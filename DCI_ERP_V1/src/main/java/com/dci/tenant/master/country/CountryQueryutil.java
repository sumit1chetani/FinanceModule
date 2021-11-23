package com.dci.tenant.master.country;

public class CountryQueryutil {
	public static String Selectivity_bean = "select rgn_id as id,concat(rgn_cd, '-', rgn_nam) as text from region";
	
	public static final String list ="select r.rgn_nam as regionName,c.cntry_id as countryid,c.cntry_cd as code,c.cntry_nam as name,c.rgn_id as region,c.dscrptn_vc as description,CASE WHEN c.actv_bt= '1' THEN true ELSE false END as isStstus,(select em.emp_name from employee_master em where c.crtd_by =em.emp_id) as crtdBy, to_char(c.crtd_dt,'dd/mm/yyyy')crtdDate,(select em.emp_name from employee_master em where c.mdfd_by =em.emp_id) as mdyBy,to_char(c.mdfd_dt,'dd/mm/yyyy')mdyDate  from country c inner join region r on r.rgn_id = c.rgn_id order by cntry_id desc";

	public static final String save ="INSERT INTO country(cntry_id,cntry_cd, cntry_nam, rgn_id, dscrptn_vc, crtd_by, crtd_dt,mdfd_by, mdfd_dt,actv_bt)VALUES (?,?, ?, ?,?, ?,now(),?,now(),pg_catalog.bit(?))";
	
	public static final String edit ="select c.cntry_id as countryid,c.cntry_cd as code,c.cntry_nam as name,c.rgn_id as region,concat(r.rgn_cd,'-',r.rgn_nam) as regionName,c.dscrptn_vc as description,CASE WHEN c.actv_bt= '1' THEN true ELSE false END as isStstus from country c inner join region r on r.rgn_id = c.rgn_id where c.cntry_id=?";

	public static final String update ="UPDATE country SET cntry_cd=?, cntry_nam=?,rgn_id=?, dscrptn_vc=?,mdfd_by=?, mdfd_dt=now(),actv_bt=pg_catalog.bit(?) where cntry_id =?";
	
	public static String delete = "delete from country where cntry_id = ? ";
	
	public static final String count1 ="select case when max(cntry_id) is null then 1 else max(cntry_id)+1 end as countryid from country";


//	public static final String duplicate = "select count(*) from port_icd where prt_icd_cd Ilike ? and prt_icd_nam Ilike ? and cty_id  Ilike ? and dscrptn_vc  Ilike ? and actv_bt Ilike ?";

	//public static String SELECT_PREVIOUS_ID = "select max(prt_icd_id) as portid from port_icd";
}
