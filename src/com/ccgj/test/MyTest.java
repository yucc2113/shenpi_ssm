package com.ccgj.test;

import org.junit.Test;

import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Systemlog;
import com.ccgj.service.imp.SystemlogServiceImp;
import com.ccgj.service.inter.SystemlogService;

public class MyTest {
	
	 public void queryByPage(){ 
		 SystemlogService systemlogService=new SystemlogServiceImp();
	     CommonPage<Systemlog>  pagedResult = (CommonPage<Systemlog>) systemlogService.searchSystemlogListByPage(null);//null表示查全部    
	     System.out.println("查找结果" + pagedResult);  
	}  
	 public static void main(String []args){
		 new MyTest().queryByPage();
	 }
}
