package com.dci.tenant.master.city;
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

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;


@Repository
@Transactional("tenantTransactionManager")
public class CityDaoImpl implements CityDao {

	private final static Logger LOGGER = Logger.getLogger(CityDaoImpl.class);

	@Resource
	private DataSource dataSource;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;
	@Override
	public CityResultBean selectivity() throws Exception {
		List<SelectivityBean> selectivity = new ArrayList<SelectivityBean>();
		CityResultBean resultbean = new CityResultBean();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			selectivity = jdbcTemplate.query(CityQueryutil.Selectivity_bean, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			resultbean.setSelectivitybean(selectivity);
			
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in selectivity", e);
		}
		
		
		return resultbean;
	}
	@Override
	public List<CityBean> getList() {

		List<CityBean> list = new ArrayList<CityBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(CityQueryutil.list,
					new BeanPropertyRowMapper<CityBean>(
							CityBean.class));

		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in list", e);
		}

		return list;
	}

	@Override
	public Object save(CityBean bean)throws CustomException {

		Integer save = null;
		String bool,bool1;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String count;
		CityBean beanlog = new CityBean();
		
		try {
			bean.setTableName("city");
			bean.setFormCode("F5593");
			
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(bean.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}		
			
			
			
			int count1=jdbcTemplate.queryForObject(CityQueryutil. count1,Integer.class);

			//insert into city(cty_id,cty_cd,cty_nam,zp_cd,stt_id,dscrptn_vc, crtd_by, crtd_dt,mdfd_by, mdfd_dt,actv_bt) 
		
			save = jdbcTemplate.update(CityQueryutil.save, new Object[] {count1,bean.getCode(),bean.getName(),bean.getPin(),bean.getState(),bean.getDescription(),userDetails.getUserId(),userDetails.getUserId(),bool});				
			
				
				
			userlogDao.userLogForInsert(bean, count1 + "", userDetails.getUserId()); 
			
			/*}else{
				throw new CustomException("NAME ALREADY EXISTS");
			}
			*/
			
			
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in save", e);
		}	
		
		return save;
	}

	@Override
	public CityBean edit(int rowid) throws Exception {

		CityBean editbean = new CityBean();
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Object[] params = new Object[] { rowid };
			editbean = jdbcTemplate.queryForObject(CityQueryutil.edit,new Object[]{rowid}, new BeanPropertyRowMapper<CityBean>(CityBean.class));
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in edit", e);
		}
		return editbean;
	}

	@Override
	public boolean update(CityBean update) throws Exception {



		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String bool,bool1;
		Integer update1 = null; 
		boolean issucces = false;
		
		CityBean oldbeanlog = edit(update.getCityid());

if (oldbeanlog.getIsStstus().equalsIgnoreCase("t"))
		{
			oldbeanlog.isActive=true;
		}
		
		try{
			update.setTableName("city");
			update.setFormCode("F5593");
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			if(update.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}
			
		

			//UPDATE state SET cty_cd=?, cty_nam=?,zp_cd=?,stt_id=?, dscrptn_vc=?,mdfd_by=?, mdfd_dt=now(),actv_bt=pg_catalog.bit(?) where cty_id =?
			update1 = jdbcTemplate.update(CityQueryutil.update, new Object[] {update.getCode(),update.getName(),update.getPin(),update.getState(),update.getDescription(),userDetails.getUserId(),bool,update.getCityid()});
			userlogDao.userLogForUpdate(oldbeanlog,update,update.getCityid() + "",userId);
			issucces = true;
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in IsStatus", e);
		}
		
		return issucces;
	}

	@Override
	public boolean delete(int rowid) throws Exception {

		boolean issucces = false;
		int value= 0;		
		CityBean beanlog = edit(rowid);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			beanlog.setTableName("city");
			beanlog.setFormCode("F5593");	
			CityBean oldbeanlog = edit(rowid);
			value = jdbcTemplate.update(CityQueryutil.delete,rowid);
			userlogDao.userLogForDelete(beanlog, rowid + "", userDetails.getUserId());			
			issucces = true;
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in delete", e);
		}
		
		return issucces;
	}

}
