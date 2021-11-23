package com.dci.tenant.finance.reports.financials.invoiceInformation;

public class InvoiceInformationQueryUtil {
	
	public static final String SELECT_CREDIT_NOTE = "select count(creditnote_no) from creditnote_temp_hdr where creditnote_no=?";
	
	public static final String SELECT_DEBIT_NOTE = "select count(debitnote_no) from debitnote_hdr where debitnote_no=?";
	
	public static final String SELECT_INVOICE = "select count(invoice_no) from customer_invoice_hdr where invoice_no=?";
	
	public static final String SELECT_GENERAL_INVOICE = "select count(invoice_no) from generalinvoice_hdr where invoice_no=?";
	
	public static final String SELECT_VOUCHER = "select count(journal_no) from journalvoucher_hdr where journal_no=?";
	
	public static final String SELECT_VOUCHER_ALL = "select count(journal_no) from journalvoucher_hdr where journal_no=?";
	
	public static final String CHECK_PURCHASE_INVOICE = "select count(invoice_no) from PURCHASE_INVOICE_HDR where invoice_no=?";
	
	public static final String CHECK_PAYMENT_ORDER = "select count(payment_order_no) from payment_order where payment_order_no=?";
	
	public static final String CHECK_PAYMENT = "select count(VOUCHER_NO) from CASHBANK_PAY_HDR where VOUCHER_NO=?";
	
	public static final String CHECK_RECEIPT = "select count(VOUCHER_NO) from CASHBANK_RECEIPT_HDR where VOUCHER_NO=?";
	
	public static String GET_COMPANY_ID_LIST = "SELECT COMPANY_CODE as companyCode"
			+ "FROM "
			+ "COMPANY_USER "
			+ "WHERE USER_ID = ?";
	
	public static String CREDIT_INVOICE_NO = "select creditnote_invoice_no invoiceNo from creditnote_temp_hdr where creditnote_no=?";
	
	public static String SINGLE_INVOICE = "select s.invoice_no invoiceNo, "
+ "									   to_char(s.invoice_dt::date,'dd/mm/yyyy') invoiceDate, "
+ "									   GET_COMPANY_NAME(GET_CUST_GEN_CODE(customer)) as customerName, "
+ "									    ''::character varying voyage, "
+ "									    ''::character varying vessel, "
+ "									     co.company_name companyName, "
+ "									     mm.mlo_name payerName "
+ "									     from customer_invoice_hdr s "
+ "									     left join COMPANY_MASTER co "
+ "									     on co.company_code=s.company_code "
+ "									     left join mlo_master mm "
+ "									   on mm.mlo_code=get_cust_gen_code(s.CUSTOMER) "
+ "									    "
+ "									     where s.invoice_no=?";
	
	public static String GENERAL_INVOICE = "select g.invoice_no invoiceNo, "
+ "									  to_char(g.invoice_dt::date,'dd/mm/yyyy') invoiceDate, "
+ "									  g.voyage_code voyage, "
+ "									  g.vessel as vessel, "
+ "								  co.company_name companyName, "
+ "								  mlo.mlo_name payerName, "
+ "									 mlo.MLO_NAME customerName "
+ "									 from generalinvoice_hdr g "
+ "									   left join COMPANY_MASTER co "
+ "									  on co.company_code=g.gi_company_code "
+ "									  "
+ "									  LEFT JOIN MLO_MASTER mlo "
+ "									  on Mlo.Mlo_Code = g.Customer "
+ "									  where g.invoice_no=?";

	
	public static String PURCHASE_INVOICE = "select ph.invoice_no invoiceNo, "
			+ "									 to_char(ph.invoice_dt::date,'dd/mm/yyyy') invoiceDate, "
			+ "									 string_agg(GET_COMPANY_NAME(GET_CUST_GEN_CODE(pd.customer)),',') as customerName, "
			+ "									    string_agg( pd.voyage,',') voyage, "
			+ "									      string_agg(pd.vessel,',') vessel, "
			+ "									   co.company_name companyName, "
			+ "									   mm.mlo_name payerName "
			+ "									   from PURCHASE_INVOICE_HDR ph "
			+ "									   left join PURCHASE_INVOICE_DTL pd "
			+ "									   on ph.invoice_no=pd.purchase_inv_no "
			+ "									   left join COMPANY_MASTER co "
			+ "									      on co.company_code=ph.company_code "
			+ "									       left join mlo_master mm "
			+ "									      on mm.mlo_code=get_cust_gen_code(pd.CUSTOMER) "
			+ " "
			+ "									      where ph.invoice_no=? "
			+ "									      group by ph.invoice_no,co.company_name,mm.mlo_name";
	

	
	public static String SINGLE_DEBIT_BY_CREDIT = "select d.debitnote_no debitNoteNo, "
									+"d.bc_amount amount "
									+ "from debitnote_hdr d "
									+ "inner join customer_invoice_hdr s "
									+ "on s.invoice_no=d.debitnote_invoice_no "
									+ "left join COMPANY_MASTER co "
									+ "on co.company_code=d.company_code "
									+ "where s.invoice_no=? "
									+ "and d.debitnote_no != null ";

	public static String GENERAL_DEBIT_BY_CREDIT = "select  d.debitnote_no debitNoteNo, "
									+"d.bc_amount amount "
									+ " from debitnote_hdr d "
									+ " inner join generalinvoice_hdr g "
									+ " on g.invoice_no=d.debitnote_invoice_no "
									+ " left join COMPANY_MASTER co "
									+ " on co.company_code=d.company_code "
									+ " where g.invoice_no=? "
									+ "and d.debitnote_no != null ";
	
	
	
	public static String PURCHASE_INVOICE_DEBIT_BY_CREDIT = "select d.debitnote_no debitNoteNo, "
									+"d.bc_amount amount "
									+ "from PURCHASE_INVOICE_HDR ph "
									+ "left join debitnote_hdr d "
									+ "on ph.invoice_no=d.debitnote_invoice_no "
									+ "left join COMPANY_MASTER co "
									+ "on co.company_code=ph.company_code "
									+ "where ph.invoice_no=? "
									+ "and d.debitnote_no != null ";
	
	public static String DEBIT_INVOICE_NO = "  select debitnote_invoice_no invoiceNo from debitnote_hdr where debitnote_no=?";
	
	public static String SINGLE_CREDIT_BY_DEBIT = "select c.creditnote_no creditNoteNo, "
									+"c.bc_amount amount"
									+ "    from creditnote_temp_hdr c "
									+ "    inner join customer_invoice_hdr s "
									+ "    on s.invoice_no=c.creditnote_invoice_no "
									+ "   left join COMPANY_MASTER co "
									+ "    on co.company_code=c.company_code "
									+ "    where s.invoice_no=? "
									+ "and c.creditnote_no != null ";

	
	public static String GENERAL_CREDIT_BY_DEBIT = "select  c.creditnote_no creditNoteNo,"
									+"c.bc_amount amount"
									+ "  from creditnote_temp_hdr c "
									+ "  inner join generalinvoice_hdr g "
									+ "  on g.invoice_no=c.creditnote_invoice_no "
									+ "  left join COMPANY_MASTER co "
									+ "   on co.company_code=c.company_code "
									+ "    where g.invoice_no=? ";
	

	
	public static String PURCHASE_INVOICE_CREDIT_BY_DEBIT = "select  c.creditnote_no creditNoteNo,"
									+"c.bc_amount amount "
									+ "  from PURCHASE_INVOICE_HDR ph "
									+ "   left join creditnote_temp_hdr c "
									+ "      on ph.invoice_no=c.creditnote_invoice_no "
									+ "   left join COMPANY_MASTER co "
									+ "   on co.company_code=ph.company_code "
									+ "    where ph.invoice_no=? "
									+ "  and c.creditnote_no != null ";
									
	public static final String SELECT_BY_JOURNAL_VOUCHER = "select jvh.journal_no generalVoucher, "
+ "									 to_char(journal_date::date,'dd/mm/yyyy') jvDate, "
+ "									 jvh.journal_narration narration, "
+ "									 co.company_name companyName, "
+ "									 string_agg(jvd.journal_voyage,',') voyage, "
+ "									 string_agg(jvd.journal_vessel,',') vessel, "
+ "									 string_agg(s.sector_name,',') sector, "
+ "									 string_agg(acct_head_name,',') acctHeadName "
+ "									 from journalvoucher_hdr jvh "
+ "									 left join company_master co "
+ "									 on jvh.journal_company_code=co.company_code "
+ "									 left join journalvoucher_dtl jvd "
+ "									 on jvh.journal_no=jvd.journal_no "
+ "									 left join SECTOR_MASTER s "
+ "									 on s.sector_code=jvd.journal_sector "
+ "									 left join ACCOUNT_HEAD_MASTER ahm "
+ "									 on jvd.journal_account_head=ahm.acct_head_code "
+ "									 where jvh.journal_no=? ";

	
	public static final String SELECT_PURCHASE_INVOICE = "select pinhdr.invoice_no purchaseInvoiceNo, "
									+ "to_char(invoice_dt,'dd/mm/yyyy') invoiceDate, "
									+ "supp.Vendor_Name supplier, "
									+ "comp.company_name company, "
									+ "purchase_no purchaseOrderNo, "
									+"pinhdr.bc_amount amount "
									+ "from PURCHASE_INVOICE_HDR pinhdr "
									+ "LEFT JOIN VENDOR_MASTER supp on Supp.ACCT_HEAD_CODE = Pinhdr.Supplier "
									+ "LEFT JOIN COMPANY_MASTER comp on Comp.Company_Code = Pinhdr.COMPANY_CODE "
									+ "where invoice_no=?";
	
	public static final String SELECT_PAYMENT_ORDER = "select payment_order_no paymentOrderNO, "
									+ "pur_inv_no purchaseInvoiceNo, "
									+ "to_char(payment_order_dt,'dd/mm/yyyy') paymentOrderDate, "
									+ "comp.company_name company "
									+ "from payment_order po "
									+ "LEFT JOIN COMPANY_MASTER comp on Comp.Company_Code = po.COMPANY_CODE "
									+ "where payment_order_no=?";
	
	public static final String SELECT_PAYMENT = "select Cpayhdr.VOUCHER_NO voucherNo, "
									+ "to_char(Cpayhdr.VOUCHER_DT,'dd/mm/yyyy') voucherDate, "
									+ "Comp.Company_Name company, "
									+ "case when PAYMENT_TYPE='B' then 'Bank' else 'Case' end as paymentType, "
									+ "PAID_TO paidTo, "
									+ "CHEQUE_NO chequeNo, "
									+ "to_char(CHEQUE_DT,'dd/mm/yyyy') chequeDate, "
									+ "Cpayhdr.bc_amount amount "
									+ "from CASHBANK_PAY_HDR cpayhdr "
									+ " LEFT JOIN COMPANY_MASTER comp on Comp.Company_Code = Cpayhdr.Company_Code "
									+ "where VOUCHER_NO=?";
	
	public static final String SELECT_RECEIPT = "select VOUCHER_NO voucherNo, "
									+ "to_char(VOUCHER_DT,'dd/mm/yyyy') voucherDate, "
									+ "case when RECEIPT_TYPE='B' then 'Bank' else 'Cash' end as paymentType, "
									+ "CHEQUE_NO chequeNo, "
									+ "to_char(CHEQUE_DT,'dd/mm/yyyy') chequeDate, "
									+ "comp.company_name company, "
									+ "RECEIVED_FROM receivedFrom, "
									+ "cbr.bc_amount amount "
									+ "from CASHBANK_RECEIPT_HDR cbr "
									+ "LEFT JOIN COMPANY_MASTER comp on comp.company_code = cbr.company_code "
									+ "where VOUCHER_NO=?";
								
	
}
