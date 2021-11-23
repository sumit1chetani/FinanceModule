package com.dci.tenant.domain.model;

import java.io.Serializable;
import java.util.List;


@SuppressWarnings("serial")
public class DashboardResultBean  implements Serializable {
	
	  private List<DashboardlistBean> descriptionCountList;
	   
	public List<DashboardlistBean> getDescriptionCountList() {
		return descriptionCountList;
	}

	public void setDescriptionCountList(List<DashboardlistBean> descriptionCountList) {
		this.descriptionCountList = descriptionCountList;
	}
	  
	  
	  

}
