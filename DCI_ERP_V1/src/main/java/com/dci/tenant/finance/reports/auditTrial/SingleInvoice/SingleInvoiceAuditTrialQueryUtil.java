package com.dci.tenant.finance.reports.auditTrial.SingleInvoice;

public class SingleInvoiceAuditTrialQueryUtil {
	
	public static final String SELECT_EMPLOYEE_LIST = "select EMP_ID as id, EMP_NAME as text from EMPLOYEE_MASTER "
			+ "where status='Y' and "
			+ "login_flag='E' and "
			+ "EMP_ID is not null and "
			+ "EMP_NAME is not null ";

	public static String SELECT_SINGLE_INVOICE_LIST(SingleInvoiceAuditTrialBean bean) {
		String whereStr = "";
		String sql = "select INVOICE_NO invoiceNo,to_char(INVOICE_DT,'dd/mm/yyyy') invoiceDate,PAYER_NAME payerName,VOYAGE,VESSEL,POL,POD, "
				+ "QUOTATION_NO quotationNO,to_char(CREATED_DT,'dd/mm/yyyy') createdDate,GET_EMPNAME(CREATED_BY) createdName,CREATED_BY createdBy,to_char(SAILING_DT,'dd/mm/yyyy') sailingDate from INVOICE_AUDIT_TRIAL_VIEW ";
		if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
			whereStr = " where ";
			sql += whereStr + " CREATED_DT >=to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
		}
		if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
			if (whereStr.isEmpty()) {
				whereStr = " where ";
			} else {
				whereStr = " and ";
			}
			sql += whereStr + " CREATED_DT <=to_date('" + bean.getToDate() + "','dd/mm/yyyy') ";
		}
		if(bean.getCustomerCode() != null && !bean.getCustomerCode().isEmpty()){
			if(whereStr.isEmpty()){
				whereStr =" where ";
			}else{
				whereStr = " and ";
			}
			sql +=whereStr +" CREATED_BY='"+bean.getCustomerCode()+"'";
		}
		return sql;
	}

}
