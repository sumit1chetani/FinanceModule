package com.dci.tenant.truck.general.chargetype;



import java.util.List;

public interface ChargetypeService {

	public List<ChargetypeBean> getList();
	
	Object save(ChargetypeBean bean);
	
	public ChargetypeBean edit(int rowid) throws Exception;
	
	public boolean update(ChargetypeBean update) throws Exception;
	
	public boolean delete(int rowid) throws Exception;
}

