package com.dci.master.branch;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;


public class BranchResultBean  extends BasicResultBean implements Serializable{

	private static final long serialVersionUID = 1L;
    private List<Branch> branchList;
	private List<Branch> templateList;
	private Branch branch;
	private List<BranchBank> branchBank;
	private List<SelectivityBean> countryList;
	
	
	public List<SelectivityBean> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<SelectivityBean> countryList) {
		this.countryList = countryList;
	}

	private int Status;

	public List<Branch> getBranchList() {
		return branchList;
	}

	public void setBranchList(List<Branch> branchList) {
		this.branchList = branchList;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public List<Branch> getTemplateList() {
		return templateList;
	}

	public void setTemplateList(List<Branch> templateList) {
		this.templateList = templateList;
	}

	public List<BranchBank> getBranchBank() {
		return branchBank;
	}

	public void setBranchBank(List<BranchBank> branchBank) {
		this.branchBank = branchBank;
	}

}
