package com.dci.tenant.finance.chqreconcilation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.util.AccountsConstants;
import com.dci.common.util.CommonUtil;

@Repository
public class ChqReconcilationDAOImpl implements ChqReconcilationDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(ChqReconcilationDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Override
	public List<ChqReconcilationBook> getBankBookList() {
		List<ChqReconcilationBook> list = new ArrayList<ChqReconcilationBook>();
		try {
			list = jdbcTemplate.query(ChqReconcilationQueryUtil.GET_BANK_ACCOUNT, new Object[] { AccountsConstants.BANK_SG }, new BeanPropertyRowMapper<ChqReconcilationBook>(ChqReconcilationBook.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<ChqReconcilationBook> getBankandBookStatement(String sFromDate, String sToDate, String sBankAccountCode, String compid) {

		List<ChqReconcilationBook> list = new ArrayList<ChqReconcilationBook>();

		try {
			List<Map<String, Object>> location = jdbcTemplate.queryForList(ChqReconcilationQueryUtil.sGetBookStatement, new Object[] { compid, CommonUtil.convertSqlDateFormat(sFromDate), CommonUtil.convertSqlDateFormat(sToDate), sBankAccountCode });
			for (Map row : location) {
				ChqReconcilationBook bean = new ChqReconcilationBook();
				bean.setTransactionNo(CommonUtil.convertNullToEmpty(String.valueOf(row.get("transaction_no"))));
				bean.setBookChequeDate(CommonUtil.convertNullToEmpty(String.valueOf(row.get("dt"))));
				bean.setBookChequeNo(CommonUtil.convertNullToEmpty(String.valueOf(row.get("cheque_no"))));
				bean.setBookDebitAmount(CommonUtil.convertNullToDouble(String.valueOf(row.get("dr"))));
				bean.setBookCreditAmount(CommonUtil.convertNullToDouble(String.valueOf(row.get("cr"))));
				bean.setOpeningBalance(CommonUtil.convertNullToDouble(String.valueOf(row.get("ob"))));
				bean.setClosingBalance(CommonUtil.convertNullToDouble(String.valueOf(row.get("cb"))));

				list.add(bean);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ChqReconcilationBook> getReconcileStatement(String sFromDate, String sToDate, String sBankAccountCode, String compid) {

		List<ChqReconcilationBook> list = new ArrayList<ChqReconcilationBook>();

		try {

			List<Map<String, Object>> location = jdbcTemplate.queryForList(ChqReconcilationQueryUtil.sGetReconcileStatement, new Object[] { CommonUtil.convertSqlDateFormat(sFromDate), CommonUtil.convertSqlDateFormat(sToDate), sBankAccountCode });
			for (Map row : location) {
				ChqReconcilationBook bean = new ChqReconcilationBook();
				bean.setTransactionNo(CommonUtil.convertNullToEmpty(String.valueOf(row.get("transaction_no"))));
				bean.setBookChequeDate(CommonUtil.convertNullToEmpty(String.valueOf(row.get("book_cheque_date"))));
				bean.setBookChequeNo(CommonUtil.convertNullToEmpty(String.valueOf(row.get("book_cheque_no"))));
				bean.setBookDebitAmount(CommonUtil.convertNullToDouble(String.valueOf(row.get("book_debit_amount"))));
				bean.setBookCreditAmount(CommonUtil.convertNullToDouble(String.valueOf(row.get("book_credit_amount"))));
				bean.setOpeningBalance(CommonUtil.convertNullToDouble(String.valueOf(row.get("opening_bal"))));
				bean.setClosingBalance(CommonUtil.convertNullToDouble(String.valueOf(row.get("closing_bal"))));
				bean.setBankDate(CommonUtil.convertNullToEmpty(String.valueOf(row.get("bank_date"))));
				bean.setRemarks(CommonUtil.convertNullToEmpty(String.valueOf(row.get("remarks"))));

				list.add(bean);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean saveReconcilation(ChqReconcilationBook bean, String companyCode) {
		boolean result = false;
		ArrayList<ChqReconcilationBook> list = bean.getDifferentrecli();

		for (int i = 0; i < list.size(); i++) {
			ChqReconcilationBook lbean = list.get(i);
			if (lbean.isSelect()) {
				jdbcTemplate.update(ChqReconcilationQueryUtil.sSaveReconcileTransaction, new Object[] { lbean.getTransactionNo(), CommonUtil.convertSqlDateFormat(lbean.getBookChequeDate()), lbean.getBookChequeNo(), lbean.getBookDebitAmount(), bean.getBookCreditAmount(), bean.getBankAccount(), bean.getRemarks(), CommonUtil.convertSqlDateFormat(lbean.getBankDate()), lbean.getClosingBalance(), lbean.getOpeningBalance() });
				result = true;
			}

		}

		return result;
	}

}