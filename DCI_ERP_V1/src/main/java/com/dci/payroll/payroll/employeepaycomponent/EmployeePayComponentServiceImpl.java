package com.dci.payroll.payroll.employeepaycomponent;

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
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;


@Service
public class EmployeePayComponentServiceImpl implements EmployeePayComponentService {
	@Autowired
	EmployeePayComponentDAO empPayComDAO;

	@Override
	public List<Map<String, Object>> getEmployeePayComponentList(String employeeId) throws Exception {
		return empPayComDAO.getEmployeePayComponentList(employeeId);
	}

	@Override
	public List<Map<String, Object>> getEmployeePayComponentList1() throws Exception {
		// TODO Auto-generated method stub
		return empPayComDAO.getEmployeePayComponentList1();
	}

	@Override
	public List<Map<String, Object>> getEmployeePayComponentList2(String departmentId) throws Exception {
		// TODO Auto-generated method stub
		return empPayComDAO.getEmployeePayComponentList2(departmentId);
	}

	@Override
	public List<Map<String, Object>> getEmployeePayComponentList3(String employeeId) throws Exception {
		return empPayComDAO.getEmployeePayComponentList3(employeeId);
	}

	@Override
	public List<EmployeePayComponentBean> getListByIdDate(String employeeId, String fromDate) throws Exception {
		// TODO Auto-generated method stub
		return empPayComDAO.getListByIdDate(employeeId, fromDate);
	}

	@Override
	public boolean insertEmployeePayComponent(ArrayList<EmployeePayComponentBean> empPayComBean) throws Exception {
		// TODO Auto-generated method stub
		return empPayComDAO.insertEmployeePayComponent(empPayComBean);
	}

	@Override
	public EmployeePayComponentBean getEmployeeMaxDate(String employeeId) throws Exception {
		// TODO Auto-generated method stub
		return empPayComDAO.getEmployeeMaxDate(employeeId);
	}

	@Override
	public boolean updateEmployeePayComponent(ArrayList<EmployeePayComponentBean> empPayComBean) throws Exception {
		// TODO Auto-generated method stub
		return empPayComDAO.updateEmployeePayComponent(empPayComBean);
	}

	@Override
	public boolean deleteEmployeePayComponenet(String employeeId, String fromDate) throws Exception {
		// TODO Auto-generated method stub
		return empPayComDAO.deleteEmployeePayComponenet(employeeId, fromDate);
	}

	@Override
	public EmployeePayComponentBean uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		return empPayComDAO.uploadFile(file);
	}

	@Override
	public void exportExcel(EmployeePayComponentBean employeePayComponentBean, String filePath) throws CustomException, IOException, Exception {

	}

	@Override
	public void exportSampleExcel(EmployeePayComponentBean employeePayComponentBean, String filePath) throws CustomException, IOException, Exception {
		List<EmployeePayComponentBean> payComponentList = new ArrayList<>();
		List<EmployeePayComponentBean> employeeList = new ArrayList<>();
		payComponentList = empPayComDAO.getSampleExcelList(employeePayComponentBean);
		employeeList = empPayComDAO.getEmployeeList(employeePayComponentBean);
		GeneratePTListExportALL(payComponentList, employeeList, filePath);
	}

	public void GeneratePTListExportALL(List<EmployeePayComponentBean> componentList, List<EmployeePayComponentBean> empList, String filePath) throws Exception, IOException {

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
		setHeading(wb, style);
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

		Row row2 = sheet1.createRow((short) 2);

		org.apache.poi.ss.usermodel.Cell cell;
		cell = row1.createCell((short) 0);
		cell.setCellValue("Month-(MM/DD/YYYY)");

		CellStyle cellStyle = wb.createCellStyle();
		CreationHelper createHelper = wb.getCreationHelper();
		cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("mm/dd/yyyy"));
		cell = row1.createCell((short) 1);
		cell.setCellValue(new Date());
		cell.setCellStyle(cellStyle);

		cell = row2.createCell((short) 0);
		cell.setCellValue("Employee Id");

		cell = row2.createCell((short) 1);
		cell.setCellValue("Employee Name");

		int j = 2;

		for (EmployeePayComponentBean componentBean : componentList) {
			setHeading(wb, style);
			cell = row2.createCell((short) j);
			cell.setCellValue(componentBean.getPayComponentId());

			j++;
		}

		sheet1.setColumnWidth((short) 0, (short) ((50 * 8) / ((double) 1 / 20)));

		for (EmployeePayComponentBean componentBean : empList) {
			rowNumber = rowNumber + 1;
			Row row3 = sheet1.createRow((short) rowNumber);
			cell = row3.createCell((short) 0);
			cell.setCellValue(componentBean.getEmployeeId());
			cell = row3.createCell((short) 1);
			cell.setCellValue(componentBean.getEmployeeName());

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

	
	/*private String writeExcel(HSSFWorkbook myWorkBook, String path) {

		Date currentDate = new Date();

		String sOutFile = path + "Sample_Employee_Salary_Upload_File.xls";

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
	
	
	
	
	
	@Override
	public EmployeePayComponentResultBean getpayExport(List<Map<String, Object>> empPayComBean) throws Exception {
		// TODO Auto-generated method stub
		return empPayComDAO.getpayExport(empPayComBean);
	}

	@Override
	public EmployeePayComponentResultBean checkArrearDate(String arrearDate, String employeeId) {
		// TODO Auto-generated method stub
		return empPayComDAO.checkArrearDate(arrearDate, employeeId);
	}

}