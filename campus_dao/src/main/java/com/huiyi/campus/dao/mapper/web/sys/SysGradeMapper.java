package com.huiyi.campus.dao.mapper.web.sys;


import com.huiyi.campus.dao.dto.sys.SysGradeClassDto;
import com.huiyi.campus.dao.entity.sys.SysGradeEntity;
import com.huiyi.campus.dao.vo.sys.SysGradeClassVo;
import com.huiyi.campus.dao.vo.sys.SysGradeVo;

import java.util.List;

public interface SysGradeMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysGradeEntity record);

    int insertSelective(SysGradeEntity record);

    SysGradeEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysGradeEntity record);

    int updateByPrimaryKey(SysGradeEntity record);

    List<SysGradeClassVo> selectGradeList(SysGradeEntity sysGradeEntity);

    List<SysGradeVo> queryGradeClass(SysGradeEntity sysGradeEntity);

    List<SysGradeVo> selectGrdeAndClass(SysGradeClassDto sysGradeClassDto);
}