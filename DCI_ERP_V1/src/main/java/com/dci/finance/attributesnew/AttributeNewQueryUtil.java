package com.dci.finance.attributesnew;

public class AttributeNewQueryUtil {

	public static final String CHECK_ATTRIBUTE = "SELECT count(*) FROM attribute WHERE lower(ATTRIBUTE_NAME)=?";

	public static final String GET_ATTRIBUTE_LIST = "select ATTRIBUTE_NAME as attributeName,ATTRIBUTE_VALUE as attributeValue from attribute";

	public static final String SAVE_ATTRIBUTE = " Insert into attribute (ATTRIBUTE_NAME,ATTRIBUTE_VALUE) values (?,?)";

	public static final String DELETE_ATTR = "Delete from attribute where ATTRIBUTE_NAME =?";

	public static final String GET_EDIT_DATA = "select ATTRIBUTE_NAME as attributeName,ATTRIBUTE_VALUE as attributeValue from attribute where ATTRIBUTE_NAME = ?";

	public static final String UPDATE_ATTRIBUTE = "update attribute set ATTRIBUTE_VALUE =? where ATTRIBUTE_NAME =?";

}
