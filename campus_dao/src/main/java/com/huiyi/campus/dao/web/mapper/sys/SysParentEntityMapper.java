package com.huiyi.campus.dao.web.mapper.sys;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huiyi.campus.dao.entity.sys.SysParentEntity;
import org.mapstruct.Mapper;

@Mapper
public interface SysParentEntityMapper extends BaseMapper<SysParentEntity> {
    int deleteByPrimaryKey(Integer id);

    int insert(SysParentEntity record);

    int insertSelective(SysParentEntity record);

    SysParentEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysParentEntity record);

    int updateByPrimaryKey(SysParentEntity record);
}