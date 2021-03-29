package com.huiyi.campus.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.codec.Hex;
//import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by zhaomeichen on 2017/8/14.
 */
public class AESUtils {
	private static final Log logger = LogFactory.getLog(AESUtils.class);
	public final static String C_KEY = "www1baiwang2com3";

	// 加密
	public static String Encrypt(String sSrc) {
		try {
			byte[] raw = C_KEY.getBytes("utf-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
			return new String(Hex.encode(encrypted)).toUpperCase();
		} catch (Exception e) {
			logger.error("AESUtils 加密异常：" + e);
			return null;

		}
	}

	// 解密
	public static String Decrypt(String sSrc) throws Exception {
		try {
			byte[] raw = C_KEY.getBytes("utf-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] encrypted1 = Hex.decode(sSrc.toLowerCase());
			// byte[] encrypted1 =   Base64.decode(sSrc);
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original, "utf-8");
			return originalString;
		} catch (Exception ex) {
			//logger.error("AESUtils ex解密异常："+ex);
			throw new Exception("AESUtils ex解密异常：" + ex);
		}
	}

	// 加密
	public static String Encrypt(String sSrc, String aesKey) {
		try {
			byte[] raw = aesKey.getBytes("utf-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
			return new String(Hex.encode(encrypted)).toUpperCase();
		} catch (Exception e) {
			logger.error("AESUtils 加密异常：" + e);
			return null;

		}
	}

	// 解密
	public static String Decrypt(String sSrc, String aesKey) throws Exception {
		try {
			byte[] raw = aesKey.getBytes("utf-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			if (sSrc != null) {
				byte[] encrypted1 = Hex.decode(sSrc.toLowerCase());
				// byte[] encrypted1 =   Base64.decode(sSrc);
				byte[] original = cipher.doFinal(encrypted1);
				String originalString = new String(original, "utf-8");
				return originalString;
			}else{
				throw new Exception("AESUtils ex解密异常：参数sSrc为NUll。");
			}
		} catch (Exception ex) {
			//logger.error("AESUtils ex解密异常："+ex);
			throw new Exception("AESUtils ex解密异常：" + ex);
		}
	}


	public static void main(String[] args) throws Exception {
		System.out.println("");
		/*
		 * 此处使用AES-128-ECB加密模式，key需要为16位。
		 */
		// 需要加密的字串
		String cSrc = "BaiWang@2019Xm*01";
//		String sstr = Encrypt(cSrc, cKey);
//		System.out.println("加密后的字串是：" + sstr);
//        System.out.println(cSrc);
        // 加密
		String enString = Encrypt(cSrc, C_KEY);
		System.out.println("加密后的字串是：" + enString);

		// 解密
		String DeString = Decrypt(enString, C_KEY);
		System.out.println("解密后的字串是：" + DeString);

		// System.out.println(getDqdm("032001600111"));
	}

	public static String getDqdm(String fpdm) {
		String dqdm = null;
		if (fpdm.length() == 12) {
			dqdm = fpdm.substring(1, 5);
		} else {
			dqdm = fpdm.substring(0, 4);
		}

		if (!"2102".equals(dqdm) && !"3302".equals(dqdm)
				&& !"3502".equals(dqdm) && !"3702".equals(dqdm)
				&& !"4403".equals(dqdm)) {
			dqdm = dqdm.substring(0, 2) + "00";
		}

		return dqdm;
	}
}
