package com.dci.tenant.user.resetPassword;

import java.sql.Types;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CipherCrypto;
import com.dci.common.util.CodeStandardMsgUtil;
import com.dci.common.util.CustomException;



@Repository
public class ResetPasswordDAOImpl implements ResetPasswordDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(ResetPasswordDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@SuppressWarnings("deprecation")
	@Override
	public boolean submitNewPassWord(ResetPasswordBean objResetPasswordBean) throws CustomException {
		boolean isSuccess = false;
		int i = 1;

		try {
			int value = 0, userId;
			int[] type = new int[] { Types.VARCHAR };
			Object[] param = new Object[] { objResetPasswordBean.getUserId() };
			System.out.println("reset new PWD " + objResetPasswordBean.getPwdName());
			 userId = jdbcTemplate.queryForObject(ResetPasswordQueryUtil.sGetUserId,new Object[]{objResetPasswordBean.getUserId()},Integer.class);
			//userId = jdbcTemplate.update(ResetPasswordQueryUtil.sGetUserId, param, type);
			if (userId != 0) {
				String pswd = CipherCrypto.Encrypt(objResetPasswordBean.getPwdName());
				int[] types = new int[] { Types.VARCHAR, Types.VARCHAR };
				Object[] params = new Object[] { pswd, objResetPasswordBean.getUserId() };

				value = jdbcTemplate.update(ResetPasswordQueryUtil.sResetPassword, params, types);
				value = jdbcTemplate.update(ResetPasswordQueryUtil.EmpResetPassword, params, types);
				Integer userCount = jdbcTemplate.queryForObject(ResetPasswordQueryUtil.sGetUserCountLog,new Object[]{objResetPasswordBean.getUserId()},Integer.class);
				if(userCount > 0) {
				value = jdbcTemplate.update(ResetPasswordQueryUtil.UPDATE_USERS_PASSWORD_LOGS,new Object[] { objResetPasswordBean.getPwdName(), objResetPasswordBean.getUserId()});
				}else {
			 value = jdbcTemplate.update(ResetPasswordQueryUtil.INSERT_USERS_PASSWORD_LOGS,new Object[] { objResetPasswordBean.getUserId(),objResetPasswordBean.getPwdName()});
				}
			} else {
				isSuccess = false;
			}
			if (value != 0) {
				isSuccess = true;
			}

		} catch (Exception ae) {
			LOGGER.error("Error in resetting password", ae);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return isSuccess;
	}

}
