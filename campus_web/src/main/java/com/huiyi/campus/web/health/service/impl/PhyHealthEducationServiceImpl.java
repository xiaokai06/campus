package com.huiyi.campus.web.health.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiyi.campus.common.base.CrRpcResult;
import com.huiyi.campus.common.base.ResultBody;
import com.huiyi.campus.common.consts.CommConstants;
import com.huiyi.campus.dao.dto.health.PhyHealthEduDto;
import com.huiyi.campus.dao.entity.phy.PhyHealthEducationEntity;
import com.huiyi.campus.dao.pojo.web.health.PhyHealthEducationDao;
import com.huiyi.campus.dao.vo.health.PhyHealthEduVo;
import com.huiyi.campus.dao.vo.sys.TokenVo;
import com.huiyi.campus.web.health.service.PhyHealthEducationService;
import com.huiyi.campus.web.sys.service.UserCacheService;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.http.Method;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yzg
 * @time: 2021-04-14 14:36
 * @description: 健康宣教
 */
@Slf4j
@Service
public class PhyHealthEducationServiceImpl implements PhyHealthEducationService {

    MinioClient minioClient;
    @Value("${minio.bucketImageName}")
    private String bucketImageName;
    @Value("${minio.healthEduImage}")
    private String healthEduImage;
    PhyHealthEducationDao phyHealthEducationDao;
    UserCacheService userCacheService;

    PhyHealthEducationServiceImpl(PhyHealthEducationDao phyHealthEducationDao, MinioClient minioClient,
                                  UserCacheService userCacheService) {
        this.minioClient = minioClient;
        this.userCacheService = userCacheService;
        this.phyHealthEducationDao = phyHealthEducationDao;
    }

    /**
     * 查询所有健康宣教
     * @param phyHealthEduDto 参数
     * @return 返回值
     */
    @Override
    public CrRpcResult selectHealthEducation(PhyHealthEduDto phyHealthEduDto, String nickName) {
        TokenVo tokenVo = userCacheService.getUserCache(nickName);
        phyHealthEduDto.setSchoolId(tokenVo.getSchoolId());
        phyHealthEduDto.setOrganId(tokenVo.getOrganId());
        phyHealthEduDto.setStartTime(phyHealthEduDto.getCreateTime() + " 00:00:00");
        phyHealthEduDto.setEndTime(phyHealthEduDto.getCreateTime() + " 23:59:59");
        Integer pageNum = phyHealthEduDto.getPageNum();
        Integer pageSize = phyHealthEduDto.getPageSize();
        if (null != pageNum && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
        }
        List<PhyHealthEducationEntity> list = phyHealthEducationDao.selectHealthEducation(phyHealthEduDto);
        List<PhyHealthEduVo> resultList = new ArrayList<>();
        for (PhyHealthEducationEntity phyHealthEducationEntity : list) {
            PhyHealthEduVo phyHealthEduVo = new PhyHealthEduVo();
            BeanUtils.copyProperties(phyHealthEducationEntity, phyHealthEduVo);
            resultList.add(phyHealthEduVo);
        }
        PageInfo<PhyHealthEduVo> pageInfo = new PageInfo<>(resultList);
        return CrRpcResult.success(pageInfo);
    }

    /**
     * 新增健康宣教
     * @param phyHealthEduDto 参数
     * @return 返回值
     */
    @Override
    public ResultBody insertHealthEducation(PhyHealthEduDto phyHealthEduDto, String nickName) {
        PhyHealthEducationEntity phyHealthEducationEntity = new PhyHealthEducationEntity();
        BeanUtils.copyProperties(phyHealthEduDto, phyHealthEducationEntity);
        TokenVo tokenVo = userCacheService.getUserCache(nickName);
        phyHealthEducationEntity.setSchoolId(tokenVo.getSchoolId());
        phyHealthEducationEntity.setOrganId(tokenVo.getOrganId());
        int count = phyHealthEducationDao.insertHealthEducation(phyHealthEducationEntity);
        int id = phyHealthEducationEntity.getId();
        return ResultBody.insert(count, id);
    }

    /**
     * 修改健康宣教
     * @param phyHealthEduDto 参数
     * @return 返回值
     */
    @Override
    public ResultBody updateHealthEducation(PhyHealthEduDto phyHealthEduDto, String nickName) {
        PhyHealthEducationEntity phyHealthEducationEntity = new PhyHealthEducationEntity();
        BeanUtils.copyProperties(phyHealthEduDto, phyHealthEducationEntity);
        TokenVo tokenVo = userCacheService.getUserCache(nickName);
        phyHealthEducationEntity.setSchoolId(tokenVo.getSchoolId());
        phyHealthEducationEntity.setOrganId(tokenVo.getOrganId());
        int count = phyHealthEducationDao.updateHealthEducation(phyHealthEducationEntity);
        return ResultBody.update(count);
    }

    /**
     * 删除健康宣教
     * @param id 参数
     * @return 返回值
     */
    @Override
    public ResultBody deleteHealthEducation(Integer id) {
        return ResultBody.delete(phyHealthEducationDao.deleteHealthEducation(id));
    }

    /**
     * 通过ID存储相应的图片
     * @param file
     * @return
     */
    @Override
    public ResultBody upLoadImage(MultipartFile file, String type) {
        try {
            String fileName = file.getOriginalFilename();
            String imageUrl = healthEduImage + CommConstants.SLASH + type + CommConstants.SLASH + System.currentTimeMillis() + CommConstants.SLASH + fileName;
            InputStream inputStream = file.getInputStream();
            minioClient.putObject(
                    PutObjectArgs.builder().bucket(bucketImageName).object(imageUrl).stream(
                            inputStream, file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build());
            if (StringUtils.isNoneEmpty(fileName)) {
                String url = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                        .method(Method.GET)
                        .bucket(bucketImageName)
                        .object(imageUrl)
                        .build());
                log.info(type + " ==== 宣教相片路径为：" + url);
                return ResultBody.success(url);
            }
        } catch (Exception e) {
            throw new RuntimeException(type + " ==== 宣教图片上传异常：" + e.getMessage());
        }
        return ResultBody.success();
    }

    @Override
    public ResultBody downLoadImage(Integer id) {
        PhyHealthEduDto phyHealthEduDto = new PhyHealthEduDto();
        phyHealthEduDto.setId(id);
        List<PhyHealthEducationEntity> list = phyHealthEducationDao.selectHealthEducation(phyHealthEduDto);
        if (!CollectionUtils.isEmpty(list)) {
            PhyHealthEducationEntity phyHealthEducationEntity = list.get(0);
            if (!StringUtils.isEmpty(phyHealthEducationEntity.getImageUrl())) {
                try {
                    String url = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket(bucketImageName)
                            .object(phyHealthEducationEntity.getImageUrl())
                            .expiry(60 * 60 * 24 * 7)
                            .build());
                    log.info("下载宣教图片ID为:" + id + " 宣教图片路径为：" + url);
                    return ResultBody.success(url);
                } catch (Exception e) {
                    throw new RuntimeException("下载宣教图片失败，id为：" + id +", 失败原因是：" + e.getMessage());
                }
            }
        }
        return ResultBody.success();
    }
}
