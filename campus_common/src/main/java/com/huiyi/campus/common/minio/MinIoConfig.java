package com.huiyi.campus.common.minio;

import io.minio.MinioClient;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: minio对象存储配置工具类
 * @date: 2021-03-31 18:18
 * @Version V1.0
 */
@Configuration
public class MinIoConfig {
    @Value("${minio.endpoint}")
    private String endpoint;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    @Bean
    public MinioClient minioClient() {
        // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
//        MinioClient minioClient = new MinioClient(endpoint, accessKey, secretKey);
        MinioClient minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
        return minioClient;
    }
}
