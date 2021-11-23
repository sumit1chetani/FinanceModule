package com.dci.tenant.finance.reports.schedule.inventry;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CodeStandardMsgUtil;
import com.dci.common.util.CustomException;

@Repository
@Transactional("tenantTransactionManager")
public class InventryDAOImpl implements InventryDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(InventryDAOImpl.class);
	
	@Resource
	 private DataSource dataSource;
	
	@Override
	public List<InventryBean> getInventryList(InventryBean inventryBean) throws CustomException {
		List<InventryBean> lInventryBean = new ArrayList<InventryBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lInventryBean = jdbcTemplate.query(InventryQueryUtill.sGetInventryValues, new BeanPropertyRowMapper<InventryBean>(InventryBean.class),
					Integer.parseInt(inventryBean.getTruckId()),inventryBean.getFromDate(),inventryBean.getToDate());

		} catch (Exception e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return lInventryBean;
	}

}
