package com.dci.tenant.finance.subheadgroupaccount;

import java.util.List;

import com.dci.common.util.CustomException;

public interface SubHeadGroupAccountDAO {

	public SubHeadGroupAccountResultListBean getGrpHeadDrpDwn() throws CustomException;

	public boolean addSubGroupAccount(SubHeadGroupAccountBean objSubGroupAccountBean, String userId) throws CustomException;

	public List<SubHeadGroupAccountBean> getSubGroupAccountList(int limit, int offset) throws CustomException;

	public SubHeadGroupAccountBean getSubGroupAccountEditData(String subGroupHeadCode) throws CustomException;

	public boolean updateSubGroupAccount(SubHeadGroupAccountBean objSubGroupAccountBean, String userId) throws CustomException;

	public boolean deleteSubGroupAccount(String subGroupCode) throws CustomException;

	public String getSubGroupCode(String grpHeadCode, String subGrpHeadCode) throws CustomException;

	public SubHeadGroupAccountResultListBean getvalidate(String subGroupName, boolean edit, String subGroupCode);
}
