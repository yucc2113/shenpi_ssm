package com.ccgj.database.custom.beans;

import java.util.List;

import com.ccgj.database.beans.Module;

public class ModuleCustom extends Module{
   private List<Module> list;

public List<Module> getList() {
	return list;
}

public void setList(List<Module> list) {
	this.list = list;
}
   
}
