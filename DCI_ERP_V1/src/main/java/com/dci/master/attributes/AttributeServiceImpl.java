package com.dci.master.attributes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttributeServiceImpl implements AttributeService {

	@Autowired
	AttributeDao objAttributeDao;

	@Override
	public List<AttributeBean> getAttributesList() {
		// TODO Auto-generated method stub
		return objAttributeDao.getAttributesList();
	}

	@Override
	public boolean saveAttribute(AttributeBean objAttribute) {
		// TODO Auto-generated method stub
		return objAttributeDao.saveAttribute(objAttribute);
	}

}
