package com.dci.master.service;

import java.util.List;

import com.dci.common.util.CustomException;



public interface ServiceMasterDAO {

	public List<ServiceMasterBean> getServiceMasterList(int limit, int offset) throws CustomException;

	public ServiceMasterResultBean getCompanyLocation();
	
	public ServiceMasterResultBean getportforEdit(String sectorCode);

	public ServiceMasterBean addServiceMaster(ServiceMasterResultBean objServiceMasterResultBean,String userId) throws CustomException, Exception;

	public ServiceMasterResultBean editServiceMaster(String sectorCode) throws CustomException, Exception;

	public ServiceMasterBean updateServiceMaster(ServiceMasterResultBean objServiceMasterResultBean,String userId) throws CustomException, Exception;

	public boolean deleteServiceMaster(String sectorCode) throws CustomException, Exception;

	public List getService() throws Exception;

}