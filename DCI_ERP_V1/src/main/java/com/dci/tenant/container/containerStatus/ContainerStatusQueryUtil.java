package com.dci.tenant.container.containerStatus;

public class ContainerStatusQueryUtil {

	public static final String INSERT ="insert into container_status (containerStatus_code,containerStatus_description,isdepot,iscustomer,isshipper,isconsignee,isvessel,isvoyage,ispol,ispod, sub_code,sub_code_desc,created_by, created_dt) values(?,?,?,?,?,?,?,?,?,?,?,?,?, now())";
	
	public static final String list = "select containerStatus_code as containerStatusCode,containerStatus_description as containerStatusDescription,isdepot as depot,iscustomer as customer,"
			+ "isshipper as shipper,isconsignee as consignee,isvessel as vessel,isvoyage as voyage,ispol as pol,ispod as pod from container_status order by created_dt desc";

	
	public static final String delete="delete from container_status where containerStatus_code=?";
	
	public static final String GET_DAMAGE="select cs.containerStatus_code as containerStatusCode,cs.containerStatus_description as containerStatusDescription,emc.emp_name as createdBy , "
			+ "emm.emp_name as modifiedBy , to_char(cs.CREATED_DT,'dd/MM/yyyy')  as createdDate, to_char(cs.MODIFIED_DT,'dd/MM/yyyy') AS modifiedDate from container_status cs "
			+ "left join employee_master emc on emc.emp_id = cs.created_by "
			+ "left  join employee_master emm on emm.emp_id = cs.MODIFIED_BY "
			+ "where containerStatus_code=?";
	
	public static final String UPDATE = "update container_status set containerStatus_description=?,isdepot=?,iscustomer=?,isshipper=?,isconsignee=?,isvessel=?,isvoyage=?,ispol=?,ispod=?,sub_code=? ,sub_code_desc=? where containerStatus_code=?";

	public static String GET_Edit="select containerStatus_code as containerStatusCode,containerStatus_description as containerStatusDescription,isdepot as depot,iscustomer as customer, " +
" isshipper as shipper,isconsignee as consignee,isvessel as vessel,isvoyage as voyage,ispol as pol,ispod as pod,sub_code as subCode, sub_code_desc as subCodeDesc, " + 
" emc.user_name as createdBy,to_char(a.created_dt,'dd/MM/yyyy') as createdDate,emm.user_name  AS modifiedBy,to_char(a.modified_dt,'dd/MM/yyyy') as modifiedDate " +
" from container_status a left join user_master emc on emc.user_id = a.CREATED_BY left join user_master emm on emm.user_id = a.MODIFIED_BY " +			
" where containerStatus_code=?";

}
