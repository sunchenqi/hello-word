package com.sinosoft.springboot_mybatis_mysql.mapper;

import com.sinosoft.springboot_mybatis_mysql.model.Citty;
import org.springframework.stereotype.Repository;

/**
 * CittyDAO继承基类
 */
@Repository
public interface CittyDAO extends MyBatisBaseDao<Citty, Integer, CittyExample> {
}