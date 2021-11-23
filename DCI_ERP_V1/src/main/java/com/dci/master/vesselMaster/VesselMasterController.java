package com.dci.master.vesselMaster;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;




@RestController
@RequestMapping(value = "{tenantid}/api/vesselmaster")
public class VesselMasterController {


	@Autowired
	private VesselMasterService vesselService;

	@RequestMapping("/list")
	public List<VesselMasterBean> getVesselList() {
		System.out.println("Get all Vessel...");

		List<VesselMasterBean> vesselList = new ArrayList<>();
		
		vesselList=vesselService.getVesselList();

		return vesselList;
	}
	
	@RequestMapping(value = "/linelist")
	public List<VesselMasterBean> getDropDown() {
		
		List<VesselMasterBean> List = new ArrayList<>();
		
		List=vesselService.getDropDown();

		return List;
	}
	
	
	
	
	@RequestMapping(value = "/create" ,method = RequestMethod.POST)
	public VesselMasterBean save(@RequestBody VesselMasterBean vessel) {
		VesselMasterBean objbranchResultBean = new VesselMasterBean();
		try {
			objbranchResultBean = vesselService.insert(vessel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return objbranchResultBean;

	}
	@RequestMapping(value="/delete") 
	public @ResponseBody VesselMasterBean delete(@RequestParam("vesselID") Integer vesselID) throws Exception {
		boolean isDeleted = false;
		VesselMasterBean bean = new VesselMasterBean();
		try{
			
			bean = vesselService.delete(vesselID);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return bean;
	}
	
	
	@RequestMapping(value="/edit") 
	public VesselMasterBean getVesselEdit(@RequestParam("vesselID") Integer vesselID) {
	
		VesselMasterBean damageBean = new VesselMasterBean();
		
		damageBean=vesselService.getVesselEdit(vesselID);

		return damageBean;
	}
	
	@RequestMapping(value = "/update" ,method = RequestMethod.POST)
	public VesselMasterBean Update(@RequestBody VesselMasterBean vessel) {
		VesselMasterBean objbranchResultBean = new VesselMasterBean();
		try {
			objbranchResultBean = vesselService.update(vessel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return objbranchResultBean;

	}
	@RequestMapping("/dropDownList")
	public @ResponseBody VesselMasterResultBean getDropDownList() throws CustomException {
		List nationalityList = new ArrayList();

		VesselMasterResultBean dropdownbean = new VesselMasterResultBean();
		try {
			nationalityList = vesselService.getDropDown();
			dropdownbean.setNationalityList(nationalityList);
		} catch (Exception e) {
			e.printStackTrace();

		}

		return dropdownbean;
	}
	
	
}
