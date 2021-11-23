package com.dci.truck.truckdrivermapping;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;




@Service
public class TruckDriverMappingServiceImpl implements TruckDriverMappingService  {
	
		@Autowired
			TruckDriverMappingDAO TruckDriverMappingDao;
			
		
			@Override
			public TruckDriverMappingResultBean gettruckList() throws CustomException{
				return TruckDriverMappingDao.gettruckList();
			}
			@Override
			public TruckDriverMappingResultBean getdriverList() throws CustomException{
				return TruckDriverMappingDao.getdriverList();
			}
			
			@Override
			public List<TruckDriverMappingBean> getList()  {
				return TruckDriverMappingDao.getList();
			}
	
			@Override
			public Object insertTruckDriverMapping(TruckDriverMappingBean TruckDriverMapping)throws CustomException{
				return TruckDriverMappingDao.insertTruckDriverMapping(TruckDriverMapping);
			}

			@Override
			public boolean updateTruckDriverMapping(TruckDriverMappingBean TruckDriverMapping) throws Exception{
				return TruckDriverMappingDao.updateTruckDriverMapping(TruckDriverMapping);
			}

			

			@Override
			public boolean deleteTruckDriverMapping(int rowid) throws Exception{
				return TruckDriverMappingDao.deleteTruckDriverMapping(rowid);
			}

			@Override
			public  TruckDriverMappingBean getTruckDriverMappingById(int rowid) throws Exception{
				return TruckDriverMappingDao.getTruckDriverMappingById(rowid);
			}
			@Override
			public boolean checkEdit(Integer driverMappingId) {
				// TODO Auto-generated method stub
				return TruckDriverMappingDao.checkEdit(driverMappingId);
			}
			@Override
			public TruckDriverMappingResultBean getSelectedTruckList(
					Integer truckId, String pDrvId, String sDrvId)
					throws CustomException {
				// TODO Auto-generated method stub
				return TruckDriverMappingDao.getSelectedTruckList(truckId, pDrvId, sDrvId);
			}
			@Override
			public TruckDriverMappingResultBean getSelectedPrimDrvList(
					Integer truckId, String pDrvId, String sDrvId)
					throws CustomException {
				// TODO Auto-generated method stub
				return TruckDriverMappingDao.getSelectedPrimDrvList(truckId, pDrvId, sDrvId);
			}
			@Override
			public TruckDriverMappingResultBean getSelectedSecDrvList(
					Integer truckId, String pDrvId, String sDrvId)
					throws CustomException {
				// TODO Auto-generated method stub
				return TruckDriverMappingDao.getSelectedSecDrvList(truckId, pDrvId, sDrvId);
			}

}
