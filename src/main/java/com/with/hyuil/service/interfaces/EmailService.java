package com.with.hyuil.service.interfaces;

import javax.mail.internet.MimeMessage;

public interface EmailService {

    MimeMessage joinMailForm(String toEmail);
    MimeMessage passwordMainForm(String toEmail);
    MimeMessage idMainForm(String toEmail, String userId);
    String passwordMailSend(String toEmail);
    String joinMailSend(String toEmail);
    String idMailSend(String toEmail, String id);
    String contextJoin(String code);
    String contextPwd(String code);
    String contextId(String id);
    void createCode();
    void createPassword();

}
