package com.dci.tenant.company;

import java.util.List;

public interface CompanyDetailsService {

	public boolean addCompanyDetails(List<CompanyDetailsBean> objCompanyDetailsBean, String userId) throws Exception;

	public List<CompanyDetailsBean> getCompanyDetailsList(int limit, int offset) throws Exception;

	public CompanyDetailsBean editCompanyDetails(String companycode) throws Exception;

	boolean deleteCompanyDetail(String companycode) throws Exception;

	boolean CompanyNameCheck(String companyname) throws Exception;

	public boolean updateCompanyDetail(CompanyDetailsBean objCompanyDetailsBean, String userId) throws Exception;

	public List getCompany();

	public List getCurrencyList();

}
