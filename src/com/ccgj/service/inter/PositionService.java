package com.ccgj.service.inter;
import java.util.List;

import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Position;


public interface PositionService {
    //根据职位名称查询职位并分页
	public CommonPage<Position> searchPositionListByNameWithPage(String name,Integer pageNum);
	//根据Id查询一条信息
	public Position searchPositionById(Integer id);
	 //添加一条信息
    public int insert(Position position);
    
    //更新一条信息
    public int updatePositionById(int id,Position position);
    //根据Id删除一条信息
    public int deletePositionById(int id);
    
    public List<Position> searchPositionList();
}
