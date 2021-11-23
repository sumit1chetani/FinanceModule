package com.dci.tenant.finance.bankreconciliation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;

@Repository
// @Transactional("tenantTransactionManager")
public class BankReconciliationDaoImpl implements BankReconciliationDao {

	private final static Logger LOGGER = LoggerFactory.getLogger(BankReconciliationDaoImpl.class);
	@Resource
	private DataSource dataSource;
	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;

	/*
	 * @Override public List<BankReconciliationBean> getBankList() {
	 * List<BankReconciliationBean> lBankList = new
	 * ArrayList<BankReconciliationBean>(); try { JdbcTemplate jdbcTemplate = new
	 * JdbcTemplate(dataSource);
	 * 
	 * lBankList = jdbcTemplate.query(BankReconciliationQueryUtil.GETBANKLIST, new
	 * BeanPropertyRowMapper<BankReconciliationBean>(BankReconciliationBean.
	 * class));
	 * 
	 * } catch (DataAccessException e) {
	 * LOGGER.error("Error in fetching the Bank LIST", e); } return lBankList; }
	 */
	@Override
	public List<SelectivityBean> getBankList() {
		List<SelectivityBean> lBankList = new ArrayList<>();

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			lBankList = jdbcTemplate.query(BankReconciliationQueryUtil.GETBANKLIST, new BeanPropertyRowMapper<>(SelectivityBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lBankList;
	}

	/*
	 * @Override public String uploadFile(MultipartFile file, String sBankCode) {
	 * 
	 * ArrayList<BankReconciliationBean> alBankDataBean = new
	 * ArrayList<BankReconciliationBean>(); BankReconciliationBean
	 * objBankReconciliationBean = null; String fileName =
	 * file.getOriginalFilename(); Iterator<Row> rowIterator = null; String
	 * datestring = ""; int stopExec = 0; Workbook workbook = null; String sMessage
	 * = ""; StringBuffer sb = new StringBuffer();
	 * 
	 * org.apache.poi.ss.usermodel.Workbook wb_xssf;
	 * org.apache.poi.ss.usermodel.Workbook wb_hssf; Sheet sheet = null; try { if
	 * (fileName.endsWith("xls")) { POIFSFileSystem fs = new
	 * POIFSFileSystem(file.getInputStream()); wb_hssf = new HSSFWorkbook(fs); sheet
	 * = wb_hssf.getSheetAt(0); } else if (fileName.endsWith("xlsx")) { wb_xssf =
	 * new XSSFWorkbook(file.getInputStream()); sheet = wb_xssf.getSheetAt(0); }
	 * else { System.out.println("Not a valid file format"); }
	 * 
	 * SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy"); int lastRow
	 * = sheet.getLastRowNum(); String sDateCheck = ""; for (int rowCount = 2 ;
	 * rowCount <= sheet.getLastRowNum(); rowCount++) { objBankReconciliationBean =
	 * new BankReconciliationBean(); Row row = sheet.getRow(rowCount); (lastRow-1)
	 * != rowCount && lastRow != rowCount if(rowCount > 1 && stopExec == 0){ Cell
	 * date = row.getCell(0); sDateCheck = date.getStringCellValue().trim(); if
	 * (sDateCheck.startsWith("*") && sDateCheck.startsWith("")) { stopExec =
	 * rowCount; } if(stopExec == 0){ if(date.getCellType() == 3){
	 * sb.append("Row - " + (rowCount+1) + " : Date should not be empty. ");
	 * sb.append("<br>"); }else{ try{ dateFormat.parse(date.toString()); Date date1
	 * = dateFormat.parse(date.toString());
	 * objBankReconciliationBean.setBank_date(date.toString());
	 * }catch(ParseException pe){ sb.append("Row - " + (rowCount+1) +
	 * " : Date Format Should be (DD/MM/YYYY). "); sb.append("<br>"); } } Cell
	 * narration = row.getCell(1); if(narration == null){ sb.append("Row - " +
	 * (rowCount+1) + " : Narration should not be empty"); sb.append("<br>"); }else
	 * objBankReconciliationBean.setBank_narration(narration.getStringCellValue(
	 * ).trim()); Cell refNo = row.getCell(2); if(refNo == null){ sb.append("Row - "
	 * + (rowCount+1) + " : Chq./Ref.No. should not be empty"); sb.append("<br>");
	 * }else if(refNo.getCellType() == 0){
	 * objBankReconciliationBean.setBank_cheque_no(refNo.toString()); } else
	 * objBankReconciliationBean.setBank_cheque_no(refNo.getStringCellValue().
	 * trim()); Cell valueDate = row.getCell(3); if(valueDate.getCellType() == 3){
	 * sb.append("Row - " + (rowCount+1) + " : Value Date should not be empty. ");
	 * sb.append("<br>"); }else{ try{ dateFormat.parse(valueDate.toString()); Date
	 * date1 = dateFormat.parse(valueDate.toString());
	 * objBankReconciliationBean.setValue_date(valueDate.toString());
	 * }catch(ParseException pe){ sb.append("Row - " + (rowCount+1) +
	 * " : Date Format Should be (DD/MM/YYYY). "); sb.append("<br>"); } } Cell
	 * withDraw = row.getCell(4); if(withDraw == null || withDraw.getCellType() ==
	 * 3) objBankReconciliationBean.setBank_debit_amt(0); else
	 * if(withDraw.getCellType() == 0){ boolean fail =
	 * (BigDecimal.valueOf(withDraw.getNumericCellValue()).scale() > 2); if(fail){
	 * objBankReconciliationBean.setBank_debit_amt(Math.round(withDraw.
	 * getNumericCellValue() * 100.0) / 100.0); }else
	 * objBankReconciliationBean.setBank_debit_amt(withDraw.getNumericCellValue( ));
	 * }else{ sb.append("Row - " + (rowCount+1) +
	 * " : Withdrawal Amount should not be text "); sb.append("<br>"); } Cell
	 * depositAmt = row.getCell(5); if(depositAmt == null ||
	 * depositAmt.getCellType() == 3)
	 * objBankReconciliationBean.setBank_credit_amt(0); else
	 * if(depositAmt.getCellType() == 0){ boolean fail =
	 * (BigDecimal.valueOf(depositAmt.getNumericCellValue()).scale() > 2); if(fail){
	 * objBankReconciliationBean.setBank_credit_amt(Math.round(depositAmt.
	 * getNumericCellValue() * 100.0) / 100.0); }else
	 * objBankReconciliationBean.setBank_credit_amt(depositAmt.
	 * getNumericCellValue()); }else{ sb.append("Row - " + (rowCount+1) +
	 * " : Deposit Amount should not be text "); sb.append("<br>"); } Cell
	 * closingBal = row.getCell(6); if(closingBal == null ||
	 * closingBal.getCellType() == 3)
	 * objBankReconciliationBean.setBank_closing_balance(0); else
	 * if(closingBal.getCellType() == 0){ boolean fail =
	 * (BigDecimal.valueOf(closingBal.getNumericCellValue()).scale() > 2); if(fail){
	 * objBankReconciliationBean.setBank_closing_balance(Math.round(closingBal.
	 * getNumericCellValue() * 100.0) / 100.0); }else
	 * objBankReconciliationBean.setBank_closing_balance(closingBal.
	 * getNumericCellValue()); }else{ sb.append("Row - " + (rowCount+1) +
	 * " : Deposit Amount should not be text "); sb.append("<br>"); }
	 * objBankReconciliationBean.setBank_account_code(sBankCode);
	 * alBankDataBean.add(objBankReconciliationBean); }
	 * 
	 * } } sMessage = sb.toString(); if(sMessage.isEmpty()){
	 * exportExcelDataToDB(alBankDataBean); } } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * return sMessage; }
	 */
	@Override
	public String uploadFile(MultipartFile file, String sBankCode) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		ArrayList<BankReconciliationBean> alBankDataBean = new ArrayList<>();
		BankReconciliationBean objBankReconciliationBean = null;
		String fileName = file.getOriginalFilename();
		Iterator<Row> rowIterator = null;
		String datestring = "";
		int stopExec = 0;
		Workbook workbook = null;
		String sMessage = "";
		StringBuffer sb = new StringBuffer();

		org.apache.poi.ss.usermodel.Workbook wb_xssf;
		org.apache.poi.ss.usermodel.Workbook wb_hssf;
		Sheet sheet = null;
		Sheet sheet1 = null;
		try {
			if (fileName.endsWith("xls")) {
				wb_xssf = new XSSFWorkbook(file.getInputStream());
				sheet1 = wb_xssf.getSheetAt(0);
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
				int lastRow = sheet1.getLastRowNum();
				String sDateCheck = "";
				for (int rowCount = 12; rowCount <= sheet1.getLastRowNum(); rowCount++) {
					objBankReconciliationBean = new BankReconciliationBean();
					XSSFRow row = (XSSFRow) sheet1.getRow(rowCount);

					Cell transactionDate = row.getCell(0);
					if (transactionDate == null || transactionDate.getCellType() == Cell.CELL_TYPE_BLANK) {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt +1)
						// + " POL Code should not be empty";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);

					} else {
						// boolean success =
						// getPOLCount(pol.getStringCellValue());
						// if (success == true) {
						SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

						objBankReconciliationBean.setBank_date(df.format(transactionDate.getDateCellValue()).toString());

						// } else {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt + 1) +
						// " POL Code should Enter be Correctly";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);
						//
						// }

					}

					Cell valuedate = row.getCell(1);
					if (valuedate == null || valuedate.getCellType() == Cell.CELL_TYPE_BLANK) {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt +1)
						// + " POL Code should not be empty";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);

					} else {
						// boolean success =
						// getPOLCount(pol.getStringCellValue());
						// if (success == true) {
						// objBankReconciliationBean.setValue_date(valuedate.getStringCellValue());
						SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

						objBankReconciliationBean.setValue_date(df.format(valuedate.getDateCellValue()).toString());

						// } else {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt + 1) +
						// " POL Code should Enter be Correctly";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);
						//
						// }

					}

					Cell chequeNo = row.getCell(3);
					if (chequeNo == null || chequeNo.getCellType() == Cell.CELL_TYPE_BLANK) {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt +1)
						// + " POL Code should not be empty";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);

					} else {
						// boolean success =
						// getPOLCount(pol.getStringCellValue());
						// if (success == true) {
						if (chequeNo.getCellType() == 0) {
							double checque = chequeNo.getNumericCellValue();
							String cheque[] = String.valueOf(checque).split("\\.");
							objBankReconciliationBean.setBank_cheque_no(cheque[0]);
						} else if (chequeNo.getCellType() == 1) {
							objBankReconciliationBean.setBank_cheque_no(chequeNo.getStringCellValue());
						}
						boolean success = getChequeNo(objBankReconciliationBean.getBank_cheque_no());
						if (!success) {
							sMessage = "Cheque No is mismatched in cashbank payment";
							// throw new Exception(sMessage);
						}
						// } else {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt + 1) +
						// " POL Code should Enter be Correctly";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);
						//
						// }

					}

					Cell narration = row.getCell(4);
					if (narration == null || narration.getCellType() == Cell.CELL_TYPE_BLANK) {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt +1)
						// + " POL Code should not be empty";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);

					} else {
						// boolean success =
						// getPOLCount(pol.getStringCellValue());
						// if (success == true) {
						objBankReconciliationBean.setBank_narration(narration.getStringCellValue());

						// } else {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt + 1) +
						// " POL Code should Enter be Correctly";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);
						//
						// }

					}

					Cell debit = row.getCell(5);
					if (debit == null || debit.getCellType() == Cell.CELL_TYPE_BLANK) {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt +1)
						// + " POL Code should not be empty";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);

					} else {
						// boolean success =
						// getPOLCount(pol.getStringCellValue());
						// if (success == true) {
						objBankReconciliationBean.setBank_debit_amt(debit.getNumericCellValue());

						// } else {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt + 1) +
						// " POL Code should Enter be Correctly";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);
						//
						// }

					}

					Cell credit = row.getCell(6);
					if (credit == null || credit.getCellType() == Cell.CELL_TYPE_BLANK) {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt +1)
						// + " POL Code should not be empty";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);

					} else {
						// boolean success =
						// getPOLCount(pol.getStringCellValue());
						// if (success == true) {
						objBankReconciliationBean.setBank_credit_amt(credit.getNumericCellValue());

						// } else {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt + 1) +
						// " POL Code should Enter be Correctly";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);
						//
						// }

					}

					Cell balance = row.getCell(7);
					if (balance == null || balance.getCellType() == Cell.CELL_TYPE_BLANK) {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt +1)
						// + " POL Code should not be empty";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);

					} else {
						// boolean success =
						// getPOLCount(pol.getStringCellValue());
						// if (success == true) {
						String balanceval = balance.getStringCellValue();
						balanceval = balanceval.replaceAll(",", "");
						objBankReconciliationBean.setBank_closing_balance(Double.parseDouble(balanceval));

						// } else {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt + 1) +
						// " POL Code should Enter be Correctly";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);
						//
						// }

					}
					objBankReconciliationBean.setBank_account_code(sBankCode);
					alBankDataBean.add(objBankReconciliationBean);
				}
				sMessage = sb.toString();
				if (sMessage.isEmpty()) {
					exportExcelDataToDB(alBankDataBean);
				}
			} else if (fileName.endsWith("xlsx")) {
				wb_xssf = new XSSFWorkbook(file.getInputStream());
				sheet1 = wb_xssf.getSheetAt(0);
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
				int lastRow = sheet1.getLastRowNum();
				String sDateCheck = "";
				for (int rowCount = 12; rowCount <= sheet1.getLastRowNum(); rowCount++) {
					objBankReconciliationBean = new BankReconciliationBean();
					XSSFRow row = (XSSFRow) sheet1.getRow(rowCount);
					/* (lastRow-1) != rowCount && lastRow != rowCount */
					/*
					 * if (rowCount > 1 && stopExec == 0) { Cell date = row.getCell(0); sDateCheck =
					 * date.getStringCellValue().trim(); if (sDateCheck.startsWith("*") &&
					 * sDateCheck.startsWith("")) { stopExec = rowCount; } if (stopExec == 0) { if
					 * (date.getCellType() == 3) { sb.append("Row - " + (rowCount + 1) +
					 * " : Date should not be empty. "); sb.append("<br>"); } else { try {
					 * dateFormat.parse(date.toString()); Date date1 =
					 * dateFormat.parse(date.toString());
					 * objBankReconciliationBean.setBank_date(date.toString()); } catch
					 * (ParseException pe) { sb.append("Row - " + (rowCount + 1) +
					 * " : Date Format Should be (DD/MM/YYYY). "); sb.append("<br>"); } } Cell
					 * narration = row.getCell(1); if (narration == null) { sb.append("Row - " +
					 * (rowCount + 1) + " : Narration should not be empty"); sb.append("<br>"); }
					 * else objBankReconciliationBean.setBank_narration(narration.
					 * getStringCellValue(). trim()); Cell refNo = row.getCell(2); if (refNo ==
					 * null) { sb.append("Row - " + (rowCount + 1) +
					 * " : Chq./Ref.No. should not be empty"); sb.append("<br>"); } else if
					 * (refNo.getCellType() == 0) {
					 * objBankReconciliationBean.setBank_cheque_no(refNo. toString()); } else
					 * objBankReconciliationBean.setBank_cheque_no(refNo.
					 * getStringCellValue().trim() ); Cell valueDate = row.getCell(3);
					 * objBankReconciliationBean.setValue_date(valueDate.
					 * getStringCellValue().trim() );
					 * 
					 * int i = jdbcTemplate.queryForObject(BranchQueryUtil.
					 * sCheckBranchCode,Integer.class, branch.getBranchCode().toUpperCase(),
					 * branch.getTenantId());
					 * 
					 * int i1 = jdbcTemplate.queryForObject(BankReconciliationQueryUtil. sCheck,
					 * Integer.class, objBankReconciliationBean.getValue_date(), sBankCode); if (i1
					 * > 0) {
					 * 
					 * sb.append("Row - " + (rowCount + 1) +
					 * " : Value date and Account Code already exist. "); sb.append("<br>"); } if
					 * (valueDate.getCellType() == 3) {
					 * 
					 * sb.append("Row - " + (rowCount + 1) +
					 * " : Value date and Account Code already exist. "); sb.append("<br>"); } else
					 * { try { dateFormat.parse(valueDate.toString()); Date date1 =
					 * dateFormat.parse(valueDate.toString());
					 * objBankReconciliationBean.setValue_date(valueDate. toString()); } catch
					 * (ParseException pe) { sb.append("Row - " + (rowCount + 1) +
					 * " : Date Format Should be (DD/MM/YYYY). "); sb.append("<br>"); } } Cell
					 * withDraw = row.getCell(4); if (withDraw == null || withDraw.getCellType() ==
					 * 3) objBankReconciliationBean.setBank_debit_amt(0); else if
					 * (withDraw.getCellType() == 0) { boolean fail =
					 * (BigDecimal.valueOf(withDraw.getNumericCellValue()).scale () > 2); if (fail)
					 * { objBankReconciliationBean.setBank_debit_amt(Math.round( withDraw.
					 * getNumericCellValue() * 100.0) / 100.0); } else
					 * objBankReconciliationBean.setBank_debit_amt(withDraw. getNumericCellValue());
					 * } else { sb.append("Row - " + (rowCount + 1) +
					 * " : Withdrawal Amount should not be text "); sb.append("<br>"); } Cell
					 * depositAmt = row.getCell(5); if (depositAmt == null ||
					 * depositAmt.getCellType() == 3)
					 * objBankReconciliationBean.setBank_credit_amt(0); else if
					 * (depositAmt.getCellType() == 0) { boolean fail =
					 * (BigDecimal.valueOf(depositAmt.getNumericCellValue()). scale() > 2); if
					 * (fail) { objBankReconciliationBean.setBank_credit_amt(Math.round( depositAmt.
					 * getNumericCellValue() * 100.0) / 100.0); } else
					 * objBankReconciliationBean.setBank_credit_amt(depositAmt.
					 * getNumericCellValue() ); } else { sb.append("Row - " + (rowCount + 1) +
					 * " : Deposit Amount should not be text "); sb.append("<br>"); } Cell
					 * closingBal = row.getCell(6); if (closingBal == null ||
					 * closingBal.getCellType() == 3)
					 * objBankReconciliationBean.setBank_closing_balance(0); else if
					 * (closingBal.getCellType() == 0) { boolean fail =
					 * (BigDecimal.valueOf(closingBal.getNumericCellValue()). scale() > 2); if
					 * (fail) { objBankReconciliationBean.setBank_closing_balance(Math.
					 * round(closingBal. getNumericCellValue() * 100.0) / 100.0); } else
					 * objBankReconciliationBean.setBank_closing_balance( closingBal.
					 * getNumericCellValue()); } else { sb.append("Row - " + (rowCount + 1) +
					 * " : Deposit Amount should not be text "); sb.append("<br>"); }
					 * objBankReconciliationBean.setBank_account_code(sBankCode) ;
					 * alBankDataBean.add(objBankReconciliationBean); }
					 * 
					 * }
					 */

					Cell transactionDate = row.getCell(0);
					if (transactionDate == null || transactionDate.getCellType() == Cell.CELL_TYPE_BLANK) {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt +1)
						// + " POL Code should not be empty";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);

					} else {
						// boolean success =
						// getPOLCount(pol.getStringCellValue());
						// if (success == true) {
						SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

						objBankReconciliationBean.setBank_date(df.format(transactionDate.getDateCellValue()).toString());

						// } else {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt + 1) +
						// " POL Code should Enter be Correctly";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);
						//
						// }

					}

					Cell valuedate = row.getCell(1);
					if (valuedate == null || valuedate.getCellType() == Cell.CELL_TYPE_BLANK) {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt +1)
						// + " POL Code should not be empty";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);

					} else {
						// boolean success =
						// getPOLCount(pol.getStringCellValue());
						// if (success == true) {
						// objBankReconciliationBean.setValue_date(valuedate.getStringCellValue());
						SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

						objBankReconciliationBean.setValue_date(df.format(valuedate.getDateCellValue()).toString());

						// } else {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt + 1) +
						// " POL Code should Enter be Correctly";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);
						//
						// }

					}

					Cell chequeNo = row.getCell(3);
					if (chequeNo == null || chequeNo.getCellType() == Cell.CELL_TYPE_BLANK) {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt +1)
						// + " POL Code should not be empty";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);

					} else {
						// boolean success =
						// getPOLCount(pol.getStringCellValue());
						// if (success == true) {
						if (chequeNo.getCellType() == 0) {
							double checque = chequeNo.getNumericCellValue();
							String cheque[] = String.valueOf(checque).split("\\.");
							objBankReconciliationBean.setBank_cheque_no(cheque[0]);
						} else if (chequeNo.getCellType() == 1) {
							objBankReconciliationBean.setBank_cheque_no(chequeNo.getStringCellValue());
						}
						boolean success = getChequeNo(objBankReconciliationBean.getBank_cheque_no());
						if (!success) {
							sMessage = "Cheque No is mismatched in cashbank payment";
							// throw new Exception(sMessage);
						}
						// } else {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt + 1) +
						// " POL Code should Enter be Correctly";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);
						//
						// }

					}

					Cell narration = row.getCell(4);
					if (narration == null || narration.getCellType() == Cell.CELL_TYPE_BLANK) {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt +1)
						// + " POL Code should not be empty";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);

					} else {
						// boolean success =
						// getPOLCount(pol.getStringCellValue());
						// if (success == true) {
						objBankReconciliationBean.setBank_narration(narration.getStringCellValue());

						// } else {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt + 1) +
						// " POL Code should Enter be Correctly";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);
						//
						// }

					}

					Cell debit = row.getCell(5);
					if (debit == null || debit.getCellType() == Cell.CELL_TYPE_BLANK) {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt +1)
						// + " POL Code should not be empty";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);

					} else {
						// boolean success =
						// getPOLCount(pol.getStringCellValue());
						// if (success == true) {
						objBankReconciliationBean.setBank_debit_amt(debit.getNumericCellValue());

						// } else {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt + 1) +
						// " POL Code should Enter be Correctly";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);
						//
						// }

					}

					Cell credit = row.getCell(6);
					if (credit == null || credit.getCellType() == Cell.CELL_TYPE_BLANK) {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt +1)
						// + " POL Code should not be empty";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);

					} else {
						// boolean success =
						// getPOLCount(pol.getStringCellValue());
						// if (success == true) {
						objBankReconciliationBean.setBank_credit_amt(credit.getNumericCellValue());

						// } else {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt + 1) +
						// " POL Code should Enter be Correctly";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);
						//
						// }

					}

					Cell balance = row.getCell(7);
					if (balance == null || balance.getCellType() == Cell.CELL_TYPE_BLANK) {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt +1)
						// + " POL Code should not be empty";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);

					} else {
						// boolean success =
						// getPOLCount(pol.getStringCellValue());
						// if (success == true) {
						String balanceval = balance.getStringCellValue();
						balanceval = balanceval.replaceAll(",", "");
						objBankReconciliationBean.setBank_closing_balance(Double.parseDouble(balanceval));

						// } else {
						// error = error + "\n" + "Sheet No " + (no + 1) + " " +
						// "Row" + (rowCnt + 1) +
						// " POL Code should Enter be Correctly";
						// System.out.println(error);
						// resultbean.setMessage(error);
						// throw new Exception(error);
						//
						// }

					}
					objBankReconciliationBean.setBank_account_code(sBankCode);
					alBankDataBean.add(objBankReconciliationBean);
				}
				sMessage = sb.toString();
				if (sMessage.isEmpty()) {
					exportExcelDataToDB(alBankDataBean);
				}
			} else {
				System.out.println("Not a valid file format");
			}

		} catch (Exception e) {
			e.printStackTrace();
			String error[] = String.valueOf(ExceptionUtils.getRootCauseMessage(e)).split(":");
			sMessage = error[0] + "-" + error[1];

		}

		return sMessage;
	}

	private boolean getChequeNo(String bank_cheque_no) {
		boolean success = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int Bank_stmt_id = jdbcTemplate.queryForObject(BankReconciliationQueryUtil.CHECK_CHEQUE_NO, Integer.class, bank_cheque_no);
		if (Bank_stmt_id > 0) {
			success = true;
		} else {
			success = false;
		}
		return success;
	}

	/*
	 * @Override public String uploadFile(MultipartFile file, String sBankCode) {
	 * 
	 * ArrayList<BankReconciliationBean> alBankDataBean = new
	 * ArrayList<BankReconciliationBean>(); BankReconciliationBean
	 * objBankReconciliationBean = null; String fileName =
	 * file.getOriginalFilename(); Iterator<Row> rowIterator = null; String
	 * datestring = ""; int stopExec = 0; Workbook workbook = null; String sMessage
	 * = ""; StringBuffer sb = new StringBuffer();
	 * 
	 * try { if (fileName.endsWith("xls")) { workbook = new
	 * HSSFWorkbook(file.getInputStream()); HSSFSheet sheet = (HSSFSheet)
	 * workbook.getSheetAt(0); rowIterator = sheet.rowIterator(); } else if
	 * (fileName.endsWith("xlsx")) { workbook = new
	 * XSSFWorkbook(file.getInputStream()); XSSFSheet sheet = (XSSFSheet)
	 * workbook.getSheetAt(0); rowIterator = sheet.rowIterator(); } else {
	 * System.out.println("Not a valid file format"); }
	 * 
	 * SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	 * 
	 * int rowCnt = 0; while (rowIterator.hasNext()) { Row row = rowIterator.next();
	 * rowCnt += 1; if (stopExec != 0) { break; } if (rowCnt > 2) { Iterator<Cell>
	 * cellIterator = row.cellIterator(); String sDateCheck = "";
	 * objBankReconciliationBean = new BankReconciliationBean(); while
	 * (cellIterator.hasNext()) { Cell cell = cellIterator.next(); switch
	 * (cell.getCellType()) {
	 * 
	 * case Cell.CELL_TYPE_STRING: if (cell.getColumnIndex() == 0) { sDateCheck =
	 * cell.getStringCellValue().trim(); } if (!sDateCheck.startsWith("*")) { if
	 * (cell.getColumnIndex() == 0) { datestring = cell.getStringCellValue().trim();
	 * if (!datestring.startsWith("*")){ if(cell == null || cell.equals("")){
	 * sb.append(" row -" + (rowCnt) + " : Date is empty. "); sb.append("<br>");
	 * }else{ try{ dateFormat.parse(sDateCheck);
	 * objBankReconciliationBean.setBank_date(datestring); }catch(ParseException
	 * pe){ sb.append(" row- " + (rowCnt) +
	 * " : Date Format Should be (DD/MM/YYYY). "); sb.append("<br>"); } } } }
	 * 
	 * else if (cell.getColumnIndex() == 1) {
	 * objBankReconciliationBean.setBank_narration(cell.getStringCellValue().
	 * trim()); } else if (cell.getColumnIndex() == 2) {
	 * objBankReconciliationBean.setBank_cheque_no(cell.getStringCellValue().
	 * trim()); } else if (cell.getColumnIndex() == 3) { datestring =
	 * cell.getStringCellValue().trim(); if(cell == null || cell.equals("")){
	 * sb.append(" row -" + (rowCnt) + " : Value Date is empty. ");
	 * sb.append("<br>"); }else{ try{ dateFormat.parse(sDateCheck);
	 * objBankReconciliationBean.setBank_date(datestring); }catch(ParseException
	 * pe){ sb.append(" row- " + (rowCnt) +
	 * " : Value Date Format Should be (DD/MM/YYYY). "); sb.append("<br>"); } }
	 * objBankReconciliationBean.setBank_date(datestring); } }
	 * 
	 * 
	 * case Cell.CELL_TYPE_NUMERIC: if (sDateCheck != "" &&
	 * !sDateCheck.startsWith("*")) { if (cell.getColumnIndex() == 4) {
	 * objBankReconciliationBean.setBank_debit_amt(cell.getNumericCellValue()); }
	 * else if (cell.getColumnIndex() == 5) {
	 * objBankReconciliationBean.setBank_credit_amt(cell.getNumericCellValue()); }
	 * else if (cell.getColumnIndex() == 6) {
	 * objBankReconciliationBean.setBank_closing_balance(cell.
	 * getNumericCellValue()); } else if (cell.getColumnIndex() == 2) {
	 * cell.setCellType(Cell.CELL_TYPE_STRING);
	 * objBankReconciliationBean.setBank_cheque_no(cell.getStringCellValue().
	 * trim()); } }
	 * 
	 * case Cell.CELL_TYPE_BLANK:
	 * System.out.println("blank"+rowCnt+"***************");
	 * 
	 * break; } if (sDateCheck.startsWith("*")) { stopExec = rowCnt; break; } } //
	 * end of cell iterator if (sDateCheck != "" && !sDateCheck.startsWith("*")) {
	 * objBankReconciliationBean.setBank_account_code(sBankCode);
	 * alBankDataBean.add(objBankReconciliationBean); }
	 * 
	 * } else { // do nothing }
	 * 
	 * } exportExcelDataToDB(alBankDataBean); sMessage = sb.toString(); } catch
	 * (Exception e) { e.printStackTrace(); }
	 * 
	 * return sMessage; }
	 */

	public void exportExcelDataToDB(ArrayList<BankReconciliationBean> alBankDataList) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			for (BankReconciliationBean objBankReconciliationBean : alBankDataList) {

				jdbcTemplate.update(BankReconciliationQueryUtil.INSERTBANKSTATEMENT, new Object[] { objBankReconciliationBean.getBank_date(), objBankReconciliationBean.getBank_cheque_no(), objBankReconciliationBean.getValue_date(), objBankReconciliationBean.getBank_debit_amt(), objBankReconciliationBean.getBank_credit_amt(), objBankReconciliationBean.getBank_closing_balance(), objBankReconciliationBean.getBank_narration(), "Bank Statement", objBankReconciliationBean.getBank_account_code() });
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public BankReconciliationResultBean getDifferenceList(int limit, int offset, String sFromDate, String sToDate, String sBankCode) throws CustomException {
		BankReconciliationResultBean resultbean = new BankReconciliationResultBean();
		List<BankReconciliationBean> lDifferenceList = new ArrayList<>();
		List<BankReconciliationBean> lDifferenceListBook = new ArrayList<>();
		List<BankReconciliationBean> lDifferenceListBank = new ArrayList<>();
		BankReconciliationBean bean = new BankReconciliationBean();
		List<BankReconciliationBean> lDifferenceListFormatted = new ArrayList<>();
		try {

			double bankbalanceasperbank = 0;
			double balanceAsPerBook = 0;
			double bankbalanceasperbankUsd = 0;

			double differencePayment = 0;
			double differenceReceipt = 0;
			Integer count = 0;
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (sBankCode == "") {
				// lDifferenceList =
				// jdbcTemplate.query(BankReconciliationQueryUtil.GET_DIFFERENCE_LIST,
				// new
				// Object[] { sFromDate, sToDate }, new
				// BeanPropertyRowMapper<>(BankReconciliationBean.class));
				// lDifferenceListBook =
				// jdbcTemplate.query(BankReconciliationQueryUtil.GET_DIFFERENCE_LIST,
				// new
				// Object[] { sFromDate, sToDate }, new
				// BeanPropertyRowMapper<>(BankReconciliationBean.class));
				lDifferenceList = jdbcTemplate.query(BankReconciliationQueryUtil.GET_DIFFERENCE_LIST_WITH_BANK_NEW1, new Object[] { sFromDate, sToDate, sBankCode }, new BeanPropertyRowMapper<>(BankReconciliationBean.class));
				// lDifferenceListBook =
				// jdbcTemplate.query(BankReconciliationQueryUtil.GET_DIFFERENCE_LIST_WITH_BOOK1,
				// new Object[] { sFromDate, sToDate }, new
				// BeanPropertyRowMapper<>(BankReconciliationBean.class));

			} else {
				lDifferenceList = jdbcTemplate.query(BankReconciliationQueryUtil.GET_DIFFERENCE_LIST_WITH_BANK_NEW, new Object[] { sFromDate, sToDate, sBankCode }, new BeanPropertyRowMapper<>(BankReconciliationBean.class));
				// lDifferenceListBook =
				// jdbcTemplate.query(BankReconciliationQueryUtil.GET_DIFFERENCE_LIST_WITH_BOOK,
				// new Object[] { sFromDate, sToDate, sBankCode }, new
				// BeanPropertyRowMapper<>(BankReconciliationBean.class));

			}

			String bank_reco_old = "select * from bank_reco_bank('" + sFromDate + "','" + sToDate + "','" + sBankCode + "')";

			// "select
			// coalesce(sum(coalesce(book_debit_amt,0)),0)-coalesce(sum(coalesce(book_credit_amt,0)),0)
			// as bankBalanceAsPerBank\n" + "from bank_reconcile_stmt where
			// bank_account_code='10060034' and bank_date::date between
			// to_date('" +
			// sFromDate + "','dd/mm/yyyy')\n" + "and to_date('" + sToDate +
			// "','dd/mm/yyyy')";
			System.out.println("query " + bank_reco_old);
			Double bankbal = jdbcTemplate.queryForObject(BankReconciliationQueryUtil.get_bank, new Object[] { sFromDate, sToDate, sBankCode }, Double.class);

			bankbalanceasperbank = bankbal;

			String book_reco_old = "select * from bank_reco_book('" + sFromDate + "','" + sToDate + "','" + sBankCode + "')";

			// "select
			// coalesce(sum(coalesce(book_debit_amt,0)),0)-coalesce(sum(coalesce(book_credit_amt,0)),0)
			// as balanceAsPerBook\n" + "from bank_reconcile_stmt where
			// bank_account_code='10060034' and bank_date::date between
			// to_date('" +
			// sFromDate + "','dd/mm/yyyy')\n" + "and to_date('" + sToDate +
			// "','dd/mm/yyyy')";

			Double bookbal = jdbcTemplate.queryForObject(BankReconciliationQueryUtil.get_bank, new Object[] { sFromDate, sToDate, sBankCode }, Double.class);

			balanceAsPerBook = bookbal;

			String unrecopayment = "select sum(book_credit_amt) from bank_reconcile_stmt";
			String unrecopaymentCount = "select count(*) from bank_reconcile_stmt";
			int urRecobalCount = jdbcTemplate.queryForObject(unrecopaymentCount, new Object[] {}, Integer.class);
			if (urRecobalCount > 0) {
				Double urRecobal = jdbcTemplate.queryForObject(BankReconciliationQueryUtil.get_reconciled_payment, new Object[] { sFromDate, sToDate, sBankCode }, Double.class);

				differencePayment = urRecobal;
			}

			String unrecoreceipt = "select sum(book_debit_amt) from bank_reconcile_stmt";
			String unrecoreceiptCount = "select count(*) from bank_reconcile_stmt";

			int urRecorecCount = jdbcTemplate.queryForObject(unrecoreceiptCount, new Object[] {}, Integer.class);
			if (urRecorecCount > 0) {
				Double urRecorec = jdbcTemplate.queryForObject(BankReconciliationQueryUtil.get_reconciled_receipt, new Object[] { sFromDate, sToDate, sBankCode }, Double.class);

				differenceReceipt = urRecorec;
			}
			// bankbalanceasperbankUsd = bean.getBalanceAsPerBankUsd();
			/*
			 * for (BankReconciliationBean objBankReconciliationBean : lDifferenceList) {
			 * objBankReconciliationBean.setBank_date(CommonUtil.
			 * convertSqlDateFormate(objBankReconciliationBean.getBank_date()));
			 * objBankReconciliationBean.setBook_cheque_date(CommonUtil.
			 * convertSqlDateFormate(objBankReconciliationBean. getBook_cheque_date()));
			 * lDifferenceListFormatted.add(objBankReconciliationBean); }
			 */
			// resultbean.setlBankStatementList(lDifferenceListBank);
			// resultbean.setlBookStatementList(lDifferenceListBook);
			resultbean.setlDifferenceResultList(lDifferenceList);
			resultbean.setBankBalanceAsPerBank(bankbalanceasperbank);
			resultbean.setBalanceAsPerBook(balanceAsPerBook);
			resultbean.setDifferencePayment(differencePayment);
			resultbean.setDifferenceReceipt(differenceReceipt);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Difference List", e);
		}
		return resultbean;
	}

	// normal reconcil
	@Override
	public String reconcileRecords(List<BankReconciliationBean> alReconciledRecords) {
		String message = "";

		DateFormat formatter = null;
		// java.sql.Timestamp timeStampDate;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			for (BankReconciliationBean objBankReconciliationBean : alReconciledRecords) {

				jdbcTemplate.update(BankReconciliationQueryUtil.INSERT_RECONCILE_STMT, new Object[] { objBankReconciliationBean.getTransaction_no(), objBankReconciliationBean.getBook_cheque_date(), objBankReconciliationBean.getBook_cheque_no(), objBankReconciliationBean.getBook_debit_amt(), objBankReconciliationBean.getBook_credit_amt(), objBankReconciliationBean.getBank_cheque_no(), objBankReconciliationBean.getBank_date(), objBankReconciliationBean.getBank_debit_amt(), objBankReconciliationBean.getBank_credit_amt(),
						objBankReconciliationBean.getRemarks(), objBankReconciliationBean.getBank_stmt_id(), objBankReconciliationBean.getBank_code(), objBankReconciliationBean.getCustomer() });
				message = "true";

			}

		} catch (Exception e) {
			LOGGER.error("Error in inserting into the bank table", e);
		}
		return message;

	}

	@Override
	public String excludedRecords(BankReconciliationBean reconcileRecords) {
		DateFormat formatter = null;
		BankReconciliationBean bankreconciliation = new BankReconciliationBean();
		// java.sql.Timestamp timeStampDate;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String message = "";
		int bankdraftno = 0;
		BankReconciliationBean beanlog = new BankReconciliationBean();

		try {
			beanlog.setTableName("bank_reconcile_stmt");
			beanlog.setFormCode("F5188");

			/*
			 * bankreconciliation.setTableName("bank_reconcile_stmt");
			 * bankreconciliation.setFormCode("F5188");
			 */
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			// objBankReconciliationBean.setBank_date(CommonUtil.convertSqlDateFormate(objBankReconciliationBean.getBank_date()));
			// objBankReconciliationBean.setBook_cheque_date(CommonUtil.convertSqlDateFormate(objBankReconciliationBean.getBook_cheque_date()));

			// Date date =
			// formatter.parse(objBankReconciliationBean.getBank_date());
			// timeStampDate = new Timestamp(date.getTime());
			// System.out.println("timeStampDate" + timeStampDate);
			if (reconcileRecords.getDifferenceReceipt() == null) {
				reconcileRecords.setDifferenceReceipt(0.00);
			}
			if (reconcileRecords.getDifferencePayment() == null) {
				reconcileRecords.setDifferencePayment(0.00);
			}
			System.out.println("COMING INSIDE SAVE");
			bankdraftno = jdbcTemplate.update(BankReconciliationQueryUtil.INSERT_EXCLUDED_STMT, new Object[] { reconcileRecords.getTransactionNo(), reconcileRecords.getChqDt(), reconcileRecords.getChqNo(), reconcileRecords.getDebitamount(), reconcileRecords.getCreditamount(), reconcileRecords.getSupplier(), reconcileRecords.getTransactionType(), reconcileRecords.getNarration(), reconcileRecords.getDoctype(), reconcileRecords.getDocdate(), reconcileRecords.getRemarks(), reconcileRecords.getBalanceAsPerBank(), reconcileRecords.getBalanceAsPerBook(),
					reconcileRecords.getDifference(), reconcileRecords.getBank_account_code(), reconcileRecords.getToDate(), reconcileRecords.getFromDate(), reconcileRecords.getDifferenceReceipt(), reconcileRecords.getDifferencePayment() });
			userlogDao.userLogForInsert(beanlog, bankdraftno + "", userDetails.getUserId());

		} catch (Exception e) {
			LOGGER.error("Error in inserting into the bank excluded table", e);
		}
		return message;

	}

	@Override
	public String reconcileRecordsDraft(List<BankReconciliationBean> alReconciledRecords) {
		String message = "";
		BankReconciliationBean beanlog = new BankReconciliationBean();
		int bankdraftno = 0;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			beanlog.setTableName("bank_reconcile_stmt_draft");
			beanlog.setFormCode("F5188");
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			for (BankReconciliationBean objBankReconciliationBean : alReconciledRecords) {
				int total = jdbcTemplate.queryForObject(BankReconciliationQueryUtil.GET_DRAFT_COUNT, new Object[] { objBankReconciliationBean.getTransaction_no() }, Integer.class);
				// objBankReconciliationBean.setBank_date(CommonUtil.convertSqlDateFormate(objBankReconciliationBean.getBank_date()));
				// objBankReconciliationBean.setBook_cheque_date(CommonUtil.convertSqlDateFormate(objBankReconciliationBean.getBook_cheque_date()));
				System.out.println("total" + total);
				if (total == 0) {
					if (objBankReconciliationBean.getDifferenceReceipt() == null) {
						objBankReconciliationBean.setDifferenceReceipt(0.00);
					}
					if (objBankReconciliationBean.getDifferencePayment() == null) {
						objBankReconciliationBean.setDifferencePayment(0.00);
					}
					bankdraftno = jdbcTemplate.update(BankReconciliationQueryUtil.INSERT_RECONCILE_STMT_DRAFTS, new Object[] { objBankReconciliationBean.getTransactionNo(), objBankReconciliationBean.getChqDt(), objBankReconciliationBean.getChqNo(), objBankReconciliationBean.getDebitamount(), objBankReconciliationBean.getCreditamount(), objBankReconciliationBean.getSupplier(), objBankReconciliationBean.getTransactionType(), objBankReconciliationBean.getNarration(), objBankReconciliationBean.getDoctype(), objBankReconciliationBean.getDocdate(),
							objBankReconciliationBean.getBank_date(), objBankReconciliationBean.getRemarks(), objBankReconciliationBean.getBalanceAsPerBank(), objBankReconciliationBean.getBalanceAsPerBook(), objBankReconciliationBean.getDifference(), objBankReconciliationBean.getBank_account_code(), objBankReconciliationBean.getToDate(), objBankReconciliationBean.getFromDate(), objBankReconciliationBean.getDifferenceReceipt(), objBankReconciliationBean.getDifferencePayment() });

					// userlogDao.userLogForInsert(beanlog, bankdraftno + "",
					// userDetails.getUserId());
				} else {
					message = "The selected records are available in drafts ";

				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in inserting into the bank reco table", e);
		}

		return message;

	}

	@Override
	public List<BankReconciliationBean> getReconcileList(int limit, int offset, String sFromDate, String sToDate, String sBankCode) throws CustomException {
		List<BankReconciliationBean> lReconcileList = new ArrayList<>();
		List<BankReconciliationBean> lReconcileListFormatted = new ArrayList<>();
		BankReconciliationBean bean = new BankReconciliationBean();
		try {
			double bankbalanceasperbank = 0;
			double balanceAsPerBook = 0;
			double bankbalanceasperbankUsd = 0;
			Integer count = 0;
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String query = "select transaction_no,book_cheque_no,customer,book_cheque_date as book_date,book_credit_amt,book_debit_amt ,bank_cheque_no, bank_date,bank_debit_amt,bank_credit_amt,remarks,book_statement_id, bank_account_code    from bank_reconcile_stmt where bank_date between TO_DATE ('" + sFromDate + "', 'DD-MM-YYYY') AND TO_DATE ('" + sToDate + "', 'DD-MM-YYYY') and BANK_ACCOUNT_CODE = '" + sBankCode + "'";
			System.out.println("sFromDate-" + sFromDate + "todate---" + sToDate + "sBankCode=--" + sBankCode);
			lReconcileList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(BankReconciliationBean.class));

			Integer getcount = jdbcTemplate.queryForObject(BankReconciliationQueryUtil.GET_COUNT, new Object[] { sToDate, sBankCode }, (Integer.class));

			if (getcount > 0) {
				bean = jdbcTemplate.queryForObject(BankReconciliationQueryUtil.get_Bank_balance_book_balance_new, new BeanPropertyRowMapper<>(BankReconciliationBean.class), sToDate, sBankCode);

			} else {

				bean = jdbcTemplate.queryForObject(BankReconciliationQueryUtil.get_Bank_balance_book_balance, new BeanPropertyRowMapper<>(BankReconciliationBean.class), sToDate, sBankCode);

			}

			bankbalanceasperbank = bean.getBankBalanceAsPerBank();
			balanceAsPerBook = bean.getBankBalanceAsPerBook();
			bankbalanceasperbankUsd = bean.getBalanceAsPerBankUsd();

			if (lReconcileList.size() > 0) {
				lReconcileList.get(0).setBalanceAsPerBank(bankbalanceasperbank);
				lReconcileList.get(0).setBalanceAsPerBook(balanceAsPerBook);
				lReconcileList.get(0).setBalanceAsPerBankUsd(bankbalanceasperbankUsd);
				lReconcileList.get(0).setDifference(balanceAsPerBook - bankbalanceasperbank);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lReconcileList;
	}

	@Override
	public List<BankReconciliationBean> getReconcileListDraft(int limit, int offset, String sFromDate, String sToDate, String sBankCode) throws CustomException {
		List<BankReconciliationBean> lReconcileList = new ArrayList<>();
		boolean isAvailable = false;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			lReconcileList = jdbcTemplate.query(BankReconciliationQueryUtil.GET_RECONCILE_LIST_Draft, new Object[] { sFromDate, sToDate },

					new BeanPropertyRowMapper<>(BankReconciliationBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lReconcileList;
	}

	@Override
	public BankReconciliationBean getReconcileListDraft1(int limit, int offset, String sFromDate, String sToDate, String sBankCode) {
		List<BankReconciliationBean> lReconcileList = new ArrayList();
		BankReconciliationBean objBankReconciliationBean = new BankReconciliationBean();
		BankReconciliationResultBean bankReconciliationResultBean = new BankReconciliationResultBean();

		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lReconcileList = jdbcTemplate.query(BankReconciliationQueryUtil.GET_RECONCILE_LIST_Draft, new Object[] { sFromDate, sToDate },

					new BeanPropertyRowMapper<>(BankReconciliationBean.class));
			if (lReconcileList.size() > 0) {
				for (int i = 0; i < lReconcileList.size(); i++) {
					if (lReconcileList.get(i).getCreditamount() == 0.0 || lReconcileList.get(i).getCreditamount() == 0.00 || lReconcileList.get(i).getCreditamount() == 0) {
						lReconcileList.get(i).setCreditamount1("0.0");
					} else {
						DecimalFormat IndianCurrencyFormat = new DecimalFormat("#,##,##,###.00");
						String value = IndianCurrencyFormat.format(lReconcileList.get(i).getCreditamount());
						lReconcileList.get(i).setCreditamount1(value);
					}

				}
				for (int i = 0; i < lReconcileList.size(); i++) {
					if (lReconcileList.get(i).getDebitamount() == 0.0 || lReconcileList.get(i).getDebitamount() == 0.00 || lReconcileList.get(i).getDebitamount() == 0) {
						lReconcileList.get(i).setDebitamount1("0.0");
					} else {
						DecimalFormat IndianCurrencyFormat = new DecimalFormat("#,##,##,###.00");
						String value = IndianCurrencyFormat.format(lReconcileList.get(i).getDebitamount());
						lReconcileList.get(i).setDebitamount1(value);
					}

				}

			}

			objBankReconciliationBean.setlDifferenceResultList1(lReconcileList);
			if (lReconcileList.size() > 0) {
				objBankReconciliationBean.setSuccess(true);
			} else {
				objBankReconciliationBean.setSuccess(false);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in 	Reconcile Draft avaiblity", e);
		}
		return objBankReconciliationBean;

	}

	@Override
	public BankReconciliationBean getReconcileListNew(int limit, int offset, String sFromDate, String sToDate, String bankcode) {
		List<BankReconciliationBean> lReconcileList = new ArrayList();
		BankReconciliationBean objBankReconciliationBean = new BankReconciliationBean();
		BankReconciliationResultBean bankReconciliationResultBean = new BankReconciliationResultBean();
		double bankbalanceasperbank = 0;
		double balanceAsPerBook = 0;
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (bankcode != null && bankcode != "") {
				lReconcileList = jdbcTemplate.query(BankReconciliationQueryUtil.GET_RECONCILE_LIST_New_With_Bank, new Object[] { sFromDate, sToDate, bankcode },

						new BeanPropertyRowMapper<>(BankReconciliationBean.class));
				/*
				 * for(BankReconciliationBean objBankReconciliationBean1 : lReconcileList){
				 * 
				 * }
				 */
				if (lReconcileList.size() > 0) {
					for (int i = 0; i < lReconcileList.size(); i++) {
						if (lReconcileList.get(i).getCreditamount() == 0.0 || lReconcileList.get(i).getCreditamount() == 0.00 || lReconcileList.get(i).getCreditamount() == 0) {
							lReconcileList.get(i).setCreditamount1("0.0");
						} else {
							DecimalFormat IndianCurrencyFormat = new DecimalFormat("#,##,##,###.00");
							String value = IndianCurrencyFormat.format(lReconcileList.get(i).getCreditamount());
							lReconcileList.get(i).setCreditamount1(value);
						}

					}
					for (int i = 0; i < lReconcileList.size(); i++) {
						if (lReconcileList.get(i).getDebitamount() == 0.0 || lReconcileList.get(i).getDebitamount() == 0.00 || lReconcileList.get(i).getDebitamount() == 0) {
							lReconcileList.get(i).setDebitamount1("0.0");
						} else {
							DecimalFormat IndianCurrencyFormat = new DecimalFormat("#,##,##,###.00");
							String value = IndianCurrencyFormat.format(lReconcileList.get(i).getDebitamount());
							lReconcileList.get(i).setDebitamount1(value);
						}

					}

				}
			} else {
				lReconcileList = jdbcTemplate.query(BankReconciliationQueryUtil.GET_RECONCILE_LIST_New, new Object[] { sFromDate, sToDate },

						new BeanPropertyRowMapper<>(BankReconciliationBean.class));
				if (lReconcileList.size() > 0) {
					for (int i = 0; i < lReconcileList.size(); i++) {
						if (lReconcileList.get(i).getCreditamount() == 0.0 || lReconcileList.get(i).getCreditamount() == 0.00 || lReconcileList.get(i).getCreditamount() == 0) {
							lReconcileList.get(i).setCreditamount1("0.0");
						} else {
							DecimalFormat IndianCurrencyFormat = new DecimalFormat("#,##,##,###.00");
							String value = IndianCurrencyFormat.format(lReconcileList.get(i).getCreditamount());
							lReconcileList.get(i).setCreditamount1(value);
						}

					}
					for (int i = 0; i < lReconcileList.size(); i++) {
						if (lReconcileList.get(i).getDebitamount() == 0.0 || lReconcileList.get(i).getDebitamount() == 0.00 || lReconcileList.get(i).getDebitamount() == 0) {
							lReconcileList.get(i).setDebitamount1("0.0");
						} else {
							DecimalFormat IndianCurrencyFormat = new DecimalFormat("#,##,##,###.00");
							String value = IndianCurrencyFormat.format(lReconcileList.get(i).getDebitamount());
							lReconcileList.get(i).setDebitamount1(value);
						}

					}

				}

			}

			objBankReconciliationBean.setlDifferenceResultList1(lReconcileList);
			if (lReconcileList.size() > 0) {
				int getcount = jdbcTemplate.queryForObject(BankReconciliationQueryUtil.GET_COUNT, new Object[] { sToDate, bankcode }, (int.class));
				BankReconciliationBean bean = new BankReconciliationBean();
				if (getcount > 0) {
					bean = jdbcTemplate.queryForObject(BankReconciliationQueryUtil.get_Bank_balance_book_balance_new, new BeanPropertyRowMapper<>(BankReconciliationBean.class), sToDate, bankcode);

				} else {
					bean = jdbcTemplate.queryForObject(BankReconciliationQueryUtil.get_Bank_balance_book_balance, new BeanPropertyRowMapper<>(BankReconciliationBean.class), sToDate, bankcode);

				}

				// bean=
				// jdbcTemplate.queryForObject(BankReconciliationQueryUtil.get_Bank_balance_book_balance,
				// new Object[]
				// {sToDate,sBankCode},(BankReconciliationBean.class));
				bankbalanceasperbank = bean.getBankBalanceAsPerBank();
				balanceAsPerBook = bean.getBankBalanceAsPerBook();

				// if(count == 0){
				// bankbalanceasperbank =
				// jdbcTemplate.queryForObject(BankReconciliationQueryUtil.Get_balance_as_per_bank_With_Bank,
				// new Object[] {sBankCode},(double.class));
				//
				// //closingBal =
				// jdbcTemplate.queryForObject(BankReconciliationQueryUtil.Get_Sum_Reconcile_With_Bank,
				// new Object[] {sFromDate, sToDate,sBankCode},(double.class));
				// balanceAsPerBook =
				// jdbcTemplate.queryForObject(BankReconciliationQueryUtil.Get_balance_as_per_book_With_Bank,
				// new Object[] {sBankCode},(double.class));
				// }
				// else{
				// balanceAsPerBook =
				// jdbcTemplate.queryForObject(BankReconciliationQueryUtil.Get_balance_as_per_book_With_Bank_New,
				// new Object[] {sBankCode},(double.class));
				// //balanceAsPerBook =
				// jdbcTemplate.queryForObject(BankReconciliationQueryUtil.Get_balance_as_per_book,
				// new Object[] {sFromDate, sToDate},(double.class));
				// bankbalanceasperbank =
				// jdbcTemplate.queryForObject(BankReconciliationQueryUtil.Get_balance_as_per_bank_With_Bank_New,
				// new Object[] {sBankCode},(double.class));
				// }
				if (lReconcileList.size() > 0) {
					lReconcileList.get(0).setBalanceAsPerBank(bankbalanceasperbank);
					lReconcileList.get(0).setBalanceAsPerBook(balanceAsPerBook);
					lReconcileList.get(0).setDifference(balanceAsPerBook - bankbalanceasperbank);
				}
				objBankReconciliationBean.setSuccess(true);
			} else {
				objBankReconciliationBean.setSuccess(false);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in 	Reconcile Draft avaiblity", e);
		}
		return objBankReconciliationBean;

	}

	@Override
	public BankReconciliationBean getReconcileListDraft2(int limit, int offset, String sFromDate, String sToDate, String sBankCode) {
		List lReconcileList = new ArrayList();
		BankReconciliationBean objBankReconciliationBean = new BankReconciliationBean();
		BankReconciliationResultBean bankReconciliationResultBean = new BankReconciliationResultBean();

		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lReconcileList = jdbcTemplate.query(BankReconciliationQueryUtil.GET_RECONCILE_LIST_Draft, new Object[] { sFromDate, sToDate, sBankCode },

					new BeanPropertyRowMapper<>(BankReconciliationBean.class));

			objBankReconciliationBean.setlDifferenceResultList1(lReconcileList);
			if (lReconcileList.size() > 0) {
				objBankReconciliationBean.setSuccess(true);
			} else {
				objBankReconciliationBean.setSuccess(false);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in 	Reconcile Draft avaiblity", e);
		}
		return objBankReconciliationBean;

	}

	@Override
	public boolean getStatementAvaiablity(String sFromDate, String sToDate, String sBankCode) {

		List lStatementList = new ArrayList();
		boolean isAvailable = false;
		try {
			System.out.println("***********8sBankCode");
			System.out.println(sBankCode);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lStatementList = jdbcTemplate.queryForList(BankReconciliationQueryUtil.GET_STATEMENT_AVAILABLITY, new Object[] { sFromDate, sToDate, sBankCode });

			if (lStatementList.size() > 0) {
				isAvailable = true;
			} else {
				isAvailable = false;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in statement avaiblity", e);
		}
		return isAvailable;
	}

	@Override
	public BankReconciliationResultBean getunReconcileBookAndBankStatement(String sFromDate, String sToDate, String sBankCode) {
		System.out.println("GET DIFFERENCES FOR MANUAL ALLOCATION");
		BankReconciliationResultBean objBankReconciliationResultBean = new BankReconciliationResultBean();
		List<BankReconciliationBean> lBankStatementList = new ArrayList<>();
		List<BankReconciliationBean> lBookStatementList = new ArrayList<>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (sBankCode == "") {
				lBookStatementList = jdbcTemplate.query(BankReconciliationQueryUtil.GET_UNRECONCILED_BOOK_LIST, new Object[] { sFromDate, sToDate }, new BeanPropertyRowMapper<>(BankReconciliationBean.class));

				lBankStatementList = jdbcTemplate.query(BankReconciliationQueryUtil.GET_UNRECONCILED_BANK_LIST, new Object[] { sFromDate, sToDate }, new BeanPropertyRowMapper<>(BankReconciliationBean.class));
			} else {
				lBookStatementList = jdbcTemplate.query(BankReconciliationQueryUtil.GET_UNRECONCILED_BOOK_LIST_WITH_BANK, new Object[] { sFromDate, sToDate, sBankCode }, new BeanPropertyRowMapper<>(BankReconciliationBean.class));

				lBankStatementList = jdbcTemplate.query(BankReconciliationQueryUtil.GET_UNRECONCILED_BANK_LIST_WITH_BANK, new Object[] { sFromDate, sToDate, sBankCode }, new BeanPropertyRowMapper<>(BankReconciliationBean.class));
			}

			objBankReconciliationResultBean.setlBankStatementList(lBankStatementList);
			objBankReconciliationResultBean.setlBookStatementList(lBookStatementList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return objBankReconciliationResultBean;
	}

	@Override
	public BankReconciliationBean getBankDetails(String sBankCode) {
		BankReconciliationBean objBankReconciliationBean = new BankReconciliationBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			objBankReconciliationBean = jdbcTemplate.queryForObject(BankReconciliationQueryUtil.GET_BANK_DETAIL, new Object[] { sBankCode }, new BeanPropertyRowMapper<>(BankReconciliationBean.class));

		} catch (

		DataAccessException e)

		{
			LOGGER.error("Error in Reconcile List", e);
		}

		return objBankReconciliationBean;
	}

	@Override
	public String approve(int bank_stmt_id) throws Exception {

		boolean status = true;
		String bool = "";

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// UserDetail userDetails = (UserDetail)
			// SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			jdbcTemplate.update(BankReconciliationQueryUtil.APPROVE_STATEMENT, new Object[] { status, bank_stmt_id });
			jdbcTemplate.update(BankReconciliationQueryUtil.APPROVE_STATEMENT1, new Object[] { status, bank_stmt_id });
			bool = "true";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bool;
	}

	@Override
	public BankReconciliationBean printBankmail(int bank_stmt_id) throws Exception {

		String status = "";
		boolean mail_status = true;

		BankReconciliationBean print = new BankReconciliationBean();
		BankReconciliationBean print1 = new BankReconciliationBean();
		int bankno = 0;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			print = jdbcTemplate.queryForObject(BankReconciliationQueryUtil.PRINT_HEADER1, new BeanPropertyRowMapper<>(BankReconciliationBean.class), bank_stmt_id);

			/*
			 * INSERT INTO BANK_RECONCILE_STMT(transaction_no, book_cheque_date,
			 * book_cheque_no, book_debit_amt, " +
			 * "book_credit_amt, bank_cheque_no, bank_date, " +
			 * "bank_debit_amt, bank_credit_amt, remarks, book_statement_id,bank_account_code) "
			 */
			/*
			 * INSERT INTO BANK_RECONCILE_STMT(transaction_no, book_cheque_date,
			 * book_cheque_no, book_debit_amt, " +
			 * "book_credit_amt, bank_cheque_no, bank_date, bank_debit_amt, bank_credit_amt, remarks, book_statement_id,bank_account_code) "
			 * +
			 * " VALUES(?,to_date(?,'dd/mm/yyyy'),?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?)"
			 * ;
			 */
			bankno = jdbcTemplate.update(BankReconciliationQueryUtil.BANK_RECONCILE_STMTprint, new Object[] { print.getTransaction_no(), print.getBook_cheque_date(), print.getBook_cheque_no(), print.getBook_debit_amt(), print.getBook_credit_amt(), print.getBank_cheque_no(), print.getBank_date(), print.getBank_debit_amt(), print.getBank_credit_amt(), print.getBank_stmt_id(), print.getBank_account_code(), print.getIsActive() });

			if (print.getIsActive() == mail_status) {
				status = "Approved";
			} else {
				status = "Rejected";
			}

			print.setStatus(status);

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return print;
	}

	@Override
	public String reject(int bank_stmt_id) throws Exception {
		// UserDetail userDetails = (UserDetail)
		// SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		boolean status = false;

		String bool = "";
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// UserDetail userDetails = (UserDetail)
			// SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			jdbcTemplate.update(BankReconciliationQueryUtil.REJECT_STATEMENT, new Object[] { status, bank_stmt_id });
			jdbcTemplate.update(BankReconciliationQueryUtil.REJECT_STATEMENT1, new Object[] { status, bank_stmt_id });
			bool = "true";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bool;
	}

	@Override
	public void getmail(HttpServletRequest request) {

	}

	@Override
	public String generateExcel(List<BankReconciliationBean> bean) {
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

			XSSFSheet excelsheet = workbook.createSheet("Bank Reconciliation");
			setExcelMainHeader(excelsheet, mainHeaderStyle);
			setExcelSubHeader(excelsheet, subHeaderStyle);
			setExcelRows(excelsheet, workbook, bean, subHeaderStyle);
			String fileName = null;
			fileName = "BankReconcilation";
			path = writeExcel(workbook, ConfigurationProps.exportFilesPath, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;

	}

	private void setExcelMainHeader(XSSFSheet excelsheet, XSSFCellStyle mainHeaderstyle) {
		Row row = excelsheet.createRow(0);
		excelsheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 16));
		Cell cell = row.createCell((short) 0);
		cell.setCellStyle(mainHeaderstyle);
		cell.setCellValue("Bank Reconciliation");

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
			cell.setCellValue("Customer/Supplier");
			cellcount++;

			Cell cell15 = row.createCell(cellcount);
			cell15.setCellStyle(subHeaderStyle);
			cell15.setCellValue("Cheque No");
			cellcount++;

			Cell cell1 = row.createCell(cellcount);
			cell1.setCellStyle(subHeaderStyle);
			cell1.setCellValue("Cheque Date");
			cellcount++;

			Cell cell2 = row.createCell(cellcount);
			cell2.setCellStyle(subHeaderStyle);
			cell2.setCellValue("Transaction No");
			cellcount++;

			Cell cell3 = row.createCell(cellcount);
			cell3.setCellStyle(subHeaderStyle);
			cell3.setCellValue("Transaction Type");
			cellcount++;

			Cell cell4 = row.createCell(cellcount);
			cell4.setCellStyle(subHeaderStyle);
			cell4.setCellValue("Narration");
			cellcount++;

			Cell cell5 = row.createCell(cellcount);
			cell5.setCellStyle(subHeaderStyle);
			cell5.setCellValue("Doc Type");
			cellcount++;

			Cell cell6 = row.createCell(cellcount);
			cell6.setCellStyle(subHeaderStyle);
			cell6.setCellValue("Doc Date");
			cellcount++;

			Cell cell7 = row.createCell(cellcount);
			cell7.setCellStyle(subHeaderStyle);
			cell7.setCellValue("Credit");
			cellcount++;

			Cell cell8 = row.createCell(cellcount);
			cell8.setCellStyle(subHeaderStyle);
			cell8.setCellValue("Debit");
			cellcount++;

			Cell cell9 = row.createCell(cellcount);
			cell9.setCellStyle(subHeaderStyle);
			cell9.setCellValue("Bank Date");
			cellcount++;

			Cell cell10 = row.createCell(cellcount);
			cell10.setCellStyle(subHeaderStyle);
			cell10.setCellValue("Remarks");
			cellcount++;

		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public void setExcelRows(XSSFSheet excelsheet, XSSFWorkbook workbook, List<BankReconciliationBean> bean, XSSFCellStyle subHeaderStyle) {
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
			int tempCount = 0;

			for (int i = 0; i < bean.size(); i++) {
				Row row = excelsheet.createRow(rCount);
				int count = 0;

				// Cell cell;

				Cell cell = row.createCell(count);
				cell.setCellStyle(my_style2);
				cell.setCellValue(bean.get(i).getSupplier());
				count++;
				Cell cell1 = row.createCell(count);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(bean.get(i).getChqNo());
				count++;
				Cell cell2 = row.createCell(count);
				cell2.setCellStyle(my_style2);
				cell2.setCellValue(bean.get(i).getChqDt());
				count++;
				Cell cell3 = row.createCell(count);
				cell3.setCellStyle(my_style2);
				cell3.setCellValue(bean.get(i).getTransactionNo());
				count++;
				Cell cell4 = row.createCell(count);
				cell4.setCellStyle(my_style2);
				cell4.setCellValue(bean.get(i).getTransactionType());
				count++;
				Cell cell5 = row.createCell(count);
				cell5.setCellStyle(my_style2);
				cell5.setCellValue(bean.get(i).getNarration());
				count++;
				Cell cell6 = row.createCell(count);
				cell6.setCellStyle(my_style2);
				cell6.setCellValue(bean.get(i).getDoctype());
				count++;

				Cell cell7 = row.createCell(count);
				cell7.setCellStyle(my_style2);
				cell7.setCellValue(bean.get(i).getDocdate());
				count++;

				Cell cell8 = row.createCell(count);
				cell8.setCellStyle(my_style2);
				cell8.setCellValue(bean.get(i).getCreditamount1());
				count++;

				Cell cell11 = row.createCell(count);
				cell11.setCellStyle(my_style2);
				cell11.setCellValue(bean.get(i).getDebitamount1());
				count++;

				Cell cell12 = row.createCell(count);
				cell12.setCellStyle(my_style2);
				cell12.setCellValue(bean.get(i).getBank_date());
				count++;

				Cell cell13 = row.createCell(count);
				cell13.setCellStyle(my_style2);
				cell13.setCellValue(bean.get(i).getRemarks());
				count++;

				rCount = rCount + 1;

			}
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int getcount = jdbcTemplate.queryForObject(BankReconciliationQueryUtil.GET_COUNT, new Object[] { bean.get(0).getToDate(), bean.get(0).getBankCode() }, (int.class));
			BankReconciliationBean recoBean = new BankReconciliationBean();
			if (getcount > 0) {
				recoBean = jdbcTemplate.queryForObject(BankReconciliationQueryUtil.get_Bank_balance_book_balance_new, new BeanPropertyRowMapper<>(BankReconciliationBean.class), bean.get(0).getToDate(), bean.get(0).getBankCode());

			} else {
				recoBean = jdbcTemplate.queryForObject(BankReconciliationQueryUtil.get_Bank_balance_book_balance, new BeanPropertyRowMapper<>(BankReconciliationBean.class), bean.get(0).getToDate(), bean.get(0).getBankCode());

			}

			// bean=
			// jdbcTemplate.queryForObject(BankReconciliationQueryUtil.get_Bank_balance_book_balance,
			// new Object[] {sToDate,sBankCode},(BankReconciliationBean.class));

			Row row2 = excelsheet.createRow(rCount);
			Cell cell13 = row2.createCell(9);
			cell13.setCellStyle(my_style2);
			cell13.setCellValue("Balance as per bank");

			Cell cell14 = row2.createCell(10);
			cell14.setCellStyle(my_style2);
			cell14.setCellValue(recoBean.getBankBalanceAsPerBank());
			rCount++;

			Row row1 = excelsheet.createRow(rCount);

			Cell cell16 = row1.createCell(9);
			cell16.setCellStyle(my_style2);
			cell16.setCellValue("Balance as per book");

			Cell cell15 = row1.createCell(10);
			cell15.setCellStyle(my_style2);
			cell15.setCellValue(recoBean.getBankBalanceAsPerBook());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcel(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/BankReconciliation.xls";

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		System.out.println("filepath" + sOutFile);
		try {
			fileOut = new FileOutputStream(sOutFile);
			myWorkBook.write(fileOut);
			url = path + "/BankReconciliation.xls";
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
