package com.dci.tenant.finance.manageitem;

public class ManageItemVendorBean {

	private String tableId;
	private int vendorId;
	
	private int entityId;
	private String entityName;
	private boolean select = false;
	private String vendorItemName;
	private String vendorItemCode;
	private String vendorMinimumQuantity;
	private int vendorUom;
	private int pricingType;
	private String vendorLeadTime;

	/**
	 * @return the tableId
	 */
	public String getTableId() {
		return tableId;
	}

	/**
	 * @param tableId
	 *            the tableId to set
	 */
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	/**
	 * @return the entityId
	 */
	public int getEntityId() {
		return entityId;
	}

	/**
	 * @param entityId
	 *            the entityId to set
	 */
	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	/**
	 * @return the vendorItemName
	 */
	public String getVendorItemName() {
		return vendorItemName;
	}

	/**
	 * @param vendorItemName
	 *            the vendorItemName to set
	 */
	public void setVendorItemName(String vendorItemName) {
		this.vendorItemName = vendorItemName;
	}

	/**
	 * @return the vendorItemCode
	 */
	public String getVendorItemCode() {
		return vendorItemCode;
	}

	/**
	 * @param vendorItemCode
	 *            the vendorItemCode to set
	 */
	public void setVendorItemCode(String vendorItemCode) {
		this.vendorItemCode = vendorItemCode;
	}

	/**
	 * @return the vendorMinimumQuantity
	 */
	public String getVendorMinimumQuantity() {
		return vendorMinimumQuantity;
	}

	/**
	 * @param vendorMinimumQuantity
	 *            the vendorMinimumQuantity to set
	 */
	public void setVendorMinimumQuantity(String vendorMinimumQuantity) {
		this.vendorMinimumQuantity = vendorMinimumQuantity;
	}

	/**
	 * @return the vendorUom
	 */
	public int getVendorUom() {
		return vendorUom;
	}

	/**
	 * @param vendorUom
	 *            the vendorUom to set
	 */
	public void setVendorUom(int vendorUom) {
		this.vendorUom = vendorUom;
	}

	/**
	 * @return the pricingType
	 */
	public int getPricingType() {
		return pricingType;
	}

	/**
	 * @param pricingType
	 *            the pricingType to set
	 */
	public void setPricingType(int pricingType) {
		this.pricingType = pricingType;
	}

	/**
	 * @return the entityName
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * @param entityName
	 *            the entityName to set
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	/**
	 * @return the vendorId
	 */
	public int getVendorId() {
		return vendorId;
	}

	/**
	 * @param vendorId
	 *            the vendorId to set
	 */
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * @return the vendorLeadTime
	 */
	public String getVendorLeadTime() {
		return vendorLeadTime;
	}

	/**
	 * @param vendorLeadTime
	 *            the vendorLeadTime to set
	 */
	public void setVendorLeadTime(String vendorLeadTime) {
		this.vendorLeadTime = vendorLeadTime;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	

}
