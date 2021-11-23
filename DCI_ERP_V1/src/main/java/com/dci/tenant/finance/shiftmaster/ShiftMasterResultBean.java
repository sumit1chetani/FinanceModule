package com.dci.tenant.finance.shiftmaster;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class ShiftMasterResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ShiftMasterBean> shiftMasterList;

	private ShiftMasterBean shiftMaster = new ShiftMasterBean();

	public List<ShiftMasterBean> getShiftMasterList() {
		return shiftMasterList;
	}

	public void setShiftMasterList(List<ShiftMasterBean> shiftMasterList) {
		this.shiftMasterList = shiftMasterList;
	}

	public ShiftMasterBean getShiftMaster() {
		return shiftMaster;
	}

	public void setShiftMaster(ShiftMasterBean shiftMaster) {
		this.shiftMaster = shiftMaster;
	}

}
