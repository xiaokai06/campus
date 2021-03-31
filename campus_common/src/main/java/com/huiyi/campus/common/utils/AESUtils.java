package com.huiyi.campus.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Component;
//import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * @author: yzg
 * @time: 2021-03-31 11:50
 * @description: AES加密工具类
 */
@Component
public class AESUtils {

	private static final Log logger = LogFactory.getLog(AESUtils.class);

	// TODO: 由于AES的秘钥规定是16位秘钥,不是16位就会报错
	public final static String C_KEY = "www_huiyi_com_cn";

	// 加密
	public String encrypt(String sSrc) {
		try {
			byte[] raw = C_KEY.getBytes(StandardCharsets.UTF_8);
			SecretKeySpec skySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
			cipher.init(Cipher.ENCRYPT_MODE, skySpec);
			byte[] encrypted = cipher.doFinal(sSrc.getBytes(StandardCharsets.UTF_8));
			return new String(Hex.encode(encrypted)).toUpperCase();
		} catch (Exception e) {
			logger.error("非法密文！！！");
			return null;
		}
	}

	// 解密
	public String decrypt(String sSrc) {
		try {
			byte[] raw = C_KEY.getBytes(StandardCharsets.UTF_8);
			SecretKeySpec skySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skySpec);
			byte[] encrypted1 = Hex.decode(sSrc.toLowerCase());
			byte[] original = cipher.doFinal(encrypted1);
			return new String(original, StandardCharsets.UTF_8);
		} catch (Exception ex) {
			logger.error("非法密文！！！");
			return null;
		}
	}

	// 加密
	public String encryptByKey(String sSrc, String aesKey) {
		try {
			byte[] raw = aesKey.getBytes(StandardCharsets.UTF_8);
			SecretKeySpec skySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
			cipher.init(Cipher.ENCRYPT_MODE, skySpec);
			byte[] encrypted = cipher.doFinal(sSrc.getBytes(StandardCharsets.UTF_8));
			return new String(Hex.encode(encrypted)).toUpperCase();
		} catch (Exception e) {
			logger.error("AESUtils 加密异常：" + e);
			return null;
		}
	}

	// 解密
	public String decryptByKey(String sSrc, String aesKey) {
		try {
			byte[] raw = aesKey.getBytes(StandardCharsets.UTF_8);
			SecretKeySpec skySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skySpec);
			if (sSrc != null) {
				byte[] encrypted1 = Hex.decode(sSrc.toLowerCase());
				byte[] original = cipher.doFinal(encrypted1);
				return new String(original, StandardCharsets.UTF_8);
			}else{
				logger.info("AESUtils ex解密异常：参数sSrc为NUll.");
				return null;
			}
		} catch (Exception ex) {
			logger.info("AESUtils ex解密异常：" + ex);
			return null;
		}
	}
}
