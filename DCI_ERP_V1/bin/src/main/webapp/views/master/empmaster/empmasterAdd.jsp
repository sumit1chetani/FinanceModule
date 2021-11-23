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

a:hover {
	text-decoration: underline;
}

.ngdialog-content {
	background: #fff !important;
}

.tab-head {
	background: #1f3113 !important;
	color: black;
}

div#dependVisa1>ul {
	margin-left: -43% !important;
}

div#dependVisa>ul {
	margin-top: -75% !important;
}

.nav-tabs>li>a {
	color: :#fff !important;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<tabset> <tab heading="{{tabs[0].title}}" class="tab-head"
				active="tabs[0].active" ng-click="setInActive(0);">
			<form class="form-horizontal" name="frmProfile" id="profileForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
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
							<!-- 	<div class="form-group" id="userId">
								<label class="col-md-4 control-label">User ID<span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="User Id"
										ng-model="EmployeeMasterData.empUserId"
										validation="pattern=/^[0-9a-zA-Z\.]{0,15}$/|required"
										data-message-id="empuseId"
										friendly-name="UserId is AlpaNumeric and length is 15 and Required"
										maxlength="15">
								</div>
							</div> -->
							<div class="form-group" id="pass" ng-if="!isEdit">
								<label class="col-md-4 control-label">Password<span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<input type="{{password}}" class="form-control input-sm"
										id="password" name="Password"
										ng-model="EmployeeMasterData.pwd" validation="required"
										friendly-name="PassWord" data-message-id="pwd"
										ng-hide="hidePass" >
								</div>
								<!-- <button class="btn btn-sm btn-primary" type="button"
													data-ng-click="visiblePassword()">
													<i class="{{eyeIcon}}"></i> {{textValue}}
												</button> -->
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">First Name <span
									style="color: red;">*</span></label>
								<div class="col-md-2 inputGroupContainer">
									<selectivity list="statusList"
										property="EmployeeMasterData.firstName1"
										ng-model="EmployeeMasterData.firstName1" validation="required"
										friendly-name="firstName" name="firstName"
										form-name="frmProfile"></selectivity>
								</div>
								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm"
										ng-model="EmployeeMasterData.firstName" name="firstName"
										data-message-id="firstName" validation="required"
										friendly-name="First Name">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Middle Name <span
									style="color: red;"></span></label>
								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm"
										name="middleName" ng-model="EmployeeMasterData.middleName">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Last Name<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="lastName" ng-model="EmployeeMasterData.lastName">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Father's Name<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="fatherName" ng-model="EmployeeMasterData.fatherName">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Mother's Name<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="momcyName" ng-model="EmployeeMasterData.momcyName">
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label">Citizenship</label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm"
										name="citizen" ng-model="EmployeeMasterData.citizen"
										maxlength="25"> -->
									<selectivity list="countryList"
										property="EmployeeMasterData.citizen"
										ng-model="EmployeeMasterData.citizen"
										friendly-name="citizen Name" name="citizen Name"
										form-name="frmProfile"></selectivity>

								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"> Other Citizenship</label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm"
										name="othercitizen" ng-model="EmployeeMasterData.othercitizen"
										maxlength="25"> -->
									<selectivity list="countryList"
										property="EmployeeMasterData.othercitizen"
										ng-model="EmployeeMasterData.othercitizen"
										friendly-name="othercitizen Name" name="othercitizen Name"
										form-name="othercitizen"></selectivity>
								</div>
							</div>

							<!-- 	<div class="form-group">
								<label class="col-md-4 control-label"> Home Destination Port<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="homedesti" ng-model="EmployeeMasterData.homedesti"
										maxlength="25">
								</div>
							</div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">Home Destination
									Port </label>
								<div class="col-md-5">
									<select class="form-control input-sm"
										ng-model="EmployeeMasterData.homedesti" name="noticeperiod"
										data-message-id="homedesti" friendly-name="homedesti">

										<option value="">--Select--</option>
										<option value="DXB-BANGLADESH-DXB">DXB-BANGLADESH-DXB</option>
										<option value="DXB-BANGLADESH-DXB">DXB-BANGLADESH-DXB</option>
										<option value="DXB-BILLUND-DXB">DXB-BILLUND-DXB</option>
										<option value="DXB-ATH-DXB">DXB-ATH-DXB</option>
										<option value="DXB-AHMADABAD-DXB">DXB-AHMADABAD-DXB</option>
										<option value="DXB-BLR-DXB">DXB-BLR-DXB</option>
										<option value="DXB-BOM-DXB">DXB-BOM-DXB</option>
										<option value="DXB-CHENNAI-DXB">DXB-CHENNAI-DXB</option>
										<option value="DXB-CNN-DXB">DXB-CNN-DXB</option>
										<option value="DXB-CHANDIGARH-DXB">DXB-CHANDIGARH-DXB</option>

										<option value="DXB-COIMBATORE-DXB">DXB-COIMBATORE-DXB</option>
										<option value="DXB-COK-DXB">DXB-COK-DXB</option>
										<option value="DXB-DEL-DXB">DXB-DEL-DXB</option>
										<option value="DXB-GOA-DXB">DXB-GOA-DXB</option>
										<option value="DXB-HYD-DXB">DXB-HYD-DXB</option>
										<option value="DXB-IXM-DXB">DXB-IXM-DXB</option>
										<option value="DXB-KOLKOTA-DXB">DXB-KOLKOTA-DXB</option>
										<option value="DXB-LUCKNOW-DXB">DXB-LUCKNOW-DXB</option>
										<option value="DXB-MAA-DXB">DXB-MAA-DXB</option>
										<option value="DXB-MAA-DXB">DXB-MAA-DXB</option>

										<option value="DXB-MANGLORE-DXB">DXB-MANGLORE-DXB</option>
										<option value="DXB-PNQ-DXB">DXB-PNQ-DXB</option>
										<option value="DXB-TRICHY-DXB">DXB-TRICHY-DXB</option>
										<option value="DXB-VISAKHAPATNAM-DXB">DXB-VISAKHAPATNAM-DXB</option>
										<option value="DXB-TEHRAN-DXB">DXB-TEHRAN-DXB</option>
										<option value="DXB-BEIRUT-DXB">DXB-BEIRUT-DXB</option>

										<option value="DXB-MALAYSIA-DXB">DXB-MALAYSIA-DXB</option>
										<option value="DXB-BELGIUM-DXB">DXB-BELGIUM-DXB</option>

										<option value="DXB-CAIRO-DXB">DXB-CAIRO-DXB</option>
										<option value="DXB-FRN-DXB">DXB-FRN-DXB</option>
										<option value="DXB-SWEDEN-DXB">DXB-SWEDEN-DXB</option>
										<option value="DXB-TAI-DXB">DXB-TAI-DXB</option>
										<option value="DXB-MNL">DXB-MNL</option>
									</select>
								</div>
							</div>

							<!-- 	<div class="form-group">
								<label class="col-md-4 control-label">Air Ticket Class<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="airticketclass" ng-model="EmployeeMasterData.airticketclass"
										maxlength="25">
								</div>
							</div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">Air Ticket Class </label>
								<div class="col-md-5">
									<select class="form-control input-sm"
										ng-model="EmployeeMasterData.airticketclass"
										name="airticketclass" data-message-id="airticketclass"
										friendly-name="airticketclass">

										<option value="">--Select--</option>
										<option value="Economy">Economy</option>
										<option value="Business">Business</option>

									</select>
								</div>
							</div>
							<!-- <div class="form-group"
													ng-init="EmployeeMasterData.gender='M'">
													<label class="col-md-4 control-label">Gender<span
														style="color: red;">*</span></label>
													<div class="radio radio-inline">
														<label class="i-checks"> <input type="radio"
															class="" name="gender" value="M"
															ng-model="EmployeeMasterData.gender"> <i></i>
															Male
														</label>
													</div>
													<div class="radio radio-inline">
														<label class="i-checks"> <input type="radio"
															class="" name="gender" value="F"
															ng-model="EmployeeMasterData.gender"> <i></i>
															Female
														</label>
													</div>
												</div> -->

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
								<!-- <div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" class=""
										name="gender" value="T" ng-model="EmployeeMasterData.gender">
										<i></i> Transgender
									</label>
								</div> -->
							</div>
							<!-- 
							<div class="form-group">
								<label class="col-md-4 control-label">DOB<span
									style="color: red;">*</span></label>

								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="EmployeeMasterData.dob"
										id="dob" name="dob" form-name="toForm" friendly-name="dob"
										validation="required" />
								</div>
							</div> -->

							<div class="form-group">
								<label class="col-md-4 control-label">DOB<span
									style="color: red;">*</span></label>

								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="EmployeeMasterData.dob"
										id="dateofbirth" name="dateofbirth" form-name="frmProfile"
										friendly-name="dob" />
								</div>
							</div>
							<!-- 	<div class="form-group">
								<label class="col-md-4 control-label">DOB <span
									style="color: red;">*</span></label>
								<div class="col-md-5 inputGroupContainer">


									<div class="input-group input-append date">
										<input type="text" class="form-control input-sm" id="dob"
											name="dob" ng-model="EmployeeMasterData.dob"
											validation="required" friendly-name="dob" /> <span
											class="input-group-addon add-on"><span
											class="glyphicon glyphicon-calendar"></span></span>
									</div>

								</div>
							</div> -->
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">DOB<span
									style="color: red;">*</span></label>
								<div class="col-md-6 inputGroupContainer">

									<div class="input-group input-append date">
										<input type="text" class="form-control input-sm" id="dob"
											name="DOB" ng-model="EmployeeMasterData.dob"
											validation="required" friendly-name="DOB" /> <span
											class="input-group-addon add-on"><span
											class="glyphicon glyphicon-calendar"></span></span>
									</div>



								</div>
							</div> -->






							<!-- div class="form-group">
								<label class="col-md-4 control-label">DOB <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<div class='input-group date datetimepick'>
										<div class="dropdown" style="margin-top: -18px;">
											<a class="dropdown-toggle" id="dob" role="button"
												style="padding-left: 15px;" data-toggle="dropdown"
												data-target="#" href="#">
												<div class="input-group">
													<input type="text" class="form-control"
														placeholder="dd/mm/yyyy" name="Date of Birth"
														data-message-id="Date of Birth" validation="required"
														friendly-name="DOB" data-ng-model="EmployeeMasterData.dob"><span
														class="input-group-addon"><i
														class="glyphicon glyphicon-calendar"></i></span>
												</div>

											</a>
											<ul class="dropdown-menu" role="menu"
												aria-labelledby="dLabel">
												<datetimepicker data-ng-model="EmployeeMasterData.dob"
													data-on-set-time="EmployeeMasterData.dob = onDateSet(newDate)"
													data-datetimepicker-config="{ dropdownSelector: '#dob',startView:'day', minView:'day'}" />
											</ul>
										</div>
									</div>
								</div>
							</div> -->

							<div class="form-group">
								<label class="col-md-4 control-label">Insurance Policy
									No<span style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Insurance Policy No"
										ng-model="EmployeeMasterData.insuranceNo" maxlength="30">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Email ID <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="emailId"
										ng-model="EmployeeMasterData.emailId"
										placeholder='your@email.com' validation="required"
										friendly-name="Email ID" form-name="frmProfile"
										maxlength="250">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Official Mobile No
									<span style="color: red;">*</span>
								</label>

								<div class="col-md-4  padding-left-4 ">
									<input type="text" class="form-control input-sm" maxlength="70"
										style="width: 100%;" name="mobileNo"
										ng-model="EmployeeMasterData.mobileNo" validation="required"
										friendly-name="Official Mobile No">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">DOJ <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="EmployeeMasterData.doj"
										id="doj" name="DOJ" form-name="toForm" friendly-name="DOJ"
										validation="required" />
								</div>

							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"> Is Active<span
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



							<div class="form-group">
								<label class="col-md-4 control-label"> Is Email Exempted<span
									style="color: red;"></span>

								</label>
								<div class="col-md-5">
									<div class="checkbox">
										<label> <input type="checkbox"
											class="checkbox style-0"
											ng-model="EmployeeMasterData.isEmailExempted" name="status"
											data-ng-true-value="'Y'" data-ng-false-value="'N'"> <span></span>
										</label>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"> Is Application
									User<span style="color: red;"></span>

								</label>
								<div class="col-md-5">
									<div class="checkbox">
										<label> <input type="checkbox"
											class="checkbox style-0" ng-model="EmployeeMasterData.isapp"
											name="isapp" data-ng-true-value="'Y'"
											data-ng-false-value="'N'"> <span></span>
										</label>
									</div>
								</div>
							</div>

							<!-- 							
<div  class="form-group">
        <label class="col-md-4 control-label">
         Is Agent
        </label>
        <div class="col-md-5">
         <div class="checkbox">
          <label >
           <input type="checkbox" class="checkbox style-0"  name="vendor" ng-true-value="'Y'"
												ng-false-value="'N'"
            ng-model="EmployeeMasterData.vendor" ng-click="agent(EmployeeMasterData.vendor)" >
           <i></i>
          </label>
         </div>
        </div>
        </div> -->


							<!-- <div class="form-group" data-ng-if="agentid">
									<label class="col-md-4 control-label"> Agency
									</label>
									<div class="col-md-5 inputGroupContainer">
										<select class="form-control journalVoucher-textBox"
											ng-model="EmployeeMasterData.customerName" id="id"
											name="id" data-message-id="companyCode"
											 friendly-name="Branch"
											ng-options="emp.id as emp.text for emp in vendorList"
											>
											<option value="" selected="selected">Select</option>
										</select>
									</div>
								</div>	 -->


							<!-- <div class="form-group" data-ng-if="agentid">
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
								</div> -->


							<div class="form-group">
								<label class="col-md-4 control-label">UAN No<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="uan"
										ng-model="EmployeeMasterData.uan" maxlength="30">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">ESIC No<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										ng-blur="checkESICNo(EmployeeMasterData.esic)" name="esic"
										ng-model="EmployeeMasterData.esic" maxlength="50">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">EPF No<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										ng-blur="checkEPFNo(EmployeeMasterData.epfNo)" name="epfNo"
										ng-model="EmployeeMasterData.epfNo" maxlength="50">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Fixed Gross</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="fixedGross" ng-model="EmployeeMasterData.fixedGross"
										style="text-align: right" data-message-id="fixedGross">
								</div>
							</div>



							<div class="form-group">
								<label class="col-md-4 control-label">Salary Breakup</label>
								<div class="col-md-5">
								 <button class="btn btn-success" type="button" data-toggle="tooltip" 
								 title="Salary Breakup"
											data-ng-click="viewRow(employeeId)" id="employeeId">
											<i class="fa fa-bolt"></i> Click Here
						         </button> 
								
								</div>
							</div> 
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">Salary Breakup</label>
							
							<div class ="col-md-1">
							<i class="fa  fa-eye text-success text" style = "font-size: 15px;"
                           data-toggle="tooltip" title="View"
							data-ng-click="viewRow(bookingData.customer)"></i>	
							</div> -->
									
									
							<div class="form-group">
								<label class="col-md-4 control-label">Social Security No<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="socialNo" ng-model="EmployeeMasterData.socialNo"
										maxlength="50">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Income Tax No<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="incometaxNo" ng-model="EmployeeMasterData.incometaxNo"
										maxlength="50">
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label">Fax Number<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="faxName"
										ng-model="EmployeeMasterData.faxName" maxlength="25">
								</div>
							</div>

							<!-- <div class="form-group">
												<label class="col-md-4 control-label"> Customer <span
													style="color: red;">*</span></label>
												<div class="col-md-5">
													<selectivity list="customerList"
														property="EmployeeMasterData.customerId"
														ng-model="EmployeeMasterData.customerId"
														friendly-name="Customer" name="Customer"
														form-name="frmProfile"></selectivity>
												</div>
											</div> -->
							<!-- <div class="form-group"
												ng-init="EmployeeMasterData.category='H'">
												<label class="col-md-4 control-label">Category<span
													style="color: red;"></span></label>
												<div class="radio radio-inline">
													<label class="i-checks"> <input type="radio"
														class="" name="Category" value="H"
														ng-model="EmployeeMasterData.category" ng-change="category(EmployeeMasterData.category)"> <i></i> 
														Hospital
													</label>
												</div>
												<div class="radio radio-inline">
													<label class="i-checks"> <input type="radio"
														class="" name="Category" value="C"
														ng-model="EmployeeMasterData.category" ng-change="category(EmployeeMasterData.category)"> <i></i>
														College
													</label>
												</div>
											</div> -->
							<!-- <div class="form-group">
												<div ng-show="showMS">
													<div class="col-md-1 col-md-offset-4">
														<div class="checkbox">
															<label> <input type="checkbox"
																class="checkbox style-0"
																ng-model="EmployeeMasterData.ms" name="ms">
																<span></span>
															</label>
														</div>
													</div>
													<label class="col-md-2 control-label-left">Is MS<span
														style="color: red;"></span>
													</label>
												</div>
												<div ng-show="showPrincipal">
													<div class="col-md-1 col-md-offset-6">
														<div class="checkbox">
															<label> <input type="checkbox"
																class="checkbox style-0"
																ng-model="EmployeeMasterData.principal" name="principal">
																<span></span>
															</label>
														</div>
													</div>
													<label class="col-md-2 control-label-left">Is Principal<span
														style="color: red;"></span>
													</label>
												</div>
										   </div> -->
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6">

							<fieldset>
								<!--  style=" margin-top: -575px; "> -->
								<div class="form-group">
									<div class="col-md-3 col-md-offset-5 inputGroupContainer"
										ng-if="EmployeeMasterData.uploadPhoto !=''">
										<img src="{{EmployeeMasterData.uploadPhoto}}"
											class="thumb-image" data-ng-if="edit"
											style="max-height: 50px; width: 70px;">


									</div>
									<label class="col-md-5 control-label">Upload Photo</label>
									<div class="col-md-5 inputGroupContainer">
										<div class="input-group">
											<div ng-show="EmployeeMasterData.upic == '1' "
												id="image-holder"></div>
											<input type="file" class="form-control" name="uploadPhoto"
												ng-model="EmployeeMasterData.uploadPhoto" id="fileUpload"
												onchange="angular.element(this).scope().uploadImgLink(this)"
												accept=".xls,.png,.jpg" /> <br>
										</div>
										<br>
										<button class="btn btn" type="button"
											ng-click="uploadImg()">Upload</button>
									</div>
									<!-- <button class="btn btn-info" type="button"
										data-ng-click="next();"
										style="margin-left: 81%; margin-top: -28%; width: 21%;">
										{{tabs[1].title}} <i class="fa fa-arrow-right"></i>
									</button> -->
								</div>

								<div class="form-group">
									<label class="col-md-5 control-label"> Company
										Name <span style="color: red;">*</span>
									</label>
									<div class="col-md-5 inputGroupContainer">
										<select class="form-control journalVoucher-textBox"
											ng-model="EmployeeMasterData.companyCode" id="companyCode"
											name="companyCode" data-message-id="companyCode"
											validation="required" friendly-name="Hospital Name"
											ng-options="emp.companyCode as emp.companyName for emp in companyList"
											ng-change="getBranchList(EmployeeMasterData.companyCode)"
											ng-disabled="companyDrop">
											<option value="" selected="selected">Select</option>
										</select>
									</div>
								</div>
								<div class="form-group ">
									<label class="col-md-5 control-label">Country </label>
									<div class="col-md-5">
										<selectivity list="countryList"
											property="EmployeeMasterData.country"
											ng-model="EmployeeMasterData.country"
											friendly-name="Country Name" name="Country Name"
											form-name="frmProfile"></selectivity>

									</div>
								</div>
								<div class="form-group ">
									<label class="col-md-5 control-label">Branch <span
										style="color: red;">*</span></label>
									<div class="col-md-5">
										<selectivity list="branchList"
											property="EmployeeMasterData.branch"
											ng-model="EmployeeMasterData.branch"
											friendly-name="Branch Name" name="Branch Name"
											form-name="frmProfile" validation="required"></selectivity>

									</div>
								</div>
								<div class="form-group ">
									<label class="col-md-5 control-label">Department <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-5">
										<selectivity list="departmentList"
											property="EmployeeMasterData.departmentId"
											ng-model="EmployeeMasterData.departmentId"
											friendly-name="Department Name" name="Department Name"
											form-name="frmProfile" validation="required"></selectivity>

									</div>
								</div>
								<div class="form-group ">
									<label class="col-md-5 control-label">Designation <span
										style="color: red;">*</span></label>
									<div class="col-md-5">
										<selectivity list="designationList"
											property="EmployeeMasterData.designation"
											ng-model="EmployeeMasterData.designation"
											friendly-name="Designation Name" name="Designation Name"
											form-name="frmProfile" validation="required"></selectivity>

									</div>
								</div>

								<div class="form-group ">
									<label class="col-md-5 control-label">Grade </label>
									<div class="col-md-5">
										<selectivity list="gradeList"
											property="EmployeeMasterData.grade"
											ng-model="EmployeeMasterData.grade"
											friendly-name="Grade Name" name="Grade Name"
											form-name="frmProfile"></selectivity>

									</div>
								</div>
								<div class="form-group">
									<label class="col-md-5 control-label">Report To Branch
										<!-- <span style="color: red;">*</span> -->
									</label>
									<div class="col-md-5">
										<selectivity list="branchList"
											property="EmployeeMasterData.reportToBranch"
											ng-model="EmployeeMasterData.reportToBranch"
											friendly-name="Reporting Branch" name="Reporting Branch"
											form-name="frmProfile"></selectivity>

									</div>
								</div>
								<div class="form-group ">
									<label class="col-md-5 control-label">Report To
										Department <!-- <span style="color: red;">*</span> -->
									</label>
									<div class="col-md-5">
										<selectivity list="reportToDeptList"
											property="EmployeeMasterData.reportDeptId"
											ng-model="EmployeeMasterData.reportDeptId"
											friendly-name="Reporting Branch" name="Reporting DeptId"
											name="reportDeptId" ng-disabled="depart"
											form-name="frmProfile"></selectivity>

									</div>
								</div>
								<div class="form-group ">
									<label class="col-md-5 control-label">Reporting
										Authority <span style="color: red;">*</span>
									</label>
									<div class="col-md-5">
										<selectivity list="reportToManagerList"
											property="EmployeeMasterData.reportMangrId"
											ng-model="EmployeeMasterData.reportMangrId"
											friendly-name="Reporting Manager" name="Reporting Manager"
											name="reportMangrId" form-name="frmProfile"
											validation="required"></selectivity>

									</div>
								</div>

								<div class="form-group ">
									<label class="col-md-5 control-label">Alternative
										Reporting Authority </label>
									<div class="col-md-5">
										<selectivity list="reportToManagerList"
											property="EmployeeMasterData.altreportMangrId"
											ng-model="EmployeeMasterData.altreportMangrId"
											friendly-name="Reporting Manager" name="Reporting Manager"
											name="altreportMangrId" form-name="frmProfile"></selectivity>

									</div>
								</div>

								<div class="form-group ">
									<label class="col-md-5 control-label">Report To
										Designation<span style="color: red;"></span>
									</label>
									<div class="col-md-5">
										<selectivity list="designationList"
											property="EmployeeMasterData.reportDesigId"
											ng-model="EmployeeMasterData.reportDesigId"
											friendly-name="Reporting DesigId" name="Reporting DesigId"
											form-name="frmProfile"></selectivity>

									</div>
								</div>
								<!-- employee -->
								<div class="form-group ">
									<label class="col-md-5 control-label">Type Of
										Employment <span style="color: red;">*</span>
									</label>
									<div class="col-md-5">
										<selectivity list="empTypeList"
											property="EmployeeMasterData.typeOfEmp"
											ng-model="EmployeeMasterData.typeOfEmp"
											friendly-name="Type Of Employment" name="Type Of Employment"
											form-name="frmProfile" validation="required"></selectivity>
										<input type="hidden"
											ng-model="EmployeeMasterData.employmentDate"
											class="form-control journalVoucher-textBox" />
									</div>
								</div>
								<!-- <div class="form-group"  ng-if="secondLevel">
													<label class="col-md-5 control-label">Second Level<span
														style="color: red;"></span></label>
													<div class="col-md-5">
														<select class="form-control journalVoucher-textBox"
															ng-model="EmployeeMasterData.secondLevel" name="Second Level"
															ng-options="emp.id as emp.text for emp in secEmpList" disabled>
															<option value>--Select--</option>
														</select>

													</div>
												</div>
												 -->

								<div class="form-group">
									<label class="col-md-5 control-label">Relieving Date</label>
									<div class="col-md-5">
										<ng-bs3-datepicker
											data-ng-model="EmployeeMasterData.relieveDate"
											id="relieveDate" name="Relieving Date" form-name="toForm"
											friendly-name="Relieving Date" />
									</div>

								</div>

								<div class="form-group">
									<label class="col-md-5 control-label">Unit<span
										style="color: red;"></span></label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm" name="unit"
											ng-model="EmployeeMasterData.unit" maxlength="25">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-5 control-label">Profit Center<span
										style="color: red;"></span></label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm"
											name="profitCenter"
											ng-model="EmployeeMasterData.profitCenter" maxlength="25">
									</div>
								</div>


								<div class="form-group ">
									<label class="col-md-5 control-label">Appraisal Level 1
										Reviewer </label>
									<div class="col-md-5">
										<selectivity list="reportToManagerList"
											property="EmployeeMasterData.appraisalone"
											ng-model="EmployeeMasterData.appraisalone"
											friendly-name="appraisalone" name="appraisalone"
											name="altreportMangrId" form-name="frmProfile"></selectivity>

									</div>
								</div>

								<div class="form-group ">
									<label class="col-md-5 control-label">Appraisal Final
										Reviewer </label>
									<div class="col-md-5">
										<selectivity list="reportToManagerList"
											property="EmployeeMasterData.appraisalfinal"
											ng-model="EmployeeMasterData.appraisalfinal"
											friendly-name="Appraisal Fianl" name="Appraisal Fianl"
											name="appraisalfinal" form-name="frmProfile"></selectivity>

									</div>
								</div>


								<!-- 		<div class="form-group">
								<label class="col-md-5 control-label">Probation Period<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="probationperiod" ng-model="EmployeeMasterData.probationperiod"
										maxlength="25">
								</div>
							</div> -->
								<div class="form-group" ng-if="EmployeeMasterData.typeOfEmp ==2">
									<label class="col-md-5 control-label">Probation Period
									</label>
									<div class="col-md-5">
										<select class="form-control input-sm"
											ng-model="EmployeeMasterData.probationperiod"
											name="probationperiod" data-message-id="probationperiod"
											friendly-name="probationperiod">

											<option value="">--Select--</option>
											<option value="30 Days">30 Days</option>
											<option value="60 Days">60 Days</option>
											<option value="90 Days">90 Days</option>

										</select>
									</div>
								</div>

								<div class="form-group" ng-if="EmployeeMasterData.typeOfEmp ==3">
									<label class="col-md-5 control-label">Contract Period </label>
									<div class="col-md-5">
										<select class="form-control input-sm"
											ng-model="EmployeeMasterData.contractperiod"
											name="contractperiod" data-message-id="contractperiod"
											friendly-name="contractperiod">

											<option value="">--Select--</option>
											<option value="1 Year">1 Year</option>
											<option value="2 Year">2 Year</option>
											<option value="3 Year">3 Year</option>

										</select>
									</div>
								</div>

								<!-- 		<div class="form
							-group">
								<label class="col-md-5 control-label">Notice Period<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="noticeperiod" ng-model="EmployeeMasterData.noticeperiod"
										maxlength="25">
								</div>
							</div> -->
								<div class="form-group">
									<label class="col-md-5 control-label">Notice Period </label>
									<div class="col-md-5">
										<select class="form-control input-sm"
											ng-model="EmployeeMasterData.noticeperiod"
											name="noticeperiod" data-message-id="noticeperiod"
											friendly-name="noticeperiod">

											<option value="">--Select--</option>
											<option value="30 Days">30 Days</option>
											<option value="60 Days">60 Days</option>
											<option value="90 Days">90 Days</option>

										</select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-5 control-label">Work Calendar </label>
									<div class="col-md-5">
										<select class="form-control input-sm"
											ng-model="EmployeeMasterData.workcalender"
											name="workcalender" data-message-id="workcalender"
											friendly-name="workcalender">

											<option value="">--Select--</option>
											<option value="Codelia Dubai">Codelia Dubai</option>
											<option value="Cordelia Singapore">Cordelia
												Singapore</option>
											<option value="Cordelia India">Cordelia India</option>

										</select>
									</div>
								</div>
								<!-- <div class="form-group">
								<label class="col-md-5 control-label">Work Calendar<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="workcalender" ng-model="EmployeeMasterData.workcalender"
										maxlength="25">
								</div>
							</div> -->


								<!-- <div class="form-group">
								<label class="col-md-5 control-label">Work Calendar</label>

								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="EmployeeMasterData.workcalender"
										id="workcalender" name="workcalender" form-name="toForm" friendly-name="workcalender"
										 />
								</div>
							</div> -->
								<div class="form-group">
									<label class="col-md-5 control-label">Generic Function<span
										style="color: red;"></span></label>
									<div class="col-md-5">
										<textarea ng-model="EmployeeMasterData.generic" name="generic"
											class="form-control input-sm resize-none" rows="1">
	     											   </textarea>
									</div>
								</div>
								
								<div class="form-group">
								<label class="col-md-5 control-label">User Location <span
									style="color: red;"></span></label>
								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm"
										name="userLocation" ng-model="EmployeeMasterData.userLocation">
								</div>
							</div>
							</fieldset>
						</div>
					</div>
				</div>
				<!-- <div class="col-md-12" id="0">	
										<button class="btn btn-info" type="button"
										data-ng-click="next();" style=" margin-left: 92%; margin-top:-126%;">{{tabs[1].title}}
											<i class="fa fa-arrow-right"></i> 
										</button>
										</div> -->

				<!-- 	<div class="row">
					<div class="col-md-12" id="0">
						<button class="btn btn-info" type="button"
							style="margin-left: 88%; width: 11%; margin-top: -42px;"
							ng-click="tabLabel(0);">
							{{tabs[1].title}}<i class="fa fa-arrow-right"
								style="margin-left: 3px;"></i>
						</button>
					</div>
				</div> -->
				<div class="form-actions-tab">
					<div class="row" align="center">
						<div class="col-md-12">
							<button class="btn btn-success" id="saveprofile" type="submit"
								ng-click="saveProfile(frmProfile,EmployeeMasterData)">
								<i class="fa fa-save"></i> Approve
							</button>
							<button class="btn btn-success displaynone" id="updateprofile"
								type="submit"
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
			</tab> <!-- /Address tab --> <tab heading="{{tabs[1].title}}"
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
							<!-- 	<button class="btn btn-info" type="button"
								data-ng-click="previous();" style="margin-right: 1029px;">
								<i class="fa fa-arrow-left"></i> {{tabs[1].title}}
							</button>
							
							 -->

							<div class="form-group"
								ng-init="EmployeeMasterDataPersonal.married='M'">
								<label class="col-md-4 control-label">Marital Status</label>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" class=""
										name="married" value="M"
										ng-model="EmployeeMasterDataPersonal.married"> <i></i>
										Married
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" class=""
										name="married" value="U"
										ng-model="EmployeeMasterDataPersonal.married"> <i></i>
										UnMarried
									</label>
								</div>
								<!-- <div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" class=""
										name="gender" value="T" ng-model="EmployeeMasterData.gender">
										<i></i> Transgender
									</label>
								</div> -->
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
										friendly-name="Pan No" maxlength="50" numberschar-only>
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
							<!-- <button class="btn btn-info" type="button"
								data-ng-click="next();"
								style="margin-left: 85%; margin-top: -4px;">
								{{tabs[2].title}} <i class="fa fa-arrow-right"></i>
							</button> -->
							<div class="form-group">
								<label class="col-md-4 control-label">Confirmation Date
								</label>
								<div class="col-md-5">
									<ng-bs3-datepicker
										data-ng-model="EmployeeMasterDataPersonal.confirmDate"
										id="relieveDate" name="Confirmation Date"
										form-name="frmPersonalInfo" friendly-name="Confirmation Date"
										/>

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

							<!-- <div class="form-group">
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
							</div> -->

							<div class="form-group">
								<label class="col-md-4 control-label">Resignation Date</label>
								<div class="col-md-5">
									<ng-bs3-datepicker
										data-ng-model="EmployeeMasterDataPersonal.resignationDate"
										id="resignationDate" name="Relieving Date" form-name="toForm"
										friendly-name="Resignation Date" />
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
				<!-- <div class="row">
					<div class="col-md-12" id="1">

						<button class="btn btn-info" ng-click="tabLabelPrevious();"
							style="margin-left: 10px; margin-top: -25px;">
							<i class="fa fa-arrow-left" style="margin-right: 4px;"></i>{{tabs[1].title}}
						</button>
						<button class="btn btn-info" name="Address"
							style="margin-left: 92%; margin-top: -4.5%"
							ng-click="tabLabel(1)">
							{{tabs[2].title}}<i class="fa fa-arrow-right"></i>
							{{tabs[0].title}}
						</button>
					</div>zs
				</div> -->
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
							<!-- <button class="btn btn-info" type="button"
								data-ng-click="previous();" style="margin-right: 1029px;">
								<i class="fa fa-arrow-left"></i> {{tabs[1].title}}
							</button> -->

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
							<!-- <button class="btn btn-info" type="button"
								data-ng-click="next();" style="margin-left: 86%;">
								{{tabs[3].title}} <i class="fa fa-arrow-right"></i>
							</button> -->

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
				<!-- 	<div class="row">
					<div class="col-md-12" id="2">
						<button class="btn btn-info" ng-click="tabLabelPrevious();"
							style="margin-right: 1062px; margin-left: 15px;">
							<i class="fa fa-arrow-left"></i>{{tabs[1].title}}
						</button>
						<button class="btn btn-info" name="Address"
							style="margin-left: 92%; margin-top: -4.5%"
							ng-click="tabLabel(2)">
							{{tabs[3].title}}<i class="fa fa-arrow-right"></i>
							{{tabs[0].title}}
						</button>
					</div>
				</div> -->

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
						<!-- <button class="btn btn-info" type="button"
							data-ng-click="previous();" style="margin-right: 1029px;">
							<i class="fa fa-arrow-left"></i> {{tabs[2].title}}
						</button>

						<button class="btn btn-info" type="button" data-ng-click="next();"
							style="margin-left: 89%; margin-top: -50px;">
							{{tabs[4].title}} <i class="fa fa-arrow-right"></i>
						</button> -->
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

																		<th class="sorting" st-sort="dependentPassportNo"></th>
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
				<!-- <div class="form-actions-tab">
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
								{{tabs[0].title}}
							</button>
						</div>
					</div>
				</div> -->
			</form>
			</tab> <tab heading="{{tabs[4].title}}" id="educationTab" class="tab-head"
				active="tabs[4].active" ng-click="setInActive(4);"> <br>
			<form class="form-horizontal" name="Education" id="educationForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<!-- <button class="btn btn-info" type="button"
							data-ng-click="previous();" style="margin-right: 1769%;">
							<i class="fa fa-arrow-left"></i> {{tabs[3].title}}
						</button> -->
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

						<!-- <div class="col-sm-6 col-md-6 col-lg-6" style="margin-top: -30px;">
							<button class="btn btn-info" type="button"
								data-ng-click="next();"
								style="margin-left: 80%; margin-top: -1px;">
								{{tabs[5].title}} <i class="fa fa-arrow-right"></i>
							</button>
						</div> -->
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
				<!-- 	<div class="form-actions-tab">
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
								{{tabs[0].title}}
							</button>
						</div>
					</div>
				</div> -->
			</form>
			</tab> <%-- <tab heading="{{tabs[5].title}}" id="isPassport" class="tab-head"
				active="tabs[5].active" ng-click="setInActive(5);"> <br>
			<form class="form-horizontal" name="Experience" id="experienceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<!-- <div class="col-sm-6 col-md-6 col-lg-6">
							<button class="btn btn-info" type="button"
								data-ng-click="previous();" style="margin-right: 1029px;">
								<i class="fa fa-arrow-left"></i> {{tabs[4].title}}
							</button>
						</div>
						<button class="btn btn-info" type="button" data-ng-click="next();"
							style="margin-left: 92%; margin-top: -50px;">
							{{tabs[6].title}} <i class="fa fa-arrow-right"></i>
						</button> -->
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

											<div class="form-group">
												<label class="col-md-4 control-label"><b>Passport
														Release Request</b></label>
											</div>


											<div class="form-group">
												<label class="col-md-4 control-label">Request Type<span
													style="color: red;">*</span>
												</label>
												<div class="col-md-5">
													<select class="form-control input-sm"
														ng-model="EmployeeMasterDatapassport.passrequestType"
														name="passrequestType" data-message-id="passrequestType"
														friendly-name="passrequestType">

														<option value="">--Select--</option>
														<option value="Personal">Personal</option>
														<option value="Bussiness">Bussiness</option>

													</select>
												</div>
											</div>



											<div class="form-group">
												<label class="col-md-4 control-label">Required Date<span
													style="color: red;">*</span></label>

												<div class="col-md-5">
													<ng-bs3-datepicker
														data-ng-model="EmployeeMasterDatapassport.passrequestDate"
														id="passrequestDate" name="passrequestDate"
														form-name="toForm" friendly-name="passrequestDate" />
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">Comments</label>
												<div class="col-md-5">
													<textarea
														ng-model="EmployeeMasterDatapassport.passrequestcomments"
														name="Address in Permanent Address"
														class="form-control input-sm resize-none"
														data-message-id="passrequestcomments"
														friendly-name="passrequestcomments" rows="4">
	         										</textarea>
												</div>
											</div>










										</div>


										<div class="col-sm-6 col-md-6 col-lg-6">


											<!-- end widget -->
									</article>
									<!-- WIDGET END -->
								</div>
							</section>
						</div>
					</div>
				</div>
				<!-- 	<div class="form-actions-tab">
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
								{{tabs[0].title}}
							</button>
						</div>
					</div>
				</div> -->

				<div class="form-actions-tab">
					<div class="row" align="center">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit && !isPassport"
								type="submit"
								ng-click="savePassport(frmPassport,EmployeeMasterDatapassport)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" ng-if="isEdit || isPassport"
								type="submit"
								ng-click="updatePassport(frmPassport,EmployeeMasterDatapassport)">
								<i class="fa fa-save"></i> Update
							</button>

							<button class="btn btn-info" type="button"
								data-ng-click="resetAddress(EmployeeMasterDatapassport)">
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
			</tab> --%> <!-- <tab heading="{{tabs[6].title}}" id="ruleTab" class="tab-head"
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

							<div class="form-group"
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
											</div>
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

							<div class="form-group"
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
											</div>

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
								<div class="form-group">
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
												</div>
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
							{{tabs[0].title}}
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
			</tab>  --><!-- <tab heading="{{tabs[7].title}}" active="tabs[7].active"
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
											<label class="col-md-4 control-label">Branch <span
																style="color: red;">*</span></label>

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
												style="color: red;">*</span></label>
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
												style="color: red;">*</span></label>
											<div class="col-md-5">
												<ng-bs3-datepicker
													data-ng-model="EmployeeMasterDataPerDet.expiryDate"
													id="expiryDate" name="expiryDate" form-name="toForm"
													friendly-name="expiryDate" />

											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">Issued Place <span
												style="color: red;">*</span>
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
												style="color: red;">*</span></label>

											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													name="licenseNo"
													ng-model="EmployeeMasterDataPerDet.licenseNo">
											</div>
										</div>

										<div class="form-group ">
											<label class="col-md-4 control-label">License Type<span
												style="color: red;">*</span>
											</label>
											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													name="licenseType" maxlength="50"
													ng-model="EmployeeMasterDataPerDet.licenseType">
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Issued Date<span
												style="color: red;">*</span></label>
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
												style="color: red;">*</span></label>
											<div class="col-md-5">
												<ng-bs3-datepicker
													data-ng-model="EmployeeMasterDataPerDet.licenseexpiryDate"
													id="licenseexpiryDate" name="licenseexpiryDate"
													form-name="toForm" friendly-name="licenseexpiryDate" />

											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">Renewal Date<span
												style="color: red;">*</span>
											</label>
											<div class="col-md-5">
												<ng-bs3-datepicker
													data-ng-model="EmployeeMasterDataPerDet.renewalDate"
													id="renewalDate" name="renewalDate" form-name="toForm"
													friendly-name="renewalDate" />

											</div>
										</div>

										<div class="form-group">
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
														</div>

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
												Number <span style="color: red;">*</span>
											</label>
											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													name="visaRefNo"
													ng-model="EmployeeMasterDataPerDet.visaRefNo">
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">VISA Type <span
												style="color: red;">*</span></label>
											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													name="visaType" maxlength="50"
													ng-model="EmployeeMasterDataPerDet.visaType">
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">VISA Issued
												Date<span style="color: red;">*</span>
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
												Date<span style="color: red;">*</span>
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
												Place <span style="color: red;">*</span>
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
							{{tabs[0].title}}
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
			</tab> --> <%-- <tab heading="{{tabs[8].title}}" active="tabs[8].active"
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
			</tab>  --%><%-- <tab heading="{{tabs[9].title}}" id="meritsTab" class="tab-head"
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
			</tab>  --%><!-- <tab heading="{{tabs[10].title}}" id="physicalTab" class="tab-head"
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
									<div class="col-sm-12 col-md-12">
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

							</fieldset>
							<br>

							<fieldset class="field_set setBorder"
								style="margin-bottom: -14px;">
								<div class="form-group">
									<label class="col-md-2 control-label"><b>Parameters</b><span
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
								{{tabs[0].title}}
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
			</tab> --> <%-- <tab heading="{{tabs[11].title}}" id="emergencyTab" class="tab-head"
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
			</tab> --%> <%-- <tab heading="{{tabs[12].title}}" id="referenceTab" class="tab-head"
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
			</tab> --%> <tab heading="{{tabs[6].title}}" id="documentsTab"
				class="tab-head" active="tabs[6].active" ng-click="setInActive(6);">
			<form class="form-horizontal" name="Documents" id="documentsForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<!-- <div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<button class="btn btn-info" type="button"
							data-ng-click="previous();" style="margin-right: 1029px;">
							<i class="fa fa-arrow-left"></i> {{tabs[5].title}}
						</button>
						<button class="btn btn-info" type="button" data-ng-click="next();"
							style="margin-left: 91%; margin-top: -50px;">
							{{tabs[7].title}} <i class="fa fa-arrow-right"></i>
						</button>
					</div> -->
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

																	<th class="sorting width_20">Document type</th>
																	<th class="sorting width_10">Issue country</th>
																	<th class="sorting width_10">Document No</th>

																	<th class="width_2 text-center">Action</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataDoc in displayedCollectionDoc">

																	<td class="wrapping">{{EmployeeMasterDataDoc.docType}}</td>
																	<td class="wrapping">{{EmployeeMasterDataDoc.issuecountry}}</td>

																	<td class="wrapping">{{EmployeeMasterDataDoc.docName}}</td>
																	<td class=" td-actions text-center"><span>
																			<i class="fa  fa-pencil text-success text"
																			data-ng-click="editRowDoc(EmployeeMasterDataDoc)"></i>
																	</span> <span> <i
																			class="fa fa-trash-o text-danger-dker text"
																			data-ng-click="deleteRowDoc(EmployeeMasterDataDoc)"></i>
																	</span><button><i class="fa fa-download" > </i>
											<a href="{{EmployeeMasterDataDoc.uploadDoc}}" download>Download</a>
											</button></td>
																	
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
				<!-- <div class="form-actions-tab">
					<div class="row">
						<div class="col-md-12" id="9">
							<button class="btn btn-info" ng-click="tabLabelPrevious();"
								style="margin-right: 1769%;">
								<i class="fa fa-arrow-left"></i>{{tabs[5].title}}
							</button>
							<button class="btn btn-info"
								style="margin-left: 91%; margin-top: -1.5%"
								ng-click="tabLabel(13)">
								{{tabs[7].title}} <i class="fa fa-arrow-right"></i>
							</button>
						</div>
					</div>
				</div> -->
			</form>
			</tab> <tab heading="{{tabs[7].title}}" id="addressTab" class="tab-head"
				style="color:black;" active="tabs[7].active"
				ng-click="setInActive(7);"><!-- ng-click="tabLabel(2);" -->
			<form class="form-horizontal" name="frmPayBank" id="addressForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<!-- <button class="btn btn-info" type="button"
								data-ng-click="previous();" style="margin-right: 1029px;">
								<i class="fa fa-arrow-left"></i> {{tabs[6].title}}
							</button> -->

							<!-- <button class="btn btn-info" type="button" data-ng-click="next();"
							style="margin-left: 91%; margin-top: -50px;">
							{{tabs[8].title}} <i class="fa fa-arrow-right"></i>
						</button>
 -->
							<div class="form-group">
								<label class="col-md-4 control-label"><b>Payroll
										Bank Details</b></label>
							</div>


							<!-- 	<div class="form-group">
								<label class="col-md-4 control-label">Bank <span
									style="color: red;"></span></label>

								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm" name="Place"
										ng-model="EmployeeMasterDataPayRollBank.paybankname" maxlength="50">
								</div>
							</div> -->


							<div class="form-group">
								<label class="col-md-4 control-label">Bank</label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm"
										name="citizen" ng-model="EmployeeMasterData.citizen"
										maxlength="25"> -->
									<selectivity list="bankList"
										property="EmployeeMasterDataPayRollBank.paybankname"
										ng-model="EmployeeMasterDataPayRollBank.paybankname"
										friendly-name="paybankname" name="paybankname"
										form-name="frmProfile"></selectivity>

								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Bank Account Name
									<span style="color: red;"></span>
								</label>

								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm"
										name="paybankacctName"
										ng-model="EmployeeMasterDataPayRollBank.paybankacctName"
										maxlength="50">
								</div>
							</div>

							<div class="form-group ">
								<label class="col-md-4 control-label">IBAN<span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="permPin"
										ng-model="EmployeeMasterDataPayRollBank.iban"
										phonenumbers-only>
								</div>
							</div>










						</div>


						<div class="col-sm-6 col-md-6 col-lg-6">
							<!-- 	<button class="btn btn-info" type="button"
								data-ng-click="next();" style="margin-left: 86%;">
								{{tabs[8].title}} <i class="fa fa-arrow-right"></i>
							</button>  -->

							<div class="col-sm-12 col-md-12 col-lg-12">



								<div class="form-group">
									<label class="col-md-4 control-label">Bank Branch <span
										style="color: red;"></span></label>

									<div class="col-md-5 inputGroupContainer">
										<input type="text" class="form-control input-sm"
											name="paybankBranch"
											ng-model="EmployeeMasterDataPayRollBank.paybankBranch"
											maxlength="50">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">Account Number <span
										style="color: red;"></span></label>

									<div class="col-md-5 inputGroupContainer">
										<input type="text" class="form-control input-sm"
											name="payAcctNum"
											ng-model="EmployeeMasterDataPayRollBank.payAcctNum"
											maxlength="50">
									</div>
								</div>


								<div class="form-group">
									<label class="col-md-4 control-label">Comments</label>
									<div class="col-md-5">
										<textarea ng-model="EmployeeMasterDataPayRollBank.paycomments"
											name="Address in Permanent Address"
											class="form-control input-sm resize-none"
											data-message-id="paycomments" friendly-name="Address"
											rows="4">
	         										</textarea>
									</div>
								</div>


							</div>
						</div>
					</div>
				</div>
				<!-- 	<div class="row">
					<div class="col-md-12" id="2">
				 	<button class="btn btn-info" ng-click="tabLabelPrevious();"
							style="margin-right: 1062px; margin-left: 15px;">
							<i class="fa fa-arrow-left"></i>{{tabs[6].title}}
						</button>  
						 <button class="btn btn-info" name="Address"
							style="margin-left: 92%; margin-top: -4.5%"
							ng-click="tabLabel(2)">
							{{tabs[8].title}}<i class="fa fa-arrow-right"></i>
							
						</button>  
					</div>
				</div> -->

				<div class="form-actions-tab">
					<div class="row" align="center">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit && !isAddress"
								type="submit"
								ng-click="savePayBank(frmPayBank,EmployeeMasterDataPayRollBank)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" ng-if="isEdit || isAddress"
								type="submit"
								ng-click="updatePayBank(frmPayBank,EmployeeMasterDataPayRollBank)">
								<i class="fa fa-save"></i> Update
							</button>

							<button class="btn btn-info" type="button"
								data-ng-click="resetAddress(EmployeeMasterDataPayRollBank)">
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
			</tab> <!-- <tab heading="{{tabs[8].title}}" id="addressTab" class="tab-head"
				style="color:black;" active="tabs[8].active"
				ng-click="setInActive(8);">ng-click="tabLabel(2);"
			<form class="form-horizontal" name="frmPayBank" id="addressForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<button class="btn btn-info" type="button"
								data-ng-click="previous();" style="margin-right: 1029px;">
								<i class="fa fa-arrow-left"></i> {{tabs[7].title}}
							</button>

							<button class="btn btn-info" type="button" data-ng-click="next();"
							style="margin-left: 91%; margin-top: -50px;">
							{{tabs[9].title}} <i class="fa fa-arrow-right"></i>
						</button>

							<div class="form-group">
								<label class="col-md-4 control-label"><b>Air Ticket
										Claims</b></label>
							</div>





							<div class="form-group">
								<label class="col-md-4 control-label">Ticket Sector </label>
								<div class="col-md-5">
									<select class="form-control input-sm"
										ng-model="EmployeeMasterDataAircliams.ticksec" name="ticksec"
										data-message-id="ticksec" friendly-name="ticksec">

										<option value="">--Select--</option>
										<option value="DXB-BANGLADESH-DXB">DXB-BANGLADESH-DXB</option>
										<option value="DXB-BANGLADESH-DXB">DXB-BANGLADESH-DXB</option>
										<option value="DXB-BILLUND-DXB">DXB-BILLUND-DXB</option>
										<option value="DXB-ATH-DXB">DXB-ATH-DXB</option>
										<option value="DXB-AHMADABAD-DXB">DXB-AHMADABAD-DXB</option>
										<option value="DXB-BLR-DXB">DXB-BLR-DXB</option>
										<option value="DXB-BOM-DXB">DXB-BOM-DXB</option>
										<option value="DXB-CHENNAI-DXB">DXB-CHENNAI-DXB</option>
										<option value="DXB-CNN-DXB">DXB-CNN-DXB</option>
										<option value="DXB-CHANDIGARH-DXB">DXB-CHANDIGARH-DXB</option>

										<option value="DXB-COIMBATORE-DXB">DXB-COIMBATORE-DXB</option>
										<option value="DXB-COK-DXB">DXB-COK-DXB</option>
										<option value="DXB-DEL-DXB">DXB-DEL-DXB</option>
										<option value="DXB-GOA-DXB">DXB-GOA-DXB</option>
										<option value="DXB-HYD-DXB">DXB-HYD-DXB</option>
										<option value="DXB-IXM-DXB">DXB-IXM-DXB</option>
										<option value="DXB-KOLKOTA-DXB">DXB-KOLKOTA-DXB</option>
										<option value="DXB-LUCKNOW-DXB">DXB-LUCKNOW-DXB</option>
										<option value="DXB-MAA-DXB">DXB-MAA-DXB</option>
										<option value="DXB-MAA-DXB">DXB-MAA-DXB</option>

										<option value="DXB-MANGLORE-DXB">DXB-MANGLORE-DXB</option>
										<option value="DXB-PNQ-DXB">DXB-PNQ-DXB</option>
										<option value="DXB-TRICHY-DXB">DXB-TRICHY-DXB</option>
										<option value="DXB-VISAKHAPATNAM-DXB">DXB-VISAKHAPATNAM-DXB</option>
										<option value="DXB-TEHRAN-DXB">DXB-TEHRAN-DXB</option>
										<option value="DXB-BEIRUT-DXB">DXB-BEIRUT-DXB</option>

										<option value="DXB-MALAYSIA-DXB">DXB-MALAYSIA-DXB</option>
										<option value="DXB-BELGIUM-DXB">DXB-BELGIUM-DXB</option>

										<option value="DXB-CAIRO-DXB">DXB-CAIRO-DXB</option>
										<option value="DXB-FRN-DXB">DXB-FRN-DXB</option>
										<option value="DXB-SWEDEN-DXB">DXB-SWEDEN-DXB</option>
										<option value="DXB-TAI-DXB">DXB-TAI-DXB</option>

									</select>
								</div>
							</div>




							<div class="form-group">
								<label class="col-md-4 control-label">Air Ticket Class </label>
								<div class="col-md-5">
									<select class="form-control input-sm"
										ng-model="EmployeeMasterDataAircliams.airclass"
										name="airclass" data-message-id="airclass"
										friendly-name="airclass">

										<option value="">--Select--</option>
										<option value="Economy">Economy</option>
										<option value="Business">Business</option>

									</select>
								</div>
							</div>



							<br>


							<div class="form-group">
								<label class="col-md-4 control-label">Self Tickets</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="airselftick"
										ng-model="EmployeeMasterDataAircliams.airselftick"
										style="text-align: right" data-message-id="airselftick">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Self Tickets
									AMount</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="airselftickAmt"
										ng-model="EmployeeMasterDataAircliams.airselftickAmt"
										style="text-align: right" data-message-id="airselftickAmt">
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label">Adult Tickets</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="airadulttick"
										ng-model="EmployeeMasterDataAircliams.airadulttick"
										style="text-align: right" data-message-id="airadulttick">
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label">Adult Tickets
									Amount</label>
								
								<div class="col-md-5">
										<input type="text" class="form-control input-sm"
											name="airadulttickAmt"
											ng-model="EmployeeMasterDataAircliams.airadulttickAmt"
											style="text-align: right" data-message-id="airadulttickAmt">
									</div>
							</div>










						</div>


						<div class="col-sm-6 col-md-6 col-lg-6">
							<button class="btn btn-info" type="button"
								data-ng-click="next();" style="margin-left: 86%;">
								{{tabs[9].title}} <i class="fa fa-arrow-right"></i>
							</button>

							<div class="col-sm-12 col-md-12 col-lg-12">


								<br> <br>

								<div class="form-group">
									<label class="col-md-4 control-label">Due Date<span
										style="color: red;">*</span></label>
									<div class="col-md-5">
										<ng-bs3-datepicker
											data-ng-model="EmployeeMasterDataAircliams.airdueDate"
											id="airdueDate" name="airdueDate" form-name="toForm"
											friendly-name="airdueDate" validation="required" />
									</div>

								</div>





								<div class="form-group">
									<label class="col-md-4 control-label">Child Tickets</label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm"
											name="airChildtick"
											ng-model="EmployeeMasterDataAircliams.airChildtick"
											style="text-align: right" data-message-id="airChildtick">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">Child Tickets
										Amount</label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm"
											name="airChildtickAmt"
											ng-model="EmployeeMasterDataAircliams.airChildtickAmt"
											style="text-align: right" data-message-id="airChildtickAmt">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">Infant Tickets</label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm"
											name="airinfanttick"
											ng-model="EmployeeMasterDataAircliams.airinfanttick"
											style="text-align: right" data-message-id="airinfanttick">
									</div>
								</div>


								<div class="form-group">
									<label class="col-md-4 control-label">Infant Tickets
										Amount</label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm"
											name="airinfanttickAmt"
											ng-model="EmployeeMasterDataAircliams.airinfanttickAmt"
											style="text-align: right" data-message-id="airinfanttickAmt">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">Comments</label>
									<div class="col-md-5">
										<textarea
											ng-model="EmployeeMasterDataAircliams.airclaimcomments"
											name="Address in Permanent Address"
											class="form-control input-sm resize-none"
											data-message-id="airclaimcomments" friendly-name="Address"
											rows="4">
	         										</textarea>
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
							<i class="fa fa-arrow-left"></i>{{tabs[7].title}}
						</button>
						<button class="btn btn-info" name="Address"
							style="margin-left: 92%; margin-top: -4.5%"
							ng-click="tabLabel(9">
							{{tabs[9].title}}<i class="fa fa-arrow-right"></i>
							{{tabs[0].title}}
						</button>
					</div>
				</div>

				<div class="form-actions-tab">
					<div class="row" align="center">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit && !isAirClaim"
								type="submit"
								ng-click="saveAirClaim(frmAirClaim,EmployeeMasterDataAircliams)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" ng-if="isEdit || isAirClaim"
								type="submit"
								ng-click="updateAirClaim(frmAirClaim,EmployeeMasterDataAircliams)">
								<i class="fa fa-save"></i> Update
							</button>

							<button class="btn btn-info" type="button"
								data-ng-click="resetAddress(EmployeeMasterDataAircliams)">
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
			</tab>  --><tab heading="{{tabs[9].title}}" id="addressTab" class="tab-head"
				style="color:black;" active="tabs[9].active"
				ng-click="setInActive(9);"><!-- ng-click="tabLabel(2);" -->
			<form class="form-horizontal" name="frmPayBank" id="addressForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<!-- <button class="btn btn-info" type="button"
								data-ng-click="previous();" style="margin-right: 1029px;">
								<i class="fa fa-arrow-left"></i> {{tabs[8].title}}
							</button> -->

							<!-- <button class="btn btn-info" type="button" data-ng-click="next();"
							style="margin-left: 91%; margin-top: -50px;">
							{{tabs[10].title}} <i class="fa fa-arrow-right"></i>
						</button> -->

							<div class="form-group">
								<label class="col-md-4 control-label"><b>End Of
										Service Settlement</b></label>
							</div>




							<div class="form-group">
								<label class="col-md-4 control-label">Settlement Type</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="settleType"
										ng-model="EmployeeMasterDataSettle.settleType"
										style="text-align: right" data-message-id="settleType">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Last Working Date<span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<ng-bs3-datepicker
										data-ng-model="EmployeeMasterDataSettle.settlelastDate"
										id="settlelastDate" name="settlelastDate" form-name="toForm"
										friendly-name="settlelastDate" />
								</div>

							</div>




						</div>


						<div class="col-sm-6 col-md-6 col-lg-6">
							<!-- 	<button class="btn btn-info" type="button"
								data-ng-click="next();" style="margin-left: 86%;">
								{{tabs[10].title}} <i class="fa fa-arrow-right"></i>
							</button> -->




							<br>
							<div class="col-sm-12 col-md-12 col-lg-12">






								<br>

								<div class="form-group">
									<label class="col-md-4 control-label">Currency</label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm"
											name="settleCurrency"
											ng-model="EmployeeMasterDataSettle.settleCurrency"
											style="text-align: right" data-message-id="settleCurrency">
									</div>
								</div>





								<div class="form-group">
									<label class="col-md-4 control-label">Comments</label>
									<div class="col-md-5">
										<textarea ng-model="EmployeeMasterDataSettle.settlecomments"
											name="Address in Permanent Address"
											class="form-control input-sm resize-none"
											data-message-id="settlecomments" friendly-name="Address"
											rows="4">
	         										</textarea>
									</div>
								</div>


							</div>
						</div>
					</div>
				</div>
				<!-- <div class="row">
					<div class="col-md-12" id="2">
						<button class="btn btn-info" ng-click="tabLabelPrevious();"
							style="margin-right: 1062px; margin-left: 15px;">
							<i class="fa fa-arrow-left"></i>{{tabs[8].title}}
						</button>
						<button class="btn btn-info" name="Address"
							style="margin-left: 92%; margin-top: -4.5%"
							ng-click="tabLabel(9">
							{{tabs[10].title}}<i class="fa fa-arrow-right"></i>
							
						</button>
					</div>
				</div> -->

				<div class="form-actions-tab">
					<div class="row" align="center">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit && !isSettle"
								type="submit"
								ng-click="saveSettle(frmSettle,EmployeeMasterDataSettle)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" ng-if="isEdit || isSettle"
								type="submit"
								ng-click="updateSettle(frmSettle,EmployeeMasterDataSettle)">
								<i class="fa fa-save"></i> Update
							</button>

							<button class="btn btn-info" type="button"
								data-ng-click="resetAddress(EmployeeMasterDataSettle)">
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
			</tab> <tab heading="{{tabs[10].title}}" id="addressTab" class="tab-head"
				style="color:black;" active="tabs[10].active"
				ng-click="setInActive(10);"><!-- ng-click="tabLabel(2);" -->
			<form class="form-horizontal" name="frmPayBank" id="addressForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<!-- <button class="btn btn-info" type="button"
								data-ng-click="previous();" style="margin-right: 1029px;">
								<i class="fa fa-arrow-left"></i> {{tabs[9].title}}
							</button> -->

							<!-- <button class="btn btn-info" type="button" data-ng-click="next();"
							style="margin-left: 91%; margin-top: -50px;">
							{{tabs[10].title}} <i class="fa fa-arrow-right"></i>
						</button> -->

							<div class="form-group">
								<label class="col-md-4 control-label"><b>Assets</b></label>
							</div>



							<div class="form-group">
								<label class="col-md-4 control-label">Asset Name</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="assetName" ng-model="EmployeeMasterDataAssets.assetName"
										style="text-align: right" data-message-id="assetName">
								</div>
							</div>



							<div class="form-group">
								<label class="col-md-4 control-label">Description</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="assetdesc" ng-model="EmployeeMasterDataAssets.assetdesc"
										style="text-align: right" data-message-id="assetdesc">
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label">Asset Type </label>
								<div class="col-md-5">
									<select class="form-control input-sm"
										ng-model="EmployeeMasterDataAssets.assetType" name="assetType"
										data-message-id="assetType" friendly-name="ticksec">

										<option value="">--Select--</option>
										<option value="Car">Car</option>
										<option value="Headset">Headset</option>
										<option value="Immigration Stamp">Immigration Stamp</option>
										<option value="Jabel Ali Dacility Pass">Jabel Ali
											Dacility Pass</option>
										<option value="Laptop">Laptop</option>
										<option value="Medical Insurance Card">Medical
											Insurance Card</option>
										<option value="Memory Card">Memory Card</option>
										<option value="Mobile Phone">Mobile Phone</option>
										<option value="Motor Cycle">Motor Cycle</option>
										<option value="Office Access Card/EMployee ID">Office
											Access Card/EMployee ID</option>

										<option value="Packing Card">Packing Card</option>
										<option value="Permanent Port Pass">Permanent Port
											Pass</option>
										<option value="Personal Accident Insurence">Personal
											Accident Insurence</option>
										<option value="Remote Control">Remote Control</option>
										<option value="Salik Card">Salik Card</option>
										<option value="Select Card">Select Card</option>
										<option value="Slim Card">Slim Card</option>
										<option value="USB Dongle">USB Dongle</option>
										<option value="VIP Kit Installation">VIP Kit
											Installation</option>


									</select>
								</div>
							</div>









						</div>


						<div class="col-sm-6 col-md-6 col-lg-6">
							<!-- 	<button class="btn btn-info" type="button"
								data-ng-click="next();" style="margin-left: 86%;">
								{{tabs[11].title}} <i class="fa fa-arrow-right"></i>
							</button> -->

							<div class="col-sm-12 col-md-12 col-lg-12">



								<br> <br>

								<div class="form-group">
									<label class="col-md-4 control-label">Status </label>
									<div class="col-md-5">
										<select class="form-control input-sm"
											ng-model="EmployeeMasterDataAssets.assetstatus"
											name="assetstatus" data-message-id="assetstatus"
											friendly-name="assetstatus">

											<option value="">--Select--</option>
											<option value="Damaged/Defect">Damaged/Defect</option>
											<option value="Expired">Expired</option>
											<option value="Issued">Issued</option>
											<option value="Lost">Lost</option>
											<option value="Out Of Diagonestics">Out Of
												Diagonestics</option>
											<option value="Out Of Repair">Out Of Repair</option>
											<option value="Purchased">Purchased</option>
											<option value="Ready To Deploy">Ready To Deploy</option>
											<option value="Scrapped">Scrapped</option>
											<option value="Spare">Spare</option>

										</select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">Location</label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm"
											name="assetlocation"
											ng-model="EmployeeMasterDataAssets.assetlocation"
											style="text-align: right" data-message-id="assetlocation">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">Quantity</label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm"
											name="assetquantity"
											ng-model="EmployeeMasterDataAssets.assetquantity"
											style="text-align: right" data-message-id="assetquantity">
									</div>
								</div>




							</div>
						</div>
					</div>
				</div>
				<!-- <div class="row">
					<div class="col-md-12" id="2">
						<button class="btn btn-info" ng-click="tabLabelPrevious();"
							style="margin-right: 1062px; margin-left: 15px;">
							<i class="fa fa-arrow-left"></i>{{tabs[9].title}}
						</button>
						<button class="btn btn-info" name="Address"
							style="margin-left: 92%; margin-top: -4.5%"
							ng-click="tabLabel(9">
							{{tabs[11].title}}<i class="fa fa-arrow-right"></i>
							{{tabs[0].title}}
						</button>
					</div>
				</div> -->

				<div class="form-actions-tab">
					<div class="row" align="center">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit && !isfrmAssets"
								type="submit"
								ng-click="savefrmAssets(frmAssets,EmployeeMasterDataAssets)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" ng-if="isEdit || isfrmAssets"
								type="submit"
								ng-click="updatefrmAssets(frmAssets,EmployeeMasterDataAssets)">
								<i class="fa fa-save"></i> Update
							</button>

							<button class="btn btn-info" type="button"
								data-ng-click="resetAddress(EmployeeMasterDataAssets)">
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
			</tab> <tab heading="{{tabs[11].title}}" id="historyTab" class="tab-head"
				active="tabs[11].active" ng-click="setInActive(11);">
			<form class="form-horizontal" name="history" id="historyForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<!-- 	<button class="btn btn-info" type="button"
							data-ng-click="previous();" style="margin-right: 1029px;">
							<i class="fa fa-arrow-left"></i> {{tabs[10].title}}
						</button> -->


						<!-- 	<button class="btn btn-info" ng-if='driverTab' type="button"
							data-ng-click="next();"
							style="margin-left: 88%; margin-top: -50px;">
							{{tabs[15].title}} <i class="fa fa-arrow-right"></i>
						</button>
						<button class="btn btn-info" type="button" data-ng-click="next1();"
							style="margin-left: 85%; margin-top: -50px;" ng-if='salesTab'>
							{{tabs[16].title}} <i class="fa fa-arrow-right"></i>
						</button> -->
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
				<!-- <div class="form-actions-tab">
					<div class="row">
						<div class="col-md-12" id="9">
							<button class="btn btn-info" ng-click="tabLabelPrevious();"
								style="margin-right: 1769%;">
								<i class="fa fa-arrow-left"></i>{{tabs[10].title}}
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
				</div> -->
			</form>
			</tab> <tab heading="{{tabs[12].title}}" id="isformsreview"
				class="tab-head" active="tabs[12].active"
				ng-click="setInActive(12);"> <br>
			<form class="form-horizontal" name="Experience" id="experienceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<!-- <div class="col-sm-6 col-md-6 col-lg-6">
							<button class="btn btn-info" type="button"
								data-ng-click="previous();" style="margin-right: 1029px;">
								<i class="fa fa-arrow-left"></i> {{tabs[4].title}}
							</button>
						</div>
						<button class="btn btn-info" type="button" data-ng-click="next();"
							style="margin-left: 92%; margin-top: -50px;">
							{{tabs[6].title}} <i class="fa fa-arrow-right"></i>
						</button> -->
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

											<div class="form-group">
												<label class="col-md-4 control-label"><b>Forms &
														Reviews</b></label>
											</div>


											<div class="form-group">
												<label class="col-md-4 control-label">Form Type<span
													style="color: red;">*</span>
												</label>
												<div class="col-md-5">
													<select class="form-control input-sm"
														ng-model="EmployeeMasterDataforms.formreviewType"
														name="formreviewType" data-message-id="formreviewType"
														friendly-name="formreviewType">

														<option value="">--Select--</option>
														<option value="probation Review">probation Review</option>


													</select>
												</div>
											</div>



											<div class="form-group">
												<label class="col-md-4 control-label">Form Templete</label>
												<div class="col-md-5">
													<input type="text" class="form-control input-sm"
														name="formreviewtemplete"
														ng-model="EmployeeMasterDataforms.formreviewtemplete"
														style="text-align: right"
														data-message-id="formreviewtemplete">
												</div>
											</div>


											<div class="form-group">
												<label class="col-md-4 control-label">Review Date<span
													style="color: red;">*</span></label>

												<div class="col-md-5">
													<ng-bs3-datepicker
														data-ng-model="EmployeeMasterDataforms.formreviewDate"
														id="formreviewDate" name="formreviewDate"
														form-name="toForm" friendly-name="formreviewDate" />
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">Comments</label>
												<div class="col-md-5">
													<textarea
														ng-model="EmployeeMasterDataforms.formsreviewcomments"
														name="Address in Permanent Address"
														class="form-control input-sm resize-none"
														data-message-id="formsreviewcomments"
														friendly-name="formsreviewcomments" rows="4">
	         										</textarea>
												</div>
											</div>










										</div>


										<div class="col-sm-6 col-md-6 col-lg-6">


											<!-- end widget -->
									</article>
									<!-- WIDGET END -->
								</div>
							</section>
						</div>
					</div>
				</div>
				<!-- 	<div class="form-actions-tab">
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
								{{tabs[0].title}}
							</button>
						</div>
					</div>
				</div> -->

				<div class="form-actions-tab">
					<div class="row" align="center">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit && !isformsreview"
								type="submit"
								ng-click="saveFormReview(frmReview,EmployeeMasterDataforms)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" ng-if="isEdit || isformsreview"
								type="submit"
								ng-click="updateFormReview(frmReview,EmployeeMasterDataforms)">
								<i class="fa fa-save"></i> Update
							</button>

							<button class="btn btn-info" type="button"
								data-ng-click="resetAddress(EmployeeMasterDataforms)">
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
			</tab> <%-- <tab heading="{{tabs[15].title}}" id="driverTab" class="tab-head"
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

			</tab>  --%><!-- WIDGET END --> <tab heading="{{tabs[16].title}}"
				id="salesTab" class="tab-head" active="tabs[16].active"
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











		</tabset>

		<script type="text/ng-template" id="employeeConfirm">
<div
	class="modal-header modal-header-new padding-left-10 padding-top-0 padding-bottom-0 padding-right-0  line-height-30"
	style="font-weight: bold;">Your Employee Id and Password</div>
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