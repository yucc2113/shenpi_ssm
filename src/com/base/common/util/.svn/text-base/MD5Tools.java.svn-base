package com.base.common.util;

import java.security.*;
import java.text.*;
import java.util.*;


public class MD5Tools{


	private static MessageDigest md;

	static{
		try{
			if(md==null){
				md = MessageDigest.getInstance("MD5");
			}
		}catch(Exception e){
		}
	}

	public static String bytes2string(byte[] bytes){
		return new String(bytes);
	}
	public static byte[] string2bytes(String str){
		return str.getBytes();
	}

	public static String byte2HEX(byte b) {
		return (""+"0123456789ABCDEF".charAt(0xf&b>>4)+"0123456789ABCDEF".charAt(b&0xF));
	}

	public static byte stringHEX2bytes(String str) {
		return (byte) ("0123456789ABCDEF".indexOf(str.substring(0,1))*16 + "0123456789ABCDEF".indexOf(str.substring(1)));
	}
	public static byte[] addbytes(byte[] b1,byte[] b2){
		byte[] b = new byte[b1.length + b2.length];
		System.arraycopy(b1, 0, b, 0, b1.length);
		System.arraycopy(b2, 0, b, b1.length, b2.length);
		return b;
	}
	public static byte[] addbytes(byte[] b1,String str1){
		return addbytes(b1,string2bytes(str1));
	}
	public static byte[] addbytes(String str1,byte[] b1){
		return addbytes(string2bytes(str1),b1);
	}
	public static byte[] addbytes(String str1,String str2){
		return addbytes(string2bytes(str1),string2bytes(str2));
	}


	public static String md5bytes2string(byte[] bytes){
		String result = "";
		for(int i=0; i<bytes.length; i++){
			result += byte2HEX(bytes[i]);
		}
		return result;
	}
	public static byte[] md5string2bytes(String str){
		byte[] b = new byte[str.length()/2];
		for(int i=0; i<b.length; i++){
			String s = str.substring(i*2,i*2+2);
			b[i] = stringHEX2bytes(s);
		}
		return b;
	}

	public static byte[] getAuthSeed(){
		byte[] b = new byte[16];
		for(int i=0; i< b.length; i++){
			b[i] = (byte)(Math.random()*1024);
		}
		return b;
	}
	public static byte[] getAuthSeed(int length){
		byte[] b = new byte[length];
		for(int i=0; i< b.length; i++){
			b[i] = (byte)(Math.random()*1024);
		}
		return b;
	}

	public static byte[] getAuthCodebySeed(byte[] seed){
		return md.digest(seed);
	}
    
    public static boolean isEqual(byte[] originalMessage, byte[] code) {
        return MessageDigest.isEqual(code, originalMessage);
    }

	public static String date2string(Date date){
		if(date == null){
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(date);
	}
//	private static String get2byteString(int in){
//		String a = "00" + in;
//		return a.substring(a.length()-2,a.length());
//	}

	public static String float2string(float f){
		String s = String.valueOf(f) + "00";
		int index = s.indexOf(".");
		return s.substring(0,index+3);
	}
}