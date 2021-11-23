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
					<div class="col-sm-12 col-md-12 col-lg-12">

						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> Code<span
									style="color: red;">*</span></label>
								<div class="col-md-3" ng-if="edit">

									<input type="text" class="form-control input-sm"  
										id="code" name="code" maxlength="2"
										ng-model="lease.code" validation="required"
										friendly-name=" Code"
										form-name="leaseForm" />
								</div>
								<div class="col-md-3" ng-if="!edit">

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
									<div class="col-md-3">
								<input type="text" class="form-control input-sm"
										id="description" name="description"  
										ng-model="lease.description" validation="required"
										friendly-name="Description"
										form-name="leaseForm" />
								</div>
							</div>
							
						
							
					
						</fieldset>

					</div>

				</div>
				<!-- /row -->
				<br>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-11">
							<button class="btn btn-success" ng-if="edit" type="button"
								ng-click="validate(leaseForm)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success"
								ng-click="validate(leaseForm)"
								ng-if="!edit" type="button">
								<i class="fa fa-save"></i> Update
							</button>

							<button class="btn btn-info" ng-if="edit" type="button"
								ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>
								<button class="btn btn-info" ng-if="!edit" type="button"
								ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>


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
