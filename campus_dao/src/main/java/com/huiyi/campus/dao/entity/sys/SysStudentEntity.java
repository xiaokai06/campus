package com.huiyi.campus.dao.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Setter
@Getter
@TableName("sys_student")
public class SysStudentEntity implements Serializable {
    private Integer id;

    private String userName;

    private Integer parentId;

    private Integer age;

    private Byte sex;

    private Integer schoolId;

    private Integer classId;

    private String idCard;

    private String familyAddress;

    private Date enterTime;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

}