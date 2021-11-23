package com.dci.tenant.finance.purchaseInvoice;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.AccountsConstants;
import com.dci.common.util.CommonUtil;
import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.finance.generalpurchaseInvoice.GeneralPurchaseInvoiceQueryUtil;
import com.dci.tenant.user.UserDetail;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Repository
public class PurchaseInvoiceDAOImpl implements PurchaseInvoiceDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(PurchaseInvoiceController.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Override
	public List<PurchaseInvoiceHeaderBean> getSupplierList() throws CustomException {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<PurchaseInvoiceHeaderBean> supplierList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_SUPPLIER_LIST, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class));
			return supplierList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Supplier List", e);
			throw new CustomException("Error in Get Supplie List");
		}

	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getGrnList(String supplier) {
		List<PurchaseInvoiceHeaderBean> lgrnList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lgrnList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_GRN_LIST, new Object[] { supplier }, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in lgrnList", e);
		}
		return lgrnList;
	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getChargeList() {
		List<PurchaseInvoiceHeaderBean> lchargeList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lchargeList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_CHARGE_LIST, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in lgrnList", e);
		}
		return lchargeList;
	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getItemList() {
		List<PurchaseInvoiceHeaderBean> lItemList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lItemList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_ITEM_LIST, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in lgrnList", e);
		}
		return lItemList;
	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getCompanyList() throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<PurchaseInvoiceHeaderBean> companyList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_COMPANY_LIST, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class), userDetails.getCompanyCode());
			return companyList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
			throw new CustomException("Error in Get company List");
		}

	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getcostcenterlist() throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<PurchaseInvoiceHeaderBean> costList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_COST_LIST, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class));
			return costList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get costList ", e);
			throw new CustomException("Error in Get company List");
		}

	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getcostcenterlist1() throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<PurchaseInvoiceHeaderBean> costList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_COST_LIST_1, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class));
			return costList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get costList ", e);
			throw new CustomException("Error in Get company List");
		}

	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getPurchaseInvoiceList() throws CustomException {
		List<PurchaseInvoiceHeaderBean> lPurchaseInvList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lPurchaseInvList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_LIST, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Account Head Master", e);
			throw new CustomException("Error in Get Account Head Master");
		}
		return lPurchaseInvList;
	}

	@Override
	public boolean savePurchaseInvoice(PurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean) throws CustomException {
		boolean isSuccess = false;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String sInvoice = getInvoiceNo(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)), objPurchaseInvoiceHeaderBean);
			objPurchaseInvoiceHeaderBean.setPuchaseInvoiceNo(sInvoice);
			if (objPurchaseInvoiceHeaderBean.getPaymentStatus() != null) {
				if (objPurchaseInvoiceHeaderBean.getPaymentStatus().isEmpty())
					objPurchaseInvoiceHeaderBean.setPaymentStatus("Not Paid");
				else
					objPurchaseInvoiceHeaderBean.setPaymentStatus(objPurchaseInvoiceHeaderBean.getPaymentStatus());
			} else
				objPurchaseInvoiceHeaderBean.setPaymentStatus("Not Paid");

			int iTemp = 0;
			if (objPurchaseInvoiceHeaderBean.getGrnNo() > 0) {
				iTemp = jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_PURCHASE_INVOICE_LIST,
						new Object[] { objPurchaseInvoiceHeaderBean.getPotype(), objPurchaseInvoiceHeaderBean.getBudgetType(), objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo(), CommonUtil.convertSqlDateFormat(objPurchaseInvoiceHeaderBean.getPuchaseInvoiceDate()), objPurchaseInvoiceHeaderBean.getSupplier(), CommonUtil.convertSqlDateFormat(objPurchaseInvoiceHeaderBean.getDueDate()), objPurchaseInvoiceHeaderBean.getDescription(), objPurchaseInvoiceHeaderBean.getPartyInvoiceNo(),
								CommonUtil.convertSqlDateFormat(objPurchaseInvoiceHeaderBean.getPartyInvoiceDate()), objPurchaseInvoiceHeaderBean.getCurrency(), objPurchaseInvoiceHeaderBean.getExchangeRate(), userId, objPurchaseInvoiceHeaderBean.getCompany(), objPurchaseInvoiceHeaderBean.getGrnNo(), objPurchaseInvoiceHeaderBean.getAmount(), objPurchaseInvoiceHeaderBean.getTcamount(), objPurchaseInvoiceHeaderBean.getBcamount(), objPurchaseInvoiceHeaderBean.getPaymentStatus(), objPurchaseInvoiceHeaderBean.getCostCenter(),
								objPurchaseInvoiceHeaderBean.getTotalTaxPo() });
			} else {

				iTemp = jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_PURCHASE_INVOICE_LIST, new Object[] { objPurchaseInvoiceHeaderBean.getPotype(), objPurchaseInvoiceHeaderBean.getBudgetType(), objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo(), CommonUtil.convertSqlDateFormat(objPurchaseInvoiceHeaderBean.getPuchaseInvoiceDate()), objPurchaseInvoiceHeaderBean.getSupplier(), CommonUtil.convertSqlDateFormat(objPurchaseInvoiceHeaderBean.getDueDate()), objPurchaseInvoiceHeaderBean.getDescription(), objPurchaseInvoiceHeaderBean.getPartyInvoiceNo(),
						CommonUtil.convertSqlDateFormat(objPurchaseInvoiceHeaderBean.getPartyInvoiceDate()), objPurchaseInvoiceHeaderBean.getCurrency(), objPurchaseInvoiceHeaderBean.getExchangeRate(), userId, objPurchaseInvoiceHeaderBean.getCompany(), null, objPurchaseInvoiceHeaderBean.getAmount(), objPurchaseInvoiceHeaderBean.getTcamount(), objPurchaseInvoiceHeaderBean.getBcamount(), objPurchaseInvoiceHeaderBean.getPaymentStatus(), objPurchaseInvoiceHeaderBean.getCostCenter(), objPurchaseInvoiceHeaderBean.getTotalTaxPo() });
			}

			if (iTemp > 0) {
				isSuccess = savePurchaseInvoiceDetail(objPurchaseInvoiceHeaderBean);
				isSuccess = savePurchaseInvoiceDetailaccthead(objPurchaseInvoiceHeaderBean);

				isSuccess = savePurchaseInvoiceProductDetail(objPurchaseInvoiceHeaderBean);
			}

			if (isSuccess) {
				isSuccess = insertGeneralLedgerheader(objPurchaseInvoiceHeaderBean);
				// isSuccess =
				// insertGeneralLedgerProductDetail(objPurchaseInvoiceHeaderBean);
				// isSuccess =
				// insertGeneralLedgerProductTaxDetail(objPurchaseInvoiceHeaderBean);
				// isSuccess =
				// insertGeneralLedgerChargeDetail(objPurchaseInvoiceHeaderBean);
			}

		} catch (Exception e) {
			LOGGER.error("Error in saving purchase invoice", e);
			throw new CustomException("Error in saving purchase invoice");
		}

		return isSuccess;

	}

	public boolean savePurchaseInvoiceDetail(PurchaseInvoiceHeaderBean objPurchaseInvoiceListBean) {

		try {
			List<PurchaseInvoiceDetailBean> alDetailList = objPurchaseInvoiceListBean.getPurchaseInvoiceDetail();
			for (PurchaseInvoiceDetailBean objPurchaseInvoiceDetailBean : alDetailList) {
				if (objPurchaseInvoiceDetailBean.getAccountHeadCode() != null && objPurchaseInvoiceDetailBean.getAccountHeadCode() != "") {
					objPurchaseInvoiceDetailBean.setSubGrpCode(objPurchaseInvoiceDetailBean.getAccountHeadCode().substring(0, 4));
					if (objPurchaseInvoiceDetailBean.getShortDetail() == null || objPurchaseInvoiceDetailBean.getShortDetail().equalsIgnoreCase("")) {
						objPurchaseInvoiceDetailBean.setShortDetail("TEST");
					}
					JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

					jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_PURCHASE_INVOICE_DTL, new Object[] { objPurchaseInvoiceListBean.getPuchaseInvoiceNo(), objPurchaseInvoiceDetailBean.getShortDetail(), objPurchaseInvoiceDetailBean.getSubGrpCode(), objPurchaseInvoiceDetailBean.getSiNo(), objPurchaseInvoiceDetailBean.getAccountHeadCode(), objPurchaseInvoiceDetailBean.getAmount(), objPurchaseInvoiceDetailBean.getEmployeeCode(), objPurchaseInvoiceDetailBean.getDepartmentCode(), objPurchaseInvoiceDetailBean.getCountryCode(),
							objPurchaseInvoiceDetailBean.getCustomerCode(), objPurchaseInvoiceDetailBean.getSupplierCode(), objPurchaseInvoiceDetailBean.getDesignationCode(), objPurchaseInvoiceDetailBean.getCompanyCode(), objPurchaseInvoiceDetailBean.getAssetCode(), objPurchaseInvoiceDetailBean.getCostCenter() });
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	public boolean savePurchaseInvoiceDetailaccthead(PurchaseInvoiceHeaderBean objPurchaseInvoiceListBean) {

		try {
			List<PurchaseInvoiceDetailBean> alDetailListhead = objPurchaseInvoiceListBean.getPurchaseInvoiceDetailacct();
			for (PurchaseInvoiceDetailBean objPurchaseInvoiceDetailBean : alDetailListhead) {
				if (objPurchaseInvoiceDetailBean.getAhaccountHeadCode() != null && objPurchaseInvoiceDetailBean.getAhaccountHeadCode() != "") {
					objPurchaseInvoiceDetailBean.setSubGrpCode(objPurchaseInvoiceDetailBean.getAhaccountHeadCode().substring(0, 4));
					if (objPurchaseInvoiceDetailBean.getAhshortDetail() == null || objPurchaseInvoiceDetailBean.getAhshortDetail().equalsIgnoreCase("")) {
						objPurchaseInvoiceDetailBean.setAhshortDetail("TEST");
					}
					JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

					jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_PURCHASE_INVOICE_DTL_HEAD, new Object[] { objPurchaseInvoiceListBean.getPuchaseInvoiceNo(), objPurchaseInvoiceDetailBean.getAhshortDetail(), objPurchaseInvoiceDetailBean.getSubGrpCode(), objPurchaseInvoiceDetailBean.getSiNo(), objPurchaseInvoiceDetailBean.getAhaccountHeadCode(), objPurchaseInvoiceDetailBean.getAhamount(), objPurchaseInvoiceDetailBean.getEmployeeCode(), objPurchaseInvoiceDetailBean.getDepartmentCode(), objPurchaseInvoiceDetailBean.getCountryCode(),
							objPurchaseInvoiceDetailBean.getCustomerCode(), objPurchaseInvoiceDetailBean.getSupplierCode(), objPurchaseInvoiceDetailBean.getDesignationCode(), objPurchaseInvoiceDetailBean.getCompanyCode(), objPurchaseInvoiceDetailBean.getAssetCode(), objPurchaseInvoiceDetailBean.getCostCenter() });

					jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_GL_ACCT_HEAD, new Object[] { objPurchaseInvoiceListBean.getPuchaseInvoiceNo() });

				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	public boolean savePurchaseInvoiceProductDetail(PurchaseInvoiceHeaderBean objPurchaseInvoiceListBean) {

		try {
			List<PurchaseInvoiceProductDetailBean> alProductDetailList = objPurchaseInvoiceListBean.getPurchaseInvoiceProdDetail();
			for (PurchaseInvoiceProductDetailBean objPurchaseInvoiceProductDetailBean : alProductDetailList) {

				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_PURCHASE_INVOICE_PROD_DTL,
						new Object[] { objPurchaseInvoiceListBean.getPuchaseInvoiceNo(), objPurchaseInvoiceProductDetailBean.getSiNo(), objPurchaseInvoiceProductDetailBean.getItemId(), objPurchaseInvoiceProductDetailBean.getQuantity(), objPurchaseInvoiceProductDetailBean.getUnitprice(), objPurchaseInvoiceProductDetailBean.getAmount(), objPurchaseInvoiceProductDetailBean.getCostdtl(), objPurchaseInvoiceProductDetailBean.getUnitTaxAmount(), objPurchaseInvoiceProductDetailBean.getUnitDiscountAmount(), objPurchaseInvoiceProductDetailBean.getTaxAmount(),
								objPurchaseInvoiceProductDetailBean.getDiscountAmount(), objPurchaseInvoiceProductDetailBean.getTaxAmount(), objPurchaseInvoiceListBean.getEmployeeCode(), objPurchaseInvoiceListBean.getDepartmentCode(), objPurchaseInvoiceListBean.getCountryCode(), objPurchaseInvoiceListBean.getCustomerCode(), objPurchaseInvoiceListBean.getSupplierCode(), objPurchaseInvoiceListBean.getDesignationCode(), objPurchaseInvoiceListBean.getCompanyCode(), objPurchaseInvoiceListBean.getAssetCode(), objPurchaseInvoiceListBean.getTotalTaxPo() });
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	public boolean updatePurchaseInvoiceDetail(PurchaseInvoiceHeaderBean objPurchaseInvoiceListBean) {

		try {
			List<PurchaseInvoiceDetailBean> alProductDetailList = objPurchaseInvoiceListBean.getPurchaseInvoiceDetail();
			for (PurchaseInvoiceDetailBean objdelbean : alProductDetailList) {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				jdbcTemplate.update(PurchaseInvoiceQueryUtil.updatePurchaseInvoiceDtl, new Object[] { objdelbean.getEmployeeCode(), objdelbean.getCountryCode(), objdelbean.getCustomerCode(), objdelbean.getSupplierCode(), objdelbean.getDesignationCode(), objdelbean.getCompanyCode(), objdelbean.getAssetCode(), objdelbean.getDepartmentCode(), objdelbean.getCostCenter(), objdelbean.getPurDtlId() });
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	public boolean updatePurchaseInvoiceDetailAcct(PurchaseInvoiceHeaderBean objPurchaseInvoiceListBean) {

		try {
			List<PurchaseInvoiceDetailBean> alProductDetailListacct = objPurchaseInvoiceListBean.getPurchaseInvoiceDetailacct();
			for (PurchaseInvoiceDetailBean objdelbean : alProductDetailListacct) {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				jdbcTemplate.update(PurchaseInvoiceQueryUtil.updatePurchaseInvoiceDtl_Acct, new Object[] { objdelbean.getEmployeeCode(), objdelbean.getCountryCode(), objdelbean.getCustomerCode(), objdelbean.getSupplierCode(), objdelbean.getDesignationCode(), objdelbean.getCompanyCode(), objdelbean.getAssetCode(), objdelbean.getDepartmentCode(), objdelbean.getCostCenter(), objdelbean.getPurDtlId() });
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	public boolean updatePurchaseInvoiceProductDetail(PurchaseInvoiceHeaderBean objPurchaseInvoiceListBean) {

		try {
			List<PurchaseInvoiceProductDetailBean> alProductDetailList = objPurchaseInvoiceListBean.getPurchaseInvoiceProdDetail();

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			jdbcTemplate.update(PurchaseInvoiceQueryUtil.updatePurchaseInvoiceProductDtl,

					new Object[] { objPurchaseInvoiceListBean.getEmployeeCode(), objPurchaseInvoiceListBean.getCountryCode(), objPurchaseInvoiceListBean.getCustomerCode(), objPurchaseInvoiceListBean.getSupplierCode(), objPurchaseInvoiceListBean.getDesignationCode(), objPurchaseInvoiceListBean.getCompanyCode(), objPurchaseInvoiceListBean.getAssetCode(), objPurchaseInvoiceListBean.getDepartmentCode(), objPurchaseInvoiceListBean.getPuchaseInvoiceNo() });

		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;

	}

	public String getInvoiceNo(String fullYear, PurchaseInvoiceHeaderBean bean) throws CustomException, ParseException {
		String sInvoiceNo = "";
		DateFormat formatter;
		String sCurrentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

		formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
			date = formatter.parse(bean.getPuchaseInvoiceDate());

			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String Gidate = df.format(date);
			sCurrentYear = Gidate.substring(2);

			String sDefaultInv = "PIN" + sCurrentYear + "00001";
			String sInvYear = "PIN" + sCurrentYear + "%";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			sInvoiceNo = jdbcTemplate.queryForObject(PurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_NO, String.class, sDefaultInv, sInvYear);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return sInvoiceNo;
	}

	public String getGPIInvoiceNo(String fullYear) throws CustomException {
		String sInvoiceNo = "";
		try {
			String sCurrentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			sCurrentYear = sCurrentYear.substring(2);

			String sDefaultInv = "GPI" + sCurrentYear + "00001";
			String sInvYear = "GPI" + sCurrentYear + "%";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// sInvoiceNo =
			// jdbcTemplate.queryForObject(PurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_NO,
			// String.class, sDefaultInv, sInvYear);
			sInvoiceNo = jdbcTemplate.queryForObject(GeneralPurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_NO, String.class, sDefaultInv, sInvYear);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return sInvoiceNo;
	}

	private boolean insertGeneralLedgerheader(PurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_GENERAL_LEDGER_HDR,
			// new Object[] { objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo()
			// });
			jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_GENERAL_LEDGER_HDR, new Object[] { objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo() });

		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	private boolean insertGeneralLedgerChargeDetail(PurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_GENERAL_LEDGER_CHARGE_DTL,
			// new Object[] { objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo()
			// });
			// jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_GENERAL_LEDGER_DEBITCHARGE_DTL,
			// new Object[] { objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo()
			// });

			jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_GENERAL_LEDGER_CHARGE_DTL, new Object[] { objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo() });

		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	private boolean insertGeneralLedgerProductDetail(PurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_GENERAL_LEDGER_PRODUCT_DTL,
			// new Object[] { objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo()
			// });
			jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_GENERAL_LEDGER_PRODUCT_DTL, new Object[] { objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo() });

		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	private boolean insertGeneralLedgerProductTaxDetail(PurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			PurchaseInvoiceHeaderBean headerBean = new PurchaseInvoiceHeaderBean();
			try {

				if (objPurchaseInvoiceHeaderBean.getTaxAccountList().size() > 0) {
					for (PurchaseInvoiceProductDetailBean detailBean : objPurchaseInvoiceHeaderBean.getTaxAccountList()) {

						String parentCode = Integer.toString(detailBean.getTaxAccountId());

						parentCode = parentCode.substring(0, 4);

						jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_GENERAL_LEDGER_PRODUCT_TAX_DTL_ID, new Object[] { CommonUtil.convertSqlDateFormat(objPurchaseInvoiceHeaderBean.getPuchaseInvoiceDate()), detailBean.getTaxAccountId(), objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo(), 0.0, objPurchaseInvoiceHeaderBean.getAmount(), 0.0, objPurchaseInvoiceHeaderBean.getAmount(), "Purchase Tax", "INR", 1, objPurchaseInvoiceHeaderBean.getCompany(), parentCode, detailBean.getItemId(), headerBean.getCostCenter(), userDetails.getUserId() });

					}
				} else {
					List<PurchaseInvoiceProductDetailBean> alProductDetailList = objPurchaseInvoiceHeaderBean.getPurchaseInvoiceProdDetail();
					if (alProductDetailList.size() > 0) {
						String parentCode = "40010024";

						parentCode = parentCode.substring(0, 4);
						for (PurchaseInvoiceProductDetailBean detailBean : alProductDetailList) {
							jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_GENERAL_LEDGER_PRODUCT_TAX_DTL_ID, new Object[] { CommonUtil.convertSqlDateFormat(objPurchaseInvoiceHeaderBean.getPuchaseInvoiceDate()), 40010024, objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo(), 0.0, objPurchaseInvoiceHeaderBean.getAmount(), 0.0, objPurchaseInvoiceHeaderBean.getAmount(), "Purchase Tax", "INR", 1, objPurchaseInvoiceHeaderBean.getCompany(), parentCode, detailBean.getItemId(), headerBean.getCostCenter(), userDetails.getUserId() });
						}
					}

				}

			}

			catch (DataAccessException e) {
				LOGGER.error("Error in getJvAccountDetail list", e);
			}
			// }

		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	// yet to done
	public List<PurchaseInvoiceDetailBean> getPurchaseInvDtlList(String purchaseInvoiceNo) throws CustomException {
		List<PurchaseInvoiceDetailBean> lChargeList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lChargeList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_LIST, new BeanPropertyRowMapper<>(PurchaseInvoiceDetailBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Account Head Master", e);
			throw new CustomException("Error in Get Account Head Master");
		}
		return lChargeList;
	}

	@Override
	public boolean deletePurchaseInvoice(String invoiceNo) throws CustomException {

		boolean isDeleted = false;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int iPurItem = jdbcTemplate.update(PurchaseInvoiceQueryUtil.deletePurchaseItemInvoiceDtl, invoiceNo);
			int iPurInv = jdbcTemplate.update(PurchaseInvoiceQueryUtil.deletePurchaseInvoiceDtl, invoiceNo);
			int rowGL = jdbcTemplate.update(PurchaseInvoiceQueryUtil.DELETE_GENERAL_LEDGER, new Object[] { invoiceNo });

			int iPurHdr = jdbcTemplate.update(PurchaseInvoiceQueryUtil.deletePurchaseInvoiceHdr, invoiceNo);
			if (iPurHdr > 0)
				isDeleted = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete Purchase Invoice", e);
		}

		return isDeleted;
	}

	@Override
	public PurchaseInvoiceHeaderBean getPurchaseInvoiceDetail(String sPurchaseInvoiceNo) {
		PurchaseInvoiceHeaderBean objPurchaseInvoiceListBean = new PurchaseInvoiceHeaderBean();
		try {
			objPurchaseInvoiceListBean = getPurchaseInvoiceHeaderDetail(sPurchaseInvoiceNo);

			List<PurchaseInvoiceDetailBean> lDetailList = new ArrayList<>();

			lDetailList = getPurchaseInvoiceDetailList(sPurchaseInvoiceNo);
			objPurchaseInvoiceListBean.setPurchaseInvoiceDetail(lDetailList);
			List<PurchaseInvoiceProductDetailBean> lProductDetailList = new ArrayList<>();

			lProductDetailList = getPurchaseInvoiceProcuctDetailList(sPurchaseInvoiceNo);
			objPurchaseInvoiceListBean.setPurchaseInvoiceProdDetail(lProductDetailList);

			List<PurchaseInvoiceDetailBean> lacctList = new ArrayList<>();

			lacctList = getPurchaseInvoiceDetailListAcct(sPurchaseInvoiceNo);
			objPurchaseInvoiceListBean.setPurchaseInvoiceDetailacct(lacctList);
		} catch (CustomException e) {
			LOGGER.error("Error in Get getPurchaseInvoiceDetail List", e);
		}

		return objPurchaseInvoiceListBean;
	}

	private PurchaseInvoiceHeaderBean getPurchaseInvoiceHeaderDetail(String sPurchaseInvoiceNo) {
		PurchaseInvoiceHeaderBean objPurchaseInvoiceListBean = new PurchaseInvoiceHeaderBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			objPurchaseInvoiceListBean = jdbcTemplate.queryForObject(PurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_HDR, new Object[] { sPurchaseInvoiceNo }, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getJvAccountDetail list", e);
		}
		return objPurchaseInvoiceListBean;
	}

	public List<PurchaseInvoiceDetailBean> getPurchaseInvoiceDetailList(String purchaseInvoiceNo) throws CustomException {
		List<PurchaseInvoiceDetailBean> dtlDataList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			dtlDataList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_DTL, new Object[] { purchaseInvoiceNo }, new BeanPropertyRowMapper<>(PurchaseInvoiceDetailBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Account Head Master", e);
			throw new CustomException("Error in Get Account Head Master");
		}
		return dtlDataList;
	}

	public List<PurchaseInvoiceDetailBean> getPurchaseInvoiceDetailListAcct(String purchaseInvoiceNo) throws CustomException {
		List<PurchaseInvoiceDetailBean> dtlDataList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			dtlDataList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_DTL_ACCT, new Object[] { purchaseInvoiceNo }, new BeanPropertyRowMapper<>(PurchaseInvoiceDetailBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Account Head Master", e);
			throw new CustomException("Error in Get Account Head Master");
		}
		return dtlDataList;
	}

	public List<PurchaseInvoiceProductDetailBean> getPurchaseInvoiceProcuctDetailList(String purchaseInvoiceNo) throws CustomException {
		List<PurchaseInvoiceProductDetailBean> lProductDtlList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lProductDtlList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_PURCHASE_PROD_INVOICE_DTL, new Object[] { purchaseInvoiceNo }, new BeanPropertyRowMapper<>(PurchaseInvoiceProductDetailBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getPurchaseInvoiceProcuctDetail", e);
			throw new CustomException("Error in getPurchaseInvoiceProcuctDetail");
		}
		return lProductDtlList;
	}

	@Override
	public boolean updatePurchaseInvoice(PurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean) {
		boolean isSuccess = false;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		int iTemp = 0;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (objPurchaseInvoiceHeaderBean.getGrnNo() == 0) {
				iTemp = jdbcTemplate.update(PurchaseInvoiceQueryUtil.sUpdatePurchaseInvoice, new Object[] { objPurchaseInvoiceHeaderBean.getPotype(), objPurchaseInvoiceHeaderBean.getBudgetType(), objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo(), CommonUtil.convertSqlDateFormat(objPurchaseInvoiceHeaderBean.getPuchaseInvoiceDate()), objPurchaseInvoiceHeaderBean.getSupplier(), CommonUtil.convertSqlDateFormat(objPurchaseInvoiceHeaderBean.getDueDate()), objPurchaseInvoiceHeaderBean.getDescription(), objPurchaseInvoiceHeaderBean.getPartyInvoiceNo(),
						CommonUtil.convertSqlDateFormat(objPurchaseInvoiceHeaderBean.getPartyInvoiceDate()), objPurchaseInvoiceHeaderBean.getCurrency(), objPurchaseInvoiceHeaderBean.getExchangeRate(), userId, objPurchaseInvoiceHeaderBean.getCompany(), null, objPurchaseInvoiceHeaderBean.getAmount(), objPurchaseInvoiceHeaderBean.getTcamount(), objPurchaseInvoiceHeaderBean.getBcamount(), objPurchaseInvoiceHeaderBean.getCostCenter(), objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo() });
			} else {
				iTemp = jdbcTemplate.update(PurchaseInvoiceQueryUtil.sUpdatePurchaseInvoice, new Object[] { objPurchaseInvoiceHeaderBean.getPotype(), objPurchaseInvoiceHeaderBean.getBudgetType(), objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo(), CommonUtil.convertSqlDateFormat(objPurchaseInvoiceHeaderBean.getPuchaseInvoiceDate()), objPurchaseInvoiceHeaderBean.getSupplier(), CommonUtil.convertSqlDateFormat(objPurchaseInvoiceHeaderBean.getDueDate()), objPurchaseInvoiceHeaderBean.getDescription(), objPurchaseInvoiceHeaderBean.getPartyInvoiceNo(),
						CommonUtil.convertSqlDateFormat(objPurchaseInvoiceHeaderBean.getPartyInvoiceDate()), objPurchaseInvoiceHeaderBean.getCurrency(), objPurchaseInvoiceHeaderBean.getExchangeRate(), userId, objPurchaseInvoiceHeaderBean.getCompany(), objPurchaseInvoiceHeaderBean.getGrnNo(), objPurchaseInvoiceHeaderBean.getAmount(), objPurchaseInvoiceHeaderBean.getTcamount(), objPurchaseInvoiceHeaderBean.getBcamount(), objPurchaseInvoiceHeaderBean.getCostCenter(), objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo() });
			}
			isSuccess = updatePurchaseInvoiceProductDetail(objPurchaseInvoiceHeaderBean);
			isSuccess = updatePurchaseInvoiceDetail(objPurchaseInvoiceHeaderBean);
			isSuccess = updatePurchaseInvoiceDetailAcct(objPurchaseInvoiceHeaderBean);

		} catch (Exception e) {
			LOGGER.error("Error in Add Account Head Master", e);
		}

		return true;
	}

	@Override
	public PurchaseInvoiceHeaderBean getGrnDetail(int igrnId) {
		PurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean = new PurchaseInvoiceHeaderBean();
		List<PurchaseInvoiceProductDetailBean> alProductDetailList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			objPurchaseInvoiceHeaderBean = jdbcTemplate.queryForObject(PurchaseInvoiceQueryUtil.GET_GRN_HDR, new Object[] { igrnId }, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class));
			alProductDetailList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_GRN_DTL, new Object[] { igrnId }, new BeanPropertyRowMapper<>(PurchaseInvoiceProductDetailBean.class));
			for (PurchaseInvoiceProductDetailBean obInvoiceProductDetailBean : alProductDetailList) {
				String ids = obInvoiceProductDetailBean.getTaxCode();
				if (ids.contains(",")) {
					String taxIds[] = ids.split(",");
					for (String txId : taxIds) {
						obInvoiceProductDetailBean.getTaxIdslist().add(txId);
					}
				} else {
					obInvoiceProductDetailBean.getTaxIdslist().add(ids);
				}

			}
			objPurchaseInvoiceHeaderBean.setPurchaseInvoiceProdDetail(alProductDetailList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Account Head Master", e);
		}
		return objPurchaseInvoiceHeaderBean;
	}

	@Override
	public PurchaseInvoiceHeaderBean checkFreightCharges(int igrnId) {
		PurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean = new PurchaseInvoiceHeaderBean();
		List<PurchaseInvoiceProductDetailBean> alProductDetailList = new ArrayList<>();
		List<PurchaseInvoiceProductDetailBean> checkGrnList = new ArrayList<>();
		List<PurchaseInvoiceHeaderBean> grnIdList = new ArrayList<>();
		try {

			double frieghtValue = 0, poTotalAmount = 0;
			int purchaseOrderId = 0;
			double totalChargesValue = 0;

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			checkGrnList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.CHECK_FRIEGHT_VALUE, new Object[] { igrnId }, new BeanPropertyRowMapper<>(PurchaseInvoiceProductDetailBean.class));

			for (PurchaseInvoiceProductDetailBean dtlbean : checkGrnList) {
				frieghtValue = dtlbean.getFrieghtTotal();
				purchaseOrderId = dtlbean.getPurchaseOrderId();
				poTotalAmount = dtlbean.getPoTotalAmount();

			}
			if (purchaseOrderId > 0) {
				grnIdList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_GRNID_LIST, new Object[] { purchaseOrderId }, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class));

			}
			for (PurchaseInvoiceHeaderBean grnIdbean : grnIdList) {
				double chargeValue = 0;
				chargeValue = jdbcTemplate.queryForObject(PurchaseInvoiceQueryUtil.GET_TOTAL_CHARGES_LIST, Integer.class, new Object[] { grnIdbean.getGrnNo() });
				totalChargesValue = totalChargesValue + chargeValue;

			}

			frieghtValue = frieghtValue - totalChargesValue;

			objPurchaseInvoiceHeaderBean.setFrieghtTotal(frieghtValue);
			objPurchaseInvoiceHeaderBean.setPoTotalAmount(poTotalAmount);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Account Head Master", e);
		}
		return objPurchaseInvoiceHeaderBean;
	}

	@Override
	public PurchaseInvoiceHeaderBean getEditcheckFreightCharges(int igrnId) {
		PurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean = new PurchaseInvoiceHeaderBean();
		List<PurchaseInvoiceProductDetailBean> alProductDetailList = new ArrayList<>();
		List<PurchaseInvoiceProductDetailBean> checkGrnList = new ArrayList<>();
		List<PurchaseInvoiceHeaderBean> grnIdList = new ArrayList<>();
		try {

			double frieghtValue = 0, poTotalAmount = 0;
			int purchaseOrderId = 0;
			double totalChargesValue = 0;

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			checkGrnList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.CHECK_FRIEGHT_VALUE, new Object[] { igrnId }, new BeanPropertyRowMapper<>(PurchaseInvoiceProductDetailBean.class));

			for (PurchaseInvoiceProductDetailBean dtlbean : checkGrnList) {
				frieghtValue = dtlbean.getFrieghtTotal();
				poTotalAmount = dtlbean.getPoTotalAmount();
				purchaseOrderId = dtlbean.getPurchaseOrderId();
			}
			if (purchaseOrderId > 0) {
				grnIdList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_GRNID_LIST, new Object[] { purchaseOrderId }, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class));

			}
			for (PurchaseInvoiceHeaderBean grnIdbean : grnIdList) {
				double chargeValue = 0;
				if (igrnId != grnIdbean.getGrnNo()) {
					chargeValue = jdbcTemplate.queryForObject(PurchaseInvoiceQueryUtil.GET_TOTAL_CHARGES_LIST, Integer.class, new Object[] { grnIdbean.getGrnNo() });
					totalChargesValue = totalChargesValue + chargeValue;
				}

			}

			frieghtValue = frieghtValue - totalChargesValue;

			objPurchaseInvoiceHeaderBean.setFrieghtTotal(frieghtValue);
			objPurchaseInvoiceHeaderBean.setPoTotalAmount(poTotalAmount);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Account Head Master", e);
		}
		return objPurchaseInvoiceHeaderBean;
	}

	@Override
	public boolean exportToPurchaseInvoicePdf(String puchaseInvoiceNo, ServletContext context) {
		boolean isGenerated = false;
		Connection conn = null;
		try {
			String contextPath = getAbsoluteFilePath(AccountsConstants.PURCHASE_INVOICE_JASPER_REPORT);
			String images = context.getRealPath(AccountsConstants.IMAGE_PATH);
			String pdfFile = context.getRealPath(AccountsConstants.TEMPDOC_PATH);

			conn = dataSource.getConnection();
			if (pdfFile != null) {
				File file = new File(pdfFile + AccountsConstants.PURCHASE_INVOICE_PDF);
				if (file.createNewFile()) {
				} else {
					file.delete();
				}
			}
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("pInvNo", puchaseInvoiceNo);
			parameters.put("realPath", images);
			pdfFile = pdfFile + AccountsConstants.PURCHASE_INVOICE_PDF;
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
	public PurchaseInvoiceHeaderBean getExchangeRates(String currencyCode) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		PurchaseInvoiceHeaderBean resultBean = new PurchaseInvoiceHeaderBean();
		List<PurchaseInvoiceHeaderBean> exchangeRatelist = new ArrayList<>();
		try {

			exchangeRatelist = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GETEXCHANGERATE, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class), currencyCode);
			resultBean.setExchangeRatelist(exchangeRatelist);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Parent Address", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return resultBean;

	}

	@Override
	public PurchaseInvoiceHeaderBean getCurrencyCode(String supplierAcctCode) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		PurchaseInvoiceHeaderBean resultBean = new PurchaseInvoiceHeaderBean();
		List<PurchaseInvoiceHeaderBean> currencyCodelist = new ArrayList<>();
		try {
			currencyCodelist = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GETCURRENCYCODE, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class), supplierAcctCode);
			resultBean.setCurrencyList(currencyCodelist);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Parent Address", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return resultBean;

	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getBankAcctListcompanycode(String company) {
		List<PurchaseInvoiceHeaderBean> lBankAcctListcompany = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);
			if (company.equalsIgnoreCase("ALL")) {
				lBankAcctListcompany = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_COMPANY_COST_ALL, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class));

			} else {
				lBankAcctListcompany = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_COMPANY_COST, new Object[] { company }, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class));

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lBankAcctListcompany;
	}

	@Override
	public List<PurchaseInvoiceHeaderBean> grnNo(Integer grnNo) {
		List<PurchaseInvoiceHeaderBean> lBankAcctListcompany = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lBankAcctListcompany = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_GRN, new Object[] { grnNo }, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lBankAcctListcompany;
	}

	@Override
	public PurchaseInvoiceHeaderBean budpo(Integer grnNo) {
		PurchaseInvoiceHeaderBean lBankAcctListcompany = new PurchaseInvoiceHeaderBean();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);
			String str = String.valueOf(grnNo);
			int i = jdbcTemplate.queryForObject(PurchaseInvoiceQueryUtil.grn, new Object[] { grnNo }, (Integer.class));

			lBankAcctListcompany.setPotype(jdbcTemplate.queryForObject(PurchaseInvoiceQueryUtil.po, new Object[] { i }, (String.class)));
			lBankAcctListcompany.setBudgetType(jdbcTemplate.queryForObject(PurchaseInvoiceQueryUtil.bud, new Object[] { i }, (String.class)));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lBankAcctListcompany;
	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getgrnsupplier(String supplier) {
		List<PurchaseInvoiceHeaderBean> lBankAcctListcompany = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lBankAcctListcompany = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_SUpplier_GRN, new Object[] { supplier }, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lBankAcctListcompany;
	}

	@Override
	public boolean checkComSupCost(String company, String supplier, String costCenter) {
		boolean isValid = false;
		try {
			int countCompany = jdbcTemplate.queryForObject(PurchaseInvoiceQueryUtil.CHK_Company, Integer.class, company );
			int countSupplier = jdbcTemplate.queryForObject(PurchaseInvoiceQueryUtil.CHK_Supplier,  Integer.class, supplier );
			int countCostCenter = jdbcTemplate.queryForObject(PurchaseInvoiceQueryUtil.CHK_CostCenter, Integer.class , costCenter );
			if (countCompany > 0 && countSupplier > 0 && countCostCenter > 0)
				isValid = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}

	@Override
	public HashMap<String, String> getCompany() {
		HashMap<String, String> map = new HashMap<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseInvoiceQueryUtil.GET_Company_LIST);
			for (Map row : rows) {
				map.put(String.valueOf(row.get("company_name")), String.valueOf(row.get("company_id")));
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getCharges", e);
		}
		return map;
	}

	@Override
	public HashMap<String, String> getSupplier() {
		HashMap<String, String> map = new HashMap<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseInvoiceQueryUtil.GET_Supplier_LIST);
			for (Map row : rows) {
				map.put(String.valueOf(row.get("entity_name")), String.valueOf(row.get("entity_id")));
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getCharges", e);
		}
		return map;
	}

	@Override
	public HashMap<String, String> getCostCenter() {
		HashMap<String, String> map = new HashMap<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseInvoiceQueryUtil.GET_cost_center_LIST);
			for (Map row : rows) {
				map.put(String.valueOf(row.get("cost_center_name")), String.valueOf(row.get("cost_center_id")));
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getCharges", e);
		}
		return map;
	}

	@Override
	public HashMap<String, String> getCharges() {
		HashMap<String, String> map = new HashMap<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseInvoiceQueryUtil.GET_CHARGE_LIST);
			for (Map row : rows) {
				map.put(String.valueOf(row.get("text")), String.valueOf(row.get("id")));
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getCharges", e);
		}
		return map;
	}

	@Override
	@Transactional
	public String InsertUploadData(List<PurchaseInvoiceHeaderBean> bean) {
		String alertmsg = "";
		Timestamp timeStampDate = new Timestamp(new Date().getTime());
		String trashipmentrequentno = "";
		Set<String> purchaseQuoteset = new HashSet<>();
		Set<String> errospq = new HashSet<>();
		Boolean tpPqCheck = false;
		boolean isSuccess = false;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String bookingRequestNo = "";
			String shipmenthdr = "";

			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();

			for (PurchaseInvoiceHeaderBean lists : bean) {
				String pInvoice = getGPIInvoiceNo(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
				lists.setPuchaseInvoiceNo(pInvoice);
				if (lists.getPaymentStatus() != null) {
					if (lists.getPaymentStatus().isEmpty())
						lists.setPaymentStatus("Not Paid");
					else
						lists.setPaymentStatus(lists.getPaymentStatus());
				} else
					lists.setPaymentStatus("Not Paid");

				int iTemp = 0;
				if (lists.getPuchaseInvoiceDate() != null && lists.getPuchaseInvoiceDate() != "") {
					iTemp = jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_GENERAL_PURCHASE_INVOICE_HEADER_LIST, new Object[] { lists.getPuchaseInvoiceNo(), CommonUtil.convertSqlDateFormat(lists.getPuchaseInvoiceDate()), lists.getSupplier(), lists.getDescription(), "INR", 1, userId, lists.getCompany(), lists.getAmount(), lists.getCostCenter() });

					if (iTemp > 0) {
						isSuccess = savePurchaseInvoiceDetailforUpload(lists);
					}

					if (isSuccess) {
						isSuccess = insertGeneralLedgerheader(lists);
						isSuccess = insertGeneralLedgerChargeDetail(lists);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();

			alertmsg = "Unable to save data";
		}
		return alertmsg;
	}

	@Override
	public boolean savePurchaseInvoiceDetailforUpload(PurchaseInvoiceHeaderBean objPurchaseInvoiceListBean) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			if (objPurchaseInvoiceListBean.getAccountHeadCode() != null && objPurchaseInvoiceListBean.getAccountHeadCode() != "") {
				objPurchaseInvoiceListBean.setSubGrpCode(objPurchaseInvoiceListBean.getAccountHeadCode().substring(0, 4));
				jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_GENERAL_PURCHASE_INVOICE_DTL_UPLOAD, new Object[] { objPurchaseInvoiceListBean.getPuchaseInvoiceNo(), 1, objPurchaseInvoiceListBean.getAccountHeadCode(), 0, objPurchaseInvoiceListBean.getDetailAmount(), objPurchaseInvoiceListBean.getDetailAmount() });
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public PurchaseInvoiceHeaderBean getPurchaseInvoiceForView(String puchaseInvoiceNo) {
		PurchaseInvoiceHeaderBean objPurchaseInvoiceBean = null;
		List<PurchaseInvoiceDetailBean> lPINDetList = new ArrayList<>();
		List<PurchaseInvoiceDetailBean> lJvList = new ArrayList<>();
		List<PurchaseInvoiceDetailBean> lAcctList = new ArrayList<>();

		try {
			objPurchaseInvoiceBean = new PurchaseInvoiceHeaderBean();

			objPurchaseInvoiceBean = jdbcTemplate.queryForObject(PurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_HDR_VIEW, new Object[] { puchaseInvoiceNo }, new BeanPropertyRowMapper<>(PurchaseInvoiceHeaderBean.class));
			/*
			 * if (checkData(objPurchaseInvoiceBean.getDueDate()).isEmpty() || checkData
			 * (objPurchaseInvoiceBean.getDueDate()).equals("01/01/0001")) {
			 * objPurchaseInvoiceBean.setDueDate(""); }
			 */
			lPINDetList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_DTL_VIEW, new Object[] { objPurchaseInvoiceBean.getPuchaseInvoiceNo() }, new BeanPropertyRowMapper<>(PurchaseInvoiceDetailBean.class));

			double dTcAmountDtl = 0.0, dBcAmountDtl = 0.0;
			for (PurchaseInvoiceDetailBean objPurchaseInvoiceDetailBean : lPINDetList) {
				dTcAmountDtl = dTcAmountDtl + objPurchaseInvoiceDetailBean.getAmount();
				dBcAmountDtl = dBcAmountDtl + objPurchaseInvoiceDetailBean.getAmount();

			}

			lAcctList = jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_DTL_VIEW_ACCT, new Object[] { objPurchaseInvoiceBean.getPuchaseInvoiceNo() }, new BeanPropertyRowMapper<>(PurchaseInvoiceDetailBean.class));

			/*
			 * objPurchaseInvoiceBean.setTcAmount(CommonUtil.roundOffValue( dTcAmountDtl,
			 * 2).doubleValue()); objPurchaseInvoiceBean.setBcAmount
			 * (CommonUtil.roundOffValue(dBcAmountDtl, 2).doubleValue());
			 */
			/*
			 * if (objPurchaseInvoiceBean.getJvNo() != null) { // add jv rows for print if
			 * (!objPurchaseInvoiceBean.getJvNo().isEmpty()) { lJvList =
			 * jdbcTemplate.query(PurchaseInvoiceQueryUtil.GET_JV_INTRA_DTL_VIEW , new
			 * Object[] { objPurchaseInvoiceBean.getJvNo() }, new
			 * BeanPropertyRowMapper<>(PurchaseInvoiceDetailBean.class));
			 * 
			 * lPINDetList.addAll(lJvList); }
			 * 
			 * }
			 */
			objPurchaseInvoiceBean.setPurchaseInvoiceDetail(lPINDetList);
			objPurchaseInvoiceBean.setPurchaseInvoiceDetailacct(lAcctList);

			/*
			 * objPurchaseInvoiceBean.setTotalTCAmountInWords(CommonUtil.
			 * currencyInWords(objPurchaseInvoiceBean.getTotalTCamount(), "(TC Amount)"));
			 * objPurchaseInvoiceBean.setTotalBCAmountInWords(CommonUtil
			 * .currencyInWords(objPurchaseInvoiceBean.getTotalBCamount(), "(BC Amount)"));
			 * objPurchaseInvoiceBean.setFiles(fetchFileName( objPurchaseInvoiceBean
			 * .getPuchaseInvoiceNo()));
			 */

		} catch (DataAccessException e) {
			LOGGER.error("Error in view data GI:::", e);
		}
		return objPurchaseInvoiceBean;
	}
}
