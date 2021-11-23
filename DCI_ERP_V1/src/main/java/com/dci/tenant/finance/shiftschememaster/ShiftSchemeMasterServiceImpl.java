package com.dci.tenant.finance.shiftschememaster;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ShiftSchemeMasterServiceImpl implements ShiftSchemeMasterService {

	@Autowired
	ShiftSchemeMasterDAO shiftSchemeMasterDAO;

	@Override
	public List<ShiftSchemeMasterBean> getShiftSchemeMasterList() throws Exception {
		return shiftSchemeMasterDAO.getShiftSchemeMasterList();
	}

	@Override
	public ShiftSchemeMasterResultBean getShiftNameList(ShiftSchemeMasterBean shiftSchemeMasterBean) throws Exception {
		return shiftSchemeMasterDAO.getShiftNameList(shiftSchemeMasterBean);
	}

	@Override
	public boolean deleteShiftSchemeMaster(ShiftSchemeMasterBean objShiftSchemeMasterBean) throws Exception {
		return shiftSchemeMasterDAO.deleteShiftSchemeMaster(objShiftSchemeMasterBean);
	}

	@Override
	public ShiftSchemeMasterBean getShiftSchemeMasterEditList(String schemeName) throws Exception {
		return shiftSchemeMasterDAO.getShiftSchemeMasterEditList(schemeName);
	}

	@Override
	public void updateShiftSchemeMaster(ShiftSchemeMasterBean objShiftSchemeMasterBean) throws Exception {
		shiftSchemeMasterDAO.updateShiftSchemeMaster(objShiftSchemeMasterBean);
	}

	@Override
	public ArrayList getShiftSchemeMasterWeekList(String schemeName) throws Exception {
		return shiftSchemeMasterDAO.getShiftSchemeMasterWeekList(schemeName);
	}

	@Override
	public boolean uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		return shiftSchemeMasterDAO.uploadFile(file);

	}

	@Override
	public void addShiftSchemeMaster(ShiftSchemeMasterBean objShiftSchemeMasterBean) throws Exception {
		shiftSchemeMasterDAO.addShiftSchemeMaster(objShiftSchemeMasterBean);
	}
}
