package com.dci.master.setting.manageitemcategory;

public class ManageItemCategoryQueryUtil {

	public static final String GetManageItemCategoryList = "select it.item_category_id as itemCategoryId,it.category_name as categoryName,dt.value as categoryTypeName,t.parentCategoryName from item_category it inner join def_table dt on dt.def_table_id = it.category_type left join (select item_category_id as itemCategoryId,category_name as parentCategoryName from item_category  where item_category_id in (select parent_category_id from item_category where parent_category_id is not null)) as t on  it.parent_category_id = t.itemCategoryId where it.company_id = ? order by it.item_category_id desc";

	public static final String sDeleteItemCategory = "delete from item_category where item_category_id =?";

	public static final String sGetCategoryList = "SELECT def_table_id as categoryTypeId,value as categoryTypeName from def_table WHERE is_active=true and form_field_id = 6 and is_active='true'";

	public static final String sGetPurchaseList = "select tax_id as purchaseTaxesId,tax_code as purchaseTaxesName from tax";

	public static final String sGetSalesList = "select tax_id as salesTaxesId,tax_code as salesTaxesName from tax";

	public static final String sGetParentCategoryList = "with RECURSIVE q AS  ( select item_category_id ,cast(category_name as varchar(255)) as path,value  from item_Category ic INNER JOIN DEF_TABLE dt on dt.def_table_id =ic.category_type  WHERE parent_category_id is null and ic.company_id = ?  UNION ALL   SELECT ic.item_category_id,cast( q.path ||' / ' || cast(ic.category_name as varchar(255)) as  varchar(255)),dt.value  FROM item_category ic JOIN q ON  ic.parent_category_id =  q.item_category_id INNER JOIN DEF_TABLE dt on dt.def_table_id =ic.category_type  ) SELECT item_category_id as parentCategoryId,path as parentCategoryName,item_category_id as id,path as text, value as defName FROM q";

	public static final String sGetExpenseAccountList = "select acct_head_code as expenseAccountId,acct_head_name as expenseAccountName,acct_head_code as id,acct_head_name as text from account_head_master ";

	public static final String sGetIncomeAccountList = "select acct_head_code as incomeAccountId,acct_head_name as incomeAccountName,acct_head_code as id,acct_head_name as text from account_head_master ";

	public static final String sAddItemCategory = "INSERT INTO item_category(category_name, category_type, parent_category_id,created_by,created_date,quality_check,company_id) VALUES (?, ?, ?, ?,?,?,?) returning item_category_id";

	public static final String sAddItemCategoryAccount = "INSERT INTO item_category_account(item_category_id, purchase_tax,sales_tax, income_account, expense_account) VALUES (?, ?, ?, ?, ?)";

	public static final String sDeleteItemCategoryAccount = "delete from item_category_account where item_category_id =?";

	public static final String sDeleteItemCategoryProperty = "delete from item_category_property where item_category_id =?";

	public static final String sDeleteItemCategoryIdProperty = "delete from item_category_property where item_category_property_id =?";

	public static final String sGetItemCategoryEditList = "select item_category_id as itemCategoryId,category_name as categoryName,category_type as categoryTypeId,COALESCE(parent_category_id,0) as parentCategoryId,quality_check as qualityCheck from item_category where item_category_id = ?";

	public static final String sGetItemCategoryAccountEditList = "select item_category_account_id as itemCategoryAccountId,item_category_id as itemCategoryId,purchase_tax as purchaseTaxId,sales_tax as salesTaxesId,income_account as incomeAccountId,expense_account as expenseAccountId from item_category_account where item_category_id = ?";

	public static final String sGetPropertyList = "select def_table_id as propertyTypeId,value as propertTypeName from def_table where form_field_id = 38";

	public static final String sAddItemCategoryProperty = "insert into item_category_property (item_category_id,dynamic_attribute_id) values(?,?)";

	public static final String GET_ITEM_PROPERTY_LIST = "select dy.dynamic_attribute_id as itemPropertiesId,dt.value as typeName,def.value as propertyTypeName,dy.attribute_type as propertyTypeId,dy.attribute_data_type as typeId,dy.attribute_name as propName,dy.attribute_value as propValue,dy.attribute_defualt_value as defaultsValue,dy.is_mandatory as manditory from dynamic_attribute dy left join def_table dt on dt.def_table_id = dy.attribute_data_type left join def_table def on def.def_table_id = dy.attribute_type where attribute_type=? and dy.company_id = ?";

	public static final String sAddItemProperty = "INSERT INTO item_category_property(item_category_id,dynamic_attribute_id ) VALUES (?, ?)";

	public static final String GetManageItemPropertiesList = "select dy.dynamic_attribute_id as itemPropertiesId,dt.value as typeName,def.value as propertyTypeName,dy.attribute_name as propName,dy.attribute_value as propValue,dy.attribute_defualt_value as defaultsValue,dy.is_mandatory as manditory,icp.item_category_property_id as itemCategoryPropertyId from item_category_property icp left join dynamic_attribute dy on dy.dynamic_attribute_id = icp.dynamic_attribute_id left join def_table dt on dt.def_table_id = dy.attribute_data_type left join def_table def on def.def_table_id = dy.attribute_type where icp.item_category_id=?";

	public static final String sUpdateItemCategory = "update item_category set category_name=?, category_type=?, parent_category_id=?,modified_by=?,modified_date=?,quality_check=? where item_category_id=?";

	public static final String sUpdateItemCategoryAccount = "update item_category_account set item_category_id=?, purchase_tax=?, sales_tax=?, income_account=?, expense_account=? where item_category_account_id=?";

	public static final String sUpdateItemProperty = "update item_category_property set item_category_id=?,dynamic_attribute_id=? where item_category_property_id=?";

	public static final String sCheckCategoryName = "SELECT count(*) FROM item_category WHERE LOWER(category_name)=LOWER(?) and category_type!=15";

	public static final String sAddItemCategoryGrnAttribute = "INSERT INTO grn_attribute(item_category_id, batch_no, mrp, expiry_date, manufacture_details) VALUES(?,?,?,?,?)";

	public static final String sGetItemCategoryGrnAttributeEditList = "select batch_no as batchNo,mrp as mrp,expiry_date as expiryDate,manufacture_details as manufactureDetails,grn_attribute_id as grnAttributeId from grn_attribute where item_category_id = ?";

	public static final String sUpdateItemCategoryGrnAttribute = "update grn_attribute set item_category_id=?,batch_no=?,mrp=?,expiry_date=?,manufacture_details=? where grn_attribute_id=?";

	public static final String sCheckItemCategoryId = "select item_category_id from item_category where item_category_id=?";

	public static final String SELECT_GRN_ATTRIBUTE_LIST = "select batch_no as batchNo,mrp as mrp,expiry_date as expiryDate,manufacture_details as manufactureDetails,grn_attribute_id as grnAttributeId from grn_attribute where item_category_id = ?";

	public static final String sGetItemCategoryGrnId = "WITH RECURSIVE q AS (SELECT item_category_id ,cast(category_name as varchar(255)) as path FROM item_category WHERE parent_category_id is null UNION ALL SELECT ic.item_category_id,cast( q.path ||' / ' || cast(ic.category_name as varchar(255)) as  varchar(255)) FROM item_category ic JOIN q ON  ic.parent_category_id =  q.item_category_id ) SELECT item_category_id as parentCategoryId,path as parentCategoryName  FROM q where item_category_id=?";

	public static final String sGetItemCategoryGrn = "select item_category_id from item_category where category_name=? and category_type!=15";

	public static final String sDeletegrnAttribute = "Delete from grn_attribute where item_category_id =?";

}
