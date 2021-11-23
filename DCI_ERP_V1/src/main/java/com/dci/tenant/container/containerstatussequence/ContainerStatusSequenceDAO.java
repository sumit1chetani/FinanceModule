package com.dci.tenant.container.containerstatussequence;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public interface ContainerStatusSequenceDAO {

	

	public List<ContainerStatusSequenceBean> getList() throws Exception;

	public ContainerStatusSequenceBean save(ContainerStatusSequenceBean bean, String userId) throws Exception;

	public ContainerStatusSequenceBean update(ContainerStatusSequenceBean bean) throws Exception;

	public ContainerStatusSequenceBean delete(String sequence) throws Exception;

	public ContainerStatusSequenceBean edit(String sequence) throws Exception;

	
    /*public List<ContainerStatusSequenceBean> getAgreementPartyList();
	
	public List<ContainerStatusSequenceBean> getAgreementTypeList();
	
	public List<ContainerStatusSequenceBean> getLocationList();*/
	
	public String getSequence();
	
	public List<ContainerStatusSequenceBean> getStatusList();
	
	/*public List<ContainerStatusSequenceBean> getcontainerstatussequenceStatusList();

	public List<ContainerStatusSequenceBean> getcontainerstatussequenceCodeList();
	
	public List<ContainerStatusSequenceBean> getContainerTypeList();
	
	public List<ContainerStatusSequenceBean> getsequenceList();
	
	public List<ContainerStatusSequenceBean> getRepairProcessList();*/
	
	public List<SelectivityBean> getcontainerStatus();
	
	public ContainerStatusSequenceBean saveContainer(ContainerStatusSequenceBean bean, String userId) throws Exception;


}
