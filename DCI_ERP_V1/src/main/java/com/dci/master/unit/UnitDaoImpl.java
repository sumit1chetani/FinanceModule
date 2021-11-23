package com.dci.master.unit;
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
public class UnitDaoImpl implements UnitDao {

	private final static Logger LOGGER = Logger.getLogger(UnitDaoImpl.class);

	@Resource
	private DataSource dataSource;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;
	@Override
	public UnitResultBean selectivity() throws Exception {
		List<SelectivityBean> selectivity = new ArrayList<SelectivityBean>();
		UnitResultBean resultbean = new UnitResultBean();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			selectivity = jdbcTemplate.query(UnitQueryutil.Selectivity_bean, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			resultbean.setSelectivitybean(selectivity);
			
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in selectivity", e);
		}
		
		
		return resultbean;
	}
	@Override
	public List<UnitBean> getList() {

		List<UnitBean> list = new ArrayList<UnitBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(UnitQueryutil.list,
					new BeanPropertyRowMapper<UnitBean>(
							UnitBean.class));

		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in list", e);
		}

		return list;
	}

	@Override
	public Object save(UnitBean bean)throws CustomException {

		Integer save = null;
		String bool;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String count;
		UnitBean beanlog = new UnitBean();
		
		try {
			bean.setTableName("unit");
			bean.setFormCode("F5600");
			
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(bean.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}		
			
			
			int count1=jdbcTemplate.queryForObject(UnitQueryutil. count1,Integer.class);
			//INSERT INTO unit(unt_id,unt_cd, unt_nam, md_id, dscrptn_vc, crtd_by, crtd_dt,mdfd_by, mdfd_dt,actv_bt)VALUES (?,?, ?, ?,?, ?,now(),?,now(),pg_catalog.bit(?))";
			save = jdbcTemplate.update(UnitQueryutil.save, new Object[] {count1,bean.getCode(),bean.getName(),bean.getMode(),bean.getDescription(),userDetails.getUserId(),userDetails.getUserId(),bool});				
			
				
				
			userlogDao.userLogForInsert(bean, count1 + "", userDetails.getUserId()); 
			
			/*}else{
				throw new CustomException("NAME ALREADY EXISTS");
			}
			*/
			
			
		} catch (Exception e) {
			LOGGER.error("Error in save", e);
			/*e.printStackTrace();*/

		}	
		
		return save;
	}

	@Override
	public UnitBean edit(int rowid) throws Exception {

		UnitBean editbean = new UnitBean();
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Object[] params = new Object[] { rowid };
			editbean = jdbcTemplate.queryForObject(UnitQueryutil.edit,new Object[]{rowid}, new BeanPropertyRowMapper<UnitBean>(UnitBean.class));
			
		}catch(Exception e){
		/*	e.printStackTrace();*/
			LOGGER.error("Error in edit", e);
		}
		return editbean;
	}

	@Override
	public boolean update(UnitBean update) throws Exception {



		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String bool;
		Integer update1 = null; 
		boolean issucces = false;
		
		UnitBean oldbeanlog = edit(update.getUnitid());
		
		
		try{
			update.setTableName("unit");
			update.setFormCode("F5600");
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			if(update.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}
			//UPDATE unit SET unt_cd=?, unt_nam=?,md_id=?, dscrptn_vc=?,mdfd_by=?, mdfd_dt=now(),actv_bt=pg_catalog.bit(?) where unt_id =?
			update1 = jdbcTemplate.update(UnitQueryutil.update, new Object[] {update.getCode(),update.getName(),update.getMode(),update.getDescription(),userDetails.getUserId(),bool,update.getUnitid()});
			userlogDao.userLogForUpdate(oldbeanlog,update,update.getUnitid() + "",userId);
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
		UnitBean beanlog = edit(rowid);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			beanlog.setTableName("unit");
			beanlog.setFormCode("F5600");	
			UnitBean oldbeanlog = edit(rowid);
			value = jdbcTemplate.update(UnitQueryutil.delete,rowid);
			userlogDao.userLogForDelete(beanlog, rowid + "", userDetails.getUserId());			
			issucces = true;
		}catch(Exception e){
			LOGGER.error("Error in delete", e);
			/*e.printStackTrace();*/
		}
		
		return issucces;
	}

}
