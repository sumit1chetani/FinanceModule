package com.dci.tenant.master.containersize;
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
public class ContainerSizeDaoImpl implements ContainerSizeDao {

	private final static Logger LOGGER = Logger.getLogger(ContainerSizeDaoImpl.class);

	@Resource
	private DataSource dataSource;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;
	@Override
	public ContainerSizeResultBean selectivity() throws Exception {
		List<SelectivityBean> selectivity = new ArrayList<SelectivityBean>();
		ContainerSizeResultBean resultbean = new ContainerSizeResultBean();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			selectivity = jdbcTemplate.query(ContainerSizeQueryutil.Selectivity_bean, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			resultbean.setSelectivitybean(selectivity);
			
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in Selectivity", e);
		}
		
		
		return resultbean;
	}
	@Override
	public List<ContainerSizeBean> getList() {

		List<ContainerSizeBean> list = new ArrayList<ContainerSizeBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(ContainerSizeQueryutil.list,
					new BeanPropertyRowMapper<ContainerSizeBean>(
							ContainerSizeBean.class));

		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in list", e);
		}

		return list;
	}

	@Override
	public Object save(ContainerSizeBean bean)throws CustomException {

		Integer save = null;
		String bool,bool1;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String count;
		ContainerSizeBean beanlog = new ContainerSizeBean();
		
		try {
			bean.setTableName("container_size_type");
			bean.setFormCode("F5594");
			
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(bean.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}		
			
			
			
			int count1=jdbcTemplate.queryForObject(ContainerSizeQueryutil. count1,Integer.class);

			//insert into container_size_type(cntnr_sz_typ_id,cntnr_sz_typ_cd,cntnr_sz_typ_nam,dscrptn_vc, crtd_by, crtd_dt,mdfd_by, mdfd_dt,actv_bt) values (?,?,?,?,?,now(),?,now(),pg_catalog.bit(?)) 
		
			save = jdbcTemplate.update(ContainerSizeQueryutil.save, new Object[] {count1,bean.getCode(),bean.getName(),bean.getDescription(),userDetails.getUserId(),userDetails.getUserId(),bool});				
			
				
				
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
	public ContainerSizeBean edit(int rowid) throws Exception {

		ContainerSizeBean editbean = new ContainerSizeBean();
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Object[] params = new Object[] { rowid };
			editbean = jdbcTemplate.queryForObject(ContainerSizeQueryutil.edit,new Object[]{rowid}, new BeanPropertyRowMapper<ContainerSizeBean>(ContainerSizeBean.class));
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in edit", e);
		}
		return editbean;
	}

	@Override
	public boolean update(ContainerSizeBean update) throws Exception {



		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String bool,bool1;
		Integer update1 = null; 
		boolean issucces = false;
		
		ContainerSizeBean oldbeanlog = edit(update.getContainerid());
		
		
		try{
			update.setTableName("container_size_type");
			update.setFormCode("F5594");
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			if(update.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}
			
		

			//update container_size_type set cntnr_sz_typ_cd=?,cntnr_sz_typ_nam=?,dscrptn_vc=?,mdfd_by=?, mdfd_dt=now(),actv_bt=pg_catalog.bit(?) where cntnr_sz_typ_id =?
			update1 = jdbcTemplate.update(ContainerSizeQueryutil.update, new Object[] {update.getCode(),update.getName(),update.getDescription(),userDetails.getUserId(),bool,update.getContainerid()});
			userlogDao.userLogForUpdate(oldbeanlog,update,update.getContainerid() + "",userId);
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
		ContainerSizeBean beanlog = edit(rowid);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			beanlog.setTableName("container_size_type");
			beanlog.setFormCode("F5594");	
			ContainerSizeBean oldbeanlog = edit(rowid);
			value = jdbcTemplate.update(ContainerSizeQueryutil.delete,rowid);
			userlogDao.userLogForDelete(beanlog, rowid + "", userDetails.getUserId());			
			issucces = true;
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in delete", e);
		}
		
		return issucces;
	}

}
