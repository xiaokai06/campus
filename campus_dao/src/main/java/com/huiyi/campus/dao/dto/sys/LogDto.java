package com.huiyi.campus.dao.dto.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yzg
 * @time: 2021-05-11 16:17
 * @description: 日志筛选条件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDto {

    private String ip;

    private String name;

    private Integer pageNum;

    private Integer pageSize;

}
