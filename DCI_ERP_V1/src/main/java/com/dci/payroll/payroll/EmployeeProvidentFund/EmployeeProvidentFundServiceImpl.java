package com.dci.payroll.payroll.EmployeeProvidentFund;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeProvidentFundServiceImpl implements EmployeeProvidentFundService {
	@Autowired
	EmployeeProvidentFundDAO professionalTaxSlabDAO;

	@Override
	public EmployeeProvidentFundResultBean getEPFList(EmployeeProvidentFundBean employeeProvidentFundBean) throws Exception {
		return professionalTaxSlabDAO.getEPFList(employeeProvidentFundBean);
	}

	@Override
	public void exportExcel(EmployeeProvidentFundBean employeeProvidentFundBean, String filePath) throws IOException, Exception {
		List<EmployeeProvidentFundBean> epfList = professionalTaxSlabDAO.getEPFXLList(employeeProvidentFundBean);
		GeneratePTListExportALL(epfList, filePath, employeeProvidentFundBean.getMonthYear());
	}

	public void GeneratePTListExportALL(List<EmployeeProvidentFundBean> epfList, String filePath, String monthYear) throws Exception, IOException {

		String number = " ";
		HSSFWorkbook wb = new HSSFWorkbook();

		Sheet sheet1 = wb.createSheet("EMPLOYEE_EPF_LIST");
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
		int rowNumber = 0;
		// heading row

		Row row1 = sheet1.createRow((short) rowNumber);
		org.apache.poi.ss.usermodel.Cell cell;
		setHeading(wb, style);
		cell = row1.createCell((short) 0);
		cell.setCellStyle(style);
		cell.setCellValue("UAN");

		cell = row1.createCell((short) 1);
		cell.setCellStyle(style);
		cell.setCellValue("Member Name");
		cell = row1.createCell((short) 2);
		cell.setCellStyle(style);
		cell.setCellValue("Salary");

		cell = row1.createCell((short) 3);
		cell.setCellStyle(style);
		cell.setCellValue("EPF Wages");

		cell = row1.createCell((short) 4);
		cell.setCellStyle(style);
		// cell.setCellValue("EPS Wages");
		cell.setCellValue("E.EE'S EPF");

		cell = row1.createCell((short) 5);
		cell.setCellStyle(style);
		// cell.setCellValue("EPF Contribution (EE Share) due");
		cell.setCellValue("E.ER'S EPS");

		cell = row1.createCell((short) 6);
		cell.setCellStyle(style);
		// cell.setCellValue("EPF Contribution (EE Share) being remitted");
		cell.setCellValue("E.ER'S EPF");
		/*
		 * cell = row1.createCell((short) 6); cell.setCellStyle(style);
		 * cell.setCellValue("EPS Contribution due");
		 * 
		 * cell = row1.createCell((short) 7); cell.setCellStyle(style);
		 * cell.setCellValue("EPS Contribution being remitted");
		 * 
		 * cell = row1.createCell((short) 8); cell.setCellStyle(style);
		 * cell.setCellValue("Diff EPF and EPS Contribution (ER Share) due");
		 * 
		 * cell = row1.createCell((short) 9); cell.setCellStyle(style);
		 * cell.setCellValue("Diff EPF and EPS Contribution (ER Share) being remitted");
		 * 
		 * cell = row1.createCell((short) 10); cell.setCellStyle(style);
		 * cell.setCellValue("NCP Days");
		 * 
		 * cell = row1.createCell((short) 11); cell.setCellStyle(style);
		 * cell.setCellValue("Refund of Advances");
		 * 
		 * cell = row1.createCell((short) 12); cell.setCellStyle(style);
		 * cell.setCellValue("Arrear EPF Wages");
		 * 
		 * cell = row1.createCell((short) 13); cell.setCellStyle(style);
		 * cell.setCellValue("Arrear EPF EE Share");
		 * 
		 * cell = row1.createCell((short) 14); cell.setCellStyle(style);
		 * cell.setCellValue("Arrear EPF ER Share");
		 * 
		 * cell = row1.createCell((short) 15); cell.setCellStyle(style);
		 * cell.setCellValue("Arrear EPS Share");
		 * 
		 * cell = row1.createCell((short) 16); cell.setCellStyle(style);
		 * cell.setCellValue("Father’s/Husband’s Name");
		 * 
		 * cell = row1.createCell((short) 17); cell.setCellStyle(style);
		 * cell.setCellValue("Relationship with the Member");
		 * 
		 * cell = row1.createCell((short) 18); cell.setCellStyle(style);
		 * cell.setCellValue("Date of Birth");
		 * 
		 * cell = row1.createCell((short) 19); cell.setCellStyle(style);
		 * cell.setCellValue("Gender");
		 * 
		 * cell = row1.createCell((short) 20); cell.setCellStyle(style);
		 * cell.setCellValue("Date of Joining EPF");
		 * 
		 * cell = row1.createCell((short) 21); cell.setCellStyle(style);
		 * cell.setCellValue("Date of Joining EPS");
		 * 
		 * cell = row1.createCell((short) 22); cell.setCellStyle(style);
		 * cell.setCellValue("Date of Exit from EPF");
		 * 
		 * cell = row1.createCell((short) 23); cell.setCellStyle(style);
		 * cell.setCellValue("Date of Exit from EPS");
		 * 
		 * cell = row1.createCell((short) 24); cell.setCellStyle(style);
		 * cell.setCellValue("Reason for leaving");
		 */
		sheet1.setColumnWidth((short) 0, (short) ((50 * 8) / ((double) 1 / 20)));

		for (EmployeeProvidentFundBean employeeProvidentFundBean : epfList) {
			rowNumber += 1;
			Row row = sheet1.createRow((short) rowNumber);
			cell = row.createCell((short) 0);
			cell.setCellValue(employeeProvidentFundBean.getEpfNo());
			cell = row.createCell((short) 1);
			cell.setCellValue(employeeProvidentFundBean.getEmployeeName());
			if (employeeProvidentFundBean.getSalary() != null) {
				cell = row.createCell((short) 2);
				// cell.setCellValue(employeeProvidentFundBean.getEpfWages());
				cell.setCellValue(employeeProvidentFundBean.getSalary());

			}
			if (employeeProvidentFundBean.getEpsWages() != null) {
				cell = row.createCell((short) 3);
				// cell.setCellValue(employeeProvidentFundBean.getEpsWages());
				cell.setCellValue(employeeProvidentFundBean.getEpfWages());
			}
			if (employeeProvidentFundBean.getEpfEmployer() != null) {
				cell = row.createCell((short) 4);
				// cell.setCellValue(employeeProvidentFundBean.getEpfDue());
				cell.setCellValue(employeeProvidentFundBean.getEpfEmployer());
			}
			if (employeeProvidentFundBean.getEps() != null) {
				cell = row.createCell((short) 5);
				// cell.setCellValue(employeeProvidentFundBean.getEpfRemitted());
				cell.setCellValue(employeeProvidentFundBean.getEps());
			}
			if (employeeProvidentFundBean.getEpf() != null) {
				cell = row.createCell((short) 6);
				cell.setCellValue(employeeProvidentFundBean.getEpf());
			}

			/*
			 * if (employeeProvidentFundBean.getEpsDue() != null) { cell =
			 * row.createCell((short) 6);
			 * cell.setCellValue(employeeProvidentFundBean.getEpsDue()); }
			 * 
			 * if (employeeProvidentFundBean.getEpsRemitted() != null) { cell =
			 * row.createCell((short) 7);
			 * cell.setCellValue(employeeProvidentFundBean.getEpsRemitted()); } if
			 * (employeeProvidentFundBean.getEpsDiffDue() != null) { cell =
			 * row.createCell((short) 8);
			 * cell.setCellValue(employeeProvidentFundBean.getEpsDiffDue()); } if
			 * (employeeProvidentFundBean.getEpsDiffRemitted() != null) { cell =
			 * row.createCell((short) 9);
			 * cell.setCellValue(employeeProvidentFundBean.getEpsDiffRemitted()); } if
			 * (employeeProvidentFundBean.getNcpDays() != null) { cell =
			 * row.createCell((short) 10);
			 * cell.setCellValue(employeeProvidentFundBean.getNcpDays()); } if
			 * (employeeProvidentFundBean.getRefund() != null) { cell =
			 * row.createCell((short) 11);
			 * cell.setCellValue(employeeProvidentFundBean.getRefund()); } if
			 * (employeeProvidentFundBean.getArrearEpfWages() != null) { cell =
			 * row.createCell((short) 12);
			 * cell.setCellValue(employeeProvidentFundBean.getArrearEpfWages()); } if
			 * (employeeProvidentFundBean.getArrearEpfEeShare() != null) { cell =
			 * row.createCell((short) 13);
			 * cell.setCellValue(employeeProvidentFundBean.getArrearEpfEeShare()); } if
			 * (employeeProvidentFundBean.getArrearEpfErShare() != null) { cell =
			 * row.createCell((short) 14);
			 * cell.setCellValue(employeeProvidentFundBean.getArrearEpfErShare()); } if
			 * (employeeProvidentFundBean.getArrearEpsShare() != null) { cell =
			 * row.createCell((short) 15);
			 * cell.setCellValue(employeeProvidentFundBean.getArrearEpsShare()); } if
			 * (employeeProvidentFundBean.getFatherHusbandsName() != null) { cell =
			 * row.createCell((short) 16);
			 * cell.setCellValue(employeeProvidentFundBean.getFatherHusbandsName()); } if
			 * (employeeProvidentFundBean.getRelationship() != null) { cell =
			 * row.createCell((short) 17);
			 * cell.setCellValue(employeeProvidentFundBean.getRelationship()); } if
			 * (employeeProvidentFundBean.getDob() != null) { cell = row.createCell((short)
			 * 18); cell.setCellValue(employeeProvidentFundBean.getDob()); } if
			 * (employeeProvidentFundBean.getGender() != null) { cell =
			 * row.createCell((short) 19);
			 * cell.setCellValue(employeeProvidentFundBean.getGender()); } if
			 * (employeeProvidentFundBean.getDojEpf() != null) { cell =
			 * row.createCell((short) 20);
			 * cell.setCellValue(employeeProvidentFundBean.getDojEpf()); } if
			 * (employeeProvidentFundBean.getOjEps() != null) { cell =
			 * row.createCell((short) 21);
			 * cell.setCellValue(employeeProvidentFundBean.getOjEps()); } if
			 * (employeeProvidentFundBean.getDoeEpf() != null) { cell =
			 * row.createCell((short) 22);
			 * cell.setCellValue(employeeProvidentFundBean.getDoeEpf()); } if
			 * (employeeProvidentFundBean.getDoeEps() != null) { cell =
			 * row.createCell((short) 23);
			 * cell.setCellValue(employeeProvidentFundBean.getDoeEps()); } if
			 * (employeeProvidentFundBean.getReason() != null) { cell =
			 * row.createCell((short) 24);
			 * cell.setCellValue(employeeProvidentFundBean.getReason()); }
			 */
		}

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
		font.setFontName("Aharoni");
		font.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short) 11);
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setFont(font);
		cellStyle.setWrapText(false);

	}

	/*private String writeExcel(HSSFWorkbook wb, String filePath) {
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
		
		Date currentDate = new Date();

		String sOutFile = filePath + "EmployeeEpf.xls";

		File dirCreatory = new File(filePath);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		System.out.println("filepath" + sOutFile);
		try {
			fileOut = new FileOutputStream(sOutFile);
			wb.write(fileOut);
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
*/	
	
	private String writeExcel(HSSFWorkbook myWorkBook, String filePath) {

		Date currentDate = new Date();

		String sOutFile = filePath + "EmployeeEpf.xls";

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