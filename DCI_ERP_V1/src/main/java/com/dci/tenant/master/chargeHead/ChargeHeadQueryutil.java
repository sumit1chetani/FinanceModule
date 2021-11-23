package com.dci.tenant.master.chargeHead;

public class ChargeHeadQueryutil {
	public static String Selectivity_bean = "select chrg_hd_grp_id as id,concat(chrg_hd_grp_cd, '-', chrg_hd_grp_nam) as text from charge_head_group";

	//public static final String list ="SELECT ch.chrg_hd_id as id,ch.chrg_hd_cd as code,ch.chrg_hd_nam as name,ch.chrg_hd_grp_id as group,cg.chrg_hd_grp_nam as groupName,(select em.emp_name from employee_master em where ch.crtd_by =em.emp_id)  as crtdBy, to_char(ch.crtd_dt,'dd/mm/yyyy')crtdDate,(select em.emp_name from employee_master em where ch.mdfd_by =em.emp_id) as mdyBy,sac_no as sacNo,sls_ldgr_nam as sName,prchs_ldgr_nam as pName,to_char(ch.mdfd_dt,'dd/mm/yyyy')mdyDate , ch.dscrptn_vc as description, CASE WHEN ch.actv_bt= '1'  THEN true  ELSE false END as isStstus FROM charge_head ch inner join charge_head_group cg on ch.chrg_hd_grp_id=cg.chrg_hd_grp_id  order by chrg_hd_id desc";
	
	public static final String list = "SELECT ch.chrg_hd_id as id,ch.chrg_hd_cd as code,ch.chrg_hd_nam as name, "
												+ "ch.chrg_hd_grp_id as group,cg.chrg_hd_grp_nam as groupName, "
												+ "(select em.emp_name from employee_master em where ch.crtd_by =em.emp_id)  as crtdBy, "
												+ "to_char(ch.crtd_dt,'dd/mm/yyyy')crtdDate,(select em.emp_name from employee_master em "
												+ "where ch.mdfd_by =em.emp_id) as mdyBy,sac_no as sacNo,ahm.acct_head_name  as sName, "
												+ "ahm1.acct_head_name as pName,to_char(ch.mdfd_dt,'dd/mm/yyyy')mdyDate , "
												+ "ch.dscrptn_vc as description, CASE WHEN ch.actv_bt= '1'  THEN true  ELSE false END as isStstus "
												+ "FROM charge_head ch inner join charge_head_group cg on ch.chrg_hd_grp_id=cg.chrg_hd_grp_id "
												+ "left join account_head_master ahm on ahm.acct_head_code = ch.sls_ldgr_nam "
												+ "left join account_head_master ahm1 on ahm1.acct_head_code =ch.prchs_ldgr_nam "
												+ "order by chrg_hd_id desc";
										
	public static String GET_ACCOUNT_HEAD_LIST="select acct_head_code ||  ' - ' || acct_head_name as text, acct_head_code as id from account_head_master where acct_head_status = 'Y' and subgroup_acct_code='6000'  order by acct_head_name ASC ";
 
	public static String GET_ACCOUNT_HEAD_LIST_Revenue="select acct_head_code ||  ' - ' || acct_head_name as text, acct_head_code as id from account_head_master where acct_head_status = 'Y' and subgroup_acct_code='4001'  order by acct_head_name ASC";
	
	public static final String count1 ="select max(chrg_hd_id)  as id from charge_head";

	public static final String save ="INSERT INTO charge_head(chrg_hd_id,chrg_hd_cd, chrg_hd_nam,chrg_hd_grp_id,  dscrptn_vc,sac_no,sls_ldgr_nam,prchs_ldgr_nam, actv_bt, crtd_by, crtd_dt,mdfd_by,mdfd_dt,cgst_prct,sgst_prct,igst_prct,gst_prct)VALUES ((select coalesce(max(chrg_hd_id),0)+1  as id from charge_head),?, ?, ?, ?,?,?,?,pg_catalog.bit(?), ?,now(),?,now(),?,?,?,?)";
	
	//public static final String edit ="SELECT ch.chrg_hd_id as id,ch.chrg_hd_cd as code,ch.chrg_hd_nam as name,ch.chrg_hd_grp_id as group,cg.chrg_hd_grp_nam as groupName ,sac_no as sacNo,sls_ldgr_nam as sName,prchs_ldgr_nam as pName, ch.dscrptn_vc as description,account_head as accountHead, CASE WHEN ch.actv_bt= '1' THEN true ELSE false END as isStstus,(select acct_head_name from account_head_master ahm where ahm.acct_head_code=ch.account_head) as accountHeadName FROM charge_head ch inner join charge_head_group cg on ch.chrg_hd_grp_id=cg.chrg_hd_grp_id  where chrg_hd_id =?";

	public static final String edit ="SELECT ch.chrg_hd_id as id,ch.chrg_hd_cd as code,ch.chrg_hd_nam as name, "
											+ "ch.chrg_hd_grp_id as group,cg.chrg_hd_grp_nam as groupName ,sac_no as sacNo, "
											+ "sls_ldgr_nam as sName,prchs_ldgr_nam as pName, ch.dscrptn_vc as description, "
											+ "CASE WHEN ch.actv_bt= '1' THEN true ELSE false END as isStstus,ch.cgst_prct as cgst,ch.sgst_prct as sgst,ch.igst_prct as igst,ch.gst_prct as gst FROM charge_head ch "
											+ "inner join charge_head_group cg on ch.chrg_hd_grp_id=cg.chrg_hd_grp_id "
											+ "left join account_head_master ahm on ahm.acct_head_code = ch.sls_ldgr_nam "
											+ "left join account_head_master ahm1 on ahm1.acct_head_code =ch.prchs_ldgr_nam where chrg_hd_id =?";
	
	public static final String view ="SELECT ch.chrg_hd_id as id,ch.chrg_hd_cd as code,ch.chrg_hd_nam as name,ch.chrg_hd_grp_id as group,cg.chrg_hd_grp_nam as groupName ,concat(cg.chrg_hd_grp_cd,'-',cg.chrg_hd_grp_nam) as groupName1,sac_no as sacNo,sls_ldgr_nam as sName,concat(ahm.acct_head_code,'-',ahm.acct_head_name) as slName,prchs_ldgr_nam as pName, concat(ahm1.acct_head_code,'-',ahm1.acct_head_name) as plName,ch.dscrptn_vc as description,CASE WHEN ch.actv_bt= '1' THEN true ELSE false END as isStstus,ch.cgst_prct as cgst,ch.sgst_prct as sgst,ch.igst_prct as igst,ch.gst_prct as gst FROM charge_head ch inner join charge_head_group cg on ch.chrg_hd_grp_id=cg.chrg_hd_grp_id left join account_head_master ahm on ahm.acct_head_code = ch.sls_ldgr_nam left join account_head_master ahm1 on ahm1.acct_head_code =ch.prchs_ldgr_nam where chrg_hd_id =?";
	
	//public static final String update ="UPDATE charge_head SET chrg_hd_cd=?, chrg_hd_nam=?,chrg_hd_grp_id=?,sac_no=?,sls_ldgr_nam=?,prchs_ldgr_nam=?,dscrptn_vc=?, actv_bt= pg_catalog.bit(?),mdfd_by=?, mdfd_dt=now(),cgst_prct=?,sgst_prct=?,igst_prct=?,gst_prct=? where chrg_hd_id =?";
	
	public static String delete = "delete from charge_head where chrg_hd_id = ? ";
	

	//public static final String duplicate = "select count(*) from charge_head where chrg_hd_cd Ilike ? and chrg_hd_grp_nam Ilike ?  and dscrptn_vc  Ilike ? and actv_bt Ilike ?";

	public static String SELECT_PREVIOUS_ID = "select max(chrg_hd_id) as id from charge_head";
	
	
	
	public static String update(String bool) {
		String hdr = "UPDATE charge_head SET chrg_hd_cd=?, chrg_hd_nam=?,chrg_hd_grp_id=?,sac_no=?,sls_ldgr_nam=?,prchs_ldgr_nam=?,dscrptn_vc=?, actv_bt='"+bool+"'::bit(1),mdfd_by=?, mdfd_dt=now(),cgst_prct=?,sgst_prct=?,igst_prct=?,gst_prct=? where chrg_hd_id =?";
		return hdr;
	}
}
