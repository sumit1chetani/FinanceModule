package com.dci.tenant.master.trucktrailermapping;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;



@RestController
@RequestMapping("{tenantid}/trucktrailermapping")

public class TruckTrailerMappingController {
	private final static Logger LOGGER = LoggerFactory.getLogger(TruckTrailerMappingController.class);

	
	@Autowired
	private TruckTrailerMappingService TruckTrailerMappingService;

	@RequestMapping(value = "/trucklist")
	public TruckTrailerMappingResultBean gettruckList() {
		TruckTrailerMappingResultBean TruckTrailerMappingResultBean = new TruckTrailerMappingResultBean();
		try {
			TruckTrailerMappingResultBean = TruckTrailerMappingService.gettruckList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return TruckTrailerMappingResultBean;
	}
	@RequestMapping(value = "/trucktrailerId")
	public @ResponseBody Integer truckDetail(@RequestParam Integer truck_trailer_mapping_id) throws CustomException {
		//List<PlanTripBean> PlanTripBean= new ArrayList<PlanTripBean>();
	int	Integer=0;
		try {

			Integer = TruckTrailerMappingService.truckDetail(truck_trailer_mapping_id);

		} catch (Exception e) {
			throw new CustomException();
		}

		return Integer;
	}
/*	@RequestMapping(value = "/trucktrailerdateId")
	public @ResponseBody List<TruckTrailerMappingBean> truckDetail1(@RequestParam Integer truck_trailer_mapping_id) throws CustomException {
		List<TruckTrailerMappingBean> Bean= new ArrayList<TruckTrailerMappingBean>();

		try {

			Bean = TruckTrailerMappingService.truckDetail1(truck_trailer_mapping_id);

		} catch (Exception e) {
			throw new CustomException();
		}

		return Bean;
	}
	@RequestMapping(value = "/truckid", method = RequestMethod.GET)
	public @ResponseBody List<PlanTripBean> truckDetail(@RequestParam Integer truck_id) throws CustomException {
		List<PlanTripBean> PlanTripBean= new ArrayList<PlanTripBean>();
		try {

			PlanTripBean = planTripService.truckDetail(truck_id);

		} catch (Exception e) {
			throw new CustomException();
		}

		return PlanTripBean;
	}
	*/
	
	@RequestMapping(value = "/gettripdate")
	public @ResponseBody TruckTrailerMappingResultBean gettripdate(@RequestBody int rowid) throws CustomException {
		TruckTrailerMappingResultBean objResultBean = new TruckTrailerMappingResultBean();
		TruckTrailerMappingBean objBean = new TruckTrailerMappingBean();

		List<TruckTrailerMappingBean> lPendingInvoice = new ArrayList<TruckTrailerMappingBean>();
		try {
			lPendingInvoice = TruckTrailerMappingService.gettripdate(rowid);

			objResultBean.setLtripDate(lPendingInvoice);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objResultBean;
	}
	
	@RequestMapping(value = "/trailerlist")
	public TruckTrailerMappingResultBean gettrailerList() {
		TruckTrailerMappingResultBean TruckTrailerMappingResultBean = new TruckTrailerMappingResultBean();
		try {
			TruckTrailerMappingResultBean = TruckTrailerMappingService.gettrailerList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return TruckTrailerMappingResultBean;
	}
	@RequestMapping(value = "/list")
	public TruckTrailerMappingResultBean getList() throws CustomException {
		TruckTrailerMappingResultBean TruckTrailerMappingResultBean = new TruckTrailerMappingResultBean();
		try {

			TruckTrailerMappingResultBean.setList(TruckTrailerMappingService.getList());

		} catch (Exception e) {
			LOGGER.error("error"+ e);
			throw new CustomException();
		}

		
		return TruckTrailerMappingResultBean;
	}

@RequestMapping(value = "/save")
	public @ResponseBody Object save(@RequestBody TruckTrailerMappingBean TruckTrailerMapping) throws CustomException  
{
		TruckTrailerMappingResultBean TruckTrailerMappingResultBean = new TruckTrailerMappingResultBean();
		Object isSuccess;
		try {
			isSuccess=TruckTrailerMappingService.insertTruckTrailerMapping(TruckTrailerMapping);
		} catch (Exception e) {
			LOGGER.error("error on TruckTrailerMapping" + e);
			throw new CustomException();
			
		}
		return isSuccess;
	}

	@RequestMapping(value = "/saveFromTrip")
	public @ResponseBody Object saveFromTripAdd(@RequestBody TruckTrailerMappingBean TruckTrailerMapping) throws CustomException  
	{
		TruckTrailerMappingResultBean TruckTrailerMappingResultBean = new TruckTrailerMappingResultBean();
		Object isSuccess;
		try {
			isSuccess=TruckTrailerMappingService.insertTruckTrailerMappingFromTrip(TruckTrailerMapping);
		} catch (Exception e) {
			LOGGER.error("error on TruckTrailerMapping" + e);
			throw new CustomException();
			
		}
		return isSuccess;
	}
		
	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody TruckTrailerMappingBean TruckTrailerMapping) throws CustomException {
		boolean isSuccess = false;
		
		try {
			isSuccess = TruckTrailerMappingService.updateTruckTrailerMapping(TruckTrailerMapping);
			
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	
	
	@RequestMapping("/delete")
	public @ResponseBody boolean delete(@RequestBody int rowid) throws Exception {
		boolean isDeleted = false;
		isDeleted = TruckTrailerMappingService.deleteTruckTrailerMapping(rowid);
;
		return isDeleted;
	}
	
	@RequestMapping("/edit")
	public @ResponseBody TruckTrailerMappingBean  getTruckTrailerMappingById(@RequestBody int rowid) throws CustomException 
	{
		TruckTrailerMappingBean TruckTrailerMapping = new TruckTrailerMappingBean();
		try {
			TruckTrailerMapping = TruckTrailerMappingService.getTruckTrailerMappingById(rowid);
			
		} catch (Exception e) {
			
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return TruckTrailerMapping;
	}
	
	@RequestMapping("/getTruckDltById")
	public @ResponseBody List<SortedMap<String, String>>  getTruckById(@RequestBody TruckTrailerMappingBean param) throws CustomException 
	{
		TruckTrailerMappingResultBean result=new TruckTrailerMappingResultBean();
		List<SortedMap<String, String>> availResult= new ArrayList<SortedMap<String,String>>();
		try {
			result = TruckTrailerMappingService.getSheduleTruckById(param.getTruckId());
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
	
	@RequestMapping("/getTrailerDltById")
	public @ResponseBody List<SortedMap<String, String>>  getTrailerkById(@RequestBody TruckTrailerMappingBean param) throws CustomException 
	{
		TruckTrailerMappingResultBean result=new TruckTrailerMappingResultBean();
		List<SortedMap<String, String>> availResult= new ArrayList<SortedMap<String,String>>();
		try {
			result = TruckTrailerMappingService.getSheduleTrailerById(param.getTrailerId());
			if(result.getList() != null && result.getList().size() > 0){
				availResult = getScheduleMap(result,"2",param.getTrailerName());
				}else{
					availResult =getScheduleEmtyMap("2",param.getTrailerName());
				}
			

		} catch (Exception e) {
			throw new CustomException();
		}

		return availResult;
	}
	
	@RequestMapping("/getTruckTrailMappingId")
	public @ResponseBody TruckTrailerMappingBean  getTruckTrailMappingId(@RequestParam Integer truckId,@RequestParam Integer trilId,@RequestParam String stDt) throws CustomException 
	{
		TruckTrailerMappingBean result = new TruckTrailerMappingBean();
		try {
			 result = TruckTrailerMappingService.getTruckTrailMappingId(truckId,trilId,stDt);
		} catch (Exception e) {
			throw new CustomException();
		}

		return result;
	}
	
	@RequestMapping(value = "/updateFromPlanTrip")
	public @ResponseBody Object updateTruckTrailerMappingFromPlanTrip(@RequestBody TruckTrailerMappingBean TruckTrailerMapping) throws CustomException {
		Object isSuccess = false;
		
		try {
			isSuccess = TruckTrailerMappingService.updateTruckTrailerMappingFromPlanTrip(TruckTrailerMapping);
			
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}
	
	public List<SortedMap<String,String>> getScheduleMap(TruckTrailerMappingResultBean result,String id,String name){
		List<SortedMap<String, String>> availResult = new ArrayList<SortedMap<String,String>>();
		for (TruckTrailerMappingBean itr : result.getList()) {
			SortedMap<String, String> map = new TreeMap<String,String>();
			map.put("id",id);
			map.put("truck",  name.length()> 0 ? name : id.equals("1") ? (itr.getTruckName()) :  (itr.getTrailerName()));
			map.put("truckId", itr.getTruckId().toString());
			map.put("trailerId", itr.getTrailerId().toString());
			map.put("truckName", itr.getTruckName());
			map.put("trailerName", itr.getTrailerName());
			map.put("eventColor", "green");
			map.put("resourceId", id);
			map.put("start", itr.getFromDate());
			map.put("end", itr.getToDate());
			map.put("fromDate", itr.getFromDate());
			map.put("toDate", itr.getToDate());
			map.put("title",  name.length()> 0 ? name : id.equals("1") ? (itr.getTruckName()) :  (itr.getTrailerName()));
			map.put("mtitle",itr.getTruckName());
			map.put("categoryId",itr.getTrucktrailerId().toString());
			availResult.add(map);
		}
	
		return availResult;
		
	}
	
	public List<SortedMap<String,String>> getScheduleEmtyMap(String id,String name){
	 List<SortedMap<String, String>> availResult = new ArrayList<SortedMap<String,String>>();
		SortedMap<String, String> map = new TreeMap<String,String>();
		map.put("id", id);
		map.put("truck", name);
		map.put("truckId", "");
		map.put("trailerId", "");
		map.put("truckName", "");
		map.put("trailerName", "");
		map.put("eventColor", "");
		map.put("resourceId",id);
		map.put("start","");
		map.put("end", "");
		map.put("title", "");
		map.put("mtitle", "");
		map.put("categoryId","");
		availResult.add(map);
		return availResult;
	}

}
