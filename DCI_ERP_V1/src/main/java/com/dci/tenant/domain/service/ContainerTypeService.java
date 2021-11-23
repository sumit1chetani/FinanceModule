package com.dci.tenant.domain.service;

import java.util.List;

import com.dci.tenant.domain.model.ContainerType;
import com.dci.tenant.domain.model.UserBean;

public interface ContainerTypeService {

	public List<ContainerType> getContainerRequestList(int limit, int offset);

	public ContainerType addContainer(ContainerType objcontainerType) ;

	public ContainerType updateContainer(ContainerType objcontainerType) ;

	public ContainerType edit(Integer typeId) ;
	
	public Boolean deleteContainer(String containerID) ;

	public boolean checkContainer(ContainerType container_type) ;
	
	public boolean checkContainerUpdate(ContainerType container_type) ;

	public List<UserBean> findAll();
	
	public Integer getcount(String userId,String Password);

}
