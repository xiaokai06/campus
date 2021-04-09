package com.huiyi.campus.web.health.controller;

import com.huiyi.campus.common.utils.rs.HQJsonResult;
import com.huiyi.campus.dao.dto.health.StudentHealthInfoDto;
import com.huiyi.campus.dao.dto.health.StudentInfoRecordDto;
import com.huiyi.campus.web.health.service.CampusHRecordService;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
@RestController
@RequestMapping("/hrecord")
public class CampusHRecordController {

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
    @PostMapping("/queryStudentInfoRecord")
    public HQJsonResult queryStudentInfoRecord(@RequestBody StudentInfoRecordDto studentInfoRecordDto) {
        return campusHRecordService.queryStudentInfoRecord(studentInfoRecordDto);
    }

    /**
     * 创建学生档案信息
     *
     * @return
     */
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
    @PostMapping("/deleteStudentInfoRecord")
    public HQJsonResult deleteStudentInfoRecord(@RequestBody StudentInfoRecordDto studentInfoRecordDto) {
        return campusHRecordService.deleteStudentInfoRecord(studentInfoRecordDto);
    }

    /**
     * 创建学生健康档案信息
     *
     * @return
     */
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
    @ResponseBody
    @PostMapping("/importStudentInfoFile")
    public String importStudentInfoFile(@RequestParam("file") MultipartFile file) {
        return campusHRecordService.importStudentInfoFile(file);
    }

    /**
     * 学生档案信息数据导出
     *
     * @param studentInfoRecordDto
     * @param response
     * @return
     */
    @ResponseBody
    @PostMapping("/exportStudentInfoFile")
    public String exportStudentInfoFile(@RequestBody StudentInfoRecordDto studentInfoRecordDto, HttpServletResponse response) {
        return campusHRecordService.exportStudentInfoFile(studentInfoRecordDto, response);
    }

    /**
     * 学生相片上传
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("data") MultipartFile data) throws Exception {
        String fileName = data.getOriginalFilename();
        InputStream inputStream = data.getInputStream();
        minioClient.putObject(
                PutObjectArgs.builder().bucket("campus").object(fileName).stream(
                        inputStream, data.getSize(), -1)
                        .contentType(data.getContentType())
                        .build());
        return "上传成功";
    }

    /**
     * 学生相片下载
     *
     * @param fileName
     * @return
     * @throws Exception
     */
    @PostMapping("/download")
    public String download(@RequestParam("fileName") String fileName) throws Exception {
        if (StringUtils.isNoneEmpty(fileName)) {
            String url = minioClient.presignedGetObject("campus", fileName, 60 * 60 * 24 * 7);
            log.info(url);
            return url;
        }
        return null;
    }


}
