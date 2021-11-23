package com.dci.payroll.payroll.gradepaycomponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;


@Repository
public class GradePayComponentDAOImpl implements GradePayComponentDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(GradePayComponentDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Map<String, Object>> getGradePayComponentList(Integer gradeId) throws CustomException {
		List<GradePayComponentBean> gradePayComList = new ArrayList<GradePayComponentBean>();
		try {
			// Define Arraylist
			List<Map<String, Object>> gradePayComponenetList = new ArrayList<Map<String, Object>>();
			// Define Map
			Map<String, Object> gradeComponenetMap = null;

			int tmpgradeId = gradeId;

			gradePayComList = jdbcTemplate.query(GradePayComponentQueryUtil.selectGradeComponentList, new BeanPropertyRowMapper<GradePayComponentBean>(GradePayComponentBean.class), tmpgradeId);

			String tempDate = null;
			int i = 1;

			for (GradePayComponentBean gradePayComp : gradePayComList) {

				if (tempDate == null) {

					tempDate = gradePayComp.getFromdate();
					gradeComponenetMap = new HashMap<String, Object>();
				}

				if ((tempDate).equals(gradePayComp.getFromdate())) {

					if (gradeComponenetMap.containsKey("fromdate")) {
					} else {
						gradeComponenetMap.put("fromdate", gradePayComp.getFromdate());
					}

					if (("BASIC").equals(gradePayComp.getPayComponentId()) || ("DA").equals(gradePayComp.getPayComponentId()) || ("HRA").equals(gradePayComp.getPayComponentId()) || ("MEDIC").equals(gradePayComp.getPayComponentId()) || ("CONVE").equals(gradePayComp.getPayComponentId()) || ("SPL").equals(gradePayComp.getPayComponentId()) || ("CONS").equals(gradePayComp.getPayComponentId()) ||

					("PFCOM").equals(gradePayComp.getPayComponentId()) || ("PFSEL").equals(gradePayComp.getPayComponentId()) || ("OTDED").equals(gradePayComp.getPayComponentId()) || ("OYEAR").equals(gradePayComp.getPayComponentId()) || ("GROSS").equals(gradePayComp.getPayComponentId()) || ("NET").equals(gradePayComp.getPayComponentId())) {

						gradeComponenetMap.put(gradePayComp.getPayComponentId(), gradePayComp.getAmount());
					}
					if (gradePayComList.size() == i) {
						gradePayComponenetList.add(gradeComponenetMap);
					}

					tempDate = gradePayComp.getFromdate();

				} else {

					gradePayComponenetList.add(gradeComponenetMap);
					gradeComponenetMap = new HashMap<String, Object>();

					if (("BASIC").equals(gradePayComp.getPayComponentId()) || ("DA").equals(gradePayComp.getPayComponentId()) || ("HRA").equals(gradePayComp.getPayComponentId()) || ("MEDIC").equals(gradePayComp.getPayComponentId()) || ("CONVE").equals(gradePayComp.getPayComponentId()) || ("SPL").equals(gradePayComp.getPayComponentId()) || ("CONS").equals(gradePayComp.getPayComponentId()) ||

					("PFCOM").equals(gradePayComp.getPayComponentId()) || ("PFSEL").equals(gradePayComp.getPayComponentId()) || ("OTDED").equals(gradePayComp.getPayComponentId()) || ("OYEAR").equals(gradePayComp.getPayComponentId()) || ("GROSS").equals(gradePayComp.getPayComponentId()) || ("NET").equals(gradePayComp.getPayComponentId())) {

						gradeComponenetMap.put(gradePayComp.getPayComponentId(), gradePayComp.getAmount());

					}
					tempDate = gradePayComp.getFromdate();

				}
				i++;

			}

			return gradePayComponenetList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getGradePayComponentList ", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<GradePayComponentBean> getListByIdDate(Integer gradeId, String fromDate) throws CustomException {
		List<GradePayComponentBean> gradePayComList = new ArrayList<GradePayComponentBean>();
		try {
			gradePayComList = jdbcTemplate.query(GradePayComponentQueryUtil.sGradePayCombyIdDate, new BeanPropertyRowMapper<GradePayComponentBean>(GradePayComponentBean.class), gradeId, fromDate, gradeId);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getListByIdDate List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return gradePayComList;
	}

	@Override
	public boolean insertGradePayComponent(ArrayList<GradePayComponentBean> gradePayComBean) throws CustomException {
		boolean isSuccess = false;
		try {
			Map<String, Object> gradePayComMap = null;
			for (GradePayComponentBean gradebean : gradePayComBean) {

				gradePayComMap = new HashMap<String, Object>();
				gradePayComMap.put("gradeId", gradebean.getGradeId());
				gradePayComMap.put("fromDate", gradebean.getFromdate());
				gradePayComMap.put("payComponentId", gradebean.getPayComponentId());
				gradePayComMap.put("amount", gradebean.getAmount());
				namedParameterJdbcTemplate.update(GradePayComponentQueryUtil.insertGradePayCom, gradePayComMap);
			}

			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertGradePayComponent", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;
	}

	@Override
	public GradePayComponentBean getGradeMaxDate(Integer gradeId) throws CustomException {
		GradePayComponentBean gradePayComponentBean = new GradePayComponentBean();
		try {
			gradePayComponentBean = jdbcTemplate.queryForObject(GradePayComponentQueryUtil.getMaxFromDate, new Object[] { gradeId }, new BeanPropertyRowMapper<GradePayComponentBean>(GradePayComponentBean.class));

		} catch (DataAccessException e) {

			gradePayComponentBean = null;
			return gradePayComponentBean;
		}
		// TODO Auto-generated method stub
		return gradePayComponentBean;
	}

	@Override
	public boolean updateGradePayComponent(ArrayList<GradePayComponentBean> gradePayComBean) throws CustomException {
		boolean isSuccess = false;
		List<GradePayComponentBean> gradePayComList = new ArrayList<GradePayComponentBean>();
		try {
			Map<String, Object> gradePayComMap = null;

			for (GradePayComponentBean gradebean : gradePayComBean) {
				gradePayComMap = new HashMap<String, Object>();
				gradePayComMap.put("gradeId", gradebean.getGradeId());
				gradePayComMap.put("fromDate", gradebean.getFromdate());
				gradePayComMap.put("payComponentId", gradebean.getPayComponentId());
				gradePayComMap.put("amount", gradebean.getAmount());
				gradePayComList = jdbcTemplate.query(GradePayComponentQueryUtil.checkGradePayCom, new BeanPropertyRowMapper<GradePayComponentBean>(GradePayComponentBean.class), gradebean.getPayComponentId(), gradebean.getFromdate(), gradebean.getGradeId());
				if (gradePayComList.size() == 0) {
					if (gradebean.getAmount() > 0) {
						namedParameterJdbcTemplate.update(GradePayComponentQueryUtil.insertGradePayCom, gradePayComMap);
					}

				} else {
					if (gradebean.getAmount() > 0) {
						namedParameterJdbcTemplate.update(GradePayComponentQueryUtil.updateGradePayCom, gradePayComMap);
					} else {
						if (gradebean.getAmount() <= 0) {
							jdbcTemplate.update(GradePayComponentQueryUtil.deleteGradePayComByID, gradebean.getGradeId(), gradebean.getFromdate(), gradebean.getPayComponentId());
						}
					}
				}
				isSuccess = true;

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in updateGradePayComponent", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;
	}

	@Override
	public boolean deleteGradePayComponenet(Integer gradeId, String fromDate) throws CustomException {
		boolean isSuccess = false;
		int val = 1;
		try {
			val = jdbcTemplate.update(GradePayComponentQueryUtil.deleteGradePayCom, gradeId, fromDate);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteGradePayComponenet", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public List<GradePayComponentBean> getGradeList(String companyId) throws CustomException {
		List<GradePayComponentBean> gradeList = new ArrayList<GradePayComponentBean>();
		try {

			gradeList = jdbcTemplate.query(GradePayComponentQueryUtil.selectGradeList, new BeanPropertyRowMapper<GradePayComponentBean>(GradePayComponentBean.class), companyId);
		} catch (DataAccessException e) {
			LOGGER.error("Error in checkSalaryFixed", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return gradeList;

	}

	@Override
	public List<GradePayComponentBean> checkEmployeeExists(String fromdate, Integer gradeId) throws CustomException {

		List<GradePayComponentBean> gradeList = new ArrayList<GradePayComponentBean>();
		try {

			gradeList = jdbcTemplate.query(GradePayComponentQueryUtil.checkGradeList, new BeanPropertyRowMapper<GradePayComponentBean>(GradePayComponentBean.class), fromdate, gradeId);

		} catch (DataAccessException e) {
			LOGGER.error("Error in checkSalaryFixed", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return gradeList;

	}

	@Override
	public boolean insertGrdePayComponent(String fromdate, Integer gradeId) throws CustomException {
		boolean isSuccess = false;
		try {

			jdbcTemplate.update(GradePayComponentQueryUtil.insertGradeList, new Object[] { gradeId, gradeId, fromdate });

			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in checkSalaryFixed", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return isSuccess;

	}

}