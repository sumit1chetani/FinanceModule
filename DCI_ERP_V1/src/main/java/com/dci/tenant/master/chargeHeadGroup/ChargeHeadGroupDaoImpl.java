package com.dci.tenant.master.chargeHeadGroup;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")
public class ChargeHeadGroupDaoImpl implements ChargeHeadGroupDao {

	private final static Logger LOGGER = Logger.getLogger(ChargeHeadGroupDaoImpl.class);

	@Resource
	private DataSource dataSource;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;
	
	@Override
	public List<ChargeHeadGroupBean> getList() {
		boolean isActive1=true;
		boolean  Status;
		List<ChargeHeadGroupBean> list = new ArrayList<ChargeHeadGroupBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(ChargeHeadGroupQueryutil.list,
					new BeanPropertyRowMapper<ChargeHeadGroupBean>(
							ChargeHeadGroupBean.class));
	
	/*	for(ChargeHeadGroupBean obj:list){
				if(obj.isActive==isActive1){
					Status=true;
					
				}
				else{
					Status=false;
				}
				obj.setActive(Status);
			}
*/
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in list", e);
		}

		return list;
	}

	@Override
	public Object save(ChargeHeadGroupBean bean)throws CustomException {

		Integer save = null;
		String bool;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String count;
		ChargeHeadGroupBean beanlog = new ChargeHeadGroupBean();
		
		try {
			bean.setTableName("charge_head_group");
			bean.setFormCode("F5087");
			
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(bean.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}	
			//select count(*) from iata where iata_cd Ilike ? and iata_nam Ilike ? and cty_id  Ilike ? and dscrptn_vc  Ilike ? and actv_bt Ilike ?
			//count = jdbcTemplate.queryForObject(ChargeHeadGroupQueryutil.duplicate,new Object[] {bean.getChargeHeadGroupCode(),bean.getChargeHeadGroupName(),bean.getChargeHeadGroupCity(),bean.getDescription(),bean.getIsActive()},String.class);
			//if(count.equalsIgnoreCase("0")){
			//int count1 =	jdbcTemplate.queryForObject(ChargeHeadGroupQueryutil.duplicate,);
			int count1=jdbcTemplate.queryForObject(ChargeHeadGroupQueryutil. count1,Integer.class);
				save = jdbcTemplate.update(ChargeHeadGroupQueryutil.save, new Object[] {count1,bean.getCode(),bean.getName(),bean.getDescription(),bool,userDetails.getUserId(),userDetails.getUserId()});				
				//int iata = jdbcTemplate.queryForObject(ChargeHeadGroupQueryutil.SELECT_PREVIOUS_ID,Integer.class);
				
			userlogDao.userLogForInsert(bean, count1 + "", userDetails.getUserId()); 
			
//	}
	//	else{
	//			throw new CustomException("NAME ALREADY EXISTS");
	//		}
			
			
			
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in save", e);

		}	
		
		return save;
	}

	@Override
	public ChargeHeadGroupBean edit(int rowid) throws Exception {

		ChargeHeadGroupBean editbean = new ChargeHeadGroupBean();
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Object[] params = new Object[] { rowid };
			editbean = jdbcTemplate.queryForObject(ChargeHeadGroupQueryutil.edit,new Object[]{rowid}, new BeanPropertyRowMapper<ChargeHeadGroupBean>(ChargeHeadGroupBean.class));
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in edit", e);
		}
		return editbean;
	}

	@Override
	public boolean update(ChargeHeadGroupBean update) throws Exception {

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String bool;
		Integer update1 = null; 
		boolean issucces = false;
		
		ChargeHeadGroupBean oldbeanlog = edit(update.getChargeHeadGroupid());
		
		
		try{
			update.setTableName("charge_head_group");
			update.setFormCode("F5087");
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
		if(update.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}
			//UPDATE iata SET iata_cd=?, iata_nam=?,cty_id=?, dscrptn_vc=?, actv_bt=?,mdfd_by=?, mdfd_dt=now() where iata_id =?
			update1 = jdbcTemplate.update(ChargeHeadGroupQueryutil.update, new Object[] {update.getCode(),update.getName(),update.getDescription(),bool,userDetails.getUserId(),update.getChargeHeadGroupid()});
			userlogDao.userLogForUpdate(oldbeanlog,update,update.getChargeHeadGroupid() + "",userId);
			issucces = true;
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in update", e);
		}
		
		return issucces;
	} 

	@Override
	public boolean delete(int rowid) throws Exception {


		boolean issucces = false;
		int value= 0;		
		ChargeHeadGroupBean beanlog = edit(rowid);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			beanlog.setTableName("charge_head_group");
			beanlog.setFormCode("F5087");			
			value = jdbcTemplate.update(ChargeHeadGroupQueryutil.delete,rowid);
			userlogDao.userLogForDelete(beanlog, rowid + "", userDetails.getUserId());			
			issucces = true;
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in update", e);
		}
		return issucces;
	}

}
