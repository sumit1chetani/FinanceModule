package com.dci.tenant.master.trucktrailermapping;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "truck_trailer_mapping", formCode = "F5039")
public class TruckTrailerMappingBean {
private String truckName;
private String trucklicenseNo;

public String getTrucklicenseNo() {
	return trucklicenseNo;
}
public void setTrucklicenseNo(String trucklicenseNo) {
	this.trucklicenseNo = trucklicenseNo;
}
private String startDate;
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
private Integer truckId;
private String trailerName;
private Integer trailerId;
private String fromDate;
private String toDate;
private String trailerNo;
private String formCode;
private String table;
private String tableName;

private String name;
private Integer trucktrailerId;

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
public String getTable() {
	return table;
}
public void setTable(String table) {
	this.table = table;
}

public String getTruckName() {
	return truckName;
}
public void setTruckName(String truckName) {
	this.truckName = truckName;
}
@AuditLoggable(fieldName = "truck_id", displayName = "truckId")

public Integer getTruckId() {
	return truckId;
}
public void setTruckId(Integer truckId) {
	this.truckId = truckId;
}

public String getTrailerName() {
	return trailerName;
}
public void setTrailerName(String trailerName) {
	this.trailerName = trailerName;
}
@AuditLoggable(fieldName = "trailer_id", displayName = "trailerId")

public Integer getTrailerId() {
	return trailerId;
}
public void setTrailerId(Integer trailerId) {
	this.trailerId = trailerId;
}
@AuditLoggable(fieldName = "from_date", displayName = "fromDate")

public String getFromDate() {
	return fromDate;
}
public void setFromDate(String fromDate) {
	this.fromDate = fromDate;
}
@AuditLoggable(fieldName = "to_date", displayName = "toDate")

public String getToDate() {
	return toDate;
}
public void setToDate(String toDate) {
	this.toDate = toDate;
}
public String getTrailerNo() {
	return trailerNo;
}
public void setTrailerNo(String trailerNo) {
	this.trailerNo = trailerNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public Integer getTrucktrailerId() {
	return trucktrailerId;
}
public void setTrucktrailerId(Integer trucktrailerId) {
	this.trucktrailerId = trucktrailerId;
}



}
