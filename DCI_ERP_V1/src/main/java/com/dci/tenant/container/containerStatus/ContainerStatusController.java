package com.dci.tenant.container.containerStatus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dci.tenant.user.UserDetail;


 @RestController
@RequestMapping(value = "{tenantid}/api/containerStatus")
public class ContainerStatusController {

	@Autowired
	private ContainerStatusService containerStatusService;

	@GetMapping("/list")
	public List<ContainerStatusBean> getContainerStatusList() {
		System.out.println("Get all ContainerStatusList...");

		List<ContainerStatusBean> containerStatusList = new ArrayList<>();
		
		containerStatusList=containerStatusService.getContainerStatusList();

		return containerStatusList;
	}
	
	@RequestMapping(value = "/save" )
	public ContainerStatusBean save(@RequestBody ContainerStatusBean containerStatus) {
		ContainerStatusBean objbranchResultBean = new ContainerStatusBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		try {
			objbranchResultBean = containerStatusService.insert(containerStatus, userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return objbranchResultBean;

	}
	
	@RequestMapping("/delete") 
	public ContainerStatusBean delete(@RequestParam("containerStatusCode")  String containerStatusCode)
	 {
		ContainerStatusBean containerStatusBean = new ContainerStatusBean();
		containerStatusBean = containerStatusService.delete(containerStatusCode);
		return containerStatusBean;
		
	}
	
	
	@RequestMapping(value="/edit") 
	public ContainerStatusBean getContainerStatusEdit(@RequestParam("containerStatusCode") String containerStatusCode) {
	
		ContainerStatusBean containerStatusBean = new ContainerStatusBean();
		
		containerStatusBean=containerStatusService.getContainerStatusEdit(containerStatusCode);

		return containerStatusBean;
	}
	
	@RequestMapping(value = "/update" ,method = RequestMethod.POST)
	public ContainerStatusBean Update(@RequestBody ContainerStatusBean containerStatus) {
		ContainerStatusBean objbranchResultBean = new ContainerStatusBean();
		try {
			objbranchResultBean = containerStatusService.update(containerStatus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return objbranchResultBean;

	}
}

