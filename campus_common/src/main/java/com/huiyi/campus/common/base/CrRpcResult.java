package com.huiyi.campus.common.base;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * web通用返回数据
 * @author lucky
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@ApiModel("通用返回类")
public class CrRpcResult<T> {

    @ApiModelProperty("响应状态码")
    private String code;

    @ApiModelProperty("响应消息")
    private String message;

    @ApiModelProperty("总条数")
    private long total;

    @ApiModelProperty("数据")
    private List<T> data;

    public static CrRpcResult success(PageInfo pageInfo) {
        CrRpcResult crRpcResult = new CrRpcResult();
        crRpcResult.setCode(CommonEnum.SUCCESS.getResultCode());
        crRpcResult.setMessage(CommonEnum.SUCCESS.getResultMsg());
        crRpcResult.setTotal(pageInfo.getList().size());
        crRpcResult.setData(pageInfo.getList());
        return crRpcResult;
    }

}
