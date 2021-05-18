package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.phy.PhyProject;
import com.huiyi.campus.dao.entity.phy.PhyProjectType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-05-17 10:44
 * @description: 项目字典
 */
public interface SysProjectMapper {

    List<PhyProject> selectAllProject(@Param("projectName") String projectName, @Param("projectTypeId") Integer projectTypeId);

    List<PhyProjectType> selectProjectType();

}
