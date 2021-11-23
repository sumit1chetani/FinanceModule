package com.dci.tenant.finance.chqreconcilation;

public class ChqReconcilationQueryUtil {

	public static String GET_BANK_ACCOUNT = "select ahm.Acct_Head_Code AS id,ahm.Acct_Head_Name AS text from ACCOUNT_HEAD_MASTER ahm where SUBGROUP_ACCT_CODE = ? ORDER BY ACCT_HEAD_NAME ASC";

	public static String sGetBookStatement = " select temp.transaction_no,TO_CHAR(temp.dt,'DD/MM/YYYY') as dt,temp.ob,temp.dr,temp.cr,temp.cb, " + "  COALESCE(cbp.cheque_no,'') || COALESCE(cbr.cheque_no,'') as cheque_no " + "  from (select * from bank_reconcilation(?,?,?,?) ) as temp " + "  left join CASHBANK_PAY_HDR cbp on cbp.voucher_no = temp.transaction_no " + "  left join cashbank_receipt cbr on cbr.cashbank_receipt_id=temp.transaction_no " + "  where temp.transaction_no not in( select transaction_no from reconciled_transaction)";

	public static String sGetReconcileStatement = " SELECT transaction_no, TO_CHAR(book_cheque_date,'DD/MM/YYYY') as book_cheque_date, book_cheque_no, book_debit_amount, book_credit_amount,TO_CHAR(bank_date,'DD/MM/YYYY') as bank_date  ," + " remarks,opening_bal,closing_bal FROM reconciled_transaction " + " where book_cheque_date between ? and ? and bank_account=? ";

	public static final String sSaveReconcileTransaction = "INSERT INTO reconciled_transaction(transaction_no, book_cheque_date, book_cheque_no, book_debit_amount," + " book_credit_amount, bank_account, remarks,bank_date,closing_bal,opening_bal) VALUES(?,?,?,?,?,?,?,?,?,?)";

}