package com.dci.tenant.finance.chqPresentation;

public class ChqPresentationQueryUtil {

	public static final String GET_PRESNTATION_HDR_LIST = "select prCode as prCode,presentDate as presentDate,chqamnt as chqAmnt,companyName as companyName ,cust.text as customerName,chqNo as chqNo,chqDate as chqDate from chequelist che  left join PRESENTATION_REALISATION pred on pred.pr_id = che.prcode left join customer_list cust on cust.id ::text= pred.customer";

	public static final String SAVE_PRESENTATION = "insert into PRESENTATION_REALISATION(pr_id, customer, cheque_no, cheque_dt, amount, presented, created_by, created_dt, pr_company_code, present_dt, drawn_bank, deposit_bank, chq_recived_date) values(?, ?, ?, to_date(?,'DD-MM-YY'), ?, ?, ?, current_date,  ?,to_date(?,'DD-MM-YY'),?,?,to_date(?,'DD-MM-YY'))";

	public static final String PRESENTATION_CODE = "SELECT CASE WHEN MAX(pr_id) IS NULL THEN 'PR00001' ELSE RPAD(MAX(pr_id),2,'PR')||LPAD (cast(cast((SUBSTRING(MAX(pr_id),3)) as int)+1 as text),5,'0') END FROM PRESENTATION_REALISATION";
	public static final String GET_REALISATION_HDR_LIST = "select * from realisation";

	// public static final String GET_REALISATION_HDR_LIST = "select
	// to_char(REALISED_DT, 'dd/mm/yyyy') realisedDate,pr_id prCode ,
	// entity_name
	// customerName, cheque_no chqNo, to_char(cheque_dt, 'dd/mm/yyyy') chqDate,
	// amount chqAmnt, pr.status status, to_char(PRESENT_DT, 'dd/mm/yyyy')
	// presentDate,cm.company_name companyName,drawn_bank drwnBank,deposit_bank
	// depositBank,to_char(chq_recived_date, 'dd/mm/yyyy') chqRcvdDate from
	// PRESENTATION_REALISATION pr inner join entity mm on mm.customer_acct_code
	// =
	// pr.customer inner join company cm on cm.company_id = PR_COMPANY_CODE
	// where
	// pr.status is not null order by realisedDate,prCode desc";

	public static final String PRESENTATION_COMBO = "select * from presentation_list";

	public static final String SAVE_REALISATION = "update PRESENTATION_REALISATION set status = ?,REALISED_DT = to_date(?,'DD-MM-YY'), modified_by = ?, modified_dt = current_date where pr_id = ?";

	public static final String GET_PRESENTATION_EDIT = "select PR_ID prCode,CUSTOMER customerCode,entity_name customerName,CHEQUE_NO chqNo,to_char(CHEQUE_DT,'dd/mm/yyyy') chqDate,AMOUNT chqAmnt, STATUS status, to_char(PRESENT_DT,'dd/mm/yyyy') presentDate, to_char(REALISED_DT,'dd/mm/yyyy') realisedDate,PR_COMPANY_CODE companyCode,DRAWN_BANK drwnBank,DEPOSIT_BANK depositBank,to_char(CHQ_RECIVED_DATE,'dd/mm/yyyy') chqRcvdDate from PRESENTATION_REALISATION left join entity e on e.customer_acct_code::text=PRESENTATION_REALISATION.CUSTOMER    where PR_ID =?";

	public static final String sDeletePresentation = "Delete from PRESENTATION_REALISATION where pr_id =?";

	public static String sCompanyDropDown = "select company_code as id, company_name as text,company_code as companyCode, company_name as companyName from company_master";

	public static String GETCUSTOMERLIST = "SELECT a.mlo_code as id,a.mlo_name as text,a.mlo_code as customerCode,a.mlo_name as customerName FROM mlo_master a ORDER BY a.mlo_name";

	public static String UPDATE_PRESENTATION = "update PRESENTATION_REALISATION set CUSTOMER =?,CHEQUE_NO=?,CHEQUE_DT=to_date(?,'DD-MM-YY'),AMOUNT=?,MODIFIED_BY=?,MODIFIED_DT=current_date,PRESENT_DT=to_date(?,'DD-MM-YY'),PR_COMPANY_CODE=?,DRAWN_BANK=?,DEPOSIT_BANK=?,CHQ_RECIVED_DATE=to_date(?,'DD-MM-YY') where PR_ID=?";

	public static final String PRESENTATION_COMBO_EDIT = "select pr_id id, pr_id as text,entity_name customerName,pr.customer customerCode,cheque_no chqNo, amount chqAmnt from PRESENTATION_REALISATION  pr inner join entity mm on mm.customer_acct_code  = pr.customer where status is null order by pr_id";

	public static final String GET_CUSTOMER_LIST = "select * from customer_list";
}
