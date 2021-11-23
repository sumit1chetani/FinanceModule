package com.dci.operation.containerReleaseOrder;

import java.util.List;

import com.dci.tenant.auditlog.AuditLoggable;

public class printcontainerReleaseOrderBean {
	private String etasailDate;
	private String gateInDate;
	public String getGateInDate() {
		return gateInDate;
	}
	public void setGateInDate(String gateInDate) {
		this.gateInDate = gateInDate;
	}
	public String getEtasailDate() {
		return etasailDate;
	}
	public void setEtasailDate(String etasailDate) {
		this.etasailDate = etasailDate;
	}
	private String depot;

	public String getDepot() {
		return depot;
	}
	public void setDepot(String depot) {
		this.depot = depot;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	private String customerName;
	private String destination;
	private String voyage;
	private String vessel;


	public String getVoyage() {
		return voyage;
	}
	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}
	public String getVessel() {
		return vessel;
	}
	public void setVessel(String vessel) {
		this.vessel = vessel;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	private String quantity;

	public String getquantity() {
		return quantity;
	}
	public void setquantity(String quantity) {
		this.quantity = quantity;
	}
	private Integer bookingId;
	private String bookingNo;
	private String polName;
	private String podName;
	private String voyagePortETA;

	
	
	public String getVoyagePortETA() {
		return voyagePortETA;
	}
	public void setVoyagePortETA(String voyagePortETA) {
		this.voyagePortETA = voyagePortETA;
	}
	public String getPolName() {
		return polName;
	}
	public void setPolName(String polName) {
		this.polName = polName;
	}
	public String getPodName() {
		return podName;
	}
	public void setPodName(String podName) {
		this.podName = podName;
	}

	private String status;
	private String bookingDate;
	private String mloCode;
	private Integer lolId;
	private Integer lodId;
	private String transportType="L";
	private String createdBy;
	private String lolName;
	private String lodName;
	private String conType;
	private String containerNo;
	private String croDate;

	public String getCroDate() {
		return croDate;
	}
	public void setCroDate(String croDate) {
		this.croDate = croDate;
	}

	//commodityId;
	private String tripNo;
	private String tripStartDate;
	private String commodity;

	public String getCommodity() {
		return commodity;
	}
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	private String etd;
	private String eta;
	private String mloName;
	//private List<BookingDtl> bookingDtlList = new ArrayList<BookingDtl>();
	private String quotation;
	private String quotationNo;
	private String quoValidFrom;
	private String quoValidTill;
	private String mloId;
	private String quoId;
	private String bookingStatus;
	private String vat;
	private Integer mode;
	private List<printcontainerReleaseOrderBean> containerList;

	
	@AuditLoggable(fieldName = "booking_id", displayName = "Booking Id")
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	
	@AuditLoggable(fieldName = "booking_no", displayName = "Booking No")
	public String getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}
	
	@AuditLoggable(fieldName = "booking_date", displayName = "Booking Date")
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	@AuditLoggable(fieldName = "mlo_code", displayName = "Customer")
	public String getMloCode() {
		return mloCode;
	}
	public void setMloCode(String mloCode) {
		this.mloCode = mloCode;
	}
	
	@AuditLoggable(fieldName = "lol_id", displayName = "LOL")
	public Integer getLolId() {
		return lolId;
	}
	public void setLolId(Integer lolId) {
		this.lolId = lolId;
	}
	
	@AuditLoggable(fieldName = "lod_id", displayName = "LOD")
	public Integer getLodId() {
		return lodId;
	}
	public void setLodId(Integer lodId) {
		this.lodId = lodId;
	}
	
	@AuditLoggable(fieldName = "transport_type", displayName = "Transport Type")
	public String getTransportType() {
		return transportType;
	}
	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/*public List<BookingDtl> getBookingDtlList() {
		return bookingDtlList;
	}
	public void setBookingDtlList(List<BookingDtl> bookingDtlList) {
		this.bookingDtlList = bookingDtlList;
	}*/
	public String getLolName() {
		return lolName;
	}
	public void setLolName(String lolName) {
		this.lolName = lolName;
	}
	public String getLodName() {
		return lodName;
	}
	public void setLodName(String lodName) {
		this.lodName = lodName;
	}
	public String getConType() {
		return conType;
	}
	public void setConType(String conType) {
		this.conType = conType;
	}
	public String getMloName() {
		return mloName;
	}
	public void setMloName(String mloName) {
		this.mloName = mloName;
	}
	public String getTripNo() {
		return tripNo;
	}
	public void setTripNo(String tripNo) {
		this.tripNo = tripNo;
	}
	public String getTripStartDate() {
		return tripStartDate;
	}
	public void setTripStartDate(String tripStartDate) {
		this.tripStartDate = tripStartDate;
	}
	public String getEtd() {
		return etd;
	}
	public void setEtd(String etd) {
		this.etd = etd;
	}
	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta = eta;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getContainerNo() {
		return containerNo;
	}
	public void setContainerNo(String containerNo) {
		this.containerNo = containerNo;
	}
	public String getQuotation() {
		return quotation;
	}
	public void setQuotation(String quotation) {
		this.quotation = quotation;
	}
	public String getQuotationNo() {
		return quotationNo;
	}
	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}
	public String getQuoValidFrom() {
		return quoValidFrom;
	}
	public void setQuoValidFrom(String quoValidFrom) {
		this.quoValidFrom = quoValidFrom;
	}
	public String getQuoValidTill() {
		return quoValidTill;
	}
	public void setQuoValidTill(String quoValidTill) {
		this.quoValidTill = quoValidTill;
	}
	public String getMloId() {
		return mloId;
	}
	public void setMloId(String mloId) {
		this.mloId = mloId;
	}
	public String getQuoId() {
		return quoId;
	}
	public void setQuoId(String quoId) {
		this.quoId = quoId;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public String getVat() {
		return vat;
	}
	public void setVat(String vat) {
		this.vat = vat;
	}
	public Integer getMode() {
		return mode;
	}
	public void setMode(Integer mode) {
		this.mode = mode;
	}
	
	public List<printcontainerReleaseOrderBean> getContainerList() {
		return containerList;
	}

	public void setContainerList(List<printcontainerReleaseOrderBean> containerList) {
		this.containerList = containerList;
	}
	


}
