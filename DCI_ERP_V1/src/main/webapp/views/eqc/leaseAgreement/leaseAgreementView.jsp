<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="leaseForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">

						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> Code<span
									style="color: red;">*</span></label>
								<div class="col-md-5" ng-if="edit">

									<input type="text" class="form-control input-sm"  
										id="code" name="code" maxlength="2"
										ng-model="lease.code" validation="required"
										friendly-name=" Code"
										form-name="leaseForm" ng-disabled="true"/>
								</div>
								<div class="col-md-5" ng-if="!edit">

									<input type="text" class="form-control input-sm"  
										id="code" name="code" maxlength="2"
										ng-model="lease.code" validation="required"
										friendly-name="Code"
										form-name="leaseForm" disabled/>
								</div>
							</div>
			
							 
						<div class="form-group">
								<label class="col-md-4 control-label">Description<span
									style="color: red;">*</span></label>
									<div class="col-md-5">
								<input type="text" class="form-control input-sm"
										id="description" name="description"  
										ng-model="lease.description" validation="required"
										friendly-name="Description"
										form-name="leaseForm" ng-disabled="true"/>
								</div>
							</div>
							
						<div class="form-group">
								<label class="col-md-4 control-label">Created By</label>
									<div class="col-md-5">
								<input type="text" class="form-control input-sm"
										id="created_by" name="created_by"  
										ng-model="lease.created_by" validation="required"
										friendly-name="Created_by"
										form-name="leaseForm" ng-disabled="true"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label">Created Date</label>
									<div class="col-md-5">
								<input type="text" class="form-control input-sm"
										id="created_date" name="created_date"  
										ng-model="lease.created_date" validation="required"
										friendly-name="Created_date"
										form-name="leaseForm" ng-disabled="true"/>
								</div>
							</div>
							
					
						</fieldset>

					</div>
<div class="col-sm-12 col-md-12 col-lg-6">

						<fieldset>

<div class="form-group">
								<label class="col-md-4 control-label">Modified By</label>
									<div class="col-md-5">
								<input type="text" class="form-control input-sm"
										id="modified_by" name="modified_by"  
										ng-model="lease.modified_by" validation="required"
										friendly-name="Modified_by"
										form-name="leaseForm" ng-disabled="true"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label">Modified Date</label>
									<div class="col-md-5">
								<input type="text" class="form-control input-sm"
										id="modified_date" name="modified_date"  
										ng-model="lease.modified_date" validation="required"
										friendly-name="Modified_date"
										form-name="leaseForm" ng-disabled="true"/>
								</div>
							</div>

</fieldset></div>
				</div>
				<!-- /row -->
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
