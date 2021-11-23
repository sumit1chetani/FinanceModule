package com.dci.tenant.user.resetPassword;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;


@Controller
@RequestMapping(value = "{tenantid}/app/password")
public class ResetPasswordController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ResetPasswordController.class);
	@Autowired
	ResetPasswordService objResetPasswordService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	boolean submitNewPassWord(@RequestBody ResetPasswordBean objResetPasswordBean) throws CustomException {
		boolean isSuccess = false;
		ResetPasswordResultBean objResetPasswordResultBean = new ResetPasswordResultBean();
		try {

			isSuccess = objResetPasswordService.submitNewPassWord(objResetPasswordBean);
			objResetPasswordResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

}
