package com.dci.master.employeeAdminMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "{tenantid}/app/employeeSchedule")

public class EmployeeScheduleController {

	@Autowired
	private EmployeeSchedule employeeSchedule;
	
	@RequestMapping(value = "/reportList")
	public @ResponseBody boolean getEmployeeSchedule()
	{ 
		boolean isSuccess=false;
		try
		{
			employeeSchedule.sendingDojList();
			employeeSchedule.sendingReleivingList();

			isSuccess=true;	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccess;
		
	}
}
