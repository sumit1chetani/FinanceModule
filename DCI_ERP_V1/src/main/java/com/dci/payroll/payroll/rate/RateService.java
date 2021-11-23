package com.dci.payroll.payroll.rate;

import java.util.List;

public interface RateService {
	List<RateBean> getRateList() throws Exception;

	RateBean getRateListById(int taxRateId) throws Exception;

	boolean insertRate(RateBean rateBean) throws Exception;

	boolean updateRate(RateBean rateBean) throws Exception;

	boolean deleteRate(int taxRateId) throws Exception;
}
