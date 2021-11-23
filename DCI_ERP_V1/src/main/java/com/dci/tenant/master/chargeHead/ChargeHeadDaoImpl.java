package com.dci.tenant.master.chargeHead;
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

import com.dci.common.model.SelectivityBen;
import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")
public class ChargeHeadDaoImpl implements ChargeHeadDao {

	private final static Logger LOGGER = Logger.getLogger(ChargeHeadDaoImpl.class);

	@Resource
	private DataSource dataSource;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;
	
	@Override
	public List<ChargeHeadBean> getList() {
boolean isActive1=true;
boolean  Status;
		List<ChargeHeadBean> list = new ArrayList<ChargeHeadBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(ChargeHeadQueryutil.list,
					new BeanPropertyRowMapper<ChargeHeadBean>(
							ChargeHeadBean.class));
	
	/*	for(ChargeHeadBean obj:list){
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
	public Object save(ChargeHeadBean bean)throws CustomException {

		Integer save = null;
		String bool;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String count;
		ChargeHeadBean beanlog = new ChargeHeadBean();
		
		try {
			bean.setTableName("charge_head");
			bean.setFormCode("F5090");
			
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(bean.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}	
			
			//int count1=jdbcTemplate.queryForObject(ChargeHeadQueryutil. count1,Integer.class);
			

				save = jdbcTemplate.update(ChargeHeadQueryutil.save, new Object[] {bean.getCode(),bean.getName(),bean.getGroup(),bean.getDescription(),bean.getSacNo(),bean.getsName(),bean.getpName(),bool,userDetails.getUserId(),userDetails.getUserId(),bean.getCgst(),bean.getSgst(),bean.getIgst(),bean.getGst()});
				int count1=jdbcTemplate.queryForObject(ChargeHeadQueryutil. count1,Integer.class);
				
			userlogDao.userLogForInsert(bean, count1 + "", userDetails.getUserId()); 
			
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in save", e);

		}	
		
		return save;
	}
	@Override
	public ChargeHeadResultBean selectivity() throws Exception {
		List<SelectivityBen> selectivity = new ArrayList<SelectivityBen>();
		List<SelectivityBen> accountHeadList = new ArrayList<SelectivityBen>();
		List<SelectivityBen> accountHeadListRevenue = new ArrayList<SelectivityBen>();
        ChargeHeadResultBean resultbean = new ChargeHeadResultBean();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			selectivity = jdbcTemplate.query(ChargeHeadQueryutil.Selectivity_bean, new BeanPropertyRowMapper<SelectivityBen>(SelectivityBen.class));
			accountHeadList = jdbcTemplate.query(ChargeHeadQueryutil.GET_ACCOUNT_HEAD_LIST, new BeanPropertyRowMapper<SelectivityBen>(SelectivityBen.class));
			accountHeadListRevenue = jdbcTemplate.query(ChargeHeadQueryutil.GET_ACCOUNT_HEAD_LIST_Revenue, new BeanPropertyRowMapper<SelectivityBen>(SelectivityBen.class));
			resultbean.setAccountHeadList(accountHeadList);
			resultbean.setAccountHeadListRevenue(accountHeadListRevenue);
			resultbean.setSelectivitybean(selectivity);
			
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in selectivity", e);
		}
		
		
		return resultbean;
	}
	@Override
	public ChargeHeadBean edit(int rowid) throws Exception {

		ChargeHeadBean editbean = new ChargeHeadBean();
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Object[] params = new Object[] { rowid };
			editbean = jdbcTemplate.queryForObject(ChargeHeadQueryutil.edit,new Object[]{rowid}, new BeanPropertyRowMapper<ChargeHeadBean>(ChargeHeadBean.class));
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in edit", e);
		}
		return editbean;
	}
	
	@Override
	public ChargeHeadBean view(int rowid) throws Exception {

		ChargeHeadBean editbean = new ChargeHeadBean();
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Object[] params = new Object[] { rowid };
			editbean = jdbcTemplate.queryForObject(ChargeHeadQueryutil.view,new Object[]{rowid}, new BeanPropertyRowMapper<ChargeHeadBean>(ChargeHeadBean.class));
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in view", e);
		}
		return editbean;
	}

	

	@Override
	public boolean update(ChargeHeadBean update) throws Exception {

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String bool;
		Integer update1 = null; 
		boolean issucces = false;
		
		ChargeHeadBean oldbeanlog = edit(update.getId());
		
		
		try{
			update.setTableName("charge_head");
			update.setFormCode("F5090");
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
		if(update.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}
		//UPDATE charge_head SET chrg_hd_cd=?, chrg_hd_nam=?,chrg_hd_grp_id=?,sac_no=?,sls_ldger_nam=?,prchs_ldger_nam=?,dscrptn_vc=?, actv_bt= pg_catalog.bit(?),mdfd_by=?, mdfd_dt=now() where chrg_hd_id =?			
		
		update1 = jdbcTemplate.update(ChargeHeadQueryutil.update(bool), new Object[] {update.getCode(),update.getName(),update.getGroup(),update.getSacNo(),update.getsName(),update.getpName(),update.getDescription(),userDetails.getUserId(),update.getCgst(),update.getSgst(),update.getIgst(),update.getGst(),update.getId()});
			
		userlogDao.userLogForUpdate(oldbeanlog,update,update.getId() + "",userId);
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
		ChargeHeadBean beanlog = edit(rowid);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			beanlog.setTableName("charge_head");
			beanlog.setFormCode("F5090");			
			value = jdbcTemplate.update(ChargeHeadQueryutil.delete,rowid);
			userlogDao.userLogForDelete(beanlog, rowid + "", userDetails.getUserId());			
			issucces = true;
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in delete", e);
		}
		
		return issucces;
	}

}
