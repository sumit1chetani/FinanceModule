package com.dci.tenant.finance.generalInvoice;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.dci.common.util.AccountsConstants;
import com.dci.common.util.CommonUtil;
import com.dci.tenant.finance.purchaseInvoice.PurchaseInvoiceQueryUtil;
import com.dci.tenant.user.UserDetail;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Repository
public class GeneralInvoiceDaoImpl implements GeneralInvoiceDao {

	private final static Logger LOGGER = LoggerFactory.getLogger(GeneralInvoiceDaoImpl.class);
	@Autowired
	DataSource dataSource;

	@Override
	public List<GeneralInvoiceBean> getGeneralInvoiceList(int limit, int offset) {
		List<GeneralInvoiceBean> lGeneralInvoiceList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lGeneralInvoiceList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_INVOICE_LIST, new BeanPropertyRowMapper<>(GeneralInvoiceBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getGeneralInvoiceList", e);
		}
		return lGeneralInvoiceList;
	}

	@Override
	public List<GeneralInvoiceBean> getCompanyList() {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<GeneralInvoiceBean> companyList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			companyList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_COMPANY_LIST, new BeanPropertyRowMapper<>(GeneralInvoiceBean.class));
			return companyList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return companyList;
	}

	@Override
	public List<GeneralInvoiceBean> getCustomerList() {
		List<GeneralInvoiceBean> customerList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			customerList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_CUSTOMER_LIST, new BeanPropertyRowMapper<>(GeneralInvoiceBean.class));
			return customerList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return customerList;
	}

	@Override
	public List<GeneralInvoiceBean> getCustomertrue() {
		List<GeneralInvoiceBean> customerList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			customerList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_CUSTOMER_True_LIST, new BeanPropertyRowMapper<>(GeneralInvoiceBean.class));
			return customerList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return customerList;
	}

	@Override
	public List<GeneralInvoiceBean> getAccountHeadList() {
		List<GeneralInvoiceBean> accountHeadList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			accountHeadList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_ACCOUNTHEAD_LIST, new BeanPropertyRowMapper<>(GeneralInvoiceBean.class));
			return accountHeadList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return accountHeadList;
	}

	@Override
	public boolean saveGeneralInvoice(GeneralInvoiceBean objGeneralInvoiceBean) {
		boolean isSuccess = false;
		try {
			String sInvoiceNo = generateInvoiceNo(objGeneralInvoiceBean);
			objGeneralInvoiceBean.setInvoiceNo(sInvoiceNo);
			isSuccess = saveInvoiceHeader(objGeneralInvoiceBean);
			isSuccess = saveInvoiceDetail(objGeneralInvoiceBean);
			isSuccess = saveInvoiceTaxInsert(objGeneralInvoiceBean);
			/// isSuccess = saveInvoiceProductDetail(objGeneralInvoiceBean);
			isSuccess = saveGeneralLedgerHeader(objGeneralInvoiceBean);
			// isSuccess =
			// saveGeneralLedgerProductDetail(objGeneralInvoiceBean);
			isSuccess = saveGeneralLedgerDetail(objGeneralInvoiceBean);
			// isSuccess = saveGeneralLedgerTaxDetail(objGeneralInvoiceBean);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return isSuccess;
	}

	private String generateInvoiceNo(GeneralInvoiceBean bean) throws ParseException {
		String sInvoiceNo = "";
		DateFormat formatter;
		String sCurrentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

		formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
			date = formatter.parse(bean.getInvoiceDate());

			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String Gidate = df.format(date);
			sCurrentYear = Gidate.substring(2);

			String sDefaultInv = "IN" + sCurrentYear + "00001";
			String sInvYear = "IN" + sCurrentYear + "%";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			sInvoiceNo = jdbcTemplate.queryForObject(GeneralInvoiceQueryUtil.GET_INVOICE_NO, String.class, sDefaultInv, sInvYear);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return sInvoiceNo;
	}

	private boolean saveInvoiceHeader(GeneralInvoiceBean objGeneralInvoiceBean) {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			if (objGeneralInvoiceBean.getReceivedStatus() != null) {
				if (objGeneralInvoiceBean.getReceivedStatus().isEmpty())
					objGeneralInvoiceBean.setReceivedStatus("Not Received");
				else
					objGeneralInvoiceBean.setReceivedStatus(objGeneralInvoiceBean.getReceivedStatus());
			} else
				objGeneralInvoiceBean.setReceivedStatus("Not Received");

			jdbcTemplate.update(GeneralInvoiceQueryUtil.SAVE_GENERAL_INVOICE_HDR, new Object[] { objGeneralInvoiceBean.getInvoiceNo(), CommonUtil.convertSqlDateFormat(objGeneralInvoiceBean.getInvoiceDate()), objGeneralInvoiceBean.getCustomer(), objGeneralInvoiceBean.getSalesOrderNo(), objGeneralInvoiceBean.getCompany(), objGeneralInvoiceBean.getManualInvoiceNo(), CommonUtil.convertSqlDateFormat(objGeneralInvoiceBean.getDueDate()), objGeneralInvoiceBean.getRemarks(), objGeneralInvoiceBean.getCurrency(), objGeneralInvoiceBean.getExchangeRate(),
					objGeneralInvoiceBean.getAmount(), objGeneralInvoiceBean.getTcamount(), objGeneralInvoiceBean.getReceivedStatus(), objGeneralInvoiceBean.getGinId(), userDetails.getUserId() });
		} catch (Exception e) {
			LOGGER.error("Error in save GI Header", e);
		}

		return true;
	}

	private boolean saveInvoiceTaxInsert(GeneralInvoiceBean objGeneralInvoiceBean) {
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			jdbcTemplate.update(GeneralInvoiceQueryUtil.SAVE_GENERAL_TAX_INSERT, new Object[] { objGeneralInvoiceBean.getInvoiceNo() });

			// }
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}

		return false;
	}

	private boolean saveInvoiceDetail(GeneralInvoiceBean objGeneralInvoiceBean) {
		try {
			List<GeneralInvoiceDetailBean> alDetailList = objGeneralInvoiceBean.getInvoiceDetail();
			for (GeneralInvoiceDetailBean objGeneralInvoiceDetailBean : alDetailList) {
				if (objGeneralInvoiceDetailBean.getAccountHeadCode() != null && objGeneralInvoiceDetailBean.getAccountHeadCode() != "") {
					objGeneralInvoiceDetailBean.setSubGrpCode(objGeneralInvoiceDetailBean.getAccountHeadCode().substring(0, 4));
					if (objGeneralInvoiceDetailBean.getShortDetail() == null || objGeneralInvoiceDetailBean.getShortDetail().equalsIgnoreCase("")) {
						objGeneralInvoiceDetailBean.setShortDetail("TEST");
					}
					JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

					jdbcTemplate.update(GeneralInvoiceQueryUtil.SAVE_GENERAL_INVOICE_DTL, new Object[] { objGeneralInvoiceBean.getInvoiceNo(), objGeneralInvoiceDetailBean.getShortDetail(),

							objGeneralInvoiceDetailBean.getSubGrpCode(), objGeneralInvoiceDetailBean.getSiNo(), objGeneralInvoiceDetailBean.getAccountHeadCode(), objGeneralInvoiceDetailBean.getAmount(),

							Double.valueOf(objGeneralInvoiceDetailBean.getTax()),

							objGeneralInvoiceDetailBean.getEmployeeCode(), objGeneralInvoiceDetailBean.getDepartmentCode(),

							objGeneralInvoiceDetailBean.getCostCenter() });
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}

		return false;
	}

	private boolean saveInvoiceProductDetail(GeneralInvoiceBean objGeneralInvoiceBean) {
		try {
			List<GeneralInvoiceProductDetailBean> alProductDetailList = objGeneralInvoiceBean.getInvoiceProdDetail();
			for (GeneralInvoiceProductDetailBean objGeneralInvoiceProductDetailBean : alProductDetailList) {

				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				jdbcTemplate.update(GeneralInvoiceQueryUtil.SAVE_INVOICE_PROD_DTL, new Object[] { objGeneralInvoiceBean.getInvoiceNo(), objGeneralInvoiceProductDetailBean.getSiNo(), objGeneralInvoiceProductDetailBean.getItemId(), objGeneralInvoiceProductDetailBean.getQuantity(), objGeneralInvoiceProductDetailBean.getUnitprice(), objGeneralInvoiceProductDetailBean.getAmount(), objGeneralInvoiceBean.getCostCenter(), objGeneralInvoiceProductDetailBean.getTaxAmount() });
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	private boolean updateInvoiceProductDetail(GeneralInvoiceBean objGeneralInvoiceBean) {
		try {
			List<GeneralInvoiceDetailBean> alProductDetailList = objGeneralInvoiceBean.getInvoiceDetail();
			for (GeneralInvoiceDetailBean objGeneralInvoiceProductDetailBean : alProductDetailList) {

				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				jdbcTemplate.update(GeneralInvoiceQueryUtil.UPDATE_INVOICE_PROD_DTL, new Object[] { objGeneralInvoiceBean.getInvoiceDetail().get(0).getCostCenter(), objGeneralInvoiceBean.getInvoiceNo() });
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	private boolean saveGeneralLedgerHeader(GeneralInvoiceBean objGeneralInvoiceBean) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(GeneralInvoiceQueryUtil.SAVE_GENERAL_LEDGER_HDR, new Object[] { objGeneralInvoiceBean.getInvoiceNo() });
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	private boolean saveGeneralLedgerProductDetail(GeneralInvoiceBean objGeneralInvoiceBean) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(GeneralInvoiceQueryUtil.SAVE_GENERAL_LEDGER_PRODUCT_DTL, new Object[] { objGeneralInvoiceBean.getInvoiceNo() });
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	private boolean saveGeneralLedgerDetail(GeneralInvoiceBean objGeneralInvoiceBean) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(GeneralInvoiceQueryUtil.SAVE_GENERAL_LEDGER_CHARGE_DTL, new Object[] { objGeneralInvoiceBean.getInvoiceNo() });
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	private boolean saveGeneralLedgerTaxDetail(GeneralInvoiceBean objGeneralInvoiceBean) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<GeneralInvoiceProductDetailBean> alProductDetailList = objGeneralInvoiceBean.getInvoiceProdDetail();
			if (alProductDetailList.size() > 0) {
				for (GeneralInvoiceProductDetailBean detailBean : alProductDetailList) {
					if (detailBean.getTaxAmount() > 0) {
						String parentCode = "";
						if (detailBean.getTaxAccountId() != null && detailBean.getTaxAccountId() != "") {
							parentCode = detailBean.getTaxAccountId();
							parentCode = parentCode.substring(0, 4);

						} else {
							detailBean.setTaxAccountId("40100001");
							parentCode = detailBean.getTaxAccountId();
							parentCode = parentCode.substring(0, 4);
						}
						jdbcTemplate.update(PurchaseInvoiceQueryUtil.SAVE_GENERAL_LEDGER_PRODUCT_TAX_DTL_ID, new Object[] { CommonUtil.convertSqlDateFormat(objGeneralInvoiceBean.getInvoiceDate()), detailBean.getTaxAccountId(), objGeneralInvoiceBean.getInvoiceNo(), detailBean.getTaxAmount(), 0.0, detailBean.getTaxAmount(), 0.0, "Sales Tax", "INR", 1, objGeneralInvoiceBean.getCompany(), parentCode, detailBean.getItemId(), objGeneralInvoiceBean.getCostCenter() });
					}

				}
			}

			jdbcTemplate.update(GeneralInvoiceQueryUtil.SAVE_GENERAL_LEDGER_HDR, new Object[] { objGeneralInvoiceBean.getInvoiceNo() });
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	@Override
	public List<GeneralInvoiceBean> getSalesOrderList() {
		List<GeneralInvoiceBean> salesOrderList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			salesOrderList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_SALES_ORDER_LIST, new BeanPropertyRowMapper<>(GeneralInvoiceBean.class));
			return salesOrderList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return salesOrderList;
	}

	@Override
	public List<GeneralInvoiceBean> getGinList() {
		List<GeneralInvoiceBean> ginList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			ginList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_GIN_DTL, new BeanPropertyRowMapper<>(GeneralInvoiceBean.class));
			return ginList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return ginList;
	}

	@Override
	public boolean deleteGeneralInvoice(String sInvoiceNo) {
		boolean isSucess = false;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(GeneralInvoiceQueryUtil.DELETE_GENERAL_INVOICE_PROD_DTL, new Object[] { sInvoiceNo });
			jdbcTemplate.update(GeneralInvoiceQueryUtil.DELETE_GENERAL_INVOICE_DTL, new Object[] { sInvoiceNo });
			jdbcTemplate.update(GeneralInvoiceQueryUtil.DELETE_GENERAL_INVOICE_HDR, new Object[] { sInvoiceNo });
			jdbcTemplate.update(GeneralInvoiceQueryUtil.DELETE_GENERAL_LEDGER, new Object[] { sInvoiceNo });
			isSucess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}

		return isSucess;
	}

	@Override
	public GeneralInvoiceBean getInvoiceDetail(String sInvoiceNo) {
		GeneralInvoiceBean objGeneralInvoiceBean = new GeneralInvoiceBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			objGeneralInvoiceBean = jdbcTemplate.queryForObject(GeneralInvoiceQueryUtil.GET_GENERALINV_GIN_HDR, new Object[] { sInvoiceNo }, new BeanPropertyRowMapper<>(GeneralInvoiceBean.class));
			List<GeneralInvoiceBean> salesOrderList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_SALES_ORDER_LIST, new BeanPropertyRowMapper<>(GeneralInvoiceBean.class));
			List<GeneralInvoiceDetailBean> lDetailList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_GENERALINV_DTL, new Object[] { sInvoiceNo }, new BeanPropertyRowMapper<>(GeneralInvoiceDetailBean.class));
			List<GeneralInvoiceProductDetailBean> lProductDetailList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_GENERALINV_PROD_DTL, new Object[] { sInvoiceNo }, new BeanPropertyRowMapper<>(GeneralInvoiceProductDetailBean.class));
			objGeneralInvoiceBean.setInvoiceDetail(lDetailList);
			objGeneralInvoiceBean.setInvoiceProdDetail(lProductDetailList);
			objGeneralInvoiceBean.setSalesOrderList(salesOrderList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return objGeneralInvoiceBean;
	}

	@Override
	public boolean updateGeneralInvoice(GeneralInvoiceBean objGeneralInvoiceBean) {
		boolean isSuccess = false;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int iGIHdr = jdbcTemplate.update(GeneralInvoiceQueryUtil.UPDATE_GENERAL_INV_GIN_HDR, new Object[] { CommonUtil.convertSqlDateFormat(objGeneralInvoiceBean.getInvoiceDate()), objGeneralInvoiceBean.getCustomer(), objGeneralInvoiceBean.getSalesOrderNo(), objGeneralInvoiceBean.getCompany(), objGeneralInvoiceBean.getManualInvoiceNo(), CommonUtil.convertSqlDateFormat(objGeneralInvoiceBean.getDueDate()), objGeneralInvoiceBean.getRemarks(), objGeneralInvoiceBean.getCurrency(), objGeneralInvoiceBean.getExchangeRate(),
					objGeneralInvoiceBean.getAmount(), objGeneralInvoiceBean.getTcamount(), objGeneralInvoiceBean.getInvoiceNo() });
			isSuccess = updateInvoiceProductDetail(objGeneralInvoiceBean);
			/*
			 * if (iGIHdr > 0) { jdbcTemplate.update(GeneralInvoiceQueryUtil.
			 * DELETE_GENERAL_INVOICE_DTL, new Object[] {
			 * objGeneralInvoiceBean.getInvoiceNo() });
			 * jdbcTemplate.update(GeneralInvoiceQueryUtil
			 * .DELETE_GENERAL_INVOICE_PROD_DTL, new Object[] {
			 * objGeneralInvoiceBean.getInvoiceNo() }); isSuccess =
			 * saveInvoiceDetail(objGeneralInvoiceBean); isSuccess =
			 * saveInvoiceProductDetail(objGeneralInvoiceBean); }
			 * 
			 * if (isSuccess) { int iGLDel =
			 * jdbcTemplate.update(GeneralInvoiceQueryUtil
			 * .DELETE_GENERAL_LEDGER, new Object[] {
			 * objGeneralInvoiceBean.getInvoiceNo() }); isSuccess =
			 * saveGeneralLedgerHeader(objGeneralInvoiceBean); isSuccess =
			 * saveGeneralLedgerProductDetail(objGeneralInvoiceBean); isSuccess
			 * = saveGeneralLedgerDetail(objGeneralInvoiceBean); isSuccess =
			 * saveGeneralLedgerTaxDetail(objGeneralInvoiceBean); }
			 */

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}

		return isSuccess;
	}

	@Override
	public List<GeneralInvoiceBean> getItemList() {
		List<GeneralInvoiceBean> lItemList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lItemList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_ITEM_LIST, new BeanPropertyRowMapper<>(GeneralInvoiceBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in lgrnList", e);
		}
		return lItemList;
	}

	@Override
	public GeneralInvoiceBean getSODetail(int iSoNo) {
		GeneralInvoiceBean objGeneralInvoiceBean = new GeneralInvoiceBean();
		List<GeneralInvoiceProductDetailBean> alProductDetailList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			objGeneralInvoiceBean = jdbcTemplate.queryForObject(GeneralInvoiceQueryUtil.GET_SO_HDR, new Object[] { iSoNo }, new BeanPropertyRowMapper<>(GeneralInvoiceBean.class));
			alProductDetailList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_SO_DTL, new Object[] { iSoNo }, new BeanPropertyRowMapper<>(GeneralInvoiceProductDetailBean.class));
			objGeneralInvoiceBean.setInvoiceProdDetail(alProductDetailList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Account Head Master", e);
		}
		return objGeneralInvoiceBean;
	}

	@Override
	public GeneralInvoiceBean getGinDetailList(int ginId) {
		GeneralInvoiceBean objGeneralInvoiceBean = new GeneralInvoiceBean();
		List<GeneralInvoiceProductDetailBean> alProductDetailList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			objGeneralInvoiceBean = jdbcTemplate.queryForObject(GeneralInvoiceQueryUtil.GET_GIN_HDR, new Object[] { ginId }, new BeanPropertyRowMapper<>(GeneralInvoiceBean.class));
			alProductDetailList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_GIN_ITEM_DTL, new Object[] { ginId }, new BeanPropertyRowMapper<>(GeneralInvoiceProductDetailBean.class));
			objGeneralInvoiceBean.setInvoiceProdDetail(alProductDetailList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Account Head Master", e);
		}
		return objGeneralInvoiceBean;
	}

	@Override
	public List<GeneralInvoiceBean> getCurrencyList() {
		List<GeneralInvoiceBean> currencyList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			currencyList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_CURRENCY_LIST, new BeanPropertyRowMapper<>(GeneralInvoiceBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Currency List", e);
		}
		return currencyList;
	}

	@Override
	public double getExchangeRate(String currencyCode) {
		double dExchangeRate = 1.0;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(GeneralInvoiceQueryUtil.GET_EXCHANGE_RATE, new Object[] { currencyCode });
			for (Map row : rows) {
				dExchangeRate = Double.parseDouble((String) row.get("value"));
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return dExchangeRate;
	}

	@Override
	public GeneralInvoiceBean printPaymentVoucher(String sInvoiceNo) {

		GeneralInvoiceBean objGeneralInvoiceBean = new GeneralInvoiceBean();
		String sJvNo = "";
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			objGeneralInvoiceBean = jdbcTemplate.queryForObject(GeneralInvoiceQueryUtil.GET_GENERALINV_GIN_HDR_Print, new Object[] { sInvoiceNo }, new BeanPropertyRowMapper<>(GeneralInvoiceBean.class));

			if (objGeneralInvoiceBean.getCompany().equalsIgnoreCase("C0002")) {
				objGeneralInvoiceBean.setCompanyName("Dental Council of India");
			} else {
				objGeneralInvoiceBean.setCompanyName("Dental Council of India");
			}
			List<GeneralInvoiceBean> salesOrderList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_SALES_ORDER_LIST_PRINT, new Object[] { sInvoiceNo }, new BeanPropertyRowMapper<>(GeneralInvoiceBean.class));
			List<GeneralInvoiceDetailBean> lDetailList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_GENERALINV_DTL, new Object[] { sInvoiceNo }, new BeanPropertyRowMapper<>(GeneralInvoiceDetailBean.class));
			List<GeneralInvoiceProductDetailBean> lProductDetailList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_GENERALINV_PROD_DTL, new Object[] { sInvoiceNo }, new BeanPropertyRowMapper<>(GeneralInvoiceProductDetailBean.class));
			objGeneralInvoiceBean.setInvoiceDetail(lDetailList);
			objGeneralInvoiceBean.setInvoiceProdDetail(lProductDetailList);
			objGeneralInvoiceBean.setSalesOrderList(salesOrderList);

			double dTcAmountDtl = 0.0, dBcAmountDtl = 0.0;

			dTcAmountDtl = dTcAmountDtl + objGeneralInvoiceBean.getAmount();
			dBcAmountDtl = dBcAmountDtl + objGeneralInvoiceBean.getAmount();

			objGeneralInvoiceBean.setAmount(dTcAmountDtl);
			objGeneralInvoiceBean.setAmount(dBcAmountDtl);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get lSubAccountList List", e);
		}

		return objGeneralInvoiceBean;

	}

	@Override
	public boolean exportToGeneralInvoicePdf(String invoiceNo, ServletContext context) {
		boolean isGenerated = false;
		Connection conn = null;
		try {
			String contextPath = getAbsoluteFilePath(AccountsConstants.GENERAL_INVOICE_JASPER_REPORT);
			String images = context.getRealPath(AccountsConstants.IMAGE_PATH);
			String pdfFile = context.getRealPath(AccountsConstants.TEMPDOC_PATH);

			conn = dataSource.getConnection();
			if (pdfFile != null) {
				File file = new File(pdfFile + AccountsConstants.GENERAL_INVOICE_PDF);
				if (file.createNewFile()) {
				} else {
					file.delete();
				}
			}
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("pGenInvoiceNo", invoiceNo);
			parameters.put("realPath", images);
			pdfFile = pdfFile + AccountsConstants.GENERAL_INVOICE_PDF;
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

	/**
	 * get Absolute File Path
	 * 
	 * @param classpathRelativePath
	 * @return
	 * @throws Exception
	 */
	public String getAbsoluteFilePath(String classpathRelativePath) throws Exception {
		Resource rsrc = new ClassPathResource(classpathRelativePath);
		return rsrc.getFile().getAbsolutePath();
	}
}