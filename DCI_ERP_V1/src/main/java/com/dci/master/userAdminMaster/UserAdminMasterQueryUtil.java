package com.dci.master.userAdminMaster;

public class UserAdminMasterQueryUtil {

	/*
	 * public static final String SELECT_EMPLOYEE_LIST =
	 * "select e.employee_id empId,e.reporting_to,e.first_name firstName, e.middle_name middleName, branch.branch_name branchName, e.surname lastName, e.gender gender, e.dob dob, e.doj doj, e.access_card_number accessCardNo, e.phone mobileNo, e.email emailId, e.photo_url uploadPhoto, e.status status, e.department_id departmentId, e.designation_id designation, e.grade_id grade, e.division_id division, e.password pwd, e.employee_type_id typeOfEmp, e.epf_no epfNo, e.esic_code esic, e.relieving_date relieveDate, e.fixed_gross fixedGross, e.donor_code donorCode, dept.department_name departmentCode, desig.designation_name designationName, et.type empTypeName, g.name gradeName, div.division_name divisionName from employee e  left join department dept on dept.department_id = e.department_id  left join designation desig on desig.designation_id = e.designation_id left join employment_type et on et.employment_type_id =e.employee_type_id left join grade g on g.grade_id = e.grade_id left join division div on div.division_id = e.division_id left join branch on dept.branch_id = branch.branch_id order by first_name ASC"
	 * ;
	 */
	

	public static String UPDATE_EMPLOYEE_USER = " UPDATE user_master SET user_name=:empname,donor_code=:donorCode, user_user_id=:empUserId,reporting_to=:reportMangrId, first_name=:firstName, middle_name=:middleName, surname=:lastName,   gender=:gender,  dt_of_birth=to_date(:dob,'dd/MM/yyyy'), email_id=:emailId, contact_no=:mobileNo, dt_of_join=to_date(:doj,'dd/MM/yyyy'), status=:status,is_email_exempted=:isEmailExempted, esic_code=:esic, fixed_gross=:fixedGross, " + " profile_img=:uploadPhoto, dept=:departmentId, designation=:designation, grade_id=:grade, "
			+ " user_type_id=:typeOfEmp," + " epf_no=:epfNo, insurance_policy_no=:insuranceNo, relieving_date=:relieveDate,user_type_date=:employmentDate,branch_department_id=:branchId,uan_no=:uan,company_code=:companyCode,vendor=:vendor,vendor_name=:customerName,port=:port,country=:country,user_location=:userLocation WHERE user_ref_id_emp=:empId ";


	public static final String SELECT_EMPLOYEE_LIST3 ="select e.user_id empId,e.reporting_to,e.first_name firstName, e.middle_name middleName, branch.brnch_nam branchName, e.surname lastName, e.gender gender, case when  e.vendor='Y' then 'Agent' when  e.vendor='N' then 'Employee' end vendor,  to_char(e.dt_of_birth,'dd/mm/yyyy') dob, to_char(e.dt_of_join,'dd/mm/yyyy') doj, e.access_card_number accessCardNo, e.contact_no mobileNo,e.email_id emailId, e.profile_img uploadPhoto, case when  e.status='Y' then 'YES' when  e.status='N' then 'NO' end status,e.user_user_id empUserId, e.dept departmentId,e.designation designation, e.grade_id grade, e.user_password pwd, e.user_type_id typeOfEmp, e.epf_no epfNo, e.esic_code esic,   e.relieving_date relieveDate, e.fixed_gross fixedGross, e.donor_code donorCode, department_master_new.dept_name departmentName, desig.desgn_name designationName, "
			+ "e.created_by as createdBy,to_char(e.created_dt,'dd/mm/yyy hh24:mi') as createdDate,e.user_location as userlocation,e.modified_by as modifiedBy,to_char(e.modified_dt,'dd/mm/yyy hh24:mi') as modifiedDate "
			+ " from user_master e "
			+ "left join designation_master desig on desig.desgn_code = e.designation "
			+ "left join branch on e.branch_department_id = branch.brnch_id ::varchar "
			+ "left join department_master_new on e.dept= department_master.dept_code "
			+ "order by empId DESC";
	public static final String SELECT_EMPLOYEE_LIST1 ="select e.user_id empId,e.reporting_to,e.first_name firstName, e.middle_name middleName, branch.brnch_nam branchName, e.surname lastName, e.gender gender, case when  e.vendor='Y' then 'Agent' when  e.vendor='N' then 'Employee' end vendor,  to_char(e.dt_of_birth,'dd/mm/yyyy') dob, to_char(e.dt_of_join,'dd/mm/yyyy') doj, e.access_card_number accessCardNo, e.contact_no mobileNo,e.email_id emailId, e.profile_img uploadPhoto, case when  e.status='Y' then 'YES' when  e.status='N' then 'NO' end status,e.user_user_id empUserId, e.dept departmentId,e.designation designation, e.grade_id grade, e.user_password pwd, e.user_type_id typeOfEmp, e.epf_no epfNo, e.esic_code esic,   e.relieving_date relieveDate, e.fixed_gross fixedGross, e.donor_code donorCode, department_master_new.dept_name departmentName, desig.desgn_name designationName, "
			+ "e.created_by as createdBy,to_char(e.created_dt,'dd/mm/yyy hh24:mi') as createdDate,e.user_location as userlocation,e.modified_by as modifiedBy,to_char(e.modified_dt,'dd/mm/yyy hh24:mi') as modifiedDate "
			+ " from user_master e "
			+ "left join designation_master_new desig on desig.desgn_code = e.designation "
			+ "left join branch on e.branch_department_id = branch.brnch_id ::varchar "
			+ "left join department_master_new on e.dept= department_master_new.dept_code "
			+ "order by empId DESC";
	public static final String SELECT_EMPLOYEE_LIST2 ="select e.user_id empId,e.reporting_to,e.first_name firstName, e.middle_name middleName, branch.brnch_nam branchName, e.surname lastName, e.gender gender, case when  e.vendor='Y' then 'Agent' when  e.vendor='N' then 'Employee' end vendor,  to_char(e.dt_of_birth,'dd/mm/yyyy') dob, to_char(e.dt_of_join,'dd/mm/yyyy') doj, e.access_card_number accessCardNo, e.contact_no mobileNo,e.email_id emailId, e.profile_img uploadPhoto, case when  e.status='Y' then 'YES' when  e.status='N' then 'NO' end status,e.user_user_id empUserId, e.dept departmentId,e.designation designation, e.grade_id grade, e.user_password pwd, e.user_type_id typeOfEmp, e.epf_no epfNo, e.esic_code esic,   e.relieving_date relieveDate, e.fixed_gross fixedGross, e.donor_code donorCode, department_master.dept_name departmentName, desig.desgn_name designationName, "
			+ "e.created_by as createdBy,to_char(e.created_dt,'dd/mm/yyy hh24:mi') as createdDate,e.user_location as userlocation,e.modified_by as modifiedBy,to_char(e.modified_dt,'dd/mm/yyy hh24:mi') as modifiedDate "
			+ " from user_master e "
			+ "left join designation_master desig on desig.desgn_code = e.designation "
			+ "left join branch on e.branch_department_id = branch.brnch_id ::VARCHAR "
			+ "left join department_master_new on e.dept= department_master_new.dept_code "
			+ "order by empId DESC";
/*	public static String INSERT_EMPLOY = "INSERT INTO user_master(emp_id,reporting_to,access_card_number,first_name, middle_name, surname, gender,dt_of_birth, dt_of_join, contact_no, email_id, profile_img, designation, grade_id, division_id, password, employee_type_id, epf_no, esic_code, fixed_gross, donor_code, status, is_email_exempted, branch_department_id,insurance_policy_no,relieving_date,employee_type_date,emp_user_id,dept,uan_no,emp_name,sa_right,created_by,created_dt,company_code,login_flag,vendor_name,vendor,port)"
			+ " VALUES (:empId,:reportMangrId,:accessCardNo,:firstName,:middleName,:lastName,:gender,:dob,:doj,:mobileNo,:emailId,:uploadPhoto,:designation,:grade,:division,:pwd,:typeOfEmp,:epfNo,:esic,:fixedGross,:donorCode,:status,:isEmailExempted,:branchId, :insuranceNo, :relieveDate,:employmentDate,:empUserId,:departmentId,:uan,:empname,:saright,:createdBy,now(),:companyCode,:loginFlag,:customerName,:vendor,:port)";
	
	*/
	public static String INSERT_USER =  "INSERT INTO user_master(user_id,reporting_to,access_card_number,first_name, middle_name, surname, gender,dt_of_birth, dt_of_join, contact_no, email_id, profile_img, designation, grade_id, division_id, user_password, user_type_id, epf_no, esic_code, fixed_gross, donor_code, status, is_email_exempted, branch_department_id,insurance_policy_no,relieving_date,user_type_date,user_user_id,dept,uan_no,user_name,sa_right,created_by,created_dt,company_code,user_ref_flag,vendor_name,vendor,port,country,user_location,access_category,is_department_contact) VALUES (:empId,:reportMangrId,:accessCardNo,:firstName,:middleName,:lastName,:gender,:dob,:doj,:mobileNo,:emailId,:uploadPhoto,:designation,:grade,:division,:pwd,:typeOfEmp,:epfNo,:esic,:fixedGross,:donorCode,:status,:isEmailExempted,:branchId, :insuranceNo, :relieveDate,:employmentDate,:empUserId,:departmentId,:uan,:empname,:saright,:createdBy,now(),:companyCode,:loginFlag,:customerName,:vendor,:port,:country,:userlocation,:accessCat,:deptContact)";
	
	public static String INSERT_COMPANY_USER = " INSERT INTO company_user (company_code, user_id, is_primary) VALUES (?, ?, ?) returning company_user_id ";

	public static String INSERT_USER_RIGHTS = " insert into user_rights(company_user_id,form_property_id) values (?, ?) ";

	/*
	 * " insert into user_rights(company_user_id,form_property_id) " +
	 * " select ? as company_user_id, form_property_id from designation_rights  where designation_id=? "
	 * ;
	 */

	public static String SELECT_DESIGNATION_RIGHTS = " select ? as companyUserId, form_property_id formPropertyId from designation_rights  where designation_id=? ";

	/*
	 * " INSERT INTO company_user (company_code, user_id, is_primary) VALUES (:companyCode, :empId, :isPrimary) returning company_user_id "
	 * ;
	 */

	/*
	 * " INSERT INTO company_user (company_code, user_id, is_primary) VALUES (:companyCode, :empId, :isPrimary) "
	 * ;
	 */

	

	// public static String INSERT_ADDRESS_INF =
	// "INSERT INTO employee_address(employee_id, permanent_address, permanent_place, permanent_district,permanent_state, permanent_pincode, permanent_phoneno, permanent_mobileno) VALUES (:empId, :permAddress,:permPlace,:permDistrict,:permState,:permPin,:permPhone, :permMobile)";

	
	

	

	

	

	

	

	
	public static String SELECT_EMPLOYEE_BY_ID ="select e.access_category as accesscodes,e.country as country,e.user_id empId,e.port as portCodes,e.vendor as vendor,e.vendor_name as customerName,e.company_code as companyCode,e.first_name firstName, e.middle_name middleName, e.branch_department_id branchId, e.surname lastName,  e.dt_of_birth dob,e.dt_of_join doj,e.contact_no mobileNo,e.email_id emailId,e.status status, e.dept departmentId,e.designation designation,e.user_password pwd,company_name as companyName,department_master_new.dept_name as departmentCode,desig.desgn_name as designationName,e.vendor_name ,concat(aa.srvc_prtnr_cd,' - ',srvc_prtnr_nam) as agentName,cc.country_name as countryName, " +
" branch.brnch_nam as branchName, e.gender gender,case when e.gender ='M' then 'Male' when e.gender ='F' then 'Female' end as genderName ,e.user_location as  userlocation," +
" case when e.status='Y' then 'YES' when e.status='N' then 'NO' end as active,case when e.vendor ='Y' then 'Yes' else 'No' end as vendorShow , " +
" emc.user_name as createdBy,to_char(e.created_dt,'dd/mm/yyy hh24:mi') as createdDate,emm.user_name  AS modifiedBy " +
" ,to_char(e.modified_dt,'dd/mm/yyy hh24:mi') as modifiedDate,e.is_department_contact as deptContact from user_master e " +
" left join designation_master_new desig on desig.desgn_code = e.designation " +
" left join branch on e.branch_department_id = branch.brnch_id::varchar " +
" left join department_master_new on e.dept= department_master_new.dept_code  " +
" left join vendor_master_new aa on aa.srvc_prtnr_bin::varchar=vendor_name " +
" left join country_master cc on cc.country_code=e.country " +
" left join company_master cm on cm.company_code= e.company_code " +
" left join user_master emc on emc.user_id = e.CREATED_BY left join user_master emm on emm.user_id = e.MODIFIED_BY where e.user_id =?";

	

	

	

	

	

	public static final String CHECK_COUNT_EMP_UPDATE = "select count(*) from employee where employee_id<>? and first_name=?";

	public static final String CHECK_FOR_EMPID = "select count(*) from employee_personalinfo where employee_id=?";

	public static final String CHECK_FOR_ADDRESS_EMPID = "select count(*) from employee_address where employee_id=?";

	public static final String CHECK_FOR_FAMILY_EMPID = "select count(*) from employee_family where employee_id=?";

	public static final String CHECK_FOR_EDU_EMPID = "select count(*) from employee_education where employee_id=?";

	public static final String CHECK_FOR_EXP_EMPID = "select count(*) from employee_experiance where employee_id=?";

	public static final String CHECK_FOR_NOMINEE_EMPID = "select count(*) from employee_nominee where employee_id=?";

	public static final String CHECK_FOR_MERIT_EMPID = "select count(*) from employee_merits where employee_id=?";

	public static final String CHECK_FOR_EMER_EMPID = "select count(*) from employee_emergency_contact where employee_id=?";

	public static final String CHECK_FOR_REF_EMPID = "select count(*) from employee_references where employee_id=?";

	public static final String CHECK_FOR_MASTER_DOCUMENT_EMPID = "select count(*) from employee_master_documents where empid=?";

	public static final String CHECK_FOR_DOC_EMPID = "select count(*) from employee_documents where employee_id=?";

	public static final String CHECK_FOR_PHY_EMPID = "select count(*) from employee_physical where employee_id=?";

	public static final String CHECK_FOR_RULE_EMPID = "select count(*) from employee_rule where employee_id=?";

	

	public static String UPDATE_EMPLOYEE = " UPDATE user_master SET user_name=:empname,donor_code=:donorCode, user_user_id=:empUserId,reporting_to=:reportMangrId, first_name=:firstName, middle_name=:middleName, surname=:lastName,  gender=:gender,  dt_of_birth=:dob, email_id=:emailId, contact_no=:mobileNo, dt_of_join=:doj, status=:status,is_email_exempted=:isEmailExempted, esic_code=:esic, fixed_gross=:fixedGross, " + " profile_img=:uploadPhoto, dept=:departmentId, designation=:designation, grade_id=:grade, "
			+ " user_type_id=:typeOfEmp," + " epf_no=:epfNo, insurance_policy_no=:insuranceNo, relieving_date=:relieveDate,user_type_date=:employmentDate,branch_department_id=:branchId,uan_no=:uan,company_code=:companyCode,vendor=:vendor,vendor_name=:customerName,port=:port,country=:country,user_location=:userlocation,modified_by=:modifiedBy,modified_dt=now(),access_category=:accessCat,is_department_contact=:deptContact  WHERE user_id=:empId ";

	public static String UPDATE_PERSONAL_INFO = "UPDATE employee_personalinfo SET employee_id=:empId, marital_status=:marritalStatus, " + "fa_hus_guardian_name=:guardianName," + " blood_group=:bloodGrp, caste=:caste," + " religion=:religion, mother_tongue=:motherTongue, nationality=:nationality, " + "pan_no=:panNo, gratuity_nominee=:gratuityNominee, gratuity_nominee_relation=:nomineeRelation, " + "mode_of_conveyence=:modeConveyence,"
			+ " hobbies=:hobbies,notice_period_tobe_served=:noticePeriod ,emergency_contact_name=:emgContactName ,emergency_contact_no=:emgContactNo, conformation_date=to_date(:confirmDate,'dd/MM/yyyy'), " + " resignation_date=to_date(:resignationDate,'dd/MM/yyyy'), " + " languages_known=:languages, remarks=:remarks," + "confirmation_period=:confirmationPeriod,aadhar_no=:aadharno, husband_wife_name=:husbWifeName " + " WHERE employee_id=:empId ";

	// public static String UPDATE_ADDRESS_INFO =
	// "UPDATE employee_address SET employee_id=:empId, permanent_address=:permAddress, "
	// +
	// " permanent_place=:permPlace,permanent_district=:permDistrict, permanent_state=:permState,"
	// +
	// " permanent_pincode=:permPin, permanent_phoneno=:permPhone, permanent_mobileno=:permMobile "
	// + " WHERE employee_id=:empId ";

	public static String UPDATE_ADDRESS_INFO = "UPDATE employee_address SET employee_id=:empId, permanent_address=:permAddress, " + " permanent_place=:permPlace,permanent_district=:permDistrict, " + " permanent_pincode=:permPin, permanent_phoneno=:permPhone, permanent_mobileno=:permMobile, " + " present_address=:presentAddress, present_place=:presentPlace, present_district=:presentDistrict, " + " present_pincode=:presentPin, present_phoneno=:presentPhone, " + " present_mobileno=:presentMobile " + " WHERE employee_id=:empId ";

	public static String UPDATE_FAMILY_INFO = "UPDATE employee_family SET employee_id=:empId, relative_name=:familyName, " + " sex=:genderType,relation_to_employee=:relationshipWithEmp, " + " dependent_on_employee=:empDependence " + " WHERE employee_id=:empId ";

	public static String UPDATE_EDU_INFO = "UPDATE employee_education SET employee_id=:empId, qualification=:qualification," + " percentage=:percentage,cource_type=:courseType, " + " institution=:institution, year_of_passing=:yearPassed " + " WHERE employee_id=:empId";

	public static String UPDATE_EXP_INFO = "UPDATE employee_experiance SET employee_id=:empId, organization_name=:organization, " + " year_of_experiance=:experienceYear,designation=:expDesisnation, " + " remarks=:expRemarks " + " WHERE employee_id=:empId ";

	public static String UPDATE_NOMINEE_INFO = "UPDATE employee_nominee SET employee_id=:empId, employee_nominee_name=:nominateName, " + "sex=:nominateGender,occupation=:nominateOccupation, relationship=:nominateRelationship, email=:nominateEmail, " + "phone_no=:nominatePhone, mobile_no=:nominateMobile, dob=to_date(:nomdateOfBirth,'dd/MM/yyyy'), address=:nomineAddress, pincode=:nominatePincode, " + "place=:nominatePlace , phone_no=:emergPhone, mobile_no=:emergMobile" + "WHERE employee_id=:empId";

	public static String UPDATE_MERIT_INFO = "UPDATE employee_merits SET employee_id=:empId, award_name=:awardName, " + " scholarship_name=:scholarshipName,description=:meritDesc " + " WHERE employee_id=:empId ";

	public static String UPDATE_EMER_INFO = "UPDATE employee_emergency_contact SET employee_id=:empId, emergency_contact_name=:emergencyName, " + " occupation=:emergencyOccu,relationship=:emergRelationship, email=:emergEmail,phone_no=:emergPhone, " + " mobile_no=:emergMobile,place=:emergPlace, address=:emerAddress,pincode=:emergencyPincode " + " WHERE employee_id=:empId ";

	public static String UPDATE_REFERENCE_INFO = "UPDATE employee_references SET employee_id=:empId, employee_reference_name=:referenceName, " + " occupation=:occupationRef,email=:emailRef, relationship=:relationshipRef,phone_no=:emergPhone, " + " pincode=:pincodeRef,address=:referenceAddress " + " WHERE employee_id=:empId";

	public static String UPDATE_DOCUMENT_INFO = "UPDATE employee_documents SET bank_account_no=:accountNo, " + " bank_name=:bankName, bank_place=:bankPlace, passport_no=:passportNo, passport_issued_date=:issuedDate, " + " passport_expiry_date=:expiryDate,passport_issued_place=:issuedPlace, driving_license_no=:licenseNo, " + " license_type=:licenseType, license_issued_date=:licenseIssuedDate, license_expiry_date=:licenseexpiryDate, " + " license_renewal_date=:renewalDate, attachment=:joinDocUpload, visa_reference_number=:visaRefNo, "
			+ " visa_type=:visaType, visa_issued_place=:visaIssuedPlace, visa_expiration_date=:visaExpiryDate, visa_issued_date=:visaIssuedDate, iscash=:isActiveCash " + " WHERE employee_id=:empId ";

	public static String UPDATE_PHYSICAL_INFO = "UPDATE employee_physical SET physically_handicaped_eye=:isActiveSight, " + " physically_handicaped_dumb=:isActiveDumb, physically_handicaped_hearing=:isActiveHearing, " + " physically_handicaped_hand=:isActiveHand,physically_handicaped_feet=:isActiveFeet, " + "height=:height,weight=:weight, left_eye_sight_power=:LeftSidePower,right_eye_sight_power=:RightSidePower " + " WHERE employee_id=:empId ";

	public static String INSERT_ON_UPDATE_PERSONAL_INF = "INSERT INTO employee_personalinfo(marital_status,fa_hus_guardian_name,blood_group,caste," + " religion, mother_tongue, nationality, pan_no, gratuity_nominee, gratuity_nominee_relation," + " mode_of_conveyence, emergency_contact_no, emergency_contact_name,notice_period_tobe_served, " + " remarks, hobbies, conformation_date, resignation_date, employee_id, languages_known, " + "confirmation_period, husband_wife_name,aadhar_no) VALUES (:marritalStatus,:guardianName,"
			+ " :bloodGrp,:caste,:religion,:motherTongue, :nationality,:panNo,:gratuityNominee,:nomineeRelation, " + " :modeConveyence,:emgContactNo, :emgContactName,:noticePeriod,:remarks,:hobbies, " + " to_date(:confirmDate,'dd/mm/yyyy'), to_date(:resignationDate,'dd/mm/yyyy'),:empId,:languages,:confirmationPeriod,:husbWifeName,:aadharno)";

	// public static String INSERT_ON_UPDATE_ADDRESS_INF =
	// "INSERT INTO employee_address(employee_id, permanent_address, permanent_place, permanent_district,permanent_state,"
	// +
	// " permanent_pincode, permanent_phoneno, permanent_mobileno) VALUES (:empId, "
	// +
	// " :permAddress,:permPlace,:permDistrict,:permState,:permPin,:permPhone, :permMobile) ";

	public static String INSERT_ON_UPDATE_ADDRESS_INF = "INSERT INTO employee_address(employee_id, permanent_address, permanent_place, permanent_district," + " permanent_pincode, permanent_phoneno, permanent_mobileno,present_address,present_place, " + " present_district, present_pincode, present_phoneno, present_mobileno) VALUES (:empId, " + " :permAddress,:permPlace,:permDistrict,:permPin,:permPhone, :permMobile, :presentAddress," + " :presentPlace,:presentDistrict,:presentPin, :presentPhone,:presentMobile) ";

	public static String INSERT_ON_UPDATE_FAMILY_INF = " INSERT INTO employee_family(employee_id, relative_name, sex, relation_to_employee, " + " dependent_on_employee) VALUES (:empId, :familyName, :genderType,:relationshipWithEmp, " + " :empDependence)";

	public static String INSERT_ON_UPDATE_EDU_INF = "INSERT INTO employee_education(employee_id, qualification, percentage, cource_type, " + " institution, year_of_passing) VALUES (:empId, :qualification, :percentage,:courseType, " + " :institution, :yearPassed)";

	public static String INSERT_ON_UPDATE_EXP_INF = "INSERT INTO employee_experiance(employee_id, organization_name, year_of_experiance,designation, " + " remarks) VALUES (:empId, :organization, :experienceYear, :expDesisnation, :expRemarks)";

	public static String INSERT_ON_UPDATE_NOMINEE_INF = "INSERT INTO employee_nominee(employee_id, employee_nominee_name, sex,occupation, relationship, " + " email, phone_no, mobile_no, dob, address, pincode, place,phone_no,mobile_no) VALUES (:empId, :nominateName, " + " :nominateGender, :nominateOccupation, :nominateRelationship, :nominateEmail, :nominatePhone, " + " :nominateMobile, :nomdateOfBirth, :nomineAddress, :nominatePincode, :nominatePlace,:emergPhone,:emergMobile)	";

	public static String INSERT_ON_UPDATE_MERIT_INF = "INSERT INTO employee_merits(employee_id, award_name, scholarship_name, description) VALUES " + " (:empId, :awardName, :scholarshipName, :meritDesc)";

	public static String INSERT_ON_UPDATE_EMER_INF = "INSERT INTO employee_emergency_contact(employee_id, emergency_contact_name, occupation," + "relationship, email, phone_no, mobile_no, place, address, pincode,mobile_no,phone_no) VALUES (:empId, " + ":emergencyName, :emergencyOccu,:emergRelationship, :emergEmail, :emergPhone, :emergMobile, " + ":emergPlace, :emerAddress, :emergencyPincode,:emergMobile,:emergPhone)	";

	public static String INSERT_ON_UPDATE_REF_INF = " INSERT INTO employee_references(employee_id, employee_reference_name, occupation, email, " + " relationship, phone_no, pincode, address) VALUES (:empId, :referenceName, :occupationRef, " + " :emailRef, :relationshipRef, :emergPhone, :pincodeRef,:referenceAddress)	";

	public static String INSERT_ON_UPDATE_DOC_INF = "INSERT INTO employee_documents(employee_id, bank_account_no, bank_name, bank_place, passport_no, passport_issued_date, passport_expiry_date, passport_issued_place, driving_license_no, license_type, license_issued_date, license_expiry_date, license_renewal_date, attachment, visa_reference_number, visa_type,visa_issued_place, visa_issued_date, visa_expiration_date, iscash) VALUES (:empId, :accountNo, :bankName, :bankPlace, :passportNo, :issuedDate , :expiryDate, :issuedPlace, :licenseNo, :licenseType, :licenseIssuedDate,:licenseexpiryDate, :renewalDate, :joinDocUpload, :visaRefNo, :visaType, :visaIssuedPlace, :visaIssuedDate, :visaExpiryDate, :isActiveCash)";

	public static String INSERT_ON_UPDATE_PHY_INF = "INSERT INTO employee_physical(employee_id, physically_handicaped_eye, physically_handicaped_dumb, " + " physically_handicaped_hearing, physically_handicaped_hand, physically_handicaped_feet, height, " + " weight,left_eye_sight_power,right_eye_sight_power) VALUES (:empId, :isActiveSight, :isActiveDumb,:isActiveHearing, :isActiveHand, " + " :isActiveFeet, :height, :weight,:LeftSidePower , :RightSidePower)";

	

	

	public static String DELETE_EMPLOYEE_RULE = "Delete from employee_rule where employee_id=?";

	public static String DELETE_EMPLOYEE_PHY = "Delete from employee_physical where employee_id=?";

	public static String DELETE_EMPLOYEE_DOC = "Delete from employee_documents where employee_id=?";

	public static String DELETE_EMPLOYEE_REF = "Delete from employee_references where employee_id=?";

	public static String DELETE_EMPLOYEE_EMERG = "Delete from employee_emergency_contact where employee_id=?";

	public static String DELETE_EMPLOYEE_MERIT = "Delete from employee_merits where employee_id=?";

	public static String DELETE_EMPLOYEE_NOMINEE = "Delete from employee_nominee where employee_id=?";

	public static String DELETE_EMPLOYEE_EXP = "Delete from employee_experiance where employee_id=?";

	public static String DELETE_EMPLOYEE_EDU = "Delete from employee_education where employee_id=?";

	public static String DELETE_EMPLOYEE_FAMILY = "Delete from employee_family where employee_id=?";

	public static String DELETE_EMPLOYEE_ADDRESS = "Delete from employee_address where employee_id=?";

	public static String DELETE_EMPLOYEE_PERSONAL = "Delete from employee_personalinfo where employee_id=?";

	public static String DELETE_EMPLOYEE_EMPLOYEE = "Delete from employee_master where emp_id=?";

	public static String DELETE_EMPLOYEE_DOCUMETNS = "Delete from employee_master_documents where empid=?";

	public static String sGetDepartmentDropDown = "select department_id, department_name from department";

	// public static String SELECT_COMPANY_LIST =
	// "select company_id as id,company_name as text,company_id companyCode,company_name companyName from company order by company_name ASC";

	public static String SELECT_COMPANY_LIST = "  select company_code as id,concat(company_code,'-',company_name) companyName, concat(company_code,'-',company_name) as text,concat(company_code,'-',company_name) as companyCode  from company_master";

	public static String SELECT_BRANCH_LIST = "select brnch_id as id,brnch_nam as text,brnch_id branch,brnch_nam branchName from branch";
	// department

	public static String SELECT_DEPARTMENT_LIST = " select dept_name departmentCode,dept_code as id,concat(dept_code,'-',dept_name) as text FROM department_master_new d  WHERE d.dept_status='Y'  order by dept_name ASC ";

	public static String SELECT_DESIGNATION_LIST = " select desgn_code as id,concat(desgn_code,'-',desgn_name) as text,desgn_name designationName from designation_master_new  order by id asc";


	public static String SELECT_GRADE_LIST = "select grade_id as id,name as text,grade_id grade,name gradeName from grade where status=true  order by name ASC";

	public static String SELECT_REPORT_BRANCH_LIST = "select branch_id as id,branch_name as text,branch_id reportToBranch,branch_name reportToBranchName from branch order by branch_name ASC";

	

	public static String SELECT_REORT_DESIG_LIST = "select des.desgn_code reportDesigId,des.desgn_code as id,des.desgn_name reportToDesig,des.desgn_name as text from designation_master des inner join employee_master e on des.desgn_id=e.designation where e.emp_id=? order by desgn_name ASC";
	public static String SELECT_EMP_TYPE_LIST = "select employment_type_id as id,type as text  from employment_type";
	// public static String SELECT_EMP_TYPE_LIST =
	// "select concat(first_name,' ',surname) as empName, concat(first_name,' ',surname) as text , employee_id as empId , employee_id as id from employee join branch_department on employee.branch_department_id=branch_department.branch_department_id inner join branch on branch.branch_id = branch_department.branch_id inner join company c on c.company_id = branch.company_id where  employee.status = true and c.company_id = ?";
	public static String SELECT_REPORT_MANAGER_LIST = "select emp_id reportMangrId,concat(emp_id,' - ',first_name,' ',surname) reportManagerName from employee_master em  inner join branch_department bd on bd.branch_department_id = em.branch_department_id  inner join branch b on b.branch_id=bd.branch_id::int where designation ='DS012' and   b.branch_id =?";

	

	

	public static String SELET_EMP_DOC_ID = "SELECT empid empId, document_name docName, description description, img_url uploadDoc, emp_doc_id empDocId FROM employee_master_documents where emp_doc_id=?;";

	public static String INSERT_DOCUMENT = "INSERT INTO employee_master_documents(empid, document_name, description, img_url)VALUES (:empId, :docName, :description,:uploadDoc)";

	public static String SELET_EMP_EXP = "SELECT contactname,contactno,employee_id empId,emp_exp_id empExpId, organization_name organization, year_of_experiance experienceYear, designation expDesisnation, remarks expRemarks, to_char(experiance_from,'dd/mm/yyyy') exFrom,to_char(experiance_to,'dd/mm/yyyy') exTo FROM employee_experiance WHERE employee_id=?";

	

	public static String SELECT_PHONE_NO = "SELECT phone_no as presentPhoneNo FROM employee_phone_no where present_address_id=?";

	public static String SELECT_PRESENT_ADDRESS = "SELECT present_address_id, present_address as presentAddress, present_place as presentPlace, present_district as presentDistrict,present_state as presentState," + " present_pincode as presentPin FROM employee_present_address where employee_id=? ";

	

	

	

	// public static String SELECT_EMPLOYEE_NAME_LIST =
	// "select employee_id as id,first_name as text,employee_id empId,first_name firstName from employee order by first_name ASC";

	

	public static String userIdAutoGen = " SELECT CASE WHEN MAX(employee_id) IS NULL THEN 'E0001' ELSE rpad(MAX(employee_id),1,'E')|| lpad(cast(cast((SUBSTRING(MAX(employee_id),4)) as int)+1 as text),4,'0') END FROM employee ";

	// public static String GET_MAX_EMPLOYEE_ID =
	// "select CASE WHEN max(empid) is null then 0 else max(empid) end maxEmpId from( "
	// +
	// "select cast((substr(employee_id, 2, char_length(employee_id))) as int ) empid from employee) temp";

	public static String GET_MAX_EMPLOYEE_ID = "SELECT CASE WHEN MAX(user_id) IS NULL  THEN 'E0001' ELSE rpad(MAX(user_id),1,'E')|| lpad(cast(cast((SUBSTRING(MAX(user_id),3)) as int)+1  as text),4,'0') END FROM user_master";
	public static String SELECT_MOBILE_NO = "SELECT mobile_no as presentMobileNo FROM employee_mobile_no where present_address_id = ?";

	public static String DELETE_PRESENT_ADDRESS = "DELETE FROM employee_present_address WHERE employee_id=?";

	public static String DELETE_MOBILE_NO = "DELETE FROM employee_mobile_no  WHERE employee_id=?";

	public static String DELETE_PHONE_NO = "DELETE FROM employee_phone_no  WHERE employee_id=?";

	public static String SELET_EMP_EDU = "SELECT specialization specialization, employee_id empId,emp_edu_id empEduId,qualification qualification, percentage percentage, cource_type courseType, institution institution,year_of_passing yearPassed  FROM employee_education where employee_id=?";

	public static String SELET_EMP_MERITS = "SELECT employee_id empId, employee_merits_id empMeritId, award_name awardName, scholarship_name scholarshipName, description meritDesc FROM employee_merits where employee_id=?";

	// public static String SELET_EMP_FAMILY =
	// "SELECT employee_id empId,emp_family_id empFamilyId, relative_name familyName,sex genderType, relation_to_employee relationshipWithEmp, dependent_on_employee empDependence,img_url uploadPhotoFamily FROM employee_family where employee_id=? ";

	public static final String SELECT_EMP_FAMILY = "SELECT aadhar_no aadharno,mobile_no mobileno,employee_id employeeId,dependent_id dependentId,dependent_dob dependentDob,age,sex,relative_name relativeName,relation_to_employee relationToEmployee,dependent_on_employee dependentOnEmployee,dependent_passport_no dependentPassportNo,dependent_passport_issued_date dependentPassportIssuedDate,dependent_passport_expiry_date dependentPassportExpiryDate,dependent_passport_issued_place dependentPassportIssuedPlace,dependent_visa_reference_number dependentVisaReferenceNumber,dependent_visa_type dependentVisaType,dependent_visa_issued_place dependentVisaIssuedPlace,dependent_visa_issued_date dependentVisaIssuedDate,dependent_visa_expiration_date dependentVisaExpirationDate,dependent_photo_url dependentPhotoUrl,dependent_medical_entitlement dependentMedicalEntitlement FROM employee_family WHERE employee_id=?";

	public static String SELET_EMP_NOMINATION = "SELECT aadhar_no aadharno, employee_id EmpId,employee_nom_id employeeNomId,employee_nominee_name nominateName, sex nominateGender, occupation nominateOccupation," + " relationship nominateRelationship,email nominateEmail, to_char(dob,'dd/mm/yyyy') nomdateOfBirth, address nomineAddress, pincode nominatePincode, " + "place nominatePlace, phone_no emergPhone, mobile_no emergMobile  FROM employee_nominee where employee_id=?";

	

	public static String SELET_EMP_EMERGENCY = "SELECT employee_id EmpId,empl_emer_id emplEmerId, emergency_contact_name emergencyName, occupation emergencyOccu, relationship emergRelationship, " + "email emergEmail,place emergPlace, address emerAddress, pincode emergencyPincode,phone_no emergPhone, mobile_no emergMobile FROM employee_emergency_contact where employee_id=?";

	public static String SELET_EMP_AWARD_ID = "SELECT employee_id empId, employee_merits_id empMeritId, award_name awardName, scholarship_name scholarshipName, description meritDesc FROM employee_merits where employee_merits_id=?";

	// public static String SELET_EMP_FAMILY_ID =
	// "SELECT employee_id empId,emp_family_id empFamilyId, relative_name familyName,case sex when true then 'Male' else 'Female' end genderType, relation_to_employee relationshipWithEmp, dependent_on_employee empDependence,img_url uploadPhotoFamily FROM employee_family where emp_family_id=? ";

	

	

	public static String SELET_EMP_EDU_ID = "SELECT specialization specialization,employee_id empId,emp_edu_id empEduId,qualification qualification, percentage percentage, cource_type courseType, institution institution,year_of_passing yearPassed  FROM employee_education where emp_edu_id=?";

	

	// public static String UPDATE_EMP_FAMILY =
	// "UPDATE employee_family  SET relative_name=?,sex=?, relation_to_employee=?, dependent_on_employee=?, img_url=? WHERE emp_family_id=? ";

	

	

	public static String UPDATE_EMP_MERITS = "UPDATE employee_merits SET award_name=?,scholarship_name=?, description=? WHERE employee_merits_id=? ";

	public static String SELET_EMP_REF_ID = "SELECT employee_id empId,emp_ref_id empRefId, employee_reference_name referenceName, occupation occupationRef," + " email emailRef, relationship relationshipRef,pincode pincodeRef, address referenceAddress,phone_no emergPhone FROM employee_references where employee_id=?";

	public static String SELET_EMP_Phone_No = "SELECT empid empId,emp_ref_ph_id empRefId, phone_no emergPhone FROM employee_ref_phoneno where emp_ref_ph_id=?";

	public static String SELET_EMP_NOM_MOB_No = "SELECT employee_id empId,nomination_mobile_id employeeNomId,mobile_no emergMobile FROM employee_nomination_mobile where nomination_mobile_id=?";

	public static String SELET_EMP_NOM_PH_No = "SELECT employee_id empId,nomination_phone_id employeeNomId,phone_no emergPhone FROM employee_nomination_phone where nomination_phone_id=?";

	public static String SELET_EMP_EME_Phone = "SELECT employee_id empId,emer_phone_id emplEmerId, phone_no emergPhone FROM employee_emergency_phone where emer_phone_id=?";

	public static String SELET_EMP_EME_MOBILE = "SELECT employee_id empId,emer_mobile_id emplEmerId,mobile_no emergMobile FROM employee_emergency_mobile where emer_mobile_id=?";

	public static String DELETE_PHONE_REF = "DELETE FROM employee_ref_phoneno WHERE emp_ref_ph_id=?";

	

	public static String INSERT_REF_PHONE_NO = "INSERT INTO employee_ref_phoneno (empid,emp_ref_ph_id,phone_no) VALUES (?,?,?)";

	public static String DELETE_PHONE_EME = "DELETE FROM employee_emergency_phone WHERE emer_phone_id=?";

	public static String DELETE_MOBILE_EME = "DELETE FROM employee_emergency_mobile WHERE emer_mobile_id=?";

	public static String DELETE_PHONE_NOM = "DELETE FROM employee_nomination_phone WHERE nomination_phone_id=?";

	public static String DELETE_MOBILE_NOM = "DELETE FROM employee_nomination_mobile WHERE nomination_mobile_id=?";

	

	

	public static String INSERT_EMER_MOBILE_NO = "INSERT INTO employee_emergency_mobile(employee_id,emer_mobile_id, mobile_no)VALUES (?,?,?)";

	public static String INSERT_EMER_PHONE_NO = "INSERT INTO employee_emergency_phone(employee_id,emer_phone_id, phone_no) VALUES (?,?,?)";

	public static String INSERT_NOM_MOBILE_NO = "INSERT INTO employee_nomination_mobile(employee_id,nomination_mobile_id,mobile_no) VALUES (?,?,?)";

	public static String INSERT_NOM_PHONE_NO = "INSERT INTO employee_nomination_phone(employee_id, nomination_phone_id,phone_no) VALUES (?,?,?)";

	public static String SELECT_FAMILY_BY_ID = "SELECT employee_id employeeId,dependent_id dependentId,dependent_dob dependentDob,age,sex,relative_name relativeName,relation_to_employee relationToEmployee,dependent_on_employee dependentOnEmployee,dependent_passport_no dependentPassportNo,dependent_passport_issued_date dependentPassportIssuedDate,dependent_passport_expiry_date dependentPassportExpiryDate,dependent_passport_issued_place dependentPassportIssuedPlace,dependent_visa_reference_number dependentVisaReferenceNumber,dependent_visa_type dependentVisaType,dependent_visa_issued_place dependentVisaIssuedPlace,dependent_visa_issued_date dependentVisaIssuedDate,dependent_visa_expiration_date dependentVisaExpirationDate,dependent_photo_url dependentPhotoUrl,dependent_medical_entitlement dependentMedicalEntitlement FROM employee_family WHERE employee_id=?";

	public static String SELECT_EDUCATION_BY_ID = "SELECT employee_id empId,emp_edu_id empEduId, qualification qualification, percentage percentage, cource_type courseType, institution institution,year_of_passing yearPassed  FROM employee_education where employee_id=?";

	public static String SELECT_EXPERIENCE_BY_ID = "SELECT employee_id empId, organization_name organization, year_of_experiance experienceYear, designation expDesisnation, remarks expRemarks, to_char(experiance_from,'dd/mm/yyyy') exFrom,to_char(experiance_to,'dd/mm/yyyy') exTo FROM employee_experiance WHERE employee_id=?";

	public static String SELECT_MERITS_BY_ID = "SELECT employee_id empId, employee_merits_id empMeritId, award_name awardName, scholarship_name scholarshipName, description meritDesc FROM employee_merits where employee_id=?";

	public static String DELETE_NOMINATION = "DELETE FROM employee_nominee WHERE employee_nom_id=?";

	public static String DELETE_EMERGENCY = "DELETE FROM employee_emergency_contact WHERE empl_emer_id=?";

	public static String DELETE_REFERENCE = "DELETE FROM employee_references WHERE emp_ref_id=?";

	public static String DELETE_EDUCATION = "DELETE FROM employee_education WHERE emp_edu_id=?";

	public static final String DELETE_FAMILY = "DELETE FROM employee_family WHERE dependent_id=?";

	public static final String INSERT_EMPLOYEE_DUPLICATE_SUBDATA = "insert into employee_duplicate(employee_id,employee_date,column_name,old_value,new_value,comments) values(:empId,:employmentDate,:columnName,:oldValue,:newValue,:comments)";

	public static final String SELET_EMP_DUPLICATE_ID = "select e.emp_id as employeeId,e.first_name as employeeName,TO_CHAR(ep.employee_date,'dd/mm/yyyy') as employmentDate,ep.column_name as columnName,ep.old_value as oldValue,ep.new_value as newValue,ep.comments from employee_duplicate ep left join employee_master e on e.emp_id = ep.employee_id where ep.employee_id = ? order by ep.employee_date desc";

	public static final String DELETE_EMPLOYEE_DUPLICATE = "Delete from employee_duplicate where employee_id=?";

	public static final String sCheckESICNo = "SELECT count(*) FROM employee_master WHERE LOWER(esic_code)=LOWER(?)";

	public static String DELETE_MERIT = "DELETE FROM employee_merits WHERE employee_merits_id=?";

	public static String DELETE_EXPERIENCE = "DELETE FROM employee_experiance WHERE emp_exp_id=?";

	public static String SELET_EMP_DOC = "SELECT empid empId, document_name docName, description description, img_url uploadDoc, emp_doc_id empDocId FROM employee_master_documents where empid=?";

	public static String UPDATE_EMP_DOC = "UPDATE employee_master_documents SET document_name=?, description=?, img_url=? WHERE emp_doc_id=?";

	public static String DELETE_DOC = "DELETE FROM employee_master_documents WHERE emp_doc_id=?";

	

	public static String SELET_EMP_PERSONAL_ID = "SELECT  marital_status marritalStatus, coalesce(fa_hus_guardian_name,'') guardianName, coalesce(blood_group,0) bloodGrp,coalesce(caste,'') caste,coalesce(religion,'') religion," + "coalesce(mother_tongue,'') motherTongue,coalesce(nationality,'') nationality,coalesce(pan_no,'') panNo,coalesce(aadhar_no,'') aadharno, coalesce(gratuity_nominee,'') gratuityNominee, coalesce(gratuity_nominee_relation,'') nomineeRelation,"
			+ "coalesce(mode_of_conveyence,'') modeConveyence, coalesce(emergency_contact_no,'') emgContactNo, coalesce(emergency_contact_name,'') emgContactName," + "coalesce(notice_period_tobe_served,0) noticePeriod, remarks remarks, hobbies hobbies, status personalStatus,  to_char(conformation_date,'dd/mm/yyyy') confirmDate," + "to_char(resignation_date,'dd/mm/yyyy') resignationDate, employee_id empId, languages_known languages,coalesce(confirmation_period,0) confirmationPeriod," + "marriage_date marriageDate, husband_wife_name husbWifeName"
			+ " FROM employee_personalinfo where employee_id = ?";

	public static String SELET_EMP_RULE_ID = "SELECT employee_id empId, overtime_applicable overTime, esi_applicable esiApp, late_applicable lateApp," + "telephone_limit telephoneLimit, pf_applicable pfApp,medical_limit medicalLimit," + "is_encashable leaveOption,early_exit_applicable earlyExit  FROM employee_rule where employee_id=?";

	public static String SELET_EMP_PER_DETAIL_ID = "SELECT employee_id empId, bank_account_no accountNo, bank_name bankName, bank_place bankPlace," + "passport_no passportNo, to_char(passport_issued_date,'dd/mm/yyyy') issuedDate, to_char(passport_expiry_date,'dd/mm/yyyy') expiryDate, passport_issued_place issuedPlace," + "driving_license_no licenseNo, license_type licenseType, to_char(license_issued_date,'dd/mm/yyyy') licenseIssuedDate,"
			+ "to_char(license_expiry_date,'dd/mm/yyyy') licenseexpiryDate, to_char(license_renewal_date,'dd/mm/yyyy') renewalDate, creditcard_no, creditcard_name," + " visa_reference_number visaRefNo,visa_type visaType, visa_issued_place visaIssuedPlace, to_char(visa_issued_date,'dd/mm/yyyy') visaIssuedDate," + "to_char(visa_expiration_date,'dd/mm/yyyy') visaExpiryDate,iscash isActiveCash  FROM employee_documents where employee_id=?";

	public static String SELET_EMP_PHYSICAL_ID = "SELECT employee_id empId, physically_handicaped_eye isActiveSight, physically_handicaped_dumb isActiveDumb," + "physically_handicaped_hearing isActiveHearing, physically_handicaped_hand isActiveHand, physically_handicaped_feet isActiveFeet," + "height height, weight weight, coalesce(right_eye_sight_power,0) rightSidePower, coalesce(left_eye_sight_power,0) leftSidePower  FROM employee_physical where employee_id=?";

	public static String SELET_EMP_ADDRESS_ID = "SELECT employee_id empId, permanent_address permAddress, permanent_place permPlace, permanent_district permDistrict,permanent_state permState, permanent_pincode permPin, permanent_phoneno permPhone, permanent_mobileno permMobile, present_address presentAddress , present_place presentPlace,present_district presentDistrict, present_pincode presentPin, present_phoneno presentPhone, present_mobileno presentMobile FROM employee_address where employee_id=?";

	

	

	public static String SELET_EMP_PERSONAL_COUNT = "select count(employee_id) from employee_personalinfo where employee_id=?";

	public static String SELET_EMP_ADDRESS_COUNT = "select count(employee_id) from employee_address where employee_id=?";

	public static String SELET_EMP_RULE_COUNT = "select count(employee_id) from employee_rule where employee_id=?";

	public static String SELET_EMP_PER_DETAIL_COUNT = "select count(employee_id) from employee_documents where employee_id=?";

	public static String SELET_EMP_PHYSICAL_COUNT = "select count(employee_id) from employee_physical where employee_id=?";

	public static String SELECT_YEAR_LIST = "select c.y as yearPassed from generate_series(1950, 2050) as c(y)";

	public static String getPrincipalCount = "select count(*) from employee where principal = true";

	public static String getMsCount = "select count(*) from employee where ms = true";

	public static String getPrincipalList = "select employee_id as id, first_name as text from employee where principal = true";

	public static String getMSList = "select employee_id as id, first_name as text from employee where ms = true";

	public static final String sCheckPANNo = "select count(*) from employee_personalinfo where LOWER(pan_no) = LOWER(?)";

	public static final String sCheckEPFNo = "SELECT count(*) FROM employee_master WHERE LOWER(epf_no)=LOWER(?)";

	public static final String COUNT_USERID = "select count(emp_id) from employee_master where lower(emp_id)=lower(?)";

	public static final String GET_EMPLOYEE_ID = "select emp_id from employee_master where lower(first_name) = lower(?)";

	public static final String GET_SHIFT_ID = "select shift_id from shift where lower(shift_name) = lower(?)";

	public static final String GET_DEPARTMENT_ID = "select department_id from department where lower(department_name) = lower(?)";

	public static final String getEmployee = "select user_id from user_master where user_id=?";

	public static final String Get_MAX_CBSE1_ID = "select CASE WHEN max(empid) is null then '0' else max(empid) end maxEmpId from(select substr(employee_id, 2) empid from employee where employee_id <> 'admin' and length(employee_id) <= 5 and employee_id like '1%' ) temp";
	// select CASE WHEN max(empid) is null then 0 else max(empid) end maxEmpId
	// from(select cast((substr(employee_id, 2, char_length(employee_id))) as
	// int ) empid from employee where employee_id <> 'admin' and
	// length(employee_id) = 5 and employee_id like '1%' ) temp
	public static final String Get_MAX_CBSE2_ID = "select CASE WHEN max(empid) is null then '0' else max(empid) end maxEmpId from(select substr(employee_id, 2) empid from employee where employee_id <> 'admin' and length(employee_id) <= 5 and employee_id like '1%' ) temp";
	// select CASE WHEN max(empid) is null then 0 else max(empid) end maxEmpId
	// from(select cast((substr(employee_id, 2, char_length(employee_id))) as
	// int ) empid from employee where employee_id <> 'admin' and
	// length(employee_id) = 5 and employee_id like '1%' ) temp
	public static final String Get_MAX_KG_ID = "select CASE WHEN max(empid) is null then '0' else max(empid) end maxEmpId from(select substr(employee_id, 2) empid from employee where employee_id <> 'admin' and length(employee_id) <= 5 and employee_id like '1%' ) temp";
	// select CASE WHEN max(empid) is null then 0 else max(empid) end maxEmpId
	// from(select cast((substr(employee_id, 2, char_length(employee_id))) as
	// int ) empid from employee where employee_id <> 'admin' and
	// length(employee_id) = 5 and employee_id like '1%' ) temp
	public static final String Get_MAX_CIS_ID = "select CASE WHEN max(empid) is null then 0 else max(empid) end maxEmpId from(select cast((substr(employee_id, 2, char_length(employee_id))) as int ) empid from employee where employee_id <> 'admin' and length(employee_id) <= 5 and employee_id like '3%' ) temp";

	public static final String Get_MAX_ADMIN_ID = "select CASE WHEN max(empid) is null then 0 else max(empid) end maxEmpId from(select cast((substr(employee_id, 2, char_length(employee_id))) as int ) empid from employee where employee_id <> 'admin' and length(employee_id) <= 5 and employee_id like '5%' ) temp";

	public static final String Get_MAX_IGCSE_ID = "select CASE WHEN max(empid) is null then 0 else max(empid) end maxEmpId from(select cast((substr(employee_id, 2, char_length(employee_id))) as int ) empid from employee where employee_id <> 'admin' and length(employee_id) <= 5 and employee_id like '6%' ) temp";

	public static final String GETDATEOFJOIN = "select emp_name as firstName,emp_id as empId,to_char(dt_of_join,'dd/mm/yyyy')as doj,dm.desgn_name as designationName from employee_master emp inner join designation_master dm on dm.desgn_code=emp.designation where dt_of_join =current_date";

	public static final String GETRELIEVINGLIST = "select emp_name as firstName,emp_id as empId,to_char(dt_of_join,'dd/mm/yyyy') as doj,to_char(relieving_date,'dd/mm/yyyy') as relieveDate,dm.desgn_name as designationName from employee_master emp inner join designation_master dm on dm.desgn_code=emp.designation where relieving_date =current_date";

	public static final String GETDESINGNATIONAME = "select desgn_name from designation_master dm where desgn_code=?";
	
	public static final String getTenantDb = "select organization_code from organization";

	public static final String BLOODGROUP_LIST = "select blood_group_id as id ,blood_group_name as text from blood_group";


	public static final String INSERT_USERMASTER = "INSERT INTO user_master(user_id,user_name,user_password,user_ref_flag,user_ref_id_emp,active_inactive)values(:empId,:empname,:pwd,:loginFlag,:empId,:status)";

	public static final String UPDATE_EMPLOYEE_MASTER = "update user_master set user_id=:empId,user_name=:empname,user_password=:pwd,user_ref_flag=:loginFlag,user_ref_id_emp=:empId,active_inactive=:status where user_id=:empId";

	public static final String GET_RELEIVING_LIST = "select emp_name as firstName,emp_id as empId,to_char(dt_of_join,'dd/mm/yyyy')as doj,to_char(relieving_date,'dd/mm/yyyy')as relievingDate,dm.desgn_name as designationName from employee_master emp inner join designation_master dm on dm.desgn_code=emp.designation where relieving_date =current_date";

	public static final String GET_JOINING_LIST = "select emp_name as firstName,emp_id as empId,to_char(dt_of_join,'dd/mm/yyyy')as doj,dm.desgn_name as designationName from employee_master emp inner join designation_master dm on dm.desgn_code=emp.designation where dt_of_join =current_date";

	public static final String GETBRANCHID = "select branch_code from branch where company_code =?";

	public static final String SELECT_BRANCH_EDIT__LIST = "   select distinct entity_acct_code as id, concat(entity_acct_code,'-',entity_name) as text from entity where is_vendor='Y'and is_customer='Y' union select distinct entity_acct_code as id, concat(entity_acct_code,'-',entity_name) as text from entity where is_customer='Y' and entity_acct_code in (select emp_name from employee_master where emp_id= ?) ";

	public static final String COMAPANY_BASED_BRANCH = " select branch_code as id,concat(branch_code,'-',branch_name) as text from branch where company_code=? ";

	public static final String DELETE_EMPLOYEE_USERMASTER = "delete from user_master  where user_id  = ?";


	public static final String INSERT_FILES_KYC = "insert into user_master_files (employee_id, file_name , file_path) values(?,?,?)";


	public static final String GET_FILE_PATH = "select employee_id,file_path,file_name from user_master_files where employee_id=?";

    public static String SELECT_PREVIOUS_ID = "select max(user_id) as empId from user_master";

    public static String brn_id = "select brnch_id from branch where brnch_cd=?";

}
