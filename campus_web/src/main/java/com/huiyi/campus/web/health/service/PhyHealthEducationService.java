package com.huiyi.campus.web.health.service;

import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.dao.dto.health.PhyHealthEduDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: yzg
 * @time: 2021-04-14 14:35
 * @description: 健康宣教
 */
public interface PhyHealthEducationService {

    /**
     * 查询所有健康宣教
     * @param phyHealthEduDto 参数
     * @return 返回值
     */
    CrRpcResult selectHealthEducation(PhyHealthEduDto phyHealthEduDto, String nickName);

    /**
     * 新增健康宣教
     * @param phyHealthEduDto 参数
     * @param nickName 昵称
     * @return 返回值
     */
    ResultBody insertHealthEducation(PhyHealthEduDto phyHealthEduDto, String nickName);

    /**
     * 修改健康宣教
     * @param phyHealthEduDto 参数
     * @param nickName 昵称
     * @return 返回值
     */
    ResultBody updateHealthEducation(PhyHealthEduDto phyHealthEduDto, String nickName);

    /**
     * 删除健康宣教
     * @param id 参数
     * @return 返回值
     */
    ResultBody deleteHealthEducation(Integer id);

    /**
     * 上传图片
     * @param file
     * @param type
     * @return
     */
    ResultBody upLoadImage(MultipartFile file, String type);

    /**
     * 根据ID下载宣教图片
     * @param id
     * @return
     */
    ResultBody downLoadImage(Integer id);

}
