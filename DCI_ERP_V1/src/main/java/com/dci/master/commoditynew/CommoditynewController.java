package com.dci.master.commoditynew;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "{tenantid}/api/commoditynew")
public class CommoditynewController {

	@Autowired
	private CommoditynewService commodityService;

	@RequestMapping("/list")
	public List<CommoditynewBean> getCommodityList() {
		System.out.println("Get all CommodityList...");

		List<CommoditynewBean> commodityList = new ArrayList<>();
		
		commodityList=commodityService.getCommodityList();

		return commodityList;
	}
	
	@RequestMapping(value = "/create" ,method = RequestMethod.POST)
	public CommoditynewBean save(@RequestBody CommoditynewBean commodity) {
		CommoditynewBean objbranchResultBean = new CommoditynewBean();
		try {
			objbranchResultBean = commodityService.insert(commodity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return objbranchResultBean;

	}
	@RequestMapping("/classification")
	public List<CommoditynewBean> getDropDown() {
	
		List<CommoditynewBean> List = new ArrayList<>();
		
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
	public CommoditynewBean getCommodityEdit(@RequestParam("commodityCode") String commodityCode) {
	
		CommoditynewBean commodityBean = new CommoditynewBean();
		
		commodityBean=commodityService.getCommodityEdit(commodityCode);

		return commodityBean;
	}
	
	@RequestMapping(value = "/update" ,method = RequestMethod.POST)
	public CommoditynewBean Update(@RequestBody CommoditynewBean commodity) {
		CommoditynewBean objbranchResultBean = new CommoditynewBean();
		try {
			objbranchResultBean = commodityService.update(commodity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return objbranchResultBean;

	}

}
