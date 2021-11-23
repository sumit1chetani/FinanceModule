package com.dci.tenant.truck.general.chargecomponent;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")
public class ChargecomponentDaoImpl implements ChargecomponentDao {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(ChargecomponentDaoImpl.class);

	@Resource
	private DataSource dataSource;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;

	@Override
	public List<ChargecomponentBean> getList() {

		List<ChargecomponentBean> list = new ArrayList<ChargecomponentBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(ChargecomponentQueryutil.list,
					new BeanPropertyRowMapper<ChargecomponentBean>(
							ChargecomponentBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Object save(ChargecomponentBean bean)throws CustomException {

		Integer save = null;
		String bool;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String count;
		ChargecomponentBean beanlog = new ChargecomponentBean();
		
		try {
			bean.setTableName("Charge Component");
			bean.setFormCode("F3533");
			
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(bean.getIsActive().equalsIgnoreCase("true")){
				bool = "t";
			}else{
				bool = "f";
			}			
			count = jdbcTemplate.queryForObject(ChargecomponentQueryutil.duplicate,new Object[] {bean.getChargeCode(),bean.getChargeName(),bean.getChargeType(),bean.getChargeComponentdescription(),bool},String.class);
			if(count.equalsIgnoreCase("0")){
				save = jdbcTemplate.update(ChargecomponentQueryutil.save, new Object[] {bean.getChargeCode(),bean.getChargeName(),bean.getChargeType(),bean.getChargeComponentdescription(),bool,userDetails.getUserId()});				
				int chargeComponent = jdbcTemplate.queryForObject(ChargecomponentQueryutil.SELECT_PREVIOUS_ID,Integer.class);
				
				userlogDao.userLogForInsert(bean, chargeComponent + "", userDetails.getUserId()); 
			
			}else{
				throw new CustomException("NAME ALREADY EXISTS");
			}
			
			
			
		} catch (Exception e) {

			e.printStackTrace();

		}	
		
		return save;
	}

	@Override
	public ChargecomponentBean edit(int rowid) throws Exception {

		ChargecomponentBean editbean = new ChargecomponentBean();
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Object[] params = new Object[] { rowid };
			editbean = jdbcTemplate.queryForObject(ChargecomponentQueryutil.edit,new Object[]{rowid}, new BeanPropertyRowMapper<ChargecomponentBean>(ChargecomponentBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return editbean;
	}

	@Override
	public boolean update(ChargecomponentBean update) throws Exception {

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String bool;
		Integer update1 = null; 
		boolean issucces = false;
		
		ChargecomponentBean oldbeanlog = edit(update.getChargeComponentid());
		
		
		try{
			update.setTableName("Charge Component");
			update.setFormCode("F3533");
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			if(update.getIsActive().equalsIgnoreCase("true")){
				bool = "t";
			}else{
				bool = "f";
			}
			
			update1 = jdbcTemplate.update(ChargecomponentQueryutil.update, new Object[] {update.getChargeCode(),update.getChargeName(),update.getChargeType(),update.getChargeComponentdescription(),bool,userDetails.getUserId(),update.getChargeComponentid()});
			userlogDao.userLogForUpdate(oldbeanlog,update, update.getChargeComponentid() + "", userDetails.getUserId());
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
		ChargecomponentBean beanlog = edit(rowid);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			beanlog.setTableName("Charge Component");
			beanlog.setFormCode("F3533");			
			value = jdbcTemplate.update(ChargecomponentQueryutil.delete,rowid);
			userlogDao.userLogForDelete(beanlog, rowid + "", userDetails.getUserId());			
			issucces = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return issucces;
	}

	@Override
	public ChargecomponentResultBean selectivity() throws Exception {
		List<SelectivityBean> selectivity = new ArrayList<SelectivityBean>();
		ChargecomponentResultBean resultbean = new ChargecomponentResultBean();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			selectivity = jdbcTemplate.query(ChargecomponentQueryutil.Selectivity_bean, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			resultbean.setSelectivitybean(selectivity);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return resultbean;
	}
	
	

}

