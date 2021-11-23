package com.dci.tenant.finance.shiftschememaster;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class ShiftSchemeMasterResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ShiftSchemeMasterBean> shiftSchemeMasterList;

	private List shiftNameList;

	private ShiftSchemeMasterBean shiftSchemeMaster = new ShiftSchemeMasterBean();

	public List<ShiftSchemeMasterBean> getShiftSchemeMasterList() {
		return shiftSchemeMasterList;
	}

	public void setShiftSchemeMasterList(List<ShiftSchemeMasterBean> shiftSchemeMasterList) {
		this.shiftSchemeMasterList = shiftSchemeMasterList;
	}

	public ShiftSchemeMasterBean getShiftSchemeMaster() {
		return shiftSchemeMaster;
	}

	public void setShiftSchemeMaster(ShiftSchemeMasterBean shiftSchemeMaster) {
		this.shiftSchemeMaster = shiftSchemeMaster;
	}

	public List getShiftNameList() {
		return shiftNameList;
	}

	public void setShiftNameList(List shiftNameList) {
		this.shiftNameList = shiftNameList;
	}

}
