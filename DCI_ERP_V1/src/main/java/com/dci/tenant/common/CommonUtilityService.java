package com.dci.tenant.common;

import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BatchAttributeBean;
import com.dci.common.util.CustomException;
import com.dci.common.util.DefTableBean;
import com.dci.master.attributes.AttributeBean;
import com.dci.tenant.finance.transferReceived.TransferReceivedBean;
import com.dci.tenant.finance.transferReceived.TransferReceivedDetailBean;

public interface CommonUtilityService {

	public List<CommonUtilityBean> getCustomer();
	
	public List<CommonUtilityBean> getSupplier();
	
	public List<CommonUtilityBean> getVendor();

	/* public List getCustList(); */

	public List getSector();

	public List getPort();
	
	public List<SelectivityBean> getPortwithSequence(String voyage);
	
	public List getTerminal();

	public List<SelectivityBean> getContainerTypeList();
	
	public List<SelectivityBean> getLeaseAggTypeList();
	
	public List<CommonUtilityBean> getAccountHeadData();
	
	public List<CommonUtilityBean> getAccountHeadData1();

	public List<CommonUtilityBean> getPhcContainers();

	public List<CommonUtilityBean> getSubAccountCodeData();

 
	public List<CommonUtilityBean> getEmployeeList();

	public List<CommonUtilityBean> getPortList();
	
	public List<CommonUtilityBean> getVendorList();

	public List<CommonUtilityBean> getStuffingList();
	
	public List<CommonUtilityBean> getPortISO_portList();

	public List<CommonUtilityBean> getDepartmentList();

	public List<CommonUtilityBean> getAgentList();

	public List<CommonUtilityBean> getCountryList();

	public List<CommonUtilityBean> getDesignationList();

	public List<CommonUtilityBean> getCustomerList();

	public List<CommonUtilityBean> getCustomerListFilter(CommonUtilityBean objCommonUtilityBean);

	public double getExchangeRate(String currencyCode);

	public List<CommonUtilityBean> getVesselList();
	
	public List<CommonUtilityBean> getQuoteApproveList();
	
	public List<CommonUtilityBean> getLeasingPartyList();

	public List<CommonUtilityBean> getSectorList();

	public List<CommonUtilityBean> getVoyageList();
	
	public List<SelectivityBean> getVoyageListByVessel(String vsl);
	public List<SelectivityBean> getVoyageListByVessel1(String vsl);

	public List<SelectivityBean> getPortListByVoyage(String pod);
	
	public List<SelectivityBean> getPortListByVoy(String voy);
	
	public List<SelectivityBean> getPortListByVoyNU(String voy);
	
	public List<CommonUtilityBean> getTripList();

	public List<CommonUtilityBean> getSupplierList();

	public List<CommonUtilityBean> getCompanyList();

	public String getCompanyCurrency(String sCompanyCode);

	public List<CommonUtilityBean> getAccountSgList(String sSubGroupCode);

	public List<CommonUtilityBean> getSubAccountCodeListTradeDebtors();

	public List<CommonUtilityBean> getSubAccountCodeListTradeCreditors();

	public boolean checkUniqueNameExists(String value, String fieldName,
			String screenName);

	public List<CommonUtilityBean> getCostCentreList();

 
	public List<CommonUtilityBean> getCompanyLocationList();

	public List<CommonUtilityBean> getCompanyLocationListForBunker();

	public List<SelectivityBean> getStaffListForAdvances();

	public List<CommonUtilityBean> getSubAccountCodeListTradeDebtorsCP();

	public List<CommonUtilityBean> getSubAccountCodeListTradeDebtorsCR();

	public CommonUtilityBean getVesselService(String sVoyageCode);
	
	public CommonUtilityBean getTruckService(String sVoyageCode);

	public double getDefaultExchangeRate(String currencyCode);

	public List<CommonUtilityBean> getassetList();

	public List<CommonUtilityBean> getJvPartnerAccount();

 
	public CommonUtilityBean getExchangeRateWithCurrency(String currencyCode);

	public List<CommonUtilityBean> getSectorBasedVessel(String sectorCode);

	public CommonUtilityBean getSupplierCurrency(String supplierCode);

	public CommonUtilityBean getCompanyName();

	public List<CommonUtilityBean> getSupplierListWthAcctCode();

	public List<CommonUtilityBean> getSurchargePort();

	public CommonUtilityBean getExchangeRateWithCurrencyBySailingDate(
			String currencyCode, String sailingDate);

	public CommonUtilityBean getExchangeRateWithCurrencyByMaxDate(
			String currencyCode);

	public List<CommonUtilityBean> getSectorWiseCompany();

	public List<CommonUtilityBean> getonlySupplier(String accountCode);

	public List<CommonUtilityBean> getonlypayer();

	public List<CommonUtilityBean> getonlypayerForJV(); 
	
	public List<CommonUtilityBean> getcustomerList();
	public List<CommonUtilityBean> getSLot();

	public List<CommonUtilityBean> getSubSLot();

	public List<CommonUtilityBean> getVessel();

	public List<CommonUtilityBean> getStaffList();

	public List<CommonUtilityBean> getTripsList();

	public List<CommonUtilityBean> geLocation();
	public List<SelectivityBean> geLocation1();

	public List<CommonUtilityBean> getChargeList();

	public List<CommonUtilityBean> getCurrencyList();

	CommonUtilityResultBean getStockAvailablity(int locationId, int itemId);
	
	public List<DefTableBean> getDefTableList(Integer formFieldId);
	
	List<CommonUtilityBean> getEntityData() throws Exception;
	
	List<BatchAttributeBean> getConsignmentBatchList(BatchAttributeBean bean);
	
	boolean updateInventoryAndLedgerIn(String stockId, String date, int i, int sourceLoc, int destLoc, int parseInt, int quantity, List<BatchAttributeBean> attributeBeans);

	boolean updateInventoryAndLedgerOut(String stockId, String date, int i, int destLoc, int sourceLoc, int parseInt, int quantity, List<BatchAttributeBean> attributeBeans);

	boolean updateInventoryAndLedgerInCheckQc(String stockId, String date, int i, int sourceLoc, int destLoc, int parseInt, int quantity, int qcStatus, List<BatchAttributeBean> attributeBeans);

	boolean updateInventoryAndLedgerOutCheckQc(String stockId, String date, int i, int destLoc, int sourceLoc, int parseInt, int quantity, int qcStatus, List<BatchAttributeBean> attributeBeans);

	public List<SelectivityBean> getMode();

	public List<SelectivityBean> getJobOrderNo();

 	
	public List<CommonUtilityBean> getSubAccountCodeListTradeDebtorsIA();
	
	public List<SelectivityBean> getCustomerCateory();

	public List getVoyageList(String vesselCode);

	public List<CommonUtilityBean> getPayerList();
	
	
 
	public List<CommonUtilityBean> getsupplierList();

	public List<CommonUtilityBean> getAccountListDrpDwn() throws CustomException;

	public List<CommonUtilityBean> getCommodityList();

	public List<SelectivityBean> getPortByEmpAgn();
	public List<SelectivityBean> getSurChargeList(String relateType);
	
	public List<AttributeBean> getAttributesList(String sAccountCode);
	
	public List<CommonUtilityBean> getAccountHeadDataCN();
	
	public List<SelectivityBean> getSpecialList();
	
	
	public List<CommonUtilityBean> getSubAccountCodeDatanew();


	public List<CommonUtilityBean> getCountryListPortmaster();

	public List<SelectivityBean> getOriginDestination();

	public List<CommonUtilityBean> getBankList();

	public List<SelectivityBean> getcargotype();
	
	public List<CommonUtilityBean> getServiceOperator();
	
	public List<CommonUtilityBean> getService();

	public List<CommonUtilityBean> getcarrierList();

	public List<CommonUtilityBean> gettransportList();

	public List<CommonUtilityBean> getQuoteApproveList1(String carrier,int mode);

	public List<SelectivityBean> getDepotListByPort(String portCode);

	public List<CommonUtilityBean> getQuoteApproveList_port(String carrier, String mode, String customer, String pol,
			String pod);

	public List<CommonUtilityBean> getcustomerlocal();

	public List<CommonUtilityBean> getsupplierlocal();

	public List<CommonUtilityBean> getsupplieroverseas();

	public List<CommonUtilityBean> getcustomeroverseas();

	public List<SelectivityBean> getCompanyListPurchase();

	public List<SelectivityBean> getCompanyListcompany();

	public CommonUtilityResultBean getCompanyListWithUser(String userId, String companyCode);

	public List<CommonUtilityBean> getSubAccountCodeList1();

	public List<CommonUtilityBean> getSubAccountCodeList();

	public List<SelectivityBean> getSubGroupAcctList();

	public List<CommonUtilityBean> getCrDtlAccountHeadDataNew();

	public CommonUtilityResultBean BudgetDefListCC(String costCenter);


	public List<CommonUtilityBean> getSubAccountCodeDataNew(String type);

	boolean updateInventoryAndLedgerIn(String stockId, String date, int i, int sourceLoc, int destLoc, int parseInt, double quantity, List<BatchAttributeBean> attributeBeans);

	boolean updateInventoryAndLedgerOut(String stockId, String date, int i, int destLoc, int sourceLoc, int parseInt, double quantity, List<BatchAttributeBean> attributeBeans);
	boolean updateInventoryAndLedgerInCheckQc(String stockId, String date, int i, int sourceLoc, int destLoc, int parseInt, double quantity, int qcStatus, List<BatchAttributeBean> attributeBeans);

	boolean updateInventoryAndLedgerOutCheckQc(String stockId, String date, int i, int destLoc, int sourceLoc, int parseInt, double quantity, int qcStatus, List<BatchAttributeBean> attributeBeans);

	List<TransferReceivedBean> getTransferNoList(String transferType) throws Exception;

	List<TransferReceivedDetailBean> getReceiveItemList(int id) throws Exception;

	List<BatchAttributeBean> getBatchDeatil(TransferReceivedBean attributeBeans) throws Exception;

	List<TransferReceivedBean> getReceivedList(int limit, int offset, String transferType);

	boolean saveTransferRecive(TransferReceivedBean bean);

	TransferReceivedBean getTransferReceiveView(Integer receivedId) throws Exception;

	public List<CommonUtilityBean> getSubAccountCodeNew(String sAccountCode) throws Exception;

	public List<CommonUtilityBean> getParentLocationList() throws Exception;



}
