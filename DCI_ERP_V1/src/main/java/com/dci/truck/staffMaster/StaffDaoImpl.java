package com.dci.truck.staffMaster;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;


@Repository
@Transactional("tenantTransactionManager")
public class StaffDaoImpl implements StaffDao {

	@Autowired
	DataSource dataSource;

	@Override
	public StaffResultBean getemployeelist() {

		StaffResultBean resultBean = new StaffResultBean();
		List<SelectivityBean>  resultList= new ArrayList<SelectivityBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			resultList = jdbcTemplate.query(StaffQueryUtil.getemployeelist, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			resultBean.setResultList(resultList);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return resultBean;
	}

	@Override
	public StaffBean save(StaffBean bean) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		StaffBean staffbean=new StaffBean();		
		try{
			int count=jdbcTemplate.queryForObject(StaffQueryUtil.Staff_count,new Object[]{bean.getIahsempcode()},Integer.class);
			if(count==0){
				int i = jdbcTemplate.update(StaffQueryUtil.save, new Object[] {bean.getIahsempcode(),bean.getTrmsempcode()});
				staffbean.setSuccess(true);	
			}else{
				staffbean.setSuccess(false);	

			}
		
			
		}catch(Exception e){
			e.printStackTrace();
			staffbean.setSuccess(false);

		}
		
		return staffbean;
	}

	@Override
	public List<StaffBean> getList() {
		List<StaffBean> list = new ArrayList<StaffBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(StaffQueryUtil.list,
					new BeanPropertyRowMapper<StaffBean>(
							StaffBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean deleteStaff(String staffId) {
		boolean isDeleted = false;
	
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(StaffQueryUtil.DELETE_Staff, staffId);

			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	




}
