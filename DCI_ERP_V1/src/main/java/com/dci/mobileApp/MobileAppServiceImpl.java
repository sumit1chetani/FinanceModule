package com.dci.mobileApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileAppServiceImpl implements MobileAppService {
	@Autowired
	private MobileAppDAO mobileAppDAO;
	@Override
	public MobileAppResultBean userLogin(MobileAppBean userDetail) {
		// TODO Auto-generated method stub
		return mobileAppDAO.userLogin(userDetail);
	}
	@Override
	public MobileAppResultBean insertBooking(MobileAppBean bookingDetail) {
		// TODO Auto-generated method stub
		return mobileAppDAO.insertBooking(bookingDetail);
	}
	@Override
	public MobileAppResultBean getBookingDropDown() {
		// TODO Auto-generated method stub
		return mobileAppDAO.getBookingDropDown();
	}
	
	@Override
	public MobileAppResultBean insertExpenses(MobileAppBean ExpensesDetail) {
		// TODO Auto-generated method stub
		return mobileAppDAO.insertExpenses(ExpensesDetail);
	}
	
	@Override
	public MobileAppResultBean getBookingDetails(String userId) {
		// TODO Auto-generated method stub
		return mobileAppDAO.getBookingDetails(userId);
	}
	
	@Override
	public MobileAppResultBean getEditBooking(String bookingId) {
		// TODO Auto-generated method stub
		return mobileAppDAO.getEditBooking(bookingId);
	}
}
