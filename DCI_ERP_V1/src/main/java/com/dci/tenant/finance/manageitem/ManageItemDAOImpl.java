package com.dci.tenant.finance.manageitem;

import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.CommonUtilityBean;
import com.dci.common.util.CommonUtil;
import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.finance.inventoryRprt.InventoryRprtBean;
import com.dci.tenant.user.UserDetail;

@Repository
public class ManageItemDAOImpl implements ManageItemDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(ManageItemDAOImpl.class);

	@Autowired
	DataSource dataSource;

	@Override
	public ManageItemResultBean getManageItemList() {
		//UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<ManageItemBean> alResult = new ArrayList();
		ManageItemResultBean objbean = new ManageItemResultBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			alResult = jdbcTemplate.query(ManageItemQueryTable.sGetManageItemList, new BeanPropertyRowMapper<>(ManageItemBean.class), userDtl.getUserId());
			objbean.setItemList(alResult);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return objbean;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getItemCtaegoryList() {
		List alResult = new ArrayList();
		ManageItemBean objbean = null;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ManageItemQueryTable.sGetItemCategoryList);
			for (Map<String, Object> row : rows) {
				objbean = new ManageItemBean();
				objbean.setItemCategoryId(Integer.parseInt(String.valueOf(row.get("itemCategoryId"))));
				objbean.setId(Integer.parseInt(String.valueOf(row.get("itemCategoryId"))));
				objbean.setText(String.valueOf(row.get("text")));
				objbean.setItemCategorytype(String.valueOf(row.get("itemCategorytype")));
				alResult.add(objbean);
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return alResult;
	}

	@Override
	public List getEntityList() {
		List alResult = new ArrayList();
		ManageItemBean objbean = null;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ManageItemQueryTable.sGetEntityList);
			for (Map<String, Object> row : rows) {
				objbean = new ManageItemBean();

				objbean.setId(Integer.parseInt(String.valueOf(row.get("entity_id"))));
				objbean.setText(String.valueOf(row.get("entity_name")));
				alResult.add(objbean);
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return alResult;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getUOmList() {
		List alResult = new ArrayList();
		ManageItemBean objbean = null;
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ManageItemQueryTable.sGetUomList);
			for (Map<String, Object> row : rows) {
				objbean = new ManageItemBean();
				objbean.setUomId(Integer.parseInt(String.valueOf(row.get("uom_id"))));
				objbean.setUom(String.valueOf(row.get("uom")));
				objbean.setId(Integer.parseInt(String.valueOf(row.get("uom_id"))));
				objbean.setText((String.valueOf(row.get("uom"))));
				alResult.add(objbean);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return alResult;
	}

	@Override
	public boolean insertManageItemDetails(ManageItemBean objManageItem) {
		boolean isSuccess = false;
		int itemId = 0;
		String createdBy = "";
		String purchase = null;
		Object[] params = null;

		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			createdBy = userDetails.getUserId();

			java.sql.Timestamp date = getCurrentTimeStamp();
			if (objManageItem.isSaleable && objManageItem.isPurchaseable) {
				params = new Object[] { objManageItem.getItemCode(), objManageItem.getItemName(), objManageItem.getItemDescription(), objManageItem.getItemTypeId(), objManageItem.getItemCategoryId(), objManageItem.getDefaultrate(), objManageItem.isSaleable(), objManageItem.isPurchaseable(), objManageItem.isAutoIssue(), objManageItem.isServiceType(), objManageItem.getPurchaseId(), objManageItem.getUomId(), objManageItem.isRequestable(), objManageItem.getMaxQuantity(), objManageItem.getMinQuantity(), objManageItem.getReorderLevel(),
						objManageItem.getCostingId(), objManageItem.getCostPrice(), objManageItem.getWarranty(), objManageItem.getInventoryValuationId(), objManageItem.getIssueId(), createdBy, date, createdBy, Integer.parseInt(objManageItem.getLeadTime()), objManageItem.getTax(), objManageItem.getCgst(), objManageItem.getSgst(), objManageItem.getIgst(), objManageItem.getOpeningQty(), objManageItem.getOpeningQty(), objManageItem.getAltuom(), objManageItem.getAltqty() };
			} else if (objManageItem.isSaleable) {
				objManageItem.setMinQuantity(0);
				objManageItem.setMaxQuantity(0);
				objManageItem.setReorderLevel("0");
				objManageItem.setRequestable(false);
				
				if(objManageItem.getLeadTime() == ""){
					objManageItem.setLeadTime("0");
				}
				params = new Object[] { objManageItem.getItemCode(), objManageItem.getItemName(), objManageItem.getItemDescription(), objManageItem.getItemTypeId(), objManageItem.getItemCategoryId(), objManageItem.getDefaultrate(), objManageItem.isSaleable(), objManageItem.isPurchaseable(), objManageItem.isAutoIssue(), objManageItem.isServiceType(), purchase, purchase, objManageItem.isRequestable(), objManageItem.getMaxQuantity(), objManageItem.getMinQuantity(), objManageItem.getReorderLevel(), objManageItem.getCostingId(),
						objManageItem.getCostPrice(), objManageItem.getWarranty(), objManageItem.getInventoryValuationId(), objManageItem.getIssueId(), createdBy, date, createdBy, Integer.parseInt(objManageItem.getLeadTime()), objManageItem.getTax(), objManageItem.getCgst(), objManageItem.getSgst(), objManageItem.getIgst(), objManageItem.getOpeningQty(), objManageItem.getOpeningQty(), objManageItem.getAltuom(), objManageItem.getAltqty() };

			} else if (objManageItem.isPurchaseable) {
				objManageItem.setCostPrice(0.0);
				objManageItem.setWarranty(0);
				objManageItem.setLeadTime("0");
				params = new Object[] { objManageItem.getItemCode(), objManageItem.getItemName(), objManageItem.getItemDescription(), objManageItem.getItemTypeId(), objManageItem.getItemCategoryId(), objManageItem.getDefaultrate(), objManageItem.isSaleable(), objManageItem.isPurchaseable(), objManageItem.isAutoIssue(), objManageItem.isServiceType(), objManageItem.getPurchaseId(), objManageItem.getUomId(), objManageItem.isRequestable(), objManageItem.getMaxQuantity(), objManageItem.getMinQuantity(), objManageItem.getReorderLevel(), purchase,
						objManageItem.getCostPrice(), objManageItem.getWarranty(), objManageItem.getInventoryValuationId(), objManageItem.getIssueId(), createdBy, date, userDetails.getCompanyCode(), Integer.parseInt(objManageItem.getLeadTime()), objManageItem.getTax(), objManageItem.getCgst(), objManageItem.getSgst(), objManageItem.getIgst(), objManageItem.getOpeningQty(), objManageItem.getOpeningQty(), objManageItem.getAltuom(), objManageItem.getAltqty() };
			}
			itemId = jdbcTemplate.queryForObject(ManageItemQueryTable.sInsertManageItemMasterHDR, params, Integer.class);

			if (itemId != 0) {
				jdbcTemplate.update(ManageItemQueryTable.sInsertGRnAttributeDetails, itemId, objManageItem.isBatch(), objManageItem.isMrp(), objManageItem.isExpiry(), objManageItem.isManfactureDetails());
				isSuccess = true;

			}
			if (objManageItem.getLmanageitemvendor().size() > 0) {
				List<ManageItemVendorBean> litemVendor = objManageItem.getLmanageitemvendor();
				isSuccess = insertItemVendorDetails(litemVendor, itemId, createdBy);
			}

			if (objManageItem.getSpecificationList().size() > 0) {
				List<ManageItemBean> lspecification = objManageItem.getSpecificationList();
				isSuccess = insertItemSpecificationDetails(lspecification, itemId);
			}

			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	private boolean insertItemSpecificationDetails(List<ManageItemBean> lspecification, int itemId) {
		boolean isSucces = false;
		int value = 0;
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			for (int index = 0; index < lspecification.size(); index++) {
				int attributeId = Integer.valueOf(lspecification.get(index).getAttributeId());
				String attributeValue = lspecification.get(index).getAttributevalue();

				int[] types = new int[] { Types.INTEGER, Types.VARCHAR, Types.INTEGER };
				Object[] params = new Object[] { attributeId, attributeValue, itemId };
				value = jdbcTemplate.update(ManageItemQueryTable.sInsertItemSpecificationDetails, params, types);
				if (value > 0) {
					isSucces = true;
				}

			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return isSucces;
	}

	private boolean insertItemVendorDetails(List<ManageItemVendorBean> litemVendor, int itemId, String createdBy) {
		boolean isSucces = false;
		int value = 0, minQty = 0, leadDays = 0;
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			for (int index = 0; index < litemVendor.size(); index++) {

				int entityId = litemVendor.get(index).getEntityId();
				String vendorCode = litemVendor.get(index).getVendorItemCode();
				String vendorName = litemVendor.get(index).getVendorItemName();

				if (!"".equalsIgnoreCase(litemVendor.get(index).getVendorMinimumQuantity()) && litemVendor.get(index).getVendorMinimumQuantity() != null)
					minQty = Integer.parseInt(litemVendor.get(index).getVendorMinimumQuantity());
				else
					minQty = 0;

				int uom = litemVendor.get(index).getVendorUom();
				int pricingId = litemVendor.get(index).getPricingType();

				if (!"".equalsIgnoreCase(litemVendor.get(index).getVendorMinimumQuantity()) && litemVendor.get(index).getVendorMinimumQuantity() != null)
					leadDays = Integer.parseInt(litemVendor.get(index).getVendorLeadTime());
				else
					leadDays = 0;

				java.sql.Timestamp createddate = getCurrentTimeStamp();
				int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.TIMESTAMP };
				Object[] params = new Object[] { itemId, entityId, vendorCode, vendorName, minQty, uom, pricingId, leadDays, createdBy, createddate };
				value = jdbcTemplate.update(ManageItemQueryTable.sInsertVendorMasterDetails, params, types);
				if (value > 0) {
					isSucces = true;
				}

			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return isSucces;
	}

	@Override
	public boolean updateManageItemDetails(ManageItemBean objManageItem) {
		boolean isSuccess = false;
		int value = 0;
		String modifiedbY = "";
		Object[] params = null;
		String purchase = null;

		try {
			//UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			modifiedbY = userDetails.getUserId();

			java.sql.Timestamp modifieddate = getCurrentTimeStamp();

			if (objManageItem.isSaleable && objManageItem.isPurchaseable) {
				params = new Object[] { objManageItem.getItemCode(), objManageItem.getItemName(), objManageItem.getItemDescription(), objManageItem.getItemTypeId(), objManageItem.getItemCategoryId(), objManageItem.getDefaultrate(), objManageItem.isSaleable(), objManageItem.isPurchaseable(), objManageItem.isAutoIssue(), objManageItem.isServiceType(), objManageItem.getPurchaseId(), objManageItem.getUomId(), objManageItem.isRequestable(), objManageItem.getMaxQuantity(), objManageItem.getMinQuantity(), objManageItem.getReorderLevel(),
						objManageItem.getCostingId(), objManageItem.getCostPrice(), objManageItem.getWarranty(), objManageItem.getInventoryValuationId(), objManageItem.getIssueId(), modifiedbY, modifieddate, Integer.parseInt(objManageItem.getLeadTime()), objManageItem.getTax(), objManageItem.getCgst(), objManageItem.getSgst(), objManageItem.getIgst(), objManageItem.getOpeningQty(), objManageItem.getOpeningQty(), objManageItem.getAltuom(), objManageItem.getAltqty(), objManageItem.getItemId() };
			} else if (objManageItem.isSaleable) {
				objManageItem.setMinQuantity(0);
				objManageItem.setMaxQuantity(0);
				objManageItem.setReorderLevel("0");
				objManageItem.setRequestable(false);
				params = new Object[] { objManageItem.getItemCode(), objManageItem.getItemName(), objManageItem.getItemDescription(), objManageItem.getItemTypeId(), objManageItem.getItemCategoryId(), objManageItem.getDefaultrate(), objManageItem.isSaleable(), objManageItem.isPurchaseable(), objManageItem.isAutoIssue(), objManageItem.isServiceType(), purchase, purchase, objManageItem.isRequestable(), objManageItem.getMaxQuantity(), objManageItem.getMinQuantity(), objManageItem.getReorderLevel(), objManageItem.getCostingId(),
						objManageItem.getCostPrice(), objManageItem.getWarranty(), objManageItem.getInventoryValuationId(), objManageItem.getIssueId(), modifiedbY, modifieddate, Integer.parseInt(objManageItem.getLeadTime()), objManageItem.getTax(), objManageItem.getCgst(), objManageItem.getSgst(), objManageItem.getIgst(), objManageItem.getOpeningQty(), objManageItem.getOpeningQty(), objManageItem.getAltuom(), objManageItem.getAltqty(), objManageItem.getItemId() };
			} else if (objManageItem.isPurchaseable) {
				objManageItem.setCostPrice(0.0);
				objManageItem.setWarranty(0);
				objManageItem.setLeadTime("0");
				params = new Object[] { objManageItem.getItemCode(), objManageItem.getItemName(), objManageItem.getItemDescription(), objManageItem.getItemTypeId(), objManageItem.getItemCategoryId(), objManageItem.getDefaultrate(), objManageItem.isSaleable(), objManageItem.isPurchaseable(), objManageItem.isAutoIssue(), objManageItem.isServiceType(), objManageItem.getPurchaseId(), objManageItem.getUomId(), objManageItem.isRequestable(), objManageItem.getMaxQuantity(), objManageItem.getMinQuantity(), objManageItem.getReorderLevel(), purchase,
						objManageItem.getCostPrice(), objManageItem.getWarranty(), objManageItem.getInventoryValuationId(), objManageItem.getIssueId(), modifiedbY, modifieddate, Integer.parseInt(objManageItem.getLeadTime()), objManageItem.getTax(), objManageItem.getCgst(), objManageItem.getSgst(), objManageItem.getIgst(), objManageItem.getOpeningQty(), objManageItem.getOpeningQty(), objManageItem.getAltuom(), objManageItem.getAltqty(), objManageItem.getItemId() };
			}

			value = jdbcTemplate.update(ManageItemQueryTable.sUpdateManageItemMasterHDR, params);

			if (value >= 0) {

				jdbcTemplate.update(ManageItemQueryTable.sUpdateGrnAttributeDetails, objManageItem.isBatch(), objManageItem.isMrp(), objManageItem.isExpiry(), objManageItem.isManfactureDetails(), objManageItem.getItemId());
				isSuccess = true;

			}

			if (objManageItem.getLmanageitemvendor().size() > 0) {
				List<ManageItemVendorBean> litemVendor = objManageItem.getLmanageitemvendor();
				isSuccess = updateItemVendorDetails(litemVendor, objManageItem.getItemId(), objManageItem.getLdeleteIds(), modifiedbY);
			}

			if (objManageItem.getSpecificationList().size() > 0) {
				List<ManageItemBean> lspecification = objManageItem.getSpecificationList();
				isSuccess = updateItemSpecificationDetails(lspecification, objManageItem.getItemId());
			}

			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	private boolean updateItemSpecificationDetails(List<ManageItemBean> lspecification, int itemId) {
		boolean isSucces = false;
		int value = 0;
		int k = 0;
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			k = jdbcTemplate.update(ManageItemQueryTable.sDeletItemSpecification, itemId);

			for (int index = 0; index < lspecification.size(); index++) {
				int attributeId = Integer.valueOf(lspecification.get(index).getAttributeId());
				String attributeValue = lspecification.get(index).getAttributevalue();

				int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.INTEGER };
				Object[] params = new Object[] { attributeId, attributeValue, itemId };
				value = jdbcTemplate.update(ManageItemQueryTable.sInsertItemSpecificationDetails, attributeId, attributeValue, itemId);
				if (value > 0) {
					isSucces = true;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSucces;
	}

	private boolean updateItemVendorDetails(List<ManageItemVendorBean> litemVendor, int itemId, ArrayList<String> ldeleteIds, String modifiedbY) {
		boolean isSucces = false;
		int value = 0;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (ldeleteIds.size() > 0) {
				for (String vendorId : ldeleteIds) {
					value = jdbcTemplate.update(ManageItemQueryTable.sDeletevendorDetails, Integer.parseInt(vendorId));
				}
			}

			for (int index = 0; index < litemVendor.size(); index++) {
				int vendorId = litemVendor.get(index).getVendorId();
				if (vendorId == 0) {

					int entityId = litemVendor.get(index).getEntityId();
					String vendorCode = litemVendor.get(index).getVendorItemCode();
					String vendorName = litemVendor.get(index).getVendorItemName();
					int minQty = Integer.parseInt(litemVendor.get(index).getVendorMinimumQuantity());
					int uom = litemVendor.get(index).getVendorUom();
					int pricingId = litemVendor.get(index).getPricingType();
					int leadDays = Integer.parseInt(litemVendor.get(index).getVendorLeadTime());
					java.sql.Timestamp createddate = getCurrentTimeStamp();
					int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.TIMESTAMP };
					Object[] params = new Object[] { itemId, entityId, vendorCode, vendorName, minQty, uom, pricingId, leadDays, modifiedbY, createddate };
					value = jdbcTemplate.update(ManageItemQueryTable.sInsertVendorMasterDetails, params, types);
					// }
					if (value > 0) {
						isSucces = true;
					}

				} else if (vendorId > 0) {

					int entityId = litemVendor.get(index).getEntityId();
					String vendorCode = litemVendor.get(index).getVendorItemCode();
					String vendorName = litemVendor.get(index).getVendorItemName();
					int minQty = Integer.parseInt(litemVendor.get(index).getVendorMinimumQuantity());
					int uom = litemVendor.get(index).getVendorUom();
					int pricingId = litemVendor.get(index).getPricingType();
					int leadDays = Integer.parseInt(litemVendor.get(index).getVendorLeadTime());
					java.sql.Timestamp modifieddate = getCurrentTimeStamp();

					int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.TIMESTAMP, Types.INTEGER };
					Object[] params = new Object[] { itemId, entityId, vendorCode, vendorName, minQty, uom, pricingId, leadDays, modifiedbY, modifieddate, vendorId };
					value = jdbcTemplate.update(ManageItemQueryTable.sUpdateVendorMasterDetails, params, types);
					// }
					if (value > 0) {
						isSucces = true;
					}
				}
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return isSucces;
	}

	public static java.sql.Timestamp getCurrentDateFromString(String dateValue) {
		Date stringToDate = null;
		java.sql.Timestamp stringtodate1 = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			stringToDate = dateFormat.parse(dateValue);
			stringtodate1 = new Timestamp(stringToDate.getTime());

		} catch (Exception ae) {

		}
		return stringtodate1;
	}

	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}

	@Override
	@Transactional
	public boolean deleteItemDetails(String itemId) {
		boolean isSuccess = false;
		int value = 0;
		int itemID = Integer.valueOf(itemId);
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			value = jdbcTemplate.update(ManageItemQueryTable.sDeleteItemPropertyDetails, itemID);
			value = jdbcTemplate.update(ManageItemQueryTable.sDeleteItemGrnDetails, itemID);
			value = jdbcTemplate.update(ManageItemQueryTable.sDeleteItemvendorDetails, itemID);
			value = jdbcTemplate.update(ManageItemQueryTable.sDeleteItemHeader, itemID);
			if (value != 0) {
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@Override
	public ManageItemResultBean getEditManageItem(String itemCode) {
		int itemid = Integer.parseInt(itemCode);
		List<ManageItemVendorBean> alResult = new ArrayList();
		List<ManageItemBean> alResult1 = new ArrayList();
		List<ManageItemBean> alResult2 = new ArrayList();
		List<InventoryRprtBean> alInvcentoryRportList = new ArrayList<>();
		ManageItemResultBean objbean = new ManageItemResultBean();
		ManageItemBean objManageItemBean = new ManageItemBean();
		ManageItemVendorBean objItemVendorBean = null;
		InventoryRprtBean objInventoryRprtBean = null;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> listHeaderDetails = jdbcTemplate.queryForList(ManageItemQueryTable.sGetEditList, new Object[] { itemid });
			for (Map<String, Object> row : listHeaderDetails) {

				objManageItemBean = new ManageItemBean();
				objManageItemBean.setItemId(Integer.parseInt(String.valueOf(row.get("item_id"))));
				objManageItemBean.setItemTypeId(Integer.parseInt(String.valueOf(row.get("item_type"))));
				objManageItemBean.setItemCode(checkEmptyString(String.valueOf(row.get("item_code"))));
				objManageItemBean.setItemName(checkEmptyString(String.valueOf(row.get("item_name"))));
				objManageItemBean.setItemDescription(checkEmptyString(String.valueOf(row.get("item_description"))));
				objManageItemBean.setItemCategoryId(Integer.parseInt(String.valueOf(row.get("item_category"))));
				objManageItemBean.setDefaultrate(checkEmptyString(String.valueOf(row.get("default_rate"))));
				objManageItemBean.setPurchaseId(CommonUtil.convertNullToInteger(String.valueOf(row.get("purchase_method"))));
				objManageItemBean.setUomId(CommonUtil.convertNullToInteger(String.valueOf(row.get("uom"))));
				objManageItemBean.setMinQuantity(Double.parseDouble(String.valueOf(row.get("min_qty"))));
				objManageItemBean.setMaxQuantity(Double.parseDouble(String.valueOf(row.get("max_qty"))));
				objManageItemBean.setReorderLevel(checkEmptyString(String.valueOf(row.get("reorder_level"))));
				objManageItemBean.setCostingId(CommonUtil.convertNullToInteger(String.valueOf(row.get("costing_method"))));
				objManageItemBean.setTax((int) row.get("tax"));
				objManageItemBean.setCgst((double) row.get("cgst"));
				objManageItemBean.setSgst((double) row.get("sgst"));
				objManageItemBean.setIgst((double) row.get("igst"));
				objManageItemBean.setOpeningQty((double) row.get("opening_qty"));
				objManageItemBean.setAltuom(CommonUtil.convertNullToInteger(String.valueOf(row.get("altuom"))));
				objManageItemBean.setAltqty(convertNullToDouble(String.valueOf(row.get("altqty"))));

				List<ManageItemBean> checkITem = jdbcTemplate.query(ManageItemQueryTable.checkItemDetails, new BeanPropertyRowMapper<>(ManageItemBean.class), objManageItemBean.getItemId());

				if (checkITem.size() == 0) {
					objManageItemBean.setEditCate(true);
				} else {
					if (checkITem.size() > 0) {
						objManageItemBean.setEditCate(false);
					}

				}

				objManageItemBean.setCostPrice(Double.parseDouble(String.valueOf(row.get("cost_price"))));
				objManageItemBean.setWarranty(Integer.parseInt(String.valueOf(row.get("warranty"))));
				objManageItemBean.setInventoryValuationId(Integer.parseInt(String.valueOf(row.get("inventory_valuation"))));
				objManageItemBean.setIssueId(Integer.parseInt(String.valueOf(row.get("issue_method"))));
				objManageItemBean.setLeadTime(CommonUtil.checkEmptyString(String.valueOf((row.get("supply_lead_time")))));
				objManageItemBean.setPurchaseable(Boolean.parseBoolean(String.valueOf(row.get("is_purchasable"))));
				objManageItemBean.setRequestable(Boolean.parseBoolean(String.valueOf(row.get("is_requestable"))));
				objManageItemBean.setSaleable(Boolean.parseBoolean(String.valueOf(row.get("is_saleable"))));
				objManageItemBean.setAutoIssue(Boolean.parseBoolean(String.valueOf(row.get("is_auto"))));
				objManageItemBean.setServiceType(Boolean.parseBoolean(String.valueOf(row.get("is_service"))));
				List<Map<String, Object>> listGrnDetails = jdbcTemplate.queryForList(ManageItemQueryTable.sGetGRNEditDetails, new Object[] { itemid });
				// if (listGrnDetails.size() > 0) {
				for (Map<String, Object> row1 : listGrnDetails) {
					objManageItemBean.setMrp(Boolean.parseBoolean(String.valueOf(row1.get("mrp"))));
					objManageItemBean.setBatch(Boolean.parseBoolean(String.valueOf(row1.get("batch_no"))));
					objManageItemBean.setExpiry(Boolean.parseBoolean(String.valueOf(row1.get("expiry_date"))));
					objManageItemBean.setManfactureDetails(Boolean.parseBoolean(String.valueOf(row1.get("manufacture_details"))));
				}

				alResult1.add(objManageItemBean);

			}
			objbean.setItemList(alResult1);

			List<Map<String, Object>> listVendorDetails = jdbcTemplate.queryForList(ManageItemQueryTable.sGetVendorList, new Object[] { itemid });

			for (Map<String, Object> row : listVendorDetails) {

				objItemVendorBean = new ManageItemVendorBean();
				objItemVendorBean.setVendorId(Integer.parseInt(String.valueOf(row.get("item_vendor_id"))));
				objItemVendorBean.setEntityId(Integer.parseInt(String.valueOf(row.get("entity_id"))));
				objItemVendorBean.setVendorItemCode(checkEmptyString(String.valueOf(row.get("vendor_item_code"))));
				objItemVendorBean.setVendorItemName(checkEmptyString(String.valueOf(row.get("vendor_item_name"))));
				objItemVendorBean.setVendorMinimumQuantity(checkEmptyString(String.valueOf(row.get("vendor_min_qty"))));
				objItemVendorBean.setVendorUom(Integer.parseInt(checkEmptyString(String.valueOf(row.get("vendor_uom_id")))));
				objItemVendorBean.setVendorLeadTime(String.valueOf(row.get("delivery_lead_time")));
				objItemVendorBean.setPricingType(Integer.parseInt(String.valueOf(row.get("pricing_type"))));
				alResult.add(objItemVendorBean);

			}
			objbean.setItemvendorList(alResult);

			List<Map<String, Object>> listSpecificationDetails = jdbcTemplate.queryForList(ManageItemQueryTable.sGetSpecificationList, new Object[] { itemid });

			for (Map<String, Object> row : listSpecificationDetails) {

				objManageItemBean = new ManageItemBean();
				objManageItemBean.setItemSpecificationId(String.valueOf((int) row.get("item_property_id")));
				objManageItemBean.setAttributeId(String.valueOf((int) row.get("dynamic_attribute_id")));
				objManageItemBean.setDefaultvalue((String) row.get("dynamic_attribute_value"));

				alResult2.add(objManageItemBean);

			}
			objbean.setItemspecificationList(alResult2);

			List<Map<String, Object>> listInventoryLocation = jdbcTemplate.queryForList(ManageItemQueryTable.sGetItemBasedLocation, new Object[] { itemid });

			if (listInventoryLocation.size() > 0) {
				for (Map<String, Object> row : listInventoryLocation) {

					objInventoryRprtBean = new InventoryRprtBean();
					objInventoryRprtBean.setLocationId(Integer.parseInt(String.valueOf(row.get("locationId"))));
					objInventoryRprtBean.setLocationName(String.valueOf(row.get("locationName")));
					objInventoryRprtBean.setQty((double) row.get("qty"));
					alInvcentoryRportList.add(objInventoryRprtBean);

				}
				getInventroyListWithParam(itemid);
				objbean.setListItemLocation(getInventroyListWithParam(itemid));
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return objbean;
	}

	private List<InventoryRprtBean> getInventroyListWithParam(int item) {
		List<InventoryRprtBean> lInventoryBean = null;
		try {
			String query = "select inv.inventory_id invId,inv.inventory_date invDate,inv.location_id locationId,inv.item_id itemId,inv.quantity_available qty,pro.item_name itemName,pro.item_description itemDesc,loc.location_name locationName from inventory inv left join item_new  pro on inv.item_id = pro.item_id left join location loc on loc.location_id = inv.location_id ";
			if (item > 0) {
				query += "where inv.item_id = " + item + " order by invdate";
			}
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lInventoryBean = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(InventoryRprtBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return lInventoryBean;

	}

	public static String getCurrentDateToString(Date date) {
		String dateToString = "";
		try {
			if (date != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				dateToString = dateFormat.format(date);
			} else {
				dateToString = "";
			}
		} catch (Exception ae) {
		}
		return dateToString;
	}

	public static double convertNullToDouble(String inputString) {
		double s = 0;
		try {
			if (inputString == null || inputString.equals("null")) {
				s = 0;
			} else {
				s = Double.parseDouble(inputString);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public static String checkEmptyString(String s1) {
		if (s1 == null || s1.equalsIgnoreCase("null")) {
			return "";
		} else {
			return s1;
		}
	}

	@Override
	public ManageItemResultBean getAttributeDetails(int itemCategoryId) throws Exception {
		ManageItemResultBean objManageItemResultBean = new ManageItemResultBean();
		List<ManageItemBean> specificationList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			specificationList = jdbcTemplate.query(ManageItemQueryTable.GET_ITEM_SPECIFICATION_LIST, new BeanPropertyRowMapper<>(ManageItemBean.class), new Object[] { itemCategoryId });
			objManageItemResultBean.setSpecificationList(specificationList);
			objManageItemResultBean.setSuccess(true);
			return objManageItemResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Item Specification List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ArrayList<ManageItemBean> getGrnAttributeDetails(int itemCategoryId) {
		ArrayList<ManageItemBean> alresult = new ArrayList<>();
		ManageItemBean objBean = new ManageItemBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Map<String, Object> row = jdbcTemplate.queryForMap(ManageItemQueryTable.GET_iTEM_CATEGORY_DETAILS, new Object[] { itemCategoryId });
			if (row.size() > 0) {
				objBean.setMrp(Boolean.parseBoolean(String.valueOf(row.get("mrp"))));
				objBean.setBatch(Boolean.parseBoolean(String.valueOf(row.get("batch_no"))));
				objBean.setExpiry(Boolean.parseBoolean(String.valueOf(row.get("expiry_date"))));
				objBean.setManfactureDetails(Boolean.parseBoolean(String.valueOf(row.get("manufacture_details"))));
				alresult.add(objBean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Item Specification List", e);
		}
		return alresult;
	}

	@Override
	public ManageItemResultBean getItemConsumptionMasterList(String itm, int rdoDays) {
		ManageItemResultBean itemConsumption = new ManageItemResultBean();
		List<ManageItemBean> itemConsumptionMasterList = new ArrayList<>();
		List<ManageItemBean> itemConsumptionMax = null;
		List<ManageItemBean> itemConsumptionMin = null;
		List<ManageItemBean> itemConsumptionAvg = null;
		List<ManageItemBean> itemTotalConsumption = null;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> manageMasterList = jdbcTemplate.queryForList(ManageItemQueryTable.QTY_MASTER_LIST, new Object[] { rdoDays, 16, Integer.parseInt(itm) });
			int i = 0;
			for (Map<String, Object> row : manageMasterList) {
				ManageItemBean objManageItemBean = new ManageItemBean();
				objManageItemBean.setDocDate(String.valueOf(row.get("docDate")));
				if (!String.valueOf(row.get("qty")).equalsIgnoreCase("null")) {
					objManageItemBean.setQty((double) row.get("qty"));
					i++;
				} else {
					if (i == 0) {
						objManageItemBean.setQty(0.0);
						i++;
					} else {
						if (!String.valueOf(row.get("qty")).equalsIgnoreCase("null"))
							objManageItemBean.setQty((double) row.get("qty"));
						// objManageItemBean.setQty(checkNull(String.valueOf(row.get("qty"))));

					}
				}

				itemConsumptionMasterList.add(objManageItemBean);

			}
			itemConsumptionMax = jdbcTemplate.query(ManageItemQueryTable.QTY_MAX, new Object[] { 16, Integer.parseInt(itm) }, new BeanPropertyRowMapper<>(ManageItemBean.class));
			itemConsumptionMin = jdbcTemplate.query(ManageItemQueryTable.QTY_MIN, new Object[] { 16, Integer.parseInt(itm) }, new BeanPropertyRowMapper<>(ManageItemBean.class));
			itemConsumptionAvg = jdbcTemplate.query(ManageItemQueryTable.QTY_AVG, new Object[] { 16, Integer.parseInt(itm) }, new BeanPropertyRowMapper<>(ManageItemBean.class));
			itemTotalConsumption = jdbcTemplate.query(ManageItemQueryTable.GET_TOTAL_QTY, new BeanPropertyRowMapper<>(ManageItemBean.class));

			itemConsumption.setItemConsumptionMasterList(itemConsumptionMasterList);
			itemConsumption.setItemConsumptionMax(itemConsumptionMax);
			itemConsumption.setItemConsumptionMin(itemConsumptionMin);
			itemConsumption.setItemConsumptionAvg(itemConsumptionAvg);
			itemConsumption.setItemTotalConsumption(itemTotalConsumption);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return itemConsumption;
	}

	public static Integer checkNull(String value) {
		if (value.equalsIgnoreCase("null") || value.equalsIgnoreCase("0")) {
			return null;
		} else {
			return Integer.parseInt(value);
		}

	}

	@Override
	public int checkItemName(String checkItemName) {
		int itemId = 0;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			itemId = jdbcTemplate.queryForObject(ManageItemQueryTable.checkItemName,Integer.class ,checkItemName );

		} catch (DataAccessException e) {
			LOGGER.error("Error in Check Category Name", e);
		}

		return itemId;
	}

	@Override
	public ManageItemResultBean getUOMCategoryBasedList(int uomId) throws Exception {

		ManageItemResultBean objManageItemResultBean = new ManageItemResultBean();
		List<ManageItemBean> uomList = new ArrayList<>();
		int uomCategoryId = 0;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ManageItemQueryTable.getCategoryBasedUomId, new Object[] { uomId });
			for (Map<String, Object> row : rows) {
				uomCategoryId = (int) row.get("uomCategoryId");
			}

			if (uomCategoryId != 0) {
				uomList = jdbcTemplate.query(ManageItemQueryTable.sGetUOMCategoryBasedList, new BeanPropertyRowMapper<>(ManageItemBean.class), new Object[] { uomCategoryId });
				objManageItemResultBean.setUomList(uomList);
				objManageItemResultBean.setSuccess(true);

			} else {
				objManageItemResultBean.setUomList(uomList);
				objManageItemResultBean.setSuccess(true);
			}

			return objManageItemResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in UOM List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public int checkItemCode(String checkItemCode) throws Exception {
		int itemCode = 0;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			itemCode = jdbcTemplate.queryForObject(ManageItemQueryTable.checkItemCode, Integer.class, checkItemCode );
		} catch (Exception e) {
			LOGGER.error("Error in Check Item Code", e);
			throw new CustomException(ErrorMessage.CODE_ALREADY_EXISTS);
		}

		return itemCode;
	}

	@Override
	public boolean exportManageItemReport(String exportFilesPath, ManageItemBean ManageItemBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ManageItemBean> getExcelReport(ManageItemBean ManageItemBean) {
		// System.out.println("fromDate:::::::;;"+DPIdetailBean.getFromDate()+"::::::;toDate::::::"+objChqDepCollecBean.getToDate());
		List<ManageItemBean> lCDCMainList = new ArrayList<>();
		try {
			lCDCMainList = getChqDepoCollReport(ManageItemBean);

		} catch (DataAccessException e) {
		}
		return lCDCMainList;
	}

	@Override
	public List<ManageItemBean> getChqDepoCollReport(ManageItemBean ManageItemBean) {
		List<ManageItemBean> lChqDepoHdrList = new ArrayList<>();
		try {
			// String sQuery =
			// "select * from vw_cheque_deposit_summary1(?,?,?,?,?,?) ";
			// lChqDepoHdrList = jdbcTemplate.query(sQuery,new Object[] {
			// objChqDepCollecBean.getCompanyCodes(),objChqDepCollecBean.getPayerCodes(),objChqDepCollecBean.getServices(),
			// DPIdetailBean.getCustomerTypes(),objChqDepCollecBean.getCountryCode(),objChqDepCollecBean.getPaymentCenters()},
			// new BeanPropertyRowMapper<>(ChequeDepositCollectionBean.class));
			// System.out.println("Final Cheque Query ");
			// System.out.println(sQuery);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lChqDepoHdrList;
	}

}
