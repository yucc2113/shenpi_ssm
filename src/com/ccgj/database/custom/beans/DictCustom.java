package com.ccgj.database.custom.beans;

import com.ccgj.database.beans.Dict;

public class DictCustom extends Dict{
	//上级名字
   private String parentName;

public String getParentName() {
	return parentName;
}

public void setParentName(String parentName) {
	this.parentName = parentName;
}
   
}
