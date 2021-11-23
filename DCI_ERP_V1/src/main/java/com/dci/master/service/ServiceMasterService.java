package com.dci.master.service;

import java.util.List;

public interface ServiceMasterService {

	List<ServiceMasterBean> getServiceMasterList(int limit, int offset) throws Exception;

	ServiceMasterResultBean getCompanyLocation();

	ServiceMasterResultBean getportforEdit(String sectorCode);

	ServiceMasterBean addServiceMaster(ServiceMasterResultBean objServiceMasterResultBean,String userId) throws Exception;

	ServiceMasterBean updateServiceMaster(ServiceMasterResultBean objServiceMasterResultBean,String userId) throws Exception;

	ServiceMasterResultBean editServiceMaster(String sectorCode) throws Exception;

	boolean deleteServiceMaster(String sectorCode) throws Exception;

	List getService() throws Exception;

}