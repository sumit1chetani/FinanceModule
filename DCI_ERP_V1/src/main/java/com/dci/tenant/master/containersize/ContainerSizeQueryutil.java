package com.dci.tenant.master.containersize;

public class ContainerSizeQueryutil {
	public static String Selectivity_bean = "select stt_id as id,concat(stt_cd, '-', stt_nam) as text from state";
	
	public static final String list ="select cntnr_sz_typ_id as containerid,cntnr_sz_typ_cd as code,cntnr_sz_typ_nam as name,dscrptn_vc as description,CASE WHEN actv_bt= '1' THEN true ELSE false END as isStstus,(select em.emp_name from employee_master em where crtd_by =em.emp_id) as crtdBy, to_char(crtd_dt,'dd/mm/yyyy')crtdDate,(select em.emp_name from employee_master em where mdfd_by =em.emp_id) as mdyBy,to_char(mdfd_dt,'dd/mm/yyyy')mdyDate from container_size_type order by cntnr_sz_typ_id desc ";

	public static final String save ="insert into container_size_type(cntnr_sz_typ_id,cntnr_sz_typ_cd,cntnr_sz_typ_nam,dscrptn_vc, crtd_by, crtd_dt,mdfd_by, mdfd_dt,actv_bt) values (?,?,?,?,?,now(),?,now(),pg_catalog.bit(?))";
	
	public static final String edit ="select cntnr_sz_typ_id as containerid,cntnr_sz_typ_cd as code,cntnr_sz_typ_nam as name,dscrptn_vc as description,CASE WHEN actv_bt= '1' THEN true ELSE false END as isStstus from container_size_type where cntnr_sz_typ_id =?";

	public static final String update ="update container_size_type set cntnr_sz_typ_cd=?,cntnr_sz_typ_nam=?,dscrptn_vc=?,mdfd_by=?, mdfd_dt=now(),actv_bt=pg_catalog.bit(?) where cntnr_sz_typ_id =?";
	
	public static String delete = "delete from container_size_type where cntnr_sz_typ_id = ? ";
	
	public static final String count1 ="select case when max(cntnr_sz_typ_id) is null then 1 else max(cntnr_sz_typ_id)+1 end as containerid from container_size_type";


//	public static final String duplicate = "select count(*) from port_icd where prt_icd_cd Ilike ? and prt_icd_nam Ilike ? and cty_id  Ilike ? and dscrptn_vc  Ilike ? and actv_bt Ilike ?";

	//public static String SELECT_PREVIOUS_ID = "select max(prt_icd_id) as portid from port_icd";
}
