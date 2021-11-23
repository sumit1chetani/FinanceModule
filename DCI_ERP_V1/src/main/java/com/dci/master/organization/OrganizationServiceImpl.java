package com.dci.master.organization;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dci.master.domain.repository.DataSourceRepository;

@Service
@Transactional("masterTransactionManager")
public class OrganizationServiceImpl implements OrganizationService{
	
	@Value("${folder.uploadpath.localPath}")
	private String localPath;

	@Value("${folder.uploadpath.serverPath}")
	private String serverpath;
	
	@Resource
	private OrganizationRepository organizationRepository;
	
	@Resource
	private DataSourceRepository dataSourceRepository;
	
	@Override
	public List<Organization> findAll() {
		return organizationRepository.findAll();
	}

	@Override
	public void save(Organization organization) {
		organizationRepository.save(organization);
	}

	@Override
	public void setDataSource(Organization organization) {
		dataSourceRepository.setDataSource(organization);
	}
	
}
