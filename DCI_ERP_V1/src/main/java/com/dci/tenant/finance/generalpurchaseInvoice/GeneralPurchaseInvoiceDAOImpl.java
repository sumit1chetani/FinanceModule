package com.dci.tenant.finance.generalpurchaseInvoice;

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
import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.user.UserDetail;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Repository
public class GeneralPurchaseInvoiceDAOImpl implements GeneralPurchaseInvoiceDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(GeneralPurchaseInvoiceController.class);

	@Autowired
	DataSource dataSource;

	@Override
	public List<GeneralPurchaseInvoiceHeaderBean> getSupplierList() throws CustomException {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<GeneralPurchaseInvoiceHeaderBean> supplierList = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.GET_SUPPLIER_LIST, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceHeaderBean.class));
			return supplierList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Supplier List", e);
			throw new CustomException("Error in Get Supplie List");
		}

	}

	@Override
	public List<GeneralPurchaseInvoiceHeaderBean> getGrnList() {
		List<GeneralPurchaseInvoiceHeaderBean> lgrnList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lgrnList = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.GET_GRN_LIST, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceHeaderBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in lgrnList", e);
		}
		return lgrnList;
	}

	@Override
	public List<GeneralPurchaseInvoiceHeaderBean> getWoList() {
		List<GeneralPurchaseInvoiceHeaderBean> lgrnList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lgrnList = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.GET_WO_LIST, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceHeaderBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in lgrnList", e);
		}
		return lgrnList;
	}

	@Override
	public List<GeneralPurchaseInvoiceHeaderBean> getCostCenterList(String companyCode) {
		List<GeneralPurchaseInvoiceHeaderBean> lgrnList = new ArrayList<>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lgrnList = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.GET_COST_CENTER_LIST, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceHeaderBean.class), companyCode);
		} catch (DataAccessException e) {
			LOGGER.error("Error in lgrnList", e);
		}

		return lgrnList;
	}

	@Override
	public List<GeneralPurchaseInvoiceHeaderBean> getDtl(Integer num) {
		List<GeneralPurchaseInvoiceHeaderBean> lgrnList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lgrnList = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.GET_DTL_LIST, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceHeaderBean.class), num);
		} catch (DataAccessException e) {
			LOGGER.error("Error in lgrnList", e);
		}

		return lgrnList;
	}

	@Override
	public List<GeneralPurchaseInvoiceHeaderBean> getChargeList() {
		List<GeneralPurchaseInvoiceHeaderBean> lchargeList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lchargeList = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.GET_CHARGE_LIST, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceHeaderBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in lgrnList", e);
		}
		return lchargeList;
	}

	@Override
	public List<GeneralPurchaseInvoiceHeaderBean> getItemList() {
		List<GeneralPurchaseInvoiceHeaderBean> lItemList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lItemList = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.GET_ITEM_LIST, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceHeaderBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in lgrnList", e);
		}
		return lItemList;
	}

	@Override
	public List<GeneralPurchaseInvoiceHeaderBean> getCompanyList() throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<GeneralPurchaseInvoiceHeaderBean> companyList = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.GET_COMPANY_LIST, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceHeaderBean.class), userDetails.getCompanyCode());
			return companyList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
			throw new CustomException("Error in Get company List");
		}

	}

	@Override
	public List<GeneralPurchaseInvoiceHeaderBean> getPurchaseInvoiceList() throws CustomException {
		List<GeneralPurchaseInvoiceHeaderBean> lPurchaseInvList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lPurchaseInvList = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_LIST, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceHeaderBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Account Head Master", e);
			throw new CustomException("Error in Get Account Head Master");
		}
		return lPurchaseInvList;
	}

	@Override
	public boolean savePurchaseInvoice(GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean) throws CustomException {
		boolean isSuccess = false;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String wotype = objPurchaseInvoiceHeaderBean.getWotype();
		boolean nonpoFlag = objPurchaseInvoiceHeaderBean.isNonPo();
		String sInvoice = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// String sInvoice =
			// getInvoiceNo(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
			if (nonpoFlag) {
				sInvoice = getInvoiceNo(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)), objPurchaseInvoiceHeaderBean);
			} else if (wotype.equals("Capex WO")) {
				sInvoice = jdbcTemplate.queryForObject(GeneralPurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_NO_CAPX, String.class);
			} else if (wotype.equals("Revex WO")) {
				sInvoice = jdbcTemplate.queryForObject(GeneralPurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_NO_REVEX, String.class);
			}

			objPurchaseInvoiceHeaderBean.setPuchaseInvoiceNo(sInvoice);

			int iTemp = 0;

			iTemp = jdbcTemplate.update(GeneralPurchaseInvoiceQueryUtil.SAVE_PURCHASE_INVOICE_LIST, new Object[] { objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo(), objPurchaseInvoiceHeaderBean.getPuchaseInvoiceDate(), objPurchaseInvoiceHeaderBean.getInvoiceDueDate(), objPurchaseInvoiceHeaderBean.getSupplier(), objPurchaseInvoiceHeaderBean.getDescription(), objPurchaseInvoiceHeaderBean.getPartyInvoiceNo(), objPurchaseInvoiceHeaderBean.getCurrency(), objPurchaseInvoiceHeaderBean.getExchangeRate(), userId, objPurchaseInvoiceHeaderBean.getCompany(),
					objPurchaseInvoiceHeaderBean.getBcamount(), objPurchaseInvoiceHeaderBean.getWotype(), objPurchaseInvoiceHeaderBean.getWonumber(), objPurchaseInvoiceHeaderBean.getCostCenter(), objPurchaseInvoiceHeaderBean.getBudgetType(), objPurchaseInvoiceHeaderBean.isNonPo() });

			if (iTemp > 0) {
				isSuccess = savePurchaseInvoiceDetail(objPurchaseInvoiceHeaderBean);
			}

			if (isSuccess) {
				isSuccess = insertGeneralLedgerheader(objPurchaseInvoiceHeaderBean);
				isSuccess = insertGeneralLedgerProductDetail(objPurchaseInvoiceHeaderBean);
			}

		} catch (Exception e) {
			LOGGER.error("Error in saving purchase invoice", e);
			throw new CustomException("Error in saving purchase invoice");
		}

		return isSuccess;

	}

	public boolean savePurchaseInvoiceDetail(GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceListBean) {

		try {

			List<GeneralPurchaseInvoiceProductDetailBean> alDetailList = objPurchaseInvoiceListBean.getPurchaseInvoiceProdDetail();
			for (GeneralPurchaseInvoiceProductDetailBean objPurchaseInvoiceDetailBean : alDetailList) {

				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

				jdbcTemplate.update(GeneralPurchaseInvoiceQueryUtil.SAVE_PURCHASE_INVOICE_DTL,
						new Object[] { objPurchaseInvoiceListBean.getPuchaseInvoiceNo(), 
								objPurchaseInvoiceDetailBean.getSiNo(), 
								objPurchaseInvoiceDetailBean.getAccountHeadCode(), 
								objPurchaseInvoiceDetailBean.getTaxAmount(), 
								objPurchaseInvoiceDetailBean.getAmount(), 
								objPurchaseInvoiceDetailBean.getTotalAmount(), 
								objPurchaseInvoiceDetailBean.getServicedetail(), 
								Integer.parseInt(objPurchaseInvoiceListBean.getCostCenter()), 
								objPurchaseInvoiceDetailBean.getEmployeeCode(), 
								objPurchaseInvoiceDetailBean.getDepartmentCode() });

			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean savePurchaseInvoiceProductDetail(GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceListBean) {

		try {
			List<GeneralPurchaseInvoiceProductDetailBean> alProductDetailList = objPurchaseInvoiceListBean.getPurchaseInvoiceProdDetail();
			for (GeneralPurchaseInvoiceProductDetailBean objPurchaseInvoiceProductDetailBean : alProductDetailList) {

				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				jdbcTemplate.update(GeneralPurchaseInvoiceQueryUtil.SAVE_PURCHASE_INVOICE_PROD_DTL,
						new Object[] { objPurchaseInvoiceListBean.getPuchaseInvoiceNo(), objPurchaseInvoiceProductDetailBean.getSiNo(), objPurchaseInvoiceProductDetailBean.getItemId(), objPurchaseInvoiceProductDetailBean.getQuantity(), objPurchaseInvoiceProductDetailBean.getUnitprice(), objPurchaseInvoiceProductDetailBean.getAmount(), objPurchaseInvoiceListBean.getCostCenter(), objPurchaseInvoiceProductDetailBean.getUnitTaxAmount(), objPurchaseInvoiceProductDetailBean.getUnitDiscountAmount(), objPurchaseInvoiceProductDetailBean.getTaxAmount(),
								objPurchaseInvoiceProductDetailBean.getDiscountAmount(), objPurchaseInvoiceProductDetailBean.getTaxAccountCode(), objPurchaseInvoiceListBean.getEmployeeCode(), objPurchaseInvoiceListBean.getDepartmentCode(), objPurchaseInvoiceListBean.getCountryCode(), objPurchaseInvoiceListBean.getCustomerCode(), objPurchaseInvoiceListBean.getSupplierCode(), objPurchaseInvoiceListBean.getDesignationCode(), objPurchaseInvoiceListBean.getCompanyCode(), objPurchaseInvoiceListBean.getAssetCode() });
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	public boolean updatePurchaseInvoiceDetail(GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceListBean) {

		try {
			List<GeneralPurchaseInvoiceDetailBean> alProductDetailList = objPurchaseInvoiceListBean.getPurchaseInvoiceDetail();
			for (GeneralPurchaseInvoiceDetailBean objdelbean : alProductDetailList) {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				jdbcTemplate.update(GeneralPurchaseInvoiceQueryUtil.updatePurchaseInvoiceDtl, new Object[] { objdelbean.getEmployeeCode(), objdelbean.getCountryCode(), objdelbean.getCustomerCode(), objdelbean.getSupplierCode(), objdelbean.getDesignationCode(), objdelbean.getCompanyCode(), objdelbean.getAssetCode(), objdelbean.getDepartmentCode(), objdelbean.getCostCenter(), objdelbean.getPurDtlId() });
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	public boolean updatePurchaseInvoiceProductDetail(GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceListBean) {

		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			jdbcTemplate.update(GeneralPurchaseInvoiceQueryUtil.updatePurchaseInvoiceProductDtl,

					new Object[] { objPurchaseInvoiceListBean.getEmployeeCode(), objPurchaseInvoiceListBean.getCountryCode(), objPurchaseInvoiceListBean.getCustomerCode(), objPurchaseInvoiceListBean.getSupplierCode(), objPurchaseInvoiceListBean.getDesignationCode(), objPurchaseInvoiceListBean.getCompanyCode(), objPurchaseInvoiceListBean.getAssetCode(), objPurchaseInvoiceListBean.getDepartmentCode(), objPurchaseInvoiceListBean.getCostCenter(), objPurchaseInvoiceListBean.getPuchaseInvoiceNo() });

		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;

	}

	public String getInvoiceNo(String fullYear, GeneralPurchaseInvoiceHeaderBean bean) throws CustomException, ParseException {
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

			String sDefaultInv = "GPI" + sCurrentYear + "00001";
			String sInvYear = "GPI" + sCurrentYear + "%";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			sInvoiceNo = jdbcTemplate.queryForObject(GeneralPurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_NO, String.class, sDefaultInv, sInvYear);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return sInvoiceNo;
	}

	private boolean insertGeneralLedgerheader(GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(GeneralPurchaseInvoiceQueryUtil.SAVE_GENERAL_LEDGER_HDR, new Object[] { objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo() });
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	private boolean insertGeneralLedgerChargeDetail(GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(GeneralPurchaseInvoiceQueryUtil.SAVE_GENERAL_LEDGER_CHARGE_DTL, new Object[] { objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo() });
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	private boolean insertGeneralLedgerProductDetail(GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(GeneralPurchaseInvoiceQueryUtil.SAVE_GENERAL_LEDGER_PRODUCT_DTL, new Object[] { objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo() });

		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	private boolean insertGeneralLedgerProductTaxDetail(GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			GeneralPurchaseInvoiceHeaderBean headerBean = new GeneralPurchaseInvoiceHeaderBean();
			try {

				if (objPurchaseInvoiceHeaderBean.getTaxAccountList().size() > 0) {
					for (GeneralPurchaseInvoiceProductDetailBean detailBean : objPurchaseInvoiceHeaderBean.getTaxAccountList()) {

						String parentCode = Integer.toString(detailBean.getTaxAccountId());

						parentCode = parentCode.substring(0, 4);

						jdbcTemplate.update(GeneralPurchaseInvoiceQueryUtil.SAVE_GENERAL_LEDGER_PRODUCT_TAX_DTL_ID, new Object[] { CommonUtil.convertSqlDateFormat(objPurchaseInvoiceHeaderBean.getPuchaseInvoiceDate()), detailBean.getTaxAccountId(), objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo(), 0.0, detailBean.getTaxAmount(), 0.0, detailBean.getTaxAmount(), "Purchase Tax", "INR", 1, objPurchaseInvoiceHeaderBean.getCompany(), parentCode, detailBean.getItemId(), headerBean.getCostCenter() });

					}
				} else {
					List<GeneralPurchaseInvoiceProductDetailBean> alProductDetailList = objPurchaseInvoiceHeaderBean.getPurchaseInvoiceProdDetail();
					if (alProductDetailList.size() > 0) {
						String parentCode = "40100003";

						parentCode = parentCode.substring(0, 4);
						for (GeneralPurchaseInvoiceProductDetailBean detailBean : alProductDetailList) {
							jdbcTemplate.update(GeneralPurchaseInvoiceQueryUtil.SAVE_GENERAL_LEDGER_PRODUCT_TAX_DTL_ID, new Object[] { CommonUtil.convertSqlDateFormat(objPurchaseInvoiceHeaderBean.getPuchaseInvoiceDate()), 40100003, objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo(), 0.0, detailBean.getTaxAmount(), 0.0, detailBean.getTaxAmount(), "Purchase Tax", "INR", 1, objPurchaseInvoiceHeaderBean.getCompany(), parentCode, detailBean.getItemId(), headerBean.getCostCenter() });
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
	public List<GeneralPurchaseInvoiceDetailBean> getPurchaseInvDtlList(String purchaseInvoiceNo) throws CustomException {
		List<GeneralPurchaseInvoiceDetailBean> lChargeList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lChargeList = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_LIST, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceDetailBean.class));
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
			int iPurItem = jdbcTemplate.update(GeneralPurchaseInvoiceQueryUtil.deletePurchaseItemInvoiceDtl, invoiceNo);
			int iPurInv = jdbcTemplate.update(GeneralPurchaseInvoiceQueryUtil.deletePurchaseInvoiceDtl, invoiceNo);
			int rowGL = jdbcTemplate.update(GeneralPurchaseInvoiceQueryUtil.DELETE_GENERAL_LEDGER, new Object[] { invoiceNo });

			int iPurHdr = jdbcTemplate.update(GeneralPurchaseInvoiceQueryUtil.deletePurchaseInvoiceHdr, invoiceNo);
			if (iPurHdr > 0)
				isDeleted = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete Purchase Invoice", e);
		}

		return isDeleted;
	}

	@Override
	public GeneralPurchaseInvoiceHeaderBean getPurchaseInvoiceDetail(String sPurchaseInvoiceNo) {
		GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceListBean = new GeneralPurchaseInvoiceHeaderBean();
		try {
			objPurchaseInvoiceListBean = getPurchaseInvoiceHeaderDetail(sPurchaseInvoiceNo);

			List<GeneralPurchaseInvoiceProductDetailBean> lProductDetailList = new ArrayList<>();

			lProductDetailList = getPurchaseInvoiceProcuctDetailList(sPurchaseInvoiceNo);
			objPurchaseInvoiceListBean.setPurchaseInvoiceProdDetail(lProductDetailList);
		} catch (CustomException e) {
			LOGGER.error("Error in Get getPurchaseInvoiceDetail List", e);
		}

		return objPurchaseInvoiceListBean;
	}

	private GeneralPurchaseInvoiceHeaderBean getPurchaseInvoiceHeaderDetail(String sPurchaseInvoiceNo) {
		GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceListBean = new GeneralPurchaseInvoiceHeaderBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			objPurchaseInvoiceListBean = jdbcTemplate.queryForObject(GeneralPurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_HDR, new Object[] { sPurchaseInvoiceNo }, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceHeaderBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getJvAccountDetail list", e);
		}
		return objPurchaseInvoiceListBean;
	}

	private GeneralPurchaseInvoiceHeaderBean getPurchaseInvoiceHeaderDetailprint(String sPurchaseInvoiceNo) {
		GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceListBean = new GeneralPurchaseInvoiceHeaderBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			objPurchaseInvoiceListBean = jdbcTemplate.queryForObject(GeneralPurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_HDR_print, new Object[] { sPurchaseInvoiceNo }, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceHeaderBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getJvAccountDetail list", e);
		}
		return objPurchaseInvoiceListBean;
	}

	public List<GeneralPurchaseInvoiceDetailBean> getPurchaseInvoiceDetailList(String purchaseInvoiceNo) throws CustomException {
		List<GeneralPurchaseInvoiceDetailBean> dtlDataList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			dtlDataList = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.GET_PURCHASE_INVOICE_DTL, new Object[] { purchaseInvoiceNo }, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceDetailBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Account Head Master", e);
			throw new CustomException("Error in Get Account Head Master");
		}
		return dtlDataList;
	}

	public List<GeneralPurchaseInvoiceProductDetailBean> getPurchaseInvoiceProcuctDetailList(String purchaseInvoiceNo) throws CustomException {
		List<GeneralPurchaseInvoiceProductDetailBean> lProductDtlList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lProductDtlList = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.GET_PURCHASE_PROD_INVOICE_DTL, new Object[] { purchaseInvoiceNo }, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceProductDetailBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getPurchaseInvoiceProcuctDetail", e);
			throw new CustomException("Error in getPurchaseInvoiceProcuctDetail");
		}
		return lProductDtlList;
	}

	@Override
	public boolean updatePurchaseInvoice(GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean) {
		boolean isSuccess = false;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		int iTemp = 0;
		int dtlTemp = 0;
		int glTemp = 0;
		int count = 0;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			iTemp = jdbcTemplate.update(GeneralPurchaseInvoiceQueryUtil.sUpdatePurchaseInvoice, new Object[] { objPurchaseInvoiceHeaderBean.getPuchaseInvoiceDate(), objPurchaseInvoiceHeaderBean.getInvoiceDueDate(), objPurchaseInvoiceHeaderBean.getSupplier(), objPurchaseInvoiceHeaderBean.getCostCenter(), objPurchaseInvoiceHeaderBean.getDescription(), objPurchaseInvoiceHeaderBean.getPartyInvoiceNo(), objPurchaseInvoiceHeaderBean.getCurrency(), objPurchaseInvoiceHeaderBean.getExchangeRate(), userId, objPurchaseInvoiceHeaderBean.getCompany(),
					objPurchaseInvoiceHeaderBean.getBcamount(), objPurchaseInvoiceHeaderBean.isNonPo(), objPurchaseInvoiceHeaderBean.getWotype(), objPurchaseInvoiceHeaderBean.getWonumber(), objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo() });

			if (iTemp > 0) {
				glTemp = jdbcTemplate.update(GeneralPurchaseInvoiceQueryUtil.DELETE_GL_ENTRY, new Object[] { objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo() });

			}

			// if (glTemp > 0) {
			count = jdbcTemplate.queryForObject(GeneralPurchaseInvoiceQueryUtil.COUNT_GPI_DTL_ENTRY, Integer.class, objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo());
			if (count > 0) {
				dtlTemp = jdbcTemplate.update(GeneralPurchaseInvoiceQueryUtil.DELETE_GPI_DTL_ENTRY, new Object[] { objPurchaseInvoiceHeaderBean.getPuchaseInvoiceNo() });
				isSuccess = savePurchaseInvoiceDetail(objPurchaseInvoiceHeaderBean);

			} else {
				isSuccess = savePurchaseInvoiceDetail(objPurchaseInvoiceHeaderBean);

				// }
			}

			// if (dtlTemp > 0) {
			// isSuccess = savePurchaseInvoiceDetail(objPurchaseInvoiceHeaderBean);
			// }

			if (isSuccess) {
				isSuccess = insertGeneralLedgerheader(objPurchaseInvoiceHeaderBean);
				isSuccess = insertGeneralLedgerProductDetail(objPurchaseInvoiceHeaderBean);
			}

		} catch (Exception e) {
			LOGGER.error("Error in Add Account Head Master", e);
		}

		return true;
	}

	@Override
	public GeneralPurchaseInvoiceHeaderBean getGrnDetail(int igrnId) {
		GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean = new GeneralPurchaseInvoiceHeaderBean();
		List<GeneralPurchaseInvoiceProductDetailBean> alProductDetailList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			objPurchaseInvoiceHeaderBean = jdbcTemplate.queryForObject(GeneralPurchaseInvoiceQueryUtil.GET_GRN_HDR, new Object[] { igrnId }, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceHeaderBean.class));
			alProductDetailList = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.GET_GRN_DTL, new Object[] { igrnId }, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceProductDetailBean.class));
			for (GeneralPurchaseInvoiceProductDetailBean obInvoiceProductDetailBean : alProductDetailList) {
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
	public GeneralPurchaseInvoiceHeaderBean checkFreightCharges(int igrnId) {
		GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean = new GeneralPurchaseInvoiceHeaderBean();
		List<GeneralPurchaseInvoiceProductDetailBean> alProductDetailList = new ArrayList<>();
		List<GeneralPurchaseInvoiceProductDetailBean> checkGrnList = new ArrayList<>();
		List<GeneralPurchaseInvoiceHeaderBean> grnIdList = new ArrayList<>();
		try {

			double frieghtValue = 0, poTotalAmount = 0;
			int purchaseOrderId = 0;
			double totalChargesValue = 0;

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			checkGrnList = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.CHECK_FRIEGHT_VALUE, new Object[] { igrnId }, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceProductDetailBean.class));

			for (GeneralPurchaseInvoiceProductDetailBean dtlbean : checkGrnList) {
				frieghtValue = dtlbean.getFrieghtTotal();
				purchaseOrderId = dtlbean.getPurchaseOrderId();
				poTotalAmount = dtlbean.getPoTotalAmount();

			}
			if (purchaseOrderId > 0) {
				grnIdList = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.GET_GRNID_LIST, new Object[] { purchaseOrderId }, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceHeaderBean.class));

			}
			for (GeneralPurchaseInvoiceHeaderBean grnIdbean : grnIdList) {
				double chargeValue = 0;
				chargeValue = jdbcTemplate.queryForObject(GeneralPurchaseInvoiceQueryUtil.GET_TOTAL_CHARGES_LIST, Integer.class, new Object[] { grnIdbean.getGrnNo() });
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
	public GeneralPurchaseInvoiceHeaderBean getEditcheckFreightCharges(int igrnId) {
		GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceHeaderBean = new GeneralPurchaseInvoiceHeaderBean();
		List<GeneralPurchaseInvoiceProductDetailBean> alProductDetailList = new ArrayList<>();
		List<GeneralPurchaseInvoiceProductDetailBean> checkGrnList = new ArrayList<>();
		List<GeneralPurchaseInvoiceHeaderBean> grnIdList = new ArrayList<>();
		try {

			double frieghtValue = 0, poTotalAmount = 0;
			int purchaseOrderId = 0;
			double totalChargesValue = 0;

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			checkGrnList = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.CHECK_FRIEGHT_VALUE, new Object[] { igrnId }, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceProductDetailBean.class));

			for (GeneralPurchaseInvoiceProductDetailBean dtlbean : checkGrnList) {
				frieghtValue = dtlbean.getFrieghtTotal();
				poTotalAmount = dtlbean.getPoTotalAmount();
				purchaseOrderId = dtlbean.getPurchaseOrderId();
			}
			if (purchaseOrderId > 0) {
				grnIdList = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.GET_GRNID_LIST, new Object[] { purchaseOrderId }, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceHeaderBean.class));

			}
			for (GeneralPurchaseInvoiceHeaderBean grnIdbean : grnIdList) {
				double chargeValue = 0;
				if (igrnId != grnIdbean.getGrnNo()) {
					chargeValue = jdbcTemplate.queryForObject(GeneralPurchaseInvoiceQueryUtil.GET_TOTAL_CHARGES_LIST, Integer.class, new Object[] { grnIdbean.getGrnNo() });
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
	public GeneralPurchaseInvoiceHeaderBean getExchangeRates(String currencyCode) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		GeneralPurchaseInvoiceHeaderBean resultBean = new GeneralPurchaseInvoiceHeaderBean();
		List<GeneralPurchaseInvoiceHeaderBean> exchangeRatelist = new ArrayList<>();
		try {

			exchangeRatelist = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.GETEXCHANGERATE, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceHeaderBean.class), currencyCode);
			resultBean.setExchangeRatelist(exchangeRatelist);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Parent Address", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return resultBean;

	}

	@Override
	public GeneralPurchaseInvoiceHeaderBean getCurrencyCode(String supplierAcctCode) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		GeneralPurchaseInvoiceHeaderBean resultBean = new GeneralPurchaseInvoiceHeaderBean();
		List<GeneralPurchaseInvoiceHeaderBean> currencyCodelist = new ArrayList<>();
		try {
			currencyCodelist = jdbcTemplate.query(GeneralPurchaseInvoiceQueryUtil.GETCURRENCYCODE, new BeanPropertyRowMapper<>(GeneralPurchaseInvoiceHeaderBean.class), supplierAcctCode);
			resultBean.setCurrencyList(currencyCodelist);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Parent Address", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return resultBean;

	}

	@Override
	public GeneralPurchaseInvoiceHeaderBean printPaymentVoucher(String voucherNo) throws CustomException {

		GeneralPurchaseInvoiceHeaderBean objCashBankPaymentBean = new GeneralPurchaseInvoiceHeaderBean();
		String sJvNo = "";
		try {

			objCashBankPaymentBean = getPurchaseInvoiceHeaderDetailprint(voucherNo);

			List<GeneralPurchaseInvoiceProductDetailBean> lProductDetailList = new ArrayList<>();

			lProductDetailList = getPurchaseInvoiceProcuctDetailList(voucherNo);
			objCashBankPaymentBean.setPurchaseInvoiceProdDetail(lProductDetailList);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get lSubAccountList List", e);
		}

		return objCashBankPaymentBean;

	}
}