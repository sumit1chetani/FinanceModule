<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%--  <%@include file="/views/templates/panel-header.jsp"%>
   <input type="hidden" value="${form_code}" id="form_code_id" /> --%>
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row book-widget-row">

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-3 bold">Agent
										:</label>
									<div class="col-md-8">
										{{mdaAccounting.supplierName}}</div>
								</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5 bold">Month
										:</label>
									<div class="col-md-7">
										{{mdaAccounting.monthOfYear}}</div>
								</div>
							</div>
							
							<div class="col-md-2">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-7 bold">Currency
										:</label>
									<div class="col-md-5">
										{{currency}}</div>
								</div>
							</div>
                            <div class="col-md-3">
                             <div class="form-group">
                              <label for="inputPassword" class="control-label col-md-5 bold">Company
                               :</label>
                              <div class="col-md-7">
                               {{companyName}}</div>
                             </div>
                            </div>
                            
                            
                             <div class="col-md-12">
                             <div class="form-group"><br><br>
                             <label for="inputPassword" class="control-label col-md-5 bold">Opening Balance
                               :</label>
                             <table class="table table-striped table-hover dataTable no-footer">
								<thead class="dataTables-Main-Head">
									<tr>
										<th>Exchange Rate</td>
										<th>TC Amount</td>
										<th>BC Amount</td>
									</tr>
									<tbody class="dataTables-Main-Body">
										<tr>
											<td>{{exchangeRate}}</td>
											<td>{{remittancesOpenBal | number:2}}</td>
											<td>{{remittancesOpenBal/exchangeRate | number:2}}</td>
										</tr>
									</tbody>
								</thead>	
							</table>	
                              
                              <!-- <div class="col-md-7">
                               {{mdaAccounting.remittancesOpenBal}}</div> -->
                             </div>
                            </div>

						</fieldset>
					</div>
				</div>

			</div>

			<div class="panel-heading bold toggleBlock-currsor" ng-click="toggleBlock('daDiv')"> DA ACCOUNTING</div>
				<div class="table-responsive " id="daDiv">
					<table class="table table-striped table-hover dataTable no-footer">
						<thead class="dataTables-Main-Head">
							<tr>
								<th class="sorting width_20" st-sort="voyageNo">Voyage</th>
								<th class="sorting width_15" st-sort="portCode">Port</th>
								<th class="sorting width_20" st-sort="sailedDate">Sailing
									Date</th>
								<th class="sorting width_15" st-sort="amountLocal">TC
									Amount</th>
								<th class="sorting width_15" st-sort="amountUsd">BC Amount</th>
							</tr>
						</thead>
						<tbody class="dataTables-Main-Body">
							<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
								ng-repeat="ObjList in mdaAccounting.lMdaMonthlyList">
								<td class="sorting ">{{ObjList.voyageNo}}</td>
								<td>{{ObjList.portCode}}</td>
								<td class="sorting ">{{ObjList.sailedDate}}</td>
								<td class="sorting ">{{ObjList.tcAmount}}</td>
								<td class="sorting ">{{ObjList.bcAmount}}</td>
							</tr>
						</tbody>
					</table>
				</div>
				
			
			<div class="panel-heading bold toggleBlock-currsor" ng-click="toggleBlock('othercostdiv')"> OTHER COST ITEM</div>
			
				<div class="table-responsive " id="othercostdiv">
					<table class="table table-striped table-hover dataTable no-footer">
						<thead class="dataTables-Main-Head">
							<tr>
								<th colspan=1 class="width_1"></th>
								<th class="sorting width_20" >Description</th>
								<th class="sorting width_10" >Ex-Rate</th>
								<th class="sorting width_15" >TC Amount</th>
								<th class="sorting width_15" >BC Amount</th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in mdaAccounting.lOtherCostList" >
							<tr>
								<td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
								<td class="sorting ">
									<input type="text" class="form-control input-sm" ng-model="row.otherdescription" 
										name="otherdescription" >
								</td>
								<td class="sorting ">
									<input type="text" class="form-control input-sm" ng-model="row.exchangeRate" 
											name="otherExchangeRate" placeholder="0.0" ng-blur="otherExRateCalc(row);">
								</td>
								<td class="sorting ">
									<input type="text" class="form-control input-sm" ng-model="row.otherTCAmount" 
											name="otherTCAmount" placeholder="0.0" ng-blur="otherTCCalc(row);">
								</td>
								<td class="sorting "> 
									<input type="text" class="form-control input-sm" ng-model="row.otherBCAmount" 
											name="otherBCAmount" placeholder="0.0" ng-blur="otherBCCalc(row);">
								</td>
							</tr>
						</tbody>
					</table>
					<div class="padding-right-5">
			      		<div class="col-md-4">
			          		  <button ng-click="addOtherCostRow(mdaAccounting.lOtherCostList)" class="btn btn-sm btn-info" tooltip="Add Row" type="button">
					            <i class="fa fa-plus"></i>
					           </button>
					           <button ng-click="removeOtherCostRow(mdaAccounting.lOtherCostList)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
					            <i class="fa  fa-trash-o"></i>
					           </button>
			          	</div>
			        </div>
				</div>
				
			
			<div class="panel-heading bold toggleBlock-currsor" ng-click="toggleBlock('remittanancePaid')"> REMITTANCES PAID</div>
			
				<div class="table-responsive " id="remittanancePaid" >
					<table class="table table-striped b-t b-light toggleBlock-currsor"  >
						<thead class="dataTables-Main-Head">
							<tr>
								<th colspan=1 class="width_1"></th>
								<th class="sorting width_20" st-sort="sailedDate">Description</th>
								<th class="sorting width_10" >Ex-Rate</th>
								<th class="sorting width_15" st-sort="amountLocal">TC Amount</th>
								<th class="sorting width_15" st-sort="amountUsd">BC Amount</th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in mdaAccounting.lRemittancePaidList" >
							<tr>
								<td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
								<td class="sorting ">
									<input type="text" class="form-control input-sm" ng-model="row.remitPaiddescription" 
										name="remitPaiddescription" >
								</td>
								<td class="sorting ">
									<input type="text" class="form-control input-sm" ng-model="row.exchangeRate" 
											name="remitPaidExchangeRate" placeholder="0.0" ng-blur="remitPaidExRateCalc(row);">
								</td>
								<td class="sorting ">
									<input type="text" class="form-control input-sm" ng-model="row.remitPaidTCAmount" 
											name="remitPaidTCAmount" placeholder="0.0" ng-blur="remitPaidTCCalc(row);">
								</td>
								<td class="sorting "> 
									<input type="text" class="form-control input-sm" ng-model="row.remitPaidBCAmount" 
											name="remitPaidBCAmount" placeholder="0.0" ng-blur="remitPaidBCCalc(row);">
								</td>
							</tr>
						</tbody>
					</table>
					<div class="padding-right-5">
			      		<div class="col-md-4">
			          		  <button ng-click="addRemittancePaidRow(mdaAccounting.lRemittancePaidList)" class="btn btn-sm btn-info" tooltip="Add Row" type="button">
					            <i class="fa fa-plus"></i>
					           </button>
					           <button ng-click="removeRemittancePaidRow(mdaAccounting.lRemittancePaidList)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
					            <i class="fa  fa-trash-o"></i>
					           </button>
			          	</div>
			        </div>
				</div>
				
			</div>
			
			<div class="panel-heading bold toggleBlock-currsor" ng-click="toggleBlock('freightCostdiv')"> FREIGHT COLLECTION MADE</div>
				<div class="table-responsive ">
					<table class="table table-striped table-hover dataTable no-footer" id="freightCostdiv">
						<thead class="dataTables-Main-Head">
							<tr>
								<th class="sorting width_20" st-sort="sailedDate">Description</th>
								<th class="sorting width_15" st-sort="amountLocal">TC Amount</th>
								<th class="sorting width_15" st-sort="amountUsd">BC Amount</th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in mdaAccounting.lAgentsCollectionMade" >
							<tr>
								<td class="sorting ">{{row.agentCollectionDescrption}}</td>
								<td class="sorting ">{{row.agentTCCollectionAmount}}</td>
								<td class="sorting ">{{row.agentBCCollectionAmount}}</td>
							</tr>
						</tbody>
						
					</table>
				</div>
				
			
			<div class="panel-heading bold toggleBlock-currsor" ng-click="toggleBlock('remittananceReceived')"> REMITTANCES RECEIVED</div>
			
				<div class="table-responsive " id="remittananceReceived">
					<table class="table table-striped table-hover dataTable no-footer" >
						<thead class="dataTables-Main-Head">
							<tr>
								<th colspan=1 class="width_1"></th>
								<th class="sorting width_20" st-sort="sailedDate">Description</th>
								<th class="sorting width_10" >Ex-Rate</th>
								<th class="sorting width_15" st-sort="amountLocal">TC Amount</th>
								<th class="sorting width_15" st-sort="amountUsd">BC Amount</th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in mdaAccounting.lRemittanceReceivedList" >
							<tr>
								<td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
								<td class="sorting ">
									<input type="text" class="form-control input-sm" ng-model="row.remitReceiveddescription" 
										name="remitReceiveddescription" >
								</td>
								<td class="sorting ">
									<input type="text" class="form-control input-sm" ng-model="row.exchangeRate" 
											name="remitReceivedExchangeRate" placeholder="0.0" ng-blur="remitRecExRateCalc(row);">
								</td>
								<td class="sorting ">
									<input type="text" class="form-control input-sm" ng-model="row.remitReceivedTCAmount" 
											name="remitReceivedTCAmount" placeholder="0.0"  ng-blur="remitRecTCCalc(row);">
								</td>
								<td class="sorting "> 
									<input type="text" class="form-control input-sm" ng-model="row.remitReceivedBCAmount" 
											name="remitReceivedBCAmount" placeholder="0.0" ng-blur="remitRecBCCalc(row);">
								</td>
							</tr>
						</tbody>
					</table>
					<div class="padding-right-5">
			      		<div class="col-md-4">
			          		  <button ng-click="addRemittanceReceivedRow(mdaAccounting.lRemittanceReceivedList)" class="btn btn-sm btn-info" tooltip="Add Row" type="button">
					            <i class="fa fa-plus"></i>
					           </button>
					           <button ng-click="removeRemittanceReceivedRow(mdaAccounting.lRemittanceReceivedList)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
					            <i class="fa  fa-trash-o"></i>
					           </button>
			          	</div>
			        </div>
				</div>
				
			
			
			
			<div class="panel-heading bold toggleBlock-currsor" ng-click="toggleBlock('otherCredits')"> OTHER CREDITS</div>
				<div class="table-responsive " id="otherCredits">
					<table class="table table-striped table-hover dataTable no-footer" >
						<thead class="dataTables-Main-Head">
							<tr>
								<th colspan=1 class="width_1"></th>
								<th class="sorting width_20">Description</th>
								<th class="sorting width_10" >Ex-Rate</th>
								<th class="sorting width_15">TC Amount</th>
								<th class="sorting width_15">BC Amount</th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in mdaAccounting.lOtherCreditlist" >
							<tr>
								<td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
								<td class="sorting ">
									<input type="text" class="form-control input-sm" ng-model="row.otherCreditsDescrption" 
										name="otherCreditsdescription" >
								</td>
								<td class="sorting ">
									<input type="text" class="form-control input-sm" ng-model="row.exchangeRate" 
											name="otherCreditsExchangeRate" placeholder="0.0" ng-blur="ocExRateCalc(row);">
								</td>
								<td class="sorting ">
									<input type="text" class="form-control input-sm" ng-model="row.otherCreditsTCAmount" 
											name="otherCreditsTCAmount" placeholder="0.0" ng-blur="ocTCCalc(row);">
								</td>
								<td class="sorting "> 
									<input type="text" class="form-control input-sm" ng-model="row.otherCreditsBCAmount" 
											name="otherCreditsBCAmount" placeholder="0.0"  ng-blur="ocBCCalc(row);">
								</td>
							</tr>
						</tbody>
						
					</table>
					<div class="padding-right-5">
			      		<div class="col-md-4">
			          		  <button ng-click="addOtherCreditsRow(mdaAccounting.lOtherCreditlist)" class="btn btn-sm btn-info" tooltip="Add Row" type="button">
					            <i class="fa fa-plus"></i>
					           </button>
					           <button ng-click="removeOtherCreditsRow(mdaAccounting.lOtherCreditlist)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
					            <i class="fa  fa-trash-o"></i>
					           </button>
			          	</div>
			        </div>
				</div>
				
			
			<div class="form-actions">
					<div class="row">
						<div class="col-md-12">

							<span>
								<button class="btn btn-success " type="button" ng-click="saveMda()">
									<i class="fa fa-save"></i>&nbsp; Save
								</button>
							</span>
							<span>
								<button class="btn btn-danger " type="button" ng-click="back()">
									<i class="fa fa-arrow-left"></i>&nbsp; Back
								</button>
							</span>
                            <span>
                             <button class="btn btn-danger " type="button" ng-click="cancel()">
                              <i class="fa "></i>&nbsp; Cancel
                             </button>
                            </span>

						</div>
					</div>
				</div>
			<!-- /panel-body -->
		</div>
	</div>
</div>
