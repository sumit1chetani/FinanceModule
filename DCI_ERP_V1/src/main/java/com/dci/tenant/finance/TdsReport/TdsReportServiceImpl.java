package com.dci.tenant.finance.TdsReport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

//import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.finance.DayBook.DayBookBean;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class TdsReportServiceImpl implements TdsReportService {
	@Autowired
	TdsReportDAO objBudgetReportDAO;

	@Override
	public List<TdsReportBean> searchportDtl(TdsReportBean objPendingapprovalBean) throws Exception {

		return objBudgetReportDAO.searchportDtl(objPendingapprovalBean);
	}

	@Override
	public boolean excellExport(TdsReportResultBean ObjPendingapprovalResultBean, TdsReportBean ObjPendingapprovalBean, String pdfFile) {
		boolean isSuccess =false;

		
		try {
					// Blank workbook
			// HSSFWorkbook workbook = new HSSFWorkbook();

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFCellStyle my_style = workbook.createCellStyle();

			/*
			 * HSSFPalette palette = workbook.getCustomPalette();
			 * palette.setColorAtIndex(HSSFColor.BLUE.index, (byte) 0, // RGB red (byte) 32,
			 * // RGB green (byte) 96 // RGB blue );
			 */
			my_style.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
			my_style.setAlignment(my_style.ALIGN_CENTER);
			my_style.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style.setFillPattern(my_style.SOLID_FOREGROUND);
			org.apache.poi.ss.usermodel.Font font = workbook.createFont();

			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.BLUE.index);
			font.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);

			XSSFCellStyle my_style1 = workbook.createCellStyle();
			// my_style1.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			// my_style1.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			// my_style1.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			// my_style1.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
			my_style1.setAlignment(my_style.ALIGN_CENTER);
			my_style1.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
			org.apache.poi.ss.usermodel.Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLUE.index);
			font1.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			font1.setFontHeightInPoints((short) 10);
			my_style1.setFont(font1);
			XSSFCellStyle my_style2 = workbook.createCellStyle();
			// my_style2.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			// my_style2.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			// my_style2.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			// my_style2.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style2.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			XSSFCellStyle my_style3 = workbook.createCellStyle();
			// my_style3.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			// my_style3.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			// my_style3.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			// my_style3.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
			org.apache.poi.ss.usermodel.Font fonts = workbook.createFont();

			fonts.setFontName("Arial");
			fonts.setFontHeight((short) 200);
			fonts.setColor(HSSFColor.BLACK.index);
			fonts.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_NORMAL);
			// font3.setfonts
			fonts.setFontHeightInPoints((short) 12);
			my_style3.setFont(fonts);
			
			XSSFCellStyle my_style6 = workbook.createCellStyle();
			// my_style6.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			// my_style6.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			// my_style6.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			// my_style6.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style6.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
			org.apache.poi.ss.usermodel.Font font6 = workbook.createFont();

			font6.setFontName("Arial");
			font6.setFontHeight((short) 200);
			font6.setColor(HSSFColor.BLUE.index);
			font6.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			// font3.setfonts
			font6.setFontHeightInPoints((short) 12);
			my_style6.setFont(font6);

			XSSFCellStyle my_style7 = workbook.createCellStyle();
			// my_style6.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			// my_style6.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			// my_style6.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			// my_style6.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style7.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
			org.apache.poi.ss.usermodel.Font font7 = workbook.createFont();

			font7.setFontName("Arial");
			font7.setFontHeight((short) 200);
			font7.setColor(HSSFColor.BLUE.index);
			font7.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			// font3.setfonts
			font7.setFontHeightInPoints((short) 10);
			my_style7.setFont(font7);

			/**
			 * Style For Focus on differentiate Income or Expenses
			 */
			XSSFCellStyle my_style4 = workbook.createCellStyle();
			// my_style4.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			// my_style4.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			// my_style4.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			// my_style4.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style4.setAlignment(XSSFCellStyle.ALIGN_LEFT);
			org.apache.poi.ss.usermodel.Font font2 = workbook.createFont();
			
			font2.setFontName("Arial");
			font2.setFontHeight((short) 200);
			font2.setColor(HSSFColor.BLACK.index);
			font2.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_NORMAL);
			font2.setFontHeightInPoints((short) 10);
			my_style4.setFont(font2);

			/**
			 * Style For Focus on differentiate Income or Expenses
			 */
			XSSFCellStyle my_style5 = workbook.createCellStyle();
			// my_style5.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			// my_style5.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			// my_style5.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			// my_style5.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style5.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			org.apache.poi.ss.usermodel.Font font3 = workbook.createFont();

			font3.setFontName("Arial");
			font3.setFontHeight((short) 200);
			font3.setColor(HSSFColor.BLACK.index);
			font3.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			font3.setFontHeightInPoints((short) 10);
			my_style5.setFont(font3);

			XSSFCellStyle my_style8 = workbook.createCellStyle();
			my_style8.setAlignment(XSSFCellStyle.ALIGN_LEFT);
			org.apache.poi.ss.usermodel.Font font8 = workbook.createFont();
			font2.setFontName("Arial");
			font2.setFontHeight((short) 200);
			font8.setColor(HSSFColor.RED.index);
			font2.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_NORMAL);
			font2.setFontHeightInPoints((short) 10);
			my_style8.setFont(font8);

			// Create a blank sheet
			XSSFSheet excelSheet = workbook.createSheet("TDS REPORT");

			// set main header
			setExcelMainHeader(excelSheet, my_style, ObjPendingapprovalBean, my_style4);
			// set header
			setExcelHeader(excelSheet, my_style5);

			// set Data
			setExcelRows(workbook, excelSheet, ObjPendingapprovalResultBean, my_style2, my_style3, my_style4, my_style5, my_style6, my_style7, my_style8);

			if (ObjPendingapprovalResultBean.getSearchList().size()> 0) {
				isSuccess = true;
			} else {
				isSuccess = false;

			}
			
			// export excell
			String sFileUrl = writeExcel(workbook, pdfFile);

			//writeExcel(workbook, pdfFile);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isSuccess;
	}

	private void setExcelRows(XSSFWorkbook workbook, XSSFSheet excelSheet, TdsReportResultBean ObjPendingapprovalResultBean, XSSFCellStyle my_style2, XSSFCellStyle my_style3, XSSFCellStyle my_style4, XSSFCellStyle my_style5, XSSFCellStyle my_style6, XSSFCellStyle my_style7, XSSFCellStyle my_style8) {
		int record = 4, sno = 1;
		try {

			for (TdsReportBean objPendingapprovalBean : ObjPendingapprovalResultBean.getSearchList()) {

				Row row1 = excelSheet.createRow((short) record++);
				row1.setHeight((short) 350);

				Cell cell1 = row1.createCell((short) 0);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(objPendingapprovalBean.getCompanyName());

				cell1 = row1.createCell((short) 1);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(objPendingapprovalBean.getCompanyCode());

				cell1 = row1.createCell((short) 2);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(objPendingapprovalBean.getEntity());

				cell1 = row1.createCell((short) 3);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(objPendingapprovalBean.getPanno());

				cell1 = row1.createCell((short) 4);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(objPendingapprovalBean.getLedgerdate());

				cell1 = row1.createCell((short) 5);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(objPendingapprovalBean.getParticulars());

				cell1 = row1.createCell((short) 6);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(objPendingapprovalBean.getAccountCode());

				cell1 = row1.createCell((short) 7);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(objPendingapprovalBean.getAcctName());

				cell1 = row1.createCell((short) 8);
				cell1.setCellStyle(my_style3);
				cell1.setCellValue(objPendingapprovalBean.getBccredit());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * private static void writeExcel(XSSFWorkbook myWorkBook, String filePath) {
	 * String l_str_file_out = filePath + "/BudgetReport.xls"; FileOutputStream
	 * fileOut = null; try { fileOut = new FileOutputStream(l_str_file_out);
	 * myWorkBook.write(fileOut); } catch (IOException e) { e.printStackTrace(); }
	 * finally { try { fileOut.close(); } catch (Exception e) { e.printStackTrace();
	 * }
	 * 
	 * }
	 * 
	 * }
	 */
	
	
	
	

	private String writeExcel(XSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/TdsReport.xls";

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
			url = path + "/TdsReport.xls";
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


	/*private String writeExcel(XSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/TdsReport.xls";

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(sOutFile);
			myWorkBook.write(fileOut);
			url = path + "/TdsReport.xls";
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
	public void setMergingStyle(Row row, XSSFCellStyle cellStyle, int start, int end) {
		for (int i = start; i <= end; i++) {
			Cell cell = row.createCell(i);
			cell.setCellStyle(cellStyle);
		}

	}

	private void setExcelHeader(XSSFSheet excelSheet, XSSFCellStyle my_style1) {
		try {

			Row row1 = excelSheet.createRow((short) 3);
			excelSheet.createFreezePane(0, 2);
			row1.setHeight((short) 350);

			Cell cell1 = row1.createCell((short) 0);

			cell1.setCellStyle(my_style1);
			cell1.setCellValue("COMAPANY CODE");
			excelSheet.setColumnWidth(0, (short) ((40 * 7) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("COMPANY NAME");
			excelSheet.setColumnWidth(1, (short) ((50 * 7) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 2);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue(" VENDOR NAME ");
			excelSheet.setColumnWidth(2, (short) ((40 * 7) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 3);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue(" PAN NO");
			excelSheet.setColumnWidth(3, (short) ((30 * 7) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 4);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("VOUCHER DATE");
			excelSheet.setColumnWidth(4, (short) ((40 * 7) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 5);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("TRANSACTION NO");
			excelSheet.setColumnWidth(5, (short) ((40 * 7) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 6);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("ACCOUNT HEAD CODE");
			excelSheet.setColumnWidth(6, (short) ((40 * 7) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 7);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("ACCOUNT HEAD NAME");
			excelSheet.setColumnWidth(7, (short) ((40 * 7) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 8);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("AMOUNT");
			excelSheet.setColumnWidth(8, (short) ((30 * 7) / ((double) 1 / 20)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setExcelMainHeader(XSSFSheet excelSheet, XSSFCellStyle my_style, TdsReportBean ObjPendingapprovalBean, XSSFCellStyle my_style4) {
	/*	Row row = excelSheet.createRow((short) 0);
		row.setHeight((short) 600);
		excelSheet.addMergedRegion(new CellRangeAddress(0, // first row
															// (0-based)

				0, // last row (0-based)
				0, // first column (0-based)
				10// last column (0-based)
		));

		Cell cell = row.createCell((short) 0);
		cell.setCellValue("TDS REPORT");
		cell.setCellStyle(my_style);
		setMergingStyle(row, my_style, 1, 6);*/
		
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 10));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Dental Council of India");
		cell.setCellStyle(my_style);
		setMergingStyle(row, my_style, 1, 10);
		
		Row row1 = excelSheet.createRow((short) 1);
		excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 10));
		Cell cell1 = row1.createCell((short) 0);
		cell1.setCellValue("Aiwan-E-Galib Marg, Kotla Road, New Delhi");
		cell1.setCellStyle(my_style);
		setMergingStyle(row, my_style, 1, 10);

		Row row2 = excelSheet.createRow((short) 2);
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 10));
		Cell cell2 = row2.createCell((short) 0);
		cell2.setCellValue("TDS REPORT");
		cell2.setCellStyle(my_style);
		setMergingStyle(row, my_style, 1, 10);
		
		
	
		
	}

	@Override
	public TdsReportBean pdfExportNew(TdsReportBean detentionTariffBean, String exportFilesPath) {


		// DetentionTariffBean bean = new DetentionTariffBean();
		List<TdsReportBean> Listbean = new ArrayList<>();
		try {
			// ServletContext context1 = request.getServletContext();
			Document document = new Document(PageSize.A4, 2, 2, 2, 2);

			//PdfWriter writer = null;

			PdfWriter	writer = PdfWriter.getInstance(document,
					new FileOutputStream(exportFilesPath + "/TdsReport.pdf"));
			document.addAuthor("tg");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("tg");
			document.addTitle("Tds Report");
			document.setPageSize(PageSize.A4);
			document.setMargins(50, 50, 50, 50);

			
			document.open();

			
			Listbean = objBudgetReportDAO.searchportDtl(detentionTariffBean);
			 Font bfBold123 = new Font(FontFamily.HELVETICA, 12,  Font.BOLD , new BaseColor(0, 0, 0)); 
				Paragraph paragraph = new Paragraph();
			Paragraph paragraphmain = new Paragraph();
			Paragraph paragraphmain1 = new Paragraph();
			Paragraph paragraphmain3 = new Paragraph();
			paragraphmain3 = new Paragraph("\n",bfBold123);
			paragraphmain = new Paragraph("TDS \n",bfBold123);
			paragraphmain1 = new Paragraph("\n",bfBold123);
			paragraphmain.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraphmain3);
			document.add(paragraphmain);
			document.add(paragraphmain1);
//			
			
			
			PdfPTable table = new PdfPTable(1);
			table.getDefaultCell().setBorder(0);
			Font bfBold12 = new Font(FontFamily.HELVETICA, 8,  Font.BOLD, new BaseColor(0, 0, 0)); 
			Font bf12 = new Font(FontFamily.HELVETICA, 8); 
			 
			   table = new PdfPTable(2);
			   table.getDefaultCell().setBorder(0);
			    table.setWidthPercentage(100);
				Font tableFont = FontFactory.getFont("Helvetica", 10, Font.NORMAL);

			

				table.addCell("\n");
				table.addCell("\n");
				table.addCell("\n");
			    
			    

				  DecimalFormat df = new DecimalFormat("0.00");

				   document.add(table);
			    

				   //specify column widths
				   float[] columnWidths = {6f, 5f, 6f, 5f,5f,5f,5f,5f};
				   //create PDF table with the given widths
				   PdfPTable table1 = new PdfPTable(columnWidths);
				   // set table width a percentage of the page width
				   table1.setWidthPercentage(100f);
				 
				   //insert column headings
				   insertCell(table1, "ORGANIZATION", Element.ALIGN_CENTER, 1, bfBold12);
				   insertCell(table1, "VOUCHER NO", Element.ALIGN_CENTER, 1, bfBold12);
				   insertCell(table1, "VOUCHER NAME", Element.ALIGN_CENTER, 1, bfBold12);
				   insertCell(table1, "VOUCHER DATE", Element.ALIGN_CENTER, 1, bfBold12);				  
				   insertCell(table1, "PAN NO", Element.ALIGN_CENTER, 1, bfBold12);
				   insertCell(table1, "ACCOUNT CODE", Element.ALIGN_CENTER, 1, bfBold12);
				   insertCell(table1, "ACCOUNT NAME", Element.ALIGN_CENTER, 1, bfBold12);
				   insertCell(table1, "AMOUNT", Element.ALIGN_CENTER, 1, bfBold12);
				   table1.setHeaderRows(1);
				 
				   //insert an empty row
				  /* insertCell(table1, "", Element.ALIGN_LEFT, 4, bfBold12);
				   //create section heading by cell merging
				   insertCell(table1, "New York Orders ...", Element.ALIGN_LEFT, 4, bfBold12);*/
				   double orderTotal, total = 0;
				    
				   //just some random data to fill 
				   for(TdsReportBean detail : Listbean){
				     
				 
					   BaseColor color = BaseColor.BLACK;
					
					   if(detail.getCompanyCode()==null)
						   detail.setCompanyCode("");
					   if(detail.getParticulars()==null)
						   detail.setParticulars("");
					   if(detail.getEntity()==null)
						   detail.setEntity("");
					   if(detail.getLedgerdate()==null)
						   detail.setLedgerdate("");
					   if(detail.getPanno()==null)
						   detail.setPanno("");
					   if(detail.getAccountCode()==null)
						   detail.setAccountCode("");
					   if(detail.getAcctName()==null)
						   detail.setAcctName("");
					   if(detail.getBccredit()==null)
						   detail.setBccredit("");

					   insertCell(table1, "" +detail.getCompanyCode()+"" , Element.ALIGN_CENTER,color, 1, bf12);
					   insertCell(table1, "" +detail.getParticulars()+"" , Element.ALIGN_CENTER,color, 1, bf12);
					   insertCell(table1, "" +detail.getEntity()+"" , Element.ALIGN_CENTER,color, 1, bf12);
					   insertCell(table1, "" +detail.getLedgerdate()+"" , Element.ALIGN_CENTER,color, 1, bf12);
					   insertCell(table1, "" +detail.getPanno()+"" , Element.ALIGN_CENTER,color, 1, bf12); 
					   insertCell(table1, "" +detail.getAccountCode()+"" , Element.ALIGN_CENTER,color, 1, bf12);   
					   insertCell(table1, "" +detail.getAcctName()+"" , Element.ALIGN_CENTER,color, 1, bf12);   
					    insertCell(table1, "" +df.format(detail.getBccreditamount())+"" , Element.ALIGN_RIGHT,color, 1, bf12);   

				     
				   }
				   
				/*   insertCell(table1, "Total", Element.ALIGN_RIGHT, 6, bfBold12);
				   insertCell(table1, df.format(total), Element.ALIGN_RIGHT, 1, bfBold12);*/
				  
				   paragraph.add(table1);
				   // add the paragraph to the document
				   document.add(paragraph);
				 
			

			
			document.close();
	         writer.close();


			detentionTariffBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detentionTariffBean;
	
	
	}
	
	  
	private void insertCell(PdfPTable table, String text, int align,BaseColor color, int colspan, Font font){
		   
		  //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(new Phrase(text.trim(), (com.itextpdf.text.Font) font));
		  //set the cell alignment
		  cell.setHorizontalAlignment(align);
		  //set the cell column span in case you want to merge two or more cells
		  cell.setColspan(colspan);
		  cell.setBorderColor(color);
		  //in case there is no text and you wan to create an empty row
		  if(text.trim().equalsIgnoreCase("")){
		   cell.setMinimumHeight(10f);
		  }
		  //add the call to the table
		  table.addCell(cell);
		   
		 }
	
	 private void insertCell(PdfPTable table, String text, int align, int colspan, Font font){
		   
		  //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
		  //set the cell alignment
		  cell.setHorizontalAlignment(align);
		  //set the cell column span in case you want to merge two or more cells
		  cell.setColspan(colspan);
		  //in case there is no text and you wan to create an empty row
		  if(text.trim().equalsIgnoreCase("")){
		   cell.setMinimumHeight(10f);
		  }
		  //add the call to the table
		  table.addCell(cell);
		   
		 }
	
}
