package com.dci.tenant.domain.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;



@RestController
@RequestMapping(value = "{tenantid}/api/dashboard")

public class DashboardController {
	@Autowired
	private DashboardService dashboardService;

	@RequestMapping("/list")
	public List<DashboardlistBean> getList() {
		System.out.println("Get all List...");

		List<DashboardlistBean> List = new ArrayList<>();
		
		List=dashboardService.getList();

		return List;
	}
	

	
	@RequestMapping(value = "/checkWhichUser")
	public @ResponseBody List<Object> isAccountsLogin ()throws CustomException {
		List<Object> li = new ArrayList<Object>();
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			if(userDetails !=null){
					li.add(0,userDetails.getDepartmentName());
					li.add(1,userDetails);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return li;
	}
	
	
	@RequestMapping("/getDescriptionCount")
	public @ResponseBody DashboardResultBean getDescriptionCount(@RequestParam("period")String period){
		DashboardResultBean DashboardResultBean =new DashboardResultBean();
		DashboardResultBean=dashboardService.getDescriptionCount(period);
		return DashboardResultBean;
	}
}
