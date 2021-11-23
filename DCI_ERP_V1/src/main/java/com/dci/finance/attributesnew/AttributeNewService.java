package com.dci.finance.attributesnew;

import java.util.List;

public interface AttributeNewService {

	public List<AttributeNewBean> getAttributesList();

	public boolean saveAttribute(AttributeNewBean objAttribute);

	boolean deleteAttr(String attr);

	public AttributeNewBean editAttribute(String attr);

	public boolean updateAttribute(AttributeNewBean objAttribute);

}
