package com.dci.tenant.truck.general.chargecomponent;


import java.util.List;

import com.dci.common.model.SelectivityBean;

public class ChargecomponentResultBean {

	private List<ChargecomponentBean> list;
	
	private List<SelectivityBean> selectivitybean;
	
	

	public List<SelectivityBean> getSelectivitybean() {
		return selectivitybean;
	}

	public void setSelectivitybean(List<SelectivityBean> selectivitybean) {
		this.selectivitybean = selectivitybean;
	}

	public List<ChargecomponentBean> getList() {
		return list;
	}

	public void setList(List<ChargecomponentBean> list) {
		this.list = list;
	}
	
	
}

