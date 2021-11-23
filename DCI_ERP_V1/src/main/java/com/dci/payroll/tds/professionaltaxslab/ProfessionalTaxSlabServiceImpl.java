package com.dci.payroll.tds.professionaltaxslab;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
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
public class ProfessionalTaxSlabServiceImpl implements ProfessionalTaxSlabService {
	@Autowired
	ProfessionalTaxSlabDAO professionalTaxSlabDAO;

	@Override
	public List<ProfessionalTaxSlabBean> getProfessionalTaxSlabList() throws Exception {
		return professionalTaxSlabDAO.getProfessionalTaxSlabList();
	}

	@Override
	public PtListDTO getProfessionalGenerationList(String companyId, String branchId, int departmentId, String financialYear) throws Exception {
		return professionalTaxSlabDAO.getProfessionalGenerationList(companyId, branchId, departmentId, financialYear);
	}

	@Override
	public PtListDTO gettypeList(String companyId, String branchId, String dept, String typeId, String financialYear) throws Exception {
		// TODO Auto-generated method stub
		return professionalTaxSlabDAO.getTypeList(companyId, branchId, dept, typeId, financialYear);
	}

	@Override
	public boolean insertPtSlab(ProfessionalTaxSlabBean professionalTaxSlabBean) throws Exception {
		// TODO Auto-generated method stub
		return professionalTaxSlabDAO.insertPtSlab(professionalTaxSlabBean);
	}

	@Override
	public ProfessionalTaxSlabBean getPtSlabById(String branchId, String financialYear, BigDecimal rangeFrom) throws Exception {
		// TODO Auto-generated method stub
		return professionalTaxSlabDAO.getPtSlabById(branchId, financialYear, rangeFrom);
	}

	@Override
	public boolean updatePTSlab(ProfessionalTaxSlabBean professionalTaxSlabBean) throws Exception {
		// TODO Auto-generated method stub
		return professionalTaxSlabDAO.updatePTSlab(professionalTaxSlabBean);
	}

	@Override
	public boolean deletePTSlab(String branchId, String financialYear, BigDecimal rangeFrom) throws Exception {
		// TODO Auto-generated method stub
		return professionalTaxSlabDAO.deletePTSlab(branchId, financialYear, rangeFrom);
	}

	@Override
	public List<ProfessionalTaxSlabBean> getFinancialYear(String companyId) throws Exception {
		// TODO Auto-generated method stub
		return professionalTaxSlabDAO.getFinancialYear(companyId);
	}

	@Override
	public List<ProfessionalTaxSlabBean> getLoginfinancialYear(String companyId) throws Exception {
		// TODO Auto-generated method stub
		return professionalTaxSlabDAO.getLoginfinancialYear(companyId);
	}

	@Override
	public List<ProfessionalTaxSlabBean> getFinancialYearList() throws Exception {
		// TODO Auto-generated method stub
		return professionalTaxSlabDAO.getFinancialYearList();
	}

	@Override
	public ProfessionalTaxSlabBean uploadFile(MultipartFile file) {
		return professionalTaxSlabDAO.uploadFile(file);

	}

	@Override
	public void exportExcel1(ProfessionalTaxSlabBean professionalTaxSlabBean, String filePath) throws CustomException, IOException, Exception {
		PtListDTO ptList = professionalTaxSlabDAO.getTypeList(professionalTaxSlabBean.getCompanyId(), professionalTaxSlabBean.getBranchId(), professionalTaxSlabBean.getDept(), professionalTaxSlabBean.getTypeId(), professionalTaxSlabBean.getFinancialYear());
		GenerateDeductionListExportALL(ptList, filePath);
	}

	public void GenerateDeductionListExportALL(PtListDTO ptList, String filePath) throws Exception, IOException {
		String number = " ";
		List<ProfessionalTaxSlabBean> dateList = new ArrayList<ProfessionalTaxSlabBean>();

		HSSFWorkbook wb = new HSSFWorkbook();

		Sheet sheet1 = wb.createSheet("EMPLOYEE_DEDUCTION_SLAB_LIST");
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
		int rowNumber = 0;
		// heading row
		Row row1 = sheet1.createRow((short) rowNumber);
		org.apache.poi.ss.usermodel.Cell cell;
		setHeading(wb, style);
		cell = row1.createCell((short) 0);
		cell.setCellStyle(style);
		cell.setCellValue("EMPLOYEE_ID");

		cell = row1.createCell((short) 1);
		cell.setCellStyle(style);
		cell.setCellValue("EMPLOYEE_NAME");
		int i1 = 0;
		int j = 2;

		for (PtSlabDTO dto1 : ptList.getEmplList()) {
			if (i1 == 0) {
				dateList = dto1.getDateList();
			}
			i1 = i1 + 1;
		}

		for (ProfessionalTaxSlabBean bean : dateList) {
			cell = row1.createCell((short) j);
			cell.setCellStyle(style);
			cell.setCellValue(bean.getMonthValue());
			j = j + 1;
		}

		sheet1.setColumnWidth((short) 0, (short) ((50 * 8) / ((double) 1 / 20)));

		for (PtSlabDTO dto : ptList.getEmplList()) {
			rowNumber += 1;
			int j1 = 2;
			Row row = sheet1.createRow((short) rowNumber);
			cell = row.createCell((short) 0);
			cell.setCellValue(dto.getEmployeeId());
			cell = row.createCell((short) 1);
			cell.setCellValue(dto.getEmployeeName());
			for (ProfessionalTaxSlabBean bean : dto.getDateList()) {
				cell = row.createCell((short) j1);

				cell.setCellValue(bean.getAmount());
				j1 = j1 + 1;
			}
		}

		for (int i = 0; i < 10; i++) {
			sheet1.autoSizeColumn(i);
		}
		Random r = new Random();
		number = String.valueOf(r.nextInt()).substring(1, 3);
		writeExcel(wb, filePath);
	}

	@Override
	public void exportExcel(ProfessionalTaxSlabBean professionalTaxSlabBean, String filePath) throws IOException, Exception {
		PtListDTO ptList = professionalTaxSlabDAO.getProfessionalGenerationList(professionalTaxSlabBean.getCompanyId(), professionalTaxSlabBean.getBranchId(), professionalTaxSlabBean.getDepartmentId(), professionalTaxSlabBean.getFinancialYear());
		GeneratePTListExportALL(ptList, filePath);
	}

	public void GeneratePTListExportALL(PtListDTO ptList, String filePath) throws Exception, IOException {
		String number = " ";
		List<ProfessionalTaxSlabBean> dateList = new ArrayList<ProfessionalTaxSlabBean>();

		HSSFWorkbook wb = new HSSFWorkbook();

		Sheet sheet1 = wb.createSheet("EMPLOYEE_PT_SLAB_LIST");
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
		int rowNumber = 0;
		// heading row
		Row row1 = sheet1.createRow((short) rowNumber);
		org.apache.poi.ss.usermodel.Cell cell;
		setHeading(wb, style);
		cell = row1.createCell((short) 0);
		cell.setCellStyle(style);
		cell.setCellValue("EMPLOYEE_ID");

		cell = row1.createCell((short) 1);
		cell.setCellStyle(style);
		cell.setCellValue("EMPLOYEE_NAME");
		int i1 = 0;
		int j = 2;

		for (PtSlabDTO dto1 : ptList.getEmplList()) {
			if (i1 == 0) {
				dateList = dto1.getDateList();
			}
			i1 = i1 + 1;
		}

		for (ProfessionalTaxSlabBean bean : dateList) {
			cell = row1.createCell((short) j);
			cell.setCellStyle(style);
			cell.setCellValue(bean.getMonthValue());
			j = j + 1;
		}

		sheet1.setColumnWidth((short) 0, (short) ((50 * 8) / ((double) 1 / 20)));

		for (PtSlabDTO dto : ptList.getEmplList()) {
			rowNumber += 1;
			int j1 = 2;
			Row row = sheet1.createRow((short) rowNumber);
			cell = row.createCell((short) 0);
			cell.setCellValue(dto.getEmployeeId());
			cell = row.createCell((short) 1);
			cell.setCellValue(dto.getEmployeeName());
			for (ProfessionalTaxSlabBean bean : dto.getDateList()) {
				cell = row.createCell((short) j1);

				cell.setCellValue(bean.getAmount());
				j1 = j1 + 1;
			}
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

	@Override
	public boolean insertEmployeePTList(ArrayList<ProfessionalTaxSlabBean> empLOPBean) throws Exception {
		// TODO Auto-generated method stub
		return professionalTaxSlabDAO.insertEmployeePTList(empLOPBean);
	}

	@Override
	public boolean insertEmployeedeDuctionList(ArrayList<ProfessionalTaxSlabBean> empLOPBean) throws Exception {
		// TODO Auto-generated method stub
		return professionalTaxSlabDAO.insertEmployeeDeductionList(empLOPBean);
	}

}