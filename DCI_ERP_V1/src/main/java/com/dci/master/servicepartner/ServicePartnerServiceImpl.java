package com.dci.master.servicepartner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.ConfigurationProps;
import com.dci.master.servicepartnerNew.ServicePartnerNewBean;
import com.dci.tenant.user.UserDetail;
@Service
public class ServicePartnerServiceImpl implements ServicePartnerService{

	@Autowired
	ServicePartnerDAO servicePartnerDAO;
	
	
	@Autowired
	DataSource dataSource;

	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public ServicePartnerResultBean getDropDownList() {
		// TODO Auto-generated method stub
		return servicePartnerDAO.getDropDownList();
	}

	@Override
	public ServicePartnerResultBean getServicePartnerList(String name) {
		// TODO Auto-generated method stub
		return servicePartnerDAO.getServicePartnerList(name);
	}

	@Override
	public ServicePartnerResultBean saveServicePartner(
			ServicePartnerResultBean servicePartnerBean) {
		// TODO Auto-generated method stub
		return servicePartnerDAO.saveServicePartner(servicePartnerBean);
	}

	@Override
	public ServicePartnerResultBean updateServicePartner(
			ServicePartnerResultBean servicePartnerBean) {
		// TODO Auto-generated method stub
		return servicePartnerDAO.updateServicePartner(servicePartnerBean);
	}

	@Override
	public ServicePartnerResultBean editServicePartner(int servicePartnerId) {
		// TODO Auto-generated method stub
		return servicePartnerDAO.editServicePartner(servicePartnerId);
	}
	
	@Override
	public ServicePartnerResultBean viewServicePatrnerList(int servicePartnerId) {
		// TODO Auto-generated method stub
		return servicePartnerDAO.viewServicePatrnerList(servicePartnerId);
	}

	@Override
	public ServicePartnerResultBean deleteServicePartner(int servicePartnerId) {
		// TODO Auto-generated method stub
		return servicePartnerDAO.deleteServicePartner(servicePartnerId);
	}

    @Override
    public ServicePartnerResultBean createLogin(int rowid){
	return servicePartnerDAO.createLogin(rowid);
    }
	@Override
	public ServicePartnerResultBean getServicePartnerDetailList() {
		// TODO Auto-generated method stub
		return servicePartnerDAO.getServicePartnerDetailList();
	}

	@Override
	public ServicePartnerResultBean deleteKeyDetail(
			List<ServicePartnerKeyBean> lServicePartnerKeyBean) {
		// TODO Auto-generated method stub
		return servicePartnerDAO.deleteKeyDetail(lServicePartnerKeyBean);
	}

	//kyc
		@Override
		public boolean saveCustomCommDetail(CustomerMasterCommDetail2 customerMasterCommDetail,String userId) throws Exception {
			return servicePartnerDAO.saveCustomerCommDetail(customerMasterCommDetail,userId);
		}


		@Override
		public ServicePartnerResultBean getCustomCommDetail(String srvcprtnrcd) throws Exception {

			return servicePartnerDAO.getCustomCommDetail(srvcprtnrcd);
		}
	    @Override
		
		public boolean updateCustomerCommDetail2(CustomerMasterCommDetail2 customerMasterCommDetail,String userId) throws Exception {
			return servicePartnerDAO.updateCustomerCommDetail(customerMasterCommDetail,userId);
		}
	    @Override
		public boolean deleteCustomerComm(String customCommId, String customId) throws Exception {
			return servicePartnerDAO.deleteCustomerComm(customCommId, customId);
		}

		@Override
		public ServicePartnerResultBean getCountryList(int cityId) {
			// TODO Auto-generated method stub
			return servicePartnerDAO.getCountryList(cityId);
		}

		@Override
		public String generateExcel() {
			String path="";
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
				ServicePartnerResultBean bean = new ServicePartnerResultBean();
				List<ServicePartnerBean> lServicePartnerBean = new ArrayList<ServicePartnerBean>();
				bean=servicePartnerDAO.getServicePartnerList("servicepartner");
				// Create a blank sheet
				XSSFSheet excelsheet = workbook.createSheet("Customer List");
				setExcelMainHeader(excelsheet, mainHeaderStyle);
				setExcelSubHeader(excelsheet, subHeaderStyle);
				setExcelRows(excelsheet, workbook, bean.getlServicePartnerBean(), subHeaderStyle);
				
				for (int i = 0; i < 10; i++) {
					excelsheet.autoSizeColumn(i);
				}
				
				String fileName = null;
					fileName = "Customer";
				 path=writeExcel(workbook, ConfigurationProps.exportFilesPath, fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return path;
			
			

		}
		
		private void setExcelRows(XSSFSheet excelsheet, XSSFWorkbook workbook, List<ServicePartnerBean> bean,
				XSSFCellStyle subHeaderStyle) {
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
				my_style2.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

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
				my_style2.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

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
				my_style3.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

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
				totalStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

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
				totalStyle1.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
				
				CellStyle cellDateStyle = workbook.createCellStyle();
				CreationHelper createHelper = workbook.getCreationHelper();
				cellDateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-mm-yyyy"));
				cellDateStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
				cellDateStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
				cellDateStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
				cellDateStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				cellDateStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
				cellDateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
				
				XSSFCellStyle cellStyle2 = workbook.createCellStyle();
		        cellStyle2.setWrapText(true);
		        cellStyle2.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		        cellStyle2.setVerticalAlignment(HSSFCellStyle.VERTICAL_BOTTOM);
				
				int rCount = 5;

				for (int i = 0; i < bean.size(); i++) {
					Row row = excelsheet.createRow( rCount);
                int count=0;

					//	Cell cell;

					Cell cell = row.createCell(count);
							cell.setCellStyle(my_style2);
							cell.setCellValue(bean.get(i).getServicePartnerLedgerName());
							count++;
							Cell	cell1 = row.createCell(count);
							cell1.setCellStyle(my_style2);
							cell1.setCellValue(bean.get(i).getAddress());
							count++;
							Cell	cell2 = row.createCell(count);
							cell2.setCellStyle(my_style2);
							cell2.setCellValue(bean.get(i).getSalesPerson());
							count++;
							Cell	cell3 = row.createCell(count);
							cell3.setCellStyle(my_style2);
							cell3.setCellValue(bean.get(i).getBranchName());
							count++;
							Cell	cell4 = row.createCell(count);
							cell4.setCellStyle(my_style2);
							cell4.setCellValue(bean.get(i).getCityName());
							count++;
							Cell cell5 = row.createCell(count);
							cell5.setCellStyle(my_style2);
							cell5.setCellValue(bean.get(i).getCountryName());
							count++;
							/*Cell cell6 = row.createCell(count);
							cell6.setCellStyle(my_style2);
							cell6.setCellValue(bean.get(i).getExemptionUnder());
							count++;
							*/
							Cell cell7 = row.createCell(count);
							cell7.setCellStyle(my_style2);
							cell7.setCellValue(bean.get(i).getgSTNNo());
							count++;
							

							Cell cell8 = row.createCell(count);
							cell8.setCellStyle(my_style2);
							cell8.setCellValue(bean.get(i).getCusvenagent());
							count++;
							
						/*	Cell	cell7 = row.createCell(count);
							cell7.setCellStyle(my_style2);
							cell7.setCellValue(bean.get(i).getSalesPerson());
							count++;
							Cell	cell8 = row.createCell(count);
							cell8.setCellStyle(my_style2);
							if(bean.get(i).isActive()) {
								cell8.setCellValue("True");
							}
							else {
								cell8.setCellValue("False");
								}
							*/
							rCount = rCount + 1;
							
						}
					
					

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private void setExcelSubHeader(XSSFSheet excelsheet, XSSFCellStyle subHeaderStyle) {
			try {

				Row row = excelsheet.createRow((short) 4);
				row.setHeight((short) 700);
				subHeaderStyle.setWrapText(true);
				for (int i = 0; i < 20; i++) {
					excelsheet.autoSizeColumn(i);
				}
//				List<ReportHeaderBean> header = objWholeData.getLjobOrderReportheaderlist();
//				for (int i = 0; i < header.size(); i++) {
				int cellcount=0;
					Cell cell = row.createCell(cellcount);
					cell.setCellStyle(subHeaderStyle);
					cell.setCellValue("CUSTOMER NAME");
					cellcount++;

					Cell cell1 = row.createCell(cellcount);
					cell1.setCellStyle(subHeaderStyle);
					cell1.setCellValue("ADDRESS");
					cellcount++;
					
					Cell cell2 = row.createCell(cellcount);
					cell2.setCellStyle(subHeaderStyle);
					cell2.setCellValue("SALES PERSON NAME");
					cellcount++;
					
					Cell cell3 = row.createCell(cellcount);
					cell3.setCellStyle(subHeaderStyle);
					cell3.setCellValue("BRANCH NAME");
					cellcount++;
					
					Cell cell4 = row.createCell(cellcount);
					cell4.setCellStyle(subHeaderStyle);
					cell4.setCellValue("CITY");
					cellcount++;
					
					Cell cell5 = row.createCell(cellcount);
					cell5.setCellStyle(subHeaderStyle);
					cell5.setCellValue("COUNTRY");
					cellcount++;
					
					/*Cell cell6 = row.createCell(cellcount);
					cell6.setCellStyle(subHeaderStyle);
					cell6.setCellValue("NETWORK");
					cellcount++;
					*/
					Cell cell7 = row.createCell(cellcount);
					cell7.setCellStyle(subHeaderStyle);
					cell7.setCellValue("GST NO");
					cellcount++;
					
					Cell cell8 = row.createCell(cellcount);
					cell8.setCellStyle(subHeaderStyle);
					cell8.setCellValue("Type");
					cellcount++;
					
			/*		Cell cell7 = row.createCell(cellcount);
					cell7.setCellStyle(subHeaderStyle);
					cell7.setCellValue("Sales Person");
					cellcount++;
					
					Cell cell8 = row.createCell(cellcount);
					cell8.setCellStyle(subHeaderStyle);
					cell8.setCellValue("Active");
					cellcount++;*/
					
					
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		private void setExcelMainHeader(XSSFSheet excelsheet, XSSFCellStyle mainHeaderstyle) {
			Row row = excelsheet.createRow(0);
			excelsheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 7));
			Cell cell = row.createCell((short) 0);
			cell.setCellStyle(mainHeaderstyle);
			cell.setCellValue("CUSTOMER LIST");

		}
		

		private String  writeExcel(XSSFWorkbook workbook, String filePath, String filePathName) {
			String fileName = null;
				fileName = filePath + "/" + filePathName + ".xls";

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
			return fileName;

		}

		
		@Override
		public ServicePartnerResultBean uploadFile1(MultipartFile file) {
		ServicePartnerResultBean resultbean = new ServicePartnerResultBean();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			List<String> errorList = new ArrayList<>();

			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			List<List<String>> rowList = new ArrayList<List<String>>();
			List<String> colList = new ArrayList<String>();
			List<Boolean> colList1 = new ArrayList<Boolean>();


			List<Integer> custype = new ArrayList<Integer>();

			String error = "";

			boolean isSuccess = false;
			String fileName = file.getOriginalFilename();
			Iterator<Row> rowIterator = null;
			Workbook workbook = null;
			int memberType = 0;
			String userFlag = "e";
			
			int i = 0;
			int rowCount = 0;
			int sheetCount = 0;
			boolean errorFlag = false;
			try {
			org.apache.poi.ss.usermodel.Workbook wb_xssf; // Declare XSSF
			org.apache.poi.ss.usermodel.Workbook wb_hssf; // Declare HSSF
			List<ServicePartnerBean> beanList = new ArrayList<>();

			Sheet sheet = null;
			if (fileName.endsWith("xls")) {

				workbook = new XSSFWorkbook(file.getInputStream());
				
				sheetCount = workbook.getNumberOfSheets();
			} else if (fileName.endsWith("xlsx")||fileName.endsWith("XLSX")) {
			
			workbook = new XSSFWorkbook(file.getInputStream());
			
			sheetCount = workbook.getNumberOfSheets();
			
			} else {
			System.out.println("Not a valid file format");
			}
			 
			
 				XSSFSheet sheet1 = (XSSFSheet) workbook.getSheetAt(0);

				//String sheetNames = workbook.getSheetName(0);
 				rowIterator = sheet1.rowIterator();
				int rowCnt = 0;
				while (rowIterator.hasNext()) {

 					Row row = rowIterator.next();
					rowCnt += 1;
					 
					Cell code = row.getCell(0);
					Cell code1 = row.getCell(1);
 
						if(rowCnt>1){
							
//					if (!code.getStringCellValue().contains("Customer Code")) {
//							if(code.CELL_TYPE_BLANK == 0){
//								
//								
//							if(code == null || code.getCellType() == code.CELL_TYPE_BLANK && code1!= null && code1.getCellType()!= Cell.CELL_TYPE_BLANK ){
//								error = "Row No" + rowCnt + "Customer Code is Missing!";
//								resultbean.setSuccess(false);
//								resultbean.setMessage(error);
//
//								throw new Exception(error);
//								
//							}else{
//							/*	error = "Row No" + rowCnt + "Customer Code is Missing!";
//								resultbean.setSuccess(false);
//								resultbean.setMessage(error);
//							*/	break;
//							}
//							
//							
//						
//							}
						if (code == null || code.getCellType() == code.CELL_TYPE_BLANK ) {								
							
							if(code == null || code.getCellType() == code.CELL_TYPE_BLANK && code1!= null && code1.getCellType()!= Cell.CELL_TYPE_BLANK ){
								error = "row" + " " + ":" + rowCnt + error+" "+"Customer Code is Missing!";
								resultbean.setSuccess(false);
								resultbean.setMessage(error);

								throw new Exception(error);
								
							}else{
							/*	error = "Row No" + rowCnt + "Customer Code is Missing!";
								resultbean.setSuccess(false);
								resultbean.setMessage(error);
							*/	break;
							}
							
							
						}else{

							Iterator<Cell> cellIterator = row.cellIterator();
							ServicePartnerBean bean = new ServicePartnerBean();
							// String error = "";

							Cell bookNo = row.getCell(0);
							// if (bookNo == null){
							if (bookNo == null || bookNo.getCellType() == Cell.CELL_TYPE_BLANK) {

								error = "row" + " " + ":" + rowCnt + " " + error + "Customer Code is Missing!";
								resultbean.setMessage(error);
								throw new Exception(error);

							}

							else {

								ServicePartnerResultBean b = new ServicePartnerResultBean();
								
								if (bookNo.getCellType() == Cell.CELL_TYPE_STRING){
								b.setMessage(String.valueOf(bookNo.getStringCellValue()));
								} else
									if (bookNo.getCellType() == Cell.CELL_TYPE_NUMERIC){
								b.setMessage(String.valueOf(bookNo.getNumericCellValue()));
								}
								else{
								b.setMessage(bookNo.getStringCellValue());
								}
								
								b = servicePartnerDAO.con(b);
								if (b.getMessage().equals("true")) {
									
									String bookNonew = "";
									if (bookNo.getCellType() == Cell.CELL_TYPE_STRING){
										bookNonew = String.valueOf(bookNo.getStringCellValue());
									} else
										if (bookNo.getCellType() == Cell.CELL_TYPE_NUMERIC){
											bookNonew = String.valueOf(bookNo.getNumericCellValue());
									}
									else{
										bookNonew =  bookNo.getStringCellValue();
									}
									
									
									if (bookNonew.length() <= 6) {
										bean.setServicePartnerCode(bookNonew);
									} else {
										error = "row" + " " + ":" + rowCnt + " " + error
												+ "Customer Code size should be 6 ! ";
										resultbean.setMessage(error);
										throw new Exception(error);
									}
								} else {
									error = "row" + " " + ":" + rowCnt + " " + error + "Customer Code is already exits";
									resultbean.setMessage(error);
									throw new Exception(error);
								}
							}

							Cell bookNo1 = row.getCell(1);
							// if (bookNo1 == null){
							if (bookNo1 == null || bookNo1.getCellType() == Cell.CELL_TYPE_BLANK) {

								error = "row" + " " + ":" + rowCnt + " " + error + "Customer Name  is Missing!";
								resultbean.setMessage(error);
								throw new Exception(error);

							} else {
								ServicePartnerResultBean b = new ServicePartnerResultBean();
								b.setMessage(bookNo1.getStringCellValue());
								b = servicePartnerDAO.cusName(b);
								if (b.getMessage().equals("true")) {
									bean.setServicePartnerName(bookNo1.getStringCellValue());
								} else {
									error = "row" + " " + ":" + rowCnt + " " + error
											+ "Customer  Name is already exist";
									resultbean.setMessage(error);
									throw new Exception(error);
								}
							}

							Cell bookNo2 = row.getCell(2);
							// if (bookNo2 == null){
							if (bookNo2 == null || bookNo2.getCellType() == Cell.CELL_TYPE_BLANK) {

								error = "row" + " " + ":" + rowCnt + " " + error + "Branch Name  is Missing!";
								resultbean.setMessage(error);
								throw new Exception(error);
							} else {
								ServicePartnerResultBean b = new ServicePartnerResultBean();
								// b.setMessage(bookNo2.getStringCellValue());
								// b=servicePartnerDAO.vendor(b);
								String branch = getbranchCount(bookNo2.getStringCellValue());

								if (branch != null) {
									bean.setBranch(branch);
									System.out.println(branch);

								} else {
									error = "row" + " " + ":" + rowCnt + " " + error
											+ "Branch Code Not Avail in Branch Master  !..";
									System.out.println(error);
									resultbean.setMessage(error);
									throw new Exception(error);

								}
							}
							Cell bookNo3 = row.getCell(3);
							// if (bookNo3 == null) {
							if (bookNo3 == null || bookNo3.getCellType() == Cell.CELL_TYPE_BLANK) {

								error = "row" + " " + ":" + rowCnt + " " + error + "Customer Ledger Name  is Missing!";
								resultbean.setMessage(error);
								throw new Exception(error);

							} else {
								ServicePartnerResultBean b = new ServicePartnerResultBean();
								b.setMessage(bookNo3.getStringCellValue());
								bean.setServicePartnerLedgerName(bookNo3.getStringCellValue());
							}

							/*
							 * Cell bookNo4 = row.getCell(4); Integer
							 * str2=(bookNo4.getColumnIndex());
							 * bean.setCreditDaysOffered(str2);
							 * 
							 */
							// Cell origin = row.getCell(0);
							// if (origin == null || origin.getCellType() ==
							// Cell.CELL_TYPE_BLANK) {

							Cell bookNo4 = row.getCell(4);
							// Integer str2=(bookNo4.getColumnIndex());
							// if(bookNo4==null){
							if (bookNo4 == null || bookNo4.getCellType() == Cell.CELL_TYPE_BLANK) {
								bean.setCreditDaysOffered(0);
							} else {
								// if(bookNo4.getStringCellValue() != null &&
								// bookNo4.getStringCellValue() != "")
								// if(bookNo4.getStringCellValue() == ""){
								// bean.setCreditDaysOffered(0);
								// }else if(bookNo4.getStringCellValue() ==
								// null){
								// bean.setCreditDaysOffered(0);
								// }else
								Integer val = (int) bookNo4.getNumericCellValue();
								bean.setCreditDaysOffered(val);
							}

							/*
							 * Cell bookNo5 = row.getCell(5);
							 * if(bookNo5.getNumericCellValue()==1){
							 * bean.setActive(true); }else{
							 * k.setActive(false);
							 * 
							 * }
							 */

							Cell bookNo5 = row.getCell(5);
							// if(bookNo5==null){
							if (bookNo5 == null || bookNo5.getCellType() == Cell.CELL_TYPE_BLANK) {

								bean.setActive(false);
							} else {

								if (bookNo5.getCellType() == Cell.CELL_TYPE_NUMERIC)
									bean.setActive(true);
								else {
									if (bookNo5.getCellType() == Cell.CELL_TYPE_STRING)
										bean.setActive(true);
								}
							}

							Cell bookNo6 = row.getCell(6);
							// if(bookNo6==null){
							if (bookNo6 == null || bookNo6.getCellType() == Cell.CELL_TYPE_BLANK) {

								bean.setAddress(null);
							} else {
								if (bookNo6.getCellType() == Cell.CELL_TYPE_NUMERIC) {
									bean.setAddress(String.valueOf(bookNo6.getNumericCellValue()));

									Double str3 = Double.valueOf(bookNo6.getNumericCellValue());
									System.out.println(str3);

									// String rev = Double.toString(str3);

									String rev = String.valueOf(str3);

									// String strNew = rev.replace(".", "");
									bean.setAddress(rev);
									System.out.println(rev);

								} else {
									if (bookNo6.getCellType() == Cell.CELL_TYPE_STRING)
										bean.setAddress(bookNo6.getStringCellValue());
								}
							}

							Cell bookNo7 = row.getCell(7);
							// if (bookNo7 == null) {
							if (bookNo7 == null || bookNo7.getCellType() == Cell.CELL_TYPE_BLANK) {

								error = "row" + " " + ":" + rowCnt + " " + error + " City  is Missing!";
								resultbean.setMessage(error);
								throw new Exception(error);
							} else {
								ServicePartnerResultBean b = new ServicePartnerResultBean();
								// b.setMessage(bookNo7.getStringCellValue());
								// bean.setCity(bookNo7.getStringCellValue());
								String City = getCityCount(bookNo7.getStringCellValue());

								if (City != null) {
									bean.setCity(City);

								} else {
									error = "row" + " " + ":" + rowCnt + " " + error
											+ "  City Code Not Avail in City!..";
									System.out.println(error);
									resultbean.setMessage(error);
									throw new Exception(error);

								}
							}

							Cell bookNo8 = row.getCell(8);
							// if(bookNo8==null){
							if (bookNo8 == null || bookNo8.getCellType() == Cell.CELL_TYPE_BLANK) {

								bean.setRegion(null);
							} else {

								if (bookNo8.getCellType() == Cell.CELL_TYPE_NUMERIC)
									bean.setRegion(String.valueOf(bookNo8.getNumericCellValue()));
								else if (bookNo8.getCellType() == Cell.CELL_TYPE_STRING)
									bean.setRegion(bookNo8.getStringCellValue());
							}

							Cell bookNo9 = row.getCell(9);
							// if (bookNo9 == null) {
							if (bookNo9 == null || bookNo9.getCellType() == Cell.CELL_TYPE_BLANK) {

								error = "row" + " " + ":" + rowCnt + " " + error + "  Sundry Type  is Missing!";
								resultbean.setMessage(error);
								throw new Exception(error);
							} else {
								ServicePartnerResultBean b = new ServicePartnerResultBean();
								b.setMessage(bookNo9.getStringCellValue());
								bean.setSundryStatus(bookNo9.getStringCellValue());
							}

							Cell bookNo10 = row.getCell(10);
							// if(bookNo10==null){
							if (bookNo10 == null || bookNo10.getCellType() == Cell.CELL_TYPE_BLANK) {

								bean.setCountry(null);
							} else {

								if (bookNo10.getCellType() == Cell.CELL_TYPE_NUMERIC)
									bean.setCountry(String.valueOf(bookNo10.getNumericCellValue()));
								else if (bookNo10.getCellType() == Cell.CELL_TYPE_STRING)
									bean.setCountry(bookNo10.getStringCellValue());
							}

							Cell bookNo11 = row.getCell(11);
							// if(bookNo11==null){
							if (bookNo11 == null || bookNo11.getCellType() == Cell.CELL_TYPE_BLANK) {

								bean.setZipCode(null);
							} else {

								if (bookNo11.getCellType() == Cell.CELL_TYPE_NUMERIC) {
									bean.setZipCode(String.valueOf(bookNo11.getNumericCellValue()));
									Double str3 = Double.valueOf(bookNo11.getNumericCellValue());
									System.out.println(str3);

									String rev = String.valueOf(str3);

									String strNew = rev.replace(".", "");
									bean.setZipCode(strNew);
									System.out.println(strNew);
								} else if (bookNo11.getCellType() == Cell.CELL_TYPE_STRING)
									bean.setZipCode(bookNo11.getStringCellValue());
							}

							Cell bookNo12 = row.getCell(12);
							// if(bookNo12==null){
							if (bookNo12 == null || bookNo12.getCellType() == Cell.CELL_TYPE_BLANK) {

								bean.setPersonToContact(null);
							} else {

								if (bookNo12.getCellType() == Cell.CELL_TYPE_NUMERIC)
									bean.setPersonToContact(String.valueOf(bookNo12.getNumericCellValue()));
								else if (bookNo12.getCellType() == Cell.CELL_TYPE_STRING)
									bean.setPersonToContact(bookNo12.getStringCellValue());

							}

							Cell bookNo13 = row.getCell(13);
							// if(bookNo13==null){
							if (bookNo13 == null || bookNo13.getCellType() == Cell.CELL_TYPE_BLANK) {

								bean.setDesignation(null);
							} else {

								if (bookNo13.getCellType() == Cell.CELL_TYPE_NUMERIC)
									bean.setDesignation(String.valueOf(bookNo13.getNumericCellValue()));
								else if (bookNo13.getCellType() == Cell.CELL_TYPE_STRING)
									bean.setDesignation(bookNo13.getStringCellValue());

							}

							Cell bookNo14 = row.getCell(14);
							// if (bookNo14 == null){
							if (bookNo14 == null || bookNo14.getCellType() == Cell.CELL_TYPE_BLANK) {

								error = "row" + " " + ":" + rowCnt + " " + error + " Email Id is Missing!";
								resultbean.setMessage(error);
								throw new Exception(error);
							} else {
								ServicePartnerResultBean b = new ServicePartnerResultBean();
								b.setMessage(bookNo14.getStringCellValue());
								b = servicePartnerDAO.email(b);

								if (b.getMessage().equals("true")) {
									bean.setEmailId(bookNo14.getStringCellValue());
								} else {
									error = "row" + " " + ":" + rowCnt + " " + error + "   Email Id is already exist";
									resultbean.setMessage(error);
									throw new Exception(error);

								}
							}
							Cell bookNo15 = row.getCell(15);
							// if(bookNo15==null){
							if (bookNo15 == null || bookNo15.getCellType() == Cell.CELL_TYPE_BLANK) {

								bean.setLandLineNo(null);
							} else {
								if (bookNo15.getCellType() == Cell.CELL_TYPE_NUMERIC) {
									bean.setLandLineNo(String.valueOf(bookNo15.getNumericCellValue()));
									Double str3 = Double.valueOf(bookNo15.getNumericCellValue());
									System.out.println(str3);

									// String rev = Double.toString(str3);

									String rev = String.valueOf(str3);

									String strNew = rev.replace(".", "");
									bean.setLandLineNo(strNew);
									System.out.println(strNew);

								} else if (bookNo15.getCellType() == Cell.CELL_TYPE_STRING)
									bean.setLandLineNo(bookNo15.getStringCellValue());

							}

							/*
							 * Cell bookNo16 = row.getCell(16);
							 * if(bookNo16==null){ bean.setMobileNo(null);
							 * }else{
							 * bean.setMobileNo(bookNo16.getStringCellValue());
							 * }
							 */

							Cell bookNo16 = row.getCell(16);

							if (bookNo16 == null || bookNo16.getCellType() == Cell.CELL_TYPE_BLANK) {

								// if(bookNo16==null){
								bean.setMobileNo(null);
							} else {

								if (bookNo16.getCellType() == Cell.CELL_TYPE_NUMERIC) {
									// bean.setMobileNo(String.valueOf(bookNo16.getNumericCellValue()));
									// bean.setMobileNo1(bookNo16.getNumericCellValue());
									Double str3 = Double.valueOf(bookNo16.getNumericCellValue());
									System.out.println(str3);

									// String rev = Double.toString(str3);

									String rev = String.valueOf(str3);

									String strNew = rev.replace(".", "");
									bean.setMobileNo(strNew);
									System.out.println(strNew);
								} else if (bookNo16.getCellType() == Cell.CELL_TYPE_STRING)
									bean.setMobileNo(bookNo16.getStringCellValue());
							}

							Cell bookNo17 = row.getCell(17);
							// if(bookNo17==null){
							if (bookNo17 == null || bookNo17.getCellType() == Cell.CELL_TYPE_BLANK) {

								bean.setSkypeId(null);
							} else {
								if (bookNo17.getCellType() == Cell.CELL_TYPE_NUMERIC)
									bean.setSkypeId(String.valueOf(bookNo13.getNumericCellValue()));
								else if (bookNo13.getCellType() == Cell.CELL_TYPE_STRING)
									bean.setSkypeId(bookNo17.getStringCellValue());

							}

							Cell bookNo18 = row.getCell(18);
							// if(bookNo18==null){
							if (bookNo18 == null || bookNo18.getCellType() == Cell.CELL_TYPE_BLANK) {

								bean.setWebSite(null);
							} else {
								if (bookNo18.getCellType() == Cell.CELL_TYPE_NUMERIC)
									bean.setWebSite(String.valueOf(bookNo18.getNumericCellValue()));
								else if (bookNo18.getCellType() == Cell.CELL_TYPE_STRING)
									bean.setWebSite(bookNo18.getStringCellValue());

							}

							Cell bookNo19 = row.getCell(19);
							// if(bookNo19==null){
							if (bookNo19 == null || bookNo19.getCellType() == Cell.CELL_TYPE_BLANK) {

								bean.setServicePartnerDescription(null);
							} else {

								if (bookNo19.getCellType() == Cell.CELL_TYPE_NUMERIC)
									bean.setServicePartnerDescription(String.valueOf(bookNo19.getNumericCellValue()));
								else if (bookNo19.getCellType() == Cell.CELL_TYPE_STRING)
									bean.setServicePartnerDescription(bookNo19.getStringCellValue());

							}

							Cell bookNo20 = row.getCell(20);
							// if(bookNo20==null){
							if (bookNo20 == null || bookNo20.getCellType() == Cell.CELL_TYPE_BLANK) {

								bean.setpANNo(null);
							} else {

								if (bookNo20.getCellType() == Cell.CELL_TYPE_NUMERIC) {
									bean.setpANNo(String.valueOf(bookNo20.getNumericCellValue()));
									Double str3 = Double.valueOf(bookNo20.getNumericCellValue());
									System.out.println(str3);

									String rev = String.valueOf(str3);

									// String strNew = rev.replace(".", "");
									bean.setpANNo(rev);
									System.out.println(rev);
								} else if (bookNo20.getCellType() == Cell.CELL_TYPE_STRING)
									bean.setpANNo(bookNo20.getStringCellValue());

							}

							Cell bookNo21 = row.getCell(21);
							// if (bookNo21 == null){
							if (bookNo21 == null || bookNo21.getCellType() == Cell.CELL_TYPE_BLANK) {

								error = "row" + " " + ":" + rowCnt + " " + error + "  Defalut Type is Missing!";
								resultbean.setMessage(error);
								throw new Exception(error);
							} else {
								// ServicePartnerResultBean b=new
								// ServicePartnerResultBean();
								// b.setMessage(bookNo21.getStringCellValue());
								// bean.setDefaultType(bookNo21.getStringCellValue());
								String Defaultcnt = getDefalutCount(bookNo21.getStringCellValue());

								if (Defaultcnt != null) {
									bean.setDefaultType(Defaultcnt);

								} else {
									error = "row" + " " + ":" + rowCnt + " " + error
											+ "  Default Type Not Available in List!..";
									resultbean.setMessage(error);
									throw new Exception(error);
									// b.setMessage(error);
									// throw new Exception(error);

								}
							}

							Cell bookNo22 = row.getCell(22);
							// if(bookNo22==null){
							if (bookNo22 == null || bookNo22.getCellType() == Cell.CELL_TYPE_BLANK) {
								bean.setPartnerClassification(0);
							} else {
								bean.setPartnerClassification(Integer.parseInt(bookNo22.getStringCellValue()));
							}

							Cell bookNo23 = row.getCell(23);
							// Integer str2=(bookNo4.getColumnIndex());
							// if(bookNo4==null){
							if (bookNo23 == null || bookNo23.getCellType() == Cell.CELL_TYPE_BLANK) {
								
								error = "row" + " " + ":" + rowCnt + " " + error + " GSTN State Code  is Missing!";
								resultbean.setMessage(error);
								throw new Exception(error);
							} else {
								Integer val = (int) bookNo23.getNumericCellValue();
								bean.setgSTNStateCode(val);
							}

							Cell bookNo24 = row.getCell(24);
							// if (bookNo24 == null){
							if (bookNo24 == null || bookNo24.getCellType() == Cell.CELL_TYPE_BLANK) {

								error = "row" + " " + ":" + rowCnt + " " + error + "  Sales Person Type is Missing!";
								resultbean.setMessage(error);
								throw new Exception(error);
							} else {
								// ServicePartnerResultBean b=new
								// ServicePartnerResultBean();
								// b.setMessage(bookNo24.getStringCellValue());
								// bean.setSalesPerson(bookNo24.getStringCellValue());
								String Salescnt = getsalesCount(bookNo24.getStringCellValue());

								if (Salescnt != null) {
									bean.setSalesPerson(Salescnt);

								} else {
									error = "row" + " " + ":" + rowCnt + " " + error
											+ "Sales Person Name Not Available in Employee Master!..";
									System.out.println(error);
									// b.setMessage(error);
									resultbean.setMessage(error);
									throw new Exception(error);
									// throw new Exception(error);

								}
							}

							Cell bookNo25 = row.getCell(25);
							// if(bookNo25==null){
							if (bookNo25 == null || bookNo25.getCellType() == Cell.CELL_TYPE_BLANK) {

								bean.setExemptionUnder(null);
							} else {

								if (bookNo25.getCellType() == Cell.CELL_TYPE_NUMERIC)
									bean.setExemptionUnder(String.valueOf(bookNo25.getNumericCellValue()));
								else if (bookNo25.getCellType() == Cell.CELL_TYPE_STRING)
									bean.setExemptionUnder(bookNo25.getStringCellValue());

							}

							Cell bookNo26 = row.getCell(26);
							// if(bookNo26==null){
							if (bookNo26 == null || bookNo26.getCellType() == Cell.CELL_TYPE_BLANK) {

								bean.setgSTNNo(null);

							} else {

								if (bookNo26.getCellType() == Cell.CELL_TYPE_NUMERIC) {
									// bean.setgSTNNo(String.valueOf(bookNo26.getNumericCellValue()));
									Double str3 = Double.valueOf(bookNo26.getNumericCellValue());
									System.out.println(str3);

									// String rev = Double.toString(str3);

									String rev = String.valueOf(str3);

									// String strNew = rev.replace(".", "");
									bean.setgSTNNo(rev);
									System.out.println(rev);

								} else if (bookNo26.getCellType() == Cell.CELL_TYPE_STRING)
									bean.setgSTNNo(bookNo26.getStringCellValue());

							}

							Cell bookNo27 = row.getCell(27);
							// if (bookNo2 == null){
							if (bookNo27 == null || bookNo27.getCellType() == Cell.CELL_TYPE_BLANK) {
								bean.setServicePartnerTypeList(null);

							} else {

								String custp = bookNo27.getStringCellValue();
								String[] arrOfStr = custp.split(",");

								for (String del : arrOfStr) {
									String customertp = getcustpe(del);
									if (customertp != null) {
										custype.add(Integer.parseInt(customertp));
										System.out.println(customertp);
									} else {

										error = "row" + " " + ":" + rowCnt + " " + error
												+ "  Customer Type Not Avail!..";
										System.out.println(error);
										resultbean.setMessage(error);
										throw new Exception(error);

									}

								}

								// String customertype =
								// getCustomertype(bookNo27.getStringCellValue());

								// String customertype =
								// getCustomertype(bookNo27.getStringCellValue());

								if (custype != null) {
									bean.setServicePartnerTypeList(custype);

									System.out.println(custype);

								} else {
									error = "row" + " " + ":" + rowCnt + " " + error + "  Customer Type Not Avail!..";
									System.out.println(error);
									resultbean.setMessage(error);
									throw new Exception(error);

								}
							}

							Cell bookNo28 = row.getCell(28);
							// if(bookNo27==null){
							if (bookNo28 == null || bookNo28.getCellType() == Cell.CELL_TYPE_BLANK) {

								bean.setCreditAmt(0);

							} else {
								

								if (bookNo28.getCellType() == Cell.CELL_TYPE_STRING){
									String amountGST = bookNo28.getStringCellValue();
									String amtGST[] = amountGST.split("[, +.@]+");
									String amt = amtGST[0];
									Double str1 = Double.valueOf(amt);
									bean.setCreditAmt(str1);								
									} 
								else
									if (bookNo28.getCellType() == Cell.CELL_TYPE_NUMERIC){

										Double str1 = Double.valueOf(bookNo28.getNumericCellValue());
										bean.setCreditAmt(str1);								}
								
							}

							beanList.add(bean);

							if (!error.equalsIgnoreCase("")) {
								errorList.add(error);
								resultbean.setMessage(rowCnt + error);

								// throw new Exception(error);

							}

						}

						 

//					}
				}
				}
 
			 

			if (errorList.size() == 0)  {
		          if(beanList.size()!=0){
				resultbean.setlServicePartnerBean(beanList);

			}
	   }
					   
	
	
	//}
//			if(errorFlag == true)
			if(resultbean.getlServicePartnerBean().size() > 0){
			resultbean =	servicePartnerDAO.saveImportDetailsnewdata(resultbean);
			resultbean.setSuccess1(true);
			}
			else{
				resultbean.setSuccess1(false);
			}
			} catch (Exception e) {
				e.printStackTrace();

//				isSuccess = false;
			}
//			if (errorList.size() > 0) {
//				errorFlag = false;
//
//				List<String> answer = new ArrayList<>();
//
//				for (String str : errorList)
//					for (String s : str.split("\n")) {
//						if (!s.isEmpty()) {
//							answer.add(s);
//						}
//
//					}
//				resultbean.setSuccess1(false);
//				resultbean.setErrorList(answer);
//				// memberCreationResultBean.setErrorExcelList(errorMembersList);
//
//			} 
//			if(!resultbean.isSuccess1()){
//				errorFlag = false;
//				resultbean.setSuccess1(false);
//			}
//			else {
//				errorFlag = true;
//				resultbean.setSuccess1(true);
//			}
//			if (resultbean.isSuccess1()) {
//				resultbean.setSuccess1(true);
//			} else {
//				resultbean.setSuccess1(false);
//			}
	         return resultbean;

		}

		
		private String getcustpe(String del) {
			boolean success = false;
			String customertype = null;
			int count = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_customer_cnt, Integer.class, del.trim());
			if (count > 0) {
				success = true;
				customertype =  jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_customer_type, String.class, del.trim());
			} else {
				success = false;

			}
			return customertype;
		}

		private String getCustomertype(String stringCellValue) {
			// TODO Auto-generated method stub
			boolean success = false;
			String customertype = null;
			int count = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_customer_cnt, Integer.class, stringCellValue.trim());
			if (count > 0) {
				success = true;
				customertype =  jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_customer_type, String.class, stringCellValue.trim());
			} else {
				success = false;

			}
			return customertype;
		}

		private String getsalesCount(String stringCellValue) {
			boolean success = false;
			String sales = null;
			int count = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_sales_cnt, Integer.class, stringCellValue.trim());
			if (count > 0) {
				success = true;
				sales =  jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_sales, String.class, stringCellValue.trim());
			} else {
				success = false;

			}
			return sales;
		}

		private String getDefalutCount(String stringCellValue) {
			boolean success = false;
			String delutcode = null;
			int count = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_defult_cnt, Integer.class, stringCellValue.trim());
			if (count > 0) {
				success = true;
				delutcode =  jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_defult, String.class, stringCellValue.trim());
			} else {
				success = false;

			}
			return delutcode;
		}

		private String getCityCount(String stringCellValue) {
			// TODO Auto-generated method stub
			ServicePartnerNewBean bean = new ServicePartnerNewBean();

			boolean success = false;
			String citycode = null;
			int count = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_City_cnt, Integer.class, stringCellValue.trim());
			if (count > 0) {
				success = true;
				citycode =  jdbcTemplate.queryForObject(ServicePartnerQueryUtil.  GET_City, String.class, stringCellValue.trim());
				bean.setCity(citycode);
			} else {
				success = false;

			}
			return citycode;
		}


		private String getbranchCount(String stringCellValue) {
			ServicePartnerNewBean bean = new ServicePartnerNewBean();

			boolean success = false;
			String branchcode = null;
			int count = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_Branch_cnt, Integer.class, stringCellValue.trim());
			if (count > 0) {
				success = true;
				branchcode =  jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_Branch, String.class, stringCellValue.trim());
				bean.setBranch(branchcode);
			} else {
				success = false;

			}
			return branchcode;
		}

				
		}
				
					
	
		
	
