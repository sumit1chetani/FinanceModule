package com.dci.tenant.finance.chqPresentation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ChqPresentationServiceImpl implements ChqPresentationService {

	@Autowired
	ChqPresentationDAO objChqPresentationDAO;

	@Override
	public List<ChqPresentationBean> getPresentationHdrList(int limit, int offset) {
		// TODO Auto-generated method stub
		return objChqPresentationDAO.getPresentationHdrList(limit, offset);
	}

	@Override
	public List<ChqPresentationBean> getchequelist() {
		// TODO Auto-generated method stub
		return objChqPresentationDAO.getchequelist();
	}

	@Override
	public boolean savePresentation(ChqPresentationBean chqPresentationBean) {
		// TODO Auto-generated method stub
		return objChqPresentationDAO.savePresentation(chqPresentationBean);
	}

	@Override
	public List<ChqPresentationBean> getRealisationList(int limit, int offset) {
		// TODO Auto-generated method stub
		return objChqPresentationDAO.getRealisationList(limit, offset);
	}

	@Override
	public List<ChqPresentationBean> getPresentationList() {
		// TODO Auto-generated method stub
		return objChqPresentationDAO.getPresentationList();
	}

	@Override
	public boolean saveRealisation(ChqPresentationBean chqPresentationBean) {
		// TODO Auto-generated method stub
		return objChqPresentationDAO.saveRealisation(chqPresentationBean);
	}

	@Override
	public ChqPresentationBean getCreditNoteForEdit(String prCode) {
		// TODO Auto-generated method stub
		return objChqPresentationDAO.getCreditNoteForEdit(prCode);
	}

	@Override
	public boolean updatePresentation(ChqPresentationBean chqPresentationBean) {
		// TODO Auto-generated method stub
		return objChqPresentationDAO.updatePresentation(chqPresentationBean);
	}

	@Override
	public boolean deletePresentation(String prCode) {
		// TODO Auto-generated method stub
		return objChqPresentationDAO.deletePresentation(prCode);
	}

	@Override
	public List<ChqPresentationBean> getPresentationListEdit() {
		// TODO Auto-generated method stub
		return objChqPresentationDAO.getPresentationListEdit();
	}

	@Override
	public List<ChqPresentationBean> getChqStatusRprtList(String customer, String company) {
		// TODO Auto-generated method stub
		return objChqPresentationDAO.getChqStatusRprtList(customer, company);
	}

	@Override
	public boolean exportExcel(String filepath, String customer, String company) {

		boolean isSuccess = false;
		List<ChqPresentationBean> lChqPresentationBean = objChqPresentationDAO.getChqStatusRprtList(customer, company);
		try {
			// Blank workbook
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFCellStyle my_style = workbook.createCellStyle();
			my_style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style.setAlignment(my_style.ALIGN_CENTER);
			my_style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
			my_style.setFillPattern(my_style.SOLID_FOREGROUND);
			Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);
			HSSFCellStyle my_style1 = workbook.createCellStyle();
			my_style1.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style1.setAlignment(my_style.ALIGN_CENTER);
			my_style1.setFillForegroundColor(HSSFColor.YELLOW.index);
			my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font1.setFontHeightInPoints((short) 10);
			my_style1.setFont(font1);
			HSSFCellStyle my_style2 = workbook.createCellStyle();
			my_style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style2.setAlignment(HSSFCellStyle.ALIGN_LEFT);

			HSSFCellStyle my_style3 = workbook.createCellStyle();
			my_style3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style3.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style3.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style3.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			// Create a blank sheet
			HSSFSheet excelSheet = workbook.createSheet("Cheque Status Report");

			// set main header
			setExcelMainHeader(excelSheet, my_style);

			// set header
			setExcelHeader(excelSheet, my_style1);

			// set Data
			setExcelRows(excelSheet, lChqPresentationBean, my_style2, my_style3);

			for (int i = 0; i < 13; i++) {
				excelSheet.autoSizeColumn(i);
			}

			
			if (lChqPresentationBean.size()> 0) {
				isSuccess = true;
			} else {
				isSuccess = false;

			}

			// export excell
			String sFileUrl = writeExcel(workbook, filepath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return isSuccess;
	}

	public void setExcelMainHeader(HSSFSheet excelSheet, HSSFCellStyle my_style) {
		
		
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 12));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Dental Council of India");
		cell.setCellStyle(my_style);
		
		Row row1 = excelSheet.createRow((short) 1);
		excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 12));
		Cell cell1 = row1.createCell((short) 0);
		cell1.setCellValue("Aiwan-E-Galib Marg, Kotla Road, New Delhi");
		cell1.setCellStyle(my_style);
		
		Row row2 = excelSheet.createRow((short) 2);
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 12));
		Cell cell2 = row2.createCell((short) 0);
		cell2.setCellValue("Cheque Status Report");
		cell2.setCellStyle(my_style);
	}

	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow((short) 3);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Sl #");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Company Name");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Customer Name");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Cheque No");

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Cheque Date");

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Cheque Amnt");

			Cell cell6 = row.createCell(6);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Cheque Received Date");

			Cell cell7 = row.createCell(7);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("isPresented");

			Cell cell8 = row.createCell(8);
			cell8.setCellStyle(my_style1);
			cell8.setCellValue("Presented Date");

			Cell cell9 = row.createCell(9);
			cell9.setCellStyle(my_style1);
			cell9.setCellValue("Deposited Bank");

			Cell cell10 = row.createCell(10);
			cell10.setCellStyle(my_style1);
			cell10.setCellValue("isRealised");

			Cell cell11 = row.createCell(11);
			cell11.setCellStyle(my_style1);
			cell11.setCellValue("Realised Date");

			Cell cell12 = row.createCell(12);
			cell12.setCellStyle(my_style1);
			cell12.setCellValue("Status");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRows(HSSFSheet excelSheet, List<ChqPresentationBean> lChqPresentationBean, HSSFCellStyle my_style2, HSSFCellStyle my_style3) {
		int record = 4, sno = 1;
		int firstRow = 0, firstSgRow = 0;
		int lastRow = 0;
		try {

			for (ChqPresentationBean objChqPresentationBean : lChqPresentationBean) {
				Row row = excelSheet.createRow((short) record++);
				row.setHeight((short) 350);
				for (int i = 0; i < 13; i++) {
					excelSheet.autoSizeColumn(i);
				}

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style2);
				cell0.setCellValue(sno++);

				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(checkNullValue(objChqPresentationBean.getCompanyName()));

				Cell cell2 = row.createCell(2);
				cell2.setCellStyle(my_style2);
				cell2.setCellValue(checkNullValue(objChqPresentationBean.getCustomerName()));

				Cell cell3 = row.createCell(3);
				cell3.setCellStyle(my_style2);
				cell3.setCellValue(checkNullValue(objChqPresentationBean.getChqNo()));

				Cell cell4 = row.createCell(4);
				cell4.setCellStyle(my_style2);
				cell4.setCellValue(objChqPresentationBean.getChqDate());

				Cell cell5 = row.createCell(5);
				cell5.setCellStyle(my_style2);
				cell5.setCellValue(objChqPresentationBean.getChqAmnt());

				Cell cell6 = row.createCell(6);
				cell6.setCellStyle(my_style2);
				cell6.setCellValue(objChqPresentationBean.getChqRcvdDate());

				Cell cell7 = row.createCell(7);
				cell7.setCellStyle(my_style2);
				cell7.setCellValue(checkNullValue(objChqPresentationBean.getIsPresented()));

				Cell cell8 = row.createCell(8);
				cell8.setCellStyle(my_style2);
				cell8.setCellValue(checkNullValue(objChqPresentationBean.getPresentDate()));

				Cell cell9 = row.createCell(9);
				cell9.setCellStyle(my_style2);
				cell9.setCellValue(checkNullValue(objChqPresentationBean.getDepositBank()));

				Cell cell10 = row.createCell(10);
				cell10.setCellStyle(my_style2);
				cell10.setCellValue(objChqPresentationBean.getIsRealised());

				Cell cell11 = row.createCell(11);
				cell11.setCellStyle(my_style2);
				cell11.setCellValue(objChqPresentationBean.getRealisedDate());

				Cell cell12 = row.createCell(12);
				cell12.setCellStyle(my_style2);
				cell12.setCellValue(objChqPresentationBean.getStatus());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcel(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/ChequeStatus.xls";

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(sOutFile);
			myWorkBook.write(fileOut);
			url = path + "/ChequeStatus.xls";
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

	private String checkNullValue(String value) {

		String t = "";
		try {
			if (value.trim() == null || value.trim().equalsIgnoreCase("null")) {
				value = "";
			}
		} catch (Exception e) {
			return t;
		}

		return value;
	}

}
