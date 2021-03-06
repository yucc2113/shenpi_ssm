package com.base.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public final class  StringUtil {
	
	/**
	 * 判断字符串是否为非null,非空串
	 * @param pStr
	 * @return 如果为空,则返回false;不为空,则返回true
	 */
	public static boolean notNullOrEmpty(String pStr)
	{
		boolean notempty = true;
		try{
			if (pStr == null || pStr.trim().length()==0)
			{
				notempty = false;
			}
		}catch(Exception ex)
		{
			notempty = false;
		}
		return notempty;
	}
	public static boolean notNullOrEmptyDate(Date pdate)
	{
		boolean notempty = true;
		try{
			if (pdate == null)
			{
				notempty = false;
			}
		}catch(Exception ex)
		{
			notempty = false;
		}
		return notempty;
	}
	public static String[] splitStr(String value,String split)
	{
		String[] retVal = {"","",""},temp;
		if ( value == null ) {
			return retVal ;
		}
		try{
			temp = value.split(split);
			if (temp.length==1)
			{
				retVal[0] = temp[0];
				retVal[1] = "";
				retVal[2] = "";
			}else if (temp.length==2)
			{
				retVal[0] = temp[0];
				retVal[1] = temp[1];
				retVal[2] = "";
			}else
			{
				retVal = temp;
			}
			
		}catch(Exception ex)
		{
			
		}
		return retVal;
	}
	
	public static String cutString( String value, int max ) {
		if ( value == null ) {
			return "" ;
		}
		
		//if ( value.length() > max ) {
		//	return value.substring( 0, max )+"...";
		//}
		
		return value ;
	}
	public static String cutString1( String value, int max ) {
		if ( value == null ) {
			return "" ;
		}
		
		if ( value.length() > max ) {
			return value.substring( 0, max )+"...";
		}
		
		return value ;
	}
	
	public static String cutString( String value, int max, String omit ) {
		if ( value == null ) {
			return "" ;
		}
		
		if ( value.length() > max ) {
			return (new StringBuffer(value.substring( 0, max )).append(omit)).toString() ;
		}
		
		return value ;
	}	
	/**
	 * 去掉左右两边空格
	 * @param str
	 * @return
	 */
	public static String trimLRbank(String str) {
		if (str == null || str.equals("")) {
			return str;
		} else {
			//return leftTrim(rightTrim(str));
			return str.replaceAll("^[　 ]+|[　 ]+$", "");
		}
	}
	public static String toEUCKR( String value ) {
		String strRet = null ;
		if ( value == null ) {
			return strRet;
		}
		
		try {
			strRet = new String(value.getBytes("iso-8859-1"),"euc-kr") ;
		} catch( Exception exc ) {
			strRet = "" ;
		}
		
		return strRet;
	}	
	
	
	public static String toUTF8( String value ) {
		String strRet = null ;
		if ( value == null ) {
			return strRet;
		}
		
		try {
			strRet = new String(value.getBytes("iso-8859-1"),"utf-8") ;
		} catch( Exception exc ) {
			strRet = "" ;
		}
		
		return strRet;
	}	
	
	/**
	 * ��ȡ�ļ�����
	 * @param filePath
	 * @return
	 */
	public static String getFileType(String filePath) {
		int FileIndex = filePath.lastIndexOf(".") + 1;
		String FileType = filePath.substring(FileIndex, filePath.length());
		return FileType;
	}

	/**
	 *  ��ȡ�ļ����
	 * @param filePath
	 * @return
	 */public static String getFileName(String filePath) {
		int FileIndex = filePath.lastIndexOf(".");
		String FileName = filePath.substring(0, FileIndex);
		return FileName;
	}
	/**
	 *  ��ȡ�ļ����
	 * @param filePath
	 * @return
	 */public static String getNowYear() {
		return DateFormat.shortDate(new Date()).split("-")[0];
	}
	

	

	

	public static String getYear(){
		return DateFormat.shortDate(new Date()).split("-")[0];
	}
	public static String getMonth(){
		return DateFormat.shortDate(new Date()).split("-")[1];
	}
	  /**
	 * 字符过长截取
	 * @param str
	 * @return
	 */	
	public static String trim(String str) {
		if (str != null)
		{
			if (str.length() > 14) {
				return str.substring(0, 10) + "...";
			} else {
				return str;
			}
		}
		else 
			return "";
	}
	
	
	public static String trimCel(String str) {
		if (str != null)
		{
			if (str.length() > 10) {
				return str.substring(0, 10) + "...";
			} else {
				return str;
			}
		}
		else 
			return "";
	}
	  /**
	 * 字符过长截取
	 * @param str
	 * @return
	 */	
	public static String remarkTrim(String str) {
		if (str != null)
		{
			if (str.length() > 20) {
				return str.substring(0, 25) + "...";
			} else {
				return str;
			}
		}
		else 
			return "";
	}
	  /**
	 * 字符过长截取地址长度
	 * @param str
	 * @return
	 */	
	public static String trimAddr(String str) {
		if (str != null)
		{
			if (str.length() > 3) {
				return str.substring(0, 2) + "...";
			} else {
				return str;
			}
		}
		else 
			return "";
	}
	
	/**
	 * 去最后一个,号
	 * @param str
	 * @return
	 */
	public static String cutLastDot(String pStr)
	{
		String retVal = "";
		try{
			if (pStr != null && pStr.length()>0)
			{
				//int len = pStr.lastIndexOf(",");
				retVal = pStr.substring(0,pStr.length()-1);
			}
		}catch(Exception ex)
		{
			retVal = "";
		}
		return retVal;
	}
	/**
	 * 将"20091012"转化成"2009 年 10 期 12 月"
	 * @param str
	 */
	public static String changFormat(String str){
		char[] chars = str.toCharArray();
		boolean flag = true;
		String strb1 = "";
		String strb2 = "";
		for(int i=0;i<chars.length;i++){
			strb1+=chars[i];
			if(i==3)strb1+="年";
			if(i==5)strb1+="期";
		}
		chars = strb1.toCharArray();
		if(chars[5]=='0'&&chars[6]=='0'){
			chars[5]='-';
			chars[6]='-';
			flag=false;
		}
		if(chars[8]=='0'&&chars[9]=='0'){
			chars[8]='-';
			chars[9]='-';
			flag=false;
		}
		for(int i=0;i<chars.length;i++){
			strb2+=chars[i];
		}
		if(flag){
			return strb1+="月";
		}else {
			return strb2+="月";
		}
	}
	public static void main(String[] args)
	{
		System.out.println(cutLastDot("a,b,"));
	}
	
	public static String DateToString(Date date){
		if(date==null){
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		String str="";
		str=df.format(date);
		return str;
	}
	
	public static String DateToString1(Date date){
		if(date==null){
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String str="";
		str=df.format(date);
		return str;
	}
	
	public static String DateToWeek(Date date){
		SimpleDateFormat df = new SimpleDateFormat("E");
		String str="";
		str=df.format(date);
		return str;
	}
	
	
	/**
	 * 
	 * @param value
	 * @param bol
	 * @return
	 */
	public static String replaceBr(String value,boolean bol){
		if (value!=null && value.length()>0) {
			if (bol) {
				return value.replace("\r\n", "<br/>").replace(" ", "&nbsp");
			}else{
				return value.replace("<br/>", "\r\n").replace("&nbsp", " ");
			}
		}else{
			return "";
		}	
	}
	/**
	 * 
	 * @param value
	 * @param bol
	 * @return
	 */
	public static String replaceFCK(String value,boolean bol){
		if (value!=null && value.length()>0) {
			if (bol) {
				return value;
			}else{
				return value;
			}
		}else{
			return "";
		}	
	}
	
}
