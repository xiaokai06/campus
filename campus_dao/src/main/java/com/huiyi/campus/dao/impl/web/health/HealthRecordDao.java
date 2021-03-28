package com.huiyi.campus.dao.impl.web.health;

import com.huiyi.campus.dao.dto.health.StudentInfoRecordDto;
import com.huiyi.campus.dao.entity.phy.PhyStudentHealthInfoEntity;
import com.huiyi.campus.dao.entity.phy.PhyStudentInfoEntity;
import com.huiyi.campus.dao.mapper.web.phy.PhyStudentHealthInfoMapper;
import com.huiyi.campus.dao.mapper.web.phy.PhyStudentInfoMapper;
import com.huiyi.campus.dao.vo.StudentInfoRecordVo;
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
     * @param phyStudentHealthInfoEntity
     * @return
     */
    public int createStudentHealthInfo(PhyStudentHealthInfoEntity phyStudentHealthInfoEntity) {
        return phyStudentHealthInfoMapper.insert(phyStudentHealthInfoEntity);
    }
}
