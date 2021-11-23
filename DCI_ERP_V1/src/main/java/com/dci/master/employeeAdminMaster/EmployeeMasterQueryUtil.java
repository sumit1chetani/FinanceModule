package com.dci.master.employeeAdminMaster;

public class EmployeeMasterQueryUtil {

	/*
	 * public static final String SELECT_EMPLOYEE_LIST =
	 * "select e.employee_id empId,e.reporting_to,e.first_name firstName, e.middle_name middleName, branch.branch_name branchName, e.surname lastName, e.gender gender, e.dob dob, e.doj doj, e.access_card_number accessCardNo, e.phone mobileNo, e.email emailId, e.photo_url uploadPhoto, e.status status, e.department_id departmentId, e.designation_id designation, e.grade_id grade, e.division_id division, e.password pwd, e.employee_type_id typeOfEmp, e.epf_no epfNo, e.esic_code esic, e.relieving_date relieveDate, e.fixed_gross fixedGross, e.donor_code donorCode, dept.department_name departmentCode, desig.designation_name designationName, et.type empTypeName, g.name gradeName, div.division_name divisionName from employee e  left join department dept on dept.department_id = e.department_id  left join designation desig on desig.designation_id = e.designation_id left join employment_type et on et.employment_type_id =e.employee_type_id left join grade g on g.grade_id = e.grade_id left join division div on div.division_id = e.division_id left join branch on dept.branch_id = branch.branch_id order by first_name ASC"
	 * ;
	 */

	public static final String SELECT_EMPLOYEE_INDIVIDUAL = "select e.employee_id empId,e.reporting_to,e.first_name firstName, e.middle_name middleName, branch.branch_name branchName, e.surname lastName, e.gender gender,  to_char(e.dob,'dd/mm/yyyy') dob, to_char(e.doj,'dd/mm/yyyy') doj, e.access_card_number accessCardNo, e.phone mobileNo, e.email emailId, e.photo_url uploadPhoto, e.status status,e.emp_user_id empUserId, e.department_id departmentId, e.designation_id designation, e.grade_id grade, e.division_id division, e.password pwd, e.employee_type_id typeOfEmp, e.epf_no epfNo, e.esic_code esic,  e.relieving_date relieveDate, e.fixed_gross fixedGross, e.donor_code donorCode, department.department_name departmentCode, desig.designation_name designationName,  et.type empTypeName, g.name gradeName, div.division_name divisionName,cus.retailer_name cusName,company.company_name as companyName from employee e left join designation desig on desig.designation_id = e.designation_id left join employment_type et on et.employment_type_id =e.employee_type_id  left join grade g on g.grade_id = e.grade_id left join division div on div.division_id = e.division_id inner join branch_department bd on bd.branch_department_id=e.branch_department_id left join branch on bd.branch_id = branch.branch_id left join department on bd.department_id= department.department_id left join retailer cus on cus.retailer_id=e.retailer_id left join company on branch.company_id = company.company_id where company.company_id = ? and e.employee_id= ?";

	public static final String SELECT_EMPLOYEE_LIST1 = "select e.employee_id empId,e.reporting_to,e.first_name firstName, e.middle_name middleName, branch.branch_name branchName, e.surname lastName, e.gender gender, " + "to_char(e.dob,'dd/mm/yyyy') dob, to_char(e.doj,'dd/mm/yyyy') doj, e.access_card_number accessCardNo, e.phone mobileNo, e.email emailId, e.photo_url uploadPhoto, e.status status,e.emp_user_id empUserId, e.department_id departmentId, "
			+ "e.designation_id designation, e.grade_id grade, e.division_id division, e.password pwd, e.employee_type_id typeOfEmp, e.epf_no epfNo, e.esic_code esic, " + "e.relieving_date relieveDate, e.fixed_gross fixedGross, e.donor_code donorCode, department.department_name departmentCode, desig.designation_name designationName, " + "et.type empTypeName, g.name gradeName, div.division_name divisionName,cus.retailer_name cusName,company.company_name as companyName from employee e   "
			+ "left join designation desig on desig.designation_id = e.designation_id left join employment_type et on et.employment_type_id =e.employee_type_id " + "left join grade g on g.grade_id = e.grade_id left join division div on div.division_id = e.division_id inner join branch_department bd "
			+ "on bd.branch_department_id=e.branch_department_id left join branch on bd.branch_id = branch.branch_id left join department on bd.department_id= department.department_id left join retailer cus on cus.retailer_id=e.retailer_id left join company on branch.company_id = company.company_id where company.company_id = ? and e.status='t' order by first_name ASC";

	public static final String SELECT_EMPLOYEE_LIST2 = "select e.employee_id empId,e.reporting_to,e.first_name firstName, e.middle_name middleName, branch.branch_name branchName, e.surname lastName, e.gender gender, " + "to_char(e.dob,'dd/mm/yyyy') dob, to_char(e.doj,'dd/mm/yyyy') doj, e.access_card_number accessCardNo, e.phone mobileNo, e.email emailId, e.photo_url uploadPhoto, e.status status,e.emp_user_id empUserId, e.department_id departmentId, "
			+ "e.designation_id designation, e.grade_id grade, e.division_id division, e.password pwd, e.employee_type_id typeOfEmp, e.epf_no epfNo, e.esic_code esic, " + "e.relieving_date relieveDate, e.fixed_gross fixedGross, e.donor_code donorCode, department.department_name departmentCode, desig.designation_name designationName, " + "et.type empTypeName, g.name gradeName, div.division_name divisionName,cus.retailer_name cusName,company.company_name as companyName from employee e   "
			+ "left join designation desig on desig.designation_id = e.designation_id left join employment_type et on et.employment_type_id =e.employee_type_id " + "left join grade g on g.grade_id = e.grade_id left join division div on div.division_id = e.division_id inner join branch_department bd "
			+ "on bd.branch_department_id=e.branch_department_id left join branch on bd.branch_id = branch.branch_id left join department on bd.department_id= department.department_id left join retailer cus on cus.retailer_id=e.retailer_id left join company on branch.company_id = company.company_id where company.company_id = ? and e.status='f' order by first_name ASC";

	public static final String SELECT_EMPLOYEE_LIST3 = "select e.employee_id empId,e.reporting_to,e.first_name firstName, e.middle_name middleName, branch.branch_name branchName, e.surname lastName, e.gender gender, " + "to_char(e.dob,'dd/mm/yyyy') dob, to_char(e.doj,'dd/mm/yyyy') doj, e.access_card_number accessCardNo, e.phone mobileNo, e.email emailId, e.photo_url uploadPhoto, e.status status,e.emp_user_id empUserId, e.department_id departmentId, "
			+ "e.designation_id designation, e.grade_id grade, e.division_id division, e.password pwd, e.employee_type_id typeOfEmp, e.epf_no epfNo, e.esic_code esic, " + "e.relieving_date relieveDate, e.fixed_gross fixedGross, e.donor_code donorCode, department.department_name departmentCode, desig.designation_name designationName, " + "et.type empTypeName, g.name gradeName, div.division_name divisionName,cus.retailer_name cusName,company.company_name as companyName from employee e   "
			+ "left join designation desig on desig.designation_id = e.designation_id left join employment_type et on et.employment_type_id =e.employee_type_id " + "left join grade g on g.grade_id = e.grade_id left join division div on div.division_id = e.division_id inner join branch_department bd "
			+ "on bd.branch_department_id=e.branch_department_id left join branch on bd.branch_id = branch.branch_id left join department on bd.department_id= department.department_id left join retailer cus on cus.retailer_id=e.retailer_id left join company on branch.company_id = company.company_id where company.company_id = ? order by first_name ASC";

	public static String INSERT_EMPLOY = "INSERT INTO employee_master(emp_id,reporting_to,access_card_number,first_name, middle_name, surname, gender, dob, doj, phone, email, photo_url, designation_id, grade_id, division_id, password, employee_type_id, epf_no, esic_code, fixed_gross, donor_code, status,branch_department_id,insurance_policy_no,relieving_date,employee_type_date,retailer_id,emp_user_id,department_id,uan_no) VALUES"
			+ " (:empId,:reportMangrId,:accessCardNo,:firstName,:middleName,:lastName,:gender,:dob,:doj,:mobileNo,:emailId,:uploadPhoto,:designation,:grade,:division,:pwd,:typeOfEmp,:epfNo,:esic,:fixedGross,:donorCode,:status,:branchId, :insuranceNo, :relieveDate,:employmentDate, :customerId,:empUserId,:departmentId,:uan)";

	public static String INSERT_COMPANY_USER = " INSERT INTO company_user (company_code, user_id, is_primary) VALUES (?, ?, ?) returning company_user_id ";

	public static String INSERT_USER_RIGHTS = " insert into user_rights_new(company_user_id,form_property_id) values (?, ?) ";

	/*
	 * " insert into user_rights(company_user_id,form_property_id) " +
	 * " select ? as company_user_id, form_property_id from designation_rights  where designation_id=? "
	 * ;
	 */
	public static String Customer_LIST_User = " select distinct  r.retailer_id as id,r.retailer_name as text from employee e  inner join branch_department bd on bd.branch_department_id =e.branch_department_id inner join branch b on b.branch_id = bd.branch_id inner join retailer r on r.retailer_id = e.retailer_id where b.company_id =? ";

	public static String SELECT_DESIGNATION_RIGHTS = " select ? as companyUserId, form_property_id formPropertyId from designation_rights  where designation_id=? ";

	/*
	 * " INSERT INTO company_user (company_code, user_id, is_primary) VALUES (:companyCode, :empId, :isPrimary) returning company_user_id "
	 * ;
	 */

	/*
	 * " INSERT INTO company_user (company_code, user_id, is_primary) VALUES (:companyCode, :empId, :isPrimary) "
	 * ;
	 */

	public static String INSERT_PERSONAL_INF = "INSERT INTO employee_personalinfo(aadhar_no,marital_status,fa_hus_guardian_name,blood_group,caste, religion, mother_tongue, nationality, pan_no, gratuity_nominee, gratuity_nominee_relation, mode_of_conveyence, emergency_contact_no, emergency_contact_name,notice_period_tobe_served, remarks, hobbies, status, conformation_date, resignation_date, employee_id, languages_known,confirmation_period, husband_wife_name) VALUES (:aadharno,:marritalStatus,:guardianName,:bloodGrp,:caste,:religion,:motherTongue, :nationality,:panNo,:gratuityNominee,:nomineeRelation,:modeConveyence,:emgContactNo, :emgContactName,:noticePeriod,:remarks,:hobbies,:personalStatus,to_date(:confirmDate,'dd/mm/yyyy'), to_date(:resignationDate,'dd/mm/yyyy'),:empId,:languages,:confirmationPeriod,:husbWifeName)";

	// public static String INSERT_ADDRESS_INF =
	// "INSERT INTO employee_address(employee_id, permanent_address, permanent_place, permanent_district,permanent_state, permanent_pincode, permanent_phoneno, permanent_mobileno) VALUES (:empId, :permAddress,:permPlace,:permDistrict,:permState,:permPin,:permPhone, :permMobile)";

	public static String INSERT_ADDRESS_INF = "INSERT INTO employee_address(employee_id, permanent_address, permanent_place, permanent_district, permanent_pincode, permanent_phoneno, permanent_mobileno,present_address,present_place, present_district, present_pincode, present_phoneno, present_mobileno) VALUES (:empId, :permAddress,:permPlace,:permDistrict,:permPin,:permPhone, :permMobile, :presentAddress,:presentPlace,:presentDistrict,:presentPin, :presentPhone,:presentMobile)";

	public static String INSERT_RULES_INF = "INSERT INTO employee_rule(employee_id, overtime_applicable, esi_applicable,late_applicable, telephone_limit, pf_applicable, is_encashable, medical_limit,early_exit_applicable) VALUES (:empId,:overTime,:esiApp, :lateApp, :telephoneLimit, :pfApp, :leaveOption, :medicalLimit, :earlyExit)";

	public static String INSERT_NOMINEE_INF = "INSERT INTO employee_nominee(employee_id, employee_nominee_name, sex,occupation, relationship,email, dob, " + "address, pincode, place,phone_no,mobile_no,aadhar_no) VALUES (:empId, :nominateName,:nominateGender,:nominateOccupation, :nominateRelationship, :nominateEmail, " + "to_date(:nomdateOfBirth,'dd/mm/yyyy'), :nomineAddress, :nominatePincode, :nominatePlace,:emergPhone,:emergMobile,:aadharno2) RETURNING employee_nom_id";

	public static String INSERT_PHYSICAL_INF = "INSERT INTO employee_physical(employee_id, physically_handicaped_eye, physically_handicaped_dumb, physically_handicaped_hearing, physically_handicaped_hand, physically_handicaped_feet, height, weight,left_eye_sight_power,right_eye_sight_power) VALUES (:empId, :isActiveSight, :isActiveDumb,:isActiveHearing, :isActiveHand, :isActiveFeet,:height, :weight, :LeftSidePower , :RightSidePower)";

	public static String INSERT_EMERGENCY_INF = "INSERT INTO employee_emergency_contact(employee_id, emergency_contact_name, occupation, relationship, email,place, address, pincode,phone_no,mobile_no) VALUES (:empId, :emergencyName, :emergencyOccu,:emergRelationship, :emergEmail,:emergPlace, :emerAddress, :emergencyPincode,:emergPhone,:emergMobile) RETURNING empl_emer_id";

	public static final String INSERT_EMP_FAMILY = "INSERT INTO employee_family(employee_id,dependent_dob,age,sex,relative_name,relation_to_employee,dependent_on_employee,dependent_passport_no,dependent_passport_issued_date,dependent_passport_expiry_date,dependent_passport_issued_place,dependent_visa_reference_number,dependent_visa_type,dependent_visa_issued_place,dependent_visa_issued_date,dependent_visa_expiration_date,dependent_photo_url,dependent_medical_entitlement,aadhar_no,mobile_no) VALUES(:employeeId,:dependentDob,:age,:sex,:relativeName,:relationToEmployee,:dependentOnEmployee,:dependentPassportNo,:dependentPassportIssuedDate,:dependentPassportExpiryDate,:dependentPassportIssuedPlace,:dependentVisaReferenceNumber,:dependentVisaType,:dependentVisaIssuedPlace,:dependentVisaIssuedDate,:dependentVisaExpirationDate,:dependentPhotoUrl,:dependentMedicalEntitlement,:aadharno,:mobileno)";

	// public static String INSERT_FAMILY_INF =
	// "INSERT INTO employee_family(employee_id, relative_name, sex, relation_to_employee, dependent_on_employee) VALUES (:empId, :familyName, :genderType,:relationshipWithEmp, :empDependence)";

	/*
	 * public static String SELECT_EMPLOYEE_BY_ID =
	 * " select e.employee_id empId, e.reporting_to reportMangrId, rep.designation_id reportDesigId, rep.department_id reportDeptId, "
	 * +
	 * " rep.first_name reportManagerName, depts.department_name reportToDept, desigs.designation_name reportToDesig, "
	 * +
	 * " e.first_name firstName, e.middle_name middleName, e.surname lastName, e.gender gender, e.dob dob, e.doj doj, "
	 * +
	 * " e.access_card_number accessCardNo, e.phone mobileNo, e.email emailId, e.photo_url uploadPhoto, "
	 * +
	 * " e.status status,e.department_id departmentId, e.designation_id designation, e.grade_id grade, e.division_id division, "
	 * +
	 * " e.password pwd, e.employee_type_id typeOfEmp, e.epf_no epfNo, e.esic_code esic, e.relieving_date relieveDate, "
	 * +
	 * " e.fixed_gross fixedGross, e.donor_code donorCode, dept.department_name departmentCode, "
	 * +
	 * " desig.designation_name designationName, et.type empTypeName, g.name gradeName, div.division_name divisionName, "
	 * +
	 * " per.marital_status marritalStatus, per.fa_hus_guardian_name guardianName,per.blood_group bloodGrp, per.caste caste, "
	 * +
	 * " per.religion religion, per.mother_tongue motherTongue, per.nationality nationality, per.pan_no panNo, "
	 * + " per.gratuity_nominee gratuityNominee, " +
	 * " per.gratuity_nominee_relation nomineeRelation, per.mode_of_conveyence modeConveyence, per.emergency_contact_no "
	 * +
	 * " emgContactNo, per.emergency_contact_name emgContactName, per.notice_period_tobe_served noticePeriod, "
	 * +
	 * " per.remarks remarks, per.hobbies hobbies, per.status personalStatus, per.conformation_date confirmDate, "
	 * +
	 * " per.resignation_date resignationDate, per.languages_known languages, per.confirmation_period confirmationPeriod, "
	 * +
	 * " per.husband_wife_name husbWifeName, addr.permanent_address permAddress, addr.permanent_place permPlace, "
	 * +
	 * " addr.permanent_district permDistrict, addr.permanent_pincode permPin, "
	 * +
	 * " addr.permanent_phoneno permPhone, addr.permanent_mobileno permMobile, addr.present_address presentAddress, "
	 * +
	 * " addr.present_place presentPlace, addr.present_district presentDistrict, addr.present_pincode presentPin, "
	 * +
	 * " addr.present_phoneno presentPhone, addr.present_mobileno presentMobile, fam.relative_name familyName, "
	 * +
	 * " fam.sex genderType, fam.relation_to_employee relationshipWithEmp, fam.dependent_on_employee empDependence, "
	 * +
	 * " edu.qualification qualification, edu.percentage percentage, edu.cource_type courseType, edu.institution institution, "
	 * +
	 * " edu.year_of_passing yearPassed,exp.organization_name organization, exp.year_of_experiance experienceYear, "
	 * +
	 * " exp.designation expDesisnation, exp.remarks expRemarks, nom.employee_nominee_name nominateName, "
	 * +
	 * " nom.sex nominateGender, nom.occupation nominateOccupation, nom.relationship nominateRelationship, "
	 * +
	 * " nom.email nominateEmail, nom.phone_no nominatePhone, nom.mobile_no nominateMobile, nom.dob nomdateOfBirth, "
	 * +
	 * " nom.address nomineAddress, nom.pincode nominatePincode, nom.place nominatePlace, mer.award_name awardName, "
	 * +
	 * " mer.scholarship_name scholarshipName, mer.description meritDesc, emer.emergency_contact_name emergencyName,"
	 * +
	 * " emer.occupation emergencyOccu, emer.relationship emergRelationship, emer.email emergEmail,"
	 * +
	 * " emer.phone_no emergPhone, emer.mobile_no emergMobile, emer.place emergPlace, emer.address emerAddress, "
	 * +
	 * " emer.pincode emergencyPincode, refe.employee_reference_name referenceName, refe.occupation occupationRef, "
	 * +
	 * " refe.email emailRef, refe.relationship relationshipRef, refe.phone_no phoneRef, refe.pincode pincodeRef, "
	 * +
	 * " refe.address referenceAddress, doc.bank_account_no accountNo, doc.bank_name bankName, doc.bank_place bankPlace, "
	 * +
	 * " doc.passport_no passportNo, doc.passport_issued_date issuedDate, doc.passport_expiry_date  expiryDate, "
	 * +
	 * " doc.passport_issued_place issuedPlace, doc.driving_license_no licenseNo, doc.license_type licenseType, "
	 * +
	 * " doc.license_issued_date licenseIssuedDate, doc.license_expiry_date licenseexpiryDate, doc.license_renewal_date "
	 * +
	 * " renewalDate, doc.attachment joinDocUpload, doc.visa_reference_number visaRefNo, doc.visa_type visaType, "
	 * +
	 * " doc.visa_issued_place visaIssuedPlace, doc.visa_issued_date visaIssuedDate,doc.visa_expiration_date visaExpiryDate, "
	 * +
	 * " doc.iscash isActiveCash, phy.physically_handicaped_eye isActiveSight, phy.physically_handicaped_dumb isActiveDumb, "
	 * +
	 * " phy.physically_handicaped_hearing isActiveHearing, phy.physically_handicaped_hand isActiveHand, "
	 * +
	 * " phy.physically_handicaped_feet isActiveFeet, phy.height height, phy.weight weight, "
	 * +
	 * " rul.overtime_applicable overTime, rul.esi_applicable esiApp, rul.late_applicable lateApp, rul.telephone_limit telephoneLimit, "
	 * +
	 * " rul. pf_applicable pfApp, rul.early_exit_applicable earlyExit, rul.medical_limit medicalLimit, rul.is_encashable leaveOption,b.branch_id as branch,c.company_id as companyCode "
	 * + " from employee e " +
	 * " left join department dept on dept.department_id = e.department_id " +
	 * " left join designation desig on desig.designation_id = e.designation_id "
	 * +
	 * " left join employment_type et on et.employment_type_id = e.employee_type_id "
	 * +
	 * " left join grade g on g.grade_id = e.grade_id left join division div on div.division_id = e.division_id "
	 * + " left join employee rep on rep.employee_id = e.reporting_to " +
	 * " left join department depts on depts.department_id = rep.department_id "
	 * +
	 * " left join designation desigs on desigs.designation_id = rep.designation_id "
	 * +
	 * " left join employee_personalinfo per on per.employee_id = e.employee_id "
	 * + " left join employee_address addr on addr.employee_id = e.employee_id "
	 * + " left join employee_family fam on fam.employee_id = e.employee_id " +
	 * " left join employee_education edu on edu.employee_id = e.employee_id " +
	 * " left join employee_experiance exp on exp.employee_id = e.employee_id "
	 * + " left join employee_nominee nom on nom.employee_id = e.employee_id " +
	 * " left join employee_merits mer on mer.employee_id = e.employee_id " +
	 * " left join employee_emergency_contact emer on emer.employee_id = e.employee_id "
	 * +
	 * " left join employee_references refe on refe.employee_id = e.employee_id "
	 * + " left join employee_documents doc on doc.employee_id = e.employee_id "
	 * + " left join employee_physical phy on phy.employee_id = e.employee_id "
	 * + " left join employee_rule rul on rul.employee_id = e.employee_id " +
	 * " inner join branch_department br on br.branch_department_id = e.branch_department_id "
	 * + " inner join branch b on br.branch_id = b.branch_id " +
	 * " inner join company c on b.company_id = c.company_id " +
	 * " where e.employee_id = ?";
	 */
	public static String SELECT_EMPLOYEE_BY_ID = "select e.uan_no uan,e.relieving_date relieveDate,e.employee_id empId, temp.branch_id reportBranch, e.reporting_to reportMangrId,e.emp_user_id empUserId, rep.designation_id reportDesigId, rep.department_id reportDeptId,  rep.first_name reportManagerName, depts.department_name reportToDept, desigs.designation_name reportToDesig,  e.first_name firstName, e.middle_name middleName, e.surname lastName, e.gender gender, e.dob dob, e.insurance_policy_no insuranceNo,e.doj doj, "
			+ "e.access_card_number accessCardNo, e.phone mobileNo, e.email emailId, e.photo_url uploadPhoto, e.status status,e.department_id as departmentId, e.designation_id designation, e.grade_id grade, e.division_id division,  e.password pwd, e.employee_type_id typeOfEmp, e.epf_no epfNo, e.esic_code esic,  e.fixed_gross fixedGross, e.donor_code donorCode, dept.department_name departmentCode, e.retailer_id as customerId, "
			+ "desig.designation_name designationName, et.type empTypeName, g.name gradeName, div.division_name divisionName,  b.branch_id as branch,b.branch_name as branchName,c.company_id as companyCode,c.company_name as companyName,e.employee_type_date employmentDate from employee e  left join department dept on dept.department_id = e.department_id  left join designation desig on desig.designation_id = e.designation_id  left join employment_type et on et.employment_type_id = e.employee_type_id  left join grade g on g.grade_id = e.grade_id left join division div on div.division_id = e.division_id "
			+ "left join employee rep on rep.employee_id = e.reporting_to  left join department depts on depts.department_id = rep.department_id  left join designation desigs on desigs.designation_id = rep.designation_id  inner join branch_department br on br.branch_department_id = e.branch_department_id  inner join branch b on br.branch_id = b.branch_id  inner join company c on b.company_id = c.company_id  left join (select branch_department.branch_id, e.employee_id from branch_department "
			+ "inner join employee e on e.branch_department_id=branch_department.branch_department_id) temp on temp.employee_id =e.reporting_to  where e.employee_id = ?";

	public static String SELECT_EMPLOYEE_REPORT_LIST = "select c.company_name companyName, b.branch_name branchName, e.employee_id empId, e.status astatus, e.reporting_to reportMangrId, coalesce(rep.designation_id,0) reportDesigId,   coalesce(rep.department_id,0) reportDeptId,    (select first_name from employee em where em.employee_id= e.reporting_to) reportManagerName,desigs.designation_name reportToDesig,  e.first_name firstName, e.middle_name middleName, e.surname lastName, e.dob dob, e.doj doj,coalesce(e.department_id,0) departmentId, e.designation_id designation,e.employee_type_id typeOfEmp,  e.fixed_gross fixedGross, dept.department_name departmentCode,  desig.designation_name designationName, et.type empTypeName, g.name gradeName, div.division_name divisionName,  per.marital_status  marritalStatus, per.fa_hus_guardian_name guardianName,per.blood_group bloodGrp, per.caste caste,  per.religion   religion, per.mother_tongue motherTongue, per.nationality nationality,   coalesce(edu.year_of_passing,0) yearPassed,coalesce(exp.year_of_experiance,0) experienceYear, doc.bank_name bankName, doc.iscash isActiveCash, phy.physically_handicaped_eye isActiveSight, phy.physically_handicaped_dumb isActiveDumb, phy.physically_handicaped_hearing isActiveHearing, phy.physically_handicaped_hand isActiveHand,   phy.physically_handicaped_feet isActiveFeet,  coalesce(rul.overtime_applicable,false) overTime, rul.esi_applicable esiApp,coalesce(rul.telephone_limit,0.00)   telephoneLimit, rul. pf_applicable pfApp,coalesce( rul.medical_limit,0.00) medicalLimit,   b.branch_id as branch,c.company_id as companyCode,addr.permanent_address as paddress,addr.permanent_mobileno as pmobile,addr.permanent_place as pplace,addr.permanent_district as pdistrict,addr.permanent_pincode as ppincode,addr.present_address as preaddress,addr.present_place as preplace,addr.present_district as predistrict,addr.present_pincode as prepincode,e.email as mail from employee e   left join department dept on dept.department_id = e.department_id  left join designation desig  on desig.designation_id = e.designation_id   left join employment_type et on et.employment_type_id = e.employee_type_id   left join grade g on g.grade_id = e.grade_id left join division div on div.division_id = e.division_id   left join employee rep on rep.employee_id = e.reporting_to   left join department depts on depts.department_id = rep.department_id   left join designation desigs on desigs.designation_id = rep.designation_id  left join employee_personalinfo per on per.employee_id = e.employee_id   left join employee_address addr on addr.employee_id = e.employee_id   left join employee_family fam on fam.employee_id = e.employee_id   left join employee_education edu on edu.employee_id = e.employee_id   left join employee_experiance exp on exp.employee_id = e.employee_id   left join employee_nominee nom on nom.employee_id = e.employee_id   left join employee_merits mer on mer.employee_id = e.employee_id left join employee_emergency_contact emer on emer.employee_id = e.employee_id   left join employee_references refe on refe.employee_id = e.employee_id   left join employee_documents doc on doc.employee_id = e.employee_id   left join employee_physical phy on phy.employee_id = e.employee_id   left join employee_rule rul on rul.employee_id = e.employee_id   inner join branch_department br on br.branch_department_id = e.branch_department_id   inner join branch b on br.branch_id = b.branch_id inner join company c on b.company_id = c.company_id";

	public static String SELECT_REPORT_CDB = " select c.company_name companyName, b.branch_name branchName, e.employee_id empId, e.reporting_to reportMangrId, rep.designation_id reportDesigId, " + " rep.department_id reportDeptId,  rep.first_name reportManagerName, depts.department_name reportToDept, " + " desigs.designation_name reportToDesig,  e.first_name firstName, e.middle_name middleName, e.surname lastName, " + " e.gender gender, e.dob dob, e.doj doj,  e.access_card_number accessCardNo, e.phone mobileNo, e.email emailId, "
			+ " e.photo_url uploadPhoto,  e.status status,e.department_id departmentId, e.designation_id designation, " + " e.grade_id grade, e.division_id division, " + " e.password pwd, e.employee_type_id typeOfEmp, e.epf_no epfNo, e.esic_code esic, e.relieving_date relieveDate, " + " e.fixed_gross fixedGross, e.donor_code donorCode, dept.department_name departmentCode,  desig.designation_name " + " designationName, et.type empTypeName, g.name gradeName, div.division_name divisionName,  per.marital_status "
			+ " marriedStatus, per.fa_hus_guardian_name guardianName,per.blood_group bloodGrp, per.caste caste,  per.religion " + " religion, per.mother_tongue motherTongue, per.nationality nationality, per.pan_no panNo,  per.gratuity_nominee " + " gratuityNominee, per.gratuity_nominee_relation nomineeRelation, per.mode_of_conveyence modeConveyence, " + " per.emergency_contact_no  emgContactNo, per.emergency_contact_name emgContactName, per.notice_period_tobe_served "
			+ " noticePeriod,  per.remarks remarks, per.hobbies hobbies, per.status personalStatus, per.conformation_date " + " confirmDate,  per.resignation_date resignationDate, per.languages_known languages, per.confirmation_period " + " confirmationPeriod,  per.husband_wife_name husbWifeName, addr.permanent_address permAddress, addr.permanent_place " + " permPlace, addr.permanent_district permDistrict, addr.permanent_pincode permPin,  addr.permanent_phoneno permPhone, "
			+ " addr.permanent_mobileno permMobile, addr.present_address presentAddress,  addr.present_place presentPlace, " + " addr.present_district presentDistrict, addr.present_pincode presentPin,  addr.present_phoneno presentPhone, " + " addr.present_mobileno presentMobile, fam.relative_name familyName,  fam.sex genderType, fam.relation_to_employee " + " relationshipWithEmp, fam.dependent_on_employee empDependence, " + " edu.qualification qualification, edu.percentage percentage, edu.cource_type courseType, edu.institution institution, "
			+ " coalesce(edu.year_of_passing,0) yearPassed,exp.organization_name organization, exp.year_of_experiance experienceYear, " + " exp.designation expDesisnation, exp.remarks expRemarks, nom.employee_nominee_name nominateName, " + " nom.sex nominateGender, nom.occupation nominateOccupation, nom.relationship nominateRelationship, " + " nom.email nominateEmail, nom.phone_no nominatePhone, nom.mobile_no nominateMobile, nom.dob nomdateOfBirth, "
			+ " nom.address nomineAddress, nom.pincode nominatePincode, nom.place nominatePlace, mer.award_name awardName, " + " mer.scholarship_name scholarshipName, mer.description meritDesc, emer.emergency_contact_name emergencyName, " + " emer.occupation emergencyOccu, emer.relationship emergRelationship, emer.email emergEmail, emer.phone_no emergPhone, " + " emer.mobile_no emergMobile, emer.place emergPlace, emer.address emerAddress,  emer.pincode emergencyPincode, "
			+ " refe.employee_reference_name referenceName, refe.occupation occupationRef, " + " refe.email emailRef, refe.relationship relationshipRef, refe.phone_no phoneRef, refe.pincode pincodeRef, " + " refe.address referenceAddress, doc.bank_account_no accountNo, doc.bank_name bankName, doc.bank_place bankPlace, " + " doc.passport_no passportNo, doc.passport_issued_date issuedDate, doc.passport_expiry_date  expiryDate, " + " doc.passport_issued_place issuedPlace, doc.driving_license_no licenseNo, doc.license_type licenseType, "
			+ " doc.license_issued_date licenseIssuedDate, doc.license_expiry_date licenseexpiryDate, doc.license_renewal_date " + " renewalDate, doc.attachment joinDocUpload, doc.visa_reference_number visaRefNo, doc.visa_type visaType, " + " doc.visa_issued_place visaIssuedPlace, doc.visa_issued_date visaIssuedDate,doc.visa_expiration_date visaExpiryDate, " + "coalesce( doc.iscash,false) isActiveCash, coalesce(phy.physically_handicaped_eye,false) isActiveSight, coalesce(phy.physically_handicaped_dumb,false) isActiveDumb, "

			+ " coalesce(phy.physically_handicaped_hearing,false) isActiveHearing, coalesce(phy.physically_handicaped_hand,false) isActiveHand, " + " coalesce(phy.physically_handicaped_feet,false) isActiveFeet, phy.height height, phy.weight weight, " + " rul.overtime_applicable overTime, rul.esi_applicable esiApp, rul.late_applicable lateApp, rul.telephone_limit " + " telephoneLimit,  rul. pf_applicable pfApp, rul.early_exit_applicable earlyExit, rul.medical_limit medicalLimit, "
			+ " rul.is_encashable leaveOption,b.branch_id as branch,c.company_id as companyCode  from employee e " + " left join department dept on dept.department_id = e.department_id " + " left join designation desig on desig.designation_id = e.designation_id " + " left join employment_type et on et.employment_type_id = e.employee_type_id " + " left join grade g on g.grade_id = e.grade_id left join division div on div.division_id = e.division_id " + " left join employee rep on rep.employee_id = e.reporting_to "
			+ " left join department depts on depts.department_id = rep.department_id " + " left join designation desigs on desigs.designation_id = rep.designation_id " + " left join employee_personalinfo per on per.employee_id = e.employee_id " + " left join employee_address addr on addr.employee_id = e.employee_id " + " left join employee_family fam on fam.employee_id = e.employee_id " + " left join employee_education edu on edu.employee_id = e.employee_id " + " left join employee_experiance exp on exp.employee_id = e.employee_id "
			+ " left join employee_nominee nom on nom.employee_id = e.employee_id " + " left join employee_merits mer on mer.employee_id = e.employee_id " + " left join employee_emergency_contact emer on emer.employee_id = e.employee_id " + " left join employee_references refe on refe.employee_id = e.employee_id " + " left join employee_documents doc on doc.employee_id = e.employee_id " + " left join employee_physical phy on phy.employee_id = e.employee_id " + " left join employee_rule rul on rul.employee_id = e.employee_id "
			+ " inner join branch_department br on br.branch_department_id = e.branch_department_id " + " inner join branch b on br.branch_id = b.branch_id " + " inner join company c on b.company_id = c.company_id  where c.company_id=? and b.branch_id=? ";

	public static String INSERT_REFERENCE_INF = "INSERT INTO employee_references(employee_id, employee_reference_name, occupation, email, relationship, pincode, address,phone_no) VALUES (:empId, :referenceName, :occupationRef, :emailRef, :relationshipRef,:pincodeRef,:referenceAddress,:emergMobile) RETURNING emp_ref_id";

	public static String INSERT_DOCUMENT_INF = "INSERT INTO employee_documents(employee_id, bank_account_no, bank_name, bank_place, passport_no, passport_issued_date, passport_expiry_date, passport_issued_place, driving_license_no, license_type, license_issued_date, license_expiry_date, license_renewal_date, attachment, visa_reference_number, visa_type,visa_issued_place, visa_issued_date, visa_expiration_date, iscash) VALUES (:empId, :accountNo, :bankName, :bankPlace, :passportNo, :issuedDate, :expiryDate, :issuedPlace, :licenseNo, :licenseType, :licenseIssuedDate,:licenseexpiryDate, :linceseRenewdDate, :joinDocUpload, :visaRefNo, :visaType, :visaIssuedPlace,:visaIssuedDate, :visaExpiryDate, :isActiveCash)";

	public static String INSERT_MERIT_INF = "INSERT INTO employee_merits(employee_id, award_name, scholarship_name, description) VALUES (:empId, :awardName, :scholarshipName, :meritDesc)";

	public static String INSERT_EDUC_INF = "INSERT INTO employee_education(employee_id, qualification, percentage, cource_type, institution, year_of_passing,specialization) VALUES (:empId, :qualification, :percentage,:courseType, :institution, :yearPassed,:specialization)";

	public static String INSERT_EXPERIENCE_INF = "INSERT INTO employee_experiance(employee_id, organization_name, year_of_experiance,designation,remarks) VALUES (:empId, :organization, :experienceYear, :expDesisnation, :expRemarks)";

	public static final String INSERT_EMPLOYEE_UPLOAD = "INSERT INTO employee_master(emp_id, first_name, department_id, dob, doj, designation_id, middle_name, surname, gender, phone, email, status, epf_no, esic_code, relieving_date, fixed_gross,branch_department_id,grade_id,division_id,employee_type_id,reporting_to) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)";

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

	public static final String CHECK_BRANCH = "select count(*) from branch_department where branch_id = ? and department_id = ? ";

	public static String UPDATE_EMPLOYEE = " UPDATE employee SET donor_code=:donorCode, emp_user_id=:empUserId,reporting_to=:reportMangrId, first_name=:firstName, middle_name=:middleName, surname=:lastName, password=:pwd," + " gender=:gender,  dob=to_date(:dob,'dd/MM/yyyy'), email=:emailId, phone=:mobileNo, doj=to_date(:doj,'dd/MM/yyyy'), status=:status, esic_code=:esic, fixed_gross=:fixedGross, " + " photo_url=:uploadPhoto, department_id=:departmentId, designation_id=:designation, division_id=:division, grade_id=:grade, "
			+ " employee_type_id=:typeOfEmp," + " epf_no=:epfNo,branch_department_id=:branchId, insurance_policy_no=:insuranceNo, relieving_date=:relieveDate,employee_type_date=:employmentDate,retailer_id=:customerId  WHERE employee_id=:empId ";

	public static String UPDATE_PERSONAL_INFO = "UPDATE employee_personalinfo SET aadhar_no=:aadharno,employee_id=:empId, marital_status=:marritalStatus, " + "fa_hus_guardian_name=:guardianName," + " blood_group=:bloodGrp, caste=:caste," + " religion=:religion, mother_tongue=:motherTongue, nationality=:nationality, " + "pan_no=:panNo, gratuity_nominee=:gratuityNominee, gratuity_nominee_relation=:nomineeRelation, " + "mode_of_conveyence=:modeConveyence,"
			+ " hobbies=:hobbies,notice_period_tobe_served=:noticePeriod ,emergency_contact_name=:emgContactName ,emergency_contact_no=:emgContactNo, conformation_date=to_date(:confirmDate,'dd/MM/yyyy'), " + " resignation_date=to_date(:resignationDate,'dd/MM/yyyy'), " + " languages_known=:languages, remarks=:remarks," + "confirmation_period=:confirmationPeriod, husband_wife_name=:husbWifeName " + " WHERE employee_id=:empId ";

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

	public static String INSERT_ON_UPDATE_PERSONAL_INF = "INSERT INTO employee_personalinfo(marital_status,fa_hus_guardian_name,blood_group,caste," + " religion, mother_tongue, nationality, pan_no, gratuity_nominee, gratuity_nominee_relation," + " mode_of_conveyence, emergency_contact_no, emergency_contact_name,notice_period_tobe_served, " + " remarks, hobbies, conformation_date, resignation_date, employee_id, languages_known, " + "confirmation_period, husband_wife_name) VALUES (:marritalStatus,:guardianName,"
			+ " :bloodGrp,:caste,:religion,:motherTongue, :nationality,:panNo,:gratuityNominee,:nomineeRelation, " + " :modeConveyence,:emgContactNo, :emgContactName,:noticePeriod,:remarks,:hobbies, " + " to_date(:confirmDate,'dd/mm/yyyy'), to_date(:resignationDate,'dd/mm/yyyy'),:empId,:languages,:confirmationPeriod,:husbWifeName)";

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

	public static String INSERT_ON_UPDATE_RULE_INF = "INSERT INTO employee_rule(employee_id, overtime_applicable, esi_applicable,late_applicable, " + " telephone_limit, pf_applicable, is_encashable, medical_limit,early_exit_applicable) VALUES " + " (:empId,:overTime,:esiApp, :lateApp, :telephoneLimit, :pfApp, :leaveOption, " + " :medicalLimit, :earlyExit)";

	public static String UPDATE_RULE_INFO = "UPDATE employee_rule SET overtime_applicable=:overTime," + " esi_applicable=:esiApp,late_applicable=:lateApp, telephone_limit=:telephoneLimit,pf_applicable=:pfApp, " + "medical_limit=:medicalLimit, " + " is_encashable=:leaveOption, early_exit_applicable=:earlyExit WHERE employee_id=:empId ";

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

	public static String DELETE_EMPLOYEE_EMPLOYEE = "Delete from employee where employee_id=?";

	public static String DELETE_EMPLOYEE_DOCUMETNS = "Delete from employee_master_documents where empid=?";

	public static String sGetDepartmentDropDown = "select department_id, department_name from department";

	// public static String SELECT_COMPANY_LIST =
	// "select company_id as id,company_name as text,company_id companyCode,company_name companyName from company order by company_name ASC";

	public static String SELECT_COMPANY_LIST = "SELECT DISTINCT company_code as companyCode,company_name as text,c.company_id as id,company_name companyName FROM company_user cu INNER JOIN company c ON cu.company_code = c.company_id WHERE user_id = ?  and company_id =? ORDER BY company_name ASC";

	public static String SELECT_BRANCH_LIST = "select branch_id as id,branch_name as text,branch_id branch,branch_name branchName from branch where company_id = ?";

	public static String SELECT_DEPARTMENT_LIST = "select department_id departmentId,department_name departmentCode,department_id as id,department_name as text  from department where company_id=?";

	public static String SELECT_DESIGNATION_LIST = "select designation_id as id,designation_name as text,designation_id designation,designation_name designationName from designation d where d.company_id = ? order by designation_name ASC";

	public static String SELECT_BLOODGROUP_LIST = "select blood_group_id as id,blood_group_name as text from blood_group ";

	public static String SELECT_DIVISION_LIST = "select division_id as id,division_name as text,division_id division,division_name divisionName from division where company_id = ?  order by division_name ASC";

	public static String SELECT_GRADE_LIST = "select grade_id as id,name as text,grade_id grade,name gradeName from grade where status=true and grade.company_id = ? order by name ASC";

	public static String SELECT_REPORT_BRANCH_LIST = "select branch_id as id,branch_name as text,branch_id reportToBranch,branch_name reportToBranchName from branch order by branch_name ASC";

	public static String SELECT_REPORT_DEPT_LIST = "select d.dept_id reportDeptId,dept_name reportToDept FROM department d INNER JOIN branch_department bd ON bd.department_id=d.department_id AND bd.branch_id=? WHERE d.dept_status='Y' order by dept_name ASC";

	public static String SELECT_REORT_DESIG_LIST = "select des.designation_id reportDesigId,des.designation_id as id,des.designation_name reportToDesig,des.designation_name as text from designation des inner join employee e on des.designation_id=e.designation_id where e.employee_id=? order by designation_name ASC";
	public static String SELECT_EMP_TYPE_LIST = "select employment_type_id as id,type as text  from employment_type";

	// public static String SELECT_EMP_TYPE_LIST =
	// "select concat(first_name,' ',surname) as empName, concat(first_name,' ',surname) as text , employee_id as empId , employee_id as id from employee join branch_department on employee.branch_department_id=branch_department.branch_department_id inner join branch on branch.branch_id = branch_department.branch_id inner join company c on c.company_id = branch.company_id where  employee.status = true and c.company_id = ?";
	public static String SELECT_REPORT_MANAGER_LIST = "select employee_id reportMangrId,employee_id as id, concat(employee_id,' - ',first_name,' ',surname) reportManagerName,concat(employee_id,' - ',first_name,' ',surname) as text from employee inner join branch_department bd on bd.branch_department_id=employee.branch_department_id where  bd.branch_id=? order by first_name ASC";

	public static final String sInsertBranchDeparment = "insert into branch_department (branch_id,department_id) values(?,?) returning branch_department_id";

	public static final String sGetBranchDepartmentId = "select branch_department_id from branch_department where branch_id = ? and department_id = ?";

	public static String SELET_EMP_DOC_ID = "SELECT empid empId, document_name docName, description description, img_url uploadDoc, emp_doc_id empDocId FROM employee_master_documents where emp_doc_id=?;";

	public static String INSERT_DOCUMENT = "INSERT INTO employee_master_documents(empid, document_name, description, img_url)VALUES (:empId, :docName, :description,:uploadDoc)";

	public static String SELET_EMP_EXP = "SELECT employee_id empId,emp_exp_id empExpId, organization_name organization, year_of_experiance experienceYear, designation expDesisnation, remarks expRemarks, to_char(experiance_from,'dd/mm/yyyy') exFrom,to_char(experiance_to,'dd/mm/yyyy') exTo FROM employee_experiance WHERE employee_id=?";

	public static String INSERT_EMPLOY_EXPERIANCE = "INSERT INTO employee_experiance(employee_id, organization_name, year_of_experiance, designation,remarks, experiance_from, experiance_to,contactname,contactno) VALUES (?, ?, ?, ?,?, to_date(?,'dd/MM/yyyy'), to_date(?,'dd/MM/yyyy'),?,?)";

	public static String SELECT_PHONE_NO = "SELECT phone_no as presentPhoneNo FROM employee_phone_no where present_address_id=?";

	public static String SELECT_PRESENT_ADDRESS = "SELECT present_address_id, present_address as presentAddress, present_place as presentPlace, present_district as presentDistrict,present_state as presentState," + " present_pincode as presentPin FROM employee_present_address where employee_id=? ";

	public static String INSERT_PRESENT_ADDRESS = "INSERT INTO employee_present_address(present_address, present_place, present_district,present_state," + " present_pincode, employee_id)VALUES (?, ?, ?, ?, ?, ?)RETURNING present_address_id";

	public static String INSERT_PHONE_NO = "INSERT INTO employee_phone_no( employee_id, present_address_id, phone_no) VALUES (?, ?, ?)";

	public static String INSERT_MOBILE_NO = "INSERT INTO employee_mobile_no(employee_id, present_address_id, mobile_no) VALUES (?, ?, ?)";

	// public static String SELECT_EMPLOYEE_NAME_LIST =
	// "select employee_id as id,first_name as text,employee_id empId,first_name firstName from employee order by first_name ASC";

	public static String SELECT_EMPLOYEE_NAME_LIST = "select concat(first_name,' ',surname) as empName, concat(first_name,' ',surname) as text , employee_id as empId , employee_id as id from employee join branch_department on employee.branch_department_id=branch_department.branch_department_id inner join branch on branch.branch_id = branch_department.branch_id inner join company c on c.company_id = branch.company_id where  employee.status = true and c.company_id = ?";

	public static String userIdAutoGen = " SELECT CASE WHEN MAX(employee_id) IS NULL THEN 'E0001' ELSE rpad(MAX(employee_id),1,'E')|| lpad(cast(cast((SUBSTRING(MAX(employee_id),4)) as int)+1 as text),4,'0') END FROM employee ";

	// public static String GET_MAX_EMPLOYEE_ID =
	// "select CASE WHEN max(empid) is null then 0 else max(empid) end maxEmpId from( "
	// +
	// "select cast((substr(employee_id, 2, char_length(employee_id))) as int ) empid from employee) temp";

	public static String GET_MAX_EMPLOYEE_ID = "select CASE WHEN max(empid) is null then 0 else max(empid) end maxEmpId from(      select cast((substr(employee_id, 2, char_length(employee_id))) as int ) empid from employee where employee_id <> 'admin' and length(employee_id) = 5 and employee_id like 'E%') temp";

	public static String SELECT_MOBILE_NO = "SELECT mobile_no as presentMobileNo FROM employee_mobile_no where present_address_id = ?";

	public static String DELETE_PRESENT_ADDRESS = "DELETE FROM employee_present_address WHERE employee_id=?";

	public static String DELETE_MOBILE_NO = "DELETE FROM employee_mobile_no  WHERE employee_id=?";

	public static String DELETE_PHONE_NO = "DELETE FROM employee_phone_no  WHERE employee_id=?";

	public static String SELET_EMP_EDU = "SELECT specialization,employee_id empId,emp_edu_id empEduId,qualification qualification, percentage percentage, cource_type courseType, institution institution,year_of_passing yearPassed  FROM employee_education where employee_id=?";

	public static String SELET_EMP_MERITS = "SELECT employee_id empId, employee_merits_id empMeritId, award_name awardName, scholarship_name scholarshipName, description meritDesc FROM employee_merits where employee_id=?";

	// public static String SELET_EMP_FAMILY =
	// "SELECT employee_id empId,emp_family_id empFamilyId, relative_name familyName,sex genderType, relation_to_employee relationshipWithEmp, dependent_on_employee empDependence,img_url uploadPhotoFamily FROM employee_family where employee_id=? ";

	public static final String SELECT_EMP_FAMILY = "SELECT aadhar_no aadharno,mobile_no mobileno,employee_id employeeId,dependent_id dependentId,dependent_dob dependentDob,age,sex,relative_name relativeName,relation_to_employee relationToEmployee,dependent_on_employee dependentOnEmployee,dependent_passport_no dependentPassportNo,dependent_passport_issued_date dependentPassportIssuedDate,dependent_passport_expiry_date dependentPassportExpiryDate,dependent_passport_issued_place dependentPassportIssuedPlace,dependent_visa_reference_number dependentVisaReferenceNumber,dependent_visa_type dependentVisaType,dependent_visa_issued_place dependentVisaIssuedPlace,dependent_visa_issued_date dependentVisaIssuedDate,dependent_visa_expiration_date dependentVisaExpirationDate,dependent_photo_url dependentPhotoUrl,dependent_medical_entitlement dependentMedicalEntitlement FROM employee_family WHERE employee_id=?";

	public static String SELET_EMP_NOMINATION = "SELECT employee_id EmpId,employee_nom_id employeeNomId,employee_nominee_name nominateName, sex nominateGender, occupation nominateOccupation," + " relationship nominateRelationship,email nominateEmail, to_char(dob,'dd/mm/yyyy') nomdateOfBirth, address nomineAddress, pincode nominatePincode, " + "place nominatePlace, phone_no emergPhone, mobile_no emergMobile  FROM employee_nominee where employee_id=?";

	public static String SELET_EMP_REFERENCE = "SELECT employee_id empId, emp_ref_id empRefId,employee_reference_name referenceName, occupation occupationRef, email emailRef," + " relationship relationshipRef,pincode pincodeRef, address referenceAddress, phone_no emergPhone  FROM employee_references where emp_ref_id=?";

	public static String SELET_EMP_EMERGENCY = "SELECT employee_id EmpId,empl_emer_id emplEmerId, emergency_contact_name emergencyName, occupation emergencyOccu, relationship emergRelationship, " + "email emergEmail,place emergPlace, address emerAddress, pincode emergencyPincode,phone_no emergPhone, mobile_no emergMobile FROM employee_emergency_contact where employee_id=?";

	public static String SELET_EMP_AWARD_ID = "SELECT employee_id empId, employee_merits_id empMeritId, award_name awardName, scholarship_name scholarshipName, description meritDesc FROM employee_merits where employee_merits_id=?";

	// public static String SELET_EMP_FAMILY_ID =
	// "SELECT employee_id empId,emp_family_id empFamilyId, relative_name familyName,case sex when true then 'Male' else 'Female' end genderType, relation_to_employee relationshipWithEmp, dependent_on_employee empDependence,img_url uploadPhotoFamily FROM employee_family where emp_family_id=? ";

	public static final String SELECT_EMP_FAMILY_BY_DEPENDID = "SELECT aadhar_no aadharno,mobile_no mobileno,employee_id employeeId,dependent_id dependentId,to_char(dependent_dob,'DD/MM/YYYY') dependentDob,age,sex,relative_name relativeName,relation_to_employee relationToEmployee,dependent_on_employee dependentOnEmployee,dependent_passport_no dependentPassportNo,to_char(dependent_passport_issued_date,'DD/MM/YYYY') dependentPassportIssuedDate,to_char(dependent_passport_expiry_date,'DD/MM/YYYY') dependentPassportExpiryDate,dependent_passport_issued_place dependentPassportIssuedPlace,dependent_visa_reference_number dependentVisaReferenceNumber,dependent_visa_type dependentVisaType,dependent_visa_issued_place dependentVisaIssuedPlace,to_char(dependent_visa_issued_date,'DD/MM/YYYY') dependentVisaIssuedDate,to_char(dependent_visa_expiration_date,'DD/MM/YYYY') dependentVisaExpirationDate,dependent_photo_url dependentPhotoUrl,dependent_medical_entitlement dependentMedicalEntitlement FROM employee_family WHERE dependent_id=?";

	public static String SELET_EMP_EXP_ID = "SELECT contactname,contactno,employee_id empId,emp_exp_id empExpId, organization_name organization, year_of_experiance experienceYear, designation expDesisnation, remarks expRemarks, to_char(experiance_from,'dd/mm/yyyy') exFrom,to_char(experiance_to,'dd/mm/yyyy') exTo FROM employee_experiance WHERE emp_exp_id=?";

	public static String SELET_EMP_EDU_ID = "SELECT specialization,employee_id empId,emp_edu_id empEduId,qualification qualification, percentage percentage, cource_type courseType, institution institution,year_of_passing yearPassed  FROM employee_education where emp_edu_id=?";

	public static String UPDATE_EMP_EDU = "UPDATE employee_education SET specialization=?,qualification=?,percentage=?, cource_type=?, institution=?, year_of_passing=? WHERE emp_edu_id=?";

	// public static String UPDATE_EMP_FAMILY =
	// "UPDATE employee_family  SET relative_name=?,sex=?, relation_to_employee=?, dependent_on_employee=?, img_url=? WHERE emp_family_id=? ";

	public static String UPDATE_EMP_FAMILY = "UPDATE employee_family SET aadhar_no=:aadharno1,mobile_no=:mobileno,dependent_dob=:dependentDob, age=:age,sex=:sex,relative_name=:relativeName,relation_to_employee=:relationToEmployee,dependent_on_employee=:dependentOnEmployee,dependent_passport_no=:dependentPassportNo,dependent_passport_issued_date=:dependentPassportIssuedDate,dependent_passport_expiry_date=:dependentPassportExpiryDate,dependent_passport_issued_place=:dependentPassportIssuedPlace,dependent_visa_reference_number=:dependentVisaReferenceNumber,dependent_visa_type=:dependentVisaType,dependent_visa_issued_place=:dependentVisaIssuedPlace,dependent_visa_issued_date=:dependentVisaIssuedDate,dependent_visa_expiration_date=:dependentVisaExpirationDate,dependent_photo_url=:dependentPhotoUrl,dependent_medical_entitlement=:dependentMedicalEntitlement WHERE dependent_id=:dependentId ";

	public static String UPDATE_EMP_EXPERIANCE = "UPDATE employee_experiance SET organization_name=?,year_of_experiance=?, designation=?,remarks=?, experiance_from=to_date(?,'dd/mm/yyyy'), experiance_to=to_date(?,'dd/mm/yyyy'),contactname=?,contactno=? WHERE emp_exp_id=? ";

	public static String UPDATE_EMP_MERITS = "UPDATE employee_merits SET award_name=?,scholarship_name=?, description=? WHERE employee_merits_id=? ";

	public static String SELET_EMP_REF_ID = "SELECT employee_id empId,emp_ref_id empRefId, employee_reference_name referenceName, occupation occupationRef," + " email emailRef, relationship relationshipRef,pincode pincodeRef, address referenceAddress,phone_no emergPhone FROM employee_references where employee_id=?";

	public static String SELET_EMP_Phone_No = "SELECT empid empId,emp_ref_ph_id empRefId, phone_no emergPhone FROM employee_ref_phoneno where emp_ref_ph_id=?";

	public static String SELET_EMP_NOM_MOB_No = "SELECT employee_id empId,nomination_mobile_id employeeNomId,mobile_no emergMobile FROM employee_nomination_mobile where nomination_mobile_id=?";

	public static String SELET_EMP_NOM_PH_No = "SELECT employee_id empId,nomination_phone_id employeeNomId,phone_no emergPhone FROM employee_nomination_phone where nomination_phone_id=?";

	public static String SELET_EMP_EME_Phone = "SELECT employee_id empId,emer_phone_id emplEmerId, phone_no emergPhone FROM employee_emergency_phone where emer_phone_id=?";

	public static String SELET_EMP_EME_MOBILE = "SELECT employee_id empId,emer_mobile_id emplEmerId,mobile_no emergMobile FROM employee_emergency_mobile where emer_mobile_id=?";

	public static String DELETE_PHONE_REF = "DELETE FROM employee_ref_phoneno WHERE emp_ref_ph_id=?";

	public static String UPDATE_REF_EMPLOYEE = "UPDATE employee_references SET occupation=?, email=?, relationship=?,pincode=?,address=?," + "employee_reference_name=?,phone_no=? WHERE emp_ref_id=?";

	public static String INSERT_REF_PHONE_NO = "INSERT INTO employee_ref_phoneno (empid,emp_ref_ph_id,phone_no) VALUES (?,?,?)";

	public static String DELETE_PHONE_EME = "DELETE FROM employee_emergency_phone WHERE emer_phone_id=?";

	public static String DELETE_MOBILE_EME = "DELETE FROM employee_emergency_mobile WHERE emer_mobile_id=?";

	public static String DELETE_PHONE_NOM = "DELETE FROM employee_nomination_phone WHERE nomination_phone_id=?";

	public static String DELETE_MOBILE_NOM = "DELETE FROM employee_nomination_mobile WHERE nomination_mobile_id=?";

	public static String UPDATE_MOBILE_NOM = "UPDATE employee_nominee SET aadhar_no=?,employee_nominee_name=?, sex=?, occupation=?,relationship=?, email=?, dob=to_date(?,'dd/mm/yyyy'), address=?,pincode=?, place=?, phone_no=?,mobile_no=? WHERE employee_nom_id=?";

	public static String UPDATE_EMER_EMPLOYEE = "UPDATE employee_emergency_contact SET emergency_contact_name=?, occupation=?, relationship=?, email=?,place=?, " + "address=?, pincode=?,phone_no=?,mobile_no=? WHERE  empl_emer_id=?";

	public static String INSERT_EMER_MOBILE_NO = "INSERT INTO employee_emergency_mobile(employee_id,emer_mobile_id, mobile_no)VALUES (?,?,?)";

	public static String INSERT_EMER_PHONE_NO = "INSERT INTO employee_emergency_phone(employee_id,emer_phone_id, phone_no) VALUES (?,?,?)";

	public static String INSERT_NOM_MOBILE_NO = "INSERT INTO employee_nomination_mobile(employee_id,nomination_mobile_id,mobile_no) VALUES (?,?,?)";

	public static String INSERT_NOM_PHONE_NO = "INSERT INTO employee_nomination_phone(employee_id, nomination_phone_id,phone_no) VALUES (?,?,?)";

	public static String SELECT_FAMILY_BY_ID = "SELECT aadhar_no aadharno,mobile_no mobileno,employee_id employeeId,dependent_id dependentId,dependent_dob dependentDob,age,sex,relative_name relativeName,relation_to_employee relationToEmployee,dependent_on_employee dependentOnEmployee,dependent_passport_no dependentPassportNo,dependent_passport_issued_date dependentPassportIssuedDate,dependent_passport_expiry_date dependentPassportExpiryDate,dependent_passport_issued_place dependentPassportIssuedPlace,dependent_visa_reference_number dependentVisaReferenceNumber,dependent_visa_type dependentVisaType,dependent_visa_issued_place dependentVisaIssuedPlace,dependent_visa_issued_date dependentVisaIssuedDate,dependent_visa_expiration_date dependentVisaExpirationDate,dependent_photo_url dependentPhotoUrl,dependent_medical_entitlement dependentMedicalEntitlement FROM employee_family WHERE employee_id=?";

	public static String SELECT_EDUCATION_BY_ID = "SELECT employee_id empId,emp_edu_id empEduId, qualification qualification, percentage percentage, cource_type courseType, institution institution,year_of_passing yearPassed  FROM employee_education where employee_id=?";

	public static String SELECT_EXPERIENCE_BY_ID = "SELECT employee_id empId, organization_name organization, year_of_experiance experienceYear, designation expDesisnation, remarks expRemarks, to_char(experiance_from,'dd/mm/yyyy') exFrom,to_char(experiance_to,'dd/mm/yyyy') exTo FROM employee_experiance WHERE employee_id=?";

	public static String SELECT_MERITS_BY_ID = "SELECT employee_id empId, employee_merits_id empMeritId, award_name awardName, scholarship_name scholarshipName, description meritDesc FROM employee_merits where employee_id=?";

	public static String DELETE_NOMINATION = "DELETE FROM employee_nominee WHERE employee_nom_id=?";

	public static String DELETE_EMERGENCY = "DELETE FROM employee_emergency_contact WHERE empl_emer_id=?";

	public static String DELETE_REFERENCE = "DELETE FROM employee_references WHERE emp_ref_id=?";

	public static String DELETE_EDUCATION = "DELETE FROM employee_education WHERE emp_edu_id=?";

	public static final String DELETE_FAMILY = "DELETE FROM employee_family WHERE dependent_id=?";

	public static final String INSERT_EMPLOYEE_DUPLICATE_SUBDATA = "insert into employee_duplicate(employee_id,employee_date,column_name,old_value,new_value,comments) values(:empId,:employmentDate,:columnName,:oldValue,:newValue,:comments)";

	public static final String SELET_EMP_DUPLICATE_ID = "select e.employee_id as employeeId,e.first_name as employeeName,TO_CHAR(ep.employee_date,'dd/mm/yyyy') as employmentDate,ep.column_name as columnName,ep.old_value as oldValue,ep.new_value as newValue,ep.comments from employee_duplicate ep left join employee e on e.employee_id = ep.employee_id where ep.employee_id = ? order by ep.employee_date desc";

	public static final String DELETE_EMPLOYEE_DUPLICATE = "Delete from employee_duplicate where employee_id=?";

	public static final String sCheckESICNo = "SELECT count(*) FROM employee WHERE LOWER(esic_code)=LOWER(?)";

	public static String DELETE_MERIT = "DELETE FROM employee_merits WHERE employee_merits_id=?";

	public static String DELETE_EXPERIENCE = "DELETE FROM employee_experiance WHERE emp_exp_id=?";

	public static String SELET_EMP_DOC = "SELECT empid empId, document_name docName, description description, img_url uploadDoc, emp_doc_id empDocId FROM employee_master_documents where empid=?";

	public static String UPDATE_EMP_DOC = "UPDATE employee_master_documents SET document_name=?, description=?, img_url=? WHERE emp_doc_id=?";

	public static String DELETE_DOC = "DELETE FROM employee_master_documents WHERE emp_doc_id=?";

	// public static String INSERT_PROBATION =
	// "INSERT INTO employee_probation(empid, from_probation, to_probation, extend,duration, break_any,"
	// +
	// " break_from_probation, break_to_probation,break_duration,completion_date)VALUES (:empId, to_date(:frmProbation,'dd/mm/yyyy'), to_date(:toProbation,'dd/mm/yyyy'),:extend,:duration,"
	// +
	// " :breakAny,to_date(:frmBreProbation,'dd/mm/yyyy'),to_date(:toBreProbation,'dd/mm/yyyy'),:breakDuration,to_date(:completion,'dd/mm/yyyy'))";

	// public static String INSERT_PROBATION_UPDATE =
	// "INSERT INTO employee_probation(empid, from_probation, to_probation, extend,duration, break_any,"
	// +
	// " break_from_probation, break_to_probation,break_duration,completion_date)VALUES (?, to_date(?,'dd/mm/yyyy'), to_date(?,'dd/mm/yyyy'),?,?,"
	// +
	// " ?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,to_date(?,'dd/mm/yyyy'))";

	// public static String SELET_EMP_PROBATION_ID =
	// "SELECT emp_probation_id empProbationId, empid empId, to_char(from_probation,'dd/mm/yyyy') frmProbation,  to_char(to_probation,'dd/mm/yyyy')toProbation, extend,duration, break_any breakAny,to_char(break_from_probation,'dd/mm/yyyy') frmBreakPro, to_char(break_to_probation,'dd/mm/yyyy') toBreakPro, to_char(completion_date,'dd/mm/yyyy')completion, coalesce(break_duration,0) breakDuration FROM employee_probation where emp_probation_id=?";

	// public static String SELET_EMP_PRO_EMP_ID =
	// "SELECT emp_probation_id empProbationId, empid empId, from_probation frmProbation, "
	// +
	// "to_probation toProbation, extend extend,duration duration, break_any breakAny, break_from_probation frmBreakPro,"
	// + " break_to_probation toBreakPro,completion_date completion," +
	// " coalesce(break_duration,0) breakDuration FROM employee_probation where empid=?";

	// public static String UPDATE_EMP_PROBATION =
	// "UPDATE employee_probation  SET from_probation=to_date(?,'dd/mm/yyyy'), to_probation=to_date(?,'dd/mm/yyyy'), extend=?, duration=?, break_any=?, "
	// +
	// "break_from_probation=to_date(?,'dd/mm/yyyy'), break_to_probation=to_date(?,'dd/mm/yyyy'),completion_date=to_date(?,'dd/mm/yyyy'), break_duration=? WHERE emp_probation_id=?";

	// public static String DELETE_PROBATION =
	// "DELETE FROM employee_probation WHERE emp_probation_id=?";

	public static String SELET_EMP_PERSONAL_ID = "SELECT  marital_status marritalStatus, coalesce(fa_hus_guardian_name,'') guardianName, coalesce(blood_group,0) bloodGrp,coalesce(caste,'') caste,coalesce(religion,'') religion," + "coalesce(mother_tongue,'') motherTongue,coalesce(nationality,'') nationality,coalesce(pan_no,'') panNo,coalesce(aadhar_no,'') aadharno, coalesce(gratuity_nominee,'') gratuityNominee, coalesce(gratuity_nominee_relation,'') nomineeRelation,"
			+ "coalesce(mode_of_conveyence,'') modeConveyence, coalesce(emergency_contact_no,'') emgContactNo, coalesce(emergency_contact_name,'') emgContactName," + "coalesce(notice_period_tobe_served,0) noticePeriod, remarks remarks, hobbies hobbies, status personalStatus,  to_char(conformation_date,'dd/mm/yyyy') confirmDate," + "to_char(resignation_date,'dd/mm/yyyy') resignationDate, employee_id empId, languages_known languages,coalesce(confirmation_period,0) confirmationPeriod," + "marriage_date marriageDate, husband_wife_name husbWifeName"
			+ " FROM employee_personalinfo where employee_id = ?";

	public static String SELET_EMP_RULE_ID = "SELECT employee_id empId, overtime_applicable overTime, esi_applicable esiApp, late_applicable lateApp," + "telephone_limit telephoneLimit, pf_applicable pfApp,medical_limit medicalLimit," + "is_encashable leaveOption,early_exit_applicable earlyExit  FROM employee_rule where employee_id=?";

	public static String SELET_EMP_PER_DETAIL_ID = "SELECT employee_id empId, bank_account_no accountNo, bank_name bankName, bank_place bankPlace," + "passport_no passportNo, to_char(passport_issued_date,'dd/mm/yyyy') issuedDate, to_char(passport_expiry_date,'dd/mm/yyyy') expiryDate, passport_issued_place issuedPlace," + "driving_license_no licenseNo, license_type licenseType, to_char(license_issued_date,'dd/mm/yyyy') licenseIssuedDate,"
			+ "to_char(license_expiry_date,'dd/mm/yyyy') licenseexpiryDate, to_char(license_renewal_date,'dd/mm/yyyy') renewalDate, creditcard_no, creditcard_name," + " visa_reference_number visaRefNo,visa_type visaType, visa_issued_place visaIssuedPlace, to_char(visa_issued_date,'dd/mm/yyyy') visaIssuedDate," + "to_char(visa_expiration_date,'dd/mm/yyyy') visaExpiryDate,iscash isActiveCash  FROM employee_documents where employee_id=?";

	public static String SELET_EMP_PHYSICAL_ID = "SELECT employee_id empId, physically_handicaped_eye isActiveSight, physically_handicaped_dumb isActiveDumb," + "physically_handicaped_hearing isActiveHearing, physically_handicaped_hand isActiveHand, physically_handicaped_feet isActiveFeet," + "height height, weight weight, coalesce(right_eye_sight_power,0) rightSidePower, coalesce(left_eye_sight_power,0) leftSidePower  FROM employee_physical where employee_id=?";

	public static String SELET_EMP_ADDRESS_ID = "SELECT employee_id empId, permanent_address permAddress, permanent_place permPlace, permanent_district permDistrict,permanent_state permState, permanent_pincode permPin, permanent_phoneno permPhone, permanent_mobileno permMobile, present_address presentAddress , present_place presentPlace,present_district presentDistrict, present_pincode presentPin, present_phoneno presentPhone, present_mobileno presentMobile FROM employee_address where employee_id=?";

	public static String SELET_EMP_EMERGENCY_ID = "SELECT employee_id EmpId,empl_emer_id emplEmerId, emergency_contact_name emergencyName, occupation emergencyOccu, relationship emergRelationship, " + "email emergEmail,place emergPlace, address emerAddress, pincode emergencyPincode,phone_no emergPhone, mobile_no emergMobile FROM employee_emergency_contact where empl_emer_id=?";

	public static String SELET_EMP_NOMINATION_ID = "SELECT aadhar_no aadharno2,employee_id EmpId,employee_nom_id employeeNomId,employee_nominee_name nominateName, sex nominateGender, occupation nominateOccupation," + " relationship nominateRelationship,email nominateEmail, to_char(dob,'dd/mm/yyyy') nomdateOfBirth, address nomineAddress, pincode nominatePincode, " + "place nominatePlace, phone_no emergPhone, mobile_no emergMobile FROM employee_nominee where employee_nom_id=?";

	public static String SELET_EMP_PERSONAL_COUNT = "select count(employee_id) from employee_personalinfo where employee_id=?";

	public static String SELET_EMP_ADDRESS_COUNT = "select count(employee_id) from employee_address where employee_id=?";

	public static String SELET_EMP_RULE_COUNT = "select count(employee_id) from employee_rule where employee_id=?";

	public static String SELET_EMP_PER_DETAIL_COUNT = "select count(employee_id) from employee_documents where employee_id=?";

	public static String SELET_EMP_PHYSICAL_COUNT = "select count(employee_id) from employee_physical where employee_id=?";

	public static String SELECT_YEAR_LIST = "select c.y as yearPassed from generate_series(1950, 2050) as c(y)";

	public static String getPrincipalCount = "select count(*) from employee where principal = true";

	public static String getMsCount = "select count(*) from employee where ms = true";

	public static String getPrincipalList = "select emp_id as id, first_name as text from employee_master where principal = true";

	public static String getMSList = "select emp_id as id, first_name as text from employee_master where ms = true";

	public static final String sCheckPANNo = "select count(*) from employee_personalinfo where LOWER(pan_no) = LOWER(?)";

	public static final String sCheckEPFNo = "SELECT count(*) FROM employee_master WHERE LOWER(epf_no)=LOWER(?)";

	public static final String COUNT_USERID = "select count(emp_user_id) from employee_master where lower(emp_user_id)=lower(?)";

	public static final String GET_EMPLOYEE_ID = "select emp_id from employee_master where lower(first_name) = lower(?)";

	public static final String GET_SHIFT_ID = "select shift_id from shift where lower(shift_name) = lower(?)";

	public static final String GET_DEPARTMENT_ID = "select department_id from department where lower(department_name) = lower(?)";

	public static final String insertManageUser = "insert into manage_user(first_name, middle_name, last_name, gender, dob, email, user_id,password,chat_password,profile_imageurl,employee_retailer_id,userflag,activationflag,is_active,marital_status,blood_group) values(?,?,?,?,?,?,?,?,?,?,?,'w','activated',true,0,0)";

	public static final String insertUserRetailer = "insert into user_retailer (user_id,retailer_id,created_by,retailer_bcode,bcode_img_url,bcode_base_img_url,created_date,delete_status) values (?,?,?,?,?,?,now(),false)";

	public static final String maxRBCode = "select max(retailer_bcode)+1 as maxRBCode from user_retailer";

	public static final String updateMURetailerId = "update manage_user set employee_retailer_id=? where user_id=?";

	public static final String checkEmail = "select count(*) from employee_master where lower(email_id)=lower(?)";

	public static final String GET_BLOOD_NAME = "select blood_group_name from blood_group where blood_group_id=?::int";

}
