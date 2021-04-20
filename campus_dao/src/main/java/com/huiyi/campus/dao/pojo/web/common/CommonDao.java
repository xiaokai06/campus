package com.huiyi.campus.dao.pojo.web.common;

import com.huiyi.campus.dao.dto.common.SchoolDto;
import com.huiyi.campus.dao.entity.sys.*;
import com.huiyi.campus.dao.mapper.web.sys.*;
import com.huiyi.campus.dao.vo.common.SysAreasVo;
import com.huiyi.campus.dao.vo.common.TsTypeGroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-04-06 17:24
 * @Version V1.0
 */
@Repository
public class CommonDao {

    @Autowired
    SysAreasMapper sysAreasMapper;

    @Autowired
    SysSchoolMapper sysSchoolMapper;

    @Autowired
    SysGradeClassMapper sysGradeClassMapper;

    @Autowired
    TsTypeGroupMapper tsTypeGroupMapper;

    @Autowired
    TsTypeMapper tsTypeMapper;

    @Autowired
    SysOrganMapper sysOrganMapper;
    /**
     * 省市区三级联动查询
     *
     * @return
     */
    public List<SysAreasVo> selectAreaList() {
        return sysAreasMapper.selectAreaList();
    }

    /**
     * 根据用户ID查询学校
     *
     * @param schoolDto
     * @return
     */
    public List<SysSchoolEntity> selectSchoolByUserId(SchoolDto schoolDto) {
        return sysSchoolMapper.selectSchoolByUserId(schoolDto.getUserId());
    }

    /**
     * 根据教育局机构ID查询学校
     *
     * @param schoolDto
     * @return
     */
    public List<SysSchoolEntity> selectSchoolByUserIdAndOrganId(SchoolDto schoolDto) {
        return sysSchoolMapper.selectSchoolByUserIdAndOrganId(schoolDto.getUserId());
    }

    /**
     * 根据学校ID查询专业班级
     * @param schoolDto
     * @return
     */
    public List<SysGradeClassEntity> selectClassBySchoolId(SchoolDto schoolDto) {
        return sysGradeClassMapper.selectClassBySchoolId(schoolDto.getSchoolId());
    }

    public List<TsTypeGroupEntity> selectTypeGroup() {
        return tsTypeGroupMapper.selectAll();
    }

    public List<TsTypeEntity> selectType(Integer id) {
        return tsTypeMapper.selectByPrimaryKeyList(id);
    }

    /**
     * 根据教育机构ID查询当前教育局机构信息
     * @param schoolDto
     * @return
     */
    public List<SysOrganEntity> selectOrganByUserId(SchoolDto schoolDto) {
        List<SysOrganEntity> organEntityList =sysOrganMapper.selectOrganByUserId(schoolDto.getOrganId());
        if (organEntityList.isEmpty()){
            organEntityList = sysOrganMapper.selectByOrganId(schoolDto.getOrganId());
        }
        return organEntityList;
    }
}
