package com.dci.tenant.finance.cashbankbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.util.AccountsConstants;
import com.dci.common.util.CommonUtil;
import com.dci.common.util.CommonUtilityQueryUtil;
import com.dci.finance.GeneralLedger.GeneralLedgerQueryUtil;



@Repository
public class CashBankBookDAOImpl implements CashBankBookDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(CashBankBookDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Override
	public ArrayList<CashBankBook> getBankBookList(CashBankBook objGeneralLedgerBean) {
		ArrayList<CashBankBook> list = new ArrayList<>();
		String queryStr = "";
		try {
			String whereCondition = "", compCode = "";

			String query = "";
			if (objGeneralLedgerBean.getType().equals("bank")) {
				query = CashBankBookQueryUtil.GET_BANK_ACCOUNT_filter;
				queryStr = "1011','1012','1013','1014','1015','1019','1020','1021','1000','1022";
			} else if (objGeneralLedgerBean.getType().equals("cash")) {
				query = CashBankBookQueryUtil.GET_CASH_ACCOUNT_filter;
				queryStr = "1005";
			}
			if ((!objGeneralLedgerBean.getFromDate().equalsIgnoreCase("") && !objGeneralLedgerBean.getFromDate().equalsIgnoreCase(null) && !objGeneralLedgerBean.getFromDate().equalsIgnoreCase("undefined")) && (!objGeneralLedgerBean.getToDate().equalsIgnoreCase("") && !objGeneralLedgerBean.getToDate().equalsIgnoreCase(null) && !objGeneralLedgerBean.getToDate().equalsIgnoreCase("undefined"))) {
				whereCondition = "and ledger_date::date between  TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY')  and  TO_DATE('" + objGeneralLedgerBean.getToDate() + "','DD-MM-YYYY') ";
			} else if (!objGeneralLedgerBean.getFromDate().equalsIgnoreCase("") && !objGeneralLedgerBean.getFromDate().equalsIgnoreCase(null) && !objGeneralLedgerBean.getFromDate().equalsIgnoreCase("undefined")) {
				whereCondition = "and ledger_date::date >=  TO_DATE('" + objGeneralLedgerBean.getFromDate() + "' ";
			} else if (!objGeneralLedgerBean.getToDate().equalsIgnoreCase("") && !objGeneralLedgerBean.getToDate().equalsIgnoreCase(null) && !objGeneralLedgerBean.getToDate().equalsIgnoreCase("undefined")) {
				whereCondition = "and ledger_date::date >=  TO_DATE('" + objGeneralLedgerBean.getToDate() + "' ";
			}
			if (objGeneralLedgerBean.getCompanyCode().equals("All")) {

			} else if (!objGeneralLedgerBean.getCompanyCode().equalsIgnoreCase("") && !objGeneralLedgerBean.getCompanyCode().equalsIgnoreCase(null) && !objGeneralLedgerBean.getCompanyCode().equalsIgnoreCase("undefined")) {
				whereCondition =whereCondition+ "and gl.company_id in ('" + objGeneralLedgerBean.getCompanyCode() + "') ";
			}
			System.out.println(query + whereCondition + " group by gl.parent_code,gl.account_code,ah.acct_head_name,s.entity_name,c.entity_name  having gl.parent_code in ('" + queryStr + "') order by gl.account_code ");
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(query + whereCondition + " group by gl.parent_code,gl.account_code,ah.acct_head_name,s.entity_name,c.entity_name  having gl.parent_code in ('" + queryStr + "') order by gl.account_code ", new Object[] {});
			for (Map row : rows) {
				CashBankBook bean = new CashBankBook();
				bean.setParentCode(CommonUtil.checkEmptyString(String.valueOf(row.get("parent_code"))));
				bean.setAccountCode(CommonUtil.checkEmptyString(String.valueOf(row.get("account_code"))));
				bean.setAccountName(CommonUtil.checkEmptyString(String.valueOf(row.get("account_name"))));
				bean.setCredit(CommonUtil.convertNullToDouble(String.valueOf(row.get("credit"))));
				bean.setDebit(CommonUtil.convertNullToDouble(String.valueOf(row.get("debit"))));
				bean.setCurrentBalance(CommonUtil.convertNullToDouble(String.valueOf(row.get("diffe"))));
				list.add(bean);

			}
		} catch (

		Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<CashBankBook> getBankBookAccountList(String sAccCode, String parentCode) {
		ArrayList<CashBankBook> list = new ArrayList<>();

		try {

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CashBankBookQueryUtil.GET_SUB_DATA, new Object[] { sAccCode, parentCode });
			for (Map row : rows) {
				CashBankBook bean = new CashBankBook();

				bean.setLedgerDate(CommonUtil.checkEmptyString(String.valueOf(row.get("ledger_date"))));
				bean.setTransactionNo(CommonUtil.checkEmptyString(String.valueOf(row.get("transaction_no"))));
				bean.setTrnsCredit(CommonUtil.convertNullToDouble(String.valueOf(row.get("credit"))));
				bean.setTrnsDebit(CommonUtil.convertNullToDouble(String.valueOf(row.get("debit"))));

				list.add(bean);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CashBankBook> getGeneralLedgerReport(CashBankBook objGeneralLedgerBean) {
		List<CashBankBook> lGeneralLedgerList = new ArrayList<>();
		String compCode = "", queryStr = "";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			String whereCondition = "";
			if (objGeneralLedgerBean.getCompanyCode().equalsIgnoreCase("ALL")) {

				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else {
				String companyCodes[] = objGeneralLedgerBean.getCompanyCode().split(",");

				for (int i = 0; i < companyCodes.length; i++) {
					if (compCode == "") {
						compCode = companyCodes[i];
					} else {
						compCode += "," + companyCodes[i];
					}
				}
			}

			String query = "", type =objGeneralLedgerBean.getType();
			if (type.equalsIgnoreCase("bank")) {
				query = CashBankBookQueryUtil.GET_SUBGROUP_DATA;
				queryStr = AccountsConstants.BANK_SG;
			} else if (type.equalsIgnoreCase("cash")) {
				query = CashBankBookQueryUtil.GET_SUBGROUP_DATA;
				queryStr = AccountsConstants.CASH_SG;
			}
			if ((!objGeneralLedgerBean.getFromDate().equalsIgnoreCase("") && !objGeneralLedgerBean.getFromDate().equalsIgnoreCase(null) && !objGeneralLedgerBean.getFromDate().equalsIgnoreCase("undefined")) && (!objGeneralLedgerBean.getToDate().equalsIgnoreCase("") && !objGeneralLedgerBean.getToDate().equalsIgnoreCase(null) && !objGeneralLedgerBean.getToDate().equalsIgnoreCase("undefined"))) {
				whereCondition = "and ledger_date::date between  TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY')  and  TO_DATE('" + objGeneralLedgerBean.getToDate() + "','DD-MM-YYYY') ";
			} else if (!objGeneralLedgerBean.getFromDate().equalsIgnoreCase("") && !objGeneralLedgerBean.getFromDate().equalsIgnoreCase(null) && !objGeneralLedgerBean.getFromDate().equalsIgnoreCase("undefined")) {
				whereCondition = "and ledger_date::date >=  TO_DATE('" + objGeneralLedgerBean.getFromDate() + "' ";
			} else if (!objGeneralLedgerBean.getToDate().equalsIgnoreCase("") && !objGeneralLedgerBean.getToDate().equalsIgnoreCase(null) && !objGeneralLedgerBean.getToDate().equalsIgnoreCase("undefined")) {
				whereCondition = "and ledger_date::date >=  TO_DATE('" + objGeneralLedgerBean.getToDate() + "' ";
			}
			/*if (!compCode.equalsIgnoreCase("") && !compCode.equalsIgnoreCase(null) && !compCode.equalsIgnoreCase("undefined")) {
				whereCondition = "and gl.company_id in ('" + compCode + "') ";
			}*/
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(query + whereCondition + "GROUP BY GL.PARENT_CODE,SG.SUB_GROUP_ACCT_NAME \n" + 
					"ORDER BY GL.PARENT_CODE", new Object[] { queryStr });
			for (Map row : rows) {
				CashBankBook bean = new CashBankBook();
				bean.setParentCode(CommonUtil.checkEmptyString(String.valueOf(row.get("subGroupCode"))));
				bean.setAccountCode(CommonUtil.checkEmptyString(String.valueOf(row.get("subGroupName"))));
				bean.setAccountName(CommonUtil.checkEmptyString(String.valueOf(row.get("subGroupName"))));
				bean.setCredit(CommonUtil.convertNullToDouble(String.valueOf(row.get("credit"))));
				bean.setDebit(CommonUtil.convertNullToDouble(String.valueOf(row.get("debit"))));
				bean.setCurrentBalance(CommonUtil.convertNullToDouble(String.valueOf(row.get("balance"))));
				lGeneralLedgerList.add(bean);

			}

		} catch (

		DataAccessException e) {
			e.printStackTrace();
		}
		return lGeneralLedgerList;
	}

	@Override
	public String getcompanycode(CashBankBook objGeneralLedgerBean) {
		String list = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			list = jdbcTemplate.queryForObject(GeneralLedgerQueryUtil.CompanyName, new Object[] { objGeneralLedgerBean.getCompanyCode() }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			// LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	@Override
	public List<CashBankBook> getOpeningBalanceValue(CashBankBook objGeneralLedgerBean) {

		List<CashBankBook> objGeneralLedgerBeanOP = new ArrayList<>();
		String compCode = "'";

		try {
			/*
			 * JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); if
			 * (objGeneralLedgerBean.getCompanyCode().equalsIgnoreCase("ALL"))
			 * 
			 * { List<String> lCompany = new ArrayList<>(); List<Map<String,
			 * Object>> rows =
			 * jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
			 * for (Map row : rows) { lCompany.add((String)
			 * row.get("COMPANY_ID")); }
			 * 
			 * for (int i = 0; i < lCompany.size(); i++) { if (compCode == "'")
			 * { compCode += lCompany.get(i); } else { compCode += "," +
			 * lCompany.get(i); } }
			 * 
			 * } else { String companyCodes[] =
			 * objGeneralLedgerBean.getCompanyCode().split(",");
			 * 
			 * for (int i = 0; i < companyCodes.length; i++) { if (compCode ==
			 * "'") { compCode += companyCodes[i]; } else { compCode += "," +
			 * companyCodes[i]; } } } String sDynamicQuery = ""; compCode +=
			 * "'";
			 * 
			 * String companyCode = "";
			 * 
			 * companyCode = getcompanycode(objGeneralLedgerBean);
			 * 
			 * objGeneralLedgerBean.setCompanyName(companyCode); String value =
			 * ""; String subgroupName = ""; String subgroupAddress = ""; String
			 * subgroupAddress1 = "";
			 * 
			 * String subgroupAddress2 = ""; String subgroupAddress3 = "";
			 * String subgroupAddress4 = "";
			 * 
			 * String GSTno = ""; List<Map<String, Object>> rows =
			 * jdbcTemplate.queryForList(CashBankBookQueryUtil.GET_SUB_DATA, new
			 * Object[] { sAccCode, parentCode }); for (Map row : rows) {
			 * CashBankBook bean = new CashBankBook();
			 * 
			 * bean.setLedgerDate(CommonUtil.checkEmptyString(String.valueOf(row
			 * .get("ledger_date"))));
			 * bean.setTransactionNo(CommonUtil.checkEmptyString(String.valueOf(
			 * row.get("transaction_no"))));
			 * bean.setTrnsCredit(CommonUtil.convertNullToDouble(String.valueOf(
			 * row.get("credit"))));
			 * bean.setTrnsDebit(CommonUtil.convertNullToDouble(String.valueOf(
			 * row.get("debit"))));
			 * 
			 * objGeneralLedgerBeanOP.add(bean);
			 * 
			 * }
			 */} catch (Exception e) {
			e.printStackTrace();
		}
		return objGeneralLedgerBeanOP;
	}
}