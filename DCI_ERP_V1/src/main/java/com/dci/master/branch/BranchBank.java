package com.dci.master.branch;

public class BranchBank {
   private Integer branchId;
	
	private Integer branchBankDetailId;

	private String bankName;
	
	private String bankAddress;

	private String accountNo;

	private String ifscCode;
	
	private String ibanNo;
	
	private String shiftCard;
	
	private String companyName;
	private String currencyName;
	private String logopath1;
	private String uom1;
	private String stateName;
	private String countryName;
	private String cityName;

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getIbanNo() {
		return ibanNo;
	}

	public void setIbanNo(String ibanNo) {
		this.ibanNo = ibanNo;
	}

	public String getShiftCard() {
		return shiftCard;
	}

	public void setShiftCard(String shiftCard) {
		this.shiftCard = shiftCard;
	}

	public boolean isBankActive() {
		return bankActive;
	}

	public void setBankActive(boolean bankActive) {
		this.bankActive = bankActive;
	}

	public Integer getBranchBankDetailId() {
		return branchBankDetailId;
	}

	public void setBranchBankDetailId(Integer branchBankDetailId) {
		this.branchBankDetailId = branchBankDetailId;
	}

	private boolean bankActive;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getLogopath1() {
		return logopath1;
	}

	public void setLogopath1(String logopath1) {
		this.logopath1 = logopath1;
	}

	public String getUom1() {
		return uom1;
	}

	public void setUom1(String uom1) {
		this.uom1 = uom1;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	
}
