package com.sinosoft.springboot_mybatis_mysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class accountController {
    @GetMapping("/login")
    public String login(){
        return "account/login";
    }
}
