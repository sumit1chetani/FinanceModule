package com.dci.finance.managestore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.user.UserDetail;

@Repository
public class ManageStoresDAOImpl implements ManageStoresDAO {

	int locationId = 0;

	private final static Logger LOGGER = LoggerFactory.getLogger(ManageStoresDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<ManageStoresBean> getManageStoresList() throws CustomException {
		List<ManageStoresBean> manageStoresList = new ArrayList<ManageStoresBean>();
		try {
			manageStoresList = jdbcTemplate.query(ManageStoresQueryUtil.get_ManageStores_List, new BeanPropertyRowMapper<ManageStoresBean>(ManageStoresBean.class));
			return manageStoresList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getManageStoresList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public void saveManageStoresList(ManageStoresBean manageStoresBean) throws CustomException {

		String type = "MS";
		int citId = 0, locId = 0, id = 0, parId = 0;
		String parentCategory = "", parentId = null;

		try {

			if (!manageStoresBean.getCityId().equalsIgnoreCase("")) {
				citId = Integer.parseInt(manageStoresBean.getCityId());
			} else {
				citId = 0;
			}

			if (manageStoresBean.getPid() != "" && manageStoresBean.getPid() != null) {
				parentCategory = manageStoresBean.getPid();
			} else {
				parentCategory = null;
			}

			if (!manageStoresBean.getLid().equalsIgnoreCase("")) {
				locId = Integer.parseInt(manageStoresBean.getLid());
			} else {
				locId = 0;
			}

			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();

			boolean status = false;
			if (manageStoresBean.getIsActive().equals("t")) {
				status = true;
			}
			boolean stoloc = false;
			if (manageStoresBean.getStockLocation().equals("t")) {
				stoloc = true;
			}
			boolean scrloc = false;
			if (manageStoresBean.getScrapLocation().equals("t")) {
				scrloc = true;
			}

			boolean parentAddress = false;
			if (manageStoresBean.getIsParentAddress().equals("t")) {
				parentAddress = true;
			}

			id = jdbcTemplate.queryForObject(ManageStoresQueryUtil.add_ManageStoresaddress_Data, Integer.class,citId, manageStoresBean.getAddress(), userId);

			if (parentCategory != null) {
				jdbcTemplate.update(ManageStoresQueryUtil.add_ManageStores_Data, manageStoresBean.getManageName(), Integer.parseInt(manageStoresBean.getPid()), locId, id, manageStoresBean.getEmpId(), manageStoresBean.getLocationActivity(), scrloc, stoloc, status, userId, type, parentAddress);
			} else {
				jdbcTemplate.update(ManageStoresQueryUtil.add_ManageStores_Data, manageStoresBean.getManageName(), parentId, locId, id, manageStoresBean.getEmpId(), manageStoresBean.getLocationActivity(), scrloc, stoloc, status, userId, type, parentAddress);
			}

		} catch (InvalidResultSetAccessException e) {
			throw new RuntimeException(e);
		} catch (DataAccessException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ManageStoresResultBean getEditList(int locNo) throws CustomException {

		ManageStoresBean manageStoresBean = new ManageStoresBean();
		ManageStoresResultBean bean = new ManageStoresResultBean();
		List<ManageStoresBean> beans = new ArrayList<ManageStoresBean>();

		try {

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ManageStoresQueryUtil.getEditList, new Object[] { locNo });

			for (Map row : rows) {

				String locationId = String.valueOf((int) row.get("locationId"));
				manageStoresBean.setLocationId(locationId);
				manageStoresBean.setManageName((String) row.get("manageName"));
				String addressId = String.valueOf((int) row.get("addressId"));
				manageStoresBean.setAddressId(addressId);
				String lid = String.valueOf((int) row.get("lid"));
				manageStoresBean.setLid(lid);
				manageStoresBean.setLocationActivity((String) row.get("locationActivity"));

				String scrapLocation = String.valueOf((boolean) row.get("scrapLocation"));

				if (scrapLocation.equalsIgnoreCase("true")) {
					manageStoresBean.setScrapLocation("t");
				} else {
					manageStoresBean.setScrapLocation("N");
				}

				String isActive = String.valueOf((boolean) row.get("isActive"));

				if (isActive.equalsIgnoreCase("true")) {
					manageStoresBean.setIsActive("t");
				} else {
					manageStoresBean.setIsActive("N");
				}

				if ((int) row.get("pid") != 0) {
					String pid = String.valueOf((int) row.get("pid"));
					manageStoresBean.setPid(pid);
				} else {
					manageStoresBean.setPid("");
				}

				String isParentAddress = String.valueOf((boolean) row.get("isParentAddress"));

				if (isParentAddress.equalsIgnoreCase("true")) {
					manageStoresBean.setIsParentAddress("t");
				} else {
					manageStoresBean.setIsParentAddress("N");
				}

				manageStoresBean.setEmpId((String) row.get("locationIncharge"));
				manageStoresBean.setEdit(true);
			}

			List<Map<String, Object>> rows1 = jdbcTemplate.queryForList(ManageStoresQueryUtil.getEditAddressList, new Object[] { Integer.valueOf(manageStoresBean.getAddressId()) });

			for (Map row : rows1) {

				String cityId = String.valueOf((int) row.get("cityId"));
				manageStoresBean.setCityId(cityId);
				manageStoresBean.setCity((String) row.get("city"));
				manageStoresBean.setAddress((String) row.get("address"));

			}

			List<Map<String, Object>> rows3 = jdbcTemplate.queryForList(ManageStoresQueryUtil.getCountry, new Object[] { Integer.valueOf(manageStoresBean.getCityId()) });

			for (Map row : rows3) {

				manageStoresBean.setCountry((String) row.get("country"));
				manageStoresBean.setZipCode((String) row.get("zipCode"));
				manageStoresBean.setState((String) row.get("state"));

			}

			beans.add(manageStoresBean);
			bean.setEditList(beans);

		} catch (Exception e) {
			LOGGER.error("Error in Get Manage Stores Edit List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return bean;

	}

	public List<ManageStoresBean> getstateList(int addId) {

		List<ManageStoresBean> cityList = new ArrayList<ManageStoresBean>();
		cityList = jdbcTemplate.query(ManageStoresQueryUtil.getCityedit, new BeanPropertyRowMapper<ManageStoresBean>(ManageStoresBean.class), addId);

		return cityList;
	}

	@Override
	public void updateManageStoresList(ManageStoresBean manageStoresBean) throws CustomException {

		String type = "MS";
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		int citId = 0, parId = 0, locId = 0, id = 0;
		String parentCategory = "", parentId = null;

		try {

			if (!manageStoresBean.getCityId().equalsIgnoreCase("")) {
				citId = Integer.parseInt(manageStoresBean.getCityId());
			} else {
				citId = 0;
			}

			if (manageStoresBean.getPid() != "" && manageStoresBean.getPid() != null) {
				parentCategory = manageStoresBean.getPid();
			} else {
				parentCategory = null;
			}

			if (!manageStoresBean.getLid().equalsIgnoreCase("")) {
				locId = Integer.parseInt(manageStoresBean.getLid());
			} else {
				locId = 0;
			}

			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();

			Date udate = formatter.parse(formatter.format(new Date()));

			boolean status = false;
			if (manageStoresBean.getIsActive().equals("t")) {
				status = true;
			}

			boolean scrloc = false;
			if (manageStoresBean.getScrapLocation().equals("t")) {
				scrloc = true;
			}

			boolean parentAddress = false;
			if (manageStoresBean.getIsParentAddress().equals("t")) {
				parentAddress = true;
			}

			id = jdbcTemplate.queryForObject(ManageStoresQueryUtil.update_ManageStoresaddress_Data,Integer.class, citId, manageStoresBean.getAddress(), userId, Integer.valueOf(manageStoresBean.getAddressId()));

			if (parentCategory != null) {
				jdbcTemplate.update(ManageStoresQueryUtil.update_ManageStores_Data, Integer.valueOf(parentCategory), locId, manageStoresBean.getEmpId(), manageStoresBean.getLocationActivity(), scrloc, status, userId, udate, id, parentAddress, manageStoresBean.getManageName(), Integer.valueOf(manageStoresBean.getLocationId()));
			} else {
				jdbcTemplate.update(ManageStoresQueryUtil.update_ManageStores_Data, parentId, locId, manageStoresBean.getEmpId(), manageStoresBean.getLocationActivity(), scrloc, status, userId, udate, id, parentAddress, manageStoresBean.getManageName(), Integer.valueOf(manageStoresBean.getLocationId()));
			}

		} catch (InvalidResultSetAccessException e) {
			throw new RuntimeException(e);
		} catch (DataAccessException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean getDeleteList(String locationId) throws CustomException {

		boolean issucces = false;
		int value = 0, detailValue = 0;
		try {

			detailValue = jdbcTemplate.update(ManageStoresQueryUtil.deletePurchaseRequsitionSource, Integer.valueOf(locationId));
			detailValue = jdbcTemplate.update(ManageStoresQueryUtil.deletePurchaseRequsitionDestination, Integer.valueOf(locationId));

			value = jdbcTemplate.update(ManageStoresQueryUtil.delete_ManageStores_data, Integer.valueOf(locationId));

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ManageStoresQueryUtil.getAddressId, new Object[] { Integer.valueOf(locationId) });

			for (Map row : rows) {
				detailValue = jdbcTemplate.update(ManageStoresQueryUtil.delete_ManageStoresaddress_data, (int) row.get("address_id"));
			}

			if (value != 0) {
				issucces = true;
			}
		} catch (Exception e) {
			LOGGER.error("Error in Delete", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		return issucces;
	}

	@Override
	public ManageStoresResultBean getparentlocationList() throws Exception {

		ManageStoresResultBean resultBean = new ManageStoresResultBean();
		List<ManageStoresBean> resultList = new ArrayList<ManageStoresBean>();
		try {

			resultList = jdbcTemplate.query(ManageStoresQueryUtil.get_ParentLocation, new BeanPropertyRowMapper<ManageStoresBean>(ManageStoresBean.class));
			resultBean.setparentlocationList(resultList);
			resultBean.setSuccess(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getgradeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return resultBean;
	}

	@Override
	public ManageStoresResultBean getlocationtypeList() throws Exception {

		ManageStoresResultBean resultBean = new ManageStoresResultBean();
		List<ManageStoresBean> resultList = new ArrayList<ManageStoresBean>();
		try {

			resultList = jdbcTemplate.query(ManageStoresQueryUtil.get_LocationType, new BeanPropertyRowMapper<ManageStoresBean>(ManageStoresBean.class));
			resultBean.setlocationtypeList(resultList);
			resultBean.setSuccess(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getgradeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return resultBean;
	}

	@Override
	public ManageStoresResultBean getinchargeList() throws Exception {

		ManageStoresResultBean resultBean = new ManageStoresResultBean();
		List<ManageStoresBean> resultList = new ArrayList<ManageStoresBean>();
		try {

			resultList = jdbcTemplate.query(ManageStoresQueryUtil.get_LocationInCharge, new BeanPropertyRowMapper<ManageStoresBean>(ManageStoresBean.class));
			resultBean.setinchargeList(resultList);
			resultBean.setSuccess(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getgradeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return resultBean;
	}

	@Override
	public ManageStoresResultBean getstatelist(String cityId) throws Exception {
		ManageStoresResultBean resultBean = new ManageStoresResultBean();
		List<ManageStoresBean> stateList = new ArrayList<ManageStoresBean>();
		try {
			int citId = Integer.parseInt(cityId);
			stateList = jdbcTemplate.query(ManageStoresQueryUtil.getState, new BeanPropertyRowMapper<ManageStoresBean>(ManageStoresBean.class), citId);
			resultBean.setStateList(stateList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getgradeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return resultBean;

	}

	@Override
	public ManageStoresResultBean getcountrylist(String cityId) throws Exception {
		ManageStoresResultBean resultBean = new ManageStoresResultBean();
		List<ManageStoresBean> countryList = new ArrayList<ManageStoresBean>();
		try {
			int citId = Integer.parseInt(cityId);
			countryList = jdbcTemplate.query(ManageStoresQueryUtil.getCountry, new BeanPropertyRowMapper<ManageStoresBean>(ManageStoresBean.class), citId);
			resultBean.setCountryList(countryList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getgradeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return resultBean;

	}

	@Override
	public ManageStoresResultBean getcitylist() throws Exception {
		ManageStoresResultBean resultBean = new ManageStoresResultBean();
		List<ManageStoresBean> resultList = new ArrayList<ManageStoresBean>();
		try {
			resultList = jdbcTemplate.query(ManageStoresQueryUtil.getCity, new BeanPropertyRowMapper<ManageStoresBean>(ManageStoresBean.class));
			resultBean.setCityList(resultList);
			resultBean.setSuccess(true);
			return resultBean;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getgradeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

	}

	@Override
	public ManageStoresResultBean getParentAddress(int pid) throws Exception {
		ManageStoresResultBean resultBean = new ManageStoresResultBean();
		List<ManageStoresBean> parentAddressList = new ArrayList<ManageStoresBean>();
		try {
			parentAddressList = jdbcTemplate.query(ManageStoresQueryUtil.getParentAddress, new BeanPropertyRowMapper<ManageStoresBean>(ManageStoresBean.class), pid);
			resultBean.setParentAddressList(parentAddressList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Parent Address", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return resultBean;

	}

	@Override
	public int checkStoreName(String manageName) throws Exception {
		int storeId = 0;
		try {

			storeId = jdbcTemplate.queryForObject(ManageStoresQueryUtil.sCheckStoreName,Integer.class,  manageName );

		} catch (DataAccessException e) {
			LOGGER.error("Error in Check Store Name", e);
		}

		return storeId;

	}

}
