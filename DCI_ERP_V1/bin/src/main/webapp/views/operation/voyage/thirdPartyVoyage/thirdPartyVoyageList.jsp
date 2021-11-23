<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="wrapper-md">
			<div class="panel panel-default">
				<div class="panel-heading font-bold" style="color: #f5f5f5">Third
					Party Voyage</div>
				<div class="panel-body form-horizontal">
					<div class="row book-widget-row">
						<div class="col-sm-12 col-md-4 col-lg-4">
							<div class="form-group">
								<label class="col-md-4 control-label  vessel-text">Vessel</label>
								<div class="col-md-6"">
									<selectivity list="vesselList"
										property="voyageHeader.vesselCode" id="vessel_id"></selectivity>
								</div>
							</div>
						</div>
						 <div class="col-sm-12 col-md-4 col-lg-4">
							<fieldset>
								
								<div class="form-group">
										<label class="col-md-4 control-label"> Voyage
										
										</label>
										<div class="col-md-6">
											
											 <select id="voyageId" multiple="multiple" name="multiselect[]" ng-model="voyageHeader.voyageIdnew"
											 ng-options="option.id as option.text for option in voyageList" data-dropdownmultiselect>    
											   <option data-ng-repeat="option in voyageList" value="{{getOptionId(option)}}" 
											   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option>
											</select>
										</div>
									</div>
								
           
								<!-- <div class="form-group">
										<label class="col-md-4 control-label"> Company
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-6">
											
											 <select id="txtCompanyCode" multiple="multiple" name="multiselect[]" ng-model="companyCodes"
											 ng-options="option.id as option.text for option in companyList" data-dropdownmultiselect>    
											   <option data-ng-repeat="option in companyList" value="{{getOptionId(option)}}" 
											   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option>
											</select>
										</div>
									</div> -->
								<!-- <div class="form-group">
									<label class="col-md-3 control-label">Voyage</label>
									<div class="col-md-6">
										<selectivity list="voyageList"
											property="voyageHeader.voyageId" id="voyage_id"></selectivity>
									</div>
								</div> -->
							</fieldset>
						</div>
						<div class="col-sm-12 col-md-4 col-lg-4">
						<div class="form-group ">
            <label class="col-md-4 control-label " >Service</label>
             <div class="col-md-6" >
            <selectivity list="serviceList" property="voyageHeader.sectorId" id="service_id"></selectivity>
            </div>
             
           </div>
						</div>
						<div class="col-sm-12 col-md-4 col-lg-4">
						<div class="form-group ">
            <label class="col-md-4 control-label " >Vessel Operator</label>
             <div class="col-md-6" >
            <selectivity list="mloShortNameList" property="voyageHeader.mloShortName" id="mlo_id"></selectivity>
            </div>
			 
           </div>
						</div>
						<div class="col-sm-12 col-md-4 col-lg-4">
							<div class="form-group">
               <label class="col-md-4 control-label ">From Date</label>
            <div class="col-md-6" >
              <!-- <bootstrapdatetimepicker  property="thirdPartyHeader.schStartDate" id="sch_start_date"></bootstrapdatetimepicker> -->
               <!-- <ng-bs3-datepicker data-ng-model="thirdPartyHeader.schStartDate" date-format="DD/MM/YYYY HH:mm" id="sch_start_date" /> -->
          <ng-bs3-datepicker data-ng-model="voyageHeader.fromDate"
										id="fromDate" name="fromDate"  date-format="DD/MM/YYYY" 
										id="fromDate"
											friendly-name="Valid From"
											/>
            </div>
            
           </div>
						</div>
						<div class="col-sm-12 col-md-4 col-lg-4">
							<div class="form-group">
               <label class="col-md-4 control-label ">To Date</label>
            <div class="col-md-6" >
              <!-- <bootstrapdatetimepicker  property="thirdPartyHeader.schStartDate" id="sch_start_date"></bootstrapdatetimepicker> -->
               <!-- <ng-bs3-datepicker data-ng-model="thirdPartyHeader.schStartDate" date-format="DD/MM/YYYY HH:mm" id="sch_start_date" /> -->
          <ng-bs3-datepicker data-ng-model="voyageHeader.toDate"
										id="toDate" name="toDate"  date-format="DD/MM/YYYY" 
										id="toDate"
											friendly-name="Valid From"
											/>
            </div>
            
           </div>
						</div>
						<!-- <div class="col-sm-12 col-md-4 col-lg-4">
							<div class="form-group">
								<label class="col-md-4 control-label">Activity Type</label>
								<div class="col-md-6">
									<selectivity list="activityTypes"
										property="voyageHeader.activityCode" id="activity_id"></selectivity>
								</div>
							</div>
						</div> -->

					</div>
					<div align="center">
						<div class="row panel-body">
							<div class="col-md-12 ">
								<security:authorize access="hasRole('${form_code}_${search}')">
									<button class="btn btn-success" type="button"
										data-ng-click="searchThirtPartyVoyage();">
										<i class="fa fa-search"></i> Search
									</button>
									
									<button class="btn btn-warning" type="button"
							data-ng-click="copyVoyage();">
							<i class="fa fa-files-o"></i> Copy Voyage
						</button>
						
									<button class="btn btn-primary" data-ng-click="exportExcel()">
										<i class="fa fa-file-excel-o"> </i> Export to Excel <a
											id="BLReport" stype="display:none"
											href="filePath/Sailing Schedule.xls"
											download="Sailing Schedule.xls"></a>
									</button>
									
									<button class="btn btn-success" type="button"
            class="btn btn-success"
            data-ng-click="fileUpload()">
           			Import
           </button>
								</security:authorize>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-default panel-default-list"
				st-table="displayedCollection" st-safe-src="rowCollection">
				<div class="col-md-7"></div>
				<div class="col-md-3 text-right padding-left-0">

					<button class="btn btn-sm btn-success" ng-click="add()"
						ng-hide="hideAddIcon">
						<span class="fa fa-plus"></span>
					</button>

				</div>
				<div class="col-md-2  p-l-0">

					<input type="text" st-search=""
						class="form-control input-sm p-tb-14 bg-white rounded padder"
						placeholder="Search">

				</div>
				<div class="panel-body float-left padding-0" style="width: 100%;">
					<div class="table-responsive ">
						<table class="table table-striped table-hover dataTable no-footer">
							<thead class="dataTables-Main-Head">
								<tr>
									<!-- 							<th class="width_1"><label class="i-checks m-b-none"> -->
									<!-- 									<input type="checkbox" name="post[]"> <i></i> -->
									<!-- 							</label></th> -->
									<th class="sorting" st-sort="vesselName">Vessel</th>
									<th class="sorting" st-sort="voyageId">Voyage</th>
									<th class="sorting" st-sort="sectorName">Service</th>
										<th class="sorting" st-sort="vesselOperatorName">Vessel Operator</th>
									<!-- <th class="sorting" st-sort="departureId">Activity</th> -->
									<th class="sorting" st-sort="schStartDate">Schedule Start
										Date</th>
									<th class="sorting" st-sort="schEndDate">Schedule End Date</th>
									
									<th class="text-center">Action</th>
								</tr>
							</thead>
							<tbody class="dataTables-Main-Body">
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
									ng-repeat="thirdPartyVoyage in displayedCollection">
									<!-- 							<td class=""><label class="i-checks m-b-none"> <input -->
									<!-- 									type="checkbox" name="post[]"> <i></i> -->
									<!-- 							</label></td> -->
									<td class="">{{thirdPartyVoyage.vesselName}}</td>
									<td class="">{{thirdPartyVoyage.voyageId}}</td>
									<td class="sorting ">{{thirdPartyVoyage.sectorName}}</td>
										<td class="sorting ">{{thirdPartyVoyage.vesselOperatorName}}</td>
									<!-- <td class="">{{thirdPartyVoyage.activityName}}</td> -->
									<td class="sorting ">{{thirdPartyVoyage.schStartDate}}</td>
									<td class="sorting ">{{thirdPartyVoyage.schEndDate}}</td>
									 <td class=" td-actions text-center">
							 <security:authorize access="hasRole('${form_code}_${modify}')">
							<span> <i
									class="fa  fa-pencil text-success text"
									data-ng-click="editVoyage(thirdPartyVoyage)"></i>
							</span> 
							</security:authorize>
							 <security:authorize access="hasRole('${form_code}_${delete}')">
							<span> <i class="fa fa-trash-o text-danger-dker text"
									data-ng-click="deleteRow(thirdPartyVoyage.voyageId,$index)"></i>
							</span>
							</security:authorize>
							<security:authorize access="hasRole('${form_code}_${view}')">
							<span> <i
									class="fa   fa-eye text-success text"
									data-ng-click="viewVoyage(thirdPartyVoyage)"></i>
							</span>
							</security:authorize>
							</td> 
								</tr>
							</tbody>
						</table>
					</div>
					<footer class="panel-footer panel-footer-list">
						<%@include file="/views/templates/panel-footer-static.jsp"%>
					</footer>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/ng-template" id="fileModal">
 <div class="modal-header"> File Upload</div>
  <div class="row">
   <div class="col-lg-12">
    <div class="col-lg-12">
     <input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadFile(this)"  accept=".xls,.xlsx,.xlsm" />
    </div>
   </div> 
  </div>
  <div class="modal-footer">
	<a class="btn btn-success" href="/assets/docs/sailingSchedule.xlsx" class="control-label">Download sample excel file</a>	
   <button class="btn btn-info" type="button" ng-click="uploadMaterialIssueRecord()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
  </div>
 </script>
 
 <script type="text/ng-template" id="modalDialogId6">
	
	<div class="padding-0">
 <div class="panel panel-default padding-0">
  <div class="panel-heading font-bold">ERROR</div>
  <div class="panel-body">
   <div style = "color:red;">Failed To Upload</div>
   <div>
    <label id="id"> {{value}}</label>
   
               
   </div>
   <div class="form-actions">
    <div class="row">
    
     <div class="col-md-12">
       <button class="btn btn-danger" ng-click="closeFileDialog()">OK</button>
     </div>
    </div>
   </div>
  </div>
 </div>
</div>
	
</script>
