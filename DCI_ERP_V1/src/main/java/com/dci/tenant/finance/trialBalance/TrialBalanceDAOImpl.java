package com.dci.tenant.finance.trialBalance;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CommonUtilityQueryUtil;

@Repository
// @Transactional("tenantTransactionManager")
public class TrialBalanceDAOImpl implements TrialBalanceDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(TrialBalanceDAOImpl.class);

	@Resource
	private DataSource dataSource;

	@Override
	public List<SelectivityBean> getCompanyList() {
		List<SelectivityBean> companyList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			companyList = jdbcTemplate.query(TrialBalanceQueryUtil.GET_COMPANY_LIST, new BeanPropertyRowMapper<>(SelectivityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return companyList;
	}

	@Override
	public List<SelectivityBean> getSubGroupList() {
		List<SelectivityBean> lSubGroupList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lSubGroupList = jdbcTemplate.query(TrialBalanceQueryUtil.GET_SUBGRP_LIST, new BeanPropertyRowMapper<>(SelectivityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return lSubGroupList;
	}

	@Override
	public List<SelectivityBean> getAccountHeadList(String subGroupCode) {
		List<SelectivityBean> lSubGroupList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lSubGroupList = jdbcTemplate.query(TrialBalanceQueryUtil.GET_ACCOUNTHEAD_LIST, new Object[] { subGroupCode }, new BeanPropertyRowMapper<>(SelectivityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Account Head List", e);
		}
		return lSubGroupList;
	}

	@Override
	public List<SelectivityBean> getSubAccountList() {
		List<SelectivityBean> lSubGroupList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lSubGroupList = jdbcTemplate.query(TrialBalanceQueryUtil.GET_SUBACCOUNT_LIST, new BeanPropertyRowMapper<>(SelectivityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getSubAccountList List", e);
		}
		return lSubGroupList;
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceSGList(TrialBalanceBean objTrialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceSGList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			String compCode = "'";

			if (objTrialBalanceBean.getCompanyCode() == null || objTrialBalanceBean.getCompanyCode().isEmpty()) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_OWNERS_COMPANY);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else {
				compCode += objTrialBalanceBean.getCompanyCode();
			}
			compCode += "'";

			if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
				String sDynamicQuery = TrialBalanceQueryUtil.GET_TB_SG_LEVEL_LIST;
				String sDynamicQuery1 = TrialBalanceQueryUtil.Sub_QUERY;
				sDynamicQuery += " from fn_trial_balance_sg_new(" + compCode + ",to_date('" + objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY')" + ",to_date('" + objTrialBalanceBean.getToDate() + "','DD-MM-YYYY')) " + sDynamicQuery1;

				if (objTrialBalanceBean.getSubGroupCode() != null && !objTrialBalanceBean.getSubGroupCode().isEmpty()) {
					sDynamicQuery += " where subGroupCode='" + objTrialBalanceBean.getSubGroupCode() + "' ";
				}

				lTrialBalanceSGList = jdbcTemplate.query(sDynamicQuery, new BeanPropertyRowMapper<>(TrialBalanceBean.class));
				System.out.print(sDynamicQuery);
			} else {
				String sDynamicQuery = TrialBalanceQueryUtil.GET_TB_SG_LEVEL_LIST_NEW;
				sDynamicQuery += " from fn_trial_balance_sg(" + compCode + ",to_date('" + objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY'),to_date('" + objTrialBalanceBean.getToDate() + "','DD-MM-YYYY'))";

				if (objTrialBalanceBean.getSubGroupCode() != null && !objTrialBalanceBean.getSubGroupCode().isEmpty()) {
					sDynamicQuery += " where SUB_GROUP_CODE='" + objTrialBalanceBean.getSubGroupCode() + "' ";
				}
				lTrialBalanceSGList = jdbcTemplate.query(sDynamicQuery, new BeanPropertyRowMapper<>(TrialBalanceBean.class));
				System.out.print(sDynamicQuery);

			}

			// lTrialBalanceSGList =
			// jdbcTemplate.query(TrialBalanceQueryUtil.getTbList(compCode,
			// objTrialBalanceBean.getFromDate(),
			// objTrialBalanceBean.getToDate()), new
			// BeanPropertyRowMapper<TrialBalanceBean>(TrialBalanceBean.class));

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lTrialBalanceSGList;
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceSGList1(TrialBalanceBean objTrialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceSGList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			String compCode = "'";
			//for company code
			if (objTrialBalanceBean.getCompanyCode() == null || objTrialBalanceBean.getCompanyCode().isEmpty()) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_OWNERS_COMPANY);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else {
				compCode += objTrialBalanceBean.getCompanyCode();
			}
			compCode += "'";

			String sDynamicQuery = TrialBalanceQueryUtil.GET_TB_SG_LEVEL_LIST_NEW;
			sDynamicQuery += " from fn_trial_balance_sg_tb(" + compCode + ",to_date('" + objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY'),to_date('" + objTrialBalanceBean.getToDate() + "','DD-MM-YYYY'),'" + objTrialBalanceBean.getSubGroupCode() + "','" + objTrialBalanceBean.getAcctHeadId() + "','" + objTrialBalanceBean.getSubAccountFilterId() + "','" + objTrialBalanceBean.getCostCenter() + "')";

			/*
			 * if (objTrialBalanceBean.getSubGroupCode() != null &&
			 * !objTrialBalanceBean.getSubGroupCode().isEmpty()) { sDynamicQuery
			 * += " where SUB_GROUP_CODE='" +
			 * objTrialBalanceBean.getSubGroupCode() + "' "; }
			 */
			lTrialBalanceSGList = jdbcTemplate.query(sDynamicQuery, new BeanPropertyRowMapper<>(TrialBalanceBean.class));
			System.out.print("my Query -   "+sDynamicQuery);

			// lTrialBalanceSGList =
			// jdbcTemplate.query(TrialBalanceQueryUtil.getTbList(compCode,
			// objTrialBalanceBean.getFromDate(),
			// objTrialBalanceBean.getToDate()), new
			// BeanPropertyRowMapper<TrialBalanceBean>(TrialBalanceBean.class));

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lTrialBalanceSGList;
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceSGListRPSplitup(TrialBalanceBean objTrialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceSGList = new ArrayList<>();
		List<TrialBalanceBean> lTrialBalanceEXCLRPSGList = new ArrayList<>();
		List<TrialBalanceBean> lTrialBalanceRPONLYSGList = new ArrayList<>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String compCode = "'";
		if (objTrialBalanceBean.getCompanyCode() == null || objTrialBalanceBean.getCompanyCode().isEmpty()) {
			List<String> lCompany = new ArrayList<>();
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_OWNERS_COMPANY);
			for (Map row : rows) {
				lCompany.add((String) row.get("COMPANY_ID"));
			}

			for (int i = 0; i < lCompany.size(); i++) {
				if (compCode == "'") {
					compCode += lCompany.get(i);
				} else {
					compCode += "," + lCompany.get(i);
				}
			}

		} else if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
			List<String> lCompany = new ArrayList<>();
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
			for (Map row : rows) {
				lCompany.add((String) row.get("COMPANY_ID"));
			}

			for (int i = 0; i < lCompany.size(); i++) {
				if (compCode == "'") {
					compCode += lCompany.get(i);
				} else {
					compCode += "," + lCompany.get(i);
				}
			}

		} else {
			compCode += objTrialBalanceBean.getCompanyCode();
		}
		compCode += "'";
		String sDynamicQueryExclRP = TrialBalanceQueryUtil.GET_TB_SG_LEVEL_LIST;
		sDynamicQueryExclRP += " ,'N' as relatedParty from fn_trial_balance_sg_excl_rp(" + compCode + ",to_date('" + objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY'),to_date('" + objTrialBalanceBean.getToDate() + "','DD-MM-YYYY'))";

		if (objTrialBalanceBean.getSubGroupCode() != null && !objTrialBalanceBean.getSubGroupCode().isEmpty()) {
			sDynamicQueryExclRP += " where SUB_GROUP_CODE='" + objTrialBalanceBean.getSubGroupCode() + "' ";
		}

		lTrialBalanceEXCLRPSGList = jdbcTemplate.query(sDynamicQueryExclRP, new BeanPropertyRowMapper<>(TrialBalanceBean.class));

		lTrialBalanceSGList.addAll(lTrialBalanceEXCLRPSGList);

		TrialBalanceBean objBean = new TrialBalanceBean();
		objBean.setSubGroupCode("RELATED PARTY");
		lTrialBalanceSGList.add(objBean);

		String sDynamicQueryRPOnly = TrialBalanceQueryUtil.GET_TB_SG_LEVEL_LIST;
		sDynamicQueryRPOnly += " ,'Y' as relatedParty from fn_trial_balance_sg_rp_only(" + compCode + ",to_date('" + objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY'),to_date('" + objTrialBalanceBean.getToDate() + "','DD-MM-YYYY'))";

		if (objTrialBalanceBean.getSubGroupCode() != null && !objTrialBalanceBean.getSubGroupCode().isEmpty()) {
			sDynamicQueryRPOnly += " where SUB_GROUP_CODE='" + objTrialBalanceBean.getSubGroupCode() + "' ";
		}

		lTrialBalanceRPONLYSGList = jdbcTemplate.query(sDynamicQueryRPOnly, new BeanPropertyRowMapper<>(TrialBalanceBean.class));
		lTrialBalanceSGList.addAll(lTrialBalanceRPONLYSGList);

		return lTrialBalanceSGList;
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceAHLevel1(TrialBalanceBean objTrialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceAHList = new ArrayList<>();
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			String whereCond = "";
			String query = null;

			whereCond = search(objTrialBalanceBean);

			if (!whereCond.isEmpty() && whereCond != "") {
				/*
				 * query =
				 * " select account_code as acctHeadCode,coalesce(AH.acct_head_name,'')"
				 * +
				 * " || coalesce(cust.entity_name,'') || coalesce(supp.entity_name,'') "
				 * + "as acctHeadName," +
				 * " SUM(TC_DEBIT) as tcDebit, SUM(TC_CREDIT) as" +
				 * " tcCredit, case when (SUM(BC_DEBIT)-SUM(BC_CREDIT))>1 then (SUM(BC_DEBIT)-SUM(BC_CREDIT)) else 0 end as debitAmount, "
				 * +
				 * " case when (SUM(BC_DEBIT)-SUM(BC_CREDIT))<1 then -(SUM(BC_DEBIT)-SUM(BC_CREDIT)) else 0 end as creditAmount, (SUM(bc_debit) - SUM(bc_credit)) as"
				 * + " currentBalance, (SUM(TC_DEBIT)- " + "SUM(TC_CREDIT)) as "
				 * + "currentBalance " + " from general_ledger gl left join" +
				 * "" + " account_head_master AH on AH.acct_head_code" + " " +
				 * "= gl.account_code " + " left join entity" +
				 * " cust on cust.customer_acct_code = gl.account_code" +
				 * " left join entity supp on supp.supplier_acct_code = gl.account_code"
				 * + " " + " where 1=1 " + whereCond + " " + "" +
				 * " group by account_code,AH.acct_head_name," + " " + "" +
				 * " cust.entity_name,supp.entity_name order by" + "" +
				 * " account_code ";
				 */
				query = "select * From vw_tb_firstbreakup(?,?,?,?,?,?,?)";
				if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
					String compcode = "'C0002,C0009,C0010,C0011,C0012'";
					/// whereCond += " and gl.company_id IN (" + compcode + ")";

					lTrialBalanceAHList = jdbcTemplate.query(query, new Object[]

					{ compcode, objTrialBalanceBean.getFromDate(), objTrialBalanceBean.getToDate(), objTrialBalanceBean.getFilterCode(), objTrialBalanceBean.getSubGroupCode(), objTrialBalanceBean.getAcctHeadId(), objTrialBalanceBean.getSubAccountFilterId()

					},

							new BeanPropertyRowMapper<>(TrialBalanceBean.class));
				} else {

					lTrialBalanceAHList = jdbcTemplate.query(query, new Object[]

					{ objTrialBalanceBean.getCompanyCode(), objTrialBalanceBean.getFromDate(), objTrialBalanceBean.getToDate(), objTrialBalanceBean.getFilterCode(), objTrialBalanceBean.getSubGroupCode(), objTrialBalanceBean.getAcctHeadId(), objTrialBalanceBean.getSubAccountFilterId()

					},

							new BeanPropertyRowMapper<>(TrialBalanceBean.class));
				}

			}

		} catch (DataAccessException | SQLException e) {
			e.printStackTrace();
		}
		return lTrialBalanceAHList;
	}

	public String search(TrialBalanceBean objTrialBalanceBean) throws SQLException {

		String whereCond = "";

		if (objTrialBalanceBean.getCompanyCode() != null && !objTrialBalanceBean.getCompanyCode().isEmpty()) {

			if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
				String compcode = "'C0008','C0009','C0010','C0011','C0012'";
				whereCond += "  and gl.company_id IN (" + compcode + ")";
			} else {
				whereCond += "  and gl.company_id IN ('" + objTrialBalanceBean.getCompanyCode() + "')";
			}
		}
		if (objTrialBalanceBean.getFromDate() != null && !objTrialBalanceBean.getFromDate().isEmpty()) {
			whereCond += " and ledger_date::date >= TO_DATE('" + objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY')";

		}
		if (objTrialBalanceBean.getToDate() != null && !objTrialBalanceBean.getToDate().isEmpty()) {
			whereCond += " and ledger_date::date <= TO_DATE('" + objTrialBalanceBean.getToDate() + "','DD-MM-YYYY')";

		}
		if (objTrialBalanceBean.getFilterCode() != null && !objTrialBalanceBean.getFilterCode().isEmpty()) {
			whereCond += " and parent_code like '" + objTrialBalanceBean.getFilterCode() + "'";

		}
		if (objTrialBalanceBean.getSubGroupCode() != null && !objTrialBalanceBean.getSubGroupCode().isEmpty()) {
			whereCond += " and gl.parent_code = '" + objTrialBalanceBean.getSubGroupCode() + "'";

		}
		if (objTrialBalanceBean.getAcctHeadId() != null && !objTrialBalanceBean.getAcctHeadId().isEmpty()) {
			whereCond += " and gl.account_code = '" + objTrialBalanceBean.getAcctHeadId() + "'";

		}
		if (objTrialBalanceBean.getSubAccountFilterId() != null && !objTrialBalanceBean.getSubAccountFilterId().isEmpty()) {
			whereCond += " and gl.sub_account_code = '" + objTrialBalanceBean.getSubAccountFilterId() + "'";

		}

		return whereCond;
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceAHLevel(TrialBalanceBean objTrialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceAHList = new ArrayList<>();
		try {

			String compCode = "", subGroupCode = "", mainAcctCode = "", subAcctCode = "";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {

				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "") {
						compCode += lCompany.get(i);
					} else {
						compCode += "','" + lCompany.get(i);
					}
				}

			} else {
				String companyCodes[] = objTrialBalanceBean.getCompanyCode().split(",");
				for (int i = 0; i < companyCodes.length; i++) {
					if (compCode == "") {
						compCode = companyCodes[i];
					} else {
						compCode += "','" + companyCodes[i];
					}
				}
			}
			System.out.println(compCode);
			if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
				String query = "select   acctHeadCode,acctHeadName,coalesce(C0008_openingbalancebc,0) as C0008_openingbalancebc,coalesce(C0008_totalbcdebit,0) as C0008_totalbcdebit ,coalesce(C0008_totalbccredit,0) as "
						+ "C0008_totalbccredit,coalesce(C0008_closingbalancebc,0) as C0008_closingbalancebc,coalesce(C0009_openingbalancebc,0) as C0009_openingbalancebc ,coalesce(C0009_totalbcdebit,0) as C0009_totalbcdebit ,coalesce(C0009_totalbccredit,0) as C0009_totalbccredit,coalesce(C0009_closingbalancebc,0) as C0009_closingbalancebc , coalesce(C0010_openingbalancebc,0) as C0010_openingbalancebc ,coalesce(C0010_totalbcdebit,0) as C0010_totalbcdebit, coalesce(C0010_totalbccredit,0) as C0010_totalbccredit,coalesce(C0010_closingbalancebc,0) as C0010_closingbalancebc,coalesce(C0011_openingbalancebc,0) as C0011_openingbalancebc,coalesce(C0011_totalbcdebit,0)as C0011_totalbcdebit, coalesce(C0011_totalbccredit,0) as C0011_totalbccredit, coalesce(C0011_closingbalancebc,0)as C0011_closingbalancebc,coalesce(C0012_openingbalancebc,0) as C0012_openingbalancebc,coalesce(C0012_totalbcdebit,0) as C0012_totalbcdebit,coalesce(C0012_totalbccredit,0)asC0012_totalbccredit ,coalesce(C0012_closingbalancebc,0) as C0012_closingbalancebc from crosstab( $$SELECT account_code as acctHeadCode,acct_head_name acctHeadName,    unnest(array[concat(gl.company_id,'_openingbalancebc'),     concat(gl.company_id,'_totalbcdebit'),concat(gl.company_id,'_totalbccredit')    ,concat(gl.company_id,'_closingbalancebc')]) AS Values,    unnest(array[SUM(TC_CREDIT) ,SUM(BC_DEBIT), SUM(BC_CREDIT),(SUM(bc_debit) - SUM(bc_credit))]) AS Count from   general_ledger gl left join account_head_master AH on AH.acct_head_code = gl.account_code 					 left join entity cust on cust.customer_acct_code = gl.account_code left join entity supp on supp.supplier_acct_code = gl.account_code where gl.company_id in ('C0008','C0009','C0010','C0011','C0012') and ledger_date::date >= TO_DATE( '"
						+ objTrialBalanceBean.getFromDate() + "' ,'DD-MM-YYYY') and ledger_date::date <= TO_DATE( '" + objTrialBalanceBean.getToDate() + "','DD-MM-YYYY') and parent_code like   '" + objTrialBalanceBean.getFilterCode()
						+ "'   					 group by account_code,gl.company_id,AH.acct_head_name, cust.entity_name,supp.entity_name order by account_code 					   $$, 					 $$VALUES ('C0008_openingbalancebc'),('C0008_totalbcdebit'),('C0008_totalbccredit'),('C0008_closingbalancebc') 					 ,  ('C0009_openingbalancebc'),('C0009_totalbcdebit'),('C0009_totalbccredit'),('C0009_closingbalancebc') 					 , ('C0010_openingbalancebc'),('C0010_totalbcdebit'),('C0010_totalbccredit'),('C0010_closingbalancebc') , 					 ('C0011_openingbalancebc'),('C0011_totalbcdebit'),('C0011_totalbccredit'),('C0011_closingbalancebc') , 					 ('C0012_openingbalancebc'),('C0012_totalbcdebit'),('C0012_totalbccredit'),('C0012_closingbalancebc') 					   					 $$ )as 					 ct (  acctHeadCode character varying,acctHeadName  character varying, "
						+ "C0008_openingbalancebc numeric,C0008_totalbcdebit numeric, C0008_totalbccredit numeric,C0008_closingbalancebc numeric,C0009_openingbalancebc numeric, C0009_totalbcdebit numeric,C0009_totalbccredit numeric, C0009_closingbalancebc numeric , C0010_openingbalancebc numeric, C0010_totalbcdebit numeric,C0010_totalbccredit numeric, C0010_closingbalancebc numeric, C0011_openingbalancebc numeric, C0011_totalbcdebit numeric,C0011_totalbccredit numeric, C0011_closingbalancebc numeric ,C0012_openingbalancebc numeric, C0012_totalbcdebit numeric,C0012_totalbccredit numeric, C0012_closingbalancebc numeric)";

				lTrialBalanceAHList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(TrialBalanceBean.class));
				System.out.println(query);

			} else {
				if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
					String compcode = "'C0008','C0009','C0010','C0011','C0012'";

					lTrialBalanceAHList = jdbcTemplate.query(TrialBalanceQueryUtil.GET_VIEW_REPORT2_QUERY, new Object[] { compcode, objTrialBalanceBean.getFromDate(), objTrialBalanceBean.getToDate(), objTrialBalanceBean.getFilterCode() }, new BeanPropertyRowMapper<>(TrialBalanceBean.class));

				} else {
					String compcode = objTrialBalanceBean.getCompanyCode();
					lTrialBalanceAHList = jdbcTemplate.query(TrialBalanceQueryUtil.GET_VIEW_REPORT2_QUERY, new Object[] { compcode, objTrialBalanceBean.getFromDate(), objTrialBalanceBean.getToDate(), objTrialBalanceBean.getFilterCode() }, new BeanPropertyRowMapper<>(TrialBalanceBean.class));

				}

			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lTrialBalanceAHList;
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceAHLevelRPonly(TrialBalanceBean objTrialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceAHList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String compCode = "'";
			if (objTrialBalanceBean.getCompanyCode() == null || objTrialBalanceBean.getCompanyCode().isEmpty()) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_OWNERS_COMPANY);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_CODE"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_CODE"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else {
				compCode += objTrialBalanceBean.getCompanyCode();
			}
			compCode += "'";

			String sDynamicQuery = TrialBalanceQueryUtil.GET_TB_AH_LEVEL_LIST;

			sDynamicQuery += " from fn_trial_balance_ah_rp_only(" + compCode + ",to_date('" + objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY'),to_date('" + objTrialBalanceBean.getToDate() + "','DD-MM-YYYY'))";

			if (objTrialBalanceBean.getFilterCode() != null && !objTrialBalanceBean.getFilterCode().isEmpty()) {
				sDynamicQuery += " where substr(acct_head_code,1,4)='" + objTrialBalanceBean.getFilterCode() + "' ";
			}

			lTrialBalanceAHList = jdbcTemplate.query(sDynamicQuery, new BeanPropertyRowMapper<>(TrialBalanceBean.class));
			System.out.print(sDynamicQuery);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return lTrialBalanceAHList;
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceAHLevelExcludeRp(TrialBalanceBean objTrialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceAHList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String compCode = "'";
			if (objTrialBalanceBean.getCompanyCode() == null || objTrialBalanceBean.getCompanyCode().isEmpty()) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_OWNERS_COMPANY);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else {
				compCode += objTrialBalanceBean.getCompanyCode();
			}
			compCode += "'";

			String sDynamicQuery = TrialBalanceQueryUtil.GET_TB_AH_LEVEL_LIST;

			sDynamicQuery += " from fn_trial_balance_ah_excl_rp(" + compCode + ",to_date('" + objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY'),to_date('" + objTrialBalanceBean.getToDate() + "','DD-MM-YYYY'))";

			if (objTrialBalanceBean.getFilterCode() != null && !objTrialBalanceBean.getFilterCode().isEmpty()) {
				sDynamicQuery += " where substr(acct_head_code,1,4)='" + objTrialBalanceBean.getFilterCode() + "' ";
			}

			lTrialBalanceAHList = jdbcTemplate.query(sDynamicQuery, new BeanPropertyRowMapper<>(TrialBalanceBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return lTrialBalanceAHList;
	}

	/*
	 * @Override public List<TrialBalanceBean>
	 * getTrialBalanceSALevel(TrialBalanceBean objTrialBalanceBean) {
	 * List<TrialBalanceBean> lTrialBalanceSALevelList = new ArrayList<>();
	 * 
	 * try { JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); String
	 * compCode = "'"; if (objTrialBalanceBean.getCompanyCode() == null ||
	 * objTrialBalanceBean.getCompanyCode().isEmpty()) { List<String> lCompany =
	 * new ArrayList<>(); List<Map<String, Object>> rows =
	 * jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_OWNERS_COMPANY); for
	 * (Map row : rows) { lCompany.add((String) row.get("COMPANY_ID")); }
	 * 
	 * for (int i = 0; i < lCompany.size(); i++) { if (compCode == "'") {
	 * compCode += lCompany.get(i); } else { compCode += "," + lCompany.get(i);
	 * } }
	 * 
	 * } else { compCode += objTrialBalanceBean.getCompanyCode(); } compCode +=
	 * "'";
	 * 
	 * 
	 * String sDynamicQuery = TrialBalanceQueryUtil.GET_TB_SA_LEVEL_LIST;
	 * 
	 * if (objTrialBalanceBean.getAcctHeadCode() != null &&
	 * !objTrialBalanceBean.getAcctHeadCode().isEmpty()) { sDynamicQuery +=
	 * " from fn_trial_balance_sa_new(" + compCode + ",to_date('" +
	 * objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY'),to_date('" +
	 * objTrialBalanceBean.getToDate() + "','DD-MM-YYYY'),'" +
	 * objTrialBalanceBean.getAcctHeadCode() + "')";
	 * 
	 * sDynamicQuery += " where subaccountcode !=''";
	 * 
	 * } else {
	 * 
	 * sDynamicQuery += " from fn_trial_balance_sa(" + compCode + ",to_date('" +
	 * objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY'),to_date('" +
	 * objTrialBalanceBean.getToDate() + "','DD-MM-YYYY'))";
	 * 
	 * sDynamicQuery += " where subaccountcode !=''";
	 * 
	 * }
	 * 
	 * lTrialBalanceSALevelList = jdbcTemplate.query(sDynamicQuery, new
	 * BeanPropertyRowMapper<>(TrialBalanceBean.class));
	 * 
	 * lTrialBalanceSALevelList =
	 * jdbcTemplate.query(TrialBalanceQueryUtil.GET_VIEW_REPORT3_QUERY, new
	 * Object[] { compCode, objTrialBalanceBean.getAcctHeadCode(),
	 * objTrialBalanceBean.getFromDate(), objTrialBalanceBean.getToDate() }, new
	 * BeanPropertyRowMapper<>(TrialBalanceBean.class));
	 * 
	 * // System.out.print(sDynamicQuery); } catch (DataAccessException e) {
	 * e.printStackTrace(); }
	 * 
	 * return lTrialBalanceSALevelList; }
	 */
	@Override
	public List<TrialBalanceBean> getTrialBalanceSALevel(TrialBalanceBean objTrialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceSALevelList = new ArrayList<>();
		try {

			String compCode = "", subGroupCode = "", mainAcctCode = "", subAcctCode = "";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			compCode = "'C0008','C0009','C0010','C0011','C0012'";
			/*
			 * if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL"))
			 * {
			 * 
			 * List<String> lCompany = new ArrayList<>(); List<Map<String,
			 * Object>> rows =
			 * jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
			 * for (Map row : rows) { lCompany.add((String)
			 * row.get("COMPANY_ID")); }
			 * 
			 * for (int i = 0; i < lCompany.size(); i++) { if (compCode == "") {
			 * compCode += lCompany.get(i); } else { compCode += "," +
			 * lCompany.get(i); } }
			 * 
			 * } else { String companyCodes[] =
			 * objTrialBalanceBean.getCompanyCode().split(","); for (int i = 0;
			 * i < companyCodes.length; i++) { if (compCode == "") { compCode =
			 * companyCodes[i]; } else { compCode += "," + companyCodes[i]; } }
			 * }
			 */
			/*
			 * String groupCode = ""; if (objGeneralLedgerBean.getGroupCode() !=
			 * "" && objGeneralLedgerBean.getGroupCode() != null) { String
			 * groupCodes[] = objGeneralLedgerBean.getGroupCode().split(",");
			 * for (int i = 0; i < groupCodes.length; i++) { if (groupCode ==
			 * "") { groupCode = groupCodes[i]; } else { groupCode += "," +
			 * groupCodes[i]; } } } if (objGeneralLedgerBean.getSubGroupCode()
			 * != "") subGroupCode = objGeneralLedgerBean.getSubGroupCode();
			 * else subGroupCode = null; if
			 * (objGeneralLedgerBean.getMainAccountCode() != "") mainAcctCode =
			 * objGeneralLedgerBean.getMainAccountCode(); else mainAcctCode =
			 * null; if (objGeneralLedgerBean.getSubAccountCode() != "")
			 * subAcctCode = objGeneralLedgerBean.getSubAccountCode(); else
			 * subAcctCode = null;
			 * 
			 * String sDynamicQuery =
			 * GeneralLedgerQueryUtil.GET_GENERAL_LEDGER_LIST_AH_LEVEL;
			 * 
			 * if (groupCode != "") { sDynamicQuery += groupCode; }
			 * 
			 * if (objGeneralLedgerBean.getMainAccountCode() != "") {
			 * sDynamicQuery += " AND trim(GL.ACCOUNT_HEAD) = '" +
			 * objGeneralLedgerBean.getMainAccountCode() + "'"; }
			 * 
			 * if (objGeneralLedgerBean.getSubAccountCode() != "") {
			 * if(objGeneralLedgerBean.getMainAccountCode().equals("10070004")
			 * || objGeneralLedgerBean.getMainAccountCode().equals("10050001")
			 * || objGeneralLedgerBean.getMainAccountCode().equals("10050002")
			 * || objGeneralLedgerBean.getMainAccountCode().equals("50060004"))
			 * sDynamicQuery += " AND trim(GL.vessel_code) = '" +
			 * objGeneralLedgerBean.getSubAccountCode() + "'"; else
			 * sDynamicQuery += " AND trim(GL.SUB_ACCOUNT_CODE) = '" +
			 * objGeneralLedgerBean.getSubAccountCode() + "'"; } sDynamicQuery
			 * += " AND trim(COMPANY_CODE) in ("+compCode+")"; sDynamicQuery +=
			 * " GROUP BY GL.ACCOUNT_HEAD,AH.ACCT_HEAD_NAME ";
			 * 
			 * if (objGeneralLedgerBean.getSubAccountCode() != null &&
			 * objGeneralLedgerBean.getSubAccountCode() != "") { if
			 * (isNum(objGeneralLedgerBean.getSubAccountCode())) {
			 * 
			 * System.out.println("up:" +
			 * objGeneralLedgerBean.getSubAccountCode());
			 * 
			 * } else {
			 * 
			 * System.out.println("down:" +
			 * objGeneralLedgerBean.getSubAccountCode()); subAcctCode =
			 * jdbcTemplate
			 * .queryForObject(GeneralLedgerQueryUtil.get_acct_head_code, new
			 * Object[] { objGeneralLedgerBean.getSubAccountCode() },
			 * String.class); System.out.println("getcode:" + subAcctCode); } }
			 */
			// lGeneralLedgerAHList =
			// jdbcTemplate.query(GeneralLedgerQueryUtil.GET_VIEW_REPORT2, new
			// Object[] { compCode, objGeneralLedgerBean.getFromDate(),
			// objGeneralLedgerBean.getToDate(), subGroupCode, mainAcctCode,
			// subAcctCode }, new
			// BeanPropertyRowMapper<GeneralLedgerBean>(GeneralLedgerBean.class));
			if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
				String query = ""
						+ "select  acctHeadCode,acctHeadName,subAccountCode,subgroup,coalesce(C0008_openingbalancebc,0) as C0008_openingbalancebc,coalesce(C0008_totalbcdebit,0) as C0008_totalbcdebit ,coalesce(C0008_totalbccredit,0) as C0008_totalbccredit,coalesce(C0008_closingbalancebc,0) as C0008_closingbalancebc,coalesce(C0009_openingbalancebc,0) as C0009_openingbalancebc ,coalesce(C0009_totalbcdebit,0) as C0009_totalbcdebit ,coalesce(C0009_totalbccredit,0) as C0009_totalbccredit,coalesce(C0009_closingbalancebc,0) as C0009_closingbalancebc , coalesce(C0010_openingbalancebc,0) as C0010_openingbalancebc ,coalesce(C0010_totalbcdebit,0) as C0010_totalbcdebit, coalesce(C0010_totalbccredit,0) as C0010_totalbccredit,coalesce(C0010_closingbalancebc,0) as C0010_closingbalancebc,coalesce(C0011_openingbalancebc,0) as C0011_openingbalancebc,coalesce(C0011_totalbcdebit,0)as C0011_totalbcdebit, coalesce(C0011_totalbccredit,0) as C0011_totalbccredit, coalesce(C0011_closingbalancebc,0)as C0011_closingbalancebc,coalesce(C0012_openingbalancebc,0) as C0012_openingbalancebc,coalesce(C0012_totalbcdebit,0) as C0012_totalbcdebit,coalesce(C0012_totalbccredit,0)asC0012_totalbccredit ,coalesce(C0012_closingbalancebc,0) as C0012_closingbalancebc from crosstab( $$SELECT account_code as acctHeadCode,acct_head_name as acctHeadName, SUB_ACCOUNT_CODE as subAccountCode,    GL.parent_code as subgroup, unnest(array[concat(gl.company_id,'_openingbalancebc'),     concat(gl.company_id,'_totalbcdebit'),concat(gl.company_id,'_totalbccredit')    ,concat(gl.company_id,'_closingbalancebc')]) AS Values,  unnest(array[sum(TC_DEBIT), SUM(TC_CREDIT) ,SUM(BC_DEBIT), SUM(BC_CREDIT),(SUM(bc_debit) - SUM(bc_credit))]) AS \"Count\" from   general_ledger gl left join account_head_master AH on AH.acct_head_code = gl.account_code left join entity cust on cust.customer_acct_code = gl.account_code left join entity supp on supp.supplier_acct_code = gl.account_code where   gl.account_code= '"
						+ objTrialBalanceBean.getAcctHeadCode() + "' and gl.company_id in ('C0008','C0009','C0010','C0011','C0012') and ledger_date::date >= TO_DATE('" + objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY') and ledger_date::date <= TO_DATE('" + objTrialBalanceBean.getToDate()
						+ "','DD-MM-YYYY')  group by account_code,gl.company_id,AH.acct_head_name, cust.entity_name,supp.entity_name,SUB_ACCOUNT_CODE,GL.parent_code order by account_code   $$, 					 $$VALUES ('C0008_openingbalancebc'),('C0008_totalbcdebit'),('C0008_totalbccredit'),('C0008_closingbalancebc') 					 ,  ('C0009_openingbalancebc'),('C0009_totalbcdebit'),('C0009_totalbccredit'),('C0009_closingbalancebc') 					 , ('C0010_openingbalancebc'),('C0010_totalbcdebit'),('C0010_totalbccredit'),('C0010_closingbalancebc') , 					 ('C0011_openingbalancebc'),('C0011_totalbcdebit'),('C0011_totalbccredit'),('C0011_closingbalancebc') , 					 ('C0012_openingbalancebc'),('C0012_totalbcdebit'),('C0012_totalbccredit'),('C0012_closingbalancebc') 					   					 $$ )as 					 ct (  acctHeadCode character varying,acctHeadName  character varying, subAccountCode character varying,subgroup character varying, "
						+ "C0008_openingbalancebc numeric,C0008_totalbcdebit numeric, C0008_totalbccredit numeric,C0008_closingbalancebc numeric,C0009_openingbalancebc numeric, C0009_totalbcdebit numeric,C0009_totalbccredit numeric, C0009_closingbalancebc numeric , C0010_openingbalancebc numeric, C0010_totalbcdebit numeric,C0010_totalbccredit numeric, C0010_closingbalancebc numeric, C0011_openingbalancebc numeric, C0011_totalbcdebit numeric,C0011_totalbccredit numeric, C0011_closingbalancebc numeric ,C0012_openingbalancebc numeric, C0012_totalbcdebit numeric,C0012_totalbccredit numeric, C0012_closingbalancebc numeric)";
				lTrialBalanceSALevelList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(TrialBalanceBean.class));
				System.out.println(query);
			} else {

				if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
					String compcode = "'C0008','C0009','C0010','C0011','C0012'";
					lTrialBalanceSALevelList = jdbcTemplate.query(TrialBalanceQueryUtil.GET_VIEW_REPORT3_QUERY, new Object[] { compcode, objTrialBalanceBean.getAcctHeadCode(), objTrialBalanceBean.getFromDate(), objTrialBalanceBean.getToDate() }, new BeanPropertyRowMapper<>(TrialBalanceBean.class));

				} else {
					String compcode = objTrialBalanceBean.getCompanyCode();
					lTrialBalanceSALevelList = jdbcTemplate.query(TrialBalanceQueryUtil.GET_VIEW_REPORT3_QUERY, new Object[] { compcode, objTrialBalanceBean.getAcctHeadCode(), objTrialBalanceBean.getFromDate(), objTrialBalanceBean.getToDate() }, new BeanPropertyRowMapper<>(TrialBalanceBean.class));

				}

			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lTrialBalanceSALevelList;
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceSALevel1(TrialBalanceBean objTrialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceSALevelList = new ArrayList<>();
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			String whereCond = "";
			String query = null;

			whereCond = search1(objTrialBalanceBean);

			if (!whereCond.isEmpty() && whereCond != "") {
				query = "Select TO_CHAR(LEDGER_DATE,'DD-MM-YYYY') as ledgerDate,general_ledger_id ledgerNo,account_code as accountHeadCode,   transaction_no as transactionNo, " + "   coalesce(GL.narration , '') as narration,CURRENCY_CODE as currency,   exchange_rate as exchangeRate,  SUB_ACCOUNT_CODE as subAccountCode, " + "   GL.parent_code as subgroup ,   SUM(COALESCE(TC_DEBIT,0)) as tcDebit,SUM(COALESCE(TC_CREDIT,0)) as tcCredit,SUM(COALESCE(BC_DEBIT,0)) as debitAmount, "
						+ "   SUM(COALESCE(BC_CREDIT,0)) as creditAmount,coalesce(e.entity_name,ce.entity_name) as subAccountName " + "from general_ledger GL " + "left join entity e on SUB_ACCOUNT_CODE=e.supplier_acct_code  left join customer_entity ce on SUB_ACCOUNT_CODE=ce.customer_acct_code" + " where 1=1 " + whereCond + " group  by LEDGER_DATE,general_ledger_id,e.entity_name,ce.entity_name ";

				lTrialBalanceSALevelList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(TrialBalanceBean.class));
			}

		} catch (DataAccessException | SQLException e) {
			e.printStackTrace();
		}
		return lTrialBalanceSALevelList;
	}

	public String search1(TrialBalanceBean objTrialBalanceBean) throws SQLException {

		String whereCond = "";

		if (objTrialBalanceBean.getCompanyCode() != null && !objTrialBalanceBean.getCompanyCode().isEmpty()) {

			if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
				String compcode = "'C0008','C0009','C0010','C0011','C0012'";
				whereCond += "  and GL.company_id IN (" + compcode + ")";
			} else {
				whereCond += "  and GL.company_id IN ('" + objTrialBalanceBean.getCompanyCode() + "')";
			}
		}
		if (objTrialBalanceBean.getFromDate() != null && !objTrialBalanceBean.getFromDate().isEmpty()) {
			whereCond += " and GL.ledger_date::date >= TO_DATE('" + objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY')";

		}
		if (objTrialBalanceBean.getToDate() != null && !objTrialBalanceBean.getToDate().isEmpty()) {
			whereCond += " and GL.ledger_date::date <= TO_DATE('" + objTrialBalanceBean.getToDate() + "','DD-MM-YYYY')";

		}
		if (objTrialBalanceBean.getFilterCode() != null && !objTrialBalanceBean.getFilterCode().isEmpty()) {
			whereCond += " and parent_code like '" + objTrialBalanceBean.getFilterCode() + "'";

		}
		if (objTrialBalanceBean.getSubGroupCode() != null && !objTrialBalanceBean.getSubGroupCode().isEmpty()) {
			whereCond += " and GL.parent_code = '" + objTrialBalanceBean.getSubGroupCode() + "'";

		}
		if (objTrialBalanceBean.getAcctHeadId() != null && !objTrialBalanceBean.getAcctHeadId().isEmpty()) {
			whereCond += " and GL.account_code = '" + objTrialBalanceBean.getAcctHeadId() + "'";

		}
		if (objTrialBalanceBean.getSubAccountFilterId() != null && !objTrialBalanceBean.getSubAccountFilterId().isEmpty()) {
			whereCond += " and GL.sub_account_code = '" + objTrialBalanceBean.getSubAccountFilterId() + "'";

		}
		if (objTrialBalanceBean.getAcctHeadCode() != null && !objTrialBalanceBean.getAcctHeadCode().isEmpty()) {
			whereCond += " and GL.account_code='" + objTrialBalanceBean.getAcctHeadCode() + "'";

		}

		return whereCond;
	}

	/*
	 * @Override public List<TrialBalanceBean>
	 * getTrialBalanceSALevel(TrialBalanceBean objTrialBalanceBean) {
	 * List<TrialBalanceBean> lTrialBalanceSALevelList = new
	 * ArrayList<TrialBalanceBean>();
	 * 
	 * try { JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); String
	 * compCode = "'"; if (objTrialBalanceBean.getCompanyCode() == null ||
	 * objTrialBalanceBean.getCompanyCode().isEmpty()) { List<String> lCompany =
	 * new ArrayList<String>(); List<Map<String, Object>> rows =
	 * jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_OWNERS_COMPANY); for
	 * (Map row : rows) { lCompany.add((String) row.get("COMPANY_CODE")); }
	 * 
	 * for (int i = 0; i < lCompany.size(); i++) { if (compCode == "'") {
	 * compCode += lCompany.get(i); } else { compCode += "," + lCompany.get(i);
	 * } }
	 * 
	 * } else if(objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
	 * List<String> lCompany = new ArrayList<String>(); List<Map<String,
	 * Object>> rows =
	 * jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER); for
	 * (Map row : rows) { lCompany.add((String) row.get("COMPANY_CODE")); }
	 * 
	 * for (int i = 0; i < lCompany.size(); i++) { if (compCode == "'") {
	 * compCode += lCompany.get(i); } else { compCode += "," + lCompany.get(i);
	 * } }
	 * 
	 * }else { compCode += objTrialBalanceBean.getCompanyCode(); } compCode +=
	 * "'";
	 * 
	 * String sDynamicQuery=TrialBalanceQueryUtil.GET_TB_SA_LEVEL_LIST;
	 * 
	 * sDynamicQuery += " from fn_trial_balance_sa(" + compCode + ",to_date('" +
	 * objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY'),to_date('" +
	 * objTrialBalanceBean.getToDate() + "','DD-MM-YYYY'))";
	 * 
	 * 
	 * if (objTrialBalanceBean.getAcctHeadCode() != null &&
	 * !objTrialBalanceBean.getAcctHeadCode().isEmpty()) { sDynamicQuery +=
	 * " where accountheadcode ='"+objTrialBalanceBean.getAcctHeadCode()+"' " ;
	 * } //sDynamicQuery += " AND subaccountcode !=''"; lTrialBalanceSALevelList
	 * = jdbcTemplate.query(sDynamicQuery, new
	 * BeanPropertyRowMapper<TrialBalanceBean>(TrialBalanceBean.class)); } catch
	 * (DataAccessException e) { e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * return lTrialBalanceSALevelList; }
	 */

	@Override
	public List<TrialBalanceBean> getTrialBalanceSALevelRPonly(TrialBalanceBean objTrialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceSALevelList = new ArrayList<>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String compCode = "'";
			if (objTrialBalanceBean.getCompanyCode() == null || objTrialBalanceBean.getCompanyCode().isEmpty()) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_OWNERS_COMPANY);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_CODE"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else {
				compCode += objTrialBalanceBean.getCompanyCode();
			}
			compCode += "'";

			String sDynamicQuery = TrialBalanceQueryUtil.GET_TB_SA_LEVEL_LIST;

			sDynamicQuery += " from fn_trial_balance_sa_rp_only(" + compCode + ",to_date('" + objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY'),to_date('" + objTrialBalanceBean.getToDate() + "','DD-MM-YYYY'))";

			if (objTrialBalanceBean.getAcctHeadCode() != null && !objTrialBalanceBean.getAcctHeadCode().isEmpty()) {
				sDynamicQuery += " where accountheadcode ='" + objTrialBalanceBean.getAcctHeadCode() + "' ";
			}

			sDynamicQuery += " AND subaccountcode !=''";

			lTrialBalanceSALevelList = jdbcTemplate.query(sDynamicQuery, new BeanPropertyRowMapper<>(TrialBalanceBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}

		return lTrialBalanceSALevelList;
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceSALevelExcludeRP(TrialBalanceBean objTrialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceSALevelList = new ArrayList<>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String compCode = "'";
			if (objTrialBalanceBean.getCompanyCode() == null || objTrialBalanceBean.getCompanyCode().isEmpty()) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_OWNERS_COMPANY);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_CODE"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_CODE"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else {
				compCode += objTrialBalanceBean.getCompanyCode();
			}
			compCode += "'";

			String sDynamicQuery = TrialBalanceQueryUtil.GET_TB_SA_LEVEL_LIST;

			sDynamicQuery += " from fn_trial_balance_sa_excl_rp(" + compCode + ",to_date('" + objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY'),to_date('" + objTrialBalanceBean.getToDate() + "','DD-MM-YYYY'))";

			if (objTrialBalanceBean.getAcctHeadCode() != null && !objTrialBalanceBean.getAcctHeadCode().isEmpty()) {
				sDynamicQuery += " where accountheadcode ='" + objTrialBalanceBean.getAcctHeadCode() + "' ";
			}

			sDynamicQuery += " AND subaccountcode !=''";

			lTrialBalanceSALevelList = jdbcTemplate.query(sDynamicQuery, new BeanPropertyRowMapper<>(TrialBalanceBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}

		return lTrialBalanceSALevelList;
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceListRPSplit(TrialBalanceBean objTrialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceList = new ArrayList<>();
		try {
			List<TrialBalanceBean> lTrialBalanceSGList = new ArrayList<>();
			lTrialBalanceSGList = getTrialBalanceSGListRPSplitup(objTrialBalanceBean);

			for (TrialBalanceBean objTrialBalanceSGBean : lTrialBalanceSGList) {
				objTrialBalanceSGBean.setFromDate(objTrialBalanceBean.getFromDate());
				objTrialBalanceSGBean.setToDate(objTrialBalanceBean.getToDate());
				objTrialBalanceSGBean.setCompanyCode(objTrialBalanceBean.getCompanyCode());
				List<TrialBalanceBean> lTrialBalanceAHList = new ArrayList<>();
				List<TrialBalanceBean> lTrialBalanceAHtempList = new ArrayList<>();
				if ("RELATED PARTY".equalsIgnoreCase(objTrialBalanceSGBean.getSubGroupCode())) {
					objTrialBalanceSGBean.setlTBAccountHeadLevelList(lTrialBalanceAHList);
					lTrialBalanceList.add(objTrialBalanceSGBean);
				} else {
					if ("Y".equalsIgnoreCase(objTrialBalanceSGBean.getRelatedParty())) {
						objTrialBalanceSGBean.setFilterCode(objTrialBalanceSGBean.getSubGroupCode());
						lTrialBalanceAHtempList = getTrialBalanceAHLevelRPonly(objTrialBalanceSGBean);
					} else {
						objTrialBalanceSGBean.setFilterCode(objTrialBalanceSGBean.getSubGroupCode());
						lTrialBalanceAHtempList = getTrialBalanceAHLevelExcludeRp(objTrialBalanceSGBean);
					}

					for (TrialBalanceBean objTrialBalanceAHBean : lTrialBalanceAHtempList) {
						objTrialBalanceAHBean.setFromDate(objTrialBalanceBean.getFromDate());
						objTrialBalanceAHBean.setToDate(objTrialBalanceBean.getToDate());
						objTrialBalanceAHBean.setCompanyCode(objTrialBalanceBean.getCompanyCode());
						objTrialBalanceAHBean.setFilterCode(objTrialBalanceAHBean.getAcctHeadCode());
						List<TrialBalanceBean> lTransactionList = new ArrayList<>();
						if ("Y".equalsIgnoreCase(objTrialBalanceAHBean.getRelatedParty())) {
							lTransactionList = getTrialBalanceSALevelRPonly(objTrialBalanceAHBean);
						} else {
							lTransactionList = getTrialBalanceSALevelExcludeRP(objTrialBalanceAHBean);
						}

						objTrialBalanceAHBean.setlTBTransactionList(lTransactionList);
						lTrialBalanceAHList.add(objTrialBalanceAHBean);
					}
					objTrialBalanceSGBean.setlTBAccountHeadLevelList(lTrialBalanceAHList);
					lTrialBalanceList.add(objTrialBalanceSGBean);
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return lTrialBalanceList;
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceList(TrialBalanceBean objTrialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceList = new ArrayList<>();
		try {
			List<TrialBalanceBean> lTrialBalanceSGList = new ArrayList<>();

			lTrialBalanceSGList = getTrialBalanceSGList(objTrialBalanceBean);

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			for (TrialBalanceBean objTrialBalanceSGBean : lTrialBalanceSGList) {
				System.out.println(" Sub Group List : " + dateFormat.format(date));
				System.out.println(" Sub Group List Size : " + lTrialBalanceSGList.size());

				List<TrialBalanceBean> lTrialBalanceAHList = new ArrayList<>();
				List<TrialBalanceBean> lTrialBalanceAHtempList = new ArrayList<>();

				objTrialBalanceSGBean.setCompanyCode(objTrialBalanceBean.getCompanyCode());
				objTrialBalanceSGBean.setCompanyName(objTrialBalanceBean.getCompanyName());

				objTrialBalanceSGBean.setFromDate(objTrialBalanceBean.getFromDate());
				objTrialBalanceSGBean.setToDate(objTrialBalanceBean.getToDate());
				objTrialBalanceSGBean.setFilterCode(objTrialBalanceSGBean.getSubGroupCode());

				objTrialBalanceSGBean.setSubAccountId(objTrialBalanceBean.getSubAccountId());
				objTrialBalanceSGBean.setAcctHeadId(objTrialBalanceBean.getAcctHeadId());
				objTrialBalanceSGBean.setSubAccountFilterId(objTrialBalanceBean.getSubAccountFilterId());

				lTrialBalanceAHtempList = getTrialBalanceAHLevel(objTrialBalanceSGBean);
				Date date1 = new Date();
				System.out.println(" ACC Head List : " + dateFormat.format(date1));
				System.out.println(" ACC Head List Size : " + lTrialBalanceAHtempList.size());
				for (TrialBalanceBean objTrialBalanceAHBean : lTrialBalanceAHtempList) {
					List<TrialBalanceBean> lTransactionList = new ArrayList<>();
					objTrialBalanceAHBean.setCompanyCode(objTrialBalanceBean.getCompanyCode());
					objTrialBalanceAHBean.setCompanyName(objTrialBalanceBean.getCompanyName());

					objTrialBalanceAHBean.setFromDate(objTrialBalanceBean.getFromDate());
					objTrialBalanceAHBean.setToDate(objTrialBalanceBean.getToDate());
					objTrialBalanceAHBean.setFilterCode(objTrialBalanceSGBean.getAcctHeadCode());

					objTrialBalanceAHBean.setSubAccountId(objTrialBalanceBean.getSubAccountId());
					objTrialBalanceAHBean.setAcctHeadId(objTrialBalanceBean.getAcctHeadId());
					objTrialBalanceAHBean.setSubAccountFilterId(objTrialBalanceBean.getSubAccountFilterId());

					lTransactionList = getTrialBalanceSALevel(objTrialBalanceAHBean);
					objTrialBalanceAHBean.setlTBTransactionList(lTransactionList);
					lTrialBalanceAHList.add(objTrialBalanceAHBean);
					Date date2 = new Date();
					System.out.println(" Sub Acc List : " + dateFormat.format(date2));
					System.out.println(" Sub Acc List Size : " + lTransactionList.size());
				}

				objTrialBalanceSGBean.setlTBAccountHeadLevelList(lTrialBalanceAHList);
				lTrialBalanceList.add(objTrialBalanceSGBean);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lTrialBalanceList;
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceList1(TrialBalanceBean objTrialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceList = new ArrayList<>();
		try {
			List<TrialBalanceBean> lTrialBalanceSGList = new ArrayList<>();

			lTrialBalanceSGList = getTrialBalanceSGList1(objTrialBalanceBean);

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			for (TrialBalanceBean objTrialBalanceSGBean : lTrialBalanceSGList) {
				System.out.println(" Sub Group List : " + dateFormat.format(date));
				System.out.println(" Sub Group List Size : " + lTrialBalanceSGList.size());

				List<TrialBalanceBean> lTrialBalanceAHList = new ArrayList<>();
				List<TrialBalanceBean> lTrialBalanceAHtempList = new ArrayList<>();

				objTrialBalanceSGBean.setCompanyCode(objTrialBalanceBean.getCompanyCode());
				objTrialBalanceSGBean.setCompanyName(objTrialBalanceBean.getCompanyName());

				objTrialBalanceSGBean.setFromDate(objTrialBalanceBean.getFromDate());
				objTrialBalanceSGBean.setToDate(objTrialBalanceBean.getToDate());
				objTrialBalanceSGBean.setFilterCode(objTrialBalanceSGBean.getSubGroupCode());

				objTrialBalanceSGBean.setSubAccountId(objTrialBalanceBean.getSubAccountId());
				objTrialBalanceSGBean.setAcctHeadId(objTrialBalanceBean.getAcctHeadId());
				objTrialBalanceSGBean.setSubAccountFilterId(objTrialBalanceBean.getSubAccountFilterId());

				lTrialBalanceAHtempList = getTrialBalanceAHLevel1(objTrialBalanceSGBean);
				Date date1 = new Date();
				System.out.println(" ACC Head List : " + dateFormat.format(date1));
				System.out.println(" ACC Head List Size : " + lTrialBalanceAHtempList.size());
				for (TrialBalanceBean objTrialBalanceAHBean : lTrialBalanceAHtempList) {
					List<TrialBalanceBean> lTransactionList = new ArrayList<>();
					objTrialBalanceAHBean.setCompanyCode(objTrialBalanceBean.getCompanyCode());
					objTrialBalanceAHBean.setCompanyName(objTrialBalanceBean.getCompanyName());

					objTrialBalanceAHBean.setFromDate(objTrialBalanceBean.getFromDate());
					objTrialBalanceAHBean.setToDate(objTrialBalanceBean.getToDate());
					objTrialBalanceAHBean.setFilterCode(objTrialBalanceSGBean.getAcctHeadCode());

					objTrialBalanceAHBean.setSubAccountId(objTrialBalanceBean.getSubAccountId());
					objTrialBalanceAHBean.setAcctHeadId(objTrialBalanceBean.getAcctHeadId());
					objTrialBalanceAHBean.setSubAccountFilterId(objTrialBalanceBean.getSubAccountFilterId());

					lTransactionList = getTrialBalanceSALevel1(objTrialBalanceAHBean);
					objTrialBalanceAHBean.setlTBTransactionList(lTransactionList);
					lTrialBalanceAHList.add(objTrialBalanceAHBean);
					Date date2 = new Date();
					System.out.println(" Sub Acc List : " + dateFormat.format(date2));
					System.out.println(" Sub Acc List Size : " + lTransactionList.size());
				}

				objTrialBalanceSGBean.setlTBAccountHeadLevelList(lTrialBalanceAHList);
				lTrialBalanceList.add(objTrialBalanceSGBean);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lTrialBalanceList;
	}

	// Export Excel by account head
	@Override
	public List<TrialBalanceBean> getTrialBalanceGLList(TrialBalanceBean objTrialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceList = new ArrayList<>();
		try {

			List<TrialBalanceBean> lTrialBalanceAHtempList = new ArrayList<>();

			lTrialBalanceAHtempList = getTrialBalanceAHFilterLevel(objTrialBalanceBean);

			for (TrialBalanceBean objTrialBalanceAHBean : lTrialBalanceAHtempList) {
				List<TrialBalanceBean> lSALevelTempList = new ArrayList<>();
				List<TrialBalanceBean> lSALevelList = new ArrayList<>();
				objTrialBalanceAHBean.setCompanyCode(objTrialBalanceBean.getCompanyCode());
				objTrialBalanceAHBean.setFromDate(objTrialBalanceBean.getFromDate());
				objTrialBalanceAHBean.setToDate(objTrialBalanceBean.getToDate());
				objTrialBalanceAHBean.setFilterCode(objTrialBalanceAHBean.getAcctHeadCode());
				objTrialBalanceAHBean.setFilterSubAccountCode(objTrialBalanceBean.getSubAccountCode());
				objTrialBalanceAHBean.setAcctHeadCode(objTrialBalanceBean.getAcctHeadCode());
				lSALevelTempList = getTrialBalanceSAFilterLevel(objTrialBalanceAHBean);

				if (lSALevelTempList.size() > 0) {
					for (TrialBalanceBean objTrialBalanceSABean : lSALevelTempList) {
						List<TrialBalanceBean> lTransactionLevelList = new ArrayList<>();
						objTrialBalanceSABean.setCompanyCode(objTrialBalanceBean.getCompanyCode());
						objTrialBalanceSABean.setFromDate(objTrialBalanceBean.getFromDate());
						objTrialBalanceSABean.setToDate(objTrialBalanceBean.getToDate());
						objTrialBalanceSABean.setFilterCode(objTrialBalanceSABean.getSubAccountCode());
						objTrialBalanceSABean.setAcctHeadCode(objTrialBalanceSABean.getAcctHeadCode());
						objTrialBalanceSABean.setFilterSubAccountCode(objTrialBalanceBean.getSubAccountCode());
						lTransactionLevelList = getTransactionLevelList(objTrialBalanceSABean);
						objTrialBalanceSABean.setlSATransactionLevelList(lTransactionLevelList);
						lSALevelList.add(objTrialBalanceSABean);

					}
				} else {
					TrialBalanceBean objTrialBalanceSABean = new TrialBalanceBean();
					objTrialBalanceSABean.setCompanyCode(objTrialBalanceBean.getCompanyCode());
					objTrialBalanceSABean.setFromDate(objTrialBalanceBean.getFromDate());
					objTrialBalanceSABean.setToDate(objTrialBalanceBean.getToDate());
					objTrialBalanceSABean.setFilterCode(objTrialBalanceSABean.getSubAccountCode());
					objTrialBalanceSABean.setAcctHeadCode(objTrialBalanceAHBean.getAcctHeadCode());

					List<TrialBalanceBean> lTransactionLevelList = new ArrayList<>();
					lTransactionLevelList = getTransactionLevelListSA(objTrialBalanceSABean);
					objTrialBalanceSABean.setlSATransactionLevelList(lTransactionLevelList);
					lSALevelList.add(objTrialBalanceSABean);
				}

				objTrialBalanceAHBean.setlTBTransactionList(lSALevelList);
				lTrialBalanceList.add(objTrialBalanceAHBean);

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return lTrialBalanceList;
	}

	public List<TrialBalanceBean> getTrialBalanceAHFilterLevel(TrialBalanceBean objTrialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceAHList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String compCode = "'";
			if (objTrialBalanceBean.getCompanyCode() == null || objTrialBalanceBean.getCompanyCode().isEmpty()) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_OWNERS_COMPANY);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else {
				compCode += objTrialBalanceBean.getCompanyCode();
			}
			compCode += "'";
			System.out.println("");
			String sDynamicQuery = TrialBalanceQueryUtil.GET_TB_AH_LEVEL_LIST;

			sDynamicQuery += " from fn_trial_balance_ah(" + compCode + ",to_date('" + objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY'),to_date('" + objTrialBalanceBean.getToDate() + "','DD-MM-YYYY')) where acct_head_code is not null ";

			if (objTrialBalanceBean.getFilterCode() != null && !objTrialBalanceBean.getFilterCode().isEmpty()) {
				sDynamicQuery += " and substr(acct_head_code,1,4)='" + objTrialBalanceBean.getFilterCode() + "' ";
			}
			if (objTrialBalanceBean.getAcctHeadCode() != null && !objTrialBalanceBean.getAcctHeadCode().isEmpty()) {
				sDynamicQuery += " and acct_head_code ='" + objTrialBalanceBean.getAcctHeadCode() + "' ";
			}
			lTrialBalanceAHList = jdbcTemplate.query(sDynamicQuery, new BeanPropertyRowMapper<>(TrialBalanceBean.class));

			System.out.println("sDynamicQuery" + sDynamicQuery);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return lTrialBalanceAHList;
	}

	public List<TrialBalanceBean> getTrialBalanceSAFilterLevel(TrialBalanceBean objTrialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceSALevelList = new ArrayList<>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String compCode = "'";
			if (objTrialBalanceBean.getCompanyCode() == null || objTrialBalanceBean.getCompanyCode().isEmpty()) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_OWNERS_COMPANY);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else {
				compCode += objTrialBalanceBean.getCompanyCode();
			}
			compCode += "'";

			String sDynamicQuery = TrialBalanceQueryUtil.GET_TB_SA_LEVEL_LIST;

			sDynamicQuery += " from fn_trial_balance_sa(" + compCode + ",to_date('" + objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY'),to_date('" + objTrialBalanceBean.getToDate() + "','DD-MM-YYYY'))";

			if (objTrialBalanceBean.getAcctHeadCode() != null && !objTrialBalanceBean.getAcctHeadCode().isEmpty()) {
				sDynamicQuery += " where accountheadcode ='" + objTrialBalanceBean.getAcctHeadCode() + "' ";
			}
			sDynamicQuery += " where subaccountcode !=''";

			if (objTrialBalanceBean.getFilterSubAccountCode() != null && !objTrialBalanceBean.getFilterSubAccountCode().isEmpty()) {
				if (objTrialBalanceBean.getAcctHeadCode().equals("10070004") || objTrialBalanceBean.getAcctHeadCode().equals("10050001") || objTrialBalanceBean.getAcctHeadCode().equals("10050002") || objTrialBalanceBean.getAcctHeadCode().equals("50060004") || objTrialBalanceBean.getAcctHeadCode().equals("50000002"))
					sDynamicQuery += " AND trim(vessel_code) = '" + objTrialBalanceBean.getSubAccountCode() + "'";
				else
					sDynamicQuery += " AND subaccountcode ='" + objTrialBalanceBean.getSubAccountCode() + "' ";
			}

			if (objTrialBalanceBean.getSubAccountCode() != null && !objTrialBalanceBean.getSubAccountCode().isEmpty()) {
				if (objTrialBalanceBean.getAcctHeadCode().equals("10070004") || objTrialBalanceBean.getAcctHeadCode().equals("10050001") || objTrialBalanceBean.getAcctHeadCode().equals("10050002") || objTrialBalanceBean.getAcctHeadCode().equals("50060004") || objTrialBalanceBean.getAcctHeadCode().equals("50000002"))
					sDynamicQuery += " AND trim(vessel_code) = '" + objTrialBalanceBean.getSubAccountCode() + "'";
				else
					sDynamicQuery += " AND subaccountcode ='" + objTrialBalanceBean.getSubAccountCode() + "' ";
			}

			lTrialBalanceSALevelList = jdbcTemplate.query(sDynamicQuery, new BeanPropertyRowMapper<>(TrialBalanceBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}

		return lTrialBalanceSALevelList;
	}

	private List<TrialBalanceBean> getTransactionLevelList(TrialBalanceBean objTrialBalanceSABean) {
		List<TrialBalanceBean> lTrialBalanceTransactionLevelList = new ArrayList<>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String compCode = "'";
			if (objTrialBalanceSABean.getCompanyCode() == null || objTrialBalanceSABean.getCompanyCode().isEmpty()) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_OWNERS_COMPANY);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i) + "'";
					} else {
						compCode += "," + lCompany.get(i) + "'";
					}
				}

			} else if (objTrialBalanceSABean.getCompanyCode().equalsIgnoreCase("ALL")) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i) + "'";
					} else {
						compCode += "," + "'" + lCompany.get(i) + "'";
					}
				}

			} else {
				compCode += objTrialBalanceSABean.getCompanyCode() + "'";

			}

			String sDynamicQuery = TrialBalanceQueryUtil.GET_TRANSACTION_LIST;

			sDynamicQuery += " AND company_code in (" + compCode + ")";

			if (objTrialBalanceSABean.getFilterSubAccountCode() != null && !objTrialBalanceSABean.getFilterSubAccountCode().isEmpty()) {
				sDynamicQuery += " AND sub_account_code = '" + objTrialBalanceSABean.getFilterSubAccountCode() + "'";
			}

			lTrialBalanceTransactionLevelList = jdbcTemplate.query(sDynamicQuery, new Object[] { objTrialBalanceSABean.getAcctHeadCode(), objTrialBalanceSABean.getSubAccountCode(), objTrialBalanceSABean.getFromDate(), objTrialBalanceSABean.getToDate() }, new BeanPropertyRowMapper<>(TrialBalanceBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}

		return lTrialBalanceTransactionLevelList;
	}

	private List<TrialBalanceBean> getTransactionLevelListSA(TrialBalanceBean objTrialBalanceSABean) {
		List<TrialBalanceBean> lTrialBalanceTransactionLevelList = new ArrayList<>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String compCode = "'";
			if (objTrialBalanceSABean.getCompanyCode() == null || objTrialBalanceSABean.getCompanyCode().isEmpty()) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_OWNERS_COMPANY);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else if (objTrialBalanceSABean.getCompanyCode().equalsIgnoreCase("ALL")) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else {
				compCode += objTrialBalanceSABean.getCompanyCode();
			}
			compCode += "'";

			String sDynamicQuery = TrialBalanceQueryUtil.GET_TRANSACTION_LIST_SA;

			sDynamicQuery += " AND company_code in (" + compCode + ")";
			lTrialBalanceTransactionLevelList = jdbcTemplate.query(sDynamicQuery, new Object[] { objTrialBalanceSABean.getAcctHeadCode(), objTrialBalanceSABean.getFromDate(), objTrialBalanceSABean.getToDate() }, new BeanPropertyRowMapper<>(TrialBalanceBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return lTrialBalanceTransactionLevelList;
	}

	private List<TrialBalanceBean> exportTBExcelWithPlain(TrialBalanceBean objTrialBalanceSABean) {
		List<TrialBalanceBean> lTrialBalanceTransactionLevelList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String compCode = "'";
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return lTrialBalanceTransactionLevelList;
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceListWithPlain(TrialBalanceBean trialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceTransactionLevelList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String compCode = "'";
			if (trialBalanceBean.getCompanyCode() == null || trialBalanceBean.getCompanyCode().isEmpty()) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_OWNERS_COMPANY);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_CODE"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else if (trialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_CODE"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "'") {
						compCode += lCompany.get(i);
					} else {
						compCode += "," + lCompany.get(i);
					}
				}

			} else {
				compCode += trialBalanceBean.getCompanyCode();
			}
			compCode += "'";
			String sDynamicQuery = TrialBalanceQueryUtil.GET_TB_WITH_PLAIN;
			lTrialBalanceTransactionLevelList = jdbcTemplate.query(sDynamicQuery, new Object[] { compCode, trialBalanceBean.getFromDate(), trialBalanceBean.getToDate() }, new BeanPropertyRowMapper<>(TrialBalanceBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return lTrialBalanceTransactionLevelList;
	}

		@Override
		public List<SelectivityBean> getAccountList() {
			List<SelectivityBean> lSubGroupList = new ArrayList<>();
			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				//lSubGroupList = jdbcTemplate.query(TrialBalanceQueryUtil.GET_ACCOUNTHEAD_LIST, new Object[] { subGroupCode }, new BeanPropertyRowMapper<>(SelectivityBean.class));
				lSubGroupList = jdbcTemplate.query(TrialBalanceQueryUtil.GET_ACCOUNTHEAD_LIST1, new BeanPropertyRowMapper<>(SelectivityBean.class));

			} catch (DataAccessException e) {
				LOGGER.error("Error in Get Account Head List", e);
			}
			return lSubGroupList;
		}
	
}