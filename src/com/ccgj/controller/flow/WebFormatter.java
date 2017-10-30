package com.ccgj.controller.flow;
import java.util.ArrayList;
import java.util.List;

import com.ccgj.database.beans.UflowValue;


public class WebFormatter {

//测试
public static void main(String[] args){
   String result = "";
   String test = "<P align=center><FONT size=4><STRONG>市青企协、青商会选出新会长</STRONG></FONT></P><P><IMG src=\"/UploadFile/20080121091722250.jpg\">&nbsp;&nbsp;&nbsp;&nbsp; <IMG src=\"/UploadFile/20080121091733226.jpg\"></P><DIV>&nbsp;&nbsp;&nbsp; 导报讯&nbsp;（记者&nbsp;詹文／文&nbsp;吴晓平／图）&nbsp;昨天下午，厦门市青年企业家协会、青年商会换届，选出新一届会长。<BR>&nbsp;&nbsp;&nbsp;&nbsp;厦门国贸集团股份有限公司总裁许晓曦担任市青年企业家协会第十一届会长；中国建设银行厦门市分行行长陈万铭担任青年商会第十一届会长。<BR>&nbsp;&nbsp;&nbsp;&nbsp;市青企协、青商会是共青团厦门市委倡导成立的青年企业家的群众组织，以促进企业转换经营机制，建立现代企业制度，提高企业经济效益，培养和造就优秀青年企业家队伍为宗旨。市青企协、青商会已经成立22年。<BR>来源（海峡导报第4版2008-1-4）</DIV>";
try{
   System.out.println("result的值是："+result);
}catch (RuntimeException re){
// System.out.println(re);
}
}

public static List html2List(String html) {
	
    StringBuffer sb = new StringBuffer(html.length());
    char[] data = html.toCharArray();
    List<Strbean> strlist = new ArrayList();
    String ss ="";
    boolean previousIsPre = false;
    for(int i=0;i<data.length;i++) {
    	boolean addlist = false;
    	char c = data[i];
    	if(c=='<') {
    		previousIsPre =true;
    	}
    	if(c=='>') {
    		previousIsPre =false;
    		ss+=c;
    		addlist = true;
    	}
    	if(previousIsPre){
    		
    		ss+=c;
    	}
    	if(addlist){
    		if(ss.contains("element_type")){
    			Strbean bean = new Strbean();
    			bean.setStrCode(ss);
    			strlist.add(bean);
    		}
    		ss = "";
    	}
    }
    return strlist;
} 


public static String gettype(String str) {
	if(str.contains("element_text")){
		return "element_text";
	}else if(str.contains("element_textarea")){
		return "element_textarea";
	}else if(str.contains("element_shuzi")){
		return "element_shuzi";
	}else if(str.contains("element_shijian")){
		return "element_shijian";
	}else if(str.contains("element_dept")){
		return "element_dept";
	}else if(str.contains("element_user")){
		return "element_user";
	}else if(str.contains("element_auto")){
		return "element_auto";
	}
    return null;
} 


public static String getStr(String str,List<UflowValue> valueList,Long state) {
	String strAll = "";
	String[] strAry =  str.split("element_type");
	if(strAry!=null&&strAry.length>0){
		for(int i=0;i<strAry.length;i++){
			if(i<strAry.length-1){
				String valueStr = "";
				if(valueList.get(i).getDataelement()!=null&&!valueList.get(i).getDataelement().equals("")){
					valueStr = valueList.get(i).getDataelement();
					if(state==1l){
						strAll +=strAry[i]+" value="+valueStr+"  element_type";
					}else{
						strAll +=strAry[i]+"readonly='true' value="+valueStr+"  element_type";
					}
				}else{
					if(state==1l){
						strAll +=strAry[i]+" value=''   element_type";
					}else{
						strAll +=strAry[i]+"readonly='true' value=''  element_type";
					}
				}
				
			}else{
				strAll +=strAry[i];
			}
		}
	}
    return strAll;
} 

}

