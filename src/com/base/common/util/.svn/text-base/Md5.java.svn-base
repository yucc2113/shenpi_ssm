package com.base.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Md5 {

    public Md5() {
    }

    /**
     *输入一个字符串对象，通过java.security.MessageDigest对象，采用MD5算法，获得128位数字，转化为16进制对应字符串返回。
     * 如果输入字符串为null，则返回null。
     * @param strURL 字符串
     * @return 输入字符串的MD5加密，16位数字表示对应的字符串
     */
    public static String GetMark(String strURL) {
        if (strURL == null) {
            return null;
        }

        String strProcessURL = strURL; /*函数内部的要处理的URL字符串*/
        String strMark; /*输出的指纹字符串*/
        byte[] byProcessURL; /*以字节方式表示的URL字符串*/
        byte[] byDigestURL; /*字节方式表示的URL字符串的指纹*/
        MessageDigest theMessageDigest; /*摘要对象*/
        char[] output = new char[32]; /*输出指纹*/
        byte by0XF = 0xF; /*用来对生成的摘要截取*/
        int iProcess, iOutput, iResult; /*分别表示处理输入的位置，输出的位置和中间结果*/
        int strLength = 0; /*strURL长度，生成数组*/
        iProcess = 0;
        iOutput = 0;

        try {
            theMessageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            System.out.print("FingerMark module no such alogrithm exception");
            System.out.println(" caught a " + ex.getClass() +
                               "\n with message: " + ex.getMessage());
            return "";
        }

        strLength = strURL.length();
        byProcessURL = new byte[2 * strLength];
        byProcessURL = strProcessURL.getBytes(); /*将字符串转变成字节方式 */
        theMessageDigest.update(byProcessURL); /*将URL字符串作为摘要对象的输入变量*/
        byDigestURL = theMessageDigest.digest(); /*生成摘要*/

        for (iProcess = 0; iProcess < 16; iProcess++) {
            iResult = (int) ((byDigestURL[iProcess] >>> 4) & by0XF);
            output[iOutput++] = inttochar(iResult);
            iResult = (int) (byDigestURL[iProcess] & by0XF);
            output[iOutput++] = inttochar(iResult);
        }

        strMark = new String(output);
        /*释放生成的数组内存*/
        byProcessURL = null;
        byDigestURL = null;
        output = null;
        return strMark;
    }

    /**
     * 输入一个16进制数字转化到字符返回，非0~15数字则返回0
     * @param a 0~15数字
     * @return 输入数字的16进制表示对应字符
     */
    private static char inttochar(int a) {
        switch (a) {
        case 0:
            return '0';
        case 1:
            return '1';
        case 2:
            return '2';
        case 3:
            return '3';
        case 4:
            return '4';
        case 5:
            return '5';
        case 6:
            return '6';
        case 7:
            return '7';
        case 8:
            return '8';
        case 9:
            return '9';
        case 10:
            return 'a';
        case 11:
            return 'b';
        case 12:
            return 'c';
        case 13:
            return 'd';
        case 14:
            return 'e';
        case 15:
            return 'f';
        }
        return '0';
    }
public static void main(String[] args){
  String mini = String.valueOf(java.util.Calendar.getInstance().getTimeInMillis());
  System.out.println(mini);
  System.out.println(GetMark("2152513399153248eqifa123"+mini));

}

}

