package com.dci.payroll.tds.taxsection;

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
public class TaxsectionDAOImpl implements TaxsectionDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(TaxsectionDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<TaxsectionBean> getTaxsectionList() throws Exception {
		List<TaxsectionBean> taxsectionList = new ArrayList<TaxsectionBean>();
		try {
			taxsectionList = jdbcTemplate.query(TaxsectionQueryUtil.taxsectionSelect, new BeanPropertyRowMapper<TaxsectionBean>(TaxsectionBean.class));
			return taxsectionList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in taxsectionList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean insertTaxSection(TaxsectionBean taxsectionBean) throws CustomException {
		boolean isSuccess = false;
		int i = 1;
		String autoGenTrnSchId = "";
		try {
			Map<String, Object> taxsectionMap = new HashMap<String, Object>();

			taxsectionMap.put("tax_section_code", taxsectionBean.getTaxSectionCode());
			taxsectionMap.put("tax_section_description", taxsectionBean.getTaxSectionDescription());
			taxsectionMap.put("tax_section_max_limit", taxsectionBean.getTaxSectionMaxLimit());
			taxsectionMap.put("display_order", taxsectionBean.getDisplayOrder());
			taxsectionMap.put("tax_section_status", taxsectionBean.getTaxSectionStatus());
			namedParameterJdbcTemplate.update(TaxsectionQueryUtil.INSERT_TAXSECTION, taxsectionMap);
			isSuccess = true;
			if (i == 0) {
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in insertDesignation", e.getMessage());
			throw new CustomException("Tax Section Name '" + taxsectionBean.getTaxSectionCode() + "' already exists.");
		}
		return isSuccess;
	}

	@Override
	public TaxsectionBean getTaxSectionById(String taxsectioncode) throws CustomException {
		TaxsectionBean taxsectionEntry = new TaxsectionBean();
		try {

			int[] types = new int[] { Types.INTEGER };
			Object[] params = new Object[] { taxsectioncode };
			Map row = jdbcTemplate.queryForMap(TaxsectionQueryUtil.SELECT_TAXSECTIONENTRYBYID, params);

			if (row.get("tax_section_code") != null) {
				taxsectionEntry.setTaxSectionCode((String) row.get("tax_section_code"));

			}
			if (row.get("tax_section_description") != null) {
				taxsectionEntry.setTaxSectionDescription((String) row.get("tax_section_description"));
			}
			if (row.get("tax_section_max_limit") != null) {
				taxsectionEntry.setTaxSectionMaxLimit((int) row.get("tax_section_max_limit"));
			}
			if (row.get("display_order") != null) {
				taxsectionEntry.setDisplayOrder((int) row.get("display_order"));
			}
			if (row.get("tax_section_status") != null) {
				taxsectionEntry.setTaxSectionStatus((Boolean) row.get("tax_section_status"));
			}

			taxsectionEntry.setisEdit(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getLoanEntryId", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}

		return taxsectionEntry;
	}

	@Override
	public boolean updateTaxSection(TaxsectionBean taxsectionBean) throws CustomException {

		boolean isSuccess = false;
		int i = 1;
		try {
			Map<String, Object> taxsectionMap = new HashMap<String, Object>();

			taxsectionMap.put("tax_section_code", taxsectionBean.getTaxSectionCode());
			taxsectionMap.put("tax_section_description", taxsectionBean.getTaxSectionDescription());
			taxsectionMap.put("tax_section_max_limit", taxsectionBean.getTaxSectionMaxLimit());
			taxsectionMap.put("display_order", taxsectionBean.getDisplayOrder());
			taxsectionMap.put("tax_section_status", taxsectionBean.getTaxSectionStatus());

			namedParameterJdbcTemplate.update(TaxsectionQueryUtil.UPDATE_TAXSECTION, taxsectionMap);
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in update LoanEntry", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return isSuccess;
	}

	@Override
	public boolean deleteTaxSection(String taxsectioncode) throws CustomException {
		boolean isSuccess = false;
		int val = 1;
		try {
			val = jdbcTemplate.update(TaxsectionQueryUtil.DELETE_TAXSECTION, taxsectioncode);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteBranch", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		return isSuccess;
	}

}