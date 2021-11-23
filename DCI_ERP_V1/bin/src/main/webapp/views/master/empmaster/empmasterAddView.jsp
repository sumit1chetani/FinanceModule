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

  .nav-tabs > li > a {
color::#fff !important;
} 


.tabs-below > .nav-tabs,
.tabs-right > .nav-tabs,
.tabs-left > .nav-tabs {
    border-bottom: 0;
}

.tab-content > .tab-pane,
.pill-content > .pill-pane {
    display: none;
}

.tab-content > .active,
.pill-content > .active {
    display: block;
}

.tabs-below > .nav-tabs {
    border-top: 1px solid #ddd;
}

.tabs-below > .nav-tabs > li {
    margin-top: -1px;
    margin-bottom: 0;
}

.tabs-below > .nav-tabs > li > a {
    -webkit-border-radius: 0 0 4px 4px;
    -moz-border-radius: 0 0 4px 4px;
    border-radius: 0 0 4px 4px;
}

.tabs-below > .nav-tabs > li > a:hover,
.tabs-below > .nav-tabs > li > a:focus {
    border-top-color: #ddd;
    border-bottom-color: transparent;
}

.tabs-below > .nav-tabs > .active > a,
.tabs-below > .nav-tabs > .active > a:hover,
.tabs-below > .nav-tabs > .active > a:focus {
    border-color: transparent #ddd #ddd #ddd;
}

.tabs-left > .nav-tabs > li,
.tabs-right > .nav-tabs > li {
    float: none;
}

.tabs-left > .nav-tabs > li > a,
.tabs-right > .nav-tabs > li > a {
    min-width: 74px;
    margin-right: 0;
    margin-bottom: 3px;
}

.tabs-left > .nav-tabs {
    float: right;
    margin-right: 19px;
    border-right: 1px solid #ddd;
    height:400px;
    overflow-y: scroll;
     overflow-x: hidden;
}

.tabs-left > .nav-tabs > li > a {
    margin-right: -1px;
    -webkit-border-radius: 4px 0 0 4px;
    -moz-border-radius: 4px 0 0 4px;
    border-radius: 4px 0 0 4px;
}

.tabs-left > .nav-tabs > li > a:hover,
.tabs-left > .nav-tabs > li > a:focus {
    border-color: #eeeeee #dddddd #eeeeee #eeeeee;
}

.tabs-left > .nav-tabs .active > a,
.tabs-left > .nav-tabs .active > a:hover,
.tabs-left > .nav-tabs .active > a:focus {
    border-color: #ddd transparent #ddd #ddd;
    *border-right-color: #ffffff;
}

.tabs-right > .nav-tabs {
    float: right;
    margin-left: 19px;
    border-left: 1px solid #ddd;
}

.tabs-right > .nav-tabs > li > a {
    margin-left: -1px;
    -webkit-border-radius: 0 4px 4px 0;
    -moz-border-radius: 0 4px 4px 0;
    border-radius: 0 4px 4px 0;
}

.tabs-right > .nav-tabs > li > a:hover,
.tabs-right > .nav-tabs > li > a:focus {
    border-color: #eeeeee #eeeeee #eeeeee #dddddd;
}

.tabs-right > .nav-tabs .active > a,
.tabs-right > .nav-tabs .active > a:hover,
.tabs-right > .nav-tabs .active > a:focus {
    border-color: #ddd #ddd #ddd transparent;
    *border-left-color: #ffffff;
}

img.thumb-image
{
width:200px !important; 
max-height:200px !important;
}

</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
		 <legend>EMPLOYEE NAME  :  {{EmployeeMasterData.firstName1}}. {{EmployeeMasterData.firstName}} {{EmployeeMasterData.lastName}}</legend>
		<div class ="col-md-2"> 
				
									<div class="col-md-12 ">
									
											<div ng-show = "EmployeeMasterData.upic == '1' "id="image-holder">
											
											
											</div>
						
										
						
									</div>
                          	
						<div class="form-group">
					
							<label><b style="color:#0072C6 !important;">EMPLOYEE NAME : {{EmployeeMasterData.firstName1}} . {{EmployeeMasterData.firstName}} {{EmployeeMasterData.lastName}}</b></label>
						</div>	
						 <div class="form-group" ng-if="EmployeeMasterData.isEdit">
						
						<label><b >EMPLOYEE ID : {{employeeId}}</b></label>
						</div>							
						<div class="form-group">
																			<label><b>DESIGNATION : {{EmployeeMasterData.designationName}}</b></label>
						
							<label><b>DEPARTMENT : {{EmployeeMasterData.departmentCode}}</b></label>
						</div>			
									
									
				</div>
		
			<tabset class="tabs-left"> <tab heading="{{tabs[0].title}}" class="tab-head"
				active="tabs[0].active" ng-click="setInActive(0);">
			<form class="form-horizontal" name="frmProfile" id="profileForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
				
				
					<div class="">
						<div class="col-sm-6 col-md-6 col-lg-6" style="margin-left: 150px;">
					
							
						
		
 	                    <div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left"><b>FULL NAME</b>
							</label>
						
							<label class="col-md-4 control-label" style="text-align: left;"><b> {{EmployeeMasterData.firstName1}}. {{EmployeeMasterData.firstName}} {{EmployeeMasterData.lastName}}</b></label>
						</div>
						
						
                              <div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Father's Name
									
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.fatherName}}</label>
						    </div>
							
							<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Mother's Name
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.momcyName}}</label>
						    </div>
							
							<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Birth Date
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.dob}}</label>
						     </div>
						<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Passport Birth Date
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.dob}}</label>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Gender
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.gender}}</label>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Marital Status
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.marriedName}}</label>
						</div>
						    
						    <div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Citizenship
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.citizen}}</label>
						    </div>
						    
						    <div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Other Citizenship
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.othercitizen}}</label>
						    </div>
						    
						    	<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Religion
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.religion}}</label>
						    </div>
						    
						    
							<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Blood Group
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.bloodgroupName}}</label>
						    </div>

						
							<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Social Security No
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.socialNo}}</label>
						    </div>

							<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Income Tax No
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.incometaxNo}}</label>
						    </div>

						
								
		
							
							
							
							


						
						    
						    
						    
						     <legend > <b style="color:#0072C6 !important;">CONTRACTUAL INFORMATION:</b></legend>
						    
						    
						    <div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left"><b>Company
										Name</b>
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;"><b>{{EmployeeMasterData.companyName}}</b></label>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Department
										
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.departmentCode}}</label>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Unit
										
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.unit}}</label>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Profit Center
										
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.profitCenter}}</label>
						</div>
						
									
					
						
						
						<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Hire Date
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.doj}}</label>
						</div>
								
								<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Group Hire Date
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.doj}}</label>
						</div>
						
						
						
						<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Employee Type
										
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.empTypeName}}</label>
						</div>
															
								<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Grade
										
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.gradeName}}</label>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Band
										
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.gradeName}}</label>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Position
										
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.designationName}}</label>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Generic Function
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.generic}}</label>
						    </div>
						
							<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Work Location
										
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.branchName}}</label>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Work Country
										
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.country}}</label>
						</div>
						
						<!-- <div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Reporting Head -Solid
										
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.reportdot}}</label>
						</div> -->
						
						<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Reporting Head
										
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.reportdot}}</label>
						</div>
						
							<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Appraisal Level 1 Reviewer
										
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.appraisaloneName}}</label>
						</div>
								
								
								<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Appraisal Final Reviewer
										
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.appraisalfinalName}}</label>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Salary Currency
										
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.reportDeptId}}</label>
						</div>
								

							
									<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Payment Mode
										
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">Bank</label>
						</div>
						<br>
							
							<span><b>Air Ticket Eligibility     :      AS PER EMPLOYMENT CONTRACT</b></span> 
							
							<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Home Destination Port
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.homedesti}}</label>
						    </div>
						    
						    
						    <div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Air Ticket Class
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.airticketclass}}</label>
						    </div>
						    
						     <div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Self Tickets
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.airselftick}}</label>
						    </div>
						    
						       <div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Spouse Tickets
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.airadulttick}}</label>
						    </div>
						    
						    
						       <div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Contractual Tickets
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.airselftick}}</label>
						    </div>
						    
						    <div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Probation Period
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.probationperiod}}</label>
						    </div>
						    
						    
						    <div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Notice Period
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.noticeperiod}}</label>
						    </div>
						    
						    
						    <div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Work Calendar
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.workcalender}}</label>
						    </div>
						    
						    
						    				    
						    						    						    
						    <div class="form-group">
							<label class="col-md-4 co
							ntrol-label"  style="text-align: left">Probation Status
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.empTypeName}}</label>
						    </div>
						    
						    
						    <div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Confirmation Date
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.confirmationDate}}</label>
						    </div>
						    
						        <div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Status
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">Y</label>
						    </div>
							
				 <legend > <b style="color:#0072C6 !important;">PRIMARY ADDRESS INFORMATION</b></legend>
							<h3><b>Contact Information</b></h3> 
							<br>
							<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Address Line.1
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.permAddress}}</label>
						    </div>
						    
							<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Address Line.2
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.presentAddress}}</label>
						    </div>
						    
						    <div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Mobile No
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.mobileNo}}</label>
						</div>
						    
						     <div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Pin Code
									
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.permPin}}</label>
						</div>
							<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Contact No(In Case
									of Emergency)
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.emgContactNo}}</label>
						    </div>
							
							<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Contact Name(In
									Case of Emergency)
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.emgContactName}}</label>
						    </div>
								
						<div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Email ID
								
							</label>
						
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.emailId}}</label>
						</div>
						
						
						
								
							<!-- <div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Relieving Date	
							</label>
							<label class="col-md-2 control-label" style="text-align: left;">{{EmployeeMasterData.relieveDate}}</label>
						    </div> -->
							
						</div>
						
					</div>
				</div>
			<br>
			<div class="form-actions-tab">
					<div class="row" align="center">
						<div class="col-md-12">
						
							<button class="btn btn-danger" type="button"
								data-ng-click="cancel();">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
			</tab> 
			
			
			<!-- /Address tab --> <tab heading="{{tabs[1].title}}"
				id="personalInfoTab" active="tabs[1].active" class="tab-head"
				ng-click="setInActive(1);" style="color: black;"><!-- ng-click="tabLabel(1);" -->
			<form class="form-horizontal" name="frmPersonalInfo"
				id="personalInfoForm" novalidate method="post"
				ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-48 col-md-28 col-lg-50">
						<div class="col-sm-6 col-md-6 col-lg-6" style="margin-left: 150px;">


						
							
						<!-- 	<div class="form-group">
								<label class="col-md-4 control-label">Marital Status
								</label>
								<div class="radio radio-inline">

									<label class="i-checks"> <input type="radio" class=""
										name="marriedStatus" ng-value="true" disabled
										ng-model="EmployeeMasterDataPersonal.marritalStatus">
										<i></i> Married
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" class=""
										name="marriedStatus" ng-value="false" disabled
										ng-model="EmployeeMasterDataPersonal.marritalStatus">
										<i></i> UnMarried
									</label>
								</div>
							</div> -->
							
							<div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Marital Status
									
							</label>
						
							<label class="col-md-4 control-label" style="text-align: left" >{{EmployeeMasterData.marriedName}}</label>
						</div>

							<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Father/Guardian
									Name
							</label>
							<label class="col-md-4 control-label"  style="text-align: left">{{EmployeeMasterDataPersonal.guardianName}}</label>
						    </div>
							
							<div class="form-group">
							<label class="col-md-4 control-label"  style="text-align: left">Husband/Wife Name
							</label>
							<label class="col-md-4 control-label"  style="text-align: left">{{EmployeeMasterDataPersonal.husbWifeName}}</label>
						    </div>

							<div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Blood Group
							</label>
							<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterData.bloodgroupName}}</label>
						    </div>

							<div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Religion
							</label>
							<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterDataPersonal.religion}}</label>
						    </div>

                              <div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Caste
							</label>
							<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterDataPersonal.caste}}</label>
						    </div>
							
							   <div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Mother Tongue
							</label>
							<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterDataPersonal.motherTongue}}</label>
						    </div>

							   <div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Languages Known
							</label>
							<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterDataPersonal.languages}}</label>
						    </div>

							<div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Nationality
							</label>
							<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterDataPersonal.nationality}}</label>
						    </div>

							<div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">AADHAR No
							</label>
							<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterDataPersonal.aadharno}}</label>
						    </div>

							<div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">PAN No
							</label>
							<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterDataPersonal.panNo}}</label>
						    </div>

							<div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Hobbies
							</label>
							<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterDataPersonal.hobbies}}</label>
						    </div>
							
							<div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Remarks
							</label>
							<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterDataPersonal.remarks}}</label>
						    </div>
						    
						    
                            <div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Confirmation Date
							</label>
							<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterDataPersonal.confirmDate}}</label>
						    </div>

                               <div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Confirmation
								Period
							</label>
							<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterDataPersonal.confirmationPeriod}}</label>
						    </div>
						
                             <div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Gratuity Nominee 
							</label>
							<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterDataPersonal.gratuityNominee}}</label>
						    </div>
							
							<div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Relation
							</label>
							<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterDataPersonal.nomineeRelation}}</label>
						    </div>

							<div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Mode of Conveyence
							</label>
							<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterDataPersonal.modeConveyence}}</label>
						    </div>



                            <div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Contact No(In Case
									of Emergency)
							</label>
							<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterDataPersonal.emgContactNo}}</label>
						    </div>
							
							<div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Contact Name(In
									Case of Emergency)
							</label>
							<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterDataPersonal.emgContactName}}</label>
						    </div>


							
							
							<div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Resignation Date
							</label>
							<label class="col-md-4 control-label">{{EmployeeMasterDataPersonal.resignationDate}}</label>
						    </div>

                           <div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left">Notice Period To
									Be Served(Months)
							</label>
							
					<label class="col-md-4 control-label" style="text-align: left">{{EmployeeMasterDataPersonal.noticePeriod}}</label>
							
							
						    </div>
						    

						</div>

					
					</div>
				</div>
			
				<div class="form-actions-tab">
					<div class="row" align="center">
						<div class="col-md-12">
						
							<button class="btn btn-danger" type="button"
								data-ng-click="cancel();">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
			
			</tab>
			
			
			
			
			
			<%-- <tab heading="{{tabs[2].title}}" id="referenceTab" class="tab-head"
				active="tabs[2].active" ng-click="setInActive(2);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
																		<th class="sorting width_5">Change Type</th>
																	<th class="sorting width_2">Effective Date</th>
																
																	<!-- <th class="sorting width_8">Old Value</th> -->
																	<th class="sorting width_8">Executed</th>
																	<th class="sorting width_10">Comments</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataHistory in displayedCollectionHistory">
																	<td>{{EmployeeMasterDataHistory.columnName}}</td>
																	<td align="right">{{EmployeeMasterDataHistory.employmentDate}}</td>
																	
<!-- 																	<td>{{EmployeeMasterDataHistory.oldValue}}</td>
 -->																	<td>{{EmployeeMasterDataHistory.newValue}}</td>
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
				
			</form>
			</tab>
			 --%>
			
			
			
			
			<tab heading="{{tabs[2].title}}" id="leaveTab" class="tab-head"
				active="tabs[2].active" ng-click="setInActive(2);">
			<form class="form-horizontal" name="Leave" id="leaveForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
				
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
						<%@taglib uri="http://www.springframework.org/tags"
							prefix="spring"%>
						<%@ taglib prefix="security"
							uri="http://www.springframework.org/security/tags"%>
						<div id="content">
							<!-- widget grid -->
							<section id="widget-grid" data-widget-grid>
							<div class="form-group ">
									<label class="col-md-5 control-label">Contarct Type
									</label>
									<div class="col-md-5">
										<select class="form-control input-sm"
														ng-model="EmployeeMasterData.contarct" 
														name="noticeperiod"
														data-message-id="noticeperiod" 
														friendly-name="noticeperiod">

														<option value="">--Select--</option>
														<option value="Contract">Contract</option>
														<option value="Probation">Probation</option>
														<option value="Confirmed">Confirmed</option>
														
													</select>
 
									</div>
								</div> 
								<div class="form-group">
												<label class="col-md-5 control-label">Status
												</label>
												<div class="col-md-5">
													<select class="form-control input-sm"
														ng-model="EmployeeMasterData.statusContract" 
														name="statusContract"
														data-message-id="statusContract" 
														friendly-name="statusContract">

														<option value="">--Select--</option>
														<option value="Approved">Approved</option>
														<option value="Rejected">Rejected</option>
														<option value="Waiting For Approval">Waiting For Approval</option>
														<option value="Draft">Draft</option>
													
													</select>
												</div>
												
													<!-- <button class="btn btn-sm btn-success width_12"
																 type="button"
																ng-click="search(EmployeeMasterData);">Search</button> -->
											</div>
																	
								<div class="row">
									<article class="col-sm-12">
										<div data-jarvis-widget id="standard-datatable-widget">
											<div role="content">
												<div class="widget-body no-padding">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
														data-st-table="displayedCollectioncontract"
														data-st-safe-src="rowCollectioncontract">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
														
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th >CHANGE TYPE</th>
																	<th >EFFECTIVE DATE</th>
																	<th >COMMENTS</th>
																	<th>APPROVAL STATUS</th>
																	<th>EXECUTED</th>
																
																<!-- 	<th>UTILIZED</th>
																	<th>BALANCE</th> -->
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDatacontract in displayedCollectioncontract">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDatacontract.changeType}}</td>
																	<td class="wrapping">{{EmployeeMasterDatacontract.effectivedate}}</td>
																	<td class="wrapping">{{EmployeeMasterDatacontract.comments}}</td>
																	<td class="wrapping">{{EmployeeMasterDatacontract.status}}</td>
																	<td class="wrapping">{{EmployeeMasterDatacontract.executed}}</td>
																		
																		<!-- <td>{{EmployeeMasterDataLeave.noDays}}</td>
																		<td>{{EmployeeMasterDataLeave.noDays}}</td> -->
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
				
			</form>
			</tab>
			
			
			
			
			
			
			
			
			
			
			
			<tab heading="{{tabs[3].title}}" id="referenceTab" class="tab-head"
				active="tabs[3].active" ng-click="setInActive(3);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
														<!-- <div class="dt-toolbar" style="padding-bottom: 10px;">
															<button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();"></button>
														</div> -->
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	    <th class="width_1"></th>
																	<th class="sorting width_20">PAYMENT NAME </th>
																	<th class="sorting width_10">START DATE</th>
																	<th class="sorting width_20">END DATE</th>
																     <th class="sorting width_10">CURRENCY</th>
																	<th class="sorting width_20">AMOUNT</th>
																
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataRef in displayedCollectionRef">
																	 <td data-cs-select="designation"></td>
																	<td class="wrapping">{{""}}</td>
																	<td class="wrapping">{{""}}</td>
																	<td class="wrapping">{{""}}</td>
																	<td class="wrapping">{{""}}</td>
																	<td class="wrapping">{{""}}</td>
															
																	
																</tr>
															</tbody>
														</table>
														<div class="dt-toolbar-footer"
															data-smart-include="views/layout/toolbar-footer.tpl"></div>
													</div>
												</div>
											<!-- 	end widget content -->
											</div>
											<!-- end widget div -->
										</div>
<!-- 										end widget
 -->									</article>
								
								</div> 
								
								
								
								
							</section>
						</div>
					</div>
				</div>
				
			</form>
			</tab>
			
			
			
			
			
			
			
			
			
			
			
		
			
			
			
			
			<tab heading="{{tabs[4].title}}" id="payrolldedTab" class="tab-head"
				active="tabs[4].active" ng-click="setInActive(4);">
			<form class="form-horizontal" name="Payrollded" id="payrolldedForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
														data-st-table="displayedCollectionPayd"
														data-st-safe-src="rowCollectionPayd">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th class="sorting width_20">DEDUCTION NAME</th>
																	<th class="sorting width_10">MONTH/YEAR</th>
																	<th class="sorting width_10">AMOUNT</th>
																
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataPayd in displayedCollectionPayd">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDataPayd.paycompName}}</td>
																	<td class="wrapping">{{EmployeeMasterDataPayd.monthYear}}</td>
																	<td class="wrapping">{{EmployeeMasterDataPayd.amount}}</td>
																
																	
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
				
			</form>
			</tab>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			<tab heading="{{tabs[5].title}}" id="referenceTab" class="tab-head"
				active="tabs[5].active" ng-click="setInActive(5);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
														data-st-table="displayedCollectionpay"
														data-st-safe-src="rowCollectionpay">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th class="sorting width_20">BANK</th>
																	<th class="sorting width_10">BRANCH</th>
																	<th class="sorting width_20">ACCOUNT NAME</th>
																	<th class="sorting width_10">ACCOUNT NUMBER</th>
																	<th class="sorting width_10">IBAN</th>
																
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataPayRollBank in displayedCollectionpay">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDataPayRollBank.paybankname}}</td>
																	<td class="wrapping">{{EmployeeMasterDataPayRollBank.paybankBranch}}</td>
																	<td class="wrapping">{{EmployeeMasterDataPayRollBank.paybankacctName}}</td>
																	<td class="wrapping">{{EmployeeMasterDataPayRollBank.payAcctNum}}</td>
																	<td class="wrapping">{{EmployeeMasterDataPayRollBank.iban}}</td>
																	
																	
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
			</form>
			</tab>
			
			
			
			
			
			
			
			
			
			
			
			
			
			<tab heading="{{tabs[6].title}}" id="leaveTab" class="tab-head"
				active="tabs[6].active" ng-click="setInActive(6);">
			<form class="form-horizontal" name="Leave" id="leaveForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
				
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
						<%@taglib uri="http://www.springframework.org/tags"
							prefix="spring"%>
						<%@ taglib prefix="security"
							uri="http://www.springframework.org/security/tags"%>
						<div id="content">
							<!-- widget grid -->
							<section id="widget-grid" data-widget-grid>
								<div class="form-group ">
									<label class="col-md-5 control-label">Leave Type
									</label>
									<div class="col-md-5">
										<selectivity list="leaveTypeList"
											property="EmployeeMasterData.leaveType"
											ng-model="EmployeeMasterData.leaveType"
											friendly-name="Leave Type" name="Leave Type"
											></selectivity>
 
									</div>
								</div>
								<div class="form-group">
												<label class="col-md-5 control-label">Status
												</label>
												<div class="col-md-5">
													<select class="form-control input-sm"
														ng-model="EmployeeMasterData.statusId" 
														name="noticeperiod"
														data-message-id="statusId" 
														friendly-name="statusId">

														<option value="">--Select--</option>
														<option value="Approved">Approved</option>
														<option value="Pending">Pending</option>
														<option value="Cancelled">Cancelled</option>
													</select>
												</div>
											</div>
											
								<div class="form-group">
												<label class="col-md-5 control-label">Year
												</label>
												<div class="col-md-5">
													<select class="form-control input-sm"
														ng-model="EmployeeMasterData.year" 
														name="noticeperiod"
														data-message-id="year" 
														friendly-name="year">

														<option value="">--Select--</option>
														<option value="2020">2020</option>
														<option value="2019">2019</option>
														
													</select>
												</div>
												<button class="btn btn-sm btn-success width_12"
																 type="button"
																ng-click="search(EmployeeMasterData);">Search</button>
											</div>
											
								
								<div class="row">
									<article class="col-sm-12">
										<div data-jarvis-widget id="standard-datatable-widget">
											<div role="content">
												<div class="widget-body no-padding">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
														data-st-table="displayedCollectionLeave"
														data-st-safe-src="rowCollectionLeave">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<button style="background-color: #e0dfda;position: relative;left: 50%;width: 35%;">Current Year</button>
															<button style="background-color: #e0dfda;position: relative;left: 50%;width: 10%;">Actual</button>
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th >LEAVE TYPE</th>
																	<th >CURRENT CYCLE</th>
																	<th >LAST ACCRUED DATE</th>
																	<th>ELIGIBLE DAYS/HOURS</th>
																	<th>ACCRUED</th>
																	<th >UTILIZED</th>
																	<th>BALANCE</th>
																<!-- 	<th>UTILIZED</th>
																	<th>BALANCE</th> -->
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataLeave in displayedCollectionLeave">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDataLeave.leaveType}}</td>
																	<td class="wrapping">{{EmployeeMasterDataLeave.fromdate}}</td>
																	<td class="wrapping">{{EmployeeMasterDataLeave.todate}}</td>
																	<td class="wrapping">{{EmployeeMasterDataLeave.noDays}}</td>
																	<td>{{EmployeeMasterDataLeave.totalLeave}}</td>
																		<td>{{EmployeeMasterDataLeave.availed}}</td>
																		<td>{{EmployeeMasterDataLeave.balance}}</td>
																		<!-- <td>{{EmployeeMasterDataLeave.noDays}}</td>
																		<td>{{EmployeeMasterDataLeave.noDays}}</td> -->
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
				
			</form>
			</tab>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			<tab heading="{{tabs[7].title}}" id="referenceTab" class="tab-head"
				active="tabs[7].active" ng-click="setInActive(7);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
				
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
														data-st-table="displayedCollectionaircliams"
														data-st-safe-src="rowCollectionaircliams">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th class="sorting width_20">Ticket Sectors</th>
																	<th class="sorting width_10">Ticket Class</th>
																	<th class="sorting width_20">Due Date</th>
																	<th class="sorting width_10">Claim Date</th>
																	<th class="sorting width_10">Self Tickets</th>
																
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataAircliams in displayedCollectionaircliams">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDataAircliams.ticksec}}</td>
																	<td class="wrapping">{{EmployeeMasterDataAircliams.airclass}}</td>
																	<td class="wrapping">{{EmployeeMasterDataAircliams.airdueDate}}</td>
																	<td class="wrapping" data-toggle="tooltip"
																		title="{{detail.description}}">{{EmployeeMasterDataAircliams.airdueDate}}</td>
																	<td>{{EmployeeMasterDataAircliams.airselftick}}</td>
																	
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
				
			</form>
			</tab>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			<tab heading="{{tabs[8].title}}" id="documentsTab" class="tab-head"
				active="tabs[8].active" ng-click="setInActive(8);">
			<form class="form-horizontal" name="Documents" id="documentsForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6">
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
															<!-- <button class="btn btn-success width_12" type="button"
																ng-click="addDocuments();">Add Documents</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>

																	<th class="sorting width_20">Type</th>
																	<th class="sorting width_10">Number</th>
																	<th class="width_2 text-center">Issue/Signed Date</th>
																		<th class="sorting width_10">Expiry Date</th>
																	<th class="width_2 text-center">Issued Country/Governing Law</th>
																<th class="width_2 text-center">Download File</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataDoc in displayedCollectionDoc">

																	<td class="wrapping">{{EmployeeMasterDataDoc.docType}}</td>
																	<td class="wrapping">{{EmployeeMasterDataDoc.docName}}</td>
																		<td class="wrapping">{{EmployeeMasterDataDoc.issueDate}}</td>
																			<td class="wrapping">{{EmployeeMasterDataDoc.expiryDate}}</td>
																		
																	<td class="wrapping">{{EmployeeMasterDataDoc.issuecountry}}</td>
																	 <td class=" td-actions text-center"><!-- <span>
																			<i class="fa  fa-pencil text-success text"
																			data-ng-click="editRowDoc(EmployeeMasterDataDoc)"></i>
																	</span> <span> <i
																			class="fa fa-trash-o text-danger-dker text"
																			data-ng-click="deleteRowDoc(EmployeeMasterDataDoc)"></i>
																	</span> --><button class="btn btn-primary ng-binding ng-scope" >
<i class="fa fa-download" > </i><a href="{{EmployeeMasterDataDoc.uploadDoc}}" download>Download</a>
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
				
			</form>
			</tab> 
			
			
			
			
			
			
			
			
			
			
			
			
			
		<tab heading="{{tabs[9].title}}" active="tabs[9].active"
				class="tab-head" ng-click="setInActive(9);">
			<form class="form-horizontal" name="Family" id="familyForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
						
						<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
																<!-- <button class="btn btn-success width_12" type="button"
																	ng-click="addFamily();">Add Family</button> -->
															</div>
															<table id="dt_basic"
																class="table table-striped table-bordered table-hover dataTable no-footer"
																role="grid" aria-describedby="dt_basic_info">
																<thead class="dataTables-Main-Head">
																	<tr>
																		<th class="sorting" st-sort="relativeName">MEMBER NAME</th>
																		<th class="sorting" st-sort="relationToEmployee">RELATIONSHIP</th>

																		<th class="sorting" st-sort="dependentPassportNo">ADHAR NO</th>
																		<th class="sorting"
																			st-sort="dependentPassportExpiryDate">MOBILE NO</th>

																		<th class="sorting" st-sort="dependentVisaType">DOB
																		</th>

																		<th class="sorting" st-sort="dependentOnEmployee">Is
																			Dependent</th>
																		<!-- <th class="table-heading">Action</th> -->
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
																<!--<td class=" td-actions text-center"><span>
																				<i class="fa  fa-pencil text-success text"
																				data-ng-click="editRowFamily(empFamilyList)"></i>
																		</span> <span> <i
																				class="fa fa-trash-o text-danger-dker text"
																				data-ng-click="deleteRowFamily(empFamilyList)"></i>
																		</span></td> -->
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
				
			</form>
			</tab>  
			
			
			
			
			
			
			
			<tab heading="{{tabs[10].title}}" id="referenceTab" class="tab-head"
				active="tabs[10].active" ng-click="setInActive(10);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
														data-st-table="displayedCollectionlere"
														data-st-safe-src="rowCollectionlere">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th class="sorting width_20">TYPE </th>
																	<th class="sorting width_10">REQUEST DATE</th>
																	<th class="sorting width_20">ISSUE DATE</th>
																	<th class="sorting width_20">ISSUE STATUS</th>
																	
																
																	
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDatalere in displayedCollectionlere">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDatalere.addressletter}}</td>
																	<td class="wrapping">{{EmployeeMasterDatalere.letterreqDate}}</td>
																	<td class="wrapping">{{EmployeeMasterDatalere.letterIssueDate}}</td>
															<td class="wrapping">{{EmployeeMasterDatalere.letterStatus}}</td>
																	
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
				
			</form>
			</tab>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			<tab heading="{{tabs[11].title}}" id="referenceTab" class="tab-head"
				active="tabs[11].active" ng-click="setInActive(11);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
						<%@taglib uri="http://www.springframework.org/tags"
							prefix="spring"%>
						<%@ taglib prefix="security"
							uri="http://www.springframework.org/security/tags"%>
						<div id="content">
							<!-- widget grid -->
							<section id="widget-grid" data-widget-grid>
								<div class="row">
									<article class="col-sm-1">
										<div data-jarvis-widget id="standard-datatable-widget">
											<div role="content">
												<div class="widget-body no-padding">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
														data-st-table="displayedCollectionLoan"
														data-st-safe-src="rowCollectionLoan">
														<div class="dt-toolbar" style="padding-bottom: 5px;">
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																		<th class="sorting width_8">Code</th>
																			<th class="sorting width_8">Name</th>
																	<th class="sorting width_10">Loan Type</th>
																<!-- 	<th class="sorting width_10">Application Date</th> -->
																		<th class="sorting width_8">Start Date</th>
 <!-- 																	<th class="sorting width_20">Repayment Start Date</th>
 --> 																	<th class="sorting width_8">End Date</th>	
 																		<th class="sorting width_8">Currency</th>														
  																		<th class="sorting width_8">Loan Amount</th>
  																		<th class="sorting width_8">Total Number Of Months</th>
																	<th class="sorting width_8">Paid</th>
																	<th class="sorting width_8">Balance</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataLoan in displayedCollectionLoan">
																	<!--  <td data-cs-select="designation"></td> -->
																		<td class="wrapping">{{EmployeeMasterDataLoan.empId}}</td>
																			<td class="wrapping">{{EmployeeMasterDataLoan.employeeName}}</td>
																	<td class="wrapping">{{EmployeeMasterDataLoan.loanTypeName}}</td>
																
																	<td class="wrapping">{{EmployeeMasterDataLoan.RepaystartDate}}</td>
																		<td class="wrapping">{{EmployeeMasterDataLoan.approvedOn}}</td>
																	<td>{{EmployeeMasterDataLoan.currency}}</td>
																	<td>{{EmployeeMasterDataLoan.loanAmount}}</td>
																	
																	<td>{{EmployeeMasterDataLoan.numberOfInstalments}}</td>
																	<td>{{EmployeeMasterDataLoan.paid}}</td>
																	<td>{{EmployeeMasterDataLoan.balance}}</td>
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
				
			</form>
			</tab>
			
			
			
			
			
			
			
			
			
			
			
			
			
			<tab heading="{{tabs[12].title}}" id="referenceTab" class="tab-head"
				active="tabs[12].active" ng-click="setInActive(12);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
														data-st-table="displayedCollectionadress"
														data-st-safe-src="rowCollectionaddress">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th class="sorting width_10">LINE.1</th>
																	<th class="sorting width_20">LINE.2</th>
																	<th class="sorting width_10">PLACE</th>
																	<th class="sorting width_10">PHONE</th>
																	<!-- <th class="sorting width_10">EMAIL</th> -->
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataAddress in displayedCollectionadress">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDataAddress.permAddress}}</td>
																	<td class="wrapping">{{EmployeeMasterDataAddress.presentAddress}}</td>
																	<td class="wrapping">{{EmployeeMasterDataAddress.permPlace}}</td>
																<td class="wrapping">{{EmployeeMasterDataAddress.permMobile}}</td>
<!-- 																	<td class="wrapping">{{EmployeeMasterDataAddress.permPin}}</td>
 -->																</tr>
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
			</form>
			</tab>
			
			
			
			
			
			
			<tab heading="{{tabs[13].title}}" id="referenceTab" class="tab-head"
				active="tabs[13].active" ng-click="setInActive(13);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th class="sorting width_20">TYPE</th>
																	<th class="sorting width_10">COURSE NAME</th>
																	<th class="sorting width_20">UNIVERSITY</th>
																	<th class="sorting width_10">YEAR</th>
<!-- 																	<th class="sorting width_10">APPROVAL STATUS</th>
 -->																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataRef in displayedCollectionRef">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDataRef.referenceName}}</td>
																	<td class="wrapping">{{EmployeeMasterDataRef.relationshipRef}}</td>
																	<td class="wrapping">{{EmployeeMasterDataRef.occupationRef}}</td>
																	<td class="wrapping">{{EmployeeMasterDataRef.yearOfpassing}}</td>
<!-- 																	<td class="wrapping">{{EmployeeMasterDataRef.relationshipRef}}</td>
 -->																	
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
			</form>
			</tab>
			
			
			
			
			
			
			
			<tab heading="{{tabs[14].title}}" id="referenceTab" class="tab-head"
				active="tabs[14].active" ng-click="setInActive(14);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
														data-st-table="displayedCollectiontravel"
														data-st-safe-src="rowCollectiontravel">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th class="sorting width_20">Request Code</th>
																	<th class="sorting width_10">Travel Type</th>
																	<th class="sorting width_20">Request Date</th>
																	<th class="sorting width_10">Approval Status</th>
																	<th class="sorting width_10">Status</th>
																
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDatatravel in displayedCollectiontravel">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDatatravel.requestForName}}</td>
																	<td class="wrapping">{{EmployeeMasterDatatravel.travelType}}</td>
																	<td class="wrapping">{{EmployeeMasterDatatravel.travelrequestDate}}</td>
																	<td class="wrapping" data-toggle="tooltip"
																		title="{{detail.description}}">{{EmployeeMasterDatatravel.travelStatus}}</td>
																	<td>{{EmployeeMasterDatatravel.travelStatus}}</td>
																	
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
				
			</form>
			</tab>
			
			
			
			
			
			
			
			
			
			<tab heading="{{tabs[15].title}}" id="referenceTab" class="tab-head"
				active="tabs[15].active" ng-click="setInActive(15);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
														data-st-table="displayedCollectionPassport"
														data-st-safe-src="rowCollectionPassport">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th class="sorting width_20">TYPE</th>
																	<th class="sorting width_20">Request Date</th>
																	<th class="sorting width_10">Comments</th>
																
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDatapassport in displayedCollectionPassport">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDatapassport.passrequestType}}</td>
																	<td class="wrapping">{{EmployeeMasterDatapassport.passrequestDate}}</td>
																	<td class="wrapping">{{EmployeeMasterDatapassport.passrequestcomments}}</td>
																
																	
																	
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
				
			</form>
			</tab>
			
			
			
			
			
			
			
			
			<tab heading="{{tabs[16].title}}" id="referenceTab" class="tab-head"
				active="tabs[16].active" ng-click="setInActive(16);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
														data-st-table="displayedCollectionmanage"
														data-st-safe-src="rowCollectionmanage">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														
														 <!-- <div class="form-group">
							<label class="col-md-4 control-label"><b>NEW REPORTING MANAGER </b>
							</label>
							
					<label class="col-md-4 control-label">{{EmployeeMasterData.appraisalfinalName}}</label>
							
							
						    </div> -->
														 <table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	    <th class="width_1"></th>
																	<th class="sorting width_20">NEW REPORTING MANAGER </th>
																	
																	
																
																	<th class="width_2 text-center">Action</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterData in displayedCollectionmanage">
																	 <td data-cs-select="designation"></td>
																	<td class="wrapping">{{EmployeeMasterData.appraisalfinalName}}</td>
																
															
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
				
			</form>
			</tab>
			
			
			
			
			
			
			
			
			
			
			<tab heading="{{tabs[17].title}}" id="referenceTab" class="tab-head"
				active="tabs[17].active" ng-click="setInActive(17);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
														data-st-table="displayedCollectionPay"
														data-st-safe-src="rowCollectionPay">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th class="sorting width_20">Payslip Number</th>
																	<th class="sorting width_10">Financial Year</th>
																	<th class="sorting width_20">Payroll Month</th>
																	<th class="sorting width_10">Start Date</th>
																	<th class="sorting width_10">End Date</th>
																
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataPay in displayedCollectionPay">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDataPay.paySlipNo}}</td>
																	<td class="wrapping">{{EmployeeMasterDataPay.paymonthYear}}</td>
																	<td class="wrapping">{{EmployeeMasterDataPay.emailRef}}</td>
																	<td class="wrapping">{{EmployeeMasterDataPay.emailRef}}</td>								<td>{{EmployeeMasterDataRef.pincodeRef}}</td>
																	
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
				
			</form>
			</tab>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			<tab heading="{{tabs[18].title}}" id="referenceTab" class="tab-head"
				active="tabs[18].active" ng-click="setInActive(18);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
														data-st-table="displayedCollectionsettle"
														data-st-safe-src="rowCollectionsettle">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th class="sorting width_20">Type </th>
																	<th class="sorting width_10">Last Working Days</th>
																	<th class="sorting width_20">Comments</th>
																	
																
																	
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataSettle in displayedCollectionsettle">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDataSettle.settleType}}</td>
																	<td class="wrapping">{{EmployeeMasterDataSettle.settlelastDate}}</td>
																	<td class="wrapping">{{EmployeeMasterDataSettle.settlecomments}}</td>
															
																	
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
				
			</form>
			</tab>
			
			
			
			
			
			
			<tab heading="{{tabs[19].title}}" id="referenceTab" class="tab-head"
				active="tabs[19].active" ng-click="setInActive(19);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th class="sorting width_20">Type </th>
																	<th class="sorting width_10">Requirement</th>
																	<th class="sorting width_20">Request Type</th>
																	
																
																	<!-- <th class="width_2 text-center">Action</th> -->
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataRef in displayedCollectionRef">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDataRef.lreferenceName}}</td>
																	<td class="wrapping">{{EmployeeMasterDataRef.lrelationshipRef}}</td>
																	<td class="wrapping">{{EmployeeMasterDataRef.lemailRef}}</td>
															
																	<!-- <td class=" td-actions text-center"><span>
																			<i class="fa  fa-pencil text-success text"
																			data-ng-click="editRowReference(EmployeeMasterDataRef)"></i>
																	</span> <span> <i
																			class="fa fa-trash-o text-danger-dker text"
																			data-ng-click="deleteRowReference(EmployeeMasterDataRef)"></i>
																	</span></td> -->
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
				
			</form>
			</tab>
			
			
			
			
			
			
			
			<tab heading="{{tabs[20].title}}" id="referenceTab" class="tab-head"
				active="tabs[20].active" ng-click="setInActive(20);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
				
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
														data-st-table="displayedCollectionform"
														data-st-safe-src="rowCollectionform">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th class="sorting width_20">FORM NAME </th>
																	<th class="sorting width_10">REVIEW DATE</th>
																	<th class="sorting width_20">APPROVAL STATUS</th>
																	
																
															
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataforms in displayedCollectionform">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDataforms.formreviewType}}</td>
																	<td class="wrapping">{{EmployeeMasterDataforms.formreviewDate}}</td>
																	<td class="wrapping"></td>
															
																	
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
				
			</form>
			</tab>
			
			
			
			
			
			
			
			
			<tab heading="{{tabs[21].title}}" id="referenceTab" class="tab-head"
				active="tabs[21].active" ng-click="setInActive(21);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
														data-st-table="displayedCollectionAssets"
														data-st-safe-src="rowCollectionAssets">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th class="sorting width_10">Name</th>
																	<th class="sorting width_20">Request Type</th>
																		<th class="sorting width_20">Asset desc</th>
																			<th class="sorting width_20">Asset Code</th>
																<th class="sorting width_20">Quantity</th>
																<th class="sorting width_20">Asset Status</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataAssets in displayedCollectionAssets">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDataAssets.assetName}}</td>
																	<td class="wrapping">{{EmployeeMasterDataAssets.assetType}}</td>
																	<td class="wrapping">{{EmployeeMasterDataAssets.assetdesc}}</td>
																	<td class="wrapping">{{EmployeeMasterDataAssets.assetName}}</td>
																	<td class="wrapping">{{EmployeeMasterDataAssets.assetquantity}}</td>
																	<td class="wrapping">{{EmployeeMasterDataAssets.assetstatus}}</td>
															
																	
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
				
			</form>
			</tab>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			<tab heading="{{tabs[22].title}}" id="referenceTab" class="tab-head"
				active="tabs[22].active" ng-click="setInActive(22);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
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
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th class="sorting width_20">GENERATE CHART </th>
																	
																	
																
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataRef in displayedCollectionRef">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDataRef.lreferenceName}}</td>
																
															
																	
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
				
			</form>
			</tab>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			 <!-- WIDGET END --> <tab heading="{{tabs[16].title}}" id="salesTab"
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