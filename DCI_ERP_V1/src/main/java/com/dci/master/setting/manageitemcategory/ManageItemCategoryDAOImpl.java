package com.dci.master.setting.manageitemcategory;

import java.sql.Types;
import java.util.ArrayList;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CommonUtil;
import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")
public class ManageItemCategoryDAOImpl implements ManageItemCategoryDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(ManageItemCategoryDAOImpl.class);
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	UserLogDAO userlogDao;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<ManageItemCategoryBean> getItemCategoryList() throws Exception {
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<ManageItemCategoryBean> manageItemCategoryList = new ArrayList<ManageItemCategoryBean>();
		try {
			manageItemCategoryList = jdbcTemplate.query(ManageItemCategoryQueryUtil.GetManageItemCategoryList, new BeanPropertyRowMapper<ManageItemCategoryBean>(ManageItemCategoryBean.class), user.getCompanyCode());
			return manageItemCategoryList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean deleteItemCategory(int itemCategoryId) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean issucces = false;
		int value = 0, accountValue = 0, propertyValue = 0;
		
		ManageItemCategoryBean bean = getItemCategoryEditList(itemCategoryId);
		try {
			bean.setTableName("Manage Item Category");
			bean.setFormCode("F3024");
			accountValue = jdbcTemplate.update(ManageItemCategoryQueryUtil.sDeleteItemCategoryAccount, itemCategoryId);
			propertyValue = jdbcTemplate.update(ManageItemCategoryQueryUtil.sDeleteItemCategoryProperty, itemCategoryId);
			jdbcTemplate.update(ManageItemCategoryQueryUtil.sDeletegrnAttribute, itemCategoryId);
			value = jdbcTemplate.update(ManageItemCategoryQueryUtil.sDeleteItemCategory, itemCategoryId);
			userlogDao.userLogForDelete(bean, itemCategoryId + "", userDetails.getUserId());
			if (value != 0) {
				issucces = true;
			}
		} catch (Exception e) {
			LOGGER.error("Error in Delete", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		return issucces;
	}

	@Override
	public ManageItemCategoryResultBean getCategoryList() throws Exception {
		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<ManageItemCategoryBean> categoryList = new ArrayList<ManageItemCategoryBean>();
		try {
			categoryList = jdbcTemplate.query(ManageItemCategoryQueryUtil.sGetCategoryList, new BeanPropertyRowMapper<ManageItemCategoryBean>(ManageItemCategoryBean.class));
			objManageItemCategoryResultBean.setCategoryList(categoryList);
			objManageItemCategoryResultBean.setSuccess(true);
			return objManageItemCategoryResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Category List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ManageItemCategoryResultBean getPurchaseList() throws Exception {
		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<ManageItemCategoryBean> purchaseList = new ArrayList<ManageItemCategoryBean>();
		try {
			purchaseList = jdbcTemplate.query(ManageItemCategoryQueryUtil.sGetPurchaseList, new BeanPropertyRowMapper<ManageItemCategoryBean>(ManageItemCategoryBean.class));
			objManageItemCategoryResultBean.setPurchaseList(purchaseList);
			objManageItemCategoryResultBean.setSuccess(true);
			return objManageItemCategoryResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Purchase List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ManageItemCategoryResultBean getSalesList() throws Exception {
		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<ManageItemCategoryBean> salesList = new ArrayList<ManageItemCategoryBean>();
		try {
			salesList = jdbcTemplate.query(ManageItemCategoryQueryUtil.sGetSalesList, new BeanPropertyRowMapper<ManageItemCategoryBean>(ManageItemCategoryBean.class));
			objManageItemCategoryResultBean.setSalesList(salesList);
			objManageItemCategoryResultBean.setSuccess(true);
			return objManageItemCategoryResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Sales List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ManageItemCategoryResultBean getParentCategoryList() throws Exception {
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		List<ManageItemCategoryBean> parentCategoryList = new ArrayList<ManageItemCategoryBean>();
		try {
			parentCategoryList = jdbcTemplate.query(ManageItemCategoryQueryUtil.sGetParentCategoryList, new BeanPropertyRowMapper<ManageItemCategoryBean>(ManageItemCategoryBean.class), user.getCompanyCode());
			objManageItemCategoryResultBean.setParentCategoryList(parentCategoryList);
			objManageItemCategoryResultBean.setSuccess(true);
			return objManageItemCategoryResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Parent Category List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ManageItemCategoryResultBean getIncomeAccountList() throws Exception {
		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<ManageItemCategoryBean> incomeAccountList = new ArrayList<ManageItemCategoryBean>();
		try {
			incomeAccountList = jdbcTemplate.query(ManageItemCategoryQueryUtil.sGetIncomeAccountList, new BeanPropertyRowMapper<ManageItemCategoryBean>(ManageItemCategoryBean.class));
			objManageItemCategoryResultBean.setIncomeAccountList(incomeAccountList);
			objManageItemCategoryResultBean.setSuccess(true);
			return objManageItemCategoryResultBean;

		} catch (Exception e) {
			LOGGER.error("Error in Parent Category List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ManageItemCategoryResultBean getExpenseAccountList() throws Exception {
		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<ManageItemCategoryBean> expenseAccountList = new ArrayList<ManageItemCategoryBean>();
		try {
			expenseAccountList = jdbcTemplate.query(ManageItemCategoryQueryUtil.sGetExpenseAccountList, new BeanPropertyRowMapper<ManageItemCategoryBean>(ManageItemCategoryBean.class));
			objManageItemCategoryResultBean.setExpenseAccountList(expenseAccountList);
			objManageItemCategoryResultBean.setSuccess(true);
			return objManageItemCategoryResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Expense Account List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean addItemCategory(ManageItemCategoryPropertyBean objItemCategoryBean) throws Exception {

		boolean issucces = false;
		int value = 0, itemCategoryId = 0, propertyValue = 0, parId = 0, detailValue = 0;
		String parentCategory = "", parentId = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		ManageItemCategoryBean bean = new ManageItemCategoryBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


		try {
			objItemCategoryBean.setTableName("item_category");
			objItemCategoryBean.setFormCode("F3024");

			java.sql.Timestamp date = CommonUtil.getCurrentTimeStamp();

			UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (objItemCategoryBean.getParentCategoryId() != "" && objItemCategoryBean.getParentCategoryId() != null) {
				parentCategory = objItemCategoryBean.getParentCategoryId();
			} else {
				parentCategory = null;
			}

			boolean qualityCheck = false;
			if (objItemCategoryBean.getQualityCheck().equalsIgnoreCase("Y")) {
				qualityCheck = true;
			}

			boolean batchNo = false;
			if (objItemCategoryBean.getBatchNo().equalsIgnoreCase("Y")) {
				batchNo = true;
			}

			boolean mrp = false;
			if (objItemCategoryBean.getMrp().equalsIgnoreCase("Y")) {
				mrp = true;
			}

			boolean expiryDate = false;
			if (objItemCategoryBean.getExpiryDate().equalsIgnoreCase("Y")) {
				expiryDate = true;
			}

			boolean manufactureDetails = false;
			if (objItemCategoryBean.getManufactureDetails().equalsIgnoreCase("Y")) {
				manufactureDetails = true;
			}

			if (parentCategory != null) {
				int[] types = new int[] { Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.DATE, Types.BOOLEAN, Types.VARCHAR };
				Object[] params = new Object[] { objItemCategoryBean.getCategoryName(), objItemCategoryBean.getCategoryTypeId(), Integer.parseInt(parentCategory), user.getUserId(), date, qualityCheck, user.getCompanyCode() };

				itemCategoryId = jdbcTemplate.queryForObject(ManageItemCategoryQueryUtil.sAddItemCategory, params, types, Integer.class);
			} else {
				int[] types = new int[] { Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.DATE, Types.BOOLEAN, Types.VARCHAR };
				Object[] params = new Object[] { objItemCategoryBean.getCategoryName(), objItemCategoryBean.getCategoryTypeId(), parentId, user.getUserId(), date, qualityCheck, user.getCompanyCode() };

				itemCategoryId = jdbcTemplate.queryForObject(ManageItemCategoryQueryUtil.sAddItemCategory, params, types, Integer.class);
			}
			userlogDao.userLogForInsert(objItemCategoryBean, itemCategoryId + "", userDetails.getUserId());

			if (itemCategoryId != 0) {

				int[] types1 = new int[] { Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER };
				Object[] params1 = new Object[] { itemCategoryId, objItemCategoryBean.getPurchaseTaxesId(), objItemCategoryBean.getSalesTaxesId(), objItemCategoryBean.getIncomeAccountId(), objItemCategoryBean.getExpenseAccountId() };

				value = jdbcTemplate.update(ManageItemCategoryQueryUtil.sAddItemCategoryAccount, params1, types1);

				int[] types2 = new int[] { Types.INTEGER, Types.BOOLEAN, Types.BOOLEAN, Types.BOOLEAN, Types.BOOLEAN };
				Object[] params2 = new Object[] { itemCategoryId, batchNo, mrp, expiryDate, manufactureDetails };

				detailValue = jdbcTemplate.update(ManageItemCategoryQueryUtil.sAddItemCategoryGrnAttribute, params2, types2);

				propertyValue = insertItemProperty(objItemCategoryBean, itemCategoryId);

				if (propertyValue != 0) {
					issucces = true;
				}
				issucces = true;
			}
			

		} catch (Exception e) {
			LOGGER.error("Error in Add Item Category", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return issucces;

	}

	private int insertItemProperty(ManageItemCategoryPropertyBean objItemCategoryBean, int itemCategoryId) throws CustomException {

		int propertyValue = 0;


		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			if (objItemCategoryBean.getPropertyDetailList().size() > 0) {
				List<ManageItemCategoryPropertyBean> lproperty = objItemCategoryBean.getPropertyDetailList();

				for (int index = 0; index < lproperty.size(); index++) {

					int[] types = new int[] { Types.INTEGER, Types.INTEGER };
					Object[] params = new Object[] { itemCategoryId, Integer.valueOf(lproperty.get(index).getItemPropertiesId()) };

					propertyValue = jdbcTemplate.update(ManageItemCategoryQueryUtil.sAddItemProperty, params, types);

					if (propertyValue != 0) {
						propertyValue = 1;
					}

				}
			}

		} catch (Exception e) {
			LOGGER.error("Error in Add Item Category", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return propertyValue;

	}

	@Override
	public ManageItemCategoryBean getItemCategoryEditList(int itemCategoryId) throws Exception {

		ManageItemCategoryBean objItemCategoryBean = new ManageItemCategoryBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		try {
			
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ManageItemCategoryQueryUtil.sGetItemCategoryEditList, new Object[] { itemCategoryId });

			for (Map row : rows) {

				String itemCategory = String.valueOf((int) row.get("itemCategoryId"));
				objItemCategoryBean.setItemCategoryId(itemCategory);
				objItemCategoryBean.setCategoryName((String) row.get("categoryName"));

				String categoryTypeId = String.valueOf((int) row.get("categoryTypeId"));
				objItemCategoryBean.setCategoryTypeId(categoryTypeId);

				if ((int) row.get("parentCategoryId") != 0) {
					objItemCategoryBean.setParentCategoryId(String.valueOf((int) row.get("parentCategoryId")));
				} else {
					objItemCategoryBean.setParentCategoryId("");
				}

				String qualityCheck = String.valueOf((boolean) row.get("qualityCheck"));
				objItemCategoryBean.setQualityCheck(qualityCheck);

			}

			List<Map<String, Object>> rows1 = jdbcTemplate.queryForList(ManageItemCategoryQueryUtil.sGetItemCategoryAccountEditList, new Object[] { itemCategoryId });

			for (Map row : rows1) {

				String itemCategoryAccountId = String.valueOf((int) row.get("itemCategoryAccountId"));
				objItemCategoryBean.setItemCategoryAccountId(itemCategoryAccountId);
				String itemCategory = String.valueOf((int) row.get("itemCategoryId"));
				objItemCategoryBean.setItemCategoryId(itemCategory);
				String purchaseTaxId = String.valueOf((int) row.get("purchaseTaxId"));
				objItemCategoryBean.setPurchaseTaxesId(purchaseTaxId);
				String salesTaxesId = String.valueOf((int) row.get("salesTaxesId"));
				objItemCategoryBean.setSalesTaxesId(salesTaxesId);
				objItemCategoryBean.setIncomeAccountId((String) row.get("incomeAccountId"));
				objItemCategoryBean.setExpenseAccountId((String) row.get("expenseAccountId"));

			}

			List<Map<String, Object>> rows2 = jdbcTemplate.queryForList(ManageItemCategoryQueryUtil.sGetItemCategoryGrnAttributeEditList, new Object[] { itemCategoryId });

			for (Map row : rows2) {

				String batchNo = String.valueOf((boolean) row.get("batchNo"));
				objItemCategoryBean.setBatchNo(batchNo);
				String mrp = String.valueOf((boolean) row.get("mrp"));
				objItemCategoryBean.setMrp(mrp);
				String expiryDate = String.valueOf((boolean) row.get("expiryDate"));
				objItemCategoryBean.setExpiryDate(expiryDate);
				String manufactureDetails = String.valueOf((boolean) row.get("manufactureDetails"));
				objItemCategoryBean.setManufactureDetails(manufactureDetails);

				String grnAttributeId = String.valueOf((int) row.get("grnAttributeId"));
				objItemCategoryBean.setGrnAttributeId(grnAttributeId);

			}

			List<ItemPropertiesBean> manageItemPropertiesList = jdbcTemplate.query(ManageItemCategoryQueryUtil.GetManageItemPropertiesList, new BeanPropertyRowMapper<ItemPropertiesBean>(ItemPropertiesBean.class), new Object[] { itemCategoryId });
			objItemCategoryBean.setManageItemPropertiesList(manageItemPropertiesList);

		} catch (Exception e) {
			LOGGER.error("Error in Get item Category Edit List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return objItemCategoryBean;
	}

	@Override
	public ManageItemCategoryResultBean getPropertyList() throws Exception {
		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		List<ManageItemCategoryBean> propertyList = new ArrayList<ManageItemCategoryBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			propertyList = jdbcTemplate.query(ManageItemCategoryQueryUtil.sGetPropertyList, new BeanPropertyRowMapper<ManageItemCategoryBean>(ManageItemCategoryBean.class));
			objManageItemCategoryResultBean.setPropertyList(propertyList);
			objManageItemCategoryResultBean.setSuccess(true);
			return objManageItemCategoryResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Expense Account List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<ItemPropertiesBean> getItemPropertiesDetail(int propertyTypeId) throws Exception {
		List<ItemPropertiesBean> detail = new ArrayList<>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


		detail = jdbcTemplate.query(ManageItemCategoryQueryUtil.GET_ITEM_PROPERTY_LIST, new Object[] { propertyTypeId, userDetails.getCompanyCode() }, new BeanPropertyRowMapper<ItemPropertiesBean>(ItemPropertiesBean.class));
		return detail;
	}

	@Override
	public boolean updateItemCategory(ManageItemCategoryPropertyBean objItemCategoryBean) throws Exception {

		boolean issucces = false;
		int value = 0, itemCategoryId = 0, propertyValue = 0, parId = 0, detailValue = 0;
		String parentCategory = "", parentId = null;
		ManageItemCategoryBean bean = getItemCategoryEditList(Integer.parseInt(objItemCategoryBean.getItemCategoryId()));
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			objItemCategoryBean.setTableName("Manage Item Category");
			objItemCategoryBean.setFormCode("F3024");
			java.sql.Timestamp date = CommonUtil.getCurrentTimeStamp();

			UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			if (objItemCategoryBean.getParentCategoryId() != "" && objItemCategoryBean.getParentCategoryId() != null && Integer.parseInt(objItemCategoryBean.getParentCategoryId()) != 0) {
				parentCategory = objItemCategoryBean.getParentCategoryId();
			} else {
				parentCategory = null;
			}

			boolean qualityCheck = false;
			if (objItemCategoryBean.getQualityCheck().equalsIgnoreCase("Y")) {
				qualityCheck = true;
			}

			boolean batchNo = false;
			if (objItemCategoryBean.getBatchNo().equalsIgnoreCase("Y")) {
				batchNo = true;
			}

			boolean mrp = false;
			if (objItemCategoryBean.getMrp().equalsIgnoreCase("Y")) {
				mrp = true;
			}

			boolean expiryDate = false;
			if (objItemCategoryBean.getExpiryDate().equalsIgnoreCase("Y")) {
				expiryDate = true;
			}

			boolean manufactureDetails = false;
			if (objItemCategoryBean.getManufactureDetails().equalsIgnoreCase("Y")) {
				manufactureDetails = true;
			}

			if (parentCategory != null) {

				int[] types = new int[] { Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.DATE, Types.BOOLEAN, Types.INTEGER };
				Object[] params = new Object[] { objItemCategoryBean.getCategoryName(), objItemCategoryBean.getCategoryTypeId(), Integer.valueOf(parentCategory), user.getUserId(), date, qualityCheck, objItemCategoryBean.getItemCategoryId() };

				value = jdbcTemplate.update(ManageItemCategoryQueryUtil.sUpdateItemCategory, params, types);

			} else {

				int[] types = new int[] { Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.DATE, Types.BOOLEAN, Types.INTEGER };
				Object[] params = new Object[] { objItemCategoryBean.getCategoryName(), objItemCategoryBean.getCategoryTypeId(), parentId, user.getUserId(), date, qualityCheck, objItemCategoryBean.getItemCategoryId() };

				value = jdbcTemplate.update(ManageItemCategoryQueryUtil.sUpdateItemCategory, params, types);

			}
			
			userlogDao.userLogForUpdate(bean,objItemCategoryBean, objItemCategoryBean.getItemCategoryId() + "", userDetails.getUserId());

			if (value != 0) {

				int[] types1 = new int[] { Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER };
				Object[] params1 = new Object[] { objItemCategoryBean.getItemCategoryId(), objItemCategoryBean.getPurchaseTaxesId(), objItemCategoryBean.getSalesTaxesId(), objItemCategoryBean.getIncomeAccountId(), objItemCategoryBean.getExpenseAccountId(), objItemCategoryBean.getItemCategoryAccountId() };

				value = jdbcTemplate.update(ManageItemCategoryQueryUtil.sUpdateItemCategoryAccount, params1, types1);

				int[] types2 = new int[] { Types.INTEGER, Types.BOOLEAN, Types.BOOLEAN, Types.BOOLEAN, Types.BOOLEAN, Types.INTEGER };
				Object[] params2 = new Object[] { objItemCategoryBean.getItemCategoryId(), batchNo, mrp, expiryDate, manufactureDetails, objItemCategoryBean.getGrnAttributeId() };

				detailValue = jdbcTemplate.update(ManageItemCategoryQueryUtil.sUpdateItemCategoryGrnAttribute, params2, types2);

			}

			propertyValue = updateItemProperty(objItemCategoryBean);

			if (propertyValue != 0) {
				issucces = true;
			}

			issucces = true;
		} catch (Exception e) {
			LOGGER.error("Error in Update Item Category", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return issucces;

	}

	private int updateItemProperty(ManageItemCategoryPropertyBean objItemCategoryBean) throws CustomException {

		int propertyValue = 0;
		int itemCategoryPropertyId = 0;

		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			if (objItemCategoryBean.getPropertyDetailList().size() > 0) {
				List<ManageItemCategoryPropertyBean> lproperty = objItemCategoryBean.getPropertyDetailList();

				for (int index = 0; index < lproperty.size(); index++) {

					if (lproperty.get(index).getItemCategoryPropertyId() != null && lproperty.get(index).getItemCategoryPropertyId() != "") {
						itemCategoryPropertyId = Integer.valueOf(lproperty.get(index).getItemCategoryPropertyId());
					} else {
						itemCategoryPropertyId = 0;
					}

					if (itemCategoryPropertyId != 0) {

						int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.INTEGER };
						Object[] params = new Object[] { objItemCategoryBean.getItemCategoryId(), Integer.valueOf(lproperty.get(index).getItemPropertiesId()), Integer.valueOf(lproperty.get(index).getItemCategoryPropertyId()) };

						propertyValue = jdbcTemplate.update(ManageItemCategoryQueryUtil.sUpdateItemProperty, params, types);

						if (propertyValue != 0) {
							propertyValue = 1;
						}

					} else {

						int[] types = new int[] { Types.INTEGER, Types.INTEGER };
						Object[] params = new Object[] { objItemCategoryBean.getItemCategoryId(), Integer.valueOf(lproperty.get(index).getItemPropertiesId()) };

						propertyValue = jdbcTemplate.update(ManageItemCategoryQueryUtil.sAddItemProperty, params, types);

						if (propertyValue != 0) {
							propertyValue = 1;
						}

					}
				}

				int j = 0;
				for (ManageItemCategoryPropertyBean manageItemCategoryPropertyBean : objItemCategoryBean.getDeletedIds()) {

					j = jdbcTemplate.update(ManageItemCategoryQueryUtil.sDeleteItemCategoryIdProperty, Integer.parseInt(manageItemCategoryPropertyBean.getItemCategoryPropertyId()));
				}

			}

		} catch (Exception e) {
			LOGGER.error("Error in Add Item Category", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return propertyValue;

	}

	@Override
	public int checkCatgeoryName(String categoryName) throws Exception {
		int categoryId = 0;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {

			categoryId = jdbcTemplate.queryForObject(ManageItemCategoryQueryUtil.sCheckCategoryName, Integer.class  ,categoryName );

		} catch (DataAccessException e) {
			LOGGER.error("Error in Check Category Name", e);
		}

		return categoryId;

	}

	@Override
	public ManageItemCategoryResultBean getGrnAttributeList(String parentCategoryId) throws Exception {
		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		List<ManageItemCategoryBean> grnAttributeList = new ArrayList<ManageItemCategoryBean>();
		int grnId = 0, itemId = 0;
		String grnAttributeName = "";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


		try {

			List<Map<String, Object>> rows2 = jdbcTemplate.queryForList(ManageItemCategoryQueryUtil.sGetItemCategoryGrnId, new Object[] { Integer.valueOf(parentCategoryId) });

			for (Map row : rows2) {
				grnId = (int) row.get("parentCategoryId");
				grnAttributeName = (String) row.get("parentCategoryName");
			}

			String grnName = "";
			if (grnAttributeName.indexOf("/") != -1) {
				String grn[] = grnAttributeName.split("/");
				grnName = grn[0];
			} else {
				grnName = grnAttributeName;
			}

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ManageItemCategoryQueryUtil.sGetItemCategoryGrn, new Object[] { grnName.trim() });

			for (Map row : rows) {
				itemId = (int) row.get("item_category_id");
			}

			grnAttributeList = jdbcTemplate.query(ManageItemCategoryQueryUtil.SELECT_GRN_ATTRIBUTE_LIST, new BeanPropertyRowMapper<ManageItemCategoryBean>(ManageItemCategoryBean.class), new Object[] { itemId });
			objManageItemCategoryResultBean.setGrnAttributeList(grnAttributeList);
			objManageItemCategoryResultBean.setSuccess(true);
			return objManageItemCategoryResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}
}
