package com.dci.tenant.finance.chqPresentation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.tenant.user.UserDetail;

@Repository
public class ChqPresentationDAOImpl implements ChqPresentationDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(ChqPresentationDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<ChqPresentationBean> getPresentationHdrList(int limit, int offset) {

		List<ChqPresentationBean> lJVAHdrList = new ArrayList<>();
		try {

			lJVAHdrList = jdbcTemplate.query(ChqPresentationQueryUtil.GET_PRESNTATION_HDR_LIST, new BeanPropertyRowMapper<>(ChqPresentationBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in JV Swap Accounting List", e);
		}
		return lJVAHdrList;
	}

	@Override
	public boolean savePresentation(ChqPresentationBean chqPresentationBean) {
		boolean success = false;
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId(), prCode = generatePresentationCode();
			int saved = jdbcTemplate.update(ChqPresentationQueryUtil.SAVE_PRESENTATION, new Object[] { prCode, chqPresentationBean.getCustomerCode(), chqPresentationBean.getChqNo(), chqPresentationBean.getChqDate(), chqPresentationBean.getChqAmnt(), "YES", userId, chqPresentationBean.getCompanyCode(), chqPresentationBean.getPresentDate(), chqPresentationBean.getDrwnBank(), chqPresentationBean.getDepositBank(), chqPresentationBean.getChqRcvdDate() });

			if (saved > 0)
				success = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Save Presentation", e);
		}
		return success;
	}

	private String generatePresentationCode() {
		// TODO Auto-generated method stub
		String prCode = "";
		try {
			prCode = jdbcTemplate.queryForObject(ChqPresentationQueryUtil.PRESENTATION_CODE, String.class);
		} catch (DataAccessException e) {
			LOGGER.error("Error in prCode Generation", e);
		}
		return prCode;
	}

	@Override
	public List<ChqPresentationBean> getRealisationList(int limit, int offset) {

		List<ChqPresentationBean> lJVAHdrList = new ArrayList<>();
		try {

			lJVAHdrList = jdbcTemplate.query(ChqPresentationQueryUtil.GET_REALISATION_HDR_LIST, new BeanPropertyRowMapper<>(ChqPresentationBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in JV Realisation List", e);
		}
		return lJVAHdrList;
	}

	@Override
	public List<ChqPresentationBean> getchequelist() {

		List<ChqPresentationBean> lPresentationList = new ArrayList<>();
		try {
			String query = "select * from customer_list";
			lPresentationList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ChqPresentationBean.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lPresentationList;

	}

	@Override
	public List<ChqPresentationBean> getPresentationList() {

		List<ChqPresentationBean> lPresentationList = new ArrayList<>();
		try {
			String query = "select * from presentation_list";
			lPresentationList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ChqPresentationBean.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lPresentationList;

	}

	@Override
	public boolean saveRealisation(ChqPresentationBean chqPresentationBean) {
		boolean success = false;
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId(), prCode = generatePresentationCode();

			int saved = jdbcTemplate.update(ChqPresentationQueryUtil.SAVE_REALISATION, new Object[] { chqPresentationBean.getStatus(), chqPresentationBean.getRealisedDate(), userId, chqPresentationBean.getPrCode() });

			if (saved > 0)
				success = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Save Presentation", e);
		}
		return success;
	}

	@Override
	public ChqPresentationBean getCreditNoteForEdit(String prCode) {
		ChqPresentationBean bean = new ChqPresentationBean();
		try {
			String query = "select PR_ID prCode,CUSTOMER customerCode," + "entity_name customerName,CHEQUE_NO chqNo," + "to_char(CHEQUE_DT,'dd/mm/yyyy') chqDate,AMOUNT chqAmnt," + " STATUS status, to_char(PRESENT_DT,'dd/mm/yyyy') presentDate, " + "to_char(REALISED_DT,'dd/mm/yyyy') realisedDate," + "PR_COMPANY_CODE companyCode,DRAWN_BANK drwnBank,DEPOSIT_BANK" + " depositBank," + "to_char(CHQ_RECIVED_DATE,'dd/mm/yyyy') chqRcvdDate" + " from PRESENTATION_REALISATION left join "
					+ "customer_entity e on e.customer_acct_code::text=PRESENTATION_REALISATION.CUSTOMER    where PR_ID =?";

			bean = jdbcTemplate.queryForObject(query, new Object[] { prCode }, new BeanPropertyRowMapper<>(ChqPresentationBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Debit Note Records!", e);
		}

		return bean;
	}

	public List<ChqPresentationBean> getCompanyList() {
		List<ChqPresentationBean> companyList = new ArrayList<>();
		try {
			companyList = jdbcTemplate.query(ChqPresentationQueryUtil.sCompanyDropDown, new BeanPropertyRowMapper<>(ChqPresentationBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return companyList;

	}

	/*
	 * public List<ChqPresentationBean> getCustomerList() {
	 * List<ChqPresentationBean> lCustomerList = new
	 * ArrayList<ChqPresentationBean>(); try { lCustomerList =
	 * jdbcTemplate.query(ChqPresentationQueryUtil.GETCUSTOMERLIST, new
	 * BeanPropertyRowMapper<ChqPresentationBean>(ChqPresentationBean.class));
	 * 
	 * } catch (DataAccessException e) { LOGGER.error("Error in Customer LIST", e);
	 * } return lCustomerList; }
	 */

	@Override
	public boolean updatePresentation(ChqPresentationBean chqPresentationBean) {
		boolean success = false;
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();

			int saved = jdbcTemplate.update(ChqPresentationQueryUtil.UPDATE_PRESENTATION, new Object[] { chqPresentationBean.getCustomerCode(), chqPresentationBean.getChqNo(), chqPresentationBean.getChqDate(), chqPresentationBean.getChqAmnt(), userId, chqPresentationBean.getPresentDate(), chqPresentationBean.getCompanyCode(), chqPresentationBean.getDrwnBank(), chqPresentationBean.getDepositBank(), chqPresentationBean.getChqRcvdDate(), chqPresentationBean.getPrCode() });

			if (saved > 0)
				success = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Save Presentation", e);
		}
		return success;
	}

	@Override
	public boolean deletePresentation(String prCode) {
		boolean issucces = false;
		int value = 0, valueDtl = 0;
		try {
			value = jdbcTemplate.update(ChqPresentationQueryUtil.sDeletePresentation, prCode);

			if (value > 0) {
				issucces = true;
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete", e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return issucces;

	}

	@Override
	public List<ChqPresentationBean> getPresentationListEdit() {

		List<ChqPresentationBean> lPresentationList = new ArrayList<>();
		try {
			lPresentationList = jdbcTemplate.query(ChqPresentationQueryUtil.PRESENTATION_COMBO_EDIT, new BeanPropertyRowMapper<>(ChqPresentationBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in PresentationList LIST", e);
		}
		return lPresentationList;

	}

	@Override
	public List<ChqPresentationBean> getChqStatusRprtList(String customer, String company) {
		List<ChqPresentationBean> lJVAHdrList = new ArrayList<>();
		try {

			String query = "select cheque_no chqNo,to_char(cheque_dt,'dd/mm/yyyy') chqDate,amount chqAmnt,to_char(chq_recived_date,'dd/mm/yyyy') chqRcvdDate,presented isPresented,to_char(present_dt,'dd/mm/yyyy') presentDate,deposit_bank depositBank,to_char(realised_dt,'dd/mm/yyyy') realisedDate,pr.status status,entity_name customerName,cm.company_name companyName,case when realised_dt is null then 'NO' else  'YES' end isRealised  from presentation_realisation pr inner join entity mm on mm.customer_acct_code = pr.customer left join company_master cm on cm.company_code = PR_COMPANY_CODE ";
			if (!customer.equalsIgnoreCase("") && !company.equalsIgnoreCase("")) {
				query += "where customer= '" + customer + "' and pr_company_code = '" + company + "' order by cheque_no";
			} else if (!customer.equalsIgnoreCase("")) {
				query += "where customer = '" + customer + "' order by cheque_no";
			} else if (!company.equalsIgnoreCase("")) {
				query += "where pr_company_code = '" + company + "' order by cheque_no";
			} else {
				query += "order by cheque_no";
			}

			lJVAHdrList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ChqPresentationBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Chq Report List", e);
		}
		return lJVAHdrList;
	}
}
