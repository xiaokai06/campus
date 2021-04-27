package com.huiyi.campus.dao.pojo.web.sys;

import com.huiyi.campus.dao.entity.sys.SysGradeClassEntity;
import com.huiyi.campus.dao.entity.sys.SysGradeEntity;
import com.huiyi.campus.dao.mapper.web.sys.SysGradeClassMapper;
import com.huiyi.campus.dao.mapper.web.sys.SysGradeMapper;
import com.huiyi.campus.dao.mapper.web.sys.SysSchoolMapper;
import com.huiyi.campus.dao.vo.sys.SysGradeClassVo;
import com.huiyi.campus.dao.vo.sys.SysGradeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 班级管理
 * @date: 2021-04-21 14:31
 * @Version V1.0
 */
@Repository
public class SysGradeClassDao {

    @Autowired
    SysGradeMapper sysGradeMapper;

    @Autowired
    SysGradeClassMapper sysGradeClassMapper;

    @Autowired
    SysSchoolMapper sysSchoolMapper;

    public int insertGrade(SysGradeEntity sysGradeEntity) {
        return sysGradeMapper.insert(sysGradeEntity);
    }

    public List<SysGradeClassVo> selectGrade(SysGradeEntity sysGradeEntity) {
        return sysGradeMapper.selectGradeList(sysGradeEntity);
    }

    public int updateGrade(SysGradeEntity sysGradeEntity) {
        return sysGradeMapper.updateByPrimaryKeySelective(sysGradeEntity);
    }

    public int deleteGrade(SysGradeEntity sysGradeEntity) {
        return sysGradeMapper.deleteByPrimaryKey(sysGradeEntity.getId());
    }

    public int insertGrdeClass(SysGradeClassEntity sysGradeClassEntity) {
        return sysGradeClassMapper.insert(sysGradeClassEntity);
    }

    public List<SysGradeClassEntity> selectGrdeClass(SysGradeClassEntity sysGradeClassEntity) {
        return sysGradeClassMapper.selectGrdeClassList(sysGradeClassEntity);
    }

    public int updaterdeClass(SysGradeClassEntity sysGradeClassEntity) {
        return sysGradeClassMapper.updateByPrimaryKeySelective(sysGradeClassEntity);
    }

    public int deleteGradeClass(SysGradeClassEntity sysGradeClassEntity) {
        return sysGradeClassMapper.deleteByPrimaryKey(sysGradeClassEntity.getId());
    }

    public List<SysGradeVo> queryGradeClass(SysGradeEntity sysGradeEntity) {
        return sysGradeMapper.queryGradeClass(sysGradeEntity);
    }

    /**
     * 查询班级
     *
     * @param id
     * @return
     */
    public List<SysGradeClassEntity> selectClassByGradeList(String id) {
        return sysGradeClassMapper.selectClassByGradeList(id);
    }

}
