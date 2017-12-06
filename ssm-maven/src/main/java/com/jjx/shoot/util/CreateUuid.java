package com.jjx.shoot.util;

import java.util.UUID;
/**
 * 创建uuid的写法
 * @author Administrator
 *
 */
public class CreateUuid {
	public static String getUuid(){
		String s = UUID.randomUUID().toString();
		String[] a = s.split("-");
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<a.length;i++){
			sb.append(a[i]);
		}
		return sb.toString();
	}
}