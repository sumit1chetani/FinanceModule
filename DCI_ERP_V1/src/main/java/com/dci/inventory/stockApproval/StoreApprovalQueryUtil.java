package com.dci.inventory.stockApproval;

public class StoreApprovalQueryUtil {

	public static final String GET_EMPLOYEE_LIST = "select emp_id employeeId,emp_id as id,first_name as text,first_name employeeName,des.designation_id designationId, des.designation_name designationName" + " from employee_master  employee left join designation des on employee.designation_id=des.designation_id order by first_name Asc";

	public static final String GET_LOCATION_LIST = "select location_id sourceLocation,  location_id destinationLocation ,location_name sourceLocationName,location_name destinationLocationName from location  order by location_name asc";

	public static final String GET_ITEM_LIST = "select item_id  as id, concat(item.item_code,' - ',item.item_name) as text,item_id itemId, item_code itemCode,item_name itemName,item_description itemDesc,item_category itemCategoryName,uom.uom_id uomId,uom.uom uomName from item_new item left join" + " uom uom on item.uom=uom.uom_id";

	public static final String GET_ITEM_DATA_ONCHANGE = "select item_id itemId, item_code itemCode,item_name itemName,item_description itemDesc,item_category.item_category_id itemCategoryId,item_category.category_name itemCategoryName,uom.uom_id uomId,uom.uom uomName" + " from item_new left join  uom uom on item_new.uom=uom.uom_id left join item_category item_category on item_new.item_category = item_category.item_category_id" + " where item_id=?";

	public static final String GENERATE_REQ_NO = "SELECT CASE WHEN MAX(requisition_number) IS NULL  THEN 'PR0001' ELSE rpad(MAX(requisition_number),2,'PR')||" + " lpad(cast(cast((SUBSTRING(MAX(requisition_number),4)) as int)+1  as text),4,'0') END FROM purchase_requisition";

	public static final String INSERT_STORE_SUBDATA = "INSERT INTO purchase_requisition_detail(" + "  purchase_requisition_id, item_id," + " quantity, edd)" + " VALUES (:purchaseRequisitionId,:itemId,:quantity,to_date(:eddDate,'dd/mm/yyyy'))";

	public static final String EDIT_HEADER = "SELECT purchase_requisition_id purchaseRequisitionId, requisition_number requisitionNumber,requisition_status requisitionStatus,def_table.value requisitionStatusName,to_char(validated_date ,'dd/mm/yyyy') approvedDate,remarks remarks,  requisition_type requisitionType, to_char(requisition_date,'dd/mm/yyyy') requisitionDate, "
			+ "			 employee1.emp_id employeeId,employee1.first_name employeeName,designation.designation_id designationId,   designation.designation_name designationName,location1.location_id sourceLocation, location1.location_name sourceLocationName   ,location2.location_id destinationLocation ,location2.location_name destinationLocationnName,pr_request_number as prRequestNo,to_char(pr_request_date,'dd/mm/yyyy') as requestDate "
			+ "			 FROM purchase_requisition left join employee_master employee1 on  purchase_requisition .requested_by=employee1.emp_id   left join designation designation on employee1.designation_id=designation.designation_id   left join location location1 on purchase_requisition .source_location=location1.location_id   left join location location2 on purchase_requisition .destination_location=location2.location_id left join  def_table def_table on  purchase_requisition.requisition_status=def_table.def_table_id where "
			+ "			 purchase_requisition_id=?";

	public static final String EDIT_DETAIL = "select item.item_id itemId, concat(item.item_code||' - '||item.item_name) as itemName,item.item_description itemDesc,item_category.item_category_id itemCategoryId," + " item_category.category_name itemCategoryName,uom.uom_id uomId,uom.uom uomName,purchase_requisition_detail.quantity quantity1,to_char(purchase_requisition_detail.edd,'dd/mm/yyyy') eddDate,purchase_requisition_detail.purchase_requisition_id purchaseRequisitionId,"
			+ " purchase_requisition_detail.purchase_requisition_detail_id purchaseRequisitionSubId from purchase_requisition_detail" + " left join item_new item on item.item_id=purchase_requisition_detail.item_id" + " left join  uom uom on item.uom=uom.uom_id" + " left join item_category item_category on item.item_category = item_category.item_category_id" + " where purchase_requisition_detail.purchase_requisition_id=?";

	public static final String SELECT_STORE_LIST =  "SELECT purchase_requisition_id purchaseRequisitionId, requisition_number requisitionNumber,requisition_status requisitionStatus,def_table.value requisitionStatusName,to_char(validated_date,'dd/mm/yyyy')  approvedDate,   requisition_type requisitionType, to_char(requisition_date,'dd/mm/yyyy') requisitionDate, employee1.emp_id employeeId,employee1.first_name employeeName,designation.designation_id designationId,   designation.designation_name designationName,location1.location_id sourceLocation, location1.location_name sourceLocationName   ,location2.location_id destinationLocation ,location2.location_name destinationLocationName   FROM purchase_requisition left join employee_master employee1 on  purchase_requisition .requested_by=employee1.emp_id  left join company_master com on com.company_code =purchase_requisition.company_id  left join designation designation on employee1.designation_id=designation.designation_id   left join location location1 on purchase_requisition .source_location=location1.location_id   left join location location2 on purchase_requisition .destination_location=location2.location_id   left join  def_table def_table on  purchase_requisition.requisition_status=def_table.def_table_id where (requisition_type=118  or requisition_type=126 ) and com.company_code = ? order by requisition_number desc";

	public static final String DELETE_DETAIL = "delete  from purchase_requisition_detail where purchase_requisition_id =?";

	public static final String UPDATE_STORE_HEADER = "update purchase_requisition set requisition_number=:requisitionNumber, requisition_date=to_date(:requisitionDate,'dd/mm/yyyy'), requisition_type=:requisitionType,requisition_status=:requisitionStatus, destination_location=:destinationLocation,validated_date=to_date(:approvedDate,'dd/mm/yyyy'),validated_by=:approvedId,remarks=:remarks where  purchase_requisition_id=:purchaseRequisitionId ";

	public static final String DELETE_HEADER = "delete from purchase_requisition where purchase_requisition_id=?";

	public static final String GET_STATUS_LIST = " select def_table_id as id,form_field_id formId,value as text from def_table  where form_field_id=39 and is_active='t'";

	public static String COUNT_MAX = "SELECT count(*) FROM purchase_requisition_detail WHERE purchase_requisition_id=?";

	public static final String STATUS_APPROVE = "update purchase_requisition set requisition_status = 67 where purchase_requisition_id = ? ";
}
