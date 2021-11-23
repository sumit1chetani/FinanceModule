package com.dci.master.port;

import java.util.List;

import com.dci.common.model.SelectivityBen;

public class PortResultBean {
	private List<PortBean> list;

	private List<SelectivityBen> selectivitybean;

	public List<SelectivityBen> getSelectivitybean() {
		return selectivitybean;
	}

	public void setSelectivitybean(List<SelectivityBen> selectivitybean) {
		this.selectivitybean = selectivitybean;
	}

	public List<PortBean> getList() {
		return list;
	}

	public void setList(List<PortBean> list) {
		this.list = list;
	}
	
}