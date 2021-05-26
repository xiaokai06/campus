package com.huiyi.campus.dao.mapper.web.phy;

import com.huiyi.campus.dao.dto.health.PhyReportDto;
import com.huiyi.campus.dao.vo.health.PhyReportVo;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-05-24 17:39
 * @description:
 */
public interface PhyHealthReportMapper {

    List<PhyReportVo> selectPhyReport(PhyReportDto phyReportDto);

}
