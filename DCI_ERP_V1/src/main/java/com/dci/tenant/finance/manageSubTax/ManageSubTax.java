package com.dci.tenant.finance.manageSubTax;

public class ManageSubTax {
	private Integer subTaxId;
	private String subTaxCode;
	private String subTaxName;
	private Integer subTaxMethodId;
	private String subTaxMethod;
	private double subTaxMethodAmount;
	private double subTaxFixedAmount;
	private double subTaxPercentage;
	private String subTaxType;
	private Integer subTaxTypeId;
	private String subTaxAccount;
	private boolean isactive;
	private boolean isEdit;
	private String text;
	private String id;
	private String acctCode;
	private String acctName;
	private Integer taxId;

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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getSubTaxId() {
		return subTaxId;
	}

	public void setSubTaxId(Integer subTaxId) {
		this.subTaxId = subTaxId;
	}

	public String getSubTaxCode() {
		return subTaxCode;
	}

	public void setSubTaxCode(String subTaxCode) {
		this.subTaxCode = subTaxCode;
	}

	public String getSubTaxName() {
		return subTaxName;
	}

	public void setSubTaxName(String subTaxName) {
		this.subTaxName = subTaxName;
	}

	public Integer getSubTaxMethodId() {
		return subTaxMethodId;
	}

	public void setSubTaxMethodId(Integer subTaxMethodId) {
		this.subTaxMethodId = subTaxMethodId;
	}

	public String getSubTaxMethod() {
		return subTaxMethod;
	}

	public void setSubTaxMethod(String subTaxMethod) {
		this.subTaxMethod = subTaxMethod;
	}

	public double getSubTaxMethodAmount() {
		return subTaxMethodAmount;
	}

	public void setSubTaxMethodAmount(double subTaxMethodAmount) {
		this.subTaxMethodAmount = subTaxMethodAmount;
	}

	public double getSubTaxFixedAmount() {
		return subTaxFixedAmount;
	}

	public void setSubTaxFixedAmount(double subTaxFixedAmount) {
		this.subTaxFixedAmount = subTaxFixedAmount;
	}

	public double getSubTaxPercentage() {
		return subTaxPercentage;
	}

	public void setSubTaxPercentage(double subTaxPercentage) {
		this.subTaxPercentage = subTaxPercentage;
	}

	public String getSubTaxType() {
		return subTaxType;
	}

	public void setSubTaxType(String subTaxType) {
		this.subTaxType = subTaxType;
	}

	public Integer getSubTaxTypeId() {
		return subTaxTypeId;
	}

	public void setSubTaxTypeId(Integer subTaxTypeId) {
		this.subTaxTypeId = subTaxTypeId;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getSubTaxAccount() {
		return subTaxAccount;
	}

	public void setSubTaxAccount(String subTaxAccount) {
		this.subTaxAccount = subTaxAccount;
	}

	/**
	 * @return the taxId
	 */
	public Integer getTaxId() {
		return taxId;
	}

	/**
	 * @param taxId
	 *            the taxId to set
	 */
	public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}

}