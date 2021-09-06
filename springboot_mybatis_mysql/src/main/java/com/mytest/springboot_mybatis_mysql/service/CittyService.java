package com.mytest.springboot_mybatis_mysql.service;

import java.util.List;

public interface CittyService {
    List findAll(Integer pageNum, Integer pageSize);

    String addByName(String name);

    List selectByName(String name, Integer pageNum, Integer pageSize);
}
