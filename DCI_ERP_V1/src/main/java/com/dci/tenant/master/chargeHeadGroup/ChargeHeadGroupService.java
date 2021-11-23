package com.dci.tenant.master.chargeHeadGroup;

import java.util.List;

import com.dci.common.util.CustomException;

public interface ChargeHeadGroupService {

	public List<ChargeHeadGroupBean> getList();

	Object save(ChargeHeadGroupBean bean) throws CustomException;

	public ChargeHeadGroupBean edit(int rowid) throws Exception;

	public boolean update(ChargeHeadGroupBean update) throws Exception;

	public boolean delete(int rowid) throws Exception;
}
