package com.huiyi.campus.dao.pojo.web.health;

import com.huiyi.campus.dao.dto.health.PhyReportDto;
import com.huiyi.campus.dao.mapper.web.phy.PhyHealthReportMapper;
import com.huiyi.campus.dao.vo.health.PhyReportVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-05-24 17:36
 * @description: 体检健康报告
 */
@Repository
public class PhyHealthReportDao {

    private final PhyHealthReportMapper phyHealthReportMapper;

    PhyHealthReportDao(PhyHealthReportMapper phyHealthReportMapper) {
        this.phyHealthReportMapper = phyHealthReportMapper;
    }

    public List<PhyReportVo> selectPhyReport(PhyReportDto phyReportDto) {
        return phyHealthReportMapper.selectPhyReport(phyReportDto);
    }

}
