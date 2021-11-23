package com.dci.master.attributes;

import java.util.List;

public interface AttributeService {

	public List<AttributeBean> getAttributesList();

	public boolean saveAttribute(AttributeBean objAttribute);

}
