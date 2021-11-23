<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
<div class="panel panel-default panel-default-form ">
<div class="panel-body">
<form name="userLogForm" method="post" class="form-horizontal" novalidate>
				<!-- /row -->

				<div  ng-controller="gateoutgateinAddCtrl">
				<div class="row pl2pc pr10pc">
				<div class="form-group">
								<div class="col-md-5">
									<button class="btn btn-primary" type="button"  
										class="btn btn-primary" data-ng-click="fileUpload()">
										<i class="fa fa-file"></i>Upload Container Details
									</button>
									<div class="excel"></div>
									 <a id="tbPdfExport" type="display:none" href="assets/docs/CCL_BulkUpload.xlsx" download="CCL_BulkUpload.xlsx"></a>
								</div>
							</div>
							</div>
					 </div>
			</form>
		</div>
	</div>
	<div class="panel-body">
<form name="userLogForm" method="post" class="form-horizontal" novalidate>
	<div class="row pl2pc pr10pc">

					<div class="col-md-4">
						<div class="form-group">

							<div class="col-md-7">

								<label class="col-md-5 control-label">Type<span
									style="color: red"></span></label>
								<div class="" style="margin-left: 5%;">
									<div class="radio radio-inline" style="padding-left: 0px;">
										<label class="i-checks"> <input type="radio"
											class="radiobox style-0" ng_model="gateOut.doType"
											value="export" name="export" checked="checked" ng-change="type('Export')"> <i></i>
											Export
										</label>
									</div>
								</div>
								<div class="" style="margin-left: 5%;">
									<div class="radio radio-inline" style="padding-left: 0px;">
										<label class="i-checks"> <input type="radio"
											class="radiobox style-0" ng_model="gateOut.doType"
											value="import" name="import" checked="checked" ng-change="type('Import')"> <i></i>
											Import
										</label>
									</div>
								</div>


							</div>
						</div>
					</div>
					
				</div></form></div>
	<div class="panel panel-default panel-default-list" st-persist="gateOutTable"
		st-table="displayedCollection" st-safe-src="rowCollection"
		ng-if="gateOut.doType=='export'">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<!-- </div> -->
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<div class="table-responsive ">
				<table id="dt_basic"
					class="table table-striped table-bordered table-hover dataTable no-footer"
					role="grid" aria-describedby="dt_basic_info">
					<thead class="dataTables-Main-Head">
						<tr>
			 
							<th class="sorting text-center" st-sort="gateoutno">Gate Out No</th>
							<th class="sorting text-center" st-sort="customername">Customer</th>
							<th class="sorting text-center" st-sort="bookingNo">Booking No</th>
						  <th class="sorting text-center" st-sort="vessel">Vessel</th>
					         <th class="sorting text-center" st-sort="voyage">Voyage</th>
							<th class="sorting text-center" st-sort="croNo">CRO No</th>
							<th class="sorting text-center" st-sort="croStatus">CRO Status</th>
							<th class="sorting text-center" st-sort="depot">Depot</th>
							<th class="sorting text-center" st-sort="releaseDate">Release Date</th>
							<th class=" text-center">Actions</th>

						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="collection in displayedCollection">
					 
							<td class="sorting text-center"><a ng-click="viewRow(collection.gateoutno)">
		             <span tooltip="{{collection.gateoutno}}" class="tool-tip-span font-blue">{{collection.gateoutno}}</span></a></td>
							<td class="sorting text-center">{{collection.customername}}</td>
							<td class="sorting text-center">{{collection.bookingNo}}</td>
							<td class="sorting text-center">{{collection.vessel}}</td>
							<td class="sorting text-center">{{collection.voyage}}</td>
							<td class="sorting text-center">
									<span tooltip="{{collection.croNo}}">{{collection.croNo}}</span>

							</td>
							<td class="sorting text-center">{{collection.croStatus}}</td>
							<td class="sorting text-center">{{collection.depot}}</td>
							<td class="sorting text-center">{{collection.releaseDate}}</td>
							
							<td class=" td-actions text-center"
								ng-if="collection.croStatus == 'COMPLETED'"><security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span> <i class="fa  fa-pencil text-success text"
										data-ng-click="editRow(collection.gateoutno)"></i>
									</span>
								</security:authorize> 
								<%-- <security:authorize access="hasRole('${form_code}_${delete}')">
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(collection.gateoutno)"></i>
									</span>
								</security:authorize> --%>
<!-- 								<span> <i class="fa  fa-eye text-success text" -->
<!-- 						data-toggle="tooltip" title="View" data-ng-click="viewRow(collection.gateoutno)"></i> -->
<!-- 									</span> -->
								<div class="fa fa-file-excel-o"
									data-ng-click="excelexport(collection.gateoutno)"></div> <a
								id="gateOutExport" style="display: none"
								href="filePath/GateOut.xlsx" download="GateOut.xlsx"></a></td>
							<td class=" td-actions text-center"
								ng-if="collection.croStatus == 'PENDING'"></td>
						</tr>
					</tbody>
				</table>
			</div>

			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>

			<!--  <div class="btn btn-primary"   data-ng-click="excelexport()">
				
				<span class="fa fa-file-excel-o"> Export to Excel</span>
</div>				
				<a id="gateOutExport" style="display:none"
							href="filePath/GateOut.xlsx" download="GateOut.xlsx"></a>
		 -->
		</div>
		<!-- end widget content -->
	</div>

	<!-- second list -->

	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection1" st-safe-src="rowCollection1"
		ng-if="gateOut.doType=='import'">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<!-- </div> -->
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<div class="table-responsive ">
				<table id="dt_basic"
					class="table table-striped table-bordered table-hover dataTable no-footer"
					role="grid" aria-describedby="dt_basic_info">
					<thead class="dataTables-Main-Head">
						<tr>
							<!-- <th class="width_1 text-center table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th> -->
							<th class="sorting text-center" st-sort="gateoutno">Gate Out No</th>
							<th class="sorting text-center" st-sort="customername">Customer</th>
							<th class="sorting text-center" st-sort="bookingNo">Booking No</th>
						 <th class="sorting text-center" st-sort="vessel">Vessel</th>
					         <th class="sorting text-center" st-sort="voyage">Voyage</th>
							<th class="sorting text-center" st-sort="doNo">Delivery Order No</th>
							<th class="sorting text-center" st-sort="depot">Depot</th>
							<th class="sorting text-center" st-sort="releaseDate">Release Date</th>
							<th class="sorting text-center" st-sort="">Actions</th>

						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="collection1 in displayedCollection1">
							<!-- <td class="">
            <label class="i-checks m-b-none">
             <input type="checkbox" name="post[]">
             <i></i>
            </label>
           </td> -->
							<td class="sorting text-center"><a ng-click="viewRow(collection1.gateoutno)">
		             <span tooltip="{{collection1.gateoutno}}" class="tool-tip-span font-blue">{{collection1.gateoutno}}</span></a></td>
							<td class="sorting text-center">{{collection1.customername}}</td>
							<td class="sorting text-center">{{collection1.bookingNo}}</td>
								<td class="sorting text-center">{{collection1.vessel}}</td>
							<td class="sorting text-center">{{collection1.voyage}}</td>
							<td class="sorting text-center">{{collection1.doNo}}</td>
							<td class="sorting text-center">{{collection1.depot}}</td>
							<td class="sorting text-center">{{collection1.releaseDate}}</td>
							<td class=" td-actions text-center"><security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span> <i class="fa  fa-pencil text-success text"
										data-ng-click="editRow(collection1.gateoutno)"></i>
									</span>
								</security:authorize>
								<%--  <security:authorize access="hasRole('${form_code}_${delete}')">
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(collection1.gateoutno)"></i>
									</span>
								</security:authorize> --%>
								<!-- <span > <i class="fa  fa-eye text-success text"
						data-toggle="tooltip" title="View" data-ng-click="viewRow(collection1.gateOutNo)"></i>
									</span> -->
								<div class="fa fa-file-excel-o"
									data-ng-click="excelexport(collection1.gateoutno)"></div> <a
								id="gateOutExport" style="display: none"
								href="filePath/GateOut.xlsx" download="GateOut.xlsx"></a></td>
							
						</tr>
					</tbody>
				</table>
			</div>

			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>

			<!--  <div class="btn btn-primary"   data-ng-click="excelexport()">
				
				<span class="fa fa-file-excel-o"> Export to Excel</span>
</div>				
				<a id="gateOutExport" style="display:none"
							href="filePath/GateOut.xlsx" download="GateOut.xlsx"></a>
		 -->
		</div>
		<!-- end widget content -->
	</div>
</div>

 <script type="text/ng-template" id="fileGenModal">
<div class="model-header">File Upload </div>
		<div class="row">
			<div class="col-lg-12">
				<div class="col-lg-12">
					<input type="file" class="form-control btn-primary" name="excelfile"
            		onchange="angular.element(this).scope().uploadContainerExcel(this)" accept=".xls,.xlsx" />
            		
				</div>
			</div> 
		</div>
		<div class="model-footer" style="padding-left:9%;padding-top:8%">
			<button class="btn btn-success" type="button" ng-click="uploadContainer()">OK</button>
			<button class="btn btn-danger" ng-click="closeUpload()">Cancel</button>
			<button class="btn btn-info" type="button"  ng-click="downloadFile()">Download Sample</button>
		</div>
</script>