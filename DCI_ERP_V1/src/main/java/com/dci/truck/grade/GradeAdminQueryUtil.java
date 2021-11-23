package com.dci.truck.grade;



public class GradeAdminQueryUtil {

	public static final String SELECT_GRADE_LIST = "SELECT grade_id gradeId, name gradeName, status status, description description FROM grade order by name asc";

	public static final String CHECK_COUNT_GRADE_UPDATE = "select count (*) from grade where company_id-? and name=? and grade_id<> ?";

	public static String INSERT_GRADE = "INSERT INTO grade(company_id,name,description, status) VALUES (:companyId,:gradeName,:description,:status)";

	public static final String INSERT_GRADE_UPLOAD = "INSERT INTO grade(name, status, description, company_id) values(?, ?, ?, ?)";

	public static String SELECT_GRADE_BY_ID = "SELECT grade_id gradeId, name gradeName, status status ,description description, company_id companyId FROM grade where grade_id=?";

	public static String DELETE_GRADE = "DELETE FROM grade WHERE grade_id=?";

	public static String CHECK_COUNT_GRADE = "SELECT count(*) FROM grade WHERE company_id =? and name=?";

	public static String UPDATE_GRADE = "UPDATE grade SET  name=:gradeName, status=:status,description=:description,company_id=:companyId WHERE grade_id=:gradeId";

	// public static String SELECT_COMPANY_LIST =
	// "select c.company_name as hospitalName, c.company_id as companyId from employee e inner join branch_department bd on e.branch_department_id = bd.branch_department_id inner join branch b on b.branch_id = bd.branch_id inner join department d on d.department_id = bd.department_id inner join company c on c.company_id = b.company_id inner join grade on e.grade_id=grade.grade_id where e.employee_id = ?";

	public static String SELECT_COMPANY_LIST = "select company_name as hospitalName, company_id as companyId,company_name as text,company_id as id from company order by company_name";

	public static String Grade_Name = "select name from grade where grade_id=? and company_id=?";

	public static String select_previous_id="select max(grade_id) from grade";

}

