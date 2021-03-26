package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.ProjectRefEntity;

public interface ProjectRefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectRefEntity record);

    int insertSelective(ProjectRefEntity record);

    ProjectRefEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectRefEntity record);

    int updateByPrimaryKey(ProjectRefEntity record);
}