package com.dci.master.domain.repository;

import org.springframework.transaction.annotation.Transactional;

import com.dci.master.organization.Organization;

@Transactional("masterTransactionManager")
public interface DataSourceRepository {

	// List<Organization> findByCompanyName(String companyName);

	// String saveOrganization();

	void setDataSource(Organization organization);
}
