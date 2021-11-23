package com.dci.tenant.finance.consignmentRequest;

import java.util.ArrayList;
import java.util.List;

import com.dci.master.settings.UOM.EntityBean;

public class ConsignmentRequest extends EntityBean {
	private int purchaseRequisitionId;
	private String requisitionNumber;
	private String requisitionDate;
	private String employeeId;// requested_by
	private String userId;
	private boolean existFlag;

	public boolean isExistFlag() {
		return existFlag;
	}

	public void setExistFlag(boolean existFlag) {
		this.existFlag = existFlag;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	private String employeeName;
	private Integer requisitionType;
	private String designationName;// Job Tittle
	private String sourceLocation;
	private String destinationLocationName;
	private String sourceLocationName;
	private String destinationLocation;
	private Integer designationId;
	private String prRequestNo;
	private String requestDate;
	private Integer requestType;
	private String requestTypeName;
	private String requestTypeflag;
	private Integer availQuantity;
	private String purchaseRequisitionNumber;

	private Integer altuom;
	private double altqty;

	private String altuomName;

	public Integer getAltuom() {
		return altuom;
	}

	public void setAltuom(Integer altuom) {
		this.altuom = altuom;
	}

	public double getAltqty() {
		return altqty;
	}

	public void setAltqty(double altqty) {
		this.altqty = altqty;
	}

	public String getAltuomName() {
		return altuomName;
	}

	public void setAltuomName(String altuomName) {
		this.altuomName = altuomName;
	}

	public String getPurchaseRequisitionNumber() {
		return purchaseRequisitionNumber;
	}

	public void setPurchaseRequisitionNumber(String purchaseRequisitionNumber) {
		this.purchaseRequisitionNumber = purchaseRequisitionNumber;
	}

	public Integer getAvailQuantity() {
		return availQuantity;
	}

	public void setAvailQuantity(Integer availQuantity) {
		this.availQuantity = availQuantity;
	}

	public Integer getRequestType() {
		return requestType;
	}

	public void setRequestType(Integer requestType) {
		this.requestType = requestType;
	}

	public String getRequestTypeName() {
		return requestTypeName;
	}

	public void setRequestTypeName(String requestTypeName) {
		this.requestTypeName = requestTypeName;
	}

	public String getRequestTypeflag() {
		return requestTypeflag;
	}

	public void setRequestTypeflag(String requestTypeflag) {
		this.requestTypeflag = requestTypeflag;
	}

	public String getPrRequestNo() {
		return prRequestNo;
	}

	public void setPrRequestNo(String prRequestNo) {
		this.prRequestNo = prRequestNo;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	private Integer requisitionStatus;
	private String locationName;
	private String itemDescription;
	private int city;
	private String costcenter;
	private String costcenterName;

	public String getCostcenterName() {
		return costcenterName;
	}

	public void setCostcenterName(String costcenterName) {
		this.costcenterName = costcenterName;
	}

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

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

	private String requisitionStatusName;

	private String itemCode;

	private List<ConsignmentRequestSubBean> itemdetail1 = new ArrayList<>();

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public List<ConsignmentRequestSubBean> getItemdetail1() {
		return itemdetail1;
	}

	public void setItemdetail1(List<ConsignmentRequestSubBean> itemdetail1) {
		this.itemdetail1 = itemdetail1;
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

	public String getRequisitionStatusName() {
		return requisitionStatusName;
	}

	public void setRequisitionStatusName(String requisitionStatusName) {
		this.requisitionStatusName = requisitionStatusName;
	}

}
