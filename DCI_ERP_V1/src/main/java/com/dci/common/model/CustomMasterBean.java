package com.dci.common.model;

import java.util.List;

import com.dci.tenant.auditlog.AuditLoggable;


public class CustomMasterBean {
	

	private String custname;
	
	
	private String customCommId;
	private String customId;
	private Integer customCommunicate;
	private Integer customBound;
	private String subject;
	private String message;
	private String meetCallDate;
	private String referral;
	private String nextFollowUpDate;
	private String assignedTo;
	private String assignedName;
	private String isLead;
	private String personmet;
	
	private String polCode;
	private String podCode;
	private String payerCode;
	private boolean checked;
	
	private String customerName;
	private String address;
	private String area;
	private String countryName;
	private String faxNo;
	private String email;
	private String currency;
	private String empName;
	private String bookingCntctPrsn;
	private String pricingCntctPrsn;
	private String operationsCntctPrsn;
	private String financeCntctPrsn;
	private String teleNumber;
	private boolean shipper;
	private boolean consignee;
	private boolean notifyParty;
	private boolean agreementParty;
	private boolean jVPartner;
	private String paymentCenter;
	private String active;
	private String slotOperator;
	private String subSlot;
	private String emailBooking;
	private String emailPricing;
	private String emailOperations;
	private String emailFinance;
	private String blRelated;
	private String city;
	private String attachFileGroup;
	private String isVesselGrp;
	private String customerShortName;
	private String address1;
	private String typeofCustomer;
	private String telOfficeNum;
	private String telexNum;
	private Double crLimit;
	private String exchangeRate;
	private String bookingCntctPrsnEmail;
	private String pricingCntctPrsnEmail;
	private String operationsCntctPrsnEmail;
	private String financeCntctPrsnEmail;
	private String faxNum;
	private String customer_category;
	private String creditCustType;
	private String typeOfCustGrp;
	private String companyTypeGrp;
	private String controllingAgent;
	private List<CustomerDtlBean> customerVoyageList;
	private List<CustomMasterBean> customerVoyageList1;
	private String shareOfRVC;
	private String slotSwap;
	private String costRevenueSpaceShare;
	private String deadFreight;
	private Double depositAmt;
	private String categoryWise;
	private String customerCode;
	private String customerType;
	private String createdBy;
	private String createdDate;
	private String modifiedBy;
	private String modifiedDate;
	private String creditBlkStatus;
	private String creditBlockHidden;
	private String creditMloTypeHidden;
	private boolean edit;
	private String companyId;
	private double outstandingLocal;
	private double outstandingUSD;
	private String paymentCountryName;
	private String customerTeus;
	private String customerTeusRank;
	private String customerAmount;
	private String customerRank;
	private String customerOutRank;
	private String customerOutAmount;
	private String creditGroupName;
	private String creditLimitAmt;
	private String creditLimitDays;
	private String creditRating;
	private String prevYear;
	private int leadId;
	private String financeAttn;
	private String invoiceEmailId;
	private boolean leadStatus;
	private String relatedParty;
	private String pol;
	private String pod;
	private String isCharter;
	private String acctHead;
	private String vatNo;
	
	
	
	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getCustomCommId() {
		return customCommId;
	}

	public void setCustomCommId(String customCommId) {
		this.customCommId = customCommId;
	}

	public String getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	public Integer getCustomCommunicate() {
		return customCommunicate;
	}

	public void setCustomCommunicate(Integer customCommunicate) {
		this.customCommunicate = customCommunicate;
	}

	public Integer getCustomBound() {
		return customBound;
	}

	public void setCustomBound(Integer customBound) {
		this.customBound = customBound;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMeetCallDate() {
		return meetCallDate;
	}

	public void setMeetCallDate(String meetCallDate) {
		this.meetCallDate = meetCallDate;
	}

	public String getReferral() {
		return referral;
	}

	public void setReferral(String referral) {
		this.referral = referral;
	}

	public String getNextFollowUpDate() {
		return nextFollowUpDate;
	}

	public void setNextFollowUpDate(String nextFollowUpDate) {
		this.nextFollowUpDate = nextFollowUpDate;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getAssignedName() {
		return assignedName;
	}

	public void setAssignedName(String assignedName) {
		this.assignedName = assignedName;
	}

	public String getIsLead() {
		return isLead;
	}

	public void setIsLead(String isLead) {
		this.isLead = isLead;
	}

	public String getPersonmet() {
		return personmet;
	}

	public void setPersonmet(String personmet) {
		this.personmet = personmet;
	}

	public String getPolCode() {
		return polCode;
	}

	public void setPolCode(String polCode) {
		this.polCode = polCode;
	}

	public String getPodCode() {
		return podCode;
	}

	public void setPodCode(String podCode) {
		this.podCode = podCode;
	}

	public String getPayerCode() {
		return payerCode;
	}

	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getIsCharter() {
		return isCharter;
	}

	public void setIsCharter(String isCharter) {
		this.isCharter = isCharter;
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


	private List<CustomMasterBean> customerMasterCommDetails;
	
	private List<CustomMasterBean> mobileCustCommDetail;
	

	@AuditLoggable(fieldName = "FINANCE_ATTN", displayName = "Finance Attn")
	public String getFinanceAttn() {
		return financeAttn;
	}

	public void setFinanceAttn(String financeAttn) {
		this.financeAttn = financeAttn;
	}


	public void setCreditBlockHidden(String creditBlockHidden) {
		this.creditBlockHidden = creditBlockHidden;
	}


	@AuditLoggable(fieldName = "CREDIT_BLOCK_STATUS", displayName = "Credit Block")
	public String getCreditBlockHidden() {
		return creditBlockHidden;
	}

	@AuditLoggable(fieldName = "EMAIL_BOOKING", displayName = "Email Booking")
	public String getEmailBooking() {
		return emailBooking;
	}

	public void setEmailBooking(String emailBooking) {
		this.emailBooking = emailBooking;
	}

	@AuditLoggable(fieldName = "EMAIL_PRICING_SALES", displayName = "Email Pricing Status")
	public String getEmailPricing() {
		return emailPricing;
	}

	public void setEmailPricing(String emailPricing) {
		this.emailPricing = emailPricing;
	}

	@AuditLoggable(fieldName = "EMAIL_OPERATIONS", displayName = "Email Operations")
	public String getEmailOperations() {
		return emailOperations;
	}

	public void setEmailOperations(String emailOperations) {
		this.emailOperations = emailOperations;
	}

	@AuditLoggable(fieldName = "EMAIL_FINANCE", displayName = "Email Fiance")
	public String getEmailFinance() {
		return emailFinance;
	}

	public void setEmailFinance(String emailFinance) {
		this.emailFinance = emailFinance;
	}

	@AuditLoggable(fieldName = "MLO_JV_TYPE_SHARE_RVC", displayName = "Share Of RVC")
	public String getShareOfRVC() {
		return shareOfRVC;
	}

	public void setShareOfRVC(String shareOfRVC) {
		this.shareOfRVC = shareOfRVC;
	}

	@AuditLoggable(fieldName = "CURRENCY_CODE", displayName = "Currency Code")
	public String getSlotSwap() {
		return slotSwap;
	}

	public void setSlotSwap(String slotSwap) {
		this.slotSwap = slotSwap;
	}

	@AuditLoggable(fieldName = "MLO_JV_TYPE_SLOT_SWAP", displayName = "Slot Swap")
	public String getCostRevenueSpaceShare() {
		return costRevenueSpaceShare;
	}

	public void setCostRevenueSpaceShare(String costRevenueSpaceShare) {
		this.costRevenueSpaceShare = costRevenueSpaceShare;
	}

	@AuditLoggable(fieldName = "MLO_JV_TYPE_DEAD_FREIGHT", displayName = "Dead Freight")
	public String getDeadFreight() {
		return deadFreight;
	}

	public void setDeadFreight(String deadFreight) {
		this.deadFreight = deadFreight;
	}

	@AuditLoggable(fieldName = "MLO_NAME", displayName = "MLO Name")
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@AuditLoggable(fieldName = "MLO_ADDRESS", displayName = "Mlo Address  Code")

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@AuditLoggable(fieldName = "MLO_AREA", displayName = "Area Code")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}


	@AuditLoggable(fieldName = "MLO_COUNTRY_ID", displayName = "Country")
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	@AuditLoggable(fieldName = "MLO_FAX_NUM", displayName = "Fax Number")
	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	@AuditLoggable(fieldName = "MLO_EMAIL", displayName = "Mlo Email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@AuditLoggable(fieldName = "MLO_CURR_CODE", displayName = "Currency ")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@AuditLoggable(fieldName = "MLO_BOOKING_CONTACT_PERSON", displayName = "Booking Contact Person")
	public String getBookingCntctPrsn() {
		return bookingCntctPrsn;
	}

	public void setBookingCntctPrsn(String bookingCntctPrsn) {
		this.bookingCntctPrsn = bookingCntctPrsn;
	}

	@AuditLoggable(fieldName = "MLO_PRICING_CONTACT_PERSON", displayName = "Pricing Contact Person")
	public String getPricingCntctPrsn() {
		return pricingCntctPrsn;
	}

	public void setPricingCntctPrsn(String pricingCntctPrsn) {
		this.pricingCntctPrsn = pricingCntctPrsn;
	}

	@AuditLoggable(fieldName = "MLO_OPERATION_CONTACT_PERSON", displayName = "Operations Conatct Person")
	public String getOperationsCntctPrsn() {
		return operationsCntctPrsn;
	}

	public void setOperationsCntctPrsn(String operationsCntctPrsn) {
		this.operationsCntctPrsn = operationsCntctPrsn;
	}

	@AuditLoggable(fieldName = "MLO_FINANCE_CONTACT_PERSON", displayName = "Finance Comtact Person")
	public String getFinanceCntctPrsn() {
		return financeCntctPrsn;
	}

	public void setFinanceCntctPrsn(String financeCntctPrsn) {
		this.financeCntctPrsn = financeCntctPrsn;
	}

	@AuditLoggable(fieldName = "MLO_CONTACT_TEL_NUM", displayName = "Telephone Number")
	public String getTeleNumber() {
		return teleNumber;
	}

	public void setTeleNumber(String teleNumber) {
		this.teleNumber = teleNumber;
	}

	public boolean isShipper() {
		return shipper;
	}

	public void setShipper(boolean shipper) {
		this.shipper = shipper;
	}

	public boolean isConsignee() {
		return consignee;
	}

	public void setConsignee(boolean consignee) {
		this.consignee = consignee;
	}

	public boolean isNotifyParty() {
		return notifyParty;
	}

	public void setNotifyParty(boolean notifyParty) {
		this.notifyParty = notifyParty;
	}

	public boolean isAgreementParty() {
		return agreementParty;
	}

	public void setAgreementParty(boolean agreementParty) {
		this.agreementParty = agreementParty;
	}

	public boolean isjVPartner() {
		return jVPartner;
	}

	public void setjVPartner(boolean jVPartner) {
		this.jVPartner = jVPartner;
	}

	@AuditLoggable(fieldName = "PAYMENT_CENTER_COUNTRY", displayName = "Payment Center")
	public String getPaymentCenter() {
		return paymentCenter;
	}

	public void setPaymentCenter(String paymentCenter) {
		this.paymentCenter = paymentCenter;
	}

	@AuditLoggable(fieldName = "MLO_CITY", displayName = "Mlo City")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@AuditLoggable(fieldName = "ATTACH_FILE_FORMAT", displayName = "Attached File")
	public String getAttachFileGroup() {
		return attachFileGroup;
	}

	public void setAttachFileGroup(String attachFileGroup) {
		this.attachFileGroup = attachFileGroup;
	}
	
	public String getIsVesselGrp() {
		return isVesselGrp;
	}

	public void setIsVesselGrp(String isVesselGrp) {
		this.isVesselGrp = isVesselGrp;
	}

	@AuditLoggable(fieldName = "MLO_SHORT_NAME", displayName = "Mlo Short Name")
	public String getCustomerShortName() {
		return customerShortName;
	}

	public void setCustomerShortName(String customerShortName) {
		this.customerShortName = customerShortName;
	}

	@AuditLoggable(fieldName = "MLO_ADDRESS1", displayName = "Customer Address1")
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	@AuditLoggable(fieldName = "MLO_TYPE", displayName = "Customer Type")
	public String getTypeofCustomer() {
		return typeofCustomer;
	}

	public void setTypeofCustomer(String typeofCustomer) {
		this.typeofCustomer = typeofCustomer;
	}

	@AuditLoggable(fieldName = "MLO_OFF_TEL_NUM", displayName = "Telephone number")
	public String getTelOfficeNum() {
		return telOfficeNum;
	}

	public void setTelOfficeNum(String telOfficeNum) {
		this.telOfficeNum = telOfficeNum;
	}

	@AuditLoggable(fieldName = "MLO_TELEX_NUM", displayName = "Mlo Telex Number")
	public String getTelexNum() {
		return telexNum;
	}

	public void setTelexNum(String telexNum) {
		this.telexNum = telexNum;
	}

	public Double getCrLimit() {
		return crLimit;
	}

	public void setCrLimit(Double crLimit) {
		this.crLimit = crLimit;
	}

	@AuditLoggable(fieldName = "MLO_EXG_RATE", displayName = "Exchange Rate")
	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	@AuditLoggable(fieldName = "MLO_BOOKING_CONTACT_PERSON", displayName = "Booking Contact Person Email")
	public String getBookingCntctPrsnEmail() {
		return bookingCntctPrsnEmail;
	}

	public void setBookingCntctPrsnEmail(String bookingCntctPrsnEmail) {
		this.bookingCntctPrsnEmail = bookingCntctPrsnEmail;
	}

	@AuditLoggable(fieldName = "CURRENCY_CODE", displayName = "Currency Code")
	public String getPricingCntctPrsnEmail() {
		return pricingCntctPrsnEmail;
	}

	public void setPricingCntctPrsnEmail(String pricingCntctPrsnEmail) {
		this.pricingCntctPrsnEmail = pricingCntctPrsnEmail;
	}

	@AuditLoggable(fieldName = "CURRENCY_CODE", displayName = "Currency Code")
	public String getOperationsCntctPrsnEmail() {
		return operationsCntctPrsnEmail;
	}

	public void setOperationsCntctPrsnEmail(String operationsCntctPrsnEmail) {
		this.operationsCntctPrsnEmail = operationsCntctPrsnEmail;
	}

	public String getFaxNum() {
		return faxNum;
	}

	public void setFaxNum(String faxNum) {
		this.faxNum = faxNum;
	}

	@AuditLoggable(fieldName = "CATEGORY", displayName = "Category")

	public String getCustomer_category() {
		return customer_category;
	}

	public void setCustomer_category(String customer_category) {
		this.customer_category = customer_category;
	}

	@AuditLoggable(fieldName = "getTypeOfCustGrp", displayName = "Type of a Cust")
	public String getTypeOfCustGrp() {
		return typeOfCustGrp;
	}

	public void setTypeOfCustGrp(String typeOfCustGrp) {
		this.typeOfCustGrp = typeOfCustGrp;
	}

	@AuditLoggable(fieldName = "COMPANY_TYPE", displayName = "Company Type")
	public String getCompanyTypeGrp() {
		return companyTypeGrp;
	}

	public void setCompanyTypeGrp(String companyTypeGrp) {
		this.companyTypeGrp = companyTypeGrp;
	}

	@AuditLoggable(fieldName = "CONTROLLING_AGENT", displayName = "Controlling Agent")
	public String getControllingAgent() {
		return controllingAgent;
	}

	public void setControllingAgent(String controllingAgent) {
		this.controllingAgent = controllingAgent;
	}

	@AuditLoggable(fieldName = "CATEGORY", displayName = "Category")
	public String getCategoryWise() {
		return categoryWise;
	}

	public void setCategoryWise(String categoryWise) {
		this.categoryWise = categoryWise;
	}

	@AuditLoggable(fieldName = "MLO_FINANCE_EMAIL", displayName = "Finance Email")
	public String getFinanceCntctPrsnEmail() {
		return financeCntctPrsnEmail;
	}

	public void setFinanceCntctPrsnEmail(String financeCntctPrsnEmail) {
		this.financeCntctPrsnEmail = financeCntctPrsnEmail;
	}

	@AuditLoggable(fieldName = "BL_RELATED", displayName = "BL Related")
	public String getBlRelated() {
		return blRelated;
	}

	public void setBlRelated(String blRelated) {
		this.blRelated = blRelated;
	}

	@AuditLoggable(fieldName = "DEPOSITAMT", displayName = "Deposit Amount")
	public Double getDepositAmt() {
		return depositAmt;
	}

	public void setDepositAmt(Double depositAmt) {
		this.depositAmt = depositAmt;
	}

	public String getSlotOperator() {
		return slotOperator;
	}

	public void setSlotOperator(String slotOperator) {
		this.slotOperator = slotOperator;
	}

	@AuditLoggable(fieldName = "MLO_CREDIT_LIMIT", displayName = "Credit Cust Type")
	public String getCreditCustType() {
		return creditCustType;
	}

	public void setCreditCustType(String creditCustType) {
		this.creditCustType = creditCustType;
	}

	public List<CustomerDtlBean> getCustomerVoyageList() {
		return customerVoyageList;
	}

	public void setCustomerVoyageList(List<CustomerDtlBean> customerVoyageList) {
		this.customerVoyageList = customerVoyageList;
	}

	@AuditLoggable(fieldName = "MLO_TYPE", displayName = "Mlo Type")
	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	@AuditLoggable(fieldName = "CURRENCY_CODE", displayName = "Currency Code")
	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@AuditLoggable(fieldName = "MODIFIED_BY", displayName = "Modified By")
	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@AuditLoggable(fieldName = "CURRENCY_CODE", displayName = "Currency Code")
	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getActive() {
		return active;
	}

	@AuditLoggable(fieldName = "MLO_ACTIVE", displayName = "Active")
	public void setActive(String active) {
		this.active = active;
	}

	public String getCreditBlkStatus() {
		return creditBlkStatus;
	}

	public void setCreditBlkStatus(String creditBlkStatus) {
		this.creditBlkStatus = creditBlkStatus;
	}

	@AuditLoggable(fieldName = "MLO_CREDIT_LIMIT", displayName = "Mlo Credit")
	public String getCreditMloTypeHidden() {
		return creditMloTypeHidden;
	}

	public void setCreditMloTypeHidden(String creditMloTypeHidden) {
		this.creditMloTypeHidden = creditMloTypeHidden;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public double getOutstandingLocal() {
		return outstandingLocal;
	}

	public void setOutstandingLocal(double outstandingLocal) {
		this.outstandingLocal = outstandingLocal;
	}

	public double getOutstandingUSD() {
		return outstandingUSD;
	}

	public void setOutstandingUSD(double outstandingUSD) {
		this.outstandingUSD = outstandingUSD;
	}


	public String getPaymentCountryName() {
		return paymentCountryName;
	}

	public void setPaymentCountryName(String paymentCountryName) {
		this.paymentCountryName = paymentCountryName;
	}

	public String getCustomerTeus() {
		return customerTeus;
	}

	public void setCustomerTeus(String customerTeus) {
		this.customerTeus = customerTeus;
	}

	public String getCustomerTeusRank() {
		return customerTeusRank;
	}

	public void setCustomerTeusRank(String customerTeusRank) {
		this.customerTeusRank = customerTeusRank;
	}

	public String getCustomerAmount() {
		return customerAmount;
	}

	public void setCustomerAmount(String customerAmount) {
		this.customerAmount = customerAmount;
	}

	public String getCustomerRank() {
		return customerRank;
	}

	public void setCustomerRank(String customerRank) {
		this.customerRank = customerRank;
	}

	public String getCustomerOutRank() {
		return customerOutRank;
	}

	public void setCustomerOutRank(String customerOutRank) {
		this.customerOutRank = customerOutRank;
	}

	public String getCustomerOutAmount() {
		return customerOutAmount;
	}

	public void setCustomerOutAmount(String customerOutAmount) {
		this.customerOutAmount = customerOutAmount;
	}

	public String getCreditGroupName() {
		return creditGroupName;
	}

	public void setCreditGroupName(String creditGroupName) {
		this.creditGroupName = creditGroupName;
	}

	@AuditLoggable(fieldName = "CREDIT_AMNT", displayName = "Credit Amount")
	public String getCreditLimitAmt() {
		return creditLimitAmt;
	}

	public void setCreditLimitAmt(String creditLimitAmt) {
		this.creditLimitAmt = creditLimitAmt;
	}

	@AuditLoggable(fieldName = "CREDIT_DAYS", displayName = "Credit  Limit")
	public String getCreditLimitDays() {
		return creditLimitDays;
	}

	public void setCreditLimitDays(String creditLimitDays) {
		this.creditLimitDays = creditLimitDays;
	}


	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}


	public String getPrevYear() {
		return prevYear;
	}

	public void setPrevYear(String prevYear) {
		this.prevYear = prevYear;
	}


	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}

	public boolean isLeadStatus() {
		return leadStatus;
	}

	public void setLeadStatus(boolean leadStatus) {
		this.leadStatus = leadStatus;
	}

	public List<CustomMasterBean> getCustomerMasterCommDetails() {
		return customerMasterCommDetails;
	}

	public void setCustomerMasterCommDetails(List<CustomMasterBean> customerMasterCommDetails) {
		this.customerMasterCommDetails = customerMasterCommDetails;
	}
	@AuditLoggable(fieldName = "RELATED_PARTY", displayName = "Related Party")
	public String getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(String relatedParty) {
		this.relatedParty = relatedParty;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@AuditLoggable(fieldName = "CURRENCY_CODE", displayName = "Currency Code")
	public String getSubSlot() {
		return subSlot;
	}

	public void setSubSlot(String subSlot) {
		this.subSlot = subSlot;
	}

	@AuditLoggable(fieldName = "INVOICE_MAIL", displayName = "Invoice Email Number")
	public String getInvoiceEmailId() {
		return invoiceEmailId;
	}

	public void setInvoiceEmailId(String invoiceEmailId) {
		this.invoiceEmailId = invoiceEmailId;
	}

	public List<CustomMasterBean> getCustomerVoyageList1() {
		return customerVoyageList1;
	}

	public void setCustomerVoyageList1(List<CustomMasterBean> customerVoyageList1) {
		this.customerVoyageList1 = customerVoyageList1;
	}

	public String getAcctHead() {
		return acctHead;
	}

	public void setAcctHead(String acctHead) {
		this.acctHead = acctHead;
	}

	public List<CustomMasterBean> getMobileCustCommDetail() {
		return mobileCustCommDetail;
	}

	public void setMobileCustCommDetail(List<CustomMasterBean> mobileCustCommDetail) {
		this.mobileCustCommDetail = mobileCustCommDetail;
	}

	public String getVatNo() {
		return vatNo;
	}

	public void setVatNo(String vatNo) {
		this.vatNo = vatNo;
	}
	
	

}
