package com.dci.tenant.master.country;
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
public class CountryDaoImpl implements CountryDao {

	private final static Logger LOGGER = Logger.getLogger(CountryDaoImpl.class);

	@Resource
	private DataSource dataSource;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;
	@Override
	public CountryResultBean selectivity() throws Exception {
		List<SelectivityBean> selectivity = new ArrayList<SelectivityBean>();
		CountryResultBean resultbean = new CountryResultBean();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			selectivity = jdbcTemplate.query(CountryQueryutil.Selectivity_bean, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			resultbean.setSelectivitybean(selectivity);
			
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in selectivity", e);
		}
		
		
		return resultbean;
	}
	@Override
	public List<CountryBean> getList() {

		List<CountryBean> list = new ArrayList<CountryBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(CountryQueryutil.list,
					new BeanPropertyRowMapper<CountryBean>(
							CountryBean.class));

		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in list", e);
		}

		return list;
	}

	@Override
	public Object save(CountryBean bean)throws CustomException {

		Integer save = null;
		String bool;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String count;
		CountryBean beanlog = new CountryBean();
		
		try {
			bean.setTableName("country");
			bean.setFormCode("F5595");
			
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(bean.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}		
			
			
			int count1=jdbcTemplate.queryForObject(CountryQueryutil. count1,Integer.class);
			save = jdbcTemplate.update(CountryQueryutil.save, new Object[] {count1,bean.getCode(),bean.getName(),bean.getRegion(),bean.getDescription(),userDetails.getUserId(),userDetails.getUserId(),bool});				
			
				
				
			userlogDao.userLogForInsert(bean, count1 + "", userDetails.getUserId()); 
			
			/*}else{
				throw new CustomException("NAME ALREADY EXISTS");
			}
			*/
			
			
		} catch (Exception e) {

		/*	e.printStackTrace();*/
			LOGGER.error("Error in save", e);

		}	
		
		return save;
	}

	@Override
	public CountryBean edit(int rowid) throws Exception {

		CountryBean editbean = new CountryBean();
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Object[] params = new Object[] { rowid };
			editbean = jdbcTemplate.queryForObject(CountryQueryutil.edit,new Object[]{rowid}, new BeanPropertyRowMapper<CountryBean>(CountryBean.class));
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in edit", e);
		}
		return editbean;
	}

	@Override
	public boolean update(CountryBean update) throws Exception {



		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String bool;
		Integer update1 = null; 
		boolean issucces = false;
		
		CountryBean oldbeanlog = edit(update.getCountryid());


if (oldbeanlog.getIsStstus().equalsIgnoreCase("t"))
		{
			oldbeanlog.isActive=true;
		}
		
		try{
			update.setTableName("country");
			update.setFormCode("F5595");
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			if(update.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}
			//UPDATE country SET cntry_cd=?, cntry_nam=?,rgn_id=?, dscrptn_vc=?,mdfd_by=?, mdfd_dt=now(),actv_bt=pg_catalog.bit(?) where cntry_id
			update1 = jdbcTemplate.update(CountryQueryutil.update, new Object[] {update.getCode(),update.getName(),update.getRegion(),update.getDescription(),userDetails.getUserId(),bool,update.getCountryid()});
			userlogDao.userLogForUpdate(oldbeanlog,update,update.getCountryid() + "",userId);
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
		CountryBean beanlog = edit(rowid);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			beanlog.setTableName("country");
			beanlog.setFormCode("F5595");	
			CountryBean oldbeanlog = edit(rowid);
			value = jdbcTemplate.update(CountryQueryutil.delete,rowid);
			userlogDao.userLogForDelete(beanlog, rowid + "", userDetails.getUserId());			
			issucces = true;
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in delete", e);
		}
		
		return issucces;
	}

}
