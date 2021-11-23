package com.dci.master.service;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "sector_port", formCode = "F6067")
public class ServiceMasterTableDetail {

	private String portCode;
	private String transhipmentHub;
	private String legDescription;
	private long slNo;
	private String toPort;
	private String id;
	private String text;
	private Integer berthHour;
	private Integer berthMin;
	private Integer stayHour;
	private Integer stayMin;
	private Integer steamingHour;
	private Integer steamingMin;
	private Double distance;
	private Double speed;
	private Integer outValue;
	private Double zoneValue;

	@AuditLoggable(fieldName = "berth_hour", displayName = "Birth Hour")
	public Integer getBerthHour() {
		return berthHour;
	}

	public void setBerthHour(Integer berthHour) {
		this.berthHour = berthHour;
	}

	@AuditLoggable(fieldName = "berth_min", displayName = "Birth Min")
	public Integer getBerthMin() {
		return berthMin;
	}

	public void setBerthMin(Integer berthMin) {
		this.berthMin = berthMin;
	}

	@AuditLoggable(fieldName = "port_stay_hour", displayName = "Port Stay Hour")
	public Integer getStayHour() {
		return stayHour;
	}

	public void setStayHour(Integer stayHour) {
		this.stayHour = stayHour;
	}

	@AuditLoggable(fieldName = "port_stay_min", displayName = "Port Stay min")
	public Integer getStayMin() {
		return stayMin;
	}

	public void setStayMin(Integer stayMin) {
		this.stayMin = stayMin;
	}

	@AuditLoggable(fieldName = "steaming_hour", displayName = "Steaming Hour")
	public Integer getSteamingHour() {
		return steamingHour;
	}

	public void setSteamingHour(Integer steamingHour) {
		this.steamingHour = steamingHour;
	}

	@AuditLoggable(fieldName = "steaming_min", displayName = "Steaming Min")
	public Integer getSteamingMin() {
		return steamingMin;
	}

	public void setSteamingMin(Integer steamingMin) {
		this.steamingMin = steamingMin;
	}

	@AuditLoggable(fieldName = "distance", displayName = "Distance")
	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@AuditLoggable(fieldName = "speed", displayName = "Speed")
	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	@AuditLoggable(fieldName = "out_value", displayName = "Out")
	public Integer getOutValue() {
		return outValue;
	}

	public void setOutValue(Integer outValue) {
		this.outValue = outValue;
	}

	@AuditLoggable(fieldName = "zone_value", displayName = "Zone")
	public Double getZoneValue() {
		return zoneValue;
	}

	public void setZoneValue(Double zoneValue) {
		this.zoneValue = zoneValue;
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

	@AuditLoggable(fieldName = "port_id", displayName = "Ports Transitted")
	public String getPortCode() {
		return portCode;
	}

	public void setPortCode(String portCode) {
		this.portCode = portCode;
	}

	@AuditLoggable(fieldName = "trans_hub", displayName = "Transhipment Hub")
	public String getTranshipmentHub() {
		return transhipmentHub;
	}

	public void setTranshipmentHub(String transhipmentHub) {
		this.transhipmentHub = transhipmentHub;
	}

	@AuditLoggable(fieldName = "leg_dec", displayName = "Leg Description")
	public String getLegDescription() {
		return legDescription;
	}

	public void setLegDescription(String legDescription) {
		this.legDescription = legDescription;
	}

	

	
	public String getToPort() {
		return toPort;
	}

	public void setToPort(String toPort) {
		this.toPort = toPort;
	}

	public long getSlNo() {
		return slNo;
	}

	public void setSlNo(long slNo) {
		this.slNo = slNo;
	}

}