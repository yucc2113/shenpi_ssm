package com.ccgj.database.custom.beans;

import com.ccgj.database.beans.FlowStep;

public class FlowStepCustom extends FlowStep{
  
    private String leibiename;
    private String lastname;//上级步骤名称
    private String nextname;//上级步骤名称
	public String getLeibiename() {
		return leibiename;
	}
	public void setLeibiename(String leibiename) {
		this.leibiename = leibiename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getNextname() {
		return nextname;
	}
	public void setNextname(String nextname) {
		this.nextname = nextname;
	}
    
    
    
}
