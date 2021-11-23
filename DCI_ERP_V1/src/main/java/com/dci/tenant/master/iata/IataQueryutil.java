package com.dci.tenant.master.iata;

public class IataQueryutil {
	/*
	 * public static String Selectivity_bean =
	 * "select cty_id as id,concat(cty_cd, '-', cty_nam) as text from CITY";
	 */
	public static String Selectivity_bean = "select cntry_id as id,concat(cntry_cd, '-', cntry_nam) as text from country";
	public static final String list = "SELECT ct.cntry_nam as iataCityName,cc.iata_id as iataid,cc.iata_cd as iataCode,cc.iata_nam as iataName, (select em.emp_name from employee_master em where cc.crtd_by =em.emp_id) as crtdBy, to_char(cc.crtd_dt,'dd/mm/yyyy')crtdDate,(select em.emp_name from employee_master em where cc.mdfd_by =em.emp_id) as mdyBy,to_char(cc.mdfd_dt,'dd/mm/yyyy')mdyDate ,cc.cty_id as iataCity, cc.dscrptn_vc as description, "
			+ "CASE WHEN cc.actv_bt= '1'" + "          THEN true" + "         ELSE false END as isStstus  "

			+ "FROM iata cc inner join country ct on ct.cntry_id = cc.cty_id order by cc.iata_id desc";
	public static final String count1 = "select 	coalesce(max(iata_id),0)+1  as iataid from iata";

	public static final String save = "INSERT INTO iata(iata_id,iata_cd, iata_nam, cty_id, dscrptn_vc, actv_bt, crtd_by, crtd_dt,mdfd_by,mdfd_dt)VALUES (?,?, ?, ?,?, pg_catalog.bit(?), ?,now(),?,now());";

	//public static final String edit = "SELECT cc.iata_id as iataid,cc.iata_cd as iataCode,cc.iata_nam as iataName,cc.cty_id as iataCity, cc.dscrptn_vc as description, CASE WHEN cc.actv_bt= '1' THEN true ELSE false END as isStstus,ct.cty_nam as iataCityName, ct.cty_nam as iataCityName FROM iata cc left join city ct on ct.cty_id = cc.cty_id where cc.iata_id = ? ";
	
	public static final String edit = "SELECT cc.iata_id as iataid,cc.iata_cd as iataCode,cc.iata_nam as iataName,cc.cty_id as iataCity, cc.dscrptn_vc as description, CASE WHEN cc.actv_bt= '1' THEN true ELSE false END as isStstus,ct.cntry_nam as iataCityName, ct.cntry_nam as iataCountryName1 FROM iata cc left join country ct on ct.cntry_id = cc.cty_id where cc.iata_id = ?";

	public static final String update = "UPDATE iata SET iata_cd=?, iata_nam=?,cty_id=?, dscrptn_vc=?, actv_bt= pg_catalog.bit(?),mdfd_by=?, mdfd_dt=now() where iata_id =?";

	public static String delete = "delete from iata where iata_id = ? ";

	public static final String duplicate = "select count(*) from iata where iata_cd Ilike ? and iata_nam Ilike ? and cty_id  Ilike ? and dscrptn_vc  Ilike ? and actv_bt Ilike ?";
	public static String SELECT_PREVIOUS_ID = "select max(iata_id) as iataid from iata";
}
