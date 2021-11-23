package com.dci.finance.attributesnew;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttributeNewServiceImpl implements AttributeNewService {

	@Autowired
	AttributeNewDao objAttributeDao;

	@Override
	public List<AttributeNewBean> getAttributesList() {
		// TODO Auto-generated method stub
		return objAttributeDao.getAttributesList();
	}

	@Override
	public boolean saveAttribute(AttributeNewBean objAttribute) {
		// TODO Auto-generated method stub
		return objAttributeDao.saveAttribute(objAttribute);
	}

	@Override
	public boolean deleteAttr(String attr) {
		// TODO Auto-generated method stub
		return objAttributeDao.deleteAttr(attr);
	}

	@Override
	public AttributeNewBean editAttribute(String attr) {
		// TODO Auto-generated method stub
		return objAttributeDao.editAttribute(attr);
	}

	@Override
	public boolean updateAttribute(AttributeNewBean objAttribute) {
		// TODO Auto-generated method stub
		return objAttributeDao.updateAttribute(objAttribute);
	}

}
