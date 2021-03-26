package com.huiyi.campus.dao.mapper.web.home;

import com.huiyi.campus.dao.entity.home.HomeHistoryEntity;

public interface HomeHistoryMapper {
    int deleteByPrimaryKey(Integer nbxh01);

    int insert(HomeHistoryEntity record);

    int insertSelective(HomeHistoryEntity record);

    HomeHistoryEntity selectByPrimaryKey(Integer nbxh01);

    int updateByPrimaryKeySelective(HomeHistoryEntity record);

    int updateByPrimaryKey(HomeHistoryEntity record);
}