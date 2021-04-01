package com.huiyi.campus.web.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.common.consts.CommConstants;
import com.huiyi.campus.common.utils.*;
import com.huiyi.campus.dao.dto.sys.SysUserDto;
import com.huiyi.campus.dao.dto.sys.UpdatePwdDto;
import com.huiyi.campus.dao.dto.sys.UserDto;
import com.huiyi.campus.dao.entity.sys.SysUserEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysUserDao;
import com.huiyi.campus.dao.vo.sys.TokenVo;
import com.huiyi.campus.web.sys.service.SysUserService;
import com.huiyi.campus.web.sys.service.TokenService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * @author: yzg
 * @time: 2021-03-30 9:59
 * @description: 用户管理
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private static final Log logger = LogFactory.getLog(SysUserServiceImpl.class);

    SysUserDao sysUserDao;
    RSAUtils rsaUtils;
    TokenService tokenService;
    AESUtils aesUtils;
    RedisUtils redisUtils;

    SysUserServiceImpl(SysUserDao sysUserDao, RSAUtils rsaUtils, TokenService tokenService,
                       AESUtils aesUtils, RedisUtils redisUtils) {
        this.sysUserDao = sysUserDao;
        this.rsaUtils = rsaUtils;
        this.tokenService = tokenService;
        this.aesUtils = aesUtils;
        this.redisUtils = redisUtils;
    }

    @Override
    public ResultBody selectUserInfoByNickName(SysUserDto sysUserDto) {
        String pwd = sysUserDto.getPwd();
        String nickName = sysUserDto.getNickName();
        SysUserEntity sysUserEntity = sysUserDao.selectUserByNickName(nickName);
        String passWord = sysUserEntity.getPassWord();
        logger.info("前端传递的数据，用户昵称：" + nickName + ", 密码为：" + pwd);
        if (!StringUtils.isEmpty(passWord) && !StringUtils.isEmpty(pwd)) {
            // 对前端传递过来的密码和数据库中的密码，先进行RSA解密，再进行AES解密
            String decRsa = rsaUtils.decrypt(pwd);
            String decAes = aesUtils.decrypt(decRsa);
            String decRsaM = rsaUtils.decrypt(passWord);
            String decAesM = aesUtils.decrypt(decRsaM);
            if (decAes.equals(decAesM)) {
                TokenVo tokenVo = new TokenVo();
                String key = CommConstants.USER_INFO + nickName;
                if (redisUtils.hasKey(key)) {
                    tokenVo.setToken(JSON.toJSONString(redisUtils.get(key)));
                } else {
                    String token = tokenService.getToken(nickName);
                    String aesToken = aesUtils.encrypt(token);
                    tokenVo.setToken(aesToken);
                    redisUtils.set(key, aesToken, CommConstants.EXPIRE_TIME);
                }
                SysUserEntity sysUser = new SysUserEntity();
                sysUser.setId(sysUserEntity.getId());
                sysUser.setLastVisit(DateUtils.getTime());
                sysUserDao.updateUserInfo(sysUser);
                return ResultBody.success(tokenVo);
            } else {
                return ResultBody.error("用户名或密码输入错误，请重新输入....");
            }
        }
        return ResultBody.error("登录失败！");
    }

    @Override
    public ResultBody exitSystem(String nickName) {
        String key = CommConstants.USER_INFO + nickName;
        boolean bl = redisUtils.hasKey(key);
        if (bl) {
            redisUtils.del(key);
            return ResultBody.success("退出成功");
        }
        return ResultBody.error("退出失败");
    }

    @Override
    public ResultBody updatePwdByOldPwd(UpdatePwdDto updatePwdDto) {
        String nickName = updatePwdDto.getNickName();
        String pwd = updatePwdDto.getOldPwd();
        SysUserEntity sysUserEntity = sysUserDao.selectUserByNickName(nickName);
        String passWord = sysUserEntity.getPassWord();
        if (!StringUtils.isEmpty(passWord) && !StringUtils.isEmpty(pwd)) {
            // 对前端传递过来的密码和数据库中的密码，先进行RSA解密，再进行AES解密
            String decRsa = rsaUtils.decrypt(pwd);
            String decAes = aesUtils.decrypt(decRsa);
            String decRsaM = rsaUtils.decrypt(passWord);
            String decAesM = aesUtils.decrypt(decRsaM);
            if (!decAes.equals(decAesM)) {
                return ResultBody.error("旧密码输入错误，请重新输入....");
            }
            String newPwd = updatePwdDto.getNewPwd();
            String confirmPwd = updatePwdDto.getConfirmPwd();
            if (!newPwd.equals(confirmPwd)) {
                return ResultBody.error("新密码和确认密码输入不一致，请重新输入....");
            }
            return ResultBody.update(sysUserDao.updateUserPwd(updatePwdDto));
        }
        return ResultBody.update(0);
    }

    @Override
    public ResultBody getAllUserInfo(UserDto userDto) {
        return ResultBody.success(sysUserDao.selectAllUserInfo(userDto));
    }

    @Override
    public ResultBody insertUserInfo(SysUserEntity sysUserEntity) {
        // TODO:对于前端传递过来的密码加密字符串先解密后加密再存储到数据库
        String pwd = sysUserEntity.getPassWord();
        String decRsa = rsaUtils.decrypt(pwd);
        String decAes = aesUtils.decrypt(decRsa);
        if (!StringUtils.isEmpty(decAes)) {
            String enAes = aesUtils.encrypt(decAes);
            String enRsa = rsaUtils.encrypt(enAes);
            sysUserEntity.setPassWord(enRsa);
        }
        return ResultBody.insert(sysUserDao.insertUserInfo(sysUserEntity), sysUserEntity.getId());
    }

    @Override
    public ResultBody updateUserInfo(SysUserEntity sysUserEntity) {
        return ResultBody.update(sysUserDao.updateUserInfo(sysUserEntity));
    }

    @Override
    public ResultBody deleteUserInfoById(Integer id) {
        return ResultBody.delete(sysUserDao.deleteUserInfoById(id));
    }

}
