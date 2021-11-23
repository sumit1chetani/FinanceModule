package com.dci.tenant.finance.generalInvoice;

public class GeneralInvoiceProductDetailBean {

	private int siNo;
	private int itemId;
	private int quantity;
	private double unitprice;
	private double amount;
	private double tax;

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	private int invoiceProdDtl;
	private double taxAmount;
	private String costCenter;
	private int soDtlId;
	private int taxId;
	private String taxAccountId;
	private boolean select;

	private String productItem;

	public String getProductItem() {
		return productItem;
	}

	public void setProductItem(String productItem) {
		this.productItem = productItem;
	}

	public int getSiNo() {
		return siNo;
	}

	public void setSiNo(int siNo) {
		this.siNo = siNo;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	/**
	 * @return the soDtlId
	 */
	public int getSoDtlId() {
		return soDtlId;
	}

	/**
	 * @param soDtlId
	 *            the soDtlId to set
	 */
	public void setSoDtlId(int soDtlId) {
		this.soDtlId = soDtlId;
	}

	/**
	 * @return the taxId
	 */
	public int getTaxId() {
		return taxId;
	}

	/**
	 * @param taxId
	 *            the taxId to set
	 */
	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	/**
	 * @return the taxAccountId
	 */
	public String getTaxAccountId() {
		return taxAccountId;
	}

	/**
	 * @param taxAccountId
	 *            the taxAccountId to set
	 */
	public void setTaxAccountId(String taxAccountId) {
		this.taxAccountId = taxAccountId;
	}

	/**
	 * @return the invoiceProdDtl
	 */
	public int getInvoiceProdDtl() {
		return invoiceProdDtl;
	}

	/**
	 * @param invoiceProdDtl
	 *            the invoiceProdDtl to set
	 */
	public void setInvoiceProdDtl(int invoiceProdDtl) {
		this.invoiceProdDtl = invoiceProdDtl;
	}

	/**
	 * @return the taxAccountId
	 */

}
