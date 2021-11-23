package com.dci.finance.storeToPurchase;

public class StoreToPurchaseQueryUtil {

	public static final String GET_EMPLOYEE_LIST = "select emp_id employeeId,emp_id as id,first_name as text,first_name employeeName,des.designation_id designationId, des.designation_name designationName from employee_master  employee left join designation des on employee.designation_id=des.designation_id inner join branch_department b on b.branch_id =  employee.branch_department_id::text inner join branch br on br.brnch_id::text = b.branch_id inner join company_master c on c.company_code = br.cmpny_id where c.company_code = ? order by first_name";

	public static final String GET_LOCATION_LIST = "select location_id sourceLocation,  location_id destinationLocation ,location_name sourceLocationName,location_name destinationLocationName from location  order by location_name asc";

	public static final String GET_DESTINATIONLOCATION_LIST = "select location_id destinationLocation,  location_id as id, location_name as text,location_name destinationLocationName from location  order by location_name asc";

	public static final String GET_ITEM_LIST = "select item_id  as id, concat(item_new.item_code,' - ',item_new.item_name) as text,item_id itemId, item_code itemCode,item_name itemName,item_description itemDesc,item_category itemCategoryName,uom.uom_id uomId,uom.uom uomName from item_new item_new left join" + " uom uom on item_new.uom=uom.uom_id where item_new.item_type!=15 and item_new.company_id = ? ";

	public static final String GET_ITEM_DATA_ONCHANGE = "select item_id itemId, item_code itemCode,item_name itemName,item_description itemDesc,item_category.item_category_id itemCategoryId,item_category.category_name itemCategoryName,uom.uom_id uomId,uom.uom uomName" + " from item_new left join  uom uom on item_new.uom=uom.uom_id left join item_category item_category on item_new.item_category = item_category.item_category_id" + " where item_id=?";

	public static final String GENERATE_REQ_NO = "SELECT CASE WHEN MAX(requisition_number) IS NULL  THEN 'PR0001' ELSE 'PR'|| lpad(cast(max(cast(SUBSTRING(requisition_number,3,10) as int)+1) as text),4,'0') END from purchase_requisition";

	public static final String INSERT_STORE_HEADER = "INSERT INTO purchase_requisition(requisition_number, requisition_date, requested_by, requisition_type,requisition_status , destination_location,company_id)" + " VALUES (:requisitionNumber,to_date(:requisitionDate,'dd/mm/yyyy'),:employeeId,:requisitionType,:requisitionStatus,:destinationLocation,:company) returning purchase_requisition_id";

	public static final String INSERT_STORE_SUBDATA = "INSERT INTO purchase_requisition_detail(" + "  purchase_requisition_id, item_id," + " quantity, edd)" + " VALUES (:purchaseRequisitionId,:itemId,:quantity,to_date(:eddDate,'dd/mm/yyyy'))";

	public static final String GET_MAX_N0 = "select max(requisition_number)  from purchase_requisition where requisition_number like 'PR%'";

	public static final String EDIT_HEADER = "SELECT pr.company_id companyId, pr.purchase_requisition_id purchaseRequisitionId, pr.requisition_number requisitionNumber,pr.requisition_status requisitionStatus,def_table.value requisitionStatusName,employee2.employee_id employeeId,pr.validated_date approvedDate, pr.requisition_type requisitionType, to_char(pr.requisition_date,'dd/mm/yyyy') requisitionDate, employee1.employee_id employeeId,employee1.first_name employeeName,employee2.first_name employeeName,designation.designation_id designationId,   designation.designation_name designationName,location1.location_id sourceLocation, location1.location_name sourceLocationName   ,location2.location_id destinationLocation ,location2.location_name destinationLocationnName FROM purchase_requisition pr left join employee employee1 on  pr.requested_by=employee1.employee_id  left join employee employee2 on  pr.validated_by=employee2.employee_id left join designation designation on employee1.designation_id=designation.designation_id left join location location1 on pr.source_location=location1.location_id left join location location2 on pr.destination_location=location2.location_id left join  def_table def_table on  pr.requisition_status=def_table.def_table_id where pr.purchase_requisition_id=?";

	public static final String EDIT_DETAIL = "select item.item_id itemId, item.item_code itemCode,item.item_name itemName,item.item_description itemDesc,item_category.item_category_id itemCategoryId," + " item_category.category_name itemCategoryName,uom.uom_id uomId,uom.uom uomName,purchase_requisition_detail.quantity quantity,to_char(purchase_requisition_detail.edd,'dd/mm/yyyy') eddDate,purchase_requisition_detail.purchase_requisition_id purchaseRequisitionId,"
			+ " purchase_requisition_detail.purchase_requisition_detail_id purchaseRequisitionSubId from purchase_requisition_detail" + " left join item_new item on item.item_id=purchase_requisition_detail.item_id" + " left join  uom uom on item.uom=uom.uom_id" + " left join item_category item_category on item.item_category = item_category.item_category_id" + " where purchase_requisition_detail.purchase_requisition_id=?";

	public static final String SELECT_STORE_LIST =  "SELECT com.company_code companyId,company_name companyName,purchase_requisition_id purchaseRequisitionId, requisition_number requisitionNumber,requisition_status requisitionStatus,def_table.value requisitionStatusName,validated_date approvedDate,   requisition_type requisitionType, to_char(requisition_date,'dd/mm/yyyy') requisitionDate, "
			+ "			  employee1.emp_id employeeId,employee1.first_name employeeName,designation.designation_id designationId,   designation.designation_name designationName,location1.location_id sourceLocation, location1.location_name sourceLocationName   ,location2.location_id destinationLocation ,location2.location_name destinationLocationName   FROM purchase_requisition left join employee_master employee1 on  purchase_requisition .requested_by=employee1.emp_id "
			+ "			  left join designation designation on employee1.designation_id=designation.designation_id  left join company_master com on com.company_code =purchase_requisition.company_id left join location location1 on purchase_requisition .source_location=location1.location_id   left join location location2 on purchase_requisition .destination_location=location2.location_id   left join  def_table def_table on  purchase_requisition.requisition_status=def_table.def_table_id where requisition_type=118  and com.company_code = ? order by requisition_number desc";

	public static final String DELETE_DETAIL = "delete  from purchase_requisition_detail where purchase_requisition_id =?";

	public static final String UPDATE_STORE_HEADER = "update purchase_requisition set requisition_number=:requisitionNumber, requisition_date=to_date(:requisitionDate,'dd/mm/yyyy'), requested_by=:employeeId, requisition_type=:requisitionType,requisition_status=:requisitionStatus, destination_location=:destinationLocation ,company_id =:company where  purchase_requisition_id=:purchaseRequisitionId ";

	public static final String DELETE_HEADER = "delete from purchase_requisition where purchase_requisition_id=?";

	public static String COUNT_MAX = "SELECT count(*) FROM purchase_requisition_detail WHERE purchase_requisition_id=?";

	public static final String sGetAssetItemList = "select it.item_id as id,concat(it.item_Code,'-',it.item_name) as text,ic.category_name as itemCategoryName,um.uom as uomName from item_new it INNER JOIN item_category ic on ic.item_category_id=it.item_category INNER JOIN uom  um on um.uom_id=it.uom  where it.item_type=15 order by it.item_code,it.item_name  ";

}
