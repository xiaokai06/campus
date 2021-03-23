package com.huiyi.campus.dao.web.mapper.sys;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huiyi.campus.dao.entity.sys.SysStudentEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysStudentEntityMapper extends BaseMapper<SysStudentEntity> {
    int deleteByPrimaryKey(Integer id);

    int insert(SysStudentEntity record);

    int insertSelective(SysStudentEntity record);

    SysStudentEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysStudentEntity record);

    int updateByPrimaryKey(SysStudentEntity record);
}