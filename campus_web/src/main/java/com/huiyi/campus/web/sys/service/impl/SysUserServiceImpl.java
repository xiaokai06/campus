package com.huiyi.campus.web.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiyi.campus.common.base.CommonEnum;
import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.common.consts.CommConstants;
import com.huiyi.campus.common.utils.*;
import com.huiyi.campus.dao.dto.sys.UpdatePwdDto;
import com.huiyi.campus.dao.entity.sys.SysMenuEntity;
import com.huiyi.campus.dao.entity.sys.SysOrganEntity;
import com.huiyi.campus.dao.entity.sys.SysUserEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysOrganDao;
import com.huiyi.campus.dao.pojo.web.sys.SysRoleMenuDao;
import com.huiyi.campus.dao.pojo.web.sys.SysSchoolDao;
import com.huiyi.campus.dao.pojo.web.sys.SysUserDao;
import com.huiyi.campus.dao.vo.sys.SysUserVo;
import com.huiyi.campus.dao.vo.sys.TokenVo;
import com.huiyi.campus.web.sys.service.SysUserService;
import com.huiyi.campus.web.sys.service.UserCacheService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    JwtUtils jwtUtils;
    SysUserDao sysUserDao;
    SysOrganDao sysOrganDao;
    SysSchoolDao sysSchoolDao;
    SysRoleMenuDao sysRoleMenuDao;
    @Value("${user.defaultPwd}")
    private String defaultPwd;
    @Value("${user.administrator}")
    private String administrator;
    UserCacheService userCacheService;

    SysUserServiceImpl(SysUserDao sysUserDao, RSAUtils rsaUtils, JwtUtils jwtUtils,
                       AESUtils aesUtils, SysRoleMenuDao sysRoleMenuDao,SysOrganDao sysOrganDao,
                       SysSchoolDao sysSchoolDao, UserCacheService userCacheService) {
        this.rsaUtils = rsaUtils;
        this.aesUtils = aesUtils;
        this.jwtUtils = jwtUtils;
        this.sysUserDao = sysUserDao;
        this.sysOrganDao = sysOrganDao;
        this.sysSchoolDao = sysSchoolDao;
        this.sysRoleMenuDao = sysRoleMenuDao;
        this.userCacheService = userCacheService;
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
        Integer id = sysUserInfo.getId();
        String passWord = sysUserInfo.getPassWord();
        logger.info("前端传递的数据，用户昵称：" + nickName + ", 密码为：" + pwd);
        if (!StringUtils.isEmpty(passWord) && !StringUtils.isEmpty(pwd)) {
            // 对前端传递过来的密码和数据库中的密码，先进行RSA解密，再进行AES解密
            String decAes = decryptResult(pwd, "前端");
            String decAesM = decryptResult(passWord, "数据库");
            if (decAes.equals(decAesM)) {
                TokenVo tokenVo = new TokenVo();
                tokenVo.setId(id);
                tokenVo.setNickName(sysUserInfo.getNickName());
                tokenVo.setUserName(sysUserInfo.getUserName());
                tokenVo.setEmail(sysUserInfo.getEmail());
                tokenVo.setPhone(sysUserInfo.getPhone());
                tokenVo.setSex(sysUserInfo.getSex());
                tokenVo.setSchoolId(sysUserInfo.getSchoolId());
                tokenVo.setOrganId(sysUserInfo.getOrganId());
                tokenVo.setRoleId(sysUserInfo.getRoleId());
                tokenVo.setRoleName(sysUserInfo.getRoleName());
                tokenVo.setEducationFlag(0); // 默认为非教育局负责人
                String roleName = sysUserInfo.getRoleName();
                if (!StringUtils.isEmpty(roleName) && roleName.contains(CommConstants.EDUCATION_LEADER)){
                    tokenVo.setEducationFlag(1);
                }
                if (userCacheService.hasUserKey(nickName)) {
                    TokenVo cacheToken = userCacheService.getUserCache(nickName);
                    String token = cacheToken.getToken();
                    logger.info("从缓存中获取到的token为：" + token);
                    tokenVo.setToken(token);
                } else {
                    String token = jwtUtils.sign(nickName);
                    logger.info("后端生成的token为：" + token);
                    String aesToken = aesUtils.encrypt(token);
                    logger.info("AES加密后的token为：" + aesToken);
                    tokenVo.setToken(aesToken);
                    userCacheService.setUserCache(nickName, tokenVo);
                }
                SysUserEntity sysUser = new SysUserEntity();
                sysUser.setId(sysUserInfo.getId());
                sysUser.setLastVisit(DateUtils.getTime());
                sysUserDao.updateUserInfoById(sysUser);
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
        if (userCacheService.hasUserKey(nickName)) {
            userCacheService.delUserCache(nickName);
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
            String decAes = decryptResult(pwd, "修改密码-旧密码");
            String decAesM = decryptResult(passWord, "修改密码-数据库密码");
            if (!decAes.equals(decAesM)) {
                return ResultBody.error(CommonEnum.USER_PWD_ERROR.getResultMsg());
            }
            String newPwd = updatePwdDto.getNewPwd();
            String newAes = decryptResult(newPwd, "修改密码-新密码");
            logger.info("（修改密码-新密码）前端传递过来的新密码为：" + newPwd);
            String confirmPwd = updatePwdDto.getConfirmPwd();
            String confirmAes = decryptResult(confirmPwd, "修改密码-确认密码");
            logger.info("（修改密码-确认密码）前端传递过来的确认密码为：" + confirmPwd);
            if (!newAes.equals(confirmAes)) {
                return ResultBody.error("新密码和确认密码输入不一致，请重新输入....");
            }
            int i = sysUserDao.updateUserPwd(updatePwdDto);
            if (i > 0) {
                if (userCacheService.hasUserKey(nickName)) {
                    userCacheService.delUserCache(nickName);
                }
            }
            return ResultBody.update(i);
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
        List<SysMenuEntity> list;
        if (administrator.equals(nickName)) {
            list = sysRoleMenuDao.selectMenuByUserId(null);
        } else {
            SysUserEntity sysUserEntity = sysUserDao.selectUserByNickName(nickName);
            Integer userId = sysUserEntity.getId();
            list = sysRoleMenuDao.selectMenuByUserId(userId);
        }
        if (null == list) {
            return ResultBody.error(CommConstants.NOT_SECURITY);
        }
        Map<Integer, List<SysMenuEntity>> map = list.stream().collect(Collectors.groupingBy(SysMenuEntity::getParentId));
        for (Integer parentId : map.keySet()) {
            List<SysMenuEntity> result = map.get(parentId);
            if (!CollectionUtils.isEmpty(result)) {
                for (SysMenuEntity firstMenu : result) {
                    List<SysMenuEntity> resultList = map.get(firstMenu.getId());
                    if (!CollectionUtils.isEmpty(resultList)) {
                        for (SysMenuEntity secondMenu : resultList) {
                            List<SysMenuEntity> menuList = map.get(secondMenu.getId());
                            if (!CollectionUtils.isEmpty(menuList)) {
                                secondMenu.setList(menuList);
                            } else {
                                firstMenu.setList(resultList);
                            }
                        }
                    }
                }
            }
            return ResultBody.success(result);
        }
        return ResultBody.success();
    }

    /**
     * 获取所有用户信息
     * @param sysUserEntity 参数
     * @return 返回值
     */
    @Override
    public CrRpcResult getAllUserInfo(String nickName, SysUserEntity sysUserEntity) {
        if (userCacheService.hasUserKey(nickName)) {
            TokenVo tokenVo = userCacheService.getUserCache(nickName);
            Integer schoolId = tokenVo.getSchoolId();
            Integer organId = tokenVo.getOrganId();
            List<SysOrganEntity> organList = sysOrganDao.selectIdByOrganId(organId);
            List<Integer> organIds = organList.stream().map(SysOrganEntity::getId).collect(Collectors.toList());
            List<Integer> schoolList = sysSchoolDao.selectIdByOrganId(organIds, schoolId);
            PageHelper.startPage(sysUserEntity.getPageNum(), sysUserEntity.getPageSize());
            List<SysUserVo> list = sysUserDao.selectAllUserInfo(sysUserEntity, organIds, schoolList);
            PageInfo<SysUserVo> pageInfo = new PageInfo<>(list);
            return CrRpcResult.success(pageInfo);
        }
        return CrRpcResult.success(new PageInfo());
    }

    /**
     * 新增用户
     * @param sysUserEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody insertUserInfo(SysUserEntity sysUserEntity) {
        if (1 == sysUserEntity.getRoleId()) {
            return ResultBody.error(CommConstants.NOT_CREATE);
        }
        SysUserEntity sysUser = sysUserDao.selectUserInfo(sysUserEntity.getNickName());
        if (null != sysUser) {
            return ResultBody.repetition();
        }
        sysUserEntity.setPassWord(encryptResult("新增用户"));
        return ResultBody.insert(sysUserDao.insertUserInfo(sysUserEntity), sysUserEntity.getId());
    }

    /**
     * 修改用户
     * @param sysUserEntity 参数
     * @return 返回值
     */
    @Override
    public ResultBody updateUserInfo(SysUserEntity sysUserEntity) {
        if (1 == sysUserEntity.getRoleId()) {
            return ResultBody.error(CommConstants.NOT_EDIT);
        }
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

    /**
     * 重置密码
     * @param updatePwdDto 参数
     * @return 返回值
     */
    @Override
    public ResultBody resetPwd(UpdatePwdDto updatePwdDto) {
        if (administrator.equals(updatePwdDto.getNickName())) {
            return ResultBody.error(CommConstants.NOT_RESET);
        }
        updatePwdDto.setNewPwd(encryptResult("重置密码"));
        return ResultBody.success(sysUserDao.updateUserPwd(updatePwdDto));
    }

    /**
     * 加密最终得到的字符串
     * @param type 功能模块
     * @return 返回值
     */
    private String encryptResult(String type) {
        // TODO:新增用户和重置密码都默认123456
        String first = aesUtils.encrypt(defaultPwd);
        logger.info("（"+ type +"）第一次AES加密--后端--得到的字符串为：" + first);
        String second = rsaUtils.encrypt(first);
        logger.info("（"+ type +"）第二次RSA加密--后端--得到的字符串为：" + second);
        return second;
    }

    /**
     * 解密最终得到的字符串
     * @param decrypt 需要解密的字符串
     * @param type 功能模块
     * @return 返回值
     */
    private String decryptResult(String decrypt, String type) {
        String first = rsaUtils.decrypt(decrypt);
        logger.info("（"+ type +"）第一次RSA解密--前端--得到的字符串为：" + first);
        String second = aesUtils.decrypt(first);
        logger.info("（"+ type +"）第二次AES解密--前端--得到的字符串为：" + second);
        return second;
    }

}
