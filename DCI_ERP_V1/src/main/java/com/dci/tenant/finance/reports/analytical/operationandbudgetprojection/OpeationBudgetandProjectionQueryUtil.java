package com.dci.tenant.finance.reports.analytical.operationandbudgetprojection;

public class OpeationBudgetandProjectionQueryUtil {

	public static final String SELECT_VESSEL = "SELECT vessel_code as vesselCode,vessel_code AS id,vessel_name AS text FROM vessel_master order by vessel_code asc";

	public static final String SELECT_VOYAGE = "SELECT voyage_id AS id, voyage_id AS text  FROM  voyage  WHERE  vessel_id=? AND voyage_id is not null  ORDER BY voyage_id asc";

	public static final String SELECT_SECTOR = "select distinct SECTOR_ID,SECTOR_NAME from voyage_pol_pod_seq";

	public static final String SELECT_SECTOR_CODE = "select distinct SECTOR_ID from voyage_pol_pod_seq where voyage_id=?";

	public static final String INSERT_OPERATION_BUDGET_PROJ = "insert into OPERATION_BUDGET_PROJ (OPERATION_BUDGET_ID,FROM_DT,TO_DT,COST_CENTER,ACCT_HEAD_CODES,CURR_VOL_EXP,PREV_EMPTY,PREV_LADEN,PREV_TOTAL_TEUS,"
			+ "CURR_VAR_EXP,PREV_VAR_EXP,CURR_PER_TEU_COST,PREV_PER_TEU_COST,CURR_TOT_ACCT_HEAD,PRV_TOT_ACCT_HEAD,CURR_TOTA_COST_CTR,PRV_TOTAL_COST_CTR,"
			+ "CURR_TOTAL_PERIOD,PRV_TOTAL_PERIOD,CURR_INC_DEC) values(?,to_date(?,'DD/MM/YYYY'),to_date(?,'DD/MM/YYYY'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String SELECT_OPERATION_MAX_NO = "SELECT CASE WHEN MAX(BUDGET_ID) IS NULL THEN 'BD00001'"
			+ "  ELSE rpad(to_char(rPAD('BD',2)),2)|| " + "lpad(to_char(MAX(TO_NUMBER(SUBSTR(BUDGET_ID,3))+1)),5,0) END"
			+ "  FROM OPERATION_BUDGET_PROJ";

	public static final String AUTO_GEN_OPERATION_BUDGET_NO = "SELECT CASE WHEN MAX(OPERATION_BUDGET_ID) IS NULL THEN ? "
			 	+ "ELSE rpad(rPAD(?,2)::text,2)|| "  
			 	+ "lpad(MAX(SUBSTR(OPERATION_BUDGET_ID,3)::int+1)::text,5,'0') END AS OPERATION_BUDGET_ID   FROM OPERATION_BUDGET_PROJ ";


	public static final String GET_OPERATION_BUDGET_HDR_LIST = "SELECT OPERATION_BUDGET_ID as budgetNo, to_char(FROM_DT,'DD/MM/YYYY') as fromDate, "
			+ "to_char(TO_DT,'DD/MM/YYYY') AS toDate, COALESCE(ACCT_HEAD_CODES,'') as accountHead, COALESCE(AHM.ACCT_HEAD_NAME,'')  as accountHeadName "
			+ "FROM OPERATION_BUDGET_PROJ OBJ " + "LEFT JOIN ACCOUNT_HEAD_MASTER AHM ON AHM.ACCT_HEAD_CODE = OBJ.ACCT_HEAD_CODES "
			+ "ORDER BY OPERATION_BUDGET_ID DESC";
}
