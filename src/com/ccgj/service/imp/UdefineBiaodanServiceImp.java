package com.ccgj.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.controller.common.BeanUtil;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.UdefineBiaodan;
import com.ccgj.database.custom.mapper.UdefineBiaodanCustomMapper;
import com.ccgj.database.mapper.UdefineBiaodanMapper;
import com.ccgj.service.inter.UdefineBiaodanService;
import com.github.pagehelper.PageHelper;

public class UdefineBiaodanServiceImp implements UdefineBiaodanService{

	@Autowired
	private UdefineBiaodanMapper udefineBiaodanMapper;
	@Autowired
	private UdefineBiaodanCustomMapper udefineBiaodanCustomMapper;
	@Override
	public int insertUdefineBiaodan(UdefineBiaodan udefineBiaodan) {
		return udefineBiaodanMapper.insert(udefineBiaodan);
	}
	@Override
	public CommonPage<UdefineBiaodan> searchByNameAndDateListWithPage(String name,
			Date startDate, Date endDate, Integer pageNum, Integer state) {
		if(name!=null&&name.length()>0)name="%"+name+"%";
		pageNum = pageNum == null ? 1 : pageNum;
		
		int pageSize = 3;
		PageHelper.startPage(pageNum, pageSize); // startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		List<UdefineBiaodan> list = udefineBiaodanCustomMapper.selectByNameAndDate(name,
				startDate, endDate,state);
		return (CommonPage<UdefineBiaodan>) BeanUtil.toPagedResult(list);
	
	}
	@Override
	public UdefineBiaodan searchById(Integer id) {
		return udefineBiaodanMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateById(Integer id, UdefineBiaodan biaodan) {
	    biaodan.setId(id);
		return udefineBiaodanMapper.updateByPrimaryKeySelective(biaodan);
	}
	@Override
	public int deleteById(Integer id) {
		return udefineBiaodanMapper.deleteByPrimaryKey(id);
	}
	@Override
	public List<UdefineBiaodan> searchAllList() {
	
		return udefineBiaodanMapper.selectByExample(null);
	}
	

}
