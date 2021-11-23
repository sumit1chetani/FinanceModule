package com.dci.operation.containerReleaseOrder;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;


@RestController
@RequestMapping(value = "{tenantid}/app/container")   
public class containerReleaseOrderController {

	@Autowired
	containerReleaseOrderService quotationService;
	
	@RequestMapping(value = "/save")
	public @ResponseBody containerReleaseOrderResultBean save(@RequestBody containerReleaseOrderBean bean) {
		System.out.println("test-------");
		containerReleaseOrderResultBean rb = null;
 		try {			 
			rb = quotationService.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
 		return rb;
	}
	
	@RequestMapping("/printbookingConfirm")
	public ModelAndView printbookingConfirm(@RequestParam("containerreleaseCode") String containerreleaseCode )	throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView obj = null;
		String compLoc = userDetails.getCompanyCode();
		containerReleaseOrderPrintBean print = new containerReleaseOrderPrintBean();
		print=quotationService.printBL(containerreleaseCode);
		obj = new ModelAndView("operation/containerReleaseOrder/containerReleaseOrderPrint");
			obj.addObject("headerDetails",print);
			/*obj.addObject("listDetails", null);
			obj.addObject("name", null);
			obj.addObject("jobInvoiceDetails", null);*/
	
		
		return obj;
	}
	
	
	
	@RequestMapping("/printreleaseorder")
	public ModelAndView printreleaseOrder(@RequestParam("containerreleaseCode") String containerreleaseCode )	throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView obj = null;
		String compLoc = userDetails.getCompanyCode();
		containerReleaseOrderPrintBean print = new containerReleaseOrderPrintBean();
		print=quotationService.printreleaseOrder(containerreleaseCode);
		obj = new ModelAndView("operation/containerReleaseOrder/printcontainerReleaseOrder");
			obj.addObject("headerDetails",print);
			/*obj.addObject("listDetails", null);
			obj.addObject("name", null);
			obj.addObject("jobInvoiceDetails", null);*/
	
		
		return obj;
	}
	
	/*@RequestMapping("/printCRO")
	public ModelAndView printCRO(@RequestParam("containerreleaseCode") String containerreleaseCode )	throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView obj = null;
		String compLoc = userDetails.getCompanyCode();
		containerReleaseOrderPrintBean print = new containerReleaseOrderPrintBean();
		print=quotationService.printCRO(containerreleaseCode);
		obj = new ModelAndView("operation/containerReleaseOrder/containerReleaseOrderPrintCRO1");
			obj.addObject("headerDetails",print);
			obj.addObject("ConList", print.getContainerDtl());
			obj.addObject("name", null);
			obj.addObject("jobInvoiceDetails", null);
	
		
		return obj;
	}*/
	@RequestMapping("/printCRO")
	public ModelAndView printCRO(@RequestParam("containerreleaseCode") String containerreleaseCode )	throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView obj = null;
		String compLoc = userDetails.getCompanyCode();
		printcontainerReleaseOrderBean print = new printcontainerReleaseOrderBean();
		print=quotationService.printCRO(containerreleaseCode);
		obj = new ModelAndView("operation/containerReleaseOrder/containerReleaseOrderPrintCRO1");
			obj.addObject("headerDetails",print);
			obj.addObject("ConList", print.getContainerList());
			/*obj.addObject("name", null);
			obj.addObject("jobInvoiceDetails", null);*/
	
		
		return obj;
	}
	

	@RequestMapping(value = "/getShipment")
	public @ResponseBody containerReleaseOrderResultBean getShipment() {
		System.out.println("test-------1222");
		containerReleaseOrderResultBean rb = null;
 		try {			 
			//rb = quotationService.save();
 			rb=quotationService.getShipment();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	@RequestMapping(value = "/saveasDraft")
	public @ResponseBody containerReleaseOrderResultBean saveasDraft(@RequestBody containerReleaseOrderBean bean) {
		containerReleaseOrderResultBean rb = null;
 		try {			 
			rb = quotationService.saveasDraft(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
		
	@RequestMapping(value = "/getcustomerdetail")
	public containerReleaseOrderResultBean getcustomerdetail(@RequestBody String custId) {
		System.out.println("testedit----------");
		containerReleaseOrderResultBean rb = null;
 		try {			 
			rb = quotationService.getCustomerDetail(custId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	
	@RequestMapping(value = "/getContainerTypeByBooking")
	public List<SelectivityBean> getContainerTypeByBooking(@RequestParam("bookingNo") String bookingNo,@RequestParam("isEdit")  boolean isEdit,@RequestParam("conHdrCode") String conHdrCode) {
		System.out.println("testedit----------");
		List<SelectivityBean>  bean = new ArrayList<SelectivityBean>();
 		try {			 
 			bean = quotationService.getContainerTypeByBooking(bookingNo,isEdit,conHdrCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	@RequestMapping(value = "/getcustomerpolpod")
	public containerReleaseOrderResultBean getcustomerpolpod(@RequestBody String custId) {
		System.out.println("testedit----------");
		containerReleaseOrderResultBean rb = null;
 		try {			 
			rb = quotationService.getcustomerpolpod(custId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}

	@RequestMapping(value = "/list")
	public @ResponseBody  containerReleaseOrderResultBean list() {
		containerReleaseOrderResultBean rb = null;
 		try {			 
			rb = quotationService.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	@RequestMapping(value = "/edit")
	public containerReleaseOrderResultBean edit(@RequestBody String QuotHdId) {
		System.out.println("testedit----------");
		containerReleaseOrderResultBean rb = null;
 		try {			 
			rb = quotationService.edit(QuotHdId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	
	@RequestMapping(value = "/view")
	public containerReleaseOrderResultBean view(@RequestBody Integer QuotHdId) {
		containerReleaseOrderResultBean rb = null;
 		try {			 
			rb = quotationService.view(QuotHdId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	
	
	@RequestMapping(value = "/update")
	public containerReleaseOrderResultBean update(@RequestBody containerReleaseOrderBean bean) {
		containerReleaseOrderResultBean rb = null;
 		try {			 
			rb = quotationService.update(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	
	@RequestMapping(value = "/delete")
	public containerReleaseOrderResultBean delete(@RequestBody String  quotationNo) {
		containerReleaseOrderResultBean rb = null;
 		try {			 
			rb = quotationService.delete(quotationNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
	
	
	@RequestMapping(value = "/uploadEmployeeExcel")
	public @ResponseBody containerReleaseOrderResultBean uploadMemberExcel(MultipartFile file) throws Exception {
		containerReleaseOrderResultBean DwellTimeInvoice = new containerReleaseOrderResultBean();
		boolean isSuccess = false;
		try {
			System.out.println("excel upload");
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					DwellTimeInvoice = quotationService.uploadEmployeeExcel(file);
					if (DwellTimeInvoice.isSuccess()) {
						DwellTimeInvoice.setSuccess(true);
						DwellTimeInvoice.setMessage("Verify Excel Data Before Upload");
					} else {
						DwellTimeInvoice.setSuccess(false);

					}
				}
			}	
		} catch (CustomException e) {
			DwellTimeInvoice.setSuccess(false);
			DwellTimeInvoice.setMessage(e.getCustomMessage());
		}
		return DwellTimeInvoice;
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
	public @ResponseBody containerReleaseOrderResultBean downloadfile(@RequestBody String quotationNo) throws CustomException {
		containerReleaseOrderResultBean Bean = new containerReleaseOrderResultBean();
		try {
			
			Bean = quotationService.DownloadFile(quotationNo);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Bean;
	}
	
	@RequestMapping("/getServicePartnerList")
	public @ResponseBody containerReleaseOrderResultBean getServicePartnerDropdownList() throws CustomException {
		containerReleaseOrderResultBean res = new containerReleaseOrderResultBean();

		try {
			res=quotationService.getServicePartnerDropdownList();
			res.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return res;
	}
	
	@RequestMapping("/getServicePartnerListid")
	public @ResponseBody containerReleaseOrderResultBean getServicePartnerDropdownListid(@RequestParam("id") String id) throws CustomException {
		containerReleaseOrderResultBean res = new containerReleaseOrderResultBean();

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
	public @ResponseBody containerReleaseOrderResultBean viewSeaQuotationMail(@RequestParam("quotationHdId") Integer quotationHdId) throws Exception {
		//ModelAndView obj = null;
		//obj = new ModelAndView("air/seaQuotation/seaQuotationPrint");
		containerReleaseOrderResultBean QuotationResultBean = new containerReleaseOrderResultBean();
		containerReleaseOrderBean objGeneralInvoiceBean = new containerReleaseOrderBean();
		objGeneralInvoiceBean = quotationService.print(quotationHdId);
		QuotationResultBean.setSeaQuotationBean(objGeneralInvoiceBean);
		/*obj.addObject("masterList", objGeneralInvoiceBean);
		obj.addObject("detailList", objGeneralInvoiceBean.getQuotationDtl());*/

		return QuotationResultBean;
	}
	
	//For contra
	
	@RequestMapping("/getCustomerList")
	public @ResponseBody containerReleaseOrderResultBean getCustomerList() throws CustomException {
		containerReleaseOrderResultBean res = new containerReleaseOrderResultBean();

		try {
			res=quotationService.getCustomerList();
			res.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return res;
	}
	
	@RequestMapping("/getCustomerListCompany")
	public @ResponseBody containerReleaseOrderResultBean getCustomerListCompany(@RequestParam("company") String company) throws CustomException {
		containerReleaseOrderResultBean res = new containerReleaseOrderResultBean();

		try {
			res=quotationService.getCustomerListCompany(company);
			res.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}

		return res;
	}

	
	@RequestMapping("/containerType")
	public List<containerReleaseOrderBean> getContainerTypeDropDown() {
	
		List<containerReleaseOrderBean> List = new ArrayList<>();
		
		List=quotationService.getContainerTypeDropDown();

		return List;
	}
	
	/*@RequestMapping(value="/excelexport", method=RequestMethod.POST)
	public @ResponseBody containerReleaseOrderResultBean save(@RequestBody containerReleaseOrderBean bean,HttpServletRequest request,
			HttpServletResponse response) throws CustomException {
		containerReleaseOrderResultBean resultBean=new containerReleaseOrderResultBean();
		try{
			resultBean.setContainerReleaseOrderBean(quotationService.getEmptyList(bean));
			quotationService.generateExcel(resultBean,bean,ConfigurationProps.exportFilesPath);
			
		}
		catch(Exception e) {
			
			throw new CustomException();
		}
		return resultBean; 
	}
*/	
	
	
	
	@RequestMapping(value="/excelexport") 
	public containerReleaseOrderBean excelexport(@RequestParam("containerreleaseCode") String containerreleaseCode) throws CustomException {
	
		containerReleaseOrderBean containerReleaseOrderBean = new containerReleaseOrderBean();
		containerReleaseOrderResultBean resultBean=new containerReleaseOrderResultBean();
		try{
			containerReleaseOrderBean=quotationService.export(containerreleaseCode);
		//quotationService.generateExcel(resultBean,containerreleaseCode,ConfigurationProps.exportFilesPath);
		}
      catch(Exception e) {
			throw new CustomException();
		} 
		return containerReleaseOrderBean;
	}
	
	@RequestMapping(value="/sendMail") 
	public containerReleaseOrderResultBean sendMail(@RequestBody String cntRelNo) throws CustomException {
	
		containerReleaseOrderResultBean resultBean=new containerReleaseOrderResultBean();
		try{
			resultBean.setSuccess(false);
			quotationService.sendCROMail(cntRelNo);
			resultBean.setSuccess(true);
		}
      catch(Exception e) {
			throw new CustomException();
		} 
		return resultBean;
	}
}

	
	/*@RequestMapping(value = "/excelexport" ,method = RequestMethod.POST)
	public @ResponseBody EmptyReportResultBean save(@RequestBody EmptyReportBean bean,HttpServletRequest request,
			HttpServletResponse response) throws CustomException {
	EmptyReportResultBean resultBean = new EmptyReportResultBean();
		try {
			
			resultBean.setEmptyReportbean(emptyreportservice.getEmptyList(bean));
			emptyreportservice.generateExcel(resultBean,bean,ConfigurationProps.exportFilesPath);

		} catch (Exception e) {
//			LOGGER.error("Error", e);
			throw new CustomException();

		}
		return resultBean; 

	
	
	}*/
