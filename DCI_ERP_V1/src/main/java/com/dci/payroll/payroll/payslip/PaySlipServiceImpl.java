package com.dci.payroll.payroll.payslip;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dci.common.util.CommonUtil;
import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.common.util.MailConstants;
import com.dci.hrms.report.employeeEarlyStart.EmployeeEarlyStartBean;
import com.dci.payroll.payroll.payrollreport.PayrollReportDAO;
import com.dci.tenant.common.Email;
import com.dci.tenant.user.UserDetail;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


@Service
public class PaySlipServiceImpl implements PaySlipService {

	@Autowired
	PaySlipDAO paySlipDAO;

	@Autowired
	PayrollReportDAO payrollReportDAO;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public PaySlipListDTO getPaySlipList(String companyId, String branchId, String dept, String employeeId, String monthYear) throws Exception {
		// TODO Auto-generated method stub
		List<EmployeeEarlyStartBean> empdetailList = new ArrayList<>();
		PaySlipResultBean ojjs = new PaySlipResultBean();
		List<PaySlipBean> paySlipList = null;

		double employeeLeaveAvailable = 0.00;
		double employeeLeaveTaken = 0.00;

		NumberFormat formatter = new DecimalFormat("#0.00");

		PaySlipListDTO payLsPaySlipListDTO = new PaySlipListDTO();

		PaySlipDTO paySlipdto = new PaySlipDTO();

		String tempEmpid = null;
		paySlipList = paySlipDAO.getPaySlipList(companyId, branchId, dept, employeeId, monthYear);
		// empdetailList = paySlipDAO.getEmpDetailList(employeeId);
		ojjs = paySlipDAO.getEmpDetailList(employeeId);

		List<EmployeeEarlyStartBean> list = ojjs.getEmpdetailList();

		for (int j = 0; j < list.size(); j++) {

			EmployeeEarlyStartBean dtbean = list.get(j);
			employeeLeaveAvailable = Double.parseDouble(dtbean.getAllowedLeave()) + employeeLeaveAvailable;
			employeeLeaveTaken = Double.parseDouble(dtbean.getConsumed()) + employeeLeaveTaken;
		}

		employeeLeaveAvailable = employeeLeaveAvailable - employeeLeaveTaken;

		int i = 1;

		for (PaySlipBean paySlip : paySlipList) {

			if (tempEmpid == null) {
				tempEmpid = paySlip.getEmployeeId();
				paySlipdto = new PaySlipDTO();

			}

			if (tempEmpid.equals(paySlip.getEmployeeId())) {

				paySlipdto.setLeaveTaken((int) employeeLeaveTaken);
				paySlipdto.setLeaveAvailable((int) employeeLeaveAvailable);
				paySlipdto.setLopDays(paySlip.getLopDays());
				if (paySlip.getPayComponentId().equalsIgnoreCase("LOPAM")) {
					paySlipdto.setLopAmount(paySlip.getLopAmount());
				}
				paySlipdto.setEmployeeLeaveTaken(employeeLeaveTaken);
				paySlipdto.setEmployeeLeaveAvailable(employeeLeaveAvailable);

			}

			if (tempEmpid.equals(paySlip.getEmployeeId())) {

				paySlipdto.setEmpId(paySlip.getEmployeeId());
				paySlipdto.setEmpName(paySlip.getEmployeeName());
				paySlipdto.setDept(paySlip.getDept());
				paySlipdto.setMonth_year(paySlip.getMonth_year());
				paySlipdto.setCompany(paySlip.getCompany());
				paySlipdto.setEpfno(paySlip.getEpfno());
				paySlipdto.setUanno(paySlip.getUanno());
				paySlipdto.setDesgination(paySlip.getDesgination());
				paySlipdto.setBankno(paySlip.getBankno());
				paySlipdto.setDoj(paySlip.getDoj());
				paySlipdto.setEsicode(paySlip.getEsicode());
				paySlipdto.setPaycomponentname(paySlip.getPaycomponentname());
				paySlipdto.setPaybankname(paySlip.getPaybankname());
				paySlipdto.setCmpyadd(paySlip.getCmpyadd());
				paySlipdto.setMonthYear(paySlip.getMonthYear());



				
				if (paySlip.getPayComponentType() == 1) {
					paySlipdto.getEarningsList().add(paySlip);
					paySlipdto.setTotalEarnings(paySlipdto.getTotalEarnings() + paySlip.getAmount());
					paySlipdto.setAmount(Math.round((int) paySlip.getAmount()));
					paySlipdto.setPrintamount(paySlipdto.getAmount());
				//} else if (!paySlip.getPayComponentId().equalsIgnoreCase("EPS") && !paySlip.getPayComponentId().equalsIgnoreCase("EPF") && !paySlip.getPayComponentId().equalsIgnoreCase("EDLI") && !paySlip.getPayComponentId().equalsIgnoreCase("ADMC")) {
					} else if (!paySlip.getPayComponentId().equalsIgnoreCase("EPS")  && !paySlip.getPayComponentId().equalsIgnoreCase("EDLI") && !paySlip.getPayComponentId().equalsIgnoreCase("ADMC")) {

					paySlipdto.getDeductionsList().add(paySlip);
					// if
					// (!paySlip.getPayComponentId().equalsIgnoreCase("LOPAM"))
					// {
					paySlipdto.setTotalDeductions(paySlipdto.getTotalDeductions() + paySlip.getAmount() + paySlip.getLopAmount());
					// }
					paySlipdto.setAmount(Math.round((int) paySlip.getAmount()));
					paySlipdto.setPrintamount(paySlipdto.getAmount());
				}
				tempEmpid = paySlip.getEmployeeId();

				if (paySlipList.size() == i) {
					payLsPaySlipListDTO.getPaySlipList().add(paySlipdto);
				}

			} else {

				payLsPaySlipListDTO.getPaySlipList().add(paySlipdto);
				paySlipdto = new PaySlipDTO();

				paySlipdto.setLeaveTaken((int) employeeLeaveTaken);
				paySlipdto.setLeaveAvailable((int) employeeLeaveAvailable);
				paySlipdto.setLopDays(paySlip.getLopDays());

				if (paySlip.getPayComponentId().equalsIgnoreCase("LOPAM")) {
					paySlipdto.setLopAmount(paySlip.getLopAmount());
				}
				// paySlipdto.setLopAmount(paySlip.getLopAmount());
				paySlipdto.setEmployeeLeaveTaken(employeeLeaveTaken);
				paySlipdto.setEmployeeLeaveAvailable(employeeLeaveAvailable);

				paySlipdto.setEmpId(paySlip.getEmployeeId());
				paySlipdto.setEmpName(paySlip.getEmployeeName());
				paySlipdto.setDept(paySlip.getDept());
				paySlipdto.setMonth_year(paySlip.getMonth_year());
				paySlipdto.setCompany(paySlip.getCompany());
				paySlipdto.setEpfno(paySlip.getEpfno());
				paySlipdto.setUanno(paySlip.getUanno());
				paySlipdto.setDesgination(paySlip.getDesgination());
				paySlipdto.setBankno(paySlip.getBankno());
				paySlipdto.setDoj(paySlip.getDoj());
				paySlipdto.setEsicode(paySlip.getEsicode());
				paySlipdto.setPaycomponentname(paySlip.getPaycomponentname());
				paySlipdto.setPaybankname(paySlip.getPaybankname());
				paySlipdto.setCmpyadd(paySlip.getCmpyadd());
				paySlipdto.setMonthYear(paySlip.getMonthYear());

				


				if (paySlip.getPayComponentType() == 1) {
					paySlipdto.getEarningsList().add(paySlip);
					paySlipdto.setTotalEarnings(paySlipdto.getTotalEarnings() + paySlip.getAmount());
					paySlipdto.setAmount(Math.round((int) paySlip.getAmount()));
					paySlipdto.setPrintamount(paySlipdto.getAmount());

			//	} else if (!paySlip.getPayComponentId().equalsIgnoreCase("EPS") && !paySlip.getPayComponentId().equalsIgnoreCase("EPF") && !paySlip.getPayComponentId().equalsIgnoreCase("EDLI") && !paySlip.getPayComponentId().equalsIgnoreCase("ADMC")) {
						} else if (!paySlip.getPayComponentId().equalsIgnoreCase("EPS")  && !paySlip.getPayComponentId().equalsIgnoreCase("EDLI") && !paySlip.getPayComponentId().equalsIgnoreCase("ADMC")) {

					paySlipdto.getDeductionsList().add(paySlip);
					// if
					// (!paySlip.getPayComponentId().equalsIgnoreCase("LOPAM"))
					// {
					paySlipdto.setTotalDeductions(paySlipdto.getTotalDeductions() + paySlip.getAmount() + paySlip.getLopAmount());
					// }
					paySlipdto.setAmount(Math.round((int) paySlip.getAmount()));
					paySlipdto.setPrintamount(paySlipdto.getAmount());

				}
				tempEmpid = paySlip.getEmployeeId();

			}
			i++;
		}

		return payLsPaySlipListDTO;
	}

	@Override
	public PaySlipResultBean sendMailForPaySlip(String companyId, String branchId, String dept, String employeeId, String monthYear, String emailAddress, UserDetail userDetails, HttpServletRequest request, HttpServletResponse response, PaySlipListDTO paySlipListDTO) throws Exception {

		ServletContext context = request.getServletContext();
		String[] emailIds = null;
		String paySlipAttachFileFormat;
		PaySlipResultBean ojjs = new PaySlipResultBean();
		int totalEarnings = 0;
		int totalDeductions = 0;
		int totalDeduct = 0;
		int lopDays = 0;
		int lopAmount = 0;

		double employeeLeaveAvailable = 0.00;
		double employeeLeaveTaken = 0.00;

		String empId = "";
		String empName = "";

		List<EmployeeEarlyStartBean> empdetailList = new ArrayList<>();

		ojjs = paySlipDAO.getEmpDetailList(employeeId);

		List<EmployeeEarlyStartBean> list1 = ojjs.getEmpdetailList();
		for (int j = 0; j < list1.size(); j++) {
			EmployeeEarlyStartBean dtbean = list1.get(j);
			employeeLeaveAvailable = Double.parseDouble(dtbean.getAllowedLeave()) + employeeLeaveAvailable;
			employeeLeaveTaken = Double.parseDouble(dtbean.getConsumed()) + employeeLeaveTaken;
		}

		PaySlipResultBean iResultBean = new PaySlipResultBean();
		iResultBean.setSuccess(false);

		iResultBean.setPaySlipListDTO(paySlipListDTO);

		File fc = null;
		String path = ConfigurationProps.exportFilesPath;

		Email objEmail = new Email();
		paySlipAttachFileFormat = "PDF";
		BufferedWriter fileOut = null;

		String toMailId = emailAddress;

		if ("PDF".equals(paySlipAttachFileFormat)) {

			double lopamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.LOPA, new Object[] { companyId, branchId, dept, employeeId, monthYear },Integer.class);

			List<PaySlipDTO> list = iResultBean.getPaySlipListDTO().getPaySlipList();

			for (int j = 0; j < list.size(); j++) {
				PaySlipDTO dtbean = list.get(j);

				empId = dtbean.getEmpId();
				empName = dtbean.getEmpName();

				totalEarnings = (int) dtbean.getTotalEarnings() + totalEarnings;
				totalDeductions = (int) dtbean.getTotalDeductions() + totalDeductions;
				lopDays = (int) dtbean.getLopDays();
				lopAmount = (int) dtbean.getLopAmount();

			}

			totalDeduct = totalEarnings - totalDeductions;
		}

		if ("PDF".equals(paySlipAttachFileFormat)) {
			GeneratedPaySlipPDFformat(empId, empName, totalEarnings, lopDays, lopAmount, totalDeduct, iResultBean.getPaySlipListDTO(), objEmail, context, path, (int) employeeLeaveAvailable, (int) employeeLeaveTaken, toMailId);
			iResultBean.setSuccess(true);
		}

		return iResultBean;

	}

	private void GeneratedPaySlipPDFformat(String employeeId, String employeeName, int totalEarnings, int lopDays, int lopAmount, int totalDeduct, PaySlipListDTO paySlipListDTO, Email email, ServletContext context, String path, int employeeLeaveAvailable, int employeeLeaveTaken, String toMailId) {

		File fc = new File(path);
		if (fc.exists()) {

		} else {
			fc.mkdirs();
		}

		Document document = new Document();
		Font font8 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13, Color.DARK_GRAY);
		Font heading = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, Color.BLACK);
		Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13, Color.BLACK);

		try {

			PdfWriter writer = null;

			writer = PdfWriter.getInstance(document, new FileOutputStream(path + "paySlipReport.pdf"));

			document.open();

			String imgg = "/images/logo1.png";

			String logoImageDubai = context.getRealPath(imgg); // PurchaseConstants.LOGO_IMAGE_HIS_PATH
			Image img = Image.getInstance(logoImageDubai);
			img.setAbsolutePosition(50, 760);
			img.scaleAbsolute(180, 40);
			img.setAlignment(Image.BOTTOM | Image.UNDERLYING);
			img.scalePercent(80, 60);
			document.add(img);

			// create a paragraph
			Paragraph paragraph = new Paragraph();

			paragraph.add("\n\n\n");
			paragraph.addAll(new Paragraph("PAYSLIP REPORT", heading));
			paragraph.setAlignment(Element.ALIGN_CENTER);
			paragraph.add("\n\n");

			Paragraph paragraph1 = new Paragraph();

			employeeLeaveAvailable = employeeLeaveAvailable - employeeLeaveTaken;

			paragraph1.addAll(new Paragraph("\t\t\t\t\t Employee Id      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:\t" + CommonUtil.returnEmptyForNull(employeeId) + "\n", headerFont));
			paragraph1.addAll(new Paragraph("\t\t\t\t\t Employee Name   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:\t" + CommonUtil.returnEmptyForNull(employeeName) + "\n", headerFont));
			paragraph1.addAll(new Paragraph("\t\t\t\t\t Number Of Leaves Taken      \t:\t" + employeeLeaveTaken + "\n", headerFont));
			paragraph1.addAll(new Paragraph("\t\t\t\t\t Number Of Leaves Available  :\t" + employeeLeaveAvailable + "\n", headerFont));
			paragraph1.addAll(new Paragraph("\t\t\t\t\t LOP Days     \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:\t" + lopDays + "\n", headerFont));
			paragraph1.addAll(new Paragraph("\t\t\t\t\t LOP Amount  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:\t" + lopAmount + "\n", headerFont));
			paragraph1.add("\n");

			PdfPCell cell = null;
			// Main table
			PdfPTable mainTable = new PdfPTable(2);
			mainTable.setWidthPercentage(100.0f);

			// Earning table
			PdfPCell firstTableCell = new PdfPCell();
			firstTableCell.setBorder(PdfPCell.NO_BORDER);
			PdfPTable firstTable = new PdfPTable(2);
			firstTable.setWidthPercentage(90.0f);

			List<PaySlipBean> list = paySlipListDTO.getPaySlipList().get(0).getEarningsList();
			for (int i = 0; i < list.size(); i++) {
				PaySlipBean dtbean = list.get(i);
				if (i == 0) {
					PdfPCell cell23 = new PdfPCell(new Phrase("EARNINGS"));
					cell23.setColspan(2);
					cell23.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
					firstTable.addCell(cell23);
				}

				int amountEarnings = (int) dtbean.getAmount();

				cell = new PdfPCell(new Phrase(dtbean.getPayComponentId().toUpperCase()));
				cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
				firstTable.addCell(cell);
				cell = new PdfPCell(new Phrase(String.valueOf(amountEarnings)));
				cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
				firstTable.addCell(cell);
			}

			firstTableCell.addElement(firstTable);
			mainTable.addCell(firstTableCell);

			// Deduction table
			PdfPCell secondTableCell = new PdfPCell();
			secondTableCell.setBorder(PdfPCell.NO_BORDER);
			PdfPTable secondTable = new PdfPTable(2);
			secondTable.setWidthPercentage(90.0f);
			List<PaySlipBean> list1 = paySlipListDTO.getPaySlipList().get(0).getDeductionsList();
			for (int j = 0; j < list1.size(); j++) {
				PaySlipBean dtbean = list1.get(j);
				if (j == 0) {
					PdfPCell cell23 = new PdfPCell(new Phrase("DEDUCTIONS"));
					cell23.setColspan(2);
					cell23.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
					secondTable.addCell(cell23);
				}

				int amountDeductions = (int) dtbean.getAmount();

				cell = new PdfPCell(new Phrase(dtbean.getPayComponentId().toUpperCase()));
				secondTable.addCell(cell);
				cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
				cell = new PdfPCell(new Phrase(String.valueOf(amountDeductions)));
				cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
				secondTable.addCell(cell);
			}
			secondTableCell.addElement(secondTable);
			mainTable.addCell(secondTableCell);

			paragraph1.add(mainTable);
			paragraph1.add("\n");

			paragraph1.addAll(new Paragraph("\t\t\t\t\t GROSS PAY \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + totalEarnings + "\t\t\t\t\t\t\t\t\t\t\t NET PAY \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + totalDeduct + "\n", headerFont));

			document.add(paragraph);
			document.add(paragraph1);

		} catch (Exception ioe) {
//			System.err.println(ioe.getMessage());
			ioe.printStackTrace();
		}

		// step 5: we close the document
		document.close();

		final String emailAttachment = path + "paySlipReport.pdf";

		try {
			if (emailAttachment != null && !"".equalsIgnoreCase(emailAttachment) && !" ".equalsIgnoreCase(emailAttachment)) {

				String sCategories = MailConstants.sCategories;
				Map<String, String> filesList = new HashMap<>();
				String subject = "Employee Id : " + employeeId + " Employee Name : " + employeeName;
				String bodyText = "Dear " + employeeName + ",";
				File file = new File(emailAttachment);

				//MailUtil.senPaySlipdMail(toMailId, subject, bodyText, sCategories.split(","), filesList, file, employeeName);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public PaySlipBean getPaySlipList1(String employeeId) throws Exception {
		// TODO Auto-generated method stub
		return paySlipDAO.getemail(employeeId);
	}

	@Override
	public PaySlipResultBean getPaySlipList2(List<PaySlipBean> employeeIdlist) throws Exception {
		// TODO Auto-generated method stub
		return paySlipDAO.getemailid(employeeIdlist);
	}

	@Override
	public void exportExcel(PaySlipBean paySlipBean, String filePath) throws CustomException, IOException, Exception {
		List<Map<String, Object>> paySlipList = new ArrayList<>();
		paySlipList = paySlipDAO.getPaySlipList1(paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear());
		GeneratePTListExportALL(paySlipList, filePath, paySlipBean.getMonthYear(), paySlipBean);
	}

	public void GeneratePTListExportALL(List<Map<String, Object>> paySlipList, String filePath, String monthYear, PaySlipBean paySlipBean) throws Exception, IOException {

		double bamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.BASIC, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double daamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.DA,Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double hamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.HRA, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double camount = jdbcTemplate.queryForObject(PaySlipQueryUtil.CONVE, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double csamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.CONS, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double samount = jdbcTemplate.queryForObject(PaySlipQueryUtil.SPL, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double otamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.OTEAR, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double gamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.GROSS, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double mamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.MEDIC, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double pfamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.PFSEL, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double otdamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.OTDED, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double lopday = jdbcTemplate.queryForObject(PaySlipQueryUtil.LOPD, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double lopamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.LOPA, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double netamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.NET,Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double currentamount = netamount - lopamount;
		double wfamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.WF, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double ptamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.PT, Integer.class,paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double tdsamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.TDS, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double teleamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.Tele, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double usamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.US,Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double adamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.AD, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double tramount = jdbcTemplate.queryForObject(PaySlipQueryUtil.TR1, Integer.class,paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double othamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.OTD,Integer.class,paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double piamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.PI, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double hramount = jdbcTemplate.queryForObject(PaySlipQueryUtil.HR,Integer.class,paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );
		double Arramount = jdbcTemplate.queryForObject(PaySlipQueryUtil.ARR, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() );

		// String epfno = jdbcTemplate.queryForObject(PaySlipQueryUtil.epfno,
		// String.class, new Object[] { paySlipBean.getCompanyId(),
		// paySlipBean.getBranchId(), paySlipBean.getDepartmentId(),
		// paySlipBean.getEmployeeId(), paySlipBean.getMonthYear() });
		// double salday = 30 - lopday;
		double totaldect = mamount + pfamount + otdamount + wfamount + ptamount + tdsamount + teleamount + usamount + adamount + tramount + othamount + lopamount;

		int count = 0;
		String number = " ";
		HSSFWorkbook wb = new HSSFWorkbook();

		Sheet sheet1 = wb.createSheet("Employee_PaySlip");
		sheet1.setZoom(4, 5);
		CellStyle style = wb.createCellStyle();
		org.apache.poi.ss.usermodel.Font font = wb.createFont();
		font.setFontHeight((short) 200);
		font.setFontName("Arial");
		style.setFont(font);
		style.setAlignment(CellStyle.ALIGN_CENTER);

		sheet1.setFitToPage(true);
		sheet1.setMargin((short) 0, 0.20);
		sheet1.setMargin((short) 1, 0.20);
		sheet1.setMargin((short) 2, 0.20);
		sheet1.setMargin((short) 3, 0.20);
		PrintSetup ps = sheet1.getPrintSetup();
		ps.setFitHeight((short) 1);
		ps.setFitWidth((short) 1);
		ps.setFooterMargin(0);
		ps.setLandscape(true);
		ps.setLeftToRight(true);
		ps.setScale((short) 100);
		ps.setPaperSize((short) 9);
		ps.setHeaderMargin(0);
		int rowNumber = 2;
		// heading row
		Row row1 = sheet1.createRow((short) 0);
		Row row2 = sheet1.createRow((short) rowNumber);
		org.apache.poi.ss.usermodel.Cell cell;
		setHeading(wb, style);

		cell = row1.createCell((short) 0);
		cell.setCellStyle(style);
		cell.setCellValue("MONTH");

		cell = row2.createCell((short) 0);
		cell.setCellStyle(style);
		cell.setCellValue("SI.NO");

		cell = row2.createCell((short) 1);
		cell.setCellStyle(style);
		cell.setCellValue("EMPLOYEE_ID");

		cell = row2.createCell((short) 2);
		cell.setCellStyle(style);
		cell.setCellValue("EMPLOYEE_NAME");

		cell = row2.createCell((short) 3);
		cell.setCellStyle(style);
		cell.setCellValue("LOP Days");

		cell = row2.createCell((short) 4);
		cell.setCellStyle(style);
		cell.setCellValue("Salary Days");

		cell = row2.createCell((short) 5);
		cell.setCellStyle(style);
		cell.setCellValue("EPF.No");

		cell = row2.createCell((short) 6);
		cell.setCellStyle(style);
		cell.setCellValue("UAN.No");

		cell = row2.createCell((short) 7);
		cell.setCellStyle(style);
		cell.setCellValue("BASIC");

		cell = row2.createCell((short) 8);
		cell.setCellStyle(style);
		cell.setCellValue("DA");

		cell = row2.createCell((short) 9);
		cell.setCellStyle(style);
		cell.setCellValue("HRA");

		cell = row2.createCell((short) 10);
		cell.setCellStyle(style);
		cell.setCellValue("CONVE");

		cell = row2.createCell((short) 11);
		cell.setCellStyle(style);
		cell.setCellValue("CONS");

		cell = row2.createCell((short) 12);
		cell.setCellStyle(style);
		cell.setCellValue("SPL");

		cell = row2.createCell((short) 13);
		cell.setCellStyle(style);
		cell.setCellValue("Other Earnings");

		cell = row2.createCell((short) 14);
		cell.setCellStyle(style);
		cell.setCellValue("Gross Pay");

		cell = row2.createCell((short) 15);
		cell.setCellStyle(style);
		cell.setCellValue("MEDIC");

		cell = row2.createCell((short) 16);
		cell.setCellStyle(style);
		cell.setCellValue("PFSEL");

		cell = row2.createCell((short) 17);
		cell.setCellStyle(style);
		cell.setCellValue("ESI");

		cell = row2.createCell((short) 18);
		cell.setCellStyle(style);
		cell.setCellValue("Welfare Fund");

		cell = row2.createCell((short) 19);
		cell.setCellStyle(style);
		cell.setCellValue("Prof.Tax");

		cell = row2.createCell((short) 20);
		cell.setCellStyle(style);
		cell.setCellValue("Tax");

		cell = row2.createCell((short) 21);
		cell.setCellStyle(style);
		cell.setCellValue("Tele");

		cell = row2.createCell((short) 22);
		cell.setCellStyle(style);
		cell.setCellValue("Unearned Salary");

		cell = row2.createCell((short) 23);
		cell.setCellStyle(style);
		cell.setCellValue("Advance");

		cell = row2.createCell((short) 24);
		cell.setCellStyle(style);
		cell.setCellValue("Trainning Fee");

		cell = row2.createCell((short) 25);
		cell.setCellStyle(style);
		cell.setCellValue("PI");

		cell = row2.createCell((short) 26);
		cell.setCellStyle(style);
		cell.setCellValue("HR");

		cell = row2.createCell((short) 27);
		cell.setCellStyle(style);
		cell.setCellValue("ARR");

		cell = row2.createCell((short) 28);
		cell.setCellStyle(style);
		cell.setCellValue("Others");

		cell = row2.createCell((short) 29);
		cell.setCellStyle(style);
		cell.setCellValue("LOP Amount");

		cell = row2.createCell((short) 30);
		cell.setCellStyle(style);
		cell.setCellValue("Total Deduction");

		cell = row2.createCell((short) 31);
		cell.setCellStyle(style);
		cell.setCellValue("Net Pay");

		double adTot = 0;
		for (Map rmp : paySlipList) {

			rowNumber += 1;
			Row row = sheet1.createRow((short) rowNumber);
			cell = row.createCell((short) 0);
			count = count + 1;
			cell.setCellValue(count);
			cell = row.createCell((short) 1);
			cell.setCellValue((String) rmp.get("employeeId"));
			cell = row.createCell((short) 2);
			cell.setCellValue((String) rmp.get("employeeName"));
			cell = row.createCell((short) 3);
			cell.setCellValue((double) rmp.get("lopDays"));
			cell = row.createCell((short) 4);
			cell.setCellValue((double) rmp.get("salDays"));
			cell = row.createCell((short) 5);
			cell.setCellValue((String) rmp.get("epfno"));
			cell = row.createCell((short) 6);
			cell.setCellValue((String) rmp.get("uanno"));

			cell = row.createCell((short) 7);
			if (rmp.get("BASIC") != null) {
				cell.setCellValue((double) rmp.get("BASIC"));
			}

			cell = row.createCell((short) 8);
			if (rmp.get("DA") != null) {
				cell.setCellValue((double) rmp.get("DA"));
			}

			cell = row.createCell((short) 9);
			if (rmp.get("HRA") != null) {
				cell.setCellValue((double) rmp.get("HRA"));
			}

			cell = row.createCell((short) 10);
			if (rmp.get("CONVE") != null) {
				cell.setCellValue((double) rmp.get("CONVE"));
			}

			cell = row.createCell((short) 11);
			if (rmp.get("CONS") != null) {
				cell.setCellValue((double) rmp.get("CONS"));
			}

			cell = row.createCell((short) 12);
			if (rmp.get("SPL") != null) {
				cell.setCellValue((double) rmp.get("SPL"));
			}

			cell = row.createCell((short) 13);
			if (rmp.get("OTEAR") != null) {
				cell.setCellValue((double) rmp.get("OTEAR"));
			}

			cell = row.createCell((short) 14);
			if (rmp.get("GROSS") != null) {
				cell.setCellValue((double) rmp.get("GROSS"));
			}

			cell = row.createCell((short) 15);
			if (rmp.get("MEDIC") != null) {
				cell.setCellValue((double) rmp.get("MEDIC"));
			}

			cell = row.createCell((short) 16);
			if (rmp.get("PFSEL") != null) {
				cell.setCellValue((double) rmp.get("PFSEL"));
			}

			cell = row.createCell((short) 17);
			if (rmp.get("OTDED") != null) {
				cell.setCellValue((double) rmp.get("OTDED"));
			}

			cell = row.createCell((short) 18);
			if (rmp.get("WF") != null) {
				cell.setCellValue((double) rmp.get("WF"));
			}

			cell = row.createCell((short) 19);
			if (rmp.get("PT") != null) {
				cell.setCellValue((double) rmp.get("PT"));
			}

			cell = row.createCell((short) 20);
			if (rmp.get("TDS") != null) {
				cell.setCellValue((double) rmp.get("TDS"));
			}

			cell = row.createCell((short) 21);
			if (rmp.get("Tele") != null) {
				cell.setCellValue((double) rmp.get("Tele"));
			}

			cell = row.createCell((short) 22);
			if (rmp.get("US") != null) {
				cell.setCellValue((double) rmp.get("US"));
			}

			cell = row.createCell((short) 23);
			if (rmp.get("AD") != null) {
				cell.setCellValue((double) rmp.get("AD"));
			}

			cell = row.createCell((short) 24);
			if (rmp.get("TR1") != null) {
				cell.setCellValue((double) rmp.get("TR1"));
			}

			cell = row.createCell((short) 25);
			if (rmp.get("PI") != null) {
				cell.setCellValue((double) rmp.get("PI"));
			}
			cell = row.createCell((short) 26);
			if (rmp.get("HR") != null) {
				cell.setCellValue((double) rmp.get("HR"));
			}

			cell = row.createCell((short) 27);
			if (rmp.get("ARR") != null) {
				cell.setCellValue((double) rmp.get("ARR"));
			}

			cell = row.createCell((short) 28);
			if (rmp.get("OTD") != null) {
				cell.setCellValue((double) rmp.get("OTD"));
			}

			cell = row.createCell((short) 29);
			cell.setCellValue((double) rmp.get("lopAmount"));

			cell = row.createCell((short) 30);
			// if (rmp.get("TOTDE") != null) {
			// cell.setCellValue((double) rmp.get("TOTDE"));
			// }
			if (rmp.get("TOTDE") != null) {
				double totamt = ((double) rmp.get("TOTDE")) + ((double) rmp.get("lopAmount"));
				cell.setCellValue(totamt);
			} else {
				cell.setCellValue((double) rmp.get("lopAmount"));
			}

			double amt = ((double) rmp.get("NET")) - ((double) rmp.get("lopAmount"));

			cell = row.createCell((short) 31);
			cell.setCellValue(amt);

			cell = row1.createCell((short) 1);
			cell.setCellStyle(style);
			cell.setCellValue((String) rmp.get("monthYear"));

		}

		rowNumber += 1;
		Row row = sheet1.createRow((short) rowNumber);

		cell = row.createCell((short) 1);
		cell.setCellStyle(style);
		cell.setCellValue("TOTAL");
		// cell = row.createCell((short) 2);
		// cell.setCellValue(lopday);
		cell = row.createCell((short) 7);
		cell.setCellValue(bamount);
		cell = row.createCell((short) 8);
		cell.setCellValue(daamount);
		cell = row.createCell((short) 9);
		cell.setCellValue(hamount);
		cell = row.createCell((short) 10);
		cell.setCellValue(camount);
		cell = row.createCell((short) 11);
		cell.setCellValue(csamount);
		cell = row.createCell((short) 12);
		cell.setCellValue(samount);
		cell = row.createCell((short) 13);
		cell.setCellValue(otamount);
		cell = row.createCell((short) 14);
		cell.setCellValue(gamount);
		cell = row.createCell((short) 15);
		cell.setCellValue(mamount);
		cell = row.createCell((short) 16);
		cell.setCellValue(pfamount);
		cell = row.createCell((short) 17);
		cell.setCellValue(otdamount);
		cell = row.createCell((short) 18);
		cell.setCellValue(wfamount);
		cell = row.createCell((short) 19);
		cell.setCellValue(ptamount);
		cell = row.createCell((short) 20);
		cell.setCellValue(tdsamount);
		cell = row.createCell((short) 21);
		cell.setCellValue(teleamount);
		cell = row.createCell((short) 22);
		cell.setCellValue(usamount);
		cell = row.createCell((short) 23);
		cell.setCellValue(adamount);
		cell = row.createCell((short) 24);
		cell.setCellValue(tramount);
		cell = row.createCell((short) 25);
		cell.setCellValue(piamount);
		cell = row.createCell((short) 26);
		cell.setCellValue(hramount);
		cell = row.createCell((short) 27);
		cell.setCellValue(Arramount);
		cell = row.createCell((short) 28);
		cell.setCellValue(othamount);
		cell = row.createCell((short) 29);
		cell.setCellValue(lopamount);
		cell = row.createCell((short) 30);
		cell.setCellValue(totaldect);
		cell = row.createCell((short) 31);
		cell.setCellValue(currentamount);
		sheet1.setColumnWidth((short) 0, (short) ((50 * 8) / ((double) 1 / 20)));

		for (int i = 0; i < 10; i++) {
			sheet1.autoSizeColumn(i);
		}
		Random r = new Random();
		number = String.valueOf(r.nextInt()).substring(1, 3);
		writeExcel(wb, filePath);

	}

	private void setHeading(HSSFWorkbook wb, CellStyle cellStyle) {
		org.apache.poi.ss.usermodel.Font font = wb.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontName("Arial");
		font.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short) 11);
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setFont(font);
		cellStyle.setWrapText(false);

	}
/*
	private String writeExcel(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path ;

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		System.out.println("filepath" + sOutFile);
		try {
			fileOut = new FileOutputStream(sOutFile);
			myWorkBook.write(fileOut);
			url = path ;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return url;
	}*/
	
	
	private String writeExcel(HSSFWorkbook myWorkBook, String filePath) {

		Date currentDate = new Date();

		String sOutFile = filePath + "PayslipReport.xls";

		File dirCreatory = new File(filePath);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		System.out.println("filepath" + sOutFile);
		try {
			fileOut = new FileOutputStream(sOutFile);
			myWorkBook.write(fileOut);
			url = sOutFile;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return url;
	}


	
	
}