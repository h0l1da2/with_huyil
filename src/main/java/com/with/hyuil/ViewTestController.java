package com.with.hyuil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {

    @GetMapping("/host")
    public String home() {
        return "host";
    }

    @GetMapping("/hotelList")
    public String hosdsme() {
        return "hotelList";
    }
    @GetMapping("/indexUser")
    public String gssd() {
        return "indexUser";
    }
    @GetMapping("/joinComplete")
    public String homve() {
        return "joinComplete";
    }
    @GetMapping("/joinEmailSend")
    public String hbome() {
        return "joinEmailSend";
    }
    @GetMapping("/loginForm")
    public String asd() {
        return "loginForm";
    }
    @GetMapping("/joinForm")
    public String homea() {
        return "joinForm";
    }
}
