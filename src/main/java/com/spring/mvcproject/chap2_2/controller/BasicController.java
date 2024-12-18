package com.spring.mvcproject.chap2_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {

    // GET요청
//    @RequestMapping(value = "/chap2-2/hello", method = RequestMethod.GET)
    @GetMapping("/chap2-2/hello")
    @ResponseBody // 데이터를 클라이언트에 응답
    public String hello() {
        System.out.println("GET요청이 들어옴!!");
        return "hello spring~";
    }

    // JSP 응답
    @GetMapping("/chap2-2/getjsp")
//    @ResponseBody   // JSP응답이 아닌 JSON응답으로 바뀜
    public String getJsp() {
        return "hello"; // JSP파일 포워딩
    }


}
