<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
			
			
			<!-- <ol class="breadcrumb inline-block padding-left-0">
				<li><a>Finance</a></li>
				<li><a x-ui-sref="app.master.controlscreen">Control Screen</a>
				</li>
				<li><a x-ui-sref="app.finance.controlscreen.subgroupaccount">Account
						Head</a></li>
				<li><a
					x-ui-sref="app.finance.controlscreen.locationForm">Add</a></li>
			</ol> -->
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="scheduleForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
<!-- 						<div class="col-sm-6 col-md-6 col-lg-6"> -->
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label"> Schedule<span
										style="color: red;"> *</span>
									</label>
									<div class="col-md-3">

										<selectivity list="scheduleList" id="type" name="type"
											property="scheduleList.id" ng-model="scheduleList.id"
											validation="required" friendly-name="Type" form-name = "scheduleForm"
											form-name="scheduleForm"></selectivity>

									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">From Time<span
										style="color: red;"> *</span></label>
									<div class="col-md-3 inputGroupContainer">


										       <div class="input-group input-append date">
          <input type="text" class="form-control input-sm" 
           id="from_time" name="toDate" 
           ng-model="schedule.from_time" validation="required" friendly-name="From Date"/> <span
           class="input-group-addon add-on"><span
           class="glyphicon glyphicon-time"></span></span>
         </div>

									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">To Time<span
										style="color: red;"> *</span></label>
									<div class="col-md-3 inputGroupContainer">


										       <div class="input-group input-append date">
          <input type="text" class="form-control input-sm" 
           id="to_time" name="To Time" 
           ng-model="schedule.to_time" validation="required" friendly-name="To Time"/> <span
           class="input-group-addon add-on"><span
           class="glyphicon glyphicon-time"></span></span>
         </div>
									</div>
								</div>
							





							</fieldset>
<!-- 						</div> -->
					
					</div>


				</div>
				<!-- /row -->
				<br>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit"
								ng-click="validate(schedule,scheduleForm)">
								<i class="fa fa-save"></i> Save
							</button>

							<button class="btn btn-success" ng-if="isEdit" type="submit" 
								ng-click="validate(schedule,scheduleForm)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="reset" ng-click="reset()" ng-if="!isEdit">
								<i class="fa fa-undo"></i> Reset
							</button>
							
							<button class="btn btn-info" ng-click="reset()" ng-if="isEdit">
								<i class="fa fa-undo"></i> Reset
							</button>

							<button class="btn btn-danger" ng-click="cancel()" type="button">
							<i class="fa fa-close"></i> Cancel</button>

						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

