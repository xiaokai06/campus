package com.huiyi.campus.dao.mapper.web.home;

import com.huiyi.campus.dao.entity.home.HomeMemberEntity;

public interface HomeMemberMapper {
    int deleteByPrimaryKey(String nbxh01);

    int insert(HomeMemberEntity record);

    int insertSelective(HomeMemberEntity record);

    HomeMemberEntity selectByPrimaryKey(String nbxh01);

    int updateByPrimaryKeySelective(HomeMemberEntity record);

    int updateByPrimaryKey(HomeMemberEntity record);
}