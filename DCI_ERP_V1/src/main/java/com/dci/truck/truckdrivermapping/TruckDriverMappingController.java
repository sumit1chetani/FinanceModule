package com.dci.truck.truckdrivermapping;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;



@RestController
@RequestMapping("{tenantid}/truckdrivermapping")

public class TruckDriverMappingController {
	private final static Logger LOGGER = LoggerFactory.getLogger(TruckDriverMappingController.class);

	
	@Autowired
	private TruckDriverMappingService TruckDriverMappingService;
	
	

	@RequestMapping(value = "/trucklist")
	public TruckDriverMappingResultBean gettruckList() {
		TruckDriverMappingResultBean TruckDriverMappingResultBean = new TruckDriverMappingResultBean();
		try {
			TruckDriverMappingResultBean = TruckDriverMappingService.gettruckList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return TruckDriverMappingResultBean;
	}
	@RequestMapping(value = "/driverlist")
	public TruckDriverMappingResultBean getdriverList() {
		TruckDriverMappingResultBean TruckDriverMappingResultBean = new TruckDriverMappingResultBean();
		try {
			TruckDriverMappingResultBean = TruckDriverMappingService.getdriverList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return TruckDriverMappingResultBean;
	}
	@RequestMapping(value = "/list")
	public TruckDriverMappingResultBean getList() throws CustomException {
		TruckDriverMappingResultBean TruckDriverMappingResultBean = new TruckDriverMappingResultBean();
		try {

			TruckDriverMappingResultBean.setList(TruckDriverMappingService.getList());

		} catch (Exception e) {
			LOGGER.error("error"+ e);
			throw new CustomException();
		}

		
		return TruckDriverMappingResultBean;
	}

@RequestMapping(value = "/save")
	public @ResponseBody Object save(@RequestBody TruckDriverMappingBean TruckDriverMapping) throws CustomException  
{
		TruckDriverMappingResultBean TruckDriverMappingResultBean = new TruckDriverMappingResultBean();
		Object isSuccess;
		try {
			isSuccess=TruckDriverMappingService.insertTruckDriverMapping(TruckDriverMapping);
		} catch (Exception e) {
			LOGGER.error("error on TruckDriverMapping" + e);
			throw new CustomException();
			
		}
		return isSuccess;
	}
	
	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody TruckDriverMappingBean TruckDriverMapping) throws CustomException {
		boolean isSuccess = false;
		
		try {
			isSuccess = TruckDriverMappingService.updateTruckDriverMapping(TruckDriverMapping);
			
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	
	
	@RequestMapping("/delete")
	public @ResponseBody boolean delete(@RequestBody int rowid) throws Exception {
		boolean isDeleted = false;
		isDeleted = TruckDriverMappingService.deleteTruckDriverMapping(rowid);
;
		return isDeleted;
	}
	
	@RequestMapping("/edit")
	public @ResponseBody TruckDriverMappingBean  getTruckDriverMappingById(@RequestBody int rowid) throws CustomException 

	{
		TruckDriverMappingBean TruckDriverMapping = new TruckDriverMappingBean();
		try {
			TruckDriverMapping = TruckDriverMappingService.getTruckDriverMappingById(rowid);
			
		} catch (Exception e) {
			
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return TruckDriverMapping;
	}

	@RequestMapping(value = "/checkEdit", method = RequestMethod.GET)
	public @ResponseBody boolean checkEdit(@RequestParam Integer driverMappingId) throws CustomException {
		boolean isSuccess=false;
		try {

			isSuccess = TruckDriverMappingService.checkEdit(driverMappingId);

		} catch (Exception e) {
			throw new CustomException();
		}

		return isSuccess;
	}
	
	@RequestMapping(value = "/selectedTruckList")
	public @ResponseBody List<SortedMap<String, String>> getSelectedTruckList(@RequestBody TruckDriverMappingBean param) throws CustomException {
		
		TruckDriverMappingResultBean result=new TruckDriverMappingResultBean();
		List<SortedMap<String, String>> availResult= new ArrayList<SortedMap<String,String>>();
		try {
			result = TruckDriverMappingService.getSelectedTruckList(param.getTruckId(), null, null);
			if(result.getList() != null && result.getList().size() > 0){
				availResult = getScheduleMap(result,"1",param.getTruckName());
				}else{
					availResult =getScheduleEmtyMap("1",param.getTruckName());
				}
			

		} catch (Exception e) {
			throw new CustomException();
		}

		return availResult;
	}
	
	@RequestMapping(value = "/selectedPrmDrvList")
	public @ResponseBody List<SortedMap<String, String>> getSelectedPrimDrvList(@RequestBody TruckDriverMappingBean param) throws CustomException {
		List<SortedMap<String, String>> availResult= new ArrayList<SortedMap<String,String>>();
		TruckDriverMappingResultBean result=new TruckDriverMappingResultBean();
		try {
			result = TruckDriverMappingService.getSelectedPrimDrvList(null, param.getDriverId(), null);
			if(result.getList() != null && result.getList().size() > 0){
				availResult = getScheduleMap(result,"2",param.getDriverName());
			}else{
				availResult =getScheduleEmtyMap("2",param.getDriverName());
			}
			

		} catch (Exception e) {
			throw new CustomException();
		}

		return availResult;
	}
	
	
	@RequestMapping(value = "/selectedSecDrvList")
	public @ResponseBody List<SortedMap<String, String>> getSelectedSecDrvList(@RequestBody TruckDriverMappingBean param) throws CustomException {
		List<SortedMap<String, String>> availResult= new ArrayList<SortedMap<String,String>>();
		TruckDriverMappingResultBean result=new TruckDriverMappingResultBean();
		try {
			result = TruckDriverMappingService.getSelectedSecDrvList(null,null, param.getSdriverId());
			if(result.getList() != null && result.getList().size() > 0){
				availResult =getScheduleMap(result,"3",param.getSdriverName());
			}else{
				availResult =getScheduleEmtyMap("3",param.getSdriverName());
			}
		} catch (Exception e) {
			throw new CustomException();
		}

		return availResult;
	}
	
	
	
	public List<SortedMap<String,String>> getScheduleMap(TruckDriverMappingResultBean result,String id,String name){
		List<SortedMap<String, String>> availResult = new ArrayList<SortedMap<String,String>>();
		for (TruckDriverMappingBean itr : result.getList()) {
			SortedMap<String, String> map = new TreeMap<String,String>();
			map.put("id",id);
			map.put("truck",  name.length()> 0 ? name : id.equals("1") ? (itr.getTruckName()) : id.equals("2")?	(itr.getDriverName()) : (itr.getSdriverName()));
			map.put("pDriverId", itr.getDriverId());
			map.put("sDriverId", itr.getSdriverId());
			map.put("pDriver", itr.getDriverName());
			map.put("sDriver", itr.getSdriverName());
			map.put("eventColor", "green");
			map.put("resourceId", id);
			map.put("start", itr.getFromDate());
			map.put("end", itr.getToDate());
			map.put("fromDate", itr.getFromDate());
			map.put("toDate", itr.getToDate());
			map.put("title",  name.length()> 0 ? name : id.equals("1") ? (itr.getTruckName()) : id.equals("2")?	(itr.getDriverName()) : (itr.getSdriverName()));
			map.put("mtitle",itr.getTruckName());
			map.put("category","truck");
			map.put("categoryId",itr.getTrkDrvMapId());
			availResult.add(map);
		}
	
		return availResult;
		
	}
	
	public List<SortedMap<String,String>> getScheduleEmtyMap(String id,String name){
	 List<SortedMap<String, String>> availResult = new ArrayList<SortedMap<String,String>>();
		SortedMap<String, String> map = new TreeMap<String,String>();
		map.put("id", id);
		map.put("truck", name);
		map.put("pDriverId", "");
		map.put("sDriverId", "");
		map.put("pDriver", "");
		map.put("sDriver", "");
		map.put("eventColor", "");
		map.put("resourceId",id);
		map.put("start","");
		map.put("end", "");
		map.put("title", "");
		map.put("mtitle", "");
		map.put("category","truck");
		map.put("categoryId","");
		availResult.add(map);
		return availResult;
	}
	
}
