package com.dci.finance.hrmanageAttendance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

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

public class HrManageAttendanceDAOimpl implements HrManageAttendanceDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Override
	public HrManageAttendanceResultBean getDepartmentName() {
		// TODO Auto-generated method stub
		HrManageAttendanceResultBean objManageAttendanceResultBean = new HrManageAttendanceResultBean();
		List<SelectivityBean> DepartmentList = new ArrayList<SelectivityBean>();
		try {

			DepartmentList = jdbcTemplate.query(HrManageAttendanceQueryUtill.SELECT_DEPARTMENT_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			objManageAttendanceResultBean.setDepartmentName(DepartmentList);
			objManageAttendanceResultBean.setSuccess(true);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return objManageAttendanceResultBean;
	}

	@Override
	public HrManageAttendanceResultBean getFirstName() {
		// TODO Auto-generated method stub
		HrManageAttendanceResultBean objManageAttendanceResultBean = new HrManageAttendanceResultBean();
		List<SelectivityBean> FirstNameList = new ArrayList<SelectivityBean>();
		try {

			FirstNameList = jdbcTemplate.query(HrManageAttendanceQueryUtill.SELECT_EMPLOYEENAME_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			objManageAttendanceResultBean.setFirstnameList(FirstNameList);
			objManageAttendanceResultBean.setSuccess(true);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return objManageAttendanceResultBean;
	}

	@Override
	public HrManageAttendanceResultBean saveHrManageAttendance(HrManageAttendanceBean objBean) {
		// TODO Auto-generated method stub
		HrManageAttendanceResultBean objManageAttendanceResultBean = new HrManageAttendanceResultBean();

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		DateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");

		int err = 0;

		int EmployeeInsert = 0;

		try {

			for (HrManageAttendanceBean obj : objBean.getlHrManageAttendanceEmployee()) {

				EmployeeInsert = jdbcTemplate.update(HrManageAttendanceQueryUtill.INSERT_Employee_ATTENDANCE,obj.getEmployeeId(), objBean.getDepartmentId(), objBean.getAttendanceDate(), obj.isAttendance(), obj.isOnDuty(), obj.getRemarks(), userDetails.getUserId());

			}

			objManageAttendanceResultBean.setSuccess(true);

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return objManageAttendanceResultBean;
	}

	@Override
	public HrManageAttendanceResultBean getHrManageAttendance() {
		// TODO Auto-generated method stub
		HrManageAttendanceResultBean objManageAttendanceResultBean = new HrManageAttendanceResultBean();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<HrManageAttendanceBean> manageAttendanceList = new ArrayList<HrManageAttendanceBean>();
		try {
			manageAttendanceList = jdbcTemplate.query(HrManageAttendanceQueryUtill.SELECT_ATTENDANCE_LIST, new BeanPropertyRowMapper<HrManageAttendanceBean>(HrManageAttendanceBean.class));
			objManageAttendanceResultBean.setManageAttendanceBeanList(manageAttendanceList);
			objManageAttendanceResultBean.setSuccess(true);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return objManageAttendanceResultBean;
	}

	@Override
	public HrManageAttendanceBean editHrManageAttendance(String departmentId, String attendanceDate) {
		// TODO Auto-generated method stub
		List<HrManageAttendanceBean> hrManageAttendanceList = new ArrayList<HrManageAttendanceBean>();
		List<HrManageAttendanceBean> hrManageAttendanceList1 = new ArrayList<HrManageAttendanceBean>();

		HrManageAttendanceBean objManageAttendanceBean = new HrManageAttendanceBean();

		try {

			objManageAttendanceBean = jdbcTemplate.queryForObject(HrManageAttendanceQueryUtill.SELECT_ATTENDANCE_EDIT, new Object[] { departmentId, attendanceDate }, new BeanPropertyRowMapper<HrManageAttendanceBean>(HrManageAttendanceBean.class));

			hrManageAttendanceList = jdbcTemplate.query(HrManageAttendanceQueryUtill.SELECT_ATTENDANCELIST_EDIT, new Object[] { departmentId, attendanceDate }, new BeanPropertyRowMapper<HrManageAttendanceBean>(HrManageAttendanceBean.class));
			objManageAttendanceBean.setlHrManageAttendanceEmployee(hrManageAttendanceList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objManageAttendanceBean;
	}

	@Override
	public HrManageAttendanceResultBean updateHrManageAttendance(HrManageAttendanceBean objBean) {
		// TODO Auto-generated method stub
		HrManageAttendanceResultBean objManageAttendanceResultBean = new HrManageAttendanceResultBean();

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		DateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");

		int err = 0;

		int EmployeeInsert = 0;

		try {

			for (HrManageAttendanceBean obj : objBean.getlHrManageAttendanceEmployee()) {

				EmployeeInsert = jdbcTemplate.update(HrManageAttendanceQueryUtill.UPDATE_MANAGE_ATTENDANCE_Employee, userDetails.getUserId(), obj.isAttendance(), obj.isOnDuty(), obj.getRemarks(), obj.getAttendanceId());

			}

			objManageAttendanceResultBean.setSuccess(true);

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return objManageAttendanceResultBean;
	}

	@Override
	public HrManageAttendanceResultBean deleteHrManageAttendance(int attendanceId) {
		// TODO Auto-generated method stub
		HrManageAttendanceResultBean objManageAttendanceResultBean = new HrManageAttendanceResultBean();
		try {
			jdbcTemplate.update(HrManageAttendanceQueryUtill.DELETE_ATTENDANCE, attendanceId);
			// jdbcTemplate.update(ManageAttendanceQueryUtill.DELETE_MANAGE_ATTENDANCE,
			// sectionId);
			objManageAttendanceResultBean.setSuccess(true);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return objManageAttendanceResultBean;
	}

	@Override
	public HrManageAttendanceResultBean getEmployeeList1(HrManageAttendanceBean objBean) {
		// TODO Auto-generated method stub
		HrManageAttendanceResultBean objManageAttendanceResultBean = new HrManageAttendanceResultBean();
		List<HrManageAttendanceBean> EmployeeList = new ArrayList<HrManageAttendanceBean>();
		try {
			/*int check = jdbcTemplate.query(HrManageAttendanceQueryUtill.SELECT_COUNT, objBean.getAcademicYearId(), objBean.getAttendanceDate());
			if (check == 0) {
				EmployeeList = jdbcTemplate.query(HrManageAttendanceQueryUtill.SELECT_Employee_LIST1, new BeanPropertyRowMapper<HrManageAttendanceBean>(HrManageAttendanceBean.class));
			}
*/
		}
		/*
		 * if (check > 0) {
		 * 
		 * } objManageAttendanceResultBean.setHrManageAttendanceEmployeeBean(
		 * EmployeeList); objManageAttendanceResultBean.setSuccess(true); }
		 */catch (DataAccessException e) {
			e.printStackTrace();
		}
		return objManageAttendanceResultBean;
	}

	@Override
	public HrManageAttendanceResultBean getAcademicYearList() {
		// TODO Auto-generated method stub
		HrManageAttendanceResultBean objManageAttendanceResultBean = new HrManageAttendanceResultBean();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<HrManageAttendanceBean> academicList = new ArrayList<HrManageAttendanceBean>();
		try {
			academicList = jdbcTemplate.query(HrManageAttendanceQueryUtill.SELECT_ACADEMIC_LIST, new BeanPropertyRowMapper<HrManageAttendanceBean>(HrManageAttendanceBean.class), userDetail.getCustomerId());

			objManageAttendanceResultBean.setAcademicList(academicList);
			objManageAttendanceResultBean.setSuccess(true);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return objManageAttendanceResultBean;
	}

	@Override
	public List<HrManageAttendanceBean> getEmployeeList(String departmentId) {
		// TODO Auto-generated method stub

		List<HrManageAttendanceBean> EmployeeList = new ArrayList<HrManageAttendanceBean>();
		try {

			EmployeeList = jdbcTemplate.query(HrManageAttendanceQueryUtill.SELECT_Employee_LIST, new Object[] { departmentId }, new BeanPropertyRowMapper<HrManageAttendanceBean>(HrManageAttendanceBean.class));

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return EmployeeList;
	}

}
