package com.dci.mobileApp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dci.tenant.user.UserDetail;
import com.dci.tenant.user.UserMasterDAO;
import com.dci.tenant.user.UserMasterService;

@Repository
public class MobileAppDAOImpl implements MobileAppDAO {

	@Autowired
	private UserMasterService userMasterService;

	@Autowired
	private UserMasterDAO UserMasterDAO;

	@Autowired
	DataSource dataSource;

	@Autowired
//	@Qualifier("TrmsDataSource")
	DataSource TrmsDataSource;

	@Override
	public MobileAppResultBean userLogin(MobileAppBean userDetail) {
		// TODO Auto-generated method stub
		MobileAppResultBean moblieUserResultBean = new MobileAppResultBean();
		UserDetail userDetail1 = new UserDetail();
		MobileAppBean TRMSBean = new MobileAppBean();

		try {
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpServletRequest request = attr.getRequest();

			if (userDetail.getUsername().contains("*") || userDetail.getUsername().contains("|")) {
				moblieUserResultBean.setMessage("Username provided is not allowed");
				moblieUserResultBean.setSuccess(false);
				throw new BadCredentialsException("Username provided is not allowed.");
			} else if (userDetail.getUsername().length() == 0) {
				moblieUserResultBean.setMessage("@@@@ Username provided is empty.");
				moblieUserResultBean.setSuccess(false);

				throw new BadCredentialsException("Username provided is empty.");
			} else if (userDetail.getPassword().length() == 0) {
				moblieUserResultBean.setMessage("@@@@ Credential provided is empty.");
				moblieUserResultBean.setSuccess(false);

				throw new BadCredentialsException("Credential provided is empty.");
			} else {/*
				JdbcTemplate jdbcTemplate = new JdbcTemplate(TrmsDataSource);
				// request.setAttribute("CURRENT_TENANT_IDENTIFIER", userDetail.getTenantId());
				userDetail1 = UserMasterDAO.loadUserByUsername(userDetail.getUsername());
				String Decrypt = CipherCrypto.Decrypt("Zjb0O9CXrmP02NBFgU7lHA==");
				Integer trmsCnt = jdbcTemplate.queryForObject(MobileAppQueryUtil.GET_EMP_CNT,
						new Object[] { userDetail.getUsername(), CipherCrypto.Encrypt(userDetail.getPassword()) },
						Integer.class);
				if (trmsCnt > 0) {
					TRMSBean = jdbcTemplate.queryForObject(MobileAppQueryUtil.GET_EMP_INFO,
							new BeanPropertyRowMapper<MobileAppBean>(MobileAppBean.class), userDetail.getUsername(),
							CipherCrypto.Encrypt(userDetail.getPassword()));

				}
				moblieUserResultBean.setUserDetail(userDetail1);
				moblieUserResultBean.setTrmsUserDetail(TRMSBean);
				moblieUserResultBean.setMessage("Successfully logged in");
				moblieUserResultBean.setSuccess(true);
				if (StringUtils.isBlank(TRMSBean.getUserId()) && StringUtils.isBlank(userDetail1.getUserId())) {
					moblieUserResultBean.setMessage("Invalid Credentials");
					moblieUserResultBean.setSuccess(false);

					throw new BadCredentialsException("Invalid Credentials");
				}
				
				 * if (StringUtils.isBlank(userDetail1.getUserId())) {
				 * moblieUserResultBean.setMessage("Username not found.");
				 * moblieUserResultBean.setSuccess(false);
				 * 
				 * throw new BadCredentialsException("Username not found."); }
				 
				if(!StringUtils.isBlank(userDetail1.getUserId())) {
				System.out.println("decrypted" + CipherCrypto.Decrypt(userDetail1.getPassword()));

				if (!(userDetail.getPassword()).equals(CipherCrypto.Decrypt(userDetail1.getPassword()))
						&& StringUtils.isBlank(TRMSBean.getUserId())) {
					moblieUserResultBean.setMessage("Wrong password");
					moblieUserResultBean.setSuccess(false);
					throw new BadCredentialsException("Wrong password.");

				}
				}

			*/}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return moblieUserResultBean;
		/* return userDetail1; */

	}
	
	@Override
	public MobileAppResultBean insertBooking(MobileAppBean bookingDetail) {
		// TODO Auto-generated method stub
		MobileAppResultBean moblieUserResultBean = new MobileAppResultBean();
		MobileAppBean BookingBean = new MobileAppBean();

		try {
			DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Integer maxBooking = jdbcTemplate.queryForObject(MobileAppQueryUtil.GET_MAX_BOOKING,Integer.class);
			maxBooking = maxBooking+1;
			String booking_no = bookingDetail.getPol()+"_"+bookingDetail.getPod()+"_"+dateFormat.format(date)+"_"+maxBooking;
			int booking_id = jdbcTemplate.update(MobileAppQueryUtil.INSERT_BOOKING,booking_no,bookingDetail.getPol(),bookingDetail.getPod(),bookingDetail.getCustomer(),bookingDetail.getDate(),bookingDetail.getVehicleNo(),bookingDetail.getDriverName(),bookingDetail.getDriverMobileNo(),bookingDetail.getContainerNo(),bookingDetail.getOpeningKm(),bookingDetail.getClosingKm(),bookingDetail.getUserId());
			BookingBean.setBookingId(booking_id);
			BookingBean.setBookingNo(booking_no);
			moblieUserResultBean.setBookingDetail(BookingBean);
			moblieUserResultBean.setMessage("Booking Inserted Successfully");
			moblieUserResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			moblieUserResultBean.setMessage("Error while inserting");
			moblieUserResultBean.setSuccess(false);
		}
		return moblieUserResultBean;
		/* return userDetail1; */

	}
	
	@Override
	public MobileAppResultBean getBookingDropDown() {
		// TODO Auto-generated method stub
		MobileAppResultBean moblieUserResultBean = new MobileAppResultBean();
		MobileAppBean locationBean = new MobileAppBean();
		MobileAppBean customerBean = new MobileAppBean();

	//	JdbcTemplate jdbcTemplate = new JdbcTemplate(TrmsDataSource);
		/*locationBean = jdbcTemplate.queryForObject(MobileAppQueryUtil.GET_LOCATION_DETAILS,
				new BeanPropertyRowMapper<MobileAppBean>(MobileAppBean.class));
		customerBean = jdbcTemplate.queryForObject(MobileAppQueryUtil.GET_CUSTOMER_DETAILS,
				new BeanPropertyRowMapper<MobileAppBean>(MobileAppBean.class));
		moblieUserResultBean.setCustomerDetail(customerBean);
		moblieUserResultBean.setLocationDetail(locationBean);
		moblieUserResultBean.setMessage("DropDown Details");
		moblieUserResultBean.setSuccess(true);*/

		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			moblieUserResultBean.setMessage("Error while fetching");
			moblieUserResultBean.setSuccess(false);
		}
		return moblieUserResultBean;
		/* return userDetail1; */

	}
	
	@Override
	public MobileAppResultBean insertExpenses(MobileAppBean ExpensesDetail) {
		// TODO Auto-generated method stub
		MobileAppResultBean moblieUserResultBean = new MobileAppResultBean();
		

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(MobileAppQueryUtil.INSERT_EXPENSES,ExpensesDetail.getBookingId(),ExpensesDetail.getExpenses(),ExpensesDetail.getExpAmount());
			moblieUserResultBean.setMessage("Expenses Inserted Successfully");
			moblieUserResultBean.setSuccess(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			moblieUserResultBean.setMessage("Error while inserting");
			moblieUserResultBean.setSuccess(false);
		}
		return moblieUserResultBean;
		/* return userDetail1; */

	}
	
	@Override
	public MobileAppResultBean getBookingDetails(String userId) {
		// TODO Auto-generated method stub
		MobileAppResultBean moblieUserResultBean = new MobileAppResultBean();
		//MobileAppBean bookingBean = new MobileAppBean();
		List<MobileAppBean> bookingBean = new ArrayList<MobileAppBean>();
		//List<MobileAppBean> ExpensesBean = new ArrayList<MobileAppBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		bookingBean = jdbcTemplate.query(MobileAppQueryUtil.GET_BOOKING_DETAILS,
				new BeanPropertyRowMapper<MobileAppBean>(MobileAppBean.class),userId);
		/*ExpensesBean = jdbcTemplate.query(MobileAppQueryUtil.GET_EXPENSES_DETAILS,
				new BeanPropertyRowMapper<MobileAppBean>(MobileAppBean.class),bookingBean.getBookingId());*/
		moblieUserResultBean.setBookingList(bookingBean);
		//moblieUserResultBean.setExpensesList(ExpensesBean);
		moblieUserResultBean.setMessage("Booking Details");
		moblieUserResultBean.setSuccess(true);

		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			moblieUserResultBean.setMessage("Error while fetching");
			moblieUserResultBean.setSuccess(false);
		}
		return moblieUserResultBean;
		/* return userDetail1; */

	}
	@Override
	public MobileAppResultBean getEditBooking(String bookingId) {
		// TODO Auto-generated method stub
		MobileAppResultBean moblieUserResultBean = new MobileAppResultBean();
		MobileAppBean bookingBean = new MobileAppBean();
		List<MobileAppBean> ExpensesBean = new ArrayList<MobileAppBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		bookingBean = jdbcTemplate.queryForObject(MobileAppQueryUtil.EDIT_BOOKING_DETAILS,
				new BeanPropertyRowMapper<MobileAppBean>(MobileAppBean.class),bookingId);
		ExpensesBean = jdbcTemplate.query(MobileAppQueryUtil.GET_EXPENSES_DETAILS,
				new BeanPropertyRowMapper<MobileAppBean>(MobileAppBean.class),bookingBean.getBookingId());
		moblieUserResultBean.setBookingDetail(bookingBean);
		moblieUserResultBean.setExpensesList(ExpensesBean);
		moblieUserResultBean.setMessage("Edit Booking Details");
		moblieUserResultBean.setSuccess(true);

		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			moblieUserResultBean.setMessage("Error while fetching");
			moblieUserResultBean.setSuccess(false);
		}
		return moblieUserResultBean;
		/* return userDetail1; */

	}
}