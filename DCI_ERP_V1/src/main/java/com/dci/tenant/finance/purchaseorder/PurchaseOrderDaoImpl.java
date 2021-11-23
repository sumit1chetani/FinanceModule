package com.dci.tenant.finance.purchaseorder;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;
import com.dci.common.util.CustomException;
import com.dci.common.util.NumberstoWordsConversion;
import com.dci.tenant.finance.cashbankpayment.CashBankPaymentQueryUtil;
import com.dci.tenant.finance.consignmentRequest.ConsignmentRequestQueryUtil;
import com.dci.tenant.finance.consignmentRequest.ConsignmentRequestSubBean;
import com.dci.tenant.finance.grn.GRNQueryUtil;
import com.dci.tenant.finance.journalvoucher.JournalVoucherQueryUtil;
import com.dci.tenant.finance.purchasequotation.PurchaseQuotationQueryUtil;
import com.dci.tenant.user.UserDetail;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Repository
public class PurchaseOrderDaoImpl implements PurchaseOrderDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	

	NumberstoWordsConversion wordingConversion;

	@Override
	public List<PurchaseOrder> getPurchaseOrderList(int purchaseType) throws Exception {
		System.out.println(purchaseType);
		List<PurchaseOrder> purchaseOrders = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_LIST, new Object[] {}, new BeanPropertyRowMapper<>(PurchaseOrder.class));
		return purchaseOrders;
	}

	@Override
	public List<PurchaseOrder> getTotalPurchaseOrderList() throws Exception {

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		// List<PurchaseOrder> purchaseOrders =
		// jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_TOTAL_PURCHASE_ORDER_LIST,
		// new Object[] { PurchaseConstants.RETAIN_STATUS_LIST,
		// userDetails.getCompanyCode() }, new
		// BeanPropertyRowMapper<>(PurchaseOrder.class));
		List<PurchaseOrder> purchaseOrders = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_TOTAL_PURCHASE_ORDER_LIST, new Object[] { PurchaseConstants.RETAIN_STATUS_LIST }, new BeanPropertyRowMapper<>(PurchaseOrder.class));

		return purchaseOrders;
	}

	@Override
	public List<PurchaseSelect> getPurchaseOrderDefList(int formFieldId) throws Exception {
		List<PurchaseSelect> purchaseOrders = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_FORM_FIELD_VALUES_PURCHASE_ORDER, new Object[] { formFieldId }, new BeanPropertyRowMapper<>(PurchaseSelect.class));
		return purchaseOrders;
	}

	@Override
	public List<PurchaseSelect> getCompanyNames(String user) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// List<PurchaseSelect> purchaseSelects =
		// jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_COMPANY_NAMES, new
		// Object[] { userDetails.getCompanyCode() }, new
		// BeanPropertyRowMapper<>(PurchaseSelect.class));

		List<PurchaseSelect> purchaseSelects = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_COMPANY_NAMES, new BeanPropertyRowMapper<>(PurchaseSelect.class));
		return purchaseSelects;
	}

	@Override
	public List<PurchaseSelect> getVendorNames() throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<PurchaseSelect> purchaseSelects = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_VENDOR_NAMES, new BeanPropertyRowMapper<>(PurchaseSelect.class));
		return purchaseSelects;
	}

	@Override
	public List<PurchaseSelect> getPurchaseReqDropDown() throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<PurchaseSelect> purchaseSelects = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_PURCHASE_REQ_DROPDOWN, new BeanPropertyRowMapper<>(PurchaseSelect.class));
		return purchaseSelects;
	}

	@Override
	public List<PurchaseSelect> getPurchaseOrderDropDown() throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<PurchaseSelect> purchaseSelects = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DROPDOWN, new BeanPropertyRowMapper<>(PurchaseSelect.class));
		return purchaseSelects;
	}

	@Override
	public List<PurchaseSelect> getPurchaseInvoiceDropDown() throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<PurchaseSelect> purchaseSelects = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_PURCHASE_INVOICE_DROPDOWN, new BeanPropertyRowMapper<>(PurchaseSelect.class));
		return purchaseSelects;
	}

	@Override
	public List<PurchaseSelect> getMaterialIssueDropDown() throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<PurchaseSelect> purchaseSelects = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_MATERIL_ISSUE_DROPDOWN, new BeanPropertyRowMapper<>(PurchaseSelect.class));
		return purchaseSelects;
	}

	@Override
	public List<PurchaseSelect> getLocationNames() throws Exception {
		String qcRejectedLocation = "Qc Rejected";
		String virtualLocation = "Virtual Location";

		
		String transLoc = "%" + qcRejectedLocation + "%";
		int qcIdId = getTransitLocation(transLoc, jdbcTemplate);

		String virtualLoc = "%" + virtualLocation + "%";
		int virtualLocationId = getTransitLocation(virtualLoc, jdbcTemplate);

		List<PurchaseSelect> purchaseSelects = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_LOCATION_NAMES, new BeanPropertyRowMapper<>(PurchaseSelect.class), qcIdId, virtualLocationId);
		return purchaseSelects;
	}

	public int getTransitLocation(String location, JdbcTemplate jdbcTemplate2) {
		int locationId = 0;
		try {
			locationId = jdbcTemplate2.queryForObject(GRNQueryUtil.GET_TRANSIT_LOCATION, new Object[] { location }, Integer.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return locationId;
	}

	@Override
	@Transactional
	public BasicResultBean savePurchaseOrder(PurchaseOrder purchaseOrder, String userId) throws Exception {
		String purchaseOrderNumber = "";
		String potype = purchaseOrder.getPotype();
		BasicResultBean BasicResultBean = new BasicResultBean();
		boolean isSucess = false;
		String POnumber = "";
		String PONumberfinal = "";
		try {
			int value = 0;

			String currency = purchaseOrder.getCountry();
			if (currency == "" || currency == null) {
				purchaseOrder.setCurrency("RS");
			}

			boolean flag = false;

			/* Duplicate validation for PONumber */

			String po = purchaseOrder.getPurchaseOrderNum();
			while (flag == false) {
				int exist1 = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_NO_EXIST1, Integer.class, purchaseOrder.getPurchaseOrderNum());
				if (exist1 != 0) {
					int exist2 = 0;
					exist2 = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_NO_EXIST1, Integer.class, po);

					if (potype.equals("Capex PO")) {
						String CompanyShortName = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME, String.class, purchaseOrder.getCompanyId());
						PONumberfinal = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1, String.class, CompanyShortName.concat("-C%"));
						PONumberfinal = CompanyShortName.concat("-" + PONumberfinal);
						BasicResultBean.setType(PONumberfinal);
						BasicResultBean.setMessage("PO Number changed...New PONO :" + " " + PONumberfinal);

					} else if (potype.equals("Revex PO")) {
						String CompanyShortName = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME, String.class, purchaseOrder.getCompanyId());
						PONumberfinal = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_NUMBER_REVEX1, String.class, CompanyShortName.concat("-R%"));
						PONumberfinal = CompanyShortName.concat("-" + PONumberfinal);
						BasicResultBean.setType(PONumberfinal);
						BasicResultBean.setMessage("PO Number changed...New PONO :" + " " + PONumberfinal);
					} else if (potype.equals("Capex WO")) {
						String CompanyShortName = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME, String.class, purchaseOrder.getCompanyId());

						PONumberfinal = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_WORK_ORDER_NUMBER_CAPX, String.class, CompanyShortName.concat("-CWO%"));
						PONumberfinal = CompanyShortName.concat("-" + PONumberfinal);

					} else if (potype.equals("Revex WO")) {
						String CompanyShortName = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME, String.class, purchaseOrder.getCompanyId());
						PONumberfinal = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_WORK_ORDER_NUMBER_RAPX, String.class, CompanyShortName.concat("-RWO%"));
						PONumberfinal = CompanyShortName.concat("-" + PONumberfinal);

					}

					else {
						BasicResultBean.setType(PONumberfinal);
						PONumberfinal = purchaseOrder.getPurchaseOrderNum();
					}

					if (exist2 == 0) {
						flag = true;
					} else {
						po = PONumberfinal;
					}
				} else {
					BasicResultBean.setType(PONumberfinal);
					PONumberfinal = purchaseOrder.getPurchaseOrderNum();
					flag = true;
				}
			}
			BasicResultBean.setType(PONumberfinal);
			purchaseOrder.setPurchaseOrderNum(PONumberfinal);
			if (flag == true) {

				Object[] params = new Object[] { purchaseOrder.getPurchaseOrderNum(), purchaseOrder.getPurchaseOrderDate(), purchaseOrder.getPurchaseFor(), purchaseOrder.getPurchaseType(), purchaseOrder.getCompanyId(), purchaseOrder.getVendorId(), purchaseOrder.getLocationId(), purchaseOrder.getTermsCondition(), purchaseOrder.getRemarks(), purchaseOrder.getStatusId(), userId, purchaseOrder.getSubTotal(), purchaseOrder.getTotalDiscount(), purchaseOrder.getTotalTax(), purchaseOrder.getTotalAmount(), purchaseOrder.getFreightAmount(),
						purchaseOrder.getFreightTax(), purchaseOrder.getFreight(), purchaseOrder.getPaymentTerms(), purchaseOrder.getCostcenter(), purchaseOrder.getAdvanceamt(), purchaseOrder.getPotype(), purchaseOrder.getTotalTaxCGST(), purchaseOrder.getTotalTaxSGST(), purchaseOrder.getTotalTaxIGST(), purchaseOrder.getOtherCharges(), purchaseOrder.getCurrency(), purchaseOrder.getRemarksforother(), purchaseOrder.getBudgetType(), purchaseOrder.getReqType() };
				value = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.INSERT_PURCHASE_ORDER, params, Integer.class);
			}
			if (value != 0) {
				isSucess = true;
				BasicResultBean.setSuccess(isSucess);
			}

			if (purchaseOrder.getPurchaseOrderDetails() != null) {

				for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrder.getPurchaseOrderDetails()) {
					isSucess = savePurchaseOrderDetail(purchaseOrderDetail, value);
					BasicResultBean.setSuccess(isSucess);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return BasicResultBean;
	}

	@Override
	@Transactional
	public boolean updatePurchaseOrder(PurchaseOrder purchaseOrder, String userId) throws Exception {
		boolean isSucess = false;
		try {
			int value = 0;

			Object[] params = new Object[] { purchaseOrder.getPurchaseOrderDate(), purchaseOrder.getPurchaseFor(), purchaseOrder.getPurchaseType(), purchaseOrder.getCompanyId(), purchaseOrder.getVendorId(), purchaseOrder.getLocationId(), purchaseOrder.getTermsCondition(), purchaseOrder.getRemarks(), purchaseOrder.getSubTotal(), userId, purchaseOrder.getTotalDiscount(), purchaseOrder.getTotalTax(), purchaseOrder.getTotalAmount(), purchaseOrder.getStatusId(), purchaseOrder.getFreightAmount(), purchaseOrder.getFreightTax(), purchaseOrder.getFreight(),
					purchaseOrder.getPaymentTerms(), purchaseOrder.getCostcenter(), purchaseOrder.getAdvanceamt(), purchaseOrder.getPotype(), purchaseOrder.getTotalTaxCGST(), purchaseOrder.getTotalTaxSGST(), purchaseOrder.getTotalTaxIGST(), purchaseOrder.getOtherCharges(), purchaseOrder.getCurrency(), purchaseOrder.getRemarksforother(), purchaseOrder.getBudgetType(), purchaseOrder.getReqType(), purchaseOrder.getPurchaseOrderId() };
			value = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER, params);
			if (value != 0) {
				isSucess = true;
			}

			if (purchaseOrder.getPurchaseOrderDetails() != null) {
				for (RateContractDetail purDetail : purchaseOrder.getIsDeletedIds()) {
					isSucess = deletePurchaseOrderDetail(purDetail.getPurchaseOrderDetailId());
				}

				for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrder.getPurchaseOrderDetails()) {
					if (purchaseOrderDetail.getEdit() == 1) {
						isSucess = savePurchaseOrderDetail(purchaseOrderDetail, purchaseOrder.getPurchaseOrderId());
					} else if (purchaseOrderDetail.getEdit() == 0) {
						isSucess = updatePurchaseOrderDetail(purchaseOrderDetail, purchaseOrder.getPurchaseOrderId());
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSucess;
	}

	@Override
	@Transactional
	public boolean deletePurchaseOrder(int purchaseOrderId) throws Exception {
		boolean isSucess = false;
		int value = 0;
		try {

			// get purchase quote id

			int QuoteDetailId = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PQ_DTL_ID, Integer.class, purchaseOrderId);
			int QuoteId = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PQ_ID, Integer.class, QuoteDetailId);
			String AmendedNo = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_AMENDMENT_NUMBER, String.class, purchaseOrderId);

			value = jdbcTemplate.update(PurchaseOrderQuertyUtil.DELETE_PURCHASE_DELIVERY_SCHEDULE, new Object[] { purchaseOrderId });
			value = jdbcTemplate.update(PurchaseOrderQuertyUtil.DELETE_PURCHASE_ORDER_DETAIL, new Object[] { purchaseOrderId });
			value = jdbcTemplate.update(PurchaseOrderQuertyUtil.DELETE_PURCHASE_ORDER, new Object[] { purchaseOrderId });

			if (AmendedNo.equals("notValid")) {

				value = jdbcTemplate.update(PurchaseQuotationQueryUtil.DELETE_PURCHASE_QUOTATION_DETAIL_BY_QUOTID, QuoteId);
				value = jdbcTemplate.update(PurchaseQuotationQueryUtil.DELETE_PURCHASE_QUOTATION_BY_QUOTID, QuoteId);
			} else {
				int value1 = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_FLAG_AMENDMENT_NUMBER, AmendedNo);

			}
			// }
			// }
			isSucess = true;

		} catch (Exception e) {
			isSucess = false;
		}
		return isSucess;
	}

	@Override
	public boolean deletePurchaseOrderDetail(int purchaseOrderDetailId) throws Exception {
		boolean isSucess = false;
		int value = 0;
		try {
			value = jdbcTemplate.update(PurchaseOrderQuertyUtil.DELETE_RATE_CONTRACT_DELIVERY_SCHEDULE, new Object[] { purchaseOrderDetailId });
			value = jdbcTemplate.update(PurchaseOrderQuertyUtil.DELETE_SELECTED_PURCHASE_ORDER_DETAIL, new Object[] { purchaseOrderDetailId });
			if (value != 0) {
				isSucess = true;
			}
		} catch (Exception e) {
			isSucess = false;
		}
		return isSucess;
	}

	public boolean savePurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail, int purchaseOrderId) {
		boolean isSucess = false;

		int discountType = 0;
		if (purchaseOrderDetail.getDiscountType() != null && purchaseOrderDetail.getDiscountType() != "")
			if (purchaseOrderDetail.getDiscountType().equals("Percentage") || purchaseOrderDetail.getDiscountType().endsWith("58")) {

				discountType = 58;

			} else if (purchaseOrderDetail.getDiscountType().equals("Amount") || purchaseOrderDetail.getDiscountType().endsWith("59")) {
				purchaseOrderDetail.setDiscountPercent(0);

				discountType = 59;
			} else {
				discountType = 14;
			}
		if (purchaseOrderDetail.getVendorUOM().equalsIgnoreCase(null) || purchaseOrderDetail.getVendorUOM().equalsIgnoreCase("")) {
			purchaseOrderDetail.setVendorUOM("0");
		}
		if (purchaseOrderDetail.getPurchaseUOM().equalsIgnoreCase(null) || purchaseOrderDetail.getPurchaseUOM().equalsIgnoreCase("")) {
			purchaseOrderDetail.setPurchaseUOM("0");
		}
		Object[] purchaseDtlParams = new Object[] { purchaseOrderDetail.getPurchaseItemId(), purchaseOrderDetail.getPurchaseQuoteDetailId(), purchaseOrderDetail.getQuantity(), purchaseOrderDetail.getPurchaseStatusId(), purchaseOrderDetail.getUnitPrice(), purchaseOrderId, purchaseOrderDetail.getDiscountAmount(), purchaseOrderDetail.getPrRequestNo(), purchaseOrderDetail.getTaxCGST(), purchaseOrderDetail.getTaxSGST(), purchaseOrderDetail.getTaxIGST(), purchaseOrderDetail.getPurchaseItemDesc(), purchaseOrderDetail.getDiscountPercent(),
				purchaseOrderDetail.getDiscountAmount(), purchaseOrderDetail.getTaxCGSTinPercent(), purchaseOrderDetail.getTaxSGSTinPercent(), purchaseOrderDetail.getTaxIGSTinPercent(), discountType, purchaseOrderDetail.getCostcenter(), Integer.parseInt(purchaseOrderDetail.getPurchaseUOM()), purchaseOrderDetail.getPurchaseQty(), Integer.parseInt(purchaseOrderDetail.getVendorUOM()) };
		int value = jdbcTemplate.update(PurchaseOrderQuertyUtil.INSERT_PURCHASE_ORDER_DETAIL, purchaseDtlParams);

		if (value != 0) {

			List<String> POItemList = jdbcTemplate.query(PurchaseOrderQuertyUtil.CHECK_PO_ITEM_ALREADY_EXIST, new Object[] { purchaseOrderDetail.getPrRequestNo() }, new BeanPropertyRowMapper<>(String.class));
			List<String> PRItemList = jdbcTemplate.query(PurchaseOrderQuertyUtil.CHECK_PR_ITEM_ALREADY_EXIST, new Object[] { purchaseOrderDetail.getPrRequestNo() }, new BeanPropertyRowMapper<>(String.class));

			isSucess = true;
		}
		return isSucess;
	}

	public boolean savePurchaseOrderDetailSplitted(PurchaseOrderDetail purchaseOrderDetail, int purchaseOrderId) {
		boolean isSucess = false;
		Object[] purchaseDtlParams = new Object[] { purchaseOrderDetail.getPurchaseItemId(), purchaseOrderDetail.getPurchaseQuoteDetailId(), purchaseOrderDetail.getQuantity(), purchaseOrderDetail.getPurchaseStatusId(), purchaseOrderDetail.getUnitPrice(), purchaseOrderId, purchaseOrderDetail.getDiscount(), purchaseOrderDetail.getTax() };
		int value = jdbcTemplate.update(PurchaseOrderQuertyUtil.INSERT_PURCHASE_ORDER_DETAIL, purchaseDtlParams);
		if (value != 0) {
			isSucess = true;
		}
		return isSucess;
	}

	public boolean updatePurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail, int purchaseOrderId) {
		boolean isSucess = false;
		int discountType = 0;
		if (purchaseOrderDetail.getDiscountType() != null && purchaseOrderDetail.getDiscountType() != "")
			if (purchaseOrderDetail.getDiscountType().equals("Percentage") || purchaseOrderDetail.getDiscountType().endsWith("58")) {

				discountType = 58;

			} else if (purchaseOrderDetail.getDiscountType().equals("Amount") || purchaseOrderDetail.getDiscountType().endsWith("59")) {
				purchaseOrderDetail.setDiscountPercent(0);

				discountType = 59;
			} else {
				discountType = 14;
			}
		Object[] purchaseDtlParams = new Object[] { purchaseOrderDetail.getPurchaseItemId(), purchaseOrderDetail.getPurchaseQuoteDetailId(), purchaseOrderDetail.getQuantity(), purchaseOrderDetail.getPurchaseStatusId(), purchaseOrderDetail.getUnitPrice(), purchaseOrderId, purchaseOrderDetail.getDiscountAmount(), purchaseOrderDetail.getTax(), purchaseOrderDetail.getTaxCGST(), purchaseOrderDetail.getTaxSGST(), purchaseOrderDetail.getTaxIGST(), purchaseOrderDetail.getDiscountPercent(), purchaseOrderDetail.getDiscountAmount(),
				purchaseOrderDetail.getTaxCGSTinPercent(), purchaseOrderDetail.getTaxSGSTinPercent(), purchaseOrderDetail.getTaxIGSTinPercent(), purchaseOrderDetail.getCostcenter(), discountType, Integer.parseInt(purchaseOrderDetail.getPurchaseUOM()), purchaseOrderDetail.getPurchaseQty(), Integer.parseInt(purchaseOrderDetail.getVendorUOM()), purchaseOrderDetail.getPurchaseOrderDetailId() };
		int value = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER_DETAIL, purchaseDtlParams);

		if (value != 0) {
			isSucess = true;
		}
		return isSucess;
	}

	@Override
	public PurchaseOrder getPurchaseOrder(int purchaseOrderId) throws Exception {
		DecimalFormat df2 = new DecimalFormat("0.00");
		PurchaseOrder purchaseOrderObj = new PurchaseOrder();
		purchaseOrderObj = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.EDIT_PURCHASE_ORDER, new Object[] { purchaseOrderId }, new BeanPropertyRowMapper<>(PurchaseOrder.class));

		List<PurchaseQuoteDetail> purchaseQuoteDetails = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL, new Object[] { purchaseOrderId }, new BeanPropertyRowMapper<>(PurchaseQuoteDetail.class));

		for (int i = 0; i < purchaseQuoteDetails.size(); i++) {
			int itemId = purchaseQuoteDetails.get(i).getItemId();
			int[] type = new int[] { Types.INTEGER };
			Object[] param = new Object[] { itemId };
			List<Map<String, Object>> ros = jdbcTemplate.queryForList(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL_PRICE, param, type);
			for (Map row : ros) {
				purchaseQuoteDetails.get(i).setOldUnitPrice((Double) row.get("oldUnitPrice"));
			}
			double mrQty = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MR_PENDING_QTY, Double.class, purchaseQuoteDetails.get(i).getRequisitionId(), purchaseQuoteDetails.get(i).getItemId());
			purchaseQuoteDetails.get(i).setRequestedQty(mrQty);

			double GRNQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_GRN_QTY, Integer.class, purchaseQuoteDetails.get(i).getItemId());
			double MISSUEQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_MI_QTY, Integer.class, purchaseQuoteDetails.get(i).getItemId());

			// 13/02/21 gatepass item included
			int GatePassOut = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSOUT_QTY, Integer.class, itemId);
			int GatePassIn = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSIN_QTY, Integer.class, itemId);
			// end

			// double availableQTY = 0;
			// if (GRNQTY > MISSUEQTY) {
			// availableQTY = GRNQTY - MISSUEQTY;
			// purchaseQuoteDetails.get(i).setAvailableQty(availableQTY);
			// } else if (GRNQTY < MISSUEQTY || GRNQTY == MISSUEQTY) {
			// availableQTY = 0;
			// purchaseQuoteDetails.get(i).setAvailableQty(availableQTY);
			//
			// }
			double itemOpeningQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_OPENING_QTY, Double.class, purchaseQuoteDetails.get(i).getItemId());

			double availableQTY = 0;

			// availableQTY = (GRNQTY + itemOpeningQTY) - MISSUEQTY;
			availableQTY = (GRNQTY + itemOpeningQTY) - (MISSUEQTY + (GatePassOut - GatePassIn));

			if (availableQTY < 0)
				availableQTY = 0;
			purchaseQuoteDetails.get(i).setAvailableQty(availableQTY);

		}

		purchaseOrderObj.setPurchaseQuoteDetails(purchaseQuoteDetails);
		// temp

		for (int i = 0; i < purchaseOrderObj.getPurchaseQuoteDetails().size(); i++) {
			PurchaseOrderQuoteTaxDetail quoteTaxDetail = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_TAX_AMOUNT_DETAILS_PO, new Object[] { purchaseOrderObj.getPurchaseQuoteDetails().get(i).getPurchaseOrderDetailId() }, new BeanPropertyRowMapper<>(PurchaseOrderQuoteTaxDetail.class));

			PurchaseOrderQuoteTaxDetail objIdsBean = new PurchaseOrderQuoteTaxDetail();

			purchaseOrderObj.getPurchaseQuoteDetails().get(i).setQuoteTaxDetail(quoteTaxDetail);

		}
		// group by GST tax

		List<PurchaseOrder> groupList = jdbcTemplate.query(PurchaseOrderQuertyUtil.GROUP_BY_GST_TAX, new Object[] { purchaseOrderId, purchaseOrderId, purchaseOrderId }, new BeanPropertyRowMapper<>(PurchaseOrder.class));

		purchaseOrderObj.setGstgropuList(groupList);
		return purchaseOrderObj;
	}

	@Override
	public List<PurchaseQuoteDetail> getApprovedPurchaseQuote(String purchaseDateFrom, String purchaseDateTo, int status, String entityId, int quoteStatus, int purchaseType) throws Exception {
		List<PurchaseQuoteDetail> detail = new ArrayList<>();
		detail = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_APPROVED_PURCHASE_REQUEST, new Object[] { status, purchaseDateFrom, purchaseDateTo, entityId, quoteStatus }, new BeanPropertyRowMapper<>(PurchaseQuoteDetail.class));

		if (detail.size() > 0) {
			for (int i = 0; i < detail.size(); i++) {

				// Added for getting old unit price
				int itemId = detail.get(i).getItemId();
				int[] type = new int[] { Types.INTEGER, Types.INTEGER };
				Object[] param = new Object[] { itemId, itemId };
				List<Map<String, Object>> ros = jdbcTemplate.queryForList(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL_PRICE, param, type);
				for (Map row : ros) {
					detail.get(i).setOldUnitPrice((Double) row.get("oldUnitPrice"));
				}

				if (detail.get(i).getOldUnitPrice() == null) {
					List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL_PRICE_NULL, param, type);
					for (Map row : rows) {
						detail.get(i).setOldUnitPrice((Double) row.get("oldUnitPrice"));
					}
				}

				PurchaseOrderQuoteTaxDetail quoteTaxDetail = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_TAX_AMOUNT_DETAILS1, new Object[] { detail.get(i).getPurchaseQuoteDetailId() }, new BeanPropertyRowMapper<>(PurchaseOrderQuoteTaxDetail.class));
				String ids = quoteTaxDetail.getLtaxIds();
				PurchaseOrderQuoteTaxDetail objIdsBean = new PurchaseOrderQuoteTaxDetail();

				detail.get(i).setQuoteTaxDetail(quoteTaxDetail);

			}
		}
		return detail;
	}

	@Override
	public List<PurchaseQuoteDetail> getApprovedConsignmentStockDetail(int stockTransferId) throws Exception {
		List<PurchaseQuoteDetail> detail = new ArrayList<>();
		detail = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_APPROVED_CONSIGNMENT_REQUEST, new Object[] { stockTransferId }, new BeanPropertyRowMapper<>(PurchaseQuoteDetail.class));
		if (detail.size() > 0) {
			for (int i = 0; i < detail.size(); i++) {

				// Added for getting old unit price
				int itemId = detail.get(i).getItemId();
				int[] type = new int[] { Types.INTEGER, Types.INTEGER };
				Object[] param = new Object[] { itemId, itemId };
				List<Map<String, Object>> ros = jdbcTemplate.queryForList(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL_PRICE, param, type);
				for (Map row : ros) {
					detail.get(i).setOldUnitPrice((Double) row.get("oldUnitPrice"));
				}

				if (detail.get(i).getOldUnitPrice() == null) {
					List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL_PRICE_NULL, param, type);
					for (Map row : rows) {
						detail.get(i).setOldUnitPrice((Double) row.get("oldUnitPrice"));
					}
				}

				PurchaseOrderQuoteTaxDetail quoteTaxDetail = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_TAX_AMOUNT_DETAILS, new Object[] { detail.get(i).getPurchaseQuoteDetailId() }, new BeanPropertyRowMapper<>(PurchaseOrderQuoteTaxDetail.class));

				String ids = quoteTaxDetail.getLtaxIds();

				PurchaseOrderQuoteTaxDetail objIdsBean = new PurchaseOrderQuoteTaxDetail();

				if (ids.contains(",")) {
					String taxIds[] = ids.split(",");
					String taxCodedtl = "";
					int i1 = 1;
					for (String txId : taxIds) {
						int tId = Integer.parseInt(txId);
						objIdsBean = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.getTaxCodeName, new Object[] { tId }, new BeanPropertyRowMapper<>(PurchaseOrderQuoteTaxDetail.class));
						if (taxCodedtl != "" && taxCodedtl != null) {
							taxCodedtl = taxCodedtl + "," + objIdsBean.getTaxCode();
							quoteTaxDetail.getTaxIdslist().add(txId);
						} else {
							taxCodedtl = taxCodedtl + objIdsBean.getTaxCode();
							quoteTaxDetail.getTaxIdslist().add(txId);
						}

						if (i1 == taxIds.length) {
							quoteTaxDetail.setTaxCode(taxCodedtl);
						}
						i1++;
					}
				} else {
					int tId = Integer.parseInt(ids);
					objIdsBean = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.getTaxCodeName, new Object[] { tId }, new BeanPropertyRowMapper<>(PurchaseOrderQuoteTaxDetail.class));
					quoteTaxDetail.setTaxCode(objIdsBean.getTaxCode());
					quoteTaxDetail.getTaxIdslist().add(ids);
				}
				detail.get(i).setQuoteTaxDetail(quoteTaxDetail);

			}
		}
		return detail;
	}

	@Override
	public boolean updatePurchaseOrderStatus(int statusId, int costCenter, int purchaseOrderId, int budget) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean isSucess = false;
		try {
			int value = 0;
			Object[] params = new Object[] { statusId, userDetails.getUserId(), userDetails.getUsername(), purchaseOrderId };
			value = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER_STATUS, params);

			if (value != 0) {
				// autoJvEntryGeneration(purchaseOrderId, costCenter, budget);
				isSucess = true;
			}
			/*
			 * if (isSucess) { isSucess =
			 * saveCBPmtGeneralLedgerCreditEntry(purchaseOrderId); isSucess =
			 * saveCBPmtGeneralLedgerDebitEntry(purchaseOrderId); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSucess;

	}

	public void autoJvEntryGeneration(int iPurchaseOrderid, int costCenter, int budget) {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		// get purchase order amount details
		try {
			purchaseOrder = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PURCHASE_DETAIL_FOR_AUTO_JV, new Object[] { iPurchaseOrderid }, new BeanPropertyRowMapper<>(PurchaseOrder.class));

			// Auto generated JV for purchase order
			String journalNumber = generateJournalVoucherNumber();

			// String vendorCode =
			// jdbcTemplate.queryForObject(GRNQueryUtil.GET_VENDOR_ACCT_CODE,
			// new Object[] {
			// purchaseOrder.getVendorId() }, String.class);
			// String vendorCode = purchaseOrder.getVendorId();
			// String costCenter1 =
			// jdbcTemplate.queryForObject(Purcha seOrderQuertyUtil.costCenter,
			// new Object[]
			// { costCenter }, String.class);
			// String acctName =
			// jdbcTemplate.queryForObject(GRNQueryUtil.GET_VENDOR_ACCT_CODE1,
			// new Object[]
			// { purchaseOrder.getVendorId() }, String.class);
			int budgetId = jdbcTemplate.queryForObject(GRNQueryUtil.budgetId, new Object[] { budget }, Integer.class);

			String budgetCode = jdbcTemplate.queryForObject(GRNQueryUtil.budgetName, new Object[] { budgetId }, String.class);
			int jvHdr = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_JOURNAL_VOUCHER_HEADER, new Object[] { costCenter, journalNumber, purchaseOrder.getPurchaseOrderDate(), "AUTO JV FOR PURCHASE ORDER - " + purchaseOrder.getPurchaseOrderNum(), userDetails.getUserId(), purchaseOrder.getCompanyId() });

			// debit entry
			int jvDebit = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_JOURNAL_VOUCHER_DTL, new Object[] { journalNumber, "2009", "INR", 1.0, purchaseOrder.getTotalAmount(), 0.0, "AUTO JV FOR PURCHASE ORDER - " + purchaseOrder.getPurchaseOrderNum(), purchaseOrder.getVendorId(), purchaseOrder.getTotalAmount(), 0.0, 1, purchaseOrder.getVendorId(), null, null, null, null, null, purchaseOrder.getCompanyId(), null, null, null });

			// credit entry
			int jvCredit = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_JOURNAL_VOUCHER_DTL, new Object[] { journalNumber, budgetCode, "INR", 1.0, 0.0, purchaseOrder.getTotalAmount(), "AUTO JV FOR PURCHASE ORDER - " + purchaseOrder.getPurchaseOrderNum(), budgetCode, 0.0, purchaseOrder.getTotalAmount(), 1, purchaseOrder.getVendorId(), null, null, null, null, null, purchaseOrder.getCompanyId(), null, null, null });
			String str = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.acct, new Object[] { journalNumber }, String.class);

			if (str.startsWith("S0")) {
				if (jvHdr > 0 && jvDebit > 0 && jvCredit > 0)
					jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_GENERAL_LEDGER_FOR_JV1_PO, new Object[] { budget, purchaseOrder.getPurchaseOrderNum(), journalNumber });
			} else {
				jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_GENERAL_LEDGER_FOR_JV_PO, new Object[] { budget, purchaseOrder.getPurchaseOrderNum(), journalNumber });

			}
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}

	public String generateJournalVoucherNumber() throws CustomException {
		String journalNumber = null;
		String appendWithYear = "", appendWithJVNo = "";

		try {
			String sCurrentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			sCurrentYear = sCurrentYear.substring(2);

			appendWithJVNo = "JV" + sCurrentYear + "00001";
			appendWithYear = "JV" + sCurrentYear + "%";

			List<Map<String, Object>> rowJVNo = jdbcTemplate.queryForList(JournalVoucherQueryUtil.GET_JOURNAL_NO_AUTOGENERATE, new Object[] { appendWithJVNo, appendWithYear });
			for (Map row : rowJVNo) {
				journalNumber = (String) row.get("JOURNAL_NO");
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return journalNumber;
	}

	@Override
	@Transactional
	public boolean saveRateContract(PurchaseOrder purchaseOrder, String userId) throws Exception {
		String purchaseOrderNumber = "";
		String potype = purchaseOrder.getPotype();
		boolean isSucess = false;
		String POnumber = "";
		String PONumberfinal = "";
		try {
			int value = 0;
			if (potype.equals("Capex PO")) {

				purchaseOrderNumber = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_NUMBER_CAPX, String.class);

			} else if (potype.equals("Revex PO")) {
				purchaseOrderNumber = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_NUMBER_REVEX, String.class);

			}
			purchaseOrder.setPurchaseOrderNum(purchaseOrderNumber);
			Object[] params = new Object[] { purchaseOrder.getPurchaseOrderNum(), purchaseOrder.getPurchaseOrderDate(), purchaseOrder.getPurchaseFor(), purchaseOrder.getPurchaseType(), purchaseOrder.getCompanyId(), purchaseOrder.getVendorId(), purchaseOrder.getLocationId(), purchaseOrder.getTermsCondition(), purchaseOrder.getRemarks(), purchaseOrder.getStatusId(), userId, purchaseOrder.getSubTotal(), purchaseOrder.getTotalDiscount(), purchaseOrder.getTotalTax(), purchaseOrder.getTotalAmount(), purchaseOrder.getFreight(),
					purchaseOrder.getPaymentTerms(), purchaseOrder.getPotype() };
			value = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.INSERT_PURCHASE_ORDER, params, Integer.class);

			if (value != 0) {
				isSucess = true;
			}

			if (purchaseOrder.getPurchaseOrderDetails() != null) {
				for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrder.getPurchaseOrderDetails()) {
					isSucess = saveRateContractDetail(purchaseOrderDetail, value, userId);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSucess;

	}

	@Override
	public boolean saveRateContractDetail(PurchaseOrderDetail purchaseOrderDetail, int purchaseOrderId, String userId) throws Exception {
		boolean isSucess = false;
		int id = 0;
		try {
			Object[] purchaseDtlParams = new Object[] { purchaseOrderDetail.getPurchaseItemId(), purchaseOrderDetail.getPurchaseQuoteDetailId(), purchaseOrderDetail.getQuantity(), purchaseOrderDetail.getPurchaseStatusId(), purchaseOrderDetail.getUnitPrice(), purchaseOrderId, purchaseOrderDetail.getDiscount(), purchaseOrderDetail.getTax() };

			id = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.INSERT_RATE_CONTRACT_DETAIL, purchaseDtlParams, Integer.class);

			if (purchaseOrderDetail.getRateContractDetails() != null) {
				for (RateContractDetail rateContractDetail : purchaseOrderDetail.getRateContractDetails()) {
					Object[] purcahseContractDeliveryParams = new Object[] { rateContractDetail.getItemId(), rateContractDetail.getQuantity(), rateContractDetail.getPurchaseOrderDeliveryDate(), id, rateContractDetail.getQuantity(), userId };
					jdbcTemplate.update(PurchaseOrderQuertyUtil.INSERT_RATE_CONTRACT_DELIVERY_SCHEDULE, purcahseContractDeliveryParams);

				}
			}
			isSucess = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSucess = false;
		}

		return isSucess;
	}

	@Override
	public PurchaseOrder getDeliveryPurchaseOrder(int purchaseOrderId) throws Exception {
		PurchaseOrder purchaseOrderObj = new PurchaseOrder();
		purchaseOrderObj = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.EDIT_PURCHASE_ORDER, new Object[] { purchaseOrderId }, new BeanPropertyRowMapper<>(PurchaseOrder.class));

		List<PurchaseQuoteDetail> purchaseQuoteDetails = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL, new Object[] { purchaseOrderId }, new BeanPropertyRowMapper<>(PurchaseQuoteDetail.class));

		for (int i = 0; i < purchaseQuoteDetails.size(); i++) {
			int itemId = purchaseQuoteDetails.get(i).getItemId();
			int[] type = new int[] { Types.INTEGER, Types.INTEGER };
			Object[] param = new Object[] { itemId, itemId };
			List<Map<String, Object>> ros = jdbcTemplate.queryForList(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL_PRICE, param, type);
			for (Map row : ros) {
				purchaseQuoteDetails.get(i).setOldUnitPrice((Double) row.get("oldUnitPrice"));
			}

		}

		purchaseOrderObj.setPurchaseQuoteDetails(purchaseQuoteDetails);

		for (int i = 0; i < purchaseOrderObj.getPurchaseQuoteDetails().size(); i++) {
			PurchaseOrderQuoteTaxDetail quoteTaxDetail = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_TAX_AMOUNT_DETAILS, new Object[] { purchaseOrderObj.getPurchaseQuoteDetails().get(i).getPurchaseQuoteDetailId() }, new BeanPropertyRowMapper<>(PurchaseOrderQuoteTaxDetail.class));

			String ids = quoteTaxDetail.getLtaxIds();
			PurchaseOrderQuoteTaxDetail objIdsBean = new PurchaseOrderQuoteTaxDetail();

			if (ids.contains(",")) {
				String taxIds[] = ids.split(",");
				String taxCodedtl = "";
				int i1 = 1;
				for (String txId : taxIds) {
					int tId = Integer.parseInt(txId);
					objIdsBean = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.getTaxCodeName, new Object[] { tId }, new BeanPropertyRowMapper<>(PurchaseOrderQuoteTaxDetail.class));
					if (taxCodedtl != "" && taxCodedtl != null) {
						taxCodedtl = taxCodedtl + "," + objIdsBean.getTaxCode();
						quoteTaxDetail.getTaxIdslist().add(txId);
					} else {
						taxCodedtl = taxCodedtl + objIdsBean.getTaxCode();
						quoteTaxDetail.getTaxIdslist().add(txId);
					}

					if (i1 == taxIds.length) {
						quoteTaxDetail.setTaxCode(taxCodedtl);
					}
					i1++;
				}
			} else {
				int tId = Integer.parseInt(ids);
				objIdsBean = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.getTaxCodeName, new Object[] { tId }, new BeanPropertyRowMapper<>(PurchaseOrderQuoteTaxDetail.class));
				quoteTaxDetail.setTaxCode(objIdsBean.getTaxCode());
				quoteTaxDetail.getTaxIdslist().add(ids);

			}

			purchaseOrderObj.getPurchaseQuoteDetails().get(i).setQuoteTaxDetail(quoteTaxDetail);

		}
		List<RateContractDetail> rateContractDetails = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DELIVERY_STATUS, new Object[] { purchaseOrderObj.getPurchaseOrderId() }, new BeanPropertyRowMapper<>(RateContractDetail.class));
		purchaseOrderObj.setRateContractDetails(rateContractDetails);
		return purchaseOrderObj;
	}

	@Override
	@Transactional
	public boolean updateDeliveryPurchaseOrder(PurchaseOrder purchaseOrder, String userId) throws Exception {
		boolean isSucess = false;
		try {
			int value = 0;
			int k = 0;
			Object[] params = new Object[] { purchaseOrder.getPurchaseOrderDate(), purchaseOrder.getPurchaseFor(), purchaseOrder.getPurchaseType(), purchaseOrder.getCompanyId(), purchaseOrder.getVendorId(), purchaseOrder.getLocationId(), purchaseOrder.getTermsCondition(), purchaseOrder.getRemarks(), purchaseOrder.getSubTotal(), userId, purchaseOrder.getTotalDiscount(), purchaseOrder.getTotalTax(), purchaseOrder.getTotalAmount(), purchaseOrder.getStatusId(), purchaseOrder.getFreight(), purchaseOrder.getPaymentTerms(),
					purchaseOrder.getPurchaseOrderId() };
			value = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER, params);

			if (value != 0) {
				isSucess = true;
			}

			if (purchaseOrder.getPurchaseOrderDetails() != null) {

				if (purchaseOrder.getIsDeletedIds().size() > 0) {
					for (RateContractDetail quoteDetail : purchaseOrder.getIsDeletedIds()) {
						k = jdbcTemplate.update(PurchaseOrderQuertyUtil.DELETE_RATE_CONTRACT_DELIVERY_SCHEDULE_BY_ITEM, new Object[] { quoteDetail.getPurchaseOrderDetailId(), quoteDetail.getPurchaseDeliveryId() });
					}
					if (k != 0) {
						isSucess = true;
					}
				}

				if (purchaseOrder.getIsOrderIds().size() > 0) {
					for (RateContractDetail quoteDetail : purchaseOrder.getIsOrderIds()) {
						deletePurchaseDeliveryOrderDetail(quoteDetail.getPurchaseOrderDetailId());
					}
				}

				for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrder.getPurchaseOrderDetails()) {
					if (purchaseOrderDetail.getEdit() == 1) {
						isSucess = saveRateContractDetail(purchaseOrderDetail, purchaseOrder.getPurchaseOrderId(), userId);
					} else if (purchaseOrderDetail.getEdit() == 0) {
						isSucess = updatePurchaseDeliveryOrderDetail(purchaseOrderDetail, purchaseOrder.getPurchaseOrderId(), userId);
					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSucess;
	}

	public boolean updatePurchaseDeliveryOrderDetail(PurchaseOrderDetail purchaseOrderDetail, int purchaseOrderId, String userId) {
		boolean isSucess = false;
		Object[] purchaseDtlParams = new Object[] { purchaseOrderDetail.getPurchaseItemId(), purchaseOrderDetail.getPurchaseQuoteDetailId(), purchaseOrderDetail.getQuantity(), purchaseOrderDetail.getPurchaseStatusId(), purchaseOrderDetail.getUnitPrice(), purchaseOrderId, purchaseOrderDetail.getDiscount(), purchaseOrderDetail.getTax(), purchaseOrderDetail.getPurchaseOrderDetailId() };
		int value = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER_DETAIL, purchaseDtlParams);
		if (purchaseOrderDetail.getRateContractDetails() != null) {
			for (RateContractDetail rateContractDetail : purchaseOrderDetail.getRateContractDetails()) {
				if (rateContractDetail.getEdit() == 0) {
					Object[] purcahseContractDeliveryParams = new Object[] { rateContractDetail.getItemId(), rateContractDetail.getQuantity(), rateContractDetail.getQuantity(), rateContractDetail.getPurchaseOrderDeliveryDate(), userId, rateContractDetail.getPurchaseDeliveryId() };
					jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_RATE_CONTRACT_DELIVERY_SCHEDULE, purcahseContractDeliveryParams);
				} else if (rateContractDetail.getEdit() == 1) {

					Object[] purcahseContractDeliveryParams = new Object[] { rateContractDetail.getItemId(), rateContractDetail.getQuantity(), rateContractDetail.getPurchaseOrderDeliveryDate(), purchaseOrderDetail.getPurchaseOrderDetailId(), rateContractDetail.getQuantity(), userId };
					jdbcTemplate.update(PurchaseOrderQuertyUtil.INSERT_RATE_CONTRACT_DELIVERY_SCHEDULE, purcahseContractDeliveryParams);
				} else {
					value = jdbcTemplate.update(PurchaseOrderQuertyUtil.DELETE_RATE_CONTRACT_DELIVERY_SCHEDULE, new Object[] { purchaseOrderDetail.getPurchaseOrderDetailId() });
				}
			}
		}
		if (value != 0) {
			isSucess = true;
		}
		return isSucess;
	}

	public boolean deletePurchaseDeliveryOrderDetail(int purchaseOrderDetailId) throws Exception {
		boolean isSucess = false;
		int value = 0;
		try {
			value = jdbcTemplate.update(PurchaseOrderQuertyUtil.DELETE_RATE_CONTRACT_DELIVERY_SCHEDULE, new Object[] { purchaseOrderDetailId });
			value = jdbcTemplate.update(PurchaseOrderQuertyUtil.DELETE_SELECTED_PURCHASE_ORDER_DETAIL, new Object[] { purchaseOrderDetailId });
			if (value != 0) {
				isSucess = true;
			}
		} catch (Exception e) {
			isSucess = false;
		}
		return isSucess;
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrderAmendmentList() throws Exception {

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<PurchaseOrder> purchaseOrders = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_AMENDMENT_LIST, new Object[] { PurchaseConstants.AMENDMENT_PURCHASE_STATUS_LIST }, new BeanPropertyRowMapper<>(PurchaseOrder.class));
		return purchaseOrders;
	}

	@Override
	public PurchaseOrder getPurchaseOrderAmendment(int purchaseOrderId) throws Exception {
		PurchaseOrder purchaseOrderObj = new PurchaseOrder();
		purchaseOrderObj = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.EDIT_PURCHASE_ORDER, new Object[] { purchaseOrderId }, new BeanPropertyRowMapper<>(PurchaseOrder.class));

		purchaseOrderObj.setPurchaseQuoteDetails(jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_AMENDMENT_DETAIL, new Object[] { purchaseOrderId, purchaseOrderId }, new BeanPropertyRowMapper<>(PurchaseQuoteDetail.class)));
		for (int i = 0; i < purchaseOrderObj.getPurchaseQuoteDetails().size(); i++) {

			PurchaseOrderQuoteTaxDetail quoteTaxDetail = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_TAX_AMOUNT_DETAILS_PO, new Object[] { purchaseOrderObj.getPurchaseQuoteDetails().get(i).getPurchaseOrderDetailId() }, new BeanPropertyRowMapper<>(PurchaseOrderQuoteTaxDetail.class));
			PurchaseOrderQuoteTaxDetail objIdsBean = new PurchaseOrderQuoteTaxDetail();
			String taxCodedtl = "";

			purchaseOrderObj.getPurchaseQuoteDetails().get(i).setQuoteTaxDetail(quoteTaxDetail);
			purchaseOrderObj.getPurchaseQuoteDetails().get(i).getQuoteTaxDetail().setTaxCode(taxCodedtl);
			double mrQty = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MR_PENDING_QTY, Double.class, purchaseOrderObj.getPurchaseQuoteDetails().get(i).getRequisitionId(), purchaseOrderObj.getPurchaseQuoteDetails().get(i).getItemId());
			purchaseOrderObj.getPurchaseQuoteDetails().get(i).setRequestedQty(mrQty);

			List<PurchaseOrder> groupList = jdbcTemplate.query(PurchaseOrderQuertyUtil.GROUP_BY_GST_TAX, new Object[] { purchaseOrderId, purchaseOrderId, purchaseOrderId }, new BeanPropertyRowMapper<>(PurchaseOrder.class));

			purchaseOrderObj.setGstgropuList(groupList);
		}

		return purchaseOrderObj;
	}

	@Override
	@Transactional
	public boolean updateDeliveryPurchaseOrderAmendment(PurchaseOrder purchaseOrder, String userId) throws Exception {

		boolean isSucess = false;
		int poStatus = 46;
		try {
			int value = 0;

			String PONumber = purchaseOrder.getPurchaseOrderNum();
			purchaseOrder.setPoAmendmentNo(PONumber);
			int exist = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_AMENDMENT_EXIST, Integer.class, PONumber);
			if (exist == 0) {

				String[] list = PONumber.split("-");
				String companyCode = list[0];
				String val = list[1];
				int len = list.length;
				if (len > 3) {
					PONumber = list[2].concat("-" + list[3]);
				} else {
					PONumber = list[2];
				}
				int fulllength = PONumber.length();
				if (fulllength > 7) {
					String[] POlist = PONumber.split("-A");
					String num1 = POlist[0];
					String num2 = "";

					num2 = POlist[1];

					int length = num2.length();
					int number = Integer.parseInt(num2) + 1;
					PONumber = num1.concat("-A" + number);
					PONumber = companyCode.concat("-" + val + "-" + PONumber);
				} else {

					PONumber = PONumber.concat("-A1");
					PONumber = companyCode.concat("-" + val + "-" + PONumber);
				}

				purchaseOrder.setPurchaseOrderNum(PONumber);
				String currency = purchaseOrder.getCountry();
				if (currency == "" || currency == null) {
					purchaseOrder.setCurrency("RS");
				}

				Object[] params = new Object[] { purchaseOrder.getPurchaseOrderNum(), purchaseOrder.getPurchaseOrderDate(), purchaseOrder.getPurchaseFor(), purchaseOrder.getPurchaseType(), purchaseOrder.getCompanyId(), purchaseOrder.getVendorId(), purchaseOrder.getLocationId(), purchaseOrder.getTermsCondition(), purchaseOrder.getRemarks(), 46, userId, purchaseOrder.getSubTotal(), purchaseOrder.getTotalDiscount(), purchaseOrder.getTotalTax(), purchaseOrder.getTotalAmount(), purchaseOrder.getFreightAmount(), purchaseOrder.getPaymentTerms(),
						purchaseOrder.getCostcenter(), purchaseOrder.getAdvanceamt(), purchaseOrder.getPotype(), purchaseOrder.getTotalTaxCGST(), purchaseOrder.getTotalTaxSGST(), purchaseOrder.getTotalTaxIGST(), purchaseOrder.getOtherCharges(), purchaseOrder.getCurrency(), purchaseOrder.getRemarksforother(), purchaseOrder.getBudgetType(), purchaseOrder.getPoAmendmentNo(), purchaseOrder.getReason_for_amendment(), purchaseOrder.getFreightTax(), purchaseOrder.getFreight(), purchaseOrder.getReqType() };
				value = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.INSERT_PURCHASE_ORDER_AMENDMENT, params, Integer.class);
				int value1 = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_MPO_FLAG, purchaseOrder.getPoAmendmentNo());

				if (value != 0) {
					isSucess = true;
				}

				if (purchaseOrder.getPurchaseOrderDetails() != null) {
					for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrder.getPurchaseOrderDetails()) {
						isSucess = savePurchaseOrderDetailAmendment(purchaseOrderDetail, value);
					}
				}
			} else {
				isSucess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSucess;
	}

	public boolean savePurchaseOrderAmendment(PurchaseOrderDetail purchaseOrderDetail, int purchaseOrderId, String userId, String purchaseOrderNumber) throws Exception {
		boolean isSucess = false;
		int id = 0;
		purchaseOrderNumber = purchaseOrderNumber + 'A';
		try {
			Object[] purchaseDtlParams = new Object[] { purchaseOrderDetail.getPurchaseItemId(), purchaseOrderDetail.getPurchaseQuoteDetailId(), purchaseOrderDetail.getQuantity(), purchaseOrderDetail.getPurchaseStatusId(), purchaseOrderDetail.getUnitPrice(), purchaseOrderId, purchaseOrderDetail.getDiscount(), purchaseOrderDetail.getTax(), purchaseOrderNumber, purchaseOrderDetail.getTaxCGST(), purchaseOrderDetail.getTaxSGST(), purchaseOrderDetail.getTaxIGST() };
			id = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.INSERT_PURCHASE_ORDER_AMENDMENT_DETAIL, purchaseDtlParams, Integer.class);

			isSucess = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSucess = false;
		}

		return isSucess;
	}

	public boolean updatePurchaseOrderAmendment(PurchaseOrderDetail purchaseOrderDetail, int purchaseOrderId, String userId, String purchaseOrderNumber) {
		boolean isSucess = false;
		purchaseOrderNumber = purchaseOrderNumber + 'A';
		Object[] purchaseDtlParams = new Object[] { purchaseOrderDetail.getPurchaseItemId(), purchaseOrderDetail.getPurchaseQuoteDetailId(), purchaseOrderDetail.getQuantity(), purchaseOrderDetail.getPurchaseStatusId(), purchaseOrderDetail.getUnitPrice(), purchaseOrderId, purchaseOrderDetail.getDiscount(), purchaseOrderDetail.getTax(), purchaseOrderNumber, purchaseOrderDetail.getTaxCGST(), purchaseOrderDetail.getTaxSGST(), purchaseOrderDetail.getTaxIGST(), purchaseOrderDetail.getPurchaseOrderDetailId() };
		int value = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER_AMENDMENT_DETAIL, purchaseDtlParams);
		if (value != 0) {
			isSucess = true;
		}
		return isSucess;
	}

	public boolean deletePurchaseOrderAmendment(int purchaseOrderDetailId) throws Exception {
		boolean isSucess = false;
		int value = 0;
		try {
			value = jdbcTemplate.update(PurchaseOrderQuertyUtil.DELETE_SELECTED_PURCHASE_ORDER_DETAIL, new Object[] { purchaseOrderDetailId });
			if (value != 0) {
				isSucess = true;
			}
		} catch (Exception e) {
			isSucess = false;
		}
		return isSucess;
	}

	@Override
	public List<PurchaseSelect> getConsignmentTransferNumbers() throws Exception {
		List<PurchaseSelect> purchaseSelects = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_STOCK_TRANSFER_NUMBER, new Object[] { PurchaseConstants.STOCK_TRANSFER_TYPE }, new BeanPropertyRowMapper<>(PurchaseSelect.class));
		return purchaseSelects;
	}

	@Override
	public List<PurchaseQuoteDetail> getApprovedPurchaseConsignmentTransferNumbers(String purchaseDateFrom, String purchaseDateTo, int status, int entityId, int quoteStatus, int stockTransferId) throws Exception {
		List<PurchaseQuoteDetail> detail = new ArrayList<>();
		detail = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_APPROVED_PURCHASE_REQUEST_FOR_CONSIGNMENT, new Object[] { status, purchaseDateFrom, purchaseDateTo, entityId, quoteStatus }, new BeanPropertyRowMapper<>(PurchaseQuoteDetail.class));

		List<PurchaseQuoteDetail> stocktransferDetails = Arrays.asList();

		stocktransferDetails = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_STOCK_TRANSFER_ITEM_DETAILS, new Object[] { stockTransferId }, new BeanPropertyRowMapper<>(PurchaseQuoteDetail.class));

		for (PurchaseQuoteDetail purchaseQuoteDetail : detail) {
			for (PurchaseQuoteDetail purchaseDetail : stocktransferDetails) {
				if (purchaseQuoteDetail.getItemId() == purchaseDetail.getItemId()) {
					purchaseQuoteDetail.setQuantity(purchaseDetail.getQuantity());
					purchaseQuoteDetail.setTransfered(true);
				}

			}
		}
		if (detail.size() > 0) {
			for (int i = 0; i < detail.size(); i++) {
				PurchaseOrderQuoteTaxDetail quoteTaxDetail = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_TAX_AMOUNT_DETAILS, new Object[] { detail.get(i).getPurchaseQuoteDetailId() }, new BeanPropertyRowMapper<>(PurchaseOrderQuoteTaxDetail.class));
				detail.get(i).setQuoteTaxDetail(quoteTaxDetail);
			}
		}

		return detail;
	}

	@Override
	@Transactional
	public boolean saveConsignmentOrder(PurchaseOrder purchaseOrder, String userId) throws Exception {
		String purchaseOrderNumber = "";
		String potype = purchaseOrder.getPotype();
		boolean isSucess = false;
		String POnumber = "";
		String PONumberfinal = "";
		try {
			int value = 0;
			if (potype.equals("Capex PO")) {

				purchaseOrderNumber = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_NUMBER_CAPX, String.class);

			} else if (potype.equals("Revex PO")) {
				purchaseOrderNumber = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_NUMBER_REVEX, String.class);

			}

			purchaseOrder.setPurchaseOrderNum(purchaseOrderNumber);
			Object[] params = new Object[] { purchaseOrder.getPurchaseOrderNum(), purchaseOrder.getPurchaseOrderDate(), purchaseOrder.getPurchaseFor(), purchaseOrder.getPurchaseType(), purchaseOrder.getCompanyId(), purchaseOrder.getVendorId(), purchaseOrder.getLocationId(), purchaseOrder.getTermsCondition(), purchaseOrder.getRemarks(), purchaseOrder.getStatusId(), userId, purchaseOrder.getSubTotal(), purchaseOrder.getTotalDiscount(), purchaseOrder.getTotalTax(), purchaseOrder.getTotalAmount(), purchaseOrder.getFreight(),
					purchaseOrder.getConTransNo(), purchaseOrder.getPaymentTerms() };
			value = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.INSERT_CONSIGNMENT_ORDER, params, Integer.class);

			if (value != 0) {
				isSucess = true;
			}

			if (purchaseOrder.getPurchaseOrderDetails() != null) {
				for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrder.getPurchaseOrderDetails()) {
					isSucess = savePurchaseOrderDetail(purchaseOrderDetail, value);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSucess;
	}

	@Override
	@Transactional
	public boolean updateConsignmentOrder(PurchaseOrder purchaseOrder, String userId) throws Exception {
		boolean isSucess = false;
		try {
			int value = 0, detailValue = 0;
			Object[] params = new Object[] { purchaseOrder.getPurchaseOrderDate(), purchaseOrder.getPurchaseFor(), purchaseOrder.getPurchaseType(), purchaseOrder.getCompanyId(), purchaseOrder.getVendorId(), purchaseOrder.getLocationId(), purchaseOrder.getTermsCondition(), purchaseOrder.getRemarks(), purchaseOrder.getSubTotal(), userId, purchaseOrder.getTotalDiscount(), purchaseOrder.getTotalTax(), purchaseOrder.getTotalAmount(), purchaseOrder.getStatusId(), purchaseOrder.getFreight(), purchaseOrder.getConTransNo(), purchaseOrder.getPaymentTerms(),
					purchaseOrder.getPurchaseOrderId() };
			value = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_CONSIGNMENT_ORDER, params);

			if (value != 0) {
				isSucess = true;
			}

			if (purchaseOrder.getPurchaseOrderDetails() != null) {
				for (RateContractDetail purDetail : purchaseOrder.getIsDeletedIds()) {
					isSucess = deletePurchaseOrderDetail(purDetail.getPurchaseOrderDetailId());
				}

				for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrder.getPurchaseOrderDetails()) {
					isSucess = updatePurchaseOrderDetail(purchaseOrderDetail, purchaseOrder.getPurchaseOrderId());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSucess;
	}

	@Override
	public List<PurchaseOrder> getTotalPurchaseOrderCancelList() throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<PurchaseOrder> purchaseOrders = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_TOTAL_PURCHASE_ORDER_FOR_CANCEL, new Object[] { PurchaseConstants.CANCEL_PURCHASE_ORDER_RETAIN_STATUS_LIST, userDetails.getCompanyCode() }, new BeanPropertyRowMapper<>(PurchaseOrder.class));
		return purchaseOrders;
	}

	@Override
	public List<PurchaseOrder> getFilteredPurchaseOrderList(PurchaseFilter purchaseFilter) throws Exception {
		List<PurchaseOrder> purchaseOrders = new ArrayList<>();
		String query = PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_FILTERED_LIST;
		String whereCondition = dynamicWhereCondition(purchaseFilter);
		if (whereCondition != null) {
			query += whereCondition + PurchaseConstants.ORDER_BY_PURCHASE_ORDER;
		} else {
			query += PurchaseConstants.ORDER_BY_PURCHASE_ORDER;
		}
		purchaseOrders = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(PurchaseOrder.class));
		return purchaseOrders;

	}

	private String dynamicWhereCondition(PurchaseFilter purchaseFilter) {
		String query = " ";
		boolean isQueryGenerated = false;
		if (!purchaseFilter.getStartDate().isEmpty() && purchaseFilter.getStartDate() != null) {
			query = " and purchase_date >= to_date('" + purchaseFilter.getStartDate() + "','dd/mm/yyyy')";
			isQueryGenerated = true;
		}
		if (!purchaseFilter.getEndDate().isEmpty() && purchaseFilter.getEndDate() != null) {
			query += " and purchase_date <= to_date('" + purchaseFilter.getEndDate() + "','dd/mm/yyyy')";
			isQueryGenerated = true;
		}
		if (purchaseFilter.getVendorId() != null) {
			query += " and vendor_id = " + purchaseFilter.getVendorId();
			isQueryGenerated = true;
		}
		if (purchaseFilter.getStatusId() != null) {
			query += " and purchase_order.po_status = " + purchaseFilter.getStatusId();
			isQueryGenerated = true;
		}
		if (purchaseFilter.getItemId() != null) {
			query += " and pod.item_id=" + purchaseFilter.getItemId();
			isQueryGenerated = true;
		} else if (!isQueryGenerated) {
			query = null;
		}
		return query;
	}

	@Override
	public List<PurchaseSelect> getItemList() throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<PurchaseSelect> itemList = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_ITEM_LIST, new BeanPropertyRowMapper<>(PurchaseSelect.class), userDetails.getCompanyCode());
		return itemList;
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrderSplitList() throws Exception {
		List<PurchaseOrder> purchaseOrders = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_SPLIT_PURCHASE_ORDER_LIST, new Object[] { PurchaseConstants.SPLIT_PURCHASE_STATUS_LIST, PurchaseConstants.PURCHASE_TYPE_REGULAR_ID }, new BeanPropertyRowMapper<>(PurchaseOrder.class));
		return purchaseOrders;
	}

	@Override
	public boolean exportPurchaseOrderPDF(int purchaseOrderId, ServletContext context) throws Exception {
		boolean isGenerated = false;
		Connection conn = null;
		try {
			String contextPath = getAbsoluteFilePath(PurchaseConstants.PURCHASE_ORDER_JASPER_REPORT);
			String images = context.getRealPath(PurchaseConstants.IMAGE_PATH);
			String pdfFile = context.getRealPath(PurchaseConstants.TEMPDOC_PATH);

			conn = dataSource.getConnection();
			if (pdfFile != null) {
				File file = new File(pdfFile + PurchaseConstants.PURCHASE_ORDER_PDF);
				if (file.createNewFile()) {
				} else {
					file.delete();
				}
			}
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("purchase_order_id", purchaseOrderId);
			parameters.put("realPath", images);
			pdfFile = pdfFile + PurchaseConstants.PURCHASE_ORDER_PDF;
			System.out.println(pdfFile);
			System.out.println(images);
			System.out.println(purchaseOrderId);
			JasperReport jasperReport = JasperCompileManager.compileReport(contextPath);
			JasperPrint jasperprint = JasperFillManager.fillReport(jasperReport, parameters, conn);
			JasperExportManager.exportReportToPdfFile(jasperprint, pdfFile);
			isGenerated = true;
		} catch (Exception e) {
			isGenerated = false;
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();

				}
			}
		}
		return isGenerated;
	}

	public String getAbsoluteFilePath(String classpathRelativePath) throws Exception {
		Resource rsrc = new ClassPathResource(classpathRelativePath);
		return rsrc.getFile().getAbsolutePath();
	}

	@Override
	public boolean updatePurchaseOrderCancelStatus(int statusId, int costCenter, int purchaseOrderId, String remarks, int budget) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean isSucess = false;
		Object[] purchaseDtlParams = new Object[] { statusId, remarks, purchaseOrderId, userDetails.getUserId(), userDetails.getUsername() };
		int value = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER_CANCEL, purchaseDtlParams);

		if (value != 0) {
			isSucess = true;
		}
		/*
		 * if (isSucess) { isSucess =
		 * saveCBPmtGeneralLedgerCreditEntry(purchaseOrderId); isSucess =
		 * saveCBPmtGeneralLedgerDebitEntry(purchaseOrderId); }
		 */
		return isSucess;
	}

	private boolean saveCBPmtGeneralLedgerCreditEntry(int purchaseOrderId) {
		boolean isSuccess = false;
		try {
			jdbcTemplate.update(PurchaseOrderQuertyUtil.INSERT_GENERAL_LEDGER_CREDIT_ENTRY_PAYMENT, new Object[] { purchaseOrderId });
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	/**
	 * DETAIL - Debit Entry
	 * 
	 * @param objCashBankPaymentBean
	 * @return
	 */
	private boolean saveCBPmtGeneralLedgerDebitEntry(int purchaseOrderId) {
		boolean isSuccess = false;
		try {
			jdbcTemplate.update(PurchaseOrderQuertyUtil.INSERT_GENERAL_LEDGER_DEBIT_ENTRY_PAYMENT, new Object[] { purchaseOrderId });
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrderForMerge() throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<PurchaseOrder> mergeList = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_MERGE_LIST, new Object[] { PurchaseConstants.MERGE_PURCHASE_STATUS_LIST, userDetails.getCompanyCode() }, new BeanPropertyRowMapper<>(PurchaseOrder.class));

		return mergeList;
	}

	@Override
	@Transactional
	public boolean updatePurchaseOrderMergeStatus(int cancelpurchaseOrderId, int mergepurchaseOrderId, String userName) throws Exception {
		boolean isSucess = false;
		StringBuilder remarks = new StringBuilder().append(PurchaseConstants.MERGE_REMARKS).append(mergepurchaseOrderId).append(".").append(PurchaseConstants.MERGE_REMARKS_STATEMENT);
		Object[] purchaseDtlParams = new Object[] { PurchaseConstants.STATUS_TYPE_CANCELLED, remarks.toString(), cancelpurchaseOrderId };
		int value = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER_CANCEL, purchaseDtlParams);

		if (value > 0) {
			double cancelledPOTotal = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_CANCELLED_PO_TOTAL, new Object[] { cancelpurchaseOrderId }, Double.class);
			double mergedPOTotal = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_MERGED_PO_TOTAL, new Object[] { mergepurchaseOrderId }, Double.class);

			double mergedTotal = cancelledPOTotal + mergedPOTotal;

			double cancelledPOFreight = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_CANCELLED_PO_FREIGHT, new Object[] { cancelpurchaseOrderId }, Double.class);
			double mergedPOFreight = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_MERGED_PO_FREIGHT, new Object[] { mergepurchaseOrderId }, Double.class);

			double mergedFreight = cancelledPOFreight + mergedPOFreight;

			jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_CANCELLED_PO_TOTAL, new Object[] { 0, 0, cancelpurchaseOrderId });
			jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_MERGED_PO_TOTAL, new Object[] { mergedTotal, mergedFreight, mergepurchaseOrderId });
			value = jdbcTemplate.update(PurchaseOrderQuertyUtil.MERGE_PURCHASE_ORDER, new Object[] { mergepurchaseOrderId, cancelpurchaseOrderId });

			if (value > 0)
				isSucess = true;
		}
		return isSucess;
	}

	@Override
	@Transactional
	public boolean updatePurchaseRecommend(PurchaseOrder purchaseOrder) throws Exception {
		boolean isSucess = false;

		int value = 0;

		jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER_TOTAL, new Object[] { purchaseOrder.getSubTotal(), purchaseOrder.getTotalDiscount(), purchaseOrder.getTotalTax(), purchaseOrder.getFreight(), purchaseOrder.getTotalAmount(), purchaseOrder.getPurchaseOrderId() });

		value = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER_RECOMMEND_STATUS, new Object[] { purchaseOrder.getStatusId(), purchaseOrder.getUserId(), purchaseOrder.getRecmndDate(), purchaseOrder.getRecmndremarks(), purchaseOrder.getTotalAmount(), purchaseOrder.getPurchaseOrderId() });

		for (PurchaseOrderDetail pOrderDetail : purchaseOrder.getPurchaseOrderDetails()) {

			value = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER_DETAIL_RECOMMEND_STATUS, new Object[] { pOrderDetail.getPurchaseItemId(), pOrderDetail.getPurchaseQuoteDetailId(), pOrderDetail.getQuantity(), pOrderDetail.getUnitPrice(), pOrderDetail.getDiscount(), pOrderDetail.getTax(), pOrderDetail.getRequestedQty(), pOrderDetail.getPurchaseOrderDetailId() });
		}
		if (value != 0) {
			isSucess = true;
		}

		return isSucess;
	}

	@Override
	public List<PurchaseSelect> getConsignmentTransferNumbersEdit() throws Exception {
		List<PurchaseSelect> purchaseSelects = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_STOCK_TRANSFER_NUMBER_EDIT, new Object[] { PurchaseConstants.STOCK_TRANSFER_TYPE }, new BeanPropertyRowMapper<>(PurchaseSelect.class));
		return purchaseSelects;
	}

	@Override
	public List<PurchaseSelect> getPurchaseOrderDefList1(int formFieldId) throws Exception {
		List<PurchaseSelect> purchaseOrders = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_FORM_FIELD_VALUES, new Object[] { formFieldId }, new BeanPropertyRowMapper<>(PurchaseSelect.class));
		return purchaseOrders;
	}

	@Override
	public boolean updatePurchaseQuantity(int purchaseOrderDetailId, Double quantity) throws Exception {
		boolean isSucces = false;
		int value = 0;
		try {
			value = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER_DETAIL_FOR_SPLIT, new Object[] { quantity, purchaseOrderDetailId });
			if (value != 0) {
				isSucces = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSucces;
	}

	@Override
	public boolean updatePurchaseSplitQuantity(int purchaseOrderDetailId, PurchaseOrderDetail detail) throws Exception {
		boolean isSucces = false;
		int value = 0;
		try {
			value = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER_DETAIL_SPLIT, new Object[] { detail.getQuantity(), detail.getDiscount(), detail.getTax(), detail.getUnitPrice(), purchaseOrderDetailId });
			if (value != 0) {
				isSucces = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSucces;
	}

	@Override
	public boolean savePurchaseOrderSplitted(PurchaseOrder purchaseOrder, String userId) throws Exception {
		String purchaseOrderNumber = "";
		String potype = purchaseOrder.getPotype();
		boolean isSucess = false;
		String POnumber = "";
		String PONumberfinal = "";
		try {
			int value = 0;
			if (potype.equals("Capex PO")) {

				purchaseOrderNumber = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_NUMBER_CAPX, String.class);

			} else if (potype.equals("Revex PO")) {
				purchaseOrderNumber = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_NUMBER_REVEX, String.class);

			}
			purchaseOrder.setPurchaseOrderNum(purchaseOrderNumber);
			Object[] params = new Object[] { purchaseOrder.getPurchaseOrderNum(), purchaseOrder.getPurchaseOrderDate(), purchaseOrder.getPurchaseFor(), purchaseOrder.getPurchaseType(), purchaseOrder.getCompanyId(), purchaseOrder.getVendorId(), purchaseOrder.getLocationId(), purchaseOrder.getTermsCondition(), purchaseOrder.getRemarks(), purchaseOrder.getStatusId(), userId, purchaseOrder.getSubTotal(), purchaseOrder.getTotalDiscount(), purchaseOrder.getTotalTax(), purchaseOrder.getTotalAmount(), purchaseOrder.getFreight(),
					purchaseOrder.getPaymentTerms(), purchaseOrder.getPotype() };
			value = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.INSERT_PURCHASE_ORDER, params, Integer.class);

			if (value != 0) {
				isSucess = true;
			}

			if (purchaseOrder.getPurchaseOrderDetails() != null) {
				for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrder.getPurchaseOrderDetails()) {
					isSucess = savePurchaseOrderDetailSplitted(purchaseOrderDetail, value);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSucess;
	}

	@Override
	public List<PurchaseOrder> getNotScheduledItemList(PurchaseOrder purchaseOrder) throws Exception {
		List<PurchaseOrder> purchaseOrders = jdbcTemplate.query(PurchaseOrderQuertyUtil.getNotDeliveredSchedule, new Object[] { purchaseOrder.getVendorId(), purchaseOrder.getItemId(), 44 }, new BeanPropertyRowMapper<>(PurchaseOrder.class));
		return purchaseOrders;
	}

	@Override
	public List<PurchaseQuoteDetail> getApprovedPurchasedDetailRateContract(String purchaseDateFrom, String purchaseDateTo, int status, int entityId, int quoteStatus, int purchaseType) throws Exception {
		List<PurchaseQuoteDetail> detail = new ArrayList<>();
		List<PurchaseOrder> polist = new ArrayList<>();

		detail = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_APPROVED_PURCHASE_REQUEST, new Object[] { status, purchaseDateFrom, purchaseDateTo, entityId, quoteStatus }, new BeanPropertyRowMapper<>(PurchaseQuoteDetail.class));

		if (detail.size() > 0) {

			for (int i = 0; i < detail.size(); i++) {

				int itemId = detail.get(i).getItemId();
				int[] type = new int[] { Types.INTEGER, Types.INTEGER };
				Object[] param = new Object[] { itemId, itemId };
				List<Map<String, Object>> ros = jdbcTemplate.queryForList(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL_PRICE, param, type);
				for (Map row : ros) {
					detail.get(i).setOldUnitPrice((Double) row.get("oldUnitPrice"));
				}

				if (detail.get(i).getOldUnitPrice() == null) {
					List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL_PRICE_NULL, param, type);
					for (Map row : rows) {
						detail.get(i).setOldUnitPrice((Double) row.get("oldUnitPrice"));
					}
				}

				int count = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.getNotDeliveredSchedule, Integer.class,  entityId, detail.get(i).getItemId(), 44 );

				polist = jdbcTemplate.query(PurchaseOrderQuertyUtil.getNotDeliveredPOList, new Object[] { entityId, detail.get(i).getItemId(), 44 }, new BeanPropertyRowMapper<>(PurchaseOrder.class));

				if (count == 0) {

					detail.get(i).setDeliverySchdCount(true);
				} else {
					detail.get(i).setDeliverySchdCount(false);
				}
				String tooltipPoNumber = "";

				int j = 0;
				for (PurchaseOrder obj : polist) {
					j = j + 1;
					if (polist.size() == 1 || j == polist.size()) {
						tooltipPoNumber = tooltipPoNumber + obj.getPurchaseOrderNum();
					} else {
						tooltipPoNumber = tooltipPoNumber + obj.getPurchaseOrderNum() + ",";
					}

				}
				if (polist.size() > 0) {
					detail.get(i).setTooltipPo("Connected POs:" + tooltipPoNumber);
				} else {
					detail.get(i).setTooltipPo(tooltipPoNumber);
				}

				PurchaseOrderQuoteTaxDetail quoteTaxDetail = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_TAX_AMOUNT_DETAILS, new Object[] { detail.get(i).getPurchaseQuoteDetailId() }, new BeanPropertyRowMapper<>(PurchaseOrderQuoteTaxDetail.class));
				String ids = quoteTaxDetail.getLtaxIds();
				PurchaseOrderQuoteTaxDetail objIdsBean = new PurchaseOrderQuoteTaxDetail();
				if (ids.contains(",")) {
					String taxIds[] = ids.split(",");
					String taxCodedtl = "";
					int i1 = 1;
					for (String txId : taxIds) {
						int tId = Integer.parseInt(txId);
						objIdsBean = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.getTaxCodeName, new Object[] { tId }, new BeanPropertyRowMapper<>(PurchaseOrderQuoteTaxDetail.class));
						if (taxCodedtl != "" && taxCodedtl != null) {
							taxCodedtl = taxCodedtl + "," + objIdsBean.getTaxCode();
							quoteTaxDetail.getTaxIdslist().add(txId);
						} else {
							taxCodedtl = taxCodedtl + objIdsBean.getTaxCode();
							quoteTaxDetail.getTaxIdslist().add(txId);
						}

						if (i1 == taxIds.length) {
							quoteTaxDetail.setTaxCode(taxCodedtl);
						}
						i1++;
					}
				} else {
					int tId = Integer.parseInt(ids);
					objIdsBean = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.getTaxCodeName, new Object[] { tId }, new BeanPropertyRowMapper<>(PurchaseOrderQuoteTaxDetail.class));
					quoteTaxDetail.setTaxCode(objIdsBean.getTaxCode());
					quoteTaxDetail.getTaxIdslist().add(ids);
				}

				detail.get(i).setQuoteTaxDetail(quoteTaxDetail);

			}

		}
		return detail;
	}

	@Override
	public boolean updatePurchaseOrderDeliverySchedule(PurchaseOrder purchaseOrder, String userId) throws Exception {
		boolean isSucess = false;
		try {
			int value = 0;
			if (purchaseOrder.getIsDeletedIds().size() > 0) {
				for (RateContractDetail rateContractDetail : purchaseOrder.getIsDeletedIds()) {
					if (rateContractDetail.getPurchaseDeliveryId() > 0) {
						if (rateContractDetail.isScheduleItem() == false) {
							value = jdbcTemplate.update(PurchaseOrderQuertyUtil.DELETE_RATE_CONTRACT_DELIVERY_SCHEDULE_ID, new Object[] { rateContractDetail.getPurchaseDeliveryId() });
						}

					}
				}
			}

			for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrder.getPurchaseOrderDetails()) {
				for (RateContractDetail rateContractDetail : purchaseOrderDetail.getRateContractDetails()) {
					if (rateContractDetail.getEdit() == 0) {
						if (rateContractDetail.isScheduleItem() == false) {
							Object[] purcahseContractDeliveryParams = new Object[] { rateContractDetail.getItemId(), rateContractDetail.getQuantity(), rateContractDetail.getQuantity(), rateContractDetail.getPurchaseOrderDeliveryDate(), userId, rateContractDetail.getPurchaseDeliveryId() };
							jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_RATE_CONTRACT_DELIVERY_SCHEDULE, purcahseContractDeliveryParams);
						}

					} else {
						if (rateContractDetail.getEdit() == 1) {

							Object[] purcahseContractDeliveryParams1 = new Object[] { rateContractDetail.getItemId(), rateContractDetail.getQuantity(), rateContractDetail.getPurchaseOrderDeliveryDate(), purchaseOrderDetail.getPurchaseOrderDetailId(), rateContractDetail.getQuantity(), userId };
							jdbcTemplate.update(PurchaseOrderQuertyUtil.INSERT_RATE_CONTRACT_DELIVERY_SCHEDULE, purcahseContractDeliveryParams1);

						}

					}
				}
				isSucess = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSucess;
	}

	@Override
	public boolean updatePurchaseOrderCancelRemarksStatus(int statusId, int purchaseOrderId, String remarks) throws Exception {
		boolean isSucess = false;
		Object[] purchaseDtlParams = new Object[] { statusId, remarks, purchaseOrderId };
		int value = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER_CANCEL, purchaseDtlParams);
		int value1 = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER_CANCEL_BY_ITEM, statusId, purchaseOrderId);
		if (value != 0) {
			isSucess = true;
		}
		return isSucess;
	}

	@Override
	public boolean updatePurchaseOrderWithoutRemarkStatus(int statusId, int costCenter, int purchaseOrderId, int budget) throws Exception {

		boolean isSucess = false;
		try {
			int value = 0;
			Object[] params = new Object[] { statusId, purchaseOrderId };
			value = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER_STATUS, params);
			int value1 = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER_CANCEL_BY_ITEM, params);

			if (value != 0) {
				autoJvEntryGeneration(purchaseOrderId, costCenter, budget);
				isSucess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSucess;

	}

	@Override
	public List<PurchaseQuoteDetail> getApprovedPurchaseQuote1(int status, String entityId, int purchaseType, String poNumber) throws Exception {
		List<PurchaseQuoteDetail> detail = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.##");
		detail = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_APPROVED_PURCHASE_REQUEST1, new Object[] { status, entityId, purchaseType, poNumber }, new BeanPropertyRowMapper<>(PurchaseQuoteDetail.class));

		if (detail.size() > 0) {
			for (int i = 0; i < detail.size(); i++) {

				// Added for getting old unit price

				int itemId = detail.get(i).getItemId();
				String description = detail.get(i).getPurchaseItemDesc();

				int[] type = new int[] { Types.INTEGER, Types.CHAR };
				Object[] param = new Object[] { itemId, description };
				String oldUnitPrice = "";
				List<Map<String, Object>> ros1 = jdbcTemplate.queryForList(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL_PRICE_WITH_DESC, param, type);
				for (Map row : ros1) {
					detail.get(i).setOldUnitPrice((Double) row.get("oldUnitPrice"));
					oldUnitPrice = row.get("oldUnitPrice").toString();
				}
				int[] type1 = new int[] { Types.INTEGER };
				Object[] param1 = new Object[] { itemId };
				if (oldUnitPrice.equals("") || oldUnitPrice.equals(null)) {
					List<Map<String, Object>> ros = jdbcTemplate.queryForList(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL_PRICE, param1, type1);
					for (Map row : ros) {
						detail.get(i).setOldUnitPrice((Double) row.get("oldUnitPrice"));
					}
				}
				if (detail.get(i).getOldUnitPrice() == null) {
					int[] type2 = new int[] { Types.INTEGER, Types.INTEGER };

					Object[] param2 = new Object[] { itemId, itemId };
					List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL_PRICE_NULL, param2, type2);
					for (Map row : rows) {
						detail.get(i).setOldUnitPrice((Double) row.get("oldUnitPrice"));
					}
				}
				double mrQty = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MR_PENDING_QTY, Double.class, detail.get(i).getRequisitionId(), detail.get(i).getItemId());
				detail.get(i).setRequestedQty(mrQty);
				double GRNQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_GRN_QTY, Integer.class, detail.get(i).getItemId());
				double MISSUEQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_MI_QTY, Integer.class, detail.get(i).getItemId());
				// 13/02/21 gatepass item included
				int GatePassOut = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSOUT_QTY, Integer.class, itemId);
				int GatePassIn = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSIN_QTY, Integer.class, itemId);
				// end

				// double availableQTY = 0;
				// if (GRNQTY > MISSUEQTY) {
				// availableQTY = GRNQTY - MISSUEQTY;
				// detail.get(i).setAvailableQty(availableQTY);
				// } else if (GRNQTY < MISSUEQTY || GRNQTY == MISSUEQTY) {
				// availableQTY = 0;
				// detail.get(i).setAvailableQty(availableQTY);
				//
				// }
				double itemOpeningQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_OPENING_QTY, Double.class, detail.get(i).getItemId());

				double availableQTY = 0;

				// availableQTY = (GRNQTY + itemOpeningQTY) - MISSUEQTY;
				availableQTY = (GRNQTY + itemOpeningQTY) - (MISSUEQTY + (GatePassOut - GatePassIn));

				if (availableQTY < 0)
					availableQTY = 0;
				detail.get(i).setAvailableQty(availableQTY);

				PurchaseOrderQuoteTaxDetail quoteTaxDetail = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_TAX_AMOUNT_DETAILS_PQ, new Object[] { detail.get(i).getPurchaseQuoteDetailId() }, new BeanPropertyRowMapper<>(PurchaseOrderQuoteTaxDetail.class));

				detail.get(i).setQuoteTaxDetail(quoteTaxDetail);

			}
		}
		return detail;
	}

	@Override
	public boolean deletepqdetail(Integer purchasequotedetailId) throws Exception {
		// TODO Auto-generated method stub
		boolean isSuccess = false;

		try {
			int purchasequoteId = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.Get_PurchaseQuoteId, Integer.class, purchasequotedetailId);
			if (purchasequoteId > 0) {

				int i = jdbcTemplate.update(PurchaseQuotationQueryUtil.delete_purchase_quote_detail, new Object[] { purchasequoteId });
				i = jdbcTemplate.update(PurchaseQuotationQueryUtil.delete_purchase_quote, new Object[] { purchasequoteId });
				isSuccess = true;
			}

		} catch (Exception e) {
			System.out.println("ERROR IN PurchaseOrderDAOImpl" + e.getMessage());
		}
		return isSuccess;

	}

	@Override
	public boolean deletepqdetail1(Integer purchasequotedetailId) throws Exception {
		// TODO Auto-generated method stub
		boolean isSuccess = false;

		try {
			int purchasequoteId = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.Get_PurchaseQuoteId, Integer.class, purchasequotedetailId);

			if (purchasequoteId > 0) {

				int i = jdbcTemplate.update(PurchaseQuotationQueryUtil.delete_purchase_quote_detail_1, new Object[] { purchasequotedetailId });
				int count = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.Get_COUNT, Integer.class, purchasequoteId);

				if (count == 0) {
					i = jdbcTemplate.update(PurchaseQuotationQueryUtil.delete_purchase_quote, new Object[] { purchasequoteId });
				}
				isSuccess = true;
			}

		} catch (Exception e) {
			System.out.println("ERROR IN PurchaseOrderDAOImpl" + e.getMessage());
		}
		return isSuccess;

	}

	@Override
	public PurchaseOrder getVendordetails(String vendorId) throws Exception {
		PurchaseOrder purchaseOrderObj = new PurchaseOrder();
		List<PurchaseOrder> vendordetailList = new ArrayList<>();
		try {
			int addressId = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_ADDRESS_ID, Integer.class, vendorId);
			vendordetailList = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_ADDRESS_DETAIL, new Object[] { addressId }, new BeanPropertyRowMapper<>(PurchaseOrder.class));
			purchaseOrderObj.setVendordetailList(vendordetailList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return purchaseOrderObj;
	}

	@Override
	public PurchaseOrder getitemList(String requisitionNo, int itemId, double quantity) throws Exception {
		PurchaseOrder purchaseOrderObj = new PurchaseOrder();

		try {
			List<PurchaseOrder> itemList = jdbcTemplate.query(PurchaseOrderQuertyUtil.CHECK_PQ_ITEM_ALREADY_EXIST, new Object[] { Integer.parseInt(requisitionNo), itemId, Integer.parseInt(requisitionNo), itemId }, new BeanPropertyRowMapper<>(PurchaseOrder.class));
			purchaseOrderObj.setItemList(itemList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return purchaseOrderObj;

	}

	@Override
	public List<SelectivityBean> getCurrency() throws Exception {
		List<SelectivityBean> currencyList = jdbcTemplate.query(PurchaseOrderQuertyUtil.getcurrecy, new BeanPropertyRowMapper<>(SelectivityBean.class));
		// purchaseOrderObj.setItemList(itemList);
		return currencyList;

	}

	@Override
	public List<SelectivityBean> BudgetTypeList(String poType) throws Exception {

		List<SelectivityBean> BudgetTypeList = jdbcTemplate.query(PurchaseOrderQuertyUtil.BUDGET_TYPE_LIST, new BeanPropertyRowMapper<>(SelectivityBean.class), poType);
		return BudgetTypeList;

	}

	@Override
	public String checkpurchaseOrderDetails(String purchaseOrderID) {
		String paymentCountry = "";
		try {

			System.out.println("paymentCountry" + paymentCountry);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return paymentCountry;
	}

	@Override
	public PrintPurchaseOrderBean printPurchaseOrder(Integer purchaseOrderNo) {

		PrintPurchaseOrderBean objGeneralInvoiceBean = new PrintPurchaseOrderBean();
		List<PrintPurchaseOrderBean> objList = new ArrayList<>();

		try {
			System.out.println(purchaseOrderNo);
			objGeneralInvoiceBean = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.get_purchase_order_pdf_header_values, new Object[] { purchaseOrderNo }, new BeanPropertyRowMapper<>(PrintPurchaseOrderBean.class));
			if (objGeneralInvoiceBean.getPurchaseOrderType().contains("Capex")) {
				if (objGeneralInvoiceBean.getReqType().equalsIgnoreCase("PO")) {
					objGeneralInvoiceBean.setPurchaseOrderType("Capital Purchase Order");
				} else {
					objGeneralInvoiceBean.setPurchaseOrderType("Capital Work Order");
				}
			} else if (objGeneralInvoiceBean.getPurchaseOrderType().contains("Revex")) {
				if (objGeneralInvoiceBean.getReqType().equalsIgnoreCase("PO")) {
					objGeneralInvoiceBean.setPurchaseOrderType("Revenue Purchase Order");
				} else {
					objGeneralInvoiceBean.setPurchaseOrderType("Revenue Work Order");
				}
			}
			if (objGeneralInvoiceBean.getVendorAddress().contains("- ,")) {
				objGeneralInvoiceBean.setVendorAddress("");
			}
			if (objGeneralInvoiceBean.getCompanyId().equalsIgnoreCase("C0009")) {
				objGeneralInvoiceBean.setOrganisationName("Lalaji Memorial Educational Society");
			} else {
				objGeneralInvoiceBean.setOrganisationName("Lalaji Memorial Omega International School");
			}
			String TermsCondition = objGeneralInvoiceBean.getTerms_Condition();
			TermsCondition = TermsCondition + " " + objGeneralInvoiceBean.getOrganisationName();
			objGeneralInvoiceBean.setTerms_Condition(TermsCondition);
			objGeneralInvoiceBean.setPoAmendNo(objGeneralInvoiceBean.getPoAmendNo());

			double subTotal = 0;
			int count = 0;
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseOrderQuertyUtil.get_purchase_order_pdf_detail_values, new Object[] { purchaseOrderNo });
			for (Map row : rows) {
				PrintPurchaseOrderBean objPurchaseInvoiceJobDetailBean = new PrintPurchaseOrderBean();

				objPurchaseInvoiceJobDetailBean.setPurchaseReqNo((String) row.get("purchaseReqNo"));

				objPurchaseInvoiceJobDetailBean.setItemName(((String) row.get("purchaseItemName")));

				objPurchaseInvoiceJobDetailBean.setItemDescription((String) row.get("itemDescription"));
				objPurchaseInvoiceJobDetailBean.setQuantity((Double.parseDouble(row.get("vendorQuantity").toString())));
				objPurchaseInvoiceJobDetailBean.setUom((Integer) row.get("uom"));
				objPurchaseInvoiceJobDetailBean.setUomName((String) row.get("uomName"));
				objPurchaseInvoiceJobDetailBean.setRate((Double) row.get("rate"));
				objPurchaseInvoiceJobDetailBean.setDicountPercentage((int) row.get("percentage"));
				objPurchaseInvoiceJobDetailBean.setDiscountAmount(((double) row.get("discount_amount")));
				objPurchaseInvoiceJobDetailBean.setTaxIGSTinPercent((Double.parseDouble(row.get("taxIGSTinPercent").toString())));
				objPurchaseInvoiceJobDetailBean.setTaxSGSTinPercent((Double.parseDouble(row.get("taxSGSTinPercent").toString())));
				objPurchaseInvoiceJobDetailBean.setTaxCGSTinPercent((Double.parseDouble(row.get("taxCGSTinPercent").toString())));
				objPurchaseInvoiceJobDetailBean.setTaxIGST((Double.parseDouble(row.get("taxIGST").toString())));
				objPurchaseInvoiceJobDetailBean.setTaxSGST((Double.parseDouble(row.get("taxSGST").toString())));
				objPurchaseInvoiceJobDetailBean.setTaxCGST((Double.parseDouble(row.get("taxCGST").toString())));
				objPurchaseInvoiceJobDetailBean.setSerialnumber(++count);
				double UnitPrice = objPurchaseInvoiceJobDetailBean.getRate();
				double qty = objPurchaseInvoiceJobDetailBean.getQuantity();
				double rowtotal = 0;

				objPurchaseInvoiceJobDetailBean.setTotal((qty * UnitPrice));
				rowtotal = rowtotal + objPurchaseInvoiceJobDetailBean.getTotal();
				objPurchaseInvoiceJobDetailBean.setSubTotal(rowtotal);
				double taxAmount = objPurchaseInvoiceJobDetailBean.getTaxCGST() + objPurchaseInvoiceJobDetailBean.getTaxSGST() + objPurchaseInvoiceJobDetailBean.getTaxIGST();
				double vat = objPurchaseInvoiceJobDetailBean.getTaxCGSTinPercent() + objPurchaseInvoiceJobDetailBean.getTaxSGSTinPercent() + objPurchaseInvoiceJobDetailBean.getTaxIGSTinPercent();

				objPurchaseInvoiceJobDetailBean.setVat(vat);
				// discount Cal
				double disAmnt = 0;
				if (objPurchaseInvoiceJobDetailBean.getDicountPercentage() == 0) {
					// disAmnt = 0;
					disAmnt = objPurchaseInvoiceJobDetailBean.getDiscountAmount();
					double discountper = (disAmnt / objPurchaseInvoiceJobDetailBean.getTotal()) * 100;
					objPurchaseInvoiceJobDetailBean.setDicountPercentage((int) discountper);

				}

				// amount
				double taxCGSTAmount = 0;
				double taxSGSTAmount = 0;
				double taxIGSTAmount = 0;
				taxCGSTAmount = ((((qty * UnitPrice) - objPurchaseInvoiceJobDetailBean.getDiscountAmount()) / 100) * objPurchaseInvoiceJobDetailBean.getTaxCGSTinPercent());
				taxSGSTAmount = ((((qty * UnitPrice) - objPurchaseInvoiceJobDetailBean.getDiscountAmount()) / 100) * objPurchaseInvoiceJobDetailBean.getTaxSGSTinPercent());
				taxIGSTAmount = ((((qty * UnitPrice) - objPurchaseInvoiceJobDetailBean.getDiscountAmount()) / 100) * objPurchaseInvoiceJobDetailBean.getTaxIGSTinPercent());

				objPurchaseInvoiceJobDetailBean.setTaxCGST(taxCGSTAmount);
				objPurchaseInvoiceJobDetailBean.setTaxSGST(taxSGSTAmount);
				objPurchaseInvoiceJobDetailBean.setTaxIGST(taxIGSTAmount);

				objPurchaseInvoiceJobDetailBean.setAmount((objPurchaseInvoiceJobDetailBean.getTotal() + taxCGSTAmount + taxSGSTAmount + taxIGSTAmount) - objPurchaseInvoiceJobDetailBean.getDiscountAmount());

				// subTotal
				subTotal = subTotal + taxAmount + objPurchaseInvoiceJobDetailBean.getAmount();
				double amount = 0;
				double igstTax = 0;
				double sgstTax = 0;
				double cgstTax = 0;
				double discount = 0;
				double freightCharges = 0;
				double otherCharges = 0;

				igstTax = objGeneralInvoiceBean.getTaxIGST() + objPurchaseInvoiceJobDetailBean.getTaxIGST();

				sgstTax = objGeneralInvoiceBean.getTaxSGST() + objPurchaseInvoiceJobDetailBean.getTaxSGST();

				cgstTax = objGeneralInvoiceBean.getTaxCGST() + objPurchaseInvoiceJobDetailBean.getTaxCGST();

				discount = objGeneralInvoiceBean.getDiscount() + objPurchaseInvoiceJobDetailBean.getDiscountAmount();

				otherCharges = objGeneralInvoiceBean.getOtherCharges() + objPurchaseInvoiceJobDetailBean.getOtherCharges();

				objGeneralInvoiceBean.setSubTotal(subTotal);
				objGeneralInvoiceBean.setTotal(objGeneralInvoiceBean.getTotal() + objPurchaseInvoiceJobDetailBean.getTotal());
				objGeneralInvoiceBean.setAmount(objGeneralInvoiceBean.getAmount() + objPurchaseInvoiceJobDetailBean.getAmount());
				objGeneralInvoiceBean.setTaxIGST(igstTax);
				objGeneralInvoiceBean.setTaxSGST(sgstTax);
				objGeneralInvoiceBean.setTaxCGST(cgstTax);
				objGeneralInvoiceBean.setDiscount(discount);
				objGeneralInvoiceBean.setOtherCharges(otherCharges);

				objList.add(objPurchaseInvoiceJobDetailBean);

			}
			objGeneralInvoiceBean.setAmount(objGeneralInvoiceBean.getAmount() + objGeneralInvoiceBean.getFreightCharges() + objGeneralInvoiceBean.getOtherCharges());
			objGeneralInvoiceBean.setTotalNetPrice(objGeneralInvoiceBean.getTotal() - objGeneralInvoiceBean.getDiscount());
			objGeneralInvoiceBean.setfTotal(objGeneralInvoiceBean.getAmount());
			double roundof = objGeneralInvoiceBean.getAmount() - Math.floor(objGeneralInvoiceBean.getAmount());
			System.out.println(roundof);
			objGeneralInvoiceBean.setRoundOf(roundof);
			String amountInWords = wordingConversion.convertToIndianCurrency(String.valueOf(Math.round(objGeneralInvoiceBean.getAmount())));
			amountInWords = objGeneralInvoiceBean.getCurrencyType() + "  " + amountInWords;
			objGeneralInvoiceBean.setAmountinWords(amountInWords);
			System.out.println(objGeneralInvoiceBean.getCurrencyType() + "  " + wordingConversion.convertToIndianCurrency(String.valueOf(objGeneralInvoiceBean.getSubTotal())));

			objGeneralInvoiceBean.setDetailList(objList);

			List<PurchaseOrder> groupList = jdbcTemplate.query(PurchaseOrderQuertyUtil.GROUP_BY_GST_TAX, new Object[] { purchaseOrderNo, purchaseOrderNo, purchaseOrderNo }, new BeanPropertyRowMapper<>(PurchaseOrder.class));

			objGeneralInvoiceBean.setGstgropuList(groupList);
			objGeneralInvoiceBean.setAmount(Math.round(objGeneralInvoiceBean.getAmount()));
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return objGeneralInvoiceBean;

	}

	@Override
	public List<PurchaseSelect> getPurchaseOrderStatusDropDown() throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<PurchaseSelect> purchaseSelects = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_STATUS_DROPDOWN, new BeanPropertyRowMapper<>(PurchaseSelect.class));
		return purchaseSelects;
	}

	@Override
	public List<PurchaseSelect> getGRNStatusDropDown() throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<PurchaseSelect> purchaseSelects = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_GRN_STATUS_DROPDOWN, new BeanPropertyRowMapper<>(PurchaseSelect.class));
		return purchaseSelects;
	}

	@Override
	public String getPOSequenceNumber(String POType) {
		String potype = POType;
		boolean isSucess = false;
		String POnumber = "";
		String PONumberfinal = "";
		try {
			int value = 0;
			if (potype.equals("Capex PO")) {

				PONumberfinal = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_NUMBER_CAPX, String.class);

			} else if (potype.equals("Revex PO")) {
				PONumberfinal = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_NUMBER_REVEX, String.class);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return PONumberfinal;
	}

	@Override
	public String getPOSeqCompanybased(String POType, String companyId) {
		String potype = POType;
		boolean isSucess = false;
		String POnumber = "";
		String PONumberfinal = "";
		try {
			int value = 0;

			if (potype.equals("Capex PO")) {
				String CompanyShortName = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME, String.class, companyId);

				PONumberfinal = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1, String.class, CompanyShortName.concat("-C%"));
				PONumberfinal = CompanyShortName.concat("-" + PONumberfinal);

			} else if (potype.equals("Revex PO")) {
				String CompanyShortName = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME, String.class, companyId);
				PONumberfinal = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_NUMBER_REVEX1, String.class, CompanyShortName.concat("-R%"));
				PONumberfinal = CompanyShortName.concat("-" + PONumberfinal);

			} else if (potype.equals("Capex WO")) {
				String CompanyShortName = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME, String.class, companyId);

				PONumberfinal = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_WORK_ORDER_NUMBER_CAPX, String.class, CompanyShortName.concat("-CWO%"));
				PONumberfinal = CompanyShortName.concat("-" + PONumberfinal);

			} else if (potype.equals("Revex WO")) {
				String CompanyShortName = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME, String.class, companyId);
				PONumberfinal = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_WORK_ORDER_NUMBER_RAPX, String.class, CompanyShortName.concat("-RWO%"));
				PONumberfinal = CompanyShortName.concat("-" + PONumberfinal);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return PONumberfinal;
	}

	@Override
	public PurchaseOrder updatePendingqty(String requisitionNo, int itemId, double quantity) throws Exception {

		PurchaseOrder PurchaseOrder = new PurchaseOrder();
		try {
			jdbcTemplate.update(PurchaseQuotationQueryUtil.UPDATE_PENDING_QTY_PQ, new Object[] { quantity, Integer.parseInt(requisitionNo), itemId });

		} catch (Exception e) {
			e.printStackTrace();
		}
		return PurchaseOrder;

	}

	@Override
	public PurchaseOrder getqtyValidation(int requisitionNo, int itemId, int poId) throws Exception {
		PurchaseOrder PurchaseOrder = new PurchaseOrder();
		boolean success = false;

		try {

			double quant = 0;

			double mrQty = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MR_PENDING_QTY, Double.class, requisitionNo, itemId);
			double pqQty = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_PQ_QTY, Double.class, requisitionNo, itemId);
			String requisitionNumber = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MR_NUM, String.class, requisitionNo);

			double pOQty = 0;

			pOQty = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_PO_QTY, Double.class, requisitionNumber, itemId);

			// }
			double MIQty = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MI_QTY, Double.class, requisitionNo, itemId);

			quant = mrQty - (pOQty);

			int count = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_PO1_QTY, Integer.class, requisitionNumber, itemId, poId);
			//
			// quant = count;
			PurchaseOrder.setCount(count);
			// }

			PurchaseOrder.setCheckqty(quant);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PurchaseOrder;

	}

	// AMENDMENT

	public boolean savePurchaseOrderDetailAmendment(PurchaseOrderDetail purchaseOrderDetail, int purchaseOrderId) {
		boolean isSucess = false;

		int discountType = 0;
		if (purchaseOrderDetail.getDiscountType().equals("58.00")) {
			purchaseOrderDetail.setDiscountPercent(purchaseOrderDetail.getDiscountcal());

			double d = Double.parseDouble(purchaseOrderDetail.getDiscountType());
			discountType = (int) d;

		} else if (purchaseOrderDetail.getDiscountType().equals("59.00")) {
			purchaseOrderDetail.setDiscountPercent(0);

			double d = Double.parseDouble(purchaseOrderDetail.getDiscountType());
			discountType = (int) d;
		} else {
			discountType = 14;
		}

		if (purchaseOrderDetail.getVendorUOM().equalsIgnoreCase(null) || purchaseOrderDetail.getVendorUOM().equalsIgnoreCase("")) {
			purchaseOrderDetail.setVendorUOM("0");
		}
		if (purchaseOrderDetail.getPurchaseUOM().equalsIgnoreCase(null) || purchaseOrderDetail.getPurchaseUOM().equalsIgnoreCase("")) {
			purchaseOrderDetail.setPurchaseUOM("0");
		}
		Object[] purchaseDtlParams = new Object[] { purchaseOrderDetail.getPurchaseItemId(), purchaseOrderDetail.getPurchaseQuoteDetailId(), purchaseOrderDetail.getQuantity(), purchaseOrderDetail.getPurchaseStatusId(), purchaseOrderDetail.getUnitPrice(), purchaseOrderId, purchaseOrderDetail.getDiscount(), purchaseOrderDetail.getPrRequestNo(), purchaseOrderDetail.getTaxCGST(), purchaseOrderDetail.getTaxSGST(), purchaseOrderDetail.getTaxIGST(), purchaseOrderDetail.getPurchaseItemDesc(), purchaseOrderDetail.getDiscountPercent(),
				purchaseOrderDetail.getDiscount(), purchaseOrderDetail.getTaxCGSTinPercent(), purchaseOrderDetail.getTaxSGSTinPercent(), purchaseOrderDetail.getTaxIGSTinPercent(), discountType, purchaseOrderDetail.getCostcenter(), Integer.parseInt(purchaseOrderDetail.getPurchaseUOM()), purchaseOrderDetail.getPurchaseQty(), Integer.parseInt(purchaseOrderDetail.getVendorUOM()) };
		int value = jdbcTemplate.update(PurchaseOrderQuertyUtil.INSERT_PURCHASE_ORDER_DETAIL, purchaseDtlParams);

		if (value != 0) {

			isSucess = true;
		}
		return isSucess;
	}

	public boolean updatePurchaseOrderDetailAmendment(PurchaseOrderDetail purchaseOrderDetail, int purchaseOrderId) {
		boolean isSucess = false;

		Object[] purchaseDtlParams = new Object[] { purchaseOrderDetail.getPurchaseItemId(), purchaseOrderDetail.getPurchaseQuoteDetailId(), purchaseOrderDetail.getQuantity(), purchaseOrderDetail.getPurchaseStatusId(), purchaseOrderDetail.getUnitPrice(), purchaseOrderId, purchaseOrderDetail.getDiscount(), purchaseOrderDetail.getTax(), purchaseOrderDetail.getTaxCGST(), purchaseOrderDetail.getTaxSGST(), purchaseOrderDetail.getTaxIGST(), purchaseOrderDetail.getPurchaseOrderDetailId() };

		if (purchaseOrderDetail.getDiscountType() == "58") {
			purchaseOrderDetail.setDiscountPercent(purchaseOrderDetail.getDiscountcal());
		} else if (purchaseOrderDetail.getDiscountType() == "59") {
			purchaseOrderDetail.setDiscountPercent(0);
		}
		int value1 = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_TAX_IN_PQUOTE, purchaseOrderDetail.getTaxCGSTinPercent(), purchaseOrderDetail.getTaxSGSTinPercent(), purchaseOrderDetail.getTaxIGSTinPercent(), purchaseOrderDetail.getDiscountPercent(), purchaseOrderDetail.getDiscount(), Integer.parseInt(purchaseOrderDetail.getDiscountType()), purchaseOrderDetail.getPurchaseQuoteDetailId());

		int value = jdbcTemplate.update(PurchaseOrderQuertyUtil.UPDATE_PURCHASE_ORDER_DETAIL, purchaseDtlParams);

		if (value != 0) {
			isSucess = true;
		}
		return isSucess;
	}

	@Override
	public List<ConsignmentRequestSubBean> costcenterList(String companyId) throws Exception {
		List<ConsignmentRequestSubBean> list = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_COST_LIST_COMPANY_BASE, new Object[] { companyId }, new BeanPropertyRowMapper<>(ConsignmentRequestSubBean.class));
		return list;

	}

	@Override
	public PurchaseOrder getPurchaseOrderLog(String purchaseOrderId) throws Exception {
		DecimalFormat df2 = new DecimalFormat("0.00");
		PurchaseOrder purchaseOrderObj = new PurchaseOrder();
		int id = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.getPOId, Integer.class, purchaseOrderId);
		purchaseOrderObj = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.EDIT_PURCHASE_ORDER_LOG, new Object[] { purchaseOrderId }, new BeanPropertyRowMapper<>(PurchaseOrder.class));

		List<PurchaseQuoteDetail> purchaseQuoteDetails = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL_LOG, new Object[] { id }, new BeanPropertyRowMapper<>(PurchaseQuoteDetail.class));

		for (int i = 0; i < purchaseQuoteDetails.size(); i++) {
			int itemId = purchaseQuoteDetails.get(i).getItemId();
			int[] type = new int[] { Types.INTEGER };
			Object[] param = new Object[] { itemId };
			List<Map<String, Object>> ros = jdbcTemplate.queryForList(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_DETAIL_PRICE, param, type);
			for (Map row : ros) {
				purchaseQuoteDetails.get(i).setOldUnitPrice((Double) row.get("oldUnitPrice"));
			}
			// purchaseQuoteDetails.get(i).setNetPrice((purchaseQuoteDetails.get(i).getUnitPrice()
			// * purchaseQuoteDetails.get(i).getQuantity()) -
			// purchaseQuoteDetails.get(i).getDiscount());
			int GRNQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_GRN_QTY, Integer.class, purchaseQuoteDetails.get(i).getItemId());
			int MISSUEQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_MI_QTY, Integer.class, purchaseQuoteDetails.get(i).getItemId());
			// 13/02/21 gatepass item included
			int GatePassOut = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSOUT_QTY, Integer.class, itemId);
			int GatePassIn = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSIN_QTY, Integer.class, itemId);
			// end
			// int availableQTY = 0;
			// if (GRNQTY > MISSUEQTY) {
			// availableQTY = GRNQTY - MISSUEQTY;
			// purchaseQuoteDetails.get(i).setAvailableQty(availableQTY);
			// } else if (GRNQTY < MISSUEQTY || GRNQTY == MISSUEQTY) {
			// availableQTY = 0;
			// purchaseQuoteDetails.get(i).setAvailableQty(availableQTY);
			//
			// }
			double itemOpeningQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_OPENING_QTY, Double.class, purchaseQuoteDetails.get(i).getItemId());

			double availableQTY = 0;

			// availableQTY = (GRNQTY + itemOpeningQTY) - MISSUEQTY;

			availableQTY = (GRNQTY + itemOpeningQTY) - (MISSUEQTY + (GatePassOut - GatePassIn));

			if (availableQTY < 0)
				availableQTY = 0;
			purchaseQuoteDetails.get(i).setAvailableQty(availableQTY);
		}

		purchaseOrderObj.setPurchaseQuoteDetails(purchaseQuoteDetails);

		for (int i = 0; i < purchaseOrderObj.getPurchaseQuoteDetails().size(); i++) {
			PurchaseOrderQuoteTaxDetail quoteTaxDetail = jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_TAX_AMOUNT_DETAILS_PO, new Object[] { purchaseOrderObj.getPurchaseQuoteDetails().get(i).getPurchaseOrderDetailId() }, new BeanPropertyRowMapper<>(PurchaseOrderQuoteTaxDetail.class));

			PurchaseOrderQuoteTaxDetail objIdsBean = new PurchaseOrderQuoteTaxDetail();

			purchaseOrderObj.getPurchaseQuoteDetails().get(i).setQuoteTaxDetail(quoteTaxDetail);

		}
		return purchaseOrderObj;
	}

	@Override
	public PurchaseOrder getAvailableQTY(int requisitionNo, int itemId) throws Exception {
		PurchaseOrder PurchaseOrder = new PurchaseOrder();
		boolean success = false;

		try {

			int ReqType = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_REQUEST_TYPE_CHECK, Integer.class, requisitionNo);
			double quant = 0;

			double mrQty = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MR_PENDING_QTY, Double.class, requisitionNo, itemId);
			double pqQty = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_PQ_QTY, Double.class, requisitionNo, itemId);
			String requisitionNumber = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MR_NUM, String.class, requisitionNo);

			int count = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_PO_COUNT, Integer.class, requisitionNumber, itemId);

			double pOQty = 0;
			if (count > 0) {
				pOQty = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_POA_QTY, Double.class, requisitionNumber, itemId);

			} else {
				pOQty = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_PO_QTY, Double.class, requisitionNumber, itemId);

			}
			double MIQty = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MI_QTY, Double.class, requisitionNo, itemId);

			quant = mrQty - (pOQty);

			PurchaseOrder.setCheckqty(quant);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PurchaseOrder;

	}

	@Override
	public PurchaseOrder getqtycheckFromPO(int requisitionNo, int itemId, int poId) throws Exception {
		PurchaseOrder PurchaseOrder = new PurchaseOrder();
		double quant = 0;
		double mrQty = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MR_PENDING_QTY, Double.class, requisitionNo, itemId);
		String requisitionNumber = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MR_NUM, String.class, requisitionNo);

		double pOQty = 0;

		int count = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_PO1_QTY, Integer.class, requisitionNumber, itemId, poId);
		//
		// quant = count;
		PurchaseOrder.setCount(count);
		return PurchaseOrder;

	}

	@Override
	public PurchaseOrder geYearlytBudgetAmount(PurchaseOrder purchaseOrder, String userId) {
		PurchaseOrder po = new PurchaseOrder();
		try {
			// int year = Calendar.getInstance().get(Calendar.YEAR);
			// String previuosyr = String.valueOf((year + 1));
			// String Financeyear = year + "-" + previuosyr.subSequence(2, 4);
			// double amount =
			// jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_BUDGET_AMOUNT,
			// Double.class, Financeyear, purchaseOrder.getBudgetType());
			String query = CashBankPaymentQueryUtil.GET_BUDGET_DEFN_AMOUNT;
			String queryCount = CashBankPaymentQueryUtil.GET_BUDGET_DEFN_AMOUNT_COUNT;
			String utilizedQuery = CashBankPaymentQueryUtil.GET_BUDGET_UTILIZED_AMOUNT_COUNT;
			String utilizedQueryCount = CashBankPaymentQueryUtil.GET_BUDGET_UTILIZED_AMOUNT_COUNT1;
			if (purchaseOrder.getBudgetType() != 0) {
				query = query + " and budget_definition_id = '" + purchaseOrder.getBudgetType() + "'";
				queryCount = queryCount + " and budget_definition_id = '" + purchaseOrder.getBudgetType() + "'";
				utilizedQuery = utilizedQuery + " and purchase_order.budget_type_id  = " + purchaseOrder.getBudgetType() + "";
				utilizedQueryCount = utilizedQueryCount + " and purchase_order.budget_type_id  = " + purchaseOrder.getBudgetType() + "";

				if (purchaseOrder.getCostcenter() != null) {
					query = query + "      and  cost_center = '" + purchaseOrder.getCostcenter() + "'";
					queryCount = queryCount + "  and  cost_center = '" + purchaseOrder.getCostcenter() + "'";
					utilizedQuery = utilizedQuery + "      and  purchase_order.cost_center_id = '" + purchaseOrder.getCostcenter() + "'";
					utilizedQueryCount = utilizedQueryCount + "  and  purchase_order.cost_center_id = '" + purchaseOrder.getCostcenter() + "'";
					// utilizedQuery = utilizedQuery + " and cost_center
					// =
					// '" + objCashBankPaymentDetailBean.getCostCenter()
					// +
					// "'";
				}
			}
			double balanceAmt = 0;
			double UAmt = 0;
			DecimalFormat df = new DecimalFormat("0.00");
			int count = jdbcTemplate.queryForObject(queryCount, Integer.class);
			if (count > 0) {

				// double amount =
				// jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_BUDGET_AMOUNT,
				// Double.class, purchaseOrder.getBudgetType());
				// po.setAmount(amount);

				double budgetVal = jdbcTemplate.queryForObject(query, Double.class);
				po.setAmount(budgetVal);
				po.setBudgetAmt(budgetVal);
				double paidVal = 0;
				UAmt = jdbcTemplate.queryForObject(utilizedQueryCount, Double.class);
				if (UAmt > 0) {
					paidVal = jdbcTemplate.queryForObject(utilizedQuery, Double.class);
					po.setBudgetUtilizedAmt(paidVal);
					balanceAmt = budgetVal - paidVal;
					po.setBudgetBalAmt(balanceAmt);
				}

			}
			// if (purchaseOrder.getBudgetType() != 0) {
			// double amount =
			// jdbcTemplate.queryForObject(PurchaseOrderQuertyUtil.GET_BUDGET_AMOUNT,
			// Double.class, purchaseOrder.getBudgetType());
			// po.setAmount(amount);
			//
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrderExportList(int purchaseType) throws Exception {
		System.out.println(purchaseType);
		List<PurchaseOrder> purchaseOrders = jdbcTemplate.query(PurchaseOrderQuertyUtil.GET_PURCHASE_ORDER_LIST_EXPORT, new Object[] { purchaseType }, new BeanPropertyRowMapper<>(PurchaseOrder.class));
		return purchaseOrders;
	}

}