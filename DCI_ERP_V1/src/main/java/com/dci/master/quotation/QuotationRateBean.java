package com.dci.master.quotation;

import java.math.BigInteger;
import java.util.List;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;



@AuditLoggableType(tableName = "quotation_hdr", formCode = "F0051")

public class QuotationRateBean {
	private String freight;
	private String userid;
	private String otCharge;
	private String bookingStatus;
	private String quotationNo;
	private String rejectRemarks;
	private String approveRemarks;
	private String doType;
	private String status1;
	private String user;
	private String location;
	private Integer service;
	private Integer aol;
	private Integer freeDays;
	private String customer;
	private String salesPerson;
	private String dimensionName;
	private Integer dropoffID;
	private Integer vendor;
	private String attention;
	private boolean hazardous;
	private boolean empty;
	private boolean oog;
	private boolean allowOtherPorts;
	private String dropoff;
	private String quotationDate;
	private String validTill;
	private String id;
	private String text;
	private Double tariff;
	private QuotationRateBean bean;
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
	private String special;
	private String cargoType;
	private String term1;
	private Integer qty;
	private Integer rate;
	private Double quotedRate;
	private List<QuotationRateBean> quotationDtl;
	private List<QuotationRateBean> quotationFreeDaysDtl;
	private String chargeCode;
	private String chargeName;
	private String approvedBy;
	private Integer quotationcount;
	private String localCurrency;
	private String customername;
	private String viewotCharge;
	private String viewfreight;
	private Boolean allowOtherPort;
	private String approvedDate;
	private Integer quotationDtlId;
	private String payAt;
	private Integer polFreeDays;
	private Integer podFreeDays;
	private Integer quotationFreeDaysId;
	private Boolean soc;
	private String  quotationcreated;
	private String spl;
	private String cartype;
	private String detentionTariffType;
	private Integer polFreeDays1;
	private Integer podFreeDays1;
	private Double quotedRate1;
	private Double quotedRatemrg;
	private Double quotedRateTariff;
	private String chargeHeads;
	public String getChargeHeads() {
		return chargeHeads;
	}
	public void setChargeHeads(String chargeHeads) {
		this.chargeHeads = chargeHeads;
	}
	public Integer getBuySell() {
		return buySell;
	}
	public void setBuySell(Integer buySell) {
		this.buySell = buySell;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	private Integer buySell;
	private String note;

	private String isVendor;
	private String userPortStr;
	private String rrnumber;
	
	
	
	
	
	public String getRrnumber() {
		return rrnumber;
	}
	public void setRrnumber(String rrnumber) {
		this.rrnumber = rrnumber;
	}
	public String getIsVendor() {
		return isVendor;
	}
	public void setIsVendor(String isVendor) {
		this.isVendor = isVendor;
	}
	public String getUserPortStr() {
		return userPortStr;
	}
	public void setUserPortStr(String userPortStr) {
		this.userPortStr = userPortStr;
	}
	
	
	public Double getQuotedRateTariff() {
		return quotedRateTariff;
	}
	public void setQuotedRateTariff(Double quotedRateTariff) {
		this.quotedRateTariff = quotedRateTariff;
	}
	public Double getQuotedRatemrg() {
		return quotedRatemrg;
	}
	public void setQuotedRatemrg(Double quotedRatemrg) {
		this.quotedRatemrg = quotedRatemrg;
	}
	public Double getQuotedRate1() {
		return quotedRate1;
	}
	public void setQuotedRate1(Double quotedRate1) {
		this.quotedRate1 = quotedRate1;
	}
	public Integer getPolFreeDays1() {
		return polFreeDays1;
	}
	public void setPolFreeDays1(Integer polFreeDays1) {
		this.polFreeDays1 = polFreeDays1;
	}
	public Integer getPodFreeDays1() {
		return podFreeDays1;
	}
	public void setPodFreeDays1(Integer podFreeDays1) {
		this.podFreeDays1 = podFreeDays1;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Boolean getAllowOtherPort() {
		return allowOtherPort;
	}
	public void setAllowOtherPort(Boolean allowOtherPort) {
		this.allowOtherPort = allowOtherPort;
	}
	public Integer getQuotationFreeDaysId() {
		return quotationFreeDaysId;
	}
	public void setQuotationFreeDaysId(Integer quotationFreeDaysId) {
		this.quotationFreeDaysId = quotationFreeDaysId;
	}
	public List<QuotationRateBean> getQuotationFreeDaysDtl() {
		return quotationFreeDaysDtl;
	}
	public void setQuotationFreeDaysDtl(List<QuotationRateBean> quotationFreeDaysDtl) {
		this.quotationFreeDaysDtl = quotationFreeDaysDtl;
	}
 
	public Integer getPolFreeDays() {
		return polFreeDays;
	}
	public void setPolFreeDays(Integer polFreeDays) {
		this.polFreeDays = polFreeDays;
	}
	public Integer getPodFreeDays() {
		return podFreeDays;
	}
	public void setPodFreeDays(Integer podFreeDays) {
		this.podFreeDays = podFreeDays;
	}
	public String getPayAt() {
		return payAt;
	}
	public void setPayAt(String payAt) {
		this.payAt = payAt;
	}
	public Integer getQuotationDtlId() {
		return quotationDtlId;
	}
	public void setQuotationDtlId(Integer quotationDtlId) {
		this.quotationDtlId = quotationDtlId;
	}
	public String getViewfreight() {
		return viewfreight;
	}
	public void setViewfreight(String viewfreight) {
		this.viewfreight = viewfreight;
	}
	public String getViewotCharge() {
		return viewotCharge;
	}
	public void setViewotCharge(String viewotCharge) {
		this.viewotCharge = viewotCharge;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public Integer getQuotationcount() {
		return quotationcount;
	}
	public void setQuotationcount(Integer quotationcount) {
		this.quotationcount = quotationcount;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public String getRejectRemarks() {
		return rejectRemarks;
	}
	public void setRejectRemarks(String rejectRemarks) {
		this.rejectRemarks = rejectRemarks;
	}
	public String getFreight() {
		return freight;
	}
	public void setFreight(String freight) {
		this.freight = freight;
	}
	public String getOtCharge() {
		return otCharge;
	}
	public void setOtCharge(String otCharge) {
		this.otCharge = otCharge;
	}
	private String  otherCharges;
	@AuditLoggable(fieldName = "other_charges", displayName = "otherCharges")
	public String getOtherCharges() {
		return otherCharges;
	}
	public void setOtherCharges(String otherCharges) {
		this.otherCharges = otherCharges;
	}
	private String validFrom;
	private String validTo;
	public String getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	public String getValidTo() {
		return validTo;
	}
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getStatus1() {
		return status1;
	}
	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	private String custcategory;

	public String getCustcategory() {
		return custcategory;
	}
	public void setCustcategory(String custcategory) {
		this.custcategory = custcategory;
	}
	@AuditLoggable(fieldName = "free_days", displayName = "freeDays")
	public Integer getFreeDays() {
		return freeDays;
	}
	public void setFreeDays(Integer freeDays) {
		this.freeDays = freeDays;
	}
	public String getDoType() {
		return doType;
	}
	public void setDoType(String doType) {
		this.doType = doType;
	}
	@AuditLoggable(fieldName = "hazardous", displayName = "hazardous")
	public boolean isHazardous() {
		return hazardous;
	}
	public void setHazardous(boolean hazardous) {
		this.hazardous = hazardous;
	}
	@AuditLoggable(fieldName = "empty", displayName = "empty")
	public boolean isEmpty() {
		return empty;
	}
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
	@AuditLoggable(fieldName = "oog", displayName = "oog")
	public boolean isOog() {
		return oog;
	}
	public void setOog(boolean oog) {
		this.oog = oog;
	}
	
	 
	public Integer getNoOfBox() {
		return noOfBox;
	}
	@AuditLoggable(fieldName = "tariff", displayName = "tariff")
	public Double getTariff() {
		return tariff;
	}
	public void setTariff(Double tariff) {
		this.tariff = tariff;
	}
	public void setNoOfBox(Integer noOfBox) {
		this.noOfBox = noOfBox;
	}
	private Integer noOfBox;
	

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
	@AuditLoggable(fieldName = "agre_party_id", displayName = "customer")
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
	@AuditLoggable(fieldName = "quotation_date", displayName = "quotationDate")
	public String getQuotationDate() {
		return quotationDate;
	}
	public void setQuotationDate(String quotationDate) {
		this.quotationDate = quotationDate;
	}
	@AuditLoggable(fieldName = "valid_till", displayName = "validTill")
	public String getValidTill() {
		return validTill;
	}
	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}
	public QuotationRateBean getBean() {
		return bean;
	}
	public void setBean(QuotationRateBean bean) {
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
	@AuditLoggable(fieldName = "currency_code", displayName = "currencyName")
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
	@AuditLoggable(fieldName = "cust_category", displayName = "customerType")
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
	@AuditLoggable(fieldName = "pod_id", displayName = "Pod")
	public String getPod() {
		return Pod;
	}
	public void setPod(String pod) {
		Pod = pod;
	}
	@AuditLoggable(fieldName = "pol_id", displayName = "pol")
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
	@AuditLoggable(fieldName = "conType", displayName = "container type")
	public String getConType() {
		return conType;
	}
	public void setConType(String conType) {
		this.conType = conType;
	}
	@AuditLoggable(fieldName = "chargeType", displayName = "chargeType")
	public String getChargeType() {
		return chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	@AuditLoggable(fieldName = "commodity", displayName = "commodity")
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
	@AuditLoggable(fieldName = "quotation_no", displayName = "quotationNo")
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
	@AuditLoggable(fieldName = "address", displayName = "address")
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
	@AuditLoggable(fieldName = "status", displayName = "status")
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
 
	public Double getQuotedRate() {
		return quotedRate;
	}
	public void setQuotedRate(Double quotedRate) {
		this.quotedRate = quotedRate;
	}
	public List<QuotationRateBean> getQuotationDtl() {
		return quotationDtl;
	}
	public void setQuotationDtl(List<QuotationRateBean> quotationDtl) {
		this.quotationDtl = quotationDtl;
	}
	
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public String getChargeCode() {
		return chargeCode;
	}
	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}
	public String getChargeName() {
		return chargeName;
	}
	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}
	public String getApproveRemarks() {
		return approveRemarks;
	}
	public void setApproveRemarks(String approveRemarks) {
		this.approveRemarks = approveRemarks;
	}
	public String getLocalCurrency() {
		return localCurrency;
	}
	public void setLocalCurrency(String localCurrency) {
		this.localCurrency = localCurrency;
	}
	public String getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}
	public Boolean getSoc() {
		return soc;
	}
	public void setSoc(Boolean soc) {
		this.soc = soc;
	}
	public boolean isAllowOtherPorts() {
		return allowOtherPorts;
	}
	public void setAllowOtherPorts(boolean allowOtherPorts) {
		this.allowOtherPorts = allowOtherPorts;
	}
	public String getQuotationcreated() {
		return quotationcreated;
	}
	public void setQuotationcreated(String quotationcreated) {
		this.quotationcreated = quotationcreated;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public String getCargoType() {
		return cargoType;
	}
	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}
	public String getSpl() {
		return spl;
	}
	public void setSpl(String spl) {
		this.spl = spl;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getDetentionTariffType() {
		return detentionTariffType;
	}
	public void setDetentionTariffType(String detentionTariffType) {
		this.detentionTariffType = detentionTariffType;
	}
	
	}
