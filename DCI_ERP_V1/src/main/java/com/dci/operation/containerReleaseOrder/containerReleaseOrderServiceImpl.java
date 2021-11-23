package com.dci.operation.containerReleaseOrder;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.model.CommonUtilityBean;
import com.dci.common.model.SelectivityBean;



@Service
public class containerReleaseOrderServiceImpl implements containerReleaseOrderService {

	@Autowired
	containerReleaseOrderDao quotationDao;
	
	@Value("${file.upload.absolutePath}")
	private String getFilePropertyUrl;

	@Value("${file.upload.serverPath}")
	private String getFileServerPath;

	@Override
	public containerReleaseOrderResultBean save(containerReleaseOrderBean bean) {
		// TODO Auto-generated method stub
		return quotationDao.save(bean);
	}
	
	@Override
	public containerReleaseOrderResultBean uploadEmployeeExcel(MultipartFile file) throws Exception {
		return quotationDao.uploadEmployeeExcel(file);
	}
	

	@Override
	public containerReleaseOrderResultBean list() {
		return quotationDao.list();
	}

	@Override
	public containerReleaseOrderResultBean getShipment() {
		// System.out.println("inside");
		return quotationDao.getShipment();
	}
	@Override
	public containerReleaseOrderResultBean edit(String quotHdId) {
		return quotationDao.edit(quotHdId);
	}
	@Override
	public containerReleaseOrderResultBean view(Integer quotHdId) {
		return quotationDao.view(quotHdId);
	}
	
	@Override
	public containerReleaseOrderResultBean getCustomerDetail(String quotHdId) {
		return quotationDao.getCustomerDetail(quotHdId);
	}
	
	@Override
	public containerReleaseOrderResultBean getcustomerpolpod(String quotHdId) {
		return quotationDao.getcustomerpolpod(quotHdId);
	}
	
	@Override
	public containerReleaseOrderResultBean update(containerReleaseOrderBean bean){
		return quotationDao.update(bean);
	}

	@Override
	public containerReleaseOrderResultBean delete(String QuotHdId) {
		return quotationDao.delete(QuotHdId);
	}
	@Override
	public containerReleaseOrderResultBean approve(String quotation) {
		return quotationDao.approve(quotation);
	}
	@Override
	public List<CommonUtilityBean> getiataList() {
		return quotationDao.getiataList();
	}
	@Override
	public List<CommonUtilityBean> getCurrencyList() {
		return quotationDao.getCurrencyList();
	}
	
	@Override
	public List<CommonUtilityBean> getServicePartner() {
		return quotationDao.getServicePartner();
	}
	@Override
	public List<CommonUtilityBean> getBranch() {
		return quotationDao.getBranch();
	}
	
	@Override
	public void insertFiles(String quotationNumber, String filename, String path) {
		quotationDao.insertFiles(quotationNumber,filename,path);
		
	}

	
	@Override
	public List<CommonUtilityBean> getServicePartnerType() {
		// TODO Auto-generated method stub
		return quotationDao.getServicePartnerType();
	}
	

	@Override
	public List<CommonUtilityBean> getEmployeeList() {
		// TODO Auto-generated method stub
		return quotationDao.getEmployeeList();
	}

	@Override
	public List<CommonUtilityBean> getChargeHeads() {
		// TODO Auto-generated method stub
		return quotationDao.getChargeHeads();
	}

	@Override
	public List<CommonUtilityBean> getTerms() {
		// TODO Auto-generated method stub
		return quotationDao.getTerms();
	}

	@Override
	public List<CommonUtilityBean> getUnitList() {
		// TODO Auto-generated method stub
		return quotationDao.getUnitList();
	}

	@Override
	public containerReleaseOrderBean print(Integer quotationHdId) {
		// TODO Auto-generated method stub
		return quotationDao.print(quotationHdId);
	}

	@Override
	public containerReleaseOrderResultBean saveasDraft(containerReleaseOrderBean bean) {
		// TODO Auto-generated method stub
		return quotationDao.saveasDraft(bean);
	}
	
	
	@Override
	public List<CommonUtilityBean> getuomList() {
		// TODO Auto-generated method stub
		return quotationDao.getuomList();
	}

	@Override
	public List<String> getFileNameList(Integer quotationHdId) {
		// TODO Auto-generated method stub
		return quotationDao.getFileNameList(quotationHdId);
	}
	
	@Override
	public void updateFiles(String quotationNo, List<String> check, String filepath,
			List<String> filepaths) {
		// TODO Auto-generated method stub
		 quotationDao.updateFiles(quotationNo, check, filepath,filepaths);
	}

	@Override
	public containerReleaseOrderResultBean getServicePartnerDropdownList() {
		// TODO Auto-generated method stub
		return quotationDao.getServicePartnerDropdownList();
	}
	
	@Override
	public containerReleaseOrderResultBean getServicePartnerDropdownListid(String id) {
		// TODO Auto-generated method stub
		return quotationDao.getServicePartnerDropdownListid(id);
	}

	@Override
	public List<CommonUtilityBean> getcommodity() {
		// TODO Auto-generated method stub
		return quotationDao.getcommodity();
	}
	@Override
	public containerReleaseOrderResultBean DownloadFile(String quotationNo) {
		return quotationDao.downloadfile(quotationNo);
	}
	
	@Override
	public boolean uploaddelete(String quotationNo) {
		// TODO Auto-generated method stub
		return quotationDao.uploaddelete(quotationNo);
	}
	
	@Override
	public boolean deletefiles(String fileName) {
		// TODO Auto-generated method stub
		return quotationDao.deletefiles(fileName);
	}
	
	@Override
	public containerReleaseOrderResultBean getCustomerList() {
		// TODO Auto-generated method stub
		return quotationDao.getCustomerList();
	}
	
	@Override
	public containerReleaseOrderResultBean getCustomerListCompany(String company) {
		// TODO Auto-generated method stub
		return quotationDao.getCustomerListCompany(company);
	}

	@Override
	public List<containerReleaseOrderBean> getContainerTypeDropDown() {
		// TODO Auto-generated method stub
		return quotationDao.getContainerTypeDropDown();
	}
	

@Override
	public containerReleaseOrderPrintBean printBL(String blNo) {
		// TODO Auto-generated method stub
		return quotationDao.printBL(blNo);
	}

@Override
public printcontainerReleaseOrderBean printCRO(String blNo) {
	// TODO Auto-generated method stub
	return quotationDao.printCRO(blNo);
}
	

@Override
public containerReleaseOrderPrintBean printreleaseOrder(String blNo) {
	// TODO Auto-generated method stub
	return quotationDao.printreleaseOrder(blNo);
}

	

	
private void setExcelMainHeader(XSSFSheet excelSheet, XSSFCellStyle my_style, containerReleaseOrderResultBean resultBean,
		String containerreleaseCode, XSSFCellStyle my_style4) {
	
	Row row = excelSheet.createRow((short) 0);
	row.setHeight((short) 600);
	excelSheet.addMergedRegion(new CellRangeAddress(0, // first row (0-based)
														
			0, // last row (0-based)
			0, // first column (0-based)
			9 // last column (0-based)
	));

	Cell cell = row.createCell((short) 0);
	cell.setCellValue("Container Release Order");
	cell.setCellStyle(my_style);
	setMergingStyle(row, my_style, 1, 6);

}
private void setMergingStyle(Row row, XSSFCellStyle my_style, int start, int end) {
	// TODO Auto-generated method stub
	
	for (int i = start; i <= end; i++) {
		Cell cell = row.createCell(i);
		cell.setCellStyle(my_style);
	}
	
}




private void setExcelHeader(XSSFSheet excelSheet,XSSFSheet excelSheet1 ,containerReleaseOrderResultBean resultBean, String containerreleaseCode,XSSFCellStyle my_style4,
		XSSFCellStyle my_style) {
	try {

		Row row1 = excelSheet.createRow((short) 1);
		Row row2 = excelSheet.createRow((short) 4);
		Row row3 = excelSheet.createRow((short) 10);
		excelSheet.createFreezePane(0, 2);
		row1.setHeight((short) 350);
		row2.setHeight((short) 350);
		row3.setHeight((short) 350);

		Cell cell1 = row1.createCell((short) 0);
		Cell cell2 = row1.createCell((short) 1);
		Cell cell3 = row1.createCell((short) 2);
		Cell cell4 = row1.createCell((short) 3);
		Cell cell5 = row1.createCell((short) 4);
		
		Cell cell6 = row2.createCell((short) 0);
		Cell cell7 = row2.createCell((short) 1);
		
		Cell cell8 = row3.createCell((short) 0);
		Cell cell9 = row3.createCell((short) 1);
		Cell cell10 = row3.createCell((short) 2);

		cell1.setCellStyle(my_style4);
		cell1.setCellValue("Sno");
		excelSheet.setColumnWidth(0, (short) ((30 * 7) / ((double) 1 / 20)));
		
		cell2 = row1.createCell((short) 1);
		cell2.setCellStyle(my_style4);
		cell2.setCellValue("CRO Date");
		excelSheet.setColumnWidth(0, (short) ((30 * 7) / ((double) 1 / 20)));

		cell3 = row1.createCell((short) 2);
		cell3.setCellStyle(my_style4);
		cell3.setCellValue("Customer");
		excelSheet.setColumnWidth(2, (short) ((30 * 7) / ((double) 1 / 20)));
		
		cell4 = row1.createCell((short) 3);
		cell4.setCellStyle(my_style4);
		cell4.setCellValue("Booking Number");
		excelSheet.setColumnWidth(0, (short) ((30 * 7) / ((double) 1 / 20)));
		
		cell5 = row1.createCell((short) 4);
		cell5.setCellStyle(my_style4);
		cell5.setCellValue("Depot");
		excelSheet.setColumnWidth(3, (short) ((30 * 7) / ((double) 1 / 20)));
		
		

		cell6 = row2.createCell((short) 1);
		cell6.setCellStyle(my_style4);
		cell6.setCellValue("Container Type");
		excelSheet.setColumnWidth(3, (short) ((30 * 7) / ((double) 1 / 20)));
		

		cell7 = row2.createCell((short) 2);
		cell7.setCellStyle(my_style4);
		cell7.setCellValue("Quantity");
		excelSheet.setColumnWidth(3, (short) ((30 * 7) / ((double) 1 / 20)));
		
		cell8 = row2.createCell((short) 3);
		cell8.setCellStyle(my_style4);
		cell8.setCellValue("Seal No From");
		excelSheet.setColumnWidth(3, (short) ((30 * 7) / ((double) 1 / 20)));

		cell9 = row2.createCell((short) 4);
		cell9.setCellStyle(my_style4);
		cell9.setCellValue("Seal No To");
		excelSheet.setColumnWidth(3, (short) ((30 * 7) / ((double) 1 / 20)));
		
		cell10 = row2.createCell((short) 5);
		cell10.setCellStyle(my_style4);
		cell10.setCellValue("Count");
		excelSheet.setColumnWidth(3, (short) ((30 * 7) / ((double) 1 / 20)));
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}

private void setExcelRows(XSSFWorkbook workbook, XSSFSheet excelSheet, XSSFSheet excelSheet1, containerReleaseOrderResultBean resultBean,
	containerReleaseOrderBean bean, XSSFCellStyle my_style2, XSSFCellStyle my_style3, XSSFCellStyle my_style4,
		XSSFCellStyle my_style5, XSSFCellStyle my_style6, XSSFCellStyle my_style7, XSSFCellStyle my_style8) {

	int record = 2, sno = 1;
	try {

		//for (containerReleaseOrderBean beanset : resultBean) {

			Row row1 = excelSheet.createRow((short) record++);
			row1.setHeight((short) 350);

			Cell cell1 = row1.createCell((short) 0);
			cell1.setCellStyle(my_style4);
			cell1.setCellValue(sno);

			cell1 = row1.createCell((short) 1);
			cell1.setCellStyle(my_style4);
			cell1.setCellValue(bean.getCroDate());

			cell1 = row1.createCell((short) 2);
			cell1.setCellStyle(my_style4);
			cell1.setCellValue(bean.getCustomer());


			cell1 = row1.createCell((short) 3);
			cell1.setCellStyle(my_style4);
			cell1.setCellValue(bean.getBookingNo());
			
			cell1 = row1.createCell((short) 4);
			cell1.setCellStyle(my_style4);
			cell1.setCellValue(bean.getDepot());
			
			sno++;
			
		//}
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	
	int records2 = 5, sno1 = 1;
	try {

		for (containerReleaseOrderBean beanset : bean.getlQuotationBean()) {

			Row row1 = excelSheet.createRow((short) records2++);
			row1.setHeight((short) 350);

			Cell cell1 = row1.createCell((short) 0);
			cell1.setCellStyle(my_style4);
			cell1.setCellValue(sno1);

			cell1 = row1.createCell((short) 1);
			cell1.setCellStyle(my_style4);
			cell1.setCellValue(beanset.getConType());

			cell1 = row1.createCell((short) 2);
			cell1.setCellStyle(my_style4);
			cell1.setCellValue(beanset.getQuantity());


		/*	cell1 = row1.createCell((short) 3);
			cell1.setCellStyle(my_style4);
			cell1.setCellValue(beanset.getBookingNo());
			
			cell1 = row1.createCell((short) 4);
			cell1.setCellStyle(my_style4);
			cell1.setCellValue(beanset.getDepot());
		*/	
			sno1++;
			
		}
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	
	int records3=6, sno3=1;
	try{
		
		for(containerReleaseOrderBean beanSeal: bean.getSealdtl()){
		
			Row row1 = excelSheet.createRow((short) records3++);
			row1.setHeight((short) 350);

			Cell cell1 = row1.createCell((short) 0);
			//cell1.setCellStyle(my_style4);
			//cell1.setCellValue(sno3);

			cell1 = row1.createCell((short) 3);
			cell1.setCellStyle(my_style4);
			cell1.setCellValue(beanSeal.getSealFrom());

			cell1 = row1.createCell((short) 4);
			cell1.setCellStyle(my_style4);
			cell1.setCellValue(beanSeal.getSealTo());
			
			cell1 = row1.createCell((short) 5);
			cell1.setCellStyle(my_style4);
			cell1.setCellValue(beanSeal.getCount());

			sno3++;
		}
		
		
	} catch(Exception e ){
		e.printStackTrace();
		}
}

private void writeExcel(XSSFWorkbook workbook, String exportFilesPath) {
	String l_str_file_out = exportFilesPath + "/ContainerReleaseOrder.xlsx";
	FileOutputStream fileOut = null;
	try {
		fileOut = new FileOutputStream(l_str_file_out);
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

@Override
public void generateExcel(containerReleaseOrderResultBean resultBean, String containerreleaseCode, String exportFilesPath) {

	try {
		// Blank workbook
		// HSSFWorkbook workbook = new HSSFWorkbook();
		
		containerReleaseOrderBean list = new containerReleaseOrderBean();
		
		list = quotationDao.getExport(containerreleaseCode);

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFCellStyle my_style = workbook.createCellStyle();
		/*
		 * HSSFPalette palette = workbook.getCustomPalette();
		 * palette.setColorAtIndex(HSSFColor.BLUE.index, (byte) 0, // RGB
		 * red (byte) 32, // RGB green (byte) 96 // RGB blue );
		 */
		my_style.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
		my_style.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
		my_style.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
		my_style.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
		my_style.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
		my_style.setAlignment(my_style.ALIGN_CENTER);
		
		Font font = workbook.createFont();
		font.setFontHeight((short) 200);
		font.setFontName("Arial");
		font.setColor(HSSFColor.BLUE.index);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
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
		my_style1.setFillForegroundColor(new XSSFColor(new java.awt.Color(137,207,240)));
		my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
		Font font1 = workbook.createFont();
		font1.setFontHeight((short) 200);
		font1.setFontName("Arial");
		font1.setColor(HSSFColor.BLUE.index);
		font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
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
		my_style3.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		Font fonts = workbook.createFont();

		fonts.setFontName("Arial");
		fonts.setFontHeight((short) 200);
		fonts.setColor(HSSFColor.RED.index);
		fonts.setBoldweight(Font.BOLDWEIGHT_BOLD);
		// font3.setfonts
		fonts.setFontHeightInPoints((short) 12);
		my_style3.setFont(fonts);

		XSSFCellStyle my_style6 = workbook.createCellStyle();
		// my_style6.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
		// my_style6.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
		// my_style6.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
		// my_style6.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
		my_style6.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
		Font font6 = workbook.createFont();

		font6.setFontName("Arial");
		font6.setFontHeight((short) 200);
		font6.setColor(HSSFColor.BLUE.index);
		font6.setBoldweight(Font.BOLDWEIGHT_BOLD);
		// font3.setfonts
		font6.setFontHeightInPoints((short) 12);
		my_style6.setFont(font6);

		XSSFCellStyle my_style7 = workbook.createCellStyle();
		// my_style6.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
		// my_style6.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
		// my_style6.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
		// my_style6.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
		my_style7.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
		Font font7 = workbook.createFont();

		font7.setFontName("Arial");
		font7.setFontHeight((short) 200);
		font7.setColor(HSSFColor.BLUE.index);
		font7.setBoldweight(Font.BOLDWEIGHT_BOLD);
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
		Font font2 = workbook.createFont();

		font2.setFontName("Arial");
		font2.setFontHeight((short) 200);
		font2.setColor(HSSFColor.BLACK.index);
		font2.setBoldweight(Font.BOLDWEIGHT_NORMAL);
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
		Font font3 = workbook.createFont();

		font3.setFontName("Arial");
		font3.setFontHeight((short) 200);
		font3.setColor(HSSFColor.BLACK.index);
		font3.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font3.setFontHeightInPoints((short) 10);
		my_style5.setFont(font3);

		XSSFCellStyle my_style8 = workbook.createCellStyle();
		my_style8.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		Font font8 = workbook.createFont();
		font2.setFontName("Arial");
		font2.setFontHeight((short) 200);
		font8.setColor(HSSFColor.RED.index);
		font2.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		font2.setFontHeightInPoints((short) 10);
		my_style8.setFont(font8);
		
		// Create a blank sheet
		XSSFSheet excelSheet = workbook.createSheet("Container Release Order Report");
		XSSFSheet excelSheet1 = workbook.createSheet("Container Release Order Report2");

		// set main header
		setExcelMainHeader(excelSheet, my_style, resultBean,containerreleaseCode, my_style4);
		// set header
		setExcelHeader(excelSheet,excelSheet1,resultBean,containerreleaseCode,my_style5,my_style);

		// set Data
		setExcelRows(workbook, excelSheet, excelSheet1, resultBean,list, my_style2, my_style3, my_style4, my_style5, my_style6,
				my_style7, my_style8);

		// export excell
		writeExcel(workbook, exportFilesPath);

	} catch (Exception e) {
		e.printStackTrace();
	} finally {

	}
	
}


@Override
public containerReleaseOrderBean export(String containerreleaseCode) {
	// TODO Auto-generated method stub
	return quotationDao.getExport(containerreleaseCode);
}

@Override
public void sendCROMail(String croNo){/*
	containerReleaseOrderPrintBean bean;
	//containerReleaseOrderPrintBean bean = quotationDao.printCRO(croNo);
	UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	//ServletContext context = request.getServletContext();
	 String path = "/root/GFS1/GFS1/GFS/GeneratedFiles/invoice/";
	 StringBuffer sbq = new StringBuffer();
		sbq.append( "<html> "
				+ "<head> "
				+ "<style> "
				+ "@page "
				+ "{	size: auto; "
				+ "	margin: 5mm; "
				+ "} "
				+ " "
				+ "#table2, td, th "
				+ "{	border: 1px solid #ddd; "
				+ "	text-align: left; "
				+ "} "
				+ " "
				+ "#table2 "
				+ "{	border-collapse: collapse; "
				+ "	width: 100%; "
				+ "} "
				+ " "
				+ "th, td "
				+ "{	/* padding: 15px;  "
				+ "	 "
				+ "} "
				+ " "
				+ ".width_auto "
				+ "{	width: auto; "
				+ "} "
				+ " "
				+ ".width_10px "
				+ "{	width: 10px; "
				+ "} "
				+ " "
				+ ".width_05 "
				+ "{	width: 0.50%; "
				+ "} "
				+ " "
				+ ".width_1 "
				+ "{	width: 1%; "
				+ "} "
				+ " "
				+ ".width_2 "
				+ "{	width: 2%; "
				+ "} "
				+ " "
				+ ".width_3 "
				+ "{	width: 3%; "
				+ "} "
				+ " "
				+ ".width_4 "
				+ "{	width: 4%; "
				+ "} "
				+ " "
				+ ".width_5 "
				+ "{	width: 5%; "
				+ "} "
				+ " "
				+ ".width_6 "
				+ "{	width: 6%; "
				+ "} "
				+ " "
				+ ".width_7 "
				+ "{	width: 7%; "
				+ "} "
				+ " "
				+ ".width_8 "
				+ "{	width: 8%; "
				+ "} "
				+ " "
				+ ".width_9 "
				+ "{	width: 9%; "
				+ "} "
				+ " "
				+ ".width_10 "
				+ "{	width: 10%; "
				+ "} "
				+ " "
				+ ".width_11 "
				+ "{	width: 11%; "
				+ "} "
				+ " "
				+ ".width_12 "
				+ "{	width: 12%; "
				+ "} "
				+ " "
				+ ".width_13 "
				+ "{	width: 13%; "
				+ "} "
				+ " "
				+ ".width_14 "
				+ "{	width: 14%; "
				+ "} "
				+ " "
				+ ".width_15 "
				+ "{	width: 15%; "
				+ "} "
				+ " "
				+ ".width_16 "
				+ "{	width: 16%; "
				+ "} "
				+ " "
				+ ".width_17 "
				+ "{	width: 17%; "
				+ "} "
				+ " "
				+ ".width_18 "
				+ "{	width: 18%; "
				+ "} "
				+ " "
				+ ".width_19 "
				+ "{	width: 19%; "
				+ "} "
				+ " "
				+ ".width_20 "
				+ "{	width: 20%; "
				+ "} "
				+ " "
				+ ".width_21 "
				+ "{	width: 21%; "
				+ "} "
				+ " "
				+ ".width_22 "
				+ "{	width: 22%; "
				+ "} "
				+ " "
				+ ".width_23 "
				+ "{	width: 23%; "
				+ "} "
				+ " "
				+ ".width_24 "
				+ "{	width: 24%; "
				+ "} "
				+ " "
				+ ".width_25 "
				+ "{	width: 25%; "
				+ "} "
				+ " "
				+ ".width_26 "
				+ "{	width: 26%; "
				+ "} "
				+ " "
				+ ".width_27 "
				+ "{	width: 27%; "
				+ "} "
				+ " "
				+ ".width_28 "
				+ "{	width: 28%; "
				+ "} "
				+ " "
				+ ".width_29 "
				+ "{	width: 29%; "
				+ "} "
				+ " "
				+ ".width_30 "
				+ "{	width: 30%; "
				+ "} "
				+ " "
				+ ".width_31 "
				+ "{	width: 31%; "
				+ "} "
				+ " "
				+ ".width_32 "
				+ "{	width: 32%; "
				+ "} "
				+ " "
				+ ".width_33 "
				+ "{	width: 33%; "
				+ "} "
				+ " "
				+ ".width_34 "
				+ "{	width: 34%; "
				+ "} "
				+ " "
				+ ".width_35 "
				+ "{	width: 35%; "
				+ "} "
				+ " "
				+ ".width_36 "
				+ "{	width: 36%; "
				+ "} "
				+ " "
				+ ".width_37 "
				+ "{	width: 37%; "
				+ "} "
				+ " "
				+ ".width_38 "
				+ "{	width: 38%; "
				+ "} "
				+ " "
				+ ".width_39 "
				+ "{	width: 39%; "
				+ "} "
				+ " "
				+ ".width_40 "
				+ "{	width: 40%; "
				+ "} "
				+ " "
				+ ".width_41 "
				+ "{	width: 41%; "
				+ "} "
				+ " "
				+ ".width_42 "
				+ "{	width: 42%; "
				+ "} "
				+ " "
				+ ".width_43 "
				+ "{	width: 43%; "
				+ "} "
				+ " "
				+ ".width_44 "
				+ "{	width: 44%; "
				+ "} "
				+ " "
				+ ".width_45 "
				+ "{	width: 45%; "
				+ "} "
				+ " "
				+ ".width_46 "
				+ "{	width: 46%; "
				+ "} "
				+ " "
				+ ".width_47 "
				+ "{	width: 47%; "
				+ "} "
				+ " "
				+ ".width_48 "
				+ "{	width: 48%; "
				+ "} "
				+ " "
				+ ".width_49 "
				+ "{	width: 49%; "
				+ "} "
				+ " "
				+ ".width_50 "
				+ "{	width: 50%; "
				+ "} "
				+ " "
				+ ".width_51 "
				+ "{	width: 51%; "
				+ "} "
				+ " "
				+ ".width_52 "
				+ "{	width: 52%; "
				+ "} "
				+ " "
				+ ".width_53 "
				+ "{	width: 53%; "
				+ "} "
				+ " "
				+ ".width_54 "
				+ "{	width: 54%; "
				+ "} "
				+ " "
				+ ".width_55 "
				+ "{	width: 55%; "
				+ "} "
				+ " "
				+ ".width_56 "
				+ "{	width: 56%; "
				+ "} "
				+ " "
				+ ".width_57 "
				+ "{	width: 57%; "
				+ "} "
				+ " "
				+ ".width_58 "
				+ "{	width: 58%; "
				+ "} "
				+ " "
				+ ".width_59 "
				+ "{	width: 59%; "
				+ "} "
				+ " "
				+ ".width_60 "
				+ "{	width: 60%; "
				+ "} "
				+ " "
				+ ".width_61 "
				+ "{	width: 61%; "
				+ "} "
				+ " "
				+ ".width_62 "
				+ "{	width: 62%; "
				+ "} "
				+ " "
				+ ".width_63 "
				+ "{	width: 63%; "
				+ "} "
				+ " "
				+ ".width_64 "
				+ "{	width: 64%; "
				+ "} "
				+ " "
				+ ".width_65 "
				+ "{	width: 65%; "
				+ "} "
				+ " "
				+ ".width_66 "
				+ "{	width: 66%; "
				+ "} "
				+ " "
				+ ".width_67 "
				+ "{	width: 67%; "
				+ "} "
				+ " "
				+ ".width_68 "
				+ "{	width: 68%; "
				+ "} "
				+ " "
				+ ".width_69 "
				+ "{	width: 69%; "
				+ "} "
				+ " "
				+ ".width_70 "
				+ "{	width: 70%; "
				+ "} "
				+ " "
				+ ".width_71 "
				+ "{	width: 71%; "
				+ "} "
				+ " "
				+ ".width_72 "
				+ "{	width: 72%; "
				+ "} "
				+ " "
				+ ".width_73 "
				+ "{	width: 73%; "
				+ "} "
				+ " "
				+ ".width_74 "
				+ "{	width: 74%; "
				+ "} "
				+ " "
				+ ".width_75 "
				+ "{	width: 75%; "
				+ "} "
				+ " "
				+ ".width_76 "
				+ "{	width: 76%; "
				+ "} "
				+ " "
				+ ".width_77 "
				+ "{	width: 77%; "
				+ "} "
				+ " "
				+ ".width_78 "
				+ "{	width: 78%; "
				+ "} "
				+ " "
				+ ".width_79 "
				+ "{	width: 79%; "
				+ "} "
				+ " "
				+ ".width_80 "
				+ "{	width: 80%; "
				+ "} "
				+ " "
				+ ".width_81 "
				+ "{	width: 81%; "
				+ "} "
				+ " "
				+ ".width_82 "
				+ "{	width: 82%; "
				+ "} "
				+ " "
				+ ".width_83 "
				+ "{	width: 83%; "
				+ "} "
				+ " "
				+ ".width_84 "
				+ "{	width: 84%; "
				+ "} "
				+ " "
				+ ".width_85 "
				+ "{	width: 85%; "
				+ "} "
				+ " "
				+ ".width_100 "
				+ "{	width: 100%; "
				+ "} "
				+ " "
				+ ".no_border "
				+ "{	border: 0px; "
				+ "} "
				+ "</style> "
				+ " "
				+ "<style type='text/css' media='print'> "
				+ "html, body "
				+ "{	margin: 0; "
				+ "	padding: 0; "
				+ "	border: 1px solid; "
				+ "} "
				+ "/* body { height: 11in;  width: 8.5in; }  "
				+ "a[href]:after "
				+ "{	content: ' (' attr(href) ')'; "
				+ "} "
				+ " "
				+ "#footer "
				+ " "
				+ "{	display: table-footer-group; "
				+ "	width: 100%; "
				+ "	position: absolute; "
				+ "	/* bottom:3px; z "
				+ "} "
				+ " "
				+ "#content "
				+ "{	margin-bottom: 4px; "
				+ "} "
				+ " "
				+ "@page "
				+ "{	size: A4; "
				+ "	margin: 2mm; "
				+ "} "
				+ "</style> "
				+ "<style type='text/css'> "
				+ ".chngTdCls>tbody>tr>td "
				+ "{	padding: 5px 0px !important; "
				+ "} "
				+ "</style> "
				+ "</head> "
				+ " "
				+ "<body style='border: 1px solid'> "
				+ "	<input type='hidden' value='"+user.getTenantId().toUpperCase()+"' id='tenantId'/> "
				+ "	< c: set var='hdr' value='${headerDetails}' /> "
				+ " "
				+ " "
				+ "	<table border='0' width='100%' cellpadding='0' cellspacing='0' "
				+ "		bgcolor='FFFFFF' bordercolor='' align='center'> "
				+ "		<tr> "
				+ "			<td width='25%' class='no_border'><img "
				+ "				src='http://213.42.28.69:8082/img/Cordelia_resize_logo.jpg' "
				+ "				style='padding: 10 0 0 10; height: 60px;'/></td> "
				+ "			<td width='100%' class='no_border' "
				+ "				style='padding-top: 15; padding-right: 15; text-align: right;'><span "
				+ "				style='text-align: right; font-family: arial; font-size: 15px; text-transform: uppercase;'><b>"+user.getTenantId().toUpperCase()+" </b> "
				+ "						 </span> "
				+ "				<hr></hr> <br></br> <span "
				+ "				style='font-family: arial; font-size: 15px;'>"+bean.getAddress1()+"</span> "
				+ "				<br> </br></td> "
				+ "		</tr> "
				+ "	</table> "
				+ "	<hr></hr> "
				+ "	<div style='padding-left: 80%;'> "
				+ "		<span>Date :</span> <span>"+bean.getPresentDate()+"</span> "
				+ "	</div> "
				+ " "
				+ "	<center> "
				+ "		<b>CONTAINER RELEASE ORDER </b> "
				+ "	</center> "
				+ "	<br></br> "
				+ " "
				+ "	<table width=100%> "
				+ "		<tr> "
				+ "			<td style='width: 60%; padding-bottom: 76px;padding-left: 15px;' class='no_border'> "
				+ "				<span>To</span> <br></br> <span>The Manager</span> <span>"+bean.getDepotAddress()+"</span> "
				+ "			</td> "
				+ "			<td class='no_border'> "
//				+ "				<div> "
				+ "					<span>Ref No</span> <br />  <span>POL "
				+ "					</span> <br /> <span>POD </span> "
//				+ "				</div> "
				+ "			</td> "
				+ "			<td class='no_border'><span>: "+bean.getRefNo()+"</span><br />   <span>: "+bean.getPol()+"</span><br /> <span>: "
				+ "					"+bean.getPod()+"</span></td> "
				+ "		</tr> "
				+ "	</table> "
				+ "	<br></br> "
				+ "	<br> </br>"
				+ "	<br> </br>"
				+ " "
				+ "	<div class='letter-style' "
				+ "		style='font-size: 18px; margin-left: 25px; height: 212px;'> "
				+ "		<p>Dear Sir,</p> "
				+ "		<p>Vsl Name ______<u>"+bean.getVesselName()+"</u>______ voyage No. ______<u>"+bean.getVoyageNo()+"</u>______</p> "
				+ "		<p>Shipper / CHA M/s. _______<u>"+bean.getShipperName()+"</u>_______ for</p> "
				+ "		<p>Stuffing and advice of units delivered.</p> "
				+ "		<p>Container Details are as Follows:</p> "
				+ "	</div> "
				+ " "
				+ " "
				+ " "
				+ "	<table class='t-table' style='width: 100%;'> "
				+ "		<thead> "
				+ "			<tr> "
				+ " "
				+ "				<th class='bold fntSiz13px wid10pr' "
				+ "					style='border-left: 1px solid #fff; border-top: 1px solid #fff'><span>Cntr "
				+ "						Type</span><br> </br><br></br></th> "
				+ "				<th class='bold fntSiz13px wid30pr' "
				+ "					style='border-left: 1px solid #fff; border-top: 1px solid #fff'><span>Temp</span><br></br> "
				+ "					<br></br></th> "
				+ "				<th class='bold fntSiz13px wid20pr' "
				+ "					style='border-left: 1px solid #fff; border-top: 1px solid #fff'><span>Units</span><br></br> "
				+ "					<br></br></th> "
				+ "				<th class='bold fntSiz13px wid20pr' "
				+ "					style='border-left: 1px solid #fff; border-top: 1px solid #fff'><span>Ventilation</span><br></br> "
				+ "					<br></br></th> "
				+ "				<th class='bold fntSiz13px wid20pr' "
				+ "					style='border-left: 1px solid #fff; border-top: 1px solid #fff'><span>Humidity</span><br></br> "
				+ "					<br></br></th> "
				+ "				<th class='bold fntSiz13px wid20pr' "
				+ "					style='border-left: 1px solid #fff; border-top: 1px solid #fff'><span>Commodity</span><br></br> "
				+ "					<br></br></th> "
				+ " "
				+ "			</tr> "
				+ "		</thead> "
				+ "		<tbody style='font-size: 10px;'> ");
				for(containerReleaseOrderPrintBean rwObj : bean.getContainerDtl()){
					sbq.append( "				<tr style='height: 8px !important;'> "
				+ " "
				+ "					<td class=' ' align='center' "
				+ "						style='border-bottom: 1px solid white; font-size: 13px;' "
				+ "						valign='top'><span style='padding: 0px; margin: 0px;'>"+rwObj.getConType()+"</span></td> "
				+ "					<td class=' ' align='center' "
				+ "						style='border-bottom: 1px solid white; font-size: 13px;' "
				+ "						valign='top'><span style='padding: 0px; margin: 0px;'>"+rwObj.getTemp()+"</span></td> "
				+ "					<td class=' ' align='center' "
				+ "						style='border-bottom: 1px solid white; padding: 0px; margin: 0px;; font-size: 13px;' "
				+ "						valign='top'><span>"+rwObj.getUnits()+"</span><br></br></td> "
				+ " "
				+ " "
				+ "					<td class=' ' align='center' "
				+ "						style='border-bottom: 1px solid white; padding: 0px; margin: 0px;; font-size: 13px;' "
				+ "						valign='top'><span>"+rwObj.getVentilation()+"</span></td> "
				+ " "
				+ "					<td class=' ' align='center' "
				+ "						style='border-bottom: 1px solid white; padding: 0px; margin: 0px;; font-size: 13px;' "
				+ "						valign='top'><span>"+rwObj.getHumidity()+"</span></td> "
				+ "					<td class=' ' align='center' "
				+ "						style='border-bottom: 1px solid white; padding: 0px; margin: 0px;; font-size: 13px;' "
				+ "						valign='top'><span>"+rwObj.getCommodity()+"</span></td> "
				+ " "
				+ " "
				+ "				</tr> ");
				}
				sbq.append( "		</tbody> "
				+ "	</table> "
				+ " "
				+ " "
				+ " "
				+ " "
				+ " "
				+ " "
				+ " "
				+ " "
				+ " "
				+ "	<div style='margin-top: 200px;'> "
				+ " "
				+ "		<c:set var='bean' value='${headerDetails}' /> "
				+ "		<br></br> <br></br> <br></br> <br></br> <b "
				+ "			style='font-size: 12px; font-family: arial; padding-left: 20px;'>Yours "
				+ "			Faithfully</b> <br></br> <b "
				+ "			style='font-size: 12px; font-family: arial; padding-left: 20px;'>cordelia</b> <br></br> "
				+ "		 "
				+ " "
				+ "		<table border='0' width='100%' cellpadding='0' cellspacing='0' "
				+ "			bgcolor='FFFFFF' bordercolor='' align='center'> "
				+ "			<tr> "
				+ "				<td width='100%' class='no_border' "
				+ "					style='padding-top: 15; padding-right: 15; text-align: center;'><span "
				+ "					style='text-align: center; font-family: arial; font-size: 15px; text-transform: uppercase;'><u>Notice to Booking party / shipper / CHA / freight Forwarder</u> "
				+ "				</span> <br> </br><span style='font-family: arial; font-size: 15px;'></span> "
				+ "					<br></br> "
				+ "			</td> "
				+ "			</tr> "
				+ "		</table> "
				+ "	</div> "
				+ " "
				+ " "
				+ "</body> "
				+ "</html>");
	 String k = sbq.toString();
	    FileOutputStream file;
		try {
			WriteToFile(k,croNo+".html");
//			file = new FileOutputStream(getFilePropertyUrl+"/"+croNo+".pdf");
			 Document document = new Document();
			 PdfWriter writer = PdfWriter.getInstance(document,
				      new FileOutputStream(getFilePropertyUrl+croNo+".pdf"));
			 document.open();
			 XMLWorkerHelper.getInstance().parseXHtml(writer, document,
				      new FileInputStream(getFilePropertyUrl+croNo+".html"));
			    document.close();
//			    file.close();
			    
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   

Email email = new Email();
String from = "softwareadmin@fscontainer.com";

String[] to = { "mgmt1@fscontainer.com","docs1@fscontainer.com"};
email.setFromEmailAddress(from);
email.setToEmailAddress(to);
email.setSubject("cordelia Container Release Order No - "+croNo);
email.setBodyText("Dear Sir/Madam, \n\n Please find the attached CRO copy. \n\n Best Regards,\n\ncordelia Team.");
String attachPath =   getFilePropertyUrl+croNo+".pdf";
final String emailAttachment = attachPath;

new Thread(new Runnable() {
	@Override
	public void run() {

		try {
		 	MailUtility.sendMail(email, emailAttachment);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}).start();

*/
}


public  void WriteToFile(String fileContent, String fileName) throws IOException {
    String  tempFile = getFilePropertyUrl +fileName;
    File file = new File(tempFile);
    // if file does exists, then delete and create a new file
    if (file.exists()) {
        try {
            File newFileName = new File("C:/Users/Gowthem/Desktop/tgg" + File.separator+ "backup_"+fileName);
            file.renameTo(newFileName);
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //write to file with OutputStreamWriter
    OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
    Writer writer=new OutputStreamWriter(outputStream);
    writer.write(fileContent);
    writer.close();

}

@Override
public List<SelectivityBean> getContainerTypeByBooking(String bookingNo,boolean isEdit,String conHdrCode) {
	// TODO Auto-generated method stub
	return quotationDao.getContainerTypeByBooking(bookingNo,isEdit,conHdrCode);
}

}

