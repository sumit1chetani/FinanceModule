package com.dci.tenant.master.terms;
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
public class TermsDaoImpl implements TermsDao {

	private final static Logger LOGGER = Logger.getLogger(TermsDaoImpl.class);

	@Resource
	private DataSource dataSource;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;
	@Override
	public TermsResultBean selectivity() throws Exception {
		List<SelectivityBean> selectivity = new ArrayList<SelectivityBean>();
		TermsResultBean resultbean = new TermsResultBean();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			selectivity = jdbcTemplate.query(TermsQueryutil.Selectivity_bean, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			resultbean.setSelectivitybean(selectivity);
			
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in selectivity", e);
		}
		
		
		return resultbean;
	}
	@Override
	public List<TermsBean> getList() {

		List<TermsBean> list = new ArrayList<TermsBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(TermsQueryutil.list,
					new BeanPropertyRowMapper<TermsBean>(
							TermsBean.class));

		} catch (Exception e) {
			LOGGER.error("Error in list", e);
			/*e.printStackTrace();*/
		}

		return list;
	}

	@Override
	public Object save(TermsBean bean)throws CustomException {

		Integer save = null;
		String bool,bool1;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String count;
		TermsBean beanlog = new TermsBean();
		
		try {
			bean.setTableName("terms");
			bean.setFormCode("F5599");
			
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(bean.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}		
			
			
			
			int count1=jdbcTemplate.queryForObject(TermsQueryutil. count1,Integer.class);

			//insert into terms(trm_id,trm_cd,trm_nam,dscrptn_vc, crtd_by, crtd_dt,mdfd_by, mdfd_dt,actv_bt) values (?,?,?,?,?,now(),?,now(),pg_catalog.bit(?)) 
		
			save = jdbcTemplate.update(TermsQueryutil.save, new Object[] {count1,bean.getCode(),bean.getName(),bean.getDescription(),userDetails.getUserId(),userDetails.getUserId(),bool});				
			
				
				
			userlogDao.userLogForInsert(bean, count1 + "", userDetails.getUserId()); 
			
			/*}else{
				throw new CustomException("NAME ALREADY EXISTS");
			}
			*/
			
			
		} catch (Exception e) {
			LOGGER.error("Error in save", e);
/*
			e.printStackTrace();*/

		}	
		
		return save;
	}

	@Override
	public TermsBean edit(int rowid) throws Exception {

		TermsBean editbean = new TermsBean();
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Object[] params = new Object[] { rowid };
			editbean = jdbcTemplate.queryForObject(TermsQueryutil.edit,new Object[]{rowid}, new BeanPropertyRowMapper<TermsBean>(TermsBean.class));
			
		}catch(Exception e){
			LOGGER.error("Error in edit", e);
			/*e.printStackTrace();*/
		}
		return editbean;
	}

	@Override
	public boolean update(TermsBean update) throws Exception {



		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String bool,bool1;
		Integer update1 = null; 
		boolean issucces = false;
		
		TermsBean oldbeanlog = edit(update.getTermid());
		
		
		try{
			update.setTableName("terms");
			update.setFormCode("F5599");
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			if(update.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}
			
		

			//update container_size_type set cntnr_sz_typ_cd=?,cntnr_sz_typ_nam=?,dscrptn_vc=?,mdfd_by=?, mdfd_dt=now(),actv_bt=pg_catalog.bit(?) where cntnr_sz_typ_id =?
			update1 = jdbcTemplate.update(TermsQueryutil.update, new Object[] {update.getCode(),update.getName(),update.getDescription(),userDetails.getUserId(),bool,update.getTermid()});
			userlogDao.userLogForUpdate(oldbeanlog,update,update.getTermid() + "",userId);
			issucces = true;
			
		}catch(Exception e){
			LOGGER.error("Error in update", e);
			/*e.printStackTrace();*/
		}
		
		return issucces;
	}

	@Override
	public boolean delete(int rowid) throws Exception {

		boolean issucces = false;
		int value= 0;		
		TermsBean beanlog = edit(rowid);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			beanlog.setTableName("terms");
			beanlog.setFormCode("F5599");	
			TermsBean oldbeanlog = edit(rowid);
			value = jdbcTemplate.update(TermsQueryutil.delete,rowid);
			userlogDao.userLogForDelete(beanlog, rowid + "", userDetails.getUserId());			
			issucces = true;
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in delte", e);
		}
		
		return issucces;
	}

}
