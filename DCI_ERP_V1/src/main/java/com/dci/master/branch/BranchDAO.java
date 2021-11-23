package com.dci.master.branch;

import java.util.List;


public interface BranchDAO {

	
	public List<Branch> getBranchList() throws Exception;

	public BranchResultBean insertBranch(BranchResultBean branch) throws Exception;

	BranchResultBean getBranchById(int custId) throws Exception;
	
	BranchResultBean getview(int custId) throws Exception;


	boolean deleteBranch(int custId) throws Exception;
	
	public boolean deletebranchBank(List<BranchBank> lBranchBank) throws Exception;

	public List<Branch> getTemplateById(int templateId) throws Exception;

	public BranchResultBean updateBranch(BranchResultBean branch) throws Exception;
	
	public BranchResultBean getDropDownList(int cityId);

	public BranchResultBean deleteKeyDetail(List<BranchNewKeyBean> lServicePartnerKeyBean);

}
