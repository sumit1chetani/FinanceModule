package com.dci.tenant.finance.paymentOrder;

public class PaymentOrderQueryUtil {

	public static final String GET_POR_DTL_LIST = "select payment_order_detail_id,payment_order_no,party_invoice_no,payment_order_dt,invoice_no,to_char(party_invoice_dt,'DD/MM/YYY') party_invoice_dt, " + " to_char(invoice_dt,'DD/MM/YYY') invoiceDate , to_char(due_date,'DD/MM/YYY') dueDt, inv_bc_amt,inv_tc_amt,payable_bc_amt,payable_tc_amt,currency as currencyCode , " + " ex_rate as exchangeRate,(inv_bc_amt-payable_bc_amt) bcBalanceAmt,(inv_tc_amt-payable_tc_amt) tcBalanceAmt from payment_order_detail where payment_order_no=?";

	public static final String GET_POR_HDR = "select to_char(payment_order.payment_order_date,'DD/MM/YYYY') payment_order_date, payment_order.payment_order_no,payment_order.po_bcamt,payment_order.po_tcamt,payment_order.supplier,e.entity_name as supplierName,payment_order.status from payment_order " + "left join  entity as e on e.supplier_acct_code=payment_order.supplier where payment_order_no=?";

	public static final String SAVE_PAYMENT_ORDER_LIST = "select distinct(po.payment_order_no) payment_order_no ,to_char(po.payment_order_date,'dd/mm/yyyy') paymentOrderDate,po.po_tcamt,po.po_bcamt,pod.currency,pod.ex_rate,e.entity_name,po.supplier from payment_order  as po " + "left join payment_order_detail as pod on pod.payment_order_no=po.payment_order_no " + "left join entity as e on e.supplier_acct_code=po.supplier "
			+ "where po.status='Approved' and po.payment_order_no not in( select payment_order_no from cashbank_pay_inv_dtl where payment_order_no!=NULL OR payment_order_no!='')";

	public static final String SELCT_ALL_PAYMENT_LIST = "select SUBGROUP_ACCT_CODE, ahm.Acct_Head_Code AS id,ahm.Acct_Head_Name AS text,ahm.Acct_Head_Code acctHeadCode,ahm.Acct_Head_Name accountName,'INR' as currencyCode, 1 AS exchangeRate from ACCOUNT_HEAD_MASTER ahm left join currency  curr on  curr.crrncy_cd = ahm.acct_currency ORDER BY ACCT_HEAD_NAME ASC";
			
//			/"select SUBGROUP_ACCT_CODE, ahm.Acct_Head_Code AS id,ahm.Acct_Head_Name AS text,ahm.Acct_Head_Code acctHeadCode,ahm.Acct_Head_Name accountName,'INR' as currencyCode, 1 AS exchangeRate " + "from ACCOUNT_HEAD_MASTER ahm left join currency  curr on  curr.currency_code = ahm.acct_currency " + "ORDER BY ACCT_HEAD_NAME ASC";

	public static final String SELECT_CHEQUE_LIST = "select chq_book_id as id , cheque_number as text  from cheque_details where bank_account=? and cheque_status=180";

	public static final String AUTOGEN_CASHBANK_VOUCHER_NO = "SELECT CASE WHEN MAX(VOUCHER_NO) IS NULL  THEN  ?  ELSE rpad(MAX (VOUCHER_NO),5,?)|| " + "lpad(cast(cast((SUBSTRING(MAX(VOUCHER_NO),5)) as int)+1 " + "as text),4,'0')  END AS VOUCHER_NO FROM CASHBANK_PAY_HDR where VOUCHER_NO like ?;";

	public static final String SAVE_CASH_BANK_PMT_HDR = "INSERT into CASHBANK_PAY_HDR (VOUCHER_NO, VOUCHER_DT,PAYMENT_TYPE, BANK_ACCT, EXCHANGE_RATE,CHEQUE_NO,voucher_no_new, CHEQUE_DT, AMT_LOCAL,AMT_USD, " + "NARRATION, created_by,created_dt, COMPANY_CODE) values(?,current_date,?,?,?,?,?,?,?,?,?,?,current_date,?)";

	public static final String SAVE_CASH_BANK_PMT_DTL = "INSERT into CASHBANK_PAY_DTL (VOUCHER_NO, ACCT_HEAD, ALLOCATED_BILL, CURRENCY, CONVERSION_RATE, AMT_LOCAL, AMT_USD, " + "SUB_GROUP_CODE, SL_NO,SUB_ACCOUNT_CODE,COMPANY) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?) returning cashbank_pay_dtl_id";

	public static final String UPDATE_CHQ_BOOK = "update cheque_details set cheque_date = to_date(:chequeDate,'dd/mm/yyyy'),narration=:narration,cheque_status=:chequeStatus,cheque_amount=:bcAmountHdr where  bank_account=:bankaccount and cheque_number=:chqBookId";

	public static final String SAVE_CASH_BANK_PMT_INVOICE_DTL = "INSERT INTO cashbank_pay_inv_dtl  (cashbank_pay_dtl_id, pur_invoice_no, inv_amt_bc, inv_amt_tc, paid_amt_bc, paid_amt_tc, currency, exg_rate,payment_order_no) " + "values (?,?,?,?,?,?,?,?,?)";

	public static final String GET_TOATAL_PAY_AMOUNT = "select pur_invoice_no, coalesce(sum(cpi.paid_amt_bc),0) totalPaidBcAmt , coalesce(sum(cpi.paid_amt_tc),0) totatlPaidTcAmt " + "from  cashbank_pay_inv_dtl as cpi " + "inner join cashbank_pay_dtl as cd on cd.cashbank_pay_dtl_id=cpi.cashbank_pay_dtl_id " + "where pur_invoice_no=? " + "group by pur_invoice_no";

	public static final String GET_TOATAL_PAY_AMOUNT_TC = "select pur_invoice_no, coalesce(sum(paid_amt_tc),0) totalPaidTcAmt, coalesce(sum(paid_amt_bc),0) totalPaidBcAmt , " + "coalesce(inv_amt_tc-sum(paid_amt_bc),0) tcBalanceAmt " + "from  cashbank_pay_inv_dtl where pur_invoice_no=? " + "group by pur_invoice_no,inv_amt_tc";

	public static String SAVE_PAYMENT_ORDER_SEARCH_LIST = "select distinct(po.payment_order_no) payment_order_no ,to_char(po.payment_order_date,'dd/mm/yyyy') paymentOrderDate,po.po_tcamt,po.po_bcamt,pod.currency,pod.ex_rate,e.entity_name,po.supplier from payment_order  as po left join payment_order_detail as pod on pod.payment_order_no=po.payment_order_no "
			+ "   left join entity as e on e.supplier_acct_code=po.supplier where po.company_code = ? and po.status='Approved' and po.payment_order_no not in( select payment_order_no from cashbank_pay_inv_dtl where payment_order_no!=NULL OR payment_order_no!='')";
}
