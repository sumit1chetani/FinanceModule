package com.dci.tenant.master.terms;

import java.util.List;

import com.dci.common.model.SelectivityBean;



public class TermsResultBean {
	private List<TermsBean> list;

	private List<SelectivityBean> selectivitybean;

	public List<SelectivityBean> getSelectivitybean() {
		return selectivitybean;
	}

	public void setSelectivitybean(List<SelectivityBean> selectivitybean) {
		this.selectivitybean = selectivitybean;
	}

	public List<TermsBean> getList() {
		return list;
	}

	public void setList(List<TermsBean> list) {
		this.list = list;
	}
	
}