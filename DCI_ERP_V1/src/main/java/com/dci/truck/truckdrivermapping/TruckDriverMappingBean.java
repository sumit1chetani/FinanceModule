package com.dci.truck.truckdrivermapping;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "truck_driver_mapping", formCode = "F0257")

public class TruckDriverMappingBean {
private String truckName;
private Integer truckId;
private String driverName;
private String driverId;
private String sdriverId;
private String sdriverName;
private String trkDrvMapId;

public String getSdriverName() {
	return sdriverName;
}
public void setSdriverName(String sdriverName) {
	this.sdriverName = sdriverName;
}

private String fromDate;
private String stoDate;

private String sfromDate;
@AuditLoggable(fieldName = "sec_emp_id", displayName = "sdriverId")

public String getSdriverId() {
	return sdriverId;
}
public void setSdriverId(String sdriverId) {
	this.sdriverId = sdriverId;
}
public String getStoDate() {
	return stoDate;
}
public void setStoDate(String stoDate) {
	this.stoDate = stoDate;
}
public String getSfromDate() {
	return sfromDate;
}
public void setSfromDate(String sfromDate) {
	this.sfromDate = sfromDate;
}

private String toDate;
private String driverNo;
private String formCode;
private String tableName;
private String trucklicenseNo;

public String getTrucklicenseNo() {
	return trucklicenseNo;
}
public void setTrucklicenseNo(String trucklicenseNo) {
	this.trucklicenseNo = trucklicenseNo;
}
public String getFormCode() {
	return formCode;
}
public void setFormCode(String formCode) {
	this.formCode = formCode;
}
public String getTableName() {
	return tableName;
}
public void setTableName(String tableName) {
	this.tableName = tableName;
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


public String getDriverName() {
	return driverName;
}
public void setDriverName(String driverName) {
	this.driverName = driverName;
}
@AuditLoggable(fieldName = "emp_id", displayName = "driverId")

public String getDriverId() {
	return driverId;
}
public void setDriverId(String driverId) {
	this.driverId = driverId;
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
public String getDriverNo() {
	return driverNo;
}
public void setDriverNo(String driverNo) {
	this.driverNo = driverNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public Integer getTruckdriverId() {
	return truckdriverId;
}
public void setTruckdriverId(Integer truckdriverId) {
	this.truckdriverId = truckdriverId;
}

private String name;
private Integer truckdriverId;

public String getTrkDrvMapId() {
	return trkDrvMapId;
}
public void setTrkDrvMapId(String trkDrvMapId) {
	this.trkDrvMapId = trkDrvMapId;
}

}
