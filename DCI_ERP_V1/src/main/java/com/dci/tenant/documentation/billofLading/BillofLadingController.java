package com.dci.tenant.documentation.billofLading;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.ConfigurationProps;
import com.dci.tenant.user.UserDetail;


  @RestController
@RequestMapping(value = "{tenantid}/api/billofLading")
public class BillofLadingController {
	
		@Autowired
		private BillofLadingService billofLadingService;
		
		@RequestMapping(value = "/create" ,method = RequestMethod.POST)
		public BillofLadingBean save(@RequestBody BillofLadingBean billofLading) {
			BillofLadingBean objbranchResultBean = new BillofLadingBean();
			try {
				objbranchResultBean = billofLadingService.insert(billofLading);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return objbranchResultBean;

		}
		
		@GetMapping("/vslvoyagedropdown")
		public List<SelectivityBean> getDropDown() {
		
			List<SelectivityBean> List = new ArrayList<>();
			
			List=billofLadingService.getDropDown();

			return List;
		}
		
		@RequestMapping("/getIssuePlace")
		public List<SelectivityBean> getIssuePlace() {
		
			List<SelectivityBean> list = new ArrayList<SelectivityBean>();
			
			list=billofLadingService.getIssuePlace();

			return list;
		}
		
		@RequestMapping("/getAgentList")
		public List<SelectivityBean> getAgentList() {
		
			List<SelectivityBean> list = new ArrayList<SelectivityBean>();
			
			list=billofLadingService.getAgentList();

			return list;
		}
		
		@RequestMapping("/getBookingList")
		public List<SelectivityBean> getBookingList() {
		
			List<SelectivityBean> list = new ArrayList<SelectivityBean>();
			
			list=billofLadingService.getBookingList();

			return list;
		}
		
		@RequestMapping("/shipmentList")
		public List<SelectivityBean> shipmentList() {
		
			List<SelectivityBean> list = new ArrayList<SelectivityBean>();
			
			list=billofLadingService.shipmentList();

			return list;
		}
		
		@RequestMapping("/getConatinerTypeList")
		public List<SelectivityBean> getConatinerTypeList() {
		
			List<SelectivityBean> list = new ArrayList<SelectivityBean>();
			
			list=billofLadingService.getConatinerTypeList();

			return list;
		}
		
		@RequestMapping("/getPackageTypeList")
		public List<SelectivityBean> getPackageTypeList() {
		
			List<SelectivityBean> list = new ArrayList<SelectivityBean>();
			
			list=billofLadingService.getPackageTypeList();

			return list;
		}
		
		@RequestMapping("/getSurChargeList")
		public List<SelectivityBean> getSurChargeList() {
		
			List<SelectivityBean> list = new ArrayList<SelectivityBean>();
			
			list=billofLadingService.getSurChargeList();

			return list;
		}
		
		@RequestMapping("/getContainerList")
		public List<SelectivityBean> getContainerList() {
		
			List<SelectivityBean> list = new ArrayList<SelectivityBean>();
			
			list=billofLadingService.getContainerList();

			return list;
		}
		
		
		@GetMapping("/list")
		public List<BillofLadingBean> getList() throws Exception {
			System.out.println("Get all BLList...");

			List<BillofLadingBean> billofLadingList = new ArrayList<>();
			
			billofLadingList=billofLadingService.getBlList();

			return billofLadingList;
		}
		
		@GetMapping(value = "/Export")
		public @ResponseBody List<BillofLadingBean>  getExcelReportExportList()  {
			BillofLadingBean billofLading= new BillofLadingBean();
			XSSFWorkbook workbook = new XSSFWorkbook();
			List<BillofLadingBean> blList = new ArrayList<BillofLadingBean>();
 
			try {
						
				System.out.println("Export Bl Of excel");

				blList = billofLadingService.getList();

				  workbook =		billofLadingService.excellExport(blList,
						billofLading, ConfigurationProps.exportFilesPath);
 				billofLading.setIsSuccess(true);
			} catch (Exception e) {
				System.out.println(e);

			}
			return blList;
		}
		@RequestMapping(value ="/print")
		public @ResponseBody ModelAndView print(@RequestParam("blNo") String blNo)  {
			ModelAndView mv = null;
			try {
					List<BillofLadingBean> bean = (List<BillofLadingBean>) billofLadingService.print(blNo);
				mv = new ModelAndView("billofLadingviewComponent");
				mv.addObject("bean", bean);
			} catch (Exception e) {
				System.out.println(e);
			}
			return mv;
		}

		@RequestMapping(value="/edit") 
		public BillofLadingBean getDamageEdit(@RequestParam("blNo") String blNo) {
		
			BillofLadingBean billofLading = new BillofLadingBean();
			
			billofLading=billofLadingService.getBlEdit(blNo);

			return billofLading;
		}
		
		@RequestMapping(value = "/update" ,method = RequestMethod.POST)
		public BillofLadingBean Update(@RequestBody BillofLadingBean billofLading) {
			BillofLadingBean objbranchResultBean = new BillofLadingBean();
			try {
				objbranchResultBean = billofLadingService.update(billofLading);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return objbranchResultBean;

		}
		@DeleteMapping(value="/delete/{blNo}") 
		public BillofLadingBean delete(@PathVariable String blNo)
		 {
			BillofLadingBean billofLading = new BillofLadingBean();
			billofLading = billofLadingService.delete(blNo);
			return billofLading;
			
		}
		
		@RequestMapping(value = "/printcountOrgnl")
		public BillofLadingResultBean getcountPrintOrgnl(@RequestParam("blNo") String blNo) {
			BillofLadingResultBean bean = new BillofLadingResultBean();
			int i=0;
			try {
				String original = "OG";
				
				bean = billofLadingService.getcountPrint(blNo,original);
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return bean;

		}
		
		@RequestMapping(value = "/printcountOrgnlSta")
		public BillofLadingResultBean printcountOrgnlSta(@RequestParam("blNo") String blNo) {
			BillofLadingResultBean bean = new BillofLadingResultBean();
			int i=0;
			try {
				String original = "OGS";
				
				bean = billofLadingService.getcountPrint(blNo,original);
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return bean;

		}
		
		
		@RequestMapping(value = "/printcountCopy")
		public BillofLadingResultBean getcountPrintCopy(@RequestParam("blNo") String blNo) {
			BillofLadingResultBean bean = new BillofLadingResultBean();
			int i=0;
			try {
				String copy = "CO";
				bean = billofLadingService.getcountPrint(blNo,copy);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return bean;

		}
		
		@RequestMapping(value = "/printcountCopyWithSta")
		public BillofLadingResultBean getcountPrintCopyWithSta(@RequestParam("blNo") String blNo) {
			BillofLadingResultBean bean = new BillofLadingResultBean();
			int i=0;
			try {
				String copy = "COS";
				bean = billofLadingService.getcountPrint(blNo,copy);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return bean;

		}
		
		//Print Original Method
		@RequestMapping("/printblinward")
		public ModelAndView printBLOrgn(@RequestParam("blNo") String blNo )	throws Exception {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			ModelAndView obj = null;
			String compLoc = userDetails.getCompanyCode();
			BillofLadingResultBean blladingResultBean = new BillofLadingResultBean();
			blladingResultBean.setBlBean(billofLadingService.printBL(blNo));
//			blladingResultBean.setBlcntrDtlList(billofLadingService.printDetailList(blNo));
//			invoiceResultBean.setSlotmessageList(invoiceService.slotmessageList(invoiceResultBean.getInvoice(), invoiceResultBean.getSearchList()));
//			blladingResultBean.setSuccess(true);
			int str = billofLadingService.seqPrint(blNo,"OG");
			blladingResultBean.getBlBean().setPageCount(str+1);
			System.out.println("B/L Print Count - "+blladingResultBean.getBlBean().pageCount);
//			if (str<3) {
				obj = new ModelAndView("documents/blLadding/printBLOrgn");
				obj.addObject("masterList", blladingResultBean.getBlBean());
			
//			} else if (str<6) {
//				obj = new ModelAndView("documents/blLadding/printBLDummy");
//				obj.addObject("masterList", blladingResultBean.getBlBean());
//			}
//			obj.addObject("middleList", blladingResultBean.getBlcntrDtlList());
//			obj.addObject("containerList", invoiceResultBean.getSlotmessageList());
			return obj;
		}
		
		//Print Original Method
		@RequestMapping("/printbloutward")
		public ModelAndView printBLCopy(@RequestParam("blNo") String blNo )	throws Exception {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			ModelAndView obj = null;
			String compLoc = userDetails.getCompanyCode();
			BillofLadingResultBean blladingResultBean = new BillofLadingResultBean();
			blladingResultBean.setBlBean(billofLadingService.printBL(blNo));
//			blladingResultBean.setBlcntrDtlList(billofLadingService.printDetailList(blNo));
//			invoiceResultBean.setSlotmessageList(invoiceService.slotmessageList(invoiceResultBean.getInvoice(), invoiceResultBean.getSearchList()));
//			blladingResultBean.setSuccess(true);
			int str = billofLadingService.seqPrint(blNo,"CO");
			blladingResultBean.getBlBean().setPageCount(str+1);
			System.out.println("B/L Print Count - "+blladingResultBean.getBlBean().pageCount);
//			if (str<3) {
//				obj = new ModelAndView("documents/blLadding/printBLOrgn");
//				obj.addObject("masterList", blladingResultBean.getBlBean());
//			
//			} else if (str<6) {
				obj = new ModelAndView("documents/blLadding/printBLDummy");
				obj.addObject("masterList", blladingResultBean.getBlBean());
//			}
//			obj.addObject("middleList", blladingResultBean.getBlcntrDtlList());
//			obj.addObject("containerList", invoiceResultBean.getSlotmessageList());
			return obj;
			}
		
	}

