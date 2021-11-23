package  com.dci.finance.shiftallocation;

import java.util.List;

import com.dci.common.util.CustomException;


public interface ShiftAllocationDAO {

	public List<ShiftAllocationBean> getShiftAllocationList() throws Exception;

	public ShiftAllocationResultBean getBranchList(String companyId) throws Exception;

	public ShiftAllocationResultBean getDepartmentList(String branchId) throws Exception;

	public ShiftAllocationResultBean getEmployeeList(ShiftAllocationBean bean) throws Exception;

	public ShiftAllocationResultBean getSchemeList(ShiftAllocationBean shiftAllocationBean) throws CustomException;

	public ShiftAllocationBean addShiftAllocation(ShiftAllocationBean objShiftAllocationBean) throws Exception;

	public boolean updateShiftAllocation(ShiftAllocationBean objShiftAllocationBean) throws Exception;

	public ShiftAllocationBean getShiftAllocationEditList(int schemeId, String employeeId, String departmentId, String branchId) throws Exception;

	public boolean deleteShiftAllocation(int schemeId, String employeeId, String validFrom, String validTo) throws Exception;

	public ShiftAllocationResultBean getShiftList() throws Exception;

	public ShiftAllocationResultBean getDateList(String schemeName) throws Exception;

}
