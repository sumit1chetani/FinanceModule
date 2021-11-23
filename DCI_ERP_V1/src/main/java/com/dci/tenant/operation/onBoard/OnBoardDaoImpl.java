package com.dci.tenant.operation.onBoard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CommonUtilityQueryUtil;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")
public class OnBoardDaoImpl implements OnBoardDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	UserLogDAO userlogDao;
	public List<SelectivityBean> getVesselList() {
		List<SelectivityBean> vesseList = new ArrayList<SelectivityBean>();
		try {
			vesseList = jdbcTemplate.query(OnBoardQueryUtil.GET_Vessel_list,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vesseList;
	}

	public List<SelectivityBean> getSlotList() {
		List<SelectivityBean> vesseList = new ArrayList<SelectivityBean>();
		try {
			vesseList = jdbcTemplate.query(OnBoardQueryUtil.Get_slot_list,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vesseList;
	}

	public List<SelectivityBean> getVoyageList(String vesselCode) {
		List<SelectivityBean> slotList = new ArrayList<SelectivityBean>();
		
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String whereCond = "";

		try {
			if(userDetails.getIsVendor() != null) {
				if(userDetails.getIsVendor().equalsIgnoreCase("Y")){
					slotList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_VOYAGE_BY_AGENT_VSL(userDetails.getUserPortStr()),
							new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),vesselCode);
				}
				else {
					slotList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_VOYAGE_LIST_BY_VSL,
							new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),vesselCode);
				}
			}else {
				slotList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_VOYAGE_LIST_BY_VSL,
						new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),vesselCode);
			}
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
		return slotList;
	}

	public List<SelectivityBean> getPortList(String voyage) {
		List<SelectivityBean> portList = new ArrayList<SelectivityBean>();

		try {
			 String port = jdbcTemplate.queryForObject(OnBoardQueryUtil.Get_port,new Object[]{voyage},
						(String.class));
			 String[] str=port.split(",");
			 String portIn="";
			 String in="";
               for(int i=0;i<str.length;i++){	
            	   if(!portIn.equalsIgnoreCase(null) && !portIn.equalsIgnoreCase("")){
            		   in=",";
            	   }
            	   
               portIn=portIn+in+str[i];
			 }
			portList = jdbcTemplate.query("select prt_icd_id as id,concat(prt_icd_cd,'-',prt_icd_nam) as text from port_icd where prt_icd_id in ("+portIn+") order by prt_icd_nam  ",
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return portList;
	}
	

	public OnBoardResultBean getContainerData(OnBoardBean onBoardBean) {
		OnBoardResultBean onBoardResultBean = new OnBoardResultBean();
		List<OnBoardBean> unallocateList = new ArrayList<OnBoardBean>();
		List<OnBoardBean> conList = new ArrayList<OnBoardBean>();

		Boolean value =false;
		try {
			List<OnBoardBean> onBoardBeanList = new ArrayList<OnBoardBean>();

			/*String port = onBoardBean.getPort();
			String portName ="";
			String portSeq ="";
			String array1[]= port.split("-");

			portName= array1[0];
			portSeq = array1[1];*/
			 value =	jdbcTemplate.queryForObject(OnBoardQueryUtil.check_Onboard_status,Boolean.class,onBoardBean.getVoyage(),onBoardBean.getPort());

			 if(value == true) {
				 
				 /*List<Map<String, Object>> rows = jdbcTemplate.queryForList(OnBoardQueryUtil.Check_Unallocated_Containers, new Object[] { onBoardBean.getVoyage(), portName });
					for (Map row : rows) {
						OnBoardBean bean = new OnBoardBean();

						bean.setBookingNo((String)row.get("bookingNo"));
						unallocateList.add(bean);

					}
					onBoardResultBean.setUnAllocatedList(unallocateList);

					if(onBoardResultBean.getUnAllocatedList().size() == 0) {*/
						
				   /* String ves =	jdbcTemplate.queryForObject(OnBoardQueryUtil.vessel,new Object[] {onBoardBean.getVessel()},String.class);
					String[] voy=onBoardBean.getVoyage().split("-");
					String vesVoy=ves+"-"+voy[1];*/
				 int port=Integer.parseInt(onBoardBean.getPort());
				 
				 if(onBoardBean.getMode().equals("4")) {
					 	 onBoardBeanList = jdbcTemplate.query(OnBoardQueryUtil.GetContainerData(onBoardBean),
							new BeanPropertyRowMapper<OnBoardBean>(OnBoardBean.class));
					 	int i=0;

						 for(OnBoardBean bean : onBoardBeanList) {
							 i=i+1;
		                     bean.setSlno(i);
						 }
							onBoardResultBean.setOnBoardBeanList(onBoardBeanList);
							onBoardResultBean.setSuccess(true);
					
					 System.out.println(onBoardBean.getVoyage()+port);
							conList = jdbcTemplate.query(OnBoardQueryUtil.GetContainerData_count_liner,new Object [] {onBoardBean.getVoyage(),port},
									new BeanPropertyRowMapper<OnBoardBean>(OnBoardBean.class));	 
				 }else {
				 onBoardBeanList = jdbcTemplate.query(OnBoardQueryUtil.GetContainerData,new Object [] {onBoardBean.getVoyage(),port},
							new BeanPropertyRowMapper<OnBoardBean>(OnBoardBean.class));
				 int i=0;

				 for(OnBoardBean bean : onBoardBeanList) {
					 i=i+1;
                     bean.setSlno(i);
				 }
					onBoardResultBean.setOnBoardBeanList(onBoardBeanList);
					onBoardResultBean.setSuccess(true);
			
			 
					conList = jdbcTemplate.query(OnBoardQueryUtil.GetContainerData_count,new Object [] {onBoardBean.getVoyage(),port},
							new BeanPropertyRowMapper<OnBoardBean>(OnBoardBean.class));
				 }
				 
					 onBoardResultBean.setContList(conList);				
					/*}else {
						
						String book ="";
						for(OnBoardBean rstbean : onBoardResultBean.getUnAllocatedList() ) 
						{
							book +="\n"+ rstbean.getBookingNo() ;
						}
						 
						onBoardResultBean.setMessage("Please Roll Over the Un-Allocated Booking(s) with Container(s) "+book+" to upcoming Vessel");
						onBoardResultBean.setSuccess(false);
			 
			 }*/
			 } else {
				 onBoardResultBean.setSuccess(false);
				 onBoardResultBean.setMessage("Onboard already Updated for Voyage and Port");
			 }
		} catch (Exception e) {
			e.printStackTrace();
			 onBoardResultBean.setSuccess(false);
			onBoardResultBean.setMessage("No Record Exist !!!");
		}
		return onBoardResultBean;
	}

	public OnBoardResultBean save(OnBoardBean onBoardBean) {
		OnBoardResultBean onBoardResultBean = new OnBoardResultBean();
		Boolean value =false;
		try {
			String onBoardNo = generateOnBoardNo("H");
			int pot=Integer.parseInt(onBoardBean.getPort());
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			 String ports =	jdbcTemplate.queryForObject(OnBoardQueryUtil.ports,new Object[]{pot},String.class);

			String port = onBoardBean.getPort();
			
			String portName ="";
			String portSeq ="";
            String array1[]= ports.split("-");
			int count=0;
			portName= array1[0];
			///portSeq = array1[1];
			String contNo="";	
			for (OnBoardBean objOnBoardBean : onBoardBean.getContainerDtl()) {/*
				
				if(objOnBoardBean.getStatusCode().equalsIgnoreCase("LDF") || objOnBoardBean.getStatusCode().equalsIgnoreCase("LTF")) {
					
					 value =	jdbcTemplate.queryForObject(OnBoardQueryUtil.Check_GATE_IN_LADEN,Boolean.class,objOnBoardBean.getContainerId(),objOnBoardBean.getBookingNo());

				}else if(objOnBoardBean.getStatusCode().equalsIgnoreCase("LDE")) {
					
					 value =	jdbcTemplate.queryForObject(OnBoardQueryUtil.Check_GATE_IN_EMPTY,Boolean.class,objOnBoardBean.getContainerId(),objOnBoardBean.getBookingNo());

				}
			
		
			 if(value) {
			count++;
		}
			 else {
				 
				  contNo=contNo+""+objOnBoardBean.getContainerNo()+",";
			 }
			*/}
			
			if  (onBoardBean.getContainerDtl().size()>0) {
				
			
			jdbcTemplate.update(OnBoardQueryUtil.INSERT, onBoardNo, onBoardBean.getVessel(), onBoardBean.getVoyage(),
					portName, onBoardBean.getPortSeq(), onBoardBean.getOnBoardDate(),
					userDetails.getUserId(),onBoardBean.getMode(),onBoardBean.getCarrier());
			int i=1;
			for (OnBoardBean objOnBoardBean : onBoardBean.getContainerDtl()) {
				
				String onBoardDtlNo = generateOnBoardNo("D");
				jdbcTemplate.update(OnBoardQueryUtil.INSERT_Dtl, onBoardDtlNo, onBoardNo, objOnBoardBean.getBlNo(),
						objOnBoardBean.getBookingNo(), objOnBoardBean.getContainerType(),
						objOnBoardBean.getContainerNo(), objOnBoardBean.getPod(), objOnBoardBean.getSealNo(),
						objOnBoardBean.getPackgeType(), objOnBoardBean.getNoOfPkgs(), objOnBoardBean.getSlotOperator(),
						objOnBoardBean.getContainerId(), objOnBoardBean.getLeg(),objOnBoardBean.getOnboardStatusDate(),objOnBoardBean.getShippingtype());

				/*Integer CON_ID = jdbcTemplate.queryForObject(OnBoardQueryUtil.GET_CON_ID,
						new Object[] { objOnBoardBean.getContainerNo() }, Integer.class);*/

				/*String status = "FOB";
				if ("T".equalsIgnoreCase(CommonExcelUtils.checkEmptyString(objOnBoardBean.getShippingtype()))) {
					status = "FTO";
				}else if(objOnBoardBean.getShippingtype().equalsIgnoreCase("ROB")) {
					status = "FROB";
				}else if(objOnBoardBean.getShippingtype().equalsIgnoreCase("ROBTR")) {
					status = "FRTO";
				}*/
				Integer count1 = jdbcTemplate.queryForObject(OnBoardQueryUtil.GET_CON_ID_count,
						new Object[] { objOnBoardBean.getContainerNo() }, Integer.class);
				if(count1==1) {
				Integer CON_ID = jdbcTemplate.queryForObject(OnBoardQueryUtil.GET_CON_ID,
						new Object[] { objOnBoardBean.getContainerNo() }, Integer.class);
				
				jdbcTemplate.update(OnBoardQueryUtil.SAVE_DETAIL_CONTAINER_STATUS,
						new Object[] { CON_ID, objOnBoardBean.getContainerType(), "SOB",
								objOnBoardBean.getOnboardStatusDate(), onBoardBean.getVessel(), onBoardBean.getVoyage(),
								portName, onBoardDtlNo, userDetails.getUserId(), 1, portName,
								objOnBoardBean.getPod(),objOnBoardBean.getBlNo(),objOnBoardBean.getBookingNo() });

				onBoardResultBean.setSuccess(true);
				}	else {
					onBoardResultBean.setSuccess(false);
					onBoardResultBean.setMessage("Row "+i+" Container already added through Onhire...Contact Admin!.");
					break;
				}
				i++;
			}
			UserLog userLog = userlogDao.userLogForInsert(onBoardBean, onBoardNo, userDetails.getUserId()); 

			 
		
			}else if (onBoardBean.getContainerDtl().size()==0){
				onBoardResultBean.setMessage("Please select atleast one row.");
				onBoardResultBean.setSuccess(false);
			}
				else {
			
				onBoardResultBean.setMessage("The Container(s) "+contNo+" are not yet Gate-IN");
				onBoardResultBean.setSuccess(false);
			}
        	
			List<OnBoardBean> blList = new ArrayList<OnBoardBean>();
			List<OnBoardBean> conList = new ArrayList<OnBoardBean>();

			//blList = jdbcTemplate.query(OnBoardQueryUtil.GET_CSLTS_BL_details, new BeanPropertyRowMapper<OnBoardBean>(OnBoardBean.class),onBoardBean.getVoyage(),portName);
			//conList = jdbcTemplate.query(OnBoardQueryUtil.GET_CSLTS_container_dtls, new BeanPropertyRowMapper<OnBoardBean>(OnBoardBean.class),onBoardBean.getVoyage(),portName);

			//onBoardResultBean.setOnBoardBeanList(blList);
			//onBoardResultBean.setContList(conList);
			onBoardResultBean.setOnBoardNo(onBoardNo);

			
			
		} catch (Exception e) {
			if (e.getCause() != null) {
				String exce = e.getCause().toString();
				onBoardResultBean.setMessage(exce.replace("org.postgresql.util.PSQLException: ERROR:", " "));
				onBoardResultBean.setSuccess(false);
				} 
			onBoardResultBean.setSuccess(false);
			e.printStackTrace();
		}
		return onBoardResultBean;
	}

	public synchronized String generateOnBoardNo(String param) {
		String onBoardNo = "";
		try {

			if ("H".equalsIgnoreCase(param)) {
				String year = gettingYear();
				String sIndexWithPer = "OB" + year + "%";
				String sIndex = "OB" + year;
				Map obReq = jdbcTemplate.queryForMap(OnBoardQueryUtil.GET_onboard_No, sIndex, sIndexWithPer);
				onBoardNo = (String) obReq.get("onboard_id");
			} else if ("D".equalsIgnoreCase(param)) {

				String year = gettingYear();
				String sIndexWithPer = "OB" + year + "%";
				String sIndex = "OB" + year;
				Map obDtlReq = jdbcTemplate.queryForMap(OnBoardQueryUtil.GET_onboard_Dtl_No, sIndex, sIndexWithPer);
				onBoardNo = (String) obDtlReq.get("onboard_details_id");
			}

		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
		return onBoardNo;
	}

	private String gettingYear() {
		String year = null;
		try {

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(OnBoardQueryUtil.gettingYear);

			for (Map<String, Object> row : rows) {
				year = row.get("year").toString();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return year;
	}

	public List<OnBoardBean> getList() {
		List<OnBoardBean> objList = new ArrayList<OnBoardBean>();
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (!"Y".equalsIgnoreCase(userDetails.getIsVendor())) {
				objList = jdbcTemplate.query(OnBoardQueryUtil.Get_List + " order by onboard_id desc ",
						new BeanPropertyRowMapper<OnBoardBean>(OnBoardBean.class));
			} else {
				objList = jdbcTemplate.query(
						OnBoardQueryUtil.Get_List + " where pol in (" + userDetails.getUserPortStr()
								+ ")  order by onboard_id desc  ",
						new BeanPropertyRowMapper<OnBoardBean>(OnBoardBean.class));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objList;
	}
	public List<OnBoardBean> getSearchList(OnBoardBean onBoardBean) {
		List<OnBoardBean> objList = new ArrayList<OnBoardBean>();
		try {
			String query="",query1="";
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(!onBoardBean.getMode().equalsIgnoreCase("") && !onBoardBean.getMode().equalsIgnoreCase(null)) {
				query=query+" and mode='"+onBoardBean.getMode()+"'";
				query1=query1+" and mode='"+onBoardBean.getMode()+"'";

			}
			if(onBoardBean.getCarrier()==null) {
				
			}else  if(!onBoardBean.getCarrier().equalsIgnoreCase("") && !onBoardBean.getCarrier().equalsIgnoreCase(null)) {
				query=query+" and carrier='"+onBoardBean.getCarrier()+"'";
				query1=query1+" and carrier='"+onBoardBean.getCarrier()+"'";

			}
            if(!query.equalsIgnoreCase("") && !query.equalsIgnoreCase(null)) {
            	query=" where " +query.substring(4);
            }
			if (!"Y".equalsIgnoreCase(userDetails.getIsVendor())) {
				System.out.println(OnBoardQueryUtil.Get_List + query+" order by onboard_id desc ");
				objList = jdbcTemplate.query(OnBoardQueryUtil.Get_List + query+" order by onboard_id desc ",
						new BeanPropertyRowMapper<OnBoardBean>(OnBoardBean.class));
			} else {
				System.out.println(OnBoardQueryUtil.Get_List  + " where pol in (" + userDetails.getUserPortStr()+ ") "+query1+" order by onboard_id desc  ");

				objList = jdbcTemplate.query(
						OnBoardQueryUtil.Get_List + " where pol in (" + userDetails.getUserPortStr()
								+ ") "+query1+" order by onboard_id desc  ",
						new BeanPropertyRowMapper<OnBoardBean>(OnBoardBean.class));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objList;
	}

	
	public OnBoardResultBean delete(String onBoardNo) {
		
		OnBoardResultBean onBoardResultBean = new OnBoardResultBean();
		Boolean value = false;
		Integer count =0;
		String contNo="";
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			List<OnBoardBean> dtlId = new ArrayList<OnBoardBean>();
			OnBoardBean editvalues = new OnBoardBean();
			
			editvalues =  getOnBoardDetails(onBoardNo);
			
		 
			for (OnBoardBean dd : editvalues.getDetailList()) {
				
			 value =	jdbcTemplate.queryForObject(OnBoardQueryUtil.check_vsl_arrival,Boolean.class,dd.getVoyage() ,dd.getPod());
		
			 if(value) {
			count++;
		     }
			 else {
				 
				 onBoardResultBean.setSuccess(false); 
			 }
			}
			
			if(editvalues.getDetailList().size() == count) {
				
			
			
			dtlId = jdbcTemplate.query(OnBoardQueryUtil.get_dtl_id  , new BeanPropertyRowMapper<OnBoardBean>(OnBoardBean.class),onBoardNo);
			
			for(OnBoardBean obj : dtlId) {
				
				int s = jdbcTemplate.update(OnBoardQueryUtil.delete_status, obj.getOnBoardId());

			}
			
			int j = jdbcTemplate.update(OnBoardQueryUtil.delete_dtl, onBoardNo);

			int i = jdbcTemplate.update(OnBoardQueryUtil.delete_hdr, onBoardNo);
			
			onBoardResultBean.setSuccess(true);
			}
			UserLog userLog = userlogDao.userLogForDelete(editvalues, onBoardNo, userDetails.getUserId());

			
		} catch (Exception e) {
			onBoardResultBean.setSuccess(false);
			e.printStackTrace();
		}
		return onBoardResultBean;
	}

	public OnBoardBean getOnBoardDetails(String onBoardNo) {
		List<OnBoardBean> objList = new ArrayList<OnBoardBean>();
		List<OnBoardBean> list = new ArrayList<OnBoardBean>();

		OnBoardBean bean = new OnBoardBean();
		try {
			objList = jdbcTemplate.query(OnBoardQueryUtil.getOnBoardDetails(onBoardNo),
					new BeanPropertyRowMapper<OnBoardBean>(OnBoardBean.class));
			
			list = jdbcTemplate.query(OnBoardQueryUtil.GET_CONTAINERCOUNT,
					new BeanPropertyRowMapper<OnBoardBean>(OnBoardBean.class),onBoardNo);
			
			
			bean.setDetailList(objList);
			bean.setContList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	
	public OnBoardBean getOnBoardDetailsForMail(String onBoardNo) {
		List<OnBoardBean> objList = new ArrayList<OnBoardBean>();
		

		OnBoardBean bean = new OnBoardBean();
		try {
			objList = jdbcTemplate.query(OnBoardQueryUtil.getOnBoardDetailsMail,
					new BeanPropertyRowMapper<OnBoardBean>(OnBoardBean.class),onBoardNo);
			
			bean.setDetailList(objList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	public List<SelectivityBean> getPort() {
		List<SelectivityBean> portList = new ArrayList<SelectivityBean>();
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			String query = "select portcode from port_master where isactive ='Y'";
			if ("Y".equalsIgnoreCase(userDetails.getIsVendor())) {
				query = query + " and portcode in (" + userDetails.getUserPortStr() + ") ";
			}
			query = query + "    order by portcode asc";

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, new Object[] {});

			for (Map row : rows) {
				SelectivityBean bean = new SelectivityBean();

				bean.setId(String.valueOf(row.get("portcode")));
				bean.setText(String.valueOf(row.get("portcode")));
				portList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return portList;
	}

	
	
	
	public List<SelectivityBean> getbookList(String vesselCode) {
		List<SelectivityBean> slotList = new ArrayList<SelectivityBean>();
		
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String whereCond = "";

		try {
					slotList = jdbcTemplate.query(OnBoardQueryUtil.get_gatein_no,
							new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),vesselCode);
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
		return slotList;
	}


	@Override
	public String generateExcelReport(String onBoardID, String path, String number) throws IOException {
		String fileName = "";
		try {
			XSSFWorkbook wb = new XSSFWorkbook();
			Sheet sheet1 = wb.createSheet("ONBOARD REPORT");
			sheet1.setZoom(4, 5);
			CellStyle style = wb.createCellStyle();
			org.apache.poi.ss.usermodel.Font font = wb.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Bell MT");
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			style.setAlignment(CellStyle.ALIGN_CENTER);

			Font font1 = wb.createFont();
			CellStyle style1 = wb.createCellStyle();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial Black");
			style1.setFont(font1);
			style1.setAlignment(CellStyle.ALIGN_CENTER);

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
			// heading row

			Row row0 = sheet1.createRow((short) 0);
			Row row1 = sheet1.createRow(1);
			Row row2 = sheet1.createRow(2);
			org.apache.poi.ss.usermodel.Cell cell;
			setHeading(wb, style);

			cell = row0.createCell((short) 0);
			cell.setCellValue("ONBOARD REPORT");
			sheet1.addMergedRegion(new CellRangeAddress(0, (short) 0, 0, (short) 30));

			cell = row1.createCell((short) 0);
			cell.setCellStyle(style);
			cell.setCellValue("SL NO");
 
			cell = row1.createCell((short) 1);
			cell.setCellStyle(style);
			cell.setCellValue("JOB NO");
			
			cell = row1.createCell((short) 2);
			cell.setCellStyle(style);
			cell.setCellValue("CONTAINER NO");

			cell = row1.createCell((short) 3);
			cell.setCellStyle(style);
			cell.setCellValue("GATE IN DATE");

			cell = row1.createCell((short) 4);
			cell.setCellStyle(style);
			cell.setCellValue("SIZE");

			cell = row1.createCell((short) 5);
			cell.setCellStyle(style);
			cell.setCellValue("ISO CODE");

			cell = row1.createCell((short) 6);
			cell.setCellStyle(style);
			cell.setCellValue("LINE CODE");

			cell = row1.createCell((short) 7);
			cell.setCellStyle(style);
			cell.setCellValue("POL");

			cell = row1.createCell((short) 8);
			cell.setCellStyle(style);
			cell.setCellValue("POD");

			cell = row1.createCell((short) 9);
			cell.setCellStyle(style);
			cell.setCellValue("WEIGHT");

			cell = row1.createCell((short) 10);
			cell.setCellStyle(style);
			cell.setCellValue("SEAL NO");

			cell = row1.createCell((short) 11);
			cell.setCellStyle(style);
			cell.setCellValue("EXPORT VSL");

			cell = row1.createCell((short) 12);
			cell.setCellStyle(style);
			cell.setCellValue("FORWARDER");

			cell = row1.createCell((short) 13);
			cell.setCellStyle(style);
			cell.setCellValue("SHIPPER NAME");

			cell = row1.createCell((short) 14);
			cell.setCellStyle(style);
			cell.setCellValue("SHIPPER ADDRESS");

			cell = row1.createCell((short) 15);
			cell.setCellStyle(style);
			cell.setCellValue("CONSIGNEE NAME");

			cell = row1.createCell((short) 16);
			cell.setCellStyle(style);
			cell.setCellValue("CONSIGNEE ADDRESS");

			cell = row1.createCell((short) 17);
			cell.setCellStyle(style);
			cell.setCellValue("PRODUCT");

			cell = row1.createCell((short) 18);
			cell.setCellStyle(style);
			cell.setCellValue("COMMODITY");

			cell = row1.createCell((short) 19);
			cell.setCellStyle(style);
			cell.setCellValue("ORIGIN LOCATION");

			cell = row1.createCell((short) 20);
			cell.setCellStyle(style);
			cell.setCellValue("DESTINATION");
			
			cell = row1.createCell((short) 21);
			cell.setCellStyle(style);
			cell.setCellValue("INVOICE NO");
			
			cell = row1.createCell((short) 22);
			cell.setCellStyle(style);
			cell.setCellValue("INVOICE DATE");

			cell = row1.createCell((short) 23);
			cell.setCellStyle(style);
			cell.setCellValue("INVOICE VALUE");

			cell = row1.createCell((short) 24);
			cell.setCellStyle(style);
			cell.setCellValue("TRANSPORTER");
			
			cell = row1.createCell((short) 25);
			cell.setCellStyle(style);
			cell.setCellValue("VEHICLE NO");
			
			cell = row1.createCell((short) 26);
			cell.setCellStyle(style);
			cell.setCellValue("MODE ENTRY");

			cell = row1.createCell((short) 27);
			cell.setCellStyle(style);
			cell.setCellValue("LR NO");

			cell = row1.createCell((short) 28);
			cell.setCellStyle(style);
			cell.setCellValue("PKGS");
			
			cell = row1.createCell((short) 29);
			cell.setCellStyle(style);
			cell.setCellValue("PKG TYPE");

			cell = row1.createCell((short) 30);
			cell.setCellStyle(style);
			cell.setCellValue("BCG NO AND DATE");

			cell = row1.createCell((short) 31);
			cell.setCellStyle(style);
			cell.setCellValue("PKG IN WORDS");
	
			List<Map<String, Object>> mailDetails = jdbcTemplate.queryForList(OnBoardQueryUtil.get_onBoard_excel,
					new Object[] { onBoardID });

			for (Map<String, Object> values : mailDetails) {
				rowNumber += 1;
				Row row = sheet1.createRow((short) rowNumber);

				cell = row.createCell((short) 0);
				cell.setCellValue(rowNumber-1);

				cell = row.createCell((short) 1);
				cell.setCellValue(values.get("jobNo").toString());
				
				cell = row.createCell((short) 2);
				cell.setCellValue(values.get("container_no").toString());
				
				
				cell = row.createCell((short) 3);
				cell.setCellValue(values.get("gateInDate").toString());

				cell = row.createCell((short) 4);
				cell.setCellValue(values.get("container_type").toString());

				cell = row.createCell((short) 5);
				cell.setCellValue(values.get("iso_code").toString());

				cell = row.createCell((short) 6);
				cell.setCellValue(values.get("lineCode").toString());

				cell = row.createCell((short) 7);
				cell.setCellValue(values.get("pol").toString());

				cell = row.createCell((short) 8);
				cell.setCellValue(values.get("pod").toString());

				cell = row.createCell((short) 9);
				cell.setCellValue(values.get("weight").toString());

				cell = row.createCell((short) 10);
				cell.setCellValue(values.get("sealNo").toString());

				cell = row.createCell((short) 11);
				cell.setCellValue(values.get("exVoyage").toString());

				cell = row.createCell((short) 12);
				cell.setCellValue(values.get("forwarder").toString());

				cell = row.createCell((short) 13);
				cell.setCellValue(values.get("shipper").toString());

				cell = row.createCell((short) 14);
				cell.setCellValue(values.get("shipperAddress").toString());

				cell = row.createCell((short) 15);
				cell.setCellValue(values.get("consignee").toString());

				cell = row.createCell((short) 16);
				cell.setCellValue(values.get("consigneeAddress").toString());

				cell = row.createCell((short) 17);
				cell.setCellValue(values.get("product").toString());

				cell = row.createCell((short) 18);
				cell.setCellValue(values.get("commodity").toString());
				
				cell = row.createCell((short) 19);
				cell.setCellValue(values.get("origin").toString());

				cell = row.createCell((short) 209);
				cell.setCellValue(values.get("destination").toString());

				cell = row.createCell((short) 21);
				cell.setCellValue(values.get("invoiceNo").toString());

				cell = row.createCell((short) 22);
				cell.setCellValue(values.get("invoiceDate").toString());

				cell = row.createCell((short) 23);
				cell.setCellValue(Double.parseDouble(values.get("invoiceAmount").toString()));

				cell = row.createCell((short) 24);
				cell.setCellValue(values.get("transporter").toString());

				cell = row.createCell((short) 25);
				cell.setCellValue(values.get("vehicleNo").toString());

				cell = row.createCell((short) 26);
				cell.setCellValue(values.get("modeEntry").toString());
				
				cell = row.createCell((short) 27);
				cell.setCellValue(values.get("LRNo").toString());
				
				cell = row.createCell((short) 28);
				cell.setCellValue(values.get("package").toString());
				
				cell = row.createCell((short) 29);
				cell.setCellValue(values.get("uomName").toString());
				
				cell = row.createCell((short) 30);
				cell.setCellValue(values.get("bcgNo").toString());
				
				cell = row.createCell((short) 31);
				cell.setCellValue(values.get("packagesInWords").toString());

			}

			writeExcel(wb, path, number);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	private void setHeading(Workbook wb, CellStyle cellStyle) {
		org.apache.poi.ss.usermodel.Font font = wb.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontName("Calibri");
		font.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short) 9);
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setFont(font);
		cellStyle.setWrapText(false);

	}
	
	private static void writeExcel(XSSFWorkbook myWorkBook, String filePath, String number) {
		//String l_str_file_out = "C:\\GeneratedExcelfiles\\MISreports" +File.separator +"BunkerReport" + number + ".xlsx";
		String l_str_file_out = filePath  +File.separator + "/OnBoardReport_" + number + ".xlsx";
		FileOutputStream fileOut = null;
		System.out.println("filepath " + l_str_file_out);
		try {
			fileOut = new FileOutputStream(l_str_file_out);
			myWorkBook.write(fileOut);
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
