package com.dci.master.servicepartner;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//import com.mbk.master.branch.BranchResultBean;

//import com.mbk.master.customer.CustomerMasterCommDetail1;

public interface ServicePartnerService {

	
	ServicePartnerResultBean getDropDownList();
	
	ServicePartnerResultBean getServicePartnerDetailList();

	ServicePartnerResultBean getServicePartnerList(String name);
	
	ServicePartnerResultBean saveServicePartner(ServicePartnerResultBean servicePartnerBean);
	
	ServicePartnerResultBean updateServicePartner(ServicePartnerResultBean servicePartnerBean);
	
	ServicePartnerResultBean editServicePartner(int servicePartnerId);
	
	ServicePartnerResultBean viewServicePatrnerList(int servicePartnerId);

	
	ServicePartnerResultBean deleteServicePartner(int servicePartnerId);
	
	ServicePartnerResultBean createLogin(int rowid);
	
	ServicePartnerResultBean deleteKeyDetail(List<ServicePartnerKeyBean> lServicePartnerKeyBean);
//kyc
	boolean updateCustomerCommDetail2(
			CustomerMasterCommDetail2 customerMasterCommDetail, String userId) throws Exception;

	boolean saveCustomCommDetail(
			CustomerMasterCommDetail2 customerMasterCommDetail, String userId) throws Exception;

	boolean deleteCustomerComm(String customCommId, String srvcprtnrcd) throws Exception;

	ServicePartnerResultBean getCustomCommDetail(String srvcprtnrcd)
			throws Exception;
	public ServicePartnerResultBean getCountryList(int cityId);

	String generateExcel();

	ServicePartnerResultBean uploadFile1(MultipartFile file);

}
