package com.huiyi.campus.dao.mapper.web.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huiyi.campus.dao.entity.sys.SysAreasEntity;
import com.huiyi.campus.dao.vo.common.SysAreasVo;
import org.mapstruct.Mapper;

import java.util.List;

public interface SysAreasMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAreasEntity record);

    int insertSelective(SysAreasEntity record);

    SysAreasEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAreasEntity record);

    int updateByPrimaryKey(SysAreasEntity record);

    List<SysAreasVo> selectAreaList();

}