package com.dci.master.organization;

import java.util.List;

public interface OrganizationService {

	List<Organization> findAll();

	void save(Organization organization);

	void setDataSource(Organization organization);

}
