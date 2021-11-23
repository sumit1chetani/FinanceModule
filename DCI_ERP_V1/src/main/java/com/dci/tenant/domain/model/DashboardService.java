package com.dci.tenant.domain.model;

import java.util.List;

public interface DashboardService {
	
	public List<DashboardlistBean> getList();

	
	DashboardResultBean getDescriptionCount(String period);

}
