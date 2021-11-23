package com.dci.tenant.finance.paymentInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;

@Repository
public class PaymentInformationDAOImpl implements PaymentInformationDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(PaymentInformationDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<PaymentInformationDetailBean> getPaymentInforDtlist(PaymentInformationBean informationBean) throws CustomException {
		List<PaymentInformationDetailBean> informationDetailBeans = new ArrayList<>();
		String whereCond = "";
		try {
			informationDetailBeans = jdbcTemplate.query(PaymentInformationQueryUtil.GET_PAY_ORDER_LIST, new BeanPropertyRowMapper<>(PaymentInformationDetailBean.class), informationBean.getSupplier(), informationBean.getFromDate(), informationBean.getToDate(), informationBean.getCompanyCode(), informationBean.getSupplier(), informationBean.getFromDate(), informationBean.getToDate(), informationBean.getCompanyCode(), informationBean.getSupplier(), informationBean.getFromDate(), informationBean.getToDate(), informationBean.getCompanyCode());

			/*
			 * if (informationBean.getSupplier() != null &&
			 * !informationBean.getSupplier().isEmpty()) { whereCond = whereCond +
			 * " and supplier in (" + informationBean.getSupplier() + ")"; } if
			 * (informationBean.getFromDate() != null &&
			 * !informationBean.getFromDate().isEmpty()) { whereCond = whereCond +
			 * " and pih.partyinvoice_dt >=to_date('" + informationBean.getFromDate() +
			 * "','dd/mm/yyyy')"; }
			 * 
			 * if (informationBean.getToDate() != null &&
			 * !informationBean.getToDate().isEmpty()) { whereCond = whereCond +
			 * " and pih.due_dt <=to_date('" + informationBean.getToDate() +
			 * "','dd/mm/yyyy')"; }
			 * 
			 * informationDetailBeans =
			 * jdbcTemplate.query(PaymentInformationQueryUtil.GET_PAY_ORDER_LIST + whereCond
			 * + "", new BeanPropertyRowMapper<PaymentInformationDetailBean
			 * >(PaymentInformationDetailBean.class));
			 */
			
		System.out.println("testhgj");
		} catch (Exception e) {
			LOGGER.error("Error in slabRateList", e);
		}
		return informationDetailBeans;
	}

	@Override
	public boolean saveData(PaymentInformationBean informationBean) throws CustomException {
		boolean isSuccess = false;
		try {

			String paymentOrderNumber = null;

			int i, j;

			UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			paymentOrderNumber = jdbcTemplate.queryForObject(PaymentInformationQueryUtil.GET_PAYMENT_ORDER_NUMBER, String.class);

			informationBean.setPaymentOrderNo(paymentOrderNumber);

			i = jdbcTemplate.update(PaymentInformationQueryUtil.SAVE_PAYMENT_ORDER_HDR, new Object[] { informationBean.getPaymentOrderNo(), user.getUserId(), informationBean.getCompanyCode(), informationBean.getSupplier(), informationBean.getPoTcamt(), informationBean.getPoBcamt(), "Pending", informationBean.getPaymentOrderDate() }); // TODO

			if (i > 0) {

				for (PaymentInformationDetailBean detailBean : informationBean.getDetailBeans()) {
					if (detailBean.isSelect() == true) {
						j = jdbcTemplate.update(PaymentInformationQueryUtil.SAVE_PAYMENT_ORDER_DETAIL, new Object[] { informationBean.getPaymentOrderNo(), detailBean.getPartyInvoiceNo(), detailBean.getPartyInvoiceDt(), detailBean.getInvoiceNo(), detailBean.getInvoiceDate(), detailBean.getInvBcAmt(), detailBean.getInvTcAmt(), detailBean.getPayableTcAmt(), detailBean.getPayableBcAmt(), detailBean.getCompanyCode(), detailBean.getCurrencyCode(), detailBean.getExchangeRate(), detailBean.getDueDt() }); // TODO
						isSuccess = true;
					}
				}

			}

		} catch (Exception e) {
			LOGGER.error("Error in slabRateList", e);
		}
		return isSuccess;
	}

	@Override
	public List<PaymentInformationBean> getlist() throws CustomException {
		List<PaymentInformationBean> informationDetailBeans = new ArrayList<>();
		try {
			informationDetailBeans = jdbcTemplate.query(PaymentInformationQueryUtil.GET_PAYMENT_ORDER_LIST, new BeanPropertyRowMapper<>(PaymentInformationBean.class));

		} catch (Exception e) {
			LOGGER.error("Error in getlist", e);
		}
		return informationDetailBeans;
	}

	@Override
	public List<PaymentInformationBean> getlistDraft() throws CustomException {
		List<PaymentInformationBean> informationDetailBeans = new ArrayList<>();
		try {
			informationDetailBeans = jdbcTemplate.query(PaymentInformationQueryUtil.GET_PAYMENT_ORDER_LIST_DRAFT, new BeanPropertyRowMapper<>(PaymentInformationBean.class));

		} catch (Exception e) {
			LOGGER.error("Error in getlist", e);
		}
		return informationDetailBeans;
	}

	@Override
	public PaymentInformationBean editData(PaymentInformationBean informationBean) throws CustomException {
		PaymentInformationBean paymentInformationBean = new PaymentInformationBean();
		List<PaymentInformationDetailBean> detailList = new ArrayList<>();
		try {

			paymentInformationBean = jdbcTemplate.queryForObject(PaymentInformationQueryUtil.GET_POR_HDR, new Object[] { informationBean.getPaymentOrderNo() }, new BeanPropertyRowMapper<>(PaymentInformationBean.class));

			detailList = jdbcTemplate.query(PaymentInformationQueryUtil.GET_POR_DTL_LIST, new BeanPropertyRowMapper<>(PaymentInformationDetailBean.class), informationBean.getPaymentOrderNo());

			for (PaymentInformationDetailBean detailBean : detailList) {

				PaymentInformationDetailBean informationDetailBean = new PaymentInformationDetailBean();

				informationDetailBean = jdbcTemplate.queryForObject(PaymentInformationQueryUtil.GET_TOTAL_PAYABLE_AMOUNT, new Object[] { detailBean.getInvoiceNo() }, new BeanPropertyRowMapper<>(PaymentInformationDetailBean.class));
				detailBean.setTotalPaidBcAmt(informationDetailBean.getTotalPaidBcAmt());
				detailBean.setTotatlPaidTcAmt(informationDetailBean.getTotatlPaidTcAmt());
				detailBean.setTcBalanceAmt(informationDetailBean.getTcBalanceAmt());
				detailBean.setBcBalanceAmt(informationDetailBean.getBcBalanceAmt());
				detailBean.setPayableAmt(detailBean.getPayableBcAmt() + informationDetailBean.getBcBalanceAmt());

			}

			paymentInformationBean.setDetailBeans(detailList);

		} catch (Exception e) {
			LOGGER.error("Error in edit", e);
		}
		// TODO Auto-generated method stub
		return paymentInformationBean;
	}

	@Override
	public boolean updateData(PaymentInformationBean informationBean) throws CustomException {
		boolean isSuccess = false;
		// TODO Auto-generated method stub
		int i = 0, j = 0;
		try {
			i = jdbcTemplate.update(PaymentInformationQueryUtil.UPDATE_POR_HDR, new Object[] { informationBean.getPoBcamt(), informationBean.getPoTcamt(), informationBean.getPaymentOrderNo() }); // TODO
			for (PaymentInformationDetailBean detailBean : informationBean.getDetailBeans()) {
				j = jdbcTemplate.update(PaymentInformationQueryUtil.UPDATE_POR_DTL, new Object[] { detailBean.getPayableBcAmt(), detailBean.getPayableTcAmt(), detailBean.getPaymentOrderDetailId() }); // TODO
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("Error in edit", e);
		}
		return isSuccess;
	}

	@Override
	public boolean deleteData(String paymentInformationNo) throws CustomException {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		try {
			int iGLDel = jdbcTemplate.update(PaymentInformationQueryUtil.DELETE_POR_HDR, new Object[] { paymentInformationNo });

			int iGLDtl = jdbcTemplate.update(PaymentInformationQueryUtil.DELETE_POR_DTL, new Object[] { paymentInformationNo });
			isSuccess = true;
		}

		catch (Exception e) {
			LOGGER.error("Error in edit", e);
		}
		return isSuccess;
	}

	@Override
	public boolean approvedata(ArrayList<PaymentInformationBean> informationBean) throws CustomException {
		boolean isSuccess = false;
		// TODO Auto-generated method stub
		int i = 0, j = 0;
		try {
			UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			for (PaymentInformationBean objBean : informationBean) {
				if (objBean.isSelect() == true) {
					i = jdbcTemplate.update(PaymentInformationQueryUtil.UPDATE_POR_HDR_STATUS, new Object[] { "Approved", user.getUserId(), objBean.getApprovedDate(), objBean.getPaymentOrderNo() }); // TODO
				}

			}

			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("Error in edit", e);
		}
		return isSuccess;
	}

	public static String checkEmptyString(String s1) {
		if (s1 == null || s1.equalsIgnoreCase("null")) {
			return "";
		} else {
			return s1;
		}
	}

	@Override
	public List<PaymentInformationBean> showPendingReceiptInformationList(PaymentInformationBean objPaymentInformationBean) {

		System.out.println("show pending");
		List<PaymentInformationBean> alPendingPaymentInformationList = new ArrayList<>();
		// int sSupplierCode = objPaymentInformationBean.getSupplierCode();
		String sFromDate = objPaymentInformationBean.getPiFromDate();
		String sTodate = objPaymentInformationBean.getPiToDate();
		String sCompanyId = "";
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String sSupplierCode = objPaymentInformationBean.getSupplierName();

		if (objPaymentInformationBean.getCompanyCode() != null && objPaymentInformationBean.getCompanyCode() != "" && !objPaymentInformationBean.getCompanyCode().isEmpty())
			sCompanyId = objPaymentInformationBean.getCompanyCode();
		else
			sCompanyId = getCompanyId(userDetails.getUserId());
		try {

			String query = " SELECT to_char(DUE_DT, 'dd-mm-yyyy') dueDate ," + "PARTY_INVOICE_NO partyInvoiceNo, " + " to_char(PARTY_INV_DT, 'dd-mm-yyyy') partyInvoicedate ," + "INVOICE_NO invoiceNo, " + " to_char(INVOICE_DT, 'dd-mm-yyyy') invoiceDate," + " " + " CURRENCY currency ,LOCAL_AMOUNT bcAmount ,RATE exchangeRate ," + "LOCAL_AMOUNT_USD as tcAmount, VENDOR_NAME supplierName ," + "COALESCE(PENDING_AMT,LOCAL_AMOUNT) pendingAmount,"
					+ "(LOCAL_AMOUNT-COALESCE(PENDING_AMT,0.0)) as paidAmount,COMPANY_CODE as companyCode " + "FROM VIEW_RECEIPT_INFO_SUBMIT_TEST() WHERE " + " (COALESCE(PENDING_AMT,LOCAL_AMOUNT) > 0.1 OR pending_amt <-1 )  ";

			if (!"".equalsIgnoreCase(checkEmptyString(sSupplierCode)) && !"select".equalsIgnoreCase(checkEmptyString(sSupplierCode))) {
				query = query + " and supplier = '" + sSupplierCode + "'";
			}
			if (!"".equalsIgnoreCase(checkEmptyString(sCompanyId))) {
				query = query + " and COMPANY_CODE = '" + sCompanyId + "'";
			}

			if (!"".equalsIgnoreCase(checkEmptyString(sFromDate))) {
				query = query + " and dueDate >=to_date( '" + sFromDate + "' ,'dd-mm-yyyy')";
			}

			if (!"".equalsIgnoreCase(checkEmptyString(sTodate))) {
				query = query + " and dueDate <= to_date( '" + sFromDate + "' ,'dd-mm-yyyy')";
			}

			query = query + "  ORDER BY DUE_DT ";

			alPendingPaymentInformationList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(PaymentInformationBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alPendingPaymentInformationList;
	}

	@Override
	public List<PaymentInformationBean> showPendingPaymentInformationList(PaymentInformationBean objPaymentInformationBean) {

		System.out.println("show pending");
		List<PaymentInformationBean> alPendingPaymentInformationList = new ArrayList<>();
		// int sSupplierCode = objPaymentInformationBean.getSupplierCode();
		String sFromDate = objPaymentInformationBean.getPiFromDate();
		String sTodate = objPaymentInformationBean.getPiToDate();
		String sCompanyId = "";
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String sSupplierCode = objPaymentInformationBean.getSupplierName();

		if (objPaymentInformationBean.getCompanyCode() != null && objPaymentInformationBean.getCompanyCode() != "" && !objPaymentInformationBean.getCompanyCode().isEmpty())
			sCompanyId = objPaymentInformationBean.getCompanyCode();
		else
			sCompanyId = getCompanyId(userDetails.getUserId());
		try {

			String query = " SELECT to_char(DUE_DT, 'dd-mm-yyyy') dueDate ,PARTY_INVOICE_NO partyInvoiceNo, " + " to_char(PARTY_INV_DT, 'dd-mm-yyyy') partyInvoicedate ,INVOICE_NO invoiceNo, " + " to_char(INVOICE_DT, 'dd-mm-yyyy') invoiceDate, " + " CURRENCY currency ,LOCAL_AMOUNT bcAmount ,RATE exchangeRate ,LOCAL_AMOUNT_USD as tcAmount, VENDOR_NAME supplierName , " + " COALESCE(PENDING_AMT,LOCAL_AMOUNT) pendingAmount,(LOCAL_AMOUNT-COALESCE(PENDING_AMT,0.0)) as paidAmount,COMPANY_CODE as companyCode "
					+ "FROM VIEW_PAYMENT_INFO_SUBMIT_TEST() WHERE " + " (COALESCE(PENDING_AMT,LOCAL_AMOUNT) > 0.1 OR pending_amt <-1 )  ";

			if (!"".equalsIgnoreCase(checkEmptyString(sSupplierCode)) && !"select".equalsIgnoreCase(checkEmptyString(sSupplierCode))) {
				query = query + " and supplier = '" + sSupplierCode + "'";
			}
			if (!"".equalsIgnoreCase(checkEmptyString(sCompanyId))) {
				query = query + " and COMPANY_CODE = '" + sCompanyId + "'";
			}

			if (!"".equalsIgnoreCase(checkEmptyString(sFromDate))) {
				query = query + " and dueDate >=to_date( '" + sFromDate + "' ,'dd-mm-yyyy')";
			}

			if (!"".equalsIgnoreCase(checkEmptyString(sTodate))) {
				query = query + " and dueDate <= to_date( '" + sFromDate + "' ,'dd-mm-yyyy')";
			}

			query = query + "  ORDER BY DUE_DT ";

			alPendingPaymentInformationList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(PaymentInformationBean.class));
		} catch (Exception e) {
			LOGGER.error("Error in get Order List", e);
		}
		return alPendingPaymentInformationList;
	}

	private String getCompanyId(String userId) {
		String sCompanyId = "";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(PaymentInformationQueryUtil.GET_COMPANY_ID, new Object[] { userId });
		for (Map row : rows) {
			sCompanyId = (String) row.get("COMPANY_CODE");
		}
		return sCompanyId;
	}

}
