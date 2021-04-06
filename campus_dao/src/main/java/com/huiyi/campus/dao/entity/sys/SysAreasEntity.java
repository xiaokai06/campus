package com.huiyi.campus.dao.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@TableName("sys_areas")
public class SysAreasEntity implements Serializable {

    private Integer id;

    private String name;

    private String pid;

    private static final long serialVersionUID = 1L;


}