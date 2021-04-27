package com.huiyi.campus.common.utils;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Created with Intellij IDEA
 * @Author : liyukai
 * @Date : 2019/10/16
 * @Descripition : Jasypt安全框架加密类工具包
 */
@Component
public class JasyptUtils {

    @Value("${jasypt.encryptor.password}")
    private String password;

    /**
     * 加密
     * @param value    待加密值
     * @return
     */
    public static String encryptPwd(String password, String value) {
        PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();
        encryptOr.setConfig(cryptOr(password));
        return encryptOr.encrypt(value);
    }

    /**
     * 解密
     * @param value    待解密密文
     * @return
     */
    public static String decryptPwd(String password,String value) {
        PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();
        encryptOr.setConfig(cryptOr(password));
        return encryptOr.decrypt(value);
    }

    public static SimpleStringPBEConfig cryptOr(String password) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm(StandardPBEByteEncryptor.DEFAULT_ALGORITHM);
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        return config;
    }

    /**
     * 加密测试方法
     * 本加密/秘钥根据网络工具随机生成密码
     * 地址:https://suijimimashengcheng.51240.com
     *
     * @param args
     */
    public static void main(String[] args) {
        // 加密
        System.out.println(encryptPwd("aztKpms@e7Dy9Fc#", "zhihuiJcE10myj20r8Q"));
        // 解密
//        System.out.println(decryptPwd("aztKpms@e7Dy9Fc#", "ikT3m1vmolEaqq4DXKq4Jw=="));
    }
}
