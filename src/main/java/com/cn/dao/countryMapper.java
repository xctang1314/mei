package com.cn.dao;

import com.cn.model.country;

public interface countryMapper {
    int deleteByPrimaryKey(String code);

    int insert(country record);

    int insertSelective(country record);

    country selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(country record);

    int updateByPrimaryKey(country record);
}