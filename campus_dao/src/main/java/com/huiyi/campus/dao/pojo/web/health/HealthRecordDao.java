package com.huiyi.campus.dao.pojo.web.health;

import com.huiyi.campus.dao.dto.health.StudentInfoRecordDto;
import com.huiyi.campus.dao.entity.phy.PhyItemResultEntity;
import com.huiyi.campus.dao.entity.phy.PhyStudentHealthInfoEntity;
import com.huiyi.campus.dao.entity.phy.PhyStudentInfoEntity;
import com.huiyi.campus.dao.mapper.web.phy.PhyItemResultMapper;
import com.huiyi.campus.dao.mapper.web.phy.PhyStudentHealthInfoMapper;
import com.huiyi.campus.dao.mapper.web.phy.PhyStudentInfoMapper;
import com.huiyi.campus.dao.vo.health.StudentHealthInfoVo;
import com.huiyi.campus.dao.vo.health.StudentInfoRecordVo;
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
     * 入库体检检验项目结果
     *
     * @param itemResultEntityList
     * @return
     */
    public int insertItemResult(List<PhyItemResultEntity> itemResultEntityList) {
        return phyItemResultMapper.insertSelectiveList(itemResultEntityList);
    }

    /**
     * 修改检验项目
     *
     * @param itemResultEntityList
     * @return
     */
    public int updateItemResult(List<PhyItemResultEntity> itemResultEntityList) {
        return phyItemResultMapper.updateItemResultList(itemResultEntityList);
    }

    /**
     * 查询健康检验项目
     *
     * @param phyHealthId
     * @return
     */
    public List<PhyItemResultEntity> selectBloodListByHealthId(String phyHealthId) {
        return phyItemResultMapper.selectBloodListByHealthId(phyHealthId);
    }
}
