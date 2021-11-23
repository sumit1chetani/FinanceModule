package com.dci.tenant.container.containerStatus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ContainerStatusServiceImpl implements ContainerStatusService {

	@Autowired
	ContainerStatusDAO containerStatusDao;
	@Override
	public List<ContainerStatusBean> getContainerStatusList() {
		return containerStatusDao.getContainerStatusList();
	}

	@Override
	public ContainerStatusBean insert(ContainerStatusBean containerStatus, String userId) throws Exception {
		return containerStatusDao.insert(containerStatus, userId);
	}

	@Override
	public ContainerStatusBean delete(String containerStatusCode) {
		return containerStatusDao.delete(containerStatusCode);
	}

	@Override
	public ContainerStatusBean getContainerStatusEdit(String containerStatusCode) {
		return containerStatusDao.getContainerStatusEdit(containerStatusCode);
	}

	@Override
	public ContainerStatusBean update(ContainerStatusBean containerStatus) throws Exception {
		// TODO Auto-generated method stub
		return containerStatusDao.update(containerStatus);
	}

}
