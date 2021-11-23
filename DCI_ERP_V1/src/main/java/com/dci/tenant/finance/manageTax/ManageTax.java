package com.dci.tenant.finance.manageTax;

public class ManageTax {
	private Integer taxId;
	private String taxCode;
	private String taxName;
	private Integer taxMethodId;
	private String taxMethod;
	private double taxMethodAmount;
	private double taxFixedAmount;
	private double taxPercentage;
	private String taxType;
	private Integer taxTypeId;
	private String taxAccount;
	private boolean isactive;
	private String text;
	private int id;
	// private List subTax;
	private Integer subTaxId;
	private String subTaxName;
	private String acctCode;
	private String acctName;

	private double subTaxPercentage;
	private double subTaxAmount;
	private String subTaxMethod;

	private String code;

	public String getAcctCode() {
		return acctCode;
	}

	public void setAcctCode(String acctCode) {
		this.acctCode = acctCode;
	}

	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	/*
	 * public List getSubTax() { return subTax; }
	 * 
	 * public void setSubTax(List subTax) { this.subTax = subTax; }
	 */
	public Integer getSubTaxId() {
		return subTaxId;
	}

	public void setSubTaxId(Integer subTaxId) {
		this.subTaxId = subTaxId;
	}

	public String getSubTaxName() {
		return subTaxName;
	}

	public void setSubTaxName(String subTaxName) {
		this.subTaxName = subTaxName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getTaxId() {
		return taxId;
	}

	public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public Integer getTaxMethodId() {
		return taxMethodId;
	}

	public void setTaxMethodId(Integer taxMethodId) {
		this.taxMethodId = taxMethodId;
	}

	public String getTaxMethod() {
		return taxMethod;
	}

	public void setTaxMethod(String taxMethod) {
		this.taxMethod = taxMethod;
	}

	public double getTaxMethodAmount() {
		return taxMethodAmount;
	}

	public void setTaxMethodAmount(double taxMethodAmount) {
		this.taxMethodAmount = taxMethodAmount;
	}

	public double getTaxFixedAmount() {
		return taxFixedAmount;
	}

	public void setTaxFixedAmount(double taxFixedAmount) {
		this.taxFixedAmount = taxFixedAmount;
	}

	public double getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public Integer getTaxTypeId() {
		return taxTypeId;
	}

	public void setTaxTypeId(Integer taxTypeId) {
		this.taxTypeId = taxTypeId;
	}

	public String getTaxAccount() {
		return taxAccount;
	}

	public void setTaxAccount(String taxAccount) {
		this.taxAccount = taxAccount;
	}

	public double getSubTaxPercentage() {
		return subTaxPercentage;
	}

	public void setSubTaxPercentage(double subTaxPercentage) {
		this.subTaxPercentage = subTaxPercentage;
	}

	public double getSubTaxAmount() {
		return subTaxAmount;
	}

	public void setSubTaxAmount(double subTaxAmount) {
		this.subTaxAmount = subTaxAmount;
	}

	public String getSubTaxMethod() {
		return subTaxMethod;
	}

	public void setSubTaxMethod(String subTaxMethod) {
		this.subTaxMethod = subTaxMethod;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}