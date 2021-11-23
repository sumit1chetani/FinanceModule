package com.dci.tenant.finance.receivableAgewise;

public class ReceivableAgewiseQueryUtil {

	public static String GET_RECEIVABLE_AGEWISE_LIST = "select * from fn_receivableagewise(?)";

	public static String GET_RECEIVABLE_AGEWISE_DTL_LIST = "select invoice_no as invoiceNo, TO_CHAR(invoice_dt,'DD-MM-YYYY') as invoiceDate, amount as invoiceAmount, " + "paid as paidAmount,balance as balanceAmount,  case when age_in_days <=15 then  balance else 0 end below15days, " + "case when age_in_days between 16 and 30 then  balance else 0 end days30, case when age_in_days between 31 and 45 then  balance else 0 end days45, " + "case when age_in_days between 46 and 90 then  balance else 0 end days90, "
			+ "case when age_in_days between 91 and 180 then  balance else 0 end days180, case when age_in_days > 180 then  balance else 0 end above180days " + "from (select A.invoice_no, invoice_dt, amount, coalesce(paid_amt,0) paid, ? - invoice_dt age_in_days, " + " amount - coalesce(paid_amt,0) balance from ( select invoice_no, invoice_dt, amount from general_invoice_hdr " + " where customer = ? and invoice_dt <= ? "
			+ "union select hdr.creditnote_no as invoice_no, creditnote_date as invoice_dt, sum(creditnote_amount) as amount from creditnote_hdr hdr, creditnote_dtl dtl " + "where hdr.creditnote_no = dtl.creditnote_no and creditnote_invoice_no in (select invoice_no from general_invoice_hdr where customer=?) " + " and creditnote_date <= ? group by hdr.creditnote_no,hdr.creditnote_date ) A  left outer join ( " + "select invoice_no, sum(paid_bc_amount) paid_amt from cashbank_receipt_invoice cri, cashbank_receipt_dtl d, "
			+ "cashbank_receipt_hdr h where cri.invoice_no in (select invoice_no from general_invoice_hdr where customer = ? " + "UNION select creditnote_no AS invoice_no from creditnote_hdr where creditnote_invoice_no in (select invoice_no from general_invoice_hdr " + "where customer=?)) " + "and cri.cashbankreceipt_dtl_id = d.cashbankreceipt_dtl_id and d.voucher_no = h.voucher_no " + "group by invoice_no ) B on A.invoice_no = B.invoice_no where amount > coalesce(paid_amt,0)) T";

}
