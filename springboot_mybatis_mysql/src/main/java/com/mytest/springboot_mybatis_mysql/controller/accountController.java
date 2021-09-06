package com.mytest.springboot_mybatis_mysql.controller;

import com.mytest.springboot_mybatis_mysql.model.Account;
import com.mytest.springboot_mybatis_mysql.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/account")
public class accountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/login")
    public String login(){
        return "account/login";
    }

    @RequestMapping("/list")
    public String findAll(@RequestParam(defaultValue = "1") Integer pagenum, @RequestParam(defaultValue = "5") Integer pagesize, Model model){
        List<Account> accountList =  accountService.findAll(pagenum,pagesize);
        model.addAttribute("accountList",accountList);
        return "account/list";
    }

    @RequestMapping("/validataAccount")
    @ResponseBody
    public String validataAccount(HttpServletRequest request,String loginName,String password){
        System.out.println("loginName==>"+loginName+"password===>"+password);
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
