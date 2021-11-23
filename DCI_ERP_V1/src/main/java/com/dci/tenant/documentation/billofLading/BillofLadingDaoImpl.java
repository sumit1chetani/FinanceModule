package com.dci.tenant.documentation.billofLading;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")

public class BillofLadingDaoImpl implements BillofLadingDao {
	private final static Logger LOGGER = Logger.getLogger(BillofLadingDaoImpl.class);

	@Autowired
	DataSource dataSource;

	@Override
	public BillofLadingBean insert(BillofLadingBean billofLading) throws Exception {
		Boolean isSuccess = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			int release;
			if(billofLading.isReleased()){
				release=1;
			}
			else{
				release=0;
			}
			int m=0;
			int n=0;
			int i = jdbcTemplate.update(BillofLadingQueryUtil.INSERT, billofLading.getBlNo(),
					billofLading.getBookingNo(), billofLading.getIssuePlace(), billofLading.getIssueDate(),
					billofLading.getOnBoard(), billofLading.getReceiptAt(), billofLading.getPol(),
					billofLading.getPod(), billofLading.getPot(), billofLading.getFpod(), billofLading.getTerms(),
					billofLading.getNoBls(), billofLading.getRef(), billofLading.getVslVoyage(), billofLading.getmVoyage(),
					billofLading.getLoadType(), billofLading.getService(), release,
					billofLading.getClient(), billofLading.getJobNo(), billofLading.getAgent(),
					billofLading.getRemarks(), billofLading.getShipment(), billofLading.getStatus());
			
			int j = jdbcTemplate.update(BillofLadingQueryUtil.INSERT_BL_NAMES,billofLading.getBlNo(), billofLading.getMessers(),billofLading.getShipper(),
					billofLading.getCnee(),billofLading.getNotify1(),billofLading.getNotify2(),
					billofLading.getForwarder());
			
			int k = jdbcTemplate.update(BillofLadingQueryUtil.INSERT_BL_GOODS,billofLading.getBlNo(), billofLading.getGoods(),billofLading.getMarks(),
					billofLading.getMaincom(),billofLading.getT_wgt(),billofLading.getG_wgt(),
					billofLading.getPkgs(),billofLading.getCbm(),billofLading.getN_wgt());
			for(BillOfLadingContainersData  cntrBean :billofLading.getBlcntrDtlList()){
				int count=0;
 
				
				int contDtlId = jdbcTemplate.queryForObject(BillofLadingQueryUtil.INSERT_CONT_DTLS, Integer.class,billofLading.getBlNo(), cntrBean.getCntrNo(),cntrBean.getSize(),
						cntrBean.getType(),cntrBean.getSealNo(),cntrBean.getTw(),cntrBean.getGw(),cntrBean.getCb(),cntrBean.getNet(),cntrBean.getFle(),cntrBean.getSo(),
						cntrBean.getPackageType(),cntrBean.getNoOfPckgs(),cntrBean.getGoods(),cntrBean.getIso(),cntrBean.getPolTer(),cntrBean.getPodTer(),cntrBean.getMarks());
				
				for(BillOfLadingChargesList  chargeBean :cntrBean.getChargeList()){
					m=0;
					  m = jdbcTemplate.update(BillofLadingQueryUtil.INSERT_CONT_CHARGE_DTLS,contDtlId,cntrBean.getCntrNo(),chargeBean.getChargeCode(),chargeBean.getCurrency(),
							chargeBean.getUnitRate(),chargeBean.getMeaRate(),chargeBean.getWgRate(),chargeBean.getFromPlace(),
							chargeBean.getToPlace(),chargeBean.getMinRate(),chargeBean.getTerms(),chargeBean.getRealAmount());
					
				}
				
				for(BillOfLadingPackageChargeList  packageBean :billofLading.getBlpckDtlList().get(count).getPackageList()){
					n=0;
					  n = jdbcTemplate.update(BillofLadingQueryUtil.INSERT_CONT_PACKAGE_DTL,contDtlId,packageBean.getHsCode(),packageBean.getPackageType(),packageBean.getNoofPcks(),
							packageBean.getGw_(),packageBean.getGoods(),cntrBean.getCntrNo());
					
				}
				count++;
			}
		
			for(BillOfLadingChargeBean  chBean :billofLading.getBlCharges()){
				
				  n = jdbcTemplate.update(BillofLadingQueryUtil.INSERT_CHARGE_DT_BL,billofLading.getBlNo(),chBean.getSeq(),chBean.getChargeCode(),chBean.getCurrency(),chBean.getQty(),chBean.getRate(),
						  chBean.getAmount(),chBean.getPayAt(),chBean.getTerms(),chBean.getFromPlace(),chBean.getToPlace(),chBean.getInvAmount(),chBean.getRealAmount());
				  
			}
			
			 
				isSuccess = true;
				billofLading.setIsSuccess(isSuccess);
		} catch (DataAccessException e) {
			e.printStackTrace();
			isSuccess = false;
			billofLading.setIsSuccess(isSuccess);
			billofLading.setMessage("Error in save :" + e.getMessage());
		}
		return billofLading;
	}

	@Override
	public List<SelectivityBean> getDropDown() {
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(BillofLadingQueryUtil.DROPDOWN,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<BillofLadingBean> getList() throws Exception {
		List<BillofLadingBean> blList=new ArrayList<BillofLadingBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			blList = jdbcTemplate.query(BillofLadingQueryUtil.LIST,
					new BeanPropertyRowMapper<BillofLadingBean>(BillofLadingBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_LIST", e);
			e.printStackTrace();
		}
		return blList;
	}
	
	@Override
	public List<BillofLadingBean> getBlList() throws Exception {
		List<BillofLadingBean> blList=new ArrayList<BillofLadingBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			blList = jdbcTemplate.query(BillofLadingQueryUtil.LIST,
					new BeanPropertyRowMapper<BillofLadingBean>(BillofLadingBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_LIST", e);
			e.printStackTrace();
		}
		return blList;
	}

	@Override
	public BillofLadingBean print(String blNo) {
		
		BillofLadingBean billofLadingbean =new BillofLadingBean();
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {

			billofLadingbean = jdbcTemplate.queryForObject(BillofLadingQueryUtil.GET_Bl, 
					new Object[] { blNo },
					new BeanPropertyRowMapper<BillofLadingBean>(BillofLadingBean.class));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return billofLadingbean;
	}

	@Override
	public BillofLadingBean getBlEdit(String blNo) {
		BillofLadingBean billofLadingbean =new BillofLadingBean();
		 List<BillOfLadingContainersData> blcntrDtlList = new ArrayList<BillOfLadingContainersData>();
		 List<BillOfLadingPackage> blpackDtlList = new ArrayList<BillOfLadingPackage>();
		 List<BillOfLadingChargeBean> packList = new ArrayList<BillOfLadingChargeBean>(); 
		try {
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			billofLadingbean = jdbcTemplate.queryForObject(BillofLadingQueryUtil.GET_BL,
					new Object[] { blNo },
					new BeanPropertyRowMapper<BillofLadingBean>(BillofLadingBean.class));
			
			blcntrDtlList = jdbcTemplate.query(BillofLadingQueryUtil.GET_BL_CONT_DTL,
					new BeanPropertyRowMapper<BillOfLadingContainersData>(BillOfLadingContainersData.class),blNo);
			blpackDtlList = jdbcTemplate.query(BillofLadingQueryUtil.GET_BL_CONT_DTL,
					new BeanPropertyRowMapper<BillOfLadingPackage>(BillOfLadingPackage.class),blNo);
			
			billofLadingbean.setBlcntrDtlList(blcntrDtlList);
			billofLadingbean.setBlpckDtlList(blpackDtlList);
			for(BillOfLadingContainersData container : billofLadingbean.getBlcntrDtlList()){
				List<BillOfLadingChargesList> blChargeList = new ArrayList<BillOfLadingChargesList>();
				blChargeList = jdbcTemplate.query(BillofLadingQueryUtil.GET_CON_CHARGE_DTL,
						new BeanPropertyRowMapper<BillOfLadingChargesList>(BillOfLadingChargesList.class),container.getInwardCntrId());
				container.setChargeList(blChargeList);
				
			}
			for(BillOfLadingPackage packageBean : billofLadingbean.getBlpckDtlList()){
			List<BillOfLadingPackageChargeList> blPackChargeList = new ArrayList<BillOfLadingPackageChargeList>();
			blPackChargeList = jdbcTemplate.query(BillofLadingQueryUtil.GET_CON_PACKAGE_DTL,
					new BeanPropertyRowMapper<BillOfLadingPackageChargeList>(BillOfLadingPackageChargeList.class),packageBean.getInwardCntrId());
			packageBean.setPackageList(blPackChargeList);
			}
 					packList = jdbcTemplate.query(BillofLadingQueryUtil.GET_BL_CHARGE,
							new BeanPropertyRowMapper<BillOfLadingChargeBean>(BillOfLadingChargeBean.class),blNo);
	 				
			 
			
			
			billofLadingbean.setBlCharges(packList);
			
		}catch (DataAccessException e) {
			LOGGER.error("Error in edit", e);
			
		}
		return billofLadingbean;
	}

	@Override
	public BillofLadingBean delete(String blNo) {
		BillofLadingBean billofLading =new BillofLadingBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		Boolean isSuccess = false;
		try {
			int i= jdbcTemplate.update(BillofLadingQueryUtil.delete, blNo);
			isSuccess = true;
			billofLading.setIsSuccess(isSuccess);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			isSuccess = false;
			billofLading.setIsSuccess(isSuccess);
			billofLading.setMessage("Error in Delete :" + e.getMessage());
			LOGGER.error("Error in delete", e);
		}

		return billofLading;

	}

	@Override
	public BillofLadingBean update(BillofLadingBean billofLading)
			throws Exception {
		Boolean isSuccess = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int contDtlId = 0;
		int j=0;
		int k=0;
		int l=0;
		int m=0;
		int n=0;
		try {
			int release;
			if(billofLading.isReleased()){
				release=1;
			}
			else{
				release=0;
			}
			int i = jdbcTemplate.update(BillofLadingQueryUtil.Update_Hdr,
					billofLading.getBookingNo(), billofLading.getIssuePlace(), billofLading.getIssueDate(),
					billofLading.getOnBoard(), billofLading.getReceiptAt(), billofLading.getPol(),
					billofLading.getPod(), billofLading.getPot(), billofLading.getFpod(), billofLading.getTerms(),
					billofLading.getNoBls(), billofLading.getRef(), billofLading.getVslVoyage(), billofLading.getmVoyage(),
					billofLading.getLoadType(), billofLading.getService(), release,
					billofLading.getClient(), billofLading.getJobNo(), billofLading.getAgent(),
					billofLading.getRemarks(), billofLading.getShipment(), billofLading.getStatus(),billofLading.getBlNo());
			
			int countnames = jdbcTemplate.queryForObject(BillofLadingQueryUtil.Get_count_names,int.class,billofLading.getBlNo());
			 if(countnames == 0){
				 j=0;
			  j = jdbcTemplate.update(BillofLadingQueryUtil.INSERT_BL_NAMES,billofLading.getBlNo(), billofLading.getMessers(),billofLading.getShipper(),
					billofLading.getCnee(),billofLading.getNotify1(),billofLading.getNotify2(),
					billofLading.getForwarder());
			 }
			 else{
				 j=0;
				   j = jdbcTemplate.update(BillofLadingQueryUtil.UPDATE_BL_NAMES, billofLading.getMessers(),billofLading.getShipper(),
							billofLading.getCnee(),billofLading.getNotify1(),billofLading.getNotify2(),
							billofLading.getForwarder(),billofLading.getBlNo()); 
			 }
				int countgoods = jdbcTemplate.queryForObject(BillofLadingQueryUtil.Get_count_names,int.class,billofLading.getBlNo());
				 if(countgoods == 0){
					 k=0;
			  k = jdbcTemplate.update(BillofLadingQueryUtil.INSERT_BL_GOODS,billofLading.getBlNo(), billofLading.getGoods(),billofLading.getMarks(),
					billofLading.getMaincom(),billofLading.getT_wgt(),billofLading.getG_wgt(),
					billofLading.getPkgs(),billofLading.getCbm(),billofLading.getN_wgt());
				 }
				 else{
					 k=0;
					   k = jdbcTemplate.update(BillofLadingQueryUtil.UPDATE_BL_GOODS,  billofLading.getGoods(),billofLading.getMarks(),
								billofLading.getMaincom(),billofLading.getT_wgt(),billofLading.getG_wgt(),
								billofLading.getPkgs(),billofLading.getCbm(),billofLading.getN_wgt(),billofLading.getBlNo());
				 }
				 
			for(BillOfLadingContainersData  cntrBean :billofLading.getBlcntrDtlList()){
				int count=0;
				if(cntrBean.getInwardCntrId() != null && cntrBean.getInwardCntrId() != 0){
					l=0;
				  l=jdbcTemplate.update(BillofLadingQueryUtil.UPDATE_CONT_DTLS,  cntrBean.getCntrNo(),cntrBean.getSize(),
						cntrBean.getType(),cntrBean.getSealNo(),cntrBean.getTw(),cntrBean.getGw(),cntrBean.getCb(),cntrBean.getNet(),cntrBean.getFle(),cntrBean.getSo(),
						cntrBean.getPackageType(),cntrBean.getNoOfPckgs(),cntrBean.getGoods(),cntrBean.getIso(),cntrBean.getPolTer(),cntrBean.getPodTer(),cntrBean.getMarks(),cntrBean.getInwardCntrId());
				}
				else{
					l=0;
					  contDtlId = jdbcTemplate.queryForObject(BillofLadingQueryUtil.INSERT_CONT_DTLS, Integer.class,billofLading.getBlNo(), cntrBean.getCntrNo(),cntrBean.getSize(),
							cntrBean.getType(),cntrBean.getSealNo(),cntrBean.getTw(),cntrBean.getGw(),cntrBean.getCb(),cntrBean.getNet(),cntrBean.getFle(),cntrBean.getSo(),
							cntrBean.getPackageType(),cntrBean.getNoOfPckgs(),cntrBean.getGoods(),cntrBean.getIso(),cntrBean.getPolTer(),cntrBean.getPodTer(),cntrBean.getMarks());
					  if(contDtlId > 0){
						  l++; 
					  }
				}
				for(BillOfLadingChargesList  chargeBean :cntrBean.getChargeList()){
					if(chargeBean.getInwardContChargesId() != null && chargeBean.getInwardContChargesId() != 0){
						m=0;
						 m = jdbcTemplate.update(BillofLadingQueryUtil.UPDATE_CONT_CHARGE_DTLS,cntrBean.getCntrNo(),chargeBean.getChargeCode(),chargeBean.getCurrency(),
							chargeBean.getUnitRate(),chargeBean.getMeaRate(),chargeBean.getWgRate(),chargeBean.getFromPlace(),
							chargeBean.getToPlace(),chargeBean.getMinRate(),chargeBean.getTerms(),chargeBean.getRealAmount(),chargeBean.getInwardContChargesId());
					}else{
						if(contDtlId == 0){
							contDtlId=cntrBean.getInwardCntrId();
						}
						m=0;
						  m = jdbcTemplate.update(BillofLadingQueryUtil.INSERT_CONT_CHARGE_DTLS,contDtlId,cntrBean.getCntrNo(),chargeBean.getChargeCode(),chargeBean.getCurrency(),
								chargeBean.getUnitRate(),chargeBean.getMeaRate(),chargeBean.getWgRate(),chargeBean.getFromPlace(),
								chargeBean.getToPlace(),chargeBean.getMinRate(),chargeBean.getTerms(),chargeBean.getRealAmount());
						
					
					}
					
				}
				
				for(BillOfLadingPackageChargeList  packageBean :billofLading.getBlpckDtlList().get(count).getPackageList()){
					if(packageBean.getInwardPackageChargeId() != null && packageBean.getInwardPackageChargeId() != 0){
					  n = jdbcTemplate.update(BillofLadingQueryUtil.UPDATE_CONT_PACKAGE_DTL, packageBean.getHsCode(),packageBean.getPackageType(),packageBean.getNoofPcks(),
							packageBean.getGw_(),packageBean.getGoods(),cntrBean.getCntrNo(),packageBean.getInwardPackageChargeId());
					}
					else{
						  n = jdbcTemplate.update(BillofLadingQueryUtil.INSERT_CONT_PACKAGE_DTL,contDtlId,packageBean.getHsCode(),packageBean.getPackageType(),packageBean.getNoofPcks(),
								packageBean.getGw_(),packageBean.getGoods(),cntrBean.getCntrNo());
					}
				}
				count++;
			}
			
			int countcharge = jdbcTemplate.queryForObject(BillofLadingQueryUtil.Get_count_charge,int.class,billofLading.getBlNo());

			if(countcharge==0){
				for(BillOfLadingChargeBean  chBean :billofLading.getBlCharges()){
					
					  n = jdbcTemplate.update(BillofLadingQueryUtil.INSERT_CHARGE_DT_BL,billofLading.getBlNo(),chBean.getSeq(),chBean.getChargeCode(),chBean.getCurrency(),chBean.getQty(),chBean.getRate(),
							  chBean.getAmount(),chBean.getPayAt(),chBean.getTerms(),chBean.getFromPlace(),chBean.getToPlace(),chBean.getInvAmount(),chBean.getRealAmount());
					  
				}	
			}
			else{
				for(BillOfLadingChargeBean  chBean :billofLading.getBlCharges()){
					
					  n = jdbcTemplate.update(BillofLadingQueryUtil.UPDATE_CHARGE_DT_BL,billofLading.getBlNo(),chBean.getSeq(),chBean.getChargeCode(),chBean.getCurrency(),chBean.getQty(),chBean.getRate(),
							  chBean.getAmount(),chBean.getPayAt(),chBean.getTerms(),chBean.getFromPlace(),chBean.getToPlace(),chBean.getInvAmount(),chBean.getRealAmount(),chBean.getPackageChargeId());
					  
				}
			}
			
			
			if(billofLading.getRemoveCharge() != null){
				for(Integer chargeId : billofLading.getRemoveCharge()){
					  jdbcTemplate.update(BillofLadingQueryUtil.delete_charge, chargeId);
				}
			}
			
			if(billofLading.getRemoveCntrPckg() != null){
				for(Integer packageId : billofLading.getRemoveCntrPckg()){
					  jdbcTemplate.update(BillofLadingQueryUtil.delete_package_charge, packageId);
				}
			}
		
	if(billofLading.getRemoveCntrCharge()!= null){
		for(Integer chargeId : billofLading.getRemoveCntrCharge()){
			  jdbcTemplate.update(BillofLadingQueryUtil.delete_conatiner_charge, chargeId);
		}
			}
		
	if(billofLading.getRemoveCntr()!= null){
		for(Integer containerId : billofLading.getRemoveCntr()){
			  jdbcTemplate.update(BillofLadingQueryUtil.delete_conatiner, containerId);
		}	
			}
		
			
 				isSuccess = true;
				billofLading.setIsSuccess(isSuccess);
			 
		} catch (DataAccessException e) {
			e.printStackTrace();
			isSuccess = false;
			billofLading.setIsSuccess(isSuccess);
			billofLading.setMessage("Error in update :" + e.getMessage());
		}
		return billofLading;
	}

	@Override
	public List<SelectivityBean> getIssuePlace() {
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(BillofLadingQueryUtil.getIssuePlace,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<SelectivityBean> getAgentList() {
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(BillofLadingQueryUtil.getAgentList,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<SelectivityBean> getBookingList() {
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(BillofLadingQueryUtil.getBookingList,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<SelectivityBean> shipmentList() {
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(BillofLadingQueryUtil.shipmentList,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<SelectivityBean> getConatinerTypeList() {
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(BillofLadingQueryUtil.getContainerType,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<SelectivityBean> getPackageTypeList() {
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(BillofLadingQueryUtil.packageTypeList,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<SelectivityBean> getSurChargeList() {
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(BillofLadingQueryUtil.surChargeList,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public BillofLadingResultBean printBL(String blNo){
		BillofLadingResultBean bean = new BillofLadingResultBean();
		List<BillofLadingResultBean> bean1 = new ArrayList<BillofLadingResultBean>();
		BillofLadingResultBean bean2 = new BillofLadingResultBean();
		BillofLadingResultBean bean3 = new BillofLadingResultBean();
		String issueplace="";
		String branch="";
		String pol="";
		String pod="";
		String fpod="";
		String vessel="";
		List<BillofLadingResultBean> chargerId;
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			bean = jdbcTemplate.queryForObject(BillofLadingQueryUtil.GET_print_bl,
					new Object[] { blNo },
					new BeanPropertyRowMapper<BillofLadingResultBean>(BillofLadingResultBean.class));
			if(bean.getTerms().equals("Prepaid")) {
				bean.setPrepaid("XXXX");
			} else if(bean.getTerms().equals("Collect")) {
				bean.setCollect("XXXX");
			}
			vessel=jdbcTemplate.queryForObject(BillofLadingQueryUtil.GET_vessel,String.class,blNo);
			branch=jdbcTemplate.queryForObject(BillofLadingQueryUtil.GET_branchforprint,String.class,bean.getReceiptAt());
			issueplace=jdbcTemplate.queryForObject(BillofLadingQueryUtil.GET_issueplaceforprint,String.class,bean.getIssuePlace());
			pol=jdbcTemplate.queryForObject(BillofLadingQueryUtil.GET_portforprint,String.class,bean.getPol());
			pod=jdbcTemplate.queryForObject(BillofLadingQueryUtil.GET_portforprint,String.class,bean.getPod());
			fpod=jdbcTemplate.queryForObject(BillofLadingQueryUtil.GET_portforprint,String.class,bean.getFpod());
		String custName	 =jdbcTemplate.queryForObject(BillofLadingQueryUtil.GET_CUST_NAME,String.class,bean.getCustomerId());
			bean.setIssuePlace(issueplace);
			bean.setReceiptAt(branch);
			bean.setPol(pol);
			bean.setPod(pod);
			bean.setFpod(fpod);
			bean.setVessel(vessel);
			bean.setCustomerName(custName);

			bean1 = jdbcTemplate.query(BillofLadingQueryUtil.GET_charges,
					new BeanPropertyRowMapper<BillofLadingResultBean>(BillofLadingResultBean.class),blNo);
		
			//bean.setRate(bean1.get(0).getRate());
			
//			chargerId=jdbcTemplate.query(BillofLadingQueryUtil.GET_cntrchargesID,
//					new BeanPropertyRowMapper<BillofLadingResultBean>(BillofLadingResultBean.class),blNo);
			
//			bean2 = jdbcTemplate.queryForObject(BillofLadingQueryUtil.GET_cntrcharges,
//					new Object[] { chargerId },
//					new BeanPropertyRowMapper<BillofLadingResultBean>(BillofLadingResultBean.class));
			
			bean3 = jdbcTemplate.queryForObject(BillofLadingQueryUtil.GET_ALL_CHARGES,
					new Object[] { blNo },
					new BeanPropertyRowMapper<BillofLadingResultBean>(BillofLadingResultBean.class));
			bean.setFreight_charges(bean3.getFreight_charges());
			bean.setCurrency(bean3.getCurrency());
			bean.setRate(bean3.getRate());
			bean.setUnit(bean3.getUnit());
		//	bean.setTerms(bean2.terms);
		}catch(Exception e){
			e.printStackTrace();
		}
		return bean;
	}
	
	@Override
	public List<BillofLadingBean> printDetailList(String blNo){
		List<BillofLadingBean> detailList = new ArrayList<BillofLadingBean>();
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return detailList;
	}
	
	@Override
	public Integer seqPrint(String blNo, String printStatus){
		int seq;
		int no;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			seq=jdbcTemplate.queryForObject(BillofLadingQueryUtil.GET_seqforprint,new Object[] {blNo, printStatus},Integer.class);
			no=jdbcTemplate.update(BillofLadingQueryUtil.insert_seqprint,blNo,userDetails.getUserId(), printStatus);
		return seq;
	}
	
	@Override
	public BillofLadingResultBean getcountPrint(String blNo, String printStatus){
		BillofLadingResultBean bean = new BillofLadingResultBean();
		int count;
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int quotCount=  jdbcTemplate.queryForObject(BillofLadingQueryUtil.GET_Quot_Count,new Object[] {blNo},Integer.class);
            if(quotCount > 0){
 			count=jdbcTemplate.queryForObject(BillofLadingQueryUtil.GET_seqforprint,new Object[] {blNo, printStatus},Integer.class);
 			bean.setCount(count);
            }
            else{
            	bean.setMessage("Quotation is not available for the Booking!");
            }
 			return bean;
	}

	@Override
	public List<SelectivityBean> getContainerList() {
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(BillofLadingQueryUtil.getContainers,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	}