
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form class="form-horizontal" novalidate
				name="dailyVehicleReportForm">
				<div class="col-sm-12 col-md-4 col-lg-4">
					<fieldset></fieldset>
				</div>


				<div class="row">


					<div class="col-sm-4 col-md-4 col-lg-4"></div>

					<!-- <div class="col-sm-4 col-md-4 col-lg-4">

						<div class="form-group">
							<label class="col-md-3 control-label">Company<span
								style="color: red;">*</span></label>
							<div class="col-md-8" style="width: 338px;">
								<selectivity list="truckList"
									property="dailyVehicleReport.truckId" id="truckId"
									ng-model="dailyVehicleReport.truckId"
									name="truckId" friendly-name="Truck" validation="required" 
									form-name="dailyVehicleReportForm"></selectivity>


																	<select  id="truckMultiSelect" multiple="multiple" name="multiselect[]" ng-model="dailyVehicleReport.truckIdList" validation="required"  friendly-name="Truck"
																			 ng-options="option.id as option.text for option in truckList" data-dropdownmultiselect>    
																			   <option data-ng-repeat="option in truckList" value="{{getOptionId(option)}}" 
																			   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option>
																			</select>

																			                <select ng-model="dailyVehicleReport.truckIdList" multiple="multiple" id="truckMultiSelect"  name="truckMultiSelect" ng-options="option for option in podList">
<!--              </select>





								<selectivity list="companyList" property="tripPandL.companyName"
									id="cmbCompanyName" form-name="tripPandLForm"
									validation="required" friendly-name="Company"
									name="cmbCompanyName" ng-model="tripPandL.companyName"></selectivity>
							</div>
						</div>

					</div>
 -->
					<div class="col-sm-6 col-md-6 col-lg-6">

						<div class="form-group">
							<label for="inputPassword" class="control-label col-md-3 ">From
								Date<span style="color: red;">*</span>
							</label>
							<div class="col-md-7">

								<ng-bs3-datepicker data-ng-model="tripPandL.fromDate"
									name="fromDate" id="fromDate" form-name="tripPandLForm"
									friendly-name="From Date" validation="required"
									form-name="tripPandLForm" />


							</div>
						</div>
					</div>

					<div class="col-sm-6 col-md-6 col-lg-6">

						<div class="form-group">
							<label for="inputPassword" class="control-label col-md-3 ">To
								Date <span style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<ng-bs3-datepicker data-ng-model="tripPandL.toDate"
									name="toDate" id="toDate" form-name="tripPandLForm"
									friendly-name="To Date" validation="required" />
							</div>
						</div>

					</div>

				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">

							<%--                               <security:authorize access="hasRole('${form_code}_${export}')"> --%>
							<!-- 							<button class="btn btn-primary" -->
							<!-- 								ng-click="exportExcel(dailyVehicleReportForm,dailyVehicleReport)"> -->
							<!-- 								<i class="fa fa-download"> </i> Export Excel -->
							<!-- 							</button> -->

							<!-- 							<a id="dailyExport" href="" download=""></a> -->

							<%-- 							</security:authorize> --%>



							<button type="button" ng-click="view(tripPandLForm,tripPandL)"
								class="btn btn-success" tooltip="Reset">View</button>

							</button>



							<button type="button" ng-click="reset()" class="btn btn-info"
								tooltip="Reset">
								<i class="fa fa-undo"> Reset</i>

							</button>

						</div>

						<br>
						<br>
						<br>
						<br>
						<br> <br>
						<br>
						<br>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</div>
