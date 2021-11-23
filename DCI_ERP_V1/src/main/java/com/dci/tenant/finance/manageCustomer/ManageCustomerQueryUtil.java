package com.dci.tenant.finance.manageCustomer;

public class ManageCustomerQueryUtil {

	public static final String GetShiftSchemeMasterList = "select scheme_name as schemeName,TO_CHAR(valid_from,'dd/mm/yyyy') as validityFrom,TO_CHAR(valid_to,'dd/mm/yyyy') as validityTo from shift_scheme order by scheme_name desc";

	public static final String sCheckShiftName = "SELECT count(*) FROM shift_scheme WHERE scheme_name = ? ";

	public static String SELECT_SHIFT_NAME_LIST = "select shift_id as shiftCode,shift_name as shiftName from shift";

	public static String sGetShiftSchemeMasterEditList = "select scheme_name as schemeName,To_CHAR(valid_from,'dd/mm/yyyy') as validityFrom,TO_CHAR(valid_to,'dd/mm/yyyy') as validityTo from shift_scheme where scheme_name=? ";

	public static final String sCheckAllShiftName = "SELECT count(*) FROM shifts_in_scheme WHERE scheme_name = ? and shift_id= ? and week_day= ? ";

	public static String sGetShiftSchemeMasterWeekList = "select scheme_name as schemeName,week_day as weekDay,shift_id as shiftId from shifts_in_scheme where scheme_name=?";

	public static final String sUpdateDeleteShiftSchemeDetails = "delete from shifts_in_scheme where scheme_name=? and week_day= ?";

	public static String sDeleteShiftSchemeMaster = "delete from shift_scheme where scheme_name=? ";
	public static String sDeleteEmployeeShiftMaster = "delete from employee_shift_scheme where scheme_name=? ";

	public static String sDeleteShiftSchemeDetails = "delete from shifts_in_scheme where scheme_name=? ";

	public static String sCheckShiftNameDetails = "SELECT count(*) FROM shifts_in_scheme WHERE scheme_name = ? ";

	public static String sCheckVendorName = "SELECT count(*) FROM entity WHERE LOWER(entity_name)=LOWER(?)";

	public static String sCheckCustomerName = "SELECT count(*) FROM customer_entity WHERE LOWER(entity_name)=LOWER(?)";

	public static String sCheckVendorId = "SELECT entity_id FROM entity WHERE entity_name=?";

	public static final String INSERT_SHIFTSCHEME_UPLOAD = "INSERT INTO shift_scheme(scheme_name, valid_from, valid_to) values(?, ?, ?)";

	public static final String GET_CITY_STATE_LIST = "select city_id cityId, city_name cityName, state.state_code stateCode,state.state_name stateName, pincode, " + "country.country_code countryCode, country.country_name countryName " + "from city " + "inner join state on state.state_code = city.state_code inner join country on state.country_code = state.country_code";

	public static final String GET_CITY_STATE_COUNTRY_LIST ="select city.cty_id cityId,city.cty_nam cityName, zp_cd as pincode, state.stt_cd stateCode,state.stt_nam stateName, country.cntry_cd countryCode, country.cntry_nam countryName from state inner join city  on city.stt_id = state.stt_id inner join country on country.cntry_id = state.cntry_id where city.cty_id=?";
			
			//t city.city_id cityId,city.city_name cityName, pincode, state.stt.cd stateCode,state.state_name stateName, " + "state.country_code countryCode, country.country_name countryName " + "from state " + "inner join city on city.sttd_id = state.sttd_id inner join country on country.country_code = state.country_code where city.city_id=? ";

	public static final String GET_CITY_LIST = "select cty_id as id,cty_nam as text from city";
	public static final String GET_CITY_SHIPPING_LIST = "select city_id as id,city_id cityAddressId, city_name cityNameAddress,city_name as text from city";
	public static final String GET_CITY_BILLING_LIST = "select city_id as id,city_id citybillingId, city_name citybillingName,city_name as text from city";
	public static final String GET_CITY_DELIVERY_LIST = "select city_id as id,city_id citydeliveryId, city_name citydeliveryName,city_name as text from city";

/*	public static final String saveManageCustomerData = "insert into customer_entity (entity_name, is_customer,is_vendor, is_college,is_others, contact_person, job_position, contact_phone, contact_mobile, email, fax, " + "website_url,tin_number, cst_number, pan_number, gst_number, is_active,address_id, internal_notes, responsible_person_sales,responsible_person_purchase,customer_payment_terms,vendor_payment_terms, "
			+ "customer_credit_limit,vendor_credit_limit,created_by,created_date, customer_acct_code, supplier_acct_code, entity_acct_code,customer_location,vendor_location,delivery_method) " + "values(?,?,?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?,current_date,?,?,?,?,?,?) returning entity_id";
*/
	
	public static final String saveManageCustomerData = "insert into customer_entity (entity_name, is_customer,is_vendor,is_college,is_others, contact_person, job_position, contact_phone, contact_mobile, email, fax, " + "website_url,tin_number, cst_number, pan_number, gst_number,is_active,address_id, internal_notes, responsible_person_sales,responsible_person_purchase,customer_payment_terms,vendor_payment_terms, "
			+ "customer_credit_limit,vendor_credit_limit,created_by,created_date, customer_acct_code, supplier_acct_code, entity_acct_code, customer_location,vendor_location,delivery_method) " + "values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,?, ?,?,?,?,?,current_date,?,?,?,?,?,?) returning entity_id";

	public static final String saveManageVendorData = "insert into entity (entity_name, is_customer,is_vendor,is_college,is_others, contact_person, job_position, contact_phone, contact_mobile, email, fax, " + "website_url,tin_number, cst_number, pan_number, gst_number,is_active,address_id, internal_notes, responsible_person_sales,responsible_person_purchase,customer_payment_terms,vendor_payment_terms, "
			+ "customer_credit_limit,vendor_credit_limit,created_by,created_date, customer_acct_code, supplier_acct_code, entity_acct_code, customer_location,vendor_location,delivery_method) " + "values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,?, ?,?,?,?,?,current_date,?,?,?,?,?,?) returning entity_id";

	public static final String updateManageCustomerData = "update customer_entity set entity_name=?, is_customer=?,is_vendor=?, is_college =?,is_others=?, contact_person=?, job_position=?, contact_phone=?, contact_mobile=?, email=?, fax=?, " + "website_url=?,tin_number=?, cst_number=?, pan_number=?,gst_number=?, is_active=?, address_id=?, internal_notes=?, responsible_person_sales=?,responsible_person_purchase=?,customer_payment_terms=?,vendor_payment_terms=?, "
			+ "customer_credit_limit=?, vendor_credit_limit=?,modified_by=?, modified_date=current_date, customer_location=?,vendor_location=?,delivery_method=? where entity_id=?";

	public static final String updateManageVendorData = "update entity set entity_name=?, is_customer=?,is_vendor=?, is_college =?,is_others=?, contact_person=?, job_position=?, contact_phone=?, contact_mobile=?, email=?, fax=?, " + "website_url=?,tin_number=?, cst_number=?, pan_number=?, gst_number=?,is_active=?, address_id=?, internal_notes=?, responsible_person_sales=?,responsible_person_purchase=?,customer_payment_terms=?,vendor_payment_terms=?, "
			+ "customer_credit_limit=?,vendor_credit_limit=?, modified_by=?, modified_date=current_date, customer_location=?,vendor_location=?,delivery_method=?, currency=? where entity_id=?";

	public static final String CUSTOMER_CODE_AUTOGEN = "SELECT CASE WHEN MAX(customer_acct_code) IS NULL THEN 'C0001' ELSE rpad(MAX(customer_acct_code),1,'C')|| " + "lpad(cast(cast((SUBSTRING(MAX(customer_acct_code),2)) as int)+1 as text),4,'0')  " + "END AS customer_acct_code FROM customer_entity where customer_acct_code like 'C%' ";

	public static final String SUPPLIER_CODE_AUTOGEN = "SELECT CASE WHEN MAX(supplier_acct_code) IS NULL THEN 'S0001' ELSE rpad(MAX(supplier_acct_code),1,'S')|| " + "lpad(cast(cast((SUBSTRING(MAX(supplier_acct_code),2)) as int)+1 as text),4,'0')  " + "END AS supplier_acct_code FROM entity where supplier_acct_code like 'S%'";

	public static final String ENTITY_CODE_AUTOGEN = "SELECT CASE WHEN MAX(entity_acct_code) IS NULL THEN 'N0001' ELSE rpad(MAX(entity_acct_code),1,'N')|| " + "lpad(cast(cast((SUBSTRING(MAX(entity_acct_code),2)) as int)+1 as text),4,'0')  " + "END AS entity_acct_code FROM entity where entity_acct_code like 'N%'";

	public static final String sGetCustomerList = "select entity_id entityId, entity_name entityName, is_vendor isVendor, is_customer isCustomer, is_others isOthers, contact_person contactPerson, job_position jobPosition, contact_phone phone, contact_mobile mobile, email, COALESCE(fax,'') fax,  website_url website, COALESCE(tin_number,'') tinNumber, COALESCE(cst_number,'') cstNumber, "
+ "			COALESCE(pan_number,'') panNumber, is_active isActive, COALESCE(address.address_id,0) addressId, address.street locationAddress,COALESCE(city.cty_id,0) cityId, city.cty_nam cityName, state.stt_cd  desStateCode, state.stt_nam stateName, city.zp_cd as pincode, customer_acct_code customerAcctCode, supplier_acct_code supplierAcctCode,entity_acct_code entityAcctCode from customer_entity left join address on address.address_id = customer_entity.address_id left join city on city.cty_id = address.city_id "
+ "			left join state on state.stt_id = city.stt_id where is_customer='t'  ORDER by entity_id desc;";
	public static final String sGetVendorList = "select entity_id entityId, entity_name entityName, is_vendor isVendor, is_customer isCustomer, is_others isOthers, contact_person contactPerson,  job_position jobPosition, contact_phone phone, contact_mobile mobile, email, COALESCE(fax,'') fax,   website_url website, COALESCE(tin_number,'') tinNumber, COALESCE(cst_number,'') cstNumber,  COALESCE(pan_number,'') panNumber, is_active isActive, COALESCE(address.address_id,0) addressId, address.street locationAddress,COALESCE(city.cty_id,0) cityId,  city.cty_nam cityName, state.stt_cd desStateCode, state.stt_nam stateName, city.zp_cd,  customer_acct_code customerAcctCode, supplier_acct_code supplierAcctCode,entity_acct_code entityAcctCode from entity  left join address on address.address_id = entity.address_id  left join city on city.cty_id = address.city_id left join state on state.stt_id = city.stt_id where is_vendor='t'  ORDER by entity_id desc	";
			


	public static final String sGetCustomerHeaderListWithEntityId = "select entity_id entityId, COALESCE(entity_name,'') entityName, is_vendor isVendor,  is_college as isCollege , is_customer isCustomer, is_others isOthers, contact_person contactPerson,job_position jobPosition, COALESCE(contact_phone,'') AS phoneNo, COALESCE(contact_mobile,'') mobile, email, COALESCE(fax,'') fax, website_url website, COALESCE(tin_number,'') tinNumber, COALESCE(cst_number,'') cstNumber,  COALESCE(pan_number,'') panNumber, is_active isActive, COALESCE(address.address_id,0) addressId, address.street locationAddress,COALESCE(city.cty_id,0) cityId, city.cty_nam cityName, state.stt_cd desStateCode, state.stt_nam desState, city.zp_cd desZipcode,  country.cntry_cd desCountryCode, country.cntry_nam desCountry, internal_notes internalNotes, responsible_person_purchase responsiblePersonPurchase, responsible_person_sales responsiblePersonSales, account_payable, vendor_payment_terms vendorPaymentTerm, customer_payment_terms custPaymentTerm, vendor_credit_limit vendorCreditLimit, customer_credit_limit creditLimit, COALESCE(customer_location,0) customerLocation, COALESCE(vendor_location,0) vendorLocation,delivery_method deliveryMethod, customer_acct_code customerAcctCode, supplier_acct_code supplierAcctCode,entity_acct_code entityAcctCode from customer_entity left join address on address.address_id = customer_entity.address_id left join city on city.cty_id = address.city_id left join state on state.stt_id = city.stt_id left join country on country.cntry_id=state.cntry_id where entity_id=?";

	public static final String updateAddress = "update address set city_id=?, street=?, modified_by=?, modified_date=current_date where address_id=?";

	public static final String SELECT_PAYMENT_LIST = "select value paymentTerms, def_table_id paymentId from def_table where form_field_id=50";
	public static final String SELECT_ACCOUNT_TYPE = "select value accountType, def_table_id  accounttypeId from def_table where form_field_id=51";

	public static final String SAVE_ENTITY_ADDRESS_DETAILS = "INSERT into entity_address (entity_id, address_id, address_type) values(?,?,?)";

	public static final String SAVE_CUSTOMER_ENTITY_ADDRESS_DETAILS = "INSERT into customer_entity_address (entity_id, address_id, address_type) values(?,?,?)";

	public static final String SAVE_ENTITY_CONTACT_DETAILS = "INSERT into entity_contact (entity_id, name, job_position, phone, mobile, email) values(?,?,?,?,?,?)";

	public static final String SAVE_CUSTOMER_ENTITY_CONTACT_DETAILS = "INSERT into customer_entity_contact (entity_id, name, job_position, phone, mobile, email) values(?,?,?,?,?,?)";

	public static final String SAVE_ENTITY_BANK_DETAILS = "INSERT into entity_bank (entity_id, bank_name, account_number, account_type, ifsc_code, address_id) values(?,?,?,?,?,?);";

	public static final String SAVE_CUSTOMER_ENTITY_BANK_DETAILS = "INSERT into customer_entity_bank (entity_id, bank_name, account_number, account_type, ifsc_code, address_id) values(?,?,?,?,?,?);";

	public static final String GET_ENTITY_ADDRESS_ON_EDIT = "select entity_address_id entityAddressId, address_type addressType, " + "CASE WHEN address_type=130 then address.city_id end cityAddressId, CASE WHEN address_type=130 then COALESCE(address.street,'') end shipAddress, " + "CASE WHEN address_type=130 then COALESCE(address.address_id,0) end shipAddressId, " + "CASE WHEN address_type=131 then address.city_id end citydeliveryId, CASE WHEN address_type=131 then COALESCE(address.street,'') end deliveryAddress, "
			+ "CASE WHEN address_type=131 then COALESCE(address.address_id,0) end deliveryAddressId, " + "CASE WHEN address_type=132 then address.city_id end citybillingId, CASE WHEN address_type=132 then COALESCE(address.street,'') end billingAddress, " + "CASE WHEN address_type=132 then COALESCE(address.address_id,0) end billingAddressId " + "from entity_address  ea left join address on address.address_id = ea.address_id WHERE entity_id=?  order by address_type asc";

	//public static final String GET_ENTITY_CONTACT_ON_EDIT = "select entity_contact_id entityContactId, entity_id entityId, name contactName, job_position jobPosition, phone, mobile, email from customer_entity_contact  WHERE entity_id=?";

	public static final String GET_ENTITY_CONTACT_ON_EDIT = "select entity_contact_id entityContactId, entity_id entityId, name contactName, job_position jobPosition, phone, mobile, email from entity_contact  WHERE entity_id=?";

	public static final String GET_ENTITY_BANK_ON_EDIT = "select entity_bank_id entityBankId, entity_id entityId, bank_name bankName, account_number accountNo, def_table.def_table_id accountTypeId, def_table.value account_type, " + "ifsc_code ifscCode, address.city_id  bankCityId, address.street bankDetAddress, eb.address_id bankAddressId from entity_bank  eb  " + "left join address on address.address_id = eb.address_id  left join def_table on def_table.def_table_id = eb.account_type WHERE entity_id=?";

	public static final String GET_SOURCELOCATION_LIST = "WITH RECURSIVE q AS (SELECT location_id ,cast(location_name as varchar(255)) as path FROM location WHERE parent_location_id is null and is_active='t' UNION ALL SELECT ic.location_id,cast( q.path ||' / ' || cast(ic.location_name as varchar(255)) as  varchar(255)) FROM location ic JOIN q ON  ic.parent_location_id =  q.location_id where ic.is_active='t') SELECT location_id as id,path as text  FROM q ";

	public static final String UPDATE_ENTITY_ADDRESS_DETAILS = "UPDATE entity_address set entity_id=?, address_id=?, address_type=? where entity_address_id=?";

	public static final String UPDATE_CUSTOMER_ENTITY_ADDRESS_DETAILS = "UPDATE customer_entity_address set entity_id=?, address_id=?, address_type=? where entity_address_id=?";

	public static final String CHECK_ADDRESS_COUNT = "select count(*) from address where address_id=? and city_id=? ";

	public static final String CHECK_ENTITY_ADDRESS_COUNT = "select count(*) from entity_address where address_type =? and entity_id=? ";

	public static final String CHECK_CUSTOMER_ENTITY_ADDRESS_COUNT = "select count(*) from customer_entity_address where address_type =? and entity_id=? ";

	public static final String UPDATE_ENTITY_CONTACT_DETAILS = "UPDATE entity_contact SET entity_id=?, name=?, job_position=?, phone=?, mobile=?, email=? WHERE  entity_contact_id=?";

	public static final String UPDATE_ENTITY_BANK_DETAILS = "UPDATE entity_bank SET entity_id=?, bank_name=?, account_number=?, account_type=?, ifsc_code=?, address_id=? WHERE entity_bank_id=?";

	public static final String sGetVendorHeaderListWithEntityId ="select entity_id entityId, COALESCE(entity_name,'') entityName, is_vendor isVendor, is_customer isCustomer,is_college as isCollege , is_others isOthers, contact_person contactPerson,job_position jobPosition, COALESCE(contact_phone,'') AS phoneNo, COALESCE(contact_mobile,'') mobile, email, COALESCE(fax,'') fax, website_url website, COALESCE(tin_number,'') tinNumber, COALESCE(cst_number,'') cstNumber,  COALESCE(pan_number,'') panNumber, COALESCE(gst_number,'') gstNumber, is_active isActive, COALESCE(address.address_id,0) addressId, address.street locationAddress,COALESCE(city.cty_id,0) cityId, city.cty_nam cityName, state.stt_cd desStateCode, state.stt_nam desState, city. zp_cd as  desZipcode,  country.cntry_cd  desCountryCode,country.cntry_nam desCountry, internal_notes internalNotes, responsible_person_purchase responsiblePersonPurchase, responsible_person_purchase responsiblePersonPurchase, account_payable, vendor_payment_terms vendorPaymentTerm, customer_payment_terms custPaymentTerm, vendor_credit_limit vendorCreditLimit, customer_credit_limit creditLimit, COALESCE(customer_location,0) customerLocation, COALESCE(vendor_location,0) vendorLocation, delivery_method deliveryMethod, customer_acct_code customerAcctCode, supplier_acct_code supplierAcctCode,entity_acct_code entityAcctCode, currency as currencyCode from entity left join address on address.address_id = entity.address_id left join city on city.cty_id = address.city_id left join state on state.stt_id = city.stt_id left join country on country.cntry_id=state.cntry_id where entity_id=?";
	public static final String DELETE_ENTITY_ADDRESS = "delete from entity_address where entity_id=? ";

	public static final String DELETE_ENTITY_BANK = "delete from entity_bank where entity_id=? ";

	public static final String DELETE_CUSTOMER_ENTITY_BANK = "delete from customer_entity_bank where entity_id=? ";

	public static final String DELETE_ENTITY_CONTACT = "delete from entity_contact where entity_id=? ";

	public static final String DELETE_CUSTOMER_ENTITY_CONTACT = "delete from customer_entity_contact where entity_id=? ";

	public static final String DELETE_ENTITY = "delete from entity where entity_id=? ";
	public static final String DELETE_ENTITY_New = "delete from customer_entity where entity_id=? ";


}
