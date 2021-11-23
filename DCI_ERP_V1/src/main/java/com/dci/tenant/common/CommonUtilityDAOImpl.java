package com.dci.tenant.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BatchAttributeBean;
import com.dci.common.util.CommonUtilityQueryUtil;
import com.dci.common.util.CommonUtilityStockBean;
import com.dci.common.util.CommonUtillityAssetTrackDetailBean;
import com.dci.common.util.CustomException;
import com.dci.common.util.DefTableBean;
import com.dci.inventory.stocktransfer.StockTransferQueryUtil;
import com.dci.master.attributes.AttributeBean;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.finance.grn.GRNQueryUtil;
import com.dci.tenant.finance.transferReceived.TransferReceivedBean;
import com.dci.tenant.finance.transferReceived.TransferReceivedDetailBean;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")
public class CommonUtilityDAOImpl implements CommonUtilityDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(CommonUtilityDAOImpl.class);

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	String transLocation = "";
	
	 
	
	@Autowired
	UserLogDAO userlogDao;
	
	private String consumptionLocation = "Consumption";
	
	private String inTransistLocation ="In Transit";
	
	private String consumedLocation = "All Consumable";

@Override
	public List<SelectivityBean> geLocation1() {
		List<SelectivityBean> lCommonUtilityBean = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.LOCATION,new Object[]{},
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}
	
	@Override
	public  CommonUtilityBean getCompanyName() {
		 CommonUtilityBean lCommonUtilityBean = new  CommonUtilityBean();
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			String location="";
			List<Map<String, Object>> rows12= jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_EMP_LOCATION,new Object[]{userId});
		
			for (Map row : rows12) {
				lCommonUtilityBean.setText(String.valueOf(row.get("company_code")));	
				lCommonUtilityBean.setId(userId);		
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}
	
	
	
	
	@Override
	public List<DefTableBean> getDefTableList(Integer formFieldId) {
		List<DefTableBean> defTableList = null;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			defTableList = jdbcTemplate.query(CommonUtilityQueryUtil.SELECT_DEF_TABLE_LIST, new BeanPropertyRowMapper<DefTableBean>(DefTableBean.class), new Object[] { formFieldId });

		} catch (DataAccessException e) {
			LOGGER.error("Error in getDefTableList", e);
		}
		return defTableList;
	}

	
	@Override
	public List<CommonUtilityBean> getCustomer() {

		List<CommonUtilityBean> customerList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			customerList = jdbcTemplate.query(CommonUtilityQueryUtil.get_Customer,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			return customerList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get customerList", e);
		}
		return customerList;
	
	}
	
	@Override
	public List<CommonUtilityBean> getSupplier() {

		List<CommonUtilityBean> supplierList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			supplierList = jdbcTemplate.query(CommonUtilityQueryUtil.get_Supplier,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			return supplierList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get customerList", e);
		}
		return supplierList;
	
	}
	@Override
	public List<CommonUtilityBean> getVendor() {

		List<CommonUtilityBean> supplierList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			supplierList = jdbcTemplate.query(CommonUtilityQueryUtil.get_Vendor,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			return supplierList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get customerList", e);
		}
		return supplierList;
	
	}
	

	@Override
	public List<CommonUtilityBean> geLocation() {
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.LOCATION,new Object[]{},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}
	
	

	@Override
	public List getSector() {
		List lCommonUtilityBean = new ArrayList();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.serviceIdandName);

			for (Map row : rows) {
				CommonUtilityBean bean = new CommonUtilityBean();
				bean.setId((String) row.get("sector_code"));
				bean.setText((String) row.get("sector_code")+"-"+(String) row.get("sector_name"));
				bean.setSectorCode((String) row.get("sector_code"));
				bean.setSectorName((String) row.get("sector_name"));
				bean.setBaseCompany((String) row.get("sec_company_code"));
				lCommonUtilityBean.add(bean);

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getPort", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List getPort() {
		List lCommonUtilityBean = new ArrayList();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_PORT_LIST);

			for (Map row : rows) {
				CommonUtilityBean bean = new CommonUtilityBean();
				bean.setId((String) row.get("id"));
				bean.setText((String) row.get("text"));
				bean.setPortCode((String) row.get("id"));

				lCommonUtilityBean.add(bean);

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getPort", e);
		}
		return lCommonUtilityBean;
	}
	
	
	
	@Override
	public List getTerminal() {
		List lCommonUtilityBean = new ArrayList();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_TERMINAL_LIST);

			for (Map row : rows) {
				CommonUtilityBean bean = new CommonUtilityBean();
				bean.setId((String) row.get("id"));
				bean.setText((String) row.get("text"));
				bean.setTerminalCode((String) row.get("id"));

				lCommonUtilityBean.add(bean);

			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in get Terminal", e);
		}
		return lCommonUtilityBean;
	}
	
	
	/**
	 * get Account Head Data from ACCOUNT_HEAD_MASTER tbl
	 */
	@Override
	public List<CommonUtilityBean> getAccountHeadData() {
		List lCommonUtilityBean = new ArrayList();
		CommonUtilityBean bean = null;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.sGetAccountHeadList);

			for (Map row : rows) {
				bean = new CommonUtilityBean();
				bean.setText((String) row.get("ACCT_HEAD_NAME"));
				bean.setId((String) row.get("ACCT_HEAD_CODE"));
				bean.setAccountHeadName((String) row.get("ACCT_HEAD_NAME"));
				bean.setAccountHeadCode((String) row.get("ACCT_HEAD_CODE"));
				bean.setCurrencyCode((String) row.get("ACCT_CURRENCY"));
				double exgRate = (Double) row.get("EXCHANGE_RATE");
				bean.setExchangeRate(exgRate);

				lCommonUtilityBean.add(bean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
	}
	
	@Override
	public List<SelectivityBean> getContainerTypeList() {
		List<SelectivityBean> lCommonUtilityBean = new ArrayList<SelectivityBean>();
		CommonUtilityBean bean = null;
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.GET_CNTR_TYPE_LIST,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			

		} catch (DataAccessException e) {
			LOGGER.error("Error in getContainerTypeList", e);
		}
		return lCommonUtilityBean;
	}
	
	@Override
	public List<SelectivityBean> getLeaseAggTypeList() {
		List<SelectivityBean> lCommonUtilityBean = new ArrayList<SelectivityBean>();
		CommonUtilityBean bean = null;
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.LEASE_AGGREMENT_TYPE_LIST,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			

		} catch (DataAccessException e) {
			LOGGER.error("Error in getLeaseAggTypeList", e);
		}
		return lCommonUtilityBean;
	}
	
	
	
	@Override
	public List<SelectivityBean> getCustomerCateory() {
		List<SelectivityBean> lCommonUtilityBean = new ArrayList<SelectivityBean>();
		CommonUtilityBean bean = null;
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.GET_customer_category_LIST,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getAccountHeadData1() {
		List lCommonUtilityBean = new ArrayList();
		CommonUtilityBean bean = null;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.sGetAccountHeadListdata);

			for (Map row : rows) {
				bean = new CommonUtilityBean();
				bean.setText((String) row.get("ACCT_HEAD_NAME"));
				bean.setId((String) row.get("ACCT_HEAD_CODE"));
				bean.setAccountHeadName((String) row.get("ACCT_HEAD_NAME"));
				bean.setAccountHeadCode((String) row.get("ACCT_HEAD_CODE"));
				bean.setCurrencyCode((String) row.get("ACCT_CURRENCY"));			
				

				lCommonUtilityBean.add(bean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getPhcContainers() {
		List lCommonUtilityBean = new ArrayList();
		CommonUtilityBean bean = null;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.sGetPhcContainerList);

			for (Map row : rows) {
				bean = new CommonUtilityBean();
				bean.setText((String) row.get("CONTAINER_TYPE"));
				bean.setId((String) row.get("CONTAINER_TYPE"));
				lCommonUtilityBean.add(bean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
	}
	
	@Override
	public List<CommonUtilityBean> getSLot() {
		List lCommonUtilityBean = new ArrayList();
		CommonUtilityBean bean = null;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.getSlot);

			for (Map row : rows) {
				bean = new CommonUtilityBean();
				bean.setText((String) row.get("text"));
				bean.setId((String) row.get("id"));
				lCommonUtilityBean.add(bean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getSLot", e);
		}
		return lCommonUtilityBean;
	}
	
	@Override
	public List<CommonUtilityBean> getSubSLot() {
		List lCommonUtilityBean = new ArrayList();
		CommonUtilityBean bean = null;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.getSubSlot);

			for (Map row : rows) {
				bean = new CommonUtilityBean();
				bean.setText((String) row.get("text"));
				bean.setId((String) row.get("id"));
				lCommonUtilityBean.add(bean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getSLot", e);
		}
		return lCommonUtilityBean;
	}
	
	
	@Override
	public List<CommonUtilityBean> getSurchargePort() {
		List lCommonUtilityBean = new ArrayList();
		CommonUtilityBean bean = null;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.GET_SUR_PORT,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getSubAccountCodeData() {
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();

		CommonUtilityBean bean = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.sGetSubAccountList,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
	}

 

	@Override
	public List<CommonUtilityBean> getEmployeeList() {
		List<CommonUtilityBean> lEmployeeList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			lEmployeeList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_EMPLOYEE_LIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in lEmployeeList", e);
		}
		return lEmployeeList;
	}

	@Override
	public List<CommonUtilityBean> getPortList() {
		List<CommonUtilityBean> lPortList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			lPortList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_PORT_LIST, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getPortList", e);
		}
		return lPortList;
	}
	
	@Override
	public List<CommonUtilityBean> getVendorList() {
		
		List<CommonUtilityBean> VendorLis = new ArrayList<CommonUtilityBean>();
		try {
			VendorLis = jdbcTemplate.query(CommonUtilityQueryUtil.GET_VENDOR_LIST, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getPortList", e);
		}
		return VendorLis;
	}

	
	@Override
	public List<CommonUtilityBean> getStuffingList() {
		
		List<CommonUtilityBean> stuffList = new ArrayList<CommonUtilityBean>();
		try {
			stuffList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_Stuff_LIST, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getPortList", e);
		}
		return stuffList;
	}
	
	
	
	@Override
	public List<CommonUtilityBean> getPortISO_portList() {
		List<CommonUtilityBean> lPortList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			lPortList = jdbcTemplate.query(CommonUtilityQueryUtil.getPortISO_portList, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getPortISO_portList", e);
		}
		return lPortList;
	}

	@Override
	public List<CommonUtilityBean> getDepartmentList() {
		List<CommonUtilityBean> lDepartmentList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			lDepartmentList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_DEPARTMENT_LIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getDepartmentList", e);
		}
		return lDepartmentList;
	}

	@Override
	public List<CommonUtilityBean> getAgentList() {
		List<CommonUtilityBean> lAgentList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			if (!"E294".equals(userId)) {
				lAgentList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_AGENT_LIST,
						new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			} else {
				lAgentList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_AGENT_LIST_FOR_AGENT_LOGIN,
						new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAgentList", e);
		}
		return lAgentList;
	}

	@Override
	public List<CommonUtilityBean> getCountryList() {
		List<CommonUtilityBean> lCountryList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			lCountryList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_COUNTRY_LIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getCountryList", e);
		}
		return lCountryList;
	}

	@Override
	public List<CommonUtilityBean> getDesignationList() {
		List<CommonUtilityBean> lDesignationList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lDesignationList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_DESIGNATION_LIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getDesignationList", e);
		}
		return lDesignationList;
	}

	@Override
	public List<CommonUtilityBean> getCustomerList() {
		List<CommonUtilityBean> lCustomerList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCustomerList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_CUSTOMER_LIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getDesignationList", e);
		}
		return lCustomerList;
	}

	@Override
	public double getExchangeRate(String currencyCode) {
		double dExchangeRate = 1.0;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			dExchangeRate = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.GET_EXCHANGE_RATE, Double.class, currencyCode, currencyCode);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get currencyCode List", e);
		}
		return dExchangeRate;
	}

	@Override
	public double getDefaultExchangeRate(String currencyCode) {
		double dExchangeRate = 1.0;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			dExchangeRate = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.GET__DEFAULT_EXCHANGE_RATE, Double.class, currencyCode);
		} catch (DataAccessException e) {
			dExchangeRate = 1.0;
			LOGGER.error("Error in Get currencyCode List", e);
		}
		return dExchangeRate;
	}

	@Override
	public List<CommonUtilityBean> getVesselList() {
		List<CommonUtilityBean> vesselList = new ArrayList<CommonUtilityBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			vesselList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_VESSEL_LIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			return vesselList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Voyage List", e);
		}
		return vesselList;
	}
	
	
	@Override
	public List<CommonUtilityBean> getQuoteApproveList() {
		List<CommonUtilityBean> vesselList = new ArrayList<CommonUtilityBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String port= "";
			/*String port = jdbcTemplate.queryForObject(SalesBookingQueryUtil.port_user,
					(String.class),userDetails.getUserId());
*/
					port=port.replace(",","','");
			if(!port.equalsIgnoreCase(null) && !port.equalsIgnoreCase("")) {
				vesselList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_QUOTE_LIST+" and (pol_id in ('"+port+"') or  pod_id in ('"+port+"')) order by  qttn_bin ASC",
						new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
				System.out.println(CommonUtilityQueryUtil.GET_QUOTE_LIST+" and (pol_id in ('"+port+"') or  pod_id in ('"+port+"')) order by  qttn_bin ASC");
			}else {
			
			vesselList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_QUOTE_LIST+" order by  qttn_bin ASC",
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			System.out.println(CommonUtilityQueryUtil.GET_QUOTE_LIST+" order by  qttn_bin ASC");

			}
			return vesselList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Voyage List", e);
		}
		return vesselList;
	}
	
	@Override
	public List<CommonUtilityBean> getQuoteApproveList1(String carrier,int mode) {
		List<CommonUtilityBean> vesselList = new ArrayList<CommonUtilityBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
String query="";
String port ="";
			//String port = jdbcTemplate.queryForObject(SalesBookingQueryUtil.port_user,
					//(String.class),userDetails.getUserId());

			if(carrier.equals("undefined") || carrier.equals(null) || carrier.equals("")) {
			}else {
				query=" and crrr_nam='"+carrier+"' ";

			}
			if((port==null && port=="") || (!port.equalsIgnoreCase(null) && !port.equalsIgnoreCase(""))) {
				port=port.replace(",","','");

				vesselList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_QUOTE_LIST+ query +" and qttn_md_id="+mode+" and (pol_id in ('"+port+"') or  pod_id in ('"+port+"')) order by  qttn_bin ASC",
						new Object[] {},new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
				System.out.println(CommonUtilityQueryUtil.GET_QUOTE_LIST+query+"   and qttn_md_id="+mode+" and (pol_id in ('"+port+"') or  pod_id in ('"+port+"')) order by  qttn_bin ASC");
			}else {
			
			vesselList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_QUOTE_LIST+query +" and qttn_md_id="+mode+" order by  qttn_bin ASC",
					new Object[] {},new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			System.out.println(CommonUtilityQueryUtil.GET_QUOTE_LIST+query+" and qttn_md_id="+mode+" order by  qttn_bin ASC");

			}
			return vesselList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Voyage List", e);
		}
		return vesselList;
	}
	@Override
	public List<CommonUtilityBean> getQuoteApproveList_port(String carrier, String mode, String customer, String pol,
			String pod) {
		List<CommonUtilityBean> vesselList = new ArrayList<CommonUtilityBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
String query="";
String port = "";
			/*String port = jdbcTemplate.queryForObject(SalesBookingQueryUtil.port_user,
					(String.class),userDetails.getUserId());
*/
		    if(!carrier.equalsIgnoreCase("undefined") && !carrier.equalsIgnoreCase(null) && !carrier.equalsIgnoreCase("")) {
			query=query+" and crrr_nam='"+carrier+"' ";
			}
	        if(!mode.equalsIgnoreCase("undefined") && !mode.equalsIgnoreCase(null) && !mode.equalsIgnoreCase("")) {
					query=query+" and qttn_md_id='"+mode+"' ";
			}if(!customer.equalsIgnoreCase("undefined") && !customer.equalsIgnoreCase(null) && !customer.equalsIgnoreCase("")) {
				query=query+" and cstmr_bin='"+customer+"' ";
	        }if(!pol.equalsIgnoreCase("undefined") && !pol.equalsIgnoreCase(null) && !pol.equalsIgnoreCase("")) {
	    	   query=query+" and pol_id='"+pol+"' ";
	        }if(!pod.equalsIgnoreCase("undefined") && !pod.equalsIgnoreCase(null) && !pod.equalsIgnoreCase("")) {
	    	   query=query+" and pod_id='"+pod+"' ";
		    }
			 if((port==null && port=="") || (!port.equalsIgnoreCase(null) && !port.equalsIgnoreCase(""))) {
				port=port.replace(",","','");

				vesselList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_QUOTE_LIST+ query +"  and (pol_id in ('"+port+"') or  pod_id in ('"+port+"')) order by  qttn_bin ASC",
						new Object[] {},new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
				System.out.println(CommonUtilityQueryUtil.GET_QUOTE_LIST+query+"  and (pol_id in ('"+port+"') or  pod_id in ('"+port+"')) order by  qttn_bin ASC");
			}else {
			
			vesselList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_QUOTE_LIST+query +"  order by  qttn_bin ASC",
					new Object[] {},new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			System.out.println(CommonUtilityQueryUtil.GET_QUOTE_LIST+query+" order by  qttn_bin ASC");

			}
			return vesselList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Voyage List", e);
		}
		return vesselList;
	}
	
	@Override
	public List<CommonUtilityBean> getLeasingPartyList() {
		List<CommonUtilityBean> LeasingPartyList = new ArrayList<CommonUtilityBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			LeasingPartyList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_LEASING_PARTY_LIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			return LeasingPartyList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Leasing Party List", e);
		}
		return LeasingPartyList;
	}
	

	@Override
	public List<CommonUtilityBean> getSectorList() {
		List<CommonUtilityBean> sectorlist = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			sectorlist = jdbcTemplate.query(CommonUtilityQueryUtil.GET_SECTOR_LIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			return sectorlist;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Voyage List", e);
		}
		return sectorlist;
	}

	@Override
	public List<CommonUtilityBean> getVoyageList() {
		List<CommonUtilityBean> voyageList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			voyageList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_VOYAGE_LIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			return voyageList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Voyage List", e);
		}
		return voyageList;
	}

	@Override
	public List<SelectivityBean> getVoyageListByVessel(String vsl) {
		List<SelectivityBean> voyageList = new ArrayList<SelectivityBean>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String whereCond = "";

		try {
			if(userDetails.getIsVendor() != null) {
				if(userDetails.getIsVendor().equalsIgnoreCase("Y")){
					voyageList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_VOYAGE_BY_AGENT_VSL(userDetails.getUserPortStr()),
							new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),vsl);
				}
			else {
				voyageList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_VOYAGE_LIST_BY_VSL,
						new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),vsl);
			}
			}
			else {
				voyageList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_VOYAGE_LIST_BY_VSL,
						new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),vsl);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Voyage List", e);
		}
		return voyageList;
	} 
	@Override
	public List<SelectivityBean> getVoyageListByVessel1(String vsl) {
		List<SelectivityBean> voyageList = new ArrayList<SelectivityBean>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String whereCond = "";

		try {
			if(userDetails.getIsVendor() != null) {
				if(userDetails.getIsVendor().equalsIgnoreCase("Y")){
					voyageList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_VOYAGE_BY_AGENT_VSL(userDetails.getUserPortStr()),
							new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),vsl);
				}
			else {
				voyageList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_VOYAGE_LIST_BY_VSL_1,
						new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),vsl);
			}
			}
			else {
				voyageList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_VOYAGE_LIST_BY_VSL_1,
						new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),vsl);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Voyage List", e);
		}
		return voyageList;
	} 
	
	@Override
	public List<SelectivityBean> getPortListByVoyage(String pod) {
		List<SelectivityBean> portList = new ArrayList<SelectivityBean>();
		try {
			portList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_PORT_LIST_BY_VOYAGE,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),pod);
			return portList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Voyage List", e);
		}
		return portList;
	}
	
	
	@Override
	public List<SelectivityBean> getPortListByVoy(String voy) {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<SelectivityBean> portList = new ArrayList<SelectivityBean>();
		String whereCond = "";
		try {
			if("Y".equalsIgnoreCase(userDetails.getIsVendor())) {
				whereCond = " and port in ("+userDetails.getUserPortStr()+") ";
			}
			portList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_PORT_LIST_BY_VOY_WO_SEQ+whereCond+" order by  port_seq::integer",
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),voy);
			return portList;
		} catch (Exception e) {
			LOGGER.error("Error in Get port List", e);
		}
		return portList;
	}
	
	@Override
	public List<SelectivityBean> getPortListByVoyNU(String voy) {
		List<SelectivityBean> portList = new ArrayList<SelectivityBean>();
		String whereCond = "";
		try {
			portList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_PORT_LIST_BY_VOY_WO_SEQ+whereCond+" order by  port_seq::integer",
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),voy);
			return portList;
		} catch (Exception e) {
			LOGGER.error("Error in Get port List", e);
		}
		return portList;
	}
	
	@Override
	public List<CommonUtilityBean> getTripList() {
		List<CommonUtilityBean> voyageList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			voyageList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_TRIP_LIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			return voyageList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Voyage List", e);
		}
		return voyageList;
	}

	@Override
	public List<CommonUtilityBean> getSupplierList() {
		List<CommonUtilityBean> supplierList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			supplierList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_SUPPLIER_LIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			return supplierList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Voyage List", e);
		}
		return supplierList;
	}

	@Override
	public List<CommonUtilityBean> getCompanyList() {
		List<CommonUtilityBean> companyList = new ArrayList<CommonUtilityBean>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			companyList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_COMPANY_LIST, new Object[] { userId },
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			return companyList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Voyage List", e);
		}
		return companyList;
	}

 

	@Override
	public List<CommonUtilityBean> getAccountSgList(String sSubGroupCode) {
		List<CommonUtilityBean> lAccountsSgList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lAccountsSgList = jdbcTemplate.query(CommonUtilityQueryUtil.sGetAccountSgList, new Object[] { sSubGroupCode },
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GetlAttributeList", e);
		}
		return lAccountsSgList;
	}
//only payers
	@Override
	public List<CommonUtilityBean> getSubAccountCodeListTradeDebtors() {
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.GET_SUBACCOUNT_TRADE_DEBTORS,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getSubAccountCodeListTradeCreditors() {
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.GET_SUBACCOUNT_TRADE_CREDITORS,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public boolean checkUniqueNameExists(String value, String fieldName, String screenName) {
		boolean isSuccess = false;
		int count = 0;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (screenName.equalsIgnoreCase("currency")) {// CurrencyScreen
				if (fieldName.equalsIgnoreCase("currencyCode")) {
					count = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.CHECK_CURRENCY_CODE_EXISTS, new Object[] { value }, Integer.class);
					if (count > 0)
						isSuccess = true;
				} else if (fieldName.equalsIgnoreCase("currencyName")) {
					count = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.CHECK_CURRENCY_NAME_EXISTS, new Object[] { value }, Integer.class);
					if (count > 0)
						isSuccess = true;
				}
			} else if (screenName.equalsIgnoreCase("accountHeadMaster")) { // AccountHeadScreen
				if (fieldName.equalsIgnoreCase("accountHeadName")) {
					count = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.CHECK_ACCOUNT_HEAD_NAME_EXISTS, new Object[] { value }, Integer.class);
					if (count > 0)
						isSuccess = true;
				}
			} else if (screenName.equalsIgnoreCase("subGroupAcctMaster")) { // SubGroupAcctScreen
				if (fieldName.equalsIgnoreCase("subGroupName")) {
					count = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.CHECK_SUB_GROUP_ACCT_NAME_EXISTS, new Object[] { value },
							Integer.class);
					if (count > 0)
						isSuccess = true;
				}
			} else if (screenName.equalsIgnoreCase("customerMaster")) { // customerScreen
				if (fieldName.equalsIgnoreCase("customerName")) {
					count = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.CHECK_CUSTOMER_NAME_EXISTS, new Object[] { value }, Integer.class);
					if (count > 0)
						isSuccess = true;
				}
			} else if (screenName.equalsIgnoreCase("cashAndBankMaster")) { // CashAndBankScreen
				if (fieldName.equalsIgnoreCase("bankName")) {
					count = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.CHECK_CASHBANK_NAME_EXISTS, new Object[] { value }, Integer.class);
					if (count > 0)
						isSuccess = true;
				}
			} else if (screenName.equalsIgnoreCase("consigneeMaster")) { // consigneeMasterScreen
				if (fieldName.equalsIgnoreCase("consigneeName")) {
					System.out.println("fieldName:::::::::CONSIGNEE::::::::::::" + fieldName);
					count = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.CHECK_CONSIGNEE_NAME_EXISTS, new Object[] { value }, Integer.class);
					System.out.println("count:::::::::CONSIGNEE::::::::::::" + count);
					if (count > 0)
						isSuccess = true;
				}
			} else if (screenName.equalsIgnoreCase("leadMaster")) {
				if (fieldName.equalsIgnoreCase("leadName")) {
					count = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.CHECK_LEAD_NAME_EXISTS, new Object[] { value }, Integer.class);
					if (count > 0)
						isSuccess = true;
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in GetlAttributeList", e);
		}
		return isSuccess;
	}

	@Override
	public List<CommonUtilityBean> getCostCentreList() {
		List<CommonUtilityBean> lCostCenterList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCostCenterList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_COST_CENTRE_LIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GetlAttributeList", e);
		}
		return lCostCenterList;
	}

	 

	@Override
	public List<CommonUtilityBean> getCompanyLocationList() {
		List<CommonUtilityBean> companyList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			companyList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_COMPANY_LOCATION_LIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Voyage List", e);
		}
		return companyList;
	}
	
	@Override
	public List<CommonUtilityBean> getCompanyLocationListForBunker() {
		List<CommonUtilityBean> companyList = new ArrayList<CommonUtilityBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			companyList = jdbcTemplate.query(CommonUtilityQueryUtil.getCompanyLocationListForBunker,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get getCompanyLocationListForBunker", e);
		}
		return companyList;
	}

	@Override
	public List<SelectivityBean> getStaffListForAdvances() {
	//	List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		List<SelectivityBean> lCommonUtilityBean2 = new ArrayList<>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCommonUtilityBean2 = jdbcTemplate.query(CommonUtilityQueryUtil.GET_STAFF_LIST,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean2;
	}
	
	
	
	
	

	@Override
	public List<CommonUtilityBean> getSubAccountCodeListTradeDebtorsCP() {
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.GET_SUBACCOUNT_TRADE_DEBTORS_CUSTOMER_ONLY,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
		


	}
	
	//getonlySupplier
	
	@Override
	public List<CommonUtilityBean> getonlySupplier(String accountCode) {
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(accountCode.equals("10080003") || accountCode.equals("10080001")|| accountCode.equals("10010004")) {
				lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.getonlySupplier_deptors,new Object[]{},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			}else if(accountCode.equals("20010003") || accountCode.equals("20010001") || accountCode.equals("20000003")||  accountCode.equals("20000001") ) {	
				lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.getonlySupplier_creditors,new Object[]{},
						new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
	

	}

	@Override
	public List<CommonUtilityBean> getonlypayer() {
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.getonlyTDSSupplier,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
	

	}
	 

 
	@Override
	public List<CommonUtilityBean> getonlypayerForJV() {
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.jv_payer,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
	

	}
	
	@Override
	public List<CommonUtilityBean> getcustomerList() {
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.CUSTOMER_LIST_ACCT_CODE,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
	

	}
	
	@Override
	public List<CommonUtilityBean> getSubAccountCodeListTradeDebtorsCR() {
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			if(userDetails.isAgent()){
				lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.GET_PAYER_BASED_ON_AGENT,new Object[]{userId},
						new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			}else{
				if (!"E285".equals(userId)) {
					lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.GET_SUBACCOUNT_TRADE_DEBTORS_PAYER_ONLY,
							new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
				} else {
					lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.GET_SUBACCOUNT_TRADE_DEBTORS_CUSTOMER_ONLY,
							new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
				}
			}
			

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public CommonUtilityBean getVesselService(String sVoyageCode) {

		CommonUtilityBean objCommonUtilityBean = new CommonUtilityBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			objCommonUtilityBean = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.GET_VESSEL_SERVICE, new Object[] { sVoyageCode },
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return objCommonUtilityBean;
	}

	@Override
	public CommonUtilityBean getTruckService(String sVoyageCode) {
		CommonUtilityBean objCommonUtilityBean = new CommonUtilityBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			objCommonUtilityBean = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.GET_TRUCK_SERVICE, new Object[] { Integer.parseInt(sVoyageCode) },
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return objCommonUtilityBean;
	}




	@Override
	public List<CommonUtilityBean> getassetList() {
		List<CommonUtilityBean> lAssetList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lAssetList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_ASSET_LIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lAssetList;
	}

	@Override
	public List<CommonUtilityBean> getJvPartnerAccount() {
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.GET_JV_PARTNER_LIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
	}

 

	@Override
	public CommonUtilityBean getExchangeRateWithCurrency(String currencyCode) {
		CommonUtilityBean objBean = new CommonUtilityBean();
		double dExchangeRate = 1.0;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			
	Integer i = jdbcTemplate.queryForObject("select count(*) from currency where crrncy_cd='"+currencyCode+"' ", new Object[]{},(Integer.class));
if(i>0) {
	objBean = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.GET_EXCHANGE_RATE_WITH_CURR, new Object[]{currencyCode}, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		
			}
			objBean.setSuccess(true);
		} catch (DataAccessException e) {
			objBean.setSuccess(false);
			LOGGER.error("Error in Get currencyCode List", e);
		}
		return objBean;
	}

	
	@Override
	public CommonUtilityBean getExchangeRateWithCurrencyBySailingDate(String currencyCode, String sailingDate) {
		CommonUtilityBean objBean = new CommonUtilityBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			objBean = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.GET_EXCHANGE_RATE_BY_SAILING_DATE, new Object[]{currencyCode,sailingDate}, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			objBean.setSuccess(true);
		} catch (DataAccessException e) {
			objBean.setSuccess(false);
			LOGGER.error("Error in Get currencyCode List", e);
		}
		return objBean;
	}
	
	@Override
	public CommonUtilityBean getExchangeRateWithCurrencyByMaxDate(String currencyCode) {
		CommonUtilityBean objBean = new CommonUtilityBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			objBean = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.GET_EXCHANGE_RATE_BY_MAX_DATE, new Object[]{currencyCode,currencyCode}, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			objBean.setSuccess(true);
		} catch (DataAccessException e) {
			objBean.setSuccess(false);
			LOGGER.error("Error in Get currencyCode List", e);
		}
		return objBean;
	}

	
	@Override
	public List<CommonUtilityBean> getSectorBasedVessel(String sectorCode) {
		List<CommonUtilityBean> vesselList=new ArrayList<CommonUtilityBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		vesselList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_SERVICE_ON_VESSEL,new Object[]{sectorCode},new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		return vesselList;
	}

	@Override
	public CommonUtilityBean getSupplierCurrency(String supplierCode) {
		CommonUtilityBean objBean = new CommonUtilityBean();
		
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			objBean = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.GET_SUPPLIER_CURRENCY, new Object[]{supplierCode}, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			objBean.setSuccess(true);
		} catch (DataAccessException e) {
			objBean.setSuccess(false);
			LOGGER.error("Error in Get currencyCode List", e);
		}
		return objBean;
	}


	@Override
	public List<CommonUtilityBean> getSupplierListWthAcctCode() {
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.GET_SUPPLIER_LIST_WITH_ACCOUNTCODE,
			new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		return lCommonUtilityBean;
	}
	
	/*@Override
	public List<LoadingSummaryBean> getCustDropDownList() {
		List<LoadingSummaryBean> alResultVoyageList = new ArrayList<LoadingSummaryBean>();
		LoadingSummaryBean objbean = null;
		try {

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.getCustomer);
			for (Map<String, Object> row : rows) {
				objbean = new LoadingSummaryBean();
				objbean.setId(String.valueOf(row.get("id")));
				objbean.setText(String.valueOf(row.get("text")));
				alResultVoyageList.add(objbean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getSlotList", e);
		}

		return alResultVoyageList;
	}*/


	@Override
	public String getserviceBasedLocation(String voyageId) {
		String serviceLocation="";
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			serviceLocation = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.GET_SERVICE_LOCATION_NAME,new Object[] { voyageId },String.class);
		}catch(DataAccessException empty){
			serviceLocation = "";
		}
		return serviceLocation;
	}
	@Override
	public List<CommonUtilityBean> getSectorWiseCompany() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean>	lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.GET_COMPANY_WISE_SECTOR,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getVessel() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean>	vesselList = jdbcTemplate.query(CommonUtilityQueryUtil.vessel_list,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		return vesselList;
	}

	@Override
	public List<CommonUtilityBean> getStaffList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean>	staffList = jdbcTemplate.query(CommonUtilityQueryUtil.staff_list,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		return staffList;
	}
	
	@Override
	public List<CommonUtilityBean> getTripsList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean>	staffList = jdbcTemplate.query(CommonUtilityQueryUtil.TRIP_LIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		return staffList;
	}


	@Override
	public List<CommonUtilityBean> getChargeList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.CHARGE_LIST,new Object[]{},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}
	@Override
	public List<CommonUtilityBean> getCurrencyList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.GET_CURRENCY,new Object[]{},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}


	 
  	
 	
 	
	private boolean insertAssetTrackintoTransfer(ArrayList<CommonUtillityAssetTrackDetailBean> assetTrackDetails, int stockTransDtlid) {
		boolean isSuccess = false;
		int value = 0;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			for (int i = 0; i < assetTrackDetails.size(); i++) {
				value = jdbcTemplate.update(CommonUtilityQueryUtil.INSERT_STOCK_DETAIL_ASSET, new Object[] { stockTransDtlid, Integer.parseInt(assetTrackDetails.get(i).getAsstDetailId()) });
				if (value > 0) {
					isSuccess = true;
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Insert the Stock Asset Detail Records!", e);
		}
		return isSuccess;
	}

	 
	
	/**
	 * Generate Stock Number with Stock Type
	 *
	 * Eg: Stock Type::: 86- Stock In, 87- Stock Out
	 */
	@Override
	public String generateStockNumber(Integer stockType) {

		String stockNo = "";
		String sStockPrefix = "", sStockPrefixWithLike = "", sDefaultStockNo = "";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			if (stockType == 86) { // StockIn

				sStockPrefix = "SKI";
				sStockPrefixWithLike = "SKI%";
				sDefaultStockNo = "SKI" + "0001";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.STOCK_NUMBER_AUTO_GEN, new Object[] { sDefaultStockNo, sStockPrefix, sStockPrefixWithLike });
				for (Map row : rows) {
					stockNo = (String) row.get("stock_number");
				}
			} else if (stockType == 87) { // StockOut

				sStockPrefix = "SKO";
				sStockPrefixWithLike = "SKO%";
				sDefaultStockNo = "SKO" + "0001";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.STOCK_NUMBER_AUTO_GEN, new Object[] { sDefaultStockNo, sStockPrefix, sStockPrefixWithLike });
				for (Map row : rows) {
					stockNo = (String) row.get("stock_number");
				}
			} else if (stockType == 121) { // ConsignmentIn

				sStockPrefix = "CNI";
				sStockPrefixWithLike = "CNI%";
				sDefaultStockNo = "CNI" + "0001";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.STOCK_NUMBER_AUTO_GEN, new Object[] { sDefaultStockNo, sStockPrefix, sStockPrefixWithLike });
				for (Map row : rows) {
					stockNo = (String) row.get("stock_number");
				}
			} else if (stockType == 122) { // ConsignmentOut

				sStockPrefix = "CNO";
				sStockPrefixWithLike = "CNO%";
				sDefaultStockNo = "CNO" + "0001";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.STOCK_NUMBER_AUTO_GEN, new Object[] { sDefaultStockNo, sStockPrefix, sStockPrefixWithLike });
				for (Map row : rows) {
					stockNo = (String) row.get("stock_number");
				}
			} else if (stockType == 172) { // Stock Adjustment
				sStockPrefix = "SAN";
				sStockPrefixWithLike = "SAN%";
				sDefaultStockNo = "SAN" + "0001";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.STOCK_NUMBER_AUTO_GEN, new Object[] { sDefaultStockNo, sStockPrefix, sStockPrefixWithLike });
				for (Map row : rows) {
					stockNo = (String) row.get("stock_number");
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Generate Stock Number", e);
		}
		return stockNo;
	}

	@Override
	public CommonUtilityResultBean getStockAvailablity(int locationId, int itemId) {
		List<CommonUtilityBean> lStockAvailList = new ArrayList<CommonUtilityBean>();
		CommonUtilityResultBean resultBean = new CommonUtilityResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {

			lStockAvailList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_ITEM_LOC_AVAILABILITY, new Object[] { locationId, itemId }, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			for (CommonUtilityBean bean : lStockAvailList) {
				if (bean.getStockQty() > 0)
					lStockAvailList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_STOCK_AVAILABILITY, new Object[] { locationId, itemId }, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			}

			resultBean.setCommonUtilityBean(lStockAvailList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Item List", e);
		}
		return resultBean;
	}
	
	
	@Override
	public List<CommonUtilityBean> getEntityData() throws Exception {
		 List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		CommonUtilityBean bean = null;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.GET_ENTITY_LIST, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Customer Data", e);
		}
		return lCommonUtilityBean;
	}




	 
	
  
 	
	public static int insertAddress(final int cityId, final String locationAddress, final String userId, JdbcTemplate jdbcTemplate) {
		Integer	city =0;
		Object[] params = new Object[] { city, locationAddress, userId };
		int iAddressId = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.INSERT_ADDRESS, params, Integer.class);

		return iAddressId;
	}
	
	public static boolean updateAddress(final int cityId, final String locationAddress, final String userId, int addressId, JdbcTemplate jdbcTemplate) {
		boolean isFlag = false;
		int iAddressUpd = jdbcTemplate.update(CommonUtilityQueryUtil.UPDATE_ADDRESS, new Object[] { cityId, locationAddress, userId, addressId });
		if (iAddressUpd > 0)
			isFlag = true;

		return isFlag;
	}
	
  
	 
	@Override
	public List<SelectivityBean> getMode() {
		List<SelectivityBean> lModeList = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lModeList = jdbcTemplate.query(CommonUtilityQueryUtil.MODE,new Object[]{},
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lModeList;
	}

	@Override
	public List<SelectivityBean> getJobOrderNo() {
		List<SelectivityBean> lJobOrderNoList = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lJobOrderNoList = jdbcTemplate.query(CommonUtilityQueryUtil.JOBORDERNO,new Object[]{},
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lJobOrderNoList;
	}
	
 

	@Override
	public List<CommonUtilityBean> getSubAccountCodeListTradeDebtorsIA() {
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			if(userDetails.isAgent()){
				lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.GET_PAYER_BASED_ON_AGENT,new Object[]{userId},
						new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			}else{
				if (!"E285".equals(userId)) {
					lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.GET_SUBACCOUNT_TRADE_DEBTORS_PAYERs_ONLY,
							new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
				} else {
					lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.GET_SUBACCOUNT_TRADE_DEBTORS_CUSTOMER_ONLY,
							new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
				}
			}
			

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
	}

	/*@Override
	public String getCompanyCurrency(String sCompanyCode) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	
	@Override
	public String getCompanyCurrency(String sCompanyCode) {
		String sCompanyCurrency = "";
		try {
			sCompanyCurrency = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.GET_COMPANY_CURRENCY, new Object[] { sCompanyCode }, String.class);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Port LIST", e);
		}

		return sCompanyCurrency;
	}

	@Override
	public boolean saveCommonUtilityStockData(CommonUtilityStockBean objCommonUtilityStockBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCommonUtilityStockData(CommonUtilityStockBean objCommonUtilityStockBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStockData(Integer stockInId, Integer stockType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BatchAttributeBean> getConsignmentBatchList(BatchAttributeBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateInventoryAndLedgerIn(String stockId, String date, int i, int sourceLoc, int destLoc,
			int parseInt, int quantity, String inTransistLocation, List<BatchAttributeBean> grnbatchBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateInventoryAndLedgerOut(String stockId, String date, int i, int sourceLoc, int destLoc,
			int parseInt, int quantity, String inTransistLocation, List<BatchAttributeBean> grnbatchBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateInventoryAndLedgerInCheckQc(String stockId, String date, int i, int sourceLoc, int destLoc,
			int parseInt, int quantity, String inTransistLocation, int qcStatus,
			List<BatchAttributeBean> attributeBeans) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateInventoryAndLedgerOutCheckQc(String stockId, String date, int i, int sourceLoc, int destLoc,
			int parseInt, int quantity, String inTransistLocation, int qcStatus,
			List<BatchAttributeBean> attributeBeans) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CommonUtilityBean> getVoyageList(String vesselCode) {
		List<CommonUtilityBean> alResultVoyageList = new ArrayList<>();
		CommonUtilityBean objbean = null;
		try {

			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			
			String Query = "";
			if(userDetails.getCompanyCode().equalsIgnoreCase("C0001")){
				Query = CommonUtilityQueryUtil.sGetCargoArrivalVoyageList;
			}/*else if(userDetails.getCompanyCode().equalsIgnoreCase("C0028")){
				Query = CommonUtilityQueryUtil.sGetCargoArrivalVoyageListSin;
			}else if(userDetails.getCompanyCode().equalsIgnoreCase("C0029")){
				Query = CommonUtilityQueryUtil.sGetCargoArrivalVoyageListMY;
			}*/
			
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(Query, new Object[] { vesselCode });
			
			for (Map<String, Object> row : rows) {
				objbean = new CommonUtilityBean();
				objbean.setId(String.valueOf(row.get("id")));
				objbean.setText(String.valueOf(row.get("text")));
				//objbean.setSectorName(String.valueOf(row.get("sectorName")));
				objbean.setSectorId(String.valueOf(row.get("sectorId")));
				 
				alResultVoyageList.add(objbean);

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getVoyageList", e);
		}
		return alResultVoyageList;
	}

	@Override
	public List<CommonUtilityBean> getPayerList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean>	staffList = jdbcTemplate.query(CommonUtilityQueryUtil.payer_list,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		return staffList;
	}	

	@Override
	public List<CommonUtilityBean> getCommodityList() {
		List<CommonUtilityBean>	commodityList = new ArrayList<CommonUtilityBean>();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			commodityList = jdbcTemplate.query(CommonUtilityQueryUtil.commodity_list,
						new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return commodityList;
	}

	@Override
	public List<SelectivityBean> getPortByEmpAgn() {

		List<SelectivityBean> portList = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if(userDetails.getIsVendor() != null) {
				if(userDetails.getIsVendor().equalsIgnoreCase("Y")){
					portList = jdbcTemplate.query(CommonUtilityQueryUtil.get_Port_By_Agent(userDetails.getUserPortStr()),
							new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
				}
				else{
				portList = jdbcTemplate.query(CommonUtilityQueryUtil.get_Port_By_Emp,
						new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
				
				}
			}
			else {
				portList = jdbcTemplate.query(CommonUtilityQueryUtil.get_Port_By_Emp,
						new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			}
			
			
			
 		} catch (DataAccessException e) {
			LOGGER.error("Error in Get customerList", e);
		}
		return portList;
	
	}	

	

@Override
	public List<CommonUtilityBean> getAccountListDrpDwn() throws CustomException {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		

			try {
				List<CommonUtilityBean> acctDrpDwn = jdbcTemplate.query(CommonUtilityQueryUtil.Accounthead,
						new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
				return acctDrpDwn;
			} catch (DataAccessException e) {
				LOGGER.error("Error in Get charge List", e);
				throw new CustomException("Error in Get Charge List");
			}
	}

	@Override
	public List<SelectivityBean> getSurChargeList(String relateType) {
		List<SelectivityBean>	 List = new ArrayList<SelectivityBean>();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List = jdbcTemplate.query(CommonUtilityQueryUtil.surChargeList, new Object[] { relateType },
						new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
		}catch(Exception e){
			e.printStackTrace();
		}
		return List;
	}
	
	@Override
	public List<AttributeBean> getAttributesList(String sAccountCode) {
		List<AttributeBean> lAttributeList = new ArrayList<>();
		try {
			lAttributeList = jdbcTemplate.query(CommonUtilityQueryUtil.sGetAttributeList, new Object[] { sAccountCode },
					new BeanPropertyRowMapper<>(AttributeBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GetlAttributeList", e);
		}
		return lAttributeList;
	}
	
	@Override
	public List<CommonUtilityBean> getAccountHeadDataCN() {
		List lCommonUtilityBean = new ArrayList();
		CommonUtilityBean bean = null;
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.sGetAccountHeadListCN);

			for (Map row : rows) {
				bean = new CommonUtilityBean();
				bean.setText((String) row.get("ACCT_HEAD_NAME"));
				bean.setId((String) row.get("ACCT_HEAD_CODE"));
				bean.setAccountHeadName((String) row.get("ACCT_HEAD_NAME"));
				bean.setAccountHeadCode((String) row.get("ACCT_HEAD_CODE"));
				bean.setCurrencyCode((String) row.get("ACCT_CURRENCY"));
				double exgRate = (Double) row.get("EXCHANGE_RATE");
				bean.setExchangeRate(exgRate);

				lCommonUtilityBean.add(bean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getCustomerListFilter(CommonUtilityBean objCommonUtilityBean) {
		List<CommonUtilityBean> lAttributeList = new ArrayList<>();
		try {
			lAttributeList = jdbcTemplate.query(CommonUtilityQueryUtil.getCustomerListFilter(objCommonUtilityBean), 
					new BeanPropertyRowMapper<>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in objCommonUtilityBean", e);
		}
		return lAttributeList;
	}

	@Override
	public List<SelectivityBean> getPortwithSequence(String voyage) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<SelectivityBean> portlist = new ArrayList<SelectivityBean>();
		try {
		
			portlist = jdbcTemplate.query(CommonUtilityQueryUtil.GET_PORTWITHSEQBYVOYAGE,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),voyage);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Getting Port Sequence", e);
		}
		return portlist;
	}

	@Override
	public List<SelectivityBean> getSpecialList() {
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		
			 
			list = jdbcTemplate.query(CommonUtilityQueryUtil.gat_Quotation_specialList,
						new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			
			
			
			
 		} catch (DataAccessException e) {
			LOGGER.error("Error in Get specialList", e);
		}
		return list;
	}

	@Override
	public List<CommonUtilityBean> getsupplierList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<CommonUtilityBean> getSubAccountCodeDatanew() {
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();

		CommonUtilityBean bean = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.sGetSubAccountList_GL_NEW,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAccountHeadData", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getCountryListPortmaster() {
		List<CommonUtilityBean> lCountryList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			lCountryList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_COUNTRY_LIST_PORT_MASTER,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getCountryList", e);
		}
		return lCountryList;
	}
	

	@Override
	public List<SelectivityBean> getOriginDestination() {
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					 
			list = jdbcTemplate.query(CommonUtilityQueryUtil.PORT_LIST,	new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			
			
			
			
 		} catch (DataAccessException e) {
			LOGGER.error("Error in Get specialList", e);
		}
		return list;
	}
	
	
	
	@Override
	public List<CommonUtilityBean> getBankList() {
		List<CommonUtilityBean> lCountryList = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			lCountryList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_BANKACCT_LIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getCountryList", e);
		}
		return lCountryList;
	}


	@Override
	public List<SelectivityBean> getcargotype() {
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		
			 
			list = jdbcTemplate.query(CommonUtilityQueryUtil.gat_cargotype,	new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			
			
			
			
 		} catch (DataAccessException e) {
			LOGGER.error("Error in Get specialList", e);
		}
		return list;
	}

	@Override
	public List<CommonUtilityBean> getServiceOperator() {
		List<CommonUtilityBean> sectorlist = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			sectorlist = jdbcTemplate.query(CommonUtilityQueryUtil.GET_SERVICE_OPERATORLIST,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			return sectorlist;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Voyage List", e);
		}
		return sectorlist;
	}
	
	
	@Override
	public List<CommonUtilityBean> getService() {
		List<CommonUtilityBean> sectorlist = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			sectorlist = jdbcTemplate.query(CommonUtilityQueryUtil.GET_SERVICE_LIST1,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			return sectorlist;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Voyage List", e);
		}
		return sectorlist;
	}
	@Override
	public List<CommonUtilityBean> getcarrierList() {
		List<CommonUtilityBean> sectorlist = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			sectorlist = jdbcTemplate.query(CommonUtilityQueryUtil.carrierList,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Voyage List", e);
		}
		return sectorlist;
	}
	@Override
	public List<CommonUtilityBean> gettransportList() {
		List<CommonUtilityBean> sectorlist = new ArrayList<CommonUtilityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			sectorlist = jdbcTemplate.query(CommonUtilityQueryUtil.transList,
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Voyage List", e);
		}
		return sectorlist;
	}

	@Override
	public List<SelectivityBean> getDepotListByPort(String portCode) {
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
			if(userDetails.getIsVendor().equalsIgnoreCase("Y")) {
				list = jdbcTemplate.query(CommonUtilityQueryUtil.get_Depot_By_Agent(userDetails.getUserPortStr()),	new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),portCode);

			}else {
				list = jdbcTemplate.query(CommonUtilityQueryUtil.Depot_list_by_port,	new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class), portCode);

			}
			
			
			
			
 		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Depot List", e);
		}
		return list;
	}

		@Override
		public List<CommonUtilityBean> getcustomerlocal() {
			List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();

			CommonUtilityBean bean = null;
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			try {
				lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.get_customer_local,
						new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

			} catch (DataAccessException e) {
				LOGGER.error("Error in getAccountHeadData", e);
			}
			return lCommonUtilityBean;
		}

		@Override
		public List<CommonUtilityBean> getsupplierlocal() {
			List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();

			CommonUtilityBean bean = null;
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			try {
				lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.get_Supplier_local,
						new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

			} catch (DataAccessException e) {
				LOGGER.error("Error in getAccountHeadData", e);
			}
			return lCommonUtilityBean;
		}
		@Override
		public List<CommonUtilityBean> getsupplieroverseas() {
			List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();

			CommonUtilityBean bean = null;
			try {
				String acct = "20010003";
				//String supplier = "select acct_head_code as id,srvc_prtnr_nam as text from service_partner where sundry_type= '20010003'";
				//System.out.println("sdgdhd"+supplier);
			/*	lCommonUtilityBean = jdbcTemplate.query(supplier,
						new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));*/
				String query = "select acct_head_code as id,srvc_prtnr_nam as text from service_partner where sundry_type ='20010003'";
				lCommonUtilityBean = jdbcTemplate.query(query,new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));



			} catch (DataAccessException e) {
				LOGGER.error("Error in getAccountHeadData", e);
			}
			return lCommonUtilityBean;
		}

		@Override
		public List<CommonUtilityBean> getcustomeroverseas() {
			List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();

			CommonUtilityBean bean = null;
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			try {
				lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.get_customer_overseas,
						new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

			} catch (DataAccessException e) {
				LOGGER.error("Error in getAccountHeadData", e);
			}
			return lCommonUtilityBean;
		}

		@Override
		public List<SelectivityBean> getCompanyListPurchase() {

			List<SelectivityBean> lCompanyList = new ArrayList<>();
			try {
				lCompanyList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_COMPANY_LIST_PURCHASE, new Object[] {}, new BeanPropertyRowMapper<>(SelectivityBean.class));
				
			} catch (DataAccessException e) {
				LOGGER.error("Error in Get Organization List", e);
			}
			return lCompanyList;
		}

		@Override
		public List<SelectivityBean> getCompanyListcompany() {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			List<SelectivityBean> lCompanyList = new ArrayList<>();
			try {
				lCompanyList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_COMPANY_LIST_COMPANY, new Object[] {}, new BeanPropertyRowMapper<>(SelectivityBean.class));
				System.out.println("value" + lCompanyList);
			} catch (DataAccessException e) {
				LOGGER.error("Error in Get SUB Group List", e);
			}
			return lCompanyList;
		}
		@Override
		public CommonUtilityResultBean getCompanyListWithUser(String userId, String companyCode) {
			List<CommonUtilityBean> lCBRcptHdrList = new ArrayList<>();
			CommonUtilityResultBean resultBean = new CommonUtilityResultBean();
			try {

				lCBRcptHdrList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_COMPANY_LIST_WITH_USER, new Object[] { companyCode }, new BeanPropertyRowMapper<>(CommonUtilityBean.class));
				resultBean.setCommonUtilityBean(lCBRcptHdrList);
			} catch (DataAccessException e) {
				LOGGER.error("Error in Reconcile List", e);
			}
			return resultBean;
		}

		@Override
		public List<CommonUtilityBean> getSubAccountCodeList1() {
			List lCommonUtilityBean = new ArrayList();
			CommonUtilityBean bean = null;
			try {

				lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.sGetSubAccountLists1, new BeanPropertyRowMapper<>(CommonUtilityBean.class));

			} catch (DataAccessException e) {
				LOGGER.error("Error in getAccountHeadData", e);
			}
			return lCommonUtilityBean;
		}

		@Override
		public List<CommonUtilityBean> getSubAccountCodeList() {
			List lCommonUtilityBean = new ArrayList();
			CommonUtilityBean bean = null;
			try {

				lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.sGetSubAccountLists, new BeanPropertyRowMapper<>(CommonUtilityBean.class));
System.out.println("test");
			} catch (DataAccessException e) {
				LOGGER.error("Error in getAccountHeadData", e);
			}
			return lCommonUtilityBean;
		}

		@Override
		public List<SelectivityBean> getSubGroupAcctList() {
			List<SelectivityBean> lSubGroupList = new ArrayList<>();
			try {
				lSubGroupList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_SUB_GROUP_ACCT_LIST, new BeanPropertyRowMapper<>(SelectivityBean.class));

			} catch (DataAccessException e) {
				LOGGER.error("Error in Get SUB Group List", e);
			}
			return lSubGroupList;
		}

		@Override
		public List<CommonUtilityBean> getCrDtlAccountHeadDataNew() {
			List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<>();
			CommonUtilityBean bean = null;
			try {
				lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.sGetAccountHeadListnew, new BeanPropertyRowMapper<>(CommonUtilityBean.class));

			} catch (DataAccessException e) {
				LOGGER.error("Error in getAccountHeadData", e);
			}
			return lCommonUtilityBean;
		}

		@Override
		public CommonUtilityResultBean BudgetDefListCC(String costCenter) {
			// TODO Auto-generated method stub

			List<SelectivityBean> lClassBasedOnSpecificRigths = new ArrayList<>();
			CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();
			try {

				lClassBasedOnSpecificRigths = jdbcTemplate.query(CommonUtilityQueryUtil.budget_DefineList_cc, new Object[] { costCenter }, new BeanPropertyRowMapper<>(SelectivityBean.class));
				commonUtilityResultBean.setlClassBasedOnSpecificRigths(lClassBasedOnSpecificRigths);
				commonUtilityResultBean.setSuccess(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return commonUtilityResultBean;
		}
		
		@Override
		public List<CommonUtilityBean> getSubAccountCodeDataNew(String type) {
			List lCommonUtilityBean = new ArrayList();
			CommonUtilityBean bean = null;
			try {

				if (type.equalsIgnoreCase("payment"))
					lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.sGetSubAccountListVendor, new BeanPropertyRowMapper<>(CommonUtilityBean.class));
				else if (type.equalsIgnoreCase("receipt"))
					lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.sGetSubAccountListCustomer, new BeanPropertyRowMapper<>(CommonUtilityBean.class));
				else if (type.equalsIgnoreCase("employee"))
					lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.sGetSubAccountListEmployee, new BeanPropertyRowMapper<>(CommonUtilityBean.class));

			} catch (DataAccessException e) {
				LOGGER.error("Error in getAccountHeadData", e);
			}
			return lCommonUtilityBean;
		}
		@Override
		public boolean updateInventoryAndLedgerIn(String formCode, String formDate, int type, int srcLocId, int destLocId, int itemId, double qnty, String transLocation, List<BatchAttributeBean> batchAttributeBeans) {
			// TODO Auto-generated method stub
			try {
				double qty = 0;
				String transLoc = "%" + transLocation + "%";
				boolean isQc = false;

				if (type == 123 || type == 106 || type == 107 || type == 147) {
					destLocId = getTransitLocation(transLoc, jdbcTemplate);
				} else if (type == 142 || type == 161) {

					srcLocId = getTransitLocation(transLoc, jdbcTemplate);

				} else if (type == 88) {
					isQc = jdbcTemplate.queryForObject(GRNQueryUtil.CHECK_QC_FOR_ITEM, new Object[] { itemId }, Boolean.class);
					if (isQc)
						destLocId = jdbcTemplate.queryForObject(GRNQueryUtil.GET_QC_LOCATION, new Object[] { formCode }, Integer.class);
				} else if (type == 149) {
					isQc = jdbcTemplate.queryForObject(GRNQueryUtil.CHECK_QC_FOR_ITEM, new Object[] { itemId }, Boolean.class);
					if (isQc)
						srcLocId = jdbcTemplate.queryForObject(GRNQueryUtil.GET_QC_LOCATION, new Object[] { formCode }, Integer.class);
				}

				int inventryExst = jdbcTemplate.queryForObject(StockTransferQueryUtil.INVENTORY_EXISTS, new Object[] { destLocId, itemId }, Integer.class);

				if (inventryExst > 0) {
					double InventryQTY = jdbcTemplate.queryForObject(StockTransferQueryUtil.INVENTORY_HAND_QUANTITY, new Object[] { destLocId, itemId }, Double.class);

					qty = InventryQTY + qnty;

					jdbcTemplate.update(GRNQueryUtil.UPDATE_INVENTORY, new Object[] { formDate, qty, itemId, destLocId });
				} else {

					qty = qnty;
					jdbcTemplate.update(GRNQueryUtil.SAVE_INVENTORY, new Object[] { formDate, destLocId, itemId, qty });
				}

				int inventoryId = jdbcTemplate.queryForObject(StockTransferQueryUtil.MAX_INVENTORY, new Object[] { destLocId, itemId }, Integer.class);

				Object[] params = new Object[] { inventoryId, null, destLocId, 0, qnty, formDate, type, formCode };

				int stockId = jdbcTemplate.queryForObject(GRNQueryUtil.SAVE_STOCK_LEDGER_NEW, params, Integer.class);

				if (batchAttributeBeans != null) {

					if (batchAttributeBeans.size() > 0) {

						for (BatchAttributeBean batchAttributeBean : batchAttributeBeans) {
							DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							String expDate = null;
							Date exdate = null;
							if (batchAttributeBean.getExpiryDate() != null && !batchAttributeBean.getExpiryDate().isEmpty() && batchAttributeBean.getExpiryDate() != "") {
								exdate = df.parse(batchAttributeBean.getExpiryDate());

							}

							jdbcTemplate.update(GRNQueryUtil.SAVE_STOCK_LEDGER_BATCH, new Object[] { stockId, batchAttributeBean.getItemId(), batchAttributeBean.getBatchNo(), batchAttributeBean.getBatchQty(), exdate, batchAttributeBean.getManufacturer(), batchAttributeBean.getMrpPrice(), null, destLocId, batchAttributeBean.getOriginalConvertedQty(), 0 });

						}

					}
				}

			} catch (DataAccessException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}

		@Override
		public boolean updateInventoryAndLedgerOut(String formCode, String formDate, int type, int srcLocId, int destLocId, int itemId, double qnty, String transLocation, List<BatchAttributeBean> batchAttributeBeans) {

			try {
				double qty = 0;
				int batchLocation = 0;
				String transLoc = "%" + transLocation + "%";

				boolean isQc = false;

				if (type == 123 || type == 107 || type == 147) {
					srcLocId = getTransitLocation(transLoc, jdbcTemplate);

				} else if (type == 142 || type == 161) {
					destLocId = getTransitLocation(transLoc, jdbcTemplate);

				} else if (type == 88) {
					isQc = jdbcTemplate.queryForObject(GRNQueryUtil.CHECK_QC_FOR_ITEM, new Object[] { itemId }, Boolean.class);
					if (isQc)
						srcLocId = jdbcTemplate.queryForObject(GRNQueryUtil.GET_QC_LOCATION, new Object[] { formCode }, Integer.class);
				} else if (type == 149) {
					isQc = jdbcTemplate.queryForObject(GRNQueryUtil.CHECK_QC_FOR_ITEM, new Object[] { itemId }, Boolean.class);
					if (isQc)
						destLocId = jdbcTemplate.queryForObject(GRNQueryUtil.GET_QC_LOCATION, new Object[] { formCode }, Integer.class);
				} else if (type == 106) {

					String consLoc = "%" + consumedLocation + "%";

					int consumeLocation = jdbcTemplate.queryForObject(GRNQueryUtil.GET_TRANSIT_LOCATION, new Object[] { consLoc }, Integer.class);

					batchLocation = destLocId;

					destLocId = consumeLocation;

				}

				int inventryExst = jdbcTemplate.queryForObject(StockTransferQueryUtil.INVENTORY_EXISTS, new Object[] { destLocId, itemId }, Integer.class);

				if (inventryExst > 0) {
					double InventryQTY = jdbcTemplate.queryForObject(StockTransferQueryUtil.INVENTORY_HAND_QUANTITY, new Object[] { destLocId, itemId }, Double.class);
					qty = InventryQTY - qnty;

					jdbcTemplate.update(GRNQueryUtil.UPDATE_INVENTORY, new Object[] { formDate, qty, itemId, destLocId });
				} else {
					qty = -qnty;

					jdbcTemplate.update(GRNQueryUtil.SAVE_INVENTORY, new Object[] { formDate, destLocId, itemId, qty });
				}

				int inventoryId = jdbcTemplate.queryForObject(StockTransferQueryUtil.MAX_INVENTORY, new Object[] { destLocId, itemId }, Integer.class);

				int stockId = 0;
				if (type == 106) {
					Object[] params = new Object[] { inventoryId, batchLocation, null, qnty, 0, formDate, type, formCode };
					stockId = jdbcTemplate.queryForObject(GRNQueryUtil.SAVE_STOCK_LEDGER_NEW, params, Integer.class);
				} else {
					Object[] params = new Object[] { inventoryId, destLocId, null, qnty, 0, formDate, type, formCode };
					stockId = jdbcTemplate.queryForObject(GRNQueryUtil.SAVE_STOCK_LEDGER_NEW, params, Integer.class);
				}

				if (batchAttributeBeans != null) {
					if (batchAttributeBeans.size() > 0) {

						for (BatchAttributeBean batchAttributeBean : batchAttributeBeans) {
							DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

							Date exdate = null;
							if (batchAttributeBean.getExpiryDate() != null && !batchAttributeBean.getExpiryDate().isEmpty() && batchAttributeBean.getExpiryDate() != "") {
								exdate = df.parse(batchAttributeBean.getExpiryDate());

							}
							if (type == 106) {
								jdbcTemplate.update(GRNQueryUtil.SAVE_STOCK_LEDGER_BATCH, new Object[] { stockId, batchAttributeBean.getItemId(), batchAttributeBean.getBatchNo(), batchAttributeBean.getBatchQty(), exdate, batchAttributeBean.getManufacturer(), batchAttributeBean.getMrpPrice(), batchLocation, null, 0, batchAttributeBean.getOriginalConvertedQty() });
							} else {
								jdbcTemplate.update(GRNQueryUtil.SAVE_STOCK_LEDGER_BATCH, new Object[] { stockId, batchAttributeBean.getItemId(), batchAttributeBean.getBatchNo(), batchAttributeBean.getBatchQty(), exdate, batchAttributeBean.getManufacturer(), batchAttributeBean.getMrpPrice(), destLocId, null, 0, batchAttributeBean.getOriginalConvertedQty() });
							}

						}

					}

				}

			} catch (DataAccessException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}

		public int getTransitLocation(String location, JdbcTemplate jdbcTemplate2) {
			int locationId = 0;
			try {
				System.out.println(location);
				locationId = jdbcTemplate2.queryForObject(GRNQueryUtil.GET_TRANSIT_LOCATION, new Object[] { location }, Integer.class);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return locationId;
		}

		@Override
		public boolean updateInventoryAndLedgerInCheckQc(String formCode, String formDate, int type, int srcLocId, int destLocId, int itemId, double qnty, String transLocation, int qcStatus, List<BatchAttributeBean> attributeBeans) {

			try {
				double qty = 0;
				String transLoc = "%" + transLocation + "%";
				boolean isQc = false;

				if (type == 123 || type == 106 || type == 107 || type == 147) {
					destLocId = getTransitLocation(transLoc, jdbcTemplate);
				} else if (type == 142 || type == 161) {

					srcLocId = getTransitLocation(transLoc, jdbcTemplate);

				} else if (type == 88) {
					isQc = jdbcTemplate.queryForObject(GRNQueryUtil.CHECK_QC_FOR_ITEM, new Object[] { itemId }, Boolean.class);
					if (isQc)
						destLocId = jdbcTemplate.queryForObject(GRNQueryUtil.GET_QC_LOCATION, new Object[] { formCode }, Integer.class);
				} else if (type == 149) {
					isQc = jdbcTemplate.queryForObject(GRNQueryUtil.CHECK_QC_FOR_ITEM, new Object[] { itemId }, Boolean.class);
					if (isQc)
						srcLocId = jdbcTemplate.queryForObject(GRNQueryUtil.GET_QC_LOCATION, new Object[] { formCode }, Integer.class);
					if (qcStatus == 148) {
						destLocId = getTransitLocation(transLoc, jdbcTemplate);
					}
				}

				int inventryExst = jdbcTemplate.queryForObject(StockTransferQueryUtil.INVENTORY_EXISTS, new Object[] { destLocId, itemId }, Integer.class);

				if (inventryExst > 0) {
					double InventryQTY = jdbcTemplate.queryForObject(StockTransferQueryUtil.INVENTORY_HAND_QUANTITY, new Object[] { destLocId, itemId }, Double.class);

					qty = InventryQTY + qnty;

					jdbcTemplate.update(GRNQueryUtil.UPDATE_INVENTORY, new Object[] { formDate, qty, itemId, destLocId });

				} else {
					qty = qnty;

					jdbcTemplate.update(GRNQueryUtil.SAVE_INVENTORY, new Object[] { formDate, destLocId, itemId, qty });

				}

				int inventoryId = jdbcTemplate.queryForObject(StockTransferQueryUtil.MAX_INVENTORY, new Object[] { destLocId, itemId }, Integer.class);

				Object[] params = new Object[] { inventoryId, null, destLocId, 0, qnty, formDate, type, formCode };
				int stockId = jdbcTemplate.queryForObject(GRNQueryUtil.SAVE_STOCK_LEDGER_NEW, params, Integer.class);

				if (attributeBeans != null) {

					if (attributeBeans.size() > 0) {

						for (BatchAttributeBean batchAttributeBean : attributeBeans) {
							DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							String expDate = null;
							Date exdate = null;
							if (batchAttributeBean.getExpiryDate() != null && !batchAttributeBean.getExpiryDate().isEmpty() && batchAttributeBean.getExpiryDate() != "") {
								exdate = df.parse(batchAttributeBean.getExpiryDate());

							}

							jdbcTemplate.update(GRNQueryUtil.SAVE_STOCK_LEDGER_BATCH, new Object[] { stockId, batchAttributeBean.getItemId(), batchAttributeBean.getBatchNo(), batchAttributeBean.getBatchQty(), exdate, batchAttributeBean.getManufacturer(), batchAttributeBean.getMrpPrice(), null, destLocId, batchAttributeBean.getOriginalConvertedQty(), 0 });

						}

					}
				}

			} catch (DataAccessException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		
		
		@Override
		public List<TransferReceivedBean> getTransferNoList(String transferType) throws Exception {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			TransferReceivedBean bean = new TransferReceivedBean();
			List<TransferReceivedBean> transferNoList = new ArrayList<>();
			int type = 0;
			if (transferType.equalsIgnoreCase("stock")) {
				type = 106;
			} else if (transferType.equalsIgnoreCase("consignment")) {
				type = 123;
			} else if (transferType.equalsIgnoreCase("stockReturn")) {
				type = 147;
			} else if (transferType.equalsIgnoreCase("stockIndent")) {
				type = 107;
			}
			try {
				transferNoList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_TRANSFER_NO, new Object[] { type, userDetails.getCompanyCode(), "approved", "partially recieved" }, new BeanPropertyRowMapper<>(TransferReceivedBean.class));

			} catch (DataAccessException e) {
				LOGGER.error("Error in Item List", e);
			}
			return transferNoList;

		}

		@Override
		public List<TransferReceivedDetailBean> getReceiveItemList(int id) throws Exception {

			List<TransferReceivedDetailBean> list = new ArrayList<>();
			try {
				list = jdbcTemplate.query(CommonUtilityQueryUtil.GET_TRANSFER_ITEM, new Object[] { id }, new BeanPropertyRowMapper<>(TransferReceivedDetailBean.class));

			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		@Override
		public List<TransferReceivedBean> getReceivedList(int limit, int offset, String transferType) {
			List<TransferReceivedBean> lReceivedBeans = new ArrayList<>();
			String type = "";
			try {
				if (transferType.equalsIgnoreCase("stock")) {
					transferType = "STR";
					type = "%" + transferType + "%";
				} else if (transferType.equalsIgnoreCase("consignment")) {
					transferType = "CTR";
					type = "%" + transferType + "%";
				} else if (transferType.equalsIgnoreCase("stockReturn")) {
					transferType = "SRR";
					type = "%" + transferType + "%";
				} else if (transferType.equalsIgnoreCase("stockIndent")) {
					transferType = "SIR";
					type = "%" + transferType + "%";
				}

				lReceivedBeans = jdbcTemplate.query(CommonUtilityQueryUtil.GET_RECEIVED_LIST, new Object[] { type }, new BeanPropertyRowMapper<>(TransferReceivedBean.class));
			} catch (DataAccessException e) {
				LOGGER.error("Error in Received List", e);
			}
			return lReceivedBeans;
		}

		@Override
		public boolean saveTransferRecive(TransferReceivedBean bean) {
			boolean isSuccess = false;
			String recvCode = "", transCode = "", transCode1 = "", code = "";
			try {
				if (bean.getTransferNo().startsWith("STN")) {
					code = "STR";
					transCode = "%" + code + "%";
					transCode1 = "STR0001";
				} else if (bean.getTransferNo().startsWith("CON")) {
					code = "CTR";
					transCode = "%" + "CTR" + "%";
					transCode1 = "CTR0001";
				} else if (bean.getTransferNo().startsWith("SRT")) {
					code = "SRR";
					transCode = "%" + "SRR" + "%";
					transCode1 = "SRR0001";
				} else if (bean.getTransferNo().startsWith("STI")) {
					code = "SIR";
					transCode = "%" + "SIR" + "%";
					transCode1 = "SIR0001";
				}

				else if (bean.getTransferNo().startsWith("ATN")) {
					code = "ATR";
					transCode = "%" + "ATR" + "%";
					transCode1 = "ATR0001";
				}

				recvCode = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.GET_STOCK_NUMBER, new Object[] { transCode1, code, transCode }, String.class);
				bean.setReceivedNo(recvCode);

				int recevdId = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.SAVE_TRANS_RECIVED, new Object[] { recvCode, bean.getTransferId(), bean.getReceivedDate(), bean.getReceivedByCode(), bean.getReceivedNote(), bean.getCompanyId() }, Integer.class);

				if (recevdId > 0) {
					isSuccess = saveTransferReciveDtl(bean, recevdId);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return isSuccess;
		}

		private boolean saveTransferReciveDtl(TransferReceivedBean bean, int recevdId) {
			boolean isSuccess = false, status = true;
			try {
				List<TransferReceivedDetailBean> alDetailList = bean.getTransferDtls();
				for (TransferReceivedDetailBean objTransferReceivedDetailBean : alDetailList) {
					int fnlQty = objTransferReceivedDetailBean.getPendingQty() - objTransferReceivedDetailBean.getReceivedQty();
					if (fnlQty > 0) {
						status = false;
					}

					int pendingQuantity = objTransferReceivedDetailBean.getPendingQty() - objTransferReceivedDetailBean.getReceivedQty();

					int dtlId = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.SAVE_TRANS_RECIVED_DTL, new Object[] { recevdId, objTransferReceivedDetailBean.getItemId(), objTransferReceivedDetailBean.getTransferQty(), objTransferReceivedDetailBean.getReceivedQty(), pendingQuantity }, Integer.class);

					if (dtlId > 0) {

						if (objTransferReceivedDetailBean.getAttributeBeans() != null && !objTransferReceivedDetailBean.getAttributeBeans().isEmpty()) {

							for (BatchAttributeBean batchAttributeBean : objTransferReceivedDetailBean.getAttributeBeans()) {

								int pendingqty = batchAttributeBean.getTransferQty() - batchAttributeBean.getReceiveQty();

								DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
								String expDate = null;
								Date exdate = null;
								if (batchAttributeBean.getExpiryDate() != null && !batchAttributeBean.getExpiryDate().isEmpty() && batchAttributeBean.getExpiryDate() != "") {
									exdate = df.parse(batchAttributeBean.getExpiryDate());
								}

								// int dtlId1 =
								// jdbcTemplate.queryForObject(CommonQueryUtil.SAVE_TRANS_RECIVED_BATCH_DTL,
								// new
								// Object[] { dtlId, batchAttributeBean.getItemId(),
								// batchAttributeBean.getBatchNo(),
								// batchAttributeBean.getBatchQty(), exdate,
								// batchAttributeBean.getMrpPrice(), pendingqty,
								// batchAttributeBean.getReceiveQty() },
								// Integer.class);

							}

						}

						if (bean.getFormName() != null && bean.getFormName().equalsIgnoreCase("Asset")) {
							boolean isSuccessDtl = insertStockReviceAssetTrackDetail(dtlId, bean.getCommonTrackList());
							if (isSuccessDtl) {

								updateInventoryAndLedgerInForAsset(bean.getReceivedNo(), bean.getReceivedDate(), 161, bean.getSourceLocId(), bean.getDestLocId(), bean.getTransferDtls().get(0).getItemId(), bean.getTransferDtls().get(0).getReceivedQty(), bean.getCommonTrackList(), transLocation, bean.getCommonTrackList());
								updateInventoryAndLedgerOutForAsset(bean.getReceivedNo(), bean.getReceivedDate(), 161, bean.getDestLocId(), bean.getSourceLocId(), bean.getTransferDtls().get(0).getItemId(), bean.getTransferDtls().get(0).getReceivedQty(), bean.getCommonTrackList(), transLocation, bean.getCommonTrackList());
								jdbcTemplate.update(CommonUtilityQueryUtil.UPDATE_TRANSFER_DTL, new Object[] { fnlQty, bean.getTransferId(), objTransferReceivedDetailBean.getItemId() });
								isSuccess = true;
							}

						} else {
							updateInventoryAndLedgerIn(bean.getReceivedNo(), bean.getReceivedDate(), 142, bean.getSourceLocId(), bean.getDestLocId(), objTransferReceivedDetailBean.getItemId(), objTransferReceivedDetailBean.getReceivedQty(), transLocation, objTransferReceivedDetailBean.getAttributeBeans());
							updateInventoryAndLedgerOut(bean.getReceivedNo(), bean.getReceivedDate(), 142, bean.getDestLocId(), bean.getSourceLocId(), objTransferReceivedDetailBean.getItemId(), objTransferReceivedDetailBean.getReceivedQty(), inTransistLocation, objTransferReceivedDetailBean.getAttributeBeans());
							jdbcTemplate.update(CommonUtilityQueryUtil.UPDATE_TRANSFER_DTL, new Object[] { fnlQty, bean.getTransferId(), objTransferReceivedDetailBean.getItemId() });

							/*
							 * if (objTransferReceivedDetailBean.getAttributeBeans() != null &&
							 * !objTransferReceivedDetailBean.getAttributeBeans(). isEmpty()) {
							 * 
							 * for (BatchAttributeBean batchAttributeBean :
							 * objTransferReceivedDetailBean.getAttributeBeans()) {
							 * 
							 * int pendingQty = batchAttributeBean.getBatchQty() -
							 * batchAttributeBean.getReceiveQty();
							 * 
							 * jdbcTemplate.update(CommonQueryUtil. UPDATE_TRANSFER_BATCH_DTL, new Object[]
							 * { pendingQty, batchAttributeBean.getStockTransferBatchDetailId() }); } }
							 */
							isSuccess = true;
						}

					}

				}
				if (status) {
					jdbcTemplate.update(CommonUtilityQueryUtil.UPDATE_TRANSFER_STATUS, new Object[] { "Received", bean.getTransferId() });
				} else {
					jdbcTemplate.update(CommonUtilityQueryUtil.UPDATE_TRANSFER_STATUS, new Object[] { "Partially Recieved", bean.getTransferId() });
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return isSuccess;
		}

		private void updateInventoryAndLedgerOutForAsset(String receivedNo, String receivedDate, int i, int destLocId,
				int sourceLocId, int itemId, int receivedQty,
				ArrayList<CommonUtillityAssetTrackDetailBean> commonTrackList, String transLocation2,
				ArrayList<CommonUtillityAssetTrackDetailBean> commonTrackList2) {
			// TODO Auto-generated method stub
			
		}

		private void updateInventoryAndLedgerInForAsset(String receivedNo, String receivedDate, int i, int sourceLocId,
				int destLocId, int itemId, int receivedQty,
				ArrayList<CommonUtillityAssetTrackDetailBean> commonTrackList, String transLocation2,
				ArrayList<CommonUtillityAssetTrackDetailBean> commonTrackList2) {
			// TODO Auto-generated method stub
			
		}

		private boolean insertStockReviceAssetTrackDetail(int dtlid, List<CommonUtillityAssetTrackDetailBean> list) {
			boolean isSuccess = false;
			int value = 0;
			try {
				for (int i = 0; i < list.size(); i++) {
					value = jdbcTemplate.update(CommonUtilityQueryUtil.INSERT_STOCK_RECEIVE_ASSET, new Object[] { dtlid, Integer.parseInt(list.get(i).getAsstDetailId()) });
					if (value > 0) {
						isSuccess = true;
					}
				}
			} catch (DataAccessException e) {
				LOGGER.error("Error in Insert the Stock Asset Detail Records!", e);
			}
			return isSuccess;
		}

		@Override
		public TransferReceivedBean getTransferReceiveView(Integer receivedId) {
			ArrayList<TransferReceivedDetailBean> receiveDetailList = new ArrayList<>();
			TransferReceivedBean objTransferReceivedBean = new TransferReceivedBean();
			try {
				objTransferReceivedBean = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.HEADER_TRANSFER_RECEIVE_VIEW, new Object[] { receivedId }, new BeanPropertyRowMapper<>(TransferReceivedBean.class));

				receiveDetailList = (ArrayList<TransferReceivedDetailBean>) jdbcTemplate.query(CommonUtilityQueryUtil.DETAIL_TRANSFER_RECEIVE_VIEW, new Object[] { receivedId }, new BeanPropertyRowMapper<>(TransferReceivedDetailBean.class));
				/*
				 * for (TransferReceivedDetailBean receivedDetailBean : receiveDetailList) {
				 * ArrayList<BatchAttributeBean> attributeBeans = new ArrayList<>();
				 * attributeBeans = (ArrayList<BatchAttributeBean>)
				 * jdbcTemplate.query(CommonQueryUtil. SELECT_TRANSFER_RECEIVE_VIEW_BATCH, new
				 * Object[] { receivedDetailBean.getStockReceivedDetailId() }, new
				 * BeanPropertyRowMapper<>(BatchAttributeBean.class));
				 * receivedDetailBean.setAttributeBeans(attributeBeans); }
				 */
				objTransferReceivedBean.setTransferDtls(receiveDetailList);

			} catch (DataAccessException e) {
				LOGGER.error("Error in getTransferReceiveView", e);
			}
			return objTransferReceivedBean;
		}

		
		@Override
		public boolean updateInventoryAndLedgerOutCheckQc(String formCode, String formDate, int type, int srcLocId, int destLocId, int itemId, double qnty, String transLocation, int qcStatus, List<BatchAttributeBean> attributeBeans) {

			try {
				double qty = 0;
				String transLoc = "%" + transLocation + "%";
				boolean isQc = false;

				if (type == 123 || type == 106 || type == 107 || type == 147) {
					srcLocId = getTransitLocation(transLoc, jdbcTemplate);

				} else if (type == 142 || type == 161) {
					destLocId = getTransitLocation(transLoc, jdbcTemplate);

				} else if (type == 88) {
					isQc = jdbcTemplate.queryForObject(GRNQueryUtil.CHECK_QC_FOR_ITEM, new Object[] { itemId }, Boolean.class);
					if (isQc)
						srcLocId = jdbcTemplate.queryForObject(GRNQueryUtil.GET_QC_LOCATION, new Object[] { formCode }, Integer.class);
				} else if (type == 149) {
					isQc = jdbcTemplate.queryForObject(GRNQueryUtil.CHECK_QC_FOR_ITEM, new Object[] { itemId }, Boolean.class);
					if (isQc)
						destLocId = jdbcTemplate.queryForObject(GRNQueryUtil.GET_QC_LOCATION, new Object[] { formCode }, Integer.class);
				}

				int inventryExst = jdbcTemplate.queryForObject(StockTransferQueryUtil.INVENTORY_EXISTS, new Object[] { destLocId, itemId }, Integer.class);

				if (inventryExst > 0) {
					double InventryQTY = jdbcTemplate.queryForObject(StockTransferQueryUtil.INVENTORY_HAND_QUANTITY, new Object[] { destLocId, itemId }, Double.class);
					qty = InventryQTY - qnty;

					jdbcTemplate.update(GRNQueryUtil.UPDATE_INVENTORY, new Object[] { formDate, qty, itemId, destLocId });

				} else {
					qty = -qnty;

					jdbcTemplate.update(GRNQueryUtil.SAVE_INVENTORY, new Object[] { formDate, destLocId, itemId, qty });

				}

				if (qcStatus == 146 || qcStatus == 148) {
					int inventoryId = jdbcTemplate.queryForObject(StockTransferQueryUtil.MAX_INVENTORY, new Object[] { destLocId, itemId }, Integer.class);
					Object[] params = new Object[] { inventoryId, destLocId, null, qnty, 0, formDate, type, formCode };
					int stockId = jdbcTemplate.queryForObject(GRNQueryUtil.SAVE_STOCK_LEDGER_NEW, params, Integer.class);

					if (attributeBeans != null) {

						if (attributeBeans.size() > 0) {

							for (BatchAttributeBean batchAttributeBean : attributeBeans) {
								DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
								String expDate = null;
								Date exdate = null;
								if (batchAttributeBean.getExpiryDate() != null && !batchAttributeBean.getExpiryDate().isEmpty() && batchAttributeBean.getExpiryDate() != "") {
									try {
										exdate = df.parse(batchAttributeBean.getExpiryDate());
									} catch (ParseException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

								}

								jdbcTemplate.update(GRNQueryUtil.SAVE_STOCK_LEDGER_BATCH, new Object[] { stockId, batchAttributeBean.getItemId(), batchAttributeBean.getBatchNo(), batchAttributeBean.getBatchQty(), exdate, batchAttributeBean.getManufacturer(), batchAttributeBean.getMrpPrice(), destLocId, null, 0, batchAttributeBean.getOriginalConvertedQty() });

							}

						}
					}
				}

			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			return true;
		}

		@Override
		public List<CommonUtilityBean> getSubAccountCodeNew(String sAccountCode) throws Exception {
			List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				
				lCommonUtilityBean = jdbcTemplate.query(CommonUtilityQueryUtil.sGetAccountSgListNew, new Object[] { sAccountCode },
						new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));


			} catch (DataAccessException e) {
				LOGGER.error("Error in getAccountHeadData", e);
			}
			return lCommonUtilityBean;
		}

		@Override
		public List<CommonUtilityBean> getParentLocationList() throws Exception {
			String qcRejectedLocation = "Qc Rejected";
			String virtualLocation = "Virtual Location";

			String transLoc = "%" + qcRejectedLocation + "%";
			int qcIdId = getTransitLocation(transLoc, jdbcTemplate);

			String virtualLoc = "%" + virtualLocation + "%";
			int virtualLocationId = getTransitLocation(virtualLoc, jdbcTemplate);

			List<CommonUtilityBean> parentlocationList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_PARENT_LOCATION, new BeanPropertyRowMapper<>(CommonUtilityBean.class), qcIdId, virtualLocationId);
			return parentlocationList;
		}

}
