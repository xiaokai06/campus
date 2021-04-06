package com.huiyi.campus.dao.pojo.web.sys;

import com.huiyi.campus.dao.entity.sys.SysDeskEntity;
import com.huiyi.campus.dao.mapper.web.sys.SysDeskMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-06 18:00
 * @description: 科室管理
 */
@Repository
public class SysDeskDao {

    SysDeskMapper sysDeskMapper;

    SysDeskDao(SysDeskMapper sysDeskMapper) {
        this.sysDeskMapper = sysDeskMapper;
    }

    /**
     * 查询所有科室
     * @param sysDeskEntity
     * @return
     */
    public List<SysDeskEntity> selectAllDesk(SysDeskEntity sysDeskEntity) {
        return sysDeskMapper.selectAllDesk(sysDeskEntity);
    }

    /**
     * 新增科室
     * @param sysDeskEntity
     * @return
     */
    public int insertDesk(SysDeskEntity sysDeskEntity) {
        return sysDeskMapper.insertDesk(sysDeskEntity);
    }

    /**
     * 修改科室
     * @param sysDeskEntity
     * @return
     */
    public int updateDesk(SysDeskEntity sysDeskEntity) {
        return sysDeskMapper.updateDesk(sysDeskEntity);
    }

    /**
     * 删除科室
     * @param id
     * @return
     */
    public int deleteDesk(Integer id) {
        return sysDeskMapper.deleteDesk(id);
    }

}
