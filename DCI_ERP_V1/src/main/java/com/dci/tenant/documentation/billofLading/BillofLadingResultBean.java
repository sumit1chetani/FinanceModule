package com.dci.tenant.documentation.billofLading;

import java.util.List;

public class BillofLadingResultBean {

	public String blNo;
	public String receiptAt;
	public String pol;
	public String pod;
	public String pot;
	public String fpod;
	public Integer noBls;
	public String ref;
	public String vslVoyage;
	public String vessel;
	public String agent;
	public String shipper;
	public String cnee;
	public String notify1;
	public String notify2;
	public String goods;
	public String marks;
	public double g_wgt;
	public Integer pkgs;
	public double cbm;
	public String issuePlace;
	public String issueDate;
	public String onBoard;
	public String messers;
	public String terms;
	public Boolean isSuccess;
	public String message;
	public Integer pageCount;
	public Integer blId;
	public String customerId;
	public String customerName;
	public String freight_charges;
	public Double rate;
	public Double unit;
	public String currency;
	public String prepaid;
	public String collect;
	public Integer count;
	public Integer chargesId;

	private BillofLadingResultBean blBean;
	List<BillofLadingResultBean> blPrintDetails;
	

	public Integer getBlId() {
		return blId;
	}
	public void setBlId(Integer blId) {
		this.blId = blId;
	}
	public String getCollect() {
		return collect;
	}
	public void setCollect(String collect) {
		this.collect = collect;
	}
	public Integer getChargesId() {
		return chargesId;
	}
	public void setChargesId(Integer chargesId) {
		this.chargesId = chargesId;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessers() {
		return messers;
	}
	public void setMessers(String messers) {
		this.messers = messers;
	}
	public String getTerms() {
		return terms;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	public String getFreight_charges() {
		return freight_charges;
	}
	public void setFreight_charges(String freight_charges) {
		this.freight_charges = freight_charges;
	}
	  
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Double getUnit() {
		return unit;
	}
	public void setUnit(Double unit) {
		this.unit = unit;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPrepaid() {
		return prepaid;
	}
	public void setPrepaid(String prepaid) {
		this.prepaid = prepaid;
	}
	public List<BillofLadingResultBean> getBlPrintDetails() {
		return blPrintDetails;
	}
	public void setBlPrintDetails(List<BillofLadingResultBean> blPrintDetails) {
		this.blPrintDetails = blPrintDetails;
	}
	public String getIssuePlace() {
		return issuePlace;
	}
	public void setIssuePlace(String issuePlace) {
		this.issuePlace = issuePlace;
	}
	public String getOnBoard() {
		return onBoard;
	}
	public void setOnBoard(String onBoard) {
		this.onBoard = onBoard;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public BillofLadingResultBean getBlBean() {
		return blBean;
	}
	public void setBlBean(BillofLadingResultBean blBean) {
		this.blBean = blBean;
	}
	public String getBlNo() {
		return blNo;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	public String getReceiptAt() {
		return receiptAt;
	}
	public void setReceiptAt(String receiptAt) {
		this.receiptAt = receiptAt;
	}
	public String getPol() {
		return pol;
	}
	public void setPol(String pol) {
		this.pol = pol;
	}
	public String getPod() {
		return pod;
	}
	public void setPod(String pod) {
		this.pod = pod;
	}
	public String getPot() {
		return pot;
	}
	public void setPot(String pot) {
		this.pot = pot;
	}
	public String getFpod() {
		return fpod;
	}
	public void setFpod(String fpod) {
		this.fpod = fpod;
	}
	public Integer getNoBls() {
		return noBls;
	}
	public void setNoBls(Integer noBls) {
		this.noBls = noBls;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getVslVoyage() {
		return vslVoyage;
	}
	public void setVslVoyage(String vslVoyage) {
		this.vslVoyage = vslVoyage;
	}
	public String getVessel() {
		return vessel;
	}
	public void setVessel(String vessel) {
		this.vessel = vessel;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getShipper() {
		return shipper;
	}
	public void setShipper(String shipper) {
		this.shipper = shipper;
	}
	public String getCnee() {
		return cnee;
	}
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}
	public String getNotify1() {
		return notify1;
	}
	public void setNotify1(String notify1) {
		this.notify1 = notify1;
	}
	public String getNotify2() {
		return notify2;
	}
	public void setNotify2(String notify2) {
		this.notify2 = notify2;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public double getG_wgt() {
		return g_wgt;
	}
	public void setG_wgt(double g_wgt) {
		this.g_wgt = g_wgt;
	}
	public Integer getPkgs() {
		return pkgs;
	}
	public void setPkgs(Integer pkgs) {
		this.pkgs = pkgs;
	}
	public double getCbm() {
		return cbm;
	}
	public void setCbm(double cbm) {
		this.cbm = cbm;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	

}
