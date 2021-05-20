package com.hanmaum.counseling.domain.account.service;

import com.hanmaum.counseling.domain.account.dto.*;
import com.hanmaum.counseling.domain.account.entity.RoleType;
import com.hanmaum.counseling.domain.account.entity.User;
import com.hanmaum.counseling.domain.account.repository.UserRepository;
import com.hanmaum.counseling.domain.ban.entity.Ban;
import com.hanmaum.counseling.domain.ban.repository.BanRepository;
import com.hanmaum.counseling.security.JwtProvider;
import com.hanmaum.counseling.utils.EmailUtil;
import com.hanmaum.counseling.utils.RedisUtil;
import exception.UserNotFoundException;
import exception.WrongPasswordException;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Log
public class AccountService {
    static final String LOGIN_FAIL = "아이디 비밀번호 확인";
    static final String NOT_FOUND = "없는 유저";
    static final String BANNED_USER = "사용 정지된 유저";
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final BanRepository banRepository;
    private final JwtProvider jwtProvider;
    private final EmailUtil emailUtil;
    private final RedisUtil redisUtil;

    public User saveUser(@Valid SignupDto request){
        //이메일 중복 및 인증 여부 체크
        String emailCheck = redisUtil.getData(request.getEmail()+"_"+request.getCode());
        if(emailCheck == null || !emailCheck.equals("T")){
            throw new IllegalArgumentException("이메일 중복 및 인증을 진행해주세요.");
        }
        User user = User.builder()
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(passwordEncoder.encode(request.getPassword()))
                .temperature(36)
                .profileImgNumber(1L)
                .role(RoleType.ROLE_USER)
                .build();

        //케싱된 데이터 삭제
        String isEmailReady = redisUtil.getData(request.getEmail());
        if(isEmailReady != null) redisUtil.deleteData(request.getEmail());
        redisUtil.deleteData(request.getEmail()+"_"+request.getCode());

        return userRepository.save(user);
    }

    public User findByEmail(String email) throws UserNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()-> new UserNotFoundException(NOT_FOUND));
    }

    public JwtTokenDto findByEmailAndPassword(LoginDto request) throws LoginException {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new LoginException(LOGIN_FAIL));
        //해당 유저가 밴 상태인지 확인
        List<Ban> bannedList = banRepository.findByUserIdFetch(user.getId());
        for (Ban ban : bannedList) {
            //현재 밴이 진행중인지 검증
            ban.validate(LocalDateTime.now());
            //검증을 통과했으면 밴 해제
            ban.releaseBan();
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new LoginException(LOGIN_FAIL);
        }
        String token = jwtProvider.generateToken(user);
        return JwtTokenDto.builder().token(token).build();
    }

    public void updatePassword(HttpServletRequest request, UpdatePasswordDto updatePasswordDto) throws WrongPasswordException, UserNotFoundException {
        String token = request.getHeader("Authorization").substring(7);
        String email = jwtProvider.getEmailFromToken(token);
        User user = findByEmail(email);
        if (!passwordEncoder.matches(updatePasswordDto.getOldPassword(), user.getPassword())) {
             throw new WrongPasswordException("비밀번호가 틀렸습니다.");
        }
        else if(passwordEncoder.matches(updatePasswordDto.getNewPassword(), user.getPassword())){
           throw new WrongPasswordException("새로운 비밀번호가 이전 비밀번호와 같습니다.");
        }

        String newPassword = passwordEncoder.encode(updatePasswordDto.getNewPassword());
        user.setPassword(newPassword);
        userRepository.save(user);
    }


    public RedundancyDto existEmail(String email) {
        boolean redundancy = userRepository.existsByEmail(email);
        return RedundancyDto.builder().redundancy(!redundancy).build();
    }

    public ResponseEntity<?> verifyCheck(String email, String code){
        StringBuilder key = new StringBuilder().append(email).append("_").append(code);
        String verify = redisUtil.getData(key.toString());
        Map<String, Object> response = new HashMap<>();

        if(verify == null){
            response.put("message","이메일 인증 실패");
            response.put("verify", false);
        }
        else if(verify.equals("F")){
            //인증 완료 했으면 인증 만료시간을 1시간으로 변경
            redisUtil.setDataExpire(key.toString(), "T", 3600);
            response.put("message", "이메일 인증 완료");
            response.put("verify", true);
        }
        else if(verify.equals("T")){
            response.put("message", "이미 이메일 인증을 받았습니다.");
            response.put("verify", true);
        }
        return ResponseEntity.ok().body(response);
    }

    public void sendVerifyEmail(String email) throws MessagingException {
        String code = RandomStringUtils.randomAlphabetic(5);
        StringBuilder key = new StringBuilder().append(email).append("_").append(code);
        redisUtil.setDataExpire(key.toString(), "F", 180L);
        emailUtil.sendMail(email, "POREST 인증 메일 입니다." ,code);
    }

    public void deleteUser(HttpServletRequest request) throws UserNotFoundException {
        String token = request.getHeader("Authorization").substring(7);
        String email = jwtProvider.getEmailFromToken(token);
        User user = findByEmail(email);
        userRepository.delete(user);
    }

    public ResponseEntity<?> findPassword(String email, String nickname) throws MessagingException {
        boolean isExist =  userRepository.existsByEmailAndNickname(email, nickname);
        Map<String, Object> result = new HashMap<>();
        if(isExist){
            //임시 비밀번호 메일 전송
            User user = userRepository.findByEmail(email).orElseThrow(IllegalArgumentException::new);
            String temporaryPassword = RandomStringUtils.randomAlphabetic(8);
            user.setPassword(passwordEncoder.encode(temporaryPassword));
            userRepository.save(user);

            emailUtil.sendMail(email,"POREST의 임시 비밀번호 메일입니다.", temporaryPassword);
        }
        else{
            result.put("message","입력하신 정보가 올바르지 않습니다.");
        }
        return isExist ? ResponseEntity.ok().build() : ResponseEntity.badRequest().body(result);
    }

    public void updateNickname(HttpServletRequest request, UpdateNicknameDto updateNicknameDto) {
        String token = request.getHeader("Authorization").substring(7);
        String email = jwtProvider.getEmailFromToken(token);

        User user = userRepository.findByEmail(email).orElseThrow(IllegalStateException::new);
        user.setNickname(updateNicknameDto.getNickname());
        userRepository.save(user);
    }
}