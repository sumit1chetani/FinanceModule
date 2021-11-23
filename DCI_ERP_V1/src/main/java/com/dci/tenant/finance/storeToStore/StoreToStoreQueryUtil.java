package com.dci.tenant.finance.storeToStore;

public class StoreToStoreQueryUtil {

	public static final String GET_EMPLOYEE_LIST = "select emp_id employeeId,emp_id as id,first_name as text,first_name employeeName,des.desgn_code desig, des.desgn_name designationName,c.company_code from employee_master employee  left join designation_master_new des on employee.designation=des.desgn_code inner join branch_department b on b.branch_department_id =  employee.branch_department_id inner join branch br on br.brnch_id ::text= b.branch_id inner join company_master c on c.company_code = br.cmpny_id where c.company_code = ? order by first_name ";
			//+ "select emp_id employeeId,employee_id as id,first_name as text,first_name employeeName,des.designation_id designationId, des.designation_name designationName from employee_master left join designation des on employee.designation_id=des.designation_id inner join branch_department b on b.branch_department_id =  employee.branch_department_id inner join branch br on br.brnch_id = b.branch_id inner join company c on c.company_id = br.company_id where c.company_id = ? order by first_name ";

	public static final String GET_SOURCELOCATION_LIST = "select location_id sourceLocation,  location_id as id, location_name as text,location_name sourceLocationName from location  order by location_name asc";

	public static final String GET_DESTINATIONLOCATION_LIST = "select location_id destinationLocation,  location_id as id, location_name as text,location_name destinationLocationName from location  order by location_name asc";

	public static final String GET_ITEM_LIST = "select item_id  as id, concat(item.item_code,' - ',item.item_name) as text,item_id itemId from item_new item left join" + " uom uom on item.uom=uom.uom_id where item.item_type!=15";

	/*
	 * public static final String GET_ITEM_DATA_ONCHANGE =
	 * "select i.item_id as id,i.item_id itemId,i.item_code as text,i.item_code itemCode,i.item_name itemName,i.item_description itemDesc,item_category.item_category_id itemCategoryId,item_category.category_name itemCategoryName,uom.uom_id uomId,uom.uom uomName,coalesce(item_category.category_type,0) itemCategoryType,iv.vendor_min_qty as physicalQty from item i left join uom uom on i.uom=uom.uom_id left join item_category item_category on i.item_category = item_category.item_category_id inner join item_vendor iv on iv.item_id = i.item_id where i.item_id=?"
	 * ;
	 */

	public static final String GET_ITEM_DATA_ONCHANGE = "select item_id  as id,item_id itemId,item_code as text, item_code itemCode,item_name itemName,item_description itemDesc,item_category.item_category_id itemCategoryId,item_category.category_name itemCategoryName,uom.uom_id uomId,uom.uom uomName ,coalesce(category_type,0) itemCategoryType" + " from item_new left join  uom uom on item_new.uom=uom.uom_id left join item_category item_category on item_new.item_category = item_category.item_category_id" + " where item_id=?";

	// public static final String GENERATE_REQ_NO =
	// "SELECT CASE WHEN MAX(requisition_number) IS NULL  THEN 'PR0001' ELSE rpad(MAX(requisition_number),2,'PR')||"
	// +
	// " lpad(cast(cast((SUBSTRING(MAX(requisition_number),4)) as int)+1  as text),4,'0') END FROM purchase_requisition";

	public static final String GENERATE_REQ_NO = "SELECT CASE WHEN MAX(requisition_number) IS NULL  THEN 'PR0001' ELSE 'PR'|| lpad(cast(max(cast(SUBSTRING(requisition_number,3,10) as int)+1) as text),4,'0') END from purchase_requisition";

	public static final String GET_MAX_N0 = "select max(requisition_number)  from purchase_requisition where requisition_number like 'PR%'";

	public static final String INSERT_STORE_HEADER = "INSERT INTO purchase_requisition(requisition_number, requisition_date, requested_by, requisition_type, source_location, destination_location,company_id)" + " VALUES (:requisitionNumber,to_date(:requisitionDate,'dd/mm/yyyy'),:employeeId,:requisitionType,:sourceLocation,:destinationLocation,:company) returning purchase_requisition_id";

	public static final String INSERT_STORE_SUBDATA = "INSERT INTO purchase_requisition_detail(purchase_requisition_id, item_id,quantity, edd,physical_qty) VALUES (:purchaseRequisitionId,:itemId,:quantity,to_date(:eddDate,'dd/mm/yyyy'),:physicalQty)";

	public static final String UPDATE_STORE_TO_STORE_DETAIL = "";

	public static final String EDIT_HEADER = "SELECT pr.company_id companyId, pr.purchase_requisition_id purchaseRequisitionId, pr.requisition_number requisitionNumber,pr.requisition_type requisitionType, to_char(pr.requisition_date,'dd/mm/yyyy') requisitionDate,employee.employee_id employeeId,employee.first_name employeeName,designation.designation_id designationId, designation.designation_name designationName,requisition_type requisitionType,location1.location_id sourceLocation, location1.location_name sourceLocationName ,location2.location_id destinationLocation ,location2.location_name destinationLocationName FROM purchase_requisition pr left join employee_master employee on  pr.requested_by=employee.employee_id left join designation designation on employee.designation_id=designation.designation_id left join location location1 on pr.source_location=location1.location_id left join location location2 on pr.destination_location=location2.location_id where pr.purchase_requisition_id=?";

	public static final String EDIT_DETAIL = "select item.item_id itemId, item.item_code itemCode,item.item_name itemName,item.item_description itemDesc,item_category.item_category_id itemCategoryId," + " item_category.category_name itemCategoryName,uom.uom_id uomId,uom.uom uomName,purchase_requisition_detail.quantity quantity,coalesce(physical_qty,0) physicalQty,to_char(purchase_requisition_detail.edd,'dd/mm/yyyy') eddDate,purchase_requisition_detail.purchase_requisition_id purchaseRequisitionId,"
			+ " purchase_requisition_detail.purchase_requisition_detail_id purchaseRequisitionSubId from purchase_requisition_detail" + " left join item_new item on item.item_id=purchase_requisition_detail.item_id" + " left join  uom uom on item.uom=uom.uom_id" + " left join item_category item_category on item.item_category = item_category.item_category_id" + " where purchase_requisition_detail.purchase_requisition_id=?";

	public static final String SELECT_STORE_LIST =  "SELECT com.company_code companyId,company_name companyName,purchase_requisition_id purchaseRequisitionId, requisition_number requisitionNumber,requisition_type requisitionType, to_char(requisition_date,'dd/mm/yyyy') requisitionDate, employee.emp_id employeeId,employee.first_name employeeName,designation.designation_id designationId, "
			+ "			 designation.designation_name designationName,requisition_type requisitionType,location1.location_id sourceLocation, location1.location_name sourceLocationName ,location2.location_id destinationLocation ,location2.location_name destinationLocationName FROM purchase_requisition left join employee_master employee on  purchase_requisition .requested_by=employee.emp_id left join designation designation on employee.designation_id=designation.designation_id "
			+ "			 left join location location1 on purchase_requisition .source_location=location1.location_id left join location location2 on purchase_requisition .destination_location=location2.location_id left join company_master com on com.company_code =purchase_requisition.company_id where  requisition_type=119 order by requisition_number desc";

	public static final String DELETE_DETAIL = "delete  from purchase_requisition_detail where purchase_requisition_id =?";

	public static final String UPDATE_STORE_HEADER = "update purchase_requisition set requisition_number=:requisitionNumber, requisition_date=to_date(:requisitionDate,'dd/mm/yyyy'), requested_by=:employeeId, requisition_type=:requisitionType, source_location=:sourceLocation, destination_location=:destinationLocation,company_id =:company where  purchase_requisition_id=:purchaseRequisitionId ";

	public static final String DELETE_HEADER = "delete from purchase_requisition where purchase_requisition_id=?";

	public static String COUNT_MAX = "SELECT count(*) FROM purchase_requisition_detail WHERE purchase_requisition_id=?";

	public static final String checkStockTransferExists = "SELECT count(*) FROM stock_transfer WHERE purchase_requisition_id=?";

	public static final String GET_SOURCE_LOCATION_ID = "select source_location from purchase_requisition where purchase_requisition_id = ?";

	public static final String GET_ITEM_AND_QTY = "select item_id,quantity from purchase_requisition_detail where purchase_requisition_id = ?";

	public static final String CHECK_AVAILABLE_QTY_INVENTORY = "select coalesce(quantity_available,0) stockQty from inventory WHERE location_id=? and item_id=?";

	public static String GET_TOTAL_QC_QUANTITY = "select grn_detail.item_id, sum(coalesce (grn_detail.converted_quantity,0)) qcQuantity from grn_detail inner join grn on grn.grn_id= grn_detail.grn_id " + "where grn_detail.item_id=? and grn.qc_location_id=? and  grn_detail.qc_status is null " + "group by grn_detail.item_id,grn.qc_location_id";

	public static final String sUpdateInventory = "update inventory set quantity_available=? WHERE location_id=? and item_id=?";

	public static final String CHECK_CONSUMED_QTY_INVENTORY = "select coalesce(quantity_available,0) stockQty,inventory_id from inventory WHERE location_id=? and item_id=?";

	public static final String DELETE_INVENTORY = "delete from inventory where inventory_id =?";

	public static final String GET_REQUISTION_NUMBER = "select requisition_number as requisitionNumber from purchase_requisition where purchase_requisition_id=?";

	public static final String GET_STOCK_LEDGER_ID = "select stock_ledger_id stockLedgerId from stock_ledger where inventory_id = ?";

	public static final String DELETE_STOCK_LEDGER_DETAIL = "delete from stock_ledger_detail where stock_ledger_id =?";

	public static final String DELETE_STOCK_LEDGER = "delete from stock_ledger where doc_ref =?";

}
