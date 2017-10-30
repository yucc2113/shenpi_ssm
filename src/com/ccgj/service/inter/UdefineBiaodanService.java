package com.ccgj.service.inter;

import java.util.Date;
import java.util.List;

import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.UdefineBiaodan;

public interface UdefineBiaodanService {
	
	public int insertUdefineBiaodan(UdefineBiaodan udefineBiaodan);
	public CommonPage<UdefineBiaodan> searchByNameAndDateListWithPage(String name,
			Date startDate, Date endDate, Integer pageNum,Integer state) ;
    public UdefineBiaodan searchById(Integer id);
    
    public int updateById(Integer id ,UdefineBiaodan biaodan);
    
    public int deleteById(Integer id);
    
    public List<UdefineBiaodan> searchAllList();
    
    
}
