package com.dci.master.unit;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public class UnitResultBean {
	private List<UnitBean> list;

	private List<SelectivityBean> selectivitybean;

	public List<SelectivityBean> getSelectivitybean() {
		return selectivitybean;
	}

	public void setSelectivitybean(List<SelectivityBean> selectivitybean) {
		this.selectivitybean = selectivitybean;
	}

	public List<UnitBean> getList() {
		return list;
	}

	public void setList(List<UnitBean> list) {
		this.list = list;
	}
	
}