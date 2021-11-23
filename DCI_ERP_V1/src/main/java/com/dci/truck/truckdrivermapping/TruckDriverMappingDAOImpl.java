package com.dci.truck.truckdrivermapping;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;



@Repository
@Transactional("tenantTransactionManager")
public class TruckDriverMappingDAOImpl implements TruckDriverMappingDAO  {
	private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(TruckDriverMappingDAOImpl.class);

	@Autowired
	UserLogDAO userlogDAO;

	@Autowired
	AuditLogDAO auditLogDAO;
	@Resource
	DataSource dataSource;
	
	

	@Override
	public TruckDriverMappingResultBean gettruckList() throws CustomException{

		TruckDriverMappingResultBean resultBean = new TruckDriverMappingResultBean();
		List<SelectivityBean>  resultList= new ArrayList<SelectivityBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			resultList = jdbcTemplate.query(TruckDriverMappingQueryUtil.truck, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			resultBean.setTruckList(resultList);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return resultBean;
	}
	@Override
	public TruckDriverMappingResultBean getdriverList() throws CustomException{

		TruckDriverMappingResultBean resultBean = new TruckDriverMappingResultBean();
		List<SelectivityBean>  resultList= new ArrayList<SelectivityBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			resultList = jdbcTemplate.query(TruckDriverMappingQueryUtil.driver, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			resultBean.setDriverList(resultList);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return resultBean;
	}


	@Override
	public List<TruckDriverMappingBean> getList()  {
		List<TruckDriverMappingBean> List = new ArrayList<TruckDriverMappingBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			List = jdbcTemplate.query(TruckDriverMappingQueryUtil.list, new BeanPropertyRowMapper<TruckDriverMappingBean>(TruckDriverMappingBean.class));
		
		} catch (Exception e) {
			e.printStackTrace();
		}	return List;
	}
	@Override
	public
	Object insertTruckDriverMapping(TruckDriverMappingBean TruckDriverMapping)throws CustomException{
	
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
Integer save=null;
int count2 =0;
int count1 =0;
int count =0;

		try {
			TruckDriverMapping.setTableName("truck_driver_mapping");
			TruckDriverMapping.setFormCode("F5045");
			 count = jdbcTemplate.queryForObject(TruckDriverMappingQueryUtil.COUNT6, Integer.class,TruckDriverMapping.getFromDate(),TruckDriverMapping.getToDate(),TruckDriverMapping.getTruckId());
		
				count1= jdbcTemplate.queryForObject(TruckDriverMappingQueryUtil.COUNT7, Integer.class,TruckDriverMapping.getDriverId(),TruckDriverMapping.getFromDate(),TruckDriverMapping.getToDate(),TruckDriverMapping.getDriverId(),TruckDriverMapping.getFromDate(),TruckDriverMapping.getToDate());
				count2= jdbcTemplate.queryForObject(TruckDriverMappingQueryUtil.COUNT8, Integer.class,TruckDriverMapping.getSdriverId(),TruckDriverMapping.getFromDate(),TruckDriverMapping.getToDate(),TruckDriverMapping.getSdriverId(),TruckDriverMapping.getFromDate(),TruckDriverMapping.getToDate());

			/* if(TruckDriverMapping.getSdriverId() != null && TruckDriverMapping.getSdriverId() != ""){
				count1= jdbcTemplate.queryForObject(TruckDriverMappingQueryUtil.COUNT7, Integer.class,TruckDriverMapping.getFromDate(),TruckDriverMapping.getToDate(),TruckDriverMapping.getSdriverId(),TruckDriverMapping.getDriverId(),TruckDriverMapping.getFromDate(),TruckDriverMapping.getToDate());
		
			
			}
	*/
			if(TruckDriverMapping.getSdriverId() == null || TruckDriverMapping.getSdriverId()=="" || TruckDriverMapping.getSdriverId().equalsIgnoreCase("") || TruckDriverMapping.getSdriverId().equalsIgnoreCase(null)) 
			{
	if((count==0)&&(count1==0))
			{

		save=jdbcTemplate.update(TruckDriverMappingQueryUtil.add, TruckDriverMapping.getTruckId(),TruckDriverMapping.getDriverId(),TruckDriverMapping.getFromDate(),TruckDriverMapping.getToDate(),TruckDriverMapping.getSdriverId(),userDetails.getUserId());
int Id = jdbcTemplate.queryForObject(TruckDriverMappingQueryUtil.SELECT_PREVIOUS_ID,Integer.class);
		
		  userlogDAO.userLogForInsert(TruckDriverMapping, Id + "", userDetails.getUserId());	
		} }
			else{
				if(count==0 && count1==0 && count2==0){

						save=jdbcTemplate.update(TruckDriverMappingQueryUtil.add,TruckDriverMapping.getTruckId(),TruckDriverMapping.getDriverId(),TruckDriverMapping.getFromDate(),TruckDriverMapping.getToDate(),TruckDriverMapping.getSdriverId(),userDetails.getUserId());
				}int Id = jdbcTemplate.queryForObject(TruckDriverMappingQueryUtil.SELECT_PREVIOUS_ID,Integer.class);
						
						  userlogDAO.userLogForInsert(TruckDriverMapping, Id + "", userDetails.getUserId());	
						}
		
			}
 catch (Exception e) {

			e.printStackTrace();

		}	
		
		return save;
	
	}

	@Override
	public boolean updateTruckDriverMapping(TruckDriverMappingBean TruckDriverMapping) throws Exception{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Integer manuid = null; 
		boolean issucces = false;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int count6 =0;
		int count =0;
		int count1 =0;


		try {
			TruckDriverMapping.setTableName("truck_driver_mapping");
			TruckDriverMapping.setFormCode("F5045");
/*			select count(*) from truck_driver_mapping where (from_date,to_date) overlaps (to_date(?,'dd/mm/yyyy')-interval '1' day,to_date(?,'dd/mm/yyyy')+interval '1' day) and truck_id=? and emp_id=? and truck_driver_mapping_id<>?::int
*/		
			 count = jdbcTemplate.queryForObject(TruckDriverMappingQueryUtil.COUNT0, Integer.class,TruckDriverMapping.getFromDate(),TruckDriverMapping.getToDate(),TruckDriverMapping.getTruckId(),TruckDriverMapping.getTruckdriverId());
			 count1 = jdbcTemplate.queryForObject(TruckDriverMappingQueryUtil.COUNT1, Integer.class,TruckDriverMapping.getDriverId(),TruckDriverMapping.getFromDate(),TruckDriverMapping.getToDate(),TruckDriverMapping.getTruckdriverId(),TruckDriverMapping.getDriverId(),TruckDriverMapping.getFromDate(),TruckDriverMapping.getToDate(),TruckDriverMapping.getTruckdriverId());
			 count6= jdbcTemplate.queryForObject(TruckDriverMappingQueryUtil.COUNT2, Integer.class,TruckDriverMapping.getSdriverId(),TruckDriverMapping.getFromDate(),TruckDriverMapping.getToDate(),TruckDriverMapping.getTruckdriverId(),TruckDriverMapping.getSdriverId(),TruckDriverMapping.getFromDate(),TruckDriverMapping.getToDate(),TruckDriverMapping.getTruckdriverId());

			/* if(TruckDriverMapping.getSdriverId() != null  && TruckDriverMapping.getSdriverId() != "" ){
				
			 count6 = jdbcTemplate.queryForObject(TruckDriverMappingQueryUtil.COUNT1, Integer.class,TruckDriverMapping.getFromDate(),TruckDriverMapping.getToDate(),TruckDriverMapping.getTruckId(),TruckDriverMapping.getTruckdriverId(),TruckDriverMapping.getSdriverId(),TruckDriverMapping.getDriverId(),TruckDriverMapping.getToDate(),TruckDriverMapping.getToDate(),TruckDriverMapping.getTruckdriverId());
			}*/
			if(TruckDriverMapping.getSdriverId() == null || TruckDriverMapping.getSdriverId() =="" || TruckDriverMapping.getSdriverId().equalsIgnoreCase("") || TruckDriverMapping.getSdriverId().equalsIgnoreCase(null)) {

			if((count==0)&&(count1==0)){
			TruckDriverMappingBean oldlocationBean = getTruckDriverMappingById(TruckDriverMapping.getTruckdriverId());

		
			manuid = jdbcTemplate.update(TruckDriverMappingQueryUtil.update, new Object[] {TruckDriverMapping.getTruckId(),TruckDriverMapping.getDriverId(),TruckDriverMapping.getFromDate(),TruckDriverMapping.getToDate(),TruckDriverMapping.getSdriverId(),userDetails.getUserId(),TruckDriverMapping.getTruckdriverId()});

			issucces = true;
			  userlogDAO.userLogForUpdate(oldlocationBean, TruckDriverMapping, TruckDriverMapping.getTruckdriverId() + "", userDetails.getUserId());

			}}else{
				if((count==0)&&(count1==0)&&(count6==0)){
					TruckDriverMappingBean oldlocationBean = getTruckDriverMappingById(TruckDriverMapping.getTruckdriverId());

					
					manuid = jdbcTemplate.update(TruckDriverMappingQueryUtil.update, new Object[] {TruckDriverMapping.getTruckId(),TruckDriverMapping.getDriverId(),TruckDriverMapping.getFromDate(),TruckDriverMapping.getToDate(),TruckDriverMapping.getSdriverId(),userDetails.getUserId(),TruckDriverMapping.getTruckdriverId()});

					issucces = true;
					  userlogDAO.userLogForUpdate(oldlocationBean, TruckDriverMapping, TruckDriverMapping.getTruckdriverId() + "", userDetails.getUserId());
				}
					
				
			}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return issucces;
	}

	


	@Override
	public boolean deleteTruckDriverMapping(int rowid) throws Exception {
		
		boolean issucces = false;
		int value= 0;
		TruckDriverMappingBean TruckDriverMapping =new TruckDriverMappingBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try{
			TruckDriverMapping.setTableName("truck_driver_mapping");
			TruckDriverMapping.setFormCode("F5045");
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			//  userlogDAO.userLogForDelete(TruckDriverMapping, rowid + "", userDetails.getUserId());
			TruckDriverMappingBean oldlocationBean = getTruckDriverMappingById(rowid);

			value = jdbcTemplate.update(TruckDriverMappingQueryUtil.delete,rowid);
			UserLog userLog = userlogDAO.userLogForDelete(oldlocationBean, rowid + "", userDetails.getUserId());
			auditLogDAO.auditLogForDelete(oldlocationBean, userLog, null);
			issucces = true;

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return issucces;
	}

	@Override
	public TruckDriverMappingBean getTruckDriverMappingById(int rowid) throws Exception {

		TruckDriverMappingBean TruckDriverMapping = new TruckDriverMappingBean();
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Object[] params = new Object[] { rowid };
			TruckDriverMapping = jdbcTemplate.queryForObject(TruckDriverMappingQueryUtil.edit,new Object[]{rowid}, new BeanPropertyRowMapper<TruckDriverMappingBean>(TruckDriverMappingBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return TruckDriverMapping;
	}
	
	@Override
	public boolean checkEdit(Integer driverMappingId) {
		Integer value = null;
		List<Integer> tripIds= new ArrayList<Integer>();
		boolean issucess = false;
		Integer count=0;
		Integer count1=0;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			value = jdbcTemplate.queryForObject(TruckDriverMappingQueryUtil.Check_Trip_Started_Or_Not, Integer.class,driverMappingId);
			if (value > 0) {
				issucess=true;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return issucess;
	}
	@Override
	public TruckDriverMappingResultBean getSelectedTruckList(Integer truckId,
			String pDrvId, String sDrvId) throws CustomException {
		List<TruckDriverMappingBean> list = new ArrayList<TruckDriverMappingBean>();
		TruckDriverMappingResultBean mappingResultBean = new TruckDriverMappingResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			String qry = TruckDriverMappingQueryUtil.SELECT_SELECTED_TRUK_DTL;
			list = jdbcTemplate.query(qry,new BeanPropertyRowMapper<TruckDriverMappingBean>(
					TruckDriverMappingBean.class),truckId);
			
		if(list != null && list.size()>0){
			mappingResultBean.setList(list);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mappingResultBean;
	}
	@Override
	public TruckDriverMappingResultBean getSelectedPrimDrvList(Integer truckId,
			String pDrvId, String sDrvId) throws CustomException {
		List<TruckDriverMappingBean> list = new ArrayList<TruckDriverMappingBean>();
		TruckDriverMappingResultBean mappingResultBean = new TruckDriverMappingResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			String qry = TruckDriverMappingQueryUtil.SELECT_SELECTED_PRMDRIVER_DTL;
			list = jdbcTemplate.query(qry,new BeanPropertyRowMapper<TruckDriverMappingBean>(
					TruckDriverMappingBean.class),pDrvId,pDrvId);
			
		if(list != null && list.size()>0){
			mappingResultBean.setList(list);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mappingResultBean;
	}
	@Override
	public TruckDriverMappingResultBean getSelectedSecDrvList(Integer truckId,
			String pDrvId, String sDrvId) throws CustomException {
		List<TruckDriverMappingBean> list = new ArrayList<TruckDriverMappingBean>();
		TruckDriverMappingResultBean mappingResultBean = new TruckDriverMappingResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			String qry = TruckDriverMappingQueryUtil.SELECT_SELECTED_SECDRIVER_DTL;
			list = jdbcTemplate.query(qry,new BeanPropertyRowMapper<TruckDriverMappingBean>(
					TruckDriverMappingBean.class),sDrvId,sDrvId);
			
		if(list != null && list.size()>0){
			mappingResultBean.setList(list);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mappingResultBean;
	}

}
