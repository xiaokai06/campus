package com.huiyi.campus.dao.vo.sys;

import com.huiyi.campus.dao.entity.sys.SysSchoolEntity;
import io.swagger.annotations.ApiModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-27 11:33
 * @description: 学校-机构
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@ApiModel("学校机构返回实体类")
public class SchoolOrganVo {

    private Integer organId;

    private String organName;

    private List<SysSchoolEntity> list;

}
