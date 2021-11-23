<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<security:authentication var="user" property="principal" />
<head>
<style>
.main_head {
	background-color: #7E7EB8 !important;
	color: white;
	padding: 10px 15px;
	border-bottom: 1px solid transparent;
	border-radius: 2px 2px 0 0;
}

.data-table {
	margin-bottom: 7px !important;
}
</style>


</head>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<div class="panel panel-default panel-default-form">
			<%@include file="/views/templates/panel-header-form.jsp"%>
			<input type="hidden" value="${form_code}" id="form_code_id">
			<div class="panel-body">
				<form class="form-horizontal" name="profitLossSearchForm">
					<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<!-- <div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label class="col-md-5 control-label"> Company
										<span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="companyList" property="pl.company" id="company" object="companyCode"></selectivity>
									</div>
								</div>
							</fieldset>
						</div> -->
							<div class="col-sm-12 col-md-3 col-lg-3">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Company <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity list="companyList" ng-model="icar.company"
												property="icar.company" id="company" object="company"
												name="company"></selectivity>

										</div>
									</div>
								</fieldset>
							</div>


							<div class="col-sm-12 col-md-3 col-lg-3">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Intra-Company
											Accounts <span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity list="intraCompanyList"
												ng-model="icar.intraCompany" property="icar.intraCompany"
												id="intraCompany" object="intraCompany" name="v"></selectivity>

										</div>
									</div>
								</fieldset>
							</div>

							<div class="col-sm-4 col-md-3 col-lg-3">
								<input type="hidden" id="companyCode"
									value="${user.companyCode}">
								<fieldset>
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">From
											Date </label>
										<div class="col-md-7">
											<div class="input-group input-append date" id="icar_fromDate">
												<input type="text" class="form-control input-sm"
													placeholder="dd/mm/yyyy" ng-model="icar.fromDate"
													name="fromDate" id="fromDate"> <span
													class="input-group-addon add-on"> <span
													class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>
										</div>
									</div>
								</fieldset>
							</div>
							<div class="col-sm-4 col-md-3 col-lg-3">
								<fieldset>
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">To
											Date </label>
										<div class="col-md-7">
											<div class="input-group input-append date" id="icar_toDate">
												<input type="text" class="form-control input-sm"
													placeholder="dd/mm/yyyy" ng-model="icar.toDate"
													name="toDate" id="toDate"> <span
													class="input-group-addon add-on"> <span
													class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>
										</div>
									</div>
								</fieldset>
							</div>
						</div>
					</div>
					<a id="PLExport" stype="display:none"
						href="filePath/ProfitAndLoss.xls" download="ProfitAndLoss.xls"></a>
					<div class="form-actions">
						<div class="row">
							<div class="col-md-12 ">

								<%-- <security:authorize access="hasRole('${form_code}_${view}')">
								<button class="btn btn-success"
									ng-click="viewProfitLossNewhor(pl.company)">
									<i class="fa fa-search"></i>View Horizontal Report
								</button>
							</security:authorize> --%>

								<security:authorize access="hasRole('${form_code}_${view}')">
									<button class="btn btn-success" ng-click="getList()">
										<i class="fa fa-search"></i>View Report
									</button>
								</security:authorize>

								<button class="btn btn-primary" type="button"
									data-ng-click="viewRecords();">View Reconcile Records</button>


								<button class="btn btn-info" type="reset"
									class="btn btn-success" tooltip="Reset" ng-click="reset()">
									<i class="fa fa-undo"></i> Reset
								</button>
								<security:authorize access="hasRole('${form_code}_${export}')">
									<button class="btn btn-primary" ng-click="exportPLExcelVer()">
										<i class="fa fa-search"></i>Export Horizontal Excel
									</button>
								</security:authorize>

								<security:authorize access="hasRole('${form_code}_${export}')">
									<button class="btn btn-primary" ng-click="exportPLExcel()">
										<i class="fa fa-search"></i>Export Vertical Excel
									</button>
								</security:authorize>




							</div>
						</div>
					</div>

					<div
						class="main_head  bold toggleBlock-currsor text-center fontSize16 ">
						Intra Company Accounts-Records</div>

					<br> <br>

					<div class="col-sm-12 col-md-12 col-lg-12"
						style="padding-top: 24px;">





						<div class="table-responsive ">
							<table
								class="table table-striped table-hover dataTable no-footer">
								<thead class="dataTables-Main-Head">
								<thead>
									<tr>

										<th class="width_1 text-center"><label
											class="i-checks m-b-none"> <input type="checkbox"
												name="post[]" ng-model="selectAllCheckBox"
												ng-click="selectAll(selectAllCheckBox) "> <i></i>
										</label></th>

										<th align="center" class="sorting" st-sort="transactionNo">Transaction
											No.</th>
										<th align="center" class="sorting" st-sort="refNo">ReferenceNo.</th>


										<th align="center" class="sorting" st-sort="transactionDate">Transaction
											Date</th>

										<th align="center" class="sorting" st-sort="subAccountName">Sub
											Account</th>
										<th align="center" class="sorting" st-sort="narration">Description</th>

										<th align="center" class="sorting" st-sort="creditAmount">Credit
											Amount</th>

										<th align="center" class="sorting" st-sort="debitAmount">Debit
											Amount</th>

										<!-- 							<th class="sorting width_30" st-sort="vessel">Consolidate In</th>
 -->
										<!--  <th class="text-center">Action</th> -->
									</tr>
								</thead>
								<tbody class="dataTables-Main-Body">
									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
										ng-repeat="(trIndex,estimate) in displayedCollection">







										<!-- 
										<td class="width_1 text-center"
											ng-if="estimate.transactionNo=='Total'"><label
											class="i-checks m-b-none"> <i></i>
										</label></td> -->

										<td class="width_1 text-center"
											ng-if="estimate.transactionNo!='Total'"><label
											class="i-checks m-b-none"> <input type="checkbox"
												name="selectedTypes[]" ng-model="estimate.check"> <i></i>
										</label></td>






										<!-- 	<td><span ng-if="objTranslationItem.urIsView=='t'"><a
												ng-click="view(objTranslationItem.jvNumber)"> <span
													tooltip="{{objTranslationItem.jvNumber}}"
													class="tool-tip-span font-blue">{{objTranslationItem.jvNumber}}</span>
											</a></span> <span ng-if="objTranslationItem.urIsView=='f'"> <span
												tooltip="{{objTranslationItem.jvNumber}}"
												class="tool-tip-span">{{objTranslationItem.jvNumber}}</span>
										</span></td> -->

										<!-- <td align="center" ng-if="estimate.transactionNo=='Total'"
											class="sorting" style="background-color: #7E7EB8;"><a
											ng-click="view(estimate.transactionNo)"> <span
												tooltip="{{estimate.transactionNo}}"
												class="tool-tip-span font-blue"> <span
													style="color: white"> <b>
															{{estimate.transactionNo}}</b></span>


											</span>
										</a></td> -->

										<td align="center" ng-if="estimate.transactionNo!='Total'"
											class="sorting"><a
											ng-click="view(estimate.transactionNo)"> <span
												tooltip="{{estimate.transactionNo}}"
												class="tool-tip-span font-blue">
													{{estimate.transactionNo}}</span>
										</a></td>





										<!-- 
										<td align="center" ng-if="estimate.transactionNo=='Total'"
											style="background-color: #7E7EB8;" class="sorting"><span
											style="color: white"></span></td> -->
										<td align="center" ng-if="estimate.transactionNo!='Total'"
											class="sorting">{{estimate.refNo}}</td>


										<!-- 
										<td align="center" ng-if="estimate.transactionNo=='Total'"
											style="background-color: #7E7EB8;" class="sorting"><span
											style="color: white"></span></td> -->
										<td align="center" ng-if="estimate.transactionNo!='Total'"
											class="sorting">{{estimate.transactionDate}}</td>


										<!-- <td align="center" ng-if="estimate.transactionNo=='Total'"
											style="background-color: #7E7EB8;" class="sorting"><span
											style="color: white"></span></td> -->
										<td align="center" ng-if="estimate.transactionNo!='Total'"
											class="sorting">{{estimate.subAccountName}}</td>

										<!-- <td align="center" ng-if="estimate.transactionNo=='Total'"
											style="background-color: #7E7EB8;" class="sorting"><span
											style="color: white"></span></td> -->
										<td align="center" ng-if="estimate.transactionNo!='Total'"
											class="sorting">{{estimate.narration}}</td>



										<!-- <td align="right" ng-if="estimate.transactionNo=='Total'"
											style="background-color: #7E7EB8;" class="sorting"><span
											style="color: white"><b>{{estimate.creditAmount}}</b></span></td> -->
										<td align="right" ng-if="estimate.transactionNo!='Total'"
											class="sorting">{{estimate.creditAmount}}</td>


										<!-- 	<td align="right" ng-if="estimate.transactionNo=='Total'"
											style="background-color: #7E7EB8;" class="sorting"><span
											style="color: white"><b>{{estimate.debitAmount}}</b></span></td> -->
										<td align="right" ng-if="estimate.transactionNo!='Total'"
											class="sorting">{{estimate.debitAmount}}</td>
									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
										ng-repeat="(trIndex,estimate) in displayedCollection">


										<td ng-if="estimate.transactionNo=='Total'" class="width_10"
											align="left" height="30"
											style="background: #D37878 !important"
											style="font-size: 10px;"><font size="2" face="arial"><b>&nbsp
											</b></font></td>

										<td ng-if="estimate.transactionNo=='Total'" class="width_10"
											align="left" height="30"
											style="background: #D37878 !important"
											style="font-size: 10px;"><font size="2" face="arial"><b>&nbsp
													TOTAL</b></font></td>
										<td ng-if="estimate.transactionNo=='Total'" class="width_10"
											align="left" height="30"
											style="background: #D37878 !important"
											style="font-size: 10px;"><font size="2" face="arial"><b>&nbsp
											</b></font></td>
										<td ng-if="estimate.transactionNo=='Total'" class="width_10"
											align="left" height="30"
											style="background: #D37878 !important"
											style="font-size: 10px;"><font size="2" face="arial"><b>&nbsp
											</b></font></td>

										<td ng-if="estimate.transactionNo=='Total'" class="width_10"
											align="left" height="30"
											style="background: #D37878 !important"
											style="font-size: 10px;"><font size="2" face="arial"><b>&nbsp
											</b></font></td>
										<td ng-if="estimate.transactionNo=='Total'" class="width_10"
											align="left" height="30"
											style="background: #D37878 !important"
											style="font-size: 10px;"><font size="2" face="arial"><b>&nbsp
											</b></font></td>

										<td ng-if="estimate.transactionNo=='Total'" class="width_10"
											align="right" height="30"
											style="background: #D37878 !important"
											style="font-size: 10px;"><font size="2" face="arial"><b>{{estimate.creditAmount}}</b></font></td>

										<td ng-if="estimate.transactionNo=='Total'" class="width_10"
											align="right" height="30"
											style="background: #D37878 !important"
											style="font-size: 10px;"><font size="2" face="arial"><b>{{estimate.debitAmount}}</b></font></td>





									</tr>






									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
										ng-repeat="(trIndex,estimate) in displayedCollection">


										<td ng-if="estimate.transactionNo=='Total'" class="width_10"
											align="left" height="30"
											
											style="font-size: 10px;"><font size="2" face="arial"><b>&nbsp
											</b></font></td>

										<td ng-if="estimate.transactionNo=='Total'" class="width_10"
											align="left" height="30"
											
											style="font-size: 10px;"><font size="2" face="arial"><b></b></font></td>
										<td ng-if="estimate.transactionNo=='Total'" class="width_10"
											align="left" height="30"
											
											style="font-size: 10px;"><font size="2" face="arial"><b>&nbsp
											</b></font></td>
										<td ng-if="estimate.transactionNo=='Total'" class="width_10"
											align="left" height="30"
										
											style="font-size: 10px;"><font size="2" face="arial"><b>&nbsp
											</b></font></td>

										<td ng-if="estimate.transactionNo=='Total'" class="width_10"
											align="left" height="30"
											
											style="font-size: 10px;"><font size="2" face="arial"><b>&nbsp
											</b></font></td>
										<td ng-if="estimate.transactionNo=='Total'" class="width_10"
											align="left" height="30"
										
											style="font-size: 10px;"><font size="2" face="arial"><b>
											</b></font></td>

										<td ng-if="estimate.transactionNo=='Total'" class="width_10"
											align="right" height="30"
											style="background: #7E7EB8 !important"
											style="font-size: 10px;"><font size="2" face="arial"><b> Balance Amount </b></font></td>

										<td ng-if="estimate.transactionNo=='Total'" class="width_10"
											align="right" height="30"
											style="background: #7E7EB8 !important"
											style="font-size: 10px;"><font size="2" face="arial"><b>{{(estimate.debitAmount - estimate.creditAmount)|number:2 }}</b></font></td>





									</tr>














								</tbody>






							</table>



						</div>




						<div class="form-actions">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">

										<button ng-if="rflag==true" class="btn btn-success"
											type="button" data-ng-click="save();">Reconcile</button>

									</div>
									<%-- <footer class="panel-footer panel-footer-list">
				<%@include file="/views/layout/panel-footer-static.jsp"%>
			</footer> --%>
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
<!-- /wrapper-md -->



