package com.dci.master.quotation;

import java.util.List;

import com.dci.common.model.CommonUtilityBean;
import com.dci.common.model.SelectivityBean;
import com.dci.reports.quotationsummary.QuotationsummaryResultBean;



public interface QuotationRateDao {

	public QuotationRateResultBean getShipment();
	
	public QuotationRateResultBean getShipmentTariff(String isVendor,String userPortStr);

	
	QuotationRateResultBean save(QuotationRateBean bean);
	
	QuotationRateResultBean savereview(QuotationRateBean bean);

	QuotationRateResultBean list();
	
	QuotationRateResultBean ratelist();

	
	public	 List<QuotationRateBean> listFilter(QuotationRateBean bean);
	
	public Integer getApprovalStatus(String quotationNo);
	
	QuotationRateResultBean listFilterApproval(QuotationRateBean bean);


	QuotationRateResultBean edit(String quotHdId);
	
	QuotationRateResultBean view(Integer quotHdId);

	QuotationRateResultBean getCustomerDetail(String quotHdId);

	QuotationRateResultBean update(QuotationRateBean bean);

	QuotationRateResultBean delete(String QuotHdId);

	QuotationRateResultBean approve(QuotationRateBean bean);
	
	QuotationRateResultBean mobapprove(QuotationRateBean bean);
	
	QuotationRateResultBean reject(String quotation);

	List<CommonUtilityBean> getCurrencyList();

	List<CommonUtilityBean> getServicePartner();

	List<CommonUtilityBean> getBranch();

	public void insertFiles(String quotationNumber, String filename, String path);

	List<CommonUtilityBean> getiataList();
	
	List<CommonUtilityBean> getcommodity();

	List<CommonUtilityBean> getServicePartnerType();

	List<CommonUtilityBean> getEmployeeList();

	List<CommonUtilityBean> getChargeHeads();

	List<CommonUtilityBean> getTerms();

	List<CommonUtilityBean> getUnitList();

	QuotationRateBean print(Integer quotationHdId);

	QuotationRateResultBean saveasDraft(QuotationRateBean bean);


	List<CommonUtilityBean> getuomList();

	List<String> getFileNameList(Integer quotationHdId);

	void updateFiles(String quotationNo, List<String> check, String filepath,
			List<String> filepaths);
	
	public QuotationRateResultBean getServicePartnerDropdownList();
	
	public QuotationRateResultBean getServicePartnerDropdownListid(String id);
	
	public QuotationRateResultBean downloadfile(String quotationNo);

	boolean uploaddelete(String quotationNo);
	
	boolean deletefiles(String fileName);
	
	public QuotationRateResultBean getCustomerList();
	
	public QuotationRateResultBean getspecial();
	
	public QuotationRateResultBean getcargotype();
	
	public QuotationRateResultBean getCustomerListCompany(String company);


	public QuotationRateResultBean reject(QuotationRateBean bean);
	
	public QuotationRateResultBean mobreject(QuotationRateBean bean);
	
	public List<QuotationRateBean> getChargeList(String pol,String pod,String chargeType,String conType,String hazardous,String oog);
	
	public List<QuotationRateBean> getdefaultchargeList(String pol,String crnyName);

	public List<SelectivityBean> getCustomereditDropdown(String quoteNo);

	
	public QuotationsummaryResultBean checkQuoteExists(String pol, String pod,String customer,String special,String cargoType);

	public QuotationRateResultBean saveNewQuotation(QuotationRateBean bean);

	public QuotationRateResultBean saveQuotationDtl(QuotationRateBean bean);
	
	public QuotationRateBean print(String quotationNo);

	void updateErrorLog(String moduleID, String value);
	
	QuotationRateBean getmrgRate(String mlo,String pod,String pol,String conType);
	
	QuotationRateBean gettariffRate(String mlo,String pod,String pol,String conType);

	QuotationRateResultBean saveRateCharges(QuotationRateBean bean);

}
