package com.dci.finance.leaveApproval;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.CommonUtilityBean;
import com.dci.common.util.CommonUtilityQueryUtil;
import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.finance.travelBookingRequest.TravelBookingRequestQueryUtil;
import com.dci.tenant.user.UserDetail;





@Repository
@Transactional("tenantTransactionManager")


public class LeaveAppCancelDAOImpl implements LeaveAppCancelDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(LeaveAppCancelDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Resource
	DataSource dataSource;
	/*@Override
	public LeaveAppCancelResultBean getList() throws Exception {
		// TODO Auto-generated method stub
		LeaveAppCancelResultBean resultBean = new LeaveAppCancelResultBean();
		List<LeaveAppCancelBean> leaveList = new ArrayList<LeaveAppCancelBean>();
		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String empId = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.SELECT_EMP_ID,String.class,teampUser.getUserId());

		 List<LeaveAppCancelBean>  reportList= jdbcTemplate.query(LeaveAppCancelQueryUtil.reporting_to, new BeanPropertyRowMapper<LeaveAppCancelBean>(LeaveAppCancelBean.class), empId);
           String where="and 1=1";
		 for(LeaveAppCancelBean report:reportList) {
			where+="or emp_id='"+report.getEmpId()+"'";
             }
		String query=LeaveAppCancelQueryUtil.leaveListQuery+where;
		leaveList = jdbcTemplate.query(query, new BeanPropertyRowMapper<LeaveAppCancelBean>(LeaveAppCancelBean.class), teampUser.getUserId());

		resultBean.setLeaveAppList(leaveList);
		return resultBean;
	}
*/
	

	@Override
	public List<LeaveAppCancelBean> getList() throws CustomException {
		List<LeaveAppCancelBean> travelList = new ArrayList<LeaveAppCancelBean>();
		List<CommonUtilityBean> workBeanlList = new ArrayList<CommonUtilityBean>();
		CommonUtilityBean commonBean =new CommonUtilityBean();
		
		try {
			UserDetail empUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
            //work flow entry checking
			
			String systemModuleName="Leave Application";
			
			commonBean = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.getEmpDetails, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class), empUser.getEmpId());
			
			workBeanlList = jdbcTemplate.query(CommonUtilityQueryUtil.getWorkFlowDetails, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class),new Object[] {systemModuleName,commonBean.getEmpBranch()});
			
			String reportingPersonCode="RA001";
		
			for(CommonUtilityBean bean:workBeanlList) {
				int i=1;
				if(bean.getApproveType().equalsIgnoreCase("Role")) {
					
					//step 1
					if(bean.getStepOrder()<=1) {
						if(bean.getRoleNameUser().equalsIgnoreCase(reportingPersonCode)) {
						
						travelList = jdbcTemplate.query(LeaveAppCancelQueryUtil.get_frst_reporting_manager_approval_List, new BeanPropertyRowMapper<LeaveAppCancelBean>
						(LeaveAppCancelBean.class),new Object[] {bean.getStepOrder(),empUser.getEmpId()});	
								
						}
						else if(bean.getRoleNameUser().equalsIgnoreCase(commonBean.getEmpDesignation())) {
							travelList = jdbcTemplate.query(LeaveAppCancelQueryUtil.get_frst_approval_List, new BeanPropertyRowMapper<LeaveAppCancelBean>(LeaveAppCancelBean.class)
									,new Object[] {bean.getStepOrder()});	
						}
					}else {
                        if(bean.getRoleNameUser().equalsIgnoreCase(reportingPersonCode)) {
                       
                        	int reportingPersonCount = jdbcTemplate.queryForObject(LeaveAppCancelQueryUtil.get_reportingPersonCount ,new Object[]{ empUser.getEmpId(),bean.getStepOrder()-1},Integer.class);
                        	
                        	if(reportingPersonCount>0) {
                        	travelList = jdbcTemplate.query(LeaveAppCancelQueryUtil.get_nxt_reporting_manager_approval_List, new BeanPropertyRowMapper<LeaveAppCancelBean>
							(LeaveAppCancelBean.class),new Object[] {bean.getStepOrder(),empUser.getEmpId(),bean.getStepOrder()-1});	
                        	}
                        	
						}
						else if(bean.getRoleNameUser().equalsIgnoreCase(commonBean.getEmpDesignation())) {
							travelList = jdbcTemplate.query(LeaveAppCancelQueryUtil.get_nxt_approval_List, new BeanPropertyRowMapper<LeaveAppCancelBean>(LeaveAppCancelBean.class)
									,new Object[] {bean.getStepOrder(),bean.getStepOrder()-1});
						}
					}
					
				}else {

					if(bean.getStepOrder()<=1) {
						if(bean.getRoleNameUser().equalsIgnoreCase(empUser.getEmpId())) {
							
						travelList = jdbcTemplate.query(LeaveAppCancelQueryUtil.get_frst_approval_List, new BeanPropertyRowMapper<LeaveAppCancelBean>(LeaveAppCancelBean.class)
								,new Object[] {bean.getStepOrder()});	

						}
						
					}else {
						if(bean.getRoleNameUser().equalsIgnoreCase(empUser.getEmpId())) {
							
							travelList = jdbcTemplate.query(LeaveAppCancelQueryUtil.get_nxt_approval_List, new BeanPropertyRowMapper<LeaveAppCancelBean>(LeaveAppCancelBean.class)
									,new Object[] {bean.getStepOrder(),bean.getStepOrder()-1});	

							}
					}
					
				
				}
			i++;	
			}
			
			

		} catch (DataAccessException e) {
			LOGGER.error("Error in getApprovalTravelList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return travelList;
	}
	@Override
	public LeaveAppCancelBean getEditListData(int leaveRequestId) throws Exception {
		LeaveAppCancelBean resultBean = new LeaveAppCancelBean();
		 String status ="";
		try {
			UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String empId = jdbcTemplate.queryForObject(LeaveAppCancelQueryUtil.SELECT_EMP_ID,String.class,teampUser.getUserId());
		//	String reportingId = jdbcTemplate.queryForObject(LeaveAppCancelQueryUtil.reporting_to, String.class, empId);
				resultBean = jdbcTemplate.queryForObject(LeaveAppCancelQueryUtil.editListQuery, new BeanPropertyRowMapper<LeaveAppCancelBean>(LeaveAppCancelBean.class),  leaveRequestId);
			if (resultBean.getStatus() == 0) {
				status = "Pending";
			} else if (resultBean.getStatus() == 1) {
				status = "Approved";
			} else if (resultBean.getStatus() == 2) {
				status = "Cancelled";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public boolean updateActionData(LeaveAppCancelBean updateBean) throws Exception {
		boolean sucess = false;
		String rep_emp_id = "SA001";
		String action = "";
		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String travelBookingType = updateBean.getLeaveType();
		UserDetail empUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int workFlowCount=0;
		CommonUtilityBean commonBean =new CommonUtilityBean();
		String systemModuleName="Leave Application";
		Integer status=null;
		String remarks=null;
		try {
	
			String fDate = updateBean.getDateFrom();



			String tDate = updateBean.getDateTo();


	
			String aDate = updateBean.getAppliedOn();


			//java.sql.Timestamp appDate = new Timestamp(date2.getTime());
			

			if (updateBean.getStatus() == 0) {
				action = "Pending";
			} else if (updateBean.getStatus() == 1) {
				action = "Approved";
			} else if (updateBean.getStatus() == 2) {
				action = "Cancelled";
			}
			int i = jdbcTemplate.update(LeaveAppCancelQueryUtil.updateLeaveQueryleve,  updateBean.getStatus(), empUser.getUserId(),updateBean.getLeaveRequestId());

			
			workFlowCount= jdbcTemplate.queryForObject(LeaveAppCancelQueryUtil.workFlowCountInTravelTable, new Object[] {updateBean.getLeaveRequestId(),updateBean.getStepOrder()},Integer.class);

			commonBean = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.getWorkFlowDetailsUsingStepsId, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class),new Object[] {systemModuleName,updateBean.getStepOrder()});

			
			if(workFlowCount>0) {
				//update
				jdbcTemplate.update(LeaveAppCancelQueryUtil.update_travel_workflow, updateBean.getStatus(), remarks, empUser.getUserId(), updateBean.getLeaveRequestId(),updateBean.getStepOrder());
	
			}else {
				//insert
				jdbcTemplate.update(LeaveAppCancelQueryUtil.insert_travel_workflow,updateBean.getLeaveRequestId(),updateBean.getStepOrder(),commonBean.getStepName(),commonBean.getApproveType(),empUser.getUserId(),updateBean.getStatus(), remarks,empUser.getUserId());

			}
			
		if (i > 0) {
				sucess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sucess;
	}
	
	
	

	/*@Override
	public boolean updateActionData(LeaveAppCancelBean updateBean) throws Exception {
		boolean sucess = false;
		String action = "";
		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			String fDate = updateBean.getDateFrom();



			String tDate = updateBean.getDateTo();

			DateFormat formatter;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			String aDate = updateBean.getAppliedOn();

			Date date2 = formatter.parse(aDate);
			java.sql.Timestamp appDate = new Timestamp(date2.getTime());

			//String aDate = updateBean.getAppliedOn();

			if (updateBean.getStatus() == 0) {
				action = "Pending";
			} else if (updateBean.getStatus() == 1) {
				action = "Approved";
			} else if (updateBean.getStatus() == 2) {
				action = "Cancelled";
			}

			int i = 0;
			if (updateBean.getApprovalType() == 1) {
				i = jdbcTemplate.update(LeaveAppCancelQueryUtil.updateLeaveAlternateQuery, appDate, teampUser.getUserId(), updateBean.getReason(), updateBean.getAlternativeStatus(), updateBean.getDescrip(), updateBean.getLeaveRequestId());
			} else if (updateBean.getApprovalType() == 2) {
				i = jdbcTemplate.update(LeaveAppCancelQueryUtil.updateLeaveReportQuery, appDate, teampUser.getUserId(), updateBean.getReason(), updateBean.getStatus(), updateBean.getDescrip(), updateBean.getLeaveRequestId());
				if (updateBean.getPayType() != null && updateBean.getPayType() != "") {
					jdbcTemplate.update(LeaveAppCancelQueryUtil.updateLeaveRequest, updateBean.getPayType(), updateBean.getLeaveRequestId());
				}
			} else {
				i = jdbcTemplate.update(LeaveAppCancelQueryUtil.updateLeaveFinalQuery, appDate, teampUser.getUserId(), updateBean.getReason(), updateBean.getFinalStatus(), updateBean.getDescrip(), action, updateBean.getLeaveRequestId());
				if (updateBean.getPayType() != null && updateBean.getPayType() != "") {
					jdbcTemplate.update(LeaveAppCancelQueryUtil.updateLeaveRequest, updateBean.getPayType(), updateBean.getLeaveRequestId());
				}
			}

			if (updateBean.getLeaveType().equals("CPL")) {
				if (updateBean.getAlternativeStatus() == 2 || updateBean.getStatus() == 2 || updateBean.getFinalStatus() == 2) {

					List<Map<String, Object>> holidayIdList = jdbcTemplate.queryForList(LeaveAppCancelQueryUtil.getHolidayId, updateBean.getLeaveRequestId());

					for (Map row : holidayIdList) {
						if ((int) row.get("id") != 0) {
							jdbcTemplate.update(LeaveRequestQueryUtil.holidayRequestQuery, 0, false, (int) row.get("id"));
						}
					}
					// int holidayId =
					// jdbcTemplate.queryForInt(LeaveAppCancelQueryUtil.getHolidayId,
					// updateBean.getLeaveRequestId());
					// if (holidayId > 0) {
					// jdbcTemplate.update(LeaveAppCancelQueryUtil.updateHolidayWorkedQuery,
					// 0, false, updateBean.getLeaveRequestId());
					// }
				}
			}

			if (i > 0) {
				sucess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sucess;
	}*/
}
