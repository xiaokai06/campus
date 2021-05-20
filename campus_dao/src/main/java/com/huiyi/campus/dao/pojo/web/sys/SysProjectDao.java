package com.huiyi.campus.dao.pojo.web.sys;

import com.huiyi.campus.dao.dto.sys.PhyProjectDto;
import com.huiyi.campus.dao.entity.phy.PhyProject;
import com.huiyi.campus.dao.entity.phy.PhyProjectType;
import com.huiyi.campus.dao.entity.phy.PhySexAgeRef;
import com.huiyi.campus.dao.mapper.web.sys.SysProjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-05-17 10:43
 * @description: 项目字典
 */
@Repository
public class SysProjectDao {

    private final SysProjectMapper sysProjectMapper;

    SysProjectDao(SysProjectMapper sysProjectMapper) {
        this.sysProjectMapper = sysProjectMapper;
    }

    /**
     * 查询所有项目字典
     * @param phyProjectDto
     * @return
     */
    public List<PhyProject> getAllProject(PhyProjectDto phyProjectDto) {
        return sysProjectMapper.selectAllProject(phyProjectDto.getProjectName(), phyProjectDto.getProjectTypeId());
    }

    /**
     * 查询所有项目归类
     * @return
     */
    public List<PhyProjectType> getProjectType() {
        return sysProjectMapper.selectProjectType();
    }

    /**
     * 新增项目字典
     * @param phyProject
     * @return
     */
    public int insertProject(PhyProject phyProject) {
        return sysProjectMapper.insertProject(phyProject);
    }

    /**
     * 修改项目字典
     * @param phyProject
     * @return
     */
    public int updateProject(PhyProject phyProject) {
        return sysProjectMapper.updateProject(phyProject);
    }

    /**
     * 删除项目字典
     * @param id
     * @return
     */
    public int deleteProject(Integer id) {
        return sysProjectMapper.deleteProject(id);
    }

    /**
     * 查询性别年龄参考值
     * @param id
     * @return
     */
    public List<PhySexAgeRef> selectSexAgeRef(Integer id) {
        return sysProjectMapper.selectSexAgeRef(id);
    }

    /**
     * 新增性别年龄参考值
     * @param phySexAgeRef
     * @return
     */
    public int insertPhySexAgeRef(PhySexAgeRef phySexAgeRef) {
        return sysProjectMapper.insertPhySexAgeRef(phySexAgeRef);
    }

    /**
     * 修改性别年龄参考值
     * @param phySexAgeRef
     * @return
     */
    public int updatePhySexAgeRef(PhySexAgeRef phySexAgeRef) {
        return sysProjectMapper.updatePhySexAgeRef(phySexAgeRef);
    }

    /**
     * 删除性别年龄参考值
     * @param id
     * @return
     */
    public int deletePhySexAgeRef(Integer id) {
        return sysProjectMapper.deletePhySexAgeRef(id);
    }

}
