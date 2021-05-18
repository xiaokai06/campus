package com.huiyi.campus.dao.pojo.web.sys;

import com.huiyi.campus.dao.dto.sys.PhyProjectDto;
import com.huiyi.campus.dao.entity.phy.PhyProject;
import com.huiyi.campus.dao.entity.phy.PhyProjectType;
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

}
