package com.dci.payroll.payroll.advance;

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
public class AdvanceServiceImpl implements AdvanceService {
	@Autowired
	AdvanceDAO advanceDAO;

	@Override
	public List<Advance> getEmployeeList() throws Exception {
		// TODO Auto-generated method stub
		return advanceDAO.getEmployeeList();
	}

	@Override
	public Advance getEmployeeDetail(String emp) throws Exception {
		// TODO Auto-generated method stub
		return advanceDAO.getEmployeeDetail(emp);
	}

	@Override
	public List<Advance> getDesignationList() throws Exception {
		// TODO Auto-generated method stub
		return advanceDAO.getDesignationList();
	}

	@Override
	public List<Advance> getEmployeeListbasondes(String des) throws Exception {
		// TODO Auto-generated method stub
		return advanceDAO.getEmployeeListbasondes(des);
	}

	@Override
	public List<Advance> getInsList(Advance Advance) throws Exception {
		// TODO Auto-generated method stub
		return advanceDAO.getInsList(Advance);
	}

	@Override
	public boolean addAdvance(Advance Advance) throws Exception {
		// TODO Auto-generated method stub
		return advanceDAO.addAdvance(Advance);
	}

	@Override
	public List<Advance> getAdvanceListList() throws Exception {
		// TODO Auto-generated method stub
		return advanceDAO.getAdvanceListList();
	}

	@Override
	public List<Advance> getAdvanceListbyCode(String advanceCode) throws Exception {
		// TODO Auto-generated method stub
		return advanceDAO.getAdvanceListbyCode(advanceCode);
	}

	@Override
	public boolean updateAdvance(Advance Advance) throws Exception {
		// TODO Auto-generated method stub
		return advanceDAO.updateAdvance(Advance);
	}

	@Override
	public boolean deleteAdvance(String advanceCode) throws Exception {
		// TODO Auto-generated method stub
		return advanceDAO.deleteAdvance(advanceCode);
	}

	@Override
	public List<Advance> getAdvanceAddList(Advance Advance) throws Exception {
		// TODO Auto-generated method stub
		return advanceDAO.getAdvanceAddList(Advance);
	}

	@Override
	public AdvanceResultBean addAdvanceAmount(ArrayList<Advance> Advance) throws Exception {
		// TODO Auto-generated method stub
		return advanceDAO.addAdvanceAmount(Advance);
	}

	@Override
	public boolean deleteAdvanceAdd(String monthYear, Integer departmentId, String employeeId) throws Exception {
		// TODO Auto-generated method stub
		return advanceDAO.deleteAdvanceAdd(monthYear, departmentId, employeeId);
	}

	@Override
	public List<Advance> getAdvanceReport(Advance Advance) throws Exception {
		// TODO Auto-generated method stub
		return advanceDAO.getAdvanceReport(Advance);
	}

	@Override
	public void exportExcel(Advance Advance, String filePath) throws CustomException, IOException, Exception {
		List<Advance> AdvanceList = new ArrayList<Advance>();
		AdvanceList = advanceDAO.getAdvanceReport(Advance);
		GeneratePTListExportALL(AdvanceList, filePath, Advance.getMonthYear());
	}

	public void GeneratePTListExportALL(List<Advance> AdvanceList, String filePath, String monthYear) throws Exception, IOException {

		int count = 0;
		String number = " ";
		HSSFWorkbook wb = new HSSFWorkbook();

		Sheet sheet1 = wb.createSheet("Advance_Report");
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
		cell.setCellValue("Advance Code");

		cell = row2.createCell((short) 1);
		cell.setCellStyle(style);
		cell.setCellValue("Employee Code");

		cell = row2.createCell((short) 2);
		cell.setCellStyle(style);
		cell.setCellValue("Employee Name");

		cell = row2.createCell((short) 3);
		cell.setCellStyle(style);
		cell.setCellValue("Advance Amount");

		cell = row2.createCell((short) 4);
		cell.setCellStyle(style);
		cell.setCellValue("Total Installments");

		cell = row2.createCell((short) 5);
		cell.setCellStyle(style);
		cell.setCellValue("Paid Amount");

		cell = row2.createCell((short) 6);
		cell.setCellStyle(style);
		cell.setCellValue("Installments Paid");

		cell = row2.createCell((short) 7);
		cell.setCellStyle(style);
		cell.setCellValue("Balance Amount");

		cell = row2.createCell((short) 8);
		cell.setCellStyle(style);
		cell.setCellValue("Balance Installments");

		cell = row2.createCell((short) 9);
		cell.setCellStyle(style);
		cell.setCellValue("Installment Amount");

		cell = row2.createCell((short) 10);
		cell.setCellStyle(style);
		cell.setCellValue("Narration");

		for (Advance adv : AdvanceList) {

			rowNumber += 1;
			Row row = sheet1.createRow((short) rowNumber);
			cell = row.createCell((short) 0);
			count = count + 1;
			cell.setCellValue(adv.getAdvanceCode());
			cell = row.createCell((short) 1);
			cell.setCellValue(adv.getEmployeeCode());
			cell = row.createCell((short) 2);
			cell.setCellValue(adv.getEmployeeName());
			cell = row.createCell((short) 3);
			cell.setCellValue(adv.getAmount());
			cell = row.createCell((short) 4);
			cell.setCellValue(Integer.parseInt(adv.getNumberOfInstallments()));
			cell = row.createCell((short) 5);
			cell.setCellValue(adv.getPaidAmount());
			cell = row.createCell((short) 6);
			cell.setCellValue(Integer.parseInt(adv.getInstallmentPaid()));

			cell = row.createCell((short) 7);
			cell.setCellValue(adv.getBalanceAmount());

			cell = row.createCell((short) 8);
			cell.setCellValue(Integer.parseInt(adv.getBalanceIns()));

			cell = row.createCell((short) 9);
			cell.setCellValue(adv.getInstallmentAmount());

			cell = row.createCell((short) 10);
			cell.setCellValue(adv.getNarration());

			cell = row1.createCell((short) 1);
			cell.setCellStyle(style);
			cell.setCellValue(monthYear);

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
