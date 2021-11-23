package com.dci.tenant.finance.payableAgewise;

public class PayableAgewiseQueryUtil {

	public static String GET_PAYABLE_AGEWISE_LIST = " select * from fn_payableagewise(?) ";

	public static String GET_PAYABLE_AGEWISE_DTL_LIST = " select invoice_no as invoiceNo, TO_CHAR(invoice_dt,'DD-MM-YYYY') as invoiceDate, amount as invoiceAmount, paid as paidAmount,balance as balanceAmount, " + " case when age_in_days <=15 then  balance else 0 end below15days, " + "  case when age_in_days between 16 and 30 then  balance else 0 end days30, " + " case when age_in_days between 31 and 45 then  balance else 0 end days45, " + " case when age_in_days between 46 and 90 then  balance else 0 end days90, "
			+ " case when age_in_days between 91 and 180 then  balance else 0 end days180, " + " case when age_in_days > 180 then  balance else 0 end above180days " + " from ( select A.invoice_no, invoice_dt, amount, coalesce(paid_amt,0) paid, ? - invoice_dt age_in_days, " + " amount - coalesce(paid_amt,0) balance from " + " ( select invoice_no, invoice_dt, amount  from purchase_invoice_hdr  where supplier = ? and invoice_dt <= ? ) A " + "  left outer join ( select pur_invoice_no, sum(paid_amt_bc) paid_amt  "
			+ " from cashbank_pay_inv_dtl cbpi, cashbank_pay_dtl d, cashbank_pay_hdr p " + " where cbpi.pur_invoice_no in (select invoice_no from purchase_invoice_hdr where supplier = ?) " + " and cbpi.cashbank_pay_dtl_id = d.cashbank_pay_dtl_id and d.voucher_no = p.voucher_no " + " and p.voucher_dt <= ?  group by pur_invoice_no   ) B on A.invoice_no = B.pur_invoice_no" + " where amount > coalesce(paid_amt,0) ) T order by invoiceNo asc ";

}
