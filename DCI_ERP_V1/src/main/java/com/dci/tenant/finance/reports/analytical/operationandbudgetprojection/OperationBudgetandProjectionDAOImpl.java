package com.dci.tenant.finance.reports.analytical.operationandbudgetprojection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;

@Repository
@Transactional("tenantTransactionManager")
public class OperationBudgetandProjectionDAOImpl implements OperationBudgetandProjectionDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(OperationBudgetandProjectionDAOImpl.class);

	@Resource
	 private DataSource dataSource;

	@Override
	public OperationBudgetandProjectionResultBean getvessel() throws Exception {
		OperationBudgetandProjectionResultBean resultBean = new OperationBudgetandProjectionResultBean();
		List<SelectivityBean> vesselList = new ArrayList<SelectivityBean>();
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			vesselList = jdbcTemplate.query(OpeationBudgetandProjectionQueryUtil.SELECT_VESSEL, new BeanPropertyRowMapper<SelectivityBean>(
					SelectivityBean.class));
			resultBean.setVesselList(vesselList);
			resultBean.setMessage("success");
		} catch (Exception e1) {
			LOGGER.error("Error in ", e1);
			resultBean.setMessage("failure");
		}
		return resultBean;

	}

	@Override
	public OperationBudgetandProjectionResultBean getvoyage(String vesselCode) throws Exception {
		OperationBudgetandProjectionResultBean resultBean = new OperationBudgetandProjectionResultBean();
		List<SelectivityBean> voyageList = new ArrayList<SelectivityBean>();
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			voyageList = jdbcTemplate.query(OpeationBudgetandProjectionQueryUtil.SELECT_VOYAGE, new BeanPropertyRowMapper<SelectivityBean>(
					SelectivityBean.class), new Object[] { vesselCode });
			resultBean.setVoyageList(voyageList);
			resultBean.setMessage("success");
		} catch (Exception e1) {
			LOGGER.error("Error in ", e1);
			resultBean.setMessage("failure");
		}
		return resultBean;
	}

	@Override
	public OperationBudgetandProjectionResultBean getSectorList() throws Exception {
		OperationBudgetandProjectionResultBean resultBean = new OperationBudgetandProjectionResultBean();
		List<SelectivityBean> sectorList = new ArrayList<SelectivityBean>();
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			sectorList = jdbcTemplate.query(OpeationBudgetandProjectionQueryUtil.SELECT_SECTOR, new BeanPropertyRowMapper<SelectivityBean>(
					SelectivityBean.class));
			resultBean.setSectorList(sectorList);
			resultBean.setMessage("success");
		} catch (Exception e1) {
			LOGGER.error("Error in ", e1);
			resultBean.setMessage("failure");
		}
		return resultBean;
	}

	@Override
	public OperationBudgetandProjectionResultBean getSectorCode(String voyageId) throws Exception {
		OperationBudgetandProjectionResultBean resultBean = new OperationBudgetandProjectionResultBean();
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sectorCode = null;
		try {
			sectorCode = jdbcTemplate
					.queryForObject(OpeationBudgetandProjectionQueryUtil.SELECT_SECTOR_CODE, String.class, new Object[] { voyageId });
			resultBean.getOperationBudget().setSectorCode(sectorCode);
			resultBean.setMessage("success");
		} catch (Exception e1) {
			LOGGER.error("Error in ", e1);
			resultBean.setMessage("failure");
		}
		return resultBean;
	}

	@Override
	public boolean insertOperationbudjet(OperationBudgetandProjectionBean operationBudjectProject) throws SQLException {
		String operationBudgetNo = getOperationBudgetId();
		boolean isSuccess = false;
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			int iSave = jdbcTemplate.update(
					OpeationBudgetandProjectionQueryUtil.INSERT_OPERATION_BUDGET_PROJ,
					new Object[] { operationBudgetNo, operationBudjectProject.getFromDate(), operationBudjectProject.getToDate(),
							operationBudjectProject.getCostCentre(), operationBudjectProject.getAccountHead(),
							operationBudjectProject.getcYearVolumeExpectation(), null, null, null,
							operationBudjectProject.getcYearVarianceExpected(), operationBudjectProject.getpYearVarianceExpected(),
							operationBudjectProject.getcYearPerTeuCost(), operationBudjectProject.getpYearPerTeuCost(),
							operationBudjectProject.getcYearVoyageTotal(), operationBudjectProject.getpYearVoyageTotal(),
							operationBudjectProject.getcYearSectorTotal(), operationBudjectProject.getpYearSectorTotal(),
							operationBudjectProject.getcYearPeriodTotal(), operationBudjectProject.getpYearPeriodTotal(), null });
			if (iSave > 0)
				isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Operation Budget Records!", e);
		}
		return isSuccess;
	}

	private String getOperationBudgetId() throws SQLException {

		String budgetNo = "";
		try {
			String initialBudgetNo = "OBD00001";
			String budgetPrefix = "OBD";
			  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(OpeationBudgetandProjectionQueryUtil.AUTO_GEN_OPERATION_BUDGET_NO,
					new Object[] { initialBudgetNo, budgetPrefix });
			for (Map row : rows) {
				budgetNo = (String) row.get("OPERATION_BUDGET_ID");
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Generate Admin budget Number", e);
		}
		return budgetNo;
	}

	@Override
	public List<OperationBudgetandProjectionBean> getOpernBudgetHdrList(int limit, int offset) {
		List<OperationBudgetandProjectionBean> lBudgetHdrList = new ArrayList<OperationBudgetandProjectionBean>();
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {

			lBudgetHdrList = jdbcTemplate.query(OpeationBudgetandProjectionQueryUtil.GET_OPERATION_BUDGET_HDR_LIST,
					new BeanPropertyRowMapper<OperationBudgetandProjectionBean>(OperationBudgetandProjectionBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get OPERATION Budget List", e);
		}
		return lBudgetHdrList;
	}
}