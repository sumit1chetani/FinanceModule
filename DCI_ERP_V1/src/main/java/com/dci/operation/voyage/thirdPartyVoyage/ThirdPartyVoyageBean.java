package com.dci.operation.voyage.thirdPartyVoyage;



import java.util.ArrayList;
import java.util.List;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

/**
 * @author Paragon
 *
 */
@AuditLoggableType(tableName = "VOYAGE", formCode = "F0110")
public class ThirdPartyVoyageBean  {

	private String id;

	private String text;

	private String voyageId;

	private String vesselCode;
	
	private String vesselCode1;
	
	private String vesselName1;
	
	private String voyageNo;
	private String remarks;
	private String eta;
	private String etb;
	private String etd;
	private String rotationId;
	private String fromPort;
	private String toPort;
	private String pol;
	private String pod;
	private String fpod;
	ArrayList<String> voyageIdnew;
	private List<ThirdPartyVoyageBean> detail;
	
	private String vesselOperatorName;
	private String fromDate;
	private String toDate;
	
	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getVesselOperatorName() {
		return vesselOperatorName;
	}

	public void setVesselOperatorName(String vesselOperatorName) {
		this.vesselOperatorName = vesselOperatorName;
	}

	public List<ThirdPartyVoyageBean> getDetail() {
		return detail;
	}

	public void setDetail(List<ThirdPartyVoyageBean> detail) {
		this.detail = detail;
	}

	public String getToPort() {
		return toPort;
	}

	public void setToPort(String toPort) {
		this.toPort = toPort;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}

	public String getFpod() {
		return fpod;
	}

	public void setFpod(String fpod) {
		this.fpod = fpod;
	}

	public ArrayList<String> getVoyageIdnew() {
		return voyageIdnew;
	}

	public void setVoyageIdnew(ArrayList<String> voyageIdnew) {
		this.voyageIdnew = voyageIdnew;
	}

	public String getFromPort() {
		return fromPort;
	}

	public void setFromPort(String fromPort) {
		this.fromPort = fromPort;
	}

	public String getRotationId() {
		return rotationId;
	}

	public void setRotationId(String rotationId) {
		this.rotationId = rotationId;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getEtb() {
		return etb;
	}

	public void setEtb(String etb) {
		this.etb = etb;
	}

	public String getEtd() {
		return etd;
	}

	public void setEtd(String etd) {
		this.etd = etd;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getVoyageNo() {
		return voyageNo;
	}

	public void setVoyageNo(String voyageNo) {
		this.voyageNo = voyageNo;
	}

	private String vesselName;
	
	private String voyageId1;
	private String schStartDate;

	private String portCost;

	private Integer miscCost;

	private String gobunkerCost;

	private String sectorId;

	private String sectorName;

	private String schEndDate;

	private Integer hireCost;

	private Integer otherExpenses;

	private String reasonId;

	private String activityeId;

	private String foBunkerCost;
	
	private String vlsfobunkerCost;

	private String lsmgobunkerCost;

	private Integer agencyCost;
	
	private String isFirstVoyage;

	public String getIsFirstVoyage() {
		return isFirstVoyage;
	}

	public void setIsFirstVoyage(String isFirstVoyage) {
		this.isFirstVoyage = isFirstVoyage;
	}

	private Integer proformaInsurance;

	private String speed;

	private String activityCode;

	private String activityName;

	private String mloShortName;
	private String mloShortName1;


	private String formCode;

	private String oldVoyageId;
	private String flag;
	private int bookingCount = 0;
	private String charterLiability;
	private String awrp;
	private String addComm;
	private String ewri;
	private String vesselOperator;
	
	private String companyCode;
	
	
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@AuditLoggable(fieldName = "PROFORMA_PORT_COST", displayName = "PROFORMA PORT COST")
	
	
	public String getVesselOperator() {
		return vesselOperator;
	}

	public void setVesselOperator(String vesselOperator) {
		this.vesselOperator = vesselOperator;
	}

	
	public String getPortCost() {
		return portCost;
	}

	
	public void setPortCost(String portCost) {
		this.portCost = portCost;
	}

	@AuditLoggable(fieldName = "MISC_COST", displayName = "MISC COST")
	public Integer getMiscCost() {
		return miscCost;
	}

	public void setMiscCost(Integer miscCost) {
		this.miscCost = miscCost;
	}

	@AuditLoggable(fieldName = "GO_RVBUNKER_COST", displayName = "GO RVBUNKER COST")
	public String getGobunkerCost() {
		return gobunkerCost;
	}

	public void setGobunkerCost(String gobunkerCost) {
		this.gobunkerCost = gobunkerCost;
	}

	@AuditLoggable(fieldName = "CHATER_HIRE_COST", displayName = "CHATER HIRE COST")
	public Integer getHireCost() {
		return hireCost;
	}

	public void setHireCost(Integer hireCost) {
		this.hireCost = hireCost;
	}

	@AuditLoggable(fieldName = "OTHER_EXPANSES", displayName = "OTHER EXPANSES")
	public Integer getOtherExpenses() {
		return otherExpenses;
	}

	public void setOtherExpenses(Integer otherExpenses) {
		this.otherExpenses = otherExpenses;
	}

	@AuditLoggable(fieldName = "REASON", displayName = "REASON")
	public String getReasonId() {
		return reasonId;
	}

	public void setReasonId(String reasonId) {
		this.reasonId = reasonId;
	}

	@AuditLoggable(fieldName = "ACTIVITY_CODE", displayName = "ACTIVITY CODE")
	public String getActivityeId() {
		return activityeId;
	}

	public void setActivityeId(String activityeId) {
		this.activityeId = activityeId;
	}

	@AuditLoggable(fieldName = "FO_RVBUNKER_COST", displayName = "FO RVBUNKER COST")
	public String getFoBunkerCost() {
		return foBunkerCost;
	}

	public void setFoBunkerCost(String foBunkerCost) {
		this.foBunkerCost = foBunkerCost;
	}
	
	public String getVlsfobunkerCost() {
		return vlsfobunkerCost;
	}

	public void setVlsfobunkerCost(String vlsfobunkerCost) {
		this.vlsfobunkerCost = vlsfobunkerCost;
	}

	public String getLsmgobunkerCost() {
		return lsmgobunkerCost;
	}

	public void setLsmgobunkerCost(String lsmgobunkerCost) {
		this.lsmgobunkerCost = lsmgobunkerCost;
	}

	@AuditLoggable(fieldName = "TOTAL_AGENCY_COST", displayName = "TOTAL AGENCY COST")
	public Integer getAgencyCost() {
		return agencyCost;
	}

	public void setAgencyCost(Integer agencyCost) {
		this.agencyCost = agencyCost;
	}

	@AuditLoggable(fieldName = "PROFORMA_INVESTMENT", displayName = "PROFORMA INVESTMENT")
	public Integer getProformaInsurance() {
		return proformaInsurance;
	}

	public void setProformaInsurance(Integer proformaInsurance) {
		this.proformaInsurance = proformaInsurance;
	}

	@AuditLoggable(fieldName = "VESSEL_CODE", displayName = "VESSEL CODE")
	public String getVesselCode() {
		return vesselCode;
	}

	public void setVesselCode(String vesselCode) {
		this.vesselCode = vesselCode;
	}

	@AuditLoggable(fieldName = "SCH_START_DATE", displayName = "SCH START DATE")
	public String getSchStartDate() {
		return schStartDate;
	}

	public void setSchStartDate(String schStartDate) {
		this.schStartDate = schStartDate;
	}

	@AuditLoggable(fieldName = "SCH_END_DATE", displayName = "SCH END DATE")
	public String getSchEndDate() {
		return schEndDate;
	}

	public void setSchEndDate(String schEndDate) {
		this.schEndDate = schEndDate;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	@AuditLoggable(fieldName = "SECTOR_ID", displayName = "SECTOR CODE")
	public String getSectorId() {
		return sectorId;
	}

	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}

	@AuditLoggable(fieldName = "VOYAGE_ID", displayName = "VOYAGE CODE")
	public String getVoyageId() {
		return voyageId;
	}

	public void setVoyageId(String voyageId) {
		this.voyageId = voyageId;
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

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	@AuditLoggable(fieldName = "vessel_optr", displayName = "MLO")
	public String getMloShortName() {
		return mloShortName;
	}

	public void setMloShortName(String mloShortName) {
		this.mloShortName = mloShortName;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public String getOldVoyageId() {
		return oldVoyageId;
	}

	public void setOldVoyageId(String oldVoyageId) {
		this.oldVoyageId = oldVoyageId;
	}

	public int getBookingCount() {
		return bookingCount;
	}

	public void setBookingCount(int bookingCount) {
		this.bookingCount = bookingCount;
	}
	@AuditLoggable(fieldName = "Charter Liability", displayName = "Charter Liability")
	public String getCharterLiability() {
		return charterLiability;
	}

	public void setCharterLiability(String charterLiability) {
		this.charterLiability = charterLiability;
	}
	@AuditLoggable(fieldName = "AWRP", displayName = "AWRP")
	public String getAwrp() {
		return awrp;
	}

	public void setAwrp(String awrp) {
		this.awrp = awrp;
	}
	@AuditLoggable(fieldName = "ADD Comm", displayName = "ADD Comm")
	public String getAddComm() {
		return addComm;
	}

	public void setAddComm(String addComm) {
		this.addComm = addComm;
	}
	@AuditLoggable(fieldName = "EWRI", displayName = "EWRI")
	public String getEwri() {
		return ewri;
	}

	public void setEwri(String ewri) {
		this.ewri = ewri;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}



	public String getVoyageId1() {
		return voyageId1;
	}

	public void setVoyageId1(String voyageId1) {
		this.voyageId1 = voyageId1;
	}
	public String getVesselCode1() {
		return vesselCode1;
	}

	public void setVesselCode1(String vesselCode1) {
		this.vesselCode1 = vesselCode1;
	}

	public String getVesselName1() {
		return vesselName1;
	}

	public void setVesselName1(String vesselName1) {
		this.vesselName1 = vesselName1;
	}

	public String getMloShortName1() {
		return mloShortName1;
	}

	public void setMloShortName1(String mloShortName1) {
		this.mloShortName1 = mloShortName1;
	}



	
}
