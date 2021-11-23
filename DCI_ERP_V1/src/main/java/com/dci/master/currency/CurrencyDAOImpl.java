package com.dci.master.currency;

import java.sql.Types;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CodeStandardMsgUtil;
import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")

public class CurrencyDAOImpl implements CurrencyDAO {

	private final static Logger LOGGER = Logger.getLogger(CurrencyDAOImpl.class);
	@Resource
	private DataSource dataSource;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;

	@SuppressWarnings("deprecation")
	@Override
	public List<CurrencyBean> getCurrencyList(int limit, int offset) throws CustomException {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<CurrencyBean> lCurrencyBean = jdbcTemplate.query(CurrencyQueryUtill.sGetCurrencyValues, new BeanPropertyRowMapper<CurrencyBean>(
					CurrencyBean.class));
			return lCurrencyBean;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Currency List", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}

	}

	@Override
	public CurrencyResultBean addcurrency(CurrencyBean objCurrencyBean) throws CustomException {
		int val = 1;
		CurrencyResultBean objCurrencyResult = new CurrencyResultBean();

		boolean isAdded = true;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			/* Map parameters = new HashMap(); */

			String currencyCode = objCurrencyBean.getCurrencyCode().trim().toUpperCase();
			String currencyName = objCurrencyBean.getCurrencyName().trim().toUpperCase();
			double fromc = objCurrencyBean.getFromc();
			double toc = objCurrencyBean.getToc();
			double currencyDefault = objCurrencyBean.getCurrencyDefault();
			double currencyFraction = objCurrencyBean.getCurrencyFraction();
			
			String bookCurrency = objCurrencyBean.getBookCurrency();
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String createdBy = userDetails.getUserId();
			int j = jdbcTemplate.queryForObject(CurrencyQueryUtill.currencyCodeExists, Integer.class, new Object[] { currencyCode });
			if (j == 0) {
				String bool,bool1;
				int i = jdbcTemplate.queryForObject(CurrencyQueryUtill.currencyExists, Integer.class, new Object[] { currencyName });
				if (i == 0) {
					if(objCurrencyBean.getIsActive()==true){
						bool = "1";
					}else{
						bool = "0";
					}	
					
					if(objCurrencyBean.getIsRound()==true){
						bool1 = "1";
					}else{
						bool1 = "0";
					}	
					
					int count1=jdbcTemplate.queryForObject(CurrencyQueryUtill. count1,Integer.class);

//insert into currency (crrncy_id,crrncy_cd,crrncy_nam,crrncy_symbl_nam,descrptn_vc,crtd_by,crtd_dt,mdfd_by,mdfd_dt,actv_bt,crrncy_ctgry,rnd_off_invc_fnl_amnt,currency_conver_from,currency_conver_to,currency_fraction,currency_default) values (?,?,?,?,?,?,now(),?,now(),pg_catalog.bit(?),?,pg_catalog.bit(?),?,?,?,?)

					val = jdbcTemplate.update(CurrencyQueryUtill.sAddCurrency, new Object[] {count1, currencyCode, currencyName, objCurrencyBean.getSymbol(),objCurrencyBean.getDescription(),createdBy,createdBy,bool,objCurrencyBean.getCategory(),bool1, objCurrencyBean.getFromCurrency(), objCurrencyBean.getToCurrency(),
							 currencyFraction,objCurrencyBean.getDefaultCurrency()});
					if (val > 0) {
	
						UserLog userLog = userlogDao.userLogForInsert(objCurrencyBean, currencyCode, userDetails.getUserId());
						//auditLogDao.auditLogForInsert(objCurrencyBean, userLog, null);
					}
					isAdded = true;
					objCurrencyResult.setSuccess(true);
				} else {
					isAdded = false;
					objCurrencyResult.setErrors("Currency Name Already Exists!");
					objCurrencyResult.setSuccess(false);

				}

			} else {
				isAdded = false;
				objCurrencyResult.setErrors("Currency Code already exists");
				objCurrencyResult.setSuccess(false);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Add Currency", e);

		}
		return objCurrencyResult;
	}

	@Override
	public boolean deleteCurrency(Integer currencyCode) throws CustomException {

		boolean issucces = false;
		int value = 0;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			CurrencyBean objCurrencyBean = getCurrency1(currencyCode);
			value = jdbcTemplate.update(CurrencyQueryUtill.sDeleteCurrencyDetail, currencyCode);
			if (value != 0) {
				issucces = true;
				UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				UserLog userLog = userlogDao.userLogForDelete(objCurrencyBean, objCurrencyBean.getCurrencyCode(), userDetails.getUserId());
			//	auditLogDao.auditLogForDelete(objCurrencyBean, userLog, null);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete Currency", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return issucces;
	}

	// update

	@Override
	public boolean updateCurrency(CurrencyBean objCurrencyBean) throws Exception {

		boolean issucces = false;
		int value = 0;
		String getcurrencyCode = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			getcurrencyCode = objCurrencyBean.getCurrencyCode();
			CurrencyBean objCurrencyBeanOld = getCurrency(getcurrencyCode);
			int[] types = new int[] { Types.VARCHAR, Types.DOUBLE, Types.INTEGER, Types.DOUBLE, Types.DOUBLE, Types.VARCHAR, Types.VARCHAR,
					Types.VARCHAR };
			Object[] params = new Object[] { objCurrencyBean.getCurrencyName(), objCurrencyBean.getDefaultCurrency(),
					objCurrencyBean.getCurrencyFraction(), objCurrencyBean.getFromCurrency(), objCurrencyBean.getToCurrency(), objCurrencyBean.getIsActive(),
					objCurrencyBean.getBookCurrency(), getcurrencyCode };
			String bool,bool1;
			if(objCurrencyBean.getIsActive()==true){
				bool = "1";
			}else{
				bool = "0";
			}	
			
			if(objCurrencyBean.getIsRound()==true){
				bool1 = "1";
			}else{
				bool1 = "0";
			}	
//update currency set crrncy_nam=?,crrncy_symbl_nam=?,dscrptn_vc=?,mdfd_by=?,mdfd_dt=now(),actv_bt=pg_catalog.bit(?),crrncy_ctgry=?,rnd_off_invc_fnl_amnt=pg_catalog.bit(?),currency_conver_from = ?, currency_conver_to = ?,CURRENCY_FRACTION =?,CURRENCY_DEFAULT =? where crrncy_id =?
			value = jdbcTemplate.update(CurrencyQueryUtill.sUpdatecurrency,new Object[] {objCurrencyBean.getCurrencyName(),objCurrencyBean.getSymbol(),objCurrencyBean.getDescription(),userDetails.getUserId(),bool,objCurrencyBean.getCategory(),bool1, objCurrencyBean.getFromCurrency(), objCurrencyBean.getToCurrency(),(int)objCurrencyBean.getCurrencyFraction(),objCurrencyBean.getDefaultCurrency()
					,objCurrencyBean.getCurrencyId()});
			if (value > 0) {
				
				UserLog userLog = userlogDao.userLogForUpdate(objCurrencyBeanOld, objCurrencyBean, getcurrencyCode, userDetails.getUserId());
				//auditLogDao.auditLogForUpdate(objCurrencyBeanOld, objCurrencyBean, userLog, null);
			}
			System.out.println("Update Value" + value);
			if (value != 0) {
				issucces = true;
			}
		}

		catch (Exception ae) {
			ae.printStackTrace();
			LOGGER.error("Error in Update Currency", ae);
			/*LOGGER.error("Error in addCodeStandard", ae);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);*/
		}
		return issucces;
	}

	/**
	 * @param getcurrencyCode
	 * @return
	 */
	@Override
	public CurrencyBean getCurrency(String currencyCode) throws CustomException {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			System.out.println(currencyCode);
			CurrencyBean currencyBean = jdbcTemplate.queryForObject(CurrencyQueryUtill.sGetCurrencyValue, new Object[] { currencyCode },
					new BeanPropertyRowMapper<CurrencyBean>(CurrencyBean.class));
			return currencyBean;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getCurrency", e);
			throw new CustomException("Error in getting currency");
		}
	}
	@Override
	public CurrencyBean getCurrency1(Integer currencyCode) throws CustomException {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			System.out.println(currencyCode);
			CurrencyBean currencyBean = jdbcTemplate.queryForObject(CurrencyQueryUtill.sGetCurrencyValue1, new Object[] { currencyCode },
					new BeanPropertyRowMapper<CurrencyBean>(CurrencyBean.class));
			return currencyBean;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getcurrencylist1", e);
			throw new CustomException("Error in getting currency");
		}
	}

	@Override
	public CurrencyResultBean getExchangeRate(int currencyId) {
		CurrencyResultBean bean = new CurrencyResultBean();
		try {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		bean=jdbcTemplate.queryForObject(CurrencyQueryUtill.sGetCurrencyRates,new BeanPropertyRowMapper<CurrencyResultBean>(CurrencyResultBean.class),currencyId);

		//bean = jdbcTemplate.queryForObject(CurrencyQueryUtill.sGetCurrencyRates,new Object[] { currencyId },CurrencyResultBean.class);
		
	} catch (DataAccessException e) {
		LOGGER.error("Error in Exchange Rate", e);
	}
	return bean;
	}
	
}
