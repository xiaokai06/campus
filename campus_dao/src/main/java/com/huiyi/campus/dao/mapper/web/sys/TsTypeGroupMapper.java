package com.huiyi.campus.dao.mapper.web.sys;


import com.huiyi.campus.dao.entity.sys.TsTypeGroupEntity;
import com.huiyi.campus.dao.vo.common.TsTypeGroupVo;

import java.util.List;

public interface TsTypeGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TsTypeGroupEntity record);

    int insertSelective(TsTypeGroupEntity record);

    TsTypeGroupEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsTypeGroupEntity record);

    int updateByPrimaryKey(TsTypeGroupEntity record);

    List<TsTypeGroupEntity> selectAll();
}