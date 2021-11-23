<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="pettyCashAddForm" role="form"
				novalidate method="post">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6 col-lg-offset-3">
						<fieldset>


							<div class="form-group">
								<label class="col-md-4 control-label"> Transfer To <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">

									<selectivity list="employeeList"
										property="pettyCashTransfer.employeeId" 
										ng-model="pettyCashTransfer.employeeId" name="Transfer To"
										form-name="pettyCashAddForm" validation="required"
										friendly-name="Transfer To"></selectivity>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"
								> Transfer Date <span
									style="color: red;">*</span></label>


								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="pettyCashTransfer.transferDate"
										 name="TransferDate"  form-name="pettyCashAddForm" validation="required" friendly-name="
										TransferDate"
										 />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Amount <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="text-left form-control input-sm"
										ng-model="pettyCashTransfer.amount" name="Amount" validation="required"
										friendly-name="Amount" >
								</div>
							</div>



					</fieldset>
				</div>
		</div>
		<div class="form-actions">
			<div class="row">
				<div class="col-md-12">
					<button class="btn btn-success"
						ng-if="!isEdit" type="button"
						ng-click="save(pettyCashAddForm,pettyCashTransfer)">
						<i class="fa fa-save"></i> Save
					</button>
					<button class="btn btn-success"
						ng-if="isEdit" type="button"
						ng-click="update(pettyCashAddForm,pettyCashTransfer)">
						<i class="fa fa-save"></i> Update
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

