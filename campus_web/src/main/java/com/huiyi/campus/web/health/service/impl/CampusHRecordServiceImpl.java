package com.huiyi.campus.web.health.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.utils.IdCardValidatorUtil;
import com.huiyi.campus.common.utils.JsonUtils;
import com.huiyi.campus.common.utils.idworker.Sid;
import com.huiyi.campus.dao.dto.health.StudentHealthInfoDto;
import com.huiyi.campus.dao.dto.health.StudentInfoRecordDto;
import com.huiyi.campus.dao.entity.phy.PhyStudentHealthInfoEntity;
import com.huiyi.campus.dao.entity.phy.PhyStudentInfoEntity;
import com.huiyi.campus.dao.impl.web.health.HealthRecordDao;
import com.huiyi.campus.dao.vo.StudentInfoRecordVo;
import com.huiyi.campus.web.health.service.CampusHRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
     * 获取所有学生档案信息
     *
     * @param studentInfoRecordDto
     * @return
     */
    @Override
    public CrRpcResult queryStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto) {
        CrRpcResult rpcResult = new CrRpcResult();
        if (JsonUtils.checkObjAllFieldsIsNull(studentInfoRecordDto)) {
            return null;
        }
        try {
            PageHelper.startPage(studentInfoRecordDto.getPage(), studentInfoRecordDto.getRows());
            List<StudentInfoRecordVo> studentInfoRecordVoList = healthRecordDao.queryStudentInfoRecord(studentInfoRecordDto);
            PageInfo<StudentInfoRecordVo> page = new PageInfo<>(studentInfoRecordVoList);
            if (page.getList() != null && !page.getList().isEmpty()) {
                rpcResult.setCode("200");
                rpcResult.setMsg("成功获取学生档案信息");
                rpcResult.setTotal(page.getTotal());
                rpcResult.setData(page.getList());
                return rpcResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 创建学生档案信息
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
            /**
             * 校验数据插入
             */
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

    /**
     * 创建学生健康档案信息
     *
     * @param studentHealthInfoDto
     * @return
     */
    @Override
    public CrRpcResult createStudentHealthInfo(StudentHealthInfoDto studentHealthInfoDto) {
        CrRpcResult rpcResult = new CrRpcResult();
        if (JsonUtils.checkObjAllFieldsIsNull(studentHealthInfoDto)) {
            return null;
        }
        try {
            PhyStudentHealthInfoEntity phyStudentHealthInfoEntity = new PhyStudentHealthInfoEntity();
            phyStudentHealthInfoEntity.setId(Sid.nextShort());
            phyStudentHealthInfoEntity.setPhyStudentId(studentHealthInfoDto.getPhyStudentId());
            phyStudentHealthInfoEntity.setHeight(studentHealthInfoDto.getHeight());
            phyStudentHealthInfoEntity.setWeight(studentHealthInfoDto.getWeight());
            phyStudentHealthInfoEntity.setBlood(studentHealthInfoDto.getBlood());
            phyStudentHealthInfoEntity.setPulse(studentHealthInfoDto.getPulse());
            phyStudentHealthInfoEntity.setChest(studentHealthInfoDto.getChest());
            phyStudentHealthInfoEntity.setVitalCapacity(studentHealthInfoDto.getVitalCapacity());
            phyStudentHealthInfoEntity.setFormDoctor(studentHealthInfoDto.getFormDoctor());
            phyStudentHealthInfoEntity.setNakedLeft(studentHealthInfoDto.getNakedLeft());
            phyStudentHealthInfoEntity.setNakedRight(studentHealthInfoDto.getNakedRight());
            phyStudentHealthInfoEntity.setCorrectLeft(studentHealthInfoDto.getCorrectLeft());
            phyStudentHealthInfoEntity.setCorrectRight(studentHealthInfoDto.getCorrectRight());
            phyStudentHealthInfoEntity.setColorVision(studentHealthInfoDto.getColorVision());
            phyStudentHealthInfoEntity.setTrachLeft(studentHealthInfoDto.getTrachLeft());
            phyStudentHealthInfoEntity.setTrachRight(studentHealthInfoDto.getTrachRight());
            phyStudentHealthInfoEntity.setEyesDoctor(studentHealthInfoDto.getEyesDoctor());
            phyStudentHealthInfoEntity.setEar(studentHealthInfoDto.getEar());
            phyStudentHealthInfoEntity.setNose(studentHealthInfoDto.getNose());
            phyStudentHealthInfoEntity.setThroat(studentHealthInfoDto.getThroat());
            phyStudentHealthInfoEntity.setEarNoseDoctor(studentHealthInfoDto.getEarNoseDoctor());
            phyStudentHealthInfoEntity.setTooth(studentHealthInfoDto.getTooth());
            phyStudentHealthInfoEntity.setPeriodontal(studentHealthInfoDto.getPeriodontal());
            phyStudentHealthInfoEntity.setAnamnesis(studentHealthInfoDto.getAnamnesis());
            phyStudentHealthInfoEntity.setHeart(studentHealthInfoDto.getHeart());
            phyStudentHealthInfoEntity.setLung(studentHealthInfoDto.getLung());
            phyStudentHealthInfoEntity.setLiver(studentHealthInfoDto.getLiver());
            phyStudentHealthInfoEntity.setSpleen(studentHealthInfoDto.getSpleen());
            phyStudentHealthInfoEntity.setInternalOther(studentHealthInfoDto.getInternalOther());
            phyStudentHealthInfoEntity.setInternalDoctor(studentHealthInfoDto.getInternalDoctor());
            phyStudentHealthInfoEntity.setSkin(studentHealthInfoDto.getSkin());
            phyStudentHealthInfoEntity.setLymph(studentHealthInfoDto.getLymph());
            phyStudentHealthInfoEntity.setThyroid(studentHealthInfoDto.getThyroid());
            phyStudentHealthInfoEntity.setSpine(studentHealthInfoDto.getSpine());
            phyStudentHealthInfoEntity.setLimbJoints(studentHealthInfoDto.getLimbJoints());
            phyStudentHealthInfoEntity.setFlatfoot(studentHealthInfoDto.getFlatfoot());
            phyStudentHealthInfoEntity.setPudendum(studentHealthInfoDto.getPudendum());
            phyStudentHealthInfoEntity.setAnus(studentHealthInfoDto.getAnus());
            phyStudentHealthInfoEntity.setSurgeryOther(studentHealthInfoDto.getSurgeryOther());
            phyStudentHealthInfoEntity.setSurgeryDoctor(studentHealthInfoDto.getSurgeryDoctor());
            phyStudentHealthInfoEntity.setChestDoctor(studentHealthInfoDto.getChestDoctor());
            phyStudentHealthInfoEntity.setLiverFunction(studentHealthInfoDto.getLiverFunction());
            phyStudentHealthInfoEntity.setBloodRoutine(studentHealthInfoDto.getBloodRoutine());
            phyStudentHealthInfoEntity.setConclusion(studentHealthInfoDto.getConclusion());
            phyStudentHealthInfoEntity.setPhyDoctor(studentHealthInfoDto.getPhyDoctor());
            phyStudentHealthInfoEntity.setPhyConclusion(studentHealthInfoDto.getPhyConclusion());
            phyStudentHealthInfoEntity.setPhyResultSuggest(studentHealthInfoDto.getPhyResultSuggest());
            phyStudentHealthInfoEntity.setDelFlag(studentHealthInfoDto.getDelFlag());
            phyStudentHealthInfoEntity.setCreateTime(new Date());
            int healthInfoStr = healthRecordDao.createStudentHealthInfo(phyStudentHealthInfoEntity);
            if (healthInfoStr > 0) {
                rpcResult.setCode("200");
                rpcResult.setMsg("创建学生信息成功");
                rpcResult.setTotal(healthInfoStr);
                rpcResult.setData(Collections.singletonList(phyStudentHealthInfoEntity));
                return rpcResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CrRpcResult updateStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto) {
        return null;
    }

    @Override
    public CrRpcResult deleteStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto) {
        return null;
    }

    @Override
    public CrRpcResult updateStudentHealthInfo(StudentHealthInfoDto studentHealthInfoDto) {
        return null;
    }

    @Override
    public CrRpcResult selectStudentHealthInfo(StudentHealthInfoDto studentHealthInfoDto) {
        return null;
    }


}
