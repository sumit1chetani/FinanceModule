package com.dci.tenant.finance.profitandlossnew;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CommonUtilityQueryUtil;
import com.dci.finance.DayBook.DayBookBean;
import com.dci.finance.DayBook.DayBookQueryUtil;
import com.dci.tenant.user.UserDetail;

@Repository
public class ProfitAndLossDAOImplNew implements ProfitAndLossDAONew {
	private final static Logger LOGGER = Logger.getLogger(ProfitAndLossDAOImplNew.class);
	String whereCond = "";
	String whereCond1 = "";
	String whereCond2 = "";
	@Resource
	private DataSource dataSource;

	@Override
	public List<SelectivityBean> getCompanyList() {
		List<SelectivityBean> lCompanyList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCompanyList = jdbcTemplate.query(ProfitAndLossQueryUtilNew.GET_COMPANY_LIST, new BeanPropertyRowMapper<>(SelectivityBean.class));
		} catch (DataAccessException e) {

		}
		return lCompanyList;
	}

	@Override
	public List<ProfitAndLossBean> generatePLReport(ProfitAndLossBean objProfitAndLossBean) {
		List<ProfitAndLossBean> lPLHdrList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (objProfitAndLossBean.getCompany() == "C0017")
				lPLHdrList = jdbcTemplate.query(ProfitAndLossQueryUtilNew.GET_PL_HDR, new Object[] { (objProfitAndLossBean.getFromDate()), (objProfitAndLossBean.getToDate()), objProfitAndLossBean.getCompany() }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));
			else
				lPLHdrList = jdbcTemplate.query(ProfitAndLossQueryUtilNew.GET_PL_HDR, new Object[] { (objProfitAndLossBean.getFromDate()), (objProfitAndLossBean.getToDate()), objProfitAndLossBean.getCompany() }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));
		} catch (DataAccessException e) {

		}
		return lPLHdrList;
	}

	@Override
	public List<ProfitAndLossBean> generatePLReportDtl(ProfitAndLossBean objProfitAndLossBean) {
		List<ProfitAndLossBean> lPLDtlList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (objProfitAndLossBean.getCompany() == "C0017")
				lPLDtlList = jdbcTemplate.query(ProfitAndLossQueryUtilNew.GET_PL_DTL_C0017, new Object[] { (objProfitAndLossBean.getFromDate()), (objProfitAndLossBean.getToDate()), objProfitAndLossBean.getCompany(), objProfitAndLossBean.getGroupHeadCode() }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));
			else
				lPLDtlList = jdbcTemplate.query(ProfitAndLossQueryUtilNew.GET_PL_DTL, new Object[] { (objProfitAndLossBean.getFromDate()), (objProfitAndLossBean.getToDate()), objProfitAndLossBean.getCompany(), objProfitAndLossBean.getGroupHeadCode() }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));
		} catch (DataAccessException e) {

		}
		return lPLDtlList;
	}

	@Override
	public List<ProfitAndLossBean> generatePLReportAHDtl(ProfitAndLossBean objProfitAndLossBean) {
		List<ProfitAndLossBean> lPLAHDtlList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (objProfitAndLossBean.getCompany() == "C0017")
				lPLAHDtlList = jdbcTemplate.query(ProfitAndLossQueryUtilNew.GET_PLAH_DTL_C0017, new Object[] { (objProfitAndLossBean.getFromDate()), (objProfitAndLossBean.getToDate()), objProfitAndLossBean.getCompany(), objProfitAndLossBean.getGroupHeadCode() }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));
			else
				lPLAHDtlList = jdbcTemplate.query(ProfitAndLossQueryUtilNew.GET_PLAH_DTL, new Object[] { (objProfitAndLossBean.getFromDate()), (objProfitAndLossBean.getToDate()), objProfitAndLossBean.getCompany(), objProfitAndLossBean.getGroupHeadCode() }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));
		} catch (DataAccessException e) {

		}
		return lPLAHDtlList;
	}

	@Override
	public Map<String, ProfitAndLossBean> getProfitLossReportList(ProfitAndLossBean objProfitAndLossBean) {
		Map<String, ProfitAndLossBean> hmSgList = new HashMap<>();
		JdbcTemplate jdbcTemplate1 = new JdbcTemplate(dataSource);
		try {
			List<ProfitAndLossBean> lProfitLossSGlist = new ArrayList<>();
			String compCode = "";
			// if(objProfitAndLossBean.getToDate()!=null
			// ||objProfitAndLossBean.getToDate().isEmpty()){
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date currDate = new Date();
			Date parDate = new Date();

			if (objProfitAndLossBean.getToDate() != null && !objProfitAndLossBean.getToDate().isEmpty())

			{

				parDate = df.parse("31/03/2019");
				currDate = df.parse(objProfitAndLossBean.getToDate());

			}

			String sDynamicQuery = ProfitAndLossQueryUtilNew.GET_PROFIT_LOSS_EXCEL_HDR;
			if (objProfitAndLossBean.getCompany().equalsIgnoreCase("ALL")) {

				List<String> lCompany = new ArrayList<>();
				List<Map<String, Object>> rows = jdbcTemplate1.queryForList(CommonUtilityQueryUtil.COMPANY_MASTER);
				for (Map row : rows) {
					lCompany.add((String) row.get("company_code"));
				}

				for (int i = 0; i < lCompany.size(); i++) {
					if (compCode == "") {
						compCode += "'" + lCompany.get(i) + "'";
					} else {
						compCode += "," + "'" + lCompany.get(i) + "'";
					}
				}
			} else {
				String[] lCompany = objProfitAndLossBean.getCompany().split(",");
				List<String> lCompanyList = Arrays.asList(lCompany);

				for (int i = 0; i < lCompanyList.size(); i++) {
					if (compCode == "") {
						compCode = "'" + lCompanyList.get(i) + "'";
					} else {
						compCode += "," + "'" + lCompanyList.get(i) + "'";
					}
				}
			}
			if (compCode.replaceAll("'", "").equals("C0017")) {
				sDynamicQuery = ProfitAndLossQueryUtilNew.GET_PROFIT_LOSS_EXCEL_HDR_C0017;
				sDynamicQuery += "and  trim(gl.company_id) in (" + compCode + ") ";
				sDynamicQuery += "group by parent_code,account_code,ah.acct_head_name,sgh.group_head_code,sg.sub_head_code HAVING abs((COALESCE(sum(coalesce(local_debit,0.0))-sum(coalesce(local_credit,0.0)),0.0))) != 0 order by acct_head_name,account_code asc";
			}

			else if (currDate.compareTo(parDate) == 0) {
				sDynamicQuery += "and  trim(gl.company_id) in (" + compCode + ") and   particulars not in ('INJV1902346','INJV1902232','INJV1902348','INJV1902347','INJV1902345','INJV1902349')";
				sDynamicQuery += "group by parent_code,account_code,ah.acct_head_name,sgh.group_head_code,sg.sub_head_code HAVING abs((COALESCE(sum(coalesce(tc_debit,0.0))-sum(coalesce(tc_credit,0.0)),0.0)) ) != 0  order by acct_head_name,account_code asc";
			} else {
				sDynamicQuery += "and  trim(gl.company_id) in (" + compCode + ")";
				sDynamicQuery += "group by parent_code,account_code,ah.acct_head_name,sgh.group_head_code,sg.sub_head_code HAVING abs((COALESCE(sum(coalesce(tc_debit,0.0))-sum(coalesce(tc_credit,0.0)),0.0)) ) != 0  order by acct_head_name,account_code asc";
			}
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (objProfitAndLossBean.getFromDate().equalsIgnoreCase("") || objProfitAndLossBean.getFromDate().equalsIgnoreCase(null) ) {
				System.out.println("fhjj");
				sDynamicQuery = ProfitAndLossQueryUtilNew.GET_PROFIT_LOSS_EXCEL_HDR_FINANCIAL_YEAR;
				sDynamicQuery += " and  trim(gl.company_id) in ('C0002')";
				sDynamicQuery += " group by parent_code,account_code,ah.acct_head_name,sgh.group_head_code,sg.sub_head_code " + "HAVING abs((COALESCE(sum(coalesce(local_debit,0.0))-sum(coalesce(local_credit,0.0)),0.0))) != 0 order by acct_head_name,account_code asc";
				lProfitLossSGlist = jdbcTemplate.query(sDynamicQuery, new Object[] {}, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));
			} 
			
	
			/*else {
				System.out.println("out "+objProfitAndLossBean.getFromDate() );
				System.out.println("out1 "+objProfitAndLossBean.getToDate() );
				
				lProfitLossSGlist = jdbcTemplate.query(sDynamicQuery, new Object[] { objProfitAndLossBean.getFromDate(), objProfitAndLossBean.getToDate() }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));
				System.out.println(sDynamicQuery);

			
			}*/
			if (objProfitAndLossBean.getCostCenter().equals(null) || objProfitAndLossBean.getCostCenter().equals("undefined") || objProfitAndLossBean.getCostCenter().equals("")) {
				System.out.println("out "+objProfitAndLossBean.getFromDate() );
				System.out.println("out1 "+objProfitAndLossBean.getToDate() );
				lProfitLossSGlist = jdbcTemplate.query(sDynamicQuery, new Object[] { objProfitAndLossBean.getFromDate(), objProfitAndLossBean.getToDate() }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));
			} else {
				 sDynamicQuery = ProfitAndLossQueryUtilNew.GET_PROFIT_LOSS_EXCEL_HDR_new;
				sDynamicQuery += "and  trim(gl.company_id) in (" + compCode + ")";
				sDynamicQuery += "group by parent_code,account_code,ah.acct_head_name, gl.cost_center ,sgh.group_head_code,sg.sub_head_code HAVING abs((COALESCE(sum(coalesce(tc_debit,0.0))-sum(coalesce(tc_credit,0.0)),0.0)) ) != 0  order by acct_head_name,account_code asc";

				lProfitLossSGlist = jdbcTemplate.query(sDynamicQuery, new Object[] { objProfitAndLossBean.getFromDate(), objProfitAndLossBean.getToDate(),objProfitAndLossBean.getCostCenter() }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));

			}
			
			
			Set<String> sgSet = new HashSet<>();

			for (ProfitAndLossBean objBean : lProfitLossSGlist) {
				if(objBean.getSgcode() != null)
				sgSet.add(objBean.getSgcode());
			}

			Set<String> treeSet = new TreeSet<>(new HashSet());
			treeSet.addAll(sgSet);

			for (String sgCode : treeSet) {
				ProfitAndLossBean objFinalProfitAndLossBean = new ProfitAndLossBean();
				List<ProfitAndLossBean> seperatedList = new ArrayList<>();
				double dGroupAmount = 0.0;
				for (ProfitAndLossBean objBean : lProfitLossSGlist) {
					if(objBean.getSgcode() == null){
						objBean.setSgcode("");
					}
					if (sgCode.trim().equals(objBean.getSgcode().trim())) {
						seperatedList.add(objBean);
						dGroupAmount += objBean.getAmount();
					}
				}
				objFinalProfitAndLossBean.setlAccountHeadLevelList(seperatedList);
				objFinalProfitAndLossBean.setGroupAmount(dGroupAmount);
				objFinalProfitAndLossBean.setSgcode(sgCode);
				hmSgList.put(sgCode, objFinalProfitAndLossBean);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hmSgList;
	}

	public String search(ProfitandLossJobOrderReport objrevenueregister) throws SQLException {

		String customerType = "";
		String category = "";
		String customerCategory = "";
		String pol = "";
		String pod = "";
		String aol = "";
		String aod = "";
		String bid = "";
		String customer = "";

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String whereCond = "b.brnch_id = '" + Integer.parseInt(userDetails.getBranchId()) + " ' ";
		System.out.println("Print the value of customer type");

		if ((objrevenueregister.getFromDate() != null && !objrevenueregister.getFromDate().isEmpty()) && (objrevenueregister.getToDate() != null && !objrevenueregister.getToDate().isEmpty())) {
			whereCond += "  (jb_dt::date >= to_date('" + objrevenueregister.getFromDate() + "','dd/mm/yyyy')";
			whereCond += " and jb_dt::date <= to_date('" + objrevenueregister.getToDate() + "','dd/mm/yyyy'))";

		} else if (objrevenueregister.getFromDate() != null && !objrevenueregister.getFromDate().isEmpty()) {
			whereCond += "  jb_dt::date >= to_date('" + objrevenueregister.getFromDate() + "','dd/mm/yyyy')";

		} else if (objrevenueregister.getToDate() != null && !objrevenueregister.getToDate().isEmpty()) {
			whereCond += "  jb_dt::date <= to_date('" + objrevenueregister.getToDate() + "','dd/mm/yyyy')";
		}

		if (objrevenueregister.getCustomerType().equalsIgnoreCase("AIR,SEA")) {
			if (objrevenueregister.getBranch() != null && !objrevenueregister.getBranch().isEmpty()) {
				whereCond += " and aj.brnch_id  IN (" + objrevenueregister.getBranch() + ")";

			}
			if (objrevenueregister.getStatus() != null && !objrevenueregister.getStatus().isEmpty()) {
				whereCond += " and aj.jb_stts_id  IN (" + objrevenueregister.getStatus() + ")";

			}
			if (objrevenueregister.getService() != null && !objrevenueregister.getService().isEmpty()) {
				whereCond += " and aj.jb_srvc_id  IN (" + objrevenueregister.getService() + ")";

			}

			if (objrevenueregister.getSales() != null && !objrevenueregister.getSales().isEmpty()) {
				whereCond += " and aj.sls_typ_id  IN (" + objrevenueregister.getSales() + ")";

			}
			if (objrevenueregister.getTerm() != null && !objrevenueregister.getTerm().isEmpty()) {
				whereCond += " and aj.trm_id  IN (" + objrevenueregister.getTerm() + ")";

			}
			if (objrevenueregister.getPod() != null && !objrevenueregister.getPod().isEmpty()) {
				whereCond += " and aj.pod_id  IN (" + objrevenueregister.getPod() + ")";
			}
			if (objrevenueregister.getPol() != null && !objrevenueregister.getPol().isEmpty()) {
				whereCond += " and aj.pol_id  IN (" + objrevenueregister.getPol() + ")";
				// aol and aod
			}
			/*
			 * if (objrevenueregister.getPol() != null &&
			 * !objrevenueregister.getPol().isEmpty()) { whereCond +=
			 * " and ao.pol_id  IN ("+objrevenueregister.getPol()+")"; } if
			 * (objrevenueregister.getPod() != null &&
			 * !objrevenueregister.getPod().isEmpty()) { whereCond +=
			 * " and ao.pod_id  IN ("+objrevenueregister.getPod()+")";
			 * 
			 * 
			 * }
			 */
		} else {

			if (objrevenueregister.getCustomerType().equalsIgnoreCase("SEA")) {
				if (objrevenueregister.getBranch() != null && !objrevenueregister.getBranch().isEmpty()) {
					whereCond += " and sj.brnch_id  IN (" + objrevenueregister.getBranch() + ")";

				}
				if (objrevenueregister.getStatus() != null && !objrevenueregister.getStatus().isEmpty()) {
					whereCond += " and sj.jb_stts_id  IN (" + objrevenueregister.getStatus() + ")";

				}
				if (objrevenueregister.getService() != null && !objrevenueregister.getService().isEmpty()) {
					whereCond += " and sj.jb_srvc_id  IN (" + objrevenueregister.getService() + ")";

				}
				if (objrevenueregister.getSales() != null && !objrevenueregister.getSales().isEmpty()) {
					whereCond += " and sj.sls_typ_id  IN (" + objrevenueregister.getSales() + ")";

				}
				if (objrevenueregister.getTerm() != null && !objrevenueregister.getTerm().isEmpty()) {
					whereCond += " and sj.trm_id  IN (" + objrevenueregister.getTerm() + ")";

				}
				if (objrevenueregister.getAod() != null && !objrevenueregister.getAod().isEmpty()) {
					whereCond += " and sj.pod_id  IN (" + objrevenueregister.getAod() + ")";
				}
				if (objrevenueregister.getAol() != null && !objrevenueregister.getAol().isEmpty()) {
					whereCond += " and sj.pol_id  IN (" + objrevenueregister.getAol() + ")";
					// aol and aod
				}
			} else {
				if (objrevenueregister.getCustomerType().equalsIgnoreCase("AIR")) {
					if (objrevenueregister.getBranch() != null && !objrevenueregister.getBranch().isEmpty()) {
						whereCond += " and aj.brnch_id  IN (" + objrevenueregister.getBranch() + ")";

					} /// pod and pol
					if (objrevenueregister.getStatus() != null && !objrevenueregister.getStatus().isEmpty()) {
						whereCond += " and aj.jb_stts_id  IN (" + objrevenueregister.getStatus() + ")";

					}
					if (objrevenueregister.getService() != null && !objrevenueregister.getService().isEmpty()) {
						whereCond += " and aj.jb_srvc_id  IN (" + objrevenueregister.getService() + ")";

					}

					if (objrevenueregister.getSales() != null && !objrevenueregister.getSales().isEmpty()) {
						whereCond += " and aj.sls_typ_id  IN (" + objrevenueregister.getSales() + ")";

					}
					if (objrevenueregister.getTerm() != null && !objrevenueregister.getTerm().isEmpty()) {
						whereCond += " and aj.trm_id  IN (" + objrevenueregister.getTerm() + ")";

					}
					if (objrevenueregister.getPol() != null && !objrevenueregister.getPol().isEmpty()) {
						whereCond += " and aj.pol_id  IN (" + objrevenueregister.getPol() + ")";
					}
					if (objrevenueregister.getPod() != null && !objrevenueregister.getPod().isEmpty()) {
						whereCond += " and aj.pod_id  IN (" + objrevenueregister.getPod() + ")";

					}
				}
			}

		}

		return whereCond;
	}

	public String search2(ProfitandLossJobOrderReport objrevenueregister) throws SQLException {

		String customerType = "";
		String category = "";
		String customerCategory = "";
		String pol = "";
		String pod = "";
		String aol = "";
		String aod = "";
		String bid = "";
		String customer = "";
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String whereCond2 = "b.brnch_id = '" + Integer.parseInt(userDetails.getBranchId()) + " ' ";
		System.out.println("Print the value of customer type");

		if ((objrevenueregister.getFromDate() != null && !objrevenueregister.getFromDate().isEmpty()) && (objrevenueregister.getToDate() != null && !objrevenueregister.getToDate().isEmpty())) {
			whereCond2 += "  (jb_dt::date >= to_date('" + objrevenueregister.getFromDate() + "','dd/mm/yyyy')";
			whereCond2 += " and jb_dt::date <= to_date('" + objrevenueregister.getToDate() + "','dd/mm/yyyy'))";

		} else if (objrevenueregister.getFromDate() != null && !objrevenueregister.getFromDate().isEmpty()) {
			whereCond2 += "  jb_dt::date >= to_date('" + objrevenueregister.getFromDate() + "','dd/mm/yyyy')";

		} else if (objrevenueregister.getToDate() != null && !objrevenueregister.getToDate().isEmpty()) {
			whereCond2 += "  jb_dt::date <= to_date('" + objrevenueregister.getToDate() + "','dd/mm/yyyy')";
		}

		if (objrevenueregister.getCustomerType().equalsIgnoreCase("AIR,SEA")) {
			if (objrevenueregister.getBranch() != null && !objrevenueregister.getBranch().isEmpty()) {
				whereCond2 += " and sj.brnch_id  IN (" + objrevenueregister.getBranch() + ")";

			}
			/*
			 * if (objrevenueregister.getAol() != null &&
			 * !objrevenueregister.getAol().isEmpty()) { whereCond2 +=
			 * " and so.pod_id  IN ("+objrevenueregister.getAol()+")"; } if
			 * (objrevenueregister.getAod() != null &&
			 * !objrevenueregister.getAod().isEmpty()) { whereCond2 +=
			 * " and so.pol_id  IN ("+objrevenueregister.getAod()+")"; //aol and
			 * aod }
			 */
			if (objrevenueregister.getStatus() != null && !objrevenueregister.getStatus().isEmpty()) {
				whereCond2 += " and sj.jb_stts_id  IN (" + objrevenueregister.getStatus() + ")";

			}
			if (objrevenueregister.getService() != null && !objrevenueregister.getService().isEmpty()) {
				whereCond2 += " and sj.jb_srvc_id  IN (" + objrevenueregister.getService() + ")";

			}
			if (objrevenueregister.getSales() != null && !objrevenueregister.getSales().isEmpty()) {
				whereCond2 += " and sj.sls_typ_id  IN (" + objrevenueregister.getSales() + ")";

			}
			if (objrevenueregister.getTerm() != null && !objrevenueregister.getTerm().isEmpty()) {
				whereCond2 += " and sj.trm_id  IN (" + objrevenueregister.getTerm() + ")";

			}
			if (objrevenueregister.getAol() != null && !objrevenueregister.getAol().isEmpty()) {
				whereCond2 += " and sj.pol_id  IN (" + objrevenueregister.getAol() + ")";
			}
			if (objrevenueregister.getAod() != null && !objrevenueregister.getAod().isEmpty()) {
				whereCond2 += " and sj.pod_id  IN (" + objrevenueregister.getAod() + ")";

			}
		} else {

			if (objrevenueregister.getCustomerType().equalsIgnoreCase("SEA")) {
				if (objrevenueregister.getBranch() != null && !objrevenueregister.getBranch().isEmpty()) {
					whereCond2 += " and so.brnch_id  IN (" + objrevenueregister.getBranch() + ")";

				}

				if (objrevenueregister.getAol() != null && !objrevenueregister.getAol().isEmpty()) {
					whereCond2 += " and so.pod_id  IN (" + objrevenueregister.getAol() + ")";
				}
				if (objrevenueregister.getAod() != null && !objrevenueregister.getAod().isEmpty()) {
					whereCond2 += " and so.pol_id  IN (" + objrevenueregister.getAod() + ")";
					// aol and aod
				}
			} else {
				if (objrevenueregister.getCustomerType().equalsIgnoreCase("AIR")) {
					if (objrevenueregister.getBranch() != null && !objrevenueregister.getBranch().isEmpty()) {
						whereCond2 += " and ao.brnch_id  IN (" + objrevenueregister.getBranch() + ")";

					} /// pod and pol

					if (objrevenueregister.getPod() != null && !objrevenueregister.getPod().isEmpty()) {
						whereCond2 += " and ao.pol_id  IN (" + objrevenueregister.getPod() + ")";
					}
					if (objrevenueregister.getPol() != null && !objrevenueregister.getPol().isEmpty()) {
						whereCond2 += " and ao.pod_id  IN (" + objrevenueregister.getPol() + ")";

					}
				}
			}

		}

		return whereCond2;
	}

	@Override
	public ProfitAndLossBean getCompanyDetails(String companyCode) {
		ProfitAndLossBean res = new ProfitAndLossBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<ProfitAndLossBean> lPLHdrList = new ArrayList<>();
			lPLHdrList = jdbcTemplate.query("select company_name as companyName,address as compAddress from company_master where company_code=?", new Object[] { companyCode }, new BeanPropertyRowMapper<>(ProfitAndLossBean.class));
			if (lPLHdrList != null && lPLHdrList.size() > 0) {
				res.setCompanyName(lPLHdrList.get(0).getCompanyName() != null ? lPLHdrList.get(0).getCompanyName() : "");
				res.setCompAddress(lPLHdrList.get(0).getCompAddress() != null ? lPLHdrList.get(0).getCompAddress() : "");
			}
		} catch (DataAccessException e) {

		}
		return res;
	}


}
