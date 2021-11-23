package com.dci.master.servicepartner;

import java.util.List;


//import com.mbk.master.customer.CustomerMasterCommDetail1;

public interface ServicePartnerDAO {

	ServicePartnerResultBean getDropDownList();
	
	ServicePartnerResultBean getServicePartnerList(String name);
	
	ServicePartnerResultBean getServicePartnerDetailList();

	ServicePartnerResultBean saveServicePartner(ServicePartnerResultBean servicePartnerBean);
	
	ServicePartnerResultBean updateServicePartner(ServicePartnerResultBean servicePartnerBean);
	
	ServicePartnerResultBean editServicePartner(int servicePartnerId);
	
	ServicePartnerResultBean viewServicePatrnerList(int servicePartnerId);

	
	ServicePartnerResultBean deleteServicePartner(int servicePartnerId);
	
	ServicePartnerResultBean createLogin(int rowid);

	ServicePartnerResultBean deleteKeyDetail(List<ServicePartnerKeyBean> lServicePartnerKeyBean);

	boolean saveCustomerCommDetail(
			CustomerMasterCommDetail2 customerMasterCommDetail, String userId) throws Exception;

	ServicePartnerResultBean getCustomCommDetail(String srvcprtnrcd);

	boolean updateCustomerCommDetail(
			CustomerMasterCommDetail2 customerMasterCommDetail, String userId) throws Exception;

	boolean deleteCustomerComm(String customCommId, String customId) throws Exception;
	public ServicePartnerResultBean getCountryList(int cityId);
	ServicePartnerResultBean saveImportDetailsnewdata(ServicePartnerResultBean resultbean);

	ServicePartnerResultBean con(ServicePartnerResultBean agentmaster);

	ServicePartnerResultBean cusName(ServicePartnerResultBean agentmaster);

	ServicePartnerResultBean email(ServicePartnerResultBean agentmaster);


}
