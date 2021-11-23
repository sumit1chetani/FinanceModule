package com.dci.tenant.truck.general.chargetype;



public class ChargetypeQueryutil {
	
	public static final String list ="select chargetype_id as chargeTypeid,chargetypecode as chargeTypecode,chargetypename as chargeTypename,Description as chargeTypedescription,is_active as isActive from chargetype";

	public static final String save ="insert into chargetype(chargetypecode,chargetypename,Description,is_active,created_by,created_dt)values(?,?,?,?,?,now())";
	
	public static final String edit ="select chargetype_id as chargeTypeid,chargetypecode as chargeTypecode,chargetypename as chargeTypename,description as chargeTypedescription, is_active as isActive from chargetype where chargetype_id=?";

	public static final String update =" UPDATE chargetype SET chargetypecode=?,chargetypename=?,description=?,is_active=?,modified_by=?,modified_dt=now() WHERE chargetype_id=?";
	
	public static String delete = " delete from chargetype where chargetype_id = ? ";
	
	public static final String duplicate = "select count(*) from chargetype where chargetypecode Ilike ? and chargetypename Ilike ? and description  Ilike ? and is_active Ilike ?";
	
	public static String SELECT_PREVIOUS_ID = "select max(chargetype_id) as taxid from chargetype";
	
}



