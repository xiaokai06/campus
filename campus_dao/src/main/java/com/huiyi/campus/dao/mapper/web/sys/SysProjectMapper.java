package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.phy.PhyProject;
import com.huiyi.campus.dao.entity.phy.PhyProjectType;
import com.huiyi.campus.dao.entity.phy.PhySexAgeRef;
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

    int insertProject(PhyProject phyProject);

    int updateProject(PhyProject phyProject);

    int deleteProject(Integer id);

    List<PhySexAgeRef> selectSexAgeRef(Integer id);

    int insertPhySexAgeRef(PhySexAgeRef phySexAgeRef);

    int updatePhySexAgeRef(PhySexAgeRef phySexAgeRef);

    int deletePhySexAgeRef(Integer id);

}
