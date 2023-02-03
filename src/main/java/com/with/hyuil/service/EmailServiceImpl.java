package com.with.hyuil.service;

import com.with.hyuil.service.interfaces.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private MimeMessage message;
    private String randomCode;
    @Value("${spring.mail.username}")
    private String fromEmail;


    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public MimeMessage joinMailForm(String title, String toEmail) {
        createCode();
        try {
            message = javaMailSender.createMimeMessage();
            message.addRecipients(Message.RecipientType.TO, toEmail);
            message.setSubject(title);
            message.setFrom(fromEmail);
            message.setText(contextJoin(title, randomCode), "UTF-8", "html");
        } catch (MessagingException e) {
            log.error("이메일 전송 오류 = {}", e);
        }
        return message;
    }

    @Override
    public MimeMessage passwordMainForm(String toEmail) {
        return null;
    }

    @Override
    public MimeMessage idMainForm(String toEmail, String userId) {
        return null;
    }

    @Override
    public String passwordMailSend(String toEmail) {
        return null;
    }

    @Override
    public String codeMailSend(String title, String toEmail) {
        message = joinMailForm(title, toEmail);
        javaMailSender.send(message);
        return randomCode;
    }

    @Override
    public String idMailSend(String toEmail, String id) {
        return null;
    }

    @Override
    public String contextJoin(String title, String code) {
        return  "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "  <h3>"+title+"</h3>\n" +
                "  <p>아래 코드를 복사하세요</p>\n" +
                "  <h1>"+code+"</h1>\n" +
                "</body>\n" +
                "</html>";
    }

    @Override
    public String contextPwd(String code) {
        return null;
    }

    @Override
    public String contextId(String id) {
        return null;
    }

    @Override
    public void createCode() {
        int min = 1000;
        int max = 9999;
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        int code = random.nextInt(max-min)+min;

        randomCode = buffer.append(code).toString();
    }

    @Override
    public void createPassword() {

    }
}
