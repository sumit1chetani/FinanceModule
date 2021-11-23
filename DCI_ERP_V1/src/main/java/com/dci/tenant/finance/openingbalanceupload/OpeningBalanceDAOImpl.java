package com.dci.tenant.finance.openingbalanceupload;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.dci.common.util.AccountsConstants;
import com.dci.common.util.CommonUtilityQueryUtil;
import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.finance.cashbankpayment.CashBankPaymentQueryUtil;
import com.dci.tenant.finance.cashbankreceipt.CashBankReceiptQueryUtil;
import com.dci.tenant.finance.journalvoucher.JournalVoucherBean;
import com.dci.tenant.finance.journalvoucher.JournalVoucherDTO;
import com.dci.tenant.finance.journalvoucher.JournalVoucherQueryUtil;
import com.dci.tenant.finance.purchaseInvoice.PurchaseInvoiceQueryUtil;
import com.dci.tenant.user.UserDetail;

@Repository
public class OpeningBalanceDAOImpl implements OpeningBalanceDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(OpeningBalanceDAOImpl.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;

	@Override
	public List<OpeningBalanceBean> getBranchList() throws Exception {
		List<OpeningBalanceBean> BranchList = new ArrayList<>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			BranchList = jdbcTemplate.query(OpeningBalanceQueryUtil.GET_OpeningBalance_LIST, new BeanPropertyRowMapper<>(OpeningBalanceBean.class));
			if (BranchList.size() > 0)
				/*
				 * for (int i = 0; i < BranchList.size(); i++) { if
				 * (BranchList.get(i).getTcAmount() == 0.0 ||
				 * BranchList.get(i).getTcAmount() == 0) {
				 * BranchList.get(i).setTcAmount1("0.0"); } else { DecimalFormat
				 * IndianCurrencyFormat = new DecimalFormat("#,##,##,###.00");
				 * String value =
				 * IndianCurrencyFormat.format(BranchList.get(i).getTcAmount());
				 * BranchList.get(i).setTcAmount1(value); } }
				 */
				for (int i = 0; i < BranchList.size(); i++) {
					if (BranchList.get(i).getBcAmount() == 0.0 || BranchList.get(i).getBcAmount() == 0) {
						BranchList.get(i).setBcAmount1("0.0");
					} else {
						DecimalFormat IndianCurrencyFormat = new DecimalFormat("#,##,##,###.00");
						String value = IndianCurrencyFormat.format(BranchList.get(i).getBcAmount());
						BranchList.get(i).setBcAmount1(value);
					}
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return BranchList;
	}

	@Override
	public List<OpeningBalanceBean> getBranchList1(OpeningBalanceBean bean) throws Exception {
		List<OpeningBalanceBean> BranchList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			BranchList = jdbcTemplate.query(OpeningBalanceQueryUtil.GET_OpeningBalance_LIST_COMPANY_LIST, new Object[] {}, new BeanPropertyRowMapper<>(OpeningBalanceBean.class));
			if (BranchList.size() > 0)
				for (int i = 0; i < BranchList.size(); i++) {
					if (BranchList.get(i).getTcAmount() == 0.0 || BranchList.get(i).getTcAmount() == 0) {
						BranchList.get(i).setTcAmount1("0.0");
					} else {
						DecimalFormat IndianCurrencyFormat = new DecimalFormat("#,##,##,###.00");
						String value = IndianCurrencyFormat.format(BranchList.get(i).getTcAmount());
						BranchList.get(i).setTcAmount1(value);
					}
				}
			for (int i = 0; i < BranchList.size(); i++) {
				if (BranchList.get(i).getBcAmount() == 0.0 || BranchList.get(i).getBcAmount() == 0) {
					BranchList.get(i).setBcAmount1("0.0");
				} else {
					DecimalFormat IndianCurrencyFormat = new DecimalFormat("#,##,##,###.00");
					String value = IndianCurrencyFormat.format(BranchList.get(i).getBcAmount());
					BranchList.get(i).setBcAmount1(value);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return BranchList;
	}

	@Override
	public OpeningBalanceResultBean getdropList() throws Exception {
		OpeningBalanceResultBean ResultBean = new OpeningBalanceResultBean();
		List<SelectivityBean> customerList = new ArrayList<>();
		List<SelectivityBean> companyList = new ArrayList<>();
		List<SelectivityBean> currencyList = new ArrayList<>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// currencyList =
			// jdbcTemplate.query(OpeningBalanceQueryUtil.GETCURRENCY, new
			// BeanPropertyRowMapper<>(SelectivityBean.class));
			// companyList =
			// jdbcTemplate.query(OpeningBalanceQueryUtil.GETCOMPANY, new
			// BeanPropertyRowMapper<>(SelectivityBean.class));
			customerList = jdbcTemplate.query(OpeningBalanceQueryUtil.GETCUSTOMER, new BeanPropertyRowMapper<>(SelectivityBean.class));
			;
			// ResultBean.setCurrecncyList(currencyList);
			// ResultBean.setCompanyList(companyList);
			ResultBean.setCustomerList(customerList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultBean;
	}

	@Override
	public OpeningBalanceResultBean save(OpeningBalanceBean mablBean) {
		OpeningBalanceResultBean ResultBean = new OpeningBalanceResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		OpeningBalanceBean Bean = new OpeningBalanceBean();
		String name;
		String name1;
		Integer count = 0;
		// int test=mablBean.getCompanyId();
		try {
			// int cust=mablBean.getCustomer();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (mablBean.getCustomer() == null || mablBean.getCustomer().isEmpty()) {
				jdbcTemplate.update(OpeningBalanceQueryUtil.SAVE_NEW, mablBean.getInvoiceNo(), mablBean.getInvoiceDate(), mablBean.getBcAmount(), mablBean.getTcAmount(), mablBean.getCurrency(), mablBean.getExchangeRate(), mablBean.getCustomer(), mablBean.getCompanyId(), mablBean.getSundryStatus(), mablBean.getAccountHead(), mablBean.getFinYear(), userDetails.getUserId());

			} else {
				name = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.Get_Account_Code, String.class, mablBean.getCustomer(), mablBean.getCustomer());
				name1 = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.CUSTOMER, String.class, mablBean.getCustomer(), mablBean.getCustomer());
				jdbcTemplate.update(OpeningBalanceQueryUtil.SAVE, mablBean.getInvoiceNo(), mablBean.getInvoiceDate(), mablBean.getBcAmount(), mablBean.getTcAmount(), mablBean.getCurrency(), mablBean.getExchangeRate(), name, name, mablBean.getCustomer(), name1, mablBean.getCompanyId(), mablBean.getSundryStatus(), mablBean.getAccountHead(), name, mablBean.getFinYear(), userDetails.getUserId());

			}
			// if(mablBean.getSubAccount() != null && mablBean.getSubAccount()
			// != ""){
			count = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.Get_Count_With_Sub_Group_Code, Integer.class, mablBean.getCompanyId(), mablBean.getAccountHead(), mablBean.getSubAccount());
			// }
			// else{
			// count=jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.Get_Count_WithOut_Sub_Group_Code,Integer.class,mablBean.getCompanyId(),mablBean.getAccountHead());
			//
			// }

			if (count > 0) {
				String jvNumb = "";
				if (mablBean.getSubAccount() != null && mablBean.getSubAccount() != "") {
					jvNumb = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.Get_JVNo_With_Sub_Group_Code, String.class, mablBean.getCompanyId(), mablBean.getAccountHead(), mablBean.getSubAccount());
				} else {
					jvNumb = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.Get_JVNo_WithOut_Sub_Group_Code, String.class, mablBean.getCompanyId(), mablBean.getAccountHead());

				}

				JournalVoucherBean objJournalVoucherBean = new JournalVoucherBean();
				boolean isSuccess = false;
				JournalVoucherDTO objJournalVoucherData = new JournalVoucherDTO();
				objJournalVoucherBean.setCompanyCode(mablBean.getCompanyId());
				// objJournalVoucherBean.setj();

				objJournalVoucherData.setOpeningBalance(true);
				objJournalVoucherData.setJvNumber(jvNumb);
				if(mablBean.getTcAmount()!=null)
				objJournalVoucherData.setTotalTcCreditAmt(mablBean.getTcAmount());
				objJournalVoucherData.setTotalBcCreditAmt(mablBean.getBcAmount());
				objJournalVoucherData.setDataOfIssue(mablBean.getInvoiceDate());
				objJournalVoucherData.setTotalbcCredit(mablBean.getBcAmount());
				objJournalVoucherData.setExchangeRate(mablBean.getExchangeRate());
				objJournalVoucherData.setNarration("Opening Balance Transfer entries as on 31/03/2018");
				boolean isUpdated = false;

				String sRefNo = getRefernce(objJournalVoucherBean.getCompanyCode(), jvNumb, mablBean.getInvoiceDate());
				List<JournalVoucherBean> tables = new ArrayList<>();
				objJournalVoucherBean.setCompanyCode(mablBean.getCompanyId());
				// objJournalVoucherBean.setj();

				objJournalVoucherBean.setOpeningBalance(true);
				objJournalVoucherBean.setJournalNo(jvNumb);
				objJournalVoucherBean.setTcCreditAmount(mablBean.getTcAmount());
				objJournalVoucherBean.setBcCreditAmount(mablBean.getBcAmount());
				objJournalVoucherBean.setCurrency(mablBean.getCurrency());
				objJournalVoucherBean.setExchangeRate(mablBean.getExchangeRate());
				objJournalVoucherBean.setNarration("Opening Balance Transfer entries as on 31/03/2018");
				objJournalVoucherBean.setAccountCode(mablBean.getAccountHead());
				// objJournalVoucherBean.setSubAccountCode(name);
				objJournalVoucherBean.setCustomerCode(mablBean.getCustomer());
				objJournalVoucherBean.setCustomerCode(sRefNo);
				tables.add(objJournalVoucherBean);
				objJournalVoucherData.setTables(tables);

				// if(objJournalVoucherData.getTotalbcDebit()==objJournalVoucherData.getTotalbcCredit()){

				int iJvHdr = jdbcTemplate.update(JournalVoucherQueryUtil.UPDATE_SAVE_JOURNAL_VOUCHER_HEADER, new Object[] { objJournalVoucherData.getDataOfIssue(), objJournalVoucherData.getNarration(), userDetails.getUserId(), objJournalVoucherBean.getCompanyCode(), objJournalVoucherData.getOpeningBalance(), objJournalVoucherData.getJvNumber() });

				if (iJvHdr > 0) {
					isUpdated = updateSaveJournalVoucherDetail(objJournalVoucherData, userDetails.getUserId());

				}
				// }
				// }
			} else {
				JournalVoucherBean objJournalVoucherBean = new JournalVoucherBean();
				boolean isSuccess = false;
				JournalVoucherDTO objJournalVoucherData = new JournalVoucherDTO();
				try {
					objJournalVoucherBean.setCompanyCode(mablBean.getCompanyId());
					objJournalVoucherData.setDataOfIssue(mablBean.getInvoiceDate());
					String journalNumber = generateJournalNumber_New(objJournalVoucherBean.getCompanyCode(), objJournalVoucherData.getDataOfIssue());

					objJournalVoucherData.setOpeningBalance(true);
					objJournalVoucherData.setJvNumber(journalNumber);

					objJournalVoucherData.setTotalTcCreditAmt(mablBean.getTcAmount());
					objJournalVoucherData.setTotalBcCreditAmt(mablBean.getBcAmount());

					objJournalVoucherData.setTotalbcCredit(mablBean.getBcAmount());
					objJournalVoucherData.setExchangeRate(mablBean.getExchangeRate());
					objJournalVoucherData.setNarration("Opening Balance Transfer entries as on 31/03/2018");
					boolean isUpdated = false;

					String sRefNo = getRefernce(objJournalVoucherBean.getCompanyCode(), journalNumber, mablBean.getInvoiceDate());
					List<JournalVoucherBean> tables = new ArrayList<>();
					objJournalVoucherBean.setCompanyCode(mablBean.getCompanyId());
					// objJournalVoucherBean.setj();

					objJournalVoucherBean.setOpeningBalance(true);
					objJournalVoucherBean.setJournalNo(journalNumber);
					objJournalVoucherBean.setTcCreditAmount(mablBean.getTcAmount());
					objJournalVoucherBean.setBcCreditAmount(mablBean.getBcAmount());
					objJournalVoucherBean.setCurrency(mablBean.getCurrency());
					objJournalVoucherBean.setExchangeRate(mablBean.getExchangeRate());
					objJournalVoucherBean.setNarration("Opening Balance Transfer entries as on 31/03/2018");
					objJournalVoucherBean.setAccountCode(mablBean.getAccountHead());
					// objJournalVoucherBean.setSubAccountCode(name);
					objJournalVoucherBean.setCustomerCode(mablBean.getCustomer());
					objJournalVoucherBean.setCustomerCode(sRefNo);
					tables.add(objJournalVoucherBean);
					objJournalVoucherData.setTables(tables);

					String sCompanyCode = "";
					int index = 0;
					boolean isInterCompanyTransaction = false;
					int iCounter = 0;
					int iJvHdr = jdbcTemplate.update(JournalVoucherQueryUtil.ADD_JOURNAL_VOUCHER_HEADER, new Object[] { journalNumber, objJournalVoucherData.getDataOfIssue(), objJournalVoucherData.getNarration(), userDetails.getUserId(), objJournalVoucherBean.getCompanyCode(), sRefNo, objJournalVoucherBean.getOpeningBalance() });
					// for (JournalVoucherBean objJournalVoucherBean :
					// lJVDetailList) {
					iCounter++;

					if (index == 0) {
						sCompanyCode = objJournalVoucherBean.getCompanyCode();
						index++;
					} else {
						if (sCompanyCode.equals(objJournalVoucherBean.getCompanyCode())) {
							// sCompanyCode =
							// objJournalVoucherBean.getCompanyCode();
						} else {
							// lJVIntraDetailList.add(objJournalVoucherBean);
							isInterCompanyTransaction = true;
						}
					}

					int iTemp = jdbcTemplate.update(JournalVoucherQueryUtil.ADD_JOURNAL_VOUCHER_DTL,
							new Object[] { objJournalVoucherData.getJvNumber(), objJournalVoucherBean.getAccountCode(), objJournalVoucherBean.getCurrency(), objJournalVoucherBean.getExchangeRate(), objJournalVoucherBean.getTcDebitAmount(), objJournalVoucherBean.getTcCreditAmount(), objJournalVoucherBean.getNarration(), objJournalVoucherBean.getDepartmentCode(), objJournalVoucherBean.getVoyageCode(), objJournalVoucherBean.getVesselCode(), objJournalVoucherBean.getSectorCode(), objJournalVoucherBean.getAccountCode().substring(0, 4),
									objJournalVoucherBean.getBcDebitAmount(), objJournalVoucherBean.getBcCreditAmount(), iCounter, objJournalVoucherBean.getSubAccountCode(), objJournalVoucherBean.getEmployeeCode(), objJournalVoucherBean.getPortCode(), objJournalVoucherBean.getAgentCode(), objJournalVoucherBean.getCountryCode(), objJournalVoucherBean.getCustomerCode(), objJournalVoucherBean.getSupplierCode(), objJournalVoucherBean.getDesignationCode(), objJournalVoucherBean.getCompanyCode(), objJournalVoucherBean.getCostCenter(),
									objJournalVoucherBean.getQuantityGO(), objJournalVoucherBean.getQuantityFO(), objJournalVoucherBean.getPortSequence(), objJournalVoucherData.getRefNo(), objJournalVoucherBean.getAssetCode() });
					if (iTemp > 0) {
						if (objJournalVoucherData.getLedgerNo() != null) {
							double allocatedAmount = 0;
							int allocatedCount = 0;
							try {
								if (objJournalVoucherBean.getAccountCode().equalsIgnoreCase(AccountsConstants.MANAGING_COMPANY_OTHERS)) {
									if (objJournalVoucherBean.getBcDebitAmount() > 0) {
										allocatedAmount = -objJournalVoucherBean.getBcDebitAmount();
									} else if (objJournalVoucherBean.getBcCreditAmount() > 0) {
										allocatedAmount = objJournalVoucherBean.getBcCreditAmount();
									}
									jdbcTemplate.update(JournalVoucherQueryUtil.UPDATE_GL_ALLOCATED_AMT_BY_LEDGER_ID, new Object[] { allocatedAmount, objJournalVoucherData.getLedgerNo(), objJournalVoucherData.getLedgerNo() });
								}
								allocatedCount = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.CHECK_ALLOCATED_AMT, new Object[] { objJournalVoucherData.getLedgerNo() }, Integer.class);
								if (allocatedCount > 0) {
									jdbcTemplate.update(JournalVoucherQueryUtil.UPDATE_GL_RECON_STATE_BY_LEDGER_ID, objJournalVoucherData.getLedgerNo());
								}
								jdbcTemplate.update(JournalVoucherQueryUtil.UPDATE_GL_RECON_STATE_BY_JV_NO, objJournalVoucherData.getJvNumber(), AccountsConstants.MANAGING_COMPANY_OTHERS);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						UserLog userLog = userlogDao.userLogForInsert(objJournalVoucherBean, objJournalVoucherData.getJvNumber(), userDetails.getUserId());
						auditLogDao.auditLogForInsert(objJournalVoucherBean, userLog, null);
					}

					// Automated entry for JV - Inter-company transaction
					if (isInterCompanyTransaction) {
						// iCounter = lJVDetailList.size();
						// for (JournalVoucherBean objJournalVoucherBean :
						// lJVIntraDetailList) {
						// iCounter++;

						Double amount = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.CHECK_INTRA_COMPANY, new Object[] { objJournalVoucherData.getJvNumber(), objJournalVoucherBean.getCompanyCode() }, Double.class);
						System.out.println(sCompanyCode + "-" + objJournalVoucherBean.getCompanyCode());
						if (amount != 0.0) {

							String creditaccount = "";
							String debitaccount = "";
							String debitnarration = "";
							String creditnarration = "";
							List<Map<String, Object>> rowsdata = jdbcTemplate.queryForList(CashBankReceiptQueryUtil.GET_ACCOUNT_INTRA, new Object[] { objJournalVoucherBean.getCompanyCode() });
							for (Map row : rowsdata) {
								debitaccount = String.valueOf(row.get("account_head"));
								debitnarration = String.valueOf(row.get("intra_name"));
							}

							List<Map<String, Object>> rowsdata1 = jdbcTemplate.queryForList(CashBankReceiptQueryUtil.GET_ACCOUNT_INTRA, new Object[] { sCompanyCode });
							for (Map row : rowsdata1) {
								creditaccount = String.valueOf(row.get("account_head"));
								creditnarration = String.valueOf(row.get("intra_name"));
							}

							jdbcTemplate.update(JournalVoucherQueryUtil.ADD_JOURNAL_VOUCHER_DTL,
									new Object[] { objJournalVoucherData.getJvNumber(), creditaccount, objJournalVoucherBean.getCurrency(), objJournalVoucherBean.getExchangeRate(), objJournalVoucherBean.getTcCreditAmount(), objJournalVoucherBean.getTcDebitAmount(), objJournalVoucherBean.getNarration() + " - " + creditnarration, objJournalVoucherBean.getDepartmentCode(), objJournalVoucherBean.getVoyageCode(), objJournalVoucherBean.getVesselCode(), objJournalVoucherBean.getSectorCode(), AccountsConstants.INTER_COMPANY_MANAGING_ACCOUNTS_SG,
											objJournalVoucherBean.getBcCreditAmount(), objJournalVoucherBean.getBcDebitAmount(), iCounter, null, objJournalVoucherBean.getEmployeeCode(), objJournalVoucherBean.getPortCode(), objJournalVoucherBean.getAgentCode(), objJournalVoucherBean.getCountryCode(), objJournalVoucherBean.getCustomerCode(), objJournalVoucherBean.getSupplierCode(), objJournalVoucherBean.getDesignationCode(), objJournalVoucherBean.getCompanyCode(), objJournalVoucherBean.getCostCenter(), objJournalVoucherBean.getQuantityGO(),
											objJournalVoucherBean.getQuantityFO(), objJournalVoucherBean.getPortSequence(), objJournalVoucherData.getRefNo(), objJournalVoucherBean.getAssetCode() });
							iCounter++;
							jdbcTemplate.update(JournalVoucherQueryUtil.ADD_JOURNAL_VOUCHER_DTL,
									new Object[] { objJournalVoucherData.getJvNumber(), debitaccount, objJournalVoucherBean.getCurrency(), objJournalVoucherBean.getExchangeRate(), objJournalVoucherBean.getTcDebitAmount(), objJournalVoucherBean.getTcCreditAmount(), objJournalVoucherBean.getNarration() + " - " + debitnarration, objJournalVoucherBean.getDepartmentCode(), objJournalVoucherBean.getVoyageCode(), objJournalVoucherBean.getVesselCode(), objJournalVoucherBean.getSectorCode(), AccountsConstants.INTER_COMPANY_MANAGING_ACCOUNTS_SG,
											objJournalVoucherBean.getBcDebitAmount(), objJournalVoucherBean.getBcCreditAmount(), iCounter, null, objJournalVoucherBean.getEmployeeCode(), objJournalVoucherBean.getPortCode(), objJournalVoucherBean.getAgentCode(), objJournalVoucherBean.getCountryCode(), objJournalVoucherBean.getCustomerCode(), objJournalVoucherBean.getSupplierCode(), objJournalVoucherBean.getDesignationCode(), sCompanyCode, objJournalVoucherBean.getCostCenter(), objJournalVoucherBean.getQuantityGO(),
											objJournalVoucherBean.getQuantityFO(), objJournalVoucherBean.getPortSequence(), objJournalVoucherData.getRefNo(), objJournalVoucherBean.getAssetCode() });

							try {

							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						// }

					}
				} catch (DataAccessException e) {
					e.printStackTrace();
				}

			}
			ResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return ResultBean;
	}

	@Override
	public OpeningBalanceResultBean generateJv(OpeningBalanceBean mablBean) {
		OpeningBalanceResultBean ResultBean = new OpeningBalanceResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		OpeningBalanceBean Bean = new OpeningBalanceBean();
		String name;
		String name1;
		Integer count = 0;
		// int test=mablBean.getCompanyId();
		try {
			// int cust=mablBean.getCustomer();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			DateFormat formatter;
			String sCurrentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

			formatter = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date date;
			JournalVoucherBean objJournalVoucherBean = new JournalVoucherBean();
			boolean isSuccess = false;
			JournalVoucherDTO objJournalVoucherData = new JournalVoucherDTO();
			try {
				objJournalVoucherBean.setCompanyCode(mablBean.getCompanyId());
				objJournalVoucherData.setDataOfIssue(mablBean.getInvoiceDate());
				// String journalNumber =
				// generateJournalNumber_New(objJournalVoucherBean.getCompanyCode(),
				// objJournalVoucherData.getDataOfIssue());
				String journalNumber = generateJournalVoucherNumber();

				objJournalVoucherData.setOpeningBalance(true);
				objJournalVoucherData.setJvNumber(journalNumber);

				Double credit = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.CHECK_CREDIT, Double.class);
				Double debit = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.CHECK_DEBIT, Double.class);

				objJournalVoucherData.setTotalTcCreditAmt(credit - debit);
				objJournalVoucherData.setTotalBcCreditAmt(credit - debit);

				objJournalVoucherData.setTotalbcDebit(credit - debit);
				objJournalVoucherData.setTotalbcCredit(credit - debit);

				objJournalVoucherData.setExchangeRate(1);
				objJournalVoucherData.setNarration("Opening Balance Transfer entries as on 31/03/2021");
				boolean isUpdated = false;

				// String sRefNo =
				// getRefernce(objJournalVoucherBean.getCompanyCode(),
				// journalNumber, mablBean.getInvoiceDate());
				List<JournalVoucherBean> tables = new ArrayList<>();
				objJournalVoucherBean.setCompanyCode(mablBean.getCompanyId());
				// objJournalVoucherBean.setj();

				objJournalVoucherBean.setOpeningBalance(true);
				objJournalVoucherBean.setJournalNo(journalNumber);
				objJournalVoucherBean.setTcCreditAmount(credit - debit);
				objJournalVoucherBean.setBcCreditAmount(credit - debit);

				objJournalVoucherBean.setBcDebitAmount(credit - debit);
				objJournalVoucherBean.setTcDebitAmount(credit - debit);

				objJournalVoucherBean.setCurrency("INR");
				objJournalVoucherBean.setExchangeRate(1);
				objJournalVoucherBean.setNarration("Opening Balance Transfer entries as on 31/03/2021");
				objJournalVoucherBean.setAccountCode("20050001");
				// objJournalVoucherBean.setSubAccountCode(name);
				objJournalVoucherBean.setCustomerCode(mablBean.getCustomer());
				// objJournalVoucherBean.setCustomerCode(sRefNo);
				tables.add(objJournalVoucherBean);
				objJournalVoucherData.setTables(tables);

				String sCompanyCode = "";
				int index = 0;
				boolean isInterCompanyTransaction = false;
				int iCounter = 0;
				int iJvHdr = jdbcTemplate.update(JournalVoucherQueryUtil.ADD_JOURNAL_VOUCHER_HEADER, new Object[] { journalNumber, objJournalVoucherData.getDataOfIssue(), objJournalVoucherData.getNarration(), userDetails.getUserId(), objJournalVoucherBean.getCompanyCode(), "", objJournalVoucherBean.getOpeningBalance() });
				// for (JournalVoucherBean objJournalVoucherBean :
				// lJVDetailList) {
				iCounter++;

				if (index == 0) {
					sCompanyCode = objJournalVoucherBean.getCompanyCode();
					index++;
				} else {
					if (sCompanyCode.equals(objJournalVoucherBean.getCompanyCode())) {
						// sCompanyCode =
						// objJournalVoucherBean.getCompanyCode();
					} else {
						// lJVIntraDetailList.add(objJournalVoucherBean);
						isInterCompanyTransaction = true;
					}
				}

				int iTemp = jdbcTemplate.update(OpeningBalanceQueryUtil.ADD_JOURNAL_VOUCHER_DTL,
						new Object[] { objJournalVoucherData.getJvNumber(), objJournalVoucherBean.getAccountCode(), objJournalVoucherBean.getCurrency(), objJournalVoucherBean.getExchangeRate(), objJournalVoucherBean.getTcDebitAmount(), objJournalVoucherBean.getTcCreditAmount(), objJournalVoucherBean.getNarration(), objJournalVoucherBean.getDepartmentCode(), objJournalVoucherBean.getVoyageCode(), objJournalVoucherBean.getVesselCode(), objJournalVoucherBean.getSectorCode(), objJournalVoucherBean.getAccountCode().substring(0, 4),
								objJournalVoucherBean.getBcDebitAmount(), objJournalVoucherBean.getBcCreditAmount(), iCounter, objJournalVoucherBean.getSubAccountCode(), objJournalVoucherBean.getEmployeeCode(), objJournalVoucherBean.getPortCode(), objJournalVoucherBean.getAgentCode(), objJournalVoucherBean.getCountryCode(), objJournalVoucherBean.getCustomerCode(), objJournalVoucherBean.getSupplierCode(), objJournalVoucherBean.getDesignationCode(), objJournalVoucherBean.getCompanyCode(), objJournalVoucherBean.getCostCenter(), });
				if (iTemp > 0) {
					if (objJournalVoucherData.getLedgerNo() != null) {
						double allocatedAmount = 0;
						int allocatedCount = 0;
						try {
							if (objJournalVoucherBean.getAccountCode().equalsIgnoreCase(AccountsConstants.MANAGING_COMPANY_OTHERS)) {
								if (objJournalVoucherBean.getBcDebitAmount() > 0) {
									allocatedAmount = -objJournalVoucherBean.getBcDebitAmount();
								} else if (objJournalVoucherBean.getBcCreditAmount() > 0) {
									allocatedAmount = objJournalVoucherBean.getBcCreditAmount();
								}
								jdbcTemplate.update(JournalVoucherQueryUtil.UPDATE_GL_ALLOCATED_AMT_BY_LEDGER_ID, new Object[] { allocatedAmount, objJournalVoucherData.getLedgerNo(), objJournalVoucherData.getLedgerNo() });
							}
							allocatedCount = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.CHECK_ALLOCATED_AMT, new Object[] { objJournalVoucherData.getLedgerNo() }, Integer.class);
							if (allocatedCount > 0) {
								jdbcTemplate.update(JournalVoucherQueryUtil.UPDATE_GL_RECON_STATE_BY_LEDGER_ID, objJournalVoucherData.getLedgerNo());
							}
							jdbcTemplate.update(JournalVoucherQueryUtil.UPDATE_GL_RECON_STATE_BY_JV_NO, objJournalVoucherData.getJvNumber(), AccountsConstants.MANAGING_COMPANY_OTHERS);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					UserLog userLog = userlogDao.userLogForInsert(objJournalVoucherBean, objJournalVoucherData.getJvNumber(), userDetails.getUserId());
					// auditLogDao.auditLogForInsert(objJournalVoucherBean,
					// userLog, null);
				}

				// Automated entry for JV - Inter-company transaction
				if (isInterCompanyTransaction) {
					// iCounter = lJVDetailList.size();
					// for (JournalVoucherBean objJournalVoucherBean :
					// lJVIntraDetailList) {
					// iCounter++;

					Double amount = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.CHECK_INTRA_COMPANY, new Object[] { objJournalVoucherData.getJvNumber(), objJournalVoucherBean.getCompanyCode() }, Double.class);
					System.out.println(sCompanyCode + "-" + objJournalVoucherBean.getCompanyCode());
					if (amount != 0.0) {

						String creditaccount = "";
						String debitaccount = "";
						String debitnarration = "";
						String creditnarration = "";
						List<Map<String, Object>> rowsdata = jdbcTemplate.queryForList(CashBankReceiptQueryUtil.GET_ACCOUNT_INTRA, new Object[] { objJournalVoucherBean.getCompanyCode() });
						for (Map row : rowsdata) {
							debitaccount = String.valueOf(row.get("account_head"));
							debitnarration = String.valueOf(row.get("intra_name"));
						}

						List<Map<String, Object>> rowsdata1 = jdbcTemplate.queryForList(CashBankReceiptQueryUtil.GET_ACCOUNT_INTRA, new Object[] { sCompanyCode });
						for (Map row : rowsdata1) {
							creditaccount = String.valueOf(row.get("account_head"));
							creditnarration = String.valueOf(row.get("intra_name"));
						}

						jdbcTemplate.update(JournalVoucherQueryUtil.ADD_JOURNAL_VOUCHER_DTL,
								new Object[] { objJournalVoucherData.getJvNumber(), creditaccount, objJournalVoucherBean.getCurrency(), objJournalVoucherBean.getExchangeRate(), objJournalVoucherBean.getTcCreditAmount(), objJournalVoucherBean.getTcDebitAmount(), objJournalVoucherBean.getNarration() + " - " + creditnarration, objJournalVoucherBean.getDepartmentCode(), objJournalVoucherBean.getVoyageCode(), objJournalVoucherBean.getVesselCode(), objJournalVoucherBean.getSectorCode(), AccountsConstants.INTER_COMPANY_MANAGING_ACCOUNTS_SG,
										objJournalVoucherBean.getBcCreditAmount(), objJournalVoucherBean.getBcDebitAmount(), iCounter, null, objJournalVoucherBean.getEmployeeCode(), objJournalVoucherBean.getPortCode(), objJournalVoucherBean.getAgentCode(), objJournalVoucherBean.getCountryCode(), objJournalVoucherBean.getCustomerCode(), objJournalVoucherBean.getSupplierCode(), objJournalVoucherBean.getDesignationCode(), objJournalVoucherBean.getCompanyCode(), objJournalVoucherBean.getCostCenter(), objJournalVoucherBean.getQuantityGO(),
										objJournalVoucherBean.getQuantityFO(), objJournalVoucherBean.getPortSequence(), objJournalVoucherData.getRefNo(), objJournalVoucherBean.getAssetCode() });
						iCounter++;
						jdbcTemplate.update(JournalVoucherQueryUtil.ADD_JOURNAL_VOUCHER_DTL,
								new Object[] { objJournalVoucherData.getJvNumber(), debitaccount, objJournalVoucherBean.getCurrency(), objJournalVoucherBean.getExchangeRate(), objJournalVoucherBean.getTcDebitAmount(), objJournalVoucherBean.getTcCreditAmount(), objJournalVoucherBean.getNarration() + " - " + debitnarration, objJournalVoucherBean.getDepartmentCode(), objJournalVoucherBean.getVoyageCode(), objJournalVoucherBean.getVesselCode(), objJournalVoucherBean.getSectorCode(), AccountsConstants.INTER_COMPANY_MANAGING_ACCOUNTS_SG,
										objJournalVoucherBean.getBcDebitAmount(), objJournalVoucherBean.getBcCreditAmount(), iCounter, null, objJournalVoucherBean.getEmployeeCode(), objJournalVoucherBean.getPortCode(), objJournalVoucherBean.getAgentCode(), objJournalVoucherBean.getCountryCode(), objJournalVoucherBean.getCustomerCode(), objJournalVoucherBean.getSupplierCode(), objJournalVoucherBean.getDesignationCode(), sCompanyCode, objJournalVoucherBean.getCostCenter(), objJournalVoucherBean.getQuantityGO(), objJournalVoucherBean.getQuantityFO(),
										objJournalVoucherBean.getPortSequence(), objJournalVoucherData.getRefNo(), objJournalVoucherBean.getAssetCode() });

						try {

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					// }

				}
			} catch (DataAccessException e) {
				e.printStackTrace();
			}

			ResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return ResultBean;
	}

	public String generateJournalVoucherNumber() throws CustomException {
		String journalNumber = null;
		String appendWithYear = "", appendWithJVNo = "";

		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			String sCurrentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			sCurrentYear = sCurrentYear.substring(2);

			appendWithJVNo = "OB" + sCurrentYear + "00001";
			appendWithYear = "OB" + sCurrentYear + "%";

			List<Map<String, Object>> rowJVNo = jdbcTemplate.queryForList(JournalVoucherQueryUtil.GET_JOURNAL_NO_AUTOGENERATE, new Object[] { appendWithJVNo, appendWithYear });
			for (Map row : rowJVNo) {
				journalNumber = (String) row.get("JOURNAL_NO");
			}

		} catch (DataAccessException e) {
		}

		return journalNumber;
	}

	@Override
	public OpeningBalanceResultBean editMabl(int transactionid) {
		OpeningBalanceResultBean mablResultBean = new OpeningBalanceResultBean();
		OpeningBalanceBean bean = new OpeningBalanceBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// bean=jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.EDIT,new
			// BeanPropertyRowMapper<OpeningBalanceBean>(OpeningBalanceBean.class),transactionid);
			bean = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.EDIT, new BeanPropertyRowMapper<>(OpeningBalanceBean.class), transactionid);
			mablResultBean.setBean(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mablResultBean;
	}

	public String generateJournalNumber_New(String sCompanyCode, String receiptDate) throws ParseException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sLocnName = "";
		List<Map<String, Object>> locnNameRows = jdbcTemplate.queryForList(CashBankPaymentQueryUtil.GET_LOCATION_WITH_COMPANY_ID, new Object[] { sCompanyCode });
		for (Map row : locnNameRows) {
			sLocnName = (String) row.get("LOCATION");
		}
		sLocnName = sLocnName.substring(0, 2);

		String journalNo = "";
		String sJVYearWithLike = "", sJVYear = "", sJVLocn = "", sJVstartingNo = "";
		try {
			/*
			 * String sCurrentYear =
			 * String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			 * sCurrentYear = sCurrentYear.substring(2);
			 */
			DateFormat formatter;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = formatter.parse(receiptDate);
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String receiptDateyear = df.format(date);
			String recDate = receiptDateyear.substring(2);

			if (!sLocnName.equalsIgnoreCase("DU")) {
				sJVYearWithLike = sLocnName + "JV" + recDate + "%";
				sJVLocn = sLocnName + "JV";
				sJVYear = sLocnName + "JV" + recDate;
				sJVstartingNo = sLocnName + "JV" + recDate + "00001";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(JournalVoucherQueryUtil.AUTO_GEN_PG_JOURNAL_NO_SIN, new Object[] { sJVstartingNo, sJVLocn, sJVYearWithLike });
				for (Map row : rows) {
					journalNo = (String) row.get("JOURNAL_NO");
				}
			} else {
				sJVYearWithLike = "JV" + recDate + "%";
				sJVYear = "JV" + recDate;
				sJVLocn = "JV";
				sJVstartingNo = "JV" + recDate + "00001";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(JournalVoucherQueryUtil.AUTO_GEN_PG_JOURNAL_NO_NEW, new Object[] { sJVstartingNo, sJVLocn, sJVYearWithLike });
				for (Map row : rows) {
					journalNo = (String) row.get("JOURNAL_NO");
				}
			}

		} catch (DataAccessException e) {
		}
		return journalNo;
	}

	public String getRefernce(String sCompanyCode, String journalNumber, String year) throws CustomException {
		String refno = "";
		String ref = "";
		List<String> lOwnersCompany = new ArrayList<>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_OWNERS_COMPANY);
		for (Map row : rows) {
			lOwnersCompany.add((String) row.get("COMPANY_CODE"));
		}
		if ("C0001".equalsIgnoreCase(sCompanyCode)) {
			ref = "FJV" + year;
			refno = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.GET_REF_NO_FEEDER_JV, new Object[] { ref, ref + "%" }, String.class);
		} else if (lOwnersCompany.contains(sCompanyCode)) {
			ref = "OJV" + year;
			refno = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.GET_REF_NO_OWNERS_JV, new Object[] { ref, ref + "%" }, String.class);
		} else {
			refno = journalNumber;
		}

		return refno;
	}

	private boolean saveJournalVoucherDetail(JournalVoucherDTO objJournalVoucherData, String userId) {
		boolean flag = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			List<JournalVoucherBean> lJVDetailList = objJournalVoucherData.getTables();
			List<JournalVoucherBean> lJVIntraDetailList = new ArrayList<>();

			String sCompanyCode = "";
			int index = 0;
			boolean isInterCompanyTransaction = false;
			int iCounter = 0;
			for (JournalVoucherBean objJournalVoucherBean : lJVDetailList) {
				iCounter++;

				if (index == 0) {
					sCompanyCode = objJournalVoucherBean.getCompanyCode();
					index++;
				} else {
					if (sCompanyCode.equals(objJournalVoucherBean.getCompanyCode())) {
						// sCompanyCode =
						// objJournalVoucherBean.getCompanyCode();
					} else {
						lJVIntraDetailList.add(objJournalVoucherBean);
						isInterCompanyTransaction = true;
					}
				}

				int iTemp = jdbcTemplate.update(JournalVoucherQueryUtil.ADD_JOURNAL_VOUCHER_DTL,
						new Object[] { objJournalVoucherData.getJvNumber(), objJournalVoucherBean.getAccountCode(), objJournalVoucherBean.getCurrency(), objJournalVoucherBean.getExchangeRate(), objJournalVoucherBean.getTcDebitAmount(), objJournalVoucherBean.getTcCreditAmount(), objJournalVoucherBean.getNarration(), objJournalVoucherBean.getDepartmentCode(), objJournalVoucherBean.getVoyageCode(), objJournalVoucherBean.getVesselCode(), objJournalVoucherBean.getSectorCode(), objJournalVoucherBean.getAccountCode().substring(0, 4),
								objJournalVoucherBean.getBcDebitAmount(), objJournalVoucherBean.getBcCreditAmount(), iCounter, objJournalVoucherBean.getSubAccountCode(), objJournalVoucherBean.getEmployeeCode(), objJournalVoucherBean.getPortCode(), objJournalVoucherBean.getAgentCode(), objJournalVoucherBean.getCountryCode(), objJournalVoucherBean.getCustomerCode(), objJournalVoucherBean.getSupplierCode(), objJournalVoucherBean.getDesignationCode(), objJournalVoucherBean.getCompanyCode(), objJournalVoucherBean.getCostCenter(),
								objJournalVoucherBean.getQuantityGO(), objJournalVoucherBean.getQuantityFO(), objJournalVoucherBean.getPortSequence(), objJournalVoucherData.getRefNo(), objJournalVoucherBean.getAssetCode() });
				if (iTemp > 0) {
					flag = true;
					if (objJournalVoucherData.getLedgerNo() != null) {
						double allocatedAmount = 0;
						int allocatedCount = 0;
						try {
							if (objJournalVoucherBean.getAccountCode().equalsIgnoreCase(AccountsConstants.MANAGING_COMPANY_OTHERS)) {
								if (objJournalVoucherBean.getBcDebitAmount() > 0) {
									allocatedAmount = -objJournalVoucherBean.getBcDebitAmount();
								} else if (objJournalVoucherBean.getBcCreditAmount() > 0) {
									allocatedAmount = objJournalVoucherBean.getBcCreditAmount();
								}
								jdbcTemplate.update(JournalVoucherQueryUtil.UPDATE_GL_ALLOCATED_AMT_BY_LEDGER_ID, new Object[] { allocatedAmount, objJournalVoucherData.getLedgerNo(), objJournalVoucherData.getLedgerNo() });
							}
							allocatedCount = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.CHECK_ALLOCATED_AMT, new Object[] { objJournalVoucherData.getLedgerNo() }, Integer.class);
							if (allocatedCount > 0) {
								jdbcTemplate.update(JournalVoucherQueryUtil.UPDATE_GL_RECON_STATE_BY_LEDGER_ID, objJournalVoucherData.getLedgerNo());
							}
							jdbcTemplate.update(JournalVoucherQueryUtil.UPDATE_GL_RECON_STATE_BY_JV_NO, objJournalVoucherData.getJvNumber(), AccountsConstants.MANAGING_COMPANY_OTHERS);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					UserLog userLog = userlogDao.userLogForInsert(objJournalVoucherBean, objJournalVoucherData.getJvNumber(), userId);
					auditLogDao.auditLogForInsert(objJournalVoucherBean, userLog, null);
				}

			}
			// Automated entry for JV - Inter-company transaction
			if (isInterCompanyTransaction) {
				iCounter = lJVDetailList.size();
				for (JournalVoucherBean objJournalVoucherBean : lJVIntraDetailList) {
					iCounter++;

					Double amount = jdbcTemplate.queryForObject(JournalVoucherQueryUtil.CHECK_INTRA_COMPANY, new Object[] { objJournalVoucherData.getJvNumber(), objJournalVoucherBean.getCompanyCode() }, Double.class);
					System.out.println(sCompanyCode + "-" + objJournalVoucherBean.getCompanyCode());
					if (amount != 0.0) {

						String creditaccount = "";
						String debitaccount = "";
						String debitnarration = "";
						String creditnarration = "";
						List<Map<String, Object>> rowsdata = jdbcTemplate.queryForList(CashBankReceiptQueryUtil.GET_ACCOUNT_INTRA, new Object[] { objJournalVoucherBean.getCompanyCode() });
						for (Map row : rowsdata) {
							debitaccount = String.valueOf(row.get("account_head"));
							debitnarration = String.valueOf(row.get("intra_name"));
						}

						List<Map<String, Object>> rowsdata1 = jdbcTemplate.queryForList(CashBankReceiptQueryUtil.GET_ACCOUNT_INTRA, new Object[] { sCompanyCode });
						for (Map row : rowsdata1) {
							creditaccount = String.valueOf(row.get("account_head"));
							creditnarration = String.valueOf(row.get("intra_name"));
						}

						jdbcTemplate.update(JournalVoucherQueryUtil.ADD_JOURNAL_VOUCHER_DTL,
								new Object[] { objJournalVoucherData.getJvNumber(), creditaccount, objJournalVoucherBean.getCurrency(), objJournalVoucherBean.getExchangeRate(), objJournalVoucherBean.getTcCreditAmount(), objJournalVoucherBean.getTcDebitAmount(), objJournalVoucherBean.getNarration() + " - " + creditnarration, objJournalVoucherBean.getDepartmentCode(), objJournalVoucherBean.getVoyageCode(), objJournalVoucherBean.getVesselCode(), objJournalVoucherBean.getSectorCode(), AccountsConstants.INTER_COMPANY_MANAGING_ACCOUNTS_SG,
										objJournalVoucherBean.getBcCreditAmount(), objJournalVoucherBean.getBcDebitAmount(), iCounter, null, objJournalVoucherBean.getEmployeeCode(), objJournalVoucherBean.getPortCode(), objJournalVoucherBean.getAgentCode(), objJournalVoucherBean.getCountryCode(), objJournalVoucherBean.getCustomerCode(), objJournalVoucherBean.getSupplierCode(), objJournalVoucherBean.getDesignationCode(), objJournalVoucherBean.getCompanyCode(), objJournalVoucherBean.getCostCenter(), objJournalVoucherBean.getQuantityGO(),
										objJournalVoucherBean.getQuantityFO(), objJournalVoucherBean.getPortSequence(), objJournalVoucherData.getRefNo(), objJournalVoucherBean.getAssetCode() });
						iCounter++;
						jdbcTemplate.update(JournalVoucherQueryUtil.ADD_JOURNAL_VOUCHER_DTL,
								new Object[] { objJournalVoucherData.getJvNumber(), debitaccount, objJournalVoucherBean.getCurrency(), objJournalVoucherBean.getExchangeRate(), objJournalVoucherBean.getTcDebitAmount(), objJournalVoucherBean.getTcCreditAmount(), objJournalVoucherBean.getNarration() + " - " + debitnarration, objJournalVoucherBean.getDepartmentCode(), objJournalVoucherBean.getVoyageCode(), objJournalVoucherBean.getVesselCode(), objJournalVoucherBean.getSectorCode(), AccountsConstants.INTER_COMPANY_MANAGING_ACCOUNTS_SG,
										objJournalVoucherBean.getBcDebitAmount(), objJournalVoucherBean.getBcCreditAmount(), iCounter, null, objJournalVoucherBean.getEmployeeCode(), objJournalVoucherBean.getPortCode(), objJournalVoucherBean.getAgentCode(), objJournalVoucherBean.getCountryCode(), objJournalVoucherBean.getCustomerCode(), objJournalVoucherBean.getSupplierCode(), objJournalVoucherBean.getDesignationCode(), sCompanyCode, objJournalVoucherBean.getCostCenter(), objJournalVoucherBean.getQuantityGO(), objJournalVoucherBean.getQuantityFO(),
										objJournalVoucherBean.getPortSequence(), objJournalVoucherData.getRefNo(), objJournalVoucherBean.getAssetCode() });

						try {

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}

			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return flag;
	}

	private boolean updateSaveJournalVoucherDetail(JournalVoucherDTO objJournalVoucherData, String userId) {
		boolean isSuccess = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			int rowDetail = jdbcTemplate.update(JournalVoucherQueryUtil.DELETE_JOURNAL_VOUCHER_DETAIL, objJournalVoucherData.getJvNumber());
			if (rowDetail > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			if (isSuccess) {
				objJournalVoucherData.setJvNumber(objJournalVoucherData.getJvNumber());
				isSuccess = saveJournalVoucherDetail(objJournalVoucherData, userId);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	@Override
	public OpeningBalanceResultBean update(OpeningBalanceBean mablBean) {
		OpeningBalanceResultBean ResultBean = new OpeningBalanceResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		OpeningBalanceBean Bean = new OpeningBalanceBean();
		String name;
		String name1;
		Integer count = 0;
		// int test=mablBean.getCompanyId();
		try {
			// int cust=mablBean.getCustomer();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// name=jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.CUSTOMER,String.class,cust);
			name1 = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.CUSTOMER, String.class, mablBean.getCustomer(), mablBean.getCustomer());
			name = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.Get_Account_Code, String.class, mablBean.getCustomer(), mablBean.getCustomer());
			jdbcTemplate.update(OpeningBalanceQueryUtil.Update, mablBean.getInvoiceNo(), mablBean.getInvoiceDate(), mablBean.getBcAmount(), mablBean.getTcAmount(), mablBean.getCurrency(), mablBean.getExchangeRate(), name, name, mablBean.getCustomer(), name1, mablBean.getCompanyId(), mablBean.getSundryStatus(), mablBean.getAccountHead(), mablBean.getSubAccount(), mablBean.getTransactionid());
			// if(mablBean.getSubAccount() != null && mablBean.getSubAccount()
			// != ""){
			count = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.Get_Count_With_Sub_Group_Code, Integer.class, mablBean.getCompanyId(), mablBean.getAccountHead(), mablBean.getSubAccount());
			// }
			// else{
			// count=jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.Get_Count_WithOut_Sub_Group_Code,Integer.class,mablBean.getCompanyId(),mablBean.getAccountHead());
			//
			// }

			if (count > 0) {
				String jvNumb = "";
				if (mablBean.getSubAccount() != null && mablBean.getSubAccount() != "") {
					jvNumb = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.Get_JVNo_With_Sub_Group_Code, String.class, mablBean.getCompanyId(), mablBean.getAccountHead(), mablBean.getSubAccount());
				} else {
					jvNumb = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.Get_JVNo_WithOut_Sub_Group_Code, String.class, mablBean.getCompanyId(), mablBean.getAccountHead());

				}
				name = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.Get_Account_Code, String.class, mablBean.getCustomer());

				JournalVoucherBean objJournalVoucherBean = new JournalVoucherBean();
				boolean isSuccess = false;
				JournalVoucherDTO objJournalVoucherData = new JournalVoucherDTO();
				objJournalVoucherBean.setCompanyCode(mablBean.getCompanyId());
				// objJournalVoucherBean.setj();

				objJournalVoucherData.setOpeningBalance(true);
				objJournalVoucherData.setJvNumber(jvNumb);
				objJournalVoucherData.setTotalTcCreditAmt(mablBean.getTcAmount());
				objJournalVoucherData.setTotalBcCreditAmt(mablBean.getBcAmount());
				objJournalVoucherData.setDataOfIssue(mablBean.getInvoiceDate());
				objJournalVoucherData.setTotalbcCredit(mablBean.getBcAmount());
				objJournalVoucherData.setExchangeRate(mablBean.getExchangeRate());
				objJournalVoucherData.setNarration("Opening Balance Transfer entries as on 31/03/2018");
				boolean isUpdated = false;

				String sRefNo = getRefernce(objJournalVoucherBean.getCompanyCode(), jvNumb, mablBean.getInvoiceDate());
				List<JournalVoucherBean> tables = new ArrayList<>();
				objJournalVoucherBean.setCompanyCode(mablBean.getCompanyId());
				// objJournalVoucherBean.setj();

				objJournalVoucherBean.setOpeningBalance(true);
				objJournalVoucherBean.setJournalNo(jvNumb);
				objJournalVoucherBean.setTcCreditAmount(mablBean.getTcAmount());
				objJournalVoucherBean.setBcCreditAmount(mablBean.getBcAmount());
				objJournalVoucherBean.setCurrency(mablBean.getCurrency());
				objJournalVoucherBean.setExchangeRate(mablBean.getExchangeRate());
				objJournalVoucherBean.setNarration("Opening Balance Transfer entries as on 31/03/2018");
				objJournalVoucherBean.setAccountCode(mablBean.getAccountHead());
				objJournalVoucherBean.setSubAccountCode(name);
				objJournalVoucherBean.setCustomerCode(mablBean.getCustomer());
				objJournalVoucherBean.setCustomerCode(sRefNo);
				tables.add(objJournalVoucherBean);
				objJournalVoucherData.setTables(tables);

				// if(objJournalVoucherData.getTotalbcDebit()==objJournalVoucherData.getTotalbcCredit()){

				int iJvHdr = jdbcTemplate.update(JournalVoucherQueryUtil.UPDATE_SAVE_JOURNAL_VOUCHER_HEADER, new Object[] { objJournalVoucherData.getDataOfIssue(), objJournalVoucherData.getNarration(), userDetails.getUserId(), objJournalVoucherBean.getCompanyCode(), objJournalVoucherData.getOpeningBalance(), objJournalVoucherData.getJvNumber() });

				if (iJvHdr > 0) {
					isUpdated = updateSaveJournalVoucherDetail(objJournalVoucherData, userDetails.getUserId());

				}
				// }
				// }
			}
			ResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return ResultBean;
	}

	public String getPurchaseTypeList(String purchasetype) {
		String list = null;
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.NEW_QUERY_FOR_PURCHASE_TYPE, new Object[] { purchasetype }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	public String getCompanyList(String purchasetype) {
		String list = null;
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.NEW_QUERY_FOR_COMPANY, new Object[] { purchasetype }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	public String getVendorList(String entityid) {
		String list = null;
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.NEW_QUERY_FOR_VENDOR_TYPE, new Object[] { entityid }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	@Override
	public HashMap<String, String> getSupplier() {
		HashMap<String, String> map = new HashMap<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseInvoiceQueryUtil.GET_Supplier_LIST);
			for (Map row : rows) {
				map.put(String.valueOf(row.get("entity_name")), String.valueOf(row.get("entity_id")));
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getCharges", e);
		}
		return map;
	}

	@Override
	public HashMap<String, String> getAccount() {
		HashMap<String, String> map = new HashMap<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseInvoiceQueryUtil.GET_CHARGE_LIST);
			for (Map row : rows) {
				map.put(String.valueOf(row.get("text")), String.valueOf(row.get("id")));
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getCharges", e);
		}
		return map;
	}

	@Override
	public HashMap<String, String> getCompany() {
		HashMap<String, String> map = new HashMap<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseInvoiceQueryUtil.GET_Company_LIST);
			for (Map row : rows) {
				map.put(String.valueOf(row.get("company_name")), String.valueOf(row.get("company_id")));
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getCharges", e);
		}
		return map;
	}

	@Override
	public HashMap<String, String> getCustomer() {
		HashMap<String, String> map = new HashMap<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(OpeningBalanceQueryUtil.GET_Supplier_LIST);
			for (Map row : rows) {
				map.put(String.valueOf(row.get("entity_name")), String.valueOf(row.get("customer_acct_code")));
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getCharges", e);
		}
		return map;
	}

	@Override
	@Transactional
	public String InsertUploadData(List<OpeningBalanceBean> mablBean) {
		String alertmsg = "";

		OpeningBalanceResultBean ResultBean = new OpeningBalanceResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		OpeningBalanceBean Bean = new OpeningBalanceBean();
		String name;
		String name1;
		Integer count = 0;
		Timestamp timeStampDate = new Timestamp(new Date().getTime());
		String trashipmentrequentno = "";
		Set<String> purchaseQuoteset = new HashSet<>();
		Set<String> errospq = new HashSet<>();
		Boolean tpPqCheck = false;
		boolean isSuccess = false;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			for (OpeningBalanceBean lists : mablBean) {

				name = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.Get_Account_Code, String.class, lists.getCustomer(), lists.getCustomer());
				name1 = jdbcTemplate.queryForObject(OpeningBalanceQueryUtil.CUSTOMER, String.class, lists.getCustomer(), lists.getCustomer());
				jdbcTemplate.update(OpeningBalanceQueryUtil.SAVE, lists.getInvoiceNo(), lists.getInvoiceDate(), lists.getBcAmount(), lists.getTcAmount(), lists.getCurrency(), lists.getExchangeRate(), name, name, lists.getCustomer(), name1, lists.getCompanyId(), lists.getSundryStatus(), lists.getAccountHead(), name);
			}
		} catch (Exception e) {
			e.printStackTrace();

			alertmsg = "Unable to save data";
		}
		return alertmsg;
	}

	@Override
	public List<OpeningBalanceBean> getJournalVoucherList(OpeningBalanceBean journalVoucherBean) throws Exception {
		List<OpeningBalanceBean> lJournalVoucherList = new ArrayList<>();
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			String wherecode = "";
			if (journalVoucherBean.getFromdate() != null && journalVoucherBean.getFromdate() != "" && journalVoucherBean.getFromdate() != " ") {
				if (wherecode.isEmpty()) {
					wherecode = wherecode + "where created_dt>=to_date(" + "'" + journalVoucherBean.getFromdate() + "'" + ",'dd/mm/yyyy')";
				} else {
					wherecode = wherecode + "and  created_dt>=to_date(" + "'" + journalVoucherBean.getFromdate() + "'" + ",'dd/mm/yyyy')";
				}

			}
			if (journalVoucherBean.getTodate() != null && journalVoucherBean.getTodate() != "") {
				if (wherecode.isEmpty()) {
					wherecode = wherecode + "where  created_dt<=to_date(" + "'" + journalVoucherBean.getTodate() + "'" + ",'dd/mm/yyyy')";
				} else {
					wherecode = wherecode + "and  created_dt<=to_date(" + "'" + journalVoucherBean.getTodate() + "'" + ",'dd/mm/yyyy')";
				}
			}
			if (journalVoucherBean.getCompanyId() != null && journalVoucherBean.getCompanyId() != "") {
				if (wherecode.isEmpty()) {
					wherecode = wherecode + " where t.company_code ='" + journalVoucherBean.getCompanyId() + "'";
				} else {
					wherecode = wherecode + " and t.company_code ='" + journalVoucherBean.getCompanyId() + "'";
				}

			}

			String mainquery = "select account_head_code as accountHeadName, (select acct_head_name from account_head_master where acct_head_code = account_head_code) as accountHead, transaction_no as invoiceNo,to_char(transaction_dt,'dd/mm/yyyy') as invoiceDate,to_char(created_dt,'dd/mm/yyyy') as createdDate,bc_amount as bcAmount,tc_amount as tcAmount,transaction_id as transactionid,t.currency as currency,exchange_rate as exchangeRate,payer_short_name as customerName,sundry_status, case when sundry_status='D' then bc_amount  else 0 end as debit, case when sundry_status='C' then bc_amount  else 0 end as credit,t.company_code as companyId,c.company_name as companyName  from transactions_in_old t  left join company_master c on c.company_code =t.company_code "
					+ wherecode + "";

			lJournalVoucherList = jdbcTemplate.query(mainquery, new BeanPropertyRowMapper<>(OpeningBalanceBean.class));

			System.out.println(mainquery);
			
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get the Journal Voucher Header Records", e);

		}
		return lJournalVoucherList;
	}
}
