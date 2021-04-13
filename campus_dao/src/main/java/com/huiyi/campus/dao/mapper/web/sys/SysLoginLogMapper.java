package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysLoginLogEntity;

public interface SysLoginLogMapper {

    /**
     * 新增登录日志
     * @param sysLoginLogEntity
     * @return
     */
    void insertSelective(SysLoginLogEntity sysLoginLogEntity);

}