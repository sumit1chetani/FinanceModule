<script>


</script>
<style>
.con-ele input {
	height: 30px;
}

.bookingDtlCls {
	border-bottom: 2px solid #23b7e5 !important;
/* 	border-top: 2px solid #23b7e5 !important; */
	/*  border-left: 1px solid #23b7e5 !important;
    border-right: 1px solid #23b7e5 !important; */
}

tbody::before {
	content: '';
	display: block;
	height: 15px;
	/*  border-left: 0px solid  !imNSA-NHAVA SHEVA, INDIA	portant;
   border-right: 1px solid #23b7e5 !important;
       width: 100%; */
}

<
style>a:hover {
	color: black;
}

srrs
.panel .actions {
	right: 8%;
}

.subTable-brs {
	padding: 8px !important;
}
.form-horizontal .control-label{
padding-top :0px !important;
}
</style>

<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="depotForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">

						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Employee ID :</label>
								<div class="col-md-3">
 
										<label><b>{{EmployeeMasterData.empId}}</b></label>				
										
										
								</div>
							</div>
					
							<div class="form-group">
							 
								<label class="col-md-4 control-label">First Name :</label>
									<div class="col-md-3">
								 
										<label>{{EmployeeMasterData.firstName}}</label>				
										
										
								</div>
							</div>
						 

							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Last Name :</label>
								<div class="col-md-3">
									 
		     										<label>{{EmployeeMasterData.lastName}}</label>				
		          						
		          						
								</div>
							</div>
							
								<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Gender :</label>
								<div class="col-md-3">
									 
		     										<label>{{EmployeeMasterData.genderName}}</label>				
		          						
		          						
								</div>
							</div>
							
							<div class="form-group">
							 
								<label class="col-md-4 control-label">Country:</label>
									<div class="col-md-3">
								 
										<label>{{EmployeeMasterData.countryName}}</label>				
										
										
								</div>
							</div>
							
							<div class="form-group">
							 
								<label class="col-md-4 control-label">Mobile Number :</label>
									<div class="col-md-3">
								 
										<label>{{EmployeeMasterData.mobileNo}}</label>				
										
										
								</div>
							</div>
							<div class="form-group">
							 
								<label class="col-md-4 control-label">Designation</label>
									<div class="col-md-3">
								 
										<label>{{EmployeeMasterData.designationName}}</label>				
										
										
								</div>
							</div>
							<div class="form-group">
							 
								<label class="col-md-4 control-label">Company</label>
									<div class="col-md-3">
								 
										<label>{{EmployeeMasterData.companyName}}</label>				
										
										
								</div>
							</div>
							
							<div class="form-group">
							 
								<label class="col-md-4 control-label">User Location</label>
									<div class="col-md-3">
								 
										<label>{{EmployeeMasterData.userlocation}}</label>				
										
										
								</div>
							</div>
                       <div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Is Active :</label>
								<div class="col-md-3">
									 
		     										<label>{{EmployeeMasterData.active}}</label>				
		          						
		          						
								</div>
							</div>
							
							   <div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Is Agent/Depot :</label>
								<div class="col-md-3">
									 
		     										<label>{{EmployeeMasterData.vendor}}</label>				
		          						
		          						
								</div>
							</div>
							
							
							
							
							
							       
       	<div class="form-group" >
								<label class="col-md-4 control-label"> File Attachment :
												</label>
												<!-- <div class="col-md-5">
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
												</div> -->
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
						</fieldset>

					</div>


<div class="col-sm-12 col-md-12 col-lg-6">
							<fieldset>
							
				 			<div class="form-group">
								<label class="col-md-4 control-label">Middle Name :</label>
								<div class="col-md-3">
 
										<label>{{EmployeeMasterData.middleName}}</label>				
										
										
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">  Email ID :</label>
								<div class="col-md-3">
        						<label>{{EmployeeMasterData.emailId}}</label>				
								
								</div>
							</div> 
							<div class="form-group">
							 
								<label class="col-md-4 control-label">DOB :</label>
									<div class="col-md-3">
								 
										<label>{{EmployeeMasterData.dob}}</label>				
										
										
								</div>
							</div>
								<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									DOJ :</label>
								<div class="col-md-3">
									 
		     										<label>{{EmployeeMasterData.doj}}</label>				
		          						
		          						
								</div>
							</div>
								<div class="form-group">
							 
								<label class="col-md-4 control-label">Department :</label>
									<div class="col-md-3">
								 
										<label>{{EmployeeMasterData.departmentCode}}</label>				
										
										
								</div>
							</div>
							
							<div class="form-group">
							 
								<label class="col-md-4 control-label">Branch :</label>
									<div class="col-md-3">
								 
										<label>{{EmployeeMasterData.branchName}}</label>				
										
										
								</div>
							</div>
							
							
							<div class="form-group">
							 
								<label class="col-md-4 control-label">Agency / Depot :</label>
									<div class="col-md-3">
								 
										<label>{{EmployeeMasterData.agentName}}</label>				
										
										
								</div>
							</div>
							
								<div class="form-group">
							 
								<label class="col-md-4 control-label">Port :</label>
									<div class="col-md-3">
								 
										<label>{{EmployeeMasterData.portCodes}}</label>				
										
										
								</div>
							</div>
							<div class="form-group">
							 
								<label class="col-md-4 control-label">Created By :</label>
									<div class="col-md-3">
								 
										<label>{{EmployeeMasterData.createdBy}}</label>				
										
										
								</div>
							</div>
						 
						 
						  
						 <div class="form-group">
							 
								<label class="col-md-4 control-label">Create Date :</label>
									<div class="col-md-3">
								 
										<label>{{EmployeeMasterData.createdDate}}</label>				
										
										
								</div>
							</div>
						 <div class="form-group">
							 
								<label class="col-md-4 control-label">Modified By :</label>
									<div class="col-md-3">
								 
										<label>{{EmployeeMasterData.modifiedBy}}</label>				
										
										
								</div>
							</div>
						
						 
						 <div class="form-group">
							 
								<label class="col-md-4 control-label">Modified Date :</label>
									<div class="col-md-3">
								 
										<label>{{EmployeeMasterData.modifiedDate}}</label>				
										
										
								</div>
							</div>
						 
						 

							
							</fieldset>
							
							</div>

				
				<!-- /row -->
				<br>
		
				</div>
				<br>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-11">
							

							
							<button class="btn btn-danger" type="button"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>


						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
