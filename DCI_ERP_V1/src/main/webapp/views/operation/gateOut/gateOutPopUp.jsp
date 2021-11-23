<style>
.ui-select-bootstrap .pull-left {
	float: left !important;
}

.ngdialog-content {
	width: 80% !important;
	bottom: 100px !important;
	margin: 0 auto !important;
}
@media screen and (min-width: 676px) {
        .modal-dialog {
          max-width: 1000px; /* New width for default modal */
        }
    }
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope" >
	<div class="panel panel-default panel-default-form " >
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body" style=" width: 1200px">
		
			<form name="quotationForm" class="form-horizontal" novalidate>
			
				

				<br>
				
				<div class="row">
				
				<button class="btn btn-primary" type="button"
										class="btn btn-primary" data-ng-click="uploadContainer()">
		<i class="fa fa-file"></i>Upload Container 
		</button>
									
					<table class="table table-striped b-t b-light" style="width: 100%;">
				
						<tr style="background-color: #dae8f6;">
								
								<th class="width_1 text-center"><label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectall(selection)"><i style="margin-left: -43px;"></i>
							</label> </th>
 							<th colspan=1 class="width_8 text-center">Container Type<span
								style="color: red">*</span></th>
							<th colspan=1 class=" width_9 text-center">Container No<span
								style="color: red">*</span></th>
								<th colspan=1 class=" width_9 text-center">Depot<span
								style="color: red">*</span></th>
								<th colspan=1 class=" width_9 text-center">Source<span
								style="color: red">*</span></th>
								<th colspan=1 class=" width_9 text-center">Reference No<span
								style="color: red">*</span></th>
								<th colspan=1 class=" width_9 text-center">Previous Status Date<span
								style="color: red"></span></th>
							<!--  <th colspan=1 class="width_9 text-center"></th> -->

						</tr>
						<tbody ng-repeat="(trIndex, row) in quotation.popUpDtl"
							ng-controller="quotationtableCtrl">
							<tr >
							<!-- <td class=" width_1"></td> -->
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}">
										<i></i>
								</label></td>
								<td class=" width_8">
								<label id="conType{{trIndex}}" name="conType{{trIndex}}" friendly-name="{{ 'Row' + ($index+1) + '(conType)'}}" >{{row.conType}}</label>
								<!-- <input type="text" class="form-control input-sm" id="conType{{trIndex}}"
										name="conType{{trIndex}}" 
										property="row.conType"
										friendly-name="{{ 'Row' + ($index+1) + '(conType)'}}" ng-model="row.conType"  disabled="true" /> -->
								<!-- <selectivity list="conTypeList"
										property="row.conType" id="conType{{trIndex}}"
										ng-model="row.conType" validation="required"
										name="conType{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(conType)'}}"
										form-name="quotationForm" disabled="true"></selectivity> -->
								</td>
								<td class=" width_10">
								<label id="containerNoNew{{trIndex}}" name="containerNoNew{{trIndex}}" friendly-name="{{ 'Row' + ($index+1) + '(containerNoNew)'}}" >{{row.containerNoNew}}</label>
								<!-- <input type="text" class="form-control input-sm" id="containerNoNew{{trIndex}}"
										name="containerNoNew{{trIndex}}" 
										property="row.containerNoNew"
										friendly-name="{{ 'Row' + ($index+1) + '(containerNoNew)'}}" ng-model="row.containerNoNew"  disabled="true" /> -->
								<!-- <selectivity list="conNoList"
										property="row.containerNo" id="containerNo{{trIndex}}"
										ng-model="row.containerNo" validation="required"
										name="containerNo{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(containerNo)'}}"
										form-name="quotationForm" disabled="true"></selectivity> -->
								</td>
								
								
								<td class=" width_12">
								<label id="depotName{{trIndex}}" name="depotName{{trIndex}}" friendly-name="{{ 'Row' + ($index+1) + '(depotName)'}}" >{{row.depotName}}</label>
								<!-- <input type="text" class="form-control input-sm" id="depotName{{trIndex}}"
										name="depotName{{trIndex}}" 
										property="row.depotName"
										friendly-name="{{ 'Row' + ($index+1) + '(depotName)'}}" ng-model="row.depotName"  disabled="true" /> -->
								<!-- <selectivity list="depotList"
										property="row.depot" id="conType{{trIndex}}"
										ng-model="row.depot" validation="required"
										name="depot{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(depot)'}}"
										form-name="quotationForm" disabled="true"></selectivity> -->
								</td>
								<td class=" width_12">
								<label id="source{{trIndex}}" name="source{{trIndex}}" friendly-name="{{ 'Row' + ($index+1) + '(source)'}}" >{{row.source}}</label>
								<!-- <input type="text" class="form-control input-sm" id="source{{trIndex}}"
										name="source{{trIndex}}" 
										property="row.source"
										friendly-name="{{ 'Row' + ($index+1) + '(source)'}}" ng-model="row.source"  disabled="true" /> -->
								<!-- <selectivity list="depotList"
										property="row.depot" id="conType{{trIndex}}"
										ng-model="row.depot" validation="required"
										name="depot{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(depot)'}}"
										form-name="quotationForm" disabled="true"></selectivity> -->
								</td>
								<td class=" width_9">
								<label id="refNo{{trIndex}}" name="refNo{{trIndex}}" friendly-name="{{ 'Row' + ($index+1) + '(refNo)'}}" >{{row.refNo}}</label>
								<!-- <input type="text" class="form-control input-sm" id="refNo{{trIndex}}"
										name="refNo{{trIndex}}" 
										property="row.refNo"
										friendly-name="{{ 'Row' + ($index+1) + '(refNo)'}}" ng-model="row.refNo"  disabled="true" /> -->
								<!-- <selectivity list="depotList"
										property="row.depot" id="conType{{trIndex}}"
										ng-model="row.depot" validation="required"
										name="depot{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(depot)'}}"
										form-name="quotationForm" disabled="true"></selectivity> -->
								</td>
										<!-- <td class=" width_9"></td> -->
								<td class=" width_9">
								<label id="previousStatusDate{{trIndex}}" name="previousStatusDate{{trIndex}}" friendly-name="{{ 'Row' + ($index+1) + '(previousStatusDate)'}}" >{{row.previousStatusDate}}</label>
										<!-- <input type="text" class="form-control input-sm" id="previousStatusDate{{trIndex}}"
										name="previousStatusDate{{trIndex}}" 
										property="row.previousStatusDate"
										friendly-name="{{ 'Row' + ($index+1) + '(previousStatusDate)'}}" ng-model="row.previousStatusDate"  disabled="true" /> --></td>
								</tr>

							<!-- detail -->

							

						</tbody>
					</table>
						<button class="btn btn-success" type="button" 
											ng-click="popupsubmit(quotation)" id="quotationsave">
											<i class="fa fa-save"></i> OK
						</button>

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
 <script type="text/ng-template" id="uploadContainer">

<div class="modal-header"> File Upload</div>
<div class="row">
	<div class="col-lg-12">
		<div class="col-lg-12">
			<!--<input type="file"  class="fsorm-control btn-primary" id="file" name="file">-->
			<input type="file" class="form-control btn-primary" name="excelfile1" onchange="angular.element(this).scope().uploadFile(this)"  accept=".xls,.xlsx,.xlsm" />
            <a id="sampleDownload" stype="display:none" href="/assets/docs/uploadContainer.xlsx" download="uploadContainer.xlsx"></a>		
       </div>
	</div> 
</div>
<div class="modal-footer">
    <button class="btn btn-info" type="button" ng-click="DownloadSample()">Download Sample</button>
	<button class="btn btn-info" type="button" ng-click="uploadContainer1()">OK</button>
	<button class="btn btn-danger" ng-click="closeThisDialog()">Cancel</button>
</div>
 </script>
 

