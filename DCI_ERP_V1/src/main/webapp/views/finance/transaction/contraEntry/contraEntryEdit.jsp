<div class="wrapper-md">
	<div class="panel panel-default">
		<div class="panel-heading font-bold"></div>
		<div class="form-body form-horizontal">
			<div class="row m-t-sm">
			
		<!-- 	<div class="col-sm-12 col-md-4 col-lg-4 ">
					<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text">ContraNo</label>
							
								<label class="col-md-7 control-label  vessel-text" ng-bind="contraNo"></label>
							
						</div>
					</fieldset>
				</div> -->
			<div class="col-sm-12 col-md-4 col-lg-4 ">
					<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text">Company</label>
							
								<label class="col-md-7 control-label  vessel-text" ng-bind="company"></label>
							
						</div>
					</fieldset>
				</div>
				<div class="col-sm-12 col-md-4 col-lg-4 ">
					<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text">Payer/Supplier</label>
				
					<!-- 			<div class="col-md-6">	
			<selectivity list="customerList"
									property="payerName" ng-model="payerName" ng-bind="payerName" object="payerName"
									></selectivity>
							</div> -->
										<label class="col-md-7 control-label  vessel-text" ng-bind="payerName"></label>
						</div>
					</fieldset>
				</div>
				
					<div class="col-sm-12 col-md-4 col-lg-4 ">
					<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text">Date</label>
							<div class="col-md-6">
									<ng-bs3-datepicker data-ng-model="contraDate"
											name="contraDate" 
											
											friendly-name="Contra Date" />
							</div>
						</div>
					</fieldset>
				</div>
			</div>
		</div>
	</div>
	
	 <div class="panel-body float-left padding-0" st-table="displayedCollection" st-safe-src="rowCollection">
   <div class="table-responsive" >
  
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">     	
      <tr role="row">
       <th class="width_1"></th>
       <th class="sorting width_9" st-sort="transno">Invoice No</th>
       <th class="sorting width_14" st-sort="bookcheque">Invoice Amt</th>
<!--        <th class="sorting width_9" st-sort="chequedt">Currency</th>
       <th class="sorting width_9" st-sort="chequedt">Ex-Rate</th> -->
<!--        <th class="sorting width_9" st-sort="tcAmount">Balance Amt</th>
 -->       <th class="sorting width_9" st-sort="tcAmount">Set Off TC Amt</th>
       <th class="sorting width_9" st-sort="bcAmount">Set off BC Amt</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(trIndex, objTranslationItem) in displayedCollection">
       <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="objTranslationItem.select" id="select{{trIndex}}" ng-change="calculateTotalAmountForIA()"><i></i></label></td>
       <td>
         <span tooltip="{{objTranslationItem.invoiceNo}}" class="tool-tip-span" ng-bind="objTranslationItem.invoiceNo"></span>
       </td>
        <td>
        <span tooltip="{{objTranslationItem.invoiceAmount}}" class="tool-tip-span" ng-bind="objTranslationItem.invoiceAmount"></span>
       </td>
     <!--   <td>
        <span tooltip="{{objTranslationItem.currencyCode}}" class="tool-tip-span" ng-bind="objTranslationItem.currencyCode"></span>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.exchangeRate}}" class="tool-tip-span" ng-bind="objTranslationItem.exchangeRate"></span>
       </td> -->
      <!--  <td>
        <span tooltip="{{objTranslationItem.receivedAmount}}" class="tool-tip-span" ng-bind="objTranslationItem.receivedAmount"></span>
       </td> -->
    <!--    <td>
        <span tooltip="{{objTranslationItem.tcAmount}}" class="tool-tip-span" ng-bind="objTranslationItem.tcAmount"></span>
       </td> -->
       <td>
        <input type="text" class="form-control input-sm input-remarks text-right" name="tcAmount{{trIndex}}" id="tcAmount{{trIndex}}"   ng-model="objTranslationItem.tcAmount"  />
       </td>
       <td>
        <input type="text" class="form-control input-sm input-remarks text-right" name="bcAmount{{trIndex}}" id="bcAmount{{trIndex}}"   ng-model="objTranslationItem.bcAmount"  />
       </td>
      </tr>
     </tbody>
    </table>
   </div>
  
  <!-- 	<div class="row"><br></div>
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12"  >
				<div class="form-group pull-right"  ng-if="payerCode === '10080003'">
					<label class="col-md-6 control-label">Disputed
						revenue(Customer)</label>
					<div class="col-md-6">
						<input type="text" data-ng-model="payerDisputedRevenue"
							class="form-control input-sm "
							ng-keyup="calculateTotalAmountForIA();"></input>
					</div>

				</div>
			</div>
		</div> -->
<div class="row"><br></div>
		<div class="row">
	
				<div class="col-sm-12 col-md-12 col-lg-12"   >
				<div class="form-group pull-right"  ng-if="payerCode === '10080003' ">
					<label class="col-md-6 control-label">Disputed
						revenue(Customer)</label>
					<div class="col-md-6">
						<input type="text" ng-model="payerDisputedRevenue" property="payerDisputedRevenue"
							value="payerDisputedRevenue" class="form-control input-sm "
						readonly 	ng-keyup="calculateTotalAmountForIA();"></input>
					</div>

				</div>
			</div>
				
			<div class="col-sm-12 col-md-12 col-lg-12" >
				<div class="form-group pull-right" ng-if="payerCode === '20010002'">
					<label class="col-md-6 control-label">CREDIT BALANCES WRITTEN OFF</label>
					<div class="col-md-6">
						<input type="text" ng-model="payerDisputedRevenue" id="payerDisputedRevenue"
							class="form-control input-sm "  property="payerDisputedRevenue" value="payerDisputedRevenue"
							readonly ng-keyup="calculateTotalAmountForIA();"></input>
					</div>

				</div>
			</div>   
		</div> 
	<div class="row"><br></div>
    <div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="form-group pull-right">
								
								<!-- <label class="col-md-3 control-label"> Total TC Amt</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm"
										ng-model="totalTCAmount" readonly
										name="TC Total">
								</div> -->
								
								<label class="col-md-6 control-label"> Total BC Amt</label>
								<div class="col-md-6">
									<input type="text" class="form-control input-sm"
										ng-model="totalBCAmount" readonly
										name="BC Total">
								</div>
								
							</div>
						</div>
	</div>
   <div class="form-actions">
			<div class="row">
				<div class="col-md-12">
   					<button class="btn btn-success" ng-click="update(displayedCollection)" type="button">Update</button>
   				
   					<button class="btn btn-danger" ng-click="cancel()" type="button">Cancel</button>
   				</div>
   			</div>
   	</div>
  </div>
</div>