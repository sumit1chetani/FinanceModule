package com.dci.payroll.payroll.electricalcharges;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class ElectricalChargesResultBean extends BasicResultBean implements Serializable {
	private List<ElectricalChargesBean> electricalChargesList;
	private ElectricalChargesBean chargesBean = null;

	public List<ElectricalChargesBean> getElectricalChargesList() {
		return electricalChargesList;
	}

	public void setElectricalChargesList(List<ElectricalChargesBean> electricalChargesList) {
		this.electricalChargesList = electricalChargesList;
	}

	public ElectricalChargesBean getChargesBean() {
		return chargesBean;
	}

	public void setChargesBean(ElectricalChargesBean chargesBean) {
		this.chargesBean = chargesBean;
	}
}
