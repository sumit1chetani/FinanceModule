package com.dci.finance.hrmanageAttendance;

import java.util.List;

public class HrManageAttendanceBean {
	private int id;
	private int admissionNo;
	private String text;
	private String firstName;
	private int courseId;
	private String empId;
	private String employeeId;
	private String courseName;
	private String employeeName;
	private String typeDate;
	private int batchId;
	private String batchName;
	private boolean attendance;
	private boolean onDuty;
	private String remarks;
	private int sectionId;
	private String departmentId;
	private int academicYearId;
	private String sectionName;
	private String departmentName;
	private String acadamicYear;
	private int attendanceId;
	private String curDate;
	private int semesterId;
	private String timeIn;
	private String timeOut;
	private boolean status;
	private String attendanceDate;
	private String semesterName;
	private int subjectId;
	private String subjectName;
	private int disciplineId;
	private String disciplineName;
	private String createdBy;
	private int slotId;
	private String slotName;
	private String retailerId;
	private String retailerName;
	private String baseImgUrl;
	private String className;
	private String profileUrl;
	private int attendanceDetailId;

	private List<HrManageAttendanceBean> lHrManageAttendanceEmployee;

	public String getCurDate() {
		return curDate;
	}

	public void setCurDate(String curDate) {
		this.curDate = curDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAttendance() {
		return attendance;
	}

	public void setAttendance(boolean attendance) {
		this.attendance = attendance;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getAcadamicYear() {
		return acadamicYear;
	}

	public void setAcadamicYear(String acadamicYear) {
		this.acadamicYear = acadamicYear;
	}

	public int getSemesterId() {
		return semesterId;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public int getDisciplineId() {
		return disciplineId;
	}

	public String getDisciplineName() {
		return disciplineName;
	}

	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public void setDisciplineId(int disciplineId) {
		this.disciplineId = disciplineId;
	}

	public void setDisciplineName(String disciplineName) {
		this.disciplineName = disciplineName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public String getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}

	public String getRetailerName() {
		return retailerName;
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	public String getBaseImgUrl() {
		return baseImgUrl;
	}

	public void setBaseImgUrl(String baseImgUrl) {
		this.baseImgUrl = baseImgUrl;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getTypeDate() {
		return typeDate;
	}

	public void setTypeDate(String typeDate) {
		this.typeDate = typeDate;
	}

	

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public String getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}

	public String getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}

	public boolean isOnDuty() {
		return onDuty;
	}

	public void setOnDuty(boolean onDuty) {
		this.onDuty = onDuty;
	}

	public List<HrManageAttendanceBean> getlHrManageAttendanceEmployee() {
		return lHrManageAttendanceEmployee;
	}

	public void setlHrManageAttendanceEmployee(List<HrManageAttendanceBean> lHrManageAttendanceEmployee) {
		this.lHrManageAttendanceEmployee = lHrManageAttendanceEmployee;
	}

	public int getAdmissionNo() {
		return admissionNo;
	}

	public void setAdmissionNo(int admissionNo) {
		this.admissionNo = admissionNo;
	}

	public int getAttendanceDetailId() {
		return attendanceDetailId;
	}

	public void setAttendanceDetailId(int attendanceDetailId) {
		this.attendanceDetailId = attendanceDetailId;
	}

	public int getAcademicYearId() {
		return academicYearId;
	}

	public void setAcademicYearId(int academicYearId) {
		this.academicYearId = academicYearId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

}
