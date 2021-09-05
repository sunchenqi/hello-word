package com.sinosoft.springboot_mybatis_mysql.mapper;

import com.sinosoft.springboot_mybatis_mysql.model.Account;
import org.springframework.stereotype.Repository;

/**
 * AccountDAO继承基类
 */
@Repository
public interface AccountDAO extends MyBatisBaseDao<Account, Integer, AccountExample> {
}