package com.dci.master.branch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BranchServiceImpl implements BranchService {
   @Autowired
	private BranchDAO branchDAO;

	@Override
	public List<Branch> getBranchList() throws Exception {
		// TODO Auto-generated method stub
		return branchDAO.getBranchList();
	}

	@Override
	public BranchResultBean insertBranch(BranchResultBean branch) throws Exception {
		// TODO Auto-generated method stub
		return branchDAO.insertBranch(branch);
	}

	@Override
	public BranchResultBean getBranchById(int custId) throws Exception {
		// TODO Auto-generated method stub
		return branchDAO.getBranchById(custId);
	}

	@Override
	public BranchResultBean getview(int custId) throws Exception {
		// TODO Auto-generated method stub
		return branchDAO.getview(custId);
	}
	
	@Override
	public boolean deleteBranch(int custId) throws Exception {
		// TODO Auto-generated method stub
		return branchDAO.deleteBranch(custId);
	}

	@Override
	public BranchResultBean updateBranch(BranchResultBean branch) throws Exception {
		// TODO Auto-generated method stub
		return branchDAO.updateBranch(branch);
	}

	@Override
	public List<Branch> getTemplateById(int templateId) throws Exception {
		// TODO Auto-generated method stub
		return branchDAO.getTemplateById(templateId);
	}

	@Override
	public BranchResultBean getDropDownList(int cityId) {
		// TODO Auto-generated method stub
		return branchDAO.getDropDownList(cityId);
	}
	
	@Override
	public boolean deletebranchBank(List<BranchBank> lBranchBank)
			throws Exception {
		// TODO Auto-generated method stub
		return branchDAO.deletebranchBank(lBranchBank);
	}

	@Override
	public BranchResultBean deleteKeyDetail(List<BranchNewKeyBean> lServicePartnerKeyBean) {
		// TODO Auto-generated method stub
		return branchDAO.deleteKeyDetail(lServicePartnerKeyBean);
	}

}
