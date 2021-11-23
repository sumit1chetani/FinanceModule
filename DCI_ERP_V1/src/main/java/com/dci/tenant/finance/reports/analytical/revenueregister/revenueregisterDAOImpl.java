package com.dci.tenant.finance.reports.analytical.revenueregister;

import java.sql.SQLException;
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

@Repository
@Transactional("tenantTransactionManager")
public class revenueregisterDAOImpl implements revenueregisterDAO {

	String whereCond = "";

	private final static Logger LOGGER = LoggerFactory.getLogger(revenueregisterDAOImpl.class);

	@Resource
	private DataSource dataSource;

	@Override
	public List<revenueregister> geRevenueRegisterList(revenueregister objrevenueregister) throws SQLException {
		List<revenueregister> revenueBean = new ArrayList<revenueregister>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			if (objrevenueregister.getVoyage().equalsIgnoreCase("2")) {// AIR
				String sql = revenueregisterQueryUtil.GET_REVENUE_REGISTER_LIST_AIR;

				if (objrevenueregister.getInvoicefromDate() != null && objrevenueregister.getInvoicetoDate() != null) {
					sql += " where (rev.sls_invc_dt::date >= to_date('" + objrevenueregister.getInvoicefromDate()
							+ "','dd/mm/yyyy') and rev.sls_invc_dt::date <= to_date('"
							+ objrevenueregister.getInvoicetoDate() + "','dd/mm/yyyy'))";
				}
				if (!objrevenueregister.getCompany().equalsIgnoreCase("ALL")) {
					if (objrevenueregister.getCompany() != null && objrevenueregister.getCompany() != "") {

						sql += " and rev.company_code in ('" + objrevenueregister.getCompany() + "')";

					}
				}

					if (objrevenueregister.getCustomer() != null && objrevenueregister.getCustomer() != "") {

						sql += search(objrevenueregister);
					}
			

				revenueBean = jdbcTemplate.query(sql,
						new BeanPropertyRowMapper<revenueregister>(revenueregister.class));
				/*
				 * if(revenueBean.size()>0){ for(int i=0;i<revenueBean.size();i++) {
				 * if(revenueBean.get(i).getBc_amount().equalsIgnoreCase("0")||revenueBean.get(i
				 * ).getBc_amount().equalsIgnoreCase("0.0")||revenueBean.get(i).getBc_amount().
				 * equalsIgnoreCase("0.00")) { revenueBean.get(i).setBc_amount("0.0"); }else{
				 * DecimalFormat IndianCurrencyFormat = new DecimalFormat("#,##,##,###.00");
				 * String value =
				 * IndianCurrencyFormat.format(revenueBean.get(i).getBc_amount());
				 * revenueBean.get(i).setBc_amount(value); }
				 * 
				 * } for(int i=0;i<revenueBean.size();i++) {
				 * if(revenueBean.get(i).getTc_amount().equalsIgnoreCase("0")||revenueBean.get(i
				 * ).getTc_amount().equalsIgnoreCase("0.0")||revenueBean.get(i).getTc_amount().
				 * equalsIgnoreCase("0.00")) { revenueBean.get(i).setTc_amount("0.0"); }else{
				 * 
				 * DecimalFormat IndianCurrencyFormat = new DecimalFormat("#,##,##,###.00");
				 * String value =
				 * IndianCurrencyFormat.format(revenueBean.get(i).getTc_amount());
				 * revenueBean.get(i).setTc_amount(value); }
				 * 
				 * } }
				 */

				System.out.println("print the query ++++++++++++++++++++++++===" + sql);
				/* return revenueBean; */

			} else if(objrevenueregister.getVoyage().equalsIgnoreCase("1")) {// SEA
				String sql = revenueregisterQueryUtil.GET_REVENUE_REGISTER_LIST_SEA;


				if (objrevenueregister.getInvoicefromDate() != null && objrevenueregister.getInvoicetoDate() != null) {
					sql += " where (rev.sls_invc_dt::date >= to_date('" + objrevenueregister.getInvoicefromDate()
							+ "','dd/mm/yyyy') and rev.sls_invc_dt::date <= to_date('"
							+ objrevenueregister.getInvoicetoDate() + "','dd/mm/yyyy'))";
				}
				if (!objrevenueregister.getCompany().equalsIgnoreCase("ALL")) {
					if (objrevenueregister.getCompany() != null && objrevenueregister.getCompany() != "") {

						sql += " and rev.company_code in ('" + objrevenueregister.getCompany() + "')";

					}
				}
				if (objrevenueregister.getCustomer() != null && objrevenueregister.getCustomer() != "") {

					sql += search(objrevenueregister);
				}

				revenueBean = jdbcTemplate.query(sql,
						new BeanPropertyRowMapper<revenueregister>(revenueregister.class));

				System.out.println("print the query ++++++++++++++++++++++++===" + sql);

			}else {//ALL
			
				String sql = revenueregisterQueryUtil.GET_REVENUE_REGISTER_LIST_SEA_AIR;

		

				if (objrevenueregister.getInvoicefromDate() != null && objrevenueregister.getInvoicetoDate() != null) {
					sql += " where (invoiceDt::date >= to_date('" + objrevenueregister.getInvoicefromDate()
							+ "','dd/mm/yyyy') and invoiceDt::date <= to_date('"
							+ objrevenueregister.getInvoicetoDate() + "','dd/mm/yyyy'))";
				}
				if (!objrevenueregister.getCompany().equalsIgnoreCase("ALL")) {
					if (objrevenueregister.getCompany() != null && objrevenueregister.getCompany() != "") {

						sql += " and company_code in ('" + objrevenueregister.getCompany() + "')";

					}
				}
				if (objrevenueregister.getCustomer() != null && objrevenueregister.getCustomer() != "") {

					sql += searchAll(objrevenueregister);
				}

				revenueBean = jdbcTemplate.query(sql,
						new BeanPropertyRowMapper<revenueregister>(revenueregister.class));


				System.out.println("print the query ++++++++++++++++++++++++===" + sql);

			
				
				
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);

		}
		return revenueBean;
	}

	@Override
	public List<revenueregister> getpayer() {
		List<revenueregister> objBean = new ArrayList<revenueregister>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(revenueregisterQueryUtil.payerList);

			for (Map row : rows) {
				revenueregister bean = new revenueregister();
				bean.setId((String) row.get("id"));
				bean.setText((String) row.get("text"));
				objBean.add(bean);

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);

		}
		return objBean;
	}

	@Override
	public List<revenueregister> getCustomer() {
		List<revenueregister> objBean = new ArrayList<revenueregister>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(revenueregisterQueryUtil.customerList);

			for (Map row : rows) {
				revenueregister bean = new revenueregister();
				bean.setId((String) row.get("id"));
				bean.setText((String) row.get("text"));
				objBean.add(bean);

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);

		}
		return objBean;
	}

	@Override
	public List<revenueregister> getportIsoCode() {
		List<revenueregister> objBean = new ArrayList<revenueregister>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(revenueregisterQueryUtil.getPortIsoCode);

			for (Map row : rows) {
				revenueregister bean = new revenueregister();
				bean.setId((String) row.get("portIsoCode"));
				bean.setText((String) row.get("portIsoCode"));
				objBean.add(bean);

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);

		}
		return objBean;
	}

	public String search(revenueregister objrevenueregister) throws SQLException {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String companyCodes[] = objrevenueregister.getCustomer().split(",");
		String compCode = "'";
		for (int i = 0; i < companyCodes.length; i++) {
			if (compCode == "'") {
				compCode += companyCodes[i];
			} else {
				compCode += "','" + companyCodes[i];
			}
		}
		compCode += "'";

		/*
		 * String compCodes=""; for(int i=0;i<companyCodes.length;i++){
		 * if(compCodes==""){ compCodes=companyCodes[i]; } else{
		 * compCodes+=","+companyCodes[i]; } }
		 */

		/* compCode +=objrevenueregister.getCustomer()+ "'"; */

		String whereCond = "";
		/*
		 * System.out.println("Print the value of customer type");
		 * System.out.println(objrevenueregister.getCustomerType());
		 */

		if (compCode != null && !compCode.isEmpty()) {

			whereCond += " and sp.srvc_prtnr_bin in (" + compCode + ")";
		}

		return whereCond;
	}
	
	public String searchAll(revenueregister objrevenueregister) throws SQLException {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String companyCodes[] = objrevenueregister.getCustomer().split(",");
		String compCode = "'";
		for (int i = 0; i < companyCodes.length; i++) {
			if (compCode == "'") {
				compCode += companyCodes[i];
			} else {
				compCode += "','" + companyCodes[i];
			}
		}
		compCode += "'";

		/*
		 * String compCodes=""; for(int i=0;i<companyCodes.length;i++){
		 * if(compCodes==""){ compCodes=companyCodes[i]; } else{
		 * compCodes+=","+companyCodes[i]; } }
		 */

		/* compCode +=objrevenueregister.getCustomer()+ "'"; */

		String whereCond = "";
		/*
		 * System.out.println("Print the value of customer type");
		 * System.out.println(objrevenueregister.getCustomerType());
		 */

		if (compCode != null && !compCode.isEmpty()) {

			whereCond += " and srvc_prtnr_bin in (" + compCode + ")";
		}

		return whereCond;
	}

	public String getOrConditions(String src, String columnName, boolean isLikeNeeded) {
		StringBuffer result = new StringBuffer("(");
		String[] splitted = (src != null) ? src.split(",") : null;
		if (splitted != null && splitted.length > 0) {
			for (int i = 0; i < splitted.length; i++) {
				if (i == 0) {
					result.append(" " + columnName + " like '" + splitted[i] + "" + ((isLikeNeeded) ? "%" : "") + "' ");
				} else {
					result.append(
							" or " + columnName + " like '" + splitted[i] + "" + ((isLikeNeeded) ? "%" : "") + "' ");
				}
			}
		}
		result.append(")");

		System.out.println("condition+++++++++++++++++++++++++++++++++++++++" + result.toString());
		return result.toString();
	}
}