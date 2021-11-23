<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<!-- </div> -->
		<style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>
<div class="row" style="margin-top: 15px;">
						          
<!-- 									<button class="btn btn-primary" type="button"  
										class="btn btn-primary" data-ng-click="fileUpload()">
										<i class="fa fa-file"></i>Upload Container Details
									</button>
									<div class="excel"></div>
									 <a id="tbPdfExport" type="display:none" href="assets/docs/SampleContainerBank.xlsx" download="SampleContainerBank.xlsx"></a>
 -->           						
                          <div class="col-md-6 ">
									<button class="btn btn-primary" type="button"  
										class="btn btn-primary" data-ng-click="fileUpload()">
										<i class="fa fa-file"></i>Upload Vendor Details
									</button>
									<div class="excel"></div>
									 <a id="tbPdfExport" type="display:none" href="assets/docs/SampleVendorMaster.xlsx" download="SampleVendorMaster.xlsx"></a>
           						</div>
           						
 
 
           						<button class="btn btn-primary" data-ng-click="exportExcel()">
										<span class="fa fa-file-excel-o"> </span> Export to Excel <a
											id="bookingreport" stype="display:none"
											href="filePath/VendorMaster.xlsx"
											download="VendorMaster.xlsx"></a>
									</button>
           						
           						<!-- 
           						<button class="btn btn-primary" data-ng-click="exportExcel()">
										<span class="fa fa-file-excel-o"> </span> Export to Excel <a
											id="bookingreport" stype="display:none"
											href="filePath/ContainerBank.xlsx"
											download="ContainerBank.xlsx"></a>
									</button> -->
           						
        						 </div>


		<div class="panel-body float-left padding-10" style="width: 100%;">
			<div class="table-responsive" style=" border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;">
						<tr>
						<th class="sorting width_3" st-sort="servicePartnerCode">Vendor Id</th>
						
							<th class="sorting width_2" st-sort="servicePartnerCode">Code</th>
							<th class="sorting width_8" st-sort="servicePartnerName">Name</th>
							<th class="sorting width_5" st-sort="servicePartnerLedgerName">Ledger
								Name</th>
						<!-- 	<th class="sorting width_3" st-sort="region">Region</th> -->
							<th class="sorting width_5" st-sort="region">GST NO</th>

							<th class="sorting width_3" st-sort="cityName">City Code</th>
							<th class="sorting width_3" st-sort="country">Type</th>
							<th class="sorting width_3" st-sort="branchName">Branch</th>
							<th class="sorting width_5" st-sort="branchName">Sales Person</th>
					<!-- 		<th class="sorting width_4" st-sort="modifiedBy">Modified By</th>
							<th class="sorting width_3" st-sort="modifiedDate">Modified Date</th> -->
							<th class="sorting width_3" st-sort="active">Active</th>

							<th class="sorting width_3 text-center table-heading">Action</th>
						</tr>
					</thead>

					</thead>


					<tbody class="dataTables-Main-Body">

						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objItem in displayedCollection">
							
							<td class="" data-toggle="tooltip"
												title="{{objItem.servicePartnerName}}">{{objItem.id}}</td>
<td class="sorting" > <a ng-click="view(objItem.servicePartnerId)"> <security:authorize
										access="hasRole('${form_code}_${view}')"> 

										<span tooltip="{{objItem.servicePartnerCode}}" class="tool-tip-span font-blue"
											>{{objItem.servicePartnerCode}}</span>
									 </security:authorize></a> 
									</td>
							
							
						<!-- 	<td class="" data-toggle="tooltip"
												title="{{objItem.servicePartnerCode}}">{{objItem.servicePartnerCode}}</td> -->
							<td class="" data-toggle="tooltip"
												title="{{objItem.servicePartnerName}}">{{objItem.servicePartnerName}}</td>
							<td class="" data-toggle="tooltip"
												title="{{objItem.servicePartnerLedgerName}}">{{objItem.servicePartnerLedgerName}}</td>
						<!-- 	<td class="" data-toggle="tooltip"
												title="{{objItem.region}}">{{objItem.region}}</td> -->
							<td class="" data-toggle="tooltip"
												title="{{objItem.gSTNNo}}">{{objItem.gSTNNo}}</td>
							<td class="" data-toggle="tooltip"
												title="{{objItem.cityName}}">{{objItem.cityName}}</td>
							<td class="" data-toggle="tooltip"
												title="{{objItem.defaultTypeName}}">{{objItem.defaultTypeName}}</td>
							<td class="" data-toggle="tooltip"
												title="{{objItem.branchName}}">{{objItem.branchName}}</td>
							<td class="" data-toggle="tooltip"
												title="{{objItem.salesPerson}}">{{objItem.salesPerson}}</td>
							<!-- <td class="" data-toggle="tooltip"
												title="{{objItem.modifiedBy}}">{{objItem.modifiedBy}}</td>
							<td class="">{{objItem.modifiedDate}}</td> -->
							<!-- <td class="" data-toggle="tooltip" title="{{objItem.active}}"  >{{objItem.active}}</td> -->
							
							<td class="sorting" data-toggle="tooltip"
												title="False" ng-if="objItem.active=='0'">False</td>
												<td class="sorting" data-toggle="tooltip"
												title="True" ng-if="objItem.active=='1'">True</td>
							
							

							<td class="td-actions text-center"><security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span class="edit-button  padding-right-5" data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(objItem.servicePartnerId)"
										tooltip="Edit Row"> <i
										class="fa  fa-pencil text-success text"></i>
									</span>
								</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
									<span class="delete-button" data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(objItem.servicePartnerId)"
										tooltip="Delete Row"> <i
										class="fa fa-trash-o text-danger-dker tex"></i>
									</span>
								</security:authorize>
								<span class="delete-button" ng-if="objItem.loginId!='Yes'" data-toggle="tooltip" title="Create Login"
										data-ng-click="createLogin(objItem.servicePartnerId)"
										tooltip="Delete Row"> <i
										class="fa fa-key"></i>
									</span></td>
						</tr>
					</tbody>

			 
       
</div>

	</table>
			
			<footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
			<div style="text-align:center;">
          
           <!-- <button id="exportXl" class="btn btn-primary"
            data-ng-click="excel(displayedCollection);"
           type="button">
           <i class="fa fa-print"></i> Export Excel
          </button>
           -->
			</div>
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