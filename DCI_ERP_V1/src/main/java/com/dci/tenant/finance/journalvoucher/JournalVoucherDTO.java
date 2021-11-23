package com.dci.tenant.finance.journalvoucher;

import java.util.List;

import com.dci.tenant.auditlog.AuditLoggable;

public class JournalVoucherDTO {

	private String jvNumber;
	private String dataOfIssue;
	private Boolean openingBalance;
	private double ExchangeRate;
	private Integer ledgerNo;
	private String subAccountCode;
	private String subAccountName;
	private String amountinWords;
	private String costcenter;


 	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String currencyType;

	
	public String getSubAccountCode() {
		return subAccountCode;
	}

	public String getAmountinWords() {
		return amountinWords;
	}

	public void setAmountinWords(String amountinWords) {
		this.amountinWords = amountinWords;
	}

	public void setSubAccountCode(String subAccountCode) {
		this.subAccountCode = subAccountCode;
	}

	public String getSubAccountName() {
		return subAccountName;
	}

	public void setSubAccountName(String subAccountName) {
		this.subAccountName = subAccountName;
	}

	public Integer getLedgerNo() {
		return ledgerNo;
	}

	public void setLedgerNo(Integer ledgerNo) {
		this.ledgerNo = ledgerNo;
	}

	private double totalbcCredit;

	public double getExchangeRate() {
		return ExchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		ExchangeRate = exchangeRate;
	}

	private double totalbcDebit;

	public double getTotalbcCredit() {
		return totalbcCredit;
	}

	public void setTotalbcCredit(double totalbcCredit) {
		this.totalbcCredit = totalbcCredit;
	}

	public double getTotalbcDebit() {
		return totalbcDebit;
	}

	public void setTotalbcDebit(double totalbcDebit) {
		this.totalbcDebit = totalbcDebit;
	}

	public Boolean getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(Boolean openingBalance) {
		this.openingBalance = openingBalance;
	}

	private String totalTcDebitAmt1;
	private String totalBcDebitAmt1;

	public String getTotalTcDebitAmt1() {
		return totalTcDebitAmt1;
	}

	public void setTotalTcDebitAmt1(String totalTcDebitAmt1) {
		this.totalTcDebitAmt1 = totalTcDebitAmt1;
	}

	public String getTotalBcDebitAmt1() {
		return totalBcDebitAmt1;
	}

	public void setTotalBcDebitAmt1(String totalBcDebitAmt1) {
		this.totalBcDebitAmt1 = totalBcDebitAmt1;
	}

	public String getTotalTcCreditAmt1() {
		return totalTcCreditAmt1;
	}

	public void setTotalTcCreditAmt1(String totalTcCreditAmt1) {
		this.totalTcCreditAmt1 = totalTcCreditAmt1;
	}

	public String getTotalBcCreditAmt1() {
		return totalBcCreditAmt1;
	}

	public void setTotalBcCreditAmt1(String totalBcCreditAmt1) {
		this.totalBcCreditAmt1 = totalBcCreditAmt1;
	}

	public String getTcAmount1() {
		return tcAmount1;
	}

	public void setTcAmount1(String tcAmount1) {
		this.tcAmount1 = tcAmount1;
	}

	public String getBcAmount1() {
		return bcAmount1;
	}

	public void setBcAmount1(String bcAmount1) {
		this.bcAmount1 = bcAmount1;
	}

	private String totalTcCreditAmt1;
	private String totalBcCreditAmt1;
	private String tcAmount1;
	private String bcAmount1;
	private String narration;
	private String company;
	private String companyCode;
	private String jvTypeName;
	private String companyLocation;
	private String jvDate;
	private int journalvoucherTypeId;

	private String costCenter;
	private String bankCenter;

	private double totalTcDebitAmt;
	private double totalBcDebitAmt;
	private double totalTcCreditAmt;
	private double totalBcCreditAmt;
	private double tcAmount;
	private double bcAmount;
	private String companyName;
	private double total;
	private double total1;

	private String refNo;

	@AuditLoggable(fieldName = "refNo", displayName = "Ref No")
	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	private String preparedBy;

	public String getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getTotalTcDebitAmt() {
		return totalTcDebitAmt;
	}

	public void setTotalTcDebitAmt(double totalTcDebitAmt) {
		this.totalTcDebitAmt = totalTcDebitAmt;
	}

	public double getTotalBcDebitAmt() {
		return totalBcDebitAmt;
	}

	public void setTotalBcDebitAmt(double totalBcDebitAmt) {
		this.totalBcDebitAmt = totalBcDebitAmt;
	}

	public double getTotalTcCreditAmt() {
		return totalTcCreditAmt;
	}

	public void setTotalTcCreditAmt(double totalTcCreditAmt) {
		this.totalTcCreditAmt = totalTcCreditAmt;
	}

	public double getTotalBcCreditAmt() {
		return totalBcCreditAmt;
	}

	public void setTotalBcCreditAmt(double totalBcCreditAmt) {
		this.totalBcCreditAmt = totalBcCreditAmt;
	}

	public double getTcAmount() {
		return tcAmount;
	}

	public void setTcAmount(double tcAmount) {
		this.tcAmount = tcAmount;
	}

	public double getBcAmount() {
		return bcAmount;
	}

	public void setBcAmount(double bcAmount) {
		this.bcAmount = bcAmount;
	}

	public String getBankCenter() {
		return bankCenter;
	}

	public void setBankCenter(String bankCenter) {
		this.bankCenter = bankCenter;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	private List<JournalVoucherBean> tables;

	private String id;
	private String text;

	private boolean success;

	public String getJvNumber() {
		return jvNumber;
	}

	public void setJvNumber(String jvNumber) {
		this.jvNumber = jvNumber;
	}

	public String getDataOfIssue() {
		return dataOfIssue;
	}

	public void setDataOfIssue(String dataOfIssue) {
		this.dataOfIssue = dataOfIssue;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<JournalVoucherBean> getTables() {
		return tables;
	}

	public void setTables(List<JournalVoucherBean> tables) {
		this.tables = tables;
	}

	public String getJvDate() {
		return jvDate;
	}

	public void setJvDate(String jvDate) {
		this.jvDate = jvDate;
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

	public int getJournalvoucherTypeId() {
		return journalvoucherTypeId;
	}

	public void setJournalvoucherTypeId(int journalvoucherTypeId) {
		this.journalvoucherTypeId = journalvoucherTypeId;
	}

	public String getJvTypeName() {
		return jvTypeName;
	}

	public void setJvTypeName(String jvTypeName) {
		this.jvTypeName = jvTypeName;
	}

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

	public double getTotal1() {
		return total1;
	}

	public void setTotal1(double total1) {
		this.total1 = total1;
	}

	
	
}
