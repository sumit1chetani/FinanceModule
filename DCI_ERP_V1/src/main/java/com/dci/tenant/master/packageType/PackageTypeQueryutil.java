package com.dci.tenant.master.packageType;

public class PackageTypeQueryutil {
	public static String Selectivity_bean = "select cty_id as id,concat(cty_cd, '-', cty_nam) as text from CITY";
	public static final String list ="SELECT pckg_id as packageTypeid,pckg_cd as code,pckg_nam as name,dscrptn_vc as description, CASE WHEN actv_bt= '1' THEN true ELSE false END as isStstus,(select em.emp_name from employee_master em where crtd_by =em.emp_id) as crtdBy, to_char(crtd_dt,'dd/mm/yyyy')crtdDate,(select em.emp_name from employee_master em where mdfd_by =em.emp_id) as mdyBy,to_char(mdfd_dt,'dd/mm/yyyy')mdyDate  FROM package_type  order by pckg_id desc";

	public static final String save ="INSERT INTO package_type(pckg_id,pckg_cd, pckg_nam, dscrptn_vc, actv_bt, crtd_by, crtd_dt,mdfd_by,mdfd_dt)VALUES (?,?, ?,?, pg_catalog.bit(?), ?,now(),?,now())";
	
	public static final String edit ="SELECT pckg_id as packageTypeid,pckg_cd as code,pckg_nam as name, dscrptn_vc as description,CASE WHEN actv_bt= '1' THEN true ELSE false END as isStstus FROM package_type where pckg_id = ?;";

	public static final String update ="UPDATE package_type SET pckg_cd=?, pckg_nam=?,dscrptn_vc=?,  actv_bt=pg_catalog.bit(?),mdfd_by=?, mdfd_dt=now() where pckg_id =?";
	
	public static String delete = "delete from package_type where pckg_id = ? ";
	
	public static final String count1 ="select coalesce(max(pckg_id),0)+1  as packageTypeid from package_type";

	public static final String duplicate = "select count(*) from package_type where pckg_cd Ilike ? and pckg_nam Ilike ? and  dscrptn_vc  Ilike ? and actv_bt Ilike ?";
	 
	public static String SELECT_PREVIOUS_ID = "select max(pckg_id) as packageTypeid from package_type";
}
