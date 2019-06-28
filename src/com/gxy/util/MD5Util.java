package com.gxy.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
	//加密的方法
	public static String md5(String context) {
		String md5Str = DigestUtils.md5Hex(context);
		return md5Str;
	}
	//测试加密
	public static void main(String[] args){
		String md5 = MD5Util.md5("aa");
		System.out.println(md5);
	}
}
