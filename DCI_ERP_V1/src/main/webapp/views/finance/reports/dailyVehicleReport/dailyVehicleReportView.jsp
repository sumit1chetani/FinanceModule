
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" novalidate
				name="dailyVehicleReportForm">
			
			
			<br>
				<div class="row">

					<div class="col-sm-3 col-md-3 col-lg-3">

						<div class="form-group">
							<label for="inputPassword" class="control-label col-md-3 ">Trip</label>
							<div class="col-md-7">
									<selectivity list="tripList" 
 									property="dailyVehicleReport.tripId" id="tripId" 
									ng-model="dailyVehicleReport.tripId" 
										name="tripId" friendly-name="Trip"  
 									form-name="dailyVehicleReportForm"></selectivity>
							</div>
						</div>

					</div>
                     <div class="col-sm-3 col-md-3 col-lg-3">

						<div class="form-group">
							<label for="inputPassword" class="control-label col-md-3 ">Truck<span
										style="color: red;">*</span></label>
							<div class="col-md-7">
									<select  id="truckMultiSelect" multiple="multiple" name="multiselect[]" ng-model="dailyVehicleReport.truckIdList" validation="required"  friendly-name="Truck"
											 ng-options="option.id as option.text for option in truckList" data-dropdownmultiselect>    
											   <option data-ng-repeat="option in truckList" value="{{getOptionId(option)}}" 
											   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option>
											</select>
							</div>
						</div>

					</div>
					<!-- <div class="col-sm-3 col-md-3 col-lg-3">

						<div class="form-group">
							<label class="col-md-3 control-label">Truck<span
										style="color: red;">*</span></label>
							<div class="col-md-7" style="width: 338px; ">
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
											
											            
							</div>
						</div>

					</div> -->

					<div class="col-sm-3 col-md-3 col-lg-3">

						<div class="form-group">
							<label for="inputPassword" class="control-label col-md-3 ">From
								Date<span
										style="color: red;">*</span> </label>
							<div class="col-md-7">

								<ng-bs3-datepicker data-ng-model="dailyVehicleReport.fromDate"
									name="fromDate" id ="fromDate" form-name="dailyVehicleReportForm"
									friendly-name="From Date" validation="required" 
									form-name="dailyVehicleReportForm"/>


							</div>
						</div>
					</div>

					<div class="col-sm-3 col-md-3 col-lg-3">

						<div class="form-group">
							<label for="inputPassword" class="control-label col-md-3 ">To
								Date <span
										style="color: red;">*</span></label>
							<div class="col-md-7">
									<ng-bs3-datepicker data-ng-model="dailyVehicleReport.toDate"
									name="toDate" id = "toDate" form-name="dailyVehicleReportForm"
									friendly-name="To Date" validation="required" 
									/>
							</div>
						</div>

					</div>

				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">

                              <security:authorize access="hasRole('${form_code}_${export}')">
							<button class="btn btn-primary"
								ng-click="exportExcel(dailyVehicleReportForm,dailyVehicleReport)">
								<i class="fa fa-download"> </i> Export Excel
							</button>

							<a id="dailyExport" href="" download=""></a>
							
							</security:authorize>


							<button type="button" ng-click="reset()" class="btn btn-info"
								tooltip="Reset">
								<i class="fa fa-undo"> Reset</i>

							</button>

						</div>
						
						<br><br><br><br><br>
						<br><br><br>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
