package com.dci.tenant.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.domain.model.ContainerType;

@Transactional("tenantTransactionManager")
public interface ContainerTypeRepository  extends JpaRepository<ContainerType, Long> {

	Integer deleteByContainerTypeId(int containerTypeId);
	
	ContainerType findByContainerTypeId(Integer typeId);
}
