package com.dci.tenant.finance.grn;

import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.AccountsConstants;
import com.dci.common.util.CommonUtil;
import com.dci.common.util.CustomException;
import com.dci.common.util.NumberstoWordsConversion;
import com.dci.tenant.common.CommonUtilityService;
import com.dci.tenant.finance.journalvoucher.JournalVoucherQueryUtil;
import com.dci.tenant.user.UserDetail;

@Repository
public class GRNDAOImpl implements GRNDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(GRNDAOImpl.class);
	NumberstoWordsConversion wordingConversion;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	CommonUtilityService commonUtilityService;

	@Override
	public List<GRNBean> getGRNMasterList(int limit, int offset, String formName) throws CustomException {
		String query = "";
		try {
			if (formName.equalsIgnoreCase("assetQC"))
				query = GRNQueryUtil.GRN_LIST_WITH_QC;
			else if (formName.equalsIgnoreCase("grn"))
				query = GRNQueryUtil.GRN_LIST;

			List<GRNBean> lGrnBean = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(GRNBean.class));
			return lGrnBean;
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException("");
		}

	}

	@Override
	public List<GRNBean> getGRNExportMasterList() throws CustomException {
		String query = "";
		String formName = "grn";

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			if (formName.equalsIgnoreCase("assetQC"))
				query = GRNQueryUtil.GRN_LIST_WITH_QC;
			else if (formName.equalsIgnoreCase("grn"))
				query = GRNQueryUtil.GRN_LIST2;

			List<GRNBean> lGrnBean = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(GRNBean.class));
			return lGrnBean;
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException("");
		}

	}

	@Override
	public GRNResultBean getLocationList() {
		GRNResultBean bean = new GRNResultBean();
		try {
			List<GRNBean> lLocationGrnBean = jdbcTemplate.query(GRNQueryUtil.GET_LOCATION_LIST, new BeanPropertyRowMapper<>(GRNBean.class));
			bean.setlLocation(lLocationGrnBean);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return bean;
	}

	@Override
	public GRNResultBean getVendorList() {
		GRNResultBean bean = new GRNResultBean();
		try {
			List<GRNBean> lVendorGrnBean = jdbcTemplate.query(GRNQueryUtil.GET_VENDOR_LIST, new BeanPropertyRowMapper<>(GRNBean.class));
			bean.setlVendor(lVendorGrnBean);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return bean;
	}

	@Override
	public GRNResultBean getPOList() {
		GRNResultBean bean = new GRNResultBean();
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			// List<GRNBean> lPoGrnBean =
			// jdbcTemplate.query(GRNQueryUtil.GET_PO_LIST, new Object[] { 47,
			// 138, userDetails.getCompanyCode() }, new
			// BeanPropertyRowMapper<GRNBean>(GRNBean.class));
			List<GRNBean> lPoGrnBean = jdbcTemplate.query(GRNQueryUtil.GET_PO_LIST, new Object[] { 47, 138 }, new BeanPropertyRowMapper<>(GRNBean.class));

			bean.setlPurchaseOrder(lPoGrnBean);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return bean;
	}

	private GRNResultBean getPOListForVendor(int vendorId, GRNResultBean bean, JdbcTemplate jdbcTemplate) {
		try {
			List<GRNBean> lPoGrnBean = jdbcTemplate.query(GRNQueryUtil.GET_PO_LIST_WITH_ID, new Object[] { vendorId, 47, 138, 139 }, new BeanPropertyRowMapper<>(GRNBean.class));
			bean.setlPurchaseOrder(lPoGrnBean);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return bean;
	}

	public static double convertDecimalPoint(double value) {
		double finalValue = 0.00;
		DecimalFormat df = new DecimalFormat("0.00");
		String formate = df.format(value);
		try {
			finalValue = df.parse(formate).doubleValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalValue;
	}

	@Override
	public GRNResultBean getPODtlList(int poId) {
		GRNResultBean bean = new GRNResultBean();
		List<GRNPurchaseOrderBean> list = new ArrayList<>();
		List<GRNPurchaseOrderBean> consignmentBatchList = new ArrayList<>();

		try {
			List<GRNPurchaseOrderBean> lPoGrnBean = jdbcTemplate.query(GRNQueryUtil.GET_PO_DTL_LIST, new Object[] { poId, poId }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(GRNQueryUtil.GET_CONSIGNMENT_TRANSFER_DETAILS, new Object[] { poId });

			for (Map row : rows) {

				if ((int) row.get("purchasetype") == 45) {

					int consignmentTransferNumber = (int) row.get("consignmentTransferId");

					consignmentBatchList = jdbcTemplate.query(GRNQueryUtil.GET_CONSIGNEMNT_STOCK_TRANSFER_DETAIL_ID, new Object[] { consignmentTransferNumber }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));

					for (int i = 0; i < lPoGrnBean.size(); i++) {
						List<GRNPurchaseOrderBean> batchDetailsConsignment = new ArrayList<>();
						if (consignmentBatchList != null) {
							batchDetailsConsignment = jdbcTemplate.query(GRNQueryUtil.GET_CONSIGNMETN_BATCH_DETAILS, new Object[] { consignmentBatchList.get(i).getStockTransferDetailId(), lPoGrnBean.get(i).getDtlItemId() }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));
						}

						lPoGrnBean.get(i).setBatchDtls(batchDetailsConsignment);
					}

				}

			}

			for (GRNPurchaseOrderBean grnPurchaseOrderBean : lPoGrnBean) {
				List<GRNPurchaseOrderBean> lSchGrnBean = jdbcTemplate.query(GRNQueryUtil.PO_SCHEDULE, new Object[] { grnPurchaseOrderBean.getDtlPODtlId() }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));
				grnPurchaseOrderBean.setScheduleList(lSchGrnBean);
				list.add(grnPurchaseOrderBean);
			}

			int count = jdbcTemplate.queryForObject(GRNQueryUtil.GET_PO_COUNT_IN_GRN, Integer.class, poId);
			if (count > 0) {
				List<Map<String, Object>> row = jdbcTemplate.queryForList(GRNQueryUtil.GET_FREIGHT_OTHER_IN_GRN, new Object[] { poId });

				for (Map row1 : row) {
					bean.setGrnFreight(CommonUtil.convertNullToDouble(row1.get("freight").toString()));
					bean.setGrnOtherCharges(CommonUtil.convertNullToDouble(row1.get("other_charges").toString()));
				}
			}
			bean.setlPurchaseOrderDtl(list);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return bean;
	}

	@Override
	@Transactional
	public boolean saveGrn(final GRNBean bean) throws Exception {
		boolean isSuccess = false;

		try {
			bean.setGrnCode(grnAutoIncrementNo());
			KeyHolder keyHolder = new GeneratedKeyHolder();
			// String vendorId = bean.getVendorId();
			// final int vId = Integer.parseInt(vendorId);
			// final int entityId =
			// jdbcTemplate.queryForObject(GRNQueryUtil.GET_ENTITY_ID, new
			// Object[] { vendorId }, Integer.class);
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			bean.setCreatedBy(userDetails.getUserId());
			// bean.setCreatedDate("NOW()");
			/*
			 * jdbcTemplate.update(new PreparedStatementCreator() {
			 * 
			 * @Override public PreparedStatement createPreparedStatement(Connection
			 * connection) throws SQLException { PreparedStatement ps =
			 * connection.prepareStatement(GRNQueryUtil.SAVE_GRN_HDR, new String[] {
			 * "grn_id" }); ps.setString(1, bean.getGrnCode()); ps.setString(2,
			 * bean.getGrnDate()); ps.setInt(3, bean.getPoId()); ps.setString(4,
			 * bean.getPoRequisition()); ps.setInt(5, bean.getVendorId()); // ps.setInt(5,
			 * vId); ps.setString(6, bean.getDelOrderNo()); ps.setString(7,
			 * bean.getDelOrderDate()); ps.setString(8, bean.getInvoiceNo());
			 * ps.setString(9, bean.getInvoiceDate()); ps.setInt(10,
			 * bean.getDeliveryMthd()); ps.setInt(11, bean.getTransMode()); ps.setInt(12,
			 * bean.getLocId()); ps.setInt(13, bean.getDstLocId()); ps.setInt(14,
			 * bean.getQcLocationId()); ps.setString(15, bean.getCompanyId());
			 * ps.setString(16, bean.getDueDate()); ps.setString(17, bean.getDescription());
			 * ps.setDouble(18, bean.getFreight()); ps.setDouble(19,
			 * bean.getOtherCharges()); ps.setString(20, bean.getCreatedBy()); //
			 * ps.setString(21, bean.getCreatedDate());
			 * 
			 * return ps; } }, keyHolder);
			 */
			int grnId = 0;
			grnId = jdbcTemplate.queryForObject(GRNQueryUtil.SAVE_GRN_HDR, new Object[] { bean.getGrnCode(), bean.getGrnDate(), bean.getPoId(), bean.getPoRequisition(), bean.getVendorId(), bean.getDelOrderNo(), bean.getDelOrderDate(), bean.getInvoiceNo(), bean.getInvoiceDate(), bean.getDeliveryMthd(), bean.getTransMode(), bean.getLocId(), bean.getDstLocId(), bean.getQcLocationId(), bean.getCompanyId(), bean.getDueDate(), bean.getDescription(), bean.getFreight(), bean.getOtherCharges(), bean.getCreatedBy() }, Integer.class);
			// int grnId = keyHolder.getKey().intValue();

			if (grnId > 0) {
				isSuccess = saveGrnDtl(bean, grnId);
				if (bean.getPoType().equalsIgnoreCase("Rate Contract")) {
					isSuccess = updatePOSchedule(bean.getSchDtlList());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	private boolean saveGrnDtl(GRNBean bean, int grnId) throws Exception {
		boolean isSuccess = false, status = true;
		double dTotalGrnAmount = 0;
		try {
			List<GRNPurchaseOrderBean> alDetailList = bean.getGrnTables();

			int poCnt = jdbcTemplate.queryForObject(GRNQueryUtil.GET_PO_CNT_IN_GRN, new Object[] { bean.getPoId() }, Integer.class);

			if (poCnt == 1)
				dTotalGrnAmount = bean.getPoFreight();

			for (GRNPurchaseOrderBean objGRNPurchaseOrderBean : alDetailList) {

				double availablePendingQty = (objGRNPurchaseOrderBean.getPendingQty() - objGRNPurchaseOrderBean.getDtlQty());

				int dtlId = jdbcTemplate.queryForObject(GRNQueryUtil.SAVE_GRN_DTL, new Object[] { grnId, objGRNPurchaseOrderBean.getDtlItemId(), objGRNPurchaseOrderBean.getCostcenter(), objGRNPurchaseOrderBean.getDtlQty(), availablePendingQty, objGRNPurchaseOrderBean.getConvertedQty(), objGRNPurchaseOrderBean.getDtlPODtlId(), objGRNPurchaseOrderBean.getConvertedQtyNew(), objGRNPurchaseOrderBean.isConvertedQtyFlag(), objGRNPurchaseOrderBean.getBalanceConvertedQtyNew() }, Integer.class);

				int poDtlCnt = jdbcTemplate.queryForObject(GRNQueryUtil.GET_PO_DTL_QTY, new Object[] { objGRNPurchaseOrderBean.getDtlPODtlId() }, Integer.class);

				if (poDtlCnt == 1)
					dTotalGrnAmount += (objGRNPurchaseOrderBean.getDtlPrice() * objGRNPurchaseOrderBean.getDtlQty()) + objGRNPurchaseOrderBean.getDtlTax() - objGRNPurchaseOrderBean.getDtlDisc();
				else
					dTotalGrnAmount += objGRNPurchaseOrderBean.getDtlPrice() * objGRNPurchaseOrderBean.getDtlQty();

				if (dtlId > 0) {
					if (objGRNPurchaseOrderBean.getDtlQty() == objGRNPurchaseOrderBean.getPendingQty()) {
						jdbcTemplate.update(GRNQueryUtil.UPDATE_PO_DTL_STATUS, new Object[] { 72, objGRNPurchaseOrderBean.getDtlPODtlId() });
						status = false;
					} else {
						jdbcTemplate.update(GRNQueryUtil.UPDATE_PO_DTL_STATUS, new Object[] { 144, objGRNPurchaseOrderBean.getDtlPODtlId() });
					}
					objGRNPurchaseOrderBean.setBatchDtls(objGRNPurchaseOrderBean.getBatchDtls());

					if (!bean.getPoType().equalsIgnoreCase("Consignment Po")) {

						//commonUtilityService.updateInventoryAndLedgerIn(bean.getGrnCode(), bean.getGrnDate(), 88, bean.getLocId(), bean.getDstLocId(), objGRNPurchaseOrderBean.getDtlItemId(), objGRNPurchaseOrderBean.getConvertedQty(), objGRNPurchaseOrderBean.getAttributeBeans());
						//commonUtilityService.updateInventoryAndLedgerOut(bean.getGrnCode(), bean.getGrnDate(), 88, bean.getDstLocId(), bean.getLocId(), objGRNPurchaseOrderBean.getDtlItemId(), objGRNPurchaseOrderBean.getConvertedQty(), objGRNPurchaseOrderBean.getAttributeBeans());
					}
					isSuccess = true;
				}

				isSuccess = saveGrnBatchDtl(objGRNPurchaseOrderBean, dtlId);
			}

			// autoJvEntryGeneration(bean, dTotalGrnAmount);
			int minStatus = jdbcTemplate.queryForObject(GRNQueryUtil.GET_PO_STATUS, new Object[] { bean.getPoId() }, Integer.class);
			int maxStatus = jdbcTemplate.queryForObject(GRNQueryUtil.GET_PO_MAX_STATUS, new Object[] { bean.getPoId() }, Integer.class);

			if (minStatus == 72 || maxStatus == 144 || minStatus == 144 || maxStatus == 72) {
				jdbcTemplate.update(GRNQueryUtil.UPDATE_PO_STATUS, new Object[] { 138, bean.getPoId() });
			} else if (minStatus == 143 && maxStatus == 143) {
				jdbcTemplate.update(GRNQueryUtil.UPDATE_PO_STATUS, new Object[] { 139, bean.getPoId() });
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	// Auto jv entry for GRN

	public void autoJvEntryGeneration(GRNBean bean, double dGrnAmount) {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			String journalNumber = generateJournalVoucherNumber();

			String vendorCode = jdbcTemplate.queryForObject(GRNQueryUtil.GET_VENDOR_ACCT_CODE, new Object[] { bean.getVendorId() }, String.class);

			int jvHdr = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_JOURNAL_VOUCHER_HEADER, new Object[] { null, journalNumber, bean.getGrnDate(), "GRN AUTO JV FOR PURCHASE ORDER - " + bean.getPoNo(), userDetails.getUserId(), bean.getCompanyId() });

			// debit entry
			int jvDebit = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_JOURNAL_VOUCHER_DTL, new Object[] { journalNumber, "2009", "INR", 1.0, 0.0, dGrnAmount, "GRN AUTO JV FOR PURCHASE ORDER - " + bean.getPoNo(), AccountsConstants.STOCK_VALUE_SG, 0.0, dGrnAmount, 1, vendorCode, null, null, null, null, null, bean.getCompanyId(), null, null, null });
			// int jvDebit =
			// jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_JOURNAL_VOUCHER_DTL,
			// new Object[] { journalNumber, AccountsConstants.STOCK_VALUE_AH,
			// "INR", 1.0, 0.0, dGrnAmount, "GRN AUTO JV FOR PURCHASE ORDER - "
			// + bean.getPoNo(), AccountsConstants.STOCK_VALUE_SG, 0.0,
			// dGrnAmount, 1, vendorCode, null, null, null, null, null,
			// bean.getCompanyId(), null, null, null });
			//
			// credit entry
			int jvCredit = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_JOURNAL_VOUCHER_DTL, new Object[] { journalNumber, "4001", "INR", 1.0, dGrnAmount, 0.0, "GRN AUTO JV FOR PURCHASE ORDER - " + bean.getPoNo(), AccountsConstants.PURCHASE_ACCRUAL_SG, dGrnAmount, 0.0, 1, vendorCode, null, null, null, null, null, bean.getCompanyId(), null, null, null });
			// int jvCredit =
			// jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_JOURNAL_VOUCHER_DTL,
			// new Object[] { journalNumber,
			// AccountsConstants.PURCHASE_ACCRUAL_AH, "INR", 1.0, dGrnAmount,
			// 0.0, "GRN AUTO JV FOR PURCHASE ORDER - " + bean.getPoNo(),
			// AccountsConstants.PURCHASE_ACCRUAL_SG, dGrnAmount, 0.0, 1,
			// vendorCode, null, null, null, null, null, bean.getCompanyId(),
			// null, null, null });

			if (jvHdr > 0 && jvDebit > 0 && jvCredit > 0)
				jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_GENERAL_LEDGER_FOR_GRN, new Object[] { bean.getPoNo(), journalNumber });

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
		}

		return journalNumber;
	}

	private boolean saveGrnBatchDtl(GRNPurchaseOrderBean objGRNPurchaseOrderBean, int grnDtlId) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		try {
			List<GRNPurchaseOrderBean> alDetailList = objGRNPurchaseOrderBean.getBatchDtls();
			for (GRNPurchaseOrderBean objBean : alDetailList) {

				String expiryDate = "";
				// int dtlStatus =
				// jdbcTemplate.update(GRNQueryUtil.SAVE_GRN_BATCH_DTL, new
				// Object[] { grnDtlId, objBean.getBatchItemId(),
				// objBean.getLotNo(), objBean.getBatchQty(),
				// objBean.getExpiryDate(), objBean.getManufactureDef(),
				// objBean.getMrp(), objBean.getOriginalConvertedQty() });
				int dtlStatus = jdbcTemplate.update(GRNQueryUtil.SAVE_GRN_BATCH_DTL, new Object[] { grnDtlId, objBean.getBatchItemId(), objBean.getLotNo(), objBean.getBatchQty(), objBean.getManufactureDef(), objBean.getMrp(), objBean.getOriginalConvertedQty() });

				if (dtlStatus > 0) {
					isSuccess = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	private boolean updatePOSchedule(List<GRNPurchaseOrderBean> schDtlList) throws Exception {
		boolean isSuccess = false;
		int status = 0, dtlStatus = 0, pendingQty = 0;
		try {
			for (GRNPurchaseOrderBean objBean : schDtlList) {
				if (objBean.getSelect() != null && !"".equalsIgnoreCase(objBean.getSelect())) {
					if (objBean.getSelect().equalsIgnoreCase("true")) {
						pendingQty = objBean.getSchedulePendingQty() - objBean.getScheduleItemQty();

						if (pendingQty == 0) {
							status = 139;
						} else {
							status = 138;
						}

						dtlStatus = jdbcTemplate.update(GRNQueryUtil.UPDATE_PO_SCHEDULE_STATUS, new Object[] { pendingQty, objBean.getScheduleId() });
					}
				}

				if (dtlStatus > 0) {
					isSuccess = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@Override
	public String grnAutoIncrementNo() {
		String str = "";
		try {
			str = jdbcTemplate.queryForObject(GRNQueryUtil.GRN_AUTO_GENERATE, String.class);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return str;
	}

	@Override
	public GRNResultBean getRequisition(int poId) {
		GRNResultBean bean = new GRNResultBean();
		try {
			List<GRNBean> lPoGrnBean = jdbcTemplate.query(GRNQueryUtil.GRN_REQUISITION, new Object[] { poId }, new BeanPropertyRowMapper<>(GRNBean.class));
			bean.setlRequisitionList(lPoGrnBean);
			bean.setlRequisitionDtl(getRequisitionList(poId));
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return bean;
	}

	private List<GRNPurchaseOrderBean> getRequisitionList(int poId) {
		List<GRNPurchaseOrderBean> lPoGrnDtlBean = new ArrayList<>();
		try {
			lPoGrnDtlBean = jdbcTemplate.query(GRNQueryUtil.GRN_REQ_DTL, new Object[] { poId }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			// throw new CustomException("");
		}
		return lPoGrnDtlBean;
	}

	@Override
	public GRNResultBean getVendorAddress(int vendorId) {
		GRNResultBean bean = new GRNResultBean();
		try {
			List<GRNPurchaseOrderBean> lPoGrnBean = jdbcTemplate.query(GRNQueryUtil.GET_VENDOR_ADDRESS, new Object[] { vendorId }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));
			bean.setlVendorAddressDtl(lPoGrnBean);
			getPOListForVendor(vendorId, bean, jdbcTemplate);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return bean;
	}

	@Override
	public GRNResultBean getGrnEditData(String grnCode) {

		GRNResultBean resultBean = new GRNResultBean();
		GRNBean bean = new GRNBean();
		List<GRNPurchaseOrderBean> lDetailList = new ArrayList<>();
		try {
			bean = getGrnHeaderData(grnCode);
			lDetailList = getGrnDtlListData(grnCode);
			bean.setGrnTables(lDetailList);
			resultBean.setEditBeanData(bean);

		} catch (Exception e) {
			LOGGER.error("Error in Get getGrnEditData List", e);
		}

		return resultBean;
	}

	private List<GRNPurchaseOrderBean> getGrnDtlListData(String grnCode) {
		List<GRNPurchaseOrderBean> dtlDataList = new ArrayList<>();
		try {
			List<GRNPurchaseOrderBean> dtlList = jdbcTemplate.query(GRNQueryUtil.GET_GRN_DTL, new Object[] { grnCode }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));

			for (GRNPurchaseOrderBean grnPurchaseOrderBean : dtlList) {
				List<GRNPurchaseOrderBean> lSchGrnBean = jdbcTemplate.query(GRNQueryUtil.PO_SCHEDULE, new Object[] { grnPurchaseOrderBean.getDtlPODtlId() }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));
				List<GRNPurchaseOrderBean> lBatchGrnBean = jdbcTemplate.query(GRNQueryUtil.GET_GRN_BATCH_DTL, new Object[] { grnPurchaseOrderBean.getGrnDtlId() }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));

				grnPurchaseOrderBean.setScheduleList(lSchGrnBean);
				grnPurchaseOrderBean.setBatchDtls(lBatchGrnBean);

				dtlDataList.add(grnPurchaseOrderBean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get GRN Detail List", e);
		}
		return dtlDataList;
	}

	private GRNBean getGrnHeaderData(String grnCode) {
		GRNBean objGRNBean = new GRNBean();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(GRNQueryUtil.GET_GRN_HDR, new Object[] { grnCode });

			for (Map row : rows) {
				objGRNBean.setGrnId((int) row.get("grnId"));
				objGRNBean.setGrnCode((String) row.get("grnCode"));
				objGRNBean.setCompanyId((String) row.get("companyId"));
				objGRNBean.setGrnDate((String) row.get("grnDate"));
				objGRNBean.setPoId((int) row.get("poId"));
				objGRNBean.setPoNo((String) row.get("poNo"));
				objGRNBean.setPoAmendNo((String) row.get("poAmendNo"));

				objGRNBean.setConTransferNo((String) row.get("conTransferNo"));
				objGRNBean.setPoRequisitionId((String) row.get("poRequisitionId"));
				objGRNBean.setPoRequisition((String) row.get("poRequisition"));
				objGRNBean.setVendorId((int) row.get("vendorId"));
				objGRNBean.setVendorName((String) row.get("vendorName"));
				objGRNBean.setDelOrderNo((String) row.get("delOrderNo"));
				objGRNBean.setDelOrderDate((String) row.get("delOrderDate"));
				objGRNBean.setInvoiceNo((String) row.get("invoiceNo"));
				objGRNBean.setInvoiceDate((String) row.get("invoiceDate"));
				objGRNBean.setDeliveryMthd((int) row.get("deliveryMthd"));
				objGRNBean.setTransMode((int) row.get("transMode"));
				objGRNBean.setLocId((int) row.get("locId"));
				objGRNBean.setLocName((String) row.get("locName"));
				objGRNBean.setQcLocationId((int) row.get("qcLocationId"));
				objGRNBean.setQcLocationName((String) row.get("qcLocationName"));
				objGRNBean.setDstLocId((int) row.get("dstLocId"));
				objGRNBean.setDstLocName((String) row.get("dstLocName"));
				objGRNBean.setPoType((String) row.get("poType"));
				objGRNBean.setGrnStatus((int) row.get("grnStatus"));
				objGRNBean.setDueDate((String) row.get("dueDate"));
				objGRNBean.setFreight((double) row.get("freight"));
				objGRNBean.setOtherCharges((double) row.get("otherCharges"));
				objGRNBean.setRemarksforother((CommonUtil.convertNullToEmpty((String) row.get("remarksforother"))));
				// objGRNBean.setDueDate((String) row.get("duedate"));
				objGRNBean.setEntity((String) row.get("entity"));
				objGRNBean.setVendorName((String) row.get("vendorName"));
				objGRNBean.setVendorAddress((String) row.get("address"));
				objGRNBean.setVendorPhone((String) row.get("vendorPhone"));
				objGRNBean.setFreight((double) row.get("grnfreight"));
				objGRNBean.setOtherCharges((double) row.get("grnOtherCharnge"));
				objGRNBean.setPreparedBy((String) row.get("first_name"));

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in get GRN Header list", e);
		}
		return objGRNBean;
	}

	@Override
	@Transactional
	public boolean updateGRN(GRNBean bean) throws Exception {
		boolean isSuccess = false;
		try {
			int iupdate = jdbcTemplate.update(GRNQueryUtil.UPDATE_GRN, new Object[] { bean.getGrnDate(), bean.getPoRequisitionId(), bean.getVendorId(), bean.getDelOrderNo(), bean.getDelOrderDate(), bean.getInvoiceNo(), bean.getInvoiceDate(), bean.getDeliveryMthd(), bean.getTransMode(), bean.getPoId(), bean.getLocId(), bean.getDstLocId(), bean.getQcLocationId(), bean.getGrnCode() });

			if (iupdate > 0) {
				jdbcTemplate.update(GRNQueryUtil.DELETE_GRN_DTL, new Object[] { bean.getGrnId() });
				isSuccess = saveGrnDtl(bean, bean.getGrnId());
			}
			isSuccess = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@Override
	@Transactional
	public boolean deleteGRN(String grnNo) {
		boolean isSuccess = false;
		try {
			int grnId = jdbcTemplate.queryForObject(GRNQueryUtil.GET_GRN_ID, new Object[] { grnNo }, Integer.class);

			if (grnId > 0) {
				int dtlDelete = jdbcTemplate.update(GRNQueryUtil.DELETE_GRN_DTL, new Object[] { grnId });
				if (dtlDelete != 0)
					jdbcTemplate.update(GRNQueryUtil.DELETE_GRN, new Object[] { grnId });
			}
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete GRN", e);
		}
		return isSuccess;
	}

	@Override
	public GRNResultBean getDeliverySchedule(int poDtlId) {
		GRNResultBean bean = new GRNResultBean();
		try {
			List<GRNPurchaseOrderBean> lPoGrnBean = jdbcTemplate.query(GRNQueryUtil.PO_SCHEDULE, new Object[] { poDtlId }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));
			bean.setlScheduleDtl(lPoGrnBean);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return bean;
	}

	@Override
	public boolean updateGRNwithQC(GRNBean bean) {
		boolean isSuccess = false, qcComplete = true;
		int dtlId = 0;
		try {
			List<GRNPurchaseOrderBean> alDetailList = bean.getGrnTables();
			for (GRNPurchaseOrderBean objGRNPurchaseOrderBean : alDetailList) {

				if (objGRNPurchaseOrderBean.getSampleQty() > 0 && (objGRNPurchaseOrderBean.getQcStatus() == 146 || objGRNPurchaseOrderBean.getQcStatus() == 148) && objGRNPurchaseOrderBean.getDtlStatus() != 150) {
					dtlId = jdbcTemplate.update(GRNQueryUtil.UPDATE_GRN_ITEM_QC, new Object[] { objGRNPurchaseOrderBean.getSampleQty(), objGRNPurchaseOrderBean.getQcStatus(), objGRNPurchaseOrderBean.getQcRemarks(), 150, objGRNPurchaseOrderBean.getGrnDtlId() });

					//commonUtilityService.updateInventoryAndLedgerInCheckQc(bean.getGrnCode(), bean.getGrnDate(), 149, bean.getLocId(), bean.getDstLocId(), objGRNPurchaseOrderBean.getDtlItemId(), objGRNPurchaseOrderBean.getConvertedQty(), objGRNPurchaseOrderBean.getQcStatus(), objGRNPurchaseOrderBean.getAttributeBeans());
					//commonUtilityService.updateInventoryAndLedgerOutCheckQc(bean.getGrnCode(), bean.getGrnDate(), 149, bean.getDstLocId(), bean.getLocId(), objGRNPurchaseOrderBean.getDtlItemId(), objGRNPurchaseOrderBean.getConvertedQty(), objGRNPurchaseOrderBean.getQcStatus(), objGRNPurchaseOrderBean.getAttributeBeans());
					isSuccess = true;
				}

				if (objGRNPurchaseOrderBean.isQualityCheck()) {
					if (objGRNPurchaseOrderBean.getQcStatus() == 0) {
						qcComplete = false;
					}

				}

			}

			if (qcComplete)
				jdbcTemplate.update(GRNQueryUtil.UPDATE_GRN_STATUS, new Object[] { 151, bean.getGrnId() });
			else
				jdbcTemplate.update(GRNQueryUtil.UPDATE_GRN_STATUS, new Object[] { 152, bean.getGrnId() });

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@Override
	public GRNPurchaseOrderBean getItemAttributes(int itemId) {
		GRNPurchaseOrderBean bean = new GRNPurchaseOrderBean();
		try {
			bean = jdbcTemplate.queryForObject(GRNQueryUtil.GET_ITEM_ATTRIBUTES, new Object[] { itemId }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return bean;
	}

	@Override
	public GRNResultBean getPOEditList() throws CustomException {
		GRNResultBean bean = new GRNResultBean();
		try {
			List<GRNBean> lPoGrnBean = jdbcTemplate.query(GRNQueryUtil.GET_PO_EDIT_LIST, new BeanPropertyRowMapper<>(GRNBean.class));
			bean.setlPurchaseOrder(lPoGrnBean);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return bean;
	}

	@Override
	public GRNPurchaseOrderBean getGrnOldBatchValue(GRNPurchaseOrderBean bean) {
		GRNPurchaseOrderBean grnResultBean = new GRNPurchaseOrderBean();
		try {

			List<GRNPurchaseOrderBean> lPoGrnBean = jdbcTemplate.query(GRNQueryUtil.GET_OLD_BATCH, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class), bean.getLotNo(), bean.getDestinationId(), bean.getBatchItemId());
			int batchCount = jdbcTemplate.queryForObject(GRNQueryUtil.CHECK_CONSIGNMENT_LIST, Integer.class , bean.getLotNo(), bean.getDestinationId(), bean.getBatchItemId() );

			for (GRNPurchaseOrderBean grnPurchaseOrderBean : lPoGrnBean) {
				grnResultBean.setExpiryDate(grnPurchaseOrderBean.getExpiryDate());
				grnResultBean.setMrp(grnPurchaseOrderBean.getMrp());
			}
			if (batchCount > 0) {
				grnResultBean.setCheckConsignmentBatch(true);
			} else {
				grnResultBean.setCheckConsignmentBatch(false);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return grnResultBean;
	}

	@Override
	public List<GRNPurchaseOrderBean> getBatchList(String grnCode) {

		List<GRNPurchaseOrderBean> batchList = new ArrayList<>();

		batchList = jdbcTemplate.query(GRNQueryUtil.GET_BATCH_DETAILLIST, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class), grnCode);

		return batchList;
	}

	@Override
	public GRNResultBean getPOListbasedonCompany(String companyId, int vendorId) {
		GRNResultBean bean = new GRNResultBean();
		try {
			// UserDetail userDetails = (UserDetail)
			// SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			List<GRNBean> lPoGrnBean = jdbcTemplate.query(GRNQueryUtil.GET_PO_LIST_COM_BASED, new Object[] { 47, 138, companyId, vendorId }, new BeanPropertyRowMapper<>(GRNBean.class));
			bean.setlPurchaseOrder(lPoGrnBean);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return bean;
	}

	@Override
	public GRNResultBean getGrnPrintData(String grnCode) {

		GRNResultBean resultBean = new GRNResultBean();
		GRNBean bean = new GRNBean();
		List<GRNPurchaseOrderBean> lDetailList = new ArrayList<>();
		try {
			bean = getGrnPrintHeaderData(grnCode);
			// lDetailList = getGrnDtlListData1(grnCode);
			// bean.setGrnTables(lDetailList);
			resultBean.setEditBeanData(bean);

		} catch (Exception e) {
			LOGGER.error("Error in Get getGrnPrintData List", e);
		}

		return resultBean;
	}

	private List<GRNPurchaseOrderBean> getGrnDtlListData1(String grnCode) {
		List<GRNPurchaseOrderBean> dtlDataList = new ArrayList<>();
		try {
			List<GRNPurchaseOrderBean> dtlList = jdbcTemplate.query(GRNQueryUtil.GET_GRN_DTL_PRINT, new Object[] { grnCode }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));
			int serialNumber = 0;
			double finalTotal = 0;
			for (GRNPurchaseOrderBean grnPurchaseOrderBean : dtlList) {
				List<GRNPurchaseOrderBean> lSchGrnBean = jdbcTemplate.query(GRNQueryUtil.PO_SCHEDULE, new Object[] { grnPurchaseOrderBean.getDtlPODtlId() }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));
				List<GRNPurchaseOrderBean> lBatchGrnBean = jdbcTemplate.query(GRNQueryUtil.GET_GRN_BATCH_DTL, new Object[] { grnPurchaseOrderBean.getGrnDtlId() }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));

				grnPurchaseOrderBean.setScheduleList(lSchGrnBean);
				grnPurchaseOrderBean.setBatchDtls(lBatchGrnBean);
				grnPurchaseOrderBean.setSerialNumber(++serialNumber);
				double qty = grnPurchaseOrderBean.getDtlQty();
				double unitPrice = grnPurchaseOrderBean.getDtlPrice();
				double subTotal = 0;
				grnPurchaseOrderBean.setTotal(qty * unitPrice);
				double taxAmount = grnPurchaseOrderBean.getTaxCGST() + grnPurchaseOrderBean.getTaxSGST() + grnPurchaseOrderBean.getTaxIGST();
				double disAmnt = 0;
				if (grnPurchaseOrderBean.getDiscountPercentage() == 0) {
					// disAmnt = 0;
					disAmnt = grnPurchaseOrderBean.getDiscountAmount();
					double discountper = (disAmnt / grnPurchaseOrderBean.getTotal()) * 100;
					grnPurchaseOrderBean.setDiscountPercentage((int) discountper);

				}
				double amount = grnPurchaseOrderBean.getTotal() - grnPurchaseOrderBean.getDiscountAmount();

				// subTotal

				subTotal = subTotal + taxAmount + amount;
				grnPurchaseOrderBean.setSubTotal(subTotal);
				finalTotal = finalTotal + subTotal;
				grnPurchaseOrderBean.setFinalTotal(finalTotal);

				dtlDataList.add(grnPurchaseOrderBean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get GRN Detail List", e);
		}
		return dtlDataList;
	}

	private GRNBean getGrnPrintHeaderData(String grnCode) {
		GRNResultBean resultBean = new GRNResultBean();
		DecimalFormat df = new DecimalFormat("0.00");
		GRNBean objGRNBean = new GRNBean();
		List<GRNPurchaseOrderBean> dtlDataList = new ArrayList<>();

		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(GRNQueryUtil.GET_GRN_HDR_PRINT, new Object[] { grnCode });

			for (Map row : rows) {
				objGRNBean.setGrnId((int) row.get("grnId"));
				objGRNBean.setGrnCode((String) row.get("grnCode"));
				objGRNBean.setCompanyId((String) row.get("companyId"));
				objGRNBean.setGrnDate((String) row.get("grnDate"));
				objGRNBean.setPoId((int) row.get("poId"));
				objGRNBean.setPoNo((String) row.get("poNo"));
				objGRNBean.setPoAmendNo((String) row.get("poAmendNo"));
				objGRNBean.setConTransferNo((String) row.get("conTransferNo"));
				objGRNBean.setPoRequisitionId((String) row.get("poRequisitionId"));
				objGRNBean.setPoRequisition((String) row.get("poRequisition"));
				objGRNBean.setVendorId((int) row.get("vendorId"));
				objGRNBean.setVendorName((String) row.get("vendorName"));
				objGRNBean.setDelOrderNo((String) row.get("delOrderNo"));
				objGRNBean.setDelOrderDate((String) row.get("delOrderDate"));
				objGRNBean.setInvoiceNo((String) row.get("invoiceNo"));
				objGRNBean.setInvoiceDate((String) row.get("invoiceDate"));
				objGRNBean.setDeliveryMthd((int) row.get("deliveryMthd"));
				objGRNBean.setTransMode((int) row.get("transMode"));
				if (objGRNBean.getTransMode() == 1) {
					objGRNBean.setTransMod("Person");
				} else if (objGRNBean.getTransMode() == 2) {
					objGRNBean.setTransMod("Courier");

				} else {
					objGRNBean.setTransMod("Transport");

				}

				objGRNBean.setLocId((int) row.get("locId"));
				objGRNBean.setLocName((String) row.get("locName"));
				objGRNBean.setQcLocationId((int) row.get("qcLocationId"));
				objGRNBean.setQcLocationName((String) row.get("qcLocationName"));
				objGRNBean.setDstLocId((int) row.get("dstLocId"));
				objGRNBean.setDstLocName((String) row.get("dstLocName"));
				objGRNBean.setPoType((String) row.get("poType"));
				objGRNBean.setGrnStatus((int) row.get("grnStatus"));
				objGRNBean.setDueDate((String) row.get("dueDate"));
				// objGRNBean.setFreight((double) row.get("freight"));
				// objGRNBean.setOtherCharges((double) row.get("otherCharges"));
				objGRNBean.setFreight((double) row.get("grnfreight"));
				objGRNBean.setOtherCharges((double) row.get("grnOtherCharnge"));
				objGRNBean.setRemarksforother((CommonUtil.convertNullToEmpty((String) row.get("remarksforother"))));
				objGRNBean.setEntity((String) row.get("entity"));
				objGRNBean.setVendorName((String) row.get("vendorName"));
				objGRNBean.setVendorAddress((String) row.get("address"));
				objGRNBean.setVendorPhone((String) row.get("vendorPhone"));
				objGRNBean.setBudgetTypeName((String) row.get("project_name"));
				objGRNBean.setPreparedBy((String) row.get("first_name"));
				objGRNBean.setFreightTax((double) row.get("freightTax"));
				objGRNBean.setFreightAmount((double) row.get("freightAmount"));
				objGRNBean.setRemarks((String) row.get("remarks"));
				objGRNBean.setRemarksforother((String) row.get("remarks_othercharges"));
				objGRNBean.setVendorEmail((String) row.get("vendorEmail"));
				// objGRNBean.setFreight((String) row.get("freight"));

				// objGRNBean.setDueDate((String) row.get("duedate"));
				if (objGRNBean.getCompanyId().equalsIgnoreCase("C0009")) {
					objGRNBean.setOrganisationName("Lalaji Memorial Educational Society");
				} else {
					objGRNBean.setOrganisationName("Lalaji Memorial Omega International School");
				}
			}

			List<GRNPurchaseOrderBean> dtlList = jdbcTemplate.query(GRNQueryUtil.GET_GRN_DTL_PRINT, new Object[] { grnCode }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));
			int serialNumber = 0;
			double finalTotal = 0;
			double taxCGST = 0;
			double taxSGST = 0;
			double taxIGST = 0;
			double taxCGSTamnt = 0;
			double taxSGSTamnt = 0;
			double taxIGSTamnt = 0;
			double cgst = 0;
			double sgst = 0;
			double igst = 0;
			double sTotal = 0;
			double discount = 0;

			for (GRNPurchaseOrderBean grnPurchaseOrderBean : dtlList) {
				// List<GRNPurchaseOrderBean> lSchGrnBean =
				// jdbcTemplate.query(GRNQueryUtil.PO_SCHEDULE, new Object[] {
				// grnPurchaseOrderBean.getDtlPODtlId() }, new
				// BeanPropertyRowMapper<GRNPurchaseOrderBean>(GRNPurchaseOrderBean.class));
				// List<GRNPurchaseOrderBean> lBatchGrnBean =
				// jdbcTemplate.query(GRNQueryUtil.GET_GRN_BATCH_DTL, new
				// Object[] { grnPurchaseOrderBean.getGrnDtlId() }, new
				// BeanPropertyRowMapper<GRNPurchaseOrderBean>(GRNPurchaseOrderBean.class));

				// grnPurchaseOrderBean.setScheduleList(lSchGrnBean);
				// grnPurchaseOrderBean.setBatchDtls(lBatchGrnBean);

				grnPurchaseOrderBean.setSerialNumber(++serialNumber);
				double qty = grnPurchaseOrderBean.getDtlQty();
				double unitPrice = grnPurchaseOrderBean.getDtlPrice();
				double subTotal = 0;
				grnPurchaseOrderBean.setTotal(qty * unitPrice);

				double Price = grnPurchaseOrderBean.getTotal();
				grnPurchaseOrderBean.setPrice(Price);
				// double taxAmount = grnPurchaseOrderBean.getTaxCGST() +
				// grnPurchaseOrderBean.getTaxSGST() +
				// grnPurchaseOrderBean.getTaxIGST();

				// find Discount Percentage

				double disAmnt = 0;

				if (grnPurchaseOrderBean.getDiscountType() == 58) {
					grnPurchaseOrderBean.setDiscountAmount(Price * (grnPurchaseOrderBean.getDiscountPercentage() / 100));

				}
				// Disocunt Calc
				if (grnPurchaseOrderBean.getDiscountType() == 59) {
					double vendorQty = grnPurchaseOrderBean.getOriginalConvertedQty();
					double dtlQty = grnPurchaseOrderBean.getDtlQty();
					double discountAmount = grnPurchaseOrderBean.getDiscountAmount();
					double unitDiscount = discountAmount / vendorQty;
					double totaldis = unitDiscount * dtlQty;
					grnPurchaseOrderBean.setDiscountAmount(totaldis);
				}

				discount = discount + grnPurchaseOrderBean.getDiscountAmount();
				objGRNBean.setTotalDiscount(Double.parseDouble(df.format(discount)));

				double amount = grnPurchaseOrderBean.getTotal() - grnPurchaseOrderBean.getDiscountAmount();

				sTotal = sTotal + grnPurchaseOrderBean.getTotal();
				objGRNBean.setSubTotal(sTotal);
				grnPurchaseOrderBean.setTotal(Double.parseDouble(df.format(amount)));

				double quantity = 0;

				double Total = 0;
				taxCGST = 0;
				taxSGST = 0;
				taxIGST = 0;

				quantity = grnPurchaseOrderBean.getDtlQty();
				taxCGST = taxCGST + grnPurchaseOrderBean.getTaxCGSTinPercent();
				taxSGST = taxSGST + grnPurchaseOrderBean.getTaxSGSTinPercent();
				taxIGST = taxIGST + grnPurchaseOrderBean.getTaxIGSTinPercent();

				Total = amount;
				// taxCGSTamnt = 0;
				// taxSGSTamnt = 0;
				// taxIGSTamnt = 0;

				if (taxCGST != 0) {
					taxCGSTamnt = taxCGSTamnt + (Total * (taxCGST / 100));

					cgst = taxCGST + cgst;

				} else {
					taxCGSTamnt = 0;
				}
				if (taxSGST != 0) {
					taxSGSTamnt = taxSGSTamnt + (Total * (taxSGST / 100));

					sgst = taxSGST + sgst;
				} else {
					taxSGSTamnt = 0;
				}
				if (taxIGST != 0) {
					taxIGSTamnt = taxIGSTamnt + (Total * (taxIGST / 100));
					igst = taxIGST + igst;
				} else {
					taxIGSTamnt = 0;
				}
				// grnPurchaseOrderBean.setTaxCGST(taxCGSTamnt);
				// grnPurchaseOrderBean.setTaxSGST(taxSGSTamnt);
				// grnPurchaseOrderBean.setTaxIGST(taxIGSTamnt);

				grnPurchaseOrderBean.setRowTotal(Total + (Total * (grnPurchaseOrderBean.getTaxCGSTinPercent() / 100)) + (Total * (grnPurchaseOrderBean.getTaxSGSTinPercent() / 100)) + (Total * (grnPurchaseOrderBean.getTaxIGSTinPercent() / 100)));

				objGRNBean.setTaxCGSTinPercent(cgst);
				objGRNBean.setTaxSGSTinPercent(sgst);
				objGRNBean.setTaxIGSTinPercent(igst);
				if (taxCGSTamnt != 0) {
					objGRNBean.setTotalTaxCGST(Double.parseDouble(df.format(taxCGSTamnt)));

				}
				if (taxSGSTamnt != 0) {
					objGRNBean.setTotalTaxSGST(Double.parseDouble(df.format(taxSGSTamnt)));

				}
				if (taxIGSTamnt != 0) {
					objGRNBean.setTotalTaxIGST(Double.parseDouble(df.format(taxIGSTamnt)));

				}
				// Total = Total + objGRNBean.getFreight() +
				// objGRNBean.getOtherCharges();
				finalTotal = finalTotal + Total;
				// + objGRNBean.getTotalTaxCGST() + objGRNBean.getTotalTaxSGST()
				// + objGRNBean.getTotalTaxIGST();
				// finalTotal = finalTotal + finalTotal;
				// objGRNBean.setFinalTotal(finalTotal);
				dtlDataList.add(grnPurchaseOrderBean);

			}

			List<GRNBean> groupList = jdbcTemplate.query(GRNQueryUtil.GRN_GST_GROUP_BY, new Object[] { grnCode, grnCode, grnCode }, new BeanPropertyRowMapper<>(GRNBean.class));
			objGRNBean.setGroupList(groupList);
			objGRNBean.setfTotal(Double.parseDouble(df.format(finalTotal + objGRNBean.getFreight() + objGRNBean.getOtherCharges() + objGRNBean.getTotalTaxCGST() + objGRNBean.getTotalTaxSGST() + objGRNBean.getTotalTaxIGST())));

			double roundof = objGRNBean.getfTotal() - Math.floor(objGRNBean.getfTotal());
			System.out.println(roundof);
			objGRNBean.setRoundOf(roundof);
			objGRNBean.setFinalTotal(Math.round(Double.parseDouble(df.format(finalTotal + objGRNBean.getFreight() + objGRNBean.getOtherCharges() + objGRNBean.getTotalTaxCGST() + objGRNBean.getTotalTaxSGST() + objGRNBean.getTotalTaxIGST()))));

			String amountInWords = wordingConversion.convertToIndianCurrency(String.valueOf(Math.round(objGRNBean.getFinalTotal())));
			objGRNBean.setAmountinWords(amountInWords);
			objGRNBean.setGrnTables(dtlDataList);

		} catch (DataAccessException e) {
			LOGGER.error("Error in get GRN Header list", e);
		}
		return objGRNBean;
	}
}
