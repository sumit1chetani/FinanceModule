package com.dci.operation.containerReleaseOrder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dci.common.model.CommonUtilityBean;
import com.dci.common.util.BasicResultBean;



public class containerReleaseOrderResultBean extends BasicResultBean implements Serializable {
	private List<containerReleaseOrderBean> lQuotationBean;
	private List<containerReleaseOrderBean> sealdtl;
	public List<containerReleaseOrderBean> getSealdtl() {
		return sealdtl;
	}

	public void setSealdtl(List<containerReleaseOrderBean> sealdtl) {
		this.sealdtl = sealdtl;
	}


	private String docPath;	

	
	private List<CommonUtilityBean> customerList;
	private List<CommonUtilityBean> consigneeList;
	private List<CommonUtilityBean> shipperList;
	private List<CommonUtilityBean> nominatedList;
	private List<CommonUtilityBean> vendorList;
	private List<CommonUtilityBean> serviceParnrList;
	private List<containerReleaseOrderBean> filel;
	private String filePath;
	private String file;
	private List<containerReleaseOrderBean> getshipmentlist;
	private List<containerReleaseOrderBean> excelList;
	private List<containerReleaseOrderBean> quotationinnerDtl;
	private List<String> errorList;
	
	private List<containerReleaseOrderBean> containerReleaseOrderBean;
	
	
	public List<containerReleaseOrderBean> getContainerReleaseOrderBean() {
		return containerReleaseOrderBean;
	}

	public void setContainerReleaseOrderBean(List<containerReleaseOrderBean> containerReleaseOrderBean) {
		this.containerReleaseOrderBean = containerReleaseOrderBean;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

	public List<containerReleaseOrderBean> getQuotationinnerDtl() {
		return quotationinnerDtl;
	}

	public void setQuotationinnerDtl(List<containerReleaseOrderBean> quotationinnerDtl) {
		this.quotationinnerDtl = quotationinnerDtl;
	}

	public List<containerReleaseOrderBean> getExcelList() {
		return excelList;
	}

	public void setExcelList(List<containerReleaseOrderBean> excelList) {
		this.excelList = excelList;
	}

	public List<containerReleaseOrderBean> getGetcustomerlist() {
		return getcustomerlist;
	}

	public void setGetcustomerlist(List<containerReleaseOrderBean> getcustomerlist) {
		this.getcustomerlist = getcustomerlist;
	}

	public List<containerReleaseOrderBean> getGetcurrencylist() {
		return getcurrencylist;
	}

	public void setGetcurrencylist(List<containerReleaseOrderBean> getcurrencylist) {
		this.getcurrencylist = getcurrencylist;
	}

	public List<containerReleaseOrderBean> getGetportlist() {
		return getportlist;
	}

	public void setGetportlist(List<containerReleaseOrderBean> getportlist) {
		this.getportlist = getportlist;
	}


	private List<containerReleaseOrderBean> getcustomerlist;
	private List<containerReleaseOrderBean> getcurrencylist;
	private List<containerReleaseOrderBean> getportlist;
	private List<containerReleaseOrderBean> getchargetypelist;
	private List<containerReleaseOrderBean> populateBookingNO;
	public List<containerReleaseOrderBean> getPopulateBookingNO() {
		return populateBookingNO;
	}

	public void setPopulateBookingNO(List<containerReleaseOrderBean> populateBookingNO) {
		this.populateBookingNO = populateBookingNO;
	}

	public List<containerReleaseOrderBean> getGetchargetypelist() {
		return getchargetypelist;
	}

	public void setGetchargetypelist(List<containerReleaseOrderBean> getchargetypelist) {
		this.getchargetypelist = getchargetypelist;
	}

	public List<containerReleaseOrderBean> getGetcontypelist() {
		return getcontypelist;
	}

	public void setGetcontypelist(List<containerReleaseOrderBean> getcontypelist) {
		this.getcontypelist = getcontypelist;
	}


	private List<containerReleaseOrderBean> getcontypelist;
	
	
	
	
	public List<containerReleaseOrderBean> getGetshipmentlist() {
		return getshipmentlist;
	}

	public void setGetshipmentlist(List<containerReleaseOrderBean> getshipmentlist) {
		this.getshipmentlist = getshipmentlist;
	}


	private containerReleaseOrderBean seaQuotationBean; 
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	
	private List<containerReleaseOrderBean> fileList = new ArrayList<containerReleaseOrderBean>();
	
	public List<containerReleaseOrderBean> getFileList() {
		return fileList;
	}

	public void setFileList(List<containerReleaseOrderBean> fileList) {
		this.fileList = fileList;
	}

	public String getDocPath() {
		return docPath;
	}

	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}

	public List<containerReleaseOrderBean> getlQuotationBean() {
		return lQuotationBean;
	}

	public void setlQuotationBean(List<containerReleaseOrderBean> lQuotationBean) {
		this.lQuotationBean = lQuotationBean;
	}

	/**
	 * @return the lBean
	 */


	public List<CommonUtilityBean> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CommonUtilityBean> customerList) {
		this.customerList = customerList;
	}

	public List<CommonUtilityBean> getConsigneeList() {
		return consigneeList;
	}

	public void setConsigneeList(List<CommonUtilityBean> consigneeList) {
		this.consigneeList = consigneeList;
	}

	public List<CommonUtilityBean> getShipperList() {
		return shipperList;
	}

	public void setShipperList(List<CommonUtilityBean> shipperList) {
		this.shipperList = shipperList;
	}

	public List<CommonUtilityBean> getNominatedList() {
		return nominatedList;
	}

	public void setNominatedList(List<CommonUtilityBean> nominatedList) {
		this.nominatedList = nominatedList;
	}

	public List<CommonUtilityBean> getVendorList() {
		return vendorList;
	}

	public void setVendorList(List<CommonUtilityBean> vendorList) {
		this.vendorList = vendorList;
	}

	public List<CommonUtilityBean> getServiceParnrList() {
		return serviceParnrList;
	}

	public void setServiceParnrList(List<CommonUtilityBean> serviceParnrList) {
		this.serviceParnrList = serviceParnrList;
	}


	public List<containerReleaseOrderBean> getFilel() {
		return filel;
	}

	public void setFilel(List<containerReleaseOrderBean> filel) {
		this.filel = filel;
	}

	public containerReleaseOrderBean getSeaQuotationBean() {
		return seaQuotationBean;
	}

	public void setSeaQuotationBean(containerReleaseOrderBean seaQuotationBean) {
		this.seaQuotationBean = seaQuotationBean;
	}
	
	
	
}
