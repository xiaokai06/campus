package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.dto.sys.LogDto;
import com.huiyi.campus.dao.entity.sys.SysLoginLogEntity;
import com.huiyi.campus.dao.vo.sys.SysLoginLogVo;

import java.util.List;

public interface SysLoginLogMapper {

    /**
     * 新增登录日志
     * @param sysLoginLogEntity
     * @return
     */
    void insertSelective(SysLoginLogEntity sysLoginLogEntity);

    /**
     * 查询登录日志
     * @param logDto
     * @return
     */
    List<SysLoginLogVo> selectAllLoginLog(LogDto logDto);

}