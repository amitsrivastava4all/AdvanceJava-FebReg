package com.bmpl.talentfinder.users.dto;

import java.util.ArrayList;
import java.util.List;

public class UserRoleRightMappingDTO {
	private String userid;
	private String role;
	private List<RightDTO> rightList  = new ArrayList<>();
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<RightDTO> getRightList() {
		return rightList;
	}
	public void setRightList(ArrayList<RightDTO> rightList) {
		this.rightList = rightList;
	}
	
	
	

}
