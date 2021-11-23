package com.dci.tenant.common;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BatchAttributeBean;
import com.dci.common.util.CustomException;
import com.dci.master.attributes.AttributeBean;
import com.dci.tenant.user.UserDetail;
@RestController
@RequestMapping(value = "{tenantid}/app/commonUtility")
public class CommonUtilityController {
	private final static Logger LOGGER = LoggerFactory.getLogger(CommonUtilityController.class);
	@Autowired
	CommonUtilityService commonUtilityService;

	@RequestMapping("/getcustomer")
	public @ResponseBody CommonUtilityResultBean getCustomer() throws CustomException {
		// System.out.println(new Date());
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();
		String value = "getMlo";
		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getCustomer());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		// System.out.println(new Date());
		return commonUtilityResultBean;
	}
	
	@RequestMapping("/getsupplier")
	public @ResponseBody CommonUtilityResultBean getSupplier() throws CustomException {
		// System.out.println(new Date());
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();
		String value = "getMlo";
		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getSupplier());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		// System.out.println(new Date());
		return commonUtilityResultBean;
	}
	@RequestMapping("/getcarrierList")
	public @ResponseBody CommonUtilityResultBean getcarrierList() throws CustomException {
		// System.out.println(new Date());
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();
		String value = "getMlo";
		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getcarrierList());
            commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		// System.out.println(new Date());
		return commonUtilityResultBean;
	}
	@RequestMapping("/gettransportList")
	public @ResponseBody CommonUtilityResultBean gettransportList() throws CustomException {
		// System.out.println(new Date());
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();
		String value = "getMlo";
		try {
            commonUtilityResultBean.setlCommonUtilityBean(commonUtilityService.gettransportList());
            commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		// System.out.println(new Date());
		return commonUtilityResultBean;
	}
	@RequestMapping("/getvendor")
	public @ResponseBody CommonUtilityResultBean getVendorlist() throws CustomException {
		// System.out.println(new Date());
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();
		String value = "getMlo";
		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getVendor());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		// System.out.println(new Date());
		return commonUtilityResultBean;
	}
	

	
	/*@RequestMapping("/dropDownList")
	public @ResponseBody LoadingSummaryResultBean getDropDownList() throws CustomException {

		List voyageList = new ArrayList();
		List custList = new ArrayList();
		LoadingSummaryResultBean objLoadingSummaryResultBean = new LoadingSummaryResultBean();
		try {
			custList = commonUtilityService.getCustList();
			objLoadingSummaryResultBean.setCustList(custList);
		} catch (Exception e) {
			LOGGER.error("Error", e);

		}

		return objLoadingSummaryResultBean;
	}*/


	@RequestMapping("/getSector")
	public @ResponseBody CommonUtilityResultBean getSector() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getSector());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	@RequestMapping("/getLocation")
	public @ResponseBody CommonUtilityResultBean getLocation() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.geLocation());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	@RequestMapping("/getLocation1")
	public @ResponseBody CommonUtilityResultBean getLocation1() throws CustomException {
		CommonUtilityResultBean commonUtility = new CommonUtilityResultBean();

		try {
			commonUtility.setlCommonUtilityBean1(commonUtilityService.geLocation1());
			commonUtility.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtility;
	}
	@RequestMapping("/getSLot")
	public @ResponseBody List<CommonUtilityBean> getSLot() throws CustomException {
		List<CommonUtilityBean> lAttributeList = new ArrayList<CommonUtilityBean>();
		try {
			lAttributeList = commonUtilityService.getSLot();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lAttributeList;
	}
	
	@RequestMapping("/getSubSLot")
	public @ResponseBody List<CommonUtilityBean> getSubSLot() throws CustomException {
		List<CommonUtilityBean> lAttributeList = new ArrayList<CommonUtilityBean>();
		try {
			lAttributeList = commonUtilityService.getSubSLot();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lAttributeList;
	}

	
	/**
	 * get Account Head Data from ACCOUNT_HEAD_MASTER tbl
	 *
	 * @return
	 * @throws CustomException
	 */
	@RequestMapping("/getCrDtlAccountHeadData")
	public @ResponseBody CommonUtilityResultBean getCrDtlAccountHeadData() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getAccountHeadData());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	
	@RequestMapping("/getCrDtlAccountHeadData1")
	public @ResponseBody CommonUtilityResultBean getCrDtlAccountHeadData1() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getAccountHeadData1());
			
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}

	@RequestMapping("/getPhcContainers")
	public @ResponseBody CommonUtilityResultBean getPhcContainers() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getPhcContainers());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}

	
	@RequestMapping("/getPortByEmpAgn")
	public @ResponseBody List<SelectivityBean> getSurChargeList() {
	
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();
		
		list=commonUtilityService.getPortByEmpAgn();

		return list;
	}
	
	
	@RequestMapping("/getSpecialList")
	public @ResponseBody List<SelectivityBean> getSpecialList() {
	
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();
		
		list=commonUtilityService.getSpecialList();

		return list;
	}
	/**
	 * get Account Port Code list from Port Master tbl.
	 *
	 * @return
	 * @throws CustomException
	 */

	@RequestMapping("/getPort")
	public @ResponseBody CommonUtilityResultBean getPort() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getPort());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	
	
	@RequestMapping("/getPortwithSequence")
	public @ResponseBody List<SelectivityBean> getPortwithSequence(@RequestBody String voyage) throws CustomException {
		List<SelectivityBean> voyageLst = new ArrayList<SelectivityBean>();

		try {
			voyageLst=commonUtilityService.getPortwithSequence(voyage);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return voyageLst;
	}
	
	
	
	
	@RequestMapping("/getTerminal")
	public @ResponseBody CommonUtilityResultBean getTerminal() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getTerminal());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	
	

	@RequestMapping("/getContainerTypeList")
	public @ResponseBody CommonUtilityResultBean getContainerTypeList() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setContainerTypeList(commonUtilityService.getContainerTypeList());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	
	@RequestMapping("/getLeaseAggTypeList")
	public @ResponseBody CommonUtilityResultBean getLeaseAggTypeList() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setLeaseAggTypeList(commonUtilityService.getLeaseAggTypeList());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	
	@RequestMapping("/getCustomerCateory")
	public @ResponseBody CommonUtilityResultBean getCustomerCateory() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCustomercategory(commonUtilityService.getCustomerCateory());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	
	@RequestMapping("/getSubAccountCodeList")
	public @ResponseBody CommonUtilityResultBean getSubAccountCodeData() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getSubAccountCodeData());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
 
 
	
	
	@RequestMapping("/getAccountSgList")
	public @ResponseBody List<CommonUtilityBean> getAccountSgList(@RequestParam("subgroupcode") String sSubGroupCode) throws CustomException {
		List<CommonUtilityBean> lAccountSgList = new ArrayList<CommonUtilityBean>();
		try {
			lAccountSgList = commonUtilityService.getAccountSgList(sSubGroupCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lAccountSgList;
	}

	@RequestMapping("/getVoyageList")
	public @ResponseBody List<CommonUtilityBean> getVoyageList() throws CustomException {
		List<CommonUtilityBean> voyageLst = new ArrayList<CommonUtilityBean>();
		try {
			voyageLst = commonUtilityService.getVoyageList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return voyageLst;
	}
	
	@RequestMapping("/getVoyageListByVessel")
	public @ResponseBody List<SelectivityBean> getVoyageListByVessel(@RequestBody String vslCode) throws CustomException {
		List<SelectivityBean> voyageLst = new ArrayList<SelectivityBean>();
		try {
			voyageLst = commonUtilityService.getVoyageListByVessel(vslCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return voyageLst;
	}
	
	@RequestMapping("/getVoyageListByVessel1")
	public @ResponseBody List<SelectivityBean> getVoyageListByVessel1(@RequestBody String vslCode) throws CustomException {
		List<SelectivityBean> voyageLst = new ArrayList<SelectivityBean>();
		try {
			voyageLst = commonUtilityService.getVoyageListByVessel1(vslCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return voyageLst;
	}
	
	
	@RequestMapping("/getPortListByVoyage")
	public @ResponseBody List<SelectivityBean> getPortListByVoyage(@RequestBody String podCode) throws CustomException {
		/////////////////ports loaded along with sequence////////////////
		List<SelectivityBean> voyageLst = new ArrayList<SelectivityBean>();
		try {
			voyageLst = commonUtilityService.getPortListByVoyage(podCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return voyageLst;
	}
	
	@RequestMapping("/getPortListByVoy")
	public @ResponseBody List<SelectivityBean> getPortListByVoy(@RequestBody String voyage) throws CustomException {
		///////without port sequence ports loaded based on emp or agent////////////
		List<SelectivityBean> voyageLst = new ArrayList<SelectivityBean>();
		try {
			voyageLst = commonUtilityService.getPortListByVoy(voyage);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return voyageLst;
	}
	
	@RequestMapping("/getPortListByVoyNU")
	public @ResponseBody List<SelectivityBean> getPortListByVoyNU(@RequestBody String voyage) throws CustomException {
		///////without port sequence ports loaded NOT based on emp or agent////////////
		List<SelectivityBean> voyageLst = new ArrayList<SelectivityBean>();
		try {
			voyageLst = commonUtilityService.getPortListByVoyNU(voyage);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return voyageLst;
	}
	
	@RequestMapping("/getTripList")
	public @ResponseBody List<CommonUtilityBean> getTripList() throws CustomException {
		List<CommonUtilityBean> voyageLst = new ArrayList<CommonUtilityBean>();
		try {
			voyageLst = commonUtilityService.getTripList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return voyageLst;
	}

	@RequestMapping("/getVesselList")
	public @ResponseBody List<CommonUtilityBean> getVesselList() throws CustomException {
		List<CommonUtilityBean> vesselList = new ArrayList<CommonUtilityBean>();
		try {
			vesselList = commonUtilityService.getVesselList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return vesselList;
	}
	
	@RequestMapping("/getQuoteApproveList")
	public @ResponseBody List<CommonUtilityBean> getQuoteApproveList() throws CustomException {
		List<CommonUtilityBean> vesselList = new ArrayList<CommonUtilityBean>();
		try {
			vesselList = commonUtilityService.getQuoteApproveList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return vesselList;
	}
	@RequestMapping("/getQuoteApproveList1")
	public @ResponseBody List<CommonUtilityBean> getQuoteApproveList1(String carrier,int mode) throws CustomException {
		List<CommonUtilityBean> vesselList = new ArrayList<CommonUtilityBean>();
		try {
			vesselList = commonUtilityService.getQuoteApproveList1( carrier, mode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return vesselList;
	}
	@RequestMapping("/getQuoteApproveList_port")
	public @ResponseBody List<CommonUtilityBean> getQuoteApproveList_port(String carrier,String mode,String customer,String pol,String pod) throws CustomException {
		List<CommonUtilityBean> vesselList = new ArrayList<CommonUtilityBean>();
		try {
			vesselList = commonUtilityService.getQuoteApproveList_port( carrier, mode,customer,pol,pod);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return vesselList;
	}
	@RequestMapping("/getLeasingPartyList")
	public @ResponseBody List<CommonUtilityBean> getLeasingPartyList() throws CustomException {
		List<CommonUtilityBean> LeasingPartyList = new ArrayList<CommonUtilityBean>();
		try {
			LeasingPartyList = commonUtilityService.getLeasingPartyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return LeasingPartyList;
	}

	@RequestMapping("/getSectorList")
	public @ResponseBody List<CommonUtilityBean> getSectorList() throws CustomException {
		List<CommonUtilityBean> sectorList = new ArrayList<CommonUtilityBean>();
		try {
			sectorList = commonUtilityService.getSectorList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return sectorList;
	}

	@RequestMapping("/getEmployeeList")
	public @ResponseBody List<CommonUtilityBean> getEmployeeList() throws CustomException {
		List<CommonUtilityBean> lEmployeeList = new ArrayList<CommonUtilityBean>();
		try {
			lEmployeeList = commonUtilityService.getEmployeeList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lEmployeeList;
	}

	@RequestMapping("/getPortList")
	public @ResponseBody List<CommonUtilityBean> getPortList() throws CustomException {
		List<CommonUtilityBean> lPortList = new ArrayList<CommonUtilityBean>();
		try {
			lPortList = commonUtilityService.getPortList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lPortList;
	}
	

	@RequestMapping("/getPayerList")
	public @ResponseBody List<CommonUtilityBean> getPayerList() throws CustomException {
		List<CommonUtilityBean> lPayerList = new ArrayList<CommonUtilityBean>();
		try {
			lPayerList = commonUtilityService.getPayerList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lPayerList;
	}
	@RequestMapping("/getsupplierandvendor")
	public @ResponseBody List<CommonUtilityBean> getList() throws CustomException {
		List<CommonUtilityBean> lPayerList = new ArrayList<CommonUtilityBean>();
		try {
			lPayerList = commonUtilityService.getsupplierList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lPayerList;
	}
 
	@RequestMapping("/getCommodityList")
	public @ResponseBody List<CommonUtilityBean> getCommodityList() throws CustomException {
		List<CommonUtilityBean> lPayerList = new ArrayList<CommonUtilityBean>();
		try {
			lPayerList = commonUtilityService.getCommodityList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lPayerList;
	}
	
	@RequestMapping("/getVendorList")
	public @ResponseBody List<CommonUtilityBean> getVendorList() throws CustomException {
		List<CommonUtilityBean> VendorList = new ArrayList<CommonUtilityBean>();
		try {
			VendorList = commonUtilityService.getVendorList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return VendorList;
	}
	
	@RequestMapping("/getStuffingList")
	public @ResponseBody List<CommonUtilityBean> getStuffingList() throws CustomException {
		List<CommonUtilityBean> stuffList = new ArrayList<CommonUtilityBean>();
		try {
			stuffList = commonUtilityService.getStuffingList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return stuffList;
	}
	
	
	@RequestMapping("/getPortISO_portList")
	public @ResponseBody List<CommonUtilityBean> getPortISO_portList() throws CustomException {
		List<CommonUtilityBean> lPortList = new ArrayList<CommonUtilityBean>();
		try {
			lPortList = commonUtilityService.getPortISO_portList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lPortList;
	}

	@RequestMapping("/getDepartmentList")
	public @ResponseBody List<CommonUtilityBean> getDepartmentList() throws CustomException {
		List<CommonUtilityBean> lDepartmentList = new ArrayList<CommonUtilityBean>();
		try {
			lDepartmentList = commonUtilityService.getDepartmentList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lDepartmentList;
	}

	@RequestMapping("/getAgentList")
	public @ResponseBody List<CommonUtilityBean> getAgentList() throws CustomException {
		List<CommonUtilityBean> lAgentList = new ArrayList<CommonUtilityBean>();
		try {
			lAgentList = commonUtilityService.getAgentList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lAgentList;
	}

	@RequestMapping("/getCountryList")
	public @ResponseBody List<CommonUtilityBean> getCountryList() throws CustomException {
		List<CommonUtilityBean> lCountryList = new ArrayList<CommonUtilityBean>();
		try {
			lCountryList = commonUtilityService.getCountryList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lCountryList;
	}

	@RequestMapping("/getDesignationList")
	public @ResponseBody List<CommonUtilityBean> getDesignationList() throws CustomException {
		List<CommonUtilityBean> lDesignationList = new ArrayList<CommonUtilityBean>();
		try {
			lDesignationList = commonUtilityService.getDesignationList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lDesignationList;
	}

	@RequestMapping("/getCustomerList")
	public @ResponseBody List<CommonUtilityBean> getCustomerList() throws CustomException {
		List<CommonUtilityBean> lCustomerList = new ArrayList<CommonUtilityBean>();
		try {
			lCustomerList = commonUtilityService.getCustomerList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lCustomerList;
	}
	
	@RequestMapping("/getCustomerListFilter")
	public @ResponseBody List<CommonUtilityBean> getCustomerListFilter(@RequestBody CommonUtilityBean objCommonUtilityBean) throws CustomException {
		List<CommonUtilityBean> lCustomerList = new ArrayList<CommonUtilityBean>();
		try {
			lCustomerList = commonUtilityService.getCustomerListFilter(objCommonUtilityBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lCustomerList;
	}


	@RequestMapping("/getSupplierList")
	public @ResponseBody List<CommonUtilityBean> getSupplierList() throws CustomException {
		List<CommonUtilityBean> lSupplierList = new ArrayList<CommonUtilityBean>();
		try {
			lSupplierList = commonUtilityService.getSupplierList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lSupplierList;
	}

	@RequestMapping("/getCompanyList")
	public @ResponseBody List<CommonUtilityBean> getCompanyList() throws CustomException {
		List<CommonUtilityBean> lCompanyList = new ArrayList<CommonUtilityBean>();
		try {
			lCompanyList = commonUtilityService.getCompanyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lCompanyList;
	}

	@RequestMapping("/getCompanyLocationList")
	public @ResponseBody List<CommonUtilityBean> getCompanyLocationList() throws CustomException {
		List<CommonUtilityBean> lCompanyList = new ArrayList<CommonUtilityBean>();
		try {
			lCompanyList = commonUtilityService.getCompanyLocationList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lCompanyList;
	}
	
	@RequestMapping("/getCompanyLocationListForBunker")
	public @ResponseBody List<CommonUtilityBean> getCompanyLocationListForBunker() throws CustomException {
		List<CommonUtilityBean> lCompanyList = new ArrayList<CommonUtilityBean>();
		try {
			lCompanyList = commonUtilityService.getCompanyLocationListForBunker();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lCompanyList;
	}

	@RequestMapping("/getCompanyCurrency")
	public @ResponseBody CommonUtilityBean getCompanyCurrency(@RequestParam("CompanyCode") String sCompanyCode) throws CustomException {
		String sCompanyCurrency = "";
		CommonUtilityBean objCommonUtilityBean = new CommonUtilityBean();
		try {
			sCompanyCurrency = commonUtilityService.getCompanyCurrency(sCompanyCode);
			objCommonUtilityBean.setCurrencyCode(sCompanyCurrency);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objCommonUtilityBean;
	}

	@RequestMapping("/getExchangeRate")
	public @ResponseBody double getExchangeRate(@RequestParam("currencyCode") String CurrencyCode) throws CustomException {
		double dExchangeRate = 1.0;
		try {
			dExchangeRate = commonUtilityService.getExchangeRate(CurrencyCode);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return dExchangeRate;
	}

	@RequestMapping("/getExchangeRateWithCurrency")
	public @ResponseBody CommonUtilityBean getExchangeRateWithCurrency(@RequestParam("currencyCode") String CurrencyCode) throws CustomException {
		CommonUtilityBean objCommonUtilityBean = new CommonUtilityBean();
		try {
			objCommonUtilityBean = commonUtilityService.getExchangeRateWithCurrency(CurrencyCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objCommonUtilityBean;
	}
	
	
	
	@RequestMapping("/getExchangeRateWithCurrencyByMaxDate")
	public @ResponseBody CommonUtilityBean getExchangeRateWithCurrencyByMaxDate(@RequestParam("currencyCode") String CurrencyCode) throws CustomException {
		CommonUtilityBean objCommonUtilityBean = new CommonUtilityBean();
		try {
			objCommonUtilityBean = commonUtilityService.getExchangeRateWithCurrencyByMaxDate(CurrencyCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objCommonUtilityBean;
	}
	
	@RequestMapping("/getExchangeRateWithCurrencyBySailingDate")
	public @ResponseBody CommonUtilityBean getExchangeRateWithCurrencyBySailingDate(@RequestParam("currencyCode") String CurrencyCode,@RequestParam("sailingDate") String sailingDate) throws CustomException {
		CommonUtilityBean objCommonUtilityBean = new CommonUtilityBean();
		try {
			objCommonUtilityBean = commonUtilityService.getExchangeRateWithCurrencyBySailingDate(CurrencyCode,sailingDate);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objCommonUtilityBean;
	}
	
	
	@RequestMapping("/getDefaultExchangeRate")
	public @ResponseBody double getDefaultExchangeRate(@RequestParam("currencyCode") String CurrencyCode) throws CustomException {
		double dExchangeRate = 1.0;
		try {
			dExchangeRate = commonUtilityService.getDefaultExchangeRate(CurrencyCode);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return dExchangeRate;
	}

	@RequestMapping("/getSubAccountCodeListTradeDebtors")
	public @ResponseBody List<CommonUtilityBean> getSubAccountCodeListTradeDebtors() throws CustomException {
		List<CommonUtilityBean> lSubAccountList = new ArrayList<CommonUtilityBean>();
		try {
			lSubAccountList = commonUtilityService.getSubAccountCodeListTradeDebtors();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lSubAccountList;
	}
	
	@RequestMapping("/getonlypayer")
	public @ResponseBody List<CommonUtilityBean> getonlypayer() throws CustomException {
		List<CommonUtilityBean> lSubAccountList = new ArrayList<CommonUtilityBean>();
		try {
			lSubAccountList = commonUtilityService.getonlypayer();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lSubAccountList;
	}
	
	@RequestMapping("/getonlypayerForJV")
	public @ResponseBody List<CommonUtilityBean> getonlypayerForJV() throws CustomException {
		List<CommonUtilityBean> lSubAccountList = new ArrayList<CommonUtilityBean>();
		try {
			lSubAccountList = commonUtilityService.getonlypayerForJV();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lSubAccountList;
	}
	
	@RequestMapping("/getcustomerList")
	public @ResponseBody List<CommonUtilityBean> getcustomerList() throws CustomException {
		List<CommonUtilityBean> lSubAccountList = new ArrayList<CommonUtilityBean>();
		try {
			lSubAccountList = commonUtilityService.getcustomerList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lSubAccountList;
	}

	@RequestMapping("/getonlySupplier")
	public @ResponseBody List<CommonUtilityBean> getonlySupplier(@RequestParam("accountCode") String accountCode) throws CustomException {
		List<CommonUtilityBean> lSubAccountList = new ArrayList<CommonUtilityBean>();
		try {
			lSubAccountList = commonUtilityService.getonlySupplier(accountCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lSubAccountList;
	}
	@RequestMapping("/getSubAccountCodeListTradeDebtorsCP")
	public @ResponseBody List<CommonUtilityBean> getSubAccountCodeListTradeDebtorsCP() throws CustomException {
		List<CommonUtilityBean> lSubAccountList = new ArrayList<CommonUtilityBean>();
		try {
			lSubAccountList = commonUtilityService.getSubAccountCodeListTradeDebtorsCP();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lSubAccountList;
	}
	
	@RequestMapping("/getSubAccountCodeListTradeDebtorsCR")
	public @ResponseBody List<CommonUtilityBean> getSubAccountCodeListTradeDebtorsCR() throws CustomException {
		List<CommonUtilityBean> lSubAccountList = new ArrayList<CommonUtilityBean>();
		try {
			lSubAccountList = commonUtilityService.getSubAccountCodeListTradeDebtorsCR();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lSubAccountList;
	}

	@RequestMapping("/getSubAccountCodeListTradeCreditors")
	public @ResponseBody List<CommonUtilityBean> getSubAccountCodeListTradeCreditors() throws CustomException {
		List<CommonUtilityBean> lSubAccountList = new ArrayList<CommonUtilityBean>();
		try {
			lSubAccountList = commonUtilityService.getSubAccountCodeListTradeCreditors();
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return lSubAccountList;
	}
	
	@RequestMapping("/getassetList")
	public @ResponseBody List<CommonUtilityBean> getassetList() throws CustomException {
		List<CommonUtilityBean> lAssetList = new ArrayList<CommonUtilityBean>();
		try {
			lAssetList = commonUtilityService.getassetList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return lAssetList;
	}
	
	@RequestMapping("/getStaffListForAdvances")
	public @ResponseBody List<SelectivityBean> getStaffListForAdvances() throws CustomException {
		List<SelectivityBean> lSubAccountList = new ArrayList<>();
		try {
			lSubAccountList = commonUtilityService.getStaffListForAdvances();
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return lSubAccountList;
	}

	@RequestMapping("/getJvPartnerAccount")
	public @ResponseBody List<CommonUtilityBean> getJvPartnerAccount() throws CustomException {
		List<CommonUtilityBean> lSubAccountList = new ArrayList<CommonUtilityBean>();
		try {
			lSubAccountList = commonUtilityService.getJvPartnerAccount();
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return lSubAccountList;
	}
	/**
	 * get Account Head Data from ACCOUNT_HEAD_MASTER tbl
	 *
	 * @return
	 * @throws CustomException
	 */
	@RequestMapping("/getCostCentreData")
	public @ResponseBody CommonUtilityResultBean getCostCentreList() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getCostCentreList());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}

	@RequestMapping("/checkUniqueNameExists")
	public @ResponseBody boolean checkUniqueNameExists(@RequestParam("codeAndName") String value, @RequestParam("formfield") String fieldName,
			@RequestParam("screenName") String screenName) throws CustomException {
		boolean isSuccess = false;
		try {
			isSuccess = commonUtilityService.checkUniqueNameExists(value, fieldName, screenName);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isSuccess;
	}
 

	@RequestMapping("/getVesselService")
	public @ResponseBody CommonUtilityBean getVesselService(@RequestParam("voyageCode") String sVoyageCode) throws CustomException {
		CommonUtilityBean objCommonUtilityBean = new CommonUtilityBean();
		try {
			objCommonUtilityBean = commonUtilityService.getVesselService(sVoyageCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objCommonUtilityBean;
	}
	
	@RequestMapping("/getTruckService")
	public @ResponseBody CommonUtilityBean getTruckService(@RequestParam("voyageCode") String sVoyageCode) throws CustomException {
		CommonUtilityBean objCommonUtilityBean = new CommonUtilityBean();
		try {
			objCommonUtilityBean = commonUtilityService.getTruckService(sVoyageCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objCommonUtilityBean;
	}
	
	@RequestMapping("/getSectorVessel")
	public @ResponseBody List<CommonUtilityBean> SectorBasedVessel(@RequestParam("sectorCode") String sectorCode) throws CustomException {
		List<CommonUtilityBean> objCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			objCommonUtilityBean = commonUtilityService.getSectorBasedVessel(sectorCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objCommonUtilityBean;
	}
	
	@RequestMapping("/getSupplierCurrency")
	public @ResponseBody CommonUtilityBean getSupplierCurrency(@RequestParam("supplierCode") String supplierCode) throws CustomException {
		CommonUtilityBean objCommonUtilityBean = new CommonUtilityBean();
		try {
			objCommonUtilityBean = commonUtilityService.getSupplierCurrency(supplierCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objCommonUtilityBean;
	}
	@RequestMapping("/companyName")
	public @ResponseBody CommonUtilityBean getCompanyName() throws CustomException {
		CommonUtilityBean commonUtilityBean = new CommonUtilityBean();

		try {
			commonUtilityBean=commonUtilityService.getCompanyName();
		 
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityBean;
	}
	@RequestMapping("/getAccountCodeListSupplier")
	public @ResponseBody List<CommonUtilityBean> getSupplierListWthAcctCode() throws CustomException {
		List<CommonUtilityBean> lsupplierList = new ArrayList<CommonUtilityBean>();
		try {
			lsupplierList = commonUtilityService.getSupplierListWthAcctCode();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lsupplierList;
	}
	@RequestMapping("/getSurchargePort")
	public @ResponseBody CommonUtilityResultBean getSurchargePort() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getSurchargePort());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	@RequestMapping("/getSectorCompany")
	public @ResponseBody List<CommonUtilityBean> getSectorWiseCompany() throws CustomException {
		List<CommonUtilityBean> lsupplierList = new ArrayList<CommonUtilityBean>();
		try {
			lsupplierList = commonUtilityService.getSectorWiseCompany();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lsupplierList;
	}
	
	@RequestMapping("/getVessel")
	public @ResponseBody List<CommonUtilityBean> getVessel() throws CustomException {
		List<CommonUtilityBean> vesselList = new ArrayList<CommonUtilityBean>();
		try {
			vesselList = commonUtilityService.getVessel();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return vesselList;
	}
	
	@RequestMapping("/getStaffList")
	public @ResponseBody List<CommonUtilityBean> getStaffList() throws CustomException {
		List<CommonUtilityBean> getStaffList = new ArrayList<CommonUtilityBean>();
		try {
			getStaffList = commonUtilityService.getStaffList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return getStaffList;
	}
	
	@RequestMapping("/getSectorCompanyCode")
	public @ResponseBody CommonUtilityResultBean getSectorCompany(@RequestParam("sector") String sector) throws CustomException {
		 String company="";
		 CommonUtilityResultBean rbean=new CommonUtilityResultBean();
			try {
				//company=scheduleVoyageService.getSectorCompany(sector);
				rbean.setCode(company);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(company);
			return rbean;
		}
	
	
	@RequestMapping("/getTripsList")
	public @ResponseBody List<CommonUtilityBean> getTripsList() throws CustomException {
		List<CommonUtilityBean> getTripsList = new ArrayList<CommonUtilityBean>();
		try {
			getTripsList = commonUtilityService.getTripsList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return getTripsList;
	}
	@RequestMapping("/getChargeList")
	public @ResponseBody CommonUtilityResultBean getChargeList() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getChargeList());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	@RequestMapping("/getCurrencyList")
	public @ResponseBody CommonUtilityResultBean getCurrencyList() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getCurrencyList());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	
	@RequestMapping("/getStockAvailablity")
	public @ResponseBody CommonUtilityResultBean getStockAvailablity(@RequestParam("locnId") int locationId, @RequestParam("itemId") int itemId) throws CustomException {
		CommonUtilityResultBean lStockList = new CommonUtilityResultBean();
		try {
			lStockList = commonUtilityService.getStockAvailablity(locationId, itemId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return lStockList;
	}
	
	@RequestMapping("/getEntityList")
	public @ResponseBody CommonUtilityResultBean getEntityData() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getEntityData());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	
	@RequestMapping("/getConsignmentBatchList")
	public @ResponseBody List<BatchAttributeBean> getConsignmentBatchList(@RequestBody BatchAttributeBean bean) throws CustomException {
		List<BatchAttributeBean> lDesignationList = new ArrayList<BatchAttributeBean>();
		try {
			lDesignationList = commonUtilityService.getConsignmentBatchList(bean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lDesignationList;
	}
	@RequestMapping("/getMode")
	public @ResponseBody List<SelectivityBean> getMode() throws CustomException {
		List<SelectivityBean> lModeList = new ArrayList<>();
		try {
			lModeList = commonUtilityService.getMode();
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return lModeList;
	}
	
	@RequestMapping("/getJobOrderNo")
	public @ResponseBody List<SelectivityBean> getJobOrderNo() throws CustomException {
		List<SelectivityBean> lJobOrderNoList = new ArrayList<>();
		try {
			lJobOrderNoList = commonUtilityService.getJobOrderNo();
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return lJobOrderNoList;
	}
 
	
	 
	@RequestMapping("/getSubAccountCodeListTradeDebtorsIA")
	public @ResponseBody List<CommonUtilityBean> getSubAccountCodeListTradeDebtorsIA() throws CustomException {
		List<CommonUtilityBean> lSubAccountList = new ArrayList<CommonUtilityBean>();
		try {
			lSubAccountList = commonUtilityService.getSubAccountCodeListTradeDebtorsIA();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lSubAccountList;
	}
	
	@RequestMapping("/voyageList")
	public @ResponseBody List getVoyageList(@RequestParam("vesselCode") String vesselCode) throws CustomException {
		List voyageList = new ArrayList();

		try {
			voyageList = commonUtilityService.getVoyageList(vesselCode);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return voyageList;
	}
	
	@RequestMapping("/getAccountList")
	public @ResponseBody List<CommonUtilityBean> getAccountListDrpDwn() throws CustomException {
		List<CommonUtilityBean> acctLst = new ArrayList<CommonUtilityBean>();
		try {
			acctLst = commonUtilityService.getAccountListDrpDwn();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return acctLst;
	}
	
	
	@RequestMapping("/getSurChargeList")
	public  @ResponseBody List<SelectivityBean> getSurChargeList(@RequestParam("relateType") String relateType) {
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();
		try {
			list = commonUtilityService.getSurChargeList(relateType);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return list;
	}
	
	
	@RequestMapping("/getAttributesList")
	public @ResponseBody List<AttributeBean> getAttributesList(@RequestParam("accountCode") String sAccountCode) throws CustomException {
		List<AttributeBean> lAttributeList = new ArrayList<>();
		try {
			lAttributeList = commonUtilityService.getAttributesList(sAccountCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lAttributeList;
	}
	

	
	@RequestMapping("/getCrDtlAccountHeadDataCN")
	public @ResponseBody CommonUtilityResultBean getCrDtlAccountHeadDataCN() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getAccountHeadDataCN());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	
	
	
	@RequestMapping("/getSubAccountCodeListnew")
	public @ResponseBody CommonUtilityResultBean getSubAccountCodeDataNew() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getSubAccountCodeDatanew());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}


	@RequestMapping("/getCountryListPortmaster")
	public @ResponseBody List<CommonUtilityBean> getCountryListPortmaster() throws CustomException {
		List<CommonUtilityBean> lCountryList = new ArrayList<CommonUtilityBean>();
		try {
			lCountryList = commonUtilityService.getCountryListPortmaster();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lCountryList;
	}
	

	@RequestMapping("/getOriginDestination")
	public @ResponseBody List<SelectivityBean> getOriginDestination() {
	
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();
		
		list=commonUtilityService.getOriginDestination();

		return list;
	}
	@RequestMapping("/getBankList")
	public @ResponseBody List<CommonUtilityBean> getBankList() throws CustomException {
		List<CommonUtilityBean> lCountryList = new ArrayList<CommonUtilityBean>();
		try {
			lCountryList = commonUtilityService.getBankList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lCountryList;
	}
	
	
	@RequestMapping("/cargotype")
	public @ResponseBody List<SelectivityBean> cargotype() {
	
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();
		
		list=commonUtilityService.getcargotype();

		return list;
	}
	
	
	
	@RequestMapping("/getServiceOperator")
	public @ResponseBody List<CommonUtilityBean> getServiceOperator() throws CustomException {
		List<CommonUtilityBean> sectorList = new ArrayList<CommonUtilityBean>();
		try {
			sectorList = commonUtilityService.getServiceOperator();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return sectorList;
	}
	
	
	@RequestMapping("/getService")
	public @ResponseBody List<CommonUtilityBean> getService() throws CustomException {
		List<CommonUtilityBean> sectorList = new ArrayList<CommonUtilityBean>();
		try {
			sectorList = commonUtilityService.getService();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return sectorList;
	}

	@RequestMapping("/getDepotByPort")
	public @ResponseBody List<SelectivityBean> getDepotListByPort(@RequestParam("portCode") String portCode) throws CustomException {
		List<SelectivityBean> depotList = new ArrayList<SelectivityBean>();
		try {
			depotList = commonUtilityService.getDepotListByPort(portCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return depotList;
	}

	
	
	
	@RequestMapping("/getcustomerlocal")
	public @ResponseBody CommonUtilityResultBean getcustomerlocal() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getcustomerlocal());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	
	
	@RequestMapping("/getsupplierlocal")
	public @ResponseBody CommonUtilityResultBean getsupplierlocal() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getsupplierlocal());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	
	
	@RequestMapping("/getsupplieroverseas")
	public @ResponseBody CommonUtilityResultBean getsupplieroverseas() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getsupplieroverseas());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}


	
	
	@RequestMapping("/getcustomeroverseas")
	public @ResponseBody CommonUtilityResultBean getcustomeroverseas() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getcustomeroverseas());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	
	
	@RequestMapping("/getCompanyListPurchase")
	public @ResponseBody List<SelectivityBean> getCompanyListPurchase() throws CustomException {
		List<SelectivityBean> companyList = new ArrayList<>();
		try {
			companyList = commonUtilityService.getCompanyListPurchase();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return companyList;
	}
	
	
	
	@RequestMapping("/getCompanyListcompany")
	public @ResponseBody List<SelectivityBean> getCompanyListcompany() throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		List<SelectivityBean> companyList = new ArrayList<>();
		try {
			companyList = commonUtilityService.getCompanyListcompany();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return companyList;
	}

	
	
	@RequestMapping("/getCompanyListWithUser")
	public @ResponseBody CommonUtilityResultBean getCompanyListWithUser() throws CustomException {
		CommonUtilityResultBean lCompanyWithUserList = new CommonUtilityResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String companyCode = userDetails.getCompanyCode();
		try {
			lCompanyWithUserList = commonUtilityService.getCompanyListWithUser(userId, companyCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return lCompanyWithUserList;
	}


	
	
	@RequestMapping("/getSubAccountCodeListsDebtors")
	public @ResponseBody CommonUtilityResultBean getSubAccountCodeList1() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getSubAccountCodeList1());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}

	
	@RequestMapping("/getSubAccountCodeLists")
	public @ResponseBody CommonUtilityResultBean getSubAccountCodeList() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getSubAccountCodeList());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}

	
	@RequestMapping("/getSubAcctNew")
	public @ResponseBody CommonUtilityResultBean getSubAccountCodeList1(@RequestParam("accountCode") String sAccountCode) throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getSubAccountCodeNew(sAccountCode));
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	
	
	@RequestMapping(value = "/getSubGroupAcctList")
	public @ResponseBody List<SelectivityBean> getSubGroupList() throws CustomException {
		List<SelectivityBean> lSubGroupList = new ArrayList<>();

		try {
			lSubGroupList = commonUtilityService.getSubGroupAcctList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lSubGroupList;
	}
	
	
	//list
	
	@RequestMapping("/getCrDtlAccountHeadDataNew")
	public @ResponseBody CommonUtilityResultBean getCrDtlAccountHeadDataNew() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getCrDtlAccountHeadDataNew());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}

	
	@RequestMapping("/BudgetDefListCC")
	public @ResponseBody CommonUtilityResultBean BudgetDefListCC(@RequestParam("costCenter") String costCenter) throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();
		try {
			commonUtilityResultBean = commonUtilityService.BudgetDefListCC(costCenter);
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	
	@RequestMapping("/getSubAccountCodeListNew")
	public @ResponseBody CommonUtilityResultBean getSubAccountCodeData(@RequestParam("type") String type) throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(commonUtilityService.getSubAccountCodeDataNew(type));
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}

 }



