package com.dci.mobileApp;

public interface MobileAppService {
	public MobileAppResultBean userLogin(MobileAppBean userDetail);
	
	public MobileAppResultBean insertBooking(MobileAppBean bookingDetail);
	
	public MobileAppResultBean getBookingDropDown();
	
	public MobileAppResultBean insertExpenses(MobileAppBean ExpensesDetail);
	
	public MobileAppResultBean getBookingDetails(String userId);
	
	public MobileAppResultBean getEditBooking(String bookingId);




}
