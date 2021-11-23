package com.dci.master.employeeAdminMaster;

import java.util.List;

public class EmployeeAdminMasterAddressBean {

	private String presentAddress;
	private String presentPlace;
	private String presentDistrict;
	private String presentPin;
	private String presentPhone;
	private String presentMobile;
	private String isActiveOldAddress = "N";
	private String empId;
	private String permAddress;
	private String permPlace;
	private String permDistrict;
	private String permPin;
	private String permPhone;
	private String permMobile;
	private String permState;
	private String isActiveAddress = "N";

	

	private String paybankname;
	private String paybankacctName;
	private String iban;
	private String payAcctNum;
	private String paybankBranch;
	private String paycomments;
	
	
	private String passrequestType;
	private String passrequestDate;
	private String passrequestcomments;
	
	

	
	private String ticksec;
	private String airclass;
	private String airclaimcomments;
	private String airdueDate;
	private Double airselftickAmt;
	private Double airadulttickAmt;
	private Double airinfanttickAmt;
	private Double airChildtickAmt;

	private Integer airselftick;
	private Integer airadulttick;
	private Integer airinfanttick;
	private Integer airChildtick;

	
	

	private String settleType;
	private String settlelastDate;
	private String settleCurrency;
	private String settlecomments;

	
	
	
	private String assetName;
	private String assetType;
	private String assetdesc;
	private String assetstatus;
	private String assetlocation;
	private String assetquantity;

	
	
	
	
	
	
	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getAssetdesc() {
		return assetdesc;
	}

	public void setAssetdesc(String assetdesc) {
		this.assetdesc = assetdesc;
	}

	public String getAssetstatus() {
		return assetstatus;
	}

	public void setAssetstatus(String assetstatus) {
		this.assetstatus = assetstatus;
	}

	public String getAssetlocation() {
		return assetlocation;
	}

	public void setAssetlocation(String assetlocation) {
		this.assetlocation = assetlocation;
	}

	public String getAssetquantity() {
		return assetquantity;
	}

	public void setAssetquantity(String assetquantity) {
		this.assetquantity = assetquantity;
	}

	public String getSettleType() {
		return settleType;
	}

	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}

	public String getSettlelastDate() {
		return settlelastDate;
	}

	public void setSettlelastDate(String settlelastDate) {
		this.settlelastDate = settlelastDate;
	}

	public String getSettleCurrency() {
		return settleCurrency;
	}

	public void setSettleCurrency(String settleCurrency) {
		this.settleCurrency = settleCurrency;
	}

	public String getSettlecomments() {
		return settlecomments;
	}

	public void setSettlecomments(String settlecomments) {
		this.settlecomments = settlecomments;
	}

	public String getTicksec() {
		return ticksec;
	}

	public void setTicksec(String ticksec) {
		this.ticksec = ticksec;
	}

	public String getAirclass() {
		return airclass;
	}

	public void setAirclass(String airclass) {
		this.airclass = airclass;
	}

	public String getAirclaimcomments() {
		return airclaimcomments;
	}

	public void setAirclaimcomments(String airclaimcomments) {
		this.airclaimcomments = airclaimcomments;
	}

	public String getAirdueDate() {
		return airdueDate;
	}

	public void setAirdueDate(String airdueDate) {
		this.airdueDate = airdueDate;
	}

	public Double getAirselftickAmt() {
		return airselftickAmt;
	}

	public void setAirselftickAmt(Double airselftickAmt) {
		this.airselftickAmt = airselftickAmt;
	}

	public Double getAiradulttickAmt() {
		return airadulttickAmt;
	}

	public void setAiradulttickAmt(Double airadulttickAmt) {
		this.airadulttickAmt = airadulttickAmt;
	}

	public Double getAirinfanttickAmt() {
		return airinfanttickAmt;
	}

	public void setAirinfanttickAmt(Double airinfanttickAmt) {
		this.airinfanttickAmt = airinfanttickAmt;
	}

	public Double getAirChildtickAmt() {
		return airChildtickAmt;
	}

	public void setAirChildtickAmt(Double airChildtickAmt) {
		this.airChildtickAmt = airChildtickAmt;
	}

	public Integer getAirselftick() {
		return airselftick;
	}

	public void setAirselftick(Integer airselftick) {
		this.airselftick = airselftick;
	}

	public Integer getAiradulttick() {
		return airadulttick;
	}

	public void setAiradulttick(Integer airadulttick) {
		this.airadulttick = airadulttick;
	}

	public Integer getAirinfanttick() {
		return airinfanttick;
	}

	public void setAirinfanttick(Integer airinfanttick) {
		this.airinfanttick = airinfanttick;
	}

	public Integer getAirChildtick() {
		return airChildtick;
	}

	public void setAirChildtick(Integer airChildtick) {
		this.airChildtick = airChildtick;
	}

	public String getPassrequestType() {
		return passrequestType;
	}

	public void setPassrequestType(String passrequestType) {
		this.passrequestType = passrequestType;
	}

	public String getPassrequestDate() {
		return passrequestDate;
	}

	public void setPassrequestDate(String passrequestDate) {
		this.passrequestDate = passrequestDate;
	}

	public String getPassrequestcomments() {
		return passrequestcomments;
	}

	public void setPassrequestcomments(String passrequestcomments) {
		this.passrequestcomments = passrequestcomments;
	}

	public String getPaybankname() {
		return paybankname;
	}

	public void setPaybankname(String paybankname) {
		this.paybankname = paybankname;
	}

	public String getPaybankacctName() {
		return paybankacctName;
	}

	public void setPaybankacctName(String paybankacctName) {
		this.paybankacctName = paybankacctName;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getPayAcctNum() {
		return payAcctNum;
	}

	public void setPayAcctNum(String payAcctNum) {
		this.payAcctNum = payAcctNum;
	}

	public String getPaybankBranch() {
		return paybankBranch;
	}

	public void setPaybankBranch(String paybankBranch) {
		this.paybankBranch = paybankBranch;
	}

	public String getPaycomments() {
		return paycomments;
	}

	public void setPaycomments(String paycomments) {
		this.paycomments = paycomments;
	}

	private List<EmployeeAdminMasterPhoneNoDetailBean> presentAddressMultiple;

	public String getPermState() {
		return permState;
	}

	public void setPermState(String permState) {
		this.permState = permState;
	}

	public String getPermAddress() {
		return permAddress;
	}

	public void setPermAddress(String permAddress) {
		this.permAddress = permAddress;
	}

	public String getPermPlace() {
		return permPlace;
	}

	public void setPermPlace(String permPlace) {
		this.permPlace = permPlace;
	}

	public String getPermDistrict() {
		return permDistrict;
	}

	public void setPermDistrict(String permDistrict) {
		this.permDistrict = permDistrict;
	}

	public String getPermPin() {
		return permPin;
	}

	public void setPermPin(String permPin) {
		this.permPin = permPin;
	}

	public String getPermPhone() {
		return permPhone;
	}

	public void setPermPhone(String permPhone) {
		this.permPhone = permPhone;
	}

	public String getPermMobile() {
		return permMobile;
	}

	public void setPermMobile(String permMobile) {
		this.permMobile = permMobile;
	}

	public String getIsActiveAddress() {
		return isActiveAddress;
	}

	public void setIsActiveAddress(String isActiveAddress) {
		this.isActiveAddress = isActiveAddress;
	}

	public List<EmployeeAdminMasterPhoneNoDetailBean> getPresentAddressMultiple() {
		return presentAddressMultiple;
	}

	public void setPresentAddressMultiple(List<EmployeeAdminMasterPhoneNoDetailBean> presentAddressMultiple) {
		this.presentAddressMultiple = presentAddressMultiple;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getPresentPlace() {
		return presentPlace;
	}

	public void setPresentPlace(String presentPlace) {
		this.presentPlace = presentPlace;
	}

	public String getPresentDistrict() {
		return presentDistrict;
	}

	public void setPresentDistrict(String presentDistrict) {
		this.presentDistrict = presentDistrict;
	}

	public String getPresentPin() {
		return presentPin;
	}

	public void setPresentPin(String presentPin) {
		this.presentPin = presentPin;
	}

	public String getPresentPhone() {
		return presentPhone;
	}

	public void setPresentPhone(String presentPhone) {
		this.presentPhone = presentPhone;
	}

	public String getPresentMobile() {
		return presentMobile;
	}

	public void setPresentMobile(String presentMobile) {
		this.presentMobile = presentMobile;
	}

	public String getIsActiveOldAddress() {
		return isActiveOldAddress;
	}

	public void setIsActiveOldAddress(String isActiveOldAddress) {
		this.isActiveOldAddress = isActiveOldAddress;
	}
}
