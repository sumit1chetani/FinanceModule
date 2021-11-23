<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<!-- </div> -->
		 <style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>

	
<div class="row">
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset><br>
							<div class="form-group"  >
            <label class="col-md-2 control-label">Vessel</label> 
             <div class="col-md-5">
                      <selectivity list="vessellist" property="voyageAdd.vessel" id="vessel" ng-model="voyageAdd.vessel"
               name="vessel" form-name="voyageForm" 
               validation="required" friendly-name="Vessel"></selectivity></div>
           </div>
						</fieldset>
					</div>
<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset><br>
							<div class="form-group"  >
            <label class="col-md-2 control-label">Voyage</label> 
             <div class="col-md-5">
                      <selectivity list="voyagelist" property="voyageAdd.voyage" id="voyage" ng-model="voyageAdd.voyage"
               name="voyage" form-name="voyageForm" 
                ></selectivity></div>
           </div></fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset><br>
							<div class="form-group"  >
            <label class="col-md-2 control-label">Pol</label> 
             <div class="col-md-5">
                      <selectivity list="pollist" property="voyageAdd.pol" id="port" ng-model="voyageAdd.pol"
               name="pol" form-name="voyageForm" 
                friendly-name="Pol"></selectivity></div>
           </div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset><br>
							<div class="form-group"  >
            <label class="col-md-2 control-label">Pod</label> 
             <div class="col-md-5">
                      <selectivity list="podlist" property="voyageAdd.pod" id="pod" ng-model="voyageAdd.pod"
               name="pod" form-name="voyageForm" 
                friendly-name="Pod"></selectivity></div>
           </div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group"><br>
								<label for="inputPassword" class="control-label col-md-2">From
									Date 
								</label>
								<div class="col-md-5">
								<div class="input-group input-append date" id="fromDate">
										<ng-bs3-datepicker placeholder='dd/mm/yyyy'
											data-ng-model="voyageAdd.fromDate" />
									</div>
									<!-- <div class="input-group input-append date" id="fromDate">
										<input type="text" class="form-control input-sm"
											placeholder="dd/mm/yyyy" ng-model="voyageAdd.fromDate"
											name="fromDate" id="fromDate"> <span
											class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div> -->
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group"><br>
								<label for="inputPassword" class="control-label col-md-2">To
									Date 
								</label>
								<div class="col-md-5">
								<div class="input-group input-append date" id="toDate">
										<ng-bs3-datepicker placeholder='dd/mm/yyyy'
											data-ng-model="voyageAdd.toDate" />
									</div>
									<!-- <div class="input-group input-append date" id="toDate">
										<input type="text" class="form-control input-sm"
											placeholder="dd/mm/yyyy" ng-model="voyageAdd.toDate"
											name="toDate" id="toDate"> <span
											class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div> -->
								</div>
							</div>
						</fieldset>
					</div><br><br><br><br><br><br><br><br><br><br>
           	<div align="center">
								<%-- <security:authorize access="hasRole('${form_code}_${upload}')"> --%>
								<button class="btn btn-primary btn-small" type="button"
								ng-click="search(voyageForm,voyageAdd)"
								>
								 Search
							</button>
									<button class="btn btn-success" type="button"
            class="btn btn-success"
            data-ng-click="fileUpload()">
           		<i class = "fa-fa-upload">Import</i>	
           </button>
								<%-- </security:authorize> --%>
					</div>
</div>
				
				

		
		<br><br><br><br>
			 <div class="table-responsive" style=" border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;">
						<tr>
							
							<th class="sorting width_10" st-sort="vessel">Vessel Code</th>
							<th class="sorting width_15" st-sort="voyageCode">Voyage Name</th>
							<th class="sorting width_10" >Action</th>	
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="item in displayedCollection">
	
	
		<td class="" data-toggle="tooltip"
												title="{{item.vesselCode}}"><a data-ng-click="view(item.voyageCode)"> <span
								tooltip="{{item.voyageCode}}"
								class="tool-tip-span font-blue">{{item.vessel}}</span></a></td>
						<!-- 	<td class="" data-toggle="tooltip"
												title="{{item.vesselCode}}">{{item.vessel}}</td> -->
							<td class="sorting" data-toggle="tooltip"
												title="{{item.vesselName}}">{{item.voyageCode}}</td>
							<td class=" td-actions">
							 <security:authorize
									access="hasRole('${form_code}_${modify}')">
									<!-- <span> <i class="fa fa-eye text-success text"
										data-toggle="tooltip" title="view"
										data-ng-click="view(item.voyageCode)"></i>
									</span> -->
									<span> <i class="fa fa-pencil text-success text" data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(item.voyageCode)"></i>
									</span>
								</security:authorize>  <security:authorize access="hasRole('${form_code}_${delete}')"> 
									<span> <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(item.voyageCode)"></i>
									</span>
								 </security:authorize>
								 </td> 
						</tr>
					</tbody> 

				</table>
			</div> 
			<footer class="panel-footer panel-footer-list" style="padding:0px">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
			
		<!-- end widget content -->
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
	<a class="btn btn-success" href="/assets/docs/Voyage.xlsx" class="control-label">Download sample excel file</a>	
   <button class="btn btn-info" type="button" ng-click="uploadMaterialIssueRecord()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
  </div>
 </script>
 