package com.mytest.springboot_mybatis_mysql.controller;

import com.mytest.springboot_mybatis_mysql.service.CittyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citty")
public class CittyController {
    @Autowired
    CittyService cittyService;

    @GetMapping("/findAll")
    public List findAll(@RequestParam(required = false) Integer pageNum, @RequestParam(required = false)Integer pageSize){
        System.out.println("pageNum==>"+pageNum+";pageSize==>"+pageSize);
        return cittyService.findAll(pageNum,pageSize);
    }

    /**
     * @PathVariable: 路径变量：/addByNmae/{name} 中的name
     * @RequestParam: Request域的参数 uri 问号后面的 required = false 可以不传参数
     * @param name
     * @return
     */
    @GetMapping("/addByName/{name}")
    public String addByName(@PathVariable("name") String name){
        System.out.println("name==>"+name);
        return cittyService.addByName(name);
    }


    @GetMapping("/selectByName/{name}")
    public List selectByName(@PathVariable("name") String name,@RequestParam(required = false) Integer pageNum, @RequestParam(required = false)Integer pageSize){
        System.out.println("name==>"+name);
        return cittyService.selectByName(name,pageNum,pageSize);
    }

}
