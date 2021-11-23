package com.dci.operation.containerReleaseOrder;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.model.CommonUtilityBean;
import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CommonUtilityQueryUtil;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")
public class containerReleaseOrderDaoImpl implements containerReleaseOrderDao {

	private final static Logger LOGGER = Logger.getLogger(containerReleaseOrderDaoImpl.class);

	@Autowired
	DataSource dataSource;
	@Autowired
	UserLogDAO userlogDao;
	
	@Autowired
	AuditLogDAO auditLogDao;

	@Override
	public containerReleaseOrderResultBean uploadEmployeeExcel(MultipartFile file) throws Exception {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<String> errorList = new ArrayList<>();
		containerReleaseOrderResultBean memberCreationResultBean = new containerReleaseOrderResultBean();
		List<containerReleaseOrderBean> membersList = new ArrayList<>();
		List<containerReleaseOrderBean> errorMembersList = new ArrayList<>();
		UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		boolean isSuccess = false;
		String fileName = file.getOriginalFilename();
		Iterator<Row> rowIterator = null;
		Workbook workbook = null;
		int memberType = 0;
		String userFlag = "e";
		int i = 0;
		boolean errorFlag = false;
		try {
			org.apache.poi.ss.usermodel.Workbook wb_xssf; // Declare XSSF
			org.apache.poi.ss.usermodel.Workbook wb_hssf; // Declare HSSF
			int j = 0;
			Sheet sheet = null;
			if (fileName.endsWith("xls")) {
				workbook = new HSSFWorkbook(file.getInputStream());
				HSSFSheet sheet1 = (HSSFSheet) workbook.getSheetAt(0);
				rowIterator = sheet1.rowIterator();
				j = 2;
			} else if (fileName.endsWith("xlsx")) {

				workbook = new XSSFWorkbook(file.getInputStream());
				XSSFSheet sheet1 = (XSSFSheet) workbook.getSheetAt(0);
				rowIterator = sheet1.rowIterator();
				j = 1;

			} else {
				System.out.println("Not a valid file format");
			}

			int rowCnt = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				rowCnt += 1;
				if (rowCnt > j) {
					boolean customFlag = false;
					Iterator<Cell> cellIterator = row.cellIterator();
					containerReleaseOrderBean memberCreationBean = new containerReleaseOrderBean();
					String error = "";

					/*
					 * Cell invoiceNo = row.getCell(0); if (invoiceNo == null ||
					 * invoiceNo.getCellType() == Cell.CELL_TYPE_BLANK) { error = "\n" + "Row" +
					 * rowCnt + " Dw Bill No should not be empty"; System.out.println(error); } else
					 * { //memberCreationBean.setInvoiceNo(invoiceNo.getStringCellValue()); //int
					 * invoiceCount =
					 * jdbcTemplate.queryForObject(DwellTimeInvoiceQueryUtil.CHECK_INVOICE, new
					 * Object[] { invoiceNo.getStringCellValue() }, Integer.class);
					 * 
					 * int invoiceCount=0; if (invoiceCount > 0) { error = "\n" + "Row" + rowCnt +
					 * " Invoice No : " + invoiceNo.getStringCellValue() + " already exists";
					 * customFlag=true; System.out.println(error); }
					 * 
					 * }
					 */

					Cell containerNO = row.getCell(1);
					if (containerNO == null || containerNO.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + "container NO should not be empty";
						System.out.println(error);
					} else {

						String container = containerNO.getStringCellValue();
						int containerCount = jdbcTemplate.queryForObject(containerReleaseOrderQueryUtil.CONTAINER_COUNT,
								new Object[] { container }, Integer.class);
						int containerDup = jdbcTemplate.queryForObject(containerReleaseOrderQueryUtil.CHK_DUP_CON,
								new Object[] { container }, Integer.class);
						// containerCount=1;

						/* if(containerDup==0) { */
						if (containerCount == 0) {
							error = "\n" + "Row" + rowCnt + " Container : " + containerNO + " not available";
							customFlag = true;
						} else
							memberCreationBean.setContainerNo(containerNO.getStringCellValue());

						/*
						 * }else {
						 * 
						 * error = "\n" + "Row" + rowCnt + " Container : " + containerNO +
						 * " already in CRO system"; customFlag=true;
						 * 
						 * }
						 */

					}

					Cell containerType = row.getCell(2);
					if (containerType == null || containerType.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " container Type should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setContainertype(containerType.getStringCellValue());
					}

					Cell releaseDate = row.getCell(3);
					if (releaseDate == null || releaseDate.getCellType() == Cell.CELL_TYPE_BLANK) {
						error = error + "\n" + "Row" + rowCnt + " Release Date should not be empty";
						System.out.println(error);
					} else {

						memberCreationBean.setReleaseDate(releaseDate.getStringCellValue());

					}

					Cell sealNumber = row.getCell(4);
					/*
					 * if (sealNumber == null || sealNumber.getCellType() == Cell.CELL_TYPE_BLANK) {
					 * error = error + "\n" + "Row" + rowCnt + " seal Number should not be empty";
					 * System.out.println(error); } else {
					 */

					memberCreationBean.setSealNo(sealNumber.getStringCellValue());
					/* } */

					//
					Cell outbound = row.getCell(5);
					/*
					 * if (outbound == null || outbound.getCellType() == Cell.CELL_TYPE_BLANK) {
					 * error = error + "\n" + "Row" + rowCnt + " IGST should not be empty";
					 * System.out.println(error); } else {
					 */

					memberCreationBean.setOutBoundMode(outbound.getStringCellValue());
					/* } */

					Cell returnDate = row.getCell(6);
					/*
					 * if (returnDate == null || returnDate.getCellType() == Cell.CELL_TYPE_BLANK) {
					 * error = error + "\n" + "Row" + rowCnt + " Return Date  should not be empty";
					 * System.out.println(error); } else {
					 */

					memberCreationBean.setReturnDate(returnDate.getStringCellValue());
					/* } */

					Cell emptyReturn = row.getCell(7);
					/*
					 * if (emptyReturn == null || emptyReturn.getCellType() == Cell.CELL_TYPE_BLANK)
					 * { error = error + "\n" + "Row" + rowCnt +
					 * " Empty Return should not be empty"; System.out.println(error); } else {
					 */

					memberCreationBean.setEmptyReturn(emptyReturn.getStringCellValue());

					/* } */

					Cell returnDepot = row.getCell(8);
					/*
					 * if (returnDepot == null || returnDepot.getCellType() == Cell.CELL_TYPE_BLANK)
					 * { error = error + "\n" + "Row" + rowCnt +
					 * " Return Depot should not be empty"; System.out.println(error); } else {
					 */

					memberCreationBean.setReturnDepot(returnDepot.getStringCellValue());

					/* } */

					Cell inBound = row.getCell(9);
					/*
					 * if (inBound == null || inBound.getCellType() == Cell.CELL_TYPE_BLANK) { error
					 * = error + "\n" + "Row" + rowCnt + " Inbound mode  should not be empty";
					 * System.out.println(error); } else {
					 */

					memberCreationBean.setInBoundMode(inBound.getStringCellValue());

					/* } */

					if (customFlag) {

						errorMembersList.add(memberCreationBean);

					} else {
						membersList.add(memberCreationBean);
					}
					if (!error.equalsIgnoreCase("")) {
						errorList.add(error);
					}
				}
			}
		} catch (Exception e) {

         LOGGER.error("Error in uploadEmployeeExcel", e);
			isSuccess = false;
		}

		// if (i <= 1)
		if (errorList.size() == 0 && i <= 1) {
			memberCreationResultBean.setQuotationinnerDtl(membersList);
		} else
			isSuccess = false;

		if (errorList.size() > 0) {
			errorFlag = false;

			List<String> answer = new ArrayList<>();

			for (String str : errorList)
				for (String s : str.split("\n")) {
					if (!s.isEmpty()) {
						answer.add(s);
					}

				}
			memberCreationResultBean.setSuccess(false);
			memberCreationResultBean.setErrorList(answer);
			// memberCreationResultBean.setErrorExcelList(errorMembersList);

		} else {
			errorFlag = true;
			memberCreationResultBean.setSuccess(true);
		}
		if (memberCreationResultBean.isSuccess()) {
			memberCreationResultBean.setSuccess(true);
		} else {
			memberCreationResultBean.setSuccess(false);
		}

		return memberCreationResultBean;
	}

	@Override
	public containerReleaseOrderResultBean getShipment() {

		containerReleaseOrderResultBean bean = new containerReleaseOrderResultBean();
		List<containerReleaseOrderBean> supplierList = new ArrayList<containerReleaseOrderBean>();
		List<containerReleaseOrderBean> customerList = new ArrayList<containerReleaseOrderBean>();
		List<containerReleaseOrderBean> currencyList = new ArrayList<containerReleaseOrderBean>();
		List<containerReleaseOrderBean> portList = new ArrayList<containerReleaseOrderBean>();
		List<containerReleaseOrderBean> chargeList = new ArrayList<containerReleaseOrderBean>();
		List<containerReleaseOrderBean> contypeList = new ArrayList<containerReleaseOrderBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			supplierList = jdbcTemplate.query(CommonUtilityQueryUtil.get_SHIPMENT,
					new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));

			currencyList = jdbcTemplate.query(CommonUtilityQueryUtil.get_currency,
					new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));

			portList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_PORT_LIST,
					new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));

			chargeList = jdbcTemplate.query(CommonUtilityQueryUtil.get_charge,
					new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));

			contypeList = jdbcTemplate.query(CommonUtilityQueryUtil.get_con,
					new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));

			customerList = jdbcTemplate.query(CommonUtilityQueryUtil.get_cust,
					new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));

			bean.setGetshipmentlist(supplierList);
			bean.setGetcurrencylist(currencyList);
			bean.setGetportlist(portList);
			bean.setGetchargetypelist(chargeList);
			bean.setGetcontypelist(contypeList);
			bean.setGetcustomerlist(customerList);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get customerList", e);
		}
		return bean;

	}

	@Override
	public containerReleaseOrderResultBean list() {
		containerReleaseOrderResultBean bean = new containerReleaseOrderResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<containerReleaseOrderBean> lQuotationBean = new ArrayList<containerReleaseOrderBean>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		try {
			if (!"Y".equalsIgnoreCase(userDetails.getIsVendor())) {
				lQuotationBean = jdbcTemplate.query(containerReleaseOrderQueryUtil.GET_CONTAINER_List, new Object[] {},
						new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));
				bean.setlQuotationBean(lQuotationBean);
				bean.setSuccess(true);
			} else {
				String whercon = " where depo in (" + userDetails.getUserPortStr() + ")";
				lQuotationBean = jdbcTemplate.query(containerReleaseOrderQueryUtil.GET_CONTAINER_List + whercon,
						new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));
				bean.setlQuotationBean(lQuotationBean);
				bean.setSuccess(true);
			}

		} catch (Exception e) {
			LOGGER.error("Error in list", e);
			bean.setSuccess(false);
			bean.setMessage("Error :" + e.getMessage());

		}
		return bean;
	}

	@Override
	public containerReleaseOrderResultBean getCustomerDetail(String quotHdId) {
		containerReleaseOrderResultBean bean = new containerReleaseOrderResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<containerReleaseOrderBean> lQuotationBean = new ArrayList<containerReleaseOrderBean>();

		try {

			lQuotationBean = jdbcTemplate.query(containerReleaseOrderQueryUtil.GET_CUST_BOOKING,
					new Object[] { quotHdId },
					new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));

			bean.setPopulateBookingNO(lQuotationBean);
			bean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error in getCustomerDetail", e);
			bean.setSuccess(false);
			bean.setMessage("Error :" + e.getMessage());

		}
		return bean;

	}

	@Override
	public containerReleaseOrderResultBean getcustomerpolpod(String quotHdId) {
		containerReleaseOrderResultBean bean = new containerReleaseOrderResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		containerReleaseOrderBean bean1 = new containerReleaseOrderBean();

		try {

			bean1 = jdbcTemplate.queryForObject(containerReleaseOrderQueryUtil.GET_CUST_POL_POD,
					new Object[] { quotHdId },
					new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));

			bean.setSeaQuotationBean(bean1);
			bean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error in get customer pol & pod", e);
			bean.setSuccess(false);
			bean.setMessage("Error :" + e.getMessage());

		}
		return bean;

	}

	@Override
	public containerReleaseOrderResultBean edit(String quotHdId) {
		containerReleaseOrderResultBean bean = new containerReleaseOrderResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		containerReleaseOrderBean bean1 = new containerReleaseOrderBean();
		List<containerReleaseOrderBean> lQuotationBean = new ArrayList<containerReleaseOrderBean>();
		List<containerReleaseOrderBean> innerDetail = new ArrayList<containerReleaseOrderBean>();

		try {

			bean1 = jdbcTemplate.queryForObject(containerReleaseOrderQueryUtil.edit_hdr, new Object[] { quotHdId },
					new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));

			lQuotationBean = jdbcTemplate.query(containerReleaseOrderQueryUtil.Edit_dtl, new Object[] { quotHdId },
					new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));

			/*
			 * for(int j = 0 ;j< lQuotationBean.size();j++){
			 * 
			 * String detail_id= lQuotationBean.get(j).getContainerRelID();
			 * 
			 * innerDetail = jdbcTemplate.query(
			 * containerReleaseOrderQueryUtil.edit_inner_dtl, new Object[] { detail_id },
			 * new BeanPropertyRowMapper<containerReleaseOrderBean>(
			 * containerReleaseOrderBean.class));
			 * lQuotationBean.get(j).setQuotationinnerDtl(innerDetail); }
			 */

			innerDetail = jdbcTemplate.query(containerReleaseOrderQueryUtil.Edit_Seal, new Object[] { quotHdId },
					new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));

			bean.setSeaQuotationBean(bean1);
			bean.setlQuotationBean(lQuotationBean);
			bean.setSealdtl(innerDetail);
			bean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error in edit", e);
			bean.setSuccess(false);
			bean.setMessage("Error :" + e.getMessage());

		}
		return bean;

	}

	@Override
	public containerReleaseOrderResultBean view(Integer quotHdId) {
		/*
		 * QuotationResultBean bean = new QuotationResultBean(); JdbcTemplate
		 * jdbcTemplate = new JdbcTemplate(dataSource); List<SeaQuotationBean>
		 * lQuotationBean = new ArrayList<SeaQuotationBean>(); List<TruckconBean> lBean
		 * = new ArrayList<TruckconBean>(); List<SeaQuotationBean> filefile = new
		 * ArrayList<SeaQuotationBean>(); List<SeaQuotationBean> fileList = new
		 * ArrayList<SeaQuotationBean>(); try { lQuotationBean = jdbcTemplate.query(
		 * QuotationQueryUtil.GET_SEA_QUOTATION_View, new Object[] { quotHdId }, new
		 * BeanPropertyRowMapper<SeaQuotationBean>( SeaQuotationBean.class));
		 * 
		 * List<SeaQuotationDtlPair> lQuotationPortPair = jdbcTemplate.query(
		 * QuotationQueryUtil.GET_SEA_QUOTATION_Dtl_View, new Object[] { quotHdId }, new
		 * BeanPropertyRowMapper<SeaQuotationDtlPair>( SeaQuotationDtlPair.class));
		 * lBean = jdbcTemplate.query(AirQuotationQueryUtil.list2, new
		 * BeanPropertyRowMapper<TruckconBean>(
		 * TruckconBean.class),lQuotationBean.get(0).getQuotationNo()); String dummy =
		 * jdbcTemplate.queryForObject(QuotationQueryUtil.dummy,String.class,quotHdId);
		 * filefile = jdbcTemplate.query(QuotationQueryUtil.FILE_LIST,new
		 * BeanPropertyRowMapper<SeaQuotationBean>(SeaQuotationBean.class),dummy);
		 * fileList = jdbcTemplate.query(QuotationQueryUtil.FILE_LIST,new
		 * BeanPropertyRowMapper<SeaQuotationBean>(SeaQuotationBean.class),
		 * lQuotationBean.get(0).getQuotationNo());
		 * 
		 * // String[] name = fileList.split("/"); // String filepath = name[0] + "/" +
		 * name[1] +"/"+name[2] +"/" +name[3] +"/" +name[4] +"/" +name[5] +"/"+name[6];
		 * // String filename = name[6];
		 * 
		 * bean.setFileList(fileList); bean.setFilePath(filefile);
		 * bean.setFile(filefile); bean.setFilel(filefile);
		 * bean.setlQuotationBean(lQuotationBean);
		 * lQuotationBean.get(0).setQuotationDtl(lQuotationPortPair);
		 * bean.setlBean(lBean); bean.setSuccess(true); } catch (Exception e) {
		 * LOGGER.error("Error in view", e); bean.setSuccess(false);
		 * bean.setMessage("Error :" + e.getMessage());
		 * 
		 * } return bean;
		 */return null;
	}

	@Override
	public containerReleaseOrderResultBean save(containerReleaseOrderBean bean) {
		containerReleaseOrderResultBean rbean = new containerReleaseOrderResultBean();
		List<containerReleaseOrderBean> releaseOrderBean = new ArrayList<containerReleaseOrderBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		try {
			for (containerReleaseOrderBean obj : bean.getQuotationDtl()) {
				int k=0;
				for(containerReleaseOrderBean orderBean : releaseOrderBean){
					if(obj.getConType().equalsIgnoreCase(orderBean.getConType())){
						int quantity=Integer.parseInt(orderBean.getQuantity())+Integer.parseInt(obj.getQuantity());
						orderBean.setQty(quantity);
						k++;
					}
				}
				if(k ==0){
					releaseOrderBean.add(obj);

				}
				
			}
			String booking_no = bean.getBookingNo();
    List<containerReleaseOrderBean> containerOrderBeanList = jdbcTemplate.query(containerReleaseOrderQueryUtil.GET_CONTAINER_QTY_TYPE_BY_BOOKING,
			new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class),bean.getBookingNo(),bean.getBookingNo());
			
    int conCompareStatus=0;
    
    for(containerReleaseOrderBean availableCont :containerOrderBeanList){
    
    	for(containerReleaseOrderBean allotedCont :releaseOrderBean){
        	 if(availableCont.getConType().equalsIgnoreCase(allotedCont.getConType())){
        		 if(Integer.parseInt(allotedCont.getQuantity()) >  availableCont.getQty()){
        			 conCompareStatus++; 
        		 }
        	 }
        }
    	
    }
			if(conCompareStatus == 0){
			int hdrcnt = 0;
			int dtlcnt = 0;
			String CONTAINER_CODE = "";
			CONTAINER_CODE = jdbcTemplate.queryForObject(containerReleaseOrderQueryUtil.GENERATE_CONTAINER_CODE,
					String.class);

			jdbcTemplate.update(containerReleaseOrderQueryUtil.SAVE_CONTAINER_HDR, new Object[] { CONTAINER_CODE,
					bean.getCustomer(), bean.getBookingNo(), bean.getDepot(), bean.getCroDate(), userId });
        	UserLog userLog = userlogDao.userLogForInsert(bean, CONTAINER_CODE, userDetails.getUserId());

			int i = 0;
			for (containerReleaseOrderBean obj : bean.getQuotationDtl()) {
				i++;
				String CONTAINER_DETAIL_id = jdbcTemplate
						.queryForObject(containerReleaseOrderQueryUtil.GENERATE_CONTAINER_CODE_DET, String.class);

				jdbcTemplate.update(containerReleaseOrderQueryUtil.SAVE_CONTAINER_DTL, new Object[] { CONTAINER_CODE,
						obj.getConType(), obj.getConNumber(), obj.getQuantity(), i, CONTAINER_DETAIL_id });
	        	UserLog userLogs = userlogDao.userLogForInsert(obj, CONTAINER_DETAIL_id, userDetails.getUserId());

			}

			int j = 0;
			for (containerReleaseOrderBean obj1 : bean.getSealDtl()) {
				j++;

				jdbcTemplate.update(containerReleaseOrderQueryUtil.SAVE_DETAIL_SEAL,
						new Object[] { obj1.getSealFrom(), obj1.getSealTo(), obj1.getCount(), j, CONTAINER_CODE });
	        	UserLog userLogs = userlogDao.userLogForInsert(obj1, CONTAINER_CODE, userDetails.getUserId());

			}

			/*
			 * int j=0; for(containerReleaseOrderBean obj1 : obj.getQuotationinnerDtl()){
			 * j++; boolean emp=false; String emptyReturn=obj1.getEmptyReturn();
			 * 
			 * if(emptyReturn.equalsIgnoreCase("NO")){
			 * 
			 * emp=false; }else emp=true;
			 * 
			 * String returnDate=null; if(obj1.getReturnDate()!=null &&
			 * !obj1.getReturnDate().equalsIgnoreCase("")) {
			 * 
			 * returnDate=obj1.getReturnDate();
			 * 
			 * } else {
			 * 
			 * returnDate=null;
			 * 
			 * }
			 * 
			 * jdbcTemplate.update(containerReleaseOrderQueryUtil.SAVE_DETAIL_CONTAINER,new
			 * Object[]
			 * {j,CONTAINER_DETAIL_id,obj1.getContainertype(),obj1.getContainerNo(),obj1.
			 * getSealNo(),userId,"C0001",obj1.getReleaseDate(),returnDate,obj1.
			 * getReturnDepot(),emp,CONTAINER_CODE,obj1.getInBoundMode(),obj1.
			 * getOutBoundMode()});
			 * 
			 * 
			 * Integer
			 * GET_CONTAINER_ID=jdbcTemplate.queryForObject(containerReleaseOrderQueryUtil.
			 * GET_CONTAINER_ID,new Object[] {obj1.getContainerNo()}, Integer.class);
			 * 
			 * if(!obj1.getReleaseDate().equalsIgnoreCase(null) &&
			 * !obj1.getReleaseDate().equalsIgnoreCase("")) {
			 * 
			 * jdbcTemplate.update(containerReleaseOrderQueryUtil.
			 * SAVE_DETAIL_CONTAINER_STATUS,new Object[]
			 * {GET_CONTAINER_ID,obj1.getContainertype(),"RTS",obj1.getReleaseDate(),bean.
			 * getPol(),bean.getPod(),CONTAINER_CODE,userId,1,obj1.getReturnDepot(),"F0104"}
			 * );
			 * 
			 * } if(!obj1.getReturnDate().equalsIgnoreCase(null) &&
			 * !obj1.getReturnDate().equalsIgnoreCase("")) {
			 * 
			 * jdbcTemplate.update(containerReleaseOrderQueryUtil.
			 * SAVE_DETAIL_CONTAINER_STATUS,new Object[]
			 * {GET_CONTAINER_ID,obj1.getContainertype(),"RNS",obj1.getReturnDate(),bean.
			 * getPol(),bean.getPod(),CONTAINER_CODE,userId,1,obj1.getReturnDepot(),"F0104"}
			 * );
			 * 
			 * } }
			 */

			/* } */
			rbean.setSuccess(true);
			rbean.setMessage(CONTAINER_CODE);
		}
			else{
				rbean.setMessage("Container quantity should be less than or equal to booking container quantity!");
				rbean.setSuccess(false);
			}

		} catch (Exception e) {
			LOGGER.error("Error in save", e);
			rbean.setMessage("Error :" + e.getMessage());
			rbean.setSuccess(false);
		}
		return rbean;
	}

	@Override
	public containerReleaseOrderResultBean delete(String quotationHdId) {
		containerReleaseOrderResultBean rbean = new containerReleaseOrderResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		containerReleaseOrderResultBean oldbean = edit(quotationHdId);
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();

			jdbcTemplate.update(containerReleaseOrderQueryUtil.DELETE_SEAL_DTL, new Object[] { quotationHdId });
			jdbcTemplate.update(containerReleaseOrderQueryUtil.DELETE_CONTAINER_DTL, new Object[] { quotationHdId });
			jdbcTemplate.update(containerReleaseOrderQueryUtil.DELETE_CONTAINER_HDR, new Object[] { quotationHdId });

			// rbean.setCode(quotationHdId);
			/*
			 * userlogDao.userLogForDelete(beanlog, quotationHdId + "",
			 * userDetails.getUserId());
			 */
			UserLog userLog = userlogDao.userLogForDelete(oldbean,quotationHdId, userDetails.getUserId());

			rbean.setMessage("Quotation Deleted Successfully");
			rbean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error in delete", e);
			rbean.setMessage("Error :" + e.getMessage());
			rbean.setSuccess(false);
		}
		return rbean;
	}

	@Override
	public containerReleaseOrderResultBean approve(String quotation) {
		containerReleaseOrderResultBean rbean = new containerReleaseOrderResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			jdbcTemplate.update(containerReleaseOrderQueryUtil.APPROVE_QUOTATION, new Object[] { userId, quotation });

			rbean.setCode(quotation);
			rbean.setMessage("Quotation Approved Successfully");
			rbean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error in approve", e);
			rbean.setMessage("Error :" + e.getMessage());
			rbean.setSuccess(false);
		}
		return rbean;
	}

	@Override
	public containerReleaseOrderResultBean downloadfile(String quotationNo) {
		String filePath = "";

		containerReleaseOrderResultBean seaquotation = new containerReleaseOrderResultBean();

		List<containerReleaseOrderBean> urlList = new ArrayList<containerReleaseOrderBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			urlList = jdbcTemplate.query(containerReleaseOrderQueryUtil.GET_FILES, new Object[] { quotationNo },
					new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));

			seaquotation.setFileList(urlList);

		} catch (Exception ae) {
			LOGGER.error("Error in dwld file", ae);
		}
		return seaquotation;
	}

	public String generateQuotationNo(Integer branchId, String IE) {

		String quotation = "";
		String quotationBranch = "";
		String dateYear = "";
		int count = 0;
		int count1 = 0;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(containerReleaseOrderQueryUtil.getQuotBranch,
					branchId, IE);
			for (Map row : rows) {
				quotationBranch = (String) row.get("quotBranch");
			}

			List<Map<String, Object>> rows1 = jdbcTemplate
					.queryForList(containerReleaseOrderQueryUtil.getQuotCount(quotationBranch));
			for (Map row2 : rows1) {
				count = (int) row2.get("count");
				count1 = count + 1;
			}

			List<Map<String, Object>> rows4 = jdbcTemplate.queryForList(containerReleaseOrderQueryUtil.DateandYear);
			for (Map row5 : rows4) {
				dateYear = (String) row5.get("dateYear");
			}

			if (count <= 9) {
				count1 = count + 1;
				quotation = quotationBranch + "/" + dateYear + "/" + "000" + count1;

			} else if (count <= 99) {
				count1 = count + 1;
				quotation = quotationBranch + "/" + dateYear + "/" + "00" + count1;

			} else if (count <= 999) {
				count1 = count + 1;
				quotation = quotationBranch + "/" + dateYear + "/" + "0" + count1;
			} else {
				count1 = count + 1;
				quotation = quotationBranch + "/" + dateYear + "/" + count1;
			}

			// quotation = quotationBranch + "/" + dateYear + "/" + count1;

			int id = checkQuoExists(quotation);

			if (id > 0) {
				generateQuotationNo(branchId, IE);
			}

		} catch (Exception e) {
			LOGGER.error("Error in generate code", e);
		}
		return quotation;
	}

	public String generateQuotationNoUpdate(Integer branchId, String IE, BigInteger QID) {

		String quotation = "";
		String quotationBranch = "";
		String dateYear = "";
		int count = 0;
		int count1 = 0;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(containerReleaseOrderQueryUtil.getQuotBranch,
					branchId, IE);
			for (Map row : rows) {
				quotationBranch = (String) row.get("quotBranch");
			}

			List<Map<String, Object>> rows1 = jdbcTemplate
					.queryForList(containerReleaseOrderQueryUtil.getQuotCountUpdate(quotationBranch, QID));
			for (Map row2 : rows1) {
				count = (int) row2.get("count");
				count1 = count + 1;
			}

			List<Map<String, Object>> rows4 = jdbcTemplate.queryForList(containerReleaseOrderQueryUtil.DateandYear);
			for (Map row5 : rows4) {
				dateYear = (String) row5.get("dateYear");
			}

			if (count <= 9) {
				count1 = count + 1;
				quotation = quotationBranch + "/" + dateYear + "/" + "000" + count1;

			} else if (count <= 99) {
				count1 = count + 1;
				quotation = quotationBranch + "/" + dateYear + "/" + "00" + count1;

			} else if (count <= 999) {
				count1 = count + 1;
				quotation = quotationBranch + "/" + dateYear + "/" + "0" + count1;
			} else {
				count1 = count + 1;
				quotation = quotationBranch + "/" + dateYear + "/" + count1;
			}

			// quotation = quotationBranch + "/" + dateYear + "/" + count1;

			int id = checkQuoExists(quotation);

			if (id > 0) {
				generateQuotationNo(branchId, IE);
			}

		} catch (Exception e) {
			LOGGER.error("Error in generate no", e);
		}
		return quotation;
	}

	public int checkQuoExists(String quotation) {
		int id = 0;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			id = jdbcTemplate.queryForObject(containerReleaseOrderQueryUtil.CHECK_QUOTATION_EXISTS,
					new Object[] { quotation }, Integer.class);

		} catch (Exception e) {
			LOGGER.error("Error in generate no", e);
		}
		return id;
	}

	@Override
	public List<CommonUtilityBean> getiataList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(containerReleaseOrderQueryUtil.PORT_LIST, new Object[] {},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getCurrencyList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(containerReleaseOrderQueryUtil.GET_CURRENCY, new Object[] {},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getServicePartner() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(containerReleaseOrderQueryUtil.Get_Service_Partner, new Object[] {},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getServicePartnerType() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(containerReleaseOrderQueryUtil.Get_Service_Partner_Type,
					new Object[] {}, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getBranch() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			lCommonUtilityBean = jdbcTemplate.query(containerReleaseOrderQueryUtil.GET_Branch,
					new Object[] { userDetails.getUserId() },
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public void insertFiles(String quotationNumber, String filename, String path) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(containerReleaseOrderQueryUtil.INSERT_FILES,
					new Object[] { quotationNumber, filename, path });

		} catch (Exception se) {
			LOGGER.error("Error in insertFiles", se);

			throw se;
		}

	}

	@Override
	public List<CommonUtilityBean> getEmployeeList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(containerReleaseOrderQueryUtil.Get_Employee_list, new Object[] {},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getChargeHeads() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(containerReleaseOrderQueryUtil.Get_Charge_Head_list,
					new Object[] {}, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getTerms() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(containerReleaseOrderQueryUtil.Get_Terms, new Object[] {},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public containerReleaseOrderResultBean update(containerReleaseOrderBean bean) {

		containerReleaseOrderResultBean rbean = new containerReleaseOrderResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		containerReleaseOrderResultBean oldbean = edit(bean.getContainerreleaseCode());
		try {
			int hdrcnt = 0;
			int dtlcnt = 0;

			jdbcTemplate.update(containerReleaseOrderQueryUtil.UPDATE_CONTAINER_HDR, new Object[] { bean.getCustomer(),
					bean.getBookingNo(), bean.getDepot(), bean.getCroDate(), userId, bean.getContainerreleaseCode() });
        	UserLog userLog = userlogDao.userLogForUpdate(oldbean, bean, bean.getContainerreleaseCode(), userDetails.getUserId());

			/*
			 * jdbcTemplate.update(containerReleaseOrderQueryUtil.DELETE_INNER_DTL,new
			 * Object[] { bean.getContainerreleaseCode() });
			 */

			jdbcTemplate.update(containerReleaseOrderQueryUtil.DELETE_CONTAINER_DTL,
					new Object[] { bean.getContainerreleaseCode() });
			jdbcTemplate.update(containerReleaseOrderQueryUtil.DELETE_SEAL_DTL,
					new Object[] { bean.getContainerreleaseCode() });
			UserLog userLogss = userlogDao.userLogForDelete(oldbean, bean.getContainerreleaseCode(), userDetails.getUserId());

			int i = 0;
			for (containerReleaseOrderBean obj : bean.getQuotationDtl()) {
				i++;
				String CONTAINER_DETAIL_id = jdbcTemplate
						.queryForObject(containerReleaseOrderQueryUtil.GENERATE_CONTAINER_CODE_DET, String.class);

				jdbcTemplate.update(containerReleaseOrderQueryUtil.SAVE_CONTAINER_DTL,
						new Object[] { bean.getContainerreleaseCode(), obj.getConType(), obj.getConNumber(),
								obj.getQuantity(), i, CONTAINER_DETAIL_id });
            	UserLog userLogs = userlogDao.userLogForInsert(obj, CONTAINER_DETAIL_id, userDetails.getUserId());

			}

			int j = 0;
			for (containerReleaseOrderBean obj1 : bean.getSealDtl()) {
				j++;

				jdbcTemplate.update(containerReleaseOrderQueryUtil.SAVE_DETAIL_SEAL, new Object[] { obj1.getSealFrom(),
						obj1.getSealTo(), obj1.getCount(), j, bean.getContainerreleaseCode() });
            	UserLog userLogs = userlogDao.userLogForInsert(obj1, bean.getContainerreleaseCode(), userDetails.getUserId());

			}
			/*
			 * int j=0; for(containerReleaseOrderBean obj1 : obj.getQuotationinnerDtl()){
			 * j++; boolean emp=false; String emptyReturn=obj1.getEmptyReturn();
			 * 
			 * if(emptyReturn.equalsIgnoreCase("NO") &&
			 * !emptyReturn.equalsIgnoreCase(null)){
			 * 
			 * emp=false; } else emp=true;
			 * 
			 * jdbcTemplate.update(containerReleaseOrderQueryUtil.SAVE_DETAIL_CONTAINER,new
			 * Object[]
			 * {j,CONTAINER_DETAIL_id,obj1.getContainertype(),obj1.getContainerNo(),obj1.
			 * getSealNo(),userId,"C0001",obj1.getReleaseDate(),obj1.getReturnDate(),obj1.
			 * getReturnDepot(),emp,bean.getContainerreleaseCode(),obj1.getInBoundMode(),
			 * obj1.getOutBoundMode()});
			 * 
			 * 
			 * Integer
			 * GET_CONTAINER_ID=jdbcTemplate.queryForObject(containerReleaseOrderQueryUtil.
			 * GET_CONTAINER_ID,new Object[] {obj1.getContainerNo()}, Integer.class);
			 * 
			 * int RTSCount =
			 * jdbcTemplate.queryForObject(containerReleaseOrderQueryUtil.RTS_COUNT, new
			 * Object[] { obj1.getContainerNo() }, Integer.class); if(RTSCount==0){
			 * if(obj1.getReleaseDate()!=null &&
			 * !obj1.getReleaseDate().equalsIgnoreCase("")) {
			 * 
			 * jdbcTemplate.update(containerReleaseOrderQueryUtil.
			 * SAVE_DETAIL_CONTAINER_STATUS,new Object[]
			 * {GET_CONTAINER_ID,obj1.getContainertype(),"RTS",obj1.getReleaseDate(),bean.
			 * getPol(),bean.getPod(),
			 * bean.getContainerreleaseCode(),userId,1,obj1.getReturnDepot(),"F0104"});
			 * 
			 * } }
			 * 
			 * int RNSCount =
			 * jdbcTemplate.queryForObject(containerReleaseOrderQueryUtil.RNS_COUNT, new
			 * Object[] { obj1.getContainerNo() }, Integer.class);
			 * 
			 * if(RNSCount==0){ if(obj1.getReturnDate()!=null &&
			 * !obj1.getReturnDate().equalsIgnoreCase("")) {
			 * 
			 * jdbcTemplate.update(containerReleaseOrderQueryUtil.
			 * SAVE_DETAIL_CONTAINER_STATUS,new Object[]
			 * {GET_CONTAINER_ID,obj1.getContainertype(),"RNS",obj1.getReturnDate(),bean.
			 * getPol(),bean.getPod(),
			 * bean.getContainerreleaseCode(),userId,1,obj1.getReturnDepot(),"F0104"});
			 * 
			 * }
			 * 
			 * }
			 * 
			 * }
			 * 
			 * rbean.setSuccess(true); }
			 */
			rbean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error in update", e);
			rbean.setMessage("Error :" + e.getMessage());
			rbean.setSuccess(false);
		}
		return rbean;
	}

	@Override
	public List<CommonUtilityBean> getUnitList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(containerReleaseOrderQueryUtil.Get_Unit, new Object[] {},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public containerReleaseOrderBean print(Integer quotationHdId) {
		/*
		 * JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); UserDetail
		 * userDetails = (UserDetail)
		 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); String
		 * userId = userDetails.getUserId(); SeaQuotationBean objGeneralInvoiceBean =
		 * null; SeaQuotationBean bean = new SeaQuotationBean();
		 * List<SeaQuotationDtlPair> lGIDetList = new ArrayList<SeaQuotationDtlPair>();
		 * try { objGeneralInvoiceBean = new SeaQuotationBean();
		 * 
		 * String name =
		 * jdbcTemplate.queryForObject(JobOrderAirQueryUtil.name,String.class, userId);
		 * objGeneralInvoiceBean = jdbcTemplate.queryForObject(
		 * QuotationQueryUtil.Get_Hdr_Sea_Quotation, new Object[] { quotationHdId }, new
		 * BeanPropertyRowMapper<SeaQuotationBean>( SeaQuotationBean.class));
		 * 
		 * lGIDetList = jdbcTemplate.query( QuotationQueryUtil.Get_Dtl_Sea_Quotation,
		 * new Object[] { quotationHdId }, new
		 * BeanPropertyRowMapper<SeaQuotationDtlPair>( SeaQuotationDtlPair.class));
		 * 
		 * 
		 * List<Map<String, Object>> rows =
		 * jdbcTemplate.queryForList(CustomerInvoiceQueryUtil
		 * .GET_GENERAL_INVOICE_DTL_TOTAL, new Object[] { invoiceNo }); for (Map row :
		 * rows) { objGeneralInvoiceBean.setTotalBCamount(((BigDecimal)
		 * row.get("BC_AMOUNT")).doubleValue());
		 * objGeneralInvoiceBean.setTotalTCamount(((BigDecimal)
		 * row.get("TC_AMOUNT")).doubleValue()); }
		 * 
		 * 
		 * // String currencyName = //
		 * jdbcTemplate.queryForObject(QuotationQueryUtil.GET_CURRENCY_NAME, // new
		 * Object[] { objGeneralInvoiceBean.getCurrency() // },String.class);
		 * 
		 * objGeneralInvoiceBean.setQuotationDtl(lGIDetList);
		 * objGeneralInvoiceBean.setName(name);
		 * 
		 * } catch (DataAccessException e) { LOGGER.error("Error in view data GI:::",
		 * e); } return objGeneralInvoiceBean;
		 */ return null;
	}

	@Override
	public containerReleaseOrderResultBean saveasDraft(containerReleaseOrderBean bean) {
		return null;
		/*
		 * QuotationResultBean rbean = new QuotationResultBean(); JdbcTemplate
		 * jdbcTemplate = new JdbcTemplate(dataSource); try { UserDetail userDetails =
		 * (UserDetail) SecurityContextHolder
		 * .getContext().getAuthentication().getPrincipal(); String userId =
		 * userDetails.getUserId(); String IE = ""; if (bean.getService() == 1) { IE =
		 * "E"; } else { IE = "I"; } String quotation =
		 * generateQuotationNo(bean.getBranch(), IE); String attention =
		 * bean.getAttention(); String carrier = bean.getCarrier(); String remarks =
		 * bean.getRemarks(); String QuotationDate = bean.getQuotationDate(); String
		 * salesPerson = bean.getSalesPerson(); String termConditions =
		 * bean.getTermConditions(); String ValidityDate = bean.getValidityDate();
		 * Integer Aod = bean.getAod(); Integer Aol = bean.getAol(); Integer branch =
		 * bean.getBranch(); Integer consignee = bean.getConsignee(); Integer curr =
		 * bean.getCurrency(); Integer customer = bean.getCustomer(); Integer
		 * destination = bean.getDestination(); Integer mode = bean.getMode(); Integer
		 * nominatedBy = bean.getNominatedBy(); Integer origin = bean.getOrigin();
		 * Integer salesType = bean.getSalesType(); Integer service = bean.getService();
		 * Integer shipper = bean.getShipper(); Integer term = bean.getTerm(); Integer
		 * vendor = bean.getVendor(); String vessel = bean.getVessel(); String dimension
		 * = bean.getDimensionName(); String termsConditions = bean.getTermConditions();
		 * Long qutHdId = null; List<Map<String, Object>> rows = jdbcTemplate
		 * .queryForList(QuotationQueryUtil.QUOTATION_DRAFT_HD_ID); for (Map row : rows)
		 * { qutHdId = (Long) row.get("QHdId"); }
		 * 
		 * List<SeaQuotationDtlPair> quotationportpair = bean .getQuotationDtl();
		 * 
		 * Integer quoteHdId = jdbcTemplate.queryForObject(
		 * QuotationQueryUtil.INSERT_QUOTATION_DRAFT, new Object[] { quotation,
		 * attention, carrier, remarks, QuotationDate, salesPerson, termConditions,
		 * ValidityDate, Aod, Aol, branch, consignee, curr, customer, destination,
		 * nominatedBy, origin, salesType, service, shipper, term, vendor,
		 * bean.getCommodity(), qutHdId, userId, userId, vessel }, Integer.class); for
		 * (int pp = 0; pp <= quotationportpair.size() - 1; pp++) { Long qutDtlId =
		 * null; List<Map<String, Object>> rows1 = jdbcTemplate
		 * .queryForList(QuotationQueryUtil.QUOTATION_DRAFT_DTL_ID); for (Map row :
		 * rows1) { qutDtlId = (Long) row.get("QDtlId"); }
		 * 
		 * Integer quoteDtlId = jdbcTemplate .queryForObject(
		 * QuotationQueryUtil.INSERT_QUOTATION_DTL_DRAFT, new Object[] { quoteHdId,
		 * quotationportpair.get(pp).getChargeHeads(),
		 * quotationportpair.get(pp).getUnit(), quotationportpair.get(pp).getQty(),
		 * quotationportpair.get(pp).getRate(), quotationportpair.get(pp).getCurrency(),
		 * quotationportpair.get(pp).getPaymentMethod(),
		 * quotationportpair.get(pp).getTransactionType(),
		 * quotationportpair.get(pp).getBuySell().longValue(),
		 * quotationportpair.get(pp).getNote(),qutDtlId }, Integer.class); }
		 * rbean.setCode(quotation);
		 * rbean.setMessage("Quotation Saved as Draft Successfully");
		 * rbean.setSuccess(true); } catch (Exception e) {
		 * LOGGER.error("Error in draft", e); rbean.setMessage("Error :" +
		 * e.getMessage()); rbean.setSuccess(false); } return rbean;
		 */}

	@Override
	public containerReleaseOrderResultBean approve(
			containerReleaseOrderBean bean) {/*
												 * QuotationResultBean rbean = new QuotationResultBean(); JdbcTemplate
												 * jdbcTemplate = new JdbcTemplate(dataSource); try {
												 * 
												 * jdbcTemplate.update( QuotationQueryUtil.Delete_Sea_Quotation_tmp_Dtl,
												 * new Object[] { bean.getQuotationId() });
												 * jdbcTemplate.update(QuotationQueryUtil.Delete_Sea_Quotation_tmp, new
												 * Object[] { bean.getQuotationId() });
												 * 
												 * UserDetail userDetails = (UserDetail) SecurityContextHolder
												 * .getContext().getAuthentication().getPrincipal(); String userId =
												 * userDetails.getUserId(); String IE = ""; if (bean.getService() == 1)
												 * { IE = "E"; } else { IE = "I"; } String quotation =
												 * generateQuotationNo(bean.getBranch(), IE); String attention =
												 * bean.getAttention(); String carrier = bean.getCarrier(); String
												 * remarks = bean.getRemarks(); String QuotationDate =
												 * bean.getQuotationDate(); String salesPerson = bean.getSalesPerson();
												 * String termConditions = bean.getTermConditions(); String ValidityDate
												 * = bean.getValidityDate(); Integer Aod = bean.getAod(); Integer Aol =
												 * bean.getAol(); Integer branch = bean.getBranch(); Integer consignee =
												 * bean.getConsignee(); Integer curr = bean.getCurrency(); Integer
												 * customer = bean.getCustomer(); Integer destination =
												 * bean.getDestination(); Integer mode = bean.getMode(); Integer
												 * nominatedBy = bean.getNominatedBy(); Integer origin =
												 * bean.getOrigin(); Integer salesType = bean.getSalesType(); Integer
												 * service = bean.getService(); Integer shipper = bean.getShipper();
												 * Integer term = bean.getTerm(); Integer vendor = bean.getVendor();
												 * String vessel = bean.getVessel(); String dimension =
												 * bean.getDimensionName(); String termsConditions =
												 * bean.getTermConditions(); Long qutHdId = null; List<Map<String,
												 * Object>> rows = jdbcTemplate
												 * .queryForList(QuotationQueryUtil.QUOTATION_HD_ID); for (Map row :
												 * rows) { qutHdId = (Long) row.get("QHdId"); }
												 * 
												 * List<SeaQuotationDtlPair> quotationportpair = bean
												 * .getQuotationDtl();
												 * 
												 * Integer quoteHdId = jdbcTemplate.queryForObject(
												 * QuotationQueryUtil.INSERT_QUOTATION, new Object[] { quotation,
												 * attention, carrier, remarks, QuotationDate, salesPerson,
												 * termConditions, ValidityDate, Aod, Aol, branch, consignee, curr,
												 * customer, destination, nominatedBy, origin, bean.getCommodity(),
												 * qutHdId, userId, userId, vessel,dimension}, Integer.class); for (int
												 * pp = 0; pp <= quotationportpair.size() - 1; pp++) { Long qutDtlId =
												 * null; List<Map<String, Object>> rows1 = jdbcTemplate
												 * .queryForList(QuotationQueryUtil.QUOTATION_DTL_ID); for (Map row :
												 * rows1) { qutDtlId = (Long) row.get("QDtlId"); }
												 * 
												 * Integer quoteDtlId = jdbcTemplate .queryForObject(
												 * QuotationQueryUtil.INSERT_QUOTATION_DTL, new Object[] { quoteHdId,
												 * quotationportpair.get(pp) .getChargeHeads(),
												 * quotationportpair.get(pp).getUnit(),
												 * quotationportpair.get(pp).getQty(),
												 * quotationportpair.get(pp).getRate(),
												 * quotationportpair.get(pp).getCurrency(), quotationportpair.get(pp)
												 * .getPaymentMethod(), quotationportpair.get(pp) .getTransactionType(),
												 * quotationportpair.get(pp).getBuySell() .longValue(),
												 * quotationportpair.get(pp).getNote(), qutDtlId }, Integer.class); }
												 * rbean.setCode(quotation);
												 * rbean.setMessage("Quotation Saved Successfully");
												 * rbean.setSuccess(true); } catch (Exception e) { LOGGER.error("Error",
												 * e); rbean.setMessage("Error :" + e.getMessage());
												 * rbean.setSuccess(false); } return rbean;
												 */
		return null;
	}

	@Override
	public List<CommonUtilityBean> getuomList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(containerReleaseOrderQueryUtil.Get_Uom_List, new Object[] {},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<String> getFileNameList(Integer quotationHdId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<String> nameList = new ArrayList<String>();
		try {
			nameList = jdbcTemplate.queryForList(containerReleaseOrderQueryUtil.Get_File_Name_List,
					new Object[] { quotationHdId }, (String.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return nameList;
	}

	@Override
	public void updateFiles(String quotationNo, List<String> check, String filepath, List<String> filepaths) {
		List<String> quotationNumberList = Arrays.asList(quotationNo.split("\\s*,\\s*"));

		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(containerReleaseOrderQueryUtil.delete_FILES,
					new Object[] { quotationNumberList.get(0) });

			for (String listName : check) {
				jdbcTemplate.update(containerReleaseOrderQueryUtil.INSERT_FILES,
						new Object[] { quotationNumberList.get(0), listName, filepath });

			}
			for (String listName1 : filepaths) {
				jdbcTemplate.update(containerReleaseOrderQueryUtil.INSERT_FILES,
						new Object[] { quotationNumberList.get(0), listName1, filepath });

			}

		} catch (Exception se) {
			LOGGER.error("Error", se);
			throw se;
		}
	}

	@Override
	public containerReleaseOrderResultBean getServicePartnerDropdownList() {
		/*
		 * JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 * List<CommonUtilityBean> lCommonUtilityBean = new
		 * ArrayList<CommonUtilityBean>(); QuotationResultBean bean = new
		 * QuotationResultBean(); try { String
		 * qry=AirQuotationQueryUtil.Get_Service_Partner; lCommonUtilityBean =
		 * jdbcTemplate.query(qry+" where cstmr_bt='1' order by srvc_prtnr_cd",new
		 * Object[]{}, new
		 * BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		 * bean.setCustomerList(lCommonUtilityBean); lCommonUtilityBean = new
		 * ArrayList<CommonUtilityBean>(); lCommonUtilityBean =
		 * jdbcTemplate.query(qry+" where  cnsgn_bt='1' order by srvc_prtnr_cd",new
		 * Object[]{}, new
		 * BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		 * bean.setConsigneeList(lCommonUtilityBean); lCommonUtilityBean = new
		 * ArrayList<CommonUtilityBean>(); lCommonUtilityBean =
		 * jdbcTemplate.query(qry+" where shppr_bt='1' order by srvc_prtnr_cd",new
		 * Object[]{}, new
		 * BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		 * bean.setShipperList(lCommonUtilityBean); lCommonUtilityBean = new
		 * ArrayList<CommonUtilityBean>(); lCommonUtilityBean =
		 * jdbcTemplate.query(qry+" order by srvc_prtnr_cd",new Object[]{}, new
		 * BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		 * bean.setNominatedList(lCommonUtilityBean); lCommonUtilityBean = new
		 * ArrayList<CommonUtilityBean>(); lCommonUtilityBean =
		 * jdbcTemplate.query(qry+" where vndr_bt='1' order by srvc_prtnr_cd",new
		 * Object[]{}, new
		 * BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		 * bean.setVendorList(lCommonUtilityBean); lCommonUtilityBean = new
		 * ArrayList<CommonUtilityBean>(); lCommonUtilityBean =
		 * jdbcTemplate.query(qry+" order by srvc_prtnr_cd",new Object[]{}, new
		 * BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		 * bean.setServiceParnrList(lCommonUtilityBean);
		 * 
		 * } catch (DataAccessException e) { LOGGER.error("Error in addCodeStandard",
		 * e); }
		 */ return null;
	}

	@Override
	public containerReleaseOrderResultBean getServicePartnerDropdownListid(String id) {
		/*
		 * JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 * List<CommonUtilityBean> lCommonUtilityBean = new
		 * ArrayList<CommonUtilityBean>(); QuotationResultBean bean = new
		 * QuotationResultBean(); try { if(id.equalsIgnoreCase("1")){//buy String
		 * qry=AirQuotationQueryUtil.Get_Service_Partner; lCommonUtilityBean = new
		 * ArrayList<CommonUtilityBean>(); lCommonUtilityBean = jdbcTemplate.query(
		 * qry+" where sundry_type in ('20010002','20010003') order by srvc_prtnr_cd"
		 * ,new Object[]{}, new
		 * BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		 * bean.setServiceParnrList(lCommonUtilityBean); }else{//sell String
		 * qry=AirQuotationQueryUtil.Get_Service_Partner; lCommonUtilityBean = new
		 * ArrayList<CommonUtilityBean>(); lCommonUtilityBean = jdbcTemplate.query(
		 * qry+" where sundry_type in ('10080002','10080003') order by srvc_prtnr_cd"
		 * ,new Object[]{}, new
		 * BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		 * bean.setServiceParnrList(lCommonUtilityBean); }
		 * 
		 * 
		 * } catch (DataAccessException e) { LOGGER.error("Error in addCodeStandard",
		 * e); }
		 */ return null;
	}

	@Override
	public List<CommonUtilityBean> getcommodity() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(containerReleaseOrderQueryUtil.getcommodity, new Object[] {},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public boolean uploaddelete(String quotationNo) {
		boolean uploaddelete = false;

		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(containerReleaseOrderQueryUtil.delete_FILES, new Object[] { quotationNo });
			uploaddelete = true;

		} catch (Exception e) {
			LOGGER.error("Error in uploaddelete", e);

		}
		return uploaddelete;
	}

	@Override
	public boolean deletefiles(String fileName) {
		boolean filedelete = false;
		try {
			String qry1 = "";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			qry1 = " where file_name  like ('%" + fileName + "%')";

			String queryBuilder = containerReleaseOrderQueryUtil.delete_FILENAME + qry1;

			jdbcTemplate.update(queryBuilder);

			/*
			 * try{
			 * 
			 * JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			 * 
			 * jdbcTemplate.update(AirQuotationQueryUtil.delete_FILENAME, new Object[] {
			 * fileName}); filedelete = true;
			 */

		} catch (Exception e) {
			LOGGER.error("Error", e);

		}
		return filedelete;
	}

	@Override
	public containerReleaseOrderResultBean getCustomerList() {
		return null;
		/*
		 * JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 * List<CommonUtilityBean> lCommonUtilityBean = new
		 * ArrayList<CommonUtilityBean>(); QuotationResultBean bean = new
		 * QuotationResultBean(); try { String qry=AirQuotationQueryUtil.Get_Customer;
		 * lCommonUtilityBean = jdbcTemplate.query(qry+" order by srvc_prtnr_cd",new
		 * Object[]{}, new
		 * BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		 * bean.setCustomerList(lCommonUtilityBean);
		 * 
		 * 
		 * } catch (DataAccessException e) { LOGGER.error("Error in addCodeStandard",
		 * e); } return bean;
		 */}

	@Override
	public containerReleaseOrderResultBean getCustomerListCompany(String company) {
		/*
		 * JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 * List<CommonUtilityBean> lCommonUtilityBean = new
		 * ArrayList<CommonUtilityBean>(); QuotationResultBean bean = new
		 * QuotationResultBean(); try {
		 * 
		 * lCommonUtilityBean =
		 * jdbcTemplate.query(AirQuotationQueryUtil.Get_Customer_company,new
		 * Object[]{company,company}, new
		 * BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		 * 
		 * bean.setCustomerList(lCommonUtilityBean);
		 * 
		 * 
		 * } catch (DataAccessException e) { LOGGER.error("Error in addCodeStandard",
		 * e); } return bean;
		 */return null;
	}

	@Override
	public List<containerReleaseOrderBean> getContainerTypeDropDown() {
		List<containerReleaseOrderBean> list = new ArrayList<containerReleaseOrderBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(containerReleaseOrderQueryUtil.ContainerTypeList,
					new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));

		} catch (Exception e) {
			LOGGER.error("Error in getContainerTypeDropDown", e);

		}

		return list;
	}

	@Override
	public containerReleaseOrderPrintBean printBL(String blNo) {
		containerReleaseOrderPrintBean bean = new containerReleaseOrderPrintBean();

		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			bean = jdbcTemplate.queryForObject(containerReleaseOrderQueryUtil.GET_print, new Object[] { userId, blNo },
					new BeanPropertyRowMapper<containerReleaseOrderPrintBean>(containerReleaseOrderPrintBean.class));

		} catch (Exception e) {
			LOGGER.error("Error in bl", e);
		}
		return bean;
	}

	
	@Override
	public containerReleaseOrderPrintBean printreleaseOrder(String blNo) {
		containerReleaseOrderPrintBean bean = new containerReleaseOrderPrintBean();

		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			bean = jdbcTemplate.queryForObject(containerReleaseOrderQueryUtil.GET_print1, new Object[] {  blNo },
					new BeanPropertyRowMapper<containerReleaseOrderPrintBean>(containerReleaseOrderPrintBean.class));
			bean.setUserid(userDetails.getUsername());
		} catch (Exception e) {
			LOGGER.error("Error in printreleaseOrder", e);
		}
		return bean;
	}
	
	
	/*@Override
	public containerReleaseOrderPrintBean printCRO(String blNo) {
		containerReleaseOrderPrintBean bean = new containerReleaseOrderPrintBean();
		List<containerReleaseOrderPrintBean> containerDtl = new ArrayList<containerReleaseOrderPrintBean>();

		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			bean = jdbcTemplate.queryForObject(containerReleaseOrderQueryUtil.GET_print_CRO,
					new Object[] { userId, blNo },
					new BeanPropertyRowMapper<containerReleaseOrderPrintBean>(containerReleaseOrderPrintBean.class));

			containerDtl = jdbcTemplate.query(containerReleaseOrderQueryUtil.GET_print_CRO_dtl, new Object[] { blNo },
					new BeanPropertyRowMapper<containerReleaseOrderPrintBean>(containerReleaseOrderPrintBean.class));

			bean.setContainerDtl(containerDtl);

		} catch (Exception e) {
			LOGGER.error("Error in printCRO", e);
		}
		return bean;
	}*/

	@Override
	public printcontainerReleaseOrderBean printCRO(String blNo) {
		printcontainerReleaseOrderBean bean = new printcontainerReleaseOrderBean();
		List<printcontainerReleaseOrderBean> containerDtl = new ArrayList<printcontainerReleaseOrderBean>();

		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			bean = jdbcTemplate.queryForObject(containerReleaseOrderQueryUtil.GET_print_CRO,
					new Object[] {  blNo },
					new BeanPropertyRowMapper<printcontainerReleaseOrderBean>(printcontainerReleaseOrderBean.class));

			containerDtl = jdbcTemplate.query(containerReleaseOrderQueryUtil.GET_print_CRO_dtl, new Object[] { blNo },
					new BeanPropertyRowMapper<printcontainerReleaseOrderBean>(printcontainerReleaseOrderBean.class));

			bean.setContainerList(containerDtl);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in printCRO", e);
		}
		return bean;
	}
	@Override
	public containerReleaseOrderBean getExport(String containerreleaseCode) {
		// containerReleaseOrderResultBean bean = new containerReleaseOrderResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		containerReleaseOrderBean bean1 = new containerReleaseOrderBean();
		List<containerReleaseOrderBean> lQuotationBean = new ArrayList<containerReleaseOrderBean>();
		List<containerReleaseOrderBean> innerDetail = new ArrayList<containerReleaseOrderBean>();

		try {

			bean1 = jdbcTemplate.queryForObject(containerReleaseOrderQueryUtil.edit_hdr,
					new Object[] { containerreleaseCode },
					new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));

			lQuotationBean = jdbcTemplate.query(containerReleaseOrderQueryUtil.Edit_dtl,
					new Object[] { containerreleaseCode },
					new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));

			innerDetail = jdbcTemplate.query(containerReleaseOrderQueryUtil.Edit_Seal,
					new Object[] { containerreleaseCode },
					new BeanPropertyRowMapper<containerReleaseOrderBean>(containerReleaseOrderBean.class));

			// bean.setSeaQuotationBean(bean1);
			bean1.setlQuotationBean(lQuotationBean);
			bean1.setSealdtl(innerDetail);
			bean1.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error in edit", e);
			bean1.setSuccess(false);
			bean1.setMessage("Error :" + e.getMessage());

		}
		return bean1;
	}

	@Override
	public List<containerReleaseOrderBean> getemptyList(containerReleaseOrderBean containerReleaseOrderBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SelectivityBean> getContainerTypeByBooking(String bookingNo,boolean isEdit,String conHdrCode) {
		List<SelectivityBean> bean = new ArrayList<SelectivityBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			if(!isEdit) {
			bean = jdbcTemplate.query(containerReleaseOrderQueryUtil.GET_CONTAINER_TYPE_BY_BOOKING,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),bookingNo,bookingNo);
			}
			else {
				bean = jdbcTemplate.query(containerReleaseOrderQueryUtil.GET_CONTAINER_TYPE_BY_BOOKING_Edit,
						new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),bookingNo,bookingNo,conHdrCode);
			}
		}
		catch(Exception e) {
			LOGGER.error("Error in getting containerType in CRO", e);
		}
		return bean;
	}

}
