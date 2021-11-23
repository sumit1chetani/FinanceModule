package com.dci.payroll.payroll.gradepaycomponent;

public class GradePayComponentQueryUtil {

	public static final String selectGradeComponentList = "select * from grade_pay_component(?) order by 1";

	public static final String sGradePayCombyIdDate = "select g.name as gradeName, gpc.grade_id, fromdate, pc.pay_component_id, pc.percentage_applied_on,  CASE WHEN pc.value IS NULL THEN 0.00 ELSE pc.value END AS value, pay_component_name, pay_component_type, CASE WHEN amount IS NULL THEN 0.00 ELSE amount END AS amount " + "from (select display_order, pay_component_id,percentage_applied_on, value, pay_component_name, pay_component_type from pay_component) pc "
			+ "left outer join ( select grade_id, fromdate, pay_component_id, amount from grade_pay_component as gpc where grade_id = ? AND fromdate = to_date(?,'dd/mm/yyyy')) gpc on pc.pay_component_id = gpc.pay_component_id " + "INNER JOIN  grade as g on g.grade_id= ? " + "ORDER BY " + "pay_component_type ASC,display_order";

	public static final String insertGradePayCom = "INSERT INTO grade_pay_component(grade_id, fromdate, pay_component_id, amount) " + " VALUES (:gradeId,to_date(:fromDate,'DD/MM/YYYY'),:payComponentId,:amount) ";

	public static final String updateGradePayCom = "UPDATE grade_pay_component SET grade_id=:gradeId,fromdate=to_date(:fromDate,'DD/MM/YYYY'),pay_component_id=:payComponentId,amount=:amount WHERE pay_component_id = :payComponentId AND fromdate=to_date(:fromDate,'DD/MM/YYYY') AND grade_id=:gradeId";

	public static final String deleteGradePayCom = "DELETE from grade_pay_component where grade_id=? and fromdate=to_date(?,'DD/MM/YYYY')";

	public static final String deleteGradePayComByID = "DELETE from grade_pay_component where grade_id=? and fromdate=to_date(?,'DD/MM/YYYY') and pay_component_id=?";

	public static final String checkGradePayCom = " select * from grade_pay_component where pay_component_id= ? and fromdate=to_date(?,'DD/MM/YYYY') and grade_id=?";

	public static final String getMaxFromDate = "SELECT to_char(MAX(fromdate),'DD/MM/YYYY') fromdate FROM grade_pay_component WHERE grade_id=?";

	public static final String selectGradeList = "select grade_id as gradeId, name as gradeName,grade_id as id, name as text from grade where company_id=? and grade_id not in(4,6,7)";

	public static final String checkGradeList = "select * from employee_pay_component where fromdate >= to_date(?,'DD/MM/YYYY')  and  employee_id in (select employee_id from employee where grade_id = ?)";

	public static final String insertGradeList = "insert into employee_pay_component select * from (select employee_id from employee where grade_id =? )A,(select pay_component_id, amount, fromdate from grade_pay_component where grade_id = ? and fromdate = to_date(?,'DD/MM/YYYY')) B";

}