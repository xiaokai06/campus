package com.huiyi.campus.common.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;

/**
 * @Description 二维码用工具类
 * @Author liyukai
 * @Date 2019-11-11 16:22
 */
public class QRCodeUtil {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final String CHARSET = "utf-8";
	private static final String FORMAT_NAME = "PNG";

	/**
	 * @Author liyukai
	 * @Description 生成二维码
	 * @Date 2019-11-12 09:50
	 * @Param [text, width, height, filePath]
	 * @Return void
	 */
	public static byte[] createImage(String text, int width, int height) throws WriterException, IOException {
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		hints.put(EncodeHintType.MARGIN, 4);

		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);
		ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
		byte[] pngData = pngOutputStream.toByteArray();
		return pngData;
	}

}
