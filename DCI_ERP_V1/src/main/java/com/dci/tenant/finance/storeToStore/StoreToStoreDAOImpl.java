package com.dci.tenant.finance.storeToStore;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.common.CommonUtilityService;
import com.dci.tenant.finance.grn.GRNQueryUtil;
import com.dci.tenant.user.UserDetail;

@Repository
public class StoreToStoreDAOImpl implements StoreToStoreDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(StoreToStoreDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	//@Value("${location.virtual.consumable}")
	private String consumedLocation;

	@Autowired
	CommonUtilityService commonUtilityService;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<StoreToStore> getStoreToStoreList() throws CustomException {
		List<StoreToStore> storeToStoreList = new ArrayList<StoreToStore>();
		try {
			storeToStoreList = jdbcTemplate.query(StoreToStoreQueryUtil.SELECT_STORE_LIST, new BeanPropertyRowMapper<StoreToStore>(StoreToStore.class));
			return storeToStoreList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getStoreToStoreList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public StoreToStoreResultBean getEmployeeList() throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		StoreToStoreResultBean storeToStoreResultBean = new StoreToStoreResultBean();
		List<StoreToStore> employeeList = new ArrayList<StoreToStore>();
		List<StoreToStore> locationList = new ArrayList<StoreToStore>();
		List<StoreToStore> destlocationList = new ArrayList<StoreToStore>();
		List<StoreToStoreSubBean> itemList = new ArrayList<StoreToStoreSubBean>();
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetail user = (UserDetail) auth.getPrincipal();

			String userId = user.getUserId();
			storeToStoreResultBean.setUserId(userId);
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}
		try {
				
	//employeeList = jdbcTemplate.query(StoreToStoreQueryUtil.GET_EMPLOYEE_LIST, new BeanPropertyRowMapper<StoreToStore>(StoreToStore.class));
	
	employeeList = jdbcTemplate.query(StoreToStoreQueryUtil.GET_EMPLOYEE_LIST, new BeanPropertyRowMapper<StoreToStore>(StoreToStore.class), userDetails.getCompanyCode());

	storeToStoreResultBean.setEmployeeList(employeeList);

		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}
		try {
			locationList = jdbcTemplate.query(StoreToStoreQueryUtil.GET_SOURCELOCATION_LIST, new BeanPropertyRowMapper<StoreToStore>(StoreToStore.class));
			storeToStoreResultBean.setLocationList(locationList);
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}

		try {
			destlocationList = jdbcTemplate.query(StoreToStoreQueryUtil.GET_DESTINATIONLOCATION_LIST, new BeanPropertyRowMapper<StoreToStore>(StoreToStore.class));
			storeToStoreResultBean.setDestLocationList(destlocationList);
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}

		try {
			itemList = jdbcTemplate.query(StoreToStoreQueryUtil.GET_ITEM_LIST, new BeanPropertyRowMapper<StoreToStoreSubBean>(StoreToStoreSubBean.class));
			storeToStoreResultBean.setItemList(itemList);
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}
		// TODO Auto-generated method stub
		return storeToStoreResultBean;
	}

	@Override
	public StoreToStoreSubBean getItemList(int itemId) throws CustomException {
		StoreToStoreSubBean storeToStoreSubBean = null;
		// TODO Auto-generated method stub
		try {
			storeToStoreSubBean = jdbcTemplate.queryForObject(StoreToStoreQueryUtil.GET_ITEM_DATA_ONCHANGE, new BeanPropertyRowMapper<StoreToStoreSubBean>(StoreToStoreSubBean.class), itemId);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getItemList", e);
		}
		return storeToStoreSubBean;
	}

	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}

	@Override
	public boolean insertStoreToStore(StoreToStoreResultBean storeToStoreResultBean, String consumedLocation) throws CustomException {
		boolean isSuccess = false;
		StoreToStore headerData = storeToStoreResultBean.getHeaderData();
		List<StoreToStoreSubBean> subData = storeToStoreResultBean.getSubData();
		String requisitionNumber = null;
		int purchaseRequisitionId = 0;

		synchronized (this) {
			try {

				requisitionNumber = jdbcTemplate.queryForObject(StoreToStoreQueryUtil.GENERATE_REQ_NO, String.class);
				Integer requisitionType = headerData.getRequisitionType();
				if (requisitionNumber != null) {
					requisitionType = 119;
				}

				HashMap<String, Object> storeInsertMap = new HashMap<String, Object>();
				storeInsertMap.put("requisitionNumber", requisitionNumber);
				storeInsertMap.put("requisitionDate", headerData.getRequisitionDate());
				storeInsertMap.put("employeeId", headerData.getEmployeeId()); // RequestedBy
				storeInsertMap.put("requisitionType", requisitionType);
				storeInsertMap.put("sourceLocation", Integer.parseInt(headerData.getSourceLocation()));
				storeInsertMap.put("destinationLocation", Integer.parseInt(headerData.getDestinationLocation()));
				storeInsertMap.put("company", headerData.getCompanyId());
				purchaseRequisitionId = namedParameterJdbcTemplate.queryForObject(StoreToStoreQueryUtil.INSERT_STORE_HEADER, storeInsertMap,Integer.class);
				isSuccess = true;

			} catch (DataAccessException e) {
				LOGGER.error("Error in getItemList", e);
			}
		}

		if (isSuccess) {

			for (int j = 0; j < subData.size(); j++) {
				HashMap<String, Object> storeInsertSubMap = new HashMap<String, Object>();
				storeInsertSubMap.put("purchaseRequisitionId", purchaseRequisitionId);
				storeInsertSubMap.put("itemId", Integer.parseInt(subData.get(j).getItemId()));
				storeInsertSubMap.put("quantity", subData.get(j).getQuantity());
				storeInsertSubMap.put("eddDate", subData.get(j).getEddDate());
				storeInsertSubMap.put("physicalQty", subData.get(j).getPhysicalQty());

				if (subData.get(j).isSelect() == true) {
					int isSaved = namedParameterJdbcTemplate.update(StoreToStoreQueryUtil.INSERT_STORE_SUBDATA, storeInsertSubMap);

					if (isSaved > 0 && subData.get(j).getPhysicalQty() > 0) {

						String consLoc = "%" + consumedLocation + "%";
						int consumeLocation = jdbcTemplate.queryForObject(GRNQueryUtil.GET_TRANSIT_LOCATION, new Object[] { consLoc }, Integer.class);

						double consumQty = subData.get(j).getQuantity();

						//commonUtilityService.updateInventoryAndLedgerIn(requisitionNumber, headerData.getRequisitionDate(), 171, Integer.parseInt(headerData.getSourceLocation()), consumeLocation, Integer.parseInt(subData.get(j).getItemId()), consumQty, subData.get(j).getAttributeBeans());
						//commonUtilityService.updateInventoryAndLedgerOut(requisitionNumber, headerData.getRequisitionDate(), 171, consumeLocation, Integer.parseInt(headerData.getSourceLocation()), Integer.parseInt(subData.get(j).getItemId()), consumQty, subData.get(j).getAttributeBeans());
					}
				}

			}

			isSuccess = true;

		}

		return isSuccess;
	}

	@Override
	public StoreToStoreResultBean getStoreToStoreById(int purchaseRequisitionId) throws CustomException {
		StoreToStoreResultBean storeToStoreResultBean = new StoreToStoreResultBean();
		List<StoreToStoreSubBean> subData = new ArrayList<StoreToStoreSubBean>();
		StoreToStore headerData = new StoreToStore();
		try {

			int[] types = new int[] { Types.INTEGER };
			Object[] params = new Object[] { purchaseRequisitionId };
			Map row = jdbcTemplate.queryForMap(StoreToStoreQueryUtil.EDIT_HEADER, params, types);

			headerData.setPurchaseRequisitionId((int) row.get("purchaseRequisitionId"));
			headerData.setRequisitionNumber((String) row.get("requisitionNumber"));
			headerData.setRequisitionType((Integer) row.get("requisitionType"));
			headerData.setRequisitionDate((String) row.get("requisitionDate"));
			if (row.get("employeeId") != null) {
				headerData.setEmployeeId((String) row.get("employeeId"));
			}
			if (row.get("employeeName") != null) {
				headerData.setEmployeeName((String) row.get("employeeName"));
			}
			headerData.setDesignationId((Integer) row.get("designationId"));
			if (row.get("designationName") != null) {
				headerData.setDesignationName((String) row.get("designationName"));
			}
			headerData.setRequisitionType((Integer) row.get("requisitionType"));

			headerData.setSourceLocation(String.valueOf(row.get("sourceLocation")));
			if (row.get("sourceLocationName") != null) {
				headerData.setSourceLocationName((String) row.get("sourceLocationName"));
			}
			headerData.setDestinationLocation(String.valueOf(row.get("destinationLocation")));
			if (row.get("destinationLocationName") != null) {
				headerData.setDestinationLocationName((String) row.get("destinationLocationName"));
			}

			if (row.get("companyId") != null) {
				headerData.setCompanyId((String) row.get("companyId"));
			} else {
				headerData.setCompanyId("");
			}

			// detail
			List<Map<String, Object>> rowdetail = jdbcTemplate.queryForList(StoreToStoreQueryUtil.EDIT_DETAIL, params, types);
			for (Map row1 : rowdetail) {
				StoreToStoreSubBean storeToStoreSubBean = new StoreToStoreSubBean();
				storeToStoreSubBean.setItemId(String.valueOf(row1.get("itemId")));
				if (row1.get("itemCode") != null) {
					storeToStoreSubBean.setItemCode((String) row1.get("itemCode"));
				}
				if (row1.get("itemName") != null) {
					storeToStoreSubBean.setItemName((String) row1.get("itemName"));
				}
				if (row1.get("itemDesc") != null) {
					storeToStoreSubBean.setItemDesc((String) row1.get("itemDesc"));
				}
				storeToStoreSubBean.setItemCategoryId((Integer) row1.get("itemCategoryId"));
				if (row1.get("itemCategoryName") != null) {
					storeToStoreSubBean.setItemCategoryName((String) row1.get("itemCategoryName"));
				}
				storeToStoreSubBean.setUomId((Integer) row1.get("uomId"));
				if (row1.get("uomName") != null) {
					storeToStoreSubBean.setUomName((String) row1.get("uomName"));
				}
				storeToStoreSubBean.setQuantity((Integer) row1.get("quantity"));
				storeToStoreSubBean.setRequestedQty((Integer) row1.get("quantity"));
				if (row1.get("eddDate") != null) {
					storeToStoreSubBean.setEddDate((String) row1.get("eddDate"));
				}
				storeToStoreSubBean.setPhysicalQty((Integer) row1.get("physicalQty"));
				headerData.setPurchaseRequisitionId((int) row1.get("purchaseRequisitionId"));
				storeToStoreSubBean.setPurchaseRequisitionSubId((int) row1.get("purchaseRequisitionSubId"));
				storeToStoreSubBean.setDisableDate(true);
				subData.add(storeToStoreSubBean);

			}
			storeToStoreResultBean.setHeaderData(headerData);
			storeToStoreResultBean.setSubData(subData);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Edit store to store", e);
		}

		return storeToStoreResultBean;
	}

	@SuppressWarnings("unused")
	@Override
	public boolean updateStoreToStore(StoreToStoreResultBean storeToStoreResultBean, String consumedLocation) throws CustomException {
		boolean isSuccess = false;
		StoreToStore headerData = storeToStoreResultBean.getHeaderData();
		List<StoreToStoreSubBean> subData = storeToStoreResultBean.getSubData();
		String requisitionNumber = null;
		int purchaseRequisitionId = headerData.getPurchaseRequisitionId();

		synchronized (this) {

			try {

				Integer requisitionType = headerData.getRequisitionType();
				if (requisitionNumber != null) {
					requisitionType = 46;
				}

				HashMap<String, Object> storeInsertMap = new HashMap<String, Object>();
				storeInsertMap.put("requisitionNumber", headerData.getRequisitionNumber());
				storeInsertMap.put("requisitionDate", headerData.getRequisitionDate());
				storeInsertMap.put("employeeId", headerData.getEmployeeId()); // RequestedBy
				storeInsertMap.put("requisitionType", requisitionType);
				storeInsertMap.put("sourceLocation", Integer.parseInt(headerData.getSourceLocation()));
				storeInsertMap.put("destinationLocation", Integer.parseInt(headerData.getDestinationLocation()));
				storeInsertMap.put("company", headerData.getCompanyId());
				storeInsertMap.put("purchaseRequisitionId", purchaseRequisitionId);
				namedParameterJdbcTemplate.update(StoreToStoreQueryUtil.UPDATE_STORE_HEADER, storeInsertMap);
				isSuccess = true;

			} catch (Exception e) {
				LOGGER.error("Error in Update Store to Store Requistion", e);
			}
		}

		if (isSuccess) {

			int j = jdbcTemplate.queryForObject(StoreToStoreQueryUtil.COUNT_MAX, Integer.class, purchaseRequisitionId );

			if (j > 0) {

				boolean success = updateDeleteStoreToStore(purchaseRequisitionId);

				jdbcTemplate.update(StoreToStoreQueryUtil.DELETE_DETAIL, purchaseRequisitionId);

				for (int k = 0; k < subData.size(); k++) {

					HashMap<String, Object> storeInsertSubMap = new HashMap<String, Object>();
					storeInsertSubMap.put("purchaseRequisitionId", purchaseRequisitionId);
					storeInsertSubMap.put("itemId", Integer.parseInt(subData.get(k).getItemId()));
					storeInsertSubMap.put("quantity", subData.get(k).getQuantity());
					storeInsertSubMap.put("eddDate", subData.get(k).getEddDate());
					storeInsertSubMap.put("physicalQty", subData.get(k).getPhysicalQty());

					int isSaved = namedParameterJdbcTemplate.update(StoreToStoreQueryUtil.INSERT_STORE_SUBDATA, storeInsertSubMap);

					if (isSaved > 0) {

						String consLoc = "%" + consumedLocation + "%";

						int consumeLocation = jdbcTemplate.queryForObject(GRNQueryUtil.GET_TRANSIT_LOCATION, new Object[] { consLoc }, Integer.class);

						double consumQty = subData.get(k).getQuantity();

						//commonUtilityService.updateInventoryAndLedgerIn(requisitionNumber, headerData.getRequisitionDate(), 171, Integer.parseInt(headerData.getSourceLocation()), consumeLocation, Integer.parseInt(subData.get(k).getItemId()), consumQty, subData.get(k).getAttributeBeans());
						//commonUtilityService.updateInventoryAndLedgerOut(requisitionNumber, headerData.getRequisitionDate(), 171, consumeLocation, Integer.parseInt(headerData.getSourceLocation()), Integer.parseInt(subData.get(k).getItemId()), consumQty, subData.get(k).getAttributeBeans());
					}
				}

			}

			isSuccess = true;

		}

		return isSuccess;
	}

	@Override
	public boolean deleteStoreToStore(int purchaseRequisitionId) throws CustomException {
		boolean isDeleted = false;

		try {

			int sourceLocationId = jdbcTemplate.queryForObject(StoreToStoreQueryUtil.GET_SOURCE_LOCATION_ID, Integer.class ,purchaseRequisitionId );
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(StoreToStoreQueryUtil.GET_ITEM_AND_QTY, new Object[] { purchaseRequisitionId });

			String consLoc = "%" + consumedLocation + "%";
			int consumeLocation = jdbcTemplate.queryForObject(GRNQueryUtil.GET_TRANSIT_LOCATION, new Object[] { consLoc }, Integer.class);

			for (Map row : rows) {
				int availableQty = jdbcTemplate.queryForObject(StoreToStoreQueryUtil.CHECK_AVAILABLE_QTY_INVENTORY,Integer.class , sourceLocationId, (int) row.get("item_id") );

				availableQty = availableQty + (int) row.get("quantity");

				int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.INTEGER };
				Object[] params = new Object[] { availableQty, sourceLocationId, (int) row.get("item_id") };

				jdbcTemplate.update(StoreToStoreQueryUtil.sUpdateInventory, params, types);

				int availableQtyConsumed = jdbcTemplate.queryForObject(StoreToStoreQueryUtil.CHECK_AVAILABLE_QTY_INVENTORY, Integer.class, consumeLocation, (int) row.get("item_id") );

				availableQtyConsumed = availableQtyConsumed - (int) row.get("quantity");

				int[] typesConsumed = new int[] { Types.INTEGER, Types.INTEGER, Types.INTEGER };
				Object[] paramsConsumed = new Object[] { availableQtyConsumed, consumeLocation, (int) row.get("item_id") };

				jdbcTemplate.update(StoreToStoreQueryUtil.sUpdateInventory, paramsConsumed, typesConsumed);

				List<Map<String, Object>> rowInventory = jdbcTemplate.queryForList(StoreToStoreQueryUtil.CHECK_CONSUMED_QTY_INVENTORY, new Object[] { consumeLocation, (int) row.get("item_id") });

				for (Map rowInvent : rowInventory) {

					if ((int) rowInvent.get("stockQty") == 0) {

						List<Map<String, Object>> requisionNumber = jdbcTemplate.queryForList(StoreToStoreQueryUtil.GET_REQUISTION_NUMBER, new Object[] { purchaseRequisitionId });

						for (Map reqId : requisionNumber) {

							jdbcTemplate.update(StoreToStoreQueryUtil.DELETE_STOCK_LEDGER, (String) reqId.get("requisitionNumber"));
						}

					} else {
						List<Map<String, Object>> requisionNumber = jdbcTemplate.queryForList(StoreToStoreQueryUtil.GET_REQUISTION_NUMBER, new Object[] { purchaseRequisitionId });

						for (Map reqId : requisionNumber) {

							jdbcTemplate.update(StoreToStoreQueryUtil.DELETE_STOCK_LEDGER, (String) reqId.get("requisitionNumber"));
						}
					}
				}
			}

			jdbcTemplate.update(StoreToStoreQueryUtil.DELETE_DETAIL, purchaseRequisitionId);
			jdbcTemplate.update(StoreToStoreQueryUtil.DELETE_HEADER, purchaseRequisitionId);

			isDeleted = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete Store to store", e);
		}

		return isDeleted;
	}

	public boolean updateDeleteStoreToStore(int purchaseRequisitionId) throws CustomException {
		boolean isDeleted = false;

		try {

			int sourceLocationId = jdbcTemplate.queryForObject(StoreToStoreQueryUtil.GET_SOURCE_LOCATION_ID, Integer.class ,purchaseRequisitionId );
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(StoreToStoreQueryUtil.GET_ITEM_AND_QTY, new Object[] { purchaseRequisitionId });

			String consLoc = "%" + consumedLocation + "%";
			int consumeLocation = jdbcTemplate.queryForObject(GRNQueryUtil.GET_TRANSIT_LOCATION, new Object[] { consLoc }, Integer.class);

			for (Map row : rows) {
				int availableQty = jdbcTemplate.queryForObject(StoreToStoreQueryUtil.CHECK_AVAILABLE_QTY_INVENTORY, Integer.class ,sourceLocationId, (int) row.get("item_id") );

				availableQty = availableQty + (int) row.get("quantity");

				int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.INTEGER };
				Object[] params = new Object[] { availableQty, sourceLocationId, (int) row.get("item_id") };

				jdbcTemplate.update(StoreToStoreQueryUtil.sUpdateInventory, params, types);

				int availableQtyConsumed = jdbcTemplate.queryForObject(StoreToStoreQueryUtil.CHECK_AVAILABLE_QTY_INVENTORY, Integer.class,  consumeLocation, (int) row.get("item_id") );

				availableQtyConsumed = availableQtyConsumed - (int) row.get("quantity");

				int[] typesConsumed = new int[] { Types.INTEGER, Types.INTEGER, Types.INTEGER };
				Object[] paramsConsumed = new Object[] { availableQtyConsumed, consumeLocation, (int) row.get("item_id") };

				jdbcTemplate.update(StoreToStoreQueryUtil.sUpdateInventory, paramsConsumed, typesConsumed);

				List<Map<String, Object>> rowInventory = jdbcTemplate.queryForList(StoreToStoreQueryUtil.CHECK_CONSUMED_QTY_INVENTORY, new Object[] { consumeLocation, (int) row.get("item_id") });

				for (Map rowInvent : rowInventory) {

					if ((int) rowInvent.get("stockQty") == 0) {

						List<Map<String, Object>> requisionNumber = jdbcTemplate.queryForList(StoreToStoreQueryUtil.GET_REQUISTION_NUMBER, new Object[] { purchaseRequisitionId });

						for (Map reqId : requisionNumber) {

							jdbcTemplate.update(StoreToStoreQueryUtil.DELETE_STOCK_LEDGER, (String) reqId.get("requisitionNumber"));
						}

					}
				}
			}

			isDeleted = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete Store to store", e);
		}

		return isDeleted;
	}

	@Override
	public StoreToStoreResultBean checkQcItem(StoreToStore storeToStorebean) throws Exception {
		StoreToStoreResultBean bean = new StoreToStoreResultBean();

		List<StoreToStore> storeToStoreList = new ArrayList<StoreToStore>();
		try {
			storeToStoreList = jdbcTemplate.query(StoreToStoreQueryUtil.GET_TOTAL_QC_QUANTITY, new BeanPropertyRowMapper<StoreToStore>(StoreToStore.class), storeToStorebean.getItemId(), storeToStorebean.getSourceLocationId());
			bean.setQcItemList(storeToStoreList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getStoreToStoreList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return bean;
	}

	@Override
	public int checkStockTransfer(int purchaseRequisitionId) throws Exception {
		int purchaseRequisitionExists = 0;

		try {
			purchaseRequisitionExists = jdbcTemplate.queryForObject(StoreToStoreQueryUtil.checkStockTransferExists,Integer.class ,purchaseRequisitionId );
		} catch (Exception e) {

		}
		return purchaseRequisitionExists;
	}

}