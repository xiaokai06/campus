package com.huiyi.campus.dao.dto.health;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 校园健康档案dto
 * @date: 2021-03-28 13:55
 * @Version V1.0
 */
@Getter
@Setter
@ApiModel("学生档案信息请求Dto")
public class StudentInfoRecordDto {
    @ApiModelProperty("学生id")
    private String id;
    @ApiModelProperty("学生姓名")
    private String studentName;
    @ApiModelProperty("性别(1:男，2:女，0:未知性别)")
    private Integer sex;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("出生日期")
    private String birthDate;
    @ApiModelProperty("父母id")
    private String parentId;
    @ApiModelProperty("学校机构id")
    private String schoolId;
    @ApiModelProperty("教育局机构id")
    private String organId;
    @ApiModelProperty("学生编号（学号）")
    private String studentNumber;
    @ApiModelProperty("年级id")
    private String gradeId;
    @ApiModelProperty("班级id")
    private String classId;
    @ApiModelProperty("国籍 0本国国籍 1外国国籍")
    private Byte nationality;
    @ApiModelProperty("身份证号")
    private String idCard;
    @ApiModelProperty("联系电话")
    private String phoneNumber;
    @ApiModelProperty("相片")
    private String image;
    @ApiModelProperty("家庭住址省")
    private String familyAddressProv;
    @ApiModelProperty("家庭住址市")
    private String familyAddressCity;
    @ApiModelProperty("家庭住址区")
    private String familyAddressArea;
    @ApiModelProperty("家庭详细住址")
    private String familyAddress;
    @ApiModelProperty("户籍地址省")
    private String censusAddresspRrov;
    @ApiModelProperty("户籍地址市")
    private String censusAddresspCity;
    @ApiModelProperty("户籍地址区")
    private String censusAddresspArea;
    @ApiModelProperty("户籍详细地址")
    private String censusAddress;
    @ApiModelProperty("入学时间")
    private String enterTime;
    @ApiModelProperty("建档人id（校医）")
    private Integer doctorId;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("责任医生")
    private String dutyDoctor;
    @ApiModelProperty("建档日期")
    private String phyFileDate;
    @ApiModelProperty("操作人员id (注：当前操作人员)")
    private Integer operatorId;
    @ApiModelProperty("页码")
    private Integer page;
    @ApiModelProperty("条数")
    private Integer rows;


/*
    @ApiModelProperty("机构id-list")
    private List<String> orgIdList;
    @ApiModelProperty("学校id-list")
    private List<String> schoolIdList;*/

}
