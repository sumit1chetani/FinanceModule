<style>
.toggleBlock-currsor {
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
									<div class="col-md-8">{{mdaAccounting.supplierName}}</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5 bold">Month
										:</label>
									<div class="col-md-7">{{mdaAccounting.monthOfYear}}</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5 bold">Company
										:</label>
									<div class="col-md-7">{{companyName}}</div>
								</div>
							</div>

						</fieldset>
					</div>
				</div>

			</div>


			<div class="panel-heading bold toggleBlock-currsor"
				ng-click="toggleBlock('othercostdiv')">OTHER COST ITEM</div>

			<div class="table-responsive " id="othercostdiv">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
						<tr>
							<th colspan=1 class="width_1"></th>
							<th class="sorting width_20">Description</th>
							<th class="sorting width_10">Ex-Rate</th>
							<th class="sorting width_15">TC Amount</th>
							<th class="sorting width_15">BC Amount</th>
							<th class="sorting width_15">Account Head</th>
						</tr>
					</thead>
					<tbody ng-repeat="(trIndex, row) in mdaAccounting.lOtherCostList">
						<tr>
							<td><label class="i-checks m-b-none"> <input
									type="checkbox" ng-model="row.select"><i></i></label></td>
							<td class="sorting "><input type="text"
								class="form-control input-sm" ng-model="row.otherdescription"
								name="otherdescription"></td>
							<td class="sorting "><input type="text"
								class="form-control input-sm" ng-model="row.exchangeRate"
								name="otherExchangeRate" placeholder="0.0"
								ng-blur="otherExRateCalc(row);"></td>
							<td class="sorting "><input type="text"
								class="form-control input-sm" ng-model="row.otherTCAmount"
								name="otherTCAmount" placeholder="0.0"
								ng-blur="otherTCCalc(row);"></td>
							<td class="sorting "><input type="text"
								class="form-control input-sm" ng-model="row.otherBCAmount"
								name="otherBCAmount" placeholder="0.0"
								ng-blur="otherBCCalc(row);"></td>

							<td class="sorting "><selectivity list="accountList"
									property="row.accountHeadCode" id="accountHeadCode"
									object="account" ng-model="row.accountHeadCode"
									name="accountHeadCode"></selectivity></td>
						</tr>
					</tbody>
				</table>
				<div class="padding-right-5">
					<div class="col-md-4">
						<button ng-click="addOtherCostRow(mdaAccounting.lOtherCostList)"
							class="btn btn-sm btn-info" tooltip="Add Row" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button
							ng-click="removeOtherCostRow(mdaAccounting.lOtherCostList)"
							class="btn btn-sm btn-danger" type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>
				</div>
			</div>



			<div class="panel-heading bold toggleBlock-currsor"
				ng-click="toggleBlock('otherCredits')">OTHER CREDITS</div>
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer"
					id="otherCredits">
					<thead class="dataTables-Main-Head">
						<tr>
							<th colspan=1 class="width_1"></th>
							<th class="sorting width_20" st-sort="sailedDate">Description</th>
							<th class="sorting width_10">Ex-Rate</th>
							<th class="sorting width_15" st-sort="amountLocal">TC Amount</th>
							<th class="sorting width_15" st-sort="amountUsd">BC Amount</th>
							<th class="sorting width_15">Account Head</th>
						</tr>
					</thead>
					<tbody ng-repeat="(trIndex, row) in mdaAccounting.lOtherCreditlist">
						<tr>
							<td><label class="i-checks m-b-none"> <input
									type="checkbox" ng-model="row.select"><i></i></label></td>
							<td class="sorting "><input type="text"
								class="form-control input-sm"
								ng-model="row.otherCreditsDescrption"
								name="otherCreditsDescrption"></td>
							<td class="sorting "><input type="text"
								class="form-control input-sm" ng-model="row.exchangeRate"
								name="otherExchangeRate" placeholder="0.0"
								ng-blur="otherExRateCalc(row);"></td>
							<td class="sorting "><input type="text"
								class="form-control input-sm"
								ng-model="row.otherCreditsTCAmount" name="otherCreditsTCAmount"
								placeholder="0.0" ng-blur="ocTCCalc(row);"></td>
							<td class="sorting "><input type="text"
								class="form-control input-sm"
								ng-model="row.otherCreditsBCAmount" name="otherCreditsBCAmount"
								placeholder="0.0" ng-blur="ocBCCalc(row);"></td>
							<td class="sorting "><selectivity list="accountList"
									property="row.accountHeadCode" id="accountHeadCode"
									object="account" ng-model="row.accountHeadCode"
									name="accountHeadCode"></selectivity></td>
						</tr>
					</tbody>

				</table>
				<div class="padding-right-5">
					<div class="col-md-4">
						<button
							ng-click="addOtherCreditsRow(mdaAccounting.lOtherCreditlist)"
							class="btn btn-sm btn-info" tooltip="Add Row" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button
							ng-click="removeOtherCreditsRow(mdaAccounting.lOtherCreditlist)"
							class="btn btn-sm btn-danger" type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>
				</div>
			</div>





<div class="panel-heading bold toggleBlock-currsor"
				ng-click="toggleBlock('FREIGHT')">FREIGHT COLLECTION MADE</div>
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer"
					id="FREIGHT">
					<thead class="dataTables-Main-Head">
						<tr>
							<th class="sorting width_20" st-sort="">Description</th>
							<th class="sorting width_10">Ex-Rate</th>
							<th class="sorting width_15" st-sort="">TC Amount</th>
							<th class="sorting width_15" st-sort="">BC Amount</th>
							<th class="sorting width_15">Account Head</th>
						</tr>
					</thead>
					<tbody ng-repeat="(trIndex, row) in mdaAccounting.lAgentsCollectionMade">
						<tr>
							<td class="sorting "><input type="text"
								class="form-control input-sm"
								ng-model="row.agentCollectionDescrption"
								name="agentCollectionDescrption"></td>
							<td class="sorting ">{{row.agentTCCollectionAmount/row.agentBCCollectionAmount | number:2}}</td>
							<td class="sorting ">{{row.agentTCCollectionAmount}}</td>
							<td class="sorting ">{{row.agentBCCollectionAmount}}</td>
							<td class="sorting ">20010001 - TRADE CREDITORS</td>
						</tr>
					</tbody>

				</table>
			</div>








			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">
						<a id="MDAExport" style="display: none" href="filePath/MDA.xls"
							download="MDA.xls"></a> <span> <span>
								<button class="btn btn-danger " type="button"
									ng-click="cancel()">
									<i class="fa "></i>&nbsp; Cancel
								</button>
						</span>

							<button class="btn btn-success" ng-click="approve(mdaAccounting)">
								<i class="fa fa-approve"></i>Approve
							</button>
					</div>
				</div>
			</div>
			<!-- /panel-body -->
		</div>
	</div>
</div>
