package com.dci.tenant.finance.reports.analytical.revenueregister;

import java.util.List;

public class revenueregister {

	// in query the fields are available
	public String invoiceNo;
	public String quotationNo;
	public String paymentCenter;
	public String invoiceDt;
	public String getPaymentCenter() {
		return paymentCenter;
	}

	public void setPaymentCenter(String paymentCenter) {
		this.paymentCenter = paymentCenter;
	}


	public String tc_amount;// amt
	public String bc_amount;// amount usd
	public String payerName;
	public String customerShortName;
	private String payerCode;
	private String invoicefromDate ;
	private String  invoicetoDate;
	public String companyName;
	public String mloCode;
	public String sailingDate;
	public String Month;
    public String voyage;
	public String rcr;
	public String portisocode;
	public String mloName;
	public String podisocode;
	public List lCustomerType;
	public List lpod;
	public List lpol;
	public String countryName;
	public String payershortName;
	private String accountname;
	private String mlocode;
	public String getJobNO() {
		return jobNO;
	}

	public void setJobNO(String jobNO) {
		this.jobNO = jobNO;
	}


	private String company_Id;
	private String customerCode;
	public String voyageName;
	public String jobNO;
	
	public String getVoyageName() {
		return voyageName;
	}

	public void setVoyageName(String voyageName) {
		this.voyageName = voyageName;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCompany_Id() {
		return company_Id;
	}

	public void setCompany_Id(String company_Id) {
		this.company_Id = company_Id;
	}

	public String getMloName() {
		return mloName;
	}

	public void setMloName(String mloName) {
		this.mloName = mloName;
	}


	public String getInvoicefromDate() {
		return invoicefromDate;
	}

	public void setInvoicefromDate(String invoicefromDate) {
		this.invoicefromDate = invoicefromDate;
	}

	public String getInvoicetoDate() {
		return invoicetoDate;
	}

	public void setInvoicetoDate(String invoicetoDate) {
		this.invoicetoDate = invoicetoDate;
	}

	public List getLpod() {
		return lpod;
	}

	public void setLpod(List lpod) {
		this.lpod = lpod;
	}

	public List getLpol() {
		return lpol;
	}

	public void setLpol(List lpol) {
		this.lpol = lpol;
	}


	public String getPortisocode() {
		return portisocode;
	}

	public void setPortisocode(String portisocode) {
		this.portisocode = portisocode;
	}


	public List getlCustomerType() {
		return lCustomerType;
	}

	public void setlCustomerType(List lCustomerType) {
		this.lCustomerType = lCustomerType;
	}

	public List getLcreditCategory() {
		return lcreditCategory;
	}

	public void setLcreditCategory(List lcreditCategory) {
		this.lcreditCategory = lcreditCategory;
	}

	public List getLcategory() {
		return lcategory;
	}

	public void setLcategory(List lcategory) {
		this.lcategory = lcategory;
	}

	public String getPayerCode() {
		return payerCode;
	}

	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}


	public List lcreditCategory;
	public List lcategory;

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

	private String id;
	private String text;

	public String pol;

	public String mloCategory;
	public String vesselId;
	public String pod;

	public String fpod;

	public String company;

	public String getAccountHeadName() {
		return accountHeadName;
	}

	public void setAccountHeadName(String accountHeadName) {
		this.accountHeadName = accountHeadName;
	}

	public String acct_code;
	public String accountHeadName;
	public String createdBy;
	public String customer;
	public String payer;

	// in
	public String mloShortName;
	public String fromDate;
	public String toDate;
	public String sectorId;
	public String activityShortName;
	public String of_usd;
	public String imco_usd;
	public String oog_usd;
	public String cbr_usd;
	public String rcr_usd;
	public String others_usd;

	// multi select dpsss
	public String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCreditCategory() {
		return creditCategory;
	}

	public void setCreditCategory(String creditCategory) {
		this.creditCategory = creditCategory;
	}

	public String customerType;
	public String creditCategory;

	public String getVesselId() {
		return vesselId;
	}

	public void setVesselId(String vesselId) {
		this.vesselId = vesselId;
	}

	public String getMloCategory() {
		return mloCategory;
	}

	public void setMloCategory(String mloCategory) {
		this.mloCategory = mloCategory;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCustomerShortName() {
		return customerShortName;
	}

	public String getRcr() {
		return rcr;
	}

	public void setRcr(String rcr) {
		this.rcr = rcr;
	}

	public void setCustomerShortName(String customerShortName) {
		this.customerShortName = customerShortName;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getQuotationNo() {
		return quotationNo;
	}

	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}

	public String getInvoiceDt() {
		return invoiceDt;
	}

	public void setInvoiceDt(String invoiceDt) {
		this.invoiceDt = invoiceDt;
	}

	public String getTc_amount() {
		return tc_amount;
	}

	public void setTc_amount(String tc_amount) {
		this.tc_amount = tc_amount;
	}

	public String getBc_amount() {
		return bc_amount;
	}

	public void setBc_amount(String bc_amount) {
		this.bc_amount = bc_amount;
	}

	 
	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getMloCode() {
		return mloCode;
	}

	public void setMloCode(String mloCode) {
		this.mloCode = mloCode;
	}

	public String getSailingDate() {
		return sailingDate;
	}

	public void setSailingDate(String sailingDate) {
		this.sailingDate = sailingDate;
	}

	public String getMonth() {
		return Month;
	}

	public void setMonth(String month) {
		Month = month;
	}

	public String getVoyage() {
		return voyage;
	}

	public void setVoyage(String voyage) {
		this.voyage = voyage;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAcct_code() {
		return acct_code;
	}

	public void setAcct_code(String acct_code) {
		this.acct_code = acct_code;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getMloShortName() {
		return mloShortName;
	}

	public void setMloShortName(String mloShortName) {
		this.mloShortName = mloShortName;
	}

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

	public String getSectorId() {
		return sectorId;
	}

	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}

	public String getActivityShortName() {
		return activityShortName;
	}

	public void setActivityShortName(String activityShortName) {
		this.activityShortName = activityShortName;
	}

	public String getOf_usd() {
		return of_usd;
	}

	public void setOf_usd(String of_usd) {
		this.of_usd = of_usd;
	}

	public String getImco_usd() {
		return imco_usd;
	}

	public void setImco_usd(String imco_usd) {
		this.imco_usd = imco_usd;
	}

	public String getOog_usd() {
		return oog_usd;
	}

	public void setOog_usd(String oog_usd) {
		this.oog_usd = oog_usd;
	}

	public String getCbr_usd() {
		return cbr_usd;
	}

	public void setCbr_usd(String cbr_usd) {
		this.cbr_usd = cbr_usd;
	}

	public String getRcr_usd() {
		return rcr_usd;
	}

	public void setRcr_usd(String rcr_usd) {
		this.rcr_usd = rcr_usd;
	}

	public String getOthers_usd() {
		return others_usd;
	}

	public void setOthers_usd(String others_usd) {
		this.others_usd = others_usd;
	}
	public String getPodisocode() {
		return podisocode;
	}

	public void setPodisocode(String podisocode) {
		this.podisocode = podisocode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getPayershortName() {
		return payershortName;
	}

	public void setPayershortName(String payershortName) {
		this.payershortName = payershortName;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getMlocode() {
		return mlocode;
	}

	public void setMlocode(String mlocode) {
		this.mlocode = mlocode;
	}

}
