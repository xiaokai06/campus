package com.huiyi.campus.web.sys.service.impl;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysOrganEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysOrganDao;
import com.huiyi.campus.web.sys.service.SysOrganService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-06 14:02
 * @description: 机构管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysOrganServiceImpl implements SysOrganService {

    SysOrganDao sysOrganDao;

    SysOrganServiceImpl(SysOrganDao sysOrganDao) {
        this.sysOrganDao = sysOrganDao;
    }

    /**
     * 查询所有机构
     * @param sysOrganEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody selectAllOrgan(SysOrganEntity sysOrganEntity) {
        return ResultBody.success(sysOrganDao.selectAllOrgan(sysOrganEntity));
    }

    /**
     * 新增机构
     * @param sysOrganEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody insertOrganInfo(SysOrganEntity sysOrganEntity) {
        List<SysOrganEntity> list = sysOrganDao.selectAllOrgan(sysOrganEntity);
        if (!CollectionUtils.isEmpty(list)) {
            return ResultBody.error("该机构名称已存在，请重新输入！");
        }
        return ResultBody.insert(sysOrganDao.insertOrganInfo(sysOrganEntity), sysOrganEntity.getId());
    }

    /**
     * 修改机构
     * @param sysOrganEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody updateOrganInfo(SysOrganEntity sysOrganEntity) {
        List<SysOrganEntity> list = sysOrganDao.selectAllOrgan(sysOrganEntity);
        if (!CollectionUtils.isEmpty(list)) {
            return ResultBody.error("该机构名称已存在，请重新输入！");
        }
        return ResultBody.update(sysOrganDao.updateOrganInfo(sysOrganEntity));
    }

    /**
     * 删除机构
     * @param id 参数
     * @return 返回值
     */
    @Override
    public ResultBody deleteOrganInfo(Integer id) {
        return ResultBody.delete(sysOrganDao.deleteOrganInfo(id));
    }
}
