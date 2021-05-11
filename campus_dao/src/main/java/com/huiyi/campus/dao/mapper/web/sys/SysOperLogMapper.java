package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.dto.sys.LogDto;
import com.huiyi.campus.dao.entity.sys.SysOperLogEntity;
import com.huiyi.campus.dao.vo.sys.SysOperLogVo;

import java.util.List;

public interface SysOperLogMapper {

    /**
     * 新增操作日志
     * @param sysOperLogEntity 参数
     * @return 返回值
     */
    int insertSelective(SysOperLogEntity sysOperLogEntity);

    /**
     * 查询操作日志
     * @param logDto
     * @return
     */
    List<SysOperLogVo> selectOperLog(LogDto logDto);
}