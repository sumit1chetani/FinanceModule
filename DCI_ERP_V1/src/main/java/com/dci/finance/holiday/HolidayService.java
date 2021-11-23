package com.dci.finance.holiday;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.model.SelectivityBean;



public interface HolidayService {

	List<HolidayBean> getHolidayList() throws Exception;

	List<HolidayBean> getTotalHolidaylist() throws Exception;

	public void saveHoliday(HolidayBean holidaybean) throws Exception;

	public HolidayBean getHolidayEditList(Integer holidayId) throws Exception;

	public boolean updateHoliday(HolidayBean holidaybean) throws Exception;

	public boolean deleteHoliday(Integer holidayId) throws Exception;

	public boolean uploadFile(MultipartFile file);

	List<SelectivityBean> getboardList();
	
	List<SelectivityBean> getgradeList();
	
	public List<HolidayBean> getCustomerListByVoyage(String departmentId);

	List<SelectivityBean> getbranchList();

	

	
}
