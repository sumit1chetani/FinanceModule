package com.dci.finance.GeneralLedger;

public class GeneralLedgerQueryUtil {
	/*
	 * public static String GET_GENERAL_LEDGER_LIST_SG_LEVEL =
	 * "select GL.SUB_GROUP_CODE as subGroupCode,SG.SUB_GROUP_ACCT_NAME as subGroupName, "
	 * +
	 * "SUM(COALESCE(LOCAL_DEBIT,0)) as tcDebit, SUM(COALESCE(LOCAL_CREDIT,0)) as tcCredit, "
	 * + "SUM(COALESCE(DEBIT,0)) as bcDebit, SUM(COALESCE(CREDIT,0)) as bcCredit, "
	 * + "(SUM(COALESCE(DEBIT,0))- SUM(COALESCE(CREDIT,0))) as currentBalance, " +
	 * "(SUM(COALESCE(LOCAL_DEBIT,0))- SUM(COALESCE(LOCAL_CREDIT,0))) as currentTCBalance from GENERAL_LEDGER GL "
	 * +
	 * "LEFT JOIN SUB_GROUP_ACCT_MASTER SG ON SG.SUB_GROUP_ACCT_CODE = GL.SUB_GROUP_CODE "
	 * +
	 * "WHERE LEDGER_DT::date BETWEEN  TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')  "
	 * ;
	 */
	
	// modified Query
	/*public static String GET_GENERAL_LEDGER_LIST_SG_LEVEL = "select GL.parent_code as subGroupCode,SG.SUB_GROUP_ACCT_NAME as subGroupName,  SUM(COALESCE(TC_DEBIT,0)) as tcDebit, SUM(COALESCE(TC_CREDIT,0)) as tcCredit,  SUM(COALESCE(BC_DEBIT,0)) as bcDebit, SUM(COALESCE(BC_CREDIT,0)) as bcCredit,  (SUM(COALESCE(BC_DEBIT,0))- SUM(COALESCE(BC_CREDIT,0))) as currentBalance,  (SUM(COALESCE(TC_DEBIT,0))- SUM(COALESCE(TC_CREDIT,0))) as currentTCBalance from GENERAL_LEDGER GL "
			+ "LEFT JOIN SUB_GROUP_ACCT_MASTER SG ON SG.SUB_GROUP_ACCT_CODE = GL.SUB_ACCOUNT_CODE " + "WHERE LEDGER_DATE::date  BETWEEN  TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " + "group by GL.parent_code ,SG.SUB_GROUP_ACCT_NAME";
	*/
	public static String GET_GENERAL_LEDGER_LIST_SG_LEVEL = "select GL.parent_code as subGroupCode,SG.SUB_GROUP_ACCT_NAME as subGroupName,  SUM(COALESCE(TC_DEBIT,0)) as tcDebit, SUM(COALESCE(TC_CREDIT,0)) as tcCredit,  SUM(COALESCE(BC_DEBIT,0)) as bcDebit, SUM(COALESCE(BC_CREDIT,0)) as bcCredit,  (SUM(COALESCE(BC_DEBIT,0))- SUM(COALESCE(BC_CREDIT,0))) as currentBalance,  (SUM(COALESCE(TC_DEBIT,0))- SUM(COALESCE(TC_CREDIT,0))) as currentTCBalance from GENERAL_LEDGER GL "
			+ "LEFT JOIN SUB_GROUP_ACCT_MASTER SG ON SG.SUB_GROUP_ACCT_CODE = GL.SUB_ACCOUNT_CODE " + "WHERE LEDGER_DATE::date  BETWEEN  TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " + "group by GL.parent_code ,SG.SUB_GROUP_ACCT_NAME";
	
	public static String GET_GENERAL_LEDGER_OP = "select acct_head_code as accountHeadCode,acct_head_name as accountHeadName,openingbalancebc as openingBalance, " + " totalbcdebit as totalBCDebit,totalbcdebit as totalBCDebit,totalbccredit as totalBCCredit, " + " closingbalancebc as closingBalance,openingbalancetc as openingBalanceTC,closingbalancetc as closingBalanceTC ";

	public static String GET_GENERAL_LEDGER_LIST_AH_LEVEL = " select GL.ACCOUNT_HEAD as accountHeadCode,AH.ACCT_HEAD_NAME as accountHeadName," + "SUM(COALESCE(LOCAL_DEBIT,0)) as tcDebit, SUM(COALESCE(LOCAL_CREDIT,0)) as tcCredit, SUM(COALESCE(DEBIT,0)) as bcDebit," + " SUM(COALESCE(CREDIT,0)) as bcCredit,(SUM(COALESCE(DEBIT,0)) - SUM(COALESCE(CREDIT,0))) as currentBalance," + "(SUM(COALESCE(DEBIT,0))- SUM(COALESCE(CREDIT,0))) as currentTCBalance from GENERAL_LEDGER GL "
			+ " LEFT JOIN ACCOUNT_HEAD_MASTER AH ON AH.ACCT_HEAD_CODE = GL.ACCOUNT_HEAD WHERE trim(GL.SUB_GROUP_CODE)=? " + " AND LEDGER_DT::date BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') ";

	public static String GET_GENERAL_LEDGER_LIST_TRANSACTION_LEVEL = "with inv_jv as ( " + " select voucher_no, jv_no from  cashbank_receipt_hdr where jv_no is not null union " + " select voucher_no, jv_no from  cashbank_pay_hdr where jv_no is not null union " + " select invoice_no, jv_no from  purchase_invoice_hdr where jv_no is not null union " + " select pur_creditnote_no, jv_no  from purchase_creditnote_hdr where jv_no is not null " + ") "
			+ " Select TO_CHAR(LEDGER_DT,'DD-MM-YYYY') as ledgerDate,ledger_no ledgerNo,PARTICULARS as transactionNo,coalesce(lpo.description,'') || coalesce(GENERAL_LEDGER.narration , '') as narration,CURRENCY_CODE as currency,CONVERSION_RATE as exchangeRate, " + " SUB_ACCOUNT_CODE as subAccountCode,PARTY_INV_NO as partyInvoiceNo,COALESCE(MLO.MLO_NAME,'')||COALESCE(VM.VENDOR_NAME,'')||COALESCE(PM.PAYER_NAME,'')||COALESCE(SM.NAME,'') as subAccountName, "
			+ " SUM(COALESCE(LOCAL_DEBIT,0)) as tcDebit,SUM(COALESCE(LOCAL_CREDIT,0)) as tcCredit,SUM(COALESCE(DEBIT,0)) as bcDebit, " + " SUM(COALESCE(CREDIT,0)) as bcCredit,COALESCE(allocation_status,'') as allocationStatus,COALESCE(allocated_to,'') as allocatedTo from GENERAL_LEDGER " + " LEFT JOIN MLO_MASTER MLO ON MLO.ACCT_HEAD_CODE =  SUB_ACCOUNT_CODE " + " LEFT JOIN VENDOR_MASTER VM on VM.ACCT_HEAD_CODE = SUB_ACCOUNT_CODE " + " LEFT JOIN PAYER_MASTER PM on PM.ACCT_HEAD_CODE = SUB_ACCOUNT_CODE "
			+ " LEFT JOIN STAFF_MASTER SM ON SM.ACCT_CODE = SUB_ACCOUNT_CODE " + " left join lpo_hdr lpo on lpo.lpo_no=GENERAL_LEDGER.particulars " + " left outer join inv_jv on Particulars = jv_no " + " where trim(ACCOUNT_HEAD) =? AND LEDGER_DT::date BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')  ";

	/*
	 * public static String GET_SUB_LEDGER_REPORT =
	 * "select PARTICULARS as transactionNo,TO_CHAR(LEDGER_DT,'DD-MM-YYYY') as transactionDate,LEDGER_DT as ledgerDate,COALESCE(GENERAL_LEDGER.VESSEL_CODE,'') as vesselCode, "
	 * +
	 * "COALESCE(GENERAL_LEDGER.VOYAGE_CODE,'') as voyageCode,CURRENCY_CODE as currency,CONVERSION_RATE as exchangeRate,PARTY_INV_NO as partyInvoiceNo,GENERAL_LEDGER.SUB_ACCOUNT_CODE as subAccountCode, "
	 * + "AH.ACCT_HEAD_CODE || '-' ||AH.ACCT_HEAD_NAME as accountHeadName, " +
	 * "COALESCE(MLO.MLO_NAME,'')||COALESCE(VM.VENDOR_NAME,'')||COALESCE(PM.PAYER_NAME,'')|| COALESCE(SM.NAME,'') as subAccountName, "
	 * +
	 * "coalesce(lpo.description,'') || coalesce(GENERAL_LEDGER.NARRATION , '') as narration,COALESCE(LOCAL_DEBIT,0.0) as tcDebit,COALESCE(DEBIT,0.0) as bcDebit,COALESCE(LOCAL_CREDIT,0.0) as tcCredit,COALESCE(CREDIT,0.0) as bcCredit, "
	 * +
	 * "GENERAL_LEDGER.COMPANY_CODE as company,vessel_code as vesselCode,GENERAL_LEDGER.voyage_code as voyageCode,sector_code as sectorCode, "
	 * +
	 * "get_empname(COALESCE(GH.created_by,'')||COALESCE(PHC.created_by,'') || COALESCE(SI.created_by,'')||COALESCE(CN.created_by,'')|| "
	 * +
	 * "COALESCE(DN.created_by,'')||COALESCE(PIN.created_by,'')||COALESCE(CBP.created_by,'')|| COALESCE(CBR.created_by,'')|| "
	 * +
	 * "COALESCE(PCN.pur_created_by,'')|| COALESCE(JV.journal_created_by,'') || COALESCE(LPO.created_by,'') || COALESCE(vpa.created_by,'')) as createdBy "
	 * +
	 * "from GENERAL_LEDGER  LEFT JOIN MLO_MASTER MLO ON MLO.ACCT_HEAD_CODE =  GENERAL_LEDGER.SUB_ACCOUNT_CODE "
	 * +
	 * "LEFT JOIN VENDOR_MASTER VM on VM.ACCT_HEAD_CODE = GENERAL_LEDGER.SUB_ACCOUNT_CODE "
	 * +
	 * "LEFT JOIN PAYER_MASTER PM on PM.ACCT_HEAD_CODE = GENERAL_LEDGER.SUB_ACCOUNT_CODE "
	 * +
	 * "LEFT JOIN STAFF_MASTER SM ON SM.ACCT_CODE = GENERAL_LEDGER.SUB_ACCOUNT_CODE "
	 * +
	 * "LEFT JOIN ACCOUNT_HEAD_MASTER AH ON AH.ACCT_HEAD_CODE=GENERAL_LEDGER.ACCOUNT_HEAD "
	 * +
	 * "LEFT JOIN generalinvoice_hdr GH on GH.INVOICE_NO = GENERAL_LEDGER.PARTICULARS "
	 * +
	 * "LEFT JOIN phc_invoice_hdr PHC on PHC.INVOICE_NO = GENERAL_LEDGER.PARTICULARS "
	 * +
	 * "LEFT JOIN singleinvoice_hdr SI on SI.INVOICE_NO = GENERAL_LEDGER.PARTICULARS "
	 * +
	 * "LEFT JOIN creditnote_hdr CN on CN.creditnote_no  = GENERAL_LEDGER.PARTICULARS "
	 * +
	 * "LEFT JOIN debitnote_hdr DN on DN.debitnote_no  = GENERAL_LEDGER.PARTICULARS "
	 * +
	 * "LEFT JOIN purchase_invoice_hdr PIN on PIN.invoice_no = GENERAL_LEDGER.PARTICULARS "
	 * +
	 * "LEFT JOIN cashbank_pay_hdr CBP on CBP.voucher_no= GENERAL_LEDGER.PARTICULARS "
	 * +
	 * "LEFT JOIN cashbank_receipt_hdr CBR on CBR.voucher_no= GENERAL_LEDGER.PARTICULARS "
	 * +
	 * "LEFT JOIN purchase_creditnote_hdr PCN on PCN.pur_creditnote_no =GENERAL_LEDGER.PARTICULARS "
	 * +
	 * "LEFT JOIN journalvoucher_hdr JV on JV.journal_no =GENERAL_LEDGER.PARTICULARS "
	 * + "LEFT JOIN lpo_hdr lpo on lpo.lpo_no =GENERAL_LEDGER.PARTICULARS " +
	 * "LEFT JOIN voyage_provi_alloc vpa on vpa.invoice_no =GENERAL_LEDGER.PARTICULARS "
	 * +
	 * "WHERE GENERAL_LEDGER.SUB_ACCOUNT_CODE =? AND GENERAL_LEDGER.LEDGER_DT between TO_DATE(?,'DD-MM-YYYY') and TO_DATE(?,'DD-MM-YYYY') "
	 * ;
	 */

	// Execel Export By Account Head

	// public static String excelByAcctHead =
	// "select * from vw_gl_report(?,?,?,?,?,?)";
	/*
	 * public static String excelByAcctHead = "with  t as( " +
	 * "select company_code as companyCode,voucher_no as transactionNo,voucher_dt as transactionDate,bank_acct as accountHeadCode,narration as narration,amt_local  as tcCredit, "
	 * +
	 * "amt_usd as  bcCredit ,c.company_name as companyName,ac.acct_head_name as accountHeadName,exchange_rate as exchangeRate from cashbank_pay_hdr "
	 * + "left join company c on company_code=c.company_id " +
	 * "left join account_head_master ac on bank_acct=ac.acct_head_code " + "union "
	 * +
	 * "select journal_company_code as companyCode,H.journal_no as transactionNo,journal_date as transactionDate,dt.journal_account_head as accountHeadCode, "
	 * + "H.journal_narration as narration,journal_credit  as tcCredit, " +
	 * "journal_debit as  bcCredit ,c.company_name as companyName,ac.acct_head_name as accountHeadName,dt.journal_exchange_rate as exchangeRate  from journalvoucher_hdr H "
	 * + "LEFT join journalvoucher_dtl dt on H.journal_no=dt.journal_no " +
	 * "left join company c on journal_company_code=c.company_id " +
	 * "left join account_head_master ac on  journal_account_head =ac.acct_head_code "
	 * + ") " + "select * from t " + "where 1=1";
	 */

	/*
	 * public static String excelByAcctHead =
	 * "with  t as( select company_code as companyCode,voucher_no as transactionNo,voucher_dt as transactionDate,bank_acct as accountHeadCode,narration as narration,amt_local  as tcCredit, amt_usd as  bcCredit ,c.company_name as companyName,ac.acct_head_name as accountHeadName,exchange_rate as exchangeRate from cashbank_pay_hdr left join company c on company_code=c.company_id left join account_head_master ac on bank_acct=ac.acct_head_code "
	 * + " union " +
	 * "select company_code  as companyCode,invoice_no as transactionNo,invoice_dt as transactionDate,charge_code as accountHeadCode,description as narration,pin.amount as tcCredit,pin.amount as bcCredit,c.company_name as companyName,ac.acct_head_name as accountHeadName,ex_rate as exchangeRate  from purchase_invoice_hdr   LEFT join purchase_invoice_dtl pin on invoice_no=pin.purchase_inv_no   left join company c on company_code=c.company_id   left join account_head_master ac on charge_code=ac.acct_head_code "
	 * + "union " +
	 * "select company_code as companyCode,voucher_no as transactionNo,voucher_dt as transactionDate,bank_acct as accountHeadCode,narration as narration,amt_local  as tcCredit, amt_usd as  bcCredit,c.company_name as companyName,ac.acct_head_name as accountHeadName,exchange_rate as exchangeRate from cashbank_receipt_hdr left join company c on company_code=c.company_id   left join account_head_master ac on bank_acct=ac.acct_head_code "
	 * + "union " +
	 * "select company_code as companyCode,invoice_no as transactionNo,invoice_dt as transactionDate,supplier as accountHeadCode,description as narration,amount as tcCredit,amount as bcCredit, "
	 * +
	 * "c.company_name as companyName,ac.acct_head_name as accountHeadName,ex_rate as exchangeRate from general_purchase_invoice_hdr "
	 * +
	 * "left join company c on company_code=c.company_id left join account_head_master ac on supplier=ac.acct_head_code "
	 * + "union " +
	 * "select journal_company_code as companyCode,H.journal_no as transactionNo,journal_date as transactionDate,dt.journal_account_head as accountHeadCode, H.journal_narration as narration,journal_credit  as tcCredit, journal_debit as  bcCredit ,c.company_name as companyName,ac.acct_head_name as accountHeadName,dt.journal_exchange_rate as exchangeRate  from journalvoucher_hdr H LEFT join journalvoucher_dtl dt on H.journal_no=dt.journal_no left join company c on journal_company_code=c.company_id "
	 * +
	 * "left join account_head_master ac on  journal_account_head =ac.acct_head_code ) select * from t where 1=1"
	 * ;
	 */

	public static String excelByAcctHead = " select g.company_id as companyCode,transaction_no as transactionNo,ledger_date as transactionDate,account_code as accountHeadCode,narration as narration,bc_credit as tcCredit,  bc_debit as bcCredit,g.cost_center as costCenter,c.company_name as companyName,ac.acct_head_name as accountHeadName,cc.cost_center_name as costCentername from general_ledger g  " + " left join company_master c on c.company_code=g.company_id " + "  left join account_head_master ac on ac.acct_head_code =g.account_code  "
			+ " left join cost_center cc on cc.cost_center_id::text =g.cost_center where 1=1  ";

	public static String EXCELBYACCTHEADNOTINTDS = "select * from vw_gl_report(?,?,?,?,?,?) where accountheadcode not in ('10070008','20120008','20120007','20120006','20120005','20120004','20120009')";

	public static String excelByAcctHead_only = "select * from vw_gl_report(?,?,?,?,?,null)";

	public static String excelByAcctHead_sub = "select *,duedt dueDate from vw_gl_report_sub(?,?,?,?,?,?)";

	// accpunt head excel
	public static String GET_CONSOLIDATED_LEDGER_LIST = "select  row_number() OVER (ORDER BY GL.LEDGER_NO) as slNo,GL.Company_code companyCode, short_name companyName, GL.ACCOUNT_HEAD as accountHeadCode,AH.ACCT_HEAD_NAME as accountHeadName, GL.SUB_ACCOUNT_CODE as subAccountCode, " + "COALESCE(MLO.MLO_NAME,'')||COALESCE(VM.VENDOR_NAME,'')||COALESCE(PM.PAYER_NAME,'')|| "
			+ "COALESCE(SM.NAME,'') as subAccountName,Particulars transactionNo,TO_CHAR(ledger_dt,'DD-MM-YYYY') as transactionDate,TO_DATE(ledger_dt::varchar,'YYYY-MM-DD') as transactionDateFormat,coalesce(lpo.description,'') || coalesce(GL.NARRATION , '') as narration, GL.Currency_code currency, GL.Conversion_Rate exchangeRate,PARTY_INV_NO as partyInvoiceNo, " + "COALESCE(LOCAL_DEBIT,0) tcDebit,COALESCE(LOCAL_CREDIT,0) tcCredit, COALESCE(DEBIT,0) as bcDebit, COALESCE(CREDIT,0) as bcCredit , "
			+ "get_empname(COALESCE(GH.created_by,'')||COALESCE(PHC.created_by,'') || COALESCE(SI.created_by,'')||COALESCE(CN.created_by,'')|| " + "COALESCE(DN.created_by,'')||COALESCE(PIN.created_by,'')||COALESCE(CBP.created_by,'')|| COALESCE(CBR.created_by,'')|| "
			+ "COALESCE(PCN.pur_created_by,'')|| COALESCE(JV.journal_created_by,'') || COALESCE(LPO.created_by,'') || COALESCE(vpa.created_by,'')) as createdBy,GL.Voyage_code as voyageCode,GL.vessel_code as vesselCode, GL.sector_code as sectorCode, COALESCE(allocation_status,'') as allocationStatus,COALESCE(allocated_to,'') as allocatedTo " + "from GENERAL_LEDGER GL   LEFT JOIN ACCOUNT_HEAD_MASTER AH ON AH.ACCT_HEAD_CODE = GL.ACCOUNT_HEAD " + "LEFT JOIN MLO_MASTER MLO ON MLO.ACCT_HEAD_CODE =  SUB_ACCOUNT_CODE "
			+ "LEFT JOIN VENDOR_MASTER VM on VM.ACCT_HEAD_CODE = SUB_ACCOUNT_CODE " + "LEFT JOIN PAYER_MASTER PM on PM.ACCT_HEAD_CODE = SUB_ACCOUNT_CODE " + "LEFT JOIN STAFF_MASTER SM ON SM.ACCT_CODE = SUB_ACCOUNT_CODE " + "LEFT JOIN COMPANY_MASTER comp on comp.company_code = GL.Company_Code " + "LEFT JOIN generalinvoice_hdr GH on GH.INVOICE_NO = GL.PARTICULARS " + "LEFT JOIN phc_invoice_hdr PHC on PHC.INVOICE_NO = GL.PARTICULARS " + "LEFT JOIN singleinvoice_hdr SI on SI.INVOICE_NO = GL.PARTICULARS "
			+ "LEFT JOIN creditnote_hdr CN on CN.creditnote_no  = GL.PARTICULARS " + "LEFT JOIN debitnote_hdr DN on DN.debitnote_no  = GL.PARTICULARS " + "LEFT JOIN purchase_invoice_hdr PIN on PIN.invoice_no = GL.PARTICULARS " + "LEFT JOIN cashbank_pay_hdr CBP on CBP.voucher_no= GL.PARTICULARS " + "LEFT JOIN cashbank_receipt_hdr CBR on CBR.voucher_no= GL.PARTICULARS " + "LEFT JOIN purchase_creditnote_hdr PCN on PCN.pur_creditnote_no =GL.PARTICULARS " + "LEFT JOIN journalvoucher_hdr JV on JV.journal_no =GL.PARTICULARS "
			+ "LEFT JOIN lpo_hdr lpo on lpo.lpo_no =GL.PARTICULARS " + "LEFT JOIN voyage_provi_alloc vpa on vpa.invoice_no =GL.PARTICULARS " + "WHERE GL.LEDGER_DT BETWEEN TO_DATE(?,'DD-MM-YYYY') AND TO_DATE(?,'DD-MM-YYYY') ";

	public static String GET_GRP_LIST = "select group_head_code as id,GROUP_HEAD_NAME as text from GROUP_HEAD_MASTER";

	public static String GET_OPENING_BALANCE = "select openingbalancebc as openingBalance,closingbalancebc as closingBalance,subCode as subAccountCode,subName as subAccountName";

	public static String GET_OPENING_BALANCE_SUB = "select openingbalancebc as openingBalance,closingbalancebc as closingBalance,subCode,subName from fn_sub_ledger_with_ah(?,TO_DATE(?,'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY'),?,?)";

	public static String GET_VIEW_REPORTtest = "select case when subgroupcode like '%S0%' =  true  then (select entity_name from entity where supplier_acct_code   =subgroupcode)   when subgroupcode like  '%C0%' =  true  then (select entity_name from customer_entity where customer_entity ::text  =subgroupcode)   else  subgroupname end as subGroupName1,* from fn_gl_viewtest(?, TO_DATE(?,'DD/MM/YYYY'), TO_DATE(?,'DD/MM/YYYY'))";
	public static String GET_VIEW_REPORTtest1 = "select case when subgroupcode like  '%S0%' =  true  then (select entity_name from entity where supplier_acct_code   =subgroupcode)     when subgroupcode like  '%C0%' =  true  then (select entity_name from customer_entity where customer_acct_code  =subgroupcode) else  subgroupname end as subGroupName1,* from fn_gl_viewtest(?, TO_DATE(?,'DD/MM/YYYY'), TO_DATE(?,'DD/MM/YYYY'),?,?,?,?)";
	public static String GET_VIEW_REPORT1 = "select * from fn_gl_view1(?, TO_DATE(?,'DD/MM/YYYY'), TO_DATE(?,'DD/MM/YYYY'), ?, ?, ?, ?,?)";

	public static String GET_VIEW_REPORT2 = "select * from fn_gl_view2(?, TO_DATE(?,'DD/MM/YYYY'), TO_DATE(?,'DD/MM/YYYY'), ?, ?, ?)";

	public static String GET_VIEW_REPORT3 = "select * from fn_gl_view3(?, TO_DATE(?,'DD/MM/YYYY'), TO_DATE(?,'DD/MM/YYYY'), ?, ?)";

	public static String getAddress = "select addrs1_add as address, gstn_no as gstNo from service_partner where srvc_prtnr_bin=?";

	public static String get_mainaccount_list = "select acct_head_code ||  ' - ' || acct_head_name as text, acct_head_code as id from account_head_master order by acct_head_code asc";

	public static final String get_sub_list = "select sgam.SUB_GROUP_ACCT_CODE as id,sgam.SUB_GROUP_ACCT_NAME as text  from SUB_GROUP_ACCT_MASTER sgam left join GROUP_HEAD_MASTER ghm on ghm.group_head_code = sgam.group_head_code where ghm.group_head_name in (?) order by SUB_GROUP_ACCT_NAME ASC";

	public static final String get_main_list = "select acct_head_code ||  ' - ' || acct_head_name as text, acct_head_code as id from account_head_master where acct_head_status = 'Y' and  subgroup_acct_code = ? order by acct_head_name ASC";

	public static final String get_acct_head_code = "select entity_id from entity where supplier_acct_code=?;";

	public static final String CompanyName = "select  brnch_nam from branch  where company_code=?";

	public static final String SubGroup = "  select sub_group_acct_name from SUB_GROUP_ACCT_MASTER where sub_group_acct_code=?";

	public static final String getAccountName = "  select acct_head_name from account_head_master where acct_head_code=?";

	public static final String getsubAccountName = "  select srvc_prtnr_nam from service_partner where srvc_prtnr_bin = ?";

	public static final String get_subgroupname = "select sub_group_acct_name as name from sub_group_acct_master where sub_group_acct_code  =? ";

	/*
	 * public static final String GET_VIEW_REPORT2_QUERY =
	 * "select account_code as accountHeadCode,transaction_no as transactionNo, " +
	 * " SUM(TC_DEBIT) as tcDebit, SUM(TC_CREDIT) as tcCredit,SUM(BC_DEBIT) as bcDebit, SUM(BC_CREDIT) as bcCredit, "
	 * +
	 * " (SUM(bc_debit) - SUM(bc_credit)) as currentBalance, (SUM(TC_DEBIT)- SUM(TC_CREDIT)) as currentTCBalance  "
	 * + " from general_ledger where  company_id=? and  " +
	 * " ledger_date::date >= TO_DATE(?,'DD-MM-YYYY') and ledger_date::date <= TO_DATE(?,'DD-MM-YYYY') and parent_code like ? "
	 * + "  group by account_code,transaction_no ";
	 */

	public static final String GET_VIEW_REPORT2_QUERY1 = "select  cost_center  as costCenter,account_code as accountHeadCode,case when length(account_code)=4 is true then (select sub_group_acct_name from sub_group_acct_master where sub_group_acct_code=account_code) else coalesce(AH.acct_head_name,'')  || coalesce(cust.entity_name,'') || coalesce(supp.entity_name,'') end as accountHeadName,  SUM(TC_DEBIT) as tcDebit, SUM(TC_CREDIT) as tcCredit,SUM(BC_DEBIT) as bcDebit, SUM(BC_CREDIT) as bcCredit,  (SUM(bc_debit) - SUM(bc_credit)) as currentBalance, (SUM(TC_DEBIT)- SUM(TC_CREDIT)) as currentTCBalance   from general_ledger gl "
			+ "left join account_head_master AH on AH.acct_head_code = gl.account_code " + "left join entity cust on cust.customer_acct_code = gl.account_code left join entity supp on supp.supplier_acct_code = gl.account_code " + "  where  gl.company_id=? and   ledger_date::date >= TO_DATE(?,'DD-MM-YYYY') and ledger_date::date <= TO_DATE(?,'DD-MM-YYYY') and parent_code like  ?  " + "group by account_code,AH.acct_head_name,cust.entity_name,supp.entity_name,cost_center  order by account_code";

	public static final String GET_VIEW_REPORT2_QUERY = "select  cost_center  as costCenter,account_code as accountHeadCode,case when length(account_code)=4 is true then (select sub_group_acct_name from sub_group_acct_master where sub_group_acct_code=account_code) else coalesce(AH.acct_head_name,'')  || coalesce(cust.entity_name,'') || coalesce(supp.entity_name,'') end as accountHeadName,  SUM(TC_DEBIT) as tcDebit, SUM(TC_CREDIT) as tcCredit,SUM(BC_DEBIT) as bcDebit, SUM(BC_CREDIT) as bcCredit,  (SUM(bc_debit) - SUM(bc_credit)) as currentBalance, (SUM(TC_DEBIT)- SUM(TC_CREDIT)) as currentTCBalance   from general_ledger gl "
			+ "left join account_head_master AH on AH.acct_head_code = gl.account_code " + "left join entity cust on cust.customer_acct_code = gl.account_code left join entity supp on supp.supplier_acct_code = gl.account_code " + "  where  gl.company_id=? and   ledger_date::date >= TO_DATE(?,'DD-MM-YYYY') and ledger_date::date <= TO_DATE(?,'DD-MM-YYYY') and parent_code like  ? and cost_center=? " + "group by account_code,AH.acct_head_name,cust.entity_name,supp.entity_name,cost_center  order by account_code";
	/*
	 * public static final String GET_VIEW_REPORT3_QUERY =
	 * "Select TO_CHAR(LEDGER_DATE,'DD-MM-YYYY') as ledgerDate,general_ledger_id ledgerNo,account_code as accountHeadCode, "
	 * + "transaction_no as transactionNo, " +
	 * "coalesce(GL.narration , '') as narration,CURRENCY_CODE as currency, " +
	 * "exchange_rate as exchangeRate,  SUB_ACCOUNT_CODE as subAccountCode, " +
	 * "GL.parent_code as subgroup , " +
	 * "SUM(COALESCE(TC_DEBIT,0)) as tcDebit,SUM(COALESCE(TC_CREDIT,0)) as tcCredit,SUM(COALESCE(BC_DEBIT,0)) as bcDebit, "
	 * + "SUM(COALESCE(BC_CREDIT,0)) as bcCredit " +
	 * "from general_ledger GL where company_id=? and account_code=?  group  by LEDGER_DATE,general_ledger_id"
	 * ;
	 */
	public static final String GET_VIEW_REPORT3_QUERY = "Select TO_CHAR(LEDGER_DATE,'DD-MM-YYYY') as ledgerDate,general_ledger_id ledgerNo,account_code as accountHeadCode,   transaction_no as transactionNo,   coalesce(GL.narration , '') as narration,CURRENCY_CODE as currency,   exchange_rate as exchangeRate,  SUB_ACCOUNT_CODE as subAccountCode,   GL.parent_code as subgroup ,   SUM(COALESCE(TC_DEBIT,0)) as tcDebit,SUM(COALESCE(TC_CREDIT,0)) as tcCredit,SUM(COALESCE(BC_DEBIT,0)) as bcDebit,   SUM(COALESCE(BC_CREDIT,0)) as bcCredit "
			+ ",cost_center_name as costCenter,project_name as budget from general_ledger GL left join cost_center cc on cc.cost_center_id::text =GL.cost_center left join budget_definition bd on bd.budget_definition_id=GL.budget where GL.company_id=? and GL.account_code=? and  ledger_date::date >= TO_DATE(?,'DD-MM-YYYY') and ledger_date::date <= TO_DATE(?,'DD-MM-YYYY')  and GL.cost_center=?  group  by LEDGER_DATE,general_ledger_id,cost_center_name,project_name;";

	public static final String GET_VIEW_REPORT3_QUERY1 = "Select TO_CHAR(LEDGER_DATE,'DD-MM-YYYY') as ledgerDate,general_ledger_id ledgerNo,account_code as accountHeadCode,   transaction_no as transactionNo,   coalesce(GL.narration , '') as narration,CURRENCY_CODE as currency,   exchange_rate as exchangeRate,  SUB_ACCOUNT_CODE as subAccountCode,   GL.parent_code as subgroup ,   SUM(COALESCE(TC_DEBIT,0)) as tcDebit,SUM(COALESCE(TC_CREDIT,0)) as tcCredit,SUM(COALESCE(BC_DEBIT,0)) as bcDebit,   SUM(COALESCE(BC_CREDIT,0)) as bcCredit "
			+ ",cost_center_name as costCenter,project_name as budget from general_ledger GL left join cost_center cc on cc.cost_center_id::text =GL.cost_center left join budget_definition bd on bd.budget_definition_id=GL.budget where GL.company_id=? and GL.account_code=? and  ledger_date::date >= TO_DATE(?,'DD-MM-YYYY') and ledger_date::date <= TO_DATE(?,'DD-MM-YYYY')  group  by LEDGER_DATE,general_ledger_id,cost_center_name,project_name;";

	public static final String GET_VIEW_REPORT1_Query = "select GL.parent_code as subGroupCode,gl.company_id as companyCode,SG.SUB_GROUP_ACCT_NAME as subGroupName,  SUM(COALESCE(TC_DEBIT,0)) as tcDebit, SUM(COALESCE(TC_CREDIT,0)) as tcCredit,  SUM(COALESCE(BC_DEBIT,0)) as bcDebit, SUM(COALESCE(BC_CREDIT,0)) as bcCredit,  (SUM(COALESCE(BC_DEBIT,0))- SUM(COALESCE(BC_CREDIT,0))) as currentBalance,  (SUM(COALESCE(TC_DEBIT,0))- SUM(COALESCE(TC_CREDIT,0))) as currentTCBalance from GENERAL_LEDGER GL "
			+ "LEFT JOIN SUB_GROUP_ACCT_MASTER SG ON SG.SUB_GROUP_ACCT_CODE = GL.SUB_ACCOUNT_CODE  WHERE 1=1 ";

	//modified query
	/*public static final String GET_VIEW_REPORTtest_ac = "with t as (select case when subgroupcode like  '%S0%' =  true  then (select entity_name from entity where supplier_acct_code   =subgroupcode)     when subgroupcode like  '%C0%' =  true  then (select entity_name from customer_entity where customer_acct_code  =subgroupcode) else  subgroupname end as subGroupName1,* from fn_gl_viewtest_acc (?,TO_DATE(?,'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY'),?,?,?,?) ) " 
			+" select distinct gl.parent_code as subgroupcode,GL.PARENT_CODE as subGroupCode,SG.SUB_GROUP_ACCT_NAME as subGroupName1, "
			+" SUM(TC_DEBIT) as tcDebit, SUM(TC_CREDIT) as tcCredit, SUM(BC_DEBIT) as bcDebit,  SUM(BC_CREDIT) as bcCredit, "  
			+" SUM(BC_DEBIT)- SUM(BC_CREDIT) as currentBalance, (SUM(TC_DEBIT)- SUM(TC_CREDIT)) as currentTCBalance  from general_ledger gl "
			+" right join t on t.transactionno = gl.transaction_no LEFT JOIN SUB_GROUP_ACCT_MASTER SG ON SG.SUB_GROUP_ACCT_CODE = GL.PARENT_CODE group by gl.parent_code ,SG.SUB_GROUP_ACCT_NAME";*/
	
	public static final String GET_VIEW_REPORTtest_ac = "with t as (select case when subgroupcode like  '%S0%' =  true  then (select entity_name from entity where supplier_acct_code   =subgroupcode)     when subgroupcode like  '%C0%' =  true  then (select entity_name from customer_entity where customer_acct_code  =subgroupcode) else  subgroupname end as subGroupName1,* from fn_gl_viewtest_acc (?,TO_DATE(?,'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY'),?,?,?,?) ) " 
			+" select distinct gl.parent_code as subgroupcode,GL.PARENT_CODE as subGroupCode,SG.SUB_GROUP_ACCT_NAME as subGroupName1, "
			+" SUM(TC_DEBIT) as tcDebit, SUM(TC_CREDIT) as tcCredit, SUM(BC_DEBIT) as bcDebit,  SUM(BC_CREDIT) as bcCredit, "  
			+" SUM(BC_DEBIT)- SUM(BC_CREDIT) as currentBalance, (SUM(TC_DEBIT)- SUM(TC_CREDIT)) as currentTCBalance  from general_ledger gl "
			+" right join t on t.transactionno = gl.transaction_no LEFT JOIN SUB_GROUP_ACCT_MASTER SG ON SG.SUB_GROUP_ACCT_CODE = GL.PARENT_CODE where gl.parent_code!=?  group by gl.parent_code ,SG.SUB_GROUP_ACCT_NAME";
	
	public static final String GET_VIEW_REPORTS ="with t as (  select account_code as accountHeadCode,transaction_no as transactionno from general_ledger gl where 1=1 "
			+ "and gl.company_id IN (?) and gl.ledger_date::date >= TO_DATE(?,'DD-MM-YYYY') and gl.ledger_date::date <= TO_DATE(?,'DD-MM-YYYY') and gl.account_code = ? "
			+ "group by account_code,transaction_no order by account_code)  select  gl.ledger_date, gl.transaction_no, account_code as accountHeadCode,case when length(account_code)=4  "
			+ "then (select sub_group_acct_name from sub_group_acct_master where sub_group_acct_code=account_code) else coalesce(AH.acct_head_name,'')  || "
			+ "coalesce(cust.entity_name,'') || coalesce(supp.entity_name,'') end as accountHeadName,  SUM(TC_DEBIT) as tcDebit, SUM(TC_CREDIT) as tcCredit,SUM(BC_DEBIT) "
			+ "as bcDebit, SUM(BC_CREDIT) as bcCredit,  (SUM(bc_debit) - SUM(bc_credit)) as currentBalance, (SUM(TC_DEBIT)- SUM(TC_CREDIT)) as currentTCBalance "
			+ "from general_ledger gl right join t on t.transactionno = gl.transaction_no left join account_head_master AH on AH.acct_head_code = gl.account_code left join "
			+ "customer_entity cust on cust.customer_acct_code = gl.account_code left join entity supp on supp.supplier_acct_code = gl.account_code where gl.account_code <> ?  "
			+ " group by account_code,AH.acct_head_name,cust.entity_name,supp.entity_name, gl.ledger_date, gl.transaction_no   order by account_code";

	public static final String GET_VIEW_REPORT = "with t as (select account_code as accountHeadCode,transaction_no as transactionno from general_ledger gl where 1=1 and"
			+ " gl.company_id IN (?) and gl.ledger_date::date >= TO_DATE(?,'DD-MM-YYYY') and gl.ledger_date::date <= TO_DATE(?,'DD-MM-YYYY')"
			+ " and gl.account_code = ? group by account_code,transaction_no order by account_code) select gl.ledger_date, gl.narration, gl.transaction_no, account_code as "
			+ "accountHeadCode,case when length(account_code)=4  then (select sub_group_acct_name from sub_group_acct_master where sub_group_acct_code=account_code) else "
			+ "coalesce(AH.acct_head_name,'') || coalesce(cust.entity_name,'') || coalesce(supp.entity_name,'') end as accountHeadName, SUM(TC_DEBIT) as tcDebit, case "
			+ "when SUM(TC_CREDIT) != 0 then (SUM(TC_CREDIT)) - (case when (select SUM(TC_DEBIT)  from general_ledger where tc_debit !=0 and transaction_no in (select "
			+ "transaction_no from general_ledger where account_code = ? AND TC_CREDIT = 0) and account_code not in (?)) is null then 0 else (select "
			+ "SUM(TC_DEBIT)  from general_ledger where tc_debit !=0 and transaction_no in (select transaction_no from general_ledger where account_code = ? "
			+ "AND TC_CREDIT = 0) and account_code not in (?)) end) else coalesce(SUM(TC_CREDIT),0) end as tcCredit, SUM(BC_DEBIT) as bcDebit, case when "
			+ "SUM(BC_CREDIT) !=0 then (SUM(BC_CREDIT) - (case when (select SUM(BC_DEBIT)  from general_ledger where bc_debit !=0 and transaction_no in (select transaction"
			+ "_no from general_ledger where account_code = ? AND BC_CREDIT = 0) and account_code not in (?)) is null then 0 else (select SUM(BC_DEBIT) "
			+ "from general_ledger where bc_debit !=0 and transaction_no in (select transaction_no from general_ledger where account_code = ? AND BC_CREDIT = 0)"
			+ " and account_code not in (?)) end)) else SUM(BC_CREDIT) end as bcCredit, SUM(bc_debit) - (case when SUM(bc_credit)!=0 then (SUM(bc_credit)) -  (case"
			+ " when (select SUM(BC_DEBIT)  from general_ledger where bc_debit !=0 and transaction_no in (select transaction_no from general_ledger where account_code = ?"
			+ " AND BC_CREDIT = 0) and account_code not in (?)) is null then 0 else (select SUM(BC_DEBIT)  from general_ledger where bc_debit !=0 and "
			+ "transaction_no in (select transaction_no from general_ledger where account_code = ? AND BC_CREDIT = 0) and account_code not in (?)) end) "
			+ "else SUM(bc_credit) end ) as currentBalance, (SUM(TC_DEBIT)- case when SUM(TC_CREDIT)!=0 then (SUM(TC_CREDIT)) - (case when (select SUM(TC_DEBIT) from "
			+ "general_ledger where tc_debit !=0 and transaction_no in (select transaction_no from general_ledger where account_code = ? AND TC_CREDIT = 0) and "
			+ "account_code not in (?)) is null then  0 else (select SUM(TC_DEBIT) from general_ledger where tc_debit !=0 and transaction_no in (select"
			+ " transaction_no from general_ledger where account_code = ? AND TC_CREDIT = 0) and account_code not in (?)) end) else SUM(TC_CREDIT) end)"
			+ " as currentTCBalance from general_ledger gl right join t on t.transactionno = gl.transaction_no left join account_head_master AH on AH.acct_head_code ="
			+ " gl.account_code left join customer_entity cust on cust.customer_acct_code = gl.account_code left join entity supp on supp.supplier_acct_code = "
			+ "gl.account_code where gl.account_code not in ((select account_code from general_ledger where tc_debit !=0 and transaction_no in (select transaction_no"
			+ " from general_ledger where account_code = ? AND BC_CREDIT = 0)) ) group by gl.transaction_no, gl.narration, account_code,AH.acct_head_name,cust.entity_name, "
			+ "supp.entity_name, gl.ledger_date order by account_code, gl.ledger_date";
}