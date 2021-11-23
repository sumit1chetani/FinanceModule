package com.dci.truck.staffMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;



@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	StaffDao StaffDao;
	 

	@Override
	public StaffResultBean getemployeelist() throws CustomException{
		return StaffDao.getemployeelist();
	}

	@Override
	public StaffBean save(StaffBean bean) throws Exception {
		// TODO Auto-generated method stub
		return StaffDao.save(bean);
	}

	@Override
	public List<StaffBean> getList() {
		return StaffDao.getList();
	}

	@Override
	public boolean deleteStaff(String staffId) {
		// TODO Auto-generated method stub
		return StaffDao.deleteStaff(staffId);
	}

	
}