package com.huiyi.campus.dao.pojo.web.health;

import com.huiyi.campus.dao.dto.health.StudentInfoRecordDto;
import com.huiyi.campus.dao.entity.phy.PhyItemResultEntity;
import com.huiyi.campus.dao.entity.phy.PhyStudentHealthInfoEntity;
import com.huiyi.campus.dao.entity.phy.PhyStudentInfoEntity;
import com.huiyi.campus.dao.mapper.web.phy.PhyItemResultMapper;
import com.huiyi.campus.dao.mapper.web.phy.PhyStudentHealthInfoMapper;
import com.huiyi.campus.dao.mapper.web.phy.PhyStudentInfoMapper;
import com.huiyi.campus.dao.vo.health.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 校园健康档案服务持久层
 * @date: 2021-03-28 13:41
 * @Version V1.0
 */
@Repository
public class HealthRecordDao {

    @Autowired
    PhyStudentInfoMapper phyStudentInfoMapper;
    @Autowired
    PhyStudentHealthInfoMapper phyStudentHealthInfoMapper;
    @Autowired
    PhyItemResultMapper phyItemResultMapper;

    /**
     * 创建学生个人健康信息
     *
     * @param phyStudentInfoEntity
     * @return
     */
    public int createStudentInfoRecord(PhyStudentInfoEntity phyStudentInfoEntity) {
        return phyStudentInfoMapper.insert(phyStudentInfoEntity);
    }

    /**
     * 获取所有学生档案信息
     *
     * @return
     */
    public List<StudentInfoRecordVo> queryStudentInfoRecord(StudentInfoRecordDto studentInfoRecordDto) {
        return phyStudentInfoMapper.selectAll(studentInfoRecordDto);
    }

    /**
     * 创建学生健康档案信息
     *
     * @param phyStudentHealthInfoEntity
     * @return
     */
    public int createStudentHealthInfo(PhyStudentHealthInfoEntity phyStudentHealthInfoEntity) {
        return phyStudentHealthInfoMapper.insert(phyStudentHealthInfoEntity);
    }

    /**
     * 修改学生档案信息
     *
     * @param phyStudentInfoEntity
     * @return
     */
    public int updateStudentInfoRecord(PhyStudentInfoEntity phyStudentInfoEntity) {
        return phyStudentInfoMapper.updateByPrimaryKeySelective(phyStudentInfoEntity);
    }

    /**
     * 删除学生档案信息
     *
     * @param phyStudentInfoEntity
     * @return
     */
    public int deleteByPrimaryKeyAndHealthAndItem(PhyStudentInfoEntity phyStudentInfoEntity) {
        return phyStudentInfoMapper.deleteByPrimaryKeyAndHealthAndItem(phyStudentInfoEntity.getId());
    }

    /**
     * 查询学生健康档案信息
     *
     * @param phyStudentHealthInfoEntity
     * @return
     */
    public StudentHealthInfoVo selectStudentHealthInfo(PhyStudentHealthInfoEntity phyStudentHealthInfoEntity) {
        return phyStudentHealthInfoMapper.selectByPrimaryKey(phyStudentHealthInfoEntity);

    }

    /**
     * 修改学生健康档案信息
     *
     * @param phyStudentHealthInfoEntity
     * @return
     */
    public int updateStudentHealthInfo(PhyStudentHealthInfoEntity phyStudentHealthInfoEntity) {
        return phyStudentHealthInfoMapper.updateByPrimaryKey(phyStudentHealthInfoEntity);
    }

    /**
     * 批量导入学生档案信息
     *
     * @param phyStudentInfoEntityList
     * @return
     */
    public int batchInsertStudentInfo(List<PhyStudentInfoEntity> phyStudentInfoEntityList) {
        return phyStudentInfoMapper.insertSelectiveList(phyStudentInfoEntityList);
    }

    /**
     * 血常规入库体检检验项目结果
     *
     * @param itemResultEntityList
     * @return
     */
    public int insertItemBloodResult(List<PhyItemResultBloodVo> itemResultEntityList) {
        if (!itemResultEntityList.isEmpty()) {
            return phyItemResultMapper.insertSelectiveBloodList(itemResultEntityList);
        }
        return 0;
    }

    /**
     * 肝功能入库体检检验项目结果
     *
     * @param itemResultEntityList
     * @return
     */
    public int insertItemLiverResult(List<PhyItemResultLiverVo> itemResultEntityList) {
        if (!itemResultEntityList.isEmpty()) {
            return phyItemResultMapper.insertSelectiveLiverList(itemResultEntityList);
        }
        return 0;
    }

    /**
     * 血常规修改检验项目
     *
     * @param itemResultEntityList
     * @return
     */
    public int updateItemBloodResult(List<PhyItemResultBloodVo> itemResultEntityList) {
        return phyItemResultMapper.updateItemBloodResultList(itemResultEntityList);
    }

    /**
     * 肝功能修改检验项目
     *
     * @param itemResultEntityList
     * @return
     */
    public int updateItemLiverResult(List<PhyItemResultLiverVo> itemResultEntityList) {
        return phyItemResultMapper.updateItemLiverResultList(itemResultEntityList);
    }

    /**
     * 查询肝功能健康检验项目
     *
     * @param phyHealthId
     * @return
     */
    public List<PhyItemResultLiverVo> selectLiverListByHealthId(String phyHealthId, Integer rptunitid) {
        return phyItemResultMapper.selectLiverListByHealthId(phyHealthId, rptunitid);
    }

    /**
     * 查询血常规健康检验项目
     *
     * @param phyHealthId
     * @return
     */
    public List<PhyItemResultBloodVo> selectBloodListByHealthId(String phyHealthId, Integer rptunitid) {
        return phyItemResultMapper.selectBloodListByHealthId(phyHealthId, rptunitid);
    }

    /**
     * 根据学生id查询体检日期
     *
     * @param phyStudentHealthInfoEntity
     * @return
     */
    public List<StudentHealthInfoPhyDateVo> selectPhyDateByPhyStudentId(PhyStudentHealthInfoEntity phyStudentHealthInfoEntity) {
        return phyStudentHealthInfoMapper.selectPhyDateByPhyStudentId(phyStudentHealthInfoEntity);
    }

    /**
     * 根据学生编号查询学生信息是否存在
     *
     * @param studentInfoRecordDto
     * @return
     */
    public StudentInfoRecordVo selectStudentByStudentNumber(StudentInfoRecordDto studentInfoRecordDto) {
        return phyStudentInfoMapper.selectStudentByStudentNumber(studentInfoRecordDto);
    }

    /**
     * 根据学生id查询
     *
     * @param studentId
     * @return
     */
    public PhyStudentInfoEntity selectByStudentId(String studentId) {
        String id = studentId;
        return phyStudentInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询学生档案信息
     *
     * @param phyStudentInfoEntity
     * @return
     */
    public StudentInfoRecordVo selectStudentInfoRecord(PhyStudentInfoEntity phyStudentInfoEntity) {
        return phyStudentInfoMapper.selectByPrimaryStudentKey(phyStudentInfoEntity);
    }

    /**
     * @param id
     * @return
     */
    public PhyItemResultEntity selectItemResultByHeathId(String id) {
        return phyItemResultMapper.selectItemResultByHeathId(id);
    }


}
