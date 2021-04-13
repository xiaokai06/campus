package com.huiyi.campus.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Component;

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

	/**
	 * 加密
	 * @param content    加密的字符串
	 */
	public String encrypt(String content) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding",new BouncyCastleProvider());
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(C_KEY.getBytes(), "AES"));
			byte[] b = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
			return Base64.encodeBase64String(b);
		} catch (Exception e) {
			logger.info("AES加密非法字符串！");
			throw new RuntimeException("非法密文！！！");
		}
	}

	/**
	 * 解密
	 * @param encryptStr 解密的字符串
	 */
	public String decrypt(String encryptStr) {
		try {
			byte[] decodeBase64 = Base64.decodeBase64(encryptStr);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding",new BouncyCastleProvider());
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(C_KEY.getBytes(), "AES"));
			byte[] decryptBytes = cipher.doFinal(decodeBase64);
			return new String(decryptBytes);
		} catch (Exception e) {
			logger.info("AES解密非法字符串！");
			throw new RuntimeException("非法密文！！！");
		}
	}
}
