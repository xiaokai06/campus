package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysDictEntity;

public interface SysDictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDictEntity record);

    int insertSelective(SysDictEntity record);

    SysDictEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDictEntity record);

    int updateByPrimaryKey(SysDictEntity record);
}