package com.dci.payroll.payroll.reimbursement;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class ReimbursementResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Reimbursement> ReimbursementList;

	private List<Reimbursement> currencyList;

	private List<Reimbursement> reimbursementTypeList;

	private String fileName;
	private String docFileName;

	private String docPath;

	public List<Reimbursement> getReimbursementList() {
		return ReimbursementList;
	}

	public void setReimbursementList(List<Reimbursement> reimbursementList) {
		ReimbursementList = reimbursementList;
	}

	public List<Reimbursement> getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(List<Reimbursement> currencyList) {
		this.currencyList = currencyList;
	}

	public List<Reimbursement> getReimbursementTypeList() {
		return reimbursementTypeList;
	}

	public void setReimbursementTypeList(List<Reimbursement> reimbursementTypeList) {
		this.reimbursementTypeList = reimbursementTypeList;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDocFileName() {
		return docFileName;
	}

	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}

	public String getDocPath() {
		return docPath;
	}

	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}

}
