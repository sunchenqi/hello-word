package com.mytest.springboot_mybatis_mysql.service;

import com.mytest.springboot_mybatis_mysql.model.Account;

import java.util.List;

public interface AccountService {
    Account findBylonginNameAndPassword(String loginName, String password);

    List<Account> findAll(Integer pagenum, Integer pagesize);
}
