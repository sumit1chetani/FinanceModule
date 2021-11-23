package com.dci.tenant.finance.journalvoucher;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.dci.common.util.CommonUtil;
import com.dci.common.util.CustomException;
import com.dci.common.util.NumberstoWordsConversion;
import com.dci.tenant.user.UserDetail;


@Repository
public class JournalVoucherDAOImpl implements JournalVoucherDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(JournalVoucherDAOImpl.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	NumberstoWordsConversion wordingConversion;

	/*
	 * @Override public List<JournalVoucherDTO>
	 * getJournalVoucherList(JournalVoucherBean journalVoucherBean) throws
	 * Exception { List<JournalVoucherDTO> lJournalVoucherList = new
	 * ArrayList<>(); try { String wherecode = "";
	 * 
	 * if (journalVoucherBean.getFromDate() != null &&
	 * journalVoucherBean.getFromDate() != "" &&
	 * journalVoucherBean.getFromDate() != " ") { if (wherecode.isEmpty()) {
	 * wherecode = wherecode + "where  JH.JOURNAL_DATE>=to_date(" + "'" +
	 * journalVoucherBean.getFromDate() + "'" + ",'dd/mm/yyyy')"; } else {
	 * wherecode = wherecode + "and  JH.JOURNAL_DATE>=to_date(" + "'" +
	 * journalVoucherBean.getFromDate() + "'" + ",'dd/mm/yyyy')"; }
	 * 
	 * } if (journalVoucherBean.getToDate() != null &&
	 * journalVoucherBean.getToDate() != "") { if (wherecode.isEmpty()) {
	 * wherecode = wherecode + "where  JH.JOURNAL_DATE<=to_date(" + "'" +
	 * journalVoucherBean.getToDate() + "'" + ",'dd/mm/yyyy')"; } else {
	 * wherecode = wherecode + "and  JH.JOURNAL_DATE<=to_date(" + "'" +
	 * journalVoucherBean.getToDate() + "'" + ",'dd/mm/yyyy')"; } } if
	 * (journalVoucherBean.getJvTypeId() != 0) { if (wherecode.isEmpty()) {
	 * wherecode = wherecode + " where JH.JOURNALVOUCHER_TYPE_ID ='" +
	 * journalVoucherBean.getJvTypeId() + "'"; } else { wherecode = wherecode +
	 * " and JH.JOURNALVOUCHER_TYPE_ID ='" + journalVoucherBean.getJvTypeId() +
	 * "'"; }
	 * 
	 * }
	 * 
	 * String mainquery =
	 * "SELECT JOURNAL_NO AS jvNumber,to_char(JOURNAL_DATE,'dd/mm/yyyy') AS dataOfIssue,JOURNAL_NARRATION AS narration , JT.NAME AS jvTypeName FROM JOURNALVOUCHER_HDR  AS JH LEFT JOIN JOURNALVOUCHER_TYPE AS JT ON JT.JOURNALVOUCHER_TYPE_ID=JH.JOURNALVOUCHER_TYPE_ID order by JOURNAL_NO desc"
	 * ;
	 * 
	 * lJournalVoucherList = jdbcTemplate.query(mainquery, new
	 * BeanPropertyRowMapper<>(JournalVoucherDTO.class));
	 * 
	 * } catch (DataAccessException e) {
	 * LOGGER.error("Error in Get the Journal Voucher Header Records", e);
	 * 
	 * } return lJournalVoucherList; }
	 */

	@Override
	public List<JournalVoucherDTO> getJournalVoucherList(JournalVoucherBean journalVoucherBean) throws Exception {
		List<JournalVoucherDTO> lJournalVoucherList = new ArrayList<>();
		try {
			String wherecode = "";
			if (journalVoucherBean.getFromDate() != null && journalVoucherBean.getFromDate() != "" && journalVoucherBean.getFromDate() != " ") {
				if (wherecode.isEmpty()) {
					wherecode = wherecode + "where  JH.JOURNAL_DATE>=to_date(" + "'" + journalVoucherBean.getFromDate() + "'" + ",'dd/mm/yyyy')";
				} else {
					wherecode = wherecode + "and  JH.JOURNAL_DATE>=to_date(" + "'" + journalVoucherBean.getFromDate() + "'" + ",'dd/mm/yyyy')";
				}

			}
			if (journalVoucherBean.getToDate() != null && journalVoucherBean.getToDate() != "") {
				if (wherecode.isEmpty()) {
					wherecode = wherecode + "where  JH.JOURNAL_DATE<=to_date(" + "'" + journalVoucherBean.getToDate() + "'" + ",'dd/mm/yyyy')";
				} else {
					wherecode = wherecode + "and  JH.JOURNAL_DATE<=to_date(" + "'" + journalVoucherBean.getToDate() + "'" + ",'dd/mm/yyyy')";
				}
			}
			if (journalVoucherBean.getJvTypeId() != 0) {
				if (wherecode.isEmpty()) {
					wherecode = wherecode + " where JH.JOURNALVOUCHER_TYPE_ID ='" + journalVoucherBean.getJvTypeId() + "'";
				} else {
					wherecode = wherecode + " and JH.JOURNALVOUCHER_TYPE_ID ='" + journalVoucherBean.getJvTypeId() + "'";
				}

			}

			String mainquery = "SELECT JOURNAL_NO AS jvNumber,to_char(JOURNAL_DATE,'MM/dd/yyyy') AS dataOfIssue,JOURNAL_NARRATION AS narration , (select cost_center_name from cost_center where  cost_center_id::text = JH.cost_center) as costcenter,   JT.NAME AS jvTypeName FROM JOURNALVOUCHER_HDR  AS JH LEFT JOIN JOURNALVOUCHER_TYPE AS JT ON JT.JOURNALVOUCHER_TYPE_ID=JH.JOURNALVOUCHER_TYPE_ID " + wherecode + " order by JOURNAL_NO desc";

			lJournalVoucherList = jdbcTemplate.query(mainquery, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));
			System.out.println("szxfsdg"+mainquery);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get the Journal Voucher Header Records", e);

		}
		return lJournalVoucherList;
	}

	@Override
	public boolean saveJournalVoucherData(JournalVoucherDTO objJournalVoucherData, String userId, String companyCode) throws CustomException {
		boolean isSuccess = false;
		try {
			String journalNumber = generateJournalVoucherNumber(objJournalVoucherData);

			int iJvHdr = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_JOURNAL_VOUCHER_HEADER_MASTER, new Object[] { journalNumber, objJournalVoucherData.getDataOfIssue(), objJournalVoucherData.getNarration(), userId, companyCode, objJournalVoucherData.getJournalvoucherTypeId(), objJournalVoucherData.getCostCenter(), objJournalVoucherData.getBankCenter() });
			System.out.println(journalNumber);
			System.out.println(iJvHdr);

			objJournalVoucherData.setJvNumber(journalNumber);
			if (iJvHdr > 0) {
				isSuccess = saveJournalVoucherDetail(objJournalVoucherData);
			}

			if (isSuccess) {
				isSuccess = createGeneralLedgerForJournalVoucher(objJournalVoucherData);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Journal Voucher Header Records!", e);
		}
		return isSuccess;
	}

	private boolean createGeneralLedgerForJournalVoucher(JournalVoucherDTO objJournalVoucherData) {
		boolean flag = false;
		try {

			int iTemp = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_GENERAL_LEDGER_FOR_JV, new Object[] { objJournalVoucherData.getJvNumber(), objJournalVoucherData.getJvNumber() });
			if (iTemp > 0)
				flag = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Journal Voucher Detail Records!", e);
		}
		return flag;
	}

	private boolean saveJournalVoucherDetail(JournalVoucherDTO objJournalVoucherData) {
		boolean flag = false;
		try {
			List<JournalVoucherBean> lJVDetailList = objJournalVoucherData.getTables();
			for (JournalVoucherBean objJournalVoucherBean : lJVDetailList) {
	 int i = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.GET_COUNT_CUS, new Object[] { objJournalVoucherBean.getAccountCode() }, (Integer.class));
	 int j = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.GET_COUNT_ENT, new Object[] { objJournalVoucherBean.getAccountCode() }, (Integer.class));
if(i>0) {
	objJournalVoucherBean.setAccountCode("20000001");
}else if (j>0) {
	objJournalVoucherBean.setAccountCode("10040001");
}
				int iTemp = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_JOURNAL_VOUCHER_DTL, new Object[] { objJournalVoucherData.getJvNumber(), objJournalVoucherBean.getAccountCode(), objJournalVoucherBean.getCurrency(), objJournalVoucherBean.getExchangeRate(), objJournalVoucherBean.getTcDebitAmount(), objJournalVoucherBean.getTcCreditAmount(), objJournalVoucherBean.getNarration(), objJournalVoucherBean.getAccountCode().substring(0, 4), objJournalVoucherBean.getBcDebitAmount(), objJournalVoucherBean.getBcCreditAmount(),
						objJournalVoucherBean.getSlNo(), objJournalVoucherBean.getSubAccountCode(), objJournalVoucherBean.getEmployeeCode(), objJournalVoucherBean.getCountryCode(), objJournalVoucherBean.getCustomerCode(), objJournalVoucherBean.getSupplierCode(), objJournalVoucherBean.getDesignationCode(), objJournalVoucherBean.getCompanyCode(), objJournalVoucherBean.getCostCenter(), objJournalVoucherBean.getDepartmentCode(), objJournalVoucherBean.getPatientCode() });
				if (iTemp > 0)
					flag = true;
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Journal Voucher Detail Records!", e);
		}
		return flag;
	}

	/**
	 * get JV Info On Edit Details *************************************
	 */
	@Override
	public JournalVoucherDTO getJournalVoucherInfoOnEdit(String journalNo) throws Exception {
		JournalVoucherDTO objJournalVoucher = new JournalVoucherDTO();
		try {
			objJournalVoucher = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.GET_JOURNAL_VOUCHER_HDR_ON_EDIT_MASTER, new Object[] { journalNo }, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));
			List<JournalVoucherBean> lJvDtlList = new ArrayList<>();

			lJvDtlList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_JOURNAL_VOUCHER_DTL_ON_EDIT, new Object[] { journalNo }, new BeanPropertyRowMapper<>(JournalVoucherBean.class));
			objJournalVoucher.setTables(lJvDtlList);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get JV Info On Edit", e);
		}

		return objJournalVoucher;
	}

	@Override
	public boolean updateJournalVoucherData(JournalVoucherDTO objJournalVoucherData, String userId, String companyCode) throws CustomException {
		boolean isUpdated = false;
		try {
			Date journalDate = CommonUtil.convertSqlDateFormat(objJournalVoucherData.getDataOfIssue());
			int iJvHdr = jdbcTemplate.update(JournalVoucherQueryUtil.UPDATE_JOURNAL_VOUCHER_HEADER_MASTER, new Object[] { journalDate, objJournalVoucherData.getNarration(), userId, companyCode, objJournalVoucherData.getCostcenter(), objJournalVoucherData.getJournalvoucherTypeId(), objJournalVoucherData.getBankCenter(), objJournalVoucherData.getJvNumber() });

			if (iJvHdr > 0)
				isUpdated = updateJournalVoucherDetail(objJournalVoucherData);

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Journal Voucher Header Records!", e);
		}
		return isUpdated;
	}

	private boolean updateJournalVoucherDetail(JournalVoucherDTO objJournalVoucherData) {
		boolean isSuccess = false;
		try {
			int rowDetail = jdbcTemplate.update(JournalVoucherQueryUtil.DELETE_JOURNAL_VOUCHER_DETAIL_INFO, objJournalVoucherData.getJvNumber());
			int rowGL = jdbcTemplate.update(JournalVoucherQueryUtil.DELETE_GENERAL_LEDGER_INFO, objJournalVoucherData.getJvNumber());
			// if (rowDetail > 0 && rowGL > 0) {
			if (rowDetail > 0) {

				isSuccess = saveJournalVoucherDetail(objJournalVoucherData);
				if (isSuccess) {
					isSuccess = createGeneralLedgerForJournalVoucher(objJournalVoucherData);
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Update", e);
		}

		return isSuccess;
	}

	@Override
	public boolean deleteJournalVoucherInfo(String jvNumber) throws Exception {
		boolean isDeleted = false;
		try {
			int jvHdrDel = 0;
			int jvDtlDel = jdbcTemplate.update(JournalVoucherQueryUtil.DELETE_JOURNAL_VOUCHER_DETAIL_INFO, jvNumber);
			int rowGL = jdbcTemplate.update(JournalVoucherQueryUtil.DELETE_GENERAL_LEDGER_INFO, jvNumber);

			// if (jvDtlDel > 0 && rowGL > 0)
			jvHdrDel = jdbcTemplate.update(JournalVoucherQueryUtil.DELETE_JOURNAL_VOUCHER_HEADER_INFO, jvNumber);

			if (jvHdrDel > 0)
				isDeleted = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete Journal Voucher Records", e);
		}
		return isDeleted;
	}

	public String generateJournalVoucherNumber(JournalVoucherDTO bean) throws CustomException {
		String journalNumber = null;
		String query;
		String appendWithYear = "", appendWithJVNo = "";
		DateFormat formatter;
		String sCurrentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

		formatter = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date;
		try {
			date = formatter.parse(bean.getDataOfIssue());

			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String Gidate = df.format(date);
			sCurrentYear = Gidate.substring(2);

			appendWithJVNo = "JV" + sCurrentYear + "00001";
			appendWithYear = "JV" + sCurrentYear + "%";

			List<Map<String, Object>> rowJVNo = jdbcTemplate.queryForList(JournalVoucherQueryUtil.GET_JOURNAL_NO_AUTOGENERATE, new Object[] { appendWithJVNo, appendWithYear });
			for (Map row : rowJVNo) {
				journalNumber = (String) row.get("JOURNAL_NO");
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get JV Number", e);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return journalNumber;
	}

	public String generateJournalVoucherNumber() throws CustomException {
		String journalNumber = null;
		String query;
		String appendWithYear = "", appendWithJVNo = "";
		DateFormat formatter;
		String sCurrentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

		try {
			sCurrentYear = sCurrentYear.substring(2);

			appendWithJVNo = "JV" + sCurrentYear + "00001";
			appendWithYear = "JV" + sCurrentYear + "%";

			List<Map<String, Object>> rowJVNo = jdbcTemplate.queryForList(JournalVoucherQueryUtil.GET_JOURNAL_NO_AUTOGENERATE, new Object[] { appendWithJVNo, appendWithYear });
			for (Map row : rowJVNo) {
				journalNumber = (String) row.get("JOURNAL_NO");
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get JV Number", e);
		}

		return journalNumber;
	}

	public BigDecimal generateSerialNumber(String jvNumber) throws CustomException {

		BigDecimal serialNumber;

		try {

			Map slNumber = jdbcTemplate.queryForMap(JournalVoucherQueryUtil.GET_SERIAL_NUMBER + "'" + jvNumber + "'");

			serialNumber = (BigDecimal) slNumber.get("SLNum");

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
			throw new CustomException(JournalVoucherMsgUtil.ERROR_LIST);
		}

		return serialNumber;
	}
	
	@Override
	public List<JournalVoucherDTO> getLedgerList(){
		List<JournalVoucherDTO> accountList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			//accountList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_LEDGER_LIST, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));
			accountList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_SUBother_HEAD_LIST, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_LEDGER_LIST", e);
		}
		return accountList;
	}

	@Override
	public List<JournalVoucherDTO> getAccountHeadList() {
		List<JournalVoucherDTO> accountList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			accountList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_ACCOUNT_HEAD_LIST, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_ACCOUNT_HEAD_LIST", e);
		}
		return accountList;
	}

	@Override
	public List<JournalVoucherDTO> getSubAcctHeadList() {
		List<JournalVoucherDTO> accountList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			accountList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_SUBACCOUNT_HEAD_LIST, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_ACCOUNT_HEAD_LIST", e);
		}
		return accountList;
	}

	@Override
	public List<JournalVoucherDTO> getSubAcctHeadVendorList() {
		List<JournalVoucherDTO> accountList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			accountList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_SUBVENDORACCOUNT_HEAD_LIST, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_ACCOUNT_HEAD_LIST", e);
		}
		return accountList;
	}

	@Override
	public List<JournalVoucherDTO> getAccountHeadMapList() {
		List<JournalVoucherDTO> accountList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			accountList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_ACCOUNT_HEAD_Map_LIST, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_ACCOUNT_HEAD_LIST", e);
		}
		return accountList;
	}

	@Override
	public List<JournalVoucherDTO> getAccountHeadCashMapList() {
		List<JournalVoucherDTO> accountList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			accountList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_ACCOUNT_HEAD_CASH_LIST, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_ACCOUNT_HEAD_LIST", e);
		}
		return accountList;
	}

	@Override
	public List<JournalVoucherDTO> getCurrencyList() {
		List<JournalVoucherDTO> currencyList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			currencyList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_CURRENCY_LIST, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_ACCOUNT_HEAD_LIST", e);
		}
		return currencyList;
	}

	@Override
	public List<JournalVoucherDTO> getCompanyList() {
		List<JournalVoucherDTO> companyList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			companyList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_COMPANY_LIST, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_ACCOUNT_HEAD_LIST", e);
		}
		return companyList;
	}

	@Override
	public JournalVoucherDTO getJournalVoucherforPrint(String jvNumber) {
		JournalVoucherDTO objJournalVoucher = new JournalVoucherDTO();
		List<JournalVoucherBean> lDtlList = new ArrayList<>();
		double totalTcDebitAmt = 0, totalBcDebitAmt = 0, totalTcCreditAmt = 0, totalBcCreditAmt = 0, dTcTotalAmount = 0, dBcTotalAmount = 0;
		try {
			objJournalVoucher = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.GET_JOURNAL_VOUCHER_HDR_ON_PRINT, new Object[] { jvNumber }, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));
			if (objJournalVoucher.getCompanyCode().equalsIgnoreCase("C0002")) {
				objJournalVoucher.setCompany("Dental Council of India");
			} else {
				objJournalVoucher.setCompany("Dental Council of India");
			}
			lDtlList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_JOURNAL_VOUCHER_DTL_ON_PRINT, new Object[] { jvNumber }, new BeanPropertyRowMapper<>(JournalVoucherBean.class));

			for (JournalVoucherBean objBean : lDtlList) {
				totalTcDebitAmt = totalTcDebitAmt + objBean.getTcDebitAmount();
				totalBcDebitAmt = objBean.getTcAmount() + objBean.getBcAmount();
				totalTcCreditAmt = totalTcCreditAmt + objBean.getTcCreditAmount();
				totalBcCreditAmt = totalBcCreditAmt + objBean.getBcCreditAmount();
				dTcTotalAmount = dTcTotalAmount + objBean.getTcAmount();
				dBcTotalAmount = dBcTotalAmount + objBean.getBcAmount();
			}

			int total = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.GETTOTAL, Integer.class ,jvNumber );

			int total1 = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.GETTOTAL1, Integer.class ,jvNumber );

			objJournalVoucher.setTables(lDtlList);
			objJournalVoucher.setTotalTcDebitAmt(Math.round(totalTcDebitAmt * 100.0) / 100.0);
			objJournalVoucher.setTotalBcDebitAmt(Math.round(totalBcDebitAmt * 100.0) / 100.0);
			objJournalVoucher.setTotalTcCreditAmt(Math.round(totalTcCreditAmt * 100.0) / 100.0);
			objJournalVoucher.setTotalBcCreditAmt(Math.round(totalBcCreditAmt * 100.0) / 100.0);
			objJournalVoucher.setBcAmount(objJournalVoucher.getTotalBcDebitAmt() - objJournalVoucher.getTotalBcCreditAmt());
			objJournalVoucher.setTcAmount(objJournalVoucher.getTotalTcDebitAmt() - objJournalVoucher.getTotalTcCreditAmt());
			objJournalVoucher.setTotal(total);
			objJournalVoucher.setTotal1(total1);

			
			String Type = "Rupees";
			objJournalVoucher.setCurrencyType(Type);
			String amountInWords = wordingConversion.convertToIndianCurrency(String.valueOf(Math.round(objJournalVoucher.getTotal())));
			amountInWords = "Rupees" + "  " + amountInWords;
			objJournalVoucher.setAmountinWords(amountInWords);
			System.out.println(objJournalVoucher.getCurrencyType() + "  " + wordingConversion.convertToIndianCurrency(String.valueOf(objJournalVoucher.getTotal())));

			String preparedBy = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.gretuser, new Object[] { jvNumber }, String.class);
			objJournalVoucher.setPreparedBy(preparedBy);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get JV Info On Edit", e);
		}

		return objJournalVoucher;
	}

	// 3 characters
	@Override
	public List<JournalVoucherBean> getjournalNo(String jvcode) {

		List<JournalVoucherBean> lQuotationBean = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String query = JournalVoucherQueryUtil.GET_JVNO;
			query = query + "  where JOURNAL_NO like '%" + checkData(jvcode).toUpperCase() + "%' limit 50";

			System.out.println("query" + query);

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

			for (Map row : rows) {
				JournalVoucherBean bean = new JournalVoucherBean();
				bean.setId((String) row.get("jvNumber"));
				bean.setText((String) row.get("jvNumber"));
				bean.setJournalNo((String) row.get("jvNumber"));
				lQuotationBean.add(bean);

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getQuotation", e);
		}
		return lQuotationBean;
	}

	public String checkData(String value) {
		try {
			value = value.trim() == null || value.trim().equals("null") || value == "null" || value.trim().isEmpty() ? "" : value;
		} catch (Exception e) {

			return "";
		}

		return value;
	}

	@Override
	public boolean getloggedcompany(String closingDate, String formCode) {
		// TODO Auto-generated method stub
		boolean checkDate = false;
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String companyCode = userDetails.getCompanyCode();
			/*
			 * if(companyCode.equals("C0001")){ checkDate = false; }else{
			 */

			Integer userRightCount = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.CHECK_YEAR_CLOSING_RIGHTS, new Object[] { formCode, userDetails.getUserId() }, Integer.class);

			if (userRightCount == 0) {

				Integer rowCount = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.CLOSING_DATE, new Object[] { companyCode, closingDate }, Integer.class);
				if (rowCount != 0)
					checkDate = true;
				else
					checkDate = false;
			}
			// }
		} catch (DataAccessException e) {
			LOGGER.error("", e);
		}
		return checkDate;
	}

	@Override
	public String reversePayment(String voucherNo, String createdDate) {
		String sReceiptStatus = "";
		String sMessage = "";
		try {
			List<Map<String, Object>> RowData = jdbcTemplate.queryForList(JournalVoucherQueryUtil.GET_PAYMENT_STATUS, new Object[] { voucherNo });
			for (Map<String, Object> row : RowData) {
				sReceiptStatus = (String) row.get("reverseJV");
			}

			if ("N".equalsIgnoreCase(sReceiptStatus)) {
				reversePaymentRecord(voucherNo, createdDate);
				sMessage = "Journal Voucher Reversed sucessfully";
			} else {
				sMessage = "Journal Voucher is already Reversed !..";
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Reverse Payment List", e);
		}
		return sMessage;
	}

	private void reversePaymentRecord(String voucherNo, String createdDate) {
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			String reverseBBStatus = "Y";
			jdbcTemplate.update(JournalVoucherQueryUtil.UPDATE_JV_HDR_STATUS, new Object[] { reverseBBStatus, voucherNo });

			String journalNumber = generateJournalVoucherNumber();

			int count = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.REVERSE_JV, new Object[] { voucherNo, createdDate, userDetails.getUserId(), journalNumber }, Integer.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<JournalVoucherDTO> getSubcollHeadList() {
		List<JournalVoucherDTO> accountList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			accountList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_SUBcollege_HEAD_LIST, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_ACCOUNT_HEAD_LIST", e);
		}
		return accountList;
	}

	@Override
	public List<JournalVoucherDTO> getSubotherHeadList() {
		List<JournalVoucherDTO> accountList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			accountList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_SUBother_HEAD_LIST, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_ACCOUNT_HEAD_LIST", e);
		}
		return accountList;
	}

	@Override
	public List<JournalVoucherDTO> getvendorList() {
		List<JournalVoucherDTO> accountList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			accountList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_SUBACCOUNT_vendor_LIST, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_ACCOUNT_HEAD_LIST", e);
		}
		return accountList;
	}
	
	
	@Override
	public List<JournalVoucherDTO> getcpotherList() {
		List<JournalVoucherDTO> accountList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			accountList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_SUBACCOUNT_other_LIST, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_ACCOUNT_HEAD_LIST", e);
		}
		return accountList;
	}

	@Override
	public List<JournalVoucherDTO> getAccountHeadNewList() {
		List<JournalVoucherDTO> accountList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			accountList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_ACCOUNT_HEAD_LIST_ICASS, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_ACCOUNT_HEAD_LIST", e);
		}
		return accountList;
	}

	@Override
	public List<JournalVoucherDTO> getAccountHeadPayList() {
		List<JournalVoucherDTO> accountList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			accountList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_ACCOUNT_HEAD_LIST_LE, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_ACCOUNT_HEAD_LIST", e);
		}
		return accountList;
	
	}

	@Override
	public List<JournalVoucherDTO> getcpothercusList() {
		List<JournalVoucherDTO> accountList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			//accountList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_SUBACCOUNT_other_cust_LIST, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));
			accountList = jdbcTemplate.query(JournalVoucherQueryUtil.GET_SUBcollege_HEAD_LIST, new BeanPropertyRowMapper<>(JournalVoucherDTO.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_ACCOUNT_HEAD_LIST", e);
		}
		return accountList;
	}

}
