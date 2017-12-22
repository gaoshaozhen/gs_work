package com.gs.sdk.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类，默认utf-8编码
 * 
 * @author shaozhen
 *
 */
public class Encrypt {
	public static final String MD5 = "MD5";
	public static final String SHA256 = "SHA256";

	/**
	 * 返回32位字符串
	 * 
	 * @param info
	 * @return
	 */
	public static String getMD5(String message) {
		return digest(message, null, MD5);
	}

	/**
	 * 返回64位字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String getSHA256(String message) {
		return digest(message, null, SHA256);
	}

	public static String getSHA256(String message, String salt) {
		return digest(message, salt, SHA256);
	}

	public static String digest(String message, String salt, String alorithm) {
		message += salt != null ? salt : "";
		String result = null;
		try {
			result = Hex
					.bytesToHex(digest(message.getBytes("utf-8"), alorithm));
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static byte[] digest(byte[] message, String algorithm)
			throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
		// update(byte[])方法，输入原数据
		// 类似StringBuilder对象的append()方法，追加模式，属于一个累计更改的过程
		messageDigest.update(message);
		// digest()被调用后,MessageDigest对象就被重置，即不能连续再次调用该方法计算原数据的MD5值。可以手动调用reset()方法重置输入源。
		// digest()返回值16位长度的哈希值，由byte[]承接
		return messageDigest.digest();
	}

	public static void main(String[] args) {
		System.out.println(getSHA256("asd"));
	}
}
