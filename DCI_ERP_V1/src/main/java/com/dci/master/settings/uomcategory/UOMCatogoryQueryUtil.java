package com.dci.master.settings.uomcategory;

public class UOMCatogoryQueryUtil {

	public static final String UOMCategory_LIST = "SELECT id uomId, uomcategory_id as uomcategoryId, uomcategory_name uomcategoryName, uomcategory_desc uomcategoryDesc, status status FROM uom_category where company_id = ? order by id desc";

	public static final String sGenerateAutoNumber = "SELECT CASE WHEN MAX(uomcategory_id) IS NULL  THEN 'UOM0001' ELSE rpad(MAX(uomcategory_id),3,'UOM')|| lpad(cast(cast((SUBSTRING(MAX(uomcategory_id),4)) as int)+1  as text),4,'0') END FROM uom_category ";

	public static final String sCheckCategoryName = "select count(*) from uom_category where upper(uomcategory_name)=upper(?)";

	public static final String CHECK_COUNT_INSERT = "select count(*) from uom_category where upper(uomcategory_name)=upper(?) and company_id = ? ";

	public static final String INSERT_UOMCATEGORY = "insert into uom_category (uomcategory_id,uomcategory_name,uomcategory_desc,status,company_id)VALUES(:uomCategoryId,:uomCategoryName,:uomCategoryDesc,:status,:companyId)";

	public static final String CHECK_COUNT_UPDATE = "select count(*) from uom where uom_id<>? and uom=?";

	public static final String UPDATE_UOM = "update uom set  uom=:uomName,uom_description=:uomDescription,uom_rounding_precision=:roundPrecision,is_active=:isPositive,modified_by=:modifiedBy,modified_date=:modifiedDate where uom_id=:uomId";

	public static final String DELETE_UOME = "delete from uom where uom_id=?";

	public static final String SELECT_UOM_BY_ID = "SELECT uom_id uomId, uom uomName, uom_description uomDescription, uom_rounding_precision roundPrecision, is_active isPositive FROM uom where uom_id=?";

	public static final String SELECT_UOM_LIST = "SELECT uom_id uomId, uom uomName, uom_description uomDescription, uom_rounding_precision roundPrecision, is_active isPositive FROM uom order by uom asc";

	public static final String DELETE_UOMCATEGORY = "delete from uom_category where id=?";

	public static final String UOMCategory_EDIT_LIST = "SELECT id uomId, uomcategory_id as uomcategoryId, uomcategory_name uomcategoryName, uomcategory_desc uomcategoryDesc,status status FROM uom_category where id=?";

	public static final String UPDATE_UOMCATEGORY = "update uom_category set uomcategory_id=:uomCategoryId,uomcategory_name=:uomCategoryName,uomcategory_desc=:uomCategoryDesc,status=:status where id=:uomId";

}
