package com.dci.master.servicepartnerNew;

import java.io.File;
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
import org.apache.poi.ss.usermodel.IndexedColors;
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
import com.dci.tenant.user.UserDetail;

@Service
public class ServicePartnerNewServiceImpl implements ServicePartnerNewService {

	@Autowired
	ServicePartnerNewDAO servicePartnerDAO;

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public ServicePartnerNewResultBean getDropDownList() {
		// TODO Auto-generated method stub
		return servicePartnerDAO.getDropDownList();
	}

	@Override
	public ServicePartnerNewResultBean getServicePartnerList(String name) {
		// TODO Auto-generated method stub
		return servicePartnerDAO.getServicePartnerList(name);
	}

	@Override
	public ServicePartnerNewResultBean saveServicePartner(ServicePartnerNewResultBean servicePartnerBean) {
		// TODO Auto-generated method stub
		return servicePartnerDAO.saveServicePartner(servicePartnerBean);
	}

	@Override
	public ServicePartnerNewResultBean updateServicePartner(ServicePartnerNewResultBean servicePartnerBean) {
		// TODO Auto-generated method stub
		return servicePartnerDAO.updateServicePartner(servicePartnerBean);
	}

	@Override
	public ServicePartnerNewResultBean editServicePartner(int servicePartnerId) {
		// TODO Auto-generated method stub
		return servicePartnerDAO.editServicePartner(servicePartnerId);
	}

	@Override
	public ServicePartnerNewResultBean viewServicePatrnerList(int servicePartnerId) {
		// TODO Auto-generated method stub
		return servicePartnerDAO.viewServicePatrnerList(servicePartnerId);
	}

	@Override
	public ServicePartnerNewResultBean deleteServicePartner(int servicePartnerId) {
		// TODO Auto-generated method stub
		return servicePartnerDAO.deleteServicePartner(servicePartnerId);
	}

	@Override
	public ServicePartnerNewResultBean createLogin(int rowid) {
		return servicePartnerDAO.createLogin(rowid);
	}

	@Override
	public ServicePartnerNewResultBean getServicePartnerDetailList() {
		// TODO Auto-generated method stub
		return servicePartnerDAO.getServicePartnerDetailList();
	}

	@Override
	public ServicePartnerNewResultBean deleteKeyDetail(List<ServicePartnerNewKeyBean> lServicePartnerKeyBean) {
		// TODO Auto-generated method stub
		return servicePartnerDAO.deleteKeyDetail(lServicePartnerKeyBean);
	}

	// kyc
	@Override
	public boolean saveCustomCommDetail(CustomerMasterNewCommDetail2 customerMasterCommDetail, String userId)
			throws Exception {
		return servicePartnerDAO.saveCustomerCommDetail(customerMasterCommDetail, userId);
	}

	@Override
	public ServicePartnerNewResultBean getCustomCommDetail(String srvcprtnrcd) throws Exception {

		return servicePartnerDAO.getCustomCommDetail(srvcprtnrcd);
	}

	@Override

	public boolean updateCustomerCommDetail2(CustomerMasterNewCommDetail2 customerMasterCommDetail, String userId)
			throws Exception {
		return servicePartnerDAO.updateCustomerCommDetail(customerMasterCommDetail, userId);
	}

	@Override
	public boolean deleteCustomerComm(String customCommId, String customId) throws Exception {
		return servicePartnerDAO.deleteCustomerComm(customCommId, customId);
	}

	@Override
	public ServicePartnerNewResultBean getCountryList(int cityId) {
		// TODO Auto-generated method stub
		return servicePartnerDAO.getCountryList(cityId);
	}

	@Override
	public String generateExcel() {
		String path = "";
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
			ServicePartnerNewResultBean bean = new ServicePartnerNewResultBean();
			List<ServicePartnerNewBean> lServicePartnerBean = new ArrayList<ServicePartnerNewBean>();
			bean = servicePartnerDAO.getServicePartnerList("servicepartner");
			// Create a blank sheet
			XSSFSheet excelsheet = workbook.createSheet("ServicePartnerList");
			setExcelMainHeader(excelsheet, mainHeaderStyle);
			setExcelSubHeader(excelsheet, subHeaderStyle);
			setExcelRows(excelsheet, workbook, bean.getlServicePartnerBean(), subHeaderStyle);
			String fileName = null;
			fileName = "SevicePartner";
			path = writeExcel(workbook, ConfigurationProps.exportFilesPath, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;

	}

	private void setExcelRows(XSSFSheet excelsheet, XSSFWorkbook workbook, List<ServicePartnerNewBean> bean,
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
				Row row = excelsheet.createRow(rCount);
				int count = 0;

				// Cell cell;

				Cell cell = row.createCell(count);
				cell.setCellStyle(my_style2);
				cell.setCellValue(bean.get(i).getServicePartnerLedgerName());
				count++;
				Cell cell1 = row.createCell(count);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(bean.get(i).getAddress());
				count++;
				Cell cell2 = row.createCell(count);
				cell2.setCellStyle(my_style2);
				cell2.setCellValue(bean.get(i).getSalesPerson());
				count++;
				Cell cell3 = row.createCell(count);
				cell3.setCellStyle(my_style2);
				cell3.setCellValue(bean.get(i).getBranchName());
				count++;
				Cell cell4 = row.createCell(count);
				cell4.setCellStyle(my_style2);
				cell4.setCellValue(bean.get(i).getCityName());
				count++;
				Cell cell5 = row.createCell(count);
				cell5.setCellStyle(my_style2);
				cell5.setCellValue(bean.get(i).getCountry());
				count++;
				Cell cell6 = row.createCell(count);
				cell6.setCellStyle(my_style2);
				cell6.setCellValue(bean.get(i).getExemptionUnder());
				count++;

				Cell cell7 = row.createCell(count);
				cell7.setCellStyle(my_style2);
				cell7.setCellValue(bean.get(i).getgSTNNo());
				count++;

				Cell cell8 = row.createCell(count);
				cell8.setCellStyle(my_style2);
				cell8.setCellValue(bean.get(i).getCusvenagent());
				count++;

				/*
				 * Cell cell7 = row.createCell(count);
				 * cell7.setCellStyle(my_style2);
				 * cell7.setCellValue(bean.get(i).getSalesPerson()); count++;
				 * Cell cell8 = row.createCell(count);
				 * cell8.setCellStyle(my_style2); if(bean.get(i).isActive()) {
				 * cell8.setCellValue("True"); } else {
				 * cell8.setCellValue("False"); }
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
			// List<ReportHeaderBean> header =
			// objWholeData.getLjobOrderReportheaderlist();
			// for (int i = 0; i < header.size(); i++) {
			int cellcount = 0;
			Cell cell = row.createCell(cellcount);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("SERVICE PARTNER NAME");
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

			Cell cell6 = row.createCell(cellcount);
			cell6.setCellStyle(subHeaderStyle);
			cell6.setCellValue("NETWORK");
			cellcount++;

			Cell cell7 = row.createCell(cellcount);
			cell7.setCellStyle(subHeaderStyle);
			cell7.setCellValue("GST NO");
			cellcount++;

			Cell cell8 = row.createCell(cellcount);
			cell8.setCellStyle(subHeaderStyle);
			cell8.setCellValue("Type");
			cellcount++;

			/*
			 * Cell cell7 = row.createCell(cellcount);
			 * cell7.setCellStyle(subHeaderStyle);
			 * cell7.setCellValue("Sales Person"); cellcount++;
			 * 
			 * Cell cell8 = row.createCell(cellcount);
			 * cell8.setCellStyle(subHeaderStyle); cell8.setCellValue("Active");
			 * cellcount++;
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setExcelMainHeader(XSSFSheet excelsheet, XSSFCellStyle mainHeaderstyle) {
		Row row = excelsheet.createRow(0);
		excelsheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 16));
		Cell cell = row.createCell((short) 0);
		cell.setCellStyle(mainHeaderstyle);
		cell.setCellValue("Sevice Partner List");

	}

	private String writeExcel(XSSFWorkbook workbook, String filePath, String filePathName) {
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
	public void excellExport(ServicePartnerNewResultBean objBookingReportResultBean,
			ServiceNewMapBean objBookingReportBean, String pdfFile) throws Exception {
		// TODO Auto-generated method stub
		List<ServicePartnerNewBean> bookingList = new ArrayList<ServicePartnerNewBean>();

		// ServicePartnerNewResultBean servicePartnerResultBean = new
		// ServicePartnerNewResultBean();

		String name = "";
		bookingList = servicePartnerDAO.getServicePartnerListnew();

		try {
			// Blank workbook
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFCellStyle my_style = workbook.createCellStyle();
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
			// font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);
			XSSFCellStyle my_style1 = workbook.createCellStyle();
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
			// font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font1.setFontHeightInPoints((short) 10);
			my_style1.setFont(font1);
			XSSFCellStyle my_style2 = workbook.createCellStyle();
			my_style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style2.setAlignment(HSSFCellStyle.ALIGN_LEFT);

			XSSFCellStyle my_style3 = workbook.createCellStyle();
			my_style3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style3.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style3.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style3.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			// Create a blank sheet
			XSSFSheet excelSheet = workbook.createSheet("VendorMaster");

			// set main header
			setExcelMainHeader(excelSheet, my_style, bookingList);

			// set header
			setExcelHeader(excelSheet, my_style1);

			// set Data
			setExcelRows(excelSheet, bookingList, my_style1, my_style2, my_style3);

			for (int i = 0; i < 13; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// export excell
			String sFileUrl = writeExcel(workbook, pdfFile);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return;

	}

	public void setExcelMainHeader(XSSFSheet excelSheet, XSSFCellStyle my_style,
			List<ServicePartnerNewBean> bookingList) {
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 12));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("VendorMaster");
		cell.setCellStyle(my_style);

	}

	public void setExcelHeader(XSSFSheet excelSheet, XSSFCellStyle my_style1) {

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {

			Row row = excelSheet.createRow((short) 2);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Vendor Id");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Code");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Name");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Ledger	Name");

			/*
			 * Cell cell4 = row.createCell(4); cell4.setCellStyle(my_style1);
			 * cell4.setCellValue("Region");
			 * 
			 */ Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("GST NO");

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("City Code");

			Cell cell6 = row.createCell(6);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Type");

			Cell cell7 = row.createCell(7);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("Branch");

			Cell cell8 = row.createCell(8);
			cell8.setCellStyle(my_style1);
			cell8.setCellValue("Sales Person");

			/*
			 * Cell cell9 = row.createCell(10); cell9.setCellStyle(my_style1);
			 * cell9.setCellValue("Modified By");
			 * 
			 */ /*
				 * Cell cell11 = row.createCell(12);
				 * cell11.setCellStyle(my_style1);
				 * cell11.setCellValue("Modified Date");
				 * 
				 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setExcelRows(XSSFSheet excelSheet, List<ServicePartnerNewBean> bookingList, XSSFCellStyle my_style1,
			XSSFCellStyle my_style2, XSSFCellStyle my_style3) {
		int record = 3, sno = 1;

		try {
			int serial = 1;
			for (ServicePartnerNewBean objBookingReportBean : bookingList) {
				Row row = excelSheet.createRow((short) record++);
				row.setHeight((short) 350);
				for (int i = 0; i < 13; i++) {
					excelSheet.autoSizeColumn(i);
				}

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style2);
				cell0.setCellValue((objBookingReportBean.getId()));

				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(checkNullValue(objBookingReportBean.getServicePartnerCode()));

				Cell cell2 = row.createCell(2);
				cell2.setCellStyle(my_style2);
				cell2.setCellValue(checkNullValue(objBookingReportBean.getServicePartnerName()));

				Cell cell3 = row.createCell(3);
				cell3.setCellStyle(my_style2);
				cell3.setCellValue(checkNullValue(objBookingReportBean.getServicePartnerLedgerName()));

				/*
				 * Cell cell4 = row.createCell(4);
				 * cell4.setCellStyle(my_style2);
				 * if(objBookingReportBean.getPayLoad() != null){
				 * cell4.setCellValue((objBookingReportBean.getPayLoad())); }
				 */

				/*
				 * Cell cell4 = row.createCell(4);
				 * cell4.setCellStyle(my_style2);
				 * cell4.setCellValue(checkNullValue(objBookingReportBean.
				 * getRegion()));
				 * 
				 */
				Cell cell4 = row.createCell(4);
				cell4.setCellStyle(my_style2);
				cell4.setCellValue(checkNullValue(objBookingReportBean.getgSTNNo()));

				Cell cell5 = row.createCell(5);
				cell5.setCellStyle(my_style2);
				cell5.setCellValue(checkNullValue(objBookingReportBean.getCityName()));

				Cell cell6 = row.createCell(6);
				cell6.setCellStyle(my_style2);
				cell6.setCellValue(checkNullValue(objBookingReportBean.getDefaultTypeName()));

				/*
				 * Cell cell7 = row.createCell(7);
				 * cell7.setCellStyle(my_style2);
				 * cell7.setCellValue(checkNullValue(objBookingReportBean.
				 * getCountry()));
				 * 
				 */
				Cell cell7 = row.createCell(7);
				cell7.setCellStyle(my_style2);
				cell7.setCellValue(checkNullValue(objBookingReportBean.getBranchName()));

				Cell cell8 = row.createCell(8);
				cell8.setCellStyle(my_style2);
				cell8.setCellValue(checkNullValue(objBookingReportBean.getSalesPerson()));

				serial++;

				/*
				 * Cell cell7 = row.createCell(7);
				 * cell7.setCellStyle(my_style2);
				 * cell7.setCellValue((objBookingReportBean.getCreditAmount()));
				 * 
				 * 
				 * Cell cell8 = row.createCell(8);
				 * cell8.setCellStyle(my_style2);
				 * cell8.setCellValue(checkNullValue(objBookingReportBean.
				 * getNarration()));
				 */

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcel(XSSFWorkbook workbook, String pdfFile) {

		/*
		 * String sOutFile = pdfFile + "/BookingReport.xls";
		 * 
		 * File dirCreatory = new File(pdfFile); if (!dirCreatory.exists()) {
		 * dirCreatory.mkdir(); } String url = "";
		 * 
		 * FileOutputStream fileOut = null; System.out.println("filepath" +
		 * sOutFile); try { fileOut = new FileOutputStream(sOutFile);
		 * workbook.write(fileOut); url = pdfFile + "/BookingReport.xls"; }
		 * catch (IOException e) { e.printStackTrace(); } finally { try {
		 * fileOut.close(); } catch (Exception e) { e.printStackTrace(); } }
		 * return url;
		 */
		String l_str_file_out = pdfFile + "VendorMaster.xlsx";
		FileOutputStream fileOut = null;
		System.out.println("filepath" + l_str_file_out);
		try {
			File file = new File(l_str_file_out);

			if (file.delete()) {
				System.out.println(file.getName() + " is deleted");
			} else {
				System.out.println("delete failed");
			}

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
		return "VendorMaster.xlsx";
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

	private Integer checkNullIntegerValue(Integer value) {

		Integer t = 0;
		try {
			if (value == null) {
				value = 0;
			}
		} catch (Exception e) {
			return t;
		}

		return value;
	}

	@Override
	public ServicePartnerNewResultBean uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		return servicePartnerDAO.uploadFile(file);
	}

	@Override
	public ServicePartnerNewResultBean uploadFile1(MultipartFile file) {

		ServicePartnerNewResultBean resultbean = new ServicePartnerNewResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<String> errorList = new ArrayList<>();
		String fileName = file.getOriginalFilename();
		Workbook workbook = null;
		UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<List<String>> rowList = new ArrayList<List<String>>();
		List<String> colList = new ArrayList<String>();
		List<Boolean> colList1 = new ArrayList<Boolean>();


		List<Integer> custype = new ArrayList<Integer>();
		Iterator<Row> rowIterator = null;

		int i = 0;
		int sheetCount = 0;
		boolean errorFlag = false;

		String error = "";

		try {
			org.apache.poi.ss.usermodel.Workbook wb_xssf; // Declare XSSF
			org.apache.poi.ss.usermodel.Workbook wb_hssf; // Declare HSSF
			List<ServicePartnerNewBean> beanList = new ArrayList<>();

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
//						if (!code.getStringCellValue().contains("Customer Code")) {
//						if(code.CELL_TYPE_BLANK == 0){
//							
//							
//						if(code == null || code.getCellType() == code.CELL_TYPE_BLANK && code1!= null && code1.getCellType()!= Cell.CELL_TYPE_BLANK ){
//							error = "Row No" + rowCnt + "Customer Code is Missing!";
//							resultbean.setSuccess(false);
//							resultbean.setMessage(error);
//
//							throw new Exception(error);
//							
//						}else{
//						/*	error = "Row No" + rowCnt + "Customer Code is Missing!";
//							resultbean.setSuccess(false);
//							resultbean.setMessage(error);
//						*/	break;
//						}
//						
//						
//					
//						}
					
					if (code == null || code.getCellType() == code.CELL_TYPE_BLANK) {

						if (code == null || code.getCellType() == code.CELL_TYPE_BLANK && code1 != null
								&& code1.getCellType() != Cell.CELL_TYPE_BLANK) {
							error = "row" + " " + ":" +  rowCnt + "Vendor Code is Missing!";
							resultbean.setSuccess(false);
							resultbean.setMessage(error);

							throw new Exception(error);

						} else {
							/*
							 * error = "Row No" + rowCnt +
							 * "Customer Code is Missing!";
							 * resultbean.setSuccess(false);
							 * resultbean.setMessage(error);
							 */ break;
						}

					} else {
						Iterator<Cell> cellIterator = row.cellIterator();
						ServicePartnerNewBean bean = new ServicePartnerNewBean();


						Cell bookNo = row.getCell(0);
						if (bookNo == null || bookNo.getCellType() == Cell.CELL_TYPE_BLANK) {
							error = rowCnt + " " + error + " Vendor Code is Missing!";
							resultbean.setMessage(error);
							throw new Exception(error);

						} else {

							ServicePartnerNewResultBean b = new ServicePartnerNewResultBean();
							if (bookNo.getCellType() == Cell.CELL_TYPE_STRING){
								b.setMessage(String.valueOf(bookNo.getStringCellValue()));
								} else
									if (bookNo.getCellType() == Cell.CELL_TYPE_NUMERIC){
								b.setMessage(String.valueOf(bookNo.getNumericCellValue()));
								}
								else{
								b.setMessage(bookNo.getStringCellValue());
								}
						//	b.setMessage(bookNo.getStringCellValue());
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
								}
								else {
									error = rowCnt + " " + error + " Vendor Code Should be 6 ! ";
									resultbean.setMessage(error);
									throw new Exception(error);

								}
							} else {
								error =  "row" + " " + ":" +  rowCnt + " " + error + " Vendor Code is already exits";
								resultbean.setMessage(error);
								throw new Exception(error);

							}
						}

						Cell bookNo1 = row.getCell(1);
						if (bookNo1 == null || bookNo1.getCellType() == Cell.CELL_TYPE_BLANK) {
							error = rowCnt + " " + error + " Vendor Name is Missing";
							resultbean.setMessage(error);
							throw new Exception(error);

						} else {
							ServicePartnerNewResultBean b = new ServicePartnerNewResultBean();
							b.setMessage(bookNo1.getStringCellValue());
							b = servicePartnerDAO.vendor(b);
							if (b.getMessage().equals("true")) {
								bean.setServicePartnerName(bookNo1.getStringCellValue());
							} else {
								error =  "row" + " " + ":" + rowCnt + " " + error + " Vendor Name is already exist";
								resultbean.setMessage(error);
								throw new Exception(error);

							}
						}

						Cell bookNo2 = row.getCell(2);
						if (bookNo2 == null || bookNo2.getCellType() == Cell.CELL_TYPE_BLANK) {
							error =  "row" + " " + ":" + rowCnt + " " + error + "  " + " Branch Name  is Missing";
							resultbean.setMessage(error);
							throw new Exception(error);

						} else {
							ServicePartnerNewResultBean b = new ServicePartnerNewResultBean();
							// b.setMessage(bookNo2.getStringCellValue());
							// b=servicePartnerDAO.vendor(b);
							String branch = getbranchCount(bookNo2.getStringCellValue());

							if (branch != null) {
								bean.setBranch(branch);
								System.out.println(branch);

							} else {
								error = "row" + " " + ":" +  rowCnt + " " + error + " "+ "  Branch Code Not Avail in Branch Master  !..";
								System.out.println(error);
								resultbean.setMessage(error);
								throw new Exception(error);

							}
						}

						Cell bookNo3 = row.getCell(3);
						if (bookNo3 == null || bookNo3.getCellType() == Cell.CELL_TYPE_BLANK) {
							error =  "row" + " " + ":" + rowCnt + " " + error + " " + " Vendor Ledger Name  is Missing";
							resultbean.setMessage(error);
							throw new Exception(error);

						} else {
							ServicePartnerNewResultBean b = new ServicePartnerNewResultBean();
							b.setMessage(bookNo3.getStringCellValue());
							bean.setServicePartnerLedgerName(bookNo3.getStringCellValue());
						}

						Cell bookNo4 = row.getCell(4);
						if (bookNo4 == null || bookNo4.getCellType() == Cell.CELL_TYPE_BLANK) {
							bean.setCreditDaysOffered(0);
						} else {
							Integer val = (int) bookNo4.getNumericCellValue();
							bean.setCreditDaysOffered(val);
						}

						Cell bookNo5 = row.getCell(5);
						if (bookNo5 == null || bookNo5.getCellType() == Cell.CELL_TYPE_BLANK) {
							bean.setActive(false);
						} else {

							if (bookNo5.getCellType() == Cell.CELL_TYPE_NUMERIC)
								bean.setActive(true);
							else if (bookNo5.getCellType() == Cell.CELL_TYPE_STRING)
								bean.setActive(true);
						}

						Cell bookNo6 = row.getCell(6);
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

							} else if (bookNo6.getCellType() == Cell.CELL_TYPE_STRING)
								bean.setAddress(bookNo6.getStringCellValue());
						}

						Cell bookNo7 = row.getCell(7);
						if (bookNo7 == null || bookNo7.getCellType() == Cell.CELL_TYPE_BLANK) {
							error = "row" + " " + ":" + rowCnt + " " + error + " City  is Missing";
							resultbean.setMessage(error);
							throw new Exception(error);

						} else {
							ServicePartnerNewResultBean b = new ServicePartnerNewResultBean();
							// b.setMessage(bookNo7.getStringCellValue());
							// bean.setCity(bookNo7.getStringCellValue());
							String City = getCityCount(bookNo7.getStringCellValue());

							if (City != null) {
								bean.setCity(City);

							} else {
								error =  "row" + " " + ":" +rowCnt + " " + error + "  City Code Not Avail in City!..";
								resultbean.setMessage(error);
								throw new Exception(error);

							}
						}

						Cell bookNo8 = row.getCell(8);
						if (bookNo8 == null || bookNo8.getCellType() == Cell.CELL_TYPE_BLANK) {
							bean.setRegion(null);
						} else {

							if (bookNo8.getCellType() == Cell.CELL_TYPE_NUMERIC)
								bean.setRegion(String.valueOf(bookNo8.getNumericCellValue()));
							else if (bookNo8.getCellType() == Cell.CELL_TYPE_STRING)
								bean.setRegion(bookNo8.getStringCellValue());
						}

						Cell bookNo9 = row.getCell(9);
						if (bookNo9 == null || bookNo9.getCellType() == Cell.CELL_TYPE_BLANK) {
							error = "row" + " " + ":" +rowCnt + " "+error + "  Sundry Type  is Missing!";
							resultbean.setMessage(error);
							throw new Exception(error);

						} else {
							ServicePartnerNewResultBean b = new ServicePartnerNewResultBean();
							b.setMessage(bookNo9.getStringCellValue());
							bean.setSundryStatus(bookNo9.getStringCellValue());
						}

						Cell bookNo10 = row.getCell(10);
						if (bookNo10 == null || bookNo10.getCellType() == Cell.CELL_TYPE_BLANK) {
							bean.setCountry(null);
						} else {

							if (bookNo10.getCellType() == Cell.CELL_TYPE_NUMERIC)
								bean.setCountry(String.valueOf(bookNo10.getNumericCellValue()));
							else if (bookNo10.getCellType() == Cell.CELL_TYPE_STRING)
								bean.setCountry(bookNo10.getStringCellValue());
						}

						Cell bookNo11 = row.getCell(11);
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
						if (bookNo12 == null || bookNo12.getCellType() == Cell.CELL_TYPE_BLANK) {
							bean.setPersonToContact(null);
						} else {

							if (bookNo12.getCellType() == Cell.CELL_TYPE_NUMERIC)
								bean.setPersonToContact(String.valueOf(bookNo12.getNumericCellValue()));
							else if (bookNo12.getCellType() == Cell.CELL_TYPE_STRING)
								bean.setPersonToContact(bookNo12.getStringCellValue());

						}

						Cell bookNo13 = row.getCell(13);
						if (bookNo13 == null || bookNo13.getCellType() == Cell.CELL_TYPE_BLANK) {
							bean.setDesignation(null);
						} else {

							if (bookNo13.getCellType() == Cell.CELL_TYPE_NUMERIC)
								bean.setDesignation(String.valueOf(bookNo13.getNumericCellValue()));
							else if (bookNo13.getCellType() == Cell.CELL_TYPE_STRING)
								bean.setDesignation(bookNo13.getStringCellValue());

						}

						Cell bookNo14 = row.getCell(14);
						if (bookNo14 == null || bookNo14.getCellType() == Cell.CELL_TYPE_BLANK) {
							error = "row" + " " + ":" +rowCnt + " " + error +" "+"  Email Id  is Missing";
							resultbean.setMessage(error);
							throw new Exception(error);

						} else {
							ServicePartnerNewResultBean b = new ServicePartnerNewResultBean();
							b.setMessage(bookNo14.getStringCellValue());
							b = servicePartnerDAO.email(b);
							if (b.getMessage().equals("true")) {
								bean.setEmailId(bookNo14.getStringCellValue());
							} else {
								error = "row" + " " + ":" +rowCnt + " " + error +" "+ " Email  Id is already exist";
								resultbean.setMessage(error);
								throw new Exception(error);

							}
						}

						Cell bookNo15 = row.getCell(15);
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
						 * Cell bookNo16 = row.getCell(16); if(bookNo16==null){
						 * bean.setMobileNo(null); }else{
						 * bean.setMobileNo(bookNo16.getStringCellValue()); }
						 */

						Cell bookNo16 = row.getCell(16);

						if (bookNo16 == null || bookNo16.getCellType() == Cell.CELL_TYPE_BLANK) {
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
						if (bookNo17 == null || bookNo17.getCellType() == Cell.CELL_TYPE_BLANK) {
							bean.setSkypeId(null);
						} else {
							if (bookNo17.getCellType() == Cell.CELL_TYPE_NUMERIC)
								bean.setSkypeId(String.valueOf(bookNo13.getNumericCellValue()));
							else if (bookNo13.getCellType() == Cell.CELL_TYPE_STRING)
								bean.setSkypeId(bookNo17.getStringCellValue());

						}

						Cell bookNo18 = row.getCell(18);
						if (bookNo18 == null || bookNo18.getCellType() == Cell.CELL_TYPE_BLANK) {
							bean.setWebSite(null);
						} else {
							if (bookNo18.getCellType() == Cell.CELL_TYPE_NUMERIC)
								bean.setWebSite(String.valueOf(bookNo18.getNumericCellValue()));
							else if (bookNo18.getCellType() == Cell.CELL_TYPE_STRING)
								bean.setWebSite(bookNo18.getStringCellValue());

						}

						Cell bookNo19 = row.getCell(19);
						if (bookNo19 == null || bookNo19.getCellType() == Cell.CELL_TYPE_BLANK) {
							bean.setServicePartnerDescription(null);
						} else {

							if (bookNo19.getCellType() == Cell.CELL_TYPE_NUMERIC)
								bean.setServicePartnerDescription(String.valueOf(bookNo19.getNumericCellValue()));
							else if (bookNo19.getCellType() == Cell.CELL_TYPE_STRING)
								bean.setServicePartnerDescription(bookNo19.getStringCellValue());

						}

						Cell bookNo20 = row.getCell(20);
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
						if (bookNo21 == null) {
							error = "row" + " " + ":" + rowCnt + " " + error + "  Defalut Type is Missing";
							resultbean.setMessage(error);
							throw new Exception(error);

						} else {
							ServicePartnerNewResultBean b = new ServicePartnerNewResultBean();
							// b.setMessage(bookNo21.getStringCellValue());
							// bean.setDefaultType(bookNo21.getStringCellValue());
							String Defaultcnt = getDefalutCount(bookNo21.getStringCellValue());

							if (Defaultcnt != null) {
								bean.setDefaultType(Defaultcnt);

							} else {
								error = "row" + " " + ":" +rowCnt + " " + error + "  Default Type Not Available in List!..";
								System.out.println(error);
								resultbean.setMessage(error);
								throw new Exception(error);

							}
						}

						Cell bookNo22 = row.getCell(22);
						if (bookNo22 == null || bookNo22.getCellType() == Cell.CELL_TYPE_BLANK) {
							bean.setPartnerClassification(0);
						} else {
							bean.setPartnerClassification(Integer.parseInt(bookNo22.getStringCellValue()));
						}

						Cell bookNo23 = row.getCell(23);
						// Integer str2=(bookNo4.getColumnIndex());
						// if(bookNo4==null){
						if (bookNo23 == null || bookNo23.getCellType() == Cell.CELL_TYPE_BLANK) {
							error = "row" + " " + ":" +rowCnt + " " + error + " GSTN State Code  is Missing";
							resultbean.setMessage(error);
							throw new Exception(error);
						} else {
							Integer val = (int) bookNo23.getNumericCellValue();
							bean.setgSTNStateCode(val);
						}

						Cell bookNo24 = row.getCell(24);
						if (bookNo24 == null || bookNo24.getCellType() == Cell.CELL_TYPE_BLANK) {
							error = "row" + " " + ":" +rowCnt + " " + error + "  Sales Person Type is Missing";
							resultbean.setMessage(error);
							throw new Exception(error);

						} else {
							ServicePartnerNewResultBean b = new ServicePartnerNewResultBean();
							// b.setMessage(bookNo24.getStringCellValue());
							// bean.setSalesPerson(bookNo24.getStringCellValue());
							String Salescnt = getsalesCount(bookNo24.getStringCellValue());

							if (Salescnt != null) {
								bean.setSalesPerson(Salescnt);

							} else {
								error =  "row" + " " + ":" +rowCnt + " " + error
										+ "  Sales Person Name Not Available in Employee Master!..";
								resultbean.setMessage(error);
								throw new Exception(error);

							}
						}

						Cell bookNo25 = row.getCell(25);
						if (bookNo25 == null || bookNo25.getCellType() == Cell.CELL_TYPE_BLANK) {
							bean.setExemptionUnder(null);
						} else {

							if (bookNo25.getCellType() == Cell.CELL_TYPE_NUMERIC)
								bean.setExemptionUnder(String.valueOf(bookNo25.getNumericCellValue()));
							else if (bookNo25.getCellType() == Cell.CELL_TYPE_STRING)
								bean.setExemptionUnder(bookNo25.getStringCellValue());

						}

						Cell bookNo26 = row.getCell(26);
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

						beanList.add(bean);

						if (!error.equalsIgnoreCase("")) {
							errorList.add(error);
							resultbean.setMessage(rowCnt + error);

							// throw new Exception(error);

						}

					}
				//}
			}

			}

			if (errorList.size() == 0) {
				if (beanList.size() != 0) {
					resultbean.setlServicePartnerBean(beanList);

				}
			}

			if(resultbean.getlServicePartnerBean().size() > 0){

				resultbean = servicePartnerDAO.saveImportDetails(resultbean);
				resultbean.setSuccess1(true);
			} else {
				resultbean.setSuccess1(false);
			}
		} catch (Exception e) {
			e.printStackTrace();

			// isSuccess = false;
		}

		/*
		 * if (errorList.size() > 0) { errorFlag = false;
		 * 
		 * List<String> answer = new ArrayList<>();
		 * 
		 * for (String str : errorList) for (String s : str.split("\n")) { if
		 * (!s.isEmpty()) { answer.add(s); }
		 * 
		 * } resultbean.setSuccess1(false); resultbean.setErrorList(answer);
		 * 
		 * } else { errorFlag = true; resultbean.setSuccess1(true); } if
		 * (resultbean.isSuccess1()) { resultbean.setSuccess1(true); } else {
		 * resultbean.setSuccess1(false); }
		 */
		return resultbean;

	}

	private String getsalesCount(String stringCellValue) {
		boolean success = false;
		String sales = null;
		int count = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.GET_sales_cnt, Integer.class,
				stringCellValue.trim());
		if (count > 0) {
			success = true;
			sales = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.GET_sales, String.class,
					stringCellValue.trim());
		} else {
			success = false;

		}
		return sales;
	}

	private String getDefalutCount(String stringCellValue) {
		boolean success = false;
		String delutcode = null;
		int count = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.GET_defult_cnt, Integer.class,
				stringCellValue.trim());
		if (count > 0) {
			success = true;
			delutcode = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.GET_defult, String.class,
					stringCellValue.trim());
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
		int count = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.GET_City_cnt, Integer.class,
				stringCellValue.trim());
		if (count > 0) {
			success = true;
			citycode = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.GET_City, String.class,
					stringCellValue.trim());
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
		int count = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.GET_Branch_cnt, Integer.class,
				stringCellValue.trim());
		if (count > 0) {
			success = true;
			branchcode = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.GET_Branch, String.class,
					stringCellValue.trim());
			bean.setBranch(branchcode);
		} else {
			success = false;

		}
		return branchcode;
	}

}
