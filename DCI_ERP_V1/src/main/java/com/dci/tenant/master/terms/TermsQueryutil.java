package com.dci.tenant.master.terms;

public class TermsQueryutil {
	public static String Selectivity_bean = "select stt_id as id,concat(stt_cd, '-', stt_nam) as text from state";
	
	public static final String list ="select trm_id as termid,trm_cd as code,trm_nam as name,dscrptn_vcr as description,CASE WHEN actv_bt= '1' THEN true ELSE false END as isStstus,(select em.emp_name from employee_master em where crtd_by =em.emp_id) as crtdBy, to_char(crtd_dt,'dd/mm/yyyy')crtdDate,(select em.emp_name from employee_master em where mdfd_by =em.emp_id) as mdyBy,to_char(mdfd_dt,'dd/mm/yyyy')mdyDate from terms order by trm_id desc ";

	public static final String save ="insert into terms(trm_id,trm_cd,trm_nam,dscrptn_vcr, crtd_by, crtd_dt,mdfd_by, mdfd_dt,actv_bt) values (?,?,?,?,?,now(),?,now(),pg_catalog.bit(?))";
	
	public static final String edit ="select trm_id as termid,trm_cd as code,trm_nam as name,dscrptn_vcr as description,CASE WHEN actv_bt= '1' THEN true ELSE false END as isStstus from terms where trm_id =?";

	public static final String update ="update terms set trm_cd=?,trm_nam=?,dscrptn_vcr=?,mdfd_by=?, mdfd_dt=now(),actv_bt=pg_catalog.bit(?) where trm_id =?";
	
	public static String delete = "delete from terms where trm_id = ? ";
	
	public static final String count1 ="select case when max(trm_id) is null then 1 else max(trm_id)+1 end as termid from terms";


//	public static final String duplicate = "select count(*) from port_icd where prt_icd_cd Ilike ? and prt_icd_nam Ilike ? and cty_id  Ilike ? and dscrptn_vcr  Ilike ? and actv_bt Ilike ?";

	//public static String SELECT_PREVIOUS_ID = "select max(prt_icd_id) as portid from port_icd";
}
