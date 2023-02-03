package com.with.hyuil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class ViewTestController {

    @ResponseBody
    @GetMapping("/hosts/aaa")
    public String test1() {
        return "GOOD";
    }
}
