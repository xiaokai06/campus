package com.huiyi.campus.web.sys.service.impl;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.common.consts.CommConstants;
import com.huiyi.campus.dao.entity.sys.SysDeskEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysDeskDao;
import com.huiyi.campus.dao.pojo.web.sys.SysDoctorDao;
import com.huiyi.campus.web.sys.service.SysDeskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-06 17:58
 * @description: 科室管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysDeskServiceImpl implements SysDeskService {

    SysDeskDao sysDeskDao;
    SysDoctorDao sysDoctorDao;

    SysDeskServiceImpl(SysDeskDao sysDeskDao, SysDoctorDao sysDoctorDao) {
        this.sysDeskDao = sysDeskDao;
        this.sysDoctorDao = sysDoctorDao;
    }

    /**
     * 查询所有科室
     * @param sysDeskEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody getAllDesk(SysDeskEntity sysDeskEntity) {
        return ResultBody.success(sysDeskDao.selectAllDesk(sysDeskEntity));
    }

    /**
     * 新增科室
     * @param sysDeskEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody insertDesk(SysDeskEntity sysDeskEntity) {
        List<SysDeskEntity> list = sysDeskDao.selectAllDesk(sysDeskEntity);
        if (!CollectionUtils.isEmpty(list)) {
            return ResultBody.error(CommConstants.DESK_REPETITION);
        }
        return ResultBody.insert(sysDeskDao.insertDesk(sysDeskEntity), sysDeskEntity.getId());
    }

    /**
     * 修改科室
     * @param sysDeskEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody updateDesk(SysDeskEntity sysDeskEntity) {
        return ResultBody.update(sysDeskDao.updateDesk(sysDeskEntity));
    }

    /**
     * 删除科室
     * @param id 参数
     * @return 返回值
     */
    @Override
    public ResultBody deleteDesk(Integer id) {
        int i = sysDeskDao.deleteDesk(id);
        if (i > 0) {
            sysDoctorDao.deleteDoctorByDeskId(id);
        }
        return ResultBody.delete(i);
    }
}
