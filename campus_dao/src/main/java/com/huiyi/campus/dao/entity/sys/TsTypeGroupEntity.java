package com.huiyi.campus.dao.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@TableName("t_s_typegroup")
public class TsTypeGroupEntity implements Serializable {

    private Integer id;

    private String typegroupcode;

    private String typegroupname;

    private static final long serialVersionUID = 1L;

}