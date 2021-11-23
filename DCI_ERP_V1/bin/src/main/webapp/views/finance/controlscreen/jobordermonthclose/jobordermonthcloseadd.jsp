<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="accountingyearcloseForm"
				ng-submit="save(accountingyearcloseForm)"
				novalidate>
				
				
				
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6 col-lg-offset-3">
						<fieldset>


							<div class="form-group">
								<label class="col-md-4 control-label">From Date<span style="color: red;">*</span></label>
								<div class="col-md-6 inputGroupContainer">


									<div class="input-group input-append date">
										<input type="text" class="form-control input-sm" 
											id="previousClosedYear" name="previousClosedYear" 
											ng-model="accountingYearClose.fromdate" validation="required" friendly-name="From Date"/> <span
											class="input-group-addon add-on"><span
											class="glyphicon glyphicon-calendar"></span></span>
									</div>

								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">To Date<span style="color: red;">*</span></label>
								<div class="col-md-6 inputGroupContainer">

									<div class="input-group input-append date">
										<input type="text" class="form-control input-sm" 
											id="yearToBeClosed" name="yearToBeClosed" 
											ng-model="accountingYearClose.todate" validation="required" friendly-name="To Date"/> <span
											class="input-group-addon add-on"><span
											class="glyphicon glyphicon-calendar"></span></span>
									</div>
<!-- 
									<div class="input-group input-append date">
										<input type="text" class="form-control input-sm" 
											id="yearToBeClosed" ng-model="accountingYearClose.todate"  validation="required" friendly-name="To Date"/> <span
											class="input-group-addon add-on"><span
											class="glyphicon glyphicon-calendar"></span></span>
									</div> -->

								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label"> Location <span style="color: red;">*</span></label>
								<div class="col-md-6 inputGroupContainer">
									<selectivity list="companyList" ng-model="accountingYearClose.location" name="location" form-name="accountingyearcloseForm"
										property="accountingYearClose.location" id="location" validation="required" friendly-name="Location"></selectivity>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Mode <span style="color: red;">*</span></label>
								<div class="col-md-6 inputGroupContainer">
									<selectivity list="modeList" ng-model="accountingYearClose.modeType" name="location" form-name="accountingyearcloseForm"
										property="accountingYearClose.modeType" id="Mode" validation="required" friendly-name="Mode"></selectivity>
								</div>
							</div>

						</fieldset>
					</div>
				</div>


				<div class="form-actions"style="margin-top: 76px;">
					<div class="row">
						<div class="col-md-12">
						 
							<button class="btn btn-success" type="button" ng-if="!isEdit" ng-click="save()">
								<i class="fa fa-save"></i> Save
							</button>
						  
						  <button class="btn btn-success"
								ng-click="update()"
								ng-if="isEdit" type="button">
								<i class="fa fa-save"></i> Update
							</button>
							
							<button class="btn btn-info" type="button" ng-if="!isEdit" ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-danger" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
