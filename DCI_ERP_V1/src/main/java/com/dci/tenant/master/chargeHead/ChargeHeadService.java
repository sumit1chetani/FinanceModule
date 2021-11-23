package com.dci.tenant.master.chargeHead;

import java.util.List;

import com.dci.common.util.CustomException;

public interface ChargeHeadService {
	public ChargeHeadResultBean selectivity() throws Exception;

	public List<ChargeHeadBean> getList();

	Object save(ChargeHeadBean bean) throws CustomException;

	public ChargeHeadBean edit(int rowid) throws Exception;
	
	public ChargeHeadBean view(int rowid) throws Exception;


	public boolean update(ChargeHeadBean update) throws Exception;

	public boolean delete(int rowid) throws Exception;
}
