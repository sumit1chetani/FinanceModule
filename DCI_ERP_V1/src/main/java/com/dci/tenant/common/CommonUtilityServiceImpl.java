package com.dci.tenant.common;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BatchAttributeBean;
import com.dci.common.util.CustomException;
import com.dci.common.util.DefTableBean;
import com.dci.master.attributes.AttributeBean;
import com.dci.tenant.finance.transferReceived.TransferReceivedBean;
import com.dci.tenant.finance.transferReceived.TransferReceivedDetailBean;


@Service
public class CommonUtilityServiceImpl implements CommonUtilityService {
	private final static Logger logger = LoggerFactory.getLogger(CommonUtilityServiceImpl.class);
	private static final String CACHE = "defaultCache";

	@Autowired
	CommonUtilityDAO commonUtilityDAO;
	
	private String inTransistLocation ="In Transit";
	
	private String qcRejectedLocation="Qc Rejected";

	@Override
	// @Cacheable(value = "defaultCache")
	public List<CommonUtilityBean> getCustomer() {
		// System.out.println("inside");
		return commonUtilityDAO.getCustomer();
	}
	
	@Override
	// @Cacheable(value = "defaultCache")
	public List<CommonUtilityBean> getSupplier() {
		// System.out.println("inside");
		return commonUtilityDAO.getSupplier();
	}
	
	@Override
	// @Cacheable(value = "defaultCache")
	public List<CommonUtilityBean> getVendor() {
		// System.out.println("inside");
		return commonUtilityDAO.getVendor();
	}
	/*@Override
	public List getCustList() {
		return commonUtilityDAO.getCustDropDownList();
	}*/

	@Override
	public List getSector() {
		return commonUtilityDAO.getSector();
	}

	@Override
	public List getPort() {
		return commonUtilityDAO.getPort();
	}
	
	@Override
	public List getTerminal() {
		return commonUtilityDAO.getTerminal();
	}


	@Override
	public List<SelectivityBean> getContainerTypeList() {
		return commonUtilityDAO.getContainerTypeList();
	}
	
	@Override
	public List<SelectivityBean> getLeaseAggTypeList() {
		return commonUtilityDAO.getLeaseAggTypeList();
	}
	
	/**
	 * get Account Head Data from ACCOUNT_HEAD_MASTER tbl
	 */
	@Override
	public List<CommonUtilityBean> getAccountHeadData() {
		return commonUtilityDAO.getAccountHeadData();
	}
	
	@Override
	public List<CommonUtilityBean> getAccountHeadData1() {
		return commonUtilityDAO.getAccountHeadData1();
	}

	@Override
	public List<CommonUtilityBean> getPhcContainers() {
		return commonUtilityDAO.getPhcContainers();
	}

	@Override
	public List<CommonUtilityBean> getSubAccountCodeData() {
		return commonUtilityDAO.getSubAccountCodeData();
	}
 

	@Override
	public List<CommonUtilityBean> getEmployeeList() {
		return commonUtilityDAO.getEmployeeList();
	}

	@Override
	public List<CommonUtilityBean> getPortList() {
		return commonUtilityDAO.getPortList();
	}
	
	@Override
	public List<CommonUtilityBean> getVendorList() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getVendorList();
	}
	
	@Override
	public List<CommonUtilityBean> getStuffingList() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getStuffingList();
	}
	
	@Override
	public List<CommonUtilityBean> getPortISO_portList() {
		return commonUtilityDAO.getPortISO_portList();
	}
	

	@Override
	public List<CommonUtilityBean> getDepartmentList() {
		return commonUtilityDAO.getDepartmentList();
	}

	@Override
	public List<CommonUtilityBean> getAgentList() {
		return commonUtilityDAO.getAgentList();
	}

	@Override
	public List<CommonUtilityBean> getCountryList() {
		return commonUtilityDAO.getCountryList();
	}

	@Override
	public List<CommonUtilityBean> getDesignationList() {
		return commonUtilityDAO.getDesignationList();
	}

	@Override
	public List<CommonUtilityBean> getCustomerList() {
		return commonUtilityDAO.getCustomerList();
	}

	@Override
	public double getExchangeRate(String currencyCode) {
		return commonUtilityDAO.getExchangeRate(currencyCode);
	}

	@Override
	public List<CommonUtilityBean> getVesselList() { 
		return commonUtilityDAO.getVesselList();
	}
	

	@Override
	public List<CommonUtilityBean> getQuoteApproveList() { 
		return commonUtilityDAO.getQuoteApproveList();
	}
	
	@Override
	public List<CommonUtilityBean> getQuoteApproveList1(String carrier,int mode) { 
		return commonUtilityDAO.getQuoteApproveList1( carrier,mode);
	}
	
	@Override
	public List<CommonUtilityBean> getLeasingPartyList() { 
		return commonUtilityDAO.getLeasingPartyList();
	}

	@Override
	public List<CommonUtilityBean> getSectorList() { 
		return commonUtilityDAO.getSectorList();
	}
	
	@Override
	public List<CommonUtilityBean> getSLot() {
		return commonUtilityDAO.getSLot();
	}
	
	@Override
	public List<CommonUtilityBean> getSubSLot() {
		return commonUtilityDAO.getSubSLot();
	}

	@Override
	public List<CommonUtilityBean> getVoyageList() {
		return commonUtilityDAO.getVoyageList();
	}

	@Override
	public List<SelectivityBean> getVoyageListByVessel(String vsl) {
		return commonUtilityDAO.getVoyageListByVessel(vsl);
	}
	
	@Override
	public List<SelectivityBean> getVoyageListByVessel1(String vsl) {
		return commonUtilityDAO.getVoyageListByVessel1(vsl);
	}
	
	@Override
	public List<SelectivityBean> getPortListByVoyage(String pod) {
		
		return commonUtilityDAO.getPortListByVoyage(pod);
		
	}
	
	@Override
	public List<SelectivityBean> getPortListByVoy(String voy) {
		return commonUtilityDAO.getPortListByVoy(voy);
	}
	
	@Override
	public List<SelectivityBean> getPortListByVoyNU(String voy) {
		return commonUtilityDAO.getPortListByVoyNU(voy);
	}
	
	@Override
	public List<CommonUtilityBean> getTripList() {
		return commonUtilityDAO.getTripList();
	}

	@Override
	public List<CommonUtilityBean> getSupplierList() {
		return commonUtilityDAO.getSupplierList();
	}

	@Override
	public List<CommonUtilityBean> getCompanyList() {
		return commonUtilityDAO.getCompanyList();
	}

	@Override
	public String getCompanyCurrency(String sCompanyCode) {
		return commonUtilityDAO.getCompanyCurrency(sCompanyCode);
	}

	@Override
	public List<CommonUtilityBean> getAccountSgList(String sSubGroupCode) {
		return commonUtilityDAO.getAccountSgList(sSubGroupCode);
	}

	@Override
	public List<CommonUtilityBean> getSubAccountCodeListTradeDebtors() {
		return commonUtilityDAO.getSubAccountCodeListTradeDebtors();
	}

	@Override
	public List<CommonUtilityBean> getSubAccountCodeListTradeCreditors() {
		return commonUtilityDAO.getSubAccountCodeListTradeCreditors();
	}

	@Override
	public boolean checkUniqueNameExists(String value, String fieldName, String screenName) {
		return commonUtilityDAO.checkUniqueNameExists(value, fieldName, screenName);
	}

	@Override
	public List<CommonUtilityBean> getCostCentreList() {
		return commonUtilityDAO.getCostCentreList();
	}

	 
	@Override
	public List<CommonUtilityBean> getCompanyLocationList() {
		return commonUtilityDAO.getCompanyLocationList();
	}
	
	@Override
	public List<CommonUtilityBean> getCompanyLocationListForBunker() {
		return commonUtilityDAO.getCompanyLocationListForBunker();
	}

	@Override
	public List<SelectivityBean> getStaffListForAdvances() {
		return commonUtilityDAO.getStaffListForAdvances();
	}

	@Override
	public List<CommonUtilityBean> getSubAccountCodeListTradeDebtorsCP() {
		return commonUtilityDAO.getSubAccountCodeListTradeDebtorsCP();
	}

	@Override
	public List<CommonUtilityBean> getSubAccountCodeListTradeDebtorsCR() {
		return commonUtilityDAO.getSubAccountCodeListTradeDebtorsCR();
	}

	@Override
	public CommonUtilityBean getVesselService(String sVoyageCode) {
		return commonUtilityDAO.getVesselService(sVoyageCode);
	}

	@Override
	public CommonUtilityBean getTruckService(String sVoyageCode) {
		return commonUtilityDAO.getTruckService(sVoyageCode);
	}

	@Override
	public double getDefaultExchangeRate(String currencyCode) {
		return commonUtilityDAO.getDefaultExchangeRate(currencyCode);
	}

	@Override
	public List<CommonUtilityBean> getassetList() {
		return commonUtilityDAO.getassetList();
	}

	@Override
	public List<CommonUtilityBean> getJvPartnerAccount() {
		return commonUtilityDAO.getJvPartnerAccount();
	}
 

	@Override
	public CommonUtilityBean getExchangeRateWithCurrency(String currencyCode) {
		return commonUtilityDAO.getExchangeRateWithCurrency(currencyCode);
	}

	@Override
	public List<CommonUtilityBean> getSectorBasedVessel(String sectorCode) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getSectorBasedVessel(sectorCode);
	}

	@Override
	public CommonUtilityBean getSupplierCurrency(String supplierCode) {
		return commonUtilityDAO.getSupplierCurrency(supplierCode);
	}

	@Override
	public CommonUtilityBean getCompanyName() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getCompanyName();
	}

	@Override
	public List<CommonUtilityBean> getSupplierListWthAcctCode() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getSupplierListWthAcctCode();
	}

	@Override
	public List<CommonUtilityBean> getSurchargePort() {
		return commonUtilityDAO.getSurchargePort();
	}

	@Override
	public CommonUtilityBean getExchangeRateWithCurrencyBySailingDate(String currencyCode, String sailingDate) {
		return commonUtilityDAO.getExchangeRateWithCurrencyBySailingDate(currencyCode,sailingDate);
	}

	@Override
	public CommonUtilityBean getExchangeRateWithCurrencyByMaxDate(String currencyCode) {
		return commonUtilityDAO.getExchangeRateWithCurrencyByMaxDate(currencyCode);
	}

	@Override
	public List<CommonUtilityBean> getSectorWiseCompany() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getSectorWiseCompany();
	}

	@Override
	public List<CommonUtilityBean> getonlySupplier(String accountCode) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getonlySupplier(accountCode);
	}

	@Override
	public List<CommonUtilityBean> getonlypayer() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getonlypayer();
	}
	
	@Override
	public List<CommonUtilityBean> getonlypayerForJV() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getonlypayerForJV();
	}
	
	@Override
	public List<CommonUtilityBean> getVessel() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getVessel();
	}
	
	@Override
	public List<CommonUtilityBean> getStaffList() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getStaffList();
	}
	
	@Override
	public List<CommonUtilityBean> getTripsList() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getTripsList();
	}

	@Override
	public List<CommonUtilityBean> geLocation() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.geLocation();
	}
	@Override
	public List<SelectivityBean> geLocation1() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.geLocation1();
	}

	@Override
	public List<DefTableBean> getDefTableList(Integer formFieldId) {
		return commonUtilityDAO.getDefTableList(formFieldId);
	}
	
	
	@Override
	public List<CommonUtilityBean> getChargeList() {
		return commonUtilityDAO.getChargeList();
	}

	@Override
	public List<CommonUtilityBean> getCurrencyList() {
		return commonUtilityDAO.getCurrencyList();
	}

	@Override
	public CommonUtilityResultBean getStockAvailablity(int locationId, int itemId) {
		return commonUtilityDAO.getStockAvailablity(locationId, itemId);
	}
	
	  
	@Override
	public List<CommonUtilityBean> getEntityData() throws Exception {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getEntityData();
	}
	
	@Override
	public List<BatchAttributeBean> getConsignmentBatchList(BatchAttributeBean bean) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getConsignmentBatchList(bean);
	}
	
	@Override
	public boolean updateInventoryAndLedgerIn(String stockId, String date, int i, int sourceLoc, int destLoc, int parseInt, int quantity, List<BatchAttributeBean> attributeBeans) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.updateInventoryAndLedgerIn(stockId, date, i, sourceLoc, destLoc, parseInt, quantity, inTransistLocation, attributeBeans);
	}

	@Override
	public boolean updateInventoryAndLedgerOut(String stockId, String date, int i, int destLoc, int sourceLoc, int parseInt, int quantity, List<BatchAttributeBean> attributeBeans) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.updateInventoryAndLedgerOut(stockId, date, i, destLoc, sourceLoc, parseInt, quantity, inTransistLocation, attributeBeans);
	}
	
	@Override
	public boolean updateInventoryAndLedgerInCheckQc(String stockId, String date, int i, int sourceLoc, int destLoc, int parseInt, int quantity, int qcStatus, List<BatchAttributeBean> attributeBeans) {
		// TODO Auto-generated method stub
		if (qcStatus == 148) {
			return commonUtilityDAO.updateInventoryAndLedgerInCheckQc(stockId, date, i, sourceLoc, destLoc, parseInt, quantity, qcRejectedLocation, qcStatus, attributeBeans);
		} else {
			return commonUtilityDAO.updateInventoryAndLedgerInCheckQc(stockId, date, i, sourceLoc, destLoc, parseInt, quantity, inTransistLocation, qcStatus, attributeBeans);
		}

	}

	@Override
	public boolean updateInventoryAndLedgerOutCheckQc(String stockId, String date, int i, int destLoc, int sourceLoc, int parseInt, int quantity, int qcStatus, List<BatchAttributeBean> attributeBeans) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.updateInventoryAndLedgerOutCheckQc(stockId, date, i, destLoc, sourceLoc, parseInt, quantity, inTransistLocation, qcStatus, attributeBeans);
	}

	@Override
	public List<SelectivityBean> getMode() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getMode();
	}

	@Override
	public List<SelectivityBean> getJobOrderNo() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getJobOrderNo();
	}
	
 
	@Override
	public List<CommonUtilityBean> getSubAccountCodeListTradeDebtorsIA() {
		return commonUtilityDAO.getSubAccountCodeListTradeDebtorsIA();
	}



	@Override
	public List<SelectivityBean> getCustomerCateory() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getCustomerCateory();
	}

	@Override
	public List getVoyageList(String vesselCode) {
		return commonUtilityDAO.getVoyageList(vesselCode);
	}

	@Override
	public List<CommonUtilityBean> getPayerList() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getPayerList();
	}
 
	@Override
	public List<CommonUtilityBean> getsupplierList() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getsupplierList();
	}
	
	@Override
	public List<CommonUtilityBean> getAccountListDrpDwn() throws CustomException {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getAccountListDrpDwn();
	}
	
	@Override
	public List<CommonUtilityBean> getCommodityList() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getCommodityList();
	}

	@Override
	public List<SelectivityBean> getPortByEmpAgn() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getPortByEmpAgn();
	}
	
	@Override
	public List<SelectivityBean> getSurChargeList(String relateType) {
		return commonUtilityDAO.getSurChargeList(relateType);
	}
	
	@Override
	public List<AttributeBean> getAttributesList(String sAccountCode) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getAttributesList(sAccountCode);
	}
	
	@Override
	public List<CommonUtilityBean> getAccountHeadDataCN() {
		return commonUtilityDAO.getAccountHeadDataCN();
	}

	@Override
	public List<CommonUtilityBean> getcustomerList() {
		// TODO Auto-generated method stub
		return  commonUtilityDAO.getcustomerList();
	}

	@Override
	public List<CommonUtilityBean> getCustomerListFilter(CommonUtilityBean objCommonUtilityBean) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getCustomerListFilter(objCommonUtilityBean);
	}

	@Override
	public List<SelectivityBean> getPortwithSequence(String voyage) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getPortwithSequence(voyage);
	}

	@Override
	public List<SelectivityBean> getSpecialList() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getSpecialList();
	}
	
	
	

	
	@Override
	public List<CommonUtilityBean> getSubAccountCodeDatanew() {
		return commonUtilityDAO.getSubAccountCodeDatanew();
	}


	@Override
	public List<CommonUtilityBean> getCountryListPortmaster() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getCountryListPortmaster();
	}


	@Override
	public List<SelectivityBean> getOriginDestination() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getOriginDestination();
	}

	@Override
	public List<CommonUtilityBean> getBankList() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getBankList();
	}
	
	
	@Override
	public List<SelectivityBean> getcargotype() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getcargotype();
	}
	
	@Override
	public List<CommonUtilityBean> getServiceOperator() { 
		return commonUtilityDAO.getServiceOperator();
	}

	@Override
	public List<CommonUtilityBean> getService() { 
		return commonUtilityDAO.getService();
	}

	@Override
	public List<CommonUtilityBean> getcarrierList() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getcarrierList();
	}
	@Override
	public List<CommonUtilityBean> gettransportList() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.gettransportList();
	}
	@Override
	public List<SelectivityBean> getDepotListByPort(String portCode) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getDepotListByPort(portCode);
	}

	@Override
	public List<CommonUtilityBean> getQuoteApproveList_port(String carrier, String mode, String customer, String pol,
			String pod) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getQuoteApproveList_port(carrier, mode,customer,pol,pod);
	}

	@Override
	public List<CommonUtilityBean> getcustomerlocal() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getcustomerlocal();
	}

	@Override
	public List<CommonUtilityBean> getsupplierlocal() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getsupplierlocal();
	}

	@Override
	public List<CommonUtilityBean> getsupplieroverseas() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getsupplieroverseas();
	}

	@Override
	public List<CommonUtilityBean> getcustomeroverseas() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getcustomeroverseas();
	}

	@Override
	public List<SelectivityBean> getCompanyListPurchase() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getCompanyListPurchase();
	}

	@Override
	public List<SelectivityBean> getCompanyListcompany() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getCompanyListcompany();
	}

	@Override
	public CommonUtilityResultBean getCompanyListWithUser(String userId, String companyCode) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getCompanyListWithUser(userId,companyCode);
	}

	@Override
	public List<CommonUtilityBean> getSubAccountCodeList1() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getSubAccountCodeList1();
	}

	@Override
	public List<CommonUtilityBean> getSubAccountCodeList() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getSubAccountCodeList();
	}

	@Override
	public List<SelectivityBean> getSubGroupAcctList() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getSubGroupAcctList();
	}

	@Override
	public List<CommonUtilityBean> getCrDtlAccountHeadDataNew() {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getCrDtlAccountHeadDataNew();
	}

	@Override
	public CommonUtilityResultBean BudgetDefListCC(String costCenter) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.BudgetDefListCC(costCenter);
	}

	@Override
	public List<CommonUtilityBean> getSubAccountCodeDataNew(String type) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getSubAccountCodeDataNew(type) ;
	}

	@Override
	public boolean updateInventoryAndLedgerIn(String stockId, String date, int i, int sourceLoc, int destLoc, int parseInt, double quantity, List<BatchAttributeBean> attributeBeans) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.updateInventoryAndLedgerIn(stockId, date, i, sourceLoc, destLoc, parseInt, quantity, inTransistLocation, attributeBeans);
	}

	@Override
	public boolean updateInventoryAndLedgerOut(String stockId, String date, int i, int destLoc, int sourceLoc, int parseInt, double quantity, List<BatchAttributeBean> attributeBeans) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.updateInventoryAndLedgerOut(stockId, date, i, destLoc, sourceLoc, parseInt, quantity, inTransistLocation, attributeBeans);
	}

	@Override
	public boolean updateInventoryAndLedgerInCheckQc(String stockId, String date, int i, int sourceLoc, int destLoc, int parseInt, double quantity, int qcStatus, List<BatchAttributeBean> attributeBeans) {
		// TODO Auto-generated method stub
		if (qcStatus == 148) {
			return commonUtilityDAO.updateInventoryAndLedgerInCheckQc(stockId, date, i, sourceLoc, destLoc, parseInt, quantity, qcRejectedLocation, qcStatus, attributeBeans);
		} else {
			return commonUtilityDAO.updateInventoryAndLedgerInCheckQc(stockId, date, i, sourceLoc, destLoc, parseInt, quantity, inTransistLocation, qcStatus, attributeBeans);
		}

	}

	@Override
	public boolean updateInventoryAndLedgerOutCheckQc(String stockId, String date, int i, int destLoc, int sourceLoc, int parseInt, double quantity, int qcStatus, List<BatchAttributeBean> attributeBeans) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.updateInventoryAndLedgerOutCheckQc(stockId, date, i, destLoc, sourceLoc, parseInt, quantity, inTransistLocation, qcStatus, attributeBeans);
	}

	@Override
	public List<TransferReceivedBean> getTransferNoList(String transferType) throws Exception {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getTransferNoList(transferType);
	}

	@Override
	public List<TransferReceivedDetailBean> getReceiveItemList(int id) throws Exception {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getReceiveItemList(id);
	}

	@Override
	public List<TransferReceivedBean> getReceivedList(int limit, int offset, String transferType) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getReceivedList(limit, offset, transferType);
	}

	@Override
	public boolean saveTransferRecive(TransferReceivedBean bean) {
		// TODO Auto-generated method stub
		return commonUtilityDAO.saveTransferRecive(bean);
	}

	@Override
	public TransferReceivedBean getTransferReceiveView(Integer receivedId) throws Exception {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getTransferReceiveView(receivedId);

	}

	@Override
	public List<BatchAttributeBean> getBatchDeatil(TransferReceivedBean attributeBeans) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommonUtilityBean> getSubAccountCodeNew(String sAccountCode) throws Exception {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getSubAccountCodeNew(sAccountCode);
	}

	@Override
	public List<CommonUtilityBean> getParentLocationList() throws Exception {
		// TODO Auto-generated method stub
		return commonUtilityDAO.getParentLocationList();
	}
	
}
