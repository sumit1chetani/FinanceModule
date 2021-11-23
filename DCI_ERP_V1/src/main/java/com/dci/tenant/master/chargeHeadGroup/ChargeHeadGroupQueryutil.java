package com.dci.tenant.master.chargeHeadGroup;

public class ChargeHeadGroupQueryutil {
	public static final String list ="SELECT chrg_hd_grp_id as chargeHeadGroupid,chrg_hd_grp_cd as code,chrg_hd_grp_nam as name,(select em.emp_name from employee_master em where crtd_by =em.emp_id)  as crtdBy, to_char(crtd_dt,'dd/mm/yyyy')crtdDate,(select em.emp_name from employee_master em where mdfd_by =em.emp_id) as mdyBy,to_char(mdfd_dt,'dd/mm/yyyy')mdyDate , dscrptn_vc as description, "
+ "CASE WHEN actv_bt= '1'" 
  +"          THEN true"
   +"         ELSE false END as isStstus  "

+"FROM charge_head_group  order by chrg_hd_grp_id desc";	 

	public static final String count1 ="select coalesce(max(chrg_hd_grp_id),0)+1 as chargeHeadGroupid from charge_head_group";

	public static final String save ="INSERT INTO charge_head_group(chrg_hd_grp_id,chrg_hd_grp_cd, chrg_hd_grp_nam,  dscrptn_vc, actv_bt, crtd_by, crtd_dt,mdfd_by,mdfd_dt)VALUES (?,?, ?, ?, pg_catalog.bit(?), ?,now(),?,now());";
	
	public static final String edit ="SELECT chrg_hd_grp_id as chargeHeadGroupid,chrg_hd_grp_cd as code,chrg_hd_grp_nam as name,dscrptn_vc as description, CASE WHEN actv_bt= '1' THEN true ELSE false END as isStstus FROM charge_head_group  where chrg_hd_grp_id = ? ";

	public static final String update ="UPDATE charge_head_group SET chrg_hd_grp_cd=?, chrg_hd_grp_nam=?,dscrptn_vc=?, actv_bt= pg_catalog.bit(?),mdfd_by=?, mdfd_dt=now() where chrg_hd_grp_id =?";
	
	public static String delete = "delete from charge_head_group where chrg_hd_grp_id = ? ";
	

	public static final String duplicate = "select count(*) from charge_head_group where chrg_hd_grp_cd Ilike ? and chrg_hd_grp_nam Ilike ?  and dscrptn_vc  Ilike ? and actv_bt Ilike ?";

	public static String SELECT_PREVIOUS_ID = "select max(chrg_hd_grp_id) as chargeHeadGroupid from charge_head_group";
}
