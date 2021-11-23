package com.dci.tenant.domain.service;

import org.springframework.stereotype.Service;

import com.dci.tenant.domain.model.DashboardBean;

@Service
public interface LoginService {

	

	public DashboardBean getDashboardValues() throws Exception;

}
