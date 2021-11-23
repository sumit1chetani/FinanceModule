package com.dci.tenant.master.trucktrailermapping;
import java.util.List;

import com.dci.common.util.CustomException;
public interface TruckTrailerMappingDAO {
	
	public TruckTrailerMappingResultBean gettruckList() throws CustomException;

	public TruckTrailerMappingResultBean gettrailerList() throws CustomException;

	List<TruckTrailerMappingBean> getList();
	
	Object insertTruckTrailerMapping(TruckTrailerMappingBean TruckTrailerMapping) throws CustomException;
	Object insertTruckTrailerMappingFromTrip(TruckTrailerMappingBean TruckTrailerMapping) throws CustomException;
	public boolean updateTruckTrailerMapping(TruckTrailerMappingBean TruckTrailerMapping) throws Exception;
	public boolean deleteTruckTrailerMapping(int rowid) throws Exception;
	public Integer truckDetail(Integer truck_trailer_mapping_id);
	//public List<TruckTrailerMappingBean> truckDetail1(Integer truck_trailer_mapping_id);

	public List<TruckTrailerMappingBean> gettripdate(int rowid);
	public  TruckTrailerMappingBean getTruckTrailerMappingById(int rowid) throws Exception;
	
	public TruckTrailerMappingResultBean getSheduleTruckById(Integer trkId) throws CustomException;
	
	public TruckTrailerMappingResultBean getSheduleTrailerById(Integer trilId) throws CustomException;
	
	public TruckTrailerMappingBean getTruckTrailMappingId(Integer truckId,Integer trilId,String stDt) throws CustomException;
	
	public Object updateTruckTrailerMappingFromPlanTrip(TruckTrailerMappingBean TruckTrailerMapping) throws Exception;

}