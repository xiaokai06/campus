package com.huiyi.campus.web.health.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiyi.campus.common.consts.PhyItemConstants;
import com.huiyi.campus.common.poi.ExcelUtils;
import com.huiyi.campus.common.utils.DateUtil;
import com.huiyi.campus.common.utils.IdCardValidatorUtil;
import com.huiyi.campus.common.utils.JavaBeanUtil;
import com.huiyi.campus.common.utils.JsonUtils;
import com.huiyi.campus.common.utils.idworker.Sid;
import com.huiyi.campus.common.utils.rs.HQJsonResult;
import com.huiyi.campus.common.utils.rs.SystemErrorEnum;
import com.huiyi.campus.dao.dto.health.ExportStudentInfoDto;
import com.huiyi.campus.dao.dto.health.StudentHealthInfoDto;
import com.huiyi.campus.dao.dto.health.StudentInfoRecordDto;
import com.huiyi.campus.dao.entity.phy.PhyStudentHealthInfoEntity;
import com.huiyi.campus.dao.entity.phy.PhyStudentInfoEntity;
import com.huiyi.campus.dao.entity.sys.SysGradeEntity;
import com.huiyi.campus.dao.pojo.web.health.HealthRecordDao;
import com.huiyi.campus.dao.pojo.web.sys.SysGradeClassDao;
import com.huiyi.campus.dao.vo.health.*;
import com.huiyi.campus.dao.vo.sys.SysGradeVo;
import com.huiyi.campus.web.health.service.CampusHRecordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 校园健康档案服务业务模块
 * @date: 2021-03-28 13:38
 * @Version V1.0
 */
@Slf4j
@Service
public class CampusHRecordServiceImpl implements CampusHRecordService {

    @Autowired
    HealthRecordDao healthRecordDao;

    @Autowired
    SysGradeClassDao sysGradeClassDao;

    /**
     * 获取所有学生档案信息
     *
     * @param studentInfoRecordDto
     * @return
     */
    @Override
    public HQJsonResult queryStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto) {
        if (JsonUtils.checkObjAllFieldsIsNull(studentInfoRecordDto)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        log.info("获取所有学生档案信息接口开始执行--->" + JSON.toJSON(studentInfoRecordDto));
        try {
            HQJsonResult<StudentInfoRecordVo> hqJsonResult = new HQJsonResult<>();
            /**String[] orgIdCode = studentInfoRecordDto.getOrganId().split(",");
             String[] schoolIdCode = studentInfoRecordDto.getSchoolId().split(",");
             studentInfoRecordDto.setOrgIdList(Arrays.asList(orgIdCode));
             studentInfoRecordDto.setSchoolIdList(Arrays.asList(schoolIdCode));*/
            PageHelper.startPage(studentInfoRecordDto.getPage(), studentInfoRecordDto.getRows());
            List<StudentInfoRecordVo> studentInfoRecordVoList = healthRecordDao.queryStudentInfoRecord(studentInfoRecordDto);
            PageInfo<StudentInfoRecordVo> page = new PageInfo<>(studentInfoRecordVoList);
            if (!page.getList().isEmpty()) {
                hqJsonResult.setSuccess(true);
                hqJsonResult.setCode("200");
                hqJsonResult.setMsg("处理成功！");
                hqJsonResult.setRequestID(String.valueOf(UUID.randomUUID()));
                hqJsonResult.setTotal(page.getTotal());
                hqJsonResult.setData(page.getList());
                log.info("获取所有学生档案信息接口结束执行--->" + JSON.toJSON(studentInfoRecordDto));
                return hqJsonResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取学生档案信息接口异常：" + e.getMessage());
        }
        return HQJsonResult.success();
    }

    /**
     * 查询学生档案信息
     *
     * @param studentInfoRecordDto
     * @return
     */
    @Override
    public HQJsonResult selectStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto) {
        if (JsonUtils.checkObjAllFieldsIsNull(studentInfoRecordDto)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        log.info("查询学生档案信息接口开始执行--->" + JSON.toJSON(studentInfoRecordDto));
        try {
            PhyStudentInfoEntity phyStudentInfoEntity = new PhyStudentInfoEntity();
            JavaBeanUtil.copyPropertiesIgnoreNull(studentInfoRecordDto, phyStudentInfoEntity);
            StudentInfoRecordVo studentInfoRecordVo = healthRecordDao.selectStudentInfoRecord(phyStudentInfoEntity);
            if (!JsonUtils.checkObjAllFieldsIsNull(studentInfoRecordVo)) {
                SysGradeEntity gradeEntity = new SysGradeEntity();
                JavaBeanUtil.copyPropertiesIgnoreNull(studentInfoRecordVo, gradeEntity);
                List<SysGradeVo> gradeVoList = sysGradeClassDao.queryGradeClass(gradeEntity);
                gradeVoList.forEach(str -> {
                    studentInfoRecordVo.setGradeName(str.getGradeName());
                    studentInfoRecordVo.setClassName(str.getClassName());
                });
                log.info("查询学生档案信息接口结束执行--->" + JSON.toJSON(studentInfoRecordDto));
                return HQJsonResult.success(studentInfoRecordVo);
            } else {
                log.info("学校ID为：" + studentInfoRecordDto.getSchoolId() + "-->当前学生档案信息不存在,学生ID为：" + studentInfoRecordDto.getId());
                return HQJsonResult.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HQJsonResult.success();
    }


    /**
     * 创建学生档案信息
     *
     * @param studentInfoRecordDto
     * @return
     */
    @Override
    public HQJsonResult createStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto) {
        if (JsonUtils.checkObjAllFieldsIsNull(studentInfoRecordDto)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        try {
            PhyStudentInfoEntity phyStudentInfoEntity = new PhyStudentInfoEntity();
            JavaBeanUtil.copyPropertiesIgnoreNull(studentInfoRecordDto, phyStudentInfoEntity);
            phyStudentInfoEntity.setId(Sid.nextShort());
            //校验身份证
            if (IdCardValidatorUtil.isValidCard(phyStudentInfoEntity.getIdCard())) {
                phyStudentInfoEntity.setIdCard(phyStudentInfoEntity.getIdCard());
            }
            phyStudentInfoEntity.setCreateTime(new Date());
            int createInfoStr = healthRecordDao.createStudentInfoRecord(phyStudentInfoEntity);
            //校验数据插入
            if (createInfoStr > 0) {
                return HQJsonResult.success(Collections.singletonList(phyStudentInfoEntity));
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("创建学生档案信息异常为：" + e.getMessage());
        }
        return HQJsonResult.success();
    }


    /**
     * 修改学生档案信息
     * TODO:缺少批量逻辑
     *
     * @param studentInfoRecordDto
     * @return
     */
    @Override
    public HQJsonResult updateStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto) {
        if (JsonUtils.checkObjAllFieldsIsNull(studentInfoRecordDto)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        try {
            PhyStudentInfoEntity phyStudentInfoEntity = new PhyStudentInfoEntity();
            JavaBeanUtil.copyPropertiesIgnoreNull(studentInfoRecordDto, phyStudentInfoEntity);
            phyStudentInfoEntity.setUpdateTime(new Date());
            int updateStudentInfo = healthRecordDao.updateStudentInfoRecord(phyStudentInfoEntity);
            if (updateStudentInfo > 0) {
                return HQJsonResult.success(Collections.singletonList(phyStudentInfoEntity));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return HQJsonResult.error(SystemErrorEnum.OUTPUT_SYSTEM_ERROR);
        }
        return HQJsonResult.success();

    }

    /**
     * 删除学生档案信息
     * TODO:缺少批量逻辑
     *
     * @param studentInfoRecordDto
     * @return
     */
    @Override
    public HQJsonResult deleteStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto) {
        if (JsonUtils.checkObjAllFieldsIsNull(studentInfoRecordDto)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        PhyStudentInfoEntity phyStudentInfoEntity = new PhyStudentInfoEntity();
        JavaBeanUtil.copyPropertiesIgnoreNull(studentInfoRecordDto, phyStudentInfoEntity);
        int deleteStudentInfo = healthRecordDao.deleteByPrimaryKeyAndHealthAndItem(phyStudentInfoEntity);
        if (deleteStudentInfo > 0) {
            log.info("学生档案信息删除成功,学生ID为：" + studentInfoRecordDto.getId());
            return HQJsonResult.success();
        }
        return HQJsonResult.success();
    }

    /**
     * 查询学生健康档案信息
     *
     * @param studentHealthInfoDto
     * @return
     */
    @Override
    public HQJsonResult selectStudentHealthInfo(StudentHealthInfoDto studentHealthInfoDto) {
        if (JsonUtils.checkObjAllFieldsIsNull(studentHealthInfoDto)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        log.info("查询学生健康档案信息接口开始执行--->" + JSON.toJSON(studentHealthInfoDto));
        try {
            PhyStudentHealthInfoEntity phyStudentHealthInfoEntity = new PhyStudentHealthInfoEntity();
            JavaBeanUtil.copyPropertiesIgnoreNull(studentHealthInfoDto, phyStudentHealthInfoEntity);
            StudentHealthInfoVo studentHealthInfoVo = healthRecordDao.selectStudentHealthInfo(phyStudentHealthInfoEntity);
            if (!JsonUtils.checkObjAllFieldsIsNull(studentHealthInfoVo)) {
                //校验血常规与肝功能检查是否正常
                if (StringUtils.isNotEmpty(studentHealthInfoVo.getBloodRoutine()) || StringUtils.isNotEmpty(studentHealthInfoVo.getLiverFunction())) {
                    if (studentHealthInfoVo.getBloodRoutine().equals(PhyItemConstants.bloodRoutine_error) ||
                            studentHealthInfoVo.getLiverFunction().equals(PhyItemConstants.liverFunction_error)) {
                        List<PhyItemResultLiverVo> liverResultEntities = healthRecordDao.selectLiverListByHealthId(studentHealthInfoVo.getId(), PhyItemConstants.liverFunction);
                        if (!liverResultEntities.isEmpty()) {
                            studentHealthInfoVo.setLiverFunctionItemList(liverResultEntities);
                        }
                        List<PhyItemResultBloodVo> bloodResultEntities = healthRecordDao.selectBloodListByHealthId(studentHealthInfoVo.getId(), PhyItemConstants.bloodRoutine);
                        if (!bloodResultEntities.isEmpty()) {
                            studentHealthInfoVo.setBloodRoutineItemList(bloodResultEntities);
                        }
                    }
                }
                log.info("查询学生健康档案信息接口结束执行--->" + JSON.toJSON(studentHealthInfoVo));
                return HQJsonResult.success(Collections.singletonList(studentHealthInfoVo));
            } else {
                log.info("学校ID为：" + studentHealthInfoDto.getSchoolId() + "-->查询当前学生健康档案信息不存在,学生ID为：" + studentHealthInfoDto.getPhyStudentId() + "-->健康ID为：" + studentHealthInfoDto.getId());
                return HQJsonResult.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HQJsonResult.success();

    }

    /**
     * 创建学生健康档案信息
     *
     * @param studentHealthInfoDto
     * @return
     */
    @Override
    public HQJsonResult createStudentHealthInfo(StudentHealthInfoDto studentHealthInfoDto) {
        if (JsonUtils.checkObjAllFieldsIsNull(studentHealthInfoDto)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        log.info("创建学生健康档案信息接口开始执行--->" + JSON.toJSON(studentHealthInfoDto));
        try {
            PhyStudentHealthInfoEntity phyStudentHealthInfoEntity = new PhyStudentHealthInfoEntity();
            JavaBeanUtil.copyPropertiesIgnoreNull(studentHealthInfoDto, phyStudentHealthInfoEntity);
            phyStudentHealthInfoEntity.setId(Sid.nextShort());
            studentHealthInfoDto.setId(phyStudentHealthInfoEntity.getId());
            phyStudentHealthInfoEntity.setCreateTime(new Date());
            int healthInfoStr = healthRecordDao.createStudentHealthInfo(phyStudentHealthInfoEntity);
            //校验肝功能与血常规检查是否正常
            if (StringUtils.isNotEmpty(studentHealthInfoDto.getBloodRoutine()) || StringUtils.isNotEmpty(studentHealthInfoDto.getLiverFunction())) {
                if (studentHealthInfoDto.getBloodRoutine().equals(PhyItemConstants.bloodRoutine_error) ||
                        studentHealthInfoDto.getLiverFunction().equals(PhyItemConstants.liverFunction_error)) {
                    //肝功能新增
                    if (!studentHealthInfoDto.getLiverFunctionItemList().isEmpty()) {
                        studentHealthInfoDto.getLiverFunctionItemList().forEach(liverStr -> {
                            liverStr.setId(Sid.nextShort());
                            liverStr.setPhyHealthId(phyStudentHealthInfoEntity.getId());
                            if (StringUtils.isNotEmpty(liverStr.getResultStr())) {
                                BigDecimal liverNum = new BigDecimal(liverStr.getResultStr());
                                liverNum.setScale(2, BigDecimal.ROUND_HALF_UP);
                                liverStr.setResultNum(liverNum.toString());
                                liverStr.setResultStr(liverStr.getResultNum());
                            }
                            liverStr.setCreateTime(DateUtil.getMsTime());
                            if (StringUtils.isEmpty(liverStr.getResultNum())) {
                                liverStr.setResultNum(null);
                            }
                        });
                        int bloodRoutine = healthRecordDao.insertItemLiverResult(studentHealthInfoDto.getLiverFunctionItemList());
                        if (bloodRoutine < 0) {
                            log.info("肝功能报告结果入库异常：" + bloodRoutine + "学生ID为：" + studentHealthInfoDto.getPhyStudentId());
                        }
                    }
                    //血常规新增
                    if (!studentHealthInfoDto.getBloodRoutineItemList().isEmpty()) {
                        studentHealthInfoDto.getBloodRoutineItemList().forEach(bloodStr -> {
                            bloodStr.setId(Sid.nextShort());
                            bloodStr.setPhyHealthId(phyStudentHealthInfoEntity.getId());
                            if (StringUtils.isNotEmpty(bloodStr.getResultStr())) {
                                BigDecimal bloodNum = new BigDecimal(bloodStr.getResultStr());
                                bloodNum.setScale(2, BigDecimal.ROUND_HALF_UP);
                                bloodStr.setResultNum(bloodNum.toString());
                                bloodStr.setResultStr(bloodStr.getResultNum());
                            }
                            bloodStr.setCreateTime(DateUtil.getMsTime());
                            if (StringUtils.isEmpty(bloodStr.getResultNum())) {
                                bloodStr.setResultNum(null);
                            }
                        });
                        int liverRoutine = healthRecordDao.insertItemBloodResult(studentHealthInfoDto.getBloodRoutineItemList());
                        if (liverRoutine < 0) {
                            log.info("血常规报告结果入库异常：" + liverRoutine + "学生ID为：" + studentHealthInfoDto.getPhyStudentId());
                        }
                    }
                }
            }
            //校验健康信息新增入库是否成功
            if (healthInfoStr > 0) {
                log.info("创建学生健康档案信息接口结束执行--->" + JSON.toJSON(studentHealthInfoDto));
                return HQJsonResult.success(Collections.singletonList(studentHealthInfoDto));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HQJsonResult.success();
    }

    /**
     * 修改学生健康档案信息
     *
     * @param studentHealthInfoDto
     * @return
     */
    @Override
    public HQJsonResult updateStudentHealthInfo(StudentHealthInfoDto studentHealthInfoDto) {
        if (JsonUtils.checkObjAllFieldsIsNull(studentHealthInfoDto)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        log.info("修改学生健康档案信息接口开始执行--->" + JSON.toJSON(studentHealthInfoDto));
        try {
            PhyStudentHealthInfoEntity phyStudentHealthInfoEntity = new PhyStudentHealthInfoEntity();
            studentHealthInfoDto.setUpdateTime(new Date());
            JavaBeanUtil.copyPropertiesIgnoreNull(studentHealthInfoDto, phyStudentHealthInfoEntity);
            int updateStudentHealth = healthRecordDao.updateStudentHealthInfo(phyStudentHealthInfoEntity);
            //校验肝功能与血常规检查是否正常
            if (StringUtils.isNotEmpty(studentHealthInfoDto.getBloodRoutine()) || StringUtils.isNotEmpty(studentHealthInfoDto.getLiverFunction())) {
                if (studentHealthInfoDto.getBloodRoutine().equals(PhyItemConstants.bloodRoutine_error) ||
                        studentHealthInfoDto.getLiverFunction().equals(PhyItemConstants.liverFunction_error)) {
                    //肝功能新增修改判断
                    if (!studentHealthInfoDto.getLiverFunctionItemList().isEmpty()){
                        if (StringUtils.isEmpty(studentHealthInfoDto.getLiverFunctionItemList().get(0).getId())) {
                            studentHealthInfoDto.getLiverFunctionItemList().forEach(liverStrC -> {
                                liverStrC.setId(Sid.nextShort());
                                liverStrC.setPhyHealthId(phyStudentHealthInfoEntity.getId());
                                if (StringUtils.isNotEmpty(liverStrC.getResultStr())) {
                                    BigDecimal liverNumC = new BigDecimal(liverStrC.getResultStr());
                                    liverNumC.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    liverStrC.setResultNum(liverNumC.toString());
                                    liverStrC.setResultStr(liverStrC.getResultNum());
                                }
                                liverStrC.setCreateTime(DateUtil.getMsTime());
                                if (StringUtils.isEmpty(liverStrC.getResultNum())) {
                                    liverStrC.setResultNum(null);
                                }
                            });
                            int liverRoutineC = healthRecordDao.insertItemLiverResult(studentHealthInfoDto.getLiverFunctionItemList());
                            if (liverRoutineC < 0) {
                                log.info("肝功能报告结果新录入异常：" + liverRoutineC + "学生ID为：" + studentHealthInfoDto.getPhyStudentId());
                            }
                        } else if (StringUtils.isNotEmpty(studentHealthInfoDto.getLiverFunctionItemList().get(0).getId())) {
                            studentHealthInfoDto.getLiverFunctionItemList().forEach(liverStrU -> {
                                liverStrU.setUpdateTime(DateUtil.getMsTime());
                                if (StringUtils.isNotEmpty(liverStrU.getResultStr())) {
                                    BigDecimal liverU = new BigDecimal(liverStrU.getResultStr());
                                    liverU.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    liverStrU.setResultNum(liverU.toString());
                                    liverStrU.setResultStr(liverStrU.getResultNum());
                                }
                            });
                            int liverRoutineU = healthRecordDao.updateItemLiverResult(studentHealthInfoDto.getLiverFunctionItemList());
                            if (liverRoutineU < 0) {
                                log.info("肝功能报告结果修改异常：" + liverRoutineU + "学生ID为：" + studentHealthInfoDto.getPhyStudentId());
                            }
                        }
                }
                    //血常规新增修改判断
                    if (!studentHealthInfoDto.getBloodRoutineItemList().isEmpty()) {
                        if (StringUtils.isEmpty(studentHealthInfoDto.getBloodRoutineItemList().get(0).getId())) {
                            studentHealthInfoDto.getBloodRoutineItemList().forEach(bloodStrC -> {
                                bloodStrC.setId(Sid.nextShort());
                                bloodStrC.setPhyHealthId(phyStudentHealthInfoEntity.getId());
                                if (StringUtils.isNotEmpty(bloodStrC.getResultStr())) {
                                    BigDecimal bloodNumC = new BigDecimal(bloodStrC.getResultStr());
                                    bloodNumC.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    bloodStrC.setResultNum(bloodNumC.toString());
                                    bloodStrC.setResultStr(bloodStrC.getResultNum());
                                }
                                bloodStrC.setCreateTime(DateUtil.getMsTime());
                                if (StringUtils.isEmpty(bloodStrC.getResultNum())) {
                                    bloodStrC.setResultNum(null);
                                }
                            });
                            int bloodRoutineC = healthRecordDao.insertItemBloodResult(studentHealthInfoDto.getBloodRoutineItemList());
                            if (bloodRoutineC < 0) {
                                log.info("血常规报告结果新录入异常：" + bloodRoutineC + "学生ID为：" + studentHealthInfoDto.getPhyStudentId());
                            }
                        } else if (StringUtils.isNotEmpty(studentHealthInfoDto.getBloodRoutineItemList().get(0).getId())) {
                            studentHealthInfoDto.getBloodRoutineItemList().forEach(bloodStrU -> {
                                bloodStrU.setUpdateTime(DateUtil.getMsTime());
                                if (StringUtils.isNotEmpty(bloodStrU.getResultStr())) {
                                    BigDecimal bloodU = new BigDecimal(bloodStrU.getResultStr());
                                    bloodU.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    bloodStrU.setResultNum(bloodU.toString());
                                    bloodStrU.setResultStr(bloodStrU.getResultNum());
                                }
                            });
                            int bloodRoutineU = healthRecordDao.updateItemBloodResult(studentHealthInfoDto.getBloodRoutineItemList());
                            if (bloodRoutineU < 0) {
                                log.info("血常规报告结果修改异常：" + bloodRoutineU + "学生ID为：" + studentHealthInfoDto.getPhyStudentId());
                            }
                        }
                    }
                }
            }
            if (updateStudentHealth > 0) {
                log.info("修改学生健康档案信息接口结束执行--->" + JSON.toJSON(studentHealthInfoDto));
                return HQJsonResult.success(Collections.singletonList(studentHealthInfoDto));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HQJsonResult.success();
    }

    /**
     * 学生档案信息数据导出
     *
     * @param exportStudentInfoDto
     * @param response
     * @return
     */
    @Override
    public String exportStudentInfoFile(ExportStudentInfoDto exportStudentInfoDto, HttpServletResponse response) {
        if (JsonUtils.checkObjAllFieldsIsNull(exportStudentInfoDto)) {
            return null;
        }
        PageHelper.startPage(exportStudentInfoDto.getPage(), exportStudentInfoDto.getRows());
        List<StudentInfoRecordVo> studentInfoRecordVoList = healthRecordDao.exportStudentInfoRecord(exportStudentInfoDto);
        if (null != studentInfoRecordVoList && !studentInfoRecordVoList.isEmpty()) {
            try {
                ExcelUtils.exportExcel(studentInfoRecordVoList, null, "学生表", StudentInfoRecordVo.class, "学生档案信息", response);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /**
     * 学生档案信息数据导入
     *
     * @param file
     * @return
     */
    @Override
    public String importStudentInfoFile(MultipartFile file) {
        try {
            List<PhyStudentInfoEntity> phyStudentInfoEntityList = ExcelUtils.importExcel(file, 0, 1, PhyStudentInfoEntity.class);
            phyStudentInfoEntityList.forEach(str -> {
                str.setId(Sid.nextShort());
//                str.setPhyDate(new Date());
                str.setCreateTime(new Date());
            });
            int batchInsertStudentInfo = healthRecordDao.batchInsertStudentInfo(phyStudentInfoEntityList);
            if (batchInsertStudentInfo > 0) {
                return "导入成功";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据学生id查询体检日期
     *
     * @param studentHealthInfoDto
     * @return
     */
    @Override
    public HQJsonResult selectPhyDateByPhyStudentId(StudentHealthInfoDto studentHealthInfoDto) {
        if (JsonUtils.checkObjAllFieldsIsNull(studentHealthInfoDto)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        try {
            PhyStudentHealthInfoEntity phyStudentHealthInfoEntity = new PhyStudentHealthInfoEntity();
            JavaBeanUtil.copyPropertiesIgnoreNull(studentHealthInfoDto, phyStudentHealthInfoEntity);
            List<StudentHealthInfoPhyDateVo> studentHealthInfoPhyDateVoList = healthRecordDao.selectPhyDateByPhyStudentId(phyStudentHealthInfoEntity);
            if (!studentHealthInfoPhyDateVoList.isEmpty()) {
                return HQJsonResult.success(Collections.singletonList(studentHealthInfoPhyDateVoList));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HQJsonResult.success();
    }

    /**
     * 根据学生id查询
     *
     * @param studentId
     * @return
     */
    @Override
    public PhyStudentInfoEntity selectByStudentId(String studentId) {
        return healthRecordDao.selectByStudentId(studentId);
    }


}
