package com.dci.tenant.finance.reports.customeranalysis;



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
import com.dci.common.util.CommonExcelUtils;
import com.dci.common.util.CustomException;

@Repository
@Transactional("tenantTransactionManager")
public class CustomerAnalysisDAOImpl implements CustomerAnalysisDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(CustomerAnalysisDAOImpl.class);
	
	@Resource
	 private DataSource dataSource;



	@Override
	public List<SelectivityBean> getCompanyList() {
		List<SelectivityBean> companyList = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<SelectivityBean> companyList1 = new ArrayList<SelectivityBean>();
			List<SelectivityBean> companyList2 = new ArrayList<SelectivityBean>();
			SelectivityBean selObj = new SelectivityBean();
			selObj.setId("C0000");
			selObj.setText("ALL");
			companyList1.add(selObj);
			companyList2 = jdbcTemplate.query(CustomerAnalysisQueryUtil.GET_COMPANY_LIST, new BeanPropertyRowMapper<SelectivityBean>(
					SelectivityBean.class));
			companyList.addAll(companyList1);
			companyList.addAll(companyList2);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return companyList;
	}

	@Override
	public List<CustomerAnalysisBean> getCustomerAnalysisReport(CustomerAnalysisBean customerAnalysisBean) {
		List<CustomerAnalysisBean> sailingsReportBeanList = new ArrayList<CustomerAnalysisBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (CommonExcelUtils.checkEmptyString(customerAnalysisBean.getCompanyCode()).equals("")	|| customerAnalysisBean.getCompanyCode().equals("C0000")) {
				customerAnalysisBean.setCompanyCode(null);
			}
			if (CommonExcelUtils.checkEmptyString(customerAnalysisBean.getSectorName()).equals("")) {
				customerAnalysisBean.setSectorName(null);
			}
			if (CommonExcelUtils.checkEmptyString(customerAnalysisBean.getVessel()).equals("")) {
				customerAnalysisBean.setVessel(null);
			}
			if (CommonExcelUtils.checkEmptyString(customerAnalysisBean.getVoyage()).equals("")) {
				customerAnalysisBean.setVoyage(null);
			}
		/*	if (CommonExcelUtils.checkEmptyString(customerAnalysisBean.getMlos()).equals("")) {
				customerAnalysisBean.setMlos(null);
			}*/
			
		if (customerAnalysisBean.getMlos() != null && customerAnalysisBean.getMlos()!= ""){
				String mloCodes[] =customerAnalysisBean.getMlos().split(",");
				String mloCode="";
				for(int i=0;i<mloCodes.length;i++){
					if(mloCode==""){
						mloCode="'"+mloCodes[i]+"'";
					}					
					else{
						mloCode +=","+"'"+mloCodes[i]+"'";
					}
				}
				customerAnalysisBean.setMlos(mloCode);
			}
			if (CommonExcelUtils.checkEmptyString(customerAnalysisBean.getTop()).equals("")) {
				customerAnalysisBean.setTop("1000");
			}
			int id=customerAnalysisBean.isPreviousYear() ? 3 : 2;
			String orderVal=customerAnalysisBean.isPreviousYear() ? "teus2015" : "teus2016"; 
		    String GET_CUSTOMER_ANALYSIS_REPORT_LIST = "";
			if (CommonExcelUtils.checkEmptyString(customerAnalysisBean.getMlos()).equals(""))
			{
			      GET_CUSTOMER_ANALYSIS_REPORT_LIST = "select * from vw_customer_analysis2016(?,?,?,?,?,?)" + "order by "+orderVal+" desc limit "+customerAnalysisBean.getTop()+"";
			  }
			else
			{
				  GET_CUSTOMER_ANALYSIS_REPORT_LIST = "select * from vw_customer_analysis2016(?,?,?,?,?,?)" + "where customer in (" + customerAnalysisBean.getMlos() + " ) order by "+orderVal+" desc limit "+customerAnalysisBean.getTop()+"";		
			}
				
			sailingsReportBeanList = jdbcTemplate.query(GET_CUSTOMER_ANALYSIS_REPORT_LIST ,new Object[]{customerAnalysisBean.getCompanyCode(),customerAnalysisBean.getSectorName()
					,customerAnalysisBean.getVessel(),customerAnalysisBean.getVoyage(),null,id},
					new BeanPropertyRowMapper<CustomerAnalysisBean>(CustomerAnalysisBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return sailingsReportBeanList;
	}


	@Override
	public CustomerAnalysisBean getWeek(String week,String year) throws CustomException {
		CustomerAnalysisBean customerAnalysisBean = new CustomerAnalysisBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CustomerAnalysisQueryUtil.weeks, new Object[] {week,year});
			for (Map row : rows) {
				customerAnalysisBean.setFromDate(row.get("fromDate").toString());
				customerAnalysisBean.setToDate(row.get("toDate").toString());
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return customerAnalysisBean;
	}
	

	@Override
	public List<CustomerAnalysisBean> getMLO() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CustomerAnalysisBean> lCommonUtilityBean = jdbcTemplate.query(CustomerAnalysisQueryUtil.MLO_MASTER, new BeanPropertyRowMapper<CustomerAnalysisBean>(CustomerAnalysisBean.class));
		return lCommonUtilityBean;

	}

	@Override
	public List<Ratesagainstloadingavg> getRatesagainstloadingavg(CustomerAnalysisBean customerAnalysisBean) {
		
		List<Ratesagainstloadingavg> lRatesagainstloadingavg=new ArrayList<Ratesagainstloadingavg>();
	 
		String wherecon="";
		String mlo=customerAnalysisBean.getMlos();
	 
		int year=Integer.parseInt(customerAnalysisBean.getYear());
		

		String sector=customerAnalysisBean.getSectorName();
		String voyage=customerAnalysisBean.getVoyage();
		String vessel=customerAnalysisBean.getVessel();
		String companyCode=customerAnalysisBean.getCompanyCode();
		
		if(!checkData(companyCode).isEmpty() && !checkData(companyCode).equals("C0000")){
			wherecon= wherecon+" and sector_id in (select sector_code from sector_master where   sec_company_code ='"+companyCode+"')";
		}
		if(!checkData(mlo).isEmpty()){
			wherecon= wherecon+" and mloshortname in ('"+mlo+"')";
		}if(!checkData(sector).isEmpty()){
			wherecon= wherecon+" and sector in ('"+sector+"')";
		}if(!checkData(voyage).isEmpty()){
			wherecon= wherecon+" and voyage_id in ('"+voyage+"')";
		}if(!checkData(vessel).isEmpty()){
			wherecon= wherecon+" and vessel_id in ('"+vessel+"')";
		}
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		wherecon= wherecon+" group by sector,mloshortname ,pol,pod,rated20,rated40,ratem20,ratem40,rater20,rater40";
		lRatesagainstloadingavg = jdbcTemplate.query(CustomerAnalysisQueryUtil.GET_LOADAGENT_DATA +wherecon ,new Object[]{year},
				new BeanPropertyRowMapper<Ratesagainstloadingavg>(Ratesagainstloadingavg.class));
	
		
		return lRatesagainstloadingavg;
	}
	

	@Override
	public List<JVRatesagainstloadingavg> getRatesagainstJvloadingavg(CustomerAnalysisBean customerAnalysisBean) {
		
		List<JVRatesagainstloadingavg> rows=new ArrayList<JVRatesagainstloadingavg>();
	 
		String wherecon="";
		String mlo=customerAnalysisBean.getMlos();
	 
		int year=Integer.parseInt(customerAnalysisBean.getYear());
		

		String sector=customerAnalysisBean.getSectorName();
		String voyage=customerAnalysisBean.getVoyage();
		String vessel=customerAnalysisBean.getVessel();
		String companyCode=customerAnalysisBean.getCompanyCode();
		
		if(!checkData(companyCode).isEmpty() && !checkData(companyCode).equals("C0000")){
			wherecon= wherecon+" and sector_id in (select sector_code from sector_master where   sec_company_code ='"+companyCode+"')";
		}
	 
		if(!checkData(mlo).isEmpty()){
			wherecon= wherecon+" and get_company(mlo) in ('"+mlo+"')";
		}if(!checkData(sector).isEmpty()){
			wherecon= wherecon+" and sector_id in ('"+sector+"')";
		}if(!checkData(voyage).isEmpty()){
			wherecon= wherecon+" and voyage_id in ('"+voyage+"')";
		}if(!checkData(vessel).isEmpty()){
			wherecon= wherecon+" and vessel_id in ('"+vessel+"')";
		} 
		
		wherecon= wherecon+" group by pol,pod,mlo,qm20rate,qm40rate,qm45rate,qd20rate,qd40rate,qd45rate, j_maxi_d20,j_maxi_d40,j_maxi_m20,j_maxi_m40, j_nyk_d20,j_nyk_d40,j_nyk_m20,j_nyk_m40,j_oel_d20,"
				+ "         j_oel_d40,j_oel_m20,j_oel_m40, j_oss_d20,j_oss_d40,j_oss_m20,j_oss_m40, j_sci_d20,j_sci_d40,j_sci_m20,j_sci_m40,            j_ssf_d20,j_ssf_d40,j_ssf_m20,j_ssf_m40,j_star_d20,j_star_d40,j_star_m20,j_star_m40,j_xcl_d20,j_xcl_d40,j_xcl_m20,j_xcl_m40 order by mlo,pol,pod";
		System.out.println(CustomerAnalysisQueryUtil.GET_LOADAGENT_JV_DATA +wherecon);
		 // rows = jdbcTemplate.queryForList(CustomerAnalysisQueryUtil.GET_LOADAGENT_JV_DATA +wherecon, new Object[] {String.valueOf(year)});
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		rows = jdbcTemplate.query(CustomerAnalysisQueryUtil.GET_LOADAGENT_JV_DATA +wherecon ,new Object[]{year,year},
					new BeanPropertyRowMapper<JVRatesagainstloadingavg>(JVRatesagainstloadingavg.class));
		
		return rows;
	}
	
	private String checkData(String valueOf) {
		try{
			if(valueOf ==null || valueOf =="null" || valueOf.trim()==null){
				valueOf="";
			}
		}catch(Exception e){
			return "";
		}
		return valueOf;
	}

}
