package com.dci.inventory.stocktransfer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;
import com.dci.tenant.finance.grn.GRNPurchaseOrderBean;

@Service
public class StockTransferServiceImpl implements StockTransferService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	StockTransferDAO stockTransferDAO;

	@Override
	public List<Object> getDropdown() {
		return stockTransferDAO.getDropdown();
	}

	@Override
	public StockTransferBean getGeneralInvoiceForView(int invoiceNo) {
		return stockTransferDAO.getGeneralInvoiceForView(invoiceNo);
	}

	@Override
	public List<StockTransferBean> getItemrequisition(String id) {
		return stockTransferDAO.getItemrequisition(id);
	}

	@Override
	public void InsertStockHdr(StockTransferBean bean) {
		stockTransferDAO.InsertStockHdr(bean);
	}

	@Override
	public List<StockTransferBean> getListPage() {
		return stockTransferDAO.getListPage();
	}

	@Override
	public void deleteStock(int id) {
		stockTransferDAO.deleteStock(id);

	}

	@Override
	public List<StockTransferBean> getEditData(int id) {
		return stockTransferDAO.getEditData(id);
	}

	@Override
	public void updateStockHdr(StockTransferBean bean) {
		stockTransferDAO.updateStockHdr(bean);

	}

	@Override
	public List<GRNPurchaseOrderBean> getBatchNoDetails(int itemId, int sourceLoc) {
		return stockTransferDAO.getBatchNoDetails(itemId, sourceLoc);
	}

	@Override
	public void InsertStockHdr1(StockTransferBean bean) {
		// TODO Auto-generated method stub
		stockTransferDAO.InsertStockHdr1(bean);

	}

	@Override
	public List<StockTransferBean> getItemrequisition1(String id) {
		// TODO Auto-generated method stub
		return stockTransferDAO.getItemrequisition1(id);
	}

	@Override
	public StockTransferResultBean uploadExeFile(MultipartFile file) {
		List<StockTransferResultBean> listbean = new ArrayList<>();
		StockTransferResultBean resultbean = new StockTransferResultBean();
		StockTransferResultBean successbean = new StockTransferResultBean();

		StockTransferBean header = null;
		ArrayList<StockTransferBean> headerDataList = new ArrayList<>();
		ArrayList<StockTransferBean> rowCollection = null;
		StockTransferBean detail = null;
		String fileName = file.getOriginalFilename();
		Iterator<Row> rowIterator = null;
		String datestring = "";
		int stopExec = 0;
		Workbook workbook = null;
		DataFormatter objDefaultFormat = new DataFormatter();
		FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
		String Errormrsg = "Error in Excel Upload";
		String Error = "Value Mismatch";
		try {
			if (fileName.endsWith("xls")) {
				workbook = new HSSFWorkbook(file.getInputStream());
				HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);
				rowIterator = sheet.rowIterator();
			} else if (fileName.endsWith("xlsx")) {
				workbook = new XSSFWorkbook(file.getInputStream());
				XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);
				rowIterator = sheet.rowIterator();
			} else {
				System.out.println("Not a valid file format");
			}
			int rowCnt = 0;
			String PArentprnumber = "0";
			String mrnumber = "null";
			String validateprnumber = "null";
			String PrRequestNumber = null;

			header = new StockTransferBean();
			// itemdetail = new ArrayList<ConsignmentRequestSubBean>();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (row != null) {
					rowCnt += 1;
					if (rowCnt > 3) {

						Iterator<Cell> cellIterator = row.cellIterator();
						String sDateCheck = "";

						Cell cell1 = cellIterator.next();
						if (cell1.getColumnIndex() == 0) {
							// header.setRequisitionNumber(cell1.getStringCellValue().trim());
							mrnumber = cell1.getStringCellValue().trim();
							validateprnumber = cell1.getStringCellValue().trim();

							System.out.println("PR" + mrnumber);

						} /*
						 * else{ if (cell1.getColumnIndex() == 1) { //
						 * header.setRequisitionNumber
						 * (cell1.getStringCellValue().trim()); PrRequestNumber
						 * = cell1.getStringCellValue().trim(); //
						 * validateprnumber = cell1.getStringCellValue().trim();
						 * stockTransferDAO.getRequisition(PrRequestNumber);
						 * System.out.println("PR" + mrnumber);
						 * 
						 * } }
						 */
						if (!mrnumber.equals(PArentprnumber)) {
							header = new StockTransferBean();
							rowCollection = new ArrayList<>();
							detail = new StockTransferBean();
							PArentprnumber = mrnumber;
							while (cellIterator.hasNext()) {
								Cell cell = cellIterator.next();
								int type = cell.getCellType();
								String retVal = null;

								if (cell.getColumnIndex() == 1) {
									// String companyName =
									// (cell.getStringCellValue());
									// Errormrsg = "Error in Row" + " " +
									// rowCnt + " " + "Column" + " " +
									// cell.getColumnIndex();
									// String companyId =
									// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.getCompanyId,
									// String.class, companyName);
									//
									// header.setCompanyId(companyId);
									// System.out.println("ORG" +
									// header.getCompanyId());
									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;

									PrRequestNumber = cell.getStringCellValue().trim();
									header = stockTransferDAO.getRequisition(PrRequestNumber);
									System.out.println("PR" + mrnumber);
									if (header.getId() != null) {
									} else {
										throw new Exception();
									}
								} else if (cell.getColumnIndex() == 2) {
									String date = (cell.getStringCellValue());

									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;

									// int locationId =
									// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.getLocationId,
									// Integer.class, srcLocation);

									header.setDate(date);
									// System.out.println("SRCLOC" +
									// header.getSourceLocation());

								} else if (cell.getColumnIndex() == 3) {
									int deliveryMet = 66;
									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;

									String deleiveryMethod = (cell.getStringCellValue());
									if (deleiveryMethod == "All at once") {
										deliveryMet = 66;
									} else if (deleiveryMethod == "Partial") {

										deliveryMet = 65;

									}
									header.setDeliveryMet(deliveryMet);
								} else if (cell.getColumnIndex() == 4) {
									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;

									String deleiveryMethod = (cell.getStringCellValue());

									String status = "Approved";
									// if (status.equals(deleiveryMethod)) {
									// status = "Approved";
									// } else {
									// status = "Pending";
									// }
									header.setStatus(status);
								} else if (cell.getColumnIndex() == 6) {
									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;

									String itemCode = (cell.getStringCellValue());
									// itemCode = itemCode.substring(0, 10);
									detail = stockTransferDAO.getItemrequisition(PrRequestNumber, itemCode);
									if (detail.getId() != null) {
										detail.setItemCode(detail.getId());
									} else {
										Error = "Item Name MisMatch";
										throw new Exception();
									}

								} else if (cell.getColumnIndex() == 7) {
									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;
									double qty = (cell.getNumericCellValue());
									if (detail.getAvailableQTY() > qty && detail.getPrquantity() > qty) {
										detail.setQuantity(qty);
									} else {
										Error = "There is no available Quantity";
										throw new Exception(" There is no available Quantity");
									}

								}
							}
							rowCollection.add(detail);
							// header.setRowCollection(rowCollection);
							header.setRowCollection(rowCollection);
							headerDataList.add(header);

							if (PArentprnumber != "0") {
								if (!mrnumber.equals(validateprnumber)) {
									header.setRowCollection(rowCollection);
									headerDataList.add(header);
									// resultbean.setHeaderDataList(headerDataList);
									resultbean.setlStockTransferBean(headerDataList);

									listbean.add(resultbean);
									rowCollection = new ArrayList<>();

								}
								validateprnumber = mrnumber;

							}
						} else {
							detail = new StockTransferBean();

							while (cellIterator.hasNext()) {
								Cell cell = cellIterator.next();
								if (cell.getColumnIndex() == 6) {
									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;

									String itemCode = (cell.getStringCellValue());
									// itemCode = itemCode.substring(0, 10);
									detail = stockTransferDAO.getItemrequisition(PrRequestNumber, itemCode);
									if (detail.getId() != null) {
										detail.setItemCode(detail.getId());
									} else {
										throw new Exception();
									}
								} else if (cell.getColumnIndex() == 7) {
									int column = cell.getColumnIndex();

									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;
									double qty = (cell.getNumericCellValue());

									if (detail.getAvailableQTY() > qty && detail.getPrquantity() > qty) {
										detail.setQuantity(qty);
									} else {
										Error = "There is no available Quantity";
										throw new Exception("There is no available Quantity");
									}
								}

							}
							PArentprnumber = mrnumber;
							validateprnumber = mrnumber;
							if (PArentprnumber != "0") {
								if (mrnumber.equals(validateprnumber)) {
									header.getRowCollection().add(detail);

									listbean.add(resultbean);
									rowCollection = new ArrayList<>();

								}
							}

						}

					}
				}
			}
			successbean.setSuccess(stockTransferDAO.InsertStockHdrImport(headerDataList));

		} catch (Exception e) {
			successbean.setMessage(Errormrsg + "  " + ":" + "  " + Error);
			e.printStackTrace();
		}
		return successbean;
	}

	@Override
	public List<StockTransferBean> getItem(String companyId) throws CustomException {
		return stockTransferDAO.getItem(companyId);

	}

	@Override
	public List<StockTransferBean> getDtlList(int itemId, int destLoc, String companyId) {
		return stockTransferDAO.getDtlList(itemId, destLoc, companyId);

	}

	@Override
	public List<SelectivityBean> issueTypeList() {
		// TODO Auto-generated method stub
		return stockTransferDAO.issueTypeList();
	}

	@Override
	public List<StockTransferBean> ItemList(int destId, String companyId) {
		// TODO Auto-generated method stub
		return stockTransferDAO.ItemList(destId, companyId);
	}

	@Override
	public void InsertStockHdrKitchen(StockTransferBean bean) {
		// TODO Auto-generated method stub
		stockTransferDAO.InsertStockHdrKitchen(bean);
	}

	@Override
	public StockTransferBean getQtyFromStock(int itemId, int destId, String companyId) {
		// TODO Auto-generated method stub
		return stockTransferDAO.getQtyFromStock(itemId, destId, companyId);
	}

	@Override
	public List<StockTransferBean> getRequisitionListCompanyBased(String companyYd) {
		// TODO Auto-generated method stub
		return stockTransferDAO.getRequisitionListCompanyBased(companyYd);
	}
}
