package com.dci.truck.truckdrivermapping;
import java.util.List;

import com.dci.common.util.CustomException;

public interface TruckDriverMappingDAO {
	
	public TruckDriverMappingResultBean gettruckList() throws CustomException;

	public TruckDriverMappingResultBean getdriverList() throws CustomException;
	

	List<TruckDriverMappingBean> getList();
	public TruckDriverMappingResultBean getSelectedTruckList(Integer truckId,String pDrvId,String sDrvId) throws CustomException;
	public TruckDriverMappingResultBean getSelectedPrimDrvList(Integer truckId,String pDrvId,String sDrvId) throws CustomException;
	public TruckDriverMappingResultBean getSelectedSecDrvList(Integer truckId,String pDrvId,String sDrvId) throws CustomException;

	Object insertTruckDriverMapping(TruckDriverMappingBean TruckDriverMapping) throws CustomException;
	public boolean updateTruckDriverMapping(TruckDriverMappingBean TruckDriverMapping) throws Exception;
	public boolean deleteTruckDriverMapping(int rowid) throws Exception;

	public  TruckDriverMappingBean getTruckDriverMappingById(int rowid) throws Exception;

	boolean checkEdit(Integer driverMappingId);


}