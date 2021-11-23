<script src="js/angular-chart/Chart.min.js"></script>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
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
										object="tempDropDownObj"></selectivity>

								</div>
							</div>
						</div>

						<div class="col-sm-2 ">
							<fieldset>
								<div class="form-group">
									<label class="col-md-3 control-label"> Cust&nbsp;#</label>
									<div class="col-md-8">
										<selectivity list="mloList" property="corgReport.mloCode"
											id="mloCode" object="mloCode"></selectivity>
									</div>
								</div>
							</fieldset>
						</div>

					<!-- 	<div class="col-sm-2 ">
							<fieldset>
								<div class="form-group">
									<label class="col-md-3 control-label"> Payer </label>
									<div class="col-md-8">
										<selectivity list="customerList"
											property="corgReport.customerCode" id="customerCode"
											object="customerCode"></selectivity>
									</div>
								</div>
							</fieldset>
						</div> -->
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

						<div class="col-sm-5">
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
									<label class="col-md-4 control-label"> {{weekEndDate}}
									</label>
								</div>

							</div>
						</div>
					</div>
				</div>

				<div class="row ">
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
				</div>

				<a id="corgExport" stype="display:none"
					href="filePath/CustomerCard.xls" download="CustomerCard.xls"></a>
			</form>
			<div class="form-actions">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<security:authorize access="hasRole('${form_code}_${view}')">
							<button class="btn btn-success" type="submit"
								ng-click="viewCorgReportAsOnDate()">
								<i class="fa fa-search"></i>View
							</button>
							<button class="btn btn-success" type="submit"
								ng-click="viewCorgChart()">
								<i class="fa fa-search"></i>View chart
							</button>
							<button class="btn btn-success" type="submit"
								ng-click="viewAgewiseChart()">
								<i class="fa fa-search"></i>View Agewise chart
							</button>
							</security:authorize>
							<security:authorize access="hasRole('${form_code}_${export}')">
							<button class="btn btn-primary" type="submit"
								ng-click="exportCorgReport()">
								<i class="fa fa-search"></i>Export Excel
							</button>
							</security:authorize>
							<security:authorize access="hasRole('${form_code}_${view}')">
							<button class="btn btn-success" type="submit"
								ng-click="consolidatedView()">
								<i class="fa fa-search"></i>Consolidated
							</button>
							</security:authorize>
						
						<!-- <button class="btn btn-primary" type="submit" ng-click="exportCorgReportAsOnDate()">
	       								<i class="fa fa-search"></i>Export As on Date
	       					</button> -->
						<button class="btn btn-info" type="reset" ng-click="reset()">
							<i class="fa fa-undo"></i> Reset
						</button>
					</div>
				</div>
			</div>

			<div class="panel-body padding-0">
				<!-- <div class="row" ng-if="isChart"> -->
				<br>
				<div class="col-sm-12 col-md-12 col-lg-12"
					ng-show="!isChart && !isChart1">
					<div class="col-sm-1"></div>
					<div class="col-sm-5" ng-if="corgReport.mloCode!=''">
						<label class="col-md-1"><b> CUSTOMER:</b></label> <label
							class="col-md-10 control-label"><b>{{corgReport.mloName}}</b></label>
					</div>


					<div class="col-sm-5" ng-if="corgReport.customerCode!=''">
						<fieldset>
							<label class="col-md-1 control-label"><b> Payer:</b></label>
							<div class="col-md-10 form-group form-group-label-left">
								<!-- <label class="col-md-2 col-md-offset-1 control-label  text-left">Payer </label> -->
								<label class="col-md-10 control-label"><b>{{corgReport.payerName}}</b></label>
							</div>

						</fieldset>
					</div>
				</div>
				<div class="col-sm-3 col-md-3 col-lg-3" ng-show="isChart">
					<div class="form-group"
						ng-init="depreciationMethod.valuationType='L'">
						<label class="col-md-2 control-label">Chart</label>
						<div class="radio radio-inline">
							<label class="i-checks"> <input type="radio" class=""
								name="valuationType" ng-click="checkChartType()" value="L"
								id="chartType" ng-model="corgReport.chartType"> <i></i>
								Line
							</label>
						</div>
						<div class="radio radio-inline">
							<label class="i-checks"> <input type="radio" class=""
								name="valuationType" ng-click="checkChartType()" value="B"
								id="chartType" ng-model="corgReport.chartType"> <i></i>
								Bar
							</label>
						</div>
					</div>
				</div>
				<div id="chartContainer" >

					<!-- <canvas id="corgBar" height="400" width="1200"></canvas> -->
				</div>

				<!-- <canvas id="myChart"></canvas>
		 -->
				<!-- </div> -->

				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-1 col-lg-1"></div>
					<div class="col-sm-12 col-md-10 col-lg-10">

						<div id="secondChart" ng-show="isChart1"
							style="padding-top: 71px; width: 1000px; height: 600px; margin: 2 auto"></div>
					</div>
					<div class="col-sm-12 col-md-1 col-lg-1"></div>
				</div>


				<div class="table-responsive" ng-if="!consolidated">

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
								<th class=" width_9">Remittance</th>
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

								<td class="text-right" ng-click="pending(objTranslationItem,0,30,'')" >
								<a href = "">
								<span tooltip="{{objTranslationItem.co30}}" class="tool-tip-span font-black" ng-bind="objTranslationItem.co30">
	     </span></a></td>
	     <td class="text-right" ng-click="pending(objTranslationItem,31,44,'')" >
								<a href = "">
								<span tooltip="{{objTranslationItem.co30to45}}" class="tool-tip-span font-black" ng-bind="objTranslationItem.co30to45">
	     </span></a></td>
	     <td class="text-right" ng-click="pending(objTranslationItem,45,59,'')" >
								<a href = "">
								<span tooltip="{{objTranslationItem.co45to60}}" class="tool-tip-span font-black" ng-bind="objTranslationItem.co45to60">
	     </span></a></td>
	     <td class="text-right" ng-click="pending(objTranslationItem,60,999,'')" >
								<a href = "">
								<span tooltip="{{objTranslationItem.co60Plus}}" class="tool-tip-span font-black" ng-bind="objTranslationItem.co60Plus">
	     </span></a></td>
	      <td class="text-right" ng-click="pending(objTranslationItem,0,9999,'')" >
								<a href = "">
								<span tooltip="{{objTranslationItem.totalAmount}}" class="tool-tip-span font-black" ng-bind="objTranslationItem.totalAmount">
	     </span></a></td>
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


				<div class="table-responsive" ng-if="consolidated">

					<table id="dt_basic"
						class="table table-striped table-bordered table-hover dataTable no-footer"
						width="100%" role="grid" aria-describedby="dt_basic_info"
						ng-if="!isChart && !isChart1">
						<thead class="dataTables-Main-Head">
							<tr role="row">
								<th class="sorting width_9">Week</th>
								<th class="sorting width_9">Blw 30</th>
								<th class="sorting width_9">30 -45</th>
								<th class="sorting width_9">45 - 60</th>
								<th class="sorting width_9">Abv 60</th>
								<th class="sorting width_9">Total</th>
								<th class="sorting width_9">Remittance</th>
								<th class="sorting width_9">Remittance Perma</th>
								<th class="sorting width_9">Remittance Merlion</th>
								<th class="sorting width_9">Actual Payment</th>
								<th class="sorting width_9">Invoicing</th>
								<th class="sorting width_9">Weekly</th>
								<th class="sorting width_9">Advance</th>
								<th class="sorting width_9">Adjusted Advance</th>
							</tr>
						</thead>
						<tbody class="dataTables-Main-Body">
							<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
								ng-repeat="(trIndex, objTranslationItem) in rowCollection">
								<td><span tooltip="{{objTranslationItem.week}}"
									class="tool-tip-span" ng-bind="objTranslationItem.week"></span>
								</td>
<td class="text-right" ng-click="pending(objTranslationItem,0,30,'C')" >
								<a href = "">
								<span tooltip="{{objTranslationItem.co30}}" class="tool-tip-span font-black" ng-bind="objTranslationItem.co30">
	     </span></a></td>
	     <td class="text-right" ng-click="pending(objTranslationItem,31,44,'C')" >
								<a href = "">
								<span tooltip="{{objTranslationItem.co30to45}}" class="tool-tip-span font-black" ng-bind="objTranslationItem.co30to45">
	     </span></a></td>
	     <td class="text-right" ng-click="pending(objTranslationItem,45,59,'C')" >
								<a href = "">
								<span tooltip="{{objTranslationItem.co45to60}}" class="tool-tip-span font-black" ng-bind="objTranslationItem.co45to60">
	     </span></a></td>
	     <td class="text-right" ng-click="pending(objTranslationItem,60,999,'C')" >
								<a href = "">
								<span tooltip="{{objTranslationItem.co60Plus}}" class="tool-tip-span font-black" ng-bind="objTranslationItem.co60Plus">
	     </span></a></td>
	     <td class="text-right" ng-click="pending(objTranslationItem,0,9999,'C')" >
								<a href = "">
								<span tooltip="{{objTranslationItem.totalAmount}}" class="tool-tip-span font-black" ng-bind="objTranslationItem.totalAmount">
	     </span></a></td>
								<td class="text-right">{{objTranslationItem.remittance}}</td>
								<td class="text-right">{{objTranslationItem.remittancePerma}}
								</td>
								<td class="text-right">{{objTranslationItem.remittanceMerlin}}
								</td>
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