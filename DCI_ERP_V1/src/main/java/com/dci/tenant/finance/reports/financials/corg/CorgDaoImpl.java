package com.dci.tenant.finance.reports.financials.corg;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("tenantTransactionManager")

public class CorgDaoImpl implements CorgDao{

	@Resource
	 private DataSource dataSource;
	
	@Override
	public List<CorgBean> viewCorgReport(CorgBean objCorgBean) {
		List<CorgBean> lCorgList = new ArrayList<CorgBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String sDynamicQuery = "";
			String companyCode = null;
			
			if("C0000".equals(objCorgBean.getCompanyCode()))
				companyCode=null;
			else if("C0001".equals(objCorgBean.getCompanyCode()))
				companyCode=objCorgBean.getCompanyCode();
			else if("C0003".equals(objCorgBean.getCompanyCode()))
				companyCode=objCorgBean.getCompanyCode();
			
			sDynamicQuery = CorgQueryUtil.GET_CORG_LIST;
			if (objCorgBean.getYear() != null && objCorgBean.getYear() != "") {
				sDynamicQuery = sDynamicQuery + " AND YR ='" + objCorgBean.getYear() + "'";
			} 
			if (objCorgBean.getWeek() != null && objCorgBean.getWeek() != ""){
				sDynamicQuery = sDynamicQuery + " AND WK = '" + objCorgBean.getWeek() + "'";
			}

			lCorgList = jdbcTemplate.query(sDynamicQuery,new Object[]{companyCode,Integer.parseInt(objCorgBean.getYear())},
					new BeanPropertyRowMapper<CorgBean>(CorgBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCorgList;
	}

	@Override
	public List<CorgBean> viewCorgReportAsOnDate(CorgBean objCorgBean) {
		List<CorgBean> lCorgList = new ArrayList<CorgBean>();
		try {
			String sDynamicQuery = "";
			String companyCode = null;
			
			if("C0000".equals(objCorgBean.getCompanyCode()))
				companyCode=null;
			else if("C0001".equals(objCorgBean.getCompanyCode()))
				companyCode=objCorgBean.getCompanyCode();
			else if("C0003".equals(objCorgBean.getCompanyCode()))
				companyCode=objCorgBean.getCompanyCode();
			
			sDynamicQuery = CorgQueryUtil.GET_CORG_LIST_AS_ON_DATE;
			
			if (objCorgBean.getYear() != null && objCorgBean.getYear() != "") {
				sDynamicQuery = sDynamicQuery + " AND YR ='" + objCorgBean.getYear() + "'";
			} 
			if (objCorgBean.getWeek() != null && objCorgBean.getWeek() != ""){
				sDynamicQuery = sDynamicQuery + " AND WK = '" + objCorgBean.getWeek() + "'";
			}
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCorgList = jdbcTemplate.query(sDynamicQuery,new Object[]{companyCode,Integer.parseInt(objCorgBean.getYear())},
					new BeanPropertyRowMapper<CorgBean>(CorgBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCorgList;
	}

	@Override
	public String getweekenddate(CorgBean objCorgBean) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sWeekDate="";
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CorgQueryUtil.GET_WEEK_END_DATE, new Object[] { objCorgBean.getWeek(),objCorgBean.getYear() });

			for (Map row : rows) {
				sWeekDate =(String) row.get("endDate");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sWeekDate;
	}

}
