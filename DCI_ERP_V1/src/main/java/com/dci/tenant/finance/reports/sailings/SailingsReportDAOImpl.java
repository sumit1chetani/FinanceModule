package com.dci.tenant.finance.reports.sailings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CodeStandardMsgUtil;
import com.dci.common.util.CustomException;

@Repository
@Transactional("tenantTransactionManager")
public class SailingsReportDAOImpl implements SailingsReportDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(SailingsReportDAOImpl.class);
	/*
	 * @Autowired DataSource dataSource;
	 * 
	 * @Autowired JdbcTemplate jdbcTemplate;
	 */
	@Resource
	 private DataSource dataSource;

	@Override
	public List<SelectivityBean> getCompanyList() {
		List<SelectivityBean> companyList = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<SelectivityBean> companyList1 = new ArrayList<SelectivityBean>();
			List<SelectivityBean> companyList2 = new ArrayList<SelectivityBean>();
			SelectivityBean selObj = new SelectivityBean();
			selObj.setId("C0000");
			selObj.setText("ALL");
			companyList1.add(selObj);
			companyList2 = jdbcTemplate.query(SailingsReportQueryUtil.GET_COMPANY_LIST, new BeanPropertyRowMapper<SelectivityBean>(
					SelectivityBean.class));
			companyList.addAll(companyList1);
			companyList.addAll(companyList2);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return companyList;
	}

	@Override
	public List<SailingsReportBean> getSailingsReport(SailingsReportBean sailingsReportBean) {
		List<SailingsReportBean> sailingsReportBeanList = new ArrayList<SailingsReportBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			System.out.println("company :" + sailingsReportBean.getCompanyCode());
			System.out.println("from dt :" + sailingsReportBean.getFromDate());
			System.out.println("to dt :" + sailingsReportBean.getToDate());
			System.out.println("week :" + sailingsReportBean.getWeek());
			String sailingCont = "";
			if (sailingsReportBean.getCompanyCode() != null && !sailingsReportBean.getCompanyCode().isEmpty()
					&& !sailingsReportBean.getCompanyCode().equals("C0000")) {
				sailingCont = sailingCont + " LOADING.COMPANY_CODE='" + sailingsReportBean.getCompanyCode() + "' and ";
			}
			if (sailingsReportBean.getWeek() != null && !sailingsReportBean.getWeek().isEmpty()) {
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(SailingsReportQueryUtil.weeks, new Object[] {sailingsReportBean.getWeek(),sailingsReportBean.getYear()});
				for (Map row : rows) {
					sailingsReportBean.setFromDate(row.get("fromDate").toString());
					sailingsReportBean.setToDate(row.get("toDate").toString());
				}
				String fromDate = sailingsReportBean.getFromDate();
				String toDate = sailingsReportBean.getToDate();
				System.out.println("date :" +fromDate  + toDate);
				/*sailingCont = sailingCont + " to_char( LOADING.SAILING_DT+1, 'IW' )=to_char( to_date('" + sailingsReportBean.getWeek().trim()
						+ "','DD/MM/YYYY')+1, 'IW' ) ";
				sailingCont = sailingCont + " and to_char(LOADING.SAILING_DT, 'YYYY')=to_char(to_date('" + sailingsReportBean.getWeek().trim()
						+ "','DD/MM/YYYY'), 'YYYY')";*/
				sailingCont = sailingCont + " LOADING.SAILING_DT::date>=to_Date('" + fromDate + "','dd/mm/yyyy') ";
				sailingCont = sailingCont + " and LOADING.SAILING_DT::date<=to_Date('" + toDate + "','dd/mm/yyyy') ";

			} else {
				if (sailingsReportBean.getFromDate() != null && !sailingsReportBean.getFromDate().isEmpty()) {
					sailingCont = sailingCont + " LOADING.SAILING_DT::date>=to_Date('" + sailingsReportBean.getFromDate().trim() + "','dd/mm/yyyy') ";
					if (sailingsReportBean.getToDate() != null && !sailingsReportBean.getToDate().isEmpty()) {
						sailingCont = sailingCont + " and LOADING.SAILING_DT::date<=to_Date('" + sailingsReportBean.getToDate().trim() + "','dd/mm/yyyy') ";
					}
				}

			}
			sailingCont = sailingCont + " ORDER BY VOYAGE, POL,SAILINGDATE";
			System.out.println("sailing report query :" + SailingsReportQueryUtil.GET_SAILING_REPORT_LIST + sailingCont);
			sailingsReportBeanList = jdbcTemplate.query(SailingsReportQueryUtil.GET_SAILING_REPORT_LIST + sailingCont,
					new BeanPropertyRowMapper<SailingsReportBean>(SailingsReportBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return sailingsReportBeanList;
	}

	@Override
	public List<SailingsReportBean> getVoyageCompletionList(SailingsReportBean sailingsReportBean) {
		List<SailingsReportBean> sailingsReportBeanList = new ArrayList<SailingsReportBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			System.out.println("company :" + sailingsReportBean.getCompanyCode());
			System.out.println("from dt :" + sailingsReportBean.getFromDate());
			System.out.println("to dt :" + sailingsReportBean.getToDate());
			System.out.println("week :" + sailingsReportBean.getWeek());
			String sailingCont = "";
			if (sailingsReportBean.getCompanyCode() != null && !sailingsReportBean.getCompanyCode().isEmpty()
					&& !sailingsReportBean.getCompanyCode().equals("C0000")) {
				sailingCont = sailingCont + " v.company_wise='" + sailingsReportBean.getCompanyCode() + "' and ";
			}
			if (sailingsReportBean.getWeek() != null && !sailingsReportBean.getWeek().isEmpty()) {
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(SailingsReportQueryUtil.weeks, new Object[] {sailingsReportBean.getWeek(),sailingsReportBean.getYear()});
				for (Map row : rows) {
					sailingsReportBean.setFromDate(row.get("fromDate").toString());
					sailingsReportBean.setToDate(row.get("toDate").toString());
				}
				String fromDate = sailingsReportBean.getFromDate();
				String toDate = sailingsReportBean.getToDate();
				System.out.println("date :" +fromDate  + toDate);
				sailingCont = sailingCont + " vah1.commence_date>=to_Date('" + fromDate	+ "','dd/mm/yyyy') ";
				sailingCont = sailingCont + " and vah1.completion_date<=to_Date('" + toDate + "','dd/mm/yyyy') ";
				/*sailingCont = sailingCont + " to_char( vah2.VESSEL_ARRIVED_HARBOUR+1, 'IW' )=to_char( to_date('"
						+ sailingsReportBean.getWeek().trim() + "','DD/MM/YYYY')+1, 'IW' ) ";
				sailingCont = sailingCont + " and to_char(vah2.VESSEL_ARRIVED_HARBOUR, 'YYYY')=to_char(to_date('"
						+ sailingsReportBean.getWeek().trim() + "','DD/MM/YYYY'), 'YYYY')";*/

			} else {
				if (sailingsReportBean.getFromDate() != null && !sailingsReportBean.getFromDate().isEmpty()) {
					sailingCont = sailingCont + " vah1.commence_date>=to_Date('" + sailingsReportBean.getFromDate().trim()
							+ "','dd/mm/yyyy') ";
					if (sailingsReportBean.getToDate() != null && !sailingsReportBean.getToDate().isEmpty()) {
						sailingCont = sailingCont + " and vah1.completion_date<=to_Date('" + sailingsReportBean.getToDate().trim()
								+ "','dd/mm/yyyy') ";
					}
				}

			}
			sailingCont = sailingCont + " ORDER BY  vah1.commence_date,vah1.completion_date";
			System.out.println("voyage completion query :" + SailingsReportQueryUtil.GET_VOYAGE_COMPLETION_LIST + sailingCont);
			sailingsReportBeanList = jdbcTemplate.query(SailingsReportQueryUtil.GET_VOYAGE_COMPLETION_LIST + sailingCont,
					new BeanPropertyRowMapper<SailingsReportBean>(SailingsReportBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return sailingsReportBeanList;
	}

	@Override
	public SailingsReportBean getWeek(String week,String year) throws CustomException {
		SailingsReportBean sailingsReportBean = new SailingsReportBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(SailingsReportQueryUtil.weeks, new Object[] {week,year});
			for (Map row : rows) {
				sailingsReportBean.setFromDate(row.get("fromDate").toString());
				sailingsReportBean.setToDate(row.get("toDate").toString());
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return sailingsReportBean;
	}

}
