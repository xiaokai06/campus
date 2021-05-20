package com.huiyi.campus.web.sys.service;

import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.dto.sys.PhyProjectDto;
import com.huiyi.campus.dao.entity.phy.PhyProject;
import com.huiyi.campus.dao.entity.phy.PhySexAgeRef;

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

    /**
     * 新增项目字典
     * @param phyProject
     * @return
     */
    ResultBody insertProject(PhyProject phyProject);

    /**
     * 修改项目字典
     * @param phyProject
     * @return
     */
    ResultBody updateProject(PhyProject phyProject);

    /**
     * 删除项目字典
     * @param id
     * @return
     */
    ResultBody deleteProject(Integer id);

    /**
     * 查询性别年龄参考值
     * @param id
     * @return
     */
    ResultBody selectSexAgeRef(Integer id);

    /**
     * 新增性别年龄参考值
     * @param phySexAgeRef
     * @return
     */
    ResultBody insertPhySexAgeRef(PhySexAgeRef phySexAgeRef);

    /**
     * 修改性别年龄参考值
     * @param phySexAgeRef
     * @return
     */
    ResultBody updatePhySexAgeRef(PhySexAgeRef phySexAgeRef);

    /**
     * 删除性别年龄参考值
     * @param id
     * @return
     */
    ResultBody deletePhySexAgeRef(Integer id);

}
