package com.exam.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {

    @GetMapping("/")
    @ResponseBody
    public String main(){
//        깃허브 연동 테스트
        return "Hello World111";
    }
}