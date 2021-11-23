package com.dci.tenant.master.iata;
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
public class IataDaoImpl implements IataDao {

	private final static Logger LOGGER = Logger.getLogger(IataDaoImpl.class);

	@Resource
	private DataSource dataSource;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;
	@Override
	public IataResultBean selectivity() throws Exception {
		List<SelectivityBen> selectivity = new ArrayList<SelectivityBen>();
		IataResultBean resultbean = new IataResultBean();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			selectivity = jdbcTemplate.query(IataQueryutil.Selectivity_bean, new BeanPropertyRowMapper<SelectivityBen>(SelectivityBen.class));
			resultbean.setSelectivitybean(selectivity);
			
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in selectivity", e);
		}
		
		
		return resultbean;
	}
	@Override
	public List<IataBean> getList() {
		boolean isActive1=true;
		boolean  Status;
		List<IataBean> list = new ArrayList<IataBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(IataQueryutil.list,
					new BeanPropertyRowMapper<IataBean>(
							IataBean.class));
	
	/*	for(IataBean obj:list){
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
	public Object save(IataBean bean)throws CustomException {

		Integer save = null;
		String bool;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String count;
		IataBean beanlog = new IataBean();
		
		try {
			bean.setTableName("IATA");
			bean.setFormCode("F5084");
			
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(bean.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}	
			//select count(*) from iata where iata_cd Ilike ? and iata_nam Ilike ? and cty_id  Ilike ? and dscrptn_vc  Ilike ? and actv_bt Ilike ?
			//count = jdbcTemplate.queryForObject(IataQueryutil.duplicate,new Object[] {bean.getIataCode(),bean.getIataName(),bean.getIataCity(),bean.getDescription(),bean.getIsActive()},String.class);
			//if(count.equalsIgnoreCase("0")){
			//int count1 =	jdbcTemplate.queryForObject(IataQueryutil.duplicate,);
			int count1=jdbcTemplate.queryForObject(IataQueryutil. count1,Integer.class);
				save = jdbcTemplate.update(IataQueryutil.save, new Object[] {count1,bean.getIataCode(),bean.getIataName(),bean.getIataCity(),bean.getDescription(),bool,userDetails.getUserId(),userDetails.getUserId()});				
				//int chargeComponent = jdbcTemplate.queryForObject(IataQueryutil.SELECT_PREVIOUS_ID,Integer.class);
				
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
	public IataBean edit(int rowid) throws Exception {

		IataBean editbean = new IataBean();
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Object[] params = new Object[] { rowid };
			editbean = jdbcTemplate.queryForObject(IataQueryutil.edit,new Object[]{rowid}, new BeanPropertyRowMapper<IataBean>(IataBean.class));
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in edit", e);
		}
		return editbean;
	}

	
	@Override
	public boolean update(IataBean update) throws Exception {

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String bool;
		Integer update1 = null; 
		boolean issucces = false;
		
		IataBean oldbeanlog = edit(update.getIataid());
		
		
		try{
			update.setTableName("IATA");
			update.setFormCode("F5084");
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
		if(update.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}
			//UPDATE iata SET iata_cd=?, iata_nam=?,cty_id=?, dscrptn_vc=?, actv_bt=?,mdfd_by=?, mdfd_dt=now() where iata_id =?
			update1 = jdbcTemplate.update(IataQueryutil.update, new Object[] {update.getIataCode(),update.getIataName(),update.getIataCity(),update.getDescription(),bool,userDetails.getUserId(),update.getIataid()});
			userlogDao.userLogForUpdate(oldbeanlog,update,update.getIataid() + "",userDetails.getUserId());
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
		IataBean beanlog = edit(rowid);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			beanlog.setTableName("IATA");
			beanlog.setFormCode("F5084");	
			value = jdbcTemplate.update(IataQueryutil.delete,rowid);
		userlogDao.userLogForDelete(beanlog, rowid + "", userDetails.getUserId());			
			issucces = true;
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in delete", e);
		}
		
		return issucces;
	}

}
