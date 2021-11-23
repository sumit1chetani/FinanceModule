package com.dci.finance.shiftreallocation;

import java.util.List;

import com.dci.common.util.CustomException;


public interface ShiftReAllocationDAO {

	public List<ShiftReAllocationBean> getShiftReAllocationList() throws Exception;

	public ShiftReAllocationResultBean getDesignationList(String empId) throws Exception;

	public boolean addShiftReAllocation(ShiftReAllocationBean objShiftReAllocationBean) throws CustomException;

	public boolean updateShiftReAllocation(ShiftReAllocationBean objShiftReAllocationBean) throws Exception;

	public boolean deleteShiftReAllocation(String shiftCode, String employeeId) throws Exception;

	public ShiftReAllocationBean getShiftReAllocationEditList(String employeeId, String fromDate, String toDate) throws Exception;

	public ShiftReAllocationResultBean getShiftList() throws CustomException;

	public ShiftReAllocationResultBean getShiftNameList() throws CustomException;

	public List<ShiftReAllocationBean> getDropdown();
	
	
	public List<ShiftReAllocationBean> companyList();


	public List<ShiftReAllocationBean> shiftNameList();

}