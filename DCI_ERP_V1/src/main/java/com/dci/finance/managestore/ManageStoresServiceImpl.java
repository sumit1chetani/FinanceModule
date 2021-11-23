package com.dci.finance.managestore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;


@Service
public class ManageStoresServiceImpl implements ManageStoresService {

	@Autowired
	ManageStoresDAO manageStoresDao;

	@Override
	public List<ManageStoresBean> getManageStoresList() throws CustomException {
		return manageStoresDao.getManageStoresList();
	}

	@Override
	public void saveManageStoresList(ManageStoresBean manageStoresBean) throws CustomException {
		manageStoresDao.saveManageStoresList(manageStoresBean);
	}

	@Override
	public ManageStoresResultBean getEditList(int locNo) throws CustomException {
		return manageStoresDao.getEditList(locNo);
	}

	@Override
	public void updateManageStoresList(ManageStoresBean manageStoresBean) throws CustomException {
		manageStoresDao.updateManageStoresList(manageStoresBean);
	}

	@Override
	public boolean getDeleteList(String lId) throws CustomException {
		return manageStoresDao.getDeleteList(lId);
	}

	@Override
	public ManageStoresResultBean getparentlocationList() throws Exception {
		// TODO Auto-generated method stub
		return manageStoresDao.getparentlocationList();
	}

	@Override
	public ManageStoresResultBean getstatelist(String cityId) throws Exception {
		// TODO Auto-generated method stub
		return manageStoresDao.getstatelist(cityId);
	}

	@Override
	public ManageStoresResultBean getcountrylist(String cityId) throws Exception {
		// TODO Auto-generated method stub
		return manageStoresDao.getcountrylist(cityId);
	}

	@Override
	public ManageStoresResultBean getcitylist() throws Exception {
		// TODO Auto-generated method stub
		return manageStoresDao.getcitylist();
	}

	@Override
	public ManageStoresResultBean getlocationtypeList() throws Exception {
		// TODO Auto-generated method stub
		return manageStoresDao.getlocationtypeList();
	}

	@Override
	public ManageStoresResultBean getinchargeList() throws Exception {
		// TODO Auto-generated method stub
		return manageStoresDao.getinchargeList();
	}

	@Override
	public ManageStoresResultBean getParentAddress(int pid) throws Exception {
		return manageStoresDao.getParentAddress(pid);
	}

	@Override
	public int checkStoreName(String manageName) throws Exception {
		return manageStoresDao.checkStoreName(manageName);
	}

}
