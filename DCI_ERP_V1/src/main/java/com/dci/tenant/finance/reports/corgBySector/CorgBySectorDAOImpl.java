package com.dci.tenant.finance.reports.corgBySector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CodeStandardMsgUtil;
import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLogDAO;

@Repository
@Transactional("tenantTransactionManager")
public class CorgBySectorDAOImpl implements CorgBySectorDAO {

	@Resource
	 private DataSource dataSource;
	
	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;
	
	private final static Logger LOGGER = LoggerFactory.getLogger(CorgBySectorDAOImpl.class);

	@Override
	public CorgBySectorResultBean  getCorgBySectorList(CorgBySector  core) throws Exception{
		CorgBySectorResultBean objBean = new CorgBySectorResultBean();
		List<String> headerlist = new ArrayList<String>();
		List<Object> detaillist = new ArrayList<Object>();
		int i = 0;
		String sector = "";
		String company = null;
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//	List<Map<String, Object>>	lCorgBySector = jdbcTemplate.queryForList(CorgBySectorQueryUtil.ContianerValue);
			if(!(core.getCompany().equals("")))
			{
		    company = core.getCompany();
			sector = jdbcTemplate.queryForObject(CorgBySectorQueryUtil.SECTOR_BY_COMPANY, new Object[]{company,Integer.parseInt(core.getYear()),Integer.parseInt(core.getWeek())},String.class);	
			System.out.println("company is not null " + sector  );
			}
			else
			{				
		    sector = jdbcTemplate.queryForObject(CorgBySectorQueryUtil.SECTOR_BY_COMPANY, new Object[]{null,Integer.parseInt(core.getYear()),Integer.parseInt(core.getWeek())},String.class);
		    System.out.println("company is  null " + sector  );	
			}
			List<Map<String, Object>>	lCorgBySector;
			if(core.getCompany().equals("C0001")){
				lCorgBySector = jdbcTemplate.queryForList(CorgBySectorQueryUtil.DUBAI_COMPANY, new Object[]{core.getReportType(),Integer.parseInt(core.getYear()),Integer.parseInt(core.getWeek()),core.isCumulative()});
			}else{
				lCorgBySector = jdbcTemplate.queryForList(CorgBySectorQueryUtil.SIN_COMPANY, new Object[]{core.getReportType(),Integer.parseInt(core.getYear()),Integer.parseInt(core.getWeek()),core.isCumulative()});
			}
			//List<Map<String, Object>>	lCorgBySector = jdbcTemplate.queryForList(sector);
			for (Map<String, Object> map : lCorgBySector) {
				List<Object> setaillist = new ArrayList<Object>();
						    for (Map.Entry<String, Object> entry : map.entrySet()) {
			    	String	key = entry.getKey();
			        Object value = entry.getValue();
			        if(!key.equals("customer")){
				        if(i==0){
				        	 headerlist.add(key.toUpperCase().replace("_", " "));
				        }
				        //setaillist.add(value);
				        try  
				        { 
				          if(value == null || value == "")
				        	  setaillist.add(value);
				          else{
					          float d = Float.parseFloat(value.toString());  
					          setaillist.add(Math.round(d));
				          }
				        }  
				        catch(NumberFormatException nfe)  
				        {  
				        	setaillist.add(value);
				        }  
				        
			        }
			    }
			    detaillist.add(setaillist);
			    i++;
			//summation of all
			    
			}		
	
			/*for (Map row : lCorgBySector) {
				CorgBySector exportDetail = new CorgBySector();
				exportDetail.setPayer_short_name((String) row.get("SURVEYOR_ENTRY_CODE"));
			}*/
			objBean.setHeader(headerlist);
			objBean.setDetail(detaillist);
		}catch (Exception ae) {
			LOGGER.error("Error in addCodeStandard", ae);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return objBean;
	}
	
	@Override
	public CorgBySectorResultBean  getcorgList(CorgBySector  core) throws Exception{
		CorgBySectorResultBean objBean = new CorgBySectorResultBean();
		List<String> headerlist = new ArrayList<String>();
		List<Object> detaillist = new ArrayList<Object>();
		int i = 0;
		String sector = "";
		String company = null;
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(!(core.getCompany().equals("")))
				company = core.getCompany();
			
			List<Map<String, Object>>	lCorgBySector;
			if(core.getCompany().equals("C0001")){
				lCorgBySector = jdbcTemplate.queryForList(CorgBySectorQueryUtil.DUBAI_COMPANY_BY_VOL, new Object[]{Integer.parseInt(core.getYear()),Integer.parseInt(core.getWeek()),core.isCumulative(),core.getSsf()});
			}else{
				lCorgBySector = jdbcTemplate.queryForList(CorgBySectorQueryUtil.SIN_COMPANY_BY_VOL, new Object[]{Integer.parseInt(core.getYear()),Integer.parseInt(core.getWeek()),core.isCumulative(),core.getSsf()});
			}
			
			//List<Map<String, Object>>	lCorgBySector = jdbcTemplate.queryForList(CorgBySectorQueryUtil.CORG_PROFIT, company,Integer.parseInt(core.getYear()),Integer.parseInt(core.getWeek()));
			for (Map<String, Object> map : lCorgBySector) {
				List<Object> setaillist = new ArrayList<Object>();
						    for (Map.Entry<String, Object> entry : map.entrySet()) {
			    	String	key = entry.getKey();
			        Object value = entry.getValue();
			        if(!key.equals("customer")){
				        if(i==0){
				        	 headerlist.add(key.toUpperCase().replace("_", " "));
				        }

				        if(!(value.equals("1. VOLUME")||value.equals("2. WEIGHT")||value.equals("3. REVENUE")||value.equals("4. EXPENSES")||value.equals("5. JV REVENUE")||value.equals("6. JV EXPENSES")))
				        	setaillist.add(Math.round(Float.parseFloat(value.toString())));
				        else
				        	setaillist.add(value);
				        
			        }
			    }
			    detaillist.add(setaillist);
			    i++;
			//summation of all
			    
			}	
	
			/*for (Map row : lCorgBySector) {
				CorgBySector exportDetail = new CorgBySector();
				exportDetail.setPayer_short_name((String) row.get("SURVEYOR_ENTRY_CODE"));
			}*/
			objBean.setHeader(headerlist);
			objBean.setDetail(detaillist);
		}catch (Exception ae) {
			LOGGER.error("Error in addCodeStandard", ae);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return objBean;
	}

	
}