package com.dci.dashboard;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "{tenantid}/app/dashboard")
@Component("dashboard")

public class DashBoardController { 
	
}
	
	

