<script src="js/vendor/angular-chart/Chart.min.js"></script>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		 <input type="hidden" value="${form_code}" id="form_code_id" /> 
		<div class="panel-body">
			<form class="form-horizontal" name="corgForm" role="form">
				<div class="row ">
					<div class="col-sm-12 col-md-12 col-lg-12">

						<div class="col-sm-2 ">
						
							<div class="form-group">
								<label class="col-md-4 control-label"> Company <!-- 	<span style="color: red;">*</span> -->
								</label>
								<div class="col-md-8">
									<selectivity list="companyList"
										property="corgReport.companyCode" id="companyCode"
										></selectivity>

								</div>
							</div>
						</div>

						<div class="col-sm-2 ">
							<fieldset>
								<div class="form-group">
									<label class="col-md-3 control-label"> Supplier</label>
									<div class="col-md-8">
										<selectivity list="supplierList" property="corgReport.supplierCode" id="supplierCode"></selectivity>
									</div>
								</div>
							</fieldset>
						</div>

						
						<div class="col-sm-1 ">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label"> Year </label>
									<div class="col-md-6 col-sm-push-2 nopadding">
										<selectivity list="yearList" property="corgReport.year"
											id="year"></selectivity>
									</div>
								</div>
							</fieldset>
						</div>

						<div class="col-sm-4">
							<div class="form-group">
								<div class="col-md-12">
									<label class="col-md-3 control-label">From Week </label>
									<div class="col-md-1 nopadding">
										<selectivity list="weekList" property="corgReport.fromWeek"
											id="week"></selectivity>
									</div>
									<label class="col-md-3 control-label"> To Week </label>
									<div class="col-md-1 nopadding">
										<selectivity list="weekList" property="corgReport.toWeek"
											id="week"></selectivity>
									</div>
									<label class="col-md-3 control-label"> {{weekEndDate}}
									</label>
								</div>

							</div>
						</div>
						<div class="col-sm-1 ">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label"> Last </label>
									<div class="col-md-6 col-sm-push-2 nopadding">
										<input type="text" class="form-control input-sm" ng-model="corgReport.totalWeek" />
									</div>
								</div>
							</fieldset>
						</div>
						<div class="col-sm-1 ">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label"> Weeks</label>
									
								</div>
							</fieldset>
						</div>
					</div>
				</div>

				<!-- <div class="row ">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-2 ">
							<div class="form-group"></div>
						</div>
						<div class="col-sm-2 ">
							<div class="form-group"></div>
						</div>
						<div class="col-sm-2 ">
							<div class="form-group"></div>
						</div>

						<div class="col-sm-1 ">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label"> Last </label>
									<div class="col-md-6 col-sm-push-2 nopadding">
										<input type="text" class="form-control input-sm" ng-model="corgReport.totalWeek" />
									</div>
								</div>
							</fieldset>
						</div>
						<div class="col-sm-1 ">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label"> Weeks</label>
									
								</div>
							</fieldset>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
							</div>
						</div>
					</div>
				</div> -->

				<a id="supplierExport" stype="display:none"
					href="filePath/SupplierCard.xls" download="SupplierCard.xls"></a>
			</form>
			<div class="form-actions">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
							<button class="btn btn-success" type="submit"
								ng-click="viewSupplierCard()">
								<i class="fa fa-search"></i>View
							</button>
							<security:authorize access="hasRole('${form_code}_${export}')">
							<button class="btn btn-primary" type="submit"
								ng-click="exportSupplierReport()">
								<i class="fa fa-search"></i>Export Excel
							</button>
							</security:authorize>
						<button class="btn btn-info" type="reset" ng-click="reset()">
							<i class="fa fa-undo"></i> Reset
						</button>
					</div>
				</div>
			</div>

			<div class="panel-body padding-0">
				<br>
								<div class="table-responsive">

					<table id="dt_basic"
						class="table table-striped table-bordered table-hover dataTable no-footer"
						width="100%" role="grid" aria-describedby="dt_basic_info"
						ng-if="!isChart && !isChart1">
						<thead class="dataTables-Main-Head">
							<tr role="row">
								<th class=" width_9">Week</th>
								<th class=" width_9">Blw 30</th>
								<th class=" width_9">30 -45</th>
								<th class=" width_9">45 - 60</th>
								<th class=" width_9">Abv 60</th>
								<th class=" width_9">Total</th>
								<th class=" width_9">Paid</th>
								<th class=" width_9">Actual Payment</th>
								<th class=" width_9">Invoicing</th>
								<th class=" width_9">Weekly</th>
								<th class=" width_9">Advance</th>
								<th class=" width_9">Adjusted Advance</th>
							</tr>
						</thead>
						<tbody class="dataTables-Main-Body">
							<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
								ng-repeat="(trIndex, objTranslationItem) in rowCollection">
								<td><span tooltip="{{objTranslationItem.week}}"
									class="tool-tip-span" ng-bind="objTranslationItem.week"></span>
								</td>

								<td class="text-right">{{objTranslationItem.co30}}</td>
								<td class="text-right">{{objTranslationItem.co30to45}}</td>
								<td class="text-right">{{objTranslationItem.co45to60}}</td>
								<td class="text-right">{{objTranslationItem.co60Plus}}</td>
								<td class="text-right">{{objTranslationItem.totalAmount}}</td>
								<td class="text-right">{{objTranslationItem.remittance}}</td>
								<td class="text-right">{{objTranslationItem.payment}}</td>
								<td class="text-right">{{objTranslationItem.invoicing}}</td>
								<td class="text-right">{{objTranslationItem.weekly}}</td>
								<td class="text-right">{{objTranslationItem.advance}}</td>
								<td class="text-right">{{objTranslationItem.adjusted_advance}}
								</td>
							</tr>
						</tbody>
					</table>
				</div>


				

			</div>
		</div>
	</div>
	</div>