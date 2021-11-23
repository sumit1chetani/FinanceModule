package com.dci.finance.managelocation;

import java.util.List;

public class ManageLocationBean {

	private String manageName;
	private String address;
	private String addressId;
	private String locationId;
	private String city;
	private String cityId;
	private String state;
	private String zipCode;
	private String country;
	private String isActive;
	private String parentLocation;
	private String pid;
	private String locationType;
	private String lid;
	private String locationIncharge;
	private String empId;
	private String locationActivity;
	private String stockLocation;
	private String scrapLocation;
	private String isParentAddress;
	private boolean isEdit;

	private int id;
	private String text;
	private int defid;
	private String defnam;

	private boolean isDeleted;

	private Boolean select;

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

	private List<ManageLocationBean> addressTable;
	private List<ManageLocationBean> mainTable;

	public List<ManageLocationBean> getAddressTable() {
		return addressTable;
	}

	public void setAddressTable(List<ManageLocationBean> addressTable) {
		this.addressTable = addressTable;
	}

	public List<ManageLocationBean> getMainTable() {
		return mainTable;
	}

	public void setMainTable(List<ManageLocationBean> mainTable) {
		this.mainTable = mainTable;
	}

	public String getManageName() {
		return manageName;
	}

	public void setManageName(String manageName) {
		this.manageName = manageName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getParentLocation() {
		return parentLocation;
	}

	public void setParentLocation(String parentLocation) {
		this.parentLocation = parentLocation;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLocationIncharge() {
		return locationIncharge;
	}

	public void setLocationIncharge(String locationIncharge) {
		this.locationIncharge = locationIncharge;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getLocationActivity() {
		return locationActivity;
	}

	public void setLocationActivity(String locationActivity) {
		this.locationActivity = locationActivity;
	}

	public String getStockLocation() {
		return stockLocation;
	}

	public void setStockLocation(String stockLocation) {
		this.stockLocation = stockLocation;
	}

	public String getScrapLocation() {
		return scrapLocation;
	}

	public void setScrapLocation(String scrapLocation) {
		this.scrapLocation = scrapLocation;
	}

	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getIsParentAddress() {
		return isParentAddress;
	}

	public void setIsParentAddress(String isParentAddress) {
		this.isParentAddress = isParentAddress;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Boolean getSelect() {
		return select;
	}

	public void setSelect(Boolean select) {
		this.select = select;
	}

	public int getDefid() {
		return defid;
	}

	public void setDefid(int defid) {
		this.defid = defid;
	}

	public String getDefnam() {
		return defnam;
	}

	public void setDefnam(String defnam) {
		this.defnam = defnam;
	}

	
}
