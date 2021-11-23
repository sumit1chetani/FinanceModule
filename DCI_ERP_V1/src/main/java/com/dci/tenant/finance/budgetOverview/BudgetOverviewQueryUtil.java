package com.dci.tenant.finance.budgetOverview;

public class BudgetOverviewQueryUtil {

	// public static String GET_BUDGET_DETAIL = "select budget.*,paidBcAmt from
	// " + "(select sub_group_acct_name Accounts,sub_group_account
	// sub_group_acct_code,Allocated from " + "(select
	// bam.sub_group_account,coalesce(bam.amount,0) Allocated from
	// budget_allocation ba " + "inner join budget_allocation_account_mapping
	// bam on bam.budget_allocation_id = ba.budget_allocation_id " + "where
	// company=? and financial_year = ?) hdr " + "left join
	// sub_group_acct_master sg on sg.sub_group_acct_code =
	// hdr.sub_group_account ) budget "
	// + "inner join (select sub_group_code,sum(dtl.amt_local) paidBcAmt from
	// cashbank_pay_dtl dtl inner join " + "(select * from cashbank_pay_hdr
	// where voucher_dt between ?::DATE and ?::DATE and company_code=?) hdr " +
	// "on hdr.voucher_no = dtl.voucher_no group by sub_group_code ) paid on
	// paid.sub_group_code = budget.sub_group_acct_code";

	public static String GET_BUDGET_DETAIL = "select * from get_budget_overview(?,?)";

	public static String GET_YEAR_LIST = "select financial_year_id as id, financial_year_id as text, financial_year_id as financialyear from financial_year where company_code=?";

	public static String GET_DETAIL_LIST = "select  hdr.paid_to paidTo, dtl.voucher_no cbVoucherNo,to_char(voucher_dt,'dd/mm/yyyy') voucherDate, coalesce(dtl.amt_local,0) loacalAmount, coalesce(dtl.amt_usd,0) loacalUsd,coalesce(hdr.paid_to,'') from cashbank_pay_dtl dtl " + "inner join (select * from cashbank_pay_hdr where voucher_dt between ?::DATE and ?::DATE and company_code=? ) hdr on hdr.voucher_no = dtl.voucher_no " + " where sub_group_code =? order by voucher_dt desc";

}