package com.dci.payroll.payroll.employeelop;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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

import com.dci.common.util.CustomException;


@Service
public class EmployeeLopServiceImpl implements EmployeeLopService {
	@Autowired
	EmployeeLopDAO empLopDAO;

	@Override
	public List<EmployeeLopBean> getEmployeeLopList(String companyId, String branchId, String dept, String monthYear) throws Exception {
		// TODO Auto-generated method stub
		return empLopDAO.getEmployeeLopList(companyId, branchId, dept, monthYear);
	}

	@Override
	public boolean insertEmployeeLopList(ArrayList<EmployeeLopBean> empLOPBean) throws Exception {
		// TODO Auto-generated method stub
		return empLopDAO.insertEmployeeLopList(empLOPBean);
	}

	@Override
	public EmployeeLopBean uploadFile(MultipartFile file) {
		return empLopDAO.uploadFile(file);

	}

	@Override
	public void exportExcel(EmployeeLopBean employeeLopBean, String filePath) throws CustomException, IOException, Exception {
		List<EmployeeLopBean> lopList = empLopDAO.getEmployeeLopList(employeeLopBean.getCompanyId(), employeeLopBean.getBranchId(), employeeLopBean.getDept(), employeeLopBean.getMonthYear());
		GeneratePTListExportALL(lopList, filePath, employeeLopBean.getMonthYear());

	}

	public void GeneratePTListExportALL(List<EmployeeLopBean> lopList, String filePath, String monthYear) throws Exception, IOException {

		String number = " ";
		HSSFWorkbook wb = new HSSFWorkbook();

		Sheet sheet1 = wb.createSheet("Employee_LOP_File");
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
		cell.setCellValue("LOP MONTH");

		cell = row2.createCell((short) 0);
		cell.setCellStyle(style);
		cell.setCellValue("EMPLOYEE_ID");

		cell = row2.createCell((short) 1);
		cell.setCellStyle(style);
		cell.setCellValue("EMPLOYEE_NAME");

		cell = row2.createCell((short) 2);
		cell.setCellStyle(style);
		cell.setCellValue("DAYS");

		sheet1.setColumnWidth((short) 0, (short) ((50 * 8) / ((double) 1 / 20)));

		for (EmployeeLopBean lopBean : lopList) {
			rowNumber += 1;
			Row row = sheet1.createRow((short) rowNumber);

			cell = row.createCell((short) 0);
			cell.setCellValue(lopBean.getEmployeeId());
			cell = row.createCell((short) 1);
			cell.setCellValue(lopBean.getEmployeeName());
			cell = row.createCell((short) 2);
			cell.setCellValue(lopBean.getDays());
			cell = row.createCell((short) 3);
			cell = row1.createCell((short) 1);
			cell.setCellStyle(style);
			cell.setCellValue(lopBean.getMonthYear());

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

	private void writeExcel(HSSFWorkbook wb, String filePath) {
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

}