package com.huiyi.campus.web.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.huiyi.campus.common.consts.CommConstants;
import com.huiyi.campus.common.utils.RedisUtils;
import com.huiyi.campus.dao.entity.sys.SysOrganEntity;
import com.huiyi.campus.dao.entity.sys.SysSchoolEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysOrganDao;
import com.huiyi.campus.dao.pojo.web.sys.SysSchoolDao;
import com.huiyi.campus.dao.vo.sys.SchoolOrganVo;
import com.huiyi.campus.dao.vo.sys.TokenVo;
import com.huiyi.campus.web.sys.service.UserCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: yzg
 * @time: 2021-04-26 15:21
 * @description: 用户缓存实现类
 */
@Service
public class UserCacheServiceImpl implements UserCacheService {

    private static final Logger logger = LoggerFactory.getLogger(UserCacheServiceImpl.class);

    RedisUtils redisUtils;
    SysOrganDao sysOrganDao;
    SysSchoolDao sysSchoolDao;

    UserCacheServiceImpl(RedisUtils redisUtils, SysOrganDao sysOrganDao, SysSchoolDao sysSchoolDao) {
        this.redisUtils = redisUtils;
        this.sysOrganDao = sysOrganDao;
        this.sysSchoolDao = sysSchoolDao;
    }

    /**
     * 通过昵称存储用户信息至缓存
     * @param nickName
     * @param tokenVo
     */
    @Override
    public void setUserCache(String nickName, TokenVo tokenVo) {
        String key = CommConstants.USER_INFO + nickName;
        redisUtils.set(key, tokenVo, CommConstants.DEFAULT_EXPIRE_TIME);
    }

    /**
     * 通过昵称从缓存获取用户信息
     * @param nickName
     * @return
     */
    @Override
    public TokenVo getUserCache(String nickName) {
        String key = CommConstants.USER_INFO + nickName;
        String str = JSON.toJSONString(redisUtils.get(key));
        return JSON.parseObject(str, TokenVo.class);
    }

    /**
     * 通过昵称删除用户缓存
     * @param nickName
     * @return
     */
    @Override
    public void delUserCache(String nickName) {
        String key = CommConstants.USER_INFO + nickName;
        redisUtils.del(key);
    }

    /**
     * 判断缓存中是否存在改昵称
     * @param nickName
     * @return
     */
    @Override
    public boolean hasUserKey(String nickName) {
        String key = CommConstants.USER_INFO + nickName;
        return redisUtils.hasKey(key);
    }

    /**
     * 通过用户昵称获取相应的学校和机构
     * @param nickName
     * @return
     */
    @Override
    public List<SchoolOrganVo> getOrganSchool(String nickName) {
        logger.info("公共接口获取机构，从请求头获取到的用户昵称为：" + nickName);
        if (hasUserKey(nickName)) {
            List<SchoolOrganVo> result = new ArrayList<>();
            TokenVo tokenVo = getUserCache(nickName);
            Integer organId = tokenVo.getOrganId();
            List<SysOrganEntity> organList = sysOrganDao.selectIdByOrganId(organId);
            List<Integer> list = organList.stream().map(SysOrganEntity::getId).collect(Collectors.toList());
            List<SysSchoolEntity> schoolList = sysSchoolDao.selectAllSchool(new SysSchoolEntity(), list);
            Map<Integer, List<SysSchoolEntity>> schoolMap = schoolList.stream().collect(Collectors.groupingBy(SysSchoolEntity::getOrganId));
            for (SysOrganEntity sysOrganEntity : organList) {
                Integer id = sysOrganEntity.getId();
                SchoolOrganVo schoolOrganVo = new SchoolOrganVo();
                schoolOrganVo.setOrganId(id);
                schoolOrganVo.setOrganName(sysOrganEntity.getOrganName());
                schoolOrganVo.setList(schoolMap.get(id));
                result.add(schoolOrganVo);
            }
            return result;
        }
        return null;
    }

}
