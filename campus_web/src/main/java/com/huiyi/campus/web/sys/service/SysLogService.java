package com.huiyi.campus.web.sys.service;

import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.dao.dto.sys.LogDto;

/**
 * @author: yzg
 * @time: 2021-05-11 16:03
 * @description: 日志管理
 */
public interface SysLogService {

    /**
     * 查询所有登录日志
     * @param logDto
     * @return
     */
    CrRpcResult selectLoginLog(LogDto logDto);

    /**
     * 查询所有操作日志
     * @param logDto
     * @return
     */
    CrRpcResult selectOperLog(LogDto logDto);

}
