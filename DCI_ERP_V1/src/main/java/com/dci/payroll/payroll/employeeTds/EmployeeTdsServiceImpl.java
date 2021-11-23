package com.dci.payroll.payroll.employeeTds;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmployeeTdsServiceImpl implements EmployeeTdsService {
	@Autowired
	EmployeeTdsDAO employeeTdsDAO;

	@Override
	public List<EmployeeTdsBean> getEmployeeTdsList(String companyId, String branchId, String dept, String monthYear) throws Exception {
		// TODO Auto-generated method stub
		return employeeTdsDAO.getEmployeeTdsList(companyId, branchId, dept, monthYear);
	}

	@Override
	public EmployeeTdsBean insertEmployeeTdsList(ArrayList<EmployeeTdsBean> empLOPBean) throws Exception {
		// TODO Auto-generated method stub
		return employeeTdsDAO.insertEmployeeTdsList(empLOPBean);
	}

	@Override
	public EmployeeTdsBean uploadFile(MultipartFile file) {
		return employeeTdsDAO.uploadFile(file);

	}

	@Override
	public void exportExcel(EmployeeTdsBean employeeTdsBean, String filePath) throws IOException, Exception {
		List<EmployeeTdsBean> tdsList = employeeTdsDAO.getEmployeeTdsList(employeeTdsBean.getCompanyId(), employeeTdsBean.getBranchId(), employeeTdsBean.getDept(), employeeTdsBean.getMonthYear());
		GeneratePTListExportALL(tdsList, filePath, employeeTdsBean.getMonthYear());
	}

	public void GeneratePTListExportALL(List<EmployeeTdsBean> tdsList, String filePath, String monthYear) throws Exception, IOException {

		String number = " ";
		HSSFWorkbook wb = new HSSFWorkbook();

		Sheet sheet1 = wb.createSheet("EMPLOYEE_TDS_LIST");
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
		cell.setCellValue("TDS MONTH");

		cell = row2.createCell((short) 0);
		cell.setCellStyle(style);
		cell.setCellValue("EMPLOYEE_ID");

		cell = row2.createCell((short) 1);
		cell.setCellStyle(style);
		cell.setCellValue("EMPLOYEE_NAME");

		cell = row2.createCell((short) 2);
		cell.setCellStyle(style);
		cell.setCellValue("ESTIMATED_TDS");

		cell = row2.createCell((short) 3);
		cell.setCellStyle(style);
		cell.setCellValue("ACTUVAL_TDS");

		sheet1.setColumnWidth((short) 0, (short) ((50 * 8) / ((double) 1 / 20)));

		for (EmployeeTdsBean tdsbean : tdsList) {
			rowNumber += 1;
			Row row = sheet1.createRow((short) rowNumber);

			cell = row.createCell((short) 0);
			cell.setCellValue(tdsbean.getEmployeeId());
			cell = row.createCell((short) 1);
			cell.setCellValue(tdsbean.getEmployeeName());
			cell = row.createCell((short) 2);
			cell.setCellValue(tdsbean.getEstimatedTds());
			cell = row.createCell((short) 3);
			cell.setCellValue(tdsbean.getActualTds());
			cell = row.createCell((short) 4);
			cell = row1.createCell((short) 1);
			cell.setCellStyle(style);
			cell.setCellValue(tdsbean.getMonthYear());

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
		font.setFontName("Arial");
		font.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short) 11);
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setFont(font);
		cellStyle.setWrapText(false);

	}

	
	private String writeExcel(HSSFWorkbook myWorkBook, String filePath) {

		Date currentDate = new Date();

		String sOutFile = filePath + "EmployeeTds.xls";

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

/*	private void writeExcel(HSSFWorkbook wb, String filePath) {
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
}