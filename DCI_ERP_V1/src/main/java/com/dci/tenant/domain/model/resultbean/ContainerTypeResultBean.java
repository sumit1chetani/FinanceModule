package com.dci.tenant.domain.model.resultbean;

import java.util.List;

import com.dci.common.util.BasicResultBean;
import com.dci.tenant.domain.model.ContainerType;

public class ContainerTypeResultBean extends BasicResultBean {
	private static final long serialVersionUID = 1L;

	private List<ContainerType> lContainerRequest;

	private ContainerType objcontainerRequest;

	public List<ContainerType> getlContainerRequest() {
		return lContainerRequest;
	}

	public void setlContainerRequest(List<ContainerType> lContainerRequest) {
		this.lContainerRequest = lContainerRequest;
	}

	public ContainerType getObjcontainerRequest() {
		return objcontainerRequest;
	}

	public void setObjcontainerRequest(ContainerType objcontainerRequest) {
		this.objcontainerRequest = objcontainerRequest;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
