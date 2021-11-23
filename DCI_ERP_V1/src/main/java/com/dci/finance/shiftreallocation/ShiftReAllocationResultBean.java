package com.dci.finance.shiftreallocation;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class ShiftReAllocationResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ShiftReAllocationBean> shiftReAllocationList;

	/* private List shiftList; */
	private List designationList;
	private List<ShiftReAllocationBean> shiftList;
	private List<ShiftReAllocationBean> shiftNameList;

	public List<ShiftReAllocationBean> getShiftNameList() {
		return shiftNameList;
	}

	public void setShiftNameList(List<ShiftReAllocationBean> shiftNameList) {
		this.shiftNameList = shiftNameList;
	}

	public List<ShiftReAllocationBean> getShiftList() {
		return shiftList;
	}

	public void setShiftList(List<ShiftReAllocationBean> shiftList) {
		this.shiftList = shiftList;
	}

	public List getDesignationList() {
		return designationList;
	}

	public void setDesignationList(List designationList) {
		this.designationList = designationList;
	}

	public List<ShiftReAllocationBean> getShiftReAllocationList() {
		return shiftReAllocationList;
	}

	public void setShiftReAllocationList(List<ShiftReAllocationBean> shiftReAllocationList) {
		this.shiftReAllocationList = shiftReAllocationList;
	}

}