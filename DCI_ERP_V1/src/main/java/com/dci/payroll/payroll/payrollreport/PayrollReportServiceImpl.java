package com.dci.payroll.payroll.payrollreport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;
import com.dci.payroll.payroll.payslip.PaySlipQueryUtil;



@Service
public class PayrollReportServiceImpl implements PayrollReportService {

	@Autowired
	PayrollReportDAO payrollReportDAO;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> getPayrollList(String companyId, String branchId, String dept, String monthYear) throws Exception {
		// TODO Auto-generated method stub

		return payrollReportDAO.getPayrollList(companyId, branchId, dept, monthYear);

	}

	@Override
	public List<Map<String, Object>> getMonthlyPayrollList(String employeeId) throws Exception {
		// TODO Auto-generated method stub
		return payrollReportDAO.getMonthlyPayrollList(employeeId);
	}

	@Override
	public void exportExcel(PayrollReportBean payrollReportBean, String filePath) throws CustomException, IOException, Exception {
		List<Map<String, Object>> payRollList = new ArrayList<>();
		payRollList = payrollReportDAO.getPayrollList(payrollReportBean.getCompanyId(), payrollReportBean.getBranchId(), payrollReportBean.getDept(), payrollReportBean.getMonthYear());
		GeneratePTListExportALL(payRollList, filePath, payrollReportBean.getMonthYear(), payrollReportBean);

	}

	public void GeneratePTListExportALL(List<Map<String, Object>> payRollList, String filePath, String monthYear, PayrollReportBean paySlipBean) throws Exception, IOException {

		double bamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.BASIC, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double daamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.DA, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double hamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.HRA, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double camount = jdbcTemplate.queryForObject(PaySlipQueryUtil.CONVE, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double csamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.CONS, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double samount = jdbcTemplate.queryForObject(PaySlipQueryUtil.SPL, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear());
		double otamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.OTEAR, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double gamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.GROSS, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear());
		double mamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.MEDIC, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double pfamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.PFSEL, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double otdamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.OTDED, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double lopday = jdbcTemplate.queryForObject(PaySlipQueryUtil.LOPD, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(),null, paySlipBean.getMonthYear() );
		double lopamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.LOPA, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double netamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.NET,  Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(),null, paySlipBean.getMonthYear());
		double currentamount = netamount - lopamount;
		double wfamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.WF, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double ptamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.PT, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear());
		double tdsamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.TDS, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double teleamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.Tele, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double usamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.US, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double adamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.AD, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear()) ;
		double tramount = jdbcTemplate.queryForObject(PaySlipQueryUtil.TR1, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double othamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.OTD, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );

		double taamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.TA, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double piamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.PI, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double otamount1 = jdbcTemplate.queryForObject(PaySlipQueryUtil.OT, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double arramount = jdbcTemplate.queryForObject(PaySlipQueryUtil.ARR, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double ts_05amount = jdbcTemplate.queryForObject(PaySlipQueryUtil.TS_05, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double epfamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.EPF, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double esiamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.ESI, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double edliamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.EDLI, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double epsamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.EPS, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double admcamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.ADMC, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double transamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.TRANS, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );
		double ptsamount = jdbcTemplate.queryForObject(PaySlipQueryUtil.PTS, Integer.class, paySlipBean.getCompanyId(), paySlipBean.getBranchId(), paySlipBean.getDept(), null, paySlipBean.getMonthYear() );

		// double leave = jdbcTemplate.queryForObject(PaySlipQueryUtil.leave, new
		// Object[] { paySlipBean.getCompanyId(), paySlipBean.getBranchId(),
		// paySlipBean.getDept(), paySlipBean.getMonthYear() });

		double totaldect = mamount + pfamount + otdamount + wfamount + ptamount + tdsamount + teleamount + usamount + adamount + tramount + othamount + lopamount;

		int count = 0;
		String number = " ";
		HSSFWorkbook wb = new HSSFWorkbook();

		Sheet sheet1 = wb.createSheet("Employee_Salary");
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
		cell.setCellValue("EPF.No");

		cell = row2.createCell((short) 5);
		cell.setCellStyle(style);
		cell.setCellValue("UAN.No");

		cell = row2.createCell((short) 6);
		cell.setCellStyle(style);
		cell.setCellValue("BASIC");

		cell = row2.createCell((short) 7);
		cell.setCellStyle(style);
		cell.setCellValue("DA");

		cell = row2.createCell((short) 8);
		cell.setCellStyle(style);
		cell.setCellValue("HRA");

		cell = row2.createCell((short) 9);
		cell.setCellStyle(style);
		cell.setCellValue("CONVC");

		cell = row2.createCell((short) 10);
		cell.setCellStyle(style);
		cell.setCellValue("CONS");

		cell = row2.createCell((short) 11);
		cell.setCellStyle(style);
		cell.setCellValue("SPL");

		cell = row2.createCell((short) 12);
		cell.setCellStyle(style);
		cell.setCellValue("TA");

		cell = row2.createCell((short) 13);
		cell.setCellStyle(style);
		cell.setCellValue("PI");

		cell = row2.createCell((short) 14);
		cell.setCellStyle(style);
		cell.setCellValue("OT");

		cell = row2.createCell((short) 15);
		cell.setCellStyle(style);
		cell.setCellValue("ARR");

		cell = row2.createCell((short) 16);
		cell.setCellStyle(style);
		cell.setCellValue("TS_05");

		cell = row2.createCell((short) 17);
		cell.setCellStyle(style);
		cell.setCellValue("Other Earnings");

		cell = row2.createCell((short) 18);
		cell.setCellStyle(style);
		cell.setCellValue("Gross Pay");

		cell = row2.createCell((short) 19);
		cell.setCellStyle(style);
		cell.setCellValue("MEDIC");

		cell = row2.createCell((short) 20);
		cell.setCellStyle(style);
		cell.setCellValue("PFSEL");

		cell = row2.createCell((short) 21);
		cell.setCellStyle(style);
		cell.setCellValue("EPF");

		cell = row2.createCell((short) 22);
		cell.setCellStyle(style);
		cell.setCellValue("ESI");

		cell = row2.createCell((short) 23);
		cell.setCellStyle(style);
		cell.setCellValue("EDLI");

		cell = row2.createCell((short) 24);
		cell.setCellStyle(style);
		cell.setCellValue("EPS");

		cell = row2.createCell((short) 25);
		cell.setCellStyle(style);
		cell.setCellValue("ADMC");

		cell = row2.createCell((short) 26);
		cell.setCellStyle(style);
		cell.setCellValue("Trans");

		cell = row2.createCell((short) 27);
		cell.setCellStyle(style);
		cell.setCellValue("PTS");

		cell = row2.createCell((short) 28);
		cell.setCellStyle(style);
		cell.setCellValue("Welfare Fund");

		cell = row2.createCell((short) 29);
		cell.setCellStyle(style);
		cell.setCellValue("Prof.Tax");

		cell = row2.createCell((short) 30);
		cell.setCellStyle(style);
		cell.setCellValue("Tax");

		cell = row2.createCell((short) 31);
		cell.setCellStyle(style);
		cell.setCellValue("Tele");

		cell = row2.createCell((short) 32);
		cell.setCellStyle(style);
		cell.setCellValue("Unearned Salary");

		cell = row2.createCell((short) 33);
		cell.setCellStyle(style);
		cell.setCellValue("Advance");

		cell = row2.createCell((short) 34);
		cell.setCellStyle(style);
		cell.setCellValue("Trainning Fee");

		cell = row2.createCell((short) 35);
		cell.setCellStyle(style);
		cell.setCellValue("Others");

		cell = row2.createCell((short) 36);
		cell.setCellStyle(style);
		cell.setCellValue("Leave Balance");

		cell = row2.createCell((short) 37);
		cell.setCellStyle(style);
		cell.setCellValue("LOP Amount");

		cell = row2.createCell((short) 38);
		cell.setCellStyle(style);
		cell.setCellValue("Total Deduction");

		cell = row2.createCell((short) 39);
		cell.setCellStyle(style);
		cell.setCellValue("Net Pay");
		double epfamountnew = 0;
		double esiamountnew = 0;
		double edliamountnew = 0;
		double epsamountnew = 0;
		double admcamountnew = 0;
		double transamountnew = 0;
		double ptsamountnew = 0;

		for (Map rmp : payRollList) {

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
			cell.setCellValue((String) rmp.get("epfno"));
			cell = row.createCell((short) 5);
			cell.setCellValue((String) rmp.get("uanno"));

			cell = row.createCell((short) 6);
			if (rmp.get("BASIC") != null) {
				cell.setCellValue((double) rmp.get("BASIC"));
			}

			cell = row.createCell((short) 7);
			if (rmp.get("DA") != null) {
				cell.setCellValue((double) rmp.get("DA"));
			}

			cell = row.createCell((short) 8);
			if (rmp.get("HRA") != null) {
				cell.setCellValue((double) rmp.get("HRA"));
			}

			cell = row.createCell((short) 9);
			if (rmp.get("CONVE") != null) {
				cell.setCellValue((double) rmp.get("CONVE"));
			}

			cell = row.createCell((short) 10);
			if (rmp.get("CONS") != null) {
				cell.setCellValue((double) rmp.get("CONS"));
			}

			cell = row.createCell((short) 11);
			if (rmp.get("SPL") != null) {
				cell.setCellValue((double) rmp.get("SPL"));
			}

			cell = row.createCell((short) 12);
			if (rmp.get("TA") != null) {
				cell.setCellValue((double) rmp.get("TA"));
			}

			cell = row.createCell((short) 13);
			if (rmp.get("PI") != null) {
				cell.setCellValue((double) rmp.get("PI"));
			}

			cell = row.createCell((short) 14);
			if (rmp.get("OT") != null) {
				cell.setCellValue((double) rmp.get("OT"));
			}

			cell = row.createCell((short) 15);
			if (rmp.get("ARR") != null) {
				cell.setCellValue((double) rmp.get("ARR"));
			}

			cell = row.createCell((short) 16);
			if (rmp.get("TS_05") != null) {
				cell.setCellValue((double) rmp.get("TS_05"));
			}

			cell = row.createCell((short) 17);
			if (rmp.get("OTEAR") != null) {
				cell.setCellValue((double) rmp.get("OTEAR"));
			}

			cell = row.createCell((short) 18);
			if (rmp.get("GROSS") != null) {
				cell.setCellValue((double) rmp.get("GROSS"));
			}

			cell = row.createCell((short) 19);
			if (rmp.get("MEDIC") != null) {
				cell.setCellValue((double) rmp.get("MEDIC"));
			}

			cell = row.createCell((short) 20);
			if (rmp.get("PFSEL") != null) {
				cell.setCellValue((double) rmp.get("PFSEL"));
			}

			cell = row.createCell((short) 21);
			if (rmp.get("EPF") != null) {
				epfamountnew = epfamountnew + (double) rmp.get("EPF");
				cell.setCellValue((double) rmp.get("EPF"));
			}

			cell = row.createCell((short) 22);
			if (rmp.get("ESI") != null) {
				esiamountnew = esiamountnew + (double) rmp.get("ESI");
				cell.setCellValue((double) rmp.get("ESI"));
			}

			cell = row.createCell((short) 23);
			if (rmp.get("EDLI") != null) {
				edliamountnew = edliamountnew + (double) rmp.get("EDLI");
				cell.setCellValue((double) rmp.get("EDLI"));
			}

			cell = row.createCell((short) 24);
			if (rmp.get("EPS") != null) {
				epsamountnew = epsamountnew + (double) rmp.get("EPS");
				cell.setCellValue((double) rmp.get("EPS"));
			}

			cell = row.createCell((short) 25);
			if (rmp.get("ADMC") != null) {
				admcamountnew = admcamountnew + (double) rmp.get("ADMC");
				cell.setCellValue((double) rmp.get("ADMC"));
			}

			cell = row.createCell((short) 26);
			if (rmp.get("Trans") != null) {
				transamountnew = transamountnew + (double) rmp.get("Trans");
				cell.setCellValue((double) rmp.get("Trans"));
			}

			cell = row.createCell((short) 27);
			if (rmp.get("PTS") != null) {
				ptsamountnew = ptsamountnew + (double) rmp.get("PTS");
				cell.setCellValue((double) rmp.get("PTS"));
			}

			cell = row.createCell((short) 28);
			if (rmp.get("WF") != null) {
				cell.setCellValue((double) rmp.get("WF"));
			}

			cell = row.createCell((short) 29);
			if (rmp.get("PT") != null) {
				cell.setCellValue((double) rmp.get("PT"));
			}

			cell = row.createCell((short) 30);
			if (rmp.get("TDS") != null) {
				cell.setCellValue((double) rmp.get("TDS"));
			}

			cell = row.createCell((short) 31);
			if (rmp.get("Tele") != null) {
				cell.setCellValue((double) rmp.get("Tele"));
			}

			cell = row.createCell((short) 32);
			if (rmp.get("US") != null) {
				cell.setCellValue((double) rmp.get("US"));
			}

			cell = row.createCell((short) 33);
			if (rmp.get("AD") != null) {
				cell.setCellValue((double) rmp.get("AD"));
			}

			cell = row.createCell((short) 34);
			if (rmp.get("TR1") != null) {
				cell.setCellValue((double) rmp.get("TR1"));
			}

			cell = row.createCell((short) 35);
			if (rmp.get("OTD") != null) {
				cell.setCellValue((double) rmp.get("OTD"));
			}

			cell = row.createCell((short) 36);
			if (rmp.get("Leave Balance") != null) {
				cell.setCellValue((double) rmp.get("avail"));
			}

			cell = row.createCell((short) 37);
			cell.setCellValue((double) rmp.get("lopAmount"));

			cell = row.createCell((short) 38);
			if (rmp.get("TOTDE") != null) {
				double totamt = ((double) rmp.get("TOTDE")) + ((double) rmp.get("lopAmount"));
				cell.setCellValue(totamt);
			} else {
				cell.setCellValue((double) rmp.get("lopAmount"));
			}

			cell = row.createCell((short) 39);
			if (rmp.get("NET") != null) {
				cell.setCellValue((double) rmp.get("NET"));
			}

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
		cell = row.createCell((short) 6);
		cell.setCellValue(bamount);
		cell = row.createCell((short) 7);
		cell.setCellValue(daamount);
		cell = row.createCell((short) 8);
		cell.setCellValue(hamount);
		cell = row.createCell((short) 9);
		cell.setCellValue(camount);
		cell = row.createCell((short) 10);
		cell.setCellValue(csamount);
		cell = row.createCell((short) 11);
		cell.setCellValue(samount);
		cell = row.createCell((short) 12);
		cell.setCellValue(taamount);
		cell = row.createCell((short) 13);
		cell.setCellValue(piamount);
		cell = row.createCell((short) 14);
		cell.setCellValue(otamount1);
		cell = row.createCell((short) 15);
		cell.setCellValue(arramount);
		cell = row.createCell((short) 16);
		cell.setCellValue(ts_05amount);

		cell = row.createCell((short) 17);
		cell.setCellValue(otamount);
		cell = row.createCell((short) 18);
		cell.setCellValue(gamount);
		cell = row.createCell((short) 19);
		cell.setCellValue(mamount);
		cell = row.createCell((short) 20);
		cell.setCellValue(pfamount);
		cell = row.createCell((short) 21);
		cell.setCellValue(epfamount);
		cell = row.createCell((short) 22);
		cell.setCellValue(esiamountnew);
		cell = row.createCell((short) 23);
		cell.setCellValue(edliamountnew);
		cell = row.createCell((short) 24);
		cell.setCellValue(epsamountnew);
		cell = row.createCell((short) 25);
		cell.setCellValue(admcamountnew);
		cell = row.createCell((short) 26);
		cell.setCellValue(transamountnew);
		cell = row.createCell((short) 27);
		cell.setCellValue(ptsamountnew);

		/*
		 * cell = row.createCell((short) 28); cell.setCellValue(otdamount);
		 */

		cell = row.createCell((short) 28);
		cell.setCellValue(wfamount);
		cell = row.createCell((short) 29);
		cell.setCellValue(ptamount);
		cell = row.createCell((short) 30);
		cell.setCellValue(tdsamount);
		cell = row.createCell((short) 31);
		cell.setCellValue(teleamount);
		cell = row.createCell((short) 32);
		cell.setCellValue(usamount);
		cell = row.createCell((short) 33);
		cell.setCellValue(adamount);
		cell = row.createCell((short) 34);
		cell.setCellValue(tramount);
		cell = row.createCell((short) 35);
		cell.setCellValue(othamount);
		/*
		 * cell = row.createCell((short) 36); cell.setCellValue(leave);
		 */ cell = row.createCell((short) 37);
		cell.setCellValue(lopamount);
		cell = row.createCell((short) 38);
		cell.setCellValue(totaldect);
		cell = row.createCell((short) 39);
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

	/*private void writeExcel(HSSFWorkbook wb, String filePath) {
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(filePath);
			wb.write(fileOut);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
*/
	
	private String writeExcel(HSSFWorkbook myWorkBook, String filePath) {

		Date currentDate = new Date();

		String sOutFile = filePath + "PayrollReport.xls";

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