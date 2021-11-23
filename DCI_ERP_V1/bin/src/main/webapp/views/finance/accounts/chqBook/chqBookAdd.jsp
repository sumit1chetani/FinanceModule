<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="manageChqBookAddForm">
        <div class="row">
        
         <div class="col-sm-12 col-md-10 col-lg-10">
          <fieldset>
          
	         							
	         							
	         								<div class="form-group">
												<label class="col-md-5 control-label">Bank Account<span style="color:red;">*</span></label>
												<div class="col-md-3">
													<selectivity list="bankAccountList" id="bankAccountId" name="bankAccountId" 
												        property="manageChqBookObj.bankAccountId" ng-model="manageChqBookObj.bankAccountId"
												        validation="required" friendly-name="Bank Account" form-name="manageChqBookAddForm">
												    </selectivity>
												</div>
											</div>
											<div class="form-group" ng-hide="isEdit==true">
												<label class="col-md-5 control-label"> Starting Leaves<span style="color:red;">*</span></label>
												<div class="col-md-3">
													<input type="text" class="form-control input-sm text-right" ng-model="manageChqBookObj.startingLeaves" ng-pattern-restrict="{{numExp}}"
														id="startingLeaves" name="startingLeaves" validation="required" friendly-name="Starting Leaves" />
												</div>
											</div>
											<div class="form-group" ng-hide="isEdit==true">
												<label class="col-md-5 control-label"> Number of Leaves<span style="color:red;">*</span></label>
												<div class="col-md-3">
													<input type="text" class="form-control input-sm text-right" ng-model="manageChqBookObj.noOfLeaves" ng-pattern-restrict="{{numExp}}"
														id="noOfLeaves" name="noOfLeaves" validation="required" friendly-name="Number of Leaves" />
												</div>
											</div>
											<div class="form-group" ng-show="isEdit==true">
												<label class="col-md-5 control-label"> Cheque Number</label>
												<div class="col-md-3">
													<input type="text" class="form-control input-sm" ng-model="manageChqBookObj.chqNo" readonly
														id="chqNo" name="chqNo" />
												</div>
											</div>
											<div class="form-group" ng-show="isEdit==true">
												<label class="col-md-5 control-label"> Cheque Status</label>
												<div class="col-md-3">
													<input type="text" class="form-control input-sm" ng-model="manageChqBookObj.chequeStatus" readonly
														id="chequeStatus" name="chequeStatus" />
												</div>
											</div>
											
											<div class="form-group ">
								<label class="col-md-5 control-label">Cheque Date<span
									style="color: red">*</span></label>
								<div class="col-md-3 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="manageChqBookObj.chequeDate"
										id="chequedate" name="chequedate"
										data-ng-change="checkDatesCL(manageChqBookObj.chequeDate)"
										friendly-name="Valid From" validation="required" />
								</div>
								</div>
											<!-- div class="form-group">
												<label class="col-md-5 control-label">Cheque Date </label>
													<div class="col-md-5">
														<div class='input-group date datetimepick'>
															<div class="dropdown">
																<a class="dropdown-toggle" id="chequedate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="chequeDate" id="chequeDate" readonly 
																			data-ng-model="manageChqBookObj.chequeDate">
																		<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker data-ng-model="manageChqBookObj.validFrom" data-on-set-time="manageChqBookObj.validFrom = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#validFromDate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
											</div> -->
	         								<!-- <div class="form-group">
												<label class="col-md-5 control-label">Valid From<span style="color:red;">*</span></label>
													<div class="col-md-5">
														<div class='input-group date datetimepick'>
															<div class="dropdown">
																<a class="dropdown-toggle" id="validFromDate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="validFrom" id="validFrom" readonly 
																			data-ng-model="manageChqBookObj.validFrom" validation="required" friendly-name="Valid From">
																		<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker data-ng-model="manageChqBookObj.validFrom" data-on-set-time="manageChqBookObj.validFrom = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#validFromDate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
											</div> -->
											
											<div class="form-group ">
								<label class="col-md-5 control-label">Valid From<span
									style="color: red">*</span></label>
								<div class="col-md-3 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="manageChqBookObj.validFrom"
										id="validFromDate" name="validFrom"
										data-ng-change="checkDatesCL(manageChqBookObj.validFrom)"
										friendly-name="Valid From" validation="required" />
								</div>
								</div>
											<!-- <div class="form-group">
												<label class="col-md-5 control-label">Valid To<span style="color:red;">*</span></label>
													<div class="col-md-5">
														<div class='input-group date datetimepick'>
															<div class="dropdown">
																<a class="dropdown-toggle" id="validToDate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="validTo" id="validTo"
																			data-ng-model="manageChqBookObj.validTo" validation="required" friendly-name="Valid From">
																			<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker data-ng-model="manageChqBookObj.validTo" data-on-set-time="manageChqBookObj.validTo = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#validToDate',startView:'day', minView:'day'}" />
																</ul>
															</div>			
														</div>
													</div>
											</div> -->
											
												
											<div class="form-group ">
								<label class="col-md-5 control-label">Valid To<span
									style="color: red">*</span></label>
								<div class="col-md-3 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="manageChqBookObj.validTo"
										id="validFromDate" name="validFrom"
										data-ng-change="checkDatesCL(manageChqBookObj.validTo)"
										friendly-name="Valid To" validation="required" />
								</div>
								</div>
	         							</fieldset>
         							</div>
         							</div>
         							
        					<div class="form-actions">
         						<div class="row">
          							<div class="col-md-12">
							           <button class="btn btn-success" data-ng-if="!isEdit" type="button"
							            	ng-click="validate(manageChqBookAddForm,manageChqBookObj)">
							            	<i class="fa fa-save"></i>
Save							           </button>
           								<button class="btn btn-success" data-ng-if="isEdit==true" type="button"
            								ng-click="validate(manageChqBookAddForm,manageChqBookObj)">
            								<i class="fa fa-save"></i>
Cancel           								</button>
           								<button class="btn btn-info ng-scope" type="button" 
           									ng-click="reset(manageChqBookAddForm)" class="btn btn-success">
            								<i class="fa fa-undo"></i>
Reset           								</button>
           								<button class="btn btn-danger" type="button" class="btn btn-success" ng-click="cancel()">
            								<i class="fa fa-close"></i>
Cancel           								</button>
          							</div>
         					</div>
        				</div>
       				</form>
      			</div>
     		</div>
     		</div>
    	