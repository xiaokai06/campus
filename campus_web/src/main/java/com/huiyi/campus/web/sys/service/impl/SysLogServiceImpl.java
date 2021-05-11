package com.huiyi.campus.web.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.dao.dto.sys.LogDto;
import com.huiyi.campus.dao.pojo.web.sys.SysLoginLogDao;
import com.huiyi.campus.dao.pojo.web.sys.SysOperLogDao;
import com.huiyi.campus.dao.vo.sys.SysLoginLogVo;
import com.huiyi.campus.dao.vo.sys.SysOperLogVo;
import com.huiyi.campus.web.sys.service.SysLogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-05-11 16:14
 * @description: 日志管理
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    SysOperLogDao sysOperLogDao;
    SysLoginLogDao sysLoginLogDao;

    SysLogServiceImpl(SysOperLogDao sysOperLogDao, SysLoginLogDao sysLoginLogDao) {
        this.sysOperLogDao = sysOperLogDao;
        this.sysLoginLogDao = sysLoginLogDao;
    }

    /**
     * 查询登录日志
     * @param logDto
     * @return
     */
    @Override
    public CrRpcResult selectLoginLog(LogDto logDto) {
        Integer pageNum = logDto.getPageNum();
        Integer pageSize = logDto.getPageSize();
        if (null != pageNum && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
        }
        List<SysLoginLogVo> list = sysLoginLogDao.selectLoginLog(logDto);
        PageInfo<SysLoginLogVo> pageInfo = new PageInfo<>(list);
        return CrRpcResult.success(pageInfo);
    }

    /**
     * 查询操作日志
     * @param logDto
     * @return
     */
    @Override
    public CrRpcResult selectOperLog(LogDto logDto) {
        Integer pageNum = logDto.getPageNum();
        Integer pageSize = logDto.getPageSize();
        if (null != pageNum && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
        }
        List<SysOperLogVo> list = sysOperLogDao.selectOperLog(logDto);
        PageInfo<SysOperLogVo> pageInfo = new PageInfo<>(list);
        return CrRpcResult.success(pageInfo);
    }
}
