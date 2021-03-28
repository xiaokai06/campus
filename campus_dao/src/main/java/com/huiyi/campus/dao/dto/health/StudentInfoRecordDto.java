package com.huiyi.campus.dao.dto.health;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 校园健康档案dto
 * @date: 2021-03-28 13:55
 * @Version V1.0
 */
@Getter
@Setter
@ApiModel("校园健康档案")
public class StudentInfoRecordDto {

    @ApiModelProperty("学生姓名")
    private String userName;
    @ApiModelProperty("性别(1:男，2:女，0:未知性别)")
    private Integer sex;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("出生日期")
    private Date birthDate;
    @ApiModelProperty("父母id")
    private String parentId;
    @ApiModelProperty("学校机构id")
    private Integer schoolId;
    @ApiModelProperty("学生编号")
    private String studentNumber;
    @ApiModelProperty("专业班级")
    private String majorClass;
    @ApiModelProperty("班级id")
    private String classId;
    @ApiModelProperty("身份证号")
    private String idCard;
    @ApiModelProperty("联系电话")
    private String phoneNumber;
    @ApiModelProperty("相片")
    private String image;
    @ApiModelProperty("家庭住址")
    private String familyAddress;
    @ApiModelProperty("户籍地址")
    private String censusAddress;
    @ApiModelProperty("入学时间")
    private Date enterTime;
    @ApiModelProperty("建档人id（校医）")
    private Integer doctorId;
    @ApiModelProperty("责任医生")
    private String dutyDoctor;
    @ApiModelProperty("体检日期")
    private Date phyDate;
    @ApiModelProperty("操作人员id (注：当前操作人员)")
    private Integer operatorId;

}