package com.ccgj.database.custom.beans;

import com.ccgj.database.beans.Notice;

public class NoticeCustom extends Notice{
	private String usersId;
	//通知人员的名字
    private String usersName;
    //通知的人员个数
    private Integer num;

    
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

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
    
}
