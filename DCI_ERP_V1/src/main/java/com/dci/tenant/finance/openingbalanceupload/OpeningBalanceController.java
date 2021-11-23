package com.dci.tenant.finance.openingbalanceupload;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "/app/finance/openingBalance")
public class OpeningBalanceController {

	/*
	 * private final static Logger LOGGER =
	 * LoggerFactory.getLogger(branchController.class);
	 */

	@Autowired
	private OpeningBalanceService branchService;

	@RequestMapping(value = "/list")
	public OpeningBalanceResultBean getbranchList() throws Exception {
		OpeningBalanceResultBean branchResultBean = new OpeningBalanceResultBean();
		try {

			branchResultBean.setOpeningBalanceList(branchService.getBranchList());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return branchResultBean;

	}

	@RequestMapping("/getData")
	public @ResponseBody OpeningBalanceResultBean getJournalVoucherList(@RequestBody OpeningBalanceBean journalVoucherBean) throws CustomException {
		OpeningBalanceResultBean objJournalVoucherResultBean = new OpeningBalanceResultBean();
		try {
			objJournalVoucherResultBean.setOpeningBalanceList(branchService.getJournalVoucherList(journalVoucherBean));
			objJournalVoucherResultBean.setSuccess(true);
		} catch (Exception e) {

			throw new CustomException();
		}
		return objJournalVoucherResultBean;
	}

	@RequestMapping(value = "/drop")
	public OpeningBalanceResultBean getdropList() throws Exception {
		OpeningBalanceResultBean branchResultBean = new OpeningBalanceResultBean();
		try {

			branchResultBean = branchService.getdropList();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return branchResultBean;

	}

	@RequestMapping(value = "/save")
	OpeningBalanceResultBean save(@RequestBody OpeningBalanceBean mablBean) {
		OpeningBalanceResultBean ResultBean = new OpeningBalanceResultBean();
		try {
			ResultBean = branchService.save(mablBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultBean;

	}

	@RequestMapping(value = "/generateJv")
	OpeningBalanceResultBean generateJv(@RequestBody OpeningBalanceBean mablBean) {
		OpeningBalanceResultBean ResultBean = new OpeningBalanceResultBean();
		try {
			ResultBean = branchService.generateJv(mablBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultBean;

	}

	@RequestMapping(value = "/edit")
	OpeningBalanceResultBean editMabl(@RequestParam("transactionid") int transactionid) {
		OpeningBalanceResultBean mablResultBean = new OpeningBalanceResultBean();
		try {
			mablResultBean = branchService.editMabl(transactionid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mablResultBean;

	}

	@RequestMapping(value = "/update")
	OpeningBalanceResultBean update(@RequestBody OpeningBalanceBean mablBean) {
		OpeningBalanceResultBean ResultBean = new OpeningBalanceResultBean();
		try {
			ResultBean = branchService.update(mablBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultBean;

	}

	@RequestMapping(value = "/ExportExcel")
	public @ResponseBody OpeningBalanceResultBean getExcelReportExportList(@RequestBody OpeningBalanceBean objFeeBean, HttpServletRequest request, HttpServletResponse response) throws CustomException {
		OpeningBalanceResultBean feeResultBean = new OpeningBalanceResultBean();

		try {

			System.out.println("List Of  fee excel");
			OpeningBalanceBean FeeBeanobj = new OpeningBalanceBean();
			List<OpeningBalanceBean> feeList = new ArrayList<>();
			String sFilePath = request.getServletContext().getRealPath("tempdoc");

			feeList = branchService.getBranchList1(objFeeBean);

			branchService.excellExport(feeList, FeeBeanobj, ConfigurationProps.exportFilesPath);
           if(feeList.size()>0) {
			feeResultBean.setSuccess(true);
           }else {
	         feeResultBean.setSuccess(false);

       }
		} catch (Exception e) {
			System.out.println(e);

		}
		return feeResultBean;
	}

	@RequestMapping("/uploadEmployeeExcel")
	public @ResponseBody OpeningBalanceResultBean uploadMemberExcel(MultipartFile file) throws Exception {
		OpeningBalanceResultBean DwellTimeInvoice = new OpeningBalanceResultBean();
		boolean isSuccess = false;
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					DwellTimeInvoice = branchService.uploadFile(file);
					if (DwellTimeInvoice.isSuccess()) {
						DwellTimeInvoice.setSuccess(true);
						DwellTimeInvoice.setMessage("Verify Excel Data Before Upload");
					} else {
						DwellTimeInvoice.setSuccess(false);

					}
				}
			}
		} catch (Exception e) {
			DwellTimeInvoice.setSuccess(false);
			DwellTimeInvoice.setMessage(e.getMessage());
		}
		return DwellTimeInvoice;
	}

	// UPLOAD FILE
	@RequestMapping("/uploadfile")
	public @ResponseBody OpeningBalanceResultBean uploadFile(MultipartFile file) throws CustomException {
		OpeningBalanceResultBean bookingRequest = new OpeningBalanceResultBean();
		String errorMessage = "";
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx") || fileName.endsWith("XLS") || fileName.endsWith("XLSX")) {
					errorMessage = branchService.uploadFile1(file);
					if (errorMessage.isEmpty()) {
						bookingRequest.setSuccess(true);
					} else {
						bookingRequest.setMessage(errorMessage);
						bookingRequest.setSuccess(false);
					}
				} else {
					bookingRequest.setSuccess(false);
					bookingRequest.setMessage("Not a valid file format");
					System.out.println("Not a valid file format");
				}

			} else {
				bookingRequest.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookingRequest;
	}

}