package com.ccgj.database.custom.beans;


import com.ccgj.database.beans.Official;

public class OfficialCustom extends Official{
	private String usersId;
	//人员的名字
    private String usersName;
  

    
	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	
}
