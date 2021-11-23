package com.dci.tenant.master.containersize;

import java.util.List;

import com.dci.common.model.SelectivityBean;



public class ContainerSizeResultBean {
	private List<ContainerSizeBean> list;

	private List<SelectivityBean> selectivitybean;

	public List<SelectivityBean> getSelectivitybean() {
		return selectivitybean;
	}

	public void setSelectivitybean(List<SelectivityBean> selectivitybean) {
		this.selectivitybean = selectivitybean;
	}

	public List<ContainerSizeBean> getList() {
		return list;
	}

	public void setList(List<ContainerSizeBean> list) {
		this.list = list;
	}
	
}