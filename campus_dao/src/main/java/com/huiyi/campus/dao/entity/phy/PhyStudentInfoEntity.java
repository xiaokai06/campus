package com.huiyi.campus.dao.entity.phy;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 学生信息表
 * @date: 2021-03-28 13:38
 * @Version V1.0
 */
@Getter
@Setter
@TableName("phy_student_info")
public class PhyStudentInfoEntity implements Serializable {

    @ApiModelProperty("主键id")
    private String id;
    @ApiModelProperty("姓名")
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
    private Integer schoolId;
    @ApiModelProperty("教育局机构id")
    private Integer organId;
    @ApiModelProperty("学生编号")
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
    private String censusAddressProv;
    @ApiModelProperty("户籍地址市")
    private String censusAddressCity;
    @ApiModelProperty("户籍地址区")
    private String censusAddressArea;
    @ApiModelProperty("户籍详细地址")
    private String censusAddress;
    @ApiModelProperty("入学时间")
    private String enterTime;
    @ApiModelProperty("建档人id（校医）")
    private Integer doctorId;
    @ApiModelProperty("责任医生")
    private String dutyDoctor;
    @ApiModelProperty("建档日期")
    private String phyFileDate;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("更新时间")
    private String updateTime;
    @ApiModelProperty("操作人员id (注：当前操作人员)")
    private Integer operatorId;
    private Integer delFlag;
    @ApiModelProperty("扩展字段1")
    private String extend1;
    @ApiModelProperty("扩展字段2")
    private String extend2;
    @ApiModelProperty("扩展字段3")
    private String extend3;
    @ApiModelProperty("扩展字段4")
    private String extend4;
    @ApiModelProperty("扩展字段5")
    private String extend5;

    private static final long serialVersionUID = 1L;

}