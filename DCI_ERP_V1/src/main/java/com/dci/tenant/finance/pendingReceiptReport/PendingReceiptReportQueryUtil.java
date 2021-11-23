package com.dci.tenant.finance.pendingReceiptReport;

public class PendingReceiptReportQueryUtil {
	public static final String SELECT_LIST = "select COALESCE(invoice_no,'') as invoiceNo,invoice_dt,inv_bc_amt,inv_tc_amt,paid_tc_amount,paid_bc_amount,customer,entity_name,balance_amount,due_date ,received_status  ,currency_code " + "from (select aaa.invoice_no,aaa.due_date,aaa.inv_bc_amt, aaa.inv_tc_amt, aaa.paid_bc_amount, aaa.paid_tc_amount,aaa.invoice_dt,aaa.customer,aaa.entity_name,aaa.currency_code, " + "(aaa.inv_tc_amt - aaa.paid_tc_amount) as balance_amount ,aaa.received_status from ( "
			+ "select e.entity_name,cri.invoice_no,cri.inv_bc_amt,cri.inv_tc_amt,gih.invoice_dt,gih.due_date,gih.customer, " + "gih.received_status,sum(cri.paid_bc_amount) paid_bc_amount,sum(cri.paid_tc_amount) paid_tc_amount,cri.currency_code " + "from cashbank_receipt_invoice as cri  left outer join general_invoice_hdr as gih on gih.invoice_no =cri.invoice_no  inner join entity as e on e.customer_acct_code = gih.customer "
			+ "group by cri.invoice_no,due_date,inv_bc_amt,inv_tc_amt,invoice_dt,customer,entity_name,received_status,currency_code) aaa  where aaa.invoice_no  in ( " + "select invoice_no from general_invoice_hdr  where  received_status not like 'Received%' and  due_date < NOW() - INTERVAL '30 days' ) " + "and (aaa.inv_bc_amt-aaa.paid_bc_amount)>0  group by aaa.invoice_no,due_date,inv_bc_amt,inv_tc_amt ,invoice_dt,paid_tc_amount,paid_bc_amount,customer,entity_name,received_status,currency_code "
			+ "union select gi.invoice_no,gi.due_date,gi.amount as inv_bc_amt,gi.tc_amount as inv_tc_amt, 0 as paid_tc_amount ,0 as  paid_bc_amount ,  gi.invoice_dt,gi.customer ,e.entity_name ,gi.currency as currency_code, " + "gi.amount as balance_amount,received_status from  general_invoice_hdr as gi  inner join entity as e on e.customer_acct_code = gi.customer where  gi.received_status not like 'Received%' and "
			+ "due_date < NOW() - INTERVAL '30 days' and gi.invoice_no not in (select invoice_no from cashbank_receipt_invoice) ) T1 order by invoice_no desc;";

	public static final String CUSTOMER_LIST = "select entity.customer_acct_code,entity.email, address.street customerAddress,  city.city_id city, city.city_name cityName, state.state_code stateCode, state.state_name state,city.pincode zipcode, country.country_name country, location.location_name customerLocName from entity left join location on location.location_id = entity.vendor_location left join address on address.address_id = location.address_id left join city on city.city_id = address.city_id left "
			+ " join state on state.state_code = city.state_code left join country on country.country_code = state.country_code where customer_acct_code=?";
}
