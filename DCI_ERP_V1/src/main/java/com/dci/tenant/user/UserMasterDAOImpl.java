package com.dci.tenant.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CipherCrypto;
import com.dci.common.util.CommonExcelUtils;
import com.dci.common.util.CustomException;
import com.dci.common.util.InvoiceMoveToDraft;

@Repository
@Transactional("tenantTransactionManager")
public class UserMasterDAOImpl implements UserMasterDAO {

	private final static Logger LOGGER = Logger.getLogger(UserMasterDAOImpl.class);

	@PersistenceContext(unitName = "tenantEntityManager")
	private EntityManager em;

	@Autowired
	DataSource dataSource;
	

		/*
	 * @Autowired
	 * 
	 * @Value("${mail.url}")
	 */
	private String mail;



	@Override
	public Map<String, String> getFormCodeUrlMap() throws CustomException {
		Map<String, String> formCodeUrlMap = new HashMap<String, String>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> list = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_FORM_CODE_URL);
			for (Map<String, Object> row : list) {
				if (row.get("form_code") != null && row.get("form_list_page_url") != null) {
						//System.out.println(row.get("form_code").toString() );
						
					String url = row.get("form_list_page_url").toString();
					String form_code = row.get("form_code").toString();
					formCodeUrlMap.put(url, form_code);
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getFormCodeUrlMap", e);
		}
		return formCodeUrlMap;
	}

	@Override
	public Map<String, String> getAddUrlFormCodeMap() throws CustomException {
		Map<String, String> formCodeUrlMap = new HashMap<String, String>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> list = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_ADD_FORM_CODE_URL);
			for (Map<String, Object> row : list) {
				if (row.get("form_code") != null && row.get("form_add_page_url") != null) {
						//System.out.println(row.get("form_code").toString());
						
					String url = row.get("form_add_page_url").toString();
					String form_code = row.get("form_code").toString();
					formCodeUrlMap.put(url, form_code);
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getAddUrlFormCodeMap", e);
		}
		return formCodeUrlMap;
	}

	@Override
	public List<ModuleMasterBean> getModuleMasterList() {
		List<ModuleMasterBean> lModuleMasterBean = new ArrayList<ModuleMasterBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lModuleMasterBean = jdbcTemplate.query(UserMasterQueryUtil.GET_MODULE_MASTER_LIST,
					new BeanPropertyRowMapper<ModuleMasterBean>(ModuleMasterBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
		return lModuleMasterBean;
	}

	@Override
	public List<FormMasterBean> getFormMasterListAll(boolean isAgent) throws CustomException {
		List<FormMasterBean> lFormMasterBean = new ArrayList<FormMasterBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (isAgent) {
				lFormMasterBean = jdbcTemplate.query(UserMasterQueryUtil.GET_FORM_MASTER_LIST_ALL_AGENT,
						new BeanPropertyRowMapper<FormMasterBean>(FormMasterBean.class));
			} else {
				lFormMasterBean = jdbcTemplate.query(UserMasterQueryUtil.GET_FORM_MASTER_LIST_ALL,
						new BeanPropertyRowMapper<FormMasterBean>(FormMasterBean.class));
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
		return lFormMasterBean;
	}

	@Override
	public Map<String, String> getFormCodeNameMap() throws CustomException {
		Map<String, String> formCodeNameMap = new HashMap<String, String>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> lRow = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_FORM_MASTER_LIST_ALL);
			for (Map<String, Object> row : lRow) {
				formCodeNameMap.put((String) row.get("FORM_CODE"), (String) row.get("FORM_NAME"));
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
		return formCodeNameMap;
	}

	@Override
	public Map<String, String> getEmpIdNameMap() throws CustomException {
		Map<String, String> empIdNameMap = new HashMap<String, String>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> lRow = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_USER_LIST);
			for (Map<String, Object> row : lRow) {
				empIdNameMap.put((String) row.get("user_id"), (String) row.get("user_name"));
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
		return empIdNameMap;
	}

	@Override
	public List<FormMasterBean> getFormMasterListByModuleCode(String moduleCode, String formCode, boolean isParent)
			throws CustomException {
		List<Map<String, Object>> lRow = new ArrayList<>();
		List<FormMasterBean> lFormMasterBean = new ArrayList<FormMasterBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		if (isParent) {
			lRow = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_FORM_MASTER_PARENT_LIST,
					new Object[] { moduleCode, UserMasterConstants.parentCode });
		} else {
			lRow = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_FORM_MASTER_CHILD_LIST,
					new Object[] { moduleCode, formCode, UserMasterConstants.childCode });
		}
		for (Map<String, Object> row : lRow) {
			FormMasterBean formMasterBean = new FormMasterBean();
			formMasterBean.setFormCode((String) row.get("FORM_CODE"));
			formMasterBean.setFormName((String) row.get("FORM_NAME"));
			formMasterBean.setDisplayOrder(Integer.valueOf(String.valueOf(row.get("DISPLAY_ORDER"))));
			formMasterBean.setImageIconUrl((String) row.get("IMAGE_ICON_URL"));
			formMasterBean.setModuleCode((String) row.get("MODULE_CODE"));
			formMasterBean.setFormCodeParent((String) row.get("FORM_CODE_PARENT"));
			formMasterBean.setFormUrl((String) row.get("FORM_URL"));
			formMasterBean.setIsParent((String) row.get("IS_PARENT"));
			lFormMasterBean.add(formMasterBean);
		}
		return lFormMasterBean;
	}

	@Override
	public List<FormMasterBean> getFormMasterListByModuleCodeBase(String moduleCode, String formCode, boolean isParent)
			throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> lRow = new ArrayList<>();
		List<FormMasterBean> lFormMasterBean = new ArrayList<FormMasterBean>();
		if (isParent) {
			lRow = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_FORM_MASTER_PARENT_LIST_BASE,
					new Object[] { moduleCode });
		} else {
			lRow = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_FORM_MASTER_CHILD_LIST,
					new Object[] { moduleCode, formCode, UserMasterConstants.childCode });
		}
		for (Map<String, Object> row : lRow) {
			FormMasterBean formMasterBean = new FormMasterBean();
			formMasterBean.setFormCode((String) row.get("FORM_CODE"));
			formMasterBean.setFormName((String) row.get("FORM_NAME"));
			formMasterBean.setDisplayOrder(Integer.valueOf(String.valueOf(row.get("DISPLAY_ORDER"))));
			formMasterBean.setImageIconUrl((String) row.get("IMAGE_ICON_URL"));
			formMasterBean.setModuleCode((String) row.get("MODULE_CODE"));
			formMasterBean.setFormCodeParent((String) row.get("FORM_CODE_PARENT"));
			formMasterBean.setFormUrl((String) row.get("FORM_URL"));
			formMasterBean.setIsParent((String) row.get("IS_PARENT"));
			lFormMasterBean.add(formMasterBean);
		}
		return lFormMasterBean;
	}

	@Override
	public List<FormMasterBean> getFormMasterListByCompanyUser(String userId, String companyCode, String moduleCode)
			throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Integer companyUserId = getCompanyUserId(companyCode, userId);
		List<Integer> lFormPropertyIdActive = getlFormPropIdByCompUser(companyUserId);
		List<String> lFormCodeActive = getlFormCodeByCompUser(companyUserId);

		List<FormMasterBean> lFormMasterBean = new ArrayList<FormMasterBean>();
		List<PropertyMasterBean> lPropertyMasterBean = getPropertyMasterBeanList();
		try {

			// String value =
			// jdbcTemplate.queryForObject(UserMasterQueryUtil.sCheckEmployeeCompny,
			// new Object[]{ companyCode, userId},String.class);
			int value = jdbcTemplate.queryForObject(UserMasterQueryUtil.sCheckEmployeeCompny, Integer.class,
					companyCode, userId);
			// if (!CommonUtil.returnEmptyForNull(value).isEmpty()) {
			if (value > 0) {
				System.out.println("Base Company");
				for (FormMasterBean formMasterBean : getFormMasterListByModuleCode(moduleCode, "", true)) {
					lFormMasterBean.add(formMasterBean);
					for (FormMasterBean formMasterBeanChild : getFormMasterListByModuleCode(moduleCode,
							formMasterBean.getFormCode(), false)) {
						Map<String, FormPropertyBean> mFormPropertyBean = getFormPropertyBeanMapByFormCode(
								formMasterBeanChild.getFormCode());
						for (PropertyMasterBean propertyMasterBean : lPropertyMasterBean) {
							if (mFormPropertyBean.containsKey(propertyMasterBean.getPropertyCode())) {
								FormPropertyBean formPropertyBean = mFormPropertyBean
										.get(propertyMasterBean.getPropertyCode());
								formPropertyBean.setEnabled(
										lFormPropertyIdActive.contains(formPropertyBean.getFormPropertyId()));
								formMasterBeanChild.setFormPropertyBean(formPropertyBean);
							} else {
								FormPropertyBean formPropertyBean = new FormPropertyBean();
								formPropertyBean.setFormCode(formMasterBeanChild.getFormCode());
								formPropertyBean.setPropertyCode(propertyMasterBean.getPropertyCode());
								formPropertyBean.setFormPropertyId(0);
								formMasterBeanChild.setFormPropertyBean(formPropertyBean);
							}
						}
						lFormMasterBean.add(formMasterBeanChild);
					}
				}
			} else {
				System.out.println("Other Company");
				for (FormMasterBean formMasterBean : getFormMasterListByModuleCodeBase(moduleCode, "", true)) {
					lFormMasterBean.add(formMasterBean);
					for (FormMasterBean formMasterBeanChild : getFormMasterListByModuleCodeBase(moduleCode,
							formMasterBean.getFormCode(), false)) {
						Map<String, FormPropertyBean> mFormPropertyBean = getFormPropertyBeanMapByFormCode(
								formMasterBeanChild.getFormCode());
						for (PropertyMasterBean propertyMasterBean : lPropertyMasterBean) {
							if (mFormPropertyBean.containsKey(propertyMasterBean.getPropertyCode())) {
								FormPropertyBean formPropertyBean = mFormPropertyBean
										.get(propertyMasterBean.getPropertyCode());
								formPropertyBean.setEnabled(
										lFormPropertyIdActive.contains(formPropertyBean.getFormPropertyId()));
								formMasterBeanChild.setFormPropertyBean(formPropertyBean);
							} else {
								FormPropertyBean formPropertyBean = new FormPropertyBean();
								formPropertyBean.setFormCode(formMasterBeanChild.getFormCode());
								formPropertyBean.setPropertyCode(propertyMasterBean.getPropertyCode());
								formPropertyBean.setFormPropertyId(0);
								formMasterBeanChild.setFormPropertyBean(formPropertyBean);
							}
						}
						lFormMasterBean.add(formMasterBeanChild);
					}
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getVesselMasterList", e);
			e.printStackTrace();
		}
		return lFormMasterBean;
	}

	/**
	 * @param formCode
	 * @return
	 */
	@Override
	public Map<String, FormPropertyBean> getFormPropertyBeanMapByFormCode(String formCode) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Map<String, FormPropertyBean> mFormPropertyBean = new HashMap<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_FORM_PROPERTY_LIST,
					new Object[] { formCode });
			for (Map<String, Object> row : rows) {
				FormPropertyBean objFormPropertyBean = new FormPropertyBean();
				objFormPropertyBean.setFormPropertyId(Integer.valueOf(String.valueOf(row.get("FORM_PROPERTY_ID"))));
				objFormPropertyBean.setFormCode((String) row.get("FORM_CODE"));
				objFormPropertyBean.setPropertyCode((String) row.get("PROPERTY_CODE"));
				objFormPropertyBean.setAvailable(true);
				mFormPropertyBean.put(objFormPropertyBean.getPropertyCode(), objFormPropertyBean);
			}
		} catch (Exception e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
		return mFormPropertyBean;
	}

	@Override
	public List<FormPropertyBean> getFormPropertyBeanListByDesgn(Set<String> formCodeSet, String desgnCode)
			throws CustomException {
		List<FormPropertyBean> lFormPropertyBean = new ArrayList<FormPropertyBean>();
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("formCodeSet", formCodeSet);
			params.put("desgnCode", desgnCode);
			List<Map<String, Object>> rows = namedParameterJdbcTemplate
					.queryForList(UserMasterQueryUtil.GET_FORM_PROPERTY_LIST_DESG, params);
			for (Map<String, Object> row : rows) {
				FormPropertyBean objFormPropertyBean = new FormPropertyBean();
				objFormPropertyBean.setFormPropertyId(Integer.parseInt(String.valueOf(row.get("FORM_PROPERTY_ID"))));
				objFormPropertyBean.setFormCode((String) row.get("FORM_CODE"));
				objFormPropertyBean.setPropertyCode((String) row.get("PROPERTY_CODE"));
				boolean isEnabled = ((String) row.get("ENABLED")).equalsIgnoreCase("true") ? true : false;
				objFormPropertyBean.setEnabled(isEnabled);
				lFormPropertyBean.add(objFormPropertyBean);
			}
		} catch (Exception e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
		return lFormPropertyBean;
	}

	@Override
	public List<FormPropertyBean> getFormPropertyBeanListByFormCode(String formCode) throws CustomException {
		List<FormPropertyBean> lFormPropertyBean = new ArrayList<FormPropertyBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_FORM_PROPERTY_LIST,
					new Object[] { formCode });
			for (Map row : rows) {
				FormPropertyBean objFormPropertyBean = new FormPropertyBean();
				objFormPropertyBean.setFormPropertyId(Integer.parseInt(String.valueOf(row.get("FORM_PROPERTY_ID"))));
				objFormPropertyBean.setFormCode((String) row.get("FORM_CODE"));
				objFormPropertyBean.setPropertyCode((String) row.get("PROPERTY_CODE"));
				lFormPropertyBean.add(objFormPropertyBean);
			}
		} catch (Exception e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
		return lFormPropertyBean;
	}

	@Override
	public List<FormPropertyBean> getFormPropertyBeanListByCompanyUser(Set<String> formCodeSet, Integer companyUserId)
			throws CustomException {
		List<FormPropertyBean> lFormPropertyBean = new ArrayList<FormPropertyBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			Map<String, Object> params = new HashMap<>();
			params.put("formCodeSet", formCodeSet);
			params.put("companyUserId", companyUserId);
			List<Map<String, Object>> rows = namedParameterJdbcTemplate
					.queryForList(UserMasterQueryUtil.GET_FORM_PROPERTY_LIST_COMPUSER, params);
			for (Map<String, Object> row : rows) {
				FormPropertyBean objFormPropertyBean = new FormPropertyBean();
				objFormPropertyBean.setFormPropertyId(Integer.parseInt(String.valueOf(row.get("FORM_PROPERTY_ID"))));
				objFormPropertyBean.setFormCode((String) row.get("FORM_CODE"));
				objFormPropertyBean.setPropertyCode((String) row.get("PROPERTY_CODE"));
				boolean isEnabled = ((String) row.get("ENABLED")).equalsIgnoreCase("true") ? true : false;
				objFormPropertyBean.setEnabled(isEnabled);
				lFormPropertyBean.add(objFormPropertyBean);
			}
		} catch (Exception e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
		return lFormPropertyBean;
	}

	@Override
	public void insertFormPropertyBeanListByCompanyUser(final List<Integer> lFormPropertyId, final int companyUserId, String userId, String companyCode, String mode)
			throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("companyUserId ***** " + companyUserId);
		
		jdbcTemplate.batchUpdate(UserMasterQueryUtil.INSERT_FORM_PROPERTY_LIST, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) {
				try{
				ps.setInt(1, lFormPropertyId.get(i));
				ps.setInt(2, companyUserId);
				//ps.setString(3, ""+mode+"");
				}
				catch (Exception e){
					e.printStackTrace();
				}
			}
		
			@Override
			public int getBatchSize() {
				return lFormPropertyId.size();
			}
		});
		//mode
//		int company =companyUserId;
//		company= jdbcTemplate.queryForObject(UserMasterQueryUtil.INSERT_COMPANY_USER_IDnew, Integer.class,
//					companyCode, userId, 0,""+mode+"");
	}

	@Override
	public void deleteFormPropertyBeanListByCompanyUser(List<Integer> lFormPropertyId, int companyUserId)
			throws CustomException {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("formPropertyId", lFormPropertyId);
		parameters.addValue("companyUserId", companyUserId);
		namedParameterJdbcTemplate.update(UserMasterQueryUtil.DELETE_FORM_PROPERTY_LIST_COMPUSER, parameters);
	}

	@Override
	public void deleteFormPropertyBeanListByUser(String userId) throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(UserMasterQueryUtil.DELETE_FORM_PROPERTY_LIST_USER, new Object[] { userId });
	}

	@Override
	public void insertFormPropertyBeanListDesgnNCompUser(String companyCode, String userId, String desgnCode)
			throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int compUserId = insertCompanyUserId(companyCode, userId,"");
		jdbcTemplate.update(UserMasterQueryUtil.INSERT_FORM_PROPERTY_LIST_DESGN_N_COMPUSER,
				new Object[] { compUserId, desgnCode });
	}

	@Override
	public void insertFormPropertyBeanListDesgn(final List<Integer> lFormPropertyId, final String desgnCode) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("companyUserId ***** " + desgnCode);
		jdbcTemplate.batchUpdate(UserMasterQueryUtil.INSERT_FORM_PROPERTY_LIST_DESGN,
				new BatchPreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setInt(1, lFormPropertyId.get(i));
						ps.setString(2, desgnCode);
					}

					@Override
					public int getBatchSize() {
						return lFormPropertyId.size();
					}
				});
	}

	@Override
	public void deleteFormPropertyBeanListDesgn(List<Integer> lFormPropertyId, String desgnCode) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("formPropertyId", lFormPropertyId);
		parameters.addValue("desgnCode", desgnCode);
		namedParameterJdbcTemplate.update(UserMasterQueryUtil.DELETE_FORM_PROPERTY_LIST_DESGN, parameters);
	}

	@Override
	public List<String> getlEnabledFormCode(int companyUserId) throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<String> lFormCode = new ArrayList<>();

		try {
			lFormCode = jdbcTemplate.query(UserMasterQueryUtil.FORM_CODE_SET_FROM_USER_RIGHTS,
					new Object[] { companyUserId }, new RowMapper<String>() {
						@Override
						public String mapRow(ResultSet rs, int rowNum) throws SQLException {
							return rs.getString(1);
						}
					});
		} catch (DataAccessException e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
		return lFormCode;
	}

	@Override
	public List<Integer> getlFormPropIdByCompUser(int companyUserId) throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Integer> formPropertyIdList = new ArrayList<Integer>();

		try {
			formPropertyIdList = jdbcTemplate.query(UserMasterQueryUtil.FORM_PROPERTY_LIST_FROM_USER_RIGHTS,
					new Object[] { companyUserId }, new RowMapper<Integer>() {
						@Override
						public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
							return rs.getInt(1);
						}
					});
		} catch (DataAccessException e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
		return formPropertyIdList;
	}

	@Override
	public List<String> getlFormCodeByCompUser(int companyUserId) throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<String> formCodeList = new ArrayList<String>();

		try {
			formCodeList = jdbcTemplate.query(UserMasterQueryUtil.FORM_CODE_LIST_FROM_USER_RIGHTS,
					new Object[] { companyUserId }, new RowMapper<String>() {
						@Override
						public String mapRow(ResultSet rs, int rowNum) throws SQLException {
							return rs.getString(1);
						}
					});
		} catch (DataAccessException e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
		return formCodeList;
	}

	@Override
	public List<Integer> getlFormPropIdByDesgn(String desgnCode) throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Integer> formPropertyIdList = new ArrayList<Integer>();

		try {
			formPropertyIdList = jdbcTemplate.query(UserMasterQueryUtil.FORM_PROPERTY_LIST_FROM_DESGN_RIGHTS,
					new Object[] { desgnCode }, new RowMapper<Integer>() {
						@Override
						public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
							return rs.getInt(1);
						}
					});
		} catch (DataAccessException e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
		return formPropertyIdList;
	}

	@Override
	public List<String> getCompanyCodeList(String userId) throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<String> lCompanyCode = new ArrayList<String>();
		try {
			lCompanyCode = jdbcTemplate.query(UserMasterQueryUtil.GET_COMPANY_ID_LIST, new Object[] { userId },
					new RowMapper<String>() {
						@Override
						public String mapRow(ResultSet rs, int rowNum) throws SQLException {
							return rs.getString(1);
						}
					});
		} catch (DataAccessException e) {
			LOGGER.error("Error in getCompanyDetailsList", e);
			throw new CustomException("");
		}
		return lCompanyCode;
	}

	@Override
	public List<DesignationMasterBean> getDesignationList() throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<DesignationMasterBean> lDesignationMasterBean = new ArrayList<DesignationMasterBean>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_DESIGNATION_LIST);
			for (Map row : rows) {
				DesignationMasterBean objDesignationMasterBean = new DesignationMasterBean();
				objDesignationMasterBean.setDesignationCode((String) row.get("DESGN_CODE"));
				objDesignationMasterBean.setDesignationName((String) row.get("DESGN_NAME"));
				objDesignationMasterBean.setDesignationDesc((String) row.get("DESGN_DESC"));
				objDesignationMasterBean.setId((String) row.get("id"));
				objDesignationMasterBean.setText((String) row.get("text"));
				lDesignationMasterBean.add(objDesignationMasterBean);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getDesignationList", e);
			throw new CustomException("");
		}
		return lDesignationMasterBean;
	}

	@Override
	public List<CompanyDetailsBean> getCompanyList() throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CompanyDetailsBean> lCompanyDetailsBean = new ArrayList<CompanyDetailsBean>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_COMPANY_LIST);
			for (Map row : rows) {
				CompanyDetailsBean objCompanyDetailsBean = new CompanyDetailsBean();
				objCompanyDetailsBean.setCompanyCode((String) row.get("COMPANY_CODE"));
				objCompanyDetailsBean.setCompanyName((String) row.get("COMPANY_NAME"));
				objCompanyDetailsBean.setCompanyLocation((String) row.get("LOCATION"));
				objCompanyDetailsBean.setId((String) row.get("id"));
				objCompanyDetailsBean.setText((String) row.get("text"));
				lCompanyDetailsBean.add(objCompanyDetailsBean);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getCompanyDetailsList", e);
			throw new CustomException("");
		}
		return lCompanyDetailsBean;
	}

	@Override
	public CompanyDetailsBean getCompanyDetailsBean(String companyCode) throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		CompanyDetailsBean companyDetailsBean = new CompanyDetailsBean();
		try {
			companyDetailsBean = jdbcTemplate.queryForObject(UserMasterQueryUtil.GET_COMPANY_BEAN,
					new Object[] { companyCode },
					new BeanPropertyRowMapper<CompanyDetailsBean>(CompanyDetailsBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getCompanyDetailsList", e);
			throw new CustomException("");
		}
		return companyDetailsBean;
	}

	@Override
	public List<UserMasterBean> getUserList() throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<UserMasterBean> lUserMasterBean = jdbcTemplate.query(UserMasterQueryUtil.GET_USER_LIST,
				new BeanPropertyRowMapper<UserMasterBean>(UserMasterBean.class));
		for (UserMasterBean userMasterBean : lUserMasterBean) {
			userMasterBean.setCompanyCodesMapped(getCompanyCodeList(userMasterBean.getUserId()));
		}
		return lUserMasterBean;
	}

	@Override
	public List<UserMasterBean> getUserList(String companyCode) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<UserMasterBean> lUserMasterBean = jdbcTemplate.query(UserMasterQueryUtil.GET_USRLST_BY_COMPCODE,
				new Object[] { companyCode }, new BeanPropertyRowMapper<UserMasterBean>(UserMasterBean.class));
		for (UserMasterBean userMasterBean : lUserMasterBean) {
			userMasterBean.setCompanyCodesMapped(getCompanyCodeList(userMasterBean.getUserId()));
		}
		return lUserMasterBean;
	}

	@Override
	public int insertCompanyUserId(String companyCode, String userId,String mode) throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int companyUserId = getCompanyUserId(companyCode, userId);
		try{
			String modenew ="";
			if(mode == ""  || mode ==null  || mode ==""+null+"" ||mode.equalsIgnoreCase("null")){
				 modenew= "";
			}else{
				 modenew= mode;

			}
		if (companyUserId == 0) {
			// final String INSERT_SQL =
			// UserMasterQueryUtil.INSERT_COMPANY_USER_ID;
			final String finalUserId = userId;
			final String finalCompanyCode = companyCode;
			companyUserId = jdbcTemplate.queryForObject(UserMasterQueryUtil.INSERT_COMPANY_USER_ID, Integer.class,
					finalUserId, finalCompanyCode, 0);
			// KeyHolder keyHolder = new GeneratedKeyHolder();
			/*
			 * jdbcTemplate.update(new PreparedStatementCreator() {
			 * 
			 * @Override public PreparedStatement
			 * createPreparedStatement(Connection connection) throws
			 * SQLException { PreparedStatement ps =
			 * connection.prepareStatement(INSERT_SQL, new String[] {
			 * "company_user_id" }); ps.setString(1, finalUserId);
			 * ps.setString(2, finalCompanyCode); ps.setInt(3, 0); return ps; }
			 * }, keyHolder); companyUserId =
			 * Integer.parseInt(String.valueOf(keyHolder.getKey()));
			 */
		}else {
	
			/*jdbcTemplate.update(UserMasterQueryUtil.update_COMPANY_USER_ID,
					new Object[] { mode,userId,companyCode});*/
        
			
			companyUserId = jdbcTemplate.queryForObject(UserMasterQueryUtil.update_COMPANY_USER_ID, Integer.class,
					modenew, userId, companyCode);
		}
		}catch (Exception e){
			e.printStackTrace();
		}
		return companyUserId;
	}

	@Override
	public int getCompanyUserId(String companyCode, String userId) throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String companyUserId = "";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_COMPANY_USER_ID,
				new Object[] { companyCode, userId });
		for (Map<String, Object> row : rows) {
			companyUserId = CommonExcelUtils.checkEmptyString(String.valueOf(row.get("COMPANY_USER_ID")));
		}
		companyUserId = companyUserId.equals("") ? "0" : companyUserId;
		return Integer.parseInt(companyUserId);
	}

	@Override
	public UserDetail loadUserByUsername(final String username) throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		UserDetail user = new UserDetail();
		int count = jdbcTemplate.queryForObject(UserMasterQueryUtil.getcount, Integer.class, username);
		if (count > 0)

		{
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_USER,
					new Object[] { username });
			String userPortStr = "";
			String[] portList = new String[] {};
			for (Map<String, Object> row : rows) {
				user.setUserId((String) row.get("user_id"));
				user.setUsername((String) row.get("user_name"));
				user.setUsername2((String) row.get("user_name2"));
				user.setPassword((String) row.get("user_password"));
				user.setCompanyCode((String) row.get("company_code"));
				user.setCompanyCountry((String) row.get("LOCATION"));
				user.setDepartmentName((String) row.get("DEPT_NAME"));
				user.setDesignationName((String) row.get("DESGN_NAME"));
				user.setEmail((String) row.get("EMAIL_ID"));
				user.setIsVendor((String) row.get("vendor"));
				user.setVendorName((String) row.get("vendor_name"));
				user.setProfileImg(StringUtils.trimToEmpty((String) row.get("PROFILE_IMG")));
				boolean isAgent = ((String) row.get("user_ref_flag")).equalsIgnoreCase("C") ? true : false;
				user.setAgent(isAgent);
				if (row.get("port") != null) {
					portList = row.get("port").toString().split(",");
				}
			}
			for (String port : portList) {
				userPortStr += "'" + port + "',";
			}
			if (userPortStr.length() > 0) {
				userPortStr = userPortStr.substring(0, userPortStr.length() - 1);
			} else {
				userPortStr = "''";
			}
			user.setUserPortList(portList);
			user.setUserPortStr(userPortStr);

		}

		else {

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_USER_CUSTOMER,
					new Object[] { username });
			for (Map<String, Object> row : rows) {
				user.setUserId((String) row.get("user_id"));
				user.setUsername((String) row.get("user_name"));
				user.setPassword((String) row.get("user_password"));
				boolean isAgent = ((String) row.get("user_ref_flag")).equalsIgnoreCase("C") ? true : false;
				user.setAgent(isAgent);
			}
		}
		return user;
	}

	@Override
	public List<GrantedAuthority> loadPermissionsByUsername(final int companyUserId, boolean isAgent) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		List<FormPropertyBean> lFormPropertyBean = new ArrayList<>();
		if (isAgent) {
			lFormPropertyBean = jdbcTemplate.query(UserMasterQueryUtil.GET_USER_PERMISSION_AGENT,
					new BeanPropertyRowMapper<FormPropertyBean>(FormPropertyBean.class));
		} else {
			lFormPropertyBean = jdbcTemplate.query(UserMasterQueryUtil.GET_USER_PERMISSION,
					new Object[] { companyUserId },
					new BeanPropertyRowMapper<FormPropertyBean>(FormPropertyBean.class));
		}
		for (final FormPropertyBean formPropertyBean : lFormPropertyBean) {
			authorities.add(new SimpleGrantedAuthority(
					"ROLE_" + formPropertyBean.getFormCode() + "_" + formPropertyBean.getPropertyCode()));
		}
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		return authorities;
	}

	@Override
	public Map<String, PropertyMasterBean> getPropertyMasterBeanMap() throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Map<String, PropertyMasterBean> mPropertyMasterBean = new HashMap<>();
		try {
			List<Map<String, Object>> lRows = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_PROPERTY_MASTER_LIST);
			for (Map<String, Object> row : lRows) {
				PropertyMasterBean propertyMasterBean = new PropertyMasterBean();
				propertyMasterBean.setPropertyCode((String) row.get("PROPERTY_CODE"));
				propertyMasterBean.setPropertyName((String) row.get("PROPERTY_NAME"));
				mPropertyMasterBean.put(propertyMasterBean.getPropertyCode(), propertyMasterBean);
			}

		} catch (Exception e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
		return mPropertyMasterBean;
	}

	@Override
	public List<PropertyMasterBean> getPropertyMasterBeanList() throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<PropertyMasterBean> lPropertyMasterBean = new ArrayList<PropertyMasterBean>();
		try {
			lPropertyMasterBean = jdbcTemplate.query(UserMasterQueryUtil.GET_PROPERTY_MASTER_LIST,
					new BeanPropertyRowMapper<PropertyMasterBean>(PropertyMasterBean.class));
		} catch (Exception e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
		return lPropertyMasterBean;
	}

	@Override
	public void insertCompanyToCompany(int fromCompUserId, int toCompUserId) throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			jdbcTemplate.update(UserMasterQueryUtil.INSERT_COMPANY_TO_COMPANY,
					new Object[] { toCompUserId, fromCompUserId });
		} catch (Exception e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
	}

	@Override
	public UserMasterBean getUser(String userId) throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		UserMasterBean objUserMasterBean = jdbcTemplate.queryForObject(UserMasterQueryUtil.GET_USER_ITEM,
				new Object[] { userId }, new BeanPropertyRowMapper<UserMasterBean>(UserMasterBean.class));
		objUserMasterBean.setCompanyCodesMapped(getCompanyCodeList(userId));
		return objUserMasterBean;
	}

	@Override
	public List<FormMasterBean> getFormMasterListByDesgn(String moduleCode, String desgnCode) throws CustomException {

		List<Integer> lFormPropertyIdActive = getlFormPropIdByDesgn(desgnCode);
		List<FormMasterBean> lFormMasterBean = new ArrayList<FormMasterBean>();
		List<PropertyMasterBean> lPropertyMasterBean = getPropertyMasterBeanList();

		try {
			for (FormMasterBean formMasterBean : getFormMasterListByModuleCode(moduleCode, "", true)) {
				lFormMasterBean.add(formMasterBean);
				for (FormMasterBean formMasterBeanChild : getFormMasterListByModuleCode(moduleCode,
						formMasterBean.getFormCode(), false)) {
					Map<String, FormPropertyBean> mFormPropertyBean = getFormPropertyBeanMapByFormCode(
							formMasterBeanChild.getFormCode());
					for (PropertyMasterBean propertyMasterBean : lPropertyMasterBean) {
						if (mFormPropertyBean.containsKey(propertyMasterBean.getPropertyCode())) {
							FormPropertyBean formPropertyBean = mFormPropertyBean
									.get(propertyMasterBean.getPropertyCode());
							formPropertyBean
									.setEnabled(lFormPropertyIdActive.contains(formPropertyBean.getFormPropertyId()));
							formMasterBeanChild.setFormPropertyBean(formPropertyBean);
						} else {
							FormPropertyBean formPropertyBean = new FormPropertyBean();
							formPropertyBean.setFormCode(formMasterBeanChild.getFormCode());
							formPropertyBean.setPropertyCode(propertyMasterBean.getPropertyCode());
							formPropertyBean.setFormPropertyId(0);
							formMasterBeanChild.setFormPropertyBean(formPropertyBean);
						}
					}
					lFormMasterBean.add(formMasterBeanChild);
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
		return lFormMasterBean;
	}

	@Override
	public List<UserMasterBean> getCompanyList(String formCode) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		List<UserMasterBean> lCompanyList = new ArrayList<UserMasterBean>();
		try {
			lCompanyList = jdbcTemplate.query(UserMasterQueryUtil.GETCOMPANYUSERLIST, new Object[] {  },
					new BeanPropertyRowMapper<UserMasterBean>(UserMasterBean.class));// GETCOMPANYUSERLISTSTAFFMAST

		} catch (DataAccessException e) {
			LOGGER.error("Error in Port LIST", e);
		}
		return lCompanyList;
	}

	@Override
	public List<UserMasterBean> getCompanyList1(String formCode) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		List<UserMasterBean> lCompanyList = new ArrayList<UserMasterBean>();
		try {
			lCompanyList = jdbcTemplate.query(UserMasterQueryUtil.GETCOMPANYUSERLIST1, new Object[] {},
					new BeanPropertyRowMapper<UserMasterBean>(UserMasterBean.class));// GETCOMPANYUSERLISTSTAFFMAST

		} catch (DataAccessException e) {
			LOGGER.error("Error in Port LIST", e);
		}
		return lCompanyList;
	}

	@Override
	public void insertUserLogIp(UserDetail user, String actionType) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] params = new Object[] { user.getUserId(), user.getUserIpAddress(),
				CommonExcelUtils.getCurrentTimeStamp(), actionType };
		jdbcTemplate.update(UserMasterQueryUtil.INSERT_USER_LOGIN_IP, params);
	}

	@Override
	public List<Map<String, Object>> getEmployeeIncompany(UserMasterBean obj) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = UserMasterQueryUtil.GET_EMP_NAME;
		if (obj.getCompanyCode() != null && !obj.getCompanyCode().isEmpty()) {
			query = query + " and view_user_rights.empcompanycode ='" + obj.getCompanyCode() + "'";
		}
		if (obj.getUserId() != null && !obj.getUserId().isEmpty()) {
			query = query + " and view_user_rights.user_id ='" + obj.getUserId() + "'";
		}
		if (obj.getModuleCode() != null && !obj.getModuleCode().isEmpty()) {
			query = query + " and view_user_rights.module_code ='" + obj.getModuleCode() + "'";
		}
		query = query + " order by user_id";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

		return rows;
	}

	@Override
	public List<Map<String, Object>> getEmployeeModule(String employee, String company) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_EMP_MODULE,
				new Object[] { employee, company });

		return rows;
	}

	@Override
	public List<Map<String, Object>> getEmployeeRights(String employee, String moduleId, String company) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(UserMasterQueryUtil.GET_EMP_RIGHTS,
				new Object[] { employee, moduleId, company });

		return rows;
	}

	@Override
	public List<GrantedAuthority> loadPermissionsByUsernameCustomer(boolean isAgent) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		List<FormPropertyBean> lFormPropertyBean = new ArrayList<>();

		lFormPropertyBean = jdbcTemplate.query(UserMasterQueryUtil.GET_USER_PERMISSION_AGENT,
				new BeanPropertyRowMapper<FormPropertyBean>(FormPropertyBean.class));

		for (final FormPropertyBean formPropertyBean : lFormPropertyBean) {
			authorities.add(new SimpleGrantedAuthority(
					"ROLE_" + formPropertyBean.getFormCode() + "_" + formPropertyBean.getPropertyCode()));
		}
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		return authorities;
	}

	@Override
	public List<Integer> getlFormPropIdByCustomer() throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Integer> formPropertyIdList = new ArrayList<Integer>();

		try {
			formPropertyIdList = jdbcTemplate.query(UserMasterQueryUtil.FORM_PROPERTY_LIST_FROM_USER_RIGHTS_CUSTOMER,
					new RowMapper<Integer>() {
						@Override
						public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
							return rs.getInt(1);
						}
					});
		} catch (DataAccessException e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
		return formPropertyIdList;
	}

	@Override
	public int getcount(String userName) throws CustomException {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		int count = jdbcTemplate.queryForObject(UserMasterQueryUtil.getcount, Integer.class, userName);
		return count;
	}

	@Override
	public List<UserDetail> getBranchList() throws Exception {

		List<UserDetail> list = new ArrayList<UserDetail>();

		List<UserDetail> list1 = new ArrayList<UserDetail>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list1 = jdbcTemplate.query(UserMasterQueryUtil.emp_list,
					new BeanPropertyRowMapper<UserDetail>(UserDetail.class));

			for (UserDetail bean : list1) {
				System.out
						.println("###################################################################################");
				String userid = bean.getUserId();
				System.out.println(userid);
				String name = bean.getUsername();
				System.out.println(name);
				String emailid = bean.getEmail();
				System.out.println(emailid);
				String password = CipherCrypto.Decrypt(bean.getPassword());
				System.out.println(password);
				System.out
						.println("###################################################################################");
				bean.setPassword(password);
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<SelectivityBean> getInvoiceList(String invoiceType, String mode) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<SelectivityBean> List = new ArrayList<>();
		try {
			if (mode.equalsIgnoreCase("1")) {
				if (invoiceType.equalsIgnoreCase("1")) {
					List = jdbcTemplate.query(UserMasterQueryUtil.SeaSalesInvoiceList, new Object[] {},
							new BeanPropertyRowMapper<>(SelectivityBean.class));

				} else if (invoiceType.equalsIgnoreCase("2")) {
					List = jdbcTemplate.query(UserMasterQueryUtil.SeaPurchaseInvoiceList, new Object[] {},
							new BeanPropertyRowMapper<>(SelectivityBean.class));

				}

			} else if (mode.equalsIgnoreCase("2")) {
				if (invoiceType.equalsIgnoreCase("1")) {
					List = jdbcTemplate.query(UserMasterQueryUtil.AirSalesInvoiceList, new Object[] {},
							new BeanPropertyRowMapper<>(SelectivityBean.class));

				} else if (invoiceType.equalsIgnoreCase("2")) {
					List = jdbcTemplate.query(UserMasterQueryUtil.AirPurchaseInvoiceList, new Object[] {},
							new BeanPropertyRowMapper<>(SelectivityBean.class));

				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Invoice List", e);
		}
		return List;
	}

	@Override
	public boolean forgetPassword(String emailId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean invoicemovetodraft(InvoiceMoveToDraft invoiceDraft) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<FormPropertyBean> getFormNames() {
		List<FormPropertyBean> lModuleMasterBean = new ArrayList<FormPropertyBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lModuleMasterBean = jdbcTemplate.query(UserMasterQueryUtil.GET_FORM_NAMES,
					new BeanPropertyRowMapper<FormPropertyBean>(FormPropertyBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getVesselMasterList", e);
		}
		return lModuleMasterBean;

	}


	@Override
	public UserFormRightsPropertyBean getUserFormRights(String formCode) {

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> propCodes = null;
		String userName = null;
		String propCode = null;
		UserFormRightsPropertyBean formRightsPropertyBean = new UserFormRightsPropertyBean(); // TODO
																								// Auto-generated
																								// method
																								// stub
		String queryVal = UserMasterQueryUtil.GETFORMUSERRIGHTS + "'" + formCode + "'"
				+ " order by usr.user_name,property_code";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);			
			List<Map<String, Object>> list = jdbcTemplate.queryForList(queryVal);
			for (Map<String, Object> row : list) {

				userName = (String)row.get("userName");
				propCode = (String)row.get("propCode");
				if (!map.containsKey(userName)) {
					propCodes = new ArrayList<String>();
				} else {
					propCodes = map.get(userName);
				}
				propCodes.add(propCode);

				map.put(userName, propCodes);


			}
			formRightsPropertyBean.setUserRights(map);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getFormCodeUrlMap", e);
		}
		return formRightsPropertyBean;

	}

/*	@Override
	public void insertFormPropertyBeanListByCompanyUsermode(String companyCode, String userId, Integer companyUserId,
			String mode) 	throws CustomException  {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("companyUserId ***** " + companyUserId);
		try{
		companyUserId = jdbcTemplate.queryForObject(UserMasterQueryUtil.INSERT_COMPANY_USER_IDnew, Integer.class,
				companyCode, userId, 0,""+mode+"");
		
		}catch(Exception e){
			e.printStackTrace();
	
		}
		return;
	}
*/
		
	}


