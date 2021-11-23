package com.dci.tenant.finance.reports.vesselbudget;
/*package com.mbk.tenant.finance.reports.vesselbudget;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.mbk.common.util.CustomException;
import com.mbkfinance.budget.budgetAllocation.BudgetAllocationBean;
import com.mbkfinance.budget.budgetAllocation.BudgetAllocationDtlBean;
import com.mbk.tenant.finance.jvoucher.JournalVoucherDAO;
import com.mbk.tenant.finance.jvoucher.JournalVoucherDTO;
import com.mbk.tenant.user.UserDetail;


@Service
public class VesselBudgetActualsServiceImpl implements VesselBudgetActualsService {
	@Autowired
	VesselBudgetActualsDAO budgetActualsDAO;
	@Autowired
	JournalVoucherDAO journalVoucherDAO;
	
	@Override
	public List<BudgetAllocationBean> getBudgetActualsList() throws CustomException {
		return budgetActualsDAO.getBudgetActualsList();
	}

	@Override
	public VesselBudgetActualsBean getBudgetAllocationDetails(VesselBudgetActualsBean objBudgetActualsBean) throws CustomException {
		return budgetActualsDAO.getBudgetAllocationDetails(objBudgetActualsBean);
	}

	@Override
	public List<VesselBudgetActualsBean> getVesselList() {
		return budgetActualsDAO.getVesselList();
	}
	
	@Override
	public BudgetAllocationBean getBudgetActuals(BudgetAllocationBean budgetAllocationBean) throws CustomException {
		return budgetActualsDAO.getBudgetActuals(budgetAllocationBean);
	}


	@Override
	public String excelExport(VesselBudgetActualsBean objBudgetActualsBean, String filePath) throws Exception {

		List<VesselBudgetActualsBean> list = new ArrayList<VesselBudgetActualsBean>();

		int objindx1 = 0, objindx3 = 0;
		String msg = "";

		list = budgetActualsDAO.getVesselName(objBudgetActualsBean);
		if (list.size() > 0) {
			VesselBudgetActualsBean budgetActualsBean = list.get(objindx1);

			XSSFWorkbook workbook = new XSSFWorkbook();

			XSSFCellStyle my_style = workbook.createCellStyle();
			XSSFSheet sheet1 = workbook.createSheet("Budget vs Actuals");

			my_style.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			Font font = workbook.createFont();

			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);

			XSSFCellStyle my_style1 = workbook.createCellStyle();

			Font font1 = workbook.createFont();

			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font1.setFontHeightInPoints((short) 10);
			my_style1.setFont(font1);

			XSSFCellStyle my_style2 = workbook.createCellStyle();

			my_style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style2.setAlignment(my_style.ALIGN_LEFT);

			ResultSet resultSet = null;

			Row rowheader1 = sheet1.createRow((short) 1);

			org.apache.poi.ss.usermodel.Cell cell;

			cell = rowheader1.createCell(0);
			cell.setCellValue("Budget Status as of Date:");
			cell.setCellStyle(my_style1);

			cell = rowheader1.createCell(1);
			cell.setCellValue(budgetActualsBean.getToDate());

			Row rowheader2 = sheet1.createRow(3);

			cell = rowheader2.createCell(0);
			cell.setCellValue("Vessel");
			cell.setCellStyle(my_style1);

			cell = rowheader2.createCell(1);
			cell.setCellValue(budgetActualsBean.getVesselName());

			List<VesselBudgetActualsDtlBean> budgetAmountList = budgetActualsDAO.getAllocatedAmount(objBudgetActualsBean);

			int count = budgetActualsDAO.getAllocatedCount(objBudgetActualsBean);
			for (int r = 6; r < count * 10; r++) {
				int crow = r;

				VesselBudgetActualsDtlBean budgetActualsDtlBean = budgetAmountList.get(objindx3);

				Row rowheader3 = sheet1.createRow(crow++);

				cell = rowheader3.createCell(0);
				cell.setCellValue("Department");
				cell.setCellStyle(my_style1);

				cell = rowheader3.createCell(1);
				cell.setCellValue(budgetActualsDtlBean.getDepartmentName());

				Row rowheader4 = sheet1.createRow(crow++);

				cell = rowheader4.createCell(0);
				cell.setCellValue("budget code");
				cell.setCellStyle(my_style1);

				cell = rowheader4.createCell(1);
				cell.setCellValue(budgetActualsDtlBean.getBudgetCode());

				Row rowheader41 = sheet1.createRow(crow++);

				cell = rowheader41.createCell(0);
				cell.setCellValue("budget description");
				cell.setCellStyle(my_style1);

				cell = rowheader41.createCell(1);
				cell.setCellValue(budgetActualsDtlBean.getBudgetDesc());

				Row rowheader5 = sheet1.createRow(crow++);

				cell = rowheader5.createCell(3);
				cell.setCellValue("Allocated");
				cell.setCellStyle(my_style1);

				cell = rowheader5.createCell(4);
				cell.setCellValue("Invoices/P.O.");
				cell.setCellStyle(my_style1);

				cell = rowheader5.createCell(5);
				cell.setCellValue("Open Requisitions");
				cell.setCellStyle(my_style1);

				cell = rowheader5.createCell(6);
				cell.setCellValue("Total Spent");
				cell.setCellStyle(my_style1);

				cell = rowheader5.createCell(7);
				cell.setCellValue("Pct");
				cell.setCellStyle(my_style1);

				cell = rowheader5.createCell(8);
				cell.setCellValue("Remaining");
				cell.setCellStyle(my_style1);

				int i = 0, objindx = 0;

				for (i = crow++; i < (crow + 4); i++) {
					VesselBudgetActualsDtlBean budgetActualsDtlBean1 = budgetAmountList.get(objindx);
					Row rowheader6 = sheet1.createRow(i);

					cell = rowheader6.createCell(2);
					cell.setCellValue(budgetActualsDtlBean1.getTerms());
					cell.setCellStyle(my_style1);

					cell = rowheader6.createCell(3);
					cell.setCellValue(budgetActualsDtlBean1.getAllocatedAmount());
					cell.setCellStyle(my_style2);

					cell = rowheader6.createCell(4);
					cell.setCellValue(budgetActualsDtlBean1.getInvoiceLpoAmount());
					cell.setCellStyle(my_style2);

					cell = rowheader6.createCell(5);
					cell.setCellValue(budgetActualsDtlBean1.getOpeningAmount());
					cell.setCellStyle(my_style2);

					cell = rowheader6.createCell(6);
					cell.setCellValue(budgetActualsDtlBean1.getTotalSpendAmount());
					cell.setCellStyle(my_style2);

					cell = rowheader6.createCell(7);
					cell.setCellValue(budgetActualsDtlBean1.getPctAmount());
					cell.setCellStyle(my_style2);

					cell = rowheader6.createCell(8);
					cell.setCellValue(budgetActualsDtlBean1.getBalanceAmount());
					cell.setCellStyle(my_style2);

					objindx++;
				}

				r = i++;
			}
			writeExcel(workbook, filePath);
			msg = "1";
		} else {
			msg = "0";
		}
		return msg;

	}
	@Override
	public String budgetActualsExcelExport(BudgetAllocationBean budgetAllocationBean, String filePath) throws CustomException, IOException {
		 
		String msg = "";
		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFCellStyle my_style = workbook.createCellStyle();
		XSSFSheet sheet1 = workbook.createSheet("Sheet1");

		my_style.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
		my_style.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
		my_style.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
		my_style.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
		Font font = workbook.createFont();

		font.setFontHeight((short) 200);
		font.setFontName("Arial");
		font.setColor(HSSFColor.BLACK.index);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short) 15);
		my_style.setFont(font);

		XSSFCellStyle my_style1 = workbook.createCellStyle();

		Font font1 = workbook.createFont();

		font1.setFontHeight((short) 200);
		font1.setFontName("Arial");
		font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font1.setFontHeightInPoints((short) 10);
		my_style1.setFont(font1);

		XSSFCellStyle my_style2 = workbook.createCellStyle();
		my_style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		my_style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
		my_style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
		my_style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		my_style2.setAlignment(my_style.ALIGN_LEFT);

		
		XSSFCellStyle txtAlignRight = workbook.createCellStyle();
		Font font2 = workbook.createFont();
		font2.setFontHeight( (short) 200);
		font2.setFontName("Arial");
		font2.setColor(HSSFColor.BLACK.index);
		font2.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		font2.setFontHeightInPoints( (short) 10);

		txtAlignRight.setFont(font2);
		txtAlignRight.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		txtAlignRight.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		txtAlignRight.setBorderRight(XSSFCellStyle.BORDER_THIN);
		txtAlignRight.setBorderTop(XSSFCellStyle.BORDER_THIN);
		txtAlignRight.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
		txtAlignRight.setFillForegroundColor(HSSFColor.WHITE.index);
		txtAlignRight.setFillPattern(txtAlignRight.SOLID_FOREGROUND);
		
		
		XSSFCellStyle totalStyle = workbook.createCellStyle();
		Font font3 = workbook.createFont();
		font3.setFontHeight( (short) 200);
		font3.setFontName("Arial");
		font3.setColor(HSSFColor.BLACK.index);
		font3.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font3.setFontHeightInPoints( (short) 10);
		totalStyle.setFont(font3);
		totalStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		totalStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		totalStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
		totalStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
		totalStyle.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
		totalStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		totalStyle.setFillPattern(totalStyle.SOLID_FOREGROUND);
		
		
		XSSFCellStyle totalStyleLeft = workbook.createCellStyle();
	
		totalStyleLeft.setFont(font3);
		totalStyleLeft.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		totalStyleLeft.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		totalStyleLeft.setBorderRight(XSSFCellStyle.BORDER_THIN);
		totalStyleLeft.setBorderTop(XSSFCellStyle.BORDER_THIN);
		totalStyleLeft.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		totalStyleLeft.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		totalStyleLeft.setFillPattern(totalStyle.SOLID_FOREGROUND);
		
		XSSFCellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFont(font3);
		headerStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
		headerStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		headerStyle.setFillForegroundColor(HSSFColor.LAVENDER.index);
		headerStyle.setFillPattern(headerStyle.SOLID_FOREGROUND);
		
		XSSFCellStyle subHeaderStyle = workbook.createCellStyle();
		subHeaderStyle.setFont(font3);
		subHeaderStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		subHeaderStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		subHeaderStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
		subHeaderStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
		subHeaderStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		subHeaderStyle.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
		subHeaderStyle.setFillPattern(subHeaderStyle.SOLID_FOREGROUND);

			int c=0,crow=0;

			Row row = sheet1.createRow(crow++);
			Cell cell = row.createCell(c++);
			cell.setCellValue("Account Code");
			cell.setCellStyle(headerStyle);

			cell = row.createCell(c++);
			cell.setCellValue("Account Description");
			cell.setCellStyle(headerStyle);
			
			cell = row.createCell(c++);
			cell.setCellValue("Actual");
			cell.setCellStyle(headerStyle);
 
			cell = row.createCell(c++);
			cell.setCellValue("Budget");
			cell.setCellStyle(headerStyle);

			cell = row.createCell(c++);
			cell.setCellValue("Variance");
			cell.setCellStyle(headerStyle);

			cell = row.createCell(c++);
			cell.setCellValue("Variance %");
			cell.setCellStyle(headerStyle);

			int r=1,c1=0;
			DecimalFormat df = new DecimalFormat("##.00");
			double actualTotal=0,budgetTotal=0,actualGt=0,budgetGt=0; 
			
			budgetAllocationBean.setFromDate(budgetAllocationBean.getFromDate());
			budgetAllocationBean.setToDate(budgetAllocationBean.getToDate());
			for(String vesselName: budgetAllocationBean.getVesselCodeList()){
					budgetAllocationBean.setVesselName(vesselName);
					System.out.println("vesselName : "+vesselName);
					BudgetAllocationBean  budgetActObj = budgetActualsDAO.getBudgetActualsExcelData(budgetAllocationBean);
					actualTotal=0;budgetTotal=0;
					
					Row rowheader = sheet1.createRow(r++);
					cell = rowheader.createCell(0);
					cell.setCellValue(vesselName);
					cell.setCellStyle(subHeaderStyle);

					cell = rowheader.createCell(1);
					cell.setCellValue("");
					cell.setCellStyle(subHeaderStyle);
					
					cell = rowheader.createCell(2);
					cell.setCellValue("");
					cell.setCellStyle(subHeaderStyle);
					
					cell = rowheader.createCell(3);
					cell.setCellValue("");
					cell.setCellStyle(subHeaderStyle);
					
					cell = rowheader.createCell(4);
					cell.setCellValue("");
					cell.setCellStyle(subHeaderStyle);
					
					cell = rowheader.createCell(5);
					cell.setCellValue("");
					cell.setCellStyle(subHeaderStyle);
					
					for(BudgetAllocationDtlBean objDtl:budgetActObj.getBudgetAllocationDtlBeanList()){
							c1=0;
							Row rowDtl = sheet1.createRow(r++);
							cell = rowDtl.createCell(c1++);
							cell.setCellValue(objDtl.getAcctHeadCode());
							cell.setCellStyle(my_style2);
		
							cell = rowDtl.createCell(c1++);
							cell.setCellValue(objDtl.getBudgetDesc());
							cell.setCellStyle(my_style2);
		
							cell = rowDtl.createCell(c1++);
							cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell.setCellValue(Double.parseDouble(df.format(objDtl.getActualAmt())));
							cell.setCellStyle(txtAlignRight);
							actualTotal+=objDtl.getActualAmt();
							
							cell = rowDtl.createCell(c1++);
							cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell.setCellValue(Double.parseDouble(df.format(objDtl.getAllocatedAmount())));
							cell.setCellStyle(txtAlignRight);
							budgetTotal+=objDtl.getAllocatedAmount();
							
							cell = rowDtl.createCell(c1++);
							cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell.setCellValue(Double.parseDouble(df.format(objDtl.getActualAmt()-objDtl.getAllocatedAmount())));
							cell.setCellStyle(txtAlignRight);
							
						
							cell = rowDtl.createCell(c1++);
							cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							if(objDtl.getAllocatedAmount()!=0){
								cell.setCellValue(Double.parseDouble(df.format(((objDtl.getActualAmt()-objDtl.getAllocatedAmount())/objDtl.getAllocatedAmount())*100)));
							}else{
								cell.setCellValue(Double.parseDouble(df.format(((objDtl.getActualAmt()-objDtl.getAllocatedAmount())/1)*100)));
							}
							
							cell.setCellStyle(txtAlignRight);
						}
						c1=0;
						Row rowDtl = sheet1.createRow(r++);
						cell = rowDtl.createCell(c1++);
						cell.setCellValue("Total For "+vesselName);
						cell.setCellStyle(totalStyleLeft);
	
						cell = rowDtl.createCell(c1++);
						cell.setCellValue("");
						cell.setCellStyle(totalStyleLeft);
	
						cell = rowDtl.createCell(c1++);
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell.setCellValue(df.format(actualTotal));
						cell.setCellStyle(totalStyle);
						actualGt+=actualTotal;
						
						cell = rowDtl.createCell(c1++);
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell.setCellStyle(totalStyle);
						cell.setCellValue(df.format(budgetTotal));
						
						budgetGt+=budgetTotal;
						
						cell = rowDtl.createCell(c1++);
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell.setCellValue(df.format(actualTotal-budgetTotal));
						cell.setCellStyle(totalStyle);
						
												
						cell = rowDtl.createCell(c1++);
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						if(budgetTotal!=0){
							cell.setCellValue(df.format(((actualTotal-budgetTotal)/budgetTotal)*100));
						}else{
							cell.setCellValue(df.format(((actualTotal-budgetTotal)/1)*100));
						}
						cell.setCellStyle(totalStyle);
					}
			c1=0;
			Row rowDtl = sheet1.createRow(r++);
			cell = rowDtl.createCell(c1++);
			cell.setCellValue("Grand Total ");
			cell.setCellStyle(totalStyleLeft);

			cell = rowDtl.createCell(c1++);
			cell.setCellValue("");
			cell.setCellStyle(totalStyleLeft);

			cell = rowDtl.createCell(c1++);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(df.format(actualGt));
			cell.setCellStyle(totalStyle);
			
			cell = rowDtl.createCell(c1++);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellStyle(totalStyle);
			cell.setCellValue(df.format(budgetGt));
			
			
			cell = rowDtl.createCell(c1++);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(df.format(actualGt-budgetGt));
			cell.setCellStyle(totalStyle);
			
			
			cell = rowDtl.createCell(c1++);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			if(budgetGt!=0){
				cell.setCellValue(df.format(((actualGt-budgetGt)/budgetGt)*100));
			}else{
				cell.setCellValue(df.format(((actualGt-budgetGt)/budgetGt)*100));
			}
			cell.setCellStyle(totalStyle);
			for (int i=0; i<200; i++){
				sheet1.autoSizeColumn(i);
				}
			
			writeExcel(workbook, filePath);
			msg = "1";
		
		return msg;

	}
	private void writeExcel(XSSFWorkbook myWorkBook, String filePath) throws IOException {
		String l_str_file_out = filePath;
		FileOutputStream fileOut = null;
		// System.out.println("filepath" + l_str_file_out);

		fileOut = new FileOutputStream(l_str_file_out);
		myWorkBook.write(fileOut);

		fileOut.close();

	}


	@Override
	@Transactional
	public String uploadFile(MultipartFile file) {

		ArrayList<JournalVoucherDTO> journalVoucherDTO = new ArrayList<JournalVoucherDTO>();
		String fileName = file.getOriginalFilename();
		Iterator<Row> rowIterator = null;
		int stopExec = 0;
		Workbook workbook = null;
		StringBuffer sb = new StringBuffer();
		String sMessage = "";
		try {
			if (fileName.endsWith("xls")) {
				workbook = new HSSFWorkbook(file.getInputStream());
				HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);
				rowIterator = sheet.rowIterator();
			} else if (fileName.endsWith("xlsx")) {
				workbook = new XSSFWorkbook(file.getInputStream());
				XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);
				rowIterator = sheet.rowIterator();
			} else {
				sb.append("Not a valid file format");
			}

			int rowCnt = 0,  iCount=1;
			double bcDtlAmount=0.0, tcDtlAmount=0.0;
			List<BudgetAllocationDtlBean> budgetAllocationDtlList = new ArrayList<BudgetAllocationDtlBean>();
			BudgetAllocationBean budgetAllocHdr = new BudgetAllocationBean();			
			//JournalVoucherBean journalVoucherBeanDtl = null;
			while (rowIterator.hasNext()) {
				
				
				Row row = rowIterator.next();
				if( row != null ){
					rowCnt=row.getRowNum()+1;
					
					if(row.getRowNum()==2){
						
						Cell fromDate = row.getCell((short) 1);
						java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/MM/yyyy");
						if (fromDate == null) {
							sb.append(" row -" + (rowCnt) + " : Journal Date is empty. ");
							sb.append("<br>");		
						} else if (fromDate.getCellType() == 1) {
							sb.append(" row- " + (rowCnt) + " : Journal Date Format Should be (DD/MM/YYYY). ");
							sb.append("<br>");		
						} else if (fromDate.getCellType() == 0) {
							budgetAllocHdr.setFromDate(formatter.format(fromDate.getDateCellValue()));

						} else{
							sb.append(" row- " + (rowCnt) + " : Journal Date Format Should be (DD/MM/YYYY). ");
							sb.append("<br>");
						}
						
						Cell toDate = row.getCell((short) 3);
						if (toDate == null) {
							sb.append(" row -" + (rowCnt) + " : Journal Date is empty. ");
							sb.append("<br>");		
						} else if (toDate.getCellType() == 1) {
							sb.append(" row- " + (rowCnt) + " : Journal Date Format Should be (DD/MM/YYYY). ");
							sb.append("<br>");		
						} else if (toDate.getCellType() == 0) {
							budgetAllocHdr.setToDate(formatter.format(toDate.getDateCellValue()));

						} else{
							sb.append(" row- " + (rowCnt) + " : Journal Date Format Should be (DD/MM/YYYY). ");
							sb.append("<br>");
						}
					}
					 
					
					if (stopExec != 0) {
						break;
					}
					
					if (row.getRowNum() > 4) {
						String companyShortName = "";
						String firstColCrDr = ""; 
						BudgetAllocationDtlBean budgetAllocDtl = new BudgetAllocationDtlBean();
						//Cell crdrFirstColumn = row.getCell((short) 0);
						
						 if ((row.getCell((short)0) == null || row.getCell((short) 0).getCellType() == 3)
										&& (row.getCell((short) 2) == null || row.getCell((short) 2).getCellType() == 3)
										&& (row.getCell((short) 4) == null || row.getCell((short) 4).getCellType() == 3)
										&& (row.getCell((short) 8) == null || row.getCell((short) 8).getCellType() == 3)
										) {

									break;

								} else{	
							
									Cell company = row.getCell((short) 0);
									
									if(company!=null){
											companyShortName = company.getStringCellValue().trim();
											String companyCode = journalVoucherDAO.getCompanyCode(companyShortName);
											if (companyCode != null && !companyCode.trim().equalsIgnoreCase("null") && !companyCode.trim().isEmpty()) {
												budgetAllocDtl.setCompanyCode(companyCode);								
											} else {
												sb.append(" row- " + (rowCnt) + " : " + "Company is not valid");
												sb.append("<br>");
											}
									}
								
									Cell Vessel = row.getCell((short)1);
									if (Vessel != null) {
										if(!Vessel.toString().equals("")){
											String vesselCode = journalVoucherDAO.checkVessel(Vessel.getStringCellValue().trim());
											if (vesselCode != null && !vesselCode.trim().equalsIgnoreCase("null") && !vesselCode.trim().isEmpty()) {
												budgetAllocDtl.setVesselId(vesselCode);
												
											}else{
													sb.append(" row- " + (rowCnt) + " : " + "Vessel is not valid");
													sb.append("<br>");
											}
										}else{
												sb.append(" row- " + (rowCnt) + " : " + "Vessel should not be empty");
												sb.append("<br>");
										}
									}
									
								
									Cell AccountHead = row.getCell((short) 2);
									boolean acctHeadValid=false;
									if (AccountHead != null) {
										String acctHeadCode="";
										if (AccountHead.getCellType() == 0) {
											acctHeadCode= String.valueOf(AccountHead.getNumericCellValue());

										} else if (AccountHead.getCellType() == 1) {

											acctHeadCode=AccountHead.getStringCellValue().trim();

										}
										
										String sAcctHeadCode = journalVoucherDAO.getAccountHeadCode(acctHeadCode.trim());
										if (sAcctHeadCode != null && !sAcctHeadCode.trim().equalsIgnoreCase("null") && !sAcctHeadCode.trim().isEmpty()) {
											budgetAllocDtl.setAcctHeadCode(sAcctHeadCode);
											budgetAllocDtl.setBudgetCode(sAcctHeadCode);
											acctHeadValid=true;
										} else {
											sb.append(" row- " + (rowCnt) + " : " + "Account head is not valid");
											sb.append("<br>");
										}
									} else {
										sb.append(" row- " + (rowCnt) + " : " + "Account head should not be empty");
										sb.append("<br>");
									}
									
									
									Cell acctHeadDesc = row.getCell((short) 3);
									if (acctHeadDesc != null) {
										if (acctHeadDesc.getStringCellValue().trim() != null && !acctHeadDesc.getStringCellValue().trim().equalsIgnoreCase("null")
												&& !acctHeadDesc.getStringCellValue().trim().isEmpty()) {
											budgetAllocDtl.setBudgetDesc(acctHeadDesc.getStringCellValue().trim());
										} else {
											sb.append(" row- " + (rowCnt) + " : " + "A is not valid");
											sb.append("<br>");
										}
									} else {
										sb.append(" row- " + (rowCnt) + " : " + "Narration should not be empty");
										sb.append("<br>");
									}
									
								
									
									Cell firstQtr = row.getCell((short) 4);
									if (firstQtr == null) {
										sb.append(" row -" + (rowCnt) + " : 1st Quarter Amount is empty. ");
										sb.append("<br>");
		
									} else if (firstQtr.getCellType() == 1) {
										sb.append(" row- " + (rowCnt) + " : 1st Quarter Amount should be in number format ");
										sb.append("<br>");
		
									} else if (firstQtr.getCellType() == 0) {
										budgetAllocDtl.setFirstQuarterAmount(firstQtr.getNumericCellValue());										
									}
		
									Cell secondQtr = row.getCell((short) 5);
									if (secondQtr == null) {
										sb.append(" row -" + (rowCnt) + " : 2nd Quarter Amount is empty. ");
										sb.append("<br>");
		
									} else if (secondQtr.getCellType() == 1) {
										sb.append(" row- " + (rowCnt) + " : 2nd Quarter Amount should be in number format ");
										sb.append("<br>");
		
									} else {
										budgetAllocDtl.setSecondQuarterAmount(secondQtr.getNumericCellValue());
									}
									
									
									Cell thirdQtr = row.getCell((short) 6);
									if (thirdQtr == null) {
										sb.append(" row -" + (rowCnt) + " :  3rd Quarter Amount is empty. ");
										sb.append("<br>");
		
									} else if (thirdQtr.getCellType() == 1) {
										sb.append(" row- " + (rowCnt) + " : 3rd Quarter Amount should be in number format ");
										sb.append("<br>");
		
									} else if (thirdQtr.getCellType() == 0) {
										budgetAllocDtl.setThirdQuarterAmount(thirdQtr.getNumericCellValue());										
									}
		
									Cell fourtherQtr = row.getCell((short)7);
									if (fourtherQtr == null) {
										sb.append(" row -" + (rowCnt) + " : 4th Quarter Amount is empty. ");
										sb.append("<br>");
		
									} else if (fourtherQtr.getCellType() == 1) {
										sb.append(" row- " + (rowCnt) + " : 4th Quarter Amount should be in number format ");
										sb.append("<br>");
		
									} else {
										budgetAllocDtl.setFourthQuarterAmount(fourtherQtr.getNumericCellValue());
									}
								
								
									Cell totalAllocAmt = row.getCell((short) 8);
									if (totalAllocAmt == null) {
										sb.append(" row -" + (rowCnt) + " : 4th Quarter Amount is empty. ");
										sb.append("<br>");
		
									} else if (totalAllocAmt.getCellType() == 1) {
										sb.append(" row- " + (rowCnt) + " : 4th Quarter Amount should be in number format ");
										sb.append("<br>");
		
									} else {
										budgetAllocDtl.setAllocatedAmount(totalAllocAmt.getNumericCellValue());
									}
									
									Cell narration = row.getCell((short) 9);
									if (narration != null) {
										if (narration.getStringCellValue().trim() != null && !narration.getStringCellValue().trim().equalsIgnoreCase("null")
												&& !narration.getStringCellValue().trim().isEmpty()) {
											budgetAllocDtl.setNarration(narration.getStringCellValue().trim());
										} else {
											sb.append(" row- " + (rowCnt) + " : " + "A is not valid");
											sb.append("<br>");
										}
									} else {
										sb.append(" row- " + (rowCnt) + " : " + "Narration should not be empty");
										sb.append("<br>");
									}
									
									
									
								
									
									budgetAllocationDtlList.add(budgetAllocDtl);
									
									
									
									//iCount++;
								}
								
					}
				}
			}
			
						 budgetAllocHdr.setBudgetAllocationDtlBeanList(budgetAllocationDtlList);			
			System.out.println("JV Header List"+budgetAllocationDtlList);
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			if (sb.toString().isEmpty()) {
			
				budgetActualsDAO.saveBudgetAllocation(budgetAllocHdr, userId);
				
				sMessage = sb.toString();
				return sMessage;
			} else {
				sMessage = sb.toString();
				return sMessage;
			}

		} catch (Exception e) {
			sMessage="Error";
			e.printStackTrace();
		}

		return sMessage;
	}

}
*/