package com.dci.tenant.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.domain.model.Company;

@Transactional("masterTransactionManager")
public interface CompanyRepository extends JpaRepository<Company, Long> {

	List<Company> findByCompanyName(String companyName);
}
