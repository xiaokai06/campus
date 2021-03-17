### 校园健康管理目录结构
│                      
├─APP_HOME_IS_UNDEFINED（日志文件）
│  └─logs
│          
├─campus_common（公共模块）
│  │  campus_common.iml
│  │  pom.xml
│  │  
│  └─src
│      ├─main
│      │  └─java
│      │      └─com
│      │          └─huiyi
│      │              └─campus
│      │                  └─common
│      │                      ├─annotaion
│      │                      │      IsLogin.java
│      │                      │      OperLog.java
│      │                      │      PassToken.java
│      │                      │      
│      │                      ├─base
│      │                      │      BaseErrorInfoInterface.java
│      │                      │      BatchUpdate.java
│      │                      │      CommonEnum.java
│      │                      │      CrRpcResult.java
│      │                      │      ResultBody.java
│      │                      │      
│      │                      ├─config
│      │                      │      RedisConfig.java
│      │                      │      Swagger2Config.java
│      │                      │      
│      │                      ├─consts
│      │                      │      CommConstants.java
│      │                      │      
│      │                      └─utils
│      │                              DateUtils.java
│      │                              ExcelUtils.java
│      │                              HttpHelper.java
│      │                              IpUtils.java
│      │                              Md5Utils.java
│      │                              PatternUtils.java
│      │                              RedisUtils.java
│      │                              StringUtils.java        
│                 
├─campus_dao（持久化层）
│  │  
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─huiyi
│      │  │          └─campus
│      │  │              └─dao
│      │  │                  │  test.txt
│      │  │                  │  
│      │  │                  ├─applets
│      │  │                  │  │  applets.txt
│      │  │                  │  │  
│      │  │                  │  └─mapper
│      │  │                  │          mapper.txt
│      │  │                  │          
│      │  │                  └─web
│      │  │                      │  web.txt
│      │  │                      │  
│      │  │                      └─mapper
│      │  │                              mapper.txt
│      │  │                              
│      │  └─resources
│      │      └─mapper
│      └─test
│          └─java
├─campus_startup（核心启动类）
│  │  campus_startup.iml
│  │  pom.xml
│  │  
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─huiyi
│      │  │          └─campus
│      │  │              └─startup
│      │  │                      CampusStartApplication.java
│      │  │                      
│      │  └─resources
│      │          application.yml
│      │          log4j.properties
│      │          logback.xml
│      │          mybatis-config.xml
│      │          
│      └─test
│          └─java
├─campus_web（校园健康系统PC后端）
│  │  campus_web.iml
│  │  pom.xml
│  │  
│  └─src
│      ├─main
│      │  └─java
│      │      └─com
│      │          └─huiyi
│      │              └─campus
│      │                  └─web
│      │                      │  test.txt
│      │                      │  
│      │                      ├─data_analysis
│      │                      │  │  data.txt
│      │                      │  │  
│      │                      │  ├─controller
│      │                      │  │      test.txt
│      │                      │  │      
│      │                      │  └─service
│      │                      │      │  test.txt
│      │                      │      │  
│      │                      │      └─impl
│      │                      ├─health_management
│      │                      │  │  health.txt
│      │                      │  │  
│      │                      │  ├─controller
│      │                      │  │      test.txt
│      │                      │  │      
│      │                      │  └─service
│      │                      │      │  test.txt
│      │                      │      │  
│      │                      │      └─impl
│      │                      ├─integrated_management
│      │                      │  │  integrated_management.txt
│      │                      │  │  
│      │                      │  ├─controller
│      │                      │  │      test.txt
│      │                      │  │      
│      │                      │  └─service
│      │                      │      │  test.txt
│      │                      │      │  
│      │                      │      └─impl
│      │                      └─internet_consultation
│      │                          │  internet.txt
│      │                          │  
│      │                          ├─controller
│      │                          │      test.txt
│      │                          │      
│      │                          └─service
│      │                              │  test.txt
│      │                              │  
│      │                              └─impl
│      └─test
│          └─java
└─campus_wx_applets（校园健康系统小程序后端）
│  campus_wx_applets.iml
│  pom.xml
│  
└─src
├─main
│  └─java
│      └─com
│          └─huiyi
│              └─campus
│                  └─wx
│                      └─applets
│                              applets.txt
│                              
└─test
└─java

