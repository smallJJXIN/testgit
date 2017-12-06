package com.jjx.shoot.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 密码加密算法
 * @author Administrator
 *
 */
public class MdFive {
	
	
	 // 全局数组
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	/**
	 * 这个加密算法
	 * @param password
	 * @return 返回验证好的数据
	 */
	public static String getMd5(String password){
		System.out.println(password);
		String[] passwords = password.split("");
		StringBuffer sb = new StringBuffer();
		/**
		 * 一般密码8位-16位
		 * 能力有限只能写个栅栏加密
		 * 截取中间2位 第4位 第7位 放在最后面
		 */
		for(int i = 0;i<passwords.length;i++){
			if(i==3||i==6){
				break;
			}
			sb.append(passwords[i]);
		}
		sb.append(passwords[3]);
		sb.append(passwords[6]);
		
		 MessageDigest md5 = null;
		 String resultString = null;
		 try {
			md5 = MessageDigest.getInstance("Md5");
			 resultString = byteToString(md5.digest(sb.toString().getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "error";
		} 
		return resultString;
	}
	
	  private static String byteToString(byte[] bByte) {
	        StringBuffer sBuffer = new StringBuffer();
	        for (int i = 0; i < bByte.length; i++) {
	            sBuffer.append(byteToArrayString(bByte[i]));
	        }
	        return sBuffer.toString();
	    }
	
	  private static String byteToArrayString(byte bByte) {
	        int iRet = bByte;
	        if (iRet < 0) {
	            iRet += 256;
	        }
	        int iD1 = iRet / 16;
	        int iD2 = iRet % 16;
	        return strDigits[iD1] + strDigits[iD2];
	    }
}
