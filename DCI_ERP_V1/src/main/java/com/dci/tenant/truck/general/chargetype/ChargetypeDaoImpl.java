package com.dci.tenant.truck.general.chargetype;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")
public class ChargetypeDaoImpl implements ChargetypeDao{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ChargetypeDaoImpl.class);

	@Resource
	private DataSource dataSource;	
	
	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;

	@Override
	public List<ChargetypeBean> getList() {
		
		List<ChargetypeBean> list = new ArrayList<ChargetypeBean>();
		
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			list = jdbcTemplate.query(ChargetypeQueryutil.list,new BeanPropertyRowMapper<ChargetypeBean>(ChargetypeBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public Object save(ChargetypeBean bean) {
		Integer save = null;
		String bool;
		String count;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ChargetypeBean beanlog = new ChargetypeBean();
		
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			bean.setTableName("Chargetype");
			bean.setFormCode("F3532");			
			
			if(bean.getIsActive().equalsIgnoreCase("true")){
				bool = "t";
			}else{
				bool = "f";
			}
			count = jdbcTemplate.queryForObject(ChargetypeQueryutil.duplicate,new Object[] {bean.getChargeTypecode(),bean.getChargeTypename(),bean.getChargeTypedescription(),bool},String.class);
			if(count.equalsIgnoreCase("0")){
				save = jdbcTemplate.update(ChargetypeQueryutil.save, new Object[] {bean.getChargeTypecode(),bean.getChargeTypename(),bean.getChargeTypedescription(),bool,userDetails.getUserId()});
				
				int chargeType = jdbcTemplate.queryForObject(ChargetypeQueryutil.SELECT_PREVIOUS_ID,Integer.class);
				
				userlogDao.userLogForInsert(bean, chargeType + "", userDetails.getUserId());
			}else{
				save = 0;
			}
			
			
		} catch (DataAccessException e) {

			LOGGER.error("AccountingYearCloseBean " + e);

		}	
		
		return save;
	}

	@Override
	public ChargetypeBean edit(int rowid) throws Exception {
		ChargetypeBean editbean = new ChargetypeBean();
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Object[] params = new Object[] { rowid };
			editbean = jdbcTemplate.queryForObject(ChargetypeQueryutil.edit,new Object[]{rowid}, new BeanPropertyRowMapper<ChargetypeBean>(ChargetypeBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return editbean;
	}

	@Override
	public boolean update(ChargetypeBean update) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String bool;
		Integer update1 = null; 
		boolean issucces = false;
		ChargetypeBean oldbeanlog = edit(update.getChargeTypeid());
		
		
		try{
			update.setTableName("Chargetype");
			update.setFormCode("F3532");			
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			if(update.getIsActive().equalsIgnoreCase("true")){
				bool = "t";
			}else{
				bool = "f";
			}
			update1 = jdbcTemplate.update(ChargetypeQueryutil.update, new Object[] {update.getChargeTypecode(),update.getChargeTypename(),update.getChargeTypedescription(),bool,userDetails.getUserId(),update.getChargeTypeid()});
			
			userlogDao.userLogForUpdate(oldbeanlog,update, update.getChargeTypeid() + "", userDetails.getUserId());
			
			
			issucces = true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return issucces;
	}

	@Override
	public boolean delete(int rowid) throws Exception {
		
		boolean issucces = false;
		int value= 0;	
		
		try{	
			ChargetypeBean beanlog = edit(rowid);
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			beanlog.setTableName("Chargetype");
			beanlog.setFormCode("F3532");			
			value = jdbcTemplate.update(ChargetypeQueryutil.delete,rowid);
			userlogDao.userLogForDelete(beanlog, rowid + "", userDetails.getUserId());
			
			issucces = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return issucces;
	}

}

