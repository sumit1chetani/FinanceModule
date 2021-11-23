package com.dci.master.company;

import java.util.List;


public interface CompanyService {
	
	public List<CompanyBean> getCompanyList();

	public CompanyBean insert(CompanyBean company) throws Exception;

	public CompanyBean update(CompanyBean company) throws Exception;

	public boolean delete(String company_code);

	public CompanyBean getEdit(String company_code);

	public List<CompanyBean> getCountry();
	
	public List<CompanyBean> getdropdown();

}
