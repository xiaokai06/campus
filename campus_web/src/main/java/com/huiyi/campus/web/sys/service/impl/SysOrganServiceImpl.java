package com.huiyi.campus.web.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.common.consts.CommConstants;
import com.huiyi.campus.dao.entity.sys.SysOrganEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysOrganDao;
import com.huiyi.campus.dao.pojo.web.sys.SysSchoolDao;
import com.huiyi.campus.dao.vo.sys.TokenVo;
import com.huiyi.campus.web.sys.service.SysOrganService;
import com.huiyi.campus.web.sys.service.UserCacheService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-06 14:02
 * @description: 机构管理
 */
@Service
public class SysOrganServiceImpl implements SysOrganService {

    SysOrganDao sysOrganDao;
    SysSchoolDao sysSchoolDao;
    UserCacheService userCacheService;

    SysOrganServiceImpl(SysOrganDao sysOrganDao, SysSchoolDao sysSchoolDao,
                        UserCacheService userCacheService) {
        this.sysOrganDao = sysOrganDao;
        this.sysSchoolDao = sysSchoolDao;
        this.userCacheService = userCacheService;
    }

    /**
     * 查询所有机构
     * @param sysOrganEntity 参数
     * @param nickName 用户昵称
     * @return 返回值
     */
    @Override
    public CrRpcResult selectAllOrgan(String nickName, SysOrganEntity sysOrganEntity) {
        if (userCacheService.hasUserKey(nickName)) {
            TokenVo tokenVo = userCacheService.getUserCache(nickName);
            Integer pageNum = sysOrganEntity.getPageNum();
            Integer pageSize = sysOrganEntity.getPageSize();
            if (null != pageNum && null != pageSize) {
                PageHelper.startPage(pageNum, pageSize);
            }
            List<SysOrganEntity> list = sysOrganDao.selectAllOrgan(sysOrganEntity, tokenVo.getOrganId());
            PageInfo<SysOrganEntity> pageInfo = new PageInfo<>(list);
            return CrRpcResult.success(pageInfo);
        }
        return CrRpcResult.success(new PageInfo<>());
    }

    /**
     * 新增机构
     * @param sysOrganEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody insertOrganInfo(SysOrganEntity sysOrganEntity) {
        List<SysOrganEntity> list = sysOrganDao.selectAllOrgan(sysOrganEntity, null);
        if (!CollectionUtils.isEmpty(list)) {
            return ResultBody.error(CommConstants.ORGAN_REPETITION);
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
        return ResultBody.update(sysOrganDao.updateOrganInfo(sysOrganEntity));
    }

    /**
     * 删除机构
     * @param id 机构ID
     * @return 返回值
     */
    @Override
    public ResultBody deleteOrganInfo(Integer id) {
        int i = sysOrganDao.deleteOrganInfo(id);
        if (i > 0) {
            sysSchoolDao.deleteSchoolByOrganId(id);
        }
        return ResultBody.delete(i);
    }
}
