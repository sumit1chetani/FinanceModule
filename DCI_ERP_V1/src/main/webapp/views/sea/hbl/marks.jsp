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
									<div class="col-xs-12" >
									
									<textarea  type="text" class="form-control input-sm"
															data-ng-model="hbl1.marksAndNos" 
															class="custom-scroll width_250 resize-none" rows="30" 
															>
															</textarea>
															
										
									</div>
									
								</div>
								
											
											
					<!-- <table class="table table-striped table-hover dataTable no-footer">
						<thead class="dataTables-Main-Head">
						
							<tr>
                               
								<th>Remarks</th>
								
												
							</tr>
						</thead>
						<tbody  "class="dataTables-Main-Body" >
							<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'">
                           
								<td class="sorting ">{{joborder.tempremarks}}</td>
								 
								   <td><textarea  type="text" class="form-control input-sm" readonly style="width:285px" maxlength="200"
															name="remarks1{{trIndex1}}" id="remark1s{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3" 
															ng-model="joborder.tempremarks">
															</textarea></td>
								

							</tr>
						</tbody>
					</table> -->
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