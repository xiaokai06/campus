package com.huiyi.campus.demo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021/5/19 4:52 下午
 * @Version V1.0
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ItemDto {
    private String id;
    private String itemCode;
    private String itemName;
    private String itemResult;
    private String resultText;
    private String itemUnit;
    private String itemArea;

}
