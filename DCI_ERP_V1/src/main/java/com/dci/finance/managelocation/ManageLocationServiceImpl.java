package com.dci.finance.managelocation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;

@Service
public class ManageLocationServiceImpl implements ManageLocationService {

	@Autowired
	ManageLocationDAO manageLocationDao;

	@Override
	public List<ManageLocationBean> getManageLocationList() throws CustomException {
		return manageLocationDao.getManageLocationList();
	}

	@Override
	public void saveManageLocationList(ManageLocationBean manageLocationBean) throws CustomException {
		manageLocationDao.saveManageLocationList(manageLocationBean);
	}

	@Override
	public ManageLocationResultBean getEditList(int locNo) throws CustomException {
		return manageLocationDao.getEditList(locNo);
	}

	@Override
	public void updateManageLocationList(ManageLocationBean manageLocationBean) throws CustomException {
		manageLocationDao.updateManageLocationList(manageLocationBean);
	}

	@Override
	public boolean getDeleteList(String locationId) throws Exception {
		return manageLocationDao.getDeleteList(locationId);
	}

	@Override
	public ManageLocationResultBean getparentlocationList() throws Exception {
		// TODO Auto-generated method stub
		return manageLocationDao.getparentlocationList();
	}

	@Override
	public ManageLocationResultBean getstatelist(String cityId) throws Exception {
		// TODO Auto-generated method stub
		return manageLocationDao.getstatelist(cityId);
	}

	@Override
	public ManageLocationResultBean getcountrylist(String cityId) throws Exception {
		// TODO Auto-generated method stub
		return manageLocationDao.getcountrylist(cityId);
	}

	@Override
	public ManageLocationResultBean getcitylist() throws Exception {
		// TODO Auto-generated method stub
		return manageLocationDao.getcitylist();
	}

	@Override
	public ManageLocationResultBean getlocationtypeList() throws Exception {
		// TODO Auto-generated method stub
		return manageLocationDao.getlocationtypeList();
	}

	@Override
	public ManageLocationResultBean getinchargeList() throws Exception {
		// TODO Auto-generated method stub
		return manageLocationDao.getinchargeList();
	}

	@Override
	public ManageLocationResultBean getParentAddress(int pid) throws Exception {
		return manageLocationDao.getParentAddress(pid);
	}

	@Override
	public int checkLocationName(String manageName) throws Exception {
		return manageLocationDao.checkLocationName(manageName);
	}

	@Override
	public String multiDeleteValue(String userId, List<ManageLocationBean> lManageLocationBean) throws Exception {
		return manageLocationDao.multiDeleteValue(userId, lManageLocationBean);
	}

}
