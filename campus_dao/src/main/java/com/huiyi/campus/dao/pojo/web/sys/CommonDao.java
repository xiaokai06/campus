package com.huiyi.campus.dao.pojo.web.sys;

import com.huiyi.campus.dao.entity.sys.SysAreasEntity;
import com.huiyi.campus.dao.mapper.web.sys.SysAreasMapper;
import com.huiyi.campus.dao.vo.sys.SysAreasVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-04-06 17:24
 * @Version V1.0
 */
@Repository
public class CommonDao {

    @Autowired
    SysAreasMapper sysAreasMapper;

    /**
     * 省市区三级联动查询
     * @return
     */
    public List<SysAreasVo> selectAreaList() {
        return sysAreasMapper.selectAreaList();
    }

}
