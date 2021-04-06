package com.huiyi.campus.web.sys.service;

import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.entity.sys.SysDeskEntity;

/**
 * @author: yzg
 * @time: 2021-04-06 17:58
 * @description: 科室管理
 */
public interface SysDeskService {

    /**
     * 查询所有科室
     * @param sysDeskEntity
     * @return
     */
    ResultBody getAllDesk(SysDeskEntity sysDeskEntity);

    /**
     * 新增科室
     * @param sysDeskEntity
     * @return
     */
    ResultBody insertDesk(SysDeskEntity sysDeskEntity);

    /**
     * 修改科室
     * @param sysDeskEntity
     * @return
     */
    ResultBody updateDesk(SysDeskEntity sysDeskEntity);

    /**
     * 删除科室
     * @param id
     * @return
     */
    ResultBody deleteDesk(Integer id);

}
