package com.huiyi.campus.web.health.controller;

import com.huiyi.campus.common.annotaion.IsLogin;
import com.huiyi.campus.common.utils.JsonUtils;
import com.huiyi.campus.common.utils.rs.HQJsonResult;
import com.huiyi.campus.common.utils.rs.SystemErrorEnum;
import com.huiyi.campus.dao.dto.health.ExportStudentInfoDto;
import com.huiyi.campus.dao.dto.health.StudentHealthInfoDto;
import com.huiyi.campus.dao.dto.health.StudentInfoRecordDto;
import com.huiyi.campus.dao.entity.phy.PhyStudentInfoEntity;
import com.huiyi.campus.dao.vo.health.ImageVo;
import com.huiyi.campus.web.health.service.CampusHRecordService;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 校园健康档案服务控制台模块
 * @date: 2021-03-28 13:35
 * @Version V1.0
 */
@Api(tags = "校园健康档案服务")
@Slf4j
@RestController
@RequestMapping("/hrecord")
public class CampusHRecordController {

    @Value("${minio.bucketImageName}")
    private String bucketImageName;
    @Value("${minio.studentImage}")
    private String studentImage;
    @Autowired
    CampusHRecordService campusHRecordService;
    @Autowired
    MinioClient minioClient;


    /**
     * 获取所有学生档案信息
     *
     * @param studentInfoRecordDto
     * @return
     */
    @IsLogin
    @ApiOperation("获取所有学生档案信息接口")
    @PostMapping("/queryStudentInfoRecord")
    public HQJsonResult queryStudentInfoRecord(@RequestBody StudentInfoRecordDto studentInfoRecordDto) {
        return campusHRecordService.queryStudentInfoRecord(studentInfoRecordDto);
    }

    /**
     * 查询学生档案信息
     *
     * @param studentInfoRecordDto
     * @return
     */
    @IsLogin
    @PostMapping("/selectStudentInfoRecord")
    public HQJsonResult selectStudentInfoRecord(@RequestBody StudentInfoRecordDto studentInfoRecordDto) {
        return campusHRecordService.selectStudentInfoRecord(studentInfoRecordDto);
    }


    /**
     * 创建学生档案信息
     *
     * @return
     */
    @IsLogin
    @ApiOperation("创建学生档案信息接口")
    @PostMapping("/createStudentInfoRecord")
    public HQJsonResult createStudentInfoRecord(@RequestBody StudentInfoRecordDto studentInfoRecordDto) {
        return campusHRecordService.createStudentInfoRecord(studentInfoRecordDto);
    }

    /**
     * 修改学生档案信息
     *
     * @param studentInfoRecordDto
     * @return
     */
    @IsLogin
    @ApiOperation("修改学生档案信息接口")
    @PostMapping("/updateStudentInfoRecord")
    public HQJsonResult updateStudentInfoRecord(@RequestBody StudentInfoRecordDto studentInfoRecordDto) {
        return campusHRecordService.updateStudentInfoRecord(studentInfoRecordDto);
    }

    /**
     * 删除学生档案信息
     *
     * @param studentInfoRecordDto
     * @return
     */
    @IsLogin
    @ApiOperation("删除学生档案信息接口")
    @PostMapping("/deleteStudentInfoRecord")
    public HQJsonResult deleteStudentInfoRecord(@RequestBody StudentInfoRecordDto studentInfoRecordDto) {
        return campusHRecordService.deleteStudentInfoRecord(studentInfoRecordDto);
    }

    /**
     * 创建学生健康档案信息
     *
     * @return
     */
    @IsLogin
    @ApiOperation("创建学生健康档案信息接口")
    @PostMapping("/createStudentHealthInfo")
    public HQJsonResult createStudentHealthInfo(@RequestBody StudentHealthInfoDto studentHealthInfoDto) {
        return campusHRecordService.createStudentHealthInfo(studentHealthInfoDto);
    }

    /**
     * 查询学生健康档案信息
     *
     * @param studentHealthInfoDto
     * @return
     */
    @IsLogin
    @ApiOperation("查询学生健康档案信息接口")
    @PostMapping("/selectStudentHealthInfo")
    public HQJsonResult selectStudentHealthInfo(@RequestBody StudentHealthInfoDto studentHealthInfoDto) {
        return campusHRecordService.selectStudentHealthInfo(studentHealthInfoDto);
    }


    /**
     * 修改学生健康档案信息
     *
     * @param studentHealthInfoDto
     * @return
     */
    @IsLogin
    @ApiOperation("修改学生健康档案信息接口")
    @PostMapping("/updateStudentHealthInfo")
    public HQJsonResult updateStudentHealthInfo(@RequestBody StudentHealthInfoDto studentHealthInfoDto) {
        return campusHRecordService.updateStudentHealthInfo(studentHealthInfoDto);
    }

    /**
     * 学生档案信息数据导入
     *
     * @param file
     * @return
     */
    @IsLogin
    @ApiOperation("学生档案信息数据导入接口")
    @ResponseBody
    @PostMapping("/importStudentInfoFile")
    public String importStudentInfoFile(@RequestParam("file") MultipartFile file) {
        return campusHRecordService.importStudentInfoFile(file);
    }

    /**
     * 学生档案信息数据导出
     *
     * @param exportStudentInfoDto
     * @param response
     * @return
     */

    @ApiOperation("学生档案信息数据导出接口")
    @ResponseBody
    @PostMapping("/exportStudentInfoFile")
    public String exportStudentInfoFile(@RequestBody ExportStudentInfoDto exportStudentInfoDto, HttpServletResponse response) {
        return campusHRecordService.exportStudentInfoFile(exportStudentInfoDto, response);
    }

    /**
     * 学生相片上传
     */
    @IsLogin
    @ApiOperation("学生相片上传接口")
    @PostMapping("/upload")
    public HQJsonResult upload(@RequestParam("studentId") String studentId, @RequestParam("data") MultipartFile data) throws Exception {
        String fileName = data.getOriginalFilename();
        InputStream inputStream = data.getInputStream();
        minioClient.putObject(
                PutObjectArgs.builder().bucket(bucketImageName).object(studentImage + "/" + studentId + "/" + fileName).stream(
                        inputStream, data.getSize(), -1)
                        .contentType(data.getContentType())
                        .build());
        StudentInfoRecordDto studentInfoRecordDto = new StudentInfoRecordDto();
        studentInfoRecordDto.setId(studentId);
        studentInfoRecordDto.setImage(studentImage + "/" + studentId + "/" + fileName);
        campusHRecordService.updateStudentInfoRecord(studentInfoRecordDto);
        ImageVo imageVo = new ImageVo();
        if (StringUtils.isNoneEmpty(fileName)) {
            String url = minioClient.presignedGetObject(bucketImageName, studentInfoRecordDto.getImage(), 60 * 60 * 24 * 7);
            log.info("学生ID为:" + studentId + " 学生相片地址为：" + url);
            imageVo.setUrl(url);
        }
        return HQJsonResult.success(imageVo);
    }

    /**
     * 学生相片下载
     *
     * @param fileName
     * @return
     * @throws Exception
     */
    @IsLogin
    @ApiOperation("学生相片下载接口")
    @PostMapping("/download")
    public HQJsonResult download(@RequestParam("fileName") String fileName, @RequestParam("studentId") String studentId) throws Exception {
        PhyStudentInfoEntity phyStudentInfoEntity = campusHRecordService.selectByStudentId(studentId);
        if (JsonUtils.checkObjAllFieldsIsNull(phyStudentInfoEntity)) {
            return HQJsonResult.error(SystemErrorEnum.CR_GET_REQ_ERROR);
        }
        if (StringUtils.isNoneEmpty(fileName)) {
            String url = minioClient.presignedGetObject(bucketImageName, fileName, 60 * 60 * 24 * 7);
            log.info("学生ID为:" + phyStudentInfoEntity.getId() + " 下载学生相片地址为：" + url);
            ImageVo imageVo = new ImageVo();
            imageVo.setUrl(url);
            return HQJsonResult.success(imageVo);
        }
        return HQJsonResult.error(SystemErrorEnum.OUTPUT_SYSTEM_ERROR);
    }

    /**
     * 根据学生id查询体检日期
     *
     * @param studentHealthInfoDto
     * @return
     */
    @IsLogin
    @PostMapping("/selectPhyDateByPhyStudentId")
    public HQJsonResult selectPhyDateByPhyStudentId(@RequestBody StudentHealthInfoDto studentHealthInfoDto) {
        return campusHRecordService.selectPhyDateByPhyStudentId(studentHealthInfoDto);
    }

}
