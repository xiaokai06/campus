package com.huiyi.campus.web.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.huiyi.campus.common.base.CommonEnum;
import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.common.consts.CommConstants;
import com.huiyi.campus.common.utils.*;
import com.huiyi.campus.dao.dto.sys.UpdatePwdDto;
import com.huiyi.campus.dao.entity.sys.SysMenuEntity;
import com.huiyi.campus.dao.entity.sys.SysUserEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysRoleMenuDao;
import com.huiyi.campus.dao.pojo.web.sys.SysUserDao;
import com.huiyi.campus.dao.vo.sys.TokenVo;
import com.huiyi.campus.web.sys.service.SysUserService;
import com.huiyi.campus.web.sys.service.TokenService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-03-30 9:59
 * @description: 用户管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserService {

    private static final Log logger = LogFactory.getLog(SysUserServiceImpl.class);

    RSAUtils rsaUtils;
    AESUtils aesUtils;
    RedisUtils redisUtils;
    SysUserDao sysUserDao;
    TokenService tokenService;
    SysRoleMenuDao sysRoleMenuDao;

    SysUserServiceImpl(SysUserDao sysUserDao, RSAUtils rsaUtils, TokenService tokenService,
                       AESUtils aesUtils, RedisUtils redisUtils, SysRoleMenuDao sysRoleMenuDao) {
        this.rsaUtils = rsaUtils;
        this.aesUtils = aesUtils;
        this.redisUtils = redisUtils;
        this.sysUserDao = sysUserDao;
        this.tokenService = tokenService;
        this.sysRoleMenuDao = sysRoleMenuDao;
    }

    /**
     * 通过用户昵称查询用户信息
     * @param sysUserEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody selectUserInfoByNickName(SysUserEntity sysUserEntity) {
        String pwd = sysUserEntity.getPassWord();
        String nickName = sysUserEntity.getNickName();
        SysUserEntity sysUserInfo = sysUserDao.selectUserByNickName(nickName);
        if (null == sysUserInfo) {
            return ResultBody.error(CommonEnum.NO_EXIST.getResultMsg());
        }
        String passWord = sysUserInfo.getPassWord();
        logger.info("前端传递的数据，用户昵称：" + nickName + ", 密码为：" + pwd);
        if (!StringUtils.isEmpty(passWord) && !StringUtils.isEmpty(pwd)) {
            // 对前端传递过来的密码和数据库中的密码，先进行RSA解密，再进行AES解密
            String decRsa = rsaUtils.decrypt(pwd);
            logger.info("前端第一次RSA解密得到的字符串为：" + decRsa);
            String decAes = aesUtils.decrypt(decRsa);
            logger.info("前端第二次AES解密得到的字符串为：" + decAes);
            String decRsaM = rsaUtils.decrypt(passWord);
            logger.info("数据库第一次RSA解密得到的字符串为：" + decRsaM);
            String decAesM = aesUtils.decrypt(decRsaM);
            logger.info("数据库第二次AES解密得到的字符串为：" + decAesM);
            if (decAes.equals(decAesM)) {
                TokenVo tokenVo = new TokenVo();
                String key = CommConstants.USER_INFO + nickName;
                if (redisUtils.hasKey(key)) {
                    String str = JSON.toJSONString(redisUtils.get(key));
                    TokenVo tokenVo1 = JSON.parseObject(str, TokenVo.class);
                    String token = tokenVo1.getToken();
                    logger.info("从缓存中获取到的token为：" + token);
                    tokenVo.setToken(token);
                } else {
                    String token = tokenService.getToken(nickName);
                    logger.info("后端生成的token为：" + token);
                    String aesToken = aesUtils.encrypt(token);
                    logger.info("AES加密后的token为：" + aesToken);
                    tokenVo.setToken(aesToken);
                    redisUtils.set(key, tokenVo, CommConstants.EXPIRE_TIME);
                }
                SysUserEntity sysUser = new SysUserEntity();
                sysUser.setId(sysUserInfo.getId());
                sysUser.setLastVisit(DateUtils.getTime());
                sysUserDao.updateUserInfo(sysUser);
                return ResultBody.success(tokenVo);
            } else {
                return ResultBody.error("用户名或密码输入错误，请重新输入....");
            }
        }
        return ResultBody.error("登录失败！");
    }

    /**
     * 退出系统
     * @param nickName 参数
     * @return 返回值
     */
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

    /**
     * 修改密码
     * @param updatePwdDto 参数
     * @return 返回值
     */
    @Override
    public ResultBody updatePwdByOldPwd(UpdatePwdDto updatePwdDto) {
        String nickName = updatePwdDto.getNickName();
        SysUserEntity sysUserEntity = sysUserDao.selectUserByNickName(nickName);
        String pwd = updatePwdDto.getOldPwd();
        String passWord = sysUserEntity.getPassWord();
        if (!StringUtils.isEmpty(passWord) && !StringUtils.isEmpty(pwd)) {
            // 对前端传递过来的密码和数据库中的密码，先进行RSA解密，再进行AES解密
            String decRsa = rsaUtils.decrypt(pwd);
            logger.info("（修改密码-旧密码）前端第一次RSA解密得到的字符串为：" + decRsa);
            String decAes = aesUtils.decrypt(decRsa);
            logger.info("（修改密码-旧密码）前端第二次AES解密得到的字符串为：" + decAes);
            String decRsaM = rsaUtils.decrypt(passWord);
            logger.info("（修改密码-数据库密码）数据库第一次RSA解密得到的字符串为：" + decRsaM);
            String decAesM = aesUtils.decrypt(decRsaM);
            logger.info("（修改密码-数据库密码）数据库第二次AES解密得到的字符串为：" + decAesM);
            if (!decAes.equals(decAesM)) {
                return ResultBody.error("旧密码输入错误，请重新输入....");
            }
            String newPwd = updatePwdDto.getNewPwd();
            logger.info("（修改密码-新密码）前端传递过来的新密码为：" + newPwd);
            String confirmPwd = updatePwdDto.getConfirmPwd();
            logger.info("（修改密码-确认密码）前端传递过来的确认密码为：" + confirmPwd);
            String newRsa = rsaUtils.decrypt(newPwd);
            logger.info("（修改密码-新密码）前端第一次RSA解密得到的字符串为：" + newRsa);
            String newAes = aesUtils.decrypt(newRsa);
            logger.info("（修改密码-新密码）前端第二次AES解密得到的字符串为：" + newAes);
            String confirmRsa = rsaUtils.decrypt(confirmPwd);
            logger.info("（修改密码-确认密码）前端第一次RSA解密得到的字符串为：" + confirmRsa);
            String confirmAes = aesUtils.decrypt(confirmRsa);
            logger.info("（修改密码-确认密码）前端第二次AES解密得到的字符串为：" + confirmAes);
            if (!newAes.equals(confirmAes)) {
                return ResultBody.error("新密码和确认密码输入不一致，请重新输入....");
            }
            return ResultBody.update(sysUserDao.updateUserPwd(updatePwdDto));
        }
        return ResultBody.update(0);
    }

    /**
     * 通过用户昵称获取菜单权限
     * @param nickName 参数
     * @return 返回值
     */
    @Override
    public ResultBody getMenuByUserId(String nickName) {
        List<SysMenuEntity> menuList;
        if (CommConstants.USER_ADMIN.equals(nickName)) {
            menuList = sysRoleMenuDao.selectMenuByUserId(null);
        } else {
            SysUserEntity sysUserEntity = sysUserDao.selectUserByNickName(nickName);
            Integer userId = sysUserEntity.getId();
            menuList = sysRoleMenuDao.selectMenuByUserId(userId);
        }
        return ResultBody.success(menuList);
    }

    /**
     * 获取所有用户信息
     * @param sysUserEntity 参数
     * @return 返回值
     */
    @Override
    public CrRpcResult getAllUserInfo(SysUserEntity sysUserEntity) {
        List<SysUserEntity> list = sysUserDao.selectAllUserInfo(sysUserEntity);
        PageInfo<SysUserEntity> pageInfo = new PageInfo<>(list);
        return CrRpcResult.success(pageInfo);
    }

    /**
     * 新增用户
     * @param sysUserEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody insertUserInfo(SysUserEntity sysUserEntity) {
        // TODO:对于前端传递过来的密码加密字符串先解密后加密再存储到数据库
        String pwd = sysUserEntity.getPassWord();
        String decRsa = rsaUtils.decrypt(pwd);
        logger.info("（新增用户）前端第一次RSA解密得到的字符串为：" + decRsa);
        String decAes = aesUtils.decrypt(decRsa);
        logger.info("（新增用户）前端第二次AES解密得到的字符串为：" + decAes);
        if (!StringUtils.isEmpty(decAes)) {
            String enAes = aesUtils.encrypt(decAes);
            logger.info("（新增用户）后端第一次AES加密得到的字符串为：" + enAes);
            String enRsa = rsaUtils.encrypt(enAes);
            logger.info("（新增用户）后端第二次RSA加密得到的字符串为：" + enRsa);
            sysUserEntity.setPassWord(enRsa);
        }
        return ResultBody.insert(sysUserDao.insertUserInfo(sysUserEntity), sysUserEntity.getId());
    }

    /**
     * 修改用户
     * @param sysUserEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody updateUserInfo(SysUserEntity sysUserEntity) {
        return ResultBody.update(sysUserDao.updateUserInfo(sysUserEntity));
    }

    /**
     * 通过ID删除用户
     * @param id 参数
     * @return 返回值
     */
    @Override
    public ResultBody deleteUserInfoById(Integer id) {
        if (1 == id) {
            return ResultBody.error(CommonEnum.NO_DELETE);
        }
        return ResultBody.delete(sysUserDao.deleteUserInfoById(id));
    }

}
