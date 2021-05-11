package com.huiyi.campus.dao.pojo.web.sys;

import com.huiyi.campus.dao.dto.sys.LogDto;
import com.huiyi.campus.dao.entity.sys.SysLoginLogEntity;
import com.huiyi.campus.dao.mapper.web.sys.SysLoginLogMapper;
import com.huiyi.campus.dao.vo.sys.SysLoginLogVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-13 13:48
 * @description: 登录日志
 */
@Repository
public class SysLoginLogDao {

    SysLoginLogMapper sysLoginLogMapper;

    SysLoginLogDao(SysLoginLogMapper sysLoginLogMapper) {
        this.sysLoginLogMapper = sysLoginLogMapper;
    }

    /**
     * 新增登录日志
     * @param sysLoginLogEntity 参数
     * @return 返回值
     */
    public void insertLoginLog(SysLoginLogEntity sysLoginLogEntity) {
        sysLoginLogMapper.insertSelective(sysLoginLogEntity);
    }

    /**
     * 查询登录日志
     * @param logDto
     * @return
     */
    public List<SysLoginLogVo> selectLoginLog(LogDto logDto) {
        return sysLoginLogMapper.selectAllLoginLog(logDto);
    }

}
