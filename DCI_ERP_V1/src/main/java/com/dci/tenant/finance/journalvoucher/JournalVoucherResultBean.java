package com.dci.tenant.finance.journalvoucher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;


public class JournalVoucherResultBean extends BasicResultBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<JournalVoucherBean> lJournalVoucherBean;
	private List<JournalVoucherDTO> lJournalVoucherBeanDTO;

	Map<String, List<JournalVoucherBean>> accountNameObj = new HashMap<>();
	Map<String, List<SelectivityBean>> selectaccountNameObj = new HashMap<>();

	private List<JournalVoucherBean> subInfo;
	private List<JournalVoucherBean> companyList;
	private List<JournalVoucherBean> accountInfo;
	private List<JournalVoucherBean> vesselInfo;
	private List<JournalVoucherBean> voyageInfo;
	private List<JournalVoucherBean> serviceInfo;
	private List<JournalVoucherBean> employeeDepartmentInfo;
	private List<JournalVoucherBean> exchangeRateInfo;

	private List<JournalVoucherBean> voyageBiList;
	private List<JournalVoucherBean> voyageMainList;
	private List<JournalVoucherBean> vesselBiList;
	private List<JournalVoucherBean> serviceBiList;
	private String sErrorMessage;

	public String getsErrorMessage() {
		return sErrorMessage;
	}

	public void setsErrorMessage(String sErrorMessage) {
		this.sErrorMessage = sErrorMessage;
	}

	public List<JournalVoucherBean> getlJournalVoucherBean() {
		return lJournalVoucherBean;
	}

	public void setlJournalVoucherBean(List<JournalVoucherBean> lJournalVoucherBean) {
		this.lJournalVoucherBean = lJournalVoucherBean;
	}

	public List<JournalVoucherDTO> getlJournalVoucherBeanDTO() {
		return lJournalVoucherBeanDTO;
	}

	public void setlJournalVoucherBeanDTO(List<JournalVoucherDTO> lJournalVoucherBeanDTO) {
		this.lJournalVoucherBeanDTO = lJournalVoucherBeanDTO;
	}

	public Map<String, List<JournalVoucherBean>> getAccountNameObj() {
		return accountNameObj;
	}

	public void setAccountNameObj(Map<String, List<JournalVoucherBean>> accountNameObj) {
		this.accountNameObj = accountNameObj;
	}

	public Map<String, List<SelectivityBean>> getSelectaccountNameObj() {
		return selectaccountNameObj;
	}

	public void setSelectaccountNameObj(Map<String, List<SelectivityBean>> selectaccountNameObj) {
		this.selectaccountNameObj = selectaccountNameObj;
	}

	public List<JournalVoucherBean> getSubInfo() {
		return subInfo;
	}

	public void setSubInfo(List<JournalVoucherBean> subInfo) {
		this.subInfo = subInfo;
	}

	public List<JournalVoucherBean> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<JournalVoucherBean> companyList) {
		this.companyList = companyList;
	}

	public List<JournalVoucherBean> getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(List<JournalVoucherBean> accountInfo) {
		this.accountInfo = accountInfo;
	}

	public List<JournalVoucherBean> getVesselInfo() {
		return vesselInfo;
	}

	public void setVesselInfo(List<JournalVoucherBean> vesselInfo) {
		this.vesselInfo = vesselInfo;
	}

	public List<JournalVoucherBean> getVoyageInfo() {
		return voyageInfo;
	}

	public void setVoyageInfo(List<JournalVoucherBean> voyageInfo) {
		this.voyageInfo = voyageInfo;
	}

	public List<JournalVoucherBean> getServiceInfo() {
		return serviceInfo;
	}

	public void setServiceInfo(List<JournalVoucherBean> serviceInfo) {
		this.serviceInfo = serviceInfo;
	}

	public List<JournalVoucherBean> getEmployeeDepartmentInfo() {
		return employeeDepartmentInfo;
	}

	public void setEmployeeDepartmentInfo(List<JournalVoucherBean> employeeDepartmentInfo) {
		this.employeeDepartmentInfo = employeeDepartmentInfo;
	}

	public List<JournalVoucherBean> getExchangeRateInfo() {
		return exchangeRateInfo;
	}

	public void setExchangeRateInfo(List<JournalVoucherBean> exchangeRateInfo) {
		this.exchangeRateInfo = exchangeRateInfo;
	}

	public List<JournalVoucherBean> getVoyageBiList() {
		return voyageBiList;
	}

	public void setVoyageBiList(List<JournalVoucherBean> voyageBiList) {
		this.voyageBiList = voyageBiList;
	}

	public List<JournalVoucherBean> getVoyageMainList() {
		return voyageMainList;
	}

	public void setVoyageMainList(List<JournalVoucherBean> voyageMainList) {
		this.voyageMainList = voyageMainList;
	}

	public List<JournalVoucherBean> getVesselBiList() {
		return vesselBiList;
	}

	public void setVesselBiList(List<JournalVoucherBean> vesselBiList) {
		this.vesselBiList = vesselBiList;
	}

	public List<JournalVoucherBean> getServiceBiList() {
		return serviceBiList;
	}

	public void setServiceBiList(List<JournalVoucherBean> serviceBiList) {
		this.serviceBiList = serviceBiList;
	}

}
