package com.dci.finance.GeneralLedger;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CommonUtilityQueryUtil;
import com.dci.common.util.CustomException;

@Repository
// @Transactional("tenantTransactionManager")
public class GeneralLedgerDaoImpl implements GeneralLedgerDao {

	@Resource
	private DataSource dataSource;

	@Override
	public List<SelectivityBean> getGroupHeadList() {
		List<SelectivityBean> lSubGroupList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lSubGroupList = jdbcTemplate.query(GeneralLedgerQueryUtil.GET_GRP_LIST, new BeanPropertyRowMapper<>(SelectivityBean.class));

		} catch (DataAccessException e) {
		}
		return lSubGroupList;
	}

	@Override
	public List<SelectivityBean> mainaccountList() {
		List<SelectivityBean> lMainlist = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lMainlist = jdbcTemplate.query(GeneralLedgerQueryUtil.get_mainaccount_list, new BeanPropertyRowMapper<>(SelectivityBean.class));

		} catch (DataAccessException e) {
		}
		return lMainlist;
	}

	@Override
	public List<GeneralLedgerBean> getGeneralLedgerReport(GeneralLedgerBean objGeneralLedgerBean) {
		List<GeneralLedgerBean> lGeneralLedgerList = new ArrayList<>();
		String compCode = "";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			String subGroupCode = "", mainAcctCode = "", subAcctCode = "";
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

			System.out.println("compCode::::" + compCode);
			String groupCode = "";
			if (objGeneralLedgerBean.getGroupCode().equalsIgnoreCase("") && objGeneralLedgerBean.getGroupCode().equalsIgnoreCase(null) && objGeneralLedgerBean.getGroupCode().equalsIgnoreCase("undefined")) {
				String groupCodes[] = objGeneralLedgerBean.getGroupCode().split(",");

				for (int i = 0; i < groupCodes.length; i++) {
					if (groupCode == "") {
						groupCode = groupCodes[i];
					} else {
						groupCode += "," + groupCodes[i];
					}
				}
				System.out.println("groupCode::::" + groupCode);
				
			} else {
				groupCode = "";
			}

			String sDynamicQuery = GeneralLedgerQueryUtil.GET_GENERAL_LEDGER_LIST_SG_LEVEL;

			if (groupCode != "") {
				sDynamicQuery += groupCode;
				System.out.println("group:" + groupCode);
			}
			if (objGeneralLedgerBean.getSubGroupCode() != "" && objGeneralLedgerBean.getSubGroupCode() != null) {
				subGroupCode = objGeneralLedgerBean.getSubGroupCode();
				System.out.println("subgroup:" + subGroupCode);
				
			} else
				subGroupCode = "";
			if (objGeneralLedgerBean.getMainAccountCode() != "" && objGeneralLedgerBean.getMainAccountCode() != null) {
				mainAcctCode = objGeneralLedgerBean.getMainAccountCode();
				System.out.println("mainAcctCode:" + mainAcctCode);
			} else
				mainAcctCode = "";
			if (objGeneralLedgerBean.getSubAccountCode() != "" && objGeneralLedgerBean.getSubAccountCode() != null)
				subAcctCode = objGeneralLedgerBean.getSubAccountCode();
			else
				subAcctCode = "";

			if (objGeneralLedgerBean.getSubAccountCode() != null && objGeneralLedgerBean.getSubAccountCode() != "") {
				if (isNum(objGeneralLedgerBean.getSubAccountCode())) {

					System.out.println("up:" + objGeneralLedgerBean.getSubAccountCode());

				} else {

					System.out.println("down:" + objGeneralLedgerBean.getSubAccountCode());
					subAcctCode = jdbcTemplate.queryForObject(GeneralLedgerQueryUtil.get_acct_head_code, new Object[] { objGeneralLedgerBean.getSubAccountCode() }, String.class);
					System.out.println("getcode:" + subAcctCode);
				}
			} 
			
			if(objGeneralLedgerBean.getAcctHeadId()==null &&objGeneralLedgerBean.getAcctHeadId().equals("undefined")  && objGeneralLedgerBean.getAcctHeadId().equals("")) {
			//lGeneralLedgerList = jdbcTemplate.query(GeneralLedgerQueryUtil.GET_VIEW_REPORTtest1, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), objGeneralLedgerBean.getSubGroupId(), objGeneralLedgerBean.getAcctHeadId(), objGeneralLedgerBean.getSubAccountFilterId(), objGeneralLedgerBean.getCostCenter() }, new BeanPropertyRowMapper<>(GeneralLedgerBean.class));
				lGeneralLedgerList = jdbcTemplate.query(GeneralLedgerQueryUtil.GET_VIEW_REPORT, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId()}, new BeanPropertyRowMapper<>(GeneralLedgerBean.class));
				System.out.println("fisrt Query if part :::" +GeneralLedgerQueryUtil.GET_VIEW_REPORT);
			}
			else {
				lGeneralLedgerList = jdbcTemplate.query(GeneralLedgerQueryUtil.GET_VIEW_REPORT, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId(),objGeneralLedgerBean.getAcctHeadId()}, new BeanPropertyRowMapper<>(GeneralLedgerBean.class));
				//lGeneralLedgerList = jdbcTemplate.query(GeneralLedgerQueryUtil.GET_VIEW_REPORTtest_ac, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), objGeneralLedgerBean.getSubGroupId(), objGeneralLedgerBean.getAcctHeadId(), objGeneralLedgerBean.getSubAccountFilterId(), objGeneralLedgerBean.getCostCenter(), objGeneralLedgerBean.getAcctHeadId().substring(0, 4) }, new BeanPropertyRowMapper<>(GeneralLedgerBean.class));
				System.out.println("fisrt Query else part :::" +GeneralLedgerQueryUtil.GET_VIEW_REPORT);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lGeneralLedgerList;
	}

	public static boolean isNum(String strNum) {
		boolean ret = true;
		try {
			Integer.parseInt(strNum);
		} catch (NumberFormatException e) {
			ret = false;
		}
		return ret;
	}

	@Override
	public List<GeneralLedgerBean> getGeneralLedgerAHLevel(GeneralLedgerBean objGeneralLedgerBean) {
		List<GeneralLedgerBean> lGeneralLedgerAHList = new ArrayList<>();
		try {

			String compCode = "";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			String whereCond = "";
			String query = null;

			whereCond = searchAcc(objGeneralLedgerBean);

			if (!whereCond.isEmpty() && whereCond != "") { //atul

				query = "with t as ( "
						+ " "
						+ "select account_code as accountHeadCode, transaction_no as transactionno    from general_ledger gl "
						+ "						 where 1=1  " + whereCond + "   group by account_code,transaction_no order by account_code) "
						+ " "
						+ " "
						+ "select gl.ledger_date, gl.transaction_no,  account_code as accountHeadCode,case when length(account_code)=4  then (select sub_group_acct_name from sub_group_acct_master where sub_group_acct_code=account_code) else coalesce(AH.acct_head_name,'')  || coalesce(cust.entity_name,'') || coalesce(supp.entity_name,'') end as accountHeadName,  SUM(TC_DEBIT) as tcDebit, SUM(TC_CREDIT) as tcCredit,SUM(BC_DEBIT) as bcDebit, SUM(BC_CREDIT) as bcCredit,  (SUM(bc_debit) - SUM(bc_credit)) as currentBalance, (SUM(TC_DEBIT)- SUM(TC_CREDIT)) as currentTCBalance   from general_ledger gl "
						+ "right join t on t.transactionno = gl.transaction_no "
						+ "						 left join account_head_master AH on AH.acct_head_code = gl.account_code   left join customer_entity cust on cust.customer_acct_code = gl.account_code left join entity supp on supp.supplier_acct_code = gl.account_code   where    gl.account_code <> '" + objGeneralLedgerBean.getAcctHeadId() + "'  group by account_code,AH.acct_head_name,cust.entity_name,supp.entity_name ,gl.transaction_no, gl.ledger_date  order by account_code";
						
				lGeneralLedgerAHList = jdbcTemplate.query(query, new Object[] {}, new BeanPropertyRowMapper<>(GeneralLedgerBean.class));

				//System.out.println("Test"+ query);			gl.parent_code=objGeneralLedgerBean.getSubGroupCode()
					/*	"select  account_code as accountHeadCode,case when length(account_code)=4  then (select sub_group_acct_name from sub_group_acct_master where sub_group_acct_code=account_code) else coalesce(AH.acct_head_name,'')  || coalesce(cust.entity_name,'') || coalesce(supp.entity_name,'') end as accountHeadName,  SUM(TC_DEBIT) as tcDebit, SUM(TC_CREDIT) as tcCredit,SUM(BC_DEBIT) as bcDebit, SUM(BC_CREDIT) as bcCredit,  (SUM(bc_debit) - SUM(bc_credit)) as currentBalance, (SUM(TC_DEBIT)- SUM(TC_CREDIT)) as currentTCBalance   from general_ledger gl "
						+ "left join account_head_master AH on AH.acct_head_code = gl.account_code " + "left join entity cust on cust.customer_acct_code = gl.account_code left join entity supp on supp.supplier_acct_code = gl.account_code " + "  where 1=1 " + whereCond + " group by account_code,AH.acct_head_name,cust.entity_name,supp.entity_name  order by account_code";
				*/
				System.out.println("Test "+ query);	

			}
		} catch (DataAccessException | SQLException e) {
			e.printStackTrace();
		}
		return lGeneralLedgerAHList;
	}
	
	
	
public String searchAcc(GeneralLedgerBean objTrialBalanceBean) throws SQLException { 
		
		String whereCond = "";

		//String	Accouncd = null;
		//Accouncd = jdbcTemplate.queryForObject(GeneralLedgerQueryUtil.get_acct_head_code, new Object[] { objGeneralLedgerBean.getSubAccountCode() }, String.class);
		
		//System.out.println("down:" + objTrialBalanceBean.getSubAccountCode());

		
		
		if (objTrialBalanceBean.getCompanyCode() != null && !objTrialBalanceBean.getCompanyCode().isEmpty()) {

			if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
				String compcode = "'C0002','C0009','C0010','C0011','C0012'";
				whereCond += "  and gl.company_id IN (" + compcode + ")";
			} else {
				whereCond += "  and gl.company_id IN ('" + objTrialBalanceBean.getCompanyCode() + "')";
			}
		}
		if (objTrialBalanceBean.getFromDate() != null && !objTrialBalanceBean.getFromDate().isEmpty()) {
			whereCond += " and gl.ledger_date::date >= TO_DATE('" + objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY')";

		}
		if (objTrialBalanceBean.getToDate() != null && !objTrialBalanceBean.getToDate().isEmpty()) {
			whereCond += " and gl.ledger_date::date <= TO_DATE('" + objTrialBalanceBean.getToDate() + "','DD-MM-YYYY')";

		}
	/*	if (objTrialBalanceBean.getSubGroupCode() != null && !objTrialBalanceBean.getSubGroupCode().isEmpty()) {

			String subGroupCode1 = objTrialBalanceBean.getSubGroupCode() + "%";
			whereCond += " and gl.parent_code like '" + subGroupCode1 + "'";

		}*/
	/*	if (objTrialBalanceBean.getSubGroupId() != null && !objTrialBalanceBean.getSubGroupId().isEmpty()) {
			whereCond += " and gl.parent_code = '" + objTrialBalanceBean.getSubGroupId() + "'";

		}*/
		if (objTrialBalanceBean.getAcctHeadId() != null && !objTrialBalanceBean.getAcctHeadId().isEmpty()) {
			whereCond += " and gl.account_code = '" + objTrialBalanceBean.getAcctHeadId() + "'";

		}
		else {
			
		}
		if (objTrialBalanceBean.getSubAccountFilterId() != null && !objTrialBalanceBean.getSubAccountFilterId().isEmpty()) {
			whereCond += " and gl.sub_account_code = '" + objTrialBalanceBean.getSubAccountFilterId() + "'";

		}
		if (objTrialBalanceBean.getCostCenter() != null && !objTrialBalanceBean.getCostCenter().isEmpty()) {
			whereCond += " and gl.cost_center = '" + objTrialBalanceBean.getCostCenter() + "'";

		}

		return whereCond;
	}
	
	

	public String search(GeneralLedgerBean objTrialBalanceBean) throws SQLException {

		
		
		String whereCond = "";

		//String	Accouncd = null;
		//Accouncd = jdbcTemplate.queryForObject(GeneralLedgerQueryUtil.get_acct_head_code, new Object[] { objGeneralLedgerBean.getSubAccountCode() }, String.class);
		
		//System.out.println("down:" + objTrialBalanceBean.getSubAccountCode());		
		
		if (objTrialBalanceBean.getCompanyCode() != null && !objTrialBalanceBean.getCompanyCode().isEmpty()) {

			if (objTrialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
				String compcode = "'C0002','C0009','C0010','C0011','C0012'";
				whereCond += "  and gl.company_id IN (" + compcode + ")";
			} else {
				whereCond += "  and gl.company_id IN ('" + objTrialBalanceBean.getCompanyCode() + "')";
			}
		}
		if (objTrialBalanceBean.getFromDate() != null && !objTrialBalanceBean.getFromDate().isEmpty()) {
			whereCond += " and gl.ledger_date::date >= TO_DATE('" + objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY')";

		}
		if (objTrialBalanceBean.getToDate() != null && !objTrialBalanceBean.getToDate().isEmpty()) {
			whereCond += " and gl.ledger_date::date <= TO_DATE('" + objTrialBalanceBean.getToDate() + "','DD-MM-YYYY')";

		}
		if (objTrialBalanceBean.getSubGroupCode() != null && !objTrialBalanceBean.getSubGroupCode().isEmpty()) {

			String subGroupCode1 = objTrialBalanceBean.getSubGroupCode() + "%";
			whereCond += " and gl.parent_code like '" + subGroupCode1 + "'";

		}
		if (objTrialBalanceBean.getSubGroupId() != null && !objTrialBalanceBean.getSubGroupId().isEmpty()) {
			whereCond += " and gl.parent_code = '" + objTrialBalanceBean.getSubGroupId() + "'";

		}
		if (objTrialBalanceBean.getAcctHeadId() != null && !objTrialBalanceBean.getAcctHeadId().isEmpty()) {
			whereCond += " and gl.account_code = '" + objTrialBalanceBean.getAcctHeadId() + "'";

		}
		else {
			
		}
		if (objTrialBalanceBean.getSubAccountFilterId() != null && !objTrialBalanceBean.getSubAccountFilterId().isEmpty()) {
			whereCond += " and gl.sub_account_code = '" + objTrialBalanceBean.getSubAccountFilterId() + "'";

		}
		if (objTrialBalanceBean.getCostCenter() != null && !objTrialBalanceBean.getCostCenter().isEmpty()) {
			whereCond += " and gl.cost_center = '" + objTrialBalanceBean.getCostCenter() + "'";

		}

		return whereCond;
	}

	@Override
	public List<GeneralLedgerBean> getGLTransactionLevel(GeneralLedgerBean objGeneralLedgerBean) {
		List<GeneralLedgerBean> lGeneralLedgerTransactionList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String compCode = "", subGroupCode = "", mainAcctCode = "", subAcctCode = "";
			if (objGeneralLedgerBean.getCompanyCode().equalsIgnoreCase("ALL")) {

				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_CODE"));
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

			String whereCond = "";
			String query = null;

			whereCond = search1(objGeneralLedgerBean);

			if (!whereCond.isEmpty() && whereCond != "") {

				System.out.println(objGeneralLedgerBean.getAcctcode());
				System.out.println(objGeneralLedgerBean.getAcctHeadId1());

				if (objGeneralLedgerBean.getAcctcode().equalsIgnoreCase(objGeneralLedgerBean.getAcctHeadId1())) {
					
					query ="Select TO_CHAR(LEDGER_DATE,'DD-MM-YYYY') as ledgerDate," + "general_ledger_id ledgerNo,account_code as accountHeadCode,  " + " transaction_no as transactionNo, " + "  coalesce(GL.narration , '') as narration," + "CURRENCY_CODE as currency,   exchange_rate as exchangeRate," + "  coalesce(e.entity_name,ce.entity_name) as subAccountCode,   GL.parent_code as subgroup ,   SUM(COALESCE(TC_DEBIT,0)) as tcDebit,SUM(COALESCE(TC_CREDIT,0)) as tcCredit,SUM(COALESCE(BC_DEBIT,0)) as bcDebit,   SUM(COALESCE(BC_CREDIT,0)) as bcCredit "
					+ ",cost_center_name as costCenter,party_inv_no as partyInvoiceNo," + "" + " project_name as budget from general_ledger GL" + " left join cost_center" + " cc on cc.cost_center_id::text =GL.cost_center " + "      left join entity e on e.supplier_acct_code=SUB_ACCOUNT_CODE " + "						left join customer_entity ce on ce.customer_acct_code=SUB_ACCOUNT_CODE" + "      left join budget_definition bd on bd.budget_definition_id=GL.budget where 1=1 " + whereCond
					+ "  group  by LEDGER_DATE,general_ledger_id,cost_center_name,project_name,e.entity_name,ce.entity_name;";

			lGeneralLedgerTransactionList = jdbcTemplate.query(query, new Object[] {}, new BeanPropertyRowMapper<>(GeneralLedgerBean.class));
					
				}
				else if (objGeneralLedgerBean.getAcctHeadId1()!="" && objGeneralLedgerBean.getAcctcode().isEmpty()){
					
					query ="Select TO_CHAR(LEDGER_DATE,'DD-MM-YYYY') as ledgerDate," + "general_ledger_id ledgerNo,account_code as accountHeadCode,  " + " transaction_no as transactionNo, " + "  coalesce(GL.narration , '') as narration," + "CURRENCY_CODE as currency,   exchange_rate as exchangeRate," + "  coalesce(e.entity_name,ce.entity_name) as subAccountCode,   GL.parent_code as subgroup ,   SUM(COALESCE(TC_DEBIT,0)) as tcDebit,SUM(COALESCE(TC_CREDIT,0)) as tcCredit,SUM(COALESCE(BC_DEBIT,0)) as bcDebit,   SUM(COALESCE(BC_CREDIT,0)) as bcCredit "
							+ ",cost_center_name as costCenter,party_inv_no as partyInvoiceNo," + "" + " project_name as budget from general_ledger GL" + " left join cost_center" + " cc on cc.cost_center_id::text =GL.cost_center " + "      left join entity e on e.supplier_acct_code=SUB_ACCOUNT_CODE " + "						left join customer_entity ce on ce.customer_acct_code=SUB_ACCOUNT_CODE" + "      left join budget_definition bd on bd.budget_definition_id=GL.budget where 1=1 " + whereCond
							+ "  group  by LEDGER_DATE,general_ledger_id,cost_center_name,project_name,e.entity_name,ce.entity_name;";

					lGeneralLedgerTransactionList = jdbcTemplate.query(query, new Object[] {}, new BeanPropertyRowMapper<>(GeneralLedgerBean.class));
					
				}
				

				
				
				else {
					
				
				query = "with t as ( "
						+ "select transaction_no  from general_ledger  where account_code in  ('"+objGeneralLedgerBean.getAcctHeadId1()+"','"+objGeneralLedgerBean.getAcctcode()+"') group by transaction_no "
						+ "having count(*) > 1 "
						+ " "
						+ ") "
						+ " "
						+ " "
						+ "Select TO_CHAR(LEDGER_DATE,'DD-MM-YYYY') as ledgerDate,     general_ledger_id ledgerNo,account_code as accountHeadCode, "
						+ "GL.transaction_no as transactionNo,     coalesce(GL.narration , '') as narration,     CURRENCY_CODE as currency, "
						+ "exchange_rate as exchangeRate,    coalesce(e.entity_name,ce.entity_name) as subAccountCode,   GL.parent_code as subgroup , "
						+ "SUM(COALESCE(TC_DEBIT,0)) as tcDebit,SUM(COALESCE(TC_CREDIT,0)) as tcCredit,SUM(COALESCE(BC_DEBIT,0)) as bcDebit, "
						+ "SUM(COALESCE(BC_CREDIT,0)) as bcCredit "
						+ "						   ,cost_center_name as costCenter,party_inv_no as partyInvoiceNo,     project_name as budget "
						+ "						   from general_ledger GL "
						+ "						     left join cost_center   cc on cc.cost_center_id::text =GL.cost_center "
						+ "							 left join entity e on e.supplier_acct_code=SUB_ACCOUNT_CODE "
						+ "							 left join customer_entity ce on ce.customer_acct_code=SUB_ACCOUNT_CODE "
						+ "							 left join budget_definition bd on bd.budget_definition_id=GL.budget "
						+ "							 right join t on t.transaction_no = GL.transaction_no "
						+ "							 where 1=1  " + whereCond + "  " 
						+ "						  group  by LEDGER_DATE,general_ledger_id,cost_center_name,project_name,e.entity_name,ce.entity_name";
						
						
						
						
				
						
						
						/*"with t as ( "
						+ "select transaction_no  from general_ledger  where account_code in ('"+objGeneralLedgerBean.getAcctcode()+"','"+objGeneralLedgerBean.getAcctHeadId()+"') group by transaction_no "
						+ "having count(*) > 1 "
						+ " "
						+ ") "
						+ " "
						+ "Select TO_CHAR(LEDGER_DATE,'DD-MM-YYYY') as ledgerDate,   general_ledger_id ledgerNo,account_code as accountHeadCode,      transaction_no as transactionNo,      coalesce(GL.narration , '') as narration,   CURRENCY_CODE as currency,   exchange_rate as exchangeRate,     coalesce(e.entity_name,ce.entity_name) as subAccountCode,   GL.parent_code as subgroup ,   SUM(COALESCE(TC_DEBIT,0)) as tcDebit,SUM(COALESCE(TC_CREDIT,0)) as tcCredit,SUM(COALESCE(BC_DEBIT,0)) as bcDebit,   SUM(COALESCE(BC_CREDIT,0)) as bcCredit , "
						+ "	cost_center_name as costCenter,party_inv_no as partyInvoiceNo,     project_name as budget from general_ledger GL    left join cost_center    cc on cc.cost_center_id::text =GL.cost_center          left join entity e on e.supplier_acct_code=SUB_ACCOUNT_CODE    						left join customer_entity ce on ce.customer_acct_code=SUB_ACCOUNT_CODE         left join budget_definition bd on bd.budget_definition_id=GL.budget where 1=1     " + whereCond +"  "
					 
						+ "	 and gl.account_code = '"+objGeneralLedgerBean.getAcctHeadId()+"' group  by LEDGER_DATE,general_ledger_id,cost_center_name,project_name,e.entity_name,ce.entity_name";*/
						
						/*"Select TO_CHAR(LEDGER_DATE,'DD-MM-YYYY') as ledgerDate," + "general_ledger_id ledgerNo,account_code as accountHeadCode,  " + " transaction_no as transactionNo, " + "  coalesce(GL.narration , '') as narration," + "CURRENCY_CODE as currency,   exchange_rate as exchangeRate," + "  coalesce(e.entity_name,ce.entity_name) as subAccountCode,   GL.parent_code as subgroup ,   SUM(COALESCE(TC_DEBIT,0)) as tcDebit,SUM(COALESCE(TC_CREDIT,0)) as tcCredit,SUM(COALESCE(BC_DEBIT,0)) as bcDebit,   SUM(COALESCE(BC_CREDIT,0)) as bcCredit "
						+ ",cost_center_name as costCenter,party_inv_no as partyInvoiceNo," + "" + " project_name as budget from general_ledger GL" + " left join cost_center" + " cc on cc.cost_center_id::text =GL.cost_center " + "      left join entity e on e.supplier_acct_code=SUB_ACCOUNT_CODE " + "						left join customer_entity ce on ce.customer_acct_code=SUB_ACCOUNT_CODE" + "      left join budget_definition bd on bd.budget_definition_id=GL.budget where 1=1 " + whereCond
						+ "  group  by LEDGER_DATE,general_ledger_id,cost_center_name,project_name,e.entity_name,ce.entity_name;";*/

				lGeneralLedgerTransactionList = jdbcTemplate.query(query, new Object[] {}, new BeanPropertyRowMapper<>(GeneralLedgerBean.class));

				System.out.println("Test" + query);
			}
				
				
				
			}

		} catch (DataAccessException | SQLException e) {
			e.printStackTrace();

		}
		return lGeneralLedgerTransactionList;
	}

	public String search1(GeneralLedgerBean objTrialBalanceBean) throws SQLException {

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
			whereCond += " and gl.ledger_date::date >= TO_DATE('" + objTrialBalanceBean.getFromDate() + "','DD-MM-YYYY')";

		}
		if (objTrialBalanceBean.getToDate() != null && !objTrialBalanceBean.getToDate().isEmpty()) {
			whereCond += " and gl.ledger_date::date <= TO_DATE('" + objTrialBalanceBean.getToDate() + "','DD-MM-YYYY')";

		}

		/*if (objTrialBalanceBean.getSubGroupId() != null && !objTrialBalanceBean.getSubGroupId().isEmpty()) {
			whereCond += " and gl.parent_code = '" + objTrialBalanceBean.getSubGroupId() + "'";

		}*/
		if (objTrialBalanceBean.getAcctHeadId1() != null && !objTrialBalanceBean.getAcctHeadId1().isEmpty()) {
			whereCond += " and gl.account_code = '" + objTrialBalanceBean.getAcctHeadId1() + "'";

		}
		/*if (objTrialBalanceBean.getSubAccountFilterId() != null && !objTrialBalanceBean.getSubAccountFilterId().isEmpty()) {
			whereCond += " and gl.sub_account_code = '" + objTrialBalanceBean.getSubAccountFilterId() + "'";

		}
		if (objTrialBalanceBean.getCostCenter() != null && !objTrialBalanceBean.getCostCenter().isEmpty()) {
			whereCond += " and gl.cost_center = '" + objTrialBalanceBean.getCostCenter() + "'";

		}

		if (objTrialBalanceBean.getAccountHeadCode() != null && !objTrialBalanceBean.getAccountHeadCode().isEmpty()) {
			whereCond += " and gl.account_code = '" + objTrialBalanceBean.getAccountHeadCode() + "'";

		}*/

		return whereCond;
	}

	@Override
	public List<GeneralLedgerBean> getGeneralLedgerList(GeneralLedgerBean objGeneralLedgerBean) {
		List<GeneralLedgerBean> lGeneralLedgerList = new ArrayList<>();
		try {
			List<GeneralLedgerBean> lGeneralLedgerSGList = new ArrayList<>();
			lGeneralLedgerSGList = getGeneralLedgerReport(objGeneralLedgerBean);

			for (GeneralLedgerBean objGeneralLedgerSGBean : lGeneralLedgerSGList) {
				List<GeneralLedgerBean> lGeneralLedgerAHList = new ArrayList<>();
				List<GeneralLedgerBean> lGeneralLedgerAHtempList = new ArrayList<>();
				objGeneralLedgerSGBean.setFromDate(objGeneralLedgerBean.getFromDate());
				objGeneralLedgerSGBean.setToDate(objGeneralLedgerBean.getToDate());
				objGeneralLedgerSGBean.setCompanyCode(objGeneralLedgerBean.getCompanyCode());

				if (objGeneralLedgerBean.getSubAccountCode() != "" && objGeneralLedgerBean.getSubAccountCode() != null)
					objGeneralLedgerSGBean.setSubAccountCode(objGeneralLedgerBean.getSubAccountCode());

				lGeneralLedgerAHtempList = getGeneralLedgerAHLevel(objGeneralLedgerSGBean);

				for (GeneralLedgerBean objGeneralLedgerAHBean : lGeneralLedgerAHtempList) {
					List<GeneralLedgerBean> lTransactionList = new ArrayList<>();
					objGeneralLedgerAHBean.setFromDate(objGeneralLedgerBean.getFromDate());
					objGeneralLedgerAHBean.setToDate(objGeneralLedgerBean.getToDate());
					objGeneralLedgerAHBean.setCompanyCode(objGeneralLedgerBean.getCompanyCode());

					if (objGeneralLedgerBean.getSubAccountCode() != "" && objGeneralLedgerBean.getSubAccountCode() != null)
						objGeneralLedgerAHBean.setSubAccountCode(objGeneralLedgerBean.getSubAccountCode());

					lTransactionList = getGLTransactionLevel(objGeneralLedgerAHBean);
					objGeneralLedgerAHBean.setlTransactionList(lTransactionList);
					lGeneralLedgerAHList.add(objGeneralLedgerAHBean);
				}
				objGeneralLedgerSGBean.setlGeneralLedgerAHLevelList(lGeneralLedgerAHList);
				lGeneralLedgerList.add(objGeneralLedgerSGBean);
			}
		} catch (DataAccessException e) {
		}
		return lGeneralLedgerList;
	}

	// normsl
	@Override
	public List<GeneralLedgerBean> getSubLedgerReport(GeneralLedgerBean objGeneralLedgerBean) {
		List<GeneralLedgerBean> lGeneralLedgerList = new ArrayList<>();
		String subGroupCode = null, mailAcctCode = null, subAcctCode = null;
		String compCode = "";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			// normal
			String sDynamicQuery = null;
			// String sDynamicQuery =
			// GeneralLedgerQueryUtil.GET_SUB_LEDGER_REPORT;
			if (objGeneralLedgerBean.getCompanyCode().equalsIgnoreCase("ALL"))

			{
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "") {
						compCode = lCompany.get(i);
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

			sDynamicQuery += " AND trim(GENERAL_LEDGER.COMPANY_CODE) in (" + compCode + ")";

			if (objGeneralLedgerBean.getMainAccountCode() != null && objGeneralLedgerBean.getMainAccountCode() != "") {
				sDynamicQuery += " AND trim(AH.ACCT_HEAD_CODE) ='" + objGeneralLedgerBean.getMainAccountCode() + "'";
			}

			sDynamicQuery += " ORDER BY LEDGER_DT DESC ";
			System.out.println("sDynamicQuery---normal query" + sDynamicQuery);
			/*
			 * lGeneralLedgerList = jdbcTemplate.query(sDynamicQuery,new Object[]
			 * {objGeneralLedgerBean.getSubAccountCode(),
			 * objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate() }, new
			 * BeanPropertyRowMapper<GeneralLedgerBean >(GeneralLedgerBean.class));
			 */

			/*
			 * if(objGeneralLedgerBean.getSubGroupCode() != null &&
			 * objGeneralLedgerBean.getSubGroupCode() != "") subGroupCode =
			 * objGeneralLedgerBean.getSubGroupCode();
			 */

			Boolean check1 = false;
			if (objGeneralLedgerBean.getMainAccountCode() != null && objGeneralLedgerBean.getMainAccountCode() != "") {
				mailAcctCode = objGeneralLedgerBean.getMainAccountCode();

			}
			if (objGeneralLedgerBean.getSubAccountCode() != null && objGeneralLedgerBean.getSubAccountCode() != "") {
				subAcctCode = objGeneralLedgerBean.getSubAccountCode();
				if (isNum(objGeneralLedgerBean.getSubAccountCode())) {

					System.out.println("up:" + objGeneralLedgerBean.getSubAccountCode());

				} else {

					System.out.println("down:" + objGeneralLedgerBean.getSubAccountCode());
					subAcctCode = jdbcTemplate.queryForObject(GeneralLedgerQueryUtil.get_acct_head_code, new Object[] { objGeneralLedgerBean.getSubAccountCode() }, String.class);
					System.out.println("getcode:" + subAcctCode);
				}
				check1 = true;
			}

			if (!check1) {

				lGeneralLedgerList = jdbcTemplate.query(GeneralLedgerQueryUtil.excelByAcctHead, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), objGeneralLedgerBean.getSubGroupCode(), mailAcctCode, subAcctCode }, new BeanPropertyRowMapper<>(GeneralLedgerBean.class));

			} else {
				lGeneralLedgerList = jdbcTemplate.query(GeneralLedgerQueryUtil.EXCELBYACCTHEADNOTINTDS, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), objGeneralLedgerBean.getSubGroupCode(), mailAcctCode, subAcctCode }, new BeanPropertyRowMapper<>(GeneralLedgerBean.class));

			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lGeneralLedgerList;
	}

	@Override
	public List<GeneralLedgerBean> getSubLedgerReport1(GeneralLedgerBean objGeneralLedgerBean) {
		List<GeneralLedgerBean> lGeneralLedgerList = new ArrayList<>();
		String subGroupCode = null, mailAcctCode = null, subAcctCode = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			// normal
			String sDynamicQuery = null;
			String compCode = "";
			if (objGeneralLedgerBean.getCompanyCode().equalsIgnoreCase("ALL"))

			{
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("company_code"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "") {
						compCode = lCompany.get(i);
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
			// String sDynamicQuery =
			// GeneralLedgerQueryUtil.GET_SUB_LEDGER_REPORT;

			if (objGeneralLedgerBean.getMainAccountCode() != null && objGeneralLedgerBean.getMainAccountCode() != "")
				mailAcctCode = objGeneralLedgerBean.getMainAccountCode();

			lGeneralLedgerList = jdbcTemplate.query(GeneralLedgerQueryUtil.excelByAcctHead_sub, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), subGroupCode, mailAcctCode, objGeneralLedgerBean.getSubAccountCode() }, new BeanPropertyRowMapper<>(GeneralLedgerBean.class));

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lGeneralLedgerList;
	}

	// new
	@Override
	public List<GeneralLedgerBean> getSubLedgerReport_only(GeneralLedgerBean objGeneralLedgerBean) {
		List<GeneralLedgerBean> lGeneralLedgerList = new ArrayList<>();
		String subGroupCode = null, mailAcctCode = null, subAcctCode = null;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String sDynamicQuery = null;
			String compCode = "";
			String pol = "";
			if (objGeneralLedgerBean.getLpayer().size() > 0) {
				String polcommaValues = StringUtils.collectionToCommaDelimitedString(objGeneralLedgerBean.getLpayer());

				String[] polseqComma = polcommaValues.split(",");
				for (int i = 0; i < polseqComma.length; i++) {
					pol += "'" + polseqComma[i] + "',";
				}
				StringBuilder str = new StringBuilder(pol);
				pol = str.replace(pol.lastIndexOf(","), pol.lastIndexOf(",") + 1, "").toString();

			}

			String subAccount[] = objGeneralLedgerBean.getSubAccountCode().split(",");
			if (objGeneralLedgerBean.getCompanyCode().equalsIgnoreCase("ALL"))

			{
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_CODE"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "") {
						compCode = lCompany.get(i);
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
			/*
			 * String subAcct=""; for(int i=0;i<subAccount.length;i++){ if(subAcct==""){
			 * subAcct=subAccount[i]; } else{ subAcct+=","+subAccount[i]; } }
			 */
			if (objGeneralLedgerBean.getMainAccountCode() != null && objGeneralLedgerBean.getMainAccountCode() != "")
				mailAcctCode = objGeneralLedgerBean.getMainAccountCode();
			// objGeneralLedgerBean.getCompanyCode() to Companycode change
			lGeneralLedgerList = jdbcTemplate.query(GeneralLedgerQueryUtil.excelByAcctHead_sub, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), subGroupCode, mailAcctCode, objGeneralLedgerBean.getSubAccountCode() }, new BeanPropertyRowMapper<>(GeneralLedgerBean.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return lGeneralLedgerList;
	}

	// account head
	@Override
	public List<GeneralLedgerBean> getConsolidatedGeneralLedgerList(GeneralLedgerBean objGeneralLedgerBean) {
		List<GeneralLedgerBean> lGeneralLedgerList = new ArrayList<>();
		String subGroupCode = null, AcctCode = null, subAcctCode = null;
		
		String compCodes = "";
		String whereCond = "";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			if (objGeneralLedgerBean.getCompanyCode().equalsIgnoreCase("All")) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("company_code"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCodes == "") {
						compCodes += lCompany.get(i);
					} else {
						compCodes += "," + lCompany.get(i);
					}
				}
			} else {
				String companyCodes[] = objGeneralLedgerBean.getCompanyCode().split(",");

				for (int i = 0; i < companyCodes.length; i++) {
					if (compCodes == "") {
						compCodes = companyCodes[i];
					} else {
						compCodes += "," + companyCodes[i];
					}
				}

			}

			/*
			 * String groupCode = ""; if (objGeneralLedgerBean.getGroupCode() != "") {
			 * String groupCodes[] = objGeneralLedgerBean.getGroupCode().split(","); for
			 * (int i = 0; i < groupCodes.length; i++) { if (groupCodes.length > 0) { if
			 * (groupCode == "") { if (groupCodes.length == 1) groupCode =
			 * " AND ( GL.SUB_GROUP_CODE LIKE '" + groupCodes[i] + "%' )"; else groupCode =
			 * " AND ( GL.SUB_GROUP_CODE LIKE '" + groupCodes[i] + "%'"; } else { if
			 * (groupCodes.length - 1 == i) groupCode += " OR GL.SUB_GROUP_CODE LIKE '" +
			 * groupCodes[i] + "%' )"; else groupCode += " OR GL.SUB_GROUP_CODE LIKE '" +
			 * groupCodes[i] + "%'"; } } } } // account head String sDynamicQuery = null; //
			 * String sDynamicQuery = //
			 * GeneralLedgerQueryUtil.GET_CONSOLIDATED_LEDGER_LIST;
			 * 
			 * if (groupCode != "" && groupCode != null) { sDynamicQuery += groupCode; }
			 * 
			 * if (objGeneralLedgerBean.getSubGroupCode() != "" &&
			 * objGeneralLedgerBean.getSubGroupCode() != null) { sDynamicQuery +=
			 * " AND trim(GL.SUB_GROUP_CODE) = '" + objGeneralLedgerBean.getSubGroupCode() +
			 * "'"; } if (objGeneralLedgerBean.getMainAccountCode() != "" &&
			 * objGeneralLedgerBean.getMainAccountCode() != null) { sDynamicQuery +=
			 * " AND trim(GL.ACCOUNT_HEAD) = '" + objGeneralLedgerBean.getMainAccountCode()
			 * + "'"; }
			 * 
			 * if (objGeneralLedgerBean.getSubAccountCode() != "" &&
			 * objGeneralLedgerBean.getSubAccountCode() != null) { sDynamicQuery +=
			 * " AND trim(GL.SUB_ACCOUNT_CODE) = '" +
			 * objGeneralLedgerBean.getSubAccountCode() + "'"; }
			 */
			// AND GL.COMPANY_CODE=?
			// sDynamicQuery += " AND trim(GL.COMPANY_CODE) in (" + compCodes +
			// ")";
			// sDynamicQuery +=
			// " ORDER BY GL.ACCOUNT_HEAD,GL.ledger_dt,GL.Particulars ";
			// System.out.println(sDynamicQuery);
			// String groupCodes = objGeneralLedgerBean.getGroupCode();

			// lGeneralLedgerList =
			// jdbcTemplate.query(GeneralLedgerQueryUtil.excelByAcctHead, new
			// Object[] { objGeneralLedgerBean.getCompanyCode(),
			// objGeneralLedgerBean.getFromDate(),
			// objGeneralLedgerBean.getToDate() }, new
			// BeanPropertyRowMapper<>(GeneralLedgerBean.class));

			if (objGeneralLedgerBean.getCompanyCode() != null && !objGeneralLedgerBean.getCompanyCode().isEmpty()) {
				whereCond = whereCond + " and g.company_id ='" + objGeneralLedgerBean.getCompanyCode() + "'";
				compCodes =  objGeneralLedgerBean.getCompanyCode();
				//System.out.println("company_id = " +compCodes);
			}

			if (objGeneralLedgerBean.getCostCenter() != null && !objGeneralLedgerBean.getCostCenter().isEmpty()) {
				whereCond = whereCond + " and g.cost_center	 ='" + objGeneralLedgerBean.getCostCenter() + "'";
				//System.out.println(" and g.cost_center	 = '"+ objGeneralLedgerBean.getCostCenter());
			}

			if (objGeneralLedgerBean.getFromDate() != null && !objGeneralLedgerBean.getFromDate().isEmpty()) {
				whereCond = whereCond + " and ledger_date >=to_date('" + objGeneralLedgerBean.getFromDate() + "','dd/mm/yyyy')";
				//System.out.println("and from ledger_date = " +objGeneralLedgerBean.getFromDate());
			}

			if (objGeneralLedgerBean.getToDate() != null && !objGeneralLedgerBean.getToDate().isEmpty()) {
				whereCond = whereCond + " and ledger_date <=to_date('" + objGeneralLedgerBean.getToDate() + "','dd/mm/yyyy')";
				//System.out.println("and to ledger_date = " +objGeneralLedgerBean.getToDate());
			}

			if (objGeneralLedgerBean.getSubGroupId() != null && !objGeneralLedgerBean.getSubGroupId().isEmpty()) {
				whereCond = whereCond + " and g.parent_code = '" + objGeneralLedgerBean.getSubGroupId() + "'";
				//System.out.println(" and g.parent_code = '" + objGeneralLedgerBean.getSubGroupId());

			}
			if (objGeneralLedgerBean.getAcctHeadId() != null && !objGeneralLedgerBean.getAcctHeadId().isEmpty()) {
				whereCond = whereCond + " and g.account_code = '" + objGeneralLedgerBean.getAcctHeadId() + "'";
				//System.out.println(" and g.account_code = '" + objGeneralLedgerBean.getAcctHeadId());
				AcctCode = objGeneralLedgerBean.getAcctHeadId();

			}
			if (objGeneralLedgerBean.getSubAccountFilterId() != null && !objGeneralLedgerBean.getSubAccountFilterId().isEmpty()) {
				whereCond = whereCond + " and g.sub_account_code = '" + objGeneralLedgerBean.getSubAccountFilterId() + "'";
				//System.out.println(" and g.sub_account_code = '" + objGeneralLedgerBean.getSubAccountFilterId());

			}

			//lGeneralLedgerList = jdbcTemplate.query(GeneralLedgerQueryUtil.excelByAcctHead + whereCond + "", new BeanPropertyRowMapper<>(GeneralLedgerBean.class));
			lGeneralLedgerList = jdbcTemplate.query(GeneralLedgerQueryUtil.GET_VIEW_REPORT , new Object[]{compCodes, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(),AcctCode, AcctCode, AcctCode, AcctCode, AcctCode, AcctCode, AcctCode, AcctCode, AcctCode, AcctCode, AcctCode, AcctCode, AcctCode, AcctCode, AcctCode, AcctCode, AcctCode, AcctCode}, new BeanPropertyRowMapper<>(GeneralLedgerBean.class));

			//String query = GeneralLedgerQueryUtil.excelByAcctHead;
			//System.out.println("report qry = " +GeneralLedgerQueryUtil.GET_VIEW_REPORT );

			/*
			 * query = "with t as (" +
			 * " select  * from vw_gl_report('C0021,C0011','01/01/2016','31/12/2016',null,null,null) "
			 * +" where not null_or_empty(accountheadcode)" +" )" +
			 * " select * from t where SUBSTRING (accountheadcode ,0 , 3)::int in (50,60,70,80,90)"
			 * ;
			 */
			/*
			 * if (groupCodes != null && groupCodes != "") { query = query +
			 * " where SUBSTRING (accountheadcode ,0 , 3 )::int in (" + groupCodes + ")"; }
			 * System.out.println(query); if (objGeneralLedgerBean.getSubGroupCode() != null
			 * && objGeneralLedgerBean.getSubGroupCode() != "") subGroupCode =
			 * objGeneralLedgerBean.getSubGroupCode(); if
			 * (objGeneralLedgerBean.getMainAccountCode() != null &&
			 * objGeneralLedgerBean.getMainAccountCode() != "") mailAcctCode =
			 * objGeneralLedgerBean.getMainAccountCode(); if
			 * (objGeneralLedgerBean.getSubAccountCode() != null &&
			 * objGeneralLedgerBean.getSubAccountCode() != "") subAcctCode =
			 * objGeneralLedgerBean.getSubAccountCode();
			 * 
			 * lGeneralLedgerList = jdbcTemplate.query(query, new Object[] { compCodes,
			 * objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(),
			 * subGroupCode, mailAcctCode, subAcctCode }, new
			 * BeanPropertyRowMapper<GeneralLedgerBean>(GeneralLedgerBean .class));
			 */
		} catch (DataAccessException e) {

		}
		return lGeneralLedgerList;
	}

	// normal
	@Override
	public List<GeneralLedgerBean> getGeneralLedgerListOP(GeneralLedgerBean objGeneralLedgerBean) {
		List<GeneralLedgerBean> lGeneralLedgerList = new ArrayList<>();
		String subGroupCode = null, mailAcctCode = null, subAcctCode = null;
		try {
			String compCode = "'";
			String compCodes = "";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (objGeneralLedgerBean.getCompanyCode().equalsIgnoreCase("ALL"))

			{
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
				String companyCodes[] = objGeneralLedgerBean.getCompanyCode().split(",");

				for (int i = 0; i < companyCodes.length; i++) {
					if (compCode == "'") {
						compCode += companyCodes[i];
					} else {
						compCode += "," + companyCodes[i];
					}
				}
			}

			compCode += "'";

			if (objGeneralLedgerBean.getCompanyCode().equalsIgnoreCase("ALL"))

			{
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_CODE"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCodes == "") {
						compCodes = lCompany.get(i);
					} else {
						compCodes += "," + lCompany.get(i);
					}
				}

			} else {
				String companyCodes[] = objGeneralLedgerBean.getCompanyCode().split(",");
				for (int i = 0; i < companyCodes.length; i++) {
					if (compCodes == "") {
						compCodes = companyCodes[i];
					} else {
						compCodes += "," + companyCodes[i];
					}
				}
			}

			List<GeneralLedgerBean> lGeneralLedgerAHList = new ArrayList<>();
			// nor,al
			String sDynamicQueryOp = GeneralLedgerQueryUtil.GET_GENERAL_LEDGER_OP;
			sDynamicQueryOp += " from fn_general_ledger(" + compCode + ", TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD/MM/YYYY'), TO_DATE('" + objGeneralLedgerBean.getToDate() + "','DD/MM/YYYY')) where acct_head_code is not null ";

			if (objGeneralLedgerBean.getSubGroupCode() != "" && objGeneralLedgerBean.getSubGroupCode() != null) {
				sDynamicQueryOp += " and substr(acct_head_code,1,4) = '" + objGeneralLedgerBean.getSubGroupCode() + "'";
			}
			if (objGeneralLedgerBean.getMainAccountCode() != "" && objGeneralLedgerBean.getMainAccountCode() != null) {
				sDynamicQueryOp += " and trim(acct_head_code) = '" + objGeneralLedgerBean.getMainAccountCode() + "'";
			}

			/*
			 * if (objGeneralLedgerBean.getAccountHeadCode() != "" &&
			 * objGeneralLedgerBean.getAccountHeadCode() !=null) { sDynamicQueryOp +=
			 * " and trim(acct_head_code) = '" + objGeneralLedgerBean.getAccountHeadCode() +
			 * "'"; }
			 */
			lGeneralLedgerAHList = jdbcTemplate.query(sDynamicQueryOp + "", new BeanPropertyRowMapper<>(GeneralLedgerBean.class));

			for (GeneralLedgerBean objGeneralLedgerTransBean : lGeneralLedgerAHList) {
				List<GeneralLedgerBean> lGeneralLedgerTransList = new ArrayList<>();
				objGeneralLedgerTransBean.setFromDate(objGeneralLedgerBean.getFromDate());
				objGeneralLedgerTransBean.setToDate(objGeneralLedgerBean.getToDate());
				objGeneralLedgerTransBean.setCompanyCode(objGeneralLedgerBean.getCompanyCode());

				// normal
				String sDynamicQuery = null;

				if (objGeneralLedgerTransBean.getAccountHeadCode() != null && objGeneralLedgerTransBean.getAccountHeadCode() != "")
					mailAcctCode = objGeneralLedgerTransBean.getAccountHeadCode();
				if (objGeneralLedgerBean.getSubAccountCode() != null && objGeneralLedgerBean.getSubAccountCode() != "")
					subAcctCode = objGeneralLedgerBean.getSubAccountCode();
				lGeneralLedgerTransList = jdbcTemplate.query(GeneralLedgerQueryUtil.excelByAcctHead + " order by ledgerdate", new Object[] { compCodes, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), subGroupCode, mailAcctCode, subAcctCode }, new BeanPropertyRowMapper<>(GeneralLedgerBean.class));

				objGeneralLedgerTransBean.setlTransactionList(lGeneralLedgerTransList);
				lGeneralLedgerList.add(objGeneralLedgerTransBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lGeneralLedgerList;
	}

	@Override
	public GeneralLedgerBean getOpeningBalanceValue(GeneralLedgerBean objGeneralLedgerBean) {

		GeneralLedgerBean objGeneralLedgerBeanOP = new GeneralLedgerBean();
		String compCode = "'";

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (objGeneralLedgerBean.getCompanyCode().equalsIgnoreCase("ALL"))

			{
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
				String companyCodes[] = objGeneralLedgerBean.getCompanyCode().split(",");

				for (int i = 0; i < companyCodes.length; i++) {
					if (compCode == "'") {
						compCode += companyCodes[i];
					} else {
						compCode += "," + companyCodes[i];
					}
				}
			}

			compCode += "'"; 
			
			String subAcctCode = objGeneralLedgerBean.getAcctHeadId();
			System.out.println("Account_code : "+subAcctCode);
			System.out.println("Manin AC Code : "+objGeneralLedgerBean.getMainAccountCode());
			objGeneralLedgerBean.setMainAccountCode(subAcctCode);

			/*String subAcctCode = objGeneralLedgerBean.getSubAccountCode();
			if (objGeneralLedgerBean.getSubAccountCode() != null && objGeneralLedgerBean.getSubAccountCode() != "") {
				if (isNum(objGeneralLedgerBean.getSubAccountCode())) {

					System.out.println("up:" + objGeneralLedgerBean.getSubAccountCode());
					subAcctCode = objGeneralLedgerBean.getSubAccountCode();

				} else {

					System.out.println("down:" + objGeneralLedgerBean.getSubAccountCode());
					subAcctCode = jdbcTemplate.queryForObject(GeneralLedgerQueryUtil.get_acct_head_code, new Object[] { objGeneralLedgerBean.getSubAccountCode() }, String.class);
					System.out.println("getcode:" + subAcctCode);

				}
			}*/
			
			String sDynamicQuery = "";

			/*if (objGeneralLedgerBean.getMainAccountCode() != null && objGeneralLedgerBean.getMainAccountCode() != "") {*/

				if (subAcctCode != null && subAcctCode != "") {
					/*sDynamicQuery += " with A as (select sum(BC_CREDIT),sum(BC_DEBIT),COALESCE(sum(BC_DEBIT)-sum(BC_CREDIT),0) as opening  from general_ledger  where ACCOUNT_CODE = '" + objGeneralLedgerBean.getMainAccountCode() + "' and ledger_date::date < TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY') and  company_id in (" + compCode + ")  and sub_account_code in (select supplier_acct_code from entity where entity_id =" + subAcctCode + ")),"
							+ "B as (   select sum(BC_CREDIT) as credit,sum(BC_DEBIT) as debit, COALESCE(sum(BC_DEBIT)-sum(BC_CREDIT),0) as nowclosing from general_ledger where ACCOUNT_CODE = '" + objGeneralLedgerBean.getMainAccountCode() + "' and ledger_date::date >= TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY') and ledger_date::date <= TO_DATE('" + objGeneralLedgerBean.getToDate() + "','DD-MM-YYYY') and company_id in (" + compCode + ")  and sub_account_code in (select supplier_acct_code from entity where entity_id ="
							+ subAcctCode + "))" + "select COALESCE(a.opening,0) as openingBalance,COALESCE(opening+nowclosing,0)  as closingBalance,COALESCE(b.debit,0) as debitamount, COALESCE(b.BC_CREDIT,0) as creditamount from a,b";*/
					
					//modified query
					sDynamicQuery += "with A as ( select COALESCE(sum(BC_CREDIT),0) as credit  ,COALESCE(sum(BC_DEBIT),0) as debit,COALESCE(sum(BC_DEBIT)-sum(BC_CREDIT),0) as opening  from general_ledger  "
							+ "	where ledger_date::date < TO_DATE('"+objGeneralLedgerBean.getFromDate()+"','DD-MM-YYYY') and company_id in (" + compCode + ") and ACCOUNT_CODE = '"+subAcctCode+"'),"
							+ "B as (select COALESCE(sum(BC_CREDIT),0) as credit, COALESCE(sum(BC_DEBIT),0) as debit,COALESCE(sum(BC_DEBIT)-sum(BC_CREDIT),0) as nowclosing from general_ledger  	"
							+ "where   ACCOUNT_CODE = '"+subAcctCode+"' and ledger_date::date >= TO_DATE('"+objGeneralLedgerBean.getFromDate()+"','DD-MM-YYYY') and ledger_date::date <= "
							+ "TO_DATE('"+objGeneralLedgerBean.getToDate()+"','DD-MM-YYYY')	 and company_id in (" + compCode + "))	select COALESCE(a.opening,0) as openingBalance,b.debit as debitamount,"
							+ " b.credit as creditamount, COALESCE(opening+nowclosing,0)  as closingBalance , COALESCE(opening+b.debit,0) as newdebitamount,"
							+ " COALESCE(opening+b.credit,0) as newcreditamount from a,b";
				} else {

					sDynamicQuery += " with A as (select COALESCE(sum(BC_CREDIT),0),COALESCE(sum(BC_DEBIT),0),COALESCE(sum(BC_DEBIT)-sum(BC_CREDIT),0) as opening  from general_ledger  where ACCOUNT_CODE = '" + subAcctCode + "' and ledger_date::date < TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY') and  company_id in (" + compCode + ")),"
							+ "B as (   select COALESCE(sum(BC_CREDIT),0) as credit, COALESCE(sum(BC_DEBIT),0) as debit, COALESCE(sum(BC_DEBIT)-sum(BC_CREDIT),0) as nowclosing from general_ledger where ACCOUNT_CODE = '" + subAcctCode + "' and ledger_date::date >= TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY') and ledger_date::date <= TO_DATE('" + objGeneralLedgerBean.getToDate() + "','DD-MM-YYYY') and company_id in (" + compCode + "))"
							+ "select COALESCE(a.opening,0) as openingBalance,COALESCE(opening+nowclosing,0)  as closingBalance,COALESCE(b.debit,0) as debitamount, COALESCE(b.credit,0) as creditamount from a,b";

				}
				
			/*} else if (objGeneralLedgerBean.getSubGroupCode() != null && objGeneralLedgerBean.getSubGroupCode() != "") {
				sDynamicQuery += "" + "	with A as ( select sum(BC_CREDIT) as credit  ,sum(BC_DEBIT) as debit,COALESCE(sum(BC_DEBIT)-sum(BC_CREDIT),0) as opening  from general_ledger  " + "	where ledger_date::date < TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY')" + "	 and  company_id in  (" + compCode + ") and  SUB_ACCOUNT_CODE =  '" + objGeneralLedgerBean.getSubGroupCode() + "'), " + "	B as (select sum(BC_CREDIT) as credit,sum(BC_DEBIT) as debit,COALESCE(sum(BC_DEBIT)-sum(BC_CREDIT),0) as nowclosing from general_ledger  "
						+ "	where " + "ledger_date::date >= TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY')" + "	 and ledger_date::date <= TO_DATE('" + objGeneralLedgerBean.getToDate() + "','DD-MM-YYYY')" + "	 and company_id in (" + compCode + ") and  SUB_ACCOUNT_CODE =  '" + objGeneralLedgerBean.getSubGroupCode() + "')" + "	 select COALESCE(a.opening,0) as openingBalance,COALESCE(b.debit,0) as debitamount, COALESCE(b.credit,0) as creditamount,"
						+ " COALESCE(opening+nowclosing,0)  as closingBalance, COALESCE(opening+b.debit,0) as newdebitamount  from a,b";

			} else {

				sDynamicQuery += "" + "	with A as ( select sum(BC_CREDIT) as credit  ,sum(BC_DEBIT) as debit,sum(BC_DEBIT)-sum(BC_CREDIT) as opening  from general_ledger  " + "	where ledger_date::date < TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY')" + "	 and  company_id in  (" + compCode + ")), " + "	B as (select sum(BC_CREDIT) as credit,sum(BC_DEBIT) as debit,sum(BC_DEBIT)-sum(BC_CREDIT) as nowclosing from general_ledger  " + "	where " + "ledger_date::date >= TO_DATE('" + objGeneralLedgerBean.getFromDate()
						+ "','DD-MM-YYYY')" + "	 and ledger_date::date <= TO_DATE('" + objGeneralLedgerBean.getToDate() + "','DD-MM-YYYY')" + "	 and company_id in (" + compCode + "))" + "	select COALESCE(a.opening,0) as openingBalance,b.debit as debitamount, b.credit as creditamount," + " COALESCE(opening+nowclosing,0)  as closingBalance , COALESCE(opening+b.debit,0) as newdebitamount, COALESCE(opening+b.credit,0) as newcreditamount from a,b";
			}*/

			String companyCode = "";

			companyCode = getcompanycode(objGeneralLedgerBean);

			objGeneralLedgerBean.setCompanyName(companyCode);
			String value = "";
			String subgroupName = "";
			String subgroupAddress = "";
			String subgroupAddress1 = "";

			String subgroupAddress2 = "";
			String subgroupAddress3 = "";
			String subgroupAddress4 = "";

			String GSTno = "";

			/*
			 * String subgroupName= jdbcTemplate.queryForObject(GeneralLedgerQueryUtil
			 * .get_subgroupname,new
			 * Object[]{objGeneralLedgerBean.getSubGroupCode()},String.class);
			 * objGeneralLedgerBeanOP.setSubGroupName(subgroupName);
			 */

			if (!objGeneralLedgerBean.getSubAccountCode().equalsIgnoreCase("")) {
				value = getsubaccountname(objGeneralLedgerBean);
				String subgroupvalue[] = value.split(",");
				subgroupName = subgroupvalue[0];
				subgroupAddress = subgroupvalue[1];
				GSTno = subgroupvalue[2];
				int subgroupAddressLength = subgroupAddress.length();
				int mid = (subgroupAddressLength / 2) + 2;
				subgroupAddress1 = subgroupAddress.substring(0, mid);
				subgroupAddress2 = subgroupAddress.substring(mid, subgroupAddressLength);
				// String address[] = subgroupAddress.split(subgroupAddress,
				// 30);
				// subgroupAddress1 = address[0];
				// subgroupAddress2 = address[1];
				// subgroupAddress3 = address[2];
				// subgroupAddress4 = address[3];

				System.out.println("add" + subgroupAddress1 + "," + subgroupAddress2);

			} else if (!objGeneralLedgerBean.getMainAccountCode().equalsIgnoreCase("")) {
				subgroupName = getaccountname(objGeneralLedgerBean);
			} else if (objGeneralLedgerBean.getSubGroupCode().equalsIgnoreCase("")) {
				subgroupName = getsubgroup(objGeneralLedgerBean);
			}
				
			 else if (!objGeneralLedgerBean.getSubGroupCode().equalsIgnoreCase("")) {
				subgroupName = getsubgroup(objGeneralLedgerBean);
			}

			objGeneralLedgerBeanOP.setSubGroupName(subgroupName);
			objGeneralLedgerBeanOP.setSubGroupAddress1(subgroupAddress1);
			objGeneralLedgerBeanOP.setSubGroupAddress2(subgroupAddress2);
			objGeneralLedgerBeanOP.setSubGroupAddres3(subgroupAddress3);
			objGeneralLedgerBeanOP.setSubGroupAddress4(subgroupAddress4);

			objGeneralLedgerBeanOP.setSubGroupGST(GSTno);
			System.out.println("closing balance :" + sDynamicQuery);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sDynamicQuery);

			for (Map row : rows) {

				if (row.get("openingBalance") != null) {
					objGeneralLedgerBeanOP.setOpeningBalance(Double.valueOf(String.valueOf(row.get("openingBalance"))));
					System.out.println("opening Balance : " +Double.valueOf(String.valueOf(row.get("openingBalance"))));
				}
				if (row.get("closingBalance") != null) {
					objGeneralLedgerBeanOP.setClosingBalance(Double.valueOf(String.valueOf(row.get("closingBalance"))));
					System.out.println("closing Balance : " +Double.valueOf(String.valueOf(row.get("closingBalance"))));
				}
				if (row.get("creditamount") != null) {
					objGeneralLedgerBeanOP.setCreditamount(Double.valueOf(String.valueOf(row.get("creditamount"))));
				}
				if (row.get("debitamount") != null) {
					objGeneralLedgerBeanOP.setDebitamount(Double.valueOf(String.valueOf(row.get("debitamount"))));
				}
				if (row.get("newdebitamount") != null) {
					objGeneralLedgerBeanOP.setNewdebitamount(Double.valueOf(String.valueOf(row.get("newdebitamount"))));
				}
				if (row.get("newcreditamount") != null) {
					objGeneralLedgerBeanOP.setNewcreditamount(Double.valueOf(String.valueOf(row.get("newcreditamount"))));
				}
				if (row.get("subCode") != null) {
					objGeneralLedgerBeanOP.setSubAccountCode(((String) row.get("subCode")));
				}
				if (row.get("subName") != null) {
					objGeneralLedgerBeanOP.setSubAccountName(((String) row.get("subName")));
				}
				if (row.get("companyName") != null) {
					objGeneralLedgerBeanOP.setCompanyName(((String) row.get("companyName")));
				}

				/*
				 * objGeneralLedgerBeanOP.setOpeningBalance(((BigDecimal)
				 * row.get("openingBalance")).doubleValue());
				 * objGeneralLedgerBeanOP.setClosingBalance(((BigDecimal)
				 * row.get("closingBalance")).doubleValue());
				 * objGeneralLedgerBeanOP.setCreditamount(((BigDecimal)
				 * row.get("creditamount")).doubleValue());
				 * objGeneralLedgerBeanOP.setDebitamount(((BigDecimal)
				 * row.get("debitamount")).doubleValue());
				 * objGeneralLedgerBeanOP.setNewdebitamount(((BigDecimal)
				 * row.get("newdebitamount")).doubleValue());
				 * objGeneralLedgerBeanOP.setNewcreditamount(((BigDecimal)
				 * row.get("newcreditamount")).doubleValue());
				 * objGeneralLedgerBeanOP.setSubAccountCode(((String) row.get("subCode")));
				 * objGeneralLedgerBeanOP.setSubAccountName(((String) row.get("subName")));
				 * objGeneralLedgerBeanOP.setCompanyName(((String) row.get("companyName")));
				 */

			}
			// if(objGeneralLedgerBeanOP.getDebitamount()<0 ||
			// objGeneralLedgerBeanOP.getCreditamount()<0){
			// objGeneralLedgerBeanOP.setDebitamount(-objGeneralLedgerBeanOP.getDebitamount());
			// objGeneralLedgerBeanOP.setCreditamount(-objGeneralLedgerBeanOP.getCreditamount());
			//
			// }
			// else{
			// objGeneralLedgerBeanOP.setDebitamount(objGeneralLedgerBeanOP.getDebitamount());
			// objGeneralLedgerBeanOP.setCreditamount(objGeneralLedgerBeanOP.getCreditamount());
			//
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objGeneralLedgerBeanOP;
	}

	@Override
	public GeneralLedgerBean getOpeningBalance(GeneralLedgerBean objGeneralLedgerBean) {

		GeneralLedgerBean objGeneralLedgerBeanOP = new GeneralLedgerBean();
		String compCode = "'";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			if (objGeneralLedgerBean.getCompanyCode().equalsIgnoreCase("ALL"))

			{
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
				String companyCodes[] = objGeneralLedgerBean.getCompanyCode().split(",");

				for (int i = 0; i < companyCodes.length; i++) {
					if (compCode == "'") {
						compCode += companyCodes[i];
					} else {
						compCode += "," + companyCodes[i];
					}
				}
			}

			compCode += "'";

			String subAcctCode = objGeneralLedgerBean.getSubAccountCode();

			if (objGeneralLedgerBean.getSubAccountCode() != null && objGeneralLedgerBean.getSubAccountCode() != "") {
				if (isNum(objGeneralLedgerBean.getSubAccountCode())) {

					System.out.println("up:" + objGeneralLedgerBean.getSubAccountCode());

				} else {

					System.out.println("down:" + objGeneralLedgerBean.getSubAccountCode());
					subAcctCode = jdbcTemplate.queryForObject(GeneralLedgerQueryUtil.get_acct_head_code, new Object[] { objGeneralLedgerBean.getSubAccountCode() }, String.class);
					System.out.println("getcode:" + subAcctCode);
				}
			}

			String sDynamicQuery = "";

			if (objGeneralLedgerBean.getMainAccountCode() != null && objGeneralLedgerBean.getMainAccountCode() != "") {
				if (subAcctCode != null && subAcctCode != "") {
					sDynamicQuery = GeneralLedgerQueryUtil.GET_OPENING_BALANCE;
					sDynamicQuery += " from fn_sub_ledger_with_ah(" + compCode + ", TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY'), TO_DATE('" + objGeneralLedgerBean.getToDate() + "','DD-MM-YYYY'),'" + subAcctCode + "','" + objGeneralLedgerBean.getMainAccountCode() + "') ";
				} else {

					sDynamicQuery += " with A as (select sum(credit),sum(debit),sum(debit)-sum(credit) as opening  from general_ledger  where ACCOUNT_HEAD = '" + objGeneralLedgerBean.getMainAccountCode() + "' and ledger_dt::date < TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY') and  company_code in (" + compCode + ")),"

							+ "B as (select sum(credit),sum(debit),sum(debit)-sum(credit) as nowclosing from general_ledger  where ACCOUNT_HEAD = '" + objGeneralLedgerBean.getMainAccountCode() + "' and ledger_dt::date >= TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY') and ledger_dt::date <= TO_DATE('" + objGeneralLedgerBean.getToDate() + "','DD-MM-YYYY') and company_code in (" + compCode + "))"
							+ "select COALESCE(a.opening,0) as openingBalance,COALESCE(opening+nowclosing,0)  as closingBalance,'test' subCode,'test' subName from a,b";

				}
			} else {
				sDynamicQuery = GeneralLedgerQueryUtil.GET_OPENING_BALANCE;
				sDynamicQuery += " from fn_sub_ledger(" + compCode + ", TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY'), TO_DATE('" + objGeneralLedgerBean.getToDate() + "','DD-MM-YYYY'),'" + subAcctCode + "',null) ";
			}

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sDynamicQuery);

			for (Map row : rows) {

				objGeneralLedgerBeanOP.setOpeningBalance(((BigDecimal) row.get("openingbalance")).doubleValue());
				objGeneralLedgerBeanOP.setClosingBalance(((BigDecimal) row.get("closingbalance")).doubleValue());

				// objGeneralLedgerBeanOP.setOpeningBalanceTC(((BigDecimal)
				// row.get("openingBalanceTC")).doubleValue());
				// objGeneralLedgerBeanOP.setClosingBalanceTC(((BigDecimal)
				// row.get("closingBalanceTC")).doubleValue());
				//
				objGeneralLedgerBeanOP.setSubAccountCode(((String) row.get("subAccountCode")));
				objGeneralLedgerBeanOP.setSubAccountName(((String) row.get("subAccountName")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objGeneralLedgerBeanOP;
	}

	@Override
	public List<GeneralLedgerBean> getOpeningBalanceSub(GeneralLedgerBean objGeneralLedgerBean) {
		String mailAcctCode = null;

		List<GeneralLedgerBean> GeneralLedgerBean = new ArrayList<>();
		try {
			String compCode = "'";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (objGeneralLedgerBean.getCompanyCode().equalsIgnoreCase("ALL"))

			{
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
				compCode += "'";
			} else {
				String companyCodes[] = objGeneralLedgerBean.getCompanyCode().split(",");

				for (int i = 0; i < companyCodes.length; i++) {
					compCode = companyCodes[i];
					/*
					 * if(compCode=="'"){ compCode += companyCodes[i]; } else{
					 * compCode+=","+companyCodes[i]; }
					 */
				}
			}

			/*
			 * String subAcctList[] = objGeneralLedgerBean.getSubAccountCode().split(",");
			 * String subAcct=""; for(int i=0;i<subAcctList.length;i++){ if(subAcct==""){
			 * subAcct=subAcctList[i]; } else{ subAcct+=","+subAcctList[i]; } }
			 */
			if (objGeneralLedgerBean.getMainAccountCode() != null && objGeneralLedgerBean.getMainAccountCode() != "")
				mailAcctCode = objGeneralLedgerBean.getMainAccountCode();

			// String sDynamicQuery
			// =GeneralLedgerQueryUtil.GET_OPENING_BALANCE_SUB;

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(GeneralLedgerQueryUtil.GET_OPENING_BALANCE_SUB, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), objGeneralLedgerBean.getSubAccountCode(), mailAcctCode });

			// sDynamicQuery +=
			// " from fn_sub_ledger_with_ah("+compCode+",
			// TO_DATE('"+objGeneralLedgerBean.getFromDate()+"','DD-MM-YYYY'),
			// TO_DATE('"+objGeneralLedgerBean.getToDate()+"','DD-MM-YYYY'),'"+objGeneralLedgerBean.getSubAccountCode()+"','"+mailAcctCode+"')
			// ";

			// List<Map<String, Object>> rows =
			// jdbcTemplate.queryForList(sDynamicQuery);

			for (Map row : rows) {
				GeneralLedgerBean objGeneralLedgerBeanOP = new GeneralLedgerBean();
				objGeneralLedgerBeanOP.setOpeningBalance(((BigDecimal) row.get("openingBalance")).doubleValue());
				objGeneralLedgerBeanOP.setClosingBalance(((BigDecimal) row.get("closingBalance")).doubleValue());

				objGeneralLedgerBeanOP.setSubAccountCode(((String) row.get("subCode")));
				objGeneralLedgerBeanOP.setSubAccountName(((String) row.get("subName")));
				GeneralLedgerBean.add(objGeneralLedgerBeanOP);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return GeneralLedgerBean;
	}

	@Override
	public List<SelectivityBean> getsub(List<String> sub) throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			String test = "";
			for (int count = 0; count < sub.size(); count++) {
				if (test.isEmpty()) {
					/* test = sub.get(count); */
					test += "'" + sub.get(count) + "'";
				} else {
					/* test = "'"test+","+sub.get(count); */
					test += "," + "'" + sub.get(count) + "'";
				}
			}

			String queries = "select sgam.SUB_GROUP_ACCT_CODE as id,sgam.SUB_GROUP_ACCT_NAME as text  from SUB_GROUP_ACCT_MASTER sgam left join GROUP_HEAD_MASTER ghm on ghm.group_head_code = sgam.group_head_code where ghm.group_head_name in (" + test + ") order by SUB_GROUP_ACCT_NAME ASC";
			List<SelectivityBean> listdub = jdbcTemplate.query(queries, new BeanPropertyRowMapper<>(SelectivityBean.class));
			return listdub;
		} catch (DataAccessException e) {

			throw new CustomException("Error in Get Customer List");
		}

	}

	@Override
	public List<SelectivityBean> getmain(String main) throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			List<SelectivityBean> listdub = jdbcTemplate.query(GeneralLedgerQueryUtil.get_main_list, new Object[] { main }, new BeanPropertyRowMapper<>(SelectivityBean.class));
			return listdub;
		} catch (DataAccessException e) {

			throw new CustomException("Error in Get Customer List");
		}
	}

	// Account Based Transaction

	@Override
	public List<GeneralLedgerBean> getGeneralTransaction(GeneralLedgerBean objGeneralLedgerBean) {
		List<GeneralLedgerBean> lGeneralLedgerAHList = new ArrayList<>();
		try {

			String compCode = "", subGroupCode = "", mainAcctCode = "", subAcctCode = "";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (objGeneralLedgerBean.getCompanyCode().equalsIgnoreCase("ALL")) {

				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_CODE"));
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

			String groupCode = "";
			if (objGeneralLedgerBean.getGroupCode() != "" && objGeneralLedgerBean.getGroupCode() != null) {
				String groupCodes[] = objGeneralLedgerBean.getGroupCode().split(",");
				for (int i = 0; i < groupCodes.length; i++) {
					if (groupCode == "") {
						groupCode = groupCodes[i];
					} else {
						groupCode += "," + groupCodes[i];
					}
				}
			}
			if (objGeneralLedgerBean.getSubGroupCode() != "")
				subGroupCode = objGeneralLedgerBean.getSubGroupCode();
			else
				subGroupCode = null;
			if (objGeneralLedgerBean.getMainAccountCode() != "")
				mainAcctCode = objGeneralLedgerBean.getAccountHeadCode();
			else
				mainAcctCode = null;
			if (objGeneralLedgerBean.getSubAccountCode() != "")
				subAcctCode = objGeneralLedgerBean.getSubAccountCode();
			else
				subAcctCode = null;

			lGeneralLedgerAHList = jdbcTemplate.query(GeneralLedgerQueryUtil.GET_VIEW_REPORT2, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), subGroupCode, mainAcctCode, subAcctCode }, new BeanPropertyRowMapper<>(GeneralLedgerBean.class));

		} catch (DataAccessException e) {

		}
		return lGeneralLedgerAHList;
	}

	@Override
	public String getcompanycode(GeneralLedgerBean objGeneralLedgerBean) {
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
	public String getsubgroup(GeneralLedgerBean objGeneralLedgerBean) {
		String list = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			list = jdbcTemplate.queryForObject(GeneralLedgerQueryUtil.SubGroup, new Object[] { objGeneralLedgerBean.getSubGroupCode() }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			// LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	@Override
	public String getaccountname(GeneralLedgerBean objGeneralLedgerBean) {
		String list = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			list = jdbcTemplate.queryForObject(GeneralLedgerQueryUtil.getAccountName, new Object[] { objGeneralLedgerBean.getMainAccountCode() }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			// LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	@Override
	public String getsubaccountname(GeneralLedgerBean objGeneralLedgerBean) {
		String value = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String subAcctCode = "";

		try {
			if (isNum(objGeneralLedgerBean.getSubAccountCode())) {

				System.out.println("up:" + objGeneralLedgerBean.getSubAccountCode());
				subAcctCode = objGeneralLedgerBean.getSubAccountCode();

			} else {

				System.out.println("down:" + objGeneralLedgerBean.getSubAccountCode());
				subAcctCode = jdbcTemplate.queryForObject(GeneralLedgerQueryUtil.get_acct_head_code, new Object[] { objGeneralLedgerBean.getSubAccountCode() }, String.class);
				System.out.println("getcode:" + subAcctCode);

			}
			System.out.println("select srvc_prtnr_nam from service_partner where srvc_prtnr_bin =" + subAcctCode);

			String query = "select srvc_prtnr_nam from service_partner where srvc_prtnr_bin =" + subAcctCode;
			value = jdbcTemplate.queryForObject(query, new Object[] {}, String.class);
			String query1 = "select addrs1_add from service_partner where srvc_prtnr_bin =" + subAcctCode;
			value += ",";
			value += jdbcTemplate.queryForObject(query1, new Object[] {}, String.class);

			String query2 = "select gstn_no from service_partner where srvc_prtnr_bin =" + subAcctCode;
			value += ",";
			value += jdbcTemplate.queryForObject(query2, new Object[] {}, String.class);

			System.out.println(value);

		} catch (DataAccessException e) {
		}
		return value;
	}

	@Override
	public GeneralLedgerBean getJournalVoucherforPrint(String voyage) {
		GeneralLedgerBean bean = new GeneralLedgerBean();

		List<GeneralLedgerBean> dtllisthdrBean = new ArrayList<>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {

			/*
			 * bean = jdbcTemplate.queryForObject(GeneralLedgerQueryUtil.GETPORT, new
			 * Object[] {voyage}, new BeanPropertyRowMapper<>( GeneralLedgerBean.class));
			 */

			/*
			 * dtllisthdrBean= jdbcTemplate.query(VesselSailingQueryUtil.GET_VOYPORT,new
			 * Object[] { voyage,port },new BeanPropertyRowMapper<GeneralLedgerBean
			 * >(GeneralLedgerBean.class));
			 */
			// bean.setDtllisthdrBean(dtllisthdrBean);

		} catch (DataAccessException e) {
		}

		return bean;
	}

	@Override
	public GeneralLedgerBean getAddress(GeneralLedgerBean objGeneralLedgerBean) {
		// String address = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		GeneralLedgerBean address = new GeneralLedgerBean();

		try {
			// address =
			// jdbcTemplate.queryForObject(GeneralLedgerQueryUtil.getAddress,new
			// Object[]
			// {Integer.parseInt(objGeneralLedgerBean.getSubAccountCode())},GeneralLedgerBean.class);
			/*
			 * address = jdbcTemplate.queryForObject(GeneralLedgerQueryUtil.getAddress, new
			 * Object[] {Integer.parseInt(objGeneralLedgerBean.getSubAccountCode())}, new
			 * BeanPropertyRowMapper <GeneralLedgerBean>(GeneralLedgerBean.class));
			 */

			address = jdbcTemplate.queryForObject(GeneralLedgerQueryUtil.getAddress, new Object[] { (objGeneralLedgerBean.getSubAccountCode()) }, new BeanPropertyRowMapper<>(GeneralLedgerBean.class));

			// System.out.println(list);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return address;
	}

	@Override
	public List<GeneralLedgerBean> getGeneralLedgerAHLevelAcct(GeneralLedgerBean objGeneralLedgerBean) {
		List<GeneralLedgerBean> lGeneralLedgerAHListAcc = new ArrayList<>();
		try {

			String compCode = "";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			String whereCond = "";
			String query = null;

			whereCond = searchAcc(objGeneralLedgerBean);

			if (!whereCond.isEmpty() && whereCond != "") {

				query = "with t as ( "
						+ " "
						+ "select account_code as accountHeadCode,transaction_no as transactionno    from general_ledger gl "
						+ "						 where 1=1  " + whereCond + "   group by account_code,transaction_no order by account_code) "
						+ " "
						+ " "
						+ "select  account_code as accountHeadCode,case when length(account_code)=4  then (select sub_group_acct_name from sub_group_acct_master where sub_group_acct_code=account_code) else coalesce(AH.acct_head_name,'')  || coalesce(cust.entity_name,'') || coalesce(supp.entity_name,'') end as accountHeadName,  SUM(TC_DEBIT) as tcDebit, SUM(TC_CREDIT) as tcCredit,SUM(BC_DEBIT) as bcDebit, SUM(BC_CREDIT) as bcCredit,  (SUM(bc_debit) - SUM(bc_credit)) as currentBalance, (SUM(TC_DEBIT)- SUM(TC_CREDIT)) as currentTCBalance   from general_ledger gl "
						+ "right join t on t.transactionno = gl.transaction_no "
						+ "						 left join account_head_master AH on AH.acct_head_code = gl.account_code   left join customer_entity cust on cust.customer_acct_code = gl.account_code left join entity supp on supp.supplier_acct_code = gl.account_code   group by account_code,AH.acct_head_name,cust.entity_name,supp.entity_name  order by account_code";
						
				lGeneralLedgerAHListAcc = jdbcTemplate.query(query, new Object[] {}, new BeanPropertyRowMapper<>(GeneralLedgerBean.class));

				//System.out.println("Test"+ query);
					/*	"select  account_code as accountHeadCode,case when length(account_code)=4  then (select sub_group_acct_name from sub_group_acct_master where sub_group_acct_code=account_code) else coalesce(AH.acct_head_name,'')  || coalesce(cust.entity_name,'') || coalesce(supp.entity_name,'') end as accountHeadName,  SUM(TC_DEBIT) as tcDebit, SUM(TC_CREDIT) as tcCredit,SUM(BC_DEBIT) as bcDebit, SUM(BC_CREDIT) as bcCredit,  (SUM(bc_debit) - SUM(bc_credit)) as currentBalance, (SUM(TC_DEBIT)- SUM(TC_CREDIT)) as currentTCBalance   from general_ledger gl "
						+ "left join account_head_master AH on AH.acct_head_code = gl.account_code " + "left join entity cust on cust.customer_acct_code = gl.account_code left join entity supp on supp.supplier_acct_code = gl.account_code " + "  where 1=1 " + whereCond + " group by account_code,AH.acct_head_name,cust.entity_name,supp.entity_name  order by account_code";
				*/
				

			}
		} catch (DataAccessException | SQLException e) {
			e.printStackTrace();
		}
		return lGeneralLedgerAHListAcc;
	}
	

}