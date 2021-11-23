package com.dci.tenant.userList;

public class ListQueryUtil {
  public static final String Bank_Payment="SELECT payment_voucher_no  as voucherNo, acct_head as accthead, invoice as invoiceNo, rcd_amt_local as usdAmount , rcd_amt_usd as localAmount, invoice_amt as invoiceAmount , alloted_dt as allotedDate , alloted_by as allotedBy,srvc_prtnr_nam as PartyName  FROM cb_payment_invoice_dtl e inner join service_partner cm on cm.acct_head_code =e.acct_head where invoice=?";
  public static final String Bank_Receipt=" SELECT receipt_voucher_no  as voucherNo, invoice as invoiceNo, rcd_amt_local as usdAmount , rcd_amt_usd as localAmount, invoice_amt as invoiceAmount , alloted_dt as allotedDate , alloted_by as allotedBy,srvc_prtnr_nam as PartyName FROM cb_receipt_invoice_dtl e inner join service_partner cm on cm.acct_head_code =e.acct_head where invoice=?";
  public static final String Tds="SELECT voucher_no  as voucherNo, paid_to as partyName,voucher_no_new as invoiceNo,  tc_amount as usdAmount , bc_amount as localAmount,crt_on as allotedDate, crt_by as allotedBy FROM cb_payment_tds_dtl where voucher_no=? ";
                                                                                                              
}
