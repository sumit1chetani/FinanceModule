<style>
.ui-select-bootstrap .pull-left {
	float: left !important;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 100px !important;
	margin: 0 auto !important;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="quotationForm" class="form-horizontal" novalidate>
			
				

				<br>
				<div class="row">
					<table class="table table-striped b-t b-light" style="width: 100%;">
				
						<tr style="background-color: #dae8f6;">
					  
								
								<th class="width_1 text-center"><label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectall(selection)"><i style="margin-left: -43px;"></i>
							</label> </th>
 							<th colspan=1 class="width_9 text-center">Container Type</th>
							<th colspan=1 class=" width_9 text-center">Quantity</th>
<!-- 								<th colspan=1 class=" width_9 text-center">Previous Status Date</th>
 -->							<!--  <th colspan=1 class="width_9 text-center"></th> -->

						</tr>
						<tbody class="dataTables-Main-Body">
						
					 <tbody ng-repeat="(trIndex, row) in bookingData.popUpDtl"
							ng-controller="quotationtableCtrl"> 
							<tr >
							<!-- <td class=" width_1"></td> -->
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}">
										<i></i>
								</label></td>
							
							<td class=" width_9">
										<input type="text" class="form-control input-sm" id="croNumber{{trIndex}}"
										name="cnNo{{trIndex}}" 
										property="row.v"
										friendly-name="{{ 'Row' + ($index+1) + '(cnNo)'}}" ng-model="row.cnNo"  disabled="true" /></td>
									
										<td class=" width_9">
										<input type="text" class="form-control input-sm" id="customer{{trIndex}}"
										name="customer{{trIndex}}" 
										property="row.customer"
										friendly-name="{{ 'Row' + ($index+1) + '(customer)'}}" ng-model="row.customer"  disabled="true" /></td>
								
								
								
							<!-- 	<td class=" width_9">
										<input type="text" class="form-control input-sm" id="pol{{trIndex}}"
										name="pol{{trIndex}}" 
										property="row.previousStatusDate"
										friendly-name="{{ 'Row' + ($index+1) + '(pol)'}}" ng-model="row.pol"  disabled="true" /></td>
								 -->
						<!-- 		
								<td class=" width_9">
										<input type="text" class="form-control input-sm" id="customer{{trIndex}}"
										name="customer{{trIndex}}" 
										property="row.customer"
										friendly-name="{{ 'Row' + ($index+1) + '(customer)'}}" ng-model="row.customer"  disabled="true" /></td>
								
									 -->
								
								
										<!-- <td class=" width_9"></td> -->
								
								</tr>

							<!-- detail -->

							

						</tbody>
					</table>
						<!-- <button class="btn btn-success" type="button" 
											ng-click="popupsubmit(quotation)" id="quotationsave">
											<i class="fa fa-save"></i> OK
						</button> -->

					<!-- <button ng-click="addRow()" class="btn btn-sm btn-info"
						ng-disabled="subForm.$invalid" type="button">
						<i class="fa fa-plus"></i>
					</button>
					<button ng-click="removeRow()" class="btn btn-sm btn-danger"
						ng-disabled="userForm{{$index}}.$invalid" type="button">
						<i class="fa  fa-trash-o"></i>
					</button> -->
				</div>

                 	

				<!-- detail -->

				
			</form>
		</div>
	</div>
</div>
 <script type="text/ng-template" id="fileModal">

<div class="modal-header"> File Upload</div>
<div class="row">
	<div class="col-lg-12">
		<div class="col-lg-12">
			<!--<input type="file"  class="fsorm-control btn-primary" id="file" name="file">-->
			<input type="file" class="form-control btn-primary" name="excelfile1" onchange="angular.element(this).scope().uploadFile(this)"  accept=".xls,.xlsx,.xlsm" />
            <a id="sampleDownload" stype="display:none" href="docs/CRO_Sample.xls" download="CRO_Sample.xls"></a>		
       </div>
	</div> 
</div>
<div class="modal-footer">
    <button class="btn btn-info" type="button" ng-click="DownloadSample()">Download Sample</button>
	<button class="btn btn-info" type="button" ng-click="uploadInvoice()">OK</button>
	<button class="btn btn-danger" ng-click="closeThisDialog()">Cancel</button>
</div>
 </script>

