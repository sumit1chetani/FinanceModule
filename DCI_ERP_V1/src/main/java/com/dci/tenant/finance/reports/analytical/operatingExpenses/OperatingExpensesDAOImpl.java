package com.dci.tenant.finance.reports.analytical.operatingExpenses;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")
public class OperatingExpensesDAOImpl implements OperatingExpensesDAO {
	@Resource
	 private DataSource dataSource;

/*	@Override
	public List<SelectivityBean> getVesselList(OperatingExpensesBean expensesBean) {
		List<SelectivityBean> vesselList = new ArrayList<SelectivityBean>();
		try {
			  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			vesselList = jdbcTemplate.query(OperatingExpensesQueryUtil.GET_VESSEL_LIST,
					new Object[] { expensesBean.getFormCode(), expensesBean.getUserId() }, new BeanPropertyRowMapper<SelectivityBean>(
							SelectivityBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vesselList;
	}*/

	@Override
	public List<SelectivityBean> setVoyageList(OperatingExpensesBean expensesBean) {
		List<SelectivityBean> voyageList = new ArrayList<SelectivityBean>();
		try {
			  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			voyageList = jdbcTemplate.query(OperatingExpensesQueryUtil.GET_trip_LIST,new Object[] { expensesBean.getFormCode(), expensesBean.getUserId() }, new BeanPropertyRowMapper<SelectivityBean>(
					SelectivityBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return voyageList;
	}

/*	@Override
	public List<SelectivityBean> getServiceList(OperatingExpensesBean expensesBean) {
		List<SelectivityBean> serviceList = new ArrayList<SelectivityBean>();
		try {
			  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			serviceList = jdbcTemplate.query(OperatingExpensesQueryUtil.GET_SERVICE_LIST, new Object[] { expensesBean.getFormCode(), expensesBean.getUserId() },
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceList;
	}*/

	@Override
	public List<SelectivityBean> getAccoundHeadList(OperatingExpensesBean expensesBean) {
		List<SelectivityBean> accountHeadList = new ArrayList<SelectivityBean>();
		try {
			  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			accountHeadList = jdbcTemplate.query(OperatingExpensesQueryUtil.SELECT_ACCOUNT_HEAD_LIST, new BeanPropertyRowMapper<SelectivityBean>(
					SelectivityBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accountHeadList;
	}

	@Override
	public List<SelectivityBean> getLocationList(){
		// TODO Auto-generated method stub
		List<SelectivityBean> locationList = new ArrayList<SelectivityBean>();
		String sql="";
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try{
			  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	
				sql=OperatingExpensesQueryUtil.SELECT_LOCATION_LIST;
			
			locationList=jdbcTemplate.query(sql,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
		}catch(Exception e){
			e.printStackTrace();
		}
		return locationList;
	}
	
	@Override
	public List<SelectivityBean> getLocationList1( String brnch){
		// TODO Auto-generated method stub
		List<SelectivityBean> locationList = new ArrayList<SelectivityBean>();
		String sql="";
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try{
			  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		if(brnch.equalsIgnoreCase("1")){
            String sql1=OperatingExpensesQueryUtil.SELECT_LOCATION_LIST1;
			
			locationList=jdbcTemplate.query(sql1,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
		}else if(brnch.equalsIgnoreCase("2")){
               sql=OperatingExpensesQueryUtil.SELECT_LOCATION_LIST;
			
			locationList=jdbcTemplate.query(sql,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
		}
				/*sql=OperatingExpensesQueryUtil.SELECT_LOCATION_LIST;
			
			locationList=jdbcTemplate.query(sql,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));*/
		}catch(Exception e){
			e.printStackTrace();
		}
		return locationList;
	}
	/*public List<SelectivityBean> getLocationList() throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<SelectivityBean> locationList = null;
		try {
			locationList = jdbcTemplate.query(
					OperatingExpensesQueryUtil.SELECT_LOCATION_LIST,
					new BeanPropertyRowMapper<SelectivityBean>(
							SelectivityBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locationList;
	}*/
	@Override
	public synchronized List<OperatingExpensesBean> getMainReport(OperatingExpensesBean expensesBean) {
		List<OperatingExpensesBean> mainReport = new ArrayList<OperatingExpensesBean>();
		try {
			  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			mainReport = jdbcTemplate.query(OperatingExpensesQueryUtil.GET_MAIN_REPORT(expensesBean),
					new BeanPropertyRowMapper<OperatingExpensesBean>(OperatingExpensesBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mainReport;
	}

	@Override
	public synchronized List<OperatingExpensesBean> getSubReport(OperatingExpensesBean expensesBean) {
		List<OperatingExpensesBean> subReport = new ArrayList<OperatingExpensesBean>();
		try {
			  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			subReport = jdbcTemplate.query(OperatingExpensesQueryUtil.GET_SUB_REPORT(expensesBean), new BeanPropertyRowMapper<OperatingExpensesBean>(
					OperatingExpensesBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subReport;
	}

	@Override
	public List<SelectivityBean> getCompanyList(OperatingExpensesBean expensesBean) {
		List<SelectivityBean> companyList = new ArrayList<SelectivityBean>();
		try {
			  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			companyList = jdbcTemplate.query(OperatingExpensesQueryUtil.GET_COMPANY_LIST, new BeanPropertyRowMapper<SelectivityBean>(
					SelectivityBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companyList;
	}
	@Override
	public List<SelectivityBean> getVesselList(OperatingExpensesBean expensesBean) {
		List<SelectivityBean> vesselList = new ArrayList<SelectivityBean>();
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			vesselList = jdbcTemplate.query(OperatingExpensesQueryUtil.GET_TRUCK_LIST,
					new Object[] { expensesBean.getFormCode(), expensesBean.getUserId() }, new BeanPropertyRowMapper<SelectivityBean>(
							SelectivityBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vesselList;
	}
	@Override
	public List<SelectivityBean> getGroupHeadList() {
		// TODO Auto-generated method stub
		List<SelectivityBean> groupHeadList = new ArrayList<SelectivityBean>();String sql="";
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try{
			  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(userDetails.getCompanyCode().equalsIgnoreCase("C0001")){
				sql=OperatingExpensesQueryUtil.SELECT_GRP_LIST_FOR_DUBAI;
			}else{
				sql=OperatingExpensesQueryUtil.SELECT_GRP_LIST;
			}
		groupHeadList=jdbcTemplate.query(sql,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
		}catch(Exception e){
			e.printStackTrace();
		}
		return groupHeadList;
	}
}
