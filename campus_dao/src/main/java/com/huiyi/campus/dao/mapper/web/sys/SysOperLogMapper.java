package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysOperLogEntity;

public interface SysOperLogMapper {

    /**
     * 新增操作日志
     * @param sysOperLogEntity 参数
     * @return 返回值
     */
    int insertSelective(SysOperLogEntity sysOperLogEntity);
}