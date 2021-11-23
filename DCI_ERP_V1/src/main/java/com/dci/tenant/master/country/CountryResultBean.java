package com.dci.tenant.master.country;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public class CountryResultBean {
	private List<CountryBean> list;

	private List<SelectivityBean> selectivitybean;

	public List<SelectivityBean> getSelectivitybean() {
		return selectivitybean;
	}

	public void setSelectivitybean(List<SelectivityBean> selectivitybean) {
		this.selectivitybean = selectivitybean;
	}

	public List<CountryBean> getList() {
		return list;
	}

	public void setList(List<CountryBean> list) {
		this.list = list;
	}
	
}