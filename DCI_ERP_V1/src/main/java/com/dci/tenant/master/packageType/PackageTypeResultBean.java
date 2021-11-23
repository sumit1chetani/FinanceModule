package com.dci.tenant.master.packageType;

import java.util.List;

import com.dci.common.model.SelectivityBen;


public class PackageTypeResultBean {
	private List<PackageTypeBean> list;

	private List<SelectivityBen> selectivitybean;

	public List<SelectivityBen> getSelectivitybean() {
		return selectivitybean;
	}

	public void setSelectivitybean(List<SelectivityBen> selectivitybean) {
		this.selectivitybean = selectivitybean;
	}

	public List<PackageTypeBean> getList() {
		return list;
	}

	public void setList(List<PackageTypeBean> list) {
		this.list = list;
	}
	
}