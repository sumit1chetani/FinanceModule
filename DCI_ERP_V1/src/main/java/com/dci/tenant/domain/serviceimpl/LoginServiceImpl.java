package com.dci.tenant.domain.serviceimpl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.domain.model.DashboardBean;
import com.dci.tenant.domain.model.resultbean.RegistrationResultBean;
import com.dci.tenant.domain.repository.LoginreportRepository;
import com.dci.tenant.domain.service.LoginService;

@Service
@Transactional("tenantTransactionManager")
public class LoginServiceImpl implements LoginService {

	private static Logger logger = Logger.getLogger(LoginServiceImpl.class.getName());

	@Resource
	private LoginreportRepository loginreportRepository;

	
	@SuppressWarnings("static-access")
	public RegistrationResultBean authenticateUser(String userName,
			String password) {
		String authMessage = "";
		RegistrationResultBean resultBean = new RegistrationResultBean();
		try {
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public DashboardBean getDashboardValues() throws Exception {
		return loginreportRepository.getDashboardValues();
	}

}