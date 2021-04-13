package com.huiyi.campus.dao.pojo.web.sys;

import com.huiyi.campus.dao.entity.sys.SysSchoolEntity;
import com.huiyi.campus.dao.mapper.web.sys.SysSchoolMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-06 14:03
 * @description: 学校管理
 */
@Repository
public class SysSchoolDao {

    SysSchoolMapper sysSchoolMapper;

    SysSchoolDao(SysSchoolMapper sysSchoolMapper) {
        this.sysSchoolMapper = sysSchoolMapper;
    }

    /**
     * 查询学校
     * @param sysSchoolEntity
     * @return 返回值
     */
    public List<SysSchoolEntity> selectAllSchool(SysSchoolEntity sysSchoolEntity) {
        return sysSchoolMapper.selectAllSchool(sysSchoolEntity);
    }

    /**
     * 新增学校
     * @param sysSchoolEntity
     * @return 返回值
     */
    public int insertSchoolInfo(SysSchoolEntity sysSchoolEntity) {
        return sysSchoolMapper.insertSchoolInfo(sysSchoolEntity);
    }

    /**
     * 修改学校
     * @param sysSchoolEntity
     * @return 返回值
     */
    public int updateSchoolInfo(SysSchoolEntity sysSchoolEntity) {
        return sysSchoolMapper.updateSchoolInfo(sysSchoolEntity);
    }

    /**
     * 删除学校
     * @param id
     * @return 返回值
     */
    public int deleteSchoolInfo(Integer id) {
        return sysSchoolMapper.deleteSchoolInfo(id);
    }

}
