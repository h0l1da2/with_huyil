package com.with.hyuil.controller.suwan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserBookCheckController {

  // user
  @GetMapping("/user-book-check")
  public String userBookCheckMain() {
    return "/user/bookCheck";
  }

}
