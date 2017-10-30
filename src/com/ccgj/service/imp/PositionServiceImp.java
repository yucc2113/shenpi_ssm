package com.ccgj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.controller.common.BeanUtil;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Position;
import com.ccgj.database.beans.PositionExample;
import com.ccgj.database.mapper.PositionMapper;
import com.ccgj.service.inter.PositionService;
import com.github.pagehelper.PageHelper;

public class PositionServiceImp implements PositionService{
    @Autowired
    private PositionMapper  positionMapper;
	
	
	@Override
	public CommonPage<Position> searchPositionListByNameWithPage(String name,
			Integer pageNum) {
		PositionExample bean=new PositionExample();
		if(name!=null&&name.length()>0){
			bean.createCriteria().andNameLike(name);
		}
		bean.createCriteria().andStateEqualTo(1);
		pageNum = pageNum == null?1:pageNum;  
		int pageSize =10;  
		PageHelper.startPage(pageNum,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		List<Position> list=positionMapper.selectByExample(bean);
		return (CommonPage<Position>) BeanUtil.toPagedResult(list); 
		
	}


	@Override
	public int insert(Position position) {
		position.setState(1);
		return positionMapper.insert(position);
	
	}


	@Override
	public int updatePositionById(int id, Position position) {
		position.setId(id);
		position.setState(1);
		return positionMapper.updateByPrimaryKey(position);
		
	}


	@Override
	public Position searchPositionById(Integer id) {
		
		return positionMapper.selectByPrimaryKey(id);
	}


	@Override
	public int deletePositionById(int id) {
		
		return positionMapper.deleteByPrimaryKey(id);
	}


	@Override
	public List<Position> searchPositionList() {
		PositionExample  bean=new PositionExample();
		bean.createCriteria().andStateEqualTo(1);
		return positionMapper.selectByExample(bean);
	}

}
