package com.dci.tenant.finance.shiftmaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ShiftMasterServiceImpl implements ShiftMasterService {

	@Autowired
	ShiftMasterDAO shiftMasterDAO;

	@Override
	public List<ShiftMasterBean> getShiftMasterList() throws Exception {
		return shiftMasterDAO.getShiftMasterList();
	}

	@Override
	public void addShiftMaster(ShiftMasterBean objShiftMasterBean) throws Exception {
		shiftMasterDAO.addShiftMaster(objShiftMasterBean);
	}

	@Override
	public ShiftMasterBean getShiftMasterEditList(int shiftId) throws Exception {
		return shiftMasterDAO.getShiftMasterEditList(shiftId);
	}

	@Override
	public boolean deleteShiftMaster(int shiftId) throws Exception {
		return shiftMasterDAO.deleteShiftMaster(shiftId);
	}

	@Override
	public boolean uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		return shiftMasterDAO.uploadFile(file);

	}

	@Override
	public void updateShiftMaster(ShiftMasterBean objShiftMasterBean) throws Exception {
		shiftMasterDAO.updateShiftMaster(objShiftMasterBean);
	}

}
