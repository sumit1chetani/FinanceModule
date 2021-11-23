package com.dci.tenant.container.containerstatussequence;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public interface ContainerStatusSequenceService {


		public List<ContainerStatusSequenceBean> getList() throws Exception;

		public ContainerStatusSequenceBean save(ContainerStatusSequenceBean bean, String userId) throws Exception;

		public ContainerStatusSequenceBean update(ContainerStatusSequenceBean bean) throws Exception;

		public ContainerStatusSequenceBean delete(String containerNo) throws Exception;

		public ContainerStatusSequenceBean edit(String containerNo) throws Exception;

		public String getSequence();
		
		public List<ContainerStatusSequenceBean> getStatusList();
		
		public ContainerStatusSequenceBean saveContainer(ContainerStatusSequenceBean bean, String userId) throws Exception;

/*	    public List<ContainerStatusSequenceBean> getAgreementPartyList();
		
		public List<ContainerStatusSequenceBean> getAgreementTypeList();
		
		public List<ContainerStatusSequenceBean> getDamageStatusList();
		
		public List<ContainerStatusSequenceBean> getLocationList();
		
		public List<ContainerStatusSequenceBean> getDamageCodeList();
		
		public List<ContainerStatusSequenceBean> getContainerTypeList();
		
		public List<ContainerStatusSequenceBean> getContainerNoList();
		
		public List<ContainerStatusSequenceBean> getRepairProcessList();*/

		public List<SelectivityBean> getcontainerStatus();
	

}
