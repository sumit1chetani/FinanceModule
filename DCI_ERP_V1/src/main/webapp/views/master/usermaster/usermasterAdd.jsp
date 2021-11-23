<style>
.field_set {
	border-color: #606060;
	border-style: solid;
}

.setBorder {
	border-style: solid;
	border-width: 1px;
}

/* a:link {
	//color: #200000;
} */
/* a:link {
	text-decoration: none;
} */
a:visited {
	text-decoration: none;
}

.displaynone {
	display: none;
}

.displayblock {
	display: inline-block;
}
/* .nav>li>a {
    position: relative;
    display: block;
    padding: 14px 10px;
} */
a:hover {
	text-decoration: underline;
}

.ngdialog-content {
	background: #fff !important;
}

.tab-head {
	background: dodgerblue !important;
	color: black;
}

div#dependVisa1>ul {
	margin-left: -43% !important;
}

div#dependVisa>ul {
	margin-top: -75% !important;
}
</style>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<!--  <tab heading="{{tabs[0].title}}" class="tab-head"
				active="tabs[0].active" ng-click="setInActive(0);"> -->
			<form class="form-horizontal" name="frmProfile" id="profileForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row" style="padding-bottom: 13%;">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<div class="form-group displaynone" id="employeeId">
								<label class="col-md-4 control-label"
									ng-if="isEdit || profileEdit">Employee ID<span
									style="color: red;">*</span></label>
								<!-- <label class="col-md-1 control-label" ng-if="EmployeeMasterData.isEdit" style=" padding-right: 0px; ">{{EmployeeMasterData.empId}}</label> -->
								<div class="col-md-5" ng-if="isEdit || profileEdit">
									<input type="text" class="form-control input-sm"
										name="Employee Id" ng-model="employeeId" validation="required"
										data-message-id="empId" friendly-name="Employee Id"
										maxlength="5" disabled>
									<!-- ng-if="!EmployeeMasterData.isEdit" -->
								</div>
							</div>
						
							
							
							<div class="form-group">
								<label class="col-md-4 control-label">First Name <span
									style="color: red;">*</span></label>
								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm"
										ng-model="EmployeeMasterData.firstName" name="firstName"
										data-message-id="firstName" validation="required"
										friendly-name="First Name" maxlength="40">
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label">Middle Name <span
									style="color: red;"></span></label>
								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm"
										name="middleName" ng-model="EmployeeMasterData.middleName"
										maxlength="15">
								</div>
							</div>
							
							
							

							

							
							
							
							<div class="form-group" ng-init="EmployeeMasterData.gender='M'">
								<label class="col-md-4 control-label">Gender</label>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" class=""
										name="gender" value="M" ng-model="EmployeeMasterData.gender">
										<i></i> Male
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" class=""
										name="gender" value="F" ng-model="EmployeeMasterData.gender">
										<i></i> Female
									</label>
								</div>
								
							</div>

							
							

							

							

						

							
							
								
							
							
							
								<div class="form-group">
								<label class="col-md-4 control-label">DOJ </label>
								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="EmployeeMasterData.doj"
										id="doj" name="doj" form-name="frmProfile" friendly-name="DOJ" style="border-color:#e5dcdb" 
										 />
								</div>

							</div>
							<div class="form-group ">
									<label class="col-md-4 control-label">Department  <span
									style="color: red;">*</span>
									</label>
									<div class="col-md-5">
										<selectivity list="departmentList"
											property="EmployeeMasterData.departmentId"
											ng-model="EmployeeMasterData.departmentId"
											 
											friendly-name="Department" name="Department Name"
											form-name="frmProfile" validation="required"></selectivity>

									</div>
								</div>
								
								
								
								<div class="form-group" >
								<label class="col-md-4 control-label"> Is Department Contact<span
									style="color: red;"></span>

								</label>
								<div class="col-md-5">
									<div class="checkbox">
										<label> <input type="checkbox"
											class="checkbox style-0" ng-model="EmployeeMasterData.deptContact"
											name="deptContact" > <span></span>
										</label>
									</div>
								</div>
							</div>
								
								
								<div class="form-group ">
									<label class="col-md-4 control-label">Organization<span style="color: red;">*</span></label>
									<div class="col-md-5">
										<selectivity list="companyList"
											property="EmployeeMasterData.companyCode"
											ng-model="EmployeeMasterData.companyCode"
										validation="required" id="companyCode"
											friendly-name="Branch" name="organizationCode"
											form-name="frmProfile"></selectivity>

									</div>
								</div>
								
									<div class="form-group ">
									<label class="col-md-4 control-label">Country </label>
									<div class="col-md-5">
										<selectivity list="countryList"
											property="EmployeeMasterData.country"
											ng-model="EmployeeMasterData.country"
											friendly-name="Country Name" name="Country Name"
											form-name="frmProfile" ></selectivity>

									</div>
								</div>
							
							
							<div class="form-group">
								<label class="col-md-4 control-label">User Location</label>
								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm"
										ng-model="EmployeeMasterData.userlocation" name="userlocation"
										data-message-id="userlocation"
										friendly-name="User Location" maxlength="40">
								</div>
							</div>

								<div class="form-group" >
								<label class="col-md-4 control-label"> Active<span
									style="color: red;"></span>

								</label>
								<div class="col-md-5">
									<div class="checkbox">
										<label> <input type="checkbox"
											class="checkbox style-0" ng-model="EmployeeMasterData.status"
											name="status" data-ng-true-value="'Y'"
											data-ng-false-value="'N'"> <span></span>
										</label>
									</div>
								</div>
							</div>
							<div  class="form-group" ng-if="!isEdit || !profileEdit"> 
        <label class="col-md-4 control-label">
        Agent / Depot
        </label>
        <div class="col-md-5">
         <div class="checkbox">
          <label >
           <input type="checkbox" class="checkbox style-0"  ng-disabled="true" name="vendor" ng-true-value="'Y'"
												ng-false-value="'N'"
            ng-model="EmployeeMasterData.vendor" ng-click="agent(EmployeeMasterData.vendor)" >
           <i></i>
          </label>
         </div>
        </div>
       </div>
       
       <div  class="form-group" ng-if="isEdit || profileEdit">
        <label class="col-md-4 control-label">
        Is Agent / Depot
        </label>
        <div class="col-md-4">
         <label class="col-md-4 control-label"> {{EmployeeMasterData.vendorShow}}</label>
        </div>
       </div>
       
       
       
       
       
       
       
       	<div class="form-group" >
								<label class="col-md-4 control-label"> File Attachment
												</label>
												<div class="col-md-5">
													<div class="input-group">
														<input type="file" class="form-control btn-primary"
															class="form-control input-sm" friendly-name="File Upload"
															name="excelfile" ng-model="excelfile"
															
															onchange="angular.element(this).scope().uploadFile(this)" />

														<span class="input-group-btn ">
															<button class="btn btn-info input-sm" type="button"
																ng-click="adduploadfiles1()" data-toggle="tooltip"
																title="Add File">
																<i class="fa fa-plus"></i>
															</button>
														</span>
													</div>
												</div>
											</div>
												<div style="padding-left: 53%;" ng-repeat="(tIndex, filelist) in EmployeeMasterData.files1">
							<a id="tbnewExport{{tIndex}}" style="display: none"
								href="filePath/{{EmployeeMasterData.employeeId}}/{{filelist.filename}}"
								download="{{filelist.filename}}"></a>
							<div ng-if="filelist.employeeId!=''">
								{{tIndex+1}} ) <a ng-click="downloadNewFile(tIndex)"
									style="color: green">{{filelist.filename}}</a>
							</div>

							<div ng-if="filelist.employeeId==''">
								{{tIndex+1}} ) <a style="color: green">{{filelist.filename}}</a>
								<button class="btn btn-default input-sm" type="button"
									ng-click="deleteuploadfiles1(filelist.filename)"
									data-toggle="tooltip" title="Delete file">
									<i class="fa fa-trash"></i>
								</button>
							</div>

						</div>
							
						
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6">

							<fieldset>
								
								
									
								
								<div class="form-group" id="pass" ng-if="!isEdit">
								<label class="col-md-4 control-label">Password<span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<input type="password" class="form-control input-sm" maxlength="30"
										id="password" name="Password"
										ng-model="EmployeeMasterData.pwd" validation="required"
										friendly-name="Password" 
										>
								</div>
								
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Last Name<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="lastName" ng-model="EmployeeMasterData.lastName"
										maxlength="25">
								</div>
							</div>
								

<div class="form-group">
								<label class="col-md-4 control-label">Email ID</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="emailId"
										ng-model="EmployeeMasterData.emailId"
										placeholder='your@email.com'
										friendly-name="Email ID" form-name="frmProfile"
										maxlength="250">
								</div>
							</div>
<div class="form-group">
								<label class="col-md-4 control-label">DOB</label>

								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="EmployeeMasterData.dob"
										id="dateofbirth" name="dateofbirth" form-name="frmProfile" friendly-name="dob"
										/>
								</div>
							</div>
<div class="form-group">
								<label class="col-md-4 control-label"> Mobile No.</label>

								<div class="col-md-5  padding-left-4 ">
									<input type="text" class="form-control input-sm" maxlength="15"
										style="width: 100%;" name="mobileNo"
										ng-model="EmployeeMasterData.mobileNo"
										friendly-name="Mobile Number">
								</div>
							</div>
							
							<div class="form-group ">
									<label class="col-md-4 control-label">Designation</label>
									<div class="col-md-5">
										<selectivity list="designationList"
											property="EmployeeMasterData.designation"
											ng-model="EmployeeMasterData.designation"
										
											friendly-name="Designation Name" name="Designation Name"
											form-name="frmProfile"></selectivity>

									</div>
								</div>
								<div class="form-group">
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label"> Branch<span style="color: red;">*</span>
									</label>
									<div class="col-md-5 inputGroupContainer">
									<selectivity list="BranchListDetail"
											property="EmployeeMasterData.branchId"
											ng-model="EmployeeMasterData.branchId"
										validation="required"
											friendly-name="Branch" name="Branch"
											form-name="frmProfile"></selectivity>
											
										<!-- <select class="form-control journalVoucher-textBox"
											ng-model="EmployeeMasterData.branchId" id="id"
											name="branchId" data-message-id="id"
											friendly-name="Branch"
											ng-options="emp.id as emp.text for emp in BranchListDetail" validation="required"
											>
											<option value="" selected="selected">Select</option>
										</select> -->
									</div>
								</div>
								
								<div class="form-group" >
									<label class="col-md-4 control-label">  Agency / Depot
									</label>
									<div class="col-md-5 inputGroupContainer">
										<selectivity list="vendorList"
											property="EmployeeMasterData.customerName"
											ng-model="EmployeeMasterData.customerName"
											friendly-name="customerName" name="customerName"
											form-name="frmProfile" ></selectivity>
								
									<!-- 	<select class="form-control journalVoucher-textBox"
											ng-model="EmployeeMasterData.customerName" id="id"
											name="id" data-message-id="companyCode"
											 friendly-name="Branch"
											ng-options="emp.id as emp.text for emp in vendorList"
											>
											<option value="" selected="selected">Select</option>
										</select> -->
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label"> Port </label>
									<div class="col-md-5">
										<select id="port" multiple="multiple" name="port"
											ng-model="EmployeeMasterData.port"
											ng-options="option.text for option in portList"
											friendly-name="Port" data-dropdownmultiselect>
											<option data-ng-repeat="option in portList"
												value="{{getOptionId(option)}}"
												ng-selected="isOptionSelected(option)"
												data-ng-bind-template="{{option.text}}"></option>
										</select>
									</div>
								</div>
								

<div class="form-group">
									<label class="col-md-4 control-label"> Access Category </label>
									<div class="col-md-5">
										<select id="accessCat" multiple="multiple" name="accessCat"
											ng-model="EmployeeMasterData.accessCat"
											ng-options="option.text for option in accessCatList"
											friendly-name="accessCat" data-dropdownmultiselect>
											<option data-ng-repeat="option in accessCatList"
												value="{{getOptionId(option)}}"
												ng-selected="isOptionSelected(option)"
												data-ng-bind-template="{{option.text}}"></option>
										</select>
									</div>
								</div>
								
							</fieldset>
						</div>
					</div>
				</div>
				
				<div class="form-actions-tab">
					<div class="row" align="center">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit" type="button"
								ng-click="saveProfile(frmProfile,EmployeeMasterData)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" ng-if="isEdit"
							type="button"
								ng-click="updateProfileDet(frmProfile,EmployeeMasterData)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="button"
								data-ng-click="resetProfile(frmProfile)">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-danger" type="button"
								data-ng-click="cancel();">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
			<%-- </tab> <!-- /Address tab --> <tab heading="{{tabs[1].title}}"
				id="personalInfoTab" active="tabs[1].active" class="tab-head"
				ng-click="setInActive(1);" style="color: black;"><!-- ng-click="tabLabel(1);" -->
			<form class="form-horizontal" name="frmPersonalInfo"
				id="frmPersonalInfo" novalidate method="post"
				ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<div class="col-sm-6 col-md-6 col-lg-6">

							<!-- <div class="form-actions-tab">
											<div class="row">
												<div class="col-md-12" id="0">													
													
													<button class="btn btn-info" type="button"
													data-ng-click="next();" style="margin-left:969px;margin-top:-55px;">{{tabs[1].title}}
											<i class="fa fa-arrow-right"></i> 
										</button>
													
												</div>
											</div>
										</div> -->
							<button class="btn btn-info" type="button"
								data-ng-click="previous();" style="margin-right: 1029px;">
								<i class="fa fa-arrow-left"></i> {{tabs[1].title}}
							</button>
							<div class="form-group" >
								<label class="col-md-4 control-label">Marital Status <span
									style="color: red;">*</span>
								</label>
								<div class="radio radio-inline">


									<label class="i-checks"> <input type="radio"
										name="marriedStatus" ng-true-value="'true'"  ng-false-value="'false'" 
										ng-model="EmployeeMasterDataPersonal.marritalStatus">
										<i></i> Married{{EmployeeMasterDataPersonal.marritalStatus}}
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" 
										name="marriedStatus" ng-true-value="'true'"  ng-false-value="'false'" 
										ng-model="EmployeeMasterDataPersonal.marritalStatus">
										<i></i> UnMarried
									</label>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Father/Guardian
									Name <span style="color: red;"></span>
								</label>

								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm"
										name="Father Name" maxlength="50"
										ng-model="EmployeeMasterDataPersonal.guardianName">
								</div>
							</div>
							<!-- <div class="form-group">
												<label class="col-md-4 control-label">Mother Name <span style="color: red;"></span>
												</label>

												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="Mother Name"
														ng-model="EmployeeMasterDataPersonal.motherName">
												</div>
											</div> -->
							<!-- <div class="form-group">
												<label class="col-md-4 control-label">Guardian
													Name <span style="color: red;"></span>
												</label>

												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="Guardian Name"
														ng-model="EmployeeMasterDataPersonal.guardiansName">
												</div>
											</div> -->

							<div class="form-group">
								<label class="col-md-4 control-label">Husband/Wife Name
									<span style="color: red;"></span>
								</label>

								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm"
										name="husbWifeName" maxlength="50"
										ng-model="EmployeeMasterDataPersonal.husbWifeName">
								</div>
							</div>

							<div class="form-group ">
								<label class="col-md-4 control-label">Blood Group<span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									
									<selectivity list="bloodgrouplist"
										property="EmployeeMasterDataPersonal.bloodGrp" id="bloodGroup"
										ng-model="EmployeeMasterDataPersonal.bloodGrp"
										name="Blood Group" form-name="frmPersonalInfo" 
										friendly-name="Blood Group" validation="required">
									</selectivity>

								</div>
							</div>

							<!-- <div class="form-group">
												<label class="col-md-4 control-label">Caste<span
													style="color: red;"></span></label>
												<div class="col-md-5">
													<input type="text" class="form-control input-sm"
														name="caste" ng-model="EmployeeMasterData.caste">
												</div>
											</div>


											<div class="form-group">
												<label class="col-md-4 control-label">Religion<span
													style="color: red;"></span></label>
												<div class="col-md-5">

													<input type="text" class="form-control input-sm"
														name="religion" ng-model="EmployeeMasterData.religion">
												</div>
											</div> -->

							<div class="form-group">
								<label class="col-md-4 control-label">Religion<span
									style="color: red;"></span></label>
								<div class="col-md-5">

									<input type="text" class="form-control input-sm"
										name="religion" ng-model="EmployeeMasterDataPersonal.religion"
										maxlength="50">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Caste<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="caste"
										ng-model="EmployeeMasterDataPersonal.caste" maxlength="50">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Mother Tongue<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Mother Tongue"
										ng-model="EmployeeMasterDataPersonal.motherTongue"
										maxlength="50">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Languages Known<span
									style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Languages Known"
										ng-model="EmployeeMasterDataPersonal.languages">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Nationality<span
									style="color: red;"></span></label>
								<div class="col-md-5">

									<input type="text" class="form-control input-sm"
										name="Nationality"
										ng-model="EmployeeMasterDataPersonal.nationality"
										maxlength="50">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">AADHAR No</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										friendly-name="Aadhar No" name="aadharno"
										ng-model="EmployeeMasterDataPersonal.aadharno" maxlength="30"
										ng-pattern-restrict="^[0-9.]*$">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">PAN No</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										ng-blur="checkPersonalInfoPANNo(EmployeeMasterDataPersonal.panNo)"
										name="panNo" ng-model="EmployeeMasterDataPersonal.panNo"
									 friendly-name="Pan No" maxlength="50"
										numberschar-only>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Hobbies<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="hobbies"
										ng-model="EmployeeMasterDataPersonal.hobbies">
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label">Remarks<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<textarea ng-model="EmployeeMasterDataPersonal.remarks"
										name="remarks" class="form-control input-sm resize-none"
										rows="4">
	     											   </textarea>
								</div>
							</div>

						</div>

						<div class="col-sm-6 col-md-6 col-lg-6">
							<button class="btn btn-info" type="button"
								data-ng-click="next();"
								style="margin-left: 85%; margin-top: -4px;">
								{{tabs[2].title}} <i class="fa fa-arrow-right"></i>
							</button>
							<div class="form-group">
								<label class="col-md-4 control-label">Confirmation Date<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<ng-bs3-datepicker
										data-ng-model="EmployeeMasterDataPersonal.confirmDate"
										id="relieveDate" name="Confirmation Date" form-name="frmPersonalInfo"
										friendly-name="Confirmation Date" validation="required" />

								</div>
							</div>



							<div class="form-group">
								<label class="col-md-4 control-label">Confirmation
									Period<span style="color: red;"></span>
								</label>

								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm"
										name="confirmationPeriod"
										ng-model="EmployeeMasterDataPersonal.confirmationPeriod"
										placeholder="0.0" style="text-align: right" phonenumbers-only>
								</div>
								<span class="pull-left line-height-30">Months</span>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Gratuity Nominee <span
									style="color: red;"></span>
								</label>

								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm"
										name="Gratuity Nominee"
										ng-model="EmployeeMasterDataPersonal.gratuityNominee"
										maxlength="50">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Relation<span
									style="color: red;"></span></label>

								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm"
										name="Relation"
										ng-model="EmployeeMasterDataPersonal.nomineeRelation">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Mode of Conveyence<span
									style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Mode of Conveyence"
										ng-model="EmployeeMasterDataPersonal.modeConveyence"
										maxlength="50">
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label">Contact No(In Case
									of Emergency)<span style="color: red;"></span>
								</label>

								<div class="col-md-1  padding-left-4 padding-top-5">
									<label class="col-md-4 control-label">+91</label>
								</div>
								<div class="col-md-4  padding-left-4 padding-top-5">
									<input type="text" class="form-control input-sm"
										name="emgContactNo" maxlength="50" style="width: 100%;"
										ng-model="EmployeeMasterDataPersonal.emgContactNo"
										phonenumbers-only>
								</div>


							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Contact Name(In
									Case of Emergency)<span style="color: red;"></span>
								</label>
								<div class="col-md-5">

									<input type="text" class="form-control input-sm"
										name="Contact Name" maxlength="50"
										ng-model="EmployeeMasterDataPersonal.emgContactName">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Resignation Date<span
									style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<div class='input-group date datetimepick'>
										<div class="dropdown" style="margin-top: -15px;">
											<a class="dropdown-toggle" id="resignationDate"
												style="padding-left: 15px;" role="button"
												data-toggle="dropdown" data-target="#" href="#">
												<div class="input-group">
													<input type="text" class="form-control"
														placeholder="dd/mm/yyyy" name="Resignation Date"
														data-validator="required" data-valid-method="submit"
														data-message-id="Resignation Date"
														data-ng-model="EmployeeMasterDataPersonal.resignationDate"><span
														class="input-group-addon"><i
														class="glyphicon glyphicon-calendar"></i></span>
												</div>
											</a>
											<ul class="dropdown-menu" role="menu"
												aria-labelledby="dLabel">
												<datetimepicker
													data-ng-model="EmployeeMasterDataPersonal.resignationDate"
													data-on-set-time="EmployeeMasterDataPersonal.resignationDate = onDateSet(newDate)"
													data-datetimepicker-config="{ dropdownSelector: '#resignationDate',startView:'day', minView:'day'}" />
											</ul>
										</div>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Notice Period To
									Be Served(Months)<span style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Notice Period"
										ng-model="EmployeeMasterDataPersonal.noticePeriod"
										placeholder="0.0" style="text-align: right" phonenumbers-only>
								</div>
							</div>

							<!-- 	<div class="form-group">
												<label class="col-md-4 control-label">Race
												</label>
												<div class="col-md-5">
													<input type="text" class="form-control input-sm"
														name="race"
														ng-model="EmployeeMasterDataPersonal.race">
												</div>
											</div> -->
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12" id="1">

						<button class="btn btn-info" ng-click="tabLabelPrevious();"
							style="margin-left: 10px; margin-top: -25px;">
							<i class="fa fa-arrow-left" style="margin-right: 4px;"></i>{{tabs[1].title}}
						</button>
						<button class="btn btn-info" name="Address"
							style="margin-left: 92%; margin-top: -4.5%"
							ng-click="tabLabel(1)">
							{{tabs[2].title}}<i class="fa fa-arrow-right"></i>
							<!-- {{tabs[0].title}} -->
						</button>
					</div>
				</div>
				<div class="form-actions-tab">
					<div class="row" align="center">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit && !isPersonal"
								type="submit"
								ng-click="savePersonalInfo(frmPersonalInfo,EmployeeMasterDataPersonal)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" ng-if="isEdit || isPersonal"
								type="submit"
								ng-click="updatePersonalInfo(frmPersonalInfo,EmployeeMasterDataPersonal)">
								<i class="fa fa-save"></i> Update
							</button>

							<button class="btn btn-info" type="button"
								data-ng-click="resetPersonal(frmPersonalInfo)">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-danger" type="button"
								data-ng-click="cancel();">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
			</tab> <tab heading="{{tabs[2].title}}" id="addressTab" class="tab-head"
				style="color:black;" active="tabs[2].active"
				ng-click="setInActive(2);"><!-- ng-click="tabLabel(2);" -->
			<form class="form-horizontal" name="frmAddress" id="addressForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<button class="btn btn-info" type="button"
								data-ng-click="previous();" style="margin-right: 1029px;">
								<i class="fa fa-arrow-left"></i> {{tabs[1].title}}
							</button>

							<!-- <div class="form-group">
													<label class="col-md-4 control-label">Address<span
														style="color: red;">*</span></label>
													<div class="col-md-5">
														<textarea ng-model="EmployeeMasterDataAddress.permAddress"
															name="Address in Permanent Address"
															class="form-control input-sm resize-none"
															data-message-id="permAddress" validation="required"
															friendly-name="Address" rows="4">
		         										</textarea>
													</div>
												</div> -->

							<!-- 	<div class="form-group">
												<label class="col-md-4 control-label">Phone No<span
													style="color: red;"></span></label>
												<div class="col-md-5">
													<input type="text" class="form-control input-sm"
														name="permPhone" ng-model="EmployeeMasterDataAddress.permPhone">
												</div>
											</div> -->


							<!-- 	<div class="form-group">
												<label class="col-md-4 control-label">Mobile No<span
													style="color: red;"></span></label>
												<div class="col-md-5">

													<input type="text" class="form-control input-sm"
														name="Mobile No" ng-model="EmployeeMasterDataAddress.permMobile">
												</div>
											</div> -->


							<div class="form-group">
								<label class="col-md-4 control-label"><b>Permanent
										Address</b></label>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Address<span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<textarea ng-model="EmployeeMasterDataAddress.permAddress"
										name="Address in Permanent Address"
										class="form-control input-sm resize-none"
										data-message-id="permAddress" validation="required"
										friendly-name="Address" rows="4">
	         										</textarea>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Place <span
									style="color: red;"></span></label>

								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm" name="Place"
										ng-model="EmployeeMasterDataAddress.permPlace" maxlength="50">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">District <span
									style="color: red;"></span></label>

								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm"
										name="District"
										ng-model="EmployeeMasterDataAddress.permDistrict"
										maxlength="50">
								</div>
							</div>

							<div class="form-group ">
								<label class="col-md-4 control-label">Pincode<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="permPin"
										ng-model="EmployeeMasterDataAddress.permPin" maxlength="10"
										phonenumbers-only>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Phone No<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="permPhone"
										ng-model="EmployeeMasterDataAddress.permPhone" maxlength="70"
										phonenumbers-only>
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label">Mobile No<span
									style="color: red;"></span></label>
								<!-- <div class="col-md-5"> -->

								<div class="col-md-4  padding-left-4 ">
									<input type="text" class="form-control input-sm"
										style="width: 100%;" name="Mobile No"
										ng-model="EmployeeMasterDataAddress.permMobile" maxlength="70">
								</div>
								<!-- </div> -->
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"> Permanent And
									Present Address are same </label>
								<div class="col-md-5">
									<div class="checkbox">
										<label> <input type="checkbox"
											class="checkbox style-0"
											ng-model="EmployeeMasterDataAddress.isActiveAddress"
											ng-click="copyAddress(EmployeeMasterDataAddress)"
											name="isActiveAddress" data-ng-true-value="'Y'"
											data-ng-false-value="'N'"> <span></span>
										</label>
									</div>
								</div>
							</div>

						</div>


						<div class="col-sm-6 col-md-6 col-lg-6">
							<button class="btn btn-info" type="button"
								data-ng-click="next();" style="margin-left: 86%;">
								{{tabs[3].title}} <i class="fa fa-arrow-right"></i>
							</button>

							<div class="col-sm-12 col-md-12 col-lg-12">
								<div class="form-group">
									<label class="col-md-4 control-label"><b>Present
											Address</b></label>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Address<span
										style="color: red;"></span></label>
									<div class="col-md-5">
										<textarea ng-model="EmployeeMasterDataAddress.presentAddress"
											name="presentAddress"
											class="form-control input-sm resize-none" rows="4">
	               									</textarea>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">Place <span
										style="color: red;"></span></label>

									<div class="col-md-5 inputGroupContainer">
										<input type="text" class="form-control input-sm"
											name="presentPlace"
											ng-model="EmployeeMasterDataAddress.presentPlace"
											maxlength="50">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">District <span
										style="color: red;"></span></label>

									<div class="col-md-5 inputGroupContainer">
										<input type="text" class="form-control input-sm"
											name="presentDistrict"
											ng-model="EmployeeMasterDataAddress.presentDistrict"
											maxlength="50">
									</div>
								</div>

								<div class="form-group ">
									<label class="col-md-4 control-label">Pincode<span
										style="color: red;"></span></label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm"
											name="presentPin"
											ng-model="EmployeeMasterDataAddress.presentPin"
											maxlength="50" phonenumbers-only>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">Phone No<span
										style="color: red;"></span></label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm"
											name="Present Phone No"
											ng-model="EmployeeMasterDataAddress.presentPhone"
											maxlength="70" phonenumbers-only>
									</div>
								</div>


								<div class="form-group">
									<label class="col-md-4 control-label">Mobile No<span
										style="color: red;"></span></label>
									<!-- <div class="col-md-5"> -->

									<div class="col-md-4  padding-left-4 ">
										<input type="text" class="form-control input-sm"
											name="Present Mobile No" style="width: 100%;"
											ng-model="EmployeeMasterDataAddress.presentMobile"
											maxlength="70">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label"> Old Address </label>
									<div class="col-md-5">
										<div class="checkbox">
											<label> <input type="checkbox"
												class="checkbox style-0"
												ng-model="EmployeeMasterDataAddress.isActiveOldAddress"
												name="isActiveOldAddress" data-ng-true-value="'Y'"
												data-ng-false-value="'N'"> <span></span>
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12" id="2">
						<button class="btn btn-info" ng-click="tabLabelPrevious();"
							style="margin-right: 1062px; margin-left: 15px;">
							<i class="fa fa-arrow-left"></i>{{tabs[1].title}}
						</button>
						<button class="btn btn-info" name="Address"
							style="margin-left: 92%; margin-top: -4.5%"
							ng-click="tabLabel(2)">
							{{tabs[3].title}}<i class="fa fa-arrow-right"></i>
							<!-- {{tabs[0].title}} -->
						</button>
					</div>
				</div>

				<div class="form-actions-tab">
					<div class="row" align="center">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit && !isAddress"
								type="submit"
								ng-click="saveAddress(frmAddress,EmployeeMasterDataAddress)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" ng-if="isEdit || isAddress"
								type="submit"
								ng-click="updateAddress(frmAddress,EmployeeMasterDataAddress)">
								<i class="fa fa-save"></i> Update
							</button>

							<button class="btn btn-info" type="button"
								data-ng-click="resetAddress(EmployeeMasterDataAddress)">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-danger" type="button"
								data-ng-click="cancel();">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
			</tab> <tab heading="{{tabs[3].title}}" active="tabs[3].active"
				class="tab-head" ng-click="setInActive(3);">
			<form class="form-horizontal" name="Family" id="familyForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<button class="btn btn-info" type="button"
							data-ng-click="previous();" style="margin-right: 1029px;">
							<i class="fa fa-arrow-left"></i> {{tabs[2].title}}
						</button>

						<button class="btn btn-info" type="button" data-ng-click="next();"
							style="margin-left: 89%; margin-top: -50px;">
							{{tabs[4].title}} <i class="fa fa-arrow-right"></i>
						</button>
						<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
							<%@taglib uri="http://www.springframework.org/tags"
								prefix="spring"%>
							<%@ taglib prefix="security"
								uri="http://www.springframework.org/security/tags"%>
							<div id="content">
								<!-- widget grid -->
								<section id="widget-grid" data-widget-grid>
									<div class="row">
										<article class="col-sm-12">
											<div data-jarvis-widget id="standard-datatable-widget">
												<div role="content">
													<div class="widget-body no-padding">
														<div
															class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
															data-st-table="displayedCollectionFam"
															data-st-safe-src="rowCollectionFam">
															<div class="dt-toolbar" style="padding-bottom: 10px;">
																<button class="btn btn-success width_12" type="button"
																	ng-click="addFamily();">Add Family</button>
															</div>
															<table id="dt_basic"
																class="table table-striped table-bordered table-hover dataTable no-footer"
																role="grid" aria-describedby="dt_basic_info">
																<thead class="dataTables-Main-Head">
																	<tr>
																		<th class="sorting" st-sort="relativeName">Relative
																			Name</th>
																		<th class="sorting" st-sort="relationToEmployee">Relation</th>

																		<th class="sorting" st-sort="dependentPassportNo">Aadhar
																			No</th>
																		<th class="sorting"
																			st-sort="dependentPassportExpiryDate">Mobile No</th>

																		<th class="sorting" st-sort="dependentVisaType">DOB
																		</th>

																		<th class="sorting" st-sort="dependentOnEmployee">Is
																			Dependent</th>
																		<th class="table-heading">Action</th>
																	</tr>
																</thead>
																<tbody class="dataTables-Main-Body">
																	<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																		ng-repeat="empFamilyList in displayedCollectionFam">
																		<td class="sorting">{{empFamilyList.relativeName}}</td>
																		<td class="sorting ">{{empFamilyList.relationToEmployee}}</td>
																		<td class="sorting ">{{empFamilyList.aadharno}}</td>
																		<td class="sorting ">{{empFamilyList.mobileno}}</td>
																		<td class="sorting ">{{empFamilyList.dependentDob}}</td>
																		<td><input type="checkbox" checked="checked"
																			ng-model="empFamilyList.dependentOnEmployee"
																			disabled="disabled"></td>
																		<td class=" td-actions text-center"><span>
																				<i class="fa  fa-pencil text-success text"
																				data-ng-click="editRowFamily(empFamilyList)"></i>
																		</span> <span> <i
																				class="fa fa-trash-o text-danger-dker text"
																				data-ng-click="deleteRowFamily(empFamilyList)"></i>
																		</span></td>
																	</tr>
																</tbody>
															</table>
															<div class="dt-toolbar-footer"
																data-smart-include="views/layout/toolbar-footer.tpl"></div>
														</div>
													</div>
													<!-- end widget content -->
												</div>
												<!-- end widget div -->
											</div>
											<!-- end widget -->
										</article>
										<!-- WIDGET END -->
									</div>
								</section>
							</div>
						</div>

						<!-- Smart Table -->
					</div>
				</div>
				<div class="form-actions-tab">
					<div class="row">
						<div class="col-md-12" id="3">
							<button class="btn btn-info" ng-click="tabLabelPrevious();"
								style="margin-right: 1769%;">
								<i class="fa fa-arrow-left"></i>{{tabs[2].title}}
							</button>
							<button class="btn btn-info"
								style="margin-left: 89%; margin-top: -1.5%"
								ng-click="tabLabel(3)">
								{{tabs[4].title}}<i class="fa fa-arrow-right"></i>
								<!-- {{tabs[0].title}} -->
							</button>
						</div>
					</div>
				</div>
			</form>
			</tab> <tab heading="{{tabs[4].title}}" id="educationTab" class="tab-head"
				active="tabs[4].active" ng-click="setInActive(4);"> <br>
			<form class="form-horizontal" name="Education" id="educationForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<button class="btn btn-info" type="button"
							data-ng-click="previous();" style="margin-right: 1769%;">
							<i class="fa fa-arrow-left"></i> {{tabs[3].title}}
						</button>
						<div class="col-sm-6 col-md-6 col-lg-6">

							<!-- <div class="form-group ">
												<label class="col-md-4 control-label">Type Of Course<span
													style="color: red;"></span></label>
												<div class="col-md-5">
													<select class="form-control journalVoucher-textBox"
														name="Type Of Course"
														ng-model="EmployeeMasterData.courseType">
														<option value="">--Select--</option>
														<option value="UG">UG</option>
														<option value="PG">PG</option>
													</select>
												</div>
											</div> -->
						</div>

						<div class="col-sm-6 col-md-6 col-lg-6" style="margin-top: -30px;">
							<button class="btn btn-info" type="button"
								data-ng-click="next();"
								style="margin-left: 80%; margin-top: -1px;">
								{{tabs[5].title}} <i class="fa fa-arrow-right"></i>
							</button>
						</div>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<%@taglib uri="http://www.springframework.org/tags"
							prefix="spring"%>
						<%@ taglib prefix="security"
							uri="http://www.springframework.org/security/tags"%>
						<div id="content">
							<!-- widget grid -->
							<section id="widget-grid" data-widget-grid>
								<div class="row">
									<article class="col-sm-12">
										<div data-jarvis-widget id="standard-datatable-widget">
											<div role="content">
												<div class="widget-body no-padding">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
														data-st-table="displayedCollectionEdu"
														data-st-safe-src="rowCollectionEdu">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<button class="btn btn-success width_12" type="button"
																ng-click="addEducation();">Add Education</button>
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>

																	<th class="sorting width_20">Qualification</th>
																	<th class="sorting width_10">Percentage</th>
																	<th class="sorting width_10">Specialization</th>

																	<th class="sorting width_20">Institution</th>
																	<th class="sorting width_10">Pass Out</th>
																	<th class="width_2 text-center">Action</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataEdu in displayedCollectionEdu">

																	<td>{{EmployeeMasterDataEdu.qualification}}</td>
																	<td>{{EmployeeMasterDataEdu.percentage}}</td>
																	<td>{{EmployeeMasterDataEdu.specialization}}</td>

																	<td>{{EmployeeMasterDataEdu.institution}}</td>
																	<td>{{EmployeeMasterDataEdu.yearPassed}}</td>
																	<td class=" td-actions text-center"><span>
																			<i class="fa  fa-pencil text-success text"
																			data-ng-click="editRowEducation(EmployeeMasterDataEdu)"></i>
																	</span> <span> <i
																			class="fa fa-trash-o text-danger-dker text"
																			data-ng-click="deleteRowEducation(EmployeeMasterDataEdu)"></i>
																	</span></td>
																</tr>
															</tbody>
														</table>
														<div class="dt-toolbar-footer"
															data-smart-include="views/layout/toolbar-footer.tpl"></div>
													</div>
												</div>
												<!-- end widget content -->
											</div>
											<!-- end widget div -->
										</div>
										<!-- end widget -->
									</article>
									<!-- WIDGET END -->
								</div>
							</section>
						</div>
					</div>
					<!-- Edu Smart  Table -->
				</div>
				<div class="form-actions-tab">
					<div class="row">
						<div class="col-md-12" id="4">
							<button class="btn btn-info" ng-click="tabLabelPrevious();"
								style="margin-right: 1769%;">
								<i class="fa fa-arrow-left"></i>{{tabs[3].title}}
							</button>
							<button class="btn btn-info" name="Address"
								style="margin-left: 89%; margin-top: -1.5%"
								ng-click="tabLabel(4)">
								{{tabs[5].title}}<i class="fa fa-arrow-right"></i>
								<!-- {{tabs[0].title}} -->
							</button>
						</div>
					</div>
				</div>
			</form>
			</tab> <tab heading="{{tabs[5].title}}" id="experienceTab" class="tab-head"
				active="tabs[5].active" ng-click="setInActive(5);"> <br>
			<form class="form-horizontal" name="Experience" id="experienceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<button class="btn btn-info" type="button"
								data-ng-click="previous();" style="margin-right: 1029px;">
								<i class="fa fa-arrow-left"></i> {{tabs[4].title}}
							</button>
						</div>
						<button class="btn btn-info" type="button" data-ng-click="next();"
							style="margin-left: 92%; margin-top: -50px;">
							{{tabs[6].title}} <i class="fa fa-arrow-right"></i>
						</button>
						<div class="col-sm-6 col-md-6 col-lg-6">

							<!-- <button class="btn btn-info" type="button"
										data-ng-click="next();" style=" margin-left: 84%; margin-top: -4px; ">{{tabs[5].title}}
											 <i class="fa fa-arrow-right"></i>  
										</button> -->
						</div>
						<%@taglib uri="http://www.springframework.org/tags"
							prefix="spring"%>
						<%@ taglib prefix="security"
							uri="http://www.springframework.org/security/tags"%>
						<div id="content">
							<!-- widget grid -->
							<section id="widget-grid" data-widget-grid>
								<div class="row">
									<article class="col-sm-12">
										<div data-jarvis-widget id="standard-datatable-widget">
											<div role="content">
												<div class="widget-body no-padding">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
														data-st-table="displayedCollectionEx"
														data-st-safe-src="rowCollectionEx">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<button class="btn btn-success width_12" type="button"
																ng-click="addExperiance();">Add Experience</button>
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--  <th class="width_1"></th> -->
																	<th class="sorting width_20">Organization</th>
																	<th class="sorting width_10">Experience</th>

																	<!-- <th class="sorting width_10">From</th>
																					<th class="sorting width_10">To</th> -->
																	<th class="sorting width_20">Designation</th>
																	<th class="sorting width_20">Remarks</th>

																	<th class="width_2 text-center">Action</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataEx in displayedCollectionEx">
																	<td>{{EmployeeMasterDataEx.organization}}</td>
																	<td>{{EmployeeMasterDataEx.experienceYear}}</td>
																	<td>{{EmployeeMasterDataEx.expDesisnation}}</td>
																	<td class="wrapping" data-toggle="tooltip"
																		title="{{detail.description}}">{{EmployeeMasterDataEx.expRemarks}}</td>
																	<td class=" td-actions text-center"><span>
																			<i class="fa  fa-pencil text-success text"
																			data-ng-click="editRowExperiance(EmployeeMasterDataEx)"></i>
																	</span> <span> <i
																			class="fa fa-trash-o text-danger-dker text"
																			data-ng-click="deleteRowExperiance(EmployeeMasterDataEx)"></i>
																	</span></td>
																</tr>
															</tbody>
														</table>
														<div class="dt-toolbar-footer"
															data-smart-include="views/layout/toolbar-footer.tpl"></div>
													</div>
												</div>
												<!-- end widget content -->
											</div>
											<!-- end widget div -->
										</div>
										<!-- end widget -->
									</article>
									<!-- WIDGET END -->
								</div>
							</section>
						</div>
					</div>
				</div>
				<div class="form-actions-tab">
					<div class="row">
						<div class="col-md-12" id="5">
							<button class="btn btn-info" ng-click="tabLabelPrevious();"
								style="margin-right: 1769%;">
								<i class="fa fa-arrow-left"></i>{{tabs[4].title}}
							</button>
							<button class="btn btn-info"
								style="margin-left: 92%; margin-top: -1.5%"
								ng-click="tabLabel(5)">
								{{tabs[6].title}}<i class="fa fa-arrow-right"></i>
								<!-- {{tabs[0].title}} -->
							</button>
						</div>
					</div>
				</div>
			</form>
			</tab> <tab heading="{{tabs[6].title}}" id="ruleTab" class="tab-head"
				active="tabs[6].active" ng-click="setInActive(6);">
			<form class="form-horizontal" name="frmRule" id="ruleForm" novalidate
				method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<button class="btn btn-info" type="button"
							data-ng-click="previous();" style="margin-right: 1769%;">
							<i class="fa fa-arrow-left"></i> {{tabs[5].title}}
						</button>
						<div class="col-sm-6 col-md-6 col-lg-6">
							<div class="form-group"
								ng-init="EmployeeMasterData.overTime='true'">
								<label class="col-md-4 control-label">Overtime
									Applicable <span style="color: red;"></span>
								</label>
								<div class="radio radio-inline">

									<label class="i-checks"> <input type="radio" class=""
										name="overTime" ng-value="true"
										ng-model="EmployeeMasterDataRule.overTime"> <i></i>
										Yes
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" class=""
										name="overTime" ng-value="false"
										ng-model="EmployeeMasterDataRule.overTime"> <i></i> No
									</label>
								</div>
							</div>

							<div class="form-group"
								ng-init="EmployeeMasterDataRule.esiApp='true'">
								<label class="col-md-4 control-label">ESI Applicable <span
									style="color: red;"></span>
								</label>
								<div class="radio radio-inline">

									<label class="i-checks"> <input type="radio" class=""
										name="esiApp" ng-value="true"
										ng-model="EmployeeMasterDataRule.esiApp"> <i></i> Yes
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" class=""
										name="esiApp" ng-value="false"
										ng-model="EmployeeMasterDataRule.esiApp"> <i></i> No
									</label>
								</div>
							</div>

							<!-- <div class="form-group"
												ng-init="EmployeeMasterDataRule.lateApp='true'">
												<label class="col-md-4 control-label">Late
													Applicable <span style="color: red;"></span>
												</label>
												<div class="radio radio-inline">

													<label class="i-checks"> <input type="radio"
														class="" name="lateApp" ng-value="true"
														ng-model="EmployeeMasterDataRule.lateApp"> <i></i>
														Yes
													</label>
												</div>
												<div class="radio radio-inline">
													<label class="i-checks"> <input type="radio"
														class="" name="lateApp" ng-value="false"
														ng-model="EmployeeMasterDataRule.lateApp"> <i></i>
														No
													</label>
												</div>
											</div> -->
							<div class="col-sm-12 col-md-12 col-lg-6">
								<div class="form-group">
									<label class="col-md-8 control-label">Telephone
										Limit(Monthly) <span style="color: red;">*</span>
									</label>

									<div class="col-md-4 inputGroupContainer">
										<input type="text" class="form-control input-sm"
											validation="required" friendly-name="Telephone Limit"
											data-message-id="telephoneLimit" name="Telephone Limit"
											ng-model="EmployeeMasterDataRule.telephoneLimit"
											style="text-align: right; width: 115px;" phonenumbers-only>
									</div>
								</div>
							</div>
						</div>

						<div class="col-sm-6 col-md-6 col-lg-6" style="margin-top: -29px;">
							<button class="btn btn-info" type="button"
								data-ng-click="next();"
								style="margin-left: 73%; margin-top: -4px;">
								{{tabs[7].title}} <i class="fa fa-arrow-right"></i>
							</button>
							<div class="form-group"
								ng-init="EmployeeMasterDataRule.pfApp='true'">
								<label class="col-md-4 control-label">PF Applicable <span
									style="color: red;"></span>
								</label>
								<div class="radio radio-inline">

									<label class="i-checks"> <input type="radio" class=""
										name="pfApp" ng-value="true"
										ng-model="EmployeeMasterDataRule.pfApp"> <i></i> Yes
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" class=""
										name="pfApp" ng-value="false"
										ng-model="EmployeeMasterDataRule.pfApp"> <i></i> No
									</label>
								</div>
							</div>

							<!-- <div class="form-group"
												ng-init="EmployeeMasterData.earlyExit='true'">
												<label class="col-md-4 control-label">Early Exit
													Applicable <span style="color: red;"></span>
												</label>
												<div class="radio radio-inline">

													<label class="i-checks"> <input type="radio"
														class="" name="earlyExit" ng-value="true"
														ng-model="EmployeeMasterDataRule.earlyExit"> <i></i>
														Yes
													</label>
												</div>
												<div class="radio radio-inline">
													<label class="i-checks"> <input type="radio"
														class="" name="earlyExit" ng-value="false"
														ng-model="EmployeeMasterDataRule.earlyExit"> <i></i>
														No
													</label>
												</div>
											</div> -->

							<div class="form-group"
								ng-init="EmployeeMasterDataRule.leaveOption='false'">
								<label class="col-md-4 control-label">Leave Option</label>
								<div class="radio radio-inline">

									<label class="i-checks"> <input type="radio" class=""
										name="leaveOption" ng-value="false"
										ng-model="EmployeeMasterDataRule.leaveOption"> <i></i>
										Carry Forward
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" class=""
										name="leaveOption" ng-value="true"
										ng-model="EmployeeMasterDataRule.leaveOption"> <i></i>
										En Cashable
									</label>
								</div>
							</div>
							<!-- 	<div class="form-group">
													<label class="col-md-4 control-label">Notice Period
													</label>

													<div class="col-md-5 inputGroupContainer"
														style="padding-left: 18px;">
														<input type="text" class="form-control input-sm"
															name="Medical Limit"
															ng-model="EmployeeMasterDataRule.noticePeriodRule"
															placeholder="0.0"
															style="text-align: right; width: 115px;">
													</div>
												</div> -->
							<div class="col-sm-12 col-md-12 col-lg-6">
								<div class="form-group">
									<label class="col-md-7 control-label">Medical
										Limit(Annual) <span style="color: red;"></span>
									</label>

									<div class="col-md-5 inputGroupContainer"
										style="padding-left: 36px;">
										<input type="text" class="form-control input-sm"
											name="Medical Limit" ng-pattern-restrict="^[0-9.]*$"
											ng-model="EmployeeMasterDataRule.medicalLimit"
											placeholder="0.0" style="text-align: right; width: 115px;">
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12" id="6">
						<button class="btn btn-info" ng-click="tabLabelPrevious();"
							style="margin-right: 1062px;">
							<i class="fa fa-arrow-left"></i>{{tabs[5].title}}
						</button>
						<button class="btn btn-info"
							style="margin-left: 86%; margin-top: -4.5%"
							ng-click="tabLabel(6)">
							{{tabs[7].title}}<i class="fa fa-arrow-right"></i>
							<!-- {{tabs[0].title}} -->
						</button>
					</div>
				</div>
				<div class="form-actions-tab">
					<div class="row" align="center">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit && !isSave"
								type="submit"
								ng-click="saveRules(frmRule,EmployeeMasterDataRule)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" ng-if="isEdit || isSave"
								type="submit"
								ng-click="updateRules(frmRule,EmployeeMasterDataRule)">
								<i class="fa fa-save"></i> Update
							</button>

							<button class="btn btn-info" type="button"
								data-ng-click="resetRule(frmRule)">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-danger" type="button"
								data-ng-click="cancel();">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
			</tab> <tab heading="{{tabs[7].title}}" active="tabs[7].active"
				class="tab-head" ng-click="setInActive(7);">
			<form class="form-horizontal" name="frmPersonalDetails"
				id="personalDetailsForm" novalidate method="post"
				ng-init="setForm(this);">


				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<button class="btn btn-info" type="button"
							data-ng-click="previous();" style="margin-right: 1029px;">
							<i class="fa fa-arrow-left"></i> {{tabs[6].title}}
						</button>
						<button class="btn btn-info" type="button" data-ng-click="next();"
							style="margin-left: 89%; margin-top: -3%;">
							{{tabs[8].title}} <i class="fa fa-arrow-right"></i>
						</button>
						<div class="col-sm-12 col-md-12 col-lg-12">
							<fieldset>
								<fieldset class="field_set setBorder"
									style="margin-bottom: -14px;">
									<div class="form-group">
										<label class="col-md-2 control-label"><b>Bank
												Details</b> <span style="color: red;"></span></label>
									</div>

									<div class="col-sm-12 col-md-6">
										<div class="form-group">
											<label class="col-md-4 control-label">Account No <span
												style="color: red;">*</span>
											</label>

											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													data-message-id="accountNo" validation="required"
													friendly-name="Account Number" name="Account No"
													ng-model="EmployeeMasterDataPerDet.accountNo"
													maxlength="20" phonenumbers-only>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">Branch <!-- <span
																style="color: red;">*</span> --></label>

											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													data-message-id="bankName" friendly-name="Bank Name"
													name="Bank Name"
													ng-model="EmployeeMasterDataPerDet.bankName" maxlength="50">
											</div>
										</div>
									</div>

									<div class="col-sm-12 col-md-6">
										<div class="form-group">
											<label class="col-md-4 control-label">Place <span
												style="color: red;"></span></label>

											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													name="bankPlace"
													ng-model="EmployeeMasterDataPerDet.bankPlace"
													maxlength="20">
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label"> Cash </label>
											<div class="col-md-5">
												<div class="checkbox">
													<label> <input type="checkbox"
														class="checkbox style-0"
														ng-model="EmployeeMasterDataPerDet.isActiveCash"
														name="isActiveCash" data-ng-true-value="'Y'"
														data-ng-false-value="'N'"> <span></span>
													</label>
												</div>
											</div>
										</div>
									</div>
								</fieldset>
								<br>

								<fieldset class="field_set setBorder"
									style="margin-bottom: -14px;">
									<div class="form-group">
										<label class="col-md-2 control-label"><b>Passport
												Details</b> <span style="color: red;"></span></label>
									</div>
									<div class="col-sm-12 col-md-6">
										<div class="form-group">
											<label class="col-md-4 control-label">Passport No <span
												style="color: red;"></span>
											</label>

											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													name="passportNo" maxlength="50"
													ng-model="EmployeeMasterDataPerDet.passportNo">
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">Issued Date<span
												style="color: red;"></span></label>
											<div class="col-md-5">
												<ng-bs3-datepicker
													data-ng-model="EmployeeMasterDataPerDet.issuedDate"
													id="issuedDate" name="issuedDate" form-name="toForm"
													friendly-name="issuedDate" />

											</div>
										</div>
									</div>

									<div class="col-sm-12 col-md-6">
										<div class="form-group">
											<label class="col-md-4 control-label">Expiry Date<span
												style="color: red;"></span></label>
											<div class="col-md-5">
												<ng-bs3-datepicker
													data-ng-model="EmployeeMasterDataPerDet.expiryDate"
													id="expiryDate" name="expiryDate" form-name="toForm"
													friendly-name="expiryDate" />

											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">Issued Place <span
												style="color: red;"></span>
											</label>

											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													name="issuedPlace" maxlength="50"
													ng-model="EmployeeMasterDataPerDet.issuedPlace">
											</div>
										</div>
									</div>
								</fieldset>
								<br>

								<fieldset class="field_set setBorder"
									style="margin-bottom: -14px;">
									<div class="form-group">
										<label class="col-md-2 control-label"><b>Driving
												License</b></label>
									</div>
									<div class="col-sm-12 col-md-6">
										<div class="form-group">
											<label class="col-md-4 control-label">License No<span
												style="color: red;"></span></label>

											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													name="licenseNo"
													ng-model="EmployeeMasterDataPerDet.licenseNo">
											</div>
										</div>

										<div class="form-group ">
											<label class="col-md-4 control-label">License Type<span
												style="color: red;"></span>
											</label>
											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													name="licenseType" maxlength="50"
													ng-model="EmployeeMasterDataPerDet.licenseType">
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Issued Date<span
												style="color: red;"></span></label>
											<div class="col-md-5">
												<ng-bs3-datepicker
													data-ng-model="EmployeeMasterDataPerDet.licenseIssuedDate"
													id="licenseIssuedDate" name="licenseIssuedDate"
													form-name="toForm" friendly-name="expiryDate" />

											</div>
										</div>
									</div>

									<div class="col-sm-12 col-md-6">
										<div class="form-group">
											<label class="col-md-4 control-label">Expiry Date<span
												style="color: red;"></span></label>
											<div class="col-md-5">
												<ng-bs3-datepicker
													data-ng-model="EmployeeMasterDataPerDet.licenseexpiryDate"
													id="licenseexpiryDate" name="licenseexpiryDate"
													form-name="toForm" friendly-name="licenseexpiryDate" />

											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">Renewal Date<span
												style="color: red;"></span>
											</label>
											<div class="col-md-5">
												<ng-bs3-datepicker
													data-ng-model="EmployeeMasterDataPerDet.renewalDate"
													id="renewalDate" name="renewalDate" form-name="toForm"
													friendly-name="renewalDate" />

											</div>
										</div>

										<!-- <div class="form-group">
															<label class="col-md-4 control-label">Joining
																Document Upload</label>
															<div class="col-md-7 inputGroupContainer">
																<div class="input-group" id="fileDiv">
																	<input type="file" name="joinDocUpload"
																		ng-model="EmployeeMasterData.joinDocUpload"
																		class="form-control"
																		onchange="angular.element(this).scope().uploadDocFile(this)"
																		accept=".docx,.xls" style="width: 182px;" /> <br>
																	<button class="btn btn" type="button"
																		ng-click="uploadDocument()">Upload</button>
																	<a class="link" href="+{{EmployeeMasterData.joinDocUpload}}+" data-ng-click="downloadDoc();" ng-if="EmployeeMasterData.isEdit">{{EmployeeMasterData.joinDocUpload}}</a>
																</div>
															</div>
														</div> -->

									</div>

								</fieldset>
								<br>


								<fieldset class="field_set setBorder"
									style="margin-bottom: -14px;">
									<div class="form-group">
										<label class="col-md-2 control-label"><b>VISA
												Details</b> <span style="color: red;"></span></label>
									</div>
									<div class="col-sm-12 col-md-6">



										<div class="form-group">
											<label class="col-md-4 control-label">VISA Reference
												Number <span style="color: red;"></span>
											</label>
											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													name="visaRefNo"
													ng-model="EmployeeMasterDataPerDet.visaRefNo">
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">VISA Type <span
												style="color: red;"></span></label>
											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													name="visaType" maxlength="50"
													ng-model="EmployeeMasterDataPerDet.visaType">
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">VISA Issued
												Date<span style="color: red;"></span>
											</label>
											<div class="col-md-5">
												<ng-bs3-datepicker
													data-ng-model="EmployeeMasterDataPerDet.visaIssuedDate"
													id="visaIssuedDate" name="visaIssuedDate"
													form-name="toForm" friendly-name="visaIssuedDate" />

											</div>
										</div>

									</div>

									<div class="col-sm-12 col-md-6">
										<div class="form-group">
											<label class="col-md-4 control-label">VISA Expiry
												Date<span style="color: red;"></span>
											</label>
											<div class="col-md-5">
												<ng-bs3-datepicker
													data-ng-model="EmployeeMasterDataPerDet.visaExpiryDate"
													id="visaExpiryDate" name="visaExpiryDate"
													form-name="toForm" friendly-name="visaExpiryDate" />

											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">VISA Issued
												Place <span style="color: red;"></span>
											</label>

											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													name="visaIssuedPlace"
													ng-model="EmployeeMasterDataPerDet.visaIssuedPlace">
											</div>
										</div>
									</div>

								</fieldset>
								<br>


							</fieldset>
							<br>
						</div>

					</div>
				</div>
				<div class="row">
					<div class="col-md-12" id="7">
						<button class="btn btn-info" ng-click="tabLabelPrevious();"
							style="margin-right: 1062px;">
							<i class="fa fa-arrow-left"></i>{{tabs[6].title}}
						</button>
						<button class="btn btn-info"
							style="margin-left: 89%; margin-top: -54px;"
							ng-click="tabLabel(7)">
							{{tabs[8].title}}<i class="fa fa-arrow-right"></i>
							<!-- {{tabs[0].title}} -->
						</button>
					</div>
				</div>
				<div class="form-actions-tab">
					<div class="row" align="center">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit && !isDocument"
								type="submit"
								ng-click="saveDocumentDet(frmPersonalDetails,EmployeeMasterDataPerDet)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" ng-if="isEdit || isDocument"
								type="submit"
								ng-click="updateDocumentDet(frmPersonalDetails,EmployeeMasterDataPerDet)">
								<i class="fa fa-save"></i> Update
							</button>

							<button class="btn btn-info" type="button"
								data-ng-click="resetPersonalDetails(frmPersonalDetails)">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-danger" type="button"
								data-ng-click="cancel();">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
			</tab> <tab heading="{{tabs[8].title}}" active="tabs[8].active"
				class="tab-head" ng-click="setInActive(8);">
			<form class="form-horizontal" name="Nomination" id="NominationForm"
				novalidate method="post" ng-init="setForm(this);">

				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<button class="btn btn-info" type="button"
							data-ng-click="previous();" style="margin-right: 1029px;">
							<i class="fa fa-arrow-left"></i> {{tabs[7].title}}
						</button>
						<button class="btn btn-info" type="button" data-ng-click="next();"
							style="margin-left: 91%; margin-top: -50px;">
							{{tabs[9].title}} <i class="fa fa-arrow-right"></i>
						</button>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12">
						<%@taglib uri="http://www.springframework.org/tags"
							prefix="spring"%>
						<%@ taglib prefix="security"
							uri="http://www.springframework.org/security/tags"%>
						<div id="content">
							<!-- widget grid -->
							<section id="widget-grid" data-widget-grid>
								<div class="row">
									<article class="col-sm-12">
										<div data-jarvis-widget id="standard-datatable-widget">
											<div role="content">
												<div class="widget-body no-padding">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
														data-st-table="displayedCollectionNom"
														data-st-safe-src="rowCollectionNom">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<button class="btn btn-success width_12" type="button"
																ng-click="addNomination();">Add Nomination</button>
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!-- <th class="width_1"></th> -->
																	<th class="sorting width_20">Name</th>
																	<th class="sorting width_10">Gender</th>
																	<th class="sorting width_10">DOB</th>
																	<th class="sorting width_20">Relationship</th>
																	<th class="sorting width_20">Address</th>
																	<th class="sorting width_20">Email</th>
																	<th class="width_2 text-center">Action</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataNomination in displayedCollectionNom">
																	<!--   <td data-cs-select="designation"></td> -->
																	<td>{{EmployeeMasterDataNomination.nominateName}}</td>
																	<td
																		ng-if="EmployeeMasterDataNomination.nominateGender == true">Male</td>
																	<td
																		ng-if="EmployeeMasterDataNomination.nominateGender == false">Female</td>

																	<td>{{EmployeeMasterDataNomination.nomdateOfBirth}}</td>
																	<td>{{EmployeeMasterDataNomination.nominateRelationship}}</td>
																	<td class="wrapping" data-toggle="tooltip"
																		title="{{detail.description}}">{{EmployeeMasterDataNomination.nomineAddress}}</td>
																	<td>{{EmployeeMasterDataNomination.nominateEmail}}</td>
																	<td class=" td-actions text-center"><span>
																			<i class="fa  fa-pencil text-success text"
																			data-ng-click="editRowNomination(EmployeeMasterDataNomination)"></i>
																	</span> <span> <i
																			class="fa fa-trash-o text-danger-dker text"
																			data-ng-click="deleteRowNomination(EmployeeMasterDataNomination)"></i>
																	</span></td>
																</tr>
															</tbody>
														</table>
														<div class="dt-toolbar-footer"
															data-smart-include="views/layout/toolbar-footer.tpl"></div>
													</div>
												</div>
												<!-- end widget content -->
											</div>
											<!-- end widget div -->
										</div>
										<!-- end widget -->
									</article>
									<!-- WIDGET END -->
								</div>
							</section>
						</div>
					</div>
				</div>
				<div class="form-actions-tab">
					<div class="row">
						<div class="col-md-12" id="8">
							<button class="btn btn-info" ng-click="tabLabelPrevious();"
								style="margin-right: 1769%;">
								<i class="fa fa-arrow-left"></i> {{tabs[7].title}}
							</button>
							<button class="btn btn-info"
								style="margin-left: 91%; margin-top: -1.5%"
								ng-click="tabLabel(8)">
								{{tabs[9].title}}<i class="fa fa-arrow-right"></i>
								<!-- {{tabs[0].title}} -->
							</button>
						</div>
					</div>
				</div>
			</form>
			</tab> <tab heading="{{tabs[9].title}}" id="meritsTab" class="tab-head"
				class="tab-head" active="tabs[9].active" style="color: black;"
				ng-click="setInActive(9);">
			<form class="form-horizontal" name="Merits" id="meritsForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<button class="btn btn-info" type="button"
							data-ng-click="previous();" style="margin-right: 1029px;">
							<i class="fa fa-arrow-left"></i> {{tabs[8].title}}
						</button>

						<button class="btn btn-info" type="button" data-ng-click="next();"
							style="margin-left: 89%; margin-top: -50px;">
							{{tabs[10].title}} <i class="fa fa-arrow-right"></i>
						</button>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12">
						<%@taglib uri="http://www.springframework.org/tags"
							prefix="spring"%>
						<%@ taglib prefix="security"
							uri="http://www.springframework.org/security/tags"%>
						<div id="content">
							<!-- widget grid -->
							<section id="widget-grid" data-widget-grid>
								<div class="row">
									<article class="col-sm-12">
										<div data-jarvis-widget id="standard-datatable-widget">
											<div role="content">
												<div class="widget-body no-padding">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
														data-st-table="displayedCollectionMerit"
														data-st-safe-src="rowCollectionMerit">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<button class="btn btn-success width_12" type="button"
																ng-click="addMerits();">Add Merits</button>
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--  <th class="width_1"></th> -->
																	<th class="sorting width_20">Award Name</th>
																	<th class="sorting width_10">Scholarship Name</th>
																	<th class="sorting width_20">Description</th>
																	<th class="width_2 text-center">Action</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataMerit in displayedCollectionMerit">
																	<td class="wrapping" data-toggle="tooltip"
																		title="{{detail.description}}">{{EmployeeMasterDataMerit.awardName}}</td>
																	<td class="wrapping" data-toggle="tooltip"
																		title="{{detail.description}}">{{EmployeeMasterDataMerit.scholarshipName}}</td>
																	<td class="wrapping" data-toggle="tooltip"
																		title="{{detail.description}}">{{EmployeeMasterDataMerit.meritDesc}}</td>
																	<td class=" td-actions text-center"><span>
																			<i class="fa  fa-pencil text-success text"
																			data-ng-click="editRowMerits(EmployeeMasterDataMerit)"></i>
																	</span> <span> <i
																			class="fa fa-trash-o text-danger-dker text"
																			data-ng-click="deleteRowMerits(EmployeeMasterDataMerit)"></i>
																	</span></td>
																</tr>
															</tbody>
														</table>
														<div class="dt-toolbar-footer"
															data-smart-include="views/layout/toolbar-footer.tpl"></div>
													</div>
												</div>
												<!-- end widget content -->
											</div>
											<!-- end widget div -->
										</div>
										<!-- end widget -->
									</article>
									<!-- WIDGET END -->
								</div>
							</section>
						</div>
					</div>
				</div>
				<div class="form-actions-tab">
					<div class="row">
						<div class="col-md-12" id="9">
							<button class="btn btn-info" ng-click="tabLabelPrevious();"
								style="margin-right: 1769%;">
								<i class="fa fa-arrow-left"></i>{{tabs[8].title}}
							</button>
							<button class="btn btn-info"
								style="margin-left: 89%; margin-top: -1.5%"
								ng-click="tabLabel(9)">
								{{tabs[10].title}} <i class="fa fa-arrow-right"></i>
							</button>
						</div>
					</div>
				</div>
			</form>
			</tab> <tab heading="{{tabs[10].title}}" id="physicalTab" class="tab-head"
				active="tabs[10].active" ng-click="setInActive(10);">
			<form class="form-horizontal" name="frmPhysical" id="physicalForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<button class="btn btn-info" type="button"
							data-ng-click="previous();"
							style="margin-right: 1029px; margin-top: 10px;">
							<i class="fa fa-arrow-left"></i> {{tabs[9].title}}
						</button>
						<button class="btn btn-info" type="button" data-ng-click="next();"
							style="margin-left: 89%; margin-top: -38px;">
							{{tabs[11].title}} <i class="fa fa-arrow-right"></i>
						</button>

						<fieldset>
							<fieldset class="field_set setBorder"
								style="margin-bottom: -14px;">
								<div class="form-group">
									<label class="col-md-2 control-label"><b>Physical
											Handicaps</b><span style="color: red;"></span></label>
								</div>

								<div class="col-sm-12 col-md-3">
									<div class="form-group">
										<label class="col-md-4 control-label"> Sight <span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
											<div class="checkbox">
												<label> <input type="checkbox"
													class="checkbox style-0"
													ng-model="EmployeeMasterDataPhysical.isActiveSight"
													name="isActiveSight" data-ng-true-value="'Y'"
													data-ng-false-value="'N'"> <span></span>
												</label>
											</div>
										</div>
									</div>
								</div>

								<div class="col-sm-12 col-md-3">
									<div class="form-group">
										<label class="col-md-4 control-label"> Dumb <span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
											<div class="checkbox">
												<label> <input type="checkbox"
													class="checkbox style-0"
													ng-model="EmployeeMasterDataPhysical.isActiveDumb"
													name="isActiveDumb" data-ng-true-value="'Y'"
													data-ng-false-value="'N'"> <span></span>
												</label>
											</div>
										</div>
									</div>
								</div>

								<div class="col-sm-10 col-md-2">
									<div class="form-group">
										<label class="col-md-4 control-label"> Hearing </label>
										<div class="col-md-5">
											<div class="checkbox">
												<label> <input type="checkbox"
													class="checkbox style-0"
													ng-model="EmployeeMasterDataPhysical.isActiveHearing"
													name="isActiveHearing" data-ng-true-value="'Y'"
													data-ng-false-value="'N'"> <span></span>
												</label>
											</div>
										</div>
									</div>
								</div>

								<div class="col-sm-10 col-md-2">
									<div class="form-group">
										<label class="col-md-4 control-label"> Hand </label>
										<div class="col-md-5">
											<div class="checkbox">
												<label> <input type="checkbox"
													class="checkbox style-0"
													ng-model="EmployeeMasterDataPhysical.isActiveHand"
													name="isActiveHand" data-ng-true-value="'Y'"
													data-ng-false-value="'N'"> <span></span>
												</label>
											</div>
										</div>
									</div>
								</div>

								<div class="col-sm-10 col-md-2">
									<div class="form-group">
										<label class="col-md-4 control-label"> Feet </label>
										<div class="col-md-5">
											<div class="checkbox">
												<label> <input type="checkbox"
													class="checkbox style-0"
													ng-model="EmployeeMasterDataPhysical.isActiveFeet"
													name="isActiveFeet" data-ng-true-value="'Y'"
													data-ng-false-value="'N'"> <span></span>
												</label>
											</div>
										</div>
									</div>
								</div>
								<!-- 	<div class="col-sm-12 col-md-12">
													<div class="col-sm-6 col-md-6">
														<div class="form-group">
															<label class="col-md-4 control-label"> Other Physical Disablity </label>
															<div class="col-md-4">
															<input type="text" class="form-control input-sm"
																friendly-name="Other Disable" name="Other Disable"
																ng-model="EmployeeMasterDataPhysical.otherDisablity" />
															</div>
														</div>
													</div>
												</div>
 -->
							</fieldset>
							<br>

							<fieldset class="field_set setBorder"
								style="margin-bottom: -14px;">
								<div class="form-group">
									<label class="col-md-2 control-label"><b>Centimeters</b><span
										style="color: red;"></span></label>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Height<span
										style="color: red;">*</span></label>
									<div class="col-md-2 inputGroupContainer">
										<input type="text" class="form-control input-sm"
											data-message-id="height" validation="required"
											friendly-name="Height" name="Height"
											ng-pattern-restrict="^[0-9.]*$"
											ng-model="EmployeeMasterDataPhysical.height"
											placeholder="0.0" style="text-align: right">
									</div>
									cm
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">Weight<span
										style="color: red;">*</span></label>
									<div class="col-md-2 inputGroupContainer">
										<input type="text" class="form-control input-sm" name="Weight"
											data-message-id="weight" validation="required"
											friendly-name="Weight" ng-pattern-restrict="^[0-9.]*$"
											ng-model="EmployeeMasterDataPhysical.weight"
											placeholder="0.0" style="text-align: right">
									</div>
									Kg
								</div>

							</fieldset>
							<br>


							<fieldset class="field_set setBorder"
								style="margin-bottom: -14px;">
								<div class="form-group">
									<label class="col-md-2 control-label"><b>Eye Sight</b><span
										style="color: red;"></span></label>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label"> Left Eye Power </label>
									<div class="col-md-2 inputGroupContainer">
										<input type="text" class="form-control input-sm"
											name="leftSidePower" data-message-id="leftSidePower"
											ng-pattern-restrict="^[0-9.]*$"
											ng-model="EmployeeMasterDataPhysical.leftSidePower"
											placeholder="0.0" style="text-align: right">

									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label"> Right Eye Power
									</label>
									<div class="col-md-2 inputGroupContainer">
										<input type="text" class="form-control input-sm"
											name="rightSidePower" data-message-id="rightSidePower"
											ng-pattern-restrict="^[0-9.]*$"
											ng-model="EmployeeMasterDataPhysical.rightSidePower"
											placeholder="0.0" style="text-align: right">

									</div>
								</div>
							</fieldset>
							<br>
						</fieldset>
					</div>
				</div>
				<div class="form-actions-tab">
					<div class="row">
						<div class="col-md-12" id="10">
							<button class="btn btn-info" ng-click="tabLabelPrevious();"
								style="margin-right: 1769%;">
								<i class="fa fa-arrow-left"></i>{{tabs[9].title}}
							</button>
							<button class="btn btn-info"
								style="margin-left: 89%; margin-top: -1.5%"
								ng-click="tabLabel(10)">
								{{tabs[11].title}}<i class="fa fa-arrow-right"></i>
								<!-- {{tabs[0].title}} -->
							</button>
						</div>
					</div>
				</div>
				<div class="form-actions-tab">
					<div class="row" align="center">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit && !isPhysical"
								type="submit"
								ng-click="savePhysical(frmPhysical,EmployeeMasterDataPhysical)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" ng-if="isEdit || isPhysical"
								type="submit"
								ng-click="updatePhysical(frmPhysical,EmployeeMasterDataPhysical)">
								<i class="fa fa-save"></i> Update
							</button>

							<button class="btn btn-info" type="button"
								data-ng-click="resetPhysical(frmPhysical)">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-danger" type="button"
								data-ng-click="cancel();">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
			</tab> <tab heading="{{tabs[11].title}}" id="emergencyTab" class="tab-head"
				active="tabs[11].active" ng-click="setInActive(11);">
			<form class="form-horizontal" name="Emergency" id="emergencyForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<button class="btn btn-info" type="button"
							data-ng-click="previous();" style="margin-right: 1029px;">
							<i class="fa fa-arrow-left"></i> {{tabs[10].title}}
						</button>
						<button class="btn btn-info" type="button" data-ng-click="next();"
							style="margin-left: 89%; margin-top: -1px;">
							{{tabs[12].title}} <i class="fa fa-arrow-right"></i>
						</button>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<%@taglib uri="http://www.springframework.org/tags"
							prefix="spring"%>
						<%@ taglib prefix="security"
							uri="http://www.springframework.org/security/tags"%>
						<div id="content">
							<!-- widget grid -->
							<section id="widget-grid" data-widget-grid>
								<div class="row">
									<article class="col-sm-12">
										<div data-jarvis-widget id="standard-datatable-widget">
											<div role="content">
												<div class="widget-body no-padding">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
														data-st-table="displayedCollectionEme"
														data-st-safe-src="rowCollectionEme">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<button class="btn btn-success width_20" type="button"
																ng-click="addEmergency();">Emergency Contact
																Details</button>
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--  <th class="width_1"></th> -->
																	<th class="sorting width_20">Name</th>
																	<th class="sorting width_10">Designation</th>
																	<th class="sorting width_20">Email</th>
																	<th class="sorting width_20">Place</th>
																	<th class="sorting width_10">Occupation</th>
																	<th class="sorting width_10">Address</th>
																	<th class="sorting width_10">Pincode</th>
																	<th class="width_2 text-center">Action</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataEme in displayedCollectionEme">
																	<!--   <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDataEme.emergencyName}}</td>
																	<td class="wrapping">{{EmployeeMasterDataEme.emergRelationship}}</td>
																	<td class="wrapping">{{EmployeeMasterDataEme.emergEmail}}</td>
																	<td class="wrapping">{{EmployeeMasterDataEme.emergPlace}}</td>
																	<td class="wrapping">{{EmployeeMasterDataEme.emergencyOccu}}</td>
																	<td class="wrapping" data-toggle="tooltip"
																		title="{{detail.description}}">{{EmployeeMasterDataEme.emerAddress}}</td>

																	<td>{{EmployeeMasterDataEme.emergencyPincode}}</td>
																	<td class=" td-actions text-center"><span>
																			<i class="fa  fa-pencil text-success text"
																			data-ng-click="editRowEmergency(EmployeeMasterDataEme)"></i>
																	</span> <span> <i
																			class="fa fa-trash-o text-danger-dker text"
																			data-ng-click="deleteRowEmergency(EmployeeMasterDataEme)"></i>
																	</span></td>
																</tr>
															</tbody>
														</table>
														<div class="dt-toolbar-footer"
															data-smart-include="views/layout/toolbar-footer.tpl"></div>
													</div>
												</div>
												<!-- end widget content -->
											</div>
											<!-- end widget div -->
										</div>
										<!-- end widget -->
									</article>
									<!-- WIDGET END -->
								</div>
							</section>
						</div>
					</div>
				</div>
				<div class="form-actions-tab">
					<div class="row">
						<div class="col-md-12" id="11">
							<button class="btn btn-info" ng-click="tabLabelPrevious();"
								style="margin-right: 1769%;">
								<i class="fa fa-arrow-left"></i>{{tabs[10].title}}
							</button>
							<button class="btn btn-info"
								style="margin-left: 89%; margin-top: -1.5%"
								ng-click="tabLabel(11)">
								{{tabs[12].title}}<i class="fa fa-arrow-right"></i>
								<!-- {{tabs[0].title}} -->
							</button>
						</div>
					</div>
				</div>
			</form>
			</tab> <tab heading="{{tabs[12].title}}" id="referenceTab" class="tab-head"
				active="tabs[12].active" ng-click="setInActive(12);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<button class="btn btn-info" type="button"
							data-ng-click="previous();" style="margin-right: 1029px;">
							<i class="fa fa-arrow-left"></i> {{tabs[11].title}}
						</button>
						<button class="btn btn-info" type="button" data-ng-click="next();"
							style="margin-left: 89%; margin-top: -1px;">
							{{tabs[13].title}} <i class="fa fa-arrow-right"></i>
						</button>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<%@taglib uri="http://www.springframework.org/tags"
							prefix="spring"%>
						<%@ taglib prefix="security"
							uri="http://www.springframework.org/security/tags"%>
						<div id="content">
							<!-- widget grid -->
							<section id="widget-grid" data-widget-grid>
								<div class="row">
									<article class="col-sm-12">
										<div data-jarvis-widget id="standard-datatable-widget">
											<div role="content">
												<div class="widget-body no-padding">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
														data-st-table="displayedCollectionRef"
														data-st-safe-src="rowCollectionRef">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button>
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th class="sorting width_20">Name</th>
																	<th class="sorting width_10">Designation</th>
																	<th class="sorting width_20">Email</th>
																	<th class="sorting width_10">Occupation</th>
																	<th class="sorting width_10">Address</th>
																	<th class="sorting width_10">Pincode</th>
																	<th class="width_2 text-center">Action</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataRef in displayedCollectionRef">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDataRef.referenceName}}</td>
																	<td class="wrapping">{{EmployeeMasterDataRef.relationshipRef}}</td>
																	<td class="wrapping">{{EmployeeMasterDataRef.emailRef}}</td>
																	<td class="wrapping">{{EmployeeMasterDataRef.occupationRef}}</td>
																	<td class="wrapping" data-toggle="tooltip"
																		title="{{detail.description}}">{{EmployeeMasterDataRef.referenceAddress}}</td>
																	<td>{{EmployeeMasterDataRef.pincodeRef}}</td>
																	<td class=" td-actions text-center"><span>
																			<i class="fa  fa-pencil text-success text"
																			data-ng-click="editRowReference(EmployeeMasterDataRef)"></i>
																	</span> <span> <i
																			class="fa fa-trash-o text-danger-dker text"
																			data-ng-click="deleteRowReference(EmployeeMasterDataRef)"></i>
																	</span></td>
																</tr>
															</tbody>
														</table>
														<div class="dt-toolbar-footer"
															data-smart-include="views/layout/toolbar-footer.tpl"></div>
													</div>
												</div>
												<!-- end widget content -->
											</div>
											<!-- end widget div -->
										</div>
										<!-- end widget -->
									</article>
									<!-- WIDGET END -->
								</div>
							</section>
						</div>
					</div>
				</div>
				<div class="form-actions-tab">
					<div class="row">
						<div class="col-md-12" id="12">
							<button class="btn btn-info" ng-click="tabLabelPrevious();"
								style="margin-right: 1769%;">
								<i class="fa fa-arrow-left"></i>{{tabs[11].title}}
							</button>
							<button class="btn btn-info"
								style="margin-left: 89%; margin-top: -1.5%"
								ng-click="tabLabel(12)">
								{{tabs[13].title}}<i class="fa fa-arrow-right"></i>
							</button>
						</div>
					</div>
				</div>
			</form>
			</tab> <tab heading="{{tabs[13].title}}" id="documentsTab" class="tab-head"
				active="tabs[13].active" ng-click="setInActive(13);">
			<form class="form-horizontal" name="Documents" id="documentsForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<button class="btn btn-info" type="button"
							data-ng-click="previous();" style="margin-right: 1029px;">
							<i class="fa fa-arrow-left"></i> {{tabs[12].title}}
						</button>
						<button class="btn btn-info" type="button" data-ng-click="next();"
							style="margin-left: 91%; margin-top: -50px;">
							{{tabs[14].title}} <i class="fa fa-arrow-right"></i>
						</button>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12">
						<%@taglib uri="http://www.springframework.org/tags"
							prefix="spring"%>
						<%@ taglib prefix="security"
							uri="http://www.springframework.org/security/tags"%>
						<div id="content">
							<!-- widget grid -->
							<section id="widget-grid" data-widget-grid>
								<div class="row">
									<article class="col-sm-12">
										<div data-jarvis-widget id="standard-datatable-widget">
											<div role="content">
												<div class="widget-body no-padding">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
														data-st-table="displayedCollectionDoc"
														data-st-safe-src="rowCollectionDoc">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<button class="btn btn-success width_12" type="button"
																ng-click="addDocuments();">Add Documents</button>
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>

																	<th class="sorting width_20">Name</th>
																	<th class="sorting width_10">Description</th>
																	<th class="width_2 text-center">Action</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataDoc in displayedCollectionDoc">

																	<td class="wrapping">{{EmployeeMasterDataDoc.docName}}</td>
																	<td class="wrapping">{{EmployeeMasterDataDoc.description}}</td>
																	<td class=" td-actions text-center"><span>
																			<i class="fa  fa-pencil text-success text"
																			data-ng-click="editRowDoc(EmployeeMasterDataDoc)"></i>
																	</span> <span> <i
																			class="fa fa-trash-o text-danger-dker text"
																			data-ng-click="deleteRowDoc(EmployeeMasterDataDoc)"></i>
																	</span> <span> <i
																			class="fa  fa-download text-success text"
																			data-ng-click="downloadDoc(EmployeeMasterDataDoc)"></i>
																			<a id="TBExport" stype="display:none"
																			href={{EmployeeMasterDataDoc.uploadDoc}} download></a>
																	</span></td>
																</tr>
															</tbody>
														</table>
														<div class="dt-toolbar-footer"
															data-smart-include="views/layout/toolbar-footer.tpl"></div>
													</div>
												</div>
												<!-- end widget content -->
											</div>
											<!-- end widget div -->
										</div>
										<!-- end widget -->
									</article>
									<!-- WIDGET END -->
								</div>
							</section>
						</div>
					</div>
				</div>
				<div class="form-actions-tab">
					<div class="row">
						<div class="col-md-12" id="9">
							<button class="btn btn-info" ng-click="tabLabelPrevious();"
								style="margin-right: 1769%;">
								<i class="fa fa-arrow-left"></i>{{tabs[12].title}}
							</button>
							<button class="btn btn-info"
								style="margin-left: 91%; margin-top: -1.5%"
								ng-click="tabLabel(13)">
								{{tabs[14].title}} <i class="fa fa-arrow-right"></i>
							</button>
						</div>
					</div>
				</div>
			</form>
			</tab> <tab heading="{{tabs[14].title}}" id="historyTab" class="tab-head"
				active="tabs[14].active" ng-click="setInActive(14);">
			<form class="form-horizontal" name="history" id="historyForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<button class="btn btn-info" type="button"
							data-ng-click="previous();" style="margin-right: 1029px;">
							<i class="fa fa-arrow-left"></i> {{tabs[13].title}}
						</button>


						<button class="btn btn-info" ng-if='driverTab' type="button"
							data-ng-click="next();"
							style="margin-left: 88%; margin-top: -50px;">
							{{tabs[15].title}} <i class="fa fa-arrow-right"></i>
						</button>
						<button class="btn btn-info" type="button" data-ng-click="next1();"
							style="margin-left: 85%; margin-top: -50px;" ng-if='salesTab'>
							{{tabs[16].title}} <i class="fa fa-arrow-right"></i>
						</button>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12">
						<%@taglib uri="http://www.springframework.org/tags"
							prefix="spring"%>
						<%@ taglib prefix="security"
							uri="http://www.springframework.org/security/tags"%>
						<div id="content">
							<!-- widget grid -->
							<section id="widget-grid" data-widget-grid>
								<div class="row">
									<article class="col-sm-12">
										<div data-jarvis-widget id="standard-datatable-widget">
											<div role="content">
												<div class="widget-body no-padding">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
														data-st-table="displayedCollectionHistory"
														data-st-safe-src="rowCollectionHistory">
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<th class="sorting width_3">Employee Id</th>
																	<th class="sorting width_8">Employee Name</th>
																	<th class="sorting width_2">Date</th>
																	<th class="sorting width_5">Column Name</th>
																	<th class="sorting width_8">Old Value</th>
																	<th class="sorting width_8">New Value</th>
																	<th class="sorting width_10">Comments</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataHistory in displayedCollectionHistory">
																	<td>{{EmployeeMasterDataHistory.employeeId}}</td>
																	<td>{{EmployeeMasterDataHistory.employeeName}}</td>
																	<td align="right">{{EmployeeMasterDataHistory.employmentDate}}</td>
																	<td>{{EmployeeMasterDataHistory.columnName}}</td>
																	<td>{{EmployeeMasterDataHistory.oldValue}}</td>
																	<td>{{EmployeeMasterDataHistory.newValue}}</td>
																	<td>{{EmployeeMasterDataHistory.comments}}</td>
																</tr>
															</tbody>
														</table>
														<div class="dt-toolbar-footer"
															data-smart-include="views/layout/toolbar-footer.tpl"></div>
													</div>
												</div>
												<!-- end widget content -->
											</div>
											<!-- end widget div -->
										</div>
										<!-- end widget -->
									</article>
									<!-- WIDGET END -->
								</div>
							</section>
						</div>
					</div>
				</div>
				<div class="form-actions-tab">
					<div class="row">
						<div class="col-md-12" id="9">
							<button class="btn btn-info" ng-click="tabLabelPrevious();"
								style="margin-right: 1769%;">
								<i class="fa fa-arrow-left"></i>{{tabs[13].title}}
							</button>
							<button class="btn btn-info" type="button"
								data-ng-click="next();"
								style="margin-left: 88%; margin-top: -50px;" ng-if='driverTab'>
								{{tabs[15].title}} <i class="fa fa-arrow-right"></i>
							</button>
							<button class="btn btn-info" type="button"
								data-ng-click="next1();"
								style="margin-left: 85%; margin-top: -50px;" ng-if='salesTab'>
								{{tabs[16].title}} <i class="fa fa-arrow-right"></i>
							</button>
						</div>
					</div>
				</div>
			</form>
			</tab> <tab heading="{{tabs[15].title}}" id="driverTab" class="tab-head"
				active="tabs[15].active" ng-click="setInActive(15);"
				ng-if='driverTab'>
			<form class="form-horizontal" name="truckdriverForm"
				id="truckdriverForm" novalidate>

					<button class="btn btn-info" type="button" style="margin-right: 1000%;margin-top: 21px;"
						data-ng-click="previous();" >
						<i class="fa fa-arrow-left"></i> {{tabs[14].title}}
					</button>
				
				<div class="col-sm-12 col-md-12 col-lg-12">
					<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
					<%@ taglib prefix="security"
						uri="http://www.springframework.org/security/tags"%>
					<div id="content">
						<!-- widget grid -->



						<div class="wrapper-md">
							<div class="panel panel-default panel-default-form">


								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-6 col-lg-offset-3">
										<fieldset>
											<div class="form-group">
												<label class="col-md-4 control-label"> Truck <span
													style="color: red;">*</span></label>
												<div class="col-md-6 inputGroupContainer">
													<selectivity list="truckList"
														ng-model="truckdrivermodel.truckId" name="truckId"
														form-name="truckdriverForm"
														property="truckdrivermodel.truckId" id="truckId"
														validation="required" friendly-name="Truck"></selectivity>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label"> Driver <span
													style="color: red;">*</span>
												</label>
												<div class="col-md-6 inputGroupContainer">

													<selectivity list="driverList" disabled="true"
														ng-model="truckdrivermodel.driverId=EmployeeMasterData.empId"
														name="driverId" form-name="truckdriverForm"
														property="truckdrivermodel.driverId" id="driverId"
														validation="required" friendly-name="Driver"></selectivity>
												</div>
											</div>


											<div class="form-group">
												<label class="col-md-4 control-label">From Date<span
													style="color: red;">*</span>
												</label>
												<div class="col-md-6">

													<ng-bs3-datepicker
														data-ng-model="truckdrivermodel.fromDate" id="fromDate"
														name="fromDate" form-name="truckdriverForm"
														data-ng-change="checkDatesCL(truckdrivermodel.fromDate)"
														friendly-name="From Date" validation="required" />
												</div>
											</div>


											<div class="form-group">
												<label class="col-md-4 control-label">To Date
												<span
													style="color: red;">*</span></label>

												<div class="col-md-6">

													<ng-bs3-datepicker data-ng-model="truckdrivermodel.toDate"
														id="toDate" name="toDate" form-name="toForm"
														data-ng-change="checkDatesCL(truckdrivermodel.toDate)"
														friendly-name="To Date" validation="required"/>
												</div>
											</div>



										</fieldset>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
			<div class="form-actions-tab">
				<div class="row">
					<div class="col-md-12" id="9">
						<button class="btn btn-info" ng-click="tabLabelPrevious();"
							style="margin-right: 1769%;">
							<i class="fa fa-arrow-left"></i>{{tabs[14].title}}
						</button>
						<!-- <button class="btn btn-info" style="margin-left: 1039px;margin-top:-54px;" ng-click="tabLabel(13)">
														{{tabs[14].title}}	<i class="fa fa-arrow-right"></i>													
													</button> -->
					</div>
				</div>
			</div>

			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">

						<button class="btn btn-success" 
							ng-click="validateDriver(truckdriverForm)">
							<i class="fa fa-save"></i> Save
						</button>

						<!-- <button class="btn btn-success" ng-if="isEdit" type="submit"
							ng-click="validateDriver(truckdriverForm)">
							<i class="fa fa-save"></i> Update
						</button> -->
						<button class="btn btn-info" ng-if="!isEdit" type="reset"
							ng-click="reset()">
							<i class="fa fa-reply"></i> Reset
						</button>
						<button class="btn btn-danger" ng-click="cancel()" type="button">
							<i class="fa fa-close"></i> Cancel
						</button>
					</div>
				</div>
			</div>

			</tab> <!-- WIDGET END --> <tab heading="{{tabs[16].title}}" id="salesTab"
				class="tab-head" active="tabs[16].active"
				ng-click="setInActive(16);" ng-if='salesTab'>
			<div class="wrapper-md">
				<div class="form-actions-tab" ng-if='salesTab'>
					<div class="row">
						<div class="col-md-12" id="9">
							<button class="btn btn-info" ng-click="tabLabelPrevious();"
								style="margin-right: 1769%;">
								<i class="fa fa-arrow-left"></i>{{tabs[14].title}}
							</button>
							<!-- <button class="btn btn-info" style="margin-left: 1039px;margin-top:-54px;" ng-click="tabLabel(13)">
														{{tabs[14].title}}	<i class="fa fa-arrow-right"></i>													
													</button> -->
						</div>
					</div>
				</div>
				<div class="panel panel-default panel-default-list"
					st-table="displayedCollection"
					st-safe-src="customerdisplayedCollection">
					<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
					<!-- </div> -->
					<div class="panel-body float-left padding-0" style="width: 100%;">

						<div class="table-responsive ">
							<table
								class="table table-striped table-hover dataTable no-footer">
								<thead class="dataTables-Main-Head">
								<thead>
									<tr>
										<th class="sorting width_2" st-sort="customerName">Customer
											Code</th>
										<th class="sorting width_2" st-sort="customerName">Account
											Head Code</th>
										<th class="sorting width_2" st-sort="customerName">Customer
											Name</th>
										<th class="sorting width_3" st-sort="customerShortName">Customer
											Short Name</th>
										<th class="sorting width_3" st-sort="country">Country</th>
										<th class="sorting width_3" st-sort="currency">Currency</th>
										<th class="sorting width_3" st-sort="status">Active</th>
										<th class="sorting width_2">Action</th>
									</tr>
								</thead>

								</thead>

								<tbody class="dataTables-Main-Body">

									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
										ng-repeat="objItem in displayedCollection">
										<td class="">{{objItem.customerCode}}</td>
										<td class="">{{objItem.accountNumber}}</td>
										<td class="">{{objItem.custName}}</td>
										<td class="">{{objItem.customerShortName}}</td>
										<td class="">{{objItem.countryName}}</td>
										<td class="">{{objItem.currency}}</td>
										<td class="">{{objItem.active}}</td>
										<!-- 	<td class="td-actions text-center"><span
											class="edit-button  padding-right-5"
											data-ng-click="editRow(objItem)" tooltip="Edit Row"> <i
												class="fa  fa-pencil text-success text"></i>
										</span> <span class="delete-button"
											data-ng-click="deleteCustomer(objItem.customerCode,$index)"
											tooltip="Delete Row"> <i
												class="fa fa-trash-o text-danger-dker tex"></i>
										</span></td> -->
									</tr>
								</tbody>


							</table>
						</div>
						<footer class="panel-footer panel-footer-list">
							<%@include file="/views/templates/panel-footer-static.jsp"%>
						</footer>
						<div class="form-actions-tab" ng-if='salesTab'>
							<div class="row">
								<div class="col-md-12" id="9">
									<button class="btn btn-info" ng-click="tabLabelPrevious();"
										style="margin-right: 1769%;">
										<i class="fa fa-arrow-left"></i>{{tabs[14].title}}
									</button>
									<!-- <button class="btn btn-info" style="margin-left: 1039px;margin-top:-54px;" ng-click="tabLabel(13)">
														{{tabs[14].title}}	<i class="fa fa-arrow-right"></i>													
													</button> -->
								</div>
							</div>
						</div>
					</div>
					<!-- end widget content -->
				</div>
			</div>
		</div>


		</tab>




		</tabset> --%>
</div>
</div>
</div>
		<script type="text/ng-template" id="employeeConfirm">
<div class="modal-header modal-header-new padding-left-10 padding-top-0 padding-bottom-0 padding-right-0  line-height-30"
	style="font-weight: bold; width: 40%;">Your Employee Id and Password</div>
<div class="row">
	<div class="col-lg-12">
		<div class="col-lg-12">
			<label class="col-md-4 control-label">Employee ID:</label> <label
				class="col-md-1 control-label" style="padding-right: 0px;">{{EmployeeMasterData.empId}}</label>
		</div>
		<div class=" col-lg-12">
			<label class="col-md-4 control-label">Password:</label> <label
				class="col-md-1 control-label" style="padding-right: 0px;">{{EmployeeMasterData.pwd}}</label>
		</div>
	</div>
</div>
<div class="modal-footer" style="padding: 10px">
	<button class="btn btn-danger" ng-click="employeeConfirm()">Ok</button>
</div>
 </script>