package com.with.hyuil.controller.order;

import com.with.hyuil.service.PaymentServiceImpl;
import com.with.hyuil.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

    @Autowired
    private PaymentServiceImpl payment;

    @Autowired
    private OrderService orderService;

}

