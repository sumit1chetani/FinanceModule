package com.dci.tenant.finance.manageCustomer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.model.CommonUtilityBean;
import com.dci.tenant.common.CommonUtilityDAOImpl;
import com.dci.tenant.finance.accounthead.AccountHeadMasterQueryUtil;
import com.dci.tenant.finance.cashbankpayment.CashBankPaymentQueryUtil;
import com.dci.tenant.finance.creditnote.CreditNoteBean;

@Repository
public class ManageCustomerDAOImpl implements ManagecustomerDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(ManageCustomerDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * get City List
	 */
	@Override
	public ManageCustomerResultBean getCityList() {
		List<CommonUtilityBean> mainCityList = new ArrayList<>();
		ManageCustomerResultBean resultBean = new ManageCustomerResultBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			mainCityList = jdbcTemplate.query(ManageCustomerQueryUtil.GET_CITY_LIST, new BeanPropertyRowMapper<>(CommonUtilityBean.class));
			resultBean.setMainCityList(mainCityList);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return resultBean;
	}

	/**
	 * get State, Country Data with city Id
	 */
	@Override
	public ManageCustomerResultBean getCityStateCountryList(int cityId) {
		List<ManageCustomerBean> lCityStateList = new ArrayList<>();
		ManageCustomerResultBean resultBean = new ManageCustomerResultBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			lCityStateList = jdbcTemplate.query(ManageCustomerQueryUtil.GET_CITY_STATE_COUNTRY_LIST, new Object[] { cityId }, new BeanPropertyRowMapper<>(ManageCustomerBean.class));
			resultBean.setlManageCustomerBean(lCityStateList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return resultBean;
	}

	/**
	 * get paymentTerms List, accountType List, location list
	 */
	@Override
	public ManageCustomerResultBean getpaymentList() {
		ManageCustomerResultBean objmanageTaxResultBean = new ManageCustomerResultBean();
		List<ManageCustomerBean> paymentList = new ArrayList<>();
		List<ManageCustomerBankBean> accountTypeList = new ArrayList<>();
		List<CommonUtilityBean> locationList = new ArrayList<>();

		try {
			paymentList = jdbcTemplate.query(ManageCustomerQueryUtil.SELECT_PAYMENT_LIST, new BeanPropertyRowMapper<>(ManageCustomerBean.class));
			accountTypeList = jdbcTemplate.query(ManageCustomerQueryUtil.SELECT_ACCOUNT_TYPE, new BeanPropertyRowMapper<>(ManageCustomerBankBean.class));
			locationList = jdbcTemplate.query(ManageCustomerQueryUtil.GET_SOURCELOCATION_LIST, new BeanPropertyRowMapper<>(CommonUtilityBean.class));
			objmanageTaxResultBean.setLocationList(locationList);
			objmanageTaxResultBean.setPaymentList(paymentList);
			objmanageTaxResultBean.setAccountTypeList(accountTypeList);
			objmanageTaxResultBean.setSuccess(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getTypeList", e);

		}
		return objmanageTaxResultBean;
	}

	/**
	 * save Customer and Vendor Data
	 */
	@Override
	public List<ManageCustomerBean> saveCustomerData(ManageCustomerBean objManageCustomerBean, String userId) {
		List<ManageCustomerBean> alManageCustomerList = new ArrayList<>();
		String acct_name = "";
		String subGroupCode ="";
		String type = "";
		String desc = "";	
		boolean isSuccess = false;
		String customerCode = "", vendorCode = "", entityCode = "";
		try {

			jdbcTemplate = new JdbcTemplate(dataSource);

			String entityName = objManageCustomerBean.getEntityName();

			boolean isCust = objManageCustomerBean.getIsCustomer().equalsIgnoreCase("Y") ? true : false;
			boolean isVendor = objManageCustomerBean.getIsVendor().equalsIgnoreCase("Y") ? true : false;
			boolean isOthers = objManageCustomerBean.getIsOthers().equalsIgnoreCase("Y") ? true : false;
			boolean isCollege = objManageCustomerBean.getIsCollege().equalsIgnoreCase("Y") ? true : false;

			if (isCust && isVendor && isOthers ) {// Cust,Vendor,Entity - active
				customerCode = generateCustomerCode();
				vendorCode = generateSupplierCode();
				entityCode = generateEntityCode();

				if (objManageCustomerBean.getScreenName().equalsIgnoreCase("manageCustomer")) {
					objManageCustomerBean.setVendorPaymentTerm(objManageCustomerBean.getCustPaymentTerm());
					objManageCustomerBean.setVendorCreditLimit(objManageCustomerBean.getCreditLimit());
					objManageCustomerBean.setVendorLocation(objManageCustomerBean.getCustomerLocation());
					objManageCustomerBean.setResponsiblePersonPurchase(objManageCustomerBean.getResponsiblePersonSales());
				} else if (objManageCustomerBean.getScreenName().equalsIgnoreCase("manageVendor")) {
					objManageCustomerBean.setCustPaymentTerm(objManageCustomerBean.getVendorPaymentTerm());
					objManageCustomerBean.setCreditLimit(objManageCustomerBean.getVendorCreditLimit());
					objManageCustomerBean.setCustomerLocation(objManageCustomerBean.getVendorLocation());
					objManageCustomerBean.setResponsiblePersonSales(objManageCustomerBean.getResponsiblePersonPurchase());
				}

			} else if (isCust && isVendor) { // Customer and Vendor - active
				customerCode = generateCustomerCode();
				vendorCode = generateSupplierCode();

				if (objManageCustomerBean.getScreenName().equalsIgnoreCase("manageCustomer")) {
					objManageCustomerBean.setVendorPaymentTerm(objManageCustomerBean.getCustPaymentTerm());
					objManageCustomerBean.setVendorCreditLimit(objManageCustomerBean.getCreditLimit());
					objManageCustomerBean.setVendorLocation(objManageCustomerBean.getCustomerLocation());
					objManageCustomerBean.setResponsiblePersonPurchase(objManageCustomerBean.getResponsiblePersonSales());
				} else if (objManageCustomerBean.getScreenName().equalsIgnoreCase("manageVendor")) {
					objManageCustomerBean.setCustPaymentTerm(objManageCustomerBean.getVendorPaymentTerm());
					objManageCustomerBean.setCreditLimit(objManageCustomerBean.getVendorCreditLimit());
					objManageCustomerBean.setCustomerLocation(objManageCustomerBean.getVendorLocation());
					objManageCustomerBean.setResponsiblePersonSales(objManageCustomerBean.getResponsiblePersonPurchase());
				}
			} else if (isVendor && isOthers) {
				vendorCode = generateSupplierCode();
				entityCode = generateEntityCode();
			} else if (isCust && isOthers) {
				customerCode = generateCustomerCode();
				entityCode = generateEntityCode();
			} else if (isCust) {
				customerCode = generateCustomerCode();
			} else if (isVendor) {
				vendorCode = generateSupplierCode();
			} else if (isOthers) {
				entityCode = generateEntityCode();
			}
			String contactPerson = objManageCustomerBean.getContactPerson();
			String jobPosition = objManageCustomerBean.getJobPosition();
			String phoneNo = objManageCustomerBean.getPhoneNo();
			String mobileNo = objManageCustomerBean.getMobile();
			String email = objManageCustomerBean.getEmail();
			String fax = objManageCustomerBean.getFax();
			String websiteUrl = objManageCustomerBean.getWebsite();
			String tinNo = objManageCustomerBean.getTinNumber();
			String cstNo = objManageCustomerBean.getCstNumber();
			String panNo = objManageCustomerBean.getPanNumber();
			String gstNo = objManageCustomerBean.getGstNumber();
			String accountreceivable = objManageCustomerBean.getAccountPayable();
			String accountpayable = objManageCustomerBean.getTotalReceivable();

			boolean isActive = objManageCustomerBean.getIsActive().equalsIgnoreCase("Y") ? true : false;
			String locationAddress = objManageCustomerBean.getLocationAddress();
			int cityId = objManageCustomerBean.getCityId();

			int addressId = CommonUtilityDAOImpl.insertAddress(cityId, locationAddress, userId, jdbcTemplate);
			String internalNotes = objManageCustomerBean.getInternalNotes();
			String responsiblePersonSales = objManageCustomerBean.getResponsiblePersonSales();
			String responsiblePersonPurchase = objManageCustomerBean.getResponsiblePersonPurchase();

			Integer custPaymentTerm = objManageCustomerBean.getCustPaymentTerm();
			Integer vendorPaymentTerm = objManageCustomerBean.getVendorPaymentTerm();

			Integer custCredLimit = objManageCustomerBean.getCreditLimit();
			Integer vendorCredLimit = objManageCustomerBean.getVendorCreditLimit();

			Integer customerLocation = objManageCustomerBean.getCustomerLocation();
			Integer vendorLocation = objManageCustomerBean.getVendorLocation();

			String deliveryMethod = objManageCustomerBean.getDeliveryMethod();
			String currency = objManageCustomerBean.getCurrencyCode();
			Integer iEntityId = 0;

			if (objManageCustomerBean.getScreenName().equalsIgnoreCase("manageCustomer")) {
				Object[] params = new Object[] { entityName, isCust, isVendor,isCollege,isOthers, contactPerson, jobPosition, phoneNo, mobileNo, email, fax, websiteUrl, tinNo, cstNo, panNo, gstNo, isActive, addressId, internalNotes, responsiblePersonSales, responsiblePersonPurchase, custPaymentTerm, vendorPaymentTerm, custCredLimit, vendorCredLimit, userId, customerCode, vendorCode, entityCode, customerLocation, vendorLocation, deliveryMethod };
				iEntityId = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.saveManageCustomerData, params, Integer.class);
				
				acct_name = "Sundry Debtor";
				List<Map<String, Object>> RowData = jdbcTemplate.queryForList(CashBankPaymentQueryUtil.ACCT_HEAD_CODE,
						new Object[] { acct_name });
				for (Map<String, Object> row : RowData) {
					subGroupCode = (String) row.get("sub_group_acct_code");
				}				
				desc = "Customer";
				type = "0";
				
			} else if (objManageCustomerBean.getScreenName().equalsIgnoreCase("manageVendor")) {
				Object[] params = new Object[] { entityName, isCust, isVendor,isCollege, isOthers, contactPerson, jobPosition, phoneNo, mobileNo, email, fax, websiteUrl, tinNo, cstNo, panNo, gstNo, isActive, addressId, internalNotes, responsiblePersonSales, responsiblePersonPurchase, custPaymentTerm, vendorPaymentTerm, custCredLimit, vendorCredLimit, userId, customerCode, vendorCode, entityCode, customerLocation, vendorLocation, deliveryMethod };
				iEntityId = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.saveManageVendorData, params, Integer.class);
				
				acct_name = "Sundry Creditor";
				List<Map<String, Object>> RowData = jdbcTemplate.queryForList(CashBankPaymentQueryUtil.ACCT_HEAD_CODE,
						new Object[] { acct_name });
				for (Map<String, Object> row : RowData) {
					subGroupCode = (String) row.get("sub_group_acct_code");
				}
				desc = "Vendor";
				type = "1";
			}
			
			 
			String acctHeadCode = "" + subGroupCode + "0001";
			String acctHeadCodeLike = "" + subGroupCode + "%";
			String AcctHeadCode = jdbcTemplate.queryForObject(AccountHeadMasterQueryUtil.AUTOGENERATE_OF_ACCT_HEAD_CODE_WITHOUT_ZERO, new Object[] { acctHeadCode, acctHeadCodeLike }, String.class);
			String AcctHeadName = objManageCustomerBean.getEntityName();					 
			String financialYearId = "";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(AccountHeadMasterQueryUtil.GET_FINANCIAL_YEAR_ID);
			for (Map row : rows) {
				financialYearId = (String) row.get("financial_year_id");
			}
			String currencyCode = "INR";			 
			String acctHeadStatus = "Y";
			 
			//null0001, MS. ATUL, null,  , INR, null, Y, 2021-22, E0001, 2021-10-12 00:00:00, null, null, Vendor, null
			//acct_head_code, subgroup_acct_code, acct_head_name, acct_head_desc, ACCT_HEAD_FOR, created_by, created_dt,ACCT_CURRENCY,FINYEAR_ID,ACCT_HEAD_STATUS)
			if (iEntityId > 0) {
				objManageCustomerBean.setEntityId(iEntityId);
				if (objManageCustomerBean.getScreenName().equalsIgnoreCase("manageCustomer")) {
					jdbcTemplate.update(AccountHeadMasterQueryUtil.sInsertSubGroup, new Object[] { AcctHeadCode, subGroupCode, AcctHeadName.toLowerCase(), desc, type, userId, currencyCode, financialYearId, acctHeadStatus });
					isSuccess = saveEntityAddressCustomerDetailData(objManageCustomerBean, userId);
					isSuccess = saveEntityCustomerContactDetailData(objManageCustomerBean, userId);
					isSuccess = saveEntityCustomerBankDetailData(objManageCustomerBean, userId);
				} else if (objManageCustomerBean.getScreenName().equalsIgnoreCase("manageVendor")) {
					jdbcTemplate.update(AccountHeadMasterQueryUtil.sInsertSubGroup, new Object[] { AcctHeadCode, subGroupCode, AcctHeadName.toUpperCase(), desc, type, userId, currencyCode, financialYearId, acctHeadStatus });
					isSuccess = saveEntityAddressDetailData(objManageCustomerBean, userId);
					isSuccess = saveEntityContactDetailData(objManageCustomerBean, userId);
					isSuccess = saveEntityBankDetailData(objManageCustomerBean, userId);
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Customer Records!", e);
		}

		alManageCustomerList.add(objManageCustomerBean);

		return alManageCustomerList;
	}

	/**
	 * save Entity Address Details with Entity Id
	 * 
	 * @param objManageCustomerBean
	 * @param userId
	 * @return
	 */

	private boolean saveEntityAddressCustomerDetailData(ManageCustomerBean objManageCustomerBean, String userId) {
		List<ManageCustomerAddressBean> customerAddressList = objManageCustomerBean.getCustomerAddressobj();
		int iShipAddressId = 0, iDelAddressId = 0, iBillAddressId = 0;
		boolean isSuccess = false;
		try {
			if (customerAddressList.size() > 0) {
				for (ManageCustomerAddressBean objAddressBean : customerAddressList) {

					if (objAddressBean.getAddressType() == 130) {// Shipping
						iShipAddressId = insertAddress(objAddressBean.getCityAddressId(), objManageCustomerBean.getShipAddress(), userId);
						int iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_CUSTOMER_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iShipAddressId, objAddressBean.getAddressType() });
						if (iAddrDet > 0) {
							isSuccess = true;
						}
					}
					if (objAddressBean.getAddressType() == 131) {// Delivery
						iDelAddressId = insertAddress(objAddressBean.getCitydeliveryId(), objManageCustomerBean.getDeliveryAddress(), userId);
						int iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_CUSTOMER_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iDelAddressId, objAddressBean.getAddressType() });
						if (iAddrDet > 0) {
							isSuccess = true;
						}
					}
					if (objAddressBean.getAddressType() == 132) {// Billing
						iBillAddressId = insertAddress(objAddressBean.getCitybillingId(), objManageCustomerBean.getBillingAddress(), userId);
						int iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_CUSTOMER_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iBillAddressId, objAddressBean.getAddressType() });
						if (iAddrDet > 0) {
							isSuccess = true;
						}
					}

				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Entity Address Records!", e);
		}
		return isSuccess;
	}

	private boolean saveEntityAddressDetailData(ManageCustomerBean objManageCustomerBean, String userId) {
		List<ManageCustomerAddressBean> customerAddressList = objManageCustomerBean.getCustomerAddressobj();
		int iShipAddressId = 0, iDelAddressId = 0, iBillAddressId = 0;
		boolean isSuccess = false;
		try {
			if (customerAddressList.size() > 0) {
				for (ManageCustomerAddressBean objAddressBean : customerAddressList) {

					if (objAddressBean.getAddressType() == 130) {// Shipping
						iShipAddressId = insertAddress(objAddressBean.getCityAddressId(), objManageCustomerBean.getShipAddress(), userId);
						int iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iShipAddressId, objAddressBean.getAddressType() });
						if (iAddrDet > 0) {
							isSuccess = true;
						}
					}
					if (objAddressBean.getAddressType() == 131) {// Delivery
						iDelAddressId = insertAddress(objAddressBean.getCitydeliveryId(), objManageCustomerBean.getDeliveryAddress(), userId);
						int iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iDelAddressId, objAddressBean.getAddressType() });
						if (iAddrDet > 0) {
							isSuccess = true;
						}
					}
					if (objAddressBean.getAddressType() == 132) {// Billing
						iBillAddressId = insertAddress(objAddressBean.getCitybillingId(), objManageCustomerBean.getBillingAddress(), userId);
						int iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iBillAddressId, objAddressBean.getAddressType() });
						if (iAddrDet > 0) {
							isSuccess = true;
						}
					}

				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Entity Address Records!", e);
		}
		return isSuccess;
	}

	/**
	 * save Entity Contact Details with Entity Id
	 * 
	 * @param objManageCustomerBean
	 * @param userId
	 * @return
	 */
	private boolean saveEntityContactDetailData(ManageCustomerBean objManageCustomerBean, String userId) {
		List<ManageCustomerContactBean> customerContactList = objManageCustomerBean.getCustomerContactobj();
		boolean isSuccess = false;
		try {
			for (ManageCustomerContactBean objContactBean : customerContactList) {
				int iContDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_ENTITY_CONTACT_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objContactBean.getContactName(), objContactBean.getJobPosition(), objContactBean.getPhone(), objContactBean.getMobile(), objContactBean.getEmail() });
				if (iContDet > 0) {
					isSuccess = true;
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the  Entity Contact Records!", e);
		}

		return isSuccess;
	}

	private boolean saveEntityCustomerContactDetailData(ManageCustomerBean objManageCustomerBean, String userId) {
		List<ManageCustomerContactBean> customerContactList = objManageCustomerBean.getCustomerContactobj();
		boolean isSuccess = false;
		try {
			for (ManageCustomerContactBean objContactBean : customerContactList) {
				int iContDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_CUSTOMER_ENTITY_CONTACT_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objContactBean.getContactName(), objContactBean.getJobPosition(), objContactBean.getPhone(), objContactBean.getMobile(), objContactBean.getEmail() });
				if (iContDet > 0) {
					isSuccess = true;
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the  Entity Contact Records!", e);
		}

		return isSuccess;
	}

	private boolean saveEntityBankDetailData(ManageCustomerBean objManageCustomerBean, String userId) {
		List<ManageCustomerBankBean> customerBankList = objManageCustomerBean.getCustomerBankobj();
		boolean isSuccess = false;
		int iBankAddressId = 0;
		try {
			if (customerBankList.size() > 0) {
				for (ManageCustomerBankBean objBankBean : customerBankList) {
					iBankAddressId = insertAddress(objBankBean.getBankCityId(), objBankBean.getBankDetAddress(), userId);

					int iBankDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_ENTITY_BANK_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objBankBean.getBankName(), objBankBean.getAccountNo(), objBankBean.getAccountTypeId(), objBankBean.getIfscCode(), iBankAddressId });
					if (iBankDet > 0) {
						isSuccess = true;
					}
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the  Entity Contact Records!", e);
		}

		return isSuccess;
	}

	private boolean saveEntityCustomerBankDetailData(ManageCustomerBean objManageCustomerBean, String userId) {
		List<ManageCustomerBankBean> customerBankList = objManageCustomerBean.getCustomerBankobj();
		boolean isSuccess = false;
		int iBankAddressId = 0;
		try {
			if (customerBankList.size() > 0) {
				for (ManageCustomerBankBean objBankBean : customerBankList) {

					iBankAddressId = insertAddress(objBankBean.getBankCityId(), objBankBean.getBankDetAddress(), userId);

					int iBankDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_CUSTOMER_ENTITY_BANK_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objBankBean.getBankName(), objBankBean.getAccountNo(), objBankBean.getAccountTypeId(), objBankBean.getIfscCode(), iBankAddressId });
					if (iBankDet > 0) {
						isSuccess = true;
					}
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the  Entity Contact Records!", e);
		}

		return isSuccess;
	}

	/**
	 * get Entity Code **********************
	 * 
	 * @return
	 */
	private String generateEntityCode() {

		String entityCode = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ManageCustomerQueryUtil.ENTITY_CODE_AUTOGEN);
			for (Map row : rows) {
				entityCode = (String) row.get("entity_acct_code");
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Generate Supplier Code", e);
		}
		return entityCode;
	}

	/**
	 * get Supplier Code
	 * 
	 * @return
	 */
	private String generateSupplierCode() {

		String supplierCode = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ManageCustomerQueryUtil.SUPPLIER_CODE_AUTOGEN);
			for (Map row : rows) {
				supplierCode = (String) row.get("supplier_acct_code");
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Generate Supplier Code", e);
		}
		return supplierCode;
	}

	/**
	 * get Customer Code
	 * 
	 * @return
	 */
	private String generateCustomerCode() {

		String customerCode = "";
		String sCNYear = "", sDefaultCNNo = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ManageCustomerQueryUtil.CUSTOMER_CODE_AUTOGEN);
			for (Map row : rows) {
				customerCode = (String) row.get("customer_acct_code");
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Generate Customer Code", e);
		}
		return customerCode;
	}

	/**
	 * insert Address
	 * 
	 * @param cityId
	 * @param locationAddress
	 * @param userId
	 * @return
	 */
	public int insertAddress(final int cityId, final String locationAddress, final String userId) {
		final String INSERT_ADDRESS = "insert into address (city_id, street, created_by, created_date) values(?,?,?,current_date)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_ADDRESS, new String[] { "address_id" });
				ps.setInt(1, cityId);
				ps.setString(2, locationAddress);
				ps.setString(3, userId);
				return ps;
			}
		}, keyHolder);

		return keyHolder.getKey().intValue();
	}

	/**
	 * get Customer and Vendor Data on List page
	 */
	@Override
	public List<ManageCustomerBean> getCustomerList(int limit, int offset, String entityType) {
		List<ManageCustomerBean> alManageEntityList = new ArrayList<>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (entityType.equalsIgnoreCase("manageCustomer")) {
				alManageEntityList = jdbcTemplate.query(ManageCustomerQueryUtil.sGetCustomerList, new BeanPropertyRowMapper<>(ManageCustomerBean.class));
			} else if (entityType.equalsIgnoreCase("manageSupplier")) {
				alManageEntityList = jdbcTemplate.query(ManageCustomerQueryUtil.sGetVendorList, new BeanPropertyRowMapper<>(ManageCustomerBean.class));
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in get Credit Note List", e);
		}
		return alManageEntityList;
	}

	/**
	 * get Customer and Vendor Data On Edit
	 */
	@Override
	public ManageCustomerBean getCustomerDataOnEdit(int entityId, String screenName) {
		ArrayList<ManageCustomerAddressBean> alAddressList = new ArrayList<>();
		ArrayList<ManageCustomerContactBean> alContactList = new ArrayList<>();
		ArrayList<ManageCustomerBankBean> alBankList = new ArrayList<>();
		ManageCustomerBean bean = null;
		ManageCustomerBean objManageCustomerBean = new ManageCustomerBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (screenName.equalsIgnoreCase("manageCustomer")) {
				objManageCustomerBean = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.sGetCustomerHeaderListWithEntityId, new Object[] { entityId }, new BeanPropertyRowMapper<>(ManageCustomerBean.class));

				alAddressList = (ArrayList<ManageCustomerAddressBean>) jdbcTemplate.query(ManageCustomerQueryUtil.GET_ENTITY_ADDRESS_ON_EDIT, new Object[] { entityId }, new BeanPropertyRowMapper<>(ManageCustomerAddressBean.class));

				alContactList = (ArrayList<ManageCustomerContactBean>) jdbcTemplate.query(ManageCustomerQueryUtil.GET_ENTITY_CONTACT_ON_EDIT, new Object[] { entityId }, new BeanPropertyRowMapper<>(ManageCustomerContactBean.class));

				alBankList = (ArrayList<ManageCustomerBankBean>) jdbcTemplate.query(ManageCustomerQueryUtil.GET_ENTITY_BANK_ON_EDIT, new Object[] { entityId }, new BeanPropertyRowMapper<>(ManageCustomerBankBean.class));

				objManageCustomerBean.setCustomerAddressobj(alAddressList);
				objManageCustomerBean.setCustomerContactobj(alContactList);
				objManageCustomerBean.setCustomerBankobj(alBankList);
			} else if (screenName.equalsIgnoreCase("manageVendor")) {
				objManageCustomerBean = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.sGetVendorHeaderListWithEntityId, new Object[] { entityId }, new BeanPropertyRowMapper<>(ManageCustomerBean.class));

				alAddressList = (ArrayList<ManageCustomerAddressBean>) jdbcTemplate.query(ManageCustomerQueryUtil.GET_ENTITY_ADDRESS_ON_EDIT, new Object[] { entityId }, new BeanPropertyRowMapper<>(ManageCustomerAddressBean.class));

				alContactList = (ArrayList<ManageCustomerContactBean>) jdbcTemplate.query(ManageCustomerQueryUtil.GET_ENTITY_CONTACT_ON_EDIT, new Object[] { entityId }, new BeanPropertyRowMapper<>(ManageCustomerContactBean.class));

				alBankList = (ArrayList<ManageCustomerBankBean>) jdbcTemplate.query(ManageCustomerQueryUtil.GET_ENTITY_BANK_ON_EDIT, new Object[] { entityId }, new BeanPropertyRowMapper<>(ManageCustomerBankBean.class));

				objManageCustomerBean.setCustomerAddressobj(alAddressList);
				objManageCustomerBean.setCustomerContactobj(alContactList);
				objManageCustomerBean.setCustomerBankobj(alBankList);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in get Credit Note List", e);
		}
		return objManageCustomerBean;
	}

	/**
	 * uodate Customer and Vendor Data
	 */
	@Override
	public List<ManageCustomerBean> updateCustmerData(ManageCustomerBean objManageCustomerBean, String userId) {
		List<ManageCustomerBean> alManageCustomerList = new ArrayList<>();
		CreditNoteBean bean = null;
		boolean isSuccess = false;
		String customerCode = "", vendorCode = "", entityCode = "";
		try {

			jdbcTemplate = new JdbcTemplate(dataSource);

			String entityName = objManageCustomerBean.getEntityName();

			boolean isCust = objManageCustomerBean.getIsCustomer().equalsIgnoreCase("Y") ? true : false;
			boolean isVendor = objManageCustomerBean.getIsVendor().equalsIgnoreCase("Y") ? true : false;
			boolean isOthers = objManageCustomerBean.getIsOthers().equalsIgnoreCase("Y") ? true : false;
			boolean isCollege = objManageCustomerBean.getIsCollege().equalsIgnoreCase("Y") ? true : false;

			if (isCust && isVendor && isOthers) {
				customerCode = objManageCustomerBean.getCustomerAcctCode();
				vendorCode = objManageCustomerBean.getSupplierAcctCode();
				entityCode = objManageCustomerBean.getEntityAcctCode();

				if (objManageCustomerBean.getScreenName().equalsIgnoreCase("manageCustomer")) {
					objManageCustomerBean.setVendorPaymentTerm(objManageCustomerBean.getCustPaymentTerm());
					objManageCustomerBean.setVendorCreditLimit(objManageCustomerBean.getCreditLimit());
					objManageCustomerBean.setVendorLocation(objManageCustomerBean.getCustomerLocation());
					objManageCustomerBean.setResponsiblePersonPurchase(objManageCustomerBean.getResponsiblePersonSales());
				} else if (objManageCustomerBean.getScreenName().equalsIgnoreCase("manageVendor")) {
					objManageCustomerBean.setCustPaymentTerm(objManageCustomerBean.getVendorPaymentTerm());
					objManageCustomerBean.setCreditLimit(objManageCustomerBean.getVendorCreditLimit());
					objManageCustomerBean.setCustomerLocation(objManageCustomerBean.getVendorLocation());
					objManageCustomerBean.setResponsiblePersonSales(objManageCustomerBean.getResponsiblePersonPurchase());
				}
			} else if (isCust && isVendor) {
				customerCode = objManageCustomerBean.getCustomerAcctCode();
				vendorCode = objManageCustomerBean.getSupplierAcctCode();

				if (objManageCustomerBean.getScreenName().equalsIgnoreCase("manageCustomer")) {
					objManageCustomerBean.setVendorPaymentTerm(objManageCustomerBean.getCustPaymentTerm());
					objManageCustomerBean.setVendorCreditLimit(objManageCustomerBean.getCreditLimit());
					objManageCustomerBean.setVendorLocation(objManageCustomerBean.getCustomerLocation());
					objManageCustomerBean.setResponsiblePersonPurchase(objManageCustomerBean.getResponsiblePersonSales());
				} else if (objManageCustomerBean.getScreenName().equalsIgnoreCase("manageVendor")) {
					objManageCustomerBean.setCustPaymentTerm(objManageCustomerBean.getVendorPaymentTerm());
					objManageCustomerBean.setCreditLimit(objManageCustomerBean.getVendorCreditLimit());
					objManageCustomerBean.setCustomerLocation(objManageCustomerBean.getVendorLocation());
					objManageCustomerBean.setResponsiblePersonSales(objManageCustomerBean.getResponsiblePersonPurchase());
				}
			} else if (isVendor && isOthers) {
				vendorCode = objManageCustomerBean.getSupplierAcctCode();
				entityCode = objManageCustomerBean.getEntityAcctCode();
			} else if (isCust && isOthers) {
				customerCode = objManageCustomerBean.getCustomerAcctCode();
				entityCode = objManageCustomerBean.getEntityAcctCode();
			} else if (isCust) {
				customerCode = objManageCustomerBean.getCustomerAcctCode();
			} else if (isVendor) {
				vendorCode = objManageCustomerBean.getSupplierAcctCode();
			} else if (isOthers) {
				entityCode = objManageCustomerBean.getEntityAcctCode();
			}
			String contactPerson = objManageCustomerBean.getContactPerson();
			String jobPosition = objManageCustomerBean.getJobPosition();
			String phoneNo = objManageCustomerBean.getPhoneNo();
			String mobileNo = objManageCustomerBean.getMobile();
			String email = objManageCustomerBean.getEmail();
			String fax = objManageCustomerBean.getFax();
			String websiteUrl = objManageCustomerBean.getWebsite();
			String tinNo = objManageCustomerBean.getTinNumber();
			String cstNo = objManageCustomerBean.getCstNumber();
			String panNo = objManageCustomerBean.getPanNumber();
			String gstNo = objManageCustomerBean.getGstNumber();

			boolean isActive = objManageCustomerBean.getIsActive().equalsIgnoreCase("Y") ? true : false;

			int addressId = objManageCustomerBean.getAddressId();
			String locationAddress = objManageCustomerBean.getLocationAddress();
			int cityId = objManageCustomerBean.getCityId();
			Integer iAddressCount = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.CHECK_ADDRESS_COUNT, new Object[] { addressId, cityId }, Integer.class);
			if (iAddressCount > 0) {
				boolean iAddressUpd = CommonUtilityDAOImpl.updateAddress(cityId, locationAddress, userId, addressId, jdbcTemplate);
			} else {
				addressId = CommonUtilityDAOImpl.insertAddress(cityId, locationAddress, userId, jdbcTemplate);
			}

			String internalNotes = objManageCustomerBean.getInternalNotes();
			String responsiblePersonSales = objManageCustomerBean.getResponsiblePersonSales();
			String responsiblePersonPurchase = objManageCustomerBean.getResponsiblePersonPurchase();
			Integer custPaymentTerm = objManageCustomerBean.getCustPaymentTerm();
			Integer vendorPaymentTerm = objManageCustomerBean.getVendorPaymentTerm();
			Integer custCredLimit = objManageCustomerBean.getCreditLimit();
			Integer vendorCredLimit = objManageCustomerBean.getVendorCreditLimit();
			Integer customerLocation = objManageCustomerBean.getCustomerLocation();
			Integer vendorLocation = objManageCustomerBean.getVendorLocation();
			String deliveryMethod = objManageCustomerBean.getDeliveryMethod();
			String currency = objManageCustomerBean.getCurrencyCode();
			int iCustUpdate = 0;
			if (objManageCustomerBean.getScreenName().equalsIgnoreCase("manageCustomer")) {
				iCustUpdate = jdbcTemplate.update(ManageCustomerQueryUtil.updateManageCustomerData, new Object[] { entityName, isCust, isVendor,isCollege, isOthers, contactPerson, jobPosition, phoneNo, mobileNo, email, fax, websiteUrl, tinNo, cstNo, panNo, gstNo, isActive, addressId, internalNotes, responsiblePersonSales, responsiblePersonPurchase, custPaymentTerm, vendorPaymentTerm, custCredLimit, vendorCredLimit, userId, customerLocation, vendorLocation, deliveryMethod, objManageCustomerBean.getEntityId() });
			} else if (objManageCustomerBean.getScreenName().equalsIgnoreCase("manageVendor")) {
				iCustUpdate = jdbcTemplate.update(ManageCustomerQueryUtil.updateManageVendorData, new Object[] { entityName, isCust, isVendor, isCollege, isOthers, contactPerson, jobPosition, phoneNo, mobileNo, email, fax, websiteUrl, tinNo, cstNo, panNo, gstNo, isActive, addressId, internalNotes, responsiblePersonSales, responsiblePersonPurchase, custPaymentTerm, vendorPaymentTerm, custCredLimit, vendorCredLimit, userId, customerLocation, vendorLocation, deliveryMethod, currency, objManageCustomerBean.getEntityId() });
			}

			// if (iCustUpdate > 0) {

			if (objManageCustomerBean.getScreenName().equalsIgnoreCase("manageCustomer")) {

				isSuccess = updateCustomerEntityAddressDetailData(objManageCustomerBean, userId);
				isSuccess = updateCustomerEntityContactDetailData(objManageCustomerBean, userId);
				isSuccess = updateCustomerEntityBankDetailData(objManageCustomerBean, userId);

			} else if (objManageCustomerBean.getScreenName().equalsIgnoreCase("manageVendor")) {
				isSuccess = updateEntityAddressDetailData(objManageCustomerBean, userId);
				isSuccess = updateEntityContactDetailData(objManageCustomerBean, userId);
				isSuccess = updateEntityBankDetailData(objManageCustomerBean, userId);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Records!", e);
		}

		alManageCustomerList.add(objManageCustomerBean);

		return alManageCustomerList;
	}

	private boolean updateCustomerEntityAddressDetailData(ManageCustomerBean objManageCustomerBean, String userId) {
		List<ManageCustomerAddressBean> customerAddressList = objManageCustomerBean.getCustomerAddressobj();
		int iShipAddressId = 0, iDelAddressId = 0, iBillAddressId = 0;
		int iShipAddressCnt = 0, iDelAddressCnt = 0, iBillAddressIdCnt = 0;
		boolean isSuccess = false;
		try {
			if (customerAddressList.size() > 0) {
				for (ManageCustomerAddressBean objAddressBean : customerAddressList) {

					if (objAddressBean.getAddressType() == 130) {// Shipping

						Integer iAddressCount = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.CHECK_ADDRESS_COUNT, new Object[] { objAddressBean.getShipAddressId(), objAddressBean.getCityAddressId() }, Integer.class);

						if (iAddressCount > 0) {

							boolean iAddressUpd = CommonUtilityDAOImpl.updateAddress(objAddressBean.getCityAddressId(), objManageCustomerBean.getShipAddress(), userId, objAddressBean.getShipAddressId(), jdbcTemplate);

							iShipAddressCnt = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.CHECK_CUSTOMER_ENTITY_ADDRESS_COUNT, new Object[] { objAddressBean.getAddressType(), objManageCustomerBean.getEntityId() }, Integer.class);

							int iAddrDet;

							if (iShipAddressCnt > 0) {

								iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.UPDATE_CUSTOMER_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objAddressBean.getShipAddressId(), objAddressBean.getAddressType(), objAddressBean.getEntityAddressId() });

							} else {
								iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_CUSTOMER_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objAddressBean.getShipAddressId(), objAddressBean.getAddressType() });
							}

							if (iAddrDet > 0)
								isSuccess = true;
						} else {
							iShipAddressId = CommonUtilityDAOImpl.insertAddress(objAddressBean.getCityAddressId(), objManageCustomerBean.getShipAddress(), userId, jdbcTemplate);
							if (iShipAddressId > 0) {
								iShipAddressCnt = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.CHECK_ADDRESS_COUNT, new Object[] { objAddressBean.getShipAddressId(), objAddressBean.getCityAddressId() }, Integer.class);

								int iAddrDet;
								if (iShipAddressCnt > 0) {
									iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.UPDATE_CUSTOMER_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iShipAddressId, objAddressBean.getAddressType(), objAddressBean.getEntityAddressId() });

								} else {
									iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_CUSTOMER_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iShipAddressId, objAddressBean.getAddressType() });
								}
								if (iAddrDet > 0)
									isSuccess = true;
							}
						}
					}
					if (objAddressBean.getAddressType() == 131) {// Delivery

						Integer iAddressCount = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.CHECK_ADDRESS_COUNT, new Object[] { objAddressBean.getDeliveryAddressId(), objAddressBean.getCitydeliveryId() }, Integer.class);
						if (iAddressCount > 0) {
							boolean iAddressUpd = CommonUtilityDAOImpl.updateAddress(objAddressBean.getCitydeliveryId(), objManageCustomerBean.getDeliveryAddress(), userId, objAddressBean.getDeliveryAddressId(), jdbcTemplate);

							iDelAddressCnt = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.CHECK_CUSTOMER_ENTITY_ADDRESS_COUNT, new Object[] { objAddressBean.getAddressType(), objManageCustomerBean.getEntityId() }, Integer.class);

							int iAddrDet;
							if (iDelAddressCnt > 0) {
								iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.UPDATE_CUSTOMER_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objAddressBean.getDeliveryAddressId(), objAddressBean.getAddressType(), objAddressBean.getEntityAddressId() });
							} else {
								iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_CUSTOMER_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objAddressBean.getDeliveryAddressId(), objAddressBean.getAddressType() });

							}

							if (iAddrDet > 0)
								isSuccess = true;
						} else {
							iDelAddressId = CommonUtilityDAOImpl.insertAddress(objAddressBean.getCitydeliveryId(), objManageCustomerBean.getDeliveryAddress(), userId, jdbcTemplate);
							if (iDelAddressId > 0) {

								iDelAddressCnt = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.CHECK_CUSTOMER_ENTITY_ADDRESS_COUNT, new Object[] { objAddressBean.getAddressType(), objManageCustomerBean.getEntityId() }, Integer.class);

								int iAddrDet;
								if (iDelAddressCnt > 0) {
									iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.UPDATE_CUSTOMER_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iDelAddressId, objAddressBean.getAddressType(), objAddressBean.getEntityAddressId() });
								} else {
									iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_CUSTOMER_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iDelAddressId, objAddressBean.getAddressType() });

								}
								if (iAddrDet > 0)
									isSuccess = true;
							}
						}
					}
					if (objAddressBean.getAddressType() == 132) {// Billing

						Integer iAddressCount = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.CHECK_ADDRESS_COUNT, new Object[] { objAddressBean.getBillingAddressId(), objAddressBean.getCitybillingId() }, Integer.class);
						if (iAddressCount > 0) {

							boolean iAddressUpd = CommonUtilityDAOImpl.updateAddress(objAddressBean.getCitybillingId(), objManageCustomerBean.getBillingAddress(), userId, objAddressBean.getBillingAddressId(), jdbcTemplate);

							iBillAddressIdCnt = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.CHECK_CUSTOMER_ENTITY_ADDRESS_COUNT, new Object[] { objAddressBean.getAddressType(), objManageCustomerBean.getEntityId() }, Integer.class);

							int iAddrDet = 0;

							if (iBillAddressIdCnt > 0) {

								iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.UPDATE_CUSTOMER_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objAddressBean.getBillingAddressId(), objAddressBean.getAddressType(), objAddressBean.getEntityAddressId() });

							} else {
								iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_CUSTOMER_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objAddressBean.getBillingAddressId(), objAddressBean.getAddressType() });

							}

							if (iAddrDet > 0)
								isSuccess = true;
						} else {
							iBillAddressId = CommonUtilityDAOImpl.insertAddress(objAddressBean.getCitybillingId(), objManageCustomerBean.getBillingAddress(), userId, jdbcTemplate);
							if (iBillAddressId > 0) {
								int iAddrDet = 0;
								if (iBillAddressIdCnt > 0) {
									iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.UPDATE_CUSTOMER_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iBillAddressId, objAddressBean.getAddressType(), objAddressBean.getEntityAddressId() });
								} else {
									iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_CUSTOMER_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iBillAddressId, objAddressBean.getAddressType() });
								}

								if (iAddrDet > 0)
									isSuccess = true;
							}

						}
					}

				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Entity Address Records!", e);
		}
		return isSuccess;
	}

	private boolean updateEntityAddressDetailData(ManageCustomerBean objManageCustomerBean, String userId) {
		List<ManageCustomerAddressBean> customerAddressList = objManageCustomerBean.getCustomerAddressobj();
		int iShipAddressId = 0, iDelAddressId = 0, iBillAddressId = 0;
		int iShipAddressCnt = 0, iDelAddressCnt = 0, iBillAddressIdCnt = 0;
		boolean isSuccess = false;
		try {
			if (customerAddressList.size() > 0) {
				for (ManageCustomerAddressBean objAddressBean : customerAddressList) {

					if (objAddressBean.getAddressType() == 130) {// Shipping

						Integer iAddressCount = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.CHECK_ADDRESS_COUNT, new Object[] { objAddressBean.getShipAddressId(), objAddressBean.getCityAddressId() }, Integer.class);

						if (iAddressCount > 0) {

							boolean iAddressUpd = CommonUtilityDAOImpl.updateAddress(objAddressBean.getCityAddressId(), objManageCustomerBean.getShipAddress(), userId, objAddressBean.getShipAddressId(), jdbcTemplate);

							iShipAddressCnt = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.CHECK_ENTITY_ADDRESS_COUNT, new Object[] { objAddressBean.getAddressType(), objManageCustomerBean.getEntityId() }, Integer.class);

							int iAddrDet;

							if (iShipAddressCnt > 0) {

								iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.UPDATE_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objAddressBean.getShipAddressId(), objAddressBean.getAddressType(), objAddressBean.getEntityAddressId() });

							} else {
								iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objAddressBean.getShipAddressId(), objAddressBean.getAddressType() });
							}

							if (iAddrDet > 0)
								isSuccess = true;
						} else {
							iShipAddressId = CommonUtilityDAOImpl.insertAddress(objAddressBean.getCityAddressId(), objManageCustomerBean.getShipAddress(), userId, jdbcTemplate);
							if (iShipAddressId > 0) {
								iShipAddressCnt = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.CHECK_ADDRESS_COUNT, new Object[] { objAddressBean.getShipAddressId(), objAddressBean.getCityAddressId() }, Integer.class);

								int iAddrDet;
								if (iShipAddressCnt > 0) {
									iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.UPDATE_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iShipAddressId, objAddressBean.getAddressType(), objAddressBean.getEntityAddressId() });

								} else {
									iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iShipAddressId, objAddressBean.getAddressType() });
								}
								if (iAddrDet > 0)
									isSuccess = true;
							}
						}
					}
					if (objAddressBean.getAddressType() == 131) {// Delivery

						Integer iAddressCount = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.CHECK_ADDRESS_COUNT, new Object[] { objAddressBean.getDeliveryAddressId(), objAddressBean.getCitydeliveryId() }, Integer.class);
						if (iAddressCount > 0) {
							boolean iAddressUpd = CommonUtilityDAOImpl.updateAddress(objAddressBean.getCitydeliveryId(), objManageCustomerBean.getDeliveryAddress(), userId, objAddressBean.getDeliveryAddressId(), jdbcTemplate);

							iDelAddressCnt = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.CHECK_ENTITY_ADDRESS_COUNT, new Object[] { objAddressBean.getAddressType(), objManageCustomerBean.getEntityId() }, Integer.class);

							int iAddrDet;
							if (iDelAddressCnt > 0) {
								iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.UPDATE_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objAddressBean.getDeliveryAddressId(), objAddressBean.getAddressType(), objAddressBean.getEntityAddressId() });
							} else {
								iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objAddressBean.getDeliveryAddressId(), objAddressBean.getAddressType() });

							}

							if (iAddrDet > 0)
								isSuccess = true;
						} else {
							iDelAddressId = CommonUtilityDAOImpl.insertAddress(objAddressBean.getCitydeliveryId(), objManageCustomerBean.getDeliveryAddress(), userId, jdbcTemplate);
							if (iDelAddressId > 0) {

								iDelAddressCnt = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.CHECK_ENTITY_ADDRESS_COUNT, new Object[] { objAddressBean.getAddressType(), objManageCustomerBean.getEntityId() }, Integer.class);

								int iAddrDet;
								if (iDelAddressCnt > 0) {
									iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.UPDATE_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iDelAddressId, objAddressBean.getAddressType(), objAddressBean.getEntityAddressId() });
								} else {
									iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iDelAddressId, objAddressBean.getAddressType() });

								}
								if (iAddrDet > 0)
									isSuccess = true;
							}
						}
					}
					if (objAddressBean.getAddressType() == 132) {// Billing

						Integer iAddressCount = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.CHECK_ADDRESS_COUNT, new Object[] { objAddressBean.getBillingAddressId(), objAddressBean.getCitybillingId() }, Integer.class);
						if (iAddressCount > 0) {

							boolean iAddressUpd = CommonUtilityDAOImpl.updateAddress(objAddressBean.getCitybillingId(), objManageCustomerBean.getBillingAddress(), userId, objAddressBean.getBillingAddressId(), jdbcTemplate);

							iBillAddressIdCnt = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.CHECK_ENTITY_ADDRESS_COUNT, new Object[] { objAddressBean.getAddressType(), objManageCustomerBean.getEntityId() }, Integer.class);

							int iAddrDet = 0;

							if (iBillAddressIdCnt > 0) {

								iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.UPDATE_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objAddressBean.getBillingAddressId(), objAddressBean.getAddressType(), objAddressBean.getEntityAddressId() });

							} else {
								iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objAddressBean.getBillingAddressId(), objAddressBean.getAddressType() });

							}

							if (iAddrDet > 0)
								isSuccess = true;
						} else {
							iBillAddressId = CommonUtilityDAOImpl.insertAddress(objAddressBean.getCitybillingId(), objManageCustomerBean.getBillingAddress(), userId, jdbcTemplate);
							if (iBillAddressId > 0) {
								int iAddrDet = 0;
								if (iBillAddressIdCnt > 0) {
									iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.UPDATE_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iBillAddressId, objAddressBean.getAddressType(), objAddressBean.getEntityAddressId() });
								} else {
									iAddrDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_ENTITY_ADDRESS_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), iBillAddressId, objAddressBean.getAddressType() });
								}

								if (iAddrDet > 0)
									isSuccess = true;
							}

						}
					}

				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Entity Address Records!", e);
		}
		return isSuccess;
	}

	private boolean updateEntityBankDetailData(ManageCustomerBean objManageCustomerBean, String userId) {
		List<ManageCustomerBankBean> customerBankList = objManageCustomerBean.getCustomerBankobj();
		boolean isSuccess = false;
		int iBankAddressId = 0;
		try {

			int iEntBank = jdbcTemplate.update(ManageCustomerQueryUtil.DELETE_ENTITY_BANK, new Object[] { objManageCustomerBean.getEntityId() });
			if (customerBankList.size() > 0) {
				for (ManageCustomerBankBean objBankBean : customerBankList) {

					iBankAddressId = insertAddress(objBankBean.getBankCityId(), objBankBean.getBankDetAddress(), userId);

					int iBankDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_ENTITY_BANK_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objBankBean.getBankName(), objBankBean.getAccountNo(), objBankBean.getAccountTypeId(), objBankBean.getIfscCode(), iBankAddressId });
					if (iBankDet > 0) {
						isSuccess = true;
					}
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the  Entity Contact Records!", e);
		}

		return isSuccess;
	}

	private boolean updateCustomerEntityBankDetailData(ManageCustomerBean objManageCustomerBean, String userId) {
		List<ManageCustomerBankBean> customerBankList = objManageCustomerBean.getCustomerBankobj();
		boolean isSuccess = false;
		int iBankAddressId = 0;
		try {

			int iEntBank = jdbcTemplate.update(ManageCustomerQueryUtil.DELETE_CUSTOMER_ENTITY_BANK, new Object[] { objManageCustomerBean.getEntityId() });
			if (customerBankList.size() > 0) {
				for (ManageCustomerBankBean objBankBean : customerBankList) {

					iBankAddressId = insertAddress(objBankBean.getBankCityId(), objBankBean.getBankDetAddress(), userId);

					int iBankDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_CUSTOMER_ENTITY_BANK_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objBankBean.getBankName(), objBankBean.getAccountNo(), objBankBean.getAccountTypeId(), objBankBean.getIfscCode(), iBankAddressId });
					if (iBankDet > 0) {
						isSuccess = true;
					}
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the  Entity Contact Records!", e);
		}

		return isSuccess;
	}

	private boolean updateEntityContactDetailData(ManageCustomerBean objManageCustomerBean, String userId) {
		List<ManageCustomerContactBean> customerContactList = objManageCustomerBean.getCustomerContactobj();
		boolean isSuccess = false;
		int j = 0;
		try {

			j = jdbcTemplate.update(ManageCustomerQueryUtil.DELETE_ENTITY_CONTACT, new Object[] { objManageCustomerBean.getEntityId() });
			for (ManageCustomerContactBean objContactBean : customerContactList) {

				int iContDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_ENTITY_CONTACT_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objContactBean.getContactName(), objContactBean.getJobPosition(), objContactBean.getPhone(), objContactBean.getMobile(), objContactBean.getEmail() });
				if (iContDet > 0) {
					isSuccess = true;
				}

			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the  Entity Contact Records!", e);
		}

		return isSuccess;
	}

	private boolean updateCustomerEntityContactDetailData(ManageCustomerBean objManageCustomerBean, String userId) {
		List<ManageCustomerContactBean> customerContactList = objManageCustomerBean.getCustomerContactobj();
		boolean isSuccess = false;
		int j = 0;
		try {

			j = jdbcTemplate.update(ManageCustomerQueryUtil.DELETE_CUSTOMER_ENTITY_CONTACT, new Object[] { objManageCustomerBean.getEntityId() });
			for (ManageCustomerContactBean objContactBean : customerContactList) {

				int iContDet = jdbcTemplate.update(ManageCustomerQueryUtil.SAVE_CUSTOMER_ENTITY_CONTACT_DETAILS, new Object[] { objManageCustomerBean.getEntityId(), objContactBean.getContactName(), objContactBean.getJobPosition(), objContactBean.getPhone(), objContactBean.getMobile(), objContactBean.getEmail() });
				if (iContDet > 0) {
					isSuccess = true;
				}

			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the  Entity Contact Records!", e);
		}

		return isSuccess;
	}

	@Override
	public boolean deleteEntityMaster(Integer entityId) {
		ManageCustomerResultBean resultBean = new ManageCustomerResultBean();
		boolean isSuccess = false;
		try {

			int iEntAddr = jdbcTemplate.update(ManageCustomerQueryUtil.DELETE_ENTITY_ADDRESS, new Object[] { entityId });
			int iEntBank = jdbcTemplate.update(ManageCustomerQueryUtil.DELETE_ENTITY_BANK, new Object[] { entityId });
			int iEntContact = jdbcTemplate.update(ManageCustomerQueryUtil.DELETE_ENTITY_CONTACT, new Object[] { entityId });
			int iEntityMaster = jdbcTemplate.update(ManageCustomerQueryUtil.DELETE_ENTITY_New, new Object[] { entityId });
			
			
			
			if (iEntityMaster > 0)
				isSuccess = true;

		} catch (DataAccessException e) {
			isSuccess = false;
			LOGGER.error("Error in delete Entity Master", e);
		}
		return isSuccess;
	}

	@Override
	public int checkVendorName(String entityName) throws Exception {
		int entityId = 0;
		try {

			entityId = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.sCheckVendorName, Integer.class, entityName );

		} catch (DataAccessException e) {
			LOGGER.error("Error in Check Vendor Name", e);
		}

		return entityId;

	}

	@Override
	public int checkCustomerName(String entityName) throws Exception {
		int entityId = 0;
		try {

			entityId = jdbcTemplate.queryForObject(ManageCustomerQueryUtil.sCheckCustomerName, Integer.class, entityName );

		} catch (DataAccessException e) {
			LOGGER.error("Error in Check Vendor Name", e);
		}

		return entityId;

	}

	@Override
	public boolean deleteEntityCustMaster(Integer entityId) {
		ManageCustomerResultBean resultBean = new ManageCustomerResultBean();
		boolean isSuccess = false;
		try {

			int iEntAddr = jdbcTemplate.update(ManageCustomerQueryUtil.DELETE_ENTITY_ADDRESS, new Object[] { entityId });
			int iEntBank = jdbcTemplate.update(ManageCustomerQueryUtil.DELETE_ENTITY_BANK, new Object[] { entityId });
			int iEntContact = jdbcTemplate.update(ManageCustomerQueryUtil.DELETE_ENTITY_CONTACT, new Object[] { entityId });
			int iEntityMaster = jdbcTemplate.update(ManageCustomerQueryUtil.DELETE_ENTITY_New, new Object[] { entityId });

			
			
			if (iEntityMaster > 0)
				isSuccess = true;

		} catch (DataAccessException e) {
			isSuccess = false;
			LOGGER.error("Error in delete Entity Master", e);
		}
		return isSuccess;
	}

}
