package com.dci.tenant.finance.subheadgroupaccount;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;

@Service
public interface SubHeadGroupAccountService {

	public SubHeadGroupAccountResultListBean getGrpHeadDrpDwn() throws CustomException;

	public boolean addSubGroupAccount(SubHeadGroupAccountBean objGrpHeadMasterBean, String userId) throws Exception;

	public List<SubHeadGroupAccountBean> getSubGroupAccountList(int limit, int offset) throws Exception;

	public SubHeadGroupAccountBean getSubGroupAccountEditData(String subGroupHeadCode) throws CustomException;

	public boolean updateSubGroupAccount(SubHeadGroupAccountBean objSubGroupAccountBean, String userId) throws Exception;

	public boolean deleteSubGroupAccount(String subGroupCode) throws Exception;

	public String getSubGroupCode(String grpHeadCode, String subGrpHeadCode) throws CustomException;

	public SubHeadGroupAccountResultListBean getvalidate(String subGroupName, boolean edit, String subGroupCode);
}