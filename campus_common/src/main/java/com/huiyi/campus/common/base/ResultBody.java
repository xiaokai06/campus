package com.huiyi.campus.common.base;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author pancm
 * @Title: ResultBody
 * @Description: 返回格式
 * @Version:1.0.0
 * @date 2018年3月7日
 */
@ApiModel("返回结果集")
public class ResultBody {

    /**
     * 响应代码
     */
    @ApiModelProperty("响应代码")
    private String code;

    /**
     * 响应消息
     */
    @ApiModelProperty("响应消息")
    private String message;

    /**
     * 响应结果
     */
    @ApiModelProperty("响应结果")
    private Object result;

    public ResultBody() {
    }

    public ResultBody(BaseErrorInfoInterface errorInfo) {
        this.code = errorInfo.getResultCode();
        this.message = errorInfo.getResultMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * 成功
     *
     * @return
     */
    public static ResultBody success() {
        return success(null);
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static ResultBody success(Object data) {
        ResultBody rb = new ResultBody();
        rb.setCode(CommonEnum.SUCCESS.getResultCode());
        rb.setMessage(CommonEnum.SUCCESS.getResultMsg());
        rb.setResult(data);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(BaseErrorInfoInterface errorInfo) {
        ResultBody rb = new ResultBody();
        rb.setCode(errorInfo.getResultCode());
        rb.setMessage(errorInfo.getResultMsg());
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(String code, String message) {
        ResultBody rb = new ResultBody();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    /**
     * 登录超时
     */
    public static ResultBody loginTimeOut() {
        ResultBody rb = new ResultBody();
        rb.setCode(CommonEnum.LOGIN_TIMEOUT.getResultCode());
        rb.setMessage(CommonEnum.LOGIN_TIMEOUT.getResultMsg());
        rb.setResult(CommonEnum.LOGIN_TIMEOUT.getResultMsg());
        return rb;
    }

    /**
     * 用户名或密码输入错误，请重新登录
     * @return
     */
    public static ResultBody userPwdError() {
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(CommonEnum.USER_PWD_ERROR.getResultCode());
        resultBody.setMessage(CommonEnum.USER_PWD_ERROR.getResultMsg());
        resultBody.setResult(null);
        return resultBody;
    }

    /**
     * 无效token，无法登录
     * @return
     */
    public static ResultBody invalidToken() {
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(CommonEnum.INVALID_TOKEN.getResultCode());
        resultBody.setMessage(CommonEnum.INVALID_TOKEN.getResultMsg());
        resultBody.setResult(null);
        return resultBody;
    }

    /**
     * 新增数据
     */
    public static ResultBody insert(Integer count, Integer id) {
        if (count > 0) {
            return ResultBody.success(id);
        }
        return ResultBody.error("新增失败");
    }

    /**
     * 修改数据
     */
    public static ResultBody update(Integer count) {
        if (count > 0) {
            return ResultBody.success("修改成功");
        }
        return ResultBody.error("修改失败");
    }

    /**
     * 删除数据
     */
    public static ResultBody delete(Integer count) {
        if (count > 0) {
            return ResultBody.success("删除成功");
        }
        return ResultBody.error("删除失败");
    }

    /**
     * 用户昵称重复
     */
    public static ResultBody repetition() {
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(CommonEnum.REPETITION.getResultCode());
        resultBody.setMessage(CommonEnum.REPETITION.getResultMsg());
        resultBody.setResult(null);
        return resultBody;
    }


    /**
     * 失败
     */
    public static ResultBody error(String message) {
        ResultBody rb = new ResultBody();
        rb.setCode(CommonEnum.INTERNAL_SERVER_ERROR.getResultCode());
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
