package com.huiyi.campus.web.health.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiyi.campus.common.poi.ExcelUtils;
import com.huiyi.campus.common.utils.IdCardValidatorUtil;
import com.huiyi.campus.common.utils.JavaBeanUtil;
import com.huiyi.campus.common.utils.JsonUtils;
import com.huiyi.campus.common.utils.idworker.Sid;
import com.huiyi.campus.common.utils.rs.HQJsonResult;
import com.huiyi.campus.common.utils.rs.SystemErrorEnum;
import com.huiyi.campus.dao.dto.health.StudentHealthInfoDto;
import com.huiyi.campus.dao.dto.health.StudentInfoRecordDto;
import com.huiyi.campus.dao.entity.phy.PhyStudentHealthInfoEntity;
import com.huiyi.campus.dao.entity.phy.PhyStudentInfoEntity;
import com.huiyi.campus.dao.pojo.web.health.HealthRecordDao;
import com.huiyi.campus.dao.vo.health.StudentInfoRecordVo;
import com.huiyi.campus.web.health.service.CampusHRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
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
        try {
            HQJsonResult<StudentInfoRecordVo> hqJsonResult = new HQJsonResult<>();
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
                return hqJsonResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取学生档案信息接口异常：" + e.getMessage());
        }
        return new HQJsonResult();
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        try {
            PhyStudentInfoEntity phyStudentInfoEntity = new PhyStudentInfoEntity();
            JavaBeanUtil.copyPropertiesIgnoreNull(studentInfoRecordDto, phyStudentInfoEntity);
            phyStudentInfoEntity.setId(Sid.nextShort());
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
        }
        return new HQJsonResult();
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
            int updateStudentInfo = healthRecordDao.updateStudentInfoRecord(phyStudentInfoEntity);
            if (updateStudentInfo > 0) {
                return HQJsonResult.success(Collections.singletonList(phyStudentInfoEntity), "学生档案信息修改成功", "200");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HQJsonResult();
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
        int deleteStudentInfo = healthRecordDao.deleteStudentInfoRecord(phyStudentInfoEntity);
        if (deleteStudentInfo > 0) {
            return HQJsonResult.success(Collections.singletonList(phyStudentInfoEntity), "学生档案信息删除成功", "200");
        }
        return new HQJsonResult();
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
        try {
            PhyStudentHealthInfoEntity phyStudentHealthInfoEntity = new PhyStudentHealthInfoEntity();
            JavaBeanUtil.copyPropertiesIgnoreNull(studentHealthInfoDto, phyStudentHealthInfoEntity);
            phyStudentHealthInfoEntity.setId(Sid.nextShort());
            phyStudentHealthInfoEntity.setCreateTime(new Date());
            int healthInfoStr = healthRecordDao.createStudentHealthInfo(phyStudentHealthInfoEntity);
            if (healthInfoStr > 0) {
                return HQJsonResult.success(Collections.singletonList(phyStudentHealthInfoEntity), "学生健康档案信息创建成功", "200");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HQJsonResult();
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
        PhyStudentHealthInfoEntity phyStudentHealthInfoEntity = new PhyStudentHealthInfoEntity();
        JavaBeanUtil.copyPropertiesIgnoreNull(studentHealthInfoDto, phyStudentHealthInfoEntity);
        PhyStudentHealthInfoEntity studentHealthInfoVo = healthRecordDao.selectStudentHealthInfo(phyStudentHealthInfoEntity);
        if (JsonUtils.checkObjAllFieldsIsNull(studentHealthInfoVo)) {
            return HQJsonResult.success(Collections.singletonList(studentHealthInfoVo), "学生健康档案信息查询成功", "200");
        }
        return new HQJsonResult();
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
        PhyStudentHealthInfoEntity phyStudentHealthInfoEntity = new PhyStudentHealthInfoEntity();
        JavaBeanUtil.copyPropertiesIgnoreNull(studentHealthInfoDto, phyStudentHealthInfoEntity);
        int updateStudentHealth = healthRecordDao.updateStudentHealthInfo(phyStudentHealthInfoEntity);
        if (updateStudentHealth > 0) {
            return HQJsonResult.success(Collections.singletonList(phyStudentHealthInfoEntity), "学生健康档案信息修改成功", "200");
        }
        return new HQJsonResult();
    }

    /**
     * 学生档案信息数据导出
     *
     * @param studentInfoRecordDto
     * @param response
     * @return
     */
    @Override
    public String exportStudentInfoFile(StudentInfoRecordDto studentInfoRecordDto, HttpServletResponse response) {
        if (JsonUtils.checkObjAllFieldsIsNull(studentInfoRecordDto)) {
            return null;
        }
        List<StudentInfoRecordVo> studentInfoRecordVoList = healthRecordDao.queryStudentInfoRecord(studentInfoRecordDto);
        if (studentInfoRecordVoList != null && !studentInfoRecordVoList.isEmpty()) {
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
                str.setPhyDate(new Date());
                str.setCreateTime(new Date());
            });
            int batchInsertStudentInfo = healthRecordDao.batchInsertStudentInfo(phyStudentInfoEntityList);
            if (batchInsertStudentInfo > 0) {
                return "导出成功";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
