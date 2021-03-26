package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysUserComment;

public interface SysUserCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserComment record);

    int insertSelective(SysUserComment record);

    SysUserComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserComment record);

    int updateByPrimaryKey(SysUserComment record);
}