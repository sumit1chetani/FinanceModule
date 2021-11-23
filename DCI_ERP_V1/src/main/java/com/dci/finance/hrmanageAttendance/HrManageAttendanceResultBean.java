package com.dci.finance.hrmanageAttendance;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;




public class HrManageAttendanceResultBean extends BasicResultBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List departmentList;
	private List courseNameList;
	private List batchNameList;
	private List subjectList;
	private List sectionNameList;

	List<SelectivityBean> departmentName;
	List<SelectivityBean> firstName;
	List<SelectivityBean> departmentId;
	private List firstnameList;
	private List academicList;
	private List<HrManageAttendanceBean> hrManageAttendanceBean;
	private List<HrManageAttendanceBean> hrManageAttendanceBeanList;
	private List<HrManageAttendanceBean> hrManageAttendanceBeanList1;

	private HrManageAttendanceBean objHrManageAttendanceBean;
	private int attendanceId;
	private List disciplineList;

	private List classList;
	private List academicYear;

	private List<HrManageAttendanceBean> employeeList;

	public List getAcademicList() {
		return academicList;
	}

	public void setAcademicList(List academicList) {
		this.academicList = academicList;
	}

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int employeeId) {
		this.attendanceId = employeeId;
	}

	public List<HrManageAttendanceBean> getHrManageAttendanceEmployeeBean() {
		return hrManageAttendanceBean;
	}

	public void setHrManageAttendanceEmployeeBean(List<HrManageAttendanceBean> manageAttendanceEmployeeBean) {
		this.hrManageAttendanceBean = manageAttendanceEmployeeBean;
	}

	public HrManageAttendanceBean getObjHrManageAttendanceBean() {
		return objHrManageAttendanceBean;
	}

	public void setObjHrManageAttendanceBean(HrManageAttendanceBean objManageAttendanceBean) {
		this.objHrManageAttendanceBean = objManageAttendanceBean;
	}

	public List<HrManageAttendanceBean> getHrManageAttendanceBeanList() {
		return hrManageAttendanceBeanList;
	}

	public void setManageAttendanceBeanList(List<HrManageAttendanceBean> manageAttendanceBeanList) {
		this.hrManageAttendanceBeanList = manageAttendanceBeanList;
	}

	public List getCourseNameList() {
		return courseNameList;
	}

	public void setCourseNameList(List courseNameList) {
		this.courseNameList = courseNameList;
	}

	public List getBatchNameList() {
		return batchNameList;
	}

	public void setBatchNameList(List batchNameList) {
		this.batchNameList = batchNameList;
	}

	public List getSectionNameList() {
		return sectionNameList;
	}

	public void setSectionNameList(List sectionNameList) {
		this.sectionNameList = sectionNameList;
	}

	public List getDisciplineList() {
		return disciplineList;
	}

	public void setDisciplineList(List disciplineList) {
		this.disciplineList = disciplineList;
	}

	public List getClassList() {
		return classList;
	}

	public void setClassList(List classList) {
		this.classList = classList;
	}

	public List getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List subjectList) {
		this.subjectList = subjectList;
	}

	public List getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(List departmentName) {
		this.departmentName = departmentName;
	}

	public List getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List departmentList) {
		this.departmentList = departmentList;
	}

	public List getFirstnameList() {
		return firstnameList;
	}

	public void setFirstnameList(List firstnameList) {
		this.firstnameList = firstnameList;
	}

	public List<HrManageAttendanceBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<HrManageAttendanceBean> employeeList) {
		this.employeeList = employeeList;
	}

	public List getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(List academicYear) {
		this.academicYear = academicYear;
	}

	public List<HrManageAttendanceBean> getHrManageAttendanceBeanList1() {
		return hrManageAttendanceBeanList1;
	}

	public void setHrManageAttendanceBeanList1(List<HrManageAttendanceBean> hrManageAttendanceBeanList1) {
		this.hrManageAttendanceBeanList1 = hrManageAttendanceBeanList1;
	}

}
