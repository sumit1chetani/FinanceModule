package com.dci.tenant.master.trucktrailermapping;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;


@Service
public class TruckTrailerMappingServiceImpl implements TruckTrailerMappingService  {
	
		@Autowired
			TruckTrailerMappingDAO TruckTrailerMappingDao;
			
		
			@Override
			public TruckTrailerMappingResultBean gettruckList() throws CustomException{
				return TruckTrailerMappingDao.gettruckList();
			}
			@Override
			public TruckTrailerMappingResultBean gettrailerList() throws CustomException{
				return TruckTrailerMappingDao.gettrailerList();
			}
			
			@Override
			public List<TruckTrailerMappingBean> getList()  {
				return TruckTrailerMappingDao.getList();
			}
		
			@Override
			public Object insertTruckTrailerMapping(TruckTrailerMappingBean TruckTrailerMapping)throws CustomException{
				return TruckTrailerMappingDao.insertTruckTrailerMapping(TruckTrailerMapping);
			}
			
			@Override
			public Integer truckDetail(Integer truck_trailer_mapping_id) {
				
				return TruckTrailerMappingDao.truckDetail(truck_trailer_mapping_id);
			}
			/*@Override
			public List<TruckTrailerMappingBean> truckDetail1(Integer truck_trailer_mapping_id) {
				
				return TruckTrailerMappingDao.truckDetail1(truck_trailer_mapping_id);
			}*/
			//public List<TruckTrailerMappingBean> gettripdate(int rowid);
			
			
			@Override
			public boolean updateTruckTrailerMapping(TruckTrailerMappingBean TruckTrailerMapping) throws Exception{
				return TruckTrailerMappingDao.updateTruckTrailerMapping(TruckTrailerMapping);
			}
			@Override
			public List<TruckTrailerMappingBean> gettripdate(int rowid) {
				return TruckTrailerMappingDao.gettripdate(rowid);
			}
			

			@Override
			public boolean deleteTruckTrailerMapping(int rowid) throws Exception{
				return TruckTrailerMappingDao.deleteTruckTrailerMapping(rowid);
			}

			@Override
			public  TruckTrailerMappingBean getTruckTrailerMappingById(int rowid) throws Exception{
				return TruckTrailerMappingDao.getTruckTrailerMappingById(rowid);
			}
			@Override
			public TruckTrailerMappingResultBean getSheduleTruckById(
					Integer trkId )
					throws CustomException {
				// TODO Auto-generated method stub
				return TruckTrailerMappingDao.getSheduleTruckById(trkId);
			}
			@Override
			public TruckTrailerMappingResultBean getSheduleTrailerById(
					Integer trilId)
					throws CustomException {
				// TODO Auto-generated method stub
				return TruckTrailerMappingDao.getSheduleTrailerById(trilId);
			}
			@Override
			public Object insertTruckTrailerMappingFromTrip(
					TruckTrailerMappingBean TruckTrailerMapping)
					throws CustomException {
				// TODO Auto-generated method stub
				return TruckTrailerMappingDao.insertTruckTrailerMappingFromTrip(TruckTrailerMapping);
			}
			@Override
			public TruckTrailerMappingBean getTruckTrailMappingId(
					Integer truckId,Integer trilId,String stDt) throws CustomException {
				// TODO Auto-generated method stub
				return TruckTrailerMappingDao.getTruckTrailMappingId(truckId,trilId,stDt);
			}
			@Override
			public Object updateTruckTrailerMappingFromPlanTrip(
					TruckTrailerMappingBean TruckTrailerMapping)
					throws Exception {
				// TODO Auto-generated method stub
				return TruckTrailerMappingDao.updateTruckTrailerMappingFromPlanTrip(TruckTrailerMapping);
			}

}
