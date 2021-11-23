package com.dci.tenant.finance.subgroupaccount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.tenant.finance.accounthead.AccountHeadMasterQueryUtil;

@Repository
public class SubGroupAccountDAOImpl implements SubGroupAccountDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(SubGroupAccountDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public SubGroupAccountResultListBean getGrpHeadDrpDwn() throws CustomException {
		// TODO Auto-generated method stub
		SubGroupAccountResultListBean resultBean = new SubGroupAccountResultListBean();
		List<SubGroupAccountBean> grpHeadList = new ArrayList<>();
		try {
			grpHeadList = jdbcTemplate.query(SubGroupAccountQueryUtil.grpHeadDrpDwn, new BeanPropertyRowMapper<>(SubGroupAccountBean.class));
			resultBean.setObjGrpHeadBeanBean(grpHeadList);
			resultBean.setMessage("success");
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Bank Account List", e);
			resultBean.setMessage("failure");
		}
		return resultBean;
	}

	@Override
	public boolean addSubGroupAccount(SubGroupAccountBean objSubGroupAccountBean, String userId) throws CustomException {
		// TODO Auto-generated method stub
		boolean isAdded = false;
		try {

			Calendar calendar = Calendar.getInstance();
			java.sql.Date currentDate = new java.sql.Date(calendar.getTime().getTime());
			int count = jdbcTemplate.queryForObject(SubGroupAccountQueryUtil.sAddSubGroupDuplicateCount, Integer.class, objSubGroupAccountBean.getSubGroupName().trim().toUpperCase());
			if (count == 0) {
				int save = jdbcTemplate.update(SubGroupAccountQueryUtil.sAddSubGroup, new Object[] { objSubGroupAccountBean.getSubHeadCode(), objSubGroupAccountBean.getSubGroupCode(), objSubGroupAccountBean.getSubGroupName(), objSubGroupAccountBean.getGrpHeadCode(), objSubGroupAccountBean.getSubGroupDesc(), "E001", currentDate, objSubGroupAccountBean.getSgType() });
				if (save > 0)
					isAdded = true;
			} else {
				isAdded = false;

			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Add Sub Group Account Master", e);
			throw new CustomException("Error in Add Group Head Master");
		}
		return isAdded;

	}

	@Override
	public List<SubGroupAccountBean> getSubGroupAccountList(int limit, int offset) throws CustomException {
		// TODO Auto-generated method stub
		List<SubGroupAccountBean> subGrpAcctBean = new ArrayList<>();
		BigDecimal subGrpCode;
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(SubGroupAccountQueryUtil.sGetSubGroup);
			for (Map row : rows) {
				SubGroupAccountBean bean = new SubGroupAccountBean();
				bean.setSubGroupCode(row.get("subGroupCode").toString());
				bean.setSubGroupName((String) row.get("subGroupName"));
				bean.setSubGroupDesc((String) row.get("subGroupDesc"));
				bean.setSubHeadCode((String) row.get("subHeadCode"));
				String accCode = (String) row.get("grpHeadCode");
				if (accCode.equalsIgnoreCase("A")) {
					accCode = "Asset";
				} else if (accCode.equalsIgnoreCase("L")) {
					accCode = "Liability";
				} else if (accCode.equalsIgnoreCase("I")) {
					accCode = "Income";
				} else if (accCode.equalsIgnoreCase("E")) {
					accCode = "Expense";
				}
				bean.setGrpHeadCode(accCode);
				subGrpAcctBean.add(bean);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Group Head Master", e);
			throw new CustomException("Error in Get Group Head Master");
		}
		return subGrpAcctBean;
	}

	@Override
	public boolean updateSubGroupAccount(SubGroupAccountBean objSubGroupAccountBean, String userId) throws CustomException {

		boolean isAdded = false;
		try {

		//	int i = jdbcTemplate.update(SubGroupAccountQueryUtil.sUpdateSubGroup, new Object[] { objSubGroupAccountBean.getSubGroupName(), objSubGroupAccountBean.getGrpHeadCode(), objSubGroupAccountBean.getSubGroupDesc(), userId, objSubGroupAccountBean.getSgType(), objSubGroupAccountBean.getSubGroupCode(), objSubGroupAccountBean.getSubHeadCode() });
			int i = jdbcTemplate.update(SubGroupAccountQueryUtil.sUpdateSubGroup, new Object[] { objSubGroupAccountBean.getSubGroupName(), objSubGroupAccountBean.getGrpHeadCode(), objSubGroupAccountBean.getSubGroupDesc(), userId, objSubGroupAccountBean.getSgType(), objSubGroupAccountBean.getSubHeadCode(), objSubGroupAccountBean.getSubGroupCode() });
			System.out.println(" query = "+SubGroupAccountQueryUtil.sUpdateSubGroup);
			System.out.println(" values = "+objSubGroupAccountBean.getSubGroupName()+"-"+objSubGroupAccountBean.getGrpHeadCode()+"-"+objSubGroupAccountBean.getSubGroupDesc()+"-"+ userId+"-date-"+objSubGroupAccountBean.getSgType()+"-"+objSubGroupAccountBean.getSubHeadCode()+"-"+objSubGroupAccountBean.getSubGroupCode());
			if (i > 0)
				isAdded = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Update Group Head Master", e);
			throw new CustomException("Error in Update Group Head Master");
		}
		return isAdded;

	}

	@Override
	public boolean deleteSubGroupAccount(String subGroupHeadCode) throws CustomException {
		boolean isDeleted = false;

		try {
			int del = jdbcTemplate.update(SubGroupAccountQueryUtil.sDeleteSubGroup, subGroupHeadCode);
			if (del > 0)
				isDeleted = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete Group Head Master", e);
			throw new CustomException("Error in Delete Group Head Master");
		}

		return isDeleted;

	}

	@SuppressWarnings("deprecation")
	@Override
	public String getSubGroupCode(String grpHeadCode, String subGrpHeadCode) throws CustomException {
		// TODO Auto-generated method stub
		String subGrpAcctCode = "";
		try {
			subGrpAcctCode = jdbcTemplate.queryForObject(SubGroupAccountQueryUtil.sGetSubGroupCode, new Object[] { subGrpHeadCode, grpHeadCode }, String.class);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Group Head Code", e);
			throw new CustomException("Error in Get Group Head Code");
		}
		return subGrpAcctCode;
	}

	@Override
	public SubGroupAccountBean getSubGroupAccountEditData(String subGroupHeadCode) throws CustomException {
		// TODO Auto-generated method stub
		SubGroupAccountBean subGrpAcctBean = new SubGroupAccountBean();
		try {
			subGrpAcctBean = jdbcTemplate.queryForObject(SubGroupAccountQueryUtil.sGetSubGroupAcctEdit, new Object[] { subGroupHeadCode }, new BeanPropertyRowMapper<>(SubGroupAccountBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Group Head Master", e);
			throw new CustomException("Error in Get Group Head Master");
		}
		return subGrpAcctBean;
	}

	@Override
	public SubGroupAccountResultListBean getvalidate(String subGroupName, boolean edit, String subGroupCode) {
		SubGroupAccountResultListBean resultBean = new SubGroupAccountResultListBean();
		List<SubGroupAccountBean> acctHeadlist = new ArrayList<>();
		try {
			String Str = "";
			if (edit == true) {

				acctHeadlist = jdbcTemplate.query(SubGroupAccountQueryUtil.validatehead, new BeanPropertyRowMapper<>(SubGroupAccountBean.class));

				for (SubGroupAccountBean bean : acctHeadlist) {
					if (subGroupName.equals(bean.getSubGroupName())) {
						Str = "success";
					}
				}
				if (Str.equals("success")) {
					int count = jdbcTemplate.queryForObject(AccountHeadMasterQueryUtil.count, new Object[] { subGroupName, subGroupCode }, Integer.class);
					if (count > 0) {
						resultBean.setMessage("success");

					}
				}

			} else {
				acctHeadlist = jdbcTemplate.query(SubGroupAccountQueryUtil.validatehead, new BeanPropertyRowMapper<>(SubGroupAccountBean.class));

				for (SubGroupAccountBean bean : acctHeadlist) {
					if (subGroupName.equals(bean.getSubGroupName())) {
						resultBean.setMessage("success");
					}
				}
			}
		} catch (Exception e1) {
			LOGGER.error("Error in ", e1);
			resultBean.setMessage("failure");
		}
		return resultBean;
	}

	@Override
	public SubGroupAccountResultListBean getsubGrpHdDrpDwn(String groupCode) {
		// TODO Auto-generated method stub
		SubGroupAccountResultListBean resultBean = new SubGroupAccountResultListBean();
		List<SubGroupAccountBean> subHeadGrpList = new ArrayList<>();
		try {
			subHeadGrpList = jdbcTemplate.query(SubGroupAccountQueryUtil.subHeadGrpList, new Object[] { groupCode }, new BeanPropertyRowMapper<>(SubGroupAccountBean.class));
			resultBean.setSubHeadGrpList(subHeadGrpList);
			resultBean.setMessage("success");
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Bank Account List", e);
			resultBean.setMessage("failure");
		}
		return resultBean;
	}
}
