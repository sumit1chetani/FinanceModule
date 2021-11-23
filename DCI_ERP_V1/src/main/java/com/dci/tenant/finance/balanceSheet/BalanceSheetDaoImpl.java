package com.dci.tenant.finance.balanceSheet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CommonUtil;
import com.dci.tenant.finance.generalInvoice.GeneralInvoiceQueryUtil;
import com.dci.tenant.user.UserDetail;

@Repository
public class BalanceSheetDaoImpl implements BalanceSheetDao {

	private final static Logger LOGGER = LoggerFactory.getLogger(BalanceSheetDaoImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<SelectivityBean> getCompanyList() {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<SelectivityBean> companyList = new ArrayList<>();
		try {

			companyList = jdbcTemplate.query(GeneralInvoiceQueryUtil.GET_COMPANY_LIST, new BeanPropertyRowMapper<>(SelectivityBean.class), userDetails.getCompanyCode());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return companyList;

	}

	@Override
	public List<BalanceSheetBean> getBalanceSheetList(BalanceSheetBean objBalanceSheetBean) {

		List<BalanceSheetBean> lTempBalanceSheetList = new ArrayList<>();
		List<BalanceSheetBean> lBalanceSheetList = new ArrayList<>();
		double dProfitLoss = 0.0;
		try {

			List<Map<String, Object>> locnNameRows = jdbcTemplate.queryForList(BalanceSheetQueryUtil.GET_PROFIT_OR_LOSS, new Object[] { CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate()), objBalanceSheetBean.getCompany(), objBalanceSheetBean.getCostCenter()});
			for (Map row : locnNameRows) {
				dProfitLoss = (Double) row.get("balance");
			}
			if (objBalanceSheetBean.getCompany().equalsIgnoreCase("ALL")) {
				String query = "" + "select  * from crosstab( " + "$$" + "SELECT group_head_master.group_head_code as groupHeadCode,group_head_master.group_head_name as groupHeadName, group_head_master.group_head_code as groupHeadType, " + "unnest(array[concat(general_ledger.company_id,'_amount')]) AS \"Values\", " + "unnest(array[case when group_head_master.group_head_code='A' then  sum(general_ledger.bc_credit) - sum(general_ledger.bc_debit) else  sum(general_ledger.bc_debit) - sum(general_ledger.bc_credit) end]) AS \"Count\" "
						+ "  FROM   (general_ledger  INNER JOIN sub_group_acct_master ON " + "			 general_ledger.parent_code=sub_group_acct_master.sub_group_acct_code) INNER JOIN group_head_master ON sub_group_acct_master.group_head_code=group_head_master.group_head_code  WHERE  (group_head_master.group_head_code='A' OR group_head_master.group_head_code='L') and general_ledger.ledger_date< to_date('" + objBalanceSheetBean.getFromDate()
						+ "','dd/mm/yyyy')   and  cost_center = ('" + objBalanceSheetBean.getCostCenter() + "') and  general_ledger.company_id in ('C0008','C0009','C0010','C0011','C0012') group by  group_head_master.group_head_code,group_head_master.group_head_name,group_head_master.group_head_code ,general_ledger.company_id  order by group_head_master.group_head_code " + " $$, " + "    $$VALUES ('C0008_amount'),('C0009_amount'),('C0010_amount'),('C0011_amount') " + ",  ('C0012_amount') $$ )as "
						+ "ct(groupHeadCode character varying,groupHeadName character varying,groupHeadType character varying,\"C0008_amount\" character varying,\"C0009_amount\" character varying, " + "\"C0010_amount\" character varying,\"C0011_amount\" character varying,\"C0012_amount\" character varying )";
				lTempBalanceSheetList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(BalanceSheetBean.class));

			} else {
				lTempBalanceSheetList = jdbcTemplate.query(BalanceSheetQueryUtil.GET_BALANCE_SHEET_HDR, new Object[] { CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate()), objBalanceSheetBean.getCompany(),objBalanceSheetBean.getCostCenter() }, new BeanPropertyRowMapper<>(BalanceSheetBean.class));
			}

			lBalanceSheetList.addAll(lTempBalanceSheetList);

			/*
			 * for (BalanceSheetBean objTempBalanceSheetBean : lTempBalanceSheetList) { if
			 * (dProfitLoss > 0) { if
			 * ("A".equalsIgnoreCase(objTempBalanceSheetBean.getGroupHeadType()) ) {
			 * objTempBalanceSheetBean.setBalance(dProfitLoss +
			 * objTempBalanceSheetBean.getAmount()); } else {
			 * objTempBalanceSheetBean.setBalance(objTempBalanceSheetBean. getAmount()); } }
			 * else if (dProfitLoss < 0) { if
			 * ("L".equalsIgnoreCase(objTempBalanceSheetBean.getGroupHeadType()) ) {
			 * objTempBalanceSheetBean.setBalance(dProfitLoss +
			 * objTempBalanceSheetBean.getAmount()); } else {
			 * objTempBalanceSheetBean.setBalance(objTempBalanceSheetBean. getAmount()); } }
			 * lBalanceSheetList.add(objTempBalanceSheetBean); }
			 */

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lBalanceSheetList;

	}

	@Override
	public List<BalanceSheetBean> getBalanceSheetList1(BalanceSheetBean objBalanceSheetBean) {

		List<BalanceSheetBean> lTempBalanceSheetList = new ArrayList<>();
		List<BalanceSheetBean> lBalanceSheetList = new ArrayList<>();
		double dProfitLoss = 0.0;
		try {
			if (objBalanceSheetBean.getCompany().equalsIgnoreCase("ALL")) {

				String query1 = " SELECT coalesce((sum(debit)-sum(credit)),0) AS balance from " + " (select gh.group_head_code,gh.group_head_name,gh.group_head_code,sum(gl.bc_credit) as credit, " + "  sum(gl.bc_debit) as debit,gl.company_id from (sub_group_acct_master sga inner join " + "  group_head_master gh on sga.group_head_code =gh.group_head_code) " + " inner join general_ledger gl on sga.sub_group_acct_code = gl.parent_code " + " where gl.ledger_date < TO_DATE('" + objBalanceSheetBean.getFromDate()
						+ "','DD-MM-YYYY') and cost_center = ('" + objBalanceSheetBean.getCostCenter() + "')  and gl.company_id in ('C0008','C0009','C0010','C0011','C0012') and (gh. group_head_code='I' or gh. group_head_code='E') " + " group by gh.group_head_code,gh.group_head_name,gh.group_head_code,gl.company_id " + " order by gh.group_head_code) pl";

				List<Map<String, Object>> locnNameRows = jdbcTemplate.queryForList(query1);
				System.out.println(query1);
				for (Map row : locnNameRows) {
					dProfitLoss = (Double) row.get("balance");
					String query = " SELECT group_head_master.group_head_code as groupHeadCode,group_head_master.group_head_name as groupHeadName, " + " group_head_master.group_head_code as groupHeadType, " + " (select case when group_head_master.group_head_code='A' then " + " sum(general_ledger.bc_debit) - sum(general_ledger.bc_credit) else " + " sum(general_ledger.bc_debit) - sum(general_ledger.bc_credit) end ) as amount " + " FROM   (general_ledger  INNER JOIN sub_group_acct_master ON "
							+ " general_ledger.parent_code=sub_group_acct_master.sub_group_acct_code) " + " INNER JOIN group_head_master ON " + " sub_group_acct_master.group_head_code=group_head_master.group_head_code" + " WHERE  (group_head_master.group_head_code='A' OR group_head_master.group_head_code='L') " + " and general_ledger.ledger_date< TO_DATE('" + objBalanceSheetBean.getFromDate() + "','DD-MM-YYYY')  and cost_center = ('" + objBalanceSheetBean.getCostCenter() + "')  and  general_ledger.company_id in ('C0008','C0009','C0010','C0011','C0012')  "
							+ " group by  group_head_master.group_head_code,group_head_master.group_head_name,group_head_master.group_head_code " + "   order by group_head_master.group_head_code ";
					lTempBalanceSheetList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(BalanceSheetBean.class));
					System.out.println(query);
				}
			} else {

				List<Map<String, Object>> locnNameRows = jdbcTemplate.queryForList(BalanceSheetQueryUtil.GET_PROFIT_OR_LOSS, new Object[] { CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate()), objBalanceSheetBean.getCompany(),objBalanceSheetBean.getCostCenter() });
				for (Map row : locnNameRows) {
					dProfitLoss = (Double) row.get("balance"); 
				}
				lTempBalanceSheetList = jdbcTemplate.query(BalanceSheetQueryUtil.GET_BALANCE_SHEET_HDR, new Object[] { CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate()), objBalanceSheetBean.getCompany(),objBalanceSheetBean.getCostCenter() }, new BeanPropertyRowMapper<>(BalanceSheetBean.class));

			}

			for (BalanceSheetBean objTempBalanceSheetBean : lTempBalanceSheetList) {
				if (dProfitLoss > 0) {
					if ("A".equalsIgnoreCase(objTempBalanceSheetBean.getGroupHeadType())) {
						objTempBalanceSheetBean.setBalance(dProfitLoss + objTempBalanceSheetBean.getAmount());
					} else {
						objTempBalanceSheetBean.setBalance(objTempBalanceSheetBean.getAmount());
					}
				} else if (dProfitLoss < 0) {
					if ("L".equalsIgnoreCase(objTempBalanceSheetBean.getGroupHeadType())) {
						objTempBalanceSheetBean.setBalance(dProfitLoss + objTempBalanceSheetBean.getAmount());
					} else {
						objTempBalanceSheetBean.setBalance(objTempBalanceSheetBean.getAmount());
					}
				}
				lBalanceSheetList.add(objTempBalanceSheetBean);
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lBalanceSheetList;

	}

	// new

	@Override
	public List<BalanceSheetBean> getBalanceSheetListAsset(BalanceSheetBean objBalanceSheetBean) {

		List<BalanceSheetBean> lTempBalanceSheetList = new ArrayList<>();
		List<BalanceSheetBean> lBalanceSheetList = new ArrayList<>();
		double dProfitLoss = 0.0;
		try {
			
			if(objBalanceSheetBean.getCostCenter().isEmpty()){
				List<Map<String, Object>> locnNameRows = jdbcTemplate.queryForList("select cost_center_id from cost_center");
				for (Map row : locnNameRows) {
					objBalanceSheetBean.setCostCenter(row.get("cost_center_id").toString());
				}
				objBalanceSheetBean.setCostCenter("87");
			}
			
			if (objBalanceSheetBean.getCompany().equalsIgnoreCase("ALL")) {

				String query1 = " SELECT coalesce((sum(debit)-sum(credit)),0) AS balance from " + " (select gh.group_head_code,gh.group_head_name,gh.group_head_code,sum(gl.bc_credit) as credit, " + "  sum(gl.bc_debit) as debit,gl.company_id from (sub_group_acct_master sga inner join " + "  group_head_master gh on sga.group_head_code =gh.group_head_code) " + " inner join general_ledger gl on sga.sub_group_acct_code = gl.parent_code " + " where gl.ledger_date <= TO_DATE('" + objBalanceSheetBean.getFromDate()
						+ "','DD-MM-YYYY') and gl.cost_center in ('" + objBalanceSheetBean.getCostCenter() + "') and gl.company_id in ('C0002','C0008','C0009','C0010','C0011','C0012') and (gh. group_head_code='I' or gh. group_head_code='E') " + " group by gh.group_head_code,gh.group_head_name,gh.group_head_code,gl.company_id " + " order by gh.group_head_code) pl";

				List<Map<String, Object>> locnNameRows = jdbcTemplate.queryForList(query1);
				System.out.println(query1);
				for (Map row : locnNameRows) {
					dProfitLoss = (Double) row.get("balance");
					System.out.println("QB ====" +dProfitLoss);
					String query = " SELECT group_head_master.group_head_code as groupHeadCode,group_head_master.group_head_name as groupHeadName, " + " group_head_master.group_head_code as groupHeadType, " + " (select case when group_head_master.group_head_code='A' then " + " sum(general_ledger.bc_credit) - sum(general_ledger.bc_debit) else " + " sum(general_ledger.bc_debit) - sum(general_ledger.bc_credit) end ) as amount " + " FROM   (general_ledger  INNER JOIN sub_group_acct_master ON "
							+ " general_ledger.parent_code=sub_group_acct_master.sub_group_acct_code) " + " INNER JOIN group_head_master ON " + " sub_group_acct_master.group_head_code=group_head_master.group_head_code" + " WHERE  (group_head_master.group_head_code='A') " + " and general_ledger.ledger_date<= TO_DATE('" + objBalanceSheetBean.getFromDate() + "','DD-MM-YYYY') and  cost_center = ('" + objBalanceSheetBean.getCostCenter() + "') and general_ledger.company_id in ('C0002','C0008','C0009','C0010','C0011','C0012')  "
							+ " group by  group_head_master.group_head_code,group_head_master.group_head_name,group_head_master.group_head_code " + "   order by group_head_master.group_head_code ";
					
					
					lTempBalanceSheetList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(BalanceSheetBean.class));
					System.out.println(query);
				}
			} else {

				List<Map<String, Object>> locnNameRows = jdbcTemplate.queryForList(BalanceSheetQueryUtil.GET_PROFIT_OR_LOSS, new Object[] { CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate()), objBalanceSheetBean.getCompany(),objBalanceSheetBean.getCostCenter() });
				for (Map row : locnNameRows) {
					dProfitLoss = (Double) row.get("balance");
				}
				lTempBalanceSheetList = jdbcTemplate.query(BalanceSheetQueryUtil.GET_BALANCE_SHEET_HDR_NEW, new Object[] { 'A', CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate()), objBalanceSheetBean.getCompany(),objBalanceSheetBean.getCostCenter() }, new BeanPropertyRowMapper<>(BalanceSheetBean.class));

			}
			lBalanceSheetList.addAll(lTempBalanceSheetList);

			/*
			 * for (BalanceSheetBean objTempBalanceSheetBean : lTempBalanceSheetList) { if
			 * (dProfitLoss > 0) { if
			 * ("A".equalsIgnoreCase(objTempBalanceSheetBean.getGroupHeadType()) ) {
			 * objTempBalanceSheetBean.setBalance(dProfitLoss +
			 * objTempBalanceSheetBean.getAmount()); } else {
			 * objTempBalanceSheetBean.setBalance(objTempBalanceSheetBean. getAmount()); } }
			 * else if (dProfitLoss < 0) { if
			 * ("L".equalsIgnoreCase(objTempBalanceSheetBean.getGroupHeadType()) ) {
			 * objTempBalanceSheetBean.setBalance(dProfitLoss +
			 * objTempBalanceSheetBean.getAmount()); } else {
			 * objTempBalanceSheetBean.setBalance(objTempBalanceSheetBean. getAmount()); } }
			 * lBalanceSheetList.add(objTempBalanceSheetBean); }
			 */

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lBalanceSheetList;

	}

	@Override
	public BalanceSheetBean getBalanceSheetListAssetCurrentPeriod(BalanceSheetBean objBalanceSheetBean) {

		List<BalanceSheetBean> lTempBalanceSheetList = new ArrayList<>();
		BalanceSheetBean lBalanceSheetList = new BalanceSheetBean();
		double dProfitLoss = 0.0;
		try {
			double currentPeriodEarning = 0;
			if (objBalanceSheetBean.getCompany().equalsIgnoreCase("ALL")) {

				String query1 = " SELECT coalesce((sum(debit)-sum(credit)),0) AS balance from " + " (select gh.group_head_code,gh.group_head_name,gh.group_head_code,sum(gl.bc_credit) as credit, " + "  sum(gl.bc_debit) as debit,gl.company_id from (sub_group_acct_master sga inner join " + "  group_head_master gh on sga.group_head_code =gh.group_head_code) " + " inner join general_ledger gl on sga.sub_group_acct_code = gl.parent_code " + " where gl.ledger_date <= TO_DATE('" + objBalanceSheetBean.getFromDate()
						+ "','DD-MM-YYYY')   and cost_center = ('" + objBalanceSheetBean.getCostCenter() + "') and gl.company_id in ('C0008','C0009','C0010','C0011','C0012') and (gh. group_head_code='I' or gh. group_head_code='E') " + " group by gh.group_head_code,gh.group_head_name,gh.group_head_code,gl.company_id " + " order by gh.group_head_code) pl";

				List<Map<String, Object>> locnNameRows = jdbcTemplate.queryForList(query1);
				System.out.println(query1);
				for (Map row : locnNameRows) {
					dProfitLoss = (Double) row.get("balance");
					String query = " SELECT group_head_master.group_head_code as groupHeadCode,group_head_master.group_head_name as groupHeadName, " + " group_head_master.group_head_code as groupHeadType, " + " (select case when group_head_master.group_head_code='A' then " + " sum(general_ledger.bc_credit) - sum(general_ledger.bc_debit) else " + " sum(general_ledger.bc_debit) - sum(general_ledger.bc_credit) end ) as amount " + " FROM   (general_ledger  INNER JOIN sub_group_acct_master ON "
							+ " general_ledger.parent_code=sub_group_acct_master.sub_group_acct_code) " + " INNER JOIN group_head_master ON " + " sub_group_acct_master.group_head_code=group_head_master.group_head_code" + " WHERE  (group_head_master.group_head_code='A') " + " and general_ledger.ledger_date<= TO_DATE('" + objBalanceSheetBean.getFromDate() + "','DD-MM-YYYY')   and cost_center = ('" + objBalanceSheetBean.getCostCenter() + "')  and  general_ledger.company_id in ('C0008','C0009','C0010','C0011','C0012')  "
							+ " group by  group_head_master.group_head_code,group_head_master.group_head_name,group_head_master.group_head_code " + "   order by group_head_master.group_head_code ";
					lTempBalanceSheetList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(BalanceSheetBean.class));
					System.out.println(query);
				}
				String query11 = " SELECT coalesce((sum(debit)-sum(credit)::numeric),0) AS balance from " + " (select gh.group_head_code,gh.group_head_name,gh.group_head_code,sum(gl.bc_credit) as credit, " + "  sum(gl.bc_debit) as debit,gl.company_id from (sub_group_acct_master sga inner join " + "  group_head_master gh on sga.group_head_code =gh.group_head_code) " + " inner join general_ledger gl on sga.sub_group_acct_code = gl.parent_code " + " where gl.ledger_date <= TO_DATE('" + objBalanceSheetBean.getFromDate()
						+ "','DD-MM-YYYY') and gl.company_id in ('C0008','C0009','C0010','C0011','C0012') and (gh. group_head_code='I' or gh. group_head_code='E') " + " group by gh.group_head_code,gh.group_head_name,gh.group_head_code,gl.company_id " + " order by gh.group_head_code) pl";

				int i = jdbcTemplate.queryForObject(query11, new Object[] {}, Integer.class);
				String s = String.valueOf(i);
				currentPeriodEarning = Double.parseDouble(s);
			} else {

				List<Map<String, Object>> locnNameRows = jdbcTemplate.queryForList(BalanceSheetQueryUtil.GET_PROFIT_OR_LOSS, new Object[] { CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate()), objBalanceSheetBean.getCompany() ,objBalanceSheetBean.getCostCenter() });
				for (Map row : locnNameRows) {
					dProfitLoss = (Double) row.get("balance");
				}
				lTempBalanceSheetList = jdbcTemplate.query(BalanceSheetQueryUtil.GET_BALANCE_SHEET_HDR_NEW, new Object[] { 'A', CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate()), objBalanceSheetBean.getCompany(),objBalanceSheetBean.getCostCenter()  }, new BeanPropertyRowMapper<>(BalanceSheetBean.class));
				int i = jdbcTemplate.queryForObject(BalanceSheetQueryUtil.GET_PROFIT_OR_LOSS_1, new Object[] { CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate()), objBalanceSheetBean.getCompany(),objBalanceSheetBean.getCostCenter() }, Integer.class);
				String s = String.valueOf(i);
				currentPeriodEarning = Double.parseDouble(s);
			}
			// lBala
			lBalanceSheetList.setCurrentPeriodEarning(currentPeriodEarning);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lBalanceSheetList;

	}

	@Override
	public List<BalanceSheetBean> getBalanceSheetListLiabilities(BalanceSheetBean objBalanceSheetBean) {

		List<BalanceSheetBean> lTempBalanceSheetList = new ArrayList<>();
		List<BalanceSheetBean> lBalanceSheetList = new ArrayList<>();
		double dProfitLoss = 0.0;
		try {
			if (objBalanceSheetBean.getCompany().equalsIgnoreCase("ALL")) {

				String query1 = " SELECT coalesce((sum(debit)-sum(credit)),0) AS balance from " + " (select gh.group_head_code,gh.group_head_name,gh.group_head_code,sum(gl.bc_credit) as credit, " + "  sum(gl.bc_debit) as debit,gl.company_id from (sub_group_acct_master sga inner join " + "  group_head_master gh on sga.group_head_code =gh.group_head_code) " + " inner join general_ledger gl on sga.sub_group_acct_code = gl.parent_code " + " where gl.ledger_date <= TO_DATE('" + objBalanceSheetBean.getFromDate()
						+ "','DD-MM-YYYY') and cost_center = ('" + objBalanceSheetBean.getCostCenter() + "') and gl.company_id in ('C0008','C0009','C0010','C0011','C0012') and (gh. group_head_code='I' or gh. group_head_code='E') " + " group by gh.group_head_code,gh.group_head_name,gh.group_head_code,gl.company_id " + " order by gh.group_head_code) pl";

				List<Map<String, Object>> locnNameRows = jdbcTemplate.queryForList(query1);
				System.out.println(query1);
				for (Map row : locnNameRows) {
					dProfitLoss = (Double) row.get("balance");
					String query = " SELECT group_head_master.group_head_code as groupHeadCode,group_head_master.group_head_name as groupHeadName, " + " group_head_master.group_head_code as groupHeadType, " + " (select case when group_head_master.group_head_code='A' then " + " sum(general_ledger.bc_debit) - sum(general_ledger.bc_credit) else " + " sum(general_ledger.bc_debit) - sum(general_ledger.bc_credit) end ) as amount " + " FROM   (general_ledger  INNER JOIN sub_group_acct_master ON "
							+ " general_ledger.parent_code=sub_group_acct_master.sub_group_acct_code) " + " INNER JOIN group_head_master ON " + " sub_group_acct_master.group_head_code=group_head_master.group_head_code" + " WHERE  (group_head_master.group_head_code='L') " + " and general_ledger.ledger_date<= TO_DATE('" + objBalanceSheetBean.getFromDate() + "','DD-MM-YYYY') and cost_center = ('" + objBalanceSheetBean.getCostCenter() + "')  and  general_ledger.company_id in ('C0008','C0009','C0010','C0011','C0012')  "
							+ " group by  group_head_master.group_head_code,group_head_master.group_head_name,group_head_master.group_head_code " + "   order by group_head_master.group_head_code ";
					lTempBalanceSheetList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(BalanceSheetBean.class));
					System.out.println(query);
				}
			} else {

				List<Map<String, Object>> locnNameRows = jdbcTemplate.queryForList(BalanceSheetQueryUtil.GET_PROFIT_OR_LOSS, new Object[] { CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate()), objBalanceSheetBean.getCompany(),objBalanceSheetBean.getCostCenter()  });
				for (Map row : locnNameRows) {
					dProfitLoss = (Double) row.get("balance");
				}
				lTempBalanceSheetList = jdbcTemplate.query(BalanceSheetQueryUtil.GET_BALANCE_SHEET_HDR_NEW, new Object[] { 'L', CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate()), objBalanceSheetBean.getCompany(),objBalanceSheetBean.getCostCenter()  }, new BeanPropertyRowMapper<>(BalanceSheetBean.class));

			}

			lBalanceSheetList.addAll(lTempBalanceSheetList);

			/*
			 * for (BalanceSheetBean objTempBalanceSheetBean : lTempBalanceSheetList) { if
			 * (dProfitLoss > 0) { if
			 * ("A".equalsIgnoreCase(objTempBalanceSheetBean.getGroupHeadType()) ) {
			 * objTempBalanceSheetBean.setBalance(dProfitLoss +
			 * objTempBalanceSheetBean.getAmount()); } else {
			 * objTempBalanceSheetBean.setBalance(objTempBalanceSheetBean. getAmount()); } }
			 * else if (dProfitLoss < 0) { if
			 * ("L".equalsIgnoreCase(objTempBalanceSheetBean.getGroupHeadType()) ) {
			 * objTempBalanceSheetBean.setBalance(dProfitLoss +
			 * objTempBalanceSheetBean.getAmount()); } else {
			 * objTempBalanceSheetBean.setBalance(objTempBalanceSheetBean. getAmount()); } }
			 * lBalanceSheetList.add(objTempBalanceSheetBean); }
			 */

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lBalanceSheetList;

	}

	@Override
	public List<BalanceSheetBean> generateBalanceSheetReportDtl(BalanceSheetBean objBalanceSheetBean) {
		List<BalanceSheetBean> lBalanceSheetList = new ArrayList<>();
		try {
			if (objBalanceSheetBean.getCompany().equalsIgnoreCase("ALL")) {

				String query = " select parent_code as groupHeadCode, sub_group_acct_master.sub_group_acct_name as groupHeadName, case when group_head_master.group_head_code='A' then  sum(general_ledger.bc_credit) - sum(general_ledger.bc_debit) else  sum(general_ledger.bc_debit) - sum(general_ledger.bc_credit) end as balance from  (general_ledger INNER JOIN sub_group_acct_master ON " + " general_ledger.parent_code=sub_group_acct_master.sub_group_acct_code) " + " INNER JOIN group_head_master ON "
						+ " sub_group_acct_master.group_head_code=group_head_master.group_head_code " + " where parent_code like '" + objBalanceSheetBean.getGroupHeadCode() + "' and general_ledger.ledger_date < TO_DATE('" + objBalanceSheetBean.getFromDate() + "','DD-MM-YYYY') " + " group by parent_code,sub_group_acct_master.sub_group_acct_name,group_head_master.group_head_code order by parent_code ";

				lBalanceSheetList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(BalanceSheetBean.class));

			} else {
				lBalanceSheetList = jdbcTemplate.query(BalanceSheetQueryUtil.GET_BALANCE_SHEET_DTL, new Object[] { objBalanceSheetBean.getGroupHeadCode(), CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate()), objBalanceSheetBean.getCompany() }, new BeanPropertyRowMapper<>(BalanceSheetBean.class));

			}
			// lBalanceSheetList =
			// jdbcTemplate.query(BalanceSheetQueryUtil.GET_BALANCE_SHEET_DTL,
			// new Object[] { objBalanceSheetBean.getGroupHeadCode(),
			// CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate())
			// }, new
			// BeanPropertyRowMapper<BalanceSheetBean>(BalanceSheetBean.class));
		} catch (DataAccessException e) {

		}
		return lBalanceSheetList;
	}

	@Override
	public List<BalanceSheetBean> generateBalanceSheetReportAHDtl(BalanceSheetBean objBalanceSheetBean) {
		List<BalanceSheetBean> lBalanceSheetList = new ArrayList<>();
		try {
			if (objBalanceSheetBean.getCompany().equalsIgnoreCase("ALL")) {

				String query = "select general_ledger.account_code  as groupHeadCode,coalesce(AH.acct_head_name,'')  || coalesce(cust.entity_name,'') || coalesce(supp.entity_name,'') as groupHeadName,(case when group_head_master.group_head_code='A' then  sum(general_ledger.bc_credit) - sum(general_ledger.bc_debit) else  sum(general_ledger.bc_debit) - sum(general_ledger.bc_credit) end) as balance from general_ledger left join account_head_master AH on AH.acct_head_code = general_ledger.account_code left join entity cust on cust.customer_acct_code = general_ledger.account_code left join entity supp on supp.supplier_acct_code = general_ledger.account_code INNER JOIN sub_group_acct_master ON  general_ledger.parent_code=sub_group_acct_master.sub_group_acct_code  INNER JOIN group_head_master ON  sub_group_acct_master.group_head_code=group_head_master.group_head_code where general_ledger.parent_code ='"
						+ objBalanceSheetBean.getGroupHeadCode() + "' and general_ledger.ledger_date < TO_DATE('" + objBalanceSheetBean.getFromDate() + "','DD-MM-YYYY') group by general_ledger.account_code,AH.acct_head_name,cust.entity_name,supp.entity_name,group_head_master.group_head_code order by  account_code";
				lBalanceSheetList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(BalanceSheetBean.class));
			} else {
				lBalanceSheetList = jdbcTemplate.query(BalanceSheetQueryUtil.GET_BALANCE_SHEETAH_DTL, new Object[] { objBalanceSheetBean.getGroupHeadCode(), CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate()), objBalanceSheetBean.getCompany() }, new BeanPropertyRowMapper<>(BalanceSheetBean.class));

			}
		} catch (DataAccessException e) {

		}
		return lBalanceSheetList;
	}

	@Override
	public List<BalanceSheetBean> getBalanceSheetReportList1(BalanceSheetBean objBalanceSheetBean) {
		List<BalanceSheetBean> lBalanceSheetList = new ArrayList<>();
		try {
			List<BalanceSheetBean> lTempBalanceSheetList = new ArrayList<>();
			lTempBalanceSheetList = getBalanceSheetList(objBalanceSheetBean);

			for (BalanceSheetBean objBalanceSheetFirstBean : lTempBalanceSheetList) {
				List<BalanceSheetBean> lBalanceSheetSGList = new ArrayList<>();
				List<BalanceSheetBean> lBalanceSheetSGTempList = new ArrayList<>();
				String sSubGroupCode = "";
				if ("A".equalsIgnoreCase(objBalanceSheetFirstBean.getGroupHeadCode()))
					sSubGroupCode = "100%";
				else
					sSubGroupCode = "200%";
				if (objBalanceSheetBean.getCompany().equalsIgnoreCase("ALL")) {

					String query = "" + "select  * from crosstab( " + "$$" + "select parent_code as groupHeadCode, sub_group_acct_master.sub_group_acct_name as groupHeadName, " + "unnest(array[concat(general_ledger.company_id,'_amount')]) AS \"Values\", " + "unnest(array[sum(general_ledger.bc_debit) - sum(general_ledger.bc_credit)]) AS \"Count\" "
							+ "from  (general_ledger INNER JOIN sub_group_acct_master ON general_ledger.parent_code=sub_group_acct_master.sub_group_acct_code)  INNER JOIN group_head_master ON  sub_group_acct_master.group_head_code=group_head_master.group_head_code  where parent_code like '" + sSubGroupCode + "' and general_ledger.ledger_date < to_date('" + objBalanceSheetBean.getFromDate() + "','dd/mm/yyyy')  group by parent_code,sub_group_acct_master.sub_group_acct_name,general_ledger.company_id order by parent_code " + " $$, "
							+ "    $$VALUES ('C0008_amount'),('C0009_amount'),('C0010_amount'),('C0011_amount') " + ",  ('C0012_amount') $$ )as " + "ct(groupHeadCode character varying,groupHeadName character varying,\"C0008_amount\" character varying,\"C0009_amount\" character varying, " + "\"C0010_amount\" character varying,\"C0011_amount\" character varying,\"C0012_amount\" character varying )";
					lBalanceSheetSGTempList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(BalanceSheetBean.class));
				} else {
					lBalanceSheetSGTempList = jdbcTemplate.query(BalanceSheetQueryUtil.GET_BALANCE_SHEET_DTL, new Object[] { sSubGroupCode, CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate()), objBalanceSheetBean.getCompany() }, new BeanPropertyRowMapper<>(BalanceSheetBean.class));

				}
				for (BalanceSheetBean objBalanceSheetSecondBean : lBalanceSheetSGTempList) {
					List<BalanceSheetBean> lBalanceSheetAHList = new ArrayList<>();

					if (objBalanceSheetBean.getCompany().equalsIgnoreCase("ALL")) {

						String query = "" + "select  * from crosstab( " + "$$" + "select general_ledger.account_code  as groupHeadCode,coalesce(AH.acct_head_name,'')  || coalesce(cust.entity_name,'') || coalesce(supp.entity_name,'') as groupHeadName,unnest(array[concat(general_ledger.company_id,'_amount')]) AS \"Values\", " + "unnest(array[sum(general_ledger.bc_debit) - sum(general_ledger.bc_credit)]) AS \"Count\" " + " "
								+ " from general_ledger left join account_head_master AH on AH.acct_head_code = general_ledger.account_code left join entity cust on cust.customer_acct_code = general_ledger.account_code left join entity supp on supp.supplier_acct_code = general_ledger.account_code where general_ledger.parent_code ='" + objBalanceSheetSecondBean.getGroupHeadCode() + "' and general_ledger.ledger_date < to_date('" + objBalanceSheetBean.getFromDate()
								+ "','dd/mm/yyyy') group by general_ledger.account_code,AH.acct_head_name,cust.entity_name, " + " supp.entity_name,general_ledger.company_id order by  account_code " + "$$, " + "    $$VALUES ('C0008_amount'),('C0009_amount'),('C0010_amount'),('C0011_amount') " + ",  ('C0012_amount') $$ )as " + "ct(groupHeadCode character varying,groupHeadName character varying,\"C0008_amount\" character varying,\"C0009_amount\" character varying, "
								+ "\"C0010_amount\" character varying,\"C0011_amount\" character varying,\"C0012_amount\" character varying )";
						lBalanceSheetAHList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(BalanceSheetBean.class));
					} else {
						lBalanceSheetAHList = jdbcTemplate.query(BalanceSheetQueryUtil.GET_BALANCE_SHEETAH_DTL, new Object[] { objBalanceSheetSecondBean.getGroupHeadCode(), CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate()), objBalanceSheetBean.getCompany() }, new BeanPropertyRowMapper<>(BalanceSheetBean.class));

					}

					objBalanceSheetSecondBean.setlAccountHeadLevelList(lBalanceSheetAHList);
					lBalanceSheetSGList.add(objBalanceSheetSecondBean);
				}
				objBalanceSheetFirstBean.setlSubGroupLevelList(lBalanceSheetSGList);
				lBalanceSheetList.add(objBalanceSheetFirstBean);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lBalanceSheetList;
	}

	@Override
	public List<BalanceSheetBean> getBalanceSheetReportList(BalanceSheetBean objBalanceSheetBean) {
		List<BalanceSheetBean> lBalanceSheetList = new ArrayList<>();
		try {
			List<BalanceSheetBean> lTempBalanceSheetList = new ArrayList<>();
			lTempBalanceSheetList = getBalanceSheetList(objBalanceSheetBean);

			for (BalanceSheetBean objBalanceSheetFirstBean : lTempBalanceSheetList) {
				List<BalanceSheetBean> lBalanceSheetSGList = new ArrayList<>();
				List<BalanceSheetBean> lBalanceSheetSGTempList = new ArrayList<>();
				String sSubGroupCode = "";
				if ("A".equalsIgnoreCase(objBalanceSheetFirstBean.getGroupHeadCode()))
					sSubGroupCode = "100%";
				else
					sSubGroupCode = "200%";
				if (objBalanceSheetBean.getCompany().equalsIgnoreCase("ALL")) {

					String query = "" + "select  * from crosstab( " + "$$" + "select parent_code as groupHeadCode, sub_group_acct_master.sub_group_acct_name as groupHeadName, " + "unnest(array[concat(general_ledger.company_id,'_amount')]) AS \"Values\", " + "unnest(array[ case when group_head_master.group_head_code='A' then  sum(general_ledger.bc_credit) - sum(general_ledger.bc_debit) else  sum(general_ledger.bc_debit) - sum(general_ledger.bc_credit) end  ]) AS \"Count\" "
							+ "from  (general_ledger INNER JOIN sub_group_acct_master ON general_ledger.parent_code=sub_group_acct_master.sub_group_acct_code)  INNER JOIN group_head_master ON  sub_group_acct_master.group_head_code=group_head_master.group_head_code  where parent_code like '" + sSubGroupCode + "' and general_ledger.ledger_date < to_date('" + objBalanceSheetBean.getFromDate()
							+ "','dd/mm/yyyy')  group by parent_code,sub_group_acct_master.sub_group_acct_name,general_ledger.company_id,group_head_master.group_head_code order by parent_code " + " $$, " + "    $$VALUES ('C0008_amount'),('C0009_amount'),('C0010_amount'),('C0011_amount') " + ",  ('C0012_amount') $$ )as " + "ct(groupHeadCode character varying,groupHeadName character varying,\"C0008_amount\" character varying,\"C0009_amount\" character varying, "
							+ "\"C0010_amount\" character varying,\"C0011_amount\" character varying,\"C0012_amount\" character varying )";
					lBalanceSheetSGTempList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(BalanceSheetBean.class));
				} else {
					lBalanceSheetSGTempList = jdbcTemplate.query(BalanceSheetQueryUtil.GET_BALANCE_SHEET_DTL, new Object[] { sSubGroupCode, CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate()), objBalanceSheetBean.getCompany() }, new BeanPropertyRowMapper<>(BalanceSheetBean.class));

				}
				for (BalanceSheetBean objBalanceSheetSecondBean : lBalanceSheetSGTempList) {
					List<BalanceSheetBean> lBalanceSheetAHList = new ArrayList<>();

					if (objBalanceSheetBean.getCompany().equalsIgnoreCase("ALL")) {

						String query = "" + "select  * from crosstab( " + "$$" + "select general_ledger.account_code  as groupHeadCode,coalesce(AH.acct_head_name,'')  || coalesce(cust.entity_name,'') || coalesce(supp.entity_name,'') as groupHeadName,unnest(array[concat(general_ledger.company_id,'_amount')]) AS \"Values\", " + "unnest(array[ case when group_head_master.group_head_code='A' then  sum(general_ledger.bc_credit) - sum(general_ledger.bc_debit) else  sum(general_ledger.bc_debit) - sum(general_ledger.bc_credit) end]) AS \"Count\" " + " "
								+ " from general_ledger left join account_head_master AH on AH.acct_head_code = general_ledger.account_code INNER JOIN sub_group_acct_master ON general_ledger.parent_code=sub_group_acct_master.sub_group_acct_code INNER JOIN group_head_master ON  sub_group_acct_master.group_head_code=group_head_master.group_head_code left join entity cust on cust.customer_acct_code = general_ledger.account_code left join entity supp on supp.supplier_acct_code = general_ledger.account_code where general_ledger.parent_code ='"
								+ objBalanceSheetSecondBean.getGroupHeadCode() + "' and general_ledger.ledger_date < to_date('" + objBalanceSheetBean.getFromDate() + "','dd/mm/yyyy') group by general_ledger.account_code,AH.acct_head_name,cust.entity_name, " + " supp.entity_name,general_ledger.company_id,group_head_master.group_head_code order by  account_code " + "$$, " + "    $$VALUES ('C0008_amount'),('C0009_amount'),('C0010_amount'),('C0011_amount') " + ",  ('C0012_amount') $$ )as "
								+ "ct(groupHeadCode character varying,groupHeadName character varying,\"C0008_amount\" character varying,\"C0009_amount\" character varying, " + "\"C0010_amount\" character varying,\"C0011_amount\" character varying,\"C0012_amount\" character varying )";
						lBalanceSheetAHList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(BalanceSheetBean.class));
					} else {
						lBalanceSheetAHList = jdbcTemplate.query(BalanceSheetQueryUtil.GET_BALANCE_SHEETAH_DTL, new Object[] { objBalanceSheetSecondBean.getGroupHeadCode(), CommonUtil.convertSqlDateFormat(objBalanceSheetBean.getFromDate()), objBalanceSheetBean.getCompany() }, new BeanPropertyRowMapper<>(BalanceSheetBean.class));

					}

					objBalanceSheetSecondBean.setlAccountHeadLevelList(lBalanceSheetAHList);
					lBalanceSheetSGList.add(objBalanceSheetSecondBean);
				}
				objBalanceSheetFirstBean.setlSubGroupLevelList(lBalanceSheetSGList);
				lBalanceSheetList.add(objBalanceSheetFirstBean);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lBalanceSheetList;
	}

	

}
