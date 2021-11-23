package com.dci.payroll.tds.slabrate;

import java.util.List;

public interface SlabRateService {
	List<SlabRateBean> getSlabRateList() throws Exception;

	List<SlabRateBean> getTaxPayerTypeList() throws Exception;

	SlabRateBean getSlabRateListById(int taxRateId) throws Exception;

	boolean insertSlabRate(SlabRateBean slabRateBean) throws Exception;

	boolean updateSlabRate(SlabRateBean slabRateBean) throws Exception;

	boolean deleteSlabRate(int taxRateId) throws Exception;
}