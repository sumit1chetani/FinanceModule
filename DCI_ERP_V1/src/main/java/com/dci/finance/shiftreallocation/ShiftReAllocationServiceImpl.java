package com.dci.finance.shiftreallocation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;


@Service
public class ShiftReAllocationServiceImpl implements ShiftReAllocationService {

	@Autowired
	ShiftReAllocationDAO shiftReAllocationDAO;

	@Override
	public List<ShiftReAllocationBean> getShiftReAllocationList() throws Exception {
		return shiftReAllocationDAO.getShiftReAllocationList();
	}

	@Override
	public ShiftReAllocationResultBean getDesignationList(String empId) throws Exception {
		return shiftReAllocationDAO.getDesignationList(empId);
	}

	@Override
	public boolean addShiftReAllocation(ShiftReAllocationBean objShiftReAllocationBean) throws CustomException {
		return shiftReAllocationDAO.addShiftReAllocation(objShiftReAllocationBean);
	}

	@Override
	public boolean updateShiftReAllocation(ShiftReAllocationBean objShiftReAllocationBean) throws Exception {
		return shiftReAllocationDAO.updateShiftReAllocation(objShiftReAllocationBean);
	}

	@Override
	public boolean deleteShiftReAllocation(String shiftCode, String employeeId) throws Exception {
		return shiftReAllocationDAO.deleteShiftReAllocation(shiftCode, employeeId);
	}

	@Override
	public ShiftReAllocationBean getShiftReAllocationEditList(String employeeId, String fromDate, String toDate) throws Exception {
		return shiftReAllocationDAO.getShiftReAllocationEditList(employeeId, fromDate, toDate);
	}

	@Override
	public ShiftReAllocationResultBean getShiftList() throws Exception {
		// TODO Auto-generated method stub
		return shiftReAllocationDAO.getShiftList();
	}

	@Override
	public List<ShiftReAllocationBean> getDropdown() {

		return shiftReAllocationDAO.getDropdown();
	}

	
	
	@Override
	public List<ShiftReAllocationBean> companyList() {

		return shiftReAllocationDAO.companyList();
	}
	@Override
	public List<ShiftReAllocationBean> shiftNameList() {

		return shiftReAllocationDAO.shiftNameList();
	}
	
	
	@Override
	public ShiftReAllocationResultBean getShiftNameList() throws CustomException {
		// TODO Auto-generated method stub
		return shiftReAllocationDAO.getShiftNameList();
	}

}