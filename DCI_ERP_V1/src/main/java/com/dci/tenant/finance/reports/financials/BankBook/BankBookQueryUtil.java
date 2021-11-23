package com.dci.tenant.finance.reports.financials.BankBook;

public class BankBookQueryUtil {

	public static String GET_BANK_ACCOUNT = "select (select sum(DEBIT)-SUM(CREDIT) as openingBalance from GENERAL_LEDGER GL where  GL.LEDGER_DT < TO_DATE(?,'DD/MM/YYYY') AND ACCOUNT_HEAD like ('1002%') AND COMPANY_CODE in (?)   ),GL.ACCOUNT_HEAD as accountCode, AM.ACCT_HEAD_NAME as accountName ,sum(DEBIT) as debit,SUM(CREDIT) as credit, "
			+ "sum(DEBIT)-SUM(CREDIT) as currentBalance from GENERAL_LEDGER GL LEFT JOIN ACCOUNT_HEAD_MASTER AM "
			+ "ON GL.ACCOUNT_HEAD = AM.ACCT_HEAD_CODE  where GL.LEDGER_DT "
			+ "between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') and GL.ACCOUNT_HEAD like ('1003%')";

	public static String GET_SUB_DATA =  "select Particulars as transactionNo, TO_CHAR(LEDGER_DT,'DD/MM/YYYY') as transactionDate,NARRATION as narration,COALESCE(DEBIT, 0) as bcDebit ,COALESCE(CREDIT, 0) as bcCredit,COALESCE(LOCAL_DEBIT, 0) as tcDebit ,COALESCE(LOCAL_CREDIT, 0) as tcCredit,DEBIT-CREDIT as currentBalance  from GENERAL_LEDGER "
			+ "where ACCOUNT_HEAD= ? AND LEDGER_DT  between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') ";

	public static String GET_ACCOUNT_LIST = "select ACCT_HEAD_CODE as id ,ACCT_HEAD_NAME as text from  ACCOUNT_HEAD_MASTER where SUBGROUP_ACCT_CODE = ? and acct_head_code!='10030003' and acct_head_code!='10030004' UNION select ACCT_HEAD_CODE as accountCode ,ACCT_HEAD_NAME as accountName from  ACCOUNT_HEAD_MASTER WHERE ACCT_HEAD_CODE ='10090004' and null_or_empty(ACCT_HEAD_NAME) is false ";

	public static String GET_CONSOLIDATED_BANK_DATA = "With t as(  select COALESCE(cph.cheque_no,'') || COALESCE(crh.cheque_no,'') as chequeNo,  COALESCE(crh.received_from,'') || COALESCE(cph.paid_to,'') as customer,  ACCOUNT_HEAD as mainAccountCode,ACCT_HEAD_NAME mainAccountName,Particulars as transactionNo, TO_CHAR(LEDGER_DT,'DD/MM/YYYY') as transactionDate,GENERAL_LEDGER.NARRATION as narration,COALESCE(DEBIT, 0) as bcDebit ,COALESCE(CREDIT, 0) as bcCredit,COALESCE(LOCAL_DEBIT, 0) as tcDebit,COALESCE(LOCAL_CREDIT, 0) as tcCredit,COALESCE((DEBIT-CREDIT),0.00) as currentBalance from GENERAL_LEDGER LEFT JOIN ACCOUNT_HEAD_MASTER AH ON AH.ACCT_HEAD_CODE=GENERAL_LEDGER.ACCOUNT_HEAD left join cashbank_pay_hdr cph on cph.voucher_no = GENERAL_LEDGER.Particulars"
			+ " left join cashbank_receipt_hdr crh on crh.voucher_no =GENERAL_LEDGER.Particulars"
			+ " where LEDGER_DT  between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') ";
}


