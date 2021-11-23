package com.dci.finance.managelocation;

import java.util.List;

import com.dci.common.util.CustomException;

public interface ManageLocationDAO {

	public List<ManageLocationBean> getManageLocationList() throws CustomException;

	public void saveManageLocationList(ManageLocationBean manageLocationBean) throws CustomException;

	public ManageLocationResultBean getEditList(int locNo) throws CustomException;

	public void updateManageLocationList(ManageLocationBean manageLocationBean) throws CustomException;

	public boolean getDeleteList(String locationId) throws Exception;

	public ManageLocationResultBean getparentlocationList() throws Exception;

	public ManageLocationResultBean getstatelist(String cityId) throws Exception;

	public ManageLocationResultBean getcountrylist(String cityId) throws Exception;

	public ManageLocationResultBean getcitylist() throws Exception;

	public ManageLocationResultBean getlocationtypeList() throws Exception;

	public ManageLocationResultBean getinchargeList() throws Exception;

	public ManageLocationResultBean getParentAddress(int pid) throws Exception;

	public int checkLocationName(String manageName) throws Exception;

	public String multiDeleteValue(String userId, List<ManageLocationBean> lManageLocationBean) throws Exception;

}
