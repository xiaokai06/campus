package com.huiyi.campus;

import com.huiyi.campus.common.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 校园健康管理系统核心启动类
 * @date: 2021-02-23 15:20
 * @Version V1.0
 */
@Slf4j
//@EnableDiscoveryClient
@ServletComponentScan
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "com.huiyi.campus")
@MapperScan("com.huiyi.campus.dao.mapper")
public class CampusStartApplication implements WebMvcConfigurer {

    @Bean
    public SpringUtil getSpingUtil() {
        return new SpringUtil();
    }

    public static void main(String[] args) {
        SpringApplication.run(CampusStartApplication.class, args);
        log.info(
                "\n\n\n\n\n                                                                                                                                   dddddddd\n"
                        + "                          tttt                                                         tttt                                          d::::::d\n"
                        + "                       ttt:::t                                                      ttt:::t                                          d::::::d\n"
                        + "                       t:::::t                                                      t:::::t                                          d::::::d\n"
                        + "                       t:::::t                                                      t:::::t                                          d:::::d \n"
                        + "    ssssssssss   ttttttt:::::ttttttt      aaaaaaaaaaaaa   rrrrr   rrrrrrrrr   ttttttt:::::ttttttt        eeeeeeeeeeee        ddddddddd:::::d \n"
                        + "  ss::::::::::s  t:::::::::::::::::t      a::::::::::::a  r::::rrr:::::::::r  t:::::::::::::::::t      ee::::::::::::ee    dd::::::::::::::d \n"
                        + "ss:::::::::::::s t:::::::::::::::::t      aaaaaaaaa:::::a r:::::::::::::::::r t:::::::::::::::::t     e::::::eeeee:::::ee d::::::::::::::::d \n"
                        + "s::::::ssss:::::stttttt:::::::tttttt               a::::a rr::::::rrrrr::::::rtttttt:::::::tttttt    e::::::e     e:::::ed:::::::ddddd:::::d \n"
                        + " s:::::s  ssssss       t:::::t              aaaaaaa:::::a  r:::::r     r:::::r      t:::::t          e:::::::eeeee::::::ed::::::d    d:::::d \n"
                        + "   s::::::s            t:::::t            aa::::::::::::a  r:::::r     rrrrrrr      t:::::t          e:::::::::::::::::e d:::::d     d:::::d \n"
                        + "      s::::::s         t:::::t           a::::aaaa::::::a  r:::::r                  t:::::t          e::::::eeeeeeeeeee  d:::::d     d:::::d \n"
                        + "ssssss   s:::::s       t:::::t    tttttta::::a    a:::::a  r:::::r                  t:::::t    tttttte:::::::e           d:::::d     d:::::d \n"
                        + "s:::::ssss::::::s      t::::::tttt:::::ta::::a    a:::::a  r:::::r                  t::::::tttt:::::te::::::::e          d::::::ddddd::::::dd\n"
                        + "s::::::::::::::s       tt::::::::::::::ta:::::aaaa::::::a  r:::::r                  tt::::::::::::::t e::::::::eeeeeeee   d:::::::::::::::::d\n"
                        + " s:::::::::::ss          tt:::::::::::tt a::::::::::aa:::a r:::::r                    tt:::::::::::tt  ee:::::::::::::e    d:::::::::ddd::::d\n"
                        + "  sssssssssss              ttttttttttt    aaaaaaaaaa  aaaa rrrrrrr                      ttttttttttt      eeeeeeeeeeeeee     ddddddddd   ddddd\n\n\n\n\n");

    }

    /**
     * 跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*");
    }
}
