package com.huiyi.campus.dao.pojo.web.sys;

import com.huiyi.campus.dao.mapper.web.sys.SysSchoolOrganMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-08 10:24
 * @description: 学校机构
 */
@Repository
public class SysSchoolOrganDao {

    SysSchoolOrganMapper sysSchoolOrganMapper;

    SysSchoolOrganDao(SysSchoolOrganMapper sysSchoolOrganMapper) {
        this.sysSchoolOrganMapper = sysSchoolOrganMapper;
    }

    /**
     * 通过机构ID查询旗下所有的学校
     * @param id
     * @return
     */
    public List<Integer> selectSchoolByOrganId(Integer id) {
        return sysSchoolOrganMapper.selectSchoolByOrganId(id);
    }

}
