package com.dci.tenant.documentation.billofLading;

import java.util.List;

public class BillofLadingBean {

	public String blNo;
	public String bookingNo;
	public String issuePlace;
	public String issueDate;
	public String onBoard;
	public String receiptAt;
	public String pol;
	public String pod;
	public String pot;
	public String fpod;
	public String terms;
	public Integer noBls;
	public String ref;
	public String vslVoyage;
	public String mVoyage;
	public String loadType;
	public String service;
	public boolean released;
	public String client;
	public String jobNo;
	public String agent;
	public String remarks;
	public String shipment;
	public String status;
	public String releasedstr;
	public Boolean isSuccess;
	public String message;
	public String value;
	public String viewValue;
	public String messers;
	public String shipper;
	public String cnee;
	public String notify1;
	public String notify2;
	public String forwarder;
	public String maincom;
	public Integer t_wgt;
	public double g_wgt;
	public double n_wgt;
	public double cbm;
	public Integer pkgs;
	public String goods;
	public String marks;
	public List<BillOfLadingPackage> blpckDtlList;
	public List<BillOfLadingContainersData> blcntrDtlList;
	public List<Integer> removeCntr;
	public List<Integer> removeCntrCharge;
	public List<Integer> removeCntrPckg;
	public List<Integer> removeCharge;
	public List<BillOfLadingChargeBean> blCharges;
	
	
	public List<BillOfLadingChargeBean> getBlCharges() {
		return blCharges;
	}

	public void setBlCharges(List<BillOfLadingChargeBean> blCharges) {
		this.blCharges = blCharges;
	}

	public List<Integer> getRemoveCharge() {
		return removeCharge;
	}

	public void setRemoveCharge(List<Integer> removeCharge) {
		this.removeCharge = removeCharge;
	}

	public List<Integer> getRemoveCntr() {
		return removeCntr;
	}

	public void setRemoveCntr(List<Integer> removeCntr) {
		this.removeCntr = removeCntr;
	}

	public List<Integer> getRemoveCntrCharge() {
		return removeCntrCharge;
	}

	public void setRemoveCntrCharge(List<Integer> removeCntrCharge) {
		this.removeCntrCharge = removeCntrCharge;
	}

	public List<Integer> getRemoveCntrPckg() {
		return removeCntrPckg;
	}

	public void setRemoveCntrPckg(List<Integer> removeCntrPckg) {
		this.removeCntrPckg = removeCntrPckg;
	}

	public List<BillOfLadingPackage> getBlpckDtlList() {
		return blpckDtlList;
	}

	public void setBlpckDtlList(List<BillOfLadingPackage> blpckDtlList) {
		this.blpckDtlList = blpckDtlList;
	}

	public List<BillOfLadingContainersData> getBlcntrDtlList() {
		return blcntrDtlList;
	}

	public void setBlcntrDtlList(List<BillOfLadingContainersData> blcntrDtlList) {
		this.blcntrDtlList = blcntrDtlList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getViewValue() {
		return viewValue;
	}

	public void setViewValue(String viewValue) {
		this.viewValue = viewValue;
	}

	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}

	public String getIssuePlace() {
		return issuePlace;
	}
 

	public void setIssuePlace(String issuePlace) {
		this.issuePlace = issuePlace;
	}
 
	 

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getOnBoard() {
		return onBoard;
	}

	public void setOnBoard(String onBoard) {
		this.onBoard = onBoard;
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

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
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

	public String getMessers() {
		return messers;
	}

	public void setMessers(String messers) {
		this.messers = messers;
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

	public String getForwarder() {
		return forwarder;
	}

	public void setForwarder(String forwarder) {
		this.forwarder = forwarder;
	}

	public String getMaincom() {
		return maincom;
	}

	public void setMaincom(String maincom) {
		this.maincom = maincom;
	}

	public Integer getT_wgt() {
		return t_wgt;
	}

	public void setT_wgt(Integer t_wgt) {
		this.t_wgt = t_wgt;
	}

	public double getG_wgt() {
		return g_wgt;
	}

	public void setG_wgt(double g_wgt) {
		this.g_wgt = g_wgt;
	}

	public double getN_wgt() {
		return n_wgt;
	}

	public void setN_wgt(double n_wgt) {
		this.n_wgt = n_wgt;
	}

	public double getCbm() {
		return cbm;
	}

	public void setCbm(double cbm) {
		this.cbm = cbm;
	}

	public Integer getPkgs() {
		return pkgs;
	}

	public void setPkgs(Integer pkgs) {
		this.pkgs = pkgs;
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

	public void setVslVoyage(String vslVoyage) {
		this.vslVoyage = vslVoyage;
	}

	public String getmVoyage() {
		return mVoyage;
	}

	public void setmVoyage(String mVoyage) {
		this.mVoyage = mVoyage;
	}

	public String getLoadType() {
		return loadType;
	}

	public void setLoadType(String loadType) {
		this.loadType = loadType;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public boolean isReleased() {
		return released;
	}

	public void setReleased(boolean released) {
		this.released = released;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getJobNo() {
		return jobNo;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getShipment() {
		return shipment;
	}

	public void setShipment(String shipment) {
		this.shipment = shipment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReleasedstr() {
		return releasedstr;
	}

	public void setReleasedstr(String releasedstr) {
		this.releasedstr = releasedstr;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

}
