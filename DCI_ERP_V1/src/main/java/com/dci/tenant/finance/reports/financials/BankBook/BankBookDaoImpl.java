package com.dci.tenant.finance.reports.financials.BankBook;

import java.text.ParseException;
import java.util.ArrayList;
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
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CommonUtilityQueryUtil;

@Repository
@Transactional("tenantTransactionManager")
public class BankBookDaoImpl implements BankBookDao {
	private final static Logger LOGGER = LoggerFactory.getLogger(BankBookDaoImpl.class);

	@Resource
	 private DataSource dataSource;
	
	String whereCond;

	@Override
	public List<BankBook> getBankBookList(BankBook objBankBook) throws ParseException {
		List<BankBook> lBankBook = new ArrayList<BankBook>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			String compCode="";
			if(objBankBook.getCompanyCode().equalsIgnoreCase("ALL"))
			{
				List<String> lCompany = new ArrayList<String>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_CODE"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode =="") {
						compCode +="'"+lCompany.get(i)+"'";
					} else {
						compCode += "," +"'"+lCompany.get(i)+"'";
					}
				}
				
			}else{
				String companyCodes[] = objBankBook.getCompanyCode().split(",");
				
				for(int i=0;i<companyCodes.length;i++){
					if(compCode==""){
						compCode="'"+companyCodes[i]+"'";
					}					
					else{
						compCode+=","+"'"+companyCodes[i]+"'";
					}
				}
			}
			
			String sDynamicQuery = "with t as (select  (select coalesce(sum(DEBIT)-SUM(CREDIT),0.0) as openingBalance from GENERAL_LEDGER GL where  GL.LEDGER_DT < TO_DATE(?,'DD/MM/YYYY') AND ACCOUNT_HEAD like ('1003%')";
					sDynamicQuery += " AND COMPANY_CODE in ("+compCode+")";
					
							sDynamicQuery += "),GL.ACCOUNT_HEAD as accountCode, AM.ACCT_HEAD_NAME as accountName ,sum(DEBIT) as debit,SUM(CREDIT) as credit,sum(LOCAL_DEBIT) as tcDebit,SUM(LOCAL_CREDIT) as tcCredit, "
			+ "sum(DEBIT)-SUM(CREDIT) as currentBalance from GENERAL_LEDGER GL LEFT JOIN ACCOUNT_HEAD_MASTER AM "
			+ "ON GL.ACCOUNT_HEAD = AM.ACCT_HEAD_CODE  where GL.LEDGER_DT "
			+ "between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') and GL.ACCOUNT_HEAD like ('1003%')";
			
			sDynamicQuery += " AND COMPANY_CODE in ("+compCode+")";
			if (objBankBook.getAccountCode() != "" && !objBankBook.getAccountCode().equalsIgnoreCase("ALL")) {
				sDynamicQuery += " AND ACCOUNT_HEAD = '" + objBankBook.getAccountCode() + "'";
			}
			
			 if(objBankBook.getTransactionNo()!=null && !objBankBook.getTransactionNo().isEmpty()) {
		        	sDynamicQuery += " AND particulars ='"+objBankBook.getTransactionNo()+"' ";
				}
		        
		        if(objBankBook.getNarration()!=null && !objBankBook.getNarration().isEmpty()) {
		        	sDynamicQuery += " AND narration like '%"+objBankBook.getNarration()+"%' ";
		        	
		        	
				}
			
			sDynamicQuery += " group by GL.ACCOUNT_HEAD,AM.ACCT_HEAD_NAME  )select t.*, coalesce((t.openingBalance+(sum(DEBIT)-SUM(CREDIT))),0.0) as currentBalance from t group by openingBalance,accountCode,accountName,currentBalance,debit,credit,tcDebit,tcCredit ";
			System.out.println(sDynamicQuery);
			
			lBankBook= jdbcTemplate.query(sDynamicQuery,
					new Object[] { objBankBook.getFromDate(), objBankBook.getFromDate(), objBankBook.getToDate() },
					new BeanPropertyRowMapper<BankBook>(BankBook.class));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lBankBook;
	}

	@Override
	public List<BankBook> getBankBookAccountList(BankBook objBankBook) {
		List<BankBook> lBankBook = new ArrayList<BankBook>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			String compCode="";
			if(objBankBook.getCompanyCode().equalsIgnoreCase("ALL"))
			{
				List<String> lCompany = new ArrayList<String>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_CODE"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode =="") {
						compCode +="'"+lCompany.get(i)+"'";
					} else {
						compCode += "," +"'"+lCompany.get(i)+"'";
					}
				}
				
			}
			else
			{
				String companyCodes[] = objBankBook.getCompanyCode().split(",");
				
				for(int i=0;i<companyCodes.length;i++){
					if(compCode==""){
						compCode="'"+companyCodes[i]+"'";
					}					
					else{
						compCode+=","+"'"+companyCodes[i]+"'";
					}
				}
			}
			
			String sDynamicQuery = BankBookQueryUtil.GET_SUB_DATA;
			
			System.out.println(compCode);
			
			sDynamicQuery += " AND COMPANY_CODE in ("+compCode+")";
			
			 if(objBankBook.getTransactionNo()!=null && !objBankBook.getTransactionNo().isEmpty()) {
		        	sDynamicQuery += " AND particulars ='"+objBankBook.getTransactionNo()+"' ";
				}
		        
		        if(objBankBook.getNarration()!=null && !objBankBook.getNarration().isEmpty()) {
		        	
		        	sDynamicQuery += " AND narration like '%"+objBankBook.getNarration()+"%' ";
				}
			
			sDynamicQuery += "  order by LEDGER_DT asc ";

			lBankBook = jdbcTemplate.query(sDynamicQuery,
					new Object[] { objBankBook.getAccountCode(), objBankBook.getFromDate(), objBankBook.getToDate() },
					new BeanPropertyRowMapper<BankBook>(BankBook.class));
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lBankBook;
	}

	public static String checkEmptyString(String s1) {
		if (s1 == null || s1.equalsIgnoreCase("null")) {
			return "";
		} else {
			return s1;
		}
	}

	public static double convertNullToDouble(String value) {
		Double i = 0.0;
		try {
			if (value == null || value.equals("null")) {
				i = 0.0;
			} else {
				i = Double.parseDouble(value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

/*	@Override
	public List<BankBook> getAccountList() throws Exception {
		ArrayList<BankBook> list = new ArrayList<BankBook>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(BankBookQueryUtil.GET_ACCOUNT_LIST,
					new Object[] { AccountsConstants.BANK_SG });
			for (Map row : rows) {
				BankBook obj = new BankBook();
				//obj.setId((String) row.get("accountCode"));
				obj.setText((String) row.get("accountName"));
				list.add(obj);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
*/
	
	
	
	

	@Override
	public List<SelectivityBean> getAccountList() {
		List<SelectivityBean> lSubGroupList = new ArrayList<SelectivityBean>();
		try {
			

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			//lSubGroupList = jdbcTemplate.query(BankBookQueryUtil.GET_ACCOUNT_LIST,new Object[] {AccountsConstants.BANK_SG},new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lSubGroupList;
	}
	
	
	@Override
	public List<BankBook> getConsolidatedBankLedgerList(BankBook objBankBook) {
		List<BankBook> lBankLedgerList = new ArrayList<BankBook>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			String compCode="";
			if(objBankBook.getCompanyCode().equalsIgnoreCase("ALL"))
			{
				List<String> lCompany = new ArrayList<String>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_CODE"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode =="") {
						compCode +="'"+lCompany.get(i)+ "'";
					} else {
						compCode += "," + "'" +lCompany.get(i)+ "'";
					}
				}
				
			}
			else{
				String companyCodes[] = objBankBook.getCompanyCode().split(",");
				
				for(int i=0;i<companyCodes.length;i++){
					if(compCode==""){
						compCode="'"+companyCodes[i]+"'";
					}					
					else{
						compCode+=","+"'"+companyCodes[i]+"'";
					}
				}
			}
			
			
			String sDynamicQuery = BankBookQueryUtil.GET_CONSOLIDATED_BANK_DATA;

			
			if (objBankBook.getAccountCode() != "") {
				sDynamicQuery += " AND GENERAL_LEDGER.ACCOUNT_HEAD = '" + objBankBook.getAccountCode() + "'";
			}
			

			sDynamicQuery += " AND GENERAL_LEDGER.COMPANY_CODE in ("+compCode+")";
			
			 if(objBankBook.getTransactionNo()!=null && !objBankBook.getTransactionNo().isEmpty()) {
		        	sDynamicQuery += " AND GENERAL_LEDGER.particulars ='"+objBankBook.getTransactionNo()+"' ";
				}
		        
		        if(objBankBook.getNarration()!=null && !objBankBook.getNarration().isEmpty()) {
		        	sDynamicQuery += " AND GENERAL_LEDGER.narration like '%"+objBankBook.getNarration()+"%' ";
		        	
				}
			
			
			sDynamicQuery += "   ) select distinct t.*,to_date(transactiondate,'dd/mm/yyyy') ,COALESCE(ah2.acct_head_name,'') as acctheadname from t left join cashbank_pay_dtl cpd on cpd.voucher_no = t.transactionno left join ACCOUNT_HEAD_MASTER AH2 on AH2.acct_head_code= cpd.acct_head left join cashbank_receipt_dtl crd on crd.voucher_no = t.transactionno and AH2.acct_head_code= crd.acct_head left join GENERAL_LEDGER GL ON GL.ACCOUNT_HEAD=AH2.ACCT_HEAD_CODE  ORDER BY to_date(transactiondate,'dd/mm/yyyy') asc,acctheadname ";
			lBankLedgerList = jdbcTemplate.query(sDynamicQuery,
					new Object[] { objBankBook.getFromDate(), objBankBook.getToDate() },
					new BeanPropertyRowMapper<BankBook>(BankBook.class));
		} catch (DataAccessException e) {

		}
		return lBankLedgerList;
	}

}