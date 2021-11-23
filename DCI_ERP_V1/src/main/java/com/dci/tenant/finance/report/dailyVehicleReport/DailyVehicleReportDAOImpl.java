package com.dci.tenant.finance.report.dailyVehicleReport;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;

@Repository
@Transactional("tenantTransactionManager")

public class DailyVehicleReportDAOImpl implements DailyVehicleReportDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public DailyVehicleReportResultBean getTruckList() {

		DailyVehicleReportResultBean resultBean = new DailyVehicleReportResultBean();
		List<SelectivityBean> truckList = new ArrayList<SelectivityBean>();
		List<SelectivityBean> tripList = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			
			truckList = jdbcTemplate.query(DailyVehicleReportQueryUtil.TRUCK_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			tripList = jdbcTemplate.query(DailyVehicleReportQueryUtil.TRIP_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

			resultBean.setTruckList(truckList);
			
			resultBean.setTripList(tripList);
			
			resultBean.setMessage("success");
		} catch (Exception e1) {
			resultBean.setMessage("failure");
		}

		return resultBean;
	}
	
	
	
	@Override
	public DailyVehicleReportResultBean getTruckByTrip(Integer tripId) {

		DailyVehicleReportResultBean resultBean = new DailyVehicleReportResultBean()
		;
		List<SelectivityBean> truckByTrip = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			
			truckByTrip = jdbcTemplate.query(DailyVehicleReportQueryUtil.TRUCK_LIST_BY_TRIP,new Object[] {tripId}, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			
			resultBean.setTruckByTrip(truckByTrip);
			
			resultBean.setMessage("success");
		} catch (Exception e1) {
			resultBean.setMessage("failure");
		}

		return resultBean;
	}
	
	
	
	
	
	@Override
	public List<DailyVehicleReportBean> exportDailyVehicleReport(DailyVehicleReportBean dailyVehicleReport,String truck) {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<DailyVehicleReportBean> lCDCMainList = new ArrayList<DailyVehicleReportBean>();
		
		
		if(dailyVehicleReport.getTripId()==null){
			
			lCDCMainList = jdbcTemplate.query(DailyVehicleReportQueryUtil.DAILY_VEHICLE_REPORT,new Object[] {dailyVehicleReport.getFromDate(),dailyVehicleReport.getToDate(),truck}, new BeanPropertyRowMapper<DailyVehicleReportBean>(DailyVehicleReportBean.class));
		}
		else{
			
			lCDCMainList = jdbcTemplate.query(DailyVehicleReportQueryUtil.DAILY_VEHICLE_REPORT_BY_TRIP,new Object[] {dailyVehicleReport.getFromDate(),dailyVehicleReport.getToDate(),truck,dailyVehicleReport.getTripId()}, new BeanPropertyRowMapper<DailyVehicleReportBean>(DailyVehicleReportBean.class));
		}
		
		try {

		} catch (DataAccessException e) {
		}
		return lCDCMainList;
	}

	
	@Override
	public DailyVehicleReportBean getTruckName(DailyVehicleReportBean dailyVehicleReport,String truck) {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		DailyVehicleReportBean dailyVehicleBean = new DailyVehicleReportBean();

		
		dailyVehicleBean = jdbcTemplate.queryForObject(DailyVehicleReportQueryUtil.TRUCK_NAME,new Object[]{truck}, new BeanPropertyRowMapper<DailyVehicleReportBean>(DailyVehicleReportBean.class) );
		
		try {

		} catch (DataAccessException e) {
		}
		return dailyVehicleBean;
	}

	
	
	
	
	@Override
	public DailyVehicleReportBean getIdleHour(String timeStart,String timeEnd){
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		DailyVehicleReportBean dailyVehicleBean = new DailyVehicleReportBean();

		
		dailyVehicleBean = jdbcTemplate.queryForObject(DailyVehicleReportQueryUtil.IDLE_HOUR,new Object[]{timeEnd,timeStart,timeEnd,timeStart}, new BeanPropertyRowMapper<DailyVehicleReportBean>(DailyVehicleReportBean.class) );
		
		try {

		} catch (DataAccessException e) {
		}
		return dailyVehicleBean;
	}
	
	
	
	
	
	
	
}
