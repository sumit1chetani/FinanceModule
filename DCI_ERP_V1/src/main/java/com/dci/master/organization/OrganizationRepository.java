package com.dci.master.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional("masterTransactionManager")
public interface OrganizationRepository extends
		JpaRepository<Organization, Long> {

}
