package com.dci.payroll.tds.slabrate;

import java.util.List;

public interface SlabRateDAO {
	public List<SlabRateBean> getSlabRateList() throws Exception;

	public List<SlabRateBean> getTaxPayerTypeList() throws Exception;

	public SlabRateBean getSlabRateListById(int taxRateId) throws Exception;

	public boolean insertSlabRate(SlabRateBean slabRateBean) throws Exception;

	public boolean updateSlabRate(SlabRateBean slabRateBean) throws Exception;

	public boolean deleteSlabRate(int taxRateId) throws Exception;
}