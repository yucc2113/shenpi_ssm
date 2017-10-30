package com.base.controller.common;

import java.util.List;

import com.github.pagehelper.Page;

public class BeanUtil {  
	  
    public static <T> CommonPage<T> toPagedResult(List<T> datas) {  
    	System.out.println("hi");
    	CommonPage<T> result = new CommonPage<T>();  
        if (datas instanceof Page) {  
            Page page = (Page) datas;  
            result.setPageNo(page.getPageNum());  
            result.setPageSize(page.getPageSize());  
            result.setDataList(page.getResult());  
            result.setTotal(page.getTotal());  
            result.setPages(page.getPages());  
        }  
        else {  
            result.setPageNo(1);  
            result.setPageSize(datas.size());  
            result.setDataList(datas);  
            result.setTotal(datas.size());  
        }  
  
        return result;  
    }  
  
}  