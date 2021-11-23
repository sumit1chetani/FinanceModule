package com.dci.tenant.domain.repository;

import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.domain.model.DashboardBean;

@Transactional("tenantTransactionManager")
public interface LoginreportRepository {


	public DashboardBean getDashboardValues() throws Exception;


}
