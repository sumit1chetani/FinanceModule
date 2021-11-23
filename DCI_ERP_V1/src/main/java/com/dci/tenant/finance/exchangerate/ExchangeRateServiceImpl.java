package com.dci.tenant.finance.exchangerate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
	@Autowired
	ExchangeRateDAO objexchangeRateDAO;

	@Override
	public List<ExchangeRateBean> getExchangeRateList(int limit, int offset) {
		return objexchangeRateDAO.getExchangeRateList(limit, offset);
	}

	@Override
	public ExchangeRateResultBean getCurrencyList() {
		return objexchangeRateDAO.getCurrencyList();
	}

	@Override
	public boolean saveExchangeRateData(ExchangeRateBean objExchangeRateBean, String userId) {
		return objexchangeRateDAO.saveExchangeRateData(objExchangeRateBean, userId);
	}

	@Override
	public ExchangeRateResultBean getBookCurrencyList() {
		return objexchangeRateDAO.getBookCurrencyList();
	}

	@Override
	public ExchangeRateBean getExchangeRateEditList(String exchangeRateCode) {
		return objexchangeRateDAO.getExchangeRateEditList(exchangeRateCode);
	}

	@Override
	public boolean updateExchangeRateData(ExchangeRateBean objExchangeRateBean, String userId) {
		return objexchangeRateDAO.updateExchangeRateData(objExchangeRateBean, userId);
	}

	@Override
	public boolean copyExchangeRate(ExchangeRateBean objExchangeRateBean, String userId) {
		return objexchangeRateDAO.copyExchangeRate(objExchangeRateBean, userId);
	}

	@Override
	public boolean deleteExchangeRate(String erCode) {
		return objexchangeRateDAO.deleteExchangeRate(erCode);
	}

}
