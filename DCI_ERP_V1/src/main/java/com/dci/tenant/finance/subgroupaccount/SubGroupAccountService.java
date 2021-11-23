package com.dci.tenant.finance.subgroupaccount;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;

@Service
public interface SubGroupAccountService {

	public SubGroupAccountResultListBean getGrpHeadDrpDwn() throws CustomException;

	public boolean addSubGroupAccount(SubGroupAccountBean objGrpHeadMasterBean, String userId) throws Exception;

	public List<SubGroupAccountBean> getSubGroupAccountList(int limit, int offset) throws Exception;

	public SubGroupAccountBean getSubGroupAccountEditData(String subGroupHeadCode) throws CustomException;

	public boolean updateSubGroupAccount(SubGroupAccountBean objSubGroupAccountBean, String userId) throws Exception;

	public boolean deleteSubGroupAccount(String subGroupCode) throws Exception;

	public String getSubGroupCode(String grpHeadCode, String subGrpHeadCode) throws CustomException;

	public SubGroupAccountResultListBean getvalidate(String subGroupName, boolean edit, String subGroupCode);

	public SubGroupAccountResultListBean getsubGrpHdDrpDwn(String groupCode);
}