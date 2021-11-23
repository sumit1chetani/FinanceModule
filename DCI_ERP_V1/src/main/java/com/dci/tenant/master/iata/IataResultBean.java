package com.dci.tenant.master.iata;

import java.util.List;

import com.dci.common.model.SelectivityBen;


public class IataResultBean {
	private List<IataBean> list;
	private List<IataBean> list1;

	public List<IataBean> getList1() {
		return list1;
	}

	public void setList1(List<IataBean> list1) {
		this.list1 = list1;
	}

	private List<SelectivityBen> selectivitybean;

	public List<SelectivityBen> getSelectivitybean() {
		return selectivitybean;
	}

	public void setSelectivitybean(List<SelectivityBen> selectivitybean) {
		this.selectivitybean = selectivitybean;
	}

	public List<IataBean> getList() {
		return list;
	}

	public void setList(List<IataBean> list) {
		this.list = list;
	}
	
}
