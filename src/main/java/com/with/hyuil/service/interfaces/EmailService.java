package com.with.hyuil.service.interfaces;

import javax.mail.internet.MimeMessage;

public interface EmailService {

    MimeMessage joinMailForm(String title, String toEmail);
    MimeMessage passwordMainForm(String toEmail);
    MimeMessage idMainForm(String toEmail, String userId);
    String passwordMailSend(String toEmail);
    String codeMailSend(String title, String toEmail);
    String idMailSend(String toEmail, String id);
    String contextJoin(String title, String code);
    String contextPwd(String code);
    String contextId(String id);
    void createCode();
    void createPassword();

}
