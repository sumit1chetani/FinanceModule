package com.dci.tenant.finance.consignmentRequest;

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

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;
import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.finance.purchasequotation.PurchaseQuotationQueryUtil;
import com.dci.tenant.user.UserDetail;

@Repository
public class ConsignmentRequestDAOImpl implements ConsignmentRequestDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsignmentRequestDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<ConsignmentRequest> getConsignmentRequestList() throws CustomException {
		List<ConsignmentRequest> consignmentRequesteList = new ArrayList<>();
		try {
			consignmentRequesteList = jdbcTemplate.query(ConsignmentRequestQueryUtil.SELECT_CONSIGNMENT_LIST, new BeanPropertyRowMapper<>(ConsignmentRequest.class));
			return consignmentRequesteList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getConsignmentRequestList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ConsignmentRequestResultBean getEmployeeList() throws CustomException {
		ConsignmentRequestResultBean consignmentRequesteResultBean = new ConsignmentRequestResultBean();
		List<ConsignmentRequest> employeeList = new ArrayList<>();
		List<ConsignmentRequest> locationList = new ArrayList<>();
		List<ConsignmentRequest> destlocationList = new ArrayList<>();
		List<ConsignmentRequestSubBean> itemList = new ArrayList<>();
		List<ConsignmentRequestSubBean> costList = new ArrayList<>();
		List<SelectivityBean> requestTypeList = new ArrayList<>();

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetail user = (UserDetail) auth.getPrincipal();

			String userId = user.getUserId();
			consignmentRequesteResultBean.setUserId(userId);
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}
		try {
			employeeList = jdbcTemplate.query(ConsignmentRequestQueryUtil.GET_EMPLOYEE_LIST, new BeanPropertyRowMapper<>(ConsignmentRequest.class), userDetails.getCompanyCode());
			consignmentRequesteResultBean.setEmployeeList(employeeList);

		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}
		try {
			locationList = jdbcTemplate.query(ConsignmentRequestQueryUtil.GET_SOURCELOCATION_LIST, new BeanPropertyRowMapper<>(ConsignmentRequest.class));
			consignmentRequesteResultBean.setLocationList(locationList);

		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}

		try {
			destlocationList = jdbcTemplate.query(ConsignmentRequestQueryUtil.GET_DESTINATIONLOCATION_LIST, new BeanPropertyRowMapper<>(ConsignmentRequest.class));
			consignmentRequesteResultBean.setDestLocationList(destlocationList);
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}
		try {
			costList = jdbcTemplate.query(ConsignmentRequestQueryUtil.GET_COST_LIST, new BeanPropertyRowMapper<>(ConsignmentRequestSubBean.class));
			consignmentRequesteResultBean.setCostList(costList);
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}
		try {
			requestTypeList = jdbcTemplate.query(ConsignmentRequestQueryUtil.GET_REQUEST_TYPE, new BeanPropertyRowMapper<>(SelectivityBean.class), 80);
			consignmentRequesteResultBean.setRequestTypeList(requestTypeList);
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}
		try {
			itemList = jdbcTemplate.query(ConsignmentRequestQueryUtil.GET_ITEM_LIST, new BeanPropertyRowMapper<>(ConsignmentRequestSubBean.class));
			consignmentRequesteResultBean.setItemList(itemList);
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeList", e);
		}

		// TODO Auto-generated method stub
		return consignmentRequesteResultBean;
	}

	@Override
	public ConsignmentRequestSubBean getItemList(int itemId) throws CustomException {
		ConsignmentRequestSubBean consignmentRequesteSubBean = new ConsignmentRequestSubBean();
		// TODO Auto-generated method stub
		try {
			consignmentRequesteSubBean = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_ITEM_DATA_ONCHANGE, new BeanPropertyRowMapper<>(ConsignmentRequestSubBean.class), itemId);

			double GRNQTY = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_GRN_QTY, Double.class, Integer.parseInt(consignmentRequesteSubBean.getId()));
			double MISSUEQTY = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MI_QTY1, Double.class, Integer.parseInt(consignmentRequesteSubBean.getId()));
			// double availableQTY = 0;
			// if (GRNQTY > MISSUEQTY) {
			// availableQTY = GRNQTY - MISSUEQTY;
			// consignmentRequesteSubBean.setAvailQuantity(availableQTY);
			// } else if (GRNQTY < MISSUEQTY || GRNQTY == MISSUEQTY) {
			// availableQTY = 0;
			// consignmentRequesteSubBean.setAvailQuantity(availableQTY);
			// }
			double itemOpeningQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_OPENING_QTY, Double.class, Integer.parseInt(consignmentRequesteSubBean.getId()));

			// 13/02/21 gatepass item included
			int GatePassOut = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSOUT_QTY, Integer.class, Integer.parseInt(consignmentRequesteSubBean.getId()));
			int GatePassIn = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSIN_QTY, Integer.class, Integer.parseInt(consignmentRequesteSubBean.getId()));
			// end
			double availableQTY = 0;

			// availableQTY = (GRNQTY + itemOpeningQTY) - MISSUEQTY;
			availableQTY = (GRNQTY + itemOpeningQTY) - (MISSUEQTY + (GatePassOut - GatePassIn));

			if (availableQTY < 0)
				availableQTY = 0;
			consignmentRequesteSubBean.setAvailQuantity(availableQTY);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getItemList", e);
		}
		return consignmentRequesteSubBean;
	}

	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}

	@Override
	public boolean insertConsignmentRequest(ConsignmentRequestResultBean consignmentRequesteResultBean) throws CustomException {
		boolean isSuccess = false;
		ConsignmentRequest headerData = consignmentRequesteResultBean.getHeaderData();
		List<ConsignmentRequestSubBean> subData = consignmentRequesteResultBean.getSubData();
		String requisitionNumber = null;
		String PRNumber = null;
		int purchaseRequisitionId = 0;

		synchronized (this) {
			try {

				PRNumber = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GENERATE_REQ_NO_SERIES, String.class);
				if (PRNumber == null) {
					requisitionNumber = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GENERATE_REQ_NO_1, String.class);

				} else {
					if (!PRNumber.equals("")) {
						requisitionNumber = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GENERATE_REQ_NO, String.class, PRNumber, PRNumber);

					} else {
						requisitionNumber = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GENERATE_REQ_NO_1, String.class);

					}
				}
				String comapnyCode = headerData.getCompanyId();
				String CompanyShortName = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME, String.class, comapnyCode);

				requisitionNumber = CompanyShortName.concat("-" + requisitionNumber);
				Integer requisitionType = headerData.getRequisitionType();
				if (requisitionNumber != null) {
					requisitionType = 126;
				}

				HashMap<String, Object> consignmentRequestInsertMap = new HashMap<>();
				consignmentRequestInsertMap.put("requisitionNumber", requisitionNumber);
				consignmentRequestInsertMap.put("requisitionDate", headerData.getRequisitionDate());
				consignmentRequestInsertMap.put("employeeId", headerData.getEmployeeId()); // RequestedBy
				consignmentRequestInsertMap.put("requisitionType", requisitionType);
				consignmentRequestInsertMap.put("sourceLocation", Integer.parseInt(headerData.getSourceLocation()));
				consignmentRequestInsertMap.put("destinationLocation", Integer.parseInt(headerData.getDestinationLocation()));
				consignmentRequestInsertMap.put("company", headerData.getCompanyId());
				consignmentRequestInsertMap.put("requisitionStatus", headerData.getRequisitionStatus());
				consignmentRequestInsertMap.put("costcenter", headerData.getCostcenter());
				consignmentRequestInsertMap.put("prrequestnumber", headerData.getPrRequestNo());
				if (headerData.getRequestDate().equals("") || headerData.getRequestDate().equals(null))
					consignmentRequestInsertMap.put("prrequestdate", null);
				else
					consignmentRequestInsertMap.put("prrequestdate", headerData.getRequestDate());
				consignmentRequestInsertMap.put("requestType", headerData.getRequestType());
				if (headerData.getRequestType() == 217) {

					consignmentRequestInsertMap.put("flag", true);

				} else if (headerData.getRequestType() == 216) {
					consignmentRequestInsertMap.put("flag", false);

				}

				purchaseRequisitionId = namedParameterJdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.INSERT_CONSIGNMENT_HEADER, consignmentRequestInsertMap,Integer.class);
				isSuccess = true;

			} catch (DataAccessException e) {
				LOGGER.error("Error in getItemList", e);
			}
		}

		if (isSuccess) {

			for (int j = 0; j < subData.size(); j++) {
				HashMap<String, Object> consignmentRequestInsertMap1 = new HashMap<>();
				consignmentRequestInsertMap1.put("purchaseRequisitionId", purchaseRequisitionId);
				consignmentRequestInsertMap1.put("itemId", Integer.parseInt(subData.get(j).getItemId()));
				consignmentRequestInsertMap1.put("quantity", subData.get(j).getQuantity());
				if (subData.get(j).getEddDate() == "" || subData.get(j).getEddDate() == null) {
					consignmentRequestInsertMap1.put("eddDate", null);
				} else {
					consignmentRequestInsertMap1.put("eddDate", subData.get(j).getEddDate());
				}

				consignmentRequestInsertMap1.put("itemdescription", subData.get(j).getItemdescription());
				consignmentRequestInsertMap1.put("pendingQty", subData.get(j).getQuantity());

				if (subData.get(j).getAltuom() == null) {
					subData.get(j).setAltuom(0);
				}
				if (subData.get(j).getAltuom() != 0)
					consignmentRequestInsertMap1.put("altuom", subData.get(j).getAltuom());
				else
					consignmentRequestInsertMap1.put("altuom", 0);
				// if(subData.get(j).getAltqty() == null) {
				// subData.get(j).setAltqty(0);
				// }
				if (subData.get(j).getAltqty() != 0)
					consignmentRequestInsertMap1.put("altqty", subData.get(j).getQuantity());
				else
					consignmentRequestInsertMap1.put("altqty", 0);
				namedParameterJdbcTemplate.update(ConsignmentRequestQueryUtil.INSERT_CONSIGNMENT_SUBDATA, consignmentRequestInsertMap1);
			}
			isSuccess = true;

		}

		return isSuccess;
	}

	@Override
	public ConsignmentRequestResultBean getConsignmentRequestById(int purchaseRequisitionId) throws CustomException {
		ConsignmentRequestResultBean consignmentRequesteResultBean = new ConsignmentRequestResultBean();
		List<ConsignmentRequestSubBean> subData = new ArrayList<>();
		ConsignmentRequest headerData = new ConsignmentRequest();
		try {

			int[] types = new int[] { Types.INTEGER };
			Object[] params = new Object[] { purchaseRequisitionId };
			Map row = jdbcTemplate.queryForMap(ConsignmentRequestQueryUtil.EDIT_HEADER, params, types);

			headerData.setPurchaseRequisitionId((int) row.get("purchaseRequisitionId"));
			headerData.setRequisitionNumber((String) row.get("requisitionNumber"));
			headerData.setRequisitionType((Integer) row.get("requisitionType"));
			headerData.setRequisitionDate((String) row.get("requisitionDate"));
			if (row.get("employeeId") != null) {
				headerData.setEmployeeId((String) row.get("employeeId"));
			}
			headerData.setRequisitionStatus((Integer) row.get("requisitionStatus"));
			if (row.get("requisitionStatusName") != null) {
				headerData.setRequisitionStatusName((String) row.get("requisitionStatusName"));
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
			headerData.setCostcenter((String) row.get("costcenter"));
			if (row.get("costcenter") != null) {
				headerData.setCostcenter((String) row.get("costcenter"));
			}
			if (row.get("companyId") != null) {
				headerData.setCompanyId((String) row.get("companyId"));
			} else {
				headerData.setCompanyId("");
			}
			headerData.setPrRequestNo((String) row.get("prRequestNo"));
			if (row.get("requestDate") != null) {
				headerData.setRequestDate((String) row.get("requestDate"));
			} else {
				headerData.setRequestDate("");
			}
			if (row.get("requestType") != null) {
				headerData.setRequestType((int) row.get("requestType"));
			} else {
				headerData.setRequestType(0);
			}
			// detail

			List<Map<String, Object>> rowdetail = jdbcTemplate.queryForList(ConsignmentRequestQueryUtil.EDIT_DETAIL, params, types);

			/*
			 * int GRNQTY = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.
			 * GET_GRN_QTY, Integer.class,
			 * Integer.parseInt(consignmentRequesteSubBean.getId())); int MISSUEQTY =
			 * jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil. GET_MI_QTY1,
			 * Integer.class, Integer.parseInt(consignmentRequesteSubBean.getId())); int
			 * availableQTY = 0; if (GRNQTY > MISSUEQTY) { availableQTY = GRNQTY -
			 * MISSUEQTY; consignmentRequesteSubBean.setAvailQuantity(availableQTY); } else
			 * if (GRNQTY < MISSUEQTY || GRNQTY == MISSUEQTY) { availableQTY = 0;
			 * consignmentRequesteSubBean.setAvailQuantity(availableQTY); }
			 */
			for (Map row1 : rowdetail) {
				ConsignmentRequestSubBean consignmentRequesteSubBean = new ConsignmentRequestSubBean();

				consignmentRequesteSubBean.setItemId(String.valueOf(row1.get("itemId")));
				if (row1.get("itemCode") != null) {
					consignmentRequesteSubBean.setItemCode((String) row1.get("itemCode"));
				}
				if (row1.get("itemName") != null) {
					consignmentRequesteSubBean.setItemName((String) row1.get("itemName"));
				}
				if (row1.get("itemdescription") != null) {
					consignmentRequesteSubBean.setItemDesc((String) row1.get("itemDesc"));
				}
				consignmentRequesteSubBean.setItemCategoryId((Integer) row1.get("itemCategoryId"));
				if (row1.get("itemCategoryName") != null) {
					consignmentRequesteSubBean.setItemCategoryName((String) row1.get("itemCategoryName"));
				}
				consignmentRequesteSubBean.setUomId((Integer) row1.get("uomId"));
				if (row1.get("uomName") != null) {
					consignmentRequesteSubBean.setUomName((String) row1.get("uomName"));
				}
				if (row1.get("altuomName") != null) {
					consignmentRequesteSubBean.setAltuomName((String) row1.get("altuomName"));
				}

				if (row1.get("altuom") != null)
					consignmentRequesteSubBean.setAltuom((Integer) row1.get("altuom"));
				if (row1.get("altqty") != null)
					consignmentRequesteSubBean.setAltqty((double) row1.get("altqty"));

				// consignmentRequesteSubBean.setAvailQuantity((double)
				// row1.get("availQuantity"));
				// if (row1.get("availQuantity") != null) {
				// consignmentRequesteSubBean.setAvailQuantity((double)
				// row1.get("availQuantity"));
				// }
				consignmentRequesteSubBean.setQuantity((double) row1.get("quantity"));
				if (row1.get("eddDate") != null) {
					consignmentRequesteSubBean.setEddDate((String) row1.get("eddDate"));
				}
				if (row1.get("itemdescription") != null) {
					consignmentRequesteSubBean.setItemdescription((String) row1.get("itemdescription"));
				}
				headerData.setPurchaseRequisitionId((int) row1.get("purchaseRequisitionId"));
				consignmentRequesteSubBean.setPurchaseRequisitionSubId((int) row1.get("purchaseRequisitionSubId"));
				consignmentRequesteSubBean.setDisableDate(true);
				Boolean existFlag = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MR_EXIST, Boolean.class, consignmentRequesteSubBean.getPurchaseRequisitionSubId());
				consignmentRequesteSubBean.setMiexist(existFlag);
				subData.add(consignmentRequesteSubBean);

			}
			// headerData.setisEdit(true);
			Boolean existFlag = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MR_EXIST_FLAG, Boolean.class, purchaseRequisitionId, purchaseRequisitionId);

			headerData.setExistFlag(existFlag);
			consignmentRequesteResultBean.setHeaderData(headerData);
			consignmentRequesteResultBean.setSubData(subData);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Edit store to store", e);
		}

		return consignmentRequesteResultBean;
	}

	@Override
	public boolean updateConsignmentRequest(ConsignmentRequestResultBean consignmentRequesteResultBean) throws CustomException {
		boolean isSuccess = false;
		ConsignmentRequest headerData = consignmentRequesteResultBean.getHeaderData();
		List<ConsignmentRequestSubBean> subData = consignmentRequesteResultBean.getSubData();
		String requisitionNumber = null;
		int purchaseRequisitionId = headerData.getPurchaseRequisitionId();

		synchronized (this) {

			try {

				Integer requisitionType = headerData.getRequisitionType();
				if (requisitionNumber != null) {
					requisitionType = 46;
				}

				HashMap<String, Object> consignmentRequestInsertMap = new HashMap<>();
				consignmentRequestInsertMap.put("requisitionNumber", headerData.getRequisitionNumber());
				consignmentRequestInsertMap.put("requisitionDate", headerData.getRequisitionDate());
				consignmentRequestInsertMap.put("employeeId", headerData.getEmployeeId()); // RequestedBy
				consignmentRequestInsertMap.put("requisitionType", requisitionType);
				consignmentRequestInsertMap.put("sourceLocation", Integer.parseInt(headerData.getSourceLocation()));
				consignmentRequestInsertMap.put("destinationLocation", Integer.parseInt(headerData.getDestinationLocation()));
				consignmentRequestInsertMap.put("company", headerData.getCompanyId());
				consignmentRequestInsertMap.put("purchaseRequisitionId", purchaseRequisitionId);
				consignmentRequestInsertMap.put("costcenter", headerData.getCostcenter());
				consignmentRequestInsertMap.put("prRequestNo", headerData.getPrRequestNo());
				// consignmentRequestInsertMap.put("requestDate",
				// headerData.getRequestDate());
				if (headerData.getRequestDate().equals("") || headerData.getRequestDate().equals(null))
					consignmentRequestInsertMap.put("requestDate", null);
				else
					consignmentRequestInsertMap.put("requestDate", headerData.getRequestDate());
				consignmentRequestInsertMap.put("requestType", headerData.getRequestType());
				if (headerData.getRequestType() == 217) {

					consignmentRequestInsertMap.put("flag", true);

				} else if (headerData.getRequestType() == 216) {
					consignmentRequestInsertMap.put("flag", false);

				}

				consignmentRequestInsertMap.put("purchaseRequisitionId", headerData.getPurchaseRequisitionId());

				namedParameterJdbcTemplate.update(ConsignmentRequestQueryUtil.UPDATE_CONSIGNMENT_HEADER, consignmentRequestInsertMap);
				isSuccess = true;
			} catch (DataAccessException e) {
				LOGGER.error("Error in getItemList", e);
			}
		}
		int j = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.COUNT_MAX, Integer.class,  purchaseRequisitionId );

		if (j > 0) {
			ConsignmentRequestSubBean consignmentRequesteSubBean = new ConsignmentRequestSubBean();

			jdbcTemplate.update(ConsignmentRequestQueryUtil.DELETE_DETAIL, purchaseRequisitionId);

			/*
			 * int GRNQTY = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.
			 * GET_GRN_QTY, Integer.class,
			 * Integer.parseInt(consignmentRequesteSubBean.getId())); int MISSUEQTY =
			 * jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil. GET_MI_QTY1,
			 * Integer.class, Integer.parseInt(consignmentRequesteSubBean.getId())); int
			 * availableQTY = 0; if (GRNQTY > MISSUEQTY) { availableQTY = GRNQTY -
			 * MISSUEQTY; consignmentRequesteSubBean.setAvailQuantity(availableQTY); } else
			 * if (GRNQTY < MISSUEQTY || GRNQTY == MISSUEQTY) { availableQTY = 0;
			 * consignmentRequesteSubBean.setAvailQuantity(availableQTY); }
			 */

			for (int k = 0; k < subData.size(); k++) {
				HashMap<String, Object> consignmentRequestInsertMap1 = new HashMap<>();
				consignmentRequestInsertMap1.put("purchaseRequisitionId", purchaseRequisitionId);
				consignmentRequestInsertMap1.put("itemId", Integer.parseInt(subData.get(k).getItemId()));
				consignmentRequestInsertMap1.put("quantity", subData.get(k).getQuantity());

				if (subData.get(k).getEddDate() == "" || subData.get(k).getEddDate() == null) {
					consignmentRequestInsertMap1.put("eddDate", null);
				} else {
					consignmentRequestInsertMap1.put("eddDate", subData.get(k).getEddDate());
				}
				// consignmentRequestInsertMap1.put("eddDate",
				// subData.get(k).getEddDate());
				consignmentRequestInsertMap1.put("eddDate", subData.get(k).getEddDate());
				consignmentRequestInsertMap1.put("itemdescription", subData.get(k).getItemdescription());
				consignmentRequestInsertMap1.put("pendingQty", subData.get(k).getQuantity());

				if (subData.get(k).getAltuom() == null) {
					subData.get(k).setAltuom(0);
				}
				if (!subData.get(k).getAltuom().equals(0))
					consignmentRequestInsertMap1.put("altuom", subData.get(k).getAltuom());
				else
					consignmentRequestInsertMap1.put("altuom", 0);

				if (subData.get(k).getAltqty() != 0)
					consignmentRequestInsertMap1.put("altqty", subData.get(k).getAltqty());
				else
					consignmentRequestInsertMap1.put("altqty", 0);
				namedParameterJdbcTemplate.update(ConsignmentRequestQueryUtil.INSERT_CONSIGNMENT_SUBDATA, consignmentRequestInsertMap1);
			}
			isSuccess = true;

		}

		return isSuccess;
	}

	@Override
	public boolean deleteConsignmentRequest(int purchaseRequisitionId) throws CustomException {
		boolean isDeleted = false;

		try {
			int rowServiceDetail = jdbcTemplate.update(ConsignmentRequestQueryUtil.DELETE_DETAIL, purchaseRequisitionId);
			int rowServiceHeader = jdbcTemplate.update(ConsignmentRequestQueryUtil.DELETE_HEADER, purchaseRequisitionId);

			isDeleted = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete Store to store", e);
		}

		return isDeleted;
	}

	@Override
	public ConsignmentRequestSubBean issueStatus(Integer reqId, Integer issueStatus) throws Exception {
		ConsignmentRequestSubBean consignmentRequesteSubBean = new ConsignmentRequestSubBean();
		// TODO Auto-generated method stub
		try {
			consignmentRequesteSubBean = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.issueStatus, new BeanPropertyRowMapper<>(ConsignmentRequestSubBean.class), issueStatus, reqId);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getItemList", e);
		}
		return consignmentRequesteSubBean;
	}

	// Material Request Print
	@Override
	public ConsignmentRequestResultBean printMaterialRequest(Integer materialReqID) {
		ConsignmentRequestResultBean consignmentRequesteResultBean = new ConsignmentRequestResultBean();
		ConsignmentRequest objGeneralInvoiceBean = new ConsignmentRequest();
		List<ConsignmentRequestSubBean> objList = new ArrayList<>();
		try {
			System.out.println(materialReqID);
			objGeneralInvoiceBean = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.get_material_req_pdf_header_values, new Object[] { materialReqID }, new BeanPropertyRowMapper<>(ConsignmentRequest.class));

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ConsignmentRequestQueryUtil.get_material_req_pdf_detail_values, new Object[] { materialReqID });
			for (Map row : rows) {

				ConsignmentRequestSubBean consignmentRequesteSubBean = new ConsignmentRequestSubBean();

				consignmentRequesteSubBean.setSlNo((Integer) row.get("id"));
				consignmentRequesteSubBean.setPurchaseRequisitionId((Integer) row.get("purchaseRequisitionId"));
				consignmentRequesteSubBean.setItemName((String) row.get("itemName"));
				consignmentRequesteSubBean.setItemDesc((String) row.get("itemDesc"));
				consignmentRequesteSubBean.setItemCategoryName((String) row.get("itemCategoryName"));
				consignmentRequesteSubBean.setQuantity((double) row.get("quantity"));
				consignmentRequesteSubBean.setUomName((String) row.get("uomName"));
				consignmentRequesteSubBean.setEddDate((String) row.get("eddDate"));

				objList.add(consignmentRequesteSubBean);
			}
			consignmentRequesteResultBean.setHeaderData(objGeneralInvoiceBean);
			consignmentRequesteResultBean.setSubData(objList);
		} catch (Exception e) {
			// LOGGER.error("Error in List", e);
			e.printStackTrace();
		}
		return consignmentRequesteResultBean;

	}

	@Override
	public BasicResultBean getPRnumberduplicate(String prnumber) {
		BasicResultBean BasicResultBean = new BasicResultBean();
		try {
			int count = 0;
			count = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_REQUEST_NUMBER, Integer.class, prnumber);
			if (count > 0) {
				BasicResultBean.setMessage("PR Request Number Already Available!! Pls Try another Number");
			} else if (count == 0) {
				BasicResultBean.setMessage("SUCCESS");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return BasicResultBean;
	}

	@Override
	public BasicResultBean getPRnumberduplicate(String prnumber, String PRId) {
		BasicResultBean BasicResultBean = new BasicResultBean();
		try {
			int count = 0;
			count = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_REQUEST_NUMBER_UPDATE, Integer.class, prnumber, PRId);
			if (count > 0) {
				BasicResultBean.setMessage("PR Request Number Already Available!! Pls Try another Number");
			} else if (count == 0) {
				BasicResultBean.setMessage("SUCCESS");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return BasicResultBean;
	}

	@Override
	public boolean insertConReq(List<ConsignmentRequest> consignmentresultbean) {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		boolean isSuccess = false;
		ConsignmentRequestResultBean consignmentRequesteResultBean = null;
		String requisitionNumber = null;
		String PRNumber = null;
		int purchaseRequisitionId = 0;

		synchronized (this) {
			try {

				for (ConsignmentRequest Cbean : consignmentresultbean) {
					ConsignmentRequest headerData = Cbean;
					List<ConsignmentRequestSubBean> subData = Cbean.getItemdetail1();

					PRNumber = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GENERATE_REQ_NO_SERIES, String.class);
					if (PRNumber == null) {
						requisitionNumber = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GENERATE_REQ_NO_1, String.class);

					} else {
						if (!PRNumber.equals("")) {
							requisitionNumber = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GENERATE_REQ_NO, String.class, PRNumber, PRNumber);

						} else {
							requisitionNumber = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GENERATE_REQ_NO_1, String.class);

						}
					}

					// requisitionNumber =
					// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GENERATE_REQ_NO,
					// String.class);

					String comapnyCode = headerData.getCompanyId();
					System.out.println("***************************************" + comapnyCode);
					String CompanyShortName = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME, String.class, comapnyCode);

					requisitionNumber = CompanyShortName.concat("-" + requisitionNumber);
					Integer requisitionType = headerData.getRequisitionType();
					if (requisitionNumber != null) {
						requisitionType = 126;
					}

					HashMap<String, Object> consignmentRequestInsertMap = new HashMap<>();
					consignmentRequestInsertMap.put("flag", false);
					consignmentRequestInsertMap.put("requisitionType", requisitionType);

					consignmentRequestInsertMap.put("requisitionNumber", requisitionNumber);
					System.out.println("SetPR" + requisitionNumber);

					consignmentRequestInsertMap.put("organizationName", headerData.getCompanyId());
					System.out.println("SetORG" + headerData.getCompanyId());

					consignmentRequestInsertMap.put("sourceLocation", Integer.parseInt(headerData.getSourceLocation()));
					System.out.println("SetSRC" + headerData.getSourceLocation());

					consignmentRequestInsertMap.put("destinationLocation", Integer.parseInt(headerData.getDestinationLocation()));
					System.out.println("SetDES" + headerData.getDestinationLocation());

					consignmentRequestInsertMap.put("costcenter", headerData.getCostcenter());
					System.out.println("SetCC" + headerData.getCostcenter());

					consignmentRequestInsertMap.put("employeeId", userDetails.getUserId()); // RequestedBy
					System.out.println("SetRBy" + userDetails.getUserId());

					consignmentRequestInsertMap.put("prrequestnumber", headerData.getRequisitionNumber()); // Requisition
																											// number
					System.out.println("SetPRno" + headerData.getRequisitionNumber());

					consignmentRequestInsertMap.put("requisitionDate", headerData.getRequisitionDate());
					System.out.println("SetRD" + headerData.getRequisitionDate());

					consignmentRequestInsertMap.put("requisitionType", requisitionType);
					System.out.println("SetRtype" + requisitionType);

					consignmentRequestInsertMap.put("company", headerData.getCompanyId());
					System.out.println("SetCompany" + headerData.getCompanyId());

					consignmentRequestInsertMap.put("requisitionStatus", 68);
					int purchaseOrderRequest = 217;

					consignmentRequestInsertMap.put("requestType", purchaseOrderRequest);

					purchaseRequisitionId = namedParameterJdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.INSERT_CONSIGNMENT_HEADER_EXCEL_IMPORT, consignmentRequestInsertMap,Integer.class);

					isSuccess = true;
					if (isSuccess) {

						for (ConsignmentRequestSubBean consignmentbean : subData) {
							HashMap<String, Object> consignmentRequestInsertMap1 = new HashMap<>();
							consignmentRequestInsertMap1.put("purchaseRequisitionId", purchaseRequisitionId);
							consignmentRequestInsertMap1.put("itemId", Integer.parseInt(consignmentbean.getItemCode()));
							consignmentRequestInsertMap1.put("quantity", consignmentbean.getQuantity());
							if (consignmentbean.getEddDate() == "" || consignmentbean.getEddDate() == null) {
								consignmentRequestInsertMap1.put("eddDate", null);
							} else {
								consignmentRequestInsertMap1.put("eddDate", consignmentbean.getEddDate());

							}
							consignmentRequestInsertMap1.put("itemdescription", consignmentbean.getItemdescription());
							consignmentRequestInsertMap1.put("pendingQty", consignmentbean.getQuantity());
							namedParameterJdbcTemplate.update(ConsignmentRequestQueryUtil.INSERT_CONSIGNMENT_SUBDATA_EXCEL_IMPORT, consignmentRequestInsertMap1);
						}
						isSuccess = true;

					}
				}

			} catch (DataAccessException e) {
				LOGGER.error("Error in getItemList", e);
			}
		}

		return isSuccess;
	}

	@Override
	public boolean updateApproveMR(ConsignmentRequestResultBean consignmentRequetResultBean) {
		boolean isSuccess = false;
		ConsignmentRequest headerData = consignmentRequetResultBean.getHeaderData();
		List<ConsignmentRequestSubBean> subData = consignmentRequetResultBean.getSubData();
		String requisitionNumber = null;
		int purchaseRequisitionId = headerData.getPurchaseRequisitionId();

		int j = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.COUNT_MAX,  Integer.class, purchaseRequisitionId );

		if (j > 0) {
			ConsignmentRequestSubBean consignmentRequesteSubBean = new ConsignmentRequestSubBean();

			// jdbcTemplate.update(ConsignmentRequestQueryUtil.DELETE_DETAIL,
			// purchaseRequisitionId);

			/*
			 * int GRNQTY = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.
			 * GET_GRN_QTY, Integer.class,
			 * Integer.parseInt(consignmentRequesteSubBean.getId())); int MISSUEQTY =
			 * jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil. GET_MI_QTY1,
			 * Integer.class, Integer.parseInt(consignmentRequesteSubBean.getId())); int
			 * availableQTY = 0; if (GRNQTY > MISSUEQTY) { availableQTY = GRNQTY -
			 * MISSUEQTY; consignmentRequesteSubBean.setAvailQuantity(availableQTY); } else
			 * if (GRNQTY < MISSUEQTY || GRNQTY == MISSUEQTY) { availableQTY = 0;
			 * consignmentRequesteSubBean.setAvailQuantity(availableQTY); }
			 */

			for (int k = 0; k < subData.size(); k++) {
				HashMap<String, Object> consignmentRequestInsertMap1 = new HashMap<>();
				// consignmentRequestInsertMap1.put("purchaseRequisitionId",
				// purchaseRequisitionId);
				// consignmentRequestInsertMap1.put("itemId",
				// Integer.parseInt(subData.get(k).getItemId()));
				consignmentRequestInsertMap1.put("quantity", subData.get(k).getQuantity());

				if (subData.get(k).getEddDate() == "" || subData.get(k).getEddDate() == null) {
					consignmentRequestInsertMap1.put("eddDate", null);
				} else {
					consignmentRequestInsertMap1.put("eddDate", subData.get(k).getEddDate());
				}
				// consignmentRequestInsertMap1.put("eddDate",
				// subData.get(k).getEddDate());
				consignmentRequestInsertMap1.put("eddDate", subData.get(k).getEddDate());
				consignmentRequestInsertMap1.put("itemdescription", subData.get(k).getItemdescription());
				// consignmentRequestInsertMap1.put("pendingQty", subData.get(k).getQuantity());

				if (subData.get(k).getAltuom() == null) {
					subData.get(k).setAltuom(0);
				}
				if (!subData.get(k).getAltuom().equals(0))
					consignmentRequestInsertMap1.put("altuom", subData.get(k).getAltuom());
				else
					consignmentRequestInsertMap1.put("altuom", 0);

				if (subData.get(k).getAltqty() != 0)
					consignmentRequestInsertMap1.put("altqty", subData.get(k).getAltqty());
				else
					consignmentRequestInsertMap1.put("altqty", 0);
				// namedParameterJdbcTemplate.update(ConsignmentRequestQueryUtil.INSERT_CONSIGNMENT_SUBDATA,
				// consignmentRequestInsertMap1);

				consignmentRequestInsertMap1.put("purchaseRequisitionId", purchaseRequisitionId);
				consignmentRequestInsertMap1.put("itemId", Integer.parseInt(subData.get(k).getItemId()));

				jdbcTemplate.update(ConsignmentRequestQueryUtil.UPDATE_CONSIGNMENT_SUBDATA, subData.get(k).getQuantity(), subData.get(k).getEddDate(), subData.get(k).getItemdescription(), subData.get(k).getAltuom(), subData.get(k).getAltqty(), purchaseRequisitionId, Integer.parseInt(subData.get(k).getItemId()));

			}
			isSuccess = true;

		}

		return isSuccess;
	}

}
