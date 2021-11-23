package com.dci.tenant.finance.consignmentRequest;

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

import com.dci.common.util.BasicResultBean;

@Service
public class ConsignmentRequestServiceImpl implements ConsignmentRequestService {

	@Autowired
	ConsignmentRequestDAO consignmentRequestDAO;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public ConsignmentRequestResultBean getEmployeeList() throws Exception {
		// TODO Auto-generated method stub
		return consignmentRequestDAO.getEmployeeList();
	}

	@Override
	public ConsignmentRequestSubBean getItemList(int itemId) throws Exception {
		// TODO Auto-generated method stub

		ConsignmentRequestSubBean consignmentRequestSubBean = consignmentRequestDAO.getItemList(itemId);
		return consignmentRequestSubBean;
	}

	@Override
	public boolean insertConsignmentRequest(ConsignmentRequestResultBean consignmentRequestResultBean) throws Exception {
		// TODO Auto-generated method stub
		return consignmentRequestDAO.insertConsignmentRequest(consignmentRequestResultBean);
	}

	@Override
	public ConsignmentRequestResultBean getConsignmentRequestById(int purchaseRequisitionId) throws Exception {
		// TODO Auto-generated method stub
		return consignmentRequestDAO.getConsignmentRequestById(purchaseRequisitionId);
	}

	@Override
	public List<ConsignmentRequest> getConsignmentRequestList() throws Exception {
		// TODO Auto-generated method stub
		return consignmentRequestDAO.getConsignmentRequestList();
	}

	@Override
	public boolean updateConsignmentRequest(ConsignmentRequestResultBean consignmentRequestResultBean) throws Exception {
		// TODO Auto-generated method stub
		return consignmentRequestDAO.updateConsignmentRequest(consignmentRequestResultBean);
	}

	@Override
	public boolean deleteConsignmentRequest(int purchaseRequisitionId) throws Exception {
		// TODO Auto-generated method stub
		return consignmentRequestDAO.deleteConsignmentRequest(purchaseRequisitionId);
	}

	@Override
	public ConsignmentRequestSubBean issueStatus(Integer reqId, Integer issueStatus) throws Exception {
		// TODO Auto-generated method stub
		return consignmentRequestDAO.issueStatus(reqId, issueStatus);
	}

	@Override
	public ConsignmentRequestResultBean printMaterialRequest(Integer materialReqID) {
		return consignmentRequestDAO.printMaterialRequest(materialReqID);
	}

	@Override
	public BasicResultBean getPRnumberduplicate(String prnumber) {
		// TODO Auto-generated method stub
		return consignmentRequestDAO.getPRnumberduplicate(prnumber);
	}

	@Override
	public BasicResultBean getPRnumberduplicate(String prnumber, String PRId) {
		// TODO Auto-generated method stub
		return consignmentRequestDAO.getPRnumberduplicate(prnumber, PRId);
	}

	@Override
	public ConsignmentRequestResultBean uploadExeFile(MultipartFile file) {
		boolean isSuccess = false;
		// TODO Auto-generated method stub
		ConsignmentRequestResultBean successbean = new ConsignmentRequestResultBean();
		ConsignmentRequestResultBean resultbean = new ConsignmentRequestResultBean();
		List<ConsignmentRequestResultBean> bean = new ArrayList<>();
		// ArrayList<ConsignmentRequest> lEmployeeMasterBean = new
		// ArrayList<>();
		ConsignmentRequest header = null;
		List<ConsignmentRequest> headerDataList = new ArrayList<>();
		List<ConsignmentRequestSubBean> itemdetail = null;
		ConsignmentRequestSubBean detail = null;
		// new ArrayList<ConsignmentRequestSubBean>();
		// ConsignmentRequest objEmployeeMasterBean = null;
		String fileName = file.getOriginalFilename();
		Iterator<Row> rowIterator = null;
		String datestring = "";
		int stopExec = 0;
		Workbook workbook = null;
		DataFormatter objDefaultFormat = new DataFormatter();
		FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
		String Errormrsg = "Error in Excel Upload";
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
			String prnumber = "null";
			String validateprnumber = "null";

			header = new ConsignmentRequest();
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
							// header = new ConsignmentRequest();

							// header.setPrRequestNo(cell1.getStringCellValue().trim());
							prnumber = cell1.getStringCellValue().trim();
							validateprnumber = cell1.getStringCellValue().trim();

							System.out.println("PR" + prnumber);
						}

						if (!prnumber.equals(PArentprnumber)) {
							header = new ConsignmentRequest();
							header.setRequisitionNumber(cell1.getStringCellValue().trim());
							itemdetail = new ArrayList<>();
							detail = new ConsignmentRequestSubBean();
							PArentprnumber = prnumber;
							while (cellIterator.hasNext()) {
								Cell cell = cellIterator.next();
								int type = cell.getCellType();
								String retVal = null;

								if (cell.getColumnIndex() == 1) {
									String companyName = (cell.getStringCellValue());
									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;
									String companyId = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.getCompanyId, String.class, companyName);

									header.setCompanyId(companyId);
									System.out.println("ORG" + header.getCompanyId());

								} else if (cell.getColumnIndex() == 2) {
									String srcLocation = (cell.getStringCellValue());

									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;

									int locationId = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.getLocationId, Integer.class, srcLocation);

									header.setSourceLocation(String.valueOf(locationId));
									System.out.println("SRCLOC" + header.getSourceLocation());

								} else if (cell.getColumnIndex() == 3) {
									String destLocation = (cell.getStringCellValue());
									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;

									int locationId = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.getLocationId, Integer.class, destLocation);

									header.setDestinationLocation(String.valueOf(locationId));
									System.out.println("DESTLOC" + header.getDestinationLocation());

								} else if (cell.getColumnIndex() == 4) {
									String costcenterName = (cell.getStringCellValue());
									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;

									String costenterId = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.getCostcenterId, String.class, costcenterName);

									header.setCostcenter(costenterId);
									System.out.println("COST" + header.getCostcenter());

									/*
									 * } else if (cell.getColumnIndex() == 5) { String requestedBy =
									 * (cell.getStringCellValue()); int column = cell.getColumnIndex(); Errormrsg =
									 * "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;
									 * 
									 * String employeeId = jdbcTemplate.queryForObject (ConsignmentRequestQueryUtil
									 * .getrequestedBy, String.class, requestedBy);
									 * 
									 * header.setEmployeeId(employeeId); System.out.println("REQBY" +
									 * header.getEmployeeId());
									 */
								} /*
									 * else if (cell.getColumnIndex() == 5) {
									 * 
									 * int column = cell.getColumnIndex(); Errormrsg = "Error in Row" + "  " +
									 * rowCnt + "  " + "Column" + "  " + ++column;
									 * 
									 * switch (cell.getCellType()) { case Cell.CELL_TYPE_STRING:
									 * header.setEmployeeId(cell .getStringCellValue().trim()); break;
									 * 
									 * case Cell.CELL_TYPE_NUMERIC: int employeeId = (int)
									 * cell.getNumericCellValue();
									 * 
									 * String loc = String.valueOf(employeeId); header.setEmployeeId((loc)); break;
									 * }
									 * 
									 * }
									 *//*
										 * else if (cell.getColumnIndex() == 6) {
										 * 
										 * int column = cell.getColumnIndex(); Errormrsg = "Error in Row" + "  " +
										 * rowCnt + "  " + "Column" + "  " + ++column;
										 * 
										 * switch (cell.getCellType()) { case Cell.CELL_TYPE_STRING:
										 * header.setPurchaseRequisitionNumber (cell.getStringCellValue().trim());
										 * break;
										 * 
										 * case Cell.CELL_TYPE_NUMERIC: int PurchaseRequisitionNumber = (int)
										 * cell.getNumericCellValue();
										 * 
										 * String loc = String.valueOf(PurchaseRequisitionNumber );
										 * header.setPurchaseRequisitionNumber((loc )); break; } }
										 */else if (cell.getColumnIndex() == 5) {
									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;

									header.setRequisitionDate((cell.getStringCellValue()));

								} else if (cell.getColumnIndex() == 7) {
									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;

									String itemCode = (cell.getStringCellValue());
									// itemCode = itemCode.substring(0, 10);
									String itemId = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.getitemId, String.class, itemCode);

									detail.setItemCode(itemId);
									System.out.println("ITEMCODE" + detail.getItemCode());

								} else if (cell.getColumnIndex() == 8) {
									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;
									System.out.println("IDS" + cell.getStringCellValue());

									detail.setItemdescription((cell.getStringCellValue().trim()));
								} else if (cell.getColumnIndex() == 9) {
									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;
									System.out.println("QUANTITY" + cell.getNumericCellValue());
									double Quantity = cell.getNumericCellValue();
									String loc = String.valueOf(Quantity);
									detail.setQuantity((Quantity));

								} else if (cell.getColumnIndex() == 10) {
									int column = cell.getColumnIndex();
									// Errormrsg = "Error in Row" + " " + rowCnt
									// + " " + "Column" + " " + ++column;
									System.out.println("EDD" + cell.getStringCellValue());
									String EddDate = cell.getStringCellValue();
									String loc = String.valueOf(EddDate);
									detail.setEddDate((EddDate));

								}
							}
							itemdetail.add(detail);
							header.setItemdetail1(itemdetail);
							headerDataList.add(header);

							if (PArentprnumber != "0") {
								if (!prnumber.equals(validateprnumber)) {
									header.setItemdetail1(itemdetail);
									headerDataList.add(header);
									resultbean.setHeaderDataList(headerDataList);

									bean.add(resultbean);
									itemdetail = new ArrayList<>();

								}
								validateprnumber = prnumber;

							}
						} else {
							detail = new ConsignmentRequestSubBean();

							while (cellIterator.hasNext()) {
								Cell cell = cellIterator.next();
								if (cell.getColumnIndex() == 7) {
									String itemCode = (cell.getStringCellValue());
									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;

									// itemCode = itemCode.substring(0, 10);
									String itemId = jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.getitemId, String.class, itemCode);

									detail.setItemCode(itemId);
									System.out.println("ITEMCODE" + header.getItemCode());

								} else if (cell.getColumnIndex() == 8) {
									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;

									System.out.println("IDS" + cell.getStringCellValue());

									detail.setItemdescription((cell.getStringCellValue().trim()));
								} else if (cell.getColumnIndex() == 9) {
									int column = cell.getColumnIndex();
									Errormrsg = "Error in Row" + "  " + rowCnt + "  " + "Column" + "  " + ++column;

									System.out.println("QUANTITY" + cell.getNumericCellValue());
									int Quantity = (int) cell.getNumericCellValue();
									String loc = String.valueOf(Quantity);
									detail.setQuantity((Quantity));
								} else if (cell.getColumnIndex() == 10) {
									int column = cell.getColumnIndex();
									// Errormrsg = "Error in Row" + " " + rowCnt
									// + " " + "Column" + " " + ++column;

									detail.setEddDate(cell.getStringCellValue().trim());
								}

							}
							PArentprnumber = prnumber;
							validateprnumber = prnumber;
							if (PArentprnumber != "0") {
								if (prnumber.equals(validateprnumber)) {
									header.getItemdetail1().add(detail);

									bean.add(resultbean);
									itemdetail = new ArrayList<>();

								}
							}

						}
					}
				}

			}
			successbean.setSuccess(consignmentRequestDAO.insertConReq(headerDataList));

		} catch (Exception e) {
			successbean.setMessage(Errormrsg + "  " + ":" + "  " + "Value Mismatch");
			e.printStackTrace();
		}
		return successbean;

	}

	@Override
	public boolean updateApproveMR(ConsignmentRequestResultBean consignmentRequetResultBean) {
		// TODO Auto-generated method stub
		return consignmentRequestDAO.updateApproveMR(consignmentRequetResultBean);
	}
}
