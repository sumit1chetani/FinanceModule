package com.dci.tenant.finance.reports.financials.invoiceInformation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.user.UserDetail;
import com.dci.tenant.user.UserMasterQueryUtil;

@Repository
@Transactional("tenantTransactionManager")
public class InvoiceInformationDAOImpl implements InvoiceInformationDAO {

	@Resource
	 private DataSource dataSource;
	
	@Override
	public InvoiceInformationResultBean getValues(String value,String type) {
		// TODO Auto-generated method stub
		InvoiceInformationResultBean objInvoiceInformationResultBean = new InvoiceInformationResultBean();
		String result = "";
		Integer count = 0;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			if(type.equalsIgnoreCase("V")){
				count = jdbcTemplate.queryForObject(InvoiceInformationQueryUtil.SELECT_CREDIT_NOTE, Integer.class, new Object[]{value});
				if(count == 0){
					count = jdbcTemplate.queryForObject(InvoiceInformationQueryUtil.SELECT_DEBIT_NOTE, Integer.class, new Object[]{value});
					if(count == 0){
						count = jdbcTemplate.queryForObject(InvoiceInformationQueryUtil.SELECT_INVOICE, Integer.class, new Object[]{value});
						if(count == 0){
							count = jdbcTemplate.queryForObject(InvoiceInformationQueryUtil.SELECT_GENERAL_INVOICE, Integer.class, new Object[]{value});
							if(count == 0){
								count = jdbcTemplate.queryForObject(InvoiceInformationQueryUtil.SELECT_VOUCHER_ALL, Integer.class, new Object[]{value});
							}
						}
					}
				}
				objInvoiceInformationResultBean.setResultType("Please provide valid Voucher");
			}
			if(type.equalsIgnoreCase("C")){
				count = jdbcTemplate.queryForObject(InvoiceInformationQueryUtil.SELECT_CREDIT_NOTE, Integer.class, new Object[]{value});
				if(count == 0)
					objInvoiceInformationResultBean.setResultType("Please Provide Valid Credit Note");
			}else if(type.equalsIgnoreCase("D")){
				count = jdbcTemplate.queryForObject(InvoiceInformationQueryUtil.SELECT_DEBIT_NOTE, Integer.class,new Object[]{value});
				if(count == 0)
					objInvoiceInformationResultBean.setResultType("Please provide valid Debit Note");
			}else if(type.equalsIgnoreCase("I")){
				count = jdbcTemplate.queryForObject(InvoiceInformationQueryUtil.SELECT_INVOICE, Integer.class, new Object[]{value});
				if(count == 0)
					objInvoiceInformationResultBean.setResultType("Please provide valid Invoice");
			}else if(type.equalsIgnoreCase("G")){
				count = jdbcTemplate.queryForObject(InvoiceInformationQueryUtil.SELECT_GENERAL_INVOICE, Integer.class, new Object[]{value});
				if(count == 0)
					objInvoiceInformationResultBean.setResultType("Please provide valid General Invoice");
				result = jdbcTemplate.queryForObject(InvoiceInformationQueryUtil.SELECT_GENERAL_INVOICE,  new Object[]{value},String.class);
			}else if(type.equalsIgnoreCase("J")){
				count = jdbcTemplate.queryForObject(InvoiceInformationQueryUtil.SELECT_VOUCHER_ALL, Integer.class, new Object[]{value});
				if(count == 0)
					objInvoiceInformationResultBean.setResultType("Please provide valid Journal Voucher");
			}else if(type.equalsIgnoreCase("PI")){
				count = jdbcTemplate.queryForObject(InvoiceInformationQueryUtil.CHECK_PURCHASE_INVOICE, Integer.class, new Object[]{value});
				if(count == 0)
					objInvoiceInformationResultBean.setResultType("Please provide valid Purchase Invoice");
			}else if(type.equalsIgnoreCase("PO")){
				count = jdbcTemplate.queryForObject(InvoiceInformationQueryUtil.CHECK_PAYMENT_ORDER, Integer.class, new Object[]{value});
				if(count == 0)
					objInvoiceInformationResultBean.setResultType("Please provide valid Payment Order");
			}else if(type.equalsIgnoreCase("P")){
				count = jdbcTemplate.queryForObject(InvoiceInformationQueryUtil.CHECK_PAYMENT, Integer.class, new Object[]{value});
				if(count == 0)
					objInvoiceInformationResultBean.setResultType("Please provide valid Payment");
			}else if(type.equalsIgnoreCase("R")){
				count = jdbcTemplate.queryForObject(InvoiceInformationQueryUtil.CHECK_RECEIPT, Integer.class, new Object[]{value});
				if(count == 0)
					objInvoiceInformationResultBean.setResultType("Please provide valid Receipt");
			}
			objInvoiceInformationResultBean.setResult(count);
			objInvoiceInformationResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objInvoiceInformationResultBean;
	}
	
	@Override
	public InvoiceInformationResultBean getList(InvoiceInformation invoiceInformation) {
		// TODO Auto-generated method stub
		InvoiceInformationResultBean objInvoiceInformationResultBean = new InvoiceInformationResultBean();
		List <CreditOrDebitBean> list = 	new ArrayList<CreditOrDebitBean>();
		List <CreditOrDebitBean> creditOrDebitList = new ArrayList<CreditOrDebitBean>();
		List <InvoiceOrGeneralBean> creditOrDebit = new ArrayList<InvoiceOrGeneralBean>();
		List <InvoiceOrGeneralBean> invoiceOrGeneralList = 	new ArrayList<InvoiceOrGeneralBean>();
		List <VoucherOrJournalBean> voucherOrJournalList = 	new ArrayList<VoucherOrJournalBean>();
		List<InvoiceOrOrderBean> purchaseInvoiceList = new ArrayList<InvoiceOrOrderBean>();
		List<InvoiceOrOrderBean> purchaseList = new ArrayList<InvoiceOrOrderBean>();
		List<InvoiceOrOrderBean> paymentOrderList = new ArrayList<InvoiceOrOrderBean>();
		List<PaymentOrReceipt> paymentList = new ArrayList<PaymentOrReceipt>();
		List<PaymentOrReceipt> receiptList = new ArrayList<PaymentOrReceipt>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		List<InvoiceInformation> companyList = getCompanyList(userId);
		String companyCode = "";
		String invoiceNo = "";
		boolean check = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			for(InvoiceInformation detail : companyList){
				if(companyCode.equals("")){
					companyCode += "'" + detail.getCompanyCode() + "'";
				}else{
					companyCode += ",'" + detail.getCompanyCode() + "'";
				}
				
			}
			if(invoiceInformation.getVoucher() != "" && invoiceInformation.getVoucher() != null){
				invoiceInformation.setCreditNote(invoiceInformation.getVoucher());
				invoiceInformation.setDebitNote(invoiceInformation.getVoucher());
				invoiceInformation.setInvoice(invoiceInformation.getVoucher());
				invoiceInformation.setGeneralInvoice(invoiceInformation.getVoucher());
				invoiceInformation.setGeneralVoucher(invoiceInformation.getVoucher());
			}
			if(invoiceInformation.getCreditNote() != "" && invoiceInformation.getCreditNote() != null){
				try{
				invoiceNo = jdbcTemplate.queryForObject(InvoiceInformationQueryUtil.CREDIT_INVOICE_NO,new Object[]{invoiceInformation.getCreditNote()}, String.class);
					check = (invoiceNo.contains("IN") || invoiceNo.contains("IN"));
					if(check){
						String whereCondition= InvoiceInformationQueryUtil.SINGLE_INVOICE + "and co.company_code in ("+companyCode+")";
						creditOrDebitList = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<CreditOrDebitBean>(CreditOrDebitBean.class),new Object[] {invoiceNo});
						whereCondition= InvoiceInformationQueryUtil.SINGLE_DEBIT_BY_CREDIT + "and co.company_code in ("+companyCode+")"; 
						list = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<CreditOrDebitBean>(CreditOrDebitBean.class),new Object[] {invoiceNo});
						creditOrDebitList.addAll(list);
						objInvoiceInformationResultBean.setCreditOrDebitList(creditOrDebitList);
						objInvoiceInformationResultBean.setCreditList(creditOrDebitList);
					}
					check = (invoiceNo.contains("DGI") || invoiceNo.contains("SIG"));
					if(check){
						String whereCondition= InvoiceInformationQueryUtil.GENERAL_INVOICE + "and co.company_code in ("+companyCode+")";
						creditOrDebitList = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<CreditOrDebitBean>(CreditOrDebitBean.class),new Object[] {invoiceNo});
						whereCondition= InvoiceInformationQueryUtil.GENERAL_DEBIT_BY_CREDIT + "and co.company_code in ("+companyCode+")";
						list = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<CreditOrDebitBean>(CreditOrDebitBean.class),new Object[] {invoiceNo});
						creditOrDebitList.addAll(list);
						objInvoiceInformationResultBean.setCreditOrDebitList(creditOrDebitList);
						objInvoiceInformationResultBean.setCreditList(creditOrDebitList);
					}
					
					check = (invoiceNo.contains("SIPIN") || invoiceNo.contains("PIN") || invoiceNo.contains("MAPIN"));
					if(check){
						String whereCondition= InvoiceInformationQueryUtil.PURCHASE_INVOICE + "and co.company_code in ("+companyCode+")";
						creditOrDebitList = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<CreditOrDebitBean>(CreditOrDebitBean.class),new Object[] {invoiceNo});
						whereCondition= InvoiceInformationQueryUtil.PURCHASE_INVOICE_DEBIT_BY_CREDIT + "and co.company_code in ("+companyCode+")";
						list = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<CreditOrDebitBean>(CreditOrDebitBean.class),new Object[] {invoiceNo});
						creditOrDebitList.addAll(list);
						objInvoiceInformationResultBean.setCreditOrDebitList(creditOrDebitList);
						objInvoiceInformationResultBean.setCreditList(creditOrDebitList);
					}
				}catch(EmptyResultDataAccessException e){
					
				}
			}
			if(invoiceInformation.getDebitNote() != "" && invoiceInformation.getDebitNote() != null){
				try{
					invoiceNo = jdbcTemplate.queryForObject(InvoiceInformationQueryUtil.DEBIT_INVOICE_NO,new Object[]{invoiceInformation.getDebitNote()}, String.class);
					check = (invoiceNo.contains("IN") || invoiceNo.contains("IN"));
					if(check){
						String whereCondition= InvoiceInformationQueryUtil.SINGLE_INVOICE + "and co.company_code in ("+companyCode+")";
						creditOrDebitList = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<CreditOrDebitBean>(CreditOrDebitBean.class),new Object[] {invoiceNo});
						whereCondition= InvoiceInformationQueryUtil.SINGLE_CREDIT_BY_DEBIT + "and co.company_code in ("+companyCode+")"; 
						list = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<CreditOrDebitBean>(CreditOrDebitBean.class),new Object[] {invoiceNo});
						creditOrDebitList.addAll(list);
						objInvoiceInformationResultBean.setCreditOrDebitList(creditOrDebitList);
						objInvoiceInformationResultBean.setDebitList(creditOrDebitList);
					}
					check = (invoiceNo.contains("DGI") || invoiceNo.contains("SIG"));
					if(check){
						String whereCondition= InvoiceInformationQueryUtil.GENERAL_INVOICE + "and co.company_code in ("+companyCode+")";
						creditOrDebitList = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<CreditOrDebitBean>(CreditOrDebitBean.class),new Object[] {invoiceNo});
						whereCondition= InvoiceInformationQueryUtil.GENERAL_CREDIT_BY_DEBIT + "and co.company_code in ("+companyCode+")";
						list = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<CreditOrDebitBean>(CreditOrDebitBean.class),new Object[] {invoiceNo});
						creditOrDebitList.addAll(list);
						objInvoiceInformationResultBean.setCreditOrDebitList(creditOrDebitList);
						objInvoiceInformationResultBean.setDebitList(creditOrDebitList);
					}
					
					check = (invoiceNo.contains("SIPIN") || invoiceNo.contains("PIN")|| invoiceNo.contains("MAPIN"));
					if(check){
						String whereCondition= InvoiceInformationQueryUtil.PURCHASE_INVOICE + "and co.company_code in ("+companyCode+") group by ph.invoice_no,co.company_name,pm.payer_name,d.debitnote_no";
						creditOrDebitList = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<CreditOrDebitBean>(CreditOrDebitBean.class),new Object[] {invoiceNo});
						whereCondition= InvoiceInformationQueryUtil.PURCHASE_INVOICE_CREDIT_BY_DEBIT + "and co.company_code in ("+companyCode+")";
						list = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<CreditOrDebitBean>(CreditOrDebitBean.class),new Object[] {invoiceNo});
						creditOrDebitList.addAll(list);
						objInvoiceInformationResultBean.setCreditOrDebitList(creditOrDebitList);
						objInvoiceInformationResultBean.setDebitList(creditOrDebitList);
					}
				}catch(EmptyResultDataAccessException e){
					
				}
			}
			if(invoiceInformation.getInvoice() != "" && invoiceInformation.getInvoice() != null){
				String whereCondition= InvoiceInformationQueryUtil.SINGLE_INVOICE + "and s.company_code in ("+companyCode+")";
				invoiceOrGeneralList = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<InvoiceOrGeneralBean>(InvoiceOrGeneralBean.class),new Object[] {invoiceInformation.getInvoice() });
				whereCondition= InvoiceInformationQueryUtil.SINGLE_CREDIT_BY_DEBIT + "and co.company_code in ("+companyCode+")"; 
				creditOrDebit = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<InvoiceOrGeneralBean>(InvoiceOrGeneralBean.class),new Object[] {invoiceInformation.getInvoice()});
				invoiceOrGeneralList.addAll(creditOrDebit);
				whereCondition= InvoiceInformationQueryUtil.SINGLE_DEBIT_BY_CREDIT + "and co.company_code in ("+companyCode+")"; 
				creditOrDebit = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<InvoiceOrGeneralBean>(InvoiceOrGeneralBean.class),new Object[] {invoiceInformation.getInvoice()});
				invoiceOrGeneralList.addAll(creditOrDebit);
				objInvoiceInformationResultBean.setInvoiceOrGeneralList(invoiceOrGeneralList);
				objInvoiceInformationResultBean.setInvoiceList(invoiceOrGeneralList);
			}
			if(invoiceInformation.getGeneralInvoice() != "" && invoiceInformation.getGeneralInvoice() != null){
				String whereCondition= InvoiceInformationQueryUtil.GENERAL_INVOICE + "and g.gi_company_code in ("+companyCode+")";
				invoiceOrGeneralList = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<InvoiceOrGeneralBean>(InvoiceOrGeneralBean.class),new Object[] {invoiceInformation.getGeneralInvoice() });
				whereCondition= InvoiceInformationQueryUtil.GENERAL_CREDIT_BY_DEBIT + "and co.company_code in ("+companyCode+")"; 
				creditOrDebit = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<InvoiceOrGeneralBean>(InvoiceOrGeneralBean.class),new Object[] {invoiceInformation.getInvoice()});
				invoiceOrGeneralList.addAll(creditOrDebit);
				whereCondition= InvoiceInformationQueryUtil.GENERAL_DEBIT_BY_CREDIT + "and co.company_code in ("+companyCode+")"; 
				creditOrDebit = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<InvoiceOrGeneralBean>(InvoiceOrGeneralBean.class),new Object[] {invoiceInformation.getInvoice()});
				invoiceOrGeneralList.addAll(creditOrDebit);
				objInvoiceInformationResultBean.setInvoiceOrGeneralList(invoiceOrGeneralList);
				objInvoiceInformationResultBean.setGeneralInvoiceList(invoiceOrGeneralList);
			}
			if(invoiceInformation.getGeneralVoucher() != "" && invoiceInformation.getGeneralVoucher() != null){
				String whereCondition= InvoiceInformationQueryUtil.SELECT_BY_JOURNAL_VOUCHER + " and jvh.journal_company_code in ("+companyCode+") group by jvh.journal_no,journal_date,co.company_name";
				voucherOrJournalList = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<VoucherOrJournalBean>(VoucherOrJournalBean.class),new Object[] {invoiceInformation.getGeneralVoucher()});
				objInvoiceInformationResultBean.setVoucherOrJournalList(voucherOrJournalList);
				objInvoiceInformationResultBean.setJournalList(voucherOrJournalList);
			}
			if(invoiceInformation.getPurchaseInvoice() != "" && invoiceInformation.getPurchaseInvoice() != null){
				String whereCondition= InvoiceInformationQueryUtil.SELECT_PURCHASE_INVOICE + " and pinhdr.company_code in ("+companyCode+")";
				purchaseInvoiceList = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<InvoiceOrOrderBean>(InvoiceOrOrderBean.class),new Object[] {invoiceInformation.getPurchaseInvoice()});
				whereCondition= InvoiceInformationQueryUtil.PURCHASE_INVOICE_DEBIT_BY_CREDIT + "and co.company_code in ("+companyCode+")";
				purchaseList = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<InvoiceOrOrderBean>(InvoiceOrOrderBean.class),new Object[] {invoiceInformation.getPurchaseInvoice()});
				purchaseInvoiceList.addAll(purchaseList);
				whereCondition= InvoiceInformationQueryUtil.PURCHASE_INVOICE_CREDIT_BY_DEBIT + "and co.company_code in ("+companyCode+")";
				purchaseList = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<InvoiceOrOrderBean>(InvoiceOrOrderBean.class),new Object[] {invoiceInformation.getPurchaseInvoice()});
				purchaseInvoiceList.addAll(purchaseList);
				objInvoiceInformationResultBean.setPurchaseInvoiceList(purchaseInvoiceList);
			}
			if(invoiceInformation.getPaymentOrder() != "" && invoiceInformation.getPaymentOrder() != null){
				String whereCondition= InvoiceInformationQueryUtil.SELECT_PAYMENT_ORDER + " and po.company_code in ("+companyCode+")";
				paymentOrderList = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<InvoiceOrOrderBean>(InvoiceOrOrderBean.class),new Object[] {invoiceInformation.getPaymentOrder()});
				objInvoiceInformationResultBean.setPaymentOrderList(paymentOrderList);
			}
			if(invoiceInformation.getPayment() != "" && invoiceInformation.getPayment() != null){
				String whereCondition= InvoiceInformationQueryUtil.SELECT_PAYMENT + " and cpayhdr.company_code in ("+companyCode+")";
				paymentList = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<PaymentOrReceipt>(PaymentOrReceipt.class),new Object[] {invoiceInformation.getPayment()});
				objInvoiceInformationResultBean.setPaymentList(paymentList);
			}
			if(invoiceInformation.getReceipt() != "" && invoiceInformation.getReceipt() != null){
				String whereCondition= InvoiceInformationQueryUtil.SELECT_RECEIPT + " and cbr.company_code in ("+companyCode+")";
				receiptList = jdbcTemplate.query(whereCondition, new BeanPropertyRowMapper<PaymentOrReceipt>(PaymentOrReceipt.class),new Object[] {invoiceInformation.getReceipt()});
				objInvoiceInformationResultBean.setReceiptList(receiptList);
			}
			objInvoiceInformationResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objInvoiceInformationResultBean;
	}
	
	private List<InvoiceInformation> getCompanyList(String userId) {
		List<InvoiceInformation> companyList ;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		companyList = jdbcTemplate.query(UserMasterQueryUtil.GET_COMPANY_ID_LIST, new Object[] { userId }, new BeanPropertyRowMapper<InvoiceInformation>(InvoiceInformation.class));
		return companyList;
	}
}