package com.with.hyuil.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class AdminHomeController {

    private static final Logger logger = LoggerFactory.getLogger(AdminHomeController.class);

    @RequestMapping
    public String main(Model model){
        // model : 데이터를 담는 그릇 역할, Map구조로 저장
        // model.addAtribute("변수명", 값);
        model.addAttribute("msg", "관리자페이지입니다");
        return "index"; //index.jsp로 포워딩

    }

    //url mapping
    //기본, 루트페이지 => index에서 호출
    @RequestMapping(value = "index.do", method = RequestMethod.GET)
    public String index(Locale locale, Model model) {
        logger.info("Admin Page! The client locale is {}.", locale);

        Date date= new Date();
        DateFormat dateFormat= DateFormat.getDateInstance(DateFormat.LONG, locale);

        String formattedDate= dateFormat.format(date);

        //모델
        model.addAttribute("serverTime", formattedDate);

        return "management/index";
    }

}
