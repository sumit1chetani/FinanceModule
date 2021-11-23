package com.dci.tenant.finance.manageCustomer;

public class ManageCustomerBankBean {

	private Integer entityBankId;
	private Integer entityId;
	private String bankName;
	private String accountNumber;
	private String accountNo;
	private Integer accountTypeId;
	private String accountType;
	private String ifscCode;
	private Integer bankCityId;
	private String addressId;
	private String bankDetAddress;
	private String desState;
	private String desStateCode;
	private boolean select = false;

	private String desZipcode;
	private String desCountryCode;
	private String desCountry;

	private Integer bankAddressId;

	public Integer getEntityBankId() {
		return entityBankId;
	}

	public void setEntityBankId(Integer entityBankId) {
		this.entityBankId = entityBankId;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Integer getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Integer accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Integer getBankCityId() {
		return bankCityId;
	}

	public void setBankCityId(Integer bankCityId) {
		this.bankCityId = bankCityId;
	}

	public String getBankDetAddress() {
		return bankDetAddress;
	}

	public void setBankDetAddress(String bankDetAddress) {
		this.bankDetAddress = bankDetAddress;
	}

	public String getDesState() {
		return desState;
	}

	public void setDesState(String desState) {
		this.desState = desState;
	}

	public String getDesZipcode() {
		return desZipcode;
	}

	public void setDesZipcode(String desZipcode) {
		this.desZipcode = desZipcode;
	}

	public String getDesCountry() {
		return desCountry;
	}

	public void setDesCountry(String desCountry) {
		this.desCountry = desCountry;
	}

	public String getDesStateCode() {
		return desStateCode;
	}

	public void setDesStateCode(String desStateCode) {
		this.desStateCode = desStateCode;
	}

	public String getDesCountryCode() {
		return desCountryCode;
	}

	public void setDesCountryCode(String desCountryCode) {
		this.desCountryCode = desCountryCode;
	}

	public Integer getBankAddressId() {
		return bankAddressId;
	}

	public void setBankAddressId(Integer bankAddressId) {
		this.bankAddressId = bankAddressId;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

}
