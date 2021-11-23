package com.dci.finance.itemproperties;

public class ItemPropertiesQueryUtil {

	public static final String sPropertyDropDown = "select def_table_id as id,value as text from def_table where form_field_id = 38 and is_active=true";

	public static final String sDefaultValueList = "select def_table_id as typeId,value as typeName from def_table where form_field_id = 53 and is_active=true";

	public static final String sAddItemProperties = "INSERT INTO dynamic_attribute(attribute_data_type, attribute_type, attribute_name,atttribute_length,attribute_value, attribute_defualt_value,is_mandatory, created_by, created_date ,company_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";

	public static final String GetManageItemPropertiesList = "select dy.dynamic_attribute_id as itemPropertiesId,dt.value as typeName,def.value as propertyTypeName,dy.attribute_name as propName,dy.attribute_value as propValue,dy.attribute_defualt_value as defaultsValue,dy.is_mandatory as manditory from dynamic_attribute dy left join def_table dt on dt.def_table_id = dy.attribute_data_type left join def_table def on def.def_table_id = dy.attribute_type where company_id = ? order by dynamic_attribute_id desc";

	public static final String deleteItemProperties = "delete from dynamic_attribute where dynamic_attribute_id=?";

	public static final String SELECT_ITEM_PROPERTIES_BY_ID = "select dy.dynamic_attribute_id as itemPropertiesId,dy.attribute_data_type as typeId,dy.attribute_type as propertyTypeId,dy.atttribute_length as propLength,dy.attribute_name as propName,dy.attribute_value as propValue,dy.attribute_defualt_value as defaultsValue,case when dy.is_mandatory=true then 'Y' else 'N' end as manditory from dynamic_attribute dy where dy.dynamic_attribute_id=?";

	public static final String sUpdateItemProperties = "update dynamic_attribute set attribute_data_type=?, attribute_type=?,attribute_name=?,atttribute_length=?,attribute_value=?, attribute_defualt_value=?,is_mandatory=?, modified_by=?, modified_date=? where dynamic_attribute_id=?";

}
