package com.dci.tenant.finance.profitAndLoss;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CommonUtil;

@Repository
public class ProfitAndLossDaoImpl implements ProfitAndLossDao {

	private final static Logger LOGGER = LoggerFactory.getLogger(ProfitAndLossDaoImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<ProfitAndLossBean> generatePLReport1(ProfitAndLossBean objProfitAndLossBean) {
		List<ProfitAndLossBean> lPLHdrList = new ArrayList<>();
		try {
			if (objProfitAndLossBean.getCompany().equalsIgnoreCase("ALL")) {

				String query = " select gh.group_head_code as groupHeadCode,gh.group_head_name as groupHeadName,gh.group_head_code groupHeadType, " + " sum(gl.bc_credit)  as creditAmount, sum(gl.bc_debit) as debitAmount " + "  from (sub_group_acct_master sga inner join " + " group_head_master gh on sga.group_head_code =gh.group_head_code) inner join general_ledger gl " + " on sga.sub_group_acct_code = gl.parent_code where gl.ledger_date between " + "  TO_DATE('" + objProfitAndLossBean.getFromDate() + "','DD-MM-YYYY') and TO_DATE('"
						+ objProfitAndLossBean.getToDate() + "','DD-MM-YYYY') and gl.company_id in ('C0008','C0009','C0010','C0011','C0012') and " + " (gh. group_head_code='I' or gh. group_head_code='E') " + " group by gh.group_head_code,gh.group_head_name,gh.group_head_code " + " order by gh.group_head_code ";

				lPLHdrList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));
			} else {
				lPLHdrList = jdbcTemplate.query(ProfitAndLossQueryUtil.GET_PL_HDR, new Object[] { CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getFromDate()), CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getToDate()), objProfitAndLossBean.getCompany() }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));

			}

		} catch (DataAccessException e) {

		}
		return lPLHdrList;
	}

	@Override
	public List<ProfitAndLossBean> generatePLReport(ProfitAndLossBean objProfitAndLossBean) {
		List<ProfitAndLossBean> lPLHdrList = new ArrayList<>();
		try {
			if (objProfitAndLossBean.getCompany().equalsIgnoreCase("ALL")) {

				String query = "" + "select  * from crosstab( " + "$$" + "select gh.group_head_code as groupHeadCode,gh.group_head_name as groupHeadName,gh.group_head_code groupHeadType, " + "unnest(array[concat(gl.company_id,'_creditAmount'), concat(gl.company_id,'_debitAmount')]) AS \"Values\", " + "unnest(array[sum(gl.bc_credit), SUM(gl.bc_debit)]) AS \"Count\" "
						+ "        from (sub_group_acct_master sga inner join    group_head_master gh on sga.group_head_code =gh.group_head_code) inner join general_ledger gl    on sga.sub_group_acct_code = gl.parent_code where gl.ledger_date between  to_date('" + objProfitAndLossBean.getFromDate() + "','dd/mm/yyyy') and to_date('" + objProfitAndLossBean.getToDate() + "','dd/mm/yyyy') and gl.company_id in " + "('C0008','C0009','C0010','C0011','C0012') and "
						+ "			  (gh. group_head_code='I' or gh. group_head_code='E')    group by gh.group_head_code,gh.group_head_name,gh.group_head_code,gl.company_id    order by gh.group_head_code " + "			  $$, " + "$$VALUES ('C0008_creditAmount'),('C0008_debitAmount'),('C0009_creditAmount'),('C0009_debitAmount') " + ",  ('C0010_creditAmount'),('C0010_debitAmount'),('C0011_creditAmount'),('C0011_debitAmount'),('C0012_creditAmount') " + ",  ('C0012_debitAmount') $$ )as "
						+ "ct(groupHeadCode character varying,groupHeadName character varying,groupHeadType character varying,\"C0008_creditAmount\" character varying,\"C0008_debitAmount\" character varying, " + "\"C0009_creditAmount\" character varying,\"C0009_debitAmount\" character varying,\"C0010_creditAmount\" character varying, " + "\"C0010_debitAmount\" character varying,\"C0011_creditAmount\" character varying,\"C0011_debitAmount\" character varying,\"C0012_creditAmount\" character varying,\"C0012_debitAmount\" character varying )";

				lPLHdrList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));
			} else {
				lPLHdrList = jdbcTemplate.query(ProfitAndLossQueryUtil.GET_PL_HDR, new Object[] { CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getFromDate()), CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getToDate()), objProfitAndLossBean.getCompany() }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));

			}

		} catch (DataAccessException e) {

		}
		return lPLHdrList;
	}

	@Override
	public List<ProfitAndLossBean> generatePLReportDtl(ProfitAndLossBean objProfitAndLossBean) {
		List<ProfitAndLossBean> lPLDtlList = new ArrayList<>();
		try {

			lPLDtlList = jdbcTemplate.query(ProfitAndLossQueryUtil.GET_PL_DTL, new Object[] { CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getFromDate()), CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getToDate()), objProfitAndLossBean.getCompany(), objProfitAndLossBean.getGroupHeadCode() }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));
		} catch (DataAccessException e) {

		}
		return lPLDtlList;
	}

	@Override
	public List<ProfitAndLossBean> generatePLReportAHDtl(ProfitAndLossBean objProfitAndLossBean) {
		List<ProfitAndLossBean> lPLAHDtlList = new ArrayList<>();
		try {

			lPLAHDtlList = jdbcTemplate.query(ProfitAndLossQueryUtil.GET_PLAH_DTL, new Object[] { CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getFromDate()), CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getToDate()), objProfitAndLossBean.getCompany(), objProfitAndLossBean.getGroupHeadCode() }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));
		} catch (DataAccessException e) {

		}
		return lPLAHDtlList;
	}

	@Override
	public List<ProfitAndLossBean> generatePLReportDtl1(ProfitAndLossBean objProfitAndLossBean) {
		List<ProfitAndLossBean> lPLDtlList = new ArrayList<>();
		try {
			if (objProfitAndLossBean.getCompany().equalsIgnoreCase("ALL")) {

				String query = " select parent_code as groupHeadCode ,sga.sub_group_acct_name as groupHeadname ,sum(gl.bc_credit) as creditAmount, " + " sum(gl.bc_debit) as debitAmount  from (sub_group_acct_master sga inner join " + " group_head_master gh on sga.group_head_code =gh.group_head_code) inner join general_ledger gl " + " on sga.sub_group_acct_code = gl.parent_code where gl.ledger_date between " + "   to_date('" + objProfitAndLossBean.getFromDate() + "','dd/mm/yyyy') and to_date('" + objProfitAndLossBean.getToDate()
						+ "','dd/mm/yyyy') and gl.company_id in " + "('C0008','C0009','C0010','C0011','C0012')  and " + " (gh. group_head_code='I' or gh. group_head_code='E') and  parent_code like '" + objProfitAndLossBean.getGroupHeadCode() + "' " + "  group by parent_code,sga.sub_group_acct_name  order by gl.parent_code ";

				lPLDtlList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));

			} else {
				lPLDtlList = jdbcTemplate.query(ProfitAndLossQueryUtil.GET_PL_DTL, new Object[] { CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getFromDate()), CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getToDate()), objProfitAndLossBean.getCompany(), objProfitAndLossBean.getGroupHeadCode() }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));

			}
		} catch (DataAccessException e) {

		}
		return lPLDtlList;
	}

	@Override
	public List<ProfitAndLossBean> generatePLReportAHDtl1(ProfitAndLossBean objProfitAndLossBean) {
		List<ProfitAndLossBean> lPLAHDtlList = new ArrayList<>();
		try {

			if (objProfitAndLossBean.getCompany().equalsIgnoreCase("ALL")) {
				String query = " select account_code as groupHeadCode ,ah.acct_head_name as groupHeadname ," + "sum(gl.bc_credit) as creditAmount, " + "  sum(gl.bc_debit) as debitAmount  from  general_ledger gl " + "" + " left join account_head_master " + "ah on ah.acct_head_code=gl.account_code " + "" + " where gl.ledger_date between   to_date('" + objProfitAndLossBean.getFromDate() + "','dd/mm/yyyy') and to_date('" + objProfitAndLossBean.getToDate() + "','dd/mm/yyyy') and gl.company_id in "
						+ "('C0008','C0009','C0010','C0011','C0012')  and gl.parent_code ='" + objProfitAndLossBean.getGroupHeadCode() + "' " + "" + " group by account_code,ah.acct_head_name";
				lPLAHDtlList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));

			} else {
				lPLAHDtlList = jdbcTemplate.query(ProfitAndLossQueryUtil.GET_PLAH_DTL, new Object[] { CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getFromDate()), CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getToDate()), objProfitAndLossBean.getCompany(), objProfitAndLossBean.getGroupHeadCode() }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));

			}

		} catch (DataAccessException e) {

		}
		return lPLAHDtlList;
	}

	@Override
	public List<ProfitAndLossBean> getProfitLossReportList1(ProfitAndLossBean objProfitAndLossBean) {
		List<ProfitAndLossBean> lProfitAndLossList = new ArrayList<>();
		try {
			List<ProfitAndLossBean> lTempProfitAndLossList = new ArrayList<>();
			lTempProfitAndLossList = generatePLReport(objProfitAndLossBean);

			for (ProfitAndLossBean objProfitAndLossFirstBean : lTempProfitAndLossList) {
				List<ProfitAndLossBean> lProfitLossSGList = new ArrayList<>();
				List<ProfitAndLossBean> lProfitLossSGTempList = new ArrayList<>();
				String sSubGroupCode = "";
				if ("E".equalsIgnoreCase(objProfitAndLossFirstBean.getGroupHeadCode()))
					sSubGroupCode = "400%";
				else
					sSubGroupCode = "300%";
				if (objProfitAndLossBean.getCompany().equalsIgnoreCase("ALL")) {

					String query = "" + "select  * from crosstab( " + "$$"

							+ "select parent_code as groupHeadCode ,sga.sub_group_acct_name as groupHeadname , " + " " + "unnest(array[concat(gl.company_id,'_creditAmount'), concat(gl.company_id,'_debitAmount')]) AS \"Values\", " + "unnest(array[sum(gl.bc_credit), SUM(gl.bc_debit)]) AS \"Count\" " + "  from (sub_group_acct_master sga inner join  group_head_master gh on sga.group_head_code =gh.group_head_code) inner join general_ledger gl  on sga.sub_group_acct_code = gl.parent_code where gl.ledger_date between to_date('"
							+ objProfitAndLossBean.getFromDate() + "','dd/mm/yyyy') and to_date('" + objProfitAndLossBean.getToDate() + "','dd/mm/yyyy')  and gl.company_id in ('C0008','C0009','C0010','C0011','C0012')  and (gh. group_head_code='I' or gh. group_head_code='E') and  parent_code like '" + sSubGroupCode + "' " + "			  group by parent_code,sga.sub_group_acct_name,gl.company_id order by gl.parent_code " + " " + "			  $$, " + "$$VALUES ('C0008_creditAmount'),('C0008_debitAmount'),('C0009_creditAmount'),('C0009_debitAmount') "
							+ ",  ('C0010_creditAmount'),('C0010_debitAmount'),('C0011_creditAmount'),('C0011_debitAmount'),('C0012_creditAmount') " + ",  ('C0012_debitAmount') $$ )as " + "ct(groupHeadCode character varying,groupHeadName character varying,\"C0008_creditAmount\" character varying,\"C0008_debitAmount\" character varying, " + "\"C0009_creditAmount\" character varying,\"C0009_debitAmount\" character varying,\"C0010_creditAmount\" character varying, "
							+ "\"C0010_debitAmount\" character varying,\"C0011_creditAmount\" character varying,\"C0011_debitAmount\" character varying,\"C0012_creditAmount\" character varying,\"C0012_debitAmount\" character varying )";
					lProfitLossSGTempList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));
				} else {
					lProfitLossSGTempList = jdbcTemplate.query(ProfitAndLossQueryUtil.GET_PL_DTL, new Object[] { CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getFromDate()), CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getToDate()), objProfitAndLossBean.getCompany(), sSubGroupCode }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));

				}
				for (ProfitAndLossBean objProfitAndLossSecondBean : lProfitLossSGTempList) {
					List<ProfitAndLossBean> lProfitLossAHList = new ArrayList<>();
					if (objProfitAndLossBean.getCompany().equalsIgnoreCase("ALL")) {
						String query = "" + "select  * from crosstab( " + "$$"

								+ "select account_code as groupHeadCode ,ah.acct_head_name as groupHeadname , " + "unnest(array[concat(gl.company_id,'_creditAmount'), concat(gl.company_id,'_debitAmount')]) AS \"Values\", " + "unnest(array[sum(gl.bc_credit), SUM(gl.bc_debit)]) AS \"Count\" " + " " + "  from  general_ledger gl  left join account_head_master ah on ah.acct_head_code=gl.account_code  where gl.ledger_date between to_date('" + objProfitAndLossBean.getFromDate() + "','dd/mm/yyyy') and to_date('" + objProfitAndLossBean.getToDate()
								+ "','dd/mm/yyyy')  and gl.company_id in ('C0008','C0009','C0010','C0011','C0012')   and gl.parent_code = '" + objProfitAndLossSecondBean.getGroupHeadCode() + "' group by account_code,ah.acct_head_name ,gl.company_id " + "    $$, " + "    $$VALUES ('C0008_creditAmount'),('C0008_debitAmount'),('C0009_creditAmount'),('C0009_debitAmount') " + ",  ('C0010_creditAmount'),('C0010_debitAmount'),('C0011_creditAmount'),('C0011_debitAmount'),('C0012_creditAmount') " + ",  ('C0012_debitAmount') $$ )as "
								+ "ct(groupHeadCode character varying,groupHeadName character varying,\"C0008_creditAmount\" character varying,\"C0008_debitAmount\" character varying, " + "\"C0009_creditAmount\" character varying,\"C0009_debitAmount\" character varying,\"C0010_creditAmount\" character varying, " + "\"C0010_debitAmount\" character varying,\"C0011_creditAmount\" character varying,\"C0011_debitAmount\" character varying,\"C0012_creditAmount\" character varying,\"C0012_debitAmount\" character varying )";
						lProfitLossAHList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));

					} else {
						lProfitLossAHList = jdbcTemplate.query(ProfitAndLossQueryUtil.GET_PLAH_DTL, new Object[] { CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getFromDate()), CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getToDate()), objProfitAndLossBean.getCompany(), objProfitAndLossSecondBean.getGroupHeadCode() }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));

					}

					objProfitAndLossSecondBean.setlAccountHeadLevelList(lProfitLossAHList);
					lProfitLossSGList.add(objProfitAndLossSecondBean);
				}
				objProfitAndLossFirstBean.setlSubGroupLevelList(lProfitLossSGList);
				lProfitAndLossList.add(objProfitAndLossFirstBean);
			}
		} catch (DataAccessException e) {

		}
		return lProfitAndLossList;
	}

	@Override
	public List<ProfitAndLossBean> getProfitLossReportList(ProfitAndLossBean objProfitAndLossBean) {
		List<ProfitAndLossBean> lProfitAndLossList = new ArrayList<>();
		try {
			List<ProfitAndLossBean> lTempProfitAndLossList = new ArrayList<>();
			lTempProfitAndLossList = generatePLReport(objProfitAndLossBean);

			for (ProfitAndLossBean objProfitAndLossFirstBean : lTempProfitAndLossList) {
				List<ProfitAndLossBean> lProfitLossSGList = new ArrayList<>();
				List<ProfitAndLossBean> lProfitLossSGTempList = new ArrayList<>();
				String sSubGroupCode = "";
				if ("E".equalsIgnoreCase(objProfitAndLossFirstBean.getGroupHeadCode()))
					sSubGroupCode = "400%";
				else
					sSubGroupCode = "300%";
				if (objProfitAndLossBean.getCompany().equalsIgnoreCase("ALL")) {

					String query = "" + "select  * from crosstab( " + "$$"

							+ "select parent_code as groupHeadCode ,sga.sub_group_acct_name as groupHeadname , " + " " + "unnest(array[concat(gl.company_id,'_creditAmount'), concat(gl.company_id,'_debitAmount')]) AS \"Values\", " + "unnest(array[sum(gl.bc_credit), SUM(gl.bc_debit)]) AS \"Count\" " + "  from (sub_group_acct_master sga inner join  group_head_master gh on sga.group_head_code =gh.group_head_code) inner join general_ledger gl  on sga.sub_group_acct_code = gl.parent_code where gl.ledger_date between to_date('"
							+ objProfitAndLossBean.getFromDate() + "','dd/mm/yyyy') and to_date('" + objProfitAndLossBean.getToDate() + "','dd/mm/yyyy')  and gl.company_id in ('C0008','C0009','C0010','C0011','C0012')  and (gh. group_head_code='I' or gh. group_head_code='E') and  parent_code like '" + sSubGroupCode + "' " + "			  group by parent_code,sga.sub_group_acct_name,gl.company_id order by gl.parent_code " + " " + "			  $$, " + "$$VALUES ('C0008_creditAmount'),('C0008_debitAmount'),('C0009_creditAmount'),('C0009_debitAmount') "
							+ ",  ('C0010_creditAmount'),('C0010_debitAmount'),('C0011_creditAmount'),('C0011_debitAmount'),('C0012_creditAmount') " + ",  ('C0012_debitAmount') $$ )as " + "ct(groupHeadCode character varying,groupHeadName character varying,\"C0008_creditAmount\" character varying,\"C0008_debitAmount\" character varying, " + "\"C0009_creditAmount\" character varying,\"C0009_debitAmount\" character varying,\"C0010_creditAmount\" character varying, "
							+ "\"C0010_debitAmount\" character varying,\"C0011_creditAmount\" character varying,\"C0011_debitAmount\" character varying,\"C0012_creditAmount\" character varying,\"C0012_debitAmount\" character varying )";
					lProfitLossSGTempList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));
				} else {
					lProfitLossSGTempList = jdbcTemplate.query(ProfitAndLossQueryUtil.GET_PL_DTL, new Object[] { CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getFromDate()), CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getToDate()), objProfitAndLossBean.getCompany(), sSubGroupCode }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));

				}
				for (ProfitAndLossBean objProfitAndLossSecondBean : lProfitLossSGTempList) {
					List<ProfitAndLossBean> lProfitLossAHList = new ArrayList<>();
					if (objProfitAndLossBean.getCompany().equalsIgnoreCase("ALL")) {
						String query = "" + "select  * from crosstab( " + "$$"

								+ "select account_code as groupHeadCode ,ah.acct_head_name as groupHeadname , " + "unnest(array[concat(gl.company_id,'_creditAmount'), concat(gl.company_id,'_debitAmount')]) AS \"Values\", " + "unnest(array[sum(gl.bc_credit), SUM(gl.bc_debit)]) AS \"Count\" " + " " + "  from  general_ledger gl  left join account_head_master ah on ah.acct_head_code=gl.account_code  where gl.ledger_date between to_date('" + objProfitAndLossBean.getFromDate() + "','dd/mm/yyyy') and to_date('" + objProfitAndLossBean.getToDate()
								+ "','dd/mm/yyyy')  and gl.company_id in ('C0008','C0009','C0010','C0011','C0012')   and gl.parent_code = '" + objProfitAndLossSecondBean.getGroupHeadCode() + "' group by account_code,ah.acct_head_name ,gl.company_id " + "    $$, " + "    $$VALUES ('C0008_creditAmount'),('C0008_debitAmount'),('C0009_creditAmount'),('C0009_debitAmount') " + ",  ('C0010_creditAmount'),('C0010_debitAmount'),('C0011_creditAmount'),('C0011_debitAmount'),('C0012_creditAmount') " + ",  ('C0012_debitAmount') $$ )as "
								+ "ct(groupHeadCode character varying,groupHeadName character varying,\"C0008_creditAmount\" character varying,\"C0008_debitAmount\" character varying, " + "\"C0009_creditAmount\" character varying,\"C0009_debitAmount\" character varying,\"C0010_creditAmount\" character varying, " + "\"C0010_debitAmount\" character varying,\"C0011_creditAmount\" character varying,\"C0011_debitAmount\" character varying,\"C0012_creditAmount\" character varying,\"C0012_debitAmount\" character varying )";
						lProfitLossAHList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));

					} else {
						lProfitLossAHList = jdbcTemplate.query(ProfitAndLossQueryUtil.GET_PLAH_DTL, new Object[] { CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getFromDate()), CommonUtil.convertSqlDateFormat(objProfitAndLossBean.getToDate()), objProfitAndLossBean.getCompany(), objProfitAndLossSecondBean.getGroupHeadCode() }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));

					}

					objProfitAndLossSecondBean.setlAccountHeadLevelList(lProfitLossAHList);
					lProfitLossSGList.add(objProfitAndLossSecondBean);
				}
				objProfitAndLossFirstBean.setlSubGroupLevelList(lProfitLossSGList);
				lProfitAndLossList.add(objProfitAndLossFirstBean);
			}
		} catch (DataAccessException e) {

		}
		return lProfitAndLossList;
	}

	@Override
	public ProfitAndLossBean getProfitLossTransactions(String accountHeadCode, String fromDate, String toDate) {
		ProfitAndLossBean profitlossbean = new ProfitAndLossBean();
		List<ProfitAndLossBean> profitLossTransactions = new ArrayList<>();
		profitLossTransactions = jdbcTemplate.query(ProfitAndLossQueryUtil.getProfitLossTransaction, new BeanPropertyRowMapper<>(ProfitAndLossBean.class), accountHeadCode, CommonUtil.convertSqlDateFormat(fromDate), CommonUtil.convertSqlDateFormat(toDate));
		profitlossbean.setlProfitLossTransaction(profitLossTransactions);
		return profitlossbean;

	}
}
