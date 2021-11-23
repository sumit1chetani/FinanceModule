package com.dci.master.servicepartnerNew;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//import com.mbk.master.branch.BranchResultBean;

//import com.mbk.master.customer.CustomerMasterCommDetail1;

public interface ServicePartnerNewService {

	
	ServicePartnerNewResultBean getDropDownList();
	
	ServicePartnerNewResultBean getServicePartnerDetailList();

	ServicePartnerNewResultBean getServicePartnerList(String name);
	
	ServicePartnerNewResultBean saveServicePartner(ServicePartnerNewResultBean servicePartnerBean);
	
	ServicePartnerNewResultBean updateServicePartner(ServicePartnerNewResultBean servicePartnerBean);
	
	ServicePartnerNewResultBean editServicePartner(int servicePartnerId);
	
	ServicePartnerNewResultBean viewServicePatrnerList(int servicePartnerId);

	
	ServicePartnerNewResultBean deleteServicePartner(int servicePartnerId);
	
	ServicePartnerNewResultBean createLogin(int rowid);
	
	ServicePartnerNewResultBean deleteKeyDetail(List<ServicePartnerNewKeyBean> lServicePartnerKeyBean);
//kyc
	boolean updateCustomerCommDetail2(
			CustomerMasterNewCommDetail2 customerMasterCommDetail, String userId) throws Exception;

	boolean saveCustomCommDetail(
			CustomerMasterNewCommDetail2 customerMasterCommDetail, String userId) throws Exception;

	boolean deleteCustomerComm(String customCommId, String srvcprtnrcd) throws Exception;

	ServicePartnerNewResultBean getCustomCommDetail(String srvcprtnrcd)
			throws Exception;
	public ServicePartnerNewResultBean getCountryList(int cityId);

	String generateExcel();

	void excellExport(ServicePartnerNewResultBean objBookingReportResultBean, ServiceNewMapBean objBookingReportBean,
			String pdfFile)throws Exception ;

	ServicePartnerNewResultBean uploadFile(MultipartFile file);

	public ServicePartnerNewResultBean uploadFile1(MultipartFile file);

 
}
