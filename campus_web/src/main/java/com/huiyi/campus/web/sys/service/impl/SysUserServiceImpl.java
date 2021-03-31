package com.huiyi.campus.web.sys.service.impl;

import com.huiyi.campus.dao.pojo.web.sys.SysUserDao;
import com.huiyi.campus.web.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: yzg
 * @time: 2021-03-30 9:59
 * @description:
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserDao sysUserDao;

    @Override
    public String selectUserInfoByNickName(String nickName) {
        return sysUserDao.selectUserByNickName(nickName);
    }
}
