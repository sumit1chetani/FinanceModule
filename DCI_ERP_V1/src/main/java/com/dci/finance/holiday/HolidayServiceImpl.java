package com.dci.finance.holiday;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.model.SelectivityBean;



@Service
public class HolidayServiceImpl implements HolidayService {
	@Autowired
	HolidayDAO holidayDAO;

	@Override
	public List<HolidayBean> getHolidayList() throws Exception {
		// TODO Auto-generated method stub
		return holidayDAO.getHolidayList();
	}

	@Override
	public void saveHoliday(HolidayBean holidaybean) throws Exception {
		// TODO Auto-generated method stub
		holidayDAO.saveHoliday(holidaybean);

	}

	@Override
	public HolidayBean getHolidayEditList(Integer holidayId) throws Exception {
		// TODO Auto-generated method stub
		return holidayDAO.getHolidayEditList(holidayId);
	}

	@Override
	public boolean updateHoliday(HolidayBean holidaybean) throws Exception {
		// TODO Auto-generated method stub
		return holidayDAO.updateHoliday(holidaybean);
	}

	@Override
	public boolean deleteHoliday(Integer holidayId) throws Exception {
		// TODO Auto-generated method stub
		return holidayDAO.deleteHoliday(holidayId);
	}

	@Override
	public boolean uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		return holidayDAO.uploadFile(file);

	}

	@Override
	public List<HolidayBean> getTotalHolidaylist() throws Exception {
		// TODO Auto-generated method stub
		return holidayDAO.getTotalHolidaylist();
	}

	@Override
	public List<SelectivityBean> getboardList() {
		// TODO Auto-generated method stub
		return holidayDAO.getboardList();
	}
	
	
	@Override
	public List<SelectivityBean> getgradeList() {
		// TODO Auto-generated method stub
		return holidayDAO.getgradeList();
	}
	
	@Override
	public List<HolidayBean> getCustomerListByVoyage(String departmentId) {
		return holidayDAO.getCustomerListByVoyage(departmentId);
	}
	@Override
	public List<SelectivityBean> getbranchList() {
		// TODO Auto-generated method stub
		return holidayDAO.getbranchList();
	}
}
