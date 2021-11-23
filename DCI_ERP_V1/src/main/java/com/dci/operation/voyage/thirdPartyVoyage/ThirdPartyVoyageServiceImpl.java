package com.dci.operation.voyage.thirdPartyVoyage;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CommonExcelUtils;
import com.dci.tenant.common.Email;
import com.dci.tenant.common.MailUtility;
import com.dci.tenant.user.UserDetail;

 
@Service
public class ThirdPartyVoyageServiceImpl implements ThirtyPartyVoyageService {

	@Autowired
	ThirdPartyVoyageDAO thirdPartyVoyageDAO;
	
	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<ThirdPartyVoyageBean> getVoyageList(ThirdPartyVoyageBean thirdPartyVoyageBean) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return thirdPartyVoyageDAO.getVoyageList(thirdPartyVoyageBean, userDetails.getUserId());
	}

	@Override
	public List<ThirdPartyVoyageBean> getThirdPartyVoyageList(ThirdPartyVoyageBean thirdPartyVoyageBean, String formCode) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return thirdPartyVoyageDAO.getThirdPartyVoyageList(thirdPartyVoyageBean, formCode, userDetails.getUserId());
	}

	@Override
	public List<ThirdPartyVoyageBean> getVesselList(String formCode) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return thirdPartyVoyageDAO.getVesselList(formCode, userDetails.getUserId());
	}

	@Override
	public List<ThirdPartyVoyageBean> getActivityTypes() throws Exception {
		return thirdPartyVoyageDAO.getActivityTypes();
	}

	@Override
	public List<ThirdPartyVoyageBean> getServiceList(ThirdPartyVoyageBean ThirdPartyVoyageBean, String companyCode) throws Exception {
		return thirdPartyVoyageDAO.getServiceList(ThirdPartyVoyageBean, companyCode);
	}

	@Override
	public List<ThirdPartyVoyagePortBean> getPortList(ThirdPartyVoyageBean ThirdPartyVoyageBean) throws Exception {
		return thirdPartyVoyageDAO.getPortList(ThirdPartyVoyageBean);
	}

	@Override
	public List<ThirdPartyVoyagePortBean> getVoyageDtlList(ThirdPartyVoyageBean ThirdPartyVoyageBean, List<ThirdPartyVoyagePortBean> portList)
			throws Exception {
		return thirdPartyVoyageDAO.getVoyageDtlList(ThirdPartyVoyageBean, portList);
	}

	@Override
	public String getDistance(String fromPort, String toPort) throws Exception {
		return thirdPartyVoyageDAO.getDistance(fromPort, toPort);
	}

	@Override
	public String saveThirdPartyVoyage(ThirdPartyVoyageResultBean ThirdPartyVoyageResultBean) {
		return thirdPartyVoyageDAO.saveThirdPartyVoyage(ThirdPartyVoyageResultBean);
	}

	@Override
	public List<ThirdPartyVoyageBean> getEditVoyageHeader(ThirdPartyVoyageBean ThirdPartyVoyageBean) throws Exception {
		return thirdPartyVoyageDAO.getEditVoyageHeader(ThirdPartyVoyageBean);
	}

	@Override
	public List<ThirdPartyVoyagePortBean> getEditVoyageDtlList(ThirdPartyVoyageBean ThirdPartyVoyageBean) throws Exception {
		return thirdPartyVoyageDAO.getEditVoyageDtlList(ThirdPartyVoyageBean);
	}

	@Override
	public ThirdPartyVoyageResultBean updateThirdPartyVoyage(ThirdPartyVoyageResultBean ThirdPartyVoyageResultBean) {
		return thirdPartyVoyageDAO.updateThirdPartyVoyage(ThirdPartyVoyageResultBean);
	}

	@Override
	public boolean deleteThirdPartyVoyage(String voyageId) {
		return thirdPartyVoyageDAO.deleteThirdPartyVoyage(voyageId);
	}

	@Override
	public List<ThirdPartyVoyageBean> getMloList(String voyageID) throws Exception {
		if(CommonExcelUtils.checkEmptyString(voyageID).equals("")){
			return thirdPartyVoyageDAO.getMloList();
		}else{
			return thirdPartyVoyageDAO.getMloList(voyageID);	
		}
	}

	@Override
	public boolean checkServiceExist(ThirdPartyVoyageBean partyVoyageBean, String companyCode) {
		// TODO Auto-generated method stub
		return thirdPartyVoyageDAO.checkServiceExist(partyVoyageBean, companyCode);
	}

	@Override
	public String getLocationOfService(String serviceId) {
		// TODO Auto-generated method stub
		return thirdPartyVoyageDAO.getLocationOfService(serviceId);
	}

	@Override
	public boolean sendMail(ThirdPartyVoyageResultBean resultBean) {
		boolean result = false;
		try {

			Email email = new Email();
			String[] tempToEmailId = new String[] { ""};
			//String[] tempToEmailId = new String[] { "sundar90mdu@gmail.com","sundarrajan@paragondynamics.in" };
			StringBuffer sb = new StringBuffer();
			String path = "";
			String[] ccEmailAddress = new String[]{"support@globalfeeders.com"};
			//String[] ccEmailAddress = new String[]{"sundar90mdu@gmail.com"};
			sb.append("<html><body>");
			sb.append("<div>Dear All,</div><br>");
			sb.append("<div style=\"width:100%;color:red;\">" + resultBean.getMessage() + "</div></body></html>");
			email.setBodyHtml(sb.toString());
			email.setFromEmailAddress("feedertech@globalfeeders.com");
			email.setToEmailAddress(tempToEmailId);
			email.setBccEmailAddress(ccEmailAddress);
			email.setSubject("Third Party [VSL- " + resultBean.getThirtyPartyVoyageHeader().getVesselName() + " and Voyage- "
					+ resultBean.getThirtyPartyVoyageHeader().getVoyageId() + "]");
			MailUtility.sendMail(email, "");
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ThirdPartyVoyageResultBean checkPurchaseQuotValid(ThirdPartyVoyageResultBean thirdPartyVoyageResultBean) {
		// TODO Auto-generated method stub
		return thirdPartyVoyageDAO.checkPurchaseQuotValid(thirdPartyVoyageResultBean);
	}

	@Override
	public boolean checkValidationDate(String voyageId) {
		// TODO Auto-generated method stub
		return thirdPartyVoyageDAO.checkValidationDate(voyageId);
	}

	@Override
	public boolean sendMailForPurchaseQuote(ThirdPartyVoyageResultBean resultBean) {
		boolean result = false;
		try {

			Email email = new Email();
			String[] tempToEmailId = new String[] { "paragondynamicsfeeders@gmail.com" };
			StringBuffer sb = new StringBuffer();
			String path = "";
			//String[] ccEmailAddress = new String[]{"sundar90mdu@gmail.com"};
			sb.append("<html><body>");
			sb.append("<div>Dear All,</div><br>");
			sb.append("<div style=\"width:100%;color:blue;\">" + resultBean.getPurchaseQuotMailMsg() + "</div></body></html>");
			email.setBodyHtml(sb.toString());
			email.setFromEmailAddress("feedertech@globalfeeders.com");
			email.setToEmailAddress(tempToEmailId);
			//email.setCcEmailAddress(ccEmailAddress);
			email.setSubject("Purchase Quote [VSL- " + resultBean.getThirtyPartyVoyageHeader().getVesselName() + " and Voyage- "
					+ resultBean.getThirtyPartyVoyageHeader().getVoyageId() + "]");
			MailUtility.sendMail(email, "");
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getCompanyOfService(ThirdPartyVoyageBean thirtyPartyVoyageHeader) {
		// TODO Auto-generated method stub
		return thirdPartyVoyageDAO.getCompanyOfService(thirtyPartyVoyageHeader);
	}

	@Override
	public List<ThirdPartyVoyageBean> getVesselListWithOutOwnParty(String formCode) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return thirdPartyVoyageDAO.getVesselListWithOutOwnParty(formCode, userDetails.getUserId());
	}
	
	@Override
	public List<ThirdPartyVoyageBean> getVesselListWithOutOwnParty1(String formCode) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return thirdPartyVoyageDAO.getVesselListWithOutOwnParty(formCode, userDetails.getUserId());
	}

	@Override
	public List<ThirdPartyVoyageBean> geList(ThirdPartyVoyageBean thirdPartyVoyageBean) throws Exception {
		// TODO Auto-generated method stub
		return thirdPartyVoyageDAO.geList(thirdPartyVoyageBean);
	}

	@Override
	public boolean excellExport(ThirdPartyVoyageResultBean ThirdPartyVoyageBean, String pdfFile) throws Exception {
		// TODO Auto-generated method stub
		
 		
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
// font.setBoldweight(Font.BOLDWEIGHT_BOLD);
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
// font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
font1.setFontHeightInPoints((short) 10);
my_style1.setFont(font1);
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
my_style3.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
// Create a blank sheet
HSSFSheet excelSheet = workbook.createSheet("BL Issued Report");
//



// set main header
setExcelMainHeader(excelSheet, my_style);

//InputStream inputStream = new FileInputStream("/img/"+"Cordelia_resize_logo.jpg");
//		   "/webapp/img/Cordelia_resize_logo.jpg");

//Get the contents of an InputStream as a byte[].
//byte[] bytes = IOUtils.toByteArray(inputStream);	
//Adds a picture to the workbook
//int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
//close the input stream
//inputStream.close();
//Returns an object that handles instantiating concrete classes
CreationHelper helper = workbook.getCreationHelper();
//Creates the top-level drawing patriarch.
HSSFPatriarch drawing = excelSheet.createDrawingPatriarch();

//Create an anchor that is attached to the worksheet
ClientAnchor anchor = helper.createClientAnchor();

//create an anchor with upper left cell _and_ bottom right cell
anchor.setCol1(0); //Column B
anchor.setRow1(excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0,3))); //Row 3
anchor.setCol2(2); //Column C
anchor.setRow2(4); //Row 4

//Creates a picture
//Picture pict = drawing.createPicture(anchor, pictureIdx);

//Reset the image to the original size
//pict.resize(); //don't do that. Let the anchor resize the image!

//Create the Cell B3
Cell cell = excelSheet.createRow(2).createCell(0);

Date date = new Date();
String todayDate = date.toString();
System.out.println("date :"+todayDate);
Cell cell1 = excelSheet.createRow(2).createCell(3);
cell1.setCellValue("Exported Date :" + todayDate);
//cell1.setCellStyle(my_style1);
//Row row = excelSheet.createRow((short) 1);
//Cell cell0 = row.createCell(2);
//cell0.setCellStyle(my_style1);
//cell0.setCellValue("Exported Date :" + todayDate);


//// 
// set header
setExcelHeader(excelSheet, my_style1);

// set Data
setExcelRows(excelSheet,ThirdPartyVoyageBean, my_style1, my_style2, my_style3);


// image insert 
	
		

	
	
	
	

for (int i = 0; i < 7; i++) {
excelSheet.autoSizeColumn(i);
}

// export excell
String filename = writeExcel(workbook, pdfFile);

} catch (Exception e) {
e.printStackTrace();
} finally {

}
		return true;

		
		
	}


	public void setExcelMainHeader(HSSFSheet excelSheet, HSSFCellStyle my_style) {
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 7));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("SAILING SCHEDULE");
		cell.setCellStyle(my_style);
	}
	
	 
	
	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {


		try {

			
		Row row = excelSheet.createRow((short) 4);
		row.setHeight((short) 350);

		Cell cell0 = row.createCell(0);
		cell0.setCellStyle(my_style1);
		cell0.setCellValue("VESSEL");
		
		
		Cell cell1 = row.createCell(1);
		cell1.setCellStyle(my_style1);
		cell1.setCellValue("VOYAGE");
		
		Cell cell2 = row.createCell(2);
		cell2.setCellStyle(my_style1);
		cell2.setCellValue("PORT");

		Cell cell3 = row.createCell(3);
		cell3.setCellStyle(my_style1);
		cell3.setCellValue("ACTUAL ETA/ARRIVED");
		
		Cell cell4 = row.createCell(4);
		cell4.setCellStyle(my_style1);
		cell4.setCellValue("ETB/BERTHED");

		Cell cell5 = row.createCell(5);
		cell5.setCellStyle(my_style1);
		cell5.setCellValue("ETA/SAILED");

		Cell cell6 = row.createCell(6);
		cell6.setCellStyle(my_style1);
		cell6.setCellValue("ROT NO");

		Cell cell7 = row.createCell(7);
		cell7.setCellStyle(my_style1);
		cell7.setCellValue("REMARKS");

	 
		


		} catch (Exception e) {
		e.printStackTrace();
		}
			}

	
	private void setExcelRows(HSSFSheet excelSheet, ThirdPartyVoyageResultBean ThirdPartyVoyageBean, HSSFCellStyle my_style1,
			HSSFCellStyle my_style2, HSSFCellStyle my_style3) {
		int record = 5, sno = 1;
		String code = "null";
		String vessel = "null";
		int i = 2;
		int j = 2;
		int k = 3;
		int oldcount =5;
		try {
			
			int serial = 1;
		for (ThirdPartyVoyageBean Bean : ThirdPartyVoyageBean.getSearchList()) {
		Row row = excelSheet.createRow((short) record++);
		row.setHeight((short) 350);
		 
		
//		Cell cell0 = row.createCell(0);
//		cell0.setCellStyle(my_style2);
//		cell0.setCellValue(sno++);
		
		Cell cell0 = row.createCell(0);
		cell0.setCellStyle(my_style2);
		cell0.setCellValue(Bean.getVesselCode());
//		JdbcTemplate JdbcTemplate = new JdbcTemplate();
//		if(vessel.equalsIgnoreCase(Bean.getVesselCode())) {
//			int vesselCount  = jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.GET_VESSEL_COUNT,Integer.class,Bean.getVesselCode());
////			i++;
////			i = record;
//			
////			i = oldcount+i;
//			CellRangeAddress cellRangeAddress = new CellRangeAddress(oldcount, vesselCount+3,0, 0);
//			 oldcount = +vesselCount;
//			vessel = Bean.getVesselCode();
//			excelSheet.addMergedRegion(cellRangeAddress);
//		
//		}
		vessel = Bean.getVesselCode();
		
		Cell cell1 = row.createCell(1);
		cell1.setCellStyle(my_style2);
		cell1.setCellValue(Bean.getVoyageId());
	
//		if(code.equalsIgnoreCase(Bean.getVoyageId())) {
//			int veoyageCount  = jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.GET_VOYAGE_COUNT,Integer.class,Bean.getVoyageId());
//
////			j++;
//			CellRangeAddress cellRangeAddress = new CellRangeAddress(j, veoyageCount+3,1, 1);
//			code = Bean.getVoyageId();
//			excelSheet.addMergedRegion(cellRangeAddress);
//		
//		}
		code = Bean.getVoyageId();
		// Merge the selected cells.

		Cell cell2 = row.createCell(2); 
		cell2.setCellStyle(my_style2);
		cell2.setCellValue(Bean.getFromPort());
		
		Cell cell5 = row.createCell(3);
		cell5.setCellStyle(my_style2);
		cell5.setCellValue(Bean.getEta());

		Cell cell3 = row.createCell(4);
		cell3.setCellStyle(my_style2);
		cell3.setCellValue(Bean.getEtb());

		Cell cell4 = row.createCell(5);
		cell4.setCellStyle(my_style2);
		cell4.setCellValue(Bean.getEtd());

		Cell celll5 = row.createCell(6);
		celll5.setCellStyle(my_style2);
		celll5.setCellValue(Bean.getRotationId());


		Cell cell6 = row.createCell(7);
		cell6.setCellStyle(my_style2);
		cell6.setCellValue(Bean.getRemarks());


		}} catch (Exception e) {
		e.printStackTrace();
		}
		}
	
	 
	 
	private String writeExcel(HSSFWorkbook workbook, String pdfFile) {

		 
			String l_str_file_out = pdfFile +"/"+ "Sailing Schedule.xls";
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
			return "BLissuedReport.xls";
		}
	

	@Override
	public List<ThirdPartyVoyageBean> searchfindshed(ThirdPartyVoyageBean searchBean) {
	
		return thirdPartyVoyageDAO.searchfindshed(searchBean);
	}
	
	

	@Override
	public ThirdPartyVoyageResultBean uploadFile(MultipartFile file) {

		ThirdPartyVoyageResultBean resultbean = new ThirdPartyVoyageResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<String> errorList = new ArrayList<>();
		ThirdPartyVoyageResultBean resultBean = null;
		List<ThirdPartyVoyageResultBean> ThirdPartyVoyageResultBean = new ArrayList<>();
		// List<EmptyRepositioningBean> membersList = new ArrayList<>();
		ThirdPartyVoyageBean HeaderBean = null;
		List<ThirdPartyVoyagePortBean> detailBeanList = null;
		// List<EmptyRepositioningBean> errorMembersList = new ArrayList<>();
		UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		boolean isSuccess = false;
		String fileName = file.getOriginalFilename();
		Iterator<Row> rowIterator = null;
		Workbook workbook = null;
		int memberType = 0;
		String userFlag = "e";
		int i = 0;
		boolean errorFlag = false;
		String error = "";
		try {
			org.apache.poi.ss.usermodel.Workbook wb_xssf; // Declare XSSF
			org.apache.poi.ss.usermodel.Workbook wb_hssf; // Declare HSSF
			int j = 0;
			int sheetCount = 0;
			Sheet sheet = null;
			if (fileName.endsWith("xls")) {
				/*
				 * workbook = new HSSFWorkbook(file.getInputStream()); HSSFSheet sheet1 =
				 * (HSSFSheet) workbook.getSheetAt(0);
				 */

				POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
				wb_hssf = new HSSFWorkbook(fs);
				sheetCount = workbook.getNumberOfSheets();
				System.out.println("Sheetcount :" + sheetCount);
				sheet = wb_hssf.getSheetAt(0);
				rowIterator = sheet.rowIterator();
				j = 1;
			} else if (fileName.endsWith("xlsx")) {

				workbook = new XSSFWorkbook(file.getInputStream());
				sheetCount = workbook.getNumberOfSheets();
				System.out.println("Sheetcount :" + sheetCount);

				j = 1;

			} else {
				System.out.println("Not a valid file format");
			}
			DataFormatter dataFormatter = new DataFormatter();
			int no = 0;

			for (no = 0; no < sheetCount; no++) {
				XSSFSheet sheet1 = (XSSFSheet) workbook.getSheetAt(no);
				rowIterator = sheet1.rowIterator();
				int rowCnt = 0;
				detailBeanList = new ArrayList<>();
				resultBean = new ThirdPartyVoyageResultBean();
				HeaderBean = new ThirdPartyVoyageBean();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					rowCnt += 1;
					if (rowCnt > j) {
						boolean customFlag = false;
						Iterator<Cell> cellIterator = row.cellIterator();
						ThirdPartyVoyagePortBean detailBean = new ThirdPartyVoyagePortBean();

						// }
						if (rowCnt == 2) {
							Cell vesselCode = row.getCell(2);
							if (vesselCode == null || vesselCode.getCellType() == Cell.CELL_TYPE_BLANK) {
								error = error + "\n" + "Sheet No " + (no + 1) + " " + "Row" + (rowCnt +1)
										+ " vessel Code should not be empty";
								System.out.println(error);
								throw new Exception(error);

							} else {
								boolean success = getVesselCodeCount(vesselCode.getStringCellValue());
								if (success == true) {
									HeaderBean.setVesselCode1(vesselCode.getStringCellValue());

								} else {
									error = error + "\n" + "Sheet No " + (no + 1) + " " + "Row" + (rowCnt +1)
											+ " vessel Code should be Correctly";
									System.out.println(error);
									throw new Exception(error);

								}

							}
						}
						if (rowCnt == 3) {
							Cell VoyageNo = row.getCell(2);
							if (VoyageNo == null || VoyageNo.getCellType() == Cell.CELL_TYPE_BLANK) {
								error = error + "\n" + "Sheet No " + (no + 1) + " " + "Row" + (rowCnt +1)
										+ " VoyageNo should not be empty";
								System.out.println(error);
								throw new Exception(error);

							} else {

								HeaderBean.setVoyageId(VoyageNo.getStringCellValue());

							}
						}
						if (rowCnt == 4) {
							Cell Service = row.getCell(2);
							if (Service == null || Service.getCellType() == Cell.CELL_TYPE_BLANK) {
								error = error + "\n" + "Sheet No " + (no + 1) + " " + "Row" + (rowCnt +1)
										+ " Service Code should not be empty";
								System.out.println(error);
								throw new Exception(error);

							} else {
								boolean success = getServiceCount(Service.getStringCellValue());
								if (success == true) {
									boolean success1 = duplicateCheck(HeaderBean.getVoyageId(),
											Service.getStringCellValue(), HeaderBean.getVesselCode1());
									if (!success1) {
										error = error + "\n" + "Sheet No " + (no + 1) + " " + "Row" + (rowCnt +1)
												+ " VoyageNo Already Exist !";
										System.out.println(error);
										throw new Exception(error);

									}
									HeaderBean.setSectorId(Service.getStringCellValue());
								} else {
									error = error + "\n" + "Sheet No " + (no + 1) + " " + "Row" + (rowCnt +1)
											+ " Service Code should  be Correctly";
									System.out.println(error);
									throw new Exception(error);

								}
							}
						}
						if (rowCnt == 5) {
							Cell vesselopr = row.getCell(2);
							if (vesselopr == null || vesselopr.getCellType() == Cell.CELL_TYPE_BLANK) {
								error = error + "\n" + "Sheet No " + (no + 1) + " " + "Row" + (rowCnt +1)
										+ " vessel Operator should not be empty";
								System.out.println(error);
							} else {
								Integer success = getVesselOprCount(vesselopr.getStringCellValue());
								if (success > 0) {
									HeaderBean.setMloShortName(success.toString());
								} else {
									error = error + "\n" + "Sheet No " + (no + 1) + " " + "Row" + (rowCnt +1)
											+ " vessel Operator should  be Enter Correctly";
									System.out.println(error);
									throw new Exception(error);

								}
							}
						}
						if (rowCnt >= 9) {

							Cell portCode = row.getCell(1);
							if (portCode == null || portCode.getCellType() == Cell.CELL_TYPE_BLANK) {
								error = error + "\n" + "Sheet No " + (no + 1) + " " + "Row" + (rowCnt +1)
										+ " Port Code should not be empty";
								System.out.println(error);
							} else {
								boolean success = getPortCount(portCode.getStringCellValue(), HeaderBean.getSectorId());
								if (success == true) {

									detailBean.setFromPort(portCode.getStringCellValue());
								} else {
									error = error + "\n" + "Sheet No " + (no + 1) + " " + "Row" + (rowCnt +1)
											+ " Port Code should  be Enter Correctly";
									System.out.println(error);
									throw new Exception(error);

								}
							}

							Cell eta = row.getCell(3);
							if (eta == null || eta.getCellType() == Cell.CELL_TYPE_BLANK) {
//								error = error + "\n" + "Sheet No " + (no + 1) + " " + "Row" + (rowCnt +1)
//										+ " eta date should not be empty";
//								System.out.println(error);
//								throw new Exception(error);

							} else {

								// HeaderBean.setFromPort(eta.getStringCellValue());

							}

							Cell etaTime = row.getCell(4);
//							double etaTime = 0;
							if (etaTime == null || etaTime.getCellType() == Cell.CELL_TYPE_BLANK) {
//								error = error + "\n" + "Sheet No " + (no + 1) + " " + "Row" + (rowCnt +1)
//										+ " eta time should not be empty";
//								System.out.println(error);
//								throw new Exception(error);

							} else {
								// if( etaDate.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								// etaTime = etaDate.getNumericCellValue();
								// }

								String str_date = String.valueOf(eta.getDateCellValue());
								DateFormat formatter;
								Date date;
								formatter = new SimpleDateFormat("dd/MM/yyyy");
								str_date = formatter.format(eta.getDateCellValue());
								date = formatter.parse(str_date);
								
								SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
								SimpleDateFormat format = new SimpleDateFormat("HH:mm");
								System.out.println("Date ETA :" + format.format(date));
								detailBean.setEta(format1.format(date) + " "+ format.format(etaTime.getDateCellValue()));

							}
							if (rowCnt == 9) {
								HeaderBean.setSchStartDate(detailBean.getEta());
							}
							Cell etb = row.getCell(5);
							if (etb == null || etb.getCellType() == Cell.CELL_TYPE_BLANK) {
//								error = error + "\n" + "Sheet No " + (no + 1) + " " + "Row" + (rowCnt +1)
//										+ " etb date should not be empty";
//								System.out.println(error);
//								throw new Exception(error);

							} else {

								// HeaderBean.setFromPort(eta.getStringCellValue());

							}
							Cell etbTime = row.getCell(6);
							double etbTime1 = 0;
							if (etbTime == null || etbTime.getCellType() == Cell.CELL_TYPE_BLANK) {
//								error = error + "\n" + "Sheet No " + (no + 1) + " " + "Row" + (rowCnt +1)
//										+ " etb time should not be empty";
//								System.out.println(error);
//								throw new Exception(error);

							} else {
								// if( etbTime.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								// etbTime1 = etbTime.getNumericCellValue();
								// }
								String str_date = String.valueOf(etb.getDateCellValue());
								DateFormat formatter;
								Date date;
								formatter = new SimpleDateFormat("dd-MMM-yy");
								str_date = formatter.format(etb.getDateCellValue());
								date = formatter.parse(str_date);
								SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
								SimpleDateFormat format = new SimpleDateFormat("HH:mm");
								System.out.println("Date ETA :" + format.format(date));//								detailBean.setEtb(etb.getStringCellValue() + " " + etbTime.getStringCellValue());
								detailBean.setEtb(format1.format(date) + " "+ format.format(etbTime.getDateCellValue()));

							}

							Cell etd = row.getCell(7);
							if (etd == null || etd.getCellType() == Cell.CELL_TYPE_BLANK) {
//								error = error + "\n" + "Sheet No " + (no + 1) + " " + "Row" + (rowCnt +1)
//										+ " eta date should not be empty";
//								System.out.println(error);
//								throw new Exception(error);

							} else {

								// HeaderBean.setFromPort(eta.getStringCellValue());

							}
							Cell etdTime = row.getCell(8);
							double etdTime1 = 0;
							if (etdTime == null || etdTime.getCellType() == Cell.CELL_TYPE_BLANK) {
//								error = error + "\n" + "Sheet No " + (no + 1) + " " + "Row" + (rowCnt +1)
//										+ " eta time should not be empty";
//								System.out.println(error);
//								throw new Exception(error);
							} else {
								// if( etdTime.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								// etdTime1 = etdTime.getNumericCellValue();
								// }
								String str_date = String.valueOf(etd.getDateCellValue());
								DateFormat formatter;
								Date date;
								formatter = new SimpleDateFormat("dd-MMM-yy");
								str_date = formatter.format(etd.getDateCellValue());
								date = formatter.parse(str_date);
								SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
								SimpleDateFormat format = new SimpleDateFormat("HH:mm");
								System.out.println("Date ETD :" + format.format(etd.getDateCellValue()));
								
//								detailBean.setEtb(etb.getStringCellValue() + " " + etbTime.getStringCellValue());
								detailBean.setEtd(format1.format(date) + " "+ format.format(etdTime.getDateCellValue()));

//								detailBean.setEtd(etd.getStringCellValue() + " " + etdTime.getStringCellValue());

							}
							HeaderBean.setSchEndDate(detailBean.getEtd());
							Cell cutoff = row.getCell(9);
							if (cutoff == null || cutoff.getCellType() == Cell.CELL_TYPE_BLANK) {
								// error = error + "\n" + "Row" + rowCnt + " Cutoff date should not be empty";
								// System.out.println(error);
							} else {

								// HeaderBean.setFromPort(eta.getStringCellValue());

							}
							Cell cutoffTime = row.getCell(10);
							double cutoffTime1 = 0;
							if (cutoffTime == null || cutoffTime.getCellType() == Cell.CELL_TYPE_BLANK) {
								// error = error + "\n" + "Row" + rowCnt + " Cutoff time should not be empty";
								// System.out.println(error);
							} else {
								// if( cutoffTime.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								// cutoffTime1 = cutoffTime.getNumericCellValue();
								// }
								String str_date = String.valueOf(cutoff.getDateCellValue());
								DateFormat formatter;
								Date date;
								formatter = new SimpleDateFormat("dd-MMM-yy");
								str_date = formatter.format(cutoff.getDateCellValue());
								date = formatter.parse(str_date);
								SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
								SimpleDateFormat format = new SimpleDateFormat("HH:mm");
								System.out.println("Date CUTOFFDT :" + format.format(cutoff.getDateCellValue()));
								
//								detailBean.setEtb(etb.getStringCellValue() + " " + etbTime.getStringCellValue());
								detailBean.setEtb(format1.format(date) + " "+ format.format(cutoffTime.getDateCellValue()));

								
//								detailBean.setCutoffdt(
//										cutoff.getStringCellValue() + " " + cutoffTime.getStringCellValue());

							}
							Cell rotationNo = row.getCell(11);
							if (rotationNo == null || rotationNo.getCellType() == Cell.CELL_TYPE_BLANK) {
								// error = error + "\n" + "Row" + rowCnt + "rotationNo should not be empty";
								// System.out.println(error);
							} else {

								detailBean.setRotationId(String.valueOf(rotationNo.getNumericCellValue()));

							}
							Cell nextvoyage = row.getCell(12);
							if (nextvoyage == null || nextvoyage.getCellType() == Cell.CELL_TYPE_BLANK) {
								// error = error + "\n" + "Row" + rowCnt + "next voyage should not be empty";
								// System.out.println(error);
							} else {
								if (nextvoyage.getStringCellValue() == "Y")
									detailBean.setNextVoyage("true");
								else
									detailBean.setNextVoyage("false");

							}
							Cell remakrs = row.getCell(13);
							if (remakrs == null || remakrs.getCellType() == Cell.CELL_TYPE_BLANK) {
								// error = error + "\n" + "Row" + rowCnt + "next voyage should not be empty";
								// System.out.println(error);
							} else {

								detailBean.setRemarks(remakrs.getStringCellValue());

							}
							detailBean.setVoyageId(HeaderBean.getVoyageId());
							detailBeanList.add(detailBean);
						}
					}
				}

				HeaderBean.setCompanyCode("C0001");
				//
				HeaderBean.setActivityCode(" ");
				resultBean = new ThirdPartyVoyageResultBean();
				resultBean.setThirtyPartyVoyageHeader(HeaderBean);
				resultBean.setVoyageDtlList(detailBeanList);
				ThirdPartyVoyageResultBean.add(resultBean);
			}

			resultbean.setMessage(thirdPartyVoyageDAO.saveThirdPartyVoyageImport(ThirdPartyVoyageResultBean));

		} catch (Exception e) {
			resultbean.setMessage(error);
			e.printStackTrace();

			isSuccess = false;
		}

		return resultbean;

	}

	public boolean getVesselCodeCount(String vesselCode) {
		boolean successs = false;
		try {
			int count = jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.GET_VESSELCode_COUNT, Integer.class,
					vesselCode.trim());
			if (count > 0) {
				successs = true;
			} else
				successs = false;
		} catch (Exception e) {

		}
		return successs;

	}

	// getServiceCount

	public boolean getServiceCount(String vesselCode) {
		boolean successs = false;
		try {
			int count = jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.GET_serviceCode_COUNT, Integer.class,
					vesselCode.trim());
			if (count > 0) {
				successs = true;
			} else {
				int count1 = jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.GET_serviceName_COUNT, Integer.class,
						vesselCode.trim());
				if (count1 > 0) {
					successs = true;
				} else {
					successs = true;
				}
			}
			// successs = false;
		} catch (Exception e) {

		}
		return successs;

	}

	// getServiceCount
	public boolean getPortCount(String port, String sector) {
		boolean successs = false;
		try {
			int count = jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.GET_PORT_COUNT1, Integer.class, port.trim());
			if (count > 0) {
				successs = true;
			} else {
				successs = false;
			}
		} catch (Exception e) {

		}
		return successs;

	}

	public boolean duplicateCheck(String voyage, String sector, String vessel) {
		boolean successs = false;
		try {
			vessel = vessel.concat("-");
			String voyageId = vessel.trim().concat(voyage.trim());
			int thirdPartyVoyageCount = jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.CHECK_THIRD_PARTY_VOYAGE,
					Integer.class, voyageId, sector);

			// int count =
			// jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.GET_PORT_COUNT,Integer.class,
			// sector.trim(),port.trim());
			if (thirdPartyVoyageCount > 0) {
				successs = false;
			} else {
				successs = true;
			}
		} catch (Exception e) {

		}
		return successs;

	}

	public Integer getVesselOprCount(String vesselCode) {
		boolean successs = false;
		int OPRNo = 0;
		try {
			String opr[] = vesselCode.split("-");
			OPRNo = jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.GET_VESSEL_OPR, Integer.class, opr[0]);
			if (OPRNo > 0) {
				successs = true;
			} else
				successs = false;
		} catch (Exception e) {

		}
		return OPRNo;

	}
	

}

