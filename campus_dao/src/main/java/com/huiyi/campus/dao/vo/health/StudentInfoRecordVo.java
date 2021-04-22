package com.huiyi.campus.dao.vo.health;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-03-28 20:43
 * @Version V1.0
 */
@Getter
@Setter
@ApiModel("学生档案信息返回Vo")
public class StudentInfoRecordVo {

    @Excel(name = "学号")
    @ApiModelProperty("主键id")
    private String id;

    @Excel(name = "学生姓名")
    @ApiModelProperty("学生姓名")
    private String studentName;

    @Excel(name = "性别")
    @ApiModelProperty("性别(1:男，2:女，0:未知性别)")
    private Integer sex;

    @Excel(name = "年龄")
    @ApiModelProperty("年龄")
    private Integer age;

    @Excel(name = "出生日期")
    @ApiModelProperty("出生日期")
    private String birthDate;

    @Excel(name = "父母id")
    @ApiModelProperty("父母id")
    private String parentId;

    @Excel(name = "父母名称")
    @ApiModelProperty("父母名称")
    private String parentName;

    @ApiModelProperty("教育局机构id")
    private Integer organId;

    @ApiModelProperty("教育机构名称")
    private String organName;

    @ApiModelProperty("学校机构名称")
    private String schoolName;

    @Excel(name = "学校机构id")
    @ApiModelProperty("学校机构id")
    private Integer schoolId;

    @Excel(name = "学生编号")
    @ApiModelProperty("学生编号")
    private String studentNumber;

    @Excel(name = "年级ID")
    @ApiModelProperty("年级ID")
    private String gradeId;

    @Excel(name = "年级名称")
    @ApiModelProperty("年级名称")
    private String gradeName;

    @Excel(name = "班级id")
    @ApiModelProperty("班级id")
    private String classId;

    @Excel(name = "班级名称")
    @ApiModelProperty("班级名称")
    private String className;

    @ApiModelProperty("国籍 0本国国籍 1外国国籍")
    private Byte nationality;

    @Excel(name = "身份证号")
    @ApiModelProperty("身份证号")
    private String idCard;

    @Excel(name = "联系电话")
    @ApiModelProperty("联系电话")
    private String phoneNumber;

    //    @Excel(name = "相片")
    @ApiModelProperty("相片")
    private String image;

    @Excel(name = "家庭住址省")
    @ApiModelProperty("家庭住址省")
    private String familyAddressProv;

    @Excel(name = "家庭住址市")
    @ApiModelProperty("家庭住址市")
    private String familyAddressCity;

    @Excel(name = "家庭住址区")
    @ApiModelProperty("家庭住址区")
    private String familyAddressArea;

    @Excel(name = "家庭住址")
    @ApiModelProperty("家庭住址")
    private String familyAddress;

    @Excel(name = "户籍地址省")
    @ApiModelProperty("户籍地址省")
    private String censusAddressProv;

    @Excel(name = "户籍地址市")
    @ApiModelProperty("户籍地址市")
    private String censusAddressCity;

    @Excel(name = "户籍地址区")
    @ApiModelProperty("户籍地址区")
    private String censusAddressArea;

    @Excel(name = "户籍地址")
    @ApiModelProperty("户籍地址")
    private String censusAddress;

    @Excel(name = "入学时间")
    @ApiModelProperty("入学时间")
    private String enterTime;

    @Excel(name = "建档人id")
    @ApiModelProperty("建档人id（校医）")
    private Integer doctorId;

    @ApiModelProperty("建档人（校医姓名）")
    private String doctorName;

    @Excel(name = "责任医生")
    @ApiModelProperty("责任医生")
    private String dutyDoctor;

    @Excel(name = "建档日期")
    @ApiModelProperty("建档日期")
    private String phyFileDate;

    @Excel(name = "创建时间")
    @ApiModelProperty("创建时间")
    private String createTime;

    @Excel(name = "更新时间")
    @ApiModelProperty("更新时间")
    private String updateTime;

    @Excel(name = "操作人员id")
    @ApiModelProperty("操作人员id (注：当前操作人员)")
    private Integer operatorId;
}
