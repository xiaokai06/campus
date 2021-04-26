package com.huiyi.campus.web.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiyi.campus.common.utils.DateUtil;
import com.huiyi.campus.common.utils.JsonUtils;
import com.huiyi.campus.common.utils.idworker.Sid;
import com.huiyi.campus.common.utils.rs.HQJsonResult;
import com.huiyi.campus.common.utils.rs.SystemErrorEnum;
import com.huiyi.campus.dao.entity.sys.SysGradeClassEntity;
import com.huiyi.campus.dao.entity.sys.SysGradeEntity;
import com.huiyi.campus.dao.entity.sys.TsTypeGroupEntity;
import com.huiyi.campus.dao.pojo.web.sys.SysGradeClassDao;
import com.huiyi.campus.dao.vo.common.TsTypeGroupVo;
import com.huiyi.campus.dao.vo.sys.SysGradeClassVo;
import com.huiyi.campus.dao.vo.sys.SysGradeVo;
import com.huiyi.campus.web.sys.service.SysGradeClassService;
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
@Service
public class SysGradeClassServiceImpl implements SysGradeClassService {

    @Autowired
    SysGradeClassDao sysGradeClassDao;

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
        return new HQJsonResult();
    }

    /**
     * 查询年级和班级
     *
     * @param sysGradeEntity
     * @return
     */
    @Override
    public HQJsonResult selectGrade(SysGradeEntity sysGradeEntity) {
        if (JsonUtils.checkObjAllFieldsIsNull(sysGradeEntity)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        try {
            HQJsonResult<SysGradeClassVo> hqJsonResult = new HQJsonResult<>();
            PageHelper.startPage(sysGradeEntity.getPage(), sysGradeEntity.getRows());
            List<SysGradeClassVo> gradeEntityList = sysGradeClassDao.selectGrade(sysGradeEntity);
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
                return hqJsonResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HQJsonResult();
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
        sysGradeEntity.setUpdateTime(DateUtil.getMsTime());
        int updateGrade = sysGradeClassDao.updateGrade(sysGradeEntity);
        if (updateGrade > 0) {
            return HQJsonResult.success(sysGradeEntity);
        }
        return new HQJsonResult();
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
        int deleteGrade = sysGradeClassDao.deleteGrade(sysGradeEntity);
        if (deleteGrade > 0) {
            return HQJsonResult.success();
        }
        return new HQJsonResult();
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
        sysGradeClassEntity.setId(Sid.nextShort());
        sysGradeClassEntity.setCreateTime(DateUtil.getMsTime());
        int insertGrdeClass = sysGradeClassDao.insertGrdeClass(sysGradeClassEntity);
        if (insertGrdeClass > 0) {
            return HQJsonResult.success(sysGradeClassEntity);
        }
        return new HQJsonResult();
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
        List<SysGradeClassEntity> sysGradeClassEntityList = sysGradeClassDao.selectGrdeClass(sysGradeClassEntity);
        if (!sysGradeClassEntityList.isEmpty()) {
            return HQJsonResult.success(sysGradeClassEntityList);
        }
        return new HQJsonResult();
    }

    @Override
    public HQJsonResult updateGradeClass(SysGradeClassEntity sysGradeClassEntity) {
        if (JsonUtils.checkObjAllFieldsIsNull(sysGradeClassEntity)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        sysGradeClassEntity.setUpdateTime(DateUtil.getMsTime());
        int updateGradeClass = sysGradeClassDao.updaterdeClass(sysGradeClassEntity);
        if (updateGradeClass > 0) {
            return HQJsonResult.success(sysGradeClassEntity);
        }
        return new HQJsonResult();
    }

    @Override
    public HQJsonResult deleteGradeClass(SysGradeClassEntity sysGradeClassEntity) {
        if (JsonUtils.checkObjAllFieldsIsNull(sysGradeClassEntity)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        int deleteGradeClass = sysGradeClassDao.deleteGradeClass(sysGradeClassEntity);
        if (deleteGradeClass > 0) {
            return HQJsonResult.success();
        }
        return new HQJsonResult();
    }

}
