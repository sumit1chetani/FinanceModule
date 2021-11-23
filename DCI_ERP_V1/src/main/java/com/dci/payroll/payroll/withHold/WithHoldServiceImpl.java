package com.dci.payroll.payroll.withHold;

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

import com.dci.common.util.CustomException;


@Service
public class WithHoldServiceImpl implements WithHoldService {

	@Autowired
	WithHoldDAO withholdDAO;

	@Override
	public List<WithHoldBean> getEmployeeList() throws Exception {
		// TODO Auto-generated method stub
		return withholdDAO.getEmployeeList();
	}

	// Year list
	@Override
	public List<WithHoldBean> getYearList() throws Exception {
		// TODO Auto-generated method stub
		return withholdDAO.getYearList();
	}

	@Override
	public boolean addWithHold(WithHoldBean withHold) throws Exception {
		// TODO Auto-generated method stub
		return withholdDAO.addWithHold(withHold);
	}

	// update
	@Override
	public boolean updateWithHold(WithHoldBean withHold) throws Exception {
		// TODO Auto-generated method stub
		return withholdDAO.updateWithHold(withHold);
	}

	// withhold report

	@Override
	public List<WithHoldBean> getWithholdReport(WithHoldBean withhold) throws Exception {
		// TODO Auto-generated method stub
		return withholdDAO.getWithholdReport(withhold);
	}

	@Override
	public List<WithHoldBean> getWithHoldList() throws Exception {
		// TODO Auto-generated method stub
		return withholdDAO.getWithHoldList();
	}

	@Override
	public List<WithHoldBean> editwithHold(String withHoldCode) throws Exception {
		// TODO Auto-generated method stub
		return withholdDAO.editwithHold(withHoldCode);
	}

	// employee check
	@Override
	public List<WithHoldBean> employeeCheck(String employee) throws Exception {
		// TODO Auto-generated method stub
		return withholdDAO.employeeCheck(employee);
	}

	// delete
	@Override
	public boolean deleteWithHold(String withHoldCode) throws Exception {
		// TODO Auto-generated method stub
		return withholdDAO.deleteWithHold(withHoldCode);
	}

	// excel export

	@Override
	public void exportExcel(WithHoldBean withhold, String filePath) throws CustomException, IOException, Exception {
		List<WithHoldBean> WithHoldList = new ArrayList<>();
		WithHoldList = withholdDAO.getWithholdReport(withhold);
		GeneratePTListExportALL(WithHoldList, filePath, withhold.getMonthYear(), withhold.getStatus());
	}

	public void GeneratePTListExportALL(List<WithHoldBean> WithHoldList, String filePath, String monthYear, String status) throws Exception, IOException {

		String mon = monthYear.substring(0, 2);
		String mon1 = monthYear.substring(2, 6);
		monthYear = mon + "-" + mon1;
		int count = 0;
		String number = " ";
		HSSFWorkbook wb = new HSSFWorkbook();

		Sheet sheet1 = wb.createSheet("Withhold_Report");
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
		cell = row1.createCell((short) 3);
		cell.setCellStyle(style);
		cell.setCellValue("STATUS");

		cell = row2.createCell((short) 0);
		cell.setCellStyle(style);
		cell.setCellValue("WithHold Code");

		cell = row2.createCell((short) 1);
		cell.setCellStyle(style);
		cell.setCellValue("Employee Code");

		cell = row2.createCell((short) 2);
		cell.setCellStyle(style);
		cell.setCellValue("Employee Name");

		cell = row2.createCell((short) 3);
		cell.setCellStyle(style);
		cell.setCellValue("Withhold Date");

		cell = row2.createCell((short) 4);
		cell.setCellStyle(style);
		cell.setCellValue("Withhold From");

		cell = row2.createCell((short) 5);
		cell.setCellStyle(style);
		cell.setCellValue("Withhold Till");

		for (WithHoldBean adv : WithHoldList) {

			rowNumber += 1;
			Row row = sheet1.createRow((short) rowNumber);
			cell = row.createCell((short) 0);
			count = count + 1;
			cell.setCellValue(adv.getWithHoldCode());
			cell = row.createCell((short) 1);
			cell.setCellValue(adv.getEmployee());
			cell = row.createCell((short) 2);
			cell.setCellValue(adv.getEmployeeName());
			cell = row.createCell((short) 3);
			cell.setCellValue(adv.getWithholdDate());
			cell = row.createCell((short) 4);
			cell.setCellValue(adv.getWithholdFrom());
			cell = row.createCell((short) 5);
			cell.setCellValue(adv.getWithholdTo());

			cell = row1.createCell((short) 1);
			cell.setCellStyle(style);
			cell.setCellValue(monthYear);
			cell = row1.createCell((short) 4);
			cell.setCellStyle(style);
			cell.setCellValue(status);

		}

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
