package com.dci.finance.storeToPurchase;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.user.UserDetail;

@Repository
public class StoreToPurchaseDAOImpl implements StoreToPurchaseDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(StoreToPurchaseDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<StoreToPurchase> getStoreToPurchaseList() throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<StoreToPurchase> storeToPurchaseList = new ArrayList<StoreToPurchase>();
		try {
			storeToPurchaseList = jdbcTemplate.query(StoreToPurchaseQueryUtil.SELECT_STORE_LIST, new BeanPropertyRowMapper<StoreToPurchase>(StoreToPurchase.class), userDetails.getCompanyCode());
			return storeToPurchaseList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getStoreToPurchaseList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public StoreToPurchaseResultBean getEmployeeList() throws CustomException {
		StoreToPurchaseResultBean storeToPurchaseResultBean = new StoreToPurchaseResultBean();
		List<StoreToPurchase> employeeList = new ArrayList<StoreToPurchase>();
		List<StoreToPurchase> locationList = new ArrayList<StoreToPurchase>();
		List<StoreToPurchase> destlocationList = new ArrayList<StoreToPurchase>();
		List<StoreToPurchaseSubBean> itemList = new ArrayList<StoreToPurchaseSubBean>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			employeeList = jdbcTemplate.query(StoreToPurchaseQueryUtil.GET_EMPLOYEE_LIST, new BeanPropertyRowMapper<StoreToPurchase>(StoreToPurchase.class), userDetails.getCompanyCode());
			storeToPurchaseResultBean.setEmployeeList(employeeList);

		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}
		try {
			locationList = jdbcTemplate.query(StoreToPurchaseQueryUtil.GET_LOCATION_LIST, new BeanPropertyRowMapper<StoreToPurchase>(StoreToPurchase.class));
			storeToPurchaseResultBean.setLocationList(locationList);
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}

		try {
			destlocationList = jdbcTemplate.query(StoreToPurchaseQueryUtil.GET_DESTINATIONLOCATION_LIST, new BeanPropertyRowMapper<StoreToPurchase>(StoreToPurchase.class));
			storeToPurchaseResultBean.setDestLocationList(destlocationList);
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}

		try {
			itemList = jdbcTemplate.query(StoreToPurchaseQueryUtil.GET_ITEM_LIST, new BeanPropertyRowMapper<StoreToPurchaseSubBean>(StoreToPurchaseSubBean.class), userDetails.getCompanyCode());
			storeToPurchaseResultBean.setItemList(itemList);
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}
		// TODO Auto-generated method stub
		return storeToPurchaseResultBean;
	}

	@Override
	public StoreToPurchaseSubBean getItemList(int itemId) throws CustomException {
		StoreToPurchaseSubBean storeToStoreSubBean = null;
		// TODO Auto-generated method stub
		try {
			storeToStoreSubBean = jdbcTemplate.queryForObject(StoreToPurchaseQueryUtil.GET_ITEM_DATA_ONCHANGE, new BeanPropertyRowMapper<StoreToPurchaseSubBean>(StoreToPurchaseSubBean.class), itemId);
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
	public boolean insertStoreToPurchase(StoreToPurchaseResultBean storeToPurchaseResultBean) throws CustomException {
		boolean isSuccess = false;
		StoreToPurchase headerData = storeToPurchaseResultBean.getHeaderData();
		List<StoreToPurchaseSubBean> subData = storeToPurchaseResultBean.getSubData();
		String requisitionNumber = null;
		int purchaseRequisitionId = 0;
		synchronized (this) {

			try {

				requisitionNumber = jdbcTemplate.queryForObject(StoreToPurchaseQueryUtil.GENERATE_REQ_NO, String.class);
				Integer requisitionType = headerData.getRequisitionType();
				Integer requisitionStatus = headerData.getRequisitionStatus();
				if (requisitionNumber != null) {
					requisitionType = 118;
					requisitionStatus = 68;

				}

				HashMap<String, Object> storeInsertMap = new HashMap<String, Object>();
				storeInsertMap.put("requisitionNumber", requisitionNumber);
				storeInsertMap.put("requisitionDate", headerData.getRequisitionDate());
				storeInsertMap.put("employeeId", headerData.getEmployeeId()); // RequestedBy
				storeInsertMap.put("requisitionType", requisitionType);
				storeInsertMap.put("requisitionStatus", requisitionStatus);
				storeInsertMap.put("destinationLocation", Integer.parseInt(headerData.getDestinationLocation()));
				storeInsertMap.put("company", headerData.getCompanyId());
				purchaseRequisitionId = namedParameterJdbcTemplate.queryForObject(StoreToPurchaseQueryUtil.INSERT_STORE_HEADER, storeInsertMap,Integer.class);
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
				namedParameterJdbcTemplate.update(StoreToPurchaseQueryUtil.INSERT_STORE_SUBDATA, storeInsertSubMap);
			}
			isSuccess = true;

		}

		return isSuccess;
	}

	@Override
	public StoreToPurchaseResultBean getStoreToPurchaseById(int purchaseRequisitionId) throws CustomException {
		StoreToPurchaseResultBean storeToPurchaseResultBean = new StoreToPurchaseResultBean();
		List<StoreToPurchaseSubBean> subData = new ArrayList<StoreToPurchaseSubBean>();
		StoreToPurchase headerData = new StoreToPurchase();
		try {

			int[] types = new int[] { Types.INTEGER };
			Object[] params = new Object[] { purchaseRequisitionId };
			Map row = jdbcTemplate.queryForMap(StoreToPurchaseQueryUtil.EDIT_HEADER, params, types);

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
			headerData.setRequisitionStatus((Integer) row.get("requisitionStatus"));
			if (row.get("requisitionStatusName") != null) {
				headerData.setRequisitionStatusName((String) row.get("requisitionStatusName"));
			}
			if (row.get("sourceLocationName") != null) {
				headerData.setSourceLocationName((String) row.get("sourceLocationName"));
			}
			headerData.setDestinationLocation(String.valueOf(row.get("destinationLocation")));
			if (row.get("destinationLocationnName") != null) {
				headerData.setDestinationLocationName((String) row.get("destinationLocationnName"));
			}

			// detail
			List<Map<String, Object>> rowdetail = jdbcTemplate.queryForList(StoreToPurchaseQueryUtil.EDIT_DETAIL, params, types);
			for (Map row1 : rowdetail) {
				StoreToPurchaseSubBean storeToStoreSubBean = new StoreToPurchaseSubBean();
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
				if (row1.get("eddDate") != null) {
					storeToStoreSubBean.setEddDate((String) row1.get("eddDate"));
				}

				if (row.get("companyId") != null) {
					headerData.setCompanyId((String) row.get("companyId"));
				} else {
					headerData.setCompanyId("");
				}
				headerData.setPurchaseRequisitionId((int) row1.get("purchaseRequisitionId"));
				storeToStoreSubBean.setPurchaseRequisitionSubId((int) row1.get("purchaseRequisitionSubId"));
				storeToStoreSubBean.setDisableDate(true);
				subData.add(storeToStoreSubBean);

			}
			storeToPurchaseResultBean.setHeaderData(headerData);
			storeToPurchaseResultBean.setSubData(subData);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Edit store to store", e);
		}

		return storeToPurchaseResultBean;
	}

	@Override
	public boolean updateStoreToPurchase(StoreToPurchaseResultBean storeToPurchaseResultBean) throws CustomException {
		boolean isSuccess = false;
		StoreToPurchase headerData = storeToPurchaseResultBean.getHeaderData();
		List<StoreToPurchaseSubBean> subData = storeToPurchaseResultBean.getSubData();
		String requisitionNumber = null;
		int purchaseRequisitionId = headerData.getPurchaseRequisitionId();
		synchronized (this) {

			try {

				Integer requisitionType = headerData.getRequisitionType();
				Integer requisitionStatus = headerData.getRequisitionStatus();
				if (requisitionNumber != null) {
					requisitionType = 47;
					requisitionStatus = 68;

				}
				HashMap<String, Object> storeInsertMap = new HashMap<String, Object>();
				storeInsertMap.put("requisitionNumber", headerData.getRequisitionNumber());
				storeInsertMap.put("requisitionDate", headerData.getRequisitionDate());
				storeInsertMap.put("employeeId", headerData.getEmployeeId()); // RequestedBy
				storeInsertMap.put("requisitionType", requisitionType);
				storeInsertMap.put("requisitionStatus", requisitionStatus);
				storeInsertMap.put("destinationLocation", Integer.parseInt(headerData.getDestinationLocation()));
				storeInsertMap.put("company", headerData.getCompanyId());
				storeInsertMap.put("purchaseRequisitionId", purchaseRequisitionId);
				namedParameterJdbcTemplate.update(StoreToPurchaseQueryUtil.UPDATE_STORE_HEADER, storeInsertMap);
				isSuccess = true;

			} catch (DataAccessException e) {
				LOGGER.error("Error in getItemList", e);
			}

		}
		int j = jdbcTemplate.queryForObject(StoreToPurchaseQueryUtil.COUNT_MAX, Integer.class, purchaseRequisitionId );

		if (j > 0) {
			jdbcTemplate.update(StoreToPurchaseQueryUtil.DELETE_DETAIL, purchaseRequisitionId);

			for (int k = 0; k < subData.size(); k++) {
				HashMap<String, Object> storeInsertSubMap = new HashMap<String, Object>();
				storeInsertSubMap.put("purchaseRequisitionId", purchaseRequisitionId);
				storeInsertSubMap.put("itemId", Integer.parseInt(subData.get(k).getItemId()));
				storeInsertSubMap.put("quantity", subData.get(k).getQuantity());
				storeInsertSubMap.put("eddDate", subData.get(k).getEddDate());
				namedParameterJdbcTemplate.update(StoreToPurchaseQueryUtil.INSERT_STORE_SUBDATA, storeInsertSubMap);
			}
			isSuccess = true;

		}

		return isSuccess;
	}

	@Override
	public boolean deleteStoreToPurchase(int purchaseRequisitionId) throws CustomException {
		boolean isDeleted = false;

		try {
			int rowServiceDetail = jdbcTemplate.update(StoreToPurchaseQueryUtil.DELETE_DETAIL, purchaseRequisitionId);
			int rowServiceHeader = jdbcTemplate.update(StoreToPurchaseQueryUtil.DELETE_HEADER, purchaseRequisitionId);

			isDeleted = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete Store to store", e);
		}

		return isDeleted;
	}

	@Override
	public StoreToPurchaseResultBean getAssetItemList() {
		List<StoreToPurchaseSubBean> itemList = new ArrayList<StoreToPurchaseSubBean>();
		StoreToPurchaseResultBean storeToPurchaseResultBean = new StoreToPurchaseResultBean();
		try {
			itemList = jdbcTemplate.query(StoreToPurchaseQueryUtil.sGetAssetItemList, new BeanPropertyRowMapper<StoreToPurchaseSubBean>(StoreToPurchaseSubBean.class));
			storeToPurchaseResultBean.setSubData(itemList);

		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}
		return storeToPurchaseResultBean;
	}

}
