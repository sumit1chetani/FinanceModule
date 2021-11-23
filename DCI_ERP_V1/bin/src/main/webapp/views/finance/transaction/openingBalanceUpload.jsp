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
<br>
	<div class="col-sm-12 col-md-3 col-lg-3 ">

							<div class="form-group">
									<label class="col-md-5 control-label">Company <span
										style="color: red;"> *</span></label>
									<div class="col-md-7">
										<selectivity  list="companyList"
											property="openingBalance.companyCode" name="companyCode"
											ng-model="openingBalance.companyCode" validation="required"
											friendly-name="Company" form-name="openingBalanceForm"></selectivity>
									</div>
							</div>
						</div>
					
						<div class="col-sm-12 col-md-6 col-lg-6">
         <a id="Export" stype="display:none"
					href="filePath/OpeningBalance.xlsx" download="OpeningBalance.xlsx"></a>
	
										<button class="btn btn-primary" ng-click="exportExcel()">
											<i class="fa fa-download"> </i>Export Excel
										</button>
										
										<button class="btn btn-success"  type="button"
								ng-click="fileUpload()">
								<i class="fa fa-upload"></i> Upload
					</button>
			

						</div>
<br><br><br>
		<div class="panel-body float-left padding-10" style="width: 100%;">
			<div class="table-responsive" style=" border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;">
						<tr>
							 <th class="sorting width_5" st-sort="servicePartnerCode">Account Head</th>
							<th class="sorting width_5" st-sort="servicePartnerCode">Invoice No</th>
							<th class="sorting width_3" st-sort="servicePartnerName">Invoice Date</th>
							<th class="sorting width_5" st-sort="bcAmount">BC Amount</th>
							<th class="sorting width_4" st-sort="region">TC Amount</th>
						<th class="sorting width_3" st-sort="country">Customer Name</th>
							<th class="sorting width_3" st-sort="branchName">Company Name</th>
					<!-- 		<th class="sorting width_4" st-sort="modifiedBy">Modified By</th>
							<th class="sorting width_3" st-sort="modifiedDate">Modified Date</th> -->
							

							<th class="sorting width_2 text-center table-heading">Action</th>
						</tr>
					</thead>

					</thead>


					<tbody class="dataTables-Main-Body">

						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objItem in displayedCollection">
							  <td class="sorting" >

										<span tooltip="{{objItem.accountHead}}" class="tool-tip-span"
											>{{objItem.accountHead}}</span>
								
									</td>		
							
<td class="sorting" >

										<span tooltip="{{objItem.invoiceNo}}" class="tool-tip-span"
											>{{objItem.invoiceNo}}</span>
								
									</td>
							
							
						<!-- 	<td class="" data-toggle="tooltip"
												title="{{objItem.servicePartnerCode}}">{{objItem.servicePartnerCode}}</td> -->
							<td class="" data-toggle="tooltip"
												title="{{objItem.invoiceDate}}">{{objItem.invoiceDate}}</td>
							<td class="" data-toggle="tooltip"
												title="{{objItem.bcAmount}}">{{objItem.bcAmount}}</td>
							 <td class="" data-toggle="tooltip"
												title="{{objItem.tcAmount}}">{{objItem.tcAmount}}</td>
 							<td class="" data-toggle="tooltip"
												title="{{objItem.customerName}}">{{objItem.customerName}}</td>
							<td class="" data-toggle="tooltip"
												title="{{objItem.companyName}}">{{objItem.companyName}}</td>
							
							

							<td class="td-actions text-center">
									<span class="edit-button  padding-right-5" data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(objItem.transactionid)"
										tooltip="Edit Row"> <i
										class="fa  fa-pencil text-success text"></i>
									</span>
							</td>
						</tr>
					</tbody>


				</table>
			
			<footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
			
			</div>
		</div>
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
  <a class="btn btn-success" href="assets/docs/SampleOpeningBalance .xlsx" class="control-label">Download sample excel file</a>
   <button class="btn btn-info" type="button" ng-click="uploadPIN()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
  </div>
 </script>