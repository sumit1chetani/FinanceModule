package com.dci.tenant.finance.journalVoucherType;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;

@Repository
public class JournalVoucherTypeDAOImpl implements JournalVoucherTypeDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private final static Logger LOGGER = LoggerFactory.getLogger(JournalVoucherTypeDAOImpl.class);

	@Override
	public List<JournalVoucherTypeBean> getList() throws Exception {
		List<JournalVoucherTypeBean> journalVoucherTypeBeans = new ArrayList<JournalVoucherTypeBean>();
		try {
			journalVoucherTypeBeans = jdbcTemplate.query(JournalVoucherTypeQueryUtil.SELECT_LIST, new BeanPropertyRowMapper<JournalVoucherTypeBean>(JournalVoucherTypeBean.class));
			return journalVoucherTypeBeans;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxPayerTypeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean save(JournalVoucherTypeBean journalVoucherTypeBean) throws Exception {
		boolean isSuccess = false;
		String jvTypeId = "";
		try {

			Map<String, Object> jvmap = new HashMap<String, Object>();
			jvmap.put("name", journalVoucherTypeBean.getName());
			jvmap.put("description", journalVoucherTypeBean.getDescription());
			jvmap.put("active", journalVoucherTypeBean.isActive());

			namedParameterJdbcTemplate.update(JournalVoucherTypeQueryUtil.INSERT_JVTYPE, jvmap);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertSlabRate", e.getMessage());
			throw new CustomException(ErrorMessage.ERROR_LIST);

		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean update(JournalVoucherTypeBean journalVoucherTypeBean) throws Exception {
		boolean isSuccess = false;
		String jvTypeId = "";
		try {

			Map<String, Object> jvmap = new HashMap<String, Object>();
			jvmap.put("name", journalVoucherTypeBean.getName());
			jvmap.put("description", journalVoucherTypeBean.getDescription());
			jvmap.put("active", journalVoucherTypeBean.isActive());
			jvmap.put("journalvoucher_type_id", journalVoucherTypeBean.getJournalVoucherTypeId());

			namedParameterJdbcTemplate.update(JournalVoucherTypeQueryUtil.UPDATE_JVTYPE, jvmap);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertSlabRate", e.getMessage());
			throw new CustomException(ErrorMessage.ERROR_LIST);

		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean delete(Integer jvTypeId) throws Exception {
		boolean isSuccess = false;
		try {
			jdbcTemplate.update(JournalVoucherTypeQueryUtil.DELETE_JVTYPE, jvTypeId);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteSlabRate", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		// TODO Auto-generated method stub
		return isSuccess;

	}

	@Override
	public JournalVoucherTypeBean getJvTypeId(int jvTypeId) throws Exception {
		JournalVoucherTypeBean voucherTypeBean = new JournalVoucherTypeBean();
		try {
			int[] types = new int[] { Types.INTEGER };
			Object[] params = new Object[] { jvTypeId };
			Map row = jdbcTemplate.queryForMap(JournalVoucherTypeQueryUtil.SELECT_JVTYPE_BY_ID, jvTypeId);

			if (row.get("name") != null) {
				voucherTypeBean.setName((String) row.get("name"));
			}
			if (row.get("journalvoucher_type_id") != null) {
				voucherTypeBean.setJournalVoucherTypeId((Integer) row.get("journalvoucher_type_id"));
			}
			if (row.get("description") != null) {
				voucherTypeBean.setDescription((String) row.get("description"));
			}
			if (row.get("active") != null) {
				voucherTypeBean.setActive((Boolean) row.get("active"));
			}

			voucherTypeBean.setisEdit(true);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getSlabRateListById", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return voucherTypeBean;
	}

	@Override
	public List<JournalVoucherTypeBean> getJvTypeList() throws Exception {
		List<JournalVoucherTypeBean> journalVoucherTypeBeans = new ArrayList<JournalVoucherTypeBean>();
		try {
			journalVoucherTypeBeans = jdbcTemplate.query(JournalVoucherTypeQueryUtil.SELECT__JV_LIST, new BeanPropertyRowMapper<JournalVoucherTypeBean>(JournalVoucherTypeBean.class));
			return journalVoucherTypeBeans;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxPayerTypeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}
}
