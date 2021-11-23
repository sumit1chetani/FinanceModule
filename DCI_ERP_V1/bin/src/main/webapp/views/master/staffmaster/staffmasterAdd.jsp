
								 <style type="text/css">
.nav-justified>li, .nav-tabs.nav-justified>li {
	background-color: #3B8A8A;
}

.textareath {
	resize: vertical;
	max-height: 124px;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 160px !important;
	margin: 0 auto !important;
}
</style> 


								
								<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		 
									<div class="panel-body">
										<div class="col-sm-12">
											<div class="col-sm-11 alert alert-success alert-dismissable"
												ng-if="thumbsAlert">
												<button ng-if="error" type="button" class="close"
													data-dismiss="alert" aria-hidden="true">×</button>
												{{successMsg}}
											</div>
											<div class="col-sm-11 alert alert-danger alert-dismissable"
												ng-if="error">
												<button ng-if="error" type="button" class="close"
													data-dismiss="alert" aria-hidden="true">×</button>
												{{errorMsg}}
											</div>
										</div>
										<form class="form-horizontal form-border" method="POST" name="trailerForm" novalidate">
											<div class="col-md-12">
											
											
										<div class="col-md-5">
													<label class="col-md-5 control-label">IAHS EMP CODE<span style="color: red;">*</span>
													</label>
													<div class="col-md-5">
														<input type="text" class="form-control input-sm"
															name="trailerNo" validation="required" friendly-name="Employee No" form-name="EmployeeForm"
															ng-model="staff.iahsempcode">
													</div>
												</div>
												
								<div class="col-md-5 ">
									<label class="col-md-5 control-label">TRMS EMPLOYEES <span
										style="color: red;">*</span></label>
									<div class="col-md-5">
										<selectivity list="employeelist1"
											property="staff.trmsempcode"
											ng-model="staff.trmsempcode"
											friendly-name="Employee Name" name="Employee Name"
											form-name="frmProfile" validation="required"></selectivity>
											</div>
								</div>			

											</div>
							<br>
								<br>
									<br>
										<br>
										   <br>
											   <br>
											<div class="form-group" id="updateButtonId">
												<label class="col-sm-5 control-label"></label> 
												<div class="col-sm-4">
													<button class="btn btn-success" type="button"
														ng-click="save()" ng-if="!edit">
														<i class="fa fa-save"></i> Save</button>
													<button class="btn btn-success" type="button"
														ng-click="validate(trailer,trailerForm)" ng-if="edit">
														<i class="fa fa-save"></i> Update</button>
												  <button class="btn btn-danger" type="button"
														ng-click="cancel()"> 
														<i class="fa fa-close"></i> Cancel</button>	
														
														<br>
						    	<br>
									<br>
										<br>	
												<table
													class="table table-striped table-hover dataTable no-footer">
								

                                         <br>
											<br>
											   <br>
										

												</table>
												
												</div>

											</div>
																			</div>
							</div>
						