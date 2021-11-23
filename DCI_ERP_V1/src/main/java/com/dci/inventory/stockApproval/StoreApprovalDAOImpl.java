package com.dci.inventory.stockApproval;

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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.user.UserDetail;

@Repository
public class StoreApprovalDAOImpl implements StoreApprovalDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(StoreApprovalDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<StoreApproval> getStoreApprovalList() throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<StoreApproval> storeApprovalList = new ArrayList<>();
		try {
			storeApprovalList = jdbcTemplate.query(StoreApprovalQueryUtil.SELECT_STORE_LIST, new BeanPropertyRowMapper<>(StoreApproval.class), userDetails.getCompanyCode());
			return storeApprovalList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getStoreApprovalList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public StoreApprovalResultBean getEmployeeList() throws CustomException {
		StoreApprovalResultBean storeApprovalResultBean = new StoreApprovalResultBean();
		List<StoreApproval> employeeList = new ArrayList<>();
		List<StoreApproval> statusList = new ArrayList<>();
		List<StoreApproval> locationList = new ArrayList<>();
		List<StoreApprovalSubBean> itemList = new ArrayList<>();
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetail user = (UserDetail) auth.getPrincipal();

			String userId = user.getUserId();
			storeApprovalResultBean.setUserId(userId);
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}
		try {
			employeeList = jdbcTemplate.query(StoreApprovalQueryUtil.GET_EMPLOYEE_LIST, new BeanPropertyRowMapper<>(StoreApproval.class));
			storeApprovalResultBean.setEmployeeList(employeeList);

		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}
		try {
			locationList = jdbcTemplate.query(StoreApprovalQueryUtil.GET_LOCATION_LIST, new BeanPropertyRowMapper<>(StoreApproval.class));
			storeApprovalResultBean.setLocationList(locationList);
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}

		try {
			itemList = jdbcTemplate.query(StoreApprovalQueryUtil.GET_ITEM_LIST, new BeanPropertyRowMapper<>(StoreApprovalSubBean.class));
			storeApprovalResultBean.setItemList(itemList);
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}
		try {
			statusList = jdbcTemplate.query(StoreApprovalQueryUtil.GET_STATUS_LIST, new BeanPropertyRowMapper<>(StoreApproval.class));
			storeApprovalResultBean.setStatusList(statusList);
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}
		// TODO Auto-generated method stub
		return storeApprovalResultBean;
	}

	@Override
	public StoreApprovalSubBean getItemList(int itemId) throws CustomException {
		StoreApprovalSubBean storeToStoreSubBean = null;
		// TODO Auto-generated method stub
		try {
			storeToStoreSubBean = jdbcTemplate.queryForObject(StoreApprovalQueryUtil.GET_ITEM_DATA_ONCHANGE, new BeanPropertyRowMapper<>(StoreApprovalSubBean.class), itemId);
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
	public StoreApprovalResultBean getStoreApprovalById(int purchaseRequisitionId) throws CustomException {
		StoreApprovalResultBean storeApprovalResultBean = new StoreApprovalResultBean();
		List<StoreApprovalSubBean> subData = new ArrayList<>();
		StoreApproval headerData = new StoreApproval();
		try {

			int[] types = new int[] { Types.INTEGER };
			Object[] params = new Object[] { purchaseRequisitionId };
			Map row = jdbcTemplate.queryForMap(StoreApprovalQueryUtil.EDIT_HEADER, params, types);

			headerData.setPurchaseRequisitionId((int) row.get("purchaseRequisitionId"));
			headerData.setRequisitionNumber((String) row.get("requisitionNumber"));
			headerData.setRequisitionStatus((Integer) row.get("requisitionStatus"));

			if (row.get("approvedDate") != null) {
				headerData.setApprovedDate((String) row.get("approvedDate"));
			}
			headerData.setRemarks((String) row.get("remarks"));
			headerData.setRequisitionType((Integer) row.get("requisitionType"));
			if (row.get("requisitionDate") != null) {
				headerData.setRequisitionDate((String) row.get("requisitionDate"));
			}
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
			headerData.setRequisitionStatus((Integer) row.get("requisitionStatus"));
			if (row.get("sourceLocationName") != null) {
				headerData.setSourceLocationName((String) row.get("sourceLocationName"));
			}
			headerData.setDestinationLocation((Integer) row.get("destinationLocation"));
			if (row.get("destinationLocationnName") != null) {
				headerData.setDestinationLocationName((String) row.get("destinationLocationnName"));
			}

			// detail
			List<Map<String, Object>> rowdetail = jdbcTemplate.queryForList(StoreApprovalQueryUtil.EDIT_DETAIL, params, types);
			for (Map row1 : rowdetail) {
				StoreApprovalSubBean storeToStoreSubBean = new StoreApprovalSubBean();
				storeToStoreSubBean.setId((Integer) row1.get("itemId"));
				storeToStoreSubBean.setItemId(String.valueOf(row1.get("itemId")));
				if (row1.get("itemName") != null) {
					storeToStoreSubBean.setText((String) row1.get("itemName"));
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
				headerData.setPurchaseRequisitionId((int) row1.get("purchaseRequisitionId"));
				storeToStoreSubBean.setPurchaseRequisitionSubId((int) row1.get("purchaseRequisitionSubId"));
				subData.add(storeToStoreSubBean);

			}
			storeApprovalResultBean.setHeaderData(headerData);
			storeApprovalResultBean.setSubData(subData);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Edit store to store", e);
		}

		return storeApprovalResultBean;
	}

	@Override
	public StoreApprovalResultBean getStoreApprovalByView(int purchaseRequisitionId) throws CustomException {
		StoreApprovalResultBean storeApprovalResultBean = new StoreApprovalResultBean();
		List<StoreApprovalSubBean> subData = new ArrayList<>();
		StoreApproval headerData = new StoreApproval();
		try {

			int[] types = new int[] { Types.INTEGER };
			Object[] params = new Object[] { purchaseRequisitionId };
			Map row = jdbcTemplate.queryForMap(StoreApprovalQueryUtil.EDIT_HEADER, params, types);

			headerData.setPurchaseRequisitionId((int) row.get("purchaseRequisitionId"));
			headerData.setRequisitionNumber((String) row.get("requisitionNumber"));
			headerData.setRequisitionStatus((Integer) row.get("requisitionStatus"));

			if (row.get("approvedDate") != null) {
				headerData.setApprovedDate((String) row.get("approvedDate"));
			}
			headerData.setRemarks((String) row.get("remarks"));
			headerData.setRequisitionType((Integer) row.get("requisitionType"));
			if (row.get("requisitionDate") != null) {
				headerData.setRequisitionDate((String) row.get("requisitionDate"));
			}
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
			headerData.setRequisitionStatus((Integer) row.get("requisitionStatus"));
			if (row.get("requisitionStatusName") != null) {
				headerData.setRequisitionStatusName((String) row.get("requisitionStatusName"));
			}
			if (row.get("sourceLocationName") != null) {
				headerData.setSourceLocationName((String) row.get("sourceLocationName"));
			}
			headerData.setDestinationLocation((Integer) row.get("destinationLocation"));
			if (row.get("destinationLocationnName") != null) {
				headerData.setDestinationLocationName((String) row.get("destinationLocationnName"));
			}
			headerData.setPrReqNo((String) row.get("prRequestNo"));
			if (row.get("requestDate") != null) {
				headerData.setPrReqDate((String) row.get("requestDate"));
			} else {
				headerData.setPrReqDate("");
			}

			// detail
			List<Map<String, Object>> rowdetail = jdbcTemplate.queryForList(StoreApprovalQueryUtil.EDIT_DETAIL, params, types);
			for (Map row1 : rowdetail) {
				StoreApprovalSubBean storeToStoreSubBean = new StoreApprovalSubBean();
				storeToStoreSubBean.setItemId(String.valueOf(row1.get("itemId")));
				if (row1.get("itemCode") != null) {
					storeToStoreSubBean.setItemCode((String) row1.get("itemCode"));
				}
				if (row1.get("itemName") != null) {
					storeToStoreSubBean.setItemName((String) row1.get("itemName"));
				}
				if (row1.get("itemName") != null) {
					storeToStoreSubBean.setText((String) row1.get("itemName"));
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
			storeToStoreSubBean.setQuantity1((Double) row1.get("quantity1"));
				if (row1.get("eddDate") != null) {
					storeToStoreSubBean.setEddDate((String) row1.get("eddDate"));
				}
				headerData.setPurchaseRequisitionId((int) row1.get("purchaseRequisitionId"));
				storeToStoreSubBean.setPurchaseRequisitionSubId((int) row1.get("purchaseRequisitionSubId"));
				subData.add(storeToStoreSubBean);

			}
			storeApprovalResultBean.setHeaderData(headerData);
			storeApprovalResultBean.setSubData(subData);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Edit store to store", e);
		}

		return storeApprovalResultBean;
	}

	@Override
	public boolean updateStoreApproval(StoreApprovalResultBean storeApprovalResultBean) throws CustomException {
		boolean isSuccess = false;
		StoreApproval headerData = storeApprovalResultBean.getHeaderData();
		List<StoreApprovalSubBean> subData = storeApprovalResultBean.getSubData();
		String requisitionNumber = null;
		int purchaseRequisitionId = headerData.getPurchaseRequisitionId();
		synchronized (this) {

			try {

				Integer requisitionType = headerData.getRequisitionType();
				if (requisitionNumber != null) {
					requisitionType = 120;
				}
				HashMap<String, Object> storeInsertMap = new HashMap<>();
				storeInsertMap.put("requisitionNumber", headerData.getRequisitionNumber());
				storeInsertMap.put("requisitionDate", headerData.getRequisitionDate());
				storeInsertMap.put("requisitionType", requisitionType);
				storeInsertMap.put("requisitionStatus", headerData.getRequisitionStatus());
				storeInsertMap.put("destinationLocation", headerData.getDestinationLocation());
				storeInsertMap.put("approvedDate", headerData.getApprovedDate());
				storeInsertMap.put("approvedId", headerData.getApprovedId());// ApprovedBy
				storeInsertMap.put("remarks", headerData.getRemarks());
				storeInsertMap.put("purchaseRequisitionId", purchaseRequisitionId);
				namedParameterJdbcTemplate.update(StoreApprovalQueryUtil.UPDATE_STORE_HEADER, storeInsertMap);
				isSuccess = true;

			} catch (DataAccessException e) {
				LOGGER.error("Error in getItemList", e);
			}
		}
		int j = jdbcTemplate.queryForObject(StoreApprovalQueryUtil.COUNT_MAX,Integer.class, purchaseRequisitionId) ;

		if (j > 0) {
			jdbcTemplate.update(StoreApprovalQueryUtil.DELETE_DETAIL, purchaseRequisitionId);

			for (int k = 0; k < subData.size(); k++) {
				HashMap<String, Object> storeInsertSubMap = new HashMap<>();
				storeInsertSubMap.put("purchaseRequisitionId", purchaseRequisitionId);
				storeInsertSubMap.put("itemId", Integer.parseInt(subData.get(k).getItemId()));
				storeInsertSubMap.put("quantity", subData.get(k).getQuantity());
				storeInsertSubMap.put("eddDate", subData.get(k).getEddDate());
				namedParameterJdbcTemplate.update(StoreApprovalQueryUtil.INSERT_STORE_SUBDATA, storeInsertSubMap);
			}
			isSuccess = true;

		}

		return isSuccess;
	}

	@Override
	public boolean deleteStoreApproval(int purchaseRequisitionId) throws CustomException {
		boolean isDeleted = false;

		try {
			int rowServiceDetail = jdbcTemplate.update(StoreApprovalQueryUtil.DELETE_DETAIL, purchaseRequisitionId);
			int rowServiceHeader = jdbcTemplate.update(StoreApprovalQueryUtil.DELETE_HEADER, purchaseRequisitionId);

			isDeleted = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete Store to store", e);
		}

		return isDeleted;
	}

	@Override
	public boolean Approval(int purchaseRequisitionId) throws Exception {
		boolean isSuccess = false;

		try {
			int approve = jdbcTemplate.update(StoreApprovalQueryUtil.STATUS_APPROVE, purchaseRequisitionId);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete Store to store", e);
		}

		return isSuccess;
	}
}
