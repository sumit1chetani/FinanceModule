package com.dci.finance.managelocation;

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
public class ManageLocationDAOImpl implements ManageLocationDAO {

	int locationId = 0;

	private final static Logger LOGGER = LoggerFactory.getLogger(ManageLocationDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<ManageLocationBean> getManageLocationList() throws CustomException {
		List<ManageLocationBean> manageLocationList = new ArrayList<ManageLocationBean>();
		try {
			manageLocationList = jdbcTemplate.query(ManageLocationQueryUtil.get_ManageStores_List, new BeanPropertyRowMapper<ManageLocationBean>(ManageLocationBean.class));
			return manageLocationList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getManageLocationList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public void saveManageLocationList(ManageLocationBean manageLocationBean) throws CustomException {

		String type = "LO";
		int citId = 0, parId = 0, locId = 0, id = 0;
		String parentCategory = "", parentId = null;

		try {

			if (!manageLocationBean.getCityId().equalsIgnoreCase("")) {
				citId = Integer.parseInt(manageLocationBean.getCityId());
			} else {
				citId = 0;
			}

			if (manageLocationBean.getPid() != "" && manageLocationBean.getPid() != null) {
				parentCategory = manageLocationBean.getPid();
			} else {
				parentCategory = null;
			}

			if (!manageLocationBean.getLid().equalsIgnoreCase("")) {
				locId = Integer.parseInt(manageLocationBean.getLid());
			} else {
				locId = 0;
			}

			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();

			boolean status = false;
			if (manageLocationBean.getIsActive().equals("t")) {
				status = true;
			}
			boolean stoloc = false;
			if (manageLocationBean.getStockLocation().equals("t")) {
				stoloc = true;
			}
			boolean scrloc = false;
			if (manageLocationBean.getScrapLocation().equals("t")) {
				scrloc = true;
			}

			boolean parentAddress = false;
			if (manageLocationBean.getIsParentAddress().equals("t")) {
				parentAddress = true;
			}

			id = jdbcTemplate.queryForObject(ManageLocationQueryUtil.add_ManageStoresaddress_Data,Integer.class, citId, manageLocationBean.getAddress(), userId);

			if (parentCategory != null) {
				jdbcTemplate.update(ManageLocationQueryUtil.add_ManageStores_Data, manageLocationBean.getManageName(), Integer.valueOf(parentCategory), locId, id, manageLocationBean.getEmpId(), manageLocationBean.getLocationActivity(), scrloc, stoloc, status, userId, type, parentAddress);
			} else {
				jdbcTemplate.update(ManageLocationQueryUtil.add_ManageStores_Data, manageLocationBean.getManageName(), parentId, locId, id, manageLocationBean.getEmpId(), manageLocationBean.getLocationActivity(), scrloc, stoloc, status, userId, type, parentAddress);
			}

		} catch (InvalidResultSetAccessException e) {
			throw new RuntimeException(e);
		} catch (DataAccessException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ManageLocationResultBean getEditList(int locNo) throws CustomException {

		ManageLocationBean manageLocationBean = new ManageLocationBean();
		ManageLocationResultBean bean = new ManageLocationResultBean();
		List<ManageLocationBean> beans = new ArrayList<ManageLocationBean>();

		try {

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ManageLocationQueryUtil.getEditList, new Object[] { locNo });

			for (Map row : rows) {

				String locationId = String.valueOf((int) row.get("locationId"));
				manageLocationBean.setLocationId(locationId);
				manageLocationBean.setManageName((String) row.get("manageName"));
				String addressId = String.valueOf((int) row.get("addressId"));
				manageLocationBean.setAddressId(addressId);
				String lid = String.valueOf((int) row.get("lid"));
				manageLocationBean.setLid(lid);
				manageLocationBean.setLocationActivity((String) row.get("locationActivity"));

				String scrapLocation = String.valueOf((boolean) row.get("scrapLocation"));

				if (scrapLocation.equalsIgnoreCase("true")) {
					manageLocationBean.setScrapLocation("t");
				} else {
					manageLocationBean.setScrapLocation("f");
				}

				String isActive = String.valueOf((boolean) row.get("isActive"));

				if (isActive.equalsIgnoreCase("true")) {
					manageLocationBean.setIsActive("t");
				} else {
					manageLocationBean.setIsActive("f");
				}

				if ((int) row.get("pid") != 0) {
					String pid = String.valueOf((int) row.get("pid"));
					manageLocationBean.setPid(pid);
				} else {
					manageLocationBean.setPid("");
				}

				String isParentAddress = String.valueOf((boolean) row.get("isParentAddress"));

				if (isParentAddress.equalsIgnoreCase("true")) {
					manageLocationBean.setIsParentAddress("t");
				} else {
					manageLocationBean.setIsParentAddress("N");
				}

				manageLocationBean.setEmpId((String) row.get("locationIncharge"));
				manageLocationBean.setEdit(true);
			}

			List<Map<String, Object>> rows1 = jdbcTemplate.queryForList(ManageLocationQueryUtil.getEditAddressList, new Object[] { Integer.valueOf(manageLocationBean.getAddressId()) });

			for (Map row : rows1) {

				String cityId = String.valueOf((int) row.get("cityId"));
				manageLocationBean.setCityId(cityId);
				manageLocationBean.setCity((String) row.get("city"));
				manageLocationBean.setAddress((String) row.get("address"));

			}

			List<Map<String, Object>> rows3 = jdbcTemplate.queryForList(ManageLocationQueryUtil.getCountry, new Object[] { Integer.valueOf(manageLocationBean.getCityId()) });

			for (Map row : rows3) {

				manageLocationBean.setCountry((String) row.get("country"));
				manageLocationBean.setZipCode((String) row.get("zipCode"));
				manageLocationBean.setState((String) row.get("state"));

			}

			beans.add(manageLocationBean);
			bean.setEditList(beans);

		} catch (Exception e) {
			LOGGER.error("Error in Get Manage Location Edit List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return bean;

	}

	public List<ManageLocationBean> getstateList(int addId) {

		List<ManageLocationBean> cityList = new ArrayList<ManageLocationBean>();
		cityList = jdbcTemplate.query(ManageLocationQueryUtil.getCityedit, new BeanPropertyRowMapper<ManageLocationBean>(ManageLocationBean.class), addId);

		return cityList;
	}

	@Override
	public void updateManageLocationList(ManageLocationBean manageLocationBean) throws CustomException {

		String type = "LO";
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		int citId = 0, parId = 0, locId = 0, id = 0;
		String parentCategory = "", parentId = null;

		try {

			if (!manageLocationBean.getCityId().equalsIgnoreCase("")) {
				citId = Integer.parseInt(manageLocationBean.getCityId());
			} else {
				citId = 0;
			}

			if (manageLocationBean.getPid() != "" && manageLocationBean.getPid() != null) {
				parentCategory = manageLocationBean.getPid();
			} else {
				parentCategory = null;
			}

			if (!manageLocationBean.getLid().equalsIgnoreCase("")) {
				locId = Integer.parseInt(manageLocationBean.getLid());
			} else {
				locId = 0;
			}

			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();

			Date udate = formatter.parse(formatter.format(new Date()));

			boolean status = false;
			if (manageLocationBean.getIsActive().equals("t")) {
				status = true;
			}

			boolean scrloc = false;
			if (manageLocationBean.getScrapLocation().equals("t")) {
				scrloc = true;
			}

			boolean parentAddress = false;
			if (manageLocationBean.getIsParentAddress().equals("t")) {
				parentAddress = true;
			}

			id = jdbcTemplate.queryForObject(ManageLocationQueryUtil.update_ManageStoresaddress_Data,Integer.class, citId, manageLocationBean.getAddress(), userId, Integer.valueOf(manageLocationBean.getAddressId()));

			if (parentCategory != null) {
				jdbcTemplate.update(ManageLocationQueryUtil.update_ManageStores_Data, manageLocationBean.getManageName(), Integer.valueOf(manageLocationBean.getPid()), Integer.valueOf(manageLocationBean.getLid()), manageLocationBean.getEmpId(), manageLocationBean.getLocationActivity(), scrloc, status, userId, udate, id, parentAddress, Integer.valueOf(manageLocationBean.getLocationId()));
			} else {
				jdbcTemplate.update(ManageLocationQueryUtil.update_ManageStores_Data, manageLocationBean.getManageName(), parentId, Integer.valueOf(manageLocationBean.getLid()), manageLocationBean.getEmpId(), manageLocationBean.getLocationActivity(), scrloc, status, userId, udate, id, parentAddress, Integer.valueOf(manageLocationBean.getLocationId()));
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

			detailValue = jdbcTemplate.update(ManageLocationQueryUtil.deletePurchaseRequsitionSource, Integer.valueOf(locationId));
			detailValue = jdbcTemplate.update(ManageLocationQueryUtil.deletePurchaseRequsitionDestination, Integer.valueOf(locationId));

			value = jdbcTemplate.update(ManageLocationQueryUtil.delete_ManageStores_data, Integer.valueOf(locationId));

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ManageLocationQueryUtil.getAddressId, new Object[] { Integer.valueOf(locationId) });

			for (Map row : rows) {
				detailValue = jdbcTemplate.update(ManageLocationQueryUtil.delete_ManageStoresaddress_data, (int) row.get("address_id"));
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
	public String multiDeleteValue(String userId, List<ManageLocationBean> lManageLocationBean) throws Exception {
		String succ = "", locationMessageId = "";
		int detailValue = 0, value = 0;

		try {

			for (int i = 0; i < lManageLocationBean.size(); i++) {
				ManageLocationBean manageLocationBean = lManageLocationBean.get(i);
				if (manageLocationBean.getSelect() == true) {

					detailValue = jdbcTemplate.update(ManageLocationQueryUtil.deletePurchaseRequsitionSource, Integer.valueOf(manageLocationBean.getLocationId()));
					detailValue = jdbcTemplate.update(ManageLocationQueryUtil.deletePurchaseRequsitionDestination, Integer.valueOf(manageLocationBean.getLocationId()));

					value = jdbcTemplate.update(ManageLocationQueryUtil.delete_ManageStores_data, Integer.valueOf(manageLocationBean.getLocationId()));

					List<Map<String, Object>> rows = jdbcTemplate.queryForList(ManageLocationQueryUtil.getAddressId, new Object[] { Integer.valueOf(manageLocationBean.getLocationId()) });

					for (Map row : rows) {
						detailValue = jdbcTemplate.update(ManageLocationQueryUtil.delete_ManageStoresaddress_data, (int) row.get("address_id"));
					}

					succ = "Deleted Successfully!";
				}
			}

			return succ;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Multi Delete", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
	}

	@Override
	public ManageLocationResultBean getparentlocationList() throws Exception {

		ManageLocationResultBean resultBean = new ManageLocationResultBean();
		List<ManageLocationBean> resultList = new ArrayList<ManageLocationBean>();
		try {

			resultList = jdbcTemplate.query(ManageLocationQueryUtil.get_ParentLocation, new BeanPropertyRowMapper<ManageLocationBean>(ManageLocationBean.class));
			resultBean.setparentlocationList(resultList);
			resultBean.setSuccess(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getgradeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return resultBean;
	}

	@Override
	public ManageLocationResultBean getlocationtypeList() throws Exception {

		ManageLocationResultBean resultBean = new ManageLocationResultBean();
		List<ManageLocationBean> resultList = new ArrayList<ManageLocationBean>();
		try {

			resultList = jdbcTemplate.query(ManageLocationQueryUtil.get_LocationType, new BeanPropertyRowMapper<ManageLocationBean>(ManageLocationBean.class));
			resultBean.setlocationtypeList(resultList);
			resultBean.setSuccess(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getgradeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return resultBean;
	}

	@Override
	public ManageLocationResultBean getinchargeList() throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		ManageLocationResultBean resultBean = new ManageLocationResultBean();
		List<ManageLocationBean> resultList = new ArrayList<ManageLocationBean>();
		try {

			resultList = jdbcTemplate.query(ManageLocationQueryUtil.get_LocationInCharge, new BeanPropertyRowMapper<ManageLocationBean>(ManageLocationBean.class),userDetails.getCompanyCode() );
			resultBean.setinchargeList(resultList);
			resultBean.setSuccess(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getgradeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return resultBean;
	}

	@Override
	public ManageLocationResultBean getstatelist(String cityId) throws Exception {
		ManageLocationResultBean resultBean = new ManageLocationResultBean();
		List<ManageLocationBean> stateList = new ArrayList<ManageLocationBean>();
		try {
			int citId = Integer.parseInt(cityId);
			stateList = jdbcTemplate.query(ManageLocationQueryUtil.getState, new BeanPropertyRowMapper<ManageLocationBean>(ManageLocationBean.class), citId);
			resultBean.setStateList(stateList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getgradeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return resultBean;

	}

	@Override
	public ManageLocationResultBean getcountrylist(String cityId) throws Exception {
		ManageLocationResultBean resultBean = new ManageLocationResultBean();
		List<ManageLocationBean> countryList = new ArrayList<ManageLocationBean>();
		try {
			int citId = Integer.parseInt(cityId);
			countryList = jdbcTemplate.query(ManageLocationQueryUtil.getCountry, new BeanPropertyRowMapper<ManageLocationBean>(ManageLocationBean.class), citId);
			resultBean.setCountryList(countryList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getgradeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return resultBean;

	}

	@Override
	public ManageLocationResultBean getcitylist() throws Exception {
		ManageLocationResultBean resultBean = new ManageLocationResultBean();
		List<ManageLocationBean> resultList = new ArrayList<ManageLocationBean>();
		try {
			resultList = jdbcTemplate.query(ManageLocationQueryUtil.getCity, new BeanPropertyRowMapper<ManageLocationBean>(ManageLocationBean.class));
			resultBean.setCityList(resultList);
			resultBean.setSuccess(true);
			return resultBean;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getgradeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

	}

	@Override
	public ManageLocationResultBean getParentAddress(int pid) throws Exception {
		ManageLocationResultBean resultBean = new ManageLocationResultBean();
		List<ManageLocationBean> parentAddressList = new ArrayList<ManageLocationBean>();
		try {
			parentAddressList = jdbcTemplate.query(ManageLocationQueryUtil.getParentAddress, new BeanPropertyRowMapper<ManageLocationBean>(ManageLocationBean.class), pid);
			resultBean.setParentAddressList(parentAddressList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Parent Address", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return resultBean;

	}

	@Override
	public int checkLocationName(String manageName) throws Exception {
		int locationId = 0;
		try {

			locationId = jdbcTemplate.queryForObject(ManageLocationQueryUtil.sCheckLocationName,Integer.class,  manageName);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Check Store Name", e);
		}

		return locationId;

	}

}
