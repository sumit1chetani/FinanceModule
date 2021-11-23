package com.dci.mobileApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(value = "{tenantid}/app/mobileApp")
public class MobileAppController {
	private final static Logger LOGGER = LoggerFactory.getLogger(MobileAppController.class);

	@Autowired
	private MobileAppService mobileAppService;
	
	@RequestMapping("/mobilelogin")
	public @ResponseBody MobileAppResultBean userLogin(@RequestBody MobileAppBean userDetail,HttpServletRequest request,HttpServletResponse response)
	{
		MobileAppResultBean moblieUserResultBean = new MobileAppResultBean();
		try
		{
			moblieUserResultBean=mobileAppService.userLogin(userDetail);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return moblieUserResultBean;
		
	}
	
	
	@RequestMapping("/insertBooking")
	public @ResponseBody MobileAppResultBean insertBooking(@RequestBody MobileAppBean bookingDetail,HttpServletRequest request,HttpServletResponse response)
	{
		MobileAppResultBean moblieUserResultBean = new MobileAppResultBean();
		try
		{
			moblieUserResultBean=mobileAppService.insertBooking(bookingDetail);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return moblieUserResultBean;
		
	}
	
	
	@RequestMapping("/getMobilelogin")
	public @ResponseBody MobileAppResultBean getMobilelogin()
	{
		MobileAppResultBean moblieUserResultBean = new MobileAppResultBean();
		try
		{
			moblieUserResultBean.setSuccess(true);
			moblieUserResultBean.setMessage("success");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			moblieUserResultBean.setSuccess(false);
			moblieUserResultBean.setMessage("failed");
		}
		return moblieUserResultBean;
		
	}
	
	@RequestMapping("/getBookingDropDown")
	public @ResponseBody MobileAppResultBean getBookingDropDown()
	{
		MobileAppResultBean moblieUserResultBean = new MobileAppResultBean();
		try
		{
			moblieUserResultBean=mobileAppService.getBookingDropDown();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return moblieUserResultBean;
		
	}
	
	@RequestMapping("/insertExpenses")
	public @ResponseBody MobileAppResultBean insertExpenses(@RequestBody MobileAppBean ExpensesDetail,HttpServletRequest request,HttpServletResponse response)
	{
		MobileAppResultBean moblieUserResultBean = new MobileAppResultBean();
		try
		{
			moblieUserResultBean=mobileAppService.insertExpenses(ExpensesDetail);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return moblieUserResultBean;
		
	}
	
	@RequestMapping("/getBookingDetails")
	public @ResponseBody MobileAppResultBean getBookingDetails(@RequestParam("userId") String userId )
	{
		MobileAppResultBean moblieUserResultBean = new MobileAppResultBean();
		try
		{
			moblieUserResultBean=mobileAppService.getBookingDetails(userId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return moblieUserResultBean;
		
	}
	
	@RequestMapping("/getEditBooking")
	public @ResponseBody MobileAppResultBean getEditBooking(@RequestParam("bookingId") String bookingId )
	{
		MobileAppResultBean moblieUserResultBean = new MobileAppResultBean();
		try
		{
			moblieUserResultBean=mobileAppService.getEditBooking(bookingId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return moblieUserResultBean;
		
	}
	
}
