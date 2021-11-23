package com.dci.tenant.master.city;

public class CityQueryutil {
	public static String Selectivity_bean = "select stt_id as id,concat(stt_cd, '-', stt_nam) as text from state";
	
	public static final String list ="select s.stt_nam as stateName,c.cty_id as cityid,c.cty_cd as code,c.cty_nam as name,c.zp_cd as pin,c.stt_id as state,c.dscrptn_vc as description,CASE WHEN c.actv_bt= '1' THEN true ELSE false END as isStstus,(select em.emp_name from employee_master em where c.crtd_by =em.emp_id) as crtdBy, to_char(c.crtd_dt,'dd/mm/yyyy')crtdDate,(select em.emp_name from employee_master em where c.mdfd_by =em.emp_id) as mdyBy,to_char(c.mdfd_dt,'dd/mm/yyyy')mdyDate from city c inner join state s on s.stt_id = c.stt_id order by c.cty_id desc";

	public static final String save ="insert into city(cty_id,cty_cd,cty_nam,zp_cd,stt_id,dscrptn_vc, crtd_by, crtd_dt,mdfd_by, mdfd_dt,actv_bt) values(?,?,?,?,?,?,?,now(),?,now(),pg_catalog.bit(?))";
	
	//public static final String edit ="select c.cty_id as cityid,c.cty_cd as code,c.cty_nam as name,c.zp_cd as pin,c.stt_id as state,c.dscrptn_vc as description,CASE WHEN c.actv_bt= '1' THEN true ELSE false END as isStstus from city c inner join state s on s.stt_id = c.stt_id where c.cty_id =?";

	public static final String edit ="select c.cty_id as cityid,c.cty_cd as code,c.cty_nam as name,concat(s.stt_cd,'-',s.stt_nam) as stateName,c.zp_cd as pin,c.stt_id as state,c.dscrptn_vc as description,CASE WHEN c.actv_bt= '1' THEN true ELSE false END as isStstus from city c inner join state s on s.stt_id = c.stt_id where c.cty_id =?";

	public static final String update ="UPDATE city SET cty_cd=?, cty_nam=?,zp_cd=?,stt_id=?, dscrptn_vc=?,mdfd_by=?, mdfd_dt=now(),actv_bt=pg_catalog.bit(?) where cty_id =?";
	
	public static String delete = "delete from city where cty_id = ? ";
	
	public static final String count1 ="select case when max(cty_id) is null then 1 else max(cty_id)+1 end as cityid from city";


//	public static final String duplicate = "select count(*) from port_icd where prt_icd_cd Ilike ? and prt_icd_nam Ilike ? and cty_id  Ilike ? and dscrptn_vc  Ilike ? and actv_bt Ilike ?";

	//public static String SELECT_PREVIOUS_ID = "select max(prt_icd_id) as portid from port_icd";
}
