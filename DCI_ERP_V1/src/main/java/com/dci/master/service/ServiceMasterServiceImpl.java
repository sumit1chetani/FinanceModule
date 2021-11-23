package com.dci.master.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceMasterServiceImpl implements ServiceMasterService {

	@Autowired
	ServiceMasterDAO objServiceMasterDAO;

	@Override
	public List<ServiceMasterBean> getServiceMasterList(int limit, int offset) throws Exception {
		return objServiceMasterDAO.getServiceMasterList(limit, offset);
	}

	@Override
	public ServiceMasterResultBean getCompanyLocation() {
		// TODO Auto-generated method stub
		return objServiceMasterDAO.getCompanyLocation();
	}

	@Override
	public ServiceMasterResultBean getportforEdit(String sectorCode) {
		// TODO Auto-generated method stub
		return objServiceMasterDAO.getportforEdit(sectorCode);
	}

	@Override
	public ServiceMasterBean addServiceMaster(ServiceMasterResultBean objServiceMasterResultBean,String userId) throws Exception {
		// TODO Auto-generated method stub
		return objServiceMasterDAO.addServiceMaster(objServiceMasterResultBean,userId);
	}

	@Override
	public ServiceMasterResultBean editServiceMaster(String sectorCode) throws Exception {
		// TODO Auto-generated method stub
		return objServiceMasterDAO.editServiceMaster(sectorCode);
	}

	@Override
	public ServiceMasterBean updateServiceMaster(ServiceMasterResultBean objServiceMasterResultBean,String userId) throws Exception {
		// TODO Auto-generated method stub
		return objServiceMasterDAO.updateServiceMaster(objServiceMasterResultBean,userId);
	}

	@Override
	public boolean deleteServiceMaster(String sectorCode) throws Exception {
		// TODO Auto-generated method stub
		return objServiceMasterDAO.deleteServiceMaster(sectorCode);
	}

	@Override
	public List getService() throws Exception {
		// TODO Auto-generated method stub
		return objServiceMasterDAO.getService();
	}
}