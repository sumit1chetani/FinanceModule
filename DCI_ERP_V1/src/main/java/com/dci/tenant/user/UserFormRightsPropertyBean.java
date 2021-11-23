package com.dci.tenant.user;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class UserFormRightsPropertyBean implements Serializable{
	
	private Map<String,List<String>> userRights;

	public Map<String, List<String>> getUserRights() {
		return userRights;
	}

	public void setUserRights(Map<String, List<String>> userRights) {
		this.userRights = userRights;
	}
	
}
