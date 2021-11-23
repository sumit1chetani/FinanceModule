package com.dci.payroll.tds.slabrate;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class SlabRateResultBean extends BasicResultBean implements Serializable {
	private List<SlabRateBean> slabRateList;
	private List<SlabRateBean> payerTypeList;
	private SlabRateBean slabRate;

	public List<SlabRateBean> getSlabRateList() {
		return slabRateList;
	}

	public void setSlabRateList(List<SlabRateBean> slabRateList) {
		this.slabRateList = slabRateList;
	}

	public SlabRateBean getSlabRate() {
		return slabRate;
	}

	public void setSlabRate(SlabRateBean slabRate) {
		this.slabRate = slabRate;
	}

	public List<SlabRateBean> getPayerTypeList() {
		return payerTypeList;
	}

	public void setPayerTypeList(List<SlabRateBean> payerTypeList) {
		this.payerTypeList = payerTypeList;
	}

}