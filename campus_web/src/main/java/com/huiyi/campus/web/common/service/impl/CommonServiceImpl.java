package com.huiyi.campus.web.common.service.impl;

import com.huiyi.campus.common.utils.JsonUtils;
import com.huiyi.campus.common.utils.rs.HQJsonResult;
import com.huiyi.campus.common.utils.rs.SystemErrorEnum;
import com.huiyi.campus.dao.dto.common.SchoolDto;
import com.huiyi.campus.dao.entity.sys.*;
import com.huiyi.campus.dao.pojo.web.common.CommonDao;
import com.huiyi.campus.dao.vo.common.SysAreasVo;
import com.huiyi.campus.dao.vo.common.TsTypeGroupVo;
import com.huiyi.campus.web.common.service.CommonService;
import com.mchange.v1.util.CollectionUtils;
import com.mchange.v2.beans.BeansUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 公共接口
 * @date: 2021-04-06 17:19
 * @Version V1.0
 */
@Service
public class CommonServiceImpl implements CommonService {


    @Autowired
    CommonDao commonDao;


    /**
     * 省市区三级联动查询
     *
     * @param
     * @return
     */
    @Override
    public HQJsonResult area() {
        List<SysAreasVo> areasEntityList = commonDao.selectAreaList();
        List<SysAreasVo> oneLevelRegion = areasEntityList.stream().filter(item -> item.getPid() == 0).collect(Collectors.toList());
        //遍历一级地区
        oneLevelRegion.stream().forEach(oneItem ->
                {
                    //获得二级地区 地级市、地区、自治州、盟
                    List<SysAreasVo> twoLevelRegion = areasEntityList.stream().filter(twoItem ->
                            StringUtils.equals(String.valueOf(twoItem.getPid()), String.valueOf(oneItem.getId())))
                            .collect(Collectors.toList());
                    //遍历二级地区
                    twoLevelRegion.stream().forEach(twoItem ->
                    {
                        //获得三级地区 市辖区、县级市、县
                        List<SysAreasVo> threeLevelRegion = areasEntityList.stream().filter(threeItem ->
                                StringUtils.equals(String.valueOf(threeItem.getPid()), String.valueOf(twoItem.getId())))
                                .collect(Collectors.toList());
                        twoItem.setAreasList(threeLevelRegion);
                    });
                    oneItem.setAreasList(twoLevelRegion);
                }
        );
        return HQJsonResult.success(oneLevelRegion);
    }

    /**
     * 根据用户ID与教育局ID查询当前所归属学校
     *
     * @param schoolDto
     * @return
     */
    @Override
    public HQJsonResult selectSchoolByUserId(SchoolDto schoolDto) {
        if (JsonUtils.checkObjAllFieldsIsNull(schoolDto)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        List<SysSchoolEntity> schoolEntityList = commonDao.selectSchoolByUserId(schoolDto);
        if (schoolEntityList.isEmpty()) {
            schoolEntityList = commonDao.selectSchoolByUserIdAndOrganId(schoolDto);
        }
        return HQJsonResult.success(schoolEntityList);
    }

    /**
     * 根据学校ID查询专业班级
     *
     * @param schoolDto
     * @return
     */
    @Override
    public HQJsonResult selectClassBySchoolId(SchoolDto schoolDto) {
        if (JsonUtils.checkObjAllFieldsIsNull(schoolDto)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        List<SysGradeClassEntity> classEntityList = commonDao.selectClassBySchoolId(schoolDto);
        return HQJsonResult.success(classEntityList);
    }

    /**
     * 字典
     *
     * @return
     */
    @Override
    public HQJsonResult selectType() {
        //父级
        List<TsTypeGroupVo> resultVoList = new ArrayList<>();
        List<TsTypeGroupEntity> list = commonDao.selectTypeGroup();
        Map<String, List<TsTypeGroupEntity>> map = list.stream().collect(Collectors.groupingBy(TsTypeGroupEntity::getTypegroupid));
        for (String id : map.keySet()) {
            TsTypeGroupVo tsTypeGroupVo = new TsTypeGroupVo();
            List<TsTypeEntity> result = new ArrayList<>();
            List<TsTypeGroupEntity> resultList = map.get(id);
            for (TsTypeGroupEntity tsTypeGroupEntity : resultList) {
                TsTypeEntity tsTypeEntity = new TsTypeEntity();
                tsTypeEntity.setId(tsTypeGroupEntity.getId());
                tsTypeEntity.setTypecode(tsTypeGroupEntity.getTypecode());
                tsTypeEntity.setTypename(tsTypeGroupEntity.getTypename());
                tsTypeEntity.setTypegroupid(tsTypeGroupEntity.getTypegroupid());
                result.add(tsTypeEntity);
            }
            if (result.size() > 0) {
                TsTypeGroupEntity tsTypeGroupEntity = resultList.get(0);
                tsTypeGroupVo.setId(tsTypeGroupEntity.getId());
                tsTypeGroupVo.setTypegroupcode(tsTypeGroupEntity.getTypegroupcode());
                tsTypeGroupVo.setTypegroupname(tsTypeGroupEntity.getTypegroupname());
                tsTypeGroupVo.setTypeList(result);
                resultVoList.add(tsTypeGroupVo);
            }
        }
        return HQJsonResult.success(resultVoList);
    }

    /**
     * 根据机构id查询教育局机构
     * @param schoolDto
     * @return
     */
    @Override
    public HQJsonResult selectOrganByOrganId(SchoolDto schoolDto) {
        if (JsonUtils.checkObjAllFieldsIsNull(schoolDto)) {
            return HQJsonResult.error(SystemErrorEnum.SYSTEM_ERROR);
        }
        List<SysOrganEntity> organEntityList = commonDao.selectOrganByUserId(schoolDto);
        if (!organEntityList.isEmpty()){
            return HQJsonResult.success(organEntityList);
        }
        return new HQJsonResult();
    }
}
