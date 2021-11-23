package com.dci.master.company;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyDAO companyDAO;

	@Override
	public List<CompanyBean> getCompanyList() {

		return companyDAO.getCompanyList();
	}

	@Override
	public CompanyBean insert(CompanyBean company) throws Exception {
		// TODO Auto-generated method stub
		return companyDAO.insert(company);
	}

	@Override
	public CompanyBean update(CompanyBean company) throws Exception {
		// TODO Auto-generated method stub
		return companyDAO.update(company);
	}

	@Override
	public boolean delete(String company_code) {
		return companyDAO.delete(company_code);
	}
	
	@Override
	public CompanyBean getEdit(String company_code) {		
		// TODO Auto-generated method stub
		return companyDAO.getEdit(company_code);
	}
	@Override
	public List<CompanyBean> getCountry() {

		return companyDAO.getCountry();
	}
	@Override
	public List<CompanyBean> getdropdown() {

		return companyDAO.getdropdown();
	}
}