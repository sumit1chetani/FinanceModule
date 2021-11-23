<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>
<div class="panel panel-default panel-default-form ">
<div class="row" style="margin-top: 15px;">
						          
           						<div class="col-md-6 ">
									<button class="btn btn-primary" type="button"  
										class="btn btn-primary" data-ng-click="fileUpload()">
										<i class="fa fa-file"></i>Upload Container Details
									</button>
									<div class="excel"></div>
									 <a id="tbPdfExport" type="display:none" href="assets/docs/SampleContainerBank.xlsx" download="SampleContainerBank.xlsx"></a>
									
           						 </div>
           						<div class="col-md-6 ">
           						<button class="btn btn-primary" data-ng-click="exportExcel()">
										<span class="fa fa-file-excel-o"> </span> Export to Excel <a
											id="bookingreport" stype="display:none"
											href="filePath/ContainerBank.xlsx"
											download="ContainerBank.xlsx"></a>
									</button>
									
									 
									<button class="btn btn-primary" type="button"   style="padding-left: 8px;border-left-width: 30px;margin-left: 456px;"
										class="btn btn-primary" data-ng-click="depotMove()">
									Depot Move
									</button>
									
									 </div>
        						 </div>
		<div class="panel-body float-left padding-0" style="width: 100%;">
		
			<!-- <div class="table-responsive "> -->
			<table class="table table-striped table-hover dataTable no-footer">
				
				<thead class="dataTables-Main-Head">
					<tr>
					
						<th class="sorting width_2" st-sort="commodityName">Container Id</th>
						<th class="sorting width_2" st-sort="shortName">Container Type</th>
						<th class="sorting width_2" st-sort="shortName">Container Number</th>
						<th class="sorting width_2" st-sort="shortName">Port</th>
						
					    <th class="sorting width_2" st-sort="description">Pay Load</th>
						<th class="sorting width_2" st-sort="status">Is Soc</th>
						<th class="width_2 text-center table-heading">Action</th>
					</tr>

				</thead>
				<tbody class="dataTables-Main-Body">
					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
						ng-repeat="collection in displayedCollection">
						
						<td>{{collection.containerId}}</td>
						<td>{{collection.cntrType}}</td>
						
						<td>{{collection.containerNo}}</td>
							<td>{{collection.port1}}</td>
						
						<td class="wrapping" data-toggle="tooltip"
												title="{{collection.payLoad}}">{{collection.payLoad}}</td>
						
						<td><input type="checkbox" checked="checked"
							disabled="disabled" ng-model="collection.soc"></td>
							
						<td class=" td-actions text-center"><security:authorize
								access="hasRole('${form_code}_${modify}')">
								<span> <i class="fa  fa-pencil text-success text"
									data-ng-click="editRow(collection.containerId)"></i>
								</span>
							</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
								<span> <i class="fa fa-trash-o text-danger-dker text"
									data-ng-click="deleteRow(collection.containerId)"></i>
								</span>
							</security:authorize></td>
					</tr>
				</tbody>
			</table>
			<!-- </div> -->
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
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