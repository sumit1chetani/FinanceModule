package com.dci.tenant.userList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ListServiceImpl implements ListService{
	@Autowired
	ListDao ListDao;

	@Override
	public List<ListBean> getList(ListBean invoicelist) throws Exception {
		
		return ListDao.getList(invoicelist);
    }
}
