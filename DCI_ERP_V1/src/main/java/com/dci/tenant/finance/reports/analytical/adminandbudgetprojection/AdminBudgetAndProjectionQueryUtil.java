package com.dci.tenant.finance.reports.analytical.adminandbudgetprojection;

public class AdminBudgetAndProjectionQueryUtil {

	public static final String GET_PREV_YEAR_VOLUME_EXPECTATION =  "select M20,M40,L20,L40,totalTues from (select nvl(sum(M20),0) as M20,nvl(sum(M40+m45),0) as M40, "
			+ " nvl(sum(D20+OOG20+R20+RI20+IMCO_20+FLEXI_20),0) as L20, "
			+ " nvl(sum(D40+OOG40+R40+RI40+IMCO_40+FLEXI_40),0) as L40,sum((M20+D20+OOG20+R20+RI20+IMCO_20+FLEXI_20+oog_slot_loss) +2*(M40+m45+D40+D45+OOG40+R40+RI40+IMCO_40+FLEXI_40)) totalTues  from loading_summary lc "
			+ "			 where  to_char(loading_dt,'YYYY')::int =? and approved_by is not Null "
			+ "			 ) A";

	public static final String GET_PREV_YEAR_TOTAL_TUES_FOR_VOLUME_EXPECT = "select sum(no_of_teus) AS totalTues from loading where  substr(to_char(loading_dt,'mm/dd/yyyy'),7,4)=? and approved_by is not Null";

	public static final String SAVE_ADMIN_BUDGET_DATA = "INSERT INTO ADMIN_BUDJET_PROJ (BUDJET_ID, FROM_DT, TO_DT, COST_CENTER, ACCT_HEAD_CODES, CURR_VOL_EXP, PREV_EMPTY, PREV_LADEN, PREV_TOTAL_TEUS, "
			+ "CURR_VAR_EXP, PREV_VAR_EXP, CURR_PER_TEU_COST, PREV_PER_TEU_COST, CURR_TOT_ACCT_HEAD, PRV_TOT_ACCT_HEAD, CURR_TOTA_COST_CTR, PRV_TOTAL_COST_CTR, "
			+ "CURR_TOTAL_PERIOD, PRV_TOTAL_PERIOD, CURR_INC_DEC) values(?,to_date(?,'DD/MM/YYYY'),to_date(?,'DD/MM/YYYY'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

	public static final String AUTO_GEN_ADMIN_BUDGET_NO = "SELECT CASE WHEN MAX(BUDJET_ID) IS NULL THEN ? ELSE rpad(to_char(rpad(?,2)),2)|| "
			+ "lpad(to_char(MAX(TO_NUMBER(SUBSTR(BUDJET_ID,3))+1)),5,0) END as BUDJET_ID FROM ADMIN_BUDJET_PROJ ";

	public static final String GET_ADMIN_BUDGET_HDR_LIST = "SELECT DISTINCT BUDJET_ID AS budgetNo, TO_CHAR(FROM_DT,'DD/MM/YYYY') AS fromDate, TO_CHAR(TO_DT,'DD/MM/YYYY') AS toDate, "
			+ "COALESCE(COST_CENTER,'') costCentre, COALESCE(ACCT_HEAD_CODES,'') AS accountHead, COALESCE(AHM.ACCT_HEAD_NAME,'') AS accountHeadName,  "
			+ "COALESCE(CURR_INC_DEC,'') AS increaseDecrease FROM ADMIN_BUDJET_PROJ ABJ "
			+ "LEFT JOIN ACCOUNT_HEAD_MASTER AHM ON AHM.ACCT_HEAD_CODE = ABJ.ACCT_HEAD_CODES " + "ORDER BY BUDJET_ID DESC";
}
