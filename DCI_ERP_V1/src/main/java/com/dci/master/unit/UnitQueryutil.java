package com.dci.master.unit;

public class UnitQueryutil {
	public static String Selectivity_bean = "select enm_cd as id,enm_nam as text from enum where enm_typ_nam='MODE'";
	
	public static final String list ="select c.unt_id as unitid,c.unt_cd as code,c.unt_nam as name,c.md_id as mode,c.dscrptn_vc as description,CASE WHEN c.actv_bt= '1' THEN true ELSE false END as isStstus,(select em.emp_name from employee_master em where c.crtd_by =em.emp_id) as crtdBy, to_char(c.crtd_dt,'dd/mm/yyyy')crtdDate,(select em.emp_name from employee_master em where c.mdfd_by =em.emp_id) as mdyBy,to_char(c.mdfd_dt,'dd/mm/yyyy')mdyDate,case when c.md_id = 1 then 'SEA'    when  c.md_id= 2 then 'AIR' END as modeName  from unit c  order by unt_id desc";

	//public static final String list ="select j.mode_name as modeName,c.unt_id as unitid,c.unt_cd as code,c.unt_nam as name,c.md_id as mode,c.dscrptn_vc as description,CASE WHEN c.actv_bt= '1' THEN true ELSE false END as isStstus,(select em.emp_name from employee_master em where c.crtd_by =em.emp_id) as crtdBy, to_char(c.crtd_dt,'dd/mm/yyyy')crtdDate,(select em.emp_name from employee_master em where c.mdfd_by =em.emp_id) as mdyBy,to_char(c.mdfd_dt,'dd/mm/yyyy')mdyDate  from unit c inner join job_transport j on j.mode_id = c.md_id order by unt_id desc";

	public static final String save ="INSERT INTO unit(unt_id,unt_cd, unt_nam, md_id, dscrptn_vc, crtd_by, crtd_dt,mdfd_by, mdfd_dt,actv_bt)VALUES (?,?, ?, ?,?, ?,now(),?,now(),pg_catalog.bit(?))";
	
	//public static final String edit ="select c.unt_id as unitid,c.unt_cd as code,c.unt_nam as name,c.md_id as mode,c.dscrptn_vc as description,CASE WHEN c.actv_bt= '1' THEN true ELSE false END as isStstus from unit c inner join job_transport j on j.mode_id = c.md_id  where c.unt_id=?";
	
	public static final String edit ="select c.unt_id as unitid,c.unt_cd as code,c.unt_nam as name,c.md_id as mode,c.dscrptn_vc as description,CASE WHEN c.actv_bt= '1' THEN true ELSE false END as isStstus,case when c.md_id = 1 then 'SEA'    when  c.md_id= 2 then 'AIR' END as modeName from unit c   where c.unt_id=?";

	public static final String update ="UPDATE unit SET unt_cd=?, unt_nam=?,md_id=?, dscrptn_vc=?,mdfd_by=?, mdfd_dt=now(),actv_bt=pg_catalog.bit(?) where unt_id =?";
	
	public static String delete = "delete from unit where unt_id = ? ";
	
	public static final String count1 ="select case when max(unt_id) is null then 1 else max(unt_id)+1 end as unitid from unit";


//	public static final String duplicate = "select count(*) from port_icd where prt_icd_cd Ilike ? and prt_icd_nam Ilike ? and cty_id  Ilike ? and dscrptn_vc  Ilike ? and actv_bt Ilike ?";

	//public static String SELECT_PREVIOUS_ID = "select max(prt_icd_id) as portid from port_icd";
}
