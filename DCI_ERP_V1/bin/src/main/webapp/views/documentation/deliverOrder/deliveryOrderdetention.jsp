
<style>
.ngdialog-overlay {
	
}

.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 75%;
	position: absolute;
	top: 20%;
	left: 7%;
	margin: 0 auto;
}

.bootstrap-datetimepicker-widget {
	z-index: 10000 !important;
}
</style>
<div class="wrapper-md">
	<div class="panel-body float-left padding-0">
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12 ">
				<fieldset>
					<legend>Detention Invoice</legend>
					
					
					<div class="form-group" >
						<label class="col-md-2 control-label line-height-30">Invoice  Date<span style="color: red;"> *</span>
						</label>
						<div class="col-md-3">

							<ng-bs3-datepicker data-ng-model="deliveryorder.invoiceDate" />

						</div>
					</div>
					
					
					<div class="form-group" >
						<label class="col-md-2 control-label line-height-30">Customer Tax No
						</label>
						<div class="col-md-3">
						
						<input type="text" class="form-control input-sm text-right"
											ng-model="deliveryorder.custtax" 
											name=" custtax" id="custtax"
											friendly-name="custaxnum"   />

						

						</div>
					</div>
					
					
					
			</div>

		</div>
	</div>
	<div class="row">
		<div class="col-sm-12 col-md-12 col-lg-12">
			<div class="form-actions m-b-none">
				<button class="btn btn-info" type="button"
					ng-click="detention()">OK</button>
				<button class="btn btn-danger" ng-click="cancelDoPop()">Cancel</button>
			</div>
		</div>
	</div>
</div>
</div>