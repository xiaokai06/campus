package com.huiyi.campus.web.sys.service.impl;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysOrganEntity;
import com.huiyi.campus.dao.entity.sys.SysSchoolEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysOrganDao;
import com.huiyi.campus.dao.pojo.web.sys.SysSchoolDao;
import com.huiyi.campus.dao.pojo.web.sys.SysSchoolDoctorDao;
import com.huiyi.campus.dao.pojo.web.sys.SysUserDao;
import com.huiyi.campus.dao.vo.sys.TokenVo;
import com.huiyi.campus.web.sys.service.SysSchoolService;
import com.huiyi.campus.web.sys.service.UserCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: yzg
 * @time: 2021-04-06 14:01
 * @description: 学校管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysSchoolServiceImpl implements SysSchoolService {

    private static final Logger logger = LoggerFactory.getLogger(SysSchoolServiceImpl.class);

    SysUserDao sysUserDao;
    SysOrganDao sysOrganDao;
    SysSchoolDao sysSchoolDao;
    UserCacheService userCacheService;
    SysSchoolDoctorDao sysSchoolDoctorDao;

    SysSchoolServiceImpl(SysSchoolDao sysSchoolDao, SysSchoolDoctorDao sysSchoolDoctorDao,
                         SysOrganDao sysOrganDao, UserCacheService userCacheService, SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
        this.sysOrganDao = sysOrganDao;
        this.sysSchoolDao = sysSchoolDao;
        this.userCacheService = userCacheService;
        this.sysSchoolDoctorDao = sysSchoolDoctorDao;
    }

    /**
     * 获取所有学校
     * @param sysSchoolEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody selectAllSchool(String nickName, SysSchoolEntity sysSchoolEntity) {
        logger.info("获取所有学校接口，从请求头获取到的用户昵称为：" + nickName);
        if (userCacheService.hasUserKey(nickName)) {
            TokenVo tokenVo = userCacheService.getUserCache(nickName);
            Integer organId = tokenVo.getOrganId();
            List<SysOrganEntity> organList = sysOrganDao.selectIdByOrganId(organId);
            List<Integer> list = organList.stream().map(SysOrganEntity::getId).collect(Collectors.toList());
            return ResultBody.success(sysSchoolDao.selectAllSchool(sysSchoolEntity, list));
        }
        return ResultBody.success();
    }

    /**
     * 新增学校
     * @param sysSchoolEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody insertSchoolInfo(SysSchoolEntity sysSchoolEntity) {
        return ResultBody.insert(sysSchoolDao.insertSchoolInfo(sysSchoolEntity), sysSchoolEntity.getId());
    }

    /**
     * 修改学校
     * @param sysSchoolEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody updateSchoolInfo(SysSchoolEntity sysSchoolEntity) {
        int count = sysSchoolDao.updateSchoolInfo(sysSchoolEntity);
        if (count > 0) {
            Integer schoolId = sysSchoolEntity.getId();
            Integer organId = sysSchoolEntity.getOrganId();
            logger.info("修改学校接口，学校ID为：" + schoolId + ", 机构ID为：" + organId);
            sysUserDao.updateOrganIdBySchoolId(schoolId, organId);
        }
        return ResultBody.update(count);
    }

    /**
     * 删除学校
     * @param id 参数
     * @return 返回值
     */
    @Override
    public ResultBody deleteSchoolInfo(Integer id) {
        int i = sysSchoolDao.deleteSchoolInfo(id);
        if (i > 0) {
            sysSchoolDoctorDao.deleteDoctorBySchoolId(id);
        }
        return ResultBody.delete(i);
    }
}
