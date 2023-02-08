package com.with.hyuil.controller.payment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OrderController<OrderInfo> {

    // 카드 결제 성공 후
    @PostMapping("/order/payment/complete")
    public ResponseEntity<String> paymentComplete(HttpSession session, OrderInfo orderInfo, long totalPrice) throws IOException {

        // 1. 아임포트 API 키와 SECRET키로 토큰을 생성

        // 2. 토큰으로 결제 완료된 주문정보를 가져옴

        // 3. 로그인하지 않았는데 사용포인트가 0 이상일경우 결제 취소

        // 4. 로그인 사용자가 현재포인트보다 사용포인트가 많을 경우 결제 취소

        // 5. DB에서 실제 계산되어야 할 가격가져오기

        // 6. 결제 완료된 금액과 실제 계산되어야 할 금액이 다를경우 결제 취소

        // 7. 결제에러시 결제 취소




        return new ResponseEntity<>(HttpStatus.OK);
    }

}
