package com.dci.tenant.finance.reports.charterhirestatement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CharterHireStatementServiceImpl implements CharterHireStatementService {

	@Autowired
	CharterHireStatementDAO charterHireStatementDAO;

	@Override
	public List<CharterHireStatementBean> getCharterHireStmtReportData(CharterHireStatementBean objCharterHireStatementBean) {
		return charterHireStatementDAO.getCharterHireStmtReportData(objCharterHireStatementBean);
	}
}
