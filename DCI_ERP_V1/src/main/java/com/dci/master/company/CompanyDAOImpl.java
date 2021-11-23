package com.dci.master.company;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;


@Repository
@Transactional("tenantTransactionManager")
public class CompanyDAOImpl implements CompanyDAO {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;

	@Override
	public List<CompanyBean> getCompanyList() {

		List<CompanyBean> list = new ArrayList<CompanyBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(CompanyQueryUtil.list, new BeanPropertyRowMapper<CompanyBean>(CompanyBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public List<CompanyBean> getdropdown() {

		List<CompanyBean> list = new ArrayList<CompanyBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(CompanyQueryUtil.GETCurrencylist, new BeanPropertyRowMapper<CompanyBean>(CompanyBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public List<CompanyBean> getCountry() {

		List<CompanyBean> list = new ArrayList<CompanyBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(CompanyQueryUtil.GETCountrylist, new BeanPropertyRowMapper<CompanyBean>(CompanyBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


	@Override
	public CompanyBean insert(CompanyBean company) throws Exception {
		
		 Boolean isSuccess = false;
			
		 CompanyBean companyBean = new CompanyBean();
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			String company_code = "";

			company_code = jdbcTemplate.queryForObject(CompanyQueryUtil.GENERATE_COMPANY_CODE, new Object[] { "C", "C" },
					String.class);
			company_code = "C" + company_code;

			int i=jdbcTemplate.update(CompanyQueryUtil.INSERT,company_code, company.getCompany_name(), company.getLocation(),
					company.getAddress(), company.getTelephone_no(), company.getCurrency(), company.getShort_name(), company.getFax_no(),
					company.getEmail(), company.getPerson_incharge(), company.getRelationship(), company.getIntercompanygroup(), company.getVat_reg_no());
			UserLog userLog = userlogDao.userLogForInsert(company, company_code,userDetails.getUserId() );

			if(i>0) {
	            	isSuccess = true;
	            	companyBean.setIsSuccess(isSuccess);
	            }
			}catch (DataAccessException e) {
				e.printStackTrace();
				isSuccess = false;
				companyBean.setIsSuccess(isSuccess);
				companyBean.setMessage("Error in save :" + e.getMessage());
			}
			return companyBean;
		}
	@Override
	public CompanyBean update(CompanyBean company) throws Exception {
		 Boolean isSuccess = false;
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 CompanyBean companyBean = new CompanyBean();
		 
		 CompanyBean oldbean = new CompanyBean();
		 oldbean = getEdit(company.getCompany_code());
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			int i=jdbcTemplate.update(CompanyQueryUtil.UPDATE, company.getCompany_name(), company.getLocation(),
					company.getAddress(), company.getTelephone_no(), company.getCurrency(), company.getShort_name(), company.getFax_no(),
					company.getEmail(), company.getPerson_incharge(), company.getRelationship(), company.getIntercompanygroup(), company.getVat_reg_no(), company.getCompany_code() );
			
			UserLog userLog = userlogDao.userLogForUpdate(oldbean, company, company.getCompany_code(),userDetails.getUserId() );
			 if(i>0) {
	            	isSuccess = true;
	            	companyBean.setIsSuccess(isSuccess);
	            }
			}catch (DataAccessException e) {
				e.printStackTrace();
				isSuccess = false;
				companyBean.setIsSuccess(isSuccess);
				companyBean.setMessage("Error in save :" + e.getMessage());
			}
			return companyBean;
		}
	@Override
	public boolean delete(String company_code) {
		// TODO Auto-generated method stub
		boolean isDeleted = false;
		 
		 CompanyBean oldbean = new CompanyBean();
		 oldbean = getEdit(company_code);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


		try {
			jdbcTemplate.update(CompanyQueryUtil.delete, company_code);
			UserLog userLog = userlogDao.userLogForDelete(oldbean, company_code,userDetails.getUserId() );

			isDeleted = true;
		} catch (DataAccessException e) {
			e.printStackTrace();

		}

		return isDeleted;
	}

	@Override
	public CompanyBean getEdit(String company_code) {
		CompanyBean companybean =new CompanyBean();
		try {
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			companybean = jdbcTemplate.queryForObject(CompanyQueryUtil.GET_COMPANY,
					new Object[] { company_code },
					new BeanPropertyRowMapper<CompanyBean>(CompanyBean.class));

		}catch (DataAccessException e) {
			e.printStackTrace();

		}
		return companybean;
	}
}
