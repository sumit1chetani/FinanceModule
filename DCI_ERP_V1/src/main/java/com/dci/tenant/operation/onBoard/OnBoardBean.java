package com.dci.tenant.operation.onBoard;

import java.util.List;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "tb_onboard", formCode = "F0108")

public class OnBoardBean {

	private String vessel;
	private String vesselVoyage;
	private String voyage;
	private String port;
	private String service;
	private String onBoardDate;
	private Integer slno;
	private String blNo;
	private String bookingNo;
	private String customerName;
	private String customerType;
	private String containerType;
	private String containerNo;
	private Integer containerId;
	private String sealNo;
	private String packgeType;
	private Integer noOfPkgs;
	private String pod;
	private Integer portSeq;
	private List<OnBoardBean> containerDtl;
	private String onBoardId;
	private String userId;
	private String slotOperator;
	private String shippingtype;
	private Integer leg;
	private String onboardStatusDate;
	private String gateInDate;
	private String mode;
	private String carrier;
	private String jobNo;

	public String getJobNo() {
		return jobNo;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getGateInDate() {
		return gateInDate;
	}

	public void setGateInDate(String gateInDate) {
		this.gateInDate = gateInDate;
	}

	private String ContainerCount;
	private String ContainerTypeCount;
	private boolean soc;
	private String pol;
	private String statusCode;

	private String fpod;
	private String etd;
	private String connectVessel = null;
	private String connectVoyage = null;
	private Double gw;
	
	private String customerMail;
	private boolean success;

	private List<OnBoardBean> detailList;
	private List<OnBoardBean> contList;

	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getVesselVoyage() {
		return vesselVoyage;
	}

	public void setVesselVoyage(String vesselVoyage) {
		this.vesselVoyage = vesselVoyage;
	}


	public String getCustomerMail() {
		return customerMail;
	}

	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}

	@AuditLoggable(fieldName = "trans_leg", displayName = "trans_leg")
	public Integer getLeg() {
		return leg;
	}

	public void setLeg(Integer leg) {
		this.leg = leg;
	}

	
	@AuditLoggable(fieldName = "booking_type", displayName = "shippingtype")

	public String getShippingtype() {
		return shippingtype;
	}

	public void setShippingtype(String shippingtype) {
		this.shippingtype = shippingtype;
	}

	@AuditLoggable(fieldName = "slot_operator", displayName = "slotOperator")
	public String getSlotOperator() {
		return slotOperator;
	}

	public void setSlotOperator(String slotOperator) {
		this.slotOperator = slotOperator;
	}

	@AuditLoggable(fieldName = "onboard_id", displayName = "onBoardId")
	public String getOnBoardId() {
		return onBoardId;
	}

	public void setOnBoardId(String onBoardId) {
		this.onBoardId = onBoardId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@AuditLoggable(fieldName = "vessel", displayName = "vessel")
	public String getVessel() {
		return vessel;
	}

	public void setVessel(String vessel) {
		this.vessel = vessel;
	}

	@AuditLoggable(fieldName = "voyage", displayName = "voyage")
	public String getVoyage() {
		return voyage;
	}

	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	@AuditLoggable(fieldName = "onboard_date", displayName = "onBoardDate")
	public String getOnBoardDate() {
		return onBoardDate;
	}

	public void setOnBoardDate(String onBoardDate) {
		this.onBoardDate = onBoardDate;
	}

	public Integer getSlno() {
		return slno;
	}

	public void setSlno(Integer slno) {
		this.slno = slno;
	}

	@AuditLoggable(fieldName = "bl_no", displayName = "blNo")
	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	@AuditLoggable(fieldName = "booking_no", displayName = "bookingNo")

	public String getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	@AuditLoggable(fieldName = "container_type", displayName = "containerType")
	public String getContainerType() {
		return containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	@AuditLoggable(fieldName = "container_no", displayName = "containerNo")
	public String getContainerNo() {
		return containerNo;
	}

	public void setContainerNo(String containerNo) {
		this.containerNo = containerNo;
	}

	@AuditLoggable(fieldName = "seal_no", displayName = "sealNo")
	public String getSealNo() {
		return sealNo;
	}

	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
	}

	@AuditLoggable(fieldName = "package_type", displayName = "packgeType")
	public String getPackgeType() {
		return packgeType;
	}

	public void setPackgeType(String packgeType) {
		this.packgeType = packgeType;
	}
	
	@AuditLoggable(fieldName = "no_of_boxes", displayName = "noOfPkgs")
	public Integer getNoOfPkgs() {
		return noOfPkgs;
	}

	public void setNoOfPkgs(Integer noOfPkgs) {
		this.noOfPkgs = noOfPkgs;
	}
	@AuditLoggable(fieldName = "pod", displayName = "pod")

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}

	public List<OnBoardBean> getContainerDtl() {
		return containerDtl;
	}

	public void setContainerDtl(List<OnBoardBean> containerDtl) {
		this.containerDtl = containerDtl;
	}

	@AuditLoggable(fieldName = "pol_sequence", displayName = "portSeq")
	public Integer getPortSeq() {
		return portSeq;
	}

	public void setPortSeq(Integer portSeq) {
		this.portSeq = portSeq;
	}
	@AuditLoggable(fieldName = "cont_id", displayName = "containerId")

	public Integer getContainerId() {
		return containerId;
	}

	public void setContainerId(Integer containerId) {
		this.containerId = containerId;
	}
	@AuditLoggable(fieldName = "onboard_status_date", displayName = "onboardStatusDate")

	public String getOnboardStatusDate() {
		return onboardStatusDate;
	}

	public void setOnboardStatusDate(String onboardStatusDate) {
		this.onboardStatusDate = onboardStatusDate;
	}

	
	public List<OnBoardBean> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<OnBoardBean> detailList) {
		this.detailList = detailList;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getContainerCount() {
		return ContainerCount;
	}

	public void setContainerCount(String containerCount) {
		ContainerCount = containerCount;
	}

	public String getContainerTypeCount() {
		return ContainerTypeCount;
	}

	public void setContainerTypeCount(String containerTypeCount) {
		ContainerTypeCount = containerTypeCount;
	}

	public List<OnBoardBean> getContList() {
		return contList;
	}

	public void setContList(List<OnBoardBean> contList) {
		this.contList = contList;
	}

	public boolean isSoc() {
		return soc;
	}

	public void setSoc(boolean soc) {
		this.soc = soc;
	}

	@AuditLoggable(fieldName = "pol", displayName = "pol")
	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	private String created_by;
	private String created_date;
	private String modified_by;
	private String modified_date;


	@AuditLoggable(fieldName = "created_by", displayName = "created_by")
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	@AuditLoggable(fieldName = "created_date", displayName = "created_date")

	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public String getModified_date() {
		return modified_date;
	}
	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	public String getFpod() {
		return fpod;
	}

	public void setFpod(String fpod) {
		this.fpod = fpod;
	}

	public String getEtd() {
		return etd;
	}

	public void setEtd(String etd) {
		this.etd = etd;
	}

	public String getConnectVessel() {
		return connectVessel;
	}

	public void setConnectVessel(String connectVessel) {
		this.connectVessel = connectVessel;
	}

	public String getConnectVoyage() {
		return connectVoyage;
	}

	public void setConnectVoyage(String connectVoyage) {
		this.connectVoyage = connectVoyage;
	}

	public Double getGw() {
		return gw;
	}

	public void setGw(Double gw) {
		this.gw = gw;
	}

	
}

