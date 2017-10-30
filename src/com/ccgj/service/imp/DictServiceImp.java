package com.ccgj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.controller.common.BeanUtil;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Dict;
import com.ccgj.database.beans.DictExample;
import com.ccgj.database.beans.Role;
import com.ccgj.database.mapper.DictMapper;
import com.ccgj.service.inter.DictService;
import com.github.pagehelper.PageHelper;

public class DictServiceImp implements DictService{
    @Autowired
    private DictMapper dictMapper;
	@Override
	public CommonPage<Dict> searchDictListByParentIdAndNameWithPage(Integer parentId,
			String name, Integer pageNum) {
		DictExample bean=new DictExample();
		DictExample.Criteria criteria=bean.createCriteria();
		if(parentId==null){
			criteria.andParentidNotEqualTo(0);
		}else{
			criteria.andParentidEqualTo(parentId);
		}
		
		if(name!=null&&name.length()>0){
			
			criteria.andPropLike("%"+name+"%");
		}
		pageNum = pageNum == null?1:pageNum;  
	    int pageSize =10;  
	    PageHelper.startPage(pageNum,pageSize); 
		List<Dict> list=dictMapper.selectByExample(bean);
		return (CommonPage<Dict>) BeanUtil.toPagedResult(list); 
	}
	@Override
	public List<Dict> searchDictListByParentIdAndName(Integer parentId,
			String name) {
		DictExample bean=new DictExample();
		DictExample.Criteria criteria=bean.createCriteria();
		if(parentId==null){
			criteria.andFlagNotEqualTo(0);
		}else{
			criteria.andParentidEqualTo(parentId);
		}
		if(name!=null&&name.length()>0){
			criteria.andPropLike("%"+name+"%");
		}
		List<Dict> list=dictMapper.selectByExample(bean);
		return list;
	}
	@Override
	public Dict searchDictById(Integer id) {
		return dictMapper.selectByPrimaryKey(id);
	}
	@Override
	public int insertDict(String prop,Integer parentId) {
		Dict dict=new Dict();
		dict.setProp(prop);
		dict.setParentid(parentId);
		dict.setFlag(1);
		dict.setTypes(parentId+"");
		if(parentId==0){
			dict.setMemos("顶级");
		}
		// TODO Auto-generated method stub
		return dictMapper.insert(dict);
	}
	@Override
	public int updateDictById(Integer id, Dict dict) {
		dict.setId(id);
		return dictMapper.updateByPrimaryKey(dict);
	}
	@Override
	public int deleteDictById(Integer id) {
		
		return dictMapper.deleteByPrimaryKey(id);
	}

}
