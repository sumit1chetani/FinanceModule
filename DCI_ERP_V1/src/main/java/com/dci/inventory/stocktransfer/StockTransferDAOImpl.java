package com.dci.inventory.stocktransfer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CommonUtil;
import com.dci.common.util.CommonUtilityQueryUtil;
import com.dci.tenant.common.CommonUtilityService;
import com.dci.tenant.finance.consignmentRequest.ConsignmentRequestQueryUtil;
import com.dci.tenant.finance.grn.GRNPurchaseOrderBean;
import com.dci.tenant.finance.purchasequotation.PurchaseQuotationQueryUtil;

@Repository
public class StockTransferDAOImpl implements StockTransferDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	CommonUtilityService commonUtilityService;

	private int requisitionType = 119;

	@Override
	public List getDropdown() {

		List<Object> list = new ArrayList<>();

		list.add(getLocation());
		list.add(getRequisition());
		list.add(getDefaultCode("F0007", 30));
		list.add(getDefaultCode("F0007", 31));

		String stacknumber = jdbcTemplate.queryForObject(StockTransferQueryUtil.GET_STOCK_NUMBER, String.class);
		list.add(stacknumber);
		return list;

	}

	public List<StockTransferBean> getLocation() {
		List<StockTransferBean> list = new ArrayList<>();
		try {
			List<Map<String, Object>> location = jdbcTemplate.queryForList(StockTransferQueryUtil.GET_LOACATION);
			for (Map row : location) {
				StockTransferBean bean = new StockTransferBean();
				bean.setId(covertNullToEmpty(String.valueOf(row.get("location_id"))));
				bean.setText(covertNullToEmpty(String.valueOf(row.get("location_name"))));
				list.add(bean);

			}

		} catch (Exception e) {

		}
		return list;
	}

	public List<StockTransferBean> getRequisition() {

		List<StockTransferBean> list = new ArrayList<>();
		try {
			List<Map<String, Object>> location = jdbcTemplate.queryForList(StockTransferQueryUtil.GET_REQUISITION);
			for (Map row : location) {
				StockTransferBean bean = new StockTransferBean();
				bean.setId(covertNullToEmpty(String.valueOf(row.get("purchase_requisition_id"))));
				bean.setText(covertNullToEmpty(String.valueOf(row.get("requisition_number"))));
				bean.setReqDate(covertNullToEmpty(String.valueOf(row.get("requisition_date"))));
				bean.setReqBy(covertNullToEmpty(String.valueOf(row.get("requested_by"))));
				bean.setSourceLoc(covertNullToInteger(String.valueOf(row.get("source_id"))));
				bean.setDestLoc(covertNullToInteger(String.valueOf(row.get("destination_id"))));
				bean.setSourceLocName(covertNullToEmpty(String.valueOf(row.get("source_name"))));
				bean.setDestLocName(covertNullToEmpty(String.valueOf(row.get("destination_name"))));
				bean.setCompanyId(covertNullToEmpty(String.valueOf(row.get("company_id"))));

				list.add(bean);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<StockTransferBean> getRequisitionListCompanyBased(String CompanyId) {

		List<StockTransferBean> list = new ArrayList<>();
		try {
			List<Map<String, Object>> location = jdbcTemplate.queryForList(StockTransferQueryUtil.GET_REQUISITION_COMPANY_BASED, CompanyId);
			for (Map row : location) {
				StockTransferBean bean = new StockTransferBean();
				bean.setId(covertNullToEmpty(String.valueOf(row.get("purchase_requisition_id"))));
				bean.setText(covertNullToEmpty(String.valueOf(row.get("requisition_number"))));
				bean.setReqDate(covertNullToEmpty(String.valueOf(row.get("requisition_date"))));
				bean.setReqBy(covertNullToEmpty(String.valueOf(row.get("requested_by"))));
				bean.setSourceLoc(covertNullToInteger(String.valueOf(row.get("source_id"))));
				bean.setDestLoc(covertNullToInteger(String.valueOf(row.get("destination_id"))));
				bean.setSourceLocName(covertNullToEmpty(String.valueOf(row.get("source_name"))));
				bean.setDestLocName(covertNullToEmpty(String.valueOf(row.get("destination_name"))));
				bean.setCompanyId(covertNullToEmpty(String.valueOf(row.get("company_id"))));

				list.add(bean);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<StockTransferBean> getListPage() {

		List<StockTransferBean> list = new ArrayList<>();
		try {

			List<Map<String, Object>> location = jdbcTemplate.queryForList(StockTransferQueryUtil.LIST_DATA);
			for (Map row : location) {
				StockTransferBean bean = new StockTransferBean();
				bean.setSourceLocName(covertNullToEmpty(String.valueOf(row.get("source_name"))));
				bean.setDestLocName(covertNullToEmpty(String.valueOf(row.get("dest_name"))));
				bean.setStockId(covertNullToEmpty(String.valueOf(row.get("stock_transfer_number"))));
				bean.setStatus(covertNullToEmpty(String.valueOf(row.get("Status"))));
				bean.setDeliveryMethod(covertNullToEmpty(String.valueOf(row.get("delivery_method"))));
				bean.setTransportPort(covertNullToEmpty(String.valueOf(row.get("transport_type"))));
				bean.setId(String.valueOf(row.get("stock_transfer_id")));
				bean.setDescription(covertNullToEmpty(String.valueOf(row.get("item_desc"))));
				int StockId = (int) row.get("stock_transfer_id");

				int issueType = 0;
				issueType = covertNullToInteger(String.valueOf(row.get("issue_type")));
				if (issueType == 218) {
					String ReqNumber = jdbcTemplate.queryForObject(StockTransferQueryUtil.GET_REQUISITION_NUMBER_LIST, String.class, StockId);
					bean.setReqType(covertNullToEmpty(String.valueOf("Purchase Request")));
					bean.setRequisitionNumber(covertNullToEmpty(String.valueOf(ReqNumber)));
				} else {
					bean.setReqType(covertNullToEmpty(String.valueOf(row.get("reqType"))));
					bean.setRequisitionNumber(String.valueOf(row.get("requisition_number")));
				}
				String var = bean.getDescription().toString();
				if (var == null) {
					bean.setDescription("");
				}

				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	private int covertNullToInteger(String value) {
		int i = 0;
		try {
			if (value == null || value.equals("null")) {
				i = 0;
			} else {
				i = Integer.parseInt(value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private String covertNullToEmpty(String value) {

		try {
			if (value == null || value.equals("null")) {
				value = "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	private Double covertNullToDouble(String value) {
		Double i = 0.0;
		try {
			if (value == null || value.equals("null")) {
				i = 0.0;
			} else {
				i = Double.parseDouble(value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<StockTransferBean> getItemrequisition(String id) {
		List<StockTransferBean> list = new ArrayList<>();
		try {
			List<Map<String, Object>> location = jdbcTemplate.queryForList(StockTransferQueryUtil.GET_ITEM_CODE, new Object[] { Integer.parseInt(id), Integer.parseInt(id) });
			for (Map row : location) {
				StockTransferBean bean = new StockTransferBean();
				bean.setId(covertNullToEmpty(String.valueOf(row.get("item_id"))));
				bean.setText(covertNullToEmpty(String.valueOf(row.get("text"))));
				bean.setItemName(covertNullToEmpty(String.valueOf(row.get("item_name"))));
				bean.setItemDesc(covertNullToEmpty(String.valueOf(row.get("item_desc"))));
				bean.setQuantity(covertNullToDouble(String.valueOf(row.get("quantity"))));
				bean.setPrquantity(covertNullToDouble(String.valueOf(row.get("quantity"))));
				bean.setPendingQuantity(covertNullToDouble(String.valueOf(row.get("pending_quantity"))));
				bean.setOriginalQty((double) row.get("originalQty"));

				bean.setUom(covertNullToEmpty(String.valueOf(row.get("uom"))));
				bean.setReqDetailId(covertNullToInteger(String.valueOf(row.get("purchase_requisition_detail_id"))));
				bean.setBatchNoExist((boolean) row.get("isBatchNoExist"));
				bean.setRequisitionNo(covertNullToEmpty(String.valueOf(row.get("requisitionno"))));

				double GRNQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_GRN_QTY, Double.class, Integer.parseInt(bean.getId()));
				double MISSUEQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_MI_QTY, Double.class, Integer.parseInt(bean.getId()));
				double itemOpeningQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_OPENING_QTY, Double.class, Integer.parseInt(bean.getId()));

				// 13/02/21 gatepass item included
				int GatePassOut = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSOUT_QTY, Integer.class, Integer.parseInt(bean.getId()));
				int GatePassIn = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSIN_QTY, Integer.class, Integer.parseInt(bean.getId()));
				// end
				double availableQTY = 0;

				// availableQTY = (GRNQTY + itemOpeningQTY) - MISSUEQTY;
				availableQTY = (GRNQTY + itemOpeningQTY) - (MISSUEQTY + (GatePassOut - GatePassIn));

				if (availableQTY < 0)
					availableQTY = 0;
				bean.setAvailableQTY(availableQTY);

				double savedqty = jdbcTemplate.queryForObject(StockTransferQueryUtil.CHECK_QUANTITY, Double.class, bean.getReqDetailId());

				int PRdtlnum = jdbcTemplate.queryForObject(StockTransferQueryUtil.Check_ST, Integer.class, bean.getReqDetailId());
				double PendingQty = 0;
				if (PRdtlnum > 0) {
					PendingQty = jdbcTemplate.queryForObject(StockTransferQueryUtil.GET_PENDING_QTY, Double.class, bean.getReqDetailId());

				}

				if (savedqty != bean.getQuantity()) {
					if (PendingQty != 0) {
						bean.setPendingQuantity(PendingQty);
						list.add(bean);

					} else {
						PendingQty = bean.getQuantity();
						bean.setPendingQuantity(PendingQty);
						list.add(bean);
					}
				}

				// if (savedqty == 0) {
				// savedqty = "0";
				// }
				/*
				 * double qty = savedqty; double qty1 = bean.getQuantity();
				 * 
				 * if (qty1 != qty) { // int id1 = Integer.parseInt(id); // int PQqtyy = //
				 * jdbcTemplate.queryForObject(StockTransferQueryUtil .CHECK_QUANTITY_PQ, //
				 * Integer.class, Integer.parseInt(id), // Integer.parseInt(bean.getId())); //
				 * if (PQqtyy == null) { // PQqtyy = "0"; // } // double Pqty = PQqtyy; // if
				 * ((Pqty + qty) != bean.getQuantity()) { // if (qty == 0) //
				 * bean.setPendingQuantity
				 * (covertNullToDouble(String.valueOf(row.get("quantity")))); double PQqty =
				 * qty1 - qty; // bean.setPendingQuantity(PQqty); list.add(bean);
				 * 
				 * // } }
				 */

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<StockTransferBean> getItemrequisition1(String id) {
		List<StockTransferBean> list = new ArrayList<>();
		try {
			List<Map<String, Object>> location = jdbcTemplate.queryForList(StockTransferQueryUtil.GET_ITEM_CODE, new Object[] { Integer.parseInt(id), Integer.parseInt(id) });
			for (Map row : location) {
				StockTransferBean bean = new StockTransferBean();
				bean.setId(covertNullToEmpty(String.valueOf(row.get("item_id"))));
				bean.setText(covertNullToEmpty(String.valueOf(row.get("text"))));
				bean.setItemName(covertNullToEmpty(String.valueOf(row.get("item_name"))));
				bean.setItemDesc(covertNullToEmpty(String.valueOf(row.get("item_desc"))));
				bean.setQuantity(covertNullToDouble(String.valueOf(row.get("quantity"))));
				bean.setPrquantity(covertNullToDouble(String.valueOf(row.get("quantity"))));
				// bean.setPendingQuantity(covertNullToDouble(String.valueOf(row.get("pending_quantity"))));
				bean.setOriginalQty((double) row.get("originalQty"));
				bean.setUom(covertNullToEmpty(String.valueOf(row.get("uom"))));
				bean.setReqDetailId(covertNullToInteger(String.valueOf(row.get("purchase_requisition_detail_id"))));
				bean.setBatchNoExist((boolean) row.get("isBatchNoExist"));

				double savedqty = jdbcTemplate.queryForObject(StockTransferQueryUtil.CHECK_QUANTITY, Double.class, bean.getReqDetailId());
				int PRdtlnum = jdbcTemplate.queryForObject(StockTransferQueryUtil.Check_ST, Integer.class, bean.getReqDetailId());
				double PendingQty = 0;
				if (PRdtlnum > 0) {
					PendingQty = jdbcTemplate.queryForObject(StockTransferQueryUtil.GET_PENDING_QTY, Double.class, bean.getReqDetailId());

				}
				if (savedqty != bean.getQuantity()) {
					if (PendingQty != 0) {
						bean.setPendingQuantity(PendingQty);
						// list.add(bean);

					} else {
						PendingQty = bean.getQuantity();
						bean.setPendingQuantity(PendingQty);
						// list.add(bean);
					}
				}
				list.add(bean);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<StockTransferBean> getItemrequisitionKitchen(String id) {
		List<StockTransferBean> list = new ArrayList<>();
		try {
			List<Map<String, Object>> location = jdbcTemplate.queryForList(StockTransferQueryUtil.EDIT_DTL_KITCHEN, new Object[] { Integer.parseInt(id) });
			for (Map row : location) {
				StockTransferBean bean = new StockTransferBean();

				// StockTransferBean dtbean = new StockTransferBean();
				bean.setStockDtlId(covertNullToInteger(String.valueOf(row.get("stock_transfer_detail_id"))));
				bean.setItemCode(covertNullToEmpty(String.valueOf(row.get("item_id"))));
				bean.setId(covertNullToEmpty(String.valueOf(row.get("item_id"))));
				bean.setText(covertNullToEmpty(String.valueOf(row.get("item_name"))));
				bean.setPrquantity(covertNullToDouble(String.valueOf(row.get("prquantity"))));
				bean.setQuantity(covertNullToDouble(String.valueOf(row.get("quantity"))));
				bean.setOriginalQty((double) row.get("originalQty"));
				bean.setDisable(true);
				bean.setItemName(covertNullToEmpty(String.valueOf(row.get("item_name"))));
				bean.setItemDesc(covertNullToEmpty(String.valueOf(row.get("item_desc"))));
				// bean.setQuantity(covertNullToDouble(String.valueOf(row.get("quantity"))));
				// bean.setPrquantity(covertNullToDouble(String.valueOf(row.get("quantity"))));
				// bean.setPendingQuantity(covertNullToDouble(String.valueOf(row.get("pending_quantity"))));
				// bean.setOriginalQty((double) row.get("originalQty"));
				bean.setUom(covertNullToEmpty(String.valueOf(row.get("uom"))));
				bean.setReqDetailId(covertNullToInteger(String.valueOf(row.get("purchase_requisition_detail_id"))));
				bean.setRequestNumber(covertNullToEmpty(String.valueOf(row.get("requestNumber"))));

				double savedqty = jdbcTemplate.queryForObject(StockTransferQueryUtil.CHECK_QUANTITY, Double.class, bean.getReqDetailId());

				double qty = savedqty;
				double qty1 = bean.getQuantity();
				if (qty1 != qty) {

					double PQqty = qty1 - qty;
					bean.setPendingQuantity(PQqty);
				}

				list.add(bean);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private int covertNullToInteger(Integer queryForObject) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<StockTransferBean> getDefaultCode(String formCode, int id) {
		List<StockTransferBean> list = new ArrayList<>();
		try {
			List<Map<String, Object>> location = jdbcTemplate.queryForList(StockTransferQueryUtil.GET_DEFAULT_VALUE, new Object[] { id });
			for (Map row : location) {
				StockTransferBean bean = new StockTransferBean();
				bean.setId(covertNullToEmpty(String.valueOf(row.get("def_table_id"))));
				bean.setText(covertNullToEmpty(String.valueOf(row.get("value"))));
				list.add(bean);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void InsertStockHdr(StockTransferBean bean) {

		try {

			SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
			int status = 0;

			// Date stockdate = fromUser.parse(bean.getDate());

			if (covertNullToEmpty(bean.getStatus()).isEmpty()) {
				bean.setStatus("Pending");
			}
			// int dec = Integer.parseInt(bean.getDestLocName());
			// int src = Integer.parseInt(bean.getSourceLocName());
			jdbcTemplate.update(StockTransferQueryUtil.INSERT_STOCK_HDR, new Object[] { bean.getStockId(), CommonUtil.changeSqlDateFormate(bean.getDate()), bean.getRequisition(), bean.getTransportType(), bean.getServiceName(), bean.getPersonName(), bean.getDeliveryMet(), bean.getStatus(), bean.getSourceLoc(), bean.getDestLoc(), bean.getCompanyId(), bean.getIssueSlip(), bean.getIssueType() });

			int hdrid = jdbcTemplate.queryForObject(StockTransferQueryUtil.MAX_ID, new Object[] { bean.getStockId() }, Integer.class);

			ArrayList list = bean.getRowCollection();
			for (int i = 0; i < list.size(); i++) {
				StockTransferBean dtbean = (StockTransferBean) list.get(i);
				jdbcTemplate.update(StockTransferQueryUtil.INSERT_STOCK_DTL, new Object[] { hdrid, dtbean.getReqDetailId(), Integer.parseInt(dtbean.getItemCode()), dtbean.getQuantity(), dtbean.getPrquantity() - dtbean.getQuantity(), dtbean.getPrquantity() });

				double getitemcount = jdbcTemplate.queryForObject(StockTransferQueryUtil.ITEM_NEW_COUNT, Double.class, Integer.parseInt(dtbean.getItemCode()));
				if (getitemcount > 0) {
					double getcurrencyQty = jdbcTemplate.queryForObject(StockTransferQueryUtil.ITEM_CURRENT_QTY, Double.class, Integer.parseInt(dtbean.getItemCode()));
					double currentQty = getcurrencyQty - dtbean.getQuantity();
					double ITMcurrentQty = getcurrencyQty - dtbean.getQuantity();

					if (currentQty > 0) {
						int count1 = jdbcTemplate.update(ConsignmentRequestQueryUtil.UPDATE_CURRENT_QTY, new Object[] { currentQty, Integer.parseInt(dtbean.getItemCode()) });

					} else if (currentQty <= 0) {
						int count1 = jdbcTemplate.update(ConsignmentRequestQueryUtil.UPDATE_CURRENT_QTY, new Object[] { 0.0, Integer.parseInt(dtbean.getItemCode()) });

					}

				}

				String requisitionNumber = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MR_NUM, String.class, bean.getRequisition());

				int count = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_PO, Integer.class, requisitionNumber, Integer.parseInt(dtbean.getItemCode()));

				if (count == 0) {
					jdbcTemplate.update(StockTransferQueryUtil.UPDATE_PENDING_QTY_MR, new Object[] { dtbean.getPrquantity() - dtbean.getQuantity(), dtbean.getReqDetailId() });
				}

				// int savedqty =
				// jdbcTemplate.queryForObject(StockTransferQueryUtil.CHECK_QUANTITY,
				// Integer.class, dtbean.getReqDetailId());
				// jdbcTemplate.update(StockTransferQueryUtil.UPDATE_PENDING_QTY_MR,
				// new Object[] { dtbean.getPrquantity() - dtbean.getQuantity(),
				// dtbean.getReqDetailId() });

				// if (savedqty == dtbean.getOriginalQty() &&
				// RequisitionListSize == list.size()) {
				// if (status != 213) {
				// status = 214;
				// }
				// } else {
				// status = 213;
				//
				// }
				int stockTransferDetailId = jdbcTemplate.queryForObject(StockTransferQueryUtil.MAX_DETAIL_ID, new Object[] { hdrid }, Integer.class);
				if (stockTransferDetailId > 0) {
					ArrayList batchDtlsList = dtbean.getBatchDetails();
					if (batchDtlsList != null) {
						for (int j = 0; j < batchDtlsList.size(); j++) {
							GRNPurchaseOrderBean batchdtbean = (GRNPurchaseOrderBean) batchDtlsList.get(j);
							if (batchdtbean.getTransferQty() > 0) {
								// jdbcTemplate.update(StockTransferQueryUtil.INSERT_STOCK_BATCH_DTL,
								// new Object[] { stockTransferDetailId,
								// batchdtbean.getDtlItemId(),
								// batchdtbean.getLotNo(),
								// batchdtbean.getBatchQty(),
								// batchdtbean.getExpiryDate(),
								// batchdtbean.getManufactureDef(),
								// batchdtbean.getMrp(),
								// batchdtbean.getTransferQty(),
								// batchdtbean.getBatchQty() -
								// batchdtbean.getTransferQty(),
								// batchdtbean.getTransferQty() });
								jdbcTemplate.update(StockTransferQueryUtil.INSERT_STOCK_BATCH_DTL, new Object[] { stockTransferDetailId, batchdtbean.getDtlItemId(), batchdtbean.getLotNo(), batchdtbean.getBatchQty(), batchdtbean.getManufactureDef(), batchdtbean.getMrp(), batchdtbean.getTransferQty(), batchdtbean.getBatchQty() - batchdtbean.getTransferQty(), batchdtbean.getTransferQty() });

							}
						}
					}
				}

				if (bean.getStatus().equals("Approved")) {

					commonUtilityService.updateInventoryAndLedgerIn(bean.getStockId(), bean.getDate(), 106, bean.getSourceLoc(), bean.getDestLoc(), Integer.parseInt(dtbean.getItemCode()), (int) dtbean.getQuantity(), dtbean.getAttributeBeans());
					commonUtilityService.updateInventoryAndLedgerOut(bean.getStockId(), bean.getDate(), 106, bean.getDestLoc(), bean.getSourceLoc(), Integer.parseInt(dtbean.getItemCode()), (int) dtbean.getQuantity(), dtbean.getAttributeBeans());

				}
			}
			int RequisitionListQTY = jdbcTemplate.queryForObject(StockTransferQueryUtil.CHECK_REQUISITION_QTY, new Object[] { bean.getRequisition() }, Integer.class);
			int stockQTY = jdbcTemplate.queryForObject(StockTransferQueryUtil.CHECK_STOCK_QTY, new Object[] { bean.getRequisition() }, Integer.class);
			if (RequisitionListQTY == stockQTY) {
				status = 214;
				jdbcTemplate.update(StockTransferQueryUtil.issueStatus, new Object[] { status, bean.getRequisition() });
			} else if (RequisitionListQTY != stockQTY) {
				status = 213;
				jdbcTemplate.update(StockTransferQueryUtil.issueStatus, new Object[] { status, bean.getRequisition() });
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void InsertStockHdr1(StockTransferBean bean) {

		try {

			SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");

			// Date stockdate = fromUser.parse(bean.getDate());
			int requisition = bean.getRequisition();
			if (covertNullToEmpty(bean.getStatus()).isEmpty()) {
				bean.setStatus("Approved");
			}
			String stacknumber = jdbcTemplate.queryForObject(StockTransferQueryUtil.GET_STOCK_NUMBER, String.class);
			bean.setStockId(stacknumber);
			bean.setIssueType(219);
			jdbcTemplate.update(StockTransferQueryUtil.INSERT_STOCK_HDR_AUTO_ISSUE, new Object[] { bean.getStockId(), CommonUtil.changeSqlDateFormate(bean.getDate()), bean.getRequisition(), bean.getTransportType(), bean.getServiceName(), bean.getPersonName(), bean.getDeliveryMet(), bean.getStatus(), bean.getSourceLoc(), bean.getDestLoc(), bean.getCompanyId(), bean.getIssueSlip(), bean.getIssueType() });

			int hdrid = jdbcTemplate.queryForObject(StockTransferQueryUtil.MAX_ID, new Object[] { bean.getStockId() }, Integer.class);

			ArrayList list = bean.getRowCollection();
			for (int i = 0; i < list.size(); i++) {
				StockTransferBean dtbean = (StockTransferBean) list.get(i);
				jdbcTemplate.update(StockTransferQueryUtil.INSERT_STOCK_DTL, new Object[] { hdrid, dtbean.getReqDetailId(), Integer.parseInt(dtbean.getItemCode()), dtbean.getQuantity(), dtbean.getQuantity(), dtbean.getPrquantity() });
				double getitemcount = jdbcTemplate.queryForObject(StockTransferQueryUtil.ITEM_NEW_COUNT, Double.class, Integer.parseInt(dtbean.getItemCode()));
				if (getitemcount > 0) {
					double getcurrencyQty = jdbcTemplate.queryForObject(StockTransferQueryUtil.ITEM_CURRENT_QTY, Double.class, Integer.parseInt(dtbean.getItemCode()));
					double currentQty = getcurrencyQty - dtbean.getQuantity();
					double ITMcurrentQty = getcurrencyQty - dtbean.getQuantity();

					if (currentQty > 0) {
						int count1 = jdbcTemplate.update(ConsignmentRequestQueryUtil.UPDATE_CURRENT_QTY, new Object[] { currentQty, Integer.parseInt(dtbean.getItemCode()) });

					} else if (currentQty <= 0) {
						int count1 = jdbcTemplate.update(ConsignmentRequestQueryUtil.UPDATE_CURRENT_QTY, new Object[] { 0.0, Integer.parseInt(dtbean.getItemCode()) });

					}

				}

				int stockTransferDetailId = jdbcTemplate.queryForObject(StockTransferQueryUtil.MAX_DETAIL_ID, new Object[] { hdrid }, Integer.class);
				if (stockTransferDetailId > 0) {
					ArrayList batchDtlsList = dtbean.getBatchDetails();
					if (batchDtlsList != null) {
						for (int j = 0; j < batchDtlsList.size(); j++) {
							GRNPurchaseOrderBean batchdtbean = (GRNPurchaseOrderBean) batchDtlsList.get(j);
							if (batchdtbean.getBatchQty() > 0) {
								jdbcTemplate.update(StockTransferQueryUtil.INSERT_STOCK_BATCH_DTL, new Object[] { stockTransferDetailId, batchdtbean.getItemId(), batchdtbean.getLotNo(), batchdtbean.getBatchQty(), batchdtbean.getExpiryDate(), batchdtbean.getManufactureDef(), batchdtbean.getMrp(), batchdtbean.getBatchQty(), batchdtbean.getBatchQty() - batchdtbean.getBatchQty(), batchdtbean.getBatchQty() });
							}
						}
					}
				}

				if (bean.getStatus().equals("Approved")) {

					commonUtilityService.updateInventoryAndLedgerIn(bean.getStockId(), bean.getDate(), 106, bean.getSourceLoc(), bean.getDestLoc(), Integer.parseInt(dtbean.getItemCode()), (int) dtbean.getQuantity(), dtbean.getAttributeBeans());
					commonUtilityService.updateInventoryAndLedgerOut(bean.getStockId(), bean.getDate(), 106, bean.getDestLoc(), bean.getSourceLoc(), Integer.parseInt(dtbean.getItemCode()), (int) dtbean.getQuantity(), dtbean.getAttributeBeans());

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStockHdr(StockTransferBean bean) {

		try {

			SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");

			Date stockdate = fromUser.parse(bean.getDate());
			StringBuffer sb = new StringBuffer();

			jdbcTemplate.update(StockTransferQueryUtil.UPDATE_STOCK_HDR, new Object[] { CommonUtil.changeSqlDateFormate(bean.getDate()), bean.getRequisition(), bean.getTransportType(), bean.getServiceName(), bean.getPersonName(), bean.getDeliveryMet(), bean.getStatus(), bean.getCompanyId(), bean.getIssueSlip(), bean.getIssueType(), covertNullToInteger(bean.getId()) });

			int hdrid = covertNullToInteger(bean.getId());

			ArrayList<StockTransferBean> list = bean.getRowCollection();
			ArrayList<StockTransferBean> deletedIds = bean.getLdeltedIds();
			if (deletedIds != null) {
				if (deletedIds.size() > 0) {
					for (int j = 0; j < deletedIds.size(); j++) {
						StockTransferBean deltedIdbean = deletedIds.get(j);
						if (deltedIdbean.getStockDtlId() > 0) {
							jdbcTemplate.update(StockTransferQueryUtil.DELETE_STOCK_BATCH, new Object[] { deltedIdbean.getStockDtlId() });
							jdbcTemplate.update(StockTransferQueryUtil.DELETE_DETAIL_ID, new Object[] { deltedIdbean.getStockDtlId() });
						}

					}
				}
			}

			for (int i = 0; i < list.size(); i++) {
				StockTransferBean dtbean = list.get(i);

				if (dtbean.getStockDtlId() == 0) {
					jdbcTemplate.update(StockTransferQueryUtil.INSERT_STOCK_DTL, new Object[] { hdrid, dtbean.getReqDetailId(), Integer.parseInt(dtbean.getItemCode()), dtbean.getQuantity(), dtbean.getQuantity() });
					double getitemcount = jdbcTemplate.queryForObject(StockTransferQueryUtil.ITEM_NEW_COUNT, Double.class, Integer.parseInt(dtbean.getItemCode()));
					if (getitemcount > 0) {
						double getcurrencyQty = jdbcTemplate.queryForObject(StockTransferQueryUtil.ITEM_CURRENT_QTY, Double.class, Integer.parseInt(dtbean.getItemCode()));
						double currentQty = getcurrencyQty - dtbean.getQuantity();
						double ITMcurrentQty = getcurrencyQty - dtbean.getQuantity();

						if (currentQty > 0) {
							int count1 = jdbcTemplate.update(ConsignmentRequestQueryUtil.UPDATE_CURRENT_QTY, new Object[] { currentQty, Integer.parseInt(dtbean.getItemCode()) });

						} else if (currentQty <= 0) {
							int count1 = jdbcTemplate.update(ConsignmentRequestQueryUtil.UPDATE_CURRENT_QTY, new Object[] { 0.0, Integer.parseInt(dtbean.getItemCode()) });

						}

					}

					int dtlid = jdbcTemplate.queryForObject(StockTransferQueryUtil.MAX_Detail_ID, new Object[] { hdrid, Integer.parseInt(dtbean.getItemCode()) }, Integer.class);
					sb.append(dtlid);
					sb.append(",");
					if (bean.getStatus().equals("Approved")) {
						commonUtilityService.updateInventoryAndLedgerIn(bean.getStockId(), bean.getDate(), 106, bean.getSourceLoc(), bean.getDestLoc(), Integer.parseInt(dtbean.getItemCode()), (int) dtbean.getQuantity(), dtbean.getAttributeBeans());
						commonUtilityService.updateInventoryAndLedgerOut(bean.getStockId(), bean.getDate(), 106, bean.getDestLoc(), bean.getSourceLoc(), Integer.parseInt(dtbean.getItemCode()), (int) dtbean.getQuantity(), dtbean.getAttributeBeans());

					}
				} else if (dtbean.getStockDtlId() > 0) {
					jdbcTemplate.update(StockTransferQueryUtil.UPDATE_STOCK_DTL, new Object[] { dtbean.getReqDetailId(), Integer.parseInt(dtbean.getItemCode()), dtbean.getQuantity(), hdrid, dtbean.getStockDtlId() });

					jdbcTemplate.update(StockTransferQueryUtil.DELETE_STOCK_BATCH, new Object[] { dtbean.getStockDtlId() });
					ArrayList batchDtlsList = dtbean.getBatchDetails();
					if (batchDtlsList != null) {
						for (int j = 0; j < batchDtlsList.size(); j++) {
							GRNPurchaseOrderBean batchdtbean = (GRNPurchaseOrderBean) batchDtlsList.get(j);
							if (batchdtbean.getTransferQty() > 0) {
								jdbcTemplate.update(StockTransferQueryUtil.INSERT_STOCK_BATCH_DTL, new Object[] { dtbean.getStockDtlId(), batchdtbean.getDtlItemId(), batchdtbean.getLotNo(), batchdtbean.getBatchQty(), batchdtbean.getExpiryDate(), batchdtbean.getManufactureDef(), batchdtbean.getMrp(), batchdtbean.getTransferQty(), batchdtbean.getBatchQty() - batchdtbean.getTransferQty(), batchdtbean.getTransferQty() });
							}
						}
					}

					sb.append(dtbean.getStockDtlId());
					sb.append(",");

					if (bean.getStatus().equals("Approved")) {
						commonUtilityService.updateInventoryAndLedgerIn(bean.getStockId(), bean.getDate(), 106, bean.getSourceLoc(), bean.getDestLoc(), Integer.parseInt(dtbean.getItemCode()), (int) dtbean.getQuantity(), dtbean.getAttributeBeans());
						commonUtilityService.updateInventoryAndLedgerOut(bean.getStockId(), bean.getDate(), 106, bean.getDestLoc(), bean.getSourceLoc(), Integer.parseInt(dtbean.getItemCode()), (int) dtbean.getQuantity(), dtbean.getAttributeBeans());
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<StockTransferBean> getEditData(int id) {
		List<StockTransferBean> list = new ArrayList<>();
		try {
			int IssueType = jdbcTemplate.queryForObject(StockTransferQueryUtil.getIssueType, Integer.class, id);
			if (IssueType == 218) {

				List<Map<String, Object>> edithdr = jdbcTemplate.queryForList(StockTransferQueryUtil.EDIT_HDR_KITCHEN, new Object[] { id });
				StockTransferBean bean = new StockTransferBean();
				for (Map row : edithdr) {

					bean.setId(covertNullToEmpty(String.valueOf(row.get("stock_transfer_id"))));
					bean.setDate(covertNullToEmpty(String.valueOf(row.get("stock_transfer_date"))));
					bean.setRequisition(covertNullToInteger(String.valueOf(row.get("purchase_requisition_id"))));
					bean.setStockId(covertNullToEmpty(String.valueOf(row.get("stock_transfer_number"))));
					bean.setTransportType(covertNullToInteger(String.valueOf(row.get("transport_type"))));
					bean.setDeliveryMet(covertNullToInteger(String.valueOf(row.get("delivery_method"))));
					bean.setStatus(covertNullToEmpty(String.valueOf(row.get("status"))));
					bean.setServiceName(covertNullToEmpty(String.valueOf(row.get("service_name"))));
					bean.setPersonName(covertNullToEmpty(String.valueOf(row.get("person_name"))));
					bean.setCompanyId(covertNullToEmpty(String.valueOf(row.get("companyId"))));
					bean.setCompanyName(covertNullToEmpty(String.valueOf(row.get("companyName"))));
					bean.setIssueSlip(covertNullToEmpty(String.valueOf(row.get("issue_slip"))));
					bean.setIssueType(Integer.parseInt((String) row.get("issue_type")));
					bean.setIssueTypeName(covertNullToEmpty(String.valueOf(row.get("issue_type_name"))));
					bean.setSourceLocName(covertNullToEmpty(String.valueOf(row.get("sourceLocName"))));
					bean.setDestLocName(covertNullToEmpty(String.valueOf(row.get("destLocName"))));
					List<StockTransferBean> itemlist = new ArrayList<>();
					// itemlist =
					// getItemrequiss
				}
				List<Map<String, Object>> editdtl = jdbcTemplate.queryForList(StockTransferQueryUtil.EDIT_DTL_KITCHEN, new Object[] { id });
				ArrayList<StockTransferBean> list1 = new ArrayList<>();
				for (Map row : editdtl) {

					StockTransferBean dtbean = new StockTransferBean();
					dtbean.setStockDtlId(covertNullToInteger(String.valueOf(row.get("stock_transfer_detail_id"))));
					dtbean.setItemCode(covertNullToEmpty(String.valueOf(row.get("item_id"))));
					dtbean.setId(covertNullToEmpty(String.valueOf(row.get("item_id"))));
					dtbean.setText(covertNullToEmpty(String.valueOf(row.get("item_name"))));

					dtbean.setPrquantity(covertNullToDouble(String.valueOf(row.get("prquantity"))));
					dtbean.setQuantity(covertNullToDouble(String.valueOf(row.get("quantity"))));
					dtbean.setOriginalQty((double) row.get("originalQty"));

					dtbean.setItemName(covertNullToEmpty(String.valueOf(row.get("item_name"))));
					dtbean.setItemDesc(covertNullToEmpty(String.valueOf(row.get("item_desc"))));
					dtbean.setPendingQuantity(covertNullToDouble(String.valueOf(row.get("pending_quantity"))));
					dtbean.setOriginalQty((double) row.get("originalQty"));
					dtbean.setUom(covertNullToEmpty(String.valueOf(row.get("uom"))));
					dtbean.setReqDetailId(covertNullToInteger(String.valueOf(row.get("purchase_requisition_detail_id"))));
					dtbean.setRequestNumber(covertNullToEmpty(String.valueOf(row.get("requestNumber"))));

					dtbean.setDisable(true);
					List<GRNPurchaseOrderBean> batchDtlsList = jdbcTemplate.query(StockTransferQueryUtil.GET_STOCK_TRANSFER_BATCH_DTLS, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class), new Object[] { dtbean.getStockDtlId() });
					dtbean.setStockTransferBatchList(batchDtlsList);
					list1.add(dtbean);

				}

				bean.setRowCollection(list1);
				list.add(bean);
			} else {
				List<Map<String, Object>> edithdr = jdbcTemplate.queryForList(StockTransferQueryUtil.EDIT_HDR, new Object[] { id });
				StockTransferBean bean = new StockTransferBean();
				for (Map row : edithdr) {

					bean.setId(covertNullToEmpty(String.valueOf(row.get("stock_transfer_id"))));
					bean.setDate(covertNullToEmpty(String.valueOf(row.get("stock_transfer_date"))));
					bean.setRequisition(covertNullToInteger(String.valueOf(row.get("purchase_requisition_id"))));
					bean.setStockId(covertNullToEmpty(String.valueOf(row.get("stock_transfer_number"))));
					bean.setTransportType(covertNullToInteger(String.valueOf(row.get("transport_type"))));
					bean.setDeliveryMet(covertNullToInteger(String.valueOf(row.get("delivery_method"))));
					bean.setStatus(covertNullToEmpty(String.valueOf(row.get("status"))));
					bean.setServiceName(covertNullToEmpty(String.valueOf(row.get("service_name"))));
					bean.setPersonName(covertNullToEmpty(String.valueOf(row.get("person_name"))));
					bean.setCompanyId(covertNullToEmpty(String.valueOf(row.get("companyId"))));
					bean.setCompanyName(covertNullToEmpty(String.valueOf(row.get("companyName"))));
					bean.setIssueSlip(covertNullToEmpty(String.valueOf(row.get("issue_slip"))));
					bean.setIssueType(Integer.parseInt((String) row.get("issue_type")));
					bean.setIssueTypeName(covertNullToEmpty(String.valueOf(row.get("issue_type_name"))));
					List<StockTransferBean> itemlist = new ArrayList<>();
					itemlist = getItemrequisition1(covertNullToEmpty(String.valueOf(row.get("purchase_requisition_id"))));
					bean.setItemlist(itemlist);

				}
				List<Map<String, Object>> editdtl = jdbcTemplate.queryForList(StockTransferQueryUtil.EDIT_DTL, new Object[] { id });
				ArrayList<StockTransferBean> list1 = new ArrayList<>();
				for (Map row : editdtl) {

					StockTransferBean dtbean = new StockTransferBean();
					dtbean.setStockDtlId(covertNullToInteger(String.valueOf(row.get("stock_transfer_detail_id"))));
					dtbean.setItemCode(covertNullToEmpty(String.valueOf(row.get("item_id"))));
					dtbean.setPrquantity(covertNullToDouble(String.valueOf(row.get("prquantity"))));
					dtbean.setQuantity(covertNullToDouble(String.valueOf(row.get("quantity"))));
					dtbean.setOriginalQty((double) row.get("originalQty"));
					dtbean.setDisable(true);
					List<GRNPurchaseOrderBean> batchDtlsList = jdbcTemplate.query(StockTransferQueryUtil.GET_STOCK_TRANSFER_BATCH_DTLS, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class), new Object[] { dtbean.getStockDtlId() });
					dtbean.setStockTransferBatchList(batchDtlsList);
					list1.add(dtbean);

				}

				bean.setRowCollection(list1);
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void deleteStock(int id) {

		List<Map<String, Object>> source = jdbcTemplate.queryForList(StockTransferQueryUtil.GET_SOURCE_LEGE, new Object[] { id });

		for (Map row : source) {
			jdbcTemplate.update(StockTransferQueryUtil.DELETE_INVOTORY_DATA, new Object[] { covertNullToInteger(String.valueOf(row.get("source_qty"))), covertNullToInteger(String.valueOf(row.get("source_location"))), covertNullToInteger(String.valueOf(row.get("Inventory_id"))) });
		}

		List<Map<String, Object>> dest = jdbcTemplate.queryForList(StockTransferQueryUtil.GET_DEST_LEGE, new Object[] { id });

		for (Map row : dest) {
			jdbcTemplate.update(StockTransferQueryUtil.DELETE_INVOTORY_DATA, new Object[] { covertNullToInteger(String.valueOf(row.get("destination_qty"))), covertNullToInteger(String.valueOf(row.get("destination_location"))), covertNullToInteger(String.valueOf(row.get("Inventory_id"))) });
		}

		jdbcTemplate.update(StockTransferQueryUtil.DELETE_LEDGE, new Object[] { id });

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.sGetTransferDetailId, new Object[] { id });

		for (Map row : rows) {
			jdbcTemplate.update(CommonUtilityQueryUtil.DELETE_STOCK_BATCH_DETAIL, new Object[] { (int) row.get("stock_transfer_detail_id") });
		}

		jdbcTemplate.update(StockTransferQueryUtil.DELETE_DTL, new Object[] { id });
		jdbcTemplate.update(StockTransferQueryUtil.DELETE_HDR, new Object[] { id });
	}

	@Override
	public List<GRNPurchaseOrderBean> getBatchNoDetails(int itemId, int sourceLoc) {
		List<GRNPurchaseOrderBean> list = new ArrayList<>();
		List<GRNPurchaseOrderBean> mainList = new ArrayList<>();
		List<GRNPurchaseOrderBean> Qclist = new ArrayList<>();
		try {
			list = jdbcTemplate.query(StockTransferQueryUtil.GET_BATCH_DETAILS, new Object[] { itemId, itemId }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));
			Qclist = jdbcTemplate.query(StockTransferQueryUtil.GET_QC_BATCH_DETAILS, new Object[] { itemId, sourceLoc }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));

			for (GRNPurchaseOrderBean bean : list) {
				String batchNo = bean.getLotNo();
				batchNo = batchNo.trim();
				int QcQuantiy = 0;
				for (GRNPurchaseOrderBean batchbean : Qclist) {
					String QcbatchNo = batchbean.getLotNo();
					if (QcbatchNo.equalsIgnoreCase(batchNo)) {
						QcQuantiy = batchbean.getBatchQty();
					}
				}
				int totalQty = 0;
				totalQty = bean.getBatchQty() - QcQuantiy;
				bean.setBatchQty(totalQty);
			}

			for (GRNPurchaseOrderBean finalbean : list) {
				if (finalbean.getBatchQty() > 0) {
					mainList.add(finalbean);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mainList;
	}

	@Override
	public StockTransferBean getGeneralInvoiceForView(int invoiceNo) {

		StockTransferBean objGeneralInvoiceBean = new StockTransferBean();
		List<StockTransferBean> objList = new ArrayList<>();

		try {
			objGeneralInvoiceBean = jdbcTemplate.queryForObject(StockTransferQueryUtil.Print, new Object[] { invoiceNo }, new BeanPropertyRowMapper<>(StockTransferBean.class));
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(StockTransferQueryUtil.PrintDTL, new Object[] { invoiceNo });
			for (Map row : rows) {
				StockTransferBean objPurchaseInvoiceJobDetailBean = new StockTransferBean();

				objPurchaseInvoiceJobDetailBean.setItemCode(CommonUtil.convertNullToEmpty(row.get("itemCode").toString()));
				// objPurchaseInvoiceJobDetailBean.setItemDesc(CommonUtil.convertNullToEmpty(row.get("item_desc").toString()));
				objPurchaseInvoiceJobDetailBean.setPrquantity(Double.parseDouble(row.get("prquantityn").toString()));
				objPurchaseInvoiceJobDetailBean.setQuantityn(Double.parseDouble(row.get("quantityn").toString()));
				objPurchaseInvoiceJobDetailBean.setAmount(Double.parseDouble(row.get("amount").toString()));
				objPurchaseInvoiceJobDetailBean.setOriginalQty(Double.parseDouble(row.get("originalQty").toString()));

				objList.add(objPurchaseInvoiceJobDetailBean);

			}
			objGeneralInvoiceBean.setItemlist(objList);

		} catch (Exception e) {
			// LOGGER.error("Error in List", e);
			e.printStackTrace();
		}
		return objGeneralInvoiceBean;

	}

	@Override
	public StockTransferBean getRequisition(String requestNumber) {
		StockTransferBean StockTransferBean = new StockTransferBean();
		List<StockTransferBean> list = new ArrayList<>();
		try {
			List<Map<String, Object>> location = jdbcTemplate.queryForList(StockTransferQueryUtil.GET_REQUISITION_FOR_EXCEL_IMPORT, requestNumber);
			for (Map row : location) {
				StockTransferBean bean = new StockTransferBean();
				bean.setId(covertNullToEmpty(String.valueOf(row.get("purchase_requisition_id"))));
				bean.setRequisition(Integer.parseInt(bean.getId()));

				bean.setText(covertNullToEmpty(String.valueOf(row.get("requisition_number"))));
				bean.setReqDate(covertNullToEmpty(String.valueOf(row.get("requisition_date"))));
				bean.setReqBy(covertNullToEmpty(String.valueOf(row.get("requested_by"))));
				bean.setSourceLoc(covertNullToInteger(String.valueOf(row.get("source_id"))));
				bean.setDestLoc(covertNullToInteger(String.valueOf(row.get("destination_id"))));
				bean.setSourceLocName(covertNullToEmpty(String.valueOf(row.get("source_name"))));
				bean.setDestLocName(covertNullToEmpty(String.valueOf(row.get("destination_name"))));
				bean.setCompanyId(covertNullToEmpty(String.valueOf(row.get("company_id"))));

				list.add(bean);
				StockTransferBean = bean;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return StockTransferBean;

	}

	@Override
	public StockTransferBean getItemrequisition(String id, String itemCode) {
		StockTransferBean stockbean = new StockTransferBean();
		List<StockTransferBean> list = new ArrayList<>();
		try {
			int PRId = jdbcTemplate.queryForObject(StockTransferQueryUtil.getPRNUmber, Integer.class, id);
			List<Map<String, Object>> location = jdbcTemplate.queryForList(StockTransferQueryUtil.GET_ITEM_CODE_FOR_EXCEL_IMPORT, new Object[] { PRId, itemCode });
			for (Map row : location) {
				StockTransferBean bean = new StockTransferBean();
				bean.setId(covertNullToEmpty(String.valueOf(row.get("item_id"))));
				bean.setText(covertNullToEmpty(String.valueOf(row.get("text"))));
				bean.setItemName(covertNullToEmpty(String.valueOf(row.get("item_name"))));
				bean.setItemDesc(covertNullToEmpty(String.valueOf(row.get("item_desc"))));
				bean.setQuantity(covertNullToDouble(String.valueOf(row.get("quantity"))));
				bean.setPrquantity(covertNullToDouble(String.valueOf(row.get("quantity"))));
				bean.setPendingQuantity(covertNullToDouble(String.valueOf(row.get("pending_quantity"))));
				bean.setOriginalQty((double) row.get("originalQty"));
				bean.setUom(covertNullToEmpty(String.valueOf(row.get("uom"))));
				bean.setReqDetailId(covertNullToInteger(String.valueOf(row.get("purchase_requisition_detail_id"))));
				bean.setBatchNoExist((boolean) row.get("isBatchNoExist"));

				double GRNQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_GRN_QTY, Double.class, Integer.parseInt(bean.getId()));
				double MISSUEQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_MI_QTY, Double.class, Integer.parseInt(bean.getId()));
				double itemOpeningQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_OPENING_QTY, Double.class, Integer.parseInt(bean.getId()));

				// 13/02/21 gatepass item included
				int GatePassOut = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSOUT_QTY, Integer.class, Integer.parseInt(bean.getId()));
				int GatePassIn = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSIN_QTY, Integer.class, Integer.parseInt(bean.getId()));
				// end
				double availableQTY = 0;
				/*
				 * if (GRNQTY == 0.0 && MISSUEQTY == 0.0) { availableQTY = (GRNQTY - MISSUEQTY)
				 * + itemOpeningQTY; bean.setAvailableQTY(availableQTY); } else
				 */
				// if (GRNQTY > MISSUEQTY) {

				// availableQTY = (GRNQTY + itemOpeningQTY) - MISSUEQTY;

				availableQTY = (GRNQTY + itemOpeningQTY) - (MISSUEQTY + (GatePassOut - GatePassIn));

				// bean.setAvailableQTY(availableQTY);
				// } else if (GRNQTY < MISSUEQTY || GRNQTY == MISSUEQTY) {
				// availableQTY = 0;
				if (availableQTY < 0)
					availableQTY = 0;
				bean.setAvailableQTY(availableQTY);

				// }
				double savedqty = jdbcTemplate.queryForObject(StockTransferQueryUtil.CHECK_QUANTITY, Double.class, bean.getReqDetailId());
				// if (savedqty == 0) {
				// savedqty = "0";
				// }
				double qty = savedqty;
				double qty1 = bean.getQuantity();

				// if (qty1 != qty) {
				//
				// double PQqty = qty1 - qty;
				// bean.setPendingQuantity(PQqty);
				// list.add(bean);
				stockbean = bean;

				// }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockbean;
	}

	/*
	 * public StockTransferBean getItemrequisition(String id, String itemCode) {
	 * StockTransferBean bean1 = new StockTransferBean(); List<StockTransferBean>
	 * list = new ArrayList<StockTransferBean>(); try { int PRId =
	 * jdbcTemplate.queryForObject(StockTransferQueryUtil.getPRNUmber,
	 * Integer.class, id); List<Map<String, Object>> location =
	 * jdbcTemplate.queryForList
	 * (StockTransferQueryUtil.GET_ITEM_CODE_FOR_EXCEL_IMPORT, new Object[] { PRId,
	 * itemCode }); for (Map row : location) { StockTransferBean bean = new
	 * StockTransferBean();
	 * bean.setId(covertNullToEmpty(String.valueOf(row.get("item_id"))));
	 * bean.setText(covertNullToEmpty(String.valueOf(row.get("text"))));
	 * bean.setItemName (covertNullToEmpty(String.valueOf(row.get("item_name"))));
	 * bean.setItemDesc (covertNullToEmpty(String.valueOf(row.get("item_desc"))));
	 * bean.setQuantity (covertNullToDouble(String.valueOf(row.get("quantity"))));
	 * bean.setPrquantity (covertNullToDouble(String.valueOf(row.get("quantity"))));
	 * bean.setPendingQuantity
	 * (covertNullToDouble(String.valueOf(row.get("pending_quantity"))));
	 * bean.setOriginalQty((double) row.get("originalQty"));
	 * bean.setUom(covertNullToEmpty(String.valueOf(row.get("uom"))));
	 * bean.setReqDetailId
	 * (covertNullToInteger(String.valueOf(row.get("purchase_requisition_detail_id"
	 * )))); bean.setBatchNoExist((boolean) row.get("isBatchNoExist"));
	 * 
	 * String savedqty =
	 * jdbcTemplate.queryForObject(StockTransferQueryUtil.CHECK_QUANTITY,
	 * String.class, bean.getReqDetailId()); if (savedqty == null) { savedqty = "0";
	 * } double qty = Double.parseDouble(savedqty); if (bean.getQuantity() != qty) {
	 * list.add(bean1); bean1 = bean;
	 * 
	 * } } } catch (Exception e) { e.printStackTrace(); } return bean1; }
	 */

	@Override
	public boolean InsertStockHdrImport(List<StockTransferBean> Allbean) {
		boolean isSuccess = false;
		for (StockTransferBean bean : Allbean) {
			try {

				SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
				int status = 0;

				// Date stockdate = fromUser.parse(bean.getDate());

				if (covertNullToEmpty(bean.getStatus()).isEmpty()) {
					bean.setStatus("Pending");
				}
				// int dec = Integer.parseInt(bean.getDestLocName());
				// int src = Integer.parseInt(bean.getSourceLocName());
				String stacknumber = jdbcTemplate.queryForObject(StockTransferQueryUtil.GET_STOCK_NUMBER, String.class);
				bean.setStockId(stacknumber);
				bean.setStatus("Approved");
				jdbcTemplate.update(StockTransferQueryUtil.INSERT_STOCK_HDR, new Object[] { bean.getStockId(), CommonUtil.changeSqlDateFormate(bean.getDate()), bean.getRequisition(), bean.getTransportType(), bean.getServiceName(), bean.getPersonName(), bean.getDeliveryMet(), bean.getStatus(), bean.getSourceLoc(), bean.getDestLoc(), bean.getCompanyId(), bean.getIssueSlip(), bean.getIssueType() });

				int hdrid = jdbcTemplate.queryForObject(StockTransferQueryUtil.MAX_ID, new Object[] { bean.getStockId() }, Integer.class);

				ArrayList list = bean.getRowCollection();
				for (int i = 0; i < list.size(); i++) {
					StockTransferBean dtbean = (StockTransferBean) list.get(i);
					jdbcTemplate.update(StockTransferQueryUtil.INSERT_STOCK_DTL, new Object[] { hdrid, dtbean.getReqDetailId(), Integer.parseInt(dtbean.getItemCode()), dtbean.getQuantity(), dtbean.getPrquantity() - dtbean.getQuantity(), dtbean.getPrquantity() });
					double getitemcount = jdbcTemplate.queryForObject(StockTransferQueryUtil.ITEM_NEW_COUNT, Double.class, Integer.parseInt(dtbean.getItemCode()));
					if (getitemcount > 0) {
						double getcurrencyQty = jdbcTemplate.queryForObject(StockTransferQueryUtil.ITEM_CURRENT_QTY, Double.class, Integer.parseInt(dtbean.getItemCode()));
						double currentQty = getcurrencyQty - dtbean.getQuantity();
						double ITMcurrentQty = getcurrencyQty - dtbean.getQuantity();

						if (currentQty > 0) {
							int count1 = jdbcTemplate.update(ConsignmentRequestQueryUtil.UPDATE_CURRENT_QTY, new Object[] { currentQty, Integer.parseInt(dtbean.getItemCode()) });

						} else if (currentQty <= 0) {
							int count1 = jdbcTemplate.update(ConsignmentRequestQueryUtil.UPDATE_CURRENT_QTY, new Object[] { 0.0, Integer.parseInt(dtbean.getItemCode()) });

						}

					}
					String requisitionNumber = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MR_NUM, String.class, bean.getRequisition());

					int count = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_PO, Integer.class, requisitionNumber, Integer.parseInt(dtbean.getItemCode()));

					if (count == 0) {
						jdbcTemplate.update(StockTransferQueryUtil.UPDATE_PENDING_QTY_MR, new Object[] { dtbean.getPrquantity() - dtbean.getQuantity(), dtbean.getReqDetailId() });
					}
					int savedqty = jdbcTemplate.queryForObject(StockTransferQueryUtil.CHECK_QUANTITY, Integer.class, dtbean.getReqDetailId());
					// jdbcTemplate.update(StockTransferQueryUtil.UPDATE_PENDING_QTY_MR,
					// new Object[] { dtbean.getPrquantity() -
					// dtbean.getQuantity(), dtbean.getReqDetailId() });

					if (savedqty == dtbean.getOriginalQty()) {
						if (status != 213) {
							status = 214;
						}
					} else {
						status = 213;

					}
					int stockTransferDetailId = jdbcTemplate.queryForObject(StockTransferQueryUtil.MAX_DETAIL_ID, new Object[] { hdrid }, Integer.class);
					if (stockTransferDetailId > 0) {
						ArrayList batchDtlsList = dtbean.getBatchDetails();
						if (batchDtlsList != null) {
							for (int j = 0; j < batchDtlsList.size(); j++) {
								GRNPurchaseOrderBean batchdtbean = (GRNPurchaseOrderBean) batchDtlsList.get(j);
								if (batchdtbean.getTransferQty() > 0) {
									// jdbcTemplate.update(StockTransferQueryUtil.INSERT_STOCK_BATCH_DTL,
									// new Object[] { stockTransferDetailId,
									// batchdtbean.getDtlItemId(),
									// batchdtbean.getLotNo(),
									// batchdtbean.getBatchQty(),
									// batchdtbean.getExpiryDate(),
									// batchdtbean.getManufactureDef(),
									// batchdtbean.getMrp(),
									// batchdtbean.getTransferQty(),
									// batchdtbean.getBatchQty() -
									// batchdtbean.getTransferQty(),
									// batchdtbean.getTransferQty() });
									jdbcTemplate.update(StockTransferQueryUtil.INSERT_STOCK_BATCH_DTL, new Object[] { stockTransferDetailId, batchdtbean.getDtlItemId(), batchdtbean.getLotNo(), batchdtbean.getBatchQty(), batchdtbean.getManufactureDef(), batchdtbean.getMrp(), batchdtbean.getTransferQty(), batchdtbean.getBatchQty() - batchdtbean.getTransferQty(), batchdtbean.getTransferQty() });

								}
							}
						}
					}

					if (bean.getStatus().equals("Approved")) {

						commonUtilityService.updateInventoryAndLedgerIn(bean.getStockId(), bean.getDate(), 106, bean.getSourceLoc(), bean.getDestLoc(), Integer.parseInt(dtbean.getItemCode()), (int) dtbean.getQuantity(), dtbean.getAttributeBeans());
						commonUtilityService.updateInventoryAndLedgerOut(bean.getStockId(), bean.getDate(), 106, bean.getDestLoc(), bean.getSourceLoc(), Integer.parseInt(dtbean.getItemCode()), (int) dtbean.getQuantity(), dtbean.getAttributeBeans());

					}
				}
				jdbcTemplate.update(StockTransferQueryUtil.issueStatus, new Object[] { status, bean.getRequisition() });
				isSuccess = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return isSuccess;
	}

	@Override
	public List<StockTransferBean> getDtlList(int itemId, int destLoc, String companyId) {
		List<StockTransferBean> list = new ArrayList<>();

		try {

			List<Map<String, Object>> location = jdbcTemplate.queryForList(StockTransferQueryUtil.getDtlList, new Object[] { itemId, destLoc, companyId });
			for (Map row : location) {
				StockTransferBean bean = new StockTransferBean();
				/*
				 * bean.setId(covertNullToEmpty(String.valueOf(row.get(
				 * "purchase_requisition_id"))));
				 * bean.setText(covertNullToEmpty(String.valueOf(row.get(
				 * "requisition_number"))));
				 * bean.setReqDate(covertNullToEmpty(String.valueOf(row.get(
				 * "requisition_date"))));
				 * bean.setReqBy(covertNullToEmpty(String.valueOf(row.get( "requested_by"))));
				 * bean.setSourceLoc(covertNullToInteger(String.valueOf(row.get(
				 * "source_id")))); bean.setDestLoc(covertNullToInteger(String.valueOf(row.get(
				 * "destination_id"))));
				 * bean.setSourceLocName(covertNullToEmpty(String.valueOf(row.
				 * get("source_name"))));
				 * bean.setDestLocName(covertNullToEmpty(String.valueOf(row.get(
				 * "destination_name"))));
				 * bean.setCompanyId(covertNullToEmpty(String.valueOf(row.get( "company_id"))));
				 */
				bean.setId(covertNullToEmpty(String.valueOf(row.get("item_id"))));
				bean.setText(covertNullToEmpty(String.valueOf(row.get("text"))));
				bean.setItemName(covertNullToEmpty(String.valueOf(row.get("item_name"))));
				bean.setItemDesc(covertNullToEmpty(String.valueOf(row.get("item_desc"))));
				bean.setQuantity(covertNullToDouble(String.valueOf(row.get("quantity"))));
				bean.setPrquantity(covertNullToDouble(String.valueOf(row.get("quantity"))));
				bean.setPendingQuantity(covertNullToDouble(String.valueOf(row.get("pending_quantity"))));
				bean.setOriginalQty((double) row.get("originalQty"));
				bean.setUom(covertNullToEmpty(String.valueOf(row.get("uom"))));
				bean.setReqDetailId(covertNullToInteger(String.valueOf(row.get("purchase_requisition_detail_id"))));
				// bean.setCompanyId(covertNullToEmpty(String.valueOf(row.get("company_id"))));

				double GRNQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_GRN_QTY, Double.class, bean.getId());
				double MISSUEQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_MI_QTY, Double.class, bean.getId());
				double itemOpeningQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_OPENING_QTY, Double.class, Integer.parseInt(bean.getId()));

				// 13/02/21 gatepass item included
				int GatePassOut = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSOUT_QTY, Integer.class, bean.getId());
				int GatePassIn = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSIN_QTY, Integer.class, bean.getId());
				// end

				double availableQTY = 0;
				/*
				 * if (GRNQTY == 0.0 && MISSUEQTY == 0.0) { availableQTY = (GRNQTY - MISSUEQTY)
				 * + itemOpeningQTY; bean.setAvailableQTY(availableQTY); } else
				 */
				// if (GRNQTY > MISSUEQTY) {
				// availableQTY = (GRNQTY + itemOpeningQTY) - MISSUEQTY;
				availableQTY = (GRNQTY + itemOpeningQTY) - (MISSUEQTY + (GatePassOut - GatePassIn));

				// bean.setAvailableQTY(availableQTY);
				// } else if (GRNQTY < MISSUEQTY || GRNQTY == MISSUEQTY) {
				// availableQTY = 0;
				if (availableQTY < 0)
					availableQTY = 0;
				bean.setAvailableQTY(availableQTY);

				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<StockTransferBean> getItem(String companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SelectivityBean> issueTypeList() {
		// TODO Auto-generated method stub
		List<SelectivityBean> List = new ArrayList<>();
		try {
			List = jdbcTemplate.query(PurchaseQuotationQueryUtil.GET_ISSUE_TYPE_LIST, new Object[] { 81 }, new BeanPropertyRowMapper<>(SelectivityBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return List;
	}

	@Override
	public List<StockTransferBean> ItemList(int destId, String companyId) {
		// TODO Auto-generated method stub
		List<StockTransferBean> List = new ArrayList<>();
		try {
			List = jdbcTemplate.query(PurchaseQuotationQueryUtil.GET_ITEM_LIST, new Object[] { destId, companyId }, new BeanPropertyRowMapper<>(StockTransferBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return List;
	}

	@Override
	public void InsertStockHdrKitchen(StockTransferBean bean) {

		try {
			SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
			int status = 0;

			// Date stockdate = fromUser.parse(bean.getDate());

			if (covertNullToEmpty(bean.getStatus()).isEmpty()) {
				bean.setStatus("Pending");
			}
			// int dec = Integer.parseInt(bean.getDestLocName());
			// int src = Integer.parseInt(bean.getSourceLocName());
			bean.setSourceLoc(Integer.parseInt(bean.getSourceLocName()));
			bean.setDestLoc((Integer.parseInt(bean.getDestLocName())));

			String stacknumber = jdbcTemplate.queryForObject(StockTransferQueryUtil.GET_STOCK_NUMBER, String.class);
			bean.setStockId(stacknumber);
			jdbcTemplate.update(StockTransferQueryUtil.INSERT_STOCK_HDR_KITCHEN, new Object[] { bean.getStockId(), CommonUtil.changeSqlDateFormate(bean.getDate()), bean.getTransportType(), bean.getServiceName(), bean.getPersonName(), bean.getDeliveryMet(), bean.getStatus(), bean.getSourceLoc(), bean.getDestLoc(), bean.getCompanyId(), bean.getIssueSlip(), bean.getIssueType() });

			int hdrid = jdbcTemplate.queryForObject(StockTransferQueryUtil.MAX_ID, new Object[] { bean.getStockId() }, Integer.class);

			ArrayList list = bean.getRowCollection();
			for (int i = 0; i < list.size(); i++) {

				// GET_LIST
				StockTransferBean dtbean = (StockTransferBean) list.get(i);
				double balanceQTY = 0;

				List<StockTransferBean> ItemList = new ArrayList<>();

				ItemList = jdbcTemplate.query(StockTransferQueryUtil.GET_LIST, new Object[] { Integer.parseInt(dtbean.getItemCode()), bean.getDestLoc(), bean.getCompanyId() }, new BeanPropertyRowMapper<>(StockTransferBean.class));
				balanceQTY = dtbean.getQuantity();
				for (int l = 0; l < ItemList.size(); l++) {
					double qty = 0;

					double REQQTY = jdbcTemplate.queryForObject(StockTransferQueryUtil.getQTY_FROM_REQUEST, Double.class, ItemList.get(l).getRequsitionDtlId());
					double ISSUEQTY = jdbcTemplate.queryForObject(StockTransferQueryUtil.GET_STOCK_DETAIL_QTY, Double.class, ItemList.get(l).getRequsitionDtlId());
					double requestQTY = REQQTY - ISSUEQTY;
					if (balanceQTY != 0.0) {
						if (requestQTY != 0.0) {
							if (balanceQTY >= requestQTY) {
								if (ItemList.get(l).getPendingQuantity() != 0.0) {

									// if (requestQTY !=
									// ItemList.get(l).getPendingQuantity()) {
									// requestQTY =
									// ItemList.get(l).getPendingQuantity();
									// ItemList.get(l).setPrquantity(requestQTY);
									// balanceQTY = Math.abs(balanceQTY -
									// requestQTY);
									// }
									balanceQTY = Math.abs(balanceQTY - requestQTY);
									ItemList.get(l).setPrquantity(requestQTY);
									ItemList.get(l).setQuantity(requestQTY);
								} else {
									ItemList.get(l).setPrquantity(requestQTY);
									balanceQTY = Math.abs(balanceQTY - requestQTY);
									ItemList.get(l).setQuantity(requestQTY);
									// balanceQTY = 0;
								}
							} else {
								// if (ItemList.get(l).getPendingQuantity() !=
								// 0.0) {
								//
								// if (requestQTY !=
								// ItemList.get(l).getPendingQuantity()) {
								// requestQTY =
								// ItemList.get(l).getPendingQuantity();
								// ItemList.get(l).setPrquantity(requestQTY);
								// ItemList.get(l).setQuantity(balanceQTY);
								// balanceQTY = Math.abs(balanceQTY -
								// requestQTY);
								// balanceQTY = 0;
								// }
								// } else {
								ItemList.get(l).setPrquantity(requestQTY);
								ItemList.get(l).setQuantity(balanceQTY);
								balanceQTY = Math.abs(balanceQTY - requestQTY);
								balanceQTY = 0;
								// }

							}

							// }

							jdbcTemplate.update(StockTransferQueryUtil.INSERT_STOCK_DTL_KITCHEN, new Object[] { hdrid, ItemList.get(l).getRequsitionDtlId(), Integer.parseInt(dtbean.getItemCode()), ItemList.get(l).getQuantity(), Math.abs(ItemList.get(l).getPrquantity() - ItemList.get(l).getQuantity()), ItemList.get(l).getPrquantity(), ItemList.get(l).getRequestNumber() });
							double getitemcount = jdbcTemplate.queryForObject(StockTransferQueryUtil.ITEM_NEW_COUNT, Double.class, Integer.parseInt(dtbean.getItemCode()));
							if (getitemcount > 0) {
								double getcurrencyQty = jdbcTemplate.queryForObject(StockTransferQueryUtil.ITEM_CURRENT_QTY, Double.class, Integer.parseInt(dtbean.getItemCode()));
								double currentQty = getcurrencyQty - dtbean.getQuantity();
								double ITMcurrentQty = getcurrencyQty - dtbean.getQuantity();

								if (currentQty > 0) {
									int count1 = jdbcTemplate.update(ConsignmentRequestQueryUtil.UPDATE_CURRENT_QTY, new Object[] { currentQty, Integer.parseInt(dtbean.getItemCode()) });

								} else if (currentQty <= 0) {
									int count1 = jdbcTemplate.update(ConsignmentRequestQueryUtil.UPDATE_CURRENT_QTY, new Object[] { 0, Integer.parseInt(dtbean.getItemCode()) });

								}
							}
							String requisitionNumber = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_MR_NUM, String.class, ItemList.get(l).getRequsitionId());

							int count = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_PO, Integer.class, requisitionNumber, Integer.parseInt(dtbean.getItemCode()));

							if (count == 0) {
								jdbcTemplate.update(StockTransferQueryUtil.UPDATE_PENDING_QTY_MR, new Object[] { Math.abs(ItemList.get(l).getPrquantity() - ItemList.get(l).getQuantity()), ItemList.get(l).getRequsitionDtlId() });
							}
							// jdbcTemplate.update(StockTransferQueryUtil.UPDATE_PENDING_QTY_MR,
							// new Object[] { dtbean.getPrquantity() -
							// dtbean.getQuantity(), dtbean.getReqDetailId() });

							int stockTransferDetailId = jdbcTemplate.queryForObject(StockTransferQueryUtil.MAX_DETAIL_ID, new Object[] { hdrid }, Integer.class);
							if (stockTransferDetailId > 0) {
								ArrayList batchDtlsList = dtbean.getBatchDetails();
								if (batchDtlsList != null) {
									for (int j = 0; j < batchDtlsList.size(); j++) {
										GRNPurchaseOrderBean batchdtbean = (GRNPurchaseOrderBean) batchDtlsList.get(j);
										if (batchdtbean.getTransferQty() > 0) {

											jdbcTemplate.update(StockTransferQueryUtil.INSERT_STOCK_BATCH_DTL, new Object[] { stockTransferDetailId, batchdtbean.getDtlItemId(), batchdtbean.getLotNo(), batchdtbean.getBatchQty(), batchdtbean.getManufactureDef(), batchdtbean.getMrp(), batchdtbean.getTransferQty(), batchdtbean.getBatchQty() - batchdtbean.getTransferQty(), batchdtbean.getTransferQty() });

										}
									}
								}
							}

							if (bean.getStatus().equals("Approved")) {

								commonUtilityService.updateInventoryAndLedgerIn(bean.getStockId(), bean.getDate(), 106, bean.getSourceLoc(), bean.getDestLoc(), Integer.parseInt(dtbean.getItemCode()), ItemList.get(l).getQuantity(), ItemList.get(l).getAttributeBeans());
								commonUtilityService.updateInventoryAndLedgerOut(bean.getStockId(), bean.getDate(), 106, bean.getDestLoc(), bean.getSourceLoc(), Integer.parseInt(dtbean.getItemCode()), ItemList.get(l).getQuantity(), ItemList.get(l).getAttributeBeans());

							}
							int RequisitionListQTY = jdbcTemplate.queryForObject(StockTransferQueryUtil.CHECK_REQUISITION_QTY, new Object[] { ItemList.get(l).getRequsitionId() }, Integer.class);
							int stockQTY = jdbcTemplate.queryForObject(StockTransferQueryUtil.CHECK_STOCK_QTY, new Object[] { ItemList.get(l).getRequsitionId() }, Integer.class);
							if (RequisitionListQTY == stockQTY) {
								status = 214;
								jdbcTemplate.update(StockTransferQueryUtil.issueStatus, new Object[] { status, ItemList.get(l).getRequsitionId() });
							} else if (RequisitionListQTY != stockQTY) {
								status = 213;
								jdbcTemplate.update(StockTransferQueryUtil.issueStatus, new Object[] { status, ItemList.get(l).getRequsitionId() });
							}
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public StockTransferBean getQtyFromStock(int itemId, int destId, String companyId) {
		// TODO Auto-generated method stub
		StockTransferBean bean = new StockTransferBean();
		try {
			// List<String> list =
			// Lists.newArrayList(Splitter.on(" , ").split(reqDetId));
			// List<String> list1 = new
			// ArrayList<String>(Arrays.asList(reqDetId.split(" , ")));

			// String str = "string,with,comma";
			// ArrayList list = new
			// ArrayList(Arrays.asList(reqDetId.split(",")));
			// for (int i = 0; i < list.size(); i++) {
			// System.out.println(" -->" + list.get(i));
			// }
			double pendingQTY = 0;
			// double TotpendingQTY = 0;
			// for (int j = 0; j < list.size(); j++) {
			// int id = Integer.parseInt(list.get(j).toString());

			double CheckQTY = 0;
			double CheckQTY1 = 0;
			double QTY = 1;
			CheckQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_SUM_PR_QTY, Double.class, itemId, destId, companyId);
			CheckQTY1 = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_SUM_ST_QTY, Double.class, itemId, destId, companyId);

			QTY = CheckQTY - CheckQTY1;
			if (QTY == 0) {

				QTY = 1;
			}
			bean.setCheckQuantity(QTY);
			// int PRdtlnum =
			// jdbcTemplate.queryForObject(StockTransferQueryUtil.Check_ST,
			// Integer.class, bean.getReqDetailId());

			double PendingQty = 0;
			int PRdtlnum = jdbcTemplate.queryForObject(StockTransferQueryUtil.Check_ST1, Integer.class, itemId);

			if (PRdtlnum > 0) {
				PendingQty = jdbcTemplate.queryForObject(StockTransferQueryUtil.GET_PENDING_QTY1, Double.class, itemId);

			}
			// pendingQTY =
			// jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_SUM_QTY,
			// Double.class, itemId);
			// TotpendingQTY = TotpendingQTY + pendingQTY;
			bean.setPendingQuantity(PendingQty);
			// }
			// List =
			// jdbcTemplate.query(PurchaseQuotationQueryUtil.GET_ITEM_LIST, new
			// Object[] { destId }, new
			// BeanPropertyRowMapper<StockTransferBean>(StockTransferBean.class));

			double GRNQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_GRN_QTY, Double.class, itemId);
			double MISSUEQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_MI_QTY, Double.class, itemId);

			double itemOpeningQTY = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GET_OPENING_QTY, Double.class, itemId);

			// 13/02/21 gatepass item included
			int GatePassOut = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSOUT_QTY, Integer.class, itemId);
			int GatePassIn = jdbcTemplate.queryForObject(PurchaseQuotationQueryUtil.GATEPASSIN_QTY, Integer.class, itemId);
			// end

			double availableQTY = 0;
			/*
			 * if (GRNQTY == 0.0 && MISSUEQTY == 0.0) { availableQTY = (GRNQTY - MISSUEQTY)
			 * + itemOpeningQTY; bean.setAvailableQTY(availableQTY); } else
			 */
			// if (GRNQTY > MISSUEQTY) {

			// availableQTY = (GRNQTY + itemOpeningQTY) - MISSUEQTY;
			availableQTY = (GRNQTY + itemOpeningQTY) - (MISSUEQTY + (GatePassOut - GatePassIn));

			// bean.setAvailableQTY(availableQTY);
			// } else if (GRNQTY < MISSUEQTY || GRNQTY == MISSUEQTY) {
			// availableQTY = 0;
			if (availableQTY < 0)
				availableQTY = 0;
			bean.setAvailableQTY(availableQTY);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
}
