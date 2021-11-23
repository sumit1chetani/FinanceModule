package com.dci.tenant.container.containerStatus;

import java.util.List;


public interface ContainerStatusService {

	public List<ContainerStatusBean> getContainerStatusList();
	
	public ContainerStatusBean insert(ContainerStatusBean containerStatusBean, String userId) throws Exception;

	public ContainerStatusBean delete(String containerStatusCode);
	
	public ContainerStatusBean getContainerStatusEdit(String containerStatusCode);

	public ContainerStatusBean update(ContainerStatusBean containerStatus) throws Exception;
}
