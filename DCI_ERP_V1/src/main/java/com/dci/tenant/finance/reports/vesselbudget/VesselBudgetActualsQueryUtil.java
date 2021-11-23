package com.dci.tenant.finance.reports.vesselbudget;

public class VesselBudgetActualsQueryUtil {
	/*public static final String GET_BUDGET_ACTUAL_LIST = "select vb.company_code as companyCode,c.short_name as companyName,vb.VESSEL_CODE as vesselId,v.VESSEL_NAME as vesselName,v.VESSEL_CODE as vesselCode, "
			+" ah.acct_head_name as departmentName,ah.acct_head_name as budgetDesc,TO_CHAR(vb.TO_DATE,'DD-MM-YYYY') toDate, "
			+" TO_CHAR(vb.FROM_DATE,'DD-MM-YYYY') fromDate,vb.BUDGET_CODE as budgetCode,vb.ALLOCATED_AMOUNT as allocatedTotalAmount "
			+" from FI_VESSEL_BUDGETS vb inner join 	 account_head_master ah on vb.BUDGET_CODE=ah.acct_head_code " 		
			+" inner join vessel_master v on v.VESSEL_CODE=vb.VESSEL_CODE " 
			+" inner join company_master c on c.company_code=vb.company_code order by vb.TO_DATE desc";*/
	
	public static final String GET_BUDGET_ACTUAL_LIST = "select vb.company_code as vesselCode,c.short_name as vesselName,TO_CHAR(vb.FROM_DATE,'DD-MM-YYYY') as fromDate,"
			+"TO_CHAR(vb.TO_DATE,'DD-MM-YYYY') as toDate from FI_VESSEL_BUDGETS vb inner join company_master c  on vb.company_code = c.company_code "
			+" group by c.short_name,vb.company_code,vb.FROM_DATE,vb.TO_DATE order by vb.TO_DATE desc";
	
	public static final String GET_BUDGET_ACTUAL_VESSEL = "select distinct vb.VESSEL_CODE as vesselCode,v.VESSEL_NAME as vesselName,v.VESSEL_SHORT_NAME,TO_CHAR(vb.TO_DATE,'DD-MM-YYYY') toDate,TO_CHAR(vb.FROM_DATE,'DD-MM-YYYY') fromDate "
			+ " from DANAOS_VESSEL_BUDGETS vb inner join DANAOS_VESSEL_DATA v on v.VESSEL_CODE=vb.VESSEL_CODE "
			+ " where v.VESSEL_SHORT_NAME=? and vb.to_date=TO_DATE(?,'dd/mm/yyyy')";
/*	public final static String GET_VESSEL = "select vessel_code as id,vessel_name as text from vessel_master where vessel_code in('INMU','INSY','MARC') order by vessel_name";
*/	
	/*public final static String GET_VESSEL ="select distinct ves.VESSEL_NAME as id ,ves.VESSEL_NAME as text,ves.VESSEL_CODE from DANAOS_VESSEL_BUDGETS vb "  
		 +" inner join DANAOS_VESSEL_DATA ves on vb.VESSEL_CODE = ves.VESSEL_CODE  ";*/
	
	public final static String GET_VESSEL ="select company_code as id,short_name as text from company_master  order by company_code";
	
	public static final String GET_ALLOCATED_AMOUNT = "select vb.VESSEL_CODE,v.VESSEL_NAME,v.VESSEL_SHORT_NAME,d.NAME,db.BUDGET_DESCRIPTION,TO_CHAR(vb.TO_DATE,'DD-MM-YYYY') TO_DATE,TO_CHAR(vb.FROM_DATE,'DD-MM-YYYY') FROM_DATE,vb.BUDGET_CODE,vb.ALLOCATED_AMOUNT from DANAOS_VESSEL_BUDGETS vb inner join "
			+ " DANAOS_DEPARTMENT_BUDGETS db on vb.BUDGET_CODE=db.BUDGET_CODE  "
			+ " inner join DANAOS_DEL_DEPARTMENTS d on db.DEPARTMENT_CODE=d.CODE  "
			+ " inner join DANAOS_VESSEL_DATA v on v.VESSEL_CODE=vb.VESSEL_CODE "
			+ " where v.VESSEL_SHORT_NAME=? and vb.to_date=TO_DATE(?,'dd/mm/yyyy')  " + "  order by d.NAME asc";
	public static final String GET_ALLOCATED_COUNT = "select count(*) from DANAOS_VESSEL_BUDGETS vb inner join  "
			+ " DANAOS_DEPARTMENT_BUDGETS db on vb.BUDGET_CODE=db.BUDGET_CODE  "
			+ " inner join DANAOS_DEL_DEPARTMENTS d on db.DEPARTMENT_CODE=d.CODE  "
			+ " inner join DANAOS_VESSEL_DATA v on v.VESSEL_CODE=vb.VESSEL_CODE  "
			+ " where v.VESSEL_SHORT_NAME=? and vb.to_date=TO_DATE(?,'dd/mm/yyyy')  " + " order by d.NAME asc";

	public static final String GET_PIN_AMOUNT = "select coalesce(sum(tc_amount),0) as tc_amount,coalesce(sum(bc_amount),0) as bc_amount from ("
			+ " select distinct hdr.invoice_no,hdr.tc_amount,hdr.bc_amount from PURCHASE_INVOICE_HDR hdr,PURCHASE_INVOICE_DTL dtl,DANAOS_VESSEL_DATA ves,DANAOS_DEL_DEPARTMENTS d "
			+ " where hdr.invoice_no=dtl.PURCHASE_INV_NO " + " and dtl.VESSEL=ves.vessel_short_name and dtl.DEPARTMENT=d.CODE "
			+ " and ves.vessel_name=? " + " and d.name=?" + " and invoice_dt>=to_date(?,'dd-mm-yyyy') " + " and invoice_dt<=to_date(?,'dd-mm-yyyy')) aa";
	public static final String GET_CBP_AMOUNT = "select coalesce(sum(rcd_amt_local),0) as tc_amount ,coalesce(sum(rcd_amt_usd),0) as bc_amount from CB_PAYMENT_INVOICE_DTL where invoice in("
			+ " select distinct hdr.invoice_no from PURCHASE_INVOICE_HDR hdr,PURCHASE_INVOICE_DTL dtl,DANAOS_VESSEL_DATA ves,DANAOS_DEL_DEPARTMENTS d "
			+ " where hdr.invoice_no=dtl.PURCHASE_INV_NO "
			+ " and dtl.VESSEL=ves.vessel_short_name and dtl.DEPARTMENT=d.CODE "
			+ " and ves.vessel_name=? " + " and d.name=?" + " and invoice_dt>=to_date(?,'dd-mm-yyyy') " + " and invoice_dt<=to_date(?,'dd-mm-yyyy'))";
	
	public static final String GET_BUDGET_ALLOCATION_HDR = "select ves.VESSEL_NAME as vesselName,TO_CHAR(FROM_DATE,'DD-MM-YYYY') fromDate,TO_CHAR(TO_DATE,'DD-MM-YYYY') toDate,sum(ALLOCATED_AMOUNT) as allocatedTotalAmount,sum(FIRST_QUARTER) as firstQuarterAmount," + " sum(SECOND_QUARTER) as secondQuarterAmount, sum(THIRD_QUARTER) as thirdQuarterAmount, sum(FOURTH_QUARTER)  as fourthQuarterAmount " + " from DANAOS_VESSEL_BUDGETS vb inner join DANAOS_VESSEL_DATA ves on vb.VESSEL_CODE = ves.VESSEL_CODE inner join DANAOS_DEPARTMENT_BUDGETS db on vb.BUDGET_CODE=db.BUDGET_CODE "
			+ " where ves.VESSEL_NAME=? and FROM_DATE =TO_DATE(?,'dd/mm/yyyy')  and TO_DATE =TO_DATE(?,'dd/mm/yyyy') " + " group by  ves.VESSEL_NAME,FROM_DATE,TO_DATE";
	
	public static final String GET_BUDGET_ALLOCATION_DTL = "select distinct ves.VESSEL_NAME,ah.acct_head_name as budgetDesc1,vb.BUDGET_CODE as budgetCode,ah.acct_head_code acctHeadCode,"
			+"ah.acct_head_name as budgetDesc,coalesce(debit,0) as debitAmt,coalesce(credit,0) as creditAmt,coalesce(debit,0) -coalesce(credit,0) as actualAmt,"
			+"TO_CHAR(vb.FROM_DATE,'DD-MM-YYYY') FROM_DATE,TO_CHAR(vb.TO_DATE,'DD-MM-YYYY') TO_DATE,ALLOCATED_AMOUNT as allocatedAmount,"
			+"FIRST_QUARTER as firstQuarterAmount,SECOND_QUARTER as secondQuarterAmount, THIRD_QUARTER as thirdQuarterAmount,"
			+"FOURTH_QUARTER  as fourthQuarterAmount,vb.company_code as companyCode,c.short_name as companyName from FI_VESSEL_BUDGETS vb "  
			+" left join vessel_master ves on vb.VESSEL_CODE = ves.VESSEL_CODE "  
			+" inner join account_head_master ah on ah.acct_head_code=vb.BUDGET_CODE " 
			+" inner join company_master c on vb.company_code=c.company_code "
			+" left join (select coalesce(sum(debit),0) as debit ,coalesce(sum(credit),0) as credit,account_head,company_code from general_ledger " 
			+" where ledger_dt between  to_date(?,'dd/mm/yyyy')  and to_date(?,'dd/mm/yyyy') "
			+" group by account_head,company_code) gl on gl.account_head=ah.ACCT_HEAD_CODE " 
			+" and   c.company_code=gl.company_code where ah.acct_head_code not like  all('{\"1%\", \"2%\",\"3%\"}') and c.short_name=? and vb.FROM_DATE =TO_DATE(?,'dd/mm/yyyy')  and vb.TO_DATE =TO_DATE(?,'dd/mm/yyyy') order by ah.acct_head_code ";

	public static final String GET_BUDGET_ALLOCATION_DTL_QUARTER = "select distinct ves.VESSEL_NAME,ah.acct_head_name as budgetDesc1,vb.BUDGET_CODE as budgetCode,ah.acct_head_code acctHeadCode,"
			+"ah.acct_head_name as budgetDesc,coalesce(debit,0) as debitAmt,coalesce(credit,0) as creditAmt,coalesce(debit,0) -coalesce(credit,0) as actualAmt,"
			+"TO_CHAR(vb.FROM_DATE,'DD-MM-YYYY') FROM_DATE,TO_CHAR(vb.TO_DATE,'DD-MM-YYYY') TO_DATE,ALLOCATED_AMOUNT as allocatedAmount,"
			+"FIRST_QUARTER as firstQuarterAmount,SECOND_QUARTER as secondQuarterAmount, THIRD_QUARTER as thirdQuarterAmount,"
			+"FOURTH_QUARTER  as fourthQuarterAmount,vb.company_code as companyCode,c.short_name as companyName from FI_VESSEL_BUDGETS vb "  
			+" left join vessel_master ves on vb.VESSEL_CODE = ves.VESSEL_CODE "  
			+" inner join account_head_master ah on ah.acct_head_code=vb.BUDGET_CODE " 
			+" inner join company_master c on vb.company_code=c.company_code "
			+" left join (select coalesce(sum(debit),0) as debit ,coalesce(sum(credit),0) as credit,account_head,company_code from general_ledger " 
			+" where ledger_dt between  to_date(?,'dd/mm/yyyy')  and to_date(?,'dd/mm/yyyy') "
			+" group by account_head,company_code) gl on gl.account_head=ah.ACCT_HEAD_CODE " 
			+" and   c.company_code=gl.company_code where ah.acct_head_code not like  all('{\"1%\", \"2%\",\"3%\"}') and c.short_name=? and vb.FROM_DATE =TO_DATE(?,'dd/mm/yyyy')  and vb.TO_DATE =TO_DATE(?,'dd/mm/yyyy') order by ah.acct_head_code "; 

	public static final String SAVE_BUDGET_ALLOC="INSERT INTO fi_vessel_budgets(company_code, vessel_code, budget_code, from_date, to_date, allocated_amount, " 
			+" first_quarter, second_quarter, third_quarter, fourth_quarter,comments, created_by, created_dt) "
			+ "VALUES (?, ?, ?, to_date(?,'dd/mm/yyyy'), to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?, ?, now())";
	
	
}
