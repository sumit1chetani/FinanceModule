package com.dci.tenant.finance.purchasequotation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;
import com.dci.common.util.DefTableBean;
import com.dci.master.settings.UOM.EntityBean;
import com.dci.tenant.common.CommonUtilityDAOImpl;
import com.dci.tenant.finance.storeToStore.StoreToStore;
import com.dci.tenant.user.UserDetail;

@Service
public class PurchaseQuotationServiceImpl implements IPurchaseQuotationService {

	@Autowired
	IPurchaseQuotationDao quotationDao;

/*	@Autowired
	private PurchaseQuotationDaoImpl quotationDao;
*/
	/*@Autowired
	private CommonUtilityDAOImpl commonUtilityService;*/

	@Override
	public List<EntityBean> getVendorList() throws CustomException {
		return quotationDao.getVendorList();
	}

	@Override
	public List<StoreToStore> getRequisitionList() throws CustomException {
		return quotationDao.getRequisitionList();
	}

	@Override
	public List<StoreToStore> getRequisitionListByVendor(String vendorId) throws CustomException {
		return quotationDao.getRequisitionListByVendor(vendorId);
	}

	@Override
	public List<DefTableBean> getTaxList() throws CustomException {
		return quotationDao.getTaxList();
	}

	@Override
	public PurchaseQuotationResultBean getRequisitionItemList(PurchaseQuotation purchaseQuotation) throws CustomException {
		return quotationDao.getRequisitionItemList(purchaseQuotation);
	}

	@Override
	public PurchaseQuotationResultBean getWOItemList(PurchaseQuotation purchaseQuotation) throws CustomException {
		return quotationDao.getWOItemList(purchaseQuotation);
	}

	@Override
	public PurchaseQuotationResultBean insertPurchaseQuotation(PurchaseQuotation purchaseQuotation) throws CustomException {
		return quotationDao.insertPurchaseQuotation(purchaseQuotation);
	}

	@Override
	public PurchaseQuotationResultBean deletePurchaseQuotation(Integer quotationId) throws CustomException {
		return quotationDao.deletePurchaseQuotation(quotationId);
	}

	@Override
	public PurchaseQuotationResultBean getPurchaseQuotationList() throws CustomException {
		return quotationDao.getPurchaseQuotationList();
	}

	@Override
	public PurchaseQuotationResultBean getItem(int requisitionId, int itemId) throws CustomException {
		return quotationDao.getItem(requisitionId, itemId);
	}

	@Override
	public PurchaseQuotationResultBean getVendorDetails(String vendorId) {
		return quotationDao.getVendorDetails(vendorId);
	}

	@Override
	public PurchaseQuotationResultBean getTaxDetails(int taxId) {
		return quotationDao.getTaxDetails(taxId);
	}

	@Override
	public PurchaseQuotation getPurchaseQuoteDataOnEdit(Integer quotationId) {
		return quotationDao.getPurchaseQuoteDataOnEdit(quotationId);
	}

	@Override
	public PurchaseQuotationResultBean updatePurchaseQuotation(PurchaseQuotation purchaseQuotation) {
		return quotationDao.updatePurchaseQuotation(purchaseQuotation);
	}

	@Override
	public PurchaseQuotationResultBean checkPurchaseQuotationNumber(PurchaseQuotationDetail purchaseQuotation) throws CustomException {
		// TODO Auto-generated method stub
		return quotationDao.checkPurchaseQuotationNumber(purchaseQuotation);
	}

	@Override
	public PurchaseQuotationResultBean uploadFile(MultipartFile file) {

		PurchaseQuotationResultBean resultbean = new PurchaseQuotationResultBean();

		PurchaseQuotation hdrBean = new PurchaseQuotation();
		List<PurchaseQuotationDetail> depotArrivalDtlBeanList = new ArrayList<>();
		UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String fileName = file.getOriginalFilename();
		Iterator<Row> rowIterator = null;
		StringBuffer sb = new StringBuffer();

		Workbook workbook = null;

		try {
			org.apache.poi.ss.usermodel.Workbook wb_xssf; // Declare XSSF
			org.apache.poi.ss.usermodel.Workbook wb_hssf; // Declare HSSF
			// int j=0;
			Sheet sheet = null;
			if (fileName.endsWith("xls")) {

				POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
				wb_hssf = new HSSFWorkbook(fs);
				sheet = wb_hssf.getSheetAt(0);
				rowIterator = sheet.rowIterator();
				// j=2;
			} else if (fileName.endsWith("xlsx")) {

				workbook = new XSSFWorkbook(file.getInputStream());
				XSSFSheet sheet1 = (XSSFSheet) workbook.getSheetAt(0);
				rowIterator = sheet1.rowIterator();
				// j=2;

			} else {
				sb.append("Not a valid file format");
			}

			int rowCnt = 0;
			String error = "";
			Row row1 = rowIterator.next();
			Cell qdate = row1.getCell(1);
			hdrBean.setQuoteDate(qdate.getStringCellValue());
			Row row2 = rowIterator.next();
			Cell Purchasefor = row2.getCell(1);
			boolean purchaseforValid = false;
			if (Purchasefor != null) {
				String purchasefor = "";
				if (Purchasefor.getCellType() == 0) {
					long myNumber = (long) Purchasefor.getNumericCellValue();
					purchasefor = String.valueOf(myNumber);
				} else if (Purchasefor.getCellType() == 1) {
					purchasefor = Purchasefor.getStringCellValue().trim();

				}
			/*	String purfor = quotationDao.getPurchaseForList(purchasefor.trim());
				if (purfor != null && !purfor.trim().equalsIgnoreCase("null") && !purfor.trim().isEmpty()) {

					hdrBean.setPurchaseFor(Integer.valueOf(purfor));
					purchaseforValid = true;
				} else {
					sb.append(" row- " + (rowCnt) + " : " + "Purchase For is not valid");
					sb.append("<br>");
				}*/
			} else {
				sb.append(" row- " + (rowCnt) + " : " + "Purchase For should not be empty");
				sb.append("<br>");
			}
			Row row3 = rowIterator.next();
			Cell Purchasetype = row3.getCell(1);
			boolean purchasetypevalid = false;
			if (Purchasetype != null) {
				String purchasetype = "";
				if (Purchasetype.getCellType() == 0) {
					long myNumber = (long) Purchasetype.getNumericCellValue();
					purchasetype = String.valueOf(myNumber);
				} else if (Purchasetype.getCellType() == 1) {
					purchasetype = Purchasetype.getStringCellValue().trim();
				}
			/*	String purtypefor = quotationDao.getPurchaseTypeList(purchasetype.trim());
				if (purtypefor != null && !purtypefor.trim().equalsIgnoreCase("null") && !purtypefor.trim().isEmpty()) {
					hdrBean.setPurchaseType(Integer.valueOf(purtypefor));
					purchasetypevalid = true;
				} else {
					sb.append(" row- " + (rowCnt) + " : " + "Purchase Type is not valid");
					sb.append("<br>");
				}*/
			} else {
				sb.append(" row- " + (rowCnt) + " : " + "Purchase For should not be empty");
				sb.append("<br>");
			}

			Row row4 = rowIterator.next();
			Cell Entityid = row4.getCell(1);
			boolean entityidvalid = false;
			if (Entityid != null) {
				String entityid = "";
				if (Entityid.getCellType() == 0) {
					long myNumber = (long) Entityid.getNumericCellValue();
					entityid = String.valueOf(myNumber);
				} else if (Entityid.getCellType() == 1) {
					entityid = Entityid.getStringCellValue().trim();
				}
				/*String entityidnew = quotationDao.getVendorList(entityid.trim());
				if (entityidnew != null && !entityidnew.trim().equalsIgnoreCase("null") && !entityidnew.trim().isEmpty()) {
					hdrBean.setVendorId(entityidnew);
					entityidvalid = true;
				} else {
					sb.append(" row- " + (rowCnt) + " : " + "Vendor For is not valid");
					sb.append("<br>");
				}*/
			} else {
				sb.append(" row- " + (rowCnt) + " : " + "Vendor For should not be empty");
				sb.append("<br>");
			}
			/*
			 * Row row5 = rowIterator.next(); Cell remarks = row5.getCell(1);
			 * hdrBean.setRemarks(remarks.getStringCellValue()); Row row7 =
			 * rowIterator.next(); Cell subtotal = row7.getCell(1);
			 * hdrBean.setSubTotal(subtotal.getNumericCellValue()); Row row8 =
			 * rowIterator.next(); Cell totdiscount = row8.getCell(1);
			 * hdrBean.setTotalDiscount(totdiscount.getNumericCellValue()); Row
			 * row9 = rowIterator.next(); Cell totaltax = row9.getCell(1);
			 * hdrBean.setTotalTax(totaltax.getNumericCellValue()); Row row10 =
			 * rowIterator.next(); Cell freight = row10.getCell(1);
			 * hdrBean.setFreight(freight.getNumericCellValue()); Row row11 =
			 * rowIterator.next(); Cell grandtotal = row11.getCell(1);
			 * hdrBean.setGrandTotal(grandtotal.getNumericCellValue()); Row
			 * row12 = rowIterator.next(); Cell fixedprice = row12.getCell(1);
			 * hdrBean.setFixedPrice(fixedprice.getStringCellValue()); Row row13
			 * = rowIterator.next(); Cell fixedqty = row13.getCell(1);
			 * hdrBean.setFixedQty(fixedqty.getStringCellValue());
			 */
			Row row5 = rowIterator.next();
			Cell remarks = row5.getCell(1);
			hdrBean.setRemarks(remarks.getStringCellValue());
			Row row6 = rowIterator.next();
			Cell validdate = row6.getCell(1);
			hdrBean.setValidFromDate(validdate.getStringCellValue());
			Row row7 = rowIterator.next();
			Cell validto = row7.getCell(1);
			hdrBean.setValidToDate(validto.getStringCellValue());
			/*
			 * Row row8 = rowIterator.next(); Cell paymentterms =
			 * row8.getCell(1); hdrBean.setPaymentTerms((int)
			 * paymentterms.getNumericCellValue());
			 */
			Row row8 = rowIterator.next();
			Cell CompanyId = row8.getCell(1);
			boolean CompanyIdvalid = false;
			if (CompanyId != null) {/*
				String companyid = "";
				if (CompanyId.getCellType() == 0) {
					String myNumber = CompanyId.getStringCellValue();
					companyid = String.valueOf(myNumber);
				} else if (CompanyId.getCellType() == 1) {
					companyid = CompanyId.getStringCellValue().trim();
				}
				String companyidnew = quotationDao.getCompanyList(companyid.trim());
				if (companyidnew != null && !companyidnew.trim().equalsIgnoreCase("null") && !companyidnew.trim().isEmpty()) {
					hdrBean.setCompanyId(companyidnew);
					CompanyIdvalid = true;
				} else {
					sb.append(" row- " + (rowCnt) + " : " + "Company  is not valid");
					sb.append("<br>");
				}
			} else {
				sb.append(" row- " + (rowCnt) + " : " + "Company should not be empty");
				sb.append("<br>");
			}
			Row row9 = rowIterator.next();
			Cell total = row9.getCell(1);
			hdrBean.setGrandTotal(total.getNumericCellValue());

			Row row10 = rowIterator.next();
			Cell discount = row10.getCell(1);
			hdrBean.setTotalDiscount(discount.getNumericCellValue());

			Row row11 = rowIterator.next();
			Cell fixedprice = row11.getCell(1);
			hdrBean.setFixedPrice(fixedprice.getStringCellValue());

			Row row12 = rowIterator.next();
			Cell fixedqty = row12.getCell(1);
			hdrBean.setFixedQty(fixedqty.getStringCellValue());

			Row row13 = rowIterator.next();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				rowCnt += 1;
				if (rowCnt >= 1) {

					boolean customFlag = true;
					Iterator<Cell> cellIterator = row.cellIterator();
					PurchaseQuotationDetail memberCreationBean = new PurchaseQuotationDetail();

					
					 * Cell quotationId = row.getCell(0); if (quotationId ==
					 * null || quotationId.getCellType() ==
					 * Cell.CELL_TYPE_BLANK) { error = error + "\n" + "Row" +
					 * rowCnt + " Container Number  should not be empty";
					 * System.out.println(error); } else {
					 * memberCreationBean.setQuotationId((int)
					 * quotationId.getNumericCellValue()); }
					 

					
					 * Cell requisitionId = row.getCell(0); if (requisitionId ==
					 * null || requisitionId.getCellType() ==
					 * Cell.CELL_TYPE_BLANK) { error = error + "\n" + "Row" +
					 * rowCnt + " Customer Code  should not be empty.";
					 * System.out.println(error); } else { // String //
					 * custCode= DepotDespatchDAO.getCustCode(customerCode.
					 * getStringCellValue ());
					 * memberCreationBean.setRequisitionId((int)
					 * requisitionId.getNumericCellValue());
					 * 
					 * }
					 

					Cell RequisitionId = row.getCell(0);
					boolean requisitionIdvalid = false;
					if (RequisitionId != null) {
						String reqid = "";
						if (RequisitionId.getCellType() == 0) {
							String myNumber = RequisitionId.getStringCellValue();
							reqid = String.valueOf(myNumber);
						} else if (RequisitionId.getCellType() == 1) {
							reqid = RequisitionId.getStringCellValue().trim();
							memberCreationBean.setRequisitionNo(String.valueOf(reqid));

						}
						String reqidnew = quotationDao.getRequisitionIdNewList(reqid.trim());
						if (reqidnew != null && !reqidnew.trim().equalsIgnoreCase("null") && !reqidnew.trim().isEmpty()) {
							memberCreationBean.setRequisitionId(Integer.valueOf(reqidnew));
							requisitionIdvalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Requisition Id is not valid");
							sb.append("<br>");
						}
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Requisition Id should not be empty");
						sb.append("<br>");
					}

					Cell ItemId = row.getCell(1);
					boolean itemIdvalid = false;
					if (ItemId != null) {
						String itemid = "";
						if (ItemId.getCellType() == 0) {
							String myNumber = ItemId.getStringCellValue();
							itemid = String.valueOf(myNumber);

						} else if (ItemId.getCellType() == 1) {
							itemid = ItemId.getStringCellValue().trim();
							memberCreationBean.setItemName(String.valueOf(itemid));

						}
						String idnew = quotationDao.getItemNewList(itemid.trim());
						if (idnew != null && !idnew.trim().equalsIgnoreCase("null") && !idnew.trim().isEmpty()) {
							memberCreationBean.setItemCode(idnew);
							itemIdvalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Item Id is not valid");
							sb.append("<br>");
						}
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Item Id should not be empty");
						sb.append("<br>");
					}

					
					 * Cell itemId = row.getCell(1); if (itemId == null ||
					 * itemId.getCellType() == Cell.CELL_TYPE_BLANK) { error =
					 * error + "\n" + "Row" + rowCnt +
					 * " Customer Code  should not be empty.";
					 * System.out.println(error); } else { // String //
					 * custCode= DepotDespatchDAO.getCustCode(customerCode.
					 * getStringCellValue ());
					 * memberCreationBean.setItemId((int)
					 * itemId.getNumericCellValue());
					 * 
					 * }
					 

					
					 * Cell RequisitionId = row.getCell(0); if (RequisitionId ==
					 * null || RequisitionId.getCellType() ==
					 * Cell.CELL_TYPE_BLANK) { error = error + "\n" + "Row" +
					 * rowCnt + " Customer Code  should not be empty.";
					 * System.out.println(error); } else { // String //
					 * custCode= DepotDespatchDAO.getCustCode(customerCode.
					 * getStringCellValue ());
					 * memberCreationBean.setRequisitionNo(RequisitionId.
					 * getStringCellValue());
					 * 
					 * }
					 * 
					 * Cell itemId = row.getCell(1); if (itemId == null ||
					 * itemId.getCellType() == Cell.CELL_TYPE_BLANK) { error =
					 * error + "\n" + "Row" + rowCnt +
					 * " Customer Code  should not be empty.";
					 * System.out.println(error);
					 * 
					 * } else { // String /custCode= //
					 * DepotDespatchDAO.getCustCode
					 * (customerCode.getStringCellValue // ());
					 * memberCreationBean.setItemId((int)
					 * itemId.getNumericCellValue());
					 * 
					 * }
					 
					Cell edd = row.getCell(2);
					if (edd == null || edd.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Net weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setEddDate(edd.getStringCellValue());

					}
					Cell taxId = row.getCell(3);
					if (taxId == null || taxId.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Gross weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setTaxId((int) taxId.getNumericCellValue());

					}
					Cell quantityId = row.getCell(4);
					if (quantityId == null || quantityId.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Customer Code  should not be empty.";
						System.out.println(error);
					} else {
						// String
						// custCode=DepotDespatchDAO.getCustCode(customerCode.getStringCellValue());
						memberCreationBean.setQuantity((int) quantityId.getNumericCellValue());

					}
					Cell vendorQuantity = row.getCell(5);
					if (vendorQuantity == null || vendorQuantity.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Tare weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setVendorQuantity((int) vendorQuantity.getNumericCellValue());

					}
					
					 * Cell uom = row.getCell(6); if (uom == null ||
					 * uom.getCellType() == Cell.CELL_TYPE_BLANK) { error =
					 * error + "\n" + "Row" + rowCnt +
					 * " Tare weight  should not be empty";
					 * System.out.println(error); } else {
					 * 
					 * memberCreationBean.setUomName((int)
					 * uom.getNumericCellValue());
					 * 
					 * }
					 

					Cell VendorUom = row.getCell(7);
					boolean VendorUomvalid = false;
					if (VendorUom != null) {
						String vendor = "";
						if (VendorUom.getCellType() == 0) {
							String myNumber = VendorUom.getStringCellValue();
							vendor = String.valueOf(myNumber);
						} else if (VendorUom.getCellType() == 1) {
							vendor = VendorUom.getStringCellValue().trim();
							memberCreationBean.setVendorUomName(vendor);

						}
						String uomidnew = quotationDao.getUomList(vendor.trim());
						if (uomidnew != null && !uomidnew.trim().equalsIgnoreCase("null") && !uomidnew.trim().isEmpty()) {
							memberCreationBean.setVendoruom(Integer.valueOf(uomidnew));
							VendorUomvalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Vendor UOM is not valid");
							sb.append("<br>");
						}
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Vendor UOM should not be empty");
						sb.append("<br>");
					}

					Cell deliveryLeadTime = row.getCell(8);
					if (deliveryLeadTime == null || deliveryLeadTime.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Gross weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setDeliveryLeadTime((int) deliveryLeadTime.getNumericCellValue());

					}
					Cell percentage = row.getCell(9);
					if (percentage == null || percentage.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Gross weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setPercentage((int) percentage.getNumericCellValue());

					}
					Cell unitPrice = row.getCell(10);
					if (unitPrice == null || unitPrice.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Gross weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setUnitPrice(unitPrice.getNumericCellValue());

					}

					Cell Status = row.getCell(11);
					boolean Statusvalid = false;
					if (Status != null) {
						String uom = "";
						if (Status.getCellType() == 0) {
							String myNumber = Status.getStringCellValue();
							uom = String.valueOf(myNumber);
						} else if (Status.getCellType() == 1) {
							uom = Status.getStringCellValue().trim();
						}
						String id = quotationDao.getStatusList(uom.trim());
						if (id != null && !id.trim().equalsIgnoreCase("null") && !id.trim().isEmpty()) {
							memberCreationBean.setQueryStatus(Integer.valueOf(id));
							Statusvalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Purchase UOM is not valid");
							sb.append("<br>");
						}
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Purchase UOM should not be empty");
						sb.append("<br>");
					}
					Cell amount = row.getCell(12);
					if (amount == null || amount.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Amount  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setAmount(amount.getNumericCellValue());

					}

					Cell DiscountType = row.getCell(13);
					boolean DiscountTypevalid = false;
					if (DiscountType != null) {
						String dis = "";
						if (DiscountType.getCellType() == 0) {
							String myNumber = DiscountType.getStringCellValue();
							dis = String.valueOf(myNumber);
						} else if (DiscountType.getCellType() == 1) {
							dis = DiscountType.getStringCellValue().trim();
							memberCreationBean.setDiscountType(dis);

						}
						String id = quotationDao.getDiscountList(dis.trim());
						if (id != null && !id.trim().equalsIgnoreCase("null") && !id.trim().isEmpty()) {
							memberCreationBean.setDiscountTypeId(Integer.valueOf(id));
							DiscountTypevalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Discount Type is not valid");
							sb.append("<br>");
						}
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Discount Type should not be empty");
						sb.append("<br>");
					}
					Cell disamount = row.getCell(14);
					if (disamount == null || disamount.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + "Discount Amount  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setDisAmt(disamount.getNumericCellValue());

					}
					Cell Taxcode = row.getCell(15);
					boolean Taxcodevalid = false;
					if (Taxcode != null) {
						String dis = "";
						if (Taxcode.getCellType() == 0) {
							String myNumber = Taxcode.getStringCellValue();
							dis = String.valueOf(myNumber);
						} else if (Taxcode.getCellType() == 1) {
							dis = Taxcode.getStringCellValue().trim();
							memberCreationBean.setTaxCode(String.valueOf(dis));

						}
						String id = quotationDao.getTaxList(dis.trim());
						if (id != null && !id.trim().equalsIgnoreCase("null") && !id.trim().isEmpty()) {
							memberCreationBean.setTaxId(Integer.valueOf(id));
							Taxcodevalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Discount Type is not valid");
							sb.append("<br>");
						}
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Discount Type should not be empty");
						sb.append("<br>");
					}
					Cell sutotal = row.getCell(16);
					if (sutotal == null || sutotal.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Gross weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setRowSubTotal(sutotal.getNumericCellValue());

					}

					depotArrivalDtlBeanList.add(memberCreationBean);
				}

			}

			hdrBean.setQuotationDetailList(depotArrivalDtlBeanList);
			resultbean.setPurchaseQuotation(hdrBean);
			if (error != null || !error.equalsIgnoreCase("")) {
				// resultbean = quotationDao.insertPurchaseQuotation(hdrBean);
				resultbean.setSuccess(true);
			} else {
				resultbean.setSuccess(true);
				resultbean.setMessage(error);
			}

		*/
				}
		}catch (Exception e) {
			resultbean.setSuccess(true);
			e.printStackTrace();
		}

		return resultbean;
	}

	@Override
	public PurchaseQuotationResultBean uploadFile1(MultipartFile file) {

		PurchaseQuotationResultBean resultbean = new PurchaseQuotationResultBean();

		PurchaseQuotation hdrBean = new PurchaseQuotation();
		List<PurchaseQuotationDetail> depotArrivalDtlBeanList = new ArrayList<>();
		UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String fileName = file.getOriginalFilename();
		Iterator<Row> rowIterator = null;
		StringBuffer sb = new StringBuffer();

		Workbook workbook = null;

		try {
			org.apache.poi.ss.usermodel.Workbook wb_xssf; // Declare XSSF
			org.apache.poi.ss.usermodel.Workbook wb_hssf; // Declare HSSF
			// int j=0;
			Sheet sheet = null;
			if (fileName.endsWith("xls")) {

				POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
				wb_hssf = new HSSFWorkbook(fs);
				sheet = wb_hssf.getSheetAt(0);
				rowIterator = sheet.rowIterator();
				// j=2;
			} else if (fileName.endsWith("xlsx")) {

				workbook = new XSSFWorkbook(file.getInputStream());
				XSSFSheet sheet1 = (XSSFSheet) workbook.getSheetAt(0);
				rowIterator = sheet1.rowIterator();
				// j=2;

			} else {
				sb.append("Not a valid file format");
			}

			int rowCnt = 0;
			String error = "";

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				rowCnt += 1;
				if (rowCnt > 1) {

					boolean customFlag = false;
					Iterator<Cell> cellIterator = row.cellIterator();
					PurchaseQuotationDetail memberCreationBean = new PurchaseQuotationDetail();

					/*
					 * Cell quotationId = row.getCell(0); if (quotationId ==
					 * null || quotationId.getCellType() ==
					 * Cell.CELL_TYPE_BLANK) { error = error + "\n" + "Row" +
					 * rowCnt + " Container Number  should not be empty";
					 * System.out.println(error); } else {
					 * memberCreationBean.setQuotationId((int)
					 * quotationId.getNumericCellValue()); }
					 */

					/*
					 * Cell requisitionId = row.getCell(0); if (requisitionId ==
					 * null || requisitionId.getCellType() ==
					 * Cell.CELL_TYPE_BLANK) { error = error + "\n" + "Row" +
					 * rowCnt + " Customer Code  should not be empty.";
					 * System.out.println(error); } else { // String //
					 * custCode= DepotDespatchDAO.getCustCode(customerCode.
					 * getStringCellValue ());
					 * memberCreationBean.setRequisitionId((int)
					 * requisitionId.getNumericCellValue());
					 * 
					 * }
					 */

					Cell RequisitionId = row.getCell(0);
					boolean requisitionIdvalid = false;
					if (RequisitionId != null) {
						String reqid = "";
						if (RequisitionId.getCellType() == 0) {
							String myNumber = RequisitionId.getStringCellValue();
							reqid = String.valueOf(myNumber);
						} else if (RequisitionId.getCellType() == 1) {
							reqid = RequisitionId.getStringCellValue().trim();
							memberCreationBean.setRequisitionNo(String.valueOf(reqid));

						}
						/*String reqidnew = quotationDao.getRequisitionIdNewList(reqid.trim());
						if (reqidnew != null && !reqidnew.trim().equalsIgnoreCase("null") && !reqidnew.trim().isEmpty()) {
							memberCreationBean.setRequisitionId(Integer.valueOf(reqidnew));
							requisitionIdvalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Requisition Id is not valid");
							sb.append("<br>");
						}*/
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Requisition Id should not be empty");
						sb.append("<br>");
					}

					Cell ItemId = row.getCell(1);
					boolean itemIdvalid = false;
					if (ItemId != null) {
						String itemid = "";
						if (ItemId.getCellType() == 0) {
							String myNumber = ItemId.getStringCellValue();
							itemid = String.valueOf(myNumber);

						} else if (ItemId.getCellType() == 1) {
							itemid = ItemId.getStringCellValue().trim();
							memberCreationBean.setItemName(String.valueOf(itemid));

						}
					/*	String idnew = quotationDao.getItemNewList(itemid.trim());
						if (idnew != null && !idnew.trim().equalsIgnoreCase("null") && !idnew.trim().isEmpty()) {
							memberCreationBean.setItemCode(idnew);
							itemIdvalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Item Id is not valid");
							sb.append("<br>");
						}*/
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Item Id should not be empty");
						sb.append("<br>");
					}

					/*
					 * Cell itemId = row.getCell(1); if (itemId == null ||
					 * itemId.getCellType() == Cell.CELL_TYPE_BLANK) { error =
					 * error + "\n" + "Row" + rowCnt +
					 * " Customer Code  should not be empty.";
					 * System.out.println(error); } else { // String //
					 * custCode= DepotDespatchDAO.getCustCode(customerCode.
					 * getStringCellValue ());
					 * memberCreationBean.setItemId((int)
					 * itemId.getNumericCellValue());
					 * 
					 * }
					 */

					/*
					 * Cell RequisitionId = row.getCell(0); if (RequisitionId ==
					 * null || RequisitionId.getCellType() ==
					 * Cell.CELL_TYPE_BLANK) { error = error + "\n" + "Row" +
					 * rowCnt + " Customer Code  should not be empty.";
					 * System.out.println(error); } else { // String //
					 * custCode= DepotDespatchDAO.getCustCode(customerCode.
					 * getStringCellValue ());
					 * memberCreationBean.setRequisitionNo(RequisitionId.
					 * getStringCellValue());
					 * 
					 * }
					 * 
					 * Cell itemId = row.getCell(1); if (itemId == null ||
					 * itemId.getCellType() == Cell.CELL_TYPE_BLANK) { error =
					 * error + "\n" + "Row" + rowCnt +
					 * " Customer Code  should not be empty.";
					 * System.out.println(error);
					 * 
					 * } else { // String /custCode= //
					 * DepotDespatchDAO.getCustCode
					 * (customerCode.getStringCellValue // ());
					 * memberCreationBean.setItemId((int)
					 * itemId.getNumericCellValue());
					 * 
					 * }
					 */
					Cell edd = row.getCell(2);
					if (edd == null || edd.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Net weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setEddDate(edd.getStringCellValue());

					}
					Cell taxId = row.getCell(3);
					if (taxId == null || taxId.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Gross weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setTaxId((int) taxId.getNumericCellValue());

					}
					Cell quantityId = row.getCell(4);
					if (quantityId == null || quantityId.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Customer Code  should not be empty.";
						System.out.println(error);
					} else {
						// String
						// custCode=DepotDespatchDAO.getCustCode(customerCode.getStringCellValue());
						memberCreationBean.setQuantity((int) quantityId.getNumericCellValue());

					}
					Cell vendorQuantity = row.getCell(5);
					if (vendorQuantity == null || vendorQuantity.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Tare weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setVendorQuantity((int) vendorQuantity.getNumericCellValue());

					}
					/*
					 * Cell uom = row.getCell(6); if (uom == null ||
					 * uom.getCellType() == Cell.CELL_TYPE_BLANK) { error =
					 * error + "\n" + "Row" + rowCnt +
					 * " Tare weight  should not be empty";
					 * System.out.println(error); } else {
					 * 
					 * memberCreationBean.setUomName((int)
					 * uom.getNumericCellValue());
					 * 
					 * }
					 */

					Cell VendorUom = row.getCell(7);
					boolean VendorUomvalid = false;
					if (VendorUom != null) {
						String vendor = "";
						if (VendorUom.getCellType() == 0) {
							String myNumber = VendorUom.getStringCellValue();
							vendor = String.valueOf(myNumber);
						} else if (VendorUom.getCellType() == 1) {
							vendor = VendorUom.getStringCellValue().trim();
							memberCreationBean.setVendorUomName(vendor);

						}
						/*String uomidnew = quotationDao.getUomList(vendor.trim());
						if (uomidnew != null && !uomidnew.trim().equalsIgnoreCase("null") && !uomidnew.trim().isEmpty()) {
							memberCreationBean.setVendoruom(Integer.valueOf(uomidnew));
							VendorUomvalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Vendor UOM is not valid");
							sb.append("<br>");
						}*/
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Vendor UOM should not be empty");
						sb.append("<br>");
					}

					Cell deliveryLeadTime = row.getCell(8);
					if (deliveryLeadTime == null || deliveryLeadTime.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Gross weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setDeliveryLeadTime((int) deliveryLeadTime.getNumericCellValue());

					}
					Cell percentage = row.getCell(9);
					if (percentage == null || percentage.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Gross weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setPercentage((int) percentage.getNumericCellValue());

					}
					Cell unitPrice = row.getCell(10);
					if (unitPrice == null || unitPrice.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Gross weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setUnitPrice(unitPrice.getNumericCellValue());

					}

					Cell Status = row.getCell(11);
					boolean Statusvalid = false;
					if (Status != null) {
						String uom = "";
						if (Status.getCellType() == 0) {
							String myNumber = Status.getStringCellValue();
							uom = String.valueOf(myNumber);
						} else if (Status.getCellType() == 1) {
							uom = Status.getStringCellValue().trim();
						}
					/*	String id = quotationDao.getStatusList(uom.trim());
						if (id != null && !id.trim().equalsIgnoreCase("null") && !id.trim().isEmpty()) {
							memberCreationBean.setQueryStatus(Integer.valueOf(id));
							Statusvalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Purchase UOM is not valid");
							sb.append("<br>");
						}*/
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Purchase UOM should not be empty");
						sb.append("<br>");
					}
					Cell amount = row.getCell(12);
					if (amount == null || amount.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Amount  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setAmount(amount.getNumericCellValue());

					}

					Cell DiscountType = row.getCell(13);
					boolean DiscountTypevalid = false;
					if (DiscountType != null) {
						String dis = "";
						if (DiscountType.getCellType() == 0) {
							String myNumber = DiscountType.getStringCellValue();
							dis = String.valueOf(myNumber);
						} else if (DiscountType.getCellType() == 1) {
							dis = DiscountType.getStringCellValue().trim();
							memberCreationBean.setDiscountType(dis);

						}
					/*	String id = quotationDao.getDiscountList(dis.trim());
						if (id != null && !id.trim().equalsIgnoreCase("null") && !id.trim().isEmpty()) {
							memberCreationBean.setDiscountTypeId(Integer.valueOf(id));
							DiscountTypevalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Discount Type is not valid");
							sb.append("<br>");
						}*/
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Discount Type should not be empty");
						sb.append("<br>");
					}
					Cell disamount = row.getCell(14);
					if (disamount == null || disamount.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + "Discount Amount  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setDisAmt(disamount.getNumericCellValue());

					}
					Cell Taxcode = row.getCell(15);
					boolean Taxcodevalid = false;
					if (Taxcode != null) {
						String dis = "";
						if (Taxcode.getCellType() == 0) {
							String myNumber = Taxcode.getStringCellValue();
							dis = String.valueOf(myNumber);
						} else if (Taxcode.getCellType() == 1) {
							dis = Taxcode.getStringCellValue().trim();
							memberCreationBean.setTaxCode(String.valueOf(dis));

						}
					/*	String id = quotationDao.getTaxList(dis.trim());
						if (id != null && !id.trim().equalsIgnoreCase("null") && !id.trim().isEmpty()) {
							memberCreationBean.setTaxId(Integer.valueOf(id));
							Taxcodevalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Discount Type is not valid");
							sb.append("<br>");
						}*/
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Discount Type should not be empty");
						sb.append("<br>");
					}
					Cell sutotal = row.getCell(16);
					if (sutotal == null || sutotal.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Gross weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setRowSubTotal(sutotal.getNumericCellValue());

					}

					depotArrivalDtlBeanList.add(memberCreationBean);
				}

			}

			hdrBean.setQuotationDetailList(depotArrivalDtlBeanList);
			resultbean.setPurchaseQuotation(hdrBean);
			if (error != null || !error.equalsIgnoreCase("")) {

				resultbean.setSuccess(true);
			} else {
				resultbean.setSuccess(true);
				resultbean.setMessage(error);
			}

		} catch (Exception e) {
			resultbean.setSuccess(true);
			e.printStackTrace();
		}

		return resultbean;
	}

	@Override
	public PurchaseQuotationResultBean uploadFile2(MultipartFile file) {

		PurchaseQuotationResultBean resultbean = new PurchaseQuotationResultBean();

		PurchaseQuotation hdrBean = new PurchaseQuotation();
		List<PurchaseQuotationDetail> depotArrivalDtlBeanList = new ArrayList<>();
		UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String fileName = file.getOriginalFilename();
		Iterator<Row> rowIterator = null;
		StringBuffer sb = new StringBuffer();

		Workbook workbook = null;

		try {
			org.apache.poi.ss.usermodel.Workbook wb_xssf; // Declare XSSF
			org.apache.poi.ss.usermodel.Workbook wb_hssf; // Declare HSSF
			// int j=0;
			Sheet sheet = null;
			if (fileName.endsWith("xls")) {

				POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
				wb_hssf = new HSSFWorkbook(fs);
				sheet = wb_hssf.getSheetAt(0);
				rowIterator = sheet.rowIterator();
				// j=2;
			} else if (fileName.endsWith("xlsx")) {

				workbook = new XSSFWorkbook(file.getInputStream());
				XSSFSheet sheet1 = (XSSFSheet) workbook.getSheetAt(0);
				rowIterator = sheet1.rowIterator();
				// j=2;

			} else {
				sb.append("Not a valid file format");
			}

			int rowCnt = 0;
			String error = "";

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				rowCnt += 1;
				if (rowCnt > 1) {

					boolean customFlag = false;
					Iterator<Cell> cellIterator = row.cellIterator();
					PurchaseQuotationDetail memberCreationBean = new PurchaseQuotationDetail();

					/*
					 * Cell quotationId = row.getCell(0); if (quotationId ==
					 * null || quotationId.getCellType() ==
					 * Cell.CELL_TYPE_BLANK) { error = error + "\n" + "Row" +
					 * rowCnt + " Container Number  should not be empty";
					 * System.out.println(error); } else {
					 * memberCreationBean.setQuotationId((int)
					 * quotationId.getNumericCellValue()); }
					 */

					/*
					 * Cell requisitionId = row.getCell(0); if (requisitionId ==
					 * null || requisitionId.getCellType() ==
					 * Cell.CELL_TYPE_BLANK) { error = error + "\n" + "Row" +
					 * rowCnt + " Customer Code  should not be empty.";
					 * System.out.println(error); } else { // String //
					 * custCode= DepotDespatchDAO.getCustCode(customerCode.
					 * getStringCellValue ());
					 * memberCreationBean.setRequisitionId((int)
					 * requisitionId.getNumericCellValue());
					 * 
					 * }
					 */

					Cell RequisitionId = row.getCell(0);
					boolean requisitionIdvalid = false;
					if (RequisitionId != null) {
						String reqid = "";
						if (RequisitionId.getCellType() == 0) {
							String myNumber = RequisitionId.getStringCellValue();
							reqid = String.valueOf(myNumber);
						} else if (RequisitionId.getCellType() == 1) {
							reqid = RequisitionId.getStringCellValue().trim();
							memberCreationBean.setRequisitionNo(String.valueOf(reqid));

						}
						/*String reqidnew = quotationDao.getRequisitionIdNewList(reqid.trim());
						if (reqidnew != null && !reqidnew.trim().equalsIgnoreCase("null") && !reqidnew.trim().isEmpty()) {
							memberCreationBean.setRequisitionId(Integer.valueOf(reqidnew));
							requisitionIdvalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Requisition Id is not valid");
							sb.append("<br>");
						}*/
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Requisition Id should not be empty");
						sb.append("<br>");
					}

					Cell ItemId = row.getCell(1);
					boolean itemIdvalid = false;
					if (ItemId != null) {
						String itemid = "";
						if (ItemId.getCellType() == 0) {
							String myNumber = ItemId.getStringCellValue();
							itemid = String.valueOf(myNumber);

						} else if (ItemId.getCellType() == 1) {
							itemid = ItemId.getStringCellValue().trim();
							memberCreationBean.setItemName(String.valueOf(itemid));

						}
					/*	String idnew = quotationDao.getItemNewList(itemid.trim());
						if (idnew != null && !idnew.trim().equalsIgnoreCase("null") && !idnew.trim().isEmpty()) {
							memberCreationBean.setItemCode(idnew);
							itemIdvalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Item Id is not valid");
							sb.append("<br>");
						}*/
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Item Id should not be empty");
						sb.append("<br>");
					}

					/*
					 * Cell itemId = row.getCell(1); if (itemId == null ||
					 * itemId.getCellType() == Cell.CELL_TYPE_BLANK) { error =
					 * error + "\n" + "Row" + rowCnt +
					 * " Customer Code  should not be empty.";
					 * System.out.println(error); } else { // String //
					 * custCode= DepotDespatchDAO.getCustCode(customerCode.
					 * getStringCellValue ());
					 * memberCreationBean.setItemId((int)
					 * itemId.getNumericCellValue());
					 * 
					 * }
					 */

					/*
					 * Cell RequisitionId = row.getCell(0); if (RequisitionId ==
					 * null || RequisitionId.getCellType() ==
					 * Cell.CELL_TYPE_BLANK) { error = error + "\n" + "Row" +
					 * rowCnt + " Customer Code  should not be empty.";
					 * System.out.println(error); } else { // String //
					 * custCode= DepotDespatchDAO.getCustCode(customerCode.
					 * getStringCellValue ());
					 * memberCreationBean.setRequisitionNo(RequisitionId.
					 * getStringCellValue());
					 * 
					 * }
					 * 
					 * Cell itemId = row.getCell(1); if (itemId == null ||
					 * itemId.getCellType() == Cell.CELL_TYPE_BLANK) { error =
					 * error + "\n" + "Row" + rowCnt +
					 * " Customer Code  should not be empty.";
					 * System.out.println(error);
					 * 
					 * } else { // String /custCode= //
					 * DepotDespatchDAO.getCustCode
					 * (customerCode.getStringCellValue // ());
					 * memberCreationBean.setItemId((int)
					 * itemId.getNumericCellValue());
					 * 
					 * }
					 */
					Cell edd = row.getCell(2);
					if (edd == null || edd.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Net weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setEddDate(edd.getStringCellValue());

					}
					Cell taxId = row.getCell(3);
					if (taxId == null || taxId.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Gross weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setTaxId((int) taxId.getNumericCellValue());

					}
					Cell quantityId = row.getCell(4);
					if (quantityId == null || quantityId.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Customer Code  should not be empty.";
						System.out.println(error);
					} else {
						// String
						// custCode=DepotDespatchDAO.getCustCode(customerCode.getStringCellValue());
						memberCreationBean.setQuantity((int) quantityId.getNumericCellValue());

					}
					Cell vendorQuantity = row.getCell(5);
					if (vendorQuantity == null || vendorQuantity.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Tare weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setVendorQuantity((int) vendorQuantity.getNumericCellValue());

					}
					/*
					 * Cell uom = row.getCell(6); if (uom == null ||
					 * uom.getCellType() == Cell.CELL_TYPE_BLANK) { error =
					 * error + "\n" + "Row" + rowCnt +
					 * " Tare weight  should not be empty";
					 * System.out.println(error); } else {
					 * 
					 * memberCreationBean.setUomName((int)
					 * uom.getNumericCellValue());
					 * 
					 * }
					 */

					Cell VendorUom = row.getCell(7);
					boolean VendorUomvalid = false;
					if (VendorUom != null) {
						String vendor = "";
						if (VendorUom.getCellType() == 0) {
							String myNumber = VendorUom.getStringCellValue();
							vendor = String.valueOf(myNumber);
						} else if (VendorUom.getCellType() == 1) {
							vendor = VendorUom.getStringCellValue().trim();
							memberCreationBean.setVendorUomName(vendor);

						}
						/*String uomidnew = quotationDao.getUomList(vendor.trim());
						if (uomidnew != null && !uomidnew.trim().equalsIgnoreCase("null") && !uomidnew.trim().isEmpty()) {
							memberCreationBean.setVendoruom(Integer.valueOf(uomidnew));
							VendorUomvalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Vendor UOM is not valid");
							sb.append("<br>");
						}*/
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Vendor UOM should not be empty");
						sb.append("<br>");
					}

					Cell deliveryLeadTime = row.getCell(8);
					if (deliveryLeadTime == null || deliveryLeadTime.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Gross weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setDeliveryLeadTime((int) deliveryLeadTime.getNumericCellValue());

					}
					Cell percentage = row.getCell(9);
					if (percentage == null || percentage.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Gross weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setPercentage((int) percentage.getNumericCellValue());

					}
					Cell unitPrice = row.getCell(10);
					if (unitPrice == null || unitPrice.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Gross weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setUnitPrice(unitPrice.getNumericCellValue());

					}

					Cell Status = row.getCell(11);
					boolean Statusvalid = false;
					if (Status != null) {
						String uom = "";
						if (Status.getCellType() == 0) {
							String myNumber = Status.getStringCellValue();
							uom = String.valueOf(myNumber);
						} else if (Status.getCellType() == 1) {
							uom = Status.getStringCellValue().trim();
						}
						/*String id = quotationDao.getStatusList(uom.trim());
						if (id != null && !id.trim().equalsIgnoreCase("null") && !id.trim().isEmpty()) {
							memberCreationBean.setQueryStatus(Integer.valueOf(id));
							Statusvalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Purchase UOM is not valid");
							sb.append("<br>");
						}*/
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Purchase UOM should not be empty");
						sb.append("<br>");
					}
					Cell amount = row.getCell(12);
					if (amount == null || amount.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Amount  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setAmount(amount.getNumericCellValue());

					}

					Cell DiscountType = row.getCell(13);
					boolean DiscountTypevalid = false;
					if (DiscountType != null) {
						String dis = "";
						if (DiscountType.getCellType() == 0) {
							String myNumber = DiscountType.getStringCellValue();
							dis = String.valueOf(myNumber);
						} else if (DiscountType.getCellType() == 1) {
							dis = DiscountType.getStringCellValue().trim();
							memberCreationBean.setDiscountType(dis);

						}
					/*	String id = quotationDao.getDiscountList(dis.trim());
						if (id != null && !id.trim().equalsIgnoreCase("null") && !id.trim().isEmpty()) {
							memberCreationBean.setDiscountTypeId(Integer.valueOf(id));
							DiscountTypevalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Discount Type is not valid");
							sb.append("<br>");
						}*/
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Discount Type should not be empty");
						sb.append("<br>");
					}
					Cell disamount = row.getCell(14);
					if (disamount == null || disamount.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + "Discount Amount  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setDisAmt(disamount.getNumericCellValue());

					}
					Cell Taxcode = row.getCell(15);
					boolean Taxcodevalid = false;
					if (Taxcode != null) {
						String dis = "";
						if (Taxcode.getCellType() == 0) {
							String myNumber = Taxcode.getStringCellValue();
							dis = String.valueOf(myNumber);
						} else if (Taxcode.getCellType() == 1) {
							dis = Taxcode.getStringCellValue().trim();
							memberCreationBean.setTaxCode(String.valueOf(dis));

						}
						/*String id = quotationDao.getTaxList(dis.trim());
						if (id != null && !id.trim().equalsIgnoreCase("null") && !id.trim().isEmpty()) {
							memberCreationBean.setTaxId(Integer.valueOf(id));
							Taxcodevalid = true;
						} else {
							sb.append(" row- " + (rowCnt) + " : " + "Discount Type is not valid");
							sb.append("<br>");
						}*/
					} else {
						sb.append(" row- " + (rowCnt) + " : " + "Discount Type should not be empty");
						sb.append("<br>");
					}
					Cell sutotal = row.getCell(16);
					if (sutotal == null || sutotal.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Gross weight  should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setRowSubTotal(sutotal.getNumericCellValue());

					}

					depotArrivalDtlBeanList.add(memberCreationBean);
				}

			}

			hdrBean.setQuotationDetailList(depotArrivalDtlBeanList);
			resultbean.setPurchaseQuotation(hdrBean);
			if (error != null || !error.equalsIgnoreCase("")) {

				resultbean.setSuccess(true);
			} else {
				resultbean.setSuccess(true);
				resultbean.setMessage(error);
			}

		} catch (Exception e) {
			resultbean.setSuccess(true);
			e.printStackTrace();
		}

		return resultbean;
	}

	@Override
	public List<StoreToStore> getRequisitionList(String companyId) throws CustomException {
		// TODO Auto-generated method stub
		return quotationDao.getRequisitionList(companyId);
	}

	@Override
	public List<StoreToStore> getWorkOrderList(String companyId) throws CustomException {
		// TODO Auto-generated method stub
		return quotationDao.getWorkOrderList(companyId);
	}

	@Override
	public PurchaseQuotationResultBean getWOItem(int requisitionId, int itemId) throws CustomException {
		// TODO Auto-generated method stub
		return quotationDao.getWOItem(requisitionId, itemId);
	}
}
