package com.huiyi.campus.dao.mapper.web.sys;

import com.huiyi.campus.dao.entity.sys.SysDeskEntity;

import java.util.List;

public interface SysDeskMapper {

    /**
     * 查询所有科室
     * @param sysDeskEntity
     * @return
     */
    List<SysDeskEntity> selectAllDesk(SysDeskEntity sysDeskEntity);

    /**
     * 新增科室
     * @param sysDeskEntity
     * @return
     */
    int insertDesk(SysDeskEntity sysDeskEntity);

    /**
     * 修改科室
     * @param sysDeskEntity
     * @return
     */
    int updateDesk(SysDeskEntity sysDeskEntity);

    /**
     * 删除科室
     * @param id
     * @return
     */
    int deleteDesk(Integer id);

}