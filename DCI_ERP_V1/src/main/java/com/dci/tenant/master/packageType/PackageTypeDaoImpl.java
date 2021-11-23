package com.dci.tenant.master.packageType;

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
public class PackageTypeDaoImpl implements PackageTypeDao {

	private final static Logger LOGGER = Logger.getLogger(PackageTypeDaoImpl.class);

	@Resource
	private DataSource dataSource;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;
	@Override
	public PackageTypeResultBean selectivity() throws Exception {
		List<SelectivityBen> selectivity = new ArrayList<SelectivityBen>();
		PackageTypeResultBean resultbean = new PackageTypeResultBean();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			selectivity = jdbcTemplate.query(PackageTypeQueryutil.Selectivity_bean, new BeanPropertyRowMapper<SelectivityBen>(SelectivityBen.class));
			resultbean.setSelectivitybean(selectivity);
			
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in Selectivity", e);
		}
		
		
		return resultbean;
	}
	@Override
	public List<PackageTypeBean> getList() {

		List<PackageTypeBean> list = new ArrayList<PackageTypeBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(PackageTypeQueryutil.list,
					new BeanPropertyRowMapper<PackageTypeBean>(
							PackageTypeBean.class));

		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in List", e);
		}

		return list;
	}

	@Override
	public Object save(PackageTypeBean bean)throws CustomException {


		Integer save = null;
		String bool;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String count;
		PackageTypeBean beanlog = new PackageTypeBean();
		
		try {
			bean.setTableName("PackageType");
			bean.setFormCode("F5088");
			
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(bean.getIsActive()==true){
				bool ="1";
			}else{
				bool = "0";
			}		
			//select count(*) from package_type where Code Ilike ? and Name Ilike ? and packageTypeid  Ilike ? and description  Ilike ? and is_Active Ilike";

		//	count = jdbcTemplate.queryForObject(PackageTypeQueryutil.duplicate, new Object[] {bean.getCode(),bean.getName(),bean.getDescription(),bool},String.class);
		//if(count.equalsIgnoreCase("0")){\
			int count1=jdbcTemplate.queryForObject(PackageTypeQueryutil. count1,Integer.class);
			save = jdbcTemplate.update(PackageTypeQueryutil.save, new Object[] {count1,bean.getCode(),bean.getName(),bean.getDescription(),bool,userDetails.getUserId(),userDetails.getUserId()});				
			int packagetype = jdbcTemplate.queryForObject(PackageTypeQueryutil.SELECT_PREVIOUS_ID,Integer.class);
				
			userlogDao.userLogForInsert(bean, packagetype + "", userDetails.getUserId()); 
			
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
	public PackageTypeBean edit(int rowid) throws Exception {

		PackageTypeBean editbean = new PackageTypeBean();
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Object[] params = new Object[] { rowid };
			editbean = jdbcTemplate.queryForObject(PackageTypeQueryutil.edit,new Object[]{rowid}, new BeanPropertyRowMapper<PackageTypeBean>(PackageTypeBean.class));
			
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in Edit", e);
		}
		return editbean;
	}

	@Override
	public boolean update(PackageTypeBean update) throws Exception {

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String bool;
		Integer update1 = null; 
		boolean issucces = false;
		
		PackageTypeBean oldbeanlog = edit(update.getPackageTypeid());
		if (oldbeanlog.getIsStstus().equalsIgnoreCase("t"))
		{
			oldbeanlog.isActive=true;
		}
		
		try{
			update.setTableName("PackageType");
			update.setFormCode("F5088");
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			if(update.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}
			//UPDATE package_type SET pckg_cd=?, pckg_nam=?,dscrptn_vc=?,  actv_bt=?,mdfd_by=?, mdfd_dt=now() from package_type where pckg_id =?
			update1 = jdbcTemplate.update(PackageTypeQueryutil.update, new Object[] {update.getCode(),update.getName(),update.getDescription(),bool,userDetails.getUserId(),update.getPackageTypeid()});
			userlogDao.userLogForUpdate(oldbeanlog,update,update.getPackageTypeid() + "",userId);
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
		PackageTypeBean beanlog = edit(rowid);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			beanlog.setTableName("PackageType");
			beanlog.setFormCode("F5088");			
			value = jdbcTemplate.update(PackageTypeQueryutil.delete,rowid);
			userlogDao.userLogForDelete(beanlog, rowid + "", userDetails.getUserId());			
			issucces = true;
		}catch(Exception e){
			/*e.printStackTrace();*/
			LOGGER.error("Error in Delete", e);
		}
		
		return issucces;
	}

}
