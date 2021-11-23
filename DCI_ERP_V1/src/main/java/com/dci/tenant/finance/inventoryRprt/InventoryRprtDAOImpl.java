package com.dci.tenant.finance.inventoryRprt;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.tenant.user.UserDetail;

@Repository
public class InventoryRprtDAOImpl implements InventoryRprtDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(InventoryRprtDAOImpl.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<InventoryRprtBean> getInventoryMasterList(int limit, int offset) {
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<InventoryRprtBean> lInventoryBean = null;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lInventoryBean = jdbcTemplate.query(InventoryRprtQueryUtil.INV_MASTER_LIST, new BeanPropertyRowMapper<>(InventoryRprtBean.class), user.getCompanyCode());
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return lInventoryBean;

	}

	@Override
	public List<InventoryRprtDtlBean> getInventroySubList(int item, int location, String invDate) {
		List<InventoryRprtDtlBean> lInventoryBean = null;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (invDate != "") {
				lInventoryBean = jdbcTemplate.query(InventoryRprtQueryUtil.INV_SUB_LIST, new Object[] { invDate, item, location, invDate, item, location }, new BeanPropertyRowMapper<>(InventoryRprtDtlBean.class));
			} else {
				lInventoryBean = jdbcTemplate.query(InventoryRprtQueryUtil.INV_SUB_LIST1, new Object[] { item, location, item, location }, new BeanPropertyRowMapper<>(InventoryRprtDtlBean.class));
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return lInventoryBean;

	}

	@Override
	public InventroyRprtListBean getDropDowns() {
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		InventroyRprtListBean listBean = new InventroyRprtListBean();
		List<InventoryRprtBean> lItem = null;
		List<InventoryRprtBean> lLocation = null;
		List<InventoryRprtBean> lcategory = null;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lItem = jdbcTemplate.query(InventoryRprtQueryUtil.GET_ITEM_LIST, new BeanPropertyRowMapper<>(InventoryRprtBean.class), user.getCompanyCode());
			lLocation = jdbcTemplate.query(InventoryRprtQueryUtil.GET_LOCATION_LIST, new BeanPropertyRowMapper<>(InventoryRprtBean.class));
			lcategory = jdbcTemplate.query(InventoryRprtQueryUtil.GET_CATEGORY_LIST, new BeanPropertyRowMapper<>(InventoryRprtBean.class));

			listBean.setItemList(lItem);
			listBean.setLocationList(lLocation);
			listBean.setCategoryList(lcategory);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return listBean;

	}

	@Override
	public List<InventoryRprtBean> getInventroyListWithParam(int item, int location, String stockon) {
		List<InventoryRprtBean> lInventoryBean = null;
		try {

			String query = "select distinct inv.inventory_id invId,to_char(inv.inventory_date ,'dd/mm/yyyy') invDate,inv.location_id locationId,inv.item_id itemId,inv.quantity_available qty,pro.item_code item,pro.item_name itemName,pro.item_description itemDesc,loc.location_name locationName from inventory inv left join item_new pro on inv.item_id = pro.item_id left join location loc on loc.location_id = inv.location_id where pro.item_type!=18";

			if (item > 0) {
				query = query + " and  inv.item_id = " + item;
			}
			if (location > 0) {
				query = query + " and  inv.location_id = " + location;
			}

			if (stockon != null && stockon != "") {
				query = query + " and inv.inventory_date <= to_date(" + "'" + stockon + "'" + ",'dd/mm/yyyy')";
			}

			query += " order by invdate";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lInventoryBean = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(InventoryRprtBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return lInventoryBean;

	}

	@Override
	public List<InventoryRprtBean> getinvlistBelowROL() {
		List<InventoryRprtBean> lInventoryBean = null;
		try {
			lInventoryBean = jdbcTemplate.query(InventoryRprtQueryUtil.GET_INVENTORY_REPORT_LIST_BELOW_ROL, new BeanPropertyRowMapper<>(InventoryRprtBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return lInventoryBean;

	}

	@Override
	public List<InventoryRprtDtlBean> getSubGridBatchDetails(int ledgerId) {
		List<InventoryRprtDtlBean> lInventoryBean = null;
		try {
			lInventoryBean = jdbcTemplate.query(InventoryRprtQueryUtil.GET_INVENTORY_BATCH_LIST, new Object[] { ledgerId }, new BeanPropertyRowMapper<>(InventoryRprtDtlBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return lInventoryBean;

	}

	@Override
	public List<InventoryRprtBean> getInventoryNewMasterList(int limit, int offset) {

		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<InventoryRprtBean> lInventoryBean = null;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lInventoryBean = jdbcTemplate.query(InventoryRprtQueryUtil.INV_MASTER_LIST_NEW, new BeanPropertyRowMapper<>(InventoryRprtBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return lInventoryBean;

	}

	@Override
	public List<InventoryRprtBean> getInventroyNewListWithParam(String item, String location, String fromdate, String todate, String category) {
		List<InventoryRprtBean> lInventoryBean = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {

			// lInventoryBean =
			// jdbcTemplate.query(InventoryRprtQueryUtil.GET_INVENTORY_SEARCH_LIST(item,
			// location, fromdate, todate, category), new
			// BeanPropertyRowMapper<>(InventoryRprtBean.class));

			if (item == null || item.equals("null") || item == "") {
				item = null;
			} else {
				// item = "'" + item + "'";
			}
			if (location == null || location.equals("null") || location == "") {
				location = null;
			} else {
				// location = "'" + location + "'";
			}
			if (fromdate == null || fromdate.equals("null") || fromdate == "") {
				fromdate = null;
			} else {
				// fromdate = "'" + fromdate + "'";
			}
			if (todate == null || todate.equals("null") || todate == "") {
				todate = null;
			} else {
				// todate = "'" + todate + "'";
			}
			if (category == null || category.equals("null") || category == "") {
				category = null;
			} else {
				// category = "'" + category + "'";
			}
			lInventoryBean = jdbcTemplate.query(InventoryRprtQueryUtil.GET_INVENTORY_SEARCH_LIST1, new Object[] { item, fromdate, todate, category }, new BeanPropertyRowMapper<>(InventoryRprtBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return lInventoryBean;
	}

	@Override
	public List<InventoryRprtDtlBean> getInventroyNewSubList(int item, String invDate) {

		List<InventoryRprtDtlBean> lInventoryBean = null;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (invDate == null) {
				invDate = "";
			}
			lInventoryBean = jdbcTemplate.query(InventoryRprtQueryUtil.INV_NEW_SUB_LIST_NEW, new Object[] { item, invDate }, new BeanPropertyRowMapper<>(InventoryRprtDtlBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return lInventoryBean;
	}

	@Override
	public List<InventoryRprtBean> getInventroyNewListExport(String item, String location, String fromdate, String todate, String category) {
		List<InventoryRprtBean> lInventoryBean = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {

			if (item == null || item.equals("null") || item == "") {
				item = null;
			} else {
				// item = "'" + item + "'";
			}
			if (location == null || location.equals("null") || location == "") {
				location = null;
			} else {
				// location = "'" + location + "'";
			}
			if (fromdate == null || fromdate.equals("null") || fromdate == "") {
				fromdate = null;
			} else {
				// fromdate = "'" + fromdate + "'";
			}
			if (todate == null || todate.equals("null") || todate == "") {
				todate = null;
			} else {
				// todate = "'" + todate + "'";
			}
			if (category == null || category.equals("null") || category == "") {
				category = null;
			} else {
				// category = "'" + category + "'";
			}
			lInventoryBean = jdbcTemplate.query(InventoryRprtQueryUtil.GET_INVENTORY_SEARCH_LIST1, new Object[] { item, fromdate, todate, category }, new BeanPropertyRowMapper<>(InventoryRprtBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return lInventoryBean;
	}

}
