package com.huiyi.campus.dao.mapper.web.home;

import com.huiyi.campus.dao.entity.home.HomeRecordEntity;

public interface HomeRecordMapper {
    int deleteByPrimaryKey(Integer nbxh01);

    int insert(HomeRecordEntity record);

    int insertSelective(HomeRecordEntity record);

    HomeRecordEntity selectByPrimaryKey(Integer nbxh01);

    int updateByPrimaryKeySelective(HomeRecordEntity record);

    int updateByPrimaryKey(HomeRecordEntity record);
}