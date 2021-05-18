package com.hanmaum.counseling.domain.post.service.counsel;

import com.hanmaum.counseling.domain.account.entity.User;
import com.hanmaum.counseling.domain.account.repository.UserRepository;
import com.hanmaum.counseling.domain.post.dto.*;
import com.hanmaum.counseling.domain.post.entity.*;
import com.hanmaum.counseling.domain.post.repository.counsel.CounselRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CounselServiceImpl implements CounselService{

    private final CounselRepository counselRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public DetailCounselDto getDetailCounsel(Long counselId, Long userId) {
        Counsel counsel = getCounsel(counselId);
        //사연자와 상담사가 아니면 이 상담 내역에 접근 불가
        if(userId != counsel.getCounsellorId() && userId != counsel.getStory().getWriterId()){
            throw new IllegalStateException("This user is not affiliated with this counsel.");
        }
        return convertToDetailCounselDto(counsel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetailCounselDto> getDetailCounsels(Long userId) {
        List<Counsel> result = counselRepository.findByUserId(userId);
        return result.stream()
                .map(this::convertToDetailCounselDto)
                .collect(Collectors.toList());
    }

    private DetailCounselDto convertToDetailCounselDto(Counsel counsel) {
        List<Letter> letters = counsel.getLetters();
        DetailCounselDto result = new DetailCounselDto(counsel.getId(), counsel.getCounsellorNickname());
        int len = letters.size();
        for(int i = 0; i+1<len; i+=2){
            Letter letter = letters.get(i);
            Letter reply = letters.get(i+1);
            result.getDetail().add(LetterReplyDto.of(letter, reply));
        }
        //현재 letters가 홀수이면 마지막 편지는 사연자의 편지
        if(len%2 == 1){
            Letter lastLetter = letters.get(len-1);
            result.getDetail().add(LetterReplyDto.builder().letter(lastLetter).build());
        }
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserCounselStateDto> getCounselStateOfUser(Long userId) {
        List<Counsel> counsels = counselRepository.findByCounsellorId(userId);
        return counsels.stream()
                .filter(counsel -> counsel.getStatus() == CounselStatus.CONNECT)
                .map(this::mappingToCounselStateDto)
                .collect(Collectors.toList());
    }

    private UserCounselStateDto mappingToCounselStateDto(Counsel counsel){
        List<Letter> letters = counsel.getLetters();
        int len = letters.size();
        Letter last = letters.get(len-1);
        int num = 0;
        //마지막 편지를 쓴 사람이 사연의 주인공이고 이 편지를 아직 읽지 않았다면 num을 증가
        for(Letter letter : letters){
            if(letter.getWriterId() == counsel.getStory().getWriterId()){
                last = letter;
                if(last.getStatus() == LetterStatus.WAIT){
                    num++;
                }
            }
        }
        return new UserCounselStateDto(counsel.getId(), counsel.getStory().getWriterNickName(), last.getTitle(), num, last.getCreatedAt());
    }

    @Override
    @Transactional
    public Long finishCounsel(EvaluateDto evaluate, Long counselId, Long userId) {
        Counsel counsel = getCounsel(counselId);
        validateUser(userId, counsel);
        User counsellor = userRepository.findById(counsel.getCounsellorId())
                .orElseThrow(IllegalStateException::new);

        counsellor.setTemperature(counsellor.getTemperature() + evaluate.getEvaluate().getScore());
        counsel.setStatus(CounselStatus.END);
        counsel.setOpenStatus(evaluate.isOpen());
        return counselId;
    }

    private Counsel getCounsel(Long counselId) {
        return counselRepository.findByCounselId(counselId)
                .orElseThrow(IllegalStateException::new);
    }

    private void validateUser(Long userId, Counsel counsel){
        if(userId != counsel.getStory().getWriterId()){
            throw new IllegalStateException("This user cannot modify this counsel.");
        }
    }
}
