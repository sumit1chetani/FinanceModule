package com.dci.tenant.master.trucktrailermapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.dci.truck.truckdrivermapping.TruckDriverMappingQueryUtil;


@Repository
@Transactional("tenantTransactionManager")
public class TruckTrailerMappingDAOImpl implements TruckTrailerMappingDAO  {
	private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(TruckTrailerMappingDAOImpl.class);

	private static final Integer String = null;

	@Autowired
	UserLogDAO userlogDAO;

	@Autowired
	AuditLogDAO auditLogDAO;
	@Resource
	DataSource dataSource;
	
	

	@Override
	public TruckTrailerMappingResultBean gettruckList() throws CustomException{

		TruckTrailerMappingResultBean resultBean = new TruckTrailerMappingResultBean();
		List<SelectivityBean>  resultList= new ArrayList<SelectivityBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			resultList = jdbcTemplate.query(TruckTrailerMappingQueryUtil.truck, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			resultBean.setTruckList(resultList);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return resultBean;
	}
	@Override
	public Integer truckDetail(Integer truck_trailer_mapping_id) {
		int Integer=0;
		String Date=null;
		TruckTrailerMappingBean truck=new TruckTrailerMappingBean();
		//List<PlanTripBean> planTripBean = new ArrayList<PlanTripBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			//1,192: int count = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.COUNT_USERID, new Object[] { objEmployee.getEmpUserId() }, Integer.class); 
		Integer =    jdbcTemplate.queryForObject(TruckTrailerMappingQueryUtil.Truck_mapping,new Object[] {truck_trailer_mapping_id}, Integer.class);
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		return Integer;

	}
/*	@Override
	public List<TruckTrailerMappingBean> truckDetail1(Integer truck_trailer_mapping_id) {
		int Integer=0;
		String date=null;
		List<TruckTrailerMappingBean> Bean= new ArrayList<TruckTrailerMappingBean>();
		TruckTrailerMappingBean localbean=new TruckTrailerMappingBean();
		//TruckTrailerMappingBean truck=new TruckTrailerMappingBean();
		//List<PlanTripBean> planTrsipBean = new ArrayList<PlanTripBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			//1,192: int count = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.COUNT_USERID, new Object[] { objEmployee.getEmpUserId() }, Integer.class); 
		Integer =    jdbcTemplate.queryForObject(TruckTrailerMappingQueryUtil.Truck_mapping,new Object[] {truck_trailer_mapping_id}, Integer.class);
		if(Integer>0){
			
			 jdbcTemplate.query(PlanTripQueryUtill.Truck_mapping,new BeanPropertyRowMapper<PlanTripBean>(PlanTripBean.class), truck_id);
			Bean= jdbcTemplate.query(TruckTrailerMappingQueryUtil.Truck_mapping1,new BeanPropertyRowMapper<TruckTrailerMappingBean>(TruckTrailerMappingBean.class), truck_trailer_mapping_id);;
for (TruckTrailerMappingBean bean : Bean) {
	bean.getStartDate();
		}
		
		} }catch (Exception e) {
			e.printStackTrace();
		}

	
		return Bean;

	}

	*/
/*	182: int dtlId = jdbcTemplate.queryForObject(BudgetAllocationQueryUtil.CHECK_ALLOCATION, new Object[] { allocationBean.getCompany(), 
			allocationBean.getFinancial_year(), allocationBean.getExpense_type() }, Integer.class); */
	@Override
	public List<TruckTrailerMappingBean> gettripdate(int rowid) {
		List<TruckTrailerMappingBean> ltriplist = new ArrayList<TruckTrailerMappingBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
				ltriplist = jdbcTemplate.query(TruckTrailerMappingQueryUtil.GET_Date_LIST1,
						new Object[] {  rowid},
						new BeanPropertyRowMapper<TruckTrailerMappingBean>(TruckTrailerMappingBean.class));
		} catch (Exception  e) {
			e.printStackTrace();
		}
		return ltriplist;
	}
	
	
	@Override
	public TruckTrailerMappingResultBean gettrailerList() throws CustomException{

		TruckTrailerMappingResultBean resultBean = new TruckTrailerMappingResultBean();
		List<SelectivityBean>  resultList= new ArrayList<SelectivityBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			resultList = jdbcTemplate.query(TruckTrailerMappingQueryUtil.trailer, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			resultBean.setTrailerList(resultList);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return resultBean;
	}


	@Override
	public List<TruckTrailerMappingBean> getList()  {
		List<TruckTrailerMappingBean> List = new ArrayList<TruckTrailerMappingBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			List = jdbcTemplate.query(TruckTrailerMappingQueryUtil.list, new BeanPropertyRowMapper<TruckTrailerMappingBean>(TruckTrailerMappingBean.class));
		
		} catch (Exception e) {
			e.printStackTrace();
		}	return List;
	}
	@Override
	public
	Object insertTruckTrailerMapping(TruckTrailerMappingBean TruckTrailerMapping)throws CustomException{
	
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		TruckTrailerMappingResultBean resultBean = new TruckTrailerMappingResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
Integer save=null;

		try {
			TruckTrailerMapping.setTableName("truck_trailer_mapping");
			TruckTrailerMapping.setFormCode("F5039");
	int count = jdbcTemplate.queryForObject(TruckTrailerMappingQueryUtil.COUNT, Integer.class,TruckTrailerMapping.getFromDate(),TruckTrailerMapping.getToDate(),TruckTrailerMapping.getTruckId(),TruckTrailerMapping.getTrailerId(),TruckTrailerMapping.getFromDate(),TruckTrailerMapping.getToDate());

	if(count==0){
		save=jdbcTemplate.update(TruckTrailerMappingQueryUtil.add, TruckTrailerMapping.getTruckId(),TruckTrailerMapping.getTrailerId(),TruckTrailerMapping.getFromDate(),TruckTrailerMapping.getToDate(),userDetails.getUserId());
		int Id = jdbcTemplate.queryForObject(TruckDriverMappingQueryUtil.SELECT_PREVIOUS_ID,Integer.class);
		
		  userlogDAO.userLogForInsert(TruckTrailerMapping, Id + "", userDetails.getUserId());	
		} 
} catch (Exception e) {

			e.printStackTrace();

		}	
		
		return save;
	
	}

	@Override
	public boolean updateTruckTrailerMapping(TruckTrailerMappingBean TruckTrailerMapping) throws Exception{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Integer manuid = null; 
		boolean issucces = false;
		
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			TruckTrailerMapping.setTableName("truck_trailer_mapping");
			TruckTrailerMapping.setFormCode("F5039");
			int count = jdbcTemplate.queryForObject(TruckTrailerMappingQueryUtil.COUNT1, Integer.class,TruckTrailerMapping.getFromDate(),TruckTrailerMapping.getToDate(),TruckTrailerMapping.getTruckId(),TruckTrailerMapping.getTrucktrailerId(),TruckTrailerMapping.getTrailerId(),TruckTrailerMapping.getFromDate(),TruckTrailerMapping.getToDate(),TruckTrailerMapping.getTrucktrailerId());
		if(count==0){
			TruckTrailerMappingBean oldlocationBean = getTruckTrailerMappingById(TruckTrailerMapping.getTrucktrailerId());

			manuid = jdbcTemplate.update(TruckTrailerMappingQueryUtil.update, new Object[] {TruckTrailerMapping.getTruckId(),TruckTrailerMapping.getTrailerId(),TruckTrailerMapping.getFromDate(),TruckTrailerMapping.getToDate(),userDetails.getUserId(),TruckTrailerMapping.getTrucktrailerId()});

			issucces = true;
			  userlogDAO.userLogForUpdate(oldlocationBean, TruckTrailerMapping, TruckTrailerMapping.getTrucktrailerId() + "", userDetails.getUserId());

			}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return issucces;
	}
	

	@Override
	public boolean deleteTruckTrailerMapping(int rowid) throws Exception {
		
		boolean issucces = false;
		int value= 0;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		TruckTrailerMappingBean TruckTrailerMapping=new TruckTrailerMappingBean(); 
		try{
			TruckTrailerMapping.setTableName("truck_trailer_mapping");
			TruckTrailerMapping.setFormCode("F5039");
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			//  userlogDAO.userLogForDelete(TruckTrailerMapping, rowid + "", userDetails.getUserId());
			TruckTrailerMappingBean oldlocationBean = getTruckTrailerMappingById(rowid);

			value = jdbcTemplate.update(TruckTrailerMappingQueryUtil.delete,rowid);
			UserLog userLog = userlogDAO.userLogForDelete(oldlocationBean, rowid + "", userDetails.getUserId());
			auditLogDAO.auditLogForDelete(oldlocationBean, userLog, null);
			
		/*	UserLog userLog =  userlogDAO.userLogForDelete(TruckTrailerMapping, rowid + "", userDetails.getUserId());

			auditLogDAO.auditLogForDelete(oldlocationBean, userLog, null);*/
			issucces = true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return issucces;
	}

	@Override
	public TruckTrailerMappingBean getTruckTrailerMappingById(int rowid) throws Exception {

		TruckTrailerMappingBean TruckTrailerMapping = new TruckTrailerMappingBean();
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Object[] params = new Object[] { rowid };
			TruckTrailerMapping = jdbcTemplate.queryForObject(TruckTrailerMappingQueryUtil.edit,new Object[]{rowid}, new BeanPropertyRowMapper<TruckTrailerMappingBean>(TruckTrailerMappingBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return TruckTrailerMapping;
	}
	@Override
	public TruckTrailerMappingResultBean getSheduleTruckById(
			Integer truckId ) throws CustomException {
		List<TruckTrailerMappingBean> list = new ArrayList<TruckTrailerMappingBean>();
		TruckTrailerMappingResultBean mappingResultBean = new TruckTrailerMappingResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			String qry = TruckTrailerMappingQueryUtil.SELECT_TRUCK_BY_ID;
			list = jdbcTemplate.query(qry,new BeanPropertyRowMapper<TruckTrailerMappingBean>(
					TruckTrailerMappingBean.class),truckId);
			
		if(list != null && list.size()>0){
			mappingResultBean.setList(list);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mappingResultBean;
	}
	@Override
	public TruckTrailerMappingResultBean getSheduleTrailerById(
			Integer trilId) throws CustomException {
		List<TruckTrailerMappingBean> list = new ArrayList<TruckTrailerMappingBean>();
		TruckTrailerMappingResultBean mappingResultBean = new TruckTrailerMappingResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			String qry = TruckTrailerMappingQueryUtil.SELECT_TRAILER_BY_ID;
			list = jdbcTemplate.query(qry,new BeanPropertyRowMapper<TruckTrailerMappingBean>(
					TruckTrailerMappingBean.class),trilId);
			
		if(list != null && list.size()>0){
			mappingResultBean.setList(list);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mappingResultBean;
	}
		@Override
		public Object insertTruckTrailerMappingFromTrip(
				TruckTrailerMappingBean TruckTrailerMapping) throws CustomException {
		
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				TruckTrailerMappingResultBean resultBean = new TruckTrailerMappingResultBean();
				UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Object save=null;
		
				try {
					TruckTrailerMapping.setTableName("truck_trailer_mapping");
					TruckTrailerMapping.setFormCode("F5039");
			int count = jdbcTemplate.queryForObject(TruckTrailerMappingQueryUtil.COUNT, Integer.class,TruckTrailerMapping.getFromDate(),TruckTrailerMapping.getToDate(),TruckTrailerMapping.getTruckId(),TruckTrailerMapping.getTrailerId(),TruckTrailerMapping.getFromDate(),TruckTrailerMapping.getToDate());
		
			if(count==0){
				save=jdbcTemplate.update(TruckTrailerMappingQueryUtil.add, TruckTrailerMapping.getTruckId(),TruckTrailerMapping.getTrailerId(),TruckTrailerMapping.getFromDate(),TruckTrailerMapping.getToDate(),userDetails.getUserId());
				int Id = jdbcTemplate.queryForObject(TruckDriverMappingQueryUtil.SELECT_PREVIOUS_ID,Integer.class);
				
				  userlogDAO.userLogForInsert(TruckTrailerMapping, Id + "", userDetails.getUserId());	
				}else{
					List<TruckTrailerMappingBean> list = new ArrayList<TruckTrailerMappingBean>();
					String qry = "select truck_trailer_mapping_id as trucktrailerId,truck_id as truckId,trailer_id as trailerNo,to_char(from_date,'dd/mm/yyyy') as fromDate,to_char(to_date,'dd/mm/yyyy') as toDate from truck_trailer_mapping where truck_id= "+TruckTrailerMapping.getTruckId()+" and "+" to_date('"+TruckTrailerMapping.getFromDate()+"','dd/mm/yyyy')"+" >= from_date and "+" to_date('"+TruckTrailerMapping.getFromDate()+"','dd/mm/yyyy')"+" <= to_date";
					list = jdbcTemplate.query(qry,new BeanPropertyRowMapper<TruckTrailerMappingBean>(
							TruckTrailerMappingBean.class));
					if(list != null && list.size() ==1){
						int Id = 0;
						for (TruckTrailerMappingBean truckTrailerMappingBean : list) {
							String frmDt = TruckTrailerMapping.getFromDate();  // Start date
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							Calendar c = Calendar.getInstance();
							c.setTime(sdf.parse(frmDt));
							c.add(Calendar.DATE, -1);  // number of days to add
							frmDt = sdf.format(c.getTime());
							Date toD=new SimpleDateFormat("dd/MM/yyyy").parse(frmDt);  
							Date fD=new SimpleDateFormat("dd/MM/yyyy").parse(truckTrailerMappingBean.getFromDate());
							 if (fD.compareTo(toD) <= 0) {
								 Id = jdbcTemplate.queryForObject("update truck_trailer_mapping set to_date= "+"to_date('"+frmDt+"'"+",'dd/MM/yyyy')"+" where truck_trailer_mapping_id= "+truckTrailerMappingBean.getTrucktrailerId()+" returning truck_trailer_mapping_id",Integer.class);
								 userlogDAO.userLogForInsert(TruckTrailerMapping, Id + "", userDetails.getUserId());
							 }else{
								 save="ERR_DATE";
							 }
							 
						}
						if(Id>0){
							Id = 0;
							save=jdbcTemplate.update(TruckTrailerMappingQueryUtil.add, TruckTrailerMapping.getTruckId(),TruckTrailerMapping.getTrailerId(),TruckTrailerMapping.getFromDate(),TruckTrailerMapping.getToDate(),userDetails.getUserId());
							 Id = jdbcTemplate.queryForObject(TruckDriverMappingQueryUtil.SELECT_PREVIOUS_ID,Integer.class);
						}
					}else{
						String[] elm = new String[list.size()];
						int i=0;
						for (TruckTrailerMappingBean li : list) {
							elm[i]=li.getTruckName()+" "+li.getTrailerNo();
							i++;
						}
						save=elm;
					}
					
				}
		} catch (Exception e) {
		
					e.printStackTrace();
		
				}	
				
				return save;
			
			}
		
		
		
		public Object updateTruckTrailerMappingFromPlanTrip(TruckTrailerMappingBean TruckTrailerMapping) throws Exception{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Integer manuid = null; 
			Object issucces = false;
			
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			try {
				TruckTrailerMapping.setTableName("truck_trailer_mapping");
				TruckTrailerMapping.setFormCode("F5039");
				
				if(TruckTrailerMapping.getTrucktrailerId() != null){
					
					TruckTrailerMappingBean obj = jdbcTemplate.queryForObject(TruckTrailerMappingQueryUtil.SELECT_TRK_TRAILID,new BeanPropertyRowMapper<TruckTrailerMappingBean>(
							TruckTrailerMappingBean.class),TruckTrailerMapping.getTrucktrailerId());
					
					if(obj.getTrailerId().equals(TruckTrailerMapping.getTrailerId())){
						int count = jdbcTemplate.queryForObject(TruckTrailerMappingQueryUtil.COUNT1, Integer.class,TruckTrailerMapping.getFromDate(),TruckTrailerMapping.getToDate(),TruckTrailerMapping.getTruckId(),TruckTrailerMapping.getTrucktrailerId(),TruckTrailerMapping.getTrailerId(),TruckTrailerMapping.getFromDate(),TruckTrailerMapping.getToDate(),TruckTrailerMapping.getTrucktrailerId());
						if(count==0){
							TruckTrailerMappingBean oldlocationBean = getTruckTrailerMappingById(TruckTrailerMapping.getTrucktrailerId());

							manuid = jdbcTemplate.update(TruckTrailerMappingQueryUtil.update, new Object[] {TruckTrailerMapping.getTruckId(),TruckTrailerMapping.getTrailerId(),TruckTrailerMapping.getFromDate(),TruckTrailerMapping.getToDate(),userDetails.getUserId(),TruckTrailerMapping.getTrucktrailerId()});

							issucces = true;
							  userlogDAO.userLogForUpdate(oldlocationBean, TruckTrailerMapping, TruckTrailerMapping.getTrucktrailerId() + "", userDetails.getUserId());

					 }
					}else{
						//delete already allocated trailer
						int value = jdbcTemplate.update("delete from truck_trailer_mapping where truck_trailer_mapping_id="+TruckTrailerMapping.getTrucktrailerId());
						
						//select truck_trailer_mapping_id as trucktrailerId,truck_id as truckId,trailer_id as trailerId from truck_trailer_mapping " + " where trailer_id="+TruckTrailerMapping.getTrailerId()+" and to_date('"+TruckTrailerMapping.getStartDate()+"','dd/mm/yyyy') between from_date and to_date "
						
						int cont = jdbcTemplate.queryForObject("select count(*) from truck_trailer_mapping "
								+ " where trailer_id="+TruckTrailerMapping.getTrailerId()+" and  (from_date  between to_date('"+TruckTrailerMapping.getFromDate()+"','dd/MM/yyyy') and to_date('"+TruckTrailerMapping.getToDate()+"','dd/MM/yyyy') or to_date between to_date('"+TruckTrailerMapping.getFromDate()+"','dd/MM/yyyy') and to_date('"+TruckTrailerMapping.getToDate()+"','dd/MM/yyyy')) ",
																Integer.class);
						if(cont >0){
							if(cont ==1){
								
							TruckTrailerMappingBean ttMap = jdbcTemplate.queryForObject("select truck_trailer_mapping_id as trucktrailerId,truck_id as truckId,trailer_id as trailerId,to_char(to_date,'dd/MM/yyyy') as toDate from truck_trailer_mapping "
									+ " where trailer_id="+TruckTrailerMapping.getTrailerId()+" and (from_date  between to_date('"+TruckTrailerMapping.getFromDate()+"','dd/MM/yyyy') and to_date('"+TruckTrailerMapping.getToDate()+"','dd/MM/yyyy') or to_date between to_date('"+TruckTrailerMapping.getFromDate()+"','dd/MM/yyyy') and to_date('"+TruckTrailerMapping.getToDate()+"','dd/MM/yyyy'))  ",
									new BeanPropertyRowMapper<TruckTrailerMappingBean>(
											TruckTrailerMappingBean.class));
							
							String frmDt = TruckTrailerMapping.getFromDate();  // Start date
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							Calendar c = Calendar.getInstance();
							c.setTime(sdf.parse(frmDt));
							c.add(Calendar.DATE, -1);  // number of days to add
							frmDt = sdf.format(c.getTime());
							Date f=new SimpleDateFormat("dd/MM/yyyy").parse(frmDt);
							Date t=new SimpleDateFormat("dd/MM/yyyy").parse(ttMap.getToDate());
							String to="";
							if (f.compareTo(t) > 0) {
					            t=f;
					            to=sdf.format(t.getTime());
					        }else{
					        	 to=sdf.format(t.getTime());
					        }
								 int Id = jdbcTemplate.queryForObject("update truck_trailer_mapping set to_date= to_date('"+frmDt+"'"+",'dd/MM/yyyy'),from_date=to_date('"+to+"','dd/MM/yyyy') where truck_trailer_mapping_id= "+ttMap.getTrucktrailerId()+" returning truck_trailer_mapping_id",Integer.class);
								 userlogDAO.userLogForInsert(TruckTrailerMapping, Id + "", userDetails.getUserId());
								 issucces = true;
								 
								 int res=jdbcTemplate.update(TruckTrailerMappingQueryUtil.add, TruckTrailerMapping.getTruckId(),TruckTrailerMapping.getTrailerId(),TruckTrailerMapping.getFromDate(),TruckTrailerMapping.getToDate(),userDetails.getUserId());
								 int Id1 = jdbcTemplate.queryForObject(TruckDriverMappingQueryUtil.SELECT_PREVIOUS_ID,Integer.class);
								 
							}else{
								 issucces="MORE THAN ONE TRUCK";
							}
							
						}else{
							int res=jdbcTemplate.update(TruckTrailerMappingQueryUtil.add, TruckTrailerMapping.getTruckId(),TruckTrailerMapping.getTrailerId(),TruckTrailerMapping.getFromDate(),TruckTrailerMapping.getToDate(),userDetails.getUserId());
							 int Id = jdbcTemplate.queryForObject(TruckDriverMappingQueryUtil.SELECT_PREVIOUS_ID,Integer.class);
							 issucces = true;
						}
						
					}
				}
		    
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return issucces;
		}
		@Override
		public TruckTrailerMappingBean getTruckTrailMappingId(Integer truckId,Integer trilId,String stDt) throws CustomException {
			TruckTrailerMappingBean res = new TruckTrailerMappingBean();
			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				res = jdbcTemplate.queryForObject(TruckTrailerMappingQueryUtil.SELECT_TRK_TRAILMAPID,new BeanPropertyRowMapper<TruckTrailerMappingBean>(
						TruckTrailerMappingBean.class),truckId,trilId,stDt,stDt);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return res;
		}

}
