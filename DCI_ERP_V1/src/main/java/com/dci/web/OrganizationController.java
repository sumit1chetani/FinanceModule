package com.dci.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dci.master.organization.Organization;
import com.dci.master.organization.OrganizationService;



@RestController
@RequestMapping
public class OrganizationController {
	
	@Resource
	private OrganizationService organizationService;

	@RequestMapping("/organization/list")
	public List<Organization> organization() {
		List<Organization> organizationList = organizationService.findAll();
		return organizationList;
	}

	@RequestMapping(value = "/organization/save", method = RequestMethod.POST)
	public void companyAdd(@RequestBody Organization organization) {
		try {
			organizationService.save(organization);
			organizationService.setDataSource(organization);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
