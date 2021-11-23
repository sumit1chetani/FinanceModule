package com.dci.master.CompanyGroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyGroupServiceImpl implements CompanyGroupService {

	@Autowired
	CompanyGroupDAO objCompanyDetailsDAO;

	@Override
	public boolean addCompanyDetails(CompanyGroupBean objCompanyDetailsBean) throws Exception {
		return objCompanyDetailsDAO.addCompanyDetails(objCompanyDetailsBean);
	}

	@Override
	public List<CompanyGroupBean> getCompanyDetailsList() throws Exception {
		return objCompanyDetailsDAO.getCompanyDetailsList();
	}

	@Override
	public List<CompanyGroupBean> CompanyGroupEditDetList(Integer groupId) throws Exception {
		return objCompanyDetailsDAO.CompanyGroupEditDetList(groupId);
	}

	@Override
	public List<CompanyGroupBean> getCompanyGroupTableList() throws Exception {
		return objCompanyDetailsDAO.getCompanyGroupTableList();
	}

	@Override
	public boolean deleteCompanyDetail(int groupId) throws Exception {
		// TODO Auto-generated method stub
		return objCompanyDetailsDAO.deleteCompanyDetail(groupId);
	}

	@Override
	public boolean companyGroupNameCheck(String companyGroupName) throws Exception {
		// TODO Auto-generated method stub
		return objCompanyDetailsDAO.companyGroupNameCheck(companyGroupName);
	}

	@Override
	public boolean multideleteCompanyDetail(String companycode) throws Exception {
		// TODO Auto-generated method stub
		return objCompanyDetailsDAO.multideleteCompanyDetail(companycode);
	}

	@Override
	public List<CompanyGroupBean> getCompanyList() throws Exception {
		// TODO Auto-generated method stub
		return objCompanyDetailsDAO.getCompanyList();
	}

}
