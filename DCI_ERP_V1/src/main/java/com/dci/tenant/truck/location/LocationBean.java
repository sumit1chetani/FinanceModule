package com.dci.tenant.truck.location;



import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;


@AuditLoggableType(tableName = "location", formCode = "F0248")


public class LocationBean {
	

private Integer locationId;
private String locationCode;
private String locationName;
private String shortName;
private String landMark;
private String type;
private String latitude;
private String longitude;
private String description;
private String tableName;
private String formCode;
private String countryId;
private String countryName;
private boolean success;
private boolean locationErrorMessage;
private boolean shortNameErrorMessage;
private String fromPort;
private String toPort;
private String id;
private String text;





public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getFromPort() {
	return fromPort;
}
public void setFromPort(String fromPort) {
	this.fromPort = fromPort;
}
public String getToPort() {
	return toPort;
}
public void setToPort(String toPort) {
	this.toPort = toPort;
}
public String getCountryName() {
	return countryName;
}
public void setCountryName(String countryName) {
	this.countryName = countryName;
}
@AuditLoggable(fieldName = "country_id", displayName = "countryId")
public String getCountryId() {
	return countryId;
}
public void setCountryId(String countryId) {
	this.countryId = countryId;
}
public Integer getLocationId() {
	return locationId;
}


public void setLocationId(Integer locationId) {
	this.locationId = locationId;
}
public String getLocationCode() {
	return locationCode;
}
public void setLocationCode(String locationCode) {
	this.locationCode = locationCode;
}
public String getTableName() {
	return tableName;
}
public void setTableName(String tableName) {
	this.tableName = tableName;
}
public String getFormCode() {
	return formCode;
}
public void setFormCode(String formCode) {
	this.formCode = formCode;
}

@AuditLoggable(fieldName = "location_name", displayName = "locationName")
public String getLocationName() {
	return locationName;
}
public void setLocationName(String locationName) {
	this.locationName = locationName;
}

@AuditLoggable(fieldName = "loc_short_name", displayName = "shortName")
public String getShortName() {
	return shortName;
}
public void setShortName(String shortName) {
	this.shortName = shortName;
}

@AuditLoggable(fieldName = "land_mark", displayName = "landMark")
public String getLandMark() {
	return landMark;
}
public void setLandMark(String landMark) {
	this.landMark = landMark;
}

@AuditLoggable(fieldName = "location_type", displayName = "type")
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}


@AuditLoggable(fieldName = "latitude", displayName = "latitude")
public String getLatitude() {
	return latitude;
}
public void setLatitude(String latitude) {
	this.latitude = latitude;
}


@AuditLoggable(fieldName = "longitude", displayName = "longitude")
public String getLongitude() {
	return longitude;
}
public void setLongitude(String longitude) {
	this.longitude = longitude;
}

@AuditLoggable(fieldName = "description", displayName = "description")
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public boolean isLocationErrorMessage() {
	return locationErrorMessage;
}
public void setLocationErrorMessage(boolean locationErrorMessage) {
	this.locationErrorMessage = locationErrorMessage;
}
public boolean isShortNameErrorMessage() {
	return shortNameErrorMessage;
}
public void setShortNameErrorMessage(boolean shortNameErrorMessage) {
	this.shortNameErrorMessage = shortNameErrorMessage;
}



	
}

