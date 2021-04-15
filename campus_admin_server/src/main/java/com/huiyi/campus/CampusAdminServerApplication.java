package com.huiyi.campus;

//import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 监控服务器启动类
 * @date: 2021-04-03 18:14
 * @Version V1.0
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@EnableAdminServer
public class CampusAdminServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CampusAdminServerApplication.class, args);
    }
}
