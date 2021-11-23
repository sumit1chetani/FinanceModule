package com.dci.tenant.finance.salesorder;

public class SalesOrderDtlBean {
	private int salesOrderDtlId;
	private String itemId;
	private String itemCode;
	private String itemName;
	private String itemDesc;
	private String itemCategory;
	private String itemCategoryId;
	private String taxCode;
	private String taxId;
	private String unit;
	private String unitId;
	private double qty;
	private double taxPercent;
	private double price;
	private double amount;
	private double taxAmount;
	private Object select;
	private String subTaxType;
	private double subTaxPercentage;
	private double sub_tax_amount;
	private double taxPercentage;

	private String id;
	private String text;

	public int getSalesOrderDtlId() {
		return salesOrderDtlId;
	}

	public void setSalesOrderDtlId(int salesOrderDtlId) {
		this.salesOrderDtlId = salesOrderDtlId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(String itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public double getTaxPercent() {
		return taxPercent;
	}

	public void setTaxPercent(double taxPercent) {
		this.taxPercent = taxPercent;
	}

	public String getSubTaxType() {
		return subTaxType;
	}

	public void setSubTaxType(String subTaxType) {
		this.subTaxType = subTaxType;
	}

	public double getSubTaxPercentage() {
		return subTaxPercentage;
	}

	public void setSubTaxPercentage(double subTaxPercentage) {
		this.subTaxPercentage = subTaxPercentage;
	}

	public double getSub_tax_amount() {
		return sub_tax_amount;
	}

	public void setSub_tax_amount(double sub_tax_amount) {
		this.sub_tax_amount = sub_tax_amount;
	}

	public double getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public Object getSelect() {
		return select;
	}

	public void setSelect(Object select) {
		this.select = select;
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

}
