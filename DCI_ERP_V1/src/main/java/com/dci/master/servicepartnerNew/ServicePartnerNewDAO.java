package com.dci.master.servicepartnerNew;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//import com.mbk.master.customer.CustomerMasterCommDetail1;

public interface ServicePartnerNewDAO {

	ServicePartnerNewResultBean getDropDownList();
	
	ServicePartnerNewResultBean getServicePartnerList(String name);
	
	ServicePartnerNewResultBean getServicePartnerDetailList();

	ServicePartnerNewResultBean saveServicePartner(ServicePartnerNewResultBean servicePartnerBean);
	
	ServicePartnerNewResultBean updateServicePartner(ServicePartnerNewResultBean servicePartnerBean);
	
	ServicePartnerNewResultBean editServicePartner(int servicePartnerId);
	
	ServicePartnerNewResultBean viewServicePatrnerList(int servicePartnerId);

	
	ServicePartnerNewResultBean deleteServicePartner(int servicePartnerId);
	
	ServicePartnerNewResultBean createLogin(int rowid);

	ServicePartnerNewResultBean deleteKeyDetail(List<ServicePartnerNewKeyBean> lServicePartnerKeyBean);

	boolean saveCustomerCommDetail(
			CustomerMasterNewCommDetail2 customerMasterCommDetail, String userId) throws Exception;

	ServicePartnerNewResultBean getCustomCommDetail(String srvcprtnrcd);

	boolean updateCustomerCommDetail(
			CustomerMasterNewCommDetail2 customerMasterCommDetail, String userId) throws Exception;

	boolean deleteCustomerComm(String customCommId, String customId) throws Exception;
	public ServicePartnerNewResultBean getCountryList(int cityId);

	List<ServicePartnerNewBean> getServicePartnerListnew();

	ServicePartnerNewResultBean uploadFile(MultipartFile file);

	ServicePartnerNewResultBean saveImportDetails(ServicePartnerNewResultBean resultbean);

	ServicePartnerNewResultBean vendor(ServicePartnerNewResultBean agentMasterBean);

	ServicePartnerNewResultBean email(ServicePartnerNewResultBean agentMasterBean);

	ServicePartnerNewResultBean con(ServicePartnerNewResultBean agentMasterBean);


}
