package com.huiyi.campus.dao.pojo.web.sys;

import com.huiyi.campus.dao.entity.sys.SysOrganEntity;
import com.huiyi.campus.dao.mapper.web.sys.SysOrganMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-06 14:04
 * @description: 机构管理
 */
@Repository
public class SysOrganDao {

    SysOrganMapper sysOrganMapper;

    SysOrganDao(SysOrganMapper sysOrganMapper) {
        this.sysOrganMapper = sysOrganMapper;
    }

    /**
     * 查询所有机构
     * @param sysOrganEntity 参数
     * @return 返回值
     */
    public List<SysOrganEntity> selectAllOrgan(SysOrganEntity sysOrganEntity) {
        return sysOrganMapper.selectAllOrgan(sysOrganEntity);
    }

    /**
     * 新增机构
     * @param sysOrganEntity 参数
     * @return 返回值
     */
    public int insertOrganInfo(SysOrganEntity sysOrganEntity) {
        return sysOrganMapper.insertOrganInfo(sysOrganEntity);
    }

    /**
     * 修改机构
     * @param sysOrganEntity 参数
     * @return 返回值
     */
    public int updateOrganInfo(SysOrganEntity sysOrganEntity) {
        return sysOrganMapper.updateOrganInfo(sysOrganEntity);
    }

    /**
     * 删除机构
     * @param id 参数
     * @return 返回值
     */
    public int deleteOrganInfo(Integer id) {
        return sysOrganMapper.deleteOrganInfo(id);
    }

}
