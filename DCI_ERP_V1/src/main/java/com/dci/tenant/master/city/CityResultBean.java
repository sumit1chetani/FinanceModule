package com.dci.tenant.master.city;

import java.util.List;

import com.dci.common.model.SelectivityBean;



public class CityResultBean {
	private List<CityBean> list;

	private List<SelectivityBean> selectivitybean;

	public List<SelectivityBean> getSelectivitybean() {
		return selectivitybean;
	}

	public void setSelectivitybean(List<SelectivityBean> selectivitybean) {
		this.selectivitybean = selectivitybean;
	}

	public List<CityBean> getList() {
		return list;
	}

	public void setList(List<CityBean> list) {
		this.list = list;
	}
	
}