/*package com.mailapp.hospital.accounts.closingaccounts;

public class ClosingAccountsQueryUtil {

	public static final String CALL_FUNCTION_NEW_OPENING_BALANCE = "select * from FN_OPENINGBALANCE(?)";

	public static final String GET_SUB_GROUP_DATA = "select acct_head_code,acct_head_name,coalesce(debit,0) debit, " + "coalesce(credit,0) credit,coalesce(debit,0)-coalesce(credit,0) as balance,sub_group_code,coalesce(local_debit,0) localdebit, " + "coalesce(local_credit,0) localcredit,coalesce(local_debit,0)-coalesce(local_credit,0) as local_balance from " + "new_opening_balance where sub_group_code ";

	public static String GET_ACCOUT_DETAILS = " SELECT  parent_code,Account_CODE,acct_head_name,DEBIT,CREDIT,DEBIT-CREDIT  as balance,LOCALDEBIT,LOCALCREDIT,LOCALDEBIT-LOCALCREDIT as local_balance FROM( " + " select  parent_code,Account_CODE,acct_head_name,sum(case when tc_debit is null then 0 else tc_debit END) AS DEBIT,sum(case when tc_credit is null then 0 else tc_credit  END) AS CREDIT,sum(case when bc_debit is null then 0 else bc_debit END)" + "  AS LOCALDEBIT,sum(case when tc_credit is null then 0 else tc_credit END) AS LOCALCREDIT "
			+ "  from  general_ledger,account_head_master where " + "  Account_CODE=acct_head_code AND to_char(ledger_date,'dd/mm/yyyy') <=? group by parent_code,Account_CODE,acct_head_name " +

			" union all " + "   select  parent_code,Account_CODE,entity_name as acct_head_name,sum(case when tc_debit is null then 0 else tc_debit END) AS DEBIT,sum(case when tc_credit is null then 0 else tc_credit  END) AS CREDIT,sum(case when bc_debit is null then 0 else bc_debit END)" + "   AS LOCALDEBIT,sum(case when tc_credit is null then 0 else tc_credit END) AS LOCALCREDIT " + "   from  general_ledger,entity where entity.is_vendor=true and "
			+ "  Account_CODE=supplier_acct_code AND to_char(ledger_date,'dd/mm/yyyy') <=? group by parent_code,Account_CODE,acct_head_name " +

			" union all " + "  select  parent_code,Account_CODE,entity_name as acct_head_name,sum(case when tc_debit is null then 0 else tc_debit END) AS DEBIT,sum(case when tc_credit is null then 0 else tc_credit  END) AS CREDIT,sum(case when bc_debit is null then 0 else bc_debit END)" + " 	  AS LOCALDEBIT,sum(case when tc_credit is null then 0 else tc_credit END) AS LOCALCREDIT " + " 	  from  general_ledger,entity where entity.is_customer=true and "
			+ " 	 Account_CODE=customer_acct_code AND to_char(ledger_date,'dd/mm/yyyy') <=? group by parent_code,Account_CODE,acct_head_name " + " ) a where parent_code ";

	public static String GET_GROUP_HEAD_NAME = "select  group_head_id  from group_head_master where group_head_name =?";

	public static final String GET_JOURNAL_NO_AUTOGENERATE = "SELECT CASE WHEN MAX(JOURNAL_NO) IS NULL " + "THEN ? ELSE rpad(MAX(JOURNAL_NO),5,'JV')||  " + "lpad(cast(cast((SUBSTRING(MAX(JOURNAL_NO),5)) as int)+1 " + "as text),4,'0') END as JOURNAL_NO FROM JOURNALVOUCHER_HDR where JOURNAL_NO like ?";

	public static String SAVE_JOURNAL_VOUCHER_HEADER = "INSERT INTO JOURNALVOUCHER_HDR(JOURNAL_NO, JOURNAL_DATE, JOURNAL_NARRATION, JOURNAL_CREATED_BY, JOURNAL_CREATED_DT, JOURNAL_COMPANY_CODE) VALUES(?,?, ?, ?, current_date, ?) ";

	public static String ADD_JOURNAL_VOUCHER_DTL = "INSERT INTO JOURNALVOUCHER_DTL (JOURNAL_NO,JOURNAL_ACCOUNT_HEAD,JOURNAL_CURRENCY,JOURNAL_EXCHANGE_RATE,JOURNAL_DEBIT, " + "JOURNAL_CREDIT,JOURNAL_NARRATION,SUB_GROUP_CODE,  " + "JOURNAL_DEBITUSD,JOURNAL_CREDITUSD,SL_NO) " + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

	public static final String INSERT_CLOSING_ACCOUNT_DETAILS = "insert into closing_account_head (acct_head_code,income_exp_debit,income_exp_credit,income_exp_bal,acct_head_status,closing_acc_code,acct_type, " + "to_date,created_by,created_dt,company_code) values(?,?,?,?,'C',?,?," + "to_date(?,'dd/mm/yyyy'),?,current_date,?)";

	public static final String GENERATE_CLOSING_ACCOUNT_CODE = "SELECT CASE WHEN MAX(CLOSING_ACC_CODE) IS NULL THEN ? ELSE rpad(MAX(CLOSING_ACC_CODE),5,'CA')  " + " || lpad(cast(cast((SUBSTRING(MAX(CLOSING_ACC_CODE),5)) as int)+1 as text),4,'0') END as CLOSING_ACC_CODE " + " FROM closing_account_head where CLOSING_ACC_CODE like ?";

	public static String INSERT_CLOSING_ACCOUNT_ENTRY = "insert into CLOSING_ACCOUNT (CLOSING_ACC_CODE, ACCT_HEAD_CODE," + "DEBIT,CREDIT,COMPANY_CODE,CREATED_BY,CREATED_DT,JV_NUMBER) " + "values(?,?,?,?,?,?,current_date,?)";

	public static final String GET_CLOSING_ACCOUNT_LIST = "select * from(select distinct closing_acc_code as closingAccountCode, " + "to_char(to_date,'dd/mm/yyyy') as finactodate,acct_type as type from  closing_account_head ) T1";

}*/

package com.dci.tenant.finance.closingaccounts;

public class AccountingYearCloseQueryUtil {

	public static final String save_bk = "insert into Accounts_Year_Closed (YEAR_END_DATE ,CLOSED_BY ,ACCT_COMPANY_CODE,CLOSED_DATE) values (to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyy'))";

	// public static final String save =
	// "insert into closing_account (fromdate,todate,created_by,created_dt,company_code,status) "
	// +
	// "values (to_date(:fromdate,'dd/mm/yyyy'),to_date(:todate,'dd/mm/yyyy'),:createdby,now(),:company_id,'Closed')";

	public static final String save = "insert into closing_account (fromdate,todate,created_dt,company_code,status) " + "values (to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),now(),?,'Approved')";

	public static final String open_account = " delete from closing_account where  company_code=? and fromdate =to_date(?,'dd/mm/yyyy') and  todate=to_date(?,'dd/mm/yyyy') ";

	// public static final String list =
	// "select to_char(fromdate,'dd/mm/yyyy') fromdate,to_char(todate,'dd/mm/yyyy') todate,closing_account.created_by,closing_account.company_code,closing_account.created_dt,company_name from closing_account,company_master where  closing_account.company_code=company_master.company_code  and closing_account.status='Closed' order by created_dt desc";
	public static final String list = "select to_char(fromdate,'dd/mm/yyyy') fromdate,to_char(todate,'dd/mm/yyyy') todate,  closing_account.company_code ,c.company_name  as companyName, closing_account_id as closingAccountId from closing_account  left join company_master c on closing_account.company_code =c.company_code ";

	public static final String EDIT = "select company_code as companyId, to_char(fromdate,'dd/mm/yyyy') fromdate,to_char(todate,'dd/mm/yyyy') todate, closing_account_id as closingAccountId from closing_account where closing_account_id=?";

	public static final String DELETE = "delete from closing_account where closing_account_id = ? ";

	public static String dateExists = "select count(*) from closing_account where (fromdate,todate) overlaps (to_date(?,'dd/mm/yyyy')-interval '1' day,to_date(?,'dd/mm/yyyy')+interval '1' day) and status='Closed' and company_code=?";

	public static final String UPDATE = "update closing_account set company_code = ?, fromdate = to_date(?,'dd/mm/yyyy'), todate = to_date(?,'dd/mm/yyyy') where closing_account_id=? ";

}
