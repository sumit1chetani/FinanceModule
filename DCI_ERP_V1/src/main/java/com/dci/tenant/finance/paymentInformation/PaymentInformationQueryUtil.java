package com.dci.tenant.finance.paymentInformation;

public class PaymentInformationQueryUtil {
	/*
	 * public static final String GET_PAY_ORDER_LIST =
	 * "select COALESCE(invoice_no,'') as Invoice_no, COALESCE(inv_bc_amt,0) invBcAmt, COALESCE(currency,'') currencyCode, "
	 * +
	 * " COALESCE(ex_rate,0) exchangeRate, COALESCE(paid_amt_bc,0) payableBcAmt, COALESCE(paid_amt_tc,0) payableTcAmt, COALESCE(bc_balance_amt,0) bcBalanceAmt, "
	 * +
	 * "Invoice_Date,supplierId,supplier,partyInvoiceDt,partyInvoiceNo,dueDt from ( "
	 * + "select aaa.invoice_no, aaa.inv_bc_amt, aaa.currency, aaa.ex_rate, " +
	 * "paid_amt_bc,  paid_amt_tc, (aaa.inv_bc_amt-aaa.paid_amt_bc)  bc_balance_amt, "
	 * +
	 * " aaa.Invoice_Date as Invoice_Date,aaa.supplierId,aaa.supplier,aaa.partyInvoiceDt,aaa.partyInvoiceNo,aaa.dueDt "
	 * + "from ( " +
	 * "select  cbpinv.invoice_no,e.entity_name as supplier, e.entity_id as supplierId,to_char(pih.invoice_dt ,'DD/MM/YYYY')Invoice_Date ,  cbpinv.inv_bc_amt,cbpinv.currency, cbpinv.ex_rate, "
	 * +
	 * "sum(cbpinv.payable_bc_amt) paid_amt_bc, sum(cbpinv.payable_tc_amt) paid_amt_tc,to_char(pih.partyinvoice_dt ,'DD/MM/YYYY')partyInvoiceDt,pih.partyinvoice_no partyInvoiceNo, "
	 * + "to_char(pih.due_dt ,'DD/MM/YYYY') dueDt from payment_order_detail cbpinv "
	 * + "left join purchase_invoice_hdr pih on pih.invoice_no = cbpinv.invoice_no "
	 * + "left join entity e on e.supplier_acct_code=pih.supplier " +
	 * "group by cbpinv.invoice_no,cbpinv.currency,cbpinv.ex_rate,Invoice_Date,supplier,supplierId,partyInvoiceDt,partyInvoiceNo,dueDt,cbpinv.inv_bc_amt "
	 * + ") aaa " +
	 * "where aaa.invoice_no in (select invoice_no  from purchase_invoice_hdr where    payment_status not like 'Fully Paid%' and "
	 * +
	 * "invoice_dt >=to_date(?,'dd/mm/yyyy') and invoice_dt <=to_date(?,'dd/mm/yyyy')  ) and (aaa.inv_bc_amt-aaa.paid_amt_bc)>0 "
	 * +
	 * " group by invoice_no,inv_bc_amt,currency,ex_rate,  paid_amt_bc,paid_amt_tc,Invoice_Date,supplierId,supplier,partyInvoiceDt,partyInvoiceNo,dueDt "
	 * + "union " + "select pih.invoice_no,  pih.amount as inv_bc_amt, " +
	 * " pih.currency, pih.ex_rate as ex_rate, " +
	 * "pih.amount as paid_amt_bc,pih.tc_amount as paid_amt_tc,pih.amount as bc_balance_amt,to_char(pih.invoice_dt ,'DD/MM/YYYY')Invoice_Date, "
	 * +
	 * "e.entity_id as supplierId,e.entity_name as supplier,to_char(pih.partyinvoice_dt ,'DD/MM/YYYY')partyInvoiceDt,  pih.partyinvoice_no partyInvoiceNo, "
	 * + "to_char(pih.due_dt ,'DD/MM/YYYY') dueDt " +
	 * "from purchase_invoice_hdr pih " +
	 * "left join entity e on e.supplier_acct_code=pih.supplier " +
	 * "where   payment_status not like 'Fully Paid%' and " +
	 * "invoice_dt >=to_date(?,'dd/mm/yyyy') and invoice_dt <=to_date(?,'dd/mm/yyyy') and "
	 * +
	 * "pih.invoice_no not in(select invoice_no from payment_order_detail)) T1 order by invoice_no desc;"
	 * ;
	 */

	public static final String GET_PAY_ORDER_LIST = " select COALESCE(invoice_no,'') as Invoice_no,companyCode, COALESCE(inv_bc_amt,0) invBcAmt, COALESCE(currency,'') currencyCode, COALESCE(ex_rate,0) exchangeRate, COALESCE(paid_amt_bc,0) payableBcAmt, COALESCE(paid_amt_tc,0) payableTcAmt, COALESCE(bc_balance_amt,0) bcBalanceAmt, Invoice_Date,supplierId,supplier,partyInvoiceDt,partyInvoiceNo,dueDt from ( select aaa.invoice_no,aaa.companyCode, aaa.inv_bc_amt, aaa.currency, aaa.ex_rate, "
			+ " paid_amt_bc, paid_amt_tc, (aaa.inv_bc_amt-aaa.paid_amt_bc) bc_balance_amt, aaa.Invoice_Date as Invoice_Date,aaa.supplierId,aaa.supplier,aaa.partyInvoiceDt,aaa.partyInvoiceNo,aaa.dueDt from ( select cbpinv.invoice_no,pih.company_code as companyCode,e.entity_name as supplier, e.entity_id as supplierId,to_char(pih.invoice_dt ,'DD/MM/YYYY')Invoice_Date , cbpinv.inv_bc_amt,cbpinv.currency, cbpinv.ex_rate, "
			+ " sum(cbpinv.payable_bc_amt) paid_amt_bc, sum(cbpinv.payable_tc_amt) paid_amt_tc,to_char(pih.partyinvoice_dt ,'DD/MM/YYYY')partyInvoiceDt,pih.partyinvoice_no as partyInvoiceNo, to_char(pih.due_dt ,'DD/MM/YYYY') dueDt from payment_order_detail cbpinv left join purchase_invoice_hdr pih on pih.invoice_no = cbpinv.invoice_no left join entity e on e.supplier_acct_code=pih.supplier "
			+ " group by cbpinv.invoice_no,pih.company_code,cbpinv.currency,cbpinv.ex_rate,Invoice_Date,supplier,supplierId,partyInvoiceDt,partyInvoiceNo,dueDt,cbpinv.inv_bc_amt ) aaa where aaa.invoice_no in (select invoice_no from purchase_invoice_hdr where supplier=? and payment_status not like 'Fully Paid%' and invoice_dt >=to_date(?,'dd/mm/yyyy') and invoice_dt <=to_date(?,'dd/mm/yyyy') ) and (aaa.inv_bc_amt-aaa.paid_amt_bc)>0 and aaa.companycode=?  "
			+ " group by invoice_no,aaa.companyCode,inv_bc_amt,currency,ex_rate, paid_amt_bc,paid_amt_tc,Invoice_Date,supplierId,supplier,partyInvoiceDt,partyInvoiceNo,dueDt union select pih.invoice_no,pih.company_code as companyCode,pih.amount as inv_bc_amt, pih.currency, pih.ex_rate as ex_rate, pih.amount as paid_amt_bc,pih.tc_amount as paid_amt_tc,pih.amount as bc_balance_amt,to_char(pih.invoice_dt ,'DD/MM/YYYY')Invoice_Date, "
			+ " e.entity_id as supplierId,e.entity_name as supplier,to_char(pih.partyinvoice_dt ,'DD/MM/YYYY')partyInvoiceDt, pih.partyinvoice_no as partyInvoiceNo, to_char(pih.due_dt ,'DD/MM/YYYY') dueDt from purchase_invoice_hdr pih left join entity e on e.supplier_acct_code=pih.supplier where pih.supplier=? and payment_status not like 'Fully Paid%' and invoice_dt >=to_date(?,'dd/mm/yyyy') and invoice_dt <=to_date(?,'dd/mm/yyyy') and pih.company_code = ? and pih.invoice_no not in(select invoice_no from payment_order_detail)) T1  "
			+ " union select gpi.invoice_no,gpi.company_code as companyCode,gpi.amount as inv_bc_amt,gpi.currency,gpi.ex_rate,gpi.amount as paid_amt_bc,gpi.amount as paid_amt_tc,gpi.amount as bc_balance_amt, to_char(gpi.invoice_dt,'dd/mmy/yyyy') Invoice_Date, e.entity_id as supplierId,e.entity_name as supplier,to_char(gpi.invoice_dt ,'DD/MM/YYYY')partyInvoiceDt, gpi.partyinvoice_no as partyInvoiceNo, to_char(gpi.invoice_dt ,'DD/MM/YYYY') dueDt "
			+ " from general_purchase_invoice_hdr gpi left join entity e on e.supplier_acct_code=gpi.supplier where gpi.supplier=? and gpi.invoice_dt >=to_date(?,'dd/mm/yyyy') and invoice_dt <=to_date(?,'dd/mm/yyyy') and  gpi.company_code = ? ";
	/*
	 * public static final String GET_PAY_ORDER_LIST =
	 * "select COALESCE(invoice_no,'') as Invoice_no, COALESCE(inv_bc_amt,0) invBcAmt, COALESCE(currency,'') currencyCode, "
	 * +
	 * " COALESCE(ex_rate,0) exchangeRate, COALESCE(paid_amt_bc,0) payableBcAmt, COALESCE(paid_amt_tc,0) payableTcAmt, COALESCE(bc_balance_amt,0) bcBalanceAmt, "
	 * +
	 * "Invoice_Date,supplierId,supplier,partyInvoiceDt,partyInvoiceNo,dueDt from ( "
	 * + "select aaa.invoice_no, aaa.inv_bc_amt, aaa.currency, aaa.ex_rate, " +
	 * "paid_amt_bc,  paid_amt_tc, (aaa.inv_bc_amt-aaa.paid_amt_bc)  bc_balance_amt, "
	 * +
	 * " aaa.Invoice_Date as Invoice_Date,aaa.supplierId,aaa.supplier,aaa.partyInvoiceDt,aaa.partyInvoiceNo,aaa.dueDt "
	 * + "from ( " +
	 * "select  cbpinv.invoice_no,e.entity_name as supplier, e.entity_id as supplierId,to_char(pih.invoice_dt ,'DD/MM/YYYY')Invoice_Date ,  cbpinv.inv_bc_amt,cbpinv.currency, cbpinv.ex_rate, "
	 * +
	 * "sum(cbpinv.payable_bc_amt) paid_amt_bc, sum(cbpinv.payable_tc_amt) paid_amt_tc,to_char(pih.partyinvoice_dt ,'DD/MM/YYYY')partyInvoiceDt,pih.partyinvoice_no partyInvoiceNo, "
	 * + "to_char(pih.due_dt ,'DD/MM/YYYY') dueDt from payment_order_detail cbpinv "
	 * + "left join purchase_invoice_hdr pih on pih.invoice_no = cbpinv.invoice_no "
	 * + "left join entity e on e.supplier_acct_code=pih.supplier " +
	 * "group by cbpinv.invoice_no,cbpinv.currency,cbpinv.ex_rate,Invoice_Date,supplier,supplierId,partyInvoiceDt,partyInvoiceNo,dueDt,cbpinv.inv_bc_amt "
	 * + ") aaa " +
	 * "where aaa.invoice_no in (select invoice_no  from purchase_invoice_hdr where supplier=?  and payment_status not like 'Fully Paid%' and "
	 * +
	 * "invoice_dt >=to_date(?,'dd/mm/yyyy') and invoice_dt <=to_date(?,'dd/mm/yyyy')  ) and (aaa.inv_bc_amt-aaa.paid_amt_bc)>0 "
	 * +
	 * " group by invoice_no,inv_bc_amt,currency,ex_rate,  paid_amt_bc,paid_amt_tc,Invoice_Date,supplierId,supplier,partyInvoiceDt,partyInvoiceNo,dueDt "
	 * + "union " + "select pih.invoice_no,  pih.amount as inv_bc_amt, " +
	 * " pih.currency, pih.ex_rate as ex_rate, " +
	 * "pih.amount as paid_amt_bc,pih.tc_amount as paid_amt_tc,pih.amount as bc_balance_amt,to_char(pih.invoice_dt ,'DD/MM/YYYY')Invoice_Date, "
	 * +
	 * "e.entity_id as supplierId,e.entity_name as supplier,to_char(pih.partyinvoice_dt ,'DD/MM/YYYY')partyInvoiceDt,  pih.partyinvoice_no partyInvoiceNo, "
	 * + "to_char(pih.due_dt ,'DD/MM/YYYY') dueDt " +
	 * "from purchase_invoice_hdr pih " +
	 * "left join entity e on e.supplier_acct_code=pih.supplier " +
	 * "where pih.supplier=? and payment_status not like 'Fully Paid%' and " +
	 * "invoice_dt >=to_date(?,'dd/mm/yyyy') and invoice_dt <=to_date(?,'dd/mm/yyyy') and "
	 * +
	 * "pih.invoice_no not in(select invoice_no from payment_order_detail)) T1 order by invoice_no desc;"
	 * ;
	 */
	public static final String SAVE_PAYMENT_ORDER_HDR = "INSERT INTO payment_order(payment_order_no,created_by,company_code,supplier,po_tcamt,po_bcamt,status,payment_order_date) VALUES (?,?,?,?,?,?,?,to_date(?,'DD/MM/YYYY'))";

	public static final String GET_PAYMENT_ORDER_NUMBER = "SELECT CASE WHEN MAX(payment_order_no) IS NULL  THEN 'POR00001' ELSE 'POR'|| lpad(cast(max(cast(SUBSTRING(payment_order_no,4,10) as int)+1) as text),5,'0') END from payment_order";

	public static final String SAVE_PAYMENT_ORDER_DETAIL = "INSERT INTO payment_order_detail(payment_order_no,party_invoice_no,party_invoice_dt,invoice_no,invoice_dt,inv_bc_amt,inv_tc_amt,payable_tc_amt,payable_bc_amt,company_code,currency,ex_rate,due_date) VALUES (?,?,to_date(?,'DD/MM/YYYY'),?,to_date(?,'DD/MM/YYYY'),?,?,?,?,?,?,?,to_date(?,'DD/MM/YYYY'))";

	public static final String GET_PAYMENT_ORDER_LIST = "select payment_order.payment_order_no,to_char(payment_order.payment_order_date,'DD/MM/YYYY') payment_order_date, payment_order.supplier,e.entity_name as supplierName,payment_order.status,po_tcamt,po_bcamt from payment_order left join  entity as e on e.supplier_acct_code=payment_order.supplier where payment_order.status='Pending' order by payment_order_no desc";

	public static final String GET_POR_DTL_LIST = "select payment_order_detail_id,payment_order_no,party_invoice_no,payment_order_dt,invoice_no,to_char(party_invoice_dt,'DD/MM/YYY') party_invoice_dt, " + " to_char(invoice_dt,'DD/MM/YYY') invoiceDate , to_char(due_date,'DD/MM/YYY') dueDt, inv_bc_amt,inv_tc_amt,payable_bc_amt,payable_tc_amt,currency as currencyCode , " + " ex_rate as exchangeRate,(inv_bc_amt-payable_bc_amt) bcBalanceAmt,(inv_tc_amt-payable_tc_amt) tcBalanceAmt from payment_order_detail where payment_order_no=?";

	public static final String GET_POR_HDR = "select to_char(payment_order.payment_order_date,'DD/MM/YYYY') payment_order_date, payment_order.payment_order_no,payment_order.po_bcamt,payment_order.po_tcamt,payment_order.supplier,e.entity_name as supplierName,payment_order.status from payment_order " + "left join  entity as e on e.supplier_acct_code=payment_order.supplier where payment_order_no=?";

	public static final String UPDATE_POR_HDR = "update payment_order set po_bcamt=? , po_tcamt=? where payment_order_no=?";

	public static final String UPDATE_POR_DTL = "update payment_order_detail set payable_bc_amt=? , payable_tc_amt=? where payment_order_detail_id=?";

	public static final String DELETE_POR_HDR = "delete from payment_order where payment_order_no=?";

	public static final String DELETE_POR_DTL = "delete from payment_order_detail where payment_order_no=?";

	public static final String UPDATE_POR_HDR_STATUS = "update payment_order set status=? , approved_by=?, approved_dt=to_date(?,'DD/MM/YYYY')  where payment_order_no=?";

	public static final String GET_TOTAL_PAYABLE_AMOUNT = "select invoice_no, coalesce(sum(payable_tc_amt),0) totalPaidTcAmt, coalesce(sum(payable_bc_amt),0) totalPaidBcAmt , " + "coalesce(inv_bc_amt-sum(payable_bc_amt),0) bcBalanceAmt " + "from  payment_order_detail where invoice_no=? " + "group by invoice_no,inv_bc_amt";

	public static final String GET_PAYMENT_ORDER_LIST_DRAFT = "select payment_order.payment_order_no,to_char(payment_order.payment_order_date,'DD/MM/YYYY') payment_order_date, payment_order.supplier,e.entity_name as supplierName,payment_order.status from payment_order left join  entity as e on e.supplier_acct_code=payment_order.supplier where payment_order.status='Approved' order by payment_order_no desc";;

	public static String GET_COMPANY_ID = "select COMPANY_CODE from employee_master where emp_id = ? ";

}
