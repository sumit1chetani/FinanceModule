package com.dci.tenant.finance.reports.auditTrial.quotation;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public interface QuotationAuditTrialDAO {

	public List<SelectivityBean> getEmployeeList();

	public List<QuotationAuditTrialBean> getQuotationList(QuotationAuditTrialBean quotationBean) throws Exception;

	public List<QuotationAuditTrialBean> jvTariffList(QuotationAuditTrialBean bean);

	public List<QuotationAuditTrialBean> getPurQuotList(QuotationAuditTrialBean bean);
}
