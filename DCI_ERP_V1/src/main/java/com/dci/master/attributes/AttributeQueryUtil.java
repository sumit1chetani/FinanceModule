package com.dci.master.attributes;

public class AttributeQueryUtil {

	public static String GET_ATTRIBUTE_LIST = "select ATTRIBUTE_NAME as attributeName,ATTRIBUTE_VALUE as attributeValue from attribute";
	public static String SAVE_ATTRIBUTE = " Insert into attribute (ATTRIBUTE_NAME,ATTRIBUTE_VALUE) values (?,?)";

}
