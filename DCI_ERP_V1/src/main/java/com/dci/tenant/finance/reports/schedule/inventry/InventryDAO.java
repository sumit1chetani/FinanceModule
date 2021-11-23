package com.dci.tenant.finance.reports.schedule.inventry;

import java.util.List;

import com.dci.common.util.CustomException;

public interface InventryDAO {
	// List<InventryBean> getInventryList(int limit, int offset) throws
	// Exception;

	List<InventryBean> getInventryList(InventryBean inventryBean) throws CustomException;

}
