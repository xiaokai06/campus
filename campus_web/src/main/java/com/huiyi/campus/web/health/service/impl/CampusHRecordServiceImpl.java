package com.huiyi.campus.web.health.service.impl;

import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.utils.IdCardValidatorUtil;
import com.huiyi.campus.common.utils.JsonUtils;
import com.huiyi.campus.common.utils.idworker.Sid;
import com.huiyi.campus.dao.dto.health.StudentInfoRecordDto;
import com.huiyi.campus.dao.entity.phy.PhyStudentInfoEntity;
import com.huiyi.campus.dao.impl.web.health.HealthRecordDao;
import com.huiyi.campus.web.health.service.CampusHRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 校园健康档案服务业务模块
 * @date: 2021-03-28 13:38
 * @Version V1.0
 */
@Service
public class CampusHRecordServiceImpl implements CampusHRecordService {

    @Autowired
    HealthRecordDao healthRecordDao;

    /**
     * 创建学生基础健康档案基础信息
     *
     * @param studentInfoRecordDto
     * @return
     */
    @Override
    public CrRpcResult createStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto) {
        CrRpcResult rpcResult = new CrRpcResult();
        if (JsonUtils.checkObjAllFieldsIsNull(studentInfoRecordDto)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        try {
            PhyStudentInfoEntity phyStudentInfoEntity = new PhyStudentInfoEntity();
            phyStudentInfoEntity.setId(Sid.nextShort());
            phyStudentInfoEntity.setUserName(studentInfoRecordDto.getUserName());
            phyStudentInfoEntity.setSex(studentInfoRecordDto.getSex());
            phyStudentInfoEntity.setAge(studentInfoRecordDto.getAge());
            phyStudentInfoEntity.setBirthDate(sdf.format(studentInfoRecordDto.getBirthDate()));
            phyStudentInfoEntity.setParentId(studentInfoRecordDto.getParentId());
            phyStudentInfoEntity.setSchoolId(studentInfoRecordDto.getSchoolId());
            phyStudentInfoEntity.setMajorClass(studentInfoRecordDto.getMajorClass());
            phyStudentInfoEntity.setClassId(studentInfoRecordDto.getClassId());
            phyStudentInfoEntity.setStudentNumber(studentInfoRecordDto.getStudentNumber());
            if (IdCardValidatorUtil.isValidCard(studentInfoRecordDto.getIdCard())) {
                phyStudentInfoEntity.setIdCard(studentInfoRecordDto.getIdCard());
            }
            phyStudentInfoEntity.setPhoneNumber(studentInfoRecordDto.getPhoneNumber());
            phyStudentInfoEntity.setImage(studentInfoRecordDto.getImage());
            phyStudentInfoEntity.setFamilyAddress(studentInfoRecordDto.getFamilyAddress());
            phyStudentInfoEntity.setCensusAddress(studentInfoRecordDto.getCensusAddress());
            phyStudentInfoEntity.setEnterTime(studentInfoRecordDto.getEnterTime());
            phyStudentInfoEntity.setDoctorId(studentInfoRecordDto.getDoctorId());
            phyStudentInfoEntity.setDutyDoctor(studentInfoRecordDto.getDutyDoctor());
            phyStudentInfoEntity.setPhyDate(studentInfoRecordDto.getPhyDate());
            phyStudentInfoEntity.setCreateTime(new Date());
            phyStudentInfoEntity.setOperatorId(studentInfoRecordDto.getOperatorId());
            int createInfoStr = healthRecordDao.createStudentInfoRecord(phyStudentInfoEntity);

            if (createInfoStr > 0) {
                rpcResult.setCode("200");
                rpcResult.setMsg("创建学生信息成功");
                rpcResult.setTotal(createInfoStr);
                rpcResult.setData(Collections.singletonList(phyStudentInfoEntity));
                return rpcResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
