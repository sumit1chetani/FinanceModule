package com.dci.tenant.finance.subgroupaccount;

import java.util.List;

import com.dci.common.util.CustomException;

public interface SubGroupAccountDAO {

	public SubGroupAccountResultListBean getGrpHeadDrpDwn() throws CustomException;

	public boolean addSubGroupAccount(SubGroupAccountBean objSubGroupAccountBean, String userId) throws CustomException;

	public List<SubGroupAccountBean> getSubGroupAccountList(int limit, int offset) throws CustomException;

	public SubGroupAccountBean getSubGroupAccountEditData(String subGroupHeadCode) throws CustomException;

	public boolean updateSubGroupAccount(SubGroupAccountBean objSubGroupAccountBean, String userId) throws CustomException;

	public boolean deleteSubGroupAccount(String subGroupCode) throws CustomException;

	public String getSubGroupCode(String grpHeadCode, String subGrpHeadCode) throws CustomException;

	public SubGroupAccountResultListBean getvalidate(String subGroupName, boolean edit, String subGroupCode);

	public SubGroupAccountResultListBean getsubGrpHdDrpDwn(String groupCode);
}
