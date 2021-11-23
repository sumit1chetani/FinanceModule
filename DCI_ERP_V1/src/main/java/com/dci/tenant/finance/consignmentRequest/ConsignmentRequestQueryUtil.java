package com.dci.tenant.finance.consignmentRequest;

public class ConsignmentRequestQueryUtil {

	public static final String GET_EMPLOYEE_LIST = "select emp_id employeeId,emp_id as id,first_name as text,first_name employeeName,des.designation_id designationId, des.designation_name designationName from employee_master employee left join designation des on employee.designation_id=des.designation_id inner join branch_department b on b.branch_department_id =  employee.branch_department_id inner join branch br on br.brnch_id ::text= b.branch_id inner join company_master c on c.company_code = br.cmpny_id  where c.company_code = ? order by first_name";

	public static final String GET_SOURCELOCATION_LIST = "select location_id sourceLocation,  location_id as id, location_name as text,location_name sourceLocationName from location  order by location_name asc";

	public static final String GET_DESTINATIONLOCATION_LIST = "select location_id destinationLocation,  location_id as id, location_name as text,location_name destinationLocationName from location  order by location_name asc";

	public static final String GET_ITEM_LIST = "select item_id  as id, concat(item_new.item_code,' - ',item_new.item_name) as text,item_id itemId from item_new left join uom uom on item_new.uom=uom.uom_id where item_new.item_type!=15";

	public static final String GET_ITEM_DATA_ONCHANGE = "select item.item_id  as id,item.item_id itemId,item.item_code as text, item_code itemCode,item.item_name itemName,item.item_description itemDesc,item_category.item_category_id itemCategoryId,item_category.category_name itemCategoryName,uom.uom_id uomId,uom.uom uomName, case when null_or_empty(altuom::text) = false then altuom else 0 end as altuom ,(select uom from uom where uom_id = case when null_or_empty(altuom::text) = false then altuom else 0 end limit 1)  altuomName, coalesce(altqty,0) as altqty  from item_new item left join  uom uom on item.uom=uom.uom_id left join item_category item_category on item.item_category = item_category.item_category_id  where item.item_id=?";

	public static final String GET_PURCHASE_ORDER_DETAIL_PRICE = "select coalesce(unit_price,0) as oldUnitPrice from purchase_order_detail where purchase_order_detail_id =(select coalesce(max(podtl.purchase_order_detail_id),0) purchase_order_detail_id from purchase_order_detail podtl inner join purchase_order por on por.purchase_order_id = podtl.purchase_order_id where item_id=? and purchase_order_detail_id not in (select max(pod.purchase_order_detail_id) from purchase_order_detail pod inner join purchase_order po on po.purchase_order_id = pod.purchase_order_id where pod.item_id=?))";

	// public static String GET_GRN_QTY =
	// "select COALESCE(sum(quantity),0) from grn_detail where item_id = ?";
	//
	// public static String GET_MI_QTY1 =
	// "select COALESCE(sum(quantity),0) from stock_transfer_detail where item_id =
	// ? ";

	public static final String GENERATE_REQ_NO = "SELECT CASE WHEN MAX(?) IS NULL  THEN 'PR0001' ELSE 'PR'|| lpad(cast(max(cast(SUBSTRING(?,3,10) as int)+1) as text),4,'0') END from purchase_requisition";

	public static final String GENERATE_REQ_NO_1 = "SELECT CASE WHEN MAX(requisition_number) IS NULL  THEN 'PR0001' ELSE 'PR'|| lpad(cast(max(cast(SUBSTRING(requisition_number,3,10) as int)+1) as text),4,'0') END from purchase_requisition";

	public static final String GENERATE_REQ_NO_SERIES = "SELECT MAX(SPLIT_PART(requisition_number, '-', 2))  from  purchase_requisition";

	public static final String GET_SHORT_NAME = "select short_name from company_master where company_code  = ? ";

	public static final String INSERT_CONSIGNMENT_HEADER = "INSERT INTO purchase_requisition(requisition_number, requisition_date, requested_by, requisition_type, source_location, destination_location,company_id,requisition_status, costcenter,pr_request_number,pr_request_date,request_type , request_type_flag )"
			+ " VALUES (:requisitionNumber,to_date(:requisitionDate,'dd/mm/yyyy'),:employeeId,:requisitionType,:sourceLocation,:destinationLocation,:company,:requisitionStatus,:costcenter,:prrequestnumber,to_date(:prrequestdate,'dd/mm/yyyy'),:requestType,:flag) returning purchase_requisition_id";

	public static final String INSERT_CONSIGNMENT_HEADER_EXCEL_IMPORT = "INSERT INTO purchase_requisition(requisition_number, requisition_date, requested_by, requisition_type, source_location, destination_location,company_id,requisition_status, costcenter,pr_request_number,pr_request_date,request_type , request_type_flag )"
			+ " VALUES (:requisitionNumber,to_date(:requisitionDate,'dd/mm/yyyy'),:employeeId,:requisitionType,:sourceLocation,:destinationLocation,:company,:requisitionStatus,:costcenter,:prrequestnumber,to_date(:requisitionDate,'dd/mm/yyyy'),:requestType,:flag) returning purchase_requisition_id";
	/*
	 * public static final String INSERT_CONSIGNMENT_HEADER_EXCEL_IMPORT =
	 * "INSERT INTO purchase_requisition(requisition_date, requested_by, requisition_type, source_location, destination_location,company_id,requisition_status, costcenter,pr_request_number,pr_request_date,request_type , request_type_flag )"
	 * +
	 * " VALUES (to_date(:requisitionDate,'dd/mm/yyyy'),:employeeId,:requisitionType,:sourceLocation,:destinationLocation,:company,:requisitionStatus,:costcenter,:prrequestnumber,to_date(:requisitionDate,'dd/mm/yyyy'),:requestType,:flag) returning purchase_requisition_id"
	 * ;
	 */

	public static final String INSERT_CONSIGNMENT_SUBDATA = "INSERT INTO purchase_requisition_detail(" + "  purchase_requisition_id, item_id," + " quantity, edd,item_desc,pending_quantity,altuom,altqty)" + " VALUES (:purchaseRequisitionId,:itemId,:quantity,to_date(:eddDate,'dd/mm/yyyy'),:itemdescription,:pendingQty,:altuom,:altqty)";

	public static final String INSERT_CONSIGNMENT_SUBDATA_EXCEL_IMPORT = "INSERT INTO purchase_requisition_detail(" + "  purchase_requisition_id, item_id," + " quantity, edd,item_desc,pending_quantity)" + " VALUES (:purchaseRequisitionId,:itemId,:quantity,to_date(:eddDate,'dd/mm/yyyy'),:itemdescription,:pendingQty)";

	public static final String EDIT_HEADER = "SELECT purchase_requisition.company_id companyId,purchase_requisition_id purchaseRequisitionId, requisition_number requisitionNumber,costcenter costcenter,requisition_type requisitionType, to_char(requisition_date,'dd/mm/yyyy') requisitionDate, employee.emp_id employeeId,employee.first_name employeeName,designation.designation_id designationId, designation.designation_name designationName,requisition_type requisitionType,location1.location_id sourceLocation, location1.location_name sourceLocationName, location2.location_id destinationLocation ,location2.location_name destinationLocationName, requisition_status requisitionStatus,def_table.value requisitionStatusName,pr_request_number as prRequestNo,to_char(pr_request_date,'dd/mm/yyyy') as requestDate,request_type as requestType  FROM purchase_requisition left join employee_master employee on  purchase_requisition .requested_by=employee.emp_id left join designation designation on employee.designation_id=designation.designation_id left join location location1 on purchase_requisition .source_location=location1.location_id left join location location2 on purchase_requisition .destination_location=location2.location_id left join  def_table def_table on  purchase_requisition.requisition_status=def_table.def_table_id where purchase_requisition_id=?";

	public static final String GET_MAX_N0 = "select max(requisition_number)  from purchase_requisition where requisition_number like 'PR%'";

	public static final String EDIT_DETAIL = "select item.item_id itemId, item.item_code itemCode,item.item_name itemName,item.item_description itemDesc,item_category.item_category_id itemCategoryId," + " item_category.category_name itemCategoryName,uom.uom_id uomId,uom.uom uomName,purchase_requisition_detail.quantity quantity,to_char(purchase_requisition_detail.edd,'dd/mm/yyyy') eddDate,item_desc itemdescription, purchase_requisition_detail.purchase_requisition_id purchaseRequisitionId,"
			+ " purchase_requisition_detail.purchase_requisition_detail_id purchaseRequisitionSubId , purchase_requisition_detail.altuom , (select uom from uom where uom_id = purchase_requisition_detail.altuom limit 1 ) as altuomName,  purchase_requisition_detail.altqty from purchase_requisition_detail" + " left join item_new item on item.item_id=purchase_requisition_detail.item_id" + " left join  uom uom on item.uom=uom.uom_id" + " left join item_category item_category on item.item_category = item_category.item_category_id"
			+ " where purchase_requisition_detail.purchase_requisition_id=?";

	// public static final String SELECT_CONSIGNMENT_LIST =
	// "SELECT com.company_id companyId,company_name
	// companyName,purchase_requisition_id
	// purchaseRequisitionId,requisition_number
	// requisitionNumber,requisition_type requisitionType,
	// to_char(requisition_date,'dd/mm/yyyy')
	// requisitionDate,employee.employee_id
	// employeeId,employee.first_name employeeName,designation.designation_id
	// designationId,designation.designation_name
	// designationName,requisition_type
	// requisitionType,location1.location_id sourceLocation,
	// location1.location_name
	// sourceLocationName ,location2.location_id destinationLocation
	// ,location2.location_name destinationLocationName,requisition_status
	// requisitionStatus,def_table.value requisitionStatusName,pr_request_number
	// as
	// prRequestNo FROM purchase_requisition left join employee employee on
	// purchase_requisition .requested_by=employee.employee_id left join company
	// com
	// on com.company_id =purchase_requisition.company_id left join designation
	// designation on employee.designation_id=designation.designation_id left
	// join
	// location location1 on purchase_requisition
	// .source_location=location1.location_id left join location location2 on
	// purchase_requisition .destination_location=location2.location_id left
	// join
	// def_table def_table on
	// purchase_requisition.requisition_status=def_table.def_table_id where
	// requisition_type=126 order by purchase_requisition_id desc ";

	public static final String SELECT_CONSIGNMENT_LIST = "SELECT com.company_code companyId,company_name companyName,purchase_requisition_id purchaseRequisitionId,requisition_number requisitionNumber,requisition_type requisitionType, to_char(requisition_date,'dd/mm/yyyy') requisitionDate,employee.emp_id employeeId,employee.first_name employeeName,designation.designation_id designationId,designation.designation_name designationName,requisition_type requisitionType,location1.location_id sourceLocation, (WITH RECURSIVE q AS (SELECT location_id ,cast(location_name as varchar(255)) as path FROM location WHERE parent_location_id is null and is_active='t' UNION ALL SELECT ic.location_id,cast( q.path ||' / ' || cast(ic.location_name as varchar(255)) as  varchar(255)) FROM location ic JOIN q ON  ic.parent_location_id =  q.location_id where ic.is_active='t') SELECT path as text  FROM q where location_id not in(11625,11599) and location_id = location1.location_id  ) as sourceLocationName   ,location2.location_id destinationLocation ,(WITH RECURSIVE q AS (SELECT location_id ,cast(location_name as varchar(255)) as path FROM location WHERE parent_location_id is null and is_active='t' UNION ALL SELECT ic.location_id,cast( q.path ||' / ' || cast(ic.location_name as varchar(255)) as  varchar(255)) FROM location ic JOIN q ON  ic.parent_location_id =  q.location_id where ic.is_active='t') SELECT path as text  FROM q where location_id not in(11625,11599) and location_id = location2.location_id  ) as destinationLocationName,requisition_status requisitionStatus,def_table.value requisitionStatusName,pr_request_number as prRequestNo ,  (select value from def_table where def_table_id =purchase_requisition.request_type ) as requestTypeName,request_type_flag as requestTypeflag FROM purchase_requisition left join employee_master employee on  purchase_requisition .requested_by=employee.emp_id left join company_master com on com.company_code =purchase_requisition.company_id left join designation designation on employee.designation_id=designation.designation_id left join location location1 on purchase_requisition .source_location=location1.location_id left join location location2 on purchase_requisition .destination_location=location2.location_id left join  def_table def_table on  purchase_requisition.requisition_status=def_table.def_table_id where requisition_type=126 order by purchase_requisition_id desc ";

	public static final String DELETE_DETAIL = "delete  from purchase_requisition_detail where purchase_requisition_id =?";

	public static final String UPDATE_CONSIGNMENT_HEADER = "update purchase_requisition set requisition_number=:requisitionNumber, requisition_date=to_date(:requisitionDate,'dd/mm/yyyy'), requested_by=:employeeId, requisition_type=:requisitionType, source_location=:sourceLocation, destination_location=:destinationLocation,company_id =:company, costcenter =:costcenter, pr_request_number =:prRequestNo, pr_request_date =to_date(:requestDate,'dd/mm/yyyy'),request_type = :requestType,request_type_flag = :flag where  purchase_requisition_id= :purchaseRequisitionId ";

	public static final String DELETE_HEADER = "delete from purchase_requisition where purchase_requisition_id=?";

	public static final String GET_COST_LIST = "select cost_center_id as id, cost_center_name as text from cost_center  where status=true";

	public static String COUNT_MAX = "SELECT count(*) FROM purchase_requisition_detail WHERE purchase_requisition_id=?";

	public static final String issueStatus = "UPDATE purchase_requisition set  requisition_status= ? WHERE purchase_requisition_id = ?";

	public static final String get_material_req_pdf_header_values = "SELECT c.company_name companyName,purchase_requisition_id purchaseRequisitionId, requisition_number requisitionNumber,cc.cost_center_name costcenterName,requisition_type requisitionType, to_char(requisition_date,'dd/mm/yyyy') requisitionDate, employee.emp_id employeeId,employee.first_name employeeName,designation.designation_id designationId, designation.designation_name designationName,requisition_type requisitionType,location1.location_id sourceLocation, location1.location_name sourceLocationName, location2.location_id destinationLocation ,location2.location_name destinationLocationName, requisition_status requisitionStatus,def_table.value requisitionStatusName,pr_request_number as prRequestNo,to_char(pr_request_date,'dd/mm/yyyy') as requestDate FROM purchase_requisition left join employee_master employee on  purchase_requisition .requested_by=employee.emp_id left join designation designation on employee.designation_id=designation.designation_id left join location location1 on purchase_requisition .source_location=location1.location_id left join location location2 on purchase_requisition .destination_location=location2.location_id left join  def_table def_table on  purchase_requisition.requisition_status=def_table.def_table_id left join cost_center cc on cc.cost_center_id=purchase_requisition.costcenter::int left join company_master c on c.company_code=purchase_requisition.company_id where purchase_requisition_id=?";

	public static final String get_material_req_pdf_detail_values = "select  row_number() over (order by purchase_requisition_detail.purchase_requisition_detail_id)::int as id,item.item_name itemName,item_desc itemDesc, item_category.category_name itemCategoryName,uom.uom uomName,purchase_requisition_detail.quantity quantity,to_char(purchase_requisition_detail.edd,'dd/mm/yyyy') eddDate,purchase_requisition_detail.purchase_requisition_id purchaseRequisitionId, purchase_requisition_detail.purchase_requisition_detail_id purchaseRequisitionSubId from purchase_requisition_detail left join item_new item on item.item_id=purchase_requisition_detail.item_id left join uom uom on item.uom=uom.uom_id left join item_category item_category on item.item_category = item_category.item_category_id where purchase_requisition_detail.purchase_requisition_id=?";

	public static final String GET_MR_QTY = "select quantity from purchase_requisition_detail where purchase_requisition_id = ? and item_id = ? ";

	public static final String GET_PQ_QTY = "select case when  sum(quantity) is null then 0 else sum(quantity) end from purchase_quote_detail where purchase_requisition_id = ? and item_id = ? ";

	public static final String GET_MR_NUM = "select concat(requisition_number,'-',pr_request_number) from purchase_requisition  where purchase_requisition_id   = ?";

	public static final String GET_MR_PENDING_QTY = "select  case when  sum(pending_quantity) is null then 0 else sum(pending_quantity) end from purchase_requisition_detail where purchase_requisition_id = ? and item_id = ? ";

	public static final String UPDATE_CURRENT_QTY = "update item_new set current_qty = ? where item_id = ?";

	public static final String GET_PO_ORIG_QTY = "select  case when  sum(quantity) is null then 0 else sum(quantity) end  from purchase_order_detail  pod left join purchase_order po on po.purchase_order_id = pod.purchase_order_id where purchase_requisition_number = ? and item_id = ?  and  po_amendment is  null ";

	public static final String GET_PO_QTY = "select  case when  sum(quantity) is null then 0 else sum(quantity) end  from purchase_order_detail  pod left join purchase_order po on po.purchase_order_id = pod.purchase_order_id  where purchase_requisition_number = ? and item_id = ? and  (po.mpo_flag = '' or po.mpo_flag is null)";

	public static final String GET_PO1_QTY = "select count(*)  from purchase_order_detail  pod left join purchase_order po on po.purchase_order_id = pod.purchase_order_id  where purchase_requisition_number = ? and item_id = ? and  (po.mpo_flag = '' or po.mpo_flag is null) and po.purchase_order_id = ? ";

	public static final String GET_POA_QTY = "select  case when  sum(quantity) is null then 0 else sum(quantity) end  from purchase_order_detail  pod left join purchase_order po on po.purchase_order_id = pod.purchase_order_id where purchase_requisition_number = ? and item_id = ?  and  po_amendment is not null ";

	public static final String GET_MI_QTY = "select case when  sum(quantity) is null then 0 else sum(quantity) end from stock_transfer_detail std inner join stock_transfer st on st.stock_transfer_id = std.stock_transfer_id  where purchase_requisition_id = ? and item_id = ? ";

	public static final String GET_PO_COUNT = "select count(  po_amendment) from purchase_order_detail  pod left join purchase_order po on po.purchase_order_id = pod.purchase_order_id where purchase_requisition_number = ? and item_id = ?";

	public static final String GET_POA_COUNT = "select case when po_amendment is null then '0' else po_amendment end from purchase_order where purchase_order_id = ?";

	public static final String GET_REQUEST_TYPE_CHECK = "select COALESCE(request_type,0) from purchase_requisition where purchase_requisition_id =  ?";

	public static final String GET_REQUEST_TYPE = "select def_table_id as id , value as text from def_table where form_field_id = ?";

	public static final String GET_REQUEST_NUMBER = "select count(pr_request_number) from purchase_requisition where pr_request_number = ? ";

	public static final String GET_REQUEST_NUMBER_UPDATE = "select count(pr_request_number) from purchase_requisition where pr_request_number = ? and not requisition_number = ? ";

	public static String getCompanyId = "select company_id as companyId from company where company_name =?";

	public static String getLocationId = "select location_id as locationId from location where location_name=?";

	public static String getCostcenterId = "  select cost_center_id as costcenterid from cost_center where cost_center_name=?";

	public static String getrequestedBy = "select employee_id as employeeId from employee where first_name = ?";

	public static String getitemId = "select item_id as itemId from item_new where item_name = ?";

	public static String GET_GRN_QTY = "select COALESCE(sum(converted_quantity_new),0) from grn_detail  where item_id = ?";

	public static String GET_MI_QTY1 = "select COALESCE(sum(quantity),0) from stock_transfer_detail  where item_id = ? ";

	public static final String GET_PO = "select  count(*)  from purchase_order_detail  where purchase_requisition_number = ?   and item_id = ?";

	public static final String GET_MR_EXIST_FLAG = "select  case when sum((select sum(quantity) from purchase_requisition_detail where purchase_requisition_id = ?)) - sum((select sum(quantity) from stock_transfer_detail where stock_transfer_id = stock_transfer.stock_transfer_id ) ) = 0  then true else false end  from stock_transfer  where purchase_requisition_id    in (?) ";

	public static final String GET_MR_EXIST = "select  case when count(*)>0  then true else false end  from stock_transfer_detail  where purchase_requisition_detail_id    in (?) ";

	// public static final String UPDATE_CONSIGNMENT_SUBDATA = "update
	// purchase_requisition_detail set quantity =:quantity ,edd =
	// (:eddDate,'dd/mm/yyyy') ,
	// item_desc=:itemdescription,altuom=:altuom,altqty=:altqty where
	// purchase_requisition_id =:purchaseRequisitionId and item_id =:itemId ";

	public static final String UPDATE_CONSIGNMENT_SUBDATA = "update purchase_requisition_detail set quantity =?,edd = to_date(?,'dd/mm/yyyy') , item_desc=?,altuom=?,altqty=?  where purchase_requisition_id =? and item_id =? ";

}
