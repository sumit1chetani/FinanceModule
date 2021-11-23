<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<!-- widget grid -->
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" >
					<header>
					  <span class="widget-icon">
				       <i class="fa fa-table"></i>
				      </span>
				       <span><state-breadcrumbs></state-breadcrumbs></span>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="EmployeeMovementForm" >
								<div class="row">
									<div class="col-sm-10 col-md-10 col-lg-10 col-md-offset-1">
										<fieldset>
										
<!-- 											<div class="form-group"> -->
<!-- 												<div class="col-md-5 col-md-offset-5 control-label-left" ng-init="movement='self'"> -->
<!-- 													<label class="radio-inline"> -->
<!-- 													<input type="radio" name="movement" class="ng-pristine ng-untouched ng-valid" value="self" ng-model="movement">Self</label> -->
<!-- 													<label class="radio-inline"> -->
<!-- 													<input type="radio" name="movement" class="ng-pristine ng-untouched ng-valid" value="others" ng-model="movement">Others</label> -->
<!-- 												</div> -->
<!-- 											</div> -->
											
<!-- 											<div class="col-sm-12 col-md-12 col-lg-12" ng-show="movement=='others'"> -->
											
<!-- 										</div> -->
										<div class="form-group">
												<label class="col-md-4 control-label">
													Organization<span style="color:red;">*</span> </label>
												<input type="hidden" value="${form_code}" id="formCode"/>
												<div class="col-md-3">
														<selectivity list="companyList" property="employeeMovementData.hospital" 
														ng-model="employeeMovementData.hospital" name="Company" validation="required" friendly-name="Hospital" form-name="EmployeeMovementForm"></selectivity>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">
													Branch<span style="color:red;">*</span> </label>
												<div class="col-md-3">
														<selectivity list="branchList" property="employeeMovementData.branch" 
														ng-model="employeeMovementData.branch" name="Branch" validation="required" friendly-name="Branch" form-name="EmployeeMovementForm"></selectivity>
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-md-4 control-label">
													Department<span style="color:red;">*</span> </label>
												<div class="col-md-3">
														<selectivity list="departmentList" property="employeeMovementData.departmentId" 
														ng-model="employeeMovementData.departmentId" name="Department" validation="required" friendly-name="Department" form-name="EmployeeMovementForm"></selectivity>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">
													Employee<span style="color:red;">*</span> </label>
												<div class="col-md-3">
														<selectivity list="employeeList" property="employeeMovementData.employee" 
														ng-model="employeeMovementData.employee" name="Employee" validation="required" friendly-name="Employee" form-name="EmployeeMovementForm"></selectivity>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">Date<span style="color:red;">*</span></label>
												<div class="col-md-3">
							               			<div class='input-group date datetimepick'  style="width:100%">
							            				<div class="dropdown">
							             					<a class="dropdown-toggle" id="effectFromDateValidate" role="button" data-toggle="dropdown" data-target="#" href="#">
							              						<div class="input-group">
													               <input type="text" class="form-control"
													                	placeholder="dd/mm/yyyy" name="Date" id="Date"
													                	validation="required" friendly-name="Date" form-name="EmployeeMovementForm"
													                	data-message-id="effectFromDate"
													                	data-ng-model="employeeMovementData.empDate"><span
													                	class="input-group-addon"><i
													                	class="glyphicon glyphicon-calendar"></i></span>
													            </div>
							             					</a>
							             					<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
							              						<datetimepicker data-ng-model="employeeMovementData.empDate"
							               							data-on-set-time="employeeMovementData.empDate = onDateSet(newDate)"
							               							data-datetimepicker-config="{ dropdownSelector: '#effectFromDateValidate',startView:'day', minView:'day'}" />
							             					</ul>
							            				</div>
							           				</div>
							           				
					             				</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Out Time<span style="color:red;">*</span></label>
												<div class="col-md-3">
									             	<div class="dropdown">
									               		<a class="dropdown-toggle" id="thresholdTimeValidate" role="button"
									                		data-toggle="dropdown" data-target="#" href="#">
											             <div class="input-group">
											                 <input type="text" class="form-control" placeholder="hh:mm" name="Out Time" id="empOutTime"
											                 	validation="required" friendly-name="Out Time" form-name="EmployeeMovementForm"
											                 	data-message-id="empOutTime" 
											                  	data-ng-model="employeeMovementData.empOutTime"><span
											                  	class="input-group-addon"><i
											                  	class="glyphicon glyphicon-time"></i></span>
											             </div>
									               		</a>
										               <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
										                	<datetimepicker data-ng-model="employeeMovementData.empOutTime" data-on-set-time="employeeMovementData.empOutTime = onTimeSet(newDate)"
										                 		data-datetimepicker-config="{ dropdownSelector: '#thresholdTimeValidate',startView:'hour', minView:'minute'}" />
										               </ul>
									            	</div>
						             			</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Place And Purpose Of Visit<span style="color:red;">*</span></label>
												<div class="col-md-3">
												  <textarea class="form-control input-sm" style="resize:none" rows="3" name="Place And Purpose Of Visit" id="Place And Purpose Of Visit"
												   ng-model="employeeMovementData.empPurposeofVisit" validation="required" friendly-name="Place And Purpose Of Visit" form-name="EmployeeMovementForm"></textarea>
												</div>
											</div>
										</fieldset>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" type="button"
												class="btn btn-success" data-ng-click="save(EmployeeMovementForm)" data-ng-if="!isEdit">
												<i class="fa fa-save"></i> Save
											</button>
											<button class="btn btn-success" type="button"
												class="btn btn-success" data-ng-click="update(EmployeeMovementForm)"
												data-ng-if="isEdit == true">
												<i class="fa fa-save"></i> Update
											</button>
											<button class="btn btn-info" type="button"
												class="btn btn-success" data-ng-click="reset()">
												<i class="fa fa-undo"></i> Reset
											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancel();">
												<i class="fa fa-close"></i> Cancel
											</button>
										</div>
									</div>
								</div>
							</form>
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