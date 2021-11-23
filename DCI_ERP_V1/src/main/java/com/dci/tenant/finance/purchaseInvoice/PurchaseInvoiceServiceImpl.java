package com.dci.tenant.finance.purchaseInvoice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;

@Component
public class PurchaseInvoiceServiceImpl implements PurchaseInvoiceService {

	@Autowired
	PurchaseInvoiceDAO objPurchaseInvoiceDAO;

	@Override
	public List<PurchaseInvoiceHeaderBean> getSupplierList() throws CustomException {
		return objPurchaseInvoiceDAO.getSupplierList();
	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getGrnList(String supplier) throws CustomException {
		return objPurchaseInvoiceDAO.getGrnList(supplier);
	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getChargeList() {
		return objPurchaseInvoiceDAO.getChargeList();
	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getItemList() {
		return objPurchaseInvoiceDAO.getItemList();
	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getCompanyList() throws CustomException {
		return objPurchaseInvoiceDAO.getCompanyList();
	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getcostcenterlist() throws CustomException {
		return objPurchaseInvoiceDAO.getcostcenterlist();
	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getcostcenterlist1() throws CustomException {
		return objPurchaseInvoiceDAO.getcostcenterlist1();
	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getPurchaseInvoiceList() throws CustomException {
		return objPurchaseInvoiceDAO.getPurchaseInvoiceList();
	}

	@Override
	public PurchaseInvoiceHeaderBean getPurchaseInvoiceDetail(String sPurchaseInvoiceNo) {
		return objPurchaseInvoiceDAO.getPurchaseInvoiceDetail(sPurchaseInvoiceNo);
	}

	@Override
	public boolean updatePurchaseInvoice(PurchaseInvoiceHeaderBean objPurchaseInvoiceBean) {
		return objPurchaseInvoiceDAO.updatePurchaseInvoice(objPurchaseInvoiceBean);
	}

	@Override
	public boolean savePurchaseInvoice(PurchaseInvoiceHeaderBean objPurchaseInvoiceBean) throws CustomException {
		boolean isSuccess = objPurchaseInvoiceDAO.savePurchaseInvoice(objPurchaseInvoiceBean);
		return true;

	}

	@Override
	public boolean deletePurchaseInvoice(String invoiceNo) throws CustomException {
		return objPurchaseInvoiceDAO.deletePurchaseInvoice(invoiceNo);
	}

	@Override
	public PurchaseInvoiceHeaderBean getGrnDetail(int igrnId) {
		return objPurchaseInvoiceDAO.getGrnDetail(igrnId);
	}

	@Override
	public boolean exportToPurchaseInvoicePdf(String puchaseInvoiceNo, ServletContext context) {
		return objPurchaseInvoiceDAO.exportToPurchaseInvoicePdf(puchaseInvoiceNo, context);
	}

	@Override
	public PurchaseInvoiceHeaderBean checkFreightCharges(int igrnId) {
		// TODO Auto-generated method stub
		return objPurchaseInvoiceDAO.checkFreightCharges(igrnId);
	}

	@Override
	public PurchaseInvoiceHeaderBean getEditcheckFreightCharges(int igrnId) {
		// TODO Auto-generated method stub
		return objPurchaseInvoiceDAO.getEditcheckFreightCharges(igrnId);
	}

	@Override
	public PurchaseInvoiceHeaderBean getExchangeRates(String currencyCode) throws Exception {

		return objPurchaseInvoiceDAO.getExchangeRates(currencyCode);
	}

	@Override
	public PurchaseInvoiceHeaderBean getCurrencyCode(String currencyCode) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseInvoiceDAO.getCurrencyCode(currencyCode);
	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getBankAcctListcompanycode(String company) {
		return objPurchaseInvoiceDAO.getBankAcctListcompanycode(company);
	}

	@Override
	public List<PurchaseInvoiceHeaderBean> grnNo(Integer grnNo) {
		return objPurchaseInvoiceDAO.grnNo(grnNo);
	}

	@Override
	public PurchaseInvoiceHeaderBean budpo(Integer grnNo) {
		return objPurchaseInvoiceDAO.budpo(grnNo);
	}

	@Override
	public List<PurchaseInvoiceHeaderBean> getgrnsupplier(String supplier) {
		return objPurchaseInvoiceDAO.getgrnsupplier(supplier);
	}

	@Override
	public PurchaseInvoiceHeaderBean getPurchaseInvoiceForView(String puchaseInvoiceNo) {
		// TODO Auto-generated method stub
		return objPurchaseInvoiceDAO.getPurchaseInvoiceForView(puchaseInvoiceNo);
	}

	@Override
	public String uploadFile(MultipartFile file) {
		String alertMsg = "";
		boolean isOverWriteable = false;
		@SuppressWarnings("unused")
		boolean isDeleted = false;
		try {

			org.apache.poi.ss.usermodel.Workbook wb_xssf;
			org.apache.poi.ss.usermodel.Workbook wb_hssf;
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/M/yyyy");
			String fileName = file.getOriginalFilename();
			Sheet sheet = null;
			StringBuffer sb = new StringBuffer();
			if (fileName.endsWith("xlsx") || fileName.endsWith("XLSX")) {
				wb_xssf = new XSSFWorkbook(file.getInputStream());
				sheet = wb_xssf.getSheetAt(0);
			}
			if (fileName.endsWith("xls") || fileName.endsWith("XLS")) {
				POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
				wb_hssf = new HSSFWorkbook(fs);

				sheet = wb_hssf.getSheetAt(0);
			}

			String company = "";
			String supplier = "";
			String costCenter = "";
			String purchaseInvoiceDate = "";
			String partyInvoiceNo = "";
			String dueDate = "";
			String description = "";
			Double amountHeader = 0.0;

			List<PurchaseInvoiceHeaderBean> headerList = new ArrayList<>();
			List<PurchaseInvoiceDetailBean> detailList = new ArrayList<>();
			System.out.println(sheet.getLastRowNum());
			for (int rowCount = 1; rowCount <= sheet.getLastRowNum(); rowCount++) {
				PurchaseInvoiceHeaderBean purchaseInvoiceHeader = new PurchaseInvoiceHeaderBean();

				int index = 0;
				int rownnum = rowCount + 1;
				XSSFRow companyCode = (XSSFRow) sheet.getRow(rowCount);
				System.out.println("Row = " + rownnum);
				if (companyCode != null && companyCode.getCell(0) != null && companyCode.getCell(1) != null) {
					Cell purInvDate = companyCode.getCell(0);

					if (purInvDate == null) {
						purchaseInvoiceDate = "";
					} else if (purInvDate.getCellType() == 0) {
						purchaseInvoiceDate = formatter.format(purInvDate.getDateCellValue());
					} else if (purInvDate.getCellType() == 1) {
						purchaseInvoiceDate = purInvDate.toString();
					} else {
						purchaseInvoiceDate = "";
					}

					// Date currentDate = new Date();
					DateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");

					Date today = new Date();

					Date currentDate = formatter1.parse(formatter1.format(today));
					SimpleDateFormat myFormat = new SimpleDateFormat("dd-mm-yyyy");

					// Date invDate = myFormat.format(purInvDate.toString()));
					
					Date invDate = new SimpleDateFormat("dd/M/yyyy").parse(purchaseInvoiceDate);
					System.out.println(invDate);
					LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

					// LocalDateTime localDateTime1 =
					// currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

					localDateTime = localDateTime.plusDays(-2);
					// localDateTime1 = localDateTime1.plusDays(-1);

					// localDateTime =
					// localDateTime.plusHours(1).plusMinutes(2).minusMinutes(1).plusSeconds(1);

					// convert LocalDateTime to date
					Date currentDatePlusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

					// Date currentDatePlusOneDay1 =
					// Date.from(localDateTime1.atZone(ZoneId.systemDefault()).toInstant());
					boolean dateflag = false;
					// if (invDate.before(currentDatePlusOneDay)) {
					// System.out.println(currentDatePlusOneDay);
					// alertMsg = "Row " + rownnum +
					// " Purchase Invoice Date allow only previous two date.";
					// return alertMsg;
					// } else

					if (invDate.after(currentDate)) {
						System.out.println(currentDatePlusOneDay);
						alertMsg = "Row " + rownnum + " Purchase Invoice Date Should not allow future date.";
						return alertMsg;
					}
					// else if (invDate == currentDate) {
					// System.out.println(currentDate);
					//
					// }

					else {
						if (purInvDate == null) {
							purchaseInvoiceDate = "";
						} else if (purInvDate.getCellType() == 0) {
							purchaseInvoiceDate = formatter.format(purInvDate.getDateCellValue());
						} else if (purInvDate.getCellType() == 1) {
							purchaseInvoiceDate = purInvDate.toString();
						} else {
							purchaseInvoiceDate = "";
						}
					}
					Cell descriptioData = companyCode.getCell(2);
					if (descriptioData == null) {
						description = "";
					} else if (descriptioData.getCellType() == 1) {
						description = checkNullValue(descriptioData.getStringCellValue()).trim();
					} else {
						description = "";
					}
					Cell descriptio1Data = companyCode.getCell(3);
					if (descriptio1Data.getCellType() == 1 && descriptio1Data != null) {
						description += "-" + checkNullValue(descriptio1Data.getStringCellValue()).trim();
					}
					Cell supplierData = companyCode.getCell(1);
					if (supplierData == null) {
						supplier = "";
					} else if (supplierData.getCellType() == 1) {
						System.out.println(supplierData);
						supplier = checkNullValue(supplierData.getStringCellValue()).trim();
					} else {
						supplier = "";
					}

					Cell companyCodeDate = companyCode.getCell(6);
					if (companyCodeDate == null) {
						company = "C0002";
					} else if (companyCodeDate.getCellType() == 1) {
						company = checkNullValue(companyCodeDate.getStringCellValue()).trim();
					} else {
						company = "C0002";
					}
					Cell costCenterData = companyCode.getCell(7);
					if (costCenterData == null) {
						costCenter = "";
					} else if (costCenterData.getCellType() == 1) {
						costCenter = checkNullValue(costCenterData.getStringCellValue()).trim();
					} else {
						costCenter = "";
					}
					Cell amountCell = companyCode.getCell(14);
					if (amountCell == null) {
						alertMsg = "Row " + rownnum + " Amount is empty. Excel file cannot be uploaded.";
						return alertMsg;
					} else if (amountCell.getCellType() == 0) {
						amountHeader = amountCell.getNumericCellValue();
						purchaseInvoiceHeader.setAmount(amountHeader);
						purchaseInvoiceHeader.setDetailAmount(amountHeader);
					} else if (amountCell.getCellType() == 1) {
						alertMsg = "Row " + rownnum + " Amount Should be Numeric. Excel file cannot be uploaded.";
						return alertMsg;
					} else {
						alertMsg = "Row " + rownnum + " Amount Format is Wrong. Excel file cannot be uploaded.";
						return alertMsg;
					}

					/*
					 * if (!objPurchaseInvoiceDAO.checkComSupCost(company, supplier, costCenter)) {
					 * alertMsg = "Row " + rowCount +
					 * " Please check Company, Supplier and Cost Center."; return alertMsg; }
					 */

					HashMap<String, String> companyMap = new HashMap<>();
					HashMap<String, String> supplierMap = new HashMap<>();
					HashMap<String, String> costConterMap = new HashMap<>();

					companyMap = objPurchaseInvoiceDAO.getCompany();
					supplierMap = objPurchaseInvoiceDAO.getSupplier();
					costConterMap = objPurchaseInvoiceDAO.getCostCenter();
					System.out.println("company" + company);
					if (company.isEmpty()) {
						purchaseInvoiceHeader.setCompany("");
					} else {
						company = company.toUpperCase();
						purchaseInvoiceHeader.setCompany(companyMap.get(company));
					}
					if (supplier.isEmpty()) {
						purchaseInvoiceHeader.setSupplier("");
						// } else if
						// (checkNullValue(supplierMap.get(supplier)).isEmpty())
						// {
					} else if (checkNullValue(supplier).isEmpty()) {

						alertMsg = "Row " + rownnum + " Supplier is not Available in Sytem. Excel file cannot be uploaded.";
						return alertMsg;

					} else {
						purchaseInvoiceHeader.setSupplier(supplierMap.get(supplier));
					}
					if (costCenter.isEmpty()) {
						purchaseInvoiceHeader.setCostCenter("");
					} else {
						purchaseInvoiceHeader.setCostCenter(costConterMap.get(costCenter));
					}
					purchaseInvoiceHeader.setPuchaseInvoiceDate(purchaseInvoiceDate);
					purchaseInvoiceHeader.setDescription(description);

					HashMap<String, String> chargesMap = new HashMap<>();
					chargesMap = objPurchaseInvoiceDAO.getCharges();
					PurchaseInvoiceDetailBean bean = new PurchaseInvoiceDetailBean();
					Cell chargesType = companyCode.getCell(8);
					String charges = "";
					if (chargesType == null) {
						charges = "";
					} else if (chargesType.getCellType() == 1) {
						charges = checkNullValue(chargesType.getStringCellValue()).trim();
						System.out.println("Charges +++++++++++++++ " + chargesType);
						if (charges.isEmpty()) {
							charges = "";
						} else {
							purchaseInvoiceHeader.setAccountHeadCode(chargesMap.get(charges));
						}
					} else {
						charges = "";
					}

					Cell narration = companyCode.getCell(5);
					String narrationData = "";
					if (narration == null) {
						narrationData = "";
					} else if (narration.getCellType() == 1) {
						narrationData = checkNullValue(narration.getStringCellValue()).trim();
						System.out.println("Narration +++++++++++++++ " + narration);
						purchaseInvoiceHeader.setNarration(narrationData);
					} else {
						narrationData = "";
					}

				} else {

				}
				index++;
				headerList.add(purchaseInvoiceHeader);
			}

			if (sb.toString().isEmpty()) {

				alertMsg = objPurchaseInvoiceDAO.InsertUploadData(headerList);
				// alertMsg = "Data uploaded successfully";
				DateFormat FILE_DATE_FORMAT = new SimpleDateFormat("dd_MM_yyyy_HHmmss");

				/*
				 * String filepath = ConfigurationProps.slotMessageFilesPath +
				 * "/PurchaseInvoiceUpload"; String path = filepath + "/" +
				 * FILE_DATE_FORMAT.format(new Date()) + "_" + userDetails.getUserId() + "_" +
				 * file.getOriginalFilename();
				 * 
				 * File checkfile = new File(filepath); if (!checkfile.exists())
				 * checkfile.mkdir();
				 * 
				 * File convFile = new File(path); FileOutputStream fos = new
				 * FileOutputStream(convFile); fos.write(file.getBytes()); fos.close();
				 */
			} else {
				alertMsg = sb.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			String error[] = String.valueOf(ExceptionUtils.getRootCauseMessage(e)).split(":");
			alertMsg = error[0] + "-" + error[1];
		}
		return alertMsg;

	}

	private Date myFormat(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private String checkNullValue(String value) {
		try {

			if (value.trim() == null || value.trim().equalsIgnoreCase("null")) {
				value = "";
			}
		} catch (Exception e) {
			value = "";
			return value;

		}
		return value;
	}

	private int checkNullInteger(String value) {

		int t = 0;
		try {
			if (value.trim() == null || value.trim().equalsIgnoreCase("null")) {
				value = "";
			} else {
				t = Integer.parseInt(value);
			}
		} catch (Exception e) {
			return t;
		}

		return t;
	}

	private double checkNullDouble(String value) {

		double t = 0;
		try {
			if (value.trim() == null || value.trim().equalsIgnoreCase("null")) {
				value = "";
			} else {
				t = Double.parseDouble(value);
			}
		} catch (Exception e) {
			return t;
		}

		return t;
	}

}
