package com.dci.payroll.payroll.reimbursement;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;



@Service
public class ReimbursementServiceImpl implements ReimbursementService {
	@Autowired
	ReimbursementDAO reimbursementDAO;

/*	@Value("${file.asset.absolutePath}")
	private String getFilePropertyUrl;

	@Value("${file.asset.serverPath}")
	private String getFileServerPath;
*/
	@Override
	public boolean insertReimbursementreq(Reimbursement reimbursement) throws Exception {
		// TODO Auto-generated method stub
		return reimbursementDAO.insertReimbursementreq(reimbursement);
	}

	@Override
	public List<Reimbursement> getReimbursementList(int status) throws Exception {
		return reimbursementDAO.getReimbursementList(status);
	}

	@Override
	public List<Reimbursement> getReimbursementListByStatus(int status, String approvalempId) throws Exception {
		return reimbursementDAO.getReimbursementListByStatus(status, approvalempId);
	}

	@Override
	public List<Reimbursement> getCurrencyList() throws Exception {
		return reimbursementDAO.getCurrencyList();
	}

	@Override
	public List<Reimbursement> getReimburseMentTypeList() throws Exception {
		return reimbursementDAO.getReimburseMentTypeList();
	}

	@Override
	public Reimbursement getReimbursementById(int reimbursementId) throws Exception {
		// TODO Auto-generated method stub
		return reimbursementDAO.getReimbursementById(reimbursementId);
	}

	@Override
	public boolean approvalupdate(Reimbursement reimbursement) throws Exception {
		// TODO Auto-generated method stub
		return reimbursementDAO.approvalupdate(reimbursement);
	}

	@Override
	public boolean updateReimbursement(Reimbursement reimbursement) throws Exception {
		// TODO Auto-generated method stub
		return reimbursementDAO.updateReimbursement(reimbursement);
	}

	@Override
	public boolean deleteReimbursement(int reimbursementId) throws Exception {
		// TODO Auto-generated method stub
		return reimbursementDAO.deleteReimbursement(reimbursementId);
	}

	@Override
	public ReimbursementResultBean uploadDocFile(MultipartFile file, String fileName) {

		ReimbursementResultBean obj = new ReimbursementResultBean();

		String filePath = "";
		if (!file.isEmpty()) {

		/*	filePath = HisFileUploadUtillity.uploadFileHandlerWithOutRandom(file, getFilePropertyUrl, getFileServerPath, fileName);
			obj.setDocPath(filePath);*/

		}
		return obj;

	}

	@Override
	public void exportExcel(Reimbursement reimbursement, String filePath) throws CustomException, IOException, Exception {
		List<Reimbursement> ReimbursementList = new ArrayList<Reimbursement>();

		ReimbursementList = reimbursementDAO.getReimbursementList(2);
		GeneratePTListExportALL(ReimbursementList, filePath, filePath);

	}

	public void GeneratePTListExportALL(List<Reimbursement> ReimbursementList, String filePath, String monthYear) throws Exception, IOException {

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
		int rowNumber = 1;
		Row row2 = sheet1.createRow((short) 0);
		org.apache.poi.ss.usermodel.Cell cell;
		setHeading(wb, style);

		cell = row2.createCell((short) 0);
		cell.setCellStyle(style);
		cell.setCellValue("EMPLOYEE_ID");

		cell = row2.createCell((short) 1);
		cell.setCellStyle(style);
		cell.setCellValue("EMPLOYEE_NAME");

		cell = row2.createCell((short) 2);
		cell.setCellStyle(style);
		cell.setCellValue("REIMBURSEMENT_TYPE");

		cell = row2.createCell((short) 3);
		cell.setCellStyle(style);
		cell.setCellValue("AMOUNT");

		cell = row2.createCell((short) 4);
		cell.setCellStyle(style);
		cell.setCellValue("PAYMENT_MODE");

		sheet1.setColumnWidth((short) 0, (short) ((50 * 8) / ((double) 1 / 20)));

		for (Reimbursement reimbursement : ReimbursementList) {
			rowNumber += 1;
			Row row = sheet1.createRow((short) rowNumber);

			cell = row.createCell((short) 0);
			cell.setCellValue(reimbursement.getEmployeeId());
			cell = row.createCell((short) 1);
			cell.setCellValue(reimbursement.getEmployeeName());
			cell = row.createCell((short) 2);
			cell.setCellValue(reimbursement.getReimbursementTypeId());
			cell = row.createCell((short) 3);
			cell.setCellValue(reimbursement.getAmount());
			cell = row.createCell((short) 4);
			cell.setCellValue(reimbursement.getPaymentMode());
			cell = row.createCell((short) 5);

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
}
