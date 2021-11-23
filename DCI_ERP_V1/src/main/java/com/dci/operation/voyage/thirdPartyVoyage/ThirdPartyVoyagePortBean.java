package com.dci.operation.voyage.thirdPartyVoyage;


import com.dci.common.model.UserRightsProperties;
import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "VOYAGE_PORT", formCode = "F0110")
public class ThirdPartyVoyagePortBean extends UserRightsProperties {

	private String vesselCode;

	private String voyageId;

	private int portSequence;

	private String fromPort;

	private String rotationId;

	private String eta;

	private String etb;

	private String etd;

	private String berthingHour;

	private String berthingMin;

	private String portStayHour;

	private String portStayMin;

	private String portStayContHour;

	private String portStayContMin;

	private int speed;

	private String distance;

	private String toPort;

	private String steamingHour;

	private String steamingMin;

	private String steamingContHour;

	private String steamingContMin;

	private String totalPortStayTime;

	private String totalSteamingTime;

	private String totalVoyageTime;

	private String nextVoyage;

	private String oldVoyageId;

	private String loadingFlag;
	
	private String deleteStatus;
	
	private String remarks;

	private String cutoffdt;
	
	
	
	

	public String getCutoffdt() {
		return cutoffdt;
	}

	public void setCutoffdt(String cutoffdt) {
		this.cutoffdt = cutoffdt;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTotalPortStayTime() {
		return totalPortStayTime;
	}

	public void setTotalPortStayTime(String totalPortStayTime) {
		this.totalPortStayTime = totalPortStayTime;
	}

	public String getTotalSteamingTime() {
		return totalSteamingTime;
	}

	public void setTotalSteamingTime(String totalSteamingTime) {
		this.totalSteamingTime = totalSteamingTime;
	}

	public String getTotalVoyageTime() {
		return totalVoyageTime;
	}

	public void setTotalVoyageTime(String totalVoyageTime) {
		this.totalVoyageTime = totalVoyageTime;
	}

	@AuditLoggable(fieldName = "STEAMING_HOUR", displayName = "STEAMING_HOUR")
	public String getSteamingHour() {
		return steamingHour;
	}

	public void setSteamingHour(String steamingHour) {
		this.steamingHour = steamingHour;
	}

	@AuditLoggable(fieldName = "STEAMING_MIN", displayName = "STEAMING MIN")
	public String getSteamingMin() {
		return steamingMin;
	}

	public void setSteamingMin(String steamingMin) {
		this.steamingMin = steamingMin;
	}

	@AuditLoggable(fieldName = "STEAMING_CONT_HOUR", displayName = "STEAMING CONT HOUR")
	public String getSteamingContHour() {
		return steamingContHour;
	}

	public void setSteamingContHour(String steamingContHour) {
		this.steamingContHour = steamingContHour;
	}

	public String getSteamingContMin() {
		return steamingContMin;
	}

	public void setSteamingContMin(String steamingContMin) {
		this.steamingContMin = steamingContMin;
	}

	@AuditLoggable(fieldName = "STAY_HRS", displayName = "STAY HRS")
	public String getPortStayHour() {
		return portStayHour;
	}

	public void setPortStayHour(String portStayHour) {
		this.portStayHour = portStayHour;
	}

	@AuditLoggable(fieldName = "STAY_MIN", displayName = "STAY MIN")
	public String getPortStayMin() {
		return portStayMin;
	}

	public void setPortStayMin(String portStayMin) {
		this.portStayMin = portStayMin;
	}

	@AuditLoggable(fieldName = "STAY_HRS_CON", displayName = "STAY HRS CON")
	public String getPortStayContHour() {
		return portStayContHour;
	}

	public void setPortStayContHour(String portStayContHour) {
		this.portStayContHour = portStayContHour;
	}

	public String getPortStayContMin() {
		return portStayContMin;
	}

	public void setPortStayContMin(String portStayContMin) {
		this.portStayContMin = portStayContMin;
	}

	@AuditLoggable(fieldName = "SPEED", displayName = "SPEED")
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@AuditLoggable(fieldName = "TO_PORT_ID", displayName = "TO PORT ID")
	public String getToPort() {
		return toPort;
	}

	@AuditLoggable(fieldName = "VOYAGE_ID", displayName = "VOYAGE ID")
	public String getVoyageId() {
		return voyageId;
	}

	public void setVoyageId(String voyageId) {
		this.voyageId = voyageId;
	}

	@AuditLoggable(fieldName = "FROM_PORT_ID", displayName = "FROM PORT ID")
	public String getFromPort() {
		return fromPort;
	}

	public void setFromPort(String fromPort) {
		this.fromPort = fromPort;
	}

	@AuditLoggable(fieldName = "ROTATION_NO", displayName = "ROTATION_NO")
	public String getRotationId() {
		return rotationId;
	}

	public void setRotationId(String rotationId) {
		this.rotationId = rotationId;
	}

	@AuditLoggable(fieldName = "ETA", displayName = "ETA")
	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getEtd() {
		return etd;
	}

	public void setEtd(String etd) {
		this.etd = etd;
	}

	public void setToPort(String toPort) {
		this.toPort = toPort;
	}

	@AuditLoggable(fieldName = "PORT_SEQUENCE", displayName = "PORT SEQUENCE")
	public int getPortSequence() {
		return portSequence;
	}

	public void setPortSequence(int portSequence) {
		this.portSequence = portSequence;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getVesselCode() {
		return vesselCode;
	}

	public void setVesselCode(String vesselCode) {
		this.vesselCode = vesselCode;
	}

	public String getEtb() {
		return etb;
	}

	public void setEtb(String etb) {
		this.etb = etb;
	}

	@AuditLoggable(fieldName = "BERTH_HOUR", displayName = "BERTH HOUR")
	public String getBerthingHour() {
		return berthingHour;
	}

	public void setBerthingHour(String berthingHour) {
		this.berthingHour = berthingHour;
	}

	@AuditLoggable(fieldName = "BERTH_MIN", displayName = "BERTH MIN")
	public String getBerthingMin() {
		return berthingMin;
	}

	public void setBerthingMin(String berthingMin) {
		this.berthingMin = berthingMin;
	}

	@AuditLoggable(fieldName = "IS_NEXT_VOYAGE", displayName = "IS NEXT VOYAGE")
	public String getNextVoyage() {
		return nextVoyage;
	}

	public void setNextVoyage(String nextVoyage) {
		this.nextVoyage = nextVoyage;
	}

	public String getOldVoyageId() {
		return oldVoyageId;
	}

	public void setOldVoyageId(String oldVoyageId) {
		this.oldVoyageId = oldVoyageId;
	}

	public String getLoadingFlag() {
		return loadingFlag;
	}

	public void setLoadingFlag(String loadingFlag) {
		this.loadingFlag = loadingFlag;
	}

	@AuditLoggable(fieldName = "DELETE_STATUS", displayName = "DELETE STATUS")
	public String getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

}
