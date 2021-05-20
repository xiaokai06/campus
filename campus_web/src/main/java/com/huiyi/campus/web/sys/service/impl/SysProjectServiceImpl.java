package com.huiyi.campus.web.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.dto.sys.PhyProjectDto;
import com.huiyi.campus.dao.entity.phy.PhyProject;
import com.huiyi.campus.dao.entity.phy.PhySexAgeRef;
import com.huiyi.campus.dao.pojo.web.sys.SysProjectDao;
import com.huiyi.campus.web.sys.service.SysProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        PageInfo<PhyProject> pageInfo = new PageInfo<>(list);
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

    /**
     * 新增项目字典
     * @param phyProject
     * @return
     */
    @Override
    public ResultBody insertProject(PhyProject phyProject) {
        return ResultBody.insert(sysProjectDao.insertProject(phyProject), phyProject.getId());
    }

    /**
     * 修改项目字典
     * @param phyProject
     * @return
     */
    @Override
    public ResultBody updateProject(PhyProject phyProject) {
        return ResultBody.update(sysProjectDao.updateProject(phyProject));
    }

    /**
     * 删除项目字典
     * @param id
     * @return
     */
    @Override
    public ResultBody deleteProject(Integer id) {
        return ResultBody.delete(sysProjectDao.deleteProject(id));
    }

    /**
     * 查询性别年龄参考值
     * @param id
     * @return
     */
    @Override
    public ResultBody selectSexAgeRef(Integer id) {
        return ResultBody.success(sysProjectDao.selectSexAgeRef(id));
    }

    /**
     * 新增性别年龄参考值
     * @param phySexAgeRef
     * @return
     */
    @Override
    public ResultBody insertPhySexAgeRef(PhySexAgeRef phySexAgeRef) {
        return ResultBody.insert(sysProjectDao.insertPhySexAgeRef(phySexAgeRef), phySexAgeRef.getId());
    }

    /**
     * 修改性别年龄参考值
     * @param phySexAgeRef
     * @return
     */
    @Override
    public ResultBody updatePhySexAgeRef(PhySexAgeRef phySexAgeRef) {
        return ResultBody.update(sysProjectDao.updatePhySexAgeRef(phySexAgeRef));
    }

    /**
     * 删除性别年龄参考值
     * @param id
     * @return
     */
    @Override
    public ResultBody deletePhySexAgeRef(Integer id) {
        return ResultBody.delete(sysProjectDao.deletePhySexAgeRef(id));
    }

}
