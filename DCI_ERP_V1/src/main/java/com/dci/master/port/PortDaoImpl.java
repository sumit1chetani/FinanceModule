package com.dci.master.port;
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
public class PortDaoImpl implements PortDao {

	private final static Logger LOGGER = Logger.getLogger(PortDaoImpl.class);

	@Resource
	private DataSource dataSource;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;
	@Override
	public PortResultBean selectivity() throws Exception {
		List<SelectivityBen> selectivity = new ArrayList<SelectivityBen>();
		PortResultBean resultbean = new PortResultBean();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			selectivity = jdbcTemplate.query(PortQueryutil.Selectivity_bean, new BeanPropertyRowMapper<SelectivityBen>(SelectivityBen.class));
			resultbean.setSelectivitybean(selectivity);
			
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in Selectivity", e);
		}
		
		
		return resultbean;
	}
	@Override
	public List<PortBean> getList() {

		List<PortBean> list = new ArrayList<PortBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(PortQueryutil.list,
					new BeanPropertyRowMapper<PortBean>(
							PortBean.class));

		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in List", e);
		}

		return list;
	}

	@Override
	public Object save(PortBean bean)throws CustomException {

		Integer save = null;
		String bool,bool1,bool2,bool3,bool4;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String count;
		PortBean beanlog = new PortBean();
		
		try {
			bean.setTableName("Port");
			bean.setFormCode("F5089");
			
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(bean.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}	
			if(bean.getIsPort()==true){
				bool1 = "1";
			}else{
				bool1 = "0";
			}	
			if(bean.getIsDepot()==true){
				bool3 = "1";
			}else{
				bool3 = "0";
			}	
			if(bean.getIsIcd()==true){
				bool2 = "1";
			}else{
				bool2 = "0";
			}	
			if(bean.getIsLocation()==true){
				bool4 = "1";
			}else{
				bool4 = "0";
			}	
			//select count(*) from port_icd where prt_icd_cd Ilike ? and prt_icd_nam Ilike ? and cty_id  Ilike ? and dscrptn_vsc  Ilike ? and actv_bt Ilike ?
			//count = jdbcTemplate.queryForObject(PortQueryutil.duplicate,new Object[] {bean.getCode(),bean.getName(),bean.getCity(),bean.getDescription(),bean.getIsActive()},String.class);
		//if(count.equalsIgnoreCase("0")){
			//INSERT INTO port_icd(prt_icd_cd, prt_icd_nam, cty_id, dscrptn_vsc, actv_bt, crtd_by, crtd_dt,mdfd_by,mdfd_dt)VALUES (?, ?, ?,?, ?, ?,now(), ?,now());
			
			int count1=jdbcTemplate.queryForObject(PortQueryutil. count1,Integer.class);
			//public static final String save ="INSERT INTO port_icd(prt_icd_id,prt_icd_cd, prt_icd_nam, cty_id, dscrptn_vsc, actv_bt, crtd_by, crtd_dt,mdfd_by,mdfd_dt)VALUES (?,?, ?, ?,?, pg_catalog.bit(?), ?,now(), ?,now())";

			save = jdbcTemplate.update(PortQueryutil.save, new Object[] {count1,bean.getCode(),bean.getName(),bean.getCity(),bean.getDescription(),bool,bool1,bool2,bool3,bool4,userDetails.getUserId(),userDetails.getUserId()});				
			
				//	int chargeComponent = jdbcTemplate.queryForObject(PortQueryutil.SELECT_PREVIOUS_ID,Integer.class);
				
			userlogDao.userLogForInsert(bean, count1 + "", userDetails.getUserId()); 
			
			/*}else{
				throw new CustomException("NAME ALREADY EXISTS");
			}
			*/
			
			
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in Save", e);

		}	
		
		return save;
	}

	@Override
	public PortBean edit(int rowid) throws Exception {

		PortBean editbean = new PortBean();
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Object[] params = new Object[] { rowid };
			editbean = jdbcTemplate.queryForObject(PortQueryutil.edit,new Object[]{rowid}, new BeanPropertyRowMapper<PortBean>(PortBean.class));
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in Edit", e);
		}
		return editbean;
	}

	@Override
	public boolean update(PortBean update) throws Exception {



		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String bool,bool1,bool2,bool3,bool4;
		Integer update1 = null; 
		boolean issucces = false;
		
		PortBean oldbeanlog = edit(update.getPortid());
		if (oldbeanlog.getIsStstus().equalsIgnoreCase("t"))
		{
			oldbeanlog.isActive=true;
		}
		try{
			update.setTableName("Port");
			update.setFormCode("F5089");
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			if(update.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}
			if(update.getIsPort()==true){
				bool1 = "1";
			}else{
				bool1 = "0";
			}	
			if(update.getIsDepot()==true){
				bool3 = "1";
			}else{
				bool3 = "0";
			}	
			if(update.getIsIcd()==true){
				bool2 = "1";
			}else{
				bool2 = "0";
			}
			if(update.getIsLocation()==true){
				bool4 = "1";
			}else{
				bool4 = "0";
			}
			//UPDATE port_icd SET prt_icd_cd=?, prt_icd_nam=?,cty_id=?, dscrptn_vsc=?, actv_bt=?,mdfd_by=?, mdfd_dt=now() where prt_icd_id =?
			update1 = jdbcTemplate.update(PortQueryutil.update, new Object[] {update.getCode(),update.getName(),update.getCity(),update.getDescription(),bool,userDetails.getUserId(),bool1,bool2,bool3,bool4,update.getPortid()});
			userlogDao.userLogForUpdate(oldbeanlog,update,update.getPortid() + "",userId);
			issucces = true;
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in Update", e);
		}
		
		return issucces;
	}

	@Override
	public boolean delete(int rowid) throws Exception {

		boolean issucces = false;
		int value= 0;		
		PortBean beanlog = edit(rowid);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			beanlog.setTableName("Port");
			beanlog.setFormCode("F5089");	
			PortBean oldbeanlog = edit(rowid);
			value = jdbcTemplate.update(PortQueryutil.delete,rowid);
			userlogDao.userLogForDelete(beanlog, rowid + "", userDetails.getUserId());			
			issucces = true;
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in Delete", e);
		}
		
		return issucces;
	}

}
