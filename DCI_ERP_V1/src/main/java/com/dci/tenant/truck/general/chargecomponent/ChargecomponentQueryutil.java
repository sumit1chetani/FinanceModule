package com.dci.tenant.truck.general.chargecomponent;


public class ChargecomponentQueryutil {
	
	public static final String list ="SELECT ct.chargetypename as chargeTypeid,cc.chargecomponent_id as chargeComponentid,cc.chargecomponentcode as chargeCode,cc.chargecomponentname as chargeName,cc.chargetype_id as chargeType, cc.description as chargeComponentdescription,cc.is_active as isActive,ct.chargetypename as chargeTypeid FROM chargecomponent cc inner join chargetype ct on ct.chargetype_id::varchar = cc.chargetype_id ";

	public static final String save ="INSERT INTO chargecomponent(chargecomponentcode, chargecomponentname, chargetype_id, description, is_active, created_by, created_dt)VALUES (?, ?, ?,?, ?, ?,now());";
	
	public static final String edit ="SELECT cc.chargecomponent_id as chargeComponentid,cc.chargecomponentcode as chargeCode,cc.chargecomponentname as chargeName,cc.chargetype_id as chargeType, cc.description as chargeComponentdescription,cc.is_active as isActive,ct.chargetypename as chargeTypeid FROM chargecomponent cc inner join chargetype ct on ct.chargetype_id::varchar = cc.chargetype_id where cc.chargecomponent_id = ?;";

	public static final String update ="UPDATE chargecomponent SET chargecomponentcode=?, chargecomponentname=?,chargetype_id=?, description=?, is_active=?,modified_by=?, modified_dt=now() where chargecomponent_id =?";
	
	public static String delete = "delete from chargecomponent where chargecomponent_id = ? ";
	
	public static String Selectivity_bean = "select chargetype_id as id,chargetypename as text from chargetype";

	public static final String duplicate = "select count(*) from chargecomponent where chargecomponentcode Ilike ? and chargecomponentname Ilike ? and chargetype_id  Ilike ? and description  Ilike ? and is_active Ilike ?";

	public static String SELECT_PREVIOUS_ID = "select max(chargecomponent_id) as taxid from chargecomponent";
}
