package com.dci.payroll.payroll.payslip;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.dci.common.util.BasicResultBean;
import com.dci.hrms.report.employeeEarlyStart.EmployeeEarlyStartBean;



public class PaySlipResultBean extends BasicResultBean implements Serializable {
	private List<PaySlipBean> paySlipList;
	private List<EmployeeEarlyStartBean> empdetailList;
	private List<EmployeeEarlyStartBean> sample;
	private PaySlipListDTO paySlipListDTO;
	private List<Map<String, Object>> paySlipComponentList;

	private List<PaySlipBean> emailList;

	public List<PaySlipBean> getPaySlipList() {
		return paySlipList;
	}

	public void setPaySlipList(List<PaySlipBean> paySlipList) {
		this.paySlipList = paySlipList;
	}

	public List<Map<String, Object>> getPaySlipComponentList() {
		return paySlipComponentList;
	}

	public void setPaySlipComponentList(List<Map<String, Object>> paySlipComponentList) {
		this.paySlipComponentList = paySlipComponentList;
	}

	public PaySlipListDTO getPaySlipListDTO() {
		return paySlipListDTO;
	}

	public void setPaySlipListDTO(PaySlipListDTO paySlipListDTO) {
		this.paySlipListDTO = paySlipListDTO;
	}

	public List<EmployeeEarlyStartBean> getEmpdetailList() {
		return empdetailList;
	}

	public void setEmpdetailList(List<EmployeeEarlyStartBean> empdetailList) {
		this.empdetailList = empdetailList;
	}

	public List<EmployeeEarlyStartBean> getSample() {
		return sample;
	}

	public void setSample(List<EmployeeEarlyStartBean> sample) {
		this.sample = sample;
	}

	public List<PaySlipBean> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<PaySlipBean> emailList) {
		this.emailList = emailList;
	}

}