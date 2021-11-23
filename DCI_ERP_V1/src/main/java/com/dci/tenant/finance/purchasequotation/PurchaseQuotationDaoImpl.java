package com.dci.tenant.finance.purchasequotation;

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
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CommonUtil;
import com.dci.common.util.CustomException;
import com.dci.common.util.DefTableBean;
import com.dci.master.settings.UOM.EntityBean;
import com.dci.tenant.finance.consignmentRequest.ConsignmentRequestQueryUtil;
import com.dci.tenant.finance.purchaseorder.PurchaseOrderQuertyUtil;
import com.dci.tenant.finance.storeToStore.StoreToStore;
import com.dci.tenant.finance.storeToStore.StoreToStoreSubBean;
import com.dci.tenant.user.UserDetail;


@Repository
public class PurchaseQuotationDaoImpl implements IPurchaseQuotationDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseQuotationDaoImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<EntityBean> getVendorList() throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<EntityBean> vendorList = null;
		try {
			vendorList = jdbcTemplate.query(PurchaseQuotationQueryUtil.SELECT_VENDOR_LIST, new BeanPropertyRowMapper<>(EntityBean.class), userDetails.getCompanyCode());
		} catch (DataAccessException e) {
			LOGGER.error("Error in getVendorList", e);
		}
		return vendorList;
	}

	@Override
	public PurchaseQuotationResultBean getPurchaseQuotationList() throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		PurchaseQuotationResultBean resultBean = new PurchaseQuotationResultBean();
		List<PurchaseQuotation> quotationList = null;
		try {
			quotationList = jdbcTemplate.query(PurchaseQuotationQueryUtil.SELECT_PURCHASE_QUOTATION_LIST, new BeanPropertyRowMapper<>(PurchaseQuotation.class), userDetails.getCompanyCode());
			resultBean.setQuotationList(quotationList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getPurchaseQuotationList", e);
		}
		return resultBean;
	}

	@Override
	public List<StoreToStore> getRequisitionList() throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<StoreToStore> requisitionList = null;
		try {
			int /* requisitionType = 118, */ requisitionStatus = 67;
			requisitionList = jdbcTemplate.query(PurchaseQuotationQueryUtil.SELECT_APPROVED_REQUISITION_LIST, new Object[] { requisitionStatus, 213, userDetails.getCompanyCode() }, new BeanPropertyRowMapper<>(StoreToStore.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getRequisitionList", e);
		}
		return requisitionList;
	}

	@Override
	public List<StoreToStore> getRequisitionList(String companyId) throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<StoreToStore> requisitionList = null;
		try {
			int /* requisitionType = 118, */ requisitionStatus = 67;
			requisitionList = jdbcTemplate.query(PurchaseQuotationQueryUtil.SELECT_APPROVED_REQUISITION_LIST, new Object[] { requisitionStatus, 213, companyId }, new BeanPropertyRowMapper<>(StoreToStore.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getRequisitionList", e);
		}
		return requisitionList;
	}

	@Override
	public List<StoreToStore> getRequisitionListByVendor(String vendorId) throws CustomException {
		List<StoreToStore> requisitionList = null;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			int requisitionType = 126, requisitionStatus = 68;

			requisitionList = jdbcTemplate.query(PurchaseQuotationQueryUtil.SELECT_APPROVED_REQUISITION_LIST1, new Object[] { requisitionType, requisitionStatus, userDetails.getCompanyCode(), vendorId }, new BeanPropertyRowMapper<>(StoreToStore.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getRequisitionList", e);
		}
		return requisitionList;
	}

	@Override
	public List<DefTableBean> getTaxList() throws CustomException {
		List<DefTableBean> taxList = null;
		try {
			taxList = jdbcTemplate.query(PurchaseQuotationQueryUtil.SELECT_TAX_LIST, new BeanPropertyRowMapper<>(DefTableBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxList", e);
		}
		return taxList;
	}

	@Override
	public PurchaseQuotationResultBean getRequisitionItemList(PurchaseQuotation purchaseQuotation) throws CustomException {
		PurchaseQuotationResultBean resultBean = new PurchaseQuotationResultBean();
		List<StoreToStoreSubBean> itemList = null;
		try {
			StoreToStore requisition = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.SELECT_PURCHASE_REQUISITION, new BeanPropertyRowMapper<>(StoreToStore.class), purchaseQuotation.getRequisitionId());
			itemList = jdbcTemplate.query(PurchaseQuotationQueryUtil.SELECT_ITEM_LIST_BY_VENDOR_MIN_QUANTITY, new BeanPropertyRowMapper<>(StoreToStoreSubBean.class), purchaseQuotation.getVendorId(), purchaseQuotation.getRequisitionId());
			resultBean.getPurchaseQuotationDetail().setRequisitionNo(requisition.getRequisitionNumber());
			resultBean.getPurchaseQuotationDetail().setReqDate(requisition.getRequisitionDate());
			resultBean.getPurchaseQuotationDetail().setLocationName(requisition.getLocationName());
			resultBean.getPurchaseQuotationDetail().setCityName(requisition.getCityName());
			resultBean.getPurchaseQuotationDetail().setStateCode(requisition.getStateCode());
			resultBean.getPurchaseQuotationDetail().setStateName(requisition.getStateName());
			resultBean.getPurchaseQuotationDetail().setStreet(requisition.getStreet());
			resultBean.getPurchaseQuotationDetail().setPincode(requisition.getPincode());
			resultBean.getPurchaseQuotationDetail().setCountry(requisition.getCountryName());

			resultBean.setItemList(itemList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getRequisitionItemList", e);
		}
		return resultBean;
	}

	@Override
	public PurchaseQuotationResultBean getWOItemList(PurchaseQuotation purchaseQuotation) throws CustomException {
		PurchaseQuotationResultBean resultBean = new PurchaseQuotationResultBean();
		List<StoreToStoreSubBean> itemList = null;
		try {
			StoreToStore requisition = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.SELECT_WO_DETAILS, new BeanPropertyRowMapper<>(StoreToStore.class), purchaseQuotation.getWorkOrderId());
			itemList = jdbcTemplate.query(PurchaseQuotationQueryUtil.SELECT_WO_ITEM_LIST, new BeanPropertyRowMapper<>(StoreToStoreSubBean.class), purchaseQuotation.getVendorId(), purchaseQuotation.getWorkOrderId(), purchaseQuotation.getWorkOrderId(), purchaseQuotation.getVendorId());
			resultBean.getPurchaseQuotationDetail().setRequisitionNo(requisition.getRequisitionNumber());
			resultBean.getPurchaseQuotationDetail().setReqDate(requisition.getRequisitionDate());
			resultBean.getPurchaseQuotationDetail().setLocationName(requisition.getLocationName());
			resultBean.getPurchaseQuotationDetail().setCityName(requisition.getCityName());
			resultBean.getPurchaseQuotationDetail().setStateCode(requisition.getStateCode());
			resultBean.getPurchaseQuotationDetail().setStateName(requisition.getStateName());
			resultBean.getPurchaseQuotationDetail().setStreet(requisition.getStreet());
			resultBean.getPurchaseQuotationDetail().setPincode(requisition.getPincode());
			resultBean.getPurchaseQuotationDetail().setCountry(requisition.getCountryName());

			resultBean.setItemList(itemList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getRequisitionItemList", e);
		}
		return resultBean;
	}

	@Override
	public PurchaseQuotationResultBean getItem(int requisitionId, int itemId) throws CustomException {
		PurchaseQuotationResultBean resultBean = new PurchaseQuotationResultBean();
		try {
			PurchaseQuotationDetail requisition = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.SELECT_REQUISITION_ITEM, new BeanPropertyRowMapper<>(PurchaseQuotationDetail.class), requisitionId, itemId);

			/*String savedqty = jdbcTemplate.queryForObject(StockTransferQueryUtil.CHECK_QUANTITY_PQ, String.class, requisitionId, requisition.getItemId());
			if (savedqty == null) {
				savedqty = "0";
			}*/
			double mrQty = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MR_PENDING_QTY, Double.class, requisitionId, requisition.getItemId());
			double pqQty = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_PQ_QTY, Double.class, requisitionId, requisition.getItemId());

			String requisitionNumber = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MR_NUM, String.class, requisitionId);

			double pOQty = 0;

			pOQty = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_PO_QTY, Double.class, requisitionNumber, requisition.getItemId());

			double MIQty = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MI_QTY, Double.class, requisitionId, requisition.getItemId());

			double Total = 0;
			double sub = 0;
			Total = mrQty - pOQty;
			requisition.setRequestedQty(mrQty);
			requisition.setCheckQuantity(pOQty);
			requisition.setPedningQuantity(Total);

			int GRNQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_GRN_QTY, Integer.class, itemId);
			int MISSUEQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_MI_QTY, Integer.class, itemId);

			// 13/02/21 gatepass item included
			int GatePassOut = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSOUT_QTY, Integer.class, itemId);
			int GatePassIn = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSIN_QTY, Integer.class, itemId);
			// end
			// int availableQTY = 0;
			// if (GRNQTY > MISSUEQTY) {
			// availableQTY = GRNQTY - MISSUEQTY;
			// requisition.setAvailableQty(availableQTY);
			// } else if (GRNQTY < MISSUEQTY || GRNQTY == MISSUEQTY) {
			// availableQTY = 0;
			// requisition.setAvailableQty(availableQTY);
			//
			// }
			double itemOpeningQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_OPENING_QTY, Double.class, itemId);

			double availableQTY = 0;
			// availableQTY = (GRNQTY + itemOpeningQTY) - MISSUEQTY;

			availableQTY = (GRNQTY + itemOpeningQTY) - (MISSUEQTY + (GatePassOut - GatePassIn));

			if (availableQTY < 0)
				availableQTY = 0;
			requisition.setAvailableQty(availableQTY);
			// OLD UNIT PRICE..................................

			// Added for getting old unit price

			// int itemId = detail.get(i).getItemId();
			// String description = detail.get(i).getPurchaseItemDesc();
			String description = requisition.getItemDescription();
			int[] type = new int[] { Types.INTEGER, Types.CHAR };
			Object[] param = new Object[] { itemId, description };
			String oldUnitPrice = "";
			List<Map<String, Object>> ros1 = jdbcTemplate.queryForList(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL_PRICE_WITH_DESC, param, type);
			for (Map row : ros1) {
				requisition.setOldunitPrice((Double) row.get("oldUnitPrice"));
				oldUnitPrice = row.get("oldUnitPrice").toString();
			}
			int[] type1 = new int[] { Types.INTEGER };
			Object[] param1 = new Object[] { itemId };
			if (oldUnitPrice.equals("") || oldUnitPrice.equals(null)) {
				List<Map<String, Object>> ros = jdbcTemplate.queryForList(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL_PRICE, param1, type1);
				for (Map row : ros) {
					requisition.setOldunitPrice((Double) row.get("oldUnitPrice"));
					oldUnitPrice = row.get("oldUnitPrice").toString();
				}
			}
			if (oldUnitPrice == null) {
				int[] type2 = new int[] { Types.INTEGER, Types.INTEGER };

				Object[] param2 = new Object[] { itemId, itemId };
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL_PRICE_NULL, param2, type2);
				for (Map row : rows) {
					requisition.setOldunitPrice((Double) row.get("oldUnitPrice"));
				}
			}
			resultBean.setPurchaseQuotationDetail(requisition);
			// }

		} catch (DataAccessException e) {
			LOGGER.error("Error in getItem", e);
		}
		return resultBean;
	}

	@SuppressWarnings("deprecation")
	@Transactional
	@Override
	public PurchaseQuotationResultBean insertPurchaseQuotation(PurchaseQuotation purchaseQuotation) throws CustomException {
		PurchaseQuotationResultBean resultBean = new PurchaseQuotationResultBean();
		try {
			Integer entityID;

			entityID = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.get_entity_id, new Object[] { purchaseQuotation.getVendorId() }, Integer.class);

			String quotationNo = generatePurchaseQuoteNumber();
			purchaseQuotation.setQuotationNo(quotationNo);
			Map<String, Object> quotationMap = new HashMap<>();
			quotationMap.put("quoteNo", purchaseQuotation.getQuotationNo());
			quotationMap.put("quoteDate", purchaseQuotation.getQuoteDate());
			quotationMap.put("purchaseFor", purchaseQuotation.getPurchaseFor());
			quotationMap.put("purchaseType", purchaseQuotation.getPurchaseType());
			quotationMap.put("entityId", entityID);
			quotationMap.put("remarks", purchaseQuotation.getRemarks());
			quotationMap.put("createdBy", purchaseQuotation.getCreatedBy());
			quotationMap.put("subTotal", purchaseQuotation.getSubTotal());
			quotationMap.put("totalDiscount", purchaseQuotation.getTotalDiscount());
			quotationMap.put("totalTax", purchaseQuotation.getTotalTax());
			quotationMap.put("freight", purchaseQuotation.getTotalFreight());
			quotationMap.put("otherCharges", purchaseQuotation.getOtherCharges());
			quotationMap.put("grandTotal", purchaseQuotation.getGrandTotal());
			int purchaseType = purchaseQuotation.getPurchaseType();
			if (purchaseType != 31) {
				boolean ifFixedPrice = purchaseQuotation.getFixedPrice().equalsIgnoreCase("Y") ? true : false;
				boolean ifFixedQty = purchaseQuotation.getFixedQty().equalsIgnoreCase("Y") ? true : false;
				quotationMap.put("fixedPrice", ifFixedPrice);
				quotationMap.put("fixedQty", ifFixedQty);
			} else {
				quotationMap.put("fixedPrice", false);
				quotationMap.put("fixedQty", false);
			}
			quotationMap.put("validFromDate", CommonUtil.convertSqlDateFormat(purchaseQuotation.getValidFromDate()));
			quotationMap.put("validToDate", CommonUtil.convertSqlDateFormat(purchaseQuotation.getValidToDate()));
			quotationMap.put("paymentTerms", purchaseQuotation.getPaymentTerms());
			// quotationMap.put("company", "C0008");
			quotationMap.put("company", purchaseQuotation.getCompanyId());

			quotationMap.put("costcenter", purchaseQuotation.getCostcenter());
			int quotationId = namedParameterJdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.INSERT_PURCHASE_QUOTAION, quotationMap,Integer.class);

			if (purchaseQuotation.getQuotationDetailList() != null) {
				for (PurchaseQuotationDetail quotationDetail : purchaseQuotation.getQuotationDetailList()) {
					// if (quotationDetail.isSelect() == false) {
					Map<String, Object> quotationDtlMap = new HashMap<>();
					quotationDtlMap.put("quotationId", quotationId);
					quotationDtlMap.put("requisitionId", quotationDetail.getRequisitionId());
					quotationDtlMap.put("itemId", quotationDetail.getItemId());
					// quotationDtlMap.put("quantityId",
					// quotationDetail.getVendorConvertedQuantity());

					quotationDtlMap.put("quantityId", quotationDetail.getQuantity());
					quotationDtlMap.put("vendorQuantity", quotationDetail.getVendorQuantity());
					quotationDtlMap.put("vendoruom", Integer.parseInt(quotationDetail.getVendorUOM()));
					quotationDtlMap.put("edd", quotationDetail.getEddDate());
					String taxIds = "";
					for (int i = 0; i < quotationDetail.getTaxIdslist().size(); i++) {
						if (taxIds != "") {
							taxIds = taxIds + "," + quotationDetail.getTaxIdslist().get(i);
						} else {
							taxIds = taxIds.trim();
							taxIds = taxIds + quotationDetail.getTaxIdslist().get(i);
						}

					}
					// String discount
					// =quotationDetail.getDiscount().toString();
					// String value = String.valueOf(discount);
					String disc = quotationDetail.getDiscount();
					Double d = 0.0;
					if (disc == null || disc == "") {
						d = new Double(0.0);// first
					} else {
						d = new Double(quotationDetail.getDiscount());
					}
					int discountTypeId = 0; // way.
					Double discount = Double.valueOf(d);
					if (quotationDetail.getDiscountType().equals(null) || quotationDetail.getDiscountType().equals("")) {
						discountTypeId = 0;

					} else {
						discountTypeId = Integer.parseInt(quotationDetail.getDiscountType());

					}

					quotationDtlMap.put("taxId", taxIds);
					quotationDtlMap.put("discountType", discountTypeId);
					// quotationDtlMap.put("discountType",
					// quotationDetail.getDiscountTypeId());
					quotationDtlMap.put("percentage", quotationDetail.getDiscountPercent());
					quotationDtlMap.put("amount", quotationDetail.getAmount());
					quotationDtlMap.put("deliveryLeadTime", quotationDetail.getDeliveryLeadTime());
					quotationDtlMap.put("status", quotationDetail.getQueryStatus());
					quotationDtlMap.put("unitPrice", quotationDetail.getUnitPrice());
					quotationDtlMap.put("disAmount", discount);
					quotationDtlMap.put("taxPercentage", quotationDetail.getTaxPercentage());
					quotationDtlMap.put("taxAmount", quotationDetail.getTaxAmt());
					quotationDtlMap.put("taxAmountCGST", quotationDetail.getTaxCGST());
					quotationDtlMap.put("taxAmountSGST", quotationDetail.getTaxSGST());
					quotationDtlMap.put("taxAmountIGST", quotationDetail.getTaxIGST());
					quotationDtlMap.put("itemDescirption", quotationDetail.getItemDescription());
					quotationDtlMap.put("taxAmountCGSTinPercent", quotationDetail.getTaxCGSTinPercent());
					quotationDtlMap.put("taxAmountSGSTinPercent", quotationDetail.getTaxSGSTinPercent());
					quotationDtlMap.put("taxAmountIGSTinPercent", quotationDetail.getTaxIGSTinPercent());
					quotationDtlMap.put("costcenter", quotationDetail.getCostcenter());
					quotationDtlMap.put("poNumber", purchaseQuotation.getPurchaseOrderNum());

					quotationDtlMap.put("purchaseuom", quotationDetail.getUom());
					quotationDtlMap.put("purchaseqty", quotationDetail.getQuantity());

					/*
					 * double PPurchaseqty = quotationDetail.getQuantity(); double Qqty =
					 * quotationDetail.getVendorQuantity(); if (PPurchaseqty != Qqty) { double fqty
					 * = (PPurchaseqty - Qqty); double pendingqty =
					 * jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil .GET_PENDING_QTY_PQ,
					 * Double.class, quotationDetail.getRequisitionId(),
					 * quotationDetail.getItemId()); pendingqty = pendingqty + fqty;
					 * jdbcTemplate.update(PurchaseQuotationQueryUtil. UPDATE_PENDING_QTY_PQ, new
					 * Object[] { fqty, quotationDetail.getRequisitionId(),
					 * quotationDetail.getItemId() });
					 * 
					 * }
					 */
					namedParameterJdbcTemplate.update(PurchaseQuotationQueryUtil.INSERT_PURCHASE_QUOTATION_DETAIL, quotationDtlMap);
					// }

				}
			}
			resultBean.setSuccess(true);
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertPurchaseQuotation", e);
		}
		return resultBean;
	}

	/**
	 * generate Purchase Quote No while insert record
	 * 
	 * @return
	 */
	public String generatePurchaseQuoteNumber() {

		String purchaseQuoteNoValue = "", sDefaultPQNo = "";
		try {

			sDefaultPQNo = "PQ00001";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseQuotationQueryUtil.AUTO_GEN_PURCHASE_QUOTE_NO, new Object[] { sDefaultPQNo });
			for (Map row : rows) {
				purchaseQuoteNoValue = (String) row.get("purchase_quote_no");
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Generate Credit Note Number", e);
		}
		return purchaseQuoteNoValue;
	}

	@Transactional
	@Override
	public PurchaseQuotationResultBean deletePurchaseQuotation(Integer quotationId) throws CustomException {
		PurchaseQuotationResultBean resultBean = new PurchaseQuotationResultBean();
		try {
			jdbcTemplate.update(PurchaseQuotationQueryUtil.DELETE_PURCHASE_QUOTATION_DETAIL_BY_QUOTID, quotationId);
			jdbcTemplate.update(PurchaseQuotationQueryUtil.DELETE_PURCHASE_QUOTATION_BY_QUOTID, quotationId);
			resultBean.setSuccess(true);
		} catch (DataAccessException e) {
			resultBean.setSuccess(false);
			LOGGER.error("Error in deletePurchaseQuotation", e);
		}
		return resultBean;
	}

	@Override
	public PurchaseQuotationResultBean getVendorDetails(String vendorId) {
		PurchaseQuotationResultBean resultBean = new PurchaseQuotationResultBean();
		try {
			PurchaseQuotation vendor = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_VENDOR_DETAILS, new BeanPropertyRowMapper<>(PurchaseQuotation.class), vendorId);
			resultBean.setPurchaseQuotation(vendor);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getVendorDetails", e);
		}
		return resultBean;
	}

	@Override
	public PurchaseQuotationResultBean getTaxDetails(int taxId) {
		PurchaseQuotationResultBean resultBean = new PurchaseQuotationResultBean();
		List<PurchaseQuotationDetail> subTaxList = new ArrayList<>();
		try {
			PurchaseQuotationDetail tax = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_TAX_DETAILS, new BeanPropertyRowMapper<>(PurchaseQuotationDetail.class), taxId);
			subTaxList = jdbcTemplate.query(PurchaseQuotationQueryUtil.GET_SUB_TAX_DETAILS, new Object[] { taxId }, new BeanPropertyRowMapper<>(PurchaseQuotationDetail.class));
			tax.setSubTaxList(subTaxList);
			resultBean.setPurchaseQuotationDetail(tax);

		} catch (DataAccessException e) {
			LOGGER.error("Error in get Tax Details", e);
		}
		return resultBean;
	}

	@Override
	public PurchaseQuotation getPurchaseQuoteDataOnEdit(Integer quotationId) {
		List<PurchaseQuotationDetail> quotationDetailList = new ArrayList<>();
		PurchaseQuotation objPurchaseQuotation = new PurchaseQuotation();
		PurchaseQuotationDetail objIdsBean = new PurchaseQuotationDetail();
		try {
			objPurchaseQuotation = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_PURCHASE_QUOTATION_HDR_LIST_ON_EDIT, new Object[] { quotationId }, new BeanPropertyRowMapper<>(PurchaseQuotation.class));
			quotationDetailList = jdbcTemplate.query(PurchaseQuotationQueryUtil.GET_PURCHASE_QUOTATION_DTL_LIST_ON_EDIT, new Object[] { quotationId }, new BeanPropertyRowMapper<>(PurchaseQuotationDetail.class));

			for (PurchaseQuotationDetail objdetailbean : quotationDetailList) {
				String ids = objdetailbean.getLtaxIds();
				if (ids.contains(",")) {
					String taxIds[] = ids.split(",");
					String taxCodedtl = "";
					int i = 1;
					for (String txId : taxIds) {
						int tId = Integer.parseInt(txId);
						objIdsBean = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.getTaxCodeName, new Object[] { tId }, new BeanPropertyRowMapper<>(PurchaseQuotationDetail.class));
						if (taxCodedtl != "" && taxCodedtl != null) {
							taxCodedtl = taxCodedtl + "," + objIdsBean.getTaxCode();
						} else {
							taxCodedtl = taxCodedtl + objIdsBean.getTaxCode();
						}

						if (i == taxIds.length) {
							objdetailbean.setTaxCode(taxCodedtl);
						}
						i++;
					}
				} else {
					int tId = Integer.parseInt(ids);
					objIdsBean = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.getTaxCodeName, new Object[] { tId }, new BeanPropertyRowMapper<>(PurchaseQuotationDetail.class));
					objdetailbean.setTaxCode(objIdsBean.getTaxCode());
					objdetailbean.getTaxIdslist().add(ids);
				}

			}

			objPurchaseQuotation.setQuotationDetailList(quotationDetailList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getPurchaseQuotationList", e);
		}
		return objPurchaseQuotation;
	}

	@Override
	public PurchaseQuotationResultBean updatePurchaseQuotation(PurchaseQuotation purchaseQuotation) {
		PurchaseQuotationResultBean resultBean = new PurchaseQuotationResultBean();
		int detailValue = 0;
		int deleteValue = 0;
		try {

			Map<String, Object> quotationMap = new HashMap<>();
			quotationMap.put("quotationId", purchaseQuotation.getQuotationId());
			quotationMap.put("quoteNo", purchaseQuotation.getQuotationNo());
			quotationMap.put("quoteDate", purchaseQuotation.getQuoteDate());
			quotationMap.put("purchaseFor", purchaseQuotation.getPurchaseFor());
			quotationMap.put("purchaseType", purchaseQuotation.getPurchaseType());
			quotationMap.put("entityId", purchaseQuotation.getVendorId());
			quotationMap.put("remarks", purchaseQuotation.getRemarks());
			quotationMap.put("modifiedBy", purchaseQuotation.getModifiedBy());
			quotationMap.put("subTotal", purchaseQuotation.getSubTotal());
			quotationMap.put("totalDiscount", purchaseQuotation.getTotalDiscount());
			quotationMap.put("totalTax", purchaseQuotation.getTotalTax());
			quotationMap.put("freight", purchaseQuotation.getTotalFreight());
			quotationMap.put("othercharges", purchaseQuotation.getOtherCharges());
			quotationMap.put("grandTotal", purchaseQuotation.getGrandTotal());
			boolean ifFixedPrice = purchaseQuotation.getFixedPrice().equalsIgnoreCase("Y") ? true : false;
			boolean ifFixedQty = purchaseQuotation.getFixedQty().equalsIgnoreCase("Y") ? true : false;
			quotationMap.put("fixedPrice", ifFixedPrice);
			quotationMap.put("fixedQty", ifFixedQty);
			quotationMap.put("validFromDate", CommonUtil.convertSqlDateFormat(purchaseQuotation.getValidFromDate()));
			quotationMap.put("validToDate", CommonUtil.convertSqlDateFormat(purchaseQuotation.getValidToDate()));
			quotationMap.put("paymentTerms", purchaseQuotation.getPaymentTerms());
			quotationMap.put("company", "C0008");
			quotationMap.put("costcenter", purchaseQuotation.getCostcenter());
			int quotationId = namedParameterJdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.UPDATE_PURCHASE_QUOTAION_HDR, quotationMap,Integer.class);

			if (purchaseQuotation.getQuotationDetailList() != null) {

				for (PurchaseQuotationDetail purDetail : purchaseQuotation.getDeletedIl()) {
					deleteValue = jdbcTemplate.update(PurchaseQuotationQueryUtil.sDeleteQuotationDetail, purDetail.getQuotationDetailId());
				}

				for (PurchaseQuotationDetail quotationDetail : purchaseQuotation.getQuotationDetailList()) {
					Map<String, Object> quotationDtlMap = new HashMap<>();

					if (quotationDetail.getQuotationDetailId() > 0) {
						quotationDtlMap.put("quotationId", purchaseQuotation.getQuotationId());
						quotationDtlMap.put("quotationDetailId", quotationDetail.getQuotationDetailId());
						quotationDtlMap.put("requisitionId", quotationDetail.getRequisitionId());
						quotationDtlMap.put("itemId", quotationDetail.getItemId());
						quotationDtlMap.put("quantityId", quotationDetail.getVendorConvertedQuantity());
						quotationDtlMap.put("vendorQuantity", quotationDetail.getVendorQuantity());
						quotationDtlMap.put("vendoruom", quotationDetail.getVendoruom());
						quotationDtlMap.put("edd", quotationDetail.getEddDate());

						quotationDtlMap.put("discountType", quotationDetail.getDiscountTypeId());
						quotationDtlMap.put("percentage", quotationDetail.getDiscountPercent());
						quotationDtlMap.put("amount", quotationDetail.getAmount());
						quotationDtlMap.put("deliveryLeadTime", quotationDetail.getDeliveryLeadTime());
						quotationDtlMap.put("status", quotationDetail.getQueryStatus());
						quotationDtlMap.put("unitPrice", quotationDetail.getUnitPrice());
						quotationDtlMap.put("disAmount", quotationDetail.getDisAmt());
						quotationDtlMap.put("taxPercentage", quotationDetail.getTaxPercentage());
						quotationDtlMap.put("taxAmount", quotationDetail.getTaxAmt());
						namedParameterJdbcTemplate.update(PurchaseQuotationQueryUtil.UPDATE_PURCHASE_QUOTATION_DETAIL, quotationDtlMap);

					} else {
						quotationDtlMap.put("quotationId", quotationId);
						quotationDtlMap.put("requisitionId", quotationDetail.getRequisitionId());
						quotationDtlMap.put("itemId", quotationDetail.getItemId());
						quotationDtlMap.put("quantityId", quotationDetail.getVendorConvertedQuantity());
						quotationDtlMap.put("vendorQuantity", quotationDetail.getVendorQuantity());
						quotationDtlMap.put("vendoruom", quotationDetail.getVendoruom());
						quotationDtlMap.put("edd", quotationDetail.getEddDate());
						String taxIds = "";
						for (int i = 0; i < quotationDetail.getTaxIdslist().size(); i++) {
							if (taxIds != "") {
								taxIds = taxIds + "," + quotationDetail.getTaxIdslist().get(i);
							} else {
								taxIds = taxIds.trim();
								taxIds = taxIds + quotationDetail.getTaxIdslist().get(i);
							}

						}

						quotationDtlMap.put("taxId", taxIds);
						quotationDtlMap.put("discountType", quotationDetail.getDiscountTypeId());
						quotationDtlMap.put("percentage", quotationDetail.getDiscountPercent());
						quotationDtlMap.put("amount", quotationDetail.getAmount());
						quotationDtlMap.put("deliveryLeadTime", quotationDetail.getDeliveryLeadTime());
						quotationDtlMap.put("status", quotationDetail.getQueryStatus());
						quotationDtlMap.put("unitPrice", quotationDetail.getUnitPrice());
						quotationDtlMap.put("disAmount", quotationDetail.getDisAmt());
						quotationDtlMap.put("taxPercentage", quotationDetail.getTaxPercentage());
						quotationDtlMap.put("taxAmount", quotationDetail.getTaxAmt());
						namedParameterJdbcTemplate.update(PurchaseQuotationQueryUtil.INSERT_PURCHASE_QUOTATION_DETAIL, quotationDtlMap);
					}
				}

			}
			resultBean.setSuccess(true);
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertPurchaseQuotation", e);
		}
		return resultBean;
	}

	@Override
	public PurchaseQuotationResultBean checkPurchaseQuotationNumber(PurchaseQuotationDetail purchaseQuotation) throws CustomException {
		PurchaseQuotationResultBean bean = new PurchaseQuotationResultBean();
		Map<String, Object> quotationMap = new HashMap<>();
		quotationMap.put("puchaseDetailId", purchaseQuotation.getQuotationDetailId());
		quotationMap.put("itemId", purchaseQuotation.getItemId());
		int quotationId = namedParameterJdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.checkQuotationDetail, quotationMap,Integer.class);
		if (quotationId == 0) {
			bean.setSuccess(true);
		} else {
			if (quotationId > 0) {
				bean.setSuccess(false);
			}

		}
		return bean;
	}

	
	public String getPurchaseForList(String purchasefor) throws CustomException {
		String taxList = null;
		try {
			taxList = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.NEW_QUERY_FOR_PURCHASE, new Object[] { purchasefor }, String.class);
			System.out.println(taxList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxList", e);
		}
		return taxList;
	}

	public String getPurchaseTypeList(String purchasetype) {
		String list = null;
		try {
			list = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.NEW_QUERY_FOR_PURCHASE_TYPE, new Object[] { purchasetype }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	public String getVendorList(String entityid) {
		String list = null;
		try {
			list = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.NEW_QUERY_FOR_VENDOR_TYPE, new Object[] { entityid }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	public String getCompanyList(String companyid) {
		String list = null;
		try {
			list = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.NEW_COMPANY_LIST, new Object[] { companyid }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	public String getCostList(String costcenterid) {
		String list = null;
		try {
			list = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.NEW_COST_CENTER_LIST, new Object[] { costcenterid }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	public String getRequisitionIdNewList(String reqid) {
		String list = null;
		try {
			list = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.NEW_REQUISITION_LIST, new Object[] { reqid }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	public String getItemNewList(String itemid) {
		String list = null;
		try {
			list = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.NEW_ITEM_LIST, new Object[] { itemid }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	public String getUomList(String trim) {
		String list = null;
		try {
			list = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.NEW_UOM_LIST, new Object[] { trim }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	public String getStatusList(String status) {
		String list = null;
		try {
			list = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.STATUS_TYPE, new Object[] { status }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	public String getDiscountList(String discountype) {
		String list = null;
		try {
			list = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.DISCOUNT_TYPE, new Object[] { discountype }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	public String getTaxList(String tax) {
		String list = null;
		try {
			list = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.TAX, new Object[] { tax }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	@Override
	public List<StoreToStore> getWorkOrderList(String companyId) throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<StoreToStore> requisitionList = null;
		try {
			int Pending = 33;
			requisitionList = jdbcTemplate.query(PurchaseQuotationQueryUtil.SELECT_WORK_ORDER_REQUISITION_LIST, new Object[] { Pending, companyId }, new BeanPropertyRowMapper<>(StoreToStore.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getWorkOrderList", e);
		}
		return requisitionList;
	}

	@Override
	public PurchaseQuotationResultBean getWOItem(int requisitionId, int itemId) throws CustomException {
		PurchaseQuotationResultBean resultBean = new PurchaseQuotationResultBean();
		try {
			PurchaseQuotationDetail requisition = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.SELECT_REQUISITION_ITEM, new BeanPropertyRowMapper<>(PurchaseQuotationDetail.class), requisitionId, itemId);

			double GRNQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_GRN_QTY, Double.class, itemId);
			double MISSUEQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_MI_QTY, Double.class, itemId);
			// double availableQTY = 0;
			// if (GRNQTY > MISSUEQTY) {
			// availableQTY = GRNQTY - MISSUEQTY;
			// requisition.setAvailableQty(availableQTY);
			// } else if (GRNQTY < MISSUEQTY || GRNQTY == MISSUEQTY) {
			// availableQTY = 0;
			// requisition.setAvailableQty(availableQTY);
			//
			// }
			double itemOpeningQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_OPENING_QTY, Double.class, itemId);

			double availableQTY = 0;

			availableQTY = (GRNQTY + itemOpeningQTY) - MISSUEQTY;

			if (availableQTY < 0)
				availableQTY = 0;
			requisition.setAvailableQty(availableQTY);
			resultBean.setPurchaseQuotationDetail(requisition);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getItem", e);
		}
		return resultBean;
	}
}
