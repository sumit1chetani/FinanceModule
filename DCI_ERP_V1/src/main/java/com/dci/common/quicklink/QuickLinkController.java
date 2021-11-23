package com.dci.common.quicklink;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping(value = "{tenantid}/app/quickLink")
public class QuickLinkController {

	@Autowired
	private QuickLinkService quickLinkService;
	
	@RequestMapping(value = "/getqlList")
	public @ResponseBody List<QuickLinkBean> getqlList() {
		
		List<QuickLinkBean> List = new ArrayList<>();
		
		List=quickLinkService.getqlList();

		return List;
	}
	
	@RequestMapping(value = "/getqlDtl")
	public @ResponseBody QuickLinkBean getqlDtl(@RequestBody Integer id) {
		
		QuickLinkBean List = null;
		
		List=quickLinkService.getqlDtl(id);

		return List;
	}
	
	@RequestMapping(value = "/getBookingNo")
	public @ResponseBody QuickLinkBean getBookingNo(@RequestBody String id) {
		
		QuickLinkBean List = null;
		
		List=quickLinkService.getBookingNo(id);

		return List;
	}
	
	@RequestMapping(value = "/getCRONo")
	public @ResponseBody QuickLinkBean getCRONo(@RequestBody String id) {
		
		QuickLinkBean List = null;
		
		List=quickLinkService.getCRONo(id);

		return List;
	}
	
	@RequestMapping(value = "/getGout")
	public @ResponseBody QuickLinkBean getGout(@RequestBody String id) {
		
		QuickLinkBean List = null;
		
		List=quickLinkService.getGout(id);

		return List;
	}
	
	@RequestMapping(value = "/getGin")
	public @ResponseBody QuickLinkBean getGin(@RequestBody String id) {
		
		QuickLinkBean List = null;
		
		List=quickLinkService.getGin(id);

		return List;
	}
	
	@RequestMapping(value = "/getShipmentOrder")
	public @ResponseBody QuickLinkBean getShipmentOrder(@RequestBody String id) {
		
		QuickLinkBean List = null;
		
		List=quickLinkService.getShipmentOrder(id);

		return List;
	}
	
	@RequestMapping(value = "/getBl")
	public @ResponseBody QuickLinkBean getBl(@RequestBody String id) {
		
		QuickLinkBean List = null;
		
		List=quickLinkService.getBl(id);

		return List;
	}
	
	
}
