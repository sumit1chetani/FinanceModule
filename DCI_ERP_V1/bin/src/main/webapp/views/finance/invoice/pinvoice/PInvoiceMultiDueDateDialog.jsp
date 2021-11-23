 <style>
 .ngdialog-overlay{
 
 }
 .ngdialog{
    z-index: 1000;
 }
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
    width: 85%; 
    position: absolute;
    top: 20%;
    left: 7%;
    margin: 0 auto;
}
</style>
<div class="wrapper-md">
	
<div class="panel-body float-left padding-0" st-table="displayedCollection" st-safe-src="rowCollection">
	<form name="purchaseInvoiceDueDateForm" class="form-horizontal" novalidate>	
		<div class="row">
	  		<div class="col-sm-12">
				<div class="table-responsive clear" ng-class="{view : isView}">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th colspan=1 class="width_1"></th>
									<th colspan=1  class="width_3 text-center">SI.No</th>
									<th colspan=1 class="width_40 text-center">Due Date</th>
									<th colspan=1 class="width_28 text-center">TC Amount<span style="color: red;">*</span></th>
									<th colspan=1 class="width_28 text-center">BC Amount({{companyCurrency}})<span style="color: red;">*</span></th>
								</tr>
							</thead>
							<tbody ng-repeat="(trIndex, row) in purchaseInvoiceData.purInvDueDateDtls">
								<tr>
									<td class="width_1"><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="row.select"><i></i></label></td>
									 <td class="width_2 text-center"><input type="text" class="b-none text-center" ng-model="row.slNo" /></td>
									 <td ng-hide="hide" class="width_35">
							           <div class="row">
								            <div class="col-xs-12">
								            		<div class="input-group input-append date" id="multiDueDates{{trIndex}}">
	                									<input type="text" class="form-control input-sm" name="Multi Due Date{{trIndex}}"
	                									placeholder="dd/mm/yyyy" id="txtMultiDueDate{{trIndex}}" ng-model="row.multiDueDate"
	                									friendly-name="{{ 'Row' + $index + '(Due Date)'}}" validation="required" />
	                									<span class="input-group-addon add-on">
	                        								<span class="glyphicon glyphicon-calendar"></span>
	                    								 </span>
			                     				    </div>							            	
								       		 </div>
							        	</div>
							      	</td> 						      	
									<td class="width_30">
										<div class="row">
											<div class="col-xs-12">
												<input type="text" class="form-control input-sm"
													id="amountUsd{{trIndex}}" ng-model="row.dueTcamount"
													name="tcamount{{trIndex}}" ng-keyup="TCtoBCamountCalcOnDialog(row.dueTcamount,trIndex,row)" 
													friendly-name="{{ 'Row' + $index + '(TC Amount)'}}" validation="required" />
											</div>
										</div>
									</td>
									<td class="width_30">
										<div class="row">
											<div class="col-xs-12">
												<input type="text" class="form-control input-sm" id="amount{{trIndex}}" ng-model="row.dueBcamount"
													name="bcamount{{trIndex}}" ng-keyup="BCtoTCamountCalcOnDialog(row.dueBcamount,trIndex,row)" 
													friendly-name="{{ 'Row' + $index + '(BC Amount)'}}" validation="required" />
											</div>
										</div>
									</td>
	
								</tr>
								
							</tbody>
						</table>
						<div class="padding-right-5 padding-bottom-5">
							<button ng-click="addMultiDueDateRow(purchaseInvoiceData.purInvDueDateDtls)"
								class="btn btn-sm btn-info" tooltip="Add Row" type="button" ng-hide="isView">
								<i class="fa fa-plus"></i>
							</button>
							<button ng-click="removeMultiDueDateRow(purchaseInvoiceData.purInvDueDateDtls)"
								class="btn btn-sm btn-danger" type="button" tooltip="Delete" ng-hide="isView">
								<i class="fa  fa-trash-o"></i>
							</button>
						</div>
						<!-- /addRow and /removeRow -->
						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
								<div class="form-group pull-right">
									
									<label class="col-md-3 control-label"> Total TC Amt</label>
									<div class="col-md-3">
										<input type="text" class="form-control input-sm"
											ng-model="totalTCAmount" readonly
											name="TC Total">
									</div>
									
									<label class="col-md-3 control-label"> Total BC Amt({{companyCurrency}})</label>
									<div class="col-md-3">
										<input type="text" class="form-control input-sm"
											ng-model="totalBCAmount" readonly
											name="BC Total">
									</div>
									
								</div>
							</div>
						</div>
					</div>		 
			</div>
		</div> <!-- /row -->
		<div class="row">
			<div class="col-md-12" align="center">
				<button class="btn btn-success" ng-click="submitMutiDueDateOption(purchaseInvoiceData.purInvDueDateDtls,purchaseInvoiceDueDateForm)" type="button">submit</button>
				<button class="btn btn-danger" ng-click="cancelng()" type="button">Cancel</button>
 			</div>
 		</div>
	</form>
	<div class="row"><br></div>
  </div>
  <footer class="panel-footer">
   </footer>
</div>