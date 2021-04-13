package com.huiyi.campus.web.sys.service.impl;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysDeskEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysDeskDao;
import com.huiyi.campus.web.sys.service.SysDeskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yzg
 * @time: 2021-04-06 17:58
 * @description: 科室管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysDeskServiceImpl implements SysDeskService {

    SysDeskDao sysDeskDao;

    SysDeskServiceImpl(SysDeskDao sysDeskDao) {
        this.sysDeskDao = sysDeskDao;
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
        return ResultBody.delete(sysDeskDao.deleteDesk(id));
    }
}
