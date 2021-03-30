package com.huiyi.campus.common.enums;
/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: Excel 类型枚举
 * @date: 2021-03-22 15:08
 * @Version V1.0
 */
public enum ExcelTypeEnum {
    XLS("xls"), XLSX("xlsx");
    private String value;

    ExcelTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
