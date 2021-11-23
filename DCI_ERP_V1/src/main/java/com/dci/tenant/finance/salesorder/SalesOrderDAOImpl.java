package com.dci.tenant.finance.salesorder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CommonUtilityQueryUtil;
import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.user.UserDetail;

@Repository
public class SalesOrderDAOImpl implements SalesOrderDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(SalesOrderDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<SalesOrderBean> getSalesOrderList() throws CustomException {
		List<SalesOrderBean> salesOrderList = new ArrayList<SalesOrderBean>();
		salesOrderList = jdbcTemplate.query(SalesOrderQueryUtil.GET_SALES_ORDER_LIST, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class));
		return salesOrderList;
	}

	@Override
	public SalesOrderBean getSalesOrder(int salesOrderId) throws CustomException {
		SalesOrderBean salesOrder = new SalesOrderBean();
		salesOrder = jdbcTemplate.queryForObject(SalesOrderQueryUtil.EDIT_SALES_ORDER_HDR, new Object[] { salesOrderId }, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class));
		List<SalesOrderDtlBean> salesOrderDtlBeanList = null;
		salesOrderDtlBeanList = jdbcTemplate.query(SalesOrderQueryUtil.EDIT_SALES_ORDER_DTL, new Object[] { salesOrderId }, new BeanPropertyRowMapper<SalesOrderDtlBean>(SalesOrderDtlBean.class));
		salesOrder.setSalesOrderTables(salesOrderDtlBeanList);
		return salesOrder;
	}

	@Override
	public SalesOrderResultBean getDropDownList() throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		SalesOrderResultBean salesOrderResultBean = new SalesOrderResultBean();
		List<SalesOrderBean> employeeList = new ArrayList<SalesOrderBean>();
		List<SalesOrderBean> cityList = new ArrayList<SalesOrderBean>();
		List<SalesOrderBean> cityList1 = new ArrayList<SalesOrderBean>();
		List<SalesOrderBean> companyList = new ArrayList<SalesOrderBean>();
		List<SalesOrderBean> customerList = new ArrayList<SalesOrderBean>();
		List<SalesOrderDtlBean> itemList = new ArrayList<SalesOrderDtlBean>();
		List<SalesOrderDtlBean> taxList = new ArrayList<SalesOrderDtlBean>();
		try {
			companyList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_COMPANY_LIST, new Object[] { userDetails.getCompanyCode() }, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class));
			salesOrderResultBean.setCompanyList(companyList);
			employeeList = jdbcTemplate.query(SalesOrderQueryUtil.GET_EMPLOYEE_LIST, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class));
			salesOrderResultBean.setEmployeeList(employeeList);
			cityList = jdbcTemplate.query(SalesOrderQueryUtil.GET_CITY_LIST, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class));
			salesOrderResultBean.setCityList(cityList);
			cityList1 = jdbcTemplate.query(SalesOrderQueryUtil.GET_CITY_LIST1, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class));
			salesOrderResultBean.setCityList1(cityList1);
			customerList = jdbcTemplate.query(SalesOrderQueryUtil.GET_CUSTOMER_LIST, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class), userDetails.getCompanyCode());
			salesOrderResultBean.setCustomerList(customerList);
			itemList = jdbcTemplate.query(SalesOrderQueryUtil.GET_ITEM_LIST, new BeanPropertyRowMapper<SalesOrderDtlBean>(SalesOrderDtlBean.class), userDetails.getCompanyCode());
			salesOrderResultBean.setItemList(itemList);
			taxList = jdbcTemplate.query(SalesOrderQueryUtil.GET_TAX_LIST, new BeanPropertyRowMapper<SalesOrderDtlBean>(SalesOrderDtlBean.class));
			salesOrderResultBean.setTaxList(taxList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return salesOrderResultBean;
	}

	@Override
	public boolean save(SalesOrderBean salesOrderBean) throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean isSucc = false;
		try {
			String salesOrderCode = jdbcTemplate.queryForObject(SalesOrderQueryUtil.GENERATE_SALES_ORDER_CODE, String.class);
			System.err.println("sales order code=" + salesOrderCode);
			if (salesOrderCode != null && !salesOrderCode.isEmpty()) {
				salesOrderBean.setStatus("Pending");
				int salesOrderId = jdbcTemplate.queryForObject(SalesOrderQueryUtil.SAVE_SALES_ORDER_HDR, new Object[] { salesOrderCode, salesOrderBean.getSalesOrderDate(), salesOrderBean.getHaspitalCode(), userDetails.getUserId(), Integer.parseInt(salesOrderBean.getCustomerCode()), salesOrderBean.getCustomerNote(), salesOrderBean.getStatus(), salesOrderBean.getTotalTax(), salesOrderBean.getTotalAmount(), salesOrderBean.getNetAmount() }, Integer.class);
				for (int i = 0; i < salesOrderBean.getSalesOrderTables().size(); i++) {
					SalesOrderDtlBean salesOrderDtlBean = salesOrderBean.getSalesOrderTables().get(i);
					jdbcTemplate.update(SalesOrderQueryUtil.SAVE_SALES_ORDER_DTL, new Object[] { salesOrderId, Integer.parseInt(salesOrderDtlBean.getItemId()), salesOrderDtlBean.getQty(), salesOrderDtlBean.getPrice(), salesOrderDtlBean.getTaxAmount(), Integer.parseInt(salesOrderDtlBean.getTaxId()), salesOrderDtlBean.getAmount() });
				}
			}
			isSucc = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return isSucc;
	}

	@Override
	public boolean update(SalesOrderBean salesOrderBean) throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean isSucc = false;
		try {

			jdbcTemplate.update(SalesOrderQueryUtil.DELETE_SALES_ORDER_DTL, new Object[] { salesOrderBean.getSalesOrderId() });
			if (salesOrderBean.getSalesOrderId() > 0) {
				jdbcTemplate.update(SalesOrderQueryUtil.UPDATE_SALES_ORDER_HDR, new Object[] { salesOrderBean.getSalesOrderDate(), salesOrderBean.getHaspitalCode(), userDetails.getUserId(), Integer.parseInt(salesOrderBean.getCustomerCode()), salesOrderBean.getCustomerNote(), salesOrderBean.getStatus(), salesOrderBean.getTotalTax(), salesOrderBean.getTotalAmount(), salesOrderBean.getNetAmount(), salesOrderBean.getSalesOrderId() });
				for (int i = 0; i < salesOrderBean.getSalesOrderTables().size(); i++) {
					SalesOrderDtlBean salesOrderDtlBean = salesOrderBean.getSalesOrderTables().get(i);
					if (salesOrderDtlBean.getTaxId() == null || salesOrderDtlBean.getTaxId() == "") {
						salesOrderDtlBean.setTaxId("0");
					}
					jdbcTemplate.update(SalesOrderQueryUtil.SAVE_SALES_ORDER_DTL, new Object[] { salesOrderBean.getSalesOrderId(), Integer.parseInt(salesOrderDtlBean.getItemId()), salesOrderDtlBean.getQty(), salesOrderDtlBean.getPrice(), salesOrderDtlBean.getTaxAmount(), Integer.parseInt(salesOrderDtlBean.getTaxId()), salesOrderDtlBean.getAmount() });

				}
			}
			isSucc = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return isSucc;
	}

	@Override
	public boolean deleteSalesOrder(int salesOrderId) throws CustomException {
		System.err.println("delete dao");
		boolean isSucc = false;
		try {

			jdbcTemplate.update(SalesOrderQueryUtil.DELETE_SALES_ORDER_DTL, new Object[] { salesOrderId });
			jdbcTemplate.update(SalesOrderQueryUtil.DELETE_SALES_ORDER_HDR, new Object[] { salesOrderId });

			isSucc = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return isSucc;
	}
}