package com.dci.tenant.finance.tax.taxpayment;

public class TaxPaymentQueryUtil {
	final static String GET_TAX_PAYMENT_LIST = "SELECT TYPE as taxType,TAX_NO taxNo,AMTLOCAL taxorderAmount,AMTUSD taxorderAmountUsd,CREDIT_HEAD taxorderAccHead,	CURRENCY currencyCode ,EXRATE,VENDOR vendorName FROM VIEW_TAX_PAYMENT";

	final static String GET_EMP_ACCESS_STATUS = "select COMPANY_CODE from employee_master where emp_id= ? and ACCESS_STATUS ='Y' ";
	/*
	 * private String cashBankAcctCode; private String cashBankAcctName; private
	 * double currFraction; private String currencyCode; private double
	 * exchangeRate; private double cashBankAmount; private double
	 * cashBankAmountUsd; private String chequeNo; private String chequeDate;
	 * private double fromValue; private double toValue; private String
	 * narration; private String paidTo;
	 */
	public final static String accountCategoryList = " select Acct_Head_Code as id,Acct_Head_Name as text,Acct_Head_Code cashBankAcctCode,Acct_Head_Name cashBankAcctName,acct_currency currencyCode, CURRENCY_DEFAULT exchangeRate,CURRENCY_CONVER_FROM fromValue,CURRENCY_CONVER_TO toValue from ACCOUNT_HEAD_MASTER,CURRENCY_MASTER " + " where CURRENCY_CODE=ACCT_CURRENCY order by Acct_Head_Name ";

	public final static String accountCategoryListDXB = "  select   Acct_Head_Code as id,Acct_Head_Name as text,Acct_Head_Code as id,Acct_Head_Name as text,Acct_Head_Code cashBankAcctCode,Acct_Head_Name cashBankAcctName,acct_currency currencyCode, CURRENCY_DEFAULT exchangeRate,CURRENCY_CONVER_FROM fromValue,CURRENCY_CONVER_TO toValue from ACCOUNT_HEAD_MASTER,CURRENCY_MASTER " + " where CURRENCY_CODE=ACCT_CURRENCY AND SUBGROUP_ACCT_CODE in " + " (BankCashSubGrpCode('B'),BankCashSubGrpCode('C')) order by Acct_Head_Name ";

	public final static String accountCategoryListSIN = "  select  Acct_Head_Code as id,Acct_Head_Name as text,Acct_Head_Code cashBankAcctCode,Acct_Head_Name cashBankAcctName,acct_currency currencyCode, CURRENCY_DEFAULT exchangeRate,CURRENCY_CONVER_FROM fromValue,CURRENCY_CONVER_TO toValue from ACCOUNT_HEAD_MASTER,CURRENCY_MASTER " + " where CURRENCY_CODE=ACCT_CURRENCY AND SUBGROUP_ACCT_CODE in " + " (BankCashSubGrpCode_SIN('B'),BankCashSubGrpCode_SIN('C')) order by Acct_Head_Name ";

	public final static String accountCategoryListMA = "  select  Acct_Head_Code as id,Acct_Head_Name as text,Acct_Head_Code cashBankAcctCode,Acct_Head_Name cashBankAcctName,acct_currency currencyCode, CURRENCY_DEFAULT exchangeRate,CURRENCY_CONVER_FROM fromValue,CURRENCY_CONVER_TO toValue from ACCOUNT_HEAD_MASTER,CURRENCY_MASTER " + " where CURRENCY_CODE=ACCT_CURRENCY AND SUBGROUP_ACCT_CODE in " + " (BankCashSubGrpCode_MA('B'),BankCashSubGrpCode_MA('C')) order by Acct_Head_Name ";

	public final static String accountCategoryListIND = " select  Acct_Head_Code as id,Acct_Head_Name as text,Acct_Head_Code cashBankAcctCode,Acct_Head_Name cashBankAcctName,acct_currency currencyCode, CURRENCY_DEFAULT exchangeRate,CURRENCY_CONVER_FROM fromValue,CURRENCY_CONVER_TO toValue from ACCOUNT_HEAD_MASTER,CURRENCY_MASTER " + " where CURRENCY_CODE=ACCT_CURRENCY AND SUBGROUP_ACCT_CODE in " + "(BankCashSubGrpCode_IND('B'),BankCashSubGrpCode_IND('C')) order by Acct_Head_Name ";

	public final static String getBankForCompany = "select  Acct_Head_Code as id,Acct_Head_Name as text,Acct_Head_Code cashBankAcctCode,Acct_Head_Name cashBankAcctName,acct_currency currencyCode, CURRENCY_DEFAULT exchangeRate,CURRENCY_CONVER_FROM fromValue,CURRENCY_CONVER_TO toValue from ACCOUNT_HEAD_MASTER,CURRENCY_MASTER where CURRENCY_CODE=ACCT_CURRENCY  order by Acct_Head_Name ";

	public final static String currencyFractionQuery = " select currency_fraction " + " from currency_master where currency_code = ? ";

	public final static String bankCashSubGroupCodeQuery = "select BankCashSubGrpCode('B') from dual";

	public final static String bankCashSubGroupCodeQueryMA = "select BankCashSubGrpCode_MA('B') from dual";

	public final static String bankCashSubGroupCodeQuerySIN = "select BankCashSubGrpCode_SIN('B') from dual";

	public final static String bankCashSubGroupCodeQueryIND = "select BankCashSubGrpCode_IND('B') from dual";

	public final static String getDateQuery = "select to_char(" + "sysdate,'mm-dd-yyyy') from dual";

	public final static String insertTaxPay = "INSERT INTO TAX_PAYMENT (TAX_NO,VOUCHER_NO,CURRENCY," + "EXRATE,AMT_LOC,AMT_USD,TYPE) VALUES (?,?,?,?,?,?,?)";

	final static String HeaderRecord = "insert into cashbank_pay_hdr (VOUCHER_NO," + "VOUCHER_DT," + "COMPANY_CODE,PAYMENT_TYPE,BANK_ACCT,EXCHANGE_RATE,narration," + "created_by,created_dt,CHEQUE_NO,AMT_LOCAL,AMT_USD," + "CHEQUE_DT,Paid_to) " + " values(?,to_date(to_char(sysdate,'DD/MM/YYYY'),'DD/MM/YYYY'),?,?,?,?,?,?,sysdate,?,?,?," + "to_date(?,'DD/MM/YYYY'),?)";

	final static String DetailRecord = "insert into cashbank_pay_dtl (voucher_no," + "acct_head,allocated_bill,currency,conversion_rate,amt_local,amt_usd," + "dept_code,vessel_id,voyage_no,sector_id,sub_group_code,sl_no) " + "values (?,?,?,?,?,?,?,?,?,?,?,?,(select nvl(max(sl_no),0)+1 " + "from cashbank_pay_dtl where voucher_no = ?))";

	final static String subheadquery = "select SUBGROUP_ACCT_CODE from ACCOUNT_HEAD_MASTER where ACCT_HEAD_CODE=?";

}
