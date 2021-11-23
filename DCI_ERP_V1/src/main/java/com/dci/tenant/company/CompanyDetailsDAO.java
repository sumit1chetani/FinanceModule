package com.dci.tenant.company;
import java.util.List;

import com.dci.common.util.CustomException;

public interface CompanyDetailsDAO {

	public boolean addCompanyDetails(List<CompanyDetailsBean> objCompanyDetailsBean, String userId) throws CustomException;

	public List<CompanyDetailsBean> getCompanyDetailsList(int limit, int offset) throws CustomException;

	public CompanyDetailsBean editCompanyDetails(String companycode) throws CustomException;

	public boolean deleteCompanyDetail(String companycode) throws CustomException;

	public boolean CompanyNameCheck(String companyname) throws CustomException;

	public boolean updateCompanyDetail(CompanyDetailsBean objCompanyDetailsBean, String userId) throws CustomException;

	public List getCompany();

	public List getCurrencyList();

}
