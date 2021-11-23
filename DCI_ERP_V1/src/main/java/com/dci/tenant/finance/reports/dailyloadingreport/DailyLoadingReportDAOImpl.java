package com.dci.tenant.finance.reports.dailyloadingreport;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")
public class DailyLoadingReportDAOImpl implements DailyLoadingReportDAO{

	private final static Logger LOGGER = LoggerFactory.getLogger(DailyLoadingReportDAOImpl.class);
	

	@Resource
	 private DataSource dataSource;
	
	@Autowired
	private DailyLoadingReportService objChqDepoCollectionService;
	
	
	
	@Override
	public DailyLoadingReportResultBean getDropDown() {

		DailyLoadingReportResultBean resultBean = new DailyLoadingReportResultBean();
		List<SelectivityBean> monthList = new ArrayList<SelectivityBean>();
		List<SelectivityBean> yearList = new ArrayList<SelectivityBean>();

		
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			monthList = jdbcTemplate.query(DailyLoadingReportQueryUtil.MONTH_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			resultBean.setMonthList(monthList);
			
			yearList = jdbcTemplate.query(DailyLoadingReportQueryUtil.YEAR_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			resultBean.setYearList(yearList);
			
			resultBean.setMessage("success");
		} catch (Exception e1) {
			resultBean.setMessage("failure");
		}

		return resultBean;
	}
	
	
	
	@Override
	public DailyLoadingReportResultBean getViewReport(DailyLoadingReportBean dailyloadingReportBean) {

		DailyLoadingReportResultBean resultBean = new DailyLoadingReportResultBean();

		List<DailyLoadingReportBean> reportList = new ArrayList<DailyLoadingReportBean>();

		
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			reportList = jdbcTemplate.query(DailyLoadingReportQueryUtil.DAILY_LOADING_REPORT, new Object [] {dailyloadingReportBean.getMonth(),dailyloadingReportBean.getYear(),dailyloadingReportBean.getMonth(),dailyloadingReportBean.getYear()},new BeanPropertyRowMapper<DailyLoadingReportBean>(DailyLoadingReportBean.class));
			resultBean.setDailyLoadingReportList(reportList);
			
			resultBean.setMessage("success");
		} catch (Exception e1) {
			resultBean.setMessage("failure");
		}

		return resultBean;
	}
	

	
	
	
	

	@Override
	public List<DailyLoadingReportBean> exportDailyLoadinReport(DailyLoadingReportBean dailyloadingReportBean) {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		
		List<DailyLoadingReportBean> lCDCMainList = new ArrayList<DailyLoadingReportBean>();
		
		lCDCMainList = jdbcTemplate.query(DailyLoadingReportQueryUtil.DAILY_LOADING_REPORT, new Object [] {dailyloadingReportBean.getMonth(),dailyloadingReportBean.getYear(),dailyloadingReportBean.getMonth(),dailyloadingReportBean.getYear()},new BeanPropertyRowMapper<DailyLoadingReportBean>(DailyLoadingReportBean.class));
		
		try {

		} catch (DataAccessException e) {
		}
		return lCDCMainList;
	}



	@Override
	public String getDeptCode() {
		
		
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			String deptCode = jdbcTemplate.queryForObject(DailyLoadingReportQueryUtil.GET_DEPT_CODE,new Object[] {userDetails.getUserId()},String.class);
		
		return deptCode;
	}
	

}

	
