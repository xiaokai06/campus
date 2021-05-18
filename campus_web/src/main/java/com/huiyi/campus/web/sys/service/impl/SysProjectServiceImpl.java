package com.huiyi.campus.web.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.dto.sys.PhyProjectDto;
import com.huiyi.campus.dao.entity.phy.PhyProject;
import com.huiyi.campus.dao.entity.phy.PhySexAgeRef;
import com.huiyi.campus.dao.pojo.web.sys.SysProjectDao;
import com.huiyi.campus.dao.vo.sys.SysProjectVo;
import com.huiyi.campus.web.sys.service.SysProjectService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: yzg
 * @time: 2021-05-17 10:42
 * @description: 项目字典
 */
@Service
public class SysProjectServiceImpl implements SysProjectService {

    private final SysProjectDao sysProjectDao;

    SysProjectServiceImpl(SysProjectDao sysProjectDao) {
        this.sysProjectDao = sysProjectDao;
    }

    /**
     * 查询所有项目字典
     * @param phyProjectDto
     * @return
     */
    @Override
    public CrRpcResult selectAllProject(PhyProjectDto phyProjectDto) {
        Integer pageNum = phyProjectDto.getPageNum();
        Integer pageSize = phyProjectDto.getPageSize();
        if (null != pageNum && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
        }
        List<PhyProject> list = sysProjectDao.getAllProject(phyProjectDto);
        Map<Integer, List<PhyProject>> map = list.stream().collect(Collectors.groupingBy(PhyProject::getId));
        List<SysProjectVo> resultList = new ArrayList<>();
        for (Integer typeId : map.keySet()) {
            SysProjectVo sysProjectVo = new SysProjectVo();
            List<PhyProject> phyList = map.get(typeId);
            if (!CollectionUtils.isEmpty(phyList)) {
                PhyProject phyProject = phyList.get(0);
                try {
                    BeanUtils.copyProperties(sysProjectVo, phyProject);
                    List<PhySexAgeRef> sexAgeRefs = new ArrayList<>();
                    for (PhyProject phyProject1 : phyList) {
                        PhySexAgeRef phySexAgeRef = new PhySexAgeRef();
                        BeanUtils.copyProperties(phySexAgeRef, phyProject1);
                        sexAgeRefs.add(phySexAgeRef);
                    }
                    sysProjectVo.setList(sexAgeRefs);
                    resultList.add(sysProjectVo);
                } catch (Exception e) {
                    throw new RuntimeException("项目字典对象赋值异常：" + e.getMessage());
                }
            }
        }
        PageInfo<SysProjectVo> pageInfo = new PageInfo<>(resultList);
        return CrRpcResult.success(pageInfo);
    }

    /**
     * 查询所有项目归类
     * @return
     */
    @Override
    public ResultBody selectProjectType() {
        return ResultBody.success(sysProjectDao.getProjectType());
    }
}
