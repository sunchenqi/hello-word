package com.mytest.springboot_mybatis_mysql.service;

import com.mytest.springboot_mybatis_mysql.model.Account;

public interface AccountService {
    Account findBylonginNameAndPassword(String loginName, String password);
}
