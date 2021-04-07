package com.huiyi.campus.dao.pojo.web.common;

import com.huiyi.campus.dao.dto.common.SchoolDto;
import com.huiyi.campus.dao.entity.sys.SysSchoolEntity;
import com.huiyi.campus.dao.mapper.web.sys.SysAreasMapper;
import com.huiyi.campus.dao.mapper.web.sys.SysSchoolMapper;
import com.huiyi.campus.dao.vo.common.SysAreasVo;
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

    /**
     * 省市区三级联动查询
     * @return
     */
    public List<SysAreasVo> selectAreaList() {
        return sysAreasMapper.selectAreaList();
    }

    public List<SysSchoolEntity> selectSchoolByUserId(SchoolDto schoolDto) {
        return sysSchoolMapper.selectSchoolByUserId(schoolDto.getId());
    }

    public List<SysSchoolEntity> selectSchoolByUserIdAndOrganId(SchoolDto schoolDto) {
        return sysSchoolMapper.selectSchoolByUserIdAndOrganId(schoolDto.getId());
    }
}
