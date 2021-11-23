package com.dci.tenant.finance.reports.schedule.inventry;

import java.util.List;

import com.dci.common.util.CustomException;

public interface InventryService {

	List<InventryBean> getInventryList(InventryBean inventryBean) throws CustomException;

}
