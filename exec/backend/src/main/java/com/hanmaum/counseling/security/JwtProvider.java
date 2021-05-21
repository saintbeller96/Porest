package com.hanmaum.counseling.security;

import com.hanmaum.counseling.domain.account.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.*;

@Component
@Log
public class JwtProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generateToken(User user){
        Date ExpireDate = Date.from(Instant.now().plusSeconds(7200));

        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS512");

        Map<String, Object> payloads = new HashMap<>();
        payloads.put("email",user.getEmail());
        payloads.put("id", user.getId());
        payloads.put("nickname", user.getNickname());
//        payloads.put("profile_img", user.getProfileImg());
        payloads.put("temperature", user.getTemperature());
        payloads.put("profile_img_number", user.getProfileImgNumber());

        return Jwts.builder()
                .setHeader(headers)
                .setSubject(user.getEmail())
                .setClaims(payloads)
                .setExpiration(ExpireDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }
        catch (Exception e){
            log.severe("invalid token");
        }
        return false;
    }

    public String getEmailFromToken(String token){
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.get("email", String.class);
    }
    public Map<String, Object> getUserInfoFromToken(String token){
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        log.info(""+claims);

        return claims;
    }
}
