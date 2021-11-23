<style>
.toggleBlock-currsor{
cursor: pointer;
}
</style>

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

							<div class="col-md-4">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5 bold">Month
										:</label>
									<div class="col-md-7">
										{{mdaAccounting.monthOfYear}}</div>
								</div>
							</div>
                            <div class="col-md-4">
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
											<td>{{mdaAccounting.exchangeRate}}</td>
											<td>{{mdaAccounting.remittancesOpenBal | number:2}}</td>
											<td>{{mdaAccounting.remittancesOpenBal/mdaAccounting.exchangeRate | number:2}}</td>
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
				
<!-- 				<div class="table-responsive " id="daDiv">
					<table class="table table-striped table-hover dataTable no-footer">
						<thead class="dataTables-Main-Head">
							<tr>
									<th class="sorting width_20" st-sort="voyageNo">Voyage</th>
								<th class="sorting width_15" st-sort="portCode">Port</th>
								<th class="sorting width_20" st-sort="sailedDate">Sailing Date</th>
								<th class="sorting width_20" >Description</th>
								<th class="sorting width_15" >TC Amount</th>
								<th class="sorting width_15" >BC Amount</th>
							</tr>
						</thead>
						<tbody class="dataTables-Main-Body">
							<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" >
										<td class="sorting ">{{ObjList.voyageNo}}</td>
								<td>{{ObjList.portCode}}</td>
								<td class="sorting ">{{ObjList.sailedDate}}</td>
								<td class="sorting ">{{ObjList.description}}</td>
								<td class="sorting ">{{ObjList.tcAmount}}</td>
								<td class="sorting ">{{ObjList.bcAmount}}</td>
							</tr>
						</tbody>
					</table>
				</div> -->
				
			
			<div class="panel-heading bold toggleBlock-currsor" ng-click="toggleBlock('othercostdiv')"> OTHER COST ITEM</div>
			
				<div class="table-responsive " id="othercostdiv">
					<table class="table table-striped table-hover dataTable no-footer">
						<thead class="dataTables-Main-Head">
							<tr>
								<th class="sorting width_20" >Description</th>
								<th class="sorting width_15" >TC Amount</th>
								<th class="sorting width_15" >BC Amount</th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in mdaAccounting.lOtherCostList" >
							<tr>
								<td class="sorting ">{{row.otherdescription}}</td>
								<td class="sorting ">{{row.otherTCAmount}}</td>
								<td class="sorting ">{{row.otherBCAmount}}</td>
							</tr>
						</tbody>
					</table>
				</div>
				
			
			<div class="panel-heading bold toggleBlock-currsor" ng-click="toggleBlock('remittanancePaid')"> REMITTANCES PAID</div>
			
				<div class="table-responsive ">
					<table class="table table-striped b-t b-light toggleBlock-currsor" id="remittanancePaid"  >
						<thead class="dataTables-Main-Head">
							<tr>
								<th class="sorting width_20" >Description</th>
								<th class="sorting width_15" >TC Amount</th>
								<th class="sorting width_15" >BC Amount</th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in mdaAccounting.lRemittancePaidList" >
							<tr>
								<td class="sorting ">{{row.remitPaiddescription}}</td>
								<td class="sorting ">{{row.remitPaidTCAmount}}</td>
								<td class="sorting ">{{row.remitPaidBCAmount}}</td>
							</tr>
						</tbody>
					</table>
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
			
				<div class="table-responsive ">
					<table class="table table-striped table-hover dataTable no-footer" id="remittananceReceived">
						<thead class="dataTables-Main-Head">
							<tr>
								<th class="sorting width_20" >Description</th>
								<th class="sorting width_15" >TC Amount</th>
								<th class="sorting width_15" >BC Amount</th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in mdaAccounting.lRemittanceReceivedList" >
							<tr>
								<td class="sorting ">{{row.remitReceiveddescription}}</td>
								<td class="sorting ">{{row.remitReceivedTCAmount}}</td>
								<td class="sorting ">{{row.remitReceivedBCAmount}}</td>
							</tr>
						</tbody>
					</table>
				</div>
				
			
			<div class="panel-heading bold toggleBlock-currsor" ng-click="toggleBlock('otherCredits')">OTHER CREDITS</div>
				<div class="table-responsive ">
					<table class="table table-striped table-hover dataTable no-footer" id="otherCredits">
						<thead class="dataTables-Main-Head">
							<tr>
								<th class="sorting width_20" st-sort="sailedDate">Description</th>
								<th class="sorting width_15" st-sort="amountLocal">TC Amount</th>
								<th class="sorting width_15" st-sort="amountUsd">BC Amount</th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in mdaAccounting.lOtherCreditlist" >
							<tr>
								<td class="sorting ">{{row.otherCreditsDescrption}}</td>
								<td class="sorting ">{{row.otherCreditsTCAmount}}</td>
								<td class="sorting ">{{row.otherCreditsBCAmount}}</td>
							</tr>
						</tbody>
						
					</table>
				</div>
				
			<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<a id="MDAExport" style="display:none"
						href="filePath/MDA.xls"
						download="MDA.xls"></a>
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
							
							<span>
								<button class="btn btn-success " type="button" ng-click="exportExcel()">
									<i class="fa fa-export"></i>&nbsp; Export Excel
								</button>
							</span>

						</div>
					</div>
				</div>
			<!-- /panel-body -->
		</div>
	</div>
</div>
