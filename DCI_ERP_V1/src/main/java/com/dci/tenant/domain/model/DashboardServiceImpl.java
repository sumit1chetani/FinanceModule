package com.dci.tenant.domain.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	DashboardDao dashboardDao;

	@Override
	public List<DashboardlistBean> getList() {
		// TODO Auto-generated method stub
		return dashboardDao.getList();
	}

	@Override
	public DashboardResultBean getDescriptionCount(String period) {
		// TODO Auto-generated method stub
		return dashboardDao.getDescriptionCount(period);
	}


	

}
