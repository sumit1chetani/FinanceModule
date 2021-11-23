package com.dci.master.settings.UOM;

public class ManageUOMQueryUtil {

	public static final String CHECK_COUNT_INSERT = "select count(*) from uom where upper(uom)=upper(?)  and company_id = ? ";

	public static final String INSERT_UOM = "insert into uom (uom,uom_description,uom_category_id, created_by, created_date,company_id) VALUES(:uomName,:uomDescription,:uomCategoryId,:createdBy,:createdDate ,:companyId )";

	public static final String CHECK_COUNT_UPDATE = "select count(*) from uom where uom_id<>? and uom=?";

	public static final String UPDATE_UOM = "update uom set uom =:uomName,uom_description =:uomDescription,uom_category_id=:uomCategoryId,modified_by=:modifiedBy,modified_date=:modifiedDate where uom_id=:uomId";

	public static final String DELETE_UOM = "delete from uom where uom_id=?";

	public static final String SELECT_UOM_BY_ID = "SELECT uom_id uomId, uom uomName, uom_description uomDescription, coalesce(uom_category_id,0) as uomCategoryId FROM uom where uom_id=?  ";

	public static final String SELECT_UOM_LIST = "SELECT u.uom_id uomId, u.uom uomName, u.uom_description uomDescription, coalesce(uc.id,0) as uomCategoryId,uc.uomcategory_name as uomCategoryName FROM uom u left join uom_category uc on uc.id = u.uom_category_id where u.company_id = ? order by u.uom_id desc";

	public static final String sGetUOMCategoryList = "select uom_id as id,uom as text from uom order by uom_id desc";

	public static final String sCheckBaseUOM = "select count(*) from uom where uom_category_id = ? and is_base_uom = true";

	public static final String sGetUOMCategList = "select id,uomcategory_name as text from uom_category where company_id = ? order by id desc";

	public static final String sCheckUOMName = "select count(*) from uom where upper(uom)=upper(?) and company_id = ?";

}
