package com.dci.finance.ReceiptPayment;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class ReceiptPaymentDaoImpl implements ReceiptPaymentDao {

	@Resource
	private DataSource dataSource;

	@Override
	public List<SelectivityBean> getGroupHeadList() {
		List<SelectivityBean> lSubGroupList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lSubGroupList = jdbcTemplate.query(ReceiptPaymentQueryUtil.GET_GRP_LIST, new BeanPropertyRowMapper<>(SelectivityBean.class));

		} catch (DataAccessException e) {
		}
		return lSubGroupList;
	}

	@Override
	public List<SelectivityBean> mainaccountList() {
		List<SelectivityBean> lMainlist = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lMainlist = jdbcTemplate.query(ReceiptPaymentQueryUtil.get_mainaccount_list, new BeanPropertyRowMapper<>(SelectivityBean.class));

		} catch (DataAccessException e) {
		}
		return lMainlist;
	}

	@Override
	public List<ReceiptPaymentBean> getGeneralLedgerReport(ReceiptPaymentBean objGeneralLedgerBean) {
		List<ReceiptPaymentBean> lGeneralLedgerList = new ArrayList<>();
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

				/*
				 * for(int i=0;i<groupCodes.length;i++){ if(groupCodes.length
				 * >0){ if(groupCode==""){ if(groupCodes.length == 1)
				 * groupCode=" AND ( GL.SUB_GROUP_CODE LIKE '"
				 * +groupCodes[i]+"%' )"; else
				 * groupCode=" AND ( GL.SUB_GROUP_CODE LIKE '"
				 * +groupCodes[i]+"%'"; } else{ if(groupCodes.length -1 == i)
				 * groupCode
				 * +=" OR GL.SUB_GROUP_CODE LIKE '"+groupCodes[i]+"%' )"; else
				 * groupCode+=" OR GL.SUB_GROUP_CODE LIKE '"+groupCodes[i]+"%'";
				 * } } }
				 */
			} else {
				groupCode = "";
			}

			String sDynamicQuery = ReceiptPaymentQueryUtil.GET_GENERAL_LEDGER_LIST_SG_LEVEL;

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
					subAcctCode = jdbcTemplate.queryForObject(ReceiptPaymentQueryUtil.get_acct_head_code, new Object[] { objGeneralLedgerBean.getSubAccountCode() }, String.class);
					System.out.println("getcode:" + subAcctCode);
				}
			}

			/*
			 * if(objGeneralLedgerBean.getMainAccountCode().equals("10070004")
			 * || objGeneralLedgerBean.getMainAccountCode().equals("10050001")
			 * || objGeneralLedgerBean.getMainAccountCode().equals("10050002")
			 * || objGeneralLedgerBean.getMainAccountCode().equals("50060004"))
			 * sDynamicQuery += " AND trim(GL.vessel_code) = '" +
			 * objGeneralLedgerBean.getSubAccountCode() + "'"; else
			 * sDynamicQuery += " AND trim(GL.SUB_ACCOUNT_CODE) = '" +
			 * objGeneralLedgerBean.getSubAccountCode() + "'";
			 */

			/*
			 * sDynamicQuery += " AND trim(COMPANY_CODE) in ("+compCode+")";
			 * 
			 * sDynamicQuery =
			 * "select * from fn_gl_view1('C0003', TO_DATE('01/01/2016','DD/MM/YYYY'), TO_DATE('31/12/2016','DD/MM/YYYY'), '10,20', '1008', '10080001', 'PYAN0011')"
			 * ;
			 * 
			 * System.out.println(
			 * "+++++++++++++++++++Dynamic Query++++++++++++++++++++++");
			 * System.out.println(sDynamicQuery);
			 */
			if (objGeneralLedgerBean.getCostCenter().equals(null) || objGeneralLedgerBean.getCostCenter().equals("") || objGeneralLedgerBean.getCostCenter().equals("undefined")) {

				lGeneralLedgerList = jdbcTemplate.query(ReceiptPaymentQueryUtil.GET_VIEW_REPORTtest, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), }, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));

			} else {
				lGeneralLedgerList = jdbcTemplate.query(ReceiptPaymentQueryUtil.GET_VIEW_REPORTtest1, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getCostCenter() }, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));

			}
			System.out.println(sDynamicQuery);

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
	public List<ReceiptPaymentBean> getGeneralLedgerAHLevel(ReceiptPaymentBean objGeneralLedgerBean) {
		List<ReceiptPaymentBean> lGeneralLedgerAHList = new ArrayList<>();
		try {

			String compCode = "", subGroupCode = "", mainAcctCode = "", subAcctCode = "";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
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
			String subGroupCode1 = objGeneralLedgerBean.getSubGroupCode() + "%";
			if (objGeneralLedgerBean.getCostCenter().equals(null) || objGeneralLedgerBean.getCostCenter().equals("undefined") || objGeneralLedgerBean.getCostCenter().equals("")) {

				lGeneralLedgerAHList = jdbcTemplate.query(ReceiptPaymentQueryUtil.GET_VIEW_REPORT2_QUERY1, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), subGroupCode1 }, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));
			} else {
				lGeneralLedgerAHList = jdbcTemplate.query(ReceiptPaymentQueryUtil.GET_VIEW_REPORT2_QUERY, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), subGroupCode1, objGeneralLedgerBean.getCostCenter() }, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));

			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lGeneralLedgerAHList;
	}

	@Override
	public List<ReceiptPaymentBean> getGLTransactionLevel(ReceiptPaymentBean objGeneralLedgerBean) {
		List<ReceiptPaymentBean> lGeneralLedgerTransactionList = new ArrayList<>();
		try {

			double totalAmount = 0;

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

			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

			Date today = new Date();
			String currentdate = DATE_FORMAT.format(today);
			String [] str=objGeneralLedgerBean.getFinancialYear().split("-");
			 int from=Integer.valueOf(str[0])-1;
			 int to=Integer.valueOf(str[0])-1;
		 //		lGeneralLedgerTransactionList = jdbcTemplate.query(ReceiptPaymentQueryUtil.GET_VIEW_REPORT3_QUERY1, new Object[] { compCode  }, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));
				if (objGeneralLedgerBean.getCostCenter().equals(null) || objGeneralLedgerBean.getCostCenter().equals("undefined") || objGeneralLedgerBean.getCostCenter().equals("")) {
	 
			 if(objGeneralLedgerBean.getToDate().equals(null) || objGeneralLedgerBean.getToDate().equals("")) {
					lGeneralLedgerTransactionList = jdbcTemplate.query("select * from get_receipt('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','01/03/"+from+"','31/04/"+to+"' )", new Object[] {}, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));
                    System.out.println("select * from get_receipt('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','01/03/"+from+"','31/04/"+to+"' )");
				}else {
					lGeneralLedgerTransactionList = jdbcTemplate.query("select * from get_receipt_date('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','"+objGeneralLedgerBean.getToDate()+"','01/03/"+from+"','31/04/"+to+"' )", new Object[] {}, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));
					System.out.println("select * from get_receipt_date('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','"+objGeneralLedgerBean.getToDate()+"','01/03/"+from+"','31/04/"+to+"' )");
				}}else {
					 if(objGeneralLedgerBean.getToDate().equals(null) || objGeneralLedgerBean.getToDate().equals("")) {

					lGeneralLedgerTransactionList = jdbcTemplate.query("select * from get_receipt_cost('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','01/03/"+from+"','31/04/"+to+"' ,'"+objGeneralLedgerBean.getCostCenter()+"' )", new Object[] {}, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));
                    System.out.println( "select * from get_receipt_cost('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','01/03/"+from+"','31/04/"+to+"','"+objGeneralLedgerBean.getCostCenter()+"'  )");
				}else {
					lGeneralLedgerTransactionList = jdbcTemplate.query("select * from get_receipt_date_cost('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','"+objGeneralLedgerBean.getToDate()+"','01/03/"+from+"','31/04/"+to+"','"+objGeneralLedgerBean.getCostCenter()+"' )", new Object[] {}, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));
					System.out.println( "select * from get_receipt_date_cost('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','"+objGeneralLedgerBean.getToDate()+"','01/03/"+from+"','31/04/"+to+"','"+objGeneralLedgerBean.getCostCenter()+"' )");
				}	
				}

		double d=0.0;
		  for(ReceiptPaymentBean bn : lGeneralLedgerTransactionList) {
			    if(bn.getAmt()==null)   {
			    	bn.setAmt("0.0");
			    	}
			    bn.setPreAmount(Double.valueOf(bn.getAmt()));
			    d=d+bn.getAmoount();
		  }
		  int i=lGeneralLedgerTransactionList.size();
		  lGeneralLedgerTransactionList.get(i-1).setAmount(Double.valueOf(d));


					/*
					 * double total=0.0,preTotal=0.0; for(ReceiptPaymentBean bean
					 * :lGeneralLedgerTransactionList) { total=total+bean.getAmount();
					 * preTotal=preTotal+bean.getPreAmount(); }
					 */
 
				 
		} catch (DataAccessException e) {
			e.printStackTrace();

		}
		return lGeneralLedgerTransactionList;
	}

	@Override
	public List<ReceiptPaymentBean> getGLTransactionLevel1(ReceiptPaymentBean objGeneralLedgerBean) {
		List<ReceiptPaymentBean> lGeneralLedgerTransactionList = new ArrayList<>();
		try {

			double totalAmount = 0;

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

			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

			Date today = new Date();
			String currentdate = DATE_FORMAT.format(today);
			String [] str=objGeneralLedgerBean.getFinancialYear().split("-");
			 int from=Integer.valueOf(str[0])-1;
			 int to=Integer.valueOf(str[0])-1;
				if (objGeneralLedgerBean.getCostCenter().equals(null) || objGeneralLedgerBean.getCostCenter().equals("undefined") || objGeneralLedgerBean.getCostCenter().equals("")) {
					 
					 if(objGeneralLedgerBean.getToDate().equals(null) || objGeneralLedgerBean.getToDate().equals("")) {
							lGeneralLedgerTransactionList = jdbcTemplate.query("select * from get_payment('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','01/03/"+from+"','31/04/"+to+"' )", new Object[] {}, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));
		                    System.out.println("select * from get_payment('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','01/03/"+from+"','31/04/"+to+"' )");
						}else {
							lGeneralLedgerTransactionList = jdbcTemplate.query("select * from get_payment_date('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','"+objGeneralLedgerBean.getToDate()+"','01/03/"+from+"','31/04/"+to+"' )", new Object[] {}, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));
							System.out.println("select * from get_payment_date('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','"+objGeneralLedgerBean.getToDate()+"','01/03/"+from+"','31/04/"+to+"' )");
						}}else {
							 if(objGeneralLedgerBean.getToDate().equals(null) || objGeneralLedgerBean.getToDate().equals("")) {

							lGeneralLedgerTransactionList = jdbcTemplate.query("select * from get_payment_cost('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','01/03/"+from+"','31/04/"+to+"' ,'"+objGeneralLedgerBean.getCostCenter()+"' )", new Object[] {}, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));
		                    System.out.println( "select * from get_payment_cost('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','01/03/"+from+"','31/04/"+to+"','"+objGeneralLedgerBean.getCostCenter()+"'  )");
						}else {
							lGeneralLedgerTransactionList = jdbcTemplate.query("select * from get_payment_date_cost('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','"+objGeneralLedgerBean.getToDate()+"','01/03/"+from+"','31/04/"+to+"','"+objGeneralLedgerBean.getCostCenter()+"' )", new Object[] {}, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));
							System.out.println( "select * from get_payment_date_cost('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','"+objGeneralLedgerBean.getToDate()+"','01/03/"+from+"','31/04/"+to+"','"+objGeneralLedgerBean.getCostCenter()+"' )");
						}	
						}

			for(ReceiptPaymentBean bn : lGeneralLedgerTransactionList) {
			    if(bn.getAmt()==null)   {
			    	bn.setAmt("0.00");
			    	}
			    bn.setPreAmount(Double.valueOf(bn.getAmt()));
 		  }
		 //		lGeneralLedgerTransactionList = jdbcTemplate.query(ReceiptPaymentQueryUtil.GET_VIEW_REPORT3_QUERY1, new Object[] { compCode  }, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));
			/*
			 * if(objGeneralLedgerBean.getToDate().equals(null) ||
			 * objGeneralLedgerBean.getToDate().equals("")) { lGeneralLedgerTransactionList
			 * = jdbcTemplate.query(ReceiptPaymentQueryUtil.GET_VIEW_REPORT3_QUERYyy, new
			 * Object[] { compCode,objGeneralLedgerBean.getFromDate() }, new
			 * BeanPropertyRowMapper<>(ReceiptPaymentBean.class));
			 * 
			 * }else { lGeneralLedgerTransactionList =
			 * jdbcTemplate.query(ReceiptPaymentQueryUtil.GET_VIEW_REPORT3_QUERY11, new
			 * Object[] {
			 * compCode,objGeneralLedgerBean.getFromDate(),objGeneralLedgerBean.getToDate()
			 * }, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class)); } String []
			 * str=objGeneralLedgerBean.getFinancialYear().split("-"); int
			 * from=Integer.valueOf(str[0])-1; int to=Integer.valueOf(str[0])-1;
			 * for(ReceiptPaymentBean bn : lGeneralLedgerTransactionList) { int
			 * i=jdbcTemplate.queryForObject(ReceiptPaymentQueryUtil.
			 * GET_VIEW_REPORT3_QUERY22, new Object[] { compCode,bn.getAcctCode(),
			 * "01/03/"+from, "31/04/"+to },Integer.class); if(i>0) {
			 * bn.setPreAmount(jdbcTemplate.queryForObject(ReceiptPaymentQueryUtil.
			 * GET_VIEW_REPORT3_QUERY33, new Object[] { compCode,bn.getAcctCode(),
			 * "01/03/"+from, "31/04/"+to },Double.class)); }else { bn.setPreAmount(0.0); }
			 * }
			 */
 
				/*
				 * Double bookbal =
				 * jdbcTemplate.queryForObject(ReceiptPaymentQueryUtil.GET_total, new Object[] {
				 * compCode, objGeneralLedgerBean.getFromDate(),
				 * objGeneralLedgerBean.getToDate() }, Double.class); if(bookbal!=null)
				 * totalAmount = bookbal; if (lGeneralLedgerTransactionList.size() > 0)
				 * lGeneralLedgerTransactionList.get(0).setTotalAmount(totalAmount);
				 */

		} catch (DataAccessException e) {
			e.printStackTrace();

		}
		return lGeneralLedgerTransactionList;
	}

	@Override
	public List<ReceiptPaymentBean> getGeneralLedgerList(ReceiptPaymentBean objGeneralLedgerBean) {
		List<ReceiptPaymentBean> lGeneralLedgerList = new ArrayList<>();
		try {
			List<ReceiptPaymentBean> lGeneralLedgerSGList = new ArrayList<>();
			lGeneralLedgerSGList = getGeneralLedgerReport(objGeneralLedgerBean);

			for (ReceiptPaymentBean objGeneralLedgerSGBean : lGeneralLedgerSGList) {
				List<ReceiptPaymentBean> lGeneralLedgerAHList = new ArrayList<>();
				List<ReceiptPaymentBean> lGeneralLedgerAHtempList = new ArrayList<>();
				objGeneralLedgerSGBean.setFromDate(objGeneralLedgerBean.getFromDate());
				objGeneralLedgerSGBean.setToDate(objGeneralLedgerBean.getToDate());
				objGeneralLedgerSGBean.setCompanyCode(objGeneralLedgerBean.getCompanyCode());

				if (objGeneralLedgerBean.getSubAccountCode() != "" && objGeneralLedgerBean.getSubAccountCode() != null)
					objGeneralLedgerSGBean.setSubAccountCode(objGeneralLedgerBean.getSubAccountCode());

				lGeneralLedgerAHtempList = getGeneralLedgerAHLevel(objGeneralLedgerSGBean);

				for (ReceiptPaymentBean objGeneralLedgerAHBean : lGeneralLedgerAHtempList) {
					List<ReceiptPaymentBean> lTransactionList = new ArrayList<>();
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
	public List<ReceiptPaymentBean> getSubLedgerReport(ReceiptPaymentBean objGeneralLedgerBean) {
		List<ReceiptPaymentBean> lGeneralLedgerList = new ArrayList<>();
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
			 * lGeneralLedgerList = jdbcTemplate.query(sDynamicQuery,new
			 * Object[] {objGeneralLedgerBean.getSubAccountCode(),
			 * objGeneralLedgerBean.getFromDate(),
			 * objGeneralLedgerBean.getToDate() }, new
			 * BeanPropertyRowMapper<GeneralLedgerBean
			 * >(GeneralLedgerBean.class));
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
					subAcctCode = jdbcTemplate.queryForObject(ReceiptPaymentQueryUtil.get_acct_head_code, new Object[] { objGeneralLedgerBean.getSubAccountCode() }, String.class);
					System.out.println("getcode:" + subAcctCode);
				}
				check1 = true;
			}

			if (!check1) {

				lGeneralLedgerList = jdbcTemplate.query(ReceiptPaymentQueryUtil.excelByAcctHead, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), objGeneralLedgerBean.getSubGroupCode(), mailAcctCode, subAcctCode }, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));

			} else {
				lGeneralLedgerList = jdbcTemplate.query(ReceiptPaymentQueryUtil.EXCELBYACCTHEADNOTINTDS, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), objGeneralLedgerBean.getSubGroupCode(), mailAcctCode, subAcctCode }, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));

			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lGeneralLedgerList;
	}

	@Override
	public List<ReceiptPaymentBean> getSubLedgerReport1(ReceiptPaymentBean objGeneralLedgerBean) {
		List<ReceiptPaymentBean> lGeneralLedgerList = new ArrayList<>();
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
			// String sDynamicQuery =
			// GeneralLedgerQueryUtil.GET_SUB_LEDGER_REPORT;

			if (objGeneralLedgerBean.getMainAccountCode() != null && objGeneralLedgerBean.getMainAccountCode() != "")
				mailAcctCode = objGeneralLedgerBean.getMainAccountCode();

			lGeneralLedgerList = jdbcTemplate.query(ReceiptPaymentQueryUtil.excelByAcctHead_sub, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), subGroupCode, mailAcctCode, objGeneralLedgerBean.getSubAccountCode() }, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lGeneralLedgerList;
	}

	// new
	@Override
	public List<ReceiptPaymentBean> getSubLedgerReport_only(ReceiptPaymentBean objGeneralLedgerBean) {
		List<ReceiptPaymentBean> lGeneralLedgerList = new ArrayList<>();
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
			 * String subAcct=""; for(int i=0;i<subAccount.length;i++){
			 * if(subAcct==""){ subAcct=subAccount[i]; } else{
			 * subAcct+=","+subAccount[i]; } }
			 */
			if (objGeneralLedgerBean.getMainAccountCode() != null && objGeneralLedgerBean.getMainAccountCode() != "")
				mailAcctCode = objGeneralLedgerBean.getMainAccountCode();
			// objGeneralLedgerBean.getCompanyCode() to Companycode change
			lGeneralLedgerList = jdbcTemplate.query(ReceiptPaymentQueryUtil.excelByAcctHead_sub, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), subGroupCode, mailAcctCode, objGeneralLedgerBean.getSubAccountCode() }, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return lGeneralLedgerList;
	}

	// account head
	@Override
	public List<ReceiptPaymentBean> getConsolidatedGeneralLedgerList(ReceiptPaymentBean objGeneralLedgerBean) {
		List<ReceiptPaymentBean> lGeneralLedgerList = new ArrayList<>();
		String subGroupCode = null, mailAcctCode = null, subAcctCode = null;
		String compCodes = "";
		String whereCond = "";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			if (objGeneralLedgerBean.getCompanyCode().equalsIgnoreCase("All")) {
				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("COMPANY_ID"));
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
			 * String groupCode = ""; if (objGeneralLedgerBean.getGroupCode() !=
			 * "") { String groupCodes[] =
			 * objGeneralLedgerBean.getGroupCode().split(","); for (int i = 0; i
			 * < groupCodes.length; i++) { if (groupCodes.length > 0) { if
			 * (groupCode == "") { if (groupCodes.length == 1) groupCode =
			 * " AND ( GL.SUB_GROUP_CODE LIKE '" + groupCodes[i] + "%' )"; else
			 * groupCode = " AND ( GL.SUB_GROUP_CODE LIKE '" + groupCodes[i] +
			 * "%'"; } else { if (groupCodes.length - 1 == i) groupCode +=
			 * " OR GL.SUB_GROUP_CODE LIKE '" + groupCodes[i] + "%' )"; else
			 * groupCode += " OR GL.SUB_GROUP_CODE LIKE '" + groupCodes[i] +
			 * "%'"; } } } } // account head String sDynamicQuery = null; //
			 * String sDynamicQuery = //
			 * GeneralLedgerQueryUtil.GET_CONSOLIDATED_LEDGER_LIST;
			 * 
			 * if (groupCode != "" && groupCode != null) { sDynamicQuery +=
			 * groupCode; }
			 * 
			 * if (objGeneralLedgerBean.getSubGroupCode() != "" &&
			 * objGeneralLedgerBean.getSubGroupCode() != null) { sDynamicQuery
			 * += " AND trim(GL.SUB_GROUP_CODE) = '" +
			 * objGeneralLedgerBean.getSubGroupCode() + "'"; } if
			 * (objGeneralLedgerBean.getMainAccountCode() != "" &&
			 * objGeneralLedgerBean.getMainAccountCode() != null) {
			 * sDynamicQuery += " AND trim(GL.ACCOUNT_HEAD) = '" +
			 * objGeneralLedgerBean.getMainAccountCode() + "'"; }
			 * 
			 * if (objGeneralLedgerBean.getSubAccountCode() != "" &&
			 * objGeneralLedgerBean.getSubAccountCode() != null) { sDynamicQuery
			 * += " AND trim(GL.SUB_ACCOUNT_CODE) = '" +
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
			}

			if (objGeneralLedgerBean.getCostCenter() != null && !objGeneralLedgerBean.getCostCenter().isEmpty()) {
				whereCond = whereCond + " and g.cost_center	 ='" + objGeneralLedgerBean.getCostCenter() + "'";
			}

			if (objGeneralLedgerBean.getFromDate() != null && !objGeneralLedgerBean.getFromDate().isEmpty()) {
				whereCond = whereCond + " and ledger_date >=to_date('" + objGeneralLedgerBean.getFromDate() + "','dd/mm/yyyy')";
			}

			if (objGeneralLedgerBean.getToDate() != null && !objGeneralLedgerBean.getToDate().isEmpty()) {
				whereCond = whereCond + " and ledger_date <=to_date('" + objGeneralLedgerBean.getToDate() + "','dd/mm/yyyy')  ";
			}
			System.out.println("query" +ReceiptPaymentQueryUtil.excelByAcctHead +  whereCond );

			lGeneralLedgerList = jdbcTemplate.query(ReceiptPaymentQueryUtil.excelByAcctHead + whereCond + " group  by transaction_no,LEDGER_DATE,g.created_date ", new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));

			// String query = GeneralLedgerQueryUtil.excelByAcctHead;

			/*
			 * query = "with t as (" +
			 * " select  * from vw_gl_report('C0021,C0011','01/01/2016','31/12/2016',null,null,null) "
			 * +" where not null_or_empty(accountheadcode)" +" )" +
			 * " select * from t where SUBSTRING (accountheadcode ,0 , 3)::int in (50,60,70,80,90)"
			 * ;
			 */
			/*
			 * if (groupCodes != null && groupCodes != "") { query = query +
			 * " where SUBSTRING (accountheadcode ,0 , 3 )::int in (" +
			 * groupCodes + ")"; } System.out.println(query); if
			 * (objGeneralLedgerBean.getSubGroupCode() != null &&
			 * objGeneralLedgerBean.getSubGroupCode() != "") subGroupCode =
			 * objGeneralLedgerBean.getSubGroupCode(); if
			 * (objGeneralLedgerBean.getMainAccountCode() != null &&
			 * objGeneralLedgerBean.getMainAccountCode() != "") mailAcctCode =
			 * objGeneralLedgerBean.getMainAccountCode(); if
			 * (objGeneralLedgerBean.getSubAccountCode() != null &&
			 * objGeneralLedgerBean.getSubAccountCode() != "") subAcctCode =
			 * objGeneralLedgerBean.getSubAccountCode();
			 * 
			 * lGeneralLedgerList = jdbcTemplate.query(query, new Object[] {
			 * compCodes, objGeneralLedgerBean.getFromDate(),
			 * objGeneralLedgerBean.getToDate(), subGroupCode, mailAcctCode,
			 * subAcctCode }, new
			 * BeanPropertyRowMapper<GeneralLedgerBean>(GeneralLedgerBean
			 * .class));
			 */
		} catch (DataAccessException e) {

		}
		return lGeneralLedgerList;
	}

	// normal
	@Override
	public List<ReceiptPaymentBean> getGeneralLedgerListOP(ReceiptPaymentBean objGeneralLedgerBean) {
		List<ReceiptPaymentBean> lGeneralLedgerList = new ArrayList<>();
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

			List<ReceiptPaymentBean> lGeneralLedgerAHList = new ArrayList<>();
			// nor,al
			String sDynamicQueryOp = ReceiptPaymentQueryUtil.GET_GENERAL_LEDGER_OP;
			sDynamicQueryOp += " from fn_general_ledger(" + compCode + ", TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD/MM/YYYY'), TO_DATE('" + objGeneralLedgerBean.getToDate() + "','DD/MM/YYYY')) where acct_head_code is not null ";

			if (objGeneralLedgerBean.getSubGroupCode() != "" && objGeneralLedgerBean.getSubGroupCode() != null) {
				sDynamicQueryOp += " and substr(acct_head_code,1,4) = '" + objGeneralLedgerBean.getSubGroupCode() + "'";
			}
			if (objGeneralLedgerBean.getMainAccountCode() != "" && objGeneralLedgerBean.getMainAccountCode() != null) {
				sDynamicQueryOp += " and trim(acct_head_code) = '" + objGeneralLedgerBean.getMainAccountCode() + "'";
			}

			/*
			 * if (objGeneralLedgerBean.getAccountHeadCode() != "" &&
			 * objGeneralLedgerBean.getAccountHeadCode() !=null) {
			 * sDynamicQueryOp += " and trim(acct_head_code) = '" +
			 * objGeneralLedgerBean.getAccountHeadCode() + "'"; }
			 */
			lGeneralLedgerAHList = jdbcTemplate.query(sDynamicQueryOp + "", new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));

			for (ReceiptPaymentBean objGeneralLedgerTransBean : lGeneralLedgerAHList) {
				List<ReceiptPaymentBean> lGeneralLedgerTransList = new ArrayList<>();
				objGeneralLedgerTransBean.setFromDate(objGeneralLedgerBean.getFromDate());
				objGeneralLedgerTransBean.setToDate(objGeneralLedgerBean.getToDate());
				objGeneralLedgerTransBean.setCompanyCode(objGeneralLedgerBean.getCompanyCode());

				// normal
				String sDynamicQuery = null;

				if (objGeneralLedgerTransBean.getAccountHeadCode() != null && objGeneralLedgerTransBean.getAccountHeadCode() != "")
					mailAcctCode = objGeneralLedgerTransBean.getAccountHeadCode();
				if (objGeneralLedgerBean.getSubAccountCode() != null && objGeneralLedgerBean.getSubAccountCode() != "")
					subAcctCode = objGeneralLedgerBean.getSubAccountCode();
				lGeneralLedgerTransList = jdbcTemplate.query(ReceiptPaymentQueryUtil.excelByAcctHead + " order by ledgerdate", new Object[] { compCodes, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), subGroupCode, mailAcctCode, subAcctCode }, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));

				objGeneralLedgerTransBean.setlTransactionList(lGeneralLedgerTransList);
				lGeneralLedgerList.add(objGeneralLedgerTransBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lGeneralLedgerList;
	}

	@Override
	public ReceiptPaymentBean getOpeningBalanceValue(ReceiptPaymentBean objGeneralLedgerBean) {

		ReceiptPaymentBean objGeneralLedgerBeanOP = new ReceiptPaymentBean();
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

			String subAcctCode = objGeneralLedgerBean.getSubAccountCode();
			if (objGeneralLedgerBean.getSubAccountCode() != null && objGeneralLedgerBean.getSubAccountCode() != "") {
				if (isNum(objGeneralLedgerBean.getSubAccountCode())) {

					System.out.println("up:" + objGeneralLedgerBean.getSubAccountCode());
					subAcctCode = objGeneralLedgerBean.getSubAccountCode();

				} else {

					System.out.println("down:" + objGeneralLedgerBean.getSubAccountCode());
					subAcctCode = jdbcTemplate.queryForObject(ReceiptPaymentQueryUtil.get_acct_head_code, new Object[] { objGeneralLedgerBean.getSubAccountCode() }, String.class);
					System.out.println("getcode:" + subAcctCode);

				}
			}
			String sDynamicQuery = "";

			if (objGeneralLedgerBean.getMainAccountCode() != null && objGeneralLedgerBean.getMainAccountCode() != "") {

				if (subAcctCode != null && subAcctCode != "") {

					sDynamicQuery += " with A as (select sum(BC_CREDIT),sum(BC_DEBIT),COALESCE(sum(BC_DEBIT)-sum(BC_CREDIT),0) as opening  from general_ledger  where ACCOUNT_CODE = '" + objGeneralLedgerBean.getMainAccountCode() + "' and ledger_date::date <= TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY') and  company_id in (" + compCode + ")  and sub_account_code in (select supplier_acct_code from entity where entity_id =" + subAcctCode + ")),"

							+ "B as (   select sum(BC_CREDIT) as credit,sum(BC_DEBIT) as debit, COALESCE(sum(BC_DEBIT)-sum(BC_CREDIT),0) as nowclosing from general_ledger where ACCOUNT_CODE = '" + objGeneralLedgerBean.getMainAccountCode() + "' and ledger_date::date <= TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY') and company_id in (" + compCode + ")  and sub_account_code in (select supplier_acct_code from entity where entity_id =" + subAcctCode + "))"
							+ "select COALESCE(a.opening,0) as openingBalance,COALESCE(opening+nowclosing,0)  as closingBalance,COALESCE(b.debit,0) as debitamount, COALESCE(b.BC_CREDIT,0) as creditamount from a,b";

				} else {

					sDynamicQuery += " with A as (select sum(BC_CREDIT),sum(BC_DEBIT),COALESCE(sum(BC_DEBIT)-sum(BC_CREDIT),0) as opening  from general_ledger  where ACCOUNT_CODE = '" + objGeneralLedgerBean.getMainAccountCode() + "' and ledger_date::date <= TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY') and  company_id in (" + compCode + ")),"

							+ "B as (   select sum(BC_CREDIT) as credit,sum(BC_DEBIT) as debit, COALESCE(sum(BC_DEBIT)-sum(BC_CREDIT),0) as nowclosing from general_ledger where ACCOUNT_CODE = '" + objGeneralLedgerBean.getMainAccountCode() + "' and ledger_date::date <= TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY') and company_id in (" + compCode + "))"
							+ "select COALESCE(a.opening,0) as openingBalance,COALESCE(opening+nowclosing,0)  as closingBalance,COALESCE(b.debit,0) as debitamount, COALESCE(b.credit,0) as creditamount from a,b";

				}
			} else if (objGeneralLedgerBean.getSubGroupCode() != null && objGeneralLedgerBean.getSubGroupCode() != "") {
				sDynamicQuery += "" + "	with A as ( select sum(BC_CREDIT) as credit  ,sum(BC_DEBIT) as debit,COALESCE(sum(BC_DEBIT)-sum(BC_CREDIT),0) as opening  from general_ledger  " + "	where ledger_date::date < TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY')" + "	 and  company_id in  (" + compCode + ") and  SUB_ACCOUNT_CODE =  '" + objGeneralLedgerBean.getSubGroupCode() + "'), " + "	B as (select sum(BC_CREDIT) as credit,sum(BC_DEBIT) as debit,COALESCE(sum(BC_DEBIT)-sum(BC_CREDIT),0) as nowclosing from general_ledger  "
						+ "	where " + "	ledger_date::date <= TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY')" + "	 and company_id in (" + compCode + ") and  SUB_ACCOUNT_CODE =  '" + objGeneralLedgerBean.getSubGroupCode() + "')" + "	 select COALESCE(a.opening,0) as openingBalance,COALESCE(b.debit,0) as debitamount, COALESCE(b.credit,0) as creditamount," + " COALESCE(opening+nowclosing,0)  as closingBalance, COALESCE(opening+b.debit,0) as newdebitamount  from a,b";

			} else {

				sDynamicQuery += "" + "	with A as ( select sum(BC_CREDIT) as credit  ,sum(BC_DEBIT) as debit,sum(BC_DEBIT)-sum(BC_CREDIT) as opening  from general_ledger  " + "	where ledger_date::date <= TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY')" + "	 and  company_id in  (" + compCode + ")), " + "	B as (select sum(BC_CREDIT) as credit,sum(BC_DEBIT) as debit,sum(BC_DEBIT)-sum(BC_CREDIT) as nowclosing from general_ledger  " + "	where " + "ledger_date::date <= TO_DATE('" + objGeneralLedgerBean.getFromDate()
						+ "','DD-MM-YYYY')" + "	 and company_id in (" + compCode + "))" + "	select COALESCE(a.opening,0) as openingBalance,b.debit as debitamount, b.credit as creditamount," + " COALESCE(opening+nowclosing,0)  as closingBalance , COALESCE(opening+b.debit,0) as newdebitamount, COALESCE(opening+b.credit,0) as newcreditamount from a,b";
			}

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
			 * String subgroupName=
			 * jdbcTemplate.queryForObject(GeneralLedgerQueryUtil
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

			} else if (!objGeneralLedgerBean.getSubGroupCode().equalsIgnoreCase("")) {
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
				}
				if (row.get("closingBalance") != null) {
					objGeneralLedgerBeanOP.setClosingBalance(Double.valueOf(String.valueOf(row.get("closingBalance"))));
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
				 * objGeneralLedgerBeanOP.setSubAccountCode(((String)
				 * row.get("subCode")));
				 * objGeneralLedgerBeanOP.setSubAccountName(((String)
				 * row.get("subName")));
				 * objGeneralLedgerBeanOP.setCompanyName(((String)
				 * row.get("companyName")));
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
	public ReceiptPaymentBean getOpeningBalance(ReceiptPaymentBean objGeneralLedgerBean) {

		ReceiptPaymentBean objGeneralLedgerBeanOP = new ReceiptPaymentBean();
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
					subAcctCode = jdbcTemplate.queryForObject(ReceiptPaymentQueryUtil.get_acct_head_code, new Object[] { objGeneralLedgerBean.getSubAccountCode() }, String.class);
					System.out.println("getcode:" + subAcctCode);
				}
			}

			String sDynamicQuery = "";

			if (objGeneralLedgerBean.getMainAccountCode() != null && objGeneralLedgerBean.getMainAccountCode() != "") {
				if (subAcctCode != null && subAcctCode != "") {
					sDynamicQuery = ReceiptPaymentQueryUtil.GET_OPENING_BALANCE;
					sDynamicQuery += " from fn_sub_ledger_with_ah(" + compCode + ", TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY'), TO_DATE('" + objGeneralLedgerBean.getToDate() + "','DD-MM-YYYY'),'" + subAcctCode + "','" + objGeneralLedgerBean.getMainAccountCode() + "') ";
				} else {

					sDynamicQuery += " with A as (select sum(credit),sum(debit),sum(debit)-sum(credit) as opening  from general_ledger  where ACCOUNT_HEAD = '" + objGeneralLedgerBean.getMainAccountCode() + "' and ledger_dt::date < TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY') and  company_code in (" + compCode + ")),"

							+ "B as (select sum(credit),sum(debit),sum(debit)-sum(credit) as nowclosing from general_ledger  where ACCOUNT_HEAD = '" + objGeneralLedgerBean.getMainAccountCode() + "' and ledger_dt::date >= TO_DATE('" + objGeneralLedgerBean.getFromDate() + "','DD-MM-YYYY') and ledger_dt::date <= TO_DATE('" + objGeneralLedgerBean.getToDate() + "','DD-MM-YYYY') and company_code in (" + compCode + "))"
							+ "select COALESCE(a.opening,0) as openingBalance,COALESCE(opening+nowclosing,0)  as closingBalance,'test' subCode,'test' subName from a,b";

				}
			} else {
				sDynamicQuery = ReceiptPaymentQueryUtil.GET_OPENING_BALANCE;
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
	public List<ReceiptPaymentBean> getOpeningBalanceSub(ReceiptPaymentBean objGeneralLedgerBean) {
		String mailAcctCode = null;

		List<ReceiptPaymentBean> GeneralLedgerBean = new ArrayList<>();
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
			 * String subAcctList[] =
			 * objGeneralLedgerBean.getSubAccountCode().split(","); String
			 * subAcct=""; for(int i=0;i<subAcctList.length;i++){
			 * if(subAcct==""){ subAcct=subAcctList[i]; } else{
			 * subAcct+=","+subAcctList[i]; } }
			 */
			if (objGeneralLedgerBean.getMainAccountCode() != null && objGeneralLedgerBean.getMainAccountCode() != "")
				mailAcctCode = objGeneralLedgerBean.getMainAccountCode();

			// String sDynamicQuery
			// =GeneralLedgerQueryUtil.GET_OPENING_BALANCE_SUB;

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ReceiptPaymentQueryUtil.GET_OPENING_BALANCE_SUB, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), objGeneralLedgerBean.getSubAccountCode(), mailAcctCode });

			// sDynamicQuery +=
			// " from fn_sub_ledger_with_ah("+compCode+",
			// TO_DATE('"+objGeneralLedgerBean.getFromDate()+"','DD-MM-YYYY'),
			// TO_DATE('"+objGeneralLedgerBean.getToDate()+"','DD-MM-YYYY'),'"+objGeneralLedgerBean.getSubAccountCode()+"','"+mailAcctCode+"')
			// ";

			// List<Map<String, Object>> rows =
			// jdbcTemplate.queryForList(sDynamicQuery);

			for (Map row : rows) {
				ReceiptPaymentBean objGeneralLedgerBeanOP = new ReceiptPaymentBean();
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
			List<SelectivityBean> listdub = jdbcTemplate.query(ReceiptPaymentQueryUtil.get_main_list, new Object[] { main }, new BeanPropertyRowMapper<>(SelectivityBean.class));
			return listdub;
		} catch (DataAccessException e) {

			throw new CustomException("Error in Get Customer List");
		}
	}

	// Account Based Transaction

	@Override
	public List<ReceiptPaymentBean> getGeneralTransaction(ReceiptPaymentBean objGeneralLedgerBean) {
		List<ReceiptPaymentBean> lGeneralLedgerAHList = new ArrayList<>();
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

			lGeneralLedgerAHList = jdbcTemplate.query(ReceiptPaymentQueryUtil.GET_VIEW_REPORT2, new Object[] { compCode, objGeneralLedgerBean.getFromDate(), objGeneralLedgerBean.getToDate(), subGroupCode, mainAcctCode, subAcctCode }, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));

		} catch (DataAccessException e) {

		}
		return lGeneralLedgerAHList;
	}

	@Override
	public String getcompanycode(ReceiptPaymentBean objGeneralLedgerBean) {
		String list = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			list = jdbcTemplate.queryForObject(ReceiptPaymentQueryUtil.CompanyName, new Object[] { objGeneralLedgerBean.getCompanyCode() }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			// LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	@Override
	public String getsubgroup(ReceiptPaymentBean objGeneralLedgerBean) {
		String list = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			list = jdbcTemplate.queryForObject(ReceiptPaymentQueryUtil.SubGroup, new Object[] { objGeneralLedgerBean.getSubGroupCode() }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			// LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	@Override
	public String getaccountname(ReceiptPaymentBean objGeneralLedgerBean) {
		String list = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			list = jdbcTemplate.queryForObject(ReceiptPaymentQueryUtil.getAccountName, new Object[] { objGeneralLedgerBean.getMainAccountCode() }, String.class);
			System.out.println(list);
		} catch (DataAccessException e) {
			// LOGGER.error("Error in getTaxList", e);
		}
		return list;
	}

	@Override
	public String getsubaccountname(ReceiptPaymentBean objGeneralLedgerBean) {
		String value = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String subAcctCode = "";

		try {
			if (isNum(objGeneralLedgerBean.getSubAccountCode())) {

				System.out.println("up:" + objGeneralLedgerBean.getSubAccountCode());
				subAcctCode = objGeneralLedgerBean.getSubAccountCode();

			} else {

				System.out.println("down:" + objGeneralLedgerBean.getSubAccountCode());
				subAcctCode = jdbcTemplate.queryForObject(ReceiptPaymentQueryUtil.get_acct_head_code, new Object[] { objGeneralLedgerBean.getSubAccountCode() }, String.class);
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
	public ReceiptPaymentBean getJournalVoucherforPrint(String voyage) {
		ReceiptPaymentBean bean = new ReceiptPaymentBean();

		List<ReceiptPaymentBean> dtllisthdrBean = new ArrayList<>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {

			/*
			 * bean =
			 * jdbcTemplate.queryForObject(GeneralLedgerQueryUtil.GETPORT, new
			 * Object[] {voyage}, new BeanPropertyRowMapper<>(
			 * GeneralLedgerBean.class));
			 */

			/*
			 * dtllisthdrBean=
			 * jdbcTemplate.query(VesselSailingQueryUtil.GET_VOYPORT,new
			 * Object[] { voyage,port },new
			 * BeanPropertyRowMapper<GeneralLedgerBean
			 * >(GeneralLedgerBean.class));
			 */
			// bean.setDtllisthdrBean(dtllisthdrBean);

		} catch (DataAccessException e) {
		}

		return bean;
	}

	@Override
	public ReceiptPaymentBean getAddress(ReceiptPaymentBean objGeneralLedgerBean) {
		// String address = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		ReceiptPaymentBean address = new ReceiptPaymentBean();

		try {
			// address =
			// jdbcTemplate.queryForObject(GeneralLedgerQueryUtil.getAddress,new
			// Object[]
			// {Integer.parseInt(objGeneralLedgerBean.getSubAccountCode())},GeneralLedgerBean.class);
			/*
			 * address =
			 * jdbcTemplate.queryForObject(GeneralLedgerQueryUtil.getAddress,
			 * new Object[]
			 * {Integer.parseInt(objGeneralLedgerBean.getSubAccountCode())}, new
			 * BeanPropertyRowMapper
			 * <GeneralLedgerBean>(GeneralLedgerBean.class));
			 */

			address = jdbcTemplate.queryForObject(ReceiptPaymentQueryUtil.getAddress, new Object[] { (objGeneralLedgerBean.getSubAccountCode()) }, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));

			// System.out.println(list);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return address;
	}

	@Override
	public List<ReceiptPaymentBean> getGLBankDetail(ReceiptPaymentBean objGeneralLedgerBean) {
		List<ReceiptPaymentBean> lGeneralLedgerTransactionList = new ArrayList<>();
		try {

			double totalAmount = 0;

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

			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

			Date today = new Date();
			String currentdate = DATE_FORMAT.format(today);
			String [] str=objGeneralLedgerBean.getFinancialYear().split("-");
			 int from=Integer.valueOf(str[0])-1;
			 int to=Integer.valueOf(str[0])-1;
			if(objGeneralLedgerBean.getToDate().equals(null) || objGeneralLedgerBean.getToDate().equals("")) {
				System.out.println("select * from get_receipt_bank('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','01/03/"+from+"','31/04/"+to+"' )");
				lGeneralLedgerTransactionList = jdbcTemplate.query("select * from get_receipt_bank('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','01/03/"+from+"','31/04/"+to+"' )", new Object[] {}, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));

			}else {
				System.out.println("select * from get_receipt_bank_date('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','"+objGeneralLedgerBean.getToDate()+"','01/03/"+from+"','31/04/"+to+"' )");
				lGeneralLedgerTransactionList = jdbcTemplate.query("select * from get_receipt_bank_date('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','"+objGeneralLedgerBean.getToDate()+"','01/03/"+from+"','31/04/"+to+"' )", new Object[] {}, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));
			}
			for(ReceiptPaymentBean bn : lGeneralLedgerTransactionList) {
			    if(bn.getAmt()==null)   {
			    	bn.setAmt("0.0");
			    	}
			    bn.setPreAmount(Double.valueOf(bn.getAmt()));
 		  }
		 } catch (DataAccessException e) {
			e.printStackTrace();

		}
		return lGeneralLedgerTransactionList;
	}
	@Override
	public List<ReceiptPaymentBean> getGLBankDetailPayemnt(ReceiptPaymentBean objGeneralLedgerBean) {
		List<ReceiptPaymentBean> lGeneralLedgerTransactionList = new ArrayList<>();
		try {

			double totalAmount = 0;

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

			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

			Date today = new Date();
			String currentdate = DATE_FORMAT.format(today);
			String [] str=objGeneralLedgerBean.getFinancialYear().split("-");
			 int from=Integer.valueOf(str[0])-1;
			 int to=Integer.valueOf(str[0])-1;
			if(objGeneralLedgerBean.getToDate().equals(null) || objGeneralLedgerBean.getToDate().equals("")) {
				System.out.println("select * from get_payment_bank('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','01/03/"+from+"','31/04/"+to+"' )");
				lGeneralLedgerTransactionList = jdbcTemplate.query("select * from get_payment_bank('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','01/03/"+from+"','31/04/"+to+"' )", new Object[] {}, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));

			}else {
				System.out.println("select * from get_payment_bank_date('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','"+objGeneralLedgerBean.getToDate()+"','01/03/"+from+"','31/04/"+to+"' )");
				lGeneralLedgerTransactionList = jdbcTemplate.query("select * from get_payment_bank_date('"+compCode+"','"+objGeneralLedgerBean.getFromDate()+"','"+objGeneralLedgerBean.getToDate()+"','01/03/"+from+"','31/04/"+to+"' )", new Object[] {}, new BeanPropertyRowMapper<>(ReceiptPaymentBean.class));
			}
			for(ReceiptPaymentBean bn : lGeneralLedgerTransactionList) {
			    if(bn.getAmt()==null)   {
			    	bn.setAmt("0.0");
			    	}
			    bn.setPreAmount(Double.valueOf(bn.getAmt()));
 		  }
		 } catch (DataAccessException e) {
			e.printStackTrace();

		}
		return lGeneralLedgerTransactionList;
	}
}