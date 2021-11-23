package com.dci.tenant.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyDetailsServiceImpl implements CompanyDetailsService {

	@Autowired
	CompanyDetailsDAO objCompanyDetailsDAO;

	@Override
	public boolean addCompanyDetails(List<CompanyDetailsBean> objCompanyDetailsBean, String userId) throws Exception {
		return objCompanyDetailsDAO.addCompanyDetails(objCompanyDetailsBean, userId);
	}

	@Override
	public List<CompanyDetailsBean> getCompanyDetailsList(int limit, int offset) throws Exception {
		return objCompanyDetailsDAO.getCompanyDetailsList(limit, offset);
	}

	@Override
	public CompanyDetailsBean editCompanyDetails(String companycode) throws Exception {
		// TODO Auto-generated method stub
		return objCompanyDetailsDAO.editCompanyDetails(companycode);
	}

	@Override
	public boolean deleteCompanyDetail(String companycode) throws Exception {
		// TODO Auto-generated method stub
		return objCompanyDetailsDAO.deleteCompanyDetail(companycode);
	}

	@Override
	public boolean CompanyNameCheck(String companyname) throws Exception {
		// TODO Auto-generated method stub
		return objCompanyDetailsDAO.CompanyNameCheck(companyname);
	}

	@Override
	public boolean updateCompanyDetail(CompanyDetailsBean objCompanyDetailsBean, String userId) throws Exception {
		return objCompanyDetailsDAO.updateCompanyDetail(objCompanyDetailsBean, userId);

	}

	@Override
	public List getCompany() {
		return objCompanyDetailsDAO.getCompany();
	}

	@Override
	public List getCurrencyList() {
		return objCompanyDetailsDAO.getCurrencyList();
	}
}
