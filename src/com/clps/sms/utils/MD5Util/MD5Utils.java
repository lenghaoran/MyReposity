/**
 * @Title: MD5Encrypt.java 
 * @Package com.clps.sms.utils 
 * @Description: MD5���ܹ��߰�
 * @author Leng Haoran   
 * @date 2017��8��9�� ����10:01:19 
 * @version V1.0  
 */
package com.clps.sms.utils.MD5Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: MD5Encrypt 
 * @Description: MD5���ܹ�����
 * @author Leng Haoran
 * @date 2017��8��9�� ����10:01:19 
 *  
 */
public class MD5Utils {
	
	  private MD5Utils(){
		  
	  };
       /**
     * @Title: encodeMd5 
     * @Description:
     * @param @param source
     * @param @return    �趨�ļ� 
     * @return String    �������� 
     * @throws 
     */
    public static String encodeMd5(String source){
    	   return encodeMd5(source.getBytes());
       }

	/**
	 * @Title: encodeMd5 
	 * @Description:  
	 * @param @param source
	 * @param @return    �趨�ļ� 
	 * @return String    �������� 
	 * @throws NoSuchAlgorithmException
	 */
	private static String encodeMd5(byte[] source) {
		try {
			return encodeHex(MessageDigest.getInstance("MD5").digest(source));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Title: encodeHex 
	 * @Description: 
	 * @param @param bytes
	 * @param @return    �趨�ļ� 
	 * @return String    �������� 
	 * @throws 
	 */
	private static String encodeHex(byte[] bytes) {
		StringBuffer buffer=new StringBuffer(bytes.length*2);
		for(int i=0;i<bytes.length;i++){
			if(((int)bytes[i]&0xff)<0x10)
				buffer.append("0");
			buffer.append(Long.toString((int)bytes[i]&0xff,16));
		}
		return buffer.toString();
	}
}
