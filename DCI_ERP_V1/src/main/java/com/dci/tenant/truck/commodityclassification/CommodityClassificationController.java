package com.dci.tenant.truck.commodityclassification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "{tenantid}/api/commodityclassification")
public class CommodityClassificationController {
	@Autowired
	private CommodityClassificationService commodityclassificationService;

	@RequestMapping("/list")
	public List<CommodityClassificationBean> getCommodityClassificationList() {
		System.out.println("Get all CommodityClassificationList...");

		List<CommodityClassificationBean> commodityclassificationList = new ArrayList<>();
		
		commodityclassificationList=commodityclassificationService.getCommodityList();

		return commodityclassificationList;
	}
	
	@RequestMapping(value = "/create" ,method = RequestMethod.POST)
	public CommodityClassificationBean save(@RequestBody CommodityClassificationBean commodityclassification) {
		CommodityClassificationBean objbranchResultBean = new CommodityClassificationBean();
		try {
			objbranchResultBean = commodityclassificationService.insert(commodityclassification);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return objbranchResultBean;

	}
	
	@RequestMapping("/delete")
	public boolean delete(@RequestParam("classificationCode") String classificationCode) {
		boolean isDeleted = false;
		try{
		  isDeleted = commodityclassificationService.delete(classificationCode);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return isDeleted;
	}
	
	
	@RequestMapping(value="/edit") 
	public CommodityClassificationBean getCommodityClassificationEdit(@RequestParam("classificationCode") String classificationCode) {
	
		CommodityClassificationBean commodityclassificationBean = new CommodityClassificationBean();
		
		commodityclassificationBean=commodityclassificationService.getCommodityEdit(classificationCode);

		return commodityclassificationBean;
	}
	
	@RequestMapping(value = "/update" ,method = RequestMethod.POST)
	public CommodityClassificationBean Update(@RequestBody CommodityClassificationBean commodityclassification) {
		CommodityClassificationBean objbranchResultBean = new CommodityClassificationBean();
		try {
			objbranchResultBean = commodityclassificationService.update(commodityclassification);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return objbranchResultBean;

	}

}