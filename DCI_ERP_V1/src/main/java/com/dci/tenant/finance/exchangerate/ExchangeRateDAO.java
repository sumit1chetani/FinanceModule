package com.dci.tenant.finance.exchangerate;

import java.util.List;

public interface ExchangeRateDAO {

	List<ExchangeRateBean> getExchangeRateList(int limit, int offset);

	ExchangeRateResultBean getCurrencyList();

	boolean saveExchangeRateData(ExchangeRateBean objExchangeRateBean, String userId);

	ExchangeRateResultBean getBookCurrencyList();

	ExchangeRateBean getExchangeRateEditList(String exchangeRateCode);

	boolean updateExchangeRateData(ExchangeRateBean objExchangeRateBean, String userId);

	boolean copyExchangeRate(ExchangeRateBean objExchangeRateBean, String userId);

	boolean deleteExchangeRate(String erCode);

}
