package com.dci.tenant.finance.PurchaseCreditNote;

public class PurchaseCreditNoteQueryUtil {

	public static final String sGetAcctHeadDropDown = " select ACCT_HEAD_CODE as id,VENDOR_NAME as text,VENDOR_CURR_CODE as currencyCode , COALESCE(VENDOR_EXG_RATE,1.0) as exchangeRate from vendor_master order by VENDOR_NAME ";

	public static final String GET_ACCOUNT_INTRA = "";
	public static final String sgetSupplierCurExg = " select COALESCE(VENDOR_CURR_CODE,'USD') as currencyCode , COALESCE(VENDOR_EXG_RATE,1.0) as exchangeRate from vendor_master where ACCT_HEAD_CODE =? ";

	public static final String sGetInvoiceNumber = " select INVOICE_NO,TO_CHAR(INVOICE_DT,'DD-MM-YYYY') as INVOICE_DT from PURCHASE_INVOICE_HDR   where SUPPLIER = ? union select invoice_no,TO_CHAR(INVOICE_DT,'DD-MM-YYYY') as INVOICE_DT from VOYAGE_PROVI_ALLOC  where SUPPLIER = ? order by INVOICE_NO desc";

	/*
	 * public static final String sGetCreditNoteList =
	 * "  SELECT PUR_CREDITNOTE_NO as creditNoteCode,CREDITNOTE_DATE,PAYER_SHORT_NAME,CREDITNOTE_INVOICE_NO, APPROVE_STATUS,LOCATION, COMPANY_NAME,  CR_AMOUNT,CR_AMOUNTUSD, "
	 * +
	 * " ur.is_delete urIsDelete, ur.is_modify urIsEdit, ur.is_print urIsPrint, ur.is_view urIsView FROM (select cn.PUR_CREDITNOTE_NO CREDITNOTE_NO, "
	 * +
	 * "  to_char(CN.PUR_CREDITNOTE_DATE, 'dd/mm/yyyy') CREDITNOTE_DATE,  buss.VENDOR_NAME PAYER_SHORT_NAME, "
	 * + " CN.PUR_CREDITNOTE_PURCHASE_NO CREDITNOTE_INVOICE_NO, " +
	 * " CN.approve_status,c.location, c.company_name, SUM(PUR_CREDITNOTE_AMOUNT) CR_AMOUNT,SUM(PUR_CREDITNOTE_AMOUNTUSD) CR_AMOUNTUSD ,c.company_code "
	 * +
	 * " from PURCHASE_CREDITNOTE_hdr cn LEFT JOIN PURCHASE_CREDITNOTE_dtl CND ON  CND.PUR_CREDITNOTE_NO = CN.PUR_CREDITNOTE_NO "
	 * +
	 * "  LEFT JOIN vendor_master buss ON buss.acct_head_code=cn.PUR_CREDITNOTE_ACCT_HEAD "
	 * + " LEFT JOIN company_master c ON c.company_code=cn.PUR_COMPANY_CODE " +
	 * "  GROUP BY CN.PUR_CREDITNOTE_NO, PUR_CREDITNOTE_DATE,buss.VENDOR_NAME, CN.PUR_CREDITNOTE_PURCHASE_NO,approve_status,c.location,c.company_name,c.company_code,cn.PUR_CREATED_DATE "
	 * +
	 * " Order by cn.PUR_CREATED_DATE desc) t inner join  VIEW_USER_RIGHTS_FOR_LIST ur on ur.company_code = t.company_code "
	 * + " where form_code = ? and user_id = ? ";
	 */

	public static final String sGetCreditNoteList = "select p.pur_creditnote_no as creditNoteCode,to_char(pur_creditnote_date,'DD/MM/YYYY')as validCreditNoteDate,bc_amount as creditAmountUSD,entity_name as supplierCode, " + "	pur_creditnote_purchase_no as invoiceNumber,pcn.pur_creditnote_acct_head as crdtlAccountHead,pur_creditnote_purchase_no as invoiceNumber, " + "	ac.acct_head_name as accountName from purchase_creditnote_hdr p  " + "	inner join purchase_creditnote_dtl pcn on p.pur_creditnote_no=pcn.pur_creditnote_no "
			+ "	left join account_head_master ac on ac.acct_head_code=pcn.pur_creditnote_acct_head   " + "	 left join entity e on p.pur_creditnote_acct_head=e.supplier_acct_code ";

	public static final String autoGenCreditNoteNo = "select ? || nvl(lpad(to_char(max(to_number(" + "substr(PUR_CREDITNOTE_NO,7)))+1), decode(length(to_char(max(to_number(" + "substr(PUR_CREDITNOTE_NO,7)))+1)),1,5,2,5,3,5,4,5,5,5, length(to_char(max(" + "to_number(substr(PUR_CREDITNOTE_NO,7)))+1))),'0'),'00001') as CREDITNOTE_NO from " + "purchase_creditnote_hdr where PUR_CREDITNOTE_NO like ? ORDER BY CREDITNOTE_NO DESC";

	public static final String autoGenCreditNoteNoDUBAI = "select ? || nvl(lpad(to_char(max(to_number(substr(" + "PUR_CREDITNOTE_NO,7)))+1), decode(length(to_char(max(to_number(" + "substr(PUR_CREDITNOTE_NO,7)))+1)),1,5,2,5,3,5,4,5,5,5, length(to_char" + "(max(to_number(substr(PUR_CREDITNOTE_NO,7)))+1))),'0'),'00001') as CREDITNOTE_NO " + "from purchase_creditnote_hdr	where PUR_CREDITNOTE_NO like ? ORDER BY CREDITNOTE_NO DESC";

	public static final String sDeleteCreditNoteDraftDtl = "delete from purchase_creditnote_dtl_temp where PUR_CREDITNOTE_NO =?";

	public static final String sDeleteCreditNoteDraft = "delete from purchase_creditnote_hdr_temp where PUR_CREDITNOTE_NO =?";

	public static final String AUTO_GEN_FOR_PG_CREDITNOTE_NO = "SELECT CASE WHEN MAX(PUR_CREDITNOTE_NO) IS NULL THEN ? ELSE rpad(MAX(PUR_CREDITNOTE_NO),6,?)|| " + "lpad(cast(cast((SUBSTRING(MAX(PUR_CREDITNOTE_NO),7)) as int)+1 as text),5,'0') END AS PUR_CREDITNOTE_NO " + "FROM purchase_creditnote_hdr where PUR_CREDITNOTE_NO like ?";

	public static final String AUTO_GEN_FOR_PG_CREDITNOTE_NO_DUBAI = "SELECT CASE WHEN MAX(PUR_CREDITNOTE_NO) IS NULL THEN ? ELSE rpad(MAX(PUR_CREDITNOTE_NO),6,?)|| " + "lpad(cast(cast((SUBSTRING(MAX(PUR_CREDITNOTE_NO),7)) as int)+1 as text),5,'0') END AS PUR_CREDITNOTE_NO " + "FROM purchase_creditnote_hdr where PUR_CREDITNOTE_NO like ?";

	public static final String saveCreditNoteData = "Insert into purchase_creditnote_hdr (PUR_CREDITNOTE_NO,PUR_CREDITNOTE_DATE,PUR_CREDITNOTE_ACCT_HEAD, " + "PUR_CREDITNOTE_CURRENCY,PUR_CREDITNOTE_RATE,PUR_CREDITNOTE_PURCHASE_NO,PUR_CREDITNOTE_NARRATION," + "PUR_COMPANY_CODE,PUR_CREATED_BY,PUR_CREATED_DATE,Approve_status,PUR_CN_VOYAGE,bc_amount,tc_amount,main_acct_head_code,main_sub_group_code,PUR_CN_REF_NO,ref_no) " + " values (?,to_date(?,'dd-mm-yy'),?,?,?,?,?,?,?,now(),?,?,?,?,?,?,?,?)";

	public static final String saveCreditNoteData_owner = "Insert into purchase_creditnote_hdr (PUR_CREDITNOTE_NO,PUR_CREDITNOTE_DATE,PUR_CREDITNOTE_ACCT_HEAD, " + "PUR_CREDITNOTE_CURRENCY,PUR_CREDITNOTE_RATE,PUR_CREDITNOTE_PURCHASE_NO,PUR_CREDITNOTE_NARRATION," + "PUR_COMPANY_CODE,PUR_CREATED_BY,PUR_CREATED_DATE,Approve_status,PUR_CN_VOYAGE,bc_amount,tc_amount," + "main_acct_head_code,main_sub_group_code,PUR_CN_REF_NO) " + " values (?,to_date(?,'dd-mm-yy'),?,?,?,?,?,?,?,now(),?,?,?,?,?,?,?)";

	public static final String sGetLocationWithInvoiceNo = "select COUNTRY as LOCATION FROM COMPANY where COMPANY_id=?";

	public static final String saveCreditNoteDetailData = " INSERT INTO purchase_creditnote_dtl(PUR_CREDITNOTE_NO,PUR_CREDITNOTE_ACCT_HEAD,PUR_CREDITNOTE_CURRENCY,PUR_CREDITNOTE_RATE, " + " PUR_CREDITNOTE_AMOUNT,PUR_CREDITNOTE_NARRATION,PUR_CREDITNOTE_AMOUNTUSD,PUR_CREDITNOTE_SLNO ,PUR_CREDITNOTE_SUB_GRP_CODE ,sub_account_code,EMPLOYEE,PORT,AGENT , " + " LOCATION,CUSTOMER ,SUPPLIER,DESIGNATION,COMPANY,COST_CENTER,QUANTITY_GO,QUANTITY_FO,PORT_SEQUENCE ,DEPARTMENT, "
			+ " VOYAGE,VESSEL,SECTOR,company_code,ref_no)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String saveCreditNoteDetailData_owner = " INSERT INTO purchase_creditnote_dtl(PUR_CREDITNOTE_NO,PUR_CREDITNOTE_ACCT_HEAD,PUR_CREDITNOTE_CURRENCY,PUR_CREDITNOTE_RATE, " + " PUR_CREDITNOTE_AMOUNT,PUR_CREDITNOTE_NARRATION,PUR_CREDITNOTE_AMOUNTUSD,PUR_CREDITNOTE_SLNO ,PUR_CREDITNOTE_SUB_GRP_CODE ,sub_account_code,EMPLOYEE,PORT,AGENT , " + " LOCATION,CUSTOMER ,SUPPLIER,DESIGNATION,COMPANY,COST_CENTER,QUANTITY_GO,QUANTITY_FO,PORT_SEQUENCE ,DEPARTMENT, "
			+ " VOYAGE,VESSEL,SECTOR,company_code)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String updateStatusCreditNoteTempHdrData = "UPDATE purchase_creditnote_hdr set APPROVE_STATUS=?,PUR_APPROVED_BY=?, PUR_APPROVED_DATE=now() where PUR_CREDITNOTE_NO=? ";

	public static final String GET_CREDIT_HDR_EDIT = " select PUR_CREDITNOTE_NO CREDITNOTE_NO ,TO_CHAR(PUR_CREDITNOTE_DATE,'DD/MM/YYYY') creditNoteDate ,PUR_CREDITNOTE_ACCT_HEAD accountName ,PUR_CREDITNOTE_CURRENCY currencyCode,PUR_CREDITNOTE_RATE exgRate ,PUR_CREDITNOTE_PURCHASE_NO invoiceNo, PUR_CREDITNOTE_NARRATION narration, PUR_COMPANY_CODE companyCode,PUR_COMPANY_CODE company,PUR_CN_VOYAGE voyageId,PUR_CN_REF_NO creditNoteNo,bc_amount bcAmount,tc_amount tcAmount from PURCHASE_CREDITNOTE_hdr where PUR_CREDITNOTE_NO= ? ";

	public static final String GET_CREDIT_DTL_EDIT = "select PUR_CREDITNOTE_ACCT_HEAD as crdtlAccountHead,PUR_CREDITNOTE_AMOUNT as tcamount,PUR_CREDITNOTE_NARRATION as narration,  " + "PUR_CREDITNOTE_AMOUNTUSD as bcamount,PUR_CREDITNOTE_SLNO as slNo,SUB_ACCOUNT_CODE as subAcctCode,EMPLOYEE as employeeCode,  " + " PORT as portCode,AGENT as agentCode,LOCATION as countryCode,CUSTOMER as customerCode,SUPPLIER as supplierCode, " + " DESIGNATION as designationCode,COMPANY as companyCode,COST_CENTER as costCenter,QUANTITY_GO as quantityGO,  "
			+ " QUANTITY_FO as quantityFO,PORT_SEQUENCE as portSequence ,DEPARTMENT as departmentCode,pur_creditnote_rate  exchangeRate,PUR_CREDITNOTE_AMOUNT tcAmount," + " PUR_CREDITNOTE_AMOUNTUSD bcAmount,  " + "VOYAGE as voyageCode,VESSEL as vesselCode,SECTOR as sectorCode,company_code as company_id_dtl,pur_creditnote_currency currency FROM PURCHASE_CREDITNOTE_dtl WHERE PUR_CREDITNOTE_NO= ?";

	public static final String UPDATE_CREDIT_HDR = " update purchase_creditnote_hdr set PUR_CREDITNOTE_DATE = to_timestamp(?, 'dd-mm-yy'),PUR_CREDITNOTE_ACCT_HEAD =?,PUR_CREDITNOTE_CURRENCY =?,PUR_CREDITNOTE_RATE =?,PUR_CREDITNOTE_PURCHASE_NO =?,PUR_CREDITNOTE_NARRATION =?,PUR_COMPANY_CODE =?,PUR_MODIFIED_BY=?,PUR_MODIFIED_DATE=current_timestamp,BC_AMOUNT=?,TC_AMOUNT=? ,PUR_CN_VOYAGE=?,PUR_CN_REF_NO =? where PUR_CREDITNOTE_NO = ? ";

	public static final String sDeleteCreditNoteDtl = "delete from purchase_creditnote_dtl where PUR_CREDITNOTE_NO =?";

	public static final String sDeleteCreditNote = "delete from purchase_creditnote_hdr where PUR_CREDITNOTE_NO =?";

	public static final String DeleteGL = "delete from general_ledger where particulars =?";

	public static final String selectCreditNoteViewData = "select PUR_CREDITNOTE_NO creditNoteCode,TO_CHAR(PUR_CREDITNOTE_DATE,'DD/MM/YYYY') creditNoteDate, " + " vendor.vendor_name accountName, PUR_CREDITNOTE_CURRENCY currencyCode,PUR_CREDITNOTE_RATE exgRate,  " + " PUR_CREDITNOTE_PURCHASE_NO invoiceNo,  invoice_dt invoiceDate, PUR_CREDITNOTE_NARRATION narration,pur_cn_ref_no as partyno,  " + " comp.COMPANY_CODE companyCode,comp.COMPANY_NAME company,comp.CURRENCY as companyCurrency , "
			+ " PUR_CN_VOYAGE voyageId,PUR_CN_REF_NO creditNoteNo,get_empname(pur_created_by) as invCreatedUser,tc_amount tcAmount,bc_amount bcAmount from PURCHASE_CREDITNOTE_hdr cnhdr  " + " left join vendor_MASTER vendor on vendor.ACCT_HEAD_CODE = cnhdr.PUR_CREDITNOTE_ACCT_HEAD  " + " left join VIEW_PCN_INV_NO geninv on geninv.INVOICE_NO = cnhdr.PUR_CREDITNOTE_PURCHASE_NO  " + " left join company_master comp on comp.company_code = cnhdr.PUR_COMPANY_CODE where PUR_CREDITNOTE_NO= ?";
	/*
	 * public static final String selectCrediteDetailViewData =
	 * "select cndtl.PUR_CREDITNOTE_ACCT_HEAD as crdtlAccountHead, ahm.ACCT_HEAD_NAME as accountHeadName,PUR_CREDITNOTE_AMOUNT as tcamount,PUR_CREDITNOTE_NARRATION as narration, "
	 * +
	 * " PUR_CREDITNOTE_AMOUNTUSD as bcamount,PUR_CREDITNOTE_SLNO as slNo, cndtl.SUB_ACCOUNT_CODE as subAcctCode, (coalesce(mlo.mlo_name,ven.vendor_name,payer.payer_name,stf.name,'')) as subAcctName,  "
	 * + " EMPLOYEE as employeeCode,  " +
	 * " PORT as portCode,AGENT as agentCode,LOCATION as countryCode,CUSTOMER as customerCode,SUPPLIER as supplierCode,   "
	 * +
	 * " DESIGNATION as designationCode,COMPANY as companyCode,COST_CENTER as costCenter,QUANTITY_GO as quantityGO, QUANTITY_FO as quantityFO,  "
	 * +
	 * " PORT_SEQUENCE as portSequence,DEPARTMENT as departmentCode,VOYAGE as voyageCode,VESSEL as vesselCode,vess.VESSEL_NAME as vesselName,SECTOR as sectorCode, sect.SECTOR_NAME as sectorName,GET_COMPANY_MASTER(company_code) as company_id_dtl  "
	 * +
	 * " 	FROM PURCHASE_CREDITNOTE_dtl cndtl  left join account_head_master ahm on ahm.ACCT_HEAD_CODE = cndtl.PUR_CREDITNOTE_ACCT_HEAD  "
	 * +
	 * " left join mlo_master mlo on mlo.acct_head_code = cndtl.SUB_ACCOUNT_CODE   "
	 * +
	 * " left join vendor_master ven on ven.acct_head_code = cndtl.SUB_ACCOUNT_CODE   "
	 * + "left join staff_master stf on stf.acct_code = cndtl.SUB_ACCOUNT_CODE " +
	 * " left join payer_master payer on payer.acct_head_code = cndtl.SUB_ACCOUNT_CODE  LEFT JOIN VESSEL_MASTER vess on vess.vessel_code = cndtl.VESSEL  "
	 * +
	 * " LEFT JOIN Sector_Master sect on sect.Sector_Code = cndtl.SECTOR WHERE cndtl.PUR_CREDITNOTE_NO =? "
	 * ;
	 */

	public static final String selectCrediteDetailViewData = "select cndtl.PUR_CREDITNOTE_ACCT_HEAD as crdtlAccountHead, " + " ahm.ACCT_HEAD_NAME as accountHeadName,PUR_CREDITNOTE_AMOUNT " + " as tcamount,PUR_CREDITNOTE_NARRATION as narration,        " + " PUR_CREDITNOTE_AMOUNTUSD as bcamount,PUR_CREDITNOTE_SLNO as slNo, cndtl.SUB_ACCOUNT_CODE as subAcctCode, " + " (coalesce(mlo.mlo_name,ven.vendor_name,payer.payer_name,stf.name,'')) as subAcctName,   " + " EMPLOYEE as employeeCode,   "
			+ " PORT as portCode,AGENT as agentCode,LOCATION as countryCode,CUSTOMER as customerCode,SUPPLIER as supplierCode,       " + " DESIGNATION as designationCode,cndtl.COMPANY as companyCode,COST_CENTER as costCenter,QUANTITY_GO as quantityGO, " + " QUANTITY_FO as quantityFO,      " + " PORT_SEQUENCE as portSequence,cndtl.DEPARTMENT as departmentCode,VOYAGE as voyageCode,VOYAGE as voyageCode1,VESSEL as vesselCode, "
			+ " vess.VESSEL_NAME as vesselName,SECTOR as sectorCode, sect.SECTOR_NAME as sectorName,GET_COMPANY_MASTER(cndtl.company_code) " + "  as company_id_dtl,pur_creditnote_currency currencyCode,pur_creditnote_rate exchangeRate         " + "	FROM PURCHASE_CREDITNOTE_dtl cndtl  left join account_head_master ahm on ahm.ACCT_HEAD_CODE = cndtl.PUR_CREDITNOTE_ACCT_HEAD     " + "  left join mlo_master mlo on mlo.acct_head_code = cndtl.SUB_ACCOUNT_CODE   " + " left join vendor_master ven on ven.acct_head_code = cndtl.SUB_ACCOUNT_CODE    "
			+ " left join staff_master stf on stf.acct_code = cndtl.SUB_ACCOUNT_CODE         " + " left join payer_master payer on payer.acct_head_code = cndtl.SUB_ACCOUNT_CODE  LEFT JOIN VESSEL_MASTER vess on " + " vess.vessel_code = cndtl.VESSEL       " + " LEFT JOIN Sector_Master sect on sect.Sector_Code = cndtl.SECTOR WHERE cndtl.PUR_CREDITNOTE_NO = ? ";

	public static final String saveCreditNoteMainHdrDataSign = "INSERT INTO CREDITNOTE_HDR (CREDITNOTE_NO, CREDITNOTE_DATE, CREDITNOTE_ACCOUNT_HEAD, " + "CREDITNOTE_CURRENCY, CREDITNOTE_EXCHANGE_RATE, CREDITNOTE_INVOICE_NO,CREDITNOTE_NARRATION, CREATED_BY, CREATED_DATE, MODIFIED_BY, " + "MODIFIED_DATE, APPROVED_BY,APPROVED_DATE,COMPANY_CODE,BC_AMOUNT,TC_AMOUNT)  " + "SELECT CREDITNOTE_NO, CREDITNOTE_DATE, CREDITNOTE_ACCOUNT_HEAD, CREDITNOTE_CURRENCY, CREDITNOTE_EXCHANGE_RATE, "
			+ "CREDITNOTE_INVOICE_NO,CREDITNOTE_NARRATION, CREATED_BY, CREATED_DATE, MODIFIED_BY,MODIFIED_DATE, ?, current_timestamp, COMPANY_CODE,BC_AMOUNT,TC_AMOUNT " + "FROM CREDITNOTE_TEMP_HDR WHERE CREDITNOTE_NO=? ";

	public static final String GET_CREDIT_HDR_FOR_GI_INSERT = " select CH.CREDITNOTE_NO creditNoteCode,TO_CHAR(CH.CREDITNOTE_DATE,'DD/MM/YYYY') creditNoteDate, " + " CH.CREDITNOTE_ACCOUNT_HEAD accountName ,CH.CREDITNOTE_CURRENCY currencyCode,CH.CREDITNOTE_EXCHANGE_RATE exgRate , " + " CH.CREDITNOTE_INVOICE_NO invoiceNo, CH.CREDITNOTE_NARRATION narration, CH.COMPANY_CODE companyCode, " + " coalesce(sum(CD.CREDITNOTE_AMOUNT),0) creditAmount,coalesce(sum(CD.CREDITNOTE_AMOUNTUSD),0) creditAmountUSD "
			+ " from creditnote_hdr CH LEFT JOIN creditnote_dtl CD on CD.CREDITNOTE_NO = CH.CREDITNOTE_NO " + " where CH.CREDITNOTE_NO= ? group by CH.CREDITNOTE_NO,CH.CREDITNOTE_DATE,CH.CREDITNOTE_ACCOUNT_HEAD, " + " CH.CREDITNOTE_CURRENCY,CH.CREDITNOTE_EXCHANGE_RATE,CH.CREDITNOTE_INVOICE_NO,CH.CREDITNOTE_NARRATION,CH.COMPANY_CODE ";

	// public static final String selectVoyageVesselByInvoice =
	// "select a.invoice_no,c.vessel_name, b.voyage from singleinvoice_hdr a,
	// singleinvoice_bl_dtl b, vessel_master c where b.vessel = c.vessel_code
	// and a.invoice_no = b.invoice_no and a.invoice_no=?";

	public static final String selectVoyageVesselByInvoice = " select invoiceno,voyage,  vessel_name from (select INVOICE_NO  invoiceno,PUR_CN_VOYAGE voyage,VM.VESSEL_NAME vessel_name " + " from vendor_master vmm INNER JOIN  VIEW_PCN_INV_NO SH ON vmm.acct_head_code = sh.ACCT_HEAD_CODE  " + " INNER JOIN PURCHASE_CREDITNOTE_hdr pch ON  pch.PUR_CREDITNOTE_PURCHASE_NO=INVOICE_NO " + " LEFT JOIN voyage v ON v.voyage_id=PCH.PUR_CN_VOYAGE " + " LEFT JOIN VESSEL_MASTER VM ON VM.VESSEL_CODE=V.VESSEL_ID ) t where   invoiceno = ? ";

	public static String GetInvoiceAddresList = " select invoiceno,InvoiceDate,slInvLocation,get_company_master_name(slInvLocation) companyName,company_name as officeName,ADDRESS1,ADDRESS2,faxno,officeTelephone,CURRENCY,EXCHANGE_RATE,TOTAL,AMTTOTAL,agent,customer,emp_name as invCreatedUser " + "   from (select pur_creditnote_no as invoiceno, TO_CHAR(pur_creditnote_date,'DD-MM-YYYY') as InvoiceDate,pur_company_code as slInvLocation,   " + "  company_name, ADDRESS1, ADDRESS2, FAX_NO as faxno,OFFICE_TELEPHONE as officeTelephone,   "
			+ "  sh.pur_creditnote_CURRENCY as CURRENCY,sh.pur_creditnote_RATE as EXCHANGE_RATE,bc_amount as  TOTAL,tc_amount as  AMTTOTAL, GET_COMPANY_NAME(v.company_code)  customer, v.company_code  as agent,v.company_code,e.emp_name " + "  from vbusiness_associate v,purchase_creditnote_hdr SH, employee_master e where e.emp_id = SH.pur_created_by  and v.acct_head_code = pur_creditnote_acct_head) temp where   invoiceno = ? ";

	public static String getCompanyAddres = " select LOCATION as locationName,company_name as officeName,c.address as footeraddr,ph_no as footerphno, " + "  fax_no as footerfaxno,email as footermail ,c.COMPANY_CODE as locationId, SUBSTR(pur_creditnote_no, 0, 4)  as invoiceId   " + " from PURCHASE_CREDITNOTE_hdr g, company_master c where  g.pur_COMPANY_CODE=c.COMPANY_CODE and pur_creditnote_no= ? ";

	public static final String ADD_JOURNAL_VOUCHER_HEADER = "INSERT INTO JOURNALVOUCHER_HDR(JOURNAL_NO, JOURNAL_DATE, JOURNAL_NARRATION, JOURNAL_CREATED_BY, JOURNAL_CREATED_DT, JOURNAL_COMPANY_CODE,REF_NO) VALUES(?,to_date(?,'dd-mm-yy'), ?, ?, now(), ?,?) ";

	public static final String ADD_JOURNAL_VOUCHER_DTL = " INSERT INTO JOURNALVOUCHER_DTL (JOURNAL_NO,JOURNAL_ACCOUNT_HEAD,JOURNAL_CURRENCY,JOURNAL_EXCHANGE_RATE,JOURNAL_DEBIT, " + " JOURNAL_CREDIT,JOURNAL_NARRATION,JOURNAL_DEPARTMENT,JOURNAL_VOYAGE,JOURNAL_VESSEL,JOURNAL_SECTOR,SUB_GROUP_CODE, " + " JOURNAL_DEBITUSD,JOURNAL_CREDITUSD,SL_NO,SUB_ACCOUNT_CODE,EMPLOYEE,PORT,AGENT,LOCATION ,CUSTOMER,SUPPLIER,DESIGNATION, "
			+ " COMPANY,COST_CENTER,QUANTITY_GO,QUANTITY_FO,PORT_SEQUENCE,REF_NO,ASSET_CODE)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static String UPDATE_JVNO_PCN_HDR = " UPDATE PURCHASE_CREDITNOTE_hdr SET JV_NO = ? WHERE PUR_CREDITNOTE_NO=? ";

	public static String GET_REF_NO_FEEDER = "select replace( 'GPCN18' || to_char( COALESCE(max(substr(REF_NO,7,5)):: int ,0) +1,'00000'),' ','') from PURCHASE_CREDITNOTE_hdr where REF_NO like 'GPCN18%'";

	// public static String GET_REF_NO_OWNERS =
	// "select replace( 'OPIN16' || to_char( nvl(max(substr(REF_NO,7,5)),0)
	// +1,'00000'),' ','') from PURCHASE_INVOICE_HDR where substr(REF_NO,0,6) like
	// 'OPIN16%'";

	public static String GET_REF_NO_OWNERS = "select replace( 'OPCN18' || to_char( COALESCE(max(substr(REF_NO,7,5))::int,0) +1,'00000'),' ','') from PURCHASE_CREDITNOTE_hdr where REF_NO like 'OPCN18%'";

	public static String GET_REVERSE_LIST = "select pur_creditnote_no as id,pur_creditnote_no as text from purchase_creditnote_hdr";

	public static String GET_PCN_STATUS = "select COALESCE(REVERSE_PCN,'N') as ReverseBr from purchase_creditnote_hdr WHERE pur_creditnote_no = ?";

	public static String UPDATE_PCN_STATUS = "update purchase_creditnote_hdr set REVERSE_PCN = 'Y' WHERE pur_creditnote_no = ?";

	public static String UPDATE_ACTUALNO_PCN_HDR = "update purchase_creditnote_hdr set actual_pcn_no = ? WHERE pur_creditnote_no = ?";

	public static String GET_REVERSE_LIST_FOR_AGENTS = " select id,text,t.company_code from (select cn.PUR_CREDITNOTE_NO as id,cn.PUR_CREDITNOTE_NO as text,c.company_code from PURCHASE_CREDITNOTE_hdr cn " + " LEFT JOIN company_master c ON c.company_code=cn.PUR_COMPANY_CODE order by cn.PUR_CREDITNOTE_NO desc) t " + " inner join  VIEW_USER_RIGHTS_FOR_LIST ur on ur.company_code = t.company_code" + " where form_code = 'F0312' and user_id = ?";
}