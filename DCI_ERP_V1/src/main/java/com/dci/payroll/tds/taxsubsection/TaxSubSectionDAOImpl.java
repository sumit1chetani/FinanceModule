package com.dci.payroll.tds.taxsubsection;

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
public class TaxSubSectionDAOImpl implements TaxSubSectionDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(TaxSubSectionDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<TaxSubSectionBean> getTaxSubSectionList() throws Exception {
		List<TaxSubSectionBean> taxSubSectionList = new ArrayList<TaxSubSectionBean>();
		try {
			taxSubSectionList = jdbcTemplate.query(TaxSubSectionQueryUtil.TAXSUBSEC_LIST, new BeanPropertyRowMapper<TaxSubSectionBean>(TaxSubSectionBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in taxSubSectionList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return taxSubSectionList;
	}

	@Override
	public TaxSubSectionBean getTaxSubSectionById(String taxSubSectionCode) throws Exception {
		TaxSubSectionBean taxSubSectionBean = new TaxSubSectionBean();
		try {
			taxSubSectionBean = jdbcTemplate.queryForObject(TaxSubSectionQueryUtil.TAXSUBSEC_BY_CODE, new Object[] { taxSubSectionCode }, new BeanPropertyRowMapper<TaxSubSectionBean>(TaxSubSectionBean.class));
			int[] types = new int[] { Types.INTEGER };
			Object[] taxSubSecCode = new Object[] { taxSubSectionCode };
			Map row = jdbcTemplate.queryForMap(TaxSubSectionQueryUtil.TAXSUBSEC_BY_CODE, taxSubSecCode);

			if (row.get("tax_sub_section_code") != null) {
				taxSubSectionBean.setTaxSectionCode((String) row.get("tax_sub_section_code"));
			}
			if (row.get("tax_section_code") != null) {
				taxSubSectionBean.setTaxSectionCode((String) row.get("tax_section_code"));
			}
			if (row.get("tax_sub_section_description") != null) {
				taxSubSectionBean.setTaxSubSectionDescription((String) row.get("tax_sub_section_description"));
			}
			if (row.get("tax_sub_section_max_limit") != null) {
				taxSubSectionBean.setTaxSubSectionMaxLimit((int) row.get("tax_sub_section_max_limit"));
			}
			if (row.get("is_computed") != null) {
				taxSubSectionBean.setComputed((Boolean) row.get("is_computed"));
			}
			if (row.get("display_order") != null) {
				taxSubSectionBean.setDisplayOrder((int) row.get("display_order"));
			}
			if (row.get("tax_sub_section_status") != null) {
				taxSubSectionBean.setTaxSubSectionStatus((Boolean) row.get("tax_sub_section_status"));
			}
			taxSubSectionBean.setisEdit(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxSubSectionById", e);
			taxSubSectionBean.setisEdit(false);
			return taxSubSectionBean;
		}
		// TODO Auto-generated method stub
		return taxSubSectionBean;
	}

	@Override
	public boolean insertTaxSubSection(TaxSubSectionBean taxSubSectionBean) throws Exception {
		boolean isSuccess = false;
		List<TaxSubSectionBean> taxSubSectionList = new ArrayList<TaxSubSectionBean>();
		try {
			taxSubSectionList = jdbcTemplate.query(TaxSubSectionQueryUtil.TAXSUBSEC_BY_CODE, new BeanPropertyRowMapper<TaxSubSectionBean>(TaxSubSectionBean.class), taxSubSectionBean.getTaxSubSectionCode());
			Map<String, Object> taxSubSectionMap = new HashMap<String, Object>();
			taxSubSectionMap.put("tax_sub_section_code", taxSubSectionBean.getTaxSubSectionCode());
			taxSubSectionMap.put("tax_section_code", taxSubSectionBean.getTaxSectionCode());
			taxSubSectionMap.put("tax_sub_section_description", taxSubSectionBean.getTaxSubSectionDescription());
			taxSubSectionMap.put("tax_sub_section_max_limit", taxSubSectionBean.getTaxSubSectionMaxLimit());
			taxSubSectionMap.put("is_computed", taxSubSectionBean.isComputed());
			taxSubSectionMap.put("display_order", taxSubSectionBean.getDisplayOrder());
			taxSubSectionMap.put("tax_sub_section_status", taxSubSectionBean.isTaxSubSectionStatus());
			if (taxSubSectionList.size() == 0) {
				namedParameterJdbcTemplate.update(TaxSubSectionQueryUtil.INSERT_TAXSUBSEC, taxSubSectionMap);
			} else {
				namedParameterJdbcTemplate.update(TaxSubSectionQueryUtil.UPDATE_TAXSUBSEC, taxSubSectionMap);
			}

			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertTaxSubSection", e.getMessage());
			throw new CustomException(ErrorMessage.ERROR_LIST);

		}
		return isSuccess;
	}

	@Override
	public boolean deleteTaxSubSection(String taxSubSectionCode) throws Exception {
		boolean isSuccess = false;
		try {
			jdbcTemplate.update(TaxSubSectionQueryUtil.DELETE_TAXSUBSEC, taxSubSectionCode);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteTaxSubSection", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public List<TaxSubSectionBean> getTaxSectionList() throws Exception {
		List<TaxSubSectionBean> taxSectionList = new ArrayList<TaxSubSectionBean>();
		try {
			taxSectionList = jdbcTemplate.query(TaxSubSectionQueryUtil.TAXSECTION_LIST, new BeanPropertyRowMapper<TaxSubSectionBean>(TaxSubSectionBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxSectionList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return taxSectionList;
	}

}