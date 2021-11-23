package com.dci.common.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class CommonExcelUtils {

	/**
	 * Time stamp
	 *
	 * @return
	 */
	public static Timestamp getCurrentTimeStamp() {
		java.util.Date today = new java.util.Date();
		return new Timestamp(today.getTime());
	}

	/**
	 *
	 * @param s1
	 * @return
	 */
	public static String checkEmptyString(String s1) {
		if (s1 == null || s1.equalsIgnoreCase("null")) {
			return "";
		} else {
			return s1;
		}
	}
	
	public static boolean isEmpty(String s1) {
		if (s1 == null || s1.equalsIgnoreCase("null") || s1.equals("")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String returnEmptyNull(String s1) {
		if (s1 == null || s1.equalsIgnoreCase("null") || s1.equals("")) {
			return null;
		} else {
			return s1;
		}
	}
	
	public static String returnNull(String s1) {
		if (s1 == null || s1.trim().equalsIgnoreCase("null") || s1.trim().equals("") || s1.trim().equals("-")) {
			return null;
		} else {
			return s1;
		}
	}

	public static String checkEmptyStringToHypen(String s1) {
		if (s1 == null || s1.equalsIgnoreCase("null")) {
			return "-";
		} else {
			return s1;
		}
	}
	public static String checkEmptyStringSToHypen(String s1) {
		if (s1 == null || s1.equalsIgnoreCase("null") || s1.equals("") ) {
			return "-";
		} else {
			return s1;
		}
	}

	public static String checkEmptyStringToZero(String s1) {
		if (s1 == null || s1.equalsIgnoreCase("null") || s1.isEmpty()) {
			return "0";
		} else {
			return s1;
		}
	}
	
	public static String checkEmptyStringToOne(String s1) {
		if (s1 == null || s1.equalsIgnoreCase("null") || s1.equals("") || s1.equals("0")) {
			return "1";
		} else {
			return s1;
		}
	}

	public static int convertStringToInt(String s) {
		if (s == null || "null".equalsIgnoreCase(s)) {
			return 0;
		} else if (s.trim().length() <= 0) {
			return 0;
		} else {
			return Integer.parseInt(s);
		}
	}

	public static double convertStringToDouble(String s) {
		if (s == null || "null".equalsIgnoreCase(s)) {
			return 0;
		} else if (s.trim().length() <= 0) {
			return 0;
		} else {
			return Double.parseDouble(s);
		}
	}

	public static String getOnlyStrings(String s) {
		Pattern pattern = Pattern.compile("[^a-z A-Z]");
		Matcher matcher = pattern.matcher(s.replaceAll(" ", ""));
		String name = matcher.replaceAll("").substring(0, 3).toUpperCase();
		return name;
	}

	public static String checkValuesEqual(int temp1,int temp2){
		return (temp1 == temp2) ? "Green" : "Red";
	}
	/**
	 * It returns String to Date
	 *
	 * @param dateValue
	 * @return
	 */
	public static java.sql.Timestamp getCurrentDateFromString(String dateValue) {
		Date stringToDate = null;
		java.sql.Timestamp stringtodate1 = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			stringToDate = dateFormat.parse(dateValue);
			stringtodate1 = new Timestamp(stringToDate.getTime());

		} catch (Exception ae) {

		}
		return stringtodate1;
	}

	public static java.sql.Timestamp getCurrentDateFromStringtest(String dateValue) {
		Date stringToDate = null;
		java.sql.Timestamp stringtodate1 = null;
		try {
			if (!dateValue.equals("")) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				stringToDate = dateFormat.parse(dateValue);
				stringtodate1 = new Timestamp(stringToDate.getTime());
			} else {
				stringtodate1 = null;
			}

		} catch (Exception ae) {

		}
		return stringtodate1;
	}

	public static String getCurrentDateToString(java.sql.Timestamp dateValue) {
		String stringToDate = null;
		try {
			if (dateValue != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				stringToDate = dateFormat.format(dateValue);
			} else {
				stringToDate = "";
			}
		} catch (Exception ae) {

		}
		return stringToDate;
	}

	public static String getCurrentDateToStringWihTime(java.sql.Timestamp dateValue) {
		String stringToDate = null;
		try {
			if (dateValue != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:MM");
				stringToDate = dateFormat.format(dateValue);
			} else {
				stringToDate = "";
			}
		} catch (Exception ae) {

		}
		return stringToDate;
	}
	
	public static BigDecimal truncateDecimal(double x ) {
		if (x > 0) {
			return new BigDecimal(String.valueOf(x)).setScale(3, BigDecimal.ROUND_FLOOR);
		} else {
			return new BigDecimal(String.valueOf(x)).setScale(3, BigDecimal.ROUND_CEILING);
		}
	}
	

	/**
	 * It Returns Date to String
	 *
	 * @param date
	 * @return
	 */
	public static String getCurrentDateToString(Date date) {
		String dateToString = "";
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dateToString = dateFormat.format(date);
		} catch (Exception ae) {
		}
		return dateToString;
	}

	public static String getCurrentDateToStringwithTime(Date date) {
		String dateToString = "";
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:MM");
			dateToString = dateFormat.format(date);
		} catch (Exception ae) {
		}
		return dateToString;
	}

	public String getCurrentDateFromStringtestwithTime(String dateValue) {
		Date stringToDate = null;

		try {
			if (!dateValue.equals("")) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				stringToDate = dateFormat.parse(dateValue);

			}
		} catch (Exception ae) {

		}
		return stringToDate.toString();
	}

	/**
	 * Excel Main Header
	 *
	 * @param excelsheet
	 * @param mainHeaderstyle
	 * @param headerName
	 * @param lastColumn
	 */
	public void setExcelMainHeader(HSSFSheet excelsheet, HSSFCellStyle mainHeaderstyle, String headerName, int lastColumn) {
		Row row = excelsheet.createRow(0);
		excelsheet.addMergedRegion(new CellRangeAddress(0, 1, 0, lastColumn));
		// First Row,Last Row,First Column,Last Column

		Cell cell = row.createCell((short) 0);
		cell.setCellValue(headerName);
		cell.setCellStyle(mainHeaderstyle);
	}

	/**
	 * Excel Sub Header
	 *
	 * @param excelsheet
	 * @param subHeaderStyle
	 * @param headerSubNames
	 */

	public void setExcelSubHeader(HSSFSheet excelsheet, HSSFCellStyle subHeaderStyle, String headerSubNames[]) {
		try {
			Row row = excelsheet.createRow((short) 2);
			row.setHeight((short) 350);
			for (int i = 0; i < headerSubNames.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(headerSubNames[i]);
				cell.setCellStyle(subHeaderStyle);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Excel Write Method
	 *
	 * @param workbook
	 * @param filePath
	 * @param filePathName
	 */
	public void writeExcel(HSSFWorkbook workbook, String filePath, String filePathName) {
		String fileName = filePath + "/" + filePathName + ".xls";
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(fileName);
			workbook.write(fileOut);
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

	/**
	 * File Upload
	 *
	 */

	public ArrayList excelUpload(MultipartFile file) {
		String fileName = "";
		ArrayList alcellResult = null;
		ArrayList alrowResult = null;
		boolean fileExtension;
		Workbook workbook = null;
		try {
			if (!file.isEmpty()) {
				fileName = file.getOriginalFilename();
				fileExtension = fileName.endsWith(".xls");
				if (fileExtension) {

					workbook = new HSSFWorkbook(file.getInputStream());
					HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);
					Iterator<Row> rowIterator = sheet.rowIterator();
					alrowResult = new ArrayList();
					while (rowIterator.hasNext()) {
						Row rowIt = rowIterator.next();
						if (rowIt.getRowNum() >= 3) {

							Iterator<Cell> cellIterator = rowIt.cellIterator();
							alcellResult = new ArrayList();
							while (cellIterator.hasNext()) {

								Cell cellIt = cellIterator.next();

								alcellResult.add(cellIt);

							}
						}
						alrowResult.add(alcellResult);
					}
					System.out.println("ArrayList Size" + alrowResult);

				} else if (!fileExtension) {
					workbook = new XSSFWorkbook(file.getInputStream());
					XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);
					Iterator<Row> rowIterator = sheet.rowIterator();
					alrowResult = new ArrayList();
					while (rowIterator.hasNext()) {

						Row rowIt = rowIterator.next();
						if (rowIt.getRowNum() >= 3) {
							Iterator<Cell> cellIterator = rowIt.cellIterator();
							alcellResult = new ArrayList();
							while (cellIterator.hasNext()) {

								Cell cellIt = cellIterator.next();
								alcellResult.add(cellIt);

							}
						}
						alrowResult.add(alcellResult);

					}
				}
			}

		} catch (Exception ae) {
			ae.printStackTrace();
		}
		return alrowResult;
	}

	private int sno;
	private String ledgerDate;
	private String groupName;
	private String balance;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getLedgerDate() {
		return ledgerDate;
	}

	public void setLedgerDate(String ledgerDate) {
		this.ledgerDate = ledgerDate;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

}
