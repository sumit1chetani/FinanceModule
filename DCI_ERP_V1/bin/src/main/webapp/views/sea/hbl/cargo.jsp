 <style>
 .ngdialog-overlay{
 
 }
 .ngdialog{
    z-index: 1000;
 }
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
    width: 23%; 
    position: absolute;
    top: 7%;
    left: 38%;
    margin: 0 auto;
}
</style>


<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		
			
			<div class="form-body form-horizontal">
				<div class="row m-t-sm"></div>
			</div>
			<div class="panel-body float-left padding-0" style="width: 100%">
				<div class="table-responsive ">
				<!-- <div class="row">
				<input type="text" class="form-control input-sm" 
											data-ng-model="row.marksAndNos" name="MobileNo{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(MobileNo)'}}" /> 
											</div> -->
											<div class="row">
									<div class="col-xs-12">
									
									<textarea  type="text" class="form-control input-sm"
															data-ng-model="hbl2.cargoDescription"" 
															class="custom-scroll width_250 resize-none" rows="20" 
															>
															</textarea>
															
										
									</div>
								</div>
											
											
					
				</div>
				<div class="row">
			<div class="col-md-12" align="center">
				<button class="btn btn-success" ng-click="ok()" type="button"><i class="fa fa-save"></i>Update</button>
				<button class="btn btn-danger" ng-click="cancelng()" type="button"><i class="fa fa-close"></i>Cancel</button>
 			</div>
 		</div>
			
			<!-- /panel-body -->
		</div>
	</div>
</div>