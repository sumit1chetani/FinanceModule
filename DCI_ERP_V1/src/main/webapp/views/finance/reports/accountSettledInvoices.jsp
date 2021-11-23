<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<div class="breadcrumb-wrapper ng-scope">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">
					<form name="accountSettledInvoicesForm" class="form-horizontal">
						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-5">
								<fieldset>
									<div class="form-group">
										<label class="col-md-6 control-label"> Customer</label>
										<div class="col-md-6">
											<selectivity list="mloList"
												property="accountSettledInvoices.mloCode" id="mloCode"
												object="mloCode"> </selectivity>
										</div>
									</div>
									
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-6">From
											Date </label>
										<div class="col-md-6">
											<div class="input-group input-append date" id="tb_fromDate">
												<input type="text" class="form-control input-sm"
													placeholder="dd/mm/yyyy" ng-model="accountSettledInvoices.fromDate"
													name="fromDate" id="fromDate"> <span
													class="input-group-addon add-on"> <span
													class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-md-6 control-label"> Company <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-6">
											<selectivity list="companyList"
												property="accountSettledInvoices.companyCode" id="companyCode"
												object="companyCode"> </selectivity>
										</div>
									</div>
									
								</fieldset>
							</div>
							
								<div class="col-sm-12 col-md-12 col-lg-5">
								<fieldset>
							
									<div class="form-group">
										<label class="col-md-6 control-label"> Invoice </label>
										<div class="col-md-6">
											<selectivity list="invoiceList"
												property="accountSettledInvoices.invoice" id="invoice"
												object="invoice"> </selectivity>
										</div>
									</div>
									
									
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-6">To
											Date </label>
										<div class="col-md-6">
											<div class="input-group input-append date" id="tb_toDate">
												<input type="text" class="form-control input-sm"
													placeholder="dd/mm/yyyy" ng-model="accountSettledInvoices.toDate"
													name="toDate" id="toDate"> <span
													class="input-group-addon add-on"> <span
													class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>
										</div>
									</div>
							 
							 
							 		<div class="form-group">
										<label class="col-md-6 control-label"> Posted by </label>
										<div class="col-md-6">
											<selectivity list="userList"
												property="accountSettledInvoices.postedBy" id="postesBy"
												object="postesBy"> </selectivity>
										</div>
									</div>
									
									
								</fieldset>
							</div>
						</div>
						<a id="AccountSettledInvoicesExport" stype="display:none"
							href="filePath/AccountSettledInvoices.xlsx" download="AccountSettledInvoices.xlsx"></a>
						<!-- Form Action -->
						<div class="form-actions">
							<div class="row">
								<div class="col-md-12 ">
								 <security:authorize access="hasRole('${form_code}_${view}')">
									<button type="button"class="btn btn-success" type="button"
										ng-click="ViewaccountSettledInvoicesReport()">
										<i class="fa fa-search"></i>View Report
									</button>
								</security:authorize>
								 <security:authorize access="hasRole('${form_code}_${export}')">
									<button  type="button" class="btn btn-primary" ng-click="exportaccountSettledInvoicesExcel()">
										<i class="fa fa-search"></i>Export Excel
									</button>
								</security:authorize>
									<button  type="button" class="btn btn-info" type="reset"
										class="btn btn-success" ng-click="formreset()">
										<i class="fa fa-undo"></i>Reset
									</button>
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-xs-12">


								<div class="panel panel-default panel-default-list"
									st-table="displayedCollection" st-safe-src="rowCollection">
									<%--   <%@include file="/views/templates/panel-header.jsp"%> --%>
									<div class="col-md-4  p-l-0 p-r-0 pull-right">
										<input type="text" st-search=""
											class="form-control input-sm p-tb-14 bg-white rounded padder"
											placeholder="Search">
									</div>
									<div class="panel-body float-left padding-0" style="width:100%">
										<div class="table-responsive" style=" border: 1px solid #CCC;">
											<table
												class="table table-striped table-hover dataTable no-footer">
												<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
													<tr>
														<th class="sorting width_15" st-sort="mloCode">Customer</th>
														<th class="sorting width_8" st-sort="docNo">Transac No</th>
														<th class="sorting width_8" st-sort="docDate">Transac Dt</th>
														<th class="sorting width_8" st-sort="recNo">Receipt No</th>
														<th class="sorting width_8" st-sort="recDt">Receipt Dt</th>
														<th class="sorting width_8" st-sort="chqNo">Cheque No</th>
														<th class="sorting width_8" st-sort="chqDt">Cheque Dt</th>
														<th class="sorting width_8" st-sort="localAmt">TC Amount</th>
														<th class="sorting width_8" st-sort="usdAmt">BC Amount</th>
														<th class="sorting width_8" st-sort="usdAmt">Posted BY</th>
													</tr>
												</thead>
												<tbody class="dataTables-Main-Body">
													<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
														ng-repeat="accountSettledInvoices in displayedCollection"
														data-ng-click="CheckboxSelect({{$index}})">

														<td>{{accountSettledInvoices.mloCode}}</td>
														<td>{{accountSettledInvoices.docNo}}</td>
														<td>{{accountSettledInvoices.docDate}}</td>
														<td>{{accountSettledInvoices.recNo}}</td>
														<td>{{accountSettledInvoices.recDt}}</td>
														<td>{{accountSettledInvoices.chqNo}}</td>
														<td>{{accountSettledInvoices.chqDt}}</td>
														<td>{{accountSettledInvoices.localAmt}}</td>
														<td>{{accountSettledInvoices.usdAmt}}</td>
														<td>{{accountSettledInvoices.postedName}}</td>

													</tr>
												</tbody>
											</table>
										</div>
										<footer class="panel-footer panel-footer-list" style="padding:0px;">
											<%@include file="/views/templates/panel-footer.jsp"%>
										</footer>
									</div>
								</div>
							</div>
						</div>		
					</form>
				</div>
				<!-- /panel-body -->
			</div>
			<!-- /panel-default -->
		</div>
	</div>
</div>