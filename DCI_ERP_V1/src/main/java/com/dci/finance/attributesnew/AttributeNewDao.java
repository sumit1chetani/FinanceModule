package com.dci.finance.attributesnew;

import java.util.List;

public interface AttributeNewDao {

	List<AttributeNewBean> getAttributesList();

	boolean saveAttribute(AttributeNewBean objAttributeBean);

	boolean deleteAttr(String attr);

	AttributeNewBean editAttribute(String attr);

	boolean updateAttribute(AttributeNewBean objAttribute);

}
