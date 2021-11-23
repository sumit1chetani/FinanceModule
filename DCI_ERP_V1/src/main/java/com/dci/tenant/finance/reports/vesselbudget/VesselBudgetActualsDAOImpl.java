package com.dci.tenant.finance.reports.vesselbudget;
/*package com.mbk.tenant.finance.reports.vesselbudget;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mbk.common.util.CodeStandardMsgUtil;
import com.mbk.common.util.CustomException;
import com.mbkfinance.budget.budgetAllocation.BudgetAllocationBean;
import com.mbkfinance.budget.budgetAllocation.BudgetAllocationDtlBean;


@Repository
@Transactional("tenantTransactionManager")

public class VesselBudgetActualsDAOImpl implements VesselBudgetActualsDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(VesselBudgetActualsDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<VesselBudgetActualsBean> getBudgetActualsList() throws CustomException {
		List<VesselBudgetActualsBean> budgetActualsBeanList = null;
		try {
			budgetActualsBeanList = jdbcTemplate.query(VesselBudgetActualsQueryUtil.GET_BUDGET_ACTUAL_LIST, new BeanPropertyRowMapper<VesselBudgetActualsBean>(
					VesselBudgetActualsBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return budgetActualsBeanList;
	}
	
	@Override
	public List<BudgetAllocationBean> getBudgetActualsList() throws CustomException {
		List<BudgetAllocationBean> budgetAllocationBeanList = null;
		try {
			budgetAllocationBeanList = jdbcTemplate.query(VesselBudgetActualsQueryUtil.GET_BUDGET_ACTUAL_LIST, new BeanPropertyRowMapper<BudgetAllocationBean>(BudgetAllocationBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return budgetAllocationBeanList;
	}
	
	@Override
	public BudgetAllocationBean getBudgetActuals(BudgetAllocationBean budgetAllocationBean) throws CustomException {
		BudgetAllocationBean objBudgetAllocationBean = new BudgetAllocationBean();
		try {
	String fm="0",fy="0",tm="",ty="0",fromDt="01/01/",toDt="31/12/";
			
			if(budgetAllocationBean.getFromDate()!=null && !budgetAllocationBean.getFromDate().trim().isEmpty()){
				String fromDtArr[]=budgetAllocationBean.getFromDate().trim().split("/");
				fm=fromDtArr[1];
				fy=fromDtArr[2];				
			}
			if(budgetAllocationBean.getToDate()!=null && !budgetAllocationBean.getToDate().trim().isEmpty()){
				String toDtArr[]=budgetAllocationBean.getToDate().trim().split("/");
				tm=toDtArr[1];
				ty=toDtArr[2];				
			}
			
			int frmQut=getQuarter(Integer.parseInt(fm));
			int toQut=getQuarter(Integer.parseInt(tm));
			fromDt=fromDt+fy;
			toDt=toDt+fy;

		//	objBudgetAllocationBean = jdbcTemplate.queryForObject(BudgetActualsQueryUtil.GET_BUDGET_ALLOCATION_HDR, new Object[] { budgetAllocationBean.getVesselName(), budgetAllocationBean.getFromDate(), budgetAllocationBean.getToDate() }, new BeanPropertyRowMapper<BudgetAllocationBean>(BudgetAllocationBean.class));
			
			objBudgetAllocationBean.setVesselCode(budgetAllocationBean.getVesselName());
			objBudgetAllocationBean.setVesselName(budgetAllocationBean.getVesselName());
			objBudgetAllocationBean.setFromDate(budgetAllocationBean.getFromDate());
			objBudgetAllocationBean.setToDate(budgetAllocationBean.getToDate());
			System.out.println("Budget Act: "+budgetAllocationBean.getVesselName()+" "+ budgetAllocationBean.getFromDate() +" "+ budgetAllocationBean.getToDate());
			List<BudgetAllocationDtlBean> budgetAllocationDtlBeanList = jdbcTemplate.query(VesselBudgetActualsQueryUtil.GET_BUDGET_ALLOCATION_DTL, new Object[] {budgetAllocationBean.getFromDate(), budgetAllocationBean.getToDate(), budgetAllocationBean.getVesselName(), fromDt,toDt }, new BeanPropertyRowMapper<BudgetAllocationDtlBean>(BudgetAllocationDtlBean.class));
			objBudgetAllocationBean.setBudgetAllocationDtlBeanList(budgetAllocationDtlBeanList);
			double actualTotalAmt=0,budgetTotalAmt=0;
			for(BudgetAllocationDtlBean obj:budgetAllocationDtlBeanList){
				actualTotalAmt+=obj.getActualAmt();
				budgetTotalAmt+=obj.getAllocatedAmount();
			}
			objBudgetAllocationBean.setActualTotalAmt(actualTotalAmt);
			objBudgetAllocationBean.setBudgetTotalAmt(budgetTotalAmt);
			objBudgetAllocationBean=getBudgetActualsExcelData(budgetAllocationBean);
			
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return objBudgetAllocationBean;
	}
	
	
	@Override
	public BudgetAllocationBean getBudgetActualsExcelData(BudgetAllocationBean budgetAllocationBean) throws CustomException {
		BudgetAllocationBean objBudgetAllocationBean = new BudgetAllocationBean();
		try {
			String fm="0",fy="0",tm="",ty="0",fromDt="01/01/",toDt="31/12/";
			
			if(budgetAllocationBean.getFromDate()!=null && !budgetAllocationBean.getFromDate().trim().isEmpty()){
				String fromDtArr[]=budgetAllocationBean.getFromDate().trim().split("/");
				fm=fromDtArr[1];
				fy=fromDtArr[2];				
			}
			if(budgetAllocationBean.getToDate()!=null && !budgetAllocationBean.getToDate().trim().isEmpty()){
				String toDtArr[]=budgetAllocationBean.getToDate().trim().split("/");
				tm=toDtArr[1];
				ty=toDtArr[2];				
			}
			
			int frmQut=getQuarter(Integer.parseInt(fm));
			int toQut=getQuarter(Integer.parseInt(tm));
			
			objBudgetAllocationBean.setVesselCode(budgetAllocationBean.getVesselName());
			objBudgetAllocationBean.setVesselName(budgetAllocationBean.getVesselName());
			objBudgetAllocationBean.setFromDate(budgetAllocationBean.getFromDate());
			objBudgetAllocationBean.setToDate(budgetAllocationBean.getToDate());
			
		//	objBudgetAllocationBean = jdbcTemplate.queryForObject(BudgetActualsQueryUtil.GET_BUDGET_ALLOCATION_HDR, new Object[] { budgetAllocationBean.getVesselName(), budgetAllocationBean.getFromDate(), budgetAllocationBean.getToDate() }, new BeanPropertyRowMapper<BudgetAllocationBean>(BudgetAllocationBean.class));
			System.out.println("Budget Act: "+budgetAllocationBean.getVesselName()+" "+ budgetAllocationBean.getFromDate() +" "+ budgetAllocationBean.getToDate()+" "+fy);
			List<BudgetAllocationDtlBean> budgetAllocationDtlBeanList =new ArrayList<BudgetAllocationDtlBean>();
			//,budgetAllocationBean.getFromDate(), budgetAllocationBean.getToDate(), "01/01/"+fy,  "31/12/"+fy 
			fromDt=fromDt+fy;
			toDt=toDt+fy;
			double budgetTotal=0,actualTotal=0;
			
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(VesselBudgetActualsQueryUtil.GET_BUDGET_ALLOCATION_DTL_QUARTER, new Object[] { budgetAllocationBean.getFromDate(), budgetAllocationBean.getToDate(),budgetAllocationBean.getVesselName(),fromDt,toDt});
		for(Map row:rows){
			BudgetAllocationDtlBean budAllocDtlObj=new BudgetAllocationDtlBean();
			select distinct ves.VESSEL_NAME,db.BUDGET_DESCRIPTION as budgetDesc,vb.BUDGET_CODE as budgetCode,act.ACCT_HEAD_CODE acctHeadCode,
			 * coalesce(debit,0) as debitAmt,coalesce(credit,0) as creditAmt,coalesce(debit,0) -coalesce(credit,0) as actualAmt,"
					+"TO_CHAR(FROM_DATE,'DD-MM-YYYY') FROM_DATE,TO_CHAR(TO_DATE,'DD-MM-YYYY') TO_DATE,ALLOCATED_AMOUNT as allocatedAmount,"
					+"FIRST_QUARTER as firstQuarterAmount,SECOND_QUARTER as secondQuarterAmount, THIRD_QUARTER as thirdQuarterAmount,"
					+"FOURTH_QUARTER  as fourthQuarterAmount,gl.company_code from DANAOS_VESSEL_BUDGETS vb
			budAllocDtlObj.setBudgetDesc((String)row.get("budgetDesc"));
			budAllocDtlObj.setBudgetCode((String)row.get("budgetCode"));
			budAllocDtlObj.setAcctHeadCode((String)row.get("acctHeadCode"));
			budAllocDtlObj.setBudgetDesc((String)row.get("budgetDesc"));
			budAllocDtlObj.setActualAmt(Double.parseDouble( row.get("actualAmt").toString()));
			budAllocDtlObj.setAllocatedAmount(Double.parseDouble( row.get("allocatedAmount").toString()));
			budAllocDtlObj.setFirstQuarterAmount(Double.parseDouble( row.get("firstQuarterAmount").toString()));
			budAllocDtlObj.setSecondQuarterAmount(Double.parseDouble( row.get("secondQuarterAmount").toString()));
			budAllocDtlObj.setThirdQuarterAmount(Double.parseDouble( row.get("thirdQuarterAmount").toString()));
			budAllocDtlObj.setFourthQuarterAmount(Double.parseDouble( row.get("fourthQuarterAmount").toString()));
			List<Double> quarterAmtList=new ArrayList<Double>();
			quarterAmtList.add(0.0);
			quarterAmtList.add(budAllocDtlObj.getFirstQuarterAmount());
			quarterAmtList.add(budAllocDtlObj.getSecondQuarterAmount());
			quarterAmtList.add(budAllocDtlObj.getThirdQuarterAmount());
			quarterAmtList.add(budAllocDtlObj.getFourthQuarterAmount());
			double budgetAmt=0;
			for(int i=frmQut;i<=toQut;i++){
				budgetAmt+=quarterAmtList.get(i);
			}
			budAllocDtlObj.setAllocatedAmount(budgetAmt);
			
			budgetTotal+=budgetAmt;
			actualTotal+=budAllocDtlObj.getActualAmt();
			
			budgetAllocationDtlBeanList.add(budAllocDtlObj);
		}
		objBudgetAllocationBean.setActualTotalAmt(actualTotal);
		objBudgetAllocationBean.setBudgetTotalAmt(budgetTotal);
			objBudgetAllocationBean.setBudgetAllocationDtlBeanList(budgetAllocationDtlBeanList);
			
			
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return objBudgetAllocationBean;
	}
	
	public int getQuarter(int fm){
		if(fm>=1 && fm<=3){
			return 1;
		}else if(fm>=3 && fm<=6){
			return 2;
		}
		else if(fm>=6 && fm<=9){
			return 3;
		}
		else if(fm>=9 && fm<=12){
			return 4;
		}else{
			return 0;
		}
		
	}
	
	@Override
	public VesselBudgetActualsBean getBudgetAllocationDetails(VesselBudgetActualsBean objBudgetActualsBean) throws CustomException {
		VesselBudgetActualsBean budgetActualsBean = new VesselBudgetActualsBean();
		List<VesselBudgetActualsDtlBean> budgetActualsDtlBeanList = new ArrayList<VesselBudgetActualsDtlBean>();
		try {
			budgetActualsBean = objBudgetActualsBean;
			double allocatedAmount = budgetActualsBean.getAllocatedTotalAmount();
			double tcPinAmount = 0, bcPinAmount = 0, bcamitGt = 0, bcCBPAmount = 0, tcCBPAmount = 0, cbpamitGt = 0;
			budgetActualsBean.setInvoiceLpoAmount(0);
			budgetActualsBean.setOpeningAmount(0);
			budgetActualsBean.setTotalSpendAmount(0);
			budgetActualsBean.setPctAmount(0);
			budgetActualsBean.setBalanceAmount(allocatedAmount);

			for (int i = 1; i <= 5; i++) {
				VesselBudgetActualsDtlBean budgetActualsDtlBean = new VesselBudgetActualsDtlBean();
				if (i == 5) {
					budgetActualsDtlBean.setTerms("Total");
					budgetActualsDtlBean.setAllocatedAmount(allocatedAmount);
					budgetActualsDtlBean.setInvoiceLpoAmount(bcamitGt);
					budgetActualsDtlBean.setOpeningAmount(0);
					budgetActualsDtlBean.setTotalSpendAmount(cbpamitGt);
					budgetActualsDtlBean.setPctAmount(0);
					budgetActualsDtlBean.setBalanceAmount(allocatedAmount - cbpamitGt);
				} else {
					String fromDt = "", toDate = "";
					String yearArr[] = budgetActualsBean.getFromDate().trim().split("-");

					if (i == 1) {
						fromDt = "01-01-" + yearArr[2];
						toDate = "31-03-" + yearArr[2];
					}
					if (i == 2) {
						fromDt = "01-04-" + yearArr[2];
						toDate = "30-06-" + yearArr[2];
					}
					if (i == 3) {
						fromDt = "01-07-" + yearArr[2];
						toDate = "30-09-" + yearArr[2];
					}
					if (i == 4) {
						fromDt = "01-10-" + yearArr[2];
						toDate = "31-12-" + yearArr[2];
					}
					System.out.println("vessel =" + budgetActualsBean.getVesselName());
					System.out.println("dept =" + budgetActualsBean.getDepartmentName());
					System.out.println("from date =" + fromDt);
					System.out.println("to date =" + toDate);
					System.out.println(budgetActualsBean.getFromDate().trim() + "=year=" + yearArr[2]);
					System.out.println("PIN amount=" + bcPinAmount);
					List<Map<String, Object>> allocatedRows = jdbcTemplate.queryForList(VesselBudgetActualsQueryUtil.GET_PIN_AMOUNT, new Object[] {
							budgetActualsBean.getVesselName().trim(), budgetActualsBean.getDepartmentName().trim(), fromDt, toDate });
					for (Map row : allocatedRows) {
						tcPinAmount = Double.parseDouble(row.get("tc_amount").toString());
						bcPinAmount = Double.parseDouble(row.get("bc_amount").toString());
					}

					List<Map<String, Object>> cpRows = jdbcTemplate.queryForList(VesselBudgetActualsQueryUtil.GET_CBP_AMOUNT, new Object[] {
							budgetActualsBean.getVesselName().trim(), budgetActualsBean.getDepartmentName().trim(), fromDt, toDate });
					for (Map row : cpRows) {
						tcCBPAmount = Double.parseDouble(row.get("tc_amount").toString());
						bcCBPAmount = Double.parseDouble(row.get("bc_amount").toString());
					}

					bcamitGt = bcamitGt + bcPinAmount;
					cbpamitGt = cbpamitGt + bcCBPAmount;
					budgetActualsDtlBean.setTerms(i + "st Quarter");
					budgetActualsDtlBean.setInvoiceLpoAmount(bcPinAmount);
					budgetActualsDtlBean.setOpeningAmount(0);
					budgetActualsDtlBean.setTotalSpendAmount(bcCBPAmount);
					budgetActualsDtlBean.setPctAmount(0);
					budgetActualsDtlBean.setAllocatedAmount(allocatedAmount / 4);
					budgetActualsDtlBean.setBalanceAmount((allocatedAmount / 4) - bcCBPAmount);

				}
				budgetActualsDtlBeanList.add(budgetActualsDtlBean);
				budgetActualsBean.setBudgetActualsDtlBeanList(budgetActualsDtlBeanList);
			}
		} catch (DataAccessException e) {
			System.out.println(e);
			LOGGER.error("Error in List", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return budgetActualsBean;
	}

	@Override
	public List<VesselBudgetActualsBean> getVesselName(VesselBudgetActualsBean budgetActualsBean) throws CustomException {
		List<VesselBudgetActualsBean> budgetActualsBeanList = null;
		try {
			budgetActualsBeanList = jdbcTemplate.query(VesselBudgetActualsQueryUtil.GET_BUDGET_ACTUAL_VESSEL,
					new Object[] { budgetActualsBean.getVesselCode(), "31/12/" + budgetActualsBean.getYear() },
					new BeanPropertyRowMapper<VesselBudgetActualsBean>(VesselBudgetActualsBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return budgetActualsBeanList;
	}

	@Override
	public List<VesselBudgetActualsBean> getVesselList() {
		List<VesselBudgetActualsBean> vesselLsit = new ArrayList<VesselBudgetActualsBean>();
		try {

			vesselLsit = jdbcTemplate.query(VesselBudgetActualsQueryUtil.GET_VESSEL, new BeanPropertyRowMapper<VesselBudgetActualsBean>(VesselBudgetActualsBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in vessel", e);
		}
		return vesselLsit;
	}

	@Override
	public int getAllocatedCount(VesselBudgetActualsBean budgetActualsBean) {
		int budgetDepartmentCount = 0;
		try {

			budgetDepartmentCount = jdbcTemplate.queryForObject(VesselBudgetActualsQueryUtil.GET_ALLOCATED_COUNT,Integer.class,
					new Object[] { budgetActualsBean.getVesselCode(), "31/12/" + budgetActualsBean.getYear() });

		} catch (DataAccessException e) {
			LOGGER.error("Error in vessel", e);
		}
		return budgetDepartmentCount;
	}

	@Override
	public List<VesselBudgetActualsDtlBean> getAllocatedAmount(VesselBudgetActualsBean budgetActualsBean) throws CustomException {
		List<VesselBudgetActualsDtlBean> budgetActualsBeanList = new ArrayList<VesselBudgetActualsDtlBean>();
		try {
			double allocatedTotAmt = 0, allocatedAmt = 0;
			String termArray[] = { "1st Quarter", "2nd Quarter", "3rd Quarter", "4th Quarter", "Total" };
			List<Map<String, Object>> allocatedRows = jdbcTemplate.queryForList(VesselBudgetActualsQueryUtil.GET_ALLOCATED_AMOUNT, new Object[] {
					budgetActualsBean.getVesselCode(), "31/12/" + budgetActualsBean.getYear() });
			for (Map row : allocatedRows) {
				VesselBudgetActualsDtlBean budgetActualsDtlBean = new VesselBudgetActualsDtlBean();

				for (int i = 0; i < 5; i++) {

					if (i == 4) {
						budgetActualsDtlBean.setTerms(termArray[i]);
						allocatedTotAmt = convertToDouble(String.valueOf(row.get("ALLOCATED_AMOUNT")));
						allocatedAmt = (allocatedTotAmt > 0) ? (allocatedTotAmt / 4) : 0;
						budgetActualsDtlBean.setAllocatedAmount(allocatedAmt);
						budgetActualsDtlBean.setBalanceAmount(allocatedAmt);

					} else {
						budgetActualsDtlBean.setTerms(termArray[i]);
						allocatedTotAmt = convertToDouble(String.valueOf(row.get("ALLOCATED_AMOUNT")));
						allocatedAmt = (allocatedTotAmt > 0) ? (allocatedTotAmt / 4) : 0;
						budgetActualsDtlBean.setAllocatedAmount(allocatedAmt);
						budgetActualsDtlBean.setBalanceAmount(allocatedAmt);
						budgetActualsDtlBean.setBudgetCode(String.valueOf(row.get("BUDGET_CODE")));
						budgetActualsDtlBean.setBudgetDesc(String.valueOf(row.get("BUDGET_DESCRIPTION")));
						budgetActualsDtlBean.setDepartmentName(String.valueOf(row.get("NAME")));

					}

					budgetActualsBeanList.add(budgetActualsDtlBean);
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return budgetActualsBeanList;
	}

	public double convertToDouble(String str) {
		double amount = 0;
		if (str != null && !str.trim().isEmpty()) {
			amount = Double.parseDouble(str.trim());
		}
		return amount;
	}
	@Override
	public VesselBudgetActualsResultBean saveBudgetAllocation(BudgetAllocationBean budgetAllocHdr, String userId) throws CustomException {
		VesselBudgetActualsResultBean resultBean=new VesselBudgetActualsResultBean();
		try {
			company_code, vessel_code, budget_code, from_date, to_date, allocated_amount, " 
					+" first_quarter, second_quarter, third_quarter, fourth_quarter,comments, created_by, created_dt) "
			for(BudgetAllocationDtlBean budgetBean:budgetAllocHdr.getBudgetAllocationDtlBeanList()){
			jdbcTemplate.update(VesselBudgetActualsQueryUtil.SAVE_BUDGET_ALLOC, new Object[] { budgetBean.getCompanyCode(),budgetBean.getVesselId(),budgetBean.getAcctHeadCode(),budgetAllocHdr.getFromDate(),budgetAllocHdr.getToDate(),budgetBean.getAllocatedAmount(),
					budgetBean.getFirstQuarterAmount(),budgetBean.getSecondQuarterAmount(),budgetBean.getThirdQuarterAmount(),budgetBean.getFourthQuarterAmount(),budgetBean.getNarration(), userId});
			}
		}
		catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return resultBean;
	}

}
*/