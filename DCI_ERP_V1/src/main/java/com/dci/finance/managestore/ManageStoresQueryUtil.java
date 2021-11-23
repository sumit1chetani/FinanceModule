package com.dci.finance.managestore;

public class ManageStoresQueryUtil {

	public static String get_ManageStores_List = "select location_name as manageName,location_id as locationId,address_id as addressId,location.is_active as isActive ,def_table.value as locationType,employee.first_name as locationIncharge from location left join def_table on def_table.def_table_id=location.location_type left join employee_master  employee on employee.emp_id=location.location_incharge where type = 'MS' order by location_id desc ";

	public static String add_ManageStoresaddress_Data = "INSERT INTO address ( city_id,street,created_by,created_date) values(?,?,?,now()) RETURNING address_id";

	public static String add_ManageStores_Data = "INSERT INTO location (location_name,parent_location_id,location_type,address_id,location_incharge,location_activity,is_scrap_location,is_stock_location,is_active,created_by,created_date,type,is_parent_address) values(?,?,?,?,?,?,?,?,?,?,now(),?,?)";

	public static final String getEditList = "select location_id as locationId,location_name as manageName,coalesce(parent_location_id,0) as pid,address_id as addressId,location_type as lid,location_incharge as empId,location_activity as locationActivity,is_scrap_location as scrapLocation,is_active as isActive,location_incharge as locationIncharge,is_parent_address as isParentAddress from location where location_id= ?";

	public static String update_ManageStores_Data = "UPDATE location SET parent_location_id=?,location_type=?,location_incharge=?,location_activity=?,is_scrap_location=?,is_active=?,modified_by=?,modified_date=?,address_id=?,is_parent_address=?,location_name=? WHERE location_id= ?";

	public static final String delete_ManageStoresaddress_data = "DELETE FROM address WHERE address_id = ? ";

	public static String delete_ManageStores_data = "DELETE FROM location WHERE location_id = ?";

	public static final String sCheckStoreName = "SELECT count(*) FROM location WHERE location_name=? and type='MS'";

	public static final String getAddressId = "select address_id from location where location_id=?";

	public static final String update_ManageStoresaddress_Data = "update address set city_id=?,street=?,modified_by=?,modified_date = now() where address_id = ? RETURNING address_id";

	public static final String getEditAddressList = "select ad.city_id as cityId,ad.street as address,c.cty_nam as city from address ad left join city c on c.cty_id = ad.city_id where ad.address_id =?";

	public static final String get_ParentLocation = "WITH RECURSIVE q AS (SELECT location_id ,cast(location_name as varchar(255)) as path FROM location WHERE parent_location_id is null and is_active='t' UNION ALL SELECT ic.location_id,cast( q.path ||' / ' || cast(ic.location_name as varchar(255)) as  varchar(255)) FROM location ic JOIN q ON  ic.parent_location_id =  q.location_id where ic.type='MS' and ic.is_active='t') SELECT location_id as id,path as text  FROM q";

	public static final String get_LocationType = "select value as locationType,def_table_id as lid from def_table where form_field_id=2";

	public static final String get_LocationInCharge = "select concat(first_name,' ',surname) as locationIncharge,emp_id as empId from employee_master";

	public static final String getState = "select state.stt_nam as state,zp_cd as zipCode from city left join state on state.stt_id=city.stt_id where cty_id= ? ";

	public static final String getCity = "select cty_nam as city,cty_id as cityId from city";

	public static final String getCountry = "select c.zp_cd as zipCode,s.stt_nam as state,co.cntry_nam as country from city c left join state s on s.stt_id = c.stt_id left join country co on co.cntry_id = s.cntry_id where c.cty_id=?";

	public static final String getCityedit = "select a.city_id cityId,a.address_id as addressId ,c.cty_nam city from address a,city c where a.city_id=c.cty_id and  a.address_id= ?";

	public static final String getParentAddress = "select ad.street as address,c.cty_id as cityId,c.cty_nam as city,c.zp_cd as zipCode,s.stt_nam as state,co.cntry_nam as country from location lo left join address ad on ad.address_id = lo.address_id left join city c on c.cty_id = ad.city_id left join state s on s.stt_id = c.stt_id left join country co on co.cntry_id = s.cntry_id where lo.location_id = ?";

	public static final String getParentIdEdit = "WITH RECURSIVE q AS (SELECT location_id ,cast(location_name as varchar(255)) as path FROM location WHERE parent_location_id is null UNION ALL SELECT ic.location_id,cast( q.path ||' / ' || cast(ic.location_name as varchar(255)) as  varchar(255)) FROM location ic JOIN q ON  ic.parent_location_id =  q.location_id ) SELECT location_id as pid,path as parentLocation  FROM q where location_id=?";

	public static final String deletePurchaseRequsitionSource = "delete from purchase_requisition where source_location = ?";

	public static final String deletePurchaseRequsitionDestination = "delete from purchase_requisition where source_location = ?";
}
