package com.dci.finance.holiday;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

public class HolidayResultBean extends BasicResultBean implements Serializable {

	private List<HolidayBean> holidayList;
	private List<SelectivityBean> BranchList;
	private HolidayBean holiday = new HolidayBean();

	public HolidayBean getHoliday() {
		return holiday;
	}

	public void setHoliday(HolidayBean holiday) {
		this.holiday = holiday;
	}

	public List<HolidayBean> getHolidayList() {
		return holidayList;
	}

	public void setHolidayList(List<HolidayBean> holidayList) {
		this.holidayList = holidayList;
	}

	public List<SelectivityBean> getBranchList() {
		return BranchList;
	}

	public void setBranchList(List<SelectivityBean> branchList) {
		BranchList = branchList;
	}

}
