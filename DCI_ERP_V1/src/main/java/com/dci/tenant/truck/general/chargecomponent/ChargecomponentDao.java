package com.dci.tenant.truck.general.chargecomponent;


import java.util.List;

import com.dci.common.util.CustomException;

public interface ChargecomponentDao {

	public List<ChargecomponentBean> getList();

	Object save(ChargecomponentBean bean) throws CustomException;

	public ChargecomponentBean edit(int rowid) throws Exception;

	public boolean update(ChargecomponentBean update) throws Exception;

	public boolean delete(int rowid) throws Exception;
	
	public ChargecomponentResultBean selectivity() throws Exception;

}

