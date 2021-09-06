package com.mytest.springboot_mybatis_mysql.controller;

import com.mytest.springboot_mybatis_mysql.model.Account;
import com.mytest.springboot_mybatis_mysql.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/account")
public class accountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/login")
    public String login(){
        return "account/login";
    }

    @RequestMapping("/validataAccount")
    @ResponseBody
    public String validataAccount(HttpServletRequest request,String loginName,String password){
        System.out.println("loginName==>"+loginName+"password"+password);
        Account account = accountService.findBylonginNameAndPassword(loginName,password);
        if(null == account){
            return "-1";
        }
        request.getSession().setAttribute("account",account);

        return "success";
    }

    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest request){
        request.getSession().removeAttribute("account");
        return "index";
    }
}
