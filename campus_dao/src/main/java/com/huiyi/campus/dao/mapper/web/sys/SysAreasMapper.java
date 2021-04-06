package com.huiyi.campus.dao.mapper.web.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huiyi.campus.dao.entity.sys.SysAreasEntity;
import org.mapstruct.Mapper;

@Mapper
public interface SysAreasMapper extends BaseMapper<SysAreasEntity> {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAreasEntity record);

    int insertSelective(SysAreasEntity record);

    SysAreasEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAreasEntity record);

    int updateByPrimaryKey(SysAreasEntity record);
}