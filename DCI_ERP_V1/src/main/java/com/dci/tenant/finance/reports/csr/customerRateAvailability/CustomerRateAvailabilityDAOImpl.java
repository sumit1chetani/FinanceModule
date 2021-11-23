package com.dci.tenant.finance.reports.csr.customerRateAvailability;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("tenantTransactionManager")
public class CustomerRateAvailabilityDAOImpl implements CustomerRateAvailabilityDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(CustomerRateAvailabilityDAOImpl.class);
	
	@Resource
	 private DataSource dataSource;

	
	@Override
	public List<Map<String, Object>> getCustomerRateAvailReportData(CustomerRateAvailabilityBean objCRABean) {
		List<Map<String, Object>> reportBuilderBeanList = new ArrayList<>();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			//select fn_get_port_combination_Qry('01-04-2016','15-04-2016',null,'JEA1',null) from dual;
			 String craPortCombinationQry = jdbcTemplate.queryForObject(CustomerRateAvailabilityQueryUtil.GET_CRA_PORT_COMBINATION_QUERY,
					 new Object[]{objCRABean.getFromDate(), objCRABean.getToDate(), objCRABean.getCustomerCode(),objCRABean.getPolCode(),
					 objCRABean.getPodCode()},
					 String.class);
			 System.out.println(craPortCombinationQry);
			 
			 reportBuilderBeanList = jdbcTemplate.queryForList(craPortCombinationQry);
			/* String names[] = null;
			 for(Map<String,Object> row:reportBuilderBeanList){
				for(String key : row.keySet()) {
					 String value = row.get(key).toString();
					 System.out.println("Key = " + key + ", Value = " + value);					 
				}
				 break;
			 }
			 */
			 System.out.println(reportBuilderBeanList);
			 
		}catch(DataAccessException ae){
			LOGGER.error("ERROR IN GET CRA LIST",ae);
		}
		return reportBuilderBeanList;
	}

}
