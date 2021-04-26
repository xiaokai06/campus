package com.huiyi.campus.web.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiyi.campus.common.utils.DateUtil;
import com.huiyi.campus.common.utils.JsonUtils;
import com.huiyi.campus.common.utils.idworker.Sid;
import com.huiyi.campus.common.utils.rs.HQJsonResult;
import com.huiyi.campus.common.utils.rs.SystemErrorEnum;
import com.huiyi.campus.dao.entity.sys.SysGradeClassEntity;
import com.huiyi.campus.dao.entity.sys.SysGradeEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysGradeClassDao;
import com.huiyi.campus.dao.vo.sys.SysGradeClassVo;
import com.huiyi.campus.dao.vo.sys.SysGradeVo;
import com.huiyi.campus.dao.vo.sys.TokenVo;
import com.huiyi.campus.web.common.service.CommonService;
import com.huiyi.campus.web.sys.service.SysGradeClassService;
import com.huiyi.campus.web.sys.service.UserCacheService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-04-21 14:23
 * @Version V1.0
 */
@Slf4j
@Service
public class SysGradeClassServiceImpl implements SysGradeClassService {

    @Autowired
    SysGradeClassDao sysGradeClassDao;
    @Autowired
    UserCacheService userCacheService;
    @Autowired
    CommonService commonService;

    /**
     * 根据学校id查询年级班级数据
     *
     * @param sysGradeEntity
     * @return
     */
    @Override
    public HQJsonResult queryGradeClass(SysGradeEntity sysGradeEntity) {
        if (JsonUtils.checkObjAllFieldsIsNull(sysGradeEntity)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        List<SysGradeClassVo> resultVoList = new ArrayList<>();
        List<SysGradeVo> sysGradeClassVoList = sysGradeClassDao.queryGradeClass(sysGradeEntity);
        Map<String, List<SysGradeVo>> map = sysGradeClassVoList.stream().collect(Collectors.groupingBy(SysGradeVo::getGradeParentId));
        for (String id : map.keySet()) {
            SysGradeClassVo gradeVo = new SysGradeClassVo();
            List<SysGradeClassEntity> result = new ArrayList<>();
            List<SysGradeVo> resultList = map.get(id);
            for (SysGradeVo sysGradeVo : resultList) {
                SysGradeClassEntity sysGradeClassEntity = new SysGradeClassEntity();
                sysGradeClassEntity.setId(sysGradeVo.getClassId());
                sysGradeClassEntity.setClassName(sysGradeVo.getClassName());
                sysGradeClassEntity.setGradeParentId(sysGradeVo.getGradeParentId());
                sysGradeClassEntity.setCreateUser(sysGradeVo.getClassCreateUser());
                sysGradeClassEntity.setCreateTime(sysGradeVo.getClassCreateTime());
                sysGradeClassEntity.setUpdateUser(sysGradeVo.getClassUpdateUser());
                sysGradeClassEntity.setUpdateTime(sysGradeVo.getClassUpdateTime());
                result.add(sysGradeClassEntity);
            }
            if (result.size() > 0) {
                SysGradeVo gradeEntity = resultList.get(0);
                gradeVo.setId(gradeEntity.getGradeId());
                gradeVo.setGradeName(gradeEntity.getGradeName());
                gradeVo.setSchoolId(gradeEntity.getSchoolId());
                gradeVo.setCreateUser(gradeEntity.getCreateUser());
                gradeVo.setCreateTime(gradeEntity.getCreateTime());
                gradeVo.setUpdateUser(gradeEntity.getUpdateUser());
                gradeVo.setUpdateTime(gradeEntity.getUpdateTime());
                gradeVo.setSysGradeClassEntityList(result);
                resultVoList.add(gradeVo);
            }
        }
        return HQJsonResult.success(resultVoList);
    }


    /**
     * 新增年级
     *
     * @param sysGradeEntity
     * @return
     */
    @Override
    public HQJsonResult insertGrade(SysGradeEntity sysGradeEntity) {
        if (JsonUtils.checkObjAllFieldsIsNull(sysGradeEntity)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        sysGradeEntity.setId(Sid.nextShort());
        sysGradeEntity.setCreateTime(DateUtil.getMsTime());
        int insertGrade = sysGradeClassDao.insertGrade(sysGradeEntity);
        if (insertGrade > 0) {
            return HQJsonResult.success(sysGradeEntity);
        }
        return HQJsonResult.success();
    }


    /**
     * 查询年级和班级
     *
     * @param sysGradeEntity
     * @return
     */
    @Override
    public HQJsonResult selectGrade(SysGradeEntity sysGradeEntity, String nickName) {
        if (JsonUtils.checkObjAllFieldsIsNull(sysGradeEntity)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        /**
         * 校验当前用户机构ID与学校ID
         */
        TokenVo tokenVo;
        tokenVo = userCacheService.getUserCache(nickName);
        if (JsonUtils.checkObjAllFieldsIsNull(tokenVo)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        String schoolId = String.valueOf(sysGradeEntity.getSchoolId());
        if (StringUtils.isNotEmpty(schoolId)) {
            tokenVo.setSchoolId(sysGradeEntity.getSchoolId());
        }
        List<Integer> schoolIdStr = commonService.getSchoolIdStr(tokenVo.getOrganId(), tokenVo.getSchoolId());
        log.info("获取所有查询年级和班级接口开始执行--->" + JSON.toJSON(sysGradeEntity));
        try {
            HQJsonResult<SysGradeClassVo> hqJsonResult = new HQJsonResult<>();
            PageHelper.startPage(sysGradeEntity.getPage(), sysGradeEntity.getRows());
            List<SysGradeClassVo> gradeEntityList = sysGradeClassDao.selectGrade(sysGradeEntity, schoolIdStr);
            PageInfo<SysGradeClassVo> page = new PageInfo<>(gradeEntityList);
            if (!gradeEntityList.isEmpty()) {
                gradeEntityList.forEach(str -> {
                    List<SysGradeClassEntity> classEntityList = sysGradeClassDao.selectClassByGradeList(str.getId());
                    if (!classEntityList.isEmpty()) {
                        str.setSysGradeClassEntityList(classEntityList);
                    }
                });
            }
            if (!page.getList().isEmpty()) {
                hqJsonResult.setSuccess(true);
                hqJsonResult.setCode("200");
                hqJsonResult.setMsg("处理成功！");
                hqJsonResult.setRequestID(String.valueOf(UUID.randomUUID()));
                hqJsonResult.setTotal(page.getTotal());
                hqJsonResult.setData(page.getList());
                log.info("获取所有查询年级和班级接口结束执行--->" + JSON.toJSON(hqJsonResult));
                return hqJsonResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return HQJsonResult.success();
    }

    /**
     * 修改年级
     *
     * @param sysGradeEntity
     * @return
     */
    @Override
    public HQJsonResult updateGrade(SysGradeEntity sysGradeEntity) {
        if (JsonUtils.checkObjAllFieldsIsNull(sysGradeEntity)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        log.info("修改年级接口开始执行--->" + JSON.toJSON(sysGradeEntity));
        sysGradeEntity.setUpdateTime(DateUtil.getMsTime());
        int updateGrade = sysGradeClassDao.updateGrade(sysGradeEntity);
        if (updateGrade > 0) {
            log.info("修改年级接口结束执行--->" + JSON.toJSON(sysGradeEntity));
            return HQJsonResult.success(sysGradeEntity);
        }
        return HQJsonResult.success();
    }

    /**
     * 删除年级
     *
     * @param sysGradeEntity
     * @return
     */
    @Override
    public HQJsonResult deleteGrade(SysGradeEntity sysGradeEntity) {
        if (JsonUtils.checkObjAllFieldsIsNull(sysGradeEntity)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        log.info("删除年级接口开始执行--->" + JSON.toJSON(sysGradeEntity));
        int deleteGrade = sysGradeClassDao.deleteGrade(sysGradeEntity);
        if (deleteGrade > 0) {
            log.info("删除年级接口结束执行--->" + JSON.toJSON(sysGradeEntity));
            return HQJsonResult.success();
        }
        return HQJsonResult.success();
    }

    /**
     * 新增班级
     *
     * @param sysGradeClassEntity
     * @return
     */
    @Override
    public HQJsonResult insertGradeClass(SysGradeClassEntity sysGradeClassEntity) {
        if (JsonUtils.checkObjAllFieldsIsNull(sysGradeClassEntity)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        log.info("新增班级接口开始执行--->" + JSON.toJSON(sysGradeClassEntity));
        sysGradeClassEntity.setId(Sid.nextShort());
        sysGradeClassEntity.setCreateTime(DateUtil.getMsTime());
        int insertGradeClass = sysGradeClassDao.insertGrdeClass(sysGradeClassEntity);
        if (insertGradeClass > 0) {
            log.info("新增班级接口开始执行--->" + JSON.toJSON(sysGradeClassEntity));
            return HQJsonResult.success(sysGradeClassEntity);
        }
        return HQJsonResult.success();
    }

    /**
     * 查询班级
     *
     * @param sysGradeClassEntity
     * @return
     */
    @Override
    public HQJsonResult selectGradeClass(SysGradeClassEntity sysGradeClassEntity) {
        if (JsonUtils.checkObjAllFieldsIsNull(sysGradeClassEntity)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        log.info("查询班级接口开始执行--->" + JSON.toJSON(sysGradeClassEntity));
        List<SysGradeClassEntity> sysGradeClassEntityList = sysGradeClassDao.selectGrdeClass(sysGradeClassEntity);
        if (!sysGradeClassEntityList.isEmpty()) {
            log.info("查询班级接口结束执行--->" + JSON.toJSON(sysGradeClassEntity));
            return HQJsonResult.success(sysGradeClassEntityList);
        }
        return HQJsonResult.success();
    }

    /**
     * 修改班级接口
     *
     * @param sysGradeClassEntity
     * @return
     */
    @Override
    public HQJsonResult updateGradeClass(SysGradeClassEntity sysGradeClassEntity) {
        if (JsonUtils.checkObjAllFieldsIsNull(sysGradeClassEntity)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        log.info("修改班级接口开始执行--->" + JSON.toJSON(sysGradeClassEntity));
        sysGradeClassEntity.setUpdateTime(DateUtil.getMsTime());
        int updateGradeClass = sysGradeClassDao.updaterdeClass(sysGradeClassEntity);
        if (updateGradeClass > 0) {
            log.info("修改班级接口结束执行--->" + JSON.toJSON(sysGradeClassEntity));
            return HQJsonResult.success(sysGradeClassEntity);
        }
        return HQJsonResult.success();
    }

    /**
     * 删除班级接口
     *
     * @param sysGradeClassEntity
     * @return
     */
    @Override
    public HQJsonResult deleteGradeClass(SysGradeClassEntity sysGradeClassEntity) {
        if (JsonUtils.checkObjAllFieldsIsNull(sysGradeClassEntity)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        log.info("删除班级接口开始执行--->" + JSON.toJSON(sysGradeClassEntity));
        int deleteGradeClass = sysGradeClassDao.deleteGradeClass(sysGradeClassEntity);
        if (deleteGradeClass > 0) {
            log.info("删除班级接口结束执行--->" + JSON.toJSON(sysGradeClassEntity));
            return HQJsonResult.success();
        }
        return HQJsonResult.success();
    }

}
