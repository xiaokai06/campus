package com.huiyi.campus.dao.web.mapper.sys;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huiyi.campus.dao.entity.sys.SysStudentParentEntity;
import org.mapstruct.Mapper;

@Mapper
public interface SysStudentParentEntityMapper extends BaseMapper<SysStudentParentEntity> {
    int deleteByPrimaryKey(Integer id);

    int insert(SysStudentParentEntity record);

    int insertSelective(SysStudentParentEntity record);

    SysStudentParentEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysStudentParentEntity record);

    int updateByPrimaryKey(SysStudentParentEntity record);
}