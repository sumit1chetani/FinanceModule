package com.dci.tenant.finance.subgroupaccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dci.common.util.CustomException;

@Component
public class SubGroupAccountServiceImpl implements SubGroupAccountService {

	@Autowired
	SubGroupAccountDAO objSubGroupAccountDAO;

	@Override
	public boolean addSubGroupAccount(SubGroupAccountBean objSubGrpHeadBean, String userId) throws Exception {
		String subGrpHeadCode = "";

		if (objSubGrpHeadBean.getGrpHeadCode().equalsIgnoreCase("A")) {
			subGrpHeadCode = "1000";
		} else if (objSubGrpHeadBean.getGrpHeadCode().equalsIgnoreCase("L")) {
			subGrpHeadCode = "2000";
		} else if (objSubGrpHeadBean.getGrpHeadCode().equalsIgnoreCase("I")) {
			subGrpHeadCode = "3000";
		} else if (objSubGrpHeadBean.getGrpHeadCode().equalsIgnoreCase("E")) {
			subGrpHeadCode = "4000";
		}

		String grp = getSubGroupCode(objSubGrpHeadBean.getGrpHeadCode(), subGrpHeadCode);
		objSubGrpHeadBean.setSubGroupCode(grp);
		return objSubGroupAccountDAO.addSubGroupAccount(objSubGrpHeadBean, userId);
	}

	@Override
	public List<SubGroupAccountBean> getSubGroupAccountList(int limit, int offset) throws Exception {
		// TODO Auto-generated method stub
		return objSubGroupAccountDAO.getSubGroupAccountList(limit, offset);
	}

	@Override
	public boolean updateSubGroupAccount(SubGroupAccountBean objSubGrpHeadBean, String userId) throws Exception {
		// TODO Auto-generated method stub
		return objSubGroupAccountDAO.updateSubGroupAccount(objSubGrpHeadBean, userId);
	}

	@Override
	public boolean deleteSubGroupAccount(String subGroupCode) throws Exception {
		return objSubGroupAccountDAO.deleteSubGroupAccount(subGroupCode);
	}

	@Override
	public String getSubGroupCode(String grpHeadCode, String subGrpHeadCode) throws CustomException {
		return objSubGroupAccountDAO.getSubGroupCode(grpHeadCode, subGrpHeadCode);
	}

	@Override
	public SubGroupAccountResultListBean getGrpHeadDrpDwn() throws CustomException {
		// TODO Auto-generated method stub
		return objSubGroupAccountDAO.getGrpHeadDrpDwn();
	}

	@Override
	public SubGroupAccountBean getSubGroupAccountEditData(String subGroupHeadCode) throws CustomException {
		// TODO Auto-generated method stub
		return objSubGroupAccountDAO.getSubGroupAccountEditData(subGroupHeadCode);
	}

	@Override
	public SubGroupAccountResultListBean getvalidate(String subGroupName, boolean edit, String subGroupCode) {
		// TODO Auto-generated method stub
		return objSubGroupAccountDAO.getvalidate(subGroupName, edit, subGroupCode);
	}

	@Override
	public SubGroupAccountResultListBean getsubGrpHdDrpDwn(String groupCode) {
		// TODO Auto-generated method stub
		return objSubGroupAccountDAO.getsubGrpHdDrpDwn(groupCode);
	}

}
