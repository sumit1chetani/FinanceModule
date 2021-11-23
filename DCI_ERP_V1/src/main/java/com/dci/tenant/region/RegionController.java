package com.dci.tenant.region;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





 @RestController
@RequestMapping(value = "{tenantid}/api/region")

public class RegionController {
	
	@Autowired
	private RegionService regionService;

	@GetMapping("/list")
	public List<RegionBean> getRegionList() {
		System.out.println("Get all Region...");

		List<RegionBean> regionList = new ArrayList<>();
		
		regionList=regionService.getRegionList();

		return regionList;
	}
	
	@RequestMapping(value = "/create" ,method = RequestMethod.POST)
	public RegionBean save(@RequestBody RegionBean region) {
		RegionBean objbranchResultBean = new RegionBean();
		try {
			objbranchResultBean = regionService.insert(region);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return objbranchResultBean;

	}
	
	
	
	
	
	@GetMapping(value="/edit") 
	public RegionBean getRegionEdit(@RequestParam("region_Code") String region_Code) {
	
		RegionBean regionBean = new RegionBean();
		
		regionBean=regionService.getRegionEdit(region_Code);

		return regionBean;
	}
	
	@RequestMapping(value = "/update" ,method = RequestMethod.POST)
	public RegionBean Update(@RequestBody RegionBean region) {
		RegionBean objbranchResultBean = new RegionBean();
		try {
			
			objbranchResultBean = regionService.update(region);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	return objbranchResultBean;
	
	}

	@DeleteMapping(value="/delete/{region_Code}") 
	public RegionBean deleteCustomer(@PathVariable String region_Code){
	 
	RegionBean regionBean = new RegionBean();
	try {
		regionBean = regionService.delete(region_Code);
	} catch (Exception e) {
		e.printStackTrace();
	}

	return regionBean;
}


}



