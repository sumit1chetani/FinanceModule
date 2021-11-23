package com.dci.tenant.finance.leave;

public class LeaveTypeQueryUtil {

	public static final String SELECT_LEAVE_TYPE_LIST = "SELECT " + "short_name, " + "leave_type_name, " + "can_carry_forward, " + "carry_forward_limit::integer, " + "status " + "FROM " + "leave_type l " + "where l.company_id=?";

	public static final String INSERT_LEAVE_TYPE = "INSERT INTO leave_type values(:shortName, :leaveTypeName,:canCarryForward, :carryForwardLimit::integer, :encashable, :appUnderProbation, :gender,:status,:maxDaysUnderProbation::integer,:isMedical,:maxDaysMedicalLeave::integer,:isMaternityLeave,:maxDaysMaternityLeave::integer,:companyId,:year,:creadted_by,:empid,:branch)";

	public static final String INSERT_LEAVE_TYPE_UPLOAD = "INSERT INTO leave_type(short_name, leave_type_name, can_carry_forward, carry_forward_limit, encashable, applicable_under_probation, gender,status, maxdays_underprobation, ismedical, maxdays_medicalleave, ismaternityleave, maxdays_maternityleave) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static final String UPDATE_LEAVE_TYPE = "UPDATE " + "leave_type " + "SET " + "leave_type_name= :leaveTypeName, " + "can_carry_forward = :canCarryForward, " + "carry_forward_limit = :carryForwardLimit::integer, " + "encashable  = :encashable, " + "applicable_under_probation = :appUnderProbation, " + "gender = :gender, " + "status = :status, " + "maxdays_underprobation = :maxDaysUnderProbation::integer, " + "ismedical = :isMedical, " + "maxdays_medicalleave = :maxDaysMedicalLeave::integer, " + "ismaternityleave = :isMaternityLeave, "
			+ "maxdays_maternityleave = :maxDaysMaternityLeave::integer,empid =:empId " + "WHERE short_name=:shortName";

	public static final String DELETE_LEAVE_TYPE = "DELETE " + "FROM " + "leave_type " + "WHERE " + "short_name=?";

	public static final String SELECT_LEAVE_TYPE_BY_SHORT_NAME =" SELECT year as year,e.emp_name as empId,short_name AS shortName, leave_type_name AS leaveTypeName, can_carry_forward AS canCarryForward, carry_forward_limit::integer AS carryForwardLimit, encashable AS encashable, applicable_under_probation AS applicableUnderProbation, leave_type.gender AS gender, leave_type.status AS status, maxdays_underprobation::integer AS maxDaysUnderProbation, isMedical AS medical, maxdays_medicalleave::integer AS maxDaysMedicalLeave, "
			+ " ismaternityleave AS maternityLeave, maxdays_maternityleave::integer AS maxDaysMaternityLeave,branch as branch  FROM leave_type "
			+ " left join employee_master e on e.emp_id=empid "
			+ " WHERE short_name=? ";

}
