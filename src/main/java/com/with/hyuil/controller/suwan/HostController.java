package com.with.hyuil.controller.suwan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HostController {

  @GetMapping("/host-book-check")
  public String businessBookCheckMain() {
    return "/host/bookCheck";
  }

}