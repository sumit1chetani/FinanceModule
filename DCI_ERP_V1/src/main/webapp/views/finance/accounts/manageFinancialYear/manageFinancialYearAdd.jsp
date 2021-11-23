<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="financialYear" ng-submit="return false">
				<div class="row">

					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-md-6">
							<fieldset>
								<%-- <div class="form-group" data-ng-if="isEdit">
										<label class="col-md-4 control-label">Financial Year Id <spring:message
												code="label.asterisk.symbol"></spring:message></label>
										<div class="col-md-6">
											<input type="text" class="form-control input-sm"
											id="txtfyId" name="fyId" placeholder=""
											ng-model="finYear.fyId" readonly>
										</div>
								</div> --%>
								<div class="form-group">
									<label class="col-md-4 control-label">	Organization Name <span style="color:red" >*</span>	</label>
									<div class="col-md-6">
										<selectivity list="companyList" property="finYear.companyCode" id="companyName"
										ng-model="finYear.companyCode" name="organizationName" form-name = "financialYear"
	        							validation="required" friendly-name="companyName" ></selectivity>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Financial Year </label>
									<div class="col-md-6">
										<input type="text" class="form-control input-sm"
											id="txtfyShortId" name="fyShortId" placeholder="2015-16" maxlength="7"
											ng-model="finYear.fyId" validation="required" friendly-name="Financial Year"
											ng-blur="ValidateYear();">
									</div>
								</div>
								<div class="form-group">
								<label class="col-md-4 control-label">Active</label>
											 <div class="col-md-6">
             <div class="checkbox">
              <label> <input type="checkbox"
               class="checkbox style-0" name="active"
               ng-model="finYear.active" validation="required" friendly-name="Active" name="financialYear"
               > <span></span>
              </label>
             </div>
            </div>
								</div>

						</fieldset>
					</div>

					<div class="col-md-6">
						<fieldset>
						
						
						 <!-- <div class="form-group">
				            <label class="col-md-4 control-label">Start Date </label>
				            <div class="col-md-6">
					             <div class='input-group date datetimepick'>
						            <div class="dropdown">
							             <a class="dropdown-toggle" id="txtStartDate" role="button"
							              data-toggle="dropdown" data-target="#" href="#">
								              <div class="input-group">
								               <input type="text" class="form-control"
								                placeholder="dd/mm/yyyy" name="fyFrom"
								                data-validator="required" data-valid-method="submit"
								                data-message-id="fyFrom"
								                data-ng-model="finYear.fyFrom"><span
								                class="input-group-addon"><i
								                class="glyphicon glyphicon-calendar"></i></span>
								              </div>
							             </a>
							             <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
								              <datetimepicker data-ng-model="finYear.fyFrom"
								               data-on-set-time="finYear.fyFrom = onDateSet(newDate)"
								               data-datetimepicker-config="{ dropdownSelector: '#txtStartDate',startView:'day', minView:'day'}" />
							             </ul>
						            </div>
					           </div> 
				            </div>
				           </div> -->
							<div class="form-group ">
								<label class="col-md-4 control-label">Start Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="finYear.fyFrom"
										id="fyFrom" name="realisedDate"
										data-ng-change="checkDatesCL(finYear.fyFrom)"
										friendly-name="Start Date" validation="required" />
								</div>
								</div>
						

						<!-- <div class="form-group">
							<label class="col-md-4 control-label">End Date </label>
							<div class="col-md-7">
								<div class='input-group date datetimepick'>
									<div class="dropdown">
										<a class="dropdown-toggle" id="txtEndDate" role="button"
											data-toggle="dropdown" data-target="#" href="#">
											<div class="input-group">
												<input type="text" class="form-control"
													placeholder="dd/mm/yyyy" name="endDate"
													data-ng-model="finYear.fyTo"
													validation="required" friendly-name="End Date" ><span
													class="input-group-addon"><i
													class="glyphicon glyphicon-calendar"></i></span>
											</div>
										</a>
										<ul class="dropdown-menu" role="menu"
											aria-labelledby="dLabel">
											<datetimepicker
												data-ng-model="finYear.fyTo"
												data-on-set-time="finYear.fyTo = onDateSet(newDate)"
												data-datetimepicker-config="{ dropdownSelector: '#txtEndDate',startView:'day', minView:'day'}" />
										</ul>
									</div>
								</div>
							</div>
						</div> -->
						<div class="form-group ">
								<label class="col-md-4 control-label">End Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="finYear.fyTo"
										id="txtEndDate" name="realisedDate"
										data-ng-change="checkDatesCL(finYear.fyTo)"
										friendly-name="Start Date" validation="required" />
								</div>
								</div>
						
				</fieldset>
			</div>
		</div>
		</div>
		<div class="form-actions">
			<div class="row">
				<div class="col-md-12">
					<button class="btn btn-success" type="button" ng-if="!isEdit"
						ng-click="onSubmit(financialYear,finYear)">
						<i class="fa fa-save"></i> Save
					</button>
					<button class="btn btn-success" type="button" ng-if="isEdit"
						ng-click="onSubmit(financialYear,finYear)">
						<i class="fa fa-save"></i> Update
					</button>
					<button class="btn btn-danger" ng-click="cancel()" type="button">
						<i class="fa fa-close"></i> Cancel
					</button>
				</div>
			</div>
		</div>
				<!-- sub table Ends -->
		</form>
	</div>
</div>
				<!-- end widget div -->
</article>
<!-- WIDGET END -->
		</div>
	</section>
</div>
