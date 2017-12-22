package com.gs.sdk.utils;

public class Hex {
	/**
	 * 在32位的电脑中数字都是以32格式存放的，如果是要求一个byte(8位)类型的数字，对于int这种32位的整形，高24位具有随机性(
	 * 从所有的数字形式来看，前面的24位取值并不确定，我把它视为具有一定的随机性，比如int型的整数，高24位的取值都是不确定的。)，低8位
	 * 才是实际的数据。 java.lang.Integer.toHexString()
	 * 方法的参数是int(32位)类型，如果输入一个byte(8位)类型的数字，这个 方法会把这个数字的高24为也看作有效位，这就必然导致错误，使用&
	 * 0XFF操作，可以把高24位置0以避免这样错误 的发生
	 * 这里面再调用了加密算法完成之后，会返回byte数组，大小为16，最终生成的是32位的加密数据
	 * 。总体的思路是把每一个byte替换为16进制的两个位的数据，至于为什么两位，是因为每个byte是8位的数据最大不会超过两位的十六进制的数据去。
	 * 那么这里之所以转为整形无非是整形的包装类中有Integer
	 * .toHexString()这个将其转为16进制的方法，如果Byte中有的话，估计这里是不会转为整形的
	 * 。如果结果小于十六的时候，要再前面加上一个0填满两位的十六进制
	 * 
	 * @param md5Array
	 * @return
	 */
	static String bytesToHex(byte[] md5Array) {
		// System.out.println(md5Array.length);
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < md5Array.length; i++) {
			int temp = 0xff & md5Array[i];
			String hexString = Integer.toHexString(temp);
			// System.out.println(hexString);
			if (hexString.length() == 1) {
				strBuilder.append("0").append(hexString);
			} else {
				strBuilder.append(hexString);
			}
		}
		return strBuilder.toString();
	}
}
