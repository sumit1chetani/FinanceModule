package com.dci.tenant.finance.journalvoucher;

public class JournalVoucherQueryUtil {
	public static final String GET_SECTOR_CODE = "select Sector_Code from sector_master where sector_name=? or Sector_Code=?";
	public static final String UPDATE_GL_ALLOCATED_AMT_BY_LEDGER_ID = "update general_ledger set allocated_amount=" + "(select coalesce(allocated_amount,0)+coalesce(?,0) from general_ledger where ledger_no =?)  " + "where ledger_no =? ";
	public static final String CHECK_ALLOCATED_AMT = "select count(*) from  general_ledger where abs(round(coalesce(debit,0)-coalesce(credit,0)) - round(coalesce(allocated_amount,0))) <= 1  and ledger_no =? ";
	public static String GET_REF_NO_FEEDER_JV = "select replace( ? || to_char(COALESCE(max(substr(REF_NO,6,5))::int,0) +1,'00000'),' ','') from JOURNALVOUCHER_HDR where REF_NO like ?";

	public static String GET_REF_NO_OWNERS_JV = "select replace( ? || to_char( COALESCE(max(substr(REF_NO,6,5))::int,0) +1,'00000'),' ','') from JOURNALVOUCHER_HDR where REF_NO like ?";

	public static String GET_JV_NOS = "select journal_no from journalvoucher_hdr where journal_no between ? and ?";

	public static final String AUTO_GEN_JOURNAL_NO = "select ? || nvl(lpad(to_char(max(to_number(substr(JOURNAL_NO,5)))+1), " + "decode(length(to_char(max(to_number(substr(JOURNAL_NO,5)))+1)),1,5,2,5,3,5,4,5,5,5,  " + "length(to_char(max(to_number(substr(JOURNAL_NO,5)))+1)) ),'0'),'00001') as JOURNAL_NO  " + "from journalvoucher_hdr where JOURNAL_NO like ? ORDER BY JOURNAL_NO DESC";

	public static final String AUTO_GEN_PG_JOURNAL_NO_SIN = "SELECT CASE WHEN MAX(JOURNAL_NO) IS NULL THEN ? ELSE rpad(MAX(JOURNAL_NO),7,?)|| " + "lpad(cast(cast((SUBSTRING(MAX(JOURNAL_NO),7)) as int)+1 as text),4,'0') END AS JOURNAL_NO " + "FROM journalvoucher_hdr where JOURNAL_NO like ?";

	public static final String AUTO_GEN_PG_JOURNAL_NO = "SELECT CASE WHEN MAX(JOURNAL_NO) IS NULL THEN ? ELSE  ?||max(SUBSTRING(JOURNAL_NO,5,100))::int+1 END AS JOURNAL_NO " + "FROM journalvoucher_hdr where JOURNAL_NO like ?";

	public static final String AUTO_GEN_PG_JOURNAL_NO_NEW = "SELECT CASE WHEN MAX(JOURNAL_NO) IS NULL  THEN ? ELSE  ? ||" + " lpad(cast(max(cast(SUBSTRING(JOURNAL_NO,3,10) as int)+1) as text),7,'0')" + " END AS JOURNAL_NO from journalvoucher_hdr where JOURNAL_NO like ?";

	public static final String AUTO_GEN_JOURNAL_NO_SIN = "select ? || nvl(lpad(to_char(max(to_number(substr(JOURNAL_NO,7)))+1), " + "decode(length(to_char(max(to_number(substr(JOURNAL_NO,7)))+1)),1,5,2,5,3,5,4,5,5,5,  " + "length(to_char(max(to_number(substr(JOURNAL_NO,7)))+1)) ),'0'),'00001') as JOURNAL_NO  " + "from journalvoucher_hdr where JOURNAL_NO like ? ORDER BY JOURNAL_NO DESC";

	public static final String AUTO_GEN_JOURNAL_PROV_NO = "select ? || nvl(lpad(to_char(max(to_number(substr(JOURNAL_NO,7)))+1), " + "decode(length(to_char(max(to_number(substr(JOURNAL_NO,7)))+1)),1,5,2,5,3,5,4,5,5,5,  " + "length(to_char(max(to_number(substr(JOURNAL_NO,7)))+1)) ),'0'),'00001') as JOURNAL_NO  " + "from journalvoucher_hdr where JOURNAL_NO like ? ORDER BY JOURNAL_NO DESC";

	public static final String AUTO_GEN_JOURNAL_NO_PROV_SIN = "select ? || nvl(lpad(to_char(max(to_number(substr(JOURNAL_NO,9)))+1), " + "decode(length(to_char(max(to_number(substr(JOURNAL_NO,9)))+1)),1,5,2,5,3,5,4,5,5,5,  " + "length(to_char(max(to_number(substr(JOURNAL_NO,9)))+1)) ),'0'),'00001') as JOURNAL_NO  " + "from journalvoucher_hdr where JOURNAL_NO like ? ORDER BY JOURNAL_NO DESC";

	public static final String GET_JV_STATUS = " select IS_REVERSED from JOURNALVOUCHER_HDR  where JOURNAL_NO =? ";

	public static final String UPDATE_GL_RECON_STATE_BY_LEDGER_ID = "update general_ledger set reconciliation_state ='Y' where ledger_no=?";

	public static final String UPDATE_GL_RECON_STATE_BY_JV_NO = "update general_ledger set reconciliation_state ='Y' where particulars=? and account_head=?";

	public static String UPDATE_JVNO_JV_HDR = "UPDATE JOURNALVOUCHER_HDR SET REVERSE_JV =?,IS_REVERSED='Y' WHERE JOURNAL_NO=?";

	public static final String CHECK_INTRA_COMPANY = "select COALESCE(sum(journal_creditusd),0)-COALESCE(sum(journal_debitusd),0) from journalvoucher_dtl where journal_no=? and  company=?";

	public static final String GET_ACCOUNT_HEAD_LIST_FOR_CONTRA_INTERCOMPANY = "select ACCT_HEAD_CODE as id,ACCT_HEAD_CODE ||' - '|| ACCT_HEAD_NAME as text,ACCT_CURRENCY as currency, " + "COALESCE(ACCT_EXCHANGE_RATE,'1.0') as exchangeRate from ACCOUNT_HEAD_MASTER  where acct_head_status = 'Y' and ACCT_HEAD_CODE like '1003%' " + "union " + "select ACCT_HEAD_CODE as id,ACCT_HEAD_CODE ||' - '|| ACCT_HEAD_NAME as text,ACCT_CURRENCY as currency, "
			+ "COALESCE(ACCT_EXCHANGE_RATE,'1.0') as exchangeRate from ACCOUNT_HEAD_MASTER  where acct_head_status = 'Y' and ACCT_HEAD_CODE like '1002%'";

	public static String GETJOURNALVOUCHERLIST = "SELECT JOURNAL_NO AS jvNumber,to_char(JOURNAL_DATE,'MM/dd/yyyy') AS dataOfIssue,JOURNAL_NARRATION AS narration , JT.NAME AS jvTypeName FROM JOURNALVOUCHER_HDR  AS JH LEFT JOIN JOURNALVOUCHER_TYPE AS JT ON JT.JOURNALVOUCHER_TYPE_ID=JH.JOURNALVOUCHER_TYPE_ID order by JOURNAL_NO desc";
	public static final String ADD_JOURNAL_VOUCHER_HEADER = "INSERT INTO JOURNALVOUCHER_HDR(JOURNAL_NO, JOURNAL_DATE, JOURNAL_NARRATION, JOURNAL_CREATED_BY, JOURNAL_CREATED_DT, JOURNAL_COMPANY_CODE,REF_NO,is_opening_balance) VALUES(?,to_date(?,'dd-mm-yy'), ?, ?, now(), ?,?,?) ";
	public static final String ADD_JOURNAL_VOUCHER_DTL = " INSERT INTO JOURNALVOUCHER_DTL (JOURNAL_NO,JOURNAL_ACCOUNT_HEAD,JOURNAL_CURRENCY,JOURNAL_EXCHANGE_RATE,JOURNAL_DEBIT, " + " JOURNAL_CREDIT,JOURNAL_NARRATION,JOURNAL_DEPARTMENT,JOURNAL_VOYAGE,JOURNAL_VESSEL,JOURNAL_SECTOR,SUB_GROUP_CODE, " + " JOURNAL_DEBITUSD,JOURNAL_CREDITUSD,SL_NO,SUB_ACCOUNT_CODE,EMPLOYEE,PORT,AGENT,LOCATION ,CUSTOMER,SUPPLIER,DESIGNATION, "
			+ " COMPANY,COST_CENTER,QUANTITY_GO,QUANTITY_FO,PORT_SEQUENCE,REF_NO,ASSET_CODE)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String DELETE_JOURNAL_VOUCHER_HEADER = "delete  from JOURNALVOUCHER_HDR where journal_no=?";
	public static final String DELETE_JOURNAL_VOUCHER_DETAIL = "delete  from JOURNALVOUCHER_DTL where journal_no=?";
	public static final String DELETE_JOURNAL_GENERAL_LEDGER = "DELETE FROM GENERAL_LEDGER WHERE particulars=?";
	public static String INSERT_JOURNAL_VOUCHER_HEADER_MASTER = "INSERT INTO JOURNALVOUCHER_HDR(JOURNAL_NO, JOURNAL_DATE," + "JOURNAL_NARRATION, JOURNAL_CREATED_BY,  JOURNAL_COMPANY_CODE,JOURNALVOUCHER_TYPE_ID,COST_CENTER,bank_center,JOURNAL_CREATED_DT,reverse_jv)" + " VALUES(?,to_date(?,'dd/mm/yyyy'), ?, ?,  ?,?,?,? ,now(),'N') ";

	public static String INSERT_JOURNAL_VOUCHER_HEADER = "INSERT INTO JOURNALVOUCHER_HDR(cost_center,JOURNAL_NO, JOURNAL_DATE, JOURNAL_NARRATION, JOURNAL_CREATED_BY, JOURNAL_CREATED_DT, JOURNAL_COMPANY_CODE) VALUES(?,?,to_date(?,'dd/mm/yyyy'), ?, ?, now(), ?) ";

	public static String UPDATE_SAVE_JOURNAL_VOUCHER_HEADER = "UPDATE JOURNALVOUCHER_HDR SET  JOURNAL_DATE=to_date(?,'dd-mm-yy'), JOURNAL_NARRATION=?, JOURNAL_MODIFIED_BY=?,JOURNAL_MODIFIED_DT=now(), JOURNAL_COMPANY_CODE=?,is_opening_balance=? WHERE JOURNAL_NO=?";

	public static String UPDATE_SAVE_JOURNAL_VOUCHERHEADER = "UPDATE JOURNALVOUCHER SET  JOURNAL_DATE=to_date(?,'dd-mm-yy'), JOURNAL_NARRATION=?, JOURNAL_MODIFIED_BY=?,JOURNAL_MODIFIED_DT=now(), JOURNAL_COMPANY_CODE=? WHERE JOURNAL_NO=?";

	public static String GET_COMPANY_LOCATION = "select location from company_master where company_code = ?";

	public static String INSERT_JOURNAL_VOUCHER_DTL = "INSERT INTO JOURNALVOUCHER_DTL (JOURNAL_NO,JOURNAL_ACCOUNT_HEAD,JOURNAL_CURRENCY,JOURNAL_EXCHANGE_RATE,JOURNAL_DEBIT, " + "JOURNAL_CREDIT,JOURNAL_NARRATION,SUB_GROUP_CODE,  " + "JOURNAL_DEBITUSD,JOURNAL_CREDITUSD,SL_NO,SUB_ACCOUNT_CODE, " + "EMPLOYEE,LOCATION,CUSTOMER,SUPPLIER,DESIGNATION,COMPANY,COST_CENTER,DEPARTMENT,PATIENT) " + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	
	
	/*public static String GET_ACCOUNT_HEAD_LIST = " select ACCT_HEAD_CODE as id,ACCT_HEAD_NAME as text from ACCOUNT_HEAD_MASTER where  subgroup_acct_code not in ('1006')  union  select supplier_acct_code as id,entity_name as text from entity      union  select customer_acct_code as id,entity_name as text from customer_entity ";*/
	public static String GET_ACCOUNT_HEAD_LIST = " select ACCT_HEAD_CODE as id,ACCT_HEAD_NAME as text from ACCOUNT_HEAD_MASTER where  subgroup_acct_code not in ('1006')";
	
	public static String GET_ACCOUNT_HEAD_LIST_ICASS = "select ACCT_HEAD_CODE as id,concat(ACCT_HEAD_CODE,'-',ACCT_HEAD_NAME) as text from\n" + 
			"account_head_master where ACCT_HEAD_CODE is not null";
		//	" select ACCT_HEAD_CODE as id,concat(ACCT_HEAD_CODE,'-',ACCT_HEAD_NAME) as text from account_head_master where  subgroup_acct_code not  in ('2000','4000','1000','1001','1002','1003','1004','1005')";

	public static String GET_COMPANY_LIST = " select company_code as id, company_name as text from company_master";

	public static String GET_SERIAL_NUMBER = "SELECT CASE WHEN MAX(SL_NO) IS NULL THEN 1 ELSE MAX(SL_NO)+1 END As SLNum FROM JOURNALVOUCHER_DTL where journal_no =";

	public static String DELETE_JOURNAL_VOUCHER_HEADER_INFO = "DELETE FROM JOURNALVOUCHER_HDR WHERE JOURNAL_NO=?";

	public static String DELETE_JOURNAL_VOUCHER_DETAIL_INFO = "DELETE FROM JOURNALVOUCHER_DTL WHERE JOURNAL_NO=?";

	public static String GET_CURRENCY_LIST = "select Crrncy_Cd as id,Crrncy_NAM as text from CURRENCY";

	public static String GET_JOURNAL_VOUCHER_INFO = "SELECT jd.JOURNAL_ACCOUNT_HEAD,sg.SUB_GROUP_ACCT_NAME,ah.ACCT_HEAD_NAME,jd.JOURNAL_CURRENCY,jd.JOURNAL_EXCHANGE_RATE," + " jd.JOURNAL_DEBIT,jd.JOURNAL_CREDIT,jd.JOURNAL_NARRATION,jd.JOURNAL_DEPARTMENT,dp.dept_name," + " jd.JOURNAL_DEPARTMENT,jd.JOURNAL_VOYAGE,jd.JOURNAL_VESSEL,jd.JOURNAL_SECTOR,jd.SUB_GROUP_CODE,jd.JOURNAL_DEBITUSD," + " jd.JOURNAL_CREDITUSD,jd.SL_NO,jh.JOURNAL_NO AS jvNumber,jh.JOURNAL_COMPANY_CODE,to_char(jh.JOURNAL_DATE,'MM/dd/yyyy') AS dataOfIssue,"
			+ " jh.JOURNAL_NARRATION AS narration,cny.LOCATION FROM JOURNALVOUCHER_DTL jd LEFT JOIN JOURNALVOUCHER_HDR jh ON" + " jh.JOURNAL_NO=jd.JOURNAL_NO LEFT JOIN COMPANY_MASTER cny ON cny.COMPANY_CODE=jh.JOURNAL_COMPANY_CODE LEFT JOIN SUB_GROUP_ACCT_MASTER_NEW sg ON to_char(sg.SUB_GROUP_ACCT_CODE)=jd.SUB_GROUP_CODE" + " LEFT JOIN ACCT_HEAD_MASTER ah ON to_char(ah.ACCT_HEAD_CODE)=jd.JOURNAL_ACCOUNT_HEAD" + " LEFT OUTER JOIN department_master dp ON dp.DEPT_CODE=jd.JOURNAL_DEPARTMENT WHERE jh.JOURNAL_NO=";

	public static String UPDATE_JOURNAL_VOUCHER_HEADER = "UPDATE JOURNALVOUCHER_HDR SET  JOURNAL_DATE=?, JOURNAL_NARRATION=?, JOURNAL_MODIFIED_BY=?,JOURNAL_MODIFIED_DT=current_date, JOURNAL_COMPANY_CODE=? WHERE JOURNAL_NO=?";

	public static String UPDATE_JOURNAL_VOUCHER_HEADER_MASTER = "UPDATE JOURNALVOUCHER_HDR SET  JOURNAL_DATE=?, JOURNAL_NARRATION=?, JOURNAL_MODIFIED_BY=?,JOURNAL_MODIFIED_DT=current_date, JOURNAL_COMPANY_CODE=?,cost_center=?,JOURNALVOUCHER_TYPE_ID=?,bank_center=? WHERE JOURNAL_NO=?";

	public static String GET_COMANY_LOCATION = "SELECT COMPANY_CODE,COMPANY_NAME,LOCATION FROM COMPANY_MASTER WHERE COMPANY_CODE=?";

	public static String GET_JOURNAL_VOUCHER_HDR_ON_EDIT = "SELECT JVHDR.JOURNAL_NO jvNumber,TO_CHAR(JVHDR.JOURNAL_DATE,'DD/MM/YYYY') dataOfIssue, JVHDR.JOURNAL_NARRATION narration,   company_name company FROM JOURNALVOUCHER_HDR JVHDR   inner join company c on JVHDR.JOURNAL_COMPANY_CODE = c.company_id WHERE JVHDR.JOURNAL_NO=?";

	public static String GET_JOURNAL_VOUCHER_HDR_ON_EDIT_MASTER = "SELECT JVHDR.JOURNAL_NO jvNumber, " + "coalesce(JVHDR.JOURNALVOUCHER_TYPE_ID, 0) as journalvoucherTypeId, TO_CHAR(JVHDR.JOURNAL_DATE,'DD/MM/YYYY') dataOfIssue, " + "JVHDR.JOURNAL_NARRATION narration,cost_center as costCenter,bank_center as bankCenter,journal_company_code as company FROM JOURNALVOUCHER_HDR JVHDR   inner join company_master c on JVHDR.JOURNAL_COMPANY_CODE = c.company_code WHERE JVHDR.JOURNAL_NO=?";

	public static String GET_JOURNAL_VOUCHER_DTL_ON_EDIT = "select  case when SUB_ACCOUNT_CODE like  '%S0%' =  true then SUB_ACCOUNT_CODE  when SUB_ACCOUNT_CODE like  '%C0%' =  true then SUB_ACCOUNT_CODE  else  JOURNAL_ACCOUNT_HEAD end as accountCode, JOURNAL_CURRENCY as currency,JOURNAL_EXCHANGE_RATE as exchangeRate, JOURNAL_DEBIT as tcDebitAmount, " + "JOURNAL_CREDIT as tcCreditAmount,JOURNAL_NARRATION as narration,JOURNAL_DEBITUSD as bcDebitAmount,JOURNAL_CREDITUSD as bcCreditAmount,SL_NO as slNo,SUB_ACCOUNT_CODE as subAccountCode, " + " EMPLOYEE as employeeCode,  LOCATION as countryCode,CUSTOMER as customerCode,SUPPLIER as supplierCode, DESIGNATION as designationCode, "
			+ "COMPANY as companyCode,COST_CENTER as costCenter, DEPARTMENT as departmentCode, COALESCE(patient,0) patientCode FROM JOURNALVOUCHER_DTL where JOURNAL_NO=? ";

	public static final String GET_JOURNAL_NO_AUTOGENERATE = "SELECT CASE WHEN MAX(JOURNAL_NO) IS NULL " + "THEN ? ELSE rpad(MAX(JOURNAL_NO),5,'JV')||  " + "lpad(cast(cast((SUBSTRING(MAX(JOURNAL_NO),5)) as int)+1 " + "as text),4,'0') END as JOURNAL_NO FROM JOURNALVOUCHER_HDR where JOURNAL_NO like ?";

	public static final String INSERT_GENERAL_LEDGER_FOR_JV = "INSERT INTO general_ledger(ledger_date, account_code,  transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, " + "narration, currency_code, exchange_rate,cost_center, company_id,parent_code,created_date,created_by)   " + "select JVH.journal_date,journal_account_head,?,journal_credit,journal_debit,journal_creditusd,journal_debitusd, "
			+ "JVD.journal_narration,'INR' as currency,1.0 as exchangeRate,jvh.cost_center,JVH.journal_company_code,substr(journal_account_head,0,5),JVH.journal_date,JVH.journal_created_by " + "from journalvoucher_dtl JVD left join  journalvoucher_hdr JVH on JVH.journal_no = JVD.journal_no where JVH.journal_no =?";

	public static final String INSERT_GENERAL_LEDGER_FOR_GRN = "INSERT INTO general_ledger(ledger_date, account_code,  transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, " + "narration, currency_code, exchange_rate,cost_center, company_id,parent_code,SUB_ACCOUNT_CODE)   " + "select JVH.journal_date,journal_account_head,?,journal_credit,journal_debit,journal_creditusd,journal_debitusd, " + "JVD.journal_narration,'INR' as currency,1.0 as exchangeRate,jvh.cost_center,JVH.journal_company_code,substr(journal_account_head,0,5),SUB_ACCOUNT_CODE "
			+ "from journalvoucher_dtl JVD left join  journalvoucher_hdr JVH on JVH.journal_no = JVD.journal_no where JVH.journal_no =?";

	public static final String INSERT_GENERAL_LEDGER_FOR_JV_PO = "INSERT INTO general_ledger(ledger_date, account_code,  transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, " + "narration, currency_code, exchange_rate,cost_center, company_id,parent_code,SUB_ACCOUNT_CODE)   " + "select JVH.journal_date,journal_account_head,?,journal_credit,journal_debit,journal_creditusd,journal_debitusd, " + "JVD.journal_narration,'INR' as currency,1.0 as exchangeRate,jvh.cost_center,JVH.journal_company_code,substr(journal_account_head,0,5),SUB_ACCOUNT_CODE "
			+ "from journalvoucher_dtl JVD left join  journalvoucher_hdr JVH on JVH.journal_no = JVD.journal_no where JVH.journal_no =?";

	public static final String INSERT_GENERAL_LEDGER_FOR_JV1_PO = "INSERT INTO general_ledger(budget,ledger_date, account_code,  transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, " + "narration, currency_code, exchange_rate,cost_center, company_id,parent_code,SUB_ACCOUNT_CODE)   " + "select ?,JVH.journal_date,journal_account_head,?,journal_credit,journal_debit,journal_creditusd,journal_debitusd, " + "JVD.journal_narration,'INR' as currency,1.0 as exchangeRate,jvh.cost_center,JVH.journal_company_code,journal_account_head ,SUB_ACCOUNT_CODE "
			+ "from journalvoucher_dtl JVD left join  journalvoucher_hdr JVH on JVH.journal_no = JVD.journal_no where JVH.journal_no =?";

	public static final String INSERT_GENERAL_LEDGER_FOR_JV1 = "INSERT INTO general_ledger(budget,ledger_date, account_code,  transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, " + "narration, currency_code, exchange_rate,cost_center, company_id,parent_code)   " + "select ?,JVH.journal_date,journal_account_head,?,journal_credit,journal_debit,journal_creditusd,journal_debitusd, " + "JVD.journal_narration,'INR' as currency,1.0 as exchangeRate,jvh.cost_center,JVH.journal_company_code,journal_account_head "
			+ "from journalvoucher_dtl JVD left join  journalvoucher_hdr JVH on JVH.journal_no = JVD.journal_no where JVH.journal_no =?";
	public static final String DELETE_GENERAL_LEDGER_INFO = "delete from general_ledger where transaction_no=? ";

	public static final String GET_JOURNAL_VOUCHER_HDR_ON_PRINT = "SELECT JVHDR.JOURNAL_NO jvNumber, TO_CHAR(JVHDR.JOURNAL_DATE,'DD/MM/YYYY') dataOfIssue, (select cost_center_name from cost_center where cost_center_id::text = JVHDR.COST_CENTER limit 1) as costCenter, JVHDR.JOURNAL_NARRATION narration,JOURNAL_COMPANY_CODE companyCode,c.company_name as companyName,journal_created_by,e.first_name as preparedBy  FROM JOURNALVOUCHER_HDR JVHDR " + "	left join company_master c on JOURNAL_COMPANY_CODE=c.company_code " + "	left join employee_master e on emp_id=journal_created_by " + "	 WHERE JVHDR.JOURNAL_NO=? ";

	public static final String GET_JOURNAL_VOUCHER_DTL_ON_PRINT = "with a as( "
			+ "  select   journal_debit,case when SUB_ACCOUNT_CODE like '%S0%' =  true  then (select entity_name from entity where supplier_acct_code   = SUB_ACCOUNT_CODE limit 1)   when SUB_ACCOUNT_CODE like '%C0%' =  true  then (select entity_name from customer_entity where customer_acct_code   = SUB_ACCOUNT_CODE limit 1)   else  ahm.ACCT_HEAD_NAME end as accountName , "
			+ "  JOURNAL_ACCOUNT_HEAD as accountCode,jvh.journal_created_by,em.first_name, ahm.ACCT_HEAD_NAME as accountName1, JOURNAL_CURRENCY as currency, JOURNAL_EXCHANGE_RATE as exchangeRate, SUB_ACCOUNT_CODE as subAccountCode, SUB_GROUP_CODE as subGroupAccount, Sg.Sub_Group_Acct_Name as subGroupAcctName,journal_debit as bcAmount,journal_credit as tcAmount, "
			+ "						jvd.JOURNAL_NARRATION as narration, JVD.DESIGNATION as designationCode,JVD.COMPANY as companyCode,jvd.COST_CENTER as costCenter,c.company_name as companyName FROM JOURNALVOUCHER_DTL JVD LEFT JOIN Sub_Group_Acct_Master sg on Sg.Sub_Group_Acct_Code = SUB_GROUP_CODE    LEFT JOIN ACCOUNT_HEAD_MASTER ahm ON ahm.ACCT_HEAD_CODE = JOURNAL_ACCOUNT_HEAD  LEFT JOIN journalvoucher_hdr jvh ON jvh.journal_no = jvd.journal_no    LEFT JOIN employee_master em ON em.emp_id = jvh.journal_created_by "
			+ "						left join company_master c on JVD.COMPANY=c.company_code "
			+ " "
			+ "						where jvd.JOURNAL_NO = ? order by journal_credit "
			+ ") "
			+ "select *, case when journal_debit=0 then concat('Cr',' ', accountName) else concat('Dr',' ', accountName) end as accountName1 from a ";
			
			/*"select  case when journal_debit=0 then concat('Cr',' ', ahm.ACCT_HEAD_NAME) else concat('Dr',' ', ahm.ACCT_HEAD_NAME) end as accountName,JOURNAL_ACCOUNT_HEAD as accountCode,jvh.journal_created_by,em.first_name, ahm.ACCT_HEAD_NAME as accountName1, JOURNAL_CURRENCY as currency, JOURNAL_EXCHANGE_RATE as exchangeRate, SUB_ACCOUNT_CODE as subAccountCode, SUB_GROUP_CODE as subGroupAccount, Sg.Sub_Group_Acct_Name as subGroupAcctName,journal_debit as bcAmount,journal_credit as tcAmount, "
			+ "			jvd.JOURNAL_NARRATION as narration, JVD.DESIGNATION as designationCode,JVD.COMPANY as companyCode,jvd.COST_CENTER as costCenter,c.company_name as companyName FROM JOURNALVOUCHER_DTL JVD LEFT JOIN Sub_Group_Acct_Master sg on Sg.Sub_Group_Acct_Code = SUB_GROUP_CODE    LEFT JOIN ACCOUNT_HEAD_MASTER ahm ON ahm.ACCT_HEAD_CODE = JOURNAL_ACCOUNT_HEAD  LEFT JOIN journalvoucher_hdr jvh ON jvh.journal_no = jvd.journal_no    LEFT JOIN employee_master em ON em.emp_id = jvh.journal_created_by "
			+ "			left join company_master c on JVD.COMPANY=c.company_code  where jvd.JOURNAL_NO = ?  order by journal_credit" ;
			*/
			
			
			/*"select  JOURNAL_ACCOUNT_HEAD as accountCode,jvh.journal_created_by,em.first_name, ahm.ACCT_HEAD_NAME as accountName, JOURNAL_CURRENCY as currency, JOURNAL_EXCHANGE_RATE as exchangeRate, SUB_ACCOUNT_CODE as subAccountCode, SUB_GROUP_CODE as subGroupAccount, Sg.Sub_Group_Acct_Name as subGroupAcctName,journal_debit as bcAmount,journal_credit as tcAmount, "
			+ "jvd.JOURNAL_NARRATION as narration, JVD.DESIGNATION as designationCode,JVD.COMPANY as companyCode,jvd.COST_CENTER as costCenter,c.company_name as companyName FROM JOURNALVOUCHER_DTL JVD LEFT JOIN Sub_Group_Acct_Master sg on Sg.Sub_Group_Acct_Code = SUB_GROUP_CODE    LEFT JOIN ACCOUNT_HEAD_MASTER ahm ON ahm.ACCT_HEAD_CODE = JOURNAL_ACCOUNT_HEAD  LEFT JOIN journalvoucher_hdr jvh ON jvh.journal_no = jvd.journal_no    LEFT JOIN employee_master em ON em.emp_id = jvh.journal_created_by "
			+ "left join company c on JVD.COMPANY=c.company_id  where jvd.JOURNAL_NO=?";*/

	public static final String GET_JVNO = "	SELECT JOURNAL_NO AS jvNumber,JOURNAL_NO as id,JOURNAL_NO as text from journalvoucher_hdr ";

	public static final String GETTOTAL = "select sum(journal_debit) as total from JOURNALVOUCHER_DTL where JOURNAL_NO= ?";
	public static final String GETTOTAL1 = "select sum(journal_credit) as total from JOURNALVOUCHER_DTL where JOURNAL_NO= ?";

	public static final String INSERT_GL_DEBIT_DTL = "\n" + "INSERT INTO general_ledger(ledger_date, transaction_no,account_code, currency_code, exchange_rate,tc_debit, bc_debit,narration,  cost_center, company_id,\n" + "parent_code)  values(now(),?,?,?,?,?,?,?,?,?,?)";

	public static final String INSERT_GL_CREDIT_DTL = "\n" + "INSERT INTO general_ledger(ledger_date, transaction_no,account_code, currency_code, exchange_rate,tc_credit, bc_credit,narration,  cost_center, company_id,\n" + "parent_code)  values(now(),?,?,?,?,?,?,?,?,?,?)";

	public static String GET_ACCOUNT_HEAD_Map_LIST = "select acct_head_code as id,acct_head_name as text from account_head_master where subgroup_acct_code like '%1003%'";

	public static String acct = "select sub_account_code from journalvoucher_dtl where journal_no  =? limit 1";

	public static String gretuser = "select e.first_name as preparedBy from journalvoucher_hdr " + " left join employee_master e on emp_id=journal_created_by " + " where  journal_no  =? ";

	public static final String CHECK_YEAR_CLOSING_RIGHTS = "select count(*) as accountcloseRights from ( select * from form_property fp  inner join form_master_new fmn on fmn.form_code=fp.form_code  inner join module_master mm on fmn.module_code=mm.module_code  inner join user_rights_new urn on urn.form_property_id=fp.form_property_id  inner join company_user cu on cu.company_user_id=urn.company_user_id  where property_code='ACY' and fp.form_code = ?\n" + "and cu.user_id = ? )\n" + "t";
	public static final String CLOSING_DATE = " select count(*) from closing_account where company_code = ? and to_date(?,'dd/mm/yyyy') between fromdate and todate ";

	public static final String AUTO_GEN_PG_JOURNAL_NO_CC = "\n" + "SELECT CASE WHEN MAX(JOURNAL_NO) IS NULL THEN ? ELSE ? || lpad(cast(max(cast(SUBSTRING(JOURNAL_NO,5,7) as int))+1 as text),5,'0')\n" + " END AS JOURNAL_NO from journalvoucher_hdr where JOURNAL_NO like ?";

	public static final String REVERSE_JV = "select * from jv_reverse(?,?,?,?)";

	public static final String UPDATE_JV_HDR_STATUS = "UPDATE JOURNALVOUCHER_HDR SET REVERSE_JV =? WHERE JOURNAL_NO=?";	

	// public static String GET_REF_NO_OWNERS =
	// "select replace( 'OJV16' || to_char( nvl(max(substr(REF_NO,7,5)),0)
	// +1,'00000'),' ','') from JOURNALVOUCHER_HDR where substr(REF_NO,0,6) like
	// 'OJV16%'";
	public static final String GET_PAYMENT_STATUS = "select COALESCE(REVERSE_JV,'N') as reverseJV from JOURNALVOUCHER_HDR WHERE JOURNAL_NO =?";
	public static final String GET_ACCOUNT_HEAD_CASH_LIST = "select acct_head_code as id,acct_head_name as text from account_head_master " + "	where subgroup_acct_code like '%1002%'"; //1005
	public static final String GET_SUBACCOUNT_HEAD_LIST = "select customer_acct_code as id, concat(customer_acct_code,'-',entity_name) as text from customer_entity";
	public static final String GET_SUBVENDORACCOUNT_HEAD_LIST = "select supplier_acct_code as id, concat(supplier_acct_code,'-',entity_name) as text from entity";
	
	//modified Query
	//public static final String GET_SUBcollege_HEAD_LIST = "select customer_acct_code as id, concat(customer_acct_code,'-',entity_name) as text from customer_entity where is_college = 't'";
	//1 public static final String GET_SUBcollege_HEAD_LIST = "select customer_acct_code as id, concat(customer_acct_code,'-',entity_name) as text from customer_entity";
	public static final String GET_SUBcollege_HEAD_LIST = "select ACCT_HEAD_CODE as id, concat(ACCT_HEAD_CODE,'-',ACCT_HEAD_NAME) as text from ACCOUNT_HEAD_MASTER where subgroup_acct_code not in ('1006') and acct_head_for  in ('0') order by id desc";
	
	//public static final String GET_SUBother_HEAD_LIST = "select customer_acct_code as id, concat(customer_acct_code,'-',entity_name) as text from customer_entity where is_college <> 't'";
	public static final String GET_SUBother_HEAD_LIST = "select ACCT_HEAD_CODE as id, concat(ACCT_HEAD_CODE,'-',ACCT_HEAD_NAME) as text from ACCOUNT_HEAD_MASTER where subgroup_acct_code not in ('1006') and (acct_head_for not in ('1') and acct_head_for not in ('0')) order by id desc";
	
	//public static final String GET_SUBACCOUNT_vendor_LIST = "select supplier_acct_code as id, concat(supplier_acct_code,'-',entity_name) as text from entity  where is_college = 't'\r\n" ;
	public static final String GET_SUBACCOUNT_vendor_LIST = "select ACCT_HEAD_CODE as id, concat(ACCT_HEAD_CODE,'-',ACCT_HEAD_NAME) as text from ACCOUNT_HEAD_MASTER where subgroup_acct_code not in ('1006') and acct_head_for  in ('1') order by id desc" ;
	
	public static final String GET_SUBACCOUNT_other_cust_LIST = "select  supplier_acct_code as id, concat(supplier_acct_code,'-',entity_name) as text from entity  where is_college <> 't'\r\n" + 
			"union \r\n" + 
			"select customer_acct_code as id, concat(customer_acct_code,'-',entity_name) as text from customer_entity where is_college <> 't'" ;
	
	//Ledger List
		public static String GET_LEDGER_LIST = "select ACCT_HEAD_CODE as id,ACCT_HEAD_NAME as text from ACCOUNT_HEAD_MASTER where  subgroup_acct_code not in ('1006')";
	
	public static final String GET_SUBACCOUNT_other_LIST = "select supplier_acct_code as id, concat(supplier_acct_code,'-',entity_name) as text from entity  where is_college <> 't'";
	public static final String GET_ACCOUNT_HEAD_LIST_LE = "select  subgroup_acct_code,ACCT_HEAD_CODE as id,concat(ACCT_HEAD_CODE,'-',ACCT_HEAD_NAME) as text from\n" + 
			"account_head_master where ACCT_HEAD_CODE is not null";
/*			" select  subgroup_acct_code,ACCT_HEAD_CODE as id,concat(ACCT_HEAD_CODE,'-',ACCT_HEAD_NAME) as text from account_head_master where  subgroup_acct_code  not   in  ('1000','1001','1002','1003','1004','1005','3000','3001','3002','3003','3004','3005','3006','3007','2000')\r\n " ;
*/	public static final String GET_COUNT_CUS = "select count(*) from entity where supplier_acct_code=? "; 
	public static final String GET_COUNT_ENT = "select count(*) from customer_entity  where customer_acct_code=? ";
	
	public static final String GET_CURRENT_FINANCIAL_YEAR = "select financial_year_id from financial_year where is_current in ('t')";

}
