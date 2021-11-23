package com.dci.operation.voyage.thirdPartyVoyage;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;


//import com.mbk.tenant.reports.BLissuedReport.BLissuedReportResultBean;

public interface ThirtyPartyVoyageService {

	public List<ThirdPartyVoyageBean> getVoyageList(ThirdPartyVoyageBean thirdPartyVoyageBean) throws Exception;

	public List<ThirdPartyVoyageBean> getThirdPartyVoyageList(ThirdPartyVoyageBean thirdPartyVoyageBean, String formCode) throws Exception;

	public List<ThirdPartyVoyageBean> getVesselList(String formCode) throws Exception;

	public List<ThirdPartyVoyageBean> getActivityTypes() throws Exception;

	public List<ThirdPartyVoyageBean> getServiceList(ThirdPartyVoyageBean ThirdPartyVoyageBean, String companyCode) throws Exception;

	public List<ThirdPartyVoyagePortBean> getPortList(ThirdPartyVoyageBean ThirdPartyVoyageBean) throws Exception;

	public List<ThirdPartyVoyagePortBean> getVoyageDtlList(ThirdPartyVoyageBean ThirdPartyVoyageBean, List<ThirdPartyVoyagePortBean> portList)
			throws Exception;

	public String getDistance(String fromPort, String toPort) throws Exception;

	public String saveThirdPartyVoyage(ThirdPartyVoyageResultBean ThirdPartyVoyageResultBean);

	public List<ThirdPartyVoyageBean> getEditVoyageHeader(ThirdPartyVoyageBean ThirdPartyVoyageBean) throws Exception;

	public List<ThirdPartyVoyagePortBean> getEditVoyageDtlList(ThirdPartyVoyageBean ThirdPartyVoyageBean) throws Exception;

	public ThirdPartyVoyageResultBean updateThirdPartyVoyage(ThirdPartyVoyageResultBean ThirdPartyVoyageResultBean);

	public boolean deleteThirdPartyVoyage(String voyageId);

	public List<ThirdPartyVoyageBean> getMloList(String voyageID) throws Exception;
	
	public boolean checkServiceExist(ThirdPartyVoyageBean partyVoyageBean,String companyCode);
	
	public String getLocationOfService(String serviceId);
	
	public boolean sendMail(ThirdPartyVoyageResultBean resultBean);

	public ThirdPartyVoyageResultBean checkPurchaseQuotValid(ThirdPartyVoyageResultBean thirdPartyVoyageResultBean);

	public boolean checkValidationDate(String voyageId);

	public boolean sendMailForPurchaseQuote(ThirdPartyVoyageResultBean thirdPartyVoyageResultBean);

	public String getCompanyOfService(ThirdPartyVoyageBean thirtyPartyVoyageHeader);
	
	public List<ThirdPartyVoyageBean> getVesselListWithOutOwnParty(String formCode) throws Exception;


	public List<ThirdPartyVoyageBean> getVesselListWithOutOwnParty1(String formCode) throws Exception;

	public List<ThirdPartyVoyageBean> geList(ThirdPartyVoyageBean thirdPartyVoyageBean) throws Exception;
	
	boolean excellExport(ThirdPartyVoyageResultBean ThirdPartyVoyageBean,  String pdfFile) throws Exception;

	public List<ThirdPartyVoyageBean> searchfindshed(ThirdPartyVoyageBean searchBean);
	
	public ThirdPartyVoyageResultBean uploadFile(MultipartFile file);


}

