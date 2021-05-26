package com.huiyi.campus.web.health.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.dao.dto.health.PhyReportDto;
import com.huiyi.campus.dao.pojo.web.health.PhyHealthReportDao;
import com.huiyi.campus.dao.vo.health.PhyReportVo;
import com.huiyi.campus.web.health.service.CampusPhyReportService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 健康体检报告
 * @date: 2021-04-19 13:48
 * @Version V1.0
 */
@Service
public class CampusPhyReportServiceImpl implements CampusPhyReportService {

    private final PhyHealthReportDao phyHealthReportDao;

    CampusPhyReportServiceImpl(PhyHealthReportDao phyHealthReportDao) {
        this.phyHealthReportDao = phyHealthReportDao;
    }

    @Override
    public CrRpcResult selectPhyReport(PhyReportDto phyReportDto) {
        Integer pageNum = phyReportDto.getPageNum();
        Integer pageSize = phyReportDto.getPageSize();
        if (null != pageNum && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
        }
        List<PhyReportVo> list = phyHealthReportDao.selectPhyReport(phyReportDto);
        PageInfo<PhyReportVo> pageInfo = new PageInfo<>(list);
        return CrRpcResult.success(pageInfo);
    }
}
