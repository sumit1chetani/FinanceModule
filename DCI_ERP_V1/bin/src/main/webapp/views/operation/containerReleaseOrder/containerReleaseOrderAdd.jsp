<style>
.ui-select-bootstrap .pull-left {
	float: left !important;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 160px !important;
	margin: 0 auto !important;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div style="width: 30%;position: absolute;margin-top: -40px;margin-left: 80%;">
		<label style="color:#e25d5d;float: left;">Quick Links &nbsp;&nbsp; </label>
		 <!--  <select ng-change="quickLinkMethd(joborder.jobId,qukLinkVal)" ng-init="qukLinkVal='Select'" ng-model="qukLinkVal">
		 <option value="Select">Select</option>
		  <option value="HBL">HBL</option>
		  <option value="MBL">MBL</option>
		  <option value="Delivery Order">Delivery Order</option>
		  <option value="Sales Invoice">Sales Invoice</option>
		  <option value="Purchase Invoice">Purchase Invoice</option>
		</select> -->
		 <selectivity style="float: left;" list="qlList" ng-init="qlList='Select'" ng-model="qukLinkVal"
		 property="qukLinkVal"
		name="qukLinkVal" friendly-name="qukLinkVal"></selectivity>
		</div>
		<div class="panel-body">
			<form name="quotationForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>


							<div class="form-group ">
								<label class="col-md-5 control-label">Customer <span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="customerDropList"
										property="quotation.customer" id="customer" name="customer"
										ng-model="quotation.customer" object="customer"
										friendly-name="Customer" validation="required"
										form-name="quotationForm"></selectivity>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">CRO Date<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<ng-bs3-datepicker
										data-ng-model="quotation.croDate" id="croDate" name="croDate"
										property="quotation.croDate"
										friendly-name="{{ 'Row' + ($index+1) + '(croDate)'}}" />
								</div>
							</div>







						</fieldset>
					</div>

					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group ">
								<label class="col-md-5 control-label">Booking No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="bookingNoList"
										property="quotation.bookingNo" id="bookingNo" name="bookingNo"
										ng-model="quotation.bookingNo" object="bookingNo"
										friendly-name="bookingNo" validation="required"
										form-name="quotationForm"></selectivity>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Depot<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="depotList"
										property="quotation.depot" id="depot{{trIndex}}"
										ng-model="quotation.depot" validation="required"
										name="depot{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(depot)'}}"
										form-name="quotationForm"></selectivity>
								</div>
							</div>






							<!-- 		<div class="form-group ">
								<label class="col-md-5 control-label">Cont.Drop Off Mode<span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="dropoffList"
										property="quotation.dropoff" id="dropoff"
										name="dropoff" ng-model="quotation.dropoff"
										object="dropoff" friendly-name="dropoff"
										validation="required" form-name="quotationForm"></selectivity>
										
								</div>
								</div> -->



						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<!-- third column -->

							


						</fieldset>
					</div>


				</div>

				<br>
				<div class="row">
					<table class="table table-striped b-t b-light" style="width: 100%;">
				
						<tr style="background-color: #dae8f6;">
						<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_9 text-center">Container Type<span
								style="color: red">*</span></th>
								<!-- <th colspan=1 class="width_9 text-center">Container Number<span
								style="color: red">*</span></th> -->
							<th colspan=1 class=" width_9 text-center">Quantity<span
								style="color: red">*</span></th>
							 <th colspan=1 class="width_9 text-center"></th>

						</tr>
						<tbody ng-repeat="(trIndex, row) in quotation.quotationDtl"
							ng-controller="quotationtableCtrl">
							<tr >
							<td class=" width_1"></td>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}">
										<i></i>
								</label></td>
								<td class=" width_9"><selectivity list="conTypeList"
										property="row.conType" id="conType{{trIndex}}"
										ng-model="row.conType" validation="required"
										name="conType{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(conType)'}}"
										form-name="quotationForm"></selectivity></td>
										
										<!-- <td class=" width_9"><selectivity list="containerNoList"
										property="row.conNumber" id="conNumber{{trIndex}}"
										ng-model="row.conNumber" validation="required"
										name="conType{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(conType)'}}"
										form-name="quotationForm"></selectivity></td> -->
										
										
								<td class=" width_9"><input type="text"
									class="form-control input-sm text-right" name="quantity"
									property="row.quantity" id="quantity{{trIndex}}"
									ng-model="row.quantity"
									friendly-name="{{ 'Row' + ($index+1) + '(quantity)'}}" /></td>
								<td class=" width_9"></td>
								</tr>

							<!-- detail -->

							

						</tbody>
					</table>

					<button ng-click="addRow()" class="btn btn-sm btn-info"
						ng-disabled="subForm.$invalid" type="button">
						<i class="fa fa-plus"></i>
					</button>
					<button ng-click="removeRow()" class="btn btn-sm btn-danger"
						ng-disabled="userForm{{$index}}.$invalid" type="button">
						<i class="fa  fa-trash-o"></i>
					</button>
				</div>

                 	<div class="row">
					<table class="table table-striped b-t b-light" style="width: 100%;">
				
						<tr style="background-color: #dae8f6;">
						<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_9 text-center">Seal No From</th>
							<th colspan=1 class=" width_9 text-center">Seal No To</th>
							<th colspan=1 class=" width_9 text-center">Count</th>
							 <th colspan=1 class="width_9 text-center"></th>
								
						</tr>
						<tbody ng-repeat="(trIndex, row) in quotation.sealDtl"
							ng-controller="quotationtableCtrl">
							<tr>
							<td class=" width_1"></td>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}">
										<i></i>
								</label></td>
								<td class=" width_9"><input type="text"
									class="form-control input-sm text-right" name="sealFrom"
									property="row.sealFrom" id="sealFrom{{trIndex}}"
									ng-model="row.sealFrom"
									friendly-name="{{ 'Row' + ($index+1) + '(sealFrom)'}}" /></td>
								<td class=" width_9"><input type="text"
									class="form-control input-sm text-right" name="sealTo"
									property="row.sealTo" id="quantity{{trIndex}}"
									ng-model="row.sealTo"
									friendly-name="{{ 'Row' + ($index+1) + '(sealTo)'}}" /></td>
									<td class=" width_9"><input type="text"
									class="form-control input-sm text-right" name="count"
									property="row.count" id="count{{trIndex}}"
									ng-model="row.count"
									friendly-name="{{ 'Row' + ($index+1) + '(count)'}}" /></td>
								<td class=" width_9"></td>
								
										
								</tr>

							<!-- detail -->

							

						</tbody>
					</table>

					<button ng-click="addRow1()" class="btn btn-sm btn-info"
						ng-disabled="subForm.$invalid" type="button">
						<i class="fa fa-plus"></i>
					</button>
					<button ng-click="removeRow1()" class="btn btn-sm btn-danger"
						ng-disabled="userForm{{$index}}.$invalid" type="button">
						<i class="fa  fa-trash-o"></i>
					</button>
				</div>

				<!-- detail -->

				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<button class="btn btn-success" type="button" ng-if="!edit"
											ng-click="submit(quotationForm,quotation)" id="quotationsave">
											<i class="fa fa-save"></i> Save
										</button>
										<button class="btn btn-success" type="button" ng-if="edit"
											ng-click="submitupdate(quotationForm,quotation)">
											<i class="fa fa-save"></i> Update
										</button>
											 <div class="btn btn-primary"  ng-if="edit" data-ng-click="excelexport(containerreleaseCode)">
				
				<span class="fa fa-file-excel-o"> Export to Excel</span>
</div>				
				<a id="emptyExport" stype="display:none"
							href="filePath/ContainerReleaseOrder.xlsx" download="ContainerReleaseOrder.xlsx"></a>
							
										<button class="btn btn-danger" ng-click="cancel()"
											type="button">
											<i class="fa fa-close"></i> Back
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
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

