package com.dci.tenant.marketing.quotation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



 @RestController
 @RequestMapping(value = "{tenantid}/api/quotation")


public class QuotationController {
	@Autowired
	private QuotationService quotationService;

	@GetMapping("/list")
	public List<QuotationBean> QuotationList() {
		System.out.println("Get all Quotation...");

		List<QuotationBean> quotationList = new ArrayList<>();
		
		quotationList=quotationService.QuotationList();

		return quotationList;
	}
	

	@GetMapping(value = "/quotationlist")
	public List<QuotationBean> getDropDown() {
		
		List<QuotationBean> List = new ArrayList<>();
		
		List=quotationService.getDropDown();

		return List;
	}
	
	@GetMapping(value = "/linelist")
	public List<QuotationBean> dropDown() {
		
		List<QuotationBean> List = new ArrayList<>();
		
		List=quotationService.dropDown();

		return List;
	}
	
	@GetMapping(value = "/agentlist")
	public List<QuotationBean> AgentList() {
		
		List<QuotationBean> List = new ArrayList<>();
		
		List=quotationService.AgentList();

		return List;
	}
	
	@GetMapping(value = "/partylist")
	public List<QuotationBean> PartyList() {
		
		List<QuotationBean> List = new ArrayList<>();
		
		List=quotationService.PartyList();

		return List;
	}
	
	@GetMapping(value = "/exelist")
	public List<QuotationBean> ExecutiveList() {
		
		List<QuotationBean> List = new ArrayList<>();
		
		List=quotationService.ExecutiveList();

		return List;
	}
	
	@RequestMapping(value = "/create" ,method = RequestMethod.POST)
	public QuotationBean save(@RequestBody QuotationBean quotation) {
		QuotationBean objbranchResultBean = new QuotationBean();
		try {
//			 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//			 Date date = dateFormat.parse(quotation.getQuotation_date());//You will get date object relative to server/client timezone wherever it is parsed
//			 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //If you need time just put specific format for time like 'HH:mm:ss'
//			 String dateStr = formatter.format(date);
//			 quotation.setQuotation_date(dateStr);
//			 
//			 DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//			 Date date1 = dateFormat1.parse(quotation.getValidtill());//You will get date object relative to server/client timezone wherever it is parsed
//			 DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd"); //If you need time just put specific format for time like 'HH:mm:ss'
//		 String dateStr1 = formatter1.format(date1);
//		 quotation.setValidtill(dateStr1);
			objbranchResultBean = quotationService.insert(quotation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return objbranchResultBean;

	}
	
	
	
	@DeleteMapping(value="/delete/{quotation_no}") 
	public boolean deleteQuotation(@PathVariable String quotation_no)
	 {
		boolean isDeleted = false;
		try{
		
		isDeleted = quotationService.delete(quotation_no);
		}
		catch (Exception e) {
				e.printStackTrace();	
				}
		
		return isDeleted;
	}
	
	
	
	
	
	
	@GetMapping(value="/edit") 
	public QuotationBean getEdit(@RequestParam("quotation_no") String quotation_no) {
	
		QuotationBean quotationBean = new QuotationBean();
		
		quotationBean=quotationService.getEdit(quotation_no);

		return quotationBean;
	}
	
	
	
	@RequestMapping(value = "/update" ,method = RequestMethod.POST)
	public QuotationBean update(@RequestBody QuotationBean update) {
		QuotationBean objbranchResultBean = new QuotationBean();
		try {
//			 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			 Date date = dateFormat.parse(update.getQuotation_date());//You will get date object relative to server/client timezone wherever it is parsed
//			 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //If you need time just put specific format for time like 'HH:mm:ss'
//			 String dateStr = formatter.format(date);
//			 update.setQuotation_date(dateStr);
//			 
//			 DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
//			 Date date1 = dateFormat1.parse(update.getValidtill());//You will get date object relative to server/client timezone wherever it is parsed
//			 DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd"); //If you need time just put specific format for time like 'HH:mm:ss'
//		 String dateStr1 = formatter1.format(date1);
//		 update.setValidtill(dateStr1);
			objbranchResultBean = quotationService.update(update);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return objbranchResultBean;

	}
	

	}







