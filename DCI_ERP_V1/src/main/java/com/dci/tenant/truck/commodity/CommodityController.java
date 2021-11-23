package com.dci.tenant.truck.commodity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "{tenantid}/api/commodity")
public class CommodityController {

	@Autowired
	private CommodityService commodityService;

	@RequestMapping("/list")
	public List<CommodityBean> getCommodityList() {
		System.out.println("Get all CommodityList...");

		List<CommodityBean> commodityList = new ArrayList<>();
		
		commodityList=commodityService.getCommodityList();

		return commodityList;
	}
	
	@RequestMapping(value = "/create" ,method = RequestMethod.POST)
	public CommodityBean save(@RequestBody CommodityBean commodity) {
		CommodityBean objbranchResultBean = new CommodityBean();
		try {
			objbranchResultBean = commodityService.insert(commodity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return objbranchResultBean;

	}
	@RequestMapping("/classification")
	public List<CommodityBean> getDropDown() {
	
		List<CommodityBean> List = new ArrayList<>();
		
		List=commodityService.getDropDown();

		return List;
	}
	@RequestMapping("/delete")
	public boolean delete(@RequestParam("commodityCode") String commodityCode) {
		boolean isDeleted = false;
		try{
		  isDeleted = commodityService.delete(commodityCode);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return isDeleted;
	}
	
	
	@RequestMapping(value="/edit") 
	public CommodityBean getCommodityEdit(@RequestParam("commodityCode") String commodityCode) {
	
		CommodityBean commodityBean = new CommodityBean();
		
		commodityBean=commodityService.getCommodityEdit(commodityCode);

		return commodityBean;
	}
	
	@RequestMapping(value = "/update" ,method = RequestMethod.POST)
	public CommodityBean Update(@RequestBody CommodityBean commodity) {
		CommodityBean objbranchResultBean = new CommodityBean();
		try {
			objbranchResultBean = commodityService.update(commodity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return objbranchResultBean;

	}

}
