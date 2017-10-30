package com.ccgj.service.inter;

import java.util.List;

import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Dict;

public interface DictService {
   public CommonPage<Dict> searchDictListByParentIdAndNameWithPage(Integer parentId,String name,Integer pageNum);
   public List<Dict> searchDictListByParentIdAndName(Integer parentId,String name);
   //根据ID查询字典信息
   public Dict searchDictById(Integer id);
   //添加字典信息
   public int insertDict(String prop,Integer parentId);
   //根据ID更新字典信息
   public int updateDictById(Integer id,Dict dict);
   //根据ID删除信息
   public int deleteDictById(Integer id);
}
