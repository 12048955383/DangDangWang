package com.gxy.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
	//���ܵķ���
	public static String md5(String context) {
		String md5Str = DigestUtils.md5Hex(context);
		return md5Str;
	}
	//���Լ���
	public static void main(String[] args){
		String md5 = MD5Util.md5("aa");
		System.out.println(md5);
	}
}
