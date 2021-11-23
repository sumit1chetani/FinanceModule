<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<style>
.panel-default-list .panel-body, .panel-default-form .panel-body {
	border: 0px #CEE3FC;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		

			<%@include file="/views/templates/panel-header.jsp"%>
			<input type="hidden" value="${form_code}" id="form_code_id">


		<div class="panel-body float-left padding-0">
			<div class="panel panel-default">
				<div class="form-body form-horizontal"><br>
					<div class="col-sm-12 col-md-12 col-lg-12">
					<br>
						<div class="row">
						<div class="col-sm-1">
						<div class="form-group">
						</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-md-5 control-label">Month</label>
								<div class="col-md-7">
									<selectivity list="finMonthList"
										property="reconciliation.month" id="vesselId"></selectivity>
								</div>
							</div>
							</div>
							<div class="col-sm-3">
							<div class="form-group hidden-group">
								<label class="col-md-5 control-label">Year</label>
								<div class="col-md-7">
									<selectivity list="yearList"
										property="reconciliation.year" id="voyageNo"></selectivity>
								</div>
							</div>
							</div>
							<div class="col-sm-3">
							<div class="form-group hidden-group">
								<label class="col-md-5 control-label">Agent</label>
								<div class="col-md-7">
									<selectivity list="agentList"
										property="reconciliation.agentCode" id="voyageNo"></selectivity>
								</div>
							</div>
							</div>
							</div>

					</div>
				</div>
				<div align="center">
					<div class="row panel-body">
						<div class="col-md-12 ">
							<security:authorize access="hasRole('${form_code}_${search}')">
								<button class="btn btn-success" type="button"
									data-ng-click="search();">
									<i class="fa fa-search"></i> Search
								</button>
								<!-- 		     <button class="btn btn-info" type="reset" class="btn btn-success" ng-click="formreset()">
						            <i class="fa fa-undo"> </i>Reset
					 </button>	 -->
							</security:authorize>
						</div>
					</div>
				</div>
			</div>
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
						<tr>
							
							<th class="sorting width_15" st-sort="billNo">Account Head</th>
							<th class="sorting width_15" st-sort="billDate">Voyage</th>
							<th class="sorting width_15" st-sort="vessel">Port</th>
							<th class="sorting width_15" st-sort="voyage">Ex.Rate</th>
							<th class="sorting width_15" st-sort="pol">TC Amt</th>
							<th class="sorting width_15" st-sort="pod">BC Amt</th>
							<th class="sorting width_15" st-sort="mloName">Approved Ex.Rate</th>
							<th class="sorting width_15" st-sort="loading">Approved TC Amt</th>
							<th class="sorting width_15" st-sort="loading">Approved BC Amt</th>
							<th class="sorting width_15" st-sort="loading">Remarks</th>
							<th>Action</th>
						</tr>
						<!-- <tr>
							<th></th>
							<th><input st-search="billNo" placeholder="Bill No"
								class="input-sm form-control" type="search" /></th>
							<th><input st-search="billDate" placeholder="Bill Date"
								class="input-sm form-control" type="search" /></th>
							<th><input st-search="vessel" placeholder="vessel"
								class="input-sm form-control" type="search" /></th>
							<th><input st-search="voyage" placeholder="voyage"
								class="input-sm form-control" type="search" /></th>
							<th><input st-search="pol" placeholder="pol"
								class="input-sm form-control" type="search" /></th>
							<th><input st-search="pod" placeholder="pod"
								class="input-sm form-control" type="search" /></th>
							<th><input st-search="mloName" placeholder="mloName"
								class="input-sm form-control" type="search" /></th>
							<th><input st-search="loading" placeholder="loading"
								class="input-sm form-control" type="search" /></th>
							<th></th>
						</tr> -->
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objTranslationItem in displayedCollection">
							<!--         <td><span>
       <a  class="text-u-l" data-ng-click="editRow(objTranslationItem.billNo)">{{objTranslationItem.billNo}}</a>
       </span>
       </td> -->

							
							<td>{{objTranslationItem.accountCode}}</td>
							<td>{{objTranslationItem.voyage}}</td>
							<td>{{objTranslationItem.port}}</td>
							<td>{{objTranslationItem.daExchangeRate}}</td>
							<td>{{objTranslationItem.daTCAmt}}</td>
							<td>{{objTranslationItem.daBCAmt}}</td>
							<td>{{objTranslationItem.vpaExchangeRate}}</td>
							<td>{{objTranslationItem.vpaTCAmt}}</td>
							<td>{{objTranslationItem.vpaBCAmt}}</td>
							<td>{{objTranslationItem.remarks}}</td>
							<td class=" td-actions text-center">
         <span>
          <i class="fa  fa-pencil text-success text" data-ng-click="edit(objTranslationItem)"></i>
         </span>
        </td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>