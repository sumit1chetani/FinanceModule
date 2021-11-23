package com.dci.tenant.domain.repository;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.domain.model.ContainerType;

@Resource
@Transactional("tenantTransactionManager")
public interface ContainerTypeRepositoryCustom {

//	public List<ContainerType> getContainerRequestList(int limit, int offset);

//	public boolean addContainer(ContainerType objcontainerType);
//
//	public boolean updateContainer(ContainerType objcontainerType) ;
//
//	public boolean deleteContainer(String containerID) ;

	public boolean checkContainer(ContainerType containerType) ;
	
	public boolean checkContainerUpdate(ContainerType containerType) ;

	public Integer getcount(String userId, String password);

}
