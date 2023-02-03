package com.with.hyuil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class ViewTestController {

<<<<<<< HEAD
<<<<<<< HEAD
=======
    @GetMapping("/")
    public String test() {

        return "index";
    }

>>>>>>> 5210103 (add : 호텔 등록 관련, 시큐리티 로그인 관련 (#16))
=======
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
    @ResponseBody
    @GetMapping("/hosts/aaa")
    public String test1() {
        return "GOOD";
    }
}
