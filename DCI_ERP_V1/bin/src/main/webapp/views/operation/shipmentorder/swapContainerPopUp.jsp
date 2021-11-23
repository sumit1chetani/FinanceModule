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
			<form name="shippopupForm" class="form-horizontal" novalidate>
			
				

				<br>
				<div class="row">
					<table  class="table table-striped b-t b-light"  style="width: 100%;">
				
						<tr  style="background-color: #dae8f6;">
					  
								<!-- <th colspan=1 class="width_1 text-center"></th> -->
							 	<th class="width_1 text-center"><label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectall(selection)"><i style="margin-left: -43px;"></i>
							</label> </th>
 							<th colspan=1 class="width_9 text-center">Container Type<span
								style="color: red">*</span></th>
							<th colspan=1 class=" width_9 text-center">Container No<span
								style="color: red">*</span></th>
								<th colspan=1 class=" width_9 text-center">Depot<span
								style="color: red">*</span></th>
								
									<th colspan=1 class=" width_12 text-center">Booking No<span
								style="color: red">*</span></th>
								
									<th colspan=1 class=" width_9 text-center">Shipment No<span
								style="color: red">*</span></th>
							
								
							<!--  <th colspan=1 class="width_9 text-center"></th> -->

						</tr>
						<tbody ng-repeat="(trIndex, row) in shippopup.popUpDtl"
							ng-controller="shippopuptableCtrl">
							<tr >
							<!-- <td class=" width_1"></td> -->
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}">
										<i></i>
								</label></td>
								<td class=" width_9"><selectivity list="conTypeList"
										property="row.conType" id="conType{{trIndex}}"
										ng-model="row.conType" validation="required"
										name="conType{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(conType)'}}"
										form-name="shippopupForm" disabled="true"></selectivity></td>
								<td class=" width_9"><selectivity list="conNoList"
										property="row.containerNo" id="containerNo{{trIndex}}"
										ng-model="row.containerNo" validation="required"
										name="containerNo{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(containerNo)'}}"
										form-name="shippopupForm" disabled="true"></selectivity></td>
								
								
								<td class=" width_9"><selectivity list="depotList"
										property="row.depot" id="conType{{trIndex}}"
										ng-model="row.depot" validation="required"
										name="depot{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(depot)'}}"
										form-name="shippopupForm" disabled="true"></selectivity></td>
										
										
								<td class=" width_12"><selectivity list="bookList"
										property="row.bookNo" id="conType{{trIndex}}"
										ng-model="row.bookNo" validation="required"
										name="bookNo{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(bookNo)'}}"
										form-name="shippopupForm" disabled="true"></selectivity></td>
									
									<td class=" width_9">	<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=15
											     property="row.shipNo" id="shipNo{{trIndex}}"
												data-ng-model="row.shipNo" name="shipNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(shipNo)'}}"  form-name="shippopupForm" disabled="true"/>
										</div>
									</div>	
									</td>
										
						<!-- 		 <td class=" width_9"><selectivity list="shipNoList"
										property="row.shipNo" id="conType{{trIndex}}"
										ng-model="row.shipNo" validation="required"
										name="shipNo{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(shipNo)'}}"
										form-name="shippopupForm"></selectivity></td> -->
										<!-- <td class=" width_9"></td> -->
								</tr>

							<!-- detail -->

							

						</tbody>
					</table>
						<button class="btn btn-success" type="button" 
											ng-click="popupsubmit(shippopup)" id="shippopupsave">
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

