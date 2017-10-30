package com.ccgj.database.custom.beans;

import com.ccgj.database.beans.Meet;

public class MeetCustom extends Meet{
    private String usersName;
    private String usersId;
    private Integer num;
    private String meetDateStr;
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getMeetDateStr() {
		return meetDateStr;
	}
	public void setMeetDateStr(String meetDateStr) {
		this.meetDateStr = meetDateStr;
	}
    
}
