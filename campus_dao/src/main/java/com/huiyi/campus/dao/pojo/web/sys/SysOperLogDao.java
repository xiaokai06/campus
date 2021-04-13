package com.huiyi.campus.dao.pojo.web.sys;

import com.huiyi.campus.dao.entity.sys.SysOperLogEntity;
import com.huiyi.campus.dao.mapper.web.sys.SysOperLogMapper;
import org.springframework.stereotype.Repository;

/**
 * @author: yzg
 * @time: 2021-04-13 13:43
 * @description: 操作日志
 */
@Repository
public class SysOperLogDao {

    SysOperLogMapper sysOperLogMapper;

    SysOperLogDao(SysOperLogMapper sysOperLogMapper) {
        this.sysOperLogMapper = sysOperLogMapper;
    }

    /**
     * 新增操作日志
     * @param sysOperLogEntity 参数
     * @return 返回值
     */
    public int insertOperLog(SysOperLogEntity sysOperLogEntity) {
        return sysOperLogMapper.insertSelective(sysOperLogEntity);
    }

}
