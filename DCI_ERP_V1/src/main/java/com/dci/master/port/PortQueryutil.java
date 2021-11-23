package com.dci.master.port;

public class PortQueryutil {
	public static String Selectivity_bean = "select cty_id as id,concat(cty_cd, '-', cty_nam) as text from CITY";
	public static final String list ="SELECT ct.cntry_nam as cityName,cc.prt_icd_id as portid,cc.prt_icd_cd as code,cc.prt_icd_nam as name,cc.cty_id as city, cc.dscrptn_vc as description,CASE WHEN cc.actv_bt= '1' THEN true ELSE false END as isStstus,(select em.emp_name from employee_master em where cc.crtd_by =em.emp_id) as crtdBy, to_char(cc.crtd_dt,'dd/mm/yyyy')crtdDate,(select em.emp_name from employee_master em where cc.mdfd_by =em.emp_id) as mdyBy,to_char(cc.mdfd_dt,'dd/mm/yyyy')mdyDate  FROM port_icd cc left join country ct on ct.cntry_id = cc.cty_id order by prt_icd_id desc";

	public static final String save ="INSERT INTO port_icd(prt_icd_id,prt_icd_cd, prt_icd_nam, cty_id, dscrptn_vc, actv_bt,port_bt,icd_bt,depot_bt,loc_bt, crtd_by, crtd_dt,mdfd_by,mdfd_dt)VALUES (?,?, ?, ?,?, pg_catalog.bit(?),?::bit,?::bit,?::bit,?::bit, ?,now(), ?,now())";
	
	public static final String edit ="SELECT cc.prt_icd_id as portid,cc.prt_icd_cd as code,cc.prt_icd_nam as name,cc.cty_id as city, cc.dscrptn_vc as description,CASE WHEN cc.actv_bt= '1' THEN true ELSE false END as isStstus,ct.cntry_nam as countryName,CASE WHEN cc.port_bt= '1' THEN true ELSE false END as isPort,CASE WHEN cc.loc_bt= '1' THEN true ELSE false END as isLocation,CASE WHEN cc.icd_bt= '1' THEN true ELSE false END as isIcd,CASE WHEN cc.depot_bt= '1' THEN true ELSE false END as isDepot FROM port_icd cc left join country ct on ct.cntry_id = cc.cty_id  where cc.prt_icd_id = ?";

	public static final String update ="UPDATE port_icd SET prt_icd_cd=?, prt_icd_nam=?,cty_id=?, dscrptn_vc=?, actv_bt=pg_catalog.bit(?),mdfd_by=?, mdfd_dt=now(),port_bt=?::bit,icd_bt=?::bit,depot_bt=?::bit ,loc_bt=?::bit where prt_icd_id =?";
	
	public static String delete = "delete from port_icd where prt_icd_id = ? ";
	public static final String count1 ="select coalesce(max(prt_icd_id),0)+1 as portid from port_icd";
	

	public static final String duplicate = "select count(*) from port_icd where prt_icd_cd Ilike ? and prt_icd_nam Ilike ? and cty_id  Ilike ? and dscrptn_vc  Ilike ? and actv_bt Ilike ?";

	public static String SELECT_PREVIOUS_ID = "select max(prt_icd_id) as portid from port_icd";
}
