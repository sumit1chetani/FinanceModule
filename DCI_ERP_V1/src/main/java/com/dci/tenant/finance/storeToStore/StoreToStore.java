package com.dci.tenant.finance.storeToStore;

import com.dci.master.settings.UOM.EntityBean;

public class StoreToStore extends EntityBean {

	private String workorderId;
	private String workorderNumber;
	private int purchaseRequisitionId;
	private String requisitionNumber;
	private String requisitionDate;
	private String employeeId;// requested_by
	private String employeeName;
	private Integer requisitionType;
	private String designationName;// Job Tittle
	private String sourceLocation;
	private String destinationLocationName;
	private String sourceLocationName;
	private String destinationLocation;
	private Integer designationId;
	private String desig;

	private Integer requisitionStatus;
	private int sourceLocationId;
	private int itemId;
	private int qcQuantity;
	private int quantity;
	private String locationName;
	private int city;
	private String stateCode;
	private String stateName;
	private String cityName;
	private String street;
	private String pincode;
	private String id;
	private String text;
	private String country;
	private String countryName;
	private String companyId;
	private String companyName;

	private boolean select;
	private boolean checkPhysicalQuantity;
	private int stockLedgerId;
	private boolean disableQuantity = false;

	public String getWorkorderId() {
		return workorderId;
	}

	public void setWorkorderId(String workorderId) {
		this.workorderId = workorderId;
	}

	public String getWorkorderNumber() {
		return workorderNumber;
	}

	public void setWorkorderNumber(String workorderNumber) {
		this.workorderNumber = workorderNumber;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public int getPurchaseRequisitionId() {
		return purchaseRequisitionId;
	}

	public void setPurchaseRequisitionId(int purchaseRequisitionId) {
		this.purchaseRequisitionId = purchaseRequisitionId;
	}

	public String getRequisitionDate() {
		return requisitionDate;
	}

	public void setRequisitionDate(String requisitionDate) {
		this.requisitionDate = requisitionDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getRequisitionType() {
		return requisitionType;
	}

	public void setRequisitionType(Integer requisitionType) {
		this.requisitionType = requisitionType;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	public String getDestinationLocation() {
		return destinationLocation;
	}

	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}

	public String getDestinationLocationName() {
		return destinationLocationName;
	}

	public void setDestinationLocationName(String destinationLocationName) {
		this.destinationLocationName = destinationLocationName;
	}

	public String getSourceLocationName() {
		return sourceLocationName;
	}

	public void setSourceLocationName(String sourceLocationName) {
		this.sourceLocationName = sourceLocationName;
	}

	public String getRequisitionNumber() {
		return requisitionNumber;
	}

	public void setRequisitionNumber(String requisitionNumber) {
		this.requisitionNumber = requisitionNumber;
	}

	public Integer getRequisitionStatus() {
		return requisitionStatus;
	}

	public void setRequisitionStatus(Integer requisitionStatus) {
		this.requisitionStatus = requisitionStatus;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public boolean isCheckPhysicalQuantity() {
		return checkPhysicalQuantity;
	}

	public void setCheckPhysicalQuantity(boolean checkPhysicalQuantity) {
		this.checkPhysicalQuantity = checkPhysicalQuantity;
	}

	/**
	 * @return the sourceLocationId
	 */
	public int getSourceLocationId() {
		return sourceLocationId;
	}

	/**
	 * @param sourceLocationId
	 *            the sourceLocationId to set
	 */
	public void setSourceLocationId(int sourceLocationId) {
		this.sourceLocationId = sourceLocationId;
	}

	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the qcQuantity
	 */
	public int getQcQuantity() {
		return qcQuantity;
	}

	/**
	 * @param qcQuantity
	 *            the qcQuantity to set
	 */
	public void setQcQuantity(int qcQuantity) {
		this.qcQuantity = qcQuantity;
	}

	public int getStockLedgerId() {
		return stockLedgerId;
	}

	public void setStockLedgerId(int stockLedgerId) {
		this.stockLedgerId = stockLedgerId;
	}

	public boolean isDisableQuantity() {
		return disableQuantity;
	}

	public void setDisableQuantity(boolean disableQuantity) {
		this.disableQuantity = disableQuantity;
	}

}
