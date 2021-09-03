package com.sinosoft.springboot_mybatis_mysql.service.impl;

import com.github.pagehelper.PageHelper;
import com.sinosoft.springboot_mybatis_mysql.mapper.CittyDAO;
import com.sinosoft.springboot_mybatis_mysql.model.Citty;
import com.sinosoft.springboot_mybatis_mysql.mapper.CittyExample;
import com.sinosoft.springboot_mybatis_mysql.service.CittyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CittyServiceImpl implements CittyService {
    @Autowired
    CittyDAO cittyDAO;
    @Override
    public List findAll(Integer pageNum, Integer pageSize) {
        if((null != pageNum && pageNum != 0) && (null!=pageSize && pageSize != 0)){
            PageHelper.startPage(pageNum,pageSize);
        }
        return cittyDAO.selectByExample(new CittyExample());
    }

    @Override
    public String addByName(String name) {
        Citty citty = new Citty();
        citty.setName(name);
        int insert = cittyDAO.insert(citty);
        return insert +"";
    }

    @Override
    public List selectByName(String name, Integer pageNum, Integer pageSize) {
        if((null != pageNum && pageNum != 0) && (null!=pageSize && pageSize != 0)){
            PageHelper.startPage(pageNum,pageSize);
        }
        CittyExample example = new CittyExample();
        example.createCriteria().andNameEqualTo(name);
        return cittyDAO.selectByExample(example);
    }
}
