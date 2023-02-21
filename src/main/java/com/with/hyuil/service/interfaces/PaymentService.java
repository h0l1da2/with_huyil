package com.with.hyuil.service.interfaces;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface PaymentService {

    public String getToken() throws IOException;
    public String paymentInfo(String imp_uid, String access_token) throws IOException, ParseException;
    public void payMentCancle(String access_token, String imp_uid, String amount, String reason) throws IOException, ParseException;
}


