package com.dci.tenant.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.tenant.user.UserDetail;
@Repository
public class DashboardDaoImpl implements DashboardDao {
	private final static Logger LOGGER = Logger.getLogger(DashboardDaoImpl.class);

	@Autowired
	DataSource dataSource;

	@Override
	public List<DashboardlistBean> getList() {
		List<DashboardlistBean> list = new ArrayList<DashboardlistBean>();

		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(DashboardQueryUtil.list,
					new BeanPropertyRowMapper<DashboardlistBean>(DashboardlistBean.class));

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in getFormList", e);
		}

		return list;
	}


	@Override
	public DashboardResultBean getDescriptionCount(String period) {
	DashboardResultBean resultBean = new DashboardResultBean();
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<DashboardlistBean> listbean = new ArrayList<DashboardlistBean>();
		try{
			String query = "";
			if(Integer.parseInt(period)==0){
				query = " where created_date::date>=(now()-interval'0 day')::date group by description,orderby order by orderby ";
			}else if(Integer.parseInt(period)==7){
				query = " where created_date::date>=(now()-interval'7 day')::date group by description,orderby order by orderby ";
			}else if(Integer.parseInt(period)==90){
				query = " where  created_date::date >= (now()-interval'3 month')::date group by description,orderby order by orderby ";
			}else if(Integer.parseInt(period)==180){
				query = " where  created_date::date >= (now()-interval'6 month')::date group by description,orderby  order by orderby";
			}else if(Integer.parseInt(period)==365){
				query = " where extract('year' from created_date)=extract('year' from now()) group by description,orderby order by orderby";
			}
			/*listbean = jdbcTemplate.query(DashboardQueryUtil.Get_Desc_count+query,new BeanPropertyRowMapper<DashboardlistBean>(DashboardlistBean.class));
			resultBean.setDescriptionCountList(listbean);*/
	}catch(Exception e){
			e.printStackTrace();
		}
		
		return resultBean;
	}
	}
