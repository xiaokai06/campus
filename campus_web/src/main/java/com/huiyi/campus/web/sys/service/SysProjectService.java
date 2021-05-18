package com.huiyi.campus.web.sys.service;

import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.dto.sys.PhyProjectDto;

/**
 * @author: yzg
 * @time: 2021-05-17 10:41
 * @description: 项目字典
 */
public interface SysProjectService {

    /**
     * 查询所有项目字典
     * @param phyProjectDto
     * @return
     */
    CrRpcResult selectAllProject(PhyProjectDto phyProjectDto);

    /**
     * 查询项目归类
     * @return
     */
    ResultBody selectProjectType();

}
