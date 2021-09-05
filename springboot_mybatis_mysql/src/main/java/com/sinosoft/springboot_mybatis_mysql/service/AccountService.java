package com.sinosoft.springboot_mybatis_mysql.service;

import com.sinosoft.springboot_mybatis_mysql.model.Account;

public interface AccountService {
    Account findBylonginNameAndPassword(String loginName, String password);
}
