package com.dci.tenant.finance.report.tripPandL;

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

public class TripPandLDAOImpl implements TripPandLDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public TripPandLResultBean getTruckList() {

		TripPandLResultBean resultBean = new TripPandLResultBean();
		List<SelectivityBean> truckList = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			truckList = jdbcTemplate.query(TripPandLQueryUtil.TRUCK_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			resultBean.setTruckList(truckList);
			resultBean.setMessage("success");
		} catch (Exception e1) {
			resultBean.setMessage("failure");
		}

		return resultBean;
	}
	
	@Override
	public TripPandLResultBean getList(TripPandLBean value ){
		TripPandLResultBean resultBean = new TripPandLResultBean();
		List<TripPandLBean> bean = new ArrayList<TripPandLBean>();
		List<TripPandLBean> bean1 = new ArrayList<TripPandLBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			bean = jdbcTemplate.query(TripPandLQueryUtil.LIST, new BeanPropertyRowMapper<TripPandLBean>(TripPandLBean.class), value.getFromDate(), value.getToDate());
			bean1 = jdbcTemplate.query(TripPandLQueryUtil.LIST1, new BeanPropertyRowMapper<TripPandLBean>(TripPandLBean.class), value.getFromDate(), value.getToDate());
			resultBean.setList(bean);
			resultBean.setList1(bean1);
			resultBean.setMessage("success");
		} catch (Exception e1) {
			resultBean.setMessage("failure");
		}

		return resultBean;
	}

	@Override
	public List<TripPandLBean> exportDailyVehicleReport(TripPandLBean dailyVehicleReport,String truck) {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<TripPandLBean> lCDCMainList = new ArrayList<TripPandLBean>();
		
		lCDCMainList = jdbcTemplate.query(TripPandLQueryUtil.DAILY_VEHICLE_REPORT,new Object[] {dailyVehicleReport.getFromDate(),dailyVehicleReport.getToDate(),truck}, new BeanPropertyRowMapper<TripPandLBean>(TripPandLBean.class));
		
		try {

		} catch (DataAccessException e) {
		}
		return lCDCMainList;
	}

	
	@Override
	public TripPandLBean getTruckName(TripPandLBean dailyVehicleReport,String truck) {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		TripPandLBean dailyVehicleBean = new TripPandLBean();

		
		dailyVehicleBean = jdbcTemplate.queryForObject(TripPandLQueryUtil.TRUCK_NAME,new Object[]{truck}, new BeanPropertyRowMapper<TripPandLBean>(TripPandLBean.class) );
		
		try {

		} catch (DataAccessException e) {
		}
		return dailyVehicleBean;
	}

	
	
	
	
	@Override
	public TripPandLBean getIdleHour(String timeStart,String timeEnd){
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		TripPandLBean dailyVehicleBean = new TripPandLBean();

		
		dailyVehicleBean = jdbcTemplate.queryForObject(TripPandLQueryUtil.IDLE_HOUR,new Object[]{timeEnd,timeStart,timeEnd,timeStart}, new BeanPropertyRowMapper<TripPandLBean>(TripPandLBean.class) );
		
		try {

		} catch (DataAccessException e) {
		}
		return dailyVehicleBean;
	}
	
	
	
	
	
	
	
}
