package  com.dci.finance.shiftallocation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;


@Service
public class ShiftAllocationServiceImpl implements ShiftAllocationService {

	@Autowired
	ShiftAllocationDAO shiftAllocationDAO;

	@Override
	public List<ShiftAllocationBean> getShiftAllocationList() throws Exception {
		return shiftAllocationDAO.getShiftAllocationList();
	}

	@Override
	public ShiftAllocationResultBean getBranchList(String companyId) throws Exception {
		return shiftAllocationDAO.getBranchList(companyId);
	}

	@Override
	public ShiftAllocationResultBean getDepartmentList(String branchId) throws Exception {
		return shiftAllocationDAO.getDepartmentList(branchId);
	}

	@Override
	public ShiftAllocationResultBean getEmployeeList(ShiftAllocationBean bean) throws Exception {
		return shiftAllocationDAO.getEmployeeList(bean);
	}

	@Override
	public ShiftAllocationResultBean getSchemeList(ShiftAllocationBean shiftAllocationBean) throws CustomException {
		return shiftAllocationDAO.getSchemeList(shiftAllocationBean);
	}

	@Override
	public ShiftAllocationBean addShiftAllocation(ShiftAllocationBean objShiftAllocationBean) throws Exception {
		return shiftAllocationDAO.addShiftAllocation(objShiftAllocationBean);
	}

	@Override
	public boolean updateShiftAllocation(ShiftAllocationBean objShiftAllocationBean) throws Exception {
		return shiftAllocationDAO.updateShiftAllocation(objShiftAllocationBean);
	}

	@Override
	public boolean deleteShiftAllocation(int schemeId, String employeeId, String validFrom, String validTo) throws Exception {
		return shiftAllocationDAO.deleteShiftAllocation(schemeId, employeeId, validFrom, validTo);
	}

	@Override
	public ShiftAllocationResultBean getShiftList() throws Exception {
		return shiftAllocationDAO.getShiftList();
	}

	@Override
	public ShiftAllocationBean getShiftAllocationEditList(int schemeId, String employeeId, String validFrom, String validTo) throws Exception {
		return shiftAllocationDAO.getShiftAllocationEditList(schemeId, employeeId, validFrom, validTo);
	}

	@Override
	public ShiftAllocationResultBean getDateList(String schemeName) throws Exception {
		return shiftAllocationDAO.getDateList(schemeName);
	}

}
