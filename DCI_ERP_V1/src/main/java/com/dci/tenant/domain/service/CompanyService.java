package com.dci.tenant.domain.service;

import java.util.List;

import com.dci.tenant.domain.model.Company;

public interface CompanyService {

	List<Company> findAll();

	void save(Company company);

}
