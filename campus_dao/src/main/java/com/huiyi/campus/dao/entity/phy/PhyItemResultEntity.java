package com.huiyi.campus.dao.entity.phy;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
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

    @ApiModelProperty("主键id")
    private String id;
    @ApiModelProperty("健康体检报告id")
    private String phyHealthId;
    @ApiModelProperty("报告单元 (0血常规  1肝功能)")
    private Integer rptunitid;
    @ApiModelProperty("报告项目id（0 血清谷丙转氨酶, 1 血清谷草转氨酶, 2 白蛋白, 3 总胆红素, 4 结合胆红素, 5 血红蛋白, 6 白细胞, 7 血小板, 8 其他）")
    private Integer rptItemid;
    @ApiModelProperty("检验数值结果")
    private String resultNum;
    @ApiModelProperty("检验结果文本")
    private String resultStr;
    @ApiModelProperty("结果标识（存储上下箭头标识）")
    private String resultTxt;
    @ApiModelProperty("单位")
    private String resultUnit;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("创建人")
    private String createUser;
    @ApiModelProperty("修改时间")
    private Date updateTime;
    @ApiModelProperty("修改人")
    private String updateUser;
    @ApiModelProperty("扩展字段")
    private String extend1;
    @ApiModelProperty("扩展字段2")
    private String extend2;

    private static final long serialVersionUID = 1L;

}