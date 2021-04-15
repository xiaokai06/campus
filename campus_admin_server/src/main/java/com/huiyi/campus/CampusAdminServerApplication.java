package com.huiyi.campus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 监控服务器启动类
 * @date: 2021-04-03 18:14
 * @Version V1.0
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class CampusAdminServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CampusAdminServerApplication.class, args);
    }
}
