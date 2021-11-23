package com.dci.tenant.container.containerstatussequence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.model.SelectivityBean;

@Service
public class ContainerStatusSequenceServiceImpl implements ContainerStatusSequenceService{

	@Autowired
	ContainerStatusSequenceDAO containerstatussequenceDao;
	
	@Override
	public List<ContainerStatusSequenceBean> getList() throws Exception {
		// TODO Auto-generated method stub
		return containerstatussequenceDao.getList();
	}

	@Override
	public ContainerStatusSequenceBean save(ContainerStatusSequenceBean bean, String userId) throws Exception {
		// TODO Auto-generated method stub
		return containerstatussequenceDao.save(bean, userId);
	}

	@Override
	public ContainerStatusSequenceBean update(ContainerStatusSequenceBean bean) throws Exception {
		// TODO Auto-generated method stub
		return containerstatussequenceDao.update(bean);
	}

	@Override
	public ContainerStatusSequenceBean delete(String sequence) throws Exception {
		// TODO Auto-generated method stub
		return containerstatussequenceDao.delete(sequence);
	}

	@Override
	public ContainerStatusSequenceBean edit(String sequence) throws Exception {
		// TODO Auto-generated method stub
		return containerstatussequenceDao.edit(sequence);
	}

	/*@Override
	public List<ContainerStatusSequenceBean> getAgreementPartyList() {
		// TODO Auto-generated method stub
		return containerstatussequenceDao.getAgreementPartyList();
	}

	@Override
	public List<ContainerStatusSequenceBean> getAgreementTypeList() {
		// TODO Auto-generated method stub
		return containerstatussequenceDao.getAgreementTypeList();
	}

	@Override
	public List<ContainerStatusSequenceBean> getLocationList() {
		// TODO Auto-generated method stub
		return containerstatussequenceDao.getLocationList();
	}

	@Override
	public List<ContainerStatusSequenceBean> getDamageCodeList() {
		// TODO Auto-generated method stub
		return containerstatussequenceDao.getDamageCodeList();
	}

	@Override
	public List<ContainerStatusSequenceBean> getContainerTypeList() {
		// TODO Auto-generated method stub
		return containerstatussequenceDao.getContainerTypeList();
	}
	
	@Override
	public List<ContainerStatusSequenceBean> getContainerNoList() {
		// TODO Auto-generated method stub
		return containerstatussequenceDao.getContainerNoList();
	}*/

	@Override
	public String getSequence() {
		// TODO Auto-generated method stub
		return containerstatussequenceDao.getSequence();
	}
	
	@Override
	public List<ContainerStatusSequenceBean> getStatusList() {
		// TODO Auto-generated method stub
		return containerstatussequenceDao.getStatusList();
	}

	@Override
	public List<SelectivityBean> getcontainerStatus() {
		// TODO Auto-generated method stub
		return containerstatussequenceDao.getcontainerStatus();
	}

	@Override
	public ContainerStatusSequenceBean saveContainer(
			ContainerStatusSequenceBean bean, String userId) throws Exception {
		// TODO Auto-generated method stub
		return containerstatussequenceDao.saveContainer(bean, userId);
	}

	/*@Override
	public List<ContainerStatusSequenceBean> getContainerStatusSequenceList() {
		// TODO Auto-generated method stub
		return containerstatussequenceDao.getContainerStatusSequenceList();
	}
	
	@Override					  
	public List<ContainerStatusSequenceBean> getRepairProcessList() {
		// TODO Auto-generated method stub
		return containerstatussequenceDao.getRepairProcessList();
	}*/
	
	
		
}
