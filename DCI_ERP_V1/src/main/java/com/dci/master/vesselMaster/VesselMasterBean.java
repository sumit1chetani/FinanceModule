package com.dci.master.vesselMaster;

import java.util.List;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;


@AuditLoggableType(tableName = "tb_vessels", formCode = "F0101")
public class VesselMasterBean {

	public Integer vesselID;
	public String vesselCode;
	public String vesselFlag;
	public float netTonnage;
	public String mainLineService;
	public String vesselName;
	public float grossTonnage;
	public String callSign;
	public String vesselOwner;
	public String nationalitYList;

	public String id;
	public String text;
	public Boolean isSuccess;
	public String message;
	public Boolean isEdit;

	private List nationalityList;

	
	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	public List getNationalityList() {
		return nationalityList;
	}

	public void setNationalityList(List nationalityList) {
		this.nationalityList = nationalityList;
	}
	@AuditLoggable(fieldName = "vesselID", displayName = "Vessel ID")
	public Integer getVesselID() {
		return vesselID;
	}

	public void setVesselID(Integer vesselID) {
		this.vesselID = vesselID;
	}
	@AuditLoggable(fieldName = "vesselCode", displayName = "Vessel Code")
	public String getVesselCode() {
		return vesselCode;
	}
	public void setVesselCode(String vesselCode) {
		this.vesselCode = vesselCode;
	}
	@AuditLoggable(fieldName = "vesselName", displayName = "Vessel Name")
	public String getVesselName() {
		return vesselName;
	}
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}
	public String getNationalitYList() {
		return nationalitYList;
	}
	public void setNationalitYList(String nationalitYList) {
		this.nationalitYList = nationalitYList;
	}
	@AuditLoggable(fieldName = "vesselFlag", displayName = "Vessel Flag")
	public String getVesselFlag() {
		return vesselFlag;
	}

	public void setVesselFlag(String vesselFlag) {
		this.vesselFlag = vesselFlag;
	}
	@AuditLoggable(fieldName = "netTonnage", displayName = "Net Tonnage")
	public float getNetTonnage() {
		return netTonnage;
	}

	public void setNetTonnage(float netTonnage) {
		this.netTonnage = netTonnage;
	}
	@AuditLoggable(fieldName = "mainLineService", displayName = "Main Line Service")
	public String getMainLineService() {
		return mainLineService;
	}

	public void setMainLineService(String mainLineService) {
		this.mainLineService = mainLineService;
	}
	@AuditLoggable(fieldName = "grossTonnage", displayName = "Gross Tonnage")
	public float getGrossTonnage() {
		return grossTonnage;
	}

	public void setGrossTonnage(float grossTonnage) {
		this.grossTonnage = grossTonnage;
	}
	@AuditLoggable(fieldName = "callSign", displayName = "Call Sign")
	public String getCallSign() {
		return callSign;
	}

	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}
	@AuditLoggable(fieldName = "vesselOwner", displayName = "Vessel Owner")
	public String getVesselOwner() {
		return vesselOwner;
	}

	public void setVesselOwner(String vesselOwner) {
		this.vesselOwner = vesselOwner;
	}

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

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
