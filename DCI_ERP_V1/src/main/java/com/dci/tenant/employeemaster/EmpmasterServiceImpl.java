package com.dci.tenant.employeemaster;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CustomException;

@Service
public class EmpmasterServiceImpl implements EmpmasterService {

	@Autowired
	EmpmasterDAO objEmpmasterDAO;

	@Override
	@Transactional
	public boolean addEmpmaster(EmpmasterBean objEmpmasterBean) throws Exception {
		return objEmpmasterDAO.addEmpmaster(objEmpmasterBean);
	}

	@Override
	public List<EmpmasterBean> getEmpmasterList(int limit, int offset) throws Exception {
		return objEmpmasterDAO.getEmpmasterList(limit, offset);
	}

	@Override
	public List getEmployee() {
		return objEmpmasterDAO.getEmployee();
	}

	@Override
	public EmpmasterResultBean getCompany() {
		return objEmpmasterDAO.getCompany();
	}

	@Override
	public EmpmasterResultBean getDepartment() {
		return objEmpmasterDAO.getDepartment();
	}

	@Override
	public EmpmasterResultBean getDesignation() {
		return objEmpmasterDAO.getDesignation();
	}

	@Override
	@Transactional
	public boolean deleteEmpmaster(String empId) throws Exception {
		// TODO Auto-generated method stub
		return objEmpmasterDAO.deleteEmpmaster(empId);
	}

	@Override
	public EmpmasterBean getempmasterValues(String empId) throws Exception {
		return objEmpmasterDAO.getempmasterValues(empId);
	}

	@Override
	@Transactional
	public boolean updateEmpmaster(EmpmasterBean objEmpmasterBean) throws Exception {
		return objEmpmasterDAO.updateEmpmaster(objEmpmasterBean);
	}

	@Override
	public boolean updateUserProfile(EmpmasterBean objEmpmasterBean) throws CustomException {
		return objEmpmasterDAO.updateUserProfile(objEmpmasterBean);
	}

	@Override
	public EmpmasterResultBean updateUserPassword(EmpmasterBean objEmpmasterBean) throws CustomException {
		// TODO Auto-generated method stub
		return objEmpmasterDAO.updateUserPassword(objEmpmasterBean);
	}

	@Override
	public void excellexport(EmpmasterResultBean objWholeData, String filepath, String fileNme) {

		try {
			// Create HSSFWork Book
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFCellStyle mainHeaderStyle = workbook.createCellStyle();
			mainHeaderStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);

			Font font = workbook.createFont();

			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setColor(HSSFColor.BLACK.index);
			font.setFontHeightInPoints((short) 15);

			mainHeaderStyle.setFont(font);

			/**
			 * Style For Focus on SubHeader
			 */

			XSSFCellStyle subHeaderStyle = workbook.createCellStyle();
			subHeaderStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			subHeaderStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
			subHeaderStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
			subHeaderStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			subHeaderStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font1.setColor(HSSFColor.BLACK.index);
			font1.setFontHeightInPoints((short) 10);
			subHeaderStyle.setFont(font1);

			// Create a blank sheet
			XSSFSheet excelsheet = workbook.createSheet("EmployeeMaster");
			setExcelMainHeader(excelsheet, mainHeaderStyle);
			setExcelSubHeader(excelsheet, subHeaderStyle);
			setExcelRows(excelsheet, workbook, objWholeData, subHeaderStyle);
			String fileName = null;
			if (fileNme != null) {
				fileName = fileNme;
			} else {
				fileName = "EmployeeMaster";
			}
			writeExcel(workbook, filepath, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void setExcelSubHeader(XSSFSheet excelsheet, XSSFCellStyle subHeaderStyle) {
		try {
			int count = 0;
			Row row = excelsheet.createRow((short) 4);
			row.setHeight((short) 700);
			subHeaderStyle.setWrapText(true);

			Cell cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Emp Id");

			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Employee Name");

			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Date Of Birth");

			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Date Of Joining");

			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Designation");

			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Department");

			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Mode Of Payment");

			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Access Rights");

			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Probation Period From");
			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Probation Period To");
			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Birth/Identification Mark");
			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Company");
			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Blood Group	");
			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Basic pay");
			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Date Of Leave");
			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Agent");
			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Bank Account Number");
			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Contact Number");
			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Email Id");
			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Passport No");
			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Place Of Issue");
			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Contact Address");
			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Date Of Confirmation");
			cell = row.createCell(count++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("Active");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setExcelRows(XSSFSheet excelsheet, XSSFWorkbook workbook, EmpmasterResultBean objWholeData, XSSFCellStyle subHeaderStyle) {
		List<EmpmasterBean> lcontainerBean = objWholeData.getlEmpmasterBeanExcel();

		try {
			/**
			 * Content
			 */
			XSSFCellStyle my_style2 = workbook.createCellStyle();
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(Font.BOLDWEIGHT_NORMAL);
			font1.setFontHeightInPoints((short) 10);

			my_style2.setFont(font1);
			my_style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style2.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			XSSFCellStyle merge_style = workbook.createCellStyle();
			Font fontmerge = workbook.createFont();
			fontmerge.setFontHeight((short) 200);
			fontmerge.setFontName("Arial");
			fontmerge.setColor(HSSFColor.BLACK.index);
			fontmerge.setBoldweight(Font.BOLDWEIGHT_NORMAL);
			fontmerge.setFontHeightInPoints((short) 10);
			my_style2.setVerticalAlignment(XSSFCellStyle.VERTICAL_TOP);
			merge_style.setFont(fontmerge);

			my_style2.setFont(font1);
			my_style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style2.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			/**
			 * Number Aligned
			 */
			XSSFCellStyle my_style3 = workbook.createCellStyle();
			Font font2 = workbook.createFont();
			font2.setFontHeight((short) 200);
			font2.setFontName("Arial");
			font2.setColor(HSSFColor.BLACK.index);
			font2.setBoldweight(Font.BOLDWEIGHT_NORMAL);
			font2.setFontHeightInPoints((short) 10);

			my_style3.setFont(font2);
			my_style3.setWrapText(true);
			my_style3.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);

			/**
			 * Sub Total and Grand Total
			 */

			XSSFCellStyle totalStyle = workbook.createCellStyle();
			Font font3 = workbook.createFont();
			font3.setFontHeight((short) 200);
			font3.setFontName("Arial");
			font3.setColor(HSSFColor.BLACK.index);
			font3.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font3.setFontHeightInPoints((short) 10);

			totalStyle.setFont(font3);
			totalStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			totalStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			totalStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
			totalStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
			totalStyle.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			XSSFCellStyle totalStyle1 = workbook.createCellStyle();
			Font font4 = workbook.createFont();
			font4.setFontHeight((short) 200);
			font4.setFontName("Arial");
			font4.setColor(HSSFColor.BLACK.index);
			font4.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font4.setFontHeightInPoints((short) 10);

			totalStyle1.setFont(font4);
			totalStyle1.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			totalStyle1.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			totalStyle1.setBorderRight(XSSFCellStyle.BORDER_THIN);
			totalStyle1.setBorderTop(XSSFCellStyle.BORDER_THIN);
			totalStyle1.setAlignment(XSSFCellStyle.ALIGN_RIGHT);

			int rCount = 5;

			for (int i = 0; i < lcontainerBean.size(); i++) {
				int count = 0;
				Row row = excelsheet.createRow((short) rCount);
				Cell cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getEmpId());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getEmpName());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getDob());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getDoj());
				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getDsgn());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getDept());
				System.out.println("DEPARTMENT NAME +++++++++++++++++++++++++++++++++" + lcontainerBean.get(i).getDept());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getMoPay());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getAccessRights());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getPpf());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getPpt());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getBiMark());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getCompany());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getBldGrp());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getbPay());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getLeaveDate());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getAgent());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getAcNo());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getContactNo());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getEmailId());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getPassNo());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getPlaceIssue());

				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getContactAddr());
				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getConfDate());
				cell = row.createCell(count++);
				cell.setCellStyle(my_style2);
				cell.setCellValue(lcontainerBean.get(i).getIsActive());

				rCount = rCount + 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeExcel(XSSFWorkbook workbook, String filePath, String filePathName) {
		String fileName = null;
		if (!filePathName.equals("EmployeeMaster")) {
			fileName = filePath + "/" + filePathName + ".xlsx";
		} else {
			fileName = filePath + "/EmployeeMaster.xlsx";
		}

		System.out.println("file name");
		System.out.println(fileName);
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(fileName);
			System.out.println(fileName);
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

	private void setExcelMainHeader(XSSFSheet excelsheet, XSSFCellStyle mainHeaderstyle) {
		Row row = excelsheet.createRow(0);
		excelsheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 24));
		Cell cell = row.createCell((short) 0);
		cell.setCellStyle(mainHeaderstyle);
		cell.setCellValue("Employee Master");

	}

	@Override
	public EmpmasterResultBean getCompanyLocation() {
		// TODO Auto-generated method stub
		return objEmpmasterDAO.getCompanyLocation();
	}

	/*@Override
	public EmpmasterResultBean uploadPhoto(String emp_id) {
		// TODO Auto-generated method stub
		return null;
	}*/

	

}
