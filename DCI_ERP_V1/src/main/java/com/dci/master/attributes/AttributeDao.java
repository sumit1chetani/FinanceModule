package com.dci.master.attributes;

import java.util.List;

public interface AttributeDao {

	List<AttributeBean> getAttributesList();

	boolean saveAttribute(AttributeBean objAttributeBean);

}
