
package com.dci.tenant.master.chargeHead;

import java.util.List;

import com.dci.common.model.SelectivityBen;

public class ChargeHeadResultBean {
	private List<ChargeHeadBean> list;
	private List<SelectivityBen> selectivitybean;

	private List<ChargeHeadBean> list1;
	
	private List<SelectivityBen> accountHeadList;
	private List<SelectivityBen> accountHeadListRevenue;
	
	
	public List<SelectivityBen> getAccountHeadListRevenue() {
		return accountHeadListRevenue;
	}
	public void setAccountHeadListRevenue(List<SelectivityBen> accountHeadListRevenue) {
		this.accountHeadListRevenue = accountHeadListRevenue;
	}
	public List<SelectivityBen> getAccountHeadList() {
		return accountHeadList;
	}
	public void setAccountHeadList(List<SelectivityBen> accountHeadList) {
		this.accountHeadList = accountHeadList;
	}
	public List<ChargeHeadBean> getList() {
		return list;
	}
	public void setList(List<ChargeHeadBean> list) {
		this.list = list;
	}
	public List<ChargeHeadBean> getList1() {
		return list1;
	}
	public void setList1(List<ChargeHeadBean> list1) {
		this.list1 = list1;
	}
	public List<SelectivityBen> getSelectivitybean() {
		return selectivitybean;
	}
	public void setSelectivitybean(List<SelectivityBen> selectivitybean) {
		this.selectivitybean = selectivitybean;
	}

	
	
}
