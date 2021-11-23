package com.dci.tenant.user.resetPassword;

import com.dci.common.util.CustomException;

public interface ResetPasswordDAO {
	public boolean submitNewPassWord(ResetPasswordBean objResetPasswordBean) throws CustomException;
}
