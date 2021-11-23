package com.dci.payroll.payroll.payslip;

import java.util.ArrayList;
import java.util.List;

public class PaySlipListDTO {

	private List<PaySlipDTO> paySlipList = new ArrayList<PaySlipDTO>();

	public List<PaySlipDTO> getPaySlipList() {
		return paySlipList;
	}

	public void setPaySlipList(List<PaySlipDTO> paySlipList) {
		this.paySlipList = paySlipList;
	}

}
