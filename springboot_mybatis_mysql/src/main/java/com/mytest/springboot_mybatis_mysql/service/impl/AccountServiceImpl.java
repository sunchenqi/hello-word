package com.mytest.springboot_mybatis_mysql.service.impl;

import com.mytest.springboot_mybatis_mysql.mapper.AccountDAO;
import com.mytest.springboot_mybatis_mysql.mapper.AccountExample;
import com.mytest.springboot_mybatis_mysql.model.Account;
import com.mytest.springboot_mybatis_mysql.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDAO accountDAO;

    @Override
    public Account findBylonginNameAndPassword(String loginName, String password) {
        AccountExample example = new AccountExample();
        example.createCriteria()
                .andLoginNameEqualTo(loginName)
                .andPasswordEqualTo(password);
        List<Account> accounts = accountDAO.selectByExample(example);
        return accounts.size() == 0 ? null : accounts.get(0);
    }
}
