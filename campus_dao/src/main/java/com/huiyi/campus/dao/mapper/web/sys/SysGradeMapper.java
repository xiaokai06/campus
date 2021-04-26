package com.huiyi.campus.dao.mapper.web.sys;


import com.huiyi.campus.dao.entity.sys.SysGradeEntity;
import com.huiyi.campus.dao.vo.sys.SysGradeClassVo;
import com.huiyi.campus.dao.vo.sys.SysGradeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysGradeMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysGradeEntity record);

    int insertSelective(SysGradeEntity record);

    SysGradeEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysGradeEntity record);

    int updateByPrimaryKey(SysGradeEntity record);

    List<SysGradeClassVo> selectGradeList(SysGradeEntity sysGradeEntity, @Param("schoolIdStr")List<Integer> schoolIdStr);

    List<SysGradeVo> queryGradeClass(SysGradeEntity sysGradeEntity);
}