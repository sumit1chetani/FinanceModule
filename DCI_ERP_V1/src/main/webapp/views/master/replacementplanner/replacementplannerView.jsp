<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
		
		<form name="addForm" class="form-horizontal" novalidate>
		<!-- 	<form  name="addForm" class="form-horizontal" 
				method="POST"> -->
				<div class="row">
					<div class="col-md-12">
					<div class="col-md-6">
				
							<fieldset>
							
							<div class="form-group">
							<label class="col-md-4 control-label"> Item 
							</label>
							<div class="col-md-5">
 		<selectivity list="itemList" property="replacement.itemName" id="itemName" disabled="true"></selectivity>
        </div>
						
						</div>
						
											<div class="form-group">
										<label class="col-md-4 control-label "> Warranty till
										</label>
										<label
									class="col-md-6 control-label" 
									style="text-align: left">{{replacement.warrenty}}</label>

									</div>
						
						
						<div class="form-group">
									<label class="col-md-4 control-label"> Replacement Value (USD)</label>
									<label
									class="col-md-6 control-label" 
									style="text-align: left">{{replacement.replacementValue}}</label>
								</div>
							
							</fieldset>
						</div>
					<div class="col-md-6">
							<fieldset>
							
								 <div class="form-group">
										<label class="col-md-4 control-label "> Approximate LifeTime
										</label>
										<label
									class="col-md-6 control-label" 
									style="text-align: left">{{replacement.lifetime}}</label>

									</div>
							
								
											 <div class="form-group">
										<label class="col-md-4 control-label "> Replacement Reminder
										</label>
										<label
									class="col-md-6 control-label" 
									style="text-align: left">{{replacement.remainder}}</label>

									</div>
									
								<div class="form-group" ng-if="!isCost" >
							<label class="col-md-4 control-label"> Alert Sent to  <span
								style="color: red;"></span>
							</label>
							<div class="col-md-5">
 		<selectivity list="deptList" property="replacement.dept" id="dept" disabled="true"></selectivity>
        </div>
							<!-- <label
									class="col-md-6 control-label" 
									style="text-align: left">{{replacement.dept}}</label> -->
						
						</div>
						
						<div class="form-group"    ng-if="isCost">
							<label class="col-md-4 control-label"> Alert Sent to  <span
								style="color: red;"></span>
							</label>
							<div class="col-md-5">
 		<selectivity list="deptList" property="replacement.dept" id="dept" disabled="true"></selectivity>
        </div>
							<!-- <label
									class="col-md-6 control-label" 
									style="text-align: left">{{replacement.dept}}</label> -->
						</div>
								
								
								
									



							</fieldset>
						</div>
					</div>


				</div>
				<!-- /row -->
				<br>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">							
							<button class="btn btn-danger" ng-click="cancel()" type="button">
							<i class="fa fa-close"> </i> Cancel</button>

						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

