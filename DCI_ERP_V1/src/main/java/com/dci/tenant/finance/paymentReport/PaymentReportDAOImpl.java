package com.dci.tenant.finance.paymentReport;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.tenant.user.UserDetail;

@Repository
public class PaymentReportDAOImpl implements PaymentReportDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(PaymentReportDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public PaymentReportResultBean getList() {
		// TODO Auto-generated method stub
		PaymentReportResultBean manageEnquiryResultBean = new PaymentReportResultBean();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<PaymentHistoryReportBean> lManageEnquiryBean = new ArrayList<>();
		try {
			lManageEnquiryBean = jdbcTemplate.query(PaymentReportQueryUtil.list_new, new BeanPropertyRowMapper<>(PaymentHistoryReportBean.class));
			manageEnquiryResultBean.setLpaymentreport(lManageEnquiryBean);
			manageEnquiryResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return manageEnquiryResultBean;
	}

	@Override
	public List<PaymentHistoryReportBean> SearchList(PaymentHistoryReportBean bean) {

		List<PaymentHistoryReportBean> list = new ArrayList<>();

		String whereCond = "";
		try {

			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (bean.getSupplier() != null && !bean.getSupplier().isEmpty()) {
				whereCond = whereCond + " and entity.entity_id ='" + bean.getSupplier() + "'";
			}
			if (bean.getCompany() != null && !bean.getCompany().isEmpty()) {
				whereCond = whereCond + " and company_code ='" + bean.getCompany() + "'";
			}

			if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
				whereCond = whereCond + " and invoice_dt between to_date ('" + bean.getFromDate() + "','dd/mm/yyyy')";
			}

			if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
				whereCond = whereCond + "   and  to_date('" + bean.getToDate() + "','dd/mm/yyyy')";
			}

			list = jdbcTemplate.query(PaymentReportQueryUtil.search_list + whereCond + PaymentReportQueryUtil.list1 + whereCond + "", new BeanPropertyRowMapper<>(PaymentHistoryReportBean.class));

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in Getting Container List", e);
		}
		return list;
	}

}
