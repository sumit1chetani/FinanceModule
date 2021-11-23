package com.dci.tenant.user.resetPassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {
	@Autowired
	ResetPasswordDAO objResetPasswordDAO;

	@Override
	public boolean submitNewPassWord(ResetPasswordBean objResetPasswordBean) throws Exception {
		// TODO Auto-generated method stub
		return objResetPasswordDAO.submitNewPassWord(objResetPasswordBean);
	}
}
