package com.dci.tenant.finance.TDSForm;

import java.sql.Types;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;

@Repository
public class TDSFormDAOImpl implements TDSFormDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(TDSFormDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;

	@SuppressWarnings("deprecation")
	@Override
	public boolean addAcctHeadMastercom(TDSFormBean objTDSFormBean, String userId) throws CustomException {
		int val = 1;
		boolean isSuccess = false;
		String acctHeadStatus = "";
		try {

			// String subGroupCode = objTDSFormBean.getSubGroupAccountCode();

			String tdsauto = "";

			tdsauto = jdbcTemplate.queryForObject(TDSFormQueryUtil.GENERATE_CODE, new Object[] { "T", "T" }, String.class);
			tdsauto = "T" + tdsauto;
			// String AcctHeadName = objTDSFormBean.getAccountHeadName();
			// String acctname = objTDSFormBean.getAccountName();
			// String desc = objTDSFormBean.getDescription();
			// String type = objTDSFormBean.getType();
			String financialYearId = "1";
			String tdsname = objTDSFormBean.getTdsname();
			String tdscode = objTDSFormBean.getTdscode();
			String tdsdesc = objTDSFormBean.getTdsDesc();
			String tdstype = objTDSFormBean.getTdsType();

			String isActive = objTDSFormBean.getAcctHeadStatus();
			if (isActive == "true") {
				acctHeadStatus = "Y";
			} else {
				acctHeadStatus = "N";
			}
			Calendar calendar = Calendar.getInstance();
			java.sql.Date currentDate = new java.sql.Date(calendar.getTime().getTime());

			val = jdbcTemplate.update(TDSFormQueryUtil.sInsertSubGroup, new Object[] { tdsauto, tdsname, tdscode, tdsdesc, tdstype });
			/*
			 * if (val > 0) { for (String sAttributeName :
			 * objBankcompanyBean.getlAttributes()) { val =
			 * jdbcTemplate.update(BankcompanyQueryUil
			 * .sInsertAccountAttributeMapping, new Object[] { companyCode,
			 * bankacctname }); } isSuccess = true; }
			 */
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Save Account Code", e);

		}
		return isSuccess;
	}

	@Override
	public List<TDSFormBean> getAcctHeadMasterList(int limit, int offset) throws CustomException {
		try {
			List<TDSFormBean> lSubGroupAccountBeanBean = jdbcTemplate.query(TDSFormQueryUtil.LIST, new BeanPropertyRowMapper<>(TDSFormBean.class));
			return lSubGroupAccountBeanBean;
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException("");
		}

	}

	@Override
	public TDSFormBean getBankcompanyValues(String tdsauto) throws CustomException {
		TDSFormBean objBean = new TDSFormBean();
		// String formDesc = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int[] types = new int[] { Types.VARCHAR };
			Object[] params = new Object[] { tdsauto };
			Map row = jdbcTemplate.queryForMap(TDSFormQueryUtil.Editbankcompanyvalues, params, types);
			objBean.setTdscode((String) row.get("tdsCode"));
			objBean.setTdsname((String) row.get("tdsname"));
			objBean.setTdsType((String) row.get("tdsType"));
			objBean.setTdsDesc((String) row.get("tdsDesc"));
			objBean.setTdsauto((String) row.get("tdsauto"));

			// objBean.setIsActive((String) row.get("isActive"));
			// objBean.setIsEdit(true);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getList", e);
			throw new CustomException("");
		}
		return objBean;
	}

	@Override
	public boolean deleteVendor(String tdsauto) throws CustomException {
		boolean issucces = false;
		int value = 0;
		String getDeptIdAutoIncrement = "";

		try {
			// BankcompanyBean VendorBean = getVendorEdit(bankCode);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			value = jdbcTemplate.update(TDSFormQueryUtil.delete, tdsauto);
			issucces = true;
			/*
			 * objDepartmentBean.setDeptCode(getDeptIdAutoIncrement); if (value
			 * != 0) { issucces = true;
			 * objDepartmentBean.setTableName("department_master");
			 * objDepartmentBean.setFormCode("F5118"); UserDetail userDetails =
			 * (UserDetail)
			 * SecurityContextHolder.getContext().getAuthentication(
			 * ).getPrincipal(); UserLog userLog =
			 * userlogDao.userLogForDelete(objDepartmentBean,dCode,
			 * userDetails.getUserId());
			 * //auditLogDao.auditLogForDelete(objDepartmentBean, userLog,
			 * null); }
			 */

		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete", e);
			// throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return issucces;
	}

	@Override
	public boolean updateAcctHeadMaster(TDSFormBean objTDSFormBean) throws CustomException {

		boolean issucces = false;
		int value = 1;
		int value1 = 1;

		String acctHeadStatus = "", tdsauto = "";
		try {
			tdsauto = objTDSFormBean.getTdsauto();
			String isActive = objTDSFormBean.getAcctHeadStatus();
			if (isActive == "true") {
				acctHeadStatus = "Y";
			} else {
				acctHeadStatus = "N";
			}

			Object[] params = new Object[] { objTDSFormBean.getTdscode(), objTDSFormBean.getTdsname(), objTDSFormBean.getTdsType(), objTDSFormBean.getTdsDesc(), tdsauto };
			value1 = jdbcTemplate.update(TDSFormQueryUtil.sUpdateSubGroup, params);
			/*
			 * value = jdbcTemplate.update(AccountHeadMasterQueryUtil.
			 * sDeleteAccountAttributeMapping, new Object[] {
			 * objAccountHeadMasterBean.getAccountHeadCode() }); for (String
			 * sAttributeName : objAccountHeadMasterBean.getlAttributes()) {
			 * value = jdbcTemplate.update(AccountHeadMasterQueryUtil.
			 * sInsertAccountAttributeMapping, new Object[] {
			 * objAccountHeadMasterBean.getAccountHeadCode(), sAttributeName });
			 * }
			 */
			if (value1 != 0) {
				issucces = true;
			}
		}

		catch (Exception ae) {
			LOGGER.error("Error in addCodeStandard", ae);
		}
		return issucces;
	}

}
