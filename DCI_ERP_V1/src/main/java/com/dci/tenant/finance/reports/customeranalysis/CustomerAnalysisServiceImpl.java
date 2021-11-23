package com.dci.tenant.finance.reports.customeranalysis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.jxls.common.Context;
import org.jxls.template.SimpleExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;

import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

@Service
public class CustomerAnalysisServiceImpl implements CustomerAnalysisService {

	@Autowired
	private CustomerAnalysisDAO customerAnalysisDAO;

	@Override
	public List<SelectivityBean> getCompanyList() {
		return customerAnalysisDAO.getCompanyList();
	}

	@Override
	public List<CustomerAnalysisBean> getCustomerAnalysisReport(CustomerAnalysisBean customerAnalysisBean) {
		return customerAnalysisDAO.getCustomerAnalysisReport(customerAnalysisBean);
	}

	@Override
	public CustomerAnalysisBean getWeek(String week, String year) throws CustomException {
		return customerAnalysisDAO.getWeek(week, year);
	}

	@Override
	public List<CustomerAnalysisBean> getMLO() {
		// TODO Auto-generated method stub
		return customerAnalysisDAO.getMLO();
	}

	@Override
	public void rateJvAgainstExcel(CustomerAnalysisBean customerAnalysisBean, String path) {

		try {
			int year = Integer.parseInt(customerAnalysisBean.getYear());
			String filename = customerAnalysisBean.getFilename();
			List<JVRatesagainstloadingavg> list = customerAnalysisDAO.getRatesagainstJvloadingavg(customerAnalysisBean);
			if (list.size() > 0) {
				JVRatesagainstloadingavg bean = new JVRatesagainstloadingavg();
				list.add(bean);
			}
			String fName = "/" + filename + ".xls";
			String fileName = path + fName;
			System.out.println(fileName);
			WritableWorkbook workbook = jxl.Workbook.createWorkbook(new File(fileName));
			workbook.createSheet("Report", 0);
			workbook.write();
			workbook.close();
			String[] str = { "Jan", "Feb", "Marn", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

			String[] ostr = { "janteus", "febteus", "marteus", "aprteus", "mayteus", "junteus", "julteus", "augteus", "septeus", "octteus", "novteus", "decteus" };
			Calendar now = Calendar.getInstance();
			int cuyear=now.get(Calendar.YEAR);
			int month = (now.get(Calendar.MONTH) + 1);
			if(cuyear>year){
				month=12;
			}
			
			StringBuffer result = new StringBuffer();
			List<String> List = new ArrayList<String>();


			String[] header = new String[List.size()];

			try (OutputStream os = new FileOutputStream(fileName)) {
				List<String> headers = Arrays.asList("CUSTOMER","POL","POD","QTY-XCL-D20","QTY-XCL-D40","QTY-XCL-M20","QTY-XCL-M40",
						"QTY-SFPL-D20","QTY-SFPL-D40","QTY-SFPL-M20","QTY-SFPL-M40",
						"QTY-OEL-D20","QTY-OEL-D40","QTY-OEL-M20","QTY-OEL-M40",
						"JV-MAXI-D20","JV-MAXI-D40","JV-MAXI-M20","JV-MAXI-M40",
						"JV-NYK-D20","JV-NYK-D40","JV-NYK-M20","JV-NYK-M40",
						"JV-OEL-D20","JV-OEL-D40","JV-OEL-M20","JV-OEL-M40",
						"JV-OSS-D20","JV-OSS-D40","JV-OSS-M20","JV-OSS-M40",
						"JV-SCI-D20","JV-SCI-D40","JV-SCI-M20","JV-SCI-M40",
						"JV-SFPL-D20","JV-SFPL-D40","JV-SFPL-M20","JV-SFPL-M40",
						"JV-STAR-D20","JV-STAR-D40","JV-STAR-M20","JV-STAR-M40",
						"JV-XCL-D20","JV-XCL-D40","JV-XCL-M20","JV-XCL-M40",
						"QUO-D20","QUO-D40","QUO-M20","QUO-M40");
				Context context = new Context();
				context.putVar("subLedger", list);
				SimpleExporter exporter = new SimpleExporter();
				exporter.gridExport(headers, list, "mloname,pol,pod,l_xcl_d20,l_xcl_d40,l_xcl_m20,l_xcl_m40,l_ssf_d20,l_ssf_d40,l_ssf_m20,l_ssf_m40,"
						+ "l_oel_d20,l_oel_d40,l_oel_m20,l_oel_m40,j_maxi_d20,j_maxi_d40,j_maxi_m20,j_maxi_m40,j_nyk_d20,j_nyk_d40,j_nyk_m20,j_nyk_m40,"
						+ "	j_oel_d20,j_oel_d40,j_oel_m20,j_oel_m40,j_oss_d20,j_oss_d40,j_oss_m20,j_oss_m40,j_sci_d20,j_sci_d40,j_sci_m20,j_sci_m40,"
						+ "	j_ssf_d20,j_ssf_d40,j_ssf_m20,j_ssf_m40,j_star_d20,j_star_d40,j_star_m20,j_star_m40,j_xcl_d20,j_xcl_d40,j_xcl_m20,j_xcl_m40,qm20rate,"
						+ "qm40rate,qd20rate,qd40rate", os);
			} catch (Exception e) {
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (WriteException e1) {
			e1.printStackTrace();
		}

	}

	protected static XSSFColor getXSSFColor(String RGB) {

		int red = Integer.parseInt(RGB.substring(0, 2), 16);
		int green = Integer.parseInt(RGB.substring(2, 4), 16);
		int blue = Integer.parseInt(RGB.substring(4, 6), 16);

		return new XSSFColor(new byte[] { (byte) red, (byte) green, (byte) blue });
	}
	
	@Override
	public void rateAgainstExcel(CustomerAnalysisBean customerAnalysisBean, String path) {

		try {
			int year = Integer.parseInt(customerAnalysisBean.getYear());
			String filename = customerAnalysisBean.getFilename();
			List<Ratesagainstloadingavg> list = customerAnalysisDAO.getRatesagainstloadingavg(customerAnalysisBean);
			if (list.size() > 0) {
				Ratesagainstloadingavg bean = new Ratesagainstloadingavg();
				list.add(bean);
			}
			String fName = "/" + filename + ".xls";
			String fileName = path + fName;
			System.out.println(fileName);
			WritableWorkbook workbook = jxl.Workbook.createWorkbook(new File(fileName));
			workbook.createSheet("Report", 0);
			workbook.write();
			workbook.close();
			String[] str = { "Jan", "Feb", "Marn", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

			String[] ostr = { "janteus", "febteus", "marteus", "aprteus", "mayteus", "junteus", "julteus", "augteus", "septeus", "octteus", "novteus", "decteus" };
			Calendar now = Calendar.getInstance();
			int month = (now.get(Calendar.MONTH) + 1);
			StringBuffer result = new StringBuffer();
			List<String> List = new ArrayList<String>();
			List.add("CUSTOMER");

			List.add("Sector");
			List.add("POL");
			List.add("POD");

			result.append("customer");
			result.append(",");
			result.append("sector");
			result.append(",");
			result.append("pol");
			result.append(",");
			result.append("pod");
			result.append(",");

			for (int i = 0; i < month; i++) {
				List.add(str[i] + "-" + year);
				result.append(ostr[i]);
				result.append(",");
			}
			List.add("Grand Total");
			List.add("AVG");
			List.add("D20 Rate");
			List.add("D40 Rate");
			List.add("M20 Rate");
			List.add("M40 Rate");
			List.add("R20 Rate");
			List.add("R40 Rate");
			List.add("REVENUE");

			result.append("grandtotal");
			result.append(",");
			result.append("avg");
			result.append(",");
			result.append("rated20");
			result.append(",");
			result.append("rated40");
			result.append(",");
			result.append("ratem20");
			result.append(",");
			result.append("ratem40");
			result.append(",");
			result.append("rater20");
			result.append(",");
			result.append("rater40");
			result.append(",");
			result.append("amount");

			String[] header = new String[List.size()];

			try (OutputStream os = new FileOutputStream(fileName)) {
				List<String> headers = Arrays.asList(List.toArray(header));
				Context context = new Context();
				context.putVar("subLedger", list);
				SimpleExporter exporter = new SimpleExporter();
				exporter.gridExport(headers, list, result.toString(), os);

			} catch (Exception e) {
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (WriteException e1) {
			e1.printStackTrace();
		}

	}

	//@Override
public void rateAgainstExcelold(CustomerAnalysisBean customerAnalysisBean, String path) {
try{
		
		int year = Integer.parseInt(customerAnalysisBean.getYear());
		String filename = customerAnalysisBean.getFilename();
		List<Ratesagainstloadingavg> list = customerAnalysisDAO.getRatesagainstloadingavg(customerAnalysisBean);
		if (list.size() > 0) {
			Ratesagainstloadingavg bean = new Ratesagainstloadingavg();
			list.add(bean);
		}
		String fName = "/" + filename + ".xls";
		String fileName = path + fName;
		System.out.println(fileName);
		WritableWorkbook workbook = jxl.Workbook.createWorkbook(new File(fileName));
		workbook.createSheet("Report", 0);
		workbook.write();
		workbook.close();
		 
		
		StringBuffer result = new StringBuffer();
		List<String> List = new ArrayList<String>();
		List.add("CUSTOMER"); 
		List.add("POL");
		List.add("POD");

		result.append("customer");
		result.append(",");
		result.append("sector");
		result.append(",");
		result.append("pol");
		result.append(",");
		result.append("pod");
		result.append(",");

		 
		List.add("Grand Total");
		List.add("AVG");
		List.add("D20 Rate");
		List.add("D40 Rate");
		List.add("M20 Rate");
		List.add("M40 Rate");
		List.add("R20 Rate");
		List.add("R40 Rate");
		List.add("REVENUE");

		result.append("grandtotal");
		result.append(",");
		result.append("avg");
		result.append(",");
		result.append("rated20");
		result.append(",");
		result.append("rated40");
		result.append(",");
		result.append("ratem20");
		result.append(",");
		result.append("ratem40");
		result.append(",");
		result.append("rater20");
		result.append(",");
		result.append("rater40");
		result.append(",");
		result.append("amount");

		String[] header = new String[List.size()];

		try (OutputStream os = new FileOutputStream(fileName)) {
			List<String> headers = Arrays.asList(List.toArray(header));
			Context context = new Context();
			context.putVar("subLedger", list);
			SimpleExporter exporter = new SimpleExporter();
			exporter.gridExport(headers, list, result.toString(), os);
		} catch (Exception e) {
		}
	} catch (Exception e) {
	}
	}
	public void rateJvAgainstExcelold(CustomerAnalysisBean customerAnalysisBean, String path) {/*
 
		
		try {

			Workbook wb = new XSSFWorkbook();
			Sheet sheet1 = wb.createSheet("Report");
			sheet1.setZoom(4, 5);

			CellStyle style = wb.createCellStyle();
			org.apache.poi.ss.usermodel.Font font = wb.createFont();

			font.setFontHeight((short) 200);
			font.setFontName("Calibri");
			style.setFont(font);
			style.setAlignment(CellStyle.ALIGN_CENTER);

			org.apache.poi.ss.usermodel.Cell cell;

			// Footer footer = sheet1.getFooter();
			sheet1.setFitToPage(true);
			sheet1.setMargin((short) 0, 0.20);
			sheet1.setMargin((short) 1, 0.20);
			sheet1.setMargin((short) 2, 0.20);
			sheet1.setMargin((short) 3, 0.20);

			PrintSetup ps = sheet1.getPrintSetup();

			// sheet1.setAutobreaks(true);

			ps.setFitHeight((short) 1);
			ps.setFitWidth((short) 1);
			ps.setFooterMargin(0);
			ps.setLandscape(true);
			ps.setLeftToRight(true);
			ps.setScale((short) 100);
			ps.setPaperSize((short) 9);
			ps.setHeaderMargin(0);

			XSSFColor color_blue = getXSSFColor("336699");

			Font font2 = wb.createFont();
			CellStyle style2 = wb.createCellStyle();
			font2.setFontHeight((short) 200);
			font2.setFontName("Arial Black");
			font2.setBoldweight(Font.BOLDWEIGHT_BOLD);
			((XSSFFont) font2).setColor(color_blue);
			font2.setUnderline(XSSFFont.U_SINGLE);
			style2.setFont(font2);
			style2.setAlignment(CellStyle.ALIGN_CENTER);

			Row row = sheet1.createRow(0);
			cell = row.createCell((short) 0);
			cell.setCellStyle(style2);
			cell.setCellValue("Report");
			sheet1.addMergedRegion(new CellRangeAddress(0, (short) 0, 0, (short) 25));
			createHeader(sheet1, wb);

			Row Row = null;
			int rowIndx =6;

			List<Map<String, Object>> rows =   customerAnalysisDAO.getRatesagainstJvloadingavg(customerAnalysisBean);
			CellStyle cellStyle1 = wb.createCellStyle();
			cellStyle1.setBorderBottom((short) 1);
			cellStyle1.setBorderTop((short) 1);
			cellStyle1.setBorderRight((short) 1);
			cellStyle1.setBorderLeft((short) 1);

			CellStyle cellStyle2 = wb.createCellStyle();
			cellStyle2.setBorderBottom((short) 1);
			cellStyle2.setBorderTop((short) 1);
			cellStyle2.setBorderRight((short) 1);
			cellStyle2.setBorderLeft((short) 1);
			cellStyle2.setWrapText(true);

			CellStyle my_style3 = wb.createCellStyle();
			my_style3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style3.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style3.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style3.setAlignment(HSSFCellStyle.ALIGN_RIGHT);

			for (Map rowdb : rows) {
				int colIndx = 1;

		 
 			Row = sheet1.createRow(rowIndx);
				int count = 1;
				cell = Row.createCell((short) count++);
				cell.setCellValue(checkData(String.valueOf(rowdb.get("mloname"))));
				cell.setCellStyle(cellStyle1);
				cell = Row.createCell((short) count++);
				cell.setCellValue(checkData(String.valueOf(rowdb.get("POL"))));
				cell.setCellStyle(cellStyle1);
				cell = Row.createCell((short) count++);
				cell.setCellValue(checkData(String.valueOf(rowdb.get("POD"))));
				cell.setCellStyle(cellStyle1);

				cell = Row.createCell((short) count++);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(checkDoubleData(String.valueOf(rowdb.get("xcl_d20"))));

				cell = Row.createCell((short) count++);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(checkDoubleData(String.valueOf(rowdb.get("xcl_d40"))));


				cell = Row.createCell((short) count++);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(checkDoubleData(String.valueOf(rowdb.get("xcl_m20"))));
				
				cell = Row.createCell((short) count++);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(checkDoubleData(String.valueOf(rowdb.get("xcl_m40"))));
				
				
				cell = Row.createCell((short) count++);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(checkDoubleData(String.valueOf(rowdb.get("ssf_d20"))));

				cell = Row.createCell((short) count++);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(checkDoubleData(String.valueOf(rowdb.get("ssf_d40"))));


				cell = Row.createCell((short) count++);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(checkDoubleData(String.valueOf(rowdb.get("ssf_m20"))));
				
				cell = Row.createCell((short) count++);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(checkDoubleData(String.valueOf(rowdb.get("ssf_m40"))));
				
				cell = Row.createCell((short) count++);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(checkDoubleData(String.valueOf(rowdb.get("oel_d20"))));

				cell = Row.createCell((short) count++);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(checkDoubleData(String.valueOf(rowdb.get("oel_d40"))));


				cell = Row.createCell((short) count++);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(checkDoubleData(String.valueOf(rowdb.get("oel_m20"))));
				
				cell = Row.createCell((short) count++);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(checkDoubleData(String.valueOf(rowdb.get("oel_m40"))));
				
				
				cell = Row.createCell((short) count++);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(checkDoubleData(String.valueOf(rowdb.get("xcl_d20")))+
						checkDoubleData(String.valueOf(rowdb.get("xcl_d40")))+
						checkDoubleData(String.valueOf(rowdb.get("xcl_m20")))+
						checkDoubleData(String.valueOf(rowdb.get("xcl_m40")))+
						checkDoubleData(String.valueOf(rowdb.get("ssf_d20")))+
						checkDoubleData(String.valueOf(rowdb.get("ssf_d40")))+
						checkDoubleData(String.valueOf(rowdb.get("ssf_m20")))+
						checkDoubleData(String.valueOf(rowdb.get("ssf_m40")))+
						checkDoubleData(String.valueOf(rowdb.get("oel_d20")))+
						checkDoubleData(String.valueOf(rowdb.get("oel_d40")))+
						checkDoubleData(String.valueOf(rowdb.get("oel_m20")))+
						checkDoubleData(String.valueOf(rowdb.get("oel_m40"))));
				
				String maxi=checkData(String.valueOf(rowdb.get("MAXI")));
				if(!maxi.isEmpty()){
					String[] a=maxi.split("-");
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[0]));

					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[1]));


					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[3]));
					
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[4]));
				}else{
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);

					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);


					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);
					
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);
				}
				String nyk=checkData(String.valueOf(rowdb.get("NYK")));
				if(!nyk.isEmpty()){
					String[] a=nyk.split("-");
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[0]));

					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[1]));


					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[3]));
					
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[4]));
				}else{
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);

					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);


					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);
					
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);
				}
				
				String oel=checkData(String.valueOf(rowdb.get("OEL")));
				if(!oel.isEmpty()){
					String[] a=oel.split("-");
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[0]));

					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[1]));


					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[3]));
					
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[4]));
				}else{
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);

					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);


					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);
					
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);
				}
				String oss=checkData(String.valueOf(rowdb.get("OSS")));
				if(!oss.isEmpty()){
					String[] a=oss.split("-");
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[0]));

					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[1]));


					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[3]));
					
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[4]));
				}else{
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);

					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);


					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);
					
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);
				}
				
				String sci=checkData(String.valueOf(rowdb.get("SCI")));
				if(!sci.isEmpty()){
					String[] a=sci.split("-");
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[0]));

					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[1]));


					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[3]));
					
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[4]));
				}else{
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);

					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);


					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);
					
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);
				}
				
				String sfpl=checkData(String.valueOf(rowdb.get("SFPL")));
				if(!sfpl.isEmpty()){
					String[] a=sfpl.split("-");
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[0]));

					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[1]));


					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[3]));
					
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[4]));
				}else{
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);

					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);


					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);
					
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);
				}
				
				String star=checkData(String.valueOf(rowdb.get("STAR")));
				if(!star.isEmpty()){
					String[] a=star.split("-");
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[0]));

					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[1]));


					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[3]));
					
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[4]));
				}else{
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);

					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);


					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);
					
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);
				}
				
				String xcl=checkData(String.valueOf(rowdb.get("XCL")));
				if(!xcl.isEmpty()){
					String[] a=xcl.split("-");
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[0]));
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[1]));
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[3]));
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(checkDoubleData(a[4]));
				}else{
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);					
					cell = Row.createCell((short) count++);
					cell.setCellStyle(cellStyle1);
					cell.setCellValue(0);
				}
			 
				cell = Row.createCell((short) count++);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(checkDoubleData(String.valueOf(rowdb.get("qm20rate"))));
				cell = Row.createCell((short) count++);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(checkDoubleData(String.valueOf(rowdb.get("qm40rate"))));
				cell = Row.createCell((short) count++);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(checkDoubleData(String.valueOf(rowdb.get("qd20rate"))));				
				cell = Row.createCell((short) count++);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(checkDoubleData(String.valueOf(rowdb.get("qd40rate"))));
				
				rowIndx++;

			}

			sheet1.setDefaultColumnWidth(20);

			FileOutputStream fileOut = new FileOutputStream(path + "/" + customerAnalysisBean.getFilename() + ".xls");

			wb.write(fileOut);
			fileOut.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	*/}

	private void createHeader(Sheet sheet1, Workbook wb) {

		// Or do it on one line.
		CellStyle style = wb.createCellStyle();

		org.apache.poi.ss.usermodel.Font font = wb.createFont();
		// font.setColor(HSSFColor.BLACK.index);
		font.setFontName("Arial");
		font.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short) 9);
		style.setAlignment(CellStyle.ALIGN_LEFT);
		// cellStyle.setFillBackgroundColor(HSSFColor.YELLOW.index);
		// cellStyle.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom((short) 1);
		style.setBorderTop((short) 1);
		style.setBorderRight((short) 1);
		style.setBorderLeft((short) 1);
		style.setFont(font);
		style.setFont(font);

		style.setFont(font);

		style.setFont(font);
		style.setWrapText(false);

		XSSFCellStyle style5 = (XSSFCellStyle) wb.createCellStyle();
		XSSFFont headerFont = (XSSFFont) wb.createFont();
		headerFont.setBold(true);
		style5.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style5.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		style5.setFont(headerFont);
		style5.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style5.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		style5.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		style5.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		style5.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);

		XSSFCellStyle style6 = (XSSFCellStyle) wb.createCellStyle();
		XSSFFont headerFont1 = (XSSFFont) wb.createFont();
		headerFont1.setBold(true);
		style6.setFillForegroundColor(IndexedColors.DARK_YELLOW.getIndex());
		style6.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		style6.setFont(headerFont1);
		style6.setWrapText(true);
		// styles.put("header", style5);

		int count = 1;
		Row row1 = sheet1.createRow(2);

		org.apache.poi.ss.usermodel.Cell cell = row1.createCell((short) 1);
		CellRangeAddress region = new CellRangeAddress(2, 5, 1, 1);
		cell.setCellStyle(style5);
		cell.setCellValue("CUSTOMER");
		sheet1.addMergedRegion(new CellRangeAddress(2, (short) 5, 1, (short) 1));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
	    region = new CellRangeAddress(2, 5, 2, 2);
		cell = row1.createCell((short) 2);
		cell.setCellStyle(style5);
		cell.setCellValue("POL");
		sheet1.addMergedRegion(new CellRangeAddress(2, (short) 5, 2, (short) 2));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);

		 region = new CellRangeAddress(2, 5, 3, 3);
		cell = row1.createCell((short) 3);
		cell.setCellStyle(style5);
		cell.setCellValue("POD");
		sheet1.addMergedRegion(new CellRangeAddress(2, (short) 5, 3, (short) 3));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);


		 region = new CellRangeAddress(2, 2, 4, 16);
		cell = row1.createCell((short) 4);
		cell.setCellStyle(style5);
		cell.setCellValue("LOADINGS");
		sheet1.addMergedRegion(new CellRangeAddress(2, (short) 2, 4, (short) 16));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		

		region = new CellRangeAddress(2, 2, 17, 48);
		cell = row1.createCell((short) 17);
		cell.setCellStyle(style5);
		cell.setCellValue("JV RATE");
		sheet1.addMergedRegion(new CellRangeAddress(2, (short) 2, 17, (short) 48));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		

		region = new CellRangeAddress(2, 2, 49, 52);
		cell = row1.createCell((short) 49);
		cell.setCellStyle(style5);
		cell.setCellValue("RATES ");
		sheet1.addMergedRegion(new CellRangeAddress(2, (short) 3, 49, (short) 52));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
 
		count = 1;
		row1 = sheet1.createRow(3);
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue(" ");

		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue(" ");

		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue(" ");

		region = new CellRangeAddress(3, 3, 4, 7);
		cell = row1.createCell((short) 4);
		cell.setCellStyle(style5);
		cell.setCellValue("XCL");
		sheet1.addMergedRegion(new CellRangeAddress(3, (short) 3, 4, (short) 7));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);

		region = new CellRangeAddress(3, 3, 8, 11);
		cell = row1.createCell((short) 8);
		cell.setCellStyle(style5);
		cell.setCellValue("SFPL");
		sheet1.addMergedRegion(new CellRangeAddress(3, (short) 3, 8, (short) 11));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);

		region = new CellRangeAddress(3, 3, 12, 15);
		cell = row1.createCell((short) 12);
		cell.setCellStyle(style5);
		cell.setCellValue("OEL");
		sheet1.addMergedRegion(new CellRangeAddress(3, (short) 3, 12, (short) 15));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);

		cell = row1.createCell((short) 16);
		cell.setCellStyle(style5);
		cell.setCellValue("TOTAL");
		
		region = new CellRangeAddress(3, 3, 17, 20);
		cell = row1.createCell((short) 17);
		cell.setCellStyle(style5);
		cell.setCellValue("MAXI");
		sheet1.addMergedRegion(new CellRangeAddress(3, (short) 3, 17, (short) 20));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		
		region = new CellRangeAddress(3, 3, 21, 24);
		cell = row1.createCell((short) 21);
		cell.setCellStyle(style5);
		cell.setCellValue("NYK");
		sheet1.addMergedRegion(new CellRangeAddress(3, (short) 3, 21, (short) 24));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		
		region = new CellRangeAddress(3, 3, 25, 28);
		cell = row1.createCell((short) 25);
		cell.setCellStyle(style5);
		cell.setCellValue("OEL");
		sheet1.addMergedRegion(new CellRangeAddress(3, (short) 3, 25, (short) 28));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		region = new CellRangeAddress(3, 3, 29, 32);
		cell = row1.createCell((short) 29);
		cell.setCellStyle(style5);
		cell.setCellValue("OSS");
		sheet1.addMergedRegion(new CellRangeAddress(3, (short) 3, 29, (short) 32));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		
		region = new CellRangeAddress(3, 3, 33, 36);
		cell = row1.createCell((short) 33);
		cell.setCellStyle(style5);
		cell.setCellValue("SCI");
		sheet1.addMergedRegion(new CellRangeAddress(3, (short) 3, 33, (short) 36));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		
		region = new CellRangeAddress(3, 3, 37, 40);
		cell = row1.createCell((short) 37);
		cell.setCellStyle(style5);
		cell.setCellValue("SFPL");
		sheet1.addMergedRegion(new CellRangeAddress(3, (short) 3, 37, (short) 40));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		

		region = new CellRangeAddress(3, 3, 41, 44);
		cell = row1.createCell((short) 41);
		cell.setCellStyle(style5);
		cell.setCellValue("STAR");
		sheet1.addMergedRegion(new CellRangeAddress(3, (short) 3, 41, (short) 44));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		

		region = new CellRangeAddress(3, 3, 45, 48);
		cell = row1.createCell((short) 45);
		cell.setCellStyle(style5);
		cell.setCellValue("XCL");
		sheet1.addMergedRegion(new CellRangeAddress(3, (short) 3, 45, (short) 48));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		
 


		count = 1;
		row1 = sheet1.createRow(4);
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue(" ");

		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue(" ");

		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue(" ");

		region = new CellRangeAddress(4, 4, 4, 5);
		cell = row1.createCell((short) 4);
		cell.setCellStyle(style5);
		cell.setCellValue("LADEN");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 4, (short) 5));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);

		region = new CellRangeAddress(4, 4, 6, 7);
		cell = row1.createCell((short) 6);
		cell.setCellStyle(style5);
		cell.setCellValue("EMPTY");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 6, (short) 7));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);

		region = new CellRangeAddress(4, 4, 8, 9);
		cell = row1.createCell((short) 8);
		cell.setCellStyle(style5);
		cell.setCellValue("LADEN");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 8, (short) 9));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);

		region = new CellRangeAddress(4, 4, 10, 11);
		cell = row1.createCell((short) 10);
		cell.setCellStyle(style5);
		cell.setCellValue("EMPTY");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 10, (short) 11));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);

		region = new CellRangeAddress(4, 4, 12, 13);
		cell = row1.createCell((short) 12);
		cell.setCellStyle(style5);
		cell.setCellValue("LADEN");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 12, (short) 13));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);

		region = new CellRangeAddress(4, 4, 14, 15);
		cell = row1.createCell((short) 14);
		cell.setCellStyle(style5);
		cell.setCellValue("EMPTY");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 14, (short) 15));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);

		cell = row1.createCell((short) 16);
		cell.setCellStyle(style5);
		cell.setCellValue(" ");
		
		
		region = new CellRangeAddress(4, 4, 17, 18);
		cell = row1.createCell((short) 17);
		cell.setCellStyle(style5);
		cell.setCellValue("LADEN");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 17, (short) 18));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		

		region = new CellRangeAddress(4, 4, 19, 20);
		cell = row1.createCell((short) 19);
		cell.setCellStyle(style5);
		cell.setCellValue("EMPTY");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 19, (short) 20));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		region = new CellRangeAddress(4, 4, 21, 22);
		cell = row1.createCell((short) 21);
		cell.setCellStyle(style5);
		cell.setCellValue("LADEN");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 21, (short) 22));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		
		region = new CellRangeAddress(4, 4, 23, 24);
		cell = row1.createCell((short) 23);
		cell.setCellStyle(style5);
		cell.setCellValue("EMPTY");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 23, (short) 24));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		
		region = new CellRangeAddress(4, 4, 25, 26);
		cell = row1.createCell((short) 25);
		cell.setCellStyle(style5);
		cell.setCellValue("LADEN");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 25, (short) 26));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		
		region = new CellRangeAddress(4, 4, 27, 28);
		cell = row1.createCell((short) 27);
		cell.setCellStyle(style5);
		cell.setCellValue("EMPTY");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 27, (short) 28));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		
		region = new CellRangeAddress(4, 4, 29, 30);
		cell = row1.createCell((short) 29);
		cell.setCellStyle(style5);
		cell.setCellValue("LADEN");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 29, (short) 30));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		region = new CellRangeAddress(4, 4, 31, 32);
		cell = row1.createCell((short) 31);
		cell.setCellStyle(style5);
		cell.setCellValue("EMPTY");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 31, (short) 32));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		
		region = new CellRangeAddress(4, 4, 33, 34);
		cell = row1.createCell((short) 33);
		cell.setCellStyle(style5);
		cell.setCellValue("LADEN");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 33, (short) 34));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		
		region = new CellRangeAddress(4, 4, 35, 36);
		cell = row1.createCell((short) 35);
		cell.setCellStyle(style5);
		cell.setCellValue("EMPTY");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 35, (short) 36));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		
		region = new CellRangeAddress(4, 4, 37, 38);
		cell = row1.createCell((short) 37);
		cell.setCellStyle(style5);
		cell.setCellValue("LADEN");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 37, (short) 38));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		
		region = new CellRangeAddress(4, 4, 37, 40);
		cell = row1.createCell((short) 39);
		cell.setCellStyle(style5);
		cell.setCellValue("EMPTY");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 39, (short) 40));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		
		region = new CellRangeAddress(4, 4, 41, 42);
		cell = row1.createCell((short) 41);
		cell.setCellStyle(style5);
		cell.setCellValue("LADEN");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 41, (short) 42));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		

		region = new CellRangeAddress(4, 4, 41, 44);
		cell = row1.createCell((short) 43);
		cell.setCellStyle(style5);
		cell.setCellValue("EMPTY");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 43, (short) 44));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		
		region = new CellRangeAddress(4, 4, 45, 46);
		cell = row1.createCell((short) 45);
		cell.setCellStyle(style5);
		cell.setCellValue("LADEN");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 45, (short) 46));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		

		region = new CellRangeAddress(4, 4, 47, 48);
		cell = row1.createCell((short) 47);
		cell.setCellStyle(style5);
		cell.setCellValue("EMPTY");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 47, (short) 48));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		
		region = new CellRangeAddress(4, 4, 49, 50);
		cell = row1.createCell((short) 49);
		cell.setCellStyle(style5);
		cell.setCellValue("LADEN");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 49, (short) 50));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		region = new CellRangeAddress(4, 4, 51, 52);
		cell = row1.createCell((short) 51);
		cell.setCellStyle(style5);
		cell.setCellValue("EMPTY");
		sheet1.addMergedRegion(new CellRangeAddress(4, (short) 4, 51, (short) 52));
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet1, wb);
		
		
		
		
		
		
		
		
		
		
		
		count = 1;
		row1 = sheet1.createRow(5);
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue(" ");

		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue(" ");

		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue(" ");

		 
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D40");		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M40");
	 
	 
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D40");		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M40");
	 

		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D40");		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M40");

	 

		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue(" ");
		
		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D40");		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M40");

		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D40");		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M40");
		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D40");		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M40");
		
		  
		
		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D40");		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M40");
		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D40");		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M40");
		
		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D40");		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M40");
		
		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D40");		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M40");
		
		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D40");		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M40");
		
		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("D40");		
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M20");
		cell = row1.createCell((short) count++);
		cell.setCellStyle(style5);
		cell.setCellValue("M40");
		
		
	 


	}

	public String checkData(String value) {
		try {
			value = value == null || value.isEmpty() || value.equals("null") ? "" : value;
		} catch (Exception e) {
			value = "";
		}

		return value;
	}

	public double checkDoubleData(String value) {
		double result = 0.0;
		try {

			result = value.trim() == null || value.trim().equals("null") || value.trim().isEmpty() ? 0.0 : Double.parseDouble(value);
		} catch (Exception e) {

			return Double.parseDouble("0.0");
		}

		return result;
	}
}
