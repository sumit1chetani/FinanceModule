package com.dci.mobileApp;

import java.util.List;

import com.dci.tenant.user.UserDetail;

public class MobileAppResultBean {
	public String message;
	public boolean success;
	UserDetail userDetail;
	MobileAppBean trmsUserDetail;
	MobileAppBean locationDetail;
	MobileAppBean CustomerDetail;
	MobileAppBean BookingDetail;
	List<MobileAppBean> ExpensesList;
	List<MobileAppBean> BookingList;
	
	public List<MobileAppBean> getBookingList() {
		return BookingList;
	}
	public void setBookingList(List<MobileAppBean> bookingList) {
		BookingList = bookingList;
	}
	public List<MobileAppBean> getExpensesList() {
		return ExpensesList;
	}
	public void setExpensesList(List<MobileAppBean> expensesList) {
		ExpensesList = expensesList;
	}
	public MobileAppBean getBookingDetail() {
		return BookingDetail;
	}
	public void setBookingDetail(MobileAppBean bookingDetail) {
		BookingDetail = bookingDetail;
	}
	public MobileAppBean getLocationDetail() {
		return locationDetail;
	}
	public void setLocationDetail(MobileAppBean locationDetail) {
		this.locationDetail = locationDetail;
	}
	public MobileAppBean getCustomerDetail() {
		return CustomerDetail;
	}
	public void setCustomerDetail(MobileAppBean customerDetail) {
		CustomerDetail = customerDetail;
	}
	public MobileAppBean getTrmsUserDetail() {
		return trmsUserDetail;
	}
	public void setTrmsUserDetail(MobileAppBean trmsUserDetail) {
		this.trmsUserDetail = trmsUserDetail;
	}
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
