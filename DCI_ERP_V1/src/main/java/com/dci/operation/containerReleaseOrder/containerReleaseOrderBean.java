package com.dci.operation.containerReleaseOrder;



import java.math.BigInteger;
import java.util.List;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;




@AuditLoggableType(tableName = "container_release_hdr", formCode = "F0104")

public class containerReleaseOrderBean {
	
	//HDR
	
	private String containerreleaseCode;

	private String containerNo;
	private String  crovalidDate;
	public String getCrovalidDate() {
		return crovalidDate;
	}
	public void setCrovalidDate(String crovalidDate) {
		this.crovalidDate = crovalidDate;
	}
	private String releaseDate;
	private String  gateOutNo;
	private String gateInNo;
	private String gateOutStatus;
	private String gateInStatus;
	private String  container_release_hdr_code;
	private String  booking_no;
	private String  agent;
	private String  vesselname;
	private String voyage;

	private String  vendor_name_head;
	private String  vendor_name;
	private String  vendor_address;
	private String  vendor_address1;
	private String  vendor_off_tel_num;
	private String vendor_telex_num;
	private String  depot_agent_name;
	private String  depot_address;
	private String  depot_phone_number;
	private String  depot_fax_number;
	private String  containersummary;
	private String  eta;
	private String  cutoff_dt;
	private String  presentDate;


	
	
	public String getPresentDate() {
		return presentDate;
	}
	public void setPresentDate(String presentDate) {
		this.presentDate = presentDate;
	}
	public String getContainer_release_hdr_code() {
		return container_release_hdr_code;
	}
	public void setContainer_release_hdr_code(String container_release_hdr_code) {
		this.container_release_hdr_code = container_release_hdr_code;
	}
	public String getBooking_no() {
		return booking_no;
	}
	public void setBooking_no(String booking_no) {
		this.booking_no = booking_no;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getVesselname() {
		return vesselname;
	}
	public void setVesselname(String vesselname) {
		this.vesselname = vesselname;
	}
	public String getVoyage() {
		return voyage;
	}
	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}
	public String getVendor_name_head() {
		return vendor_name_head;
	}
	public void setVendor_name_head(String vendor_name_head) {
		this.vendor_name_head = vendor_name_head;
	}
	public String getVendor_name() {
		return vendor_name;
	}
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	public String getVendor_address() {
		return vendor_address;
	}
	public void setVendor_address(String vendor_address) {
		this.vendor_address = vendor_address;
	}
	public String getVendor_address1() {
		return vendor_address1;
	}
	public void setVendor_address1(String vendor_address1) {
		this.vendor_address1 = vendor_address1;
	}
	public String getVendor_off_tel_num() {
		return vendor_off_tel_num;
	}
	public void setVendor_off_tel_num(String vendor_off_tel_num) {
		this.vendor_off_tel_num = vendor_off_tel_num;
	}
	public String getVendor_telex_num() {
		return vendor_telex_num;
	}
	public void setVendor_telex_num(String vendor_telex_num) {
		this.vendor_telex_num = vendor_telex_num;
	}
	public String getDepot_agent_name() {
		return depot_agent_name;
	}
	public void setDepot_agent_name(String depot_agent_name) {
		this.depot_agent_name = depot_agent_name;
	}
	public String getDepot_address() {
		return depot_address;
	}
	public void setDepot_address(String depot_address) {
		this.depot_address = depot_address;
	}
	public String getDepot_phone_number() {
		return depot_phone_number;
	}
	public void setDepot_phone_number(String depot_phone_number) {
		this.depot_phone_number = depot_phone_number;
	}
	public String getDepot_fax_number() {
		return depot_fax_number;
	}
	public void setDepot_fax_number(String depot_fax_number) {
		this.depot_fax_number = depot_fax_number;
	}
	public String getContainersummary() {
		return containersummary;
	}
	public void setContainersummary(String containersummary) {
		this.containersummary = containersummary;
	}
	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta = eta;
	}
	public String getCutoff_dt() {
		return cutoff_dt;
	}
	public void setCutoff_dt(String cutoff_dt) {
		this.cutoff_dt = cutoff_dt;
	}
	@AuditLoggable(fieldName = "gateOutNo", displayName = "Gate Out No")
	public String getGateOutNo() {
		return gateOutNo;
	}
	public void setGateOutNo(String gateOutNo) {
		this.gateOutNo = gateOutNo;
	}
	@AuditLoggable(fieldName = "gateInNo", displayName = "Gate In No")
	public String getGateInNo() {
		return gateInNo;
	}
	public void setGateInNo(String gateInNo) {
		this.gateInNo = gateInNo;
	}
	@AuditLoggable(fieldName = "gateOutStatus", displayName = "Gate Out Status")
	public String getGateOutStatus() {
		return gateOutStatus;
	}
	public void setGateOutStatus(String gateOutStatus) {
		this.gateOutStatus = gateOutStatus;
	}
	@AuditLoggable(fieldName = "gateInStatus", displayName = "Gate In Status")
	public String getGateInStatus() {
		return gateInStatus;
	}
	public void setGateInStatus(String gateInStatus) {
		this.gateInStatus = gateInStatus;
	}
	@AuditLoggable(fieldName = "sealFrom", displayName = "Seal From")
	public String getSealFrom() {
		return sealFrom;
	}
	public void setSealFrom(String sealFrom) {
		this.sealFrom = sealFrom;
	}
	@AuditLoggable(fieldName = "sealTo", displayName = "Seal To")
	public String getSealTo() {
		return sealTo;
	}
	public void setSealTo(String sealTo) {
		this.sealTo = sealTo;
	}
	@AuditLoggable(fieldName = "count", displayName = "count")
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	private String sealFrom;
	
	private String sealTo;
	
	private Integer count;
	@AuditLoggable(fieldName = "releaseDate", displayName = "Release Date")
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	private String croDate;
	@AuditLoggable(fieldName = "isempty", displayName = "Is Empty")
	public boolean isIsempty() {
		return isempty;
	}
	public void setIsempty(boolean isempty) {
		this.isempty = isempty;
	}
	private String containerRelID;
	
	private boolean isempty; 
	@AuditLoggable(fieldName = "containerRelID", displayName = "Container RelID")
	public String getContainerRelID() {
		return containerRelID;
	}
	public void setContainerRelID(String containerRelID) {
		this.containerRelID = containerRelID;
	}
	private String sealNo;
	
	private String returnDepot;
	@AuditLoggable(fieldName = "returnDepot", displayName = "Return Depot")
	public String getReturnDepot() {
		return returnDepot;
	}
	public void setReturnDepot(String returnDepot) {
		this.returnDepot = returnDepot;
	}
	@AuditLoggable(fieldName = "croDate", displayName = "CRO Date")
	public String getCroDate() {
		return croDate;
	}
	public void setCroDate(String croDate) {
		this.croDate = croDate;
	}
	@AuditLoggable(fieldName = "containerNo", displayName = "Container No")
	public String getContainerNo() {
		return containerNo;
	}
	public void setContainerNo(String containerNo) {
		this.containerNo = containerNo;
	}
	@AuditLoggable(fieldName = "sealNo", displayName = "seal No")
	public String getSealNo() {
		return sealNo;
	}
	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
	}
	public String getOutBoundMode() {
		return outBoundMode;
	}
	public void setOutBoundMode(String outBoundMode) {
		this.outBoundMode = outBoundMode;
	}
	@AuditLoggable(fieldName = "returnDate", displayName = "Return Date")
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getEmptyReturn() {
		return emptyReturn;
	}
	public void setEmptyReturn(String emptyReturn) {
		this.emptyReturn = emptyReturn;
	}
	public String getInBoundMode() {
		return inBoundMode;
	}
	public void setInBoundMode(String inBoundMode) {
		this.inBoundMode = inBoundMode;
	}
	private String outBoundMode;
	
	private String returnDate;
	
	private String emptyReturn;
	
	private String inBoundMode;
	
	
	
	public String getContainerreleaseCode() {
		return containerreleaseCode;
	}
	public void setContainerreleaseCode(String containerreleaseCode) {
		this.containerreleaseCode = containerreleaseCode;
	}

	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public String getPortCode() {
		return portCode;
	}
	public void setPortCode(String portCode) {
		this.portCode = portCode;
	}
	public String getPortName() {
		return portName;
	}
	public void setPortName(String portName) {
		this.portName = portName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getViewValue() {
		return viewValue;
	}
	public void setViewValue(String viewValue) {
		this.viewValue = viewValue;
	}
	@AuditLoggable(fieldName = "bookingCode", displayName = "Booking Code")
	public String getBookingCode() {
		return bookingCode;
	}
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}
	@AuditLoggable(fieldName = "containertype", displayName = "Container Type")
	public String getContainertype() {
		return containertype;
	}
	public void setContainertype(String containertype) {
		this.containertype = containertype;
	}
	@AuditLoggable(fieldName = "depot", displayName = "Depot")
	public String getDepot() {
		return depot;
	}
	public void setDepot(String depot) {
		this.depot = depot;
	}
	@AuditLoggable(fieldName = "quantity", displayName = "Quantity")
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getAllocDate() {
		return allocDate;
	}
	public void setAllocDate(String allocDate) {
		this.allocDate = allocDate;
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
	private String bookingNo;

	public String getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}
	private String pod;
	private String instruction;
	private String portCode;
	private String portName;
	public String value;
	public String viewValue;
	public String bookingCode;
 
	//DTL
	

	private String containertype;
	private String depot;
	private String quantity;
	public String allocDate;
	
	
	 public Boolean isSuccess;
		public String message;
	private Integer service;
	private Integer aol;
	private String customer;
	private String salesPerson;
	private String dimensionName;
	private Integer dropoffID;
	private Integer vendor;
	private String attention;
	
	private String dropoff;
	private String quotationDate;
	private String validTill;
	private String id;
	private String text;
	
	private List<containerReleaseOrderBean> lQuotationBean;
	private List<containerReleaseOrderBean> sealdtl;

	public List<containerReleaseOrderBean> getlQuotationBean() {
		return lQuotationBean;
	}
	public void setlQuotationBean(List<containerReleaseOrderBean> lQuotationBean) {
		this.lQuotationBean = lQuotationBean;
	}
	public List<containerReleaseOrderBean> getSealdtl() {
		return sealdtl;
	}
	public void setSealdtl(List<containerReleaseOrderBean> sealdtl) {
		this.sealdtl = sealdtl;
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
	public String getDropoff() {
		return dropoff;
	}
	public void setDropoff(String dropoff) {
		this.dropoff = dropoff;
	}
	public Integer getService() {
		return service;
	}
	public void setService(Integer service) {
		this.service = service;
	}
	public Integer getAol() {
		return aol;
	}
	public void setAol(Integer aol) {
		this.aol = aol;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getSalesPerson() {
		return salesPerson;
	}
	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}
	public String getDimensionName() {
		return dimensionName;
	}
	public void setDimensionName(String dimensionName) {
		this.dimensionName = dimensionName;
	}
	public Integer getDropoffID() {
		return dropoffID;
	}
	public void setDropoffID(Integer dropoffID) {
		this.dropoffID = dropoffID;
	}
	public Integer getVendor() {
		return vendor;
	}
	public void setVendor(Integer vendor) {
		this.vendor = vendor;
	}
	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	public String getQuotationDate() {
		return quotationDate;
	}
	public void setQuotationDate(String quotationDate) {
		this.quotationDate = quotationDate;
	}
	public String getValidTill() {
		return validTill;
	}
	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}
	public containerReleaseOrderBean getBean() {
		return bean;
	}
	public void setBean(containerReleaseOrderBean bean) {
		this.bean = bean;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChargeHeads1() {
		return chargeHeads1;
	}
	public void setChargeHeads1(String chargeHeads1) {
		this.chargeHeads1 = chargeHeads1;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getPartyBin() {
		return partyBin;
	}
	public void setPartyBin(String partyBin) {
		this.partyBin = partyBin;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getCustomer1() {
		return customer1;
	}
	public void setCustomer1(String customer1) {
		this.customer1 = customer1;
	}
	public String getNominatedBy1() {
		return nominatedBy1;
	}
	public void setNominatedBy1(String nominatedBy1) {
		this.nominatedBy1 = nominatedBy1;
	}
	public String getShipper1() {
		return shipper1;
	}
	public void setShipper1(String shipper1) {
		this.shipper1 = shipper1;
	}
	public String getPolicdName() {
		return policdName;
	}
	public void setPolicdName(String policdName) {
		this.policdName = policdName;
	}
	public String getPod() {
		return Pod;
	}
	public void setPod(String pod) {
		Pod = pod;
	}
	public String getPol() {
		return pol;
	}
	public void setPol(String pol) {
		this.pol = pol;
	}
	public String getOrginName() {
		return orginName;
	}
	public void setOrginName(String orginName) {
		this.orginName = orginName;
	}
	public String getDestination1() {
		return destination1;
	}
	public void setDestination1(String destination1) {
		this.destination1 = destination1;
	}
	public String getSalesPerson1() {
		return salesPerson1;
	}
	public void setSalesPerson1(String salesPerson1) {
		this.salesPerson1 = salesPerson1;
	}
	public String getSalesType1() {
		return salesType1;
	}
	public void setSalesType1(String salesType1) {
		this.salesType1 = salesType1;
	}
	public String getAod1() {
		return aod1;
	}
	public void setAod1(String aod1) {
		this.aod1 = aod1;
	}
	public Integer getUnit() {
		return unit;
	}
	public void setUnit(Integer unit) {
		this.unit = unit;
	}
	public Integer getShipper() {
		return shipper;
	}
	public void setShipper(Integer shipper) {
		this.shipper = shipper;
	}
	public Integer getBranch() {
		return branch;
	}
	public void setBranch(Integer branch) {
		this.branch = branch;
	}
	public Integer getAod() {
		return aod;
	}
	public void setAod(Integer aod) {
		this.aod = aod;
	}
	public Integer getDestination() {
		return destination;
	}
	public void setDestination(Integer destination) {
		this.destination = destination;
	}
	public Integer getSalesType() {
		return salesType;
	}
	public void setSalesType(Integer salesType) {
		this.salesType = salesType;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getTermConditions() {
		return termConditions;
	}
	public void setTermConditions(String termConditions) {
		this.termConditions = termConditions;
	}
	public Integer getMode() {
		return mode;
	}
	public void setMode(Integer mode) {
		this.mode = mode;
	}
	public Integer getCurrency() {
		return currency;
	}
	public void setCurrency(Integer currency) {
		this.currency = currency;
	}
	public Integer getTerm() {
		return term;
	}
	public void setTerm(Integer term) {
		this.term = term;
	}
	public String getTermName() {
		return termName;
	}
	public void setTermName(String termName) {
		this.termName = termName;
	}
	public String getConType() {
		return conType;
	}
	public void setConType(String conType) {
		this.conType = conType;
	}
	public String getChargeType() {
		return chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	public String getCommodity() {
		return commodity;
	}
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	public Integer getConsignee() {
		return consignee;
	}
	public void setConsignee(Integer consignee) {
		this.consignee = consignee;
	}
	public Integer getNominatedBy() {
		return nominatedBy;
	}
	public void setNominatedBy(Integer nominatedBy) {
		this.nominatedBy = nominatedBy;
	}
	public String getValidityDate() {
		return validityDate;
	}
	public void setValidityDate(String validityDate) {
		this.validityDate = validityDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public BigInteger getQuotationId() {
		return quotationId;
	}
	public void setQuotationId(BigInteger quotationId) {
		this.quotationId = quotationId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAolName() {
		return aolName;
	}
	public void setAolName(String aolName) {
		this.aolName = aolName;
	}
	public String getAodName() {
		return aodName;
	}
	public void setAodName(String aodName) {
		this.aodName = aodName;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public String getQuotationNo() {
		return quotationNo;
	}
	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}
	public String getVessel() {
		return vessel;
	}
	public void setVessel(String vessel) {
		this.vessel = vessel;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getCustAddress1() {
		return custAddress1;
	}
	public void setCustAddress1(String custAddress1) {
		this.custAddress1 = custAddress1;
	}
	public String getCustAddress2() {
		return custAddress2;
	}
	public void setCustAddress2(String custAddress2) {
		this.custAddress2 = custAddress2;
	}
	public String getCustAddress3() {
		return custAddress3;
	}
	public void setCustAddress3(String custAddress3) {
		this.custAddress3 = custAddress3;
	}
	public String getCustAddress4() {
		return custAddress4;
	}
	public void setCustAddress4(String custAddress4) {
		this.custAddress4 = custAddress4;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getGstnNo() {
		return gstnNo;
	}
	public void setGstnNo(String gstnNo) {
		this.gstnNo = gstnNo;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getShipmentTerm() {
		return shipmentTerm;
	}
	public void setShipmentTerm(String shipmentTerm) {
		this.shipmentTerm = shipmentTerm;
	}
	public String getTerm1() {
		return term1;
	}
	public void setTerm1(String term1) {
		this.term1 = term1;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public double getQuotedRate() {
		return quotedRate;
	}
	public void setQuotedRate(double quotedRate) {
		this.quotedRate = quotedRate;
	}
	public List<containerReleaseOrderBean> getQuotationDtl() {
		return quotationDtl;
	}
	public void setQuotationDtl(List<containerReleaseOrderBean> quotationDtl) {
		this.quotationDtl = quotationDtl;
	}
	
	private String conNumber;
	private containerReleaseOrderBean bean;
	private String name;
	private String chargeHeads1;
	private String unitName;
	private String currencyName;
	private String paymentMethod;
	private String transactionType;
	private String partyBin;
	private String customerType;
	private String branchName;
	private String customer1;
	private String nominatedBy1;
	private String shipper1;
	private String policdName;
    private String Pod;
    private String pol;
    private String orginName;
    private String destination1;
    private String salesPerson1;
    private String salesType1;
    private String aod1;
    private Integer unit;

	
	private Integer shipper;	
	private Integer branch;	
	private Integer aod;	
	private Integer destination;	
	private Integer salesType;	
	private String carrier;
	private String termConditions;	
	private Integer mode;	
	private Integer currency;	
	private Integer term;	
	private String termName;
	private String conType;
	private String chargeType;
	private String commodity;	
	private Integer consignee;	
	private Integer nominatedBy;	
	private String validityDate;	
	private String remarks;
	private BigInteger quotationId;
	private String custName;
	private String aolName;
	private String aodName;
	private String origin;
	private String createdOn;
	private String modifiedOn;
	private String createdBy;
	private String modifiedBy;
	private String destinationName;
	private String  quotationNo;
	private String  vessel;
	private String  serviceType;
	private String  address;
	private String  address2;
	private String  address3;
	private String custAddress1;
	private String custAddress2;
	private String custAddress3;
	private String custAddress4;
	private String commodityName;
	private String fileName;
	private String gstnNo;
	private String Status;
	private String shipmentTerm;
	private String term1;
	private Integer qty;
	private Integer rate;
	private double quotedRate;
	private List<containerReleaseOrderBean> quotationDtl;
	private List<containerReleaseOrderBean> sealDtl;
	public List<containerReleaseOrderBean> getSealDtl() {
		return sealDtl;
	}
	public void setSealDtl(List<containerReleaseOrderBean> sealDtl) {
		this.sealDtl = sealDtl;
	}
	public List<containerReleaseOrderBean> getQuotationinnerDtl() {
		return quotationinnerDtl;
	}
	public void setQuotationinnerDtl(List<containerReleaseOrderBean> quotationinnerDtl) {
		this.quotationinnerDtl = quotationinnerDtl;
	}
	private List<containerReleaseOrderBean> quotationinnerDtl;

	public String getConNumber() {
		return conNumber;
	}
	public void setConNumber(String conNumber) {
		this.conNumber = conNumber;
	}
	public void setSuccess(Boolean isSuccess2) {
		// TODO Auto-generated method stub
		
	}
	
	
	}

