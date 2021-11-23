package com.dci.tenant.finance.letterRequest;

public class LetterRequestQueryUtil {

	public static String GET_EMP_ID = "select user_ref_id_emp from user_master where user_id = ? ";

	public static String LEETERREQTYPELIST = "select letter_request_type_id as letterReqTypeId,letter_request_type as letterReqTypeName,\n" + 
			"(select company_name from company_master where company_code = lrt.company_code limit 1) as companyName , \n" + 
			"company_code as companyCode ,description as descripiton  from letter_request_type lrt";

	public static String INSERT_LEETTER_TYPE = "insert into letter_request_type(letter_request_type,company_code,description,created_date) values (?,?,?,now())";

	public static String DELETE_LEETTER_TYPE = "DELETE FROM letter_request_type WHERE letter_request_type_id = ?";

	public static String SELECT_EDIT_LIST = "select letter_request_type_id as letterReqTypeId,letter_request_type as letterReqTypeName,  description as descripiton  from letter_request_type lrt where letter_request_type_id = ?";

	public static String UPDATE_LEETTER_TYPE = " update letter_request_type set letter_request_type = ? ,description = ? where letter_request_type_id = ? ";

	public static String GET_LETTER_REUEST_LIST = " SELECT letter_request_id letterReqId,(select letter_request_type from letter_request_type where letter_request_type_id = letter_request.letter_request_type::integer limit 1 )   letterReqTypeName, company_code companyCode,(select emp_name from employee_master where emp_id = letter_request.emp_id limit 1 ) employeeName , (select designation from employee_master where emp_id = letter_request.emp_id limit 1 ) designation ,emp_id employeeId, address_the_letter_to address, letter_purpose purpose, description descripiton,  hr_status hrStatus,admin_status adminStatus , approved_by ApprovedBy, approved_date ApprovedDate, to_char(request_date,'dd/mm/yyyy') requestDate, to_char(issued_date,'dd/mm/yyyy') issuedDate  FROM letter_request where emp_id = ? ";
	
	public static String GET_LETTER_REUEST_LIST1 = " SELECT letter_request_id letterReqId,(select letter_request_type from letter_request_type where letter_request_type_id = letter_request.letter_request_type::integer limit 1 )   letterReqTypeName, company_code companyCode,(select emp_name from employee_master where emp_id = letter_request.emp_id limit 1 ) employeeName , 'DS005' designation ,emp_id employeeId, address_the_letter_to address, letter_purpose purpose, description descripiton,  hr_status hrStatus,admin_status adminStatus , approved_by ApprovedBy, approved_date ApprovedDate, to_char(request_date,'dd/mm/yyyy') requestDate, to_char(issued_date,'dd/mm/yyyy') issuedDate  FROM letter_request ";
	
	public static String GET_LETTER_REUEST_LIST2 = " SELECT letter_request_id letterReqId,(select letter_request_type from letter_request_type where letter_request_type_id = letter_request.letter_request_type::integer limit 1 )   letterReqTypeName, company_code companyCode,(select emp_name from employee_master where emp_id = letter_request.emp_id limit 1 ) employeeName ,  'DS037' designation ,emp_id employeeId, address_the_letter_to address, letter_purpose purpose, description descripiton,  hr_status hrStatus,admin_status adminStatus , approved_by ApprovedBy, approved_date ApprovedDate, to_char(request_date,'dd/mm/yyyy') requestDate, to_char(issued_date,'dd/mm/yyyy') issuedDate ,'DS011' approveFlag FROM letter_request ";
	
	public static String INSERT_LETTER_REQUEST = " INSERT INTO letter_request( letter_request_type,  emp_id,  address_the_letter_to, letter_purpose,  hr_status,   request_date, create_date, created_by , admin_status)   VALUES (  ?,   ?, ?, ?, ?, now(), now(), ? , 'Pending')";
	
	public static String UPDATE_LETTER_REQUEST = " UPDATE letter_request  SET letter_request_type=?,  emp_id=?,admin_status='Pending',    address_the_letter_to=?, letter_purpose=?, hr_status=?,  modified_date=now(), modified_by=? WHERE letter_request_id=? ";

	public static String DELETE_LETTER_REQUEST = "DELETE FROM letter_request WHERE letter_request_ID = ? ";
	
	public static String EDIT_LETTER_REQUEST = " SELECT letter_request_type letterReqTypeId, (select  letter_request_type from letter_request_type where  letter_request_type_Id = letter_request.letter_request_type::int  limit 1) letterReqTypeName, company_code companyCode, emp_id employeeId, address_the_letter_to address, letter_purpose purpose, description descripiton,  hr_status hrStatus, admin_status adminStatus, approved_by ApprovedBy, approved_date ApprovedDate, request_date requestDate, to_char(issued_date,'dd/mm/yyyy') issuedDate  FROM letter_request WHERE LETTER_REQUEST_ID = ? ";

	public static String GET_LETTER_TYPE_LIST = " select letter_request_type_id as id , letter_request_type as text from letter_request_type ";

	public static String APPROVE_LETTER_REQUEST = " UPDATE letter_request  SET  hr_status='Approved',admin_status='Pending', approved_date = now(), approved_by = ? , issued_date = to_date(?,'dd/mm/yyyy') WHERE letter_request_id=? ";

	public static String ISSUE_LETTER_REQUEST = " UPDATE letter_request  SET  admin_status='Issued' WHERE letter_request_id=? ";

}