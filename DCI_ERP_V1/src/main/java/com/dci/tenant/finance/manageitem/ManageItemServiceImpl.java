package com.dci.tenant.finance.manageitem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.dci.tenant.user.UserDetail;

@Service
public class ManageItemServiceImpl implements ManageItemService {

	@Autowired
	ManageItemDAO objManageItemDAO;

	@Autowired
	DataSource dataSource;

	@Override
	public List getItemCtaegoryList() {
		// TODO Auto-generated method stub
		return objManageItemDAO.getItemCtaegoryList();
	}

	@Override
	public List getUOmList() {
		// TODO Auto-generated method stub
		return objManageItemDAO.getUOmList();
	}

	@Override
	public List getEntityList() {
		// TODO Auto-generated method stub
		return objManageItemDAO.getEntityList();
	}

	@Override
	public boolean insertManageItemDetails(ManageItemBean objManageItem) {
		// TODO Auto-generated method stub
		return objManageItemDAO.insertManageItemDetails(objManageItem);
	}

	@Override
	public ManageItemResultBean getManageItemList() {
		// TODO Auto-generated method stub
		return objManageItemDAO.getManageItemList();
	}

	@Override
	public boolean deleteItemDetails(String itemId) {
		// TODO Auto-generated method stub
		return objManageItemDAO.deleteItemDetails(itemId);
	}

	@Override
	public ManageItemResultBean getEditManageItem(String itemCode) {
		// TODO Auto-generated method stub
		return objManageItemDAO.getEditManageItem(itemCode);
	}

	@Override
	public boolean updateManageItemDetails(ManageItemBean objManageItem) {
		// TODO Auto-generated method stub
		return objManageItemDAO.updateManageItemDetails(objManageItem);
	}

	@Override
	public ManageItemResultBean getAttributeDetails(int itemCategoryId) throws Exception {
		// TODO Auto-generated method stub
		return objManageItemDAO.getAttributeDetails(itemCategoryId);
	}

	@Override
	public int checkItemName(String itemName) {
		return objManageItemDAO.checkItemName(itemName);
	}

	@Override
	public ArrayList<ManageItemBean> getGrnAttributeDetails(int itemCategoryId) {
		// TODO Auto-generated method stub
		return objManageItemDAO.getGrnAttributeDetails(itemCategoryId);
	}

	@Override
	public ManageItemResultBean getItemConsumptionMasterList(String itm, int rdoDays) {
		// TODO Auto-generated method stub
		return objManageItemDAO.getItemConsumptionMasterList(itm, rdoDays);
	}

	@Override
	public ManageItemResultBean getUOMCategoryBasedList(int uomId) throws Exception {
		// TODO Auto-generated method stub
		return objManageItemDAO.getUOMCategoryBasedList(uomId);
	}

	@Override
	public int checkItemCode(String checkItemCode) throws Exception {
		return objManageItemDAO.checkItemCode(checkItemCode);
	}

	/*
	 * @Override public boolean exportDPIdetailReport(String exportFilesPath,
	 * ManageItemBean objChqDepCollecBean) { // TODO Auto-generated method stub
	 * return false; }
	 */

	@Override
	public boolean exportManageItemReport(String filePath, ManageItemBean ManageItemBean) {

		// List<ManageItemResultBean> lCDCList;
		List<ManageItemBean> lCDCList = new ArrayList();
		try {

			/*
			 * if (ManageItemBean.getFromdate() != "" &&
			 * ManageItemBean.getTodate() != "") { lCDCList =
			 * ManageItemDAO.DPIlist1(ManageItemBean.getFromdate(),
			 * ManageItemBean.getTodate()); } else {
			 */
			// List<ManageItemBean> lCDCList =
			// objManageItemDAO.getManageItemList();

			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			ManageItemResultBean objbean = new ManageItemResultBean();
			// try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCDCList = jdbcTemplate.query(ManageItemQueryTable.sGetManageItemList1, new BeanPropertyRowMapper<ManageItemBean>(ManageItemBean.class), userDetails.getCompanyCode());
			// objbean.setItemList(alResult);

			// } catch (DataAccessException e) {
			// e.printStackTrace();
			// }
			// return objbean;

		} catch (Exception e) {
			e.printStackTrace();
		}

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

			HSSFCellStyle my_style_green = workbook.createCellStyle();
			my_style_green.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style_green.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style_green.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style_green.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style_green.setAlignment(my_style.ALIGN_LEFT);

			Font font_green = workbook.createFont();
			font_green.setColor(HSSFColor.GREEN.index);
			font_green.setBoldweight(Font.BOLDWEIGHT_BOLD);
			my_style_green.setFont(font_green);

			HSSFCellStyle my_style_green_right_align = workbook.createCellStyle();
			my_style_green_right_align.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style_green_right_align.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style_green_right_align.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style_green_right_align.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style_green_right_align.setAlignment(my_style.ALIGN_CENTER);
			my_style_green_right_align.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));
			font_green.setColor(HSSFColor.GREEN.index);
			font_green.setBoldweight(Font.BOLDWEIGHT_BOLD);
			my_style_green_right_align.setFont(font_green);

			HSSFCellStyle my_style_red = workbook.createCellStyle();
			my_style_red.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style_red.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style_red.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style_red.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style_red.setAlignment(my_style.ALIGN_LEFT);

			HSSFCellStyle my_style4 = workbook.createCellStyle();
			my_style4.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style4.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style4.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style4.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style4.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			my_style4.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style4.setFillForegroundColor(HSSFColor.YELLOW.index);
			my_style4.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style4.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));

			Font font2 = workbook.createFont();
			font2.setFontHeight((short) 200);
			font2.setFontName("Arial");
			font2.setColor(HSSFColor.BLACK.index);
			font2.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font2.setFontHeightInPoints((short) 10);
			my_style4.setFont(font2);

			Font font_red = workbook.createFont();
			font_red.setColor(HSSFColor.RED.index);
			font_red.setBoldweight(Font.BOLDWEIGHT_BOLD);
			my_style_red.setFont(font_red);

			HSSFCellStyle my_style_red_right_align = workbook.createCellStyle();
			my_style_red_right_align.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style_red_right_align.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style_red_right_align.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style_red_right_align.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style_red_right_align.setAlignment(my_style.ALIGN_CENTER);
			my_style_red_right_align.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));
			font_red.setColor(HSSFColor.RED.index);
			font_red.setBoldweight(Font.BOLDWEIGHT_BOLD);
			my_style_red_right_align.setFont(font_red);

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
			my_style2.setAlignment(HSSFCellStyle.ALIGN_LEFT);

			HSSFCellStyle my_styleExcess = workbook.createCellStyle();
			my_styleExcess.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_styleExcess.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_styleExcess.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_styleExcess.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_styleExcess.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			my_styleExcess.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));

			HSSFCellStyle my_styleremarks = workbook.createCellStyle();
			my_styleremarks.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_styleremarks.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_styleremarks.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_styleremarks.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_styleremarks.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			my_styleremarks.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));

			// Create a blank sheet
			HSSFSheet excelSheet = workbook.createSheet("MANAGE ITEM");

			// set main header
			setExcelMainHeader(excelSheet, my_style);

			// set header
			setExcelHeader(excelSheet, my_style1);

			// set Data
			setExcelRows(excelSheet, lCDCList, my_style4, my_style1, my_style2, my_styleExcess, my_style3, my_style_green, my_style_red, my_style_green_right_align, my_style_red_right_align);

			for (int i = 0; i < 7; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// export excell
			String sFileUrl = writeExcel(workbook, filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	private void setExcelMainHeader(HSSFSheet excelSheet, HSSFCellStyle my_style) {
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 5));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("MANAGE ITEM");
		cell.setCellStyle(my_style);
	}

	private void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow((short) 2);
			row.setHeight((short) 350);

			/*
			 * Cell cell0 = row.createCell(0); cell0.setCellStyle(my_style1);
			 * cell0.setCellValue("Sl #");
			 */

			Cell cell1 = row.createCell(0);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Item Code");

			Cell cell2 = row.createCell(1);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Item Name");

			Cell cell3 = row.createCell(2);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Item Description");

			Cell cell4 = row.createCell(3);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Item Type");

			Cell cell5 = row.createCell(4);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Item Category");

			Cell cell6 = row.createCell(5);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("uom");

			/*
			 * Cell cell7 = row.createCell(6); cell7.setCellStyle(my_style1);
			 * cell7.setCellValue("Phone");
			 * 
			 * 
			 * Cell cell8 = row.createCell(7); cell8.setCellStyle(my_style1);
			 * cell8.setCellValue("0-15 Days");
			 * 
			 * Cell cell9 = row.createCell(8); cell9.setCellStyle(my_style1);
			 * cell9.setCellValue("16-30 Days");
			 * 
			 * Cell cell10 = row.createCell(9); cell10.setCellStyle(my_style1);
			 * cell10.setCellValue("31-45 Days");
			 * 
			 * Cell cell11 = row.createCell(10); cell11.setCellStyle(my_style1);
			 * cell11.setCellValue("46-60 Days");
			 * 
			 * Cell cell12 = row.createCell(11); cell12.setCellStyle(my_style1);
			 * cell12.setCellValue("Above 60 Days");
			 * 
			 * Cell cell13 = row.createCell(12); cell13.setCellStyle(my_style1);
			 * cell13.setCellValue("Country");
			 * 
			 * Cell cell14 = row.createCell(13); cell14.setCellStyle(my_style1);
			 * cell14.setCellValue("Remarks");
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setExcelRows(HSSFSheet excelSheet, List<ManageItemBean> lCDCList, HSSFCellStyle my_style4, HSSFCellStyle my_style1, HSSFCellStyle my_style2, HSSFCellStyle my_styleExcess, HSSFCellStyle my_style3, HSSFCellStyle my_style_green, HSSFCellStyle my_style_red, HSSFCellStyle my_style_green_right_align, HSSFCellStyle my_style_red_right_align) {
		int record = 3, sno = 1;
		int countpr;
		double dTotal = 0.0, d15 = 0.0;
		double d30 = 0.0, d45 = 0.0;
		double d60 = 0.0, dabove60 = 0.0;
		String prId = "";
		try {
			List<ManageItemBean> objChqDepoCollecBean = lCDCList;
			for (int j = 0; j < lCDCList.size(); j++) {
				Row row = excelSheet.createRow((short) record++);
				row.setHeight((short) 350);
				for (int i = 0; i < 7; i++) {
					excelSheet.autoSizeColumn(7);
				}

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style2);
				cell0.setCellValue(lCDCList.get(j).getItemCode());

				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style2);
				// Cell cell2 = row.createCell(1);
				// cell2.setCellStyle(my_style2);

				cell1.setCellValue(lCDCList.get(j).getItemName());

				Cell cell2 = row.createCell(2);
				cell2.setCellStyle(my_style2);
				cell2.setCellValue(lCDCList.get(j).getItemDescription());

				Cell cell3 = row.createCell(3);
				cell3.setCellStyle(my_style2);
				// Double creditlimit =
				// jdbcTemplate.queryForObject(ChequeDepositCollectionQueryUtil.
				// GET_CREDIT_AMOUNT, new Object[] {
				// objChqDepoCollecBean.get(j).getPayerCode() }, Double.class);
				cell3.setCellValue(lCDCList.get(j).getItemType());

				// double balance = objChqDepoCollecBean.get(j).getBalance();
				// double balancepdcamnt =
				// objChqDepoCollecBean.get(j).getPdcamount(); double
				// payerCreditLimit =
				// objChqDepoCollecBean.get(j).getPayerCreditLimit(); double
				// excessamount = balance - (balancepdcamnt + payerCreditLimit);
				// objChqDepoCollecBean.get(j).setExcessAmount(excessamount);
				Cell cell4 = row.createCell(4);
				cell4.setCellStyle(my_style3);
				cell4.setCellValue(lCDCList.get(j).getItemCategory());

				Cell cell5 = row.createCell(5);
				cell5.setCellStyle(my_style3);
				cell5.setCellValue(lCDCList.get(j).getUom());

				/*
				 * Cell cell6 = row.createCell(6);
				 * cell6.setCellStyle(my_style3);
				 * cell6.setCellValue(lCDCList.get
				 * (j).getDesijgnatedMobileNo1());
				 */}

			// Create total row
			/*
			 * Row rowTotal = excelSheet.createRow(record++);
			 * rowTotal.setHeight((short) 350);
			 * 
			 * rowTotal.createCell(0).setCellStyle(my_style4);
			 * rowTotal.createCell(1).setCellStyle(my_style4);
			 * rowTotal.createCell(2).setCellStyle(my_style4);
			 * rowTotal.createCell(3).setCellStyle(my_style4);
			 * rowTotal.createCell(4).setCellStyle(my_style4);
			 * rowTotal.createCell(5).setCellStyle(my_style4);
			 * rowTotal.createCell(6).setCellStyle(my_style4); //
			 * rowTotal.createCell(7).setCellStyle(my_style4); //
			 * rowTotal.createCell(8).setCellStyle(my_style4); //
			 * rowTotal.createCell(9).setCellStyle(my_style4); //
			 * rowTotal.createCell(10).setCellStyle(my_style4); //
			 * rowTotal.createCell(11).setCellStyle(my_style4); //
			 * rowTotal.createCell(12).setCellStyle(my_style4); //
			 * rowTotal.createCell(13).setCellStyle(my_style4);
			 * 
			 * Cell cellah1 = rowTotal.createCell(1);
			 * cellah1.setCellStyle(my_style4); cellah1.setCellValue("Total");
			 * 
			 * Cell cellahTcdbt13 = rowTotal.createCell(6);
			 * cellahTcdbt13.setCellStyle(my_style4);
			 * cellahTcdbt13.setCellValue(dTotal);
			 * 
			 * Cell cellahBcdbt14 = rowTotal.createCell(7);
			 * cellahBcdbt14.setCellStyle(my_style4);
			 * cellahBcdbt14.setCellValue(d15);
			 * 
			 * Cell cellahTcCrdt15 = rowTotal.createCell(8);
			 * cellahTcCrdt15.setCellStyle(my_style4);
			 * cellahTcCrdt15.setCellValue(d30);
			 * 
			 * Cell cellahBcCrdt16 = rowTotal.createCell(9);
			 * cellahBcCrdt16.setCellStyle(my_style4);
			 * cellahBcCrdt16.setCellValue(d45);
			 * 
			 * Cell cellahBcCrdt17 = rowTotal.createCell(10);
			 * cellahBcCrdt17.setCellStyle(my_style4);
			 * cellahBcCrdt17.setCellValue(d60);
			 * 
			 * Cell cellahBcCrdt18 = rowTotal.createCell(11);
			 * cellahBcCrdt18.setCellStyle(my_style4);
			 * cellahBcCrdt18.setCellValue(dabove60);
			 * 
			 * rowTotal.createCell(12).setCellStyle(my_style4);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcel(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/Manageitemdetail.xls";

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		System.out.println("filePath" + sOutFile);
		try {
			fileOut = new FileOutputStream(sOutFile);
			myWorkBook.write(fileOut);
			url = path + "/Manageitemdetail.xls";
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

}
