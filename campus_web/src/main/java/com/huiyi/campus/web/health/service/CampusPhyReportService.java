package com.huiyi.campus.web.health.service;

import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.dao.dto.health.PhyReportDto;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 体检报告
 * @date: 2021-04-19 13:47
 * @Version V1.0
 */
public interface CampusPhyReportService {

    CrRpcResult selectPhyReport(PhyReportDto phyReportDto);

}
