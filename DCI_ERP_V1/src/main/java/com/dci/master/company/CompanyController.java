package com.dci.master.company;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;





@Controller
@RequestMapping(value = "{tenantid}/api/company")
public class CompanyController {

	@Autowired
	private CompanyService CompanyService;

	@GetMapping("/list")
	public List<CompanyBean> getCompanyList() {
		System.out.println("Get all Company...");

		List<CompanyBean> companyList = new ArrayList<>();

		companyList = CompanyService.getCompanyList();

		return companyList;
	}
	
	

	
	@RequestMapping("/countrylist")
	public @ResponseBody List<CompanyBean> getCountry() {
		System.out.println("Get all Country...");

		List<CompanyBean> companylist = new ArrayList<>();

		companylist = CompanyService.getCountry();

		return companylist;
	}
      
	@GetMapping("/currencylist")
	public List<CompanyBean> getdropdown() {
		System.out.println("Get all Currency...");

		List<CompanyBean> companylist = new ArrayList<>();

		companylist = CompanyService.getdropdown();

		return companylist;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public CompanyBean save(@RequestBody CompanyBean company) {
		CompanyBean objbranchResultBean = new CompanyBean();
		try {
			objbranchResultBean = CompanyService.insert(company);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objbranchResultBean;

	}

	@DeleteMapping(value = "/delete/{company_code}")
	public boolean deleteCompany(@PathVariable String company_code) {
		boolean isDeleted = false;
		try{
		  isDeleted = CompanyService.delete(company_code);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return isDeleted;
	}

	@RequestMapping(value="/edit") 
	public  @ResponseBody CompanyBean getEdit(@RequestParam("company_code") String company_code) {
	
		CompanyBean companybean = new CompanyBean();
		
		companybean=CompanyService.getEdit(company_code);

		return companybean;
	}
	
	@RequestMapping(value = "/update" ,method = RequestMethod.POST)
	public CompanyBean Update(@RequestBody CompanyBean company) {
		CompanyBean objbranchResultBean = new CompanyBean();
		try {
			objbranchResultBean = CompanyService.update(company);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return objbranchResultBean;

	}
	
}
