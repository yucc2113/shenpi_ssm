package com.ccgj.service.inter;

import java.util.List;

import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.FlowDefine;

public interface FlowDefineService {

	//根据流程名称及是否可用的状态查询
	public CommonPage<FlowDefine> searchByNameAndStateWithPage(String name,Integer state,Integer pageNum);

    public List<FlowDefine> searchByIsEnabled(Integer idEnabled);
    
    //根据ID查询
    public FlowDefine searchById(Integer id);
    
    //添加信息
    public int insert(FlowDefine bean);
    //更新
    
    public int updateById(Integer id,FlowDefine bean);
}
