package com.hanmaum.counseling.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailUtil {
    private final JavaMailSender emailSender;

    public void sendMail(String to, String sub, String text) throws MessagingException {
        //html 들어갈 변수
        String template = setTemplate(to, text, sub.contains("비밀번호") ? 1 : 2);
        try {
            MimeMessage message = emailSender.createMimeMessage();
            message.setSubject(sub);
            message.setText(template, "UTF-8", "html");
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            emailSender.send(message);
        } catch (Exception e) {
            throw new MessagingException("이메일 전송에 실패하였습니다.");
        }
    }
    private String setTemplate(String to, String text, int type){
        String PASSWORD_TEXT = "POREST의 임시 비밀번호입니다.";
        String REGISTER_TEXT = "POREST의 인증코드입니다.";
        String PASSWORD = "비밀번호 : ";
        String CODE = "인증코드 : ";
        //html 넣자.
        return "<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "안녕하세요! "+ to + "님"+
                "<br/>"+
                (type==1 ? PASSWORD_TEXT : REGISTER_TEXT)+
                "<br/>"+
                (type==1 ? PASSWORD : CODE)+
                text+
                "</body>\n" +
                "</html>\n";
    }
}
