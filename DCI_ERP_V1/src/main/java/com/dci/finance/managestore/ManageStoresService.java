package com.dci.finance.managestore;

import java.util.List;

import com.dci.common.util.CustomException;

public interface ManageStoresService {

	public List<ManageStoresBean> getManageStoresList() throws CustomException;

	public ManageStoresResultBean getparentlocationList() throws Exception;

	public ManageStoresResultBean getlocationtypeList() throws Exception;

	public ManageStoresResultBean getinchargeList() throws Exception;

	public ManageStoresResultBean getstatelist(String cityId) throws Exception;

	public ManageStoresResultBean getcountrylist(String cityId) throws Exception;

	public ManageStoresResultBean getcitylist() throws Exception;

	public void saveManageStoresList(ManageStoresBean manageStoresBean) throws CustomException;

	public ManageStoresResultBean getEditList(int locNo) throws CustomException;

	public void updateManageStoresList(ManageStoresBean manageStoresBean) throws CustomException;

	public boolean getDeleteList(String lId) throws CustomException;

	public ManageStoresResultBean getParentAddress(int pid) throws Exception;

	public int checkStoreName(String manageName) throws Exception;

}
