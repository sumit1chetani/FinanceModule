package com.dci.master.quotation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dci.common.model.CommonUtilityBean;
import com.dci.common.util.BasicResultBean;



public class QuotationRateResultBean extends BasicResultBean implements Serializable {
	private List<QuotationRateBean> lQuotationBean;
	private List<QuotationRateBean> fQuotationBean;
	private List<QuotationRateBean> notDraftList;
	private List<QuotationRateBean> ChargeList;
	private List<QuotationRateBean> quotationFreeDaysDtl;
	
	
	
	public List<QuotationRateBean> getQuotationFreeDaysDtl() {
		return quotationFreeDaysDtl;
	}

	public void setQuotationFreeDaysDtl(List<QuotationRateBean> quotationFreeDaysDtl) {
		this.quotationFreeDaysDtl = quotationFreeDaysDtl;
	}

	public List<QuotationRateBean> getNotDraftList() {
		return notDraftList;
	}

	public void setNotDraftList(List<QuotationRateBean> notDraftList) {
		this.notDraftList = notDraftList;
	}

	private String userId;	
	private String emailid;
	private boolean vendor;
	private String docPath;	
	private String bookingStatus;	
	private String maxGateOutNo;	
	private List<QuotationRateBean> getstufflist;
	private List<QuotationRateBean> custCatList;
	
	
	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<QuotationRateBean> getCustCatList() {
		return custCatList;
	}

	public void setCustCatList(List<QuotationRateBean> custCatList) {
		this.custCatList = custCatList;
	}

	public List<QuotationRateBean> getGetstufflist() {
		return getstufflist;
	}

	public void setGetstufflist(List<QuotationRateBean> getstufflist) {
		this.getstufflist = getstufflist;
	}

	public List<QuotationRateBean> getGetsurchargelist() {
		return getsurchargelist;
	}

	public void setGetsurchargelist(List<QuotationRateBean> getsurchargelist) {
		this.getsurchargelist = getsurchargelist;
	}

	public List<QuotationRateBean> getGetagencylist() {
		return getagencylist;
	}

	public void setGetagencylist(List<QuotationRateBean> getagencylist) {
		this.getagencylist = getagencylist;
	}


	private List<QuotationRateBean> getsurchargelist;
	private List<QuotationRateBean> getagencylist;
	
	public String getMaxGateOutNo() {
		return maxGateOutNo;
	}

	public void setMaxGateOutNo(String maxGateOutNo) {
		this.maxGateOutNo = maxGateOutNo;
	}

	
	// gate in max count
	
	private String maxGateInNo;	
	
	public String getMaxGateInNo() {
		return maxGateInNo;
	}

	public void setMaxGateInNo(String maxGateInNo) {
		this.maxGateInNo = maxGateInNo;
	}


	private List<CommonUtilityBean> customerList;
	

	
	private List<CommonUtilityBean> consigneeList;
	private List<CommonUtilityBean> shipperList;
	private List<CommonUtilityBean> nominatedList;
	private List<CommonUtilityBean> vendorList;
	private List<CommonUtilityBean> serviceParnrList;
	private List<QuotationRateBean> vesselList;
	private List<QuotationRateBean> contractType;

	public List<QuotationRateBean> getContractType() {
		return contractType;
	}

	public void setContractType(List<QuotationRateBean> contractType) {
		this.contractType = contractType;
	}

	private List<QuotationRateBean> voyageList;
	private List<QuotationRateBean> agentList;
	private List<QuotationRateBean> polList;
    private String quotNo;
    
    


	

	
	

	public List<QuotationRateBean> getPolList() {
		return polList;
	}

	public void setPolList(List<QuotationRateBean> polList) {
		this.polList = polList;
	}

	public String getQuotNo() {
		return quotNo;
	}

	public void setQuotNo(String quotNo) {
		this.quotNo = quotNo;
	}

	public List<QuotationRateBean> getVesselList() {
		return vesselList;
	}

	public void setVesselList(List<QuotationRateBean> vesselList) {
		this.vesselList = vesselList;
	}

	public List<QuotationRateBean> getVoyageList() {
		return voyageList;
	}

	public void setVoyageList(List<QuotationRateBean> voyageList) {
		this.voyageList = voyageList;
	}

	public List<QuotationRateBean> getAgentList() {
		return agentList;
	}

	public void setAgentList(List<QuotationRateBean> agentList) {
		this.agentList = agentList;
	}


	private List<QuotationRateBean> filel;
	private String filePath;
	private String file;
	private List<QuotationRateBean> getshipmentlist;
	public List<QuotationRateBean> getContainerSizeList() {
		return containerSizeList;
	}

	public void setContainerSizeList(List<QuotationRateBean> containerSizeList) {
		this.containerSizeList = containerSizeList;
	}


	private List<QuotationRateBean> containerSizeList;
	private List<QuotationRateBean> getcontainer;
	private List<QuotationRateBean> gateOutList;
	private List<QuotationRateBean> custShortName;
	private List<QuotationRateBean> custAcctHead;
	private List<QuotationRateBean> vendorAcctHead;

	private List<QuotationRateBean> compList;
	
	
	public List<QuotationRateBean> getCustAcctHead() {
		return custAcctHead;
	}

	public List<QuotationRateBean> getCompList() {
		return compList;
	}

	public void setCompList(List<QuotationRateBean> compList) {
		this.compList = compList;
	}

	public void setCustAcctHead(List<QuotationRateBean> custAcctHead) {
		this.custAcctHead = custAcctHead;
	}

	public List<QuotationRateBean> getVendorAcctHead() {
		return vendorAcctHead;
	}

	public void setVendorAcctHead(List<QuotationRateBean> vendorAcctHead) {
		this.vendorAcctHead = vendorAcctHead;
	}

	public List<QuotationRateBean> getCustShortName() {
		return custShortName;
	}

	public void setCustShortName(List<QuotationRateBean> custShortName) {
		this.custShortName = custShortName;
	}

	public List<QuotationRateBean> getGateOutList() {
		return gateOutList;
	}

	public void setGateOutList(List<QuotationRateBean> gateOutList) {
		this.gateOutList = gateOutList;
	}

	public List<QuotationRateBean> getGetcustomerlist() {
		return getcustomerlist;
	}

	public List<QuotationRateBean> getGetcontainer() {
		return getcontainer;
	}

	public void setGetcontainer(List<QuotationRateBean> getcontainer) {
		this.getcontainer = getcontainer;
	}

	public void setGetcustomerlist(List<QuotationRateBean> getcustomerlist) {
		this.getcustomerlist = getcustomerlist;
	}

	public List<QuotationRateBean> getGetcurrencylist() {
		return getcurrencylist;
	}

	public void setGetcurrencylist(List<QuotationRateBean> getcurrencylist) {
		this.getcurrencylist = getcurrencylist;
	}

	public List<QuotationRateBean> getGetportlist() {
		return getportlist;
	}

	public void setGetportlist(List<QuotationRateBean> getportlist) {
		this.getportlist = getportlist;
	}


	private List<QuotationRateBean> getcustomerlist;
	private List<QuotationRateBean> getcurrencylist;
	private List<QuotationRateBean> getportlist;
	private List<QuotationRateBean> getchargetypelist;
	public List<QuotationRateBean> getGetchargetypelist() {
		return getchargetypelist;
	}

	public void setGetchargetypelist(List<QuotationRateBean> getchargetypelist) {
		this.getchargetypelist = getchargetypelist;
	}

	public List<QuotationRateBean> getGetcontypelist() {
		return getcontypelist;
	}

	public void setGetcontypelist(List<QuotationRateBean> getcontypelist) {
		this.getcontypelist = getcontypelist;
	}


	private List<QuotationRateBean> getcontypelist;
	
	
	
	
	public List<QuotationRateBean> getGetshipmentlist() {
		return getshipmentlist;
	}

	public void setGetshipmentlist(List<QuotationRateBean> getshipmentlist) {
		this.getshipmentlist = getshipmentlist;
	}


	private QuotationRateBean seaQuotationBean; 
	
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

	
	private List<QuotationRateBean> fileList = new ArrayList<QuotationRateBean>();
	
	public List<QuotationRateBean> getFileList() {
		return fileList;
	}

	public void setFileList(List<QuotationRateBean> fileList) {
		this.fileList = fileList;
	}

	public String getDocPath() {
		return docPath;
	}

	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}

	public List<QuotationRateBean> getlQuotationBean() {
		return lQuotationBean;
	}

	public void setlQuotationBean(List<QuotationRateBean> lQuotationBean) {
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


	public List<QuotationRateBean> getFilel() {
		return filel;
	}

	public void setFilel(List<QuotationRateBean> filel) {
		this.filel = filel;
	}

	public QuotationRateBean getSeaQuotationBean() {
		return seaQuotationBean;
	}

	public void setSeaQuotationBean(QuotationRateBean seaQuotationBean) {
		this.seaQuotationBean = seaQuotationBean;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public List<QuotationRateBean> getfQuotationBean() {
		return fQuotationBean;
	}

	public void setfQuotationBean(List<QuotationRateBean> fQuotationBean) {
		this.fQuotationBean = fQuotationBean;
	}

	public List<QuotationRateBean> getChargeList() {
		return ChargeList;
	}

	public void setChargeList(List<QuotationRateBean> chargeList) {
		ChargeList = chargeList;
	}

	public boolean isVendor() {
		return vendor;
	}

	public void setVendor(boolean vendor) {
		this.vendor = vendor;
	}


	
	
	
	
}
