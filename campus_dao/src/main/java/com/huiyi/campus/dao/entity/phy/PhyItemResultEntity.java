package com.huiyi.campus.dao.entity.phy;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 健康体检检验项目结果表
 * @date: 2021-03-28 13:38
 * @Version V1.0
 */
@Getter
@Setter
@TableName("phy_item_result")
public class PhyItemResultEntity implements Serializable {
    private String id;

    private String phyHealthId;

    private Integer rptunitid;

    private Integer rptItemid;

    private Integer resultNum;

    private String resultStr;

    private String resultTxt;

    private String resultUnit;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    private String extend1;

    private String extend2;

    private static final long serialVersionUID = 1L;

}