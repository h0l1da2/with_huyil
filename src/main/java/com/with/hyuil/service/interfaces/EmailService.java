package com.with.hyuil.service.interfaces;

import javax.mail.internet.MimeMessage;

public interface EmailService {

    MimeMessage joinMailForm(String title, String toEmail);
    MimeMessage passwordMainForm(String title, String newPwd, String toEmail);
    MimeMessage idMailForm(String title, String userId, String toEmail);
    String passwordMailSend(String title, String newPwd, String toEmail);
    String codeMailSend(String title, String toEmail);
    String idMailSend(String title, String userId, String toEmail);
    String contextJoin(String title, String code);
    String contextPwd(String code);
    String contextId(String title, String id);
    void createCode();

}
