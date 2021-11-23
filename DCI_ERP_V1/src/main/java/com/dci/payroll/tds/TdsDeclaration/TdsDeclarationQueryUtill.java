package com.dci.payroll.tds.TdsDeclaration;

public class TdsDeclarationQueryUtill {

	public static final String SELECT_ALL = "SELECT ss.tax_sub_section_description,ss.tax_sub_section_code,ss.tax_section_code,coalesce(tax_sub_section_max_limit,0) limited, coalesce(actual_amount,0) actual_amount, coalesce(declared_amount,0) declared_amount, filepath_url filepathUrl from tax_sub_section ss " + " LEFT OUTER JOIN " + "( SELECT tax_section_code,tax_sub_section_code, actual_amount, declared_amount ,filepath_url FROM employee_tds_declaration "
			+ "where employee_id = ? and financial_year_id = ?) d on ss.tax_sub_section_code = d.tax_sub_section_code " + "WHERE ss.tax_section_code=?  and ss.is_computed=? order by display_order";

	public static final String SELECT_EMP_DECLARATION_BY_ID = "SELECT employee_id,financial_year_id,tax_sub_section_code FROM employee_tds_declaration WHERE employee_id=? AND financial_year_id=? AND tax_sub_section_code=?";

	public static final String SELECT_BY_SK = "select * from  employee_tds_declaration where employee_tds_declaration_id=?";

	public static final String INSERT = "INSERT INTO employee_tds_declaration" + "(employee_id,financial_year_id,tax_section_code,tax_sub_section_code,declared_amount,status) " + "VALUES (:employee_id,:financial_year_id,:tax_section_code,:tax_sub_section_code,:declared_amount,:status) ";

	public static final String UPDATE = "UPDATE employee_tds_declaration SET " + "employee_id = :employeeId, financial_year_id =:financialYearId," + "tax_section_code = :taxSectionCode, tax_sub_section_code = :taxSubSectionCode," + "actual_amount = :actualAmount, declared_amount = :declaredAmount," + "status = :status, filepath_url =:filepathUrl " + "where employee_tds_declaration_id=?";

	public static final String UPDATE_EMP_DECLARATION = "UPDATE employee_tds_declaration SET declared_amount = :declared_amount,status=:status WHERE employee_id=:employee_id AND financial_year_id=:financial_year_id AND tax_sub_section_code = :tax_sub_section_code";

	public static final String UPDATE_EMP_ACTUAL = "UPDATE employee_tds_declaration SET actual_amount = :actual_amount, filepath_url=:filepath_url, status=:status WHERE employee_id=:employee_id AND financial_year_id=:financial_year_id AND tax_sub_section_code = :tax_sub_section_code";

	public static final String INSERT_ACTUAL = "INSERT INTO employee_tds_declaration" + "(employee_id,financial_year_id,tax_section_code,tax_sub_section_code,actual_amount,status,filepath_url) " + "VALUES (:employee_id,:financial_year_id,:tax_section_code,:tax_sub_section_code,:actual_amount,:status,:filepath_url)";

	public static final String DELETE_BY_SK = "delete from  employee_tds_declaration where employee_tds_declaration_id=?";

	public static final String EMPLOYEE_TDS_GENERATION = "select E.employee_id, E.first_name||' '||E.middle_name||' '||E.surname  employeeName, coalesce(T.amount,0) amount from employees(?,?,?,?) E left outer join ( select * from  employee_pay_component_paid  where pay_component_id = ? and month_year = ? ) T on E.employee_id = T.employee_id";

	public static final String INSERT_EMP_PAYCOM_PAID = "INSERT INTO employee_pay_component_paid(employee_id,pay_component_id,month_year,amount) VALUES(:employee_id,:pay_component_id,:month_year,:amount)";

	public static final String UPDATE_EMP_PAYCOM_PAID = "UPDATE employee_pay_component_paid SET employee_id=:employee_id,pay_component_id=:pay_component_id,month_year=:month_year,amount=:amount WHERE employee_id=:employee_id AND month_year=:month_year AND pay_component_id=:pay_component_id";

	public static final String CHECK_EMP_PAYCOM_PAID_EXISTS = "SELECT * FROM employee_pay_component_paid WHERE employee_id=? AND month_year=? AND pay_component_id=?";

	public static final String CHECK_EMP_PAYCOM_EXISTS = "SELECT * FROM employee_pay_component_paid WHERE employee_id=? AND month_year=?";

	public static final String CHECK_EMP_SALARY_FIX_EXISTS = "SELECT * FROM employee_pay_component WHERE employee_id=? AND to_char(fromdate,'MMYYYY')=?";

	public static final String DELETE_EMP_PAYCOM_EXISTS = "delete from  employee_tds_declaration WHERE employee_id=:employee_id AND financial_year_id=:financial_year_id AND tax_sub_section_code=:tax_sub_section_code";

	public static final String DELETE_EMP_PAYCOM = "delete from  employee_pay_component_paid  WHERE employee_id=:employee_id AND month_year=:month_year AND pay_component_id=:pay_component_id";

}