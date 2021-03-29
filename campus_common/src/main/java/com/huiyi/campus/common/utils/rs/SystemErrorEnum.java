package com.huiyi.campus.common.utils.rs;

import org.apache.commons.lang3.StringUtils;
import com.huiyi.campus.common.utils.rs.CodeMessage;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 系统异常枚举
 * @date: 2021-03-29 14:42
 * @Version V1.0
 */
public enum SystemErrorEnum implements CodeMessage {
    SYSTEM_ERROR("-1", "系统异常，请稍后再试"),
    SYSTEM_NULL_ERROR("-2", "空指针异常，请检查！"),
    OUTPUT_SYSTEM_ERROR("10000", "服务间调用异常"),
    OUTPUT_SESSION_ERROR("10001", "用户登录超时，请重新登录!"),
    OUTPUT_FILE_IMPORT_ERROR("10006", "文件导入异常"),
    OUTPUT_FILE_EMPTY_ERROR("10007", "找不到文件"),
    OUTPUT_FILE_HANDLE_ERROR("10008", "解析文件异常"),
    OUTPUT_FILE_EXPORT_ERROR("10009", "导出文件失败"),
    OUTPUT_PARAM_EMPTY_ERROR("10010", "入参不能为空"),
    OUTPUT_PARAM_VALIDATE_ERROR("10011", "入参数据校验失败，请检查数据格式"),
    OUTPUT_TIME_CONVERT_ERROR("10012", "时间格式转换异常"),
    OUTPUT_FILE_IMPORT_TYPE_ERROR("10013", "请选择Excel2003或2007文件"),
    OUTPUT_FILE_DATA_EMPTY("10014", "导入的数据为空"),
    OUTPUT_SYSDICT_NO("10092", "未找到对应字典表配置！"),
    CR_ASYNC_CERTIFY_ERROR_1("215", "未知错误"),
    CR_ASYNC_CERTIFY_ERROR_001("216", "签名结果错误"),
    CR_ASYNC_CERTIFY_ERROR_002("217", "版本号不正确"),
    CR_ASYNC_CERTIFY_ERROR_003("218", "时间差异超出范围"),
    CR_ASYNC_CERTIFY_ERROR_005("220", "请求参数不正确"),
    CR_ASYNC_CERTIFY_ERROR_006("221", "IP不在授权范围内"),
    CR_ASYNC_CERTIFY_ERROR_101("222", "身份验证失败"),
    BUSINESS_PARAM_VALID("300", "参数不正确"),
    CR_GET_FPXX_OVER_TIMES_ERROR_002("402", "当日查询超过5次"),
    CR_GET_FPXX_PARAMS_ERROR_006("406", "查询条件不正确"),
    CR_GET_FPXX_REQUEST_VALID_108("418", "请求不规范"),
    CR_GET_FPXX_RESULT_NULL("480", "返回内容为空"),
    CR_GET_FPXX_RESULT_IO_ERROR("481", "网络错误"),
    CR_GET_FPXX_RESULT_CLJG_NULL("482", "返回处理结果为空"),
    CR_GET_FPXX_REQUEST_NULL("483", "解析结果出错"),
    CR_GET_REQ_ERROR("484", "请求参数不正确"),
    AUTH_CUSTOM_ERROR_100("435", "用户不存在"),
    AUTH_CUSTOM_ERROR_101("436", "密码不正确"),
    AUTH_CUSTOM_ERROR_102("437", "该用户无此权限"),
    LOGHTCHECK_LOGIN_ERROR("60001", ""),
    TOO_MUCH_ERROR("9999", "系统限流，请稍后再试"),
    UNKNOWN_ERROR("10000", "未知异常");

    private String msg;
    private String code;

    public static SystemErrorEnum getByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        } else {
            SystemErrorEnum[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                SystemErrorEnum errorEnum = var1[var3];
                if (errorEnum.getCode().equals(code)) {
                    return errorEnum;
                }
            }

            return null;
        }
    }

    private SystemErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String getCodeAsString() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.msg;
    }
}
