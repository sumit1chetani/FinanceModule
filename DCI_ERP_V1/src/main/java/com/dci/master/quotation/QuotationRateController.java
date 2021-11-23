package com.dci.master.quotation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jxls.common.Context;
import org.jxls.template.SimpleExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.reports.quotationsummary.QuotationsummaryResultBean;
import com.dci.tenant.user.UserDetail;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


@RestController
@RequestMapping(value = "{tenantid}/app/quotation")
public class QuotationRateController {

	@Autowired
	QuotationRateService quotationService;
	
	@RequestMapping(value = "/save")
	public @ResponseBody QuotationRateResultBean save(@RequestBody QuotationRateBean bean) {
		System.out.println("test-------");
		QuotationRateResultBean rb = null;
 		try {			 
			rb = quotationService.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}

	@RequestMapping(value = "/saveNewQuotation")
	public @ResponseBody QuotationRateResultBean saveNewQuotation(@RequestBody QuotationRateBean bean) {
 		QuotationRateResultBean rb = null;
 		try {			 
			rb = quotationService.saveNewQuotation(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	
	@RequestMapping(value = "/saveQuotationDtl")
	public @ResponseBody QuotationRateResultBean saveQuotationDtl(@RequestBody QuotationRateBean bean) {
 		QuotationRateResultBean rb = null;
 		try {			 
			rb = quotationService.saveQuotationDtl(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	
	
	@RequestMapping(value = "/getShipment")
	public @ResponseBody QuotationRateResultBean getShipment() {
		System.out.println("test-------1222");
		QuotationRateResultBean rb = null;
 		try {			 
			//rb = quotationService.save();
 			rb=quotationService.getShipment();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	@RequestMapping(value = "/saveasDraft")
	public @ResponseBody QuotationRateResultBean saveasDraft(@RequestBody QuotationRateBean bean) {
		QuotationRateResultBean rb = null;
 		try {			 
			rb = quotationService.saveasDraft(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}

	
	
	@RequestMapping(value = "/getcustomerdetail")
	public QuotationRateResultBean getcustomerdetail(@RequestBody String custId) {
		System.out.println("testedit----------");
		QuotationRateResultBean rb = null;
 		try {			 
			rb = quotationService.getCustomerDetail(custId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}

	@RequestMapping(value = "/list")
	public @ResponseBody  QuotationRateResultBean list() {
		QuotationRateResultBean rb = null;
 		try {			 
			rb = quotationService.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	
	@RequestMapping(value = "/listFilter")
	public @ResponseBody  QuotationRateResultBean listFilter(@RequestBody QuotationRateBean bean) {
		QuotationRateResultBean rsltBean = new QuotationRateResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 		try {			 
 			rsltBean.setlQuotationBean(quotationService.listFilter(bean));
 			rsltBean.setUserId(userDetails.getUserId());
 			if("Y".equalsIgnoreCase(userDetails.getIsVendor())) {
 				rsltBean.setVendor(true);
 			}else {
 				rsltBean.setVendor(false);
 			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rsltBean;
	}
	
	@RequestMapping(value = "/getApprovalStatus")
	public @ResponseBody Integer getApprovalStatus(@RequestParam("quotationNo") String quotationNo) throws CustomException {

		int rb = 0;
 		try {			 
			rb = quotationService.getApprovalStatus(quotationNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	
	@RequestMapping(value = "/listFilterApproval")
	public @ResponseBody  QuotationRateResultBean listFilterApproval(@RequestBody QuotationRateBean bean) {
		QuotationRateResultBean rb = null;
 		try {			 
			rb = quotationService.listFilterApproval(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	
	@RequestMapping(value = "/edit")
	public QuotationRateResultBean edit(@RequestBody String QuotHdId) {
		System.out.println("testedit----------");
		QuotationRateResultBean rb = null;
 		try {			 
			rb = quotationService.edit(QuotHdId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	
	
	
	
	@RequestMapping(value = "/view")
	public QuotationRateResultBean view(@RequestBody Integer QuotHdId) {
		QuotationRateResultBean rb = null;
 		try {			 
			rb = quotationService.view(QuotHdId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	
	
	@RequestMapping(value = "/update")
	public QuotationRateResultBean update(@RequestBody QuotationRateBean bean) {
		QuotationRateResultBean rb = null;
 		try {			 
			rb = quotationService.update(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	
	@RequestMapping(value = "/delete")
	public QuotationRateResultBean delete(@RequestBody String  quotationNo) {
		QuotationRateResultBean rb = null;
 		try {			 
			rb = quotationService.delete(quotationNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	
	@RequestMapping(value = "/approve")
	public QuotationRateResultBean approve(@RequestBody QuotationRateBean bean) {
		QuotationRateResultBean rb = null;
 		try {			 
			rb = quotationService.approve(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	
/*	@RequestMapping(value = "/reject")
	public QuotationRateResultBean reject(@RequestBody String  quotationNo) {
		QuotationRateResultBean rb = null;
 		try {			 
			rb = quotationService.reject(quotationNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}*/
	
	@RequestMapping(value = "/reject")
	public @ResponseBody QuotationRateResultBean reject(@RequestBody QuotationRateBean bean) {
		QuotationRateResultBean rb = null;
 		try {			 
			rb = quotationService.reject(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	@RequestMapping(value="/checkQuoteExists") 
	public QuotationsummaryResultBean checkQuoteExists(@RequestParam("pol") String pol,@RequestParam("pod") String pod,@RequestParam("customer") String customer,@RequestParam("special") String special,@RequestParam("cargoType") String cargoType) {
	
		QuotationsummaryResultBean quotationBean = new QuotationsummaryResultBean();
		
		quotationBean=quotationService.checkQuoteExists(pol,pod,customer,special,cargoType);

		return quotationBean;
	}
	
	
/*	@RequestMapping("/getiataList")
	public @ResponseBody CommonUtilityResultBean getiataList() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(quotationService.getiataList());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	*/
	/*@RequestMapping("/getcommodity")
	public @ResponseBody CommonUtilityResultBean getcommodity() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(quotationService.getcommodity());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}*/
	
	
	
/*	@RequestMapping("/getCurrencyList")
	public @ResponseBody CommonUtilityResultBean getCurrencyList() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(quotationService.getCurrencyList());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}*/
/*	@RequestMapping("/getuomList")
	public @ResponseBody CommonUtilityResultBean getuomList() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(quotationService.getuomList());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}*/
/*	@RequestMapping("/getServicePartner")
	public @ResponseBody CommonUtilityResultBean getServicePartner() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(quotationService.getServicePartner());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}*/
	
	/*@RequestMapping("/getServicePartnerType")
	public @ResponseBody CommonUtilityResultBean getServicePartnerType() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(quotationService.getServicePartnerType());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}
	*/
	
	
/*	@RequestMapping("/getBranch")
	public @ResponseBody CommonUtilityResultBean getBranch() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(quotationService.getBranch());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}*/
	
	
/*	@RequestMapping("/getChargeHeads")
	public @ResponseBody CommonUtilityResultBean getChargeHeads() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(quotationService.getChargeHeads());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}*/
	
/*	@RequestMapping("/getTerms")
	public @ResponseBody CommonUtilityResultBean getTerms() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(quotationService.getTerms());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}*/
	
/*	@RequestMapping("/getEmployeeList")
	public @ResponseBody CommonUtilityResultBean getEmployeeList() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(quotationService.getEmployeeList());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}*/
	
/*	@RequestMapping("/getUnitList")
	public @ResponseBody CommonUtilityResultBean getUnitList() throws CustomException {
		CommonUtilityResultBean commonUtilityResultBean = new CommonUtilityResultBean();

		try {
			commonUtilityResultBean.setCommonUtilityBean(quotationService.getUnitList());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}*/
	
	

/*	@RequestMapping("/print")
	public ModelAndView print(@RequestParam("quotationHdId") Integer quotationHdId) throws Exception {
		ModelAndView obj = null;
		obj = new ModelAndView("air/seaQuotation/seaQuotationPrint");
		SeaQuotationBean objGeneralInvoiceBean = new SeaQuotationBean();
		objGeneralInvoiceBean = quotationService.print(quotationHdId);
		
		obj.addObject("masterList", objGeneralInvoiceBean);
		obj.addObject("detailList", objGeneralInvoiceBean.getQuotationDtl());

		return obj;
	}
	*/



	public static PdfPCell createImageCell(String path) throws DocumentException, IOException {
	    Image img = Image.getInstance(path);
	    PdfPCell cell = new PdfPCell(img, true);
	    return cell;
	}


	@RequestMapping(value = "/downloadFiles")
	public @ResponseBody QuotationRateResultBean downloadfile(@RequestBody String quotationNo) throws CustomException {
		QuotationRateResultBean Bean = new QuotationRateResultBean();
		try {
			
			Bean = quotationService.DownloadFile(quotationNo);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Bean;
	}
	
	@RequestMapping("/getServicePartnerList")
	public @ResponseBody QuotationRateResultBean getServicePartnerDropdownList() throws CustomException {
		QuotationRateResultBean res = new QuotationRateResultBean();

		try {
			res=quotationService.getServicePartnerDropdownList();
			res.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return res;
	}
	
	@RequestMapping("/getServicePartnerListid")
	public @ResponseBody QuotationRateResultBean getServicePartnerDropdownListid(@RequestParam("id") String id) throws CustomException {
		QuotationRateResultBean res = new QuotationRateResultBean();

		try {
			res=quotationService.getServicePartnerDropdownListid(id);
			res.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return res;
	}
	
	@RequestMapping("/uploaddelete")
	public @ResponseBody boolean updelete(@RequestBody String quotationNo) throws Exception {
		boolean isDeleted = false;
		isDeleted = quotationService.uploaddelete(quotationNo);
		return isDeleted;
	}
	
	@RequestMapping("/deleteFiles")
	public @ResponseBody boolean deletefiles(@RequestBody String fileName) throws Exception {
		boolean isDeleted = false;
		isDeleted = quotationService.deletefiles(fileName);
		return isDeleted;
	}
	
	
	@RequestMapping("/viewSeaQuotationMail")
	public @ResponseBody QuotationRateResultBean viewSeaQuotationMail(@RequestParam("quotationHdId") Integer quotationHdId) throws Exception {
		//ModelAndView obj = null;
		//obj = new ModelAndView("air/seaQuotation/seaQuotationPrint");
		QuotationRateResultBean QuotationResultBean = new QuotationRateResultBean();
		QuotationRateBean objGeneralInvoiceBean = new QuotationRateBean();
		objGeneralInvoiceBean = quotationService.print(quotationHdId);
		QuotationResultBean.setSeaQuotationBean(objGeneralInvoiceBean);
		/*obj.addObject("masterList", objGeneralInvoiceBean);
		obj.addObject("detailList", objGeneralInvoiceBean.getQuotationDtl());*/

		return QuotationResultBean;
	}
	
	//For contra
	
	@RequestMapping("/getCustomerList")
	public @ResponseBody QuotationRateResultBean getCustomerList() throws CustomException {
		QuotationRateResultBean res = new QuotationRateResultBean();

		try {
			res=quotationService.getCustomerList();
			res.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return res;
	}
	
	@RequestMapping("/getCustomerListCompany")
	public @ResponseBody QuotationRateResultBean getCustomerListCompany(@RequestParam("company") String company) throws CustomException {
		QuotationRateResultBean res = new QuotationRateResultBean();

		try {
			res=quotationService.getCustomerListCompany(company);
			res.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return res;
	}
	
	@RequestMapping("/getChargeList")
	public @ResponseBody List<QuotationRateBean> getChargeList(String pol,String pod,String chargeType,String conType,String hazardous ,String oog ) throws Exception {
		List<QuotationRateBean> listBean = new ArrayList<QuotationRateBean>();
		listBean = quotationService.getChargeList(pol,pod,chargeType,conType,hazardous,oog);		
		return listBean;
	}
	
	@RequestMapping("/getdefaultchargeList")
	public @ResponseBody List<QuotationRateBean> getdefaultchargeList(@RequestParam String pol,String crnyName) throws Exception {
		List<QuotationRateBean> listBean = new ArrayList<QuotationRateBean>();
		try{
			listBean = quotationService.getdefaultchargeList(pol,crnyName);			
		}catch(Exception e){
			e.printStackTrace();
		}
		return listBean;
	}
	@RequestMapping(value = "/ExportExcel", method = RequestMethod.POST)
	public QuotationRateBean ExportExcel(@RequestBody QuotationRateBean reffbean) throws Exception {
	// TODO Auto-generated method stub
//	QuotationRateResultBean list;
	try {

	 List<QuotationRateBean> list=quotationService.listFilter(reffbean);
	 
	if (list.size() == 0) {
		QuotationRateBean bean=new QuotationRateBean();
	list.add(bean);
	}
	if (list.size() > 0) {
	String fileName = ConfigurationProps.exportFilesPath + "/Quotation.xls";
	System.out.println(fileName);
	WritableWorkbook workbook = jxl.Workbook.createWorkbook(new File(fileName));
	//workbook.createSheet("Report", 0);
	WritableSheet excelSheet = workbook.createSheet("Report", 0);
	workbook.write();
	workbook.close();
	try (OutputStream os = new FileOutputStream(fileName)) {
	List<String> headers = Arrays.asList("QUOTATION NO","QUOTATION DATE","CUSTOMER","POL","FPOD","IS VALID","SUBMITTED BY","LOCATION","APPORVAL STATUS","BOOKING STATUS");
	Context context = new Context();
	context.putVar("subLedger", list);
	SimpleExporter exporter = new SimpleExporter();

	exporter.gridExport(headers,list,"quotationNo,quotationDate,customer,pol,pod,status,user,location,status1,bookingStatus", os);
	
	} catch (Exception e) {
	}
	}
	} catch (DataAccessException e) {
	e.printStackTrace();
	} catch (IOException e1) {
	e1.printStackTrace();
	} catch (WriteException e1) {
	e1.printStackTrace();
	}
	return reffbean;

	}
	@RequestMapping("/getCustomereditDropdown")
	public @ResponseBody List<SelectivityBean> getCustomerListFilter(@RequestParam("quoteNo") String quoteNo) throws CustomException {
		List<SelectivityBean> lCustomerList = new ArrayList<SelectivityBean>();
		try {
			lCustomerList = quotationService.getCustomereditDropdown(quoteNo);
		} catch (Exception e) {
			throw new CustomException();
		}

		return lCustomerList;
	}
	
	@RequestMapping("/print")
	public ModelAndView printInvoice(@RequestParam("quotationNo") String quotationNo )
			throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView obj = null;
		obj = new ModelAndView("air/seaQuotation/seaQuotationPrint");

		QuotationRateResultBean quotationResultBean = new QuotationRateResultBean();
		QuotationRateBean objGeneralInvoiceBean = new QuotationRateBean();
		quotationResultBean = quotationService.edit(quotationNo);
		obj.addObject("masterList", quotationResultBean.getSeaQuotationBean());
		obj.addObject("middleList", quotationResultBean.getlQuotationBean());
		obj.addObject("freedaysList", quotationResultBean.getQuotationFreeDaysDtl());

		return obj;
	}
	
	@RequestMapping(value = "/savereview")
	public @ResponseBody QuotationRateResultBean savereview(@RequestBody QuotationRateBean bean) {
		System.out.println("test-------");
		QuotationRateResultBean rb = null;
 		try {			 
			rb = quotationService.savereview(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	

	@RequestMapping(value = "/getmrgRate")
	public @ResponseBody QuotationRateBean getmrgRate(@RequestParam("mlo") String mlo,@RequestParam("pod") String pod,@RequestParam("pol") String pol,@RequestParam("containerType") String containerType) throws CustomException {

		QuotationRateBean bean  =new QuotationRateBean();
 		try {			 
 			bean = quotationService.getmrgRate(mlo,pod,pol,containerType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@RequestMapping(value = "/gettariffRate")
	public @ResponseBody QuotationRateBean gettariffRate(@RequestParam("mlo") String mlo,@RequestParam("pod") String pod,@RequestParam("pol") String pol,@RequestParam("containerType") String containerType) throws CustomException {

		QuotationRateBean bean  =new QuotationRateBean();
 		try {			 
 			bean = quotationService.gettariffRate(mlo,pod,pol,containerType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
}
