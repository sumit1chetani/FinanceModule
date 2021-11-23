package  com.dci.finance.shiftallocation;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class ShiftAllocationResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ShiftAllocationBean> shiftAllocationList;

	private List branchList;
	private List schemeList;
	private List departmentList;
	private List employeeList;
	private List shiftList;
	private List dateList;

	private ShiftAllocationBean shiftAllocation = new ShiftAllocationBean();

	public ShiftAllocationBean getShiftAllocation() {
		return shiftAllocation;
	}

	public void setShiftAllocation(ShiftAllocationBean shiftAllocation) {
		this.shiftAllocation = shiftAllocation;
	}

	public List<ShiftAllocationBean> getShiftAllocationList() {
		return shiftAllocationList;
	}

	public void setShiftAllocationList(List<ShiftAllocationBean> shiftAllocationList) {
		this.shiftAllocationList = shiftAllocationList;
	}

	public List getBranchList() {
		return branchList;
	}

	public void setBranchList(List branchList) {
		this.branchList = branchList;
	}

	public List getSchemeList() {
		return schemeList;
	}

	public void setSchemeList(List schemeList) {
		this.schemeList = schemeList;
	}

	public List getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List departmentList) {
		this.departmentList = departmentList;
	}

	public List getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List employeeList) {
		this.employeeList = employeeList;
	}

	public List getShiftList() {
		return shiftList;
	}

	public void setShiftList(List shiftList) {
		this.shiftList = shiftList;
	}

	public List getDateList() {
		return dateList;
	}

	public void setDateList(List dateList) {
		this.dateList = dateList;
	}

}
